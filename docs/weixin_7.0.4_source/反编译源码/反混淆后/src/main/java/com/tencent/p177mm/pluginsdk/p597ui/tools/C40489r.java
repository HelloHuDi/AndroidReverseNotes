package com.tencent.p177mm.pluginsdk.p597ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.r */
public final class C40489r {
    int ieu;
    int iev;
    int iew;
    int iex;
    C35873d rce = C35873d.DEFAULT;
    int videoHeight;
    int videoWidth;
    boolean vvq;

    /* Access modifiers changed, original: final */
    public final void reset() {
        this.iev = 0;
        this.ieu = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.iex = 0;
        this.iew = 0;
    }

    public final void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(118045);
        C4990ab.m7417i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", this.rce, c35873d);
        this.rce = c35873d;
        reset();
        AppMethodBeat.m2505o(118045);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: I */
    public final boolean mo64033I(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(118046);
        if (this.ieu == i && this.iev == i2 && this.videoWidth == i3 && this.videoHeight == i4) {
            AppMethodBeat.m2505o(118046);
            return true;
        }
        this.ieu = i;
        this.iev = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        float f = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f2 = (((float) this.ieu) * 1.0f) / ((float) this.iev);
        if (this.rce != C35873d.DEFAULT) {
            if (this.rce == C35873d.CONTAIN) {
                m69620bk(f);
            } else if (this.rce == C35873d.FILL) {
                dlD();
            } else if (this.rce == C35873d.COVER) {
                m69621bl(f);
            }
            C4990ab.m7411d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.ieu), Integer.valueOf(this.iev), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iew), Integer.valueOf(this.iex), Float.valueOf(f2), Float.valueOf(f));
            AppMethodBeat.m2505o(118046);
            return false;
        }
        m69619ag(f, f2);
        C4990ab.m7411d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.ieu), Integer.valueOf(this.iev), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iew), Integer.valueOf(this.iex), Float.valueOf(f2), Float.valueOf(f));
        AppMethodBeat.m2505o(118046);
        return false;
    }

    /* renamed from: bk */
    private void m69620bk(float f) {
        if (this.ieu < this.iev) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
            if (this.iex > this.iev) {
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                return;
            }
            return;
        }
        this.iew = (int) (((float) this.iev) * f);
        this.iex = this.iev;
        if (this.iew > this.ieu) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
        }
    }

    /* renamed from: bl */
    private void m69621bl(float f) {
        if (this.ieu > this.iev) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
            if (this.iex < this.iev) {
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                return;
            }
            return;
        }
        this.iew = (int) (((float) this.iev) * f);
        this.iex = this.iev;
        if (this.iew < this.ieu) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
        }
    }

    private void dlD() {
        this.iex = this.iev;
        this.iew = this.ieu;
    }

    /* renamed from: ag */
    private void m69619ag(float f, float f2) {
        AppMethodBeat.m2504i(118047);
        if (this.vvq) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.ieu < this.iev) {
                    this.iex = (int) (((float) this.ieu) / f);
                    this.iew = this.ieu;
                    AppMethodBeat.m2505o(118047);
                    return;
                }
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                AppMethodBeat.m2505o(118047);
            } else if (this.ieu > this.iev) {
                this.iex = (int) (((float) this.ieu) / f);
                this.iew = this.ieu;
                AppMethodBeat.m2505o(118047);
            } else {
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                AppMethodBeat.m2505o(118047);
            }
        } else if (this.ieu < this.iev) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
            AppMethodBeat.m2505o(118047);
        } else {
            this.iew = (int) (((float) this.iev) * f);
            this.iex = this.iev;
            AppMethodBeat.m2505o(118047);
        }
    }
}
