package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class b {
    public static byte[] compress(byte[] bArr) {
        AppMethodBeat.i(114592);
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
            AppMethodBeat.o(114592);
            return toByteArray;
        } catch (Exception e2) {
            h.db("deflater(), exception: ".concat(String.valueOf(e2)));
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e3) {
            }
            AppMethodBeat.o(114592);
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e4) {
            }
            AppMethodBeat.o(114592);
        }
    }

    public static byte[] cl(byte[] bArr) {
        AppMethodBeat.i(114593);
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
                h.db("inflater(), exception: ".concat(String.valueOf(e)));
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.o(114593);
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
                AppMethodBeat.o(114593);
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e4) {
        }
        AppMethodBeat.o(114593);
        return toByteArray;
    }
}
