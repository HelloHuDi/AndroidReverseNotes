package com.tencent.p177mm.plugin.location.p446ui.impl;

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
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar */
public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView gvq;
    private Context mContext;
    private LinearLayout nRk;
    private Animation nRl;
    private Animation nRm;
    private String username;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar$2 */
    class C123852 implements AnimationListener {
        C123852() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(113732);
            TrackPointAnimAvatar.this.bringToFront();
            TrackPointAnimAvatar.this.nRk.startAnimation(TrackPointAnimAvatar.this.nRl);
            AppMethodBeat.m2505o(113732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar$1 */
    class C283731 implements AnimationListener {
        C283731() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(113731);
            TrackPointAnimAvatar.this.bringToFront();
            TrackPointAnimAvatar.this.nRk.startAnimation(TrackPointAnimAvatar.this.nRm);
            AppMethodBeat.m2505o(113731);
        }
    }

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113733);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113733);
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        AppMethodBeat.m2504i(113734);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(113734);
    }

    private void init() {
        AppMethodBeat.m2504i(113735);
        View inflate = View.inflate(this.mContext, 2130970965, this);
        this.nRk = (LinearLayout) inflate.findViewById(2131828357);
        this.gvq = (ImageView) inflate.findViewById(2131828358);
        bKG();
        AppMethodBeat.m2505o(113735);
    }

    public void setUser(String str) {
        AppMethodBeat.m2504i(113736);
        if (!C5046bo.isNullOrNil(str)) {
            this.username = str;
            if (this.gvq != null) {
                C40460b.m69437r(this.gvq, this.username);
            }
        }
        AppMethodBeat.m2505o(113736);
    }

    private void bKG() {
        AppMethodBeat.m2504i(113737);
        this.nRl = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.nRl.setDuration(500);
        this.nRl.setFillAfter(true);
        this.nRm = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.nRm.setDuration(500);
        this.nRm.setFillAfter(true);
        this.nRl.setAnimationListener(new C283731());
        this.nRm.setAnimationListener(new C123852());
        AppMethodBeat.m2505o(113737);
    }
}
