package com.tencent.mm.plugin.n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f {
    List<g> gkn;
    List<Pair> gko;
    RandomAccessFile ort;
    g oru;
    int orv;
    int orw;

    public final int J(ByteBuffer byteBuffer) {
        Throwable e;
        AppMethodBeat.i(117870);
        if (this.orv >= this.orw) {
            AppMethodBeat.o(117870);
            return -1;
        }
        int read;
        try {
            this.ort.seek(this.oru.start);
            byte[] bArr = new byte[this.oru.size];
            read = this.ort.read(bArr);
            try {
                if (read < this.oru.size) {
                    AppMethodBeat.o(117870);
                    return -1;
                }
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                bArr[3] = (byte) 1;
                int i = 0;
                while (i < read) {
                    if (bArr[i] == Byte.MIN_VALUE && i + 4 < read && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 0) {
                        bArr[i + 3] = (byte) 0;
                        bArr[i + 4] = (byte) 1;
                    }
                    i++;
                }
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, read).flip();
                AppMethodBeat.o(117870);
                return read;
            } catch (Exception e2) {
                e = e2;
                ab.printErrStackTrace("MicroMsg.Mp4Extractor", e, "read sample data error", new Object[0]);
                AppMethodBeat.o(117870);
                return read;
            }
        } catch (Exception e3) {
            e = e3;
            read = -1;
        }
    }
}
