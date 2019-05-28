package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class PlatformDetector {

    public static class Vendor {
        private static final String LINUX_ID_PREFIX = "ID=";
        private static final String[] LINUX_OS_RELEASE_FILES = new String[]{"/etc/os-release", "/usr/lib/os-release"};
        private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";

        public static String getName() {
            AppMethodBeat.i(75013);
            String str;
            if (OS.isWindows()) {
                str = "microsoft";
                AppMethodBeat.o(75013);
                return str;
            } else if (OS.isMac()) {
                str = "apple";
                AppMethodBeat.o(75013);
                return str;
            } else if (OS.isLinux()) {
                str = getLinuxOsReleaseId();
                AppMethodBeat.o(75013);
                return str;
            } else if (OS.isAndroid()) {
                str = "google";
                AppMethodBeat.o(75013);
                return str;
            } else {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported vendor: " + getName());
                AppMethodBeat.o(75013);
                throw unsatisfiedLinkError;
            }
        }

        private static String getLinuxOsReleaseId() {
            String parseLinuxOsReleaseFile;
            AppMethodBeat.i(75014);
            for (String file : LINUX_OS_RELEASE_FILES) {
                File file2 = new File(file);
                if (file2.exists()) {
                    parseLinuxOsReleaseFile = parseLinuxOsReleaseFile(file2);
                    AppMethodBeat.o(75014);
                    return parseLinuxOsReleaseFile;
                }
            }
            File file3 = new File(REDHAT_RELEASE_FILE);
            if (file3.exists()) {
                parseLinuxOsReleaseFile = parseLinuxRedhatReleaseFile(file3);
                AppMethodBeat.o(75014);
                return parseLinuxOsReleaseFile;
            }
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
            AppMethodBeat.o(75014);
            throw unsatisfiedLinkError;
        }

        private static String parseLinuxOsReleaseFile(File file) {
            Throwable th;
            Closeable closeable;
            String str = null;
            AppMethodBeat.i(75015);
            Closeable bufferedReader;
            try {
                String readLine;
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), ProtocolPackage.ServerEncoding));
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (IOException e) {
                        closeQuietly(bufferedReader);
                        AppMethodBeat.o(75015);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedReader;
                        closeQuietly(closeable);
                        AppMethodBeat.o(75015);
                        throw th;
                    }
                } while (!readLine.startsWith(LINUX_ID_PREFIX));
                str = PlatformDetector.access$300(readLine.substring(3));
                closeQuietly(bufferedReader);
                AppMethodBeat.o(75015);
            } catch (IOException e2) {
                bufferedReader = null;
                closeQuietly(bufferedReader);
                AppMethodBeat.o(75015);
                return str;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                closeQuietly(closeable);
                AppMethodBeat.o(75015);
                throw th;
            }
            return str;
        }

        private static String parseLinuxRedhatReleaseFile(File file) {
            Throwable th;
            Closeable closeable;
            String str = null;
            AppMethodBeat.i(75016);
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), ProtocolPackage.ServerEncoding));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.toLowerCase(Locale.US);
                        if (readLine.contains("centos")) {
                            str = "centos";
                        } else if (readLine.contains("fedora")) {
                            str = "fedora";
                        } else if (readLine.contains("red hat enterprise linux")) {
                            str = "rhel";
                        } else {
                            closeQuietly(bufferedReader);
                            AppMethodBeat.o(75016);
                            return str;
                        }
                        closeQuietly(bufferedReader);
                        AppMethodBeat.o(75016);
                        return str;
                    }
                    closeQuietly(bufferedReader);
                    AppMethodBeat.o(75016);
                    return str;
                } catch (IOException e) {
                    closeQuietly(bufferedReader);
                    AppMethodBeat.o(75016);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = bufferedReader;
                    closeQuietly(closeable);
                    AppMethodBeat.o(75016);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = null;
                closeQuietly(bufferedReader);
                AppMethodBeat.o(75016);
                return str;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                closeQuietly(closeable);
                AppMethodBeat.o(75016);
                throw th;
            }
        }

        private static void closeQuietly(Closeable closeable) {
            AppMethodBeat.i(75017);
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    AppMethodBeat.o(75017);
                    return;
                }
            }
            AppMethodBeat.o(75017);
        }
    }

    public static class Arch {
        public static String getName() {
            AppMethodBeat.i(75005);
            String property = System.getProperty("os.arch");
            String access$000 = PlatformDetector.access$000(property);
            if (access$000.equals("unknown")) {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported arch: ".concat(String.valueOf(property)));
                AppMethodBeat.o(75005);
                throw unsatisfiedLinkError;
            }
            AppMethodBeat.o(75005);
            return access$000;
        }
    }

    public static class OS {
        public static String getName() {
            AppMethodBeat.i(75006);
            String property = System.getProperty("os.name");
            String access$100 = PlatformDetector.access$100(property);
            String property2 = System.getProperty("java.specification.vendor");
            if (PlatformDetector.access$200(property2).contains("android") || access$100.contains("android")) {
                access$100 = "android";
                AppMethodBeat.o(75006);
                return access$100;
            } else if (access$100.equals("unknown")) {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform/vendor: " + property + " / " + property2);
                AppMethodBeat.o(75006);
                throw unsatisfiedLinkError;
            } else {
                AppMethodBeat.o(75006);
                return access$100;
            }
        }

        public static boolean isWindows() {
            AppMethodBeat.i(75007);
            boolean equals = getName().equals(Platform.WINDOWS);
            AppMethodBeat.o(75007);
            return equals;
        }

        public static boolean isMac() {
            AppMethodBeat.i(75008);
            boolean equals = getName().equals(Platform.MACOSX);
            AppMethodBeat.o(75008);
            return equals;
        }

        public static boolean isLinux() {
            AppMethodBeat.i(75009);
            boolean equals = getName().equals(Platform.LINUX);
            AppMethodBeat.o(75009);
            return equals;
        }

        public static boolean isNativeClient() {
            AppMethodBeat.i(75010);
            boolean equals = getName().equals(Platform.NATIVE_CLIENT);
            AppMethodBeat.o(75010);
            return equals;
        }

        public static boolean isAndroid() {
            AppMethodBeat.i(75011);
            boolean equals = getName().equals("android");
            AppMethodBeat.o(75011);
            return equals;
        }

        public static String getLibFileExtension() {
            AppMethodBeat.i(75012);
            String str;
            if (isWindows()) {
                str = "dll";
                AppMethodBeat.o(75012);
                return str;
            } else if (isMac()) {
                str = "dylib";
                AppMethodBeat.o(75012);
                return str;
            } else if (isLinux() || isAndroid() || isNativeClient()) {
                str = "so";
                AppMethodBeat.o(75012);
                return str;
            } else {
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
                AppMethodBeat.o(75012);
                throw unsatisfiedLinkError;
            }
        }
    }

    static /* synthetic */ String access$000(String str) {
        AppMethodBeat.i(75022);
        String normalizeArch = normalizeArch(str);
        AppMethodBeat.o(75022);
        return normalizeArch;
    }

    static /* synthetic */ String access$100(String str) {
        AppMethodBeat.i(75023);
        String normalizeOs = normalizeOs(str);
        AppMethodBeat.o(75023);
        return normalizeOs;
    }

    static /* synthetic */ String access$200(String str) {
        AppMethodBeat.i(75024);
        String normalize = normalize(str);
        AppMethodBeat.o(75024);
        return normalize;
    }

    static /* synthetic */ String access$300(String str) {
        AppMethodBeat.i(75025);
        String normalizeOsReleaseValue = normalizeOsReleaseValue(str);
        AppMethodBeat.o(75025);
        return normalizeOsReleaseValue;
    }

    private static String normalizeOsReleaseValue(String str) {
        AppMethodBeat.i(75018);
        String replace = str.trim().replace("\"", "");
        AppMethodBeat.o(75018);
        return replace;
    }

    private static String normalizeOs(String str) {
        AppMethodBeat.i(75019);
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            normalize = "aix";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("hpux")) {
            normalize = "hpux";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("os400") && (normalize.length() <= 5 || !Character.isDigit(normalize.charAt(5)))) {
            normalize = "os400";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("android")) {
            normalize = "android";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith(Platform.LINUX)) {
            normalize = Platform.LINUX;
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith(Platform.NATIVE_CLIENT)) {
            normalize = Platform.NATIVE_CLIENT;
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith(Platform.MACOSX) || normalize.startsWith("osx")) {
            normalize = Platform.MACOSX;
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("freebsd")) {
            normalize = "freebsd";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("openbsd")) {
            normalize = "openbsd";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("netbsd")) {
            normalize = "netbsd";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith("solaris") || normalize.startsWith("sunos")) {
            normalize = "sunos";
            AppMethodBeat.o(75019);
            return normalize;
        } else if (normalize.startsWith(Platform.WINDOWS)) {
            normalize = Platform.WINDOWS;
            AppMethodBeat.o(75019);
            return normalize;
        } else {
            normalize = "unknown";
            AppMethodBeat.o(75019);
            return normalize;
        }
    }

    private static String normalizeArch(String str) {
        AppMethodBeat.i(75020);
        String normalize = normalize(str);
        if (normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            normalize = "x86_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            normalize = "x86_32";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(ia64|itanium64)$")) {
            normalize = "itanium_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(sparc|sparc32)$")) {
            normalize = "sparc_32";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(sparcv9|sparc64)$")) {
            normalize = "sparc_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(arm|arm32)$")) {
            normalize = "arm_32";
            AppMethodBeat.o(75020);
            return normalize;
        } else if ("aarch64".equals(normalize)) {
            normalize = "aarch_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if (normalize.matches("^(ppc|ppc32)$")) {
            normalize = "ppc_32";
            AppMethodBeat.o(75020);
            return normalize;
        } else if ("ppc64".equals(normalize)) {
            normalize = "ppc_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if ("ppc64le".equals(normalize)) {
            normalize = "ppcle_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else if ("s390".equals(normalize)) {
            normalize = "s390_32";
            AppMethodBeat.o(75020);
            return normalize;
        } else if ("s390x".equals(normalize)) {
            normalize = "s390_64";
            AppMethodBeat.o(75020);
            return normalize;
        } else {
            normalize = "unknown";
            AppMethodBeat.o(75020);
            return normalize;
        }
    }

    private static String normalize(String str) {
        AppMethodBeat.i(75021);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(75021);
            return str2;
        }
        str2 = str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
        AppMethodBeat.o(75021);
        return str2;
    }
}
