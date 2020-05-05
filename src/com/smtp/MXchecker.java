package com.smtp;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class MXchecker {

	private static ArrayList mxList;

	public static ArrayList getMxlist(String email) throws NamingException {
		mxList = null;
		String testData[] = { email };
		for (int ctr = 0; ctr < testData.length; ctr++) {
			isAddressValid(testData[ctr]);
		}
		return mxList;
	}

	private static ArrayList getMX(String hostName) throws NamingException { // �����ο��� MX���ڵ带 ã�⸦ �õ�
		Hashtable env = new Hashtable();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");
		// ���� MX���ڵ尡 ������, �� �ڽ� MX�������� �õ��� ����.
		if ((attr == null) || (attr.size() == 0)) {
			attrs = ictx.getAttributes(hostName, new String[] { "A" });
			attr = attrs.get("A");
			if (attr == null)
				throw new NamingException("ȣ��Ʈ���� �߸��Ǿ����ϴ�. " + hostName + "'");
		}
		// �߰��� ��쿡 ������ �����Ѵ�.
		ArrayList res = new ArrayList();
		NamingEnumeration en = attr.getAll();
		while (en.hasMore()) {
			String x = (String) en.next();
			String f[] = x.split(" ");
			if (f[1].endsWith("."))
				f[1] = f[1].substring(0, (f[1].length() - 1));
			res.add(f[1]);
		}
		return res;
	}

	public static boolean isAddressValid(String address) throws NamingException { // �����γ��� ������'@'��ġ�� ã�´�.
		int pos = address.indexOf('@');
		// ���ٸ�, �߸��� e-mail
		if (pos == -1)
			return false;
		String domain = address.substring(++pos);
		try {
			// DNS���� MX���ڵ带 ã�´�.
			mxList = getMX(domain);
		} catch (NamingException ex) {
			return false;
		}
		if (mxList.size() == 0) {
			return false;
		}
		return true;
	}

}
