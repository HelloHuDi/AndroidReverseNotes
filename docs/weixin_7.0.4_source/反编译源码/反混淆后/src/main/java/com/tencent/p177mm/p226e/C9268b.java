package com.tencent.p177mm.p226e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C18128d;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.view.C16051a;

/* renamed from: com.tencent.mm.e.b */
public abstract class C9268b<T extends C18128d> {
    public static final C9268b cjg = new C14941();
    private boolean bYT;
    public boolean bZq;
    public C18117b cjc;
    private Matrix cjd;
    Rect cje;
    private Bitmap cjf;
    private Canvas cjh = new Canvas();
    private Runnable cji;
    PointF cjj = new PointF();
    private PointF cjk = new PointF();
    private Context mContext;
    float[] values = new float[9];

    /* renamed from: com.tencent.mm.e.b$1 */
    static class C14941 extends C9268b {
        C14941() {
        }

        /* renamed from: CG */
        public final C1493a mo4943CG() {
            return C1493a.DEFAULT;
        }

        /* renamed from: CH */
        public final void mo4944CH() {
        }

        public final void onDraw(Canvas canvas) {
        }
    }

    /* renamed from: com.tencent.mm.e.b$2 */
    class C92672 implements Runnable {
        C92672() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116148);
            C9268b.this.mo4944CH();
            C9268b.this.mo20696CP();
            C9268b.this.cji = null;
            AppMethodBeat.m2505o(116148);
        }
    }

    /* renamed from: CG */
    public abstract C1493a mo4943CG();

    /* renamed from: CH */
    public abstract void mo4944CH();

    public abstract void onDraw(Canvas canvas);

    /* renamed from: a */
    public final void mo20698a(Canvas canvas) {
        if (this.cjf != null && !this.cjf.isRecycled()) {
            canvas.drawBitmap(this.cjf, 0.0f, 0.0f, null);
        }
    }

    /* renamed from: a */
    public void mo4953a(C18117b c18117b, Matrix matrix, Rect rect) {
        C4990ab.m7416i("MicroMsg.BaseArtist" + mo4943CG(), "[onCreate]");
        this.bZq = true;
        this.mContext = c18117b.getContext();
        this.cjc = c18117b;
        this.cjd = matrix;
        this.cje = rect;
    }

    /* renamed from: zC */
    public void mo4955zC() {
        C4990ab.m7417i("MicroMsg.BaseArtist" + mo4943CG(), "[onAlive] isAlive:%s", Boolean.valueOf(this.bYT));
        if (!this.bYT) {
            this.bYT = true;
            C18128d CI = mo20691CI();
            if (CI != null) {
                CI.mo33614Je();
                CI.mo33619by(false);
            } else {
                C4990ab.m7413e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", mo4943CG());
            }
            this.cjf = mo20693CM();
        }
    }

    /* renamed from: CJ */
    public void mo4948CJ() {
        C4990ab.m7416i("MicroMsg.BaseArtist" + mo4943CG(), "[onSelected] ");
    }

    public final void onFinish() {
        C4990ab.m7417i("MicroMsg.BaseArtist", "[onFinish] type:%s", mo4943CG());
        this.bYT = false;
        this.bZq = false;
        C18128d CI = mo20691CI();
        if (CI != null) {
            CI.mo33619by(true);
        } else {
            C4990ab.m7413e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", mo4943CG());
        }
        mo20692CK();
    }

    public void onDestroy() {
        this.bZq = false;
        this.bYT = false;
        C4990ab.m7416i("MicroMsg.BaseArtist" + mo4943CG(), "[onDestroy]");
        mo20692CK();
    }

    /* renamed from: CK */
    public final void mo20692CK() {
        if (this.cjf != null && !this.cjf.isRecycled()) {
            this.cjf.recycle();
        }
    }

    /* renamed from: CL */
    public boolean mo4949CL() {
        try {
            if (mo20691CI().mo33616ac(true) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: bk */
    public void mo20700bk(boolean z) {
        this.cjh.setBitmap(mo20693CM());
        C18128d CI = mo20691CI();
        if (CI != null) {
            CI.mo33615a(this.cjh, z);
        } else {
            C4990ab.m7416i("MicroMsg.BaseArtist", "updateCache: cache is null");
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: CM */
    public final Bitmap mo20693CM() {
        if (this.cjf == null || this.cjf.isRecycled()) {
            int width;
            int height;
            Rect imageBitmapRect = this.cjc.dlT().getBaseBoardView().getImageBitmapRect();
            if (imageBitmapRect.isEmpty() || !this.cjc.dlT().getBaseBoardView().dMM()) {
                width = this.cjc.dlT().getBaseBoardView().getBoardRect().width();
                height = this.cjc.dlT().getBaseBoardView().getBoardRect().height();
            } else {
                width = imageBitmapRect.width();
                height = imageBitmapRect.height();
            }
            this.cjf = Bitmap.createBitmap(width, height, Config.ARGB_4444);
        }
        return this.cjf;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: o */
    public final void mo20706o(Bitmap bitmap) {
        if (!(mo20693CM() == null || mo20693CM().isRecycled())) {
            mo20693CM().recycle();
        }
        this.cjf = bitmap;
    }

    public final boolean isAlive() {
        return this.bZq && this.bYT;
    }

    /* renamed from: CO */
    public final void mo20695CO() {
        if (mo20691CI().pop() != null) {
            mo20691CI().mo33613CO();
        }
        this.cjc.dlT().removeCallbacks(this.cji);
        C16051a dlT = this.cjc.dlT();
        C92672 c92672 = new C92672();
        this.cji = c92672;
        dlT.postDelayed(c92672, 66);
    }

    /* renamed from: o */
    public boolean mo4954o(MotionEvent motionEvent) {
        if (mo20710s(motionEvent)) {
            mo20709r(motionEvent);
        }
        return false;
    }

    public final float getScale() {
        float a = m16794a(this.cjd, 3);
        float a2 = m16794a(this.cjd, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) m16794a(this.cjd, 1), (double) m16794a(this.cjd, 0)) * 57.29577951308232d);
    }

    /* renamed from: b */
    public final float mo20699b(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) m16794a(matrix, 1), (double) m16794a(matrix, 0)) * 57.29577951308232d);
    }

    /* renamed from: a */
    private float m16794a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: A */
    public final float[] mo20689A(float f, float f2) {
        Matrix matrix = new Matrix(this.cjd);
        this.cjd.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: B */
    public final float[] mo20690B(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.cjd.mapPoints(fArr);
        return fArr;
    }

    /* renamed from: p */
    protected static int m16796p(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    /* renamed from: q */
    protected static int[] m16797q(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: r */
    public final void mo20709r(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.cjk.x = motionEvent.getX(1);
            this.cjk.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerCount() == 1) {
            this.cjj.x = motionEvent.getX(0);
            this.cjj.y = motionEvent.getY(0);
        }
        if (motionEvent.getActionMasked() != 6) {
            return;
        }
        if (motionEvent.getPointerCount() <= 1 || 1 - motionEvent.getActionIndex() < 0 || 1 - motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
            this.cjj.x = motionEvent.getX(0);
            this.cjj.y = motionEvent.getY(0);
            return;
        }
        this.cjj.x = motionEvent.getX(1 - motionEvent.getActionIndex());
        this.cjj.y = motionEvent.getY(1 - motionEvent.getActionIndex());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: s */
    public final boolean mo20710s(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (Math.abs(this.cjj.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.cjj.y - motionEvent.getY(0)) > 3.0f || Math.abs(this.cjk.x - motionEvent.getX(1)) > 3.0f || Math.abs(this.cjk.y - motionEvent.getY(1)) > 3.0f) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            if (Math.abs(this.cjj.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.cjj.y - motionEvent.getY(0)) > 3.0f) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: CI */
    public final T mo20691CI() {
        return this.cjc.mo33561a(mo4943CG());
    }

    public final void setOneFingerMoveEnable(boolean z) {
        this.cjc.dlT().getBaseBoardView().setOneFingerMoveEnable(z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: CN */
    public final boolean mo20694CN() {
        return this.cjc.dlU().mo4943CG() == mo4943CG();
    }

    /* Access modifiers changed, original: protected|final */
    public final Rect getBoardRect() {
        return this.cjc.dlT().getBaseBoardView().getBoardRect();
    }

    public final Matrix getMainMatrix() {
        return this.cjc.dlT().getBaseBoardView().getMainMatrix();
    }

    /* renamed from: CP */
    public final void mo20696CP() {
        this.cjc.dlT().getBaseBoardView().postInvalidate();
    }

    /* renamed from: CQ */
    public final void mo20697CQ() {
        this.cjc.dlT().getBaseFooterView().postInvalidate();
    }
}
