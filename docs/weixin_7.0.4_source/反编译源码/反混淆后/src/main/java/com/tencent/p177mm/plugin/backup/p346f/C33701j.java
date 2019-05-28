package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* renamed from: com.tencent.mm.plugin.backup.f.j */
public final class C33701j {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8 A:{SYNTHETIC, Splitter:B:30:0x00b8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m55070a(byte[] bArr, int i, short s, PByteArray pByteArray, int i2) {
        Throwable e;
        AppMethodBeat.m2504i(17469);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write("GSMW".getBytes());
                byteArrayOutputStream.write(C37432o.m63091fZ(i));
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 1});
                byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
                if (!(s == (short) 1 || s == (short) 2)) {
                    bArr = C1182l.m2608d(bArr, C38634d.aSy());
                }
                byteArrayOutputStream.write(C37432o.m63091fZ(bArr.length + 20));
                byteArrayOutputStream.write(C37432o.m63091fZ(0));
                byteArrayOutputStream.write(bArr);
                pByteArray.value = byteArrayOutputStream.toByteArray();
                if (i2 == 1) {
                    CRC32 crc32 = new CRC32();
                    crc32.update(pByteArray.value);
                    System.arraycopy(C37432o.m63091fZ((int) crc32.getValue()), 0, pByteArray.value, 16, 4);
                }
                try {
                    byteArrayOutputStream.reset();
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(17469);
                } catch (IOException e2) {
                    AppMethodBeat.m2505o(17469);
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            try {
                C4990ab.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker pack err.", new Object[0]);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.reset();
                        byteArrayOutputStream.close();
                        AppMethodBeat.m2505o(17469);
                        return;
                    } catch (IOException e5) {
                        AppMethodBeat.m2505o(17469);
                        return;
                    }
                }
                AppMethodBeat.m2505o(17469);
            } catch (Throwable th) {
                e = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.reset();
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(17469);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            AppMethodBeat.m2505o(17469);
            throw e;
        }
    }

    /* renamed from: a */
    public static int m55069a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        AppMethodBeat.m2504i(17470);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(C37432o.m63091fZ(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & 255), (byte) (s2 & 255)});
            byteArrayOutputStream.write(C37432o.m63091fZ(i2));
            byteArrayOutputStream.write(C37432o.m63091fZ(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            i3 = (int) crc32.getValue();
            AppMethodBeat.m2505o(17470);
            return i3;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPacker", e, "BackupPacker getCheckSum error.", new Object[i3]);
            AppMethodBeat.m2505o(17470);
            return i3;
        }
    }

    /* renamed from: ap */
    public static String m55071ap(byte[] bArr) {
        AppMethodBeat.m2504i(17471);
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        C4990ab.m7413e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", str);
        AppMethodBeat.m2505o(17471);
        return str;
    }
}
