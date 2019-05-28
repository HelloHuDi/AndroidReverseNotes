package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private boolean rNf = false;
    private int rNg = 0;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSpecialWidth(int i) {
        this.rNg = i;
    }

    public final a SQ() {
        AppMethodBeat.i(40512);
        this.rNf = true;
        a textViewConfig = e.cvB().getTextViewConfig();
        AppMethodBeat.o(40512);
        return textViewConfig;
    }

    public void setMaxLines(int i) {
        boolean z = true;
        AppMethodBeat.i(40513);
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i < 7) {
            if (this.rNf) {
                setConfig(e.cvB().cvC());
                this.rNf = false;
            }
            z = false;
        } else {
            if (!this.rNf) {
                setConfig(e.cvB().getTextViewConfig());
                this.rNf = true;
            }
            z = false;
        }
        if (z) {
            f a = c.eNj.a(getConfig(), getText());
            if (a == null) {
                int postDescWidth = getPostDescWidth();
                if (postDescWidth > 0) {
                    a = d.a(getText(), postDescWidth, getConfig()).SO();
                }
            }
            if (a != null) {
                setTextLayout(a);
            }
        }
        AppMethodBeat.o(40513);
    }

    public final void w(CharSequence charSequence) {
        AppMethodBeat.i(40514);
        super.w(charSequence);
        hitCount++;
        AppMethodBeat.o(40514);
    }

    public final void v(CharSequence charSequence) {
        AppMethodBeat.i(40515);
        if (charSequence != null) {
            boolean Xu;
            Context context = getContext();
            String charSequence2 = charSequence.toString();
            float f = getConfig().eOg;
            if (getTag() instanceof com.tencent.mm.pluginsdk.ui.d.a) {
                Xu = com.tencent.mm.plugin.sns.e.a.Xu(((com.tencent.mm.pluginsdk.ui.d.a) getTag()).getUserName());
            } else {
                Xu = false;
            }
            setText(f.a(context, charSequence2, f, Xu), true);
        }
        missCount++;
        AppMethodBeat.o(40515);
    }

    private int getPostDescWidth() {
        AppMethodBeat.i(40516);
        int i;
        if (this.rNg > 0) {
            i = this.rNg;
            AppMethodBeat.o(40516);
            return i;
        }
        i = e.cvB().getViewWidth();
        AppMethodBeat.o(40516);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(40517);
        super.onMeasure(i, i2);
        AppMethodBeat.o(40517);
    }
}
