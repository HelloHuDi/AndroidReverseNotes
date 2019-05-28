package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    public String TAG;
    private boolean mHasInit;
    private int mHeight;
    private boolean yjC;
    private a yjD;

    public interface a {
        void sD(int i);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105972);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
        this.mHasInit = false;
        this.mHeight = 0;
        this.yjC = false;
        this.TAG += getId();
        AppMethodBeat.o(105972);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
    }

    public void setOnkbdStateListener(a aVar) {
        this.yjD = aVar;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105973);
        super.onLayout(z, i, i2, i3, i4);
        rP(i4);
        AppMethodBeat.o(105973);
    }

    /* Access modifiers changed, original: protected */
    public void rP(int i) {
        AppMethodBeat.i(105974);
        if (this.mHasInit) {
            this.mHeight = this.mHeight < i ? i : this.mHeight;
        } else {
            this.mHasInit = true;
            this.mHeight = i;
            ab.i(this.TAG, "init height:%d", Integer.valueOf(this.mHeight));
            if (this.yjD != null) {
                this.yjD.sD(-1);
            }
        }
        if (this.mHasInit && !this.yjC && this.mHeight - i > 100) {
            this.yjC = true;
            sD(-3);
            ab.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
        if (this.mHasInit && this.yjC && this.mHeight - i <= 100) {
            this.yjC = false;
            sD(-2);
            ab.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
        AppMethodBeat.o(105974);
    }

    /* Access modifiers changed, original: protected */
    public void sD(int i) {
        AppMethodBeat.i(105975);
        if (this.yjD != null) {
            this.yjD.sD(i);
        }
        AppMethodBeat.o(105975);
    }
}
