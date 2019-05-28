package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
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
    private com.tencent.mm.plugin.sns.storage.a qDi = null;
    b qDj;
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

    public a(com.tencent.mm.plugin.sns.storage.a aVar, String str, long j, View view, int i, View view2, int i2, int i3, cbf cbf, int i4, b bVar) {
        AppMethodBeat.i(35701);
        this.position = i4;
        this.qCY = view;
        this.qCX = cbf;
        this.qDj = bVar;
        this.qDi = aVar;
        this.sceneType = i3;
        this.hnw = aVar == null ? "" : bo.bc(aVar.hnw, "");
        this.qDg = aVar == null ? "" : bo.bc(aVar.qPj, "");
        this.czD = str;
        this.qDh = j;
        this.qDc = i;
        this.qDd = view2;
        this.qDe = i2;
        if (this.qCY != null) {
            this.qCZ = this.qCY.findViewById(R.id.emi);
        }
        initView();
        AppMethodBeat.o(35701);
    }

    private void initView() {
        AppMethodBeat.i(35702);
        if (this.iZo == 0 && this.qCY != null) {
            this.iZo = this.qCY.getHeight();
            if (this.qCZ != null) {
                this.qDa = this.qCZ.getHeight();
            }
            if (this.iZo == 0) {
                AppMethodBeat.o(35702);
                return;
            }
            this.qDf = 0;
            if (this.qDd != null) {
                this.qDf = this.qDd.getBottom();
            }
            this.iZo -= this.qDa;
            this.qDb = this.iZo / 2;
            this.qDc = (this.qDc - this.qDf) - this.qDe;
            ab.i("MicroMsg.AdViewStatic", "viewHeight " + this.iZo + " SCREEN_HEIGHT: " + this.qDc + " abottom: " + this.qDf + " stHeight: " + this.qDe + " commentViewHeight:" + this.qDa);
        }
        AppMethodBeat.o(35702);
    }

    public final void kG(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(35703);
        if (this.qCY != null) {
            initView();
            if (this.eTf || this.iZo <= 0) {
                AppMethodBeat.o(35703);
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
            ab.i("MicroMsg.AdViewStatic", "get top " + i3 + " bottom " + i4 + " body_half: " + this.qDb + "| " + (this.iZo + i3) + "  firsttop " + this.qDk + " endtop " + this.qDm);
            if (i3 < 0) {
                i = i3 + this.iZo;
                int i5 = this.iZo - i;
                ab.i("MicroMsg.AdViewStatic", "top " + i3 + " screen in " + i + " out: " + i5);
                if (i < this.qDb || this.qDq != -10086) {
                    boolean i22 = true;
                } else {
                    this.qDq = i3;
                    this.qDr = i4;
                    this.qDs = System.currentTimeMillis();
                    ab.i("MicroMsg.AdViewStatic", "up first touch half" + i + " top " + i3 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i5);
                    i22 = 0;
                }
                if (i5 >= this.qDb && this.qDt == -10086 && i22 != 0 && this.qDs > 0) {
                    this.qDt = i3;
                    this.qDu = i4;
                    this.qDv = System.currentTimeMillis();
                    ab.i("MicroMsg.AdViewStatic", "down first touch half" + i + " bottom " + i4 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i5);
                }
            }
            if (i4 > this.qDc) {
                i22 = i4 - this.qDc;
                i = this.iZo - i22;
                ab.i("MicroMsg.AdViewStatic", "bottom " + i4 + " screen in " + i + " out: " + i22);
                if (i >= this.qDb && this.qDq == -10086) {
                    this.qDq = i3;
                    this.qDr = i4;
                    this.qDs = System.currentTimeMillis();
                    ab.i("MicroMsg.AdViewStatic", "up first touch half" + i22 + " top " + i3 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i22);
                    z2 = false;
                }
                if (i22 >= this.qDb && this.qDt == -10086 && z2 && this.qDs > 0) {
                    this.qDt = i3;
                    this.qDu = i4;
                    this.qDv = System.currentTimeMillis();
                    ab.i("MicroMsg.AdViewStatic", "down first touch half" + i22 + " bottom " + i4 + " viewhieght " + this.iZo + " inscreenval: " + i + " outscreenval: " + i22);
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
            ab.i("MicroMsg.AdViewStatic", "unreadtop: " + this.qDD + " unreadBottom:" + this.qDE + " readHeight: " + this.qDC + (z ? " isScrooIde" : ""));
        }
        AppMethodBeat.o(35703);
    }

    public final com.tencent.mm.protocal.protobuf.bo cmd() {
        AppMethodBeat.i(35704);
        com.tencent.mm.protocal.protobuf.bo boVar = new com.tencent.mm.protocal.protobuf.bo();
        n kD = af.cnF().kD(this.qDh);
        if (kD != null) {
            cbf q = aj.q(kD);
            if (q != null) {
                boVar.vDR = q.xat.size();
                boVar.vDQ = q.xaq.size();
                AppMethodBeat.o(35704);
                return boVar;
            }
        }
        if (this.qCX != null) {
            boVar.vDR = this.qCX.xas;
            boVar.vDQ = this.qCX.xap;
            AppMethodBeat.o(35704);
            return boVar;
        }
        AppMethodBeat.o(35704);
        return null;
    }

    public final boolean cme() {
        return this.qDH == 1;
    }
}
