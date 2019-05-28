package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class d {
    public static final String x(byte[] bArr) {
        AppMethodBeat.i(4011);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            String str = new String(cArr2);
            AppMethodBeat.o(4011);
            return str;
        } catch (Exception e) {
            AppMethodBeat.o(4011);
            return null;
        }
    }

    private static String r(InputStream inputStream) {
        String str = null;
        int i = 0;
        AppMethodBeat.i(4012);
        try {
            if (inputStream.skip(0) < 0) {
                AppMethodBeat.o(4012);
            } else {
                byte[] digest;
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[102400];
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1 || i2 >= 102400) {
                        digest = instance.digest();
                    } else if (i2 + read <= 102400) {
                        instance.update(bArr, 0, read);
                        i2 += read;
                    } else {
                        instance.update(bArr, 0, 102400 - i2);
                        i2 = 102400;
                    }
                }
                digest = instance.digest();
                while (i < digest.length) {
                    stringBuilder.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                    i++;
                }
                str = stringBuilder.toString();
                AppMethodBeat.o(4012);
            }
        } catch (Exception e) {
            AppMethodBeat.o(4012);
        }
        return str;
    }

    private static String b(InputStream inputStream, int i) {
        String str = null;
        AppMethodBeat.i(4013);
        if (i <= 0) {
            AppMethodBeat.o(4013);
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[i];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                str = stringBuilder.toString();
                AppMethodBeat.o(4013);
            } catch (Exception e) {
                AppMethodBeat.o(4013);
            }
        }
        return str;
    }

    public static String cz(String str) {
        AppMethodBeat.i(4014);
        if (str == null) {
            AppMethodBeat.o(4014);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            String v = v(file);
            AppMethodBeat.o(4014);
            return v;
        }
        AppMethodBeat.o(4014);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A:{SYNTHETIC, Splitter:B:23:0x0044} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String v(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        long j = 102400;
        AppMethodBeat.i(4015);
        if (file.exists()) {
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    if (102400 > file.length()) {
                        j = file.length();
                    }
                    String b = b(fileInputStream2, (int) j);
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.o(4015);
                    return b;
                } catch (Exception e2) {
                    fileInputStream = fileInputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    AppMethodBeat.o(4015);
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(4015);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(4015);
                throw th;
            }
        }
        AppMethodBeat.o(4015);
        return null;
    }

    public static boolean gA(String str, String str2) {
        AppMethodBeat.i(4016);
        String cz = cz(str);
        if (cz == null || str2 == null || !str2.equalsIgnoreCase(cz)) {
            AppMethodBeat.o(4016);
            return false;
        }
        AppMethodBeat.o(4016);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A:{SYNTHETIC, Splitter:B:13:0x0028} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033 A:{SYNTHETIC, Splitter:B:19:0x0033} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String w(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.i(4017);
        if (file.exists()) {
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    String r = r(fileInputStream2);
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.o(4017);
                    return r;
                } catch (Exception e2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(4017);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    AppMethodBeat.o(4017);
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(4017);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(4017);
                throw th;
            }
        }
        AppMethodBeat.o(4017);
        return null;
    }
}
