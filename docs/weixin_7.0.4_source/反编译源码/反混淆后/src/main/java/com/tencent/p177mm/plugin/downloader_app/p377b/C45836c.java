package com.tencent.p177mm.plugin.downloader_app.p377b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C45832c;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C27716g.C27717a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.c */
public class C45836c {

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.c$14 */
    static class C1151414 implements C27717a {
        C1151414() {
        }

        /* renamed from: gd */
        public final void mo23230gd(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.c$13 */
    static class C2033513 implements OnClickListener {
        C2033513() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136095);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(136095);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.c$9 */
    static class C277149 implements OnClickListener {
        C277149() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.c$7 */
    static class C339337 implements OnClickListener {
        C339337() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: a */
    public static void m84835a(Context context, C38861i c38861i) {
        AppMethodBeat.m2504i(138734);
        C45836c.m84837a(context, c38861i, false);
        AppMethodBeat.m2505o(138734);
    }

    /* renamed from: a */
    public static void m84837a(Context context, C38861i c38861i, boolean z) {
        AppMethodBeat.m2504i(136099);
        if (!z) {
            C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 23, c38861i.appId, "", "");
        }
        C45836c.m84841b(context, c38861i, z);
        AppMethodBeat.m2505o(136099);
    }

    /* renamed from: b */
    private static void m84841b(Context context, C38861i c38861i, boolean z) {
        AppMethodBeat.m2504i(138735);
        if (context == null || c38861i == null) {
            AppMethodBeat.m2505o(138735);
            return;
        }
        final C45833a c45833a = new C45833a();
        c45833a.downloadUrl = c38861i.kPc.egm;
        c45833a.kOB = c38861i.kPc.kKV;
        c45833a.appId = c38861i.appId;
        c45833a.appName = c38861i.appName;
        c45833a.kOC = c38861i.kPc.kKP;
        c45833a.kOD = c38861i.kPc.kKQ;
        c45833a.packageName = c38861i.kPc.kKO;
        c45833a.cBA = c38861i.kPc.kKR;
        c45833a.extInfo = C45836c.biI();
        c45833a.scene = z ? 6003 : 6002;
        c45833a.kNt = c38861i.kPc.kKX;
        c45833a.fileType = 1;
        C45405b.eBF.mo73200a(c45833a.appId, c45833a.scene, 9, -1, "", null);
        if (C5023at.isConnected(context)) {
            C45836c.m84834a(context, c45833a, null);
            AppMethodBeat.m2505o(138735);
            return;
        }
        C30379h.m48447a(context, context.getString(C25738R.string.d5t), context.getString(C25738R.string.d5u), context.getString(C25738R.string.ckt), false, new OnClickListener() {
            final /* synthetic */ C20332b kOH = null;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136085);
                C42911a In = C2895c.m5140In(c45833a.appId);
                if (In != null) {
                    In.field_status = 4;
                    C2895c.m5146e(In);
                } else {
                    In = new C42911a();
                    In.field_downloadId = System.currentTimeMillis();
                    In.field_appId = c45833a.appId;
                    In.field_downloadUrl = c45833a.downloadUrl;
                    In.field_status = 4;
                    C2895c.m5145d(In);
                }
                C42918d.m76215hD(In.field_downloadId);
                if (this.kOH != null) {
                    this.kOH.mo9713a(C20331a.FAIL, In.field_downloadId);
                }
                AppMethodBeat.m2505o(136085);
            }
        });
        AppMethodBeat.m2505o(138735);
    }

