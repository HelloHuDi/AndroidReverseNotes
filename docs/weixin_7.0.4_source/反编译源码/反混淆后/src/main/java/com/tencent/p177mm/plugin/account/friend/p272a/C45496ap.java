package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ap */
public final class C45496ap extends C7298n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) "};
    public final C7480h fni;

    public C45496ap(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: E */
    public final Cursor mo73280E(int i, boolean z) {
        String str;
        String[] strArr;
        AppMethodBeat.m2504i(108503);
        if (z) {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
            strArr = new String[]{String.valueOf(i)};
        } else {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
            strArr = new String[]{String.valueOf(i), "1", "2"};
        }
        Cursor a = this.fni.mo10104a(str, strArr, 0);
        AppMethodBeat.m2505o(108503);
        return a;
    }

    /* renamed from: c */
    public final Cursor mo73283c(int i, String str, boolean z) {
        AppMethodBeat.m2504i(108504);
        C4990ab.m7410d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i + ", searchby:" + str);
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
        Cursor a = this.fni.mo10104a(stringBuilder.toString(), null, 0);
        AppMethodBeat.m2505o(108504);
        return a;
    }

    /* renamed from: ge */
    public final C9878ao mo73284ge(long j) {
        C9878ao c9878ao = null;
        AppMethodBeat.m2504i(108505);
        Cursor a = this.fni.mo10104a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + j + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(108505);
        } else {
            if (a.moveToFirst()) {
                c9878ao = new C9878ao();
                c9878ao.mo21233d(a);
            }
            a.close();
            AppMethodBeat.m2505o(108505);
        }
        return c9878ao;
    }

    /* renamed from: wj */
    public final C9878ao mo73286wj(String str) {
        C9878ao c9878ao = null;
        AppMethodBeat.m2504i(108506);
        Cursor a = this.fni.mo10104a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + str + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(108506);
        } else {
            if (a.moveToFirst()) {
                c9878ao = new C9878ao();
                c9878ao.mo21233d(a);
            }
            a.close();
            AppMethodBeat.m2505o(108506);
        }
        return c9878ao;
    }

    /* renamed from: a */
    public final int mo73281a(long j, C9878ao c9878ao) {
        int i = 0;
        AppMethodBeat.m2504i(108507);
        ContentValues aqn = c9878ao.aqn();
        if (aqn.size() > 0) {
            i = this.fni.update("qqlist", aqn, "qq=?", new String[]{String.valueOf(j)});
        }
        if (i > 0) {
            mo10120b(3, this, String.valueOf(j));
        }
        AppMethodBeat.m2505o(108507);
        return i;
    }

    /* renamed from: a */
    public final boolean mo73282a(C9878ao c9878ao) {
        AppMethodBeat.m2504i(108508);
        if (c9878ao == null) {
            AppMethodBeat.m2505o(108508);
            return false;
        }
        C4990ab.m7410d("MicroMsg.QQListStorage", "insert: name:" + c9878ao.aqo());
        c9878ao.bJt = -1;
        if (((int) this.fni.insert("qqlist", "qq", c9878ao.aqn())) != -1) {
            mo10120b(2, this, c9878ao.gwC);
            AppMethodBeat.m2505o(108508);
            return true;
        }
        AppMethodBeat.m2505o(108508);
        return false;
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(108509);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.QQListStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(108509);
            return false;
        }
        AppMethodBeat.m2505o(108509);
        return true;
    }

    /* renamed from: mZ */
    public final boolean mo73285mZ(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(108510);
        Cursor cursor = null;
        try {
            cursor = this.fni.mo10104a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[]{String.valueOf(i), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(108510);
        }
        AppMethodBeat.m2505o(108510);
        return z;
    }
}
