package com.tencent.mm.app.plugin;

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
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.e.g;
import com.tencent.mm.pluginsdk.ui.e.l;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet {
    Context mContext = null;

    @a
    class AddressUriSpanHandler extends BaseUriSpanHandler {
        AddressUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{44};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15632);
            if (mVar.type == 44) {
                Uri parse = Uri.parse(new StringBuilder(WebView.SCHEME_GEO).append(Uri.encode(mVar.url)).toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                if (intent.resolveActivity(ah.getContext().getPackageManager()) != null) {
                    ah.getContext().startActivity(intent);
                    h.pYm.e(12809, Integer.valueOf(9), "");
                } else {
                    ab.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
                }
                h.pYm.e(12809, Integer.valueOf(8), "");
                AppMethodBeat.o(15632);
                return true;
            }
            AppMethodBeat.o(15632);
            return false;
        }
    }

    enum PRIORITY {
        LOW,
        NORMAL,
        HIGH;

        static {
            AppMethodBeat.o(15680);
        }
    }

    @a
    class SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
        SettingNotifyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15699);
            if (str.trim().startsWith("weixin://setting/notify")) {
                m mVar = new m(str, 9, null);
                AppMethodBeat.o(15699);
                return mVar;
            }
            AppMethodBeat.o(15699);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{9};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15701);
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
                d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI", intent);
                AppMethodBeat.o(15701);
                return true;
            }
            AppMethodBeat.o(15701);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15700);
            if (mVar.type == 9) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                d.H(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI");
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15700);
                return true;
            }
            AppMethodBeat.o(15700);
            return false;
        }
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface a {
        PRIORITY Cn() default PRIORITY.NORMAL;
    }

    @a
    class EnterRoomUriSpanHandler extends BaseUriSpanHandler {
        EnterRoomUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15654);
            if (str.startsWith("weixin://jump/mainframe/")) {
                int lastIndexOf = str.trim().lastIndexOf("/");
                if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                    String substring = str.trim().substring(lastIndexOf + 1);
                    if (t.kH(substring)) {
                        aw.ZK();
                        ad aoO = c.XM().aoO(substring);
                        if (aoO == null || ((int) aoO.ewQ) == 0) {
                            aoO = new ad();
                            aoO.setUsername(substring);
                            aw.ZK();
                            c.XM().Z(aoO);
                        }
                    }
                    Intent putExtra = new Intent(URISpanHandlerSet.this.mContext, ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        putExtra.addFlags(268435456);
                    }
                    URISpanHandlerSet.this.mContext.startActivity(putExtra);
                    AppMethodBeat.o(15654);
                    return true;
                }
            }
            AppMethodBeat.o(15654);
            return false;
        }
    }

    @a
    class FlowStatUriSpanHandler extends BaseUriSpanHandler {
        FlowStatUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15659);
            if (str.trim().startsWith("weixin://flowstat")) {
                m mVar = new m(str, 16, null);
                AppMethodBeat.o(15659);
                return mVar;
            }
            AppMethodBeat.o(15659);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{16};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15661);
            if (str.equals("weixin://flowstat")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                AppMethodBeat.o(15661);
                return true;
            }
            AppMethodBeat.o(15661);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15660);
            if (mVar.type == 16) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15660);
                return true;
            }
            AppMethodBeat.o(15660);
            return false;
        }
    }

    @a
    class PluginUriSpanHandler extends BaseUriSpanHandler {
        PluginUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15684);
            if (str.trim().startsWith("weixin://plugin")) {
                m mVar = new m(str, 26, null);
                AppMethodBeat.o(15684);
                return mVar;
            }
            AppMethodBeat.o(15684);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{26};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15685);
            if (str.equals("weixin://plugin")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPluginsUI", intent);
                AppMethodBeat.o(15685);
                return true;
            }
            AppMethodBeat.o(15685);
            return false;
        }
    }

    @a
    class ProfileUriSpanHandler extends BaseUriSpanHandler {
        ProfileUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15686);
            if (str.trim().startsWith("weixin://contacts/profile/")) {
                m mVar = new m(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace("/", ""));
                AppMethodBeat.o(15686);
                return mVar;
            }
            AppMethodBeat.o(15686);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{3};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15688);
            if (str.startsWith("weixin://contacts/profile/")) {
                String replace = str.trim().replace("weixin://contacts/profile/", "").replace("/", "");
                if (bo.isNullOrNil(replace)) {
                    ab.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
                    AppMethodBeat.o(15688);
                    return true;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", replace);
                aw.ZK();
                ad aoO = c.XM().aoO(replace);
                if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    e.a(intent, replace);
                }
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(15688);
                return true;
            }
            AppMethodBeat.o(15688);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15687);
            if (mVar.type == 3) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                String str = (String) mVar.au(String.class);
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", str);
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    e.a(intent, str);
                }
                if (bo.nullAsNil(str).length() > 0) {
                    d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15687);
                return true;
            }
            AppMethodBeat.o(15687);
            return false;
        }
    }

    @a
    class SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
        SetSafeDeviceUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15690);
            if (str.equals("weixin://setting/account/safedevice")) {
                aw.ZK();
                String str2 = (String) c.Ry().get(6, (Object) "");
                aw.ZK();
                String str3 = (String) c.Ry().get(4097, (Object) "");
                Intent intent;
                if (!bo.isNullOrNil(str2)) {
                    intent = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    d.H(URISpanHandlerSet.this.mContext, "account", ".security.ui.MySafeDeviceListUI");
                } else if (bo.isNullOrNil(str3)) {
                    intent = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    d.a(URISpanHandlerSet.this.mContext, "account", ".security.ui.BindSafeDeviceUI", intent);
                } else {
                    intent = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                    intent.putExtra("bind_scene", 1);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    MMWizardActivity.J(URISpanHandlerSet.this.mContext, intent);
                }
                AppMethodBeat.o(15690);
                return true;
            }
            AppMethodBeat.o(15690);
            return false;
        }
    }

    @a
    class SettingPrivacyUriSpanHandler extends BaseUriSpanHandler {
        SettingPrivacyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15710);
            if (str.trim().startsWith("weixin://setting/privacy")) {
                m mVar = new m(str, 15, null);
                AppMethodBeat.o(15710);
                return mVar;
            }
            AppMethodBeat.o(15710);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{15};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15712);
            if (str.equals("weixin://setting/privacy")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                AppMethodBeat.o(15712);
                return true;
            }
            AppMethodBeat.o(15712);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15711);
            if (mVar.type == 15) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                d.H(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15711);
                return true;
            }
            AppMethodBeat.o(15711);
            return false;
        }
    }

    @a
    class FriendMobileUriSpanHandler extends BaseUriSpanHandler {
        FriendMobileUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15662);
            if (str.trim().startsWith("weixin://findfriend/mobile")) {
                m mVar = new m(str, 20, null);
                AppMethodBeat.o(15662);
                return mVar;
            }
            AppMethodBeat.o(15662);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{20};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15664);
            if (str.equals("weixin://findfriend/mobile")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                AppMethodBeat.o(15664);
                return true;
            }
            AppMethodBeat.o(15664);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15663);
            if (mVar.type == 20) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                URISpanHandlerSet.this.mContext.startActivity(new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class));
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15663);
                return true;
            }
            AppMethodBeat.o(15663);
            return false;
        }
    }

    @a
    class PayTransferUriSpanHandler extends BaseUriSpanHandler {
        PayTransferUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15681);
            if (str.startsWith("wxpay://")) {
                String obj;
                com.tencent.mm.plugin.wallet.a aVar;
                if (vVar != null) {
                    obj = vVar.dgT().toString();
                    Object dgU = vVar.dgU();
                    aVar = dgU instanceof com.tencent.mm.plugin.wallet.a ? (com.tencent.mm.plugin.wallet.a) dgU : null;
                } else {
                    aVar = null;
                    obj = null;
                }
                if (bo.isNullOrNil(obj)) {
                    ab.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
                    AppMethodBeat.o(15681);
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
                if (bo.getInt(substring, 0) == 1) {
                    if (r.YN() || r.YO()) {
                        com.tencent.mm.pluginsdk.wallet.h.a(URISpanHandlerSet.this.mContext, 5, obj, 11, aVar);
                    } else {
                        com.tencent.mm.pluginsdk.wallet.h.a(URISpanHandlerSet.this.mContext, 2, obj, 11, aVar);
                    }
                    AppMethodBeat.o(15681);
                    return true;
                }
                Toast.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.e3v), 0).show();
                AppMethodBeat.o(15681);
                return false;
            }
            AppMethodBeat.o(15681);
            return false;
        }
    }

    @a
    class SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15705);
            if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
                m mVar = new m(str, 10, null);
                AppMethodBeat.o(15705);
                return mVar;
            }
            AppMethodBeat.o(15705);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{10};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15707);
            if (str.equals("weixin://setting/plugin/qqmail")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(15707);
                return true;
            }
            AppMethodBeat.o(15707);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15706);
            if (mVar.type == 10) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15706);
                return true;
            }
            AppMethodBeat.o(15706);
            return false;
        }
    }

    @a
    class StoryEntranceHandler extends BaseUriSpanHandler {
        StoryEntranceHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{48};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15713);
            if (mVar.type == 48) {
                String str = mVar.username;
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.o(15713);
                    return false;
                }
                if (com.tencent.mm.plugin.sns.e.a.Xu(str)) {
                    n.aT(URISpanHandlerSet.this.mContext, str);
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15713);
                return true;
            }
            AppMethodBeat.o(15713);
            return false;
        }
    }

    @a
    class TransferUriSpanHandler extends BaseUriSpanHandler {
        TransferUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15715);
            m mVar;
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
                mVar = new m(str, 39, null);
                AppMethodBeat.o(15715);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
                mVar = new m(str, 40, null);
                AppMethodBeat.o(15715);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
                mVar = new m(str, 41, null);
                AppMethodBeat.o(15715);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt")) {
                mVar = new m(str, 42, null);
                AppMethodBeat.o(15715);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery")) {
                mVar = new m(str, 49, null);
                AppMethodBeat.o(15715);
                return mVar;
            } else {
                AppMethodBeat.o(15715);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{39, 40, 41, 42, 49};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15716);
            if (mVar != null) {
                final Bundle bundle;
                if (mVar.type == 42) {
                    d.H(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(15716);
                    return true;
                } else if (mVar.type == 41) {
                    d.H(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.WalletBalanceManagerUI");
                    AppMethodBeat.o(15716);
                    return true;
                } else if (mVar.type == 39) {
                    if (mVar.data != null && (mVar.data instanceof Bundle)) {
                        bundle = (Bundle) mVar.data;
                        new com.tencent.mm.plugin.remittance.ui.d(URISpanHandlerSet.this.mContext).a((ResendMsgInfo) bundle.getParcelable("resend_msg_info"), new com.tencent.mm.ui.widget.a.e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(15714);
                                if (z) {
                                    String string = bundle.getString(b.TRANSACTION_ID);
                                    String string2 = bundle.getString("transfer_id");
                                    String string3 = bundle.getString("receiver_name");
                                    Intent intent = new Intent();
                                    intent.putExtra(b.TRANSACTION_ID, string);
                                    intent.putExtra("transfer_id", string2);
                                    intent.putExtra("receiver_name", string3);
                                    intent.putExtra("resend_msg_from_flag", 3);
                                    d.b(ah.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
                                }
                                AppMethodBeat.o(15714);
                            }
                        });
                    }
                    AppMethodBeat.o(15716);
                    return true;
                } else if (mVar.type == 40) {
                    if (mVar.data != null && (mVar.data instanceof Bundle)) {
                        bundle = (Bundle) mVar.data;
                        od odVar = new od();
                        odVar.cKt.cAa = bundle.getString(b.TRANSACTION_ID);
                        odVar.cKt.cEa = bundle.getString("transfer_id");
                        odVar.cKt.cKu = bundle.getInt("total_fee");
                        odVar.cKt.cKv = bundle.getString("sender_name");
                        com.tencent.mm.sdk.b.a.xxA.m(odVar);
                    }
                    AppMethodBeat.o(15716);
                    return true;
                } else if (mVar.type == 49) {
                    Uri parse = Uri.parse(mVar.url);
                    String queryParameter = parse.getQueryParameter("transfer_id");
                    String queryParameter2 = parse.getQueryParameter("trans_id");
                    String str = "";
                    if (mVar.data == null || !(mVar.data instanceof Bundle)) {
                        ab.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
                    } else {
                        str = ((Bundle) mVar.data).getString("sender_name");
                    }
                    Intent intent = new Intent();
                    intent.putExtra("transfer_id", queryParameter);
                    intent.putExtra(b.TRANSACTION_ID, queryParameter2);
                    intent.putExtra("sender_name", str);
                    d.b(ah.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                    AppMethodBeat.o(15716);
                    return true;
                }
            }
            AppMethodBeat.o(15716);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class UnKnowToUrlSpanHandler extends BaseUriSpanHandler {
        UnKnowToUrlSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{2147483646};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15717);
            if (mVar.type == 2147483646) {
                if (mVar.data instanceof Bundle) {
                    String string = ((Bundle) mVar.data).getString("rawUrl");
                    if (bo.isNullOrNil(string)) {
                        ab.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
                    } else {
                        com.tencent.mm.plugin.account.a.b.a.b(ah.getContext(), string, 0, true);
                    }
                } else {
                    ab.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
                }
                AppMethodBeat.o(15717);
                return true;
            }
            AppMethodBeat.o(15717);
            return false;
        }
    }

    @a
    class VoipCallAgainUrilSpanHandler extends BaseUriSpanHandler {
        VoipCallAgainUrilSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15720);
            if (str.trim().startsWith("weixin://voip/callagain/")) {
                m mVar = new m(str, 38, null);
                AppMethodBeat.o(15720);
                return mVar;
            }
            AppMethodBeat.o(15720);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{38};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15721);
            if (mVar.type == 38) {
                Uri parse = Uri.parse(mVar.url);
                String queryParameter = parse.getQueryParameter("username");
                String queryParameter2 = parse.getQueryParameter("isvideocall");
                ui uiVar = new ui();
                uiVar.cQx.cAd = 5;
                uiVar.cQx.talker = queryParameter;
                uiVar.cQx.context = URISpanHandlerSet.this.mContext;
                if (!(queryParameter == null || queryParameter.equals(""))) {
                    if (queryParameter2 == null || !queryParameter2.equals("true")) {
                        uiVar.cQx.cQs = 4;
                    } else {
                        uiVar.cQx.cQs = 2;
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                    AppMethodBeat.o(15721);
                    return true;
                }
            }
            AppMethodBeat.o(15721);
            return false;
        }
    }

    @a
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        BizMsgMenuUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15639);
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                m mVar = new m(str, 43, null);
                AppMethodBeat.o(15639);
                return mVar;
            }
            AppMethodBeat.o(15639);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{43};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15640);
            if (43 != mVar.type) {
                AppMethodBeat.o(15640);
                return false;
            } else if (bo.isNullOrNil(mVar.username)) {
                ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                AppMethodBeat.o(15640);
                return true;
            } else {
                ab.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", mVar.url);
                Uri parse = Uri.parse(mVar.url.trim());
                String queryParameter = parse.getQueryParameter("msgmenuid");
                String queryParameter2 = parse.getQueryParameter("msgmenucontent");
                h.pYm.e(14522, bo.nullAsNil(queryParameter), mVar.username);
                if (bo.isNullOrNil(queryParameter) || bo.isNullOrNil(queryParameter2)) {
                    ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                    AppMethodBeat.o(15640);
                    return true;
                }
                try {
                    String decode = URLDecoder.decode(queryParameter2, "UTF-8");
                    HashMap hashMap = new HashMap();
                    hashMap.put("bizmsgmenuid", queryParameter);
                    aw.Rg().a(new com.tencent.mm.modelmulti.h(mVar.username, decode, t.nK(mVar.username), 291, hashMap), 0);
                } catch (UnsupportedEncodingException e) {
                    ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", e.getMessage());
                }
                AppMethodBeat.o(15640);
                return true;
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class CardUriSpanHandler extends BaseUriSpanHandler {
        CardUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15641);
            if (str.startsWith("wxcard://cardjumptype=1")) {
                String str2 = null;
                if (vVar != null) {
                    str2 = vVar.dgT().toString();
                }
                Intent intent = new Intent();
                intent.putExtra("user_name", str2);
                intent.putExtra("view_type", 1);
                d.b(URISpanHandlerSet.this.mContext, "card", ".ui.CardViewUI", intent);
                AppMethodBeat.o(15641);
                return true;
            }
            AppMethodBeat.o(15641);
            return false;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        ContactUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            m mVar = null;
            AppMethodBeat.i(15642);
            if (str.trim().equals("weixin://contacts/all/")) {
                mVar = new m(str, 23, new y("@all.android", null, URISpanHandlerSet.this.mContext.getString(R.string.c_0), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                mVar = new m(str, 22, z.nZ(URISpanHandlerSet.this.mContext.getString(R.string.c_3)));
            } else if (str.trim().equals("weixin://contacts/micromessenger/")) {
                mVar = new m(str, 2, new y("@micromsg.qq.com", null, URISpanHandlerSet.this.mContext.getString(R.string.c_4), null, true, true));
            } else if (str.trim().startsWith("weixin://contacts/")) {
                String substring = str.trim().substring(0, str.trim().length() - 1);
                int lastIndexOf = substring.lastIndexOf("/");
                if (lastIndexOf == -1) {
                    AppMethodBeat.o(15642);
                    return mVar;
                }
                mVar = new m(str, 21, z.ag("@".concat(String.valueOf(substring.substring(lastIndexOf + 1))), URISpanHandlerSet.this.mContext.getString(R.string.c_2)));
            }
            AppMethodBeat.o(15642);
            return mVar;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{23, 21, 22, 2};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15644);
            if (str.equals("weixin://contacts/microblog/") || str.equals("weixin://contacts/micromessenger/") || str.equals("weixin://contacts/all/")) {
                y nZ = z.nZ(URISpanHandlerSet.this.mContext.getString(R.string.c_4));
                if (str.equals("weixin://contacts/microblog/")) {
                    nZ = z.nZ(URISpanHandlerSet.this.mContext.getString(R.string.c_3));
                }
                if (str.equals("weixin://contacts/micromessenger/")) {
                    nZ = z.nZ(URISpanHandlerSet.this.mContext.getString(R.string.c_4));
                }
                if (str.equals("weixin://contacts/all/")) {
                    nZ = z.nZ(URISpanHandlerSet.this.mContext.getString(R.string.c_0));
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nZ.getType()).putExtra("Contact_GroupFilter_Str", nZ.Zq()).putExtra("Contact_GroupFilter_DisplayName", nZ.Oi());
                intent.addFlags(268435456);
                AppMethodBeat.o(15644);
                return true;
            }
            AppMethodBeat.o(15644);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            boolean z = false;
            AppMethodBeat.i(15643);
            int i = mVar.type;
            if (i == 23 || i == 21 || i == 22 || i == 2) {
                y yVar = (y) mVar.au(y.class);
                if (gVar != null) {
                    gVar.a(mVar);
                }
                if (yVar == null) {
                    com.tencent.mm.ui.base.h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.cmm), URISpanHandlerSet.this.mContext.getString(R.string.tz), true);
                    AppMethodBeat.o(15643);
                    return false;
                }
                if (yVar.getType().equals("@t.qq.com")) {
                    boolean z2;
                    if (((j) com.tencent.mm.kernel.g.K(j.class)).XU().RA("@t.qq.com") != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        com.tencent.mm.ui.base.h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.cmm), URISpanHandlerSet.this.mContext.getString(R.string.tz), true);
                    }
                }
                if (yVar.getType().equals("@domain.android")) {
                    List bOJ = ((j) com.tencent.mm.kernel.g.K(j.class)).XU().bOJ();
                    if (bOJ.size() > 0) {
                        for (int i2 = 0; i2 < bOJ.size(); i2++) {
                            if (((bq) bOJ.get(i2)).isEnable()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        com.tencent.mm.ui.base.h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.cmm), URISpanHandlerSet.this.mContext.getString(R.string.tz), true);
                    }
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", yVar.getType()).putExtra("Contact_GroupFilter_Str", yVar.Zq()).putExtra("Contact_GroupFilter_DisplayName", yVar.Oi());
                intent.addFlags(268435456);
                URISpanHandlerSet.this.mContext.startActivity(intent);
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15643);
                return true;
            }
            AppMethodBeat.o(15643);
            return false;
        }
    }

    @a(Cn = PRIORITY.LOW)
    class DeeplinkUriSpanHandler extends BaseUriSpanHandler {
        DeeplinkUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15649);
            ab.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", str);
            if (str.trim().toLowerCase().startsWith("weixin://")) {
                m mVar = new m(str, 30, null);
                AppMethodBeat.o(15649);
                return mVar;
            }
            AppMethodBeat.o(15649);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{30};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            String str;
            AppMethodBeat.i(15650);
            ab.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", Integer.valueOf(mVar.type), mVar.url);
            if (gVar != null) {
                str = (String) gVar.a(mVar);
            } else {
                str = null;
            }
            if (mVar.type == 30) {
                final String nullAsNil = bo.nullAsNil(mVar.url);
                if (nullAsNil.startsWith("weixin://shieldBrandMsg/") || nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                    if (bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                        AppMethodBeat.o(15650);
                        return true;
                    }
                    final com.tencent.mm.aj.d qX = f.qX(str);
                    if (qX == null) {
                        ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                        AppMethodBeat.o(15650);
                        return true;
                    } else if (nullAsNil.startsWith("weixin://shieldBrandMsg/")) {
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.eve, (int) R.string.tz, (int) R.string.evd, (int) R.string.abx, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(15645);
                                int i2 = qX.field_brandFlag;
                                qX.field_brandFlag |= 1;
                                ab.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i2), Integer.valueOf(qX.field_brandFlag));
                                f.f(qX);
                                AppMethodBeat.o(15645);
                            }
                        }, null);
                    } else if (nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.evc, (int) R.string.tz, (int) R.string.evb, (int) R.string.abx, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(15646);
                                int i2 = qX.field_brandFlag;
                                qX.field_brandFlag &= -2;
                                ab.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i2), Integer.valueOf(qX.field_brandFlag));
                                f.f(qX);
                                AppMethodBeat.o(15646);
                            }
                        }, null);
                    }
                } else if (com.tencent.mm.pluginsdk.e.s(Uri.parse(nullAsNil))) {
                    com.tencent.mm.pluginsdk.e.A(URISpanHandlerSet.this.mContext, str, nullAsNil);
                } else if (!nullAsNil.startsWith("weixin://receiveWeAppKFMsg")) {
                    com.tencent.mm.pluginsdk.e.a(URISpanHandlerSet.this.mContext, nullAsNil, str, 1, nullAsNil, null);
                } else if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", nullAsNil);
                    AppMethodBeat.o(15650);
                    return true;
                } else {
                    com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.ng, (int) R.string.tz, (int) R.string.nf, (int) R.string.abx, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(15647);
                            ab.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", str);
                            com.tencent.mm.ui.appbrand.b.k(URISpanHandlerSet.this.mContext, str, true);
                            AppMethodBeat.o(15647);
                        }
                    }, null);
                }
                AppMethodBeat.o(15650);
                return true;
            }
            AppMethodBeat.o(15650);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15651);
            if (bo.isNullOrNil(str) || bundle == null) {
                String str2 = "MicroMsg.URISpanHandlerSet";
                String str3 = "url is null ? %b, paramsBundle is null ? %b";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(str == null);
                objArr[1] = Boolean.valueOf(bundle == null);
                ab.e(str2, str3, objArr);
                AppMethodBeat.o(15651);
                return false;
            } else if (com.tencent.mm.pluginsdk.e.s(Uri.parse(str))) {
                int i = bundle.getInt("key_scene", -1);
                ab.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", Integer.valueOf(i), str);
                if (i == -1) {
                    i = 5;
                }
                final p b = com.tencent.mm.ui.base.h.b(URISpanHandlerSet.this.mContext, "", true, null);
                com.tencent.mm.pluginsdk.e.a(URISpanHandlerSet.this.mContext, str, i, new com.tencent.mm.pluginsdk.e.a() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ai.m mVar, boolean z) {
                        AppMethodBeat.i(15648);
                        if (b != null && b.isShowing()) {
                            b.dismiss();
                        }
                        if (!(mVar == null || i == 0 || i2 == 0 || !(mVar instanceof com.tencent.mm.modelsimple.z))) {
                            ciq ajE = ((com.tencent.mm.modelsimple.z) mVar).ajE();
                            if (!(ajE == null || URISpanHandlerSet.this.mContext == null)) {
                                com.tencent.mm.ui.base.t.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.tz) + " : " + bo.nullAsNil(ajE.xhy), 0).show();
                            }
                        }
                        AppMethodBeat.o(15648);
                    }
                });
                AppMethodBeat.o(15651);
                return true;
            } else {
                AppMethodBeat.o(15651);
                return false;
            }
        }
    }

    @a
    class EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
        EmotionStoreUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15652);
            if (str.trim().startsWith("weixin://emoticonstore/")) {
                int lastIndexOf = str.lastIndexOf("/");
                Object obj = "";
                if (lastIndexOf != -1) {
                    obj = str.substring(lastIndexOf + 1);
                }
                m mVar = new m(str, 29, obj);
                AppMethodBeat.o(15652);
                return mVar;
            }
            AppMethodBeat.o(15652);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{29};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15653);
            if (mVar.type == 29) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                Intent intent = new Intent();
                intent.putExtra("download_entrance_scene", 21);
                intent.putExtra("extra_id", (String) mVar.au(String.class));
                intent.putExtra("preceding_scence", 3);
                d.b(URISpanHandlerSet.this.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent);
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15653);
                return true;
            }
            AppMethodBeat.o(15653);
            return false;
        }
    }

    @a
    class PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
        PhoneEmailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{25, 24};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15683);
            if (mVar.type == 25) {
                String str = mVar.username;
                Bundle bundle = new Bundle();
                if (!(str == null || str.equals(r.Yz()))) {
                    bundle.putString("Contact_User", str);
                    com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(str);
                    if (vT == null || bo.isNullOrNil(vT.Aq())) {
                        str = null;
                    } else {
                        str = bo.nullAsNil(vT.apG()).replace(" ", "");
                    }
                    bundle.putString("Contact_Mobile_MD5", str);
                }
                bundle.putInt("fromScene", 1);
                l.a(URISpanHandlerSet.this.mContext, mVar.url, null, bundle);
                AppMethodBeat.o(15683);
                return true;
            }
            if (mVar.type == 24) {
                l.b(URISpanHandlerSet.this.mContext, mVar.url, null);
            }
            AppMethodBeat.o(15683);
            return false;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        VerifyContactUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15718);
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                m mVar = new m(str, 4, null);
                AppMethodBeat.o(15718);
                return mVar;
            }
            AppMethodBeat.o(15718);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{4};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15719);
            if (mVar.type == 4) {
                if (gVar != null) {
                    gVar.a(mVar);
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15719);
                return true;
            }
            AppMethodBeat.o(15719);
            return false;
        }
    }

    @a
    class AppBrandLinkSpanHandler extends BaseUriSpanHandler {
        AppBrandLinkSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{45};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15635);
            if (mVar.type == 45) {
                if (gVar != null) {
                    ab.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
                    gVar.b(mVar);
                    AppMethodBeat.o(15635);
                    return true;
                }
                ab.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
            }
            AppMethodBeat.o(15635);
            return false;
        }
    }

    @a
    class JumpActivityUriSpanHandler extends BaseUriSpanHandler {
        JumpActivityUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15675);
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
                    h.pYm.X(10221, "1");
                    intent = new Intent();
                    intent.addFlags(67108864);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    d.b(URISpanHandlerSet.this.mContext, "shake", ".ui.ShakeReportUI", intent);
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
                    d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent);
                }
                AppMethodBeat.o(15675);
                return true;
            }
            AppMethodBeat.o(15675);
            return false;
        }
    }

    @a
    class PayUriSpanHandler extends BaseUriSpanHandler {
        PayUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{28};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15682);
            if (mVar.type == 28) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                com.tencent.mm.sdk.b.b heVar = new he();
                heVar.cBW.actionCode = 11;
                heVar.cBW.result = mVar.url;
                heVar.cBW.context = URISpanHandlerSet.this.mContext;
                heVar.cBW.cBY = new Bundle();
                heVar.cBW.cBY.putInt("pay_channel", 6);
                com.tencent.mm.sdk.b.a.xxA.a(heVar, Looper.myLooper());
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15682);
                return true;
            }
            AppMethodBeat.o(15682);
            return false;
        }
    }

    @a
    class SettingBindEmailUriSpanHandler extends BaseUriSpanHandler {
        SettingBindEmailUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15691);
            if (str.trim().startsWith("weixin://setting/bindemail")) {
                m mVar = new m(str, 7, null);
                AppMethodBeat.o(15691);
                return mVar;
            }
            AppMethodBeat.o(15691);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{7};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15692);
            if (mVar.type == 7) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15692);
                return true;
            }
            AppMethodBeat.o(15692);
            return false;
        }
    }

    @a
    class SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
        SettingBlacklistUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15693);
            if (str.trim().startsWith("weixin://setting/blacklist")) {
                m mVar = new m(str, 14, null);
                AppMethodBeat.o(15693);
                return mVar;
            }
            AppMethodBeat.o(15693);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{14};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15695);
            if (str.equals("weixin://setting/blacklist")) {
                y nY = z.nY(URISpanHandlerSet.this.mContext.getString(R.string.c_1));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, AddressUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nY.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", nY.Oi());
                intent.addFlags(67108864);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                AppMethodBeat.o(15695);
                return true;
            }
            AppMethodBeat.o(15695);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15694);
            if (mVar.type == 14) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                y nY = z.nY(URISpanHandlerSet.this.mContext.getString(R.string.c_1));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", nY.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", nY.Oi());
                intent.addFlags(67108864);
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                URISpanHandlerSet.this.mContext.startActivity(intent);
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15694);
                return true;
            }
            AppMethodBeat.o(15694);
            return false;
        }
    }

    abstract class BaseUriSpanHandler {
        public abstract int[] Cm();

        public abstract boolean a(m mVar, g gVar);

        public abstract boolean a(String str, boolean z, v vVar, Bundle bundle);

        public abstract m dr(String str);
    }

    @a
    class ExposeUriSpanHandler extends BaseUriSpanHandler {
        ExposeUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15655);
            if (str.trim().toLowerCase().equals("weixin://expose/")) {
                m mVar = new m(str, 31, null);
                AppMethodBeat.o(15655);
                return mVar;
            }
            AppMethodBeat.o(15655);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{31};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15656);
            if (mVar.type == 31) {
                Intent intent = new Intent();
                if (gVar == null) {
                    AppMethodBeat.o(15656);
                    return false;
                }
                int i;
                String str = (String) gVar.a(mVar);
                intent.putExtra("k_username", str);
                if (bo.isNullOrNil(str) || !str.endsWith("@chatroom")) {
                    i = 39;
                } else {
                    i = 36;
                }
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(15656);
                return true;
            }
            AppMethodBeat.o(15656);
            return false;
        }
    }

    @a
    class FriendShareUriSpanHandler extends BaseUriSpanHandler {
        FriendShareUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15668);
            if (str.trim().startsWith("weixin://findfriend/share")) {
                m mVar = new m(str, 18, null);
                AppMethodBeat.o(15668);
                return mVar;
            }
            AppMethodBeat.o(15668);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{18};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15670);
            if (str.equals("weixin://findfriend/share")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
                AppMethodBeat.o(15670);
                return true;
            }
            AppMethodBeat.o(15670);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15669);
            if (mVar.type == 18) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                d.H(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15669);
                return true;
            }
            AppMethodBeat.o(15669);
            return false;
        }
    }

    @a
    class AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
        AlphaInstallUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15633);
            if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
                m mVar = new m(str, 32, null);
                AppMethodBeat.o(15633);
                return mVar;
            }
            AppMethodBeat.o(15633);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{32};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15634);
            if (mVar.type == 32) {
                String replace = mVar.url.replace("weixin://alphainstall?", "");
                String str = com.tencent.mm.compatible.util.e.eSn + Uri.parse(replace).getQueryParameter("md5") + ".apk";
                if (com.tencent.mm.vfs.e.ct(str)) {
                    bo.k(str, ah.getContext());
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", replace.toString());
                    d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(15634);
                return true;
            }
            AppMethodBeat.o(15634);
            return false;
        }
    }

    @a
    class BindMobileUrilSpanHandler extends BaseUriSpanHandler {
        BindMobileUrilSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15636);
            if (str.trim().startsWith("weixin://setting/bindphone")) {
                m mVar = new m(str, 5, null);
                AppMethodBeat.o(15636);
                return mVar;
            }
            AppMethodBeat.o(15636);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{5};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15638);
            if (str.equals("weixin://setting/bindphone")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                MMWizardActivity.J(URISpanHandlerSet.this.mContext, intent);
                AppMethodBeat.o(15638);
                return true;
            }
            AppMethodBeat.o(15638);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15637);
            if (mVar.type == 5) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                MMWizardActivity.J(URISpanHandlerSet.this.mContext, new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class));
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15637);
                return true;
            }
            AppMethodBeat.o(15637);
            return false;
        }
    }

    @a
    class FriendSearchUriSpanHandler extends BaseUriSpanHandler {
        FriendSearchUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15665);
            if (str.trim().startsWith("weixin://findfriend/search")) {
                m mVar = new m(str, 17, null);
                AppMethodBeat.o(15665);
                return mVar;
            }
            AppMethodBeat.o(15665);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{17};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15667);
            if (str.equals("weixin://findfriend/search")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", intent);
                AppMethodBeat.o(15667);
                return true;
            }
            AppMethodBeat.o(15667);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15666);
            if (mVar.type == 17) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                d.H(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15666);
                return true;
            }
            AppMethodBeat.o(15666);
            return false;
        }
    }

    @a
    class HoneyPayLinkSpanHandler extends BaseUriSpanHandler {
        HoneyPayLinkSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15671);
            m mVar;
            if (str.trim().startsWith("native://wcpay/honeypay")) {
                mVar = new m(str, 46, null);
                AppMethodBeat.o(15671);
                return mVar;
            } else if (str.trim().startsWith("weixin://wcpay/bankCardList")) {
                mVar = new m(str, 47, null);
                AppMethodBeat.o(15671);
                return mVar;
            } else {
                AppMethodBeat.o(15671);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{46, 47};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15672);
            if (mVar.type == 46) {
                ab.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
                if (mVar.data != null && (mVar.data instanceof Bundle)) {
                    Uri parse = Uri.parse(mVar.url);
                    String queryParameter = parse.getQueryParameter("cardNo");
                    boolean equals = parse.getQueryParameter("isPayer").equals("1");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", queryParameter);
                    intent.putExtra("key_is_payer", equals);
                    d.b(URISpanHandlerSet.this.mContext, "honey_pay", ".ui.HoneyPayProxyUI", intent);
                }
            } else if (mVar.type == 47) {
                ab.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
                Intent intent2 = new Intent();
                intent2.putExtra("intent_finish_self", true);
                d.b(URISpanHandlerSet.this.mContext, "wallet", ".bind.ui.WalletBankcardManageUI", intent2);
                h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            AppMethodBeat.o(15672);
            return false;
        }
    }

    @a(Cn = PRIORITY.HIGH)
    class LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
        LuckyMoneyUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15676);
            if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
                m mVar = new m(str, 33, null);
                AppMethodBeat.o(15676);
                return mVar;
            }
            AppMethodBeat.o(15676);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{33};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15677);
            if (mVar.type != 33) {
                AppMethodBeat.o(15677);
                return false;
            } else if (gVar == null) {
                ab.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
                AppMethodBeat.o(15677);
                return false;
            } else {
                Intent intent = new Intent();
                intent.putExtra("key_native_url", mVar.url);
                intent.putExtra("key_username", (String) gVar.a(mVar));
                intent.putExtra("key_lucky_money_can_received", true);
                d.b(URISpanHandlerSet.this.mContext, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                h.pYm.e(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                h.pYm.e(11850, Integer.valueOf(4), Integer.valueOf(1));
                AppMethodBeat.o(15677);
                return true;
            }
        }
    }

    @a
    class ScanQrCodeUriSpanHandler extends BaseUriSpanHandler {
        ScanQrCodeUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[0];
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            boolean z2 = false;
            AppMethodBeat.i(15689);
            if (!str.equals("weixin://scanqrcode/")) {
                AppMethodBeat.o(15689);
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
                    d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.SingleTopScanUI", intent);
                    AppMethodBeat.o(15689);
                    return true;
                }
                d.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.o(15689);
                return true;
            } else {
                ab.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
                AppMethodBeat.o(15689);
                return true;
            }
        }
    }

    @a
    class SettingHeadImgUriSpanHandler extends BaseUriSpanHandler {
        SettingHeadImgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15696);
            if (str.trim().startsWith("weixin://setting/setheadimage")) {
                m mVar = new m(str, 6, null);
                AppMethodBeat.o(15696);
                return mVar;
            }
            AppMethodBeat.o(15696);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{6};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15698);
            if (str.equals("weixin://setting/setheadimage")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", r.Yz());
                intent.putExtra("Contact_Nick", r.YB());
                intent.putExtra("User_Avatar", true);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(15698);
                return true;
            }
            AppMethodBeat.o(15698);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15697);
            if (mVar.type == 6) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.yjJ.getMainTabUI().aqG("tab_settings");
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15697);
                return true;
            }
            AppMethodBeat.o(15697);
            return false;
        }
    }

    @a
    class SettingPluginLomoUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginLomoUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15702);
            if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
                m mVar = new m(str, 12, null);
                AppMethodBeat.o(15702);
                return mVar;
            }
            AppMethodBeat.o(15702);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{12};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            AppMethodBeat.i(15704);
            if (str.equals("weixin://setting/plugin/lomo")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(15704);
                return true;
            }
            AppMethodBeat.o(15704);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15703);
            if (mVar.type == 12) {
                if (gVar != null) {
                    gVar.a(mVar);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                d.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15703);
                return true;
            }
            AppMethodBeat.o(15703);
            return false;
        }
    }

    @a
    class SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginSxMsgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15709);
            if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
                m mVar = new m(str, 11, null);
                AppMethodBeat.o(15709);
                return mVar;
            }
            AppMethodBeat.o(15709);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{11};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        AAUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15630);
            m mVar;
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                mVar = new m(str, 35, null);
                AppMethodBeat.o(15630);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                mVar = new m(str, 36, null);
                AppMethodBeat.o(15630);
                return mVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa")) {
                mVar = new m(str, 37, null);
                AppMethodBeat.o(15630);
                return mVar;
            } else {
                AppMethodBeat.o(15630);
                return null;
            }
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{35, 36, 37};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15631);
            if (mVar.type == 35) {
                try {
                    String queryParameter = Uri.parse(mVar.url).getQueryParameter("billno");
                    if (bo.isNullOrNil(queryParameter)) {
                        ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        AppMethodBeat.o(15631);
                        return true;
                    }
                    String string;
                    if (mVar.data instanceof Bundle) {
                        string = ((Bundle) mVar.data).getString("chatroom_name");
                    } else if (mVar.data instanceof String) {
                        string = mVar.data.toString();
                    } else {
                        ab.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", mVar);
                        AppMethodBeat.o(15631);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom", string);
                    d.b(URISpanHandlerSet.this.mContext, "aa", ".ui.PaylistAAUI", intent);
                    AppMethodBeat.o(15631);
                    return true;
                } catch (Exception e) {
                    ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", e.getMessage(), mVar.url);
                }
            } else {
                final String queryParameter2;
                Bundle bundle;
                final String string2;
                final long j;
                if (mVar.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(mVar.url).getQueryParameter("billno");
                        if (bo.isNullOrNil(queryParameter2)) {
                            ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.o(15631);
                            return true;
                        } else if (mVar.data instanceof Bundle) {
                            bundle = (Bundle) mVar.data;
                            string2 = bundle.getString("chatroom_name");
                            if (bo.isNullOrNil(string2)) {
                                ab.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                AppMethodBeat.o(15631);
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                ab.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                AppMethodBeat.o(15631);
                                return true;
                            }
                            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, R.string.erg, -1, R.string.erj, R.string.abx, (OnClickListener) new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(15628);
                                    br brVar = new br();
                                    brVar.cuN.cuO = queryParameter2;
                                    brVar.cuN.cuP = string2;
                                    brVar.cuN.cuQ = j;
                                    com.tencent.mm.sdk.b.a.xxA.m(brVar);
                                    AppMethodBeat.o(15628);
                                }
                            }, null);
                        } else {
                            ab.e("MicroMsg.URISpanHandlerSet", "error data!");
                            AppMethodBeat.o(15631);
                            return true;
                        }
                    } catch (Exception e2) {
                        ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", e2.getMessage(), mVar.url);
                    }
                } else if (mVar.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(mVar.url).getQueryParameter("billno");
                        if (bo.isNullOrNil(queryParameter2)) {
                            ab.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.o(15631);
                            return true;
                        }
                        bundle = null;
                        if (mVar.data instanceof Bundle) {
                            bundle = (Bundle) mVar.data;
                        }
                        if (bundle == null || bo.isNullOrNil(bundle.getString("chatroom_name"))) {
                            ab.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            AppMethodBeat.o(15631);
                            return true;
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, R.string.erh, -1, R.string.eri, R.string.abx, (OnClickListener) new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(15629);
                                bs bsVar = new bs();
                                bsVar.cuR.cuO = queryParameter2;
                                bsVar.cuR.cuP = string2;
                                bsVar.cuR.cuQ = j;
                                com.tencent.mm.sdk.b.a.xxA.m(bsVar);
                                AppMethodBeat.o(15629);
                            }
                        }, null);
                    } catch (Exception e22) {
                        ab.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", e22.getMessage(), mVar.url);
                    }
                }
                AppMethodBeat.o(15631);
                return false;
            }
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        FeedbackUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15657);
            if (str.trim().startsWith("weixin://feedback/next/")) {
                m mVar = new m(str, 34, null);
                AppMethodBeat.o(15657);
                return mVar;
            }
            AppMethodBeat.o(15657);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{34};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15658);
            if (mVar.type == 34) {
                ab.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", mVar.url, mVar.url.trim().replace("weixin://feedback/next/", ""));
                aw.Rg().a(new com.tencent.mm.plugin.setting.model.j(q.Mc(), r2, 8), 0);
                AppMethodBeat.o(15658);
                return true;
            }
            AppMethodBeat.o(15658);
            return false;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        HttpUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            m mVar;
            AppMethodBeat.i(15673);
            if (str.trim().toLowerCase().startsWith("http")) {
                mVar = new m(str, 1, null);
            } else {
                mVar = null;
            }
            AppMethodBeat.o(15673);
            return mVar;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{1};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            AppMethodBeat.i(15674);
            if (mVar.type == 1) {
                y ag;
                String str;
                boolean z = URISpanHandlerSet.this.mContext != null && (URISpanHandlerSet.this.mContext instanceof WebViewUI);
                mVar.au(y.class);
                if (!z || ah.bqo()) {
                    ag = z.ag("@" + mVar.url, URISpanHandlerSet.this.mContext.getString(R.string.c_2));
                } else {
                    ag = null;
                }
                if (gVar != null) {
                    str = (String) gVar.a(mVar);
                } else {
                    str = null;
                }
                if (ag == null || !ag.enable) {
                    String str2 = mVar.url;
                    if (!str2.toLowerCase().startsWith("http")) {
                        str2 = "http://".concat(String.valueOf(str2));
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    if (mVar.data != null && (mVar.data instanceof Integer)) {
                        intent.putExtra("geta8key_scene", ((Integer) mVar.data).intValue());
                    }
                    str2 = mVar.hcl;
                    if (!bo.isNullOrNil(str2)) {
                        com.tencent.mm.model.v.b nV = com.tencent.mm.model.v.Zp().nV(str2);
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
                            intent.putExtra("preChatTYPE", u.ad(string2, string3));
                        }
                    }
                    intent.putExtra("geta8key_username", bo.isNullOrNil(str) ? null : str);
                    if (z) {
                        intent.addFlags(268435456);
                    } else {
                        intent.addFlags(536870912);
                    }
                    d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                }
                if (gVar != null) {
                    gVar.b(mVar);
                }
                AppMethodBeat.o(15674);
                return true;
            }
            AppMethodBeat.o(15674);
            return false;
        }
    }

    @a
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMsgUriSpanHandler() {
            super();
        }

        /* Access modifiers changed, original: final */
        public final m dr(String str) {
            AppMethodBeat.i(15708);
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                m mVar = new m(str, 13, null);
                AppMethodBeat.o(15708);
                return mVar;
            }
            AppMethodBeat.o(15708);
            return null;
        }

        /* Access modifiers changed, original: final */
        public final int[] Cm() {
            return new int[]{13};
        }

        /* Access modifiers changed, original: final */
        public final boolean a(m mVar, g gVar) {
            return false;
        }

        /* Access modifiers changed, original: final */
        public final boolean a(String str, boolean z, v vVar, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        AppMethodBeat.i(15722);
        this.mContext = context == null ? ah.getContext() : this.mContext;
        AppMethodBeat.o(15722);
    }
}
