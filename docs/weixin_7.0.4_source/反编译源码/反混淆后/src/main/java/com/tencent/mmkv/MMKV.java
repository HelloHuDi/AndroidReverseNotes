package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MMKV implements SharedPreferences, Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static C5763a gCallbackHandler;
    private static boolean gWantLogReDirecting = false;
    private static C5764b[] index2LogLevel = new C5764b[]{C5764b.LevelDebug, C5764b.LevelInfo, C5764b.LevelWarning, C5764b.LevelError, C5764b.LevelNone};
    private static EnumMap<C5764b, Integer> logLevel2Index;
    private static final HashMap<String, Creator<?>> mCreators = new HashMap();
    private static EnumMap<C5765c, Integer> recoverIndex;
    private static String rootDir = null;
    private long nativeHandle;

    /* renamed from: com.tencent.mmkv.MMKV$a */
    public interface C5761a {
    }

    private native boolean containsKey(long j, String str);

    private native long count(long j);

    private static native long createNB(int i);

    private native boolean decodeBool(long j, String str, boolean z);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d);

    private native float decodeFloat(long j, String str, float f);

    private native int decodeInt(long j, String str, int i);

    private native long decodeLong(long j, String str, long j2);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    private static native void destroyNB(long j, int i);

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBytes(long j, String str, byte[] bArr);

    private native boolean encodeDouble(long j, String str, double d);

    private native boolean encodeFloat(long j, String str, float f);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    private static native long getDefaultMMKV(int i, String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i2, String str2);

    private static native long getMMKVWithID(String str, int i, String str2, String str3);

    private static native long getMMKVWithIDAndSize(String str, int i, int i2, String str2);

    public static native boolean isFileValid(String str);

    private static native void jniInitialize(String str);

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long j, String str);

    private static native void setLogLevel(int i);

    private static native void setLogReDirecting(boolean z);

    private native long totalSize(long j);

    private native int valueSize(long j, String str, boolean z);

    private native int writeValueToNB(long j, String str, long j2, int i);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkReSetCryptKey(String str);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String str);

    public native void removeValuesForKeys(String[] strArr);

    public native void sync();

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    static {
        AppMethodBeat.m2504i(124036);
        EnumMap enumMap = new EnumMap(C5765c.class);
        recoverIndex = enumMap;
        enumMap.put(C5765c.OnErrorDiscard, Integer.valueOf(0));
        recoverIndex.put(C5765c.OnErrorRecover, Integer.valueOf(1));
        enumMap = new EnumMap(C5764b.class);
        logLevel2Index = enumMap;
        enumMap.put(C5764b.LevelDebug, Integer.valueOf(0));
        logLevel2Index.put(C5764b.LevelInfo, Integer.valueOf(1));
        logLevel2Index.put(C5764b.LevelWarning, Integer.valueOf(2));
        logLevel2Index.put(C5764b.LevelError, Integer.valueOf(3));
        logLevel2Index.put(C5764b.LevelNone, Integer.valueOf(4));
        AppMethodBeat.m2505o(124036);
    }

    public static String initialize(Context context) {
        AppMethodBeat.m2504i(123962);
        String initialize = initialize(context.getFilesDir().getAbsolutePath() + "/mmkv", null);
        AppMethodBeat.m2505o(123962);
        return initialize;
    }

    public static String initialize(String str) {
        AppMethodBeat.m2504i(123963);
        String initialize = initialize(str, null);
        AppMethodBeat.m2505o(123963);
        return initialize;
    }

    public static String initialize(String str, C5761a c5761a) {
        AppMethodBeat.m2504i(123964);
        if (c5761a != null) {
            "StaticCpp".equals("SharedCpp");
        } else {
            if ("StaticCpp".equals("SharedCpp")) {
                System.loadLibrary("c++_shared");
            }
            System.loadLibrary("mmkv");
        }
        rootDir = str;
        jniInitialize(str);
        AppMethodBeat.m2505o(123964);
        return str;
    }

    public static String getRootDir() {
        return rootDir;
    }

    public static void setLogLevel(C5764b c5764b) {
        int i = 1;
        AppMethodBeat.m2504i(123965);
        switch (c5764b) {
            case LevelDebug:
                i = 0;
                break;
            case LevelWarning:
                i = 2;
                break;
            case LevelError:
                i = 3;
                break;
            case LevelNone:
                i = 4;
                break;
        }
        setLogLevel(i);
        AppMethodBeat.m2505o(123965);
    }

    public static MMKV mmkvWithID(String str) {
        AppMethodBeat.m2504i(123966);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123966);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, 1, null, null));
        AppMethodBeat.m2505o(123966);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i) {
        AppMethodBeat.m2504i(123967);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123967);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, i, null, null));
        AppMethodBeat.m2505o(123967);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i, String str2) {
        AppMethodBeat.m2504i(123968);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123968);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getMMKVWithID(str, i, str2, null));
        AppMethodBeat.m2505o(123968);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, String str2) {
        AppMethodBeat.m2504i(123969);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123969);
            throw illegalStateException;
        }
        long mMKVWithID = getMMKVWithID(str, 1, null, str2);
        if (mMKVWithID == 0) {
            AppMethodBeat.m2505o(123969);
            return null;
        }
        MMKV mmkv = new MMKV(mMKVWithID);
        AppMethodBeat.m2505o(123969);
        return mmkv;
    }

    public static MMKV mmkvWithID(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(123970);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123970);
            throw illegalStateException;
        }
        long mMKVWithID = getMMKVWithID(str, i, str2, str3);
        if (mMKVWithID == 0) {
            AppMethodBeat.m2505o(123970);
            return null;
        }
        MMKV mmkv = new MMKV(mMKVWithID);
        AppMethodBeat.m2505o(123970);
        return mmkv;
    }

    public static MMKV mmkvWithAshmemID(Context context, String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(123971);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123971);
            throw illegalStateException;
        }
        String aB = MMKVContentProvider.m8675aB(context, Process.myPid());
        MMKV mmkv;
        if (aB == null || aB.length() == 0) {
            simpleLog(C5764b.LevelError, "process name detect fail, try again later");
            AppMethodBeat.m2505o(123971);
            return null;
        } else if (aB.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            Uri ix = MMKVContentProvider.m8677ix(context);
            if (ix == null) {
                simpleLog(C5764b.LevelError, "MMKVContentProvider has invalid authority");
                AppMethodBeat.m2505o(123971);
                return null;
            }
            simpleLog(C5764b.LevelInfo, "getting parcelable mmkv in process, Uri = ".concat(String.valueOf(ix)));
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i);
            bundle.putInt("KEY_MODE", i2);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle call = context.getContentResolver().call(ix, "mmkvFromAshmemID", str, bundle);
            if (call != null) {
                call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                if (parcelableMMKV != null) {
                    if (parcelableMMKV.AiS < 0 || parcelableMMKV.AiT < 0) {
                        mmkv = null;
                    } else {
                        mmkv = mmkvWithAshmemFD(parcelableMMKV.AiR, parcelableMMKV.AiS, parcelableMMKV.AiT, parcelableMMKV.AiU);
                    }
                    if (mmkv != null) {
                        simpleLog(C5764b.LevelInfo, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    }
                    AppMethodBeat.m2505o(123971);
                    return mmkv;
                }
            }
            AppMethodBeat.m2505o(123971);
            return null;
        } else {
            simpleLog(C5764b.LevelInfo, "getting mmkv in main process");
            mmkv = new MMKV(getMMKVWithIDAndSize(str, i, i2 | 8, str2));
            AppMethodBeat.m2505o(123971);
            return mmkv;
        }
    }

    public static MMKV defaultMMKV() {
        AppMethodBeat.m2504i(123972);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123972);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getDefaultMMKV(1, null));
        AppMethodBeat.m2505o(123972);
        return mmkv;
    }

    public static MMKV defaultMMKV(int i, String str) {
        AppMethodBeat.m2504i(123973);
        if (rootDir == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You should Call MMKV.initialize() first.");
            AppMethodBeat.m2505o(123973);
            throw illegalStateException;
        }
        MMKV mmkv = new MMKV(getDefaultMMKV(i, str));
        AppMethodBeat.m2505o(123973);
        return mmkv;
    }

    public boolean encode(String str, boolean z) {
        AppMethodBeat.m2504i(123974);
        boolean encodeBool = encodeBool(this.nativeHandle, str, z);
        AppMethodBeat.m2505o(123974);
        return encodeBool;
    }

    public boolean decodeBool(String str) {
        AppMethodBeat.m2504i(123975);
        boolean decodeBool = decodeBool(this.nativeHandle, str, false);
        AppMethodBeat.m2505o(123975);
        return decodeBool;
    }

    public boolean decodeBool(String str, boolean z) {
        AppMethodBeat.m2504i(123976);
        boolean decodeBool = decodeBool(this.nativeHandle, str, z);
        AppMethodBeat.m2505o(123976);
        return decodeBool;
    }

    public boolean encode(String str, int i) {
        AppMethodBeat.m2504i(123977);
        boolean encodeInt = encodeInt(this.nativeHandle, str, i);
        AppMethodBeat.m2505o(123977);
        return encodeInt;
    }

    public int decodeInt(String str) {
        AppMethodBeat.m2504i(123978);
        int decodeInt = decodeInt(this.nativeHandle, str, 0);
        AppMethodBeat.m2505o(123978);
        return decodeInt;
    }

    public int decodeInt(String str, int i) {
        AppMethodBeat.m2504i(123979);
        int decodeInt = decodeInt(this.nativeHandle, str, i);
        AppMethodBeat.m2505o(123979);
        return decodeInt;
    }

    public boolean encode(String str, long j) {
        AppMethodBeat.m2504i(123980);
        boolean encodeLong = encodeLong(this.nativeHandle, str, j);
        AppMethodBeat.m2505o(123980);
        return encodeLong;
    }

    public long decodeLong(String str) {
        AppMethodBeat.m2504i(123981);
        long decodeLong = decodeLong(this.nativeHandle, str, 0);
        AppMethodBeat.m2505o(123981);
        return decodeLong;
    }

    public long decodeLong(String str, long j) {
        AppMethodBeat.m2504i(123982);
        long decodeLong = decodeLong(this.nativeHandle, str, j);
        AppMethodBeat.m2505o(123982);
        return decodeLong;
    }

    public boolean encode(String str, float f) {
        AppMethodBeat.m2504i(123983);
        boolean encodeFloat = encodeFloat(this.nativeHandle, str, f);
        AppMethodBeat.m2505o(123983);
        return encodeFloat;
    }

    public float decodeFloat(String str) {
        AppMethodBeat.m2504i(123984);
        float decodeFloat = decodeFloat(this.nativeHandle, str, 0.0f);
        AppMethodBeat.m2505o(123984);
        return decodeFloat;
    }

    public float decodeFloat(String str, float f) {
        AppMethodBeat.m2504i(123985);
        float decodeFloat = decodeFloat(this.nativeHandle, str, f);
        AppMethodBeat.m2505o(123985);
        return decodeFloat;
    }

    public boolean encode(String str, double d) {
        AppMethodBeat.m2504i(123986);
        boolean encodeDouble = encodeDouble(this.nativeHandle, str, d);
        AppMethodBeat.m2505o(123986);
        return encodeDouble;
    }

    public double decodeDouble(String str) {
        AppMethodBeat.m2504i(123987);
        double decodeDouble = decodeDouble(this.nativeHandle, str, 0.0d);
        AppMethodBeat.m2505o(123987);
        return decodeDouble;
    }

    public double decodeDouble(String str, double d) {
        AppMethodBeat.m2504i(123988);
        double decodeDouble = decodeDouble(this.nativeHandle, str, d);
        AppMethodBeat.m2505o(123988);
        return decodeDouble;
    }

    public boolean encode(String str, String str2) {
        AppMethodBeat.m2504i(123989);
        boolean encodeString = encodeString(this.nativeHandle, str, str2);
        AppMethodBeat.m2505o(123989);
        return encodeString;
    }

    public String decodeString(String str) {
        AppMethodBeat.m2504i(123990);
        String decodeString = decodeString(this.nativeHandle, str, null);
        AppMethodBeat.m2505o(123990);
        return decodeString;
    }

    public String decodeString(String str, String str2) {
        AppMethodBeat.m2504i(123991);
        String decodeString = decodeString(this.nativeHandle, str, str2);
        AppMethodBeat.m2505o(123991);
        return decodeString;
    }

    public boolean encode(String str, Set<String> set) {
        AppMethodBeat.m2504i(123992);
        boolean encodeSet = encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[set.size()]));
        AppMethodBeat.m2505o(123992);
        return encodeSet;
    }

    public Set<String> decodeStringSet(String str) {
        AppMethodBeat.m2504i(123993);
        Set decodeStringSet = decodeStringSet(str, null);
        AppMethodBeat.m2505o(123993);
        return decodeStringSet;
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(123994);
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            AppMethodBeat.m2505o(123994);
            return set;
        }
        set = new HashSet(Arrays.asList(decodeStringSet));
        AppMethodBeat.m2505o(123994);
        return set;
    }

    public boolean encode(String str, byte[] bArr) {
        AppMethodBeat.m2504i(123995);
        boolean encodeBytes = encodeBytes(this.nativeHandle, str, bArr);
        AppMethodBeat.m2505o(123995);
        return encodeBytes;
    }

    public byte[] decodeBytes(String str) {
        AppMethodBeat.m2504i(123996);
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        AppMethodBeat.m2505o(123996);
        return decodeBytes;
    }

    public boolean encode(String str, Parcelable parcelable) {
        AppMethodBeat.m2504i(123997);
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, parcelable.describeContents());
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        boolean encodeBytes = encodeBytes(this.nativeHandle, str, marshall);
        AppMethodBeat.m2505o(123997);
        return encodeBytes;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        AppMethodBeat.m2504i(123998);
        Parcelable decodeParcelable = decodeParcelable(str, cls, null);
        AppMethodBeat.m2505o(123998);
        return decodeParcelable;
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t) {
        AppMethodBeat.m2504i(123999);
        if (cls == null) {
            AppMethodBeat.m2505o(123999);
            return t;
        }
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        if (decodeBytes == null) {
            AppMethodBeat.m2505o(123999);
            return t;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        Exception exception;
        try {
            Creator creator;
            String cls2 = cls.toString();
            synchronized (mCreators) {
                creator = (Creator) mCreators.get(cls2);
                if (creator == null) {
                    creator = (Creator) cls.getField("CREATOR").get(null);
                    if (creator != null) {
                        mCreators.put(cls2, creator);
                    }
                }
            }
            if (creator != null) {
                T t2 = (Parcelable) creator.createFromParcel(obtain);
                obtain.recycle();
                AppMethodBeat.m2505o(123999);
                return t2;
            }
            exception = new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(cls2)));
            AppMethodBeat.m2505o(123999);
            throw exception;
        } catch (Exception exception2) {
            try {
                simpleLog(C5764b.LevelError, exception2.toString());
                return t;
            } finally {
                obtain.recycle();
                AppMethodBeat.m2505o(123999);
            }
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(123999);
            }
        }
    }

    public int getValueSize(String str) {
        AppMethodBeat.m2504i(124000);
        int valueSize = valueSize(this.nativeHandle, str, false);
        AppMethodBeat.m2505o(124000);
        return valueSize;
    }

    public int getValueActualSize(String str) {
        AppMethodBeat.m2504i(124001);
        int valueSize = valueSize(this.nativeHandle, str, true);
        AppMethodBeat.m2505o(124001);
        return valueSize;
    }

    public boolean containsKey(String str) {
        AppMethodBeat.m2504i(124002);
        boolean containsKey = containsKey(this.nativeHandle, str);
        AppMethodBeat.m2505o(124002);
        return containsKey;
    }

    public long count() {
        AppMethodBeat.m2504i(124003);
        long count = count(this.nativeHandle);
        AppMethodBeat.m2505o(124003);
        return count;
    }

    public long totalSize() {
        AppMethodBeat.m2504i(124004);
        long totalSize = totalSize(this.nativeHandle);
        AppMethodBeat.m2505o(124004);
        return totalSize;
    }

    public void removeValueForKey(String str) {
        AppMethodBeat.m2504i(124005);
        removeValueForKey(this.nativeHandle, str);
        AppMethodBeat.m2505o(124005);
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(124006);
        Map all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            AppMethodBeat.m2505o(124006);
            return 0;
        }
        for (Entry entry : all.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (!(str == null || value == null)) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, str, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, str, (String) value);
                } else if (value instanceof Set) {
                    encode(str, (Set) value);
                } else {
                    simpleLog(C5764b.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        int size = all.size();
        AppMethodBeat.m2505o(124006);
        return size;
    }

    public Map<String, ?> getAll() {
        AppMethodBeat.m2504i(124007);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
        AppMethodBeat.m2505o(124007);
        throw unsupportedOperationException;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.m2504i(124008);
        String decodeString = decodeString(this.nativeHandle, str, str2);
        AppMethodBeat.m2505o(124008);
        return decodeString;
    }

    public Editor putString(String str, String str2) {
        AppMethodBeat.m2504i(124009);
        encodeString(this.nativeHandle, str, str2);
        AppMethodBeat.m2505o(124009);
        return this;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(124010);
        Set decodeStringSet = decodeStringSet(str, (Set) set);
        AppMethodBeat.m2505o(124010);
        return decodeStringSet;
    }

    public Editor putStringSet(String str, Set<String> set) {
        AppMethodBeat.m2504i(124011);
        encode(str, (Set) set);
        AppMethodBeat.m2505o(124011);
        return this;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.m2504i(124012);
        int decodeInt = decodeInt(this.nativeHandle, str, i);
        AppMethodBeat.m2505o(124012);
        return decodeInt;
    }

    public Editor putInt(String str, int i) {
        AppMethodBeat.m2504i(124013);
        encodeInt(this.nativeHandle, str, i);
        AppMethodBeat.m2505o(124013);
        return this;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.m2504i(124014);
        long decodeLong = decodeLong(this.nativeHandle, str, j);
        AppMethodBeat.m2505o(124014);
        return decodeLong;
    }

    public Editor putLong(String str, long j) {
        AppMethodBeat.m2504i(124015);
        encodeLong(this.nativeHandle, str, j);
        AppMethodBeat.m2505o(124015);
        return this;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.m2504i(124016);
        float decodeFloat = decodeFloat(this.nativeHandle, str, f);
        AppMethodBeat.m2505o(124016);
        return decodeFloat;
    }

    public Editor putFloat(String str, float f) {
        AppMethodBeat.m2504i(124017);
        encodeFloat(this.nativeHandle, str, f);
        AppMethodBeat.m2505o(124017);
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(124018);
        boolean decodeBool = decodeBool(this.nativeHandle, str, z);
        AppMethodBeat.m2505o(124018);
        return decodeBool;
    }

    public Editor putBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(124019);
        encodeBool(this.nativeHandle, str, z);
        AppMethodBeat.m2505o(124019);
        return this;
    }

    public Editor remove(String str) {
        AppMethodBeat.m2504i(124020);
        removeValueForKey(str);
        AppMethodBeat.m2505o(124020);
        return this;
    }

    public Editor clear() {
        AppMethodBeat.m2504i(124021);
        clearAll();
        AppMethodBeat.m2505o(124021);
        return this;
    }

    public boolean commit() {
        AppMethodBeat.m2504i(124022);
        sync();
        AppMethodBeat.m2505o(124022);
        return true;
    }

    public void apply() {
    }

    public boolean contains(String str) {
        AppMethodBeat.m2504i(124023);
        boolean containsKey = containsKey(str);
        AppMethodBeat.m2505o(124023);
        return containsKey;
    }

    public Editor edit() {
        return this;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(124024);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.m2505o(124024);
        throw unsupportedOperationException;
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.m2504i(124025);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implement in MMKV");
        AppMethodBeat.m2505o(124025);
        throw unsupportedOperationException;
    }

    public static MMKV mmkvWithAshmemFD(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(124026);
        MMKV mmkv = new MMKV(getMMKVWithAshmemFD(str, i, i2, str2));
        AppMethodBeat.m2505o(124026);
        return mmkv;
    }

    public static C5766d createNativeBuffer(int i) {
        AppMethodBeat.m2504i(124027);
        long createNB = createNB(i);
        if (createNB <= 0) {
            AppMethodBeat.m2505o(124027);
            return null;
        }
        C5766d c5766d = new C5766d(createNB, i);
        AppMethodBeat.m2505o(124027);
        return c5766d;
    }

    public static void destroyNativeBuffer(C5766d c5766d) {
        AppMethodBeat.m2504i(124028);
        destroyNB(c5766d.AiQ, c5766d.size);
        AppMethodBeat.m2505o(124028);
    }

    public int writeValueToNativeBuffer(String str, C5766d c5766d) {
        AppMethodBeat.m2504i(124029);
        int writeValueToNB = writeValueToNB(this.nativeHandle, str, c5766d.AiQ, c5766d.size);
        AppMethodBeat.m2505o(124029);
        return writeValueToNB;
    }

    public static void registerHandler(C5763a c5763a) {
        AppMethodBeat.m2504i(124030);
        gCallbackHandler = c5763a;
        setLogReDirecting(true);
        gWantLogReDirecting = true;
        AppMethodBeat.m2505o(124030);
    }

    public static void unregisterHandler() {
        AppMethodBeat.m2504i(124031);
        gCallbackHandler = null;
        setLogReDirecting(false);
        gWantLogReDirecting = false;
        AppMethodBeat.m2505o(124031);
    }

    private static int onMMKVCRCCheckFail(String str) {
        AppMethodBeat.m2504i(124032);
        Object obj = C5765c.OnErrorDiscard;
        if (gCallbackHandler != null) {
            obj = gCallbackHandler.amJ(str);
        }
        simpleLog(C5764b.LevelInfo, "Recover strategic for " + str + " is " + obj);
        int intValue = ((Integer) recoverIndex.get(obj)).intValue();
        AppMethodBeat.m2505o(124032);
        return intValue;
    }

    private static int onMMKVFileLengthError(String str) {
        AppMethodBeat.m2504i(124033);
        Object obj = C5765c.OnErrorDiscard;
        if (gCallbackHandler != null) {
            obj = gCallbackHandler.amK(str);
        }
        simpleLog(C5764b.LevelInfo, "Recover strategic for " + str + " is " + obj);
        int intValue = ((Integer) recoverIndex.get(obj)).intValue();
        AppMethodBeat.m2505o(124033);
        return intValue;
    }

    private static void mmkvLogImp(int i, String str, int i2, String str2, String str3) {
        AppMethodBeat.m2504i(124034);
        if (gCallbackHandler == null || !gWantLogReDirecting) {
            int[] iArr = C57601.AiF;
            index2LogLevel[i].ordinal();
            AppMethodBeat.m2505o(124034);
            return;
        }
        gCallbackHandler.mo10361h(str, i2, str2, str3);
        AppMethodBeat.m2505o(124034);
    }

    private static void simpleLog(C5764b c5764b, String str) {
        AppMethodBeat.m2504i(124035);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        mmkvLogImp(((Integer) logLevel2Index.get(c5764b)).intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
        AppMethodBeat.m2505o(124035);
    }

    private MMKV(long j) {
        this.nativeHandle = j;
    }
}
