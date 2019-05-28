package com.tencent.mm.plugin.scanner.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

@h(doa = {BaseScanUI.class})
public final class q extends i implements f, com.tencent.mm.plugin.scanner.util.b.a {
    private static int qeG = 300;
    private float ecs;
    private float ect;
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(81239);
            ab.i("MicroMsg.scanner.ScanModeStreetView", "onGetLocation %s", Boolean.valueOf(z));
            if (z) {
                q.this.ecs = f2;
                q.this.ect = f;
                q.this.qfw = (int) d2;
                q.this.qfx = "";
                q.this.qfy = "";
                q.this.qfv = i;
                q.this.qfz = true;
                q.d(q.this);
                if (!q.this.fwx) {
                    q.this.fwx = true;
                    o.a(2012, f, f2, (int) d2);
                }
                AppMethodBeat.o(81239);
                return false;
            }
            ab.i("MicroMsg.scanner.ScanModeStreetView", "check permission not passed!");
            if (!(q.this.nPX || d.agA() || q.this.qet == null)) {
                q.this.nPX = true;
                com.tencent.mm.ui.base.h.a(q.this.qet.getContext(), q.this.qet.getContext().getString(R.string.c9z), q.this.qet.getContext().getString(R.string.tz), q.this.qet.getContext().getString(R.string.ckr), q.this.qet.getContext().getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(81238);
                        d.bX(q.this.qet.getContext());
                        AppMethodBeat.o(81238);
                    }
                }, null);
            }
            AppMethodBeat.o(81239);
            return true;
        }
    };
    private d fwu;
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
    private a qfE;
    protected ak qfF = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(81240);
            if (q.this.qbp != null) {
                q.this.qet.kj(true);
                q.this.qbp.setText(R.string.dyt);
                q.this.qbp.setVisibility(0);
            }
            AppMethodBeat.o(81240);
        }
    };
    private int qfv;
    private int qfw;
    private String qfx;
    private String qfy;
    private boolean qfz = false;

    final class a implements Runnable {
        String url;

        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(81241);
            if (q.this.qet == null || q.this.qfB) {
                AppMethodBeat.o(81241);
                return;
            }
            t.a(new com.tencent.mm.pluginsdk.ui.tools.d());
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", this.url);
            intent.putExtra("show_bottom", false);
            intent.putExtra("title", R.string.dxp);
            intent.putExtra("webview_bg_color_rsID", R.color.h4);
            intent.putExtra("geta8key_scene", 13);
            intent.setFlags(65536);
            c.gkE.i(intent, q.this.qet.getContext());
            q.this.qet.getContext().finish();
            q.this.qet.getContext().overridePendingTransition(0, 0);
            AppMethodBeat.o(81241);
        }
    }

    public q(b bVar, Point point) {
        super(bVar, point);
        AppMethodBeat.i(81242);
        fd(300, 400);
        AppMethodBeat.o(81242);
    }

    private void chA() {
        AppMethodBeat.i(81243);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
            AppMethodBeat.o(81243);
            return;
        }
        if (this.fwu == null) {
            this.fwu = d.agz();
        }
        this.ecs = -85.0f;
        this.ect = -1000.0f;
        this.qfw = -1000;
        this.qfv = 1;
        this.qfx = "";
        this.qfy = "";
        this.fwu.a(this.ecy, true);
        AppMethodBeat.o(81243);
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        AppMethodBeat.i(81244);
        this.qbp = (TextView) this.qet.findViewById(R.id.e4r);
        this.qbp.setText(R.string.dy9);
        this.iqU = (TextView) this.qet.findViewById(R.id.e56);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        if (com.tencent.mm.compatible.e.d.Lt()) {
            this.iqU.setPadding(BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingTop(), BackwardSupportUtil.b.b(this.qet.getContext(), 54.0f), this.iqU.getPaddingBottom());
        }
        chv();
        kl(true);
        AppMethodBeat.o(81244);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.i(81245);
        j(new Rect(0, 0, 0, 0));
        this.qet.b(4, null);
        onResume();
        AppMethodBeat.o(81245);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.apj;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b cgO() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.i(81246);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
            AppMethodBeat.o(81246);
            return;
        }
        chv();
        AppMethodBeat.o(81246);
    }

    private void chv() {
        AppMethodBeat.i(81247);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.o(81247);
            return;
        }
        if (g.RK() && (g.Rg().acS() == 6 || g.Rg().acS() == 4)) {
            this.qet.jL(0);
            chA();
        }
        AppMethodBeat.o(81247);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
    }

    public final void jJ(long j) {
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81248);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            AppMethodBeat.o(81248);
            return;
        }
        this.qfD = false;
        switch (mVar.getType()) {
            case v2helper.EMethodSetSpkEnhance /*424*/:
                if (i == 0 && i2 == 0) {
                    this.qfD = true;
                    bug ajC = ((u) mVar).ajC();
                    if (ajC != null && ajC.vOt != null) {
                        ab.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ajC.jCt));
                        String str2;
                        if (ajC.jCt != 0) {
                            if (ajC.jCt != 2) {
                                if (ajC.jCt == 1) {
                                    try {
                                        str2 = ajC.vOt;
                                        if (str2 != null) {
                                            Map z = br.z(str2, "recommend");
                                            if (z != null) {
                                                LinkedList f = u.b.f(z, ".recommend");
                                                u.b bVar = new u.b();
                                                bVar.title = bo.nullAsNil((String) z.get(".recommend.title"));
                                                bVar.desc = bo.nullAsNil((String) z.get(".recommend.desc"));
                                                bVar.fPL = f;
                                            }
                                        }
                                        AppMethodBeat.o(81248);
                                        return;
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e, "", new Object[0]);
                                        ab.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", e.getMessage());
                                        break;
                                    }
                                }
                            } else if (this.qfF == null || this.qfB) {
                                AppMethodBeat.o(81248);
                                return;
                            } else {
                                this.qfF.removeMessages(0);
                                this.qfF.sendEmptyMessageDelayed(0, 1000);
                                AppMethodBeat.o(81248);
                                return;
                            }
                        }
                        str2 = u.tu(ajC.vOt);
                        if (bo.isNullOrNil(str2)) {
                            ab.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            AppMethodBeat.o(81248);
                            return;
                        }
                        if (this.qfE == null) {
                            this.qfE = new a(this, (byte) 0);
                        }
                        this.qfE.url = str2;
                        al.af(this.qfE);
                        al.n(this.qfE, 800);
                        AppMethodBeat.o(81248);
                        return;
                    }
                    ab.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                    AppMethodBeat.o(81248);
                    return;
                }
                ab.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(81248);
                return;
                break;
        }
        AppMethodBeat.o(81248);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(81249);
        this.qfB = false;
        if (g.RK()) {
            g.Rg().a((int) v2helper.EMethodSetSpkEnhance, (f) this);
        }
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
            AppMethodBeat.o(81249);
            return;
        }
        chv();
        AppMethodBeat.o(81249);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(81250);
        this.qfB = true;
        kl(false);
        if (g.RK()) {
            g.Rg().b((int) v2helper.EMethodSetSpkEnhance, (f) this);
        }
        if (this.qfF != null) {
            this.qfF.removeMessages(0);
        }
        AppMethodBeat.o(81250);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.i(81251);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(81251);
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

    public final void K(Bundle bundle) {
    }

    static /* synthetic */ void d(q qVar) {
        AppMethodBeat.i(81252);
        if (!qVar.qfz || qVar.qfB || qVar.qfD) {
            ab.i("MicroMsg.scanner.ScanModeStreetView", "!hasGetLbsInfo || hasPause || hasDoScene,abort");
            AppMethodBeat.o(81252);
            return;
        }
        qVar.qfD = true;
        bkt bkt = new bkt();
        bkt.wfI = qVar.qfy;
        bkt.wfJ = qVar.qfv;
        bkt.vRq = qVar.ecs;
        bkt.vRp = qVar.ect;
        bkt.wfH = qVar.qfx;
        bkt.wfG = qVar.qfw;
        if (g.RK()) {
            g.Rg().a(new u(bkt, qVar.qfA, qVar.pitch), 0);
        }
        AppMethodBeat.o(81252);
    }
}
