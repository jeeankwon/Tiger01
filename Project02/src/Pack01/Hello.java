// 잡 문법: 2차원 배열, 열거형
// 결국 자바는 클래스 제작이다.

package Pack01;

import java.util.Iterator;
import java.util.Scanner;

// https://github.com/jeeankwon/Tiger01

/*
public class Hello {
	public static void main(String[] args) {
		
	}
}
*/

//ex130
// ex1) 
// https://gluonhq.com/products/javafx/

import javafx.application.Application;
import javafx.stage.Stage;

public class Hello extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(2);
		primaryStage.show();
		System.out.println(3);
	}
	public static void main(String[] args) throws Exception{
		System.out.println(1);
		launch();
		System.out.println(4);
	}
}

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server Start");
		try {
			ServerSocket ss = new ServerSocket();			
			ss.bind(new InetSocketAddress("localhost", 5001));
			System.out.println("기다리고 있음");
			ss.accept(); 
			System.out.println("누군가 접속됨");
			
			(new Scanner( System.in )).nextInt();
			System.out.println("서버 종료됨.");
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Client Start");
		
		try {
			System.out.println("접속하기 일보직전");
			(new Scanner( System.in )).nextInt();			
			Socket cs = new Socket();
			cs.connect(new InetSocketAddress("localhost", 5001));
			
			(new Scanner( System.in )).nextInt();
			System.out.println("클라이언트 종료됨.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}



//ex129 Git 연동 설명

/*
//ex128

public class Hello {
	public static void main(String[] args) {
		z
	}
}
*/

/*
//ex127

interface A{
	void f1();
}

class B implements A{
	public void f1() {
		System.out.println(1);
	}
}

public class Hello {
	public static void main(String[] args) {
		// 인터페이스 상속을 받아서 구현
		B b1 = new B();
		b1.f1();
		
		// 익명 클래스
		A b2 = new A() {
			public void f1() {
				System.out.println(2);
			}
		};
		b2.f1();
	}
}
*/

/*

//ex125 - 다시

class Tiger extends Thread{
	public void run() {
		System.out.println("Tiger start");
		int num = (new Scanner(System.in)).nextInt();
		System.out.println("Tiger end");
	}
}

class Lion extends Thread{
	public void run() {
		System.out.println("Lion start");
		int num = (new Scanner(System.in)).nextInt();
		System.out.println("Lion end");
	}
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Tiger();
		Thread l = new Lion();
		t.start();
		l.start();
		
		int num = (new Scanner(System.in)).nextInt();
		System.out.println("main end");
	}
}
*/

/*
//ex124 - 다시

public class Hello {
	public static void main(String[] args) {
		//사용방법1
//		Scanner input = new Scanner( System.in );
//		System.out.println("숫자를 입력하세요"); // 콘솔창에 직접 입력하고 엔터.
//		int num = input.nextInt();
//		System.out.println("입력된 숫자는" + num); 
		
		//사용방법2
		System.out.println("숫자를 입력하세요");
		int num = (new Scanner(System.in)).nextInt();
		System.out.println("입력된 숫자는" + num + "입니다.");
		}
	}
}
*/

/*
//ex123
class Tiger extends Thread{
	
	// run이 스레드 코드이다.
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println( "호랑이" + i );
			try { Thread.sleep(0);} catch(Exception e) {}
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		
		// 부자 관계
		Thread t = new Tiger();
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("코끼리" + i);
			try { Thread.sleep(0);} catch(Exception e) {}
		}
		System.out.println("main end");
	}
}
*/

/*
//ex122 : 스레드 생성 방법
class Tiger extends Thread{
	
	// run이 스레드 코드이다.
	public void run() {
		System.out.println("Thread Start");
		
		System.out.println("Thread End");
	}
}

public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		
		// 부자 관계
		Thread t = new Tiger();
		// 스레드를 발동시킨다.
		// start함수는 반드시 내부적으로 run이라는 함수를 호출.
		t.start();
		
		// try { Thread.sleep(1000);} catch (Exception e) {}

		System.out.println("main end");
	}
}
*/

// 21/03/24

/*
//ex121: 데코레이션 패턴
class A{
	int a = 10;
	int f1() {
		System.out.println(1);
		return a;
	}
}

class B extends A{
	int a = 20;
	A tiger;
	B( A tiger ){
		this.tiger = tiger;
	}
	int f1() {
		System.out.println(2);
		return tiger.f1() + a;
		// return 10 + 20; : 30을 리턴함.
	}
}

class C extends A{
	int a = 30;
	A tiger;
	C( A tiger ){
		this.tiger = tiger;
	}
	int f1() {
		System.out.println(3);
		return tiger.f1() + a;
	}
}

class D extends A{
	int a = 40;
	A tiger;
	D( A tiger ){
		this.tiger = tiger;
	}
	int f1() {
		System.out.println(4);
		return tiger.f1() + a;
	}
}


public class Hello {
	public static void main(String[] args) {
		A aa = new A(); // aa객체가 생김.
		aa = new B(aa); // aa객체가 생기는 데 내부적으로 이전 객체를 가진다.
		aa = new C(aa);
		aa = new D(aa);
		System.out.println(aa.f1());
		
//		class AA{
//			
//		}
//		class BB extends AA{
//			
//		}
//		AA p = new AA();
//		p = new BB();
//		AA s = new BB();
		
	}
}
*/

/*
//ex120: 싱글톤 패턴
class Apple{
	// 생성자 함수 앞에 private을 걸었다.
	// 생성자함수는 객체가 생성될 때 자동 호출된다.
	private Apple() {
		
	}
	// 밑에 코드가 객체가 생성되었습니까? 객체는 new를 만나야 생성됨.
	// 변수가 선언된것뿐.
	static private Apple myApple = null;
	
	static Apple getInstance() { // Instance=객체
		//System.out.println(1);
		// 이 때 객체가 생성되었다.
		if( myApple == null ) {
			System.out.println(1);
			myApple = new Apple();		
		}
		
		return myApple;
	}
	void f2() {
		//System.out.println("f2");
	}
}

public class Hello {
	public static void main(String[] args) {
		// Apple클래스는 객체를 생성시킬 수 있는 방법이 없다.
		// Apple a = new Apple();
		Apple app = Apple.getInstance();
		app.f2();
		
		Apple bpp = Apple.getInstance();
		bpp.f2();
		System.out.println(app);
		System.out.println(bpp);
		
		// 싱글톤 패턴을 하고 있다.
		// 싱글: 1개라는 뜻
		// 프로그램에서 객체를 딱 1개만 생성이 되도록
		// 프로그램을 작성하는 방법.
	}
}
*/

/*
//ex119
class Tiger{
	private int a = 10;
	public int b = 20;
	
	private void f1() {
		a = 10; // 본인 클래스 내부에서만 쓸 수 있음.
		b = 20; // 온 동네에서 다 쓸 수 있음.
		System.out.println(1);
	}
	public void f2() {
		System.out.println(2);
	}
	public void f3() {
		f1();
		f2();
	}
}


public class Hello {
	public static void main(String[] args) {
		// 가장 유명한 패턴이 싱글톤 패턴.
		
		Tiger tiger = new Tiger();
		//tiger.a = 10; // 사용 할 수 없다.
		tiger.b = 20; // 사용 할 수 있다.
		//tiger.f1(); // 사용 할 수 없다.
		tiger.f2(); // 사용 할 수 있다.
	}
}
*/

		/*
		// 과정 목차 설명 (홈페이지 소개)
		// 10일차 wrap부분
		Integer a = 10; // 클래스, Wrap
		int b = 20; // unWrap
		String s = a.toString(); // 클래스로서 다양한 함수를 이용하고 싶을 때
		Float f;
		Boolean t;
		// 12일차 스트림: data가 움직일 수 있는 경로
		// 디자인 패턴: 코드의 형식 (23가지: 600page) - 1학기 동안 배우는 내용/
		*/

		/*
		//ex118
		try {
			Reader r = new FileReader("test03.txt");
			
			while( true ) {
				int data = r.read();
				if( data == -1 ) {
					break;
				}
				System.out.println( (char)data );
			}
			
			r.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		/*
		//ex117 : 파일 입출력
		// 파일 만드는 것 : write
		// 파일 기존에 있는 거 읽는 것 : read
		 
		System.out.println(1);
		try {
			Writer w = new FileWriter( "test02.txt" );
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					
					//System.out.print( "[" + i + "," + j + "]" );
					
					if( (i + j) % 2 == 0 ) {
						w.write("O ");
						System.out.print("O ");
					}else {
						w.write("X ");
						System.out.print("X ");
					}
				}
				System.out.println();
				w.write("\n");
			}
			
			w.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(2);
		*/

		/*
		//ex116 : 파일 입출력
		// bmp, jpg, tga, png
		// bmp 파일 정도를 해석하고 입출력 할 수 있으면 상당한 수준이다.

		// class A{}
		// class B extends A{}
		// class C extends B{}
		// class D extends C{}
		
		// 업캐스팅일때는 이 문법이 성립된다.
		// 부 = 자; // Type Hierachy 켜는 방법 = f4
		System.out.println(1);
		try {
			// 파일을 생성해서 만들겠다.
			Writer w = new FileWriter( "test01.txt" );
			w.write("apple");
			
			w.write("\n");
			
			w.write("무궁화");
			
			// 싸인펜 뚜껑을 닫는다.
			w.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(2);
		*/

		/*
		//ex115
		ArrayList<Integer> al = new ArrayList<Integer>();
		// C
		al.add(10);
		al.add(20);
		al.add(30);
		// R
		for (int i = 0; i < al.size(); i++) {
			System.out.print( al.get(i) + " " );
		}System.out.println();
		// U
		al.set(1, 40);
		// D
		al.remove(0);
		
		// 최종확인
		System.out.println( al );
		*/
		/*
		//ex114
		// LinkedList는 콜렉션 중에 1개이다.
		// 제네릭 문법 사용하고 있다.
		// CRUD 할 수 있다.
		LinkedList<Integer> li = new LinkedList<Integer>();
		
		// size
		// 데이터가 몇개인지 물어본다.
		System.out.println( li.size() );
		int ct = li.size();
		System.out.println( ct );
		
		li.add(100);
		System.out.println( li.size() );
		Integer data = 200;
		li.add(data);
		System.out.println( li.size() );
		
		for (int i = 0; i < 5; i++) {
			li.add(i*10);
		}
		
		// 출력 방법1) 활용도가 제일 높다.
		System.out.println( li.size() );
		for (int i = 0; i < li.size(); i++) {
			System.out.print( li.get(i) + " " );
		}System.out.println();
		
		// 출력 방법2) 활용도는 떨어짐.
		// 오로지 출력용도. 연산이 안되니까.
		System.out.println( li );
		
		// 출력 방법3) 활용도는 1, 3의 중간 정도.
		for (Integer value : li) {
			System.out.print(value + " ");
		}System.out.println();
		
		li.add(1, 999);
		System.out.println(li);
		System.out.println();
		
		// 갱신
		li.set(2, 888);
		System.out.println(li);
		System.out.println();
		
		// 삭제
		li.remove(4);
		System.out.println(li);
		System.out.println();
		
		// 20을 찾아서 삭제하세요.
		for (int i = 0; i < li.size(); i++) {
			Integer num = li.get(i);
			if( num == 20 ) {
				li.remove(i);
				break;
			}
		}
		
		System.out.println(li);
		System.out.println();
		*/

		/*
		//ex113
		// 당신들이 사용하는 타입이 무엇인지 알려주기만 하면
		// 그 타입을 T라고 하는 이름으로 사용하겠다.
		// T는 이제부터  int이다 라고 알려주면, 그때부터
		// T라고 사용했던 모든 곳은 int가 된다.
		// 제네릭 문법( 템플릿 문법 )
		class Tiger<T>{
			T data;
			void setData(T data) {
				this.data = data;
			}
			T getData() {
				return data;
			}
		}
		// 단, 하나 주의 할 것은 이렇게 사용할 때, 표준 타입은
		// 사용할 수 없고 Integer
		// float >> Float
		// 반드시 클래스로만 설정할 수 있다.
		
		Tiger<Integer> tiger1 = new Tiger<Integer>();
		tiger1.setData(100);
		System.out.println(tiger1.getData());
		
		Tiger<String> tiger2 = new Tiger<String>();
		tiger2.setData("호랑이");
		System.out.println(tiger2.getData());
		
		Tiger<Float> tiger3 = new Tiger<Float>();
		tiger3.setData(3.14f);
		System.out.println(tiger3.getData());
		*/
		/*
		//ex112 >> 이 프로그램은 무식하면서도 융통성이 없다.
		// 이 프로그램은 잘못된 프로그램이다.
		class Tiger1{
			int data;
			void setData(int data) {
				this.data = data;
			}
			int getData() {
				return data;
			}
		}
		Tiger1 tiger1 = new Tiger1();
		tiger1.setData(100);
		System.out.println(tiger1.getData());
		
		class Tiger2{
			String data;
			void setData( String data ) {
				this.data = data;
			}
			String getData() {
				return data;
			}
		}
		Tiger2 tiger2 = new Tiger2();
		tiger2.setData("호랑이");
		System.out.println(tiger2.getData());
		*/

/*
public class Hello {
	public static void main(String[] args) {
		//ex111 : String의 제공 기능(멤버함수, 메쏘드)
		// String 클래스가 많은 프로그래머들에게
		// 시간 절약과 편의를 주기 위해서 표준으로 만들어
		// 진것인데... 그래서 사용하면 뭐가 편한데....?

		
		// 1. 
		String s = "무궁화꽃이피었습니다";
		System.out.println( s.charAt(3) );
		
		// 2. equals
		System.out.println(s.equals("무궁화꽃이피었습니다"));
		
		// 3. 검색 : 못찾으면 무조건 -1이 출력된다.
		System.out.println(s.indexOf("꽃이"));
		
		// 4.
		System.out.println(s.replace("꽃이", "나무는"));
		
		// 5.
		System.out.println(s.substring(5));
		// 인덱스 번호 3부터 5전까지(앞까지) 짤라서 주세요
		System.out.println(s.substring(3, 5));
		
		// 6.
		String s1 = "Apple";
		// Lower : 소문자
		System.out.println(s1.toLowerCase());
		// Upper
		System.out.println(s1.toUpperCase());
		
		// 7
		String s2 = " A p p l e ";
		System.out.println(s2);
		System.out.println(s2 + "banana");
		System.out.println(s2.trim() + "banana");
		
		// 8. 
		System.out.println(String.valueOf(100) + 100);
		System.out.println(String.valueOf(123.456) + 100);
		System.out.println(String.valueOf(true) + 100);
		
		System.out.println("------------------------");
		// 9.
		String s3 = "Apple";
		System.out.println(s3.toLowerCase());
		// 이 때 s3의 값 자체가 변경되었는가 ? 아니다.
		System.out.println(s3);
		
		// 이 때 s3의 값 자체가 변경되었는가 ? 아니다.
		String s4 = s3.toLowerCase();
		System.out.println(s3);
		System.out.println(s4);
		
		//10.
		String s = "무궁화꽃이피었습니다";
		System.out.println( s.length() );
	}
}
*/

/*
		//ex110
		
		String s;
		int n1 = 123; // "123"
		// 숫자 >> 문자열 변환
		s = Integer.toString(n1);
		System.out.println(s + 100);
		
		// 문자열 >> 숫자 변환
		int n2 = Integer.parseInt(s); // 문맥을 해석.
		System.out.println(n2 + 100);
		
		// 숫자 >> 문자열 변환
		int n3 = 3456; // "123"
		s = "" + n3; // 팁
		System.out.println(s + 1000);
 */

/*
		//ex109
		// 1
		String s1;
		s1 = "호랑이";
		
		// 2
		String s2 = "코끼리";
		
		//3
		String s3 = new String("코끼리");
 */

/*
public class Hello {
	public static void main(String[] args) {
		// f3
		// 모든 클래스의 부모는 object라는 클래스이다.
		//String s = "호랑이";
		//s.toString();
		//System.out.println( Math.PI);
		//Thread t;
		//class Tiger{
			
		//}
		//Tiger tttt = new Tiger();
		
		//tttt.toString();
		
		//108
		String s1 = "호랑이"; // s1과 s2는 동일한 객체이다.
		String s2 = "호랑이";
		// 1. 객체가 같은지 묻는 것인가 ? (이게 정답)
		// 2. 값이 같은지 묻는 것인가 ?
		System.out.println(s1 == s2);
		
		// 지금 s3번 코드는 엄밀히 말하면 코드가 잘못된것이다.
		// 모든 클래스는 객체를 생성시킬려고 하면 반드시
		// new를 이용해서 만들어야 한다.
		// 내부적으로 new를 이용해서.....
		String s3 = "호랑이";
		// 너무 어렵다.
		// s4이 정석이다.
		String s4 = new String("호랑이"); // new는 무조건 객체를 새로만듦.
		
		// 1. 객체가 같은지 묻는 것인가 ? (이게 정답)
		// 2. 값이 같은지 묻는 것인가 ?
		System.out.println(s2 == s4);
		
		String s5 = new String("호랑이");
		System.out.println(s4 == s5);
		
		// 문자열 객체를 서로 비교할 때 객체가 같은지를
		// 질문하는 프로그래머는 1명도 없다.
		// ==은 프로그래머가 사용하지 않는 문장이다.
		// 알고 싶은 것은 두 객체간에 값이 같은지 아닌지
		// 그것을 확인하는것이 거의 100%
		System.out.println(s4.equals(s5));
	}
}
*/

/*
//ex 107
class A{
	void f1() {
		System.out.println(1);
		try {
			int a = 10 / 2;
			return;
		}catch(Exception e) {
			
		}finally { // 쓸 수도 있고 안 쓸 수도 있음. & exception이 발생하든 안하든 = 무조건 실행
		System.out.println(2);
		}
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new A();
		a.f1();
	}
}
*/

/*
// ex107: 시간지연함수
public class Hello {
	public static void main(String[] args) {
		
		// 뭐하는 명령인지는 모르겠다.
		System.out.println(1);
		try {
			Thread.sleep(2000); // 프로그램 시간을 지연시킴. 예) 2000ms = 2초 쉰다.			
		}catch(Exception e) {
			
		}
		System.out.println(2);
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000); // 프로그램 시간을 지연시킴. 예) 2000ms = 2초 쉰다.			
			}catch(Exception e) {
				
			}
			System.out.println(i);
		}
		System.out.println("종료됨");
	}
}
*/

/*
//ex106 : 지금 하는 문법은 여러분이 작성할 일이 없습니다.
// 그런데 중요하다.

class A{
	void f1() {
		System.out.println(1);
		try {
			throw new Exception(); // 직접 익셉션을 발생시킨다.	
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}
	// throws Exception : 이 함수에서 try catch 안한다.
	// 함수를 부른 놈이 책임을 지어라.
	// 함수를 부른놈이 try catch해라.
	void f2()throws Exception {
		throw new Exception();
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new A();
		a.f1();
		
		// Unhandled exception
		try{
			a.f2();
		}catch(Exception e) {
			
		}
		System.out.println(999);
	}
}
*/

/*
//ex105 : 예외 처리(Exception)
public class Hello {
	public static void main(String[] args) {
		// 1. Arithmetic Exception :
		// 프로그램을 중단시키는게 목적이 아니라
		// 예외가 발생할 것을 프로그래머에게 알리는게 목적이다.
		// 이렇게 하면 중단이 되지 않음.
		System.out.println(1);
		try {
			// Arithmetic Exception
			int a = 10 / 0; // 이줄이 잘못된게 아니고.....
		}catch( Exception e ) {
			e.printStackTrace();
		}
		System.out.println(2);
		
		// 2. Null Pointer Exception
		String s = "호랑이";
		System.out.println(s + s.length());
		s = "독수리리";
		System.out.println(s + s.length());
		s = null; // s 자체가 없다. (존재하지 않는다.)
		// NullPointerException
		// Null이라고 설정한 객체를 이용해서 길이를 구하는 에러.
		try {
			System.out.println(s + s.length());
		}catch( Exception e ) {
			e.printStackTrace();
		}
		
		System.out.println(3);
		
		class Tiger{
			void f1() {
				System.out.println("함수콜");
			}
		}
		Tiger t = new Tiger();
		t.f1();
		t = null;
		try {
			t.f1();			
		}catch( Exception e) {
			e.printStackTrace();
		}
		System.out.println(4);
		
		// 3. ArrayIndexOutOfBoundsException
		int[] ar = new int[3];
		try {
			ar[0] = 10;
			ar[3] = 20;			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(5);
		
		// 4. ClassCastException
		class Apple{}
		
		class Banana extends Apple{};
		class Orange extends Apple{};
		
		Apple apple = new Banana();
		Banana banana = (Banana)apple;
		System.out.println(6); 
		// Class Cast Exception
		try {
			Orange orange = (Orange)apple;			
		}catch( Exception e ){
			e.printStackTrace();
		}
		System.out.println(7);
	}
}
*/

/*
// ex104
class Tiger{
	static int a;
	static void f1() {
		System.out.println(1);
	}
}
public class Hello {
	public static void main(String[] args) {
		// static이 붙은 멤버변수와 멤버함수는
		// 객체를 생성시키지 않고 바로 사용할 수 있다.
		Tiger.a = 10;
		Tiger.f1();
		System.out.println(Tiger.a);
	}
}
*/


/*
// ex103
class A{
	void f1() {}
}
interface B{
	void f1();
}
interface C{
	void f2();
}
interface D{}

class E extends A implements B, C, D{
	public void f1() {
	}
	public void f2() {
	}
}
public class Hello {
	public static void main(String[] args) {
		
	}
}
*/

/*
// ex102
class A{
	void f1() {
		System.out.println(1);
	}
}

interface B{
	void f2();
}

class C extends A implements B{
	public void f2() {
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		A c1 = new C();
		c1.f1();
		
		B b1 = new C();
		b1.f2();
		
		C c2 = new C();
		c2.f1();
		c2.f2();
	}
}
*/

/*
// ex101
// 부모 클래스 안에 추상함수로만 되어 있을 때는
// 일반적으로 클래스를 사용하지 않고 인터페이스 문법을 사용한다. (바꾸나 안바꾸나 똑같다.)
interface A{
	// 추상함수가 1개 이상 있는 경우
	void f1(); // abstract 는 자동으로 붙여진다.
	void f2();
}
// A가 미쳐 못했던 코드를 B가 구현하려고 한다.
class B implements A{
	// ctrl + space
	public void f1() {
		System.out.println(1);
	}
	public void f2() {
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new B();
		a.f1();
		a.f2();
	}
}
*/

/*
// ex100
abstract class A{
	// 추상함수가 1개 이상 있는 경우
	abstract void f1();
	abstract void f2();
}

class B extends A{
	// ctrl + space 누르면 overriding 함수 나옴. 있든 없든 상관없음
	@Override 
	void f1() {
		System.out.println(1);
	}
	void f2() {
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new B();
		A b = new B();
		a.f1();
		a.f2();
		b.f1();
		b.f2();
	}
}
*/

		/*
		// ex99 : 칼을 만드는 클래스이다.
		abstract class A{
			void f1() {
				System.out.println("칼 만듦");
			}
			// 추상함수
			// 누구든지 상속받으세요. (단 f2함수를 구현 할 수 있는 사람만)
			abstract void f2();
		}
		class B extends A{
			void f2() {
				System.out.println("쇠방패 만듦");
			}
		}
		class C extends A{
			void f2() {
				System.out.println("나무 방패 만듦");
			}
		}
		
		A a = new B();
		a.f1();
		a.f2();
		
		A b = new C();
		b.f1();
		b.f2();
		
		// 성립되지 않는다.
		// A a = new A();
		 */
		/*
		// ex98)
		abstract class Animal{
			// 오버라이딩하면 어차피 이 안에 있는 건 호출 할 수 없다.
			// 이 함수는 코드가 미완성입니다.
			// 그 완성은 자식이 할 것입니다. 라고 하는 것을 알려야 한다.
			// abstract >> 추상 >> 미완성.
			// 추상함수이다. 라고 알린다.
			// 추상함수가 1개라도 있는 클래스는 반드시
			// 클래스 이름앞에 추상이라고 적어야 한다.
			// 98 예제와 97 예제는 완전히 동일합니까 ? 아니다.
			// 
			// 상속받은 클래스 어떤 함수로 작용을 할지 모른다.
			// 그 결과가 아주 아주 다양한 형태로 나타날 수 있다.
			// 업캐스팅(부=자) << 다형성.
			abstract void cry();
			
			void run() {
				System.out.println("달린다.");
			}
		}
		class Dog extends Animal{
			void cry() { // 오버라이딩
				System.out.println("멍멍");
			}
		}
		class Cat extends Animal{
			void cry() { // 오버라이딩
				System.out.println("야옹");
			}
		}
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.cry();
		cat.cry();
		
		dog.run();
		cat.run();
		
		// 추상 클래스는 객체를 생성시킬 수가 없다.
		//Animal animal = new Animal();
		*/

		/*
		// ex97)
		class Animal{
			void cry() {
				
			}
			void run() {
				System.out.println("달린다.");
			}
		}
		class Dog extends Animal{
			void cry() { // 오버라이딩
				System.out.println("멍멍");
			}
		}
		class Cat extends Animal{
			void cry() { // 오버라이딩
				System.out.println("야옹");
			}
		}
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.cry();
		cat.cry();
		
		dog.run();
		cat.run();
		
		// 사용 가능
		Animal animal = new Animal();
		*/
		
		/*
		// ex96)
		class A{
			// 찾았다. f1 >> 혹시 자식이 f1이 있는지 쳐다본다.
			// 쳐다보고 있으면 자식 함수 사용.
			void f1() {
				System.out.println(1111);
			}
			// 못찾았다. 그러면 부모의 함수 사용.
			void f2() {
				System.out.println(3333);
			}
		}
		class B extends A{
			// 부모이름이랑 똑같이 이름을 작명하는 것을
			// 오버라이딩이라고 한다.
			void f1() {
				System.out.println(2222);
			}
			void f3() {
				System.out.println(4444);
			}
		}
		// 부모 a = new 자식();
		// 부자 관계( 업캐스팅 )
		// 자부 관계( 다운캐스팅 ) : 자바에서 지원하지 않음.
		A a = new B(); // 부모 = 자식
		a.f1(); // 사용가능
		a.f2(); // 사용가능
		// a.f3(); // 사용불가
		
		// 자자 관계
		// B b = new B(); // 자식 = 자식
		 */
		/*
		// ex95)
		class A{
			A(){
				System.out.println("부모생성자1");
			}
			A(int a){
				System.out.println("부모생성자2");
			}
			A(int a, int b){
				System.out.println("부모생성자3");
			}
		}
		class B extends A{
			B(){
				super();
				System.out.println("자식생성자1");
			}
			B(int a){
				//super(10);
				super(10,20);
				System.out.println("자식생성자2");
			}
		}
		B b1 = new B();
		System.out.println("-----------------------");
		B b2 = new B(100);
		*/

		/*
		// ex94) 상속
		class Tire{
			String name;
			void roll() {
				System.out.println(name + "타이어가 굴러갑니다.");
			}
		}
		class Kumho extends Tire{
			Kumho(){
				name = "금호";
			}
			void origin() {
				System.out.println("마산에서 생산된");
			}
		}
		Kumho kumho = new Kumho();
		kumho.origin();
		kumho.roll();
		
		class Hankook extends Tire{
			Hankook(){
				name = "한국";
			}
			void origin() {
				System.out.println("울산에서 생산된");
			}
		}
		Hankook hankook = new Hankook();
		hankook.origin();
		hankook.roll();
		*/
		/*
		 class Button{
			String name;
			Button(){}
			Button(String name){
				this.name = name;
			}
			void textName() {
				// System.out.println(name);
				System.out.println(this.name);
			}
		}
		
		class CheckButton extends Button{
			CheckButton(String name){
				super(name); // 부모 생성자를 호출(콜). 반드시 첫줄에 사용해야 함.
				System.out.println(111);
				System.out.println(super.name); // 부모의 변수를 사용하는 것.
			}
			void setCheck() {
				System.out.println(name + "체크됨");
			}
		}
		
		class RadioButton extends Button{
			RadioButton(String name){
				super(name); // 부모의 생성자를 호출하게됨.
			}
			void setCheck() {
				System.out.println(name + "선택됨");
			}
		}
		CheckButton c = new CheckButton("돈까스");
		c.setCheck();
		c.textName();
		System.out.println("---------------------------");
		RadioButton r = new RadioButton("오렌지");
		r.setCheck();
		r.textName();
		 */
		/*
		// ex92) 상속
		class Shape{ // 모양
			int width, height; // 가로, 세로
			int area;
			void showArea() {
				System.out.println(area);
			}
		}
		// 사각형은 도형이다.
		class Rectangle extends Shape{
			void cal() {
				area = width * height;
			}
		}
		// 삼각형은 도형이다.
		class Triangle extends Shape{
			void cal() {
				area = (width * height)/2;
			}
		}
		Rectangle r = new Rectangle();
		r.width = 10;
		r.height = 20;
		r.cal();
		r.showArea();
		
		Triangle t = new Triangle();
		t.width = 10;
		t.height = 20;
		t.cal();
		t.showArea();
		*/

		/*
		// ex91) 상속
		class Animal{
			void common() {
				System.out.println("포유류");
			}
		}
		// 호랑이는 동물이다.
		class Tiger extends Animal{
			void name() {
				System.out.println("호랑이");
			}
		}
		class Lion extends Animal{
			void name() {
				System.out.println("사자");
			}
		}
		Tiger tiger = new Tiger();
		tiger.common();
		tiger.name();
		Lion lion = new Lion();
		lion.common();
		lion.name();
		*/

		/*
		// ex90) 상속
		class A{
			void f1() {
				System.out.println("유능한 기능 1");
			}
			void f3() {
				System.out.println("이상한 기능 3");
			}
		}
		
		class B extends A{ // a여 나의 부모가 되어주시오. 나 a 당신 꺼도 쓸거야.
			void f2() {
				System.out.println("특별한 기능 2");
			}
			void f3() {
				System.out.println("요상한 기능 3");
			}
			void f4() {
				System.out.println("아빠의 3번");
				super.f3();
			}
		}
		
		A a = new A();
		a.f1();
		System.out.println("===========================");
		B b = new B();
		b.f1();
		b.f2();
		b.f3(); // 자기 호주머니에 있는거부터 찾고 없으면 부모님꺼를 씀.
		b.f4();
		*/

		/*
		// ex 88)
		class Tiger{
			// this
			int radio; // 필드, 멤버 변수
			
			void f1(int radio) { //
				// 필드의 radio = 전달인수의 radio;
				this.radio = radio;
			}
		}
		Tiger t = new Tiger();
		*/

		/*
		// ex87)
		class Tiger{
			void showMeTheMoney() {
				System.out.println("100만원");
			}
		}
		class Lion{
			int a;
			String s;
			Tiger t;
			Lion(int a, String s, Tiger t){
				this.a = a;
				this.s = s;
				this.t = t;
			}
			
			void show() {
				// this가 생략된 문장
				System.out.println(a+s);
				// this를 구태여 붙여서 사용한 문장
				// System.out.println(this.a + this.s);
				t.showMeTheMoney(); // this. 적어도 됨.
			}
		}
		Tiger tiger = new Tiger();
		Lion lion = new Lion(10, "호랑이", tiger);
		lion.show();
		*/
		/*
		 
		// ex86)
		// 클래스도 타입이다.
		// 모든 타입은 함수 인수로 전달할 수 있다. 
		class Tiger{
			void f2() {
				System.out.println(999);
			}
		}
		
		class Lion{
			void f1(int a, String s, Tiger t) {
				System.out.println(a + s);
				t.f2();
			}
		}
		
		Lion lion = new Lion();
		Tiger tiger = new Tiger();
		lion.f1(10, "호랑이", tiger);
		*/
		/*
		// ex85)
		class Tiger{
			int aa, bb;
			Tiger(int x, int y){
				aa = x;
				bb = y;
			}
			
			void showData() {
				System.out.println(aa + " " + bb);
			}
		}
		Tiger t = new Tiger(10, 20);
		System.out.println(t.aa + " " + t.bb);
		t.showData();
		*/
		/*
		// ex84)
		class Lion{
			// 디폴트 생성자가 자동으로 만들어졌다.
			// this라는 멤버변수를 자동으로 만든다.
			void f1() {
				System.out.println(1);
				System.out.println( 2 + ":" + this);
			}
		}
		// t1입장에서 this변수가 만들어진다.
		Tiger t1 = new Tiger();
		t1.f1();
		// 객체의 고유번호. 를 저장하기 위한 변수 >> this 변수
		System.out.println(1 + ":" + t1); // 컴퓨터가 식별하는 고유번호
		//System.out.println( t.hashCode() ); // 사람이 식별하는 고유번호
		
		System.out.println("--------------------------------");
		// t2입장에서 this변수가 만들어진다.
		Tiger t2 = new Tiger();
		t2.f1();
		System.out.println( 1 + ":" + t2);
		*/
		/*
		// ex84)
		class Tiger{
			// 멤버 변수 
			int x, y;
			
			// 생성자
			Tiger(){
				x = 100;
				y = 200;
			}
			
			// 생성자 
			Tiger(int a, int b){
				x = a;
				y = b;
			}
			
			// 멤버 함수
			void showMember() {
				// x = 100; 사용할 수 있다.
				System.out.println(x + " " + y);
			}
			
			void Multiple( int num ) {
				// x = 777 * 3;
				x = x * num;
				// y = 888 * 3;
				y = y * num;
			}
		}
		Tiger t1 = new Tiger();
		t1.showMember();
		
		Tiger t2 = new Tiger();
		t2.showMember();
		
		Tiger t3 = new Tiger(300,400);
		t3.showMember();
		
		Tiger t4 = new Tiger(777,888);
		t4.showMember();
		t4.Multiple(3);
		t4.showMember();
		t4.Multiple(2);
		t4.showMember();
		*/
		/*
		// ex83) 생성자함수가 필요한 이유
		class Tiger{
			int a=10, b=20;
		}
		Tiger t1 = new Tiger();
		System.out.println(t1.a + " " + t1.b);
		
		Tiger t2 = new Tiger();
		System.out.println(t2.a + " " + t2.b);
		
		class Airplane{
			int fuel = 80; // 연료
		}
		Airplane boying777 = new Airplane(); // 제주도
		Airplane boying888 = new Airplane(); // 뉴질랜드
		
		class Car{
			int fuel;
			Car(int num){
				fuel = num;
			}
		}
		Car car1 = new Car(10); // 수원까지 가는 차
		Car car2 = new Car(100); // 부산까지 가는 차
		System.out.println(car1.fuel);
		System.out.println(car2.fuel);
		*/
		/*
		// ex82)
		 
		class Tiger{
			int a, b;
			
			// 여기서 디폴트 생성자는 사용하지 않는다.
			Tiger(){}
			
			Tiger(int x, int y){
				a = x; // 멤버변수 a = 함수 인수 x; 
				b = y; // 멤버변수 b = 함수 인수 y;
			}
		}
		Tiger t1 = new Tiger(10,20);
		System.out.println(t1.a + " " + t1.b);
		
		Tiger t2 = new Tiger(30,40);
		System.out.println(t2.a + " " + t2.b);
		
		Tiger t3 = new Tiger();
		System.out.println(t3.a + " " + t3.b);
		*/
		/*
		// ex81)
		// 디폴트 생성자를 자동으로 만든다.(눈에 안보임)
		class T00001{
			
		}
		T00001 t1 = new T00001();
		
		// 디폴트 생성자 안만들어 준다.
		class T00002{
			T00002(){
			}
		}
		T00002 t2 = new T00002();
		
		// 디폴트 생성자 안만들어 준다.
		class T00003{
			T00003(int a){
			}
		}
		// T00003 t3 = new T00003(); // 불가능 >> 많이들 헷갈림.
		T00003 t33 = new T00003(100);
		
		// 디폴트 생성자 안만들어 준다.
		class T00004{
			T00004(){
			}
			T00004(int a){
			}
		}
		T00004 t4 = new T00004();
		T00004 t44 = new T00004(100);
		 */

		/*
		// ex80)
		// 8. 생성자 함수를 작성하지 않으면
		//    디폴트 생성자를 자동으로 만들어 준다.
		class Tiger{
			int x, y; // 필드( == 멤버 변수 )
			// 생성자: 디폴트 생성자라고도 한다.
			// 디폴트 생성자는 인수 전달이 없는 생성자.
			
//			Tiger(){
//				
//			}
		}
		Tiger t1 = new Tiger();
		// 에러가 뜨지 않는 이유는 디폴트 생성자가 생성되었기때문 
		// 눈에 보이지 않지만 생성되어있음.
		 */
		/*
		// ex79)
		// 7. 생성자 함수도 함수이기 때문에 오버로딩 할 수 있다.
		class Tiger{
			int x, y;
			
			Tiger(){
				System.out.println("생성자 함수 콜1");
			}
			Tiger(int a){
				System.out.println("생성자 함수 콜2");
			}
			Tiger(int a, int b){
				System.out.println("생성자 함수 콜3");
			}
			Tiger(char a, char b){
				System.out.println("생성자 함수 콜4");
			}
		}
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(10);
		Tiger t3 = new Tiger((int)10,(int)20);
		Tiger t4 = new Tiger((char)'한',(char)'글');
		
		// 코드의 가독성이 매우 매우 중요합니다.
		 */
		/*
		// ex78)
		// 6. 생성자 함수를 만드는 단 하나의 목적 : 필드 초기화.
		class Tiger{
			int x, y;
			
			Tiger(){
				System.out.println("생성자 함수 콜");
				x = 100;
				y = 200;
			}
		}
		System.out.println(1);
		Tiger t1 = new Tiger();
		System.out.println(t1.x + " " + t1.y);
		
		System.out.println(2);
		Tiger t2 = new Tiger();
		System.out.println(t2.x + " " + t2.y);
		
		System.out.println(3);
		*/

	/*
		// ex77) 생성자
		class Tiger{
			// 1. 생성자는 함수의 일부분이다.( 정확한 표현: 생성자 함수 )
			// 2. 생성자 함수는 반드시 클래스 이름과 동일해야 한다.
			// 3. 생성자 함수는 리턴값이 무조건 없다.
			// 4. 생성자 함수는 객체가 생성될 때 자동 호출(콜)된다.
			// 5. 생성자 함수는 프로그래머가 직접 호출 할 수 없다. (자동임)
			Tiger() { //void 조차 쓰면 안된다.
				System.out.println("생성자 함수 콜");
			}
		}
		
		System.out.println(1);
		Tiger t1 = new Tiger(); // 객체 생성 시킴.
		System.out.println(2);
		Tiger t2 = new Tiger(); // 객체 생성 시킴.
		System.out.println(3);
		
		// 생성자 함수가 함수니까. 자동 말고 직접 호출해서 콜할 수 있는가 ?
	*/

/*
// ex 76-1)
class Tiger{
	void f1() {
		// f3() : 주석을 풀면 돌아 올 수 없는 코드가 된다.
		System.out.println(1);
	}
	void f2() {
		f1();
		System.out.println(2);
	}
	void f3() {
		f2(); // 이렇게 호출 할 수 있다.
		System.out.println(3);
	}
}

Tiger t = new Tiger();
t.f3();

System.out.println("---------------");
class Lion{
	void f1() {
		System.out.println(1);
	}
	void f2() {
		f1();
		System.out.println(2);
		f3();
	}
	void f3() {
		f1();
		System.out.println(3);
		f1(); // 객체이름없이 호출 가능.
		// f1, f2, f3 은 family
	}
}
Lion lion = new Lion();
lion.f2(); // 객체이름.함수호출 Ex. 최진사댁 f2
*/

		/*
		// ex75) 코드 작성 순서
		// 필드, 생성자, 함수: 가족이다. 패밀리.
		clas Tiger{
			// 필드
			// 생성자 
			// 함수	
		} */
		/*
		// ex74)
		clas Tiger{
			//리턴 타입은 다르더라도 오버로딩 할 수 없다.
			void func() {
				
			}
			int func() {
				return 100;
			}
		}
		*/

		/*
		// ex73) overloading
		// ex73-1)
		class Tiger{
			// 카멜 표기법: 사각형의 면적을 출력하세요.
			void printAreaRectangle(int a) {
				System.out.println( a * a);
			}
			// 가로 세로값으로 면적을 구한다.
			void printAreaRectangle(int a, int b) {
				System.out.println( a * b);
			}
			void printAreaRectangle(int x1, int y1, int x2, int y2) {
				int w = x2 - x1;
				int h = y2 - y1;
				System.out.println(w * h);
			}
		}
		Tiger t = new Tiger();
		t.printAreaRectangle(10);
		t.printAreaRectangle(10, 20);
		t.printAreaRectangle(10, 10, 50, 50);
		
		// ex73-2)
		class Lion{
			void swap(int a, int b) {
				// 데이터 교환하는 코드
				int temp;
				System.out.println(a + " " + b);
				temp = a;
				a = b;
				b = temp;
				System.out.println(a + " " + b);
			}
			
			void swap(float a, float b) {
				// 데이터 교환하는 코드
				float temp;
				System.out.println(a + " " + b);
				temp = a;
				a = b;
				b = temp;
				System.out.println(a + " " + b);
			}
		}
		System.out.println("------------------");
		Lion lion = new Lion();
		lion.swap( (int)100, (int)400 );
		lion.swap( (float)200.0f, (float)600.0f);
		*/

		/*
		// ex72)
		class Tiger{
			// 전달 인수 개수가 다르거나
			// 개수가 같더라도 받는 타입이 다르면
			// 함수이름을 동일하게 작명할 수 있다.
			// 이것을 함수 오버로딩(overloading)이라고 한다.
			// overloading, overriding
			void func01() {
				System.out.println(1);
			}
			// 특별한 조건 : 전달되는 인수의 개수가 다를 때
			void func01(int a) {
				System.out.println(2);
			}
			void func01(int a, int b) {
				System.out.println(3);
			}
			
			// 특별한 조건2 : 전달 인수 갯수가 같더라도 받는 타입이 다를 때
			void func01(long a) {
				System.out.println(4);
			}
		}
		Tiger t = new Tiger();
		t.func01();
		t.func01((long)10);
		t.func01(10, 20);
		t.func01((int)10);
		
		// 변수 이름을 중복해서 정의 할 수 없다.
		// 클래스 이름은 중복해서 정의 할 수 없다.
		// 함수이름은 중복해서 정의 할 수 없다.
			// 그런데 특별한 조건에 의해서 함수 이름은 중복될 수 있다.
			 */
		/*
		 
		// ex71) 인수 4개 사용하는 예제
		class Tiger{
			void f1() {
			
			}
			void f2(int a, int b) {
				System.out.println(a + " " + b);
			}
			// int, float, String, char >> 타입
			void f3(int num, float ct, String s, char ch) {
				System.out.println("f3 call");
				System.out.println(num);
				System.out.println(ct);
				System.out.println(s);
				System.out.println(ch);
			}
		}
		Tiger t = new Tiger(); // Tiger : 클래스, 설계도(의미상), 타입
		t.f2(10, 20);
		t.f3(100, 3.14f, "호랑이", '한');
		*/
		
		/*
		// ex70)
		 
		class Tiger{
			void f1() {
				System.out.println(1);
			}
			void f2(int a) {
				System.out.println(a);
			}
			// 전달 인수 1개 이상 됩니까? 됩니다.
			// void f3(int a, b) << 아주 자주하는 실수이다.
			void f3(int a, int b) {
				System.out.println(a + b);
			}
		}
		Tiger t = new Tiger();
		t.f1();
		t.f2(100);
		t.f3(100, 200);
		*/
		/*
		// ex69)
		class Apple{
			void confirm( int password ) {
				System.out.println(password);
				
				int[] DataBase = new int[] { 1234, 2345, 3456, 4567 };
				//							//홍	 //이	//세  //안
				int count = 0;
				for (int i = 0; i < DataBase.length; i++) {
					if( DataBase[i] == password ) {
						System.out.println("찾았따....");
						break;
					}
					count++;
				}
				System.out.println(count);	
				if( count == DataBase.length ) {
					System.out.println("못찾았다. 패스워드를 확인하세요");
					return;
				}
				
				String[] name = new String[] {
						"홍길동",
						"이순신",
						"세종대왕",
						"안중근"
						};
				System.out.println(name[count] + "하이");
				
				// switch문장을 사용하는 것은 잘못된것이다.
//				switch( count ) {
//				case 0:
//					System.out.println("홍길동 하이");
//					break;
//				case 1:
//					System.out.println("이순신 하이");
//					break;
//				case 2:
//					System.out.println("세종대왕 하이");
//					break;
//				}
			}
		}
		Apple apple = new Apple();
		apple.confirm(4567);
		*/

		/*
		// ex69)
		class Tiger{
			// 리턴값이 없다.
			// 리턴이 없다라고는 안했다.
			void f1() {
				System.out.println(1);
				System.out.println(2);
				System.out.println(3);
				return;
				// System.out.println(4); >> 오류가 남
				// System.out.println(5);
			}
			// 짝수 홀수를 판별하는 함수이다.
			void f2(int num) {
				if( num < 0) {
					System.out.println("양수를 입력하세요");
					return; // 진행 안함. 중단.
				}
				
				if( num % 2 == 0 ) {
					System.out.println(num+"짝");
				}else {
					System.out.println(num+"홀");
				}
			}
			
			void f3(int num) {
				System.out.println(1);
				if( num < 0 ) {
					return;
				}
				System.out.println(2);
				if( num > 100) {
					return;
				}
				System.out.println(3);
			}
		}
		Tiger t = new Tiger();
		t.f1();
		t.f2(10);
		t.f2(11);
		t.f2(-20);
		System.out.println("================================");
		t.f3(-10);
		System.out.println("================================");
		t.f3(50);
		System.out.println("================================");
		t.f3(200);
		*/
		/*
		// ex68)
		class Tiger {
			int func01(int num) {
				int sum = 0;
				for (int i = 0; i <= num; i++) {
					sum += i; // sum = sum + 1;
				}
				// 여기서 sum을 출력해도 된다.
				return sum;
			}
			// 2의 승수를 구해준다. 2^n >> 2의 n승을 구한다.
			int func02(int num) {
				int sum = 1;
				for (int i = 0; i < num; i++) {
					sum = sum * 2;
				}
				return sum;
			}
		}
		Tiger t = new Tiger();
		System.out.println( t.func01(50) );
		
		System.out.println( t.func02(8) );
		System.out.println( t.func02(10) );
		System.out.println( t.func02(20) * 6 );
		System.out.println( t.func02(3) + t.func02(4) );
		*/
		/*
		// ex67) 
		class Lion{
			// 원의 면적을 구하는 함수이다.
			// float getAreaCircle(float radius) >> 실제 함수
			float func01(float r) {
				// System.out.println("1"); >> 호출확인 하는 용도
				float s = r * r * 3.14f;
				return s;
			}
			//정사각형의 면적을 구하는 함수.
			// float getAreaRectangle(float length) >> 실제 함수
			float func02(float length) {
				// System.out.println("1"); >> 호출확인 하는 용도
				float s = length * length;
				return s;
			}
		}
		//무시
		Lion lion = new Lion();
		lion.func01(6);
		// 값을 받음
		float result = lion.func01(6);
		System.out.println(result);
		// 출력에
		System.out.println( lion.func01(86));
		
		//리턴을 받지 말고 함수안에서 바로 출력하면 안되는가?
		System.out.println( lion.func02(10));
		
		// 조합1. 혹은 활용 >> 리턴을 받지 않으면 이런 것이 안됨.
		float a = lion.func01(3);
		float b = lion.func02(4);
		System.out.println( a + b );
		// 조합2.
		System.out.println(lion.func01(3) + lion.func02(4));
		*/

/*
// ex66) 기본꼴(형태) 정리
class Tiger{
	// void f1() : 함수원형, 함수 프로토타입
	void f1() {
		
	}
	// void f2(int a) : 함수원형
	void f2(int a) {
		
	}
	// float f3() >> 함수 프로토타입
	float f3() {
		return 3.14f;
	}
	// boolean f4(float a) >>  
	boolean f4(float a) {
		return tree;
	}
}
*/

/*
		// ex65)
		// java >> 프로그램 파트에 있다가.. 어느날
		// 갑자기 파이썬이라는 프로그램이 필요한 경우가 생겼다.
		// 1. 4대 제어문 비슷 혹은 같다.
		// 2. 함수 사용법(거의 같다. 99%)
		// 3. 타입 선언하는 방법
		// 4. 클래스 만드는 방법.
		// 5. IDE 사용법.
		class Tree{
			// 인수 전달이 없고, 리턴도 없는 함수.
			void func01() {
				System.out.println( "func01 함수가 콜(call) 됨. " );
			}
			// 전달인수는 있는데, 리턴이 없다.
			void func02(int num) {
				System.out.println( num +"func01 함수가 콜(call) 됨. " );
			}
			// void >> ...가 없다. (돌려주는게(return) 없다)
			// 있다: int 타입에 return값이 있다.
			// 전달 인수는 없는데 리턴은 있다.
			int func03() {
				System.out.println( "func03 콜" );
				return 999;
			}
			// 			return값 전달인수
			// func01	X		X
			// func02	X		O
			// func03	O		X
			// func04	O		O
			
			int func04(int apple) {
				System.out.println( "func04 콜" );
				return 800+apple;
			}
		}
		Tree tree = new Tree();
		tree.func01();
		tree.func02(100);
		// 1. 리턴된값을 무시했음.
		tree.func03();
		
		// 2. 리턴값을 변수가 받았다.
		int num = tree.func03();
		System.out.println("예제:" + num);
		
		// 3. 리턴값을 바로 출력에 연결했다.
		System.out.println("테스트:" + tree.func03());
		System.out.println("================================");
		
		// 1.
		tree.func04(10);
		
		// 2.
		int sum = tree.func04(20);
		System.out.println(sum);
		// 3.
		System.out.println(tree.func04(30));
		*/

		/*
		// ex64)
		class Banana{
			void test( int n ) {
				for (int i = 0; i < n; i++) {
							System.out.println("테스트중");
				}
			}
			
			void gugu( int num ){
				for (int i = 0; i < 10; i++) {
					// System.out.println( 5 + "*" + i = "=" + 5 * i);
					System.out.println(num + "*" + i + "=" + num * i );
				}
				System.out.println("-------------------");
			}
		}
		Banana banana = new Banana();
		banana.test(5);
		banana.gugu(9);
		banana.gugu(13);
		*/
		/*
		// ex63)
		class Apple{
			// void cry( int num = ) {
			void cry( int num ) {
				//System.out.println(num);
				for (int i = 0; i < num; i++) {
					System.out.println("엉");
				}
			}
		}
		
		Apple apple = new Apple();
		// 함수에 값을 대입시킨다.
		// 함수에 인수 전달을 한다.
		// 함수cry를 호출하는데 1000이라는 값을 전달한다.
		apple.cry( 3 );
		// 약속 위반
		// apple.cry(); // 에러.
		System.out.println("=====================");
		apple.cry( 4 );
		System.out.println("=====================");
		apple.cry( 2 );
		// int num = 3; 위와 같이 할 수 있음. (대입연산이 일어남. '='이 생략됨.) 
		 */
		/*
		// ex62) 메소드:method, 함수:function
		class Apple{
			// 동작
			// void 외우세요.
			void eat() { // 이름:eat
				System.out.println("저는 먹습니다.");
				System.out.println("저녁을");
			}
			
			void drink() { // 이름:drink
				System.out.println("저는 마십니다.");
				System.out.println("쥬스를");
			}
		}
		Apple apple = new Apple(); // 무조건 외우세요.
		System.out.println(apple);
		// eat함수를 콜한다. (호출한다.)
		apple.eat();
		// drink함수를 콜한다.
		apple.drink();
		apple.eat();
		System.out.println("-------------------");
		for (int i = 0; i < 5; i++) {
			apple.drink();
		}
		*/
		/*
		// ex61) 필드(변수) : 속성
		// ex61-1)
		class Tiger {
			byte a;
			short b;
			char c;
			int d;
			long e;
			float f;
			double g;
			boolean h;
			String s;
		}
		// 만약에 객체가 1개만 사용할것이라고 보장될 때
		Tiger tiger = new Tiger();
		tiger.a = 10;
		tiger.b = 20000;
		tiger.c = '한';
		tiger.d = 1000;
		tiger.e = 2000;
		tiger.f = 3.14f;
		tiger.g = 3.14;
		tiger.h = true;
		tiger.s = "호랑이";
		System.out.println( tiger.c + " " + tiger.s );
		
		// ex61-2)
		class Lion {
			byte a = 10;
			short b = 20000;
			char c = '한';
			int d = 1000;
			long e = 2000;
			float f = 3.14f;
			double g = 3.14;
			boolean h = true;
			String s = "사자";
		}
		Lion lion = new Lion();
		System.out.println( lion.c + " " + lion.s );
		*/

		/*
		// ex60)
		class Tiger {
		 
			int x, y;
		}
		
		Tiger t1 = new Tiger();
		t1.x = 10;
		t1.y = 20;
		System.out.println(t1.x + " " + t1.y);
		
		Tiger t2 = new Tiger();
		t2.x = 30;
		t2.y = 40;
		System.out.println(t2.x + " " + t2.y);

		Tiger t3 = new Tiger();
		t3.x = 50;
		t3.y = 60;
		System.out.println(t3.x + " " + t3.y);
		// 각각각의 고유 주민등록번호 번호가 출력된다. (컴퓨터마다 다름)
		// 고유 식별번호. (절대 중복되지 않음)
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		*/
		/*
		// ex59) 필드(변수) 선언 및 객체 생성과 사용
		class Tiger{
			int age;
			int salary;
			int x, y;
		} // >> 설계도.
		
		Tiger tiger01 = new Tiger();
		tiger01.age = 20;
		tiger01.x = 30;
		// 틀린 문장이다.
		// System.out.println(age);
		System.out.println(tiger01.age); // 20
		System.out.println(tiger01.salary); // 0 (디폴트 값)
		System.out.println(tiger01.x); // 30 
		System.out.println(tiger01.y);
		System.out.println(tiger01.x + tiger01.age);
		*/
		/*
		// ex58) 클래스의 기본
		// 클래스 : 비행기 설계도, 붕어빵 틀
		// 객체 : 실제 만들어진 비행기, 실제 만들어진 붕어빵
		
		// Tiger는 클래스 이름이다.
		// 주의: 이름의 첫자는 가급적 대문자로 작성하자. (암묵적인 약속.)
		
		// 클래스의 3대 구성요소: 생성자, 메소드, 필드
		class Tiger{
			// 1. 생성자 : 필드 초기화.
			// 2. 메소드 : 클래스의 동작.
			// 3. 필드 : 클래스의 속성.
			// 모두가 있어야 되는가 ? 아니다.
		}
		
		// 객체를 만든다.
		// t1은 객체이다. 객체 이름이다.
		// 비행기 보잉747 = new 비행기();
		Tiger t1 = new Tiger();
		
		// t1이라는 이름으로 객체를 만드세요.
		// 오타의 모습
		// Tiger t1 = Tiger(); // new 빠짐
		// Tiger t1 = new Tiger; // () 빠짐
		// tiger t1 = new tiger(); // 첫자가 틀림
		*/

		/*
		// ex57)
		// 표준타입
		// byte, char, short, int, 
		// long, float, double, boolean
		
		// 참조타입( String >> 혹시 클래스 인가요? 예스)
		String s1 = "호랑이"; // 문자열 
		String[] s2 = new String[] { "코끼리", "독수리", "앵무새" };
		// 출력방식1
		for (int i = 0; i < s2.length; i++) {
			System.out.print(s2[i] + " ");			
		}System.out.println();
		// 출력방식2
		for (String item : s2) {
			System.out.print(item + " ");			
		}System.out.println();
		
		// 표준 타입 : 첫자가 소문자. 변수 만들 수 있다.
		// 클래스 타입 : 첫자가 대문자. 변수(객체) 만들 수 있다.
		// 클래스가 설계도이다.
		// 참조 타입 안에 클래스 타입이 포함됨.
		// 참조타입: 배열, 클래스
		*/
		/*
		// ex56) for each
		 
		// int 외에 7가지의 표준타입들의 문법도 모두 동일하다.
		int[] ar = new int[] {70, 80, 90, 100};
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");			
		}System.out.println();
		
		// "for each" 문이라고 한다.
		for (int i : ar) { // 외워
			System.out.print(i + " ");
		}System.out.println();
		
		
		// ㅑ, value, item
		for (int item : ar) { // 외워
			System.out.print(item + " ");
		}System.out.println();
		
		// int 외에 7가지의 표준타입들의 문법도 모두 동일하다.
		// int[] ar = new int[] {70, 80, 90, 100};
		float[] br = new float[] { 1.0f, 2.3f, 3.14f, 12.48f};
		for( float value : br );{
			System.out.println(value + " " );
		}
		*/
		/*
		// ex55)
		// ex55-1)
		// int[] scores1 = new int[] {70, 80, 90, 100}; // 형식2
		// int[] scores2 = {70, 80, 90, 100}; // 형식3
		int[] scores = new int[4]; // 형식1
		scores[0] = 70;
		scores[1] = 80;
		scores[2] = 90;
		scores[3] = 100;
		
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			//sum = sum + scores[i];
			sum += scores[i];
		}
		System.out.println(sum);
		System.out.println("=========================");
		
		// ex55-2)
		int[] scores1 = new int[] {70, 80, 90, 100}; // 초기화
		
		int sum1 = 0;
		for (int i = 0; i < scores1.length; i++) {
			//sum1 = sum1 + scores1[i];
			sum1 += scores1[i];
		}
		System.out.println(sum1);
		
		// ex55-3)
		// new int[] 을 생략해도 되는가 ?
		// 생략해도 됩니다.
		int[] scores2 = {70, 80, 90, 100};
		
		// 이 문법이 제일 필요한 문법이다.
		// int[] scores = new int[4];
		// 정말 정말 정말 중요한 것이 클래스라는 것인데
		// int[] scores = new int[4]; 형식을 사용하게 되는데
		// 클래스를 사용할때는 배열처럼 생략할 수 없다.
		 */
		
		/*
		// ex54)
		// ex54-1)
		// 컴퓨터야 int 타입으로 메모리 8개를 한꺼번에 달라
		int[] ar = new int[8];
		System.out.println(ar.length);
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i; // ar[0] ~ ar[7]
		}
		// 출력용으로 for문을 사용해봄
		for (int i = 0; i < ar.length; i++) {
			System.out.print( ar[i] + " " );
		}System.out.println();
		
		// ex54-2)
		// 여기서 ar을 계속 사용할 수도 있고
		// 새로운 배열을 만들어서 사용할 수도 있습니다.
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i * 3;
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.print( ar[i] + " " );
		}System.out.println();
		
		// ex 54-3)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new Random().nextInt(10); // 배열은 변수가 1개 이상.
		}
		// 결과는 과연 ?
		System.out.println("==========================");
		for (int i = 0; i < ar.length; i++) {
			System.out.print( ar[i] + " " );
		}System.out.println();
		
		// ex 54-4)
		// ex) 만약 데이터가 2 7 5 6 2 5 3 3 일때
		//			결과는 9 11 7 6
		// ar.length까지 적어버리면 베스트 코드.
		for (int i = 0; i < ar.length / 2; i++) {
			// 코드를 한 줄로 작성할 수도 있지만 의도적으로
			// 2줄로 작성할 것임.
			// 알고리즘의 기초
			int sum = ar[i*2] + ar[i*2+1];
			System.out.print( sum + " " );
		}System.out.println();

		// 밑의 프로그램처럼 작성을 하면 안되지만
		// 이렇게 적어보면 규칙을 발견할 확률이 높아진다.
		// 알고리즘 능력이 뛰어나다는 것은 
		// 거의 대부분 문제에서 규칙을 발견하는 것이다.
		// System.out.println( ar[0] + ar[1] ); 
		// System.out.println( ar[2] + ar[3] );
		// System.out.println( ar[4] + ar[5] );
		// System.out.println( ar[6] + ar[7] );
		
		// ex 54-5
		System.out.println("호랑이==========================");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new Random().nextInt(10);
			System.out.print( ar[i] + " ");
		}System.out.println();
		
		// ex) 4 3 1 8 7 7 6 9
		//	   13 9 8 15
		for (int i = 0; i < ar.length / 2; i++) {
			int sum = ar[i] + ar[7-i];
			System.out.print( sum + " ");
		}System.out.println();

		// System.out.println( ar[0] + ar[7] ); 
		// System.out.println( ar[1] + ar[6] );
		// System.out.println( ar[2] + ar[5] );
		// System.out.println( ar[3] + ar[4] );
		 */
		/*
		// ex53)
		// ex53-1)
		int[] ar = new int[10];
		// ar이 사용할 수 있는 번호는 0번부터 9번까지이다.
		// Array Index OutOfBounds Exception(에러)
		// []안의 숫자가 경계영역의 범위를 벗어나서 에러가 발생했습니다. 
		// ar[-1] = 10; // 사용할 수 없다.
		// ar[10] = 10; // 사용할 수 없다.
		// ar[17] = 10; // 사용할 수 없다.
		
		// ex53-2)
		int[] br = new int[10];
		br[0] = 100;
		br[9] = 200;
		
		int num = 7;
		// 인덱스로 변수를 사용할 수 있다.
		br[num] = 300;
		// 산술 연산을 할 수 있다.
		// (단, 그 결과가 인덱스의 유효범위(0~9사이)를 벗어나면 안된다.)
		br[num-2] = 400;
		
		br[8] = br[5];
		
		// br6 = br0 * 300
		br[6] = br[0] * 300;
		
		for (int i = 0; i < 10; i++) {
			System.out.println( br[i] );
		}
		System.out.println("=================================");
		// ex53-3)
		
		System.out.println( "호랑이" ); // 줄바꿈을 한다.
		System.out.print( "코끼리" );   // 줄바꿈을 안한다.
		System.out.println( "독수리" ); // 줄바꿈을 한다.
		
		for (int i = 0; i < 10; i++) {
			System.out.print( br[i] + " " ); // 데이터가 몇개 되지 않을 때 자주 쓰는 방법.
		}
		// 아무것도 넣지 않으면 줄바꿈만 일어난다.
		System.out.println();
		System.out.println("앵무새");

		System.out.println("=================================");
		for (int i = 0; i < 10; i++) {
			System.out.print( br[i] + " " ); // 데이터가 몇개 되지 않을 때 자주 쓰는 방법.
		}System.out.println();
		
		// ex53-4)
		System.out.println("=================================");
		System.out.println( br.length );
		// 참고: String일때 tiger.length()
		
		// 베스트 코드
		for (int i = 0; i < br.length; i++) { // length가 뭐지? 복습해라.
			System.out.print( br[i] + " ");
		} System.out.println();
		*/

		/*
		// ex53)
		int [] ar = new int[10];
		
		ar[0] = 10;
		ar[7] = 20;
		ar[9] = 30;
		System.out.println( ar[0]);
		System.out.println( ar[7]);
		System.out.println( ar[9]);
		
		// 궁금해서 출력해봄.
		System.out.println( ar[5]); // 결과값 = 0 (초기 설정된 결과값(defalut)이 0)
		*/

		/*
		// ex52) 배열을 선언하는 방법
		// 배열(*****) : array
		//          = new >> 메모리 주세요 int타입으로 10개
		// 이름을 tiger로 해서 변수 10개를 만드세요.
		// 이름을 lion으로 해서 변수 15개를 만드세요.
		// int타입 10개의 메모리를 요구하고, 그 이름을
		// 타이거라고 했다.
		int[] tiger = new int[10];
		int[] lion = new int[15];
		*/
		/*
		// ex51) String
		// String을 이용해서 사용할 수 있는 명령은
		// 대충 14개 정도 된다. 그 중에 1개만 해봤다.
		// 그 1개는 length였다.
		// 숫자(정수, 실수), 문자. (신글 쿼테이션)
		// 문자열( string )     (떠블 쿼테이션)
		String tiger = "한글을 사랑하자.";
		System.out.println(tiger);
		System.out.println( tiger.length() ); // length: 길이

		String lion = "무궁화꽃이피었습니다.";
		System.out.println(lion);
		System.out.println( lion.length() ); // length: 길이
		*/
		/*
		// ex51)
		// ex51-1)
		for (int i = 0; i < 10; i++) {
			if( i == 3 ) {
				continue;
			}
			if( i == 7 ) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("=====================");
		
		// ex51-2)
		int password = 7;
		int no = 90;
		// 0일때 continue;
		// 1일때 continue;
		// 7일때만 continue;가 아니다.
		// 8일때 continue; (int no = 80; 일때)
		for (int i = 0; i < 10; i++) {
			if ( i != password ) {
				System.out.println("침입자 발생");
				continue;
			}
			System.out.println( i + "패스워드를 찾았습니다." );
			if ( no == 90 ) {
				System.out.println("구글에 로그인 되었습니다.");
				break;
			}
			System.out.println(i);
		}
		*/

		/*
		// ex50) 
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				continue; // i++로 가자.
			}
			
			if(i == 7) {
				continue; // i++로 가자.
			}
			System.out.println(i);
		}
		System.out.println("==========================");// ex50)
		for (int i = 0; i < 10; i++) {
			if(i == 5 || i == 7) {
				continue; // i++로 가자.
			}
			System.out.println(i);
		}
		*/
		
		/*
		// ex49)
		// break는 반복문을 탈출한다.
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if( i == 5 ) {
				System.out.println("탈출직전");
				break;
			}
		}
		System.out.println("프로그램 종료");
		
		// ex49-1)
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			// i는 0이 아니고, 4의 배수가 일 때 탈출하세요.
			if( i != 0 && i % 4 == 0 ) {
				System.out.println("탈출직전");
				break;
			}
		}
		System.out.println("프로그램 종료");
		 */
		/*
		// ex48)
		 
		int jumsu = 77;
		switch(jumsu / 10) {
		case 10: // 의도적으로 break를 사용 안함.
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
		*/
		/*
		// ex47)  
		 
		// 1부터 100사이의 정수를 랜덤하게 얻어서
		// 그 정수가 짝수이면 짝수단을 출력하고
		// 그 정수가 홀수이면 합산프로그램을 작성하세요.
		// ex) 10 >> 10단을 출력한다.
		// ex) 11 >> 1부터 11까지 합산 결과 출력.
		// 이거 혼자 짤 수 있으면 복습 잘한 것. = 여태까지의 내용 잘 숙지하는 것.
				
		int num = new Random().nextInt(100);
		System.out.println( "랜덤 정수는" + num + "입니다.");
		// if else를 사용할 수도 있지만
		// 연습용으로 switch를 사용할 것이다.
		switch( num % 2 ) {
		case 0:{ // 짝수 점프
			for (int i = 0; i < 10; i++) {
				System.out.println( num + "*" + i + "=" + i*num);
			}
			
		}break;
				
		case 1:{ // 홀수 점프
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println( num + "까지의 합산결과는" + sum);
		}break;
		
				
		}
		*/
		/*
		
		*/
		/*
		// ex46) switch : 분기한다. 점프한다.
		// switch 안에는 반드시 case break;가 있다.
		// ex46-1)
		switch(20) {
		case 10:
			System.out.println("호랑이");
			break;

		case 20:
			System.out.println("코끼리");
			break; // break를 만나서 switch를 탈출한다.
		
		case 30:
			System.out.println("독수리");
			break;
		}
		System.out.println("-----------------");
		
		// ex46-1)
		// switch안에 변수를 사용할 수 있다.
		int apple = 10;
		int kwi = 30;
		switch(apple) {
		case 10: 
			System.out.println("호랑이");
			break;

		case 20:
			System.out.println("코끼리");
			break; // break를 만나서 switch를 탈출한다.
				
//		case kiwi: // case 뒤에는 변수를 사용할 수 없다. (절대로)
//			System.out.println("독수리");
//			break;
		}			
		System.out.println("-----------------");

		// ex46-3)
		switch(15) {
		case 10:
			System.out.println(1000);
			break;
//		case 10: (10 두개는 불가능)
//			break;
		case 20:
			System.out.println(2000);
			break;
			
		default:
			System.out.println("나는 점프할곳이 없어요");
			break;
		}
		System.out.println("-----------------");
		
		// ex 46-4)
		switch(10) {
		case 10:
			System.out.println(1000);
			//break;
			
//		case 10: (10 두개는 불가능)
//			break;
			
		case 20:
			System.out.println(2000);
			//break;
			
		default:
			System.out.println("나는 점프할곳이 없어요");
			break;
		}
		*/
		/*
		// ex45)
		if(ture) {
			while() {
				if() {
					if() {
						while() {
							
						}
					}
				}
			}
			
			if() {
				for() {
					
				}
			}
		}
		*/
		/*
		// ex44)
		 
		// 0 100사이에 정수를 랜덤하게 계속 뽑으세요.
		// 단, 50이 나오면 프로그램을 중단하세요.
		int count = 0;
		while(true) {
			count++;
			int num = new Random().nextInt(100);
			System.out.println(count + " " + num);
			if( num == 50 ) {
				break;
			}
		}
		System.out.println("반복된 횟수는" + count);
		System.out.println("프로그램종료");
		*/
		/*
		// ex43)
		// 우박수 출력 프로그램
		// for문과 while문을 선택할 때 가장 큰 기준은
		// 반복횟수를 알고 있는가(for문), 모르는가이다. (while문)
		int num = 2021;
		while(true) {
			System.out.println(num);
			
			if( num % 2 == 0 ) { //짝수라면
				num = num / 2;
			}else {
				num = num * 3 + 1;
			}

			if(num == 1) {
				System.out.println(1); // 넣어준 것.
				System.out.println("탈출직전");
				break;
			}
		}
		System.out.println("탈출 됨.....^^");
		 */
		

/*		// ex42) 사실 ex41 예제의 형태는 거의 사용하지 않음.
		// while 문에는 ()안에 true 같은 것이 들어가는게 대부분.
		// break를 이용하여 반복문을 탈출한다.
		int ct = 0 ;
		while( true ) {
			System.out.println(ct + "독수리");
			ct++;
			if(ct > 2) {
				System.out.println("앗싸..탈출 직전");
				break; // 무한 루프 멈춤.
			}
		}
		System.out.println("무사히 탈출함");
		*/
		/*
		// ex41-1)
		int ct = 4;
		while( ct > 0 ) {
			System.out.println(ct);
			System.out.println("호랑이");
			System.out.println("코끼리");
			ct--;
		}
		System.out.println("탈출했음.");
		System.out.println("----------------------");
		
		// ex41-2)
		ct = 4;
		while( ct <= 8 ) {
			System.out.println(ct + "호랑이");
			ct++;
		}
		System.out.println("탈출했음.");
		System.out.println("----------------------");
		
		//ex 41-3
		ct = 0;
		while( ct != 3 ) {
			System.out.println(ct + "독수리");
			ct++;
		}
		System.out.println("탈출했음.");
		*/
		/*
		// ex40) while( 반복문이다. )
		 
		int ct = 4; // count의 약자를 ct
		// 이 프로그램은 무한 루프에 빠진다.
		// 강제 종료 하고 싶으면 빨간색 아이콘을 이용.
		while( ct > 0 ) {
			System.out.println("호랑이");
			System.out.println("코끼리");
		}
		*/
		/*
		// ex 39)
		int a = new Random().nextInt(10); // 외우세요.
		System.out.println(a);
		
		for (int i = 0; i < 4; i++) {
			System.out.println(new Random().nextInt(10));
		}
		*/

		/*
		// ex 38)
		
		Random rnd = new Random();
		
		int r2 = rnd.nextInt(10);
		// 임의로 8
		System.out.println(r2);
		
		for (int i=0; i < 15; i++) {
			// r2 = rnd.nextInt(10);
			// System.out.println(r2);
			System.out.println(rnd.nextInt(10));]
		}
		*/

		/*
		// ex37)
		// ex37-1)		
		// 0부터 10사이의 숫자중에서 랜덤한 숫자를
		// 얻는 프로그램. ( 0 ~ 9 )
		int r1 = (int)(Math.random() * 10);
		System.out.println(r1);
		
		// ex37-2)
		// 이 한줄의 해석은 
		// Random : 설계도
		// rnd : 이름은 내 마음대로 지었다.
		//		: 객체
		Random rnd = new Random(); // ctrl + space 눌러야 함.
		// 비행기설계도 진짜비행기 = new 비행기설계도(); // 외우세요.
		int r2 = rnd.nextInt(10);
		System.out.println(r2);
		
		for (int i = 0; i < 15; i++) {
			System.out.println( rnd.nextInt(10));
		}
		*/
				
		/*
		// ex36)
		// double Math. random()
		// ex36-1) 바로 출력
		System.out.println( "1 :" + Math.random() );
		
		// ex36-2) 받아서 출력
		double value = Math.random();
		System.out.println( "2 :" + value);
		
		// ex36-3)
		// 출력도 없고, 받아주는 놈도 없다.
		// 그냥 공중에서 데이터는 사라진다.
		Math.random();
		*/
		/*
		// ex35-1)
		
		// Math.random() : 0.0 부터 1.0
		System.out.println( Math.random() );
		System.out.println("---------------------");

		// ex35-2)
		for (int i = 0; i < 5; i++) {
			System.out.println( Math.random() );
		}
		System.out.println("---------------------");
		
		// ex35-3)
		for (int i = 0; i < 5; i++) {
		System.out.println( Math.random() * 10 );
		}
		System.out.println("---------------------");
		
		// ex35-4)
		// 0부터 9까지 정수를 랜덤하게 출력하세요. *10
		// 0부터 99까지 정수를 랜덤하게 출력하세요. *100
		for (int i = 0; i < 10; i++) {
		System.out.println( (int)(Math.random() * 100));
		}
		System.out.println("---------------------");
		*/
		/*
		// ex34-1)
		// 아스키 코드 번호는 총 128(0번부터 127번까지)개입니다.
		for (int i = 0; i < 128; i++) {
			System.out.println( i + ":" + (char)i);
		}
		
		// ex34-2)
		// 아스키 코드 번호는 총 128(0번부터 127번까지)개입니다.
		for (int i = 0; i < 10; i++) {
			System.out.println(('가'+i));
		}
		*/
		/*
		// ex33-1) A ~ Z 까지 출력하는 프로그램
		
		// 나쁜 프로그램에 해당한다.
		for (int i = 65; i < 65+26; i++) { // 영문 알파벳 갯수는 26개
			//System.out.println(i);
			System.out.println((char)i);
		}
		
		// ex33-2) A ~ Z 까지 출력하는 프로그램
		// 대문자가 총 26개이다.
		for (int i = 0; i < 26; i++) {
			System.out.println( (char)(65+i) );
		}
		// ex33-3) A ~ Z 까지 출력하는 프로그램
		// 대문자가 총 26개이다.
		for (int i = 0; i < 26; i++) {
			System.out.println( (char)('A'+ i) );
		}
		*/

		/*
		// ex32-1)
		// 제어문안에서 제어문을 사용할 수 있다.
		for (int i = 0; i < 10; i++) {
			if( i % 3 == 0) { // i의 숫자가 3의 배수라면
				System.out.println(i + "=" + "호랑이");
			}else {
				System.out.println(i + "=" + "코끼리");
			}
		}
		// ex32-2)
		// 제어문안에서 제어문을 사용할 수 있다.
		for (int i = 0; i < 20; i++) {
			if( i % 2 == 0) { // i의 숫자가 2의 배수라면
				System.out.println(i + "는 짝수입니다");
			}else {
				System.out.println(i + "는 홀수입니다");
			}
		}
*/

		/*
		// ex31)
		int sum = 0;
		System.out.println("================");
		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println("i가" + i + "일때" + "누적값 : " + sum);
		}
		System.out.println("================");
		System.out.println("for문 끝났음 : "+sum);
		*/
		/*
		// 1 ~~ 10 까지 더하면 55가 나온다.
		// 1 ~~ 100 까지 더하면 5050이 나온다.
		// 1 ~~ 1000 까지 더하면 500500이 나온다.
		// ex 30-1) 합산 프로그램이다.
		int s = 0;
		for (int i = 1; i <= 10; i++) {
			s = s + i;
		}
		System.out.println(s);
		System.out.println("----------------");
		// ex 30-2) 합산 프로그램이다.
		int s1 = 0;
		for (int i = 1; i <= 10; i++) {
			s1 = s1 + i;
		}
		System.out.println(s1);
		System.out.println("----------------");

		// ex 30-3) 합산 프로그램의 결과는 일반적으로
		// sum이라는 변수를 많이 사용한다.
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		System.out.println("----------------");

		// ex 30-4) 합산 프로그램의 결과는 일반적으로
		// sum이라는 변수를 많이 사용한다.
		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			// sum1 = sum1 + i;
			sum1 += i;
		}
		System.out.println(sum1);
		*/
		
		/*
		// ex 30)
		int number = 4;
		for (int i = 0; i < 10; i++) {
			System.out.println( number + "*" + i + "=" + (number*i) );
		}
		*/
		
		/*
		// ex29) 5단을 출력하는 프로그램을 작성해보자. (자습해보기)
		for (int i = 0; i < 10; i++) {
			// 괄호로 묶어주는 것을 선호한다.
			System.out.println( 5 + "*" + i + "=" + (5*i) );
			// System.out.println( 5 + "*" + i + "=" + 5*i );
					
		}
				
			// 괄호 연산 우선 순위의 예제
			System.out.println( (3 + 5) * 2);
			System.out.println( 3 + (5 * 2));
			System.out.println( 3 + 5 * 2); // 곱하기가 우선 순위가 높음.
											// 결과적으로 위의 문제와 동일.
											 */
		
		
										

		/*
		// ex28) 단축기 사용 방법
		// for(int a = 0; a < 반복횟수; a++) {
		// }
		
		// 단축기 사용 방법 for ctrl + enter Tap 누르고
		for (int i = 0; i < 5; i++) {
			
		// }
		*/

		/*
		// ex27) for문 : 대빵입니다.
		// 반복 처리, 반복 작업, 반복 수행, 반복 동작
		// ex27-1) 결과: 0 1 2 3
		System.out.println("반복시작");
		for(int a = 0; a<4; a++) {
			System.out.println(a);
		}
		System.out.println("반복끝");
		
		// ex27-2) 결과: 2 3 4
		for(int a = 2; a<5; a++) {
			System.out.println(a);
		}
		System.out.println("----------------");		
		
		// ex27-3) 결과: 2 3 4 5
		for(int a = 2; a<=5; a++) {
			System.out.println(a);
		}
		System.out.println("----------------");		
		
		// ex27-4) 결과: 없다. (반복 못한다.)
		System.out.println("호랑이");
		for(int a = 2; a>5; a++) {
			System.out.println(a);
		}
		System.out.println("코끼리");
		System.out.println("----------------");
		
		// ex27-5) 결과: 0 3 6
		for(int a = 0; a < 7; a = a + 3) {
			System.out.println(a);
		}
		System.out.println("----------------");
		
		// ex27-6) 
		// for( 변수초기화 ; 조건 ; 증가 or 감소 )
		// 1. 변수초기화는 거의 대부분 0으로 초기화 한다.
		// 2. 조건은 거의 대부분 (<) 라고 하는 비교 연산만 사용한다.
		// 3. 증가or 감소는 거의 대부분 ++만 사용한다.)
		// 밑의 문장은 몇 번 반복할까요 ? 7번 반복한다. < 7의 7은 반복횟수. 
		// ex) a < 1234면 1234번 반복함.
		for(int a = 0; a < 7; a++) {
			System.out.println(a);
		}
		System.out.println("----------------");

		// ex27-7)
		// 1. 변수초기화는 가끔 1으로 초기화하는 경우가 있음. (2는 없다.)
		// 2. 조건은 <=를 사용한다.
		for(int a = 1; a <= 3; a++) {
			System.out.println(a);
		}
		System.out.println("----------------");
		*/


/*
		// ex26-2)
		// 형식1
		if() {
		}
		
		// 형식2
		if() {
			
		} else {
			
		}
		
		//형식 3
		if () {
		} else if(){
			
		} else if(){
		
		} else {
			
		}
*/
		
		/*
		// ex 26) 
		int x = 10; // 38 17
		// 8 3 >> 짝수 홀수 >> 호랑이
		// 8 4 >> 짝수 짝수 >> 독수리
		// 7 3 >> 홀수 홀수 >> 코끼리
		// 7 4 >> 홀수 짝수 >> 앵무새
		
		// 숫자를 분리하자.
		int q = x / 10; // 몫 : 8
		int r = x % 10; // 나머지 : 3
		System.out.println( q + " " + r);
		if( q % 2 == 0 ) { // 첫번째 숫자가 짝수 입니까.
			if( r % 2 == 0) { // 두번째 숫자가 짝수 입니까.
				System.out.println("독수리");
			}else { // 홀수
				System.out.println("호랑이");
			}
		}else { // 무조건 홀수
			 if (r % 2 == 0 ) { // 두번째 숫자가 짝수 입니까.
					System.out.println("앵무새");
				}else { // 홀수
					System.out.println("코끼리");
				}
		*/
	
		/*
		// ex 25) n개 중에서 1개를 선택하고 싶다면 어떻게 ?
		
		// ex 25-1)
		// 3개중에서 1개 선택하는 프로그램
		int a = 3, b = 2;
		if( a == b ) {
			System.out.println("호랑이");
		} else if ( !(a+1 == b+2) ) {
			System.out.println("코끼리");
		} else { 
			System.out.println("앵무새");
		}
		System.out.println("--------------------------");
		
		// ex 25-2)
		int num = 65; // number의 약자.
		
		if( num <= 100 ) {
			System.out.println("호랑이");
			if( num > 90 ) {
				System.out.println("당신의 학점은 A입니다.");
			} else if ( num > 80 ) {
				System.out.println("당신의 학점은 B입니다.");
			} else if ( num > 70 ) {
				System.out.println("당신의 학점은 C입니다.");
			} else if ( num > 60 ) {
				System.out.println("당신의 학점은 D입니다.");
			} else { 
				System.out.println("당신의 학점은 F입니다.");
			}
		} else {
			System.out.println("점수가 좀 이상한데요.");
		}
		
		*/

/*

		// ex 24) 둘중에 1개를 선택하는 if(){} else{}
		int num = 1234567;
		System.out.println( num / 2); // 몫
		System.out.println( num % 2); // 나머지
		
		if( num % 2 == 0  ) {
			System.out.println("짝수:호랑이");
		}else {
			System.out.println("홀수:독수리");
		}

*/
		/*
		// ex 23) 
		// 참 중요한 용어이다.
		// 문자 : 1개만 			: '', (싱글 쿼텐션) char
		// 문자열 : 1개이상을 의미	: "", (더블 쿼텐션) string
		
		// char는 양수만 쓸 수 있다.
		char a = 20;
		System.out.println(a + 10);
		
		// 다른 정수 타입과 다르게 산술연산을 목적으로 하는 타입이 아닙니다.
		// char는 문자를 받는 것을 목적으로 하는 타입이다.
		// b는 문자A에 약속된 아스키 코드 번호를 대입받는다.
		char b = 'A';
		// 일단, b가 무슨 타입인지 확인한다.
		System.out.println(b);
		System.out.println( (int)b ); // 아스키 코드 번호 65가 출력됨.
		System.out.println("=================");
		int c = 66;
		System.out.println(c);
		System.out.println( (char)c); // 아스키 코드 번호 66에 해당하는 'B'가 출력됨.
		System.out.println("=================");
		// 유니코드 번호가 대입된다.
		char d = '지';
		System.out.println(d);
		System.out.println( (int)d );
		System.out.println("=================");
		// 스페이스와 탭은 눈에 안보이는 문자이다. 
		// 그래서 스페이스와 탭은 아스키코드 번호가 존재한다.
		
		// 숫자도 문자일 수 있다.
		char e = '8';
		System.out.println(e);
		System.out.println( (int)e );
		System.out.println("=================");
		
		System.out.println( "Char은" + Character.BYTES + "바이트 입니다." );
		System.out.println( "Short는" + Short.BYTES + "바이트 입니다.");
		System.out.println( "long은" +Long.BYTES + "바이트 입니다.");
		*/

		/*
		// ex 22)
		int a = 3, b = 0;
		System.out.println(1);
		if( a > b) {
			System.out.println(2);
			System.out.println(3);
			System.out.println(4);
			if ( a+10 > 20) {
				System.out.println(1000);
				System.out.println(2000);
			}
			if ( a + 10 < 20) {
				System.out.println(3000);
				System.out.println(4000);
			}
		}
		System.out.println(5);
		*/
		/*
		// ex 21) if 제어문, for 제어문, while 제어문, switch 제어문
		// if 문, for 문, while 문, switch 문
		// if () {}, for () {}, while () {}, switch () {}
		
		// ex 21-1)
		// if(조건) {
		// 컴퓨터는 조건에 대해서 결과적으로 무조건 참/거짓만 판단한다.
		// 와아 참이다~~ >> 스코프로 들어가자.
		// 와아 거짓이다~~ >> 스코프는 패스.
		System.out.println(1);
		if(true) { 
			System.out.println(2);
		}
		System.out.println(3);
		if(false) { 
			System.out.println(4);
		}
		System.out.println(5);
		System.out.println("===============");
		
		// ex20-2)
		System.out.println(1);
		if(3>2) { 
			System.out.println(2);
		}
		System.out.println(3);
		if(3>1000) { 
			System.out.println(4);
		}
		System.out.println(5);
		System.out.println("===============");
		
		// ex20-3)
		int a = 10, b = 20;
		System.out.println(1);
		if( b > a) { 
			System.out.println(2);
		}
		System.out.println(3);
		if( b > a+50) { 
			System.out.println(4);
		}
		System.out.println(5);
		
		System.out.println("===============");
		
		// ex 20-4)
		int c = 10, d = 20;
		System.out.println(1);
		if(true || false) { 
			System.out.println(2);
		}
		System.out.println(3);
		if(true && false ){ 
			System.out.println(4);
		}
		System.out.println(5);
		*/
		/*
		// ex 20)
		// bit 연산( 전구끼리 논리 연산을 하는 모양이다.)
		// bit 연산은 프로그램에서 중요합니다. 
		// 지금 안합니다.
		// 자바라고 하는 산을 보고 나서 그 때 bit 연산해도 안늦습니다.
		 */

		/*
		// ex 19) exclusive OR
		// &&, ||, ^
		
		//    ||
		// A     B
		// F  F  F
		// F  T  T
		// T  T  F 
		// T  T  T
		

		//   &&
		// A     B
		// F  F  F
		// F  F  T
		// T  F  F 
		// T  T  T
		

		//    ^    // 쌍쌍파티
		// A     B
		// F  F  F
		// F  T  T
		// T  T  F 
		// T  F  T
		
		System.out.println( false ^ false);
		System.out.println( false ^ true);
		System.out.println( true ^ false);
		System.out.println( true ^ true);
		*/
		/*
		// ex 18) ++변수, 변수++
		int a = 10;
		int b;
		b = a++; // a++은 >> 1. 대입하고 2. 증가. ( a--는 대입 감소 )
		System.out.println(a + " " + b);
		
		int c = 10;
		int d;
		d = ++c; // 1. 증가하고 2. 대입.
		System.out.println(c + " " + d);
		
		a++;
		++c;
		
		System.out.println(!true);
		*/
		/*
		// ex 17)
		int a = 10;

		System.out.println(a);
		a = a + 1;
		System.out.println(a);
		
		a = a + 10;
		System.out.println(a);
		
		
		// ark 가지고 있는 내용에서 1을 더한다.
		// 증가연산자라고 한다.
		a++;  a=a+1; // 와 결과적으로 똑같다.
		System.out.println(a);
		
		// 증가 연산자.
		++a;
		System.out.println(a);
		System.out.println("====================");
		
		a--;
		--a;
		System.out.println(a);
		
		// 복합대입연산자. ( += )
		// 번역속도 좀 더 빠름.
		a += 7; // == (a = a + 7;) 둘은 동격코드이다.
		System.out.println(a);
		
		int apple = 123
		apple += 73 // apple = apple + 73;
		System.out.println(apple);
		
		int banana = 3;
		banana *= 2; // banana = banana * 2;
		
		int tiger = 16;
		tiger %= 4; // tiger = tiger % 4 
		
		int t1 = 10, t2 = 20;
		t1 = t2 + 10;
		*/
		
	/*
		// int >> type
		// a >> 변수
		// = >> 대입연산자
		// 100 >> 리터럴
		int a = 100;
		
	*/

	/*
	 	// 참고
		int a;
		int b = 10;
		int c;
		// 문장이 잘못된 이유 ?]
		// 초기화 되지 않은 변수는 사용할 수 없다.
		c = a + b
		System.out.println(c);
	*/	
	
		/*
		// 참고
		int a = 10; // 이 문장은 기계어로 컴파일되면
					// 밑의 문장으로 번역된다.
		int b;
		b = 10;
		
		*/
/*
		// ex16)   (중요!!)
		// 컴퓨터야 메모리 1개 주세요.
		// 1개의 단위는 1byte. = 8bit
		// 컴퓨터야 메모리 1byte 주세요.
		byte num; // 8bit >> 경우의 수는 총 256가지
					// -128 ~ +127
		// byte -128 ~ +127
		// short : +- 삼만정도.
		// int : +- 20억정도. (기억 정도만 하세요.)
		
		num = 120;
		num = -120;
		// num = 128; // X
		num = 127;
		// num = -129;
		num = -128;
		System.out.println(Byte.MIN_VALUE); // BYTE 도트
		System.out.println(Byte.MAX_VALUE);
		
		// 2byte 주세요.
		short b; // 16bit >> -2^15 ~ +2^15-1
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		// 4byte 주세요.
		int c; // 2^32
		System.out.println(Integer.MIN_VALUE); // int가 integer의 약자.
		System.out.println(Integer.MAX_VALUE);
		
		// 8byte 주세요.
		long d; // 2^64
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		// short(양, 음수 모두), char(양수만)
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println("==================");
		System.out.println( (int)Character.MIN_VALUE); // char는 character의 약자.
		System.out.println( (int)Character.MAX_VALUE);
*/

/*
		// ex15) 부정연산
		// !뒤는 모두 부정이다.
		System.out.println(!false);
		System.out.println(!(3>2)); // 괄호가 우선
		// false || ture || false 
		System.out.println(!(3<2 || 5>2 || false));
*/ 

/*
		// false or true or false => true
		System.out.println(3<2 || 5>2 || false); 
		// false or false or false => false
		System.out.println(3<2 || 5<2 || false);
		// 
		System.out.println(true && true && false);
		//
		System.out.println(true && true && 4>2);
*/

/*
		// ex14) 논리연산자. (논리 and = && )
		 
		System.out.println(false && false);
		System.out.println(false && true);
		System.out.println(true && false);
		System.out.println(true && true);
		System.out.println("--------------");
	
		int money = 100;
		int key = 0;
		System.out.println(money<=0 && key!=0);
		System.out.println(money<=0 && key==0);
		System.out.println(money>0 && key==-1);
		System.out.println(money>0 && key==0);
	
		System.out.println("--------------");
		
		// 성문을 열어 주는 조건.
		// 돈이 1,000원 이상 있고
		// 열쇠가 있으면 문을 열어주세요. (true)
		int money = 500;
		int key = 2;
		System.out.println(money>=1000 && key>0);
*/

/*
		// ex13) 논리연산자. (논리 or = ||)
		// (프로그래밍 입문할 때 여기서 한 번 막히게 됨.)
		// A단자 B단자  결과
		// OFF  OFF   X
		// OFF   ON   O
		// ON   OFF   O
		// ON    ON   O
		
		// 스위치를 누르지 않는 상태를 0 이라고 표현한다.
		// 스위치를 누른 상태를 1 이라고 표현한다.
		// 전류가 흐르지 않는 상태 0 이라고 표현한다.
		// 전류가 흐르는 상태를 1 이라고 표현한다.
		
		// 간략화된 표현 (논리 OR = || 라고 한다.)
		// A단자 B단자 결과
		// 0    0    0
		// 0    1    1
		// 1    0    1
		// 1    1    1
		// 컴퓨터에서는 0이 아닌 모든 숫자를 참으로 해석한다.
		
		System.out.println( false || false ); // 0 0 
		System.out.println( false || true );  // 0 1
		System.out.println( true || false );  // 1 0
		System.out.println( true || true );   // 1 1
		
		System.out.println("-------------");
		System.out.println( 2 > 10 || 5 < 4 );  // 0 0 
		System.out.println( 2 > 10 || 5 > 4 );  // 0 1
		System.out.println( 2 < 10 || 5 < 4 );  // 1 0
		System.out.println( 2 < 10 || 5 > 4 );  // 1 1
*/

/*		// ex12) 산술연산자, 비교(관계)연산자, 논리연산자. => 순서대로 외우셈.
		// 비교(관계) 연산자 (총 6개가 있다.)
		// >, <, >=, <=, ==, !=
		System.out.println(5>3);
		System.out.println(5<3);
		System.out.println(3>=3); // 크거나 같은가? =>는 안됨.
		System.out.println(3<=2); // 작거나 같은가?  
		System.out.println(10==10); // 정말주의 =이 1개 아님
		System.out.println(20!=10); // !는 다르냐고 물어보는것
		System.out.println(100!=100); // !는 다르냐고 물어보는것
		System.out.println("----------");
		int a = 10, b = 20;
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(a>=b);
		System.out.println(a<=b);
		System.out.println(a==b);
		System.out.println(a!=b);
*/

/*
		// ex11) 변수 작명법.
		// 1. 이름은 중복해서 선언될 수 없다.
		// 2. 대소문자는 서로 다른 변수다. (apple, Apple 둘은 다름)
		// 3. 숫자와 섞어서 만들 수 있다. (단, 첫 글자는 숫자면 안됨)
		// 4. 특수문자는 사용할 수 없다. (!@#^&) (단, _, $은 사용할 수 있다.)
		// 5. 한글을 변수명으로 사용할 수 있지만, 대부분의 프로그래머는 사용하지 않는다.\
		// 6. 한 단어 이상일 때는 카멜표기법을 사용한다.(대문자로 구분)
		// 7. 변수명이 특별한 의미를 가지지 않을 때는 아래와 같이 쓴다.
		// a, b, c, x, y, z, i, j, k, temp(임시)
		// a1, a2, a3, ii, jj, kk
		int apple;
		int Apple;
		int apple2021;
		// int 9apple; << 안 된다.
		int _app_le;
		int $apple;
		//int *apple; << 안 된다.
		int 사과;
		int AppleNumber; // applenumber
		//int app le; 띄어쓰기 또한 특수문자.
*/

/*
		// 21/3/5 수업내용 끝. ex10) 
		// 쉬우면서도 중요한데, 죽어도 안지킴.
		int a = 10; // 4개의 메모리 주세요
		short b = 20; // 2개의 메모리 주세요
		
		// 대입 연산자(=)는 반드시 쌍방간에 타입이 같아야 한다.
		// 다르면 아주 안좋은 프로그램이다.
		// 왜요? 쌍방간에 타입이 다르기 때문에
		a = b; // 4개짜리 = 2개짜리 (기계어: 일단은 허락해줄게. 문제가 발생할 것 같지는 않으니까)
		// 아주 더 안좋은 프로그램이다.
		// b = a; // 2개짜리 = 4개짜리 (에러가 뜬다)

		// float = int;
		// int = boolean;
*/
		
/*
		// ex9) 표준 8개 "타입."
		// 정수만 다룰 수 있다.
		// 1개 주세요
		byte a;
		
		// 2개 주세요 (어떤 명령어를 쓰던 간에 2개 줌)
		char b;		// 양수만 다룰 수 있다. (문자를 다룬다.)
		short c;	// 양, 음수 같이 다룰 수 있다.
		
		// 4개 주세요
		int d;
		
		// 8개 주세요
		long e;
		
		// ==================================
		// 소수를 다룰 수 있다. 예. 3.14 21. 689
		4개 주세요
		float f;
		// 8개 주세요
		double g;
		
		// ==================================
		// 1개 주세요 ( 참 과 거짓 )
		boolean h;
*/

/*
		// ex8) 데이타 교환 프로그램
		// swap 프로그램
		int a=10, b=20, t;
		System.out.println(a + " " + b);
		
		// 프로그램 세줄을 외우세요. 너무나도 유명함. (사진6 참고)
		t = a; // t =10
		a = b; // a= 20
		b = t; // b= 10
		
		System.out.println(a + " " + b);
*/	

/*
		// ex7) 
		int a = 10, b;
		System.out.println(a);
		// 에러가 발생한다. (아무것도 기억못하는 애한테 시키면 안되
		// System.out.println(b);
		b = 20;
		System.out.println(b);
		// 대입 연산자가 나타났다. ( = )
		// b가 기억하고 있는 값을 a에 기억시켜라.
		a = b; // <<<<====
		System.out.println("----------");	
		System.out.println(a);
		System.out.println(b);
		
		// 대입은 가장 나중에 한다. (맨 마지막에)
		a = b + 30;
		System.out.println("----------");
		// 한줄로 출력하고 싶을 때
		System.out.println(a + " " + b);
		
		b = a * 2 + 30;
		System.out.println("----------");
		System.out.println(a + " " + b);
		
		// 
		a = a + b;
		System.out.println("----------");
		System.out.println(a + " " + b);
		
		// 가장 최근의 기억을 갖게 됨.
		a = 1000;
		b = 2000;
		System.out.println("----------");
		System.out.println(a + " " + b);
*/

/*
		// ex6) 변수 선언(메모리주세요: 이름 작명)과 초기화 방법(숫자 기억)
		// ex6-1)
		// 컴퓨터야 4개의 메모리 주세요.
		// 그 이름은 a이다.
		// 숫자 10을 기억해라.
		int a = 10;
		
		// ex6-2)
		// 이름은 중복해서 작명할 수 없다.
		// 두개 다 쓸 수 있는 문법. (어느게 좋다는 없음)
		int b;
		b = 20;
		
		// ex6-3)
		// 콤마를 이용해서 연속해서 메모리를 여러 개 요구 할 수 있다.
		int c = 30, d = 40, e=50;
		
		// ex6-4)
		int f, g, h;
		f = 60;
		g = 70;
		h = 80;
		// 단, 주의 할 코드(잘못된 코드)는 아래와 같다.
		// f = 60, g = 70, h = 80;
		
		// 1개만 확인
		System.out.println( f );
*/

/*
		// ex5)
		// 박스 4개 주세요(메모리 4개주세요)
		int monkey; // 타입 변수(명);
		int dog; // 타입 변수(명);
		// 메모리 안에 숫자를 기록한다.
		// (=) 대입 연산자라고 한다.
		// 대입 연산은 항상 우측에서 좌측으로 대입된다.
		monkey = 200; // <<<<<<=====
		System.out.println( monkey );
		dog = 40;
		System.out.println( dog );
		System.out.println( "----------------"); // 헷갈리니까 구분하려고
		System.out.println( monkey + dog );
		System.out.println( monkey - dog );
		System.out.println( monkey * dog );
		System.out.println( monkey / dog );
		System.out.println( monkey % dog );
		
		// int >> 메모리 4개주세요 >> 전문용어로 타입(type)
		// monkey >> 변수(기억할 수 있는 숫자가 변할 수 있다.)
*/

/*
 		// ex4) 문자열 연결
 		System.out.println( 16 + 3 ); // 숫 + 숫
		System.out.println( 16 + "3" ); // 숫 + 문
		System.out.println( "16" + 3 ); // 문 + 숫
		System.out.println( "16" + "3" ); // 문 + 문
		System.out.println( "호랑이" + "코끼리" ); // 문 + 문
		System.out.println( 100 + "코끼리" ); // 숫 + 문
		System.out.println( 100 + "코끼리" + 200 ); // 숫 + 문 + 숫
		System.out.println( 100 + 200 + "코끼리" ); // 숫 + 숫 + 문
		System.out.println( "코끼리" + 100 + 200 ); // 문 + 숫 + 숫
*/


/*
		// ex3) 산술연산자. ( +, -, *, /, % )
		System.out.println( 16 + 3 );
		System.out.println( 16 - 3 );
		System.out.println( 234567 * 1254 ); // x 아님
		System.out.println( 16 / 3 ); // 몫
		System.out.println( 16 % 3 ); // 나머지
*/
		
/*
		
		// ex2) 숫자와 문자열 
		// Alt + 방향키 : 한줄 혹은 한줄이상 코드 옮기기
		// 출력은 크게 숫자 아니면 문자(열)
		// 숫자는 " "를 사용하지 않는다.
		// 문자(열)은 반드시 " "을 사용한다.
		// 문자 1개는 문자라고 하고
		// 문자 1개 이상은 문자열이라고 합니다.
		// a << 문자다. apple << 문자열
		// 문자열을 영어로 string이라고 한다.
		
		System.out.println( 100 );
		System.out.println( "호랑이" );
		// 쿼텐셜안에 있으니깐 문자열임. 숫자처럼 보이는 문자열이다.
		System.out.println( "200" );
*/

/*
		//EX1)
		System.out.println("호랑이");
		// 밑의 문장은 주석입니다.
		// 주석은 컴파일이 되지 않는다.
		// System.out.println("코끼리");
		// System.out.println("독수리");
		// 전체주석은 사이에 있는 문장은 주석처리된다.		
		//System.out.println("독수리2");
		//System.out.println("독수리3");
		//System.out.println("독수리4");
*/

package Pack;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server Start");
		try {
			ServerSocket ss = new ServerSocket();			
			ss.bind(new InetSocketAddress("localhost", 5001));
			System.out.println("기다리고 있음");
			Socket ts = ss.accept(); 
			System.out.println("누군가 접속됨");
			
			InputStream is =ts.getInputStream();
			//클라이언트에서 데이터가 오기를 기다린다.
			//블로킹 함수이다.
			
			for (int i = 0; i < 4; i++) {
				System.out.println("데이터가 오기를 기다림.");
				byte []bt = new byte[512];
				int size = is.read(bt);
				String s = new String(bt, 0, size);
				System.out.println(s);
			}
			
			(new Scanner(System.in)).nextInt();
			
			// 완료된 것은 아니다.
			//System.out.println(bt + " " + size);

			System.out.println("서버 종료됨.");
			
			/*
			OutputStream os = ts.getOutputStream();
			String s1 = "독수리";
			byte[] ct = s1.getBytes();
			os.write(ct);
			(new Scanner(System.in)).nextInt();	*/

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}

package Pack;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Client Start");
		
		try {
			System.out.println("접속하기 일보직전");		
			Socket cs = new Socket();
			cs.connect(new InetSocketAddress("localhost", 5001));
			
			for (int i = 0; i < 4; i++) {
				(new Scanner( System.in )).nextInt();
				OutputStream os = cs.getOutputStream();
				String s = "호랑이" + i;
				byte[] bt = s.getBytes();
				os.write(bt);				
			}
			
			OutputStream os = cs.getOutputStream();
			System.out.println("클라이언트 종료됨.");
			/*
			// 새로 들어 온 코드
			InputStream is = cs.getInputStream();
			System.out.println("데이터가 오기를 기다림.");
			
			byte []ct = new byte[512];
			int size = is.read(ct);
			// 완료된 것은 아니다.
			System.out.println(ct + " " + size);
			String s1 = new String(ct, 0, size);
			System.out.println(s1);
			(new Scanner(System.in)).nextInt();
			*/
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


