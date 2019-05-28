package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.model.WMElement;

public class a extends View {
    protected Matrix AbS;
    public Rect AbT;
    private Rect AbU;
    private Rect AbV;
    private Runnable AbW;
    protected float AbX;
    protected float AbY;
    private boolean AbZ = true;
    private boolean cjF = false;
    private com.tencent.mm.br.b cjc;
    protected Matrix cjd;
    private Rect cje;
    private Rect eHd;
    private float eHj = 1.0f;
    private float lbS;
    private float lbT;
    float[] values = new float[9];

    public interface b {
        void CV();

        void onStart();
    }

    class a extends com.tencent.mm.b.b {
        private float Acb;
        private float Acc;
        boolean Acd;
        b Ace;
        float ccw;
        float ccx;
        float mScale;
        float nR;
        private ValueAnimator rD;

        public a(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.mScale = f;
            this.Acb = f2;
            this.Acc = f3;
            this.ccw = f4;
            this.ccx = f5;
            this.nR = f6;
            this.Acd = z;
        }

        public final void play() {
            AppMethodBeat.i(116400);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(WMElement.ANIMATE_TYPE_SCALE, new float[]{0.0f, 166.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.Acb});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.Acc});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("rotation", new float[]{0.0f, this.nR});
            this.rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.rD.addUpdateListener(new AnimatorUpdateListener() {
                float Acf = 0.0f;
                int ccA = 0;
                float ccB = ((float) Math.pow((double) a.this.mScale, 0.10000000149011612d));
                float ccs = 0.0f;
                float cct = 0.0f;

                {
                    AppMethodBeat.i(116396);
                    AppMethodBeat.o(116396);
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(116397);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
                    if (this.ccA < 10) {
                        a.this.cjd.postScale(this.ccB, this.ccB, (float) a.this.getBoardRect().centerX(), (float) a.this.getBoardRect().centerY());
                        this.ccA++;
                    }
                    a.this.ccw += floatValue2 - this.cct;
                    a.this.ccx += floatValue - this.ccs;
                    a.this.cjd.postTranslate(a.this.ccw - a.this.getCurImageRect().centerX(), a.this.ccx - a.this.getCurImageRect().centerY());
                    if (a.this.nR != 0.0f) {
                        a.this.cjd.postRotate(floatValue3 - this.Acf, a.this.ccw, a.this.ccx);
                    }
                    a.this.postInvalidate();
                    this.ccs = floatValue;
                    this.cct = floatValue2;
                    this.Acf = floatValue3;
                    AppMethodBeat.o(116397);
                }
            });
            this.rD.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(116398);
                    if (a.this.Ace != null) {
                        a.this.Ace.onStart();
                    }
                    a.this.cco = false;
                    AppMethodBeat.o(116398);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(116399);
                    if (a.this.Ace != null) {
                        a.this.Ace.CV();
                    }
                    a.this.cco = true;
                    a.this.AbS.set(a.this.cjd);
                    a.this.AbY = a.this.d(a.this.AbS) * 1.0f;
                    if (a.this.Acd) {
                        a.this.AbX = a.this.d(a.this.AbS) * 3.0f;
                        a.a(a.this);
                    }
                    AppMethodBeat.o(116399);
                }

                public final void onAnimationCancel(Animator animator) {
                    a.this.cco = true;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.rD.setInterpolator(new LinearInterpolator());
            this.rD.setDuration(166);
            this.rD.start();
            AppMethodBeat.o(116400);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(116401);
            Rect rawImageRect = a.this.getRawImageRect();
            float width = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
            if (width < (((float) a.this.getBoardRect().width()) * 1.0f) / ((float) a.this.getBoardRect().height())) {
                width = ((float) a.this.getBoardRect().width()) / width;
                a.this.getBoardRect().height();
            } else {
                width = (float) a.this.getBoardRect().height();
                a.this.getBoardRect().width();
            }
            if (a.this.b(a.this.cjd) % 180.0f == 0.0f) {
                width = (width * 1.0f) / ((float) rawImageRect.height());
            } else {
                width = (width * 1.0f) / ((float) rawImageRect.width());
            }
            if (a.this.AbX < width) {
                a.this.AbX = width * 1.2f;
            }
            AppMethodBeat.o(116401);
        }
    }

    public com.tencent.mm.br.b getPresenter() {
        return this.cjc;
    }

    public a(Context context, com.tencent.mm.br.b bVar) {
        super(context);
        AppMethodBeat.i(116402);
        this.cjc = bVar;
        this.cjd = new Matrix();
        this.AbS = new Matrix();
        this.cje = new Rect();
        this.AbT = new Rect();
        this.AbU = new Rect();
        this.eHd = new Rect();
        this.AbV = new Rect();
        Bitmap dlV = bVar.dlV();
        if (dlV != null) {
            this.eHd.set(0, 0, dlV.getWidth(), dlV.getHeight());
            this.cje.set(this.eHd);
            this.AbV.set(this.eHd);
        }
        if (!(dMM() || bVar.getConfig().rect == null)) {
            Rect rect = bVar.getConfig().rect;
            this.cje.set(0, 0, rect.width(), rect.height());
            this.cjd.postTranslate(0.0f, (float) rect.top);
        }
        AppMethodBeat.o(116402);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(116403);
        super.onLayout(z, i, i2, i3, i4);
        ab.i("changelcai", "[onLayout] %s", Boolean.valueOf(z));
        if (z) {
            this.AbT.set(i, i2, i3, i4);
            this.AbU.set(this.AbT);
        }
        AppMethodBeat.o(116403);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(116404);
        super.onDraw(canvas);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(this.cjd);
        getPresenter().onDraw(canvas);
        AppMethodBeat.o(116404);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(116405);
        if (getPresenter().dlW()) {
            if (motionEvent.getAction() == 0) {
                this.lbS = motionEvent.getX();
                this.lbT = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                removeCallbacks(this.AbW);
                long j = 0;
                if (this.cjF) {
                    j = 700;
                }
                if (getPresenter().dlU().CG() != com.tencent.mm.e.a.EMOJI_AND_TEXT) {
                    AnonymousClass1 anonymousClass1 = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(116395);
                            if (a.this.getPresenter().dlT().ccT) {
                                a.this.getPresenter().dlT().setFooterVisible(false);
                                a.this.getPresenter().dlT().setActionBarVisible(false);
                                AppMethodBeat.o(116395);
                                return;
                            }
                            a.this.getPresenter().dlT().setFooterVisible(true);
                            a.this.getPresenter().dlT().setActionBarVisible(true);
                            AppMethodBeat.o(116395);
                        }
                    };
                    this.AbW = anonymousClass1;
                    postDelayed(anonymousClass1, j);
                } else {
                    getPresenter().dlT().rj(true);
                    if (getPresenter().dlT().ccT) {
                        getPresenter().dlT().setFooterVisible(false);
                        getPresenter().dlT().setActionBarVisible(false);
                    } else {
                        boolean z;
                        com.tencent.mm.view.a dlT = getPresenter().dlT();
                        if (dlT.odY.getVisibility() == 0 || dlT.getTextEditView().getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            getPresenter().dlT().setFooterVisible(true);
                            getPresenter().dlT().setActionBarVisible(true);
                        }
                    }
                    getPresenter().dlT().getBaseFooterView().dMS();
                }
                this.cjF = false;
            } else if (motionEvent.getAction() == 2) {
                if (Math.abs(motionEvent.getX() - this.lbS) >= 3.0f || Math.abs(motionEvent.getY() - this.lbT) >= 3.0f) {
                    this.cjF = true;
                    removeCallbacks(this.AbW);
                    if (getPresenter().dlT().ccT) {
                        getPresenter().dlT().setFooterVisible(false);
                        getPresenter().dlT().setActionBarVisible(false);
                    }
                }
                this.lbS = motionEvent.getX();
                this.lbT = motionEvent.getY();
            }
        }
        if (!getPresenter().G(motionEvent) && dMM()) {
            V(motionEvent);
        }
        AppMethodBeat.o(116405);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void V(MotionEvent motionEvent) {
    }

    /* Access modifiers changed, original: protected */
    public boolean dML() {
        return this.AbZ;
    }

    public void setOneFingerMoveEnable(boolean z) {
        this.AbZ = z;
    }

    public boolean dMM() {
        return true;
    }

    public Rect getAliveRect() {
        return this.cje;
    }

    public Matrix getMainMatrix() {
        return this.cjd;
    }

    public float getInitScale() {
        AppMethodBeat.i(116406);
        if (dMM()) {
            float f = this.eHj;
            AppMethodBeat.o(116406);
            return f;
        }
        AppMethodBeat.o(116406);
        return 1.0f;
    }

    public Rect getBoardRect() {
        AppMethodBeat.i(116407);
        if (this.AbT == null) {
            this.AbT = new Rect();
        }
        Rect rect = this.AbT;
        AppMethodBeat.o(116407);
        return rect;
    }

    public Rect getRawBoardRect() {
        return this.AbU;
    }

    public final void dMN() {
        float width;
        float height;
        float height2;
        AppMethodBeat.i(116408);
        Rect rawImageRect = getRawImageRect();
        if (b(this.cjd) % 180.0f == 0.0f) {
            width = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
        } else {
            width = (((float) rawImageRect.height()) * 1.0f) / ((float) rawImageRect.width());
        }
        if (width < (((float) getBoardRect().width()) * 1.0f) / ((float) getBoardRect().height())) {
            width = ((float) getBoardRect().width()) / width;
            height = (float) getBoardRect().height();
        } else {
            height = ((float) getBoardRect().width()) / width;
            width = (float) getBoardRect().height();
        }
        if (b(this.cjd) % 180.0f == 0.0f) {
            height2 = (1.0f * height) / ((float) rawImageRect.height());
        } else {
            height2 = (1.0f * height) / ((float) rawImageRect.width());
        }
        if (b(this.cjd) % 180.0f == 0.0f) {
            width = (width * 1.0f) / ((float) rawImageRect.height());
        } else {
            width = (width * 1.0f) / ((float) rawImageRect.width());
        }
        this.cjd.postScale(height2, height2, (float) rawImageRect.centerX(), (float) rawImageRect.centerY());
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        this.cjd.postTranslate((float) (getBoardRect().centerX() - centerX), (float) (getBoardRect().centerY() - ((int) curImageRect.centerY())));
        this.AbS.set(this.cjd);
        this.AbX = d(this.AbS) * 3.0f;
        this.AbY = d(this.AbS) * 1.0f;
        if (this.AbX < width) {
            this.AbX = width * 1.2f;
        }
        AppMethodBeat.o(116408);
    }

    public final void a(b bVar, float f, boolean z) {
        float width;
        float height;
        AppMethodBeat.i(116409);
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        int centerY = (int) curImageRect.centerY();
        int centerX2 = getBoardRect().centerX() - centerX;
        int centerY2 = getBoardRect().centerY() - centerY;
        if (f % 180.0f == 0.0f) {
            width = (curImageRect.width() * 1.0f) / curImageRect.height();
        } else {
            width = (curImageRect.height() * 1.0f) / curImageRect.width();
        }
        if (width < (((float) getBoardRect().width()) * 1.0f) / ((float) getBoardRect().height())) {
            getBoardRect().width();
            width = (float) getBoardRect().height();
        } else {
            getBoardRect().height();
            width = ((float) getBoardRect().width()) / width;
        }
        if (f % 180.0f == 0.0f) {
            height = (width * 1.0f) / curImageRect.height();
        } else {
            height = (width * 1.0f) / curImageRect.width();
        }
        a aVar = new a(height, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f, z);
        aVar.Ace = bVar;
        aVar.play();
        AppMethodBeat.o(116409);
    }

    public RectF getCurImageRect() {
        AppMethodBeat.i(116410);
        RectF rectF = new RectF(getRawImageRect());
        this.cjd.mapRect(rectF);
        AppMethodBeat.o(116410);
        return rectF;
    }

    public final void o(Rect rect) {
        AppMethodBeat.i(116411);
        this.eHd.set(rect);
        this.cje.set(rect);
        ab.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
        AppMethodBeat.o(116411);
    }

    public Rect getRawImageRect() {
        return this.eHd;
    }

    public Rect getImageBitmapRect() {
        return this.AbV;
    }

    public float getMinScale() {
        return this.AbY;
    }

    public float getMaxScale() {
        return this.AbX;
    }

    private float a(Matrix matrix, int i) {
        AppMethodBeat.i(116412);
        matrix.getValues(this.values);
        float f = this.values[i];
        AppMethodBeat.o(116412);
        return f;
    }

    /* Access modifiers changed, original: protected|final */
    public final float d(Matrix matrix) {
        AppMethodBeat.i(116413);
        float a = a(matrix, 3);
        float a2 = a(matrix, 0);
        a = (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
        AppMethodBeat.o(116413);
        return a;
    }

    public float getCurScale() {
        AppMethodBeat.i(116414);
        float d = d(this.cjd);
        AppMethodBeat.o(116414);
        return d;
    }

    public final float b(Matrix matrix) {
        AppMethodBeat.i(116415);
        float round = (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
        AppMethodBeat.o(116415);
        return round;
    }
}
