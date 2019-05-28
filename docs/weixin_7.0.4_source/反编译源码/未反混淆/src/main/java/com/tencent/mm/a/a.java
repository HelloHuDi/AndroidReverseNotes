package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static boolean g(String str, String str2, String str3) {
        return a(str, "AES/CBC/PKCS7Padding", str2, str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(String str, String str2, String str3, String str4) {
        Exception e;
        Throwable th;
        if (bo.isNullOrNil(str2)) {
            throw new InvalidParameterException("invalid cipherTransformation");
        }
        File file = new File(str3);
        File file2 = new File(str4);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        file2.createNewFile();
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        CipherOutputStream cipherOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                    Cipher instance = Cipher.getInstance(str2);
                    instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                    cipherOutputStream = new CipherOutputStream(fileOutputStream, instance);
                    try {
                        decode = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = fileInputStream.read(decode);
                            if (read != -1) {
                                cipherOutputStream.write(decode, 0, read);
                                cipherOutputStream.flush();
                            } else {
                                cipherOutputStream.close();
                                fileOutputStream.close();
                                fileInputStream.close();
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    cipherOutputStream = null;
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    cipherOutputStream = null;
                    if (cipherOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                cipherOutputStream = null;
                fileOutputStream = null;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                cipherOutputStream = null;
                fileOutputStream = null;
                if (cipherOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            cipherOutputStream = null;
            fileOutputStream = null;
            fileInputStream = null;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            cipherOutputStream = null;
            fileOutputStream = null;
            fileInputStream = null;
            if (cipherOutputStream != null) {
                cipherOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static byte[] cq(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    @Deprecated
    public static String x(String str, String str2) {
        if (bo.isNullOrNil(str)) {
            return "";
        }
        try {
            return new String(c(cq(str), str2));
        } catch (Exception e) {
            ab.e("MicroMsg.AESUtils", bo.l(e));
            return str;
        }
    }

    @Deprecated
    private static byte[] c(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            ab.e("MicroMsg.AESUtils", bo.l(e));
            return null;
        }
    }
}
