package com.tencent.p177mm.plugin.sns.p514a.p515b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C46529bo;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.a.b.a */
public final class C29028a {
    public String czD = "";
    boolean eTf = false;
    private String hnw = "";
    public int iZo = 0;
    int position = 0;
    boolean qCW = false;
    public cbf qCX;
    public View qCY;
    public View qCZ;
    private int qDA = -10086;
    long qDB = 0;
    int qDC = 0;
    int qDD = -1;
    int qDE = -1;
    int qDF = 0;
    int qDG = 0;
    int qDH = 0;
    public int qDa = 0;
    public int qDb = 0;
    public int qDc;
    private View qDd;
    private int qDe = 0;
    private int qDf;
    public String qDg = "";
    long qDh = 0;
    private C21980a qDi = null;
    C21984b qDj;
    int qDk = -10086;
    private int qDl = -10086;
    int qDm = -10086;
    private int qDn = -10086;
    long qDo = 0;
    long qDp = 0;
    private int qDq = -10086;
    private int qDr = -10086;
    long qDs = 0;
    private int qDt = -10086;
    private int qDu = -10086;
    long qDv = 0;
    private int qDw = -10086;
    private int qDx = -10086;
    long qDy = 0;
    private int qDz = -10086;
    public int sceneType = 1;

