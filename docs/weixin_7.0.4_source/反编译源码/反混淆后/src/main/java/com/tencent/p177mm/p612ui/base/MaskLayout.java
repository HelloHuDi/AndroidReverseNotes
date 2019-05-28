package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MaskLayout */
public class MaskLayout extends RelativeLayout {
    private ImageView moR;
    private View view;
    private Drawable yyQ;

    /* renamed from: com.tencent.mm.ui.base.MaskLayout$a */
    public enum C23622a {
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_ALL;

        static {
            AppMethodBeat.m2505o(106965);
        }
    }

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106966);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.MaskLayout, i, 0);
        this.yyQ = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(106966);
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(106967);
        super.onFinishInflate();
        this.view = findViewById(2131821019);
        if (this.view == null) {
            C4990ab.m7411d("MicroMsg.MaskLayout", "%s", "not found view by id, new one");
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
        AppMethodBeat.m2505o(106967);
    }

    public void setMaskBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(106968);
        m48409a(C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.moR.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(106968);
    }

    public void setMaskDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(106969);
        m48409a(C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.moR.setImageDrawable(drawable);
        AppMethodBeat.m2505o(106969);
    }

    /* renamed from: a */
    public final void mo48741a(Bitmap bitmap, C23622a c23622a) {
        AppMethodBeat.m2504i(106970);
        m48409a(c23622a);
        this.moR.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(106970);
    }

    public View getContentView() {
        return this.view;
    }

    /* renamed from: a */
    private void m48409a(C23622a c23622a) {
        AppMethodBeat.m2504i(106971);
        removeView(this.moR);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        switch (c23622a) {
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
        AppMethodBeat.m2505o(106971);
    }
}
