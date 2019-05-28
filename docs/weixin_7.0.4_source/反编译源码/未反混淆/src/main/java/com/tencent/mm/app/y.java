package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.f;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.ui.LoginIndepPass;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.pluginsdk.ui.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.widget.a.c;

public final class y implements n {
    public final void a(Intent intent, Context context) {
        AppMethodBeat.i(15560);
        if (context == null) {
            AppMethodBeat.o(15560);
            return;
        }
        intent.setClassName(context, "com.tencent.mm.ui.contact.SayHiEditUI");
        context.startActivity(intent);
        AppMethodBeat.o(15560);
    }

    public final void b(Intent intent, Context context) {
        AppMethodBeat.i(15561);
        if (context == null) {
            AppMethodBeat.o(15561);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        d.f(context, ".ui.tools.MultiStageCitySelectUI", intent);
        AppMethodBeat.o(15561);
    }

    public final void bf(Context context) {
        AppMethodBeat.i(15562);
        d.b(context, "setting", ".ui.setting.EditSignatureUI", new Intent());
        AppMethodBeat.o(15562);
    }

    public final void c(Intent intent, Context context) {
        AppMethodBeat.i(15563);
        if (context == null) {
            AppMethodBeat.o(15563);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(15563);
    }

    public final void d(Intent intent, Context context) {
        AppMethodBeat.i(15564);
        if (context == null) {
            AppMethodBeat.o(15564);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        String stringExtra = intent.getStringExtra("Contact_User");
        if (stringExtra != null) {
            e.a(intent, stringExtra);
        }
        ab.i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", stringExtra, bo.dpG().toString());
        intent.setClass(context, ChattingUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(15564);
    }

    public final void e(Intent intent, Context context) {
        AppMethodBeat.i(15565);
        ab.i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", bo.dpG().toString());
        intent.setClass(context, ChattingUI.class);
        ((Activity) context).startActivityForResult(intent, 1);
        AppMethodBeat.o(15565);
    }

    public final void f(Intent intent, Context context) {
        AppMethodBeat.i(15566);
        if (context == null) {
            AppMethodBeat.o(15566);
            return;
        }
        intent.setClass(context, BindMContactIntroUI.class);
        MMWizardActivity.J(context, intent);
        AppMethodBeat.o(15566);
    }

    public final void g(Intent intent, Context context) {
        AppMethodBeat.i(15567);
        if (context == null) {
            AppMethodBeat.o(15567);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, BindQQUI.class);
        MMWizardActivity.J(context, intent);
        AppMethodBeat.o(15567);
    }

    public final void h(Intent intent, Context context) {
        AppMethodBeat.i(15568);
        intent.setClass(context, LauncherUI.class).addFlags(67108864);
        context.startActivity(intent);
        AppMethodBeat.o(15568);
    }

    public final void i(Intent intent, Context context) {
        AppMethodBeat.i(15569);
        if (context == null) {
            AppMethodBeat.o(15569);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(15569);
    }

    public final void j(Intent intent, Context context) {
        AppMethodBeat.i(15570);
        q.h(context, intent.getBundleExtra("reportArgs"));
        AppMethodBeat.o(15570);
    }

    public final c bg(Context context) {
        AppMethodBeat.i(15571);
        c bg = MMAppMgr.bg(context);
        AppMethodBeat.o(15571);
        return bg;
    }

    public final void k(Intent intent, Context context) {
        AppMethodBeat.i(15572);
        if (context != null) {
            if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
                intent.putExtra("Retr_Msg_Type", 4);
            }
            intent.setClass(context, MsgRetransmitUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(15572);
    }

    public final void l(Intent intent, Context context) {
        AppMethodBeat.i(15573);
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 2);
            d.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
        AppMethodBeat.o(15573);
    }

    public final void a(MMActivity mMActivity, String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        AppMethodBeat.i(15574);
        String string = mMActivity.getResources().getString(R.string.rs);
        string = new StringBuffer(string).append(wXMediaMessage.title).toString();
        a aVar = new a(mMActivity);
        aVar.cx(str2).ajC(string).KQ(R.string.atf);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str;
        final String str5 = str3;
        final String str6 = str2;
        final MMActivity mMActivity2 = mMActivity;
        aVar.h(Boolean.TRUE).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(15559);
                if (z) {
                    l.a(wXMediaMessage2, str4, str5, str6, 3, null);
                    if (!bo.isNullOrNil(str)) {
                        qb qbVar = new qb();
                        qbVar.cMq.cMr = str6;
                        qbVar.cMq.content = str;
                        qbVar.cMq.type = t.nK(str6);
                        qbVar.cMq.flags = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                    }
                    h.bQ(mMActivity2, mMActivity2.getResources().getString(R.string.to));
                    com.tencent.mm.plugin.report.service.h.pYm.X(10910, "2");
                    AppMethodBeat.o(15559);
                    return;
                }
                AppMethodBeat.o(15559);
            }
        }).gud.show();
        AppMethodBeat.o(15574);
    }

    public final void a(Intent intent, MMActivity mMActivity) {
        AppMethodBeat.i(15575);
        intent.setClass(mMActivity, SelectConversationUI.class);
        mMActivity.startActivityForResult(intent, 1);
        AppMethodBeat.o(15575);
    }

    public final void a(Intent intent, int i, MMActivity mMActivity, Intent intent2) {
        AppMethodBeat.i(15576);
        intent.setClassName(mMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
        aw.ZK();
        com.tencent.mm.ui.tools.a.a(mMActivity, intent2, intent, com.tencent.mm.model.c.XW(), i);
        AppMethodBeat.o(15576);
    }

    public final void a(Activity activity, Intent intent, int i) {
        AppMethodBeat.i(15578);
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            activity.startActivityForResult(intent, i);
        }
        AppMethodBeat.o(15578);
    }

    public final void a(Activity activity, Intent intent, Intent intent2, String str, int i, com.tencent.mm.ui.tools.a.a aVar) {
        AppMethodBeat.i(15579);
        if (activity != null) {
            intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            com.tencent.mm.ui.tools.a.b(activity, intent, intent2, str, i, aVar);
        }
        AppMethodBeat.o(15579);
    }

    public final void m(Intent intent, Context context) {
        AppMethodBeat.i(15580);
        if (context != null) {
            intent.setClass(context, ContactRemarkInfoModUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(15580);
    }

    public final void n(Intent intent, Context context) {
        AppMethodBeat.i(15581);
        if (context != null) {
            intent.setClass(context, ModRemarkNameUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(15581);
    }

    public final void a(Intent intent, Activity activity) {
        AppMethodBeat.i(15582);
        intent.setClass(activity, ModRemarkNameUI.class);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.o(15582);
    }

    public final void b(Intent intent, Activity activity) {
        AppMethodBeat.i(15583);
        if (activity != null) {
            intent.setClass(activity, CountryCodeUI.class);
            activity.startActivityForResult(intent, 100);
        }
        AppMethodBeat.o(15583);
    }

    public final void o(Intent intent, Context context) {
        AppMethodBeat.i(15584);
        if (context != null) {
            d.b(context, "setting", ".ui.setting.SettingsLanguageUI", intent);
        }
        AppMethodBeat.o(15584);
    }

    public final void p(Intent intent, Context context) {
        AppMethodBeat.i(15585);
        if (!(intent == null || context == null)) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
        AppMethodBeat.o(15585);
    }

    public final Intent bh(Context context) {
        AppMethodBeat.i(15586);
        Intent addFlags = new Intent(context, LauncherUI.class).addFlags(67108864);
        AppMethodBeat.o(15586);
        return addFlags;
    }

    public final void bi(Context context) {
        AppMethodBeat.i(15587);
        d.b(context, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
        AppMethodBeat.o(15587);
    }

    public final void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity) {
        AppMethodBeat.i(15588);
        if (mMActivity != null) {
            intent.setClass(mMActivity, SelectConversationUI.class);
            mMActivity.b(aVar, intent, 0);
        }
        AppMethodBeat.o(15588);
    }

    public final void q(Intent intent, Context context) {
        AppMethodBeat.i(15589);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
        AppMethodBeat.o(15589);
    }

    public final void r(Intent intent, Context context) {
        AppMethodBeat.i(15590);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        com.tencent.mm.pluginsdk.e.fC(context);
        AppMethodBeat.o(15590);
    }

    public final void s(Intent intent, Context context) {
        AppMethodBeat.i(15591);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.pluginapp.ContactSearchUI", intent2);
        }
        AppMethodBeat.o(15591);
    }

    public final void t(Intent intent, Context context) {
        AppMethodBeat.i(15592);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent2);
        }
        AppMethodBeat.o(15592);
    }

    public final void a(Intent intent, Activity activity, int i) {
        AppMethodBeat.i(15593);
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.contact.SnsAddressUI");
            activity.startActivityForResult(intent, i);
        }
        AppMethodBeat.o(15593);
    }

    public final void u(Intent intent, Context context) {
        AppMethodBeat.i(15594);
        intent.setClass(context, SnsLabelContactListUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(15594);
    }

    public final void a(boolean z, boolean z2, Context context, String str, int i, int i2) {
        AppMethodBeat.i(15595);
        if (!z && !z2) {
            Intent intent = new Intent();
            intent.putExtra("VideoPlayer_File_nam", str);
            intent.putExtra("VideoRecorder_VideoLength", i);
            intent.putExtra("VideoRecorder_VideoSize", i2);
            d.b(context, "subapp", ".ui.video.VideoPlayerUI", intent);
        } else if (!com.tencent.mm.pluginsdk.h.b.a.a.b(str, context, z2)) {
            Toast.makeText(context, context.getString(R.string.f1k), 0).show();
            AppMethodBeat.o(15595);
            return;
        }
        AppMethodBeat.o(15595);
    }

    public final void bj(Context context) {
        AppMethodBeat.i(15596);
        d.b(context, "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.o(15596);
    }

    public final void d(Context context, Intent intent) {
        AppMethodBeat.i(15597);
        if (context != null) {
            intent.setClass(context, ShowImageUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(15597);
    }

    public final void e(Context context, Intent intent) {
        AppMethodBeat.i(15598);
        if (context == null) {
            AppMethodBeat.o(15598);
            return;
        }
        d.b(context, "account", ".security.ui.MySafeDeviceListUI", intent);
        AppMethodBeat.o(15598);
    }

    public final void a(MMWizardActivity mMWizardActivity, Intent intent) {
        AppMethodBeat.i(15599);
        if (mMWizardActivity == null) {
            AppMethodBeat.o(15599);
            return;
        }
        intent.setClass(mMWizardActivity, MobileInputUI.class);
        MMWizardActivity.J(mMWizardActivity, intent);
        AppMethodBeat.o(15599);
    }

    public final void f(Context context, Intent intent) {
        AppMethodBeat.i(15600);
        if (context == null) {
            AppMethodBeat.o(15600);
            return;
        }
        intent.setClass(context, RegByMobileVoiceVerifyUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(15600);
    }

    public final void a(Context context, Intent intent, Intent intent2) {
        AppMethodBeat.i(15601);
        int intExtra = intent.getIntExtra("from_source", 1);
        if (intExtra == 1) {
            intent.setClass(context, LoginUI.class);
            context.startActivity(intent);
            AppMethodBeat.o(15601);
        } else if (intExtra == 2) {
            intent.setClass(context, LoginPasswordUI.class);
            context.startActivity(intent);
            AppMethodBeat.o(15601);
        } else if (intExtra == 3) {
            intent.setClass(context, SimpleLoginUI.class);
            if (intent2 != null) {
                MMWizardActivity.b(context, intent, intent2);
                AppMethodBeat.o(15601);
                return;
            }
            MMWizardActivity.J(context, intent);
            AppMethodBeat.o(15601);
        } else if (intExtra == 5) {
            intent.setClass(context, LoginIndepPass.class);
            context.startActivity(intent);
            AppMethodBeat.o(15601);
        } else {
            if (intExtra == 6) {
                intent.setClass(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("mobile_auth_type", 7);
                context.startActivity(intent);
            }
            AppMethodBeat.o(15601);
        }
    }

    public final void g(Context context, Intent intent) {
        AppMethodBeat.i(15602);
        if (context == null) {
            AppMethodBeat.o(15602);
            return;
        }
        d.a(context, "account", ".security.ui.SecurityAccountIntroUI", intent);
        AppMethodBeat.o(15602);
    }

    public final void h(Context context, Intent intent) {
        AppMethodBeat.i(15603);
        intent.setClassName(context, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
        context.startActivity(intent);
        AppMethodBeat.o(15603);
    }

    public final void a(Intent intent, int i, MMActivity.a aVar, MMActivity mMActivity) {
        AppMethodBeat.i(15605);
        if (mMActivity != null) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
            mMActivity.b(aVar, intent, i);
        }
        AppMethodBeat.o(15605);
    }

    public final void BV() {
        AppMethodBeat.i(15606);
        MMAppMgr.BV();
        AppMethodBeat.o(15606);
    }

    public final boolean b(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(15577);
        boolean a = r.a.vax.a(context, str, false, bundle);
        AppMethodBeat.o(15577);
        return a;
    }

    public final boolean b(Context context, String str, Object... objArr) {
        AppMethodBeat.i(15604);
        boolean c = r.a.vax.c(context, str, objArr);
        AppMethodBeat.o(15604);
        return c;
    }

    public final void cancelNotification(String str) {
        AppMethodBeat.i(15607);
        f.a.eec;
        if (str != null) {
            int id = b.IP().getId(str);
            ab.d("MicroMsg.Notification.Handle", "cancel : %s", str);
            b.IP().cancel(id);
        }
        AppMethodBeat.o(15607);
    }

    public final void v(Context context, String str) {
        AppMethodBeat.i(15608);
        r.a.vax.a(context, str, true);
        AppMethodBeat.o(15608);
    }
}
