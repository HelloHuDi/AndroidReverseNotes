package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.tools.MMTruncTextView */
public class MMTruncTextView extends TextView {
    private boolean zGg = false;
    private boolean zGh = false;

    public MMTruncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTruncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107735);
        super.onLayout(z, i, i2, i3, i4);
        if (this.zGg) {
            CharSequence text = getText();
            if (text instanceof Spanned) {
                this.zGh = true;
                setText(TextUtils.ellipsize(text, getPaint(), (float) ((getWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
                this.zGh = false;
                AppMethodBeat.m2505o(107735);
                return;
            }
            AppMethodBeat.m2505o(107735);
            return;
        }
        AppMethodBeat.m2505o(107735);
    }

    /* Access modifiers changed, original: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AppMethodBeat.m2504i(107736);
        super.onTextChanged(charSequence, i, i2, i3);
        this.zGg = !this.zGh;
        AppMethodBeat.m2505o(107736);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107737);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(107737);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(107737);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107738);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(107738);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(107738);
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(107739);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(107739);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(107739);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(107740);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(107740);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(107740);
            return true;
        }
    }
}
