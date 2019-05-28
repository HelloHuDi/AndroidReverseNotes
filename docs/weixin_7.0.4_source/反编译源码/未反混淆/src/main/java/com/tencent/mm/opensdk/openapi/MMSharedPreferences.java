package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.a;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns = new String[]{"_id", "key", "type", "value"};
    private final ContentResolver cr;
    private REditor editor = null;
    private final HashMap<String, Object> values = new HashMap();

    static class REditor implements Editor {
        private boolean clear = false;
        private ContentResolver cr;
        private Set<String> remove = new HashSet();
        private Map<String, Object> values = new HashMap();

        public REditor(ContentResolver contentResolver) {
            AppMethodBeat.i(128094);
            this.cr = contentResolver;
            AppMethodBeat.o(128094);
        }

        public void apply() {
        }

        public Editor clear() {
            this.clear = true;
            return this;
        }

        public boolean commit() {
            AppMethodBeat.i(128101);
            ContentValues contentValues = new ContentValues();
            if (this.clear) {
                this.cr.delete(b.CONTENT_URI, null, null);
                this.clear = false;
            }
            for (String str : this.remove) {
                this.cr.delete(b.CONTENT_URI, "key = ?", new String[]{str});
            }
            for (Entry value : this.values.entrySet()) {
                int i;
                boolean z;
                Object value2 = value.getValue();
                if (value2 == null) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                    i = 0;
                } else if (value2 instanceof Integer) {
                    i = 1;
                } else if (value2 instanceof Long) {
                    i = 2;
                } else if (value2 instanceof String) {
                    i = 3;
                } else if (value2 instanceof Boolean) {
                    i = 4;
                } else if (value2 instanceof Float) {
                    i = 5;
                } else if (value2 instanceof Double) {
                    i = 6;
                } else {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value2.getClass().toString());
                    i = 0;
                }
                if (i == 0) {
                    z = false;
                } else {
                    contentValues.put("type", Integer.valueOf(i));
                    contentValues.put("value", value2.toString());
                    z = true;
                }
                if (z) {
                    this.cr.update(b.CONTENT_URI, contentValues, "key = ?", new String[]{(String) value.getKey()});
                }
            }
            AppMethodBeat.o(128101);
            return true;
        }

        public Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(128099);
            this.values.put(str, Boolean.valueOf(z));
            this.remove.remove(str);
            AppMethodBeat.o(128099);
            return this;
        }

        public Editor putFloat(String str, float f) {
            AppMethodBeat.i(128098);
            this.values.put(str, Float.valueOf(f));
            this.remove.remove(str);
            AppMethodBeat.o(128098);
            return this;
        }

        public Editor putInt(String str, int i) {
            AppMethodBeat.i(128096);
            this.values.put(str, Integer.valueOf(i));
            this.remove.remove(str);
            AppMethodBeat.o(128096);
            return this;
        }

        public Editor putLong(String str, long j) {
            AppMethodBeat.i(128097);
            this.values.put(str, Long.valueOf(j));
            this.remove.remove(str);
            AppMethodBeat.o(128097);
            return this;
        }

        public Editor putString(String str, String str2) {
            AppMethodBeat.i(128095);
            this.values.put(str, str2);
            this.remove.remove(str);
            AppMethodBeat.o(128095);
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public Editor remove(String str) {
            AppMethodBeat.i(128100);
            this.remove.add(str);
            AppMethodBeat.o(128100);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        AppMethodBeat.i(128080);
        this.cr = context.getContentResolver();
        AppMethodBeat.o(128080);
    }

    private Object getValue(String str) {
        AppMethodBeat.i(128081);
        try {
            Cursor query = this.cr.query(b.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.o(128081);
                return null;
            }
            Object a = query.moveToFirst() ? a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            AppMethodBeat.o(128081);
            return a;
        } catch (Exception e) {
            Log.e(TAG, "getValue exception:" + e.getMessage());
            AppMethodBeat.o(128081);
            return null;
        }
    }

    public boolean contains(String str) {
        AppMethodBeat.i(128088);
        if (getValue(str) != null) {
            AppMethodBeat.o(128088);
            return true;
        }
        AppMethodBeat.o(128088);
        return false;
    }

    public Editor edit() {
        AppMethodBeat.i(128089);
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        REditor rEditor = this.editor;
        AppMethodBeat.o(128089);
        return rEditor;
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.i(128082);
        HashMap hashMap;
        try {
            Cursor query = this.cr.query(b.CONTENT_URI, this.columns, null, null, null);
            if (query == null) {
                AppMethodBeat.o(128082);
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            hashMap = this.values;
            AppMethodBeat.o(128082);
            return hashMap;
        } catch (Exception e) {
            Log.e(TAG, "getAll exception:" + e.getMessage());
            hashMap = this.values;
            AppMethodBeat.o(128082);
            return hashMap;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(128087);
        Object value = getValue(str);
        if (value == null || !(value instanceof Boolean)) {
            AppMethodBeat.o(128087);
            return z;
        }
        z = ((Boolean) value).booleanValue();
        AppMethodBeat.o(128087);
        return z;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.i(128086);
        Object value = getValue(str);
        if (value == null || !(value instanceof Float)) {
            AppMethodBeat.o(128086);
            return f;
        }
        f = ((Float) value).floatValue();
        AppMethodBeat.o(128086);
        return f;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.i(128084);
        Object value = getValue(str);
        if (value == null || !(value instanceof Integer)) {
            AppMethodBeat.o(128084);
            return i;
        }
        i = ((Integer) value).intValue();
        AppMethodBeat.o(128084);
        return i;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.i(128085);
        Object value = getValue(str);
        if (value == null || !(value instanceof Long)) {
            AppMethodBeat.o(128085);
            return j;
        }
        j = ((Long) value).longValue();
        AppMethodBeat.o(128085);
        return j;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(128083);
        Object value = getValue(str);
        if (value == null || !(value instanceof String)) {
            AppMethodBeat.o(128083);
            return str2;
        }
        String str3 = (String) value;
        AppMethodBeat.o(128083);
        return str3;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
