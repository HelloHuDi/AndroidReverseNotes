package com.tencent.mm.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.view.a;

public abstract class b<T extends d> {
    public static final b cjg = new b() {
        public final a CG() {
            return a.DEFAULT;
        }

        public final void CH() {
        }

        public final void onDraw(Canvas canvas) {
        }
    };
    private boolean bYT;
    public boolean bZq;
    public com.tencent.mm.br.b cjc;
    private Matrix cjd;
    Rect cje;
    private Bitmap cjf;
    private Canvas cjh = new Canvas();
    private Runnable cji;
    PointF cjj = new PointF();
    private PointF cjk = new PointF();
    private Context mContext;
    float[] values = new float[9];

    public abstract a CG();

    public abstract void CH();

    public abstract void onDraw(Canvas canvas);

    public final void a(Canvas canvas) {
        if (this.cjf != null && !this.cjf.isRecycled()) {
            canvas.drawBitmap(this.cjf, 0.0f, 0.0f, null);
        }
    }

    public void a(com.tencent.mm.br.b bVar, Matrix matrix, Rect rect) {
        ab.i("MicroMsg.BaseArtist" + CG(), "[onCreate]");
        this.bZq = true;
        this.mContext = bVar.getContext();
        this.cjc = bVar;
        this.cjd = matrix;
        this.cje = rect;
    }

    public void zC() {
        ab.i("MicroMsg.BaseArtist" + CG(), "[onAlive] isAlive:%s", Boolean.valueOf(this.bYT));
        if (!this.bYT) {
            this.bYT = true;
            d CI = CI();
            if (CI != null) {
                CI.Je();
                CI.by(false);
            } else {
                ab.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", CG());
            }
            this.cjf = CM();
        }
    }

    public void CJ() {
        ab.i("MicroMsg.BaseArtist" + CG(), "[onSelected] ");
    }

    public final void onFinish() {
        ab.i("MicroMsg.BaseArtist", "[onFinish] type:%s", CG());
        this.bYT = false;
        this.bZq = false;
        d CI = CI();
        if (CI != null) {
            CI.by(true);
        } else {
            ab.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", CG());
        }
        CK();
    }

    public void onDestroy() {
        this.bZq = false;
        this.bYT = false;
        ab.i("MicroMsg.BaseArtist" + CG(), "[onDestroy]");
        CK();
    }

    public final void CK() {
        if (this.cjf != null && !this.cjf.isRecycled()) {
            this.cjf.recycle();
        }
    }

    public boolean CL() {
        try {
            if (CI().ac(true) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void bk(boolean z) {
        this.cjh.setBitmap(CM());
        d CI = CI();
        if (CI != null) {
            CI.a(this.cjh, z);
        } else {
            ab.i("MicroMsg.BaseArtist", "updateCache: cache is null");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final Bitmap CM() {
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
    public final void o(Bitmap bitmap) {
        if (!(CM() == null || CM().isRecycled())) {
            CM().recycle();
        }
        this.cjf = bitmap;
    }

    public final boolean isAlive() {
        return this.bZq && this.bYT;
    }

    public final void CO() {
        if (CI().pop() != null) {
            CI().CO();
        }
        this.cjc.dlT().removeCallbacks(this.cji);
        a dlT = this.cjc.dlT();
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(116148);
                b.this.CH();
                b.this.CP();
                b.this.cji = null;
                AppMethodBeat.o(116148);
            }
        };
        this.cji = anonymousClass2;
        dlT.postDelayed(anonymousClass2, 66);
    }

    public boolean o(MotionEvent motionEvent) {
        if (s(motionEvent)) {
            r(motionEvent);
        }
        return false;
    }

    public final float getScale() {
        float a = a(this.cjd, 3);
        float a2 = a(this.cjd, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.cjd, 1), (double) a(this.cjd, 0)) * 57.29577951308232d);
    }

    public final float b(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    /* Access modifiers changed, original: protected|final */
    public final float[] A(float f, float f2) {
        Matrix matrix = new Matrix(this.cjd);
        this.cjd.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    /* Access modifiers changed, original: protected|final */
    public final float[] B(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.cjd.mapPoints(fArr);
        return fArr;
    }

    protected static int p(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected static int[] q(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    /* Access modifiers changed, original: protected|final */
    public final void r(MotionEvent motionEvent) {
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
    public final boolean s(MotionEvent motionEvent) {
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

    public final T CI() {
        return this.cjc.a(CG());
    }

    public final void setOneFingerMoveEnable(boolean z) {
        this.cjc.dlT().getBaseBoardView().setOneFingerMoveEnable(z);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean CN() {
        return this.cjc.dlU().CG() == CG();
    }

    /* Access modifiers changed, original: protected|final */
    public final Rect getBoardRect() {
        return this.cjc.dlT().getBaseBoardView().getBoardRect();
    }

    public final Matrix getMainMatrix() {
        return this.cjc.dlT().getBaseBoardView().getMainMatrix();
    }

    public final void CP() {
        this.cjc.dlT().getBaseBoardView().postInvalidate();
    }

    public final void CQ() {
        this.cjc.dlT().getBaseFooterView().postInvalidate();
    }
}
