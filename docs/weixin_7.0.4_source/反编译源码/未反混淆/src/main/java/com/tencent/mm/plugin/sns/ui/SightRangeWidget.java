package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.ate;
    }

    /* Access modifiers changed, original: protected */
    public int getMaxTagNameLen() {
        return 10;
    }

    public final boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        AppMethodBeat.i(38582);
        super.a(i, i2, intent, atContactWidget);
        if (atContactWidget != null) {
            if (getLabelRange() == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.crA();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        AppMethodBeat.o(38582);
        return true;
    }
}
