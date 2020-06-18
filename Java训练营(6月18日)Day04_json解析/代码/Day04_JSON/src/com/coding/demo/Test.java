package com.coding.demo;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "张三";
		p1.age = 28;
		p1.sex = "男性";
		p1.salary = 30000.88;
		
		Car car = new Car();
		car.brand = "雪佛兰";
		car.model = "科迈罗";
		car.color = "黄色";
		
		p1.car = car;
		
		
		Book b1 = new Book();
		b1.bookName = "十万个为啥";
		b1.author = "王二狗";
		b1.price = 35.8;
		
		Book b2 = new Book();
		b2.bookName = "西游记";
		b2.author = "吴承恩";
		b2.price = 203.6;
		p1.books.add(b1);
		p1.books.add(b2);
	}

}
