package com.tencent.mm.plugin.appbrand.t.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public final class b {
    public static CodingErrorAction iTM = CodingErrorAction.REPORT;

    public static byte[] Es(String str) {
        AppMethodBeat.i(73274);
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF8");
            AppMethodBeat.o(73274);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            bytes = new byte[0];
            AppMethodBeat.o(73274);
            return bytes;
        }
    }

    public static byte[] Et(String str) {
        AppMethodBeat.i(73275);
        byte[] bytes;
        try {
            bytes = str.getBytes("ASCII");
            AppMethodBeat.o(73275);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            bytes = new byte[0];
            AppMethodBeat.o(73275);
            return bytes;
        }
    }

    public static String H(byte[] bArr, int i) {
        AppMethodBeat.i(73276);
        String str;
        try {
            str = new String(bArr, 0, i, "ASCII");
            AppMethodBeat.o(73276);
            return str;
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandNetWork.Charsetfunctions", e.toString());
            str = "";
            AppMethodBeat.o(73276);
            return str;
        }
    }

    public static String B(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73277);
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(iTM);
        newDecoder.onUnmappableCharacter(iTM);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            AppMethodBeat.o(73277);
            return charBuffer;
        } catch (CharacterCodingException e) {
            com.tencent.mm.plugin.appbrand.t.c.b bVar = new com.tencent.mm.plugin.appbrand.t.c.b(1007, e);
            AppMethodBeat.o(73277);
            throw bVar;
        }
    }
}
