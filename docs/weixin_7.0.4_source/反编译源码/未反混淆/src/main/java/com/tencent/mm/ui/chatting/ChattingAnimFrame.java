package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.ba.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String kTY = "";
    private int aKu;
    private int aKv;
    private int mScreenHeight = com.tencent.mm.bz.a.ge(getContext());
    private int xCD = 40;
    List<MMAnimateView> yHT = new ArrayList();
    private int yHU = 30;
    private int yHV = 30;
    private boolean yHW = false;
    private int yHX = 0;
    private ArrayList<Integer> yHY = new ArrayList();

    class a implements AnimationListener {
        a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    class b extends Animation {
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
        private OnLayoutChangeListener yiU = new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(30506);
                b.this.aE();
                AppMethodBeat.o(30506);
            }
        };

        public b(int i, int i2) {
            AppMethodBeat.i(30507);
            this.yIk = i;
            this.mSize = i2;
            this.yIl = false;
            AppMethodBeat.o(30507);
        }

        public b(int i, int i2, boolean z) {
            AppMethodBeat.i(30508);
            this.yIk = i;
            this.mSize = i2;
            this.yIl = z;
            AppMethodBeat.o(30508);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(30509);
            super.initialize(i, i2, i3, i4);
            switch (this.yIk) {
                case 1:
                    this.yIa = ChattingAnimFrame.Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.Y(this.yIa - 0.25f, this.yIa + 0.25f);
                    this.yIc = 1.5f;
                    this.yId = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.yIa = 0.0f;
                    this.yIb = 0.0f;
                    this.yIc = 0.0f;
                    this.yId = 1.0f;
                    setInterpolator(new com.tencent.mm.ui.c.a.a());
                    break;
                case 3:
                    this.yIa = 0.0f;
                    this.yIb = 0.0f;
                    this.yIc = 1.5f;
                    if (this.yIl) {
                        this.yId = ChattingAnimFrame.Y(0.4f, 0.55f);
                    } else {
                        this.yId = ChattingAnimFrame.Y(0.54999995f, 0.85f);
                    }
                    setInterpolator(new com.tencent.mm.ui.c.a.b());
                    break;
                case 999:
                    this.yIa = ChattingAnimFrame.Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.Y(this.yIa - 0.5f, this.yIa + 0.5f);
                    this.yIc = 0.0f;
                    this.yId = 0.0f;
                    this.yIi = 0.8f;
                    this.yIj = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.yIa = ChattingAnimFrame.Y(0.1f, 0.9f);
                    this.yIb = ChattingAnimFrame.Y(this.yIa - 0.5f, this.yIa + 0.5f);
                    this.yIc = -0.2f;
                    this.yId = 1.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.yIk == 0 || this.yIk == 1)) {
                ChattingAnimFrame.this.addOnLayoutChangeListener(this.yiU);
            }
            aE();
            AppMethodBeat.o(30509);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.i(30510);
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
            AppMethodBeat.o(30510);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.i(30511);
            super.finalize();
            ab.i("MicroMsg.ChattingAnimFrame", "finalize!");
            ChattingAnimFrame.this.removeOnLayoutChangeListener(this.yiU);
            AppMethodBeat.o(30511);
        }

        public final void aE() {
            AppMethodBeat.i(30512);
            this.yIe = this.yIa * ((float) ChattingAnimFrame.this.aKu);
            this.yIf = this.yIb * ((float) ChattingAnimFrame.this.aKu);
            if (this.yIk == 2) {
                this.yIg = this.yIc * ((float) ChattingAnimFrame.this.aKv);
                this.yIh = this.yId * ((float) ChattingAnimFrame.this.aKv);
                AppMethodBeat.o(30512);
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
                    AppMethodBeat.o(30512);
                    return;
                }
            }
            this.yIg = this.yIc * ((float) ChattingAnimFrame.this.mScreenHeight);
            this.yIh = this.yId * ((float) ChattingAnimFrame.this.mScreenHeight);
            AppMethodBeat.o(30512);
        }
    }

    class c extends AnimationSet {
        int mSize;
        private long yIn;
        MMAnimateView yIo;

        public c(int i, int i2, long j, boolean z) {
            super(false);
            AppMethodBeat.i(30515);
            this.mSize = i2;
            switch (i) {
                case 0:
                case 1:
                    addAnimation(new b(i, this.mSize));
                    break;
                case 2:
                    addAnimation(new b(999, this.mSize));
                    addAnimation(new b(i, this.mSize));
                    break;
                case 3:
                    addAnimation(new b(i, this.mSize, z));
                    addAnimation(new b(999, this.mSize));
                    break;
                default:
                    addAnimation(new b(0, this.mSize));
                    break;
            }
            setAnimationListener(new a(ChattingAnimFrame.this) {
                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(30513);
                    c cVar = c.this;
                    if (cVar.yIo != null) {
                        cVar.yIo.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(30514);
                                if (c.this.yIo != null) {
                                    c.this.yIo.clearAnimation();
                                    ChattingAnimFrame chattingAnimFrame = ChattingAnimFrame.this;
                                    MMAnimateView mMAnimateView = c.this.yIo;
                                    if (!(mMAnimateView == null || chattingAnimFrame.yHT == null)) {
                                        chattingAnimFrame.yHT.remove(mMAnimateView);
                                        mMAnimateView.recycle();
                                        if (chattingAnimFrame.yHT.isEmpty()) {
                                            mMAnimateView.setLayerType(0, null);
                                            chattingAnimFrame.removeAllViews();
                                            AppMethodBeat.o(30514);
                                            return;
                                        }
                                        mMAnimateView.setVisibility(4);
                                        mMAnimateView.setLayerType(0, null);
                                    }
                                }
                                AppMethodBeat.o(30514);
                            }
                        });
                        AppMethodBeat.o(30513);
                        return;
                    }
                    ab.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    AppMethodBeat.o(30513);
                }
            });
            this.yIn = 500 + j;
            reset();
            setDuration(ChattingAnimFrame.Ok(i));
            AppMethodBeat.o(30515);
        }

        static /* synthetic */ void a(c cVar) {
            AppMethodBeat.i(30516);
            cVar.setStartOffset(cVar.yIn);
            cVar.start();
            AppMethodBeat.o(30516);
        }
    }

    private static String getDataEmojiPath() {
        AppMethodBeat.i(30517);
        if (bo.isNullOrNil(kTY)) {
            kTY = e.eSk.replace("/data/user/0", "/data/data");
            kTY += "/emoji";
        }
        String str = kTY;
        AppMethodBeat.o(30517);
        return str;
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30518);
        AppMethodBeat.o(30518);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(30519);
        super.onFinishInflate();
        this.aKv = getMeasuredHeight();
        this.aKu = getMeasuredWidth();
        ab.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKv));
        AppMethodBeat.o(30519);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(30520);
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
        ab.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.aKu), Integer.valueOf(this.aKv), Boolean.valueOf(this.yHW), Integer.valueOf(this.yHX));
        AppMethodBeat.o(30520);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(30521);
        stop();
        if (dVar == null) {
            ab.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            AppMethodBeat.o(30521);
            return;
        }
        String str = getDataEmojiPath() + "/egg/" + dVar.fMd;
        if (com.tencent.mm.vfs.e.ct(str)) {
            setVisibility(0);
            if (dVar.fMf > 0) {
                this.yHU = dVar.fMf;
                if (this.yHU > 60) {
                    this.yHU = 60;
                }
            } else {
                this.yHU = 30;
            }
            if (dVar.fMg > 0) {
                this.yHV = dVar.fMg;
            } else {
                this.yHV = 30;
            }
            if (dVar.maxSize > 0) {
                this.xCD = dVar.maxSize;
            } else {
                this.xCD = 40;
            }
            ab.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.yHU), Integer.valueOf(this.yHV), Integer.valueOf(this.xCD), Integer.valueOf(dVar.fMe), Integer.valueOf(dVar.cKB));
            long j = 0;
            Oj(this.yHU);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.yHU) {
                    boolean z;
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), (int) Y((float) this.yHV, (float) this.xCD));
                    int i3 = dVar.fMe;
                    if (this.yHY == null || !this.yHY.contains(Integer.valueOf(i2))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    c cVar = new c(i3, fromDPToPix, j, z);
                    MMAnimateView mMAnimateView = new MMAnimateView(getContext());
                    mMAnimateView.setImageFilePath(str);
                    mMAnimateView.setAnimation(cVar);
                    mMAnimateView.setLayerType(2, null);
                    cVar.yIo = mMAnimateView;
                    mMAnimateView.setLayoutParams(new LayoutParams(cVar.mSize, cVar.mSize));
                    this.yHT.add(mMAnimateView);
                    addView(mMAnimateView);
                    i = dVar.fMe;
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
                            j = (long) ((int) (Y(0.0f, 4.0f) * 1000.0f));
                            break;
                    }
                    i = i2 + 1;
                } else {
                    if (this.yHT != null) {
                        for (View view : this.yHT) {
                            if (view != null && (view.getAnimation() instanceof c)) {
                                c.a((c) view.getAnimation());
                            }
                        }
                    }
                    AppMethodBeat.o(30521);
                    return;
                }
            }
        }
        ab.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
        AppMethodBeat.o(30521);
    }

    private void Oj(int i) {
        AppMethodBeat.i(30522);
        if (i <= 0) {
            ab.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            AppMethodBeat.o(30522);
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.yHY != null) {
            this.yHY.clear();
        } else {
            this.yHY = new ArrayList();
        }
        while (this.yHY.size() < i2) {
            int Y = (int) Y(0.0f, (float) i);
            if (!this.yHY.contains(Integer.valueOf(Y))) {
                this.yHY.add(Integer.valueOf(Y));
            }
        }
        AppMethodBeat.o(30522);
    }

    public final void stop() {
        AppMethodBeat.i(30523);
        for (MMAnimateView mMAnimateView : this.yHT) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
        }
        removeAllViews();
        AppMethodBeat.o(30523);
    }

    static float Y(float f, float f2) {
        AppMethodBeat.i(30524);
        float random = (((float) Math.random()) * (f2 - f)) + f;
        AppMethodBeat.o(30524);
        return random;
    }

    static /* synthetic */ long Ok(int i) {
        AppMethodBeat.i(30525);
        switch (i) {
            case 2:
                AppMethodBeat.o(30525);
                return 1200;
            case 3:
                AppMethodBeat.o(30525);
                return 1500;
            default:
                long Y = (long) ((int) Y(4000.0f, 6000.0f));
                AppMethodBeat.o(30525);
                return Y;
        }
    }
}
