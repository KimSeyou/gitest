package Calculator_240502;
import java.util.*;

public class Infix2Postfix {
	public static String convert(String exp) {
		// 입력된 수식이 null이거나 길이가 0이면 null을 반환
		if(exp == null || exp.length() == 0) return null; 
		
		// 입력된 수식을 연산자('+', '-', '*', '/')와 연산자를 기준으로 분리하는 StringTokenizer를 생성
		StringTokenizer st = new StringTokenizer(exp, "+-*/()", true);
		// 후위 표기법으로 변환할 때 연산자를 저장할 스택을 생성
		Stack<String> stack = new Stack<String>();
		// 변환된 후위 표기법을 저장할 StringBuffer를 생성
		StringBuffer buf = new StringBuffer();
		
		// StringTokenizer가 토큰을 가지고 있으면 반복
		while(st.hasMoreTokens()) {
			String tok = st.nextToken();
			System.out.printf("token => %s %n", tok); //토큰이 나눠지는지 확인하기 위한 출력
			// 토큰이 연산자인지 확인
			if(opType(tok) > 0) {
				// 스택이 비어 있지 않고, 스택의 맨 위 요소가 연산자이며, 스택의 맨 위 연산자의 우선순위가 현재 토큰의 우선순위보다 크거나 같을 때 반복
                while (!stack.empty() && opType(stack.peek()) > 0 
                		&& getPriority(stack.peek().charAt(0)) >= getPriority(tok.charAt(0))) {
                    // 스택에서 연산자를 꺼내 buf에 추가
                	buf.append(stack.pop());
                    buf.append(" ");
                }
                // 현재 토큰을 스택에 추가. trim() 메소드는 문자열 양쪽의 공백 제거
                stack.push(tok.trim());
            } else if (tok.equals("(")) {
                stack.push(tok.trim());
            } else if (tok.equals(")")) {
            	// 스택이 비어있지 않고, 스택의 맨 위 요소가 여는 괄호가 아닌 동안 반복
                while (!stack.empty() && !stack.peek().equals("(")) {
                    buf.append(stack.pop());
                    buf.append(" ");
                }
                if (!stack.empty()) {
                	// ( 제거
                    stack.pop();
                }
            } else { // 숫자일 경우
                buf.append(tok.trim());
                buf.append(" ");
            }
        }
		
		//  스택이 비어있지 않은 동안 반복
		while(!stack.empty()) {
			// 스택의 연산자를 후위 표기법 문자열에 추가
			buf.append(stack.pop());
			buf.append(" ");
		}
		System.out.printf("postfix => %s%n", buf.toString()); // 후위 표기법으로 변환된 문자열을 확인하기 위한 출력
		System.out.println();
		// 후위 표기법으로 변환된 문자열을 반환
		return buf.toString().trim();
	}
	
	// 토큰이 연산자인지 피연산자인지 확인하는 메서드
	public static int opType(String op) {
		// 입력된 연산자의 공백 제거
		op = op.trim();
		// 연산자의 길이가 1보다 크거나 0일 때
		if(op.length() > 1 || op.length() == 0) {
			// 유효하지 않은 연산자로 판단. -1 반환
			return -1;
		}
		// 연산자의 첫 번째 문자를 가져옴
		char c = op.charAt(0);
		
		switch(c) {
			case '+':
				return 1;
			case '-':
				return 2;
			case '*':
				return 3;
			case '/':
				return 4;
		}
		return -1;
	}
	
	// 연산자 op를 입력받아 우선순위 값을 반환. private로 클래스 내부에서만 사용 가능
	private static int getPriority(char op) {
		switch(op) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '(':
				return 0;
			default:
				return -1;
		}
	}
}