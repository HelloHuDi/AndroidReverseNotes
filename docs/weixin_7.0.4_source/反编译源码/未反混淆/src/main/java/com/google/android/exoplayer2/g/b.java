package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.o;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b implements f {
    private int aBR;
    final Format[] bhv;
    protected final o bpd;
    protected final int[] bpe;
    private final long[] bpf;
    protected final int length;

    static final class a implements Comparator<Format> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Format) obj2).bitrate - ((Format) obj).bitrate;
        }
    }

    public b(o oVar, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.i.a.checkState(iArr.length > 0);
        this.bpd = (o) com.google.android.exoplayer2.i.a.checkNotNull(oVar);
        this.length = iArr.length;
        this.bhv = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.bhv[i2] = oVar.bhv[iArr[i2]];
        }
        Arrays.sort(this.bhv, new a());
        this.bpe = new int[this.length];
        while (i < this.length) {
            this.bpe[i] = oVar.j(this.bhv[i]);
            i++;
        }
        this.bpf = new long[this.length];
    }

    public final o tf() {
        return this.bpd;
    }

    public final int length() {
        return this.bpe.length;
    }

    public final Format eG(int i) {
        return this.bhv[i];
    }

    public final int eH(int i) {
        return this.bpe[i];
    }

    public final int j(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.bhv[i] == format) {
                return i;
            }
        }
        return -1;
    }

    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.bpe[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final Format tg() {
        return this.bhv[su()];
    }

    public final int th() {
        return this.bpe[su()];
    }

    public final boolean eI(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean j = j(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !j) {
            if (i2 == i || j(i2, elapsedRealtime)) {
                j = false;
            } else {
                j = true;
            }
            i2++;
        }
        if (!j) {
            return false;
        }
        long[] jArr = this.bpf;
        jArr[i] = Math.max(jArr[i], elapsedRealtime + 60000);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean j(int i, long j) {
        return this.bpf[i] > j;
    }

    public int hashCode() {
        if (this.aBR == 0) {
            this.aBR = (System.identityHashCode(this.bpd) * 31) + Arrays.hashCode(this.bpe);
        }
        return this.aBR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.bpd == bVar.bpd && Arrays.equals(this.bpe, bVar.bpe)) {
            return true;
        }
        return false;
    }
}
