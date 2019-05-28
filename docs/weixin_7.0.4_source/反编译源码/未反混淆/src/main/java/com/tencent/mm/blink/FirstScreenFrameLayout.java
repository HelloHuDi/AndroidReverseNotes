package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class FirstScreenFrameLayout extends FrameLayout {
    public a ebs;

    public interface a {
        void Ia();
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(57721);
        super.dispatchDraw(canvas);
        if (this.ebs != null) {
            new ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57720);
                    if (FirstScreenFrameLayout.this.ebs != null) {
                        FirstScreenFrameLayout.this.ebs.Ia();
                        FirstScreenFrameLayout.this.ebs = null;
                    }
                    AppMethodBeat.o(57720);
                }
            });
        }
        AppMethodBeat.o(57721);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(57722);
        super.setPadding(i, i2, i3, i4);
        AppMethodBeat.o(57722);
    }
}
