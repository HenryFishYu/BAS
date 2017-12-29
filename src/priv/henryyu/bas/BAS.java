package priv.henryyu.bas; 
/**
 * A simple BAS class
 * 
 * @author HenryYu
 * @date 2017年12月27日下午2:56:42
 * @version 1.0.0
 */
public class BAS {
	private double eta; 			//should be larger than 0 and smaller than 1
	private double defaultX;		//param X
	private double x;				//result X
	private double leftX;
	private double rightX;
	private double defaultStep;    //move step(Weight)
	private double step;
	private double y;				
	private double accuracy;
	private double a;
	private double b;
	private double c;
	
	public BAS(double accuracy,double defaultX,double eta,double a,double b,double c) {
		defaultStep=1;
		this.accuracy=accuracy;
		this.defaultX=defaultX;
		this.eta=eta;
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void setStep(double step) {
		this.step=step;
	}
	
	public double getMin(double times) {
		step=defaultStep;
		x=defaultX;
		for(int i=0;i<times;i++) {
			if(getY(x-accuracy/2)>getY(x+accuracy/2)) {
				x+=accuracy*step;		
			}else {
				x-=accuracy*step;
			}
			step=step*eta;
		}
		return x;
	}
	
	public double getMax(double times) {
		step=defaultStep;
		x=defaultX;
		for(int i=0;i<times;i++) {
			if(getY(x-accuracy/2)>getY(x+accuracy/2)) {
				x-=accuracy*step;		
			}else {
				x+=accuracy*step;
			}
			step=step*eta;
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
		return 0;
	}
	
	public double approach(double targetNumber,double times) {
		step=defaultStep;
		x=defaultX;
		for(int i=0;i<times;i++) {
			if(Math.abs(getY(x-accuracy/2)-targetNumber)>Math.abs(getY(x+accuracy/2)-targetNumber)) {
				x+=accuracy*step;		
			}else {
				x-=accuracy*step;
			}
			step=step*eta;
		}
		return x;
	}
	
	public double getY(double x) {
		return a*Math.pow(x, 2)+b*x+c;
	}
}
 

