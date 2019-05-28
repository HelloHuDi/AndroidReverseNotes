package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.d;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j implements g, com.google.android.exoplayer2.h.s.a<com.google.android.exoplayer2.source.a.a>, d, b, m {
    final int aMr;
    p aNe;
    private final int bgC;
    private final com.google.android.exoplayer2.h.b bgF;
    final s bgI = new s("Loader:HlsSampleStreamWrapper");
    private final Runnable bgL = new Runnable() {
        public final void run() {
            AppMethodBeat.i(125941);
            j.this.sB();
            AppMethodBeat.o(125941);
        }
    };
    k[] bgO = new k[0];
    private int[] bgP = new int[0];
    boolean bgQ;
    boolean bgR;
    int bgT;
    long bgZ;
    private long bha;
    boolean bhc;
    final com.google.android.exoplayer2.source.a.a bjc;
    private final a bjn;
    final c bjo;
    private final Format bjp;
    private final c.b bjq = new c.b();
    final LinkedList<f> bjr = new LinkedList();
    Format bjs;
    int bjt;
    int bju;
    private boolean bjv;
    boolean[] bjw;
    private boolean[] bjx;
    boolean bjy;
    final Handler handler = new Handler();
    boolean prepared;
    boolean released;

    public interface a extends com.google.android.exoplayer2.source.m.a<j> {
        void a(com.google.android.exoplayer2.source.b.a.a.a aVar);

        void pL();
    }

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        AppMethodBeat.i(125960);
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        c cVar2 = this.bjo;
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            cVar2.biv = aVar2.data;
            cVar2.a(aVar2.bib.uri, aVar2.biC, aVar2.result);
        }
        this.bjc.a(aVar.bib, aVar.type, this.aMr, aVar.bic, aVar.bid, aVar.bie, aVar.bif, aVar.big, j, j2, aVar.ss());
        if (this.prepared) {
            this.bjn.a(this);
            AppMethodBeat.o(125960);
            return;
        }
        Y(this.bgZ);
        AppMethodBeat.o(125960);
    }

    public final /* synthetic */ com.google.android.exoplayer2.c.m dM(int i) {
        AppMethodBeat.i(125961);
        k es = es(i);
        AppMethodBeat.o(125961);
        return es;
    }

    public j(int i, a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, long j, Format format, int i2, com.google.android.exoplayer2.source.a.a aVar2) {
        AppMethodBeat.i(125942);
        this.aMr = i;
        this.bjn = aVar;
        this.bjo = cVar;
        this.bgF = bVar;
        this.bjp = format;
        this.bgC = i2;
        this.bjc = aVar2;
        this.bgZ = j;
        this.bha = j;
        AppMethodBeat.o(125942);
    }

    public final void sz() {
        AppMethodBeat.i(125943);
        if (!this.prepared) {
            Y(this.bgZ);
        }
        AppMethodBeat.o(125943);
    }

    public final boolean j(long j, boolean z) {
        AppMethodBeat.i(125944);
        this.bgZ = j;
        if (z || sd() || !aa(j)) {
            this.bha = j;
            this.bhc = false;
            this.bjr.clear();
            if (this.bgI.isLoading()) {
                this.bgI.cancelLoading();
            } else {
                sA();
            }
            AppMethodBeat.o(125944);
            return true;
        }
        AppMethodBeat.o(125944);
        return false;
    }

    public final long rU() {
        AppMethodBeat.i(125945);
        long j;
        if (this.bhc) {
            AppMethodBeat.o(125945);
            return Long.MIN_VALUE;
        } else if (sd()) {
            j = this.bha;
            AppMethodBeat.o(125945);
            return j;
        } else {
            long j2 = this.bgZ;
            f fVar = (f) this.bjr.getLast();
            if (!fVar.bja) {
                fVar = this.bjr.size() > 1 ? (f) this.bjr.get(this.bjr.size() - 2) : null;
            }
            if (fVar != null) {
                j = Math.max(j2, fVar.big);
            } else {
                j = j2;
            }
            for (k kVar : this.bgO) {
                j = Math.max(j, kVar.bhG.sc());
            }
            AppMethodBeat.o(125945);
            return j;
        }
    }

    public final void rZ() {
        AppMethodBeat.i(125946);
        sA();
        AppMethodBeat.o(125946);
    }

    public final void aJ(boolean z) {
        this.bjo.biu = z;
    }

    /* Access modifiers changed, original: final */
    public final void sA() {
        AppMethodBeat.i(125947);
        for (k reset : this.bgO) {
            reset.reset(this.bjy);
        }
        this.bjy = false;
        AppMethodBeat.o(125947);
    }

    public final boolean Y(long j) {
        AppMethodBeat.i(125948);
        if (this.bhc || this.bgI.isLoading()) {
            AppMethodBeat.o(125948);
            return false;
        }
        f fVar;
        c cVar = this.bjo;
        if (this.bjr.isEmpty()) {
            fVar = null;
        } else {
            fVar = (f) this.bjr.getLast();
        }
        if (this.bha != -9223372036854775807L) {
            j = this.bha;
        }
        cVar.a(fVar, j, this.bjq);
        boolean z = this.bjq.biE;
        com.google.android.exoplayer2.source.a.a aVar = this.bjq.biD;
        com.google.android.exoplayer2.source.b.a.a.a aVar2 = this.bjq.biF;
        this.bjq.clear();
        if (z) {
            this.bha = -9223372036854775807L;
            this.bhc = true;
            AppMethodBeat.o(125948);
            return true;
        } else if (aVar == null) {
            if (aVar2 != null) {
                this.bjn.a(aVar2);
            }
            AppMethodBeat.o(125948);
            return false;
        } else {
            if (aVar instanceof f) {
                this.bha = -9223372036854775807L;
                fVar = (f) aVar;
                fVar.a(this);
                this.bjr.add(fVar);
            }
            this.bjc.a(aVar.bib, aVar.type, this.aMr, aVar.bic, aVar.bid, aVar.bie, aVar.bif, aVar.big, this.bgI.a(aVar, this, this.bgC));
            AppMethodBeat.o(125948);
            return true;
        }
    }

    public final long rV() {
        AppMethodBeat.i(125949);
        long j;
        if (sd()) {
            j = this.bha;
            AppMethodBeat.o(125949);
            return j;
        } else if (this.bhc) {
            AppMethodBeat.o(125949);
            return Long.MIN_VALUE;
        } else {
            j = ((f) this.bjr.getLast()).big;
            AppMethodBeat.o(125949);
            return j;
        }
    }

    public final k es(int i) {
        AppMethodBeat.i(125950);
        int length = this.bgO.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.bgP[i2] == i) {
                k kVar = this.bgO[i2];
                AppMethodBeat.o(125950);
                return kVar;
            }
        }
        k kVar2 = new k(this.bgF);
        kVar2.bhQ = this;
        this.bgP = Arrays.copyOf(this.bgP, length + 1);
        this.bgP[length] = i;
        this.bgO = (k[]) Arrays.copyOf(this.bgO, length + 1);
        this.bgO[length] = kVar2;
        AppMethodBeat.o(125950);
        return kVar2;
    }

    public final void rb() {
        AppMethodBeat.i(125951);
        this.bgQ = true;
        this.handler.post(this.bgL);
        AppMethodBeat.o(125951);
    }

    public final void a(l lVar) {
    }

    public final void sa() {
        AppMethodBeat.i(125952);
        this.handler.post(this.bgL);
        AppMethodBeat.o(125952);
    }

    /* Access modifiers changed, original: final */
    public final void sB() {
        AppMethodBeat.i(125953);
        if (this.released || this.prepared || !this.bgQ) {
            AppMethodBeat.o(125953);
            return;
        }
        int i;
        for (k kVar : this.bgO) {
            if (kVar.bhG.sl() == null) {
                AppMethodBeat.o(125953);
                return;
            }
        }
        int length = this.bgO.length;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i2 < length) {
            String str = this.bgO[i2].bhG.sl().aOd;
            if (i.aI(str)) {
                i = 3;
            } else if (i.aH(str)) {
                i = 2;
            } else if (i.aJ(str)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i > i4) {
                i3 = i2;
            } else if (i != i4 || i3 == -1) {
                i = i4;
            } else {
                i3 = -1;
                i = i4;
            }
            i2++;
            i4 = i;
        }
        o oVar = this.bjo.bis;
        int i5 = oVar.length;
        this.bju = -1;
        this.bjw = new boolean[length];
        this.bjx = new boolean[length];
        o[] oVarArr = new o[length];
        for (int i6 = 0; i6 < length; i6++) {
            Format sl = this.bgO[i6].bhG.sl();
            String str2 = sl.aOd;
            boolean z = i.aI(str2) || i.aH(str2);
            this.bjx[i6] = z;
            this.bjv = z | this.bjv;
            if (i6 == i3) {
                Format[] formatArr = new Format[i5];
                for (i2 = 0; i2 < i5; i2++) {
                    formatArr[i2] = a(oVar.bhv[i2], sl);
                }
                oVarArr[i6] = new o(formatArr);
                this.bju = i6;
            } else {
                Format format = (i4 == 3 && i.aH(sl.aOd)) ? this.bjp : null;
                oVarArr[i6] = new o(a(format, sl));
            }
        }
        this.aNe = new p(oVarArr);
        this.prepared = true;
        this.bjn.pL();
        AppMethodBeat.o(125953);
    }

    /* Access modifiers changed, original: final */
    public final void r(int i, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(125954);
        com.google.android.exoplayer2.i.a.checkState(this.bjw[i] != z);
        this.bjw[i] = z;
        int i3 = this.bgT;
        if (!z) {
            i2 = -1;
        }
        this.bgT = i3 + i2;
        AppMethodBeat.o(125954);
    }

    private static Format a(Format format, Format format2) {
        AppMethodBeat.i(125955);
        if (format == null) {
            AppMethodBeat.o(125955);
            return format2;
        }
        String str = null;
        int aL = i.aL(format2.aOd);
        if (aL == 1) {
            str = j(format.aOa, 1);
        } else if (aL == 2) {
            str = j(format.aOa, 2);
        }
        format2 = format2.a(format.id, str, format.bitrate, format.width, format.height, format.aOs, format.aOt);
        AppMethodBeat.o(125955);
        return format2;
    }

    /* Access modifiers changed, original: final */
    public final boolean sd() {
        return this.bha != -9223372036854775807L;
    }

    private boolean aa(long j) {
        AppMethodBeat.i(125956);
        int length = this.bgO.length;
        int i = 0;
        while (i < length) {
            k kVar = this.bgO[i];
            kVar.rewind();
            if (kVar.g(j, false) || (!this.bjx[i] && this.bjv)) {
                kVar.sp();
                i++;
            } else {
                AppMethodBeat.o(125956);
                return false;
            }
        }
        AppMethodBeat.o(125956);
        return true;
    }

    private static String j(String str, int i) {
        AppMethodBeat.i(125957);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(125957);
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (i == i.aL(i.aK(str2))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > 0) {
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(125957);
            return stringBuilder2;
        }
        AppMethodBeat.o(125957);
        return null;
    }
}
