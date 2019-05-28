package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.eclipsesource.v8.LibraryLoader */
class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    LibraryLoader() {
    }

    static {
        AppMethodBeat.m2504i(74962);
        AppMethodBeat.m2505o(74962);
    }

    private static String computeLibraryShortName() {
        AppMethodBeat.m2504i(74947);
        String os = LibraryLoader.getOS();
        String str = "j2v8" + "_" + os + "_" + LibraryLoader.getArchSuffix();
        AppMethodBeat.m2505o(74947);
        return str;
    }

    private static String computeLibraryFullName() {
        AppMethodBeat.m2504i(74948);
        String str = "lib" + LibraryLoader.computeLibraryShortName() + "." + LibraryLoader.getOSFileExtension();
        AppMethodBeat.m2505o(74948);
        return str;
    }

    static void loadLibrary(String str) {
        AppMethodBeat.m2504i(74949);
        if (LibraryLoader.isAndroid()) {
            System.loadLibrary("j2v8");
            AppMethodBeat.m2505o(74949);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String computeLibraryShortName = LibraryLoader.computeLibraryShortName();
        String computeLibraryFullName = LibraryLoader.computeLibraryFullName();
        String str2 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + LibraryLoader.computeLibraryFullName();
        if (LibraryLoader.load(computeLibraryFullName, stringBuffer)) {
            AppMethodBeat.m2505o(74949);
        } else if (LibraryLoader.load(computeLibraryShortName, stringBuffer)) {
            AppMethodBeat.m2505o(74949);
        } else if (new File(str2).exists() && LibraryLoader.load(str2, stringBuffer)) {
            AppMethodBeat.m2505o(74949);
        } else {
            if (str == null) {
                str = System.getProperty("java.io.tmpdir");
            }
            if (LibraryLoader.extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer)) {
                AppMethodBeat.m2505o(74949);
                return;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
            AppMethodBeat.m2505o(74949);
            throw unsatisfiedLinkError;
        }
    }

    static boolean load(String str, StringBuffer stringBuffer) {
        AppMethodBeat.m2504i(74950);
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            AppMethodBeat.m2505o(74950);
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append(9);
            stringBuffer.append(e.getMessage());
            stringBuffer.append(DELIMITER);
            AppMethodBeat.m2505o(74950);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042 A:{SYNTHETIC, Splitter:B:17:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A:{SYNTHETIC, Splitter:B:20:0x0047} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean extract(String str, String str2, StringBuffer stringBuffer) {
        boolean z = true;
        AppMethodBeat.m2504i(74951);
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
                    LibraryLoader.chmod("755", str);
                    if (LibraryLoader.load(str, stringBuffer)) {
                        AppMethodBeat.m2505o(74951);
                        return true;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (resourceAsStream != null) {
                    }
                    file.delete();
                    AppMethodBeat.m2505o(74951);
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
            AppMethodBeat.m2505o(74951);
            return false;
        }
        AppMethodBeat.m2505o(74951);
        return false;
    }

    static void chmod(String str, String str2) {
        AppMethodBeat.m2504i(74952);
        if (LibraryLoader.isWindows()) {
            AppMethodBeat.m2505o(74952);
            return;
        }
        try {
            Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            AppMethodBeat.m2505o(74952);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(74952);
        }
    }

    static String getOsName() {
        AppMethodBeat.m2504i(74953);
        String str = System.getProperty("os.name") + System.getProperty("java.specification.vendor");
        AppMethodBeat.m2505o(74953);
        return str;
    }

    static boolean isWindows() {
        AppMethodBeat.m2504i(74954);
        boolean startsWith = LibraryLoader.getOsName().startsWith("Windows");
        AppMethodBeat.m2505o(74954);
        return startsWith;
    }

    static boolean isMac() {
        AppMethodBeat.m2504i(74955);
        boolean startsWith = LibraryLoader.getOsName().startsWith("Mac");
        AppMethodBeat.m2505o(74955);
        return startsWith;
    }

    static boolean isLinux() {
        AppMethodBeat.m2504i(74956);
        boolean startsWith = LibraryLoader.getOsName().startsWith("Linux");
        AppMethodBeat.m2505o(74956);
        return startsWith;
    }

    static boolean isNativeClient() {
        AppMethodBeat.m2504i(74957);
        boolean startsWith = LibraryLoader.getOsName().startsWith(Platform.NATIVE_CLIENT);
        AppMethodBeat.m2505o(74957);
        return startsWith;
    }

    static boolean isAndroid() {
        AppMethodBeat.m2504i(74958);
        boolean contains = LibraryLoader.getOsName().contains("Android");
        AppMethodBeat.m2505o(74958);
        return contains;
    }

    static String getArchSuffix() {
        AppMethodBeat.m2504i(74959);
        String property = System.getProperty("os.arch");
        if (property.equals("i686")) {
            property = "x86";
            AppMethodBeat.m2505o(74959);
            return property;
        } else if (property.equals("amd64")) {
            property = "x86_64";
            AppMethodBeat.m2505o(74959);
            return property;
        } else if (property.equals(Platform.NATIVE_CLIENT)) {
            property = "armv7l";
            AppMethodBeat.m2505o(74959);
            return property;
        } else if (property.equals("aarch64")) {
            property = "armv7l";
            AppMethodBeat.m2505o(74959);
            return property;
        } else {
            AppMethodBeat.m2505o(74959);
            return property;
        }
    }

    static String getOSFileExtension() {
        AppMethodBeat.m2504i(74960);
        String str;
        if (LibraryLoader.isWindows()) {
            str = "dll";
            AppMethodBeat.m2505o(74960);
            return str;
        } else if (LibraryLoader.isMac()) {
            str = "dylib";
            AppMethodBeat.m2505o(74960);
            return str;
        } else if (LibraryLoader.isLinux()) {
            str = "so";
            AppMethodBeat.m2505o(74960);
            return str;
        } else if (LibraryLoader.isNativeClient()) {
            str = "so";
            AppMethodBeat.m2505o(74960);
            return str;
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + LibraryLoader.getOsName());
            AppMethodBeat.m2505o(74960);
            throw unsatisfiedLinkError;
        }
    }

    static String getOS() {
        AppMethodBeat.m2504i(74961);
        String str;
        if (LibraryLoader.isWindows()) {
            str = "win32";
            AppMethodBeat.m2505o(74961);
            return str;
        } else if (LibraryLoader.isMac()) {
            str = Platform.MACOSX;
            AppMethodBeat.m2505o(74961);
            return str;
        } else if (LibraryLoader.isLinux() && !LibraryLoader.isAndroid()) {
            str = Platform.LINUX;
            AppMethodBeat.m2505o(74961);
            return str;
        } else if (LibraryLoader.isAndroid()) {
            str = "android";
            AppMethodBeat.m2505o(74961);
            return str;
        } else {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + LibraryLoader.getOsName());
            AppMethodBeat.m2505o(74961);
            throw unsatisfiedLinkError;
        }
    }
}
