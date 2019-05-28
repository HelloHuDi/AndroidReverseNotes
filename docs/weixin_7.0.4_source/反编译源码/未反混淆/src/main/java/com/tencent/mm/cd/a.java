package com.tencent.mm.cd;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import junit.framework.Assert;

public final class a {
    public static final Pattern ybj = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    private String aIm = "";
    private boolean isNew = false;
    String key;
    f ybk;
    String ybl = "";
    public boolean ybm = false;
    String ybn = "";
    public boolean ybo = false;

    static {
        AppMethodBeat.i(59031);
        AppMethodBeat.o(59031);
    }

    public final String getError() {
        AppMethodBeat.i(59019);
        String str;
        if (bo.isNullOrNil(this.aIm) || bo.isNullOrNil(this.ybn)) {
            str = "";
            AppMethodBeat.o(59019);
            return str;
        } else if (bo.isNullOrNil(com.tencent.mm.sdk.e.a.getValue(this.ybn, "Reported"))) {
            com.tencent.mm.sdk.e.a.aB(this.ybn, "Reported", "true");
            str = this.aIm;
            AppMethodBeat.o(59019);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(59019);
            return str;
        }
    }

    /* renamed from: if */
    private void m3if(String str, String str2) {
        AppMethodBeat.i(59020);
        HashSet hashSet = new HashSet();
        String str3 = "";
        Cursor a = this.ybk.a("select * from " + str + " limit 1 ", null, 0);
        if (a.getCount() == 0) {
            a.close();
            AppMethodBeat.o(59020);
            return;
        }
        a.moveToFirst();
        for (int i = 0; i < a.getColumnCount(); i++) {
            hashSet.add(a.getColumnName(i));
        }
        a.close();
        a = this.ybk.a("PRAGMA table_info( " + str2 + " )", null, 0);
        String str4 = str3;
        while (a.moveToNext()) {
            str3 = a.getString(a.getColumnIndex("name"));
            if (hashSet.contains(str3)) {
                str4 = (str4 + str3) + ",";
            }
        }
        a.close();
        str4 = str4.substring(0, str4.length() - 1);
        this.ybk.execSQL("insert into " + str2 + "(" + str4 + ") select " + str4 + " from " + str + ";");
        AppMethodBeat.o(59020);
    }

