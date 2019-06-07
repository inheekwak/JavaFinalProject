package edu.handong.csee.merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFiles {

	public static ArrayList<String> decompress(String Input_path) throws Throwable {
		File zipFile = new File(Input_path);
		//System.out.println(Input_path);
		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry zipentry = null;
		
		ArrayList<String> fileNames = new ArrayList<String>();

		try {
			// 파일 스트림
			fis = new FileInputStream(zipFile);
			zis = new ZipInputStream(fis);
	
			// entry가 없을때까지 뽑기
			while ((zipentry = zis.getNextEntry()) != null) {
				String filename = zipentry.getName();
				fileNames.add(filename);
				
				File file = new File(filename);
				
				// entry가 폴더면 폴더 생성
				if (zipentry.isDirectory()) {
					file.mkdirs();
				} else {
					// 파일이면 파일 만들기
					createFile(file, zis);
				}
			}

		} catch (Throwable e) {
			throw e;
		} finally {
			if (zis != null)
				zis.close();
			if (fis != null)
				fis.close();
		}
		
		//System.out.println(Output_path);
		
		return fileNames;

	}

	/**
	 * 파일 만들기 메소드
	 * 
	 * @param file 파일
	 * @param zis  Zip스트림
	 */
	private static void createFile(File file, ZipInputStream zis) throws Throwable {
		// 디렉토리 확인
		File parentDir = new File(file.getParent());
		// 디렉토리가 없으면 생성하자
		/*
		 * if (!parentDir.exists()) { parentDir.mkdirs(); }
		 */
		// 파일 스트림 선언
		try (FileOutputStream fos = new FileOutputStream(file)) {
			byte[] buffer = new byte[256];
			int size = 0;
			// Zip스트림으로부터 byte뽑아내기
			while ((size = zis.read(buffer)) > 0) {
				// byte로 파일 만들기
				fos.write(buffer, 0, size);
			}
		} catch (Throwable e) {
			throw e;
		}
	}
}
