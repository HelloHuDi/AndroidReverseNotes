package com.tencent.p177mm.p226e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.cache.C41918a;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p651y.C24186a;
import com.tencent.p177mm.p834b.C25851a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.view.p1096b.C30844a.C30845b;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.e.c */
public final class C1497c extends C9268b<C41918a> {
    public Rect cch;
    boolean cjA = false;
    boolean cjB = false;
    boolean cjC = false;
    boolean cjD = false;
    public boolean cjE = true;
    boolean cjF = false;
    float cjG;
    float cjH;
    float cjI;
    float cjJ;
    float cjK;
    float cjL;
    public ValueAnimator cjM;
    public Rect cjN = new Rect();
    public int cjO = 0;
    public boolean cjP = false;
    private int cjm = ((int) C4996ah.getResources().getDimension(C25738R.dimen.f10228v3));
    private int cjn = ((int) C4996ah.getResources().getDimension(C25738R.dimen.a26));
    private int cjo = ((int) C4996ah.getResources().getDimension(C25738R.dimen.f10330y9));
    private Matrix cjp = new Matrix();
    private RectF cjq;
    private RectF cjr;
    private RectF cjs;
    private RectF cjt;
    public final Rect cju = new Rect();
    private C24186a cjv;
    private boolean cjw = false;
    private boolean cjx = false;
    public C25851a cjy;
    boolean cjz = false;

    /* renamed from: com.tencent.mm.e.c$1 */
    class C14951 implements C30845b {
        C14951() {
        }

        /* renamed from: CV */
        public final void mo4946CV() {
            AppMethodBeat.m2504i(116149);
            if (((C41918a) C1497c.this.mo20691CI()).efr.isIdentity()) {
                C41918a c41918a = (C41918a) C1497c.this.mo20691CI();
                c41918a.efr.set(C1497c.this.getMainMatrix());
            }
            Rect rect = new Rect();
            if (C1497c.this.cjc.dlV() == null) {
                rect.set(0, 0, C1497c.this.cjc.dlT().getBaseBoardView().getBoardRect().width(), C1497c.this.cjc.dlT().getBaseBoardView().getBoardRect().height());
            } else {
                rect.set(0, 0, C1497c.this.cjc.dlV().getWidth(), C1497c.this.cjc.dlV().getHeight());
            }
            C1497c.this.cjc.dlT().getBaseBoardView().mo49350o(rect);
            C1497c.m3112a(C1497c.this, 200, true, false);
            C1497c.this.mo20697CQ();
            AppMethodBeat.m2505o(116149);
        }

        public final void onStart() {
            AppMethodBeat.m2504i(116150);
            C1497c.this.cjw = false;
            C1497c.this.cjE = false;
            AppMethodBeat.m2505o(116150);
        }
    }

    /* renamed from: com.tencent.mm.e.c$9 */
    public class C14989 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(116164);
            C1497c.this.cjw = false;
            C1497c.this.cjE = true;
            C1497c.this.cjx = true;
            AppMethodBeat.m2505o(116164);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(116165);
            C4990ab.m7416i("MicroMsg.CropArtist", "onAnimationEnd");
            C1497c.this.cjO = C1497c.this.cjO - 1;
            if (C1497c.this.cjO == 0) {
                C1497c.this.cjx = false;
                RectF rectF = new RectF();
                rectF.set(C1497c.this.cch);
                C1497c.this.cjp.mapRect(rectF);
                C1497c.this.cjp.reset();
                C1497c.this.cch.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                C1497c.this.mo4950CS();
            }
            C1497c.m3112a(C1497c.this, 200, false, true);
            AppMethodBeat.m2505o(116165);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.e.c$7 */
    public class C14997 implements C30845b {
        /* renamed from: CV */
        public final void mo4946CV() {
            AppMethodBeat.m2504i(116160);
            C1497c.this.getMainMatrix().set(((C41918a) C1497c.this.mo20691CI()).efr);
            C1497c.this.mo20697CQ();
            C1497c.m3112a(C1497c.this, 300, false, false);
            AppMethodBeat.m2505o(116160);
        }

        public final void onStart() {
            AppMethodBeat.m2504i(116161);
            C1497c.this.cjw = false;
            AppMethodBeat.m2505o(116161);
        }
    }

