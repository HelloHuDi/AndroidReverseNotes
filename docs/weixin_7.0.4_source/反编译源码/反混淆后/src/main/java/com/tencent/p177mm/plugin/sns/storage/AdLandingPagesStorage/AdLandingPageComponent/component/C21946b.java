package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39779l;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b */
public final class C21946b extends C13437h {
    int qYI;
    private RecyclerView qYJ;
    private C21947b qYK;
    private Map<Integer, C13435a> qYL = new HashMap();
    LinearLayoutManager qYM;
    Set<Integer> qYN = new HashSet();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$a */
    class C13435a {
        int count;
        boolean isVisible;
        long qYO;
        long time;

        private C13435a() {
        }

        /* synthetic */ C13435a(C21946b c21946b, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void cpm() {
            AppMethodBeat.m2504i(37013);
            if (this.isVisible) {
                AppMethodBeat.m2505o(37013);
                return;
            }
            this.isVisible = true;
            this.qYO = System.currentTimeMillis();
            this.count++;
            AppMethodBeat.m2505o(37013);
        }

        /* Access modifiers changed, original: final */
        public final void cpn() {
            AppMethodBeat.m2504i(37014);
            if (this.isVisible) {
                this.isVisible = false;
                if (this.qYO > 0) {
                    this.time += System.currentTimeMillis() - this.qYO;
                    this.qYO = 0;
                }
            }
            AppMethodBeat.m2505o(37014);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$b */
    class C21947b extends C41523a<C21948a> {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$b$a */
        class C21948a extends C41531v {
            private C46228e qYQ;

            public C21948a(View view, C46228e c46228e) {
                super(view);
                this.qYQ = c46228e;
            }
        }

        private C21947b() {
        }

        /* synthetic */ C21947b(C21946b c21946b, byte b) {
            this();
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(37015);
            int size = ((C39779l) C21946b.this.qZo).qWB.size();
            AppMethodBeat.m2505o(37015);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$c */
    class C21949c extends C41530m {
        RecyclerView iJP;
        private LinearLayoutManager qYS;
        int qYT = BaseClientBuilder.API_PRIORITY_OTHER;
        private int qYU = -1;
        private int qYV = -1;
        private long qYW = 0;
        Runnable qYX = new C219501();

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b$c$1 */
        class C219501 implements Runnable {
            C219501() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37018);
                if (C21949c.this.qYT == 1) {
                    C21949c c21949c = C21949c.this;
                    C4990ab.m7410d("AdLandingCarouselComp", "onDraggin first visible " + C21946b.this.qYM.mo1780iQ() + ", last visible " + C21946b.this.qYM.mo1782iS());
                    C21946b.m33589a(C21946b.this);
                    C21949c.this.iJP.postDelayed(C21949c.this.qYX, 100);
                }
                AppMethodBeat.m2505o(37018);
            }
        }

        public C21949c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.m2504i(37019);
            this.iJP = recyclerView;
            this.qYS = linearLayoutManager;
            AppMethodBeat.m2505o(37019);
        }

        private void cpo() {
            AppMethodBeat.m2504i(37020);
            this.iJP.getHandler().removeCallbacks(this.qYX);
            AppMethodBeat.m2505o(37020);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(37021);
            super.mo6643c(recyclerView, i);
            if (i != this.qYT) {
                if (i != 1) {
                    cpo();
                }
                switch (i) {
                    case 0:
                        C21946b.m33589a(C21946b.this);
                        if (this.qYT == 2) {
                            int iQ = this.qYS.mo1780iQ();
                            int iS = this.qYS.mo1782iS();
                            if (iS >= this.qYU) {
                                if (iQ > this.qYV) {
                                    m33597h(this.qYV, iQ, System.currentTimeMillis() - this.qYW);
                                    break;
                                }
                            }
                            m33597h(iS, this.qYU, System.currentTimeMillis() - this.qYW);
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
            C4990ab.m7410d("AdLandingCarouselComp", "state ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(37021);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(37022);
            super.mo6642a(recyclerView, i, i2);
            AppMethodBeat.m2505o(37022);
        }

        /* renamed from: h */
        private void m33597h(int i, int i2, long j) {
            AppMethodBeat.m2504i(37023);
            C4990ab.m7411d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            C21946b.m33590a(C21946b.this, i, i2, j);
            AppMethodBeat.m2505o(37023);
        }
    }

    public C21946b(Context context, C39779l c39779l, ViewGroup viewGroup) {
        super(context, c39779l, viewGroup);
        AppMethodBeat.m2504i(37024);
        this.qYI = C1338a.fromDPToPix(context, 12);
        AppMethodBeat.m2505o(37024);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970721;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37025);
        this.qYJ = (RecyclerView) this.contentView.findViewById(2131827630);
        this.qYJ.setBackgroundColor(((C39779l) this.qZo).backgroundColor);
        Iterator it = ((C39779l) this.qZo).qWB.iterator();
        int i = 0;
        while (it.hasNext()) {
            C29086r c29086r = (C29086r) it.next();
            if (c29086r instanceof C39780n) {
                C39780n c39780n = (C39780n) c29086r;
                int i2 = ((int) ((c29086r.qWQ + c29086r.qWR) + c39780n.height)) + (this.qYI << 1);
                if (i <= i2) {
                    i = i2;
                }
            }
            i = i;
        }
        LayoutParams layoutParams = this.qYJ.getLayoutParams();
        layoutParams.height = i;
        this.qYJ.setLayoutParams(layoutParams);
        this.qYK = new C21947b(this, (byte) 0);
        this.qYJ.setAdapter(this.qYK);
        this.qYM = new LinearLayoutManager();
        this.qYM.setOrientation(0);
        this.qYJ.setLayoutManager(this.qYM);
        this.qYJ.mo66332a(new C21949c(this.qYJ, this.qYM));
        this.qYJ.setNestedScrollingEnabled(false);
        this.qYJ.setHasFixedSize(true);
        AppMethodBeat.m2505o(37025);
    }

    private void cpl() {
        AppMethodBeat.m2504i(37026);
        if (this.qYM != null) {
            m33592fm(this.qYM.mo1780iQ(), this.qYM.mo1782iS());
        }
        AppMethodBeat.m2505o(37026);
    }

    /* renamed from: fm */
    private void m33592fm(int i, int i2) {
        AppMethodBeat.m2504i(37027);
        while (i <= i2) {
            C13435a c13435a = (C13435a) this.qYL.get(Integer.valueOf(i));
            if (c13435a == null) {
                c13435a = new C13435a(this, (byte) 0);
                this.qYL.put(Integer.valueOf(i), c13435a);
            }
            c13435a.cpm();
            i++;
        }
        AppMethodBeat.m2505o(37027);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37028);
        super.cpa();
        cpl();
        AppMethodBeat.m2505o(37028);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37029);
        super.cpb();
        if (this.qYM != null) {
            int iQ = this.qYM.mo1780iQ();
            int iS = this.qYM.mo1782iS();
            for (int i = iQ; i <= iS; i++) {
                C13435a c13435a = (C13435a) this.qYL.get(Integer.valueOf(i));
                if (c13435a != null) {
                    c13435a.cpn();
                }
            }
        }
        AppMethodBeat.m2505o(37029);
    }

    /* renamed from: x */
    public final boolean mo25547x(JSONArray jSONArray) {
        AppMethodBeat.m2504i(37030);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(37030);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        if (super.mo15456al(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.qYL;
            Set set = this.qYN;
            this.qYN = new HashSet();
            this.qYL = new HashMap();
            for (Entry entry : map.entrySet()) {
                C29086r c29086r = (C29086r) ((C39779l) this.qZo).qWB.get(((Integer) entry.getKey()).intValue());
                if (!c29086r.qXb && (c29086r instanceof C39780n)) {
                    C39780n c39780n = (C39780n) c29086r;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((C29086r) ((C39779l) this.qZo).qWB.get(((Integer) entry.getKey()).intValue())).qWO);
                    jSONObject2.put("exposureCount", ((C13435a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((C13435a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String ck = C4995ag.m7428ck(c39780n.qWD);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", ck);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            AppMethodBeat.m2505o(37030);
            return true;
        } catch (JSONException e) {
            C4990ab.m7412e("AdLandingCarouselComp", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(37030);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33589a(C21946b c21946b) {
        AppMethodBeat.m2504i(37031);
        c21946b.cpl();
        int iQ = c21946b.qYM.mo1780iQ();
        int iS = c21946b.qYM.mo1782iS();
        for (Entry entry : c21946b.qYL.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < iQ || ((Integer) entry.getKey()).intValue() > iS) {
                ((C13435a) entry.getValue()).cpn();
            }
        }
        AppMethodBeat.m2505o(37031);
    }

    /* renamed from: a */
    static /* synthetic */ void m33590a(C21946b c21946b, int i, int i2, long j) {
        AppMethodBeat.m2504i(37032);
        if (i > i2) {
            C4990ab.m7412e("AdLandingCarouselComp", "wtf start > end");
            AppMethodBeat.m2505o(37032);
            return;
        }
        int i3;
        c21946b.m33592fm(i, i2);
        if (i2 == i) {
            i3 = 1;
        } else {
            i3 = (i2 - i) + 1;
        }
        long j2 = j / ((long) i3);
        while (i <= i2) {
            C13435a c13435a = (C13435a) c21946b.qYL.get(Integer.valueOf(i));
            if (c13435a != null && c13435a.isVisible) {
                c13435a.isVisible = false;
                c13435a.qYO = 0;
                c13435a.time += j2;
            }
            i++;
        }
        AppMethodBeat.m2505o(37032);
    }
}
