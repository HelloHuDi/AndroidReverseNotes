package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.wxmm.v2helper;

@a(7)
public class WalletIapUI extends MMActivity implements f {
    private final int DEFAULT = 1003;
    private final int OK = 1000;
    private int currentState = 1003;
    private int czV = 0;
    private Dialog iMU;
    private c piM = new c<ul>() {
        {
            AppMethodBeat.i(48275);
            this.xxI = ul.class.getName().hashCode();
            AppMethodBeat.o(48275);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(48276);
            ul ulVar = (ul) bVar;
            ab.i("MicroMsg.WalletIapUI", "payListener callback to close progress");
            if (ulVar instanceof ul) {
                WalletIapUI.f(WalletIapUI.this);
                AppMethodBeat.o(48276);
                return true;
            }
            ab.f("MicroMsg.WalletIapUI", "mismatched event");
            AppMethodBeat.o(48276);
            return false;
        }
    };
    private c tRS = new c<uw>() {
        {
            AppMethodBeat.i(48271);
            this.xxI = uw.class.getName().hashCode();
            AppMethodBeat.o(48271);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(48272);
            uw uwVar = (uw) bVar;
            ab.i("MicroMsg.WalletIapUI", "walletPayResultListener onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s", Integer.valueOf(uwVar.cRI.result), uwVar.cRI.czZ, Integer.valueOf(uwVar.cRI.cRH));
            if (uwVar.cRI == null || bo.isNullOrNil(uwVar.cRI.czZ) || !uwVar.cRI.czZ.equalsIgnoreCase("key_from_scene_appbrandgame") || uwVar.cRI.cRH != 1) {
                ab.i("MicroMsg.WalletIapUI", "FuncId %s,is not current request key || comeFrom:%s is not FINISH", "key_from_scene_appbrandgame", Integer.valueOf(uwVar.cRI.cRH));
                AppMethodBeat.o(48272);
            } else {
                if (uwVar.cRI.intent == null || uwVar.cRI.intent.getExtras() == null || uwVar.cRI.intent.getExtras().get("key_total_fee") == null) {
                    ab.i("MicroMsg.WalletIapUI", "no payAmount");
                } else {
                    WalletIapUI.this.tSh = uwVar.cRI.intent.getExtras().get("key_total_fee").toString();
                    ab.i("MicroMsg.WalletIapUI", "has payAmount:%s", WalletIapUI.this.tSh);
                }
                if (WalletIapUI.this.tSi != null) {
                    WalletIapUI.this.tSi.a(WalletIapUI.this, WalletIapUI.this.czV, uwVar.cRI.result, uwVar.cRI.intent);
                    ab.d("MicroMsg.WalletIapUI", "walletPayResultListener handled by mWalletPay.");
                } else {
                    ab.e("MicroMsg.WalletIapUI", "havn't handle user action");
                    Intent intent = new Intent();
                    com.tencent.mm.plugin.wallet_index.c.b bu = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
                    intent.putExtra("key_err_code", bu.nqa);
                    intent.putExtra("key_err_msg", bu.nqb);
                    intent.putExtra("key_launch_ts", a.tRs);
                    WalletIapUI.this.setResult(-1, intent);
                    WalletIapUI.this.finish();
                }
                AppMethodBeat.o(48272);
            }
            return true;
        }
    };
    private final int tRX = 4;
    private final int tRY = 0;
    private final int tRZ = 1;
    private c tRr;
    private d tRt = new d() {
        public final void a(com.tencent.mm.plugin.wallet_index.c.b bVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
            AppMethodBeat.i(48274);
            ab.d("MicroMsg.WalletIapUI", "Consume finished: " + bVar + ", purchase: " + cVar);
            if (bVar.cSV()) {
                WalletIapUI.this.currentState = 1002;
                ab.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                WalletIapUI.this.currentState = 1000;
                ab.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", bVar.nqa);
            intent.putExtra("key_err_msg", bVar.nqb);
            intent.putStringArrayListExtra("key_response_product_ids", WalletIapUI.this.tRr.tRz);
            intent.putStringArrayListExtra("key_response_series_ids", WalletIapUI.this.tRr.tRA);
            intent.putExtra("key_launch_ts", a.tRs);
            WalletIapUI.this.setResult(-1, intent);
            WalletIapUI.this.finish();
            AppMethodBeat.o(48274);
        }
    };
    private final int tSa = 2;
    private final int tSb = 3;
    private final int tSc = 1001;
    private final int tSd = 1002;
    private boolean tSe = false;
    private int tSf = 0;
    private boolean tSg;
    private String tSh = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private b tSi;
    private d tSj = new d() {
        public final void a(com.tencent.mm.plugin.wallet_index.c.b bVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar) {
            AppMethodBeat.i(48273);
            ab.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + bVar + ", purchase: " + cVar);
            if (WalletIapUI.this.tSi instanceof a) {
                if (cVar != null) {
                    z.d(cVar.tQS, cVar.kWz, cVar.tQY, bVar.nqa, bVar.nqb);
                } else {
                    a aVar = (a) WalletIapUI.this.tSi;
                    z.d(aVar.tRw, aVar.kWz, aVar.tQY, bVar.nqa, bVar.nqb);
                }
            }
            Intent intent;
            if (bVar.cSV()) {
                ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + bVar.nqa + " , errMsg: " + bVar.nqb);
                if (bVar.nqa == 1) {
                    WalletIapUI.this.currentState = 1001;
                } else {
                    WalletIapUI.this.currentState = 1002;
                }
                intent = new Intent();
                intent.putExtra("key_err_code", bVar.nqa);
                intent.putExtra("key_err_msg", bVar.nqb);
                intent.putExtra("key_launch_ts", a.tRs);
                intent.putExtra("key_gw_error_code", bVar.tQZ);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.o(48273);
            } else if (bVar.cSU()) {
                WalletIapUI.this.tSf = 3;
                ab.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                WalletIapUI.this.tSi.b(WalletIapUI.this, false);
                AppMethodBeat.o(48273);
            } else if (cVar != null) {
                ab.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + cVar.kWz + ",billNo:" + cVar.tQV);
                g.RQ();
                g.RO().eJo.a(WalletIapUI.this.tRr.a(cVar, false), 0);
                WalletIapUI.this.tSf = 2;
                WalletIapUI.e(WalletIapUI.this);
                AppMethodBeat.o(48273);
            } else {
                WalletIapUI.this.currentState = 1002;
                intent = new Intent();
                com.tencent.mm.plugin.wallet_index.c.b bu = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
                intent.putExtra("key_err_code", bu.nqa);
                intent.putExtra("key_err_msg", bu.nqb);
                intent.putExtra("key_launch_ts", a.tRs);
                intent.putExtra("key_gw_error_code", bu.tQZ);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.o(48273);
            }
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletIapUI() {
        AppMethodBeat.i(48278);
        AppMethodBeat.o(48278);
    }

