package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.p615c.p1344a.C30411b;
import com.tencent.p177mm.p612ui.p615c.p1344a.C40688a;
import com.tencent.p177mm.p707ba.C45180d;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame */
public class ChattingAnimFrame extends FrameLayout {
    private static String kTY = "";
    private int aKu;
    private int aKv;
    private int mScreenHeight = C1338a.m2869ge(getContext());
    private int xCD = 40;
    List<MMAnimateView> yHT = new ArrayList();
    private int yHU = 30;
    private int yHV = 30;
    private boolean yHW = false;
    private int yHX = 0;
    private ArrayList<Integer> yHY = new ArrayList();

    /* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame$a */
    class C23671a implements AnimationListener {
        C23671a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame$b */
    class C23672b extends Animation {
        private int mSize = 0;
        private float yIa;
        private float yIb;
        private float yIc;
        private float yId;
        private float yIe;
        private float yIf;
        private float yIg;
        private float yIh;
        private float yIi;
        private float yIj;
        private int yIk = 0;
        private boolean yIl = false;
        private OnLayoutChangeListener yiU = new C155551();

        /* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame$b$1 */
        class C155551 implements OnLayoutChangeListener {
            C155551() {
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.m2504i(30506);
                C23672b.this.mo39501aE();
                AppMethodBeat.m2505o(30506);
            }
        }

        public C23672b(int i, int i2) {
            AppMethodBeat.m2504i(30507);
            this.yIk = i;
            this.mSize = i2;
            this.yIl = false;
            AppMethodBeat.m2505o(30507);
        }

        public C23672b(int i, int i2, boolean z) {
            AppMethodBeat.m2504i(30508);
            this.yIk = i;
            this.mSize = i2;
            this.yIl = z;
            AppMethodBeat.m2505o(30508);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(30509);
            super.initialize(i, i2, i3, i4);
            switch (this.yIk) {
                case 1:
                    this.yIa = ChattingAnimFrame.m70345Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.m70345Y(this.yIa - 0.25f, this.yIa + 0.25f);
                    this.yIc = 1.5f;
                    this.yId = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.yIa = 0.0f;
                    this.yIb = 0.0f;
                    this.yIc = 0.0f;
                    this.yId = 1.0f;
                    setInterpolator(new C40688a());
                    break;
                case 3:
                    this.yIa = 0.0f;
                    this.yIb = 0.0f;
                    this.yIc = 1.5f;
                    if (this.yIl) {
                        this.yId = ChattingAnimFrame.m70345Y(0.4f, 0.55f);
                    } else {
                        this.yId = ChattingAnimFrame.m70345Y(0.54999995f, 0.85f);
                    }
                    setInterpolator(new C30411b());
                    break;
                case 999:
                    this.yIa = ChattingAnimFrame.m70345Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.m70345Y(this.yIa - 0.5f, this.yIa + 0.5f);
                    this.yIc = 0.0f;
                    this.yId = 0.0f;
                    this.yIi = 0.8f;
                    this.yIj = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.yIa = ChattingAnimFrame.m70345Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.m70345Y(this.yIa - 0.5f, this.yIa + 0.5f);
                    this.yIc = -0.2f;
                    this.yId = 1.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.yIk == 0 || this.yIk == 1)) {
                ChattingAnimFrame.this.addOnLayoutChangeListener(this.yiU);
            }
            mo39501aE();
            AppMethodBeat.m2505o(30509);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.m2504i(30510);
            float f2 = this.yIe;
            float f3 = this.yIg;
            if (this.yIe != this.yIf) {
                f2 = this.yIe + ((this.yIf - this.yIe) * f);
            }
            if (this.yIg != this.yIh) {
                f3 = this.yIg + ((this.yIh - this.yIg) * f);
                if (this.yIk == 2) {
                    f3 -= (float) this.mSize;
                }
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (this.yIi != this.yIj && 3 == this.yIk) {
                f2 = this.yIi + ((this.yIj - this.yIi) * f);
                transformation.getMatrix().postScale(f2, f2);
            }
            AppMethodBeat.m2505o(30510);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.m2504i(30511);
            super.finalize();
            C4990ab.m7416i("MicroMsg.ChattingAnimFrame", "finalize!");
            ChattingAnimFrame.this.removeOnLayoutChangeListener(this.yiU);
            AppMethodBeat.m2505o(30511);
        }

