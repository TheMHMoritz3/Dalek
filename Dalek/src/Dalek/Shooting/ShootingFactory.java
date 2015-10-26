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
    public ShootingFactory()
    {
        UsedTactic=Tactics.LinearTargeting;
        TargetingLinear = new LinearTargeting();
        //TargetingCircular = new CircularTargeting();
        TargetingLinear.setRobotDimentions(RobotWidth, RobotHigh);
        //Statistics = new StatisticsFactory();
        BulletPower = 1;
    }
	
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
	
    public void calculateGunPower(double myHealth)
    {
        BulletPower=Math.min(myHealth, BulletPower);
        TargetingLinear.setBulletPower(BulletPower);
        //TargetingCircular.setBulletPower(BulletPower);
    }
	
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
	
    public void setDataOfEvent(double distance, double headingRadinas, double robotVelocety, double bearingRadians)
    {
        TargetingLinear.setDataOfEvent(distance, headingRadinas, robotVelocety, bearingRadians);
        //TargetingCircular.setDataOfEvent(distance, headingRadinas, robotVelocety, bearingRadians);
    }

    public void setMyPosition(double MyPosX, double MyPosY)
    {
        TargetingLinear.setMyPosition(MyPosX, MyPosY);
        //TargetingCircular.setOwnXAndY(MyPosX, MyPosY);
    }

    public void setSizeOfBattlefield(double XSize, double YSize)
    {
        TargetingLinear.setSizeOfBattlefield(XSize, YSize);
        //TargetingCircular.setBattleFieldWidthAndHeight(XSize, YSize);
    }

    public void setMyUtilitys(double myGunHeadingRadiance, double myHeadingRadians)
    {
        TargetingLinear.setMyUtilitys(myGunHeadingRadiance, myHeadingRadians);
        //TargetingCircular.setMyUtilitys(myHeadingRadians,myGunHeadingRadiance);
    }

    public double getBulletPower()
    {
        return BulletPower;
    }

    public void addMissedBullet()
    {
        //Statistics.addMissedBulletToBulletStatistics();
    }

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
