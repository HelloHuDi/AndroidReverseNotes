package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a */
public final class C13431a extends LinkedHashMap<Spannable, Float> {
    public long duration = 0;
    public C29063b qXF = new C29063b();
    public Interpolator qXG = null;
    private String qXH = "";

    public C13431a() {
        AppMethodBeat.m2504i(36954);
        AppMethodBeat.m2505o(36954);
    }

    public C13431a(C29063b c29063b) {
        AppMethodBeat.m2504i(36955);
        this.qXF = c29063b;
        AppMethodBeat.m2505o(36955);
    }

    /* renamed from: a */
    public final boolean mo25506a(C13431a c13431a) {
        AppMethodBeat.m2504i(36956);
        if (size() != c13431a.size()) {
            AppMethodBeat.m2505o(36956);
            return false;
        }
        for (Entry key : c13431a.entrySet()) {
            if (!containsKey(key.getKey())) {
                AppMethodBeat.m2505o(36956);
                return false;
            }
        }
        AppMethodBeat.m2505o(36956);
        return true;
    }

    public final Spannable[] cpi() {
        AppMethodBeat.m2504i(36957);
        ArrayList arrayList = new ArrayList();
        for (Entry key : entrySet()) {
            arrayList.add(key.getKey());
        }
        Spannable[] spannableArr = (Spannable[]) arrayList.toArray(new Spannable[arrayList.size()]);
        AppMethodBeat.m2505o(36957);
        return spannableArr;
    }
}