    /* renamed from: com.tencent.mm.plugin.sns.a.b.a$1 */
    class C290291 implements Runnable {
        C290291() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35700);
            if (!C29028a.this.qCW) {
                C29028a.this.mo47107kG(false);
            }
            AppMethodBeat.m2505o(35700);
        }
    }

    public C29028a(C21980a c21980a, String str, long j, View view, int i, View view2, int i2, int i3, cbf cbf, int i4, C21984b c21984b) {
        AppMethodBeat.m2504i(35701);
        this.position = i4;
        this.qCY = view;
        this.qCX = cbf;
        this.qDj = c21984b;
        this.qDi = c21980a;
        this.sceneType = i3;
        this.hnw = c21980a == null ? "" : C5046bo.m7532bc(c21980a.hnw, "");
        this.qDg = c21980a == null ? "" : C5046bo.m7532bc(c21980a.qPj, "");
        this.czD = str;
        this.qDh = j;
        this.qDc = i;
        this.qDd = view2;
        this.qDe = i2;
        if (this.qCY != null) {
            this.qCZ = this.qCY.findViewById(2131827888);
        }
        initView();
        AppMethodBeat.m2505o(35701);
    }

    private void initView() {
        AppMethodBeat.m2504i(35702);
        if (this.iZo == 0 && this.qCY != null) {
            this.iZo = this.qCY.getHeight();
            if (this.qCZ != null) {
                this.qDa = this.qCZ.getHeight();
            }
            if (this.iZo == 0) {
                AppMethodBeat.m2505o(35702);
                return;
            }
            this.qDf = 0;
            if (this.qDd != null) {
                this.qDf = this.qDd.getBottom();
            }
            this.iZo -= this.qDa;
            this.qDb = this.iZo / 2;
            this.qDc = (this.qDc - this.qDf) - this.qDe;
            C4990ab.m7416i("MicroMsg.AdViewStatic", "viewHeight " + this.iZo + " SCREEN_HEIGHT: " + this.qDc + " abottom: " + this.qDf + " stHeight: " + this.qDe + " commentViewHeight:" + this.qDa);
        }
        AppMethodBeat.m2505o(35702);
    }

    /* renamed from: kG */
    public final void mo47107kG(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(35703);
        if (this.qCY != null) {
            initView();
            if (this.eTf || this.iZo <= 0) {
                AppMethodBeat.m2505o(35703);
                return;
            }
            int i;
            int i2;
            this.qCW = true;
            int[] iArr = new int[2];
            this.qCY.getLocationOnScreen(iArr);
            int i3 = (iArr[1] - this.qDf) - this.qDe;
            int i4 = i3 + this.iZo;
            if (i3 < 0 || i4 < 0 || i4 > this.qDc) {
                this.qDH = 0;
            } else {
                this.qDH = 1;
            }
            if (this.qDk == -10086 && this.qDl == -10086) {
                this.qDk = i3;
                this.qDl = i4;
            }
            this.qDm = i3;
            this.qDn = i4;
            C4990ab.m7416i("MicroMsg.AdViewStatic", "get top " + i3 + " bottom " + i4 + " body_half: " + this.qDb + "| " + (this.iZo + i3) + "  firsttop " + this.qDk + " endtop " + this.qDm);
            if (i3 < 0) {
                i = i3 + this.iZo;
                int i5 = this.iZo - i;
                C4990ab.m7416i("MicroMsg.AdViewStatic", "top " + i3 + " screen in " + i + " out: " + i5);
                if (i < this.qDb || this.qDq != -10086) {
                    boolean i22 = true;
                } else {
                    this.qDq = i3;
                    this.qDr = i4;
                    this.qDs = System.currentTimeMillis();
                    C4990ab.m7416i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + i3 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i5);
                    i22 = 0;
                }
                if (i5 >= this.qDb && this.qDt == -10086 && i22 != 0 && this.qDs > 0) {
                    this.qDt = i3;
                    this.qDu = i4;
                    this.qDv = System.currentTimeMillis();
                    C4990ab.m7416i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + i4 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i5);
                }
            }
            if (i4 > this.qDc) {
                i22 = i4 - this.qDc;
                i = this.iZo - i22;
                C4990ab.m7416i("MicroMsg.AdViewStatic", "bottom " + i4 + " screen in " + i + " out: " + i22);
                if (i >= this.qDb && this.qDq == -10086) {
                    this.qDq = i3;
                    this.qDr = i4;
                    this.qDs = System.currentTimeMillis();
                    C4990ab.m7416i("MicroMsg.AdViewStatic", "up first touch half" + i22 + " top " + i3 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i22);
                    z2 = false;
                }
                if (i22 >= this.qDb && this.qDt == -10086 && z2 && this.qDs > 0) {
                    this.qDt = i3;
                    this.qDu = i4;
                    this.qDv = System.currentTimeMillis();
                    C4990ab.m7416i("MicroMsg.AdViewStatic", "down first touch half" + i22 + " bottom " + i4 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i22);
                }
            }
            if (i3 < 0 || i4 > this.qDc) {
                if (this.qDB == 0 && this.qDy != 0) {
                    this.qDz = i3;
                    this.qDA = i4;
                    this.qDB = System.currentTimeMillis();
                }
            } else if (this.qDy == 0) {
                this.qDw = i3;
                this.qDx = i4;
                this.qDy = System.currentTimeMillis();
            }
            if (i3 < 0) {
                i22 = -i3;
                if (this.qDD == -1 || this.qDD > i22) {
                    this.qDD = i22;
                }
            } else {
                this.qDD = 0;
            }
            if (i4 > this.qDc) {
                i22 = i4 - this.qDc;
                if (this.qDE == -1 || this.qDE > i22) {
                    this.qDE = i22;
                }
            } else {
                this.qDE = 0;
            }
            i22 = this.iZo;
            if (i3 < 0) {
                i22 += i3;
            }
            if (i4 > this.qDc) {
                i22 -= i4 - this.qDc;
            }
            if (this.qDC == -1 || this.qDC < i22) {
                this.qDC = i22;
            }
            C4990ab.m7416i("MicroMsg.AdViewStatic", "unreadtop: " + this.qDD + " unreadBottom:" + this.qDE + " readHeight: " + this.qDC + (z ? " isScrooIde" : ""));
        }
        AppMethodBeat.m2505o(35703);
    }

    public final C46529bo cmd() {
        AppMethodBeat.m2504i(35704);
        C46529bo c46529bo = new C46529bo();
        C46236n kD = C13373af.cnF().mo62941kD(this.qDh);
        if (kD != null) {
            cbf q = C34955aj.m57409q(kD);
            if (q != null) {
                c46529bo.vDR = q.xat.size();
                c46529bo.vDQ = q.xaq.size();
                AppMethodBeat.m2505o(35704);
                return c46529bo;
            }
        }
        if (this.qCX != null) {
            c46529bo.vDR = this.qCX.xas;
            c46529bo.vDQ = this.qCX.xap;
            AppMethodBeat.m2505o(35704);
            return c46529bo;
        }
        AppMethodBeat.m2505o(35704);
        return null;
    }

    public final boolean cme() {
        return this.qDH == 1;
    }
}
