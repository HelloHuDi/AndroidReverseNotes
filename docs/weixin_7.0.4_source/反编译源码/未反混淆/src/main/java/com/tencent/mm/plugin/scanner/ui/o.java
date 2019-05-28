package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ugc.TXRecordCommon;

public final class o extends i implements f, a {
    private int ctE;
    int qeJ = 0;
    int qeK = 2;
    private long qeL;
    private final int qeM = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
    private final int qeN = 46;
    private final int qeQ = 50;
    com.tencent.mm.plugin.scanner.a.f qeV;
    private int qeW = 0;
    private TextView qeX;
    private TextView qeY;
    private final int qeZ = 5000;
    private final int qfa = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private ak qfb = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(81185);
            if (o.this.qeJ >= o.this.qeK) {
                if (o.this.qeV != null) {
                    g.Rg().c(o.this.qeV);
                }
                o oVar = o.this;
                oVar.qeJ--;
            }
            AppMethodBeat.o(81185);
        }
    };

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        AppMethodBeat.i(81186);
        fd(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 46);
        ab.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s]", Integer.valueOf(this.qep), Integer.valueOf(this.qeq));
        this.ctE = (int) (System.currentTimeMillis() & -1);
        AppMethodBeat.o(81186);
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        AppMethodBeat.i(81187);
        this.iqU = (TextView) this.qet.findViewById(R.id.e56);
        this.qeY = (TextView) this.qet.findViewById(R.id.e5_);
        this.qeX = (TextView) this.qet.findViewById(R.id.e59);
        this.iqU = (TextView) this.qet.findViewById(R.id.e56);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qeX.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qet.getContext(), 13.0f);
            this.qeX.setLayoutParams(layoutParams);
            this.qeX.setVisibility(4);
        }
        if (d.Lt()) {
            this.iqU.setPadding(BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
            this.qeX.setPadding(BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.qeX.getPaddingTop(), BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.qeX.getPaddingBottom());
        }
        if (this.qen != null) {
            ((j) this.qen).ovx = this.qet.chh();
        }
        chv();
        kl(true);
        AppMethodBeat.o(81187);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.i(81188);
        j(new Rect(0, 0, 0, 0));
        this.qet.b(4, null);
        this.qet.jL(0);
        onResume();
        AppMethodBeat.o(81188);
    }

    /* Access modifiers changed, original: protected|final */
    public final Rect H(boolean z, boolean z2) {
        Rect H;
        AppMethodBeat.i(81189);
        if (z || this.qem == null) {
            if (r.cio()) {
                Point point = new Point();
                this.qet.getContext().getWindowManager().getDefaultDisplay().getRealSize(point);
                this.qem = new Rect(0, 0, point.x, point.y);
            } else {
                H = super.H(z, z2);
                AppMethodBeat.o(81189);
                return H;
            }
        }
        H = this.qem;
        AppMethodBeat.o(81189);
        return H;
    }

    /* Access modifiers changed, original: protected|final */
    public final void kn(boolean z) {
        AppMethodBeat.i(81190);
        super.kn(z);
        if (this.qen != null) {
            ((j) this.qen).ovx = z;
        }
        AppMethodBeat.o(81190);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.apg;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b cgO() {
        AppMethodBeat.i(81191);
        if (this.qen == null) {
            int i = 50;
            if (q.etc.erl > 0) {
                i = q.etc.erl;
                ab.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", Integer.valueOf(q.etc.erl));
            }
            if (at.is2G(this.qet.getContext())) {
                this.qen = new j(this, i - 10, true, this.qet.chh());
            } else {
                this.qen = new j(this, i, true, this.qet.chh());
            }
        }
        com.tencent.mm.plugin.scanner.util.b bVar = this.qen;
        AppMethodBeat.o(81191);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.i(81192);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.o(81192);
            return;
        }
        chv();
        AppMethodBeat.o(81192);
    }

    private void chv() {
        AppMethodBeat.i(81193);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.o(81193);
        } else if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            this.qet.jL(0);
            AppMethodBeat.o(81193);
        } else {
            this.qeX.setText("");
            this.qeY.setText("");
            this.qet.kj(true);
            AppMethodBeat.o(81193);
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(81194);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.o(81194);
        } else if (bArr2 == null || bArr2.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr2 == null);
            ab.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((j) this.qen).qin) {
                this.qet.jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.jL(0);
            }
            this.qeW = 0;
            AppMethodBeat.o(81194);
        } else if (this.qeJ >= this.qeK) {
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((j) this.qen).qin) {
                this.qet.jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.jL(0);
            }
            ab.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qeJ), Integer.valueOf(this.qeK));
            AppMethodBeat.o(81194);
        } else {
            this.qeV = new com.tencent.mm.plugin.scanner.a.f(bArr2, "en", "zh_CN", this.ctE);
            g.Rg().a(this.qeV, 0);
            this.qeJ++;
            this.qfb.removeMessages(0);
            if (at.is2G(this.qet.getContext())) {
                this.qfb.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.qfb.sendEmptyMessageDelayed(0, 5000);
            }
            this.qeu += bArr2.length;
            ab.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qeu), Integer.valueOf(this.qeW), Integer.valueOf(this.qeK));
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((j) this.qen).qin) {
                this.qet.jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.jL(0);
            }
            ab.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.qeJ + "," + this.qeW);
            AppMethodBeat.o(81194);
        }
    }

    public final void jJ(long j) {
        AppMethodBeat.i(81195);
        ab.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.o(81195);
        } else if (System.currentTimeMillis() - this.qeL <= 1840 || !((j) this.qen).qin) {
            this.qet.jK(40);
            AppMethodBeat.o(81195);
        } else {
            this.qeL = System.currentTimeMillis();
            this.qet.jL(0);
            AppMethodBeat.o(81195);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81196);
        this.qfb.removeMessages(0);
        switch (mVar.getType()) {
            case 392:
                this.qeJ--;
                if (i == 0 && i2 == 0) {
                    beo beo;
                    ab.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.plugin.scanner.a.f fVar = (com.tencent.mm.plugin.scanner.a.f) mVar;
                    if (fVar.ehh == null || fVar.ehh.fsH.fsP == null) {
                        beo = null;
                    } else {
                        beo = (beo) fVar.ehh.fsH.fsP;
                    }
                    if (beo != null) {
                        ab.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", Integer.valueOf(beo.vOn), Integer.valueOf(beo.vOr), beo.wIF, beo.wIG);
                        if (!bo.isNullOrNil(beo.wIG)) {
                            fR(beo.wIF, beo.wIG);
                            if (this.qeV != null) {
                                g.Rg().c(this.qeV);
                                break;
                            }
                        }
                        AppMethodBeat.o(81196);
                        return;
                    }
                    ab.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                    fR(null, null);
                    AppMethodBeat.o(81196);
                    return;
                }
                ab.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                this.qeL -= 300;
                fR(null, null);
                AppMethodBeat.o(81196);
                return;
                break;
        }
        AppMethodBeat.o(81196);
    }

    private void fR(String str, String str2) {
        AppMethodBeat.i(81197);
        if (bo.isNullOrNil(str)) {
            this.qeX.setText("");
        } else {
            this.iqU.setVisibility(8);
            this.qeX.setText(str);
            this.qeX.setVisibility(0);
        }
        if (bo.isNullOrNil(str2)) {
            this.qeY.setText("");
            AppMethodBeat.o(81197);
            return;
        }
        this.iqU.setVisibility(8);
        this.qeY.setText(str2);
        this.qeY.setVisibility(0);
        AppMethodBeat.o(81197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(81198);
        g.Rg().a(392, (f) this);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.o(81198);
            return;
        }
        chv();
        AppMethodBeat.o(81198);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(81199);
        kl(false);
        g.Rg().b(392, (f) this);
        AppMethodBeat.o(81199);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgS() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgT() {
        return false;
    }

    public final void K(Bundle bundle) {
    }
}
