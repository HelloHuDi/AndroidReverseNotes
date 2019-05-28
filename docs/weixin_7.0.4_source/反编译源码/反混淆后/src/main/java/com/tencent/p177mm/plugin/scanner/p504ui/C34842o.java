package com.tencent.p177mm.plugin.scanner.p504ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.p740a.C21680f;
import com.tencent.p177mm.plugin.scanner.util.C28920j;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.protocal.protobuf.beo;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.scanner.ui.o */
public final class C34842o extends C13161i implements C1202f, C3772a {
    private int ctE;
    int qeJ = 0;
    int qeK = 2;
    private long qeL;
    private final int qeM = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
    private final int qeN = 46;
    private final int qeQ = 50;
    C21680f qeV;
    private int qeW = 0;
    private TextView qeX;
    private TextView qeY;
    private final int qeZ = 5000;
    private final int qfa = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private C7306ak qfb = new C217281();

    /* renamed from: com.tencent.mm.plugin.scanner.ui.o$1 */
    class C217281 extends C7306ak {
        C217281() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(81185);
            if (C34842o.this.qeJ >= C34842o.this.qeK) {
                if (C34842o.this.qeV != null) {
                    C1720g.m3540Rg().mo14547c(C34842o.this.qeV);
                }
                C34842o c34842o = C34842o.this;
                c34842o.qeJ--;
            }
            AppMethodBeat.m2505o(81185);
        }
    }

    public C34842o(C13164b c13164b, Point point) {
        super(c13164b, point, (byte) 0);
        AppMethodBeat.m2504i(81186);
        mo25196fd(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE, 46);
        C4990ab.m7411d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s]", Integer.valueOf(this.qep), Integer.valueOf(this.qeq));
        this.ctE = (int) (System.currentTimeMillis() & -1);
        AppMethodBeat.m2505o(81186);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        AppMethodBeat.m2504i(81187);
        this.iqU = (TextView) this.qet.findViewById(2131827209);
        this.qeY = (TextView) this.qet.findViewById(2131827213);
        this.qeX = (TextView) this.qet.findViewById(2131827212);
        this.iqU = (TextView) this.qet.findViewById(2131827209);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + C4977b.m7371b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qeX.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + C4977b.m7371b(this.qet.getContext(), 13.0f);
            this.qeX.setLayoutParams(layoutParams);
            this.qeX.setVisibility(4);
        }
        if (C32468d.m53154Lt()) {
            this.iqU.setPadding(C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
            this.qeX.setPadding(C4977b.m7371b(this.qet.getContext(), 54.0f), this.qeX.getPaddingTop(), C4977b.m7371b(this.qet.getContext(), 54.0f), this.qeX.getPaddingBottom());
        }
        if (this.qen != null) {
            ((C28920j) this.qen).ovx = this.qet.chh();
        }
        chv();
        mo25197kl(true);
        AppMethodBeat.m2505o(81187);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.m2504i(81188);
        mo8429j(new Rect(0, 0, 0, 0));
        this.qet.mo25205b(4, null);
        this.qet.mo25215jL(0);
        onResume();
        AppMethodBeat.m2505o(81188);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: H */
    public final Rect mo25189H(boolean z, boolean z2) {
        Rect H;
        AppMethodBeat.m2504i(81189);
        if (z || this.qem == null) {
            if (C28923r.cio()) {
                Point point = new Point();
                this.qet.getContext().getWindowManager().getDefaultDisplay().getRealSize(point);
                this.qem = new Rect(0, 0, point.x, point.y);
            } else {
                H = super.mo25189H(z, z2);
                AppMethodBeat.m2505o(81189);
                return H;
            }
        }
        H = this.qem;
        AppMethodBeat.m2505o(81189);
        return H;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: kn */
    public final void mo8431kn(boolean z) {
        AppMethodBeat.m2504i(81190);
        super.mo8431kn(z);
        if (this.qen != null) {
            ((C28920j) this.qen).ovx = z;
        }
        AppMethodBeat.m2505o(81190);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970548;
    }

    /* Access modifiers changed, original: protected|final */
    public final C3771b cgO() {
        AppMethodBeat.m2504i(81191);
        if (this.qen == null) {
            int i = 50;
            if (C1427q.etc.erl > 0) {
                i = C1427q.etc.erl;
                C4990ab.m7411d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", Integer.valueOf(C1427q.etc.erl));
            }
            if (C5023at.is2G(this.qet.getContext())) {
                this.qen = new C28920j(this, i - 10, true, this.qet.chh());
            } else {
                this.qen = new C28920j(this, i, true, this.qet.chh());
            }
        }
        C3771b c3771b = this.qen;
        AppMethodBeat.m2505o(81191);
        return c3771b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.m2504i(81192);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.m2505o(81192);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81192);
    }

    private void chv() {
        AppMethodBeat.m2504i(81193);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.m2505o(81193);
        } else if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            this.qet.mo25215jL(0);
            AppMethodBeat.m2505o(81193);
        } else {
            this.qeX.setText("");
            this.qeY.setText("");
            this.qet.mo25216kj(true);
            AppMethodBeat.m2505o(81193);
        }
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(81194);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.m2505o(81194);
        } else if (bArr2 == null || bArr2.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr2 == null);
            C4990ab.m7421w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((C28920j) this.qen).qin) {
                this.qet.mo25214jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.mo25215jL(0);
            }
            this.qeW = 0;
            AppMethodBeat.m2505o(81194);
        } else if (this.qeJ >= this.qeK) {
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((C28920j) this.qen).qin) {
                this.qet.mo25214jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.mo25215jL(0);
            }
            C4990ab.m7421w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qeJ), Integer.valueOf(this.qeK));
            AppMethodBeat.m2505o(81194);
        } else {
            this.qeV = new C21680f(bArr2, "en", "zh_CN", this.ctE);
            C1720g.m3540Rg().mo14541a(this.qeV, 0);
            this.qeJ++;
            this.qfb.removeMessages(0);
            if (C5023at.is2G(this.qet.getContext())) {
                this.qfb.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.qfb.sendEmptyMessageDelayed(0, 5000);
            }
            this.qeu += bArr2.length;
            C4990ab.m7411d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qeu), Integer.valueOf(this.qeW), Integer.valueOf(this.qeK));
            if (System.currentTimeMillis() - this.qeL <= 1840 || !((C28920j) this.qen).qin) {
                this.qet.mo25214jK(40);
            } else {
                this.qeL = System.currentTimeMillis();
                this.qet.mo25215jL(0);
            }
            C4990ab.m7418v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.qeJ + "," + this.qeW);
            AppMethodBeat.m2505o(81194);
        }
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        AppMethodBeat.m2504i(81195);
        C4990ab.m7410d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.m2505o(81195);
        } else if (System.currentTimeMillis() - this.qeL <= 1840 || !((C28920j) this.qen).qin) {
            this.qet.mo25214jK(40);
            AppMethodBeat.m2505o(81195);
        } else {
            this.qeL = System.currentTimeMillis();
            this.qet.mo25215jL(0);
            AppMethodBeat.m2505o(81195);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81196);
        this.qfb.removeMessages(0);
        switch (c1207m.getType()) {
            case 392:
                this.qeJ--;
                if (i == 0 && i2 == 0) {
                    beo beo;
                    C4990ab.m7411d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                    C21680f c21680f = (C21680f) c1207m;
                    if (c21680f.ehh == null || c21680f.ehh.fsH.fsP == null) {
                        beo = null;
                    } else {
                        beo = (beo) c21680f.ehh.fsH.fsP;
                    }
                    if (beo != null) {
                        C4990ab.m7411d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", Integer.valueOf(beo.vOn), Integer.valueOf(beo.vOr), beo.wIF, beo.wIG);
                        if (!C5046bo.isNullOrNil(beo.wIG)) {
                            m57226fR(beo.wIF, beo.wIG);
                            if (this.qeV != null) {
                                C1720g.m3540Rg().mo14547c(this.qeV);
                                break;
                            }
                        }
                        AppMethodBeat.m2505o(81196);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                    m57226fR(null, null);
                    AppMethodBeat.m2505o(81196);
                    return;
                }
                C4990ab.m7413e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                this.qeL -= 300;
                m57226fR(null, null);
                AppMethodBeat.m2505o(81196);
                return;
                break;
        }
        AppMethodBeat.m2505o(81196);
    }

    /* renamed from: fR */
    private void m57226fR(String str, String str2) {
        AppMethodBeat.m2504i(81197);
        if (C5046bo.isNullOrNil(str)) {
            this.qeX.setText("");
        } else {
            this.iqU.setVisibility(8);
            this.qeX.setText(str);
            this.qeX.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(str2)) {
            this.qeY.setText("");
            AppMethodBeat.m2505o(81197);
            return;
        }
        this.iqU.setVisibility(8);
        this.qeY.setText(str2);
        this.qeY.setVisibility(0);
        AppMethodBeat.m2505o(81197);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(81198);
        C1720g.m3540Rg().mo14539a(392, (C1202f) this);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
            AppMethodBeat.m2505o(81198);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81198);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(81199);
        mo25197kl(false);
        C1720g.m3540Rg().mo14546b(392, (C1202f) this);
        AppMethodBeat.m2505o(81199);
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

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
    }
}
