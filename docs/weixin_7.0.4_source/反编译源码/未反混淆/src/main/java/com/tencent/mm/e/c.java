package com.tencent.mm.e;

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
import com.tencent.mm.R;
import com.tencent.mm.br.b;
import com.tencent.mm.cache.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.view.d;

public final class c extends b<a> {
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
    private int cjm = ((int) ah.getResources().getDimension(R.dimen.v3));
    private int cjn = ((int) ah.getResources().getDimension(R.dimen.a26));
    private int cjo = ((int) ah.getResources().getDimension(R.dimen.y9));
    private Matrix cjp = new Matrix();
    private RectF cjq;
    private RectF cjr;
    private RectF cjs;
    private RectF cjt;
    public final Rect cju = new Rect();
    private com.tencent.mm.y.a cjv;
    private boolean cjw = false;
    private boolean cjx = false;
    public com.tencent.mm.b.a cjy;
    boolean cjz = false;

    /* renamed from: com.tencent.mm.e.c$8 */
    public class AnonymousClass8 implements AnimatorUpdateListener {
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

        public AnonymousClass8(float f, float f2, float f3) {
            this.cjZ = f;
            this.cka = f2;
            this.ckb = f3;
            AppMethodBeat.i(116162);
            AppMethodBeat.o(116162);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(116163);
            if (this.ccA < 12) {
                c.this.getMainMatrix().postScale(this.ccB, this.ccB, ((float) c.this.cch.centerX()) + this.cjU, ((float) c.this.cch.centerY()) + this.cjW);
                c.this.cjp.postScale(this.ccB, this.ccB, ((float) c.this.cch.centerX()) + this.cjU, ((float) c.this.cch.centerY()) + this.cjW);
                this.ccA++;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
            c.this.getMainMatrix().postRotate((float) (intValue - this.cjS), this.cjZ + this.cjU, this.cka + this.cjW);
            c.this.cjp.postRotate((float) (intValue - this.cjS), this.cjZ + this.cjU, this.cka + this.cjW);
            RectF rectF = new RectF();
            rectF.set(c.this.cch);
            c.this.cjp.mapRect(rectF);
            this.cjX += ((float) intValue2) - this.cjT;
            this.cjY += ((float) intValue3) - this.cjV;
            this.cjU = this.cjX - rectF.centerX();
            this.cjW = this.cjY - rectF.centerY();
            c.this.getMainMatrix().postTranslate(this.cjU, this.cjW);
            c.this.cjp.postTranslate(this.cjU, this.cjW);
            c.this.CP();
            this.cjS = intValue;
            this.cjT = (float) intValue2;
            this.cjV = (float) intValue3;
            AppMethodBeat.o(116163);
        }
    }

    public c() {
        AppMethodBeat.i(116166);
        AppMethodBeat.o(116166);
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(116177);
        cVar.CU();
        AppMethodBeat.o(116177);
    }

    public final a CG() {
        return a.CROP_PHOTO;
    }

    public final void a(b bVar, Matrix matrix, Rect rect) {
        AppMethodBeat.i(116167);
        super.a(bVar, matrix, rect);
        this.cch = new Rect();
        this.cjr = new RectF();
        this.cjq = new RectF();
        this.cjs = new RectF();
        this.cjt = new RectF();
        this.cjv = new com.tencent.mm.y.a(this.cch);
        this.cjy = new com.tencent.mm.b.a(this);
        AppMethodBeat.o(116167);
    }

    public final void zC() {
        AppMethodBeat.i(116168);
        super.zC();
        if (this.cju.isEmpty()) {
            this.cju.set(this.cjm, this.cjm * 2, getBoardRect().width() - this.cjm, ((getBoardRect().height() - this.cjn) - this.cjo) - (this.cjm * 2));
        }
        ab.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", this.cju);
        com.tencent.mm.y.a Jg = ((a) CI()).Jg();
        if (!(Jg == null || Jg.eHd.isEmpty())) {
            this.cjc.dlT().getBaseBoardView().o(Jg.eHd);
            ab.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", Float.valueOf(b(Jg.mMatrix)));
            getMainMatrix().postRotate(-r1, (float) Jg.eHd.centerX(), (float) Jg.eHd.centerY());
        }
        AppMethodBeat.o(116168);
    }

