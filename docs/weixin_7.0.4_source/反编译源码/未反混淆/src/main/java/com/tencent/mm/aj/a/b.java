package com.tencent.mm.aj.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class b extends j<a> implements com.tencent.mm.sdk.e.n.b {
    public static final String[] fnj = new String[]{j.a(a.ccO, "BizChatConversation")};
    public e bSd;
    final l<a, b> fuL = new l<a, b>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11490);
            ((a) obj).a((b) obj2);
            AppMethodBeat.o(11490);
        }
    };

    public interface a {

        public enum a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11493);
            }
        }

        public static class b {
            public String cwz;
            public a fxp;
            public long fxq;
            public a fxr;
        }

        void a(b bVar);
    }

    static {
        AppMethodBeat.i(11513);
        AppMethodBeat.o(11513);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "BizChatConversation", null);
        AppMethodBeat.i(11494);
        this.bSd = eVar;
        eVar.hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        eVar.hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        eVar.hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor a = eVar.a("PRAGMA table_info( BizChatConversation)", null, 2);
        while (a.moveToNext()) {
            int columnIndex = a.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        a.close();
        if (obj == null) {
            eVar.hY("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().a(this);
        AppMethodBeat.o(11494);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(11495);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(this);
        AppMethodBeat.o(11495);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(11496);
        this.fuL.a(aVar, looper);
        AppMethodBeat.o(11496);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11497);
        if (this.fuL != null) {
            this.fuL.remove(aVar);
        }
        AppMethodBeat.o(11497);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(11498);
        ab.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj == null || !(obj instanceof String)) {
            AppMethodBeat.o(11498);
            return;
        }
        String str = (String) obj;
        if (f.kq(str) && !t.mY(str)) {
            e.G(str, true);
        }
        AppMethodBeat.o(11498);
    }

    public final a fv(long j) {
        AppMethodBeat.i(11499);
        c aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        AppMethodBeat.o(11499);
        return aVar;
    }

    public final boolean fw(long j) {
        AppMethodBeat.i(11500);
        c fv = fv(j);
        boolean a = super.a(fv, "bizChatId");
        if (a) {
            b bVar = new b();
            bVar.fxq = fv.field_bizChatId;
            bVar.cwz = fv.field_brandUserName;
            bVar.fxp = a.DELETE;
            bVar.fxr = fv;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11500);
        return a;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(11501);
        ab.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            ab.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            AppMethodBeat.o(11501);
            return false;
        }
        boolean b = super.b((c) aVar);
        ab.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(b));
        if (b) {
            b bVar = new b();
            bVar.fxq = aVar.field_bizChatId;
            bVar.cwz = aVar.field_brandUserName;
            bVar.fxp = a.INSTERT;
            bVar.fxr = aVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11501);
        return b;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(11502);
        if (aVar == null) {
            ab.w("MicroMsg.BizConversationStorage", "update wrong argument");
            AppMethodBeat.o(11502);
            return false;
        }
        boolean a = super.a(aVar);
        ab.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(a));
        if (a) {
            e.g(z.aeT().aK(aVar.field_bizChatId));
            b bVar = new b();
            bVar.fxq = aVar.field_bizChatId;
            bVar.cwz = aVar.field_brandUserName;
            bVar.fxp = a.UPDATE;
            bVar.fxr = aVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11502);
        return a;
    }

    public final Cursor rn(String str) {
        AppMethodBeat.i(11503);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , lastMsgTime desc");
        ab.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(11503);
        return rawQuery;
    }

    public final List<c> aC(String str, String str2) {
        AppMethodBeat.i(11504);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(11504);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizChatInfo.*");
            stringBuilder.append(" from BizChatConversation , BizChatInfo");
            stringBuilder.append(" where BizChatConversation.brandUserName = '").append(str).append("'");
            stringBuilder.append(" and BizChatInfo.brandUserName = '").append(str).append("'");
            stringBuilder.append(" and BizChatConversation.bizChatId");
            stringBuilder.append(" = BizChatInfo.bizChatLocalId");
            stringBuilder.append(" and BizChatInfo.chatName like '%").append(str2).append("%'");
            stringBuilder.append(" order by BizChatConversation.flag desc");
            stringBuilder.append(" , BizChatConversation.lastMsgTime desc");
            ab.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", stringBuilder.toString());
            Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        c cVar = new c();
                        cVar.d(rawQuery);
                        arrayList.add(cVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.o(11504);
        }
        return arrayList;
    }

    public static void a(a aVar, int i, int i2) {
        AppMethodBeat.i(11505);
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((o) g.K(o.class)).XP().aR(aVar.field_brandUserName, aVar.field_bizChatId);
            ab.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                ab.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        ab.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(11505);
    }

    public final boolean fx(long j) {
        AppMethodBeat.i(11506);
        a fv = fv(j);
        if (fv.field_unReadCount == 0 && fv.field_bizChatId == j) {
            AppMethodBeat.o(11506);
        } else {
            fv.field_unReadCount = 0;
            fv.field_atCount = 0;
            b(fv);
            AppMethodBeat.o(11506);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        AppMethodBeat.i(11507);
        if (aVar == null) {
            AppMethodBeat.o(11507);
            return 0;
        }
        if (j == 0) {
            j = bo.anU();
        }
        long a;
        switch (i) {
            case 2:
                a = a(aVar, j) | 4611686018427387904L;
                AppMethodBeat.o(11507);
                return a;
            case 3:
                a = a(aVar, j) & -4611686018427387905L;
                AppMethodBeat.o(11507);
                return a;
            case 4:
                a = a(aVar, j) & 4611686018427387904L;
                AppMethodBeat.o(11507);
                return a;
            default:
                a = a(aVar, j);
                AppMethodBeat.o(11507);
                return a;
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean fy(long j) {
        AppMethodBeat.i(11508);
        boolean c = c(fv(j));
        AppMethodBeat.o(11508);
        return c;
    }

    public static boolean c(a aVar) {
        AppMethodBeat.i(11509);
        if (aVar == null) {
            ab.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.o(11509);
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            AppMethodBeat.o(11509);
            return true;
        } else {
            AppMethodBeat.o(11509);
            return false;
        }
    }

    public final boolean fz(long j) {
        AppMethodBeat.i(11510);
        fv(j);
        a fv = fv(j);
        boolean hY = this.bSd.hY("BizChatConversation", "update BizChatConversation set flag = " + a(fv, 2, 0) + " where bizChatId = " + fv.field_bizChatId);
        if (hY) {
            fv = fv(fv.field_bizChatId);
            b bVar = new b();
            bVar.fxq = fv.field_bizChatId;
            bVar.cwz = fv.field_brandUserName;
            bVar.fxp = a.UPDATE;
            bVar.fxr = fv;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11510);
        return hY;
    }

    public final boolean fA(long j) {
        AppMethodBeat.i(11511);
        a fv = fv(j);
        boolean hY = this.bSd.hY("BizChatConversation", "update BizChatConversation set flag = " + a(fv, 3, fv.field_lastMsgTime) + " where bizChatId = " + fv.field_bizChatId);
        if (hY) {
            fv = fv(fv.field_bizChatId);
            b bVar = new b();
            bVar.fxq = fv.field_bizChatId;
            bVar.cwz = fv.field_brandUserName;
            bVar.fxp = a.UPDATE;
            bVar.fxr = fv;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11511);
        return hY;
    }
}
