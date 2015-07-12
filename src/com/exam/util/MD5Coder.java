package com.exam.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Coder {
	
	public static String encodeMD5Hex(String data) {
		return DigestUtils.md5Hex(data);
	}
}
