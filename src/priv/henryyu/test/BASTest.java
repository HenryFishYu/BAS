package priv.henryyu.test;

import priv.henryyu.bas.BAS;
import priv.henryyu.bas.Limit;

/**
 * XXX class
 * 
 * @author HenryYu
 * @date 2017年12月27日下午3:37:22
 * @version 1.0.0
 */
public class BASTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long beginTime=System.currentTimeMillis();
		BAS bas=new BAS(0.05, 1, 0.95,2,2,2);
		double x=bas.approach(10, 100000000);
		System.out.println(x+" "+bas.getY(x));
		//System.out.println(System.currentTimeMillis()-beginTime);
	}

}

