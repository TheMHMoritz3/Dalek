/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dalek.Shooting;

/**
 * @date 24.10.2015
 * @author Moritz
 */
public class ShootingFactory {
    /**
     * CTor
     */
    public ShootingFactory()
    {
        UsedTactic=Tactics.LinearTargeting;
        TargetingLinear = new LinearTargeting();
        //TargetingCircular = new CircularTargeting();
        TargetingLinear.setRobotDimentions(RobotWidth, RobotHigh);
        //Statistics = new StatisticsFactory();
        BulletPower = 1;
    }
    
    /**
     * Is called on every shoot and decides about a tactic change.
     */
    public void decideAboutTactics()
    {
        /*if(Statistics.getBulletStatisticsBulletCount()>5)
        {
            Statistics.calculateBulletStatitics();
            if(Statistics.getBulletStatisticsStatisticsHitBulletsDecimal()<(0.5))
            {
                changeTactics();
            }
        }*/
    }
    
    /**
     * Changes the Tactics with the support of the StaticsticsFactory.
     */
    private void changeTactics()
    {
        /*if(Statistics.getEnemyMovementFromMovementStatistics()==EnemyMovementTactics.LineMovement)
        {
            switch(Statistics.getEnemyMovementFromMovementStatistics())
            {
            case LineMovement:
                StatisticsSaver.HitRateLinearTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case CircularMovement:
                StatisticsSaver.HitRateCircularTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case WaveSurfing:
                StatisticsSaver.HitRateWaveSurfing=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            }
            UsedTactic=Tactics.LinearTargeting;
        }

        if(Statistics.getEnemyMovementFromMovementStatistics()==EnemyMovementTactics.CircularMovement)
        {
            switch(Statistics.getEnemyMovementFromMovementStatistics())
            {
            case LineMovement:
                StatisticsSaver.HitRateLinearTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case CircularMovement:
                StatisticsSaver.HitRateCircularTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case WaveSurfing:
                StatisticsSaver.HitRateWaveSurfing=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            }
            UsedTactic=Tactics.CircularTargeting;
        }

        if(Statistics.getEnemyMovementFromMovementStatistics()==EnemyMovementTactics.WaveSurfing)
        {
            switch(Statistics.getEnemyMovementFromMovementStatistics())
            {
            case LineMovement:
                StatisticsSaver.HitRateLinearTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case CircularMovement:
                StatisticsSaver.HitRateCircularTargeting=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            case WaveSurfing:
                StatisticsSaver.HitRateWaveSurfing=Statistics.getBulletStatisticsStatisticsHitBulletsDecimal();
                break;
            }
            UsedTactic=Tactics.KillWavesurfer;
        }*/

        //Statistics.resetBulletCount();
    }
    
    /**
     * Calculates the gunpower.
     * @param myHealth The Health of the Robot.
     */
    public void calculateGunPower(double myHealth)
    {
        BulletPower=Math.min(myHealth, BulletPower);
        TargetingLinear.setBulletPower(BulletPower);
        //TargetingCircular.setBulletPower(BulletPower);
    }
    
    /**
     * Returns the value in which angle the gun schould turn.
     * This method dicides with the help of the Tactics enum.
     * @return Angle of the gun.
     */
    public double turnGunTo()
    {
        switch(UsedTactic)
        {
        case LinearTargeting:
            TargetingLinear.calculateEnemysPoition();
            //Statistics.addEnemyPositionToMovementStatistic(TargetingLinear.getEnemyX(), TargetingLinear.getEnemyY());
            return TargetingLinear.turnCanon();
        case CircularTargeting:
            //TargetingCircular.calculateEnemysPositon();
            //Statistics.addEnemyPositionToMovementStatistic(TargetingLinear.getEnemyX(), TargetingLinear.getEnemyY());
            //return TargetingCircular.calculateAiming();
            break;
        case KillWavesurfer:
            //TODO Saarli Add KillWaveServer
            break;
        }
        return 0.0;
    }
    
    /**
     * Is need to be set. Sets all the varibles of the RobotScannedEvent that are needed.
     * @param distance Distance to the enemy.
     * @param headingRadinas Heading of the enemy in Radians.
     * @param robotVelocety Enemys Velocety
     * @param bearingRadians Bearing of the enemy in Radians.
     */
    public void setDataOfEvent(double distance, double headingRadinas, double robotVelocety, double bearingRadians)
    {
        TargetingLinear.setDataOfEvent(distance, headingRadinas, robotVelocety, bearingRadians);
        //TargetingCircular.setDataOfEvent(distance, headingRadinas, robotVelocety, bearingRadians);
    }
    
    /**
     * Need to be set. Sets Daleks Position in all Targeting classes.
     * @param MyPosX Daleks Position X
     * @param MyPosY Daleks Position Y
     */
    public void setMyPosition(double MyPosX, double MyPosY)
    {
        TargetingLinear.setMyPosition(MyPosX, MyPosY);
        //TargetingCircular.setOwnXAndY(MyPosX, MyPosY);
    }
    
    /**
     * Is need to be set. Sets the size of the Battlefield
     * @param XSize Maximum X-Value of the Battlefield
     * @param YSize Maximum Y-Value of the Battlefield
     */
    public void setSizeOfBattlefield(double XSize, double YSize)
    {
        TargetingLinear.setSizeOfBattlefield(XSize, YSize);
        //TargetingCircular.setBattleFieldWidthAndHeight(XSize, YSize);
    }
    
    /**
     * Is need to be set. Sets the Utilitys of the Dalek.
     * @param myGunHeadingRadiance Daleks Gun Heading Radians.
     * @param myHeadingRadians Daleks Heading Radians.
     */
    public void setMyUtilitys(double myGunHeadingRadiance, double myHeadingRadians)
    {
        TargetingLinear.setMyUtilitys(myGunHeadingRadiance, myHeadingRadians);
        //TargetingCircular.setMyUtilitys(myHeadingRadians,myGunHeadingRadiance);
    }
    
    /**
     * Returns the BulletPower.
     * @return Bullet Power
     */
    public double getBulletPower()
    {
        return BulletPower;
    }
    
    /**
     * Adds a Missed Bullet. Will be Replaced.
     */
    public void addMissedBullet()
    {
        //Statistics.addMissedBulletToBulletStatistics();
    }
    
    /**
     * Adds a Hit Bullet. Will be Replaced.
     */
    public void addHitBullet()
    {
        //Statistics.addHitBulletToBulletStatistics();
    }

    final double RobotWidth = 16, RobotHigh = 16;
    double BulletPower;
    private Tactics UsedTactic;
    private LinearTargeting TargetingLinear;
    //private CircularTargeting TargetingCircular;

    //private StatisticsFactory Statistics;
}
