package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;

public class LoadingMoreView extends LinearLayout {
    private ImageView cDh;
    private Context context;
    protected LinearLayout khb;
    protected LinearLayout khc;
    protected LinearLayout rjW;
    protected LinearLayout rjX;
    protected TextView rjY;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38280);
        this.context = context;
        init();
        AppMethodBeat.o(38280);
    }

    public LoadingMoreView(Context context) {
        super(context);
        AppMethodBeat.i(38281);
        this.context = context;
        init();
        AppMethodBeat.o(38281);
    }

    private void init() {
        AppMethodBeat.i(38282);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.avv, this, true);
        this.cDh = (ImageView) findViewById(R.id.ai4);
        this.khb = (LinearLayout) inflate.findViewById(R.id.ai3);
        this.khc = (LinearLayout) inflate.findViewById(R.id.ai5);
        this.rjW = (LinearLayout) inflate.findViewById(R.id.ekf);
        this.rjX = (LinearLayout) inflate.findViewById(R.id.ekg);
        this.rjY = (TextView) inflate.findViewById(R.id.ekh);
        this.khb.setVisibility(0);
        this.khc.setVisibility(8);
        this.rjW.setVisibility(8);
        this.rjX.setVisibility(8);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.cDh.startAnimation(rotateAnimation);
        AppMethodBeat.o(38282);
    }

    public final void lc(boolean z) {
        AppMethodBeat.i(38283);
        this.khb.setVisibility(8);
        if (z) {
            this.rjW.setVisibility(0);
            this.khc.setVisibility(8);
        } else {
            this.khc.setVisibility(0);
            this.rjW.setVisibility(8);
        }
        this.rjX.setVisibility(8);
        AppMethodBeat.o(38283);
    }

    public final void bf(int i, String str) {
        CharSequence str2;
        AppMethodBeat.i(138385);
        this.khb.setVisibility(8);
        this.rjW.setVisibility(8);
        this.khc.setVisibility(8);
        this.rjX.setVisibility(0);
        if (bo.isNullOrNil(str2)) {
            if (i == 2001) {
                str2 = getContext().getResources().getString(R.string.ent);
            } else if (i == 2003) {
                str2 = getContext().getResources().getString(R.string.ejx);
            } else if (i == 2004) {
                str2 = getContext().getResources().getString(R.string.enu);
            } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                str2 = getContext().getResources().getString(R.string.g97);
            } else if (i == 203) {
                str2 = getContext().getResources().getString(R.string.eoo);
            }
        }
        this.rjY.setText(str2);
        AppMethodBeat.o(138385);
    }
}
