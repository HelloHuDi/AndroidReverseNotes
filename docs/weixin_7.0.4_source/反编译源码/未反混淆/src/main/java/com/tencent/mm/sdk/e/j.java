package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class j<T extends c> extends k implements d<T> {
    private final e bSd;
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private final String table;
    protected final a xDe;

    public j(e eVar, a aVar, String str, String[] strArr) {
        String str2;
        int i = 0;
        this.bSd = eVar;
        this.xDe = aVar;
        a aVar2 = this.xDe;
        if (bo.isNullOrNil(this.xDe.xDc)) {
            str2 = "rowid";
        } else {
            str2 = this.xDe.xDc;
        }
        aVar2.xDc = str2;
        this.table = str;
        List a = a(this.xDe, getTableName(), this.bSd);
        for (int i2 = 0; i2 < a.size(); i2++) {
            if (!this.bSd.hY(this.table, (String) a.get(i2))) {
                ab.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.table, a.get(i2));
            }
        }
        if (strArr != null && strArr.length > 0) {
            while (i < strArr.length) {
                this.bSd.hY(this.table, strArr[i]);
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

    public static String a(a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        stringBuilder.append(aVar.sql);
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public static List<String> a(a aVar, String str, e eVar) {
        ArrayList arrayList = new ArrayList();
        if (eVar == null || str == null) {
            boolean z;
            String str2 = "MicroMsg.SDK.MAutoStorage";
            String str3 = "dk getUpdateSQLs db==null :%b  table:%s";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            ab.e(str2, str3, objArr);
            return arrayList;
        }
        Cursor a = eVar.a("PRAGMA table_info( " + str + " )", new String[0], 2);
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
        for (Entry entry : aVar.xDd.entrySet()) {
            String str4 = (String) entry.getValue();
            String str5 = (String) entry.getKey();
            if (str4 != null && str4.length() > 0) {
                String str6 = (String) hashMap.get(str5);
                if (str6 == null) {
                    arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str5 + " " + str4 + ";");
                    hashMap.remove(str5);
                } else if (!str4.toLowerCase().startsWith(str6.toLowerCase())) {
                    ab.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str5 + ", " + str6 + "<o-n>" + str4);
                    hashMap.remove(str5);
                }
            }
        }
        return arrayList;
    }

    public final boolean hY(String str, String str2) {
        if (str.length() == 0) {
            anH("null or nill table");
            return false;
        } else if (str2 != null && str2.length() != 0) {
            return this.bSd.hY(str, str2);
        } else {
            anH("null or nill sql");
            return false;
        }
    }

    public boolean b(T t) {
        return a((c) t, true);
    }

    public boolean a(T t, boolean z) {
        ContentValues Hl = t.Hl();
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

    public boolean a(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues Hl = t.Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("delete failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("delete with primary key");
            if (this.bSd.delete(getTableName(), this.xDe.xDc + " = ?", new String[]{bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(Hl, strArr);
            if (a == null) {
                anH("delete failed, check keys failed");
                return false;
            } else if (this.bSd.delete(getTableName(), a.toString(), a(strArr, Hl)) <= 0 || !z) {
                anH("delete failed");
                return false;
            } else {
                anF(this.xDe.xDc);
                return true;
            }
        }
    }

    public boolean a(T t, String... strArr) {
        return a((c) t, true, strArr);
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

    public final boolean b(long j, T t) {
        Cursor a = this.bSd.a(getTableName(), this.xDe.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            t.d(a);
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public boolean b(T t, String... strArr) {
        ContentValues Hl = t.Hl();
        Cursor a;
        if (Hl == null || Hl.size() <= 0) {
            anH("get failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("get with primary key");
            a = this.bSd.a(getTableName(), this.xDe.columns, this.xDe.xDc + " = ?", new String[]{bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}, null, null, null, 2);
            if (a.moveToFirst()) {
                t.d(a);
                a.close();
                return true;
            }
            a.close();
            return false;
        } else {
            StringBuilder a2 = a(Hl, strArr);
            if (a2 == null) {
                anH("get failed, check keys failed");
                return false;
            }
            a = this.bSd.a(getTableName(), this.xDe.columns, a2.toString(), a(strArr, Hl), null, null, null, 2);
            if (a.moveToFirst()) {
                t.d(a);
                a.close();
                return true;
            }
            a.close();
            anG("get failed, not found");
            return false;
        }
    }

    public final boolean a(long j, T t, boolean z) {
        ContentValues Hl = t.Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.bSd.query(getTableName(), this.xDe.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (c.a(Hl, query)) {
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

    public boolean a(long j, T t) {
        return a(j, (c) t, true);
    }

    public boolean b(T t, boolean z, String... strArr) {
        boolean z2 = false;
        ContentValues Hl = t.Hl();
        if (Hl == null || Hl.size() <= 0) {
            anH("update failed, value.size <= 0");
            return false;
        } else if (strArr == null || strArr.length <= 0) {
            anG("update with primary key");
            if (b(Hl)) {
                anG("no need replace , fields no change");
                return true;
            }
            if (this.bSd.update(getTableName(), Hl, this.xDe.xDc + " = ?", new String[]{bo.nullAsNil(Hl.getAsString(this.xDe.xDc))}) > 0) {
                z2 = true;
            }
            if (!z2 || !z) {
                return z2;
            }
            doNotify();
            return z2;
        } else {
            StringBuilder a = a(Hl, strArr);
            if (a == null) {
                anH("update failed, check keys failed");
                return false;
            } else if (this.bSd.update(getTableName(), Hl, a.toString(), a(strArr, Hl)) > 0) {
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

    public boolean c(T t, String... strArr) {
        return b(t, true, strArr);
    }

    public boolean a(T t) {
        Assert.assertTrue("replace primaryKey == null", !bo.isNullOrNil(this.xDe.xDc));
        ContentValues Hl = t.Hl();
        if (Hl != null) {
            int i;
            int size = Hl.size();
            int length = t.Ag().xDb.length;
            if (Hl.containsKey("rowid")) {
                i = 1;
            } else {
                i = 0;
            }
            if (size == i + length) {
                if (b(Hl)) {
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

    private boolean b(ContentValues contentValues) {
        Cursor query = this.bSd.query(getTableName(), this.xDe.columns, this.xDe.xDc + " = ?", new String[]{bo.nullAsNil(contentValues.getAsString(this.xDe.xDc))}, null, null, null);
        boolean a = c.a(contentValues, query);
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

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
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

    private static String[] a(String[] strArr, ContentValues contentValues) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr2.length; i++) {
            strArr2[i] = bo.nullAsNil(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void anG(String str) {
        ab.d("MicroMsg.SDK.MAutoStorage", getTableName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
    }

    private void anH(String str) {
        ab.e("MicroMsg.SDK.MAutoStorage", getTableName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
    }
}
