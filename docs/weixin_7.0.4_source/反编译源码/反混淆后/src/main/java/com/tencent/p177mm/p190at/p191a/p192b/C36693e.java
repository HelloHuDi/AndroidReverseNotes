package com.tencent.p177mm.p190at.p191a.p192b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p193c.C32281k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: com.tencent.mm.at.a.b.e */
public final class C36693e implements C32281k {
    /* renamed from: aM */
    public final boolean mo52984aM(String str, String str2) {
        AppMethodBeat.m2504i(116084);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            AppMethodBeat.m2505o(116084);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.m2505o(116084);
            return false;
        } else {
            String cz = C1178g.m2587cz(str2);
            if (C5046bo.isNullOrNil(cz) || !cz.equals(str)) {
                C4990ab.m7421w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", cz, str);
                AppMethodBeat.m2505o(116084);
                return false;
            }
            C4990ab.m7416i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            AppMethodBeat.m2505o(116084);
            return true;
        }
    }

    /* renamed from: p */
    public final boolean mo52986p(String str, byte[] bArr) {
        AppMethodBeat.m2504i(116085);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.m2505o(116085);
            return false;
        }
        String w = C4995ag.m7429w(bArr);
        if (C5046bo.isNullOrNil(w) || !w.equals(str)) {
            C4990ab.m7421w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
            AppMethodBeat.m2505o(116085);
            return false;
        }
        C4990ab.m7416i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.m2505o(116085);
        return true;
    }

    /* renamed from: b */
    public final boolean mo52985b(String str, InputStream inputStream) {
        AppMethodBeat.m2504i(116086);
        if (inputStream == null) {
            C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            AppMethodBeat.m2505o(116086);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.m2505o(116086);
            return false;
        } else {
            try {
                inputStream.mark(inputStream.available());
                String w = C4995ag.m7429w(C36693e.m60877a(inputStream, true));
                inputStream.reset();
                if (C5046bo.isNullOrNil(w) || !w.equals(str)) {
                    C4990ab.m7421w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", w, str);
                    AppMethodBeat.m2505o(116086);
                    return false;
                }
                C4990ab.m7416i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                AppMethodBeat.m2505o(116086);
                return true;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e.toString());
                AppMethodBeat.m2505o(116086);
                return false;
            }
        }
    }

    /* renamed from: y */
    public static byte[] m60878y(InputStream inputStream) {
        AppMethodBeat.m2504i(116087);
        byte[] a = C36693e.m60877a(inputStream, false);
        AppMethodBeat.m2505o(116087);
        return a;
    }

    /* renamed from: a */
    public static byte[] m60877a(InputStream inputStream, boolean z) {
        AppMethodBeat.m2504i(116088);
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
        AppMethodBeat.m2505o(116088);
        return bArr;
    }
}
