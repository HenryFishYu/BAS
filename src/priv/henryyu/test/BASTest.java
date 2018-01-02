package priv.henryyu.test;

import priv.henryyu.bas.BAS;
import priv.henryyu.bas.Limit;

/**
 * BasExample class
 * 
 * @author HenryYu
 * @date 2017年12月27日下午3:37:22
 * @version 1.2.0
 * Last Update 1/2/2018 11:48
 */
public class BASTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long beginTime=System.currentTimeMillis();
		BAS bas=new BAS(0.05, 1) {

			@Override
			public double getY(double x) {
				return 2*Math.pow(x, 3)-3*Math.pow(x, 2)+5*x+17;
			}
			
		};
		double x=bas.approach(1000,1000000);
		System.out.println(x+" "+bas.getY(x));
		//System.out.println(System.currentTimeMillis()-beginTime);
	}

}

