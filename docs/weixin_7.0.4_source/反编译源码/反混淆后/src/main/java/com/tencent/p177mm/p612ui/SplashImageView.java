package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.chatting.C5306ap;

/* renamed from: com.tencent.mm.ui.SplashImageView */
public class SplashImageView extends ImageView {
    private boolean hasDrawed;
    private C5306ap yqt;

    public SplashImageView(Context context) {
        super(context);
        AppMethodBeat.m2504i(29908);
        setImageResource(C25738R.drawable.bm9);
        AppMethodBeat.m2505o(29908);
    }

    public SplashImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29909);
        setImageResource(C25738R.drawable.bm9);
        AppMethodBeat.m2505o(29909);
    }

    public SplashImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29910);
        setImageResource(C25738R.drawable.bm9);
        AppMethodBeat.m2505o(29910);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(29911);
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqt != null) {
                this.yqt.bCv();
            }
        }
        AppMethodBeat.m2505o(29911);
    }

    public void setOnDrawListener(C5306ap c5306ap) {
        this.yqt = c5306ap;
    }
}
