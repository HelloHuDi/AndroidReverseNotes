package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class o extends j<n> implements a {
    public static final String[] fnj = new String[]{j.a(n.ccO, "GoogleFriend")};
    private e bSd;
    public n gvC = new n() {
        public final boolean apK() {
            AppMethodBeat.i(108387);
            if (o.this.bSd == null || o.this.bSd.dpU()) {
                String str = "MicroMsg.GoogleContact.GoogleFriendUI";
                String str2 = "shouldProcessEvent db is close :%s";
                Object[] objArr = new Object[1];
                objArr[0] = o.this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(o.this.bSd.dpU());
                ab.w(str, str2, objArr);
                AppMethodBeat.o(108387);
                return false;
            }
            AppMethodBeat.o(108387);
            return true;
        }
    };

    static {
        AppMethodBeat.i(108399);
        AppMethodBeat.o(108399);
    }

    public o(e eVar) {
        super(eVar, n.ccO, "GoogleFriend", null);
        AppMethodBeat.i(108388);
        this.bSd = eVar;
        AppMethodBeat.o(108388);
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    private boolean a(n nVar) {
        AppMethodBeat.i(108389);
        if (nVar == null) {
            AppMethodBeat.o(108389);
            return false;
        }
        if (((int) this.bSd.insert("GoogleFriend", "googleitemid", nVar.Hl())) > 0) {
            AppMethodBeat.o(108389);
            return true;
        }
        AppMethodBeat.o(108389);
        return false;
    }

    public final boolean j(ArrayList<n> arrayList) {
        AppMethodBeat.i(108390);
        if (arrayList.size() <= 0) {
            ab.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            AppMethodBeat.o(108390);
            return false;
        }
        long iV;
        h hVar = null;
        if (this.bSd instanceof h) {
            h hVar2 = (h) this.bSd;
            iV = hVar2.iV(Thread.currentThread().getId());
            ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(iV));
            hVar = hVar2;
        } else {
            iV = -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            a((n) arrayList.get(i));
        }
        if (hVar != null) {
            hVar.mB(iV);
            ab.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.gvC.b(2, this.gvC, "");
        AppMethodBeat.o(108390);
        return true;
    }

    public final Cursor bi(String str, String str2) {
        AppMethodBeat.i(108391);
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
        AppMethodBeat.o(108391);
        return rawQuery;
    }

    public final Cursor wg(String str) {
        AppMethodBeat.i(108392);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        Cursor rawQuery = this.bSd.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  ".concat(String.valueOf(stringBuilder)), null);
        AppMethodBeat.o(108392);
        return rawQuery;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(108393);
        if (wh(nVar.field_googleitemid)) {
            int update = this.bSd.update("GoogleFriend", nVar.Hl(), "googleitemid=?", new String[]{nVar.field_googleitemid});
            if (update > 0) {
                doNotify();
            }
            if (update > 0) {
                AppMethodBeat.o(108393);
                return true;
            }
            AppMethodBeat.o(108393);
            return false;
        }
        boolean a = a(nVar);
        AppMethodBeat.o(108393);
        return a;
    }

    public final boolean aj(String str, int i) {
        AppMethodBeat.i(108394);
        boolean hY = this.bSd.hY("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
        AppMethodBeat.o(108394);
        return hY;
    }

    public final boolean ak(String str, int i) {
        AppMethodBeat.i(108395);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(108395);
            return false;
        }
        boolean hY = this.bSd.hY("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0' WHERE username='" + str + "'");
        AppMethodBeat.o(108395);
        return hY;
    }

    private boolean wh(String str) {
        AppMethodBeat.i(108396);
        Cursor a = this.bSd.a("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(108396);
        return moveToFirst;
    }

    public final void clear() {
        AppMethodBeat.i(108397);
        this.bSd.hY("GoogleFriend", " delete from GoogleFriend");
        this.gvC.b(5, this.gvC, "");
        AppMethodBeat.o(108397);
    }
}
