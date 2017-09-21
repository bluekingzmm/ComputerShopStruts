package com.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction extends BaseAction {
	private File image;
	private String imageContentType;
	private String imageFileName;

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String addUI() {
		return "success";
	}

	// public String upload() throws Exception {
	// // 得到upload物理路径
	// String realpath =
	// ServletActionContext.getServletContext().getRealPath("/upload");
	// System.out.println(realpath);
	// if (image != null) {
	// String name = new Date().getTime() +
	// imageFileName.substring(imageFileName.lastIndexOf("."));
	// File savefile = new File(new File(realpath), name);
	// if (!savefile.getParentFile().exists())
	// savefile.getParentFile().mkdirs();// 如果不存在则创建这个目录
	// FileUtils.copyFile(image, savefile);
	// request.setAttribute("imgPath", name);
	//
	// return "success";
	//
	// } else {
	// return "input";
	// }
	//
	// }
	public void upload() throws Exception {
		// 得到upload物理路径
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(realpath);
		if (image != null) {
			String name = new Date().getTime() + imageFileName.substring(imageFileName.lastIndexOf("."));
			File savefile = new File(new File(realpath), name);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();// 如果不存在则创建这个目录
			FileUtils.copyFile(image, savefile);
//			request.setAttribute("imgPath", name);
			StringBuffer sbf = new StringBuffer();
			sbf.append("{\"error\":0,\"url\":\"");
			sbf.append(request.getContextPath() + "/upload/" + name+"\"");
			sbf.append(",\"name\":\"");
			sbf.append(name);
			sbf.append("\"}");
			System.out.println(sbf.toString());
			PrintWriter writer=response.getWriter();
			writer.println(sbf.toString());
			writer.flush();
			writer.close();
		}else{
			System.out.println("上传失败!");
		}
		
		
		
		
	}
}
