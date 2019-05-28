package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p520ui.C43590al;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29060a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C39767o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3934c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3934c.C3935a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3934c.C3936b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3952g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a */
public final class C39771a extends C41523a<C41531v> implements C3936b {
    int bgColor;
    private Context context;
    private LinearLayoutManager qYM;
    C3952g rcX;
    private LinkedHashMap<String, C13437h> rcY = new LinkedHashMap();
    int rcZ;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a$a */
    public class C39770a extends C41531v {
        private LinearLayout jbJ;

        public C39770a(View view) {
            super(view);
            AppMethodBeat.m2504i(37599);
            this.jbJ = (LinearLayout) view.findViewById(2131821019);
            AppMethodBeat.m2505o(37599);
        }
    }

    public C39771a(C3952g c3952g, int i, Context context, LinearLayoutManager linearLayoutManager) {
        AppMethodBeat.m2504i(37600);
        this.qYM = linearLayoutManager;
        this.rcX = c3952g;
        this.bgColor = i;
        this.context = context;
        AppMethodBeat.m2505o(37600);
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(37601);
        C39770a c39770a = new C39770a(LayoutInflater.from(viewGroup.getContext()).inflate(2130968630, viewGroup, false));
        AppMethodBeat.m2505o(37601);
        return c39770a;
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(37602);
        C4990ab.m7416i("MicroMsg.ContentAdapter", "display page " + this.rcX.f1283id + ", pos " + i);
        C39770a c39770a = (C39770a) c41531v;
        c39770a.jbJ.removeAllViews();
        C29086r c29086r = (C29086r) this.rcX.rej.get(i);
        C13437h c13437h = (C13437h) this.rcY.get(c29086r.qWO);
        int i2 = this.bgColor;
        if (c29086r.qWX != null && c29086r.qWX.length() > 0) {
            try {
                i2 = Color.parseColor(c29086r.qWX);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", c29086r.qWX);
            }
        }
        c39770a.jbJ.setBackgroundColor(i2);
        if (c13437h != null) {
            c13437h.mo25535a((C29086r) this.rcX.rej.get(i));
        } else {
            c13437h = C43590al.m77980a(c39770a.jbJ.getContext(), c29086r, c39770a.jbJ, i2);
            if (c13437h != null) {
                this.rcY.put(c29086r.qWO, c13437h);
            }
        }
        if (c13437h != null) {
            View view = c13437h.getView();
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            c39770a.jbJ.addView(view);
        }
        if (i == 0) {
            C13437h c13437h2 = (C13437h) cqa().iterator().next();
            if (c13437h2 != null && (c13437h2 instanceof C39767o)) {
                HashMap hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(this.rcZ));
                c13437h2.mo25536ae(hashMap);
            }
        }
        AppMethodBeat.m2505o(37602);
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(37603);
        int size = this.rcX.rej.size();
        AppMethodBeat.m2505o(37603);
        return size;
    }

    /* renamed from: Du */
    public final boolean mo8697Du(int i) {
        AppMethodBeat.m2504i(37604);
        if (i < this.qYM.mo1780iQ() || i > this.qYM.mo1782iS()) {
            C4990ab.m7418v("MicroMsg.ContentAdapter", "index %d not visible");
            AppMethodBeat.m2505o(37604);
            return false;
        }
        C13437h c13437h = (C13437h) this.rcY.get(((C29086r) this.rcX.rej.get(i)).qWO);
        if (c13437h != null) {
            C4990ab.m7411d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", c13437h, Boolean.valueOf(c13437h.cpx()));
            boolean cpx = c13437h.cpx();
            AppMethodBeat.m2505o(37604);
            return cpx;
        }
        AppMethodBeat.m2505o(37604);
        return false;
    }

    /* renamed from: Dv */
    public final boolean mo8698Dv(int i) {
        AppMethodBeat.m2504i(37605);
        boolean Dz = C3953i.m6286Dz(((C29086r) this.rcX.rej.get(i)).type);
        AppMethodBeat.m2505o(37605);
        return Dz;
    }

    /* renamed from: a */
    public final void mo8700a(int i, C3934c c3934c) {
        AppMethodBeat.m2504i(37606);
        C29086r c29086r = (C29086r) this.rcX.rej.get(i);
        C13437h c13437h = (C13437h) this.rcY.get(c29086r.qWO);
        if (c13437h != null) {
            c13437h.cpa();
            c13437h.cpc();
            if (c29086r.type == 61 || c29086r.type == 62) {
                ArrayList<Integer> arrayList = new ArrayList();
                for (Entry entry : c3934c.qYL.entrySet()) {
                    if (((C3935a) entry.getValue()).qVK) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && mo8697Du(intValue2)) {
                        C13437h Dy = m68032Dy(intValue2);
                        if (Dy instanceof C29060a) {
                            C29060a c29060a = (C29060a) Dy;
                            if (c29060a.qVI && this.rcX.mTL && intValue2 == 0) {
                                ((C29060a) c13437h).coY();
                            } else if (((C29060a) c13437h).qVI) {
                                c29060a.coY();
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(37606);
    }

    /* renamed from: Dw */
    public final void mo8699Dw(int i) {
        AppMethodBeat.m2504i(37607);
        C13437h Dy = m68032Dy(i);
        if (C3953i.m6286Dz(Dy.cpv().type)) {
            ((C3910a) Dy).cps();
        }
        AppMethodBeat.m2505o(37607);
    }

    /* renamed from: Dy */
    private C13437h m68032Dy(int i) {
        AppMethodBeat.m2504i(37608);
        C13437h c13437h = (C13437h) this.rcY.get(((C29086r) this.rcX.rej.get(i)).qWO);
        AppMethodBeat.m2505o(37608);
        return c13437h;
    }

    /* renamed from: Dt */
    public final void mo8696Dt(int i) {
        AppMethodBeat.m2504i(37609);
        if (i < 0 || i >= this.rcX.rej.size()) {
            C4990ab.m7421w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", Integer.valueOf(i), Integer.valueOf(this.rcX.rej.size()));
            AppMethodBeat.m2505o(37609);
            return;
        }
        C13437h c13437h = (C13437h) this.rcY.get(((C29086r) this.rcX.rej.get(i)).qWO);
        if (c13437h != null) {
            c13437h.cpb();
        }
        AppMethodBeat.m2505o(37609);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(37610);
        for (Entry value : this.rcY.entrySet()) {
            ((C13437h) value.getValue()).coZ();
        }
        AppMethodBeat.m2505o(37610);
    }

    /* renamed from: a */
    public final void mo62891a(C3952g c3952g) {
        AppMethodBeat.m2504i(37611);
        if (this.rcX != c3952g) {
            this.rcX = c3952g;
            this.aop.notifyChanged();
        }
        AppMethodBeat.m2505o(37611);
    }

    public final Collection<C13437h> cqa() {
        AppMethodBeat.m2504i(37612);
        if (this.rcY == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(37612);
            return list;
        }
        Collection<C13437h> values = this.rcY.values();
        AppMethodBeat.m2505o(37612);
        return values;
    }
}
