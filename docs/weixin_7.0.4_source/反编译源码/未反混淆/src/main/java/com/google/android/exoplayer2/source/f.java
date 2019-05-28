package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

final class f implements g, com.google.android.exoplayer2.h.s.a<a>, com.google.android.exoplayer2.h.s.d, h, com.google.android.exoplayer2.source.k.b {
    long aOz;
    private final com.google.android.exoplayer2.h.f aSF;
    private final int bgC;
    final com.google.android.exoplayer2.source.g.a bgD;
    final c bgE;
    private final com.google.android.exoplayer2.h.b bgF;
    final String bgG;
    final long bgH;
    final s bgI = new s("Loader:ExtractorMediaPeriod");
    private final b bgJ;
    final e bgK;
    private final Runnable bgL;
    final Runnable bgM;
    l bgN;
    k[] bgO;
    private int[] bgP;
    boolean bgQ;
    private boolean bgR;
    boolean bgS;
    private int bgT;
    p bgU;
    boolean[] bgV;
    boolean[] bgW;
    boolean bgX;
    private long bgY;
    long bgZ;
    com.google.android.exoplayer2.source.h.a bgq;
    private long bha;
    private int bhb;
    boolean bhc;
    private final Handler eventHandler;
    final Handler handler;
    boolean prepared;
    boolean released;
    private final Uri uri;

    final class a implements com.google.android.exoplayer2.h.s.c {
        private final com.google.android.exoplayer2.h.f aSF;
        private final b bgJ;
        private final e bgK;
        long bgY = -1;
        private final k bhe = new k();
        private volatile boolean bhf;
        private boolean bhg = true;
        private long bhh;
        private final Uri uri;

        public a(Uri uri, com.google.android.exoplayer2.h.f fVar, b bVar, e eVar) {
            AppMethodBeat.i(95480);
            this.uri = (Uri) com.google.android.exoplayer2.i.a.checkNotNull(uri);
            this.aSF = (com.google.android.exoplayer2.h.f) com.google.android.exoplayer2.i.a.checkNotNull(fVar);
            this.bgJ = (b) com.google.android.exoplayer2.i.a.checkNotNull(bVar);
            this.bgK = eVar;
            AppMethodBeat.o(95480);
        }

        public final void j(long j, long j2) {
            this.bhe.position = j;
            this.bhh = j2;
            this.bhg = true;
        }

        public final void se() {
            this.bhf = true;
        }

        public final boolean sf() {
            return this.bhf;
        }

