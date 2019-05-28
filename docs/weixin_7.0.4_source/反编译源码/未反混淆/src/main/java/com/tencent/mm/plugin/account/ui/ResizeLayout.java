package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResizeLayout extends LinearLayout {
    private a gHV = null;

    public interface a {
        void aqZ();
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChanged(a aVar) {
        this.gHV = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(125565);
        if (this.gHV != null) {
            this.gHV.aqZ();
        }
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(125565);
    }
}
