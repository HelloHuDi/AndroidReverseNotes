package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.z;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.ab;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.Map;

public final class u {
    static ProgressDialog ehJ = null;
    static SecurityImage gue = null;
    private static boolean ymX = false;

    public static class a {
        public static boolean a(final Context context, int i, int i2, String str, int i3) {
            AppMethodBeat.i(29608);
            switch (i) {
                case 1:
                    if ((i3 & 2) != 0 && aw.Rg().acT()) {
                        aw.Rg().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (!(((i3 & 1) != 0 && ab.ch(context) && h.fR(context)) || ((i3 & 4) != 0 && at.isWap(context) && MMAppMgr.hr(context)))) {
                        Toast.makeText(context, context.getString(R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    AppMethodBeat.o(29608);
                    return true;
                case 2:
                    Toast.makeText(context, context.getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    AppMethodBeat.o(29608);
                    return true;
                case 3:
                    AppMethodBeat.o(29608);
                    return true;
                case 4:
                    final com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        OnClickListener onClickListener;
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i2), Integer.valueOf(jY.showType), jY.url, jY.desc);
                        if (bo.isNullOrNil(jY.url)) {
                            onClickListener = null;
                        } else {
                            onClickListener = new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(29607);
                                    Intent intent = new Intent();
                                    StringBuilder stringBuilder = new StringBuilder(jY.url);
                                    stringBuilder.append("&wechat_real_lang=" + aa.dor());
                                    intent.putExtra("rawUrl", stringBuilder.toString());
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("needRedirect", false);
                                    intent.putExtra("neverGetA8Key", true);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                    d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.o(29607);
                                }
                            };
                        }
                        if (jY.a(context, onClickListener, null)) {
                            AppMethodBeat.o(29608);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(29608);
            return false;
        }
    }

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        AppMethodBeat.i(29609);
        if (i != 4) {
            AppMethodBeat.o(29609);
            return false;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(i2)));
                com.tencent.mm.ui.base.h.a((Context) activity, (int) R.string.cvy, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29600);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.K(activity, intent);
                            w.cn(activity);
                        }
                        AppMethodBeat.o(29600);
                    }
                });
                AppMethodBeat.o(29609);
                return true;
            case -140:
            case ZipJNI.UNZ_INTERNALERROR /*-104*/:
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i2), str);
                if (bo.isNullOrNil(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == ZipJNI.UNZ_INTERNALERROR) {
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                }
                str = str.substring(16);
                if (!bo.isNullOrNil(str) && str.startsWith("<")) {
                    Map z = br.z(str, "e");
                    if (!(z == null || bo.isNullOrNil((String) z.get(".e.Content")))) {
                        str = (String) z.get(".e.Content");
                    }
                }
                if (bo.isNullOrNil(str)) {
                    str = ah.getContext().getString(R.string.cvy);
                }
                com.tencent.mm.ui.base.h.a((Context) activity, str, ah.getContext().getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29606);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.K(activity, intent);
                            w.cn(activity);
                        }
                        AppMethodBeat.o(29606);
                    }
                });
                AppMethodBeat.o(29609);
                return true;
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                String QH = aw.QH();
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + QH);
                com.tencent.mm.sdk.b.a.xxA.m(new x());
                com.tencent.mm.kernel.a.hold();
                jl jlVar = new jl();
                jlVar.cEK.status = 0;
                jlVar.cEK.boZ = 1;
                com.tencent.mm.sdk.b.a.xxA.m(jlVar);
                ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
                String str2;
                if (ymX) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (bo.isNullOrNil(QH)) {
                        str2 = "";
                    } else {
                        str2 = QH;
                    }
                    objArr[0] = str2;
                    com.tencent.mm.sdk.platformtools.ab.i(str3, str4, objArr);
                    AppMethodBeat.o(29609);
                    return true;
                }
                if (!bo.isNullOrNil(QH)) {
                    final com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(QH);
                    if (jY != null) {
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", Integer.valueOf(jY.showType));
                        if ((jY.showType == 3 || jY.showType == 4) && jY.a(activity, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29601);
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    if (bo.isNullOrNil(jY.url)) {
                                        activity.startActivity(intent);
                                        b.K(activity, intent);
                                    } else {
                                        Intent intent = new Intent();
                                        StringBuilder stringBuilder = new StringBuilder(jY.url);
                                        stringBuilder.append("&wechat_real_lang=" + aa.dor());
                                        intent.putExtra("rawUrl", stringBuilder.toString());
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("needRedirect", false);
                                        intent.putExtra("neverGetA8Key", true);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                                        d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    w.cn(activity);
                                    z zVar = new z();
                                    zVar.csU.csV = true;
                                    com.tencent.mm.sdk.b.a.xxA.m(zVar);
                                }
                                AppMethodBeat.o(29601);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29602);
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    b.K(activity, intent);
                                    w.cn(activity);
                                }
                                AppMethodBeat.o(29602);
                            }
                        })) {
                            ymX = true;
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            AppMethodBeat.o(29609);
                            return true;
                        }
                    }
                }
                if (!bo.isNullOrNil(QH) && QH.startsWith("<")) {
                    Map z2 = br.z(QH, "e");
                    if (!(z2 == null || bo.isNullOrNil((String) z2.get(".e.Content")))) {
                        str2 = (String) z2.get(".e.Content");
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + z2);
                        QH = str2;
                    }
                }
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", QH);
                if (bo.isNullOrNil(QH)) {
                    QH = com.tencent.mm.bz.a.an(activity, R.string.cvw);
                }
                com.tencent.mm.ui.base.h.a((Context) activity, QH, activity.getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29603);
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            b.K(activity, intent);
                            w.cn(activity);
                            z zVar = new z();
                            zVar.csU.csV = true;
                            com.tencent.mm.sdk.b.a.xxA.m(zVar);
                        }
                        AppMethodBeat.o(29603);
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(29604);
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            b.K(activity, intent);
                            w.cn(activity);
                        }
                        AppMethodBeat.o(29604);
                    }
                });
                ymX = true;
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                AppMethodBeat.o(29609);
                return true;
            case -75:
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(i2)));
                com.tencent.mm.ui.base.h.a((Context) activity, (int) R.string.fm, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29605);
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.K(activity, intent);
                            w.cn(activity);
                        }
                        AppMethodBeat.o(29605);
                    }
                });
                AppMethodBeat.o(29609);
                return true;
        }
        AppMethodBeat.o(29609);
        return false;
    }

    public static c a(final Activity activity, String str, final String str2, final Intent intent) {
        AppMethodBeat.i(29610);
        jl jlVar = new jl();
        jlVar.cEK.status = 0;
        jlVar.cEK.boZ = 1;
        com.tencent.mm.sdk.b.a.xxA.m(jlVar);
        c a = com.tencent.mm.ui.base.h.a((Context) activity, str, activity.getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29594);
                com.tencent.mm.plugin.report.service.h.pYm.a(322, 23, 1, true);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4023);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bo.isNullOrNil(str2)), str2});
                hVar.e(11098, objArr);
                aw.hold();
                if (bo.isNullOrNil(str2)) {
                    activity.startActivity(intent);
                    b.K(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                w.cn(activity);
                AppMethodBeat.o(29594);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(29595);
                com.tencent.mm.plugin.report.service.h.pYm.a(322, 24, 1, true);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bo.isNullOrNil(str2)), str2});
                hVar.e(11098, objArr);
                activity.startActivity(intent);
                b.K(activity, intent);
                w.cn(activity);
                AppMethodBeat.o(29595);
            }
        });
        AppMethodBeat.o(29610);
        return a;
    }

    public static boolean as(Activity activity) {
        boolean z = true;
        AppMethodBeat.i(29611);
        if (bo.ank(g.Nu().getValue("SilentDownloadApkAtWiFi")) != 0) {
            AppMethodBeat.o(29611);
            return false;
        }
        aw.ZK();
        boolean z2 = (((Integer) com.tencent.mm.model.c.Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(at.isWifi((Context) activity) && z2)) {
            z = false;
        }
        if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && i.dhX()) {
            boolean at = at(activity);
            AppMethodBeat.o(29611);
            return at;
        }
        AppMethodBeat.o(29611);
        return false;
    }

    public static boolean ht(final Context context) {
        AppMethodBeat.i(29612);
        final String dhU = i.dhU();
        final int dhV = i.dhV();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", dhU, Integer.valueOf(dhV));
        if (bo.isNullOrNil(dhU) || i.dhW()) {
            AppMethodBeat.o(29612);
            return false;
        }
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(29597);
                if (dhV == 4 && com.tencent.mm.pluginsdk.model.app.a.dhs() == null) {
                    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                    AppMethodBeat.o(29597);
                    return;
                }
                if (!(com.tencent.mm.plugin.p.d.bQU() == null || com.tencent.mm.plugin.p.d.bQU().RP(dhU) == null)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29596);
                            if (com.tencent.mm.plugin.p.d.bQU() != null) {
                                com.tencent.mm.plugin.p.d.bQU().ez(context);
                            }
                            AppMethodBeat.o(29596);
                        }
                    });
                }
                AppMethodBeat.o(29597);
            }
        });
        AppMethodBeat.o(29612);
        return true;
    }

    public static boolean c(final Activity activity, int i, int i2) {
        AppMethodBeat.i(29613);
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vxo), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdh));
        if (i != 4) {
            AppMethodBeat.o(29613);
            return false;
        }
        com.tencent.mm.plugin.p.a d;
        switch (i2) {
            case -17:
                long j = ah.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j), Long.valueOf(bo.fp(j)));
                if (j != -1 && bo.fp(j) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                    AppMethodBeat.o(29613);
                    return true;
                } else if ((com.tencent.mm.sdk.platformtools.g.cdh & 2) != 0) {
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    AppMethodBeat.o(29613);
                    return true;
                } else {
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    String value = g.Nu().getValue("SilentDownloadApkAtWiFi");
                    aw.ZK();
                    boolean z = ((((Integer) com.tencent.mm.model.c.Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (bo.isNullOrNil(value) || bo.ank(value) == 0);
                    if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
                        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                        z = false;
                    } else {
                        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                    }
                    if (bo.ank(value) != 0) {
                        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                    }
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                    if (z) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(405, 40, 1, true);
                        z = at(activity);
                        AppMethodBeat.o(29613);
                        return z;
                    } else if (com.tencent.mm.plugin.p.d.bQU() != null) {
                        d = com.tencent.mm.plugin.p.d.bQU().d(activity, new OnCancelListener() {
                            final /* synthetic */ Intent ymY = null;

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(29599);
                                com.tencent.mm.plugin.report.service.h.pYm.a(405, 39, 1, true);
                                if (this.ymY != null) {
                                    activity.finish();
                                    activity.startActivity(this.ymY);
                                    b.K(activity, this.ymY);
                                }
                                AppMethodBeat.o(29599);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h.pYm.a(405, 38, 1, true);
                        d.update(2);
                        AppMethodBeat.o(29613);
                        return true;
                    } else {
                        AppMethodBeat.o(29613);
                        return false;
                    }
                }
            case -16:
                if (com.tencent.mm.plugin.p.d.bQU() != null) {
                    d = com.tencent.mm.plugin.p.d.bQU().d(activity, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(29598);
                            com.tencent.mm.plugin.report.service.h.pYm.a(405, 37, 1, true);
                            activity.finish();
                            MMAppMgr.bd(activity);
                            AppMethodBeat.o(29598);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.pYm.a(405, 36, 1, true);
                    d.update(1);
                    AppMethodBeat.o(29613);
                    return true;
                }
                AppMethodBeat.o(29613);
                return false;
            default:
                AppMethodBeat.o(29613);
                return false;
        }
    }

    private static boolean at(Activity activity) {
        AppMethodBeat.i(29614);
        com.tencent.mm.pluginsdk.model.app.a dhs = com.tencent.mm.pluginsdk.model.app.a.dhs();
        if (dhs != null) {
            dhs.dhv();
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            AppMethodBeat.o(29614);
            return true;
        } else if (com.tencent.mm.plugin.p.d.bQU() != null) {
            com.tencent.mm.plugin.p.d.bQU().ey(activity).update(2);
            AppMethodBeat.o(29614);
            return true;
        } else {
            AppMethodBeat.o(29614);
            return false;
        }
    }
}
