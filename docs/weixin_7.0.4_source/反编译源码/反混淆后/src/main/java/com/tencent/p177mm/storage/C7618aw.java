package com.tencent.p177mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C6512kz;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3455d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.aw */
public final class C7618aw extends C7563j<C7568av> implements C3455d, C4931a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7568av.ccO, "fmessage_conversation")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    public C4927e bSd;
    private final int cfQ = 1;
    protected Context mContext = null;
    private Runnable xYK = new C51301();

    /* renamed from: com.tencent.mm.storage.aw$1 */
    class C51301 implements Runnable {
        C51301() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1279);
            C4990ab.m7419v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(C7618aw.this.dtd()));
            C1720g.m3536RP().mo5239Ry().set(143618, Integer.valueOf(r0));
            AppMethodBeat.m2505o(1279);
        }
    }

    static {
        AppMethodBeat.m2504i(1293);
        AppMethodBeat.m2505o(1293);
    }

    public C7618aw(C4927e c4927e) {
        super(c4927e, C7568av.ccO, "fmessage_conversation", xIq);
        AppMethodBeat.m2504i(ActUtil.HEIGHT);
        this.bSd = c4927e;
        this.mContext = C4996ah.getContext();
        AppMethodBeat.m2505o(ActUtil.HEIGHT);
    }

    public final Cursor baR() {
        AppMethodBeat.m2504i(1281);
        Cursor rawQuery = this.bSd.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
        AppMethodBeat.m2505o(1281);
        return rawQuery;
    }

    public final List<C7568av> dtb() {
        AppMethodBeat.m2504i(1282);
        C4990ab.m7419v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
        while (a.moveToNext()) {
            C7568av c7568av = new C7568av();
            c7568av.mo8995d(a);
            if (!C5046bo.isNullOrNil(c7568av.field_talker)) {
                arrayList.add(c7568av);
            }
        }
        a.close();
        AppMethodBeat.m2505o(1282);
        return arrayList;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(1283);
        Cursor a = this.bSd.mo10104a("select count(*) from fmessage_conversation", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "getCount = ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(1283);
        return i;
    }

    /* renamed from: ep */
    public final boolean mo17076ep(String str, int i) {
        AppMethodBeat.m2504i(1284);
        if (str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            AppMethodBeat.m2505o(1284);
            return false;
        }
        C7568av QR = mo7910QR(str);
        if (QR == null) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1284);
            return false;
        } else if (i == QR.field_state) {
            C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            AppMethodBeat.m2505o(1284);
            return true;
        } else {
            QR.field_state = i;
            QR.field_lastModifiedTime = System.currentTimeMillis();
            if (super.mo10103c(QR, new String[0])) {
                anF(str);
                AppMethodBeat.m2505o(1284);
                return true;
            }
            AppMethodBeat.m2505o(1284);
            return false;
        }
    }

    public final boolean dtc() {
        AppMethodBeat.m2504i(1285);
        if (this.bSd.mo10108hY("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            AppMethodBeat.m2505o(1285);
            return true;
        }
        C4990ab.m7412e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        AppMethodBeat.m2505o(1285);
        return false;
    }

    public final int dtd() {
        int i = 0;
        AppMethodBeat.m2504i(1286);
        Cursor a = this.bSd.mo10104a(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "getNewCount = ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(1286);
        return i;
    }

    public final boolean apt(String str) {
        AppMethodBeat.m2504i(1287);
        if (str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            AppMethodBeat.m2505o(1287);
            return false;
        }
        C7568av QR = mo7910QR(str);
        if (QR == null || !str.equals(QR.field_talker)) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1287);
            return false;
        }
        QR.field_isNew = 0;
        boolean c = super.mo10103c(QR, new String[0]);
        AppMethodBeat.m2505o(1287);
        return c;
    }

    /* renamed from: QR */
    public final C7568av mo7910QR(String str) {
        AppMethodBeat.m2504i(1288);
        if (str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            AppMethodBeat.m2505o(1288);
            return null;
        }
        C4925c c7568av = new C7568av();
        c7568av.field_talker = str;
        if (super.mo10102b(c7568av, new String[0])) {
            AppMethodBeat.m2505o(1288);
            return c7568av;
        }
        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(1288);
        return null;
    }

    public final C7568av apu(String str) {
        C7568av c7568av = null;
        AppMethodBeat.m2504i(1289);
        if (str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
            AppMethodBeat.m2505o(1289);
        } else {
            Cursor a = this.bSd.mo10104a("select * from fmessage_conversation  where encryptTalker=" + C7480h.escape(str), null, 2);
            if (a.moveToFirst()) {
                c7568av = new C7568av();
                c7568av.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(1289);
        }
        return c7568av;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(1290);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            AppMethodBeat.m2505o(1290);
            return;
        }
        long j;
        try {
            j = C5046bo.getLong(str, 0);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
            AppMethodBeat.m2505o(1290);
        } else if (C1720g.m3534RN().mo5161QY()) {
            C7569ax c7569ax = new C7569ax();
            if (((C7619ay) ((C6982j) C1720g.m3528K(C6982j.class)).bOq()).mo16761b(j, (C4925c) c7569ax)) {
                C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = ".concat(String.valueOf(j)));
                C7568av QR = ((C6982j) C1720g.m3528K(C6982j.class)).bOp().mo7910QR(c7569ax.field_talker);
                C5135a apC;
                C5138d apF;
                if (QR == null) {
                    C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + c7569ax.field_talker);
                    if (C5046bo.isNullOrNil(c7569ax.field_talker)) {
                        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        AppMethodBeat.m2505o(1290);
                        return;
                    }
                    QR = new C7568av();
                    if (c7569ax.field_type == 0) {
                        apC = C5135a.apC(c7569ax.field_msgContent);
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
                        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    } else if (c7569ax.dtf()) {
                        apF = C5138d.apF(c7569ax.field_msgContent);
                        QR.field_displayName = apF.getDisplayName();
                        QR.field_addScene = apF.scene;
                        QR.field_isNew = 1;
                        QR.field_contentFromUsername = apF.svN;
                        QR.field_contentNickname = apF.nickname;
                        QR.field_contentVerifyContent = apF.content;
                        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    }
                    QR.field_lastModifiedTime = System.currentTimeMillis();
                    QR.field_state = 0;
                    QR.field_talker = c7569ax.field_talker;
                    QR.field_encryptTalker = c7569ax.field_encryptTalker;
                    QR.field_fmsgSysRowId = j;
                    QR.field_fmsgIsSend = c7569ax.field_isSend;
                    QR.field_fmsgType = c7569ax.field_type;
                    QR.field_fmsgContent = c7569ax.field_msgContent;
                    QR.field_recvFmsgType = c7569ax.dtf() ? c7569ax.field_type : 0;
                    C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + QR.field_fmsgContent);
                    ((C7618aw) ((C6982j) C1720g.m3528K(C6982j.class)).bOp()).mo10101b((C4925c) QR);
                } else {
                    C4990ab.m7410d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + c7569ax.field_talker);
                    if (c7569ax.dtf()) {
                        QR.field_isNew = 1;
                    }
                    QR.field_lastModifiedTime = System.currentTimeMillis();
                    QR.field_encryptTalker = c7569ax.field_encryptTalker;
                    QR.field_fmsgSysRowId = j;
                    QR.field_fmsgIsSend = c7569ax.field_isSend;
                    QR.field_fmsgType = c7569ax.field_type;
                    QR.field_fmsgContent = c7569ax.field_msgContent;
                    if (c7569ax.dtf()) {
                        QR.field_recvFmsgType = c7569ax.field_type;
                        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + QR.field_recvFmsgType);
                    }
                    if (c7569ax.field_type == 0) {
                        apC = C5135a.apC(c7569ax.field_msgContent);
                        QR.field_contentFromUsername = apC.svN;
                        QR.field_contentNickname = apC.nickname;
                        QR.field_contentPhoneNumMD5 = apC.xZi;
                        QR.field_contentFullPhoneNumMD5 = apC.xZj;
                        C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + QR.field_contentFromUsername + "new friend Nickname: " + QR.field_contentNickname);
                    } else if (c7569ax.dtf()) {
                        int i;
                        if (c7569ax.field_isSend >= 2) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            apF = C5138d.apF(c7569ax.field_msgContent);
                            QR.field_contentVerifyContent = apF.content;
                            QR.field_contentFromUsername = apF.svN;
                            QR.field_contentNickname = apF.nickname;
                            C4990ab.m7416i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + QR.field_contentVerifyContent + " receive, new friend Username: " + QR.field_contentFromUsername + " new friend Nickname: " + QR.field_contentNickname);
                            String str2 = QR.field_contentFromUsername;
                            String str3 = QR.field_contentNickname;
                            C6512kz c6512kz = new C6512kz();
                            c6512kz.cGR.userName = str2;
                            c6512kz.cGR.bCu = str3;
                            c6512kz.cGR.type = 1;
                            C4879a.xxA.mo10055m(c6512kz);
                        }
                    }
                    ((C7618aw) ((C6982j) C1720g.m3528K(C6982j.class)).bOp()).mo10103c(QR, new String[0]);
                    if (dtd() == 0) {
                        C1720g.m3536RP().mo5239Ry().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                dte();
                AppMethodBeat.m2505o(1290);
                return;
            }
            C4990ab.m7420w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(1290);
        } else {
            C4990ab.m7412e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
            AppMethodBeat.m2505o(1290);
        }
    }

    public final void dte() {
        AppMethodBeat.m2504i(1291);
        C5004al.m7439af(this.xYK);
        C5004al.m7442n(this.xYK, 500);
        AppMethodBeat.m2505o(1291);
    }

    /* renamed from: p */
    public final boolean mo7911p(long j, String str) {
        String str2;
        AppMethodBeat.m2504i(1292);
        C4990ab.m7417i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j), str);
        if (!C5046bo.isNullOrNil(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + C5046bo.m7586vA(str) + "'";
        } else if (j > 0) {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        } else {
            AppMethodBeat.m2505o(1292);
            return false;
        }
        if (this.bSd.mo10108hY("fmessage_conversation", str2)) {
            C4990ab.m7417i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j), str);
            anF(str);
            AppMethodBeat.m2505o(1292);
            return true;
        }
        AppMethodBeat.m2505o(1292);
        return false;
    }
}
