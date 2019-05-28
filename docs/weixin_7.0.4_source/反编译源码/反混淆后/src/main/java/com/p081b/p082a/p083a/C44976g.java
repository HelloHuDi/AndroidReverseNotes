package com.p081b.p082a.p083a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.b.a.a.g */
final class C44976g {
    protected static byte[] compress(byte[] bArr) {
        AppMethodBeat.m2504i(55583);
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Error | Exception e) {
        }
        AppMethodBeat.m2505o(55583);
        return bArr2;
    }
}
