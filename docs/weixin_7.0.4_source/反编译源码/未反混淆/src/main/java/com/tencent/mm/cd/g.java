package com.tencent.mm.cd;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g implements e {
    private static String ybL = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean vcA;
    public h ybK;
    public Map<String, i> ybM;
    public Queue<a> ybN;
    public f ybk;

    public interface a {
        int a(g gVar);

        String getTableName();
    }

    public final void closeDB() {
        AppMethodBeat.i(59088);
        ybL = bo.dpG().toString();
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        AppMethodBeat.o(59088);
    }

    public final boolean dpU() {
        AppMethodBeat.i(59089);
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.e("MicroMsg.MemoryStorage", "memory db is close [%s]", ybL);
            AppMethodBeat.o(59089);
            return true;
        }
        AppMethodBeat.o(59089);
        return false;
    }

    public final int aqv(String str) {
        String str2 = null;
        AppMethodBeat.i(59090);
        if (!this.vcA) {
            AppMethodBeat.o(59090);
            return -4;
        } else if (this.ybK == null || this.ybK.inTransaction()) {
            ab.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            AppMethodBeat.o(59090);
            return -3;
        } else {
            try {
                if (f.a(this.ybk, str)) {
                    this.ybk.execSQL("drop table ".concat(String.valueOf(str)));
                    ab.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
                }
                Cursor a = this.ybK.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
                if (a != null) {
                    if (a.getCount() == 1) {
                        a.moveToFirst();
                        str2 = a.getString(0);
                    }
                    a.close();
                }
                if (str2 == null) {
                    ab.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                    AppMethodBeat.o(59090);
                    return -1;
                }
                this.ybk.execSQL(str2);
                this.ybk.execSQL("insert into " + str + " select * from old." + str);
                ab.d("MicroMsg.MemoryStorage", "copy table %s success", str);
                AppMethodBeat.o(59090);
                return 0;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
                AppMethodBeat.o(59090);
                return -2;
            }
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.i(59091);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        int delete;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.o(59091);
                return -1;
            }
            delete = this.ybK.delete(str, str2, strArr);
            AppMethodBeat.o(59091);
            return delete;
        }
        i iVar = (i) this.ybM.get(str);
        com.tencent.mm.cd.i.a aVar = new com.tencent.mm.cd.i.a();
        aVar.xBj = 5;
        aVar.ycf = str2;
        aVar.T(strArr);
        iVar.b(aVar);
        delete = this.ybk.delete(str, str2, strArr);
        AppMethodBeat.o(59091);
        return delete;
    }

    public final boolean hY(String str, String str2) {
        AppMethodBeat.i(59092);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.o(59092);
                return false;
            }
            this.ybK.hY(str2, str);
            AppMethodBeat.o(59092);
            return true;
        }
        i iVar = (i) this.ybM.get(str);
        com.tencent.mm.cd.i.a aVar = new com.tencent.mm.cd.i.a();
        aVar.xBj = 1;
        aVar.sql = str2;
        iVar.b(aVar);
        this.ybk.execSQL(str2);
        AppMethodBeat.o(59092);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(59093);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        long insert;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.o(59093);
                return -1;
            }
            insert = this.ybK.insert(str, str2, contentValues);
            AppMethodBeat.o(59093);
            return insert;
        }
        i iVar = (i) this.ybM.get(str);
        com.tencent.mm.cd.i.a aVar = new com.tencent.mm.cd.i.a();
        aVar.xBj = 2;
        aVar.xDc = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.b(aVar);
        insert = this.ybk.insert(str, str2, contentValues);
        AppMethodBeat.o(59093);
        return insert;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(59094);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        long replace;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.o(59094);
                return -1;
            }
            replace = this.ybK.replace(str, str2, contentValues);
            AppMethodBeat.o(59094);
            return replace;
        }
        i iVar = (i) this.ybM.get(str);
        com.tencent.mm.cd.i.a aVar = new com.tencent.mm.cd.i.a();
        aVar.xBj = 4;
        aVar.xDc = str2;
        aVar.values = new ContentValues(contentValues);
        iVar.b(aVar);
        replace = this.ybk.replace(str, str2, contentValues);
        AppMethodBeat.o(59094);
        return replace;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(59095);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        int update;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.o(59095);
                return -1;
            }
            update = this.ybK.update(str, contentValues, str2, strArr);
            AppMethodBeat.o(59095);
            return update;
        }
        i iVar = (i) this.ybM.get(str);
        com.tencent.mm.cd.i.a aVar = new com.tencent.mm.cd.i.a();
        aVar.xBj = 3;
        aVar.ycf = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.T(strArr);
        iVar.b(aVar);
        update = this.ybk.update(str, contentValues, str2, strArr);
        AppMethodBeat.o(59095);
        return update;
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.i(59096);
        Cursor dvo;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, ybL);
            dvo = d.dvo();
            AppMethodBeat.o(59096);
            return dvo;
        }
        dvo = this.ybk.a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        AppMethodBeat.o(59096);
        return dvo;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        AppMethodBeat.i(59097);
        Cursor query = query(str, strArr, str2, strArr2, str3, str4, str5);
        AppMethodBeat.o(59097);
        return query;
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(59098);
        Cursor dvo;
        if (this.ybk == null || !this.ybk.isOpen()) {
            ab.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, ybL);
            dvo = d.dvo();
            AppMethodBeat.o(59098);
            return dvo;
        }
        dvo = this.ybk.a(str, strArr, 0);
        AppMethodBeat.o(59098);
        return dvo;
    }

    public final Cursor a(String str, String[] strArr, int i) {
        AppMethodBeat.i(59099);
        Cursor rawQuery = rawQuery(str, strArr);
        AppMethodBeat.o(59099);
        return rawQuery;
    }
}
