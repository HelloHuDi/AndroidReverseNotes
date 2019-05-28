package com.tencent.p177mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar */
public class MMFalseProgressBar extends ProgressBar {
    /* renamed from: Yn */
    private float f1257Yn;
    private float iUf;
    private float iUg;
    private float iUh;
    private float iUi;
    private boolean iUj;
    private C7306ak mHandler;
    private boolean mIsStart;

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(87444);
        this.mIsStart = false;
        this.f1257Yn = 0.0f;
        this.iUj = true;
        this.mHandler = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(87443);
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.m4747a(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(87443);
                        return;
                    case 1001:
                        MMFalseProgressBar.m4748b(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(87443);
                        return;
                    case 1002:
                        MMFalseProgressBar.m4749c(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(87443);
                        return;
                    case 1003:
                        MMFalseProgressBar.m4750d(MMFalseProgressBar.this);
                        break;
                }
                AppMethodBeat.m2505o(87443);
            }
        };
        setMax(1000);
        if (C5023at.m7477gH(C4996ah.getContext())) {
            this.iUf = 4.0f;
            this.iUg = 1.0f;
            this.iUh = 0.3f;
            this.iUi = 50.0f;
            AppMethodBeat.m2505o(87444);
            return;
        }
        this.iUf = 2.0f;
        this.iUg = 0.5f;
        this.iUh = 0.15f;
        this.iUi = 50.0f;
        AppMethodBeat.m2505o(87444);
    }

    /* renamed from: a */
    static /* synthetic */ void m4747a(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(87445);
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
        AppMethodBeat.m2505o(87445);
    }

    /* renamed from: b */
    static /* synthetic */ void m4748b(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(87446);
        if (mMFalseProgressBar.f1257Yn < 600.0f) {
            mMFalseProgressBar.f1257Yn += mMFalseProgressBar.iUf;
        } else if (mMFalseProgressBar.f1257Yn >= 600.0f && mMFalseProgressBar.f1257Yn < 800.0f) {
            mMFalseProgressBar.f1257Yn += mMFalseProgressBar.iUg;
        } else if (mMFalseProgressBar.f1257Yn >= 800.0f && mMFalseProgressBar.f1257Yn < 920.0f) {
            mMFalseProgressBar.f1257Yn += mMFalseProgressBar.iUh;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.f1257Yn < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.f1257Yn);
        AppMethodBeat.m2505o(87446);
    }

    /* renamed from: c */
    static /* synthetic */ void m4749c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        AppMethodBeat.m2504i(87447);
        if (mMFalseProgressBar.mIsStart) {
            Float valueOf;
            if (mMFalseProgressBar.f1257Yn < 950.0f) {
                mMFalseProgressBar.f1257Yn += mMFalseProgressBar.iUi;
                if (mMFalseProgressBar.f1257Yn <= 950.0f) {
                    f = mMFalseProgressBar.f1257Yn;
                }
                mMFalseProgressBar.f1257Yn = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.f1257Yn += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.f1257Yn) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.f1257Yn < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.f1257Yn = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.f1257Yn);
        }
        AppMethodBeat.m2505o(87447);
    }

    /* renamed from: d */
    static /* synthetic */ void m4750d(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(87448);
        mMFalseProgressBar.f1257Yn = 0.0f;
        mMFalseProgressBar.mIsStart = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
        AppMethodBeat.m2505o(87448);
    }
}
