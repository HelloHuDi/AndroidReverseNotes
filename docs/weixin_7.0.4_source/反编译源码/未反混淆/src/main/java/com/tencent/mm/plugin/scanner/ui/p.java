package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.ui.i.a;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p extends i implements f, a, b.a, c.a {
    int bufferSize;
    Object cli = new Object();
    int cvH = 0;
    private int mMode = 0;
    private int pZN;
    long qeH = 80;
    private e.a qeR = new e.a() {
        public final void o(int i, Bundle bundle) {
            AppMethodBeat.i(81200);
            ab.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", Integer.valueOf(i));
            switch (i) {
                case 0:
                    p.this.qff = false;
                    AppMethodBeat.o(81200);
                    return;
                case 1:
                    p.this.jZ(true);
                    AppMethodBeat.o(81200);
                    return;
                case 2:
                    p.this.jZ(true);
                    AppMethodBeat.o(81200);
                    return;
                case 3:
                    p.this.qet.chi();
                    AppMethodBeat.o(81200);
                    return;
                case 4:
                    if (bundle != null) {
                        String string = bundle.getString("geta8key_fullurl");
                        if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                            p.this.cvH = 2;
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
            }
            p.this.qet.kj(true);
            p.this.qff = true;
            AppMethodBeat.o(81200);
        }
    };
    d qfd;
    AtomicBoolean qfe = new AtomicBoolean(false);
    boolean qff = false;
    boolean qfg = false;
    private Set<Integer> qfh;
    private float qfi = 1.5f;
    byte[] qfj;
    Point qfk;
    int qfl;
    private TextView qfm;
    boolean qfn = false;
    private OnClickListener qfo = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(81201);
            if (p.this.qet == null) {
                ab.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
                AppMethodBeat.o(81201);
                return;
            }
            h.pYm.e(11264, Integer.valueOf(3));
            com.tencent.mm.plugin.scanner.c.gkE.bi(p.this.qet.getContext());
            AppMethodBeat.o(81201);
        }
    };

    static /* synthetic */ void a(p pVar, int i, String str, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(81236);
        pVar.a(i, str, bArr, i2, i3);
        AppMethodBeat.o(81236);
    }

    static /* synthetic */ void b(p pVar) {
        AppMethodBeat.i(81237);
        pVar.chz();
        AppMethodBeat.o(81237);
    }

    public p(i.b bVar, Point point, int i, int i2) {
        super(bVar, point);
        AppMethodBeat.i(81212);
        fd(244, 244);
        this.cvH = i;
        this.mMode = i2;
        this.qev = true;
        this.qel = 1000;
        if (bo.gO(bVar.getContext()) < 100) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.qeH = 280;
        }
        AppMethodBeat.o(81212);
    }

    public p(i.b bVar, Point point, int i, Set<Integer> set) {
        super(bVar, point);
        AppMethodBeat.i(81213);
        fd(244, 244);
        this.cvH = i;
        this.qfh = set;
        this.qev = true;
        this.qel = 1000;
        if (bo.gO(bVar.getContext()) < 100) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.qeH = 280;
        }
        AppMethodBeat.o(81213);
    }

    /* Access modifiers changed, original: protected|final */
    public final void f(Point point) {
        AppMethodBeat.i(81214);
        this.qem = null;
        super.f(point);
        AppMethodBeat.o(81214);
    }

    /* Access modifiers changed, original: protected|final */
    public final void kn(boolean z) {
        AppMethodBeat.i(81215);
        super.kn(z);
        if (this.qfd != null) {
            this.qfd.ovx = z;
        }
        AppMethodBeat.o(81215);
    }

    /* Access modifiers changed, original: protected|final */
    public final Rect km(boolean z) {
        AppMethodBeat.i(81216);
        Rect rect = new Rect(H(true, z));
        ab.i("MicroMsg.scanner.ScanModeQRCode", "display rect:".concat(String.valueOf(rect)));
        int width = rect.width();
        int height = rect.height();
        int i = (int) (((float) width) * this.qfi);
        int i2 = (int) (((float) height) * this.qfi);
        if (i > ((int) (((float) this.qeo.x) * 0.85f))) {
            i = (int) (((float) this.qeo.x) * 0.85f);
        }
        if (i2 > ((int) (((float) this.qeo.y) * 0.85f))) {
            i2 = (int) (((float) this.qeo.y) * 0.85f);
        }
        if (i2 % 2 == 1) {
            i2--;
        }
        if (i % 2 == 1) {
            i--;
        }
        ab.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", Integer.valueOf(i), Integer.valueOf(i2));
        rect.left -= (i - width) / 2;
        rect.right = ((i - width) / 2) + rect.right;
        rect.top -= (i2 - height) / 2;
        rect.bottom += (i2 - height) / 2;
        ab.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:".concat(String.valueOf(rect)));
        AppMethodBeat.o(81216);
        return rect;
    }

    public final void chx() {
        this.qev = false;
    }

    public final boolean chy() {
        return this.qev;
    }

    /* Access modifiers changed, original: protected|final */
    public final void j(Rect rect) {
        AppMethodBeat.i(81217);
        this.qfm = (TextView) this.qet.findViewById(R.id.e5b);
        this.qfm.setOnClickListener(this.qfo);
        this.iqU = (TextView) this.qet.findViewById(R.id.e56);
        if (rect.bottom > 0) {
            this.qfm.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.iqU.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qet.getContext(), 13.0f);
            this.iqU.setLayoutParams(layoutParams);
        }
        chv();
        if (this.mMode == 2) {
            this.iqU.setText(R.string.df2);
        } else if (this.mMode == 1) {
            this.iqU.setText(R.string.df1);
        } else if (this.cvH == 1) {
            this.iqU.setText(R.string.dgq);
        } else if (this.cvH == 2) {
            this.iqU.setText(R.string.fzu);
        } else {
            this.iqU.setText(R.string.dgr);
        }
        kl(true);
        AppMethodBeat.o(81217);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgR() {
        AppMethodBeat.i(81218);
        j(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.qet.b(4, null);
        } else {
            this.qet.b(0, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(81202);
                    p.a(p.this);
                    AppMethodBeat.o(81202);
                }
            });
        }
        this.qet.a(this);
        onResume();
        AppMethodBeat.o(81218);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgP() {
        return R.layout.api;
    }

    /* Access modifiers changed, original: protected|final */
    public final b cgO() {
        AppMethodBeat.i(81219);
        if (this.qfd == null && this.qet != null) {
            this.qfd = new d(this, this.mMode, this.qet.chh());
        }
        d dVar = this.qfd;
        AppMethodBeat.o(81219);
        return dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cgN() {
        AppMethodBeat.i(81220);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
            AppMethodBeat.o(81220);
            return;
        }
        chv();
        AppMethodBeat.o(81220);
    }

    private void chv() {
        AppMethodBeat.i(81221);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
            AppMethodBeat.o(81221);
            return;
        }
        if (g.Rg().acS() == 6 || g.Rg().acS() == 4) {
            this.qet.jL(0);
        }
        AppMethodBeat.o(81221);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(81222);
        this.qfe.set(false);
        this.pZN = 0;
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            AppMethodBeat.o(81222);
        } else if (this.qff) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
            AppMethodBeat.o(81222);
        } else {
            this.qff = true;
            ab.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", str);
            if (bo.isNullOrNil(str)) {
                this.qff = false;
                AppMethodBeat.o(81222);
            } else if (g.Rg().acS() == 0) {
                Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(R.string.bx9), 0).show();
                this.qff = false;
                AppMethodBeat.o(81222);
            } else {
                m.qiz.stop();
                a(i, str, bArr, i2, i3);
                AppMethodBeat.o(81222);
            }
        }
    }

    private void a(int i, String str, byte[] bArr, int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.i(81223);
        Activity context = this.qet.getContext();
        mv mvVar = new mv();
        if (i == 1) {
            mvVar.cIL.cIN = 0;
        } else {
            mvVar.cIL.cIN = 1;
        }
        mvVar.cIL.scanResult = str;
        if (this.qfn) {
            ab.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            mvVar.cIL.bJt = 1;
            com.tencent.mm.sdk.b.a.xxA.m(mvVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_raw", bArr);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            context.setResult(-1, intent);
            context.finish();
            context.overridePendingTransition(0, 0);
            AppMethodBeat.o(81223);
            return;
        }
        mvVar.cIL.bJt = 0;
        com.tencent.mm.sdk.b.a.xxA.m(mvVar);
        if (mvVar.cIM.ret == 1 || mvVar.cIM.ret == 2) {
            context.finish();
            context.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.qet.cha();
            this.qet.kj(true);
            this.qff = false;
            if (mvVar.cIM.ret != 2) {
                if (!this.qfg) {
                    i4 = 0;
                }
                this.qet.a(str, i4, i2, i3, this.qeR);
                AppMethodBeat.o(81223);
                return;
            }
        } else if (i == 2) {
            af(str, i2, i3);
        }
        AppMethodBeat.o(81223);
    }

    public final void jJ(long j) {
        AppMethodBeat.i(81224);
        ab.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail cost %s", Long.valueOf(j));
        this.qfe.set(false);
        synchronized (this.cli) {
            try {
                chz();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81224);
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(81225);
        ab.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.qet == null || mVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(mVar == null);
            ab.e(str2, str3, objArr);
            this.qff = false;
            AppMethodBeat.o(81225);
        } else if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.h.a(this.qet.getContext(), (int) R.string.dgi, (int) R.string.tz, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(81203);
                    p.this.jZ(true);
                    AppMethodBeat.o(81203);
                }
            });
            AppMethodBeat.o(81225);
        } else {
            int i3;
            switch (i) {
                case 1:
                    if (g.Rg().acT()) {
                        g.Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (com.tencent.mm.network.ab.ch(this.qet.getContext())) {
                        com.tencent.mm.pluginsdk.ui.tools.h.fR(this.qet.getContext());
                    } else {
                        Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    i3 = 1;
                    break;
                case 2:
                    Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    i3 = 1;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                jZ(true);
                AppMethodBeat.o(81225);
            } else if (i == 4 && i2 == -2004) {
                com.tencent.mm.ui.base.h.g(this.qet.getContext(), R.string.dgb, R.string.tz);
                jZ(true);
                AppMethodBeat.o(81225);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.qet.getContext(), this.qet.getContext().getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                jZ(true);
                AppMethodBeat.o(81225);
            } else if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_QINSHUI) {
                kx cgG = ((com.tencent.mm.plugin.scanner.a.g) mVar).cgG();
                if (cgG == null) {
                    ab.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    jZ(true);
                    AppMethodBeat.o(81225);
                    return;
                }
                ab.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(cgG.jCt));
                if (bo.isNullOrNil(cgG.vNK)) {
                    jZ(true);
                    AppMethodBeat.o(81225);
                    return;
                }
                switch (o.a(cgG.jCt, cgG.vNK, this, 4, this.qeR, ((com.tencent.mm.plugin.scanner.a.g) mVar).cvn, ((com.tencent.mm.plugin.scanner.a.g) mVar).cvo, ((com.tencent.mm.plugin.scanner.a.g) mVar).pZG)) {
                    case 0:
                        this.qet.getContext().finish();
                        this.qet.getContext().overridePendingTransition(0, 0);
                        AppMethodBeat.o(81225);
                        return;
                    case 1:
                        ab.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        ab.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.qet.jL(0);
                        break;
                }
                this.qet.kj(false);
                AppMethodBeat.o(81225);
            } else {
                if (mVar.getType() == 666) {
                    if (mVar instanceof com.tencent.mm.ao.c) {
                        this.qet.kj(true);
                        this.qet.getContext().finish();
                        this.qet.getContext().overridePendingTransition(0, 0);
                        AppMethodBeat.o(81225);
                        return;
                    }
                } else if (mVar.getType() == 971) {
                    this.qet.kj(true);
                    this.qet.getContext().finish();
                    this.qet.getContext().overridePendingTransition(0, 0);
                }
                AppMethodBeat.o(81225);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(81226);
        g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (f) this);
        g.Rg().a(666, (f) this);
        g.Rg().a(971, (f) this);
        if (this.qet == null) {
            ab.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            AppMethodBeat.o(81226);
            return;
        }
        if (!this.qfg) {
            this.qff = false;
        }
        chv();
        AppMethodBeat.o(81226);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(81227);
        super.onPause();
        kl(false);
        g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, (f) this);
        g.Rg().b(666, (f) this);
        g.Rg().b(971, (f) this);
        AppMethodBeat.o(81227);
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgQ() {
        return 244;
    }

    private void af(String str, int i, int i2) {
        AppMethodBeat.i(81228);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
            this.qff = false;
            this.qet.kj(false);
            AppMethodBeat.o(81228);
            return;
        }
        String[] split = str.split(",", 2);
        if (split == null || split.length < 2) {
            ab.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
            this.qff = false;
            this.qet.kj(false);
            AppMethodBeat.o(81228);
            return;
        }
        final com.tencent.mm.ai.m gVar = new com.tencent.mm.plugin.scanner.a.g(r.Ws(split[0]), split[1], i, i2);
        gVar.pZG = this.qfg;
        g.Rg().a(gVar, 0);
        this.qet.cha();
        this.qet.kj(true);
        Context context = this.qet.getContext();
        this.qet.getContext().getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b(context, this.qet.getContext().getString(R.string.dgn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(81204);
                g.Rg().c(gVar);
                p.this.qet.kj(false);
                p.this.qff = false;
                AppMethodBeat.o(81204);
            }
        });
        AppMethodBeat.o(81228);
    }

    public final void c(final Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.i(81229);
        this.qff = true;
        if (i2 != -1) {
            this.qff = false;
            this.qfe.set(false);
            this.qfg = false;
            AppMethodBeat.o(81229);
            return;
        }
        switch (i) {
            case 1:
                this.qet.chj();
                break;
            case 4660:
                if (intent == null) {
                    ab.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                    this.qff = false;
                    this.qfe.set(false);
                    this.qfg = false;
                    AppMethodBeat.o(81229);
                    return;
                }
                this.qfe.set(true);
                ab.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", com.tencent.mm.ui.tools.a.i(activity, intent, com.tencent.mm.plugin.i.c.XW()));
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(81206);
                        p pVar = p.this;
                        Context context = activity;
                        activity.getString(R.string.tz);
                        pVar.ehJ = com.tencent.mm.ui.base.h.b(context, activity.getString(R.string.dgl), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(81205);
                                p.this.qff = false;
                                p.this.qfe.set(false);
                                p.this.qfg = false;
                                AppMethodBeat.o(81205);
                            }
                        });
                        AppMethodBeat.o(81206);
                    }
                });
                if (this.qfd != null) {
                    this.qfd.sI();
                }
                if (this.qet != null) {
                    this.qet.kj(true);
                }
                com.tencent.mm.plugin.scanner.a.m.pZK.reset();
                com.tencent.mm.plugin.scanner.e.cgy().pYI.a(r0, new com.tencent.mm.plugin.u.a.b.a() {
                    public final void a(String str, String str2, byte[] bArr, int i, int i2) {
                        int i3 = 1;
                        AppMethodBeat.i(81209);
                        com.tencent.mm.plugin.scanner.a.m.pZK.BU(com.tencent.mm.plugin.scanner.a.m.pZI);
                        if (p.this.qfd != null) {
                            p.this.qfd.chP();
                        }
                        if (p.this.ehJ == null || !p.this.ehJ.isShowing()) {
                            p.this.qff = false;
                            p.this.qfg = false;
                            AppMethodBeat.o(81209);
                            return;
                        }
                        if (p.this.qet != null) {
                            p.this.qet.kj(true);
                        }
                        p.this.ehJ.dismiss();
                        if (bo.isNullOrNil(str2)) {
                            com.tencent.mm.plugin.scanner.a.m.pZK.bHT();
                            com.tencent.mm.ui.base.h.a(activity, (int) R.string.dgk, (int) R.string.tz, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(81207);
                                    p.this.qff = false;
                                    p.this.qfg = false;
                                    com.tencent.mm.plugin.scanner.a.m.pZK.reset();
                                    com.tencent.mm.plugin.scanner.a.m.pZK.BU(com.tencent.mm.plugin.scanner.a.m.pZH);
                                    if (p.this.qet != null) {
                                        p.this.qet.kj(false);
                                        p.this.qet.jK(p.this.qeH);
                                    }
                                    AppMethodBeat.o(81207);
                                }
                            });
                            AppMethodBeat.o(81209);
                            return;
                        }
                        bv.aaq().c(10237, Integer.valueOf(1));
                        p.this.qet.cha();
                        if (!(i == 19 || i == 22)) {
                            i3 = 2;
                        }
                        p.a(p.this, i3, str2, bArr, i, i2);
                        p.this.qfg = false;
                        p.this.qfe.set(false);
                        AppMethodBeat.o(81209);
                    }

                    public final void Vv(String str) {
                        AppMethodBeat.i(81210);
                        com.tencent.mm.plugin.scanner.a.m.pZK.BU(com.tencent.mm.plugin.scanner.a.m.pZI);
                        if (p.this.qfd != null) {
                            p.this.qfd.chP();
                        }
                        if (p.this.ehJ == null || !p.this.ehJ.isShowing()) {
                            p.this.qff = false;
                            p.this.qfe.set(false);
                            p.this.qfg = false;
                            AppMethodBeat.o(81210);
                            return;
                        }
                        if (p.this.qet != null) {
                            p.this.qet.kj(true);
                        }
                        p.this.ehJ.dismiss();
                        com.tencent.mm.plugin.scanner.a.m.pZK.bHT();
                        com.tencent.mm.ui.base.h.a(activity, (int) R.string.dgk, (int) R.string.tz, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(81208);
                                p.this.qff = false;
                                p.this.qfg = false;
                                com.tencent.mm.plugin.scanner.a.m.pZK.reset();
                                com.tencent.mm.plugin.scanner.a.m.pZK.BU(com.tencent.mm.plugin.scanner.a.m.pZH);
                                if (p.this.qet != null) {
                                    p.this.qet.kj(false);
                                    p.this.qet.jK(p.this.qeH);
                                }
                                AppMethodBeat.o(81208);
                            }
                        });
                        p.this.qfe.set(false);
                        AppMethodBeat.o(81210);
                    }
                }, null);
                AppMethodBeat.o(81229);
                return;
        }
        AppMethodBeat.o(81229);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        this.qfj = null;
    }

    public final Context getContext() {
        AppMethodBeat.i(81230);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
            AppMethodBeat.o(81230);
            return null;
        }
        Context context = this.qet.getContext();
        AppMethodBeat.o(81230);
        return context;
    }

    public final void jZ(boolean z) {
        AppMethodBeat.i(81231);
        if (this.qet == null) {
            ab.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
            AppMethodBeat.o(81231);
        } else if (z) {
            this.qet.kj(false);
            AppMethodBeat.o(81231);
        } else {
            this.qet.getContext().finish();
            this.qet.getContext().overridePendingTransition(0, 0);
            AppMethodBeat.o(81231);
        }
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
        AppMethodBeat.i(81232);
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.qet != null) {
            this.qet.ah(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
        AppMethodBeat.o(81232);
    }

    private void chz() {
        AppMethodBeat.i(81233);
        if (this.qfe.get() || this.bufferSize <= 0) {
            if (this.qet != null) {
                this.qet.jK(0);
            }
            AppMethodBeat.o(81233);
            return;
        }
        this.qfe.set(true);
        this.bufferSize--;
        if (this.qfh != null && this.qfh.size() > 0) {
            ((d) cgO()).qfh = this.qfh;
        } else if (this.pZN % 3 >= 2 || !(this.mMode == 1 || this.mMode == 0)) {
            ((d) cgO()).qht = this.mMode;
        } else {
            ((d) cgO()).qht = 3;
        }
        ab.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
        if (this.pZN > 0 && this.qet != null) {
            this.qet.jK(30);
        }
        if (!(this.qfj == null || this.qfk == null)) {
            ((d) cgO()).chT();
            ((d) cgO()).a(this.qfj, this.qfk);
        }
        if (com.tencent.mm.plugin.scanner.a.m.pZK.pZN == 30 && this.qet != null) {
            this.qet.chk();
        }
        this.pZN++;
        AppMethodBeat.o(81233);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(byte[] bArr, Point point, int i, Rect rect) {
        AppMethodBeat.i(81234);
        synchronized (this.cli) {
            try {
                if (this.bufferSize == 1) {
                    ab.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
                    this.bufferSize = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(81234);
                }
            }
        }
        if (this.qfk == null) {
            this.qfk = new Point();
        }
        final byte[] bArr2 = bArr;
        final Point point2 = point;
        final int i2 = i;
        final Rect rect2 = rect;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81211);
                byte[] a = ((d) p.this.cgO()).a(bArr2, point2, i2, rect2, p.this.qfk);
                if (a != null) {
                    synchronized (p.this.cli) {
                        try {
                            if (p.this.qfj == null || p.this.qfl < a.length) {
                                p.this.qfj = new byte[a.length];
                                p.this.qfl = a.length;
                            }
                            System.arraycopy(a, 0, p.this.qfj, 0, a.length);
                            p pVar = p.this;
                            pVar.bufferSize++;
                            p.b(p.this);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(81211);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(81211);
            }
        }, "prepare_decode_data");
        AppMethodBeat.o(81234);
    }

    static /* synthetic */ void a(p pVar) {
        AppMethodBeat.i(81235);
        pVar.qfg = true;
        pVar.qff = true;
        pVar.qet.chg();
        AppMethodBeat.o(81235);
    }
}
