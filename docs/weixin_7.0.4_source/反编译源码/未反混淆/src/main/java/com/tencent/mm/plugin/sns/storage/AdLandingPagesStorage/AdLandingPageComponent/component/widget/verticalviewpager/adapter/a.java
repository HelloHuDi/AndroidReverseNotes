package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends android.support.v7.widget.RecyclerView.a<v> implements b {
    int bgColor;
    private Context context;
    private LinearLayoutManager qYM;
    g rcX;
    private LinkedHashMap<String, h> rcY = new LinkedHashMap();
    int rcZ;

    public class a extends v {
        private LinearLayout jbJ;

        public a(View view) {
            super(view);
            AppMethodBeat.i(37599);
            this.jbJ = (LinearLayout) view.findViewById(R.id.m5);
            AppMethodBeat.o(37599);
        }
    }

    public a(g gVar, int i, Context context, LinearLayoutManager linearLayoutManager) {
        AppMethodBeat.i(37600);
        this.qYM = linearLayoutManager;
        this.rcX = gVar;
        this.bgColor = i;
        this.context = context;
        AppMethodBeat.o(37600);
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(37601);
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ar, viewGroup, false));
        AppMethodBeat.o(37601);
        return aVar;
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(37602);
        ab.i("MicroMsg.ContentAdapter", "display page " + this.rcX.id + ", pos " + i);
        a aVar = (a) vVar;
        aVar.jbJ.removeAllViews();
        r rVar = (r) this.rcX.rej.get(i);
        h hVar = (h) this.rcY.get(rVar.qWO);
        int i2 = this.bgColor;
        if (rVar.qWX != null && rVar.qWX.length() > 0) {
            try {
                i2 = Color.parseColor(rVar.qWX);
            } catch (Exception e) {
                ab.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", rVar.qWX);
            }
        }
        aVar.jbJ.setBackgroundColor(i2);
        if (hVar != null) {
            hVar.a((r) this.rcX.rej.get(i));
        } else {
            hVar = al.a(aVar.jbJ.getContext(), rVar, aVar.jbJ, i2);
            if (hVar != null) {
                this.rcY.put(rVar.qWO, hVar);
            }
        }
        if (hVar != null) {
            View view = hVar.getView();
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aVar.jbJ.addView(view);
        }
        if (i == 0) {
            h hVar2 = (h) cqa().iterator().next();
            if (hVar2 != null && (hVar2 instanceof o)) {
                HashMap hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(this.rcZ));
                hVar2.ae(hashMap);
            }
        }
        AppMethodBeat.o(37602);
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        AppMethodBeat.i(37603);
        int size = this.rcX.rej.size();
        AppMethodBeat.o(37603);
        return size;
    }

    public final boolean Du(int i) {
        AppMethodBeat.i(37604);
        if (i < this.qYM.iQ() || i > this.qYM.iS()) {
            ab.v("MicroMsg.ContentAdapter", "index %d not visible");
            AppMethodBeat.o(37604);
            return false;
        }
        h hVar = (h) this.rcY.get(((r) this.rcX.rej.get(i)).qWO);
        if (hVar != null) {
            ab.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", hVar, Boolean.valueOf(hVar.cpx()));
            boolean cpx = hVar.cpx();
            AppMethodBeat.o(37604);
            return cpx;
        }
        AppMethodBeat.o(37604);
        return false;
    }

    public final boolean Dv(int i) {
        AppMethodBeat.i(37605);
        boolean Dz = i.Dz(((r) this.rcX.rej.get(i)).type);
        AppMethodBeat.o(37605);
        return Dz;
    }

    public final void a(int i, c cVar) {
        AppMethodBeat.i(37606);
        r rVar = (r) this.rcX.rej.get(i);
        h hVar = (h) this.rcY.get(rVar.qWO);
        if (hVar != null) {
            hVar.cpa();
            hVar.cpc();
            if (rVar.type == 61 || rVar.type == 62) {
                ArrayList<Integer> arrayList = new ArrayList();
                for (Entry entry : cVar.qYL.entrySet()) {
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a) entry.getValue()).qVK) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && Du(intValue2)) {
                        h Dy = Dy(intValue2);
                        if (Dy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) Dy;
                            if (aVar.qVI && this.rcX.mTL && intValue2 == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) hVar).coY();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) hVar).qVI) {
                                aVar.coY();
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(37606);
    }

    public final void Dw(int i) {
        AppMethodBeat.i(37607);
        h Dy = Dy(i);
        if (i.Dz(Dy.cpv().type)) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) Dy).cps();
        }
        AppMethodBeat.o(37607);
    }

    private h Dy(int i) {
        AppMethodBeat.i(37608);
        h hVar = (h) this.rcY.get(((r) this.rcX.rej.get(i)).qWO);
        AppMethodBeat.o(37608);
        return hVar;
    }

    public final void Dt(int i) {
        AppMethodBeat.i(37609);
        if (i < 0 || i >= this.rcX.rej.size()) {
            ab.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", Integer.valueOf(i), Integer.valueOf(this.rcX.rej.size()));
            AppMethodBeat.o(37609);
            return;
        }
        h hVar = (h) this.rcY.get(((r) this.rcX.rej.get(i)).qWO);
        if (hVar != null) {
            hVar.cpb();
        }
        AppMethodBeat.o(37609);
    }

    public final void onDestroy() {
        AppMethodBeat.i(37610);
        for (Entry value : this.rcY.entrySet()) {
            ((h) value.getValue()).coZ();
        }
        AppMethodBeat.o(37610);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(37611);
        if (this.rcX != gVar) {
            this.rcX = gVar;
            this.aop.notifyChanged();
        }
        AppMethodBeat.o(37611);
    }

    public final Collection<h> cqa() {
        AppMethodBeat.i(37612);
        if (this.rcY == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(37612);
            return list;
        }
        Collection<h> values = this.rcY.values();
        AppMethodBeat.o(37612);
        return values;
    }
}
