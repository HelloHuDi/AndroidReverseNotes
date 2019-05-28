package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class WalletSecuritySettingUI extends MMPreference implements com.tencent.mm.ai.f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private int emC = 0;
    private Map<String, com.tencent.mm.at.p.a> tqO = new HashMap();
    private boolean tsF = true;
    private WalletSecuritySettingHeaderPref tsG;
    private IconPreference tsH;
    private IconPreference tsI;
    private IconPreference tsJ;
    private IconPreference tsK;
    private IconPreference tsL;
    private Preference tsM;
    private b tsN;
    private g tsO;
    private f tsP;
    private c tsQ;
    private a tsR;
    private ProgressDialog tsS;

    class a {
        String cIY;
        String desc;
        int switchState;
        String title;
        String tsW;

        private a() {
        }

        /* synthetic */ a(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    class g {
        String desc;
        String oRi;
        int status;
        String title;
        String ttl;
        boolean ttm;

        private g() {
        }

        /* synthetic */ g(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    class b {
        String desc;
        int jumpType;
        String oRi;
        String title;
        String tsX;
        String tsY;
        String tsZ;

        private b() {
        }

        /* synthetic */ b(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    static class d {
        String kdE;
        int ttd;
        String tte;
        String ttf;
        String ttg;

        private d() {
        }

        public static d ao(JSONObject jSONObject) {
            AppMethodBeat.i(46403);
            if (jSONObject == null) {
                AppMethodBeat.o(46403);
                return null;
            }
            d dVar = new d();
            dVar.kdE = jSONObject.optString("button_wording");
            dVar.ttd = jSONObject.optInt("jump_type");
            dVar.tte = jSONObject.optString("jump_h5_url");
            dVar.ttf = jSONObject.optString("tinyapp_name");
            dVar.ttg = jSONObject.optString("tinyapp_path");
            AppMethodBeat.o(46403);
            return dVar;
        }
    }

    static class e {
        String cEh;
        String pia;
        String title;
        d tth;
        d tti;

        e() {
        }
    }

    class f {
        String desc;
        int jumpType;
        String oRi;
        int status;
        String title;
        String tsX;
        String tsY;
        String ttj;
        String ttk;

        private f() {
        }

        /* synthetic */ f(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    class c {
        String desc;
        String oRi;
        int status;
        String title;
        String tsX;
        String tta;
        String ttb;
        String ttc;

        c(Context context) {
            AppMethodBeat.i(46400);
            if (!p.u(context, "com.tencent.qqpimsecure")) {
                this.status = 0;
                AppMethodBeat.o(46400);
            } else if (bo.bH(context, "com.tencent.server.back.BackEngine")) {
                this.status = 2;
                AppMethodBeat.o(46400);
            } else {
                this.status = 1;
                AppMethodBeat.o(46400);
            }
        }

        public final String getUrl() {
            AppMethodBeat.i(46401);
            String gL;
            if (this.status == 0) {
                gL = gL("qqpimsecurestatus", "not_installed");
                AppMethodBeat.o(46401);
                return gL;
            } else if (this.status == 1) {
                gL = gL("qqpimsecurestatus", "not_run");
                AppMethodBeat.o(46401);
                return gL;
            } else {
                gL = gL("qqpimsecurestatus", "runing");
                AppMethodBeat.o(46401);
                return gL;
            }
        }

        private String gL(String str, String str2) {
            AppMethodBeat.i(46402);
            String uri = Uri.parse(this.tsX).buildUpon().appendQueryParameter(str, str2).build().toString();
            AppMethodBeat.o(46402);
            return uri;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletSecuritySettingUI() {
        AppMethodBeat.i(46404);
        AppMethodBeat.o(46404);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46405);
        super.onCreate(bundle);
        this.emC = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        bj bjVar = new bj();
        bjVar.cVT = 11;
        bjVar.dcm = 1;
        bjVar.dcn = (long) this.emC;
        bjVar.ajK();
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46393);
                WalletSecuritySettingUI.this.finish();
                AppMethodBeat.o(46393);
                return false;
            }
        });
        if (com.tencent.mm.compatible.util.d.iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.a69));
            dxW();
        }
        AppMethodBeat.o(46405);
    }

    public final int JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(46406);
        super.initView();
        this.ehK = this.yCw;
        if (this.ehK != null) {
            this.ehK.addPreferencesFromResource(R.xml.cv);
        }
        com.tencent.mm.kernel.g.RQ();
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, (Object) "");
        if (!bo.isNullOrNil(str)) {
            try {
                an(new JSONObject(str));
                AppMethodBeat.o(46406);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(46406);
    }

    public void onResume() {
        String string;
        String string2;
        AppMethodBeat.i(46407);
        super.onResume();
        this.tsG = (WalletSecuritySettingHeaderPref) this.ehK.aqO("wallet_security_basic_info");
        if (this.tsG != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.tsG;
            AnonymousClass2 anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46394);
                    if (WalletSecuritySettingUI.this.tsN != null && bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsX)) {
                        ab.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                        AppMethodBeat.o(46394);
                    } else if (WalletSecuritySettingUI.this.tsN == null || WalletSecuritySettingUI.this.tsN.jumpType != 1 || bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsX)) {
                        if (WalletSecuritySettingUI.this.tsN != null && WalletSecuritySettingUI.this.tsN.jumpType == 2) {
                            bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsY);
                        }
                        AppMethodBeat.o(46394);
                    } else {
                        Intent intent = new Intent();
                        ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", WalletSecuritySettingUI.this.tsN.tsX);
                        intent.putExtra("rawUrl", WalletSecuritySettingUI.this.tsN.tsX);
                        com.tencent.mm.bp.d.b(WalletSecuritySettingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(46394);
                    }
                }
            };
            String str = "MicroMsg.WalletSecuritySettingHeaderPref";
            String str2 = "alvinluo details == null: %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.tsA == null);
            ab.v(str, str2, objArr);
            walletSecuritySettingHeaderPref.tsD = anonymousClass2;
            if (walletSecuritySettingHeaderPref.tsA != null) {
                walletSecuritySettingHeaderPref.tsA.setOnClickListener(anonymousClass2);
            }
            walletSecuritySettingHeaderPref = this.tsG;
            AnonymousClass3 anonymousClass3 = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46395);
                    ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
                    WalletSecuritySettingUI.this.finish();
                    AppMethodBeat.o(46395);
                }
            };
            str = "MicroMsg.WalletSecuritySettingHeaderPref";
            str2 = "alvinluo closeBtn == null: %b";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.rnN == null);
            ab.v(str, str2, objArr);
            walletSecuritySettingHeaderPref.tsE = anonymousClass3;
            if (walletSecuritySettingHeaderPref.rnN != null) {
                walletSecuritySettingHeaderPref.rnN.setOnClickListener(anonymousClass3);
            }
        }
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(385, (com.tencent.mm.ai.f) this);
        if (this.tsF) {
            this.tsS = h.b((Context) this, getString(R.string.un), false, null);
            this.tsF = false;
        }
        boolean bxe = ((l) com.tencent.mm.kernel.g.K(l.class)).bxe();
        SharedPreferences doB = ah.doB();
        if (doB != null) {
            string = doB.getString("cpu_id", null);
            string2 = doB.getString("uid", null);
        } else {
            string2 = null;
            string = null;
        }
        ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(bxe));
        com.tencent.mm.kernel.g.Rg().a(new k(bxe, string, string2), 0);
        AppMethodBeat.o(46407);
    }

    public void onPause() {
        AppMethodBeat.i(46408);
        super.onPause();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(385, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(46408);
    }

    private void cOJ() {
        AppMethodBeat.i(46409);
        this.tsG = (WalletSecuritySettingHeaderPref) this.ehK.aqO("wallet_security_basic_info");
        if (this.tsN != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.tsG;
            String str = this.tsN.title;
            String str2 = this.tsN.desc;
            String str3 = this.tsN.tsZ;
            walletSecuritySettingHeaderPref.lYc = str;
            walletSecuritySettingHeaderPref.tsB = str2;
            walletSecuritySettingHeaderPref.tsC = str3;
            walletSecuritySettingHeaderPref.cu();
            if (bo.isNullOrNil(this.tsN.tsZ)) {
                walletSecuritySettingHeaderPref = this.tsG;
                if (walletSecuritySettingHeaderPref.tsA != null) {
                    walletSecuritySettingHeaderPref.tsA.setVisibility(8);
                }
            }
        }
        AppMethodBeat.o(46409);
    }

    private void cOK() {
        AppMethodBeat.i(46410);
        if (this.tsR == null) {
            this.ehK.ce("balance_privacy_info", true);
            AppMethodBeat.o(46410);
            return;
        }
        this.ehK.ce("balance_privacy_info", false);
        this.tsL = (IconPreference) this.ehK.aqO("balance_privacy_info");
        a(this.tsR.cIY, this.tsL);
        this.tsL.setTitle((CharSequence) this.tsR.title);
        this.tsL.setSummary((CharSequence) this.tsR.tsW);
        this.tsL.setDesc(this.tsR.desc);
        this.tsL.dAy();
        AppMethodBeat.o(46410);
    }

    private void cOL() {
        AppMethodBeat.i(46411);
        if (this.tsO == null) {
            this.ehK.ce("wallet_security_wallet_lock", true);
            AppMethodBeat.o(46411);
            return;
        }
        this.ehK.ce("wallet_security_wallet_lock", false);
        this.tsJ = (IconPreference) this.ehK.aqO("wallet_security_wallet_lock");
        a(this.tsO.oRi, this.tsJ);
        this.tsJ.setTitle((CharSequence) this.tsO.title);
        this.tsJ.setSummary((CharSequence) this.tsO.ttl);
        this.tsJ.setDesc(this.tsO.desc);
        this.tsJ.dAy();
        AppMethodBeat.o(46411);
    }

    private void cOM() {
        boolean z;
        AppMethodBeat.i(46412);
        this.ehK.ce("wallet_security_digital_certificate", false);
        this.tsH = (IconPreference) this.ehK.aqO("wallet_security_digital_certificate");
        com.tencent.mm.wallet_core.c.ab.dNZ();
        com.tencent.mm.kernel.g.RQ();
        if (((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(0))).intValue() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (com.tencent.mm.wallet_core.c.ab.dNZ().dOa()) {
                if (this.tsH != null) {
                    this.tsH.setSummary((int) R.string.fsf);
                }
            } else if (this.tsH != null) {
                this.tsH.setSummary((int) R.string.fsh);
            }
            a(com.tencent.mm.wallet_core.c.ab.dNZ().Age, this.tsH);
            this.tsH.setTitle((CharSequence) com.tencent.mm.wallet_core.c.ab.dNZ().Agc);
            this.tsH.setSummary((CharSequence) com.tencent.mm.wallet_core.c.ab.dNZ().Agd);
            this.tsH.setDesc(com.tencent.mm.wallet_core.c.ab.dNZ().Agb);
            this.tsH.dAy();
            AppMethodBeat.o(46412);
            return;
        }
        this.ehK.ce("wallet_security_digital_certificate", true);
        AppMethodBeat.o(46412);
    }

    private void cON() {
        AppMethodBeat.i(46413);
        this.ehK.ce("wallet_security_pay_guard", false);
        this.tsI = (IconPreference) this.ehK.aqO("wallet_security_pay_guard");
        if (this.tsI != null) {
            this.tsI.setSummary((int) R.string.fsh);
        }
        if (this.tsQ == null) {
            this.ehK.ce("wallet_security_pay_guard", true);
            AppMethodBeat.o(46413);
            return;
        }
        CharSequence charSequence;
        a(this.tsQ.oRi, this.tsI);
        this.tsI.setTitle((CharSequence) this.tsQ.title);
        IconPreference iconPreference = this.tsI;
        c cVar = this.tsQ;
        if (cVar.status == 0) {
            charSequence = cVar.tta;
        } else if (cVar.status == 1) {
            charSequence = cVar.ttb;
        } else {
            charSequence = cVar.ttc;
        }
        iconPreference.setSummary(charSequence);
        this.tsI.setDesc(this.tsQ.desc);
        this.tsI.dAy();
        AppMethodBeat.o(46413);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(46415);
        if ("wallet_security_digital_certificate".equals(preference.mKey)) {
            bj bjVar = new bj();
            bjVar.cVT = 12;
            bjVar.dcm = 1;
            bjVar.ajK();
            com.tencent.mm.bp.d.b((Context) this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            AppMethodBeat.o(46415);
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.mKey)) {
            if (this.tsQ == null) {
                AppMethodBeat.o(46415);
                return true;
            }
            ab.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", this.tsQ.getUrl());
            com.tencent.mm.wallet_core.ui.e.bV(this, this.tsQ.getUrl());
            AppMethodBeat.o(46415);
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).b(this, new Intent());
            AppMethodBeat.o(46415);
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.mKey)) {
            if ("balance_privacy_info".equals(preference.mKey)) {
                if (this.tsR == null) {
                    AppMethodBeat.o(46415);
                    return true;
                }
                com.tencent.mm.bp.d.H(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
            }
            AppMethodBeat.o(46415);
            return false;
        } else if (this.tsP == null) {
            AppMethodBeat.o(46415);
            return true;
        } else {
            bj bjVar2 = new bj();
            bjVar2.cVT = 15;
            bjVar2.dcm = 1;
            bjVar2.ajK();
            if (this.tsP.jumpType == 2) {
                se seVar = new se();
                seVar.cOf.axy = 0;
                seVar.cOf.userName = this.tsP.ttk;
                seVar.cOf.cOh = this.tsP.tsY;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.tsP.tsX);
                ab.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", intent.getStringExtra("rawUrl"));
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.o(46415);
            return true;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46416);
        ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof k) {
            JSONObject jSONObject = ((k) mVar).tqH;
            ab.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", jSONObject);
            an(jSONObject);
            if (!(jSONObject == null || ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.FALSE)).booleanValue())) {
                e eVar;
                jSONObject = jSONObject.optJSONObject("dialog_info");
                if (jSONObject == null) {
                    eVar = null;
                } else {
                    e eVar2 = new e();
                    eVar2.title = jSONObject.optString("title");
                    eVar2.cEh = jSONObject.optString("wording");
                    eVar2.pia = jSONObject.optString("logo");
                    eVar2.tth = d.ao(jSONObject.optJSONObject("left_btn"));
                    eVar2.tti = d.ao(jSONObject.optJSONObject("right_btn"));
                    eVar = eVar2;
                }
                if (eVar != null) {
                    com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                    View inflate = LayoutInflater.from(this).inflate(R.layout.b6b, null, false);
                    TextView textView = (TextView) inflate.findViewById(R.id.fhh);
                    ((CdnImageView) inflate.findViewById(R.id.fhg)).eb(eVar.pia, R.drawable.blk);
                    textView.setText(eVar.cEh);
                    aVar.rd(true);
                    aVar.rc(false);
                    aVar.fn(inflate);
                    aVar.asD(eVar.title);
                    if (!(eVar.tti == null || bo.isNullOrNil(eVar.tti.kdE))) {
                        aVar.asJ(eVar.tti.kdE);
                        aVar.a(true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(46396);
                                if (eVar.tti.ttd == 1) {
                                    com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.mController.ylL, eVar.tti.tte, true);
                                    AppMethodBeat.o(46396);
                                    return;
                                }
                                if (eVar.tti.ttd == 2) {
                                    com.tencent.mm.wallet_core.ui.e.p(eVar.tti.ttf, eVar.tti.ttg, 0, 1000);
                                }
                                AppMethodBeat.o(46396);
                            }
                        });
                    }
                    if (!(eVar.tth == null || bo.isNullOrNil(eVar.tth.kdE))) {
                        aVar.asK(eVar.tth.kdE);
                        aVar.b(new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(46397);
                                if (eVar.tth.ttd == 1) {
                                    com.tencent.mm.wallet_core.ui.e.n(WalletSecuritySettingUI.this.mController.ylL, eVar.tth.tte, true);
                                    AppMethodBeat.o(46397);
                                } else if (eVar.tth.ttd == 2) {
                                    com.tencent.mm.wallet_core.ui.e.p(eVar.tth.ttf, eVar.tth.ttg, 0, 1000);
                                    AppMethodBeat.o(46397);
                                } else {
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(46397);
                                }
                            }
                        });
                    }
                    aVar.aMb().show();
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.TRUE);
                }
            }
        }
        AppMethodBeat.o(46416);
    }

    private void onError(String str) {
        AppMethodBeat.i(46417);
        if (this.tsS != null && this.tsS.isShowing()) {
            this.tsS.dismiss();
        }
        h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(46398);
                WalletSecuritySettingUI.this.finish();
                AppMethodBeat.o(46398);
            }
        });
        AppMethodBeat.o(46417);
    }

    private void an(JSONObject jSONObject) {
        AppMethodBeat.i(46418);
        if (jSONObject == null) {
            ab.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(R.string.fs6));
            AppMethodBeat.o(46418);
            return;
        }
        try {
            JSONObject jSONObject2;
            this.ehK = this.yCw;
            CharSequence string = jSONObject.getString("more_security_title");
            this.tsM = this.ehK.aqO("wallet_security_more_title");
            this.tsM.setTitle(string);
            if (jSONObject.has("basic_security_item")) {
                jSONObject2 = jSONObject.getJSONObject("basic_security_item");
                this.tsN = new b(this, (byte) 0);
                this.tsN.title = jSONObject2.optString("title");
                this.tsN.desc = jSONObject2.optString("desc");
                this.tsN.oRi = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                jSONObject2 = jSONObject.getJSONObject("wallet_lock_info");
                this.tsO = new g(this, (byte) 0);
                this.tsO.title = jSONObject2.optString("wallet_lock_title");
                this.tsO.desc = jSONObject2.optString("wallet_lock_desc");
                this.tsO.oRi = jSONObject2.getString("wallet_lock_logo_url");
                this.tsO.status = jSONObject2.optInt("wallet_lock_status");
                this.tsO.ttl = jSONObject2.optString("wallet_lock_status_name");
                this.tsO.ttm = jSONObject2.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                jSONObject2 = jSONObject.getJSONObject("property_security_info");
                this.tsP = new f(this, (byte) 0);
                this.tsP.title = jSONObject2.optString("title", "");
                this.tsP.desc = jSONObject2.optString("desc", "");
                this.tsP.oRi = jSONObject2.optString("logo_url", "");
                this.tsP.status = jSONObject2.optInt("status", 0);
                this.tsP.ttj = jSONObject2.optString("status_name");
                this.tsP.jumpType = jSONObject2.optInt("jump_type");
                this.tsP.tsX = jSONObject2.optString("jump_h5_url");
                this.tsP.ttk = jSONObject2.optString("tinyapp_username");
                this.tsP.tsY = jSONObject2.optString("tinyapp_path");
            }
            if (jSONObject.has("safe_manager_info")) {
                jSONObject2 = jSONObject.getJSONObject("safe_manager_info");
                this.tsQ = new c(this);
                this.tsQ.title = jSONObject2.optString("title", "");
                this.tsQ.desc = jSONObject2.optString("desc", "");
                this.tsQ.oRi = jSONObject2.optString("logo_url", "");
                this.tsQ.ttb = jSONObject2.optString("installed_status_name");
                this.tsQ.tta = jSONObject2.optString("uninstall_status_name");
                this.tsQ.ttc = jSONObject2.optString("protected_mode_name");
                this.tsQ.tsX = jSONObject2.optString("jump_h5_url");
            }
            if (jSONObject.has("balance_privacy_info")) {
                jSONObject2 = jSONObject.getJSONObject("balance_privacy_info");
                this.tsR = new a(this, (byte) 0);
                this.tsR.cIY = jSONObject2.optString("icon", "");
                this.tsR.title = jSONObject2.optString("title", "");
                this.tsR.desc = jSONObject2.optString("desc", "");
                this.tsR.switchState = jSONObject2.optInt("switch_state");
                this.tsR.tsW = jSONObject2.optString("switch_state_info");
            }
            com.tencent.mm.wallet_core.c.ab.dNZ().aT(jSONObject);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, jSONObject.toString());
            cOJ();
            cOL();
            cOM();
            cON();
            cOO();
            cOK();
            this.ehK.notifyDataSetChanged();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            onError(getString(R.string.fs6));
        }
        dismissDialog();
        AppMethodBeat.o(46418);
    }

    private void dismissDialog() {
        AppMethodBeat.i(46419);
        if (this.tsS != null && this.tsS.isShowing()) {
            this.tsS.dismiss();
        }
        AppMethodBeat.o(46419);
    }

    private void a(String str, final IconPreference iconPreference) {
        AppMethodBeat.i(46420);
        if (iconPreference == null) {
            AppMethodBeat.o(46420);
            return;
        }
        o.ahk();
        Bitmap kR = com.tencent.mm.at.c.kR(str);
        if (kR != null) {
            iconPreference.drawable = new BitmapDrawable(this.mController.ylL.getResources(), kR);
            AppMethodBeat.o(46420);
            return;
        }
        if (!bo.isNullOrNil(str)) {
            AnonymousClass7 anonymousClass7 = new com.tencent.mm.at.p.a() {
                public final void i(String str, Bitmap bitmap) {
                    AppMethodBeat.i(46399);
                    ab.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", str);
                    iconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.mController.ylL.getResources(), bitmap);
                    WalletSecuritySettingUI.this.tqO.remove(str);
                    AppMethodBeat.o(46399);
                }
            };
            this.tqO.put(str, anonymousClass7);
            o.aho().a(str, anonymousClass7);
        }
        AppMethodBeat.o(46420);
    }

    public void onDestroy() {
        AppMethodBeat.i(46421);
        for (Entry entry : this.tqO.entrySet()) {
            o.aho().b((String) entry.getKey(), (com.tencent.mm.at.p.a) entry.getValue());
        }
        this.tqO.clear();
        super.onDestroy();
        AppMethodBeat.o(46421);
    }

    private void cOO() {
        AppMethodBeat.i(46414);
        this.ehK = this.yCw;
        this.ehK.ce("wallet_security_safety_insurance", false);
        this.tsK = (IconPreference) this.ehK.aqO("wallet_security_safety_insurance");
        if (this.tsK != null) {
            this.tsK.setSummary((int) R.string.fsi);
        }
        if (this.tsP == null) {
            this.ehK.ce("wallet_security_safety_insurance", true);
            AppMethodBeat.o(46414);
            return;
        }
        a(this.tsP.oRi, this.tsK);
        this.tsK.setTitle((CharSequence) this.tsP.title);
        this.tsK.setSummary((CharSequence) this.tsP.ttj);
        this.tsK.setDesc(this.tsP.desc);
        this.tsK.dAy();
        AppMethodBeat.o(46414);
    }
}
