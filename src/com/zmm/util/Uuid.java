/**
 * 
 */
package com.zmm.util;

import java.util.UUID;

/**
 * @author Administrator 
    
 * replace()
 * �����������ַ�������һЩ�ַ��滻��һЩ�ַ������滻һ����������ʽƥ����Ӵ���
 * toUpperCase()����˵��:�÷�������ָ����charֵ�Ĵ�д��ʽ
 *
 */
public class Uuid {

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
