package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.ListIterator;

public final class x extends n implements b {
    public static final String[] fnj = new String[]{j.a(w.ccO, "ChatroomMsgSeq")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  ChatroomMsgSeqTalkerIndex ON ChatroomMsgSeq ( username )"};
    private h fni;

    static {
        AppMethodBeat.i(1101);
        AppMethodBeat.o(1101);
    }

    public x(h hVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL);
        this.fni = hVar;
        hVar.hY("ChatroomMsgSeq", xIq[0]);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL);
    }

    public final long a(w wVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA);
        long a = a(wVar, false);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA);
        return a;
    }

    public final long a(w wVar, boolean z) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        if (wVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
            return -1;
        }
        long a = this.fni.a("ChatroomMsgSeq", "username", wVar.Hl(), false);
        if (a >= 0) {
            a aVar = new a();
            aVar.id = 4;
            aVar.username = wVar.field_username;
            aVar.oqE = z;
            b(4, this, aVar);
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        return a;
    }

    public final long b(w wVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
        if (wVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
            return -1;
        }
        long update = (long) this.fni.update("ChatroomMsgSeq", wVar.Hl(), "username = ?", new String[]{wVar.field_username});
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE);
        return update;
    }

    public final long QF(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG);
        long delete = (long) this.fni.delete("ChatroomMsgSeq", "username = ?", new String[]{str});
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINDONG);
        return delete;
    }

    public final boolean bOu() {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
        long delete = (long) this.fni.delete("ChatroomMsgSeq", "", null);
        ab.w("MicroMsg.ChatroomMsgSeqStorage", "[deleteTable] result:" + delete + " table:ChatroomMsgSeq");
        if (delete >= 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
            return true;
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUNJIE);
        return false;
    }

    public final long QG(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -1;
        }
        Cursor a = this.fni.a("select lastPushSeq from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHEN);
            return -3;
        }
    }

    public final long QI(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -1;
        }
        Cursor a = this.fni.a("select lastPushCreateTime from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO);
            return -3;
        }
    }

    public final long QH(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -1;
        }
        Cursor a = this.fni.a("select lastLocalSeq from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG);
            return -3;
        }
    }

    public final long QJ(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -1;
        }
        Cursor a = this.fni.a("select lastLocalCreateTime from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastLocalSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -2;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_BUDING);
            return -3;
        }
    }

    public final boolean I(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
            return false;
        }
        boolean hY = this.fni.hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushSeq =  " + j + " where username = \"" + bo.vA(str) + "\"");
        if (hY) {
            a aVar = new a();
            aVar.id = 4;
            aVar.username = str;
            b(2, this, aVar);
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE);
        return hY;
    }

    public final boolean J(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
            return false;
        }
        boolean hY = this.fni.hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalCreateTime =  " + j + " where username = \"" + bo.vA(str) + "\"");
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU);
        return hY;
    }

    public final boolean K(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
            return false;
        }
        boolean hY = this.fni.hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastPushCreateTime =  " + j + " where username = \"" + bo.vA(str) + "\"");
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI);
        return hY;
    }

    public final boolean L(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
            return false;
        }
        boolean hY = this.fni.hY("ChatroomMsgSeq", "update ChatroomMsgSeq set lastLocalSeq =  " + j + " where username = \"" + bo.vA(str) + "\"");
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA);
        return hY;
    }

    public final d QK(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
        d dVar;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed username is null!");
            dVar = new d();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return dVar;
        }
        Cursor a = this.fni.a("select seqBlockInfo from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.e("MicroMsg.ChatroomMsgSeqStorage", "getSeqBlockInfo failed ".concat(String.valueOf(str)));
            dVar = new d();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return dVar;
        } else if (a.moveToFirst()) {
            byte[] blob = a.getBlob(0);
            if (bo.cb(blob)) {
                a.close();
                dVar = new d();
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
                return dVar;
            }
            dVar = new d();
            try {
                dVar.parseFrom(blob);
            } catch (Exception e) {
            }
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return dVar;
        } else {
            a.close();
            dVar = new d();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG);
            return dVar;
        }
    }

    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.ChatroomMsgSeqStorage", "updateSeqBlockInfo failed");
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
            return false;
        }
        byte[] bArr = new byte[0];
        try {
            bArr = dVar.toByteArray();
        } catch (Exception e) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqBlockInfo", bArr);
        if (this.fni.update("ChatroomMsgSeq", contentValues, "username = ?", new String[]{bo.vA(str)}) > 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
            return true;
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI);
        return false;
    }

    public final boolean QL(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
        Cursor a = this.fni.a("select count(*) from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "getLastPushSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            if (j > 0) {
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
                return true;
            }
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        } else {
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING);
            return false;
        }
    }

    public final c QM(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
        d QK = QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
            return null;
        }
        c cVar = (c) QK.eoG.getLast();
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG);
        return cVar;
    }

    public final c f(String str, long j, boolean z) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
        d QK = QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
            return null;
        }
        Iterator it = QK.eoG.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (z) {
                if (cVar.eoE > j) {
                    AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
                    return cVar;
                }
            } else if (cVar.eoF > j) {
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
                return cVar;
            }
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING);
        return null;
    }

    public final c M(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
        d QK = QK(str);
        if (QK.eoG.size() <= 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
            return null;
        }
        ListIterator listIterator = QK.eoG.listIterator(QK.eoG.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar.eoE < j) {
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
                return cVar;
            }
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI);
        return null;
    }

    public final w QN(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        ab.i("MicroMsg.ChatroomMsgSeqStorage", "[getChatroomMsgSeq] username:%s", str);
        w wVar = new w();
        Cursor a = this.fni.a("select * from ChatroomMsgSeq where username = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        } else {
            if (a.moveToFirst()) {
                wVar.d(a);
            }
            a.close();
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN);
        }
        return wVar;
    }

    public final StringBuilder QO(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
        StringBuilder stringBuilder = new StringBuilder();
        d dVar = QN(str).field_seqBlockInfo;
        if (dVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
            return stringBuilder;
        }
        for (c cVar : dVar.eoG) {
            stringBuilder.append("[").append(cVar.eoC).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar.eoD).append("][").append(cVar.eoE).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(cVar.eoF).append("] | ");
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN);
        return stringBuilder;
    }

    public final int o(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
        d dVar = QN(str).field_seqBlockInfo;
        if (dVar == null) {
            ab.i("MicroMsg.ChatroomMsgSeqStorage", "[getBlockCount] seqBlockInfo is null!");
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
            return 0;
        }
        Iterator it = dVar.eoG.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                c cVar = (c) it.next();
                if (j <= cVar.eoE && cVar.eoF <= j2) {
                    i2++;
                }
                i = i2;
            } else {
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA);
                return i2;
            }
        }
    }

    public final boolean apK() {
        return true;
    }
}
