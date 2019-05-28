package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d implements c {
    public final boolean b(String str, InputStream inputStream) {
        if (inputStream == null) {
            ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String w = ag.w(a(inputStream, true));
                if (bo.isNullOrNil(w) || !w.equals(str)) {
                    ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
                    return false;
                }
                ab.i("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        return bArr;
    }
}
