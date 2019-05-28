package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37232b;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p110h.C41613s;
import com.google.android.exoplayer2.p110h.C41613s.C32059c;
import com.google.android.exoplayer2.p110h.C41613s.C32060d;
import com.google.android.exoplayer2.p110h.C41613s.C8683a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C8684e;
import com.google.android.exoplayer2.source.C25560k.C17687b;
import com.google.android.exoplayer2.source.C37279h.C37280a;
import com.google.android.exoplayer2.source.C46871g.C0881a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.f */
final class C41629f implements C8662g, C8683a<C8713a>, C32060d, C37279h, C17687b {
    long aOz;
    private final C0867f aSF;
    private final int bgC;
    final C0881a bgD;
    final C8715c bgE;
    private final C32053b bgF;
    final String bgG;
    final long bgH;
    final C41613s bgI = new C41613s("Loader:ExtractorMediaPeriod");
    private final C8714b bgJ;
    final C8684e bgK;
    private final Runnable bgL;
    final Runnable bgM;
    C37247l bgN;
    C25560k[] bgO;
    private int[] bgP;
    boolean bgQ;
    private boolean bgR;
    boolean bgS;
    private int bgT;
    C41631p bgU;
    boolean[] bgV;
    boolean[] bgW;
    boolean bgX;
    private long bgY;
    long bgZ;
    C37280a bgq;
    private long bha;
    private int bhb;
    boolean bhc;
    private final Handler eventHandler;
    final Handler handler;
    boolean prepared;
    boolean released;
    private final Uri uri;

    /* renamed from: com.google.android.exoplayer2.source.f$a */
    final class C8713a implements C32059c {
        private final C0867f aSF;
        private final C8714b bgJ;
        private final C8684e bgK;
        long bgY = -1;
        private final C32040k bhe = new C32040k();
        private volatile boolean bhf;
        private boolean bhg = true;
        private long bhh;
        private final Uri uri;

        public C8713a(Uri uri, C0867f c0867f, C8714b c8714b, C8684e c8684e) {
            AppMethodBeat.m2504i(95480);
            this.uri = (Uri) C45039a.checkNotNull(uri);
            this.aSF = (C0867f) C45039a.checkNotNull(c0867f);
            this.bgJ = (C8714b) C45039a.checkNotNull(c8714b);
            this.bgK = c8684e;
            AppMethodBeat.m2505o(95480);
        }

        /* renamed from: j */
        public final void mo19286j(long j, long j2) {
            this.bhe.position = j;
            this.bhh = j2;
            this.bhg = true;
        }

        /* renamed from: se */
        public final void mo19287se() {
            this.bhf = true;
        }

        /* renamed from: sf */
        public final boolean mo19288sf() {
            return this.bhf;
        }

