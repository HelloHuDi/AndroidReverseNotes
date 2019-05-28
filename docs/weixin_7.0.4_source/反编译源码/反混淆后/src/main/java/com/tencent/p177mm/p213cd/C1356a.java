package com.tencent.p177mm.p213cd;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.compatible.p221e.C1420l;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.cd.a */
public final class C1356a {
    public static final Pattern ybj = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    private String aIm = "";
    private boolean isNew = false;
    String key;
    C6395f ybk;
    String ybl = "";
    public boolean ybm = false;
    String ybn = "";
    public boolean ybo = false;

    static {
        AppMethodBeat.m2504i(59031);
        AppMethodBeat.m2505o(59031);
    }

    public final String getError() {
        AppMethodBeat.m2504i(59019);
        String str;
        if (C5046bo.isNullOrNil(this.aIm) || C5046bo.isNullOrNil(this.ybn)) {
            str = "";
            AppMethodBeat.m2505o(59019);
            return str;
        } else if (C5046bo.isNullOrNil(C4894a.getValue(this.ybn, "Reported"))) {
            C4894a.m7286aB(this.ybn, "Reported", "true");
            str = this.aIm;
            AppMethodBeat.m2505o(59019);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(59019);
            return str;
        }
    }

    /* renamed from: if */
    private void m2905if(String str, String str2) {
        AppMethodBeat.m2504i(59020);
        HashSet hashSet = new HashSet();
        String str3 = "";
        Cursor a = this.ybk.mo14612a("select * from " + str + " limit 1 ", null, 0);
        if (a.getCount() == 0) {
            a.close();
            AppMethodBeat.m2505o(59020);
            return;
        }
        a.moveToFirst();
        for (int i = 0; i < a.getColumnCount(); i++) {
            hashSet.add(a.getColumnName(i));
        }
        a.close();
        a = this.ybk.mo14612a("PRAGMA table_info( " + str2 + " )", null, 0);
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
        AppMethodBeat.m2505o(59020);
    }

