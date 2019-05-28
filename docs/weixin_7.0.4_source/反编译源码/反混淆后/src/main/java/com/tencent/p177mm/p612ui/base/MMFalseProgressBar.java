package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.base.MMFalseProgressBar */
public class MMFalseProgressBar extends ProgressBar {
    /* renamed from: Yn */
    private float f13737Yn;
    private float iUf;
    private float iUg;
    private float iUh;
    private float iUi;
    public boolean iUj;
    private C7306ak mHandler;
    private boolean mIsStart;

    public MMFalseProgressBar(Context context) {
        this(context, null);
        AppMethodBeat.m2504i(106534);
        dzG();
        AppMethodBeat.m2505o(106534);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106535);
        this.mIsStart = false;
        this.f13737Yn = 0.0f;
        this.iUj = true;
        this.mHandler = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(106533);
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.m48386a(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(106533);
                        return;
                    case 1001:
                        MMFalseProgressBar.m48387b(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(106533);
                        return;
                    case 1002:
                        MMFalseProgressBar.m48388c(MMFalseProgressBar.this);
                        AppMethodBeat.m2505o(106533);
                        return;
                    case 1003:
                        MMFalseProgressBar.m48389d(MMFalseProgressBar.this);
                        break;
                }
                AppMethodBeat.m2505o(106533);
            }
        };
        setMax(1000);
        dzG();
        AppMethodBeat.m2505o(106535);
    }

    public final void start() {
        AppMethodBeat.m2504i(106536);
        C4990ab.m7410d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (!this.iUj) {
            AppMethodBeat.m2505o(106536);
        } else if (this.mIsStart) {
            AppMethodBeat.m2505o(106536);
        } else {
            this.mIsStart = true;
            dzG();
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1000);
                this.mHandler.sendEmptyMessage(1001);
            }
            AppMethodBeat.m2505o(106536);
        }
    }

    public final void finish() {
        AppMethodBeat.m2504i(106537);
        C4990ab.m7410d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
        AppMethodBeat.m2505o(106537);
    }

    private void dzG() {
        AppMethodBeat.m2504i(106538);
        if (C5023at.m7477gH(C4996ah.getContext())) {
            this.iUf = 4.0f;
            this.iUg = 1.0f;
            this.iUh = 0.3f;
            this.iUi = 50.0f;
            AppMethodBeat.m2505o(106538);
            return;
        }
        this.iUf = 2.0f;
        this.iUg = 0.5f;
        this.iUh = 0.15f;
        this.iUi = 50.0f;
        AppMethodBeat.m2505o(106538);
    }

    /* renamed from: a */
    static /* synthetic */ void m48386a(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(106539);
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
        AppMethodBeat.m2505o(106539);
    }

    /* renamed from: b */
    static /* synthetic */ void m48387b(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(106540);
        if (mMFalseProgressBar.f13737Yn < 600.0f) {
            mMFalseProgressBar.f13737Yn += mMFalseProgressBar.iUf;
        } else if (mMFalseProgressBar.f13737Yn >= 600.0f && mMFalseProgressBar.f13737Yn < 800.0f) {
            mMFalseProgressBar.f13737Yn += mMFalseProgressBar.iUg;
        } else if (mMFalseProgressBar.f13737Yn >= 800.0f && mMFalseProgressBar.f13737Yn < 920.0f) {
            mMFalseProgressBar.f13737Yn += mMFalseProgressBar.iUh;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.f13737Yn < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.f13737Yn);
        AppMethodBeat.m2505o(106540);
    }

    /* renamed from: c */
    static /* synthetic */ void m48388c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        AppMethodBeat.m2504i(106541);
        if (mMFalseProgressBar.mIsStart) {
            Float valueOf;
            if (mMFalseProgressBar.f13737Yn < 950.0f) {
                mMFalseProgressBar.f13737Yn += mMFalseProgressBar.iUi;
                if (mMFalseProgressBar.f13737Yn <= 950.0f) {
                    f = mMFalseProgressBar.f13737Yn;
                }
                mMFalseProgressBar.f13737Yn = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.f13737Yn += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.f13737Yn) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.f13737Yn < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.f13737Yn = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.f13737Yn);
        }
        AppMethodBeat.m2505o(106541);
    }

    /* renamed from: d */
    static /* synthetic */ void m48389d(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.m2504i(106542);
        mMFalseProgressBar.f13737Yn = 0.0f;
        mMFalseProgressBar.mIsStart = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
        AppMethodBeat.m2505o(106542);
    }
}
