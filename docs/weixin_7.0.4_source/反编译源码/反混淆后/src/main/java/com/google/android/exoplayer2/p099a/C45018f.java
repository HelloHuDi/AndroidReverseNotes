package com.google.android.exoplayer2.p099a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.C45045p;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/* renamed from: com.google.android.exoplayer2.a.f */
public final class C45018f {
    public static boolean aPT = false;
    public static boolean aPU = false;
    C45045p aNg;
    int aOX;
    C0824b aOY;
    private final C8639c aPV;
    final C37228g aPW;
    private final C25512l aPX;
    final C8640d[] aPY;
    final C32020f aPZ;
    private long aQA;
    private long aQB;
    int aQC;
    int aQD;
    long aQE;
    private long aQF;
    private long aQG;
    float aQH;
    private C8640d[] aQI;
    private ByteBuffer[] aQJ;
    ByteBuffer aQK;
    private ByteBuffer aQL;
    private byte[] aQM;
    private int aQN;
    private int aQO;
    boolean aQP;
    boolean aQQ;
    boolean aQR;
    boolean aQS;
    long aQT;
    final ConditionVariable aQa = new ConditionVariable(true);
    private final long[] aQb;
    final C0834a aQc;
    final LinkedList<C37226g> aQd;
    AudioTrack aQe;
    AudioTrack aQf;
    int aQg;
    int aQh;
    boolean aQi;
    long aQj;
    C45045p aQk;
    private long aQl;
    private long aQm;
    private ByteBuffer aQn;
    int aQo;
    private int aQp;
    private int aQq;
    private long aQr;
    private long aQs;
    private boolean aQt;
    private long aQu;
    private Method aQv;
    int aQw;
    long aQx;
    long aQy;
    int aQz;
    int bufferSize;
    int encoding;
    int sampleRate;

    /* renamed from: com.google.android.exoplayer2.a.f$a */
    static class C0834a {
        private boolean aQW;
        private long aQX;
        private long aQY;
        private long aQZ;
        protected AudioTrack aQf;
        private long aRa;
        private long aRb;
        private long aRc;
        private int sampleRate;

        private C0834a() {
        }

        /* synthetic */ C0834a(byte b) {
            this();
        }

        /* renamed from: a */
        public void mo2536a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.m2504i(94662);
            this.aQf = audioTrack;
            this.aQW = z;
            this.aRa = -9223372036854775807L;
            this.aQX = 0;
            this.aQY = 0;
            this.aQZ = 0;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
            AppMethodBeat.m2505o(94662);
        }

        /* renamed from: L */
        public final void mo2535L(long j) {
            AppMethodBeat.m2504i(94663);
            this.aRb = mo2540qx();
            this.aRa = SystemClock.elapsedRealtime() * 1000;
            this.aRc = j;
            this.aQf.stop();
            AppMethodBeat.m2505o(94663);
        }

        public final void pause() {
            AppMethodBeat.m2504i(94664);
            if (this.aRa != -9223372036854775807L) {
                AppMethodBeat.m2505o(94664);
                return;
            }
            this.aQf.pause();
            AppMethodBeat.m2505o(94664);
        }

        /* renamed from: qx */
        public final long mo2540qx() {
            AppMethodBeat.m2504i(94665);
            long min;
            if (this.aRa != -9223372036854775807L) {
                min = Math.min(this.aRc, ((((SystemClock.elapsedRealtime() * 1000) - this.aRa) * ((long) this.sampleRate)) / 1000000) + this.aRb);
                AppMethodBeat.m2505o(94665);
                return min;
            }
            int playState = this.aQf.getPlayState();
            if (playState == 1) {
                AppMethodBeat.m2505o(94665);
                return 0;
            }
            min = 4294967295L & ((long) this.aQf.getPlaybackHeadPosition());
            if (this.aQW) {
                if (playState == 2 && min == 0) {
                    this.aQZ = this.aQX;
                }
                min += this.aQZ;
            }
            if (this.aQX > min) {
                this.aQY++;
            }
            this.aQX = min;
            min += this.aQY << 32;
            AppMethodBeat.m2505o(94665);
            return min;
        }

        /* renamed from: qy */
        public final long mo2541qy() {
            AppMethodBeat.m2504i(94666);
            long qx = (mo2540qx() * 1000000) / ((long) this.sampleRate);
            AppMethodBeat.m2505o(94666);
            return qx;
        }

