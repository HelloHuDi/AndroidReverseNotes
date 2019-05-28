package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout */
public class PreviewFrameLayout extends RelativeLayout {
    private double mAspectRatio = 1.3333333333333333d;

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public double getmAspectRatio() {
        return this.mAspectRatio;
    }

    public void setAspectRatio(double d) {
        AppMethodBeat.m2504i(809);
        if (d <= 0.0d) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(809);
            throw illegalArgumentException;
        }
        if (this.mAspectRatio != d) {
            this.mAspectRatio = d;
            requestLayout();
        }
        AppMethodBeat.m2505o(809);
    }
}
