package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class AppBrandCapsuleHomeButton extends AppBrandOptionButton {
    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected|final */
    public final Drawable getDefaultImageDrawable() {
        AppMethodBeat.i(87497);
        Drawable g = b.g(getContext(), R.drawable.avr);
        AppMethodBeat.o(87497);
        return g;
    }
}
