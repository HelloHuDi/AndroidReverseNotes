package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.p712j.p713a.p714a.C6595d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b.C3453a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: com.tencent.mm.storage.x */
public final class C7579x extends C7298n implements C6973b {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7578w.ccO, "ChatroomMsgSeq")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )"};
    private C7480h fni;

    static {
        AppMethodBeat.m2504i(1101);
        AppMethodBeat.m2505o(1101);
    }

    public C7579x(C7480h c7480h) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL);
        this.fni = c7480h;
        c7480h.mo10108hY("ChatroomMsgSeq", xIq[0]);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL);
    }

    /* renamed from: a */
    public final long mo15220a(C7578w c7578w) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA);
        long a = mo15221a(c7578w, false);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA);
        return a;
    }

    /* renamed from: a */
    public final long mo15221a(C7578w c7578w, boolean z) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        if (c7578w == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
            return -1;
        }
        long a = this.fni.mo16656a("ChatroomMsgSeq", "username", c7578w.mo10098Hl(), false);
        if (a >= 0) {
            C3453a c3453a = new C3453a();
            c3453a.f1271id = 4;
            c3453a.username = c7578w.field_username;
            c3453a.oqE = z;
            mo10120b(4, this, c3453a);
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        return a;
    }

    /* renamed from: b */
    public final long mo15223b(C7578w c7578w) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
        if (c7578w == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
            return -1;
        }
        long update = (long) this.fni.update("ChatroomMsgSeq", c7578w.mo10098Hl(), "username = ?", new String[]{c7578w.field_username});
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
        return update;
    }

    /* renamed from: QF */
    public final long mo15210QF(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG);
        long delete = (long) this.fni.delete("ChatroomMsgSeq", "username = ?", new String[]{str});
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG);
        return delete;
    }

    public final boolean bOu() {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
        long delete = (long) this.fni.delete("ChatroomMsgSeq", "", null);
        C4990ab.m7420w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + delete + " table:ChatroomMsgSeq");
        if (delete >= 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
            return true;
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
        return false;
    }

    /* renamed from: QG */
    public final long mo15211QG(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -1;
        }
        Cursor a = this.fni.mo10104a("select lastPushSeq from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -3;
        }
    }

    /* renamed from: QI */
    public final long mo15213QI(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -1;
        }
        Cursor a = this.fni.mo10104a("select lastPushCreateTime from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -3;
        }
    }

    /* renamed from: QH */
    public final long mo15212QH(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -1;
        }
        Cursor a = this.fni.mo10104a("select lastLocalSeq from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -3;
        }
    }

    /* renamed from: QJ */
    public final long mo15214QJ(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -1;
        }
        Cursor a = this.fni.mo10104a("select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -3;
        }
    }

    /* renamed from: I */
    public final boolean mo15205I(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
            return false;
        }
        boolean hY = this.fni.mo10108hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushSeq =  " + j + " where username = \"" + C5046bo.m7586vA(str) + "\"");
        if (hY) {
            C3453a c3453a = new C3453a();
            c3453a.f1271id = 4;
            c3453a.username = str;
            mo10120b(2, this, c3453a);
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
        return hY;
    }

    /* renamed from: J */
    public final boolean mo15206J(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
            return false;
        }
        boolean hY = this.fni.mo10108hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalCreateTime =  " + j + " where username = \"" + C5046bo.m7586vA(str) + "\"");
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
        return hY;
    }

    /* renamed from: K */
    public final boolean mo15207K(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
            return false;
        }
        boolean hY = this.fni.mo10108hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushCreateTime =  " + j + " where username = \"" + C5046bo.m7586vA(str) + "\"");
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
        return hY;
    }

    /* renamed from: L */
    public final boolean mo15208L(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
            return false;
        }
        boolean hY = this.fni.mo10108hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalSeq =  " + j + " where username = \"" + C5046bo.m7586vA(str) + "\"");
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
        return hY;
    }

    /* renamed from: QK */
    public final C6595d mo15215QK(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
        C6595d c6595d;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
            c6595d = new C6595d();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return c6595d;
        }
        Cursor a = this.fni.mo10104a("select seqBlockInfo from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(str)));
            c6595d = new C6595d();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return c6595d;
        } else if (a.moveToFirst()) {
            byte[] blob = a.getBlob(0);
            if (C5046bo.m7540cb(blob)) {
                a.close();
                c6595d = new C6595d();
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
                return c6595d;
            }
            c6595d = new C6595d();
            try {
                c6595d.parseFrom(blob);
            } catch (Exception e) {
            }
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return c6595d;
        } else {
            a.close();
            c6595d = new C6595d();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return c6595d;
        }
    }

    /* renamed from: a */
    public final boolean mo15222a(String str, C6595d c6595d) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
            return false;
        }
        byte[] bArr = new byte[0];
        try {
            bArr = c6595d.toByteArray();
        } catch (Exception e) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqBlockInfo", bArr);
        if (this.fni.update("ChatroomMsgSeq", contentValues, "username = ?", new String[]{C5046bo.m7586vA(str)}) > 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
            return true;
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
        return false;
    }

    /* renamed from: QL */
    public final boolean mo15216QL(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
        Cursor a = this.fni.mo10104a("select count(*) from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            if (j > 0) {
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
                return true;
            }
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        } else {
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        }
    }

    /* renamed from: QM */
    public final C6594c mo15217QM(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
        C6595d QK = mo15215QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
            return null;
        }
        C6594c c6594c = (C6594c) QK.eoG.getLast();
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
        return c6594c;
    }

    /* renamed from: f */
    public final C6594c mo15225f(String str, long j, boolean z) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
        C6595d QK = mo15215QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
            return null;
        }
        Iterator it = QK.eoG.iterator();
        while (it.hasNext()) {
            C6594c c6594c = (C6594c) it.next();
            if (z) {
                if (c6594c.eoE > j) {
                    AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
                    return c6594c;
                }
            } else if (c6594c.eoF > j) {
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
                return c6594c;
            }
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
        return null;
    }

    /* renamed from: M */
    public final C6594c mo15209M(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
        C6595d QK = mo15215QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
            return null;
        }
        ListIterator listIterator = QK.eoG.listIterator(QK.eoG.size());
        while (listIterator.hasPrevious()) {
            C6594c c6594c = (C6594c) listIterator.previous();
            if (c6594c.eoE < j) {
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
                return c6594c;
            }
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
        return null;
    }

    /* renamed from: QN */
    public final C7578w mo15218QN(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        C4990ab.m7417i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", str);
        C7578w c7578w = new C7578w();
        Cursor a = this.fni.mo10104a("select * from ChatroomMsgSeq where username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        } else {
            if (a.moveToFirst()) {
                c7578w.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        }
        return c7578w;
    }

    /* renamed from: QO */
    public final StringBuilder mo15219QO(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
        StringBuilder stringBuilder = new StringBuilder();
        C6595d c6595d = mo15218QN(str).field_seqBlockInfo;
        if (c6595d == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
            return stringBuilder;
        }
        for (C6594c c6594c : c6595d.eoG) {
            stringBuilder.append("[").append(c6594c.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c.eoD).append("][").append(c6594c.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(c6594c.eoF).append("] | ");
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
        return stringBuilder;
    }

    /* renamed from: o */
    public final int mo15226o(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
        C6595d c6595d = mo15218QN(str).field_seqBlockInfo;
        if (c6595d == null) {
            C4990ab.m7416i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
            return 0;
        }
        Iterator it = c6595d.eoG.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C6594c c6594c = (C6594c) it.next();
                if (j <= c6594c.eoE && c6594c.eoF <= j2) {
                    i2++;
                }
                i = i2;
            } else {
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
                return i2;
            }
        }
    }

    public final boolean apK() {
        return true;
    }
}
