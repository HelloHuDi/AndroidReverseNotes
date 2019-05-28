package com.tencent.p177mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.talkroom.component.C39948a.C22379a;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.QbSdk;

/* renamed from: com.tencent.mm.plugin.talkroom.component.g */
class C24838g extends C22379a {
    private final C7306ak handler = new C7306ak(Looper.getMainLooper());
    private final v2engine sxg = new v2engine();

    /* renamed from: com.tencent.mm.plugin.talkroom.component.g$8 */
    class C223898 extends C5039bj<C22380d> {
        C223898() {
            super(3000, null, (byte) 0);
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(25725);
            C22384f c22384f = new C22384f(C24838g.this.sxg);
            AppMethodBeat.m2505o(25725);
            return c22384f;
        }
    }

    static {
        AppMethodBeat.m2504i(25735);
        C1449k.m3079a("voipMain", C24838g.class.getClassLoader());
        AppMethodBeat.m2505o(25735);
    }

    public C24838g() {
        AppMethodBeat.m2504i(25726);
        AppMethodBeat.m2505o(25726);
    }

    public final int uninitLive() {
        AppMethodBeat.m2504i(25727);
        int intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25718);
                Integer valueOf = Integer.valueOf(C24838g.this.sxg.uninitLive());
                AppMethodBeat.m2505o(25718);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(25727);
        return intValue;
    }

    public final int SetCurrentMicId(final int i) {
        AppMethodBeat.m2504i(25728);
        int intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25719);
                Integer valueOf = Integer.valueOf(C24838g.this.sxg.SetCurrentMicId(i));
                AppMethodBeat.m2505o(25719);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(25728);
        return intValue;
    }

    public final int Close() {
        AppMethodBeat.m2504i(25729);
        int intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25720);
                Integer valueOf = Integer.valueOf(C24838g.this.sxg.Close());
                AppMethodBeat.m2505o(25720);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(25729);
        return intValue;
    }

    public final int cEb() {
        AppMethodBeat.m2504i(25730);
        int intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25721);
                C4990ab.m7417i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", Integer.valueOf(C45290m.m83509Lw()));
                C4990ab.m7417i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", Integer.valueOf(C24838g.this.sxg.initLive(r0, C6457e.eSi + "lib/")));
                Integer valueOf = Integer.valueOf(r0);
                AppMethodBeat.m2505o(25721);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(25730);
        return intValue;
    }

    /* renamed from: a */
    public final int mo26145a(C46295b c46295b, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        int i5;
        AppMethodBeat.m2504i(25731);
        final short[] sArr = new short[iArr2.length];
        for (i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        final C46295b c46295b2 = c46295b;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final long j2 = j;
        final int[] iArr3 = iArr;
        final int i9 = i4;
        i5 = ((Integer) new C5039bj<Integer>(Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25722);
                Integer valueOf = Integer.valueOf(C24838g.this.sxg.Open(c46295b2, i6, i7, i8, j2, iArr3, sArr, i9));
                AppMethodBeat.m2505o(25722);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(25731);
        return i5;
    }

    /* renamed from: e */
    public final byte[] mo26150e(final int[] iArr, final String str) {
        AppMethodBeat.m2504i(25732);
        byte[] bArr = (byte[]) new C5039bj<byte[]>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25723);
                PByteArray pByteArray = new PByteArray();
                iArr[0] = C24838g.this.sxg.GetStatis(pByteArray, str);
                byte[] bArr = pByteArray.value;
                AppMethodBeat.m2505o(25723);
                return bArr;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(25732);
        return bArr;
    }

    /* renamed from: a */
    public final C22381e mo26146a(final C43680c c43680c) {
        AppMethodBeat.m2504i(25733);
        C22381e c22381e = (C22381e) new C5039bj<C22381e>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(25724);
                C43681h c43681h = new C43681h(C24838g.this.sxg, c43680c);
                AppMethodBeat.m2505o(25724);
                return c43681h;
            }
        }.mo10372b(this.handler);
        AppMethodBeat.m2505o(25733);
        return c22381e;
    }

    public final C22380d cEc() {
        AppMethodBeat.m2504i(25734);
        C22380d c22380d = (C22380d) new C223898().mo10372b(this.handler);
        AppMethodBeat.m2505o(25734);
        return c22380d;
    }
}
