package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView gvq;
    private Context mContext;
    private LinearLayout nRk;
    private Animation nRl;
    private Animation nRm;
    private String username;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113733);
        this.mContext = context;
        init();
        AppMethodBeat.o(113733);
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        AppMethodBeat.i(113734);
        this.mContext = context;
        init();
        AppMethodBeat.o(113734);
    }

    private void init() {
        AppMethodBeat.i(113735);
        View inflate = View.inflate(this.mContext, R.layout.b0p, this);
        this.nRk = (LinearLayout) inflate.findViewById(R.id.ez7);
        this.gvq = (ImageView) inflate.findViewById(R.id.ez8);
        bKG();
        AppMethodBeat.o(113735);
    }

    public void setUser(String str) {
        AppMethodBeat.i(113736);
        if (!bo.isNullOrNil(str)) {
            this.username = str;
            if (this.gvq != null) {
                b.r(this.gvq, this.username);
            }
        }
        AppMethodBeat.o(113736);
    }

    private void bKG() {
        AppMethodBeat.i(113737);
        this.nRl = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.nRl.setDuration(500);
        this.nRl.setFillAfter(true);
        this.nRm = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.nRm.setDuration(500);
        this.nRm.setFillAfter(true);
        this.nRl.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(113731);
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.nRk.startAnimation(TrackPointAnimAvatar.this.nRm);
                AppMethodBeat.o(113731);
            }
        });
        this.nRm.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(113732);
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.nRk.startAnimation(TrackPointAnimAvatar.this.nRl);
                AppMethodBeat.o(113732);
            }
        });
        AppMethodBeat.o(113737);
    }
}
