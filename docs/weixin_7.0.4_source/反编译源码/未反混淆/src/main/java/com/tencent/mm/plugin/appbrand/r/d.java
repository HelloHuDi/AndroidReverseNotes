package com.tencent.mm.plugin.appbrand.r;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class d {
    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(91137);
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
                    bo.b(inputStreamReader);
                    bo.b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.o(91137);
                    return stringWriter2;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandIOUtil", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                bo.b(inputStreamReader);
                bo.b(inputStream);
                AppMethodBeat.o(91137);
            }
        }
    }

    public static String Eb(String str) {
        AppMethodBeat.i(91138);
        InputStream inputStream = null;
        try {
            inputStream = ah.getContext().getAssets().open(str);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, bo.l(e));
        }
        String str2;
        if (inputStream == null) {
            str2 = "";
            AppMethodBeat.o(91138);
            return str2;
        }
        str2 = convertStreamToString(inputStream);
        AppMethodBeat.o(91138);
        return str2;
    }

    public static byte[] Ec(String str) {
        AppMethodBeat.i(91139);
        InputStream inputStream = null;
        try {
            inputStream = ah.getContext().getAssets().open(str);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, bo.l(e));
        }
        byte[] bArr;
        if (inputStream == null) {
            bArr = new byte[0];
            AppMethodBeat.o(91139);
            return bArr;
        }
        bArr = k(inputStream);
        AppMethodBeat.o(91139);
        return bArr;
    }

    public static byte[] k(InputStream inputStream) {
        byte[] bArr;
        AppMethodBeat.i(91140);
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
                ab.e("MicroMsg.AppBrandIOUtil", "readPkgCertificate: ".concat(String.valueOf(e)));
                bArr = new byte[0];
                return bArr;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    ab.e("MicroMsg.AppBrandIOUtil", "close: ".concat(String.valueOf(e2)));
                }
                AppMethodBeat.o(91140);
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e22) {
            ab.e("MicroMsg.AppBrandIOUtil", "close: ".concat(String.valueOf(e22)));
        }
        bArr = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(91140);
        return bArr;
    }

    public static boolean Ed(String str) {
        AppMethodBeat.i(91141);
        if (bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.o(91141);
            return false;
        }
        AppMethodBeat.o(91141);
        return true;
    }

    public static byte[] q(ByteBuffer byteBuffer) {
        AppMethodBeat.i(91142);
        byte[] bArr;
        if (byteBuffer == null) {
            bArr = new byte[0];
            AppMethodBeat.o(91142);
            return bArr;
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
            AppMethodBeat.o(91142);
            return bArr;
        } else {
            bArr = byteBuffer.array();
            AppMethodBeat.o(91142);
            return bArr;
        }
    }
}
