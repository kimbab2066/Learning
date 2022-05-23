package Java.Chap8;

public class ChainedException {
	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of main

	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException e) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
		} catch (MemoryException me) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace()) {
			throw new SpaceException("공간 부족.");
		}
		if (!enoughMemory()) {
			throw new MemoryException("메모리 부족.");
			// throw new RuntimeException(new MemoryException("메모리 부족."));
		}
	}

	static void copyFiles() {

	}

	static void deleteTempFiles() {

	}

	static boolean enoughSpace() {
		return false;
	}

	static boolean enoughMemory() {
		return true;
	}
}// end of class

class InstallException extends Exception {
	public InstallException(String msg) {
		super(msg);
	}
}

class SpaceException extends Exception {
	public SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	public MemoryException(String msg) {
		super(msg);
	}
}