    static /* synthetic */ void e(WalletIapUI walletIapUI) {
        AppMethodBeat.i(48288);
        walletIapUI.aoW();
        AppMethodBeat.o(48288);
    }

    static /* synthetic */ void f(WalletIapUI walletIapUI) {
        AppMethodBeat.i(48289);
        walletIapUI.aoX();
        AppMethodBeat.o(48289);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48279);
        super.onCreate(bundle);
        ab.i("MicroMsg.WalletIapUI", "onCreate");
        g.RQ();
        g.RO().eJo.a((int) v2helper.EMethodOutputVolumeGainEnable, (f) this);
        g.RQ();
        g.RO().eJo.a(414, (f) this);
        g.RQ();
        g.RO().eJo.a(1130, (f) this);
        g.RQ();
        g.RO().eJo.a(1306, (f) this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            aoW();
        }
        this.tSg = getIntent().getBooleanExtra("key_is_mini_program", false);
        this.tRr = new c();
        this.tRr.tRE = this.tSg;
        if (getIntent().getBooleanExtra("key_force_google", false) || r.YL()) {
            ab.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.tSi = new a(this, this.tRr, this.tRt);
        } else {
            ab.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.tSi = new f(this.tRr, this.piM);
        }
        this.tRr.peo = this.tSi.cSW();
        com.tencent.mm.sdk.b.a.xxA.c(this.tRS);
        AppMethodBeat.o(48279);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.i(48280);
        ab.i("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        ab.i("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.tSe) {
            this.tSe = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                ab.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.tSf = 3;
                this.tSi.b(this, true);
                AppMethodBeat.o(48280);
                return;
            }
            m fVar;
            c cVar = this.tRr;
            String stringExtra = intent.getStringExtra("key_product_id");
            cVar.kWz = stringExtra;
            cVar.tRD.add(stringExtra);
            ab.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(stringExtra)));
            this.tRr.tQY = intent.getStringExtra("key_price");
            this.tRr.tQX = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.tRr.mCount = intent.getIntExtra("key_count", 1);
            stringExtra = intent.getStringExtra("key_appid");
            String stringExtra3 = intent.getStringExtra("key_desc");
            String stringExtra4 = intent.getStringExtra("key_busiid");
            this.tRr.tRF = intent.getStringExtra("key_virtual_pay_sign");
            this.tRr.tRG = intent.getStringExtra("key_attach");
            g.RQ();
            p pVar = g.RO().eJo;
            c cVar2 = this.tRr;
            int cSW = this.tSi.cSW();
            if (cVar2.tRE) {
                fVar = new com.tencent.mm.plugin.wallet_index.c.f(cSW, stringExtra, cVar2.tQY, stringExtra3, cVar2.mCount, cVar2.tQX, stringExtra4, cVar2.tRF, cVar2.tRG);
            } else {
                fVar = new s(cVar2.kWz, cVar2.tQY, cVar2.tQX, cVar2.mCount, cSW, stringExtra2);
            }
            pVar.a(fVar, 0);
        }
        AppMethodBeat.o(48280);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(48281);
        ab.i("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(48281);
    }

    public void onDestroy() {
        int i;
        AppMethodBeat.i(48282);
        ab.i("MicroMsg.WalletIapUI", "onDestroy");
        aoX();
        if (this.currentState == 1003) {
            this.currentState = 1001;
        }
        String str = "";
        if (getIntent() != null) {
            str = getIntent().getStringExtra("key_appid");
        }
        if (this.tSi instanceof f) {
            i = 0;
        } else {
            i = 1;
        }
        ab.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", Integer.valueOf(15751), Boolean.valueOf(this.tSg), str, Integer.valueOf(i), Integer.valueOf(this.tSf), Integer.valueOf(this.currentState), this.tSh, Long.valueOf((long) (bo.getDouble(this.tSh, 0.0d) * 100.0d)));
        h hVar = h.pYm;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.tSg ? 0 : 1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.tSf);
        objArr[4] = Integer.valueOf(this.currentState);
        objArr[5] = this.tSh;
        objArr[6] = Long.valueOf(r4);
        hVar.e(15751, objArr);
        h.pYm.a(1044, (long) (this.currentState - 1000), 1, false);
        if (this.currentState == 1001) {
            h.pYm.a(1044, (long) (this.tSf + 4), 1, false);
        } else if (this.currentState == 1002) {
            h.pYm.a(1044, (long) (this.tSf + 8), 1, false);
        }
        if (this.tSi != null) {
            this.tSi.l(this);
        }
        g.RQ();
        g.RO().eJo.b((int) v2helper.EMethodOutputVolumeGainEnable, (f) this);
        g.RQ();
        g.RO().eJo.b(414, (f) this);
        g.RQ();
        g.RO().eJo.b(1130, (f) this);
        g.RQ();
        g.RO().eJo.b(1306, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.tRS);
        super.onDestroy();
        AppMethodBeat.o(48282);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48283);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(i2)));
        if (intent == null || intent.getExtras() == null || intent.getExtras().get("key_total_fee") == null) {
            ab.i("MicroMsg.WalletIapUI", "no payAmount");
        } else {
            this.tSh = intent.getExtras().get("key_total_fee").toString();
            ab.i("MicroMsg.WalletIapUI", "has payAmount:%s", this.tSh);
        }
        if (this.tSi != null) {
            this.tSi.a((MMActivity) this, i, i2, intent);
            ab.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            AppMethodBeat.o(48283);
            return;
        }
        ab.e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.c.b bu = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
        intent2.putExtra("key_err_code", bu.nqa);
        intent2.putExtra("key_err_msg", bu.nqb);
        intent2.putExtra("key_launch_ts", a.tRs);
        setResult(-1, intent2);
        finish();
        AppMethodBeat.o(48283);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(48284);
        ab.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + mVar.getType() + " errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.c.b bu = com.tencent.mm.plugin.wallet_index.c.b.bu(i2, str);
        int i3 = bu.nqa;
        String str2 = bu.nqb;
        int type = mVar.getType();
        c cVar;
        Intent intent;
        switch (type) {
            case 414:
            case 1306:
                boolean z2;
                cVar = this.tRr;
                if (mVar instanceof t) {
                    t tVar = (t) mVar;
                    cVar.kWz = tVar.kWz;
                    cVar.tRB = tVar.kWB;
                    cVar.tRC = tVar.tRC;
                    z2 = tVar.errCode == 0;
                } else if (mVar instanceof l) {
                    l lVar = (l) mVar;
                    cVar.kWz = lVar.cwg;
                    z2 = lVar.errCode == 0;
                } else {
                    z2 = false;
                }
                cVar.tRD.remove(cVar.kWz);
                if (z2) {
                    ab.i("MicroMsg.IapData", "Verify " + cVar.kWz + " OK");
                    cVar.tRz.add(cVar.kWz);
                    cVar.tRA.add(cVar.tRB);
                } else if (!cVar.kWz.startsWith("com.tencent.xin.wco")) {
                    ab.i("MicroMsg.IapData", "Verify " + cVar.kWz + " fail");
                } else if (cVar.tRC > 0) {
                    cVar.tRz.add(cVar.kWz);
                    cVar.tRA.add(cVar.tRB);
                    ab.i("MicroMsg.IapData", "Verify " + cVar.kWz + " fail and cosume");
                    if (this.tRr.tRD.isEmpty()) {
                        ab.d("MicroMsg.WalletIapUI", "Verify All End... ");
                        if (this.tRr.tRz.isEmpty()) {
                            ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                            this.currentState = 1002;
                            intent = new Intent();
                            intent.putExtra("key_err_code", i3);
                            intent.putExtra("key_err_msg", str2);
                            intent.putExtra("key_response_position", 3);
                            intent.putExtra("key_launch_ts", a.tRs);
                            setResult(-1, intent);
                            finish();
                        } else {
                            ab.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.tRr.tRz.size() + ", Consume ...");
                            this.tSi.a((MMActivity) this, this.tRr.tRz, this.tRt, z);
                            AppMethodBeat.o(48284);
                            return;
                        }
                    }
                    AppMethodBeat.o(48284);
                    return;
                } else {
                    ab.i("MicroMsg.IapData", "Verify " + cVar.kWz + " fail");
                }
                z = false;
                if (this.tRr.tRD.isEmpty()) {
                }
                AppMethodBeat.o(48284);
                return;
            case v2helper.EMethodOutputVolumeGainEnable /*422*/:
            case 1130:
                cVar = this.tRr;
                com.tencent.mm.plugin.wallet_index.c.b bu2 = com.tencent.mm.plugin.wallet_index.c.b.bu(i3, str2);
                type = bu2.nqa;
                if (mVar instanceof s) {
                    s sVar = (s) mVar;
                    if (type == 0) {
                        blm blm;
                        if (cVar.cSX()) {
                            aui aui;
                            blm = (blm) sVar.ehh.fsH.fsP;
                            if (blm != null) {
                                aui aui2 = new aui();
                                aui2.wyq = blm.wOw;
                                aui2.wyr = blm.wOx;
                                aui2.cIf = 5;
                                aui2.wys = blm.wOy;
                                ab.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + blm.wOy);
                                aui = aui2;
                            } else {
                                ab.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
                                aui = null;
                            }
                            cVar.tRf = aui;
                        } else {
                            auh auh;
                            blm = (blm) sVar.ehh.fsH.fsP;
                            if (blm != null) {
                                auh auh2 = new auh();
                                auh2.wma = sVar.tQX;
                                auh2.pho = sVar.kWz;
                                auh2.pdz = sVar.tQY;
                                auh2.wym = blm.wOv;
                                ab.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + blm.wOv);
                                auh = auh2;
                            } else {
                                ab.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
                                auh = null;
                            }
                            cVar.tRe = auh;
                        }
                    }
                } else if (mVar instanceof com.tencent.mm.plugin.wallet_index.c.f) {
                    com.tencent.mm.plugin.wallet_index.c.f fVar = (com.tencent.mm.plugin.wallet_index.c.f) mVar;
                    if (type == 0 && fVar.errCode == 0) {
                        cVar.tRf = fVar.tRf;
                        cVar.tRe = fVar.tRe;
                        if (cVar.cSX()) {
                            if (cVar.tRf != null) {
                                cVar.tRw = cVar.tRf.wym;
                            } else {
                                ab.e("MicroMsg.IapData", "iapWxPayData is null");
                            }
                        } else if (cVar.tRe != null) {
                            cVar.tRw = cVar.tRe.wym;
                        } else {
                            ab.e("MicroMsg.IapData", "iapGoogleData is null");
                        }
                    }
                }
                if (bu2.nqa == 0) {
                    this.czV = this.tSi.a(this, this.tSj);
                    this.tSf = 1;
                    AppMethodBeat.o(48284);
                    return;
                }
                this.currentState = 1002;
                ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + bu2.nqa + " , errMsg: " + bu2.nqb);
                intent = new Intent();
                intent.putExtra("key_err_code", bu2.nqa);
                intent.putExtra("key_err_msg", bu2.nqb);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(48284);
                return;
            default:
                ab.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(type)));
                AppMethodBeat.o(48284);
                return;
        }
    }

    public void finish() {
        AppMethodBeat.i(48285);
        ab.i("MicroMsg.WalletIapUI", "finish");
        aoX();
        super.finish();
        AppMethodBeat.o(48285);
    }

    private void aoW() {
        AppMethodBeat.i(48286);
        ab.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
        this.iMU = com.tencent.mm.wallet_core.ui.g.a((Context) this, getString(R.string.un), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.plugin.wallet_index.c.b bu;
                AppMethodBeat.i(48277);
                ab.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", Integer.valueOf(WalletIapUI.this.tSf));
                if (WalletIapUI.this.tSf == 2) {
                    bu = com.tencent.mm.plugin.wallet_index.c.b.bu(7, "");
                } else {
                    bu = com.tencent.mm.plugin.wallet_index.c.b.bu(1, "");
                }
                Intent intent = new Intent();
                intent.putExtra("key_err_code", bu.nqa);
                intent.putExtra("key_err_msg", bu.nqb);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.o(48277);
            }
        });
        AppMethodBeat.o(48286);
    }

    private void aoX() {
        AppMethodBeat.i(48287);
        ab.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
        if (this.iMU != null && this.iMU.isShowing()) {
            this.iMU.dismiss();
            this.iMU = null;
        }
        AppMethodBeat.o(48287);
    }
}
