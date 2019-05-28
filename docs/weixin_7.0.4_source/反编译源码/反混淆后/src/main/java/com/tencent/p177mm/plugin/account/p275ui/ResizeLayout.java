package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.account.ui.ResizeLayout */
public class ResizeLayout extends LinearLayout {
    private C33029a gHV = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.ResizeLayout$a */
    public interface C33029a {
        void aqZ();
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChanged(C33029a c33029a) {
        this.gHV = c33029a;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(125565);
        if (this.gHV != null) {
            this.gHV.aqZ();
        }
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(125565);
    }
}
