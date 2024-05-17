package Calculator_240502;
import java.util.*;

public class Calc {
	// 산술 표현식을 문자열 형태로 받아서 이를 평가하여 double 값으로 반환
	public static double eval(String exp) {
		// 문자열을 특정 구분자로 분할. exp는 산술 표현식을 나타내는 문자열
		StringTokenizer st = new StringTokenizer(exp);
		// double 값을 거장하는 스택을 생성. 제네릭 사용
		Stack<Double> stack = new Stack<Double>();
		
		// StringTokenizer가 토큰을 가지고 있으면 반복
		while(st.hasMoreTokens()) {
			// 다음 토큰 가져오기
			String tok = st.nextToken();
			// 토큰이 연산자인지 피연산자인지 확인
			if(Infix2Postfix.opType(tok) > 0) {
				// 토큰이 연산자라면 스택에 피연산자 두 개를 꺼내서 해당 연산 수행
				double v1 = stack.pop();
				double v2 = stack.pop();
				// 결과값을 저장할 value 변수 생성. 0으로 초기화
				double value = 0;
				// 연산자 타입에 따라 연산을 수행
				switch(Infix2Postfix.opType(tok)) {
					case 1: // '+'
						value = v2 + v1;
						break;
					case 2: // '-'
						value = v2 - v1;
						break;
					case 3: // '*'
						value = v2 * v1;
						break;
					case 4: // '/'
						value = v2 / v1;
						break;
				}
				// 계산 결과를 다시 스택이 삽입
				stack.push(value);
			} else {
				// 토큰이 피연산자라면 이를 double로 변환하여 스택에 삽입
				stack.push(Double.parseDouble(tok));
			}
		}
		// 결과값 반환
		double result = stack.pop();
		return result;
	}
}