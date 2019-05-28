package com.tencent.p177mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mmkv.C5763a;
import com.tencent.mmkv.C5765c;
import com.tencent.mmkv.C5766d;
import com.tencent.mmkv.MMKV;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.plugin.report.C7053e;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.sdk.platformtools.as */
public class C5018as implements SharedPreferences, Editor {
    private static ArrayMap<String, C5018as> xAo = new ArrayMap();
    private String name;
    private MMKV xAn;

    /* renamed from: com.tencent.mm.sdk.platformtools.as$1 */
    static class C50191 implements C5763a {
        C50191() {
        }

        public final C5765c amJ(String str) {
            AppMethodBeat.m2504i(93460);
            C4990ab.m7417i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", str);
            C7053e.pXa.mo8378a(941, 3, 1, true);
            C5765c c5765c = C5765c.OnErrorDiscard;
            AppMethodBeat.m2505o(93460);
            return c5765c;
        }

        public final C5765c amK(String str) {
            AppMethodBeat.m2504i(93461);
            C4990ab.m7417i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", str);
            C7053e.pXa.mo8378a(941, 4, 1, true);
            C5765c c5765c = C5765c.OnErrorDiscard;
            AppMethodBeat.m2505o(93461);
            return c5765c;
        }

        /* renamed from: h */
        public final void mo10361h(String str, int i, String str2, String str3) {
            AppMethodBeat.m2504i(93462);
            C4990ab.m7417i("MMKV", "[%s][%d][%s] %s", str, Integer.valueOf(i), str2, str3);
            AppMethodBeat.m2505o(93462);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.as$a */
    static class C5020a extends C5018as implements SharedPreferences, Editor {
        private SharedPreferences ehZ;

        /* synthetic */ C5020a(String str, byte b) {
            this(str);
        }

        private C5020a(String str) {
            super(str, (byte) 0);
            AppMethodBeat.m2504i(93463);
            this.ehZ = C4996ah.getContext().getSharedPreferences(str, 4);
            AppMethodBeat.m2505o(93463);
        }

        public final Map<String, ?> getAll() {
            AppMethodBeat.m2504i(93464);
            Map all = this.ehZ.getAll();
            AppMethodBeat.m2505o(93464);
            return all;
        }

        public final String[] allKeys() {
            AppMethodBeat.m2504i(93465);
            String[] strArr = (String[]) this.ehZ.getAll().keySet().toArray(new String[0]);
            AppMethodBeat.m2505o(93465);
            return strArr;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.m2504i(93466);
            String string = this.ehZ.getString(str, str2);
            AppMethodBeat.m2505o(93466);
            return string;
        }

        public final Set<String> getStringSet(String str, Set<String> set) {
            AppMethodBeat.m2504i(93467);
            Set stringSet = this.ehZ.getStringSet(str, set);
            AppMethodBeat.m2505o(93467);
            return stringSet;
        }

        public final int getInt(String str, int i) {
            int i2;
            AppMethodBeat.m2504i(93468);
            try {
                i2 = this.ehZ.getInt(str, i);
            } catch (Throwable th) {
                C5018as.doZ();
                i2 = this.ehZ.getInt(str, i);
            }
            AppMethodBeat.m2505o(93468);
            return i2;
        }

        public final long getLong(String str, long j) {
            AppMethodBeat.m2504i(93469);
            long j2 = this.ehZ.getLong(str, j);
            AppMethodBeat.m2505o(93469);
            return j2;
        }

        public final float getFloat(String str, float f) {
            AppMethodBeat.m2504i(93470);
            float f2 = this.ehZ.getFloat(str, f);
            AppMethodBeat.m2505o(93470);
            return f2;
        }

        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.m2504i(93471);
            boolean z2 = this.ehZ.getBoolean(str, z);
            AppMethodBeat.m2505o(93471);
            return z2;
        }

        public final boolean contains(String str) {
            AppMethodBeat.m2504i(93472);
            boolean contains = this.ehZ.contains(str);
            AppMethodBeat.m2505o(93472);
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
            AppMethodBeat.m2504i(93473);
            Editor putString = this.ehZ.edit().putString(str, str2);
            putString.apply();
            AppMethodBeat.m2505o(93473);
            return putString;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.m2504i(93474);
            Editor putStringSet = this.ehZ.edit().putStringSet(str, set);
            putStringSet.apply();
            AppMethodBeat.m2505o(93474);
            return putStringSet;
        }

        public final Editor putInt(String str, int i) {
            AppMethodBeat.m2504i(93475);
            Editor putInt = this.ehZ.edit().putInt(str, i);
            putInt.apply();
            AppMethodBeat.m2505o(93475);
            return putInt;
        }

        public final Editor putLong(String str, long j) {
            AppMethodBeat.m2504i(93476);
            Editor putLong = this.ehZ.edit().putLong(str, j);
            putLong.apply();
            AppMethodBeat.m2505o(93476);
            return putLong;
        }

        public final Editor putFloat(String str, float f) {
            AppMethodBeat.m2504i(93477);
            Editor putFloat = this.ehZ.edit().putFloat(str, f);
            putFloat.apply();
            AppMethodBeat.m2505o(93477);
            return putFloat;
        }

        public final Editor putBoolean(String str, boolean z) {
            AppMethodBeat.m2504i(93478);
            Editor putBoolean = this.ehZ.edit().putBoolean(str, z);
            putBoolean.apply();
            AppMethodBeat.m2505o(93478);
            return putBoolean;
        }

        public final Editor remove(String str) {
            AppMethodBeat.m2504i(93479);
            Editor remove = this.ehZ.edit().remove(str);
            remove.apply();
            remove = remove.remove(str);
            AppMethodBeat.m2505o(93479);
            return remove;
        }

        public final Editor clear() {
            AppMethodBeat.m2504i(93480);
            Editor clear = this.ehZ.edit().clear();
            clear.apply();
            AppMethodBeat.m2505o(93480);
            return clear;
        }

        public final boolean commit() {
            AppMethodBeat.m2504i(93481);
            boolean commit = this.ehZ.edit().commit();
            AppMethodBeat.m2505o(93481);
            return commit;
        }

        public final void apply() {
            AppMethodBeat.m2504i(93482);
            this.ehZ.edit().apply();
            AppMethodBeat.m2505o(93482);
        }

        public final boolean encode(String str, String str2) {
            AppMethodBeat.m2504i(93483);
            this.ehZ.edit().putString(str, str2).apply();
            AppMethodBeat.m2505o(93483);
            return true;
        }

        public final boolean encode(String str, int i) {
            AppMethodBeat.m2504i(93484);
            this.ehZ.edit().putInt(str, i).apply();
            AppMethodBeat.m2505o(93484);
            return true;
        }

        public final boolean encode(String str, long j) {
            AppMethodBeat.m2504i(93485);
            this.ehZ.edit().putLong(str, j).apply();
            AppMethodBeat.m2505o(93485);
            return true;
        }

        public final boolean encode(String str, boolean z) {
            AppMethodBeat.m2504i(93486);
            this.ehZ.edit().putBoolean(str, z).apply();
            AppMethodBeat.m2505o(93486);
            return true;
        }

        public final boolean encode(String str, byte[] bArr) {
            AppMethodBeat.m2504i(93487);
            this.ehZ.edit().putString(str, Base64.encodeToString(bArr, 0)).apply();
            AppMethodBeat.m2505o(93487);
            return true;
        }

        public final int importFromSharedPreferences(SharedPreferences sharedPreferences) {
            AppMethodBeat.m2504i(93488);
            int size = sharedPreferences.getAll().size();
            AppMethodBeat.m2505o(93488);
            return size;
        }

        public final String amH(String str) {
            AppMethodBeat.m2504i(93489);
            String string = this.ehZ.getString(str, null);
            AppMethodBeat.m2505o(93489);
            return string;
        }

        public final int decodeInt(String str, int i) {
            AppMethodBeat.m2504i(93490);
            int i2 = this.ehZ.getInt(str, i);
            AppMethodBeat.m2505o(93490);
            return i2;
        }

        public final long amI(String str) {
            AppMethodBeat.m2504i(93491);
            long j = this.ehZ.getLong(str, 0);
            AppMethodBeat.m2505o(93491);
            return j;
        }

        public final boolean decodeBool(String str, boolean z) {
            AppMethodBeat.m2504i(93492);
            boolean z2 = this.ehZ.getBoolean(str, z);
            AppMethodBeat.m2505o(93492);
            return z2;
        }

        public final byte[] decodeBytes(String str) {
            AppMethodBeat.m2504i(93493);
            try {
                byte[] decode = Base64.decode(this.ehZ.getString(str, ""), 0);
                AppMethodBeat.m2505o(93493);
                return decode;
            } catch (Exception e) {
                AppMethodBeat.m2505o(93493);
                return null;
            }
        }

        public final boolean containsKey(String str) {
            AppMethodBeat.m2504i(93494);
            boolean contains = this.ehZ.contains(str);
            AppMethodBeat.m2505o(93494);
            return contains;
        }

        public final void removeValueForKey(String str) {
            AppMethodBeat.m2504i(93495);
            this.ehZ.edit().remove(str).apply();
            AppMethodBeat.m2505o(93495);
        }
    }

