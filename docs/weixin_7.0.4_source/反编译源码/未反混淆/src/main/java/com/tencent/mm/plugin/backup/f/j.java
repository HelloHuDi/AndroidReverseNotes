package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class j {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8 A:{SYNTHETIC, Splitter:B:30:0x00b8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(byte[] bArr, int i, short s, PByteArray pByteArray, int i2) {
        Throwable e;
        AppMethodBeat.i(17469);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write("GSMW".getBytes());
                byteArrayOutputStream.write(o.fZ(i));
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 1});
                byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
                if (!(s == (short) 1 || s == (short) 2)) {
                    bArr = l.d(bArr, d.aSy());
                }
                byteArrayOutputStream.write(o.fZ(bArr.length + 20));
                byteArrayOutputStream.write(o.fZ(0));
                byteArrayOutputStream.write(bArr);
                pByteArray.value = byteArrayOutputStream.toByteArray();
                if (i2 == 1) {
                    CRC32 crc32 = new CRC32();
                    crc32.update(pByteArray.value);
                    System.arraycopy(o.fZ((int) crc32.getValue()), 0, pByteArray.value, 16, 4);
                }
                try {
                    byteArrayOutputStream.reset();
                    byteArrayOutputStream.close();
                    AppMethodBeat.o(17469);
                } catch (IOException e2) {
                    AppMethodBeat.o(17469);
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            try {
                ab.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker pack err.", new Object[0]);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.reset();
                        byteArrayOutputStream.close();
                        AppMethodBeat.o(17469);
                        return;
                    } catch (IOException e5) {
                        AppMethodBeat.o(17469);
                        return;
                    }
                }
                AppMethodBeat.o(17469);
            } catch (Throwable th) {
                e = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.reset();
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(17469);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            AppMethodBeat.o(17469);
            throw e;
        }
    }

    public static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        AppMethodBeat.i(17470);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(o.fZ(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & 255), (byte) (s2 & 255)});
            byteArrayOutputStream.write(o.fZ(i2));
            byteArrayOutputStream.write(o.fZ(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            i3 = (int) crc32.getValue();
            AppMethodBeat.o(17470);
            return i3;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker getCheckSum error.", new Object[i3]);
            AppMethodBeat.o(17470);
            return i3;
        }
    }

    public static String ap(byte[] bArr) {
        AppMethodBeat.i(17471);
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        ab.e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", str);
        AppMethodBeat.o(17471);
        return str;
    }
}
