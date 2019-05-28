package com.google.android.exoplayer2.source.p112b.p113a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C41613s;
import com.google.android.exoplayer2.p110h.C41613s.C32059c;
import com.google.android.exoplayer2.p110h.C41613s.C8683a;
import com.google.android.exoplayer2.p110h.C41614t;
import com.google.android.exoplayer2.p110h.C41614t.C37263a;
import com.google.android.exoplayer2.p111i.C25544u;
import com.google.android.exoplayer2.source.C37271a.C8705a;
import com.google.android.exoplayer2.source.p112b.C25555d;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b.C37273a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.a.e */
public final class C45049e implements C8683a<C41614t<C45047c>> {
    public C25553a biH;
    public final C25555d bjb;
    final C8705a bjc;
    public final C37263a<C45047c> bjk;
    public final Uri bkA;
    public final int bkB;
    public final IdentityHashMap<C25552a, C0878a> bkC = new IdentityHashMap();
    public final Handler bkD = new Handler();
    final C32071e bkE;
    public final List<C0879b> bkF = new ArrayList();
    public final C41613s bkG = new C41613s("HlsPlaylistTracker:MasterPlaylist");
    public C25552a bkH;
    C37272b bkI;
    public boolean bkJ;

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$a */
    public final class C0878a implements C8683a<C41614t<C45047c>>, Runnable {
        private final C25552a bkK;
        public final C41613s bkL = new C41613s("HlsPlaylistTracker:MediaPlaylist");
        private final C41614t<C45047c> bkM;
        public C37272b bkN;
        public long bkO;
        private long bkP;
        private long bkQ;
        private long bkR;
        private boolean bkS;
        private IOException bkT;

        /* renamed from: a */
        static /* synthetic */ void m1979a(C0878a c0878a, C37272b c37272b) {
            AppMethodBeat.m2504i(125989);
            c0878a.m1981b(c37272b);
            AppMethodBeat.m2505o(125989);
        }

        /* renamed from: a */
        public final /* synthetic */ void mo2604a(C32059c c32059c, long j, long j2) {
            AppMethodBeat.m2504i(125988);
            C41614t c41614t = (C41614t) c32059c;
            C45047c c45047c = (C45047c) c41614t.result;
            if (c45047c instanceof C37272b) {
                m1981b((C37272b) c45047c);
                if (((C37272b) c45047c).bjP) {
                    C45049e.this.bjc.mo19267rQ();
                }
                C45049e.this.bjc.mo19263a(c41614t.bib, j, j2, c41614t.bqW);
                AppMethodBeat.m2505o(125988);
                return;
            }
            this.bkT = new C37269o("Loaded playlist has unexpected type.");
            AppMethodBeat.m2505o(125988);
        }

        public C0878a(C25552a c25552a) {
            AppMethodBeat.m2504i(125980);
            this.bkK = c25552a;
            this.bkM = new C41614t(C45049e.this.bjb.mo42816st(), C25544u.m40382m(C45049e.this.biH.bjZ, c25552a.url), C45049e.this.bjk);
            AppMethodBeat.m2505o(125980);
        }

        /* renamed from: sD */
        public final void mo2607sD() {
            AppMethodBeat.m2504i(125981);
            this.bkR = 0;
            if (this.bkS || this.bkL.isLoading()) {
                AppMethodBeat.m2505o(125981);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.bkQ) {
                this.bkS = true;
                C45049e.this.bkD.postDelayed(this, this.bkQ - elapsedRealtime);
                AppMethodBeat.m2505o(125981);
                return;
            }
            m1982sE();
            AppMethodBeat.m2505o(125981);
        }

        public final void run() {
            AppMethodBeat.m2504i(125982);
            this.bkS = false;
            m1982sE();
            AppMethodBeat.m2505o(125982);
        }

        /* renamed from: sE */
        private void m1982sE() {
            AppMethodBeat.m2504i(125983);
            this.bkL.mo66741a(this.bkM, this, C45049e.this.bkB);
            AppMethodBeat.m2505o(125983);
        }

