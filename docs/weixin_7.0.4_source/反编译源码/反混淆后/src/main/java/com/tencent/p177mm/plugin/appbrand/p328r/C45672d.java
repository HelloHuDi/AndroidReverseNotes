package com.tencent.p177mm.plugin.appbrand.p328r;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.r.d */
public final class C45672d {
    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.m2504i(91137);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            String stringWriter2;
            try {
                int read = inputStreamReader.read(cArr);
                if (-1 != read) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.m2505o(91137);
                    return stringWriter2;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandIOUtil", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(inputStream);
                AppMethodBeat.m2505o(91137);
            }
        }
    }

    /* renamed from: Eb */
    public static String m84370Eb(String str) {
        AppMethodBeat.m2504i(91138);
        InputStream inputStream = null;
        try {
            inputStream = C4996ah.getContext().getAssets().open(str);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, C5046bo.m7574l(e));
        }
        String str2;
        if (inputStream == null) {
            str2 = "";
            AppMethodBeat.m2505o(91138);
            return str2;
        }
        str2 = C45672d.convertStreamToString(inputStream);
        AppMethodBeat.m2505o(91138);
        return str2;
    }

    /* renamed from: Ec */
    public static byte[] m84371Ec(String str) {
        AppMethodBeat.m2504i(91139);
        InputStream inputStream = null;
        try {
            inputStream = C4996ah.getContext().getAssets().open(str);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, C5046bo.m7574l(e));
        }
        byte[] bArr;
        if (inputStream == null) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(91139);
            return bArr;
        }
        bArr = C45672d.m84373k(inputStream);
        AppMethodBeat.m2505o(91139);
        return bArr;
    }

    /* renamed from: k */
    public static byte[] m84373k(InputStream inputStream) {
        byte[] bArr;
        AppMethodBeat.m2504i(91140);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandIOUtil", "readPkgCertificate: ".concat(String.valueOf(e)));
                bArr = new byte[0];
                return bArr;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.AppBrandIOUtil", "close: ".concat(String.valueOf(e2)));
                }
                AppMethodBeat.m2505o(91140);
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e22) {
            C4990ab.m7412e("MicroMsg.AppBrandIOUtil", "close: ".concat(String.valueOf(e22)));
        }
        bArr = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(91140);
        return bArr;
    }

    /* renamed from: Ed */
    public static boolean m84372Ed(String str) {
        AppMethodBeat.m2504i(91141);
        if (C5046bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.m2505o(91141);
            return false;
        }
        AppMethodBeat.m2505o(91141);
        return true;
    }

    /* renamed from: q */
    public static byte[] m84374q(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(91142);
        byte[] bArr;
        if (byteBuffer == null) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(91142);
            return bArr;
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
            AppMethodBeat.m2505o(91142);
            return bArr;
        } else {
            bArr = byteBuffer.array();
            AppMethodBeat.m2505o(91142);
            return bArr;
        }
    }
}
