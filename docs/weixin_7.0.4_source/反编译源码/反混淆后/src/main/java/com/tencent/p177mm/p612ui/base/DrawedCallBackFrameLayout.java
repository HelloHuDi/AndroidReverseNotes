package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.DrawedCallBackFrameLayout */
public class DrawedCallBackFrameLayout extends FrameLayout {
    private C23579a ysp;

    /* renamed from: com.tencent.mm.ui.base.DrawedCallBackFrameLayout$a */
    public interface C23579a {
        void bCv();
    }

    public DrawedCallBackFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106262);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(106262);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(106263);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
        if (this.ysp != null) {
            this.ysp.bCv();
            this.ysp = null;
        }
        AppMethodBeat.m2505o(106263);
    }

    public void setListener(C23579a c23579a) {
        this.ysp = c23579a;
    }
}
