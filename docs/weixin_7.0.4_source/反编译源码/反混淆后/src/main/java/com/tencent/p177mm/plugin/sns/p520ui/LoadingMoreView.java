package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.sns.ui.LoadingMoreView */
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
        AppMethodBeat.m2504i(38280);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38280);
    }

    public LoadingMoreView(Context context) {
        super(context);
        AppMethodBeat.m2504i(38281);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38281);
    }

    private void init() {
        AppMethodBeat.m2504i(38282);
        View inflate = LayoutInflater.from(this.context).inflate(2130970784, this, true);
        this.cDh = (ImageView) findViewById(2131822251);
        this.khb = (LinearLayout) inflate.findViewById(2131822250);
        this.khc = (LinearLayout) inflate.findViewById(2131822252);
        this.rjW = (LinearLayout) inflate.findViewById(2131827811);
        this.rjX = (LinearLayout) inflate.findViewById(2131827812);
        this.rjY = (TextView) inflate.findViewById(2131827813);
        this.khb.setVisibility(0);
        this.khc.setVisibility(8);
        this.rjW.setVisibility(8);
        this.rjX.setVisibility(8);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.cDh.startAnimation(rotateAnimation);
        AppMethodBeat.m2505o(38282);
    }

    /* renamed from: lc */
    public final void mo55600lc(boolean z) {
        AppMethodBeat.m2504i(38283);
        this.khb.setVisibility(8);
        if (z) {
            this.rjW.setVisibility(0);
            this.khc.setVisibility(8);
        } else {
            this.khc.setVisibility(0);
            this.rjW.setVisibility(8);
        }
        this.rjX.setVisibility(8);
        AppMethodBeat.m2505o(38283);
    }

    /* renamed from: bf */
    public final void mo55599bf(int i, String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(138385);
        this.khb.setVisibility(8);
        this.rjW.setVisibility(8);
        this.khc.setVisibility(8);
        this.rjX.setVisibility(0);
        if (C5046bo.isNullOrNil(str2)) {
            if (i == 2001) {
                str2 = getContext().getResources().getString(C25738R.string.ent);
            } else if (i == 2003) {
                str2 = getContext().getResources().getString(C25738R.string.ejx);
            } else if (i == 2004) {
                str2 = getContext().getResources().getString(C25738R.string.enu);
            } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                str2 = getContext().getResources().getString(C25738R.string.g97);
            } else if (i == 203) {
                str2 = getContext().getResources().getString(C25738R.string.eoo);
            }
        }
        this.rjY.setText(str2);
        AppMethodBeat.m2505o(138385);
    }
}
