package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class e implements f, com.tencent.mm.plugin.u.a.c.a {
    public String appId;
    public int cvp;
    public String cvr;
    public String imagePath;
    private ProgressDialog jMB = null;
    public int jSW;
    private Activity mActivity;
    a qhA = null;
    private Map<m, Integer> qhB = new HashMap();
    private int qhx;
    private String qhy;
    private Bundle qhz;
    public String source;

    public interface a {
        void o(int i, Bundle bundle);
    }

    public e() {
        AppMethodBeat.i(81404);
        onResume();
        AppMethodBeat.o(81404);
    }

    public final void a(Activity activity, String str, int i, int i2, int i3, a aVar, Bundle bundle) {
        AppMethodBeat.i(81405);
        ab.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mActivity = activity;
        this.qhx = i;
        this.qhy = str;
        this.qhA = aVar;
        this.qhz = bundle;
        String str2 = "";
        if (bundle != null) {
            str2 = bundle.getString("stat_url", "");
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
            AppMethodBeat.o(81405);
        } else if (g.Rg().acS() == 0) {
            Toast.makeText(activity, activity.getString(R.string.bx9), 0).show();
            if (this.qhA != null) {
                this.qhA.o(0, null);
            }
            AppMethodBeat.o(81405);
        } else {
            String str3 = "";
            if (str.startsWith("weixin://qr/")) {
                str3 = str.substring(12) + "@qr";
            }
            if (bo.isNullOrNil(str3)) {
                ab.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", str, Boolean.TRUE, Boolean.TRUE);
                int Cb;
                int Bx;
                final pr prVar;
                if (str.startsWith("weixin://wxpay/bizpayurl")) {
                    ab.i("MicroMsg.QBarStringHandler", "do native pay");
                    this.qhA.o(5, null);
                    Cb = Cb(this.qhx);
                    Bx = Bx(Cb);
                    final b mfVar = new mf();
                    mfVar.cHZ.url = str;
                    mfVar.cHZ.cIb = Bx;
                    mfVar.cHZ.scene = Cb;
                    mfVar.cHZ.context = this.mActivity;
                    if (Bx == 13) {
                        ab.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        mfVar.cHZ.source = this.source;
                        mfVar.cHZ.cvp = this.cvp;
                    }
                    mfVar.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81393);
                            if (e.this.getContext() == null || mfVar.cIa == null) {
                                AppMethodBeat.o(81393);
                            } else if (mfVar.cIa.ret == 1) {
                                e.this.jZ(true);
                                AppMethodBeat.o(81393);
                            } else {
                                if (mfVar.cIa.ret == 2) {
                                    e.this.jZ(false);
                                }
                                AppMethodBeat.o(81393);
                            }
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.a(mfVar, Looper.myLooper());
                    new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81396);
                            if (e.this.qhA != null && (mfVar.cIa == null || mfVar.cIa.ret != 1)) {
                                e.this.qhA.o(3, null);
                            }
                            AppMethodBeat.o(81396);
                        }
                    }, 10000);
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(2), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 1, str, Bx(Cb(this.qhx)), null);
                    if (this.qhA != null) {
                        this.qhA.o(3, null);
                    }
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(1), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (str.startsWith("wxp://wbf2f")) {
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 6, str, Bx(Cb(this.qhx)), null);
                    if (this.qhA != null) {
                        this.qhA.o(3, null);
                    }
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(3), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (i2 == 22 && str.startsWith("m")) {
                    ab.d("MicroMsg.QBarStringHandler", "go to reward");
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    Bx = Bx(Cb(this.qhx));
                    Cb = 1;
                    if (this.jSW == 37) {
                        Cb = 2;
                    } else if (this.jSW == 38) {
                        Cb = 3;
                    } else if (this.jSW == 40) {
                        Cb = 4;
                    }
                    com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, str, Bx, str2, Cb);
                    if (this.qhA != null) {
                        this.qhA.o(3, null);
                    }
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(6), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (str.startsWith("https://payapp.weixin.qq.com/qr/")) {
                    ab.d("MicroMsg.QBarStringHandler", "f2f pay material");
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    Cb = Cb(this.qhx);
                    Bx = Bx(Cb);
                    prVar = new pr();
                    prVar.cLS.cLU = str;
                    prVar.cLS.scene = Cb;
                    prVar.cLS.type = 0;
                    prVar.cLS.aIq = new WeakReference(this.mActivity);
                    prVar.cLS.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81397);
                            if (!bo.isNullOrNil(prVar.cLT.aIm)) {
                                Toast.makeText(e.this.getContext(), prVar.cLT.aIm, 1).show();
                            } else if (bo.isNullOrNil(prVar.cLT.cLV)) {
                                ab.w("MicroMsg.QBarStringHandler", "resp url is null!");
                            } else if (prVar.cLT.actionType == 1) {
                                com.tencent.mm.pluginsdk.wallet.h.a(e.this.getContext(), 1, prVar.cLT.cLV, Bx, null);
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", prVar.cLT.cLV);
                                c.gkE.i(intent, e.this.getContext());
                            }
                            if (e.this.qhA != null) {
                                e.this.qhA.o(3, null);
                            }
                            AppMethodBeat.o(81397);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.m(prVar);
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(5), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (i2 == 22 && str.startsWith("n")) {
                    ab.d("MicroMsg.QBarStringHandler", "qr reward pay material");
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    final int Cb2 = Cb(this.qhx);
                    final int Bx2 = Bx(Cb2);
                    prVar = new pr();
                    prVar.cLS.cLU = str;
                    prVar.cLS.scene = Cb2;
                    prVar.cLS.type = 1;
                    prVar.cLS.aIq = new WeakReference(this.mActivity);
                    prVar.cLS.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81398);
                            if (!bo.isNullOrNil(prVar.cLT.aIm)) {
                                Toast.makeText(e.this.getContext(), prVar.cLT.aIm, 1).show();
                            } else if (bo.isNullOrNil(prVar.cLT.cLV)) {
                                ab.w("MicroMsg.QBarStringHandler", "resp url is null!");
                            } else if (prVar.cLT.actionType == 1) {
                                com.tencent.mm.pluginsdk.wallet.h.a(e.this.getContext(), prVar.cLT.cLV, Bx2, str2, Cb2);
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", prVar.cLT.cLV);
                                c.gkE.i(intent, e.this.getContext());
                            }
                            if (e.this.qhA != null) {
                                e.this.qhA.o(3, null);
                            }
                            AppMethodBeat.o(81398);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.m(prVar);
                    Cc(11);
                    h.pYm.e(16472, Integer.valueOf(7), str, str2);
                    AppMethodBeat.o(81405);
                    return;
                } else if (str.startsWith("wxhb://f2f")) {
                    ab.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                    if (i2 != 19) {
                        AppMethodBeat.o(81405);
                        return;
                    }
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_share_url", str);
                    d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1);
                    h.pYm.e(16472, Integer.valueOf(4), str, str2);
                    Cc(11);
                    AppMethodBeat.o(81405);
                    return;
                } else {
                    a(activity, str, i2, i3, this.appId);
                    if (this.qhA != null) {
                        this.qhA.o(5, null);
                    }
                    AppMethodBeat.o(81405);
                    return;
                }
            }
            a(activity, i, str3, false);
            AppMethodBeat.o(81405);
        }
    }

    private static int Bx(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }

    public final void chU() {
        AppMethodBeat.i(81406);
        ab.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.qhy = null;
        this.mActivity = null;
        onPause();
        AppMethodBeat.o(81406);
    }

    public final void onResume() {
        AppMethodBeat.i(81407);
        ab.i("MicroMsg.QBarStringHandler", "onResume");
        g.Rg().a(106, (f) this);
        g.Rg().a((int) com.tencent.view.d.MIC_PTU_MEISHI, (f) this);
        g.Rg().a(666, (f) this);
        g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX, (f) this);
        AppMethodBeat.o(81407);
    }

    public final void onPause() {
        AppMethodBeat.i(81408);
        ab.i("MicroMsg.QBarStringHandler", "onPause");
        g.Rg().b(106, (f) this);
        g.Rg().b((int) com.tencent.view.d.MIC_PTU_MEISHI, (f) this);
        g.Rg().b(666, (f) this);
        g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX, (f) this);
        AppMethodBeat.o(81408);
    }

    private void a(Activity activity, int i, String str, boolean z) {
        int i2 = 2;
        AppMethodBeat.i(81409);
        ab.i("MicroMsg.QBarStringHandler", "start search contact %s", str);
        if (i != 2) {
            i2 = 1;
        }
        final m fVar = new com.tencent.mm.plugin.messenger.a.f(str, i2, 5, z);
        this.qhB.put(fVar, Integer.valueOf(1));
        g.Rg().a(fVar, 0);
        activity.getString(R.string.tz);
        this.jMB = com.tencent.mm.ui.base.h.b(activity, activity.getString(R.string.dy4), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(81399);
                g.Rg().c(fVar);
                if (e.this.qhA != null) {
                    e.this.qhA.o(1, null);
                }
                AppMethodBeat.o(81399);
            }
        });
        AppMethodBeat.o(81409);
    }

    private void a(Activity activity, String str, int i, int i2, String str2) {
        AppMethodBeat.i(81410);
        ab.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", str, Integer.valueOf(this.qhx), Integer.valueOf(this.jSW > 0 ? this.jSW : Cb(this.qhx)));
        final m hVar = new com.tencent.mm.modelsimple.h(str, r2, i, i2, str2, (int) System.currentTimeMillis(), new byte[0]);
        if (str.startsWith("http://weixin.qq.com/r/")) {
            String stringExtra = activity.getIntent().getStringExtra("img_gallery_session_id");
            hVar.lV(com.tencent.mm.ui.e.a.MQ(this.qhx));
            String str3 = "";
            if (!bo.isNullOrNil(stringExtra)) {
                v.b nV = v.Zp().nV(stringExtra);
                if (nV != null) {
                    str3 = nV.getString("url", null);
                }
                hVar.tq(str3);
            }
            ab.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", str3, Integer.valueOf(r3));
        }
        this.qhB.put(hVar, Integer.valueOf(1));
        g.Rg().a(hVar, 0);
        if (this.jMB != null) {
            this.jMB.dismiss();
        }
        activity.getString(R.string.tz);
        this.jMB = com.tencent.mm.ui.base.h.b((Context) activity, activity.getString(R.string.dgn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(81401);
                g.Rg().c(hVar);
                if (e.this.qhA != null) {
                    e.this.qhA.o(1, null);
                }
                AppMethodBeat.o(81401);
            }
        });
        AppMethodBeat.o(81410);
    }

    private static int Cb(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        if (i == 3) {
            return 42;
        }
        return 30;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0277  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81411);
        ab.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        String str2;
        if (mVar == null) {
            String str3 = "MicroMsg.QBarStringHandler";
            str2 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(mVar == null);
            ab.e(str3, str2, objArr);
            if (this.qhA != null) {
                this.qhA.o(2, null);
            }
            AppMethodBeat.o(81411);
            return;
        }
        if (!this.qhB.containsKey(mVar)) {
            if (mVar instanceof com.tencent.mm.ao.c) {
                ab.e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                ab.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                AppMethodBeat.o(81411);
                return;
            }
        }
        this.qhB.remove(mVar);
        if (this.jMB != null) {
            this.jMB.dismiss();
            this.jMB = null;
        }
        m hVar;
        if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX && i == 4 && i2 == -2034) {
            hVar = new com.tencent.mm.modelsimple.h(((n) mVar).gfh, null, 50, 0, 0, new byte[0]);
            g.RQ();
            g.RO().eJo.a(hVar, 0);
            this.qhB.put(hVar, Integer.valueOf(1));
            AppMethodBeat.o(81411);
        } else if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.h.a(this.mActivity, (int) R.string.dgi, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(81402);
                    if (e.this.qhA != null) {
                        e.this.qhA.o(1, null);
                    }
                    AppMethodBeat.o(81402);
                }
            });
            AppMethodBeat.o(81411);
        } else {
            Object obj;
            switch (i) {
                case 1:
                    if (g.Rg().acT()) {
                        g.Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (com.tencent.mm.network.ab.ch(this.mActivity)) {
                        com.tencent.mm.pluginsdk.ui.tools.h.fR(this.mActivity);
                    } else {
                        Toast.makeText(this.mActivity, this.mActivity.getString(R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    obj = 1;
                    break;
                case 2:
                    Toast.makeText(this.mActivity, this.mActivity.getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            Activity activity;
            String stringExtra;
            Bundle bundle;
            if (obj != null) {
                if (this.qhA != null) {
                    this.qhA.o(1, null);
                }
                AppMethodBeat.o(81411);
            } else if (i == 4 && i2 == -2004) {
                com.tencent.mm.ui.base.h.g(this.mActivity, R.string.dgb, R.string.tz);
                if (this.qhA != null) {
                    this.qhA.o(1, null);
                }
                AppMethodBeat.o(81411);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.mActivity, this.mActivity.getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                if (this.qhA != null) {
                    this.qhA.o(1, null);
                }
                AppMethodBeat.o(81411);
            } else if (mVar.getType() == 106) {
                com.tencent.mm.plugin.messenger.a.f fVar = (com.tencent.mm.plugin.messenger.a.f) mVar;
                if (!fVar.opS) {
                    buv bOj = fVar.bOj();
                    if (ad.Mn(bOj.wBT) && bOj.wCa != null && !bo.isNullOrNil(bOj.wCa.gvc) && com.tencent.mm.modelappbrand.a.pi(bOj.wCa.gvc)) {
                        int i3;
                        if (this.jSW > 0) {
                            i3 = this.jSW;
                        } else {
                            i3 = Cb(this.qhx);
                        }
                        ab.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", this.qhy, Integer.valueOf(this.qhx), Integer.valueOf(i3));
                        hVar = new com.tencent.mm.modelsimple.h(this.qhy, null, 43, 0, 0, new byte[0]);
                        this.qhB.put(hVar, Integer.valueOf(1));
                        g.Rg().a(hVar, 0);
                        if (this.jMB != null) {
                            this.jMB.dismiss();
                        }
                        Context context = this.mActivity;
                        this.mActivity.getString(R.string.tz);
                        this.jMB = com.tencent.mm.ui.base.h.b(context, this.mActivity.getString(R.string.dgn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(81395);
                                g.Rg().c(hVar);
                                if (e.this.qhA != null) {
                                    e.this.qhA.o(1, null);
                                }
                                AppMethodBeat.o(81395);
                            }
                        });
                        obj = 1;
                        if (obj == null) {
                            AppMethodBeat.o(81411);
                            return;
                        }
                        buv bOj2 = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                        str2 = aa.a(bOj2.wcB);
                        ab.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + bOj2.wcB);
                        o.acd().n(str2, aa.a(bOj2.vEF));
                        if (this.jMB != null && this.jMB.isShowing()) {
                            ab.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                            this.jMB.dismiss();
                        }
                        if (bo.nullAsNil(str2).length() > 0) {
                            ad aoO = ((j) g.K(j.class)).XM().aoO(str2);
                            if (aoO != null && com.tencent.mm.n.a.jh(aoO.field_type) && aoO.dsf()) {
                                com.tencent.mm.aj.d qP = z.aeR().qP(str2);
                                qP.cJ(false);
                                com.tencent.mm.aj.d.b bVar = qP.fuY;
                                if (bVar.fvc != null) {
                                    bVar.fvs = bVar.fvc.optInt("ScanQRCodeType", 0);
                                }
                                if (bVar.fvs == 1) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (!(obj == null || qP.adP())) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", str2);
                                    intent.putExtra("finish_direct", true);
                                    c.gkE.d(intent, this.mActivity);
                                    obj = 1;
                                }
                            }
                            i3 = chV();
                            Intent intent2 = new Intent();
                            com.tencent.mm.api.b.a(intent2, bOj2, i3);
                            if (!(aoO == null || com.tencent.mm.n.a.jh(aoO.field_type))) {
                                intent2.putExtra("Contact_IsLBSFriend", true);
                            }
                            if ((bOj2.wBT & 8) > 0) {
                                h.pYm.X(10298, str2 + "," + i3);
                            }
                            if (this.mActivity != null) {
                                if (ad.Mn(bOj2.wBT)) {
                                    activity = this.mActivity;
                                    if (activity != null) {
                                        intent2.putExtra("qbarScene", this.qhx);
                                        stringExtra = activity.getIntent().getStringExtra("img_gallery_session_id");
                                        if (!bo.isNullOrNil(stringExtra)) {
                                            v.b nV = v.Zp().nV(stringExtra);
                                            if (nV != null) {
                                                str2 = nV.getString("preUsername", null);
                                                String string = nV.getString("preChatName", null);
                                                String string2 = nV.getString("url", null);
                                                stringExtra = nV.getString("rawUrl", null);
                                                int ad = u.ad(str2, string);
                                                intent2.putExtra("preUsername", str2);
                                                intent2.putExtra("preChatName", string);
                                                intent2.putExtra("url", string2);
                                                intent2.putExtra("rawUrl", stringExtra);
                                                intent2.putExtra("preChatTYPE", ad);
                                            }
                                        }
                                    }
                                }
                                c.gkE.c(intent2, this.mActivity);
                                h hVar2 = h.pYm;
                                Object[] objArr2 = new Object[6];
                                objArr2[0] = Integer.valueOf(ad.Mn(bOj2.wBT) ? 0 : 1);
                                objArr2[1] = Integer.valueOf(this.cvp);
                                objArr2[2] = Integer.valueOf(this.qhx);
                                objArr2[3] = this.imagePath;
                                objArr2[4] = this.qhy;
                                objArr2[5] = bo.nullAsNil(this.cvr);
                                hVar2.e(14268, objArr2);
                            }
                            obj = 1;
                        } else {
                            if (this.mActivity != null) {
                                Toast.makeText(this.mActivity, R.string.dyr, 0).show();
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            if (this.qhA != null) {
                                bundle = new Bundle();
                                bundle.putString("geta8key_fullurl", aa.a(((com.tencent.mm.plugin.messenger.a.f) mVar).bOj().wcB));
                                bundle.putInt("geta8key_action_code", 4);
                                this.qhA.o(3, bundle);
                            }
                            Cc(4);
                            AppMethodBeat.o(81411);
                            return;
                        }
                        if (this.qhA != null) {
                            this.qhA.o(1, null);
                        }
                        AppMethodBeat.o(81411);
                        return;
                    }
                }
                obj = null;
                if (obj == null) {
                }
            } else if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX) {
                bvk bvk = ((n) mVar).gfg;
                str2 = bvk.jBB;
                ab.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(str2)));
                if (this.jMB != null && this.jMB.isShowing()) {
                    ab.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                    this.jMB.dismiss();
                }
                if (bo.nullAsNil(str2).length() > 0) {
                    ad aoO2 = ((j) g.K(j.class)).XM().aoO(str2);
                    int chV = chV();
                    Intent intent3 = new Intent();
                    com.tencent.mm.api.b.a(intent3, bvk, chV);
                    if (!(aoO2 == null || com.tencent.mm.n.a.jh(aoO2.field_type))) {
                        intent3.putExtra("Contact_IsLBSFriend", true);
                    }
                    if (this.mActivity != null) {
                        c.gkE.c(intent3, this.mActivity);
                        h.pYm.e(14268, Integer.valueOf(2), Integer.valueOf(this.cvp), Integer.valueOf(this.qhx), this.imagePath, this.qhy, bo.nullAsNil(this.cvr));
                    }
                    obj = 1;
                } else {
                    if (this.mActivity != null) {
                        Toast.makeText(this.mActivity, R.string.dyr, 0).show();
                    }
                    obj = null;
                }
                if (obj != null) {
                    if (this.qhA != null) {
                        bundle = new Bundle();
                        bundle.putString("geta8key_fullurl", bvk.jBB);
                        bundle.putInt("geta8key_action_code", 4);
                        this.qhA.o(3, bundle);
                    }
                    Cc(4);
                    AppMethodBeat.o(81411);
                    return;
                }
                if (this.qhA != null) {
                    this.qhA.o(1, null);
                }
                AppMethodBeat.o(81411);
            } else if (mVar.getType() == com.tencent.view.d.MIC_PTU_MEISHI) {
                int i4;
                String aiT = ((com.tencent.mm.modelsimple.h) mVar).aiT();
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_fullurl", aiT);
                bundle2.putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.h) mVar).aiV());
                if (this.qhA != null) {
                    this.qhA.o(4, bundle2);
                }
                Cc(((com.tencent.mm.modelsimple.h) mVar).aiV());
                if (this.jSW > 0) {
                    i4 = this.jSW;
                } else {
                    i4 = Cb(this.qhx);
                }
                ab.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", Integer.valueOf(i4));
                boolean a = com.tencent.mm.plugin.u.a.c.a(this, (com.tencent.mm.modelsimple.h) mVar, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(81403);
                        if (e.this.qhA != null) {
                            e.this.qhA.o(1, null);
                        }
                        AppMethodBeat.o(81403);
                    }
                }, this.qhy, i4, this.qhx, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(81394);
                        if (e.this.qhA != null) {
                            e.this.qhA.o(3, null);
                        }
                        AppMethodBeat.o(81394);
                    }
                }, this.qhz);
                if (!a && ((com.tencent.mm.modelsimple.h) mVar).aiV() == 4) {
                    a(this.mActivity, this.qhx, aiT, true);
                    AppMethodBeat.o(81411);
                } else if (a || ((com.tencent.mm.modelsimple.h) mVar).aiV() != 29) {
                    ab.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", Boolean.valueOf(a));
                    if (!(a || this.qhA == null)) {
                        this.qhA.o(1, null);
                    }
                    AppMethodBeat.o(81411);
                } else {
                    activity = this.mActivity;
                    ab.i("MicroMsg.QBarStringHandler", "start search contact %s", aiT);
                    final m nVar = new n(aiT, (byte) 0);
                    this.qhB.put(nVar, Integer.valueOf(1));
                    g.Rg().a(nVar, 0);
                    activity.getString(R.string.tz);
                    this.jMB = com.tencent.mm.ui.base.h.b(activity, activity.getString(R.string.dy4), new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(81400);
                            g.Rg().c(nVar);
                            if (e.this.qhA != null) {
                                e.this.qhA.o(1, null);
                            }
                            AppMethodBeat.o(81400);
                        }
                    });
                    AppMethodBeat.o(81411);
                }
            } else {
                if (mVar.getType() == 666) {
                    if (i != 0 || i2 != 0) {
                        ab.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
                    } else if (mVar instanceof com.tencent.mm.ao.c) {
                        ab.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", ((com.tencent.mm.ao.c) mVar).agd().ProductID);
                        Intent intent4 = new Intent();
                        intent4.putExtra("extra_id", stringExtra);
                        intent4.putExtra("preceding_scence", 11);
                        intent4.putExtra("download_entrance_scene", 14);
                        d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", intent4);
                        ab.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                        if (this.qhA != null) {
                            this.qhA.o(3, null);
                        }
                        AppMethodBeat.o(81411);
                        return;
                    }
                }
                AppMethodBeat.o(81411);
            }
        }
    }

    private int chV() {
        switch (this.qhx) {
            case 1:
                return 45;
            default:
                return 30;
        }
    }

    private void Cc(int i) {
        AppMethodBeat.i(81412);
        if (this.qhz != null) {
            String string = this.qhz.getString("stat_url");
            if ((this.cvp == 6 || this.cvp == 0) && !bo.isNullOrNil(string)) {
                String str = "";
                String str2 = "";
                try {
                    str = URLEncoder.encode(bo.nullAsNil(string), "UTF-8");
                    str2 = URLEncoder.encode(bo.nullAsNil(this.qhy), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.QBarStringHandler", e, "", new Object[0]);
                }
                h.pYm.e(13329, str, str2, Integer.valueOf(i));
            }
        }
        AppMethodBeat.o(81412);
    }

    public final Context getContext() {
        return this.mActivity;
    }

    public final void jZ(boolean z) {
        AppMethodBeat.i(81413);
        if (z) {
            if (this.qhA != null) {
                this.qhA.o(1, null);
                AppMethodBeat.o(81413);
                return;
            }
        } else if (this.qhA != null) {
            this.qhA.o(3, null);
        }
        AppMethodBeat.o(81413);
    }
}
