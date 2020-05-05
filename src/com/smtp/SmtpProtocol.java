package com.smtp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.server.EmailDTO;

public class SmtpProtocol {

	private static String errorMsg = "";

	public static String getErrorMsg() {
		return errorMsg;
	}

	public static int sendMail(EmailDTO emailDTO) {

		final int ERRORCODE = -1;
		final int SUCCESS = 1;
		int statuscode = SUCCESS;

		final int port = 25;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		Socket socket = null;
		String brTemp = null;

		try {
			ArrayList mxList = MXchecker.getMxlist(emailDTO.getRcpt());
			System.out.println("�뿰寃곗쓣 �떆�룄�빀�땲�떎.");
			socket = new Socket((String) mxList.get(0), port);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println(socket.getInetAddress() + " " + socket.getPort());
			brTemp = (String) (bufferedReader.readLine());
			EmailException.handShaking(brTemp);

			String temp = "HELO " + emailDTO.getFrom().substring(emailDTO.getFrom().indexOf("@")+1) + " \r\n";
			System.out.print(temp);
			bufferedWriter.write(temp);
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.checkHELO(brTemp);

			temp = "mail from: " + "<" + emailDTO.getFrom() + ">" + "\r\n";
			System.out.print(temp);
			bufferedWriter.write(temp);
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.checkFrom(brTemp);

			temp = "rcpt to: <" + emailDTO.getRcpt() + "> " + "\r\n";
			System.out.print(temp);
			bufferedWriter.write(temp);
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.checkRcpt(brTemp);

			temp = "DATA" + "\r\n";
			System.out.print(temp);
			bufferedWriter.write(temp);
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.checkData(brTemp);

			StringBuffer buffer = new StringBuffer();
			buffer.append("Subject: " + emailDTO.getTitle() + "\r\n");
			buffer.append("From: " + emailDTO.getName() + "<" + emailDTO.getFrom() + "> \r\n");
			buffer.append("To: <" + emailDTO.getRcpt() + "> \r\n\r\n");
			buffer.append(emailDTO.getContent() + "\r\n.\r\n");
			System.out.print(buffer.toString());
			bufferedWriter.write(buffer.toString());
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.checkMsg(brTemp);

			temp = "quit\r\n";
			System.out.print(temp);
			bufferedWriter.write(temp);
			bufferedWriter.flush();
			brTemp = bufferedReader.readLine();
			System.out.println(brTemp);
			EmailException.complatedMsg(brTemp);

		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			statuscode = ERRORCODE;
			errorMsg = e.getMessage();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			statuscode = ERRORCODE;
			errorMsg = e.getMessage();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			statuscode = ERRORCODE;
			errorMsg = e.getMessage();

		}
		return statuscode;

	}

}
