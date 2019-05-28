package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.j.b;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final List<byte[]> aOf;
    public final int aTz;
    public final float brq;
    public final int height;
    public final int width;

    public static a K(l lVar) {
        int i = 0;
        AppMethodBeat.i(95979);
        try {
            lVar.eM(4);
            int readUnsignedByte = (lVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95979);
                throw illegalStateException;
            }
            int i2;
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = lVar.readUnsignedByte() & 31;
            for (i2 = 0; i2 < readUnsignedByte2; i2++) {
                arrayList.add(L(lVar));
            }
            i2 = lVar.readUnsignedByte();
            while (i < i2) {
                arrayList.add(L(lVar));
                i++;
            }
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                b k = j.k((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i = k.width;
                i2 = k.height;
                f = k.brq;
            } else {
                i = -1;
                i2 = -1;
            }
            a aVar = new a(arrayList, readUnsignedByte, i, i2, f);
            AppMethodBeat.o(95979);
            return aVar;
        } catch (ArrayIndexOutOfBoundsException e) {
            o oVar = new o("Error parsing AVC config", e);
            AppMethodBeat.o(95979);
            throw oVar;
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.aOf = list;
        this.aTz = i;
        this.width = i2;
        this.height = i3;
        this.brq = f;
    }

    private static byte[] L(l lVar) {
        AppMethodBeat.i(95980);
        int readUnsignedShort = lVar.readUnsignedShort();
        int i = lVar.position;
        lVar.eM(readUnsignedShort);
        byte[] j = c.j(lVar.data, i, readUnsignedShort);
        AppMethodBeat.o(95980);
        return j;
    }
}
