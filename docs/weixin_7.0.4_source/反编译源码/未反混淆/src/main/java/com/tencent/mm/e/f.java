package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.LinkedList;

public final class f extends b<g> {
    private float ati;
    private float atj;
    private boolean cjF = false;
    private float cjG;
    private float cjH;
    private boolean ckd = true;
    private Bitmap ckr;
    private LinkedList<b> cks = new LinkedList();
    public a ckt = a.ONE;
    private Path vr = new Path();

    public f() {
        AppMethodBeat.i(116198);
        AppMethodBeat.o(116198);
    }

    public final a CG() {
        return a.MOSAIC;
    }

    public final void zC() {
        Bitmap bitmap;
        AppMethodBeat.i(116199);
        super.zC();
        o(((g) CI()).Jl());
        Bitmap dlV = this.cjc.dlV();
        if (dlV == null) {
            ab.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = dlV.getWidth();
            int height = dlV.getHeight();
            int bu = com.tencent.mm.ch.a.bu(6.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) bu)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) bu)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i = 0; i < ceil; i++) {
                for (int i2 = 0; i2 < ceil2; i2++) {
                    int i3;
                    int i4 = bu * i;
                    int i5 = bu * i2;
                    int i6 = i4 + bu;
                    if (i6 > width) {
                        i3 = width;
                    } else {
                        i3 = i6;
                    }
                    i6 = i5 + bu;
                    if (i6 > height) {
                        i6 = height;
                    }
                    int pixel = dlV.getPixel(i4, i5);
                    Rect rect = new Rect(i4, i5, i3, i6);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.ckr = bitmap;
        AppMethodBeat.o(116199);
    }

    public final void onDestroy() {
        AppMethodBeat.i(116200);
        super.onDestroy();
        if (!(this.ckr == null || this.ckr.isRecycled())) {
            this.ckr.recycle();
        }
        AppMethodBeat.o(116200);
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(116201);
        canvas.save();
        canvas.clipRect(this.cje);
        if (this.ckt == a.ONE) {
            a(canvas);
            new d(this.ckt, this.vr, 1.0f / getScale(), this.ckr).draw(canvas);
        } else if (this.ckt == a.TWO) {
            new d(this.ckt, new LinkedList(this.cks), 1.0f / getScale()).draw(new Canvas(CM()));
            a(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(116201);
    }

    public final boolean o(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.i(116202);
        if (CN()) {
            float[] A = A(motionEvent.getX(), motionEvent.getY());
            float f;
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (this.cje.contains((int) A[0], (int) A[1])) {
                        f = A[0];
                        this.cjG = f;
                        this.ati = f;
                        float f2 = A[1];
                        this.cjH = f2;
                        this.atj = f2;
                        this.ckd = true;
                    } else {
                        this.ckd = false;
                    }
                    this.cjF = false;
                    break;
                case 1:
                case 5:
                    if (this.ckd && this.cjF) {
                        if (this.ckt == a.ONE) {
                            ((g) CI()).a(new d(this.ckt, new Path(this.vr), 1.0f / getScale(), this.ckr));
                            bk(false);
                        } else if (this.ckt == a.TWO) {
                            ((g) CI()).a(new d(this.ckt, new LinkedList(this.cks), 1.0f / getScale()));
                            bk(false);
                        }
                        CQ();
                    }
                    this.cks.clear();
                    this.vr.reset();
                    this.cjF = false;
                    this.ckd = false;
                    break;
                case 2:
                    if (!this.ckd || !this.cjF) {
                        if (this.ckd && !this.cjF) {
                            if (this.ckt == a.ONE) {
                                this.vr.moveTo(A[0], A[1]);
                            }
                            this.cjF = true;
                            break;
                        }
                    }
                    this.cjG = this.ati;
                    this.cjH = this.atj;
                    this.ati = A[0];
                    this.atj = A[1];
                    if (this.ckt == a.ONE) {
                        this.vr.quadTo(this.cjG, this.cjH, (this.ati + this.cjG) / 2.0f, (this.atj + this.cjH) / 2.0f);
                    } else if (this.ckt == a.TWO) {
                        int i2;
                        double toDegrees = Math.toDegrees(Math.atan((double) ((this.ati - this.cjG) / (this.atj - this.cjH))));
                        if (getRotation() == 180.0f) {
                            i2 = 180;
                        } else {
                            i2 = 0;
                        }
                        float f3 = ((float) (((double) i2) + toDegrees)) % 360.0f;
                        LinkedList linkedList = this.cks;
                        f = 1.0f / getScale();
                        float f4 = this.ati;
                        float f5 = this.atj;
                        Bitmap dlV = this.cjc.dlV();
                        if (dlV == null || f4 >= ((float) dlV.getWidth()) || f5 >= ((float) dlV.getHeight()) || f4 <= 0.0f || f5 <= 0.0f) {
                            ab.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", Float.valueOf(f4), Float.valueOf(f5));
                        } else {
                            i = dlV.getPixel((int) f4, (int) f5);
                        }
                        linkedList.add(new b(f, i, f3, this.ati, this.atj));
                    }
                    CP();
                    break;
                    break;
            }
            boolean z = this.ckd;
            AppMethodBeat.o(116202);
            return z;
        }
        AppMethodBeat.o(116202);
        return false;
    }

    public final void bk(boolean z) {
        AppMethodBeat.i(116203);
        super.bk(z);
        ((g) CI()).p(CM());
        AppMethodBeat.o(116203);
    }

    public final void CH() {
        AppMethodBeat.i(116204);
        if (!(CM() == null || CM().isRecycled())) {
            CM().recycle();
        }
        o(((g) CI()).Jl());
        AppMethodBeat.o(116204);
    }
}
