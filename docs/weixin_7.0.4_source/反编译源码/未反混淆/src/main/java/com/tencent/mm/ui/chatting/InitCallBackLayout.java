package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InitCallBackLayout extends FrameLayout {
    private boolean hasDrawed;
    private ap yqt;

    public InitCallBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(30954);
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqt != null) {
                this.yqt.bCv();
            }
        }
        AppMethodBeat.o(30954);
    }

    public void setListener(ap apVar) {
        this.yqt = apVar;
    }
}
