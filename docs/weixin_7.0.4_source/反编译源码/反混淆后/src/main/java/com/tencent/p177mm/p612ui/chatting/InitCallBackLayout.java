package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.chatting.InitCallBackLayout */
public class InitCallBackLayout extends FrameLayout {
    private boolean hasDrawed;
    private C5306ap yqt;

    public InitCallBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(30954);
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqt != null) {
                this.yqt.bCv();
            }
        }
        AppMethodBeat.m2505o(30954);
    }

    public void setListener(C5306ap c5306ap) {
        this.yqt = c5306ap;
    }
}
