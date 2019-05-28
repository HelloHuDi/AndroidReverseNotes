package com.tencent.p177mm.p184aj.p185a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.aj.a.b */
public final class C37446b extends C7563j<C32232a> implements C4937b {
    public static final String[] fnj = new String[]{C7563j.m13217a(C32232a.ccO, "BizChatConversation")};
    public C4927e bSd;
    final C4934l<C37447a, C32233b> fuL = new C257521();

    /* renamed from: com.tencent.mm.aj.a.b$1 */
    class C257521 extends C4934l<C37447a, C32233b> {
        C257521() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11490);
            ((C37447a) obj).mo48789a((C32233b) obj2);
            AppMethodBeat.m2505o(11490);
        }
    }

    /* renamed from: com.tencent.mm.aj.a.b$a */
    public interface C37447a {

        /* renamed from: com.tencent.mm.aj.a.b$a$a */
        public enum C8922a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11493);
            }
        }

        /* renamed from: com.tencent.mm.aj.a.b$a$b */
        public static class C32233b {
            public String cwz;
            public C8922a fxp;
            public long fxq;
            public C32232a fxr;
        }

        /* renamed from: a */
        void mo48789a(C32233b c32233b);
    }

    static {
        AppMethodBeat.m2504i(11513);
        AppMethodBeat.m2505o(11513);
    }

    public C37446b(C4927e c4927e) {
        super(c4927e, C32232a.ccO, "BizChatConversation", null);
        AppMethodBeat.m2504i(11494);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        c4927e.mo10108hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        c4927e.mo10108hY("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor a = c4927e.mo10104a("PRAGMA table_info( BizChatConversation)", null, 2);
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
            c4927e.mo10108hY("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this);
        AppMethodBeat.m2505o(11494);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(11495);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this);
        AppMethodBeat.m2505o(11495);
    }

    /* renamed from: a */
    public final void mo60334a(C37447a c37447a, Looper looper) {
        AppMethodBeat.m2504i(11496);
        this.fuL.mo10125a(c37447a, looper);
        AppMethodBeat.m2505o(11496);
    }

    /* renamed from: a */
    public final void mo60333a(C37447a c37447a) {
        AppMethodBeat.m2504i(11497);
        if (this.fuL != null) {
            this.fuL.remove(c37447a);
        }
        AppMethodBeat.m2505o(11497);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(11498);
        C4990ab.m7416i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj == null || !(obj instanceof String)) {
            AppMethodBeat.m2505o(11498);
            return;
        }
        String str = (String) obj;
        if (C17903f.m28103kq(str) && !C1855t.m3912mY(str)) {
            C25754e.m40889G(str, true);
        }
        AppMethodBeat.m2505o(11498);
    }

    /* renamed from: fv */
    public final C32232a mo60340fv(long j) {
        AppMethodBeat.m2504i(11499);
        C4925c c32232a = new C32232a();
        c32232a.field_bizChatId = j;
        super.mo10102b(c32232a, new String[0]);
        AppMethodBeat.m2505o(11499);
        return c32232a;
    }

    /* renamed from: fw */
    public final boolean mo60341fw(long j) {
        AppMethodBeat.m2504i(11500);
        C4925c fv = mo60340fv(j);
        boolean a = super.mo16760a(fv, "bizChatId");
        if (a) {
            C32233b c32233b = new C32233b();
            c32233b.fxq = fv.field_bizChatId;
            c32233b.cwz = fv.field_brandUserName;
            c32233b.fxp = C8922a.DELETE;
            c32233b.fxr = fv;
            this.fuL.mo10126cF(c32233b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11500);
        return a;
    }

    /* renamed from: a */
    public final boolean mo60335a(C32232a c32232a) {
        AppMethodBeat.m2504i(11501);
        C4990ab.m7410d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (c32232a == null) {
            C4990ab.m7420w("MicroMsg.BizConversationStorage", "insert wrong argument");
            AppMethodBeat.m2505o(11501);
            return false;
        }
        boolean b = super.mo10101b((C4925c) c32232a);
        C4990ab.m7417i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(b));
        if (b) {
            C32233b c32233b = new C32233b();
            c32233b.fxq = c32232a.field_bizChatId;
            c32233b.cwz = c32232a.field_brandUserName;
            c32233b.fxp = C8922a.INSTERT;
            c32233b.fxr = c32232a;
            this.fuL.mo10126cF(c32233b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11501);
        return b;
    }

    /* renamed from: b */
    public final boolean mo60337b(C32232a c32232a) {
        AppMethodBeat.m2504i(11502);
        if (c32232a == null) {
            C4990ab.m7420w("MicroMsg.BizConversationStorage", "update wrong argument");
            AppMethodBeat.m2505o(11502);
            return false;
        }
        boolean a = super.mo10099a(c32232a);
        C4990ab.m7417i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(a));
        if (a) {
            C25754e.m40901g(C41747z.aeT().mo60349aK(c32232a.field_bizChatId));
            C32233b c32233b = new C32233b();
            c32233b.fxq = c32232a.field_bizChatId;
            c32233b.cwz = c32232a.field_brandUserName;
            c32233b.fxp = C8922a.UPDATE;
            c32233b.fxr = c32232a;
            this.fuL.mo10126cF(c32233b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11502);
        return a;
    }

    /* renamed from: rn */
    public final Cursor mo60345rn(String str) {
        AppMethodBeat.m2504i(11503);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , lastMsgTime desc");
        C4990ab.m7411d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", stringBuilder.toString());
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(11503);
        return rawQuery;
    }

    /* renamed from: aC */
    public final List<C45142c> mo60336aC(String str, String str2) {
        AppMethodBeat.m2504i(11504);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(11504);
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
            C4990ab.m7411d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", stringBuilder.toString());
            Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        C45142c c45142c = new C45142c();
                        c45142c.mo8995d(rawQuery);
                        arrayList.add(c45142c);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.m2505o(11504);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m63111a(C32232a c32232a, int i, int i2) {
        AppMethodBeat.m2504i(11505);
        if (c32232a.field_msgCount == 0) {
            c32232a.field_msgCount = ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74797aR(c32232a.field_brandUserName, c32232a.field_bizChatId);
            C4990ab.m7416i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            c32232a.field_msgCount -= i;
            if (c32232a.field_msgCount < 0) {
                C4990ab.m7412e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                c32232a.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            c32232a.field_msgCount += i2;
        }
        C4990ab.m7417i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(c32232a.field_msgCount), Long.valueOf(c32232a.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(11505);
    }

    /* renamed from: fx */
    public final boolean mo60342fx(long j) {
        AppMethodBeat.m2504i(11506);
        C32232a fv = mo60340fv(j);
        if (fv.field_unReadCount == 0 && fv.field_bizChatId == j) {
            AppMethodBeat.m2505o(11506);
        } else {
            fv.field_unReadCount = 0;
            fv.field_atCount = 0;
            mo60337b(fv);
            AppMethodBeat.m2505o(11506);
        }
        return true;
    }

    /* renamed from: a */
    public static long m63109a(C32232a c32232a, int i, long j) {
        AppMethodBeat.m2504i(11507);
        if (c32232a == null) {
            AppMethodBeat.m2505o(11507);
            return 0;
        }
        if (j == 0) {
            j = C5046bo.anU();
        }
        long a;
        switch (i) {
            case 2:
                a = C37446b.m63110a(c32232a, j) | 4611686018427387904L;
                AppMethodBeat.m2505o(11507);
                return a;
            case 3:
                a = C37446b.m63110a(c32232a, j) & -4611686018427387905L;
                AppMethodBeat.m2505o(11507);
                return a;
            case 4:
                a = C37446b.m63110a(c32232a, j) & 4611686018427387904L;
                AppMethodBeat.m2505o(11507);
                return a;
            default:
                a = C37446b.m63110a(c32232a, j);
                AppMethodBeat.m2505o(11507);
                return a;
        }
    }

    /* renamed from: a */
    private static long m63110a(C32232a c32232a, long j) {
        return (c32232a.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    /* renamed from: fy */
    public final boolean mo60343fy(long j) {
        AppMethodBeat.m2504i(11508);
        boolean c = C37446b.m63112c(mo60340fv(j));
        AppMethodBeat.m2505o(11508);
        return c;
    }

    /* renamed from: c */
    public static boolean m63112c(C32232a c32232a) {
        AppMethodBeat.m2504i(11509);
        if (c32232a == null) {
            C4990ab.m7412e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.m2505o(11509);
            return false;
        } else if (C37446b.m63109a(c32232a, 4, 0) != 0) {
            AppMethodBeat.m2505o(11509);
            return true;
        } else {
            AppMethodBeat.m2505o(11509);
            return false;
        }
    }

    /* renamed from: fz */
    public final boolean mo60344fz(long j) {
        AppMethodBeat.m2504i(11510);
        mo60340fv(j);
        C32232a fv = mo60340fv(j);
        boolean hY = this.bSd.mo10108hY("BizChatConversation", "update BizChatConversation set flag = " + C37446b.m63109a(fv, 2, 0) + " where bizChatId = " + fv.field_bizChatId);
        if (hY) {
            fv = mo60340fv(fv.field_bizChatId);
            C32233b c32233b = new C32233b();
            c32233b.fxq = fv.field_bizChatId;
            c32233b.cwz = fv.field_brandUserName;
            c32233b.fxp = C8922a.UPDATE;
            c32233b.fxr = fv;
            this.fuL.mo10126cF(c32233b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11510);
        return hY;
    }

    /* renamed from: fA */
    public final boolean mo60338fA(long j) {
        AppMethodBeat.m2504i(11511);
        C32232a fv = mo60340fv(j);
        boolean hY = this.bSd.mo10108hY("BizChatConversation", "update BizChatConversation set flag = " + C37446b.m63109a(fv, 3, fv.field_lastMsgTime) + " where bizChatId = " + fv.field_bizChatId);
        if (hY) {
            fv = mo60340fv(fv.field_bizChatId);
            C32233b c32233b = new C32233b();
            c32233b.fxq = fv.field_bizChatId;
            c32233b.cwz = fv.field_brandUserName;
            c32233b.fxp = C8922a.UPDATE;
            c32233b.fxr = fv;
            this.fuL.mo10126cF(c32233b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11511);
        return hY;
    }
}