    public final void CJ() {
        AppMethodBeat.i(116169);
        super.CJ();
        this.cjc.dlT().getActionBar().setVisibility(8);
        this.cjN.setEmpty();
        com.tencent.mm.y.a aVar;
        if (((a) CI()).ac(true) <= 0) {
            aVar = new com.tencent.mm.y.a();
            aVar.mMatrix.set(getMainMatrix());
            ((a) CI()).a(aVar);
            CT();
            this.cjc.dlT().getBaseBoardView().AbT = this.cch;
            this.cjc.dlT().getBaseBoardView().a(new com.tencent.mm.view.b.a.b() {
                public final void CV() {
                    AppMethodBeat.i(116149);
                    if (((a) c.this.CI()).efr.isIdentity()) {
                        a aVar = (a) c.this.CI();
                        aVar.efr.set(c.this.getMainMatrix());
                    }
                    Rect rect = new Rect();
                    if (c.this.cjc.dlV() == null) {
                        rect.set(0, 0, c.this.cjc.dlT().getBaseBoardView().getBoardRect().width(), c.this.cjc.dlT().getBaseBoardView().getBoardRect().height());
                    } else {
                        rect.set(0, 0, c.this.cjc.dlV().getWidth(), c.this.cjc.dlV().getHeight());
                    }
                    c.this.cjc.dlT().getBaseBoardView().o(rect);
                    c.a(c.this, 200, true, false);
                    c.this.CQ();
                    AppMethodBeat.o(116149);
                }

                public final void onStart() {
                    AppMethodBeat.i(116150);
                    c.this.cjw = false;
                    c.this.cjE = false;
                    AppMethodBeat.o(116150);
                }
            }, 0.0f, false);
        } else {
            aVar = ((a) CI()).Jg();
            if (aVar == null) {
                ab.e("MicroMsg.CropArtist", "item is null!!!");
                AppMethodBeat.o(116169);
                return;
            }
            this.cch.set(new Rect(aVar.cch));
            this.cjc.dlT().getBaseBoardView().AbT = aVar.cch;
            try {
                ((a) CI()).a((com.tencent.mm.y.a) aVar.clone());
            } catch (CloneNotSupportedException e) {
                ab.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
            }
            this.cjc.dlT().getBaseBoardView().a(new com.tencent.mm.view.b.a.b() {
                public final void CV() {
                    AppMethodBeat.i(116151);
                    c.this.cjE = true;
                    c.this.cjc.dlT().getBaseBoardView().o(new Rect(0, 0, c.this.cjc.dlV().getWidth(), c.this.cjc.dlV().getHeight()));
                    c.a(c.this, 200, true, false);
                    AppMethodBeat.o(116151);
                }

                public final void onStart() {
                    AppMethodBeat.i(116152);
                    c.this.cjw = false;
                    c.this.cjE = false;
                    c.this.cjv;
                    com.tencent.mm.y.a.jA(d.MIC_PTU_BAIXI);
                    AppMethodBeat.o(116152);
                }
            }, 0.0f, false);
        }
        setOneFingerMoveEnable(true);
        AppMethodBeat.o(116169);
    }

    public final boolean CL() {
        AppMethodBeat.i(116170);
        if (CI() == null) {
            AppMethodBeat.o(116170);
            return false;
        } else if (((a) CI()).efr.equals(getMainMatrix())) {
            AppMethodBeat.o(116170);
            return false;
        } else {
            AppMethodBeat.o(116170);
            return true;
        }
    }

