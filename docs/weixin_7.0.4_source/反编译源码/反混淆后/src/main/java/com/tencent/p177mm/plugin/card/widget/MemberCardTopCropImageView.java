package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView */
public class MemberCardTopCropImageView extends ImageView {
    protected int itemHeight = -1;
    protected int itemPadding = -1;
    protected int itemWidth = -1;
    private float ksR;
    private Path ksS;
    private RectF ksT;
    private float radius;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(88987);
        init();
        AppMethodBeat.m2505o(88987);
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(88988);
        init();
        AppMethodBeat.m2505o(88988);
    }

    public float getShowScale() {
        return this.ksR;
    }

    public void setRadius(float f) {
        AppMethodBeat.m2504i(88989);
        this.radius = f;
        if (f > 0.0f) {
            this.ksS = new Path();
            this.ksT = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        AppMethodBeat.m2505o(88989);
    }

    private void init() {
        AppMethodBeat.m2504i(88990);
        setScaleType(ScaleType.MATRIX);
        this.itemHeight = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f10248vp);
        this.itemPadding = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9966lo) * 2;
        AppMethodBeat.m2505o(88990);
    }

    /* Access modifiers changed, original: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(88991);
        boolean frame;
        if (getDrawable() == null) {
            frame = super.setFrame(i, i2, i3, i4);
            AppMethodBeat.m2505o(88991);
            return frame;
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.itemWidth = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i5 = this.itemWidth;
        int i6 = this.itemHeight;
        if (intrinsicWidth * i6 > intrinsicHeight * i5) {
            this.ksR = ((float) i6) / ((float) intrinsicHeight);
        } else {
            this.ksR = ((float) i5) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.ksR, this.ksR);
        setImageMatrix(imageMatrix);
        frame = super.setFrame(i, i2, i3, i4);
        AppMethodBeat.m2505o(88991);
        return frame;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(88992);
        if (!(this.ksT == null || this.ksS == null)) {
            this.ksT.right = (float) getWidth();
            this.ksT.bottom = (float) getHeight();
            this.ksS.addRoundRect(this.ksT, this.radius, this.radius, Direction.CW);
            canvas.clipPath(this.ksS);
        }
        super.onDraw(canvas);
        AppMethodBeat.m2505o(88992);
    }
}
