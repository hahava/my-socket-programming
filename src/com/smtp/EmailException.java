package com.smtp;

import java.io.BufferedReader;
import java.io.IOException;

public class EmailException extends Exception {

	public EmailException() {

	}

	public EmailException(String num) {
		super(num);
	}

	public static void handShaking(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("220")) {
			throw new EmailException("접속 실패 입니다. 에러메시지: " + brTemp);
		}
	}

	public static void checkHELO(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("250")) {
			throw new EmailException("접속 실패 입니다. 에러메시지: " + brTemp);
		}
	}

	public static void checkFrom(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("250")) {
			throw new EmailException("발신자 설정 실패 입니다.\n에러메시지: " + brTemp);
		}
	}

	public static void checkRcpt(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("250")) {
			throw new EmailException("수신자 설정 실패 입니다.\n에러메시지: " + brTemp);
		}
	}

	public static void checkData(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("354")) {
			throw new EmailException("메일 내용 입력 실패 입니다.\n에러메시지: " + brTemp);
		}
	}

	public static void checkMsg(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("250")) {
			throw new EmailException("전송 실패 입니다. \n 에러메시지: " + brTemp);
		}
	}

	public static void complatedMsg(String brTemp) throws EmailException {
		String num = brTemp.substring(0, 3);
		if (!num.equals("221")) {
			throw new EmailException("정상적으로 종료되지 못했습니다만, 메일을 전송되었을 수 있습니다.\n 에러메시지: " + brTemp);
		}
	}
}
