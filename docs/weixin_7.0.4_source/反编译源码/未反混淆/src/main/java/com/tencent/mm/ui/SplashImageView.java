package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ap;

public class SplashImageView extends ImageView {
    private boolean hasDrawed;
    private ap yqt;

    public SplashImageView(Context context) {
        super(context);
        AppMethodBeat.i(29908);
        setImageResource(R.drawable.bm9);
        AppMethodBeat.o(29908);
    }

    public SplashImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29909);
        setImageResource(R.drawable.bm9);
        AppMethodBeat.o(29909);
    }

    public SplashImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29910);
        setImageResource(R.drawable.bm9);
        AppMethodBeat.o(29910);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(29911);
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqt != null) {
                this.yqt.bCv();
            }
        }
        AppMethodBeat.o(29911);
    }

    public void setOnDrawListener(ap apVar) {
        this.yqt = apVar;
    }
}
