package com.tencent.p177mm.plugin.account.friend.p272a;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.account.friend.a.o */
public final class C38036o extends C7563j<C45498n> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C45498n.ccO, "GoogleFriend")};
    private C4927e bSd;
    public C7298n gvC = new C329641();

    /* renamed from: com.tencent.mm.plugin.account.friend.a.o$1 */
    class C329641 extends C7298n {
        C329641() {
        }

        public final boolean apK() {
            AppMethodBeat.m2504i(108387);
            if (C38036o.this.bSd == null || C38036o.this.bSd.dpU()) {
                String str = "MicroMsg.GoogleContact.GoogleFriendUI";
                String str2 = "shouldProcessEvent db is close :%s";
                Object[] objArr = new Object[1];
                objArr[0] = C38036o.this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(C38036o.this.bSd.dpU());
                C4990ab.m7421w(str, str2, objArr);
                AppMethodBeat.m2505o(108387);
                return false;
            }
            AppMethodBeat.m2505o(108387);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(108399);
        AppMethodBeat.m2505o(108399);
    }

    public C38036o(C4927e c4927e) {
        super(c4927e, C45498n.ccO, "GoogleFriend", null);
        AppMethodBeat.m2504i(108388);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(108388);
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: a */
    private boolean m64355a(C45498n c45498n) {
        AppMethodBeat.m2504i(108389);
        if (c45498n == null) {
            AppMethodBeat.m2505o(108389);
            return false;
        }
        if (((int) this.bSd.insert("GoogleFriend", "googleitemid", c45498n.mo10098Hl())) > 0) {
            AppMethodBeat.m2505o(108389);
            return true;
        }
        AppMethodBeat.m2505o(108389);
        return false;
    }

    /* renamed from: j */
    public final boolean mo60784j(ArrayList<C45498n> arrayList) {
        AppMethodBeat.m2504i(108390);
        if (arrayList.size() <= 0) {
            C4990ab.m7410d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            AppMethodBeat.m2505o(108390);
            return false;
        }
        long iV;
        C7480h c7480h = null;
        if (this.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) this.bSd;
            iV = c7480h2.mo15639iV(Thread.currentThread().getId());
            C4990ab.m7417i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(iV));
            c7480h = c7480h2;
        } else {
            iV = -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            m64355a((C45498n) arrayList.get(i));
        }
        if (c7480h != null) {
            c7480h.mo15640mB(iV);
            C4990ab.m7416i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.gvC.mo10120b(2, this.gvC, "");
        AppMethodBeat.m2505o(108390);
        return true;
    }

    /* renamed from: bi */
    public final Cursor mo60782bi(String str, String str2) {
        AppMethodBeat.m2504i(108391);
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        Cursor rawQuery = this.bSd.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null);
        AppMethodBeat.m2505o(108391);
        return rawQuery;
    }

    /* renamed from: wg */
    public final Cursor mo60785wg(String str) {
        AppMethodBeat.m2504i(108392);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        Cursor rawQuery = this.bSd.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  ".concat(String.valueOf(stringBuilder)), null);
        AppMethodBeat.m2505o(108392);
        return rawQuery;
    }

    /* renamed from: b */
    public final boolean mo60781b(C45498n c45498n) {
        AppMethodBeat.m2504i(108393);
        if (m64356wh(c45498n.field_googleitemid)) {
            int update = this.bSd.update("GoogleFriend", c45498n.mo10098Hl(), "googleitemid=?", new String[]{c45498n.field_googleitemid});
            if (update > 0) {
                doNotify();
            }
            if (update > 0) {
                AppMethodBeat.m2505o(108393);
                return true;
            }
            AppMethodBeat.m2505o(108393);
            return false;
        }
        boolean a = m64355a(c45498n);
        AppMethodBeat.m2505o(108393);
        return a;
    }

    /* renamed from: aj */
    public final boolean mo60779aj(String str, int i) {
        AppMethodBeat.m2504i(108394);
        boolean hY = this.bSd.mo10108hY("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
        AppMethodBeat.m2505o(108394);
        return hY;
    }

    /* renamed from: ak */
    public final boolean mo60780ak(String str, int i) {
        AppMethodBeat.m2504i(108395);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(108395);
            return false;
        }
        boolean hY = this.bSd.mo10108hY("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0' WHERE username='" + str + "'");
        AppMethodBeat.m2505o(108395);
        return hY;
    }

    /* renamed from: wh */
    private boolean m64356wh(String str) {
        AppMethodBeat.m2504i(108396);
        Cursor a = this.bSd.mo10104a("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(108396);
        return moveToFirst;
    }

    public final void clear() {
        AppMethodBeat.m2504i(108397);
        this.bSd.mo10108hY("GoogleFriend", " delete from GoogleFriend");
        this.gvC.mo10120b(5, this.gvC, "");
        AppMethodBeat.m2505o(108397);
    }
}
