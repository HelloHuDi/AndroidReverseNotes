package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements k {
    public final boolean aM(String str, String str2) {
        AppMethodBeat.i(116084);
        if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            AppMethodBeat.o(116084);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(116084);
            return false;
        } else {
            String cz = g.cz(str2);
            if (bo.isNullOrNil(cz) || !cz.equals(str)) {
                ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", cz, str);
                AppMethodBeat.o(116084);
                return false;
            }
            ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            AppMethodBeat.o(116084);
            return true;
        }
    }

    public final boolean p(String str, byte[] bArr) {
        AppMethodBeat.i(116085);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(116085);
            return false;
        }
        String w = ag.w(bArr);
        if (bo.isNullOrNil(w) || !w.equals(str)) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
            AppMethodBeat.o(116085);
            return false;
        }
        ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.o(116085);
        return true;
    }

    public final boolean b(String str, InputStream inputStream) {
        AppMethodBeat.i(116086);
        if (inputStream == null) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            AppMethodBeat.o(116086);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(116086);
            return false;
        } else {
            try {
                inputStream.mark(inputStream.available());
                String w = ag.w(a(inputStream, true));
                inputStream.reset();
                if (bo.isNullOrNil(w) || !w.equals(str)) {
                    ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
                    AppMethodBeat.o(116086);
                    return false;
                }
                ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                AppMethodBeat.o(116086);
                return true;
            } catch (Exception e) {
                ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                AppMethodBeat.o(116086);
                return false;
            }
        }
    }

    public static byte[] y(InputStream inputStream) {
        AppMethodBeat.i(116087);
        byte[] a = a(inputStream, false);
        AppMethodBeat.o(116087);
        return a;
    }

    public static byte[] a(InputStream inputStream, boolean z) {
        AppMethodBeat.i(116088);
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
        AppMethodBeat.o(116088);
        return bArr;
    }
}
