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

public class JarExtractor {

	public void extract(String jarPath, String resource, String dest) throws IOException {
		JarFile jar = new JarFile(jarPath);
		ZipEntry entry = jar.getEntry(resource);
		File file = new File(dest, entry.getName());

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
	}

	public void extractAll(String jarPath, String dest) throws IOException {
		JarFile jar = new JarFile(jarPath);
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry file = entries.nextElement();
			File f = new File(dest + File.separator + file.getName());
			if (file.isDirectory()) {
				f.mkdir();
				continue;
			}
			InputStream is = jar.getInputStream(file);
			FileOutputStream fos = new FileOutputStream(f);
			while (is.available() > 0) {
				fos.write(is.read());
			}
			fos.close();
			is.close();
		}		
	}

}
