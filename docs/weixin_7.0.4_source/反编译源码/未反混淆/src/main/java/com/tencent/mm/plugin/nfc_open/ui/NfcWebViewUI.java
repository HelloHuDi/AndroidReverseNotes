package com.tencent.mm.plugin.nfc_open.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String oTx = null;
    private boolean oTy = false;
    private a oTz = new a();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NfcWebViewUI() {
        AppMethodBeat.i(23072);
        AppMethodBeat.o(23072);
    }

    static /* synthetic */ void b(NfcWebViewUI nfcWebViewUI) {
        AppMethodBeat.i(23090);
        nfcWebViewUI.bVG();
        AppMethodBeat.o(23090);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23073);
        Intent intent = getIntent();
        if (ak(intent)) {
            ab.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            try {
                intent.putExtra("key_trust_url", false);
            } catch (Exception e) {
            }
            super.onCreate(bundle);
            finish();
            AppMethodBeat.o(23073);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.oTz);
        d.dlL();
        ab.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23069);
                if (NfcWebViewUI.this.oTy) {
                    NfcWebViewUI.b(NfcWebViewUI.this);
                } else {
                    NfcWebViewUI.this.finish();
                }
                AppMethodBeat.o(23069);
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        nO(false);
        AppMethodBeat.o(23073);
    }

    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.i(23074);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.oTz);
        AppMethodBeat.o(23074);
    }

    public final void aMh() {
        AppMethodBeat.i(23075);
        if (bVD()) {
            finish();
            ab.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            AppMethodBeat.o(23075);
            return;
        }
        super.aMh();
        a(AutoLoginActivity.a.LOGIN_OK, getIntent());
        AppMethodBeat.o(23075);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(23076);
        if (ak(intent)) {
            ab.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            AppMethodBeat.o(23076);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = w.a(intent, "wizard_activity_result_code", (int) BaseClientBuilder.API_PRIORITY_OTHER);
        ab.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(a)));
        if (a != BaseClientBuilder.API_PRIORITY_OTHER) {
            this.oTy = true;
        }
        switch (a) {
            case -1:
                a(AutoLoginActivity.a.LOGIN_OK, intent);
                break;
            case 0:
                bVD();
                AppMethodBeat.o(23076);
                return;
            case 1:
                a(AutoLoginActivity.a.LOGIN_CANCEL, intent);
                break;
        }
        jD(true);
        ab.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(intent)));
        AppMethodBeat.o(23076);
    }

    private boolean bVD() {
        AppMethodBeat.i(23077);
        try {
            if (this.icy.cZp()) {
                ab.w("MicroMsg.NfcWebViewUI", "not login");
                Intent intent = new Intent(this, getClass());
                intent.putExtras(getIntent());
                intent.addFlags(67108864);
                this.icy.aB(intent);
                AppMethodBeat.o(23077);
                return true;
            }
            AppMethodBeat.o(23077);
            return false;
        } catch (RemoteException e) {
            ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            AppMethodBeat.o(23077);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        AppMethodBeat.i(23078);
        switch (aVar) {
            case LOGIN_OK:
                Tag tag;
                Parcelable p = w.p(intent, "android.nfc.extra.TAG");
                if (p == null || !(p instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) p;
                }
                if (tag == null) {
                    ab.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    AppMethodBeat.o(23078);
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.b.a.a.bVz().a(tag);
                    ab.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bVz().eG(this.mController.ylL))));
                    AppMethodBeat.o(23078);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.NfcWebViewUI", "exp protect");
                    AppMethodBeat.o(23078);
                    return;
                }
            default:
                finish();
                AppMethodBeat.o(23078);
                return;
        }
    }

    /* JADX WARNING: Missing block: B:22:0x00c9, code skipped:
            if (r2.equals(r3) != false) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void jD(boolean z) {
        int i = 1;
        AppMethodBeat.i(23079);
        if (this.icy == null) {
            ab.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            AppMethodBeat.o(23079);
            return;
        }
        a(AutoLoginActivity.a.LOGIN_OK, getIntent());
        String bVF = bVF();
        if (!z || bo.isNullOrNil(this.cOG)) {
            this.cOG = bVF;
        } else if (!bVE()) {
            try {
                if (!bo.isNullOrNil(bVF)) {
                    try {
                        Uri parse = Uri.parse(bVF);
                        Uri parse2 = Uri.parse(this.cOG);
                        bVF = parse.getHost();
                        String host = parse2.getHost();
                        ab.i("MicroMsg.NfcWebViewUI", "targetHost=" + bVF + ", curHost=" + host);
                    } catch (Exception e) {
                    }
                }
                i = 0;
                if (i != 0) {
                    this.umI.c(WearableStatusCodes.UNKNOWN_CAPABILITY, new Bundle());
                }
            } catch (RemoteException e2) {
                ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
            }
            ab.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
            AppMethodBeat.o(23079);
            return;
        } else if (bo.isNullOrNil(bVF)) {
            ab.e("MicroMsg.NfcWebViewUI", "[NFC] carGuideUrl not found! not support this card ?");
        } else {
            ab.i("MicroMsg.NfcWebViewUI", "alvinluo [NFC] cardGuideUrl: %s", bVF);
            this.cOG = bVF;
            getIntent().putExtra("rawUrl", this.cOG);
            as(this.cOG, false);
        }
        if (bo.isNullOrNil(this.cOG)) {
            this.cOG = Ah(0);
            ab.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
        }
        getIntent().putExtra("rawUrl", this.cOG);
        AppMethodBeat.o(23079);
    }

    private boolean bVE() {
        AppMethodBeat.i(23080);
        boolean startsWith = this.cOG.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        AppMethodBeat.o(23080);
        return startsWith;
    }

    private static String Ah(int i) {
        String str;
        AppMethodBeat.i(23081);
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!g.xyg && aa.dor().equals("zh_CN")) {
            str = "zh_CN";
        } else if (aa.dop()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        str = stringBuilder.toString();
        AppMethodBeat.o(23081);
        return str;
    }

    private String bVF() {
        String str = null;
        AppMethodBeat.i(23082);
        ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle g = this.icy.g(WearableStatusCodes.DUPLICATE_CAPABILITY, null);
            if (g == null) {
                ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                AppMethodBeat.o(23082);
                return str;
            }
            g.setClassLoader(getClass().getClassLoader());
            String string = g.getString("debugConfig");
            String string2 = g.getString("config");
            if (string != null) {
                str = TG(string);
            } else {
                str = TH(string2);
            }
            ab.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bo.nullAsNil(str));
            AppMethodBeat.o(23082);
            return str;
        } catch (RemoteException e) {
            ab.e("MicroMsg.NfcWebViewUI", e.toString());
            ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
        }
    }

    private String TG(String str) {
        AppMethodBeat.i(23083);
        ab.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.oTx = "";
        String str2;
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    str2 = split[i];
                    String str3 = split[i + 1];
                    ab.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.oTx = split[split.length - 1];
                    ab.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.oTx);
                    str2 = this.oTx;
                    AppMethodBeat.o(23083);
                    return str2;
                }
            }
            str2 = this.oTx;
            AppMethodBeat.o(23083);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            ab.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            ab.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bVz().eF(this.mController.ylL))));
            this.oTx = Ah(1);
            str2 = this.oTx;
            AppMethodBeat.o(23083);
            return str2;
        }
    }

    private String TH(String str) {
        String str2;
        AppMethodBeat.i(23084);
        ab.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.oTx = "";
        bel bel = new bel();
        if (!bo.isNullOrNil(str)) {
            try {
                bel.parseFrom(str.getBytes("ISO-8859-1"));
                if (bel.wbW != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < bel.wbW.size(); i2++) {
                        nn nnVar = (nn) bel.wbW.get(i2);
                        com.tencent.mm.plugin.nfc.b.a.a bVz = com.tencent.mm.plugin.nfc.b.a.a.bVz();
                        if (bVz.oTq != null) {
                            bVz.oTq.bVA();
                        }
                        if (!(nnVar == null || bo.isNullOrNil(nnVar.vzX) || bo.ek(nnVar.vRR))) {
                            String str3;
                            int i3 = 0;
                            int i4 = i;
                            while (i3 < nnVar.vRR.size()) {
                                if (!bo.ek(((ul) nnVar.vRR.get(i3)).wbZ)) {
                                    int i5 = 0;
                                    while (i5 < ((ul) nnVar.vRR.get(i3)).wbZ.size()) {
                                        if (((ul) nnVar.vRR.get(i3)).wbZ.get(i5) != null && !bo.isNullOrNil(((sz) ((ul) nnVar.vRR.get(i3)).wbZ.get(i5)).wap) && !bo.isNullOrNil(((sz) ((ul) nnVar.vRR.get(i3)).wbZ.get(i5)).nYb)) {
                                            String str4 = ((sz) ((ul) nnVar.vRR.get(i3)).wbZ.get(i5)).wap;
                                            str3 = ((sz) ((ul) nnVar.vRR.get(i3)).wbZ.get(i5)).nYb;
                                            ab.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str4 + " anwser = " + str3);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str4)), str3)) {
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
                                str3 = nnVar.vzX;
                                ab.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                com.tencent.mm.sdk.g.d.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(23070);
                                        h.pYm.e(12794, str3, Integer.valueOf(0));
                                        ab.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str3);
                                        AppMethodBeat.o(23070);
                                    }
                                }, getClass().getName());
                                str2 = nnVar.vzX;
                                AppMethodBeat.o(23084);
                                return str2;
                            }
                        }
                        i = i;
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                ab.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                ab.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.bVz().eF(this.mController.ylL))));
                this.oTx = Ah(1);
                str2 = this.oTx;
                AppMethodBeat.o(23084);
                return str2;
            }
        }
        str2 = this.oTx;
        AppMethodBeat.o(23084);
        return str2;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        AppMethodBeat.i(23085);
        ab.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        if (ft(str, com.tencent.mm.plugin.nfc.b.a.a.bVz().a(aVar).toString())) {
            AppMethodBeat.o(23085);
            return true;
        }
        AppMethodBeat.o(23085);
        return false;
    }

    private static boolean ft(String str, String str2) {
        AppMethodBeat.i(23086);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(23086);
            return false;
        }
        ab.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bo.nullAsNil(str) + " resp = " + bo.nullAsNil(str2));
        if (Pattern.compile(str, 2).matcher(str2).find()) {
            AppMethodBeat.o(23086);
            return true;
        }
        AppMethodBeat.o(23086);
        return false;
    }

    public void onBackPressed() {
        AppMethodBeat.i(23087);
        if (this.oTy) {
            bVG();
            AppMethodBeat.o(23087);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(23087);
    }

    private void bVG() {
        AppMethodBeat.i(23088);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.anim.s, R.anim.c9);
        ab.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
        AppMethodBeat.o(23088);
    }

    private static boolean ak(Intent intent) {
        AppMethodBeat.i(23089);
        if (intent == null) {
            ab.e("MicroMsg.NfcWebViewUI", "intent is null");
            AppMethodBeat.o(23089);
            return true;
        }
        try {
            Tag tag;
            Iterator it = intent.getExtras().keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!(str == null || str.startsWith("android.nfc"))) {
                    ab.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(str)));
                    it.remove();
                }
            }
            Parcelable p = w.p(intent, "android.nfc.extra.TAG");
            if (p == null || !(p instanceof Tag)) {
                tag = null;
            } else {
                tag = (Tag) p;
            }
            if (tag == null) {
                ab.e("MicroMsg.NfcWebViewUI", "tag is null");
                AppMethodBeat.o(23089);
                return true;
            }
            AppMethodBeat.o(23089);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", e);
            AppMethodBeat.o(23089);
            return true;
        }
    }
}
