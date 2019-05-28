package com.tencent.p177mm.view.p1096b;

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
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p834b.C9065b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.view.C16051a;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.view.b.a */
public class C30844a extends View {
    protected Matrix AbS;
    public Rect AbT;
    private Rect AbU;
    private Rect AbV;
    private Runnable AbW;
    protected float AbX;
    protected float AbY;
    private boolean AbZ = true;
    private boolean cjF = false;
    private C18117b cjc;
    protected Matrix cjd;
    private Rect cje;
    private Rect eHd;
    private float eHj = 1.0f;
    private float lbS;
    private float lbT;
    float[] values = new float[9];

    /* renamed from: com.tencent.mm.view.b.a$1 */
    class C308421 implements Runnable {
        C308421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116395);
            if (C30844a.this.getPresenter().dlT().ccT) {
                C30844a.this.getPresenter().dlT().setFooterVisible(false);
                C30844a.this.getPresenter().dlT().setActionBarVisible(false);
                AppMethodBeat.m2505o(116395);
                return;
            }
            C30844a.this.getPresenter().dlT().setFooterVisible(true);
            C30844a.this.getPresenter().dlT().setActionBarVisible(true);
            AppMethodBeat.m2505o(116395);
        }
    }

    /* renamed from: com.tencent.mm.view.b.a$b */
    public interface C30845b {
        /* renamed from: CV */
        void mo4946CV();

        void onStart();
    }

    /* renamed from: com.tencent.mm.view.b.a$a */
    class C30846a extends C9065b {
        private float Acb;
        private float Acc;
        boolean Acd;
        C30845b Ace;
        float ccw;
        float ccx;
        float mScale;
        /* renamed from: nR */
        float f13769nR;
        /* renamed from: rD */
        private ValueAnimator f13770rD;

        /* renamed from: com.tencent.mm.view.b.a$a$2 */
        class C160632 implements AnimatorListener {
            C160632() {
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(116398);
                if (C30846a.this.Ace != null) {
                    C30846a.this.Ace.onStart();
                }
                C30846a.this.cco = false;
                AppMethodBeat.m2505o(116398);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(116399);
                if (C30846a.this.Ace != null) {
                    C30846a.this.Ace.mo4946CV();
                }
                C30846a.this.cco = true;
                C30844a.this.AbS.set(C30844a.this.cjd);
                C30844a.this.AbY = C30844a.this.mo49334d(C30844a.this.AbS) * 1.0f;
                if (C30846a.this.Acd) {
                    C30844a.this.AbX = C30844a.this.mo49334d(C30844a.this.AbS) * 3.0f;
                    C30846a.m49242a(C30846a.this);
                }
                AppMethodBeat.m2505o(116399);
            }

            public final void onAnimationCancel(Animator animator) {
                C30846a.this.cco = true;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }

        /* renamed from: com.tencent.mm.view.b.a$a$1 */
        class C308431 implements AnimatorUpdateListener {
            float Acf = 0.0f;
            int ccA = 0;
            float ccB = ((float) Math.pow((double) C30846a.this.mScale, 0.10000000149011612d));
            float ccs = 0.0f;
            float cct = 0.0f;

            C308431() {
                AppMethodBeat.m2504i(116396);
                AppMethodBeat.m2505o(116396);
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(116397);
                float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue("rotation")).floatValue();
                if (this.ccA < 10) {
                    C30844a.this.cjd.postScale(this.ccB, this.ccB, (float) C30844a.this.getBoardRect().centerX(), (float) C30844a.this.getBoardRect().centerY());
                    this.ccA++;
                }
                C30846a.this.ccw += floatValue2 - this.cct;
                C30846a.this.ccx += floatValue - this.ccs;
                C30844a.this.cjd.postTranslate(C30846a.this.ccw - C30844a.this.getCurImageRect().centerX(), C30846a.this.ccx - C30844a.this.getCurImageRect().centerY());
                if (C30846a.this.f13769nR != 0.0f) {
                    C30844a.this.cjd.postRotate(floatValue3 - this.Acf, C30846a.this.ccw, C30846a.this.ccx);
                }
                C30844a.this.postInvalidate();
                this.ccs = floatValue;
                this.cct = floatValue2;
                this.Acf = floatValue3;
                AppMethodBeat.m2505o(116397);
            }
        }

        public C30846a(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.mScale = f;
            this.Acb = f2;
            this.Acc = f3;
            this.ccw = f4;
            this.ccx = f5;
            this.f13769nR = f6;
            this.Acd = z;
        }

        public final void play() {
            AppMethodBeat.m2504i(116400);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(WMElement.ANIMATE_TYPE_SCALE, new float[]{0.0f, 166.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.Acb});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.Acc});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("rotation", new float[]{0.0f, this.f13769nR});
            this.f13770rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.f13770rD.addUpdateListener(new C308431());
            this.f13770rD.addListener(new C160632());
            this.f13770rD.setInterpolator(new LinearInterpolator());
            this.f13770rD.setDuration(166);
            this.f13770rD.start();
            AppMethodBeat.m2505o(116400);
        }

        /* renamed from: a */
        static /* synthetic */ void m49242a(C30846a c30846a) {
            AppMethodBeat.m2504i(116401);
            Rect rawImageRect = C30844a.this.getRawImageRect();
            float width = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
            if (width < (((float) C30844a.this.getBoardRect().width()) * 1.0f) / ((float) C30844a.this.getBoardRect().height())) {
                width = ((float) C30844a.this.getBoardRect().width()) / width;
                C30844a.this.getBoardRect().height();
            } else {
                width = (float) C30844a.this.getBoardRect().height();
                C30844a.this.getBoardRect().width();
            }
            if (C30844a.this.mo49333b(C30844a.this.cjd) % 180.0f == 0.0f) {
                width = (width * 1.0f) / ((float) rawImageRect.height());
            } else {
                width = (width * 1.0f) / ((float) rawImageRect.width());
            }
            if (C30844a.this.AbX < width) {
                C30844a.this.AbX = width * 1.2f;
            }
            AppMethodBeat.m2505o(116401);
        }
    }

    public C18117b getPresenter() {
        return this.cjc;
    }

    public C30844a(Context context, C18117b c18117b) {
        super(context);
        AppMethodBeat.m2504i(116402);
        this.cjc = c18117b;
        this.cjd = new Matrix();
        this.AbS = new Matrix();
        this.cje = new Rect();
        this.AbT = new Rect();
        this.AbU = new Rect();
        this.eHd = new Rect();
        this.AbV = new Rect();
        Bitmap dlV = c18117b.dlV();
        if (dlV != null) {
            this.eHd.set(0, 0, dlV.getWidth(), dlV.getHeight());
            this.cje.set(this.eHd);
            this.AbV.set(this.eHd);
        }
        if (!(dMM() || c18117b.getConfig().rect == null)) {
            Rect rect = c18117b.getConfig().rect;
            this.cje.set(0, 0, rect.width(), rect.height());
            this.cjd.postTranslate(0.0f, (float) rect.top);
        }
        AppMethodBeat.m2505o(116402);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(116403);
        super.onLayout(z, i, i2, i3, i4);
        C4990ab.m7417i("changelcai", "[onLayout] %s", Boolean.valueOf(z));
        if (z) {
            this.AbT.set(i, i2, i3, i4);
            this.AbU.set(this.AbT);
        }
        AppMethodBeat.m2505o(116403);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116404);
        super.onDraw(canvas);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(this.cjd);
        getPresenter().onDraw(canvas);
        AppMethodBeat.m2505o(116404);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116405);
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
                if (getPresenter().dlU().mo4943CG() != C1493a.EMOJI_AND_TEXT) {
                    C308421 c308421 = new C308421();
                    this.AbW = c308421;
                    postDelayed(c308421, j);
                } else {
                    getPresenter().dlT().mo28431rj(true);
                    if (getPresenter().dlT().ccT) {
                        getPresenter().dlT().setFooterVisible(false);
                        getPresenter().dlT().setActionBarVisible(false);
                    } else {
                        boolean z;
                        C16051a dlT = getPresenter().dlT();
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
        if (!getPresenter().mo33560G(motionEvent) && dMM()) {
            mo49331V(motionEvent);
        }
        AppMethodBeat.m2505o(116405);
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: V */
    public void mo49331V(MotionEvent motionEvent) {
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
        AppMethodBeat.m2504i(116406);
        if (dMM()) {
            float f = this.eHj;
            AppMethodBeat.m2505o(116406);
            return f;
        }
        AppMethodBeat.m2505o(116406);
        return 1.0f;
    }

    public Rect getBoardRect() {
        AppMethodBeat.m2504i(116407);
        if (this.AbT == null) {
            this.AbT = new Rect();
        }
        Rect rect = this.AbT;
        AppMethodBeat.m2505o(116407);
        return rect;
    }

    public Rect getRawBoardRect() {
        return this.AbU;
    }

    public final void dMN() {
        float width;
        float height;
        float height2;
        AppMethodBeat.m2504i(116408);
        Rect rawImageRect = getRawImageRect();
        if (mo49333b(this.cjd) % 180.0f == 0.0f) {
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
        if (mo49333b(this.cjd) % 180.0f == 0.0f) {
            height2 = (1.0f * height) / ((float) rawImageRect.height());
        } else {
            height2 = (1.0f * height) / ((float) rawImageRect.width());
        }
        if (mo49333b(this.cjd) % 180.0f == 0.0f) {
            width = (width * 1.0f) / ((float) rawImageRect.height());
        } else {
            width = (width * 1.0f) / ((float) rawImageRect.width());
        }
        this.cjd.postScale(height2, height2, (float) rawImageRect.centerX(), (float) rawImageRect.centerY());
        RectF curImageRect = getCurImageRect();
        int centerX = (int) curImageRect.centerX();
        this.cjd.postTranslate((float) (getBoardRect().centerX() - centerX), (float) (getBoardRect().centerY() - ((int) curImageRect.centerY())));
        this.AbS.set(this.cjd);
        this.AbX = mo49334d(this.AbS) * 3.0f;
        this.AbY = mo49334d(this.AbS) * 1.0f;
        if (this.AbX < width) {
            this.AbX = width * 1.2f;
        }
        AppMethodBeat.m2505o(116408);
    }

    /* renamed from: a */
    public final void mo49332a(C30845b c30845b, float f, boolean z) {
        float width;
        float height;
        AppMethodBeat.m2504i(116409);
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
        C30846a c30846a = new C30846a(height, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f, z);
        c30846a.Ace = c30845b;
        c30846a.play();
        AppMethodBeat.m2505o(116409);
    }

    public RectF getCurImageRect() {
        AppMethodBeat.m2504i(116410);
        RectF rectF = new RectF(getRawImageRect());
        this.cjd.mapRect(rectF);
        AppMethodBeat.m2505o(116410);
        return rectF;
    }

    /* renamed from: o */
    public final void mo49350o(Rect rect) {
        AppMethodBeat.m2504i(116411);
        this.eHd.set(rect);
        this.cje.set(rect);
        C4990ab.m7416i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
        AppMethodBeat.m2505o(116411);
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

    /* renamed from: a */
    private float m49235a(Matrix matrix, int i) {
        AppMethodBeat.m2504i(116412);
        matrix.getValues(this.values);
        float f = this.values[i];
        AppMethodBeat.m2505o(116412);
        return f;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final float mo49334d(Matrix matrix) {
        AppMethodBeat.m2504i(116413);
        float a = m49235a(matrix, 3);
        float a2 = m49235a(matrix, 0);
        a = (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
        AppMethodBeat.m2505o(116413);
        return a;
    }

    public float getCurScale() {
        AppMethodBeat.m2504i(116414);
        float d = mo49334d(this.cjd);
        AppMethodBeat.m2505o(116414);
        return d;
    }

    /* renamed from: b */
    public final float mo49333b(Matrix matrix) {
        AppMethodBeat.m2504i(116415);
        float round = (float) Math.round(Math.atan2((double) m49235a(matrix, 1), (double) m49235a(matrix, 0)) * 57.29577951308232d);
        AppMethodBeat.m2505o(116415);
        return round;
    }
}
