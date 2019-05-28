package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelsimple.C45453u;
import com.tencent.p177mm.modelsimple.C45453u.C37949b;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.util.C3771b;
import com.tencent.p177mm.plugin.scanner.util.C3771b.C3772a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14976d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t;
import com.tencent.p177mm.protocal.protobuf.bkt;
import com.tencent.p177mm.protocal.protobuf.bug;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5060h;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

@C5060h(doa = {BaseScanUI.class})
/* renamed from: com.tencent.mm.plugin.scanner.ui.q */
public final class C7067q extends C13161i implements C1202f, C3772a {
    private static int qeG = 300;
    private float ecs;
    private float ect;
    private C42206a ecy = new C70701();
    private C26443d fwu;
    private boolean fwx = false;
    private boolean nPX;
    private float pitch = -10000.0f;
    private TextView qbp;
    private final int qeM = 300;
    private final int qeN = 400;
    private float qfA = -10000.0f;
    private boolean qfB = false;
    private boolean qfC = false;
    private boolean qfD = false;
    private C7068a qfE;
    protected C7306ak qfF = new C70692();
    private int qfv;
    private int qfw;
    private String qfx;
    private String qfy;
    private boolean qfz = false;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.q$a */
    final class C7068a implements Runnable {
        String url;

        private C7068a() {
        }

        /* synthetic */ C7068a(C7067q c7067q, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(81241);
            if (C7067q.this.qet == null || C7067q.this.qfB) {
                AppMethodBeat.m2505o(81241);
                return;
            }
            C40490t.m69623a(new C14976d());
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", this.url);
            intent.putExtra("show_bottom", false);
            intent.putExtra("title", C25738R.string.dxp);
            intent.putExtra("webview_bg_color_rsID", C25738R.color.f11782h4);
            intent.putExtra("geta8key_scene", 13);
            intent.setFlags(65536);
            C28892c.gkE.mo38924i(intent, C7067q.this.qet.getContext());
            C7067q.this.qet.getContext().finish();
            C7067q.this.qet.getContext().overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(81241);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.q$2 */
    class C70692 extends C7306ak {
        C70692() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(81240);
            if (C7067q.this.qbp != null) {
                C7067q.this.qet.mo25216kj(true);
                C7067q.this.qbp.setText(C25738R.string.dyt);
                C7067q.this.qbp.setVisibility(0);
            }
            AppMethodBeat.m2505o(81240);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.q$1 */
    class C70701 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.scanner.ui.q$1$1 */
        class C70711 implements OnClickListener {
            C70711() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(81238);
                C26443d.m42103bX(C7067q.this.qet.getContext());
                AppMethodBeat.m2505o(81238);
            }
        }

        C70701() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(81239);
            C4990ab.m7417i("MicroMsg.scanner.ScanModeStreetView", "onGetLocation %s", Boolean.valueOf(z));
            if (z) {
                C7067q.this.ecs = f2;
                C7067q.this.ect = f;
                C7067q.this.qfw = (int) d2;
                C7067q.this.qfx = "";
                C7067q.this.qfy = "";
                C7067q.this.qfv = i;
                C7067q.this.qfz = true;
                C7067q.m11842d(C7067q.this);
                if (!C7067q.this.fwx) {
                    C7067q.this.fwx = true;
                    C18698o.m29222a(2012, f, f2, (int) d2);
                }
                AppMethodBeat.m2505o(81239);
                return false;
            }
            C4990ab.m7416i("MicroMsg.scanner.ScanModeStreetView", "check permission not passed!");
            if (!(C7067q.this.nPX || C26443d.agA() || C7067q.this.qet == null)) {
                C7067q.this.nPX = true;
                C30379h.m48445a(C7067q.this.qet.getContext(), C7067q.this.qet.getContext().getString(C25738R.string.c9z), C7067q.this.qet.getContext().getString(C25738R.string.f9238tz), C7067q.this.qet.getContext().getString(C25738R.string.ckr), C7067q.this.qet.getContext().getString(C25738R.string.f9076or), false, new C70711(), null);
            }
            AppMethodBeat.m2505o(81239);
            return true;
        }
    }

    public C7067q(C13164b c13164b, Point point) {
        super(c13164b, point);
        AppMethodBeat.m2504i(81242);
        mo25196fd(300, 400);
        AppMethodBeat.m2505o(81242);
    }

    private void chA() {
        AppMethodBeat.m2504i(81243);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
            AppMethodBeat.m2505o(81243);
            return;
        }
        if (this.fwu == null) {
            this.fwu = C26443d.agz();
        }
        this.ecs = -85.0f;
        this.ect = -1000.0f;
        this.qfw = -1000;
        this.qfv = 1;
        this.qfx = "";
        this.qfy = "";
        this.fwu.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(81243);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final void mo8429j(Rect rect) {
        AppMethodBeat.m2504i(81244);
        this.qbp = (TextView) this.qet.findViewById(2131827194);
        this.qbp.setText(C25738R.string.dy9);
        this.iqU = (TextView) this.qet.findViewById(2131827209);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + C4977b.m7371b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        if (C32468d.m53154Lt()) {
            this.iqU.setPadding(C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), C4977b.m7371b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
        }
        chv();
        mo25197kl(true);
        AppMethodBeat.m2505o(81244);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.m2504i(81245);
        mo8429j(new Rect(0, 0, 0, 0));
        this.qet.mo25205b(4, null);
        onResume();
        AppMethodBeat.m2505o(81245);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return 2130970551;
    }

