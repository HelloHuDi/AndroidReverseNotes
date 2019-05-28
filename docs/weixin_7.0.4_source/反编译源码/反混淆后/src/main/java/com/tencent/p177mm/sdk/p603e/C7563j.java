package com.tencent.p177mm.sdk.p603e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.e.j */
public abstract class C7563j<T extends C4925c> extends C7296k implements C4926d<T> {
    private final C4927e bSd;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final String table;
    protected final C4924a xDe;

    public C7563j(C4927e c4927e, C4924a c4924a, String str, String[] strArr) {
        String str2;
        int i = 0;
        this.bSd = c4927e;
        this.xDe = c4924a;
        C4924a c4924a2 = this.xDe;
        if (C5046bo.isNullOrNil(this.xDe.xDc)) {
            str2 = "rowid";
        } else {
            str2 = this.xDe.xDc;
        }
        c4924a2.xDc = str2;
        this.table = str;
        List a = C7563j.m13219a(this.xDe, getTableName(), this.bSd);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (!this.bSd.mo10108hY(this.table, (String) a.get(i2))) {
                C4990ab.m7417i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.table, a.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.bSd.mo10108hY(this.table, strArr[i]);
                i++;
            }
        }
    }

    public String getTableName() {
        return this.table;
    }

    public final String dpX() {
        return this.xDe.xDc;
    }

    /* renamed from: a */
    public static String m13217a(C4924a c4924a, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(c4924a.sql);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static List<String> m13219a(C4924a c4924a, String str, C4927e c4927e) {
        ArrayList arrayList = new ArrayList();
        if (c4927e == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (c4927e == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            C4990ab.m7413e(str2, str3, objArr);
            return arrayList;
        }
        Cursor a = c4927e.mo10104a("PRAGMA table_info( " + str + " )", new String[0], 2);
        if (a == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int columnIndex = a.getColumnIndex("name");
        int columnIndex2 = a.getColumnIndex("type");
        while (a.moveToNext()) {
            hashMap.put(a.getString(columnIndex), a.getString(columnIndex2));
        }
        a.close();
        for (Entry entry : c4924a.xDd.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    C4990ab.m7412e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: hY */
    public final boolean mo16768hY(String str, String str2) {
        if (str.length() == 0) {
            anH("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.bSd.mo10108hY(str, str2);
        } else {
            anH("null or nill sql");
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo10101b(T t) {
        return mo16759a((C4925c) t, true);
    }

    /* renamed from: a */
    public boolean mo16759a(T t, boolean z) {
        ContentValues Hl = t.mo10098Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("insert failed, value.size <= 0");
            return false;
        }
        t.xDa = this.bSd.insert(getTableName(), this.xDe.xDc, Hl);
        if (t.xDa <= 0) {
            anH("insert failed");
            return false;
        }
        Hl.put("rowid", Long.valueOf(t.xDa));
        if (z) {
            anF(Hl.getAsString(this.xDe.xDc));
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo10100a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues Hl = t.mo10098Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("delete with primary key");
            if (this.bSd.delete(getTableName(), this.xDe.xDc + " = ?", new String[]{C5046bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = C7563j.m13218a(Hl, strArr);
            if (a == null) {
                anH("delete failed, check keys failed");
                return false;
            } else if (this.bSd.delete(getTableName(), a.toString(), C7563j.m13220a(strArr, Hl)) <= 0 || !z) {
                anH("delete failed");
                return false;
            } else {
                anF(this.xDe.xDc);
                return true;
            }
        }
    }

    /* renamed from: a */
    public boolean mo16760a(T t, String... strArr) {
        return mo10100a((C4925c) t, true, strArr);
    }

    public boolean delete(long j) {
        boolean z = true;
        if (this.bSd.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        }
        return z;
    }

    /* renamed from: b */
    public final boolean mo16761b(long j, T t) {
        Cursor a = this.bSd.mo10105a(getTableName(), this.xDe.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.mo8995d(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    /* renamed from: b */
    public boolean mo10102b(T t, String... strArr) {
        ContentValues Hl = t.mo10098Hl();
        Cursor a;
        if (Hl == null || Hl.size() <= 0) {
            anH("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("get with primary key");
            a = this.bSd.mo10105a(getTableName(), this.xDe.columns, this.xDe.xDc + " = ?", new String[]{C5046bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}, null, null, null, 2);
            if (a.moveToFirst()) {
                t.mo8995d(a);
                a.close();
                return true;
            }
            a.close();
            return false;
        } else {
            StringBuilder a2 = C7563j.m13218a(Hl, strArr);
            if (a2 == null) {
                anH("get failed, check keys failed");
                return false;
            }
            a = this.bSd.mo10105a(getTableName(), this.xDe.columns, a2.toString(), C7563j.m13220a(strArr, Hl), null, null, null, 2);
            if (a.moveToFirst()) {
                t.mo8995d(a);
                a.close();
                return true;
            }
            a.close();
            anG("get failed, not found");
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo16758a(long j, T t, boolean z) {
        ContentValues Hl = t.mo10098Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.bSd.query(getTableName(), this.xDe.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (C4925c.m7294a(Hl, query)) {
            query.close();
            anG("no need replace , fields no change");
            return true;
        }
        boolean z2;
        query.close();
        if (this.bSd.update(getTableName(), Hl, "rowid = ?", new String[]{String.valueOf(j)}) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !z) {
            return z2;
        }
        doNotify();
        return z2;
    }

    /* renamed from: a */
    public boolean mo16757a(long j, T t) {
        return mo16758a(j, (C4925c) t, true);
    }

    /* renamed from: b */
    public boolean mo16762b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues Hl = t.mo10098Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("update with primary key");
            if (m13221b(Hl)) {
                anG("no need replace , fields no change");
                return true;
            }
            if (this.bSd.update(getTableName(), Hl, this.xDe.xDc + " = ?", new String[]{C5046bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = C7563j.m13218a(Hl, strArr);
            if (a == null) {
                anH("update failed, check keys failed");
                return false;
            } else if (this.bSd.update(getTableName(), Hl, a.toString(), C7563j.m13220a(strArr, Hl)) > 0) {
                if (z) {
                    anF(Hl.getAsString(this.xDe.xDc));
                }
                return true;
            } else {
                anH("update failed");
                return false;
            }
        }
    }

    /* renamed from: c */
    public boolean mo10103c(T t, String... strArr) {
        return mo16762b(t, true, strArr);
    }

    /* renamed from: a */
    public boolean mo10099a(T t) {
        Assert.assertTrue("replace primaryKey == null", !C5046bo.isNullOrNil(this.xDe.xDc));
        ContentValues Hl = t.mo10098Hl();
        if (Hl != null) {
            int i;
            int size = Hl.size();
            int length = t.mo4635Ag().xDb.length;
            if (Hl.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (m13221b(Hl)) {
                    anG("no need replace , fields no change");
                    return true;
                } else if (this.bSd.replace(getTableName(), this.xDe.xDc, Hl) > 0) {
                    anF(this.xDe.xDc);
                    return true;
                } else {
                    anH("replace failed");
                    return false;
                }
            }
        }
        anH("replace failed, cv.size() != item.fields().length");
        return false;
    }

    /* renamed from: b */
    private boolean m13221b(ContentValues contentValues) {
        Cursor query = this.bSd.query(getTableName(), this.xDe.columns, this.xDe.xDc + " = ?", new String[]{C5046bo.nullAsNil(contentValues.getAsString(this.xDe.xDc))}, null, null, null);
        boolean a = C4925c.m7294a(contentValues, query);
        query.close();
        return a;
    }

    public Cursor baR() {
        return this.bSd.query(getTableName(), this.xDe.columns, null, null, null, null, null);
    }

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final Cursor rawQuery(String str, String... strArr) {
        return this.bSd.rawQuery(str, strArr);
    }

    /* renamed from: a */
    private static StringBuilder m13218a(ContentValues contentValues, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            stringBuilder.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        stringBuilder.append(" 1=1");
        return stringBuilder;
    }

    /* renamed from: a */
    private static String[] m13220a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = C5046bo.nullAsNil(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void anG(String str) {
        C4990ab.m7410d("MicroMsg.SDK.MAutoStorage", getTableName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
    }

    private void anH(String str) {
        C4990ab.m7412e("MicroMsg.SDK.MAutoStorage", getTableName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
    }
}
