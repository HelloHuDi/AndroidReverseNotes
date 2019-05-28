package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p520ui.C43590al;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l */
public final class C46235l {
    private int bgColor = 0;
    private Context context;
    private ViewGroup pxQ;
    private LinkedHashMap<String, C13437h> rcY;
    private List<C29086r> reL;

    public C46235l(List<C29086r> list, Context context, ViewGroup viewGroup) {
        this.reL = list;
        this.context = context;
        this.pxQ = viewGroup;
    }

    /* renamed from: dl */
    public final void mo74251dl(List<C29086r> list) {
        AppMethodBeat.m2504i(37785);
        if (!(list == null || list.equals(this.reL))) {
            this.reL = list;
            mo74249aZ();
        }
        AppMethodBeat.m2505o(37785);
    }

    /* renamed from: aZ */
    public final void mo74249aZ() {
        AppMethodBeat.m2504i(37786);
        if (this.reL == null || this.reL.isEmpty()) {
            AppMethodBeat.m2505o(37786);
            return;
        }
        if (this.rcY == null) {
            this.rcY = new LinkedHashMap();
        }
        for (int i = 0; i < this.reL.size(); i++) {
            C29086r c29086r = (C29086r) this.reL.get(i);
            C13437h c13437h = (C13437h) this.rcY.get(c29086r.qWO);
            if (c13437h != null) {
                c13437h.mo25535a(c29086r);
            } else {
                c13437h = C43590al.m77980a(this.context, c29086r, this.pxQ, this.bgColor);
                if (c13437h != null) {
                    this.rcY.put(c29086r.qWO, c13437h);
                }
            }
            try {
                if (this.pxQ != c13437h.getView().getParent()) {
                    if (this.pxQ.getChildCount() > i) {
                        this.pxQ.addView(c13437h.getView(), i);
                        c13437h.cpz();
                    } else {
                        this.pxQ.addView(c13437h.getView());
                        c13437h.cpz();
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("CompRenderer", "component may have same id %s,%s", c29086r.qWO, C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(37786);
    }

    public final Collection<C13437h> cqa() {
        AppMethodBeat.m2504i(37787);
        if (this.rcY == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(37787);
            return list;
        }
        Collection<C13437h> values = this.rcY.values();
        AppMethodBeat.m2505o(37787);
        return values;
    }
}
