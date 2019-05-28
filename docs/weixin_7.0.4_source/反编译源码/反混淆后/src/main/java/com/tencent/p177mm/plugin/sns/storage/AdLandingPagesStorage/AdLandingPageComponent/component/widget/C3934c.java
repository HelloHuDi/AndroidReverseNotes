package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c */
public final class C3934c {
    public boolean caA = true;
    private RecyclerView iJP;
    public Map<Integer, C3935a> qYL = new HashMap();
    private LinearLayoutManager qYM;
    public C3936b rcF;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c$a */
    public class C3935a {
        public boolean qVK;

        private C3935a() {
        }

        /* synthetic */ C3935a(C3934c c3934c, byte b) {
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

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c$b */
    public interface C3936b {
        /* renamed from: Dt */
        void mo8696Dt(int i);

        /* renamed from: Du */
        boolean mo8697Du(int i);

        /* renamed from: Dv */
        boolean mo8698Dv(int i);

        /* renamed from: Dw */
        void mo8699Dw(int i);

        /* renamed from: a */
        void mo8700a(int i, C3934c c3934c);

        void onDestroy();
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c$c */
    class C3937c extends C41530m {
        RecyclerView iJP;
        private LinearLayoutManager qYS;
        int qYT = BaseClientBuilder.API_PRIORITY_OTHER;
        private int qYU = -1;
        private int qYV = -1;
        private long qYW = 0;
        Runnable qYX = new C39381();

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c$c$1 */
        class C39381 implements Runnable {
            C39381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37480);
                if (C3937c.this.qYT == 1) {
                    C3934c.this.cpX();
                    C3937c.this.iJP.postDelayed(C3937c.this.qYX, 100);
                }
                AppMethodBeat.m2505o(37480);
            }
        }

        public C3937c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.m2504i(37481);
            this.iJP = recyclerView;
            this.qYS = linearLayoutManager;
            AppMethodBeat.m2505o(37481);
        }

        private void cpo() {
            AppMethodBeat.m2504i(37482);
            this.iJP.getHandler().removeCallbacks(this.qYX);
            AppMethodBeat.m2505o(37482);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(37483);
            super.mo6643c(recyclerView, i);
            if (i != this.qYT) {
                if (i != 1) {
                    cpo();
                }
                switch (i) {
                    case 0:
                        C3934c.this.cpX();
                        if (this.qYT == 2) {
                            int iQ = this.qYS.mo1780iQ();
                            int iS = this.qYS.mo1782iS();
                            if (iS >= this.qYU) {
                                if (iQ > this.qYV) {
                                    m6269fn(this.qYV, iQ);
                                    break;
                                }
                            }
                            m6269fn(iS, this.qYU);
                            break;
                        }
                        break;
                    case 1:
                        cpo();
                        this.iJP.postDelayed(this.qYX, 100);
                        break;
                    case 2:
                        this.qYU = this.qYS.mo1780iQ();
                        this.qYV = this.qYS.mo1782iS();
                        this.qYW = System.currentTimeMillis();
                        break;
                }
            }
            this.qYT = i;
            C4990ab.m7410d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(37483);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(37484);
            super.mo6642a(recyclerView, i, i2);
            AppMethodBeat.m2505o(37484);
        }

        /* renamed from: fn */
        private void m6269fn(int i, int i2) {
            AppMethodBeat.m2504i(37485);
            C3934c.m6262a(C3934c.this, i, i2);
            AppMethodBeat.m2505o(37485);
        }
    }

