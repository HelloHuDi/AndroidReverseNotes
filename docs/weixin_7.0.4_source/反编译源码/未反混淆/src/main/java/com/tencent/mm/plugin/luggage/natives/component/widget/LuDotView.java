package com.tencent.mm.plugin.luggage.natives.component.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class LuDotView extends LinearLayout {
    private int lfO = 0;
    private int mCount = 0;
    private GradientDrawable oiN;
    private GradientDrawable oiO;

    public LuDotView(Context context) {
        super(context);
        AppMethodBeat.i(116836);
        init();
        AppMethodBeat.o(116836);
    }

    public LuDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116837);
        init();
        AppMethodBeat.o(116837);
    }

    public LuDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(116838);
        init();
        AppMethodBeat.o(116838);
    }

    @TargetApi(11)
    public LuDotView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AppMethodBeat.i(116839);
        init();
        AppMethodBeat.o(116839);
    }

    private void init() {
        AppMethodBeat.i(116840);
        this.oiN = (GradientDrawable) getContext().getResources().getDrawable(R.drawable.lq);
        this.oiO = (GradientDrawable) getContext().getResources().getDrawable(R.drawable.lq);
        AppMethodBeat.o(116840);
    }

    public void setLuDotViewOrientation(int i) {
        AppMethodBeat.i(116841);
        setOrientation(i);
        if (i == 1) {
            setGravity(21);
            AppMethodBeat.o(116841);
            return;
        }
        setGravity(81);
        AppMethodBeat.o(116841);
    }

    public void setSelectedIndex(int i) {
        int i2 = 0;
        AppMethodBeat.i(116842);
        if (this.lfO == i) {
            AppMethodBeat.o(116842);
            return;
        }
        if (i > getChildCount()) {
            d.d("LuDotView", "index %d is bigger then view count %d. make index to view count", Integer.valueOf(i), Integer.valueOf(getChildCount()));
            i = getChildCount() - 1;
        } else if (i < 0) {
            d.d("LuDotView", "index %d is litter then 0. make index to 0", Integer.valueOf(i));
            i = 0;
        }
        while (true) {
            int i3 = i2;
            if (i3 < getChildCount()) {
                ImageView imageView = (ImageView) getChildAt(i3);
                if (i3 == i) {
                    imageView.setImageDrawable(this.oiO);
                } else {
                    imageView.setImageDrawable(this.oiN);
                }
                i2 = i3 + 1;
            } else {
                this.lfO = i;
                AppMethodBeat.o(116842);
                return;
            }
        }
    }

    public void setIndicatorColor(int i) {
        AppMethodBeat.i(116843);
        this.oiN.setColor(i);
        AppMethodBeat.o(116843);
    }

    public void setIndicatorActiveColor(int i) {
        AppMethodBeat.i(116844);
        this.oiO.setColor(i);
        AppMethodBeat.o(116844);
    }
}
