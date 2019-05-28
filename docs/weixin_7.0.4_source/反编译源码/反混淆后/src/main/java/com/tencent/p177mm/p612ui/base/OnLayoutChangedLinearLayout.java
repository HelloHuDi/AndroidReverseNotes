package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.DrawnCallBackLinearLayout;

/* renamed from: com.tencent.mm.ui.base.OnLayoutChangedLinearLayout */
public class OnLayoutChangedLinearLayout extends DrawnCallBackLinearLayout {
    public C23623a yAx;

    /* renamed from: com.tencent.mm.ui.base.OnLayoutChangedLinearLayout$a */
    public interface C23623a {
        void dyX();
    }

    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnChattingLayoutChangedListener(C23623a c23623a) {
        this.yAx = c23623a;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107082);
        super.onLayout(z, i, i2, i3, i4);
        if (this.yAx != null) {
            this.yAx.dyX();
        }
        AppMethodBeat.m2505o(107082);
    }
}
