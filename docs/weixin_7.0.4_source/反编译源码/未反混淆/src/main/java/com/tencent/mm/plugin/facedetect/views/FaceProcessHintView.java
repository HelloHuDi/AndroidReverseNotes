package com.tencent.mm.plugin.facedetect.views;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public class FaceProcessHintView extends LinearLayout {
    private h mbs;
    private int mbt;
    private Animation mbu;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(659);
        this.mbs = null;
        this.mbt = 0;
        this.mbu = null;
        setOrientation(0);
        setMinimumHeight(b.b(getContext(), 36.0f));
        this.mbu = AnimationUtils.loadAnimation(context, R.anim.av);
        this.mbu.setInterpolator(new AccelerateDecelerateInterpolator());
        AppMethodBeat.o(659);
    }

    @SuppressLint({"SetTextI18n"})
    public void setDataAndInvalidate(h hVar) {
        AppMethodBeat.i(660);
        this.mbs = hVar;
        if (this.mbs == null || this.mbs.lTR <= 0) {
            ab.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
            AppMethodBeat.o(660);
            return;
        }
        removeAllViews();
        for (int i = 0; i < this.mbs.lTR; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.xh, null, false);
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            ((TextView) inflate.findViewById(R.id.bmu)).setText(String.valueOf(i + 1));
            addView(inflate, layoutParams);
        }
        getChildAt(getChildCount() - 1).findViewById(R.id.bmv).setVisibility(8);
        setCurrentProcessing(0);
        invalidate();
        AppMethodBeat.o(660);
    }

    private void setCurrentProcessing(int i) {
        AppMethodBeat.i(661);
        TextView textView = (TextView) getChildAt(i).findViewById(R.id.bmu);
        textView.setTextColor(getResources().getColor(R.color.a69));
        textView.setBackgroundResource(R.drawable.mr);
        AppMethodBeat.o(661);
    }
}
