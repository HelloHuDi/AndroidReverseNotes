package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.OnLayoutChangedLinearLayout;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.KeyboardLinearLayout */
public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    public String TAG;
    private boolean mHasInit;
    private int mHeight;
    private boolean yjC;
    private C44246a yjD;

    /* renamed from: com.tencent.mm.ui.KeyboardLinearLayout$a */
    public interface C44246a {
        /* renamed from: sD */
        void mo7486sD(int i);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105972);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
        this.mHasInit = false;
        this.mHeight = 0;
        this.yjC = false;
        this.TAG += getId();
        AppMethodBeat.m2505o(105972);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
    }

    public void setOnkbdStateListener(C44246a c44246a) {
        this.yjD = c44246a;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105973);
        super.onLayout(z, i, i2, i3, i4);
        mo35253rP(i4);
        AppMethodBeat.m2505o(105973);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: rP */
    public void mo35253rP(int i) {
        AppMethodBeat.m2504i(105974);
        if (this.mHasInit) {
            this.mHeight = this.mHeight < i ? i : this.mHeight;
        } else {
            this.mHasInit = true;
            this.mHeight = i;
            C4990ab.m7417i(this.TAG, "init height:%d", Integer.valueOf(this.mHeight));
            if (this.yjD != null) {
                this.yjD.mo7486sD(-1);
            }
        }
        if (this.mHasInit && !this.yjC && this.mHeight - i > 100) {
            this.yjC = true;
            mo24333sD(-3);
            C4990ab.m7420w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
        if (this.mHasInit && this.yjC && this.mHeight - i <= 100) {
            this.yjC = false;
            mo24333sD(-2);
            C4990ab.m7420w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + i);
        }
        AppMethodBeat.m2505o(105974);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: sD */
    public void mo24333sD(int i) {
        AppMethodBeat.m2504i(105975);
        if (this.yjD != null) {
            this.yjD.mo7486sD(i);
        }
        AppMethodBeat.m2505o(105975);
    }
}
