package priv.henryyu.bas; 
/**
 * A Simple BAS class
 * 
 * @author HenryYu
 * @date 2017年12月27日下午2:56:42
 * @version 1.2.0
 * Last Update 1/2/2018 11:48
 */
public abstract class BAS {
	private double defaultX;		//param X
	private double x;				//result X
	private double y;				
	private double accuracy;
	private boolean mutationalX;
	
	public BAS(double accuracy,double defaultX) {
		this.accuracy=accuracy;
		this.defaultX=defaultX;
		mutationalX=true;
	}
	
	public double getMin(double times) {
		x=defaultX;
		for(int i=0;i<times;i++) {
			
			double leftY=getY(x-accuracy/2);
			double rightY=getY(x+accuracy/2);
			if (mutationalX) {
				double tempX = getRandomDouble();
				if (getY(tempX) <= Math.min(leftY, rightY)) {
					x = tempX;
					continue;
				}
			}
				x+=accuracy*(sigmoid(leftY-rightY)-0.5)*2;		
		}
		return x;
	}
	
	public double getMax(double times) {
		x=defaultX;
		for(int i=0;i<times;i++) {
			double leftY=getY(x-accuracy/2);
			double rightY=getY(x+accuracy/2);
			if (mutationalX) {
				double tempX = getRandomDouble();
				if (getY(tempX) >= Math.max(leftY, rightY)) {
					x = tempX;
					continue;
				}
			}
				x-=accuracy*(sigmoid(leftY-rightY)-0.5)*2;
		}
		return x;
	}
	
	public double approach(Limit limit,double times) {
		if(limit==Limit.MAX) {
			getMax(times);
		}
		if(limit==Limit.MIN) {
			getMin(times);
		}
		return x;
	}
	
	public double approach(double targetNumber,double times) {
		x=defaultX;
		for(int i=0;i<times;i++) {
			double leftAbs=Math.abs(getY(x-accuracy/2)-targetNumber);
			double rightAbs=Math.abs(getY(x+accuracy/2)-targetNumber);
			if (mutationalX) {
				double tempX = getRandomDouble();
				if (Math.abs(getY(tempX) - targetNumber) < Math.min(leftAbs, rightAbs)) {
					x = tempX;
					continue;
				}
			}
				x+=accuracy*(sigmoid(leftAbs-rightAbs)-0.5)*2;		
		}
		return x;
	}
	
	public abstract double getY(double x);
	
	public double sigmoid(double param) {
		return ((double)(1))/(1+Math.exp(-param));
	}
	
	public double getRandomDouble() {
		return Math.random()*Double.MAX_VALUE*(Math.random()>0.5?1:-1);
	}
}
 

