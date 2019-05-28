package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class VideoDotPercentIndicator extends LinearLayout {
    private int hYk;
    private LayoutInflater mInflater;

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(84559);
        init(context);
        AppMethodBeat.o(84559);
    }

    public VideoDotPercentIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(84560);
        init(context);
        AppMethodBeat.o(84560);
    }

    private void init(Context context) {
        AppMethodBeat.i(84561);
        this.mInflater = LayoutInflater.from(context);
        setDotsNum(0);
        AppMethodBeat.o(84561);
    }

    public void setDotsNum(int i) {
        AppMethodBeat.i(84562);
        if (i <= 1) {
            i = 8;
        }
        this.hYk = i;
        removeAllViews();
        for (int i2 = 0; i2 < this.hYk; i2++) {
            addView((ImageView) this.mInflater.inflate(R.layout.b8e, this, false));
        }
        AppMethodBeat.o(84562);
    }

    public void setProgress(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        AppMethodBeat.i(84563);
        float f4 = f / 100.0f;
        if (f4 >= 0.0f) {
            f3 = f4;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        ab.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", Float.valueOf(f2), Integer.valueOf((int) Math.rint((double) (((float) this.hYk) * f2))));
        int i = 0;
        while (i < r3 && i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.drawable.a82);
            i++;
        }
        while (i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.drawable.a81);
            i++;
        }
        AppMethodBeat.o(84563);
    }
}
