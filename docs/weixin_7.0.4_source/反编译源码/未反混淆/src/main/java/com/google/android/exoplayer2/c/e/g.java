package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g extends h {
    private static final int bat = v.aT("Opus");
    private static final byte[] bau = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    private boolean bav;

    g() {
    }

    static {
        AppMethodBeat.i(95049);
        AppMethodBeat.o(95049);
    }

    public static boolean r(l lVar) {
        AppMethodBeat.i(95044);
        if (lVar.tB() < bau.length) {
            AppMethodBeat.o(95044);
            return false;
        }
        byte[] bArr = new byte[bau.length];
        lVar.readBytes(bArr, 0, bau.length);
        boolean equals = Arrays.equals(bArr, bau);
        AppMethodBeat.o(95044);
        return equals;
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.i(95045);
        super.reset(z);
        if (z) {
            this.bav = false;
        }
        AppMethodBeat.o(95045);
    }

    /* Access modifiers changed, original: protected|final */
    public final long s(l lVar) {
        int i;
        AppMethodBeat.i(95046);
        byte[] bArr = lVar.data;
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
        long U = U((long) (i3 * i));
        AppMethodBeat.o(95046);
        return U;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(l lVar, long j, a aVar) {
        AppMethodBeat.i(95047);
        if (this.bav) {
            boolean z;
            if (lVar.readInt() == bat) {
                z = true;
            } else {
                z = false;
            }
            lVar.setPosition(0);
            AppMethodBeat.o(95047);
            return z;
        }
        byte[] copyOf = Arrays.copyOf(lVar.data, lVar.limit);
        int i = copyOf[9] & 255;
        int i2 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        c(arrayList, i2);
        c(arrayList, 3840);
        aVar.aOv = Format.a(null, "audio/opus", -1, -1, i, TXRecordCommon.AUDIO_SAMPLERATE_48000, arrayList, null, null);
        this.bav = true;
        AppMethodBeat.o(95047);
        return true;
    }

    private static void c(List<byte[]> list, int i) {
        AppMethodBeat.i(95048);
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
        AppMethodBeat.o(95048);
    }
}
