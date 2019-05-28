package com.tencent.p177mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C6686q.C6688a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.BioHelperUI;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.platformtools.z */
public final class C42257z {
    public static void showAddrBookUploadConfirm(final Activity activity, final Runnable runnable, boolean z, final int i) {
        AppMethodBeat.m2504i(124587);
        if (C38033l.apS() != C38034a.SUCC && C38033l.apS() != C38034a.SUCC_UNLOAD) {
            C4990ab.m7412e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        } else if (C5046bo.m7546e((Boolean) C1720g.m3536RP().mo5239Ry().get(12322, null))) {
            C4990ab.m7410d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
        } else if (z || !C5046bo.m7546e((Boolean) C1720g.m3536RP().mo5239Ry().get(12323, null))) {
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
            String nullAsNil = C5046bo.nullAsNil(C5046bo.m7554gP(activity));
            if (nullAsNil.length() <= 0 || !nullAsNil.equals(C1720g.m3536RP().mo5239Ry().get(6, null))) {
                C30379h.m48428a((Context) activity, (int) C25738R.string.a64, (int) C25738R.string.f9238tz, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(124582);
                        C4990ab.m7417i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(i));
                        C7060h.pYm.mo8381e(11438, Integer.valueOf(i));
                        C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
                        C42257z.syncUploadMContactStatus(true, false);
                        C45474a.anC();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.m2505o(124582);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(124583);
                        C1720g.m3536RP().mo5239Ry().set(12322, Boolean.FALSE);
                        C42257z.syncUploadMContactStatus(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                        AppMethodBeat.m2505o(124583);
                    }
                });
                C1720g.m3536RP().mo5239Ry().set(12323, Boolean.TRUE);
                AppMethodBeat.m2505o(124587);
                return;
            }
            C1720g.m3536RP().mo5239Ry().set(12322, Boolean.TRUE);
            C4990ab.m7416i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
        } else {
            C4990ab.m7410d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
        }
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.m2505o(124587);
    }

    public static void syncUploadMContactStatus(boolean z, boolean z2) {
        AppMethodBeat.m2504i(124588);
        int YD = C1853r.m3822YD();
        if (z) {
            YD &= -131073;
        } else {
            YD |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        C4990ab.m7410d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(YD)));
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(YD));
        YD = !z ? 1 : 2;
        act act = new act();
        act.wkw = 17;
        act.pvD = YD;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
        if (z2) {
            C24679a.gkF.mo38844BS();
        }
        AppMethodBeat.m2505o(124588);
    }

    /* renamed from: vx */
    public static void m74637vx(String str) {
        AppMethodBeat.m2504i(124589);
        C6665av.fly.mo14897ak("login_user_name", str);
        AppMethodBeat.m2505o(124589);
    }

    /* renamed from: cu */
    public static void m74634cu(final Context context) {
        AppMethodBeat.m2504i(124590);
        String string = context.getString(C25738R.string.f8809fm);
        final String string2 = context.getString(C25738R.string.f8808fl);
        String string3 = context.getString(C25738R.string.atd);
        String string4 = context.getString(C25738R.string.atb);
        C328913 c328913 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(124584);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                C24679a.gkE.mo38924i(intent, context);
                AppMethodBeat.m2505o(124584);
            }
        };
        C30379h.m48466d(context, string, "", string3, string4, c328913, null);
        AppMethodBeat.m2505o(124590);
    }

    /* renamed from: o */
    public static void m74636o(final Context context, String str, final String str2) {
        AppMethodBeat.m2504i(124591);
        C42124a jY = C42124a.m74268jY(str);
        if (jY != null) {
            jY.mo67668a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(124585);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    C24679a.gkE.mo38924i(intent, context);
                    AppMethodBeat.m2505o(124585);
                }
            }, null);
        }
        AppMethodBeat.m2505o(124591);
    }

    /* renamed from: a */
    public static void m74633a(Context context, C6688a c6688a, int i) {
        AppMethodBeat.m2504i(124592);
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", c6688a.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", c6688a.cxb);
        intent.putExtra("KVoiceHelpUrl", c6688a.fPp);
        intent.putExtra("KVoiceHelpWording", c6688a.cEh);
        intent.putExtra("Kusername", c6688a.username);
        if (c6688a.fPq != null) {
            intent.getExtras().putAll(c6688a.fPq);
        }
        AppMethodBeat.m2505o(124592);
    }

    /* renamed from: f */
    public static void m74635f(final Context context, String str, final int i) {
        AppMethodBeat.m2504i(124593);
        final C42124a jY = C42124a.m74268jY(str);
        if (jY == null) {
            AppMethodBeat.m2505o(124593);
        } else if (jY.showType == 8) {
            C32921a.m53856b(context, jY.url, i, false);
            AppMethodBeat.m2505o(124593);
        } else {
            String string = context.getString(C25738R.string.f9187s6);
            String string2 = context.getString(C25738R.string.f9076or);
            C187675 c187675 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(124586);
                    C32921a.m53856b(context, jY.url, i, false);
                    AppMethodBeat.m2505o(124586);
                }
            };
            if (jY.showType == 1 || jY.showType == 4) {
                if (C5046bo.isNullOrNil(jY.url)) {
                    C30379h.m48461b(context, jY.desc, jY.Title, true);
                    AppMethodBeat.m2505o(124593);
                    return;
                }
                C30379h.m48466d(context, jY.desc, jY.Title, string, string2, c187675, null);
            }
            AppMethodBeat.m2505o(124593);
        }
    }
}
