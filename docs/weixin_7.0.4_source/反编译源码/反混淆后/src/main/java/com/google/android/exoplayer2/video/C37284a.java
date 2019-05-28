package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p111i.C32062c;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.p111i.C45041j.C41617b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.video.a */
public final class C37284a {
    public final List<byte[]> aOf;
    public final int aTz;
    public final float brq;
    public final int height;
    public final int width;

    /* renamed from: K */
    public static C37284a m62588K(C32065l c32065l) {
        int i = 0;
        AppMethodBeat.m2504i(95979);
        try {
            c32065l.mo52369eM(4);
            int readUnsignedByte = (c32065l.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95979);
                throw illegalStateException;
            }
            int i2;
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = c32065l.readUnsignedByte() & 31;
            for (i2 = 0; i2 < readUnsignedByte2; i2++) {
                arrayList.add(C37284a.m62589L(c32065l));
            }
            i2 = c32065l.readUnsignedByte();
            while (i < i2) {
                arrayList.add(C37284a.m62589L(c32065l));
                i++;
            }
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                C41617b k = C45041j.m82580k((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i = k.width;
                i2 = k.height;
                f = k.brq;
            } else {
                i = -1;
                i2 = -1;
            }
            C37284a c37284a = new C37284a(arrayList, readUnsignedByte, i, i2, f);
            AppMethodBeat.m2505o(95979);
            return c37284a;
        } catch (ArrayIndexOutOfBoundsException e) {
            C37269o c37269o = new C37269o("Error parsing AVC config", e);
            AppMethodBeat.m2505o(95979);
            throw c37269o;
        }
    }

    private C37284a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.aOf = list;
        this.aTz = i;
        this.width = i2;
        this.height = i3;
        this.brq = f;
    }

    /* renamed from: L */
    private static byte[] m62589L(C32065l c32065l) {
        AppMethodBeat.m2504i(95980);
        int readUnsignedShort = c32065l.readUnsignedShort();
        int i = c32065l.position;
        c32065l.mo52369eM(readUnsignedShort);
        byte[] j = C32062c.m52120j(c32065l.data, i, readUnsignedShort);
        AppMethodBeat.m2505o(95980);
        return j;
    }
}
