package com.tencent.p177mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelcontrol.e */
public final class C37939e {
    protected String fzR;
    protected int fzS;
    protected int fzT;
    protected int fzU;
    protected int fzV;
    protected boolean fzW;
    protected C26440f[] fzX;

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo60703a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        AppMethodBeat.m2504i(50617);
        this.fzR = str;
        this.fzS = C5046bo.getInt(str2, 0);
        this.fzS = this.fzS == 0 ? 64000 : this.fzS * 1000;
        this.fzT = C5046bo.getInt(str3, 10);
        this.fzU = C5046bo.getInt(str4, 2);
        this.fzV = C5046bo.getInt(str5, 1);
        if (C5046bo.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.fzW = z;
        AppMethodBeat.m2505o(50617);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean afQ() {
        AppMethodBeat.m2504i(50618);
        if (C5046bo.isNullOrNil(this.fzR)) {
            AppMethodBeat.m2505o(50618);
            return true;
        }
        boolean rR = C45448b.m83719rR(this.fzR);
        AppMethodBeat.m2505o(50618);
        return rR;
    }

    /* Access modifiers changed, original: protected|final */
    public final VideoTransPara afR() {
        AppMethodBeat.m2504i(50619);
        VideoTransPara videoTransPara = null;
        if (this.fzX != null) {
            for (C26440f c26440f : this.fzX) {
                if (c26440f != null && c26440f.fzY <= 0 && c26440f.fzZ >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = c26440f.fAa;
                    videoTransPara.height = c26440f.fAb;
                    videoTransPara.fps = c26440f.fAc;
                    videoTransPara.videoBitrate = c26440f.fAd;
                    videoTransPara.fzT = this.fzT;
                    videoTransPara.fzS = this.fzS;
                    videoTransPara.fzU = this.fzU;
                    videoTransPara.fzV = this.fzV;
                }
            }
        }
        AppMethodBeat.m2505o(50619);
        return videoTransPara;
    }

    public final String toString() {
        AppMethodBeat.m2504i(50620);
        String str = "[ busyTime " + this.fzR + " audioBitrate " + this.fzS + " iFrame " + this.fzT + " profileIndex " + this.fzU + " presetIndex " + this.fzV + " isStepBr " + this.fzW + " ]";
        AppMethodBeat.m2505o(50620);
        return str;
    }
}