    public C3934c(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(37486);
        this.iJP = recyclerView;
        IllegalArgumentException illegalArgumentException;
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            illegalArgumentException = new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
            AppMethodBeat.m2505o(37486);
            throw illegalArgumentException;
        } else if (recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof C3936b)) {
            illegalArgumentException = new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
            AppMethodBeat.m2505o(37486);
            throw illegalArgumentException;
        } else {
            this.rcF = (C3936b) recyclerView.getAdapter();
            this.qYM = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.iJP.mo66332a(new C3937c(recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager()));
            AppMethodBeat.m2505o(37486);
        }
    }

    public final void cpX() {
        AppMethodBeat.m2504i(37487);
        if (this.caA) {
            cpl();
            int iQ = this.qYM.mo1780iQ();
            int iS = this.qYM.mo1782iS();
            for (Entry entry : this.qYL.entrySet()) {
                if (((Integer) entry.getKey()).intValue() < iQ || ((Integer) entry.getKey()).intValue() > iS) {
                    if (((C3935a) entry.getValue()).qVK) {
                        this.rcF.mo8696Dt(((Integer) entry.getKey()).intValue());
                        ((C3935a) entry.getValue()).cpn();
                    }
                } else if (((C3935a) entry.getValue()).qVK) {
                    if (!this.rcF.mo8697Du(((Integer) entry.getKey()).intValue())) {
                        this.rcF.mo8696Dt(((Integer) entry.getKey()).intValue());
                        ((C3935a) entry.getValue()).cpn();
                    } else if (this.rcF.mo8698Dv(((Integer) entry.getKey()).intValue())) {
                        this.rcF.mo8699Dw(((Integer) entry.getKey()).intValue());
                    }
                }
            }
            AppMethodBeat.m2505o(37487);
            return;
        }
        AppMethodBeat.m2505o(37487);
    }

    public final void cpl() {
        AppMethodBeat.m2504i(37488);
        if (this.caA) {
            if (this.qYM != null) {
                int iQ = this.qYM.mo1780iQ();
                int iS = this.qYM.mo1782iS();
                C4990ab.m7411d("RecyclerViewExposureMgr", "appear [%d, %d]", Integer.valueOf(iQ), Integer.valueOf(iS));
                if (iQ == iS && iQ == -1) {
                    C4990ab.m7416i("RecyclerViewExposureMgr", "no exposuring child");
                    AppMethodBeat.m2505o(37488);
                    return;
                }
                m6263fm(iQ, iS);
            }
            AppMethodBeat.m2505o(37488);
            return;
        }
        AppMethodBeat.m2505o(37488);
    }

    /* renamed from: fm */
    private void m6263fm(int i, int i2) {
        AppMethodBeat.m2504i(37489);
        while (i <= i2) {
            C3935a c3935a = (C3935a) this.qYL.get(Integer.valueOf(i));
            if (c3935a == null) {
                c3935a = new C3935a(this, (byte) 0);
                this.qYL.put(Integer.valueOf(i), c3935a);
            }
            if (this.rcF.mo8697Du(i)) {
                if (!c3935a.qVK) {
                    this.rcF.mo8700a(i, this);
                    c3935a.cpm();
                } else if (this.rcF.mo8698Dv(i)) {
                    this.rcF.mo8699Dw(i);
                }
            }
            i++;
        }
        AppMethodBeat.m2505o(37489);
    }

    public final void cpY() {
        AppMethodBeat.m2504i(37490);
        if (this.qYM != null) {
            int iQ = this.qYM.mo1780iQ();
            int iS = this.qYM.mo1782iS();
            C4990ab.m7411d("RecyclerViewExposureMgr", "disappear [%d, %d]", Integer.valueOf(iQ), Integer.valueOf(iS));
            if (iQ == iS && iQ == -1) {
                C4990ab.m7416i("RecyclerViewExposureMgr", "no exposuring child");
                AppMethodBeat.m2505o(37490);
                return;
            }
            for (int i = iQ; i <= iS; i++) {
                C3935a c3935a = (C3935a) this.qYL.get(Integer.valueOf(i));
                if (c3935a != null && c3935a.qVK) {
                    this.rcF.mo8696Dt(i);
                    c3935a.cpn();
                }
            }
        }
        AppMethodBeat.m2505o(37490);
    }

    /* renamed from: a */
    static /* synthetic */ void m6262a(C3934c c3934c, int i, int i2) {
        AppMethodBeat.m2504i(37491);
        if (i > i2) {
            C4990ab.m7412e("RecyclerViewExposureMgr", "wtf start > end");
            AppMethodBeat.m2505o(37491);
            return;
        }
        if (c3934c.caA) {
            c3934c.m6263fm(i, i2);
            while (i <= i2) {
                C3935a c3935a = (C3935a) c3934c.qYL.get(Integer.valueOf(i));
                if (c3935a != null && c3935a.qVK) {
                    c3934c.rcF.mo8696Dt(i);
                    c3935a.cpn();
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(37491);
    }
}
