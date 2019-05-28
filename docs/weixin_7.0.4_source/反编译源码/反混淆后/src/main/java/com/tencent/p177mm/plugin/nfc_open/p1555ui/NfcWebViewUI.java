package com.tencent.p177mm.plugin.nfc_open.p1555ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.nfc.p1002a.C34621a;
import com.tencent.p177mm.plugin.nfc.p1004c.C12717a;
import com.tencent.p177mm.plugin.nfc.p472b.p1003a.C46113a;
import com.tencent.p177mm.plugin.nfc_open.p736a.C6996a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.protocal.protobuf.C23442sz;
import com.tencent.p177mm.protocal.protobuf.C35937nn;
import com.tencent.p177mm.protocal.protobuf.C40578ul;
import com.tencent.p177mm.protocal.protobuf.bel;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.util.Iterator;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI */
public class NfcWebViewUI extends WebViewUI {
    private String oTx = null;
    private boolean oTy = false;
    private C6996a oTz = new C6996a();

    /* renamed from: com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI$1 */
    class C394661 implements OnMenuItemClickListener {
        C394661() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23069);
            if (NfcWebViewUI.this.oTy) {
                NfcWebViewUI.m77361b(NfcWebViewUI.this);
            } else {
                NfcWebViewUI.this.finish();
            }
            AppMethodBeat.m2505o(23069);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NfcWebViewUI() {
        AppMethodBeat.m2504i(23072);
        AppMethodBeat.m2505o(23072);
    }

