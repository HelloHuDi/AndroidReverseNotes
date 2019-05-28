package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.view.ViewPager.d;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements d {
    public final void j(View view, float f) {
        float f2 = 0.0f;
        AppMethodBeat.i(37654);
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(((float) view.getWidth()) * (-f));
        view.setTranslationY(((float) view.getHeight()) * f);
        AppMethodBeat.o(37654);
    }
}
