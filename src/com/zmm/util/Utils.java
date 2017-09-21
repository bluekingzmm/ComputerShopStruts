package com.zmm.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utils {
	// Id��ȡ
	public static int subStringToId(String s) {
		StringBuffer sb = new StringBuffer();
		char ch = s.charAt(6);
		char ch1 = s.charAt(7);
		char ch2 = s.charAt(8);
		char ch3 = s.charAt(9);

		sb.append(ch).append(ch1).append(ch2).append(ch3);
		int Id = Integer.parseInt(sb.toString());
		return Id;
	}

	// ��ǰʱ���ȡ
	public static int subStringToTime(String s) {
		StringBuffer sb = new StringBuffer();
		char ch = s.charAt(0);
		char ch1 = s.charAt(1);
		char ch2 = s.charAt(2);
		char ch3 = s.charAt(3);

		sb.append(ch).append(ch1).append(ch2).append(ch3);
		int time = Integer.parseInt(sb.toString());
		return time;
	}

	public void sendMail(String mail, String code,String type) throws Exception {
		/*
		 * ���ʼ� ���������ļ���
		 */
		// ��ȡ�����ļ�����

		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream(type));
		String host = props.getProperty("host");// ��ȡ����������
		String name = props.getProperty("userName");//
		// ��ȡ�û���
		String password = props.getProperty("userPassword");// ��ȡ����

		String from = props.getProperty("from");// ��ȡ������
		String to = mail;// ��ȡ�ռ���
		String subject = props.getProperty("subject");// ��ȡ����
		String content = props.getProperty("content");//
		// ��ȡ�ʼ�����
		content = MessageFormat.format(content, code);// �滻�����ļ��е�{0}

		Session session = MailUtils.createSession(host, name, password);// �õ�session

		Mail email = new Mail(from, to, subject, content);//
		// �����ʼ�����
		try {
			MailUtils.send(session, email);// ���ʼ���
		} catch (MessagingException e) {
		}
	}

	public static Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); // �������RGB��ɫ�е�rֵ
		g = s + random.nextInt(e - s); // �������RGB��ɫ�е�gֵ
		b = s + random.nextInt(e - s); // �������RGB��ɫ�е�bֵ
		return new Color(r, g, b);
	}

	public static void yzm(HttpServletResponse response,HttpServletRequest request) throws Exception {
		
		int width = 112, height = 37; // ָ��������֤��Ŀ�Ⱥ͸߶�
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // ����BufferedImage����,�������൱��һͼƬ
		Graphics g = image.getGraphics(); // ����Graphics����,�������൱�ڻ���
		Graphics2D g2d = (Graphics2D) g; // ����Grapchics2D����
		Random random = new Random();
		Font mfont = new Font("����", Font.BOLD, 24); // ����������ʽ
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height); // ���Ʊ���
		g.setFont(mfont); // ��������
		g.setColor(getRandColor(180, 200));

		// ����100����ɫ��λ��ȫ��Ϊ�������������,������Ϊ2f
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); // ����������ʽ
			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line); // ����ֱ��
		}
		// �����Ӣ�ģ����֣������������ɵ���֤���֣��������Ϸ�ʽ�������������ȷ����
		String sRand = "";
		String ctmp = "";
		int itmp = 0;
		// �ƶ��������֤��Ϊ��λ
		for (int i = 0; i < 4; i++) {
			switch (random.nextInt(3)) {
			case 1: // ����A-Z����ĸ
				itmp = random.nextInt(26) + 65;
				ctmp = String.valueOf((char) itmp);
				break;
			case 2: // ���ɺ���
				String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
				// ���ɵ�һλ����
				int r1 = random.nextInt(3) + 11;
				String str_r1 = rBase[r1];
				// ���ɵڶ�λ����
				int r2;
				if (r1 == 13) {
					r2 = random.nextInt(7);
				} else {
					r2 = random.nextInt(16);
				}
				String str_r2 = rBase[r2];
				// ���ɵ�һλλ��
				int r3 = random.nextInt(6) + 10;
				String str_r3 = rBase[r3];
				// ���ɵڶ�λλ��
				int r4;
				if (r3 == 10) {
					r4 = random.nextInt(15) + 1;
				} else if (r3 == 15) {
					r4 = random.nextInt(15);
				} else {
					r4 = random.nextInt(16);
				}
				String str_r4 = rBase[r4];
				// �����ɵĻ�����ת��Ϊ����
				byte[] bytes = new byte[2];
				// �����ɵ����뱣�浽�ֽ�����ĵ�һ��Ԫ����
				String str_12 = str_r1 + str_r2;
				int tempLow = Integer.parseInt(str_12, 16);
				bytes[0] = (byte) tempLow;
				// �����ɵ�λ�뱣�浽�ֽ�����ĵڶ���Ԫ����
				String str_34 = str_r3 + str_r4;
				int tempHigh = Integer.parseInt(str_34, 16);
				bytes[1] = (byte) tempHigh;
				ctmp = new String(bytes);
				break;
			default:
				itmp = random.nextInt(10) + 48;
				ctmp = String.valueOf((char) itmp);
				break;
			}
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
			g.setColor(color);
			// �����ɵ����������������Ų���ת�ƶ��Ƕ� PS.���鲻Ҫ�����ֽ�����������ת,��Ϊ����ͼƬ���ܲ�������ʾ
			/* ��������ת�ƶ��Ƕ� */
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate((45) * 3.14 / 180, 15 * i + 8, 7);
			/* �������� */
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1f)
				scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15 * i + 18, 14);
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		g.dispose(); // �ͷ�g��ռ�õ�ϵͳ��Դ
		ImageIO.write(image, "JPEG", response.getOutputStream()); // ���ͼƬ
	}

	
}
