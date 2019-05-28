package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;

public class MMSightRecordButton extends FrameLayout {
    private static final int LO = ViewConfiguration.getTapTimeout();
    private static final float oAQ = (((float) ah.getContext().getResources().getDimensionPixelSize(R.dimen.a66)) / ((float) ah.getContext().getResources().getDimensionPixelSize(R.dimen.a65)));
    private boolean enable = true;
    private ak fbD = new ak(Looper.getMainLooper());
    private boolean isAnimating = false;
    private float neH = -1.0f;
    private long oAR = -1;
    private View oAS;
    private View oAT;
    private MMSightCircularProgressBar oAU;
    private boolean oAV = false;
    private boolean oAW = false;
    private ViewPropertyAnimator oAX;
    private ViewPropertyAnimator oAY;
    private ValueAnimator oAZ;
    private ViewPropertyAnimator oBa;
    private ViewPropertyAnimator oBb;
    private boolean oBc = false;
    private int oBd;
    private int oBe;
    private d oBf;
    private b oBg;
    private c oBh;
    private a oBi;
    private Drawable oBj;
    private Drawable oBk;
    private boolean oBl = false;
    private boolean oBm = false;
    private Runnable oBn = new Runnable() {
        public final void run() {
            AppMethodBeat.i(55097);
            ab.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oAV), Boolean.valueOf(MMSightRecordButton.this.oAW));
            if (!MMSightRecordButton.this.oAV) {
                MMSightRecordButton.this.oAW = true;
                if (MMSightRecordButton.this.oBg != null) {
                    MMSightRecordButton.this.oBg.m21if();
                }
            }
            AppMethodBeat.o(55097);
        }
    };
    private Runnable oBo = new Runnable() {
        public final void run() {
            AppMethodBeat.i(55098);
            ab.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", Boolean.valueOf(MMSightRecordButton.this.oBc));
            if (MMSightRecordButton.this.oBc) {
                MMSightRecordButton.f(MMSightRecordButton.this);
            }
            AppMethodBeat.o(55098);
        }
    };
    private View progressBar;

    public interface d {
        void bnX();
    }

    public interface a {
        void bQu();
    }

    public interface b {
        void bnU();

        void bnV();

        /* renamed from: if */
        void m21if();
    }

    public interface c {
        void uF(int i);

        void uG(int i);
    }

    static {
        AppMethodBeat.i(55116);
        AppMethodBeat.o(55116);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55100);
        init();
        AppMethodBeat.o(55100);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(55101);
        init();
        AppMethodBeat.o(55101);
    }

    private void init() {
        AppMethodBeat.i(55102);
        ab.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", Integer.valueOf(500), Integer.valueOf(LO));
        this.oBj = getContext().getResources().getDrawable(R.drawable.v3);
        this.oBk = getContext().getResources().getDrawable(R.drawable.v4);
        this.oBd = -2236963;
        this.oBe = this.oBd;
        if (this.oBk instanceof GradientDrawable) {
            ((GradientDrawable) this.oBk).setColor(this.oBd);
        }
        v.hu(getContext()).inflate(R.layout.agz, this, true);
        this.oAS = findViewById(R.id.dbj);
        this.oAT = findViewById(R.id.dbi);
        this.progressBar = findViewById(R.id.oa);
        this.oAU = (MMSightCircularProgressBar) findViewById(R.id.dbk);
        this.oAS.setBackgroundDrawable(this.oBj);
        this.oAT.setBackgroundDrawable(this.oBk);
        this.enable = true;
        AppMethodBeat.o(55102);
    }

    public void setHighLightOuter(int i) {
        AppMethodBeat.i(55103);
        this.oBe = i;
        if (this.oBk instanceof GradientDrawable) {
            ((GradientDrawable) this.oBk).setColor(i);
        }
        AppMethodBeat.o(55103);
    }

    public void setSimpleTapCallback(d dVar) {
        this.oBf = dVar;
    }

    public void setLongPressCallback(b bVar) {
        this.oBg = bVar;
    }

    public void setLongPressScrollCallback(c cVar) {
        this.oBh = cVar;
    }

    public void setErrorPressCallback(a aVar) {
        this.oBi = aVar;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.i(55104);
        ab.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", Boolean.valueOf(z));
        this.enable = z;
        AppMethodBeat.o(55104);
    }

    public final void bQs() {
        AppMethodBeat.i(55105);
        ab.i("MicroMsg.MMSightRecordButton", "showProgressBar");
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(55105);
    }

    public final void bQt() {
        AppMethodBeat.i(55106);
        ab.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(55106);
    }

    public final void a(int i, int i2, final com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a aVar) {
        AppMethodBeat.i(55107);
        ab.c("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), aVar);
        this.oAU.setInitProgress(0);
        this.oAU.setMaxProgress(100);
        this.oAU.setDuration(i);
        this.oAU.setVisibility(0);
        this.oAU.setCircularColor(i2);
        this.oAU.setProgressCallback(new com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a() {
            public final void bnW() {
                AppMethodBeat.i(55091);
                ab.c("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
                MMSightRecordButton.this.bgk();
                MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(55090);
                        ab.c("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                        if (aVar != null) {
                            aVar.bnW();
                        }
                        AppMethodBeat.o(55090);
                    }
                });
                AppMethodBeat.o(55091);
            }
        });
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oAU;
        ab.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", Integer.valueOf(mMSightCircularProgressBar.oAI), Integer.valueOf(mMSightCircularProgressBar.oAJ), Integer.valueOf(mMSightCircularProgressBar.duration));
        mMSightCircularProgressBar.oAH = 0.0f;
        mMSightCircularProgressBar.oAL = new c((float) mMSightCircularProgressBar.oAI, (float) mMSightCircularProgressBar.oAJ, mMSightCircularProgressBar.duration);
        c cVar = mMSightCircularProgressBar.oAL;
        ab.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new com.tencent.mm.plugin.mmsight.ui.c.a() {
            public final void aO(float f) {
                AppMethodBeat.i(55080);
                MMSightCircularProgressBar.this.oAH = f;
                MMSightCircularProgressBar.this.invalidate();
                AppMethodBeat.o(55080);
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(55081);
                ab.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55079);
                        if (MMSightCircularProgressBar.this.oAM != null) {
                            MMSightCircularProgressBar.this.oAM.bnW();
                        }
                        AppMethodBeat.o(55079);
                    }
                });
                AppMethodBeat.o(55081);
            }
        });
        cVar.oCg = r2;
        c cVar2 = mMSightCircularProgressBar.oAL;
        ab.i("MicroMsg.ProgressHandlerAnimator", "Start");
        cVar2.cFy = true;
        cVar2.eyR = bo.yz();
        cVar2.fJs.ae(20, 20);
        AppMethodBeat.o(55107);
    }

    public final void bgk() {
        AppMethodBeat.i(55108);
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oAU;
        mMSightCircularProgressBar.oAM = null;
        mMSightCircularProgressBar.oAI = 0;
        mMSightCircularProgressBar.oAJ = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.cFy = false;
        if (mMSightCircularProgressBar.oAL != null) {
            c cVar = mMSightCircularProgressBar.oAL;
            cVar.cFy = false;
            cVar.eyR = 0;
            mMSightCircularProgressBar.oAL = null;
        }
        this.oAU.setVisibility(8);
        AppMethodBeat.o(55108);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(55109);
        this.isAnimating = true;
        if (this.oBa != null) {
            this.oBa.cancel();
            this.oBa = null;
        }
        this.oBa = this.oAS.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBa.setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(55094);
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
                AppMethodBeat.o(55094);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55095);
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
                AppMethodBeat.o(55095);
            }
        }).setDuration(150).start();
        if (this.oBb != null) {
            this.oBb.cancel();
            this.oBb = null;
        }
        this.oBb = this.oAT.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBb.setDuration(150).start();
        if (this.oBe != this.oBd) {
            if (this.oAZ != null) {
                this.oAZ.cancel();
            }
            this.oAZ = ObjectAnimator.ofInt(this.oBk, "color", new int[]{this.oBd, this.oBe});
            this.oAZ.setDuration(150);
            this.oAZ.setEvaluator(a.bQq());
            this.oAZ.start();
        }
        AppMethodBeat.o(55109);
    }

    public void setVisibility(final int i) {
        AppMethodBeat.i(55110);
        ab.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", Boolean.valueOf(this.isAnimating));
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(55096);
                    MMSightRecordButton.a(MMSightRecordButton.this, i);
                    AppMethodBeat.o(55096);
                }
            }, 150);
            AppMethodBeat.o(55110);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.o(55110);
    }

    public final void reset() {
        AppMethodBeat.i(55111);
        setClipChildren(false);
        this.enable = true;
        this.oAS.setScaleX(1.0f);
        this.oAS.setScaleY(1.0f);
        this.oAT.setScaleX(1.0f);
        this.oAT.setScaleY(1.0f);
        this.progressBar.setVisibility(8);
        bgk();
        AppMethodBeat.o(55111);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(55112);
        if (this.enable) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.oBc = true;
                    this.oAR = System.currentTimeMillis();
                    this.oAV = false;
                    this.oAW = false;
                    this.neH = motionEvent.getRawY();
                    if (this.oBg != null) {
                        this.oBg.bnV();
                    }
                    this.fbD.postDelayed(this.oBn, 550);
                    this.fbD.postDelayed(this.oBo, 250);
                    this.oBm = true;
                    this.oBl = true;
                    break;
                case 1:
                case 3:
                    this.oBc = false;
                    this.fbD.removeCallbacks(this.oBo, Integer.valueOf(LO));
                    this.fbD.removeCallbacks(this.oBn);
                    if (!(this.oAX == null || this.oAY == null)) {
                        this.oAX.cancel();
                        this.oAY.cancel();
                    }
                    final long currentTimeMillis = System.currentTimeMillis() - this.oAR;
                    ab.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", Boolean.valueOf(this.oAW), Boolean.valueOf(this.oAV), Long.valueOf(this.oAR), Long.valueOf(currentTimeMillis));
                    bgk();
                    a(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(55099);
                            if (MMSightRecordButton.this.oAR > 0 && currentTimeMillis <= 500) {
                                ab.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oAV), Boolean.valueOf(MMSightRecordButton.this.oAW));
                                MMSightRecordButton.this.oAV = true;
                                if (!(MMSightRecordButton.this.oAW || MMSightRecordButton.this.oBf == null)) {
                                    MMSightRecordButton.this.oBf.bnX();
                                    AppMethodBeat.o(55099);
                                    return;
                                }
                            } else if (MMSightRecordButton.this.oAW) {
                                ab.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                                if (MMSightRecordButton.this.oBg != null) {
                                    MMSightRecordButton.this.oBg.bnU();
                                    AppMethodBeat.o(55099);
                                    return;
                                }
                            } else {
                                ab.i("MicroMsg.MMSightRecordButton", "error action up");
                                if (MMSightRecordButton.this.oBi != null) {
                                    MMSightRecordButton.this.oBi.bQu();
                                }
                            }
                            AppMethodBeat.o(55099);
                        }
                    });
                    break;
                case 2:
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.oAW) {
                        if (this.neH > 0.0f) {
                            float abs = Math.abs(rawY - this.neH);
                            int min;
                            c cVar;
                            if (rawY >= this.neH || abs < 10.0f) {
                                if (rawY > this.neH && abs >= 10.0f) {
                                    ab.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBm));
                                    min = Math.min(min, 3);
                                    if (this.oBh != null) {
                                        cVar = this.oBh;
                                        if (this.oBm) {
                                            min = 1;
                                        }
                                        cVar.uG(min);
                                    }
                                    this.oBm = false;
                                    this.neH = rawY;
                                    break;
                                }
                            }
                            ab.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBl));
                            min = Math.min(min, 3);
                            if (this.oBh != null) {
                                cVar = this.oBh;
                                if (this.oBl) {
                                    min = 1;
                                }
                                cVar.uF(min);
                            }
                            this.neH = rawY;
                            this.oBl = false;
                            break;
                        }
                        this.neH = motionEvent.getRawY();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(55112);
        } else {
            ab.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
            AppMethodBeat.o(55112);
        }
        return true;
    }

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        AppMethodBeat.i(55115);
        mMSightRecordButton.isAnimating = true;
        if (mMSightRecordButton.oAX != null) {
            mMSightRecordButton.oAX.cancel();
            mMSightRecordButton.oAX = null;
        }
        mMSightRecordButton.oAX = mMSightRecordButton.oAS.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.oAX.setListener(new AnimatorListenerAdapter() {
            final /* synthetic */ AnimatorListenerAdapter oBs = null;

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(55092);
                MMSightRecordButton.this.isAnimating = true;
                if (this.oBs != null) {
                    this.oBs.onAnimationStart(animator);
                }
                AppMethodBeat.o(55092);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(55093);
                MMSightRecordButton.this.isAnimating = false;
                if (this.oBs != null) {
                    this.oBs.onAnimationEnd(animator);
                }
                AppMethodBeat.o(55093);
            }
        }).setDuration(150).start();
        if (mMSightRecordButton.oAY != null) {
            mMSightRecordButton.oAY.cancel();
            mMSightRecordButton.oAY = null;
        }
        mMSightRecordButton.oAY = mMSightRecordButton.oAT.animate().scaleX(oAQ).scaleY(oAQ);
        mMSightRecordButton.oAY.setDuration(150).start();
        if (mMSightRecordButton.oBe != mMSightRecordButton.oBd) {
            if (mMSightRecordButton.oAZ != null) {
                mMSightRecordButton.oAZ.cancel();
            }
            mMSightRecordButton.oAZ = ObjectAnimator.ofInt(mMSightRecordButton.oBk, "color", new int[]{mMSightRecordButton.oBe, mMSightRecordButton.oBd});
            mMSightRecordButton.oAZ.setDuration(150);
            mMSightRecordButton.oAZ.setEvaluator(a.bQq());
            mMSightRecordButton.oAZ.start();
        }
        AppMethodBeat.o(55115);
    }
}
