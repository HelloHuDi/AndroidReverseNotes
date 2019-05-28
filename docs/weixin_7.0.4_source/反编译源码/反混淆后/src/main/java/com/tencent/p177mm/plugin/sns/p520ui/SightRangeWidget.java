package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.SightRangeWidget */
public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return 2130970694;
    }

    /* Access modifiers changed, original: protected */
    public int getMaxTagNameLen() {
        return 10;
    }

    /* renamed from: a */
    public final boolean mo62963a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        AppMethodBeat.m2504i(38582);
        super.mo62963a(i, i2, intent, atContactWidget);
        if (atContactWidget != null) {
            if (getLabelRange() == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.crA();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(38582);
        return true;
    }
}
