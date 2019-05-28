package com.google.android.exoplayer2.p109g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C41630o;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.g.b */
public abstract class C8675b implements C45035f {
    private int aBR;
    final Format[] bhv;
    protected final C41630o bpd;
    protected final int[] bpe;
    private final long[] bpf;
    protected final int length;

    /* renamed from: com.google.android.exoplayer2.g.b$a */
    static final class C8676a implements Comparator<Format> {
        private C8676a() {
        }

        /* synthetic */ C8676a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Format) obj2).bitrate - ((Format) obj).bitrate;
        }
    }

    public C8675b(C41630o c41630o, int... iArr) {
        int i = 0;
        C45039a.checkState(iArr.length > 0);
        this.bpd = (C41630o) C45039a.checkNotNull(c41630o);
        this.length = iArr.length;
        this.bhv = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.bhv[i2] = c41630o.bhv[iArr[i2]];
        }
        Arrays.sort(this.bhv, new C8676a());
        this.bpe = new int[this.length];
        while (i < this.length) {
            this.bpe[i] = c41630o.mo66765j(this.bhv[i]);
            i++;
        }
        this.bpf = new long[this.length];
    }

    /* renamed from: tf */
    public final C41630o mo19206tf() {
        return this.bpd;
    }

    public final int length() {
        return this.bpe.length;
    }

    /* renamed from: eG */
    public final Format mo19197eG(int i) {
        return this.bhv[i];
    }

    /* renamed from: eH */
    public final int mo19198eH(int i) {
        return this.bpe[i];
    }

    /* renamed from: j */
    public final int mo19203j(Format format) {
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

    /* renamed from: tg */
    public final Format mo19207tg() {
        return this.bhv[mo52335su()];
    }

    /* renamed from: th */
    public final int mo19208th() {
        return this.bpe[mo52335su()];
    }

    /* renamed from: eI */
    public final boolean mo19199eI(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean j = mo19204j(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !j) {
            if (i2 == i || mo19204j(i2, elapsedRealtime)) {
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
    /* renamed from: j */
    public final boolean mo19204j(int i, long j) {
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
        C8675b c8675b = (C8675b) obj;
        if (this.bpd == c8675b.bpd && Arrays.equals(this.bpe, c8675b.bpe)) {
            return true;
        }
        return false;
    }
}
