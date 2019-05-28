package com.tencent.mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;
import java.util.Map;
import java.util.Set;

public class as implements SharedPreferences, Editor {
    private static ArrayMap<String, as> xAo = new ArrayMap();
    private String name;
    private MMKV xAn;

    static class a extends as implements SharedPreferences, Editor {
        private SharedPreferences ehZ;

        /* synthetic */ a(String str, byte b) {
            this(str);
        }

        private a(String str) {
            super(str, (byte) 0);
            AppMethodBeat.i(93463);
            this.ehZ = ah.getContext().getSharedPreferences(str, 4);
            AppMethodBeat.o(93463);
        }

        public final Map<String, ?> getAll() {
            AppMethodBeat.i(93464);
            Map all = this.ehZ.getAll();
            AppMethodBeat.o(93464);
            return all;
        }

        public final String[] allKeys() {
            AppMethodBeat.i(93465);
            String[] strArr = (String[]) this.ehZ.getAll().keySet().toArray(new String[0]);
            AppMethodBeat.o(93465);
            return strArr;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.i(93466);
            String string = this.ehZ.getString(str, str2);
            AppMethodBeat.o(93466);
            return string;
        }

        public final Set<String> getStringSet(String str, Set<String> set) {
            AppMethodBeat.i(93467);
            Set stringSet = this.ehZ.getStringSet(str, set);
            AppMethodBeat.o(93467);
            return stringSet;
        }

        public final int getInt(String str, int i) {
            int i2;
            AppMethodBeat.i(93468);
            try {
                i2 = this.ehZ.getInt(str, i);
            } catch (Throwable th) {
                as.doZ();
                i2 = this.ehZ.getInt(str, i);
            }
            AppMethodBeat.o(93468);
            return i2;
        }

        public final long getLong(String str, long j) {
            AppMethodBeat.i(93469);
            long j2 = this.ehZ.getLong(str, j);
            AppMethodBeat.o(93469);
            return j2;
        }

        public final float getFloat(String str, float f) {
            AppMethodBeat.i(93470);
            float f2 = this.ehZ.getFloat(str, f);
            AppMethodBeat.o(93470);
            return f2;
        }

        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.i(93471);
            boolean z2 = this.ehZ.getBoolean(str, z);
            AppMethodBeat.o(93471);
            return z2;
        }

        public final boolean contains(String str) {
            AppMethodBeat.i(93472);
            boolean contains = this.ehZ.contains(str);
            AppMethodBeat.o(93472);
            return contains;
        }

        public final Editor edit() {
            return this;
        }

