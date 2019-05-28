package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b */
public final class C11113b {
    /* renamed from: a */
    public static int m18826a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        AppMethodBeat.m2504i(17752);
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
            AppMethodBeat.m2505o(17752);
            return i3;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.BakOldPacker", e, "", new Object[i3]);
            AppMethodBeat.m2505o(17752);
            return i3;
        }
    }

    /* renamed from: ap */
    public static String m18827ap(byte[] bArr) {
        AppMethodBeat.m2504i(17753);
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        C4990ab.m7413e("MicroMsg.BakOldPacker", "dump errBuf: %s", str);
        AppMethodBeat.m2505o(17753);
        return str;
    }
}
