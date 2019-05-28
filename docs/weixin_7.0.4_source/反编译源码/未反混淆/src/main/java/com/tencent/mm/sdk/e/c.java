package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class c {
    public long xDa = -1;

    public static class a {
        public String[] columns;
        public String sql;
        public Field[] xDb;
        public String xDc;
        public Map<String, String> xDd = new HashMap();

        public a() {
            AppMethodBeat.i(52515);
            AppMethodBeat.o(52515);
        }
    }

    public abstract a Ag();

    public abstract ContentValues Hl();

    public abstract void d(Cursor cursor);

    public static a ax(Class<?> cls) {
        a aVar = new a();
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
                if (field.isAnnotationPresent(i.class)) {
                    if (((i) field.getAnnotation(i.class)).dpW() == 1) {
                        aVar.xDc = substring;
                    }
                } else if (!name.startsWith("field_")) {
                }
                if (!bo.isNullOrNil(substring)) {
                    if (substring.equals("rowid")) {
                        Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                    }
                    linkedList.add(field);
                }
            }
        }
        aVar.xDb = (Field[]) linkedList.toArray(new Field[0]);
        aVar.columns = a(aVar.xDb);
        aVar.xDd = b(aVar.xDb);
        aVar.sql = c(aVar.xDb);
        return aVar;
    }

    private static String[] a(Field[] fieldArr) {
        String[] strArr = new String[(fieldArr.length + 1)];
        for (int i = 0; i < fieldArr.length; i++) {
            boolean z;
            strArr[i] = b(fieldArr[i]);
            String str = "getFullColumns failed:" + fieldArr[i].getName();
            if (bo.isNullOrNil(strArr[i])) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(str, z);
        }
        strArr[fieldArr.length] = "rowid";
        return strArr;
    }

    private static Map<String, String> b(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            String aw = b.aw(field.getType());
            if (aw == null) {
                ab.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String b = b(field);
                if (!bo.isNullOrNil(b)) {
                    hashMap.put(b, aw);
                }
            }
        }
        return hashMap;
    }

    private static String c(Field[] fieldArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < fieldArr.length) {
            Field field = fieldArr[i];
            String aw = b.aw(field.getType());
            if (aw == null) {
                ab.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String b = b(field);
                if (!bo.isNullOrNil(b)) {
                    int dpW;
                    String str = "";
                    if (field.isAnnotationPresent(i.class)) {
                        str = " default '" + ((i) field.getAnnotation(i.class)).dpV() + "' ";
                        dpW = ((i) field.getAnnotation(i.class)).dpW();
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

    public static String b(Field field) {
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
    public static boolean a(ContentValues contentValues, Cursor cursor) {
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
                ab.printErrStackTrace("MicroMsg.SDK.IAutoDBItem", e, "", new Object[0]);
                return false;
            }
        }
    }
}
