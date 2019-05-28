package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class b extends n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final h fni;

    public b(h hVar) {
        AppMethodBeat.i(108309);
        this.fni = hVar;
        String str = "addr_upload2";
        Cursor a = hVar.a("PRAGMA table_info( " + str + " )", null, 2);
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
            hVar.hY(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            hVar.hY(str, "Alter table " + str + " add showhead int ");
        }
        AppMethodBeat.o(108309);
    }

    public final boolean ap(List<String> list) {
        AppMethodBeat.i(108310);
        if (list.size() <= 0) {
            AppMethodBeat.o(108310);
            return false;
        }
        boolean z;
        bm bmVar = new bm("MicroMsg.AddrUploadStorage", "delete transaction");
        bmVar.addSplit("begin");
        long iV = this.fni.iV(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.fni.delete("addr_upload2", "id =?", new String[]{a.vR(str)});
                    ab.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AddrUploadStorage", e, "", new Object[0]);
            z = false;
        }
        this.fni.mB(iV);
        bmVar.addSplit("end");
        bmVar.dumpToLog();
        AppMethodBeat.o(108310);
        return z;
    }

    public final boolean aa(List<a> list) {
        AppMethodBeat.i(108311);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(108311);
            return false;
        }
        boolean z;
        bm bmVar = new bm("MicroMsg.AddrUploadStorage", "transaction");
        bmVar.addSplit("transation begin");
        long iV = this.fni.iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a aVar = (a) list.get(i);
                if (aVar != null) {
                    boolean z2;
                    Cursor a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + a.vR(aVar.Aq()) + "\"", null, 2);
                    if (a == null) {
                        z2 = false;
                    } else {
                        z2 = a.moveToFirst();
                        a.close();
                    }
                    if (z2) {
                        int vR = a.vR(aVar.Aq());
                        ContentValues Hl = aVar.Hl();
                        int i2 = 0;
                        if (Hl.size() > 0) {
                            i2 = this.fni.update("addr_upload2", Hl, "id=?", new String[]{String.valueOf(vR)});
                        }
                        if (i2 == 0) {
                            ab.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", aVar.apG(), aVar.getEmail());
                        } else if (i2 < 0) {
                            ab.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", aVar.apG(), aVar.getEmail());
                            z = true;
                            break;
                        } else {
                            b(3, this, aVar.Aq());
                        }
                    } else {
                        aVar.bJt = -1;
                        if (((int) this.fni.insert("addr_upload2", "id", aVar.Hl())) == -1) {
                            ab.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", aVar.apG(), aVar.getEmail());
                            z = true;
                            break;
                        }
                        b(2, this, aVar.Aq());
                    }
                }
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.AddrUploadStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mB(iV);
        bmVar.addSplit("transation end");
        bmVar.dumpToLog();
        AppMethodBeat.o(108311);
        return z;
    }

    public final boolean aq(List<String> list) {
        boolean z;
        AppMethodBeat.i(108312);
        bm bmVar = new bm("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        bmVar.addSplit("transation begin");
        long iV = this.fni.iV(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    a aVar = new a();
                    aVar.bJt = 8;
                    aVar.guD = bo.anT();
                    ContentValues Hl = aVar.Hl();
                    int i = 0;
                    if (Hl.size() > 0) {
                        i = this.fni.update("addr_upload2", Hl, "id=?", new String[]{a.vR(str)});
                    }
                    ab.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            ab.e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.fni.mB(iV);
        bmVar.addSplit("transation end");
        bmVar.dumpToLog();
        if (z) {
            b(3, this, null);
        }
        AppMethodBeat.o(108312);
        return z;
    }

    public final int a(String str, a aVar) {
        int i = 0;
        AppMethodBeat.i(108313);
        ContentValues Hl = aVar.Hl();
        if (Hl.size() > 0) {
            i = this.fni.update("addr_upload2", Hl, "id=?", new String[]{a.vR(str)});
        }
        if (i > 0) {
            if (aVar.Aq().equals(str)) {
                b(3, this, str);
            } else {
                b(5, this, str);
                b(2, this, aVar.Aq());
            }
        }
        AppMethodBeat.o(108313);
        return i;
    }

    public final a vT(String str) {
        AppMethodBeat.i(108314);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(108314);
            return null;
        }
        a aVar = new a();
        Cursor a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bo.vA(str) + "\"", null, 2);
        ab.d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(str)));
        if (a.moveToFirst()) {
            aVar.d(a);
        }
        a.close();
        AppMethodBeat.o(108314);
        return aVar;
    }

    public final Cursor vU(String str) {
        AppMethodBeat.i(108315);
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
        String str2 = (String) g.RP().Ry().get(6, null);
        Cursor a;
        if (str2 == null || str2.equals("")) {
            a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
            AppMethodBeat.o(108315);
            return a;
        }
        a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
        AppMethodBeat.o(108315);
        return a;
    }

    public final Cursor vV(String str) {
        AppMethodBeat.i(108316);
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
        String str2 = (String) g.RP().Ry().get(6, null);
        Cursor a;
        if (str2 == null || str2.equals("")) {
            a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by showhead", null, 0);
            AppMethodBeat.o(108316);
            return a;
        }
        a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + stringBuilder.toString() + " order by showhead", null, 0);
        AppMethodBeat.o(108316);
        return a;
    }

    public final a vW(String str) {
        a aVar = null;
        AppMethodBeat.i(108317);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(108317);
        } else {
            Cursor a = this.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + a.vR(str) + "\"", null, 2);
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.d(a);
            }
            ab.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (aVar != null ? 1 : 0));
            a.close();
            AppMethodBeat.o(108317);
        }
        return aVar;
    }

    public final List<String[]> apJ() {
        AppMethodBeat.i(108318);
        Cursor a = this.fni.a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(new String[]{a.getString(0), a.getString(1)});
        }
        a.close();
        AppMethodBeat.o(108318);
        return arrayList;
    }

    public final List<a> vX(String str) {
        AppMethodBeat.i(108319);
        ab.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        ab.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        Cursor a = this.fni.a(str, null, 2);
        while (a.moveToNext()) {
            a aVar = new a();
            aVar.d(a);
            arrayList.add(aVar);
        }
        a.close();
        AppMethodBeat.o(108319);
        return arrayList;
    }

    public final boolean apK() {
        AppMethodBeat.i(108320);
        if (this.fni == null || this.fni.dpU()) {
            String str = "MicroMsg.AddrUploadStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.fni == null ? BuildConfig.COMMAND : Boolean.valueOf(this.fni.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(108320);
            return false;
        }
        AppMethodBeat.o(108320);
        return true;
    }

    public final String vY(String str) {
        AppMethodBeat.i(108321);
        a vW = vW(str);
        if (vW != null) {
            String username = vW.getUsername();
            AppMethodBeat.o(108321);
            return username;
        }
        AppMethodBeat.o(108321);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String vZ(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(108322);
        if (!bo.isNullOrNil(str)) {
            Cursor a;
            try {
                a = this.fni.a("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null, 2);
                try {
                    if (a.moveToFirst()) {
                        a aVar = new a();
                        aVar.d(a);
                        String username = aVar.getUsername();
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(108322);
                        return username;
                    } else if (a != null) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(108322);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                        }
                        AppMethodBeat.o(108322);
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
                AppMethodBeat.o(108322);
                throw th;
            }
        }
        AppMethodBeat.o(108322);
        return null;
    }
}
