package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5042bm;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.b */
public final class C18818b extends C7298n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final C7480h fni;

    public C18818b(C7480h c7480h) {
        AppMethodBeat.m2504i(108309);
        this.fni = c7480h;
        String str = "addr_upload2";
        Cursor a = c7480h.mo10104a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj = null;
        Object obj2 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        a.close();
        if (obj2 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add showhead int ");
        }
        AppMethodBeat.m2505o(108309);
    }

    /* renamed from: ap */
    public final boolean mo34086ap(List<String> list) {
        AppMethodBeat.m2504i(108310);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(108310);
            return false;
        }
        boolean z;
        C5042bm c5042bm = new C5042bm("MicroMsg.AddrUploadStorage", "delete transaction");
        c5042bm.addSplit("begin");
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.fni.delete("addr_upload2", "id =?", new String[]{C18817a.m29385vR(str)});
                    C4990ab.m7410d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        mo10120b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AddrUploadStorage", e, "", new Object[0]);
            z = false;
        }
        this.fni.mo15640mB(iV);
        c5042bm.addSplit("end");
        c5042bm.dumpToLog();
        AppMethodBeat.m2505o(108310);
        return z;
    }

    /* renamed from: aa */
    public final boolean mo34085aa(List<C18817a> list) {
        AppMethodBeat.m2504i(108311);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(108311);
            return false;
        }
        boolean z;
        C5042bm c5042bm = new C5042bm("MicroMsg.AddrUploadStorage", "transaction");
        c5042bm.addSplit("transation begin");
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                C18817a c18817a = (C18817a) list.get(i);
                if (c18817a != null) {
                    boolean z2;
                    Cursor a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + C18817a.m29385vR(c18817a.mo34067Aq()) + "\"", null, 2);
                    if (a == null) {
                        z2 = false;
                    } else {
                        z2 = a.moveToFirst();
                        a.close();
                    }
                    if (z2) {
                        int vR = C18817a.m29385vR(c18817a.mo34067Aq());
                        ContentValues Hl = c18817a.mo34068Hl();
                        int i2 = 0;
                        if (Hl.size() > 0) {
                            i2 = this.fni.update("addr_upload2", Hl, "id=?", new String[]{String.valueOf(vR)});
                        }
                        if (i2 == 0) {
                            C4990ab.m7417i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", c18817a.apG(), c18817a.getEmail());
                        } else if (i2 < 0) {
                            C4990ab.m7417i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", c18817a.apG(), c18817a.getEmail());
                            z = true;
                            break;
                        } else {
                            mo10120b(3, this, c18817a.mo34067Aq());
                        }
                    } else {
                        c18817a.bJt = -1;
                        if (((int) this.fni.insert("addr_upload2", "id", c18817a.mo34068Hl())) == -1) {
                            C4990ab.m7417i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", c18817a.apG(), c18817a.getEmail());
                            z = true;
                            break;
                        }
                        mo10120b(2, this, c18817a.mo34067Aq());
                    }
                }
                i++;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AddrUploadStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mo15640mB(iV);
        c5042bm.addSplit("transation end");
        c5042bm.dumpToLog();
        AppMethodBeat.m2505o(108311);
        return z;
    }

    /* renamed from: aq */
    public final boolean mo34088aq(List<String> list) {
        boolean z;
        AppMethodBeat.m2504i(108312);
        C5042bm c5042bm = new C5042bm("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        c5042bm.addSplit("transation begin");
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    C18817a c18817a = new C18817a();
                    c18817a.bJt = 8;
                    c18817a.guD = C5046bo.anT();
                    ContentValues Hl = c18817a.mo34068Hl();
                    int i = 0;
                    if (Hl.size() > 0) {
                        i = this.fni.update("addr_upload2", Hl, "id=?", new String[]{C18817a.m29385vR(str)});
                    }
                    C4990ab.m7416i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.fni.mo15640mB(iV);
        c5042bm.addSplit("transation end");
        c5042bm.dumpToLog();
        if (z) {
            mo10120b(3, this, null);
        }
        AppMethodBeat.m2505o(108312);
        return z;
    }

    /* renamed from: a */
    public final int mo34084a(String str, C18817a c18817a) {
        int i = 0;
        AppMethodBeat.m2504i(108313);
        ContentValues Hl = c18817a.mo34068Hl();
        if (Hl.size() > 0) {
            i = this.fni.update("addr_upload2", Hl, "id=?", new String[]{C18817a.m29385vR(str)});
        }
        if (i > 0) {
            if (c18817a.mo34067Aq().equals(str)) {
                mo10120b(3, this, str);
            } else {
                mo10120b(5, this, str);
                mo10120b(2, this, c18817a.mo34067Aq());
            }
        }
        AppMethodBeat.m2505o(108313);
        return i;
    }

    /* renamed from: vT */
    public final C18817a mo34089vT(String str) {
        AppMethodBeat.m2504i(108314);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(108314);
            return null;
        }
        C18817a c18817a = new C18817a();
        Cursor a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + C5046bo.m7586vA(str) + "\"", null, 2);
        C4990ab.m7410d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(str)));
        if (a.moveToFirst()) {
            c18817a.mo34080d(a);
        }
        a.close();
        AppMethodBeat.m2505o(108314);
        return c18817a;
    }

    /* renamed from: vU */
    public final Cursor mo34090vU(String str) {
        AppMethodBeat.m2504i(108315);
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        Cursor a;
        if (str2 == null || str2.equals("")) {
            a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
            AppMethodBeat.m2505o(108315);
            return a;
        }
        a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
        AppMethodBeat.m2505o(108315);
        return a;
    }

    /* renamed from: vV */
    public final Cursor mo34091vV(String str) {
        AppMethodBeat.m2504i(108316);
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        Cursor a;
        if (str2 == null || str2.equals("")) {
            a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by showhead", null, 0);
            AppMethodBeat.m2505o(108316);
            return a;
        }
        a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + stringBuilder.toString() + " order by showhead", null, 0);
        AppMethodBeat.m2505o(108316);
        return a;
    }

    /* renamed from: vW */
    public final C18817a mo34092vW(String str) {
        C18817a c18817a = null;
        AppMethodBeat.m2504i(108317);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(108317);
        } else {
            Cursor a = this.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + C18817a.m29385vR(str) + "\"", null, 2);
            if (a.moveToFirst()) {
                c18817a = new C18817a();
                c18817a.mo34080d(a);
            }
            C4990ab.m7410d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (c18817a != null ? 1 : 0));
            a.close();
            AppMethodBeat.m2505o(108317);
        }
        return c18817a;
    }

    public final List<String[]> apJ() {
        AppMethodBeat.m2504i(108318);
        Cursor a = this.fni.mo10104a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(new String[]{a.getString(0), a.getString(1)});
        }
        a.close();
        AppMethodBeat.m2505o(108318);
        return arrayList;
    }

    /* renamed from: vX */
    public final List<C18817a> mo34093vX(String str) {
        AppMethodBeat.m2504i(108319);
        C4990ab.m7410d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        C4990ab.m7410d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10104a(str, null, 2);
        while (a.moveToNext()) {
            C18817a c18817a = new C18817a();
            c18817a.mo34080d(a);
            arrayList.add(c18817a);
        }
        a.close();
        AppMethodBeat.m2505o(108319);
        return arrayList;
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(108320);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.AddrUploadStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(108320);
            return false;
        }
        AppMethodBeat.m2505o(108320);
        return true;
    }

    /* renamed from: vY */
    public final String mo34094vY(String str) {
        AppMethodBeat.m2504i(108321);
        C18817a vW = mo34092vW(str);
        if (vW != null) {
            String username = vW.getUsername();
            AppMethodBeat.m2505o(108321);
            return username;
        }
        AppMethodBeat.m2505o(108321);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vZ */
    public final String mo34095vZ(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(108322);
        if (!C5046bo.isNullOrNil(str)) {
            Cursor a;
            try {
                a = this.fni.mo10105a("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null, 2);
                try {
                    if (a.moveToFirst()) {
                        C18817a c18817a = new C18817a();
                        c18817a.mo34080d(a);
                        String username = c18817a.getUsername();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(108322);
                        return username;
                    } else if (a != null) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(108322);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                        }
                        AppMethodBeat.m2505o(108322);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(108322);
                throw th;
            }
        }
        AppMethodBeat.m2505o(108322);
        return null;
    }
}
