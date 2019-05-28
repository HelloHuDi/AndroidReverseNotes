package com.google.android.exoplayer2.source.p112b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p110h.C41613s;
import com.google.android.exoplayer2.p110h.C41613s.C32059c;
import com.google.android.exoplayer2.p110h.C41613s.C32060d;
import com.google.android.exoplayer2.p110h.C41613s.C8683a;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C17689m;
import com.google.android.exoplayer2.source.C17689m.C17690a;
import com.google.android.exoplayer2.source.C25560k;
import com.google.android.exoplayer2.source.C25560k.C17687b;
import com.google.android.exoplayer2.source.C37271a.C8705a;
import com.google.android.exoplayer2.source.C41630o;
import com.google.android.exoplayer2.source.C41631p;
import com.google.android.exoplayer2.source.p112b.C37275c.C0880a;
import com.google.android.exoplayer2.source.p112b.C37275c.C32072b;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p1520a.C41622a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

/* renamed from: com.google.android.exoplayer2.source.b.j */
final class C41626j implements C8662g, C8683a<C41622a>, C32060d, C17687b, C17689m {
    final int aMr;
    C41631p aNe;
    private final int bgC;
    private final C32053b bgF;
    final C41613s bgI = new C41613s("Loader:HlsSampleStreamWrapper");
    private final Runnable bgL = new C255571();
    C25560k[] bgO = new C25560k[0];
    private int[] bgP = new int[0];
    boolean bgQ;
    boolean bgR;
    int bgT;
    long bgZ;
    private long bha;
    boolean bhc;
    final C8705a bjc;
    private final C41627a bjn;
    final C37275c bjo;
    private final Format bjp;
    private final C32072b bjq = new C32072b();
    final LinkedList<C25556f> bjr = new LinkedList();
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

    /* renamed from: com.google.android.exoplayer2.source.b.j$1 */
    class C255571 implements Runnable {
        C255571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125941);
            C41626j.this.mo66759sB();
            AppMethodBeat.m2505o(125941);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.b.j$a */
    public interface C41627a extends C17690a<C41626j> {
        /* renamed from: a */
        void mo19277a(C25552a c25552a);

        /* renamed from: pL */
        void mo19280pL();
    }

    /* renamed from: a */
    public final /* synthetic */ void mo2604a(C32059c c32059c, long j, long j2) {
        AppMethodBeat.m2504i(125960);
        C41622a c41622a = (C41622a) c32059c;
        C37275c c37275c = this.bjo;
        if (c41622a instanceof C0880a) {
            C0880a c0880a = (C0880a) c41622a;
            c37275c.biv = c0880a.data;
            c37275c.mo59518a(c0880a.bib.uri, c0880a.biC, c0880a.result);
        }
        this.bjc.mo19261a(c41622a.bib, c41622a.type, this.aMr, c41622a.bic, c41622a.bid, c41622a.bie, c41622a.bif, c41622a.big, j, j2, c41622a.mo42818ss());
        if (this.prepared) {
            this.bjn.mo19279a(this);
            AppMethodBeat.m2505o(125960);
            return;
        }
        mo19275Y(this.bgZ);
        AppMethodBeat.m2505o(125960);
    }

    /* renamed from: dM */
    public final /* synthetic */ C32041m mo19157dM(int i) {
        AppMethodBeat.m2504i(125961);
        C25560k es = mo66755es(i);
        AppMethodBeat.m2505o(125961);
        return es;
    }

    public C41626j(int i, C41627a c41627a, C37275c c37275c, C32053b c32053b, long j, Format format, int i2, C8705a c8705a) {
        AppMethodBeat.m2504i(125942);
        this.aMr = i;
        this.bjn = c41627a;
        this.bjo = c37275c;
        this.bgF = c32053b;
        this.bjp = format;
        this.bgC = i2;
        this.bjc = c8705a;
        this.bgZ = j;
        this.bha = j;
        AppMethodBeat.m2505o(125942);
    }

    /* renamed from: sz */
    public final void mo66761sz() {
        AppMethodBeat.m2504i(125943);
        if (!this.prepared) {
            mo19275Y(this.bgZ);
        }
        AppMethodBeat.m2505o(125943);
    }

    /* renamed from: j */
    public final boolean mo66756j(long j, boolean z) {
        AppMethodBeat.m2504i(125944);
        this.bgZ = j;
        if (z || mo66760sd() || !m72941aa(j)) {
            this.bha = j;
            this.bhc = false;
            this.bjr.clear();
            if (this.bgI.isLoading()) {
                this.bgI.cancelLoading();
            } else {
                mo66758sA();
            }
            AppMethodBeat.m2505o(125944);
            return true;
        }
        AppMethodBeat.m2505o(125944);
        return false;
    }

