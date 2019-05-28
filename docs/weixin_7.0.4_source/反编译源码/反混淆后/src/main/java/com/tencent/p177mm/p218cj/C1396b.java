package com.tencent.p177mm.p218cj;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.cj.b */
public class C1396b implements SharedPreferences, Editor {
    C5018as AiE;

    public C1396b(C5018as c5018as) {
        this.AiE = c5018as;
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.m2504i(80386);
        HashMap hashMap = new HashMap();
        String[] allKeys = this.AiE.allKeys();
        if (allKeys == null) {
            AppMethodBeat.m2505o(80386);
        } else {
            for (Object put : allKeys) {
                hashMap.put(put, "");
            }
            AppMethodBeat.m2505o(80386);
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.m2504i(80387);
        String string = this.AiE.getString(str, str2);
        AppMethodBeat.m2505o(80387);
        return string;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(80388);
        Set stringSet = this.AiE.getStringSet(str, set);
        AppMethodBeat.m2505o(80388);
        return stringSet;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.m2504i(80389);
        int i2 = this.AiE.getInt(str, i);
        AppMethodBeat.m2505o(80389);
        return i2;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.m2504i(80390);
        long j2 = this.AiE.getLong(str, j);
        AppMethodBeat.m2505o(80390);
        return j2;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.m2504i(80391);
        float f2 = this.AiE.getFloat(str, f);
        AppMethodBeat.m2505o(80391);
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(80392);
        boolean z2 = this.AiE.getBoolean(str, z);
        AppMethodBeat.m2505o(80392);
        return z2;
    }

    public boolean contains(String str) {
        AppMethodBeat.m2504i(80393);
        boolean contains = this.AiE.contains(str);
        AppMethodBeat.m2505o(80393);
        return contains;
    }

    public Editor edit() {
        AppMethodBeat.m2504i(80394);
        Editor edit = this.AiE.edit();
        AppMethodBeat.m2505o(80394);
        return edit;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(80395);
        this.AiE.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.m2505o(80395);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(80396);
        this.AiE.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        AppMethodBeat.m2505o(80396);
    }

    public Editor putString(String str, String str2) {
        AppMethodBeat.m2504i(80397);
        Editor putString = this.AiE.putString(str, str2);
        AppMethodBeat.m2505o(80397);
        return putString;
    }

    public Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(80398);
        Editor putStringSet = this.AiE.putStringSet(str, set);
        AppMethodBeat.m2505o(80398);
        return putStringSet;
    }

    public Editor putInt(String str, int i) {
        AppMethodBeat.m2504i(80399);
        Editor putInt = this.AiE.putInt(str, i);
        AppMethodBeat.m2505o(80399);
        return putInt;
    }

    public Editor putLong(String str, long j) {
        AppMethodBeat.m2504i(80400);
        Editor putLong = this.AiE.putLong(str, j);
        AppMethodBeat.m2505o(80400);
        return putLong;
    }

    public Editor putFloat(String str, float f) {
        AppMethodBeat.m2504i(80401);
        Editor putFloat = this.AiE.putFloat(str, f);
        AppMethodBeat.m2505o(80401);
        return putFloat;
    }

    public Editor putBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(80402);
        Editor putBoolean = this.AiE.putBoolean(str, z);
        AppMethodBeat.m2505o(80402);
        return putBoolean;
    }

    public Editor remove(String str) {
        AppMethodBeat.m2504i(80403);
        Editor remove = this.AiE.remove(str);
        AppMethodBeat.m2505o(80403);
        return remove;
    }

    public Editor clear() {
        AppMethodBeat.m2504i(80404);
        Editor clear = this.AiE.clear();
        AppMethodBeat.m2505o(80404);
        return clear;
    }

    public boolean commit() {
        AppMethodBeat.m2504i(80405);
        boolean commit = this.AiE.commit();
        AppMethodBeat.m2505o(80405);
        return commit;
    }

    public void apply() {
        AppMethodBeat.m2504i(80406);
        this.AiE.apply();
        AppMethodBeat.m2505o(80406);
    }
}