        /* renamed from: aE */
        public final void mo39501aE() {
            AppMethodBeat.m2504i(30512);
            this.yIe = this.yIa * ((float) ChattingAnimFrame.this.aKu);
            this.yIf = this.yIb * ((float) ChattingAnimFrame.this.aKu);
            if (this.yIk == 2) {
                this.yIg = this.yIc * ((float) ChattingAnimFrame.this.aKv);
                this.yIh = this.yId * ((float) ChattingAnimFrame.this.aKv);
                AppMethodBeat.m2505o(30512);
                return;
            }
            if (this.yIk == 3) {
                this.yIg = this.yIc * ((float) ChattingAnimFrame.this.mScreenHeight);
                this.yIh = this.yId * ((float) ChattingAnimFrame.this.mScreenHeight);
                if (ChattingAnimFrame.this.yHW) {
                    this.yIg = (this.yIc * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.yHX);
                    this.yIh = (this.yId * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.yHX);
                }
                if (this.yIh < 0.0f) {
                    this.yIh = 0.0f;
                    AppMethodBeat.m2505o(30512);
                    return;
                }
            }
            this.yIg = this.yIc * ((float) ChattingAnimFrame.this.mScreenHeight);
            this.yIh = this.yId * ((float) ChattingAnimFrame.this.mScreenHeight);
            AppMethodBeat.m2505o(30512);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame$c */
    class C30421c extends AnimationSet {
        int mSize;
        private long yIn;
        MMAnimateView yIo;

        /* renamed from: com.tencent.mm.ui.chatting.ChattingAnimFrame$c$2 */
        class C304232 implements Runnable {
            C304232() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30514);
                if (C30421c.this.yIo != null) {
                    C30421c.this.yIo.clearAnimation();
                    ChattingAnimFrame chattingAnimFrame = ChattingAnimFrame.this;
                    MMAnimateView mMAnimateView = C30421c.this.yIo;
                    if (!(mMAnimateView == null || chattingAnimFrame.yHT == null)) {
                        chattingAnimFrame.yHT.remove(mMAnimateView);
                        mMAnimateView.recycle();
                        if (chattingAnimFrame.yHT.isEmpty()) {
                            mMAnimateView.setLayerType(0, null);
                            chattingAnimFrame.removeAllViews();
                            AppMethodBeat.m2505o(30514);
                            return;
                        }
                        mMAnimateView.setVisibility(4);
                        mMAnimateView.setLayerType(0, null);
                    }
                }
                AppMethodBeat.m2505o(30514);
            }
        }

        public C30421c(int i, int i2, long j, boolean z) {
            super(false);
            AppMethodBeat.m2504i(30515);
            this.mSize = i2;
            switch (i) {
                case 0:
                case 1:
                    addAnimation(new C23672b(i, this.mSize));
                    break;
                case 2:
                    addAnimation(new C23672b(999, this.mSize));
                    addAnimation(new C23672b(i, this.mSize));
                    break;
                case 3:
                    addAnimation(new C23672b(i, this.mSize, z));
                    addAnimation(new C23672b(999, this.mSize));
                    break;
                default:
                    addAnimation(new C23672b(0, this.mSize));
                    break;
            }
            setAnimationListener(new C23671a(ChattingAnimFrame.this) {
                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(30513);
                    C30421c c30421c = C30421c.this;
                    if (c30421c.yIo != null) {
                        c30421c.yIo.post(new C304232());
                        AppMethodBeat.m2505o(30513);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    AppMethodBeat.m2505o(30513);
                }
            });
            this.yIn = 500 + j;
            reset();
            setDuration(ChattingAnimFrame.m70344Ok(i));
            AppMethodBeat.m2505o(30515);
        }

        /* renamed from: a */
        static /* synthetic */ void m48514a(C30421c c30421c) {
            AppMethodBeat.m2504i(30516);
            c30421c.setStartOffset(c30421c.yIn);
            c30421c.start();
            AppMethodBeat.m2505o(30516);
        }
    }

