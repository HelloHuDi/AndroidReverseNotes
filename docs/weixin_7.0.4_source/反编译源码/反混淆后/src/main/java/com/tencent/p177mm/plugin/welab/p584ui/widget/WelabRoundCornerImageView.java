package com.tencent.p177mm.plugin.welab.p584ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.p059a.C37111b;
import android.support.p057v4.p058a.p059a.C37112d;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView */
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
        AppMethodBeat.m2504i(80626);
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(80626);
        } else if (this.uMD <= 0.0f) {
            super.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(80626);
        } else {
            C37111b a = C37112d.m62123a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.uMD, ((float) bitmap.getHeight()) * this.uMD);
            if (a.f15758rf != min) {
                a.f15748HA = false;
                if (C37111b.m62119s(min)) {
                    a.mPaint.setShader(a.f15753Hv);
                } else {
                    a.mPaint.setShader(null);
                }
                a.f15758rf = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
            AppMethodBeat.m2505o(80626);
        }
    }

    public Bitmap getDisplayingBitmap() {
        AppMethodBeat.m2504i(80627);
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof C37111b)) {
            AppMethodBeat.m2505o(80627);
            return null;
        }
        Bitmap bitmap = ((C37111b) drawable).mBitmap;
        AppMethodBeat.m2505o(80627);
        return bitmap;
    }
}
