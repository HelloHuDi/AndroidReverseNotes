package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C26270x;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C44057a;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35891h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.u */
public final class C30777u {
    static ProgressDialog ehJ = null;
    static SecurityImage gue = null;
    private static boolean ymX = false;

    /* renamed from: com.tencent.mm.ui.u$a */
    public static class C30784a {
        /* renamed from: a */
        public static boolean m49123a(final Context context, int i, int i2, String str, int i3) {
            AppMethodBeat.m2504i(29608);
            switch (i) {
                case 1:
                    if ((i3 & 2) != 0 && C9638aw.m17182Rg().acT()) {
                        C9638aw.m17182Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (!(((i3 & 1) != 0 && C32856ab.m53750ch(context) && C35891h.m58839fR(context)) || ((i3 & 4) != 0 && C5023at.isWap(context) && MMAppMgr.m7911hr(context)))) {
                        Toast.makeText(context, context.getString(C25738R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    AppMethodBeat.m2505o(29608);
                    return true;
                case 2:
                    Toast.makeText(context, context.getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    AppMethodBeat.m2505o(29608);
                    return true;
                case 3:
                    AppMethodBeat.m2505o(29608);
                    return true;
                case 4:
                    final C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        OnClickListener onClickListener;
                        C4990ab.m7417i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i2), Integer.valueOf(jY.showType), jY.url, jY.desc);
                        if (C5046bo.isNullOrNil(jY.url)) {
                            onClickListener = null;
                        } else {
                            onClickListener = new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(29607);
                                    Intent intent = new Intent();
                                    StringBuilder stringBuilder = new StringBuilder(jY.url);
                                    stringBuilder.append("&wechat_real_lang=" + C4988aa.dor());
                                    intent.putExtra("rawUrl", stringBuilder.toString());
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("needRedirect", false);
                                    intent.putExtra("neverGetA8Key", true);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.m2505o(29607);
                                }
                            };
                        }
                        if (jY.mo67668a(context, onClickListener, null)) {
                            AppMethodBeat.m2505o(29608);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(29608);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m49118a(final Activity activity, int i, int i2, final Intent intent, String str) {
        AppMethodBeat.m2504i(29609);
        if (i != 4) {
            AppMethodBeat.m2505o(29609);
            return false;
        }
        C4990ab.m7410d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                C4990ab.m7412e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(i2)));
                C30379h.m48431a((Context) activity, (int) C25738R.string.cvy, (int) C25738R.string.f9238tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29600);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            C5274b.m8044K(activity, intent);
                            C26529w.m42357cn(activity);
                        }
                        AppMethodBeat.m2505o(29600);
                    }
                });
                AppMethodBeat.m2505o(29609);
                return true;
            case -140:
            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                C4990ab.m7413e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i2), str);
                if (C5046bo.isNullOrNil(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == ZipJNI.UNZ_INTERNALERROR) {
                        C4990ab.m7417i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                }
                str = str.substring(16);
                if (!C5046bo.isNullOrNil(str) && str.startsWith("<")) {
                    Map z = C5049br.m7595z(str, "e");
                    if (!(z == null || C5046bo.isNullOrNil((String) z.get(".e.Content")))) {
                        str = (String) z.get(".e.Content");
                    }
                }
                if (C5046bo.isNullOrNil(str)) {
                    str = C4996ah.getContext().getString(C25738R.string.cvy);
                }
                C30379h.m48438a((Context) activity, str, C4996ah.getContext().getString(C25738R.string.f9238tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29606);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            C5274b.m8044K(activity, intent);
                            C26529w.m42357cn(activity);
                        }
                        AppMethodBeat.m2505o(29606);
                    }
                });
                AppMethodBeat.m2505o(29609);
                return true;
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                String QH = C9638aw.m17177QH();
                C4990ab.m7412e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + QH);
                C4879a.xxA.mo10055m(new C26270x());
                C1668a.hold();
                C26171jl c26171jl = new C26171jl();
                c26171jl.cEK.status = 0;
                c26171jl.cEK.boZ = 1;
                C4879a.xxA.mo10055m(c26171jl);
                C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
                String str2;
                if (ymX) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (C5046bo.isNullOrNil(QH)) {
                        str2 = "";
                    } else {
                        str2 = QH;
                    }
                    objArr[0] = str2;
                    C4990ab.m7417i(str3, str4, objArr);
                    AppMethodBeat.m2505o(29609);
                    return true;
                }
                if (!C5046bo.isNullOrNil(QH)) {
                    final C42124a jY = C42124a.m74268jY(QH);
                    if (jY != null) {
                        C4990ab.m7417i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", Integer.valueOf(jY.showType));
                        if ((jY.showType == 3 || jY.showType == 4) && jY.mo67668a(activity, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(29601);
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    if (C5046bo.isNullOrNil(jY.url)) {
                                        activity.startActivity(intent);
                                        C5274b.m8044K(activity, intent);
                                    } else {
                                        Intent intent = new Intent();
                                        StringBuilder stringBuilder = new StringBuilder(jY.url);
                                        stringBuilder.append("&wechat_real_lang=" + C4988aa.dor());
                                        intent.putExtra("rawUrl", stringBuilder.toString());
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("needRedirect", false);
                                        intent.putExtra("neverGetA8Key", true);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                        C25985d.m41467b(activity, "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    C26529w.m42357cn(activity);
                                    C45382z c45382z = new C45382z();
                                    c45382z.csU.csV = true;
                                    C4879a.xxA.mo10055m(c45382z);
                                }
                                AppMethodBeat.m2505o(29601);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(29602);
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    C5274b.m8044K(activity, intent);
                                    C26529w.m42357cn(activity);
                                }
                                AppMethodBeat.m2505o(29602);
                            }
                        })) {
                            ymX = true;
                            C4990ab.m7416i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            AppMethodBeat.m2505o(29609);
                            return true;
                        }
                    }
                }
                if (!C5046bo.isNullOrNil(QH) && QH.startsWith("<")) {
                    Map z2 = C5049br.m7595z(QH, "e");
                    if (!(z2 == null || C5046bo.isNullOrNil((String) z2.get(".e.Content")))) {
                        str2 = (String) z2.get(".e.Content");
                        C4990ab.m7416i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + z2);
                        QH = str2;
                    }
                }
                C4990ab.m7417i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", QH);
                if (C5046bo.isNullOrNil(QH)) {
                    QH = C1338a.m2858an(activity, C25738R.string.cvw);
                }
                C30379h.m48439a((Context) activity, QH, activity.getString(C25738R.string.f9238tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29603);
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            C5274b.m8044K(activity, intent);
                            C26529w.m42357cn(activity);
                            C45382z c45382z = new C45382z();
                            c45382z.csU.csV = true;
                            C4879a.xxA.mo10055m(c45382z);
                        }
                        AppMethodBeat.m2505o(29603);
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(29604);
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            C5274b.m8044K(activity, intent);
                            C26529w.m42357cn(activity);
                        }
                        AppMethodBeat.m2505o(29604);
                    }
                });
                ymX = true;
                C4990ab.m7416i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                AppMethodBeat.m2505o(29609);
                return true;
            case -75:
                C4990ab.m7412e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(i2)));
                C30379h.m48431a((Context) activity, (int) C25738R.string.f8809fm, (int) C25738R.string.f9238tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29605);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            C5274b.m8044K(activity, intent);
                            C26529w.m42357cn(activity);
                        }
                        AppMethodBeat.m2505o(29605);
                    }
                });
                AppMethodBeat.m2505o(29609);
                return true;
        }
        AppMethodBeat.m2505o(29609);
        return false;
    }

    /* renamed from: a */
    public static C5653c m49117a(final Activity activity, String str, final String str2, final Intent intent) {
        AppMethodBeat.m2504i(29610);
        C26171jl c26171jl = new C26171jl();
        c26171jl.cEK.status = 0;
        c26171jl.cEK.boZ = 1;
        C4879a.xxA.mo10055m(c26171jl);
        C5653c a = C30379h.m48439a((Context) activity, str, activity.getString(C25738R.string.f9238tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(29594);
                C7060h.pYm.mo8378a(322, 23, 1, true);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4023);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(C5046bo.isNullOrNil(str2)), str2});
                c7060h.mo8381e(11098, objArr);
                C9638aw.hold();
                if (C5046bo.isNullOrNil(str2)) {
                    activity.startActivity(intent);
                    C5274b.m8044K(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    C25985d.m41467b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                C26529w.m42357cn(activity);
                AppMethodBeat.m2505o(29594);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(29595);
                C7060h.pYm.mo8378a(322, 24, 1, true);
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(C5046bo.isNullOrNil(str2)), str2});
                c7060h.mo8381e(11098, objArr);
                activity.startActivity(intent);
                C5274b.m8044K(activity, intent);
                C26529w.m42357cn(activity);
                AppMethodBeat.m2505o(29595);
            }
        });
        AppMethodBeat.m2505o(29610);
        return a;
    }

    /* renamed from: as */
    public static boolean m49119as(Activity activity) {
        boolean z = true;
        AppMethodBeat.m2504i(29611);
        if (C5046bo.ank(C26373g.m41964Nu().getValue("SilentDownloadApkAtWiFi")) != 0) {
            AppMethodBeat.m2505o(29611);
            return false;
        }
        C9638aw.m17190ZK();
        boolean z2 = (((Integer) C18628c.m29072Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(C5023at.isWifi((Context) activity) && z2)) {
            z = false;
        }
        if ((C5059g.cdh & 1) != 0) {
            C4990ab.m7410d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            C4990ab.m7410d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && C30035i.dhX()) {
            boolean at = C30777u.m49120at(activity);
            AppMethodBeat.m2505o(29611);
            return at;
        }
        AppMethodBeat.m2505o(29611);
        return false;
    }

    /* renamed from: ht */
    public static boolean m49122ht(final Context context) {
        AppMethodBeat.m2504i(29612);
        final String dhU = C30035i.dhU();
        final int dhV = C30035i.dhV();
        C4990ab.m7417i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", dhU, Integer.valueOf(dhV));
        if (C5046bo.isNullOrNil(dhU) || C30035i.dhW()) {
            AppMethodBeat.m2505o(29612);
            return false;
        }
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.ui.u$3$1 */
            class C307741 implements Runnable {
                C307741() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(29596);
                    if (C21429d.bQU() != null) {
                        C21429d.bQU().mo36882ez(context);
                    }
                    AppMethodBeat.m2505o(29596);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(29597);
                if (dhV == 4 && C44057a.dhs() == null) {
                    C4990ab.m7420w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                    AppMethodBeat.m2505o(29597);
                    return;
                }
                if (!(C21429d.bQU() == null || C21429d.bQU().mo36875RP(dhU) == null)) {
                    C5004al.m7441d(new C307741());
                }
                AppMethodBeat.m2505o(29597);
            }
        });
        AppMethodBeat.m2505o(29612);
        return true;
    }

    /* renamed from: c */
    public static boolean m49121c(final Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(29613);
        C4990ab.m7421w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C7243d.vxo), Integer.valueOf(C5059g.cdf), Integer.valueOf(C5059g.cdh));
        if (i != 4) {
            AppMethodBeat.m2505o(29613);
            return false;
        }
        C21426a d;
        switch (i2) {
            case -17:
                long j = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                C4990ab.m7417i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j), Long.valueOf(C5046bo.m7549fp(j)));
                if (j != -1 && C5046bo.m7549fp(j) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                    AppMethodBeat.m2505o(29613);
                    return true;
                } else if ((C5059g.cdh & 2) != 0) {
                    C4990ab.m7410d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    AppMethodBeat.m2505o(29613);
                    return true;
                } else {
                    C4990ab.m7410d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    String value = C26373g.m41964Nu().getValue("SilentDownloadApkAtWiFi");
                    C9638aw.m17190ZK();
                    boolean z = ((((Integer) C18628c.m29072Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (C5046bo.isNullOrNil(value) || C5046bo.ank(value) == 0);
                    if ((C5059g.cdh & 1) != 0) {
                        C4990ab.m7410d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                        z = false;
                    } else {
                        C4990ab.m7410d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    }
                    if (C5046bo.ank(value) != 0) {
                        C4990ab.m7410d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                    }
                    C4990ab.m7411d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                    if (z) {
                        C7060h.pYm.mo8378a(405, 40, 1, true);
                        z = C30777u.m49120at(activity);
                        AppMethodBeat.m2505o(29613);
                        return z;
                    } else if (C21429d.bQU() != null) {
                        d = C21429d.bQU().mo36879d(activity, new OnCancelListener() {
                            final /* synthetic */ Intent ymY = null;

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(29599);
                                C7060h.pYm.mo8378a(405, 39, 1, true);
                                if (this.ymY != null) {
                                    activity.finish();
                                    activity.startActivity(this.ymY);
                                    C5274b.m8044K(activity, this.ymY);
                                }
                                AppMethodBeat.m2505o(29599);
                            }
                        });
                        C7060h.pYm.mo8378a(405, 38, 1, true);
                        d.update(2);
                        AppMethodBeat.m2505o(29613);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(29613);
                        return false;
                    }
                }
            case -16:
                if (C21429d.bQU() != null) {
                    d = C21429d.bQU().mo36879d(activity, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(29598);
                            C7060h.pYm.mo8378a(405, 37, 1, true);
                            activity.finish();
                            MMAppMgr.m7905bd(activity);
                            AppMethodBeat.m2505o(29598);
                        }
                    });
                    C7060h.pYm.mo8378a(405, 36, 1, true);
                    d.update(1);
                    AppMethodBeat.m2505o(29613);
                    return true;
                }
                AppMethodBeat.m2505o(29613);
                return false;
            default:
                AppMethodBeat.m2505o(29613);
                return false;
        }
    }

    /* renamed from: at */
    private static boolean m49120at(Activity activity) {
        AppMethodBeat.m2504i(29614);
        C44057a dhs = C44057a.dhs();
        if (dhs != null) {
            dhs.dhv();
            C4990ab.m7416i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            AppMethodBeat.m2505o(29614);
            return true;
        } else if (C21429d.bQU() != null) {
            C21429d.bQU().mo36881ey(activity).update(2);
            AppMethodBeat.m2505o(29614);
            return true;
        } else {
            AppMethodBeat.m2505o(29614);
            return false;
        }
    }
}