        /* renamed from: sg */
        public final void mo19289sg() {
            Throwable th;
            Object obj;
            C45026f obj2;
            AppMethodBeat.m2504i(95481);
            int i = 0;
            while (i == 0 && !this.bhf) {
                int a;
                try {
                    long j = this.bhe.position;
                    this.bgY = this.aSF.mo2583a(new C17665i(this.uri, j, -1, C41629f.this.bgG));
                    if (this.bgY != -1) {
                        this.bgY += j;
                    }
                    C37232b c37232b = new C37232b(this.aSF, j, this.bgY);
                    try {
                        int i2;
                        C32034e a2 = this.bgJ.mo19290a(c37232b, this.aSF.getUri());
                        if (this.bhg) {
                            a2.mo2571g(j, this.bhh);
                            this.bhg = false;
                        }
                        int i3 = i;
                        while (i3 == 0) {
                            try {
                                if (this.bhf) {
                                    break;
                                }
                                this.bgK.block();
                                a = a2.mo2568a(c37232b, this.bhe);
                                try {
                                    if (c37232b.getPosition() > C41629f.this.bgH + j) {
                                        j = c37232b.getPosition();
                                        this.bgK.mo19214tw();
                                        C41629f.this.handler.post(C41629f.this.bgM);
                                        i3 = a;
                                    } else {
                                        i3 = a;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = c37232b;
                                    this.bhe.position = obj2.getPosition();
                                    C17675v.m27555a(this.aSF);
                                    AppMethodBeat.m2505o(95481);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj2 = c37232b;
                                a = i3;
                                this.bhe.position = obj2.getPosition();
                                C17675v.m27555a(this.aSF);
                                AppMethodBeat.m2505o(95481);
                                throw th;
                            }
                        }
                        if (i3 == 1) {
                            i2 = 0;
                        } else {
                            this.bhe.position = c37232b.getPosition();
                            i2 = i3;
                        }
                        C17675v.m27555a(this.aSF);
                        i = i2;
                    } catch (Throwable th22) {
                        th = th22;
                        obj2 = c37232b;
                        a = i;
                        this.bhe.position = obj2.getPosition();
                        C17675v.m27555a(this.aSF);
                        AppMethodBeat.m2505o(95481);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj2 = null;
                    a = i;
                    if (!(a == 1 || obj2 == null)) {
                        this.bhe.position = obj2.getPosition();
                    }
                    C17675v.m27555a(this.aSF);
                    AppMethodBeat.m2505o(95481);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(95481);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.f$b */
    static final class C8714b {
        private final C8662g aTn;
        private final C32034e[] bhi;
        C32034e bhj;

        public C8714b(C32034e[] c32034eArr, C8662g c8662g) {
            this.bhi = c32034eArr;
            this.aTn = c8662g;
        }

        /* renamed from: a */
        public final C32034e mo19290a(C45026f c45026f, Uri uri) {
            AppMethodBeat.m2504i(95482);
            C32034e c32034e;
            if (this.bhj != null) {
                c32034e = this.bhj;
                AppMethodBeat.m2505o(95482);
                return c32034e;
            }
            C32034e[] c32034eArr = this.bhi;
            int length = c32034eArr.length;
            int i = 0;
            while (i < length) {
                C32034e c32034e2 = c32034eArr[i];
                try {
                    if (c32034e2.mo2570a(c45026f)) {
                        this.bhj = c32034e2;
                        c45026f.mo59486qY();
                        break;
                    }
                    c45026f.mo59486qY();
                    i++;
                } catch (EOFException e) {
                    c45026f.mo59486qY();
                } catch (Throwable th) {
                    c45026f.mo59486qY();
                    AppMethodBeat.m2505o(95482);
                }
            }
            if (this.bhj == null) {
                C41632q c41632q = new C41632q("None of the available extractors (" + C17675v.m27567d(this.bhi) + ") could read the stream.", uri);
                AppMethodBeat.m2505o(95482);
                throw c41632q;
            }
            this.bhj.mo2569a(this.aTn);
            c32034e = this.bhj;
            AppMethodBeat.m2505o(95482);
            return c32034e;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.f$c */
    interface C8715c {
        /* renamed from: e */
        void mo19291e(long j, boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.source.f$d */
    final class C8716d implements C17688l {
        final int track;

        public C8716d(int i) {
            this.track = i;
        }

        public final boolean isReady() {
            AppMethodBeat.m2504i(95483);
            C41629f c41629f = C41629f.this;
            int i = this.track;
            if (c41629f.bhc || (!c41629f.mo66762sd() && c41629f.bgO[i].bhG.mo59540sk())) {
                AppMethodBeat.m2505o(95483);
                return true;
            }
            AppMethodBeat.m2505o(95483);
            return false;
        }

        /* renamed from: rW */
        public final void mo19295rW() {
        }

        /* renamed from: b */
        public final int mo19293b(C8692k c8692k, C32022e c32022e, boolean z) {
            AppMethodBeat.m2504i(95484);
            C41629f c41629f = C41629f.this;
            int i = this.track;
            if (c41629f.bgS || c41629f.mo66762sd()) {
                AppMethodBeat.m2505o(95484);
                return -3;
            }
            int a = c41629f.bgO[i].mo42833a(c8692k, c32022e, z, c41629f.bhc, c41629f.bgZ);
            AppMethodBeat.m2505o(95484);
            return a;
        }

        /* renamed from: Z */
        public final void mo19292Z(long j) {
            AppMethodBeat.m2504i(95485);
            C41629f c41629f = C41629f.this;
            C25560k c25560k = c41629f.bgO[this.track];
            if (!c41629f.bhc || j <= c25560k.bhG.mo59537sc()) {
                c25560k.mo42837g(j, true);
                AppMethodBeat.m2505o(95485);
                return;
            }
            c25560k.bhG.mo59542sm();
            AppMethodBeat.m2505o(95485);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.f$1 */
    class C320751 implements Runnable {
        C320751() {
        }

        public final void run() {
            AppMethodBeat.m2504i(95477);
            C41629f c41629f = C41629f.this;
            if (c41629f.released || c41629f.prepared || c41629f.bgN == null || !c41629f.bgQ) {
                AppMethodBeat.m2505o(95477);
                return;
            }
            for (C25560k c25560k : c41629f.bgO) {
                if (c25560k.bhG.mo59541sl() == null) {
                    break;
                }
            }
            c41629f.bgK.mo19214tw();
            int length = c41629f.bgO.length;
            C41630o[] c41630oArr = new C41630o[length];
            c41629f.bgW = new boolean[length];
            c41629f.bgV = new boolean[length];
            c41629f.aOz = c41629f.bgN.getDurationUs();
            for (int i = 0; i < length; i++) {
                boolean z;
                c41630oArr[i] = new C41630o(c41629f.bgO[i].bhG.mo59541sl());
                String str = r0.aOd;
                if (C37265i.m62523aI(str) || C37265i.m62522aH(str)) {
                    z = true;
                } else {
                    z = false;
                }
                c41629f.bgW[i] = z;
                c41629f.bgX = z | c41629f.bgX;
            }
            c41629f.bgU = new C41631p(c41630oArr);
            c41629f.prepared = true;
            c41629f.bgE.mo19291e(c41629f.aOz, c41629f.bgN.mo2552qX());
            c41629f.bgq.mo32388a(c41629f);
            AppMethodBeat.m2505o(95477);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.f$2 */
    class C320762 implements Runnable {
        C320762() {
        }

        public final void run() {
            AppMethodBeat.m2504i(95478);
            if (!C41629f.this.released) {
                C41629f.this.bgq.mo19279a(C41629f.this);
            }
            AppMethodBeat.m2505o(95478);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo2604a(C32059c c32059c, long j, long j2) {
        AppMethodBeat.m2504i(95505);
        m72964a((C8713a) c32059c);
        this.bhc = true;
        if (this.aOz == -9223372036854775807L) {
            long sc = m72967sc();
            this.aOz = sc == Long.MIN_VALUE ? 0 : sc + 10000;
            this.bgE.mo19291e(this.aOz, this.bgN.mo2552qX());
        }
        this.bgq.mo19279a(this);
        AppMethodBeat.m2505o(95505);
    }

    public C41629f(Uri uri, C0867f c0867f, C32034e[] c32034eArr, int i, Handler handler, C0881a c0881a, C8715c c8715c, C32053b c32053b, String str, int i2) {
        AppMethodBeat.m2504i(95486);
        this.uri = uri;
        this.aSF = c0867f;
        this.bgC = i;
        this.eventHandler = handler;
        this.bgD = c0881a;
        this.bgE = c8715c;
        this.bgF = c32053b;
        this.bgG = str;
        this.bgH = (long) i2;
        this.bgJ = new C8714b(c32034eArr, this);
        this.bgK = new C8684e();
        this.bgL = new C320751();
        this.bgM = new C320762();
        this.handler = new Handler();
        this.bgP = new int[0];
        this.bgO = new C25560k[0];
        this.bha = -9223372036854775807L;
        this.bgY = -1;
        AppMethodBeat.m2505o(95486);
    }

    /* renamed from: rZ */
    public final void mo52350rZ() {
        AppMethodBeat.m2504i(95487);
        C8714b c8714b = this.bgJ;
        if (c8714b.bhj != null) {
            c8714b.bhj = null;
        }
        for (C25560k reset : this.bgO) {
            reset.reset(false);
        }
        AppMethodBeat.m2505o(95487);
    }

    /* renamed from: a */
    public final void mo19278a(C37280a c37280a, long j) {
        AppMethodBeat.m2504i(95488);
        this.bgq = c37280a;
        this.bgK.open();
        startLoading();
        AppMethodBeat.m2505o(95488);
    }

    /* renamed from: rR */
    public final void mo19281rR() {
    }

    /* renamed from: rS */
    public final C41631p mo19282rS() {
        return this.bgU;
    }

    /* renamed from: a */
    public final long mo19276a(C45035f[] c45035fArr, boolean[] zArr, C17688l[] c17688lArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int i2 = 0;
        AppMethodBeat.m2504i(95489);
        C45039a.checkState(this.prepared);
        int i3 = this.bgT;
        int i4 = 0;
        while (i4 < c45035fArr.length) {
            if (c17688lArr[i4] != null && (c45035fArr[i4] == null || !zArr[i4])) {
                i = ((C8716d) c17688lArr[i4]).track;
                C45039a.checkState(this.bgV[i]);
                this.bgT--;
                this.bgV[i] = false;
                c17688lArr[i4] = null;
            }
            i4++;
        }
        boolean z2 = this.bgR ? i3 == 0 : j != 0;
        i3 = 0;
        while (true) {
            z = z2;
            if (i3 >= c45035fArr.length) {
                break;
            }
            if (c17688lArr[i3] == null && c45035fArr[i3] != null) {
                C45035f c45035f = c45035fArr[i3];
                if (c45035f.length() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C45039a.checkState(z2);
                if (c45035f.mo19198eH(0) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C45039a.checkState(z2);
                int a = this.bgU.mo66766a(c45035f.mo19206tf());
                if (this.bgV[a]) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                C45039a.checkState(z2);
                this.bgT++;
                this.bgV[a] = true;
                c17688lArr[i3] = new C8716d(a);
                zArr2[i3] = true;
                if (!z) {
                    C25560k c25560k = this.bgO[a];
                    c25560k.rewind();
                    if (c25560k.mo42837g(j, true) || c25560k.bhG.mo59539sj() == 0) {
                        z2 = false;
                        i3++;
                    } else {
                        z2 = true;
                        i3++;
                    }
                }
            }
            z2 = z;
            i3++;
        }
        if (this.bgT == 0) {
            this.bgS = false;
            if (this.bgI.isLoading()) {
                C25560k[] c25560kArr = this.bgO;
                i4 = c25560kArr.length;
                while (i2 < i4) {
                    c25560kArr[i2].mo42842sq();
                    i2++;
                }
                this.bgI.cancelLoading();
            } else {
                for (C25560k reset : this.bgO) {
                    reset.reset(false);
                }
            }
        } else if (z) {
            j = mo19274X(j);
            while (i2 < c17688lArr.length) {
                if (c17688lArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.bgR = true;
        AppMethodBeat.m2505o(95489);
        return j;
    }

    /* renamed from: W */
    public final void mo19273W(long j) {
        AppMethodBeat.m2504i(95490);
        int length = this.bgO.length;
        for (int i = 0; i < length; i++) {
            this.bgO[i].mo42838i(j, this.bgV[i]);
        }
        AppMethodBeat.m2505o(95490);
    }

    /* renamed from: Y */
    public final boolean mo19275Y(long j) {
        AppMethodBeat.m2504i(95491);
        if (this.bhc || (this.prepared && this.bgT == 0)) {
            AppMethodBeat.m2505o(95491);
            return false;
        }
        boolean open = this.bgK.open();
        if (!this.bgI.isLoading()) {
            startLoading();
            open = true;
        }
        AppMethodBeat.m2505o(95491);
        return open;
    }

    /* renamed from: rV */
    public final long mo19285rV() {
        AppMethodBeat.m2504i(95492);
        if (this.bgT == 0) {
            AppMethodBeat.m2505o(95492);
            return Long.MIN_VALUE;
        }
        long rU = mo19284rU();
        AppMethodBeat.m2505o(95492);
        return rU;
    }

    /* renamed from: rT */
    public final long mo19283rT() {
        if (!this.bgS) {
            return -9223372036854775807L;
        }
        this.bgS = false;
        return this.bgZ;
    }

    /* renamed from: rU */
    public final long mo19284rU() {
        AppMethodBeat.m2504i(95493);
        long j;
        if (this.bhc) {
            AppMethodBeat.m2505o(95493);
            return Long.MIN_VALUE;
        } else if (mo66762sd()) {
            j = this.bha;
            AppMethodBeat.m2505o(95493);
            return j;
        } else {
            if (this.bgX) {
                j = Long.MAX_VALUE;
                int length = this.bgO.length;
                for (int i = 0; i < length; i++) {
                    if (this.bgW[i]) {
                        j = Math.min(j, this.bgO[i].bhG.mo59537sc());
                    }
                }
            } else {
                j = m72967sc();
            }
            if (j == Long.MIN_VALUE) {
                j = this.bgZ;
                AppMethodBeat.m2505o(95493);
                return j;
            }
            AppMethodBeat.m2505o(95493);
            return j;
        }
    }

    /* renamed from: X */
    public final long mo19274X(long j) {
        AppMethodBeat.m2504i(95494);
        if (!this.bgN.mo2552qX()) {
            j = 0;
        }
        this.bgZ = j;
        this.bgS = false;
        if (mo66762sd() || !m72965aa(j)) {
            this.bha = j;
            this.bhc = false;
            if (this.bgI.isLoading()) {
                this.bgI.cancelLoading();
            } else {
                for (C25560k reset : this.bgO) {
                    reset.reset(false);
                }
            }
            AppMethodBeat.m2505o(95494);
        } else {
            AppMethodBeat.m2505o(95494);
        }
        return j;
    }

    /* renamed from: dM */
    public final C32041m mo19157dM(int i) {
        AppMethodBeat.m2504i(95495);
        int length = this.bgO.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.bgP[i2] == i) {
                C32041m c32041m = this.bgO[i2];
                AppMethodBeat.m2505o(95495);
                return c32041m;
            }
        }
        C25560k c25560k = new C25560k(this.bgF);
        c25560k.bhQ = this;
        this.bgP = Arrays.copyOf(this.bgP, length + 1);
        this.bgP[length] = i;
        this.bgO = (C25560k[]) Arrays.copyOf(this.bgO, length + 1);
        this.bgO[length] = c25560k;
        AppMethodBeat.m2505o(95495);
        return c25560k;
    }

    /* renamed from: rb */
    public final void mo19158rb() {
        AppMethodBeat.m2504i(95496);
        this.bgQ = true;
        this.handler.post(this.bgL);
        AppMethodBeat.m2505o(95496);
    }

    /* renamed from: a */
    public final void mo19156a(C37247l c37247l) {
        AppMethodBeat.m2504i(95497);
        this.bgN = c37247l;
        this.handler.post(this.bgL);
        AppMethodBeat.m2505o(95497);
    }

    /* renamed from: sa */
    public final void mo32390sa() {
        AppMethodBeat.m2504i(95498);
        this.handler.post(this.bgL);
        AppMethodBeat.m2505o(95498);
    }

    /* renamed from: a */
    private void m72964a(C8713a c8713a) {
        if (this.bgY == -1) {
            this.bgY = c8713a.bgY;
        }
    }

    private void startLoading() {
        AppMethodBeat.m2504i(95499);
        C8713a c8713a = new C8713a(this.uri, this.aSF, this.bgJ, this.bgK);
        if (this.prepared) {
            C45039a.checkState(mo66762sd());
            if (this.aOz == -9223372036854775807L || this.bha < this.aOz) {
                c8713a.mo19286j(this.bgN.mo2548M(this.bha), this.bha);
                this.bha = -9223372036854775807L;
            } else {
                this.bhc = true;
                this.bha = -9223372036854775807L;
                AppMethodBeat.m2505o(95499);
                return;
            }
        }
        this.bhb = m72966sb();
        int i = this.bgC;
        if (i == -1) {
            i = (this.prepared && this.bgY == -1 && (this.bgN == null || this.bgN.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.bgI.mo66741a(c8713a, this, i);
        AppMethodBeat.m2505o(95499);
    }

    /* renamed from: aa */
    private boolean m72965aa(long j) {
        AppMethodBeat.m2504i(95500);
        int length = this.bgO.length;
        int i = 0;
        while (i < length) {
            C25560k c25560k = this.bgO[i];
            c25560k.rewind();
            if (c25560k.mo42837g(j, false) || (!this.bgW[i] && this.bgX)) {
                c25560k.mo42841sp();
                i++;
            } else {
                AppMethodBeat.m2505o(95500);
                return false;
            }
        }
        AppMethodBeat.m2505o(95500);
        return true;
    }

    /* renamed from: sb */
    private int m72966sb() {
        AppMethodBeat.m2504i(95501);
        C25560k[] c25560kArr = this.bgO;
        int i = 0;
        int i2 = 0;
        while (i < c25560kArr.length) {
            i++;
            i2 = c25560kArr[i].bhG.mo59538si() + i2;
        }
        AppMethodBeat.m2505o(95501);
        return i2;
    }

    /* renamed from: sc */
    private long m72967sc() {
        AppMethodBeat.m2504i(95502);
        long j = Long.MIN_VALUE;
        for (C25560k c25560k : this.bgO) {
            j = Math.max(j, c25560k.bhG.mo59537sc());
        }
        AppMethodBeat.m2505o(95502);
        return j;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: sd */
    public final boolean mo66762sd() {
        return this.bha != -9223372036854775807L;
    }
}
