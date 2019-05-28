package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements com.google.android.exoplayer2.h.s.a<t<c>> {
    public a biH;
    public final com.google.android.exoplayer2.source.b.d bjb;
    final com.google.android.exoplayer2.source.a.a bjc;
    public final com.google.android.exoplayer2.h.t.a<c> bjk;
    public final Uri bkA;
    public final int bkB;
    public final IdentityHashMap<com.google.android.exoplayer2.source.b.a.a.a, a> bkC = new IdentityHashMap();
    public final Handler bkD = new Handler();
    final e bkE;
    public final List<b> bkF = new ArrayList();
    public final s bkG = new s("HlsPlaylistTracker:MasterPlaylist");
    public com.google.android.exoplayer2.source.b.a.a.a bkH;
    b bkI;
    public boolean bkJ;

    public final class a implements com.google.android.exoplayer2.h.s.a<t<c>>, Runnable {
        private final com.google.android.exoplayer2.source.b.a.a.a bkK;
        public final s bkL = new s("HlsPlaylistTracker:MediaPlaylist");
        private final t<c> bkM;
        public b bkN;
        public long bkO;
        private long bkP;
        private long bkQ;
        private long bkR;
        private boolean bkS;
        private IOException bkT;

        static /* synthetic */ void a(a aVar, b bVar) {
            AppMethodBeat.i(125989);
            aVar.b(bVar);
            AppMethodBeat.o(125989);
        }

        public final /* synthetic */ void a(com.google.android.exoplayer2.h.s.c cVar, long j, long j2) {
            AppMethodBeat.i(125988);
            t tVar = (t) cVar;
            c cVar2 = (c) tVar.result;
            if (cVar2 instanceof b) {
                b((b) cVar2);
                if (((b) cVar2).bjP) {
                    e.this.bjc.rQ();
                }
                e.this.bjc.a(tVar.bib, j, j2, tVar.bqW);
                AppMethodBeat.o(125988);
                return;
            }
            this.bkT = new o("Loaded playlist has unexpected type.");
            AppMethodBeat.o(125988);
        }

        public a(com.google.android.exoplayer2.source.b.a.a.a aVar) {
            AppMethodBeat.i(125980);
            this.bkK = aVar;
            this.bkM = new t(e.this.bjb.st(), u.m(e.this.biH.bjZ, aVar.url), e.this.bjk);
            AppMethodBeat.o(125980);
        }

        public final void sD() {
            AppMethodBeat.i(125981);
            this.bkR = 0;
            if (this.bkS || this.bkL.isLoading()) {
                AppMethodBeat.o(125981);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.bkQ) {
                this.bkS = true;
                e.this.bkD.postDelayed(this, this.bkQ - elapsedRealtime);
                AppMethodBeat.o(125981);
                return;
            }
            sE();
            AppMethodBeat.o(125981);
        }

        public final void run() {
            AppMethodBeat.i(125982);
            this.bkS = false;
            sE();
            AppMethodBeat.o(125982);
        }

        private void sE() {
            AppMethodBeat.i(125983);
            this.bkL.a(this.bkM, this, e.this.bkB);
            AppMethodBeat.o(125983);
        }

        private void b(b bVar) {
            Object obj;
            int size;
            b bVar2;
            AppMethodBeat.i(125984);
            b bVar3 = this.bkN;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.bkO = elapsedRealtime;
            e eVar = e.this;
            if (bVar3 == null || bVar.bjM > bVar3.bjM) {
                obj = 1;
            } else {
                if (bVar.bjM >= bVar3.bjM) {
                    size = bVar.bjS.size();
                    int size2 = bVar3.bjS.size();
                    if (size > size2 || (size == size2 && bVar.bjP && !bVar3.bjP)) {
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                bVar2 = bVar.bjP ? bVar3.bjP ? bVar3 : new b(bVar3.bjI, bVar3.bjZ, bVar3.bka, bVar3.bjJ, bVar3.bif, bVar3.bjK, bVar3.bjL, bVar3.bjM, bVar3.version, bVar3.bjN, bVar3.bjO, true, bVar3.bjQ, bVar3.bjR, bVar3.bjS) : bVar3;
            } else {
                long j;
                int i;
                if (bVar.bjQ) {
                    j = bVar.bif;
                } else {
                    j = eVar.bkI != null ? eVar.bkI.bif : 0;
                    if (bVar3 != null) {
                        size = bVar3.bjS.size();
                        com.google.android.exoplayer2.source.b.a.b.a a = e.a(bVar3, bVar);
                        if (a != null) {
                            j = bVar3.bif + a.bjU;
                        } else if (size == bVar.bjM - bVar3.bjM) {
                            j = bVar3.sC();
                        }
                    }
                }
                if (bVar.bjK) {
                    i = bVar.bjL;
                } else {
                    i = eVar.bkI != null ? eVar.bkI.bjL : 0;
                    if (bVar3 != null) {
                        com.google.android.exoplayer2.source.b.a.b.a a2 = e.a(bVar3, bVar);
                        if (a2 != null) {
                            i = (bVar3.bjL + a2.bjT) - ((com.google.android.exoplayer2.source.b.a.b.a) bVar.bjS.get(0)).bjT;
                        }
                    }
                }
                bVar2 = new b(bVar.bjI, bVar.bjZ, bVar.bka, bVar.bjJ, j, true, i, bVar.bjM, bVar.version, bVar.bjN, bVar.bjO, bVar.bjP, bVar.bjQ, bVar.bjR, bVar.bjS);
            }
            this.bkN = bVar2;
            if (this.bkN != bVar3) {
                this.bkT = null;
                this.bkP = elapsedRealtime;
                e eVar2 = e.this;
                com.google.android.exoplayer2.source.b.a.a.a aVar = this.bkK;
                b bVar4 = this.bkN;
                if (aVar == eVar2.bkH) {
                    if (eVar2.bkI == null) {
                        eVar2.bkJ = !bVar4.bjP;
                    }
                    eVar2.bkI = bVar4;
                    eVar2.bkE.a(bVar4);
                }
                int size3 = eVar2.bkF.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    ((b) eVar2.bkF.get(i2)).sx();
                }
            } else if (!this.bkN.bjP) {
                if (bVar.bjM + bVar.bjS.size() < this.bkN.bjM) {
                    this.bkT = new c(this.bkK.url, (byte) 0);
                } else if (((double) (elapsedRealtime - this.bkP)) > ((double) com.google.android.exoplayer2.b.w(this.bkN.bjN)) * 3.5d) {
                    this.bkT = new d(this.bkK.url, (byte) 0);
                    sF();
                }
            }
            this.bkQ = com.google.android.exoplayer2.b.w(this.bkN != bVar3 ? this.bkN.bjN : this.bkN.bjN / 2) + elapsedRealtime;
            if (this.bkK == e.this.bkH && !this.bkN.bjP) {
                sD();
            }
            AppMethodBeat.o(125984);
        }

        private boolean sF() {
            AppMethodBeat.i(125985);
            this.bkR = SystemClock.elapsedRealtime() + 60000;
            e.a(e.this, this.bkK);
            if (e.this.bkH != this.bkK || e.a(e.this)) {
                AppMethodBeat.o(125985);
                return false;
            }
            AppMethodBeat.o(125985);
            return true;
        }
    }

    public interface b {
        void b(com.google.android.exoplayer2.source.b.a.a.a aVar);

        void sx();
    }

    public static final class d extends IOException {
        public final String url;

        /* synthetic */ d(String str, byte b) {
            this(str);
        }

        private d(String str) {
            this.url = str;
        }
    }

    public interface e {
        void a(b bVar);
    }

    public static final class c extends IOException {
        public final String url;

        /* synthetic */ c(String str, byte b) {
            this(str);
        }

        private c(String str) {
            this.url = str;
        }
    }

    public final /* synthetic */ void a(com.google.android.exoplayer2.h.s.c cVar, long j, long j2) {
        a aVar;
        AppMethodBeat.i(125998);
        t tVar = (t) cVar;
        c cVar2 = (c) tVar.result;
        boolean z = cVar2 instanceof b;
        if (z) {
            if (((b) cVar2).bjP) {
                this.bjc.rQ();
            }
            List singletonList = Collections.singletonList(new com.google.android.exoplayer2.source.b.a.a.a(cVar2.bjZ, Format.j(AppEventsConstants.EVENT_PARAM_VALUE_NO, "application/x-mpegURL")));
            List emptyList = Collections.emptyList();
            aVar = new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        } else {
            aVar = (a) cVar2;
        }
        this.biH = aVar;
        this.bkH = (com.google.android.exoplayer2.source.b.a.a.a) aVar.bjF.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.bjF);
        arrayList.addAll(aVar.bjG);
        arrayList.addAll(aVar.bjH);
        w(arrayList);
        a aVar2 = (a) this.bkC.get(this.bkH);
        if (z) {
            a.a(aVar2, (b) cVar2);
        } else {
            aVar2.sD();
        }
        this.bjc.a(tVar.bib, j, j2, tVar.bqW);
        AppMethodBeat.o(125998);
    }

    public e(Uri uri, com.google.android.exoplayer2.source.b.d dVar, com.google.android.exoplayer2.source.a.a aVar, int i, e eVar, com.google.android.exoplayer2.h.t.a<c> aVar2) {
        AppMethodBeat.i(125990);
        this.bkA = uri;
        this.bjb = dVar;
        this.bjc = aVar;
        this.bkB = i;
        this.bkE = eVar;
        this.bjk = aVar2;
        AppMethodBeat.o(125990);
    }

    public final b c(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        AppMethodBeat.i(125991);
        b bVar = ((a) this.bkC.get(aVar)).bkN;
        if (bVar != null) {
            e(aVar);
        }
        AppMethodBeat.o(125991);
        return bVar;
    }

    public final void d(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        AppMethodBeat.i(125992);
        this.bkC.get(aVar);
        AppMethodBeat.o(125992);
    }

    private void e(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        AppMethodBeat.i(125993);
        if (aVar == this.bkH || !this.biH.bjF.contains(aVar) || (this.bkI != null && this.bkI.bjP)) {
            AppMethodBeat.o(125993);
            return;
        }
        this.bkH = aVar;
        ((a) this.bkC.get(this.bkH)).sD();
        AppMethodBeat.o(125993);
    }

    private void w(List<com.google.android.exoplayer2.source.b.a.a.a> list) {
        AppMethodBeat.i(125994);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.source.b.a.a.a aVar = (com.google.android.exoplayer2.source.b.a.a.a) list.get(i);
            this.bkC.put(aVar, new a(aVar));
        }
        AppMethodBeat.o(125994);
    }

    static com.google.android.exoplayer2.source.b.a.b.a a(b bVar, b bVar2) {
        AppMethodBeat.i(125995);
        int i = bVar2.bjM - bVar.bjM;
        List list = bVar.bjS;
        if (i < list.size()) {
            com.google.android.exoplayer2.source.b.a.b.a aVar = (com.google.android.exoplayer2.source.b.a.b.a) list.get(i);
            AppMethodBeat.o(125995);
            return aVar;
        }
        AppMethodBeat.o(125995);
        return null;
    }

    static /* synthetic */ boolean a(e eVar) {
        AppMethodBeat.i(126000);
        List list = eVar.biH.bjF;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = (a) eVar.bkC.get(list.get(i));
            if (elapsedRealtime > aVar.bkR) {
                eVar.bkH = aVar.bkK;
                aVar.sD();
                AppMethodBeat.o(126000);
                return true;
            }
        }
        AppMethodBeat.o(126000);
        return false;
    }
}
