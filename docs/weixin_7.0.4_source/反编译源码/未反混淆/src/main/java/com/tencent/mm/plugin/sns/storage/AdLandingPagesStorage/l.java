package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l {
    private int bgColor = 0;
    private Context context;
    private ViewGroup pxQ;
    private LinkedHashMap<String, h> rcY;
    private List<r> reL;

    public l(List<r> list, Context context, ViewGroup viewGroup) {
        this.reL = list;
        this.context = context;
        this.pxQ = viewGroup;
    }

    public final void dl(List<r> list) {
        AppMethodBeat.i(37785);
        if (!(list == null || list.equals(this.reL))) {
            this.reL = list;
            aZ();
        }
        AppMethodBeat.o(37785);
    }

    public final void aZ() {
        AppMethodBeat.i(37786);
        if (this.reL == null || this.reL.isEmpty()) {
            AppMethodBeat.o(37786);
            return;
        }
        if (this.rcY == null) {
            this.rcY = new LinkedHashMap();
        }
        for (int i = 0; i < this.reL.size(); i++) {
            r rVar = (r) this.reL.get(i);
            h hVar = (h) this.rcY.get(rVar.qWO);
            if (hVar != null) {
                hVar.a(rVar);
            } else {
                hVar = al.a(this.context, rVar, this.pxQ, this.bgColor);
                if (hVar != null) {
                    this.rcY.put(rVar.qWO, hVar);
                }
            }
            try {
                if (this.pxQ != hVar.getView().getParent()) {
                    if (this.pxQ.getChildCount() > i) {
                        this.pxQ.addView(hVar.getView(), i);
                        hVar.cpz();
                    } else {
                        this.pxQ.addView(hVar.getView());
                        hVar.cpz();
                    }
                }
            } catch (Exception e) {
                ab.e("CompRenderer", "component may have same id %s,%s", rVar.qWO, bo.l(e));
            }
        }
        AppMethodBeat.o(37786);
    }

    public final Collection<h> cqa() {
        AppMethodBeat.i(37787);
        if (this.rcY == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(37787);
            return list;
        }
        Collection<h> values = this.rcY.values();
        AppMethodBeat.o(37787);
        return values;
    }
}
