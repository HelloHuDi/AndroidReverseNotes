package com.tencent.p177mm.p226e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C41920g;
import com.tencent.p177mm.p1639ch.C45281a;
import com.tencent.p177mm.p651y.C36401d;
import com.tencent.p177mm.p651y.C36401d.C24187a;
import com.tencent.p177mm.p651y.C36401d.C36400b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.e.f */
public final class C32496f extends C9268b<C41920g> {
    private float ati;
    private float atj;
    private boolean cjF = false;
    private float cjG;
    private float cjH;
    private boolean ckd = true;
    private Bitmap ckr;
    private LinkedList<C36400b> cks = new LinkedList();
    public C24187a ckt = C24187a.ONE;
    /* renamed from: vr */
    private Path f15018vr = new Path();

    public C32496f() {
        AppMethodBeat.m2504i(116198);
        AppMethodBeat.m2505o(116198);
    }

    /* renamed from: CG */
    public final C1493a mo4943CG() {
        return C1493a.MOSAIC;
    }

    /* renamed from: zC */
    public final void mo4955zC() {
        Bitmap bitmap;
        AppMethodBeat.m2504i(116199);
        super.mo4955zC();
        mo20706o(((C41920g) mo20691CI()).mo67567Jl());
        Bitmap dlV = this.cjc.dlV();
        if (dlV == null) {
            C4990ab.m7412e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = dlV.getWidth();
            int height = dlV.getHeight();
            int bu = C45281a.m83492bu(6.0f);
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
        AppMethodBeat.m2505o(116199);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116200);
        super.onDestroy();
        if (!(this.ckr == null || this.ckr.isRecycled())) {
            this.ckr.recycle();
        }
        AppMethodBeat.m2505o(116200);
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116201);
        canvas.save();
        canvas.clipRect(this.cje);
        if (this.ckt == C24187a.ONE) {
            mo20698a(canvas);
            new C36401d(this.ckt, this.f15018vr, 1.0f / getScale(), this.ckr).draw(canvas);
        } else if (this.ckt == C24187a.TWO) {
            new C36401d(this.ckt, new LinkedList(this.cks), 1.0f / getScale()).draw(new Canvas(mo20693CM()));
            mo20698a(canvas);
        }
        canvas.restore();
        AppMethodBeat.m2505o(116201);
    }

    /* renamed from: o */
    public final boolean mo4954o(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(116202);
        if (mo20694CN()) {
            float[] A = mo20689A(motionEvent.getX(), motionEvent.getY());
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
                        if (this.ckt == C24187a.ONE) {
                            ((C41920g) mo20691CI()).mo67568a(new C36401d(this.ckt, new Path(this.f15018vr), 1.0f / getScale(), this.ckr));
                            mo20700bk(false);
                        } else if (this.ckt == C24187a.TWO) {
                            ((C41920g) mo20691CI()).mo67568a(new C36401d(this.ckt, new LinkedList(this.cks), 1.0f / getScale()));
                            mo20700bk(false);
                        }
                        mo20697CQ();
                    }
                    this.cks.clear();
                    this.f15018vr.reset();
                    this.cjF = false;
                    this.ckd = false;
                    break;
                case 2:
                    if (!this.ckd || !this.cjF) {
                        if (this.ckd && !this.cjF) {
                            if (this.ckt == C24187a.ONE) {
                                this.f15018vr.moveTo(A[0], A[1]);
                            }
                            this.cjF = true;
                            break;
                        }
                    }
                    this.cjG = this.ati;
                    this.cjH = this.atj;
                    this.ati = A[0];
                    this.atj = A[1];
                    if (this.ckt == C24187a.ONE) {
                        this.f15018vr.quadTo(this.cjG, this.cjH, (this.ati + this.cjG) / 2.0f, (this.atj + this.cjH) / 2.0f);
                    } else if (this.ckt == C24187a.TWO) {
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
                            C4990ab.m7421w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", Float.valueOf(f4), Float.valueOf(f5));
                        } else {
                            i = dlV.getPixel((int) f4, (int) f5);
                        }
                        linkedList.add(new C36400b(f, i, f3, this.ati, this.atj));
                    }
                    mo20696CP();
                    break;
                    break;
            }
            boolean z = this.ckd;
            AppMethodBeat.m2505o(116202);
            return z;
        }
        AppMethodBeat.m2505o(116202);
        return false;
    }

    /* renamed from: bk */
    public final void mo20700bk(boolean z) {
        AppMethodBeat.m2504i(116203);
        super.mo20700bk(z);
        ((C41920g) mo20691CI()).mo67569p(mo20693CM());
        AppMethodBeat.m2505o(116203);
    }

    /* renamed from: CH */
    public final void mo4944CH() {
        AppMethodBeat.m2504i(116204);
        if (!(mo20693CM() == null || mo20693CM().isRecycled())) {
            mo20693CM().recycle();
        }
        mo20706o(((C41920g) mo20691CI()).mo67567Jl());
        AppMethodBeat.m2505o(116204);
    }
}
