package com.tencent.p177mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C18643z;
import com.tencent.p177mm.model.C26432y;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p231a.C26093br;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C6528od;
import com.tencent.p177mm.p230g.p231a.C9304bs;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.appbrand.C40663b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.AddressUI;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.MobileFriendUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.p177mm.plugin.remittance.p497ui.C46178d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.model.C7081j;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.C14827e.C14831a;
import com.tencent.p177mm.pluginsdk.C30156v;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet */
class URISpanHandlerSet {
    Context mContext = null;

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$AddressUriSpanHandler */
    class AddressUriSpanHandler extends BaseUriSpanHandler {
        AddressUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{44};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15632);
            if (c14932m.type == 44) {
                Uri parse = Uri.parse(new StringBuilder(WebView.SCHEME_GEO).append(Uri.encode(c14932m.url)).toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                if (intent.resolveActivity(C4996ah.getContext().getPackageManager()) != null) {
                    C4996ah.getContext().startActivity(intent);
                    C7060h.pYm.mo8381e(12809, Integer.valueOf(9), "");
                } else {
                    C4990ab.m7420w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
                }
                C7060h.pYm.mo8381e(12809, Integer.valueOf(8), "");
                AppMethodBeat.m2505o(15632);
                return true;
            }
            AppMethodBeat.m2505o(15632);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$PRIORITY */
    enum PRIORITY {
        LOW,
        NORMAL,
        HIGH;

        static {
            AppMethodBeat.m2505o(15680);
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingNotifyUriSpanHandler */
    class SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
        SettingNotifyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15699);
            if (str.trim().startsWith("weixin://setting/notify")) {
                C14932m c14932m = new C14932m(str, 9, null);
                AppMethodBeat.m2505o(15699);
                return c14932m;
            }
            AppMethodBeat.m2505o(15699);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{9};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15701);
            if (str.equals("weixin://setting/notify")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                Intent intent = new Intent();
                intent.addFlags(67108864);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI", intent);
                AppMethodBeat.m2505o(15701);
                return true;
            }
            AppMethodBeat.m2505o(15701);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15700);
            if (c14932m.type == 9) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                C25985d.m41448H(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI");
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15700);
                return true;
            }
            AppMethodBeat.m2505o(15700);
            return false;
        }
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$a */
    @interface C1262a {
        /* renamed from: Cn */
        PRIORITY mo4547Cn() default PRIORITY.NORMAL;
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$EnterRoomUriSpanHandler */
    class EnterRoomUriSpanHandler extends BaseUriSpanHandler {
        EnterRoomUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15654);
            if (str.startsWith("weixin://jump/mainframe/")) {
                int lastIndexOf = str.trim().lastIndexOf("/");
                if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                    String substring = str.trim().substring(lastIndexOf + 1);
                    if (C1855t.m3896kH(substring)) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(substring);
                        if (aoO == null || ((int) aoO.ewQ) == 0) {
                            aoO = new C7616ad();
                            aoO.setUsername(substring);
                            C9638aw.m17190ZK();
                            C18628c.m29078XM().mo15702Z(aoO);
                        }
                    }
                    Intent putExtra = new Intent(URISpanHandlerSet.this.mContext, ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        putExtra.addFlags(268435456);
                    }
                    URISpanHandlerSet.this.mContext.startActivity(putExtra);
                    AppMethodBeat.m2505o(15654);
                    return true;
                }
            }
            AppMethodBeat.m2505o(15654);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$FlowStatUriSpanHandler */
    class FlowStatUriSpanHandler extends BaseUriSpanHandler {
        FlowStatUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15659);
            if (str.trim().startsWith("weixin://flowstat")) {
                C14932m c14932m = new C14932m(str, 16, null);
                AppMethodBeat.m2505o(15659);
                return c14932m;
            }
            AppMethodBeat.m2505o(15659);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{16};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15661);
            if (str.equals("weixin://flowstat")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                AppMethodBeat.m2505o(15661);
                return true;
            }
            AppMethodBeat.m2505o(15661);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15660);
            if (c14932m.type == 16) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15660);
                return true;
            }
            AppMethodBeat.m2505o(15660);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$PluginUriSpanHandler */
    class PluginUriSpanHandler extends BaseUriSpanHandler {
        PluginUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15684);
            if (str.trim().startsWith("weixin://plugin")) {
                C14932m c14932m = new C14932m(str, 26, null);
                AppMethodBeat.m2505o(15684);
                return c14932m;
            }
            AppMethodBeat.m2505o(15684);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{26};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15685);
            if (str.equals("weixin://plugin")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPluginsUI", intent);
                AppMethodBeat.m2505o(15685);
                return true;
            }
            AppMethodBeat.m2505o(15685);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$ProfileUriSpanHandler */
    class ProfileUriSpanHandler extends BaseUriSpanHandler {
        ProfileUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15686);
            if (str.trim().startsWith("weixin://contacts/profile/")) {
                C14932m c14932m = new C14932m(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
                AppMethodBeat.m2505o(15686);
                return c14932m;
            }
            AppMethodBeat.m2505o(15686);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{3};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15688);
            if (str.startsWith("weixin://contacts/profile/")) {
                String replace = str.trim().replace("weixin://contacts/profile/", "").replace("/", "");
                if (C5046bo.isNullOrNil(replace)) {
                    C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
                    AppMethodBeat.m2505o(15688);
                    return true;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", replace);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(replace);
                if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                    C36249e.m59677a(intent, replace);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(15688);
                return true;
            }
            AppMethodBeat.m2505o(15688);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15687);
            if (c14932m.type == 3) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                String str = (String) c14932m.mo27270au(String.class);
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", str);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                    C36249e.m59677a(intent, str);
                }
                if (C5046bo.nullAsNil(str).length() > 0) {
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15687);
                return true;
            }
            AppMethodBeat.m2505o(15687);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SetSafeDeviceUriSpanHandler */
    class SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
        SetSafeDeviceUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15690);
            if (str.equals("weixin://setting/account/safedevice")) {
                C9638aw.m17190ZK();
                String str2 = (String) C18628c.m29072Ry().get(6, (Object) "");
                C9638aw.m17190ZK();
                String str3 = (String) C18628c.m29072Ry().get(4097, (Object) "");
                Intent intent;
                if (!C5046bo.isNullOrNil(str2)) {
                    intent = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    C25985d.m41448H(URISpanHandlerSet.this.mContext, "account", ".security.ui.MySafeDeviceListUI");
                } else if (C5046bo.isNullOrNil(str3)) {
                    intent = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    C25985d.m41452a(URISpanHandlerSet.this.mContext, "account", ".security.ui.BindSafeDeviceUI", intent);
                } else {
                    intent = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                    intent.putExtra("bind_scene", 1);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    MMWizardActivity.m23791J(URISpanHandlerSet.this.mContext, intent);
                }
                AppMethodBeat.m2505o(15690);
                return true;
            }
            AppMethodBeat.m2505o(15690);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingPrivacyUriSpanHandler */
    class SettingPrivacyUriSpanHandler extends BaseUriSpanHandler {
        SettingPrivacyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15710);
            if (str.trim().startsWith("weixin://setting/privacy")) {
                C14932m c14932m = new C14932m(str, 15, null);
                AppMethodBeat.m2505o(15710);
                return c14932m;
            }
            AppMethodBeat.m2505o(15710);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{15};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15712);
            if (str.equals("weixin://setting/privacy")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                AppMethodBeat.m2505o(15712);
                return true;
            }
            AppMethodBeat.m2505o(15712);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15711);
            if (c14932m.type == 15) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                C25985d.m41448H(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15711);
                return true;
            }
            AppMethodBeat.m2505o(15711);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$FriendMobileUriSpanHandler */
    class FriendMobileUriSpanHandler extends BaseUriSpanHandler {
        FriendMobileUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15662);
            if (str.trim().startsWith("weixin://findfriend/mobile")) {
                C14932m c14932m = new C14932m(str, 20, null);
                AppMethodBeat.m2505o(15662);
                return c14932m;
            }
            AppMethodBeat.m2505o(15662);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{20};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15664);
            if (str.equals("weixin://findfriend/mobile")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                AppMethodBeat.m2505o(15664);
                return true;
            }
            AppMethodBeat.m2505o(15664);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15663);
            if (c14932m.type == 20) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                URISpanHandlerSet.this.mContext.startActivity(new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class));
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15663);
                return true;
            }
            AppMethodBeat.m2505o(15663);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$PayTransferUriSpanHandler */
    class PayTransferUriSpanHandler extends BaseUriSpanHandler {
        PayTransferUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15681);
            if (str.startsWith("wxpay://")) {
                String obj;
                C40052a c40052a;
                if (c30156v != null) {
                    obj = c30156v.dgT().toString();
                    Object dgU = c30156v.dgU();
                    c40052a = dgU instanceof C40052a ? (C40052a) dgU : null;
                } else {
                    c40052a = null;
                    obj = null;
                }
                if (C5046bo.isNullOrNil(obj)) {
                    C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
                    AppMethodBeat.m2505o(15681);
                    return false;
                }
                String substring = str.substring(8);
                String str2 = "";
                if (substring.indexOf("&") > 0) {
                    substring = substring.split("&")[0];
                }
                int indexOf = substring.indexOf("=");
                if (indexOf >= 0) {
                    substring = substring.substring(indexOf + 1);
                } else {
                    substring = str2;
                }
                if (C5046bo.getInt(substring, 0) == 1) {
                    if (C1853r.m3832YN() || C1853r.m3833YO()) {
                        C35899h.m58851a(URISpanHandlerSet.this.mContext, 5, obj, 11, c40052a);
                    } else {
                        C35899h.m58851a(URISpanHandlerSet.this.mContext, 2, obj, 11, c40052a);
                    }
                    AppMethodBeat.m2505o(15681);
                    return true;
                }
                Toast.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(C25738R.string.e3v), 0).show();
                AppMethodBeat.m2505o(15681);
                return false;
            }
            AppMethodBeat.m2505o(15681);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingPluginQQMailUriSpanHandler */
    class SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15705);
            if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
                C14932m c14932m = new C14932m(str, 10, null);
                AppMethodBeat.m2505o(15705);
                return c14932m;
            }
            AppMethodBeat.m2505o(15705);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{10};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15707);
            if (str.equals("weixin://setting/plugin/qqmail")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(15707);
                return true;
            }
            AppMethodBeat.m2505o(15707);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15706);
            if (c14932m.type == 10) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15706);
                return true;
            }
            AppMethodBeat.m2505o(15706);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$StoryEntranceHandler */
    class StoryEntranceHandler extends BaseUriSpanHandler {
        StoryEntranceHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{48};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15713);
            if (c14932m.type == 48) {
                String str = c14932m.username;
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.m2505o(15713);
                    return false;
                }
                if (C39732a.m67944Xu(str)) {
                    C46270n.m86706aT(URISpanHandlerSet.this.mContext, str);
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15713);
                return true;
            }
            AppMethodBeat.m2505o(15713);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$TransferUriSpanHandler */
    class TransferUriSpanHandler extends BaseUriSpanHandler {
        TransferUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15715);
            C14932m c14932m;
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
                c14932m = new C14932m(str, 39, null);
                AppMethodBeat.m2505o(15715);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
                c14932m = new C14932m(str, 40, null);
                AppMethodBeat.m2505o(15715);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
                c14932m = new C14932m(str, 41, null);
                AppMethodBeat.m2505o(15715);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt")) {
                c14932m = new C14932m(str, 42, null);
                AppMethodBeat.m2505o(15715);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery")) {
                c14932m = new C14932m(str, 49, null);
                AppMethodBeat.m2505o(15715);
                return c14932m;
            } else {
                AppMethodBeat.m2505o(15715);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{39, 40, 41, 42, 49};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15716);
            if (c14932m != null) {
                final Bundle bundle;
                if (c14932m.type == 42) {
                    C25985d.m41448H(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.m2505o(15716);
                    return true;
                } else if (c14932m.type == 41) {
                    C25985d.m41448H(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.WalletBalanceManagerUI");
                    AppMethodBeat.m2505o(15716);
                    return true;
                } else if (c14932m.type == 39) {
                    if (c14932m.data != null && (c14932m.data instanceof Bundle)) {
                        bundle = (Bundle) c14932m.data;
                        new C46178d(URISpanHandlerSet.this.mContext).mo74162a((ResendMsgInfo) bundle.getParcelable("resend_msg_info"), new C5662c() {
                            /* renamed from: d */
                            public final void mo5699d(boolean z, String str) {
                                AppMethodBeat.m2504i(15714);
                                if (z) {
                                    String string = bundle.getString(C8741b.TRANSACTION_ID);
                                    String string2 = bundle.getString("transfer_id");
                                    String string3 = bundle.getString("receiver_name");
                                    Intent intent = new Intent();
                                    intent.putExtra(C8741b.TRANSACTION_ID, string);
                                    intent.putExtra("transfer_id", string2);
                                    intent.putExtra("receiver_name", string3);
                                    intent.putExtra("resend_msg_from_flag", 3);
                                    C25985d.m41467b(C4996ah.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
                                }
                                AppMethodBeat.m2505o(15714);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(15716);
                    return true;
                } else if (c14932m.type == 40) {
                    if (c14932m.data != null && (c14932m.data instanceof Bundle)) {
                        bundle = (Bundle) c14932m.data;
                        C6528od c6528od = new C6528od();
                        c6528od.cKt.cAa = bundle.getString(C8741b.TRANSACTION_ID);
                        c6528od.cKt.cEa = bundle.getString("transfer_id");
                        c6528od.cKt.cKu = bundle.getInt("total_fee");
                        c6528od.cKt.cKv = bundle.getString("sender_name");
                        C4879a.xxA.mo10055m(c6528od);
                    }
                    AppMethodBeat.m2505o(15716);
                    return true;
                } else if (c14932m.type == 49) {
                    Uri parse = Uri.parse(c14932m.url);
                    String queryParameter = parse.getQueryParameter("transfer_id");
                    String queryParameter2 = parse.getQueryParameter("trans_id");
                    String str = "";
                    if (c14932m.data == null || !(c14932m.data instanceof Bundle)) {
                        C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
                    } else {
                        str = ((Bundle) c14932m.data).getString("sender_name");
                    }
                    Intent intent = new Intent();
                    intent.putExtra("transfer_id", queryParameter);
                    intent.putExtra(C8741b.TRANSACTION_ID, queryParameter2);
                    intent.putExtra("sender_name", str);
                    C25985d.m41467b(C4996ah.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                    AppMethodBeat.m2505o(15716);
                    return true;
                }
            }
            AppMethodBeat.m2505o(15716);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$UnKnowToUrlSpanHandler */
    class UnKnowToUrlSpanHandler extends BaseUriSpanHandler {
        UnKnowToUrlSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{2147483646};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15717);
            if (c14932m.type == 2147483646) {
                if (c14932m.data instanceof Bundle) {
                    String string = ((Bundle) c14932m.data).getString("rawUrl");
                    if (C5046bo.isNullOrNil(string)) {
                        C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
                    } else {
                        C32921a.m53856b(C4996ah.getContext(), string, 0, true);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
                }
                AppMethodBeat.m2505o(15717);
                return true;
            }
            AppMethodBeat.m2505o(15717);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$VoipCallAgainUrilSpanHandler */
    class VoipCallAgainUrilSpanHandler extends BaseUriSpanHandler {
        VoipCallAgainUrilSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15720);
            if (str.trim().startsWith("weixin://voip/callagain/")) {
                C14932m c14932m = new C14932m(str, 38, null);
                AppMethodBeat.m2505o(15720);
                return c14932m;
            }
            AppMethodBeat.m2505o(15720);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{38};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15721);
            if (c14932m.type == 38) {
                Uri parse = Uri.parse(c14932m.url);
                String queryParameter = parse.getQueryParameter("username");
                String queryParameter2 = parse.getQueryParameter("isvideocall");
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 5;
                c26250ui.cQx.talker = queryParameter;
                c26250ui.cQx.context = URISpanHandlerSet.this.mContext;
                if (!(queryParameter == null || queryParameter.equals(""))) {
                    if (queryParameter2 == null || !queryParameter2.equals("true")) {
                        c26250ui.cQx.cQs = 4;
                    } else {
                        c26250ui.cQx.cQs = 2;
                    }
                    C4879a.xxA.mo10055m(c26250ui);
                    AppMethodBeat.m2505o(15721);
                    return true;
                }
            }
            AppMethodBeat.m2505o(15721);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$BizMsgMenuUriSpanHandler */
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        BizMsgMenuUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15639);
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                C14932m c14932m = new C14932m(str, 43, null);
                AppMethodBeat.m2505o(15639);
                return c14932m;
            }
            AppMethodBeat.m2505o(15639);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{43};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15640);
            if (43 != c14932m.type) {
                AppMethodBeat.m2505o(15640);
                return false;
            } else if (C5046bo.isNullOrNil(c14932m.username)) {
                C4990ab.m7420w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                AppMethodBeat.m2505o(15640);
                return true;
            } else {
                C4990ab.m7411d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", c14932m.url);
                Uri parse = Uri.parse(c14932m.url.trim());
                String queryParameter = parse.getQueryParameter("msgmenuid");
                String queryParameter2 = parse.getQueryParameter("msgmenucontent");
                C7060h.pYm.mo8381e(14522, C5046bo.nullAsNil(queryParameter), c14932m.username);
                if (C5046bo.isNullOrNil(queryParameter) || C5046bo.isNullOrNil(queryParameter2)) {
                    C4990ab.m7420w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                    AppMethodBeat.m2505o(15640);
                    return true;
                }
                try {
                    String decode = URLDecoder.decode(queryParameter2, "UTF-8");
                    HashMap hashMap = new HashMap();
                    hashMap.put("bizmsgmenuid", queryParameter);
                    C9638aw.m17182Rg().mo14541a(new C26451h(c14932m.username, decode, C1855t.m3925nK(c14932m.username), 291, hashMap), 0);
                } catch (UnsupportedEncodingException e) {
                    C4990ab.m7421w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", e.getMessage());
                }
                AppMethodBeat.m2505o(15640);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$CardUriSpanHandler */
    class CardUriSpanHandler extends BaseUriSpanHandler {
        CardUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15641);
            if (str.startsWith("wxcard://cardjumptype=1")) {
                String str2 = null;
                if (c30156v != null) {
                    str2 = c30156v.dgT().toString();
                }
                Intent intent = new Intent();
                intent.putExtra("user_name", str2);
                intent.putExtra("view_type", 1);
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "card", ".ui.CardViewUI", intent);
                AppMethodBeat.m2505o(15641);
                return true;
            }
            AppMethodBeat.m2505o(15641);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$ContactUriSpanHandler */
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        ContactUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            C14932m c14932m = null;
            AppMethodBeat.m2504i(15642);
            if (str.trim().equals("weixin://contacts/all/")) {
                c14932m = new C14932m(str, 23, new C26432y("@all.android", null, URISpanHandlerSet.this.mContext.getString(C25738R.string.c_0), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                c14932m = new C14932m(str, 22, C18643z.m29129nZ(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_3)));
            } else if (str.trim().equals("weixin://contacts/micromessenger/")) {
                c14932m = new C14932m(str, 2, new C26432y("@micromsg.qq.com", null, URISpanHandlerSet.this.mContext.getString(C25738R.string.c_4), null, true, true));
            } else if (str.trim().startsWith("weixin://contacts/")) {
                String substring = str.trim().substring(0, str.trim().length() - 1);
                int lastIndexOf = substring.lastIndexOf("/");
                if (lastIndexOf == -1) {
                    AppMethodBeat.m2505o(15642);
                    return c14932m;
                }
                c14932m = new C14932m(str, 21, C18643z.m29127ag("@".concat(String.valueOf(substring.substring(lastIndexOf + 1))), URISpanHandlerSet.this.mContext.getString(C25738R.string.c_2)));
            }
            AppMethodBeat.m2505o(15642);
            return c14932m;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{23, 21, 22, 2};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15644);
            if (str.equals("weixin://contacts/microblog/") || str.equals("weixin://contacts/micromessenger/") || str.equals("weixin://contacts/all/")) {
                C26432y nZ = C18643z.m29129nZ(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_4));
                if (str.equals("weixin://contacts/microblog/")) {
                    nZ = C18643z.m29129nZ(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_3));
                }
                if (str.equals("weixin://contacts/micromessenger/")) {
                    nZ = C18643z.m29129nZ(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_4));
                }
                if (str.equals("weixin://contacts/all/")) {
                    nZ = C18643z.m29129nZ(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_0));
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nZ.getType()).putExtra("Contact_GroupFilter_Str", nZ.mo44196Zq()).putExtra("Contact_GroupFilter_DisplayName", nZ.mo44195Oi());
                intent.addFlags(268435456);
                AppMethodBeat.m2505o(15644);
                return true;
            }
            AppMethodBeat.m2505o(15644);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            boolean z = false;
            AppMethodBeat.m2504i(15643);
            int i = c14932m.type;
            if (i == 23 || i == 21 || i == 22 || i == 2) {
                C26432y c26432y = (C26432y) c14932m.mo27270au(C26432y.class);
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                if (c26432y == null) {
                    C30379h.m48461b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(C25738R.string.cmm), URISpanHandlerSet.this.mContext.getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(15643);
                    return false;
                }
                if (c26432y.getType().equals("@t.qq.com")) {
                    boolean z2;
                    if (((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com") != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        C30379h.m48461b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(C25738R.string.cmm), URISpanHandlerSet.this.mContext.getString(C25738R.string.f9238tz), true);
                    }
                }
                if (c26432y.getType().equals("@domain.android")) {
                    List bOJ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().bOJ();
                    if (bOJ.size() > 0) {
                        for (int i2 = 0; i2 < bOJ.size(); i2++) {
                            if (((C5140bq) bOJ.get(i2)).isEnable()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        C30379h.m48461b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(C25738R.string.cmm), URISpanHandlerSet.this.mContext.getString(C25738R.string.f9238tz), true);
                    }
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", c26432y.getType()).putExtra("Contact_GroupFilter_Str", c26432y.mo44196Zq()).putExtra("Contact_GroupFilter_DisplayName", c26432y.mo44195Oi());
                intent.addFlags(268435456);
                URISpanHandlerSet.this.mContext.startActivity(intent);
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15643);
                return true;
            }
            AppMethodBeat.m2505o(15643);
            return false;
        }
    }

    @C1262a(Cn = PRIORITY.LOW)
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$DeeplinkUriSpanHandler */
    class DeeplinkUriSpanHandler extends BaseUriSpanHandler {
        DeeplinkUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15649);
            C4990ab.m7417i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", str);
            if (str.trim().toLowerCase().startsWith("weixin://")) {
                C14932m c14932m = new C14932m(str, 30, null);
                AppMethodBeat.m2505o(15649);
                return c14932m;
            }
            AppMethodBeat.m2505o(15649);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{30};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            String str;
            AppMethodBeat.m2504i(15650);
            C4990ab.m7417i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", Integer.valueOf(c14932m.type), c14932m.url);
            if (c44086g != null) {
                str = (String) c44086g.mo27726a(c14932m);
            } else {
                str = null;
            }
            if (c14932m.type == 30) {
                final String nullAsNil = C5046bo.nullAsNil(c14932m.url);
                if (nullAsNil.startsWith("weixin://shieldBrandMsg/") || nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                    if (C5046bo.isNullOrNil(str)) {
                        C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                        AppMethodBeat.m2505o(15650);
                        return true;
                    }
                    final C16527d qX = C17903f.m28104qX(str);
                    if (qX == null) {
                        C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                        AppMethodBeat.m2505o(15650);
                        return true;
                    } else if (nullAsNil.startsWith("weixin://shieldBrandMsg/")) {
                        C30379h.m48428a(URISpanHandlerSet.this.mContext, (int) C25738R.string.eve, (int) C25738R.string.f9238tz, (int) C25738R.string.evd, (int) C25738R.string.abx, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(15645);
                                int i2 = qX.field_brandFlag;
                                qX.field_brandFlag |= 1;
                                C4990ab.m7417i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i2), Integer.valueOf(qX.field_brandFlag));
                                C17903f.m28099f(qX);
                                AppMethodBeat.m2505o(15645);
                            }
                        }, null);
                    } else if (nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                        C30379h.m48428a(URISpanHandlerSet.this.mContext, (int) C25738R.string.evc, (int) C25738R.string.f9238tz, (int) C25738R.string.evb, (int) C25738R.string.abx, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(15646);
                                int i2 = qX.field_brandFlag;
                                qX.field_brandFlag &= -2;
                                C4990ab.m7417i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i2), Integer.valueOf(qX.field_brandFlag));
                                C17903f.m28099f(qX);
                                AppMethodBeat.m2505o(15646);
                            }
                        }, null);
                    }
                } else if (C14827e.m23079s(Uri.parse(nullAsNil))) {
                    C14827e.m23065A(URISpanHandlerSet.this.mContext, str, nullAsNil);
                } else if (!nullAsNil.startsWith("weixin://receiveWeAppKFMsg")) {
                    C14827e.m23071a(URISpanHandlerSet.this.mContext, nullAsNil, str, 1, nullAsNil, null);
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7413e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", nullAsNil);
                    AppMethodBeat.m2505o(15650);
                    return true;
                } else {
                    C30379h.m48428a(URISpanHandlerSet.this.mContext, (int) C25738R.string.f9043ng, (int) C25738R.string.f9238tz, (int) C25738R.string.f9042nf, (int) C25738R.string.abx, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(15647);
                            C4990ab.m7417i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", str);
                            C40663b.m70234k(URISpanHandlerSet.this.mContext, str, true);
                            AppMethodBeat.m2505o(15647);
                        }
                    }, null);
                }
                AppMethodBeat.m2505o(15650);
                return true;
            }
            AppMethodBeat.m2505o(15650);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15651);
            if (C5046bo.isNullOrNil(str) || bundle == null) {
                String str2 = "MicroMsg.URISpanHandlerSet";
                String str3 = "url is null ? %b, paramsBundle is null ? %b";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(str == null);
                objArr[1] = Boolean.valueOf(bundle == null);
                C4990ab.m7413e(str2, str3, objArr);
                AppMethodBeat.m2505o(15651);
                return false;
            } else if (C14827e.m23079s(Uri.parse(str))) {
                int i = bundle.getInt("key_scene", -1);
                C4990ab.m7411d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", Integer.valueOf(i), str);
                if (i == -1) {
                    i = 5;
                }
                final C44275p b = C30379h.m48458b(URISpanHandlerSet.this.mContext, "", true, null);
                C14827e.m23069a(URISpanHandlerSet.this.mContext, str, i, new C14831a() {
                    /* renamed from: a */
                    public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
                        AppMethodBeat.m2504i(15648);
                        if (b != null && b.isShowing()) {
                            b.dismiss();
                        }
                        if (!(c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z))) {
                            ciq ajE = ((C26475z) c1207m).ajE();
                            if (!(ajE == null || URISpanHandlerSet.this.mContext == null)) {
                                C23639t.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(C25738R.string.f9238tz) + " : " + C5046bo.nullAsNil(ajE.xhy), 0).show();
                            }
                        }
                        AppMethodBeat.m2505o(15648);
                    }
                });
                AppMethodBeat.m2505o(15651);
                return true;
            } else {
                AppMethodBeat.m2505o(15651);
                return false;
            }
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$EmotionStoreUriSpanHandler */
    class EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
        EmotionStoreUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15652);
            if (str.trim().startsWith("weixin://emoticonstore/")) {
                int lastIndexOf = str.lastIndexOf("/");
                Object obj = "";
                if (lastIndexOf != -1) {
                    obj = str.substring(lastIndexOf + 1);
                }
                C14932m c14932m = new C14932m(str, 29, obj);
                AppMethodBeat.m2505o(15652);
                return c14932m;
            }
            AppMethodBeat.m2505o(15652);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{29};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15653);
            if (c14932m.type == 29) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                Intent intent = new Intent();
                intent.putExtra("download_entrance_scene", 21);
                intent.putExtra("extra_id", (String) c14932m.mo27270au(String.class));
                intent.putExtra("preceding_scence", 3);
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent);
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15653);
                return true;
            }
            AppMethodBeat.m2505o(15653);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$PhoneEmailUriSpanHandler */
    class PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
        PhoneEmailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{25, 24};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15683);
            if (c14932m.type == 25) {
                String str = c14932m.username;
                Bundle bundle = new Bundle();
                if (!(str == null || str.equals(C1853r.m3846Yz()))) {
                    bundle.putString("Contact_User", str);
                    C18817a vT = C32923a.getAddrUploadStg().mo34089vT(str);
                    if (vT == null || C5046bo.isNullOrNil(vT.mo34067Aq())) {
                        str = null;
                    } else {
                        str = C5046bo.nullAsNil(vT.apG()).replace(" ", "");
                    }
                    bundle.putString("Contact_Mobile_MD5", str);
                }
                bundle.putInt("fromScene", 1);
                C23314l.m35797a(URISpanHandlerSet.this.mContext, c14932m.url, null, bundle);
                AppMethodBeat.m2505o(15683);
                return true;
            }
            if (c14932m.type == 24) {
                C23314l.m35798b(URISpanHandlerSet.this.mContext, c14932m.url, null);
            }
            AppMethodBeat.m2505o(15683);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$VerifyContactUriSpanHandler */
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        VerifyContactUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15718);
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                C14932m c14932m = new C14932m(str, 4, null);
                AppMethodBeat.m2505o(15718);
                return c14932m;
            }
            AppMethodBeat.m2505o(15718);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{4};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15719);
            if (c14932m.type == 4) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15719);
                return true;
            }
            AppMethodBeat.m2505o(15719);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$AppBrandLinkSpanHandler */
    class AppBrandLinkSpanHandler extends BaseUriSpanHandler {
        AppBrandLinkSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{45};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15635);
            if (c14932m.type == 45) {
                if (c44086g != null) {
                    C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
                    c44086g.mo27727b(c14932m);
                    AppMethodBeat.m2505o(15635);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
            }
            AppMethodBeat.m2505o(15635);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$JumpActivityUriSpanHandler */
    class JumpActivityUriSpanHandler extends BaseUriSpanHandler {
        JumpActivityUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15675);
            if (str.toLowerCase().startsWith("weixin://jump/")) {
                String[] split = str.split("/");
                String str2 = split[split.length - 1];
                Intent intent;
                if ("mainframe".equalsIgnoreCase(str2)) {
                    intent = new Intent(URISpanHandlerSet.this.mContext, LauncherUI.class);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    intent.addFlags(67108864);
                    URISpanHandlerSet.this.mContext.startActivity(intent);
                } else if ("shake".equalsIgnoreCase(str2)) {
                    C7060h.pYm.mo8374X(10221, "1");
                    intent = new Intent();
                    intent.addFlags(67108864);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "shake", ".ui.ShakeReportUI", intent);
                    if (URISpanHandlerSet.this.mContext != null && (URISpanHandlerSet.this.mContext instanceof Activity)) {
                        ((Activity) URISpanHandlerSet.this.mContext).finish();
                    }
                } else if ("scanqrcode".equalsIgnoreCase(str2)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                    intent.setFlags(65536);
                    intent.addFlags(67108864);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent);
                }
                AppMethodBeat.m2505o(15675);
                return true;
            }
            AppMethodBeat.m2505o(15675);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$PayUriSpanHandler */
    class PayUriSpanHandler extends BaseUriSpanHandler {
        PayUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{28};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15682);
            if (c14932m.type == 28) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                C4883b c26151he = new C26151he();
                c26151he.cBW.actionCode = 11;
                c26151he.cBW.result = c14932m.url;
                c26151he.cBW.context = URISpanHandlerSet.this.mContext;
                c26151he.cBW.cBY = new Bundle();
                c26151he.cBW.cBY.putInt("pay_channel", 6);
                C4879a.xxA.mo10048a(c26151he, Looper.myLooper());
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15682);
                return true;
            }
            AppMethodBeat.m2505o(15682);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingBindEmailUriSpanHandler */
    class SettingBindEmailUriSpanHandler extends BaseUriSpanHandler {
        SettingBindEmailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15691);
            if (str.trim().startsWith("weixin://setting/bindemail")) {
                C14932m c14932m = new C14932m(str, 7, null);
                AppMethodBeat.m2505o(15691);
                return c14932m;
            }
            AppMethodBeat.m2505o(15691);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{7};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15692);
            if (c14932m.type == 7) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15692);
                return true;
            }
            AppMethodBeat.m2505o(15692);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingBlacklistUriSpanHandler */
    class SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
        SettingBlacklistUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15693);
            if (str.trim().startsWith("weixin://setting/blacklist")) {
                C14932m c14932m = new C14932m(str, 14, null);
                AppMethodBeat.m2505o(15693);
                return c14932m;
            }
            AppMethodBeat.m2505o(15693);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{14};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15695);
            if (str.equals("weixin://setting/blacklist")) {
                C26432y nY = C18643z.m29128nY(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_1));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, AddressUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nY.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", nY.mo44195Oi());
                intent.addFlags(67108864);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                AppMethodBeat.m2505o(15695);
                return true;
            }
            AppMethodBeat.m2505o(15695);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15694);
            if (c14932m.type == 14) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                C26432y nY = C18643z.m29128nY(URISpanHandlerSet.this.mContext.getString(C25738R.string.c_1));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nY.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", nY.mo44195Oi());
                intent.addFlags(67108864);
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15694);
                return true;
            }
            AppMethodBeat.m2505o(15694);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$BaseUriSpanHandler */
    abstract class BaseUriSpanHandler {
        /* renamed from: Cm */
        public abstract int[] mo4543Cm();

        /* renamed from: a */
        public abstract boolean mo4544a(C14932m c14932m, C44086g c44086g);

        /* renamed from: a */
        public abstract boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle);

        /* renamed from: dr */
        public abstract C14932m mo4546dr(String str);
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$ExposeUriSpanHandler */
    class ExposeUriSpanHandler extends BaseUriSpanHandler {
        ExposeUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15655);
            if (str.trim().toLowerCase().equals("weixin://expose/")) {
                C14932m c14932m = new C14932m(str, 31, null);
                AppMethodBeat.m2505o(15655);
                return c14932m;
            }
            AppMethodBeat.m2505o(15655);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{31};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15656);
            if (c14932m.type == 31) {
                Intent intent = new Intent();
                if (c44086g == null) {
                    AppMethodBeat.m2505o(15656);
                    return false;
                }
                int i;
                String str = (String) c44086g.mo27726a(c14932m);
                intent.putExtra("k_username", str);
                if (C5046bo.isNullOrNil(str) || !str.endsWith("@chatroom")) {
                    i = 39;
                } else {
                    i = 36;
                }
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(15656);
                return true;
            }
            AppMethodBeat.m2505o(15656);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$FriendShareUriSpanHandler */
    class FriendShareUriSpanHandler extends BaseUriSpanHandler {
        FriendShareUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15668);
            if (str.trim().startsWith("weixin://findfriend/share")) {
                C14932m c14932m = new C14932m(str, 18, null);
                AppMethodBeat.m2505o(15668);
                return c14932m;
            }
            AppMethodBeat.m2505o(15668);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{18};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15670);
            if (str.equals("weixin://findfriend/share")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
                AppMethodBeat.m2505o(15670);
                return true;
            }
            AppMethodBeat.m2505o(15670);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15669);
            if (c14932m.type == 18) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                C25985d.m41448H(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15669);
                return true;
            }
            AppMethodBeat.m2505o(15669);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$AlphaInstallUriSpanHandler */
    class AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
        AlphaInstallUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15633);
            if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
                C14932m c14932m = new C14932m(str, 32, null);
                AppMethodBeat.m2505o(15633);
                return c14932m;
            }
            AppMethodBeat.m2505o(15633);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{32};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15634);
            if (c14932m.type == 32) {
                String replace = c14932m.url.replace("weixin://alphainstall?", "");
                String str = C6457e.eSn + Uri.parse(replace).getQueryParameter("md5") + ".apk";
                if (C5730e.m8628ct(str)) {
                    C5046bo.m7571k(str, C4996ah.getContext());
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", replace.toString());
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(15634);
                return true;
            }
            AppMethodBeat.m2505o(15634);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$BindMobileUrilSpanHandler */
    class BindMobileUrilSpanHandler extends BaseUriSpanHandler {
        BindMobileUrilSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15636);
            if (str.trim().startsWith("weixin://setting/bindphone")) {
                C14932m c14932m = new C14932m(str, 5, null);
                AppMethodBeat.m2505o(15636);
                return c14932m;
            }
            AppMethodBeat.m2505o(15636);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{5};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15638);
            if (str.equals("weixin://setting/bindphone")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                MMWizardActivity.m23791J(URISpanHandlerSet.this.mContext, intent);
                AppMethodBeat.m2505o(15638);
                return true;
            }
            AppMethodBeat.m2505o(15638);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15637);
            if (c14932m.type == 5) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                MMWizardActivity.m23791J(URISpanHandlerSet.this.mContext, new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class));
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15637);
                return true;
            }
            AppMethodBeat.m2505o(15637);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$FriendSearchUriSpanHandler */
    class FriendSearchUriSpanHandler extends BaseUriSpanHandler {
        FriendSearchUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15665);
            if (str.trim().startsWith("weixin://findfriend/search")) {
                C14932m c14932m = new C14932m(str, 17, null);
                AppMethodBeat.m2505o(15665);
                return c14932m;
            }
            AppMethodBeat.m2505o(15665);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{17};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15667);
            if (str.equals("weixin://findfriend/search")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", intent);
                AppMethodBeat.m2505o(15667);
                return true;
            }
            AppMethodBeat.m2505o(15667);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15666);
            if (c14932m.type == 17) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                C25985d.m41448H(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15666);
                return true;
            }
            AppMethodBeat.m2505o(15666);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$HoneyPayLinkSpanHandler */
    class HoneyPayLinkSpanHandler extends BaseUriSpanHandler {
        HoneyPayLinkSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15671);
            C14932m c14932m;
            if (str.trim().startsWith("native://wcpay/honeypay")) {
                c14932m = new C14932m(str, 46, null);
                AppMethodBeat.m2505o(15671);
                return c14932m;
            } else if (str.trim().startsWith("weixin://wcpay/bankCardList")) {
                c14932m = new C14932m(str, 47, null);
                AppMethodBeat.m2505o(15671);
                return c14932m;
            } else {
                AppMethodBeat.m2505o(15671);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{46, 47};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15672);
            if (c14932m.type == 46) {
                C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
                if (c14932m.data != null && (c14932m.data instanceof Bundle)) {
                    Uri parse = Uri.parse(c14932m.url);
                    String queryParameter = parse.getQueryParameter("cardNo");
                    boolean equals = parse.getQueryParameter("isPayer").equals("1");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", queryParameter);
                    intent.putExtra("key_is_payer", equals);
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "honey_pay", ".ui.HoneyPayProxyUI", intent);
                }
            } else if (c14932m.type == 47) {
                C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "go to bank card list");
                Intent intent2 = new Intent();
                intent2.putExtra("intent_finish_self", true);
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "wallet", ".bind.ui.WalletBankcardManageUI", intent2);
                C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(15672);
            return false;
        }
    }

    @C1262a(Cn = PRIORITY.HIGH)
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$LuckyMoneyUriSpanHandler */
    class LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
        LuckyMoneyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15676);
            if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
                C14932m c14932m = new C14932m(str, 33, null);
                AppMethodBeat.m2505o(15676);
                return c14932m;
            }
            AppMethodBeat.m2505o(15676);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{33};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15677);
            if (c14932m.type != 33) {
                AppMethodBeat.m2505o(15677);
                return false;
            } else if (c44086g == null) {
                C4990ab.m7416i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
                AppMethodBeat.m2505o(15677);
                return false;
            } else {
                Intent intent = new Intent();
                intent.putExtra("key_native_url", c14932m.url);
                intent.putExtra("key_username", (String) c44086g.mo27726a(c14932m));
                intent.putExtra("key_lucky_money_can_received", true);
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                C7060h.pYm.mo8381e(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                C7060h.pYm.mo8381e(11850, Integer.valueOf(4), Integer.valueOf(1));
                AppMethodBeat.m2505o(15677);
                return true;
            }
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$ScanQrCodeUriSpanHandler */
    class ScanQrCodeUriSpanHandler extends BaseUriSpanHandler {
        ScanQrCodeUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            boolean z2 = false;
            AppMethodBeat.m2504i(15689);
            if (!str.equals("weixin://scanqrcode/")) {
                AppMethodBeat.m2505o(15689);
                return false;
            } else if (z) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                if (bundle != null && bundle.getInt("fromScene") == 100) {
                    z2 = true;
                }
                if (!z2) {
                    intent.addFlags(67108864);
                }
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                if (z2) {
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "scanner", ".ui.SingleTopScanUI", intent);
                    AppMethodBeat.m2505o(15689);
                    return true;
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.m2505o(15689);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
                AppMethodBeat.m2505o(15689);
                return true;
            }
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingHeadImgUriSpanHandler */
    class SettingHeadImgUriSpanHandler extends BaseUriSpanHandler {
        SettingHeadImgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15696);
            if (str.trim().startsWith("weixin://setting/setheadimage")) {
                C14932m c14932m = new C14932m(str, 6, null);
                AppMethodBeat.m2505o(15696);
                return c14932m;
            }
            AppMethodBeat.m2505o(15696);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{6};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15698);
            if (str.equals("weixin://setting/setheadimage")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", C1853r.m3846Yz());
                intent.putExtra("Contact_Nick", C1853r.m3820YB());
                intent.putExtra("User_Avatar", true);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(15698);
                return true;
            }
            AppMethodBeat.m2505o(15698);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15697);
            if (c14932m.type == 6) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15697);
                return true;
            }
            AppMethodBeat.m2505o(15697);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingPluginLomoUriSpanHandler */
    class SettingPluginLomoUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginLomoUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15702);
            if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
                C14932m c14932m = new C14932m(str, 12, null);
                AppMethodBeat.m2505o(15702);
                return c14932m;
            }
            AppMethodBeat.m2505o(15702);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{12};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            AppMethodBeat.m2504i(15704);
            if (str.equals("weixin://setting/plugin/lomo")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(15704);
                return true;
            }
            AppMethodBeat.m2505o(15704);
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15703);
            if (c14932m.type == 12) {
                if (c44086g != null) {
                    c44086g.mo27726a(c14932m);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                C25985d.m41467b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15703);
                return true;
            }
            AppMethodBeat.m2505o(15703);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingPluginSxMsgUriSpanHandler */
    class SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginSxMsgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15709);
            if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
                C14932m c14932m = new C14932m(str, 11, null);
                AppMethodBeat.m2505o(15709);
                return c14932m;
            }
            AppMethodBeat.m2505o(15709);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{11};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$AAUriSpanHandler */
    class AAUriSpanHandler extends BaseUriSpanHandler {
        AAUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15630);
            C14932m c14932m;
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                c14932m = new C14932m(str, 35, null);
                AppMethodBeat.m2505o(15630);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                c14932m = new C14932m(str, 36, null);
                AppMethodBeat.m2505o(15630);
                return c14932m;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa")) {
                c14932m = new C14932m(str, 37, null);
                AppMethodBeat.m2505o(15630);
                return c14932m;
            } else {
                AppMethodBeat.m2505o(15630);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{35, 36, 37};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15631);
            if (c14932m.type == 35) {
                try {
                    String queryParameter = Uri.parse(c14932m.url).getQueryParameter("billno");
                    if (C5046bo.isNullOrNil(queryParameter)) {
                        C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        AppMethodBeat.m2505o(15631);
                        return true;
                    }
                    String string;
                    if (c14932m.data instanceof Bundle) {
                        string = ((Bundle) c14932m.data).getString("chatroom_name");
                    } else if (c14932m.data instanceof String) {
                        string = c14932m.data.toString();
                    } else {
                        C4990ab.m7413e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", c14932m);
                        AppMethodBeat.m2505o(15631);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom", string);
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "aa", ".ui.PaylistAAUI", intent);
                    AppMethodBeat.m2505o(15631);
                    return true;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", e.getMessage(), c14932m.url);
                }
            } else {
                final String queryParameter2;
                Bundle bundle;
                final String string2;
                final long j;
                if (c14932m.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(c14932m.url).getQueryParameter("billno");
                        if (C5046bo.isNullOrNil(queryParameter2)) {
                            C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.m2505o(15631);
                            return true;
                        } else if (c14932m.data instanceof Bundle) {
                            bundle = (Bundle) c14932m.data;
                            string2 = bundle.getString("chatroom_name");
                            if (C5046bo.isNullOrNil(string2)) {
                                C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                AppMethodBeat.m2505o(15631);
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                AppMethodBeat.m2505o(15631);
                                return true;
                            }
                            C30379h.m48428a(URISpanHandlerSet.this.mContext, C25738R.string.erg, -1, C25738R.string.erj, C25738R.string.abx, (OnClickListener) new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(15628);
                                    C26093br c26093br = new C26093br();
                                    c26093br.cuN.cuO = queryParameter2;
                                    c26093br.cuN.cuP = string2;
                                    c26093br.cuN.cuQ = j;
                                    C4879a.xxA.mo10055m(c26093br);
                                    AppMethodBeat.m2505o(15628);
                                }
                            }, null);
                        } else {
                            C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "error data!");
                            AppMethodBeat.m2505o(15631);
                            return true;
                        }
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", e2.getMessage(), c14932m.url);
                    }
                } else if (c14932m.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(c14932m.url).getQueryParameter("billno");
                        if (C5046bo.isNullOrNil(queryParameter2)) {
                            C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.m2505o(15631);
                            return true;
                        }
                        bundle = null;
                        if (c14932m.data instanceof Bundle) {
                            bundle = (Bundle) c14932m.data;
                        }
                        if (bundle == null || C5046bo.isNullOrNil(bundle.getString("chatroom_name"))) {
                            C4990ab.m7412e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            AppMethodBeat.m2505o(15631);
                            return true;
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        C30379h.m48428a(URISpanHandlerSet.this.mContext, C25738R.string.erh, -1, C25738R.string.eri, C25738R.string.abx, (OnClickListener) new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(15629);
                                C9304bs c9304bs = new C9304bs();
                                c9304bs.cuR.cuO = queryParameter2;
                                c9304bs.cuR.cuP = string2;
                                c9304bs.cuR.cuQ = j;
                                C4879a.xxA.mo10055m(c9304bs);
                                AppMethodBeat.m2505o(15629);
                            }
                        }, null);
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", e22.getMessage(), c14932m.url);
                    }
                }
                AppMethodBeat.m2505o(15631);
                return false;
            }
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$FeedbackUriSpanHandler */
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        FeedbackUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15657);
            if (str.trim().startsWith("weixin://feedback/next/")) {
                C14932m c14932m = new C14932m(str, 34, null);
                AppMethodBeat.m2505o(15657);
                return c14932m;
            }
            AppMethodBeat.m2505o(15657);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{34};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15658);
            if (c14932m.type == 34) {
                C4990ab.m7411d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", c14932m.url, c14932m.url.trim().replace("weixin://feedback/next/", ""));
                C9638aw.m17182Rg().mo14541a(new C7081j(C1427q.m3044Mc(), r2, 8), 0);
                AppMethodBeat.m2505o(15658);
                return true;
            }
            AppMethodBeat.m2505o(15658);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$HttpUriSpanHandler */
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        HttpUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            C14932m c14932m;
            AppMethodBeat.m2504i(15673);
            if (str.trim().toLowerCase().startsWith("http")) {
                c14932m = new C14932m(str, 1, null);
            } else {
                c14932m = null;
            }
            AppMethodBeat.m2505o(15673);
            return c14932m;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{1};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            AppMethodBeat.m2504i(15674);
            if (c14932m.type == 1) {
                C26432y ag;
                String str;
                boolean z = URISpanHandlerSet.this.mContext != null && (URISpanHandlerSet.this.mContext instanceof WebViewUI);
                c14932m.mo27270au(C26432y.class);
                if (!z || C4996ah.bqo()) {
                    ag = C18643z.m29127ag("@" + c14932m.url, URISpanHandlerSet.this.mContext.getString(C25738R.string.c_2));
                } else {
                    ag = null;
                }
                if (c44086g != null) {
                    str = (String) c44086g.mo27726a(c14932m);
                } else {
                    str = null;
                }
                if (ag == null || !ag.enable) {
                    String str2 = c14932m.url;
                    if (!str2.toLowerCase().startsWith("http")) {
                        str2 = "http://".concat(String.valueOf(str2));
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    if (c14932m.data != null && (c14932m.data instanceof Integer)) {
                        intent.putExtra("geta8key_scene", ((Integer) c14932m.data).intValue());
                    }
                    str2 = c14932m.hcl;
                    if (!C5046bo.isNullOrNil(str2)) {
                        C32800b nV = C37922v.m64076Zp().mo60674nV(str2);
                        if (nV != null) {
                            String string = nV.getString("prePublishId", null);
                            String string2 = nV.getString("preUsername", null);
                            String string3 = nV.getString("preChatName", null);
                            intent.putExtra("reportSessionId", str2);
                            intent.putExtra("KPublisherId", string);
                            intent.putExtra("geta8key_username", string3);
                            intent.putExtra("pre_username", string2);
                            intent.putExtra("prePublishId", string);
                            intent.putExtra("preUsername", string2);
                            intent.putExtra("preChatName", string3);
                            intent.putExtra("preChatTYPE", C32798u.m53583ad(string2, string3));
                        }
                    }
                    intent.putExtra("geta8key_username", C5046bo.isNullOrNil(str) ? null : str);
                    if (z) {
                        intent.addFlags(268435456);
                    } else {
                        intent.addFlags(536870912);
                    }
                    C25985d.m41467b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                }
                if (c44086g != null) {
                    c44086g.mo27727b(c14932m);
                }
                AppMethodBeat.m2505o(15674);
                return true;
            }
            AppMethodBeat.m2505o(15674);
            return false;
        }
    }

    @C1262a
    /* renamed from: com.tencent.mm.app.plugin.URISpanHandlerSet$SettingPluginQQMsgUriSpanHandler */
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMsgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dr */
        public final C14932m mo4546dr(String str) {
            AppMethodBeat.m2504i(15708);
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                C14932m c14932m = new C14932m(str, 13, null);
                AppMethodBeat.m2505o(15708);
                return c14932m;
            }
            AppMethodBeat.m2505o(15708);
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Cm */
        public final int[] mo4543Cm() {
            return new int[]{13};
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4544a(C14932m c14932m, C44086g c44086g) {
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo4545a(String str, boolean z, C30156v c30156v, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        AppMethodBeat.m2504i(15722);
        this.mContext = context == null ? C4996ah.getContext() : this.mContext;
        AppMethodBeat.m2505o(15722);
    }
}
