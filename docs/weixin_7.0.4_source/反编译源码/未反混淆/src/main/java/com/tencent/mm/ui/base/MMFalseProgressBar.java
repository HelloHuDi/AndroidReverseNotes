package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

public class MMFalseProgressBar extends ProgressBar {
    private float Yn;
    private float iUf;
    private float iUg;
    private float iUh;
    private float iUi;
    public boolean iUj;
    private ak mHandler;
    private boolean mIsStart;

    public MMFalseProgressBar(Context context) {
        this(context, null);
        AppMethodBeat.i(106534);
        dzG();
        AppMethodBeat.o(106534);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106535);
        this.mIsStart = false;
        this.Yn = 0.0f;
        this.iUj = true;
        this.mHandler = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(106533);
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.a(MMFalseProgressBar.this);
                        AppMethodBeat.o(106533);
                        return;
                    case 1001:
                        MMFalseProgressBar.b(MMFalseProgressBar.this);
                        AppMethodBeat.o(106533);
                        return;
                    case 1002:
                        MMFalseProgressBar.c(MMFalseProgressBar.this);
                        AppMethodBeat.o(106533);
                        return;
                    case 1003:
                        MMFalseProgressBar.d(MMFalseProgressBar.this);
                        break;
                }
                AppMethodBeat.o(106533);
            }
        };
        setMax(1000);
        dzG();
        AppMethodBeat.o(106535);
    }

    public final void start() {
        AppMethodBeat.i(106536);
        ab.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (!this.iUj) {
            AppMethodBeat.o(106536);
        } else if (this.mIsStart) {
            AppMethodBeat.o(106536);
        } else {
            this.mIsStart = true;
            dzG();
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1000);
                this.mHandler.sendEmptyMessage(1001);
            }
            AppMethodBeat.o(106536);
        }
    }

    public final void finish() {
        AppMethodBeat.i(106537);
        ab.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
        AppMethodBeat.o(106537);
    }

    private void dzG() {
        AppMethodBeat.i(106538);
        if (at.gH(ah.getContext())) {
            this.iUf = 4.0f;
            this.iUg = 1.0f;
            this.iUh = 0.3f;
            this.iUi = 50.0f;
            AppMethodBeat.o(106538);
            return;
        }
        this.iUf = 2.0f;
        this.iUg = 0.5f;
        this.iUh = 0.15f;
        this.iUi = 50.0f;
        AppMethodBeat.o(106538);
    }

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(106539);
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
        AppMethodBeat.o(106539);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(106540);
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
        AppMethodBeat.o(106540);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        AppMethodBeat.i(106541);
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
        AppMethodBeat.o(106541);
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(106542);
        mMFalseProgressBar.Yn = 0.0f;
        mMFalseProgressBar.mIsStart = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
        AppMethodBeat.o(106542);
    }
}
