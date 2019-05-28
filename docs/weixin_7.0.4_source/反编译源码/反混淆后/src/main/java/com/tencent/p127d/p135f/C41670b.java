package com.tencent.p127d.p135f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* renamed from: com.tencent.d.f.b */
public final class C41670b {
    public static byte[] compress(byte[] bArr) {
        AppMethodBeat.m2504i(114592);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e) {
            }
            AppMethodBeat.m2505o(114592);
            return toByteArray;
        } catch (Exception e2) {
            C45085h.m82711db("deflater(), exception: ".concat(String.valueOf(e2)));
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e3) {
            }
            AppMethodBeat.m2505o(114592);
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.m2505o(114592);
        }
    }

    /* renamed from: cl */
    public static byte[] m73072cl(byte[] bArr) {
        AppMethodBeat.m2504i(114593);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inflaterInputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Exception e) {
                C45085h.m82711db("inflater(), exception: ".concat(String.valueOf(e)));
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(114593);
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                AppMethodBeat.m2505o(114593);
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e4) {
        }
        AppMethodBeat.m2505o(114593);
        return toByteArray;
    }
}
