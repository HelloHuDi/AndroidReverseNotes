package com.tencent.mm.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    public static final String x(byte[] bArr) {
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
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static final byte[] y(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static String r(InputStream inputStream) {
        int i = 0;
        if (inputStream == null) {
            return null;
        }
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            byte[] digest;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr = new byte[102400];
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1 || i2 >= 256) {
                    digest = instance.digest();
                } else if (i2 + read <= 256) {
                    instance.update(bArr, 0, read);
                    i2 += read;
                } else {
                    instance.update(bArr, 0, 256 - i2);
                    i2 = 256;
                }
            }
            digest = instance.digest();
            while (i < digest.length) {
                stringBuilder.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
                i++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static final String b(InputStream inputStream, int i) {
        if (inputStream == null || i <= 0) {
            return null;
        }
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
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String cz(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return v(file);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A:{SYNTHETIC, Splitter:B:25:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String v(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        long j = 102400;
        if (file == null || !file.exists()) {
            return null;
        }
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
                    return b;
                } catch (IOException e) {
                    return b;
                }
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
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
            throw th;
        }
    }

    public static String cA(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return w(file);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A:{SYNTHETIC, Splitter:B:12:0x001d} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A:{SYNTHETIC, Splitter:B:18:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String w(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        if (!file.exists()) {
            return null;
        }
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
                return r;
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e4) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }
}
