package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a extends h {
    public a(Context context, c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(LinearLayout linearLayout) {
        c cVar = (c) this.qZo;
        if (linearLayout != null) {
            LinearLayout linearLayout2;
            int i = (int) cVar.qWa;
            int i2 = (int) cVar.qWb;
            if (Double.compare(cVar.qWa, cVar.qWb) != 0) {
                if (i == 0 && cVar.qWa != 0.0d) {
                    i = 1;
                }
                if (i2 == 0 && cVar.qWb != 0.0d) {
                    i2 = 1;
                }
            } else if (i == 0) {
                i2 = 1;
                i = 1;
            }
            ab.i("AdLandingBorderedComp", "border width top %d,bottom %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(cVar.borderColor);
                LayoutParams layoutParams = new LayoutParams(-1, i);
                layoutParams.gravity = 48;
                linearLayout.addView(linearLayout2, 0, layoutParams);
            }
            if (i2 > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(cVar.borderColor);
                LayoutParams layoutParams2 = new LayoutParams(-1, i2);
                layoutParams2.gravity = 80;
                linearLayout.addView(linearLayout2, layoutParams2);
            }
        }
    }
}