    /* Access modifiers changed, original: protected|final */
    public final C3771b cgO() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.m2504i(81246);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
            AppMethodBeat.m2505o(81246);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81246);
    }

    private void chv() {
        AppMethodBeat.m2504i(81247);
        if (this.qet == null) {
            C4990ab.m7412e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.m2505o(81247);
            return;
        }
        if (C1720g.m3531RK() && (C1720g.m3540Rg().acS() == 6 || C1720g.m3540Rg().acS() == 4)) {
            this.qet.mo25215jL(0);
            chA();
        }
        AppMethodBeat.m2505o(81247);
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
    }

    /* renamed from: jJ */
    public final void mo8430jJ(long j) {
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(81248);
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            AppMethodBeat.m2505o(81248);
            return;
        }
        this.qfD = false;
        switch (c1207m.getType()) {
            case v2helper.EMethodSetSpkEnhance /*424*/:
                if (i == 0 && i2 == 0) {
                    this.qfD = true;
                    bug ajC = ((C45453u) c1207m).ajC();
                    if (ajC != null && ajC.vOt != null) {
                        C4990ab.m7417i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ajC.jCt));
                        String str2;
                        if (ajC.jCt != 0) {
                            if (ajC.jCt != 2) {
                                if (ajC.jCt == 1) {
                                    try {
                                        str2 = ajC.vOt;
                                        if (str2 != null) {
                                            Map z = C5049br.m7595z(str2, "recommend");
                                            if (z != null) {
                                                LinkedList f = C37949b.m64159f(z, ".recommend");
                                                C37949b c37949b = new C37949b();
                                                c37949b.title = C5046bo.nullAsNil((String) z.get(".recommend.title"));
                                                c37949b.desc = C5046bo.nullAsNil((String) z.get(".recommend.desc"));
                                                c37949b.fPL = f;
                                            }
                                        }
                                        AppMethodBeat.m2505o(81248);
                                        return;
                                    } catch (Exception e) {
                                        C4990ab.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e, "", new Object[0]);
                                        C4990ab.m7413e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", e.getMessage());
                                        break;
                                    }
                                }
                            } else if (this.qfF == null || this.qfB) {
                                AppMethodBeat.m2505o(81248);
                                return;
                            } else {
                                this.qfF.removeMessages(0);
                                this.qfF.sendEmptyMessageDelayed(0, 1000);
                                AppMethodBeat.m2505o(81248);
                                return;
                            }
                        }
                        str2 = C45453u.m83729tu(ajC.vOt);
                        if (C5046bo.isNullOrNil(str2)) {
                            C4990ab.m7412e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            AppMethodBeat.m2505o(81248);
                            return;
                        }
                        if (this.qfE == null) {
                            this.qfE = new C7068a(this, (byte) 0);
                        }
                        this.qfE.url = str2;
                        C5004al.m7439af(this.qfE);
                        C5004al.m7442n(this.qfE, 800);
                        AppMethodBeat.m2505o(81248);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                    AppMethodBeat.m2505o(81248);
                    return;
                }
                C4990ab.m7413e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(81248);
                return;
                break;
        }
        AppMethodBeat.m2505o(81248);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(81249);
        this.qfB = false;
        if (C1720g.m3531RK()) {
            C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetSpkEnhance, (C1202f) this);
        }
        if (this.qet == null) {
            C4990ab.m7420w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
            AppMethodBeat.m2505o(81249);
            return;
        }
        chv();
        AppMethodBeat.m2505o(81249);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(81250);
        this.qfB = true;
        mo25197kl(false);
        if (C1720g.m3531RK()) {
            C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSpkEnhance, (C1202f) this);
        }
        if (this.qfF != null) {
            this.qfF.removeMessages(0);
        }
        AppMethodBeat.m2505o(81250);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(81251);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(81251);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return qeG;
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

    /* renamed from: d */
    static /* synthetic */ void m11842d(C7067q c7067q) {
        AppMethodBeat.m2504i(81252);
        if (!c7067q.qfz || c7067q.qfB || c7067q.qfD) {
            C4990ab.m7416i("MicroMsg.scanner.ScanModeStreetView", "!hasGetLbsInfo || hasPause || hasDoScene,abort");
            AppMethodBeat.m2505o(81252);
            return;
        }
        c7067q.qfD = true;
        bkt bkt = new bkt();
        bkt.wfI = c7067q.qfy;
        bkt.wfJ = c7067q.qfv;
        bkt.vRq = c7067q.ecs;
        bkt.vRp = c7067q.ect;
        bkt.wfH = c7067q.qfx;
        bkt.wfG = c7067q.qfw;
        if (C1720g.m3531RK()) {
            C1720g.m3540Rg().mo14541a(new C45453u(bkt, c7067q.qfA, c7067q.pitch), 0);
        }
        AppMethodBeat.m2505o(81252);
    }
}
