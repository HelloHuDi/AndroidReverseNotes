package com.tencent.p177mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32562gp;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.C14827e.C14831a;
import com.tencent.p177mm.pluginsdk.p1078e.C14826a;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity */
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> jDZ;

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity$2 */
    class C26712 implements C14831a {
        C26712() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18182);
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.m2505o(18182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity$4 */
    class C26724 implements C14831a {
        C26724() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18184);
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.m2505o(18184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity$1 */
    class C26731 implements C14831a {
        C26731() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18181);
            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (!(c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z))) {
                ciq ajE = ((C26475z) c1207m).ajE();
                if (!(ajE == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                    C23639t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(C25738R.string.f9238tz) + " : " + C5046bo.nullAsNil(ajE.xhy), 0).show();
                }
            }
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.m2505o(18181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity$3 */
    class C26743 implements C14831a {
        C26743() {
        }

        /* renamed from: a */
        public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
            AppMethodBeat.m2504i(18183);
            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
            if (!(c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z))) {
                ciq ajE = ((C26475z) c1207m).ajE();
                if (!(ajE == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                    C23639t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(C25738R.string.f9238tz) + " : " + C5046bo.nullAsNil(ajE.xhy), 0).show();
                }
            }
            WXCustomSchemeEntryActivity.this.finish();
            AppMethodBeat.m2505o(18183);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18186);
        C4990ab.m7416i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.jDZ = new ArrayList();
        this.jDZ.add("cardpackage");
        this.jDZ.add("connectToFreeWifi");
        this.jDZ.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
        AppMethodBeat.m2505o(18186);
    }

    public final int getLayoutId() {
        return 2130968856;
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        Uri data;
        AppMethodBeat.m2504i(18187);
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (C14827e.aim(data.toString())) {
                AppMethodBeat.m2505o(18187);
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!C5046bo.isNullOrNil(host) && this.jDZ.contains(host)) {
                C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!C5046bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        AppMethodBeat.m2505o(18187);
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!C5046bo.isNullOrNil(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!C5046bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            AppMethodBeat.m2505o(18187);
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        AppMethodBeat.m2505o(18187);
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    C4990ab.m7416i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    AppMethodBeat.m2505o(18187);
                    return true;
                }
            }
        }
        finish();
        AppMethodBeat.m2505o(18187);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(18188);
        switch (c4737a) {
            case LOGIN_OK:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    Object obj;
                    if (data != null) {
                        Bundle bundle;
                        int i = 2;
                        if (intent != null) {
                            i = C5068w.m7682a(intent, "translate_link_scene", 2);
                        }
                        int a = C5068w.m7682a(intent, "pay_channel", -1);
                        C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", Integer.valueOf(i), Integer.valueOf(a));
                        Bundle bundle2 = null;
                        if (a >= 0) {
                            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", Integer.valueOf(a));
                            bundle2 = new Bundle();
                            bundle2.putInt("pay_channel", a);
                        }
                        String aVm = aVm();
                        C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", aVm);
                        if (bundle2 == null) {
                            bundle = new Bundle();
                        } else {
                            bundle = bundle2;
                        }
                        bundle.putString("pay_package", aVm);
                        String host;
                        if (!C14827e.aim(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            String query = data.getQuery();
                            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!C5046bo.isNullOrNil(host) && this.jDZ.contains(host)) {
                                if (host.equals("cardpackage") && !C5046bo.isNullOrNil(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!C5046bo.isNullOrNil(query) && query.startsWith("apKey=")) {
                                        scheme = data.getQueryParameter("apKey");
                                        C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                                        String queryParameter = data.getQueryParameter("ticket");
                                        if (!C5046bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", scheme);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!C5046bo.isNullOrNil(queryParameter)) {
                                                intent2.putExtra("free_wifi_schema_ticket", queryParameter);
                                            }
                                            if (scheme.startsWith("_") || C5046bo.isNullOrNil(queryParameter)) {
                                                intent2.addFlags(67108864);
                                                C25985d.m41467b((Context) this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                C32562gp c32562gp = new C32562gp();
                                                c32562gp.cBm.intent = intent2;
                                                C4879a.xxA.mo10055m(c32562gp);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        C25985d.m41467b((Context) this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        C4990ab.m7416i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", aVm);
                                    if (!TextUtils.isEmpty(query)) {
                                        C35899h.m58852a((Context) this, C14826a.aiw(query), false, aVm);
                                    }
                                }
                            }
                        } else if (C14827e.m23079s(data)) {
                            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(C14827e.m23080t(data)));
                            if (C14827e.m23080t(data)) {
                                C14827e.m23067a((Context) this, data.toString(), i, bundle, new C26731());
                                obj = 1;
                                if (obj != null) {
                                    AppMethodBeat.m2505o(18188);
                                    return;
                                }
                            }
                            C14827e.m23067a((Context) this, data.toString(), i, bundle, new C26712());
                        } else if (C14827e.ain(data.toString())) {
                            if (i == 1) {
                                C32800b nU = C37922v.m64076Zp().mo60673nU("key_data_center_session_id");
                                if (nU == null) {
                                    C4990ab.m7412e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", nU.getString("key_package_name", ""), nU.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                                    C37922v.m64076Zp().mo60674nV("key_data_center_session_id");
                                    if (!(nU.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r0.equals(r6))) {
                                        C4990ab.m7412e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            C14827e.m23068a((Context) this, data.toString(), i, bundle, new C26743(), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            obj = 1;
                            if (obj != null) {
                            }
                        } else {
                            host = C1853r.m3846Yz();
                            C4990ab.m7417i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            C14827e.m23071a((Context) this, data.toString(), host, 23, data.toString(), new C26724());
                        }
                    }
                    obj = null;
                    if (obj != null) {
                    }
                }
                break;
        }
        finish();
        AppMethodBeat.m2505o(18188);
    }

    private String aVm() {
        AppMethodBeat.m2504i(18189);
        String str;
        if (C1443d.m3069iX(21)) {
            try {
                Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(this);
                AppMethodBeat.m2505o(18189);
                return str;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", e, "", new Object[0]);
                str = "No referrer";
                AppMethodBeat.m2505o(18189);
                return str;
            }
        }
        str = "";
        AppMethodBeat.m2505o(18189);
        return str;
    }
}
