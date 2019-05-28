package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43562c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a */
public abstract class C21941a extends C13437h {
    public C21941a(Context context, C43562c c43562c, ViewGroup viewGroup) {
        super(context, c43562c, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo37490a(LinearLayout linearLayout) {
        C43562c c43562c = (C43562c) this.qZo;
        if (linearLayout != null) {
            LinearLayout linearLayout2;
            int i = (int) c43562c.qWa;
            int i2 = (int) c43562c.qWb;
            if (Double.compare(c43562c.qWa, c43562c.qWb) != 0) {
                if (i == 0 && c43562c.qWa != 0.0d) {
                    i = 1;
                }
                if (i2 == 0 && c43562c.qWb != 0.0d) {
                    i2 = 1;
                }
            } else if (i == 0) {
                i2 = 1;
                i = 1;
            }
            C4990ab.m7417i("AdLandingBorderedComp", "border width top %d,bottom %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(c43562c.borderColor);
                LayoutParams layoutParams = new LayoutParams(-1, i);
                layoutParams.gravity = 48;
                linearLayout.addView(linearLayout2, 0, layoutParams);
            }
            if (i2 > 0) {
                linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(c43562c.borderColor);
                LayoutParams layoutParams2 = new LayoutParams(-1, i2);
                layoutParams2.gravity = 80;
                linearLayout.addView(linearLayout2, layoutParams2);
            }
        }
    }
}