    static {
        AppMethodBeat.m2504i(93541);
        C1449k.m3079a("mmkv", MMKV.class.getClassLoader());
        MMKV.initialize(C4996ah.getContext());
        MMKV.registerHandler(new C50191());
        AppMethodBeat.m2505o(93541);
    }

    /* renamed from: a */
    public static int m7464a(SharedPreferences sharedPreferences, C5018as c5018as) {
        AppMethodBeat.m2504i(93496);
        if (sharedPreferences == null || c5018as == null) {
            AppMethodBeat.m2505o(93496);
            return 0;
        }
        String str = c5018as.name;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(93496);
            return 0;
        }
        boolean decodeBool;
        C5018as eh = C5018as.m7466eh("MULTIPROCESSMMKV_PERSERVED_NAME", 2);
        C4990ab.m7417i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", str);
        try {
            decodeBool = eh.decodeBool(str, false);
        } catch (Throwable th) {
            C5018as.doZ();
            decodeBool = eh.decodeBool(str, false);
        }
        if (decodeBool) {
            C4990ab.m7416i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
            AppMethodBeat.m2505o(93496);
            return 0;
        }
        eh.encode(str, true);
        C7053e.pXa.mo8378a(941, 2, 1, true);
        int importFromSharedPreferences = c5018as.importFromSharedPreferences(sharedPreferences);
        AppMethodBeat.m2505o(93496);
        return importFromSharedPreferences;
    }

