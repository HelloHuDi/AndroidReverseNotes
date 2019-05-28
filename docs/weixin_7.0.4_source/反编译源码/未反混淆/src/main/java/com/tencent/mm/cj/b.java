package com.tencent.mm.cj;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class b implements SharedPreferences, Editor {
    as AiE;

    public b(as asVar) {
        this.AiE = asVar;
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.i(80386);
        HashMap hashMap = new HashMap();
        String[] allKeys = this.AiE.allKeys();
        if (allKeys == null) {
            AppMethodBeat.o(80386);
        } else {
            for (Object put : allKeys) {
                hashMap.put(put, "");
            }
            AppMethodBeat.o(80386);
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(80387);
        String string = this.AiE.getString(str, str2);
        AppMethodBeat.o(80387);
        return string;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        AppMethodBeat.i(80388);
        Set stringSet = this.AiE.getStringSet(str, set);
        AppMethodBeat.o(80388);
        return stringSet;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.i(80389);
        int i2 = this.AiE.getInt(str, i);
        AppMethodBeat.o(80389);
        return i2;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.i(80390);
        long j2 = this.AiE.getLong(str, j);
        AppMethodBeat.o(80390);
        return j2;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.i(80391);
        float f2 = this.AiE.getFloat(str, f);
        AppMethodBeat.o(80391);
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(80392);
        boolean z2 = this.AiE.getBoolean(str, z);
        AppMethodBeat.o(80392);
        return z2;
    }

    public boolean contains(String str) {
        AppMethodBeat.i(80393);
        boolean contains = this.AiE.contains(str);
        AppMethodBeat.o(80393);
        return contains;
    }

    public Editor edit() {
        AppMethodBeat.i(80394);
        Editor edit = this.AiE.edit();
        AppMethodBeat.o(80394);
        return edit;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(80395);
        this.AiE.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.o(80395);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(80396);
        this.AiE.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.o(80396);
    }

    public Editor putString(String str, String str2) {
        AppMethodBeat.i(80397);
        Editor putString = this.AiE.putString(str, str2);
        AppMethodBeat.o(80397);
        return putString;
    }

    public Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.i(80398);
        Editor putStringSet = this.AiE.putStringSet(str, set);
        AppMethodBeat.o(80398);
        return putStringSet;
    }

    public Editor putInt(String str, int i) {
        AppMethodBeat.i(80399);
        Editor putInt = this.AiE.putInt(str, i);
        AppMethodBeat.o(80399);
        return putInt;
    }

    public Editor putLong(String str, long j) {
        AppMethodBeat.i(80400);
        Editor putLong = this.AiE.putLong(str, j);
        AppMethodBeat.o(80400);
        return putLong;
    }

    public Editor putFloat(String str, float f) {
        AppMethodBeat.i(80401);
        Editor putFloat = this.AiE.putFloat(str, f);
        AppMethodBeat.o(80401);
        return putFloat;
    }

    public Editor putBoolean(String str, boolean z) {
        AppMethodBeat.i(80402);
        Editor putBoolean = this.AiE.putBoolean(str, z);
        AppMethodBeat.o(80402);
        return putBoolean;
    }

    public Editor remove(String str) {
        AppMethodBeat.i(80403);
        Editor remove = this.AiE.remove(str);
        AppMethodBeat.o(80403);
        return remove;
    }

    public Editor clear() {
        AppMethodBeat.i(80404);
        Editor clear = this.AiE.clear();
        AppMethodBeat.o(80404);
        return clear;
    }

    public boolean commit() {
        AppMethodBeat.i(80405);
        boolean commit = this.AiE.commit();
        AppMethodBeat.o(80405);
        return commit;
    }

    public void apply() {
        AppMethodBeat.i(80406);
        this.AiE.apply();
        AppMethodBeat.o(80406);
    }
}
