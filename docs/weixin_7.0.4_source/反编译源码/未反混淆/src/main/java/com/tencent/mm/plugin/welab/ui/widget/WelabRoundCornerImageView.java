package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.b;
import android.support.v4.a.a.d;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WelabRoundCornerImageView extends ImageView {
    private float uMD;

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCornerRadiusPercent(float f) {
        this.uMD = f;
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(80626);
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.o(80626);
        } else if (this.uMD <= 0.0f) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.o(80626);
        } else {
            b a = d.a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.uMD, ((float) bitmap.getHeight()) * this.uMD);
            if (a.rf != min) {
                a.HA = false;
                if (b.s(min)) {
                    a.mPaint.setShader(a.Hv);
                } else {
                    a.mPaint.setShader(null);
                }
                a.rf = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
            AppMethodBeat.o(80626);
        }
    }

    public Bitmap getDisplayingBitmap() {
        AppMethodBeat.i(80627);
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof b)) {
            AppMethodBeat.o(80627);
            return null;
        }
        Bitmap bitmap = ((b) drawable).mBitmap;
        AppMethodBeat.o(80627);
        return bitmap;
    }
}
