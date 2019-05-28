package com.tencent.p177mm.sdk.p603e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.e.c */
public abstract class C4925c {
    public long xDa = -1;

    /* renamed from: com.tencent.mm.sdk.e.c$a */
    public static class C4924a {
        public String[] columns;
        public String sql;
        public Field[] xDb;
        public String xDc;
        public Map<String, String> xDd = new HashMap();

        public C4924a() {
            AppMethodBeat.m2504i(52515);
            AppMethodBeat.m2505o(52515);
        }
    }

    /* renamed from: Ag */
    public abstract C4924a mo4635Ag();

    /* renamed from: Hl */
    public abstract ContentValues mo10098Hl();

    /* renamed from: d */
    public abstract void mo8995d(Cursor cursor);

    /* renamed from: ax */
    public static C4924a m7296ax(Class<?> cls) {
        C4924a c4924a = new C4924a();
        LinkedList linkedList = new LinkedList();
        for (Field field : cls.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (!(name == null || !Modifier.isPublic(modifiers) || Modifier.isFinal(modifiers))) {
                String substring;
                if (name.startsWith("field_")) {
                    substring = name.substring(6);
                } else {
                    substring = name;
                }
                if (field.isAnnotationPresent(C4930i.class)) {
                    if (((C4930i) field.getAnnotation(C4930i.class)).dpW() == 1) {
                        c4924a.xDc = substring;
                    }
                } else if (!name.startsWith("field_")) {
                }
                if (!C5046bo.isNullOrNil(substring)) {
                    if (substring.equals("rowid")) {
                        Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                    }
                    linkedList.add(field);
                }
            }
        }
        c4924a.xDb = (Field[]) linkedList.toArray(new Field[0]);
        c4924a.columns = C4925c.m7295a(c4924a.xDb);
        c4924a.xDd = C4925c.m7298b(c4924a.xDb);
        c4924a.sql = C4925c.m7299c(c4924a.xDb);
        return c4924a;
    }

    /* renamed from: a */
    private static String[] m7295a(Field[] fieldArr) {
        String[] strArr = new String[(fieldArr.length + 1)];
        for (int i = 0; i < fieldArr.length; i++) {
            boolean z;
            strArr[i] = C4925c.m7297b(fieldArr[i]);
            String str = "getFullColumns failed:" + fieldArr[i].getName();
            if (C5046bo.isNullOrNil(strArr[i])) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(str, z);
        }
        strArr[fieldArr.length] = "rowid";
        return strArr;
    }

    /* renamed from: b */
    private static Map<String, String> m7298b(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            String aw = C4923b.m7293aw(field.getType());
            if (aw == null) {
                C4990ab.m7412e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String b = C4925c.m7297b(field);
                if (!C5046bo.isNullOrNil(b)) {
                    hashMap.put(b, aw);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private static String m7299c(Field[] fieldArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < fieldArr.length) {
            Field field = fieldArr[i];
            String aw = C4923b.m7293aw(field.getType());
            if (aw == null) {
                C4990ab.m7412e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String b = C4925c.m7297b(field);
                if (!C5046bo.isNullOrNil(b)) {
                    int dpW;
                    String str = "";
                    if (field.isAnnotationPresent(C4930i.class)) {
                        str = " default '" + ((C4930i) field.getAnnotation(C4930i.class)).dpV() + "' ";
                        dpW = ((C4930i) field.getAnnotation(C4930i.class)).dpW();
                    } else {
                        dpW = 0;
                    }
                    stringBuilder.append(b + " " + aw + str + (dpW == 1 ? " PRIMARY KEY " : ""));
                    stringBuilder.append(i == fieldArr.length + -1 ? "" : ", ");
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public static String m7297b(Field field) {
        if (field == null) {
            return null;
        }
        String name = field.getName();
        if (name == null || name.length() <= 0) {
            return null;
        }
        return name.startsWith("field_") ? name.substring(6) : name;
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0042 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0084 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0084 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0042 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0042 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0084 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m7294a(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            if (cursor == null) {
                return true;
            }
            return false;
        } else if (cursor == null || cursor.getCount() != 1) {
            return false;
        } else {
            cursor.moveToFirst();
            int columnCount = cursor.getColumnCount();
            int size = contentValues.size();
            if (contentValues.containsKey("rowid")) {
                size--;
            }
            if (cursor.getColumnIndex("rowid") != -1) {
                columnCount--;
            }
            if (size != columnCount) {
                return false;
            }
            try {
                for (Entry key : contentValues.valueSet()) {
                    String str = (String) key.getKey();
                    if (!str.equals("rowid")) {
                        columnCount = cursor.getColumnIndex(str);
                        if (columnCount == -1) {
                            return false;
                        }
                        if (contentValues.get(str) instanceof byte[]) {
                            byte[] bArr = (byte[]) contentValues.get(str);
                            byte[] blob = cursor.getBlob(columnCount);
                            if (!(bArr == null && blob == null)) {
                                if (bArr == null && blob != null) {
                                    size = 0;
                                    if (size != 0) {
                                    }
                                } else if (bArr == null || blob != null) {
                                    if (bArr.length != blob.length) {
                                        size = 0;
                                    } else {
                                        for (columnCount = 0; columnCount < bArr.length; columnCount++) {
                                            if (bArr[columnCount] != blob[columnCount]) {
                                                size = 0;
                                                break;
                                            }
                                        }
                                    }
                                    if (size != 0) {
                                        return false;
                                    }
                                } else {
                                    size = 0;
                                    if (size != 0) {
                                    }
                                }
                            }
                            size = 1;
                            if (size != 0) {
                            }
                        } else if (cursor.getString(columnCount) == null && contentValues.get(str) != null) {
                            return false;
                        } else {
                            if (contentValues.get(str) == null) {
                                return false;
                            }
                            if (!contentValues.get(str).toString().equals(cursor.getString(columnCount))) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SDK.IAutoDBItem", e, "", new Object[0]);
                return false;
            }
        }
    }
}
