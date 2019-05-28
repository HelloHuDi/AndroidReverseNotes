package com.tencent.p177mm.p226e;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p651y.C5755b;
import com.tencent.p177mm.view.footer.C16070a;

/* renamed from: com.tencent.mm.e.d */
public final class C1505d extends C9268b {
    private float ati;
    private float atj;
    private boolean cjF = false;
    private float cjG;
    private float cjH;
    private float ckc;
    private boolean ckd = true;
    public int mColor = C16070a.AcD[2];
    /* renamed from: vr */
    private Path f1228vr = new Path();

    public C1505d() {
        AppMethodBeat.m2504i(116178);
        AppMethodBeat.m2505o(116178);
    }

    /* renamed from: zC */
    public final void mo4955zC() {
        AppMethodBeat.m2504i(116179);
        super.mo4955zC();
        this.ckc = this.cjc.getInitScale();
        AppMethodBeat.m2505o(116179);
    }

    /* renamed from: CG */
    public final C1493a mo4943CG() {
        return C1493a.DOODLE;
    }

    /* renamed from: o */
    public final boolean mo4954o(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(116180);
        if (mo20694CN()) {
            float[] A = mo20689A(motionEvent.getX(), motionEvent.getY());
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
                        mo20691CI().add(new C5755b(new Path(this.f1228vr), (this.ckc / this.cjc.getInitScale()) / this.cjc.getCurScale(), this.mColor));
                        mo20700bk(false);
                    }
                    mo20697CQ();
                    this.f1228vr.reset();
                    this.cjF = false;
                    this.ckd = false;
                    break;
                case 2:
                    if (!this.ckd || !this.cjF) {
                        if (this.ckd && !this.cjF) {
                            this.f1228vr.moveTo(A[0], A[1]);
                            this.cjF = true;
                            break;
                        }
                    }
                    this.cjG = this.ati;
                    this.cjH = this.atj;
                    this.ati = A[0];
                    this.atj = A[1];
                    this.f1228vr.quadTo(this.cjG, this.cjH, (this.ati + this.cjG) / 2.0f, (this.atj + this.cjH) / 2.0f);
                    mo20696CP();
                    break;
                    break;
            }
            boolean z = this.ckd;
            AppMethodBeat.m2505o(116180);
            return z;
        }
        AppMethodBeat.m2505o(116180);
        return false;
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116181);
        canvas.save();
        canvas.clipRect(this.cje);
        mo20698a(canvas);
        if (!this.f1228vr.isEmpty()) {
            new C5755b(this.f1228vr, (this.ckc / this.cjc.getInitScale()) / this.cjc.getCurScale(), this.mColor).draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.m2505o(116181);
    }

    /* renamed from: CH */
    public final void mo4944CH() {
        AppMethodBeat.m2504i(116182);
        mo20700bk(true);
        AppMethodBeat.m2505o(116182);
    }
}
