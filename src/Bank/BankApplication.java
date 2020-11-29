package Bank;

import java.util.Scanner;

public class BankApplication {
	private static Account[] acconutArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	private static int count =0;
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("=======================");
			System.out.println("1.계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("=======================");
			System.out.println("선택>");
			
			int selectNo = sc.nextInt();
			
			if(selectNo ==1) {
				createAccount();
			}else if(selectNo ==2){
				accountList();
			}else if(selectNo ==3) {
				deposit();
			}else if(selectNo ==4) {
				withdraw();
			}else if(selectNo ==5) {
				run = false;
			}
			
		}
		System.out.println("프로그램 종료");	
	}
	//계좌 생성하기
	private static void createAccount() { //작성위치
	System.out.println("-------");
	System.out.println("계좌생성");
	System.out.println("-------");
	System.out.println("계좌 번호:");
	String ano = sc.next();
	
	System.out.println("계좌주:");
	String owner = sc.next();
	
	System.out.println("초기 입금액:");
	int money =sc.nextInt();
	
	acconutArray[count++] = new Account(ano, owner,money);
	System.out.println("결과 :계좌가 생성되었습니다");
		}
	
    
	//계좌 목록 보기
	private static void accountList() {//작성위치
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		for (int i =0; i<count; i++) {	
			System.out.println(acconutArray[i].getAno() +"\t"+acconutArray[i].getOwner()
					+"\t"+acconutArray[i].getBalance());
		}
    }
	//예금 하기
	private static void deposit() {//작성위치,findAccount호출해서 이용
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");
		System.out.println("계좌번호");
		String ano = sc.next();
		System.out.println("예금액:");
		int dep = sc.nextInt();
		
		if(findAccount(ano)==null) {
			System.out.println("입력한 계좌 번호를 찻지 못했습니다");
		}else {
			findAccount(ano).setBalance(findAccount(ano).getBalance()+dep);
			System.out.println("결과 : 입금이 성공되었습니다");
		}
	}
	//출금 하기
	private static void withdraw() {//작성위치, findAccount호출해서 이용
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		System.out.println("계좌번호");
		String ano = sc.next();
		System.out.println("예금액:");
		int withd = sc.nextInt();
		
		if(findAccount(ano)==null) {
			System.out.println("입력한 계좌 번홀르 찻지 못했습니다");
		}else {
			if(withd>findAccount(ano).getBalance()) {
				System.out.println("잔액보다 큰액수를 입력 하셨습니다");
			}else {
				findAccount(ano).setBalance(findAccount(ano).getBalance()- withd);
				System.out.println("결과 : 출금이 성공되었습니다");
			}
		}
	}
	private static Account findAccount(String ano) {
		for(int i =0; i <count; i++) {
			if(acconutArray[i].getAno().equals(ano)) {
				return acconutArray[i];
			}
		}
		return null;
	}
}
