package com.tencent.p177mm.plugin.p468n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p878a.C26533g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.n.f */
public final class C12692f {
    List<C26533g> gkn;
    List<Pair> gko;
    RandomAccessFile ort;
    C26533g oru;
    int orv;
    int orw;

    /* renamed from: J */
    public final int mo24675J(ByteBuffer byteBuffer) {
        Throwable e;
        AppMethodBeat.m2504i(117870);
        if (this.orv >= this.orw) {
            AppMethodBeat.m2505o(117870);
            return -1;
        }
        int read;
        try {
            this.ort.seek(this.oru.start);
            byte[] bArr = new byte[this.oru.size];
            read = this.ort.read(bArr);
            try {
                if (read < this.oru.size) {
                    AppMethodBeat.m2505o(117870);
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
                AppMethodBeat.m2505o(117870);
                return read;
            } catch (Exception e2) {
                e = e2;
                C4990ab.printErrStackTrace("MicroMsg.Mp4Extractor", e, "read sample data error", new Object[0]);
                AppMethodBeat.m2505o(117870);
                return read;
            }
        } catch (Exception e3) {
            e = e3;
            read = -1;
        }
    }
}
