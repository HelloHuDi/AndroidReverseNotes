package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.p1621a;

import android.support.p057v4.view.ViewPager.C0435d;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a */
public final class C43566a implements C0435d {
    /* renamed from: j */
    public final void mo959j(View view, float f) {
        float f2 = 0.0f;
        AppMethodBeat.m2504i(37654);
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(((float) view.getWidth()) * (-f));
        view.setTranslationY(((float) view.getHeight()) * f);
        AppMethodBeat.m2505o(37654);
    }
}
