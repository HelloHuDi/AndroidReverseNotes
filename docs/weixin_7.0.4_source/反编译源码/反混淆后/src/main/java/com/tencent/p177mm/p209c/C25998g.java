package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* renamed from: com.tencent.mm.c.g */
public final class C25998g {
    /* renamed from: a */
    private static String m41487a(InputStream inputStream, int i, byte[] bArr) {
        String str = null;
        int i2 = 0;
        AppMethodBeat.m2504i(125688);
        if (i <= 0) {
            AppMethodBeat.m2505o(125688);
        } else {
            try {
                if (inputStream.skip(0) < 0) {
                    AppMethodBeat.m2505o(125688);
                } else {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    StringBuilder stringBuilder = new StringBuilder(32);
                    byte[] bArr2 = new byte[102400];
                    int i3 = 0;
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1 || i3 >= i) {
                            if (bArr != null && bArr.length > 0) {
                                instance.update(bArr);
                            }
                        } else if (i3 + read <= i) {
                            instance.update(bArr2, 0, read);
                            i3 += read;
                        } else {
                            instance.update(bArr2, 0, i - i3);
                            i3 = i;
                        }
                    }
                    instance.update(bArr);
                    byte[] digest = instance.digest();
                    while (i2 < digest.length) {
                        stringBuilder.append(Integer.toString((digest[i2] & 255) + 256, 16).substring(1));
                        i2++;
                    }
                    str = stringBuilder.toString();
                    AppMethodBeat.m2505o(125688);
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(125688);
            }
        }
        return str;
    }

    /* renamed from: b */
    private static String m41488b(InputStream inputStream, int i) {
        String str = null;
        AppMethodBeat.m2504i(125689);
        if (i <= 0) {
            AppMethodBeat.m2505o(125689);
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
                AppMethodBeat.m2505o(125689);
            } catch (Exception e) {
                AppMethodBeat.m2505o(125689);
            }
        }
        return str;
    }

    /* renamed from: cz */
    public static String m41489cz(String str) {
        AppMethodBeat.m2504i(125690);
        if (str == null) {
            AppMethodBeat.m2505o(125690);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            String v = C25998g.m41490v(file);
            AppMethodBeat.m2505o(125690);
            return v;
        }
        AppMethodBeat.m2505o(125690);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A:{SYNTHETIC, Splitter:B:23:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    private static String m41490v(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        long j = 102400;
        AppMethodBeat.m2504i(125691);
        if (file.exists()) {
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    if (102400 > file.length()) {
                        j = file.length();
                    }
                    String b = C25998g.m41488b(fileInputStream2, (int) j);
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(125691);
                    return b;
                } catch (Exception e2) {
                    fileInputStream = fileInputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(125691);
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
                AppMethodBeat.m2505o(125691);
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
                AppMethodBeat.m2505o(125691);
                throw th;
            }
        }
        AppMethodBeat.m2505o(125691);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A:{SYNTHETIC, Splitter:B:14:0x002b} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A:{SYNTHETIC, Splitter:B:20:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m41486a(File file, int i, byte[] bArr) {
        FileInputStream fileInputStream;
        Throwable th;
        AppMethodBeat.m2504i(125692);
        if (!file.exists() || i <= 0) {
            AppMethodBeat.m2505o(125692);
            return null;
        }
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                String a = C25998g.m41487a((InputStream) fileInputStream2, i, bArr);
                fileInputStream2.close();
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                }
                AppMethodBeat.m2505o(125692);
                return a;
            } catch (Exception e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                AppMethodBeat.m2505o(125692);
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                AppMethodBeat.m2505o(125692);
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
            AppMethodBeat.m2505o(125692);
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
            AppMethodBeat.m2505o(125692);
            throw th;
        }
    }
}
