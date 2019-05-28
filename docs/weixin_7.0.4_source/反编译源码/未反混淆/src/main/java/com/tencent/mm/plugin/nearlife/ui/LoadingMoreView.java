package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class LoadingMoreView extends LinearLayout {
    private ImageView cDh = ((ImageView) findViewById(R.id.cpb));
    private Context context;
    protected LinearLayout khb;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22967);
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.a9v, this, true);
        this.khb = (LinearLayout) inflate.findViewById(R.id.ai3);
        this.khb.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.cDh.startAnimation(rotateAnimation);
        AppMethodBeat.o(22967);
    }
}
