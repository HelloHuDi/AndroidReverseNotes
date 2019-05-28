package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class OnLayoutChangedLinearLayout extends DrawnCallBackLinearLayout {
    public a yAx;

    public interface a {
        void dyX();
    }

    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnChattingLayoutChangedListener(a aVar) {
        this.yAx = aVar;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107082);
        super.onLayout(z, i, i2, i3, i4);
        if (this.yAx != null) {
            this.yAx.dyX();
        }
        AppMethodBeat.o(107082);
    }
}
