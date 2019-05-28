package com.tencent.p177mm.loader.p246e;

import com.tencent.p177mm.loader.p245d.C32727c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.mm.loader.e.d */
public final class C9571d implements C32727c {
    /* renamed from: b */
    public final boolean mo20892b(String str, InputStream inputStream) {
        if (inputStream == null) {
            C4990ab.m7420w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            return false;
        } else {
            try {
                String w = C4995ag.m7429w(C9571d.m17056a(inputStream, true));
                if (C5046bo.isNullOrNil(w) || !w.equals(str)) {
                    C4990ab.m7421w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
                    return false;
                }
                C4990ab.m7416i("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check success");
                return true;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                return false;
            }
        }
    }

    /* renamed from: a */
    public static byte[] m17056a(InputStream inputStream, boolean z) {
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
