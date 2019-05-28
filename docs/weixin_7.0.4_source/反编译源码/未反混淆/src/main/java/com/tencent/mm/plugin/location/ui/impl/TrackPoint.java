package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;

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
        AppMethodBeat.i(113720);
        this.mContext = context;
        init(0);
        AppMethodBeat.o(113720);
    }

    public TrackPoint(Context context, ViewManager viewManager) {
        super(context);
        AppMethodBeat.i(113721);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(0);
        AppMethodBeat.o(113721);
    }

    public TrackPoint(Context context, ViewManager viewManager, byte b) {
        super(context);
        AppMethodBeat.i(113722);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(R.drawable.bmi);
        AppMethodBeat.o(113722);
    }

    private void init(int i) {
        AppMethodBeat.i(113723);
        this.nRh = (FrameLayout) View.inflate(this.mContext, R.layout.b0p, null);
        this.nRi = new ImageView(this.mContext);
        if (i > 0) {
            this.nRi.setImageResource(i);
        } else {
            this.nRi.setImageResource(R.drawable.bmj);
        }
        this.nRi.setBackgroundResource(R.drawable.uv);
        this.nRi.setFocusable(true);
        this.nRi.setFocusableInTouchMode(true);
        AppMethodBeat.o(113723);
    }

    public void setOnLocationOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnAvatarOnClickListener(OnClickListener onClickListener) {
    }

    public void setAvatar(String str) {
        AppMethodBeat.i(113724);
        if (str.equals(this.username)) {
            ab.i("MicroMsg.TrackPoint", "skip this set avatar");
            AppMethodBeat.o(113724);
            return;
        }
        this.username = str;
        b.r((ImageView) this.nRh.findViewById(R.id.ez8), str);
        if (this.mViewManager != null) {
            this.mViewManager.updateMarkerView(this.nRh);
        }
        AppMethodBeat.o(113724);
    }

    public double getHeading() {
        return this.nRj;
    }

    public void setHeading(double d) {
        this.nRj = d;
    }

    public final void bKE() {
        AppMethodBeat.i(113725);
        this.aIB = false;
        this.nRh.setVisibility(4);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.nRh);
        }
        AppMethodBeat.o(113725);
    }

    public final void bKF() {
        AppMethodBeat.i(113726);
        this.aIB = true;
        this.nRh.setVisibility(0);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.nRh);
        }
        AppMethodBeat.o(113726);
    }

    public final void z(double d) {
        AppMethodBeat.i(113727);
        this.nRj = d;
        if (this.mViewManager != null) {
            this.mViewManager.updateRotation(this.nRi, (float) d);
        }
        AppMethodBeat.o(113727);
    }

    public double getLatOffest() {
        return this.hOr - this.hOt;
    }

    public double getLongOffset() {
        return this.hOs - this.hOu;
    }

    public final void n(double d, double d2) {
        AppMethodBeat.i(113728);
        if (this.mViewManager != null) {
            this.mViewManager.updateViewLayout(this.nRh, d, d2, false);
            this.mViewManager.updateLocaitonPinLayout(this.nRi, d, d2, false);
        }
        AppMethodBeat.o(113728);
    }

    public final void o(double d, double d2) {
        AppMethodBeat.i(113729);
        if (this.mViewManager != null) {
            this.mViewManager.addView(this.nRh, d, d2);
            this.mViewManager.addView(this.nRi, d, d2);
        }
        AppMethodBeat.o(113729);
    }

    public final void set2Top() {
        AppMethodBeat.i(113730);
        if (this.mViewManager != null) {
            this.mViewManager.setMarker2Top(this.nRh);
            this.mViewManager.setMarker2Top(this.nRi);
        }
        AppMethodBeat.o(113730);
    }
}