    private C5018as(String str, MMKV mmkv) {
        this.xAn = mmkv;
        this.name = str;
    }

    private C5018as(String str) {
        this.name = str;
    }

    public static C5018as amF(String str) {
        AppMethodBeat.m2504i(93497);
        C5018as eg = C5018as.m7465eg(str, 2);
        AppMethodBeat.m2505o(93497);
        return eg;
    }

    /* renamed from: eg */
    public static C5018as m7465eg(String str, int i) {
        AppMethodBeat.m2504i(93498);
        C5018as eh;
        if (C5018as.isSupported()) {
            if (C5046bo.isNullOrNil(str) || C5046bo.isEqual(str, "MULTIPROCESSMMKV_PERSERVED_NAME")) {
                C4990ab.m7416i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
                AppMethodBeat.m2505o(93498);
                return null;
            }
            eh = C5018as.m7466eh(str, i);
            AppMethodBeat.m2505o(93498);
            return eh;
        } else if (C5046bo.isNullOrNil(str) || C5046bo.isEqual(str, "MULTIPROCESSMMKV_PERSERVED_NAME")) {
            C4990ab.m7416i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
            AppMethodBeat.m2505o(93498);
            return null;
        } else {
            C5020a c5020a = new C5020a(str, (byte) 0);
            eh = C5018as.m7466eh(str, i);
            C5018as.m7464a(c5020a, eh);
            AppMethodBeat.m2505o(93498);
            return eh;
        }
    }

    /* renamed from: eh */
    private static C5018as m7466eh(String str, int i) {
        C5018as c5018as;
        AppMethodBeat.m2504i(93499);
        synchronized (C5018as.class) {
            try {
                c5018as = (C5018as) xAo.get(str);
                if (c5018as == null) {
                    c5018as = new C5018as(str, MMKV.mmkvWithID(str, i));
                    xAo.put(str, c5018as);
                } else {
                    AppMethodBeat.m2505o(93499);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93499);
            }
        }
        return c5018as;
    }

    public final int getValueActualSize(String str) {
        AppMethodBeat.m2504i(93501);
        int valueActualSize = this.xAn.getValueActualSize(str);
        AppMethodBeat.m2505o(93501);
        return valueActualSize;
    }

