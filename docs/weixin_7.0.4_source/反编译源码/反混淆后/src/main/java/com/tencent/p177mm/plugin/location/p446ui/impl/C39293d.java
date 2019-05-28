package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.p177mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.p177mm.plugin.p443k.C12329c;
import com.tencent.p177mm.plugin.p443k.C39279a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.d */
public final class C39293d implements C12329c {
    /* renamed from: P */
    public static Intent m66972P(Activity activity) {
        AppMethodBeat.m2504i(113645);
        Intent intent = new Intent(activity, SoSoProxyUI.class);
        AppMethodBeat.m2505o(113645);
        return intent;
    }

    /* renamed from: ep */
    public static View m66973ep(Context context) {
        AppMethodBeat.m2504i(113646);
        SoSoMapView soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(2131820622);
        AppMethodBeat.m2505o(113646);
        return soSoMapView;
    }

    /* renamed from: d */
    public final C39279a mo24188d(Activity activity, int i) {
        C39279a c46051c;
        AppMethodBeat.m2504i(113647);
        switch (i) {
            case 2:
                c46051c = new C46051c(activity);
                break;
            case 4:
                c46051c = new C28383h(activity);
                break;
            case 5:
                C4990ab.m7416i("MicroMsg.MapFactoryImp", "share map");
                c46051c = new C39296g(activity);
                break;
            default:
                AppMethodBeat.m2505o(113647);
                return null;
        }
        AppMethodBeat.m2505o(113647);
        return c46051c;
    }
}
