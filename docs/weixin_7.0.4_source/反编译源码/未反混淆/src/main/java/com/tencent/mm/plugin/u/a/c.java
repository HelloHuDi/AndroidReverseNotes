package com.tencent.mm.plugin.u.a;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.scanner.a.s;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class c {
    private static final SparseIntArray pAw = new SparseIntArray() {
        {
            AppMethodBeat.i(80761);
            put(2, 1012);
            put(1, 1013);
            AppMethodBeat.o(80761);
        }

        public final int get(int i) {
            AppMethodBeat.i(80762);
            int i2 = super.get(i, 1011);
            AppMethodBeat.o(80762);
            return i2;
        }
    };
    private static final SparseIntArray pAx = new SparseIntArray() {
        {
            AppMethodBeat.i(80763);
            put(2, 1048);
            put(1, 1049);
            AppMethodBeat.o(80763);
        }

        public final int get(int i) {
            AppMethodBeat.i(80764);
            int i2 = super.get(i, FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
            AppMethodBeat.o(80764);
            return i2;
        }
    };
    private static final SparseIntArray pAy = new SparseIntArray() {
        {
            AppMethodBeat.i(80765);
            put(2, 1125);
            put(1, 1126);
            AppMethodBeat.o(80765);
        }

        public final int get(int i) {
            AppMethodBeat.i(80766);
            int i2 = super.get(i, 1124);
            AppMethodBeat.o(80766);
            return i2;
        }
    };

    public interface a {
        Context getContext();

        void jZ(boolean z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final a aVar, h hVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        AppMethodBeat.i(80767);
        if (aVar.getContext() == null) {
            ab.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            AppMethodBeat.o(80767);
            return false;
        }
        int aiV = hVar.aiV();
        ab.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", Integer.valueOf(aiV), Integer.valueOf(((ado) hVar.ehh.fsG.fsP).vXI));
        ab.i("MicroMsg.scanner.GetA8KeyRedirect", "source=".concat(String.valueOf(i)));
        final Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        i.Lt(Bx(i));
        String aiT;
        String string;
        int i3;
        String aiT2;
        Intent I;
        switch (aiV) {
            case 1:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + hVar.getContent());
                intent.putExtra("data", hVar.getContent());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", Bx(i));
                intent.putExtra("geta8key_session_id", hVar.ajb());
                com.tencent.mm.plugin.scanner.c.gkE.i(intent, aVar.getContext());
                new ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.o(80767);
                return true;
            case 2:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + hVar.aiT());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                Object[] objArr = new Object[1];
                if (bo.isNullOrNil(str)) {
                    str = hVar.aiT();
                }
                objArr[0] = str;
                final h hVar2 = hVar;
                aiV = i2;
                final int i4 = i;
                final a aVar2 = aVar;
                com.tencent.mm.ui.base.h.a(context, context2.getString(R.string.dga, objArr), aVar.getContext().getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(80757);
                        intent.putExtra("title", hVar2.getTitle());
                        intent.putExtra("rawUrl", hVar2.aiT());
                        if (aiV == 2) {
                            intent.putExtra("stastic_scene", 13);
                        } else if (aiV == 1) {
                            intent.putExtra("stastic_scene", 14);
                        } else {
                            intent.putExtra("stastic_scene", 11);
                        }
                        intent.putExtra("pay_channel", c.Bx(i4));
                        intent.putExtra("geta8key_session_id", hVar2.ajb());
                        intent.putExtra("geta8key_cookie", hVar2.ajc());
                        com.tencent.mm.plugin.scanner.c.gkE.i(intent, aVar2.getContext());
                        AppMethodBeat.o(80757);
                    }
                }, onClickListener);
                AppMethodBeat.o(80767);
                return true;
            case 3:
                aiT = hVar.aiT();
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: ".concat(String.valueOf(aiT)));
                if (aiT == null || aiT.length() == 0) {
                    ab.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    AppMethodBeat.o(80767);
                    return false;
                }
                string = aVar.getContext().getString(R.string.dg_);
                if (aiT.startsWith("http")) {
                    string = aVar.getContext().getString(R.string.dga, new Object[]{aiT});
                }
                Uri parse = Uri.parse(aiT);
                if (parse != null) {
                    final Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(268435456);
                    if (bo.k(aVar.getContext(), intent2)) {
                        com.tencent.mm.ui.base.h.a(aVar.getContext(), string, aVar.getContext().getString(R.string.tz), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(80758);
                                aVar.getContext().startActivity(intent2);
                                AppMethodBeat.o(80758);
                            }
                        }, onClickListener);
                        AppMethodBeat.o(80767);
                        return true;
                    }
                }
                AppMethodBeat.o(80767);
                return false;
            case 4:
                AppMethodBeat.o(80767);
                return false;
            case 6:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + hVar.aiT());
                intent.putExtra("rawUrl", hVar.aiT());
                intent.putExtra("pay_channel", Bx(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", hVar.ajb());
                intent.putExtra("geta8key_cookie", hVar.ajc());
                com.tencent.mm.plugin.scanner.c.gkE.i(intent, aVar.getContext());
                AppMethodBeat.o(80767);
                return true;
            case 7:
            case 30:
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", hVar.aiU(), hVar.aiT(), hVar.aiX());
                intent.putExtra("title", hVar.getTitle());
                intent.putExtra("rawUrl", hVar.aiT());
                intent.putExtra("k_share_url", hVar.aiX());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : ".concat(String.valueOf(Bx(i))));
                intent.putExtra("pay_channel", Bx(i));
                intent.putExtra("geta8key_session_id", hVar.ajb());
                intent.putExtra("geta8key_cookie", hVar.ajc());
                List<atp> aja = hVar.aja();
                if (!bo.ek(aja)) {
                    Object obj;
                    for (atp atp : aja) {
                        atp atp2;
                        if (atp2 == null || bo.isNullOrNil(atp2.vMU)) {
                            ab.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                String[] strArr = new String[aja.size()];
                                String[] strArr2 = new String[aja.size()];
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 < aja.size()) {
                                        atp2 = (atp) aja.get(i5);
                                        ab.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", Integer.valueOf(i5), atp2.vMU, atp2.pXM);
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
                        } else if (bo.isNullOrNil(atp2.pXM)) {
                            ab.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                    }
                }
                if (aiV == 30 && ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_opensdk_qrcode_scan_auth_native, 0) == 1) {
                    intent.putExtra("auth_raw_url", str);
                    intent.putExtra("auth_from_scan", true);
                    d.b(aVar.getContext(), "webview", ".ui.tools.SDKOAuthUI", intent);
                    new ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                    AppMethodBeat.o(80767);
                    return true;
                }
                com.tencent.mm.plugin.scanner.c.gkE.i(intent, aVar.getContext());
                new ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.o(80767);
                return true;
            case 8:
                string = hVar.getContent();
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: ".concat(String.valueOf(string)));
                if (!bo.isNullOrNil(string)) {
                    try {
                        new s().We(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.jZ(false);
                        AppMethodBeat.o(80767);
                        return true;
                    } catch (XmlPullParserException e) {
                        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (IOException e2) {
                        ab.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        ab.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                com.tencent.mm.ui.base.h.a(aVar.getContext(), aVar.getContext().getString(R.string.dgj), aVar.getContext().getString(R.string.tz), false, onClickListener);
                AppMethodBeat.o(80767);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                boolean b = com.tencent.mm.plugin.scanner.c.gkE.b(aVar.getContext(), hVar.aiT(), bundle2);
                AppMethodBeat.o(80767);
                return b;
            case 10:
            case 11:
                a(aVar, aiV, hVar.aiT(), Bx(i));
                new ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.o(80767);
                return true;
            case 12:
            case 15:
                a(aVar, aiV, hVar.aiT(), Bx(i));
                AppMethodBeat.o(80767);
                return true;
            case 14:
                aiT = hVar.aiT();
                if (aiT != null) {
                    aiT = aiT.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", aiT);
                intent.putExtra("key_product_scene", 7);
                d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                AppMethodBeat.o(80767);
                return true;
            case 16:
                aiT2 = hVar.aiT();
                intent = new Intent().setClassName(ah.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
                I = bo.I(ah.getContext(), intent);
                if (I == null) {
                    I = intent;
                }
                d.aH(I.putExtra("url", aiT2).putExtra("isFromWifi", true));
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                AppMethodBeat.o(80767);
                return true;
            case 17:
                final Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", hVar.aiT());
                string = "free_wifi_mid";
                adp adp = (adp) hVar.ehh.fsH.fsP;
                if (adp == null || adp.vAI == null) {
                    ab.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    aiT = null;
                } else {
                    aiT = adp.vAI;
                }
                intent3.putExtra(string, aiT);
                string = "free_wifi_ssid";
                adp = (adp) hVar.ehh.fsH.fsP;
                if (adp == null || adp.SSID == null) {
                    ab.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    aiT = null;
                } else {
                    aiT = adp.SSID;
                }
                intent3.putExtra(string, aiT);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", hVar.aiT());
                if (g.RP().Ry().get(303104, null) != null) {
                    com.tencent.mm.ui.base.h.a(aVar.getContext(), (int) R.string.bzu, (int) R.string.tz, (int) R.string.ox, (int) R.string.or, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(80759);
                            d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                            aVar.jZ(false);
                            AppMethodBeat.o(80759);
                        }
                    }, onClickListener);
                } else {
                    d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.jZ(false);
                }
                AppMethodBeat.o(80767);
                return true;
            case 18:
                com.tencent.mm.plugin.scanner.util.r.a Wt = r.Wt(hVar.aiT());
                if (Wt == null) {
                    ab.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (r.sP(Wt.iAd)) {
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
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    ab.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    r.aQ(aVar.getContext(), aVar.getContext().getString(R.string.agb));
                }
                AppMethodBeat.o(80767);
                return false;
            case 20:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + hVar.aiT());
                g.Rg().a(new com.tencent.mm.ao.c(hVar.aiT()), 0);
                AppMethodBeat.o(80767);
                return true;
            case 21:
                I = new Intent();
                I.setClass(aVar.getContext(), ProductUI.class);
                I.putExtra("key_ProductUI_getProductInfoScene", 5);
                I.putExtra("key_Qrcode_Url", hVar.aiT());
                aVar.getContext().startActivity(I);
                AppMethodBeat.o(80767);
                return true;
            case 22:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + hVar.aiT());
                com.tencent.mm.pluginsdk.wallet.h.a(aVar.getContext(), 1, hVar.aiT(), Bx(i), null);
                new ak(Looper.getMainLooper()).postDelayed(runnable, 200);
                AppMethodBeat.o(80767);
                return true;
            case 23:
                aiT = hVar.aiT();
                if (bo.isNullOrNil(aiT)) {
                    ab.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    AppMethodBeat.o(80767);
                    return true;
                }
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", aiT);
                y yVar = new y();
                yVar.csT.url = aiT;
                com.tencent.mm.sdk.b.a.xxA.m(yVar);
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                AppMethodBeat.o(80767);
                return true;
            case 24:
                pt ptVar = new pt();
                ptVar.cLX.cLY = str;
                com.tencent.mm.sdk.b.a.xxA.m(ptVar);
                AppMethodBeat.o(80767);
                return true;
            case 25:
                aiT = hVar.aiT();
                ArrayList Wu = r.Wu(aiT);
                if (Wu == null || Wu.size() == 0) {
                    ab.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (r.Q(Wu)) {
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
                    d.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    ab.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    r.aQ(aVar.getContext(), aVar.getContext().getString(R.string.agb));
                }
                AppMethodBeat.o(80767);
                return false;
            case 26:
                string = hVar.aiT();
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: ".concat(String.valueOf(string)));
                Context context3 = aVar.getContext();
                ab.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: ".concat(String.valueOf(string)));
                Uri parse2 = Uri.parse(string);
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    SparseIntArray sparseIntArray;
                    if (bo.getInt(parse2.getQueryParameter("qr_type4wxa"), 0) != 2) {
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
                    ((f) g.K(f.class)).b(context3, string, sparseIntArray.get(i2), bundle);
                } else {
                    aiT = parse2.getQueryParameter("search_query");
                    aiT2 = parse2.getQueryParameter("appid");
                    String queryParameter = parse2.getQueryParameter("search_extInfo");
                    int i6 = bo.getInt(parse2.getQueryParameter("debug"), 0);
                    aiV = bo.getInt(parse2.getQueryParameter("version"), 0);
                    ll llVar = new ll();
                    llVar.cHk.scene = 1;
                    llVar.cHk.appId = aiT2;
                    llVar.cHk.type = i6;
                    llVar.cHk.version = aiV;
                    llVar.cHk.cHl = aiT;
                    llVar.cHk.url = string;
                    llVar.cHk.cHm = queryParameter;
                    com.tencent.mm.sdk.b.a.xxA.m(llVar);
                    Intent cVd = aa.cVd();
                    cVd.putExtra("ftsbizscene", 99999);
                    cVd.putExtra("ftsQuery", aiT);
                    cVd.putExtra("ftsqrcodestring", string);
                    Map d = aa.d(300, false, 262144);
                    d.put(SearchIntents.EXTRA_QUERY, aiT);
                    aiT = aa.HP(bo.ank((String) d.get("scene")));
                    d.put("sessionid", aiT);
                    cVd.putExtra("rawUrl", aa.E(d));
                    cVd.putExtra("key_session_id", aiT);
                    d.b(ah.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", cVd);
                }
                aVar.jZ(false);
                AppMethodBeat.o(80767);
                return true;
            default:
                ab.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + hVar.aiV());
                AppMethodBeat.o(80767);
                return false;
        }
    }

    private static void a(final a aVar, int i, String str, int i2) {
        AppMethodBeat.i(80768);
        ab.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", Integer.valueOf(i), str);
        final b heVar = new he();
        heVar.cBW.actionCode = i;
        heVar.cBW.result = str;
        heVar.cBW.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        heVar.cBW.cBY = bundle;
        heVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(80760);
                if (aVar == null || heVar == null || heVar.cBX == null) {
                    AppMethodBeat.o(80760);
                } else if (heVar.cBX.ret == 1) {
                    aVar.jZ(true);
                    AppMethodBeat.o(80760);
                } else {
                    if (heVar.cBX.ret == 2) {
                        aVar.jZ(false);
                    }
                    AppMethodBeat.o(80760);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(heVar, Looper.myLooper());
        AppMethodBeat.o(80768);
    }

    protected static int Bx(int i) {
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
        AppMethodBeat.i(80769);
        AppMethodBeat.o(80769);
    }
}
