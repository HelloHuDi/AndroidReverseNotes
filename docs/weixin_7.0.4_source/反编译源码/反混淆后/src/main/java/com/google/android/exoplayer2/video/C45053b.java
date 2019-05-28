package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.video.b */
public final class C45053b {
    public final List<byte[]> aOf;
    public final int aTz;

    /* renamed from: M */
    public static C45053b m82638M(C32065l c32065l) {
        AppMethodBeat.m2504i(95995);
        try {
            int readUnsignedShort;
            int i;
            int i2;
            c32065l.mo52369eM(21);
            int readUnsignedByte = c32065l.readUnsignedByte() & 3;
            int readUnsignedByte2 = c32065l.readUnsignedByte();
            int i3 = c32065l.position;
            int i4 = 0;
            int i5 = 0;
            while (i4 < readUnsignedByte2) {
                c32065l.mo52369eM(1);
                readUnsignedShort = c32065l.readUnsignedShort();
                i = i5;
                for (i2 = 0; i2 < readUnsignedShort; i2++) {
                    i5 = c32065l.readUnsignedShort();
                    i += i5 + 4;
                    c32065l.mo52369eM(i5);
                }
                i4++;
                i5 = i;
            }
            c32065l.setPosition(i3);
            byte[] bArr = new byte[i5];
            i2 = 0;
            for (i4 = 0; i4 < readUnsignedByte2; i4++) {
                c32065l.mo52369eM(1);
                readUnsignedShort = c32065l.readUnsignedShort();
                for (i = 0; i < readUnsignedShort; i++) {
                    int readUnsignedShort2 = c32065l.readUnsignedShort();
                    System.arraycopy(C45041j.bqY, 0, bArr, i2, C45041j.bqY.length);
                    i2 += C45041j.bqY.length;
                    System.arraycopy(c32065l.data, c32065l.position, bArr, i2, readUnsignedShort2);
                    i2 += readUnsignedShort2;
                    c32065l.mo52369eM(readUnsignedShort2);
                }
            }
            C45053b c45053b = new C45053b(i5 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
            AppMethodBeat.m2505o(95995);
            return c45053b;
        } catch (ArrayIndexOutOfBoundsException e) {
            C37269o c37269o = new C37269o("Error parsing HEVC config", e);
            AppMethodBeat.m2505o(95995);
            throw c37269o;
        }
    }

    private C45053b(List<byte[]> list, int i) {
        this.aOf = list;
        this.aTz = i;
    }
}
