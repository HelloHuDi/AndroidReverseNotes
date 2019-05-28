package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;

public class MMProgressBar extends LinearLayout {
    private int max = 100;
    private ap oXA = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(106704);
            int a = MMProgressBar.this.ywc - MMProgressBar.this.ywb;
            if (a > 0) {
                int i = (int) (((double) a) * 0.6d);
                MMProgressBar mMProgressBar = MMProgressBar.this;
                int b = MMProgressBar.this.ywb;
                if (i <= 0) {
                    i = 1;
                }
                mMProgressBar.ywb = i + b;
                MMProgressBar.b(MMProgressBar.this, MMProgressBar.this.ywb);
                long c = (long) (((MMProgressBar.this.max - a) * 40) / MMProgressBar.this.max);
                MMProgressBar.this.oXA.ae(c, c);
            }
            AppMethodBeat.o(106704);
            return false;
        }
    }, false);
    private TextView qyR;
    private int ywb = 0;
    private int ywc = 0;
    private TextView ywd;
    private a ywe;

    public interface a {
        void FO(int i);
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106705);
        inflate(getContext(), R.layout.age, this);
        this.ywd = (TextView) findViewById(R.id.dar);
        this.qyR = (TextView) findViewById(R.id.daq);
        AppMethodBeat.o(106705);
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getMax() {
        return this.max;
    }

    public void setProgress(int i) {
        AppMethodBeat.i(106706);
        if (i > this.max) {
            i = this.max;
        }
        this.ywc = i;
        if (this.oXA.doT()) {
            setAutoProgress(true);
        }
        AppMethodBeat.o(106706);
    }

    public int getProgress() {
        return this.ywc;
    }

    public void setAutoProgress(boolean z) {
        AppMethodBeat.i(106707);
        if (z) {
            this.oXA.ae(40, 40);
            AppMethodBeat.o(106707);
            return;
        }
        this.oXA.stopTimer();
        AppMethodBeat.o(106707);
    }

    public void setTips(CharSequence charSequence) {
        AppMethodBeat.i(106708);
        this.qyR.setText(charSequence);
        AppMethodBeat.o(106708);
    }

    public void setOnProgressChangedListener(a aVar) {
        this.ywe = aVar;
    }

    private int getProgressLength() {
        AppMethodBeat.i(106709);
        int width = (getWidth() * this.ywb) / this.max;
        if (width < b.b(getContext(), 20.0f)) {
            width = b.b(getContext(), 20.0f);
        }
        AppMethodBeat.o(106709);
        return width;
    }

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        AppMethodBeat.i(106710);
        mMProgressBar.ywd.setWidth(mMProgressBar.getProgressLength());
        if (mMProgressBar.ywe != null) {
            mMProgressBar.ywe.FO(i);
        }
        AppMethodBeat.o(106710);
    }
}
