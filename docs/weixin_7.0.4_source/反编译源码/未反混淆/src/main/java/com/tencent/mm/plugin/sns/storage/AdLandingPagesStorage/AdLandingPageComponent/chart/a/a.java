package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class a extends LinkedHashMap<Spannable, Float> {
    public long duration = 0;
    public b qXF = new b();
    public Interpolator qXG = null;
    private String qXH = "";

    public a() {
        AppMethodBeat.i(36954);
        AppMethodBeat.o(36954);
    }

    public a(b bVar) {
        AppMethodBeat.i(36955);
        this.qXF = bVar;
        AppMethodBeat.o(36955);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(36956);
        if (size() != aVar.size()) {
            AppMethodBeat.o(36956);
            return false;
        }
        for (Entry key : aVar.entrySet()) {
            if (!containsKey(key.getKey())) {
                AppMethodBeat.o(36956);
                return false;
            }
        }
        AppMethodBeat.o(36956);
        return true;
    }

    public final Spannable[] cpi() {
        AppMethodBeat.i(36957);
        ArrayList arrayList = new ArrayList();
        for (Entry key : entrySet()) {
            arrayList.add(key.getKey());
        }
        Spannable[] spannableArr = (Spannable[]) arrayList.toArray(new Spannable[arrayList.size()]);
        AppMethodBeat.o(36957);
        return spannableArr;
    }
}
