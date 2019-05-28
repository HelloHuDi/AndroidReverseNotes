package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.k;
import com.tencent.mm.cache.c;
import com.tencent.mm.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends b<c> {
    private boolean cjF = false;
    private boolean ckd = false;
    private TimerTask cke;
    private Rect ckf = new Rect();
    private float ckg = 0.0f;
    private float ckh = 0.0f;
    private int cki = 0;
    private int ckj = 0;
    private boolean ckk = false;
    private com.tencent.mm.b.c ckl = new com.tencent.mm.b.c(this);
    public com.tencent.mm.ae.a ckm;
    boolean ckn = false;
    private Timer mTimer = new Timer();
    Matrix uS = new Matrix();

    class a extends TimerTask {
        private b cko;
        private Handler mHandler = new Handler(Looper.getMainLooper());

        public a(b bVar) {
            AppMethodBeat.i(116184);
            this.cko = bVar;
            AppMethodBeat.o(116184);
        }

        public final void run() {
            AppMethodBeat.i(116185);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(116183);
                    ab.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
                    if (e.this.CI() == null) {
                        AppMethodBeat.o(116183);
                        return;
                    }
                    com.tencent.mm.y.c Ji = ((c) e.this.CI()).Ji();
                    if (Ji != null && Ji.ejw) {
                        Ji.setSelected(false);
                        a.this.cko.bk(false);
                        a.this.cko.CP();
                    }
                    AppMethodBeat.o(116183);
                }
            });
            AppMethodBeat.o(116185);
        }
    }

    public e() {
        AppMethodBeat.i(116186);
        AppMethodBeat.o(116186);
    }

    public final void zC() {
        AppMethodBeat.i(116187);
        super.zC();
        this.ckf.set(0, getBoardRect().height() - ((int) ah.getResources().getDimension(R.dimen.a7p)), getBoardRect().width(), getBoardRect().height());
        AppMethodBeat.o(116187);
    }

    public final a CG() {
        return a.EMOJI_AND_TEXT;
    }

    public final void CH() {
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(116188);
        a(canvas);
        c cVar = (c) CI();
        if (cVar != null) {
            com.tencent.mm.y.c Ji = cVar.Ji();
            if (Ji != null && Ji.ejw) {
                Ji.draw(canvas);
            }
        }
        AppMethodBeat.o(116188);
    }

    public final boolean o(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(116189);
        com.tencent.mm.y.c C;
        com.tencent.mm.y.c Ji;
        switch (motionEvent.getActionMasked()) {
            case 0:
                CY();
                C = C(motionEvent.getX(), motionEvent.getY());
                if (C != null) {
                    z = C.eHn;
                    CW();
                    this.ckd = true;
                    C.setSelected(true);
                    C.eHn = z;
                    C.eHk.set(C.eHi);
                    ((c) CI()).b(C);
                    bk(true);
                    CP();
                    break;
                }
                this.ckd = false;
                if (CI() == null) {
                    z = false;
                } else {
                    Ji = ((c) CI()).Ji();
                    if (Ji != null) {
                        z = Ji.ejw;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    CW();
                    bk(false);
                    CP();
                    break;
                }
                break;
            case 1:
                if (isAlive()) {
                    if (CI() != null) {
                        C = ((c) CI()).Ji();
                        if (C != null) {
                            if (!this.cje.contains((int) C.eHi.x, (int) C.eHi.y)) {
                                this.ckl.cco = true;
                                com.tencent.mm.b.c cVar = this.ckl;
                                cVar.ccq = C;
                                cVar.ccf = C.eHk.x - C.eHi.x;
                                cVar.ccg = C.eHk.y - C.eHi.y;
                                cVar.ccr = C.eHf;
                                cVar = this.ckl;
                                if (cVar.cco) {
                                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, cVar.ccg});
                                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, cVar.ccf});
                                    cVar.rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                                    cVar.rD.addUpdateListener(new AnimatorUpdateListener() {
                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            AppMethodBeat.i(116141);
                                            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                                            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                                            ab.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", Float.valueOf(floatValue), Float.valueOf(floatValue - c.this.ccs));
                                            e eVar = c.this.ccp;
                                            float f = floatValue2 - c.this.cct;
                                            float f2 = floatValue - c.this.ccs;
                                            String str = c.this.ccr;
                                            com.tencent.mm.cache.c cVar = (com.tencent.mm.cache.c) eVar.CI();
                                            if (cVar != null) {
                                                ListIterator Jj = cVar.Jj();
                                                while (Jj.hasPrevious()) {
                                                    com.tencent.mm.y.c cVar2 = (com.tencent.mm.y.c) Jj.previous();
                                                    if (cVar2.eHf.equals(str)) {
                                                        cVar2.eHi.offset(f, f2);
                                                        eVar.CP();
                                                        break;
                                                    }
                                                }
                                            }
                                            ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
                                            c.this.ccs = floatValue;
                                            c.this.cct = floatValue2;
                                            AppMethodBeat.o(116141);
                                        }
                                    });
                                    cVar.rD.addListener(new AnimatorListener() {
                                        public final void onAnimationStart(Animator animator) {
                                            AppMethodBeat.i(116142);
                                            c.this.cco = false;
                                            c.this.ccs = 0.0f;
                                            c.this.cct = 0.0f;
                                            ab.d("MicroMsg.StickBackAnim", "onAnimationStart");
                                            AppMethodBeat.o(116142);
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            c.this.cco = true;
                                            c.this.ccs = 0.0f;
                                            c.this.cct = 0.0f;
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                            c.this.cco = true;
                                            c.this.ccs = 0.0f;
                                            c.this.cct = 0.0f;
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    cVar.rD.setInterpolator(new LinearInterpolator());
                                    cVar.rD.setDuration(100);
                                    cVar.rD.start();
                                }
                            }
                            if (C instanceof com.tencent.mm.y.e) {
                                com.tencent.mm.y.e eVar = (com.tencent.mm.y.e) C;
                                if (eVar.ejw && eVar.eHn) {
                                    if (this.ckm != null) {
                                        this.ckm.a(eVar);
                                    }
                                } else if (eVar.ejw) {
                                    eVar.eHn = true;
                                }
                            }
                            PointF pointF = C.eHi;
                            ab.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", this.ckf, Float.valueOf(B(pointF.x, pointF.y)[1]));
                            if (C.ejw && ((float) this.ckf.top) <= r0[1] && this.ckd && this.ckm != null) {
                                ((c) CI()).Jh();
                                CP();
                            }
                        }
                        CX();
                        if (this.cjF && this.ckm != null) {
                            this.ckm.onHide();
                        }
                        this.cjF = false;
                        break;
                    }
                    ab.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
                    AppMethodBeat.o(116189);
                    return false;
                }
                ab.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
                AppMethodBeat.o(116189);
                return false;
            case 2:
                if (!this.ckk) {
                    if (this.ckd && s(motionEvent)) {
                        float f;
                        if (!(this.cjF || this.ckm == null)) {
                            this.ckm.onShow();
                        }
                        int[] iArr = new int[]{(int) (motionEvent.getX(0) - this.cjj.x), (int) (motionEvent.getY(0) - this.cjj.y)};
                        float f2 = 1.0f;
                        int i = 0;
                        if (motionEvent.getPointerCount() > 1) {
                            if (0.0f != this.ckg) {
                                f2 = ((float) b.p(motionEvent)) / this.ckg;
                            }
                            i = this.cki - ((int) Math.toDegrees(Math.atan2((double) b.q(motionEvent)[0], (double) b.q(motionEvent)[1])));
                            f = f2;
                        } else {
                            f = 1.0f;
                        }
                        float f3 = (float) iArr[0];
                        float f4 = (float) iArr[1];
                        float f5 = this.ckh;
                        int i2 = this.ckj;
                        int pointerCount = motionEvent.getPointerCount();
                        Ji = ((c) CI()).Ji();
                        if (Ji != null) {
                            this.uS.reset();
                            this.uS.postRotate(-getRotation());
                            Matrix matrix = this.uS;
                            Matrix matrix2 = new Matrix();
                            matrix.invert(matrix2);
                            float[] fArr = new float[]{f3, f4};
                            matrix2.mapPoints(fArr);
                            if (pointerCount > 1) {
                                Ji.b(0.0f, 0.0f, f * f5, (i + i2) % v2helper.VOIP_ENC_HEIGHT_LV1);
                            } else {
                                Ji.b(fArr[0] / getScale(), fArr[1] / getScale(), 0.0f, Ji.mRotation);
                            }
                            Ji.Qg();
                            PointF pointF2 = Ji.eHi;
                            float[] B = B(pointF2.x, pointF2.y);
                            if (((float) this.ckf.top) <= B[1]) {
                                if (this.ckm != null) {
                                    this.ckm.ae((B[1] - ((float) this.ckf.top)) / ((float) this.ckf.height()));
                                }
                                this.ckn = true;
                            } else {
                                if (this.ckm != null && this.ckn) {
                                    this.ckm.Ta();
                                }
                                this.ckn = false;
                            }
                            if (Ji instanceof com.tencent.mm.y.e) {
                                Ji.eHn = false;
                            }
                        }
                        this.cjF = true;
                        CP();
                        break;
                    }
                }
                this.ckk = false;
                AppMethodBeat.o(116189);
                return true;
            case 5:
                if (!this.ckd) {
                    int[] iArr2 = new int[2];
                    if (motionEvent.getPointerCount() > 1) {
                        iArr2[0] = ((int) (motionEvent.getX(0) + motionEvent.getX(1))) / 2;
                        iArr2[1] = ((int) (motionEvent.getY(0) + motionEvent.getY(1))) / 2;
                    }
                    C = C((float) iArr2[0], (float) iArr2[1]);
                    if (C != null) {
                        z = C.eHn;
                        CW();
                        C.eHn = z;
                        this.ckd = true;
                        C.setSelected(true);
                        ((c) CI()).b(C);
                        this.ckg = (float) b.p(motionEvent);
                        this.cki = (int) Math.toDegrees(Math.atan2((double) b.q(motionEvent)[0], (double) b.q(motionEvent)[1]));
                        if (C != null && C.ejw) {
                            this.ckj = C.mRotation;
                            this.ckh = C.mScale;
                        }
                        bk(true);
                        CP();
                        break;
                    }
                }
                this.ckg = (float) b.p(motionEvent);
                this.cki = (int) Math.toDegrees(Math.atan2((double) b.q(motionEvent)[0], (double) b.q(motionEvent)[1]));
                Ji = ((c) CI()).Ji();
                if (Ji != null && Ji.ejw) {
                    this.ckj = Ji.mRotation;
                    this.ckh = Ji.mScale;
                    break;
                }
                break;
            case 6:
                this.ckk = true;
                break;
        }
        super.o(motionEvent);
        z = this.ckd;
        AppMethodBeat.o(116189);
        return z;
    }

    public final void onDestroy() {
        AppMethodBeat.i(116190);
        super.onDestroy();
        CY();
        AppMethodBeat.o(116190);
    }

    private com.tencent.mm.y.c C(float f, float f2) {
        AppMethodBeat.i(116191);
        if (CI() == null) {
            ab.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
            AppMethodBeat.o(116191);
            return null;
        }
        com.tencent.mm.y.c cVar;
        ListIterator Jj = ((c) CI()).Jj();
        while (Jj.hasPrevious()) {
            cVar = (com.tencent.mm.y.c) Jj.previous();
            float[] A = A(f, f2);
            if (cVar.D(A[0], A[1])) {
                break;
            }
        }
        cVar = null;
        AppMethodBeat.o(116191);
        return cVar;
    }

    private com.tencent.mm.y.c CW() {
        com.tencent.mm.y.c cVar = null;
        AppMethodBeat.i(116192);
        c cVar2 = (c) CI();
        if (cVar2 == null) {
            AppMethodBeat.o(116192);
        } else {
            ListIterator Jj = cVar2.Jj();
            while (Jj.hasPrevious()) {
                com.tencent.mm.y.c cVar3 = (com.tencent.mm.y.c) Jj.previous();
                if (cVar3.ejw) {
                    cVar = cVar3;
                }
                cVar3.setSelected(false);
            }
            AppMethodBeat.o(116192);
        }
        return cVar;
    }

    private void CX() {
        AppMethodBeat.i(116193);
        ab.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
        if (this.cke != null) {
            this.cke.cancel();
        }
        this.cke = new a(this);
        this.mTimer.schedule(this.cke, 1500);
        AppMethodBeat.o(116193);
    }

    private void CY() {
        AppMethodBeat.i(116194);
        ab.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
        if (this.cke != null) {
            this.cke.cancel();
        }
        AppMethodBeat.o(116194);
    }

    public final void a(SpannableString spannableString, int i, int i2) {
        AppMethodBeat.i(116195);
        ab.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", spannableString);
        if (bo.ac(spannableString)) {
            AppMethodBeat.o(116195);
            return;
        }
        c cVar = (c) CI();
        if (cVar == null) {
            ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.o(116195);
            return;
        }
        CY();
        CW();
        bk(false);
        Rect boardRect = getBoardRect();
        com.tencent.mm.y.e eVar = new com.tencent.mm.y.e(ah.getContext(), getMainMatrix(), cVar.ac(true), boardRect, spannableString, i, i2);
        eVar.setSelected(true);
        eVar.eHn = true;
        float[] A = A((float) boardRect.centerX(), (float) boardRect.centerY());
        eVar.a(A[0], A[1], this.cjc.getInitScale() / this.cjc.getCurScale(), (int) getRotation());
        cVar.a(eVar);
        CP();
        CX();
        AppMethodBeat.o(116195);
    }

    public final void b(k kVar) {
        AppMethodBeat.i(116196);
        ab.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", kVar);
        c cVar = (c) CI();
        if (cVar == null) {
            ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.o(116196);
            return;
        }
        CY();
        CW();
        bk(false);
        Rect boardRect = getBoardRect();
        com.tencent.mm.y.c cVar2 = new com.tencent.mm.y.c(ah.getContext(), getMainMatrix(), cVar.ac(true), kVar, boardRect);
        cVar2.setSelected(true);
        float[] A = A((float) boardRect.centerX(), (float) boardRect.centerY());
        cVar2.a(A[0], A[1], this.cjc.getInitScale() / this.cjc.getCurScale(), (int) getRotation());
        cVar.a(cVar2);
        CP();
        CX();
        AppMethodBeat.o(116196);
    }

    public final void a(com.tencent.mm.y.e eVar, SpannableString spannableString, int i, int i2) {
        AppMethodBeat.i(116197);
        c cVar = (c) CI();
        if (cVar == null) {
            ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.o(116197);
            return;
        }
        ab.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", eVar.eHf);
        if (cVar.efp != null && cVar.efp.size() > 0) {
            if (((com.tencent.mm.y.c) cVar.efp.peek()).eHf.equalsIgnoreCase(r1)) {
                cVar.efp.pop();
            } else {
                ab.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", r1, (com.tencent.mm.y.c) cVar.efp.peek());
            }
        }
        eVar.setSelected(true);
        eVar.eHn = true;
        CY();
        CW();
        bk(true);
        if (!bo.ac(spannableString)) {
            com.tencent.mm.y.e eVar2 = new com.tencent.mm.y.e(ah.getContext(), getMainMatrix(), cVar.ac(true), getBoardRect(), spannableString, i, i2);
            eVar2.setSelected(true);
            PointF pointF = eVar.eHi;
            eVar2.a(pointF.x, pointF.y, this.cjc.getInitScale() / this.cjc.getCurScale(), eVar.mRotation);
            eVar2.mScale = eVar.mScale;
            cVar.a(eVar2);
        }
        CP();
        CX();
        AppMethodBeat.o(116197);
    }
}