        public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        }

        public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        }

        public final Editor putString(String str, String str2) {
            AppMethodBeat.i(93473);
            Editor putString = this.ehZ.edit().putString(str, str2);
            putString.apply();
            AppMethodBeat.o(93473);
            return putString;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.i(93474);
            Editor putStringSet = this.ehZ.edit().putStringSet(str, set);
            putStringSet.apply();
            AppMethodBeat.o(93474);
            return putStringSet;
        }

        public final Editor putInt(String str, int i) {
            AppMethodBeat.i(93475);
            Editor putInt = this.ehZ.edit().putInt(str, i);
            putInt.apply();
            AppMethodBeat.o(93475);
            return putInt;
        }

        public final Editor putLong(String str, long j) {
            AppMethodBeat.i(93476);
            Editor putLong = this.ehZ.edit().putLong(str, j);
            putLong.apply();
            AppMethodBeat.o(93476);
            return putLong;
        }

        public final Editor putFloat(String str, float f) {
            AppMethodBeat.i(93477);
            Editor putFloat = this.ehZ.edit().putFloat(str, f);
            putFloat.apply();
            AppMethodBeat.o(93477);
            return putFloat;
        }

        public final Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(93478);
            Editor putBoolean = this.ehZ.edit().putBoolean(str, z);
            putBoolean.apply();
            AppMethodBeat.o(93478);
            return putBoolean;
        }

        public final Editor remove(String str) {
            AppMethodBeat.i(93479);
            Editor remove = this.ehZ.edit().remove(str);
            remove.apply();
            remove = remove.remove(str);
            AppMethodBeat.o(93479);
            return remove;
        }

        public final Editor clear() {
            AppMethodBeat.i(93480);
            Editor clear = this.ehZ.edit().clear();
            clear.apply();
            AppMethodBeat.o(93480);
            return clear;
        }

        public final boolean commit() {
            AppMethodBeat.i(93481);
            boolean commit = this.ehZ.edit().commit();
            AppMethodBeat.o(93481);
            return commit;
        }

        public final void apply() {
            AppMethodBeat.i(93482);
            this.ehZ.edit().apply();
            AppMethodBeat.o(93482);
        }

        public final boolean encode(String str, String str2) {
            AppMethodBeat.i(93483);
            this.ehZ.edit().putString(str, str2).apply();
            AppMethodBeat.o(93483);
            return true;
        }

        public final boolean encode(String str, int i) {
            AppMethodBeat.i(93484);
            this.ehZ.edit().putInt(str, i).apply();
            AppMethodBeat.o(93484);
            return true;
        }

        public final boolean encode(String str, long j) {
            AppMethodBeat.i(93485);
            this.ehZ.edit().putLong(str, j).apply();
            AppMethodBeat.o(93485);
            return true;
        }

        public final boolean encode(String str, boolean z) {
            AppMethodBeat.i(93486);
            this.ehZ.edit().putBoolean(str, z).apply();
            AppMethodBeat.o(93486);
            return true;
        }

        public final boolean encode(String str, byte[] bArr) {
            AppMethodBeat.i(93487);
            this.ehZ.edit().putString(str, Base64.encodeToString(bArr, 0)).apply();
            AppMethodBeat.o(93487);
            return true;
        }

        public final int importFromSharedPreferences(SharedPreferences sharedPreferences) {
            AppMethodBeat.i(93488);
            int size = sharedPreferences.getAll().size();
            AppMethodBeat.o(93488);
            return size;
        }

        public final String amH(String str) {
            AppMethodBeat.i(93489);
            String string = this.ehZ.getString(str, null);
            AppMethodBeat.o(93489);
            return string;
        }

        public final int decodeInt(String str, int i) {
            AppMethodBeat.i(93490);
            int i2 = this.ehZ.getInt(str, i);
            AppMethodBeat.o(93490);
            return i2;
        }

        public final long amI(String str) {
            AppMethodBeat.i(93491);
            long j = this.ehZ.getLong(str, 0);
            AppMethodBeat.o(93491);
            return j;
        }

        public final boolean decodeBool(String str, boolean z) {
            AppMethodBeat.i(93492);
            boolean z2 = this.ehZ.getBoolean(str, z);
            AppMethodBeat.o(93492);
            return z2;
        }

        public final byte[] decodeBytes(String str) {
            AppMethodBeat.i(93493);
            try {
                byte[] decode = Base64.decode(this.ehZ.getString(str, ""), 0);
                AppMethodBeat.o(93493);
                return decode;
            } catch (Exception e) {
                AppMethodBeat.o(93493);
                return null;
            }
        }

        public final boolean containsKey(String str) {
            AppMethodBeat.i(93494);
            boolean contains = this.ehZ.contains(str);
            AppMethodBeat.o(93494);
            return contains;
        }

        public final void removeValueForKey(String str) {
            AppMethodBeat.i(93495);
            this.ehZ.edit().remove(str).apply();
            AppMethodBeat.o(93495);
        }
    }

    static {
        AppMethodBeat.i(93541);
        k.a("mmkv", MMKV.class.getClassLoader());
        MMKV.initialize(ah.getContext());
        MMKV.registerHandler(new com.tencent.mmkv.a() {
            public final c amJ(String str) {
                AppMethodBeat.i(93460);
                ab.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", str);
                e.pXa.a(941, 3, 1, true);
                c cVar = c.OnErrorDiscard;
                AppMethodBeat.o(93460);
                return cVar;
            }

            public final c amK(String str) {
                AppMethodBeat.i(93461);
                ab.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", str);
                e.pXa.a(941, 4, 1, true);
                c cVar = c.OnErrorDiscard;
                AppMethodBeat.o(93461);
                return cVar;
            }

            public final void h(String str, int i, String str2, String str3) {
                AppMethodBeat.i(93462);
                ab.i("MMKV", "[%s][%d][%s] %s", str, Integer.valueOf(i), str2, str3);
                AppMethodBeat.o(93462);
            }
        });
        AppMethodBeat.o(93541);
    }

    public static int a(SharedPreferences sharedPreferences, as asVar) {
        AppMethodBeat.i(93496);
        if (sharedPreferences == null || asVar == null) {
            AppMethodBeat.o(93496);
            return 0;
        }
        String str = asVar.name;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(93496);
            return 0;
        }
        boolean decodeBool;
        as eh = eh("MULTIPROCESSMMKV_PERSERVED_NAME", 2);
        ab.i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", str);
        try {
            decodeBool = eh.decodeBool(str, false);
        } catch (Throwable th) {
            doZ();
            decodeBool = eh.decodeBool(str, false);
        }
        if (decodeBool) {
            ab.i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
            AppMethodBeat.o(93496);
            return 0;
        }
        eh.encode(str, true);
        e.pXa.a(941, 2, 1, true);
        int importFromSharedPreferences = asVar.importFromSharedPreferences(sharedPreferences);
        AppMethodBeat.o(93496);
        return importFromSharedPreferences;
    }

    private as(String str, MMKV mmkv) {
        this.xAn = mmkv;
        this.name = str;
    }

    private as(String str) {
        this.name = str;
    }

    public static as amF(String str) {
        AppMethodBeat.i(93497);
        as eg = eg(str, 2);
        AppMethodBeat.o(93497);
        return eg;
    }

    public static as eg(String str, int i) {
        AppMethodBeat.i(93498);
        as eh;
        if (isSupported()) {
            if (bo.isNullOrNil(str) || bo.isEqual(str, "MULTIPROCESSMMKV_PERSERVED_NAME")) {
                ab.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
                AppMethodBeat.o(93498);
                return null;
            }
            eh = eh(str, i);
            AppMethodBeat.o(93498);
            return eh;
        } else if (bo.isNullOrNil(str) || bo.isEqual(str, "MULTIPROCESSMMKV_PERSERVED_NAME")) {
            ab.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
            AppMethodBeat.o(93498);
            return null;
        } else {
            a aVar = new a(str, (byte) 0);
            eh = eh(str, i);
            a(aVar, eh);
            AppMethodBeat.o(93498);
            return eh;
        }
    }

    private static as eh(String str, int i) {
        as asVar;
        AppMethodBeat.i(93499);
        synchronized (as.class) {
            try {
                asVar = (as) xAo.get(str);
                if (asVar == null) {
                    asVar = new as(str, MMKV.mmkvWithID(str, i));
                    xAo.put(str, asVar);
                } else {
                    AppMethodBeat.o(93499);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93499);
            }
        }
        return asVar;
    }

    public final int getValueActualSize(String str) {
        AppMethodBeat.i(93501);
        int valueActualSize = this.xAn.getValueActualSize(str);
        AppMethodBeat.o(93501);
        return valueActualSize;
    }

    public boolean encode(String str, String str2) {
        AppMethodBeat.i(93502);
        if (s(str, str2)) {
            boolean encode = this.xAn.encode(str, str2);
            AppMethodBeat.o(93502);
            return encode;
        }
        AppMethodBeat.o(93502);
        return false;
    }

    public boolean encode(String str, int i) {
        AppMethodBeat.i(93503);
        if (s(str, Integer.valueOf(i))) {
            boolean encode = this.xAn.encode(str, i);
            AppMethodBeat.o(93503);
            return encode;
        }
        AppMethodBeat.o(93503);
        return false;
    }

    public boolean encode(String str, long j) {
        AppMethodBeat.i(93504);
        if (s(str, Long.valueOf(j))) {
            boolean encode = this.xAn.encode(str, j);
            AppMethodBeat.o(93504);
            return encode;
        }
        AppMethodBeat.o(93504);
        return false;
    }

    public boolean encode(String str, boolean z) {
        AppMethodBeat.i(93505);
        if (s(str, Boolean.valueOf(z))) {
            boolean encode;
            try {
                encode = this.xAn.encode(str, z);
            } catch (Throwable th) {
                doZ();
                encode = this.xAn.encode(str, z);
            }
            AppMethodBeat.o(93505);
            return encode;
        }
        AppMethodBeat.o(93505);
        return false;
    }

    public boolean encode(String str, byte[] bArr) {
        AppMethodBeat.i(93506);
        if (s(str, bArr)) {
            boolean encode = this.xAn.encode(str, bArr);
            AppMethodBeat.o(93506);
            return encode;
        }
        AppMethodBeat.o(93506);
        return false;
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        int importFromSharedPreferences;
        AppMethodBeat.i(93507);
        try {
            importFromSharedPreferences = this.xAn.importFromSharedPreferences(sharedPreferences);
        } catch (Throwable th) {
            doZ();
            importFromSharedPreferences = this.xAn.importFromSharedPreferences(sharedPreferences);
        }
        AppMethodBeat.o(93507);
        return importFromSharedPreferences;
    }

    public static d createNativeBuffer(int i) {
        AppMethodBeat.i(93508);
        d createNativeBuffer = MMKV.createNativeBuffer(i);
        AppMethodBeat.o(93508);
        return createNativeBuffer;
    }

    public static void destroyNativeBuffer(d dVar) {
        AppMethodBeat.i(93509);
        MMKV.destroyNativeBuffer(dVar);
        AppMethodBeat.o(93509);
    }

    public final int writeValueToNativeBuffer(String str, d dVar) {
        AppMethodBeat.i(93510);
        int writeValueToNativeBuffer = this.xAn.writeValueToNativeBuffer(str, dVar);
        AppMethodBeat.o(93510);
        return writeValueToNativeBuffer;
    }

    public String amH(String str) {
        AppMethodBeat.i(93511);
        String decodeString = this.xAn.decodeString(str, null);
        AppMethodBeat.o(93511);
        return decodeString;
    }

    public int decodeInt(String str, int i) {
        AppMethodBeat.i(93512);
        int decodeInt = this.xAn.decodeInt(str, i);
        AppMethodBeat.o(93512);
        return decodeInt;
    }

    public long amI(String str) {
        AppMethodBeat.i(93513);
        long decodeLong = this.xAn.decodeLong(str, 0);
        AppMethodBeat.o(93513);
        return decodeLong;
    }

    public boolean decodeBool(String str, boolean z) {
        AppMethodBeat.i(93514);
        boolean decodeBool = this.xAn.decodeBool(str, z);
        AppMethodBeat.o(93514);
        return decodeBool;
    }

    public byte[] decodeBytes(String str) {
        AppMethodBeat.i(93515);
        byte[] decodeBytes = this.xAn.decodeBytes(str);
        AppMethodBeat.o(93515);
        return decodeBytes;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(93516);
        boolean containsKey = this.xAn.containsKey(str);
        AppMethodBeat.o(93516);
        return containsKey;
    }

    public void removeValueForKey(String str) {
        AppMethodBeat.i(93517);
        this.xAn.removeValueForKey(str);
        AppMethodBeat.o(93517);
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.i(93518);
        Map all = this.xAn.getAll();
        AppMethodBeat.o(93518);
        return all;
    }

    public String[] allKeys() {
        String[] allKeys;
        AppMethodBeat.i(93519);
        try {
            allKeys = this.xAn.allKeys();
        } catch (Throwable th) {
            doZ();
            allKeys = this.xAn.allKeys();
        }
        AppMethodBeat.o(93519);
        return allKeys;
    }

    public String getString(String str, String str2) {
        String string;
        AppMethodBeat.i(93520);
        try {
            string = this.xAn.getString(str, str2);
        } catch (Throwable th) {
            doZ();
            string = this.xAn.getString(str, str2);
        }
        AppMethodBeat.o(93520);
        return string;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet;
        AppMethodBeat.i(93521);
        try {
            stringSet = this.xAn.getStringSet(str, set);
        } catch (Throwable th) {
            doZ();
            stringSet = this.xAn.getStringSet(str, set);
        }
        AppMethodBeat.o(93521);
        return stringSet;
    }

    public int getInt(String str, int i) {
        int i2;
        AppMethodBeat.i(93522);
        try {
            i2 = this.xAn.getInt(str, i);
        } catch (Throwable th) {
            doZ();
            i2 = this.xAn.getInt(str, i);
        }
        AppMethodBeat.o(93522);
        return i2;
    }

    public long getLong(String str, long j) {
        long j2;
        AppMethodBeat.i(93523);
        try {
            j2 = this.xAn.getLong(str, j);
        } catch (Throwable th) {
            doZ();
            j2 = this.xAn.getLong(str, j);
        }
        AppMethodBeat.o(93523);
        return j2;
    }

    public float getFloat(String str, float f) {
        float f2;
        AppMethodBeat.i(93524);
        try {
            f2 = this.xAn.getFloat(str, f);
        } catch (Throwable th) {
            doZ();
            f2 = this.xAn.getFloat(str, f);
        }
        AppMethodBeat.o(93524);
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(93525);
        try {
            z2 = this.xAn.getBoolean(str, z);
        } catch (Throwable th) {
            doZ();
            z2 = this.xAn.getBoolean(str, z);
        }
        AppMethodBeat.o(93525);
        return z2;
    }

    public boolean contains(String str) {
        boolean contains;
        AppMethodBeat.i(93526);
        try {
            contains = this.xAn.contains(str);
        } catch (Throwable th) {
            doZ();
            contains = this.xAn.contains(str);
        }
        AppMethodBeat.o(93526);
        return contains;
    }

    public Editor edit() {
        return this;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public Editor putString(String str, String str2) {
        AppMethodBeat.i(93527);
        Editor putString;
        if (s(str, str2)) {
            try {
                putString = this.xAn.putString(str, str2);
            } catch (Throwable th) {
                doZ();
                putString = this.xAn.putString(str, str2);
            }
            AppMethodBeat.o(93527);
            return putString;
        }
        putString = edit();
        AppMethodBeat.o(93527);
        return putString;
    }

    public Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.i(93528);
        Editor putStringSet;
        if (s(str, set)) {
            try {
                putStringSet = this.xAn.putStringSet(str, set);
            } catch (Throwable th) {
                doZ();
                putStringSet = this.xAn.putStringSet(str, set);
            }
            AppMethodBeat.o(93528);
            return putStringSet;
        }
        putStringSet = edit();
        AppMethodBeat.o(93528);
        return putStringSet;
    }

    public Editor putInt(String str, int i) {
        AppMethodBeat.i(93529);
        Editor putInt;
        if (s(str, Integer.valueOf(i))) {
            try {
                putInt = this.xAn.putInt(str, i);
            } catch (Throwable th) {
                doZ();
                putInt = this.xAn.putInt(str, i);
            }
            AppMethodBeat.o(93529);
            return putInt;
        }
        putInt = edit();
        AppMethodBeat.o(93529);
        return putInt;
    }

    public Editor putLong(String str, long j) {
        AppMethodBeat.i(93530);
        Editor putLong;
        if (s(str, Long.valueOf(j))) {
            try {
                putLong = this.xAn.putLong(str, j);
            } catch (Throwable th) {
                doZ();
                putLong = this.xAn.putLong(str, j);
            }
            AppMethodBeat.o(93530);
            return putLong;
        }
        putLong = edit();
        AppMethodBeat.o(93530);
        return putLong;
    }

    public Editor putFloat(String str, float f) {
        AppMethodBeat.i(93531);
        Editor putFloat;
        if (s(str, Float.valueOf(f))) {
            try {
                putFloat = this.xAn.putFloat(str, f);
            } catch (Throwable th) {
                doZ();
                putFloat = this.xAn.putFloat(str, f);
            }
            AppMethodBeat.o(93531);
            return putFloat;
        }
        putFloat = edit();
        AppMethodBeat.o(93531);
        return putFloat;
    }

    public Editor putBoolean(String str, boolean z) {
        AppMethodBeat.i(93532);
        Editor putBoolean;
        if (s(str, Boolean.valueOf(z))) {
            try {
                putBoolean = this.xAn.putBoolean(str, z);
            } catch (Throwable th) {
                doZ();
                putBoolean = this.xAn.putBoolean(str, z);
            }
            AppMethodBeat.o(93532);
            return putBoolean;
        }
        putBoolean = edit();
        AppMethodBeat.o(93532);
        return putBoolean;
    }

    public Editor remove(String str) {
        Editor remove;
        AppMethodBeat.i(93533);
        try {
            remove = this.xAn.remove(str);
        } catch (Throwable th) {
            doZ();
            remove = this.xAn.remove(str);
        }
        remove = remove.remove(str);
        AppMethodBeat.o(93533);
        return remove;
    }

    public Editor clear() {
        Editor clear;
        AppMethodBeat.i(93534);
        try {
            clear = this.xAn.clear();
        } catch (Throwable th) {
            doZ();
            clear = this.xAn.clear();
        }
        AppMethodBeat.o(93534);
        return clear;
    }

    public boolean commit() {
        boolean commit;
        AppMethodBeat.i(93535);
        try {
            commit = this.xAn.commit();
        } catch (Throwable th) {
            doZ();
            commit = this.xAn.commit();
        }
        AppMethodBeat.o(93535);
        return commit;
    }

    public void apply() {
        AppMethodBeat.i(93536);
        this.xAn.apply();
        AppMethodBeat.o(93536);
    }

    private boolean s(String str, Object obj) {
        AppMethodBeat.i(93537);
        if (bo.isNullOrNil(str) || obj == null || bo.isNullOrNil(this.name)) {
            AppMethodBeat.o(93537);
            return false;
        }
        AppMethodBeat.o(93537);
        return true;
    }

    static void doZ() {
        AppMethodBeat.i(93538);
        k.a("mmkv", MMKV.class.getClassLoader());
        AppMethodBeat.o(93538);
    }

    private static boolean dpa() {
        AppMethodBeat.i(93539);
        String str = Build.MODEL;
        if (str == null) {
            AppMethodBeat.o(93539);
            return false;
        } else if (bo.isEqual(str, "vivo Y66i") || bo.isEqual(str, "vivo Y66i A")) {
            AppMethodBeat.o(93539);
            return true;
        } else {
            AppMethodBeat.o(93539);
            return false;
        }
    }

    private static boolean isSupported() {
        AppMethodBeat.i(93540);
        if (dpa()) {
            AppMethodBeat.o(93540);
            return false;
        }
        AppMethodBeat.o(93540);
        return true;
    }

    public static as amG(String str) {
        AppMethodBeat.i(93500);
        as eg = eg(str, 2);
        a(ah.getContext().getSharedPreferences(str, 4), eg);
        AppMethodBeat.o(93500);
        return eg;
    }
}
