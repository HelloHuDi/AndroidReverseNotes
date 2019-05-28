package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    public boolean caA = true;
    private RecyclerView iJP;
    public Map<Integer, a> qYL = new HashMap();
    private LinearLayoutManager qYM;
    public b rcF;

    public class a {
        public boolean qVK;

        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void cpm() {
            if (!this.qVK) {
                this.qVK = true;
            }
        }

        /* Access modifiers changed, original: final */
        public final void cpn() {
            if (this.qVK) {
                this.qVK = false;
            }
        }
    }

    public interface b {
        void Dt(int i);

        boolean Du(int i);

        boolean Dv(int i);

        void Dw(int i);

        void a(int i, c cVar);

        void onDestroy();
    }

    class c extends m {
        RecyclerView iJP;
        private LinearLayoutManager qYS;
        int qYT = BaseClientBuilder.API_PRIORITY_OTHER;
        private int qYU = -1;
        private int qYV = -1;
        private long qYW = 0;
        Runnable qYX = new Runnable() {
            public final void run() {
                AppMethodBeat.i(37480);
                if (c.this.qYT == 1) {
                    c.this.cpX();
                    c.this.iJP.postDelayed(c.this.qYX, 100);
                }
                AppMethodBeat.o(37480);
            }
        };

        public c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.i(37481);
            this.iJP = recyclerView;
            this.qYS = linearLayoutManager;
            AppMethodBeat.o(37481);
        }

        private void cpo() {
            AppMethodBeat.i(37482);
            this.iJP.getHandler().removeCallbacks(this.qYX);
            AppMethodBeat.o(37482);
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(37483);
            super.c(recyclerView, i);
            if (i != this.qYT) {
                if (i != 1) {
                    cpo();
                }
                switch (i) {
                    case 0:
                        c.this.cpX();
                        if (this.qYT == 2) {
                            int iQ = this.qYS.iQ();
                            int iS = this.qYS.iS();
                            if (iS >= this.qYU) {
                                if (iQ > this.qYV) {
                                    fn(this.qYV, iQ);
                                    break;
                                }
                            }
                            fn(iS, this.qYU);
                            break;
                        }
                        break;
                    case 1:
                        cpo();
                        this.iJP.postDelayed(this.qYX, 100);
                        break;
                    case 2:
                        this.qYU = this.qYS.iQ();
                        this.qYV = this.qYS.iS();
                        this.qYW = System.currentTimeMillis();
                        break;
                }
            }
            this.qYT = i;
            ab.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(i)));
            AppMethodBeat.o(37483);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(37484);
            super.a(recyclerView, i, i2);
            AppMethodBeat.o(37484);
        }

        private void fn(int i, int i2) {
            AppMethodBeat.i(37485);
            c.a(c.this, i, i2);
            AppMethodBeat.o(37485);
        }
    }

    public c(RecyclerView recyclerView) {
        AppMethodBeat.i(37486);
        this.iJP = recyclerView;
        IllegalArgumentException illegalArgumentException;
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            illegalArgumentException = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
            AppMethodBeat.o(37486);
            throw illegalArgumentException;
        } else if (recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof b)) {
            illegalArgumentException = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
            AppMethodBeat.o(37486);
            throw illegalArgumentException;
        } else {
            this.rcF = (b) recyclerView.getAdapter();
            this.qYM = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.iJP.a(new c(recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager()));
            AppMethodBeat.o(37486);
        }
    }

    public final void cpX() {
        AppMethodBeat.i(37487);
        if (this.caA) {
            cpl();
            int iQ = this.qYM.iQ();
            int iS = this.qYM.iS();
            for (Entry entry : this.qYL.entrySet()) {
                if (((Integer) entry.getKey()).intValue() < iQ || ((Integer) entry.getKey()).intValue() > iS) {
                    if (((a) entry.getValue()).qVK) {
                        this.rcF.Dt(((Integer) entry.getKey()).intValue());
                        ((a) entry.getValue()).cpn();
                    }
                } else if (((a) entry.getValue()).qVK) {
                    if (!this.rcF.Du(((Integer) entry.getKey()).intValue())) {
                        this.rcF.Dt(((Integer) entry.getKey()).intValue());
                        ((a) entry.getValue()).cpn();
                    } else if (this.rcF.Dv(((Integer) entry.getKey()).intValue())) {
                        this.rcF.Dw(((Integer) entry.getKey()).intValue());
                    }
                }
            }
            AppMethodBeat.o(37487);
            return;
        }
        AppMethodBeat.o(37487);
    }

    public final void cpl() {
        AppMethodBeat.i(37488);
        if (this.caA) {
            if (this.qYM != null) {
                int iQ = this.qYM.iQ();
                int iS = this.qYM.iS();
                ab.d("RecyclerViewExposureMgr", "appear [%d, %d]", Integer.valueOf(iQ), Integer.valueOf(iS));
                if (iQ == iS && iQ == -1) {
                    ab.i("RecyclerViewExposureMgr", "no exposuring child");
                    AppMethodBeat.o(37488);
                    return;
                }
                fm(iQ, iS);
            }
            AppMethodBeat.o(37488);
            return;
        }
        AppMethodBeat.o(37488);
    }

    private void fm(int i, int i2) {
        AppMethodBeat.i(37489);
        while (i <= i2) {
            a aVar = (a) this.qYL.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.qYL.put(Integer.valueOf(i), aVar);
            }
            if (this.rcF.Du(i)) {
                if (!aVar.qVK) {
                    this.rcF.a(i, this);
                    aVar.cpm();
                } else if (this.rcF.Dv(i)) {
                    this.rcF.Dw(i);
                }
            }
            i++;
        }
        AppMethodBeat.o(37489);
    }

    public final void cpY() {
        AppMethodBeat.i(37490);
        if (this.qYM != null) {
            int iQ = this.qYM.iQ();
            int iS = this.qYM.iS();
            ab.d("RecyclerViewExposureMgr", "disappear [%d, %d]", Integer.valueOf(iQ), Integer.valueOf(iS));
            if (iQ == iS && iQ == -1) {
                ab.i("RecyclerViewExposureMgr", "no exposuring child");
                AppMethodBeat.o(37490);
                return;
            }
            for (int i = iQ; i <= iS; i++) {
                a aVar = (a) this.qYL.get(Integer.valueOf(i));
                if (aVar != null && aVar.qVK) {
                    this.rcF.Dt(i);
                    aVar.cpn();
                }
            }
        }
        AppMethodBeat.o(37490);
    }

    static /* synthetic */ void a(c cVar, int i, int i2) {
        AppMethodBeat.i(37491);
        if (i > i2) {
            ab.e("RecyclerViewExposureMgr", "wtf start > end");
            AppMethodBeat.o(37491);
            return;
        }
        if (cVar.caA) {
            cVar.fm(i, i2);
            while (i <= i2) {
                a aVar = (a) cVar.qYL.get(Integer.valueOf(i));
                if (aVar != null && aVar.qVK) {
                    cVar.rcF.Dt(i);
                    aVar.cpn();
                }
                i++;
            }
        }
        AppMethodBeat.o(37491);
    }
}
