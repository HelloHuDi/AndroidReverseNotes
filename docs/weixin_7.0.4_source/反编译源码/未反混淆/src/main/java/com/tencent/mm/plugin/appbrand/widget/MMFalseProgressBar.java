package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

public class MMFalseProgressBar extends ProgressBar {
    private float Yn;
    private float iUf;
    private float iUg;
    private float iUh;
    private float iUi;
    private boolean iUj;
    private ak mHandler;
    private boolean mIsStart;

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(87444);
        this.mIsStart = false;
        this.Yn = 0.0f;
        this.iUj = true;
        this.mHandler = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(87443);
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.a(MMFalseProgressBar.this);
                        AppMethodBeat.o(87443);
                        return;
                    case 1001:
                        MMFalseProgressBar.b(MMFalseProgressBar.this);
                        AppMethodBeat.o(87443);
                        return;
                    case 1002:
                        MMFalseProgressBar.c(MMFalseProgressBar.this);
                        AppMethodBeat.o(87443);
                        return;
                    case 1003:
                        MMFalseProgressBar.d(MMFalseProgressBar.this);
                        break;
                }
                AppMethodBeat.o(87443);
            }
        };
        setMax(1000);
        if (at.gH(ah.getContext())) {
            this.iUf = 4.0f;
            this.iUg = 1.0f;
            this.iUh = 0.3f;
            this.iUi = 50.0f;
            AppMethodBeat.o(87444);
            return;
        }
        this.iUf = 2.0f;
        this.iUg = 0.5f;
        this.iUh = 0.15f;
        this.iUi = 50.0f;
        AppMethodBeat.o(87444);
    }

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(87445);
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
        AppMethodBeat.o(87445);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(87446);
        if (mMFalseProgressBar.Yn < 600.0f) {
            mMFalseProgressBar.Yn += mMFalseProgressBar.iUf;
        } else if (mMFalseProgressBar.Yn >= 600.0f && mMFalseProgressBar.Yn < 800.0f) {
            mMFalseProgressBar.Yn += mMFalseProgressBar.iUg;
        } else if (mMFalseProgressBar.Yn >= 800.0f && mMFalseProgressBar.Yn < 920.0f) {
            mMFalseProgressBar.Yn += mMFalseProgressBar.iUh;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.Yn < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.Yn);
        AppMethodBeat.o(87446);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        AppMethodBeat.i(87447);
        if (mMFalseProgressBar.mIsStart) {
            Float valueOf;
            if (mMFalseProgressBar.Yn < 950.0f) {
                mMFalseProgressBar.Yn += mMFalseProgressBar.iUi;
                if (mMFalseProgressBar.Yn <= 950.0f) {
                    f = mMFalseProgressBar.Yn;
                }
                mMFalseProgressBar.Yn = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.Yn += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.Yn) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.Yn < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.Yn = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.Yn);
        }
        AppMethodBeat.o(87447);
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(87448);
        mMFalseProgressBar.Yn = 0.0f;
        mMFalseProgressBar.mIsStart = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
        AppMethodBeat.o(87448);
    }
}
