package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C46355k;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C46720ab;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI */
public class WalletSecuritySettingUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private int emC = 0;
    private Map<String, C32293a> tqO = new HashMap();
    private boolean tsF = true;
    private WalletSecuritySettingHeaderPref tsG;
    private IconPreference tsH;
    private IconPreference tsI;
    private IconPreference tsJ;
    private IconPreference tsK;
    private IconPreference tsL;
    private Preference tsM;
    private C43778b tsN;
    private C22554g tsO;
    private C43781f tsP;
    private C44778c tsQ;
    private C22553a tsR;
    private ProgressDialog tsS;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$6 */
    class C225526 implements OnClickListener {
        C225526() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46398);
            WalletSecuritySettingUI.this.finish();
            AppMethodBeat.m2505o(46398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$a */
    class C22553a {
        String cIY;
        String desc;
        int switchState;
        String title;
        String tsW;

        private C22553a() {
        }

        /* synthetic */ C22553a(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$g */
    class C22554g {
        String desc;
        String oRi;
        int status;
        String title;
        String ttl;
        boolean ttm;

        private C22554g() {
        }

        /* synthetic */ C22554g(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$3 */
    class C354683 implements View.OnClickListener {
        C354683() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46395);
            C4990ab.m7418v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
            WalletSecuritySettingUI.this.finish();
            AppMethodBeat.m2505o(46395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$2 */
    class C400862 implements View.OnClickListener {
        C400862() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46394);
            if (WalletSecuritySettingUI.this.tsN != null && C5046bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsX)) {
                C4990ab.m7412e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                AppMethodBeat.m2505o(46394);
            } else if (WalletSecuritySettingUI.this.tsN == null || WalletSecuritySettingUI.this.tsN.jumpType != 1 || C5046bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsX)) {
                if (WalletSecuritySettingUI.this.tsN != null && WalletSecuritySettingUI.this.tsN.jumpType == 2) {
                    C5046bo.isNullOrNil(WalletSecuritySettingUI.this.tsN.tsY);
                }
                AppMethodBeat.m2505o(46394);
            } else {
                Intent intent = new Intent();
                C4990ab.m7417i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", WalletSecuritySettingUI.this.tsN.tsX);
                intent.putExtra("rawUrl", WalletSecuritySettingUI.this.tsN.tsX);
                C25985d.m41467b(WalletSecuritySettingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(46394);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$b */
    class C43778b {
        String desc;
        int jumpType;
        String oRi;
        String title;
        String tsX;
        String tsY;
        String tsZ;

        private C43778b() {
        }

        /* synthetic */ C43778b(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$d */
    static class C43779d {
        String kdE;
        int ttd;
        String tte;
        String ttf;
        String ttg;

        private C43779d() {
        }

        /* renamed from: ao */
        public static C43779d m78465ao(JSONObject jSONObject) {
            AppMethodBeat.m2504i(46403);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(46403);
                return null;
            }
            C43779d c43779d = new C43779d();
            c43779d.kdE = jSONObject.optString("button_wording");
            c43779d.ttd = jSONObject.optInt("jump_type");
            c43779d.tte = jSONObject.optString("jump_h5_url");
            c43779d.ttf = jSONObject.optString("tinyapp_name");
            c43779d.ttg = jSONObject.optString("tinyapp_path");
            AppMethodBeat.m2505o(46403);
            return c43779d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$e */
    static class C43780e {
        String cEh;
        String pia;
        String title;
        C43779d tth;
        C43779d tti;

        C43780e() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$f */
    class C43781f {
        String desc;
        int jumpType;
        String oRi;
        int status;
        String title;
        String tsX;
        String tsY;
        String ttj;
        String ttk;

        private C43781f() {
        }

        /* synthetic */ C43781f(WalletSecuritySettingUI walletSecuritySettingUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$1 */
    class C447771 implements OnMenuItemClickListener {
        C447771() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46393);
            WalletSecuritySettingUI.this.finish();
            AppMethodBeat.m2505o(46393);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI$c */
    class C44778c {
        String desc;
        String oRi;
        int status;
        String title;
        String tsX;
        String tta;
        String ttb;
        String ttc;

        C44778c(Context context) {
            AppMethodBeat.m2504i(46400);
            if (!C35799p.m58695u(context, "com.tencent.qqpimsecure")) {
                this.status = 0;
                AppMethodBeat.m2505o(46400);
            } else if (C5046bo.m7528bH(context, "com.tencent.server.back.BackEngine")) {
                this.status = 2;
                AppMethodBeat.m2505o(46400);
            } else {
                this.status = 1;
                AppMethodBeat.m2505o(46400);
            }
        }

        public final String getUrl() {
            AppMethodBeat.m2504i(46401);
            String gL;
            if (this.status == 0) {
                gL = m81740gL("qqpimsecurestatus", "not_installed");
                AppMethodBeat.m2505o(46401);
                return gL;
            } else if (this.status == 1) {
                gL = m81740gL("qqpimsecurestatus", "not_run");
                AppMethodBeat.m2505o(46401);
                return gL;
            } else {
                gL = m81740gL("qqpimsecurestatus", "runing");
                AppMethodBeat.m2505o(46401);
                return gL;
            }
        }

        /* renamed from: gL */
        private String m81740gL(String str, String str2) {
            AppMethodBeat.m2504i(46402);
            String uri = Uri.parse(this.tsX).buildUpon().appendQueryParameter(str, str2).build().toString();
            AppMethodBeat.m2505o(46402);
            return uri;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletSecuritySettingUI() {
        AppMethodBeat.m2504i(46404);
        AppMethodBeat.m2505o(46404);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46405);
        super.onCreate(bundle);
        this.emC = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        C42088bj c42088bj = new C42088bj();
        c42088bj.cVT = 11;
        c42088bj.dcm = 1;
        c42088bj.dcn = (long) this.emC;
        c42088bj.ajK();
        initView();
        setBackBtn(new C447771());
        if (C1443d.m3068iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.a69));
            dxW();
        }
        AppMethodBeat.m2505o(46405);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(46406);
        super.initView();
        this.ehK = this.yCw;
        if (this.ehK != null) {
            this.ehK.addPreferencesFromResource(C25738R.xml.f8581cv);
        }
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, (Object) "");
        if (!C5046bo.isNullOrNil(str)) {
            try {
                m81736an(new JSONObject(str));
                AppMethodBeat.m2505o(46406);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(46406);
    }

    public void onResume() {
        String string;
        String string2;
        AppMethodBeat.m2504i(46407);
        super.onResume();
        this.tsG = (WalletSecuritySettingHeaderPref) this.ehK.aqO("wallet_security_basic_info");
        if (this.tsG != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.tsG;
            C400862 c400862 = new C400862();
            String str = "MicroMsg.WalletSecuritySettingHeaderPref";
            String str2 = "alvinluo details == null: %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.tsA == null);
            C4990ab.m7419v(str, str2, objArr);
            walletSecuritySettingHeaderPref.tsD = c400862;
            if (walletSecuritySettingHeaderPref.tsA != null) {
                walletSecuritySettingHeaderPref.tsA.setOnClickListener(c400862);
            }
            walletSecuritySettingHeaderPref = this.tsG;
            C354683 c354683 = new C354683();
            str = "MicroMsg.WalletSecuritySettingHeaderPref";
            str2 = "alvinluo closeBtn == null: %b";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.rnN == null);
            C4990ab.m7419v(str, str2, objArr);
            walletSecuritySettingHeaderPref.tsE = c354683;
            if (walletSecuritySettingHeaderPref.rnN != null) {
                walletSecuritySettingHeaderPref.rnN.setOnClickListener(c354683);
            }
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        if (this.tsF) {
            this.tsS = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), false, null);
            this.tsF = false;
        }
        boolean bxe = ((C30052l) C1720g.m3528K(C30052l.class)).bxe();
        SharedPreferences doB = C4996ah.doB();
        if (doB != null) {
            string = doB.getString("cpu_id", null);
            string2 = doB.getString("uid", null);
        } else {
            string2 = null;
            string = null;
        }
        C4990ab.m7417i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(bxe));
        C1720g.m3540Rg().mo14541a(new C46355k(bxe, string, string2), 0);
        AppMethodBeat.m2505o(46407);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46408);
        super.onPause();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(46408);
    }

    private void cOJ() {
        AppMethodBeat.m2504i(46409);
        this.tsG = (WalletSecuritySettingHeaderPref) this.ehK.aqO("wallet_security_basic_info");
        if (this.tsN != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.tsG;
            String str = this.tsN.title;
            String str2 = this.tsN.desc;
            String str3 = this.tsN.tsZ;
            walletSecuritySettingHeaderPref.lYc = str;
            walletSecuritySettingHeaderPref.tsB = str2;
            walletSecuritySettingHeaderPref.tsC = str3;
            walletSecuritySettingHeaderPref.mo47855cu();
            if (C5046bo.isNullOrNil(this.tsN.tsZ)) {
                walletSecuritySettingHeaderPref = this.tsG;
                if (walletSecuritySettingHeaderPref.tsA != null) {
                    walletSecuritySettingHeaderPref.tsA.setVisibility(8);
                }
            }
        }
        AppMethodBeat.m2505o(46409);
    }

    private void cOK() {
        AppMethodBeat.m2504i(46410);
        if (this.tsR == null) {
            this.ehK.mo27715ce("balance_privacy_info", true);
            AppMethodBeat.m2505o(46410);
            return;
        }
        this.ehK.mo27715ce("balance_privacy_info", false);
        this.tsL = (IconPreference) this.ehK.aqO("balance_privacy_info");
        m81735a(this.tsR.cIY, this.tsL);
        this.tsL.setTitle((CharSequence) this.tsR.title);
        this.tsL.setSummary((CharSequence) this.tsR.tsW);
        this.tsL.setDesc(this.tsR.desc);
        this.tsL.dAy();
        AppMethodBeat.m2505o(46410);
    }

    private void cOL() {
        AppMethodBeat.m2504i(46411);
        if (this.tsO == null) {
            this.ehK.mo27715ce("wallet_security_wallet_lock", true);
            AppMethodBeat.m2505o(46411);
            return;
        }
        this.ehK.mo27715ce("wallet_security_wallet_lock", false);
        this.tsJ = (IconPreference) this.ehK.aqO("wallet_security_wallet_lock");
        m81735a(this.tsO.oRi, this.tsJ);
        this.tsJ.setTitle((CharSequence) this.tsO.title);
        this.tsJ.setSummary((CharSequence) this.tsO.ttl);
        this.tsJ.setDesc(this.tsO.desc);
        this.tsJ.dAy();
        AppMethodBeat.m2505o(46411);
    }

    private void cOM() {
        boolean z;
        AppMethodBeat.m2504i(46412);
        this.ehK.mo27715ce("wallet_security_digital_certificate", false);
        this.tsH = (IconPreference) this.ehK.aqO("wallet_security_digital_certificate");
        C46720ab.dNZ();
        C1720g.m3537RQ();
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, Integer.valueOf(0))).intValue() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (C46720ab.dNZ().dOa()) {
                if (this.tsH != null) {
                    this.tsH.setSummary((int) C25738R.string.fsf);
                }
            } else if (this.tsH != null) {
                this.tsH.setSummary((int) C25738R.string.fsh);
            }
            m81735a(C46720ab.dNZ().Age, this.tsH);
            this.tsH.setTitle((CharSequence) C46720ab.dNZ().Agc);
            this.tsH.setSummary((CharSequence) C46720ab.dNZ().Agd);
            this.tsH.setDesc(C46720ab.dNZ().Agb);
            this.tsH.dAy();
            AppMethodBeat.m2505o(46412);
            return;
        }
        this.ehK.mo27715ce("wallet_security_digital_certificate", true);
        AppMethodBeat.m2505o(46412);
    }

    private void cON() {
        AppMethodBeat.m2504i(46413);
        this.ehK.mo27715ce("wallet_security_pay_guard", false);
        this.tsI = (IconPreference) this.ehK.aqO("wallet_security_pay_guard");
        if (this.tsI != null) {
            this.tsI.setSummary((int) C25738R.string.fsh);
        }
        if (this.tsQ == null) {
            this.ehK.mo27715ce("wallet_security_pay_guard", true);
            AppMethodBeat.m2505o(46413);
            return;
        }
        CharSequence charSequence;
        m81735a(this.tsQ.oRi, this.tsI);
        this.tsI.setTitle((CharSequence) this.tsQ.title);
        IconPreference iconPreference = this.tsI;
        C44778c c44778c = this.tsQ;
        if (c44778c.status == 0) {
            charSequence = c44778c.tta;
        } else if (c44778c.status == 1) {
            charSequence = c44778c.ttb;
        } else {
            charSequence = c44778c.ttc;
        }
        iconPreference.setSummary(charSequence);
        this.tsI.setDesc(this.tsQ.desc);
        this.tsI.dAy();
        AppMethodBeat.m2505o(46413);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(46415);
        if ("wallet_security_digital_certificate".equals(preference.mKey)) {
            C42088bj c42088bj = new C42088bj();
            c42088bj.cVT = 12;
            c42088bj.dcm = 1;
            c42088bj.ajK();
            C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            AppMethodBeat.m2505o(46415);
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.mKey)) {
            if (this.tsQ == null) {
                AppMethodBeat.m2505o(46415);
                return true;
            }
            C4990ab.m7417i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", this.tsQ.getUrl());
            C36391e.m60000bV(this, this.tsQ.getUrl());
            AppMethodBeat.m2505o(46415);
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.mKey)) {
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38290b(this, new Intent());
            AppMethodBeat.m2505o(46415);
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.mKey)) {
            if ("balance_privacy_info".equals(preference.mKey)) {
                if (this.tsR == null) {
                    AppMethodBeat.m2505o(46415);
                    return true;
                }
                C25985d.m41448H(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
            }
            AppMethodBeat.m2505o(46415);
            return false;
        } else if (this.tsP == null) {
            AppMethodBeat.m2505o(46415);
            return true;
        } else {
            C42088bj c42088bj2 = new C42088bj();
            c42088bj2.cVT = 15;
            c42088bj2.dcm = 1;
            c42088bj2.ajK();
            if (this.tsP.jumpType == 2) {
                C32628se c32628se = new C32628se();
                c32628se.cOf.axy = 0;
                c32628se.cOf.userName = this.tsP.ttk;
                c32628se.cOf.cOh = this.tsP.tsY;
                C4879a.xxA.mo10055m(c32628se);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.tsP.tsX);
                C4990ab.m7411d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", intent.getStringExtra("rawUrl"));
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(46415);
            return true;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46416);
        C4990ab.m7419v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C46355k) {
            JSONObject jSONObject = ((C46355k) c1207m).tqH;
            C4990ab.m7419v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", jSONObject);
            m81736an(jSONObject);
            if (!(jSONObject == null || ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.FALSE)).booleanValue())) {
                C43780e c43780e;
                jSONObject = jSONObject.optJSONObject("dialog_info");
                if (jSONObject == null) {
                    c43780e = null;
                } else {
                    C43780e c43780e2 = new C43780e();
                    c43780e2.title = jSONObject.optString("title");
                    c43780e2.cEh = jSONObject.optString("wording");
                    c43780e2.pia = jSONObject.optString("logo");
                    c43780e2.tth = C43779d.m78465ao(jSONObject.optJSONObject("left_btn"));
                    c43780e2.tti = C43779d.m78465ao(jSONObject.optJSONObject("right_btn"));
                    c43780e = c43780e2;
                }
                if (c43780e != null) {
                    C5652a c5652a = new C5652a(this);
                    View inflate = LayoutInflater.from(this).inflate(2130971175, null, false);
                    TextView textView = (TextView) inflate.findViewById(2131829071);
                    ((CdnImageView) inflate.findViewById(2131829070)).mo38952eb(c43780e.pia, C25738R.drawable.blk);
                    textView.setText(c43780e.cEh);
                    c5652a.mo11483rd(true);
                    c5652a.mo11482rc(false);
                    c5652a.mo11479fn(inflate);
                    c5652a.asD(c43780e.title);
                    if (!(c43780e.tti == null || C5046bo.isNullOrNil(c43780e.tti.kdE))) {
                        c5652a.asJ(c43780e.tti.kdE);
                        c5652a.mo11462a(true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(46396);
                                if (c43780e.tti.ttd == 1) {
                                    C36391e.m60016n(WalletSecuritySettingUI.this.mController.ylL, c43780e.tti.tte, true);
                                    AppMethodBeat.m2505o(46396);
                                    return;
                                }
                                if (c43780e.tti.ttd == 2) {
                                    C36391e.m60018p(c43780e.tti.ttf, c43780e.tti.ttg, 0, 1000);
                                }
                                AppMethodBeat.m2505o(46396);
                            }
                        });
                    }
                    if (!(c43780e.tth == null || C5046bo.isNullOrNil(c43780e.tth.kdE))) {
                        c5652a.asK(c43780e.tth.kdE);
                        c5652a.mo11476b(new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(46397);
                                if (c43780e.tth.ttd == 1) {
                                    C36391e.m60016n(WalletSecuritySettingUI.this.mController.ylL, c43780e.tth.tte, true);
                                    AppMethodBeat.m2505o(46397);
                                } else if (c43780e.tth.ttd == 2) {
                                    C36391e.m60018p(c43780e.tth.ttf, c43780e.tth.ttg, 0, 1000);
                                    AppMethodBeat.m2505o(46397);
                                } else {
                                    dialogInterface.dismiss();
                                    AppMethodBeat.m2505o(46397);
                                }
                            }
                        });
                    }
                    c5652a.aMb().show();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.TRUE);
                }
            }
        }
        AppMethodBeat.m2505o(46416);
    }

    private void onError(String str) {
        AppMethodBeat.m2504i(46417);
        if (this.tsS != null && this.tsS.isShowing()) {
            this.tsS.dismiss();
        }
        C30379h.m48448a((Context) this, str, "", false, new C225526());
        AppMethodBeat.m2505o(46417);
    }

    /* renamed from: an */
    private void m81736an(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46418);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(C25738R.string.fs6));
            AppMethodBeat.m2505o(46418);
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
                this.tsN = new C43778b(this, (byte) 0);
                this.tsN.title = jSONObject2.optString("title");
                this.tsN.desc = jSONObject2.optString("desc");
                this.tsN.oRi = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                jSONObject2 = jSONObject.getJSONObject("wallet_lock_info");
                this.tsO = new C22554g(this, (byte) 0);
                this.tsO.title = jSONObject2.optString("wallet_lock_title");
                this.tsO.desc = jSONObject2.optString("wallet_lock_desc");
                this.tsO.oRi = jSONObject2.getString("wallet_lock_logo_url");
                this.tsO.status = jSONObject2.optInt("wallet_lock_status");
                this.tsO.ttl = jSONObject2.optString("wallet_lock_status_name");
                this.tsO.ttm = jSONObject2.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                jSONObject2 = jSONObject.getJSONObject("property_security_info");
                this.tsP = new C43781f(this, (byte) 0);
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
                this.tsQ = new C44778c(this);
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
                this.tsR = new C22553a(this, (byte) 0);
                this.tsR.cIY = jSONObject2.optString("icon", "");
                this.tsR.title = jSONObject2.optString("title", "");
                this.tsR.desc = jSONObject2.optString("desc", "");
                this.tsR.switchState = jSONObject2.optInt("switch_state");
                this.tsR.tsW = jSONObject2.optString("switch_state_info");
            }
            C46720ab.dNZ().mo75126aT(jSONObject);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, jSONObject.toString());
            cOJ();
            cOL();
            cOM();
            cON();
            cOO();
            cOK();
            this.ehK.notifyDataSetChanged();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e, "", new Object[0]);
            onError(getString(C25738R.string.fs6));
        }
        dismissDialog();
        AppMethodBeat.m2505o(46418);
    }

    private void dismissDialog() {
        AppMethodBeat.m2504i(46419);
        if (this.tsS != null && this.tsS.isShowing()) {
            this.tsS.dismiss();
        }
        AppMethodBeat.m2505o(46419);
    }

    /* renamed from: a */
    private void m81735a(String str, final IconPreference iconPreference) {
        AppMethodBeat.m2504i(46420);
        if (iconPreference == null) {
            AppMethodBeat.m2505o(46420);
            return;
        }
        C32291o.ahk();
        Bitmap kR = C17937c.m28186kR(str);
        if (kR != null) {
            iconPreference.drawable = new BitmapDrawable(this.mController.ylL.getResources(), kR);
            AppMethodBeat.m2505o(46420);
            return;
        }
        if (!C5046bo.isNullOrNil(str)) {
            C447767 c447767 = new C32293a() {
                /* renamed from: i */
                public final void mo11044i(String str, Bitmap bitmap) {
                    AppMethodBeat.m2504i(46399);
                    C4990ab.m7417i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", str);
                    iconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.mController.ylL.getResources(), bitmap);
                    WalletSecuritySettingUI.this.tqO.remove(str);
                    AppMethodBeat.m2505o(46399);
                }
            };
            this.tqO.put(str, c447767);
            C32291o.aho().mo53003a(str, c447767);
        }
        AppMethodBeat.m2505o(46420);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46421);
        for (Entry entry : this.tqO.entrySet()) {
            C32291o.aho().mo53005b((String) entry.getKey(), (C32293a) entry.getValue());
        }
        this.tqO.clear();
        super.onDestroy();
        AppMethodBeat.m2505o(46421);
    }

    private void cOO() {
        AppMethodBeat.m2504i(46414);
        this.ehK = this.yCw;
        this.ehK.mo27715ce("wallet_security_safety_insurance", false);
        this.tsK = (IconPreference) this.ehK.aqO("wallet_security_safety_insurance");
        if (this.tsK != null) {
            this.tsK.setSummary((int) C25738R.string.fsi);
        }
        if (this.tsP == null) {
            this.ehK.mo27715ce("wallet_security_safety_insurance", true);
            AppMethodBeat.m2505o(46414);
            return;
        }
        m81735a(this.tsP.oRi, this.tsK);
        this.tsK.setTitle((CharSequence) this.tsP.title);
        this.tsK.setSummary((CharSequence) this.tsP.ttj);
        this.tsK.setDesc(this.tsP.desc);
        this.tsK.dAy();
        AppMethodBeat.m2505o(46414);
    }
}
