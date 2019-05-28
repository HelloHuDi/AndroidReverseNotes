package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public final class f {
    public static boolean aPT = false;
    public static boolean aPU = false;
    p aNg;
    int aOX;
    b aOY;
    private final c aPV;
    final g aPW;
    private final l aPX;
    final d[] aPY;
    final f aPZ;
    private long aQA;
    private long aQB;
    int aQC;
    int aQD;
    long aQE;
    private long aQF;
    private long aQG;
    float aQH;
    private d[] aQI;
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
    final a aQc;
    final LinkedList<g> aQd;
    AudioTrack aQe;
    AudioTrack aQf;
    int aQg;
    int aQh;
    boolean aQi;
    long aQj;
    p aQk;
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

    static class a {
        private boolean aQW;
        private long aQX;
        private long aQY;
        private long aQZ;
        protected AudioTrack aQf;
        private long aRa;
        private long aRb;
        private long aRc;
        private int sampleRate;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.i(94662);
            this.aQf = audioTrack;
            this.aQW = z;
            this.aRa = -9223372036854775807L;
            this.aQX = 0;
            this.aQY = 0;
            this.aQZ = 0;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
            AppMethodBeat.o(94662);
        }

        public final void L(long j) {
            AppMethodBeat.i(94663);
            this.aRb = qx();
            this.aRa = SystemClock.elapsedRealtime() * 1000;
            this.aRc = j;
            this.aQf.stop();
            AppMethodBeat.o(94663);
        }

        public final void pause() {
            AppMethodBeat.i(94664);
            if (this.aRa != -9223372036854775807L) {
                AppMethodBeat.o(94664);
                return;
            }
            this.aQf.pause();
            AppMethodBeat.o(94664);
        }

        public final long qx() {
            AppMethodBeat.i(94665);
            long min;
            if (this.aRa != -9223372036854775807L) {
                min = Math.min(this.aRc, ((((SystemClock.elapsedRealtime() * 1000) - this.aRa) * ((long) this.sampleRate)) / 1000000) + this.aRb);
                AppMethodBeat.o(94665);
                return min;
            }
            int playState = this.aQf.getPlayState();
            if (playState == 1) {
                AppMethodBeat.o(94665);
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
            AppMethodBeat.o(94665);
            return min;
        }

        public final long qy() {
            AppMethodBeat.i(94666);
            long qx = (qx() * 1000000) / ((long) this.sampleRate);
            AppMethodBeat.o(94666);
            return qx;
        }

        public boolean qz() {
            return false;
        }

        public long qA() {
            AppMethodBeat.i(94667);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(94667);
            throw unsupportedOperationException;
        }

        public long qB() {
            AppMethodBeat.i(94668);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(94668);
            throw unsupportedOperationException;
        }
    }

    @TargetApi(19)
    static class b extends a {
        private final AudioTimestamp aRd = new AudioTimestamp();
        private long aRe;
        private long aRf;
        private long aRg;

        public b() {
            super();
            AppMethodBeat.i(94669);
            AppMethodBeat.o(94669);
        }

        public final void a(AudioTrack audioTrack, boolean z) {
            AppMethodBeat.i(94670);
            super.a(audioTrack, z);
            this.aRe = 0;
            this.aRf = 0;
            this.aRg = 0;
            AppMethodBeat.o(94670);
        }

        public final boolean qz() {
            AppMethodBeat.i(94671);
            boolean timestamp = this.aQf.getTimestamp(this.aRd);
            if (timestamp) {
                long j = this.aRd.framePosition;
                if (this.aRf > j) {
                    this.aRe++;
                }
                this.aRf = j;
                this.aRg = j + (this.aRe << 32);
            }
            AppMethodBeat.o(94671);
            return timestamp;
        }

        public final long qA() {
            return this.aRd.nanoTime;
        }

        public final long qB() {
            return this.aRg;
        }
    }

    public static final class c extends Exception {
        public c(Throwable th) {
            super(th);
        }

        public c(String str) {
            super(str);
        }
    }

    public static final class e extends RuntimeException {
        public e(String str) {
            super(str);
        }
    }

    public interface f {
        void dx(int i);

        void e(int i, long j, long j2);

        void qe();
    }

    static final class g {
        final long aNT;
        final p aNg;
        final long aRi;

        /* synthetic */ g(p pVar, long j, long j2, byte b) {
            this(pVar, j, j2);
        }

        private g(p pVar, long j, long j2) {
            this.aNg = pVar;
            this.aRi = j;
            this.aNT = j2;
        }
    }

    public static final class h extends Exception {
        public final int errorCode;

        public h(int i) {
            super("AudioTrack write failed: ".concat(String.valueOf(i)));
            AppMethodBeat.i(94673);
            this.errorCode = i;
            AppMethodBeat.o(94673);
        }
    }

    public static final class d extends Exception {
        public final int aRh;

        public d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            AppMethodBeat.i(94672);
            this.aRh = i;
            AppMethodBeat.o(94672);
        }
    }

    public f(c cVar, d[] dVarArr, f fVar) {
        AppMethodBeat.i(94674);
        this.aPV = cVar;
        this.aPZ = fVar;
        if (v.SDK_INT >= 18) {
            try {
                this.aQv = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.aQc = new b();
        } else {
            this.aQc = new a();
        }
        this.aPW = new g();
        this.aPX = new l();
        this.aPY = new d[(dVarArr.length + 3)];
        this.aPY[0] = new j();
        this.aPY[1] = this.aPW;
        System.arraycopy(dVarArr, 0, this.aPY, 2, dVarArr.length);
        this.aPY[dVarArr.length + 2] = this.aPX;
        this.aQb = new long[10];
        this.aQH = 1.0f;
        this.aQD = 0;
        this.aOY = b.aPz;
        this.aOX = 0;
        this.aNg = p.aOC;
        this.aQO = -1;
        this.aQI = new d[0];
        this.aQJ = new ByteBuffer[0];
        this.aQd = new LinkedList();
        AppMethodBeat.o(94674);
    }

    public final boolean at(String str) {
        AppMethodBeat.i(94675);
        if (this.aPV != null) {
            boolean z;
            c cVar = this.aPV;
            if (Arrays.binarySearch(cVar.aPE, au(str)) >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(94675);
                return true;
            }
        }
        AppMethodBeat.o(94675);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void qn() {
        int i;
        AppMethodBeat.i(94677);
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.aPY) {
            if (dVar.isActive()) {
                arrayList.add(dVar);
            } else {
                dVar.flush();
            }
        }
        int size = arrayList.size();
        this.aQI = (d[]) arrayList.toArray(new d[size]);
        this.aQJ = new ByteBuffer[size];
        for (i = 0; i < size; i++) {
            d dVar2 = this.aQI[i];
            dVar2.flush();
            this.aQJ[i] = dVar2.qm();
        }
        AppMethodBeat.o(94677);
    }

    public final void play() {
        AppMethodBeat.i(94678);
        this.aQQ = true;
        if (isInitialized()) {
            this.aQF = System.nanoTime() / 1000;
            this.aQf.play();
        }
        AppMethodBeat.o(94678);
    }

    /* Access modifiers changed, original: final */
    public final void H(long j) {
        AppMethodBeat.i(94679);
        int length = this.aQI.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.aQJ[i - 1] : this.aQK != null ? this.aQK : d.aPG;
            if (i == length) {
                a(byteBuffer, j);
            } else {
                d dVar = this.aQI[i];
                dVar.g(byteBuffer);
                ByteBuffer qm = dVar.qm();
                this.aQJ[i] = qm;
                if (qm.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                AppMethodBeat.o(94679);
                return;
            }
            i--;
        }
        AppMethodBeat.o(94679);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(ByteBuffer byteBuffer, long j) {
        AppMethodBeat.i(94680);
        if (byteBuffer.hasRemaining()) {
            boolean z;
            int remaining;
            if (this.aQL != null) {
                if (this.aQL == byteBuffer) {
                    z = true;
                } else {
                    z = false;
                }
                com.google.android.exoplayer2.i.a.checkArgument(z);
            } else {
                this.aQL = byteBuffer;
                if (v.SDK_INT < 21) {
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
            if (v.SDK_INT < 21) {
                remaining = this.bufferSize - ((int) (this.aQA - (this.aQc.qx() * ((long) this.aQz))));
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
                com.google.android.exoplayer2.i.a.checkState(z);
                remaining = a(this.aQf, byteBuffer, remaining2, j);
            } else {
                remaining = this.aQf.write(byteBuffer, remaining2, 1);
            }
            this.aQT = SystemClock.elapsedRealtime();
            if (remaining < 0) {
                h hVar = new h(remaining);
                AppMethodBeat.o(94680);
                throw hVar;
            }
            if (!this.aQi) {
                this.aQA += (long) remaining;
            }
            if (remaining == remaining2) {
                if (this.aQi) {
                    this.aQB += (long) this.aQC;
                }
                this.aQL = null;
                AppMethodBeat.o(94680);
                return true;
            }
            AppMethodBeat.o(94680);
            return false;
        }
        AppMethodBeat.o(94680);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean qo() {
        boolean z;
        AppMethodBeat.i(94681);
        if (this.aQO == -1) {
            this.aQO = this.aQi ? this.aQI.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.aQO < this.aQI.length) {
            d dVar = this.aQI[this.aQO];
            if (z) {
                dVar.ql();
            }
            H(-9223372036854775807L);
            if (dVar.qf()) {
                this.aQO++;
                z = true;
            } else {
                AppMethodBeat.o(94681);
                return false;
            }
        }
        if (this.aQL != null) {
            a(this.aQL, -9223372036854775807L);
            if (this.aQL != null) {
                AppMethodBeat.o(94681);
                return false;
            }
        }
        this.aQO = -1;
        AppMethodBeat.o(94681);
        return true;
    }

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (r2 != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean qp() {
        AppMethodBeat.i(94682);
        if (isInitialized()) {
            if (qt() <= this.aQc.qx()) {
                boolean z;
                if (qv() && this.aQf.getPlayState() == 2 && this.aQf.getPlaybackHeadPosition() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            AppMethodBeat.o(94682);
            return true;
        }
        AppMethodBeat.o(94682);
        return false;
    }

    public final p b(p pVar) {
        AppMethodBeat.i(94683);
        p pVar2;
        if (this.aQi) {
            this.aNg = p.aOC;
            pVar2 = this.aNg;
            AppMethodBeat.o(94683);
            return pVar2;
        }
        Object obj;
        l lVar = this.aPX;
        lVar.speed = v.h(pVar.speed, 0.1f, 8.0f);
        float f = lVar.speed;
        l lVar2 = this.aPX;
        float f2 = pVar.pitch;
        lVar2.pitch = v.h(f2, 0.1f, 8.0f);
        p pVar3 = new p(f, f2);
        if (this.aQk != null) {
            obj = this.aQk;
        } else if (this.aQd.isEmpty()) {
            obj = this.aNg;
        } else {
            obj = ((g) this.aQd.getLast()).aNg;
        }
        if (!pVar3.equals(obj)) {
            if (isInitialized()) {
                this.aQk = pVar3;
            } else {
                this.aNg = pVar3;
            }
        }
        pVar2 = this.aNg;
        AppMethodBeat.o(94683);
        return pVar2;
    }

    /* Access modifiers changed, original: final */
    public final void qq() {
        AppMethodBeat.i(94684);
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                this.aQf.setVolume(this.aQH);
                AppMethodBeat.o(94684);
                return;
            }
            AudioTrack audioTrack = this.aQf;
            float f = this.aQH;
            audioTrack.setStereoVolume(f, f);
        }
        AppMethodBeat.o(94684);
    }

    public final void reset() {
        AppMethodBeat.i(94685);
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
                this.aNg = ((g) this.aQd.getLast()).aNg;
            }
            this.aQd.clear();
            this.aQl = 0;
            this.aQm = 0;
            this.aQK = null;
            this.aQL = null;
            for (int i = 0; i < this.aQI.length; i++) {
                d dVar = this.aQI[i];
                dVar.flush();
                this.aQJ[i] = dVar.qm();
            }
            this.aQP = false;
            this.aQO = -1;
            this.aQn = null;
            this.aQo = 0;
            this.aQD = 0;
            this.aQG = 0;
            qu();
            if (this.aQf.getPlayState() == 3) {
                this.aQf.pause();
            }
            final AudioTrack audioTrack = this.aQf;
            this.aQf = null;
            this.aQc.a(null, false);
            this.aQa.close();
            new Thread() {
                public final void run() {
                    AppMethodBeat.i(94660);
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        f.this.aQa.open();
                        AppMethodBeat.o(94660);
                    }
                }
            }.start();
        }
        AppMethodBeat.o(94685);
    }

    /* Access modifiers changed, original: final */
    public final void qr() {
        AppMethodBeat.i(94686);
        if (this.aQe == null) {
            AppMethodBeat.o(94686);
            return;
        }
        final AudioTrack audioTrack = this.aQe;
        this.aQe = null;
        new Thread() {
            public final void run() {
                AppMethodBeat.i(94661);
                audioTrack.release();
                AppMethodBeat.o(94661);
            }
        }.start();
        AppMethodBeat.o(94686);
    }

    private long I(long j) {
        AppMethodBeat.i(94687);
        while (!this.aQd.isEmpty() && j >= ((g) this.aQd.getFirst()).aNT) {
            g gVar = (g) this.aQd.remove();
            this.aNg = gVar.aNg;
            this.aQm = gVar.aNT;
            this.aQl = gVar.aRi - this.aQE;
        }
        long j2;
        if (this.aNg.speed == 1.0f) {
            j2 = (this.aQl + j) - this.aQm;
            AppMethodBeat.o(94687);
            return j2;
        } else if (!this.aQd.isEmpty() || this.aPX.aRW < 1024) {
            j2 = this.aQl + ((long) (((double) this.aNg.speed) * ((double) (j - this.aQm))));
            AppMethodBeat.o(94687);
            return j2;
        } else {
            j2 = v.b(j - this.aQm, this.aPX.aRV, this.aPX.aRW) + this.aQl;
            AppMethodBeat.o(94687);
            return j2;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean isInitialized() {
        return this.aQf != null;
    }

    /* Access modifiers changed, original: final */
    public final long J(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    /* Access modifiers changed, original: final */
    public final long K(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    /* Access modifiers changed, original: final */
    public final long qs() {
        return this.aQi ? this.aQy : this.aQx / ((long) this.aQw);
    }

    /* Access modifiers changed, original: final */
    public final long qt() {
        return this.aQi ? this.aQB : this.aQA / ((long) this.aQz);
    }

    /* Access modifiers changed, original: final */
    public final void qu() {
        this.aQr = 0;
        this.aQq = 0;
        this.aQp = 0;
        this.aQs = 0;
        this.aQt = false;
        this.aQu = 0;
    }

    /* Access modifiers changed, original: final */
    public final boolean qv() {
        return v.SDK_INT < 23 && (this.aQh == 5 || this.aQh == 6);
    }

    /* Access modifiers changed, original: final */
    public final AudioTrack qw() {
        AudioTrack audioTrack;
        AppMethodBeat.i(94688);
        if (v.SDK_INT >= 21) {
            AudioAttributes build;
            if (this.aQR) {
                build = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                b bVar = this.aOY;
                if (bVar.aPC == null) {
                    bVar.aPC = new Builder().setContentType(bVar.aPA).setFlags(bVar.flags).setUsage(bVar.aPB).build();
                }
                build = bVar.aPC;
            }
            audioTrack = new AudioTrack(build, new AudioFormat.Builder().setChannelMask(this.aQg).setEncoding(this.aQh).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.aOX != 0 ? this.aOX : 0);
        } else {
            int eS = v.eS(this.aOY.aPB);
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
            d dVar = new d(state, this.sampleRate, this.aQg, this.bufferSize);
            AppMethodBeat.o(94688);
            throw dVar;
        }
        AppMethodBeat.o(94688);
        return audioTrack;
    }

    static int au(String str) {
        AppMethodBeat.i(94689);
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
                AppMethodBeat.o(94689);
                return 5;
            case 1:
                AppMethodBeat.o(94689);
                return 6;
            case 2:
                AppMethodBeat.o(94689);
                return 7;
            case 3:
                AppMethodBeat.o(94689);
                return 8;
            default:
                AppMethodBeat.o(94689);
                return 0;
        }
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        int write;
        AppMethodBeat.i(94690);
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
                AppMethodBeat.o(94690);
                return write;
            } else if (write < remaining) {
                AppMethodBeat.o(94690);
                return 0;
            }
        }
        write = audioTrack.write(byteBuffer, i, 1);
        if (write < 0) {
            this.aQo = 0;
            AppMethodBeat.o(94690);
            return write;
        }
        this.aQo -= write;
        AppMethodBeat.o(94690);
        return write;
    }

    public final long aI(boolean z) {
        Object obj;
        AppMethodBeat.i(94676);
        if (!isInitialized() || this.aQD == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            AppMethodBeat.o(94676);
            return Long.MIN_VALUE;
        }
        long qA;
        if (this.aQf.getPlayState() == 3) {
            long qy = this.aQc.qy();
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
                if (!qv() && nanoTime - this.aQu >= 500000) {
                    this.aQt = this.aQc.qz();
                    if (this.aQt) {
                        qA = this.aQc.qA() / 1000;
                        long qB = this.aQc.qB();
                        if (qA >= this.aQF) {
                            String str;
                            e eVar;
                            if (Math.abs(qA - nanoTime) > 5000000) {
                                str = "Spurious audio timestamp (system clock mismatch): " + qB + ", " + qA + ", " + nanoTime + ", " + qy + ", " + qs() + ", " + qt();
                                if (aPU) {
                                    eVar = new e(str);
                                    AppMethodBeat.o(94676);
                                    throw eVar;
                                }
                                this.aQt = false;
                            } else if (Math.abs(J(qB) - qy) > 5000000) {
                                str = "Spurious audio timestamp (frame position mismatch): " + qB + ", " + qA + ", " + nanoTime + ", " + qy + ", " + qs() + ", " + qt();
                                if (aPU) {
                                    eVar = new e(str);
                                    AppMethodBeat.o(94676);
                                    throw eVar;
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
            qA = J(K(qA - (this.aQc.qA() / 1000)) + this.aQc.qB());
        } else {
            if (this.aQq == 0) {
                qA = this.aQc.qy();
            } else {
                qA += this.aQr;
            }
            if (!z) {
                qA -= this.aQG;
            }
        }
        qA = I(qA) + this.aQE;
        AppMethodBeat.o(94676);
        return qA;
    }
}
