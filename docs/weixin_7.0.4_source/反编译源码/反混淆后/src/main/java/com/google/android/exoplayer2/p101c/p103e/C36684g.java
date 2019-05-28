package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.p103e.C32031h.C32032a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.e.g */
final class C36684g extends C32031h {
    private static final int bat = C17675v.m27562aT("Opus");
    private static final byte[] bau = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    private boolean bav;

    C36684g() {
    }

    static {
        AppMethodBeat.m2504i(95049);
        AppMethodBeat.m2505o(95049);
    }

    /* renamed from: r */
    public static boolean m60844r(C32065l c32065l) {
        AppMethodBeat.m2504i(95044);
        if (c32065l.mo52382tB() < bau.length) {
            AppMethodBeat.m2505o(95044);
            return false;
        }
        byte[] bArr = new byte[bau.length];
        c32065l.readBytes(bArr, 0, bau.length);
        boolean equals = Arrays.equals(bArr, bau);
        AppMethodBeat.m2505o(95044);
        return equals;
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.m2504i(95045);
        super.reset(z);
        if (z) {
            this.bav = false;
        }
        AppMethodBeat.m2505o(95045);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: s */
    public final long mo32323s(C32065l c32065l) {
        int i;
        AppMethodBeat.m2504i(95046);
        byte[] bArr = c32065l.data;
        int i2 = bArr[0] & 255;
        switch (i2 & 3) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i3 = i2 >> 3;
        i2 = i3 & 3;
        if (i3 >= 16) {
            i3 = 2500 << i2;
        } else if (i3 >= 12) {
            i3 = Downloads.MIN_WAIT_FOR_NETWORK << (i2 & 1);
        } else if (i2 == 3) {
            i3 = 60000;
        } else {
            i3 = Downloads.MIN_WAIT_FOR_NETWORK << i2;
        }
        long U = mo52327U((long) (i3 * i));
        AppMethodBeat.m2505o(95046);
        return U;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32321a(C32065l c32065l, long j, C32032a c32032a) {
        AppMethodBeat.m2504i(95047);
        if (this.bav) {
            boolean z;
            if (c32065l.readInt() == bat) {
                z = true;
            } else {
                z = false;
            }
            c32065l.setPosition(0);
            AppMethodBeat.m2505o(95047);
            return z;
        }
        byte[] copyOf = Arrays.copyOf(c32065l.data, c32065l.limit);
        int i = copyOf[9] & 255;
        int i2 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        C36684g.m60843c(arrayList, i2);
        C36684g.m60843c(arrayList, 3840);
        c32032a.aOv = Format.m15271a(null, "audio/opus", -1, -1, i, TXRecordCommon.AUDIO_SAMPLERATE_48000, arrayList, null, null);
        this.bav = true;
        AppMethodBeat.m2505o(95047);
        return true;
    }

    /* renamed from: c */
    private static void m60843c(List<byte[]> list, int i) {
        AppMethodBeat.m2504i(95048);
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
        AppMethodBeat.m2505o(95048);
    }
}
