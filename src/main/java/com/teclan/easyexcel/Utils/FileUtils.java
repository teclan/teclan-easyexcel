package com.teclan.easyexcel.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

	public static String getContent(File file) {
		StringBuilder content = new StringBuilder();
		try {

			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line);
				}
				read.close();
			} else {
				LOGGER.error(String.format("找不到指定的文件:%s", file.getAbsolutePath()));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return content.toString();
	}

	/**
	 * 生成文件
	 * 
	 * @param okPath
	 * @throws Exception
	 */
	public static void createFile(String path) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		write2File(path, sb);
	}

	/**
	 * 删除文件
	 * 
	 * @param okPath
	 */
	public static void deleteFile(String path) {
		try {
			if (new File(path).exists()) {
				new File(path).delete();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public static synchronized void write2File(String filePath, StringBuffer content) throws Exception {
		write2File(filePath, "UTF-8", content);
	}

	public static void write2File(String filePath, String coding, StringBuffer content) throws Exception {
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		try {
			if (!new File(filePath).exists()) {
				if (!new File(filePath).getParentFile().exists()) {
					if (new File(filePath).getParentFile().mkdirs()) {
						new File(filePath).createNewFile();
					}
				} else {
					new File(filePath).createNewFile();
				}
			}
			FileOutputStream fos = null;
			OutputStreamWriter writer = null;
			fos = new FileOutputStream(new File(filePath),true);
			writer = new OutputStreamWriter(fos, coding);
			writer.write(content.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}
}
