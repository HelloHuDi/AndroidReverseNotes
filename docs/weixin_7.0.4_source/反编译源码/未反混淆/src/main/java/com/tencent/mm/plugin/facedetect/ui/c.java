package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    boolean lYA = false;
    boolean lYB = false;
    boolean lYC = false;
    int lYD = 0;
    Bitmap lYE = null;
    public String lYF = null;
    String lYG = null;
    String lYH = null;
    String lYI = null;
    int lYJ = -1;
    String lYK = null;
    a lYL = null;
    OnClickListener lYM;
    OnClickListener lYN;
    OnClickListener lYO;
    OnClickListener lYP;
    boolean lYw = false;
    public boolean lYx = true;
    boolean lYy = true;
    boolean lYz = false;
    public int status = 1;

    public final String toString() {
        AppMethodBeat.i(528);
        String str = "JumperConfig{isShowMainButton=" + this.lYw + ", isShowStatusWordingTv=" + this.lYx + ", isShowUploadStatusIv=" + this.lYy + ", isShowCancelBtn=" + this.lYz + ", isShowSubButton=" + this.lYA + ", isShowOneByOne=" + this.lYB + ", isShowFeedback=" + this.lYC + ", oneByOneIndexStart=" + this.lYD + ", bgBm=" + this.lYE + ", statusWording='" + this.lYF + '\'' + ", mainBtnText='" + this.lYG + '\'' + ", subBtnText='" + this.lYH + '\'' + ", cancelBtnText='" + this.lYI + '\'' + ", statusIvRes=" + this.lYJ + ", feedbackText='" + this.lYK + '\'' + ", status=" + this.status + ", onJumperShowEndCallback=" + this.lYL + ", onMainBtnClickListener=" + this.lYM + ", onSubBtnClickListener=" + this.lYN + ", onFeedbackClickListener=" + this.lYO + ", onCancelBtnClickListener=" + this.lYP + '}';
        AppMethodBeat.o(528);
        return str;
    }
}
