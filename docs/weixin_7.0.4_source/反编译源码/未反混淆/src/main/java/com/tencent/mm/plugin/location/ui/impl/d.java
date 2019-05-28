package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;

public final class d implements c {
    public static Intent P(Activity activity) {
        AppMethodBeat.i(113645);
        Intent intent = new Intent(activity, SoSoProxyUI.class);
        AppMethodBeat.o(113645);
        return intent;
    }

    public static View ep(Context context) {
        AppMethodBeat.i(113646);
        SoSoMapView soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(R.id.be);
        AppMethodBeat.o(113646);
        return soSoMapView;
    }

    public final a d(Activity activity, int i) {
        a cVar;
        AppMethodBeat.i(113647);
        switch (i) {
            case 2:
                cVar = new c(activity);
                break;
            case 4:
                cVar = new h(activity);
                break;
            case 5:
                ab.i("MicroMsg.MapFactoryImp", "share map");
                cVar = new g(activity);
                break;
            default:
                AppMethodBeat.o(113647);
                return null;
        }
        AppMethodBeat.o(113647);
        return cVar;
    }
}