    /* renamed from: r */
    private boolean m2909r(Cursor cursor) {
        int i;
        AppMethodBeat.m2504i(59021);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            hashSet.add(cursor.getString(0));
        }
        Cursor a = this.ybk.mo14612a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (a == null) {
            AppMethodBeat.m2505o(59021);
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
                Cursor a2 = this.ybk.mo14612a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0);
                if (a2 != null) {
                    this.ybk.execSQL(a2.getString(0));
                    a2.close();
                }
            }
        }
        this.ybk.endTransaction();
        AppMethodBeat.m2505o(59021);
        return true;
    }

    /* renamed from: ig */
    private List<String> m2906ig(String str, String str2) {
        AppMethodBeat.m2504i(59022);
        ArrayList arrayList = new ArrayList();
        if (this.ybk == null) {
            AppMethodBeat.m2505o(59022);
            return arrayList;
        }
        Cursor a = this.ybk.mo14612a("PRAGMA table_info( " + str + " )", null, 0);
        if (a == null) {
            AppMethodBeat.m2505o(59022);
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex("type");
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        a = this.ybk.mo14612a("PRAGMA table_info( " + str2 + " )", null, 0);
        if (a == null) {
            AppMethodBeat.m2505o(59022);
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
                    C4990ab.m7412e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        AppMethodBeat.m2505o(59022);
        return arrayList;
    }

    /* renamed from: ih */
    private boolean m2907ih(String str, String str2) {
        AppMethodBeat.m2504i(59023);
        Cursor a = this.ybk.mo14612a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (a == null) {
            AppMethodBeat.m2505o(59023);
            return false;
        }
        try {
            if (C5046bo.isNullOrNil(str2)) {
                this.ybk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.ybk.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (m2909r(a)) {
                this.ybk.beginTransaction();
                for (int i = 0; i < a.getCount(); i++) {
                    int count;
                    a.moveToPosition(i);
                    Cursor a2 = this.ybk.mo14612a("select * from old.sqlite_master where tbl_name = '" + a.getString(0) + "'", null, 0);
                    if (a2 != null) {
                        count = a2.getCount();
                        a2.close();
                    } else {
                        count = 0;
                    }
                    if (count == 0) {
                        C4990ab.m7420w("MicroMsg.DBInit", "In old db not found :" + a.getString(0));
                    } else {
                        try {
                            for (String execSQL : m2906ig("old." + a.getString(0), a.getString(0))) {
                                this.ybk.execSQL(execSQL);
                            }
                            m2905if("old." + a.getString(0), a.getString(0));
                        } catch (Exception e) {
                            C4990ab.m7420w("MicroMsg.DBInit", "Insertselect FAILED :" + a.getString(0));
                        }
                    }
                }
                this.ybk.endTransaction();
                a.close();
                this.ybk.execSQL("DETACH DATABASE old;");
                AppMethodBeat.m2505o(59023);
                return true;
            }
            AppMethodBeat.m2505o(59023);
            return false;
        } catch (SQLiteDatabaseCorruptException e2) {
            C4990ab.m7412e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(str)));
            C5730e.deleteFile(str);
            AppMethodBeat.m2505o(59023);
            throw e2;
        }
    }

    /* renamed from: a */
    public final boolean mo4728a(String str, HashMap<Integer, C1366d> hashMap, boolean z) {
        AppMethodBeat.m2504i(59024);
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        try {
            boolean z2;
            C4990ab.m7417i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.TRUE, Boolean.valueOf(C5730e.m8628ct(str)), str);
            this.ybk = C6395f.m10549ca(str, z);
            if (C5730e.m8628ct(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (m2904a((HashMap) hashMap, true, z2)) {
                AppMethodBeat.m2505o(59024);
                return true;
            }
            if (this.ybk != null) {
                this.ybk.close();
                this.ybk = null;
            }
            AppMethodBeat.m2505o(59024);
            return false;
        } catch (SQLiteException e) {
            AppMethodBeat.m2505o(59024);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo4727a(String str, String str2, String str3, long j, HashMap<Integer, C1366d> hashMap, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(59025);
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !C5046bo.isNullOrNil(str2));
        this.ybn = str2 + ".errreport";
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        boolean ct = C5730e.m8628ct(str2);
        boolean ct2 = C5730e.m8628ct(str);
        boolean ct3 = C5730e.m8628ct(str3);
        Object obj2 = (ct || !ct2) ? null : 1;
        this.ybm = m2903a(str2, j, C6395f.dvt(), str3);
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
        C4990ab.m7417i(str4, str5, objArr);
        if (this.ybk == null || this.ybk.getPath().equals(str3) || !ct3) {
            obj = null;
        } else {
            obj = 1;
            C4990ab.m7416i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        if (!m2904a((HashMap) hashMap, z, this.isNew)) {
            AppMethodBeat.m2505o(59025);
            return false;
        } else if (ct2 || ct3) {
            if (!(obj == null && obj2 == null)) {
                this.ybo = true;
            }
            if (obj != null) {
                this.key = C1178g.m2591x((C1427q.m3026LK() + j).getBytes()).substring(0, 7);
                m2908ii(str3, this.key);
                C1311a.m2809r(201, 1);
            }
            if (obj2 != null) {
                boolean ii = m2908ii(str, "");
                C1311a.m2809r(200, 1);
                AppMethodBeat.m2505o(59025);
                return ii;
            } else if (this.ybk != null) {
                AppMethodBeat.m2505o(59025);
                return true;
            } else {
                AppMethodBeat.m2505o(59025);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(59025);
            return true;
        }
    }

    /* renamed from: ii */
    private boolean m2908ii(String str, String str2) {
        AppMethodBeat.m2504i(59026);
        if (m2907ih(str, str2)) {
            C4990ab.m7417i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            C4990ab.m7417i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(C5730e.deleteFile(str)));
            AppMethodBeat.m2505o(59026);
            return true;
        }
        C4990ab.m7417i("MicroMsg.DBInit", "system transfer fail path %s", str);
        AppMethodBeat.m2505o(59026);
        return false;
    }

    /* renamed from: a */
    private static void m2902a(C6395f c6395f) {
        AppMethodBeat.m2504i(59027);
        com.tencent.wcdb.Cursor rawQueryWithFactory = (c6395f.ybt != null ? c6395f.ybt : c6395f.ybu).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            rawQueryWithFactory.close();
            AppMethodBeat.m2505o(59027);
            return;
        }
        SQLiteException sQLiteException = new SQLiteException("Cannot get count for sqlite_master");
        AppMethodBeat.m2505o(59027);
        throw sQLiteException;
    }

    private static Collection<String> dvm() {
        Throwable e;
        AppMethodBeat.m2504i(59028);
        Context context = C4996ah.getContext();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(C1427q.m3026LK());
        linkedHashSet.add(C1427q.getDeviceID(context));
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
                        C4990ab.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
                        C5046bo.m7527b(bufferedReader);
                        linkedHashSet.add("1234567890ABCDEF");
                        AppMethodBeat.m2505o(59028);
                        return linkedHashSet;
                    } catch (Throwable th) {
                        e = th;
                        closeable = bufferedReader;
                        C5046bo.m7527b(closeable);
                        AppMethodBeat.m2505o(59028);
                        throw e;
                    }
                }
            }
            C5046bo.m7527b(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
            C5046bo.m7527b(bufferedReader);
            linkedHashSet.add("1234567890ABCDEF");
            AppMethodBeat.m2505o(59028);
            return linkedHashSet;
        } catch (Throwable th2) {
            e = th2;
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(59028);
            throw e;
        }
        linkedHashSet.add("1234567890ABCDEF");
        AppMethodBeat.m2505o(59028);
        return linkedHashSet;
    }

    /* renamed from: a */
    private boolean m2903a(String str, long j, boolean z, String str2) {
        AppMethodBeat.m2504i(59029);
        if (this.ybk != null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(59029);
            throw assertionError;
        }
        this.isNew = !C5730e.m8628ct(str);
        Object obj = null;
        for (String str3 : C1356a.dvm()) {
            this.key = C1178g.m2591x((str3 + j).getBytes()).substring(0, 7);
            try {
                this.ybk = C6395f.m10545E(str, this.key, z);
                C1356a.m2902a(this.ybk);
                if (!C1427q.m3026LK().equals(str3)) {
                    C4990ab.m7416i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str3)));
                    C1420l.m3008Lu().set(C31128d.MIC_PTU_ZIPAI_SAPPORO, str3);
                    C7053e.pXa.mo8378a(181, 5, 1, false);
                }
                AppMethodBeat.m2505o(59029);
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
            } else if (C6395f.dvu()) {
                i = 43;
            } else {
                i = 41;
            }
            C7053e.pXa.mo8378a(181, (long) i, 1, true);
            C6395f.aqu(str);
            if (str.endsWith("EnMicroMsg.db")) {
                C6395f.aqu(C1720g.m3536RP().eJM + "dbback/EnMicroMsg.db");
            }
            try {
                this.key = C1178g.m2591x((C1427q.m3026LK() + j).getBytes()).substring(0, 7);
                this.ybk = C6395f.m10545E(str, this.key, z);
                C1356a.m2902a(this.ybk);
                this.isNew = true;
                C7053e.pXa.mo8378a(181, 6, 1, false);
                AppMethodBeat.m2505o(59029);
                return true;
            } catch (SQLiteException e2) {
                C7053e.pXa.mo8378a(181, 7, 1, false);
            }
        } else {
            if (str2 != null && str2.length() > 0) {
                this.isNew = !C5730e.m8628ct(str2);
                try {
                    this.ybk = C6395f.m10545E(str2, this.key, z);
                    C1356a.m2902a(this.ybk);
                    C7053e.pXa.mo8378a(181, 6, 1, false);
                    AppMethodBeat.m2505o(59029);
                    return true;
                } catch (SQLiteException e3) {
                    C7053e.pXa.mo8378a(181, 7, 1, false);
                }
            }
            if (this.ybk != null) {
                this.ybk.close();
                this.ybk = null;
            }
            this.key = null;
            AppMethodBeat.m2505o(59029);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2904a(HashMap<Integer, C1366d> hashMap, boolean z, boolean z2) {
        AppMethodBeat.m2504i(59030);
        if (this.ybk == null) {
            AppMethodBeat.m2505o(59030);
            return false;
        }
        int i;
        String str = "MicroMsg.DBInit";
        String str2 = "createtables checkCreateIni:%b  tables:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        C4990ab.m7411d(str, str2, objArr);
        String str3 = "";
        if (z) {
            this.ybl = this.ybk.getPath() + ".ini";
            StringBuilder stringBuilder = new StringBuilder();
            if (hashMap != null) {
                for (C1366d c1366d : hashMap.values()) {
                    if (c1366d.mo4750Af() == null) {
                        C4990ab.m7413e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", c1366d.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + c1366d.getClass().toString(), false);
                    }
                    for (String hashCode : c1366d.mo4750Af()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                }
            }
            str3 = C1178g.m2591x(stringBuilder.toString().getBytes());
            if (!z2) {
                str = C4894a.getValue(this.ybl, "createmd5");
                if (!C5046bo.isNullOrNil(str) && str3.equals(str)) {
                    C4990ab.m7417i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.ybk.getPath());
                    AppMethodBeat.m2505o(59030);
                    return true;
                }
            }
        }
        str = str3;
        this.ybk.execSQL("pragma auto_vacuum = 0 ");
        C1446a c1446a = new C1446a();
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
                for (String str4 : ((C1366d) it.next()).mo4750Af()) {
                    try {
                        this.ybk.execSQL(str4);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = ybj.matcher(str4);
                        if (matcher == null || !matcher.matches()) {
                            C4990ab.m7420w("MicroMsg.DBInit", "CreateTable failed:[" + str4 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str4 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        long Mr = c1446a.mo4908Mr();
        this.ybk.endTransaction();
        C4990ab.m7417i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(Mr), Long.valueOf(c1446a.mo4908Mr()), Integer.valueOf(i));
        if (z) {
            C4894a.m7286aB(this.ybl, "createmd5", str);
        }
        AppMethodBeat.m2505o(59030);
        return true;
    }
}