    private static String getDataEmojiPath() {
        AppMethodBeat.m2504i(30517);
        if (C5046bo.isNullOrNil(kTY)) {
            kTY = C6457e.eSk.replace("/data/user/0", "/data/data");
            kTY += "/emoji";
        }
        String str = kTY;
        AppMethodBeat.m2505o(30517);
        return str;
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(30518);
        AppMethodBeat.m2505o(30518);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(30519);
        super.onFinishInflate();
        this.aKv = getMeasuredHeight();
        this.aKu = getMeasuredWidth();
        C4990ab.m7411d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKv));
        AppMethodBeat.m2505o(30519);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(30520);
        super.onLayout(z, i, i2, i3, i4);
        this.aKv = i4 - i2;
        this.aKu = i3 - i;
        if (this.aKv < this.mScreenHeight) {
            this.yHW = true;
            this.yHX = this.mScreenHeight - this.aKv;
        } else {
            this.yHW = false;
            this.yHX = 0;
        }
        C4990ab.m7411d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKv), Boolean.valueOf(this.yHW), Integer.valueOf(this.yHX));
        AppMethodBeat.m2505o(30520);
    }

    /* renamed from: a */
    public final void mo64215a(C45180d c45180d) {
        AppMethodBeat.m2504i(30521);
        stop();
        if (c45180d == null) {
            C4990ab.m7420w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            AppMethodBeat.m2505o(30521);
            return;
        }
        String str = ChattingAnimFrame.getDataEmojiPath() + "/egg/" + c45180d.fMd;
        if (C5730e.m8628ct(str)) {
            setVisibility(0);
            if (c45180d.fMf > 0) {
                this.yHU = c45180d.fMf;
                if (this.yHU > 60) {
                    this.yHU = 60;
                }
            } else {
                this.yHU = 30;
            }
            if (c45180d.fMg > 0) {
                this.yHV = c45180d.fMg;
            } else {
                this.yHV = 30;
            }
            if (c45180d.maxSize > 0) {
                this.xCD = c45180d.maxSize;
            } else {
                this.xCD = 40;
            }
            C4990ab.m7417i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.yHU), Integer.valueOf(this.yHV), Integer.valueOf(this.xCD), Integer.valueOf(c45180d.fMe), Integer.valueOf(c45180d.cKB));
            long j = 0;
            m70343Oj(this.yHU);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.yHU) {
                    boolean z;
                    int fromDPToPix = C1338a.fromDPToPix(getContext(), (int) ChattingAnimFrame.m70345Y((float) this.yHV, (float) this.xCD));
                    int i3 = c45180d.fMe;
                    if (this.yHY == null || !this.yHY.contains(Integer.valueOf(i2))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    C30421c c30421c = new C30421c(i3, fromDPToPix, j, z);
                    MMAnimateView mMAnimateView = new MMAnimateView(getContext());
                    mMAnimateView.setImageFilePath(str);
                    mMAnimateView.setAnimation(c30421c);
                    mMAnimateView.setLayerType(2, null);
                    c30421c.yIo = mMAnimateView;
                    mMAnimateView.setLayoutParams(new LayoutParams(c30421c.mSize, c30421c.mSize));
                    this.yHT.add(mMAnimateView);
                    addView(mMAnimateView);
                    i = c45180d.fMe;
                    int i4 = this.yHU;
                    switch (i) {
                        case 2:
                            long j2;
                            if (i2 < 2) {
                                j2 = 800 + j;
                            } else {
                                j2 = ((long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                            }
                            j = j2;
                            break;
                        case 3:
                            j += (long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                            break;
                        default:
                            j = (long) ((int) (ChattingAnimFrame.m70345Y(0.0f, 4.0f) * 1000.0f));
                            break;
                    }
                    i = i2 + 1;
                } else {
                    if (this.yHT != null) {
                        for (View view : this.yHT) {
                            if (view != null && (view.getAnimation() instanceof C30421c)) {
                                C30421c.m48514a((C30421c) view.getAnimation());
                            }
                        }
                    }
                    AppMethodBeat.m2505o(30521);
                    return;
                }
            }
        }
        C4990ab.m7420w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
        AppMethodBeat.m2505o(30521);
    }

    /* renamed from: Oj */
    private void m70343Oj(int i) {
        AppMethodBeat.m2504i(30522);
        if (i <= 0) {
            C4990ab.m7420w("MicroMsg.ChattingAnimFrame", "count is zero.");
            AppMethodBeat.m2505o(30522);
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.yHY != null) {
            this.yHY.clear();
        } else {
            this.yHY = new ArrayList();
        }
        while (this.yHY.size() < i2) {
            int Y = (int) ChattingAnimFrame.m70345Y(0.0f, (float) i);
            if (!this.yHY.contains(Integer.valueOf(Y))) {
                this.yHY.add(Integer.valueOf(Y));
            }
        }
        AppMethodBeat.m2505o(30522);
    }

    public final void stop() {
        AppMethodBeat.m2504i(30523);
        for (MMAnimateView mMAnimateView : this.yHT) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
        }
        removeAllViews();
        AppMethodBeat.m2505o(30523);
    }

    /* renamed from: Y */
    static float m70345Y(float f, float f2) {
        AppMethodBeat.m2504i(30524);
        float random = (((float) Math.random()) * (f2 - f)) + f;
        AppMethodBeat.m2505o(30524);
        return random;
    }

    /* renamed from: Ok */
    static /* synthetic */ long m70344Ok(int i) {
        AppMethodBeat.m2504i(30525);
        switch (i) {
            case 2:
                AppMethodBeat.m2505o(30525);
                return 1200;
            case 3:
                AppMethodBeat.m2505o(30525);
                return 1500;
            default:
                long Y = (long) ((int) ChattingAnimFrame.m70345Y(4000.0f, 6000.0f));
                AppMethodBeat.m2505o(30525);
                return Y;
        }
    }
}
