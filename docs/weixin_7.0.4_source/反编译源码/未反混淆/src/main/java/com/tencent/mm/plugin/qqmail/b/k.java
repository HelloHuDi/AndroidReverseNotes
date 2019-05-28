package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class k {
    public static int ptP = 100;
    private int ehD = ptP;
    public String ptQ = null;

    public k(String str, int i) {
        AppMethodBeat.i(67933);
        ab.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.ptQ = str;
        File file = new File(this.ptQ);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = ptP;
        }
        this.ehD = i;
        AppMethodBeat.o(67933);
    }

    public final byte[] t(String str, Map<String, String> map) {
        AppMethodBeat.i(67934);
        if (str == null || str.length() == 0) {
            ab.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            AppMethodBeat.o(67934);
            return null;
        }
        String u = u(str, map);
        byte[] readFromFile = readFromFile(this.ptQ + u);
        if (readFromFile == null) {
            ab.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            AppMethodBeat.o(67934);
            return null;
        }
        byte[] decrypt = decrypt(readFromFile, Ve(u));
        if (decrypt == null) {
            ab.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
            AppMethodBeat.o(67934);
            return null;
        }
        AppMethodBeat.o(67934);
        return decrypt;
    }

    public final boolean a(String str, Map<String, String> map, byte[] bArr) {
        AppMethodBeat.i(67935);
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            ab.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            AppMethodBeat.o(67935);
            return false;
        }
        cco();
        String u = u(str, map);
        byte[] encrypt = encrypt(bArr, Ve(u));
        if (encrypt == null) {
            ab.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
            AppMethodBeat.o(67935);
            return false;
        }
        boolean z = z(this.ptQ + u, encrypt);
        AppMethodBeat.o(67935);
        return z;
    }

    private static String u(String str, Map<String, String> map) {
        String str2;
        AppMethodBeat.i(67936);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                stringBuffer.append(str2);
                stringBuffer.append(str3);
            }
        }
        str2 = g.x(stringBuffer.toString().getBytes());
        AppMethodBeat.o(67936);
        return str2;
    }

    private static byte[] Ve(String str) {
        AppMethodBeat.i(67937);
        byte[] bytes = g.x(str.toString().getBytes()).substring(8, 16).getBytes();
        AppMethodBeat.o(67937);
        return bytes;
    }

    private static int Vf(String str) {
        AppMethodBeat.i(67938);
        String[] list = new File(str).list();
        if (list != null) {
            int length = list.length;
            AppMethodBeat.o(67938);
            return length;
        }
        AppMethodBeat.o(67938);
        return 0;
    }

    public final void cco() {
        AppMethodBeat.i(67939);
        if (Vf(this.ptQ) < this.ehD) {
            AppMethodBeat.o(67939);
            return;
        }
        File file = null;
        for (String file2 : new File(this.ptQ).list()) {
            file = new File(file2);
            file.lastModified();
        }
        if (file.exists()) {
            file.delete();
        }
        AppMethodBeat.o(67939);
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.i(67940);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.o(67940);
        return doFinal;
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.i(67941);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.o(67941);
        return doFinal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a A:{SYNTHETIC, Splitter:B:33:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        AppMethodBeat.i(67942);
        try {
            File file = new File(str);
            if (file.exists()) {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                        }
                        AppMethodBeat.o(67942);
                        return null;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                    }
                    AppMethodBeat.o(67942);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                AppMethodBeat.o(67942);
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th) {
            e = th;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e32) {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e32, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67942);
            throw e;
        }
        try {
            ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67942);
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(67942);
            throw e;
        }
        AppMethodBeat.o(67942);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050 A:{SYNTHETIC, Splitter:B:23:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A:{SYNTHETIC, Splitter:B:15:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean z(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.i(67943);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                AppMethodBeat.o(67943);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(67943);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(67943);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67943);
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67943);
            throw e;
        }
    }
}
