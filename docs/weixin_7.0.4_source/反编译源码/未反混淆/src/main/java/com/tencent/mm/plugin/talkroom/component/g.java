package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.smtt.sdk.QbSdk;

class g extends a {
    private final ak handler = new ak(Looper.getMainLooper());
    private final v2engine sxg = new v2engine();

    static {
        AppMethodBeat.i(25735);
        k.a("voipMain", g.class.getClassLoader());
        AppMethodBeat.o(25735);
    }

    public g() {
        AppMethodBeat.i(25726);
        AppMethodBeat.o(25726);
    }

    public final int uninitLive() {
        AppMethodBeat.i(25727);
        int intValue = ((Integer) new bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25718);
                Integer valueOf = Integer.valueOf(g.this.sxg.uninitLive());
                AppMethodBeat.o(25718);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(25727);
        return intValue;
    }

    public final int SetCurrentMicId(final int i) {
        AppMethodBeat.i(25728);
        int intValue = ((Integer) new bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25719);
                Integer valueOf = Integer.valueOf(g.this.sxg.SetCurrentMicId(i));
                AppMethodBeat.o(25719);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(25728);
        return intValue;
    }

    public final int Close() {
        AppMethodBeat.i(25729);
        int intValue = ((Integer) new bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25720);
                Integer valueOf = Integer.valueOf(g.this.sxg.Close());
                AppMethodBeat.o(25720);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(25729);
        return intValue;
    }

    public final int cEb() {
        AppMethodBeat.i(25730);
        int intValue = ((Integer) new bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25721);
                ab.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", Integer.valueOf(m.Lw()));
                ab.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", Integer.valueOf(g.this.sxg.initLive(r0, e.eSi + "lib/")));
                Integer valueOf = Integer.valueOf(r0);
                AppMethodBeat.o(25721);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(25730);
        return intValue;
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        int i5;
        AppMethodBeat.i(25731);
        final short[] sArr = new short[iArr2.length];
        for (i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        final b bVar2 = bVar;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final long j2 = j;
        final int[] iArr3 = iArr;
        final int i9 = i4;
        i5 = ((Integer) new bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25722);
                Integer valueOf = Integer.valueOf(g.this.sxg.Open(bVar2, i6, i7, i8, j2, iArr3, sArr, i9));
                AppMethodBeat.o(25722);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(25731);
        return i5;
    }

    public final byte[] e(final int[] iArr, final String str) {
        AppMethodBeat.i(25732);
        byte[] bArr = (byte[]) new bj<byte[]>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25723);
                PByteArray pByteArray = new PByteArray();
                iArr[0] = g.this.sxg.GetStatis(pByteArray, str);
                byte[] bArr = pByteArray.value;
                AppMethodBeat.o(25723);
                return bArr;
            }
        }.b(this.handler);
        AppMethodBeat.o(25732);
        return bArr;
    }

    public final e a(final c cVar) {
        AppMethodBeat.i(25733);
        e eVar = (e) new bj<e>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25724);
                h hVar = new h(g.this.sxg, cVar);
                AppMethodBeat.o(25724);
                return hVar;
            }
        }.b(this.handler);
        AppMethodBeat.o(25733);
        return eVar;
    }

    public final d cEc() {
        AppMethodBeat.i(25734);
        d dVar = (d) new bj<d>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(25725);
                f fVar = new f(g.this.sxg);
                AppMethodBeat.o(25725);
                return fVar;
            }
        }.b(this.handler);
        AppMethodBeat.o(25734);
        return dVar;
    }
}
