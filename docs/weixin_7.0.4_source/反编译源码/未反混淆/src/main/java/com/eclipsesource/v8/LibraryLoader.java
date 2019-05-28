package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    LibraryLoader() {
    }

    static {
        AppMethodBeat.i(74962);
        AppMethodBeat.o(74962);
    }

    private static String computeLibraryShortName() {
        AppMethodBeat.i(74947);
        String os = getOS();
        String str = "j2v8" + "_" + os + "_" + getArchSuffix();
        AppMethodBeat.o(74947);
        return str;
    }

    private static String computeLibraryFullName() {
        AppMethodBeat.i(74948);
        String str = "lib" + computeLibraryShortName() + "." + getOSFileExtension();
        AppMethodBeat.o(74948);
        return str;
    }

    static void loadLibrary(String str) {
        AppMethodBeat.i(74949);
        if (isAndroid()) {
            System.loadLibrary("j2v8");
            AppMethodBeat.o(74949);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String computeLibraryShortName = computeLibraryShortName();
        String computeLibraryFullName = computeLibraryFullName();
        String str2 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
        if (load(computeLibraryFullName, stringBuffer)) {
            AppMethodBeat.o(74949);
        } else if (load(computeLibraryShortName, stringBuffer)) {
            AppMethodBeat.o(74949);
        } else if (new File(str2).exists() && load(str2, stringBuffer)) {
            AppMethodBeat.o(74949);
        } else {
            if (str == null) {
                str = System.getProperty("java.io.tmpdir");
            }
            if (extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer)) {
                AppMethodBeat.o(74949);
                return;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
            AppMethodBeat.o(74949);
            throw unsatisfiedLinkError;
        }
    }

    static boolean load(String str, StringBuffer stringBuffer) {
        AppMethodBeat.i(74950);
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            AppMethodBeat.o(74950);
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append(9);
            stringBuffer.append(e.getMessage());
            stringBuffer.append(DELIMITER);
            AppMethodBeat.o(74950);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042 A:{SYNTHETIC, Splitter:B:17:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A:{SYNTHETIC, Splitter:B:20:0x0047} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean extract(String str, String str2, StringBuffer stringBuffer) {
        boolean z = true;
        AppMethodBeat.i(74951);
        File file = new File(str);
        InputStream resourceAsStream;
        FileOutputStream fileOutputStream;
        try {
            if (file.exists()) {
                file.delete();
            }
            resourceAsStream = LibraryLoader.class.getResourceAsStream("/".concat(String.valueOf(str2)));
            if (resourceAsStream != null) {
                try {
                    byte[] bArr = new byte[4096];
                    fileOutputStream = new FileOutputStream(str);
                    while (true) {
                        try {
                            int read = resourceAsStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Throwable th) {
                        }
                    }
                    fileOutputStream.close();
                    resourceAsStream.close();
                    chmod("755", str);
                    if (load(str, stringBuffer)) {
                        AppMethodBeat.o(74951);
                        return true;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (resourceAsStream != null) {
                    }
                    file.delete();
                    AppMethodBeat.o(74951);
                    return false;
                }
            }
        } catch (Throwable th3) {
            z = false;
            resourceAsStream = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e2) {
                }
            }
            if (z && file.exists()) {
                file.delete();
            }
            AppMethodBeat.o(74951);
            return false;
        }
        AppMethodBeat.o(74951);
        return false;
    }

    static void chmod(String str, String str2) {
        AppMethodBeat.i(74952);
        if (isWindows()) {
            AppMethodBeat.o(74952);
            return;
        }
        try {
            Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            AppMethodBeat.o(74952);
        } catch (Throwable th) {
            AppMethodBeat.o(74952);
        }
    }

    static String getOsName() {
        AppMethodBeat.i(74953);
        String str = System.getProperty("os.name") + System.getProperty("java.specification.vendor");
        AppMethodBeat.o(74953);
        return str;
    }

    static boolean isWindows() {
        AppMethodBeat.i(74954);
        boolean startsWith = getOsName().startsWith("Windows");
        AppMethodBeat.o(74954);
        return startsWith;
    }

    static boolean isMac() {
        AppMethodBeat.i(74955);
        boolean startsWith = getOsName().startsWith("Mac");
        AppMethodBeat.o(74955);
        return startsWith;
    }

    static boolean isLinux() {
        AppMethodBeat.i(74956);
        boolean startsWith = getOsName().startsWith("Linux");
        AppMethodBeat.o(74956);
        return startsWith;
    }

    static boolean isNativeClient() {
        AppMethodBeat.i(74957);
        boolean startsWith = getOsName().startsWith(Platform.NATIVE_CLIENT);
        AppMethodBeat.o(74957);
        return startsWith;
    }

    static boolean isAndroid() {
        AppMethodBeat.i(74958);
        boolean contains = getOsName().contains("Android");
        AppMethodBeat.o(74958);
        return contains;
    }

    static String getArchSuffix() {
        AppMethodBeat.i(74959);
        String property = System.getProperty("os.arch");
        if (property.equals("i686")) {
            property = "x86";
            AppMethodBeat.o(74959);
            return property;
        } else if (property.equals("amd64")) {
            property = "x86_64";
            AppMethodBeat.o(74959);
            return property;
        } else if (property.equals(Platform.NATIVE_CLIENT)) {
            property = "armv7l";
            AppMethodBeat.o(74959);
            return property;
        } else if (property.equals("aarch64")) {
            property = "armv7l";
            AppMethodBeat.o(74959);
            return property;
        } else {
            AppMethodBeat.o(74959);
            return property;
        }
    }

    static String getOSFileExtension() {
        AppMethodBeat.i(74960);
        String str;
        if (isWindows()) {
            str = "dll";
            AppMethodBeat.o(74960);
            return str;
        } else if (isMac()) {
            str = "dylib";
            AppMethodBeat.o(74960);
            return str;
        } else if (isLinux()) {
            str = "so";
            AppMethodBeat.o(74960);
            return str;
        } else if (isNativeClient()) {
            str = "so";
            AppMethodBeat.o(74960);
            return str;
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
            AppMethodBeat.o(74960);
            throw unsatisfiedLinkError;
        }
    }

    static String getOS() {
        AppMethodBeat.i(74961);
        String str;
        if (isWindows()) {
            str = "win32";
            AppMethodBeat.o(74961);
            return str;
        } else if (isMac()) {
            str = Platform.MACOSX;
            AppMethodBeat.o(74961);
            return str;
        } else if (isLinux() && !isAndroid()) {
            str = Platform.LINUX;
            AppMethodBeat.o(74961);
            return str;
        } else if (isAndroid()) {
            str = "android";
            AppMethodBeat.o(74961);
            return str;
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
            AppMethodBeat.o(74961);
            throw unsatisfiedLinkError;
        }
    }
}
