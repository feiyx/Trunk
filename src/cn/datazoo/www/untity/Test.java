package cn.datazoo.www.untity;

import java.io.IOException;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyListener;

public class Test {
	public static void main(String[] args) throws IOException {
		String path = "e:/CDN";
		int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED
				| JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
		boolean watchSubtree = true;
		int watchID = JNotify.addWatch(path, mask, watchSubtree,
				new JNotifyListener() {
					public void fileRenamed(final int wd,
							final String rootPath, final String oldName,
							final String newName) {
						System.out.println("JNotifyTest.fileRenamed() : wd #"
								+ wd + " root = " + rootPath + ", " + oldName
								+ " -> " + newName);
					}

					public void fileModified(final int wd,
							final String rootPath, final String name) {
						System.out.println("JNotifyTest.fileModified() : wd #"
								+ wd + " root = " + rootPath + ", " + name);
					}

					public void fileDeleted(final int wd,
							final String rootPath, final String name) {
						System.out.println("JNotifyTest.fileDeleted() : wd #"
								+ wd + " root = " + rootPath + ", " + name);
					}

					public void fileCreated(final int wd,
							final String rootPath, final String name) {
						System.out.println("JNotifyTest.fileCreated() : wd #"
								+ wd + " root = " + rootPath + ", " + name);
					}
				});
		System.in.read();
		boolean res = JNotify.removeWatch(watchID);
		if (!res) {
			System.out.println("error");
		}
		System.out.println("ok");
	}
}
