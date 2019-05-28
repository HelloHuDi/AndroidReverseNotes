package com.tencent.p177mm.plugin.search.p1292a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.plugin.search.a.a */
public final class C34844a {
    public static final SparseArray<C21732a> qiX;

    /* renamed from: com.tencent.mm.plugin.search.a.a$a */
    static class C21732a {
        /* renamed from: id */
        int f4393id;
        int qiY;
        String qiZ;
        boolean qja;
        String uri;
        String username;

        public C21732a(int i, int i2, String str, String str2, String str3) {
            this(i, i2, str, str2, str3, (byte) 0);
        }

        public C21732a(int i, int i2, String str, String str2, String str3, byte b) {
            this.f4393id = i;
            this.qiY = i2;
            this.uri = str;
            this.qiZ = str2;
            this.username = str3;
        }
    }

    static {
        AppMethodBeat.m2504i(24402);
        SparseArray sparseArray = new SparseArray();
        qiX = sparseArray;
        sparseArray.put(19, new C21732a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        qiX.put(30, new C21732a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        qiX.put(18, new C21732a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        qiX.put(17, new C21732a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        qiX.put(16, new C21732a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        qiX.put(31, new C21732a(31, -1, ".ui.GameCenterUI", "game", ""));
        qiX.put(20, new C21732a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        qiX.put(21, new C21732a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        qiX.put(26, new C21732a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        qiX.put(29, new C21732a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        qiX.put(23, new C21732a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        qiX.put(1, new C21732a(1, -1, ".ui.MallIndexUI", "mall", ""));
        qiX.put(24, new C21732a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        qiX.put(27, new C21732a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        qiX.put(28, new C21732a(28, SQLiteGlobal.journalSizeLimit, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        qiX.put(32, new C21732a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        qiX.put(33, new C21732a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        qiX.put(34, new C21732a(34, -1, ".ui.MallIndexUI", "mall", ""));
        qiX.put(35, new C21732a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        qiX.put(38, new C21732a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        qiX.put(39, new C21732a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        qiX.put(6, new C21732a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        qiX.put(41, new C21732a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        qiX.put(42, new C21732a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        qiX.put(40, new C21732a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        qiX.put(43, new C21732a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
        qiX.put(50, new C21732a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        qiX.put(51, new C21732a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
        qiX.put(66, new C21732a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
        qiX.put(63, new C21732a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
        qiX.put(64, new C21732a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
        qiX.put(65, new C21732a(65, -1, "", "", ""));
        qiX.put(67, new C21732a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
        AppMethodBeat.m2505o(24402);
    }

    /* renamed from: aR */
    private static boolean m57235aR(Context context, String str) {
        AppMethodBeat.m2504i(24400);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(24400);
        return true;
    }

    /* renamed from: U */
    public static boolean m57234U(Context context, int i) {
        AppMethodBeat.m2504i(24401);
        if (qiX.indexOfKey(i) < 0) {
            AppMethodBeat.m2505o(24401);
            return false;
        } else if (i == 30 && (C35973a.m59178bI(context) || C35973a.m59177bH(context))) {
            AppMethodBeat.m2505o(24401);
            return false;
        } else {
            C21732a c21732a = (C21732a) qiX.get(i);
            boolean aR;
            if (c21732a.qiY != -1 && (C1853r.m3829YK() & c21732a.qiY) != 0) {
                aR = C34844a.m57235aR(context, c21732a.username);
                AppMethodBeat.m2505o(24401);
                return aR;
            } else if (!C5046bo.isNullOrNil(c21732a.qiZ)) {
                Intent intent = new Intent();
                if (i == 28) {
                    intent.putExtra("type", 20);
                }
                if (i == 1) {
                    intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
                }
                intent.putExtra("animation_pop_in", c21732a.qja);
                if (i == 32) {
                    C7060h.pYm.mo8381e(12065, Integer.valueOf(6));
                }
                if (i == 6) {
                    intent.putExtra("pay_channel", 15);
                }
                if (i == 31) {
                    intent.putExtra("game_report_from_scene", 4);
                }
                if (i == 41) {
                    intent.putExtra("key_from_scene", 5);
                }
                if (i == 42) {
                    intent.putExtra("key_from_scene", 4);
                }
                if (i == 64) {
                    intent.putExtra("entry_fix_tools", 1);
                }
                if (i == 63 || i == 67) {
                    intent.putExtra("biz_enter_source", 2);
                }
                if (i == 33) {
                    C39037b.m66371b(context, ".ui.FavoriteIndexUI", new Intent());
                } else if (i == 35) {
                    intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                    MMWizardActivity.m23791J(context, intent);
                } else if (i == 66) {
                    ((C19731g) C1720g.m3528K(C19731g.class)).mo34964b(context, 16, false);
                } else if (c21732a.qiZ.equals("app")) {
                    C25985d.m41473f(context, c21732a.uri, intent);
                } else {
                    C25985d.m41467b(context, c21732a.qiZ, c21732a.uri, intent);
                }
                C5274b.m8044K(context, intent);
                AppMethodBeat.m2505o(24401);
                return true;
            } else if (i == 65) {
                C4210c.m6554W(context, 21);
                AppMethodBeat.m2505o(24401);
                return true;
            } else if (c21732a.uri.equals(".ui.chatting.ChattingUI")) {
                String str = c21732a.username;
                if (C7486a.m12942jh(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Chat_User", str);
                    intent2.putExtra("finish_direct", true);
                    C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent2);
                } else {
                    C34844a.m57235aR(context, str);
                }
                AppMethodBeat.m2505o(24401);
                return true;
            } else if (c21732a.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
                aR = C34844a.m57235aR(context, c21732a.username);
                AppMethodBeat.m2505o(24401);
                return aR;
            } else {
                C4990ab.m7412e("MicroMsg.Feature", "Error URI of android feature");
                AppMethodBeat.m2505o(24401);
                return false;
            }
        }
    }
}
