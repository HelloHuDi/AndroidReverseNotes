package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawedCallBackFrameLayout extends FrameLayout {
    private a ysp;

    public interface a {
        void bCv();
    }

    public DrawedCallBackFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106262);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(106262);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(106263);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
        if (this.ysp != null) {
            this.ysp.bCv();
            this.ysp = null;
        }
        AppMethodBeat.o(106263);
    }

    public void setListener(a aVar) {
        this.ysp = aVar;
    }
}
