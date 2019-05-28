package com.github.henryye.nativeiv;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.p1159iv.NativeTextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeImageView extends FrameLayout {
    private ImageView aLY;
    private NativeTextureView aLZ;
    private C0820b aMa;

    public NativeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public NativeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(115753);
        this.aLY = null;
        this.aLZ = null;
        this.aMa = null;
        this.aLY = new ImageView(getContext());
        this.aLZ = new NativeTextureView(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        addView(this.aLY, layoutParams);
        addView(this.aLZ, layoutParams);
        if (this.aMa == null || this.aMa.mo2511pA() == BitmapType.Undefined || this.aMa.mo2511pA() == BitmapType.Legacy) {
            this.aLY.setVisibility(0);
            this.aLZ.setVisibility(8);
        } else {
            this.aLY.setVisibility(8);
            this.aLZ.setVisibility(0);
        }
        this.aLY.setImageBitmap(null);
        NativeTextureView.m27432pB();
        AppMethodBeat.m2505o(115753);
    }
}
