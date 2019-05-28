package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class ap extends n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) "};
    public final h fni;

    public ap(h hVar) {
        this.fni = hVar;
    }

    public final Cursor E(int i, boolean z) {
        String str;
        String[] strArr;
        AppMethodBeat.i(108503);
        if (z) {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
            strArr = new String[]{String.valueOf(i)};
        } else {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
            strArr = new String[]{String.valueOf(i), "1", "2"};
        }
        Cursor a = this.fni.a(str, strArr, 0);
        AppMethodBeat.o(108503);
        return a;
    }

    public final Cursor c(int i, String str, boolean z) {
        AppMethodBeat.i(108504);
        ab.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i + ", searchby:" + str);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and ( ");
        } else {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and (wexinstatus =\"1\" or wexinstatus =\"2\") and ( ");
        }
        stringBuilder.append("qqlist.qq like '%" + str + "%' or ");
        stringBuilder.append("qqlist.username like '%" + str + "%' or ");
        stringBuilder.append("qqlist.nickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.pyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.quanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqnickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqpyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqquanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqremark like '%" + str + "%' )");
        stringBuilder.append(" order by reserved3");
        Cursor a = this.fni.a(stringBuilder.toString(), null, 0);
        AppMethodBeat.o(108504);
        return a;
    }

    public final ao ge(long j) {
        ao aoVar = null;
        AppMethodBeat.i(108505);
        Cursor a = this.fni.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + j + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(108505);
        } else {
            if (a.moveToFirst()) {
                aoVar = new ao();
                aoVar.d(a);
            }
            a.close();
            AppMethodBeat.o(108505);
        }
        return aoVar;
    }

    public final ao wj(String str) {
        ao aoVar = null;
        AppMethodBeat.i(108506);
        Cursor a = this.fni.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + str + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(108506);
        } else {
            if (a.moveToFirst()) {
                aoVar = new ao();
                aoVar.d(a);
            }
            a.close();
            AppMethodBeat.o(108506);
        }
        return aoVar;
    }

    public final int a(long j, ao aoVar) {
        int i = 0;
        AppMethodBeat.i(108507);
        ContentValues aqn = aoVar.aqn();
        if (aqn.size() > 0) {
            i = this.fni.update("qqlist", aqn, "qq=?", new String[]{String.valueOf(j)});
        }
        if (i > 0) {
            b(3, this, String.valueOf(j));
        }
        AppMethodBeat.o(108507);
        return i;
    }

    public final boolean a(ao aoVar) {
        AppMethodBeat.i(108508);
        if (aoVar == null) {
            AppMethodBeat.o(108508);
            return false;
        }
        ab.d("MicroMsg.QQListStorage", "insert: name:" + aoVar.aqo());
        aoVar.bJt = -1;
        if (((int) this.fni.insert("qqlist", "qq", aoVar.aqn())) != -1) {
            b(2, this, aoVar.gwC);
            AppMethodBeat.o(108508);
            return true;
        }
        AppMethodBeat.o(108508);
        return false;
    }

    public final boolean apK() {
        AppMethodBeat.i(108509);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.QQListStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(108509);
            return false;
        }
        AppMethodBeat.o(108509);
        return true;
    }

    public final boolean mZ(int i) {
        boolean z = false;
        AppMethodBeat.i(108510);
        Cursor cursor = null;
        try {
            cursor = this.fni.a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(108510);
        }
        AppMethodBeat.o(108510);
        return z;
    }
}
