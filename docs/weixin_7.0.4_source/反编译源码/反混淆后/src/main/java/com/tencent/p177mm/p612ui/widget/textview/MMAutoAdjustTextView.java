package com.tencent.p177mm.p612ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1594cg.C41922a.C41921a;
import com.tencent.p177mm.p612ui.C5229aj;

/* renamed from: com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView */
public class MMAutoAdjustTextView extends TextView {
    private float eOg;
    private float scale;
    /* renamed from: vQ */
    private Paint f13765vQ;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113111);
        MMAutoAdjustTextView.m49229b(context.obtainStyledAttributes(attributeSet, C41921a.MMAutoAdjustTextView));
        init();
        AppMethodBeat.m2505o(113111);
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113112);
        MMAutoAdjustTextView.m49229b(context.obtainStyledAttributes(attributeSet, C41921a.MMAutoAdjustTextView));
        init();
        AppMethodBeat.m2505o(113112);
    }

    private void init() {
        AppMethodBeat.m2504i(113113);
        this.eOg = getTextSize();
        this.scale = C5229aj.m7982dm(getContext());
        this.f13765vQ = new Paint();
        this.f13765vQ.set(getPaint());
        AppMethodBeat.m2505o(113113);
    }

    /* renamed from: b */
    private static void m49229b(TypedArray typedArray) {
        AppMethodBeat.m2504i(113114);
        if (typedArray != null) {
            typedArray.recycle();
        }
        AppMethodBeat.m2505o(113114);
    }

    /* renamed from: Qx */
    private void m49228Qx(int i) {
        AppMethodBeat.m2504i(113115);
        if (i <= 0) {
            AppMethodBeat.m2505o(113115);
            return;
        }
        while (true) {
            measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
            if (((float) getMeasuredWidth()) > ((float) i)) {
                this.eOg -= C5229aj.getDensity(getContext());
                setTextSize(0, this.eOg * this.scale);
            } else {
                AppMethodBeat.m2505o(113115);
                return;
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AppMethodBeat.m2504i(113116);
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        m49228Qx(getWidth());
        AppMethodBeat.m2505o(113116);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(113117);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            m49228Qx(i);
        }
        AppMethodBeat.m2505o(113117);
    }
}
