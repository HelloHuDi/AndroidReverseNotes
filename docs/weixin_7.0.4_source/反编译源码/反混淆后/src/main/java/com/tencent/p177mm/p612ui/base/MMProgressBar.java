package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.ui.base.MMProgressBar */
public class MMProgressBar extends LinearLayout {
    private int max = 100;
    private C7564ap oXA = new C7564ap(new C360561(), false);
    private TextView qyR;
    private int ywb = 0;
    private int ywc = 0;
    private TextView ywd;
    private C30370a ywe;

    /* renamed from: com.tencent.mm.ui.base.MMProgressBar$a */
    public interface C30370a {
        /* renamed from: FO */
        void mo37987FO(int i);
    }

    /* renamed from: com.tencent.mm.ui.base.MMProgressBar$1 */
    class C360561 implements C5015a {
        C360561() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(106704);
            int a = MMProgressBar.this.ywc - MMProgressBar.this.ywb;
            if (a > 0) {
                int i = (int) (((double) a) * 0.6d);
                MMProgressBar mMProgressBar = MMProgressBar.this;
                int b = MMProgressBar.this.ywb;
                if (i <= 0) {
                    i = 1;
                }
                mMProgressBar.ywb = i + b;
                MMProgressBar.m59347b(MMProgressBar.this, MMProgressBar.this.ywb);
                long c = (long) (((MMProgressBar.this.max - a) * 40) / MMProgressBar.this.max);
                MMProgressBar.this.oXA.mo16770ae(c, c);
            }
            AppMethodBeat.m2505o(106704);
            return false;
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106705);
        MMProgressBar.inflate(getContext(), 2130970212, this);
        this.ywd = (TextView) findViewById(2131826084);
        this.qyR = (TextView) findViewById(2131826083);
        AppMethodBeat.m2505o(106705);
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getMax() {
        return this.max;
    }

    public void setProgress(int i) {
        AppMethodBeat.m2504i(106706);
        if (i > this.max) {
            i = this.max;
        }
        this.ywc = i;
        if (this.oXA.doT()) {
            setAutoProgress(true);
        }
        AppMethodBeat.m2505o(106706);
    }

    public int getProgress() {
        return this.ywc;
    }

    public void setAutoProgress(boolean z) {
        AppMethodBeat.m2504i(106707);
        if (z) {
            this.oXA.mo16770ae(40, 40);
            AppMethodBeat.m2505o(106707);
            return;
        }
        this.oXA.stopTimer();
        AppMethodBeat.m2505o(106707);
    }

    public void setTips(CharSequence charSequence) {
        AppMethodBeat.m2504i(106708);
        this.qyR.setText(charSequence);
        AppMethodBeat.m2505o(106708);
    }

    public void setOnProgressChangedListener(C30370a c30370a) {
        this.ywe = c30370a;
    }

    private int getProgressLength() {
        AppMethodBeat.m2504i(106709);
        int width = (getWidth() * this.ywb) / this.max;
        if (width < C4977b.m7371b(getContext(), 20.0f)) {
            width = C4977b.m7371b(getContext(), 20.0f);
        }
        AppMethodBeat.m2505o(106709);
        return width;
    }

    /* renamed from: b */
    static /* synthetic */ void m59347b(MMProgressBar mMProgressBar, int i) {
        AppMethodBeat.m2504i(106710);
        mMProgressBar.ywd.setWidth(mMProgressBar.getProgressLength());
        if (mMProgressBar.ywe != null) {
            mMProgressBar.ywe.mo37987FO(i);
        }
        AppMethodBeat.m2505o(106710);
    }
}