    public boolean encode(String str, String str2) {
        AppMethodBeat.m2504i(93502);
        if (m7467s(str, str2)) {
            boolean encode = this.xAn.encode(str, str2);
            AppMethodBeat.m2505o(93502);
            return encode;
        }
        AppMethodBeat.m2505o(93502);
        return false;
    }

    public boolean encode(String str, int i) {
        AppMethodBeat.m2504i(93503);
        if (m7467s(str, Integer.valueOf(i))) {
            boolean encode = this.xAn.encode(str, i);
            AppMethodBeat.m2505o(93503);
            return encode;
        }
        AppMethodBeat.m2505o(93503);
        return false;
    }

    public boolean encode(String str, long j) {
        AppMethodBeat.m2504i(93504);
        if (m7467s(str, Long.valueOf(j))) {
            boolean encode = this.xAn.encode(str, j);
            AppMethodBeat.m2505o(93504);
            return encode;
        }
        AppMethodBeat.m2505o(93504);
        return false;
    }

    public boolean encode(String str, boolean z) {
        AppMethodBeat.m2504i(93505);
        if (m7467s(str, Boolean.valueOf(z))) {
            boolean encode;
            try {
                encode = this.xAn.encode(str, z);
            } catch (Throwable th) {
                C5018as.doZ();
                encode = this.xAn.encode(str, z);
            }
            AppMethodBeat.m2505o(93505);
            return encode;
        }
        AppMethodBeat.m2505o(93505);
        return false;
    }

    public boolean encode(String str, byte[] bArr) {
        AppMethodBeat.m2504i(93506);
        if (m7467s(str, bArr)) {
            boolean encode = this.xAn.encode(str, bArr);
            AppMethodBeat.m2505o(93506);
            return encode;
        }
        AppMethodBeat.m2505o(93506);
        return false;
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        int importFromSharedPreferences;
        AppMethodBeat.m2504i(93507);
        try {
            importFromSharedPreferences = this.xAn.importFromSharedPreferences(sharedPreferences);
        } catch (Throwable th) {
            C5018as.doZ();
            importFromSharedPreferences = this.xAn.importFromSharedPreferences(sharedPreferences);
        }
        AppMethodBeat.m2505o(93507);
        return importFromSharedPreferences;
    }

    public static C5766d createNativeBuffer(int i) {
        AppMethodBeat.m2504i(93508);
        C5766d createNativeBuffer = MMKV.createNativeBuffer(i);
        AppMethodBeat.m2505o(93508);
        return createNativeBuffer;
    }

    public static void destroyNativeBuffer(C5766d c5766d) {
        AppMethodBeat.m2504i(93509);
        MMKV.destroyNativeBuffer(c5766d);
        AppMethodBeat.m2505o(93509);
    }

    public final int writeValueToNativeBuffer(String str, C5766d c5766d) {
        AppMethodBeat.m2504i(93510);
        int writeValueToNativeBuffer = this.xAn.writeValueToNativeBuffer(str, c5766d);
        AppMethodBeat.m2505o(93510);
        return writeValueToNativeBuffer;
    }

    public String amH(String str) {
        AppMethodBeat.m2504i(93511);
        String decodeString = this.xAn.decodeString(str, null);
        AppMethodBeat.m2505o(93511);
        return decodeString;
    }

    public int decodeInt(String str, int i) {
        AppMethodBeat.m2504i(93512);
        int decodeInt = this.xAn.decodeInt(str, i);
        AppMethodBeat.m2505o(93512);
        return decodeInt;
    }

    public long amI(String str) {
        AppMethodBeat.m2504i(93513);
        long decodeLong = this.xAn.decodeLong(str, 0);
        AppMethodBeat.m2505o(93513);
        return decodeLong;
    }

    public boolean decodeBool(String str, boolean z) {
        AppMethodBeat.m2504i(93514);
        boolean decodeBool = this.xAn.decodeBool(str, z);
        AppMethodBeat.m2505o(93514);
        return decodeBool;
    }

    public byte[] decodeBytes(String str) {
        AppMethodBeat.m2504i(93515);
        byte[] decodeBytes = this.xAn.decodeBytes(str);
        AppMethodBeat.m2505o(93515);
        return decodeBytes;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.m2504i(93516);
        boolean containsKey = this.xAn.containsKey(str);
        AppMethodBeat.m2505o(93516);
        return containsKey;
    }

