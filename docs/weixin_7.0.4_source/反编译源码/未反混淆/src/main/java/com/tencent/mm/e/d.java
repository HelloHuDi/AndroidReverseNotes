package com.tencent.mm.e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.footer.a;
import com.tencent.mm.y.b;

public final class d extends b {
    private float ati;
    private float atj;
    private boolean cjF = false;
    private float cjG;
    private float cjH;
    private float ckc;
    private boolean ckd = true;
    public int mColor = a.AcD[2];
    private Path vr = new Path();

    public d() {
        AppMethodBeat.i(116178);
        AppMethodBeat.o(116178);
    }

    public final void zC() {
        AppMethodBeat.i(116179);
        super.zC();
        this.ckc = this.cjc.getInitScale();
        AppMethodBeat.o(116179);
    }

    public final a CG() {
        return a.DOODLE;
    }

    public final boolean o(MotionEvent motionEvent) {
        AppMethodBeat.i(116180);
        if (CN()) {
            float[] A = A(motionEvent.getX(), motionEvent.getY());
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (this.cje.contains((int) A[0], (int) A[1])) {
                        float f = A[0];
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
                        CI().add(new b(new Path(this.vr), (this.ckc / this.cjc.getInitScale()) / this.cjc.getCurScale(), this.mColor));
                        bk(false);
                    }
                    CQ();
                    this.vr.reset();
                    this.cjF = false;
                    this.ckd = false;
                    break;
                case 2:
                    if (!this.ckd || !this.cjF) {
                        if (this.ckd && !this.cjF) {
                            this.vr.moveTo(A[0], A[1]);
                            this.cjF = true;
                            break;
                        }
                    }
                    this.cjG = this.ati;
                    this.cjH = this.atj;
                    this.ati = A[0];
                    this.atj = A[1];
                    this.vr.quadTo(this.cjG, this.cjH, (this.ati + this.cjG) / 2.0f, (this.atj + this.cjH) / 2.0f);
                    CP();
                    break;
                    break;
            }
            boolean z = this.ckd;
            AppMethodBeat.o(116180);
            return z;
        }
        AppMethodBeat.o(116180);
        return false;
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(116181);
        canvas.save();
        canvas.clipRect(this.cje);
        a(canvas);
        if (!this.vr.isEmpty()) {
            new b(this.vr, (this.ckc / this.cjc.getInitScale()) / this.cjc.getCurScale(), this.mColor).draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(116181);
    }

    public final void CH() {
        AppMethodBeat.i(116182);
        bk(true);
        AppMethodBeat.o(116182);
    }
}
