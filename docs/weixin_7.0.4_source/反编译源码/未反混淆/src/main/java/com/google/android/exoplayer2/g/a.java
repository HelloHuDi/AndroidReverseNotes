package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class a extends b {
    private int biG = al(Long.MIN_VALUE);
    private final d boT;
    private final int boU;
    private final long boV;
    private final long boW;
    private final long boX;
    private final float boY;
    private int boZ = 1;

    public static final class a implements com.google.android.exoplayer2.g.f.a {
        private final d boT;
        private final int boU;
        private final float boY;
        private final int bpa;
        private final int bpb;
        private final int bpc;

        public a(d dVar) {
            this(dVar, (byte) 0);
        }

        private a(d dVar, byte b) {
            this.boT = dVar;
            this.boU = 800000;
            this.bpa = Downloads.MIN_WAIT_FOR_NETWORK;
            this.bpb = 25000;
            this.bpc = 25000;
            this.boY = 0.75f;
        }

        public final /* synthetic */ f a(o oVar, int[] iArr) {
            AppMethodBeat.i(95757);
            a aVar = new a(oVar, iArr, this.boT, this.boU, (long) this.bpa, (long) this.bpb, (long) this.bpc, this.boY);
            AppMethodBeat.o(95757);
            return aVar;
        }
    }

    public a(o oVar, int[] iArr, d dVar, int i, long j, long j2, long j3, float f) {
        super(oVar, iArr);
        AppMethodBeat.i(95758);
        this.boT = dVar;
        this.boU = i;
        this.boV = 1000 * j;
        this.boW = 1000 * j2;
        this.boX = 1000 * j3;
        this.boY = f;
        AppMethodBeat.o(95758);
    }

    public final void ag(long j) {
        AppMethodBeat.i(95759);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.biG;
        this.biG = al(elapsedRealtime);
        if (this.biG == i) {
            AppMethodBeat.o(95759);
            return;
        }
        if (!j(i, elapsedRealtime)) {
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
        AppMethodBeat.o(95759);
    }

    public final int su() {
        return this.biG;
    }

    public final int sv() {
        return this.boZ;
    }

    public final Object sw() {
        return null;
    }

    private int al(long j) {
        int i = 0;
        AppMethodBeat.i(95760);
        long tl = this.boT.tl();
        tl = tl == -1 ? (long) this.boU : (long) (((float) tl) * this.boY);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.length) {
                if (j != Long.MIN_VALUE && j(i2, j)) {
                    i = i3;
                } else if (((long) this.bhv[i2].bitrate) <= tl) {
                    AppMethodBeat.o(95760);
                    return i2;
                } else {
                    i = i2;
                }
                i2++;
            } else {
                AppMethodBeat.o(95760);
                return i3;
            }
        }
    }
}