    /* renamed from: b */
    static /* synthetic */ void m77361b(NfcWebViewUI nfcWebViewUI) {
        AppMethodBeat.m2504i(23090);
        nfcWebViewUI.bVG();
        AppMethodBeat.m2505o(23090);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23073);
        Intent intent = getIntent();
        if (NfcWebViewUI.m77360ak(intent)) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            try {
                intent.putExtra("key_trust_url", false);
            } catch (Exception e) {
            }
            super.onCreate(bundle);
            finish();
            AppMethodBeat.m2505o(23073);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.oTz);
        C25985d.dlL();
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new C394661());
        getIntent().putExtra("showShare", false);
        mo31012nO(false);
        AppMethodBeat.m2505o(23073);
    }

    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.m2504i(23074);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.oTz);
        AppMethodBeat.m2505o(23074);
    }

    public final void aMh() {
        AppMethodBeat.m2504i(23075);
        if (bVD()) {
            finish();
            C4990ab.m7420w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            AppMethodBeat.m2505o(23075);
            return;
        }
        super.aMh();
        m77357a(C4737a.LOGIN_OK, getIntent());
        AppMethodBeat.m2505o(23075);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(23076);
        if (NfcWebViewUI.m77360ak(intent)) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            AppMethodBeat.m2505o(23076);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = C5068w.m7682a(intent, "wizard_activity_result_code", (int) BaseClientBuilder.API_PRIORITY_OTHER);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(a)));
        if (a != BaseClientBuilder.API_PRIORITY_OTHER) {
            this.oTy = true;
        }
        switch (a) {
            case -1:
                m77357a(C4737a.LOGIN_OK, intent);
                break;
            case 0:
                bVD();
                AppMethodBeat.m2505o(23076);
                return;
            case 1:
                m77357a(C4737a.LOGIN_CANCEL, intent);
                break;
        }
        mo31008jD(true);
        C4990ab.m7416i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(intent)));
        AppMethodBeat.m2505o(23076);
    }

    private boolean bVD() {
        AppMethodBeat.m2504i(23077);
        try {
            if (this.icy.cZp()) {
                C4990ab.m7420w("MicroMsg.NfcWebViewUI", "not login");
                Intent intent = new Intent(this, getClass());
                intent.putExtras(getIntent());
                intent.addFlags(67108864);
                this.icy.mo15534aB(intent);
                AppMethodBeat.m2505o(23077);
                return true;
            }
            AppMethodBeat.m2505o(23077);
            return false;
        } catch (RemoteException e) {
            C4990ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(23077);
            return true;
        }
    }

    /* renamed from: a */
    private void m77357a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(23078);
        switch (c4737a) {
            case LOGIN_OK:
                Tag tag;
                Parcelable p = C5068w.m7691p(intent, "android.nfc.extra.TAG");
                if (p == null || !(p instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) p;
                }
                if (tag == null) {
                    C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    AppMethodBeat.m2505o(23078);
                    return;
                }
                try {
                    C46113a.bVz().mo24725a(tag);
                    C4990ab.m7416i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(C46113a.bVz().mo74060eG(this.mController.ylL))));
                    AppMethodBeat.m2505o(23078);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.NfcWebViewUI", "exp protect");
                    AppMethodBeat.m2505o(23078);
                    return;
                }
            default:
                finish();
                AppMethodBeat.m2505o(23078);
                return;
        }
    }

    /* JADX WARNING: Missing block: B:22:0x00c9, code skipped:
            if (r2.equals(r3) != false) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: jD */
    public final void mo31008jD(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(23079);
        if (this.icy == null) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            AppMethodBeat.m2505o(23079);
            return;
        }
        m77357a(C4737a.LOGIN_OK, getIntent());
        String bVF = bVF();
        if (!z || C5046bo.isNullOrNil(this.cOG)) {
            this.cOG = bVF;
        } else if (!bVE()) {
            try {
                if (!C5046bo.isNullOrNil(bVF)) {
                    try {
                        Uri parse = Uri.parse(bVF);
                        Uri parse2 = Uri.parse(this.cOG);
                        bVF = parse.getHost();
                        String host = parse2.getHost();
                        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "targetHost=" + bVF + ", curHost=" + host);
                    } catch (Exception e) {
                    }
                }
                i = 0;
                if (i != 0) {
                    this.umI.mo26784c(WearableStatusCodes.UNKNOWN_CAPABILITY, new Bundle());
                }
            } catch (RemoteException e2) {
                C4990ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
            }
            C4990ab.m7416i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
            AppMethodBeat.m2505o(23079);
            return;
        } else if (C5046bo.isNullOrNil(bVF)) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        } else {
            C4990ab.m7417i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", bVF);
            this.cOG = bVF;
            getIntent().putExtra("rawUrl", this.cOG);
            mo30966as(this.cOG, false);
        }
        if (C5046bo.isNullOrNil(this.cOG)) {
            this.cOG = NfcWebViewUI.m77354Ah(0);
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
        }
        getIntent().putExtra("rawUrl", this.cOG);
        AppMethodBeat.m2505o(23079);
    }

    private boolean bVE() {
        AppMethodBeat.m2504i(23080);
        boolean startsWith = this.cOG.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        AppMethodBeat.m2505o(23080);
        return startsWith;
    }

    /* renamed from: Ah */
    private static String m77354Ah(int i) {
        String str;
        AppMethodBeat.m2504i(23081);
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!C5059g.xyg && C4988aa.dor().equals("zh_CN")) {
            str = "zh_CN";
        } else if (C4988aa.dop()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(23081);
        return str;
    }

    private String bVF() {
        String str = null;
        AppMethodBeat.m2504i(23082);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle g = this.icy.mo15575g(WearableStatusCodes.DUPLICATE_CAPABILITY, null);
            if (g == null) {
                C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                AppMethodBeat.m2505o(23082);
                return str;
            }
            g.setClassLoader(getClass().getClassLoader());
            String string = g.getString("debugConfig");
            String string2 = g.getString("config");
            if (string != null) {
                str = m77355TG(string);
            } else {
                str = m77356TH(string2);
            }
            C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + C5046bo.nullAsNil(str));
            AppMethodBeat.m2505o(23082);
            return str;
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", e.toString());
            C4990ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
        }
    }

    /* renamed from: TG */
    private String m77355TG(String str) {
        AppMethodBeat.m2504i(23083);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.oTx = "";
        String str2;
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    str2 = split[i];
                    String str3 = split[i + 1];
                    C4990ab.m7410d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = NfcWebViewUI.m77358a(new C34621a(C12717a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.oTx = split[split.length - 1];
                    C4990ab.m7410d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.oTx);
                    str2 = this.oTx;
                    AppMethodBeat.m2505o(23083);
                    return str2;
                }
            }
            str2 = this.oTx;
            AppMethodBeat.m2505o(23083);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(C46113a.bVz().mo74059eF(this.mController.ylL))));
            this.oTx = NfcWebViewUI.m77354Ah(1);
            str2 = this.oTx;
            AppMethodBeat.m2505o(23083);
            return str2;
        }
    }

    /* renamed from: TH */
    private String m77356TH(String str) {
        String str2;
        AppMethodBeat.m2504i(23084);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.oTx = "";
        bel bel = new bel();
        if (!C5046bo.isNullOrNil(str)) {
            try {
                bel.parseFrom(str.getBytes("ISO-8859-1"));
                if (bel.wbW != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < bel.wbW.size(); i2++) {
                        C35937nn c35937nn = (C35937nn) bel.wbW.get(i2);
                        C46113a bVz = C46113a.bVz();
                        if (bVz.oTq != null) {
                            bVz.oTq.bVA();
                        }
                        if (!(c35937nn == null || C5046bo.isNullOrNil(c35937nn.vzX) || C5046bo.m7548ek(c35937nn.vRR))) {
                            String str3;
                            int i3 = 0;
                            int i4 = i;
                            while (i3 < c35937nn.vRR.size()) {
                                if (!C5046bo.m7548ek(((C40578ul) c35937nn.vRR.get(i3)).wbZ)) {
                                    int i5 = 0;
                                    while (i5 < ((C40578ul) c35937nn.vRR.get(i3)).wbZ.size()) {
                                        if (((C40578ul) c35937nn.vRR.get(i3)).wbZ.get(i5) != null && !C5046bo.isNullOrNil(((C23442sz) ((C40578ul) c35937nn.vRR.get(i3)).wbZ.get(i5)).wap) && !C5046bo.isNullOrNil(((C23442sz) ((C40578ul) c35937nn.vRR.get(i3)).wbZ.get(i5)).nYb)) {
                                            String str4 = ((C23442sz) ((C40578ul) c35937nn.vRR.get(i3)).wbZ.get(i5)).wap;
                                            str3 = ((C23442sz) ((C40578ul) c35937nn.vRR.get(i3)).wbZ.get(i5)).nYb;
                                            C4990ab.m7410d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str4 + " anwser = " + str3);
                                            if (!NfcWebViewUI.m77358a(new C34621a(C12717a.hexStringToByteArray(str4)), str3)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                                i4 = i;
                            }
                            i = i4;
                            if (i != 0) {
                                str3 = c35937nn.vzX;
                                C4990ab.m7416i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                C7305d.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(23070);
                                        C7060h.pYm.mo8381e(12794, str3, Integer.valueOf(0));
                                        C4990ab.m7410d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str3);
                                        AppMethodBeat.m2505o(23070);
                                    }
                                }, getClass().getName());
                                str2 = c35937nn.vzX;
                                AppMethodBeat.m2505o(23084);
                                return str2;
                            }
                        }
                        i = i;
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                C4990ab.m7412e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(C46113a.bVz().mo74059eF(this.mController.ylL))));
                this.oTx = NfcWebViewUI.m77354Ah(1);
                str2 = this.oTx;
                AppMethodBeat.m2505o(23084);
                return str2;
            }
        }
        str2 = this.oTx;
        AppMethodBeat.m2505o(23084);
        return str2;
    }

    /* renamed from: a */
    private static boolean m77358a(C34621a c34621a, String str) {
        AppMethodBeat.m2504i(23085);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        if (NfcWebViewUI.m77362ft(str, C46113a.bVz().mo74057a(c34621a).toString())) {
            AppMethodBeat.m2505o(23085);
            return true;
        }
        AppMethodBeat.m2505o(23085);
        return false;
    }

    /* renamed from: ft */
    private static boolean m77362ft(String str, String str2) {
        AppMethodBeat.m2504i(23086);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(23086);
            return false;
        }
        C4990ab.m7410d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + C5046bo.nullAsNil(str) + " resp = " + C5046bo.nullAsNil(str2));
        if (Pattern.compile(str, 2).matcher(str2).find()) {
            AppMethodBeat.m2505o(23086);
            return true;
        }
        AppMethodBeat.m2505o(23086);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(23087);
        if (this.oTy) {
            bVG();
            AppMethodBeat.m2505o(23087);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(23087);
    }

    private void bVG() {
        AppMethodBeat.m2504i(23088);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        C25985d.m41473f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8367c9);
        C4990ab.m7416i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
        AppMethodBeat.m2505o(23088);
    }

    /* renamed from: ak */
    private static boolean m77360ak(Intent intent) {
        AppMethodBeat.m2504i(23089);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.NfcWebViewUI", "intent is null");
            AppMethodBeat.m2505o(23089);
            return true;
        }
        try {
            Tag tag;
            Iterator it = intent.getExtras().keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!(str == null || str.startsWith("android.nfc"))) {
                    C4990ab.m7412e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
                    it.remove();
                }
            }
            Parcelable p = C5068w.m7691p(intent, "android.nfc.extra.TAG");
            if (p == null || !(p instanceof Tag)) {
                tag = null;
            } else {
                tag = (Tag) p;
            }
            if (tag == null) {
                C4990ab.m7412e("MicroMsg.NfcWebViewUI", "tag is null");
                AppMethodBeat.m2505o(23089);
                return true;
            }
            AppMethodBeat.m2505o(23089);
            return false;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", e);
            AppMethodBeat.m2505o(23089);
            return true;
        }
    }
}