    private boolean r(Cursor cursor) {
        int i;
        AppMethodBeat.i(59021);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            hashSet.add(cursor.getString(0));
        }
        Cursor a = this.ybk.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (a == null) {
            AppMethodBeat.o(59021);
            return false;
        }
        for (i = 0; i < a.getCount(); i++) {
            a.moveToPosition(i);
            hashSet2.add(a.getString(0));
        }
        a.close();
        this.ybk.beginTransaction();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashSet.contains(str)) {
                Cursor a2 = this.ybk.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0);
                if (a2 != null) {
                    this.ybk.execSQL(a2.getString(0));
                    a2.close();
                }
            }
        }
        this.ybk.endTransaction();
        AppMethodBeat.o(59021);
        return true;
    }

    private List<String> ig(String str, String str2) {
        AppMethodBeat.i(59022);
        ArrayList arrayList = new ArrayList();
        if (this.ybk == null) {
            AppMethodBeat.o(59022);
            return arrayList;
        }
        Cursor a = this.ybk.a("PRAGMA table_info( " + str + " )", null, 0);
        if (a == null) {
            AppMethodBeat.o(59022);
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex("type");
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        a = this.ybk.a("PRAGMA table_info( " + str2 + " )", null, 0);
        if (a == null) {
            AppMethodBeat.o(59022);
            return arrayList;
        }
        HashMap hashMap2 = new HashMap();
        columnIndex = a.getColumnIndex("name");
        columnIndex2 = a.getColumnIndex("type");
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        Iterator it = new HashSet(hashMap.entrySet()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 != null && str4.length() > 0) {
                String str5 = (String) hashMap2.get(str3);
                if (str5 == null) {
                    arrayList.add("ALTER TABLE " + str2 + " ADD COLUMN " + str3 + " " + str4 + ";");
                    hashMap.remove(str3);
                } else if (!str4.toLowerCase().startsWith(str5.toLowerCase())) {
                    ab.e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        AppMethodBeat.o(59022);
        return arrayList;
    }

    private boolean ih(String str, String str2) {
        AppMethodBeat.i(59023);
        Cursor a = this.ybk.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (a == null) {
            AppMethodBeat.o(59023);
            return false;
        }
        try {
            if (bo.isNullOrNil(str2)) {
                this.ybk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.ybk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (r(a)) {
                this.ybk.beginTransaction();
                for (int i = 0; i < a.getCount(); i++) {
                    int count;
                    a.moveToPosition(i);
                    Cursor a2 = this.ybk.a("select * from old.sqlite_master where tbl_name = '" + a.getString(0) + "'", null, 0);
                    if (a2 != null) {
                        count = a2.getCount();
                        a2.close();
                    } else {
                        count = 0;
                    }
                    if (count == 0) {
                        ab.w("MicroMsg.DBInit", "In old db not found :" + a.getString(0));
                    } else {
                        try {
                            for (String execSQL : ig("old." + a.getString(0), a.getString(0))) {
                                this.ybk.execSQL(execSQL);
                            }
                            m3if("old." + a.getString(0), a.getString(0));
                        } catch (Exception e) {
                            ab.w("MicroMsg.DBInit", "Insertselect FAILED :" + a.getString(0));
                        }
                    }
                }
                this.ybk.endTransaction();
                a.close();
                this.ybk.execSQL("DETACH DATABASE old;");
                AppMethodBeat.o(59023);
                return true;
            }
            AppMethodBeat.o(59023);
            return false;
        } catch (SQLiteDatabaseCorruptException e2) {
            ab.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(str)));
            e.deleteFile(str);
            AppMethodBeat.o(59023);
            throw e2;
        }
    }

    public final boolean a(String str, HashMap<Integer, d> hashMap, boolean z) {
        AppMethodBeat.i(59024);
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        try {
            boolean z2;
            ab.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.TRUE, Boolean.valueOf(e.ct(str)), str);
            this.ybk = f.ca(str, z);
            if (e.ct(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (a((HashMap) hashMap, true, z2)) {
                AppMethodBeat.o(59024);
                return true;
            }
            if (this.ybk != null) {
                this.ybk.close();
                this.ybk = null;
            }
            AppMethodBeat.o(59024);
            return false;
        } catch (SQLiteException e) {
            AppMethodBeat.o(59024);
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j, HashMap<Integer, d> hashMap, boolean z) {
        Object obj;
        AppMethodBeat.i(59025);
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !bo.isNullOrNil(str2));
        this.ybn = str2 + ".errreport";
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        boolean ct = e.ct(str2);
        boolean ct2 = e.ct(str);
        boolean ct3 = e.ct(str3);
        Object obj2 = (ct || !ct2) ? null : 1;
        this.ybm = a(str2, j, f.dvt(), str3);
        String str4 = "MicroMsg.DBInit";
        String str5 = "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s";
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(ct);
        objArr[2] = Boolean.valueOf(ct2);
        objArr[3] = Boolean.TRUE;
        objArr[4] = Boolean.valueOf(this.ybm);
        objArr[5] = Boolean.valueOf(this.ybk != null);
        objArr[6] = Thread.currentThread().getName();
        ab.i(str4, str5, objArr);
        if (this.ybk == null || this.ybk.getPath().equals(str3) || !ct3) {
            obj = null;
        } else {
            obj = 1;
            ab.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        if (!a((HashMap) hashMap, z, this.isNew)) {
            AppMethodBeat.o(59025);
            return false;
        } else if (ct2 || ct3) {
            if (!(obj == null && obj2 == null)) {
                this.ybo = true;
            }
            if (obj != null) {
                this.key = g.x((q.LK() + j).getBytes()).substring(0, 7);
                ii(str3, this.key);
                com.tencent.mm.blink.a.r(201, 1);
            }
            if (obj2 != null) {
                boolean ii = ii(str, "");
                com.tencent.mm.blink.a.r(200, 1);
                AppMethodBeat.o(59025);
                return ii;
            } else if (this.ybk != null) {
                AppMethodBeat.o(59025);
                return true;
            } else {
                AppMethodBeat.o(59025);
                return false;
            }
        } else {
            AppMethodBeat.o(59025);
            return true;
        }
    }

    private boolean ii(String str, String str2) {
        AppMethodBeat.i(59026);
        if (ih(str, str2)) {
            ab.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            ab.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(e.deleteFile(str)));
            AppMethodBeat.o(59026);
            return true;
        }
        ab.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        AppMethodBeat.o(59026);
        return false;
    }

    private static void a(f fVar) {
        AppMethodBeat.i(59027);
        com.tencent.wcdb.Cursor rawQueryWithFactory = (fVar.ybt != null ? fVar.ybt : fVar.ybu).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            AppMethodBeat.o(59027);
            return;
        }
        SQLiteException sQLiteException = new SQLiteException("Cannot get count for sqlite_master");
        AppMethodBeat.o(59027);
        throw sQLiteException;
    }

    private static Collection<String> dvm() {
        Throwable e;
        AppMethodBeat.i(59028);
        Context context = ah.getContext();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(q.LK());
        linkedHashSet.add(q.getDeviceID(context));
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("_wEcHAT_".getBytes(), "RC4");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, secretKeySpec);
            bufferedReader = new BufferedReader(new InputStreamReader(new CipherInputStream(context.openFileInput("KeyInfo.bin"), instance)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    linkedHashSet.add(readLine);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
                        bo.b(bufferedReader);
                        linkedHashSet.add("1234567890ABCDEF");
                        AppMethodBeat.o(59028);
                        return linkedHashSet;
                    } catch (Throwable th) {
                        e = th;
                        closeable = bufferedReader;
                        bo.b(closeable);
                        AppMethodBeat.o(59028);
                        throw e;
                    }
                }
            }
            bo.b(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
            bo.b(bufferedReader);
            linkedHashSet.add("1234567890ABCDEF");
            AppMethodBeat.o(59028);
            return linkedHashSet;
        } catch (Throwable th2) {
            e = th2;
            bo.b(closeable);
            AppMethodBeat.o(59028);
            throw e;
        }
        linkedHashSet.add("1234567890ABCDEF");
        AppMethodBeat.o(59028);
        return linkedHashSet;
    }

    private boolean a(String str, long j, boolean z, String str2) {
        AppMethodBeat.i(59029);
        if (this.ybk != null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(59029);
            throw assertionError;
        }
        this.isNew = !e.ct(str);
        Object obj = null;
        for (String str3 : dvm()) {
            this.key = g.x((str3 + j).getBytes()).substring(0, 7);
            try {
                this.ybk = f.E(str, this.key, z);
                a(this.ybk);
                if (!q.LK().equals(str3)) {
                    ab.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str3)));
                    l.Lu().set(com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, str3);
                    com.tencent.mm.plugin.report.e.pXa.a(181, 5, 1, false);
                }
                AppMethodBeat.o(59029);
                return true;
            } catch (SQLiteException e) {
                if (!(e instanceof SQLiteDatabaseCorruptException)) {
                    obj = null;
                    break;
                }
                obj = 1;
            }
        }
        if (obj != null) {
            int i;
            if (!z) {
                i = 42;
            } else if (f.dvu()) {
                i = 43;
            } else {
                i = 41;
            }
            com.tencent.mm.plugin.report.e.pXa.a(181, (long) i, 1, true);
            f.aqu(str);
            if (str.endsWith("EnMicroMsg.db")) {
                f.aqu(com.tencent.mm.kernel.g.RP().eJM + "dbback/EnMicroMsg.db");
            }
            try {
                this.key = g.x((q.LK() + j).getBytes()).substring(0, 7);
                this.ybk = f.E(str, this.key, z);
                a(this.ybk);
                this.isNew = true;
                com.tencent.mm.plugin.report.e.pXa.a(181, 6, 1, false);
                AppMethodBeat.o(59029);
                return true;
            } catch (SQLiteException e2) {
                com.tencent.mm.plugin.report.e.pXa.a(181, 7, 1, false);
            }
        } else {
            if (str2 != null && str2.length() > 0) {
                this.isNew = !e.ct(str2);
                try {
                    this.ybk = f.E(str2, this.key, z);
                    a(this.ybk);
                    com.tencent.mm.plugin.report.e.pXa.a(181, 6, 1, false);
                    AppMethodBeat.o(59029);
                    return true;
                } catch (SQLiteException e3) {
                    com.tencent.mm.plugin.report.e.pXa.a(181, 7, 1, false);
                }
            }
            if (this.ybk != null) {
                this.ybk.close();
                this.ybk = null;
            }
            this.key = null;
            AppMethodBeat.o(59029);
            return false;
        }
    }

    private boolean a(HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        AppMethodBeat.i(59030);
        if (this.ybk == null) {
            AppMethodBeat.o(59030);
            return false;
        }
        int i;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        ab.d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.ybl = this.ybk.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (d dVar : hashMap.values()) {
                    if (dVar.Af() == null) {
                        ab.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", dVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + dVar.getClass().toString(), false);
                    }
                    for (String hashCode : dVar.Af()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = g.x(stringBuilder.toString().getBytes());
            if (!z2) {
                str = com.tencent.mm.sdk.e.a.getValue(this.ybl, "createmd5");
                if (!bo.isNullOrNil(str) && str3.equals(str)) {
                    ab.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.ybk.getPath());
                    AppMethodBeat.o(59030);
                    return true;
                }
            }
        }
        str = str3;
        this.ybk.execSQL("pragma auto_vacuum = 0 ");
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        int i2 = 0;
        this.ybk.beginTransaction();
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = i;
                for (String str4 : ((d) it.next()).Af()) {
                    try {
                        this.ybk.execSQL(str4);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = ybj.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            ab.w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        long Mr = aVar.Mr();
        this.ybk.endTransaction();
        ab.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(Mr), Long.valueOf(aVar.Mr()), Integer.valueOf(i));
        if (z) {
            com.tencent.mm.sdk.e.a.aB(this.ybl, "createmd5", str);
        }
        AppMethodBeat.o(59030);
        return true;
    }
}
