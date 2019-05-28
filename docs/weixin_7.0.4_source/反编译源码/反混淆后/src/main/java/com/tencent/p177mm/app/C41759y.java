package com.tencent.p177mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.C18105f.C18104a;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.contact.ContactRemarkInfoModUI;
import com.tencent.p177mm.p612ui.contact.ModRemarkNameUI;
import com.tencent.p177mm.p612ui.contact.SnsLabelContactListUI;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.C36338a.C15946a;
import com.tencent.p177mm.p612ui.tools.CountryCodeUI;
import com.tencent.p177mm.p612ui.tools.ShowImageUI;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindQQUI;
import com.tencent.p177mm.plugin.account.p275ui.LoginIndepPass;
import com.tencent.p177mm.plugin.account.p275ui.LoginPasswordUI;
import com.tencent.p177mm.plugin.account.p275ui.LoginUI;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileVoiceVerifyUI;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C44070r.C23257a;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p1080h.p1571b.p1572a.C40434a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C46506q;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.app.y */
public final class C41759y implements C23255n {
    /* renamed from: a */
    public final void mo38897a(Intent intent, Context context) {
        AppMethodBeat.m2504i(15560);
        if (context == null) {
            AppMethodBeat.m2505o(15560);
            return;
        }
        intent.setClassName(context, "com.tencent.mm.ui.contact.SayHiEditUI");
        context.startActivity(intent);
        AppMethodBeat.m2505o(15560);
    }

