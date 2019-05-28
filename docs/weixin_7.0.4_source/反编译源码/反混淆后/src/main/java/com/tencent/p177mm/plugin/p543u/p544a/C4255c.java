package com.tencent.p177mm.plugin.p543u.p544a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p1177ao.C17912c;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p230g.p231a.C37817y;
import com.tencent.p177mm.p230g.p231a.C45359pt;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.p504ui.ProductUI;
import com.tencent.p177mm.plugin.scanner.p504ui.VcardContactUI;
import com.tencent.p177mm.plugin.scanner.p740a.C46182s;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C28923r.C3773a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.ado;
import com.tencent.p177mm.protocal.protobuf.adp;
import com.tencent.p177mm.protocal.protobuf.atp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.mm.plugin.u.a.c */
public final class C4255c {
    private static final SparseIntArray pAw = new C42605();
    private static final SparseIntArray pAx = new C42626();
    private static final SparseIntArray pAy = new C42637();

    /* renamed from: com.tencent.mm.plugin.u.a.c$5 */
    static class C42605 extends SparseIntArray {
        C42605() {
            AppMethodBeat.m2504i(80761);
            put(2, 1012);
            put(1, 1013);
            AppMethodBeat.m2505o(80761);
        }

        public final int get(int i) {
            AppMethodBeat.m2504i(80762);
            int i2 = super.get(i, 1011);
            AppMethodBeat.m2505o(80762);
            return i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.u.a.c$a */
    public interface C4261a {
        Context getContext();

        /* renamed from: jZ */
        void mo9244jZ(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.u.a.c$6 */
    static class C42626 extends SparseIntArray {
        C42626() {
            AppMethodBeat.m2504i(80763);
            put(2, 1048);
            put(1, 1049);
            AppMethodBeat.m2505o(80763);
        }

        public final int get(int i) {
            AppMethodBeat.m2504i(80764);
            int i2 = super.get(i, FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
            AppMethodBeat.m2505o(80764);
            return i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.u.a.c$7 */
    static class C42637 extends SparseIntArray {
        C42637() {
            AppMethodBeat.m2504i(80765);
            put(2, 1125);
            put(1, 1126);
            AppMethodBeat.m2505o(80765);
        }

        public final int get(int i) {
            AppMethodBeat.m2504i(80766);
            int i2 = super.get(i, 1124);
            AppMethodBeat.m2505o(80766);
            return i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m6612a(final C4261a c4261a, C6681h c6681h, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        AppMethodBeat.m2504i(80767);
        if (c4261a.getContext() == null) {
            C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            AppMethodBeat.m2505o(80767);
            return false;
        }
        int aiV = c6681h.aiV();
        C4990ab.m7417i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", Integer.valueOf(aiV), Integer.valueOf(((ado) c6681h.ehh.fsG.fsP).vXI));
        C4990ab.m7416i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(i)));
        final Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        C14991i.m23324Lt(C4255c.m6610Bx(i));
        String aiT;
        String string;
        int i3;
        String aiT2;
        Intent I;
        switch (aiV) {
            case 1:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + c6681h.getContent());
                intent.putExtra("data", c6681h.getContent());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", C4255c.m6610Bx(i));
                intent.putExtra("geta8key_session_id", c6681h.ajb());
                C28892c.gkE.mo38924i(intent, c4261a.getContext());
                new C7306ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.m2505o(80767);
                return true;
            case 2:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + c6681h.aiT());
                Context context = c4261a.getContext();
                Context context2 = c4261a.getContext();
                Object[] objArr = new Object[1];
                if (C5046bo.isNullOrNil(str)) {
                    str = c6681h.aiT();
                }
                objArr[0] = str;
                final C6681h c6681h2 = c6681h;
                aiV = i2;
                final int i4 = i;
                final C4261a c4261a2 = c4261a;
                C30379h.m48440a(context, context2.getString(C25738R.string.dga, objArr), c4261a.getContext().getString(C25738R.string.f9238tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(80757);
                        intent.putExtra("title", c6681h2.getTitle());
                        intent.putExtra("rawUrl", c6681h2.aiT());
                        if (aiV == 2) {
                            intent.putExtra("stastic_scene", 13);
                        } else if (aiV == 1) {
                            intent.putExtra("stastic_scene", 14);
                        } else {
                            intent.putExtra("stastic_scene", 11);
                        }
                        intent.putExtra("pay_channel", C4255c.m6610Bx(i4));
                        intent.putExtra("geta8key_session_id", c6681h2.ajb());
                        intent.putExtra("geta8key_cookie", c6681h2.ajc());
                        C28892c.gkE.mo38924i(intent, c4261a2.getContext());
                        AppMethodBeat.m2505o(80757);
                    }
                }, onClickListener);
                AppMethodBeat.m2505o(80767);
                return true;
            case 3:
                aiT = c6681h.aiT();
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(aiT)));
                if (aiT == null || aiT.length() == 0) {
                    C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    AppMethodBeat.m2505o(80767);
                    return false;
                }
                string = c4261a.getContext().getString(C25738R.string.dg_);
                if (aiT.startsWith("http")) {
                    string = c4261a.getContext().getString(C25738R.string.dga, new Object[]{aiT});
                }
                Uri parse = Uri.parse(aiT);
                if (parse != null) {
                    final Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(268435456);
                    if (C5046bo.m7572k(c4261a.getContext(), intent2)) {
                        C30379h.m48449a(c4261a.getContext(), string, c4261a.getContext().getString(C25738R.string.f9238tz), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(80758);
                                c4261a.getContext().startActivity(intent2);
                                AppMethodBeat.m2505o(80758);
                            }
                        }, onClickListener);
                        AppMethodBeat.m2505o(80767);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(80767);
                return false;
            case 4:
                AppMethodBeat.m2505o(80767);
                return false;
            case 6:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + c6681h.aiT());
                intent.putExtra("rawUrl", c6681h.aiT());
                intent.putExtra("pay_channel", C4255c.m6610Bx(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", c6681h.ajb());
                intent.putExtra("geta8key_cookie", c6681h.ajc());
                C28892c.gkE.mo38924i(intent, c4261a.getContext());
                AppMethodBeat.m2505o(80767);
                return true;
            case 7:
            case 30:
                C4990ab.m7417i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", c6681h.aiU(), c6681h.aiT(), c6681h.aiX());
                intent.putExtra("title", c6681h.getTitle());
                intent.putExtra("rawUrl", c6681h.aiT());
                intent.putExtra("k_share_url", c6681h.aiX());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                C4990ab.m7416i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(C4255c.m6610Bx(i))));
                intent.putExtra("pay_channel", C4255c.m6610Bx(i));
                intent.putExtra("geta8key_session_id", c6681h.ajb());
                intent.putExtra("geta8key_cookie", c6681h.ajc());
                List<atp> aja = c6681h.aja();
                if (!C5046bo.m7548ek(aja)) {
                    Object obj;
                    for (atp atp : aja) {
                        atp atp2;
                        if (atp2 == null || C5046bo.isNullOrNil(atp2.vMU)) {
                            C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                String[] strArr = new String[aja.size()];
                                String[] strArr2 = new String[aja.size()];
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 < aja.size()) {
                                        atp2 = (atp) aja.get(i5);
                                        C4990ab.m7417i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", Integer.valueOf(i5), atp2.vMU, atp2.pXM);
                                        strArr[i5] = r9;
                                        strArr2[i5] = aiT;
                                        i3 = i5 + 1;
                                    } else {
                                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                        intent.putExtra("k_has_http_header", true);
                                    }
                                }
                            }
                        } else if (C5046bo.isNullOrNil(atp2.pXM)) {
                            C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                }
                if (aiV == 30 && ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_opensdk_qrcode_scan_auth_native, 0) == 1) {
                    intent.putExtra("auth_raw_url", str);
                    intent.putExtra("auth_from_scan", true);
                    C25985d.m41467b(c4261a.getContext(), "webview", ".ui.tools.SDKOAuthUI", intent);
                    new C7306ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                    AppMethodBeat.m2505o(80767);
                    return true;
                }
                C28892c.gkE.mo38924i(intent, c4261a.getContext());
                new C7306ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.m2505o(80767);
                return true;
            case 8:
                string = c6681h.getContent();
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(string)));
                if (!C5046bo.isNullOrNil(string)) {
                    try {
                        new C46182s().mo74170We(string);
                        c4261a.getContext().startActivity(new Intent(c4261a.getContext(), VcardContactUI.class));
                        c4261a.mo9244jZ(false);
                        AppMethodBeat.m2505o(80767);
                        return true;
                    } catch (XmlPullParserException e) {
                        C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        C4990ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (IOException e2) {
                        C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        C4990ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                C30379h.m48448a(c4261a.getContext(), c4261a.getContext().getString(C25738R.string.dgj), c4261a.getContext().getString(C25738R.string.f9238tz), false, onClickListener);
                AppMethodBeat.m2505o(80767);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                boolean b = C28892c.gkE.mo38905b(c4261a.getContext(), c6681h.aiT(), bundle2);
                AppMethodBeat.m2505o(80767);
                return b;
            case 10:
            case 11:
                C4255c.m6611a(c4261a, aiV, c6681h.aiT(), C4255c.m6610Bx(i));
                new C7306ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.m2505o(80767);
                return true;
            case 12:
            case 15:
                C4255c.m6611a(c4261a, aiV, c6681h.aiT(), C4255c.m6610Bx(i));
                AppMethodBeat.m2505o(80767);
                return true;
            case 14:
                aiT = c6681h.aiT();
                if (aiT != null) {
                    aiT = aiT.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", aiT);
                intent.putExtra("key_product_scene", 7);
                C25985d.m41467b(c4261a.getContext(), "product", ".ui.MallProductUI", intent);
                AppMethodBeat.m2505o(80767);
                return true;
            case 16:
                aiT2 = c6681h.aiT();
                intent = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
                I = C5046bo.m7503I(C4996ah.getContext(), intent);
                if (I == null) {
                    I = intent;
                }
                C25985d.m41463aH(I.putExtra("url", aiT2).putExtra("isFromWifi", true));
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                AppMethodBeat.m2505o(80767);
                return true;
            case 17:
                final Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", c6681h.aiT());
                string = "free_wifi_mid";
                adp adp = (adp) c6681h.ehh.fsH.fsP;
                if (adp == null || adp.vAI == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    aiT = null;
                } else {
                    aiT = adp.vAI;
                }
                intent3.putExtra(string, aiT);
                string = "free_wifi_ssid";
                adp = (adp) c6681h.ehh.fsH.fsP;
                if (adp == null || adp.SSID == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    aiT = null;
                } else {
                    aiT = adp.SSID;
                }
                intent3.putExtra(string, aiT);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", c6681h.aiT());
                if (C1720g.m3536RP().mo5239Ry().get(303104, null) != null) {
                    C30379h.m48428a(c4261a.getContext(), (int) C25738R.string.bzu, (int) C25738R.string.f9238tz, (int) C25738R.string.f9081ox, (int) C25738R.string.f9076or, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(80759);
                            C25985d.m41467b(c4261a.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                            c4261a.mo9244jZ(false);
                            AppMethodBeat.m2505o(80759);
                        }
                    }, onClickListener);
                } else {
                    C25985d.m41467b(c4261a.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    c4261a.mo9244jZ(false);
                }
                AppMethodBeat.m2505o(80767);
                return true;
            case 18:
                C3773a Wt = C28923r.m45943Wt(c6681h.aiT());
                if (Wt == null) {
                    C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (C28923r.m45947sP(Wt.iAd)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", Wt.kbU);
                    intent.putExtra("key_card_ext", Wt.cMD);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    C25985d.m41467b(c4261a.getContext(), "card", ".ui.CardDetailUI", intent);
                    C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    C28923r.m45945aQ(c4261a.getContext(), c4261a.getContext().getString(C25738R.string.agb));
                }
                AppMethodBeat.m2505o(80767);
                return false;
            case 20:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + c6681h.aiT());
                C1720g.m3540Rg().mo14541a(new C17912c(c6681h.aiT()), 0);
                AppMethodBeat.m2505o(80767);
                return true;
            case 21:
                I = new Intent();
                I.setClass(c4261a.getContext(), ProductUI.class);
                I.putExtra("key_ProductUI_getProductInfoScene", 5);
                I.putExtra("key_Qrcode_Url", c6681h.aiT());
                c4261a.getContext().startActivity(I);
                AppMethodBeat.m2505o(80767);
                return true;
            case 22:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + c6681h.aiT());
                C35899h.m58851a(c4261a.getContext(), 1, c6681h.aiT(), C4255c.m6610Bx(i), null);
                new C7306ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.m2505o(80767);
                return true;
            case 23:
                aiT = c6681h.aiT();
                if (C5046bo.isNullOrNil(aiT)) {
                    C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    AppMethodBeat.m2505o(80767);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", aiT);
                C37817y c37817y = new C37817y();
                c37817y.csT.url = aiT;
                C4879a.xxA.mo10055m(c37817y);
                C4990ab.m7416i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                AppMethodBeat.m2505o(80767);
                return true;
            case 24:
                C45359pt c45359pt = new C45359pt();
                c45359pt.cLX.cLY = str;
                C4879a.xxA.mo10055m(c45359pt);
                AppMethodBeat.m2505o(80767);
                return true;
            case 25:
                aiT = c6681h.aiT();
                ArrayList Wu = C28923r.m45944Wu(aiT);
                if (Wu == null || Wu.size() == 0) {
                    C4990ab.m7412e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (C28923r.m45941Q(Wu)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", aiT);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    C25985d.m41467b(c4261a.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    C28923r.m45945aQ(c4261a.getContext(), c4261a.getContext().getString(C25738R.string.agb));
                }
                AppMethodBeat.m2505o(80767);
                return false;
            case 26:
                string = c6681h.aiT();
                C4990ab.m7416i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(string)));
                Context context3 = c4261a.getContext();
                C4990ab.m7416i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(string)));
                Uri parse2 = Uri.parse(string);
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    SparseIntArray sparseIntArray;
                    if (C5046bo.getInt(parse2.getQueryParameter("qr_type4wxa"), 0) != 2) {
                        switch (i3) {
                            case 22:
                                sparseIntArray = pAx;
                                break;
                            default:
                                sparseIntArray = pAw;
                                break;
                        }
                    }
                    sparseIntArray = pAy;
                    ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(context3, string, sparseIntArray.get(i2), bundle);
                } else {
                    aiT = parse2.getQueryParameter("search_query");
                    aiT2 = parse2.getQueryParameter("appid");
                    String queryParameter = parse2.getQueryParameter("search_extInfo");
                    int i6 = C5046bo.getInt(parse2.getQueryParameter("debug"), 0);
                    aiV = C5046bo.getInt(parse2.getQueryParameter("version"), 0);
                    C26190ll c26190ll = new C26190ll();
                    c26190ll.cHk.scene = 1;
                    c26190ll.cHk.appId = aiT2;
                    c26190ll.cHk.type = i6;
                    c26190ll.cHk.version = aiV;
                    c26190ll.cHk.cHl = aiT;
                    c26190ll.cHk.url = string;
                    c26190ll.cHk.cHm = queryParameter;
                    C4879a.xxA.mo10055m(c26190ll);
                    Intent cVd = C46400aa.cVd();
                    cVd.putExtra("ftsbizscene", 99999);
                    cVd.putExtra("ftsQuery", aiT);
                    cVd.putExtra("ftsqrcodestring", string);
                    Map d = C46400aa.m87334d(300, false, 262144);
                    d.put(SearchIntents.EXTRA_QUERY, aiT);
                    aiT = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
                    d.put("sessionid", aiT);
                    cVd.putExtra("rawUrl", C46400aa.m87298E(d));
                    cVd.putExtra("key_session_id", aiT);
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", cVd);
                }
                c4261a.mo9244jZ(false);
                AppMethodBeat.m2505o(80767);
                return true;
            default:
                C4990ab.m7410d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + c6681h.aiV());
                AppMethodBeat.m2505o(80767);
                return false;
        }
    }

    /* renamed from: a */
    private static void m6611a(final C4261a c4261a, int i, String str, int i2) {
        AppMethodBeat.m2504i(80768);
        C4990ab.m7411d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", Integer.valueOf(i), str);
        final C4883b c26151he = new C26151he();
        c26151he.cBW.actionCode = i;
        c26151he.cBW.result = str;
        c26151he.cBW.context = c4261a.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        c26151he.cBW.cBY = bundle;
        c26151he.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80760);
                if (c4261a == null || c26151he == null || c26151he.cBX == null) {
                    AppMethodBeat.m2505o(80760);
                } else if (c26151he.cBX.ret == 1) {
                    c4261a.mo9244jZ(true);
                    AppMethodBeat.m2505o(80760);
                } else {
                    if (c26151he.cBX.ret == 2) {
                        c4261a.mo9244jZ(false);
                    }
                    AppMethodBeat.m2505o(80760);
                }
            }
        };
        C4879a.xxA.mo10048a(c26151he, Looper.myLooper());
        AppMethodBeat.m2505o(80768);
    }

    /* renamed from: Bx */
    protected static int m6610Bx(int i) {
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

    static {
        AppMethodBeat.m2504i(80769);
        AppMethodBeat.m2505o(80769);
    }
}
