package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> efv = new HashMap();
    private static final Map<Class<?>, Object> efw = new HashMap();
    private static final Map<Class<?>, String> xCZ = new HashMap();

    static {
        AppMethodBeat.i(52514);
        try {
            efv.put(byte[].class, new Object() {
            });
            efv.put(Short.TYPE, new Object() {
            });
            efv.put(Short.class, new Object() {
            });
            efv.put(Boolean.TYPE, new Object() {
            });
            efv.put(Boolean.class, new Object() {
            });
            efv.put(Integer.TYPE, new Object() {
            });
            efv.put(Integer.class, new Object() {
            });
            efv.put(Float.TYPE, new Object() {
            });
            efv.put(Float.class, new Object() {
            });
            efv.put(Double.TYPE, new Object() {
            });
            efv.put(Double.class, new Object() {
            });
            efv.put(Long.TYPE, new Object() {
            });
            efv.put(Long.class, new Object() {
            });
            efv.put(String.class, new Object() {
            });
            efw.put(byte[].class, new Object() {
            });
            efw.put(Short.TYPE, new Object() {
            });
            efw.put(Short.class, new Object() {
            });
            efw.put(Boolean.TYPE, new Object() {
            });
            efw.put(Boolean.class, new Object() {
            });
            efw.put(Integer.TYPE, new Object() {
            });
            efw.put(Integer.class, new Object() {
            });
            efw.put(Float.TYPE, new Object() {
            });
            efw.put(Float.class, new Object() {
            });
            efw.put(Double.TYPE, new Object() {
            });
            efw.put(Double.class, new Object() {
            });
            efw.put(Long.TYPE, new Object() {
            });
            efw.put(Long.class, new Object() {
            });
            efw.put(String.class, new Object() {
            });
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
            AppMethodBeat.o(52514);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52514);
        }
    }

    public static String aw(Class<?> cls) {
        AppMethodBeat.i(52497);
        String str = (String) xCZ.get(cls);
        AppMethodBeat.o(52497);
        return str;
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52498);
        try {
            field.set(obj, cursor.getBlob(i));
            AppMethodBeat.o(52498);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52498);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52499);
        try {
            contentValues.put(c.b(field), (byte[]) field.get(obj));
            AppMethodBeat.o(52499);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52499);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52500);
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
                AppMethodBeat.o(52500);
                return;
            }
            field.set(obj, Short.valueOf(cursor.getShort(i)));
            AppMethodBeat.o(52500);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52500);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52501);
        try {
            contentValues.put(c.b(field), Short.valueOf(field.getShort(obj)));
            AppMethodBeat.o(52501);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52501);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52502);
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
                AppMethodBeat.o(52502);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i)));
            AppMethodBeat.o(52502);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52502);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52503);
        try {
            contentValues.put(c.b(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
            AppMethodBeat.o(52503);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52503);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52504);
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
                AppMethodBeat.o(52504);
                return;
            }
            field.set(obj, Integer.valueOf(cursor.getInt(i)));
            AppMethodBeat.o(52504);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52504);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52505);
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.b(field), Integer.valueOf(field.getInt(obj)));
                AppMethodBeat.o(52505);
                return;
            }
            contentValues.put(c.b(field), (Integer) field.get(obj));
            AppMethodBeat.o(52505);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52505);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52506);
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
                AppMethodBeat.o(52506);
                return;
            }
            field.set(obj, Float.valueOf(cursor.getFloat(i)));
            AppMethodBeat.o(52506);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52506);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52507);
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.b(field), Float.valueOf(field.getFloat(obj)));
                AppMethodBeat.o(52507);
                return;
            }
            contentValues.put(c.b(field), (Float) field.get(obj));
            AppMethodBeat.o(52507);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52507);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52508);
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
                AppMethodBeat.o(52508);
                return;
            }
            field.set(obj, Double.valueOf(cursor.getDouble(i)));
            AppMethodBeat.o(52508);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52508);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52509);
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.b(field), Double.valueOf(field.getDouble(obj)));
                AppMethodBeat.o(52509);
                return;
            }
            contentValues.put(c.b(field), (Double) field.get(obj));
            AppMethodBeat.o(52509);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52509);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52510);
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
                AppMethodBeat.o(52510);
                return;
            }
            field.set(obj, Long.valueOf(cursor.getLong(i)));
            AppMethodBeat.o(52510);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52510);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52511);
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.b(field), Long.valueOf(field.getLong(obj)));
                AppMethodBeat.o(52511);
                return;
            }
            contentValues.put(c.b(field), (Long) field.get(obj));
            AppMethodBeat.o(52511);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52511);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        AppMethodBeat.i(52512);
        try {
            field.set(obj, cursor.getString(i));
            AppMethodBeat.o(52512);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52512);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        AppMethodBeat.i(52513);
        try {
            contentValues.put(c.b(field), (String) field.get(obj));
            AppMethodBeat.o(52513);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
            AppMethodBeat.o(52513);
        }
    }
}
