package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.location_soso.ViewManager;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.TrackPoint */
public class TrackPoint extends LinearLayout {
    private boolean aIB = true;
    private double hOr = -1.0d;
    private double hOs = -1.0d;
    private double hOt = -1.0d;
    private double hOu = -1.0d;
    private Context mContext;
    public ViewManager mViewManager;
    public FrameLayout nRh;
    public ImageView nRi;
    private double nRj = 0.0d;
    private String username;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113720);
        this.mContext = context;
        init(0);
        AppMethodBeat.m2505o(113720);
    }

    public TrackPoint(Context context, ViewManager viewManager) {
        super(context);
        AppMethodBeat.m2504i(113721);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(0);
        AppMethodBeat.m2505o(113721);
    }

    public TrackPoint(Context context, ViewManager viewManager, byte b) {
        super(context);
        AppMethodBeat.m2504i(113722);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(C25738R.drawable.bmi);
        AppMethodBeat.m2505o(113722);
    }

    private void init(int i) {
        AppMethodBeat.m2504i(113723);
        this.nRh = (FrameLayout) View.inflate(this.mContext, 2130970965, null);
        this.nRi = new ImageView(this.mContext);
        if (i > 0) {
            this.nRi.setImageResource(i);
        } else {
            this.nRi.setImageResource(C25738R.drawable.bmj);
        }
        this.nRi.setBackgroundResource(C25738R.drawable.f6900uv);
        this.nRi.setFocusable(true);
        this.nRi.setFocusableInTouchMode(true);
        AppMethodBeat.m2505o(113723);
    }

    public void setOnLocationOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnAvatarOnClickListener(OnClickListener onClickListener) {
    }

    public void setAvatar(String str) {
        AppMethodBeat.m2504i(113724);
        if (str.equals(this.username)) {
            C4990ab.m7416i("MicroMsg.TrackPoint", "skip this set avatar");
            AppMethodBeat.m2505o(113724);
            return;
        }
        this.username = str;
        C40460b.m69437r((ImageView) this.nRh.findViewById(2131828358), str);
        if (this.mViewManager != null) {
            this.mViewManager.updateMarkerView(this.nRh);
        }
        AppMethodBeat.m2505o(113724);
    }

    public double getHeading() {
        return this.nRj;
    }

    public void setHeading(double d) {
        this.nRj = d;
    }

    public final void bKE() {
        AppMethodBeat.m2504i(113725);
        this.aIB = false;
        this.nRh.setVisibility(4);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.nRh);
        }
        AppMethodBeat.m2505o(113725);
    }

    public final void bKF() {
        AppMethodBeat.m2504i(113726);
        this.aIB = true;
        this.nRh.setVisibility(0);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.nRh);
        }
        AppMethodBeat.m2505o(113726);
    }

    /* renamed from: z */
    public final void mo36510z(double d) {
        AppMethodBeat.m2504i(113727);
        this.nRj = d;
        if (this.mViewManager != null) {
            this.mViewManager.updateRotation(this.nRi, (float) d);
        }
        AppMethodBeat.m2505o(113727);
    }

    public double getLatOffest() {
        return this.hOr - this.hOt;
    }

    public double getLongOffset() {
        return this.hOs - this.hOu;
    }

    /* renamed from: n */
    public final void mo36503n(double d, double d2) {
        AppMethodBeat.m2504i(113728);
        if (this.mViewManager != null) {
            this.mViewManager.updateViewLayout(this.nRh, d, d2, false);
            this.mViewManager.updateLocaitonPinLayout(this.nRi, d, d2, false);
        }
        AppMethodBeat.m2505o(113728);
    }

    /* renamed from: o */
    public final void mo36504o(double d, double d2) {
        AppMethodBeat.m2504i(113729);
        if (this.mViewManager != null) {
            this.mViewManager.addView(this.nRh, d, d2);
            this.mViewManager.addView(this.nRi, d, d2);
        }
        AppMethodBeat.m2505o(113729);
    }

    public final void set2Top() {
        AppMethodBeat.m2504i(113730);
        if (this.mViewManager != null) {
            this.mViewManager.setMarker2Top(this.nRh);
            this.mViewManager.setMarker2Top(this.nRi);
        }
        AppMethodBeat.m2505o(113730);
    }
}
