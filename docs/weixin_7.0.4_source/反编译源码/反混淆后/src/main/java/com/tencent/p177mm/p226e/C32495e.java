package com.tencent.p177mm.p226e;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.cache.C24666c;
import com.tencent.p177mm.p1525ae.C37434a;
import com.tencent.p177mm.p651y.C36398c;
import com.tencent.p177mm.p651y.C36890e;
import com.tencent.p177mm.p834b.C45178c;
import com.tencent.p177mm.p834b.C45178c.C258531;
import com.tencent.p177mm.p834b.C45178c.C375022;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.e.e */
public final class C32495e extends C9268b<C24666c> {
    private boolean cjF = false;
    private boolean ckd = false;
    private TimerTask cke;
    private Rect ckf = new Rect();
    private float ckg = 0.0f;
    private float ckh = 0.0f;
    private int cki = 0;
    private int ckj = 0;
    private boolean ckk = false;
    private C45178c ckl = new C45178c(this);
    public C37434a ckm;
    boolean ckn = false;
    private Timer mTimer = new Timer();
    /* renamed from: uS */
    Matrix f15017uS = new Matrix();

    /* renamed from: com.tencent.mm.e.e$a */
    class C26070a extends TimerTask {
        private C9268b cko;
        private Handler mHandler = new Handler(Looper.getMainLooper());