        public final void sg() {
            Throwable th;
            Object obj;
            com.google.android.exoplayer2.c.f obj2;
            AppMethodBeat.i(95481);
            int i = 0;
            while (i == 0 && !this.bhf) {
                int a;
                try {
                    long j = this.bhe.position;
                    this.bgY = this.aSF.a(new i(this.uri, j, -1, f.this.bgG));
                    if (this.bgY != -1) {
                        this.bgY += j;
                    }
                    com.google.android.exoplayer2.c.b bVar = new com.google.android.exoplayer2.c.b(this.aSF, j, this.bgY);
                    try {
                        int i2;
                        com.google.android.exoplayer2.c.e a2 = this.bgJ.a(bVar, this.aSF.getUri());
                        if (this.bhg) {
                            a2.g(j, this.bhh);
                            this.bhg = false;
                        }
                        int i3 = i;
                        while (i3 == 0) {
                            try {
                                if (this.bhf) {
                                    break;
                                }
                                this.bgK.block();
                                a = a2.a(bVar, this.bhe);
                                try {
                                    if (bVar.getPosition() > f.this.bgH + j) {
                                        j = bVar.getPosition();
                                        this.bgK.tw();
                                        f.this.handler.post(f.this.bgM);
                                        i3 = a;
                                    } else {
                                        i3 = a;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = bVar;
                                    this.bhe.position = obj2.getPosition();
                                    v.a(this.aSF);
                                    AppMethodBeat.o(95481);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj2 = bVar;
                                a = i3;
                                this.bhe.position = obj2.getPosition();
                                v.a(this.aSF);
                                AppMethodBeat.o(95481);
                                throw th;
                            }
                        }
                        if (i3 == 1) {
                            i2 = 0;
                        } else {
                            this.bhe.position = bVar.getPosition();
                            i2 = i3;
                        }
                        v.a(this.aSF);
                        i = i2;
                    } catch (Throwable th22) {
                        th = th22;
                        obj2 = bVar;
                        a = i;
                        this.bhe.position = obj2.getPosition();
                        v.a(this.aSF);
                        AppMethodBeat.o(95481);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj2 = null;
                    a = i;
                    if (!(a == 1 || obj2 == null)) {
                        this.bhe.position = obj2.getPosition();
                    }
                    v.a(this.aSF);
                    AppMethodBeat.o(95481);
                    throw th;
                }
            }
            AppMethodBeat.o(95481);
        }
    }

    static final class b {
        private final g aTn;
        private final com.google.android.exoplayer2.c.e[] bhi;
        com.google.android.exoplayer2.c.e bhj;

        public b(com.google.android.exoplayer2.c.e[] eVarArr, g gVar) {
            this.bhi = eVarArr;
            this.aTn = gVar;
        }

        public final com.google.android.exoplayer2.c.e a(com.google.android.exoplayer2.c.f fVar, Uri uri) {
            AppMethodBeat.i(95482);
            com.google.android.exoplayer2.c.e eVar;
            if (this.bhj != null) {
                eVar = this.bhj;
                AppMethodBeat.o(95482);
                return eVar;
            }
            com.google.android.exoplayer2.c.e[] eVarArr = this.bhi;
            int length = eVarArr.length;
            int i = 0;
            while (i < length) {
                com.google.android.exoplayer2.c.e eVar2 = eVarArr[i];
                try {
                    if (eVar2.a(fVar)) {
                        this.bhj = eVar2;
                        fVar.qY();
                        break;
                    }
                    fVar.qY();
                    i++;
                } catch (EOFException e) {
                    fVar.qY();
                } catch (Throwable th) {
                    fVar.qY();
                    AppMethodBeat.o(95482);
                }
            }
            if (this.bhj == null) {
                q qVar = new q("None of the available extractors (" + v.d(this.bhi) + ") could read the stream.", uri);
                AppMethodBeat.o(95482);
                throw qVar;
            }
            this.bhj.a(this.aTn);
            eVar = this.bhj;
            AppMethodBeat.o(95482);
            return eVar;
        }
    }

    interface c {
        void e(long j, boolean z);
    }

    final class d implements l {
        final int track;

        public d(int i) {
            this.track = i;
        }

        public final boolean isReady() {
            AppMethodBeat.i(95483);
            f fVar = f.this;
            int i = this.track;
            if (fVar.bhc || (!fVar.sd() && fVar.bgO[i].bhG.sk())) {
                AppMethodBeat.o(95483);
                return true;
            }
            AppMethodBeat.o(95483);
            return false;
        }

        public final void rW() {
        }

        public final int b(com.google.android.exoplayer2.k kVar, com.google.android.exoplayer2.b.e eVar, boolean z) {
            AppMethodBeat.i(95484);
            f fVar = f.this;
            int i = this.track;
            if (fVar.bgS || fVar.sd()) {
                AppMethodBeat.o(95484);
                return -3;
            }
            int a = fVar.bgO[i].a(kVar, eVar, z, fVar.bhc, fVar.bgZ);
            AppMethodBeat.o(95484);
            return a;
        }

        public final void Z(long j) {
            AppMethodBeat.i(95485);
            f fVar = f.this;
            k kVar = fVar.bgO[this.track];
            if (!fVar.bhc || j <= kVar.bhG.sc()) {
                kVar.g(j, true);
                AppMethodBeat.o(95485);
                return;
            }
            kVar.bhG.sm();
            AppMethodBeat.o(95485);
        }
    }

    public final /* synthetic */ void a(com.google.android.exoplayer2.h.s.c cVar, long j, long j2) {
        AppMethodBeat.i(95505);
        a((a) cVar);
        this.bhc = true;
        if (this.aOz == -9223372036854775807L) {
            long sc = sc();
            this.aOz = sc == Long.MIN_VALUE ? 0 : sc + 10000;
            this.bgE.e(this.aOz, this.bgN.qX());
        }
        this.bgq.a(this);
        AppMethodBeat.o(95505);
    }

    public f(Uri uri, com.google.android.exoplayer2.h.f fVar, com.google.android.exoplayer2.c.e[] eVarArr, int i, Handler handler, com.google.android.exoplayer2.source.g.a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, String str, int i2) {
        AppMethodBeat.i(95486);
        this.uri = uri;
        this.aSF = fVar;
        this.bgC = i;
        this.eventHandler = handler;
        this.bgD = aVar;
        this.bgE = cVar;
        this.bgF = bVar;
        this.bgG = str;
        this.bgH = (long) i2;
        this.bgJ = new b(eVarArr, this);
        this.bgK = new e();
        this.bgL = new Runnable() {
            public final void run() {
                AppMethodBeat.i(95477);
                f fVar = f.this;
                if (fVar.released || fVar.prepared || fVar.bgN == null || !fVar.bgQ) {
                    AppMethodBeat.o(95477);
                    return;
                }
                for (k kVar : fVar.bgO) {
                    if (kVar.bhG.sl() == null) {
                        break;
                    }
                }
                fVar.bgK.tw();
                int length = fVar.bgO.length;
                o[] oVarArr = new o[length];
                fVar.bgW = new boolean[length];
                fVar.bgV = new boolean[length];
                fVar.aOz = fVar.bgN.getDurationUs();
                for (int i = 0; i < length; i++) {
                    boolean z;
                    oVarArr[i] = new o(fVar.bgO[i].bhG.sl());
                    String str = r0.aOd;
                    if (com.google.android.exoplayer2.i.i.aI(str) || com.google.android.exoplayer2.i.i.aH(str)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar.bgW[i] = z;
                    fVar.bgX = z | fVar.bgX;
                }
                fVar.bgU = new p(oVarArr);
                fVar.prepared = true;
                fVar.bgE.e(fVar.aOz, fVar.bgN.qX());
                fVar.bgq.a(fVar);
                AppMethodBeat.o(95477);
            }
        };
        this.bgM = new Runnable() {
            public final void run() {
                AppMethodBeat.i(95478);
                if (!f.this.released) {
                    f.this.bgq.a(f.this);
                }
                AppMethodBeat.o(95478);
            }
        };
        this.handler = new Handler();
        this.bgP = new int[0];
        this.bgO = new k[0];
        this.bha = -9223372036854775807L;
        this.bgY = -1;
        AppMethodBeat.o(95486);
    }

    public final void rZ() {
        AppMethodBeat.i(95487);
        b bVar = this.bgJ;
        if (bVar.bhj != null) {
            bVar.bhj = null;
        }
        for (k reset : this.bgO) {
            reset.reset(false);
        }
        AppMethodBeat.o(95487);
    }

    public final void a(com.google.android.exoplayer2.source.h.a aVar, long j) {
        AppMethodBeat.i(95488);
        this.bgq = aVar;
        this.bgK.open();
        startLoading();
        AppMethodBeat.o(95488);
    }

    public final void rR() {
    }

    public final p rS() {
        return this.bgU;
    }

    public final long a(com.google.android.exoplayer2.g.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(95489);
        com.google.android.exoplayer2.i.a.checkState(this.prepared);
        int i3 = this.bgT;
        int i4 = 0;
        while (i4 < fVarArr.length) {
            if (lVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                i = ((d) lVarArr[i4]).track;
                com.google.android.exoplayer2.i.a.checkState(this.bgV[i]);
                this.bgT--;
                this.bgV[i] = false;
                lVarArr[i4] = null;
            }
            i4++;
        }
        boolean z2 = this.bgR ? i3 == 0 : j != 0;
        i3 = 0;
        while (true) {
            z = z2;
            if (i3 >= fVarArr.length) {
                break;
            }
            if (lVarArr[i3] == null && fVarArr[i3] != null) {
                com.google.android.exoplayer2.g.f fVar = fVarArr[i3];
                if (fVar.length() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.google.android.exoplayer2.i.a.checkState(z2);
                if (fVar.eH(0) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.google.android.exoplayer2.i.a.checkState(z2);
                int a = this.bgU.a(fVar.tf());
                if (this.bgV[a]) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                com.google.android.exoplayer2.i.a.checkState(z2);
                this.bgT++;
                this.bgV[a] = true;
                lVarArr[i3] = new d(a);
                zArr2[i3] = true;
                if (!z) {
                    k kVar = this.bgO[a];
                    kVar.rewind();
                    if (kVar.g(j, true) || kVar.bhG.sj() == 0) {
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
                k[] kVarArr = this.bgO;
                i4 = kVarArr.length;
                while (i2 < i4) {
                    kVarArr[i2].sq();
                    i2++;
                }
                this.bgI.cancelLoading();
            } else {
                for (k reset : this.bgO) {
                    reset.reset(false);
                }
            }
        } else if (z) {
            j = X(j);
            while (i2 < lVarArr.length) {
                if (lVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.bgR = true;
        AppMethodBeat.o(95489);
        return j;
    }

    public final void W(long j) {
        AppMethodBeat.i(95490);
        int length = this.bgO.length;
        for (int i = 0; i < length; i++) {
            this.bgO[i].i(j, this.bgV[i]);
        }
        AppMethodBeat.o(95490);
    }

    public final boolean Y(long j) {
        AppMethodBeat.i(95491);
        if (this.bhc || (this.prepared && this.bgT == 0)) {
            AppMethodBeat.o(95491);
            return false;
        }
        boolean open = this.bgK.open();
        if (!this.bgI.isLoading()) {
            startLoading();
            open = true;
        }
        AppMethodBeat.o(95491);
        return open;
    }

    public final long rV() {
        AppMethodBeat.i(95492);
        if (this.bgT == 0) {
            AppMethodBeat.o(95492);
            return Long.MIN_VALUE;
        }
        long rU = rU();
        AppMethodBeat.o(95492);
        return rU;
    }

    public final long rT() {
        if (!this.bgS) {
            return -9223372036854775807L;
        }
        this.bgS = false;
        return this.bgZ;
    }

    public final long rU() {
        AppMethodBeat.i(95493);
        long j;
        if (this.bhc) {
            AppMethodBeat.o(95493);
            return Long.MIN_VALUE;
        } else if (sd()) {
            j = this.bha;
            AppMethodBeat.o(95493);
            return j;
        } else {
            if (this.bgX) {
                j = Long.MAX_VALUE;
                int length = this.bgO.length;
                for (int i = 0; i < length; i++) {
                    if (this.bgW[i]) {
                        j = Math.min(j, this.bgO[i].bhG.sc());
                    }
                }
            } else {
                j = sc();
            }
            if (j == Long.MIN_VALUE) {
                j = this.bgZ;
                AppMethodBeat.o(95493);
                return j;
            }
            AppMethodBeat.o(95493);
            return j;
        }
    }

    public final long X(long j) {
        AppMethodBeat.i(95494);
        if (!this.bgN.qX()) {
            j = 0;
        }
        this.bgZ = j;
        this.bgS = false;
        if (sd() || !aa(j)) {
            this.bha = j;
            this.bhc = false;
            if (this.bgI.isLoading()) {
                this.bgI.cancelLoading();
            } else {
                for (k reset : this.bgO) {
                    reset.reset(false);
                }
            }
            AppMethodBeat.o(95494);
        } else {
            AppMethodBeat.o(95494);
        }
        return j;
    }

    public final m dM(int i) {
        AppMethodBeat.i(95495);
        int length = this.bgO.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.bgP[i2] == i) {
                m mVar = this.bgO[i2];
                AppMethodBeat.o(95495);
                return mVar;
            }
        }
        k kVar = new k(this.bgF);
        kVar.bhQ = this;
        this.bgP = Arrays.copyOf(this.bgP, length + 1);
        this.bgP[length] = i;
        this.bgO = (k[]) Arrays.copyOf(this.bgO, length + 1);
        this.bgO[length] = kVar;
        AppMethodBeat.o(95495);
        return kVar;
    }

    public final void rb() {
        AppMethodBeat.i(95496);
        this.bgQ = true;
        this.handler.post(this.bgL);
        AppMethodBeat.o(95496);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(95497);
        this.bgN = lVar;
        this.handler.post(this.bgL);
        AppMethodBeat.o(95497);
    }

    public final void sa() {
        AppMethodBeat.i(95498);
        this.handler.post(this.bgL);
        AppMethodBeat.o(95498);
    }

    private void a(a aVar) {
        if (this.bgY == -1) {
            this.bgY = aVar.bgY;
        }
    }

    private void startLoading() {
        AppMethodBeat.i(95499);
        a aVar = new a(this.uri, this.aSF, this.bgJ, this.bgK);
        if (this.prepared) {
            com.google.android.exoplayer2.i.a.checkState(sd());
            if (this.aOz == -9223372036854775807L || this.bha < this.aOz) {
                aVar.j(this.bgN.M(this.bha), this.bha);
                this.bha = -9223372036854775807L;
            } else {
                this.bhc = true;
                this.bha = -9223372036854775807L;
                AppMethodBeat.o(95499);
                return;
            }
        }
        this.bhb = sb();
        int i = this.bgC;
        if (i == -1) {
            i = (this.prepared && this.bgY == -1 && (this.bgN == null || this.bgN.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.bgI.a(aVar, this, i);
        AppMethodBeat.o(95499);
    }

    private boolean aa(long j) {
        AppMethodBeat.i(95500);
        int length = this.bgO.length;
        int i = 0;
        while (i < length) {
            k kVar = this.bgO[i];
            kVar.rewind();
            if (kVar.g(j, false) || (!this.bgW[i] && this.bgX)) {
                kVar.sp();
                i++;
            } else {
                AppMethodBeat.o(95500);
                return false;
            }
        }
        AppMethodBeat.o(95500);
        return true;
    }

    private int sb() {
        AppMethodBeat.i(95501);
        k[] kVarArr = this.bgO;
        int i = 0;
        int i2 = 0;
        while (i < kVarArr.length) {
            i++;
            i2 = kVarArr[i].bhG.si() + i2;
        }
        AppMethodBeat.o(95501);
        return i2;
    }

    private long sc() {
        AppMethodBeat.i(95502);
        long j = Long.MIN_VALUE;
        for (k kVar : this.bgO) {
            j = Math.max(j, kVar.bhG.sc());
        }
        AppMethodBeat.o(95502);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final boolean sd() {
        return this.bha != -9223372036854775807L;
    }
}
