package priv.henryyu.bas; 
/**
 * A simple BAS class
 * 
 * @author HenryYu
 * @date 2017年12月27日下午2:56:42
 * @version 1.1.0
 */
public class BAS {
	private double defaultX;		//param X
	private double x;				//result X
	private double leftX;
	private double rightX;
	private double y;				
	private double accuracy;
	private double a;
	private double b;
	private double c;
	
	public BAS(double accuracy,double defaultX,double a,double b,double c) {
		this.accuracy=accuracy;
		this.defaultX=defaultX;
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public double getMin(double times) {
		x=defaultX;
		for(int i=0;i<times;i++) {
			double leftY=getY(x-accuracy/2);
			double rightY=getY(x+accuracy/2);
				x+=accuracy*(sigmoid(leftY-rightY)-0.5)*2;		
		}
		return x;
	}
	
	public double getMax(double times) {
		x=defaultX;
		for(int i=0;i<times;i++) {
			double leftY=getY(x-accuracy/2);
			double rightY=getY(x+accuracy/2);
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
				x+=accuracy*(sigmoid(leftAbs-rightAbs)-0.5)*2;		
		}
		return x;
	}
	
	public double getY(double x) {
		return a*Math.pow(x, 2)+b*x+c;
	}
	
	public double sigmoid(double param) {
		return ((double)(1))/(1+Math.pow(Math.E, -param));
	}
}
 

