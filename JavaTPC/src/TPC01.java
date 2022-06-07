import kr.bit.Book;
import kr.bit.PersonVO;

public class TPC01 {

	public static void main(String[] args) {
		System.out.println("Hello Java");

		// 프로그래밍의 3대 요소 : 변수, 자료형(DataType), 할당(=)
		// 변수(Variable) : 데이터를 저장할 메모리 공간의 이름
		// 자료형(Data Type) : 변수의 크기와 변수에 저장될 데이터의 종류를 결정하는 것 (셋 중 가장 중요)
		// 할당(Assig) : 변수에 값을 저장(대입, 할당)하는 것
		
		// 책 1권을 저장하기 위한 변수 선언
		// 변수는 하나의 값을 가리키게 되어있음. 그러나 Book이라는 객체는 책의 여러개 속성들이 여러개의 변수로 정의되어 있음
		// 따라서 변수 b에는 book이 담겨있는 것이 아니라, book이라는 객체가 생성되면 만들어지는 메모리의 번지를 가리키도록 번지가 저장됨 => 이러한 번지를 저장하는 것을 객체를 생성한다,라고 함
		// 기본자료형(PDT):정수, 실수, 문자, 참거짓 vs 사용자정의자료형(UDDT):객체자료형(사용자가 설계)
		
		// b는 객체를 저장하기 위한 객체(변수)(=>객체변수에서 변수를 생략하고 객체로 부름)
		Book b;
		b = new Book(); // ~() -> 생성자 함수. 미리 book이라고 설계한 대로 메모리 어딘가에 새로운 객체.실체(인스턴스)를 생성
		b.title = "자바";
		b.price = 15000;
		b.company = "한빛미디어";
		b.page = 700;
		
		PersonVO p = new PersonVO(); // PersonVO p; + p=new PersonVO();
		p.name = "박매일";
		p.age = 40;
		
		System.out.println(p.name);
		
		
	}

}
