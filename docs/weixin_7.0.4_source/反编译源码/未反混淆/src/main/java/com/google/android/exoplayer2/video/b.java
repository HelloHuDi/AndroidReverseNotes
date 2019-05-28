package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b {
    public final List<byte[]> aOf;
    public final int aTz;

    public static b M(l lVar) {
        AppMethodBeat.i(95995);
        try {
            int readUnsignedShort;
            int i;
            int i2;
            lVar.eM(21);
            int readUnsignedByte = lVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = lVar.readUnsignedByte();
            int i3 = lVar.position;
            int i4 = 0;
            int i5 = 0;
            while (i4 < readUnsignedByte2) {
                lVar.eM(1);
                readUnsignedShort = lVar.readUnsignedShort();
                i = i5;
                for (i2 = 0; i2 < readUnsignedShort; i2++) {
                    i5 = lVar.readUnsignedShort();
                    i += i5 + 4;
                    lVar.eM(i5);
                }
                i4++;
                i5 = i;
            }
            lVar.setPosition(i3);
            byte[] bArr = new byte[i5];
            i2 = 0;
            for (i4 = 0; i4 < readUnsignedByte2; i4++) {
                lVar.eM(1);
                readUnsignedShort = lVar.readUnsignedShort();
                for (i = 0; i < readUnsignedShort; i++) {
                    int readUnsignedShort2 = lVar.readUnsignedShort();
                    System.arraycopy(j.bqY, 0, bArr, i2, j.bqY.length);
                    i2 += j.bqY.length;
                    System.arraycopy(lVar.data, lVar.position, bArr, i2, readUnsignedShort2);
                    i2 += readUnsignedShort2;
                    lVar.eM(readUnsignedShort2);
                }
            }
            b bVar = new b(i5 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
            AppMethodBeat.o(95995);
            return bVar;
        } catch (ArrayIndexOutOfBoundsException e) {
            o oVar = new o("Error parsing HEVC config", e);
            AppMethodBeat.o(95995);
            throw oVar;
        }
    }

    private b(List<byte[]> list, int i) {
        this.aOf = list;
        this.aTz = i;
    }
}
