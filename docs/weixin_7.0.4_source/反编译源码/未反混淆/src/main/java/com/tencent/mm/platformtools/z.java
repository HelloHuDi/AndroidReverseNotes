package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class z {
    public static void showAddrBookUploadConfirm(final Activity activity, final Runnable runnable, boolean z, final int i) {
        AppMethodBeat.i(124587);
        if (l.apS() != a.SUCC && l.apS() != a.SUCC_UNLOAD) {
            ab.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        } else if (bo.e((Boolean) g.RP().Ry().get(12322, null))) {
            ab.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
        } else if (z || !bo.e((Boolean) g.RP().Ry().get(12323, null))) {
            g.RP().Ry().set(12322, Boolean.FALSE);
            String nullAsNil = bo.nullAsNil(bo.gP(activity));
            if (nullAsNil.length() <= 0 || !nullAsNil.equals(g.RP().Ry().get(6, null))) {
                h.a((Context) activity, (int) R.string.a64, (int) R.string.tz, (int) R.string.up, (int) R.string.s2, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(124582);
                        ab.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.h.pYm.e(11438, Integer.valueOf(i));
                        g.RP().Ry().set(12322, Boolean.TRUE);
                        z.syncUploadMContactStatus(true, false);
                        a.anC();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ah.doA(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.o(124582);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(124583);
                        g.RP().Ry().set(12322, Boolean.FALSE);
                        z.syncUploadMContactStatus(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ah.doA(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.o(124583);
                    }
                });
                g.RP().Ry().set(12323, Boolean.TRUE);
                AppMethodBeat.o(124587);
                return;
            }
            g.RP().Ry().set(12322, Boolean.TRUE);
            ab.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
        } else {
            ab.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
        }
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(124587);
    }

    public static void syncUploadMContactStatus(boolean z, boolean z2) {
        AppMethodBeat.i(124588);
        int YD = r.YD();
        if (z) {
            YD &= -131073;
        } else {
            YD |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        ab.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(YD)));
        g.RP().Ry().set(7, Integer.valueOf(YD));
        YD = !z ? 1 : 2;
        act act = new act();
        act.wkw = 17;
        act.pvD = YD;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
        if (z2) {
            com.tencent.mm.plugin.account.a.a.gkF.BS();
        }
        AppMethodBeat.o(124588);
    }

    public static void vx(String str) {
        AppMethodBeat.i(124589);
        av.fly.ak("login_user_name", str);
        AppMethodBeat.o(124589);
    }

    public static void cu(final Context context) {
        AppMethodBeat.i(124590);
        String string = context.getString(R.string.fm);
        final String string2 = context.getString(R.string.fl);
        String string3 = context.getString(R.string.atd);
        String string4 = context.getString(R.string.atb);
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(124584);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                com.tencent.mm.plugin.account.a.a.gkE.i(intent, context);
                AppMethodBeat.o(124584);
            }
        };
        h.d(context, string, "", string3, string4, anonymousClass3, null);
        AppMethodBeat.o(124590);
    }

    public static void o(final Context context, String str, final String str2) {
        AppMethodBeat.i(124591);
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY != null) {
            jY.a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(124585);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    com.tencent.mm.plugin.account.a.a.gkE.i(intent, context);
                    AppMethodBeat.o(124585);
                }
            }, null);
        }
        AppMethodBeat.o(124591);
    }

    public static void a(Context context, q.a aVar, int i) {
        AppMethodBeat.i(124592);
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.cxb);
        intent.putExtra("KVoiceHelpUrl", aVar.fPp);
        intent.putExtra("KVoiceHelpWording", aVar.cEh);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.fPq != null) {
            intent.getExtras().putAll(aVar.fPq);
        }
        AppMethodBeat.o(124592);
    }

    public static void f(final Context context, String str, final int i) {
        AppMethodBeat.i(124593);
        final com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY == null) {
            AppMethodBeat.o(124593);
        } else if (jY.showType == 8) {
            com.tencent.mm.plugin.account.a.b.a.b(context, jY.url, i, false);
            AppMethodBeat.o(124593);
        } else {
            String string = context.getString(R.string.s6);
            String string2 = context.getString(R.string.or);
            AnonymousClass5 anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(124586);
                    com.tencent.mm.plugin.account.a.b.a.b(context, jY.url, i, false);
                    AppMethodBeat.o(124586);
                }
            };
            if (jY.showType == 1 || jY.showType == 4) {
                if (bo.isNullOrNil(jY.url)) {
                    h.b(context, jY.desc, jY.Title, true);
                    AppMethodBeat.o(124593);
                    return;
                }
                h.d(context, jY.desc, jY.Title, string, string2, anonymousClass5, null);
            }
            AppMethodBeat.o(124593);
        }
    }
}
