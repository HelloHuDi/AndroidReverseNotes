package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;

public class MMSwitchBtn extends View {
    private int edgePadding;
    private int maxHeight;
    private int maxWidth;
    private int nfE;
    private Paint oJk = new Paint(1);
    private float rLO;
    private float rLP;
    private long zMI;
    private int zMJ;
    private int zMK;
    private int zML;
    private boolean zMM = false;
    private boolean zMN = false;
    private float zMO;
    private float zMP;
    private int zMQ;
    private int zMR;
    private int zMS;
    private int zMT;
    public boolean zMU = false;
    private RectF zMV = new RectF();
    private RectF zMW = new RectF();
    private int zMX;
    private int zMY;
    private int zMZ;
    private String zNa;
    private String zNb;
    private b zNc = new b(this, (byte) 0);
    private a zNd;

    class b extends Animation {
        int direction;
        float startX;
        long zNe;

        /* synthetic */ b(MMSwitchBtn mMSwitchBtn, byte b) {
            this();
        }

        private b() {
            AppMethodBeat.i(112576);
            this.direction = 0;
            this.startX = 0.0f;
            this.zNe = 0;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new AnimationListener(MMSwitchBtn.this) {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    boolean z = true;
                    AppMethodBeat.i(112575);
                    if (MMSwitchBtn.this.zMU != (b.this.direction == 1)) {
                        MMSwitchBtn mMSwitchBtn = MMSwitchBtn.this;
                        if (b.this.direction != 1) {
                            z = false;
                        }
                        mMSwitchBtn.zMU = z;
                        MMSwitchBtn.this.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(112574);
                                if (MMSwitchBtn.this.zNd != null) {
                                    MMSwitchBtn.this.zNd.di(MMSwitchBtn.this.zMU);
                                }
                                AppMethodBeat.o(112574);
                            }
                        });
                    }
                    MMSwitchBtn.this.zMM = false;
                    AppMethodBeat.o(112575);
                }
            });
            AppMethodBeat.o(112576);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.i(112577);
            if (this.direction == 0) {
                MMSwitchBtn.this.zMW.left = this.startX - (((float) this.zNe) * f);
            } else {
                MMSwitchBtn.this.zMW.left = this.startX + (((float) this.zNe) * f);
            }
            MMSwitchBtn.e(MMSwitchBtn.this);
            MMSwitchBtn.this.invalidate();
            AppMethodBeat.o(112577);
        }
    }

    public interface a {
        void di(boolean z);
    }

    static /* synthetic */ void e(MMSwitchBtn mMSwitchBtn) {
        AppMethodBeat.i(112590);
        mMSwitchBtn.dKF();
        AppMethodBeat.o(112590);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112578);
        init();
        b(context.obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.MMSwitchBtn));
        AppMethodBeat.o(112578);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112579);
        init();
        b(context.obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.MMSwitchBtn));
        AppMethodBeat.o(112579);
    }

    public MMSwitchBtn(Context context) {
        super(context);
        AppMethodBeat.i(112580);
        init();
        AppMethodBeat.o(112580);
    }

    private void init() {
        AppMethodBeat.i(112581);
        this.edgePadding = getResources().getDimensionPixelSize(R.dimen.nj);
        this.zMO = (float) getResources().getDimensionPixelSize(R.dimen.nq);
        this.zMP = (float) getResources().getDimensionPixelSize(R.dimen.np);
        this.zMQ = getResources().getColor(R.color.a69);
        this.zMR = getResources().getColor(R.color.a2f);
        this.zMS = getResources().getColor(R.color.a2g);
        this.zMT = getResources().getColor(R.color.h8);
        this.zMY = this.zMS;
        this.zMX = this.zMR;
        this.zMZ = this.zMQ;
        this.nfE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        AppMethodBeat.o(112581);
    }

    private void b(TypedArray typedArray) {
        AppMethodBeat.i(112582);
        this.zMY = typedArray.getColor(0, this.zMS);
        this.zMX = typedArray.getColor(1, this.zMR);
        this.zMZ = typedArray.getColor(2, this.zMQ);
        this.zNa = typedArray.getString(3);
        this.zNb = typedArray.getString(4);
        typedArray.recycle();
        AppMethodBeat.o(112582);
    }

    public final boolean dKD() {
        return this.zMU;
    }

    public void setCheck(boolean z) {
        CharSequence string;
        AppMethodBeat.i(112583);
        if (this.zMU != z) {
            clearAnimation();
            this.zMU = z;
            dKE();
            this.zMM = false;
            invalidate();
        }
        if (z) {
            string = getContext().getString(R.string.etw);
        } else {
            string = getContext().getString(R.string.eu7);
        }
        setContentDescription(string);
        AppMethodBeat.o(112583);
    }

    public void setSwitchListener(a aVar) {
        this.zNd = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112584);
        super.onLayout(z, i, i2, i3, i4);
        this.maxWidth = i3 - i;
        this.maxHeight = i4 - i2;
        this.zMK = (this.maxWidth - ((int) (this.zMP * 2.0f))) - (this.edgePadding * 2);
        this.zMJ = this.zMK / 2;
        this.zML = getResources().getDimensionPixelSize(R.dimen.no);
        if (this.zML < this.maxHeight) {
            this.zMV.top = (float) ((this.maxHeight - this.zML) / 2);
            this.zMV.bottom = this.zMV.top + ((float) this.zML);
        } else {
            this.zMV.top = 0.0f;
            this.zMV.bottom = (float) this.maxHeight;
        }
        this.zMV.left = 0.0f;
        this.zMV.right = (float) this.maxWidth;
        dKE();
        this.oJk.setStyle(Style.FILL);
        this.oJk.setColor(this.zMR);
        AppMethodBeat.o(112584);
    }

    private void dKE() {
        if (this.zML < this.maxHeight) {
            this.zMW.top = (float) (((this.maxHeight - this.zML) / 2) + this.edgePadding);
            this.zMW.bottom = (this.zMW.top + ((float) this.zML)) - ((float) (this.edgePadding * 2));
        } else {
            this.zMW.top = (float) this.edgePadding;
            this.zMW.bottom = (float) (this.maxHeight - this.edgePadding);
        }
        if (this.zMU) {
            this.zMW.left = (float) (this.zMK + this.edgePadding);
            this.zMW.right = (float) (this.maxWidth - this.edgePadding);
            return;
        }
        this.zMW.left = (float) this.edgePadding;
        this.zMW.right = (float) (((int) (this.zMP * 2.0f)) + this.edgePadding);
    }

    private void dKF() {
        if (this.zMW.left < ((float) this.edgePadding)) {
            this.zMW.left = (float) this.edgePadding;
        }
        if (this.zMW.left > ((float) (this.zMK + this.edgePadding))) {
            this.zMW.left = (float) (this.zMK + this.edgePadding);
        }
        this.zMW.right = this.zMW.left + ((float) ((int) (this.zMP * 2.0f)));
    }

    private void qW(boolean z) {
        AppMethodBeat.i(112585);
        this.zMM = true;
        this.zNc.reset();
        if (z) {
            this.zNc.zNe = (((long) this.zMK) - ((long) this.zMW.left)) + ((long) this.edgePadding);
            this.zNc.direction = 1;
        } else {
            this.zNc.zNe = (long) this.zMW.left;
            this.zNc.direction = 0;
        }
        this.zNc.startX = this.zMW.left;
        this.zNc.setDuration((80 * this.zNc.zNe) / ((long) this.zMK));
        startAnimation(this.zNc);
        AppMethodBeat.o(112585);
    }

    private void gq(boolean z) {
        AppMethodBeat.i(112586);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(112586);
    }

    private void dKb() {
        AppMethodBeat.i(112587);
        if (this.zMW.left > ((float) this.zMJ)) {
            qW(true);
            AppMethodBeat.o(112587);
            return;
        }
        qW(false);
        AppMethodBeat.o(112587);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(112588);
        if (this.zMM) {
            AppMethodBeat.o(112588);
        } else if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    clearAnimation();
                    this.rLO = motionEvent.getX();
                    this.rLP = motionEvent.getY();
                    this.zMI = SystemClock.elapsedRealtime();
                    this.zMN = false;
                    break;
                case 1:
                    if (SystemClock.elapsedRealtime() - this.zMI < 300) {
                        qW(!this.zMU);
                    } else {
                        dKb();
                    }
                    gq(false);
                    this.zMN = false;
                    break;
                case 2:
                    float x;
                    if (this.zMN) {
                        gq(true);
                        x = motionEvent.getX() - this.rLO;
                        RectF rectF = this.zMW;
                        rectF.left = x + rectF.left;
                        dKF();
                    } else {
                        float x2 = motionEvent.getX() - this.rLO;
                        x = motionEvent.getY() - this.rLP;
                        if (Math.abs(x2) >= ((float) this.nfE) / 10.0f) {
                            if (x == 0.0f) {
                                x = 1.0f;
                            }
                            if (Math.abs(x2 / x) > 3.0f) {
                                z = true;
                            }
                        }
                        if (z) {
                            this.zMN = true;
                            gq(true);
                        }
                    }
                    this.rLO = motionEvent.getX();
                    this.rLP = motionEvent.getY();
                    break;
                case 3:
                    if (this.zMN) {
                        dKb();
                    }
                    gq(false);
                    this.zMN = false;
                    break;
            }
            if (this.zMN) {
                invalidate();
            }
            AppMethodBeat.o(112588);
        } else {
            AppMethodBeat.o(112588);
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int i;
        AppMethodBeat.i(112589);
        if (isEnabled()) {
            i = this.zMX;
            this.oJk.setAlpha(255);
        } else {
            i = this.zMT;
            this.oJk.setAlpha(38);
        }
        this.oJk.setColor(i);
        canvas.drawRoundRect(this.zMV, this.zMO, this.zMO, this.oJk);
        this.oJk.setColor(this.zMY);
        this.oJk.setAlpha(Math.min(255, (int) (((this.zMW.left - ((float) this.edgePadding)) / ((float) this.zMK)) * 255.0f)));
        canvas.drawRoundRect(this.zMV, this.zMO, this.zMO, this.oJk);
        this.oJk.setColor(this.zMZ);
        canvas.drawRoundRect(this.zMW, this.zMP, this.zMP, this.oJk);
        if (!(this.zNa == null || this.zNb == null)) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(R.dimen.nd));
            paint.setTextAlign(Align.CENTER);
            paint.setColor(getResources().getColor(R.color.a6a));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.zMW.left - ((float) this.edgePadding)) / ((float) this.zMK)) * 255.0f));
            Rect rect = new Rect();
            paint.getTextBounds(this.zNa, 0, this.zNa.length(), rect);
            paint.setAlpha(min);
            float height = ((((float) rect.height()) / 2.0f) + ((this.zMV.top + this.zMV.bottom) / 2.0f)) - ((float) aj.fromDPToPix(getContext(), 1));
            canvas.drawText(this.zNa, (((this.zMV.left + this.zMV.right) / 2.0f) - this.zMP) + ((float) aj.fromDPToPix(getContext(), 1)), height, paint);
            float fromDPToPix = (((this.zMV.left + this.zMV.right) / 2.0f) + this.zMP) - ((float) aj.fromDPToPix(getContext(), 1));
            paint.setAlpha(255 - min);
            canvas.drawText(this.zNb, fromDPToPix, height, paint);
        }
        AppMethodBeat.o(112589);
    }
}
