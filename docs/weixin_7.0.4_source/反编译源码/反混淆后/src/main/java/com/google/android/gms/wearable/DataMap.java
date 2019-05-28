package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

@VisibleForTesting
public class DataMap {
    public static final String TAG = "DataMap";
    private final HashMap<String, Object> zzq = new HashMap();

    public DataMap() {
        AppMethodBeat.m2504i(70803);
        AppMethodBeat.m2505o(70803);
    }

    public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> arrayList) {
        AppMethodBeat.m2504i(70806);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            arrayList2.add(fromBundle((Bundle) obj));
        }
        AppMethodBeat.m2505o(70806);
        return arrayList2;
    }

    public static DataMap fromBundle(Bundle bundle) {
        AppMethodBeat.m2504i(70804);
        bundle.setClassLoader(Asset.class.getClassLoader());
        DataMap dataMap = new DataMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                dataMap.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                dataMap.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                dataMap.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                dataMap.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                dataMap.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                dataMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataMap.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                dataMap.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                dataMap.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                dataMap.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                dataMap.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                dataMap.putAsset(str, (Asset) obj);
            } else if (obj instanceof Bundle) {
                dataMap.putDataMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof ArrayList) {
                switch (zza((ArrayList) obj)) {
                    case 0:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 1:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 2:
                        dataMap.putIntegerArrayList(str, (ArrayList) obj);
                        break;
                    case 3:
                        dataMap.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 5:
                        dataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList) obj));
                        break;
                    default:
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(70804);
        return dataMap;
    }

    public static DataMap fromByteArray(byte[] bArr) {
        AppMethodBeat.m2504i(70805);
        try {
            DataMap zza = zze.zza(new zzf(zzg.zza(bArr), new ArrayList()));
            AppMethodBeat.m2505o(70805);
            return zza;
        } catch (zzs e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to convert data", e);
            AppMethodBeat.m2505o(70805);
            throw illegalArgumentException;
        }
    }

    private static int zza(ArrayList<?> arrayList) {
        int i = 0;
        AppMethodBeat.m2504i(70861);
        if (arrayList.isEmpty()) {
            AppMethodBeat.m2505o(70861);
            return 0;
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            if (obj != null) {
                if (obj instanceof Integer) {
                    AppMethodBeat.m2505o(70861);
                    return 2;
                } else if (obj instanceof String) {
                    AppMethodBeat.m2505o(70861);
                    return 3;
                } else if (obj instanceof DataMap) {
                    AppMethodBeat.m2505o(70861);
                    return 4;
                } else if (obj instanceof Bundle) {
                    AppMethodBeat.m2505o(70861);
                    return 5;
                }
            }
        }
        AppMethodBeat.m2505o(70861);
        return 1;
    }

    private static void zza(String str, Object obj, String str2, ClassCastException classCastException) {
        AppMethodBeat.m2504i(70859);
        zza(str, obj, str2, "<null>", classCastException);
        AppMethodBeat.m2505o(70859);
    }

    private static void zza(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        AppMethodBeat.m2504i(70860);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key ");
        stringBuilder.append(str);
        stringBuilder.append(" expected ");
        stringBuilder.append(str2);
        stringBuilder.append(" but value was a ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(".  The default value ");
        stringBuilder.append(obj2);
        stringBuilder.append(" was returned.");
        AppMethodBeat.m2505o(70860);
    }

    public void clear() {
        AppMethodBeat.m2504i(70811);
        this.zzq.clear();
        AppMethodBeat.m2505o(70811);
    }

    public boolean containsKey(String str) {
        AppMethodBeat.m2504i(70812);
        boolean containsKey = this.zzq.containsKey(str);
        AppMethodBeat.m2505o(70812);
        return containsKey;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(70856);
        if (obj instanceof DataMap) {
            DataMap dataMap = (DataMap) obj;
            if (size() != dataMap.size()) {
                AppMethodBeat.m2505o(70856);
                return false;
            }
            for (String str : keySet()) {
                Object obj2 = get(str);
                Object obj3 = dataMap.get(str);
                if (obj2 instanceof Asset) {
                    if (obj3 instanceof Asset) {
                        Asset asset = (Asset) obj2;
                        Asset asset2 = (Asset) obj3;
                        boolean equals = (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.getDigest()) ? asset.getDigest().equals(asset2.getDigest()) : Arrays.equals(asset.getData(), asset2.getData());
                        if (!equals) {
                            AppMethodBeat.m2505o(70856);
                            return false;
                        }
                    } else {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                } else if (obj2 instanceof String[]) {
                    if (!(obj3 instanceof String[])) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    } else if (!Arrays.equals((String[]) obj2, (String[]) obj3)) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                } else if (obj2 instanceof long[]) {
                    if (!(obj3 instanceof long[])) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    } else if (!Arrays.equals((long[]) obj2, (long[]) obj3)) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                } else if (obj2 instanceof float[]) {
                    if (!(obj3 instanceof float[])) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    } else if (!Arrays.equals((float[]) obj2, (float[]) obj3)) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                } else if (obj2 instanceof byte[]) {
                    if (!(obj3 instanceof byte[])) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    } else if (!Arrays.equals((byte[]) obj2, (byte[]) obj3)) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                } else if (obj2 == null || obj3 == null) {
                    if (obj2 != obj3) {
                        AppMethodBeat.m2505o(70856);
                        return false;
                    }
                    AppMethodBeat.m2505o(70856);
                    return true;
                } else if (!obj2.equals(obj3)) {
                    AppMethodBeat.m2505o(70856);
                    return false;
                }
            }
            AppMethodBeat.m2505o(70856);
            return true;
        }
        AppMethodBeat.m2505o(70856);
        return false;
    }

    public <T> T get(String str) {
        AppMethodBeat.m2504i(70813);
        Object obj = this.zzq.get(str);
        AppMethodBeat.m2505o(70813);
        return obj;
    }

    public Asset getAsset(String str) {
        AppMethodBeat.m2504i(70847);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70847);
            return null;
        }
        try {
            Asset asset = (Asset) obj;
            AppMethodBeat.m2505o(70847);
            return asset;
        } catch (ClassCastException e) {
            zza(str, obj, "Asset", e);
            AppMethodBeat.m2505o(70847);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.m2504i(70833);
        boolean z = getBoolean(str, false);
        AppMethodBeat.m2505o(70833);
        return z;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(70834);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70834);
        } else {
            try {
                z = ((Boolean) obj).booleanValue();
                AppMethodBeat.m2505o(70834);
            } catch (ClassCastException e) {
                zza(str, obj, "Boolean", Boolean.valueOf(z), e);
                AppMethodBeat.m2505o(70834);
            }
        }
        return z;
    }

    public byte getByte(String str) {
        AppMethodBeat.m2504i(70835);
        byte b = getByte(str, (byte) 0);
        AppMethodBeat.m2505o(70835);
        return b;
    }

    public byte getByte(String str, byte b) {
        AppMethodBeat.m2504i(70836);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70836);
        } else {
            try {
                b = ((Byte) obj).byteValue();
                AppMethodBeat.m2505o(70836);
            } catch (ClassCastException e) {
                zza(str, obj, "Byte", Byte.valueOf(b), e);
                AppMethodBeat.m2505o(70836);
            }
        }
        return b;
    }

    public byte[] getByteArray(String str) {
        AppMethodBeat.m2504i(70852);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70852);
            return null;
        }
        try {
            byte[] bArr = (byte[]) obj;
            AppMethodBeat.m2505o(70852);
            return bArr;
        } catch (ClassCastException e) {
            zza(str, obj, "byte[]", e);
            AppMethodBeat.m2505o(70852);
            return null;
        }
    }

    public DataMap getDataMap(String str) {
        AppMethodBeat.m2504i(70848);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70848);
            return null;
        }
        try {
            DataMap dataMap = (DataMap) obj;
            AppMethodBeat.m2505o(70848);
            return dataMap;
        } catch (ClassCastException e) {
            zza(str, obj, TAG, e);
            AppMethodBeat.m2505o(70848);
            return null;
        }
    }

    public ArrayList<DataMap> getDataMapArrayList(String str) {
        AppMethodBeat.m2504i(70851);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70851);
            return null;
        }
        try {
            ArrayList arrayList = (ArrayList) obj;
            AppMethodBeat.m2505o(70851);
            return arrayList;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<DataMap>", e);
            AppMethodBeat.m2505o(70851);
            return null;
        }
    }

    public double getDouble(String str) {
        AppMethodBeat.m2504i(70843);
        double d = getDouble(str, 0.0d);
        AppMethodBeat.m2505o(70843);
        return d;
    }

    public double getDouble(String str, double d) {
        AppMethodBeat.m2504i(70844);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70844);
        } else {
            try {
                d = ((Double) obj).doubleValue();
                AppMethodBeat.m2505o(70844);
            } catch (ClassCastException e) {
                zza(str, obj, "Double", Double.valueOf(d), e);
                AppMethodBeat.m2505o(70844);
            }
        }
        return d;
    }

    public float getFloat(String str) {
        AppMethodBeat.m2504i(70841);
        float f = getFloat(str, 0.0f);
        AppMethodBeat.m2505o(70841);
        return f;
    }

    public float getFloat(String str, float f) {
        AppMethodBeat.m2504i(70842);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70842);
        } else {
            try {
                f = ((Float) obj).floatValue();
                AppMethodBeat.m2505o(70842);
            } catch (ClassCastException e) {
                zza(str, obj, "Float", Float.valueOf(f), e);
                AppMethodBeat.m2505o(70842);
            }
        }
        return f;
    }

    public float[] getFloatArray(String str) {
        AppMethodBeat.m2504i(70854);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70854);
            return null;
        }
        try {
            float[] fArr = (float[]) obj;
            AppMethodBeat.m2505o(70854);
            return fArr;
        } catch (ClassCastException e) {
            zza(str, obj, "float[]", e);
            AppMethodBeat.m2505o(70854);
            return null;
        }
    }

    public int getInt(String str) {
        AppMethodBeat.m2504i(70837);
        int i = getInt(str, 0);
        AppMethodBeat.m2505o(70837);
        return i;
    }

    public int getInt(String str, int i) {
        AppMethodBeat.m2504i(70838);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70838);
        } else {
            try {
                i = ((Integer) obj).intValue();
                AppMethodBeat.m2505o(70838);
            } catch (ClassCastException e) {
                zza(str, obj, DownloadSetting.TYPE_INTEGER, e);
                AppMethodBeat.m2505o(70838);
            }
        }
        return i;
    }

    public ArrayList<Integer> getIntegerArrayList(String str) {
        AppMethodBeat.m2504i(70849);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70849);
            return null;
        }
        try {
            ArrayList arrayList = (ArrayList) obj;
            AppMethodBeat.m2505o(70849);
            return arrayList;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<Integer>", e);
            AppMethodBeat.m2505o(70849);
            return null;
        }
    }

    public long getLong(String str) {
        AppMethodBeat.m2504i(70839);
        long j = getLong(str, 0);
        AppMethodBeat.m2505o(70839);
        return j;
    }

    public long getLong(String str, long j) {
        AppMethodBeat.m2504i(70840);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70840);
        } else {
            try {
                j = ((Long) obj).longValue();
                AppMethodBeat.m2505o(70840);
            } catch (ClassCastException e) {
                zza(str, obj, "long", e);
                AppMethodBeat.m2505o(70840);
            }
        }
        return j;
    }

    public long[] getLongArray(String str) {
        AppMethodBeat.m2504i(70853);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70853);
            return null;
        }
        try {
            long[] jArr = (long[]) obj;
            AppMethodBeat.m2505o(70853);
            return jArr;
        } catch (ClassCastException e) {
            zza(str, obj, "long[]", e);
            AppMethodBeat.m2505o(70853);
            return null;
        }
    }

    public String getString(String str) {
        AppMethodBeat.m2504i(70846);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70846);
            return null;
        }
        try {
            String str2 = (String) obj;
            AppMethodBeat.m2505o(70846);
            return str2;
        } catch (ClassCastException e) {
            zza(str, obj, "String", e);
            AppMethodBeat.m2505o(70846);
            return null;
        }
    }

    public String getString(String str, String str2) {
        AppMethodBeat.m2504i(70845);
        String string = getString(str);
        if (string == null) {
            AppMethodBeat.m2505o(70845);
            return str2;
        }
        AppMethodBeat.m2505o(70845);
        return string;
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.m2504i(70855);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70855);
            return null;
        }
        try {
            String[] strArr = (String[]) obj;
            AppMethodBeat.m2505o(70855);
            return strArr;
        } catch (ClassCastException e) {
            zza(str, obj, "String[]", e);
            AppMethodBeat.m2505o(70855);
            return null;
        }
    }

    public ArrayList<String> getStringArrayList(String str) {
        AppMethodBeat.m2504i(70850);
        Object obj = this.zzq.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(70850);
            return null;
        }
        try {
            ArrayList arrayList = (ArrayList) obj;
            AppMethodBeat.m2505o(70850);
            return arrayList;
        } catch (ClassCastException e) {
            zza(str, obj, "ArrayList<String>", e);
            AppMethodBeat.m2505o(70850);
            return null;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(70857);
        int hashCode = this.zzq.hashCode() * 29;
        AppMethodBeat.m2505o(70857);
        return hashCode;
    }

    public boolean isEmpty() {
        AppMethodBeat.m2504i(70810);
        boolean isEmpty = this.zzq.isEmpty();
        AppMethodBeat.m2505o(70810);
        return isEmpty;
    }

    public Set<String> keySet() {
        AppMethodBeat.m2504i(70816);
        Set keySet = this.zzq.keySet();
        AppMethodBeat.m2505o(70816);
        return keySet;
    }

    public void putAll(DataMap dataMap) {
        AppMethodBeat.m2504i(70815);
        for (String str : dataMap.keySet()) {
            this.zzq.put(str, dataMap.get(str));
        }
        AppMethodBeat.m2505o(70815);
    }

    public void putAsset(String str, Asset asset) {
        AppMethodBeat.m2504i(70824);
        this.zzq.put(str, asset);
        AppMethodBeat.m2505o(70824);
    }

    public void putBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(70817);
        this.zzq.put(str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(70817);
    }

    public void putByte(String str, byte b) {
        AppMethodBeat.m2504i(70818);
        this.zzq.put(str, Byte.valueOf(b));
        AppMethodBeat.m2505o(70818);
    }

    public void putByteArray(String str, byte[] bArr) {
        AppMethodBeat.m2504i(70829);
        this.zzq.put(str, bArr);
        AppMethodBeat.m2505o(70829);
    }

    public void putDataMap(String str, DataMap dataMap) {
        AppMethodBeat.m2504i(70825);
        this.zzq.put(str, dataMap);
        AppMethodBeat.m2505o(70825);
    }

    public void putDataMapArrayList(String str, ArrayList<DataMap> arrayList) {
        AppMethodBeat.m2504i(70826);
        this.zzq.put(str, arrayList);
        AppMethodBeat.m2505o(70826);
    }

    public void putDouble(String str, double d) {
        AppMethodBeat.m2504i(70822);
        this.zzq.put(str, Double.valueOf(d));
        AppMethodBeat.m2505o(70822);
    }

    public void putFloat(String str, float f) {
        AppMethodBeat.m2504i(70821);
        this.zzq.put(str, Float.valueOf(f));
        AppMethodBeat.m2505o(70821);
    }

    public void putFloatArray(String str, float[] fArr) {
        AppMethodBeat.m2504i(70831);
        this.zzq.put(str, fArr);
        AppMethodBeat.m2505o(70831);
    }

    public void putInt(String str, int i) {
        AppMethodBeat.m2504i(70819);
        this.zzq.put(str, Integer.valueOf(i));
        AppMethodBeat.m2505o(70819);
    }

    public void putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        AppMethodBeat.m2504i(70827);
        this.zzq.put(str, arrayList);
        AppMethodBeat.m2505o(70827);
    }

    public void putLong(String str, long j) {
        AppMethodBeat.m2504i(70820);
        this.zzq.put(str, Long.valueOf(j));
        AppMethodBeat.m2505o(70820);
    }

    public void putLongArray(String str, long[] jArr) {
        AppMethodBeat.m2504i(70830);
        this.zzq.put(str, jArr);
        AppMethodBeat.m2505o(70830);
    }

    public void putString(String str, String str2) {
        AppMethodBeat.m2504i(70823);
        this.zzq.put(str, str2);
        AppMethodBeat.m2505o(70823);
    }

    public void putStringArray(String str, String[] strArr) {
        AppMethodBeat.m2504i(70832);
        this.zzq.put(str, strArr);
        AppMethodBeat.m2505o(70832);
    }

    public void putStringArrayList(String str, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(70828);
        this.zzq.put(str, arrayList);
        AppMethodBeat.m2505o(70828);
    }

    public Object remove(String str) {
        AppMethodBeat.m2504i(70814);
        Object remove = this.zzq.remove(str);
        AppMethodBeat.m2505o(70814);
        return remove;
    }

    public int size() {
        AppMethodBeat.m2504i(70809);
        int size = this.zzq.size();
        AppMethodBeat.m2505o(70809);
        return size;
    }

    public Bundle toBundle() {
        AppMethodBeat.m2504i(70807);
        Bundle bundle = new Bundle();
        for (String str : this.zzq.keySet()) {
            Object obj = this.zzq.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Asset) {
                bundle.putParcelable(str, (Asset) obj);
            } else if (obj instanceof DataMap) {
                bundle.putParcelable(str, ((DataMap) obj).toBundle());
            } else if (obj instanceof ArrayList) {
                switch (zza((ArrayList) obj)) {
                    case 0:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 1:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 2:
                        bundle.putIntegerArrayList(str, (ArrayList) obj);
                        break;
                    case 3:
                        bundle.putStringArrayList(str, (ArrayList) obj);
                        break;
                    case 4:
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList2.get(i);
                            i++;
                            arrayList.add(((DataMap) obj2).toBundle());
                        }
                        bundle.putParcelableArrayList(str, arrayList);
                        break;
                    default:
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(70807);
        return bundle;
    }

    public byte[] toByteArray() {
        AppMethodBeat.m2504i(70808);
        byte[] zzb = zzt.zzb(zze.zza(this).zzfw);
        AppMethodBeat.m2505o(70808);
        return zzb;
    }

    public String toString() {
        AppMethodBeat.m2504i(70858);
        String hashMap = this.zzq.toString();
        AppMethodBeat.m2505o(70858);
        return hashMap;
    }
}
