package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuDotView */
public class LuDotView extends LinearLayout {
    private int lfO = 0;
    private int mCount = 0;
    private GradientDrawable oiN;
    private GradientDrawable oiO;

    public LuDotView(Context context) {
        super(context);
        AppMethodBeat.m2504i(116836);
        init();
        AppMethodBeat.m2505o(116836);
    }

    public LuDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116837);
        init();
        AppMethodBeat.m2505o(116837);
    }

    public LuDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(116838);
        init();
        AppMethodBeat.m2505o(116838);
    }

    @TargetApi(11)
    public LuDotView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AppMethodBeat.m2504i(116839);
        init();
        AppMethodBeat.m2505o(116839);
    }

    private void init() {
        AppMethodBeat.m2504i(116840);
        this.oiN = (GradientDrawable) getContext().getResources().getDrawable(C25738R.drawable.f6665lq);
        this.oiO = (GradientDrawable) getContext().getResources().getDrawable(C25738R.drawable.f6665lq);
        AppMethodBeat.m2505o(116840);
    }

    public void setLuDotViewOrientation(int i) {
        AppMethodBeat.m2504i(116841);
        setOrientation(i);
        if (i == 1) {
            setGravity(21);
            AppMethodBeat.m2505o(116841);
            return;
        }
        setGravity(81);
        AppMethodBeat.m2505o(116841);
    }

    public void setSelectedIndex(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(116842);
        if (this.lfO == i) {
            AppMethodBeat.m2505o(116842);
            return;
        }
        if (i > getChildCount()) {
            C45124d.m82926d("LuDotView", "index %d is bigger then view count %d. make index to view count", Integer.valueOf(i), Integer.valueOf(getChildCount()));
            i = getChildCount() - 1;
        } else if (i < 0) {
            C45124d.m82926d("LuDotView", "index %d is litter then 0. make index to 0", Integer.valueOf(i));
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
                AppMethodBeat.m2505o(116842);
                return;
            }
        }
    }

    public void setIndicatorColor(int i) {
        AppMethodBeat.m2504i(116843);
        this.oiN.setColor(i);
        AppMethodBeat.m2505o(116843);
    }

    public void setIndicatorActiveColor(int i) {
        AppMethodBeat.m2504i(116844);
        this.oiO.setColor(i);
        AppMethodBeat.m2505o(116844);
    }
}
