package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.k;
import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.RandomAccessFile;

public final class j {
    private static final k cdq = new k(101010256);

    static {
        AppMethodBeat.i(2333);
        AppMethodBeat.o(2333);
    }

    public static byte[] Im(String str) {
        AppMethodBeat.i(2332);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(2332);
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            ab.i("MicroMsg.Channel.ZipEocdCommentTool", "apk file length is zero");
            AppMethodBeat.o(2332);
            return null;
        }
        byte[] bArr;
        try {
            File file = new File(str);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            randomAccessFile2.seek((((Long) h.N(file).second).longValue() + 22) - 2);
            bArr = new byte[2];
            randomAccessFile2.readFully(bArr);
            int i = new l(bArr).value;
            if (i == 0) {
                bArr = null;
            } else {
                bArr = new byte[i];
                randomAccessFile2.read(bArr);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.Channel.ZipEocdCommentTool", "readComment, error: %s", e.getMessage());
            bArr = null;
        }
        randomAccessFile.close();
        AppMethodBeat.o(2332);
        return bArr;
    }
}