        /* renamed from: qz */
        public boolean mo2542qz() {
            return false;
        }

        /* renamed from: qA */
        public long mo2538qA() {
            AppMethodBeat.m2504i(94667);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(94667);
            throw unsupportedOperationException;
        }

        /* renamed from: qB */
        public long mo2539qB() {
            AppMethodBeat.m2504i(94668);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(94668);
            throw unsupportedOperationException;
        }
    }

    @TargetApi(19)
    /* renamed from: com.google.android.exoplayer2.a.f$b */
    static class C6263b extends C0834a {
        private final AudioTimestamp aRd = new AudioTimestamp();
        private long aRe;
        private long aRf;
        private long aRg;

        public C6263b() {
            super();
            AppMethodBeat.m2504i(94669);
            AppMethodBeat.m2505o(94669);
        }

        /* renamed from: a */
        public final void mo2536a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.m2504i(94670);
            super.mo2536a(audioTrack, z);
            this.aRe = 0;
            this.aRf = 0;
            this.aRg = 0;
            AppMethodBeat.m2505o(94670);
        }

        /* renamed from: qz */
        public final boolean mo2542qz() {
            AppMethodBeat.m2504i(94671);
            boolean timestamp = this.aQf.getTimestamp(this.aRd);
            if (timestamp) {
                long j = this.aRd.framePosition;
                if (this.aRf > j) {
                    this.aRe++;
                }
                this.aRf = j;
                this.aRg = j + (this.aRe << 32);
            }
            AppMethodBeat.m2505o(94671);
            return timestamp;
        }

        /* renamed from: qA */
        public final long mo2538qA() {
            return this.aRd.nanoTime;
        }

        /* renamed from: qB */
        public final long mo2539qB() {
            return this.aRg;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.f$c */
    public static final class C17627c extends Exception {
        public C17627c(Throwable th) {
            super(th);
        }

        public C17627c(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.f$e */
    public static final class C32019e extends RuntimeException {
        public C32019e(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.f$f */
    public interface C32020f {
        /* renamed from: dx */
        void mo52312dx(int i);

        /* renamed from: e */
        void mo52313e(int i, long j, long j2);

        /* renamed from: qe */
        void mo52314qe();
    }

    /* renamed from: com.google.android.exoplayer2.a.f$g */
    static final class C37226g {
        final long aNT;
        final C45045p aNg;
        final long aRi;

        /* synthetic */ C37226g(C45045p c45045p, long j, long j2, byte b) {
            this(c45045p, j, j2);
        }

        private C37226g(C45045p c45045p, long j, long j2) {
            this.aNg = c45045p;
            this.aRi = j;
            this.aNT = j2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.f$h */
    public static final class C37227h extends Exception {
        public final int errorCode;

        public C37227h(int i) {
            super("AudioTrack write failed: ".concat(String.valueOf(i)));
            AppMethodBeat.m2504i(94673);
            this.errorCode = i;
            AppMethodBeat.m2505o(94673);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a.f$d */
    public static final class C45017d extends Exception {
        public final int aRh;

        public C45017d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            AppMethodBeat.m2504i(94672);
            this.aRh = i;
            AppMethodBeat.m2505o(94672);
        }
    }

    public C45018f(C8639c c8639c, C8640d[] c8640dArr, C32020f c32020f) {
        AppMethodBeat.m2504i(94674);
        this.aPV = c8639c;
        this.aPZ = c32020f;
        if (C17675v.SDK_INT >= 18) {
            try {
                this.aQv = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (C17675v.SDK_INT >= 19) {
            this.aQc = new C6263b();
        } else {
            this.aQc = new C0834a();
        }
        this.aPW = new C37228g();
        this.aPX = new C25512l();
        this.aPY = new C8640d[(c8640dArr.length + 3)];
        this.aPY[0] = new C25511j();
        this.aPY[1] = this.aPW;
        System.arraycopy(c8640dArr, 0, this.aPY, 2, c8640dArr.length);
        this.aPY[c8640dArr.length + 2] = this.aPX;
        this.aQb = new long[10];
        this.aQH = 1.0f;
        this.aQD = 0;
        this.aOY = C0824b.aPz;
        this.aOX = 0;
        this.aNg = C45045p.aOC;
        this.aQO = -1;
        this.aQI = new C8640d[0];
        this.aQJ = new ByteBuffer[0];
        this.aQd = new LinkedList();
        AppMethodBeat.m2505o(94674);
    }

    /* renamed from: at */
    public final boolean mo72528at(String str) {
        AppMethodBeat.m2504i(94675);
        if (this.aPV != null) {
            boolean z;
            C8639c c8639c = this.aPV;
            if (Arrays.binarySearch(c8639c.aPE, C45018f.m82456au(str)) >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.m2505o(94675);
                return true;
            }
        }
        AppMethodBeat.m2505o(94675);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qn */
    public final void mo72532qn() {
        int i;
        AppMethodBeat.m2504i(94677);
        ArrayList arrayList = new ArrayList();
        for (C8640d c8640d : this.aPY) {
            if (c8640d.isActive()) {
                arrayList.add(c8640d);
            } else {
                c8640d.flush();
            }
        }
        int size = arrayList.size();
        this.aQI = (C8640d[]) arrayList.toArray(new C8640d[size]);
        this.aQJ = new ByteBuffer[size];
        for (i = 0; i < size; i++) {
            C8640d c8640d2 = this.aQI[i];
            c8640d2.flush();
            this.aQJ[i] = c8640d2.mo19135qm();
        }
        AppMethodBeat.m2505o(94677);
    }

    public final void play() {
        AppMethodBeat.m2504i(94678);
        this.aQQ = true;
        if (isInitialized()) {
            this.aQF = System.nanoTime() / 1000;
            this.aQf.play();
        }
        AppMethodBeat.m2505o(94678);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: H */
    public final void mo72523H(long j) {
        AppMethodBeat.m2504i(94679);
        int length = this.aQI.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.aQJ[i - 1] : this.aQK != null ? this.aQK : C8640d.aPG;
            if (i == length) {
                mo72526a(byteBuffer, j);
            } else {
                C8640d c8640d = this.aQI[i];
                c8640d.mo19130g(byteBuffer);
                ByteBuffer qm = c8640d.mo19135qm();
                this.aQJ[i] = qm;
                if (qm.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                AppMethodBeat.m2505o(94679);
                return;
            }
            i--;
        }
        AppMethodBeat.m2505o(94679);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo72526a(ByteBuffer byteBuffer, long j) {
        AppMethodBeat.m2504i(94680);
        if (byteBuffer.hasRemaining()) {
            boolean z;
            int remaining;
            if (this.aQL != null) {
                if (this.aQL == byteBuffer) {
                    z = true;
                } else {
                    z = false;
                }
                C45039a.checkArgument(z);
            } else {
                this.aQL = byteBuffer;
                if (C17675v.SDK_INT < 21) {
                    remaining = byteBuffer.remaining();
                    if (this.aQM == null || this.aQM.length < remaining) {
                        this.aQM = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.aQM, 0, remaining);
                    byteBuffer.position(position);
                    this.aQN = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (C17675v.SDK_INT < 21) {
                remaining = this.bufferSize - ((int) (this.aQA - (this.aQc.mo2540qx() * ((long) this.aQz))));
                if (remaining > 0) {
                    remaining = this.aQf.write(this.aQM, this.aQN, Math.min(remaining2, remaining));
                    if (remaining > 0) {
                        this.aQN += remaining;
                        byteBuffer.position(byteBuffer.position() + remaining);
                    }
                } else {
                    remaining = 0;
                }
            } else if (this.aQR) {
                if (j != -9223372036854775807L) {
                    z = true;
                } else {
                    z = false;
                }
                C45039a.checkState(z);
                remaining = m82454a(this.aQf, byteBuffer, remaining2, j);
            } else {
                remaining = this.aQf.write(byteBuffer, remaining2, 1);
            }
            this.aQT = SystemClock.elapsedRealtime();
            if (remaining < 0) {
                C37227h c37227h = new C37227h(remaining);
                AppMethodBeat.m2505o(94680);
                throw c37227h;
            }
            if (!this.aQi) {
                this.aQA += (long) remaining;
            }
            if (remaining == remaining2) {
                if (this.aQi) {
                    this.aQB += (long) this.aQC;
                }
                this.aQL = null;
                AppMethodBeat.m2505o(94680);
                return true;
            }
            AppMethodBeat.m2505o(94680);
            return false;
        }
        AppMethodBeat.m2505o(94680);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qo */
    public final boolean mo72533qo() {
        boolean z;
        AppMethodBeat.m2504i(94681);
        if (this.aQO == -1) {
            this.aQO = this.aQi ? this.aQI.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.aQO < this.aQI.length) {
            C8640d c8640d = this.aQI[this.aQO];
            if (z) {
                c8640d.mo19134ql();
            }
            mo72523H(-9223372036854775807L);
            if (c8640d.mo19132qf()) {
                this.aQO++;
                z = true;
            } else {
                AppMethodBeat.m2505o(94681);
                return false;
            }
        }
        if (this.aQL != null) {
            mo72526a(this.aQL, -9223372036854775807L);
            if (this.aQL != null) {
                AppMethodBeat.m2505o(94681);
                return false;
            }
        }
        this.aQO = -1;
        AppMethodBeat.m2505o(94681);
        return true;
    }

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (r2 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: qp */
    public final boolean mo72534qp() {
        AppMethodBeat.m2504i(94682);
        if (isInitialized()) {
            if (mo72538qt() <= this.aQc.mo2540qx()) {
                boolean z;
                if (mo72540qv() && this.aQf.getPlayState() == 2 && this.aQf.getPlaybackHeadPosition() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            AppMethodBeat.m2505o(94682);
            return true;
        }
        AppMethodBeat.m2505o(94682);
        return false;
    }

    /* renamed from: b */
    public final C45045p mo72529b(C45045p c45045p) {
        AppMethodBeat.m2504i(94683);
        C45045p c45045p2;
        if (this.aQi) {
            this.aNg = C45045p.aOC;
            c45045p2 = this.aNg;
            AppMethodBeat.m2505o(94683);
            return c45045p2;
        }
        Object obj;
        C25512l c25512l = this.aPX;
        c25512l.speed = C17675v.m27572h(c45045p.speed, 0.1f, 8.0f);
        float f = c25512l.speed;
        C25512l c25512l2 = this.aPX;
        float f2 = c45045p.pitch;
        c25512l2.pitch = C17675v.m27572h(f2, 0.1f, 8.0f);
        C45045p c45045p3 = new C45045p(f, f2);
        if (this.aQk != null) {
            obj = this.aQk;
        } else if (this.aQd.isEmpty()) {
            obj = this.aNg;
        } else {
            obj = ((C37226g) this.aQd.getLast()).aNg;
        }
        if (!c45045p3.equals(obj)) {
            if (isInitialized()) {
                this.aQk = c45045p3;
            } else {
                this.aNg = c45045p3;
            }
        }
        c45045p2 = this.aNg;
        AppMethodBeat.m2505o(94683);
        return c45045p2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qq */
    public final void mo72535qq() {
        AppMethodBeat.m2504i(94684);
        if (isInitialized()) {
            if (C17675v.SDK_INT >= 21) {
                this.aQf.setVolume(this.aQH);
                AppMethodBeat.m2505o(94684);
                return;
            }
            AudioTrack audioTrack = this.aQf;
            float f = this.aQH;
            audioTrack.setStereoVolume(f, f);
        }
        AppMethodBeat.m2505o(94684);
    }

    public final void reset() {
        AppMethodBeat.m2504i(94685);
        if (isInitialized()) {
            this.aQx = 0;
            this.aQy = 0;
            this.aQA = 0;
            this.aQB = 0;
            this.aQC = 0;
            if (this.aQk != null) {
                this.aNg = this.aQk;
                this.aQk = null;
            } else if (!this.aQd.isEmpty()) {
                this.aNg = ((C37226g) this.aQd.getLast()).aNg;
            }
            this.aQd.clear();
            this.aQl = 0;
            this.aQm = 0;
            this.aQK = null;
            this.aQL = null;
            for (int i = 0; i < this.aQI.length; i++) {
                C8640d c8640d = this.aQI[i];
                c8640d.flush();
                this.aQJ[i] = c8640d.mo19135qm();
            }
            this.aQP = false;
            this.aQO = -1;
            this.aQn = null;
            this.aQo = 0;
            this.aQD = 0;
            this.aQG = 0;
            mo72539qu();
            if (this.aQf.getPlayState() == 3) {
                this.aQf.pause();
            }
            final AudioTrack audioTrack = this.aQf;
            this.aQf = null;
            this.aQc.mo2536a(null, false);
            this.aQa.close();
            new Thread() {
                public final void run() {
                    AppMethodBeat.m2504i(94660);
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        C45018f.this.aQa.open();
                        AppMethodBeat.m2505o(94660);
                    }
                }
            }.start();
        }
        AppMethodBeat.m2505o(94685);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qr */
    public final void mo72536qr() {
        AppMethodBeat.m2504i(94686);
        if (this.aQe == null) {
            AppMethodBeat.m2505o(94686);
            return;
        }
        final AudioTrack audioTrack = this.aQe;
        this.aQe = null;
        new Thread() {
            public final void run() {
                AppMethodBeat.m2504i(94661);
                audioTrack.release();
                AppMethodBeat.m2505o(94661);
            }
        }.start();
        AppMethodBeat.m2505o(94686);
    }

    /* renamed from: I */
    private long m82453I(long j) {
        AppMethodBeat.m2504i(94687);
        while (!this.aQd.isEmpty() && j >= ((C37226g) this.aQd.getFirst()).aNT) {
            C37226g c37226g = (C37226g) this.aQd.remove();
            this.aNg = c37226g.aNg;
            this.aQm = c37226g.aNT;
            this.aQl = c37226g.aRi - this.aQE;
        }
        long j2;
        if (this.aNg.speed == 1.0f) {
            j2 = (this.aQl + j) - this.aQm;
            AppMethodBeat.m2505o(94687);
            return j2;
        } else if (!this.aQd.isEmpty() || this.aPX.aRW < 1024) {
            j2 = this.aQl + ((long) (((double) this.aNg.speed) * ((double) (j - this.aQm))));
            AppMethodBeat.m2505o(94687);
            return j2;
        } else {
            j2 = C17675v.m27564b(j - this.aQm, this.aPX.aRV, this.aPX.aRW) + this.aQl;
            AppMethodBeat.m2505o(94687);
            return j2;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean isInitialized() {
        return this.aQf != null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: J */
    public final long mo72524J(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: K */
    public final long mo72525K(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qs */
    public final long mo72537qs() {
        return this.aQi ? this.aQy : this.aQx / ((long) this.aQw);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qt */
    public final long mo72538qt() {
        return this.aQi ? this.aQB : this.aQA / ((long) this.aQz);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qu */
    public final void mo72539qu() {
        this.aQr = 0;
        this.aQq = 0;
        this.aQp = 0;
        this.aQs = 0;
        this.aQt = false;
        this.aQu = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qv */
    public final boolean mo72540qv() {
        return C17675v.SDK_INT < 23 && (this.aQh == 5 || this.aQh == 6);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qw */
    public final AudioTrack mo72541qw() {
        AudioTrack audioTrack;
        AppMethodBeat.m2504i(94688);
        if (C17675v.SDK_INT >= 21) {
            AudioAttributes build;
            if (this.aQR) {
                build = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                C0824b c0824b = this.aOY;
                if (c0824b.aPC == null) {
                    c0824b.aPC = new Builder().setContentType(c0824b.aPA).setFlags(c0824b.flags).setUsage(c0824b.aPB).build();
                }
                build = c0824b.aPC;
            }
            audioTrack = new AudioTrack(build, new AudioFormat.Builder().setChannelMask(this.aQg).setEncoding(this.aQh).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.aOX != 0 ? this.aOX : 0);
        } else {
            int eS = C17675v.m27570eS(this.aOY.aPB);
            if (this.aOX == 0) {
                audioTrack = new AudioTrack(eS, this.sampleRate, this.aQg, this.aQh, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(eS, this.sampleRate, this.aQg, this.aQh, this.bufferSize, 1, this.aOX);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            C45017d c45017d = new C45017d(state, this.sampleRate, this.aQg, this.bufferSize);
            AppMethodBeat.m2505o(94688);
            throw c45017d;
        }
        AppMethodBeat.m2505o(94688);
        return audioTrack;
    }

    /* renamed from: au */
    static int m82456au(String str) {
        AppMethodBeat.m2504i(94689);
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(94689);
                return 5;
            case 1:
                AppMethodBeat.m2505o(94689);
                return 6;
            case 2:
                AppMethodBeat.m2505o(94689);
                return 7;
            case 3:
                AppMethodBeat.m2505o(94689);
                return 8;
            default:
                AppMethodBeat.m2505o(94689);
                return 0;
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    private int m82454a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        int write;
        AppMethodBeat.m2504i(94690);
        if (this.aQn == null) {
            this.aQn = ByteBuffer.allocate(16);
            this.aQn.order(ByteOrder.BIG_ENDIAN);
            this.aQn.putInt(1431633921);
        }
        if (this.aQo == 0) {
            this.aQn.putInt(4, i);
            this.aQn.putLong(8, 1000 * j);
            this.aQn.position(0);
            this.aQo = i;
        }
        int remaining = this.aQn.remaining();
        if (remaining > 0) {
            write = audioTrack.write(this.aQn, remaining, 1);
            if (write < 0) {
                this.aQo = 0;
                AppMethodBeat.m2505o(94690);
                return write;
            } else if (write < remaining) {
                AppMethodBeat.m2505o(94690);
                return 0;
            }
        }
        write = audioTrack.write(byteBuffer, i, 1);
        if (write < 0) {
            this.aQo = 0;
            AppMethodBeat.m2505o(94690);
            return write;
        }
        this.aQo -= write;
        AppMethodBeat.m2505o(94690);
        return write;
    }

    /* renamed from: aI */
    public final long mo72527aI(boolean z) {
        Object obj;
        AppMethodBeat.m2504i(94676);
        if (!isInitialized() || this.aQD == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            AppMethodBeat.m2505o(94676);
            return Long.MIN_VALUE;
        }
        long qA;
        if (this.aQf.getPlayState() == 3) {
            long qy = this.aQc.mo2541qy();
            if (qy != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.aQs >= 30000) {
                    this.aQb[this.aQp] = qy - nanoTime;
                    this.aQp = (this.aQp + 1) % 10;
                    if (this.aQq < 10) {
                        this.aQq++;
                    }
                    this.aQs = nanoTime;
                    this.aQr = 0;
                    for (int i = 0; i < this.aQq; i++) {
                        this.aQr += this.aQb[i] / ((long) this.aQq);
                    }
                }
                if (!mo72540qv() && nanoTime - this.aQu >= 500000) {
                    this.aQt = this.aQc.mo2542qz();
                    if (this.aQt) {
                        qA = this.aQc.mo2538qA() / 1000;
                        long qB = this.aQc.mo2539qB();
                        if (qA >= this.aQF) {
                            String str;
                            C32019e c32019e;
                            if (Math.abs(qA - nanoTime) > 5000000) {
                                str = "Spurious audio timestamp (system clock mismatch): " + qB + ", " + qA + ", " + nanoTime + ", " + qy + ", " + mo72537qs() + ", " + mo72538qt();
                                if (aPU) {
                                    c32019e = new C32019e(str);
                                    AppMethodBeat.m2505o(94676);
                                    throw c32019e;
                                }
                                this.aQt = false;
                            } else if (Math.abs(mo72524J(qB) - qy) > 5000000) {
                                str = "Spurious audio timestamp (frame position mismatch): " + qB + ", " + qA + ", " + nanoTime + ", " + qy + ", " + mo72537qs() + ", " + mo72538qt();
                                if (aPU) {
                                    c32019e = new C32019e(str);
                                    AppMethodBeat.m2505o(94676);
                                    throw c32019e;
                                }
                            }
                        }
                        this.aQt = false;
                    }
                    if (!(this.aQv == null || this.aQi)) {
                        try {
                            this.aQG = (((long) ((Integer) this.aQv.invoke(this.aQf, null)).intValue()) * 1000) - this.aQj;
                            this.aQG = Math.max(this.aQG, 0);
                            if (this.aQG > 5000000) {
                                new StringBuilder("Ignoring impossibly large audio latency: ").append(this.aQG);
                                this.aQG = 0;
                            }
                        } catch (Exception e) {
                            this.aQv = null;
                        }
                    }
                    this.aQu = nanoTime;
                }
            }
        }
        qA = System.nanoTime() / 1000;
        if (this.aQt) {
            qA = mo72524J(mo72525K(qA - (this.aQc.mo2538qA() / 1000)) + this.aQc.mo2539qB());
        } else {
            if (this.aQq == 0) {
                qA = this.aQc.mo2541qy();
            } else {
                qA += this.aQr;
            }
            if (!z) {
                qA -= this.aQG;
            }
        }
        qA = m82453I(qA) + this.aQE;
        AppMethodBeat.m2505o(94676);
        return qA;
    }
}
