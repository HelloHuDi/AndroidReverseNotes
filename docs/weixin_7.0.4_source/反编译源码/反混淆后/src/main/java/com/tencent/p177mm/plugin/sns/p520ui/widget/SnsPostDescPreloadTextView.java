package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.C37873c;
import com.tencent.p177mm.kiss.widget.textview.C37874f;
import com.tencent.p177mm.kiss.widget.textview.C45416d;
import com.tencent.p177mm.kiss.widget.textview.PLTextView;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.pluginsdk.p597ui.p1669d.C46504a;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView */
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

    /* renamed from: SQ */
    public final C42149a mo47418SQ() {
        AppMethodBeat.m2504i(40512);
        this.rNf = true;
        C42149a textViewConfig = C35147e.cvB().getTextViewConfig();
        AppMethodBeat.m2505o(40512);
        return textViewConfig;
    }

    public void setMaxLines(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(40513);
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i < 7) {
            if (this.rNf) {
                setConfig(C35147e.cvB().cvC());
                this.rNf = false;
            }
            z = false;
        } else {
            if (!this.rNf) {
                setConfig(C35147e.cvB().getTextViewConfig());
                this.rNf = true;
            }
            z = false;
        }
        if (z) {
            C37874f a = C37873c.eNj.mo60603a(getConfig(), getText());
            if (a == null) {
                int postDescWidth = getPostDescWidth();
                if (postDescWidth > 0) {
                    a = C45416d.m83643a(getText(), postDescWidth, getConfig()).mo73210SO();
                }
            }
            if (a != null) {
                setTextLayout(a);
            }
        }
        AppMethodBeat.m2505o(40513);
    }

    /* renamed from: w */
    public final void mo33774w(CharSequence charSequence) {
        AppMethodBeat.m2504i(40514);
        super.mo33774w(charSequence);
        hitCount++;
        AppMethodBeat.m2505o(40514);
    }

    /* renamed from: v */
    public final void mo33773v(CharSequence charSequence) {
        AppMethodBeat.m2504i(40515);
        if (charSequence != null) {
            boolean Xu;
            Context context = getContext();
            String charSequence2 = charSequence.toString();
            float f = getConfig().eOg;
            if (getTag() instanceof C46504a) {
                Xu = C39732a.m67944Xu(((C46504a) getTag()).getUserName());
            } else {
                Xu = false;
            }
            setText(C4100f.m6419a(context, charSequence2, f, Xu), true);
        }
        missCount++;
        AppMethodBeat.m2505o(40515);
    }

    private int getPostDescWidth() {
        AppMethodBeat.m2504i(40516);
        int i;
        if (this.rNg > 0) {
            i = this.rNg;
            AppMethodBeat.m2505o(40516);
            return i;
        }
        i = C35147e.cvB().getViewWidth();
        AppMethodBeat.m2505o(40516);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(40517);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(40517);
    }
}
