package com.tencent.p177mm.sdk.p603e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.sdk.e.b */
final class C4923b {
    private static final Map<Class<?>, Object> efv = new HashMap();
    private static final Map<Class<?>, Object> efw = new HashMap();
    private static final Map<Class<?>, String> xCZ = new HashMap();

    /* renamed from: com.tencent.mm.sdk.e.b$10 */
    static class C489510 {
        C489510() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$11 */
    static class C489611 {
        C489611() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$12 */
    static class C489712 {
        C489712() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$13 */
    static class C489813 {
        C489813() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$14 */
    static class C489914 {
        C489914() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$15 */
    static class C490015 {
        C490015() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$16 */
    static class C490116 {
        C490116() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$17 */
    static class C490217 {
        C490217() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$18 */
    static class C490318 {
        C490318() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$19 */
    static class C490419 {
        C490419() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$1 */
    static class C49051 {
        C49051() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$20 */
    static class C490620 {
        C490620() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$21 */
    static class C490721 {
        C490721() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$22 */
    static class C490822 {
        C490822() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$23 */
    static class C490923 {
        C490923() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$24 */
    static class C491024 {
        C491024() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$25 */
    static class C491125 {
        C491125() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$26 */
    static class C491226 {
        C491226() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$27 */
    static class C491327 {
        C491327() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$28 */
    static class C491428 {
        C491428() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$2 */
    static class C49152 {
        C49152() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$3 */
    static class C49163 {
        C49163() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$4 */
    static class C49174 {
        C49174() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$5 */
    static class C49185 {
        C49185() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$6 */
    static class C49196 {
        C49196() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$7 */
    static class C49207 {
        C49207() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$8 */
    static class C49218 {
        C49218() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.b$9 */
    static class C49229 {
        C49229() {
        }
    }

    static {
        AppMethodBeat.m2504i(52514);
        try {
            efv.put(byte[].class, new C49051());
            efv.put(Short.TYPE, new C489712());
            efv.put(Short.class, new C490822());
            efv.put(Boolean.TYPE, new C490923());
            efv.put(Boolean.class, new C491024());
            efv.put(Integer.TYPE, new C491125());
            efv.put(Integer.class, new C491226());
            efv.put(Float.TYPE, new C491327());
            efv.put(Float.class, new C491428());
            efv.put(Double.TYPE, new C49152());
            efv.put(Double.class, new C49163());
            efv.put(Long.TYPE, new C49174());
            efv.put(Long.class, new C49185());
            efv.put(String.class, new C49196());
            efw.put(byte[].class, new C49207());
            efw.put(Short.TYPE, new C49218());
            efw.put(Short.class, new C49229());
            efw.put(Boolean.TYPE, new C489510());
            efw.put(Boolean.class, new C489611());
            efw.put(Integer.TYPE, new C489813());
            efw.put(Integer.class, new C489914());
            efw.put(Float.TYPE, new C490015());
            efw.put(Float.class, new C490116());
            efw.put(Double.TYPE, new C490217());
            efw.put(Double.class, new C490318());
            efw.put(Long.TYPE, new C490419());
            efw.put(Long.class, new C490620());
            efw.put(String.class, new C490721());
            xCZ.put(byte[].class, "BLOB");
            xCZ.put(Short.TYPE, "SHORT");
            xCZ.put(Short.class, "SHORT");
            xCZ.put(Boolean.TYPE, "INTEGER");
            xCZ.put(Boolean.class, "INTEGER");
            xCZ.put(Integer.TYPE, "INTEGER");
            xCZ.put(Integer.class, "INTEGER");
            xCZ.put(Float.TYPE, "FLOAT");
            xCZ.put(Float.class, "FLOAT");
            xCZ.put(Double.TYPE, "DOUBLE");
            xCZ.put(Double.class, "DOUBLE");
            xCZ.put(Long.TYPE, "LONG");
            xCZ.put(Long.class, "LONG");
            xCZ.put(String.class, "TEXT");
            AppMethodBeat.m2505o(52514);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52514);
        }
    }

    /* renamed from: aw */
    public static String m7293aw(Class<?> cls) {
        AppMethodBeat.m2504i(52497);
        String str = (String) xCZ.get(cls);
        AppMethodBeat.m2505o(52497);
        return str;
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52498);
        try {
            field.set(obj, cursor.getBlob(i));
            AppMethodBeat.m2505o(52498);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52498);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52499);
        try {
            contentValues.put(C4925c.m7297b(field), (byte[]) field.get(obj));
            AppMethodBeat.m2505o(52499);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52499);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52500);
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
                AppMethodBeat.m2505o(52500);
                return;
            }
            field.set(obj, Short.valueOf(cursor.getShort(i)));
            AppMethodBeat.m2505o(52500);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52500);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52501);
        try {
            contentValues.put(C4925c.m7297b(field), Short.valueOf(field.getShort(obj)));
            AppMethodBeat.m2505o(52501);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52501);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52502);
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
                AppMethodBeat.m2505o(52502);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i)));
            AppMethodBeat.m2505o(52502);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52502);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52503);
        try {
            contentValues.put(C4925c.m7297b(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
            AppMethodBeat.m2505o(52503);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52503);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52504);
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
                AppMethodBeat.m2505o(52504);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i)));
            AppMethodBeat.m2505o(52504);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52504);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52505);
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(C4925c.m7297b(field), Integer.valueOf(field.getInt(obj)));
                AppMethodBeat.m2505o(52505);
                return;
            }
            contentValues.put(C4925c.m7297b(field), (Integer) field.get(obj));
            AppMethodBeat.m2505o(52505);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52505);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52506);
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
                AppMethodBeat.m2505o(52506);
                return;
            }
            field.set(obj, Float.valueOf(cursor.getFloat(i)));
            AppMethodBeat.m2505o(52506);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52506);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52507);
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(C4925c.m7297b(field), Float.valueOf(field.getFloat(obj)));
                AppMethodBeat.m2505o(52507);
                return;
            }
            contentValues.put(C4925c.m7297b(field), (Float) field.get(obj));
            AppMethodBeat.m2505o(52507);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52507);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52508);
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
                AppMethodBeat.m2505o(52508);
                return;
            }
            field.set(obj, Double.valueOf(cursor.getDouble(i)));
            AppMethodBeat.m2505o(52508);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52508);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52509);
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(C4925c.m7297b(field), Double.valueOf(field.getDouble(obj)));
                AppMethodBeat.m2505o(52509);
                return;
            }
            contentValues.put(C4925c.m7297b(field), (Double) field.get(obj));
            AppMethodBeat.m2505o(52509);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52509);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52510);
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
                AppMethodBeat.m2505o(52510);
                return;
            }
            field.set(obj, Long.valueOf(cursor.getLong(i)));
            AppMethodBeat.m2505o(52510);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52510);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52511);
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(C4925c.m7297b(field), Long.valueOf(field.getLong(obj)));
                AppMethodBeat.m2505o(52511);
                return;
            }
            contentValues.put(C4925c.m7297b(field), (Long) field.get(obj));
            AppMethodBeat.m2505o(52511);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52511);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.m2504i(52512);
        try {
            field.set(obj, cursor.getString(i));
            AppMethodBeat.m2505o(52512);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52512);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.m2504i(52513);
        try {
            contentValues.put(C4925c.m7297b(field), (String) field.get(obj));
            AppMethodBeat.m2505o(52513);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.m2505o(52513);
        }
    }
}
