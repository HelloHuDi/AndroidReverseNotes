package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class MaskLayout extends RelativeLayout {
    private ImageView moR;
    private View view;
    private Drawable yyQ;

    public enum a {
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_ALL;

        static {
            AppMethodBeat.o(106965);
        }
    }

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106966);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.MaskLayout, i, 0);
        this.yyQ = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(106966);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(106967);
        super.onFinishInflate();
        this.view = findViewById(R.id.m5);
        if (this.view == null) {
            ab.d("MicroMsg.MaskLayout", "%s", "not found view by id, new one");
            this.view = new View(getContext());
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.moR = new ImageView(getContext());
        this.moR.setLayoutParams(new LayoutParams(-1, -1));
        this.moR.setImageDrawable(this.yyQ);
        addView(this.moR);
        AppMethodBeat.o(106967);
    }

    public void setMaskBitmap(Bitmap bitmap) {
        AppMethodBeat.i(106968);
        a(a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.moR.setImageBitmap(bitmap);
        AppMethodBeat.o(106968);
    }

    public void setMaskDrawable(Drawable drawable) {
        AppMethodBeat.i(106969);
        a(a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.moR.setImageDrawable(drawable);
        AppMethodBeat.o(106969);
    }

    public final void a(Bitmap bitmap, a aVar) {
        AppMethodBeat.i(106970);
        a(aVar);
        this.moR.setImageBitmap(bitmap);
        AppMethodBeat.o(106970);
    }

    public View getContentView() {
        return this.view;
    }

    private void a(a aVar) {
        AppMethodBeat.i(106971);
        removeView(this.moR);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        switch (aVar) {
            case SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT:
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new LayoutParams(-1, -1);
                break;
        }
        addView(this.moR, layoutParams);
        AppMethodBeat.o(106971);
    }
}