    /* renamed from: b */
    public final void mo38904b(Intent intent, Context context) {
        AppMethodBeat.m2504i(15561);
        if (context == null) {
            AppMethodBeat.m2505o(15561);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        C25985d.m41473f(context, ".ui.tools.MultiStageCitySelectUI", intent);
        AppMethodBeat.m2505o(15561);
    }

    /* renamed from: bf */
    public final void mo38907bf(Context context) {
        AppMethodBeat.m2504i(15562);
        C25985d.m41467b(context, "setting", ".ui.setting.EditSignatureUI", new Intent());
        AppMethodBeat.m2505o(15562);
    }

    /* renamed from: c */
    public final void mo38912c(Intent intent, Context context) {
        AppMethodBeat.m2504i(15563);
        if (context == null) {
            AppMethodBeat.m2505o(15563);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(15563);
    }

    /* renamed from: d */
    public final void mo38915d(Intent intent, Context context) {
        AppMethodBeat.m2504i(15564);
        if (context == null) {
            AppMethodBeat.m2505o(15564);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        String stringExtra = intent.getStringExtra("Contact_User");
        if (stringExtra != null) {
            C36249e.m59677a(intent, stringExtra);
        }
        C4990ab.m7417i("MicroMsg.WorkerUICallbackImpl", "startChattingUI %s %s", stringExtra, C5046bo.dpG().toString());
        intent.setClass(context, ChattingUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(15564);
    }

    /* renamed from: e */
    public final void mo38917e(Intent intent, Context context) {
        AppMethodBeat.m2504i(15565);
        C4990ab.m7417i("MicroMsg.WorkerUICallbackImpl with result", "startChattingUI %s", C5046bo.dpG().toString());
        intent.setClass(context, ChattingUI.class);
        ((Activity) context).startActivityForResult(intent, 1);
        AppMethodBeat.m2505o(15565);
    }

    /* renamed from: f */
    public final void mo38919f(Intent intent, Context context) {
        AppMethodBeat.m2504i(15566);
        if (context == null) {
            AppMethodBeat.m2505o(15566);
            return;
        }
        intent.setClass(context, BindMContactIntroUI.class);
        MMWizardActivity.m23791J(context, intent);
        AppMethodBeat.m2505o(15566);
    }

    /* renamed from: g */
    public final void mo38921g(Intent intent, Context context) {
        AppMethodBeat.m2504i(15567);
        if (context == null) {
            AppMethodBeat.m2505o(15567);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, BindQQUI.class);
        MMWizardActivity.m23791J(context, intent);
        AppMethodBeat.m2505o(15567);
    }

    /* renamed from: h */
    public final void mo38923h(Intent intent, Context context) {
        AppMethodBeat.m2504i(15568);
        intent.setClass(context, LauncherUI.class).addFlags(67108864);
        context.startActivity(intent);
        AppMethodBeat.m2505o(15568);
    }

    /* renamed from: i */
    public final void mo38924i(Intent intent, Context context) {
        AppMethodBeat.m2504i(15569);
        if (context == null) {
            AppMethodBeat.m2505o(15569);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(15569);
    }

    /* renamed from: j */
    public final void mo38925j(Intent intent, Context context) {
        AppMethodBeat.m2504i(15570);
        C46506q.m87790h(context, intent.getBundleExtra("reportArgs"));
        AppMethodBeat.m2505o(15570);
    }

    /* renamed from: bg */
    public final C5653c mo38908bg(Context context) {
        AppMethodBeat.m2504i(15571);
        C5653c bg = MMAppMgr.m7907bg(context);
        AppMethodBeat.m2505o(15571);
        return bg;
    }

    /* renamed from: k */
    public final void mo38926k(Intent intent, Context context) {
        AppMethodBeat.m2504i(15572);
        if (context != null) {
            if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
                intent.putExtra("Retr_Msg_Type", 4);
            }
            intent.setClass(context, MsgRetransmitUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(15572);
    }

    /* renamed from: l */
    public final void mo38927l(Intent intent, Context context) {
        AppMethodBeat.m2504i(15573);
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 2);
            C25985d.m41467b(context, "sns", ".ui.SnsUploadUI", intent);
        }
        AppMethodBeat.m2505o(15573);
    }

    /* renamed from: a */
    public final void mo38900a(MMActivity mMActivity, String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        AppMethodBeat.m2504i(15574);
        String string = mMActivity.getResources().getString(C25738R.string.f9174rs);
        string = new StringBuffer(string).append(wXMediaMessage.title).toString();
        C23273a c23273a = new C23273a(mMActivity);
        c23273a.mo38972cx(str2).ajC(string).mo38965KQ(C25738R.string.atf);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str;
        final String str5 = str3;
        final String str6 = str2;
        final MMActivity mMActivity2 = mMActivity;
        c23273a.mo38977h(Boolean.TRUE).mo38966a(new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(15559);
                if (z) {
                    C4733l.m7090a(wXMediaMessage2, str4, str5, str6, 3, null);
                    if (!C5046bo.isNullOrNil(str)) {
                        C18372qb c18372qb = new C18372qb();
                        c18372qb.cMq.cMr = str6;
                        c18372qb.cMq.content = str;
                        c18372qb.cMq.type = C1855t.m3925nK(str6);
                        c18372qb.cMq.flags = 0;
                        C4879a.xxA.mo10055m(c18372qb);
                    }
                    C30379h.m48465bQ(mMActivity2, mMActivity2.getResources().getString(C25738R.string.f9229to));
                    C7060h.pYm.mo8374X(10910, "2");
                    AppMethodBeat.m2505o(15559);
                    return;
                }
                AppMethodBeat.m2505o(15559);
            }
        }).gud.show();
        AppMethodBeat.m2505o(15574);
    }

    /* renamed from: a */
    public final void mo38899a(Intent intent, MMActivity mMActivity) {
        AppMethodBeat.m2504i(15575);
        intent.setClass(mMActivity, SelectConversationUI.class);
        mMActivity.startActivityForResult(intent, 1);
        AppMethodBeat.m2505o(15575);
    }

    /* renamed from: a */
    public final void mo38894a(Intent intent, int i, MMActivity mMActivity, Intent intent2) {
        AppMethodBeat.m2504i(15576);
        intent.setClassName(mMActivity, "com.tencent.mm.ui.tools.CropImageNewUI");
        C9638aw.m17190ZK();
        C36338a.m59822a(mMActivity, intent2, intent, C18628c.m29088XW(), i);
        AppMethodBeat.m2505o(15576);
    }

    /* renamed from: a */
    public final void mo38890a(Activity activity, Intent intent, int i) {
        AppMethodBeat.m2504i(15578);
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            activity.startActivityForResult(intent, i);
        }
        AppMethodBeat.m2505o(15578);
    }

    /* renamed from: a */
    public final void mo38891a(Activity activity, Intent intent, Intent intent2, String str, int i, C15946a c15946a) {
        AppMethodBeat.m2504i(15579);
        if (activity != null) {
            intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
            C36338a.m59823b(activity, intent, intent2, str, i, c15946a);
        }
        AppMethodBeat.m2505o(15579);
    }

    /* renamed from: m */
    public final void mo38928m(Intent intent, Context context) {
        AppMethodBeat.m2504i(15580);
        if (context != null) {
            intent.setClass(context, ContactRemarkInfoModUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(15580);
    }

    /* renamed from: n */
    public final void mo38929n(Intent intent, Context context) {
        AppMethodBeat.m2504i(15581);
        if (context != null) {
            intent.setClass(context, ModRemarkNameUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(15581);
    }

    /* renamed from: a */
    public final void mo38895a(Intent intent, Activity activity) {
        AppMethodBeat.m2504i(15582);
        intent.setClass(activity, ModRemarkNameUI.class);
        activity.startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(15582);
    }

    /* renamed from: b */
    public final void mo38903b(Intent intent, Activity activity) {
        AppMethodBeat.m2504i(15583);
        if (activity != null) {
            intent.setClass(activity, CountryCodeUI.class);
            activity.startActivityForResult(intent, 100);
        }
        AppMethodBeat.m2505o(15583);
    }

    /* renamed from: o */
    public final void mo38930o(Intent intent, Context context) {
        AppMethodBeat.m2504i(15584);
        if (context != null) {
            C25985d.m41467b(context, "setting", ".ui.setting.SettingsLanguageUI", intent);
        }
        AppMethodBeat.m2505o(15584);
    }

    /* renamed from: p */
    public final void mo38931p(Intent intent, Context context) {
        AppMethodBeat.m2504i(15585);
        if (!(intent == null || context == null)) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(15585);
    }

    /* renamed from: bh */
    public final Intent mo38909bh(Context context) {
        AppMethodBeat.m2504i(15586);
        Intent addFlags = new Intent(context, LauncherUI.class).addFlags(67108864);
        AppMethodBeat.m2505o(15586);
        return addFlags;
    }

    /* renamed from: bi */
    public final void mo38910bi(Context context) {
        AppMethodBeat.m2504i(15587);
        C25985d.m41467b(context, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
        AppMethodBeat.m2505o(15587);
    }

    /* renamed from: a */
    public final void mo38898a(Intent intent, C5186a c5186a, MMActivity mMActivity) {
        AppMethodBeat.m2504i(15588);
        if (mMActivity != null) {
            intent.setClass(mMActivity, SelectConversationUI.class);
            mMActivity.mo17391b(c5186a, intent, 0);
        }
        AppMethodBeat.m2505o(15588);
    }

    /* renamed from: q */
    public final void mo38932q(Intent intent, Context context) {
        AppMethodBeat.m2504i(15589);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        C25985d.m41467b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
        AppMethodBeat.m2505o(15589);
    }

    /* renamed from: r */
    public final void mo38933r(Intent intent, Context context) {
        AppMethodBeat.m2504i(15590);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        C14827e.m23078fC(context);
        AppMethodBeat.m2505o(15590);
    }

    /* renamed from: s */
    public final void mo38934s(Intent intent, Context context) {
        AppMethodBeat.m2504i(15591);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            C25985d.m41467b(context, "subapp", ".ui.pluginapp.ContactSearchUI", intent2);
        }
        AppMethodBeat.m2505o(15591);
    }

    /* renamed from: t */
    public final void mo38935t(Intent intent, Context context) {
        AppMethodBeat.m2504i(15592);
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            C25985d.m41467b(context, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent2);
        }
        AppMethodBeat.m2505o(15592);
    }

    /* renamed from: a */
    public final void mo38896a(Intent intent, Activity activity, int i) {
        AppMethodBeat.m2504i(15593);
        if (activity != null) {
            intent.setClassName(activity, "com.tencent.mm.ui.contact.SnsAddressUI");
            activity.startActivityForResult(intent, i);
        }
        AppMethodBeat.m2505o(15593);
    }

    /* renamed from: u */
    public final void mo38936u(Intent intent, Context context) {
        AppMethodBeat.m2504i(15594);
        intent.setClass(context, SnsLabelContactListUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(15594);
    }

    /* renamed from: a */
    public final void mo38902a(boolean z, boolean z2, Context context, String str, int i, int i2) {
        AppMethodBeat.m2504i(15595);
        if (!z && !z2) {
            Intent intent = new Intent();
            intent.putExtra("VideoPlayer_File_nam", str);
            intent.putExtra("VideoRecorder_VideoLength", i);
            intent.putExtra("VideoRecorder_VideoSize", i2);
            C25985d.m41467b(context, "subapp", ".ui.video.VideoPlayerUI", intent);
        } else if (!C40434a.m69348b(str, context, z2)) {
            Toast.makeText(context, context.getString(C25738R.string.f1k), 0).show();
            AppMethodBeat.m2505o(15595);
            return;
        }
        AppMethodBeat.m2505o(15595);
    }

    /* renamed from: bj */
    public final void mo38911bj(Context context) {
        AppMethodBeat.m2504i(15596);
        C25985d.m41467b(context, "subapp", ".ui.openapi.AddAppUI", new Intent());
        AppMethodBeat.m2505o(15596);
    }

    /* renamed from: d */
    public final void mo38914d(Context context, Intent intent) {
        AppMethodBeat.m2504i(15597);
        if (context != null) {
            intent.setClass(context, ShowImageUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(15597);
    }

    /* renamed from: e */
    public final void mo38916e(Context context, Intent intent) {
        AppMethodBeat.m2504i(15598);
        if (context == null) {
            AppMethodBeat.m2505o(15598);
            return;
        }
        C25985d.m41467b(context, "account", ".security.ui.MySafeDeviceListUI", intent);
        AppMethodBeat.m2505o(15598);
    }

    /* renamed from: a */
    public final void mo38901a(MMWizardActivity mMWizardActivity, Intent intent) {
        AppMethodBeat.m2504i(15599);
        if (mMWizardActivity == null) {
            AppMethodBeat.m2505o(15599);
            return;
        }
        intent.setClass(mMWizardActivity, MobileInputUI.class);
        MMWizardActivity.m23791J(mMWizardActivity, intent);
        AppMethodBeat.m2505o(15599);
    }

    /* renamed from: f */
    public final void mo38918f(Context context, Intent intent) {
        AppMethodBeat.m2504i(15600);
        if (context == null) {
            AppMethodBeat.m2505o(15600);
            return;
        }
        intent.setClass(context, RegByMobileVoiceVerifyUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(15600);
    }

    /* renamed from: a */
    public final void mo38892a(Context context, Intent intent, Intent intent2) {
        AppMethodBeat.m2504i(15601);
        int intExtra = intent.getIntExtra("from_source", 1);
        if (intExtra == 1) {
            intent.setClass(context, LoginUI.class);
            context.startActivity(intent);
            AppMethodBeat.m2505o(15601);
        } else if (intExtra == 2) {
            intent.setClass(context, LoginPasswordUI.class);
            context.startActivity(intent);
            AppMethodBeat.m2505o(15601);
        } else if (intExtra == 3) {
            intent.setClass(context, SimpleLoginUI.class);
            if (intent2 != null) {
                MMWizardActivity.m23792b(context, intent, intent2);
                AppMethodBeat.m2505o(15601);
                return;
            }
            MMWizardActivity.m23791J(context, intent);
            AppMethodBeat.m2505o(15601);
        } else if (intExtra == 5) {
            intent.setClass(context, LoginIndepPass.class);
            context.startActivity(intent);
            AppMethodBeat.m2505o(15601);
        } else {
            if (intExtra == 6) {
                intent.setClass(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("mobile_auth_type", 7);
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(15601);
        }
    }

    /* renamed from: g */
    public final void mo38920g(Context context, Intent intent) {
        AppMethodBeat.m2504i(15602);
        if (context == null) {
            AppMethodBeat.m2505o(15602);
            return;
        }
        C25985d.m41452a(context, "account", ".security.ui.SecurityAccountIntroUI", intent);
        AppMethodBeat.m2505o(15602);
    }

    /* renamed from: h */
    public final void mo38922h(Context context, Intent intent) {
        AppMethodBeat.m2504i(15603);
        intent.setClassName(context, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
        context.startActivity(intent);
        AppMethodBeat.m2505o(15603);
    }

    /* renamed from: a */
    public final void mo38893a(Intent intent, int i, C5186a c5186a, MMActivity mMActivity) {
        AppMethodBeat.m2504i(15605);
        if (mMActivity != null) {
            intent.setClassName(mMActivity, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
            mMActivity.mo17391b(c5186a, intent, i);
        }
        AppMethodBeat.m2505o(15605);
    }

    /* renamed from: BV */
    public final void mo38889BV() {
        AppMethodBeat.m2504i(15606);
        MMAppMgr.m7891BV();
        AppMethodBeat.m2505o(15606);
    }

    /* renamed from: b */
    public final boolean mo38905b(Context context, String str, Bundle bundle) {
        AppMethodBeat.m2504i(15577);
        boolean a = C23257a.vax.mo52972a(context, str, false, bundle);
        AppMethodBeat.m2505o(15577);
        return a;
    }

    /* renamed from: b */
    public final boolean mo38906b(Context context, String str, Object... objArr) {
        AppMethodBeat.m2504i(15604);
        boolean c = C23257a.vax.mo52975c(context, str, objArr);
        AppMethodBeat.m2505o(15604);
        return c;
    }

    public final void cancelNotification(String str) {
        AppMethodBeat.m2504i(15607);
        C18104a.eec;
        if (str != null) {
            int id = C9203b.m16707IP().getId(str);
            C4990ab.m7411d("MicroMsg.Notification.Handle", "cancel : %s", str);
            C9203b.m16707IP().cancel(id);
        }
        AppMethodBeat.m2505o(15607);
    }

    /* renamed from: v */
    public final void mo38937v(Context context, String str) {
        AppMethodBeat.m2504i(15608);
        C23257a.vax.mo52971a(context, str, true);
        AppMethodBeat.m2505o(15608);
    }
}