    public void removeValueForKey(String str) {
        AppMethodBeat.m2504i(93517);
        this.xAn.removeValueForKey(str);
        AppMethodBeat.m2505o(93517);
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.m2504i(93518);
        Map all = this.xAn.getAll();
        AppMethodBeat.m2505o(93518);
        return all;
    }

    public String[] allKeys() {
        String[] allKeys;
        AppMethodBeat.m2504i(93519);
        try {
            allKeys = this.xAn.allKeys();
        } catch (Throwable th) {
            C5018as.doZ();
            allKeys = this.xAn.allKeys();
        }
        AppMethodBeat.m2505o(93519);
        return allKeys;
    }

    public String getString(String str, String str2) {
        String string;
        AppMethodBeat.m2504i(93520);
        try {
            string = this.xAn.getString(str, str2);
        } catch (Throwable th) {
            C5018as.doZ();
            string = this.xAn.getString(str, str2);
        }
        AppMethodBeat.m2505o(93520);
        return string;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet;
        AppMethodBeat.m2504i(93521);
        try {
            stringSet = this.xAn.getStringSet(str, set);
        } catch (Throwable th) {
            C5018as.doZ();
            stringSet = this.xAn.getStringSet(str, set);
        }
        AppMethodBeat.m2505o(93521);
        return stringSet;
    }

    public int getInt(String str, int i) {
        int i2;
        AppMethodBeat.m2504i(93522);
        try {
            i2 = this.xAn.getInt(str, i);
        } catch (Throwable th) {
            C5018as.doZ();
            i2 = this.xAn.getInt(str, i);
        }
        AppMethodBeat.m2505o(93522);
        return i2;
    }

    public long getLong(String str, long j) {
        long j2;
        AppMethodBeat.m2504i(93523);
        try {
            j2 = this.xAn.getLong(str, j);
        } catch (Throwable th) {
            C5018as.doZ();
            j2 = this.xAn.getLong(str, j);
        }
        AppMethodBeat.m2505o(93523);
        return j2;
    }

    public float getFloat(String str, float f) {
        float f2;
        AppMethodBeat.m2504i(93524);
        try {
            f2 = this.xAn.getFloat(str, f);
        } catch (Throwable th) {
            C5018as.doZ();
            f2 = this.xAn.getFloat(str, f);
        }
        AppMethodBeat.m2505o(93524);
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(93525);
        try {
            z2 = this.xAn.getBoolean(str, z);
        } catch (Throwable th) {
            C5018as.doZ();
            z2 = this.xAn.getBoolean(str, z);
        }
        AppMethodBeat.m2505o(93525);
        return z2;
    }

    public boolean contains(String str) {
        boolean contains;
        AppMethodBeat.m2504i(93526);
        try {
            contains = this.xAn.contains(str);
        } catch (Throwable th) {
            C5018as.doZ();
            contains = this.xAn.contains(str);
        }
        AppMethodBeat.m2505o(93526);
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
        AppMethodBeat.m2504i(93527);
        Editor putString;
        if (m7467s(str, str2)) {
            try {
                putString = this.xAn.putString(str, str2);
            } catch (Throwable th) {
                C5018as.doZ();
                putString = this.xAn.putString(str, str2);
            }
            AppMethodBeat.m2505o(93527);
            return putString;
        }
        putString = edit();
        AppMethodBeat.m2505o(93527);
        return putString;
    }

