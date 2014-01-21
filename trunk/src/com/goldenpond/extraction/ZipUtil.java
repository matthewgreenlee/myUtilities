package com.goldenpond.extraction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {

	public void extract(String jarPath, String resource, String dest) throws IOException {
		JarFile jar = new JarFile(jarPath);
		ZipEntry entry = jar.getEntry(resource);
		File destDir = new File(dest);
		if (!destDir.exists() || destDir.isFile()) {
			boolean created = destDir.mkdirs();
			if (!created) {
			    jar.close();
				throw new RuntimeException("can not create dest folder");
			}
		}
		File file = new File(destDir, entry.getName());

        new File(file.getParent()).mkdirs();
		InputStream in = new BufferedInputStream(jar.getInputStream(entry));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] buffer = new byte[2048];
		for (;;) {
			int nBytes = in.read(buffer);
			if (nBytes <= 0)
				break;
			out.write(buffer, 0, nBytes);
		}
		out.flush();
		out.close();
		in.close();
		jar.close();
	}

	public void extract(String jarPath, String dest) throws IOException {
		JarFile jar = new JarFile(jarPath);
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry file = entries.nextElement();
			System.out.println("extract the jar entry: " + file.getName());
			File f = new File(dest + File.separator + file.getName());
			if (file.isDirectory()) {
				f.mkdirs();
				continue;
			}
			// make sure the folder of the output file exists, or you will hit FileNotFoundException
			new File(f.getParent()).mkdirs();
			InputStream is = jar.getInputStream(file);
			FileOutputStream fos = new FileOutputStream(f);
			while (is.available() > 0) {
				fos.write(is.read());
			}
			fos.close();
			is.close();
		}
		jar.close();
	}

	public void listEntries(String filePath) throws IOException {
	    ZipFile zip = new ZipFile(filePath);
	    Enumeration<? extends ZipEntry> entries = zip.entries();
	    while (entries.hasMoreElements()) {
	        ZipEntry entry = entries.nextElement();
	        System.out.println(entry.getName());
	    }
	    zip.close();
	}

	public void removeEntry(String filePath, String entry) {
	    
	}
}
