package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends h {
    int qYI;
    private RecyclerView qYJ;
    private b qYK;
    private Map<Integer, a> qYL = new HashMap();
    LinearLayoutManager qYM;
    Set<Integer> qYN = new HashSet();

    class a {
        int count;
        boolean isVisible;
        long qYO;
        long time;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void cpm() {
            AppMethodBeat.i(37013);
            if (this.isVisible) {
                AppMethodBeat.o(37013);
                return;
            }
            this.isVisible = true;
            this.qYO = System.currentTimeMillis();
            this.count++;
            AppMethodBeat.o(37013);
        }

        /* Access modifiers changed, original: final */
        public final void cpn() {
            AppMethodBeat.i(37014);
            if (this.isVisible) {
                this.isVisible = false;
                if (this.qYO > 0) {
                    this.time += System.currentTimeMillis() - this.qYO;
                    this.qYO = 0;
                }
            }
            AppMethodBeat.o(37014);
        }
    }

    class b extends android.support.v7.widget.RecyclerView.a<a> {

        class a extends v {
            private e qYQ;

            public a(View view, e eVar) {
                super(view);
                this.qYQ = eVar;
            }
        }

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final int getItemCount() {
            AppMethodBeat.i(37015);
            int size = ((l) b.this.qZo).qWB.size();
            AppMethodBeat.o(37015);
            return size;
        }
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
                AppMethodBeat.i(37018);
                if (c.this.qYT == 1) {
                    c cVar = c.this;
                    ab.d("AdLandingCarouselComp", "onDraggin first visible " + b.this.qYM.iQ() + ", last visible " + b.this.qYM.iS());
                    b.a(b.this);
                    c.this.iJP.postDelayed(c.this.qYX, 100);
                }
                AppMethodBeat.o(37018);
            }
        };

        public c(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            AppMethodBeat.i(37019);
            this.iJP = recyclerView;
            this.qYS = linearLayoutManager;
            AppMethodBeat.o(37019);
        }

        private void cpo() {
            AppMethodBeat.i(37020);
            this.iJP.getHandler().removeCallbacks(this.qYX);
            AppMethodBeat.o(37020);
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(37021);
            super.c(recyclerView, i);
            if (i != this.qYT) {
                if (i != 1) {
                    cpo();
                }
                switch (i) {
                    case 0:
                        b.a(b.this);
                        if (this.qYT == 2) {
                            int iQ = this.qYS.iQ();
                            int iS = this.qYS.iS();
                            if (iS >= this.qYU) {
                                if (iQ > this.qYV) {
                                    h(this.qYV, iQ, System.currentTimeMillis() - this.qYW);
                                    break;
                                }
                            }
                            h(iS, this.qYU, System.currentTimeMillis() - this.qYW);
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
            ab.d("AdLandingCarouselComp", "state ".concat(String.valueOf(i)));
            AppMethodBeat.o(37021);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(37022);
            super.a(recyclerView, i, i2);
            AppMethodBeat.o(37022);
        }

        private void h(int i, int i2, long j) {
            AppMethodBeat.i(37023);
            ab.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            b.a(b.this, i, i2, j);
            AppMethodBeat.o(37023);
        }
    }

    public b(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
        AppMethodBeat.i(37024);
        this.qYI = com.tencent.mm.bz.a.fromDPToPix(context, 12);
        AppMethodBeat.o(37024);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au5;
    }

    public final void cpk() {
        AppMethodBeat.i(37025);
        this.qYJ = (RecyclerView) this.contentView.findViewById(R.id.efj);
        this.qYJ.setBackgroundColor(((l) this.qZo).backgroundColor);
        Iterator it = ((l) this.qZo).qWB.iterator();
        int i = 0;
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar instanceof n) {
                n nVar = (n) rVar;
                int i2 = ((int) ((rVar.qWQ + rVar.qWR) + nVar.height)) + (this.qYI << 1);
                if (i <= i2) {
                    i = i2;
                }
            }
            i = i;
        }
        LayoutParams layoutParams = this.qYJ.getLayoutParams();
        layoutParams.height = i;
        this.qYJ.setLayoutParams(layoutParams);
        this.qYK = new b(this, (byte) 0);
        this.qYJ.setAdapter(this.qYK);
        this.qYM = new LinearLayoutManager();
        this.qYM.setOrientation(0);
        this.qYJ.setLayoutManager(this.qYM);
        this.qYJ.a(new c(this.qYJ, this.qYM));
        this.qYJ.setNestedScrollingEnabled(false);
        this.qYJ.setHasFixedSize(true);
        AppMethodBeat.o(37025);
    }

    private void cpl() {
        AppMethodBeat.i(37026);
        if (this.qYM != null) {
            fm(this.qYM.iQ(), this.qYM.iS());
        }
        AppMethodBeat.o(37026);
    }

    private void fm(int i, int i2) {
        AppMethodBeat.i(37027);
        while (i <= i2) {
            a aVar = (a) this.qYL.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.qYL.put(Integer.valueOf(i), aVar);
            }
            aVar.cpm();
            i++;
        }
        AppMethodBeat.o(37027);
    }

    public final void cpa() {
        AppMethodBeat.i(37028);
        super.cpa();
        cpl();
        AppMethodBeat.o(37028);
    }

    public final void cpb() {
        AppMethodBeat.i(37029);
        super.cpb();
        if (this.qYM != null) {
            int iQ = this.qYM.iQ();
            int iS = this.qYM.iS();
            for (int i = iQ; i <= iS; i++) {
                a aVar = (a) this.qYL.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.cpn();
                }
            }
        }
        AppMethodBeat.o(37029);
    }

    public final boolean x(JSONArray jSONArray) {
        AppMethodBeat.i(37030);
        if (jSONArray == null) {
            AppMethodBeat.o(37030);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        if (super.al(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.qYL;
            Set set = this.qYN;
            this.qYN = new HashSet();
            this.qYL = new HashMap();
            for (Entry entry : map.entrySet()) {
                r rVar = (r) ((l) this.qZo).qWB.get(((Integer) entry.getKey()).intValue());
                if (!rVar.qXb && (rVar instanceof n)) {
                    n nVar = (n) rVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((r) ((l) this.qZo).qWB.get(((Integer) entry.getKey()).intValue())).qWO);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String ck = ag.ck(nVar.qWD);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", ck);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            AppMethodBeat.o(37030);
            return true;
        } catch (JSONException e) {
            ab.e("AdLandingCarouselComp", bo.l(e));
            AppMethodBeat.o(37030);
            return false;
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(37031);
        bVar.cpl();
        int iQ = bVar.qYM.iQ();
        int iS = bVar.qYM.iS();
        for (Entry entry : bVar.qYL.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < iQ || ((Integer) entry.getKey()).intValue() > iS) {
                ((a) entry.getValue()).cpn();
            }
        }
        AppMethodBeat.o(37031);
    }

    static /* synthetic */ void a(b bVar, int i, int i2, long j) {
        AppMethodBeat.i(37032);
        if (i > i2) {
            ab.e("AdLandingCarouselComp", "wtf start > end");
            AppMethodBeat.o(37032);
            return;
        }
        int i3;
        bVar.fm(i, i2);
        if (i2 == i) {
            i3 = 1;
        } else {
            i3 = (i2 - i) + 1;
        }
        long j2 = j / ((long) i3);
        while (i <= i2) {
            a aVar = (a) bVar.qYL.get(Integer.valueOf(i));
            if (aVar != null && aVar.isVisible) {
                aVar.isVisible = false;
                aVar.qYO = 0;
                aVar.time += j2;
            }
            i++;
        }
        AppMethodBeat.o(37032);
    }
}
