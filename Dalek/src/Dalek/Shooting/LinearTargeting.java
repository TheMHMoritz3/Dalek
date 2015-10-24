/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dalek.Shooting;

import robocode.Rules;

/**
 * @date 24.10.2015
 * @author Moritz
 */
public class LinearTargeting {
    /**
     * CTor
     */
    public LinearTargeting()
    {
	MyPositionX=0;
	MyPositionY=0;
	BulletPower=0;
	BulletVelocety=0;
	MyHeadingRadians=0;
	MyGunHeadingRadiance=0;
		
	Theta=0;
	
	EnemyHeading=0;
	EnemyPositionX=0;
	EnemyPositionY=0;
	AbsoluteBearing=0;
	EnemyVelocety=0;
	Distance=0;
	HeadingRadinas=0;
	RobotVelocety=0;
	BearingRadians=0;
    }
	
    /**
     * Sets the Event Data. ONLY the EVENT DATA!
     * @param distance Distance of the Enemy
     * @param headingRadinas Heading of the Enemy in RAD
     * @param robotVelocety Velocity of the Enemy
     * @param bearingRadians Bearing of the Enemy in RAD
     */
    public void setDataOfEvent(double distance, double headingRadinas, double robotVelocety, double bearingRadians)
    {
	Distance = distance;
	HeadingRadinas = headingRadinas;
	RobotVelocety = robotVelocety;
	BearingRadians = bearingRadians;
    }
	
    /**
     * Sets the Position of Myselph
     * @param MyPosX
     * @param MyPosY
     */
    public void setMyPosition(double MyPosX, double MyPosY)
    {
	MyPositionX = MyPosX;
	MyPositionY = MyPosY;
    }
	
    /**
     * Sets the Size of the Battlefield in an Array
     * @param XSize
     * @param YSize
     */
    public void setSizeOfBattlefield(double XSize, double YSize)
    {
	BattleFieldSize = new double[2];
	BattleFieldSize[0] = XSize;
	BattleFieldSize[1] = YSize;
    }
	
    /**
     * Is setting all the Heading
     * @param myGunHeadingRadiance
     * @param myHeadingRadians
     */
    public void setMyUtilitys(double myGunHeadingRadiance, double myHeadingRadians)
    {
	MyGunHeadingRadiance = myGunHeadingRadiance;
	MyHeadingRadians = myHeadingRadians;
    }
	
    /**
     * Sets the Bulletpower and the Bulletspeed
     * @param bulletPower
     */
    public void setBulletPower(double bulletPower)
    {
	BulletPower = bulletPower;
	BulletVelocety = Rules.getBulletSpeed(BulletPower);
    }
	
    /**
     * Sets the Size of the Robot
     * @param robotX
     * @param robotY
     */
    public void setRobotDimentions(double robotX,double robotY)
    {
	RobotX = robotX;
	RobotY = robotY;
    }
	
    /**
     * Calculates the Enemys Position
     */
    public void calculateEnemysPoition()
    {
	AbsoluteBearing = MyHeadingRadians + BearingRadians;
        
        EnemyPositionX = MyPositionX + Distance*Math.sin(AbsoluteBearing);
	EnemyPositionY = MyPositionY + Distance*Math.cos(AbsoluteBearing);
	        
	        
	// These constants make calculating the quadratic coefficients below easier
	double A = (EnemyPositionX - MyPositionX)/BulletVelocety;
	double B = RobotVelocety/BulletVelocety*Math.sin(HeadingRadinas);
	double C = (EnemyPositionY - MyPositionY)/BulletVelocety;
	double D = RobotVelocety/BulletVelocety*Math.cos(HeadingRadinas);
	
	// Quadratic coefficients: a*(1/t)^2 + b*(1/t) + c = 0
	double a = A*A + C*C;
	double b = 2*(A*B + C*D);
	double c = (B*B + D*D - 1);
	double discrim = b*b - 4*a*c;
	if (discrim >= 0) {
	    // Reciprocal of quadratic formula
	    double t1 = 2*a/(-b - Math.sqrt(discrim));
	    double t2 = 2*a/(-b + Math.sqrt(discrim));
	    double t = Math.min(t1, t2) >= 0 ? Math.min(t1, t2) : Math.max(t1, t2);
	    // Assume enemy stops at walls
	    EndX = limit(EnemyPositionX + RobotVelocety*t*Math.sin(HeadingRadinas),RobotX/2, BattleFieldSize[0] - RobotX/2);
	    EndY = limit(EnemyPositionY + RobotVelocety*t*Math.cos(HeadingRadinas),RobotY/2, BattleFieldSize[1] - RobotY/2);
        }
    }
	
    private double limit(double value, double min, double max) {
        return Math.min(max, Math.max(min, value));
    }
	
    /**
     * Returns the Guns Positon
     * @return Position of the Gun
     */
    public double turnCanon()
    {
	return robocode.util.Utils.normalRelativeAngle(Math.atan2(EndX - MyPositionX, EndY - MyPositionY) - MyGunHeadingRadiance);
    }
	
    /**
     * Return the Enemys-X-Position
     * @return Enemys-X-Position
     */
    public double getEnemyX()
    {
	return EnemyPositionX;
    }
	
    /**
     * Returns the Enemys-Y-Positoin
     * @return Enemys-Y-Positoin
     */
    public double getEnemyY()
    {
	return EnemyPositionY;
    }

    /**
     * Returns the Enemys Velocity
     * @return Enemys Velocity
     */
    public double getEneyVelocety()
    {
	return EnemyVelocety;
    }
	
    /**
     * Returns the Enemys Velocity
     * @return Enemys Velocity
     */
    public double getEnemyHeading()
    {
	return EnemyHeading;
    }
	
    /**
     * Returns the Bullet Power
     * @return Bullet Power
     */
    public double getBulletPower()
    {
	return BulletPower;
    }
	
    /**
     * Returns Theta
     * @return Theta
     */
    public double getTheta()
    {
	return Theta;
    }
    
    private double MyPositionX;
    private double MyPositionY;
    private double BulletPower;
    private double BulletVelocety;
    private double MyHeadingRadians;
    private double MyGunHeadingRadiance;
    
    private double Theta;
    
    private double EnemyHeading;
    private double EnemyPositionX;
    private double EnemyPositionY;
    private double AbsoluteBearing;
    private double EnemyVelocety;
    private double Distance;
    private double HeadingRadinas;
    private double RobotVelocety;
    private double BearingRadians;
    
    private double[] BattleFieldSize;
    private double RobotY,RobotX;
    private double EndX, EndY;
}