        /* renamed from: b */
        private void m1981b(C37272b c37272b) {
            Object obj;
            int size;
            C37272b c37272b2;
            AppMethodBeat.m2504i(125984);
            C37272b c37272b3 = this.bkN;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bkO = elapsedRealtime;
            C45049e c45049e = C45049e.this;
            if (c37272b3 == null || c37272b.bjM > c37272b3.bjM) {
                obj = 1;
            } else {
                if (c37272b.bjM >= c37272b3.bjM) {
                    size = c37272b.bjS.size();
                    int size2 = c37272b3.bjS.size();
                    if (size > size2 || (size == size2 && c37272b.bjP && !c37272b3.bjP)) {
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                c37272b2 = c37272b.bjP ? c37272b3.bjP ? c37272b3 : new C37272b(c37272b3.bjI, c37272b3.bjZ, c37272b3.bka, c37272b3.bjJ, c37272b3.bif, c37272b3.bjK, c37272b3.bjL, c37272b3.bjM, c37272b3.version, c37272b3.bjN, c37272b3.bjO, true, c37272b3.bjQ, c37272b3.bjR, c37272b3.bjS) : c37272b3;
            } else {
                long j;
                int i;
                if (c37272b.bjQ) {
                    j = c37272b.bif;
                } else {
                    j = c45049e.bkI != null ? c45049e.bkI.bif : 0;
                    if (c37272b3 != null) {
                        size = c37272b3.bjS.size();
                        C37273a a = C45049e.m82620a(c37272b3, c37272b);
                        if (a != null) {
                            j = c37272b3.bif + a.bjU;
                        } else if (size == c37272b.bjM - c37272b3.bjM) {
                            j = c37272b3.mo59516sC();
                        }
                    }
                }
                if (c37272b.bjK) {
                    i = c37272b.bjL;
                } else {
                    i = c45049e.bkI != null ? c45049e.bkI.bjL : 0;
                    if (c37272b3 != null) {
                        C37273a a2 = C45049e.m82620a(c37272b3, c37272b);
                        if (a2 != null) {
                            i = (c37272b3.bjL + a2.bjT) - ((C37273a) c37272b.bjS.get(0)).bjT;
                        }
                    }
                }
                c37272b2 = new C37272b(c37272b.bjI, c37272b.bjZ, c37272b.bka, c37272b.bjJ, j, true, i, c37272b.bjM, c37272b.version, c37272b.bjN, c37272b.bjO, c37272b.bjP, c37272b.bjQ, c37272b.bjR, c37272b.bjS);
            }
            this.bkN = c37272b2;
            if (this.bkN != c37272b3) {
                this.bkT = null;
                this.bkP = elapsedRealtime;
                C45049e c45049e2 = C45049e.this;
                C25552a c25552a = this.bkK;
                C37272b c37272b4 = this.bkN;
                if (c25552a == c45049e2.bkH) {
                    if (c45049e2.bkI == null) {
                        c45049e2.bkJ = !c37272b4.bjP;
                    }
                    c45049e2.bkI = c37272b4;
                    c45049e2.bkE.mo52415a(c37272b4);
                }
                int size3 = c45049e2.bkF.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    ((C0879b) c45049e2.bkF.get(i2)).mo2609sx();
                }
            } else if (!this.bkN.bjP) {
                if (c37272b.bjM + c37272b.bjS.size() < this.bkN.bjM) {
                    this.bkT = new C45048c(this.bkK.url, (byte) 0);
                } else if (((double) (elapsedRealtime - this.bkP)) > ((double) C17628b.m27433w(this.bkN.bjN)) * 3.5d) {
                    this.bkT = new C32070d(this.bkK.url, (byte) 0);
                    m1983sF();
                }
            }
            this.bkQ = C17628b.m27433w(this.bkN != c37272b3 ? this.bkN.bjN : this.bkN.bjN / 2) + elapsedRealtime;
            if (this.bkK == C45049e.this.bkH && !this.bkN.bjP) {
                mo2607sD();
            }
            AppMethodBeat.m2505o(125984);
        }

        /* renamed from: sF */
        private boolean m1983sF() {
            AppMethodBeat.m2504i(125985);
            this.bkR = SystemClock.elapsedRealtime() + 60000;
            C45049e.m82621a(C45049e.this, this.bkK);
            if (C45049e.this.bkH != this.bkK || C45049e.m82622a(C45049e.this)) {
                AppMethodBeat.m2505o(125985);
                return false;
            }
            AppMethodBeat.m2505o(125985);
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$b */
    public interface C0879b {
        /* renamed from: b */
        void mo2608b(C25552a c25552a);

        /* renamed from: sx */
        void mo2609sx();
    }

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$d */
    public static final class C32070d extends IOException {
        public final String url;

        /* synthetic */ C32070d(String str, byte b) {
            this(str);
        }

        private C32070d(String str) {
            this.url = str;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$e */
    public interface C32071e {
        /* renamed from: a */
        void mo52415a(C37272b c37272b);
    }

    /* renamed from: com.google.android.exoplayer2.source.b.a.e$c */
    public static final class C45048c extends IOException {
        public final String url;

        /* synthetic */ C45048c(String str, byte b) {
            this(str);
        }

        private C45048c(String str) {
            this.url = str;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo2604a(C32059c c32059c, long j, long j2) {
        C25553a c25553a;
        AppMethodBeat.m2504i(125998);
        C41614t c41614t = (C41614t) c32059c;
        C45047c c45047c = (C45047c) c41614t.result;
        boolean z = c45047c instanceof C37272b;
        if (z) {
            if (((C37272b) c45047c).bjP) {
                this.bjc.mo19267rQ();
            }
            List singletonList = Collections.singletonList(new C25552a(c45047c.bjZ, Format.m15287j(AppEventsConstants.EVENT_PARAM_VALUE_NO, "application/x-mpegURL")));
            List emptyList = Collections.emptyList();
            c25553a = new C25553a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        } else {
            c25553a = (C25553a) c45047c;
        }
        this.biH = c25553a;
        this.bkH = (C25552a) c25553a.bjF.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c25553a.bjF);
        arrayList.addAll(c25553a.bjG);
        arrayList.addAll(c25553a.bjH);
        m82624w(arrayList);
        C0878a c0878a = (C0878a) this.bkC.get(this.bkH);
        if (z) {
            C0878a.m1979a(c0878a, (C37272b) c45047c);
        } else {
            c0878a.mo2607sD();
        }
        this.bjc.mo19263a(c41614t.bib, j, j2, c41614t.bqW);
        AppMethodBeat.m2505o(125998);
    }

    public C45049e(Uri uri, C25555d c25555d, C8705a c8705a, int i, C32071e c32071e, C37263a<C45047c> c37263a) {
        AppMethodBeat.m2504i(125990);
        this.bkA = uri;
        this.bjb = c25555d;
        this.bjc = c8705a;
        this.bkB = i;
        this.bkE = c32071e;
        this.bjk = c37263a;
        AppMethodBeat.m2505o(125990);
    }

    /* renamed from: c */
    public final C37272b mo72565c(C25552a c25552a) {
        AppMethodBeat.m2504i(125991);
        C37272b c37272b = ((C0878a) this.bkC.get(c25552a)).bkN;
        if (c37272b != null) {
            m82623e(c25552a);
        }
        AppMethodBeat.m2505o(125991);
        return c37272b;
    }

    /* renamed from: d */
    public final void mo72566d(C25552a c25552a) {
        AppMethodBeat.m2504i(125992);
        this.bkC.get(c25552a);
        AppMethodBeat.m2505o(125992);
    }

    /* renamed from: e */
    private void m82623e(C25552a c25552a) {
        AppMethodBeat.m2504i(125993);
        if (c25552a == this.bkH || !this.biH.bjF.contains(c25552a) || (this.bkI != null && this.bkI.bjP)) {
            AppMethodBeat.m2505o(125993);
            return;
        }
        this.bkH = c25552a;
        ((C0878a) this.bkC.get(this.bkH)).mo2607sD();
        AppMethodBeat.m2505o(125993);
    }

    /* renamed from: w */
    private void m82624w(List<C25552a> list) {
        AppMethodBeat.m2504i(125994);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C25552a c25552a = (C25552a) list.get(i);
            this.bkC.put(c25552a, new C0878a(c25552a));
        }
        AppMethodBeat.m2505o(125994);
    }

    /* renamed from: a */
    static C37273a m82620a(C37272b c37272b, C37272b c37272b2) {
        AppMethodBeat.m2504i(125995);
        int i = c37272b2.bjM - c37272b.bjM;
        List list = c37272b.bjS;
        if (i < list.size()) {
            C37273a c37273a = (C37273a) list.get(i);
            AppMethodBeat.m2505o(125995);
            return c37273a;
        }
        AppMethodBeat.m2505o(125995);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m82622a(C45049e c45049e) {
        AppMethodBeat.m2504i(126000);
        List list = c45049e.biH.bjF;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            C0878a c0878a = (C0878a) c45049e.bkC.get(list.get(i));
            if (elapsedRealtime > c0878a.bkR) {
                c45049e.bkH = c0878a.bkK;
                c0878a.mo2607sD();
                AppMethodBeat.m2505o(126000);
                return true;
            }
        }
        AppMethodBeat.m2505o(126000);
        return false;
    }
}
