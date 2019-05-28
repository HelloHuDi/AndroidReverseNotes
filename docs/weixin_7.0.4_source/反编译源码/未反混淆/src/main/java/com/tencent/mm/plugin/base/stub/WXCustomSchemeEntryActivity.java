package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.t;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> jDZ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18186);
        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.jDZ = new ArrayList();
        this.jDZ.add("cardpackage");
        this.jDZ.add("connectToFreeWifi");
        this.jDZ.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
        AppMethodBeat.o(18186);
    }

    public final int getLayoutId() {
        return R.layout.gv;
    }

    public final boolean O(Intent intent) {
        Uri data;
        AppMethodBeat.i(18187);
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            ab.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (e.aim(data.toString())) {
                AppMethodBeat.o(18187);
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!bo.isNullOrNil(host) && this.jDZ.contains(host)) {
                ab.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        AppMethodBeat.o(18187);
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!bo.isNullOrNil(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            AppMethodBeat.o(18187);
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        AppMethodBeat.o(18187);
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    AppMethodBeat.o(18187);
                    return true;
                }
            }
        }
        finish();
        AppMethodBeat.o(18187);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar, Intent intent) {
        AppMethodBeat.i(18188);
        switch (aVar) {
            case LOGIN_OK:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    ab.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    Object obj;
                    if (data != null) {
                        Bundle bundle;
                        int i = 2;
                        if (intent != null) {
                            i = w.a(intent, "translate_link_scene", 2);
                        }
                        int a = w.a(intent, "pay_channel", -1);
                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", Integer.valueOf(i), Integer.valueOf(a));
                        Bundle bundle2 = null;
                        if (a >= 0) {
                            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", Integer.valueOf(a));
                            bundle2 = new Bundle();
                            bundle2.putInt("pay_channel", a);
                        }
                        String aVm = aVm();
                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", aVm);
                        if (bundle2 == null) {
                            bundle = new Bundle();
                        } else {
                            bundle = bundle2;
                        }
                        bundle.putString("pay_package", aVm);
                        String host;
                        if (!e.aim(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            String query = data.getQuery();
                            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!bo.isNullOrNil(host) && this.jDZ.contains(host)) {
                                if (host.equals("cardpackage") && !bo.isNullOrNil(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!bo.isNullOrNil(query) && query.startsWith("apKey=")) {
                                        scheme = data.getQueryParameter("apKey");
                                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                                        String queryParameter = data.getQueryParameter("ticket");
                                        if (!bo.isNullOrNil(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", scheme);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!bo.isNullOrNil(queryParameter)) {
                                                intent2.putExtra("free_wifi_schema_ticket", queryParameter);
                                            }
                                            if (scheme.startsWith("_") || bo.isNullOrNil(queryParameter)) {
                                                intent2.addFlags(67108864);
                                                d.b((Context) this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                gp gpVar = new gp();
                                                gpVar.cBm.intent = intent2;
                                                com.tencent.mm.sdk.b.a.xxA.m(gpVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        d.b((Context) this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", aVm);
                                    if (!TextUtils.isEmpty(query)) {
                                        h.a((Context) this, com.tencent.mm.pluginsdk.e.a.aiw(query), false, aVm);
                                    }
                                }
                            }
                        } else if (e.s(data)) {
                            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(e.t(data)));
                            if (e.t(data)) {
                                e.a((Context) this, data.toString(), i, bundle, new e.a() {
                                    public final void a(int i, int i2, String str, m mVar, boolean z) {
                                        AppMethodBeat.i(18181);
                                        ab.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                        if (!(mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z))) {
                                            ciq ajE = ((z) mVar).ajE();
                                            if (!(ajE == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                                                t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.string.tz) + " : " + bo.nullAsNil(ajE.xhy), 0).show();
                                            }
                                        }
                                        WXCustomSchemeEntryActivity.this.finish();
                                        AppMethodBeat.o(18181);
                                    }
                                });
                                obj = 1;
                                if (obj != null) {
                                    AppMethodBeat.o(18188);
                                    return;
                                }
                            }
                            e.a((Context) this, data.toString(), i, bundle, new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18182);
                                    WXCustomSchemeEntryActivity.this.finish();
                                    AppMethodBeat.o(18182);
                                }
                            });
                        } else if (e.ain(data.toString())) {
                            if (i == 1) {
                                b nU = v.Zp().nU("key_data_center_session_id");
                                if (nU == null) {
                                    ab.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", nU.getString("key_package_name", ""), nU.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                                    v.Zp().nV("key_data_center_session_id");
                                    if (!(nU.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r0.equals(r6))) {
                                        ab.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            e.a((Context) this, data.toString(), i, bundle, new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18183);
                                    ab.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z))) {
                                        ciq ajE = ((z) mVar).ajE();
                                        if (!(ajE == null || WXCustomSchemeEntryActivity.this.isFinishing())) {
                                            t.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.string.tz) + " : " + bo.nullAsNil(ajE.xhy), 0).show();
                                        }
                                    }
                                    WXCustomSchemeEntryActivity.this.finish();
                                    AppMethodBeat.o(18183);
                                }
                            }, intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            obj = 1;
                            if (obj != null) {
                            }
                        } else {
                            host = r.Yz();
                            ab.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            e.a((Context) this, data.toString(), host, 23, data.toString(), new e.a() {
                                public final void a(int i, int i2, String str, m mVar, boolean z) {
                                    AppMethodBeat.i(18184);
                                    WXCustomSchemeEntryActivity.this.finish();
                                    AppMethodBeat.o(18184);
                                }
                            });
                        }
                    }
                    obj = null;
                    if (obj != null) {
                    }
                }
                break;
        }
        finish();
        AppMethodBeat.o(18188);
    }

    private String aVm() {
        AppMethodBeat.i(18189);
        String str;
        if (com.tencent.mm.compatible.util.d.iX(21)) {
            try {
                Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(this);
                AppMethodBeat.o(18189);
                return str;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", e, "", new Object[0]);
                str = "No referrer";
                AppMethodBeat.o(18189);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(18189);
        return str;
    }
}
