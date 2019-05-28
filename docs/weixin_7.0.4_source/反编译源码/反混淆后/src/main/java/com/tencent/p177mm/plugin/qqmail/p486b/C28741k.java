package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.plugin.qqmail.b.k */
public final class C28741k {
    public static int ptP = 100;
    private int ehD = ptP;
    public String ptQ = null;

    public C28741k(String str, int i) {
        AppMethodBeat.m2504i(67933);
        C4990ab.m7416i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.ptQ = str;
        File file = new File(this.ptQ);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = ptP;
        }
        this.ehD = i;
        AppMethodBeat.m2505o(67933);
    }

    /* renamed from: t */
    public final byte[] mo46895t(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(67934);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            AppMethodBeat.m2505o(67934);
            return null;
        }
        String u = C28741k.m45673u(str, map);
        byte[] readFromFile = C28741k.readFromFile(this.ptQ + u);
        if (readFromFile == null) {
            C4990ab.m7416i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            AppMethodBeat.m2505o(67934);
            return null;
        }
        byte[] decrypt = C28741k.decrypt(readFromFile, C28741k.m45671Ve(u));
        if (decrypt == null) {
            C4990ab.m7412e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
            AppMethodBeat.m2505o(67934);
            return null;
        }
        AppMethodBeat.m2505o(67934);
        return decrypt;
    }

    /* renamed from: a */
    public final boolean mo46893a(String str, Map<String, String> map, byte[] bArr) {
        AppMethodBeat.m2504i(67935);
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            C4990ab.m7412e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            AppMethodBeat.m2505o(67935);
            return false;
        }
        cco();
        String u = C28741k.m45673u(str, map);
        byte[] encrypt = C28741k.encrypt(bArr, C28741k.m45671Ve(u));
        if (encrypt == null) {
            C4990ab.m7412e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
            AppMethodBeat.m2505o(67935);
            return false;
        }
        boolean z = C28741k.m45674z(this.ptQ + u, encrypt);
        AppMethodBeat.m2505o(67935);
        return z;
    }

    /* renamed from: u */
    private static String m45673u(String str, Map<String, String> map) {
        String str2;
        AppMethodBeat.m2504i(67936);
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
        str2 = C1178g.m2591x(stringBuffer.toString().getBytes());
        AppMethodBeat.m2505o(67936);
        return str2;
    }

    /* renamed from: Ve */
    private static byte[] m45671Ve(String str) {
        AppMethodBeat.m2504i(67937);
        byte[] bytes = C1178g.m2591x(str.toString().getBytes()).substring(8, 16).getBytes();
        AppMethodBeat.m2505o(67937);
        return bytes;
    }

    /* renamed from: Vf */
    private static int m45672Vf(String str) {
        AppMethodBeat.m2504i(67938);
        String[] list = new File(str).list();
        if (list != null) {
            int length = list.length;
            AppMethodBeat.m2505o(67938);
            return length;
        }
        AppMethodBeat.m2505o(67938);
        return 0;
    }

    public final void cco() {
        AppMethodBeat.m2504i(67939);
        if (C28741k.m45672Vf(this.ptQ) < this.ehD) {
            AppMethodBeat.m2505o(67939);
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
        AppMethodBeat.m2505o(67939);
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.m2504i(67940);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.m2505o(67940);
        return doFinal;
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.m2504i(67941);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.m2505o(67941);
        return doFinal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a A:{SYNTHETIC, Splitter:B:33:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        AppMethodBeat.m2504i(67942);
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
                            C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                        }
                        AppMethodBeat.m2505o(67942);
                        return null;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(67942);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                AppMethodBeat.m2505o(67942);
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
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e32, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(67942);
            throw e;
        }
        try {
            C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(67942);
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(67942);
            throw e;
        }
        AppMethodBeat.m2505o(67942);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050 A:{SYNTHETIC, Splitter:B:23:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A:{SYNTHETIC, Splitter:B:15:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    public static boolean m45674z(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.m2504i(67943);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                AppMethodBeat.m2505o(67943);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(67943);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(67943);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(67943);
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(67943);
            throw e;
        }
    }
}