    public Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(93528);
        Editor putStringSet;
        if (m7467s(str, set)) {
            try {
                putStringSet = this.xAn.putStringSet(str, set);
            } catch (Throwable th) {
                C5018as.doZ();
                putStringSet = this.xAn.putStringSet(str, set);
            }
            AppMethodBeat.m2505o(93528);
            return putStringSet;
        }
        putStringSet = edit();
        AppMethodBeat.m2505o(93528);
        return putStringSet;
    }

    public Editor putInt(String str, int i) {
        AppMethodBeat.m2504i(93529);
        Editor putInt;
        if (m7467s(str, Integer.valueOf(i))) {
            try {
                putInt = this.xAn.putInt(str, i);
            } catch (Throwable th) {
                C5018as.doZ();
                putInt = this.xAn.putInt(str, i);
            }
            AppMethodBeat.m2505o(93529);
            return putInt;
        }
        putInt = edit();
        AppMethodBeat.m2505o(93529);
        return putInt;
    }

    public Editor putLong(String str, long j) {
        AppMethodBeat.m2504i(93530);
        Editor putLong;
        if (m7467s(str, Long.valueOf(j))) {
            try {
                putLong = this.xAn.putLong(str, j);
            } catch (Throwable th) {
                C5018as.doZ();
                putLong = this.xAn.putLong(str, j);
            }
            AppMethodBeat.m2505o(93530);
            return putLong;
        }
        putLong = edit();
        AppMethodBeat.m2505o(93530);
        return putLong;
    }

    public Editor putFloat(String str, float f) {
        AppMethodBeat.m2504i(93531);
        Editor putFloat;
        if (m7467s(str, Float.valueOf(f))) {
            try {
                putFloat = this.xAn.putFloat(str, f);
            } catch (Throwable th) {
                C5018as.doZ();
                putFloat = this.xAn.putFloat(str, f);
            }
            AppMethodBeat.m2505o(93531);
            return putFloat;
        }
        putFloat = edit();
        AppMethodBeat.m2505o(93531);
        return putFloat;
    }

    public Editor putBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(93532);
        Editor putBoolean;
        if (m7467s(str, Boolean.valueOf(z))) {
            try {
                putBoolean = this.xAn.putBoolean(str, z);
            } catch (Throwable th) {
                C5018as.doZ();
                putBoolean = this.xAn.putBoolean(str, z);
            }
            AppMethodBeat.m2505o(93532);
            return putBoolean;
        }
        putBoolean = edit();
        AppMethodBeat.m2505o(93532);
        return putBoolean;
    }

    public Editor remove(String str) {
        Editor remove;
        AppMethodBeat.m2504i(93533);
        try {
            remove = this.xAn.remove(str);
        } catch (Throwable th) {
            C5018as.doZ();
            remove = this.xAn.remove(str);
        }
        remove = remove.remove(str);
        AppMethodBeat.m2505o(93533);
        return remove;
    }

    public Editor clear() {
        Editor clear;
        AppMethodBeat.m2504i(93534);
        try {
            clear = this.xAn.clear();
        } catch (Throwable th) {
            C5018as.doZ();
            clear = this.xAn.clear();
        }
        AppMethodBeat.m2505o(93534);
        return clear;
    }

    public boolean commit() {
        boolean commit;
        AppMethodBeat.m2504i(93535);
        try {
            commit = this.xAn.commit();
        } catch (Throwable th) {
            C5018as.doZ();
            commit = this.xAn.commit();
        }
        AppMethodBeat.m2505o(93535);
        return commit;
    }

    public void apply() {
        AppMethodBeat.m2504i(93536);
        this.xAn.apply();
        AppMethodBeat.m2505o(93536);
    }

    /* renamed from: s */
    private boolean m7467s(String str, Object obj) {
        AppMethodBeat.m2504i(93537);
        if (C5046bo.isNullOrNil(str) || obj == null || C5046bo.isNullOrNil(this.name)) {
            AppMethodBeat.m2505o(93537);
            return false;
        }
        AppMethodBeat.m2505o(93537);
        return true;
    }

    static void doZ() {
        AppMethodBeat.m2504i(93538);
        C1449k.m3079a("mmkv", MMKV.class.getClassLoader());
        AppMethodBeat.m2505o(93538);
    }

    private static boolean dpa() {
        AppMethodBeat.m2504i(93539);
        String str = Build.MODEL;
        if (str == null) {
            AppMethodBeat.m2505o(93539);
            return false;
        } else if (C5046bo.isEqual(str, "vivo Y66i") || C5046bo.isEqual(str, "vivo Y66i A")) {
            AppMethodBeat.m2505o(93539);
            return true;
        } else {
            AppMethodBeat.m2505o(93539);
            return false;
        }
    }

    private static boolean isSupported() {
        AppMethodBeat.m2504i(93540);
        if (C5018as.dpa()) {
            AppMethodBeat.m2505o(93540);
            return false;
        }
        AppMethodBeat.m2505o(93540);
        return true;
    }

    public static C5018as amG(String str) {
        AppMethodBeat.m2504i(93500);
        C5018as eg = C5018as.m7465eg(str, 2);
        C5018as.m7464a(C4996ah.getContext().getSharedPreferences(str, 4), eg);
        AppMethodBeat.m2505o(93500);
        return eg;
    }
}
