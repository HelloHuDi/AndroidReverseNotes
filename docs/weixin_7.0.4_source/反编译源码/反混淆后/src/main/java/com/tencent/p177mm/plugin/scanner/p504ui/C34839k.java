package com.tencent.p177mm.plugin.scanner.p504ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.p740a.C43484h;
import com.tencent.p177mm.plugin.scanner.util.C28920j;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.plugin.scanner.util.C43494o;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.protocal.protobuf.C7545kz;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.ui.k */
public final class C34839k extends C13161i implements C1202f, C3772a {
    private static int qeG = 300;
    private int ctE;
    private TextView qbp;
    private View qbq;
    private long qeH = 130;
    C43484h qeI;
    private int qeJ = 0;
    private int qeK = 1;
    private long qeL;
    private final int qeM = 300;
    private final int qeN = 400;
    private final long qeO = 30000;
    private long qeP;
    private final int qeQ = 50;
    private C21729a qeR = new C37671();
    private OnTouchListener qeS;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.k$1 */
    class C37671 implements C21729a {
        C37671() {
        }

        /* renamed from: o */
        public final void mo8437o(int i, Bundle bundle) {
            AppMethodBeat.m2504i(81166);
            switch (i) {
                case 0:
                    AppMethodBeat.m2505o(81166);
                    return;
                case 1:
                    AppMethodBeat.m2505o(81166);
                    return;
                case 2:
                    AppMethodBeat.m2505o(81166);
                    return;
                case 3:
                    C34839k.this.qet.chi();
                    break;
            }
            AppMethodBeat.m2505o(81166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.k$2 */
    class C131682 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.k$2$1 */
        class C131671 implements OnTouchListener {
            C131671() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(81167);
                C34839k.this.qet.mo25216kj(false);
                C34839k.this.iqU.setVisibility(0);
                C34839k.this.iqU.setText(C28923r.m45946fT(C28923r.qiR, C34839k.this.qet.getContext().getString(C25738R.string.dxw)));
                C34839k.this.qbp.setVisibility(8);
                C34839k.this.qeP = System.currentTimeMillis();
                AppMethodBeat.m2505o(81167);
                return false;
            }
        }

        C131682() {
        }

        public final void run() {
            AppMethodBeat.m2504i(81168);
            if (System.currentTimeMillis() - C34839k.this.qeP > 30000) {
                C4990ab.m7410d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
                C34839k.this.qet.mo25216kj(true);
                C34839k.this.iqU.setVisibility(8);
                C34839k.this.qbp.setText(C25738R.string.dxu);
                C34839k.this.qbp.setVisibility(0);
                if (C34839k.this.qeS == null) {
                    C34839k.this.qeS = new C131671();
                }
                C34839k.this.qbq.setOnTouchListener(C34839k.this.qeS);
            }
            AppMethodBeat.m2505o(81168);
        }
    }

