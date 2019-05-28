package com.tencent.p177mm.plugin.appbrand.p332t.p1539f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* renamed from: com.tencent.mm.plugin.appbrand.t.f.b */
public final class C42690b {
    public static CodingErrorAction iTM = CodingErrorAction.REPORT;

    /* renamed from: Es */
    public static byte[] m75608Es(String str) {
        AppMethodBeat.m2504i(73274);
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF8");
            AppMethodBeat.m2505o(73274);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            bytes = new byte[0];
            AppMethodBeat.m2505o(73274);
            return bytes;
        }
    }

    /* renamed from: Et */
    public static byte[] m75609Et(String str) {
        AppMethodBeat.m2504i(73275);
        byte[] bytes;
        try {
            bytes = str.getBytes("ASCII");
            AppMethodBeat.m2505o(73275);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            bytes = new byte[0];
            AppMethodBeat.m2505o(73275);
            return bytes;
        }
    }

    /* renamed from: H */
    public static String m75610H(byte[] bArr, int i) {
        AppMethodBeat.m2504i(73276);
        String str;
        try {
            str = new String(bArr, 0, i, "ASCII");
            AppMethodBeat.m2505o(73276);
            return str;
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            str = "";
            AppMethodBeat.m2505o(73276);
            return str;
        }
    }

    /* renamed from: B */
    public static String m75607B(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73277);
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(iTM);
        newDecoder.onUnmappableCharacter(iTM);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            AppMethodBeat.m2505o(73277);
            return charBuffer;
        } catch (CharacterCodingException e) {
            C27301b c27301b = new C27301b(1007, e);
            AppMethodBeat.m2505o(73277);
            throw c27301b;
        }
    }
}
