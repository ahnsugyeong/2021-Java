class BasicRect{
	int width, height;
	String name;
	
	// BasicRect(){}
	
	void print()
	{
		System.out.println("[RECT:"+name+"] width="+width+", height="+height);
	}
	
	boolean isBig(BasicCircle c) {
		int area = width*height;
		return (area > c.getArea());
		
	}
	
	
}

// 반드시 먼저 radius와 name 값을 입력할 것
class BasicCircle {
	double radius;
	String name;
/*		
	BasicCircle(){							// default constructor
		radius = 1;
		name = "이름없음";
	}
*/	
	
	BasicCircle(double r){
		this(r, "이름없음");	
		name += "ㅎㅎ";
//		radius = r;
//		name = "이름없음";
	}
	BasicCircle(double r, String n)	{		// constructor overloading
		
		if(r<0) r = -r;
		if(r>200) r = 200;
		radius= r;
		name = n;
	}
	BasicCircle(BasicCircle in)
	{
		radius = in.radius;
		name = in.name;
	}
	
	void print() {
		
		System.out.println("[CIRCLE:"+name+"] r="+radius);
	}
	double getArea() {
		return radius*radius*3.141592;
	}
	
	void func() {
		BasicRect rect = new BasicRect();
		rect.width = 10;
		rect.height = 20;
		if(rect.isBig(this))
			System.out.println("기준 사각형이 더 큽니다");
		else 
			System.out.println("기준 사각형보다 더 큰 원입니다");
	}
	
}


class MyWiFi{
	
	MyWiFi(){
		Connect();
	}
	
	private void Connect() {};
	void send() {};
	void recieve() {};
	
}

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCircle a = new BasicCircle(10, "피자");
		BasicCircle b = new BasicCircle(-5, "도넛");
		
//		a.radius = 10.0;
//		a.name = "피자";
		a.print();
//		b.radius = -5.0f;
//		b.name = "도넛";
		b.print();
		BasicRect c = new BasicRect();
		c.width = 3;
		c.height = 4;
		c.name = "지우개";
		c.print();
	
		BasicCircle d = new BasicCircle(-20);
		d.print();
		//d.BasicCircle();
		
		BasicCircle e = d;
		e.print();
		e.radius *=10;
		d.print();
		
		BasicCircle f = new BasicCircle(d);
		f.print();

		
		// primitives : int float double long char byte 
		// references : class, array
	}

}