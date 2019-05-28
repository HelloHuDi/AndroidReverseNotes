package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.List;

public final class aw extends j<av> implements d, a {
    public static final String[] fnj = new String[]{j.a(av.ccO, "fmessage_conversation")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    public e bSd;
    private final int cfQ = 1;
    protected Context mContext = null;
    private Runnable xYK = new Runnable() {
        public final void run() {
            AppMethodBeat.i(1279);
            ab.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(aw.this.dtd()));
            g.RP().Ry().set(143618, Integer.valueOf(r0));
            AppMethodBeat.o(1279);
        }
    };

    static {
        AppMethodBeat.i(1293);
        AppMethodBeat.o(1293);
    }

    public aw(e eVar) {
        super(eVar, av.ccO, "fmessage_conversation", xIq);
        AppMethodBeat.i(ActUtil.HEIGHT);
        this.bSd = eVar;
        this.mContext = ah.getContext();
        AppMethodBeat.o(ActUtil.HEIGHT);
    }

    public final Cursor baR() {
        AppMethodBeat.i(1281);
        Cursor rawQuery = this.bSd.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
        AppMethodBeat.o(1281);
        return rawQuery;
    }

    public final List<av> dtb() {
        AppMethodBeat.i(1282);
        ab.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
        while (a.moveToNext()) {
            av avVar = new av();
            avVar.d(a);
            if (!bo.isNullOrNil(avVar.field_talker)) {
                arrayList.add(avVar);
            }
        }
        a.close();
        AppMethodBeat.o(1282);
        return arrayList;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.i(1283);
        Cursor a = this.bSd.a("select count(*) from fmessage_conversation", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        ab.d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
        AppMethodBeat.o(1283);
        return i;
    }

    public final boolean ep(String str, int i) {
        AppMethodBeat.i(1284);
        if (str == null || str.length() == 0) {
            ab.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            AppMethodBeat.o(1284);
            return false;
        }
        av QR = QR(str);
        if (QR == null) {
            ab.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(1284);
            return false;
        } else if (i == QR.field_state) {
            ab.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            AppMethodBeat.o(1284);
            return true;
        } else {
            QR.field_state = i;
            QR.field_lastModifiedTime = System.currentTimeMillis();
            if (super.c(QR, new String[0])) {
                anF(str);
                AppMethodBeat.o(1284);
                return true;
            }
            AppMethodBeat.o(1284);
            return false;
        }
    }

    public final boolean dtc() {
        AppMethodBeat.i(1285);
        if (this.bSd.hY("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            ab.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            AppMethodBeat.o(1285);
            return true;
        }
        ab.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        AppMethodBeat.o(1285);
        return false;
    }

    public final int dtd() {
        int i = 0;
        AppMethodBeat.i(1286);
        Cursor a = this.bSd.a(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        ab.d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
        AppMethodBeat.o(1286);
        return i;
    }

    public final boolean apt(String str) {
        AppMethodBeat.i(1287);
        if (str == null || str.length() == 0) {
            ab.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            AppMethodBeat.o(1287);
            return false;
        }
        av QR = QR(str);
        if (QR == null || !str.equals(QR.field_talker)) {
            ab.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.o(1287);
            return false;
        }
        QR.field_isNew = 0;
        boolean c = super.c(QR, new String[0]);
        AppMethodBeat.o(1287);
        return c;
    }

    public final av QR(String str) {
        AppMethodBeat.i(1288);
        if (str == null || str.length() == 0) {
            ab.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            AppMethodBeat.o(1288);
            return null;
        }
        c avVar = new av();
        avVar.field_talker = str;
        if (super.b(avVar, new String[0])) {
            AppMethodBeat.o(1288);
            return avVar;
        }
        ab.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(str)));
        AppMethodBeat.o(1288);
        return null;
    }

    public final av apu(String str) {
        av avVar = null;
        AppMethodBeat.i(1289);
        if (str == null || str.length() == 0) {
            ab.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
            AppMethodBeat.o(1289);
        } else {
            Cursor a = this.bSd.a("select * from fmessage_conversation  where encryptTalker=" + h.escape(str), null, 2);
            if (a.moveToFirst()) {
                avVar = new av();
                avVar.d(a);
            }
            a.close();
            AppMethodBeat.o(1289);
        }
        return avVar;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(1290);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            AppMethodBeat.o(1290);
            return;
        }
        long j;
        try {
            j = bo.getLong(str, 0);
        } catch (Exception e) {
            ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
            AppMethodBeat.o(1290);
        } else if (g.RN().QY()) {
            ax axVar = new ax();
            if (((ay) ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOq()).b(j, (c) axVar)) {
                ab.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(j)));
                av QR = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOp().QR(axVar.field_talker);
                bi.a apC;
                bi.d apF;
                if (QR == null) {
                    ab.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + axVar.field_talker);
                    if (bo.isNullOrNil(axVar.field_talker)) {
                        ab.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        AppMethodBeat.o(1290);
                        return;
                    }
                    QR = new av();
                    if (axVar.field_type == 0) {
                        apC = bi.a.apC(axVar.field_msgContent);
                        QR.field_displayName = apC.getDisplayName();
                        if (apC.scene == 4 && apC.dtZ() != null) {
                            QR.field_displayName = apC.dtZ();
                        }
                        QR.field_addScene = apC.scene;
                        QR.field_isNew = 1;
                        QR.field_contentFromUsername = apC.svN;
                        QR.field_contentNickname = apC.nickname;
                        QR.field_contentPhoneNumMD5 = apC.xZi;
                        QR.field_contentFullPhoneNumMD5 = apC.xZj;
                        ab.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    } else if (axVar.dtf()) {
                        apF = bi.d.apF(axVar.field_msgContent);
                        QR.field_displayName = apF.getDisplayName();
                        QR.field_addScene = apF.scene;
                        QR.field_isNew = 1;
                        QR.field_contentFromUsername = apF.svN;
                        QR.field_contentNickname = apF.nickname;
                        QR.field_contentVerifyContent = apF.content;
                        ab.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    }
                    QR.field_lastModifiedTime = System.currentTimeMillis();
                    QR.field_state = 0;
                    QR.field_talker = axVar.field_talker;
                    QR.field_encryptTalker = axVar.field_encryptTalker;
                    QR.field_fmsgSysRowId = j;
                    QR.field_fmsgIsSend = axVar.field_isSend;
                    QR.field_fmsgType = axVar.field_type;
                    QR.field_fmsgContent = axVar.field_msgContent;
                    QR.field_recvFmsgType = axVar.dtf() ? axVar.field_type : 0;
                    ab.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + QR.field_fmsgContent);
                    ((aw) ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOp()).b((c) QR);
                } else {
                    ab.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + axVar.field_talker);
                    if (axVar.dtf()) {
                        QR.field_isNew = 1;
                    }
                    QR.field_lastModifiedTime = System.currentTimeMillis();
                    QR.field_encryptTalker = axVar.field_encryptTalker;
                    QR.field_fmsgSysRowId = j;
                    QR.field_fmsgIsSend = axVar.field_isSend;
                    QR.field_fmsgType = axVar.field_type;
                    QR.field_fmsgContent = axVar.field_msgContent;
                    if (axVar.dtf()) {
                        QR.field_recvFmsgType = axVar.field_type;
                        ab.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + QR.field_recvFmsgType);
                    }
                    if (axVar.field_type == 0) {
                        apC = bi.a.apC(axVar.field_msgContent);
                        QR.field_contentFromUsername = apC.svN;
                        QR.field_contentNickname = apC.nickname;
                        QR.field_contentPhoneNumMD5 = apC.xZi;
                        QR.field_contentFullPhoneNumMD5 = apC.xZj;
                        ab.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    } else if (axVar.dtf()) {
                        int i;
                        if (axVar.field_isSend >= 2) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            apF = bi.d.apF(axVar.field_msgContent);
                            QR.field_contentVerifyContent = apF.content;
                            QR.field_contentFromUsername = apF.svN;
                            QR.field_contentNickname = apF.nickname;
                            ab.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + QR.field_contentVerifyContent + " receive, new friend Username: " + QR.field_contentFromUsername + " new friend Nickname: " + QR.field_contentNickname);
                            String str2 = QR.field_contentFromUsername;
                            String str3 = QR.field_contentNickname;
                            kz kzVar = new kz();
                            kzVar.cGR.userName = str2;
                            kzVar.cGR.bCu = str3;
                            kzVar.cGR.type = 1;
                            com.tencent.mm.sdk.b.a.xxA.m(kzVar);
                        }
                    }
                    ((aw) ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOp()).c(QR, new String[0]);
                    if (dtd() == 0) {
                        g.RP().Ry().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                dte();
                AppMethodBeat.o(1290);
                return;
            }
            ab.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.o(1290);
        } else {
            ab.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
            AppMethodBeat.o(1290);
        }
    }

    public final void dte() {
        AppMethodBeat.i(1291);
        al.af(this.xYK);
        al.n(this.xYK, 500);
        AppMethodBeat.o(1291);
    }

    public final boolean p(long j, String str) {
        String str2;
        AppMethodBeat.i(1292);
        ab.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j), str);
        if (!bo.isNullOrNil(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + bo.vA(str) + "'";
        } else if (j > 0) {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        } else {
            AppMethodBeat.o(1292);
            return false;
        }
        if (this.bSd.hY("fmessage_conversation", str2)) {
            ab.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j), str);
            anF(str);
            AppMethodBeat.o(1292);
            return true;
        }
        AppMethodBeat.o(1292);
        return false;
    }
}
