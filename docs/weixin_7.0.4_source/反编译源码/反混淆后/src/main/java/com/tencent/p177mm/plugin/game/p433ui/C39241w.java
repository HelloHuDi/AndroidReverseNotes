package com.tencent.p177mm.plugin.game.p433ui;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;

/* renamed from: com.tencent.mm.plugin.game.ui.w */
public final class C39241w implements OnTouchListener {
    private int mColor;

    public C39241w() {
        this(Color.argb(221, C19395n.CTRL_INDEX, C19395n.CTRL_INDEX, C19395n.CTRL_INDEX));
        AppMethodBeat.m2504i(112218);
        AppMethodBeat.m2505o(112218);
    }

    private C39241w(int i) {
        this.mColor = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(112219);
        int action = motionEvent.getAction();
        Drawable drawable;
        if (action == 0) {
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(this.mColor, Mode.MULTIPLY);
                    imageView.setImageDrawable(drawable);
                }
            } else if (view.getBackground() != null) {
                view.getBackground().setColorFilter(this.mColor, Mode.MULTIPLY);
            }
        } else if (action == 1 || action == 3) {
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            } else {
                drawable = view.getBackground();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            }
        }
        AppMethodBeat.m2505o(112219);
        return false;
    }
}
