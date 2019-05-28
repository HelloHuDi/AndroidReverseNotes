package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class b extends j<a> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] fnj = new String[]{j.a(a.ccO, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public e bSd;

    static {
        AppMethodBeat.i(18640);
        AppMethodBeat.o(18640);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "WxFileIndex2", diI);
        this.bSd = eVar;
    }

    public final boolean delete() {
        long delete;
        AppMethodBeat.i(18630);
        try {
            delete = (long) this.bSd.delete("WxFileIndex2", null, null);
        } catch (Exception e) {
            delete = 0;
        }
        if (delete > 0) {
            AppMethodBeat.o(18630);
            return true;
        }
        AppMethodBeat.o(18630);
        return false;
    }

    public final long sK(int i) {
        Cursor cursor = null;
        AppMethodBeat.i(18631);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select sum(size)  from WxFileIndex2  where msgType=".concat(String.valueOf(i)), null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18631);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18631);
        }
    }

    public final long sL(int i) {
        Cursor cursor = null;
        AppMethodBeat.i(18632);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18632);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18632);
        }
    }

    public final long aZn() {
        Cursor cursor = null;
        AppMethodBeat.i(18633);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18633);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18633);
        }
    }

    public final Cursor aZo() {
        Cursor cursor = null;
        AppMethodBeat.i(18634);
        try {
            cursor = this.bSd.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e) {
        }
        AppMethodBeat.o(18634);
        return cursor;
    }

    public final List<a> j(String str, long j, long j2) {
        AppMethodBeat.i(18635);
        long yz = bo.yz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgSubType in (1,20,23,30,32,34 ) and size > 0  order by msgtime DESC,msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.d(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18635);
        }
        ab.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(18635);
        return arrayList;
    }

    public final List<a> k(String str, long j, long j2) {
        AppMethodBeat.i(18636);
        long yz = bo.yz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgType in (43,62,44,3,49,268435505 ) order by msgtime DESC,msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    a aVar = new a();
                    aVar.d(cursor);
                    arrayList.add(aVar);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(18636);
        }
        ab.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(18636);
        return arrayList;
    }

    public final List<a> S(bi biVar) {
        List<a> list = null;
        AppMethodBeat.i(18637);
        if (biVar == null) {
            AppMethodBeat.o(18637);
            return list;
        }
        String str = "select *, rowid from WxFileIndex2  where msgId=" + biVar.field_msgId + " AND username='" + biVar.field_talker + "' order by msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.bSd.rawQuery(str, null);
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.d(rawQuery);
                arrayList.add(aVar);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e) {
            if (list != null) {
                list.close();
            }
        } catch (Throwable th) {
            if (list != null) {
                list.close();
            }
            AppMethodBeat.o(18637);
        }
        AppMethodBeat.o(18637);
        return arrayList;
    }

    public final int bd(List<a> list) {
        AppMethodBeat.i(18638);
        if (list.isEmpty()) {
            AppMethodBeat.o(18638);
            return 0;
        }
        long yz = bo.yz();
        int i = 0;
        for (a a : list) {
            int i2;
            if (a((c) a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        ab.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(18638);
        return i;
    }

    public final int be(List<a> list) {
        AppMethodBeat.i(18639);
        if (list.isEmpty()) {
            AppMethodBeat.o(18639);
            return 0;
        }
        long yz = bo.yz();
        int i = 0;
        for (a aVar : list) {
            int i2;
            if (a(aVar.xDa, (c) aVar, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        ab.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(18639);
        return i;
    }
}
