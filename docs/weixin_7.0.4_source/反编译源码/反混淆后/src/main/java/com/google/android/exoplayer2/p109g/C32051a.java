package com.google.android.exoplayer2.p109g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p109g.C45035f.C8678a;
import com.google.android.exoplayer2.p110h.C32056d;
import com.google.android.exoplayer2.source.C41630o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.google.android.exoplayer2.g.a */
public final class C32051a extends C8675b {
    private int biG = m52102al(Long.MIN_VALUE);
    private final C32056d boT;
    private final int boU;
    private final long boV;
    private final long boW;
    private final long boX;
    private final float boY;
    private int boZ = 1;

    /* renamed from: com.google.android.exoplayer2.g.a$a */
    public static final class C25537a implements C8678a {
        private final C32056d boT;
        private final int boU;
        private final float boY;
        private final int bpa;
        private final int bpb;
        private final int bpc;

        public C25537a(C32056d c32056d) {
            this(c32056d, (byte) 0);
        }

        private C25537a(C32056d c32056d, byte b) {
            this.boT = c32056d;
            this.boU = 800000;
            this.bpa = Downloads.MIN_WAIT_FOR_NETWORK;
            this.bpb = 25000;
            this.bpc = 25000;
            this.boY = 0.75f;
        }

        /* renamed from: a */
        public final /* synthetic */ C45035f mo19210a(C41630o c41630o, int[] iArr) {
            AppMethodBeat.m2504i(95757);
            C32051a c32051a = new C32051a(c41630o, iArr, this.boT, this.boU, (long) this.bpa, (long) this.bpb, (long) this.bpc, this.boY);
            AppMethodBeat.m2505o(95757);
            return c32051a;
        }
    }

    public C32051a(C41630o c41630o, int[] iArr, C32056d c32056d, int i, long j, long j2, long j3, float f) {
        super(c41630o, iArr);
        AppMethodBeat.m2504i(95758);
        this.boT = c32056d;
        this.boU = i;
        this.boV = 1000 * j;
        this.boW = 1000 * j2;
        this.boX = 1000 * j3;
        this.boY = f;
        AppMethodBeat.m2505o(95758);
    }

    /* renamed from: ag */
    public final void mo52334ag(long j) {
        AppMethodBeat.m2504i(95759);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.biG;
        this.biG = m52102al(elapsedRealtime);
        if (this.biG == i) {
            AppMethodBeat.m2505o(95759);
            return;
        }
        if (!mo19204j(i, elapsedRealtime)) {
            Format format = this.bhv[i];
            Format format2 = this.bhv[this.biG];
            if (format2.bitrate > format.bitrate && j < this.boV) {
                this.biG = i;
            } else if (format2.bitrate < format.bitrate && j >= this.boW) {
                this.biG = i;
            }
        }
        if (this.biG != i) {
            this.boZ = 3;
        }
        AppMethodBeat.m2505o(95759);
    }

    /* renamed from: su */
    public final int mo52335su() {
        return this.biG;
    }

    /* renamed from: sv */
    public final int mo52336sv() {
        return this.boZ;
    }

    /* renamed from: sw */
    public final Object mo52337sw() {
        return null;
    }

    /* renamed from: al */
    private int m52102al(long j) {
        int i = 0;
        AppMethodBeat.m2504i(95760);
        long tl = this.boT.mo52345tl();
        tl = tl == -1 ? (long) this.boU : (long) (((float) tl) * this.boY);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.length) {
                if (j != Long.MIN_VALUE && mo19204j(i2, j)) {
                    i = i3;
                } else if (((long) this.bhv[i2].bitrate) <= tl) {
                    AppMethodBeat.m2505o(95760);
                    return i2;
                } else {
                    i = i2;
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(95760);
                return i3;
            }
        }
    }
}
