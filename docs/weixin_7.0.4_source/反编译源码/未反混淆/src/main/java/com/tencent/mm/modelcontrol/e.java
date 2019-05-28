package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {
    protected String fzR;
    protected int fzS;
    protected int fzT;
    protected int fzU;
    protected int fzV;
    protected boolean fzW;
    protected f[] fzX;

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        AppMethodBeat.i(50617);
        this.fzR = str;
        this.fzS = bo.getInt(str2, 0);
        this.fzS = this.fzS == 0 ? 64000 : this.fzS * 1000;
        this.fzT = bo.getInt(str3, 10);
        this.fzU = bo.getInt(str4, 2);
        this.fzV = bo.getInt(str5, 1);
        if (bo.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.fzW = z;
        AppMethodBeat.o(50617);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean afQ() {
        AppMethodBeat.i(50618);
        if (bo.isNullOrNil(this.fzR)) {
            AppMethodBeat.o(50618);
            return true;
        }
        boolean rR = b.rR(this.fzR);
        AppMethodBeat.o(50618);
        return rR;
    }

    /* Access modifiers changed, original: protected|final */
    public final VideoTransPara afR() {
        AppMethodBeat.i(50619);
        VideoTransPara videoTransPara = null;
        if (this.fzX != null) {
            for (f fVar : this.fzX) {
                if (fVar != null && fVar.fzY <= 0 && fVar.fzZ >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.fAa;
                    videoTransPara.height = fVar.fAb;
                    videoTransPara.fps = fVar.fAc;
                    videoTransPara.videoBitrate = fVar.fAd;
                    videoTransPara.fzT = this.fzT;
                    videoTransPara.fzS = this.fzS;
                    videoTransPara.fzU = this.fzU;
                    videoTransPara.fzV = this.fzV;
                }
            }
        }
        AppMethodBeat.o(50619);
        return videoTransPara;
    }

    public final String toString() {
        AppMethodBeat.i(50620);
        String str = "[ busyTime " + this.fzR + " audioBitrate " + this.fzS + " iFrame " + this.fzT + " profileIndex " + this.fzU + " presetIndex " + this.fzV + " isStepBr " + this.fzW + " ]";
        AppMethodBeat.o(50620);
        return str;
    }
}
