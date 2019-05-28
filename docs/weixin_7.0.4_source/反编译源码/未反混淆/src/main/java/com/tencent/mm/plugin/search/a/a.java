package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    public static final SparseArray<a> qiX;

    static class a {
        int id;
        int qiY;
        String qiZ;
        boolean qja;
        String uri;
        String username;

        public a(int i, int i2, String str, String str2, String str3) {
            this(i, i2, str, str2, str3, (byte) 0);
        }

        public a(int i, int i2, String str, String str2, String str3, byte b) {
            this.id = i;
            this.qiY = i2;
            this.uri = str;
            this.qiZ = str2;
            this.username = str3;
        }
    }

    static {
        AppMethodBeat.i(24402);
        SparseArray sparseArray = new SparseArray();
        qiX = sparseArray;
        sparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        qiX.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        qiX.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        qiX.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        qiX.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        qiX.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
        qiX.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        qiX.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        qiX.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        qiX.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        qiX.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        qiX.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
        qiX.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        qiX.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        qiX.put(28, new a(28, SQLiteGlobal.journalSizeLimit, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        qiX.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        qiX.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        qiX.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
        qiX.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        qiX.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        qiX.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        qiX.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        qiX.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        qiX.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        qiX.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        qiX.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
        qiX.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        qiX.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
        qiX.put(66, new a(66, -1, ".ui.AppBrandLauncherUI", "appbrand", ""));
        qiX.put(63, new a(63, -1, ".ui.conversation.BizConversationUI", "app", ""));
        qiX.put(64, new a(64, -1, ".plugin.setting.ui.fixtools.FixToolsUI", "app", ""));
        qiX.put(65, new a(65, -1, "", "", ""));
        qiX.put(67, new a(67, -1, ".plugin.brandservice.ui.timeline.BizTimeLineUI", "app", ""));
        AppMethodBeat.o(24402);
    }

    private static boolean aR(Context context, String str) {
        AppMethodBeat.i(24400);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(24400);
        return true;
    }

    public static boolean U(Context context, int i) {
        AppMethodBeat.i(24401);
        if (qiX.indexOfKey(i) < 0) {
            AppMethodBeat.o(24401);
            return false;
        } else if (i == 30 && (com.tencent.mm.r.a.bI(context) || com.tencent.mm.r.a.bH(context))) {
            AppMethodBeat.o(24401);
            return false;
        } else {
            a aVar = (a) qiX.get(i);
            boolean aR;
            if (aVar.qiY != -1 && (r.YK() & aVar.qiY) != 0) {
                aR = aR(context, aVar.username);
                AppMethodBeat.o(24401);
                return aR;
            } else if (!bo.isNullOrNil(aVar.qiZ)) {
                Intent intent = new Intent();
                if (i == 28) {
                    intent.putExtra("type", 20);
                }
                if (i == 1) {
                    intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
                }
                intent.putExtra("animation_pop_in", aVar.qja);
                if (i == 32) {
                    h.pYm.e(12065, Integer.valueOf(6));
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
                    b.b(context, ".ui.FavoriteIndexUI", new Intent());
                } else if (i == 35) {
                    intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                    MMWizardActivity.J(context, intent);
                } else if (i == 66) {
                    ((g) com.tencent.mm.kernel.g.K(g.class)).b(context, 16, false);
                } else if (aVar.qiZ.equals("app")) {
                    d.f(context, aVar.uri, intent);
                } else {
                    d.b(context, aVar.qiZ, aVar.uri, intent);
                }
                com.tencent.mm.ui.base.b.K(context, intent);
                AppMethodBeat.o(24401);
                return true;
            } else if (i == 65) {
                c.W(context, 21);
                AppMethodBeat.o(24401);
                return true;
            } else if (aVar.uri.equals(".ui.chatting.ChattingUI")) {
                String str = aVar.username;
                if (com.tencent.mm.n.a.jh(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str).field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Chat_User", str);
                    intent2.putExtra("finish_direct", true);
                    d.f(context, ".ui.chatting.ChattingUI", intent2);
                } else {
                    aR(context, str);
                }
                AppMethodBeat.o(24401);
                return true;
            } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
                aR = aR(context, aVar.username);
                AppMethodBeat.o(24401);
                return aR;
            } else {
                ab.e("MicroMsg.Feature", "Error URI of android feature");
                AppMethodBeat.o(24401);
                return false;
            }
        }
    }
}
