package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class r {
    int ieu;
    int iev;
    int iew;
    int iex;
    d rce = d.DEFAULT;
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

    public final void setScaleType(d dVar) {
        AppMethodBeat.i(118045);
        ab.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", this.rce, dVar);
        this.rce = dVar;
        reset();
        AppMethodBeat.o(118045);
    }

    /* Access modifiers changed, original: final */
    public final boolean I(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(118046);
        if (this.ieu == i && this.iev == i2 && this.videoWidth == i3 && this.videoHeight == i4) {
            AppMethodBeat.o(118046);
            return true;
        }
        this.ieu = i;
        this.iev = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        float f = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f2 = (((float) this.ieu) * 1.0f) / ((float) this.iev);
        if (this.rce != d.DEFAULT) {
            if (this.rce == d.CONTAIN) {
                bk(f);
            } else if (this.rce == d.FILL) {
                dlD();
            } else if (this.rce == d.COVER) {
                bl(f);
            }
            ab.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.ieu), Integer.valueOf(this.iev), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iew), Integer.valueOf(this.iex), Float.valueOf(f2), Float.valueOf(f));
            AppMethodBeat.o(118046);
            return false;
        }
        ag(f, f2);
        ab.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.ieu), Integer.valueOf(this.iev), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.iew), Integer.valueOf(this.iex), Float.valueOf(f2), Float.valueOf(f));
        AppMethodBeat.o(118046);
        return false;
    }

    private void bk(float f) {
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

    private void bl(float f) {
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

    private void ag(float f, float f2) {
        AppMethodBeat.i(118047);
        if (this.vvq) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.ieu < this.iev) {
                    this.iex = (int) (((float) this.ieu) / f);
                    this.iew = this.ieu;
                    AppMethodBeat.o(118047);
                    return;
                }
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                AppMethodBeat.o(118047);
            } else if (this.ieu > this.iev) {
                this.iex = (int) (((float) this.ieu) / f);
                this.iew = this.ieu;
                AppMethodBeat.o(118047);
            } else {
                this.iew = (int) (((float) this.iev) * f);
                this.iex = this.iev;
                AppMethodBeat.o(118047);
            }
        } else if (this.ieu < this.iev) {
            this.iex = (int) (((float) this.ieu) / f);
            this.iew = this.ieu;
            AppMethodBeat.o(118047);
        } else {
            this.iew = (int) (((float) this.iev) * f);
            this.iex = this.iev;
            AppMethodBeat.o(118047);
        }
    }
}
