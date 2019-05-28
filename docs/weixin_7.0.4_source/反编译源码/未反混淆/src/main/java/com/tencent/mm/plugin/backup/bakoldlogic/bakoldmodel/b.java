package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class b {
    public static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        AppMethodBeat.i(17752);
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
            AppMethodBeat.o(17752);
            return i3;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.BakOldPacker", e, "", new Object[i3]);
            AppMethodBeat.o(17752);
            return i3;
        }
    }

    public static String ap(byte[] bArr) {
        AppMethodBeat.i(17753);
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        ab.e("MicroMsg.BakOldPacker", "dump errBuf: %s", str);
        AppMethodBeat.o(17753);
        return str;
    }
}
