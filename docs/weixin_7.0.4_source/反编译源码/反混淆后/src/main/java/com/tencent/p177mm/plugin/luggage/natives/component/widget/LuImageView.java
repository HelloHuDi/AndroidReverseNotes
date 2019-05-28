package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuImageView */
public class LuImageView extends AppCompatImageView {
    public LuImageView(Context context) {
        super(context);
    }

    public LuImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        Path path;
        AppMethodBeat.m2504i(116891);
        Drawable background = getBackground();
        if (background instanceof C3431a) {
            C3431a c3431a = (C3431a) background;
            if (c3431a.oiI == null) {
                c3431a.oiI = c3431a.bMS();
                if (c3431a.oiI == null) {
                    path = null;
                }
            }
            path = c3431a.mo7868j(c3431a.oiI);
        } else {
            path = null;
        }
        if (path != null) {
            canvas.save();
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        if (path != null) {
            canvas.restore();
        }
        AppMethodBeat.m2505o(116891);
    }
}
