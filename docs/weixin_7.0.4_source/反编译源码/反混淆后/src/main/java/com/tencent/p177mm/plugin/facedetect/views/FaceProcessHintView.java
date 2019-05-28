package com.tencent.p177mm.plugin.facedetect.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.facedetect.model.C43033h;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.views.FaceProcessHintView */
public class FaceProcessHintView extends LinearLayout {
    private C43033h mbs;
    private int mbt;
    private Animation mbu;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(659);
        this.mbs = null;
        this.mbt = 0;
        this.mbu = null;
        setOrientation(0);
        setMinimumHeight(C4977b.m7371b(getContext(), 36.0f));
        this.mbu = AnimationUtils.loadAnimation(context, C25738R.anim.f8324av);
        this.mbu.setInterpolator(new AccelerateDecelerateInterpolator());
        AppMethodBeat.m2505o(659);
    }

    @SuppressLint({"SetTextI18n"})
    public void setDataAndInvalidate(C43033h c43033h) {
        AppMethodBeat.m2504i(660);
        this.mbs = c43033h;
        if (this.mbs == null || this.mbs.lTR <= 0) {
            C4990ab.m7412e("MicroMsg.FaceProcessHintView", "hy: model invalid");
            AppMethodBeat.m2505o(660);
            return;
        }
        removeAllViews();
        for (int i = 0; i < this.mbs.lTR; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(2130969473, null, false);
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            ((TextView) inflate.findViewById(2131823794)).setText(String.valueOf(i + 1));
            addView(inflate, layoutParams);
        }
        getChildAt(getChildCount() - 1).findViewById(2131823795).setVisibility(8);
        setCurrentProcessing(0);
        invalidate();
        AppMethodBeat.m2505o(660);
    }

    private void setCurrentProcessing(int i) {
        AppMethodBeat.m2504i(661);
        TextView textView = (TextView) getChildAt(i).findViewById(2131823794);
        textView.setTextColor(getResources().getColor(C25738R.color.a69));
        textView.setBackgroundResource(C25738R.drawable.f6689mr);
        AppMethodBeat.m2505o(661);
    }
}