    /* renamed from: com.tencent.mm.e.c$3 */
    class C15003 implements AnimatorUpdateListener {
        C15003() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(116153);
            int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue();
            C1497c.this.cjv;
            C24186a.m37171jz(intValue2);
            C1497c.this.cjv;
            C24186a.m37170jA(intValue);
            C1497c.this.mo20696CP();
            AppMethodBeat.m2505o(116153);
        }
    }

    /* renamed from: com.tencent.mm.e.c$4 */
    class C15014 implements AnimatorListener {
        C15014() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(116154);
            C1497c.this.cjE = true;
            C1497c.this.cjw = true;
            AppMethodBeat.m2505o(116154);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(116155);
            C1497c.this.cjw = true;
            AppMethodBeat.m2505o(116155);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(116156);
            C1497c.this.cjw = false;
            animator.removeAllListeners();
            AppMethodBeat.m2505o(116156);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.e.c$5 */
    public class C15025 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(116157);
            C1497c.this.cjy.f13660uw = null;
            C1497c.m3116c(C1497c.this);
            AppMethodBeat.m2505o(116157);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(116158);
            C1497c.this.cjy.f13660uw = null;
            AppMethodBeat.m2505o(116158);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.e.c$8 */
    public class C15038 implements AnimatorUpdateListener {
        int ccA = 0;
        float ccB = ((float) Math.pow((double) this.ckb, 0.0833333358168602d));
        int cjS = 0;
        float cjT;
        float cjU = 0.0f;
        float cjV;
        float cjW = 0.0f;
        float cjX = this.cjZ;
        float cjY = this.cka;
        final /* synthetic */ float cjZ;
        final /* synthetic */ float cka;
        final /* synthetic */ float ckb;

        public C15038(float f, float f2, float f3) {
            this.cjZ = f;
            this.cka = f2;
            this.ckb = f3;
            AppMethodBeat.m2504i(116162);
            AppMethodBeat.m2505o(116162);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(116163);
            if (this.ccA < 12) {
                C1497c.this.getMainMatrix().postScale(this.ccB, this.ccB, ((float) C1497c.this.cch.centerX()) + this.cjU, ((float) C1497c.this.cch.centerY()) + this.cjW);
                C1497c.this.cjp.postScale(this.ccB, this.ccB, ((float) C1497c.this.cch.centerX()) + this.cjU, ((float) C1497c.this.cch.centerY()) + this.cjW);
                this.ccA++;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
            C1497c.this.getMainMatrix().postRotate((float) (intValue - this.cjS), this.cjZ + this.cjU, this.cka + this.cjW);
            C1497c.this.cjp.postRotate((float) (intValue - this.cjS), this.cjZ + this.cjU, this.cka + this.cjW);
            RectF rectF = new RectF();
            rectF.set(C1497c.this.cch);
            C1497c.this.cjp.mapRect(rectF);
            this.cjX += ((float) intValue2) - this.cjT;
            this.cjY += ((float) intValue3) - this.cjV;
            this.cjU = this.cjX - rectF.centerX();
            this.cjW = this.cjY - rectF.centerY();
            C1497c.this.getMainMatrix().postTranslate(this.cjU, this.cjW);
            C1497c.this.cjp.postTranslate(this.cjU, this.cjW);
            C1497c.this.mo20696CP();
            this.cjS = intValue;
            this.cjT = (float) intValue2;
            this.cjV = (float) intValue3;
            AppMethodBeat.m2505o(116163);
        }
    }

    /* renamed from: com.tencent.mm.e.c$2 */
    class C15042 implements C30845b {
        C15042() {
        }

        /* renamed from: CV */
        public final void mo4946CV() {
            AppMethodBeat.m2504i(116151);
            C1497c.this.cjE = true;
            C1497c.this.cjc.dlT().getBaseBoardView().mo49350o(new Rect(0, 0, C1497c.this.cjc.dlV().getWidth(), C1497c.this.cjc.dlV().getHeight()));
            C1497c.m3112a(C1497c.this, 200, true, false);
            AppMethodBeat.m2505o(116151);
        }

        public final void onStart() {
            AppMethodBeat.m2504i(116152);
            C1497c.this.cjw = false;
            C1497c.this.cjE = false;
            C1497c.this.cjv;
            C24186a.m37170jA(C31128d.MIC_PTU_BAIXI);
            AppMethodBeat.m2505o(116152);
        }
    }

    public C1497c() {
        AppMethodBeat.m2504i(116166);
        AppMethodBeat.m2505o(116166);
    }

    /* renamed from: c */
    static /* synthetic */ void m3116c(C1497c c1497c) {
        AppMethodBeat.m2504i(116177);
        c1497c.mo4952CU();
        AppMethodBeat.m2505o(116177);
    }

    /* renamed from: CG */
    public final C1493a mo4943CG() {
        return C1493a.CROP_PHOTO;
    }

    /* renamed from: a */
    public final void mo4953a(C18117b c18117b, Matrix matrix, Rect rect) {
        AppMethodBeat.m2504i(116167);
        super.mo4953a(c18117b, matrix, rect);
        this.cch = new Rect();
        this.cjr = new RectF();
        this.cjq = new RectF();
        this.cjs = new RectF();
        this.cjt = new RectF();
        this.cjv = new C24186a(this.cch);
        this.cjy = new C25851a(this);
        AppMethodBeat.m2505o(116167);
    }

    /* renamed from: zC */
    public final void mo4955zC() {
        AppMethodBeat.m2504i(116168);
        super.mo4955zC();
        if (this.cju.isEmpty()) {
            this.cju.set(this.cjm, this.cjm * 2, getBoardRect().width() - this.cjm, ((getBoardRect().height() - this.cjn) - this.cjo) - (this.cjm * 2));
        }
        C4990ab.m7417i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", this.cju);
        C24186a Jg = ((C41918a) mo20691CI()).mo67564Jg();
        if (!(Jg == null || Jg.eHd.isEmpty())) {
            this.cjc.dlT().getBaseBoardView().mo49350o(Jg.eHd);
            C4990ab.m7417i("MicroMsg.CropArtist", "[onAlive] rotation:%s", Float.valueOf(mo20699b(Jg.mMatrix)));
            getMainMatrix().postRotate(-r1, (float) Jg.eHd.centerX(), (float) Jg.eHd.centerY());
        }
        AppMethodBeat.m2505o(116168);
    }

    /* renamed from: CJ */
    public final void mo4948CJ() {
        AppMethodBeat.m2504i(116169);
        super.mo4948CJ();
        this.cjc.dlT().getActionBar().setVisibility(8);
        this.cjN.setEmpty();
        C24186a c24186a;
        if (((C41918a) mo20691CI()).mo33616ac(true) <= 0) {
            c24186a = new C24186a();
            c24186a.mMatrix.set(getMainMatrix());
            ((C41918a) mo20691CI()).mo67565a(c24186a);
            mo4951CT();
            this.cjc.dlT().getBaseBoardView().AbT = this.cch;
            this.cjc.dlT().getBaseBoardView().mo49332a(new C14951(), 0.0f, false);
        } else {
            c24186a = ((C41918a) mo20691CI()).mo67564Jg();
            if (c24186a == null) {
                C4990ab.m7412e("MicroMsg.CropArtist", "item is null!!!");
                AppMethodBeat.m2505o(116169);
                return;
            }
            this.cch.set(new Rect(c24186a.cch));
            this.cjc.dlT().getBaseBoardView().AbT = c24186a.cch;
            try {
                ((C41918a) mo20691CI()).mo67565a((C24186a) c24186a.clone());
            } catch (CloneNotSupportedException e) {
                C4990ab.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
            }
            this.cjc.dlT().getBaseBoardView().mo49332a(new C15042(), 0.0f, false);
        }
        setOneFingerMoveEnable(true);
        AppMethodBeat.m2505o(116169);
    }

    /* renamed from: CL */
    public final boolean mo4949CL() {
        AppMethodBeat.m2504i(116170);
        if (mo20691CI() == null) {
            AppMethodBeat.m2505o(116170);
            return false;
        } else if (((C41918a) mo20691CI()).efr.equals(getMainMatrix())) {
            AppMethodBeat.m2505o(116170);
            return false;
        } else {
            AppMethodBeat.m2505o(116170);
            return true;
        }
    }

    /* renamed from: CH */
    public final void mo4944CH() {
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116171);
        if (this.cjx) {
            canvas.setMatrix(this.cjp);
        } else {
            canvas.setMatrix(null);
        }
        C24186a c24186a = this.cjv;
        boolean z = this.cjE;
        boolean z2 = this.cjw;
        if (c24186a.cch == null) {
            C4990ab.m7412e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            AppMethodBeat.m2505o(116171);
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(c24186a.cch, Op.DIFFERENCE);
            canvas.drawPaint(C24186a.eGZ);
            canvas.restore();
        }
        if (z2) {
            if (!C24186a.f4451oT.equals(c24186a.cch)) {
                C24186a.eGW.reset();
                C24186a.eGW.moveTo((float) c24186a.cch.left, (float) c24186a.cch.top);
                C24186a.eGW.lineTo((float) c24186a.cch.right, (float) c24186a.cch.top);
                C24186a.eGW.lineTo((float) c24186a.cch.right, (float) c24186a.cch.bottom);
                C24186a.eGW.lineTo((float) c24186a.cch.left, (float) c24186a.cch.bottom);
                C24186a.eGW.close();
                C24186a.eGV.reset();
                for (int i = 1; i < 3; i++) {
                    C24186a.eGV.moveTo((float) (c24186a.cch.left + ((c24186a.cch.width() / 3) * i)), (float) c24186a.cch.top);
                    C24186a.eGV.lineTo((float) (c24186a.cch.left + ((c24186a.cch.width() / 3) * i)), (float) c24186a.cch.bottom);
                    C24186a.eGV.moveTo((float) c24186a.cch.left, (float) (c24186a.cch.top + ((c24186a.cch.height() / 3) * i)));
                    C24186a.eGV.lineTo((float) c24186a.cch.right, (float) (c24186a.cch.top + ((c24186a.cch.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) c24186a.cch.left, (float) c24186a.cch.top, (float) c24186a.cch.right, (float) c24186a.cch.bottom, C24186a.eGY);
            canvas.drawPath(C24186a.eGV, C24186a.eHa);
            canvas.drawPath(C24186a.eGW, C24186a.eGX);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) c24186a.cch.left) - C24186a.eGT, ((float) c24186a.cch.top) - (C24186a.eGT / 2.0f), C24186a.eGU + ((float) c24186a.cch.left), ((float) c24186a.cch.top) - (C24186a.eGT / 2.0f), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((C24186a.eGT / 2.0f) + (((float) c24186a.cch.right) - C24186a.eGU), ((float) c24186a.cch.top) - (C24186a.eGT / 2.0f), C24186a.eGT + ((float) c24186a.cch.right), ((float) c24186a.cch.top) - (C24186a.eGT / 2.0f), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) c24186a.cch.left) - (C24186a.eGT / 2.0f), ((float) c24186a.cch.top) - (C24186a.eGT / 2.0f), ((float) c24186a.cch.left) - (C24186a.eGT / 2.0f), C24186a.eGU + ((float) c24186a.cch.top), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) c24186a.cch.left) - (C24186a.eGT / 2.0f), (C24186a.eGT / 2.0f) + (((float) c24186a.cch.bottom) - C24186a.eGU), ((float) c24186a.cch.left) - (C24186a.eGT / 2.0f), (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((C24186a.eGT / 2.0f) + ((float) c24186a.cch.right), (float) c24186a.cch.top, (C24186a.eGT / 2.0f) + ((float) c24186a.cch.right), C24186a.eGU + ((float) c24186a.cch.top), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((C24186a.eGT / 2.0f) + ((float) c24186a.cch.right), (C24186a.eGT / 2.0f) + (((float) c24186a.cch.bottom) - C24186a.eGU), (C24186a.eGT / 2.0f) + ((float) c24186a.cch.right), (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) c24186a.cch.left) - C24186a.eGT, (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eGU + ((float) c24186a.cch.left), (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) c24186a.cch.right) - C24186a.eGU, (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eGT + ((float) c24186a.cch.right), (C24186a.eGT / 2.0f) + ((float) c24186a.cch.bottom), C24186a.eHb);
            if (!C24186a.f4451oT.equals(c24186a.cch)) {
                C24186a.f4451oT.set(c24186a.cch);
            }
        }
        AppMethodBeat.m2505o(116171);
    }

    /* renamed from: o */
    public final boolean mo4954o(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116172);
        if (mo20694CN()) {
            RectF curImageRect = this.cjc.dlT().getBaseBoardView().getCurImageRect();
            this.cjI = curImageRect.top - (curImageRect.bottom - ((float) this.cch.bottom));
            this.cjJ = curImageRect.bottom + (((float) this.cch.top) - curImageRect.top);
            this.cjK = curImageRect.left - (curImageRect.right - ((float) this.cch.right));
            this.cjL = curImageRect.right + (((float) this.cch.left) - curImageRect.left);
            if (this.cjL > ((float) this.cju.right)) {
                this.cjL = (float) this.cju.right;
            }
            if (this.cjK < ((float) this.cjm)) {
                this.cjK = (float) this.cjm;
            }
            if (this.cjJ > ((float) this.cju.bottom)) {
                this.cjJ = (float) this.cju.bottom;
            }
            if (this.cjI < ((float) this.cjm)) {
                this.cjI = (float) this.cjm;
            }
            float width;
            float height;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.cjF = false;
                    if (this.cjy != null) {
                        this.cjy.cancel();
                    }
                    if (this.cjr.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.cjC = true;
                    }
                    if (this.cjq.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.cjB = true;
                    }
                    if (this.cjs.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.cjA = true;
                    }
                    if (this.cjt.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.cjD = true;
                    }
                    this.cjE = false;
                    if (m3110CR()) {
                        if (this.cjC && this.cjA) {
                            this.cjC = true;
                            this.cjA = true;
                            this.cjB = false;
                            this.cjD = false;
                        } else if (this.cjC && this.cjD) {
                            this.cjC = true;
                            this.cjA = false;
                            this.cjB = false;
                            this.cjD = true;
                        } else if (this.cjB && this.cjD) {
                            this.cjC = false;
                            this.cjA = false;
                            this.cjB = true;
                            this.cjD = true;
                        } else if (this.cjB && this.cjD) {
                            this.cjC = false;
                            this.cjA = false;
                            this.cjB = true;
                            this.cjD = true;
                        }
                        this.cjG = motionEvent.getX();
                        this.cjH = motionEvent.getY();
                        break;
                    }
                    break;
                case 1:
                    width = (((float) this.cju.width()) * 1.0f) / ((float) this.cch.width());
                    height = (((float) this.cju.height()) * 1.0f) / ((float) this.cch.height());
                    if (width >= height) {
                        width = height;
                    }
                    height = ((float) this.cju.centerX()) - ((float) this.cch.centerX());
                    float centerY = ((float) this.cju.centerY()) - ((float) this.cch.centerY());
                    if (this.cjF) {
                        this.cjy.cck = 1000;
                        C25851a c25851a = this.cjy;
                        Rect rect = this.cch;
                        c25851a.ccf = height;
                        c25851a.ccg = centerY;
                        c25851a.cch = rect;
                        c25851a.cci.set(c25851a.cch);
                        c25851a.cce = width;
                        this.cjy.play();
                    }
                    if (m3110CR()) {
                        this.cjz = true;
                    } else {
                        this.cjz = false;
                    }
                    this.cjC = false;
                    this.cjA = false;
                    this.cjB = false;
                    this.cjD = false;
                    mo20697CQ();
                    break;
                case 2:
                    this.cjF = true;
                    if (motionEvent.getPointerCount() == 1 && m3110CR()) {
                        Rect rect2;
                        if (this.cjD && this.cch.right >= this.cch.left) {
                            if (this.cch.right <= this.cju.right) {
                                if (motionEvent.getX() - this.cjG > ((float) (this.cju.right - this.cch.right))) {
                                    this.cch.right = this.cju.right;
                                } else {
                                    rect2 = this.cch;
                                    rect2.right = (int) (((float) rect2.right) + (motionEvent.getX() - this.cjG));
                                }
                            }
                            if (this.cch.right < this.cch.left + (this.cjm * 2)) {
                                this.cch.right = this.cch.left + (this.cjm * 2);
                            }
                            if (this.cch.right > this.cju.right) {
                                this.cch.right = this.cju.right;
                            }
                            if (((int) curImageRect.right) <= ((int) this.cjL) && ((int) curImageRect.right) <= this.cch.right) {
                                if (motionEvent.getX() - this.cjG > this.cjL - curImageRect.right) {
                                    getMainMatrix().postTranslate(this.cjL - curImageRect.right, 0.0f);
                                } else {
                                    getMainMatrix().postTranslate(motionEvent.getX() - this.cjG, 0.0f);
                                }
                            }
                            if (((float) this.cch.width()) > curImageRect.width() && this.cch.right < this.cju.right) {
                                height = ((float) this.cch.width()) / curImageRect.width();
                                getMainMatrix().postScale(height, height, (float) this.cch.left, (float) this.cch.centerY());
                            }
                        }
                        if (this.cjA && this.cch.right >= this.cch.left) {
                            if (this.cch.left >= this.cju.left) {
                                if (this.cjG - motionEvent.getX() > ((float) (this.cch.left - this.cju.left))) {
                                    this.cch.left = this.cju.left;
                                } else {
                                    rect2 = this.cch;
                                    rect2.left = (int) (((float) rect2.left) - (this.cjG - motionEvent.getX()));
                                }
                            }
                            if (this.cch.left > this.cch.right - (this.cjm * 2)) {
                                this.cch.left = this.cch.right - (this.cjm * 2);
                            }
                            if (this.cch.left < this.cju.left) {
                                this.cch.left = this.cju.left;
                            }
                            if (((int) curImageRect.left) >= ((int) this.cjK) && ((int) curImageRect.left) >= this.cch.left) {
                                if (this.cjG - motionEvent.getX() > curImageRect.left - this.cjK) {
                                    getMainMatrix().postTranslate(this.cjK - curImageRect.left, 0.0f);
                                } else {
                                    getMainMatrix().postTranslate(motionEvent.getX() - this.cjG, 0.0f);
                                }
                            }
                            if (((float) this.cch.width()) > curImageRect.width() && this.cch.left > this.cju.left) {
                                height = ((float) this.cch.width()) / curImageRect.width();
                                getMainMatrix().postScale(height, height, (float) this.cch.right, (float) this.cch.centerY());
                            }
                        }
                        if (this.cjB && this.cch.bottom >= this.cch.top) {
                            if (this.cch.top >= this.cju.top) {
                                if (this.cjH - motionEvent.getY() > ((float) (this.cch.top - this.cju.top))) {
                                    this.cch.top = this.cju.top;
                                } else {
                                    rect2 = this.cch;
                                    rect2.top = (int) (((float) rect2.top) - (this.cjH - motionEvent.getY()));
                                }
                            }
                            if (this.cch.top > this.cch.bottom - (this.cjm * 2)) {
                                this.cch.top = this.cch.bottom - (this.cjm * 2);
                            }
                            if (this.cch.top < this.cju.top) {
                                this.cch.top = this.cju.top;
                            }
                            if (((int) curImageRect.top) >= ((int) this.cjI) && ((int) curImageRect.top) >= this.cch.top) {
                                if (this.cjH - motionEvent.getY() > curImageRect.top - this.cjI) {
                                    getMainMatrix().postTranslate(0.0f, this.cjI - curImageRect.top);
                                } else {
                                    getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.cjH);
                                }
                            }
                            if (((float) this.cch.height()) > curImageRect.height() && this.cch.top > this.cju.top) {
                                height = ((float) this.cch.height()) / curImageRect.height();
                                getMainMatrix().postScale(height, height, (float) this.cch.centerX(), (float) this.cch.bottom);
                            }
                        }
                        if (this.cjC && this.cch.bottom >= this.cch.top) {
                            if (this.cch.bottom <= this.cju.bottom) {
                                if (motionEvent.getY() - this.cjH > ((float) (this.cju.bottom - this.cch.bottom))) {
                                    this.cch.bottom = this.cju.bottom;
                                } else {
                                    rect2 = this.cch;
                                    rect2.bottom = (int) (((float) rect2.bottom) + (motionEvent.getY() - this.cjH));
                                }
                            }
                            if (this.cch.bottom < this.cch.top + (this.cjm * 2)) {
                                this.cch.bottom = this.cch.top + (this.cjm * 2);
                            }
                            if (this.cch.bottom > this.cju.bottom) {
                                this.cch.bottom = this.cju.bottom;
                            }
                            if (((int) curImageRect.bottom) <= ((int) this.cjJ) && ((int) curImageRect.bottom) <= this.cch.bottom) {
                                if (motionEvent.getY() - this.cjH > this.cjJ - curImageRect.bottom) {
                                    getMainMatrix().postTranslate(0.0f, this.cjJ - curImageRect.bottom);
                                } else {
                                    getMainMatrix().postTranslate(0.0f, motionEvent.getY() - this.cjH);
                                }
                            }
                            if (((float) this.cch.height()) > curImageRect.height() && this.cch.bottom < this.cju.bottom) {
                                width = ((float) this.cch.height()) / curImageRect.height();
                                getMainMatrix().postScale(width, width, (float) this.cch.centerX(), (float) this.cch.top);
                            }
                        }
                        mo4950CS();
                        this.cjz = true;
                        mo20696CP();
                        this.cjG = motionEvent.getX();
                        this.cjH = motionEvent.getY();
                    } else {
                        this.cjz = false;
                    }
                    mo20709r(motionEvent);
                    break;
                case 5:
                    this.cjC = false;
                    this.cjA = false;
                    this.cjB = false;
                    this.cjD = false;
                    this.cjz = false;
                    break;
            }
            boolean z = this.cjz;
            AppMethodBeat.m2505o(116172);
            return z;
        }
        AppMethodBeat.m2505o(116172);
        return false;
    }

    /* renamed from: CR */
    private boolean m3110CR() {
        return this.cjC || this.cjA || this.cjB || this.cjD;
    }

    /* renamed from: CS */
    public final void mo4950CS() {
        AppMethodBeat.m2504i(116173);
        this.cjr.set((float) (this.cch.left - this.cjm), (float) (this.cch.bottom - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.bottom + this.cjm));
        this.cjq.set((float) (this.cch.left - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.top + this.cjm));
        this.cjs.set((float) (this.cch.left - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.left + this.cjm), (float) (this.cch.bottom + this.cjm));
        this.cjt.set((float) (this.cch.right - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.bottom + this.cjm));
        AppMethodBeat.m2505o(116173);
    }

    /* renamed from: CT */
    public final void mo4951CT() {
        AppMethodBeat.m2504i(116174);
        if (this.cjc.dlV() == null) {
            C4990ab.m7420w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
            AppMethodBeat.m2505o(116174);
            return;
        }
        float width = (((float) this.cjc.dlV().getWidth()) * 1.0f) / ((float) this.cjc.dlV().getHeight());
        int width2;
        if (width < (((float) this.cju.width()) * 1.0f) / ((float) this.cju.height())) {
            width2 = (int) ((((float) this.cju.width()) - (width * ((float) this.cju.height()))) / 2.0f);
            this.cch.set(this.cju.left + width2, this.cju.top, this.cju.right - width2, this.cju.bottom);
        } else {
            width2 = (int) ((((float) this.cju.height()) - (((float) this.cju.width()) / width)) / 2.0f);
            this.cch.set(this.cju.left, this.cju.top + width2, this.cju.right, this.cju.bottom - width2);
        }
        mo4950CS();
        AppMethodBeat.m2505o(116174);
    }

    /* renamed from: CU */
    public final void mo4952CU() {
        AppMethodBeat.m2504i(116175);
        this.cjc.dlT().getBaseBoardView().AbT = this.cjc.dlT().getBaseBoardView().getRawBoardRect();
        RectF rectF = new RectF(this.cch);
        Matrix matrix = new Matrix();
        getMainMatrix().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.cjc.dlT().getBaseBoardView().mo49350o(rect);
        final C24186a c24186a = new C24186a();
        c24186a.cch = new Rect(this.cch);
        c24186a.eHd.set(rect);
        this.cjc.dlT().getBaseBoardView().mo49332a(new C30845b() {
            /* renamed from: CV */
            public final void mo4946CV() {
                AppMethodBeat.m2504i(116159);
                C24186a c24186a = c24186a;
                c24186a.mMatrix.set(C1497c.this.getMainMatrix());
                C41918a c41918a = (C41918a) C1497c.this.mo20691CI();
                if (c41918a.efp != null) {
                    c41918a.efp.clear();
                }
                ((C41918a) C1497c.this.mo20691CI()).mo67565a(c24186a);
                AppMethodBeat.m2505o(116159);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        this.cjc.dlT().getActionBar().setVisibility(0);
        AppMethodBeat.m2505o(116175);
    }

    /* renamed from: a */
    static /* synthetic */ void m3112a(C1497c c1497c, long j, boolean z, boolean z2) {
        PropertyValuesHolder ofInt;
        AppMethodBeat.m2504i(116176);
        if (c1497c.cjM != null) {
            c1497c.cjM.cancel();
        }
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        if (z) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{C31128d.MIC_PTU_BAIXI, 255});
        } else if (z2) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255});
        } else {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        }
        c1497c.cjM = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt});
        c1497c.cjM.addUpdateListener(new C15003());
        c1497c.cjM.addListener(new C15014());
        c1497c.cjM.setStartDelay(j);
        c1497c.cjM.setDuration(300);
        c1497c.cjM.start();
        AppMethodBeat.m2505o(116176);
    }
}
