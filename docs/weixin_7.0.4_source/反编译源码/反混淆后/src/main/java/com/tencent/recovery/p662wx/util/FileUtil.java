package com.tencent.recovery.p662wx.util;

import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.recovery.wx.util.FileUtil */
public class FileUtil {
    /* renamed from: q */
    public static byte[] m8749q(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        int i = 0;
        while (true) {
            try {
                i = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } catch (IOException e) {
            }
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A:{SYNTHETIC, Splitter:B:10:0x0017} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A:{SYNTHETIC, Splitter:B:16:0x0020} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ae */
    public static String m8748ae(File file) {
        InputStream inputStream;
        Throwable th;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String str = new String(FileUtil.m8749q(fileInputStream));
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e) {
                    return str;
                }
            } catch (Exception e2) {
                inputStream = fileInputStream;
                if (inputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception e3) {
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }
}
