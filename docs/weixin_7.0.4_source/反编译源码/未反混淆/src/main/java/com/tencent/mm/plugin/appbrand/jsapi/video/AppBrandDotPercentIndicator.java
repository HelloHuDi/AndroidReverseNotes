package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class AppBrandDotPercentIndicator extends LinearLayout {
    private int hYk;
    private LayoutInflater mInflater;

    public AppBrandDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126436);
        init(context);
        AppMethodBeat.o(126436);
    }

    public AppBrandDotPercentIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126437);
        init(context);
        AppMethodBeat.o(126437);
    }

    private void init(Context context) {
        AppMethodBeat.i(126438);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(126438);
    }

    public void setDotsNum(int i) {
        AppMethodBeat.i(126439);
        if (i <= 1) {
            i = 8;
        }
        this.hYk = i;
        removeAllViews();
        for (int i2 = 0; i2 < this.hYk; i2++) {
            addView((ImageView) this.mInflater.inflate(R.layout.c2, this, false));
        }
        AppMethodBeat.o(126439);
    }

    public void setPercent(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        AppMethodBeat.i(126440);
        if (f >= 0.0f) {
            f3 = f;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        ab.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", Float.valueOf(f2), Integer.valueOf((int) Math.rint((double) (((float) this.hYk) * f2))));
        int i = 0;
        while (i < r3 && i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.drawable.bk);
            i++;
        }
        while (i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.drawable.bj);
            i++;
        }
        AppMethodBeat.o(126440);
    }
}