        /* renamed from: com.tencent.mm.e.e$a$1 */
        class C260711 implements Runnable {
            C260711() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116183);
                C4990ab.m7410d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
                if (C32495e.this.mo20691CI() == null) {
                    AppMethodBeat.m2505o(116183);
                    return;
                }
                C36398c Ji = ((C24666c) C32495e.this.mo20691CI()).mo41558Ji();
                if (Ji != null && Ji.ejw) {
                    Ji.setSelected(false);
                    C26070a.this.cko.mo20700bk(false);
                    C26070a.this.cko.mo20696CP();
                }
                AppMethodBeat.m2505o(116183);
            }
        }

        public C26070a(C9268b c9268b) {
            AppMethodBeat.m2504i(116184);
            this.cko = c9268b;
            AppMethodBeat.m2505o(116184);
        }

        public final void run() {
            AppMethodBeat.m2504i(116185);
            this.mHandler.post(new C260711());
            AppMethodBeat.m2505o(116185);
        }
    }

    public C32495e() {
        AppMethodBeat.m2504i(116186);
        AppMethodBeat.m2505o(116186);
    }

    /* renamed from: zC */
    public final void mo4955zC() {
        AppMethodBeat.m2504i(116187);
        super.mo4955zC();
        this.ckf.set(0, getBoardRect().height() - ((int) C4996ah.getResources().getDimension(C25738R.dimen.a7p)), getBoardRect().width(), getBoardRect().height());
        AppMethodBeat.m2505o(116187);
    }

    /* renamed from: CG */
    public final C1493a mo4943CG() {
        return C1493a.EMOJI_AND_TEXT;
    }

    /* renamed from: CH */
    public final void mo4944CH() {
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116188);
        mo20698a(canvas);
        C24666c c24666c = (C24666c) mo20691CI();
        if (c24666c != null) {
            C36398c Ji = c24666c.mo41558Ji();
            if (Ji != null && Ji.ejw) {
                Ji.draw(canvas);
            }
        }
        AppMethodBeat.m2505o(116188);
    }

    /* renamed from: o */
    public final boolean mo4954o(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.m2504i(116189);
        C36398c C;
        C36398c Ji;
        switch (motionEvent.getActionMasked()) {
            case 0:
                m53190CY();
                C = m53187C(motionEvent.getX(), motionEvent.getY());
                if (C != null) {
                    z = C.eHn;
                    m53188CW();
                    this.ckd = true;
                    C.setSelected(true);
                    C.eHn = z;
                    C.eHk.set(C.eHi);
                    ((C24666c) mo20691CI()).mo41562b(C);
                    mo20700bk(true);
                    mo20696CP();
                    break;
                }
                this.ckd = false;
                if (mo20691CI() == null) {
                    z = false;
                } else {
                    Ji = ((C24666c) mo20691CI()).mo41558Ji();
                    if (Ji != null) {
                        z = Ji.ejw;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    m53188CW();
                    mo20700bk(false);
                    mo20696CP();
                    break;
                }
                break;
            case 1:
                if (isAlive()) {
                    if (mo20691CI() != null) {
                        C = ((C24666c) mo20691CI()).mo41558Ji();
                        if (C != null) {
                            if (!this.cje.contains((int) C.eHi.x, (int) C.eHi.y)) {
                                this.ckl.cco = true;
                                C45178c c45178c = this.ckl;
                                c45178c.ccq = C;
                                c45178c.ccf = C.eHk.x - C.eHi.x;
                                c45178c.ccg = C.eHk.y - C.eHi.y;
                                c45178c.ccr = C.eHf;
                                c45178c = this.ckl;
                                if (c45178c.cco) {
                                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, c45178c.ccg});
                                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, c45178c.ccf});
                                    c45178c.f17873rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                                    c45178c.f17873rD.addUpdateListener(new C258531());
                                    c45178c.f17873rD.addListener(new C375022());
                                    c45178c.f17873rD.setInterpolator(new LinearInterpolator());
                                    c45178c.f17873rD.setDuration(100);
                                    c45178c.f17873rD.start();
                                }
                            }
                            if (C instanceof C36890e) {
                                C36890e c36890e = (C36890e) C;
                                if (c36890e.ejw && c36890e.eHn) {
                                    if (this.ckm != null) {
                                        this.ckm.mo41549a(c36890e);
                                    }
                                } else if (c36890e.ejw) {
                                    c36890e.eHn = true;
                                }
                            }
                            PointF pointF = C.eHi;
                            C4990ab.m7417i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", this.ckf, Float.valueOf(mo20690B(pointF.x, pointF.y)[1]));
                            if (C.ejw && ((float) this.ckf.top) <= r0[1] && this.ckd && this.ckm != null) {
                                ((C24666c) mo20691CI()).mo41557Jh();
                                mo20696CP();
                            }
                        }
                        m53189CX();
                        if (this.cjF && this.ckm != null) {
                            this.ckm.onHide();
                        }
                        this.cjF = false;
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
                    AppMethodBeat.m2505o(116189);
                    return false;
                }
                C4990ab.m7412e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
                AppMethodBeat.m2505o(116189);
                return false;
            case 2:
                if (!this.ckk) {
                    if (this.ckd && mo20710s(motionEvent)) {
                        float f;
                        if (!(this.cjF || this.ckm == null)) {
                            this.ckm.onShow();
                        }
                        int[] iArr = new int[]{(int) (motionEvent.getX(0) - this.cjj.x), (int) (motionEvent.getY(0) - this.cjj.y)};
                        float f2 = 1.0f;
                        int i = 0;
                        if (motionEvent.getPointerCount() > 1) {
                            if (0.0f != this.ckg) {
                                f2 = ((float) C9268b.m16796p(motionEvent)) / this.ckg;
                            }
                            i = this.cki - ((int) Math.toDegrees(Math.atan2((double) C9268b.m16797q(motionEvent)[0], (double) C9268b.m16797q(motionEvent)[1])));
                            f = f2;
                        } else {
                            f = 1.0f;
                        }
                        float f3 = (float) iArr[0];
                        float f4 = (float) iArr[1];
                        float f5 = this.ckh;
                        int i2 = this.ckj;
                        int pointerCount = motionEvent.getPointerCount();
                        Ji = ((C24666c) mo20691CI()).mo41558Ji();
                        if (Ji != null) {
                            this.f15017uS.reset();
                            this.f15017uS.postRotate(-getRotation());
                            Matrix matrix = this.f15017uS;
                            Matrix matrix2 = new Matrix();
                            matrix.invert(matrix2);
                            float[] fArr = new float[]{f3, f4};
                            matrix2.mapPoints(fArr);
                            if (pointerCount > 1) {
                                Ji.mo57320b(0.0f, 0.0f, f * f5, (i + i2) % v2helper.VOIP_ENC_HEIGHT_LV1);
                            } else {
                                Ji.mo57320b(fArr[0] / getScale(), fArr[1] / getScale(), 0.0f, Ji.mRotation);
                            }
                            Ji.mo57317Qg();
                            PointF pointF2 = Ji.eHi;
                            float[] B = mo20690B(pointF2.x, pointF2.y);
                            if (((float) this.ckf.top) <= B[1]) {
                                if (this.ckm != null) {
                                    this.ckm.mo41550ae((B[1] - ((float) this.ckf.top)) / ((float) this.ckf.height()));
                                }
                                this.ckn = true;
                            } else {
                                if (this.ckm != null && this.ckn) {
                                    this.ckm.mo41548Ta();
                                }
                                this.ckn = false;
                            }
                            if (Ji instanceof C36890e) {
                                Ji.eHn = false;
                            }
                        }
                        this.cjF = true;
                        mo20696CP();
                        break;
                    }
                }
                this.ckk = false;
                AppMethodBeat.m2505o(116189);
                return true;
            case 5:
                if (!this.ckd) {
                    int[] iArr2 = new int[2];
                    if (motionEvent.getPointerCount() > 1) {
                        iArr2[0] = ((int) (motionEvent.getX(0) + motionEvent.getX(1))) / 2;
                        iArr2[1] = ((int) (motionEvent.getY(0) + motionEvent.getY(1))) / 2;
                    }
                    C = m53187C((float) iArr2[0], (float) iArr2[1]);
                    if (C != null) {
                        z = C.eHn;
                        m53188CW();
                        C.eHn = z;
                        this.ckd = true;
                        C.setSelected(true);
                        ((C24666c) mo20691CI()).mo41562b(C);
                        this.ckg = (float) C9268b.m16796p(motionEvent);
                        this.cki = (int) Math.toDegrees(Math.atan2((double) C9268b.m16797q(motionEvent)[0], (double) C9268b.m16797q(motionEvent)[1]));
                        if (C != null && C.ejw) {
                            this.ckj = C.mRotation;
                            this.ckh = C.mScale;
                        }
                        mo20700bk(true);
                        mo20696CP();
                        break;
                    }
                }
                this.ckg = (float) C9268b.m16796p(motionEvent);
                this.cki = (int) Math.toDegrees(Math.atan2((double) C9268b.m16797q(motionEvent)[0], (double) C9268b.m16797q(motionEvent)[1]));
                Ji = ((C24666c) mo20691CI()).mo41558Ji();
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
        super.mo4954o(motionEvent);
        z = this.ckd;
        AppMethodBeat.m2505o(116189);
        return z;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116190);
        super.onDestroy();
        m53190CY();
        AppMethodBeat.m2505o(116190);
    }

    /* renamed from: C */
    private C36398c m53187C(float f, float f2) {
        AppMethodBeat.m2504i(116191);
        if (mo20691CI() == null) {
            C4990ab.m7412e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
            AppMethodBeat.m2505o(116191);
            return null;
        }
        C36398c c36398c;
        ListIterator Jj = ((C24666c) mo20691CI()).mo41559Jj();
        while (Jj.hasPrevious()) {
            c36398c = (C36398c) Jj.previous();
            float[] A = mo20689A(f, f2);
            if (c36398c.mo57314D(A[0], A[1])) {
                break;
            }
        }
        c36398c = null;
        AppMethodBeat.m2505o(116191);
        return c36398c;
    }

    /* renamed from: CW */
    private C36398c m53188CW() {
        C36398c c36398c = null;
        AppMethodBeat.m2504i(116192);
        C24666c c24666c = (C24666c) mo20691CI();
        if (c24666c == null) {
            AppMethodBeat.m2505o(116192);
        } else {
            ListIterator Jj = c24666c.mo41559Jj();
            while (Jj.hasPrevious()) {
                C36398c c36398c2 = (C36398c) Jj.previous();
                if (c36398c2.ejw) {
                    c36398c = c36398c2;
                }
                c36398c2.setSelected(false);
            }
            AppMethodBeat.m2505o(116192);
        }
        return c36398c;
    }

    /* renamed from: CX */
    private void m53189CX() {
        AppMethodBeat.m2504i(116193);
        C4990ab.m7410d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
        if (this.cke != null) {
            this.cke.cancel();
        }
        this.cke = new C26070a(this);
        this.mTimer.schedule(this.cke, 1500);
        AppMethodBeat.m2505o(116193);
    }

    /* renamed from: CY */
    private void m53190CY() {
        AppMethodBeat.m2504i(116194);
        C4990ab.m7410d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
        if (this.cke != null) {
            this.cke.cancel();
        }
        AppMethodBeat.m2505o(116194);
    }

    /* renamed from: a */
    public final void mo53131a(SpannableString spannableString, int i, int i2) {
        AppMethodBeat.m2504i(116195);
        C4990ab.m7417i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", spannableString);
        if (C5046bo.m7519ac(spannableString)) {
            AppMethodBeat.m2505o(116195);
            return;
        }
        C24666c c24666c = (C24666c) mo20691CI();
        if (c24666c == null) {
            C4990ab.m7420w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.m2505o(116195);
            return;
        }
        m53190CY();
        m53188CW();
        mo20700bk(false);
        Rect boardRect = getBoardRect();
        C36890e c36890e = new C36890e(C4996ah.getContext(), getMainMatrix(), c24666c.mo33616ac(true), boardRect, spannableString, i, i2);
        c36890e.setSelected(true);
        c36890e.eHn = true;
        float[] A = mo20689A((float) boardRect.centerX(), (float) boardRect.centerY());
        c36890e.mo57319a(A[0], A[1], this.cjc.getInitScale() / this.cjc.getCurScale(), (int) getRotation());
        c24666c.mo41561a(c36890e);
        mo20696CP();
        m53189CX();
        AppMethodBeat.m2505o(116195);
    }

    /* renamed from: b */
    public final void mo53133b(C8955k c8955k) {
        AppMethodBeat.m2504i(116196);
        C4990ab.m7417i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", c8955k);
        C24666c c24666c = (C24666c) mo20691CI();
        if (c24666c == null) {
            C4990ab.m7420w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.m2505o(116196);
            return;
        }
        m53190CY();
        m53188CW();
        mo20700bk(false);
        Rect boardRect = getBoardRect();
        C36398c c36398c = new C36398c(C4996ah.getContext(), getMainMatrix(), c24666c.mo33616ac(true), c8955k, boardRect);
        c36398c.setSelected(true);
        float[] A = mo20689A((float) boardRect.centerX(), (float) boardRect.centerY());
        c36398c.mo57319a(A[0], A[1], this.cjc.getInitScale() / this.cjc.getCurScale(), (int) getRotation());
        c24666c.mo41561a(c36398c);
        mo20696CP();
        m53189CX();
        AppMethodBeat.m2505o(116196);
    }

    /* renamed from: a */
    public final void mo53132a(C36890e c36890e, SpannableString spannableString, int i, int i2) {
        AppMethodBeat.m2504i(116197);
        C24666c c24666c = (C24666c) mo20691CI();
        if (c24666c == null) {
            C4990ab.m7420w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            AppMethodBeat.m2505o(116197);
            return;
        }
        C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", c36890e.eHf);
        if (c24666c.efp != null && c24666c.efp.size() > 0) {
            if (((C36398c) c24666c.efp.peek()).eHf.equalsIgnoreCase(r1)) {
                c24666c.efp.pop();
            } else {
                C4990ab.m7413e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", r1, (C36398c) c24666c.efp.peek());
            }
        }
        c36890e.setSelected(true);
        c36890e.eHn = true;
        m53190CY();
        m53188CW();
        mo20700bk(true);
        if (!C5046bo.m7519ac(spannableString)) {
            C36890e c36890e2 = new C36890e(C4996ah.getContext(), getMainMatrix(), c24666c.mo33616ac(true), getBoardRect(), spannableString, i, i2);
            c36890e2.setSelected(true);
            PointF pointF = c36890e.eHi;
            c36890e2.mo57319a(pointF.x, pointF.y, this.cjc.getInitScale() / this.cjc.getCurScale(), c36890e.mRotation);
            c36890e2.mScale = c36890e.mScale;
            c24666c.mo41561a(c36890e2);
        }
        mo20696CP();
        m53189CX();
        AppMethodBeat.m2505o(116197);
    }
}
