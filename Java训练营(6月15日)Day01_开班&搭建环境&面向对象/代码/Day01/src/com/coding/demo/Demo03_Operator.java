package com.coding.demo;

public class Demo03_Operator {

	public static void main(String[] args) {
		/*
		 * 算术运算符：+，-，*，/,%,++,--
		 *  /，除法，取商
		 *  %，取余，取模
		 *  
		 *  ++,自增1
		 *  --，自减1
		 */
		int a = 10;
		int b = 3;
		int div = a / b;
		int mod = a % b;
		System.out.println(div);//3
		System.out.println(mod);//1
		
		
		b++;//给b自增1 相当于b = b+1;
		System.out.println(b);
		a--;//给a自减1
		System.out.println(a);
		
		/*
		 * 2.赋值运算符：=，+=，-=，*=，/=,%=
		 * 
		 * a += b,相当于a =a + b
		 * a -= b,相当于a =a -b
		 */
		int i = 3;//将=左侧数值3，赋值给=左侧的变量i
		
		i += 2;//相当于i = i + 2
		System.out.println(i);
		
		/*
		 * 3.关系运算符：比较两个数的关系，计算结果是boolean：true，false
		 * >,<,>=,<=,==,!=
		 */
		int x = 3;
		int y = 2;
		boolean res1 = x > y;
		System.out.println(res1);
		boolean res2 = x == y;//比较x和y是否相等，结果赋值给res2
		System.out.println(res2);
		
		boolean res3 = x != y;
		System.out.println(res3);//true
		
		
		
		/*
		 * 逻辑运算符：
		 * &&，短路与
		 * 		运算规则：如果操作数都为true，结果才为true，有一个为false，结果就为false
		 * 			一假则假，全真才真
		 * ||，短路或
		 * 		运算规则：如果操作数都是false，结果才为false，有一个为true，结果就为true
		 * 			一真则真，全假才假
		 * !，取非，就是取反
		 */
		boolean bb1 = true;
		boolean bb2 = false;
		
		boolean res4 = bb1 && bb2;//false
		System.out.println(res4);
		
		boolean res5 = bb1 || bb2;
		System.out.println(res5);
		
		System.out.println(!bb1);//取反
	}

}