    public C34839k(C13164b c13164b, Point point) {
        super(c13164b, point);
        AppMethodBeat.m2504i(81169);
        mo25196fd(300, 400);
        C4990ab.m7411d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s]", Integer.valueOf(this.qep), Integer.valueOf(this.qeq));
        if (C5046bo.m7553gO(c13164b.getContext()) < 100) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.qeH = 300;
        }
        this.ctE = (int) (System.currentTimeMillis() & -1);
        this.qeP = System.currentTimeMillis();
        AppMethodBeat.m2505o(81169);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        AppMethodBeat.m2504i(81170);
        this.qbq = this.qet.findViewById(2131827193);
        this.qbp = (TextView) this.qet.findViewById(2131827194);
        this.iqU = (TextView) this.qet.findViewById(2131827209);
        this.iqU.setText(C28923r.m45946fT(C28923r.qiR, this.qet.getContext().getString(C25738R.string.dxw)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + C4977b.m7371b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        if (C32468d.m53154Lt()) {
            this.iqU.setPadding(C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
        }
        if (this.qen != null) {
            ((C28920j) this.qen).ovx = this.qet.chh();
        }
        chv();
        mo25197kl(true);
        AppMethodBeat.m2505o(81170);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.m2504i(81171);
        mo8429j(new Rect(0, 0, 0, 0));
        this.qet.mo25205b(4, null);
        onResume();
        AppMethodBeat.m2505o(81171);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: kn */
    public final void mo8431kn(boolean z) {
        AppMethodBeat.m2504i(81172);
        super.mo8431kn(z);
        if (this.qen != null) {
            ((C28920j) this.qen).ovx = z;
        }
        AppMethodBeat.m2505o(81172);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970546;
    }

    /* Access modifiers changed, original: protected|final */
    public final C3771b cgO() {
        AppMethodBeat.m2504i(81173);
        if (this.qen == null) {
            int i = 50;
            if (C1427q.etc.erl > 0) {
                i = C1427q.etc.erl;
                C4990ab.m7411d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", Integer.valueOf(C1427q.etc.erl));
            }
            if (C5023at.is2G(this.qet.getContext())) {
                this.qen = new C28920j(this, i - 10, false, this.qet.chh());
            } else {
                this.qen = new C28920j(this, i, false, this.qet.chh());
            }
        }
        C3771b c3771b = this.qen;
        AppMethodBeat.m2505o(81173);
        return c3771b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.m2504i(81174);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.m2505o(81174);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81174);
    }

    private void chv() {
        AppMethodBeat.m2504i(81175);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.m2505o(81175);
            return;
        }
        if (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4) {
            this.qet.mo25215jL(0);
        }
        AppMethodBeat.m2505o(81175);
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(81176);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.m2505o(81176);
        } else if (bArr2 == null || bArr2.length <= 0) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((C28920j) this.qen).qin) {
                this.qet.mo25214jK(this.qeH);
                AppMethodBeat.m2505o(81176);
                return;
            }
            this.qeL = System.currentTimeMillis();
            this.qet.mo25215jL(0);
            AppMethodBeat.m2505o(81176);
        } else {
            chw();
            if (this.qeJ >= this.qeK) {
                C4990ab.m7416i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.qet.mo25214jK(this.qeH);
                if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((C28920j) this.qen).qin) {
                    this.qet.mo25214jK(this.qeH);
                    AppMethodBeat.m2505o(81176);
                    return;
                }
                this.qeL = System.currentTimeMillis();
                this.qet.mo25215jL(0);
                AppMethodBeat.m2505o(81176);
                return;
            }
            this.qeI = new C43484h(bArr2, bArr2.length, this.ctE);
            C1720g.m3540Rg().mo14541a(this.qeI, 0);
            this.qeJ++;
            this.qeu += bArr2.length;
            C4990ab.m7411d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", Integer.valueOf(this.qeu));
            if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((C28920j) this.qen).qin) {
                this.qet.mo25214jK(this.qeH);
                AppMethodBeat.m2505o(81176);
                return;
            }
            this.qeL = System.currentTimeMillis();
            this.qet.mo25215jL(0);
            AppMethodBeat.m2505o(81176);
        }
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
        AppMethodBeat.m2504i(81177);
        C4990ab.m7410d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.m2505o(81177);
            return;
        }
        chw();
        if (System.currentTimeMillis() - this.qeL <= 1800 + this.qeH || !((C28920j) this.qen).qin) {
            this.qet.mo25214jK(this.qeH);
            AppMethodBeat.m2505o(81177);
            return;
        }
        this.qeL = System.currentTimeMillis();
        this.qet.mo25215jL(0);
        AppMethodBeat.m2505o(81177);
    }

    private void chw() {
        AppMethodBeat.m2504i(81178);
        C5004al.m7441d(new C131682());
        AppMethodBeat.m2505o(81178);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81179);
        this.qeJ = 0;
        if (this.qet == null || c1207m == null) {
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(c1207m == null);
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(81179);
            return;
        }
        if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_HUAYE) {
            if (i == 0 && i2 == 0) {
                C7545kz c7545kz;
                this.qeJ = this.qeK;
                C43484h c43484h = (C43484h) c1207m;
                if (c43484h.ehh == null || c43484h.ehh.fsH.fsP == null) {
                    c7545kz = null;
                } else {
                    c7545kz = (C7545kz) c43484h.ehh.fsH.fsP;
                }
                if (c7545kz != null) {
                    C4990ab.m7411d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", Integer.valueOf(c7545kz.vOn), Integer.valueOf(c7545kz.vOr));
                    switch (C43494o.m77714a(c7545kz.jCt, c7545kz.vOt, this, 3, this.qeR, 0, 0, false)) {
                        case 0:
                            this.qet.cha();
                            if (!(this.qet == null || this.qet.getContext() == null)) {
                                this.qet.chi();
                                break;
                            }
                        case 1:
                            C4990ab.m7410d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            C4990ab.m7412e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                AppMethodBeat.m2505o(81179);
                return;
            }
            C4990ab.m7413e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            this.iqU.setText(C28923r.m45946fT(C28923r.qiR, this.qet.getContext().getString(C25738R.string.dxw)));
            if (this.qeI != null) {
                C1720g.m3540Rg().mo14547c(this.qeI);
            }
        }
        AppMethodBeat.m2505o(81179);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(81180);
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_HUAYE, (C1202f) this);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            AppMethodBeat.m2505o(81180);
            return;
        }
        this.qeJ = 0;
        chv();
        AppMethodBeat.m2505o(81180);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(81181);
        super.onPause();
        mo25197kl(false);
        C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_HUAYE, (C1202f) this);
        AppMethodBeat.m2505o(81181);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return qeG;
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
        return true;
    }

    /* renamed from: K */
    public final void mo8420K(Bundle bundle) {
    }
}
