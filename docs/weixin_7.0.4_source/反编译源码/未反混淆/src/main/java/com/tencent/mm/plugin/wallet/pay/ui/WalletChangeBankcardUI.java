package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.VError;
import java.util.ArrayList;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int toB = 1;
    protected int cIf = 0;
    public String gHr;
    protected TextView klD;
    protected Button pTi;
    private c pUc = new c<vc>() {
        {
            AppMethodBeat.i(45957);
            this.xxI = vc.class.getName().hashCode();
            AppMethodBeat.o(45957);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(45958);
            final vc vcVar = (vc) bVar;
            ab.i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", Integer.valueOf(vcVar.cRZ.result));
            uq uqVar = new uq();
            if (vcVar.cRZ.result == -1) {
                uqVar.cQP.scene = 17;
            } else if (vcVar.cRZ.result == 0) {
                uqVar.cQP.scene = 18;
            } else {
                uqVar.cQP.scene = 0;
            }
            uqVar.cQQ.cQH = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(45956);
                    if (-1 == vcVar.cRZ.result) {
                        WalletChangeBankcardUI.a(WalletChangeBankcardUI.this);
                    }
                    AppMethodBeat.o(45956);
                }
            };
            com.tencent.mm.sdk.b.a.xxA.m(uqVar);
            AppMethodBeat.o(45958);
            return false;
        }
    };
    protected PayInfo pVL = null;
    protected Orders pWy = null;
    public ArrayList<Bankcard> tgB;
    protected Bankcard tgC = null;
    protected Authen tms = null;
    protected ListView toC;
    public q toD;
    protected int toE;
    public i toF = null;
    protected String toG = null;
    public FavorPayInfo toH;
    private a toI;
    d toJ = null;
    private boolean toK = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletChangeBankcardUI() {
        AppMethodBeat.i(45965);
        AppMethodBeat.o(45965);
    }

    static /* synthetic */ void a(WalletChangeBankcardUI walletChangeBankcardUI) {
        AppMethodBeat.i(45986);
        walletChangeBankcardUI.cNN();
        AppMethodBeat.o(45986);
    }

    private void cNN() {
        AppMethodBeat.i(45966);
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        if (aE != null) {
            aE.c((Activity) this, 1);
        } else {
            finish();
        }
        vd vdVar = new vd();
        vdVar.cSa.result = -1;
        com.tencent.mm.sdk.b.a.xxA.m(vdVar);
        AppMethodBeat.o(45966);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45967);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == toB) {
            cNN();
        }
        AppMethodBeat.o(45967);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45968);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ft4);
        Bundle bundle2 = this.mBundle;
        bundle2.putInt("key_err_code", 0);
        this.toE = bundle2.getInt("key_support_bankcard", 1);
        this.tms = (Authen) bundle2.getParcelable("key_authen");
        this.pWy = (Orders) bundle2.getParcelable("key_orders");
        this.pVL = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.toH = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.cIf = this.pVL == null ? 0 : this.pVL.cIf;
        ab.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", Integer.valueOf(this.cIf));
        if (this.mBundle.getBoolean("key_is_filter_bank_type")) {
            mW(true);
        } else {
            this.tgB = cNO();
        }
        if (!(this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
            this.toG = getString(R.string.fcy, new Object[]{e.e(this.pWy.pTN, this.pWy.pcl), ((Commodity) this.pWy.tAq.get(0)).desc});
        }
        initView();
        z.hL(7, 0);
        com.tencent.mm.sdk.b.a.xxA.c(this.pUc);
        if (this.mBundle.getBoolean("key_is_filter_bank_type") && this.toF != null) {
            this.toF.tGM = false;
        }
        AppMethodBeat.o(45968);
    }

    private ArrayList<Bankcard> cNO() {
        AppMethodBeat.i(45969);
        if (this.cIf == 8) {
            ArrayList ne = ac.ne(true);
            AppMethodBeat.o(45969);
            return ne;
        }
        ArrayList<Bankcard> ne2 = ac.ne(false);
        AppMethodBeat.o(45969);
        return ne2;
    }

    public void onDestroy() {
        AppMethodBeat.i(45970);
        if (this.toI != null) {
            this.toI.cNM();
            this.toI.release();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.pUc);
        this.toJ = null;
        super.onDestroy();
        AppMethodBeat.o(45970);
    }

    public final void initView() {
        AppMethodBeat.i(45971);
        this.pTi = (Button) findViewById(R.id.f9q);
        this.pTi.setEnabled(false);
        this.pTi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45960);
                WalletChangeBankcardUI.this.cNQ();
                AppMethodBeat.o(45960);
            }
        });
        if (bo.isNullOrNil(this.mBundle.getString("key_pwd1"))) {
            this.pTi.setText(R.string.s6);
        } else {
            this.pTi.setText(R.string.fq2);
        }
        this.toC = (ListView) findViewById(R.id.f5f);
        this.toF = cNP();
        this.toC.setAdapter(this.toF);
        this.toC.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(45961);
                WalletChangeBankcardUI.this.Hf(i);
                AppMethodBeat.o(45961);
            }
        });
        cu();
        AppMethodBeat.o(45971);
    }

    /* Access modifiers changed, original: protected */
    public i cNP() {
        AppMethodBeat.i(45972);
        i iVar = new i(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.o(45972);
        return iVar;
    }

    public final void cu() {
        AppMethodBeat.i(45973);
        this.klD = (TextView) findViewById(R.id.f55);
        if (this.toH != null && !bo.isNullOrNil(this.toH.tzf)) {
            this.klD.setVisibility(0);
            this.klD.setText(this.toH.tzf);
            AppMethodBeat.o(45973);
        } else if (this.mBundle.getInt("key_main_bankcard_state", 0) != 0) {
            this.klD.setVisibility(0);
            this.klD.setText(this.toG);
            AppMethodBeat.o(45973);
        } else {
            this.klD.setVisibility(8);
            AppMethodBeat.o(45973);
        }
    }

    /* Access modifiers changed, original: protected */
    public void Hf(int i) {
        int i2 = 0;
        AppMethodBeat.i(45974);
        int size = this.tgB != null ? this.tgB.size() : 0;
        ab.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", Integer.valueOf(i), Integer.valueOf(size));
        if (this.tgB == null || i >= size) {
            if (size == i) {
                g cPl = g.cPl();
                if (cPl.aFF()) {
                    h.b((Context) this, cPl.pbp, getString(R.string.tz), true);
                    AppMethodBeat.o(45974);
                    return;
                }
                String str;
                if (this.pVL != null) {
                    i2 = this.pVL.cIf;
                }
                if (this.pVL == null) {
                    str = "";
                } else {
                    str = this.pVL.czZ;
                }
                ad.e(i2, str, 14, "");
                this.mBundle.putInt("key_err_code", VError.ERROR_DETECTOR_INSTANCE_INIT);
                this.mBundle.putBoolean("key_has_click_bind_new_card", true);
                com.tencent.mm.wallet_core.a.j(this, this.mBundle);
            }
            AppMethodBeat.o(45974);
            return;
        }
        Bankcard bankcard = (Bankcard) this.tgB.get(i);
        this.tgC = bankcard;
        if (this.pVL != null) {
            i2 = this.pVL.cIf;
        }
        ad.e(i2, this.pVL == null ? "" : this.pVL.czZ, 13, this.tgC.field_bindSerial);
        this.toF.tGL = bankcard.field_bindSerial;
        this.pTi.setEnabled(true);
        this.toF.notifyDataSetChanged();
        cNQ();
        AppMethodBeat.o(45974);
    }

    public final boolean bwP() {
        AppMethodBeat.i(45976);
        if (super.bwP()) {
            AppMethodBeat.o(45976);
            return true;
        } else if (this.pVL == null || !this.pVL.mXg) {
            AppMethodBeat.o(45976);
            return false;
        } else if (this.pVL.mXg) {
            AppMethodBeat.o(45976);
            return true;
        } else {
            s.cNC();
            if (s.cND().cQg()) {
                AppMethodBeat.o(45976);
                return false;
            }
            AppMethodBeat.o(45976);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.b3q;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean onKeyUp;
        int i2 = 0;
        AppMethodBeat.i(45977);
        if (i == 4 && this.toH != null && this.tgB.size() == 0) {
            int i3;
            FavorPayInfo favorPayInfo = this.toH;
            if (favorPayInfo == null || favorPayInfo.tzc == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                ab.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.mBundle.getString("key_is_cur_bankcard_bind_serial");
                if (bo.isNullOrNil(string)) {
                    ab.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    onKeyUp = super.onKeyUp(i, keyEvent);
                    AppMethodBeat.o(45977);
                    return onKeyUp;
                }
                ArrayList cNO = cNO();
                if (cNO != null && this.tgC == null) {
                    while (true) {
                        i3 = i2;
                        if (i3 >= cNO.size()) {
                            break;
                        } else if (string.equals(((Bankcard) cNO.get(i3)).field_bindSerial)) {
                            ab.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(string)));
                            this.tgC = (Bankcard) cNO.get(i3);
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                    if (this.tgC == null) {
                        ab.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        onKeyUp = super.onKeyUp(i, keyEvent);
                        AppMethodBeat.o(45977);
                        return onKeyUp;
                    }
                }
                cNQ();
                AppMethodBeat.o(45977);
                return true;
            }
        }
        onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45977);
        return onKeyUp;
    }

    public boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(45978);
        Bundle bundle;
        if (i != 0 || i2 != 0) {
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            this.mBundle.putBoolean("key_need_verify_sms", false);
            ((l) com.tencent.mm.kernel.g.K(l.class)).a(this.tms.pGr.tKd == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.pVL.vwi = i2;
                    cNQ();
                    AppMethodBeat.o(45978);
                    return true;
                case 100100:
                case 100101:
                    this.pVL.vwi = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.toI == null) {
                        this.toI = new a(this, this);
                    }
                    this.toI.a(z, this.pVL.cBS, this.pVL.czZ);
                    ab.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z)));
                    AppMethodBeat.o(45978);
                    return true;
            }
        } else if (mVar instanceof f) {
            AppMethodBeat.o(45978);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            boolean z2;
            int i3;
            Bundle bundle2 = this.mBundle;
            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
            if (!bo.isNullOrNil(this.gHr)) {
                bundle2.putString("key_pwd1", this.gHr);
            }
            bundle2.putString("kreq_token", bVar.token);
            bundle2.putParcelable("key_authen", bVar.toh);
            bundle2.putBoolean("key_need_verify_sms", !bVar.tof);
            bundle2.putParcelable("key_pay_info", this.pVL);
            bundle2.putInt("key_pay_flag", 3);
            bundle2.putInt("key_can_verify_tail", bVar.tol);
            bundle2.putString("key_verify_tail_wording", bVar.tom);
            RealnameGuideHelper realnameGuideHelper = bVar.oYc;
            Bundle bundle3 = this.mBundle;
            String str2 = "key_block_bind_new_card";
            if (bVar.ton == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bundle3.putBoolean(str2, z2);
            if (bo.isNullOrNil(bVar.toi)) {
                bundle2.putString("key_mobile", this.tgC.field_mobile);
            } else {
                bundle2.putString("key_mobile", bVar.toi);
            }
            bundle2.putString("key_QADNA_URL", bVar.toj);
            if (realnameGuideHelper != null) {
                bundle2.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            l lVar = (l) com.tencent.mm.kernel.g.K(l.class);
            if (lVar.bxe()) {
                i3 = 1;
            } else if (lVar.bxh()) {
                i3 = 2;
            }
            bundle.putInt("key_open_biometric_type", i3);
            lVar.a(bVar.cNJ(), true, bundle);
            if (bVar.tpw) {
                bundle2.putParcelable("key_orders", bVar.tog);
                if (this.pVL != null && this.pVL.cIf == 8) {
                    ut utVar = new ut();
                    utVar.cRA.cRB = this.tms.pbo;
                    com.tencent.mm.sdk.b.a.xxA.m(utVar);
                }
            }
            com.tencent.mm.wallet_core.a.j(this, bundle2);
            AppMethodBeat.o(45978);
            return true;
        }
        AppMethodBeat.o(45978);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cNQ() {
        AppMethodBeat.i(45979);
        ab.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        this.mBundle.getString("key_pwd1");
        this.toK = false;
        AM(4);
        this.toD = q.a((Context) this, this.pWy, this.toH, this.tgC, this.pVL, new q.c() {
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                AppMethodBeat.i(45962);
                if (WalletChangeBankcardUI.this.toK) {
                    ab.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
                    com.tencent.mm.plugin.report.service.h.pYm.k(965, 3, 1);
                    AppMethodBeat.o(45962);
                    return;
                }
                WalletChangeBankcardUI.this.toH = favorPayInfo;
                WalletChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.toH);
                if (WalletChangeBankcardUI.this.toH == null || !z) {
                    WalletChangeBankcardUI.this.gHr = str;
                    WalletChangeBankcardUI.this.aqX();
                    WalletChangeBankcardUI.this.acs(str);
                    WalletChangeBankcardUI.this.toJ = null;
                    AppMethodBeat.o(45962);
                    return;
                }
                if (WalletChangeBankcardUI.this.toH != null) {
                    WalletChangeBankcardUI.this.mW(true);
                    WalletChangeBankcardUI.this.toF.f(WalletChangeBankcardUI.this.tgB, false);
                }
                if (WalletChangeBankcardUI.this.toD != null) {
                    WalletChangeBankcardUI.this.toD.dismiss();
                }
                WalletChangeBankcardUI.this.cu();
                WalletChangeBankcardUI.this.AM(0);
                AppMethodBeat.o(45962);
            }
        }, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45963);
                if (WalletChangeBankcardUI.this.toD != null) {
                    WalletChangeBankcardUI.this.toD.dismiss();
                }
                WalletChangeBankcardUI.this.mW(false);
                WalletChangeBankcardUI.this.toF.f(WalletChangeBankcardUI.this.tgB, true);
                WalletChangeBankcardUI.this.toH = (FavorPayInfo) view.getTag();
                if (WalletChangeBankcardUI.this.toH != null) {
                    WalletChangeBankcardUI.this.toH.tzf = "";
                }
                WalletChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.toH);
                WalletChangeBankcardUI.this.cu();
                WalletChangeBankcardUI.this.AM(0);
                WalletChangeBankcardUI.this.toJ = null;
                AppMethodBeat.o(45963);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(45964);
                ab.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", bo.dpG().toString());
                WalletChangeBankcardUI.this.toK = true;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                WalletChangeBankcardUI.this.gHr = null;
                if (WalletChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                    WalletChangeBankcardUI.this.bwW();
                }
                WalletChangeBankcardUI.this.toJ = null;
                AppMethodBeat.o(45964);
            }
        });
        this.toJ = this.toD;
        AppMethodBeat.o(45979);
    }

    /* Access modifiers changed, original: protected */
    public void acs(String str) {
        AppMethodBeat.i(45980);
        this.tms.twc = str;
        boolean z = this.mBundle.getBoolean("key_has_click_bind_new_card", false);
        int i = this.mBundle.getInt("key_pay_flag");
        if (z && i == 3) {
            ab.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
            this.tms.bJt = 3;
        }
        if (this.tgC != null) {
            this.mBundle.putString("key_mobile", this.tgC.field_mobile);
            this.mBundle.putParcelable("key_bankcard", this.tgC);
            this.tms.pbo = this.tgC.field_bindSerial;
            this.tms.pbn = this.tgC.field_bankcardType;
            if (this.toH != null) {
                this.tms.two = this.toH.tzb;
            } else {
                this.tms.two = null;
            }
            if (this.pWy.tAr != null) {
                this.tms.twn = this.pWy.tAr.tmU;
            }
            if (this.pWy != null && this.pWy.tuo == 3) {
                if (this.tgC.cPf()) {
                    this.tms.bJt = 3;
                } else {
                    this.tms.bJt = 6;
                }
                Bundle bundle = this.mBundle;
                String str2 = "key_is_oversea";
                if (this.tgC.cPf()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.mBundle.putString("key_pwd1", str);
        this.mBundle.putParcelable("key_authen", this.tms);
        m a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.tms, this.pWy, false);
        if (a != null) {
            a.eHT = "PayProcess";
            a.mBundle = this.mBundle;
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                a.gOW = 100;
            } else {
                a.gOW = this.pVL.cIf;
            }
            a(a, true, true);
        }
        AppMethodBeat.o(45980);
    }

    public final boolean cNR() {
        return true;
    }

    public final void wU(int i) {
        AppMethodBeat.i(45981);
        if (i == 0) {
            bwW();
            AppMethodBeat.o(45981);
        } else if (i == 1) {
            this.mBundle.putString("key_pwd1", "");
            cNQ();
            AppMethodBeat.o(45981);
        } else {
            ab.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
            AppMethodBeat.o(45981);
        }
    }

    public final void bwW() {
        AppMethodBeat.i(45982);
        dOy();
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        if (aE != null) {
            aE.b(this, this.mBundle);
            AppMethodBeat.o(45982);
            return;
        }
        finish();
        AppMethodBeat.o(45982);
    }

    public int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected|final */
    public final void mW(boolean z) {
        int i = 0;
        AppMethodBeat.i(45983);
        this.tgB = cNO();
        if (this.toH != null) {
            int i2;
            if (this.toH.tzc != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0 && z) {
                String str = this.toH.tzd;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    i2 = i;
                    if (i2 < this.tgB.size()) {
                        Bankcard bankcard = (Bankcard) this.tgB.get(i2);
                        if (bo.isNullOrNil(str)) {
                            if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                                arrayList.add(bankcard);
                            }
                        } else if (bankcard.field_bankcardType.equals(str)) {
                            arrayList.add(bankcard);
                        }
                        i = i2 + 1;
                    } else {
                        this.tgB = arrayList;
                        AppMethodBeat.o(45983);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(45983);
    }

    public final boolean bwQ() {
        return true;
    }

    public final void c(boolean z, String str, String str2) {
        AppMethodBeat.i(45984);
        ab.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            ab.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.pVL.cBU = str;
            this.pVL.cBV = str2;
            acs(this.gHr);
            AppMethodBeat.o(45984);
            return;
        }
        ab.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        acs(this.gHr);
        AppMethodBeat.o(45984);
    }

    public void onPause() {
        AppMethodBeat.i(45985);
        super.onPause();
        if (this.toJ != null) {
            this.toJ.onActivityPause();
        }
        AppMethodBeat.o(45985);
    }

    public void onResume() {
        AppMethodBeat.i(45975);
        this.mBundle.putInt("key_err_code", 0);
        super.onResume();
        if (this.toJ != null) {
            this.toJ.cRm();
        }
        AppMethodBeat.o(45975);
    }
}
