package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton */
public class AppBrandOptionButton extends FrameLayout {
    private boolean iVc = true;
    private View iVd;
    private View iVe;
    private TextView iVf;
    private ImageButton iVg;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(87498);
        init(context);
        AppMethodBeat.m2505o(87498);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(87499);
        init(context);
        AppMethodBeat.m2505o(87499);
    }

    private int getActionBarHeight() {
        AppMethodBeat.m2504i(87500);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9776fb);
        AppMethodBeat.m2505o(87500);
        return dimensionPixelSize;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(87501);
        this.iVd = LayoutInflater.from(context).inflate(2130968656, this, false);
        this.iVe = this.iVd.findViewById(2131821128);
        this.iVf = (TextView) this.iVd.findViewById(2131821129);
        this.iVf.setMaxLines(1);
        this.iVf.setClickable(false);
        this.iVf.setBackground(null);
        addView(this.iVd, new LayoutParams(-2, -1, 17));
        this.iVd.setVisibility(8);
        this.iVg = new ImageButton(context);
        this.iVg.setClickable(false);
        this.iVg.setBackground(null);
        addView(this.iVg, new LayoutParams(getActionBarHeight(), -1, 17));
        AppMethodBeat.m2505o(87501);
    }

    public void setAccessibilityLabel(String str) {
        AppMethodBeat.m2504i(87502);
        if (this.iVg == null || this.iVg.getVisibility() != 0) {
            if (this.iVf != null && this.iVf.getVisibility() == 0) {
                this.iVf.setContentDescription(str);
            }
            AppMethodBeat.m2505o(87502);
            return;
        }
        this.iVg.setContentDescription(str);
        AppMethodBeat.m2505o(87502);
    }

    public void setIcon(Bitmap bitmap) {
        AppMethodBeat.m2504i(87503);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(87503);
            return;
        }
        this.iVc = false;
        this.iVg.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        this.iVg.setVisibility(0);
        this.iVd.setVisibility(8);
        AppMethodBeat.m2505o(87503);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(87504);
        this.iVc = false;
        this.iVf.setText(str);
        this.iVd.setVisibility(0);
        this.iVg.setVisibility(8);
        AppMethodBeat.m2505o(87504);
    }

    public void setColor(int i) {
        AppMethodBeat.m2504i(87505);
        this.iVf.setTextColor(i);
        this.iVg.setImageDrawable(getDefaultImageDrawable());
        this.iVg.setColorFilter(i, Mode.SRC_ATOP);
        this.iVg.setBackground(getBackground());
        if (this.iVg.getBackground() != null) {
            this.iVg.getBackground().setColorFilter(i, Mode.SRC_ATOP);
        }
        AppMethodBeat.m2505o(87505);
    }

    public final void reset() {
        AppMethodBeat.m2504i(87506);
        this.iVc = true;
        this.iVd.setVisibility(8);
        this.iVg.setVisibility(0);
        this.iVg.setAlpha(1.0f);
        this.iVg.setImageDrawable(getDefaultImageDrawable());
        AppMethodBeat.m2505o(87506);
    }

    /* Access modifiers changed, original: protected */
    public Drawable getDefaultImageDrawable() {
        AppMethodBeat.m2504i(87507);
        Drawable g = C0380b.m649g(getContext(), C25738R.drawable.avx);
        AppMethodBeat.m2505o(87507);
        return g;
    }

    /* Access modifiers changed, original: 0000 */
    public ImageView getButtonImage() {
        return this.iVg;
    }
}