    /* renamed from: rU */
    public final long mo19284rU() {
        AppMethodBeat.m2504i(125945);
        long j;
        if (this.bhc) {
            AppMethodBeat.m2505o(125945);
            return Long.MIN_VALUE;
        } else if (mo66760sd()) {
            j = this.bha;
            AppMethodBeat.m2505o(125945);
            return j;
        } else {
            long j2 = this.bgZ;
            C25556f c25556f = (C25556f) this.bjr.getLast();
            if (!c25556f.bja) {
                c25556f = this.bjr.size() > 1 ? (C25556f) this.bjr.get(this.bjr.size() - 2) : null;
            }
            if (c25556f != null) {
                j = Math.max(j2, c25556f.big);
            } else {
                j = j2;
            }
            for (C25560k c25560k : this.bgO) {
                j = Math.max(j, c25560k.bhG.mo59537sc());
            }
            AppMethodBeat.m2505o(125945);
            return j;
        }
    }

    /* renamed from: rZ */
    public final void mo52350rZ() {
        AppMethodBeat.m2504i(125946);
        mo66758sA();
        AppMethodBeat.m2505o(125946);
    }

    /* renamed from: aJ */
    public final void mo66754aJ(boolean z) {
        this.bjo.biu = z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: sA */
    public final void mo66758sA() {
        AppMethodBeat.m2504i(125947);
        for (C25560k reset : this.bgO) {
            reset.reset(this.bjy);
        }
        this.bjy = false;
        AppMethodBeat.m2505o(125947);
    }

    /* renamed from: Y */
    public final boolean mo19275Y(long j) {
        AppMethodBeat.m2504i(125948);
        if (this.bhc || this.bgI.isLoading()) {
            AppMethodBeat.m2505o(125948);
            return false;
        }
        C25556f c25556f;
        C37275c c37275c = this.bjo;
        if (this.bjr.isEmpty()) {
            c25556f = null;
        } else {
            c25556f = (C25556f) this.bjr.getLast();
        }
        if (this.bha != -9223372036854775807L) {
            j = this.bha;
        }
        c37275c.mo59519a(c25556f, j, this.bjq);
        boolean z = this.bjq.biE;
        C41622a c41622a = this.bjq.biD;
        C25552a c25552a = this.bjq.biF;
        this.bjq.clear();
        if (z) {
            this.bha = -9223372036854775807L;
            this.bhc = true;
            AppMethodBeat.m2505o(125948);
            return true;
        } else if (c41622a == null) {
            if (c25552a != null) {
                this.bjn.mo19277a(c25552a);
            }
            AppMethodBeat.m2505o(125948);
            return false;
        } else {
            if (c41622a instanceof C25556f) {
                this.bha = -9223372036854775807L;
                c25556f = (C25556f) c41622a;
                c25556f.mo42817a(this);
                this.bjr.add(c25556f);
            }
            this.bjc.mo19260a(c41622a.bib, c41622a.type, this.aMr, c41622a.bic, c41622a.bid, c41622a.bie, c41622a.bif, c41622a.big, this.bgI.mo66741a(c41622a, this, this.bgC));
            AppMethodBeat.m2505o(125948);
            return true;
        }
    }

    /* renamed from: rV */
    public final long mo19285rV() {
        AppMethodBeat.m2504i(125949);
        long j;
        if (mo66760sd()) {
            j = this.bha;
            AppMethodBeat.m2505o(125949);
            return j;
        } else if (this.bhc) {
            AppMethodBeat.m2505o(125949);
            return Long.MIN_VALUE;
        } else {
            j = ((C25556f) this.bjr.getLast()).big;
            AppMethodBeat.m2505o(125949);
            return j;
        }
    }

    /* renamed from: es */
    public final C25560k mo66755es(int i) {
        AppMethodBeat.m2504i(125950);
        int length = this.bgO.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.bgP[i2] == i) {
                C25560k c25560k = this.bgO[i2];
                AppMethodBeat.m2505o(125950);
                return c25560k;
            }
        }
        C25560k c25560k2 = new C25560k(this.bgF);
        c25560k2.bhQ = this;
        this.bgP = Arrays.copyOf(this.bgP, length + 1);
        this.bgP[length] = i;
        this.bgO = (C25560k[]) Arrays.copyOf(this.bgO, length + 1);
        this.bgO[length] = c25560k2;
        AppMethodBeat.m2505o(125950);
        return c25560k2;
    }

    /* renamed from: rb */
    public final void mo19158rb() {
        AppMethodBeat.m2504i(125951);
        this.bgQ = true;
        this.handler.post(this.bgL);
        AppMethodBeat.m2505o(125951);
    }

    /* renamed from: a */
    public final void mo19156a(C37247l c37247l) {
    }

    /* renamed from: sa */
    public final void mo32390sa() {
        AppMethodBeat.m2504i(125952);
        this.handler.post(this.bgL);
        AppMethodBeat.m2505o(125952);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: sB */
    public final void mo66759sB() {
        AppMethodBeat.m2504i(125953);
        if (this.released || this.prepared || !this.bgQ) {
            AppMethodBeat.m2505o(125953);
            return;
        }
        int i;
        for (C25560k c25560k : this.bgO) {
            if (c25560k.bhG.mo59541sl() == null) {
                AppMethodBeat.m2505o(125953);
                return;
            }
        }
        int length = this.bgO.length;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i2 < length) {
            String str = this.bgO[i2].bhG.mo59541sl().aOd;
            if (C37265i.m62523aI(str)) {
                i = 3;
            } else if (C37265i.m62522aH(str)) {
                i = 2;
            } else if (C37265i.m62524aJ(str)) {
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
        C41630o c41630o = this.bjo.bis;
        int i5 = c41630o.length;
        this.bju = -1;
        this.bjw = new boolean[length];
        this.bjx = new boolean[length];
        C41630o[] c41630oArr = new C41630o[length];
        for (int i6 = 0; i6 < length; i6++) {
            Format sl = this.bgO[i6].bhG.mo59541sl();
            String str2 = sl.aOd;
            boolean z = C37265i.m62523aI(str2) || C37265i.m62522aH(str2);
            this.bjx[i6] = z;
            this.bjv = z | this.bjv;
            if (i6 == i3) {
                Format[] formatArr = new Format[i5];
                for (i2 = 0; i2 < i5; i2++) {
                    formatArr[i2] = C41626j.m72940a(c41630o.bhv[i2], sl);
                }
                c41630oArr[i6] = new C41630o(formatArr);
                this.bju = i6;
            } else {
                Format format = (i4 == 3 && C37265i.m62522aH(sl.aOd)) ? this.bjp : null;
                c41630oArr[i6] = new C41630o(C41626j.m72940a(format, sl));
            }
        }
        this.aNe = new C41631p(c41630oArr);
        this.prepared = true;
        this.bjn.mo19280pL();
        AppMethodBeat.m2505o(125953);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final void mo66757r(int i, boolean z) {
        int i2 = 1;
        AppMethodBeat.m2504i(125954);
        C45039a.checkState(this.bjw[i] != z);
        this.bjw[i] = z;
        int i3 = this.bgT;
        if (!z) {
            i2 = -1;
        }
        this.bgT = i3 + i2;
        AppMethodBeat.m2505o(125954);
    }

    /* renamed from: a */
    private static Format m72940a(Format format, Format format2) {
        AppMethodBeat.m2504i(125955);
        if (format == null) {
            AppMethodBeat.m2505o(125955);
            return format2;
        }
        String str = null;
        int aL = C37265i.m62526aL(format2.aOd);
        if (aL == 1) {
            str = C41626j.m72942j(format.aOa, 1);
        } else if (aL == 2) {
            str = C41626j.m72942j(format.aOa, 2);
        }
        format2 = format2.mo19114a(format.f2431id, str, format.bitrate, format.width, format.height, format.aOs, format.aOt);
        AppMethodBeat.m2505o(125955);
        return format2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: sd */
    public final boolean mo66760sd() {
        return this.bha != -9223372036854775807L;
    }

    /* renamed from: aa */
    private boolean m72941aa(long j) {
        AppMethodBeat.m2504i(125956);
        int length = this.bgO.length;
        int i = 0;
        while (i < length) {
            C25560k c25560k = this.bgO[i];
            c25560k.rewind();
            if (c25560k.mo42837g(j, false) || (!this.bjx[i] && this.bjv)) {
                c25560k.mo42841sp();
                i++;
            } else {
                AppMethodBeat.m2505o(125956);
                return false;
            }
        }
        AppMethodBeat.m2505o(125956);
        return true;
    }

    /* renamed from: j */
    private static String m72942j(String str, int i) {
        AppMethodBeat.m2504i(125957);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(125957);
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (i == C37265i.m62526aL(C37265i.m62525aK(str2))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > 0) {
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(125957);
            return stringBuilder2;
        }
        AppMethodBeat.m2505o(125957);
        return null;
    }
}