    public final void CH() {
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(116171);
        if (this.cjx) {
            canvas.setMatrix(this.cjp);
        } else {
            canvas.setMatrix(null);
        }
        com.tencent.mm.y.a aVar = this.cjv;
        boolean z = this.cjE;
        boolean z2 = this.cjw;
        if (aVar.cch == null) {
            ab.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            AppMethodBeat.o(116171);
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.cch, Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.y.a.eGZ);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.y.a.oT.equals(aVar.cch)) {
                com.tencent.mm.y.a.eGW.reset();
                com.tencent.mm.y.a.eGW.moveTo((float) aVar.cch.left, (float) aVar.cch.top);
                com.tencent.mm.y.a.eGW.lineTo((float) aVar.cch.right, (float) aVar.cch.top);
                com.tencent.mm.y.a.eGW.lineTo((float) aVar.cch.right, (float) aVar.cch.bottom);
                com.tencent.mm.y.a.eGW.lineTo((float) aVar.cch.left, (float) aVar.cch.bottom);
                com.tencent.mm.y.a.eGW.close();
                com.tencent.mm.y.a.eGV.reset();
                for (int i = 1; i < 3; i++) {
                    com.tencent.mm.y.a.eGV.moveTo((float) (aVar.cch.left + ((aVar.cch.width() / 3) * i)), (float) aVar.cch.top);
                    com.tencent.mm.y.a.eGV.lineTo((float) (aVar.cch.left + ((aVar.cch.width() / 3) * i)), (float) aVar.cch.bottom);
                    com.tencent.mm.y.a.eGV.moveTo((float) aVar.cch.left, (float) (aVar.cch.top + ((aVar.cch.height() / 3) * i)));
                    com.tencent.mm.y.a.eGV.lineTo((float) aVar.cch.right, (float) (aVar.cch.top + ((aVar.cch.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) aVar.cch.left, (float) aVar.cch.top, (float) aVar.cch.right, (float) aVar.cch.bottom, com.tencent.mm.y.a.eGY);
            canvas.drawPath(com.tencent.mm.y.a.eGV, com.tencent.mm.y.a.eHa);
            canvas.drawPath(com.tencent.mm.y.a.eGW, com.tencent.mm.y.a.eGX);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) aVar.cch.left) - com.tencent.mm.y.a.eGT, ((float) aVar.cch.top) - (com.tencent.mm.y.a.eGT / 2.0f), com.tencent.mm.y.a.eGU + ((float) aVar.cch.left), ((float) aVar.cch.top) - (com.tencent.mm.y.a.eGT / 2.0f), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.y.a.eGT / 2.0f) + (((float) aVar.cch.right) - com.tencent.mm.y.a.eGU), ((float) aVar.cch.top) - (com.tencent.mm.y.a.eGT / 2.0f), com.tencent.mm.y.a.eGT + ((float) aVar.cch.right), ((float) aVar.cch.top) - (com.tencent.mm.y.a.eGT / 2.0f), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.cch.left) - (com.tencent.mm.y.a.eGT / 2.0f), ((float) aVar.cch.top) - (com.tencent.mm.y.a.eGT / 2.0f), ((float) aVar.cch.left) - (com.tencent.mm.y.a.eGT / 2.0f), com.tencent.mm.y.a.eGU + ((float) aVar.cch.top), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.cch.left) - (com.tencent.mm.y.a.eGT / 2.0f), (com.tencent.mm.y.a.eGT / 2.0f) + (((float) aVar.cch.bottom) - com.tencent.mm.y.a.eGU), ((float) aVar.cch.left) - (com.tencent.mm.y.a.eGT / 2.0f), (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.right), (float) aVar.cch.top, (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.right), com.tencent.mm.y.a.eGU + ((float) aVar.cch.top), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.right), (com.tencent.mm.y.a.eGT / 2.0f) + (((float) aVar.cch.bottom) - com.tencent.mm.y.a.eGU), (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.right), (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.cch.left) - com.tencent.mm.y.a.eGT, (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eGU + ((float) aVar.cch.left), (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eHb);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.cch.right) - com.tencent.mm.y.a.eGU, (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eGT + ((float) aVar.cch.right), (com.tencent.mm.y.a.eGT / 2.0f) + ((float) aVar.cch.bottom), com.tencent.mm.y.a.eHb);
            if (!com.tencent.mm.y.a.oT.equals(aVar.cch)) {
                com.tencent.mm.y.a.oT.set(aVar.cch);
            }
        }
        AppMethodBeat.o(116171);
    }

    public final boolean o(MotionEvent motionEvent) {
        AppMethodBeat.i(116172);
        if (CN()) {
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
                    if (CR()) {
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
                        com.tencent.mm.b.a aVar = this.cjy;
                        Rect rect = this.cch;
                        aVar.ccf = height;
                        aVar.ccg = centerY;
                        aVar.cch = rect;
                        aVar.cci.set(aVar.cch);
                        aVar.cce = width;
                        this.cjy.play();
                    }
                    if (CR()) {
                        this.cjz = true;
                    } else {
                        this.cjz = false;
                    }
                    this.cjC = false;
                    this.cjA = false;
                    this.cjB = false;
                    this.cjD = false;
                    CQ();
                    break;
                case 2:
                    this.cjF = true;
                    if (motionEvent.getPointerCount() == 1 && CR()) {
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
                        CS();
                        this.cjz = true;
                        CP();
                        this.cjG = motionEvent.getX();
                        this.cjH = motionEvent.getY();
                    } else {
                        this.cjz = false;
                    }
                    r(motionEvent);
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
            AppMethodBeat.o(116172);
            return z;
        }
        AppMethodBeat.o(116172);
        return false;
    }

    private boolean CR() {
        return this.cjC || this.cjA || this.cjB || this.cjD;
    }

    public final void CS() {
        AppMethodBeat.i(116173);
        this.cjr.set((float) (this.cch.left - this.cjm), (float) (this.cch.bottom - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.bottom + this.cjm));
        this.cjq.set((float) (this.cch.left - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.top + this.cjm));
        this.cjs.set((float) (this.cch.left - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.left + this.cjm), (float) (this.cch.bottom + this.cjm));
        this.cjt.set((float) (this.cch.right - this.cjm), (float) (this.cch.top - this.cjm), (float) (this.cch.right + this.cjm), (float) (this.cch.bottom + this.cjm));
        AppMethodBeat.o(116173);
    }

    public final void CT() {
        AppMethodBeat.i(116174);
        if (this.cjc.dlV() == null) {
            ab.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
            AppMethodBeat.o(116174);
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
        CS();
        AppMethodBeat.o(116174);
    }

    public final void CU() {
        AppMethodBeat.i(116175);
        this.cjc.dlT().getBaseBoardView().AbT = this.cjc.dlT().getBaseBoardView().getRawBoardRect();
        RectF rectF = new RectF(this.cch);
        Matrix matrix = new Matrix();
        getMainMatrix().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.cjc.dlT().getBaseBoardView().o(rect);
        final com.tencent.mm.y.a aVar = new com.tencent.mm.y.a();
        aVar.cch = new Rect(this.cch);
        aVar.eHd.set(rect);
        this.cjc.dlT().getBaseBoardView().a(new com.tencent.mm.view.b.a.b() {
            public final void CV() {
                AppMethodBeat.i(116159);
                com.tencent.mm.y.a aVar = aVar;
                aVar.mMatrix.set(c.this.getMainMatrix());
                a aVar2 = (a) c.this.CI();
                if (aVar2.efp != null) {
                    aVar2.efp.clear();
                }
                ((a) c.this.CI()).a(aVar);
                AppMethodBeat.o(116159);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        this.cjc.dlT().getActionBar().setVisibility(0);
        AppMethodBeat.o(116175);
    }

    static /* synthetic */ void a(c cVar, long j, boolean z, boolean z2) {
        PropertyValuesHolder ofInt;
        AppMethodBeat.i(116176);
        if (cVar.cjM != null) {
            cVar.cjM.cancel();
        }
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        if (z) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{d.MIC_PTU_BAIXI, 255});
        } else if (z2) {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255});
        } else {
            ofInt = PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        }
        cVar.cjM = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt});
        cVar.cjM.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(116153);
                int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
                int intValue2 = ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue();
                c.this.cjv;
                com.tencent.mm.y.a.jz(intValue2);
                c.this.cjv;
                com.tencent.mm.y.a.jA(intValue);
                c.this.CP();
                AppMethodBeat.o(116153);
            }
        });
        cVar.cjM.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(116154);
                c.this.cjE = true;
                c.this.cjw = true;
                AppMethodBeat.o(116154);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(116155);
                c.this.cjw = true;
                AppMethodBeat.o(116155);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(116156);
                c.this.cjw = false;
                animator.removeAllListeners();
                AppMethodBeat.o(116156);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        cVar.cjM.setStartDelay(j);
        cVar.cjM.setDuration(300);
        cVar.cjM.start();
        AppMethodBeat.o(116176);
    }
}