    /* renamed from: a */
    public static void m84834a(Context context, final C45833a c45833a, final C20332b c20332b) {
        AppMethodBeat.m2504i(136100);
        if (context == null || !c45833a.isValid()) {
            AppMethodBeat.m2505o(136100);
        } else if (C5023at.isWifi(context)) {
            C42918d.m76196IF(c45833a.appId);
            c45833a.kNt = false;
            C45836c.m84831a(c45833a, c20332b);
            AppMethodBeat.m2505o(136100);
        } else if (c45833a.kNt) {
            ((C45832c) C1720g.m3528K(C45832c.class)).mo68447a(context, c45833a.appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136092);
                    c45833a.kNt = false;
                    C45836c.m84831a(c45833a, c20332b);
                    AppMethodBeat.m2505o(136092);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136093);
                    C45836c.m84831a(c45833a, c20332b);
                    AppMethodBeat.m2505o(136093);
                }
            }, null);
            AppMethodBeat.m2505o(136100);
        } else {
            C30379h.m48446a(context, context.getString(C25738R.string.fy6), context.getString(C25738R.string.fy7), context.getString(C25738R.string.fy1), context.getString(C25738R.string.f9076or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136094);
                    C42918d.m76196IF(c45833a.appId);
                    c45833a.kNt = false;
                    C45836c.m84831a(c45833a, c20332b);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(136094);
                }
            }, new C2033513(), (int) C25738R.color.a61);
            AppMethodBeat.m2505o(136100);
        }
    }

    /* renamed from: a */
    public static long m84831a(C45833a c45833a, C20332b c20332b) {
        long b;
        AppMethodBeat.m2504i(136101);
        if (!C45837j.contains(c45833a.appId)) {
            LinkedList biP = C45837j.biP();
            biP.add(c45833a.appId);
            C27716g.m44026a(biP, new C1151414());
            C45837j.m84846Iz(c45833a.appId);
        }
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(c45833a.downloadUrl);
        c2901a.mo7056Iu(c45833a.kOB);
        c2901a.mo7066hA(c45833a.kOC);
        c2901a.mo7057Iv(c45833a.appName);
        c2901a.setAppId(c45833a.appId);
        c2901a.mo7058Iw(c45833a.kOD);
        c2901a.mo7063ga(true);
        c2901a.mo7064gb(false);
        c2901a.mo7069tN(c45833a.fileType == 0 ? 1 : c45833a.fileType);
        c2901a.mo7062cY(c45833a.packageName);
        c2901a.bis();
        c2901a.setScene(c45833a.scene);
        c2901a.mo7059Ix(c45833a.extInfo);
        c2901a.mo7065gc(c45833a.kNt);
        if (c45833a.cBA == 1) {
            b = C2896d.bij().mo7043b(c2901a.kNl);
        } else {
            b = C2896d.bij().mo7042a(c2901a.kNl);
        }
        C4990ab.m7417i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(b), c45833a.appId, Integer.valueOf(c45833a.cBA));
        if (c20332b != null) {
            C20331a c20331a = (!c45833a.kNt || C5023at.isWifi(C4996ah.getContext())) ? b > 0 ? C20331a.OK : C20331a.FAIL : C20331a.WAIT_FOR_WIFI;
            c20332b.mo9713a(c20331a, b);
        }
        if (c45833a.kNt && !C5023at.isWifi(C4996ah.getContext())) {
            C42918d.m76197IG(c45833a.appId);
        }
        C26483d.m42196b(10, "DownloadPluginUtil_downloadTaskStraight", C45836c.class.hashCode());
        AppMethodBeat.m2505o(136101);
        return b;
    }

    /* renamed from: a */
    public static void m84836a(Context context, C38861i c38861i, C20332b c20332b) {
        AppMethodBeat.m2504i(138736);
        C45836c.m84838a(context, c38861i, true, c20332b);
        AppMethodBeat.m2505o(138736);
    }

    /* renamed from: a */
    public static void m84838a(Context context, C38861i c38861i, boolean z, C20332b c20332b) {
        AppMethodBeat.m2504i(136102);
        C42911a In = C2895c.m5140In(c38861i.appId);
        if (In != null) {
            In.field_extInfo = C45836c.m84830IE(In.field_extInfo);
            C45836c.m84833a(context, In, c38861i, c20332b);
            C45405b.eBF.mo60568a(In.field_appId, In.field_scene, 10, In.field_startSize, In.field_downloadedSize - In.field_startSize, In.field_totalSize, In.field_downloadUrl, In.field_errCode, In.field_downloaderType, In.field_channelId, (System.currentTimeMillis() - In.field_startTime) / 1000, In.field_startState, In.field_downloadId, In.field_extInfo, 0);
        }
        if (z) {
            C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 6, c38861i.appId, "", "");
        }
        AppMethodBeat.m2505o(136102);
    }

    /* renamed from: a */
    public static void m84833a(Context context, final C42911a c42911a, final C38861i c38861i, final C20332b c20332b) {
        AppMethodBeat.m2504i(136103);
        if (!C5023at.isConnected(context)) {
            C30379h.m48447a(context, context.getString(C25738R.string.d5t), context.getString(C25738R.string.d5u), context.getString(C25738R.string.ckt), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136096);
                    c42911a.field_status = 4;
                    C2895c.m5146e(c42911a);
                    C42918d.m76215hD(c42911a.field_downloadId);
                    if (c20332b != null) {
                        c20332b.mo9713a(C20331a.FAIL, c42911a.field_downloadId);
                    }
                    if (c20332b != null) {
                        c20332b.mo9713a(C20331a.FAIL, c42911a.field_downloadId);
                    }
                    AppMethodBeat.m2505o(136096);
                }
            });
            AppMethodBeat.m2505o(136103);
        } else if (C5023at.isWifi(context)) {
            C42918d.m76196IF(c42911a.field_appId);
            C45836c.m84840a(c42911a, false, c20332b);
            AppMethodBeat.m2505o(136103);
        } else if (c38861i.kPc.kKX) {
            ((C45832c) C1720g.m3528K(C45832c.class)).mo68447a(context, c42911a.field_appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136097);
                    C42918d.m76196IF(c42911a.field_appId);
                    C45836c.m84840a(c42911a, false, c20332b);
                    AppMethodBeat.m2505o(136097);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136098);
                    if (!(c42911a.field_reserveInWifi && c42911a.field_downloadInWifi)) {
                        C42911a c42911a = c42911a;
                        c42911a.field_downloadInWifi = true;
                        c42911a.field_reserveInWifi = true;
                        C2895c.m5146e(c42911a);
                    }
                    c20332b.mo9713a(C20331a.WAIT_FOR_WIFI, c42911a.field_downloadId);
                    AppMethodBeat.m2505o(136098);
                }
            }, null);
            AppMethodBeat.m2505o(136103);
        } else {
            if (c42911a.field_reserveInWifi) {
                c42911a.field_downloadInWifi = false;
                c42911a.field_reserveInWifi = false;
                C2895c.m5146e(c42911a);
            }
            C30379h.m48446a(context, context.getString(C25738R.string.fy6), context.getString(C25738R.string.fy7), context.getString(C25738R.string.fy1), context.getString(C25738R.string.f9076or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136086);
                    C42918d.m76196IF(c42911a.field_appId);
                    C45836c.m84840a(c42911a, false, c20332b);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(136086);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136087);
                    if (c38861i != null) {
                        C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 4, c38861i.appId, "", "");
                    }
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(136087);
                }
            }, (int) C25738R.color.a61);
            AppMethodBeat.m2505o(136103);
        }
    }

    /* renamed from: a */
    public static boolean m84840a(C42911a c42911a, boolean z, C20332b c20332b) {
        AppMethodBeat.m2504i(136104);
        if (!C45837j.contains(c42911a.field_appId)) {
            LinkedList biP = C45837j.biP();
            biP.add(c42911a.field_appId);
            C27716g.m44026a(biP, null);
            C45837j.m84846Iz(c42911a.field_appId);
        }
        c42911a.field_showNotification = false;
        c42911a.field_fromDownloadApp = true;
        c42911a.field_downloadInWifi = z;
        c42911a.field_reserveInWifi = z;
        C2895c.m5146e(c42911a);
        boolean ho = C2896d.bij().mo7050ho(c42911a.field_downloadId);
        if (c20332b != null) {
            c20332b.mo9713a(ho ? C20331a.OK : C20331a.FAIL, c42911a.field_downloadId);
        }
        C26483d.m42196b(10, "DownloadPluginUtil_resumeDownloadTaskStraight", C45836c.class.hashCode());
        AppMethodBeat.m2505o(136104);
        return ho;
    }

    /* renamed from: a */
    public static void m84839a(C38861i c38861i) {
        AppMethodBeat.m2504i(136105);
        C42911a In = C2895c.m5140In(c38861i.appId);
        if (In != null) {
            C2896d.bij().mo7049hn(In.field_downloadId);
            C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 5, In.field_appId, "", "");
        }
        AppMethodBeat.m2505o(136105);
    }

    /* renamed from: b */
    public static void m84842b(C38861i c38861i) {
        AppMethodBeat.m2504i(138737);
        C42911a In = C2895c.m5140In(c38861i.appId);
        if (In != null) {
            C2896d.bij().mo7047hl(In.field_downloadId);
        }
        C45838a.m84850a(11, C45838a.m84852tQ(c38861i.type), c38861i.position, 81, c38861i.appId, "", "");
        AppMethodBeat.m2505o(138737);
    }

    /* renamed from: a */
    public static void m84832a(Context context, final long j, final C20332b c20332b) {
        AppMethodBeat.m2504i(138738);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            c20332b.mo9713a(C20331a.FAIL, -1);
            AppMethodBeat.m2505o(138738);
            return;
        }
        ((C45832c) C1720g.m3528K(C45832c.class)).mo68448b(context, hv.field_appId, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136088);
                C42918d.m76196IF(hv.field_appId);
                C45836c.m84840a(hv, false, c20332b);
                AppMethodBeat.m2505o(136088);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136089);
                C42911a c42911a = hv;
                hv.field_downloadInWifi = false;
                c42911a.field_reserveInWifi = false;
                C2895c.m5146e(hv);
                if (hv.field_status == 0) {
                    C42918d.m76198IH(hv.field_appId);
                }
                if (c20332b != null) {
                    c20332b.mo9713a(C20331a.CANCEL, j);
                }
                AppMethodBeat.m2505o(136089);
            }
        }, null);
        AppMethodBeat.m2505o(138738);
    }

    /* renamed from: b */
    public static boolean m84843b(final Context context, final C38861i c38861i) {
        AppMethodBeat.m2504i(136106);
        C42911a In = C2895c.m5140In(c38861i.appId);
        if (In == null) {
            AppMethodBeat.m2505o(136106);
            return false;
        } else if (C5730e.m8628ct(In.field_filePath)) {
            C33913a.m55499a(In.field_downloadId, false, null);
            C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 44, c38861i.appId, "", "");
            AppMethodBeat.m2505o(136106);
            return true;
        } else {
            C30379h.m48445a(context, context.getString(C25738R.string.db4), context.getString(C25738R.string.db5), context.getString(C25738R.string.dr0), context.getString(C25738R.string.ev9), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(136090);
                    C45836c.m84835a(context, c38861i);
                    AppMethodBeat.m2505o(136090);
                }
            }, new C339337());
            AppMethodBeat.m2505o(136106);
            return false;
        }
    }

    /* renamed from: c */
    public static void m84844c(final Context context, final C38861i c38861i) {
        AppMethodBeat.m2504i(138739);
        if (C35799p.m58695u(context, c38861i.kPc.kKO)) {
            C33913a.m55500a(context, c38861i.appId, null);
            C45838a.m84850a(10, C45838a.m84852tQ(c38861i.type), c38861i.position, 22, c38861i.appId, "", "");
            AppMethodBeat.m2505o(138739);
            return;
        }
        C30379h.m48445a(context, context.getString(C25738R.string.f9243u4), context.getString(C25738R.string.f9244u5), context.getString(C25738R.string.dr0), context.getString(C25738R.string.ev9), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(136091);
                C45836c.m84835a(context, c38861i);
                AppMethodBeat.m2505o(136091);
            }
        }, new C277149());
        AppMethodBeat.m2505o(138739);
    }

    private static String biI() {
        AppMethodBeat.m2504i(136107);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("DownloadInWidget", 1);
            jSONObject.put("OpInWidget", 1);
        } catch (JSONException e) {
        }
        String str = null;
        try {
            str = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e2) {
        }
        AppMethodBeat.m2505o(136107);
        return str;
    }

    /* renamed from: IE */
    private static String m84830IE(String str) {
        AppMethodBeat.m2504i(136108);
        if (str == null || !str.contains("OpInWidget")) {
            JSONObject jSONObject;
            String str2;
            if (C5046bo.isNullOrNil(str)) {
                jSONObject = null;
                str2 = str;
            } else {
                try {
                    str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e2) {
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("OpInWidget", 1);
            } catch (JSONException e3) {
            }
            try {
                str2 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e4) {
            }
            AppMethodBeat.m2505o(136108);
            return str2;
        }
        AppMethodBeat.m2505o(136108);
        return str;
    }
}
