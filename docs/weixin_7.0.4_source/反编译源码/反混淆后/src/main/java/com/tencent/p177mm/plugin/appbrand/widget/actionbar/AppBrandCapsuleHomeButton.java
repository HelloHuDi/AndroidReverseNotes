package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton */
public final class AppBrandCapsuleHomeButton extends AppBrandOptionButton {
    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected|final */
    public final Drawable getDefaultImageDrawable() {
        AppMethodBeat.m2504i(87497);
        Drawable g = C0380b.m649g(getContext(), C25738R.drawable.avr);
        AppMethodBeat.m2505o(87497);
        return g;
    }
}
