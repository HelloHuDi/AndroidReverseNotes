package com.tencent.p177mm.p612ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.p069v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1594cg.C41922a.C41921a;

/* renamed from: com.tencent.mm.ui.widget.imageview.WeImageView */
public class WeImageView extends AppCompatImageView {
    private int yDb;
    private boolean zQS = true;

    public WeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112705);
        init(context, attributeSet);
        AppMethodBeat.m2505o(112705);
    }

    public WeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112706);
        init(context, attributeSet);
        AppMethodBeat.m2505o(112706);
    }

    public void setIconColor(int i) {
        AppMethodBeat.m2504i(112707);
        this.yDb = i;
        this.zQS = true;
        invalidate();
        AppMethodBeat.m2505o(112707);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(112708);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C41921a.WeImageView);
        this.yDb = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(112708);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(112709);
        super.onDraw(canvas);
        if (getDrawable() != null && this.zQS) {
            getDrawable().setColorFilter(new PorterDuffColorFilter(this.yDb, Mode.SRC_ATOP));
            this.zQS = false;
        }
        AppMethodBeat.m2505o(112709);
    }
}
