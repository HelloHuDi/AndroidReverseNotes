package com.google.android.gms.internal.wearable;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@VisibleForTesting
public final class zze {
    public static zzf zza(DataMap dataMap) {
        AppMethodBeat.m2504i(70674);
        zzg zzg = new zzg();
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        zzh[] zzhArr = new zzh[treeSet.size()];
        int i = 0;
        Iterator it = treeSet.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String str = (String) it.next();
                Object obj = dataMap.get(str);
                zzhArr[i2] = new zzh();
                zzhArr[i2].name = str;
                zzhArr[i2].zzga = zza(arrayList, obj);
                i = i2 + 1;
            } else {
                zzg.zzfy = zzhArr;
                zzf zzf = new zzf(zzg, arrayList);
                AppMethodBeat.m2505o(70674);
                return zzf;
            }
        }
    }

    private static zzi zza(List<Asset> list, Object obj) {
        int i = 0;
        AppMethodBeat.m2504i(70676);
        zzi zzi = new zzi();
        if (obj == null) {
            zzi.type = 14;
            AppMethodBeat.m2505o(70676);
            return zzi;
        }
        zzi.zzgc = new zzj();
        String str;
        if (obj instanceof String) {
            zzi.type = 2;
            zzi.zzgc.zzge = (String) obj;
        } else if (obj instanceof Integer) {
            zzi.type = 6;
            zzi.zzgc.zzgi = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            zzi.type = 5;
            zzi.zzgc.zzgh = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            zzi.type = 3;
            zzi.zzgc.zzgf = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            zzi.type = 4;
            zzi.zzgc.zzgg = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            zzi.type = 8;
            zzi.zzgc.zzgk = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            zzi.type = 7;
            zzi.zzgc.zzgj = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            zzi.type = 1;
            zzi.zzgc.zzgd = (byte[]) obj;
        } else if (obj instanceof String[]) {
            zzi.type = 11;
            zzi.zzgc.zzgn = (String[]) obj;
        } else if (obj instanceof long[]) {
            zzi.type = 12;
            zzi.zzgc.zzgo = (long[]) obj;
        } else if (obj instanceof float[]) {
            zzi.type = 15;
            zzi.zzgc.zzgp = (float[]) obj;
        } else if (obj instanceof Asset) {
            zzi.type = 13;
            zzj zzj = zzi.zzgc;
            list.add((Asset) obj);
            zzj.zzgq = (long) (list.size() - 1);
        } else if (obj instanceof DataMap) {
            zzi.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.keySet());
            zzh[] zzhArr = new zzh[treeSet.size()];
            Iterator it = treeSet.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                str = (String) it.next();
                zzhArr[i2] = new zzh();
                zzhArr[i2].name = str;
                zzhArr[i2].zzga = zza(list, dataMap.get(str));
                i = i2 + 1;
            }
            zzi.zzgc.zzgl = zzhArr;
        } else if (obj instanceof ArrayList) {
            zzi.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzi[] zziArr = new zzi[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 14;
            while (i3 < size) {
                Object obj3 = arrayList.get(i3);
                zzi zza = zza(list, obj3);
                if (zza.type == 14 || zza.type == 2 || zza.type == 6 || zza.type == 9) {
                    if (i4 == 14 && zza.type != 14) {
                        i4 = zza.type;
                    } else if (zza.type != i4) {
                        String valueOf = String.valueOf(obj2.getClass());
                        str = String.valueOf(obj3.getClass());
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 80) + String.valueOf(str).length()).append("ArrayList elements must all be of the sameclass, but this one contains a ").append(valueOf).append(" and a ").append(str).toString());
                        AppMethodBeat.m2505o(70676);
                        throw illegalArgumentException;
                    } else {
                        obj3 = obj2;
                    }
                    zziArr[i3] = zza;
                    i3++;
                    obj2 = obj3;
                } else {
                    str = String.valueOf(obj3.getClass());
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 130).append("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ").append(str).toString());
                    AppMethodBeat.m2505o(70676);
                    throw illegalArgumentException2;
                }
            }
            zzi.zzgc.zzgm = zziArr;
        } else {
            String str2 = "newFieldValueFromValue: unexpected value ";
            str = String.valueOf(obj.getClass().getSimpleName());
            RuntimeException runtimeException = new RuntimeException(str.length() != 0 ? str2.concat(str) : new String(str2));
            AppMethodBeat.m2505o(70676);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(70676);
        return zzi;
    }

    public static DataMap zza(zzf zzf) {
        AppMethodBeat.m2504i(70675);
        DataMap dataMap = new DataMap();
        for (zzh zzh : zzf.zzfw.zzfy) {
            zza(zzf.zzfx, dataMap, zzh.name, zzh.zzga);
        }
        AppMethodBeat.m2505o(70675);
        return dataMap;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzi zzi) {
        AppMethodBeat.m2504i(70677);
        int i = zzi.type;
        if (i == 14) {
            dataMap.putString(str, null);
            AppMethodBeat.m2505o(70677);
            return;
        }
        zzj zzj = zzi.zzgc;
        RuntimeException runtimeException;
        if (i == 1) {
            dataMap.putByteArray(str, zzj.zzgd);
            AppMethodBeat.m2505o(70677);
        } else if (i == 11) {
            dataMap.putStringArray(str, zzj.zzgn);
            AppMethodBeat.m2505o(70677);
        } else if (i == 12) {
            dataMap.putLongArray(str, zzj.zzgo);
            AppMethodBeat.m2505o(70677);
        } else if (i == 15) {
            dataMap.putFloatArray(str, zzj.zzgp);
            AppMethodBeat.m2505o(70677);
        } else if (i == 2) {
            dataMap.putString(str, zzj.zzge);
            AppMethodBeat.m2505o(70677);
        } else if (i == 3) {
            dataMap.putDouble(str, zzj.zzgf);
            AppMethodBeat.m2505o(70677);
        } else if (i == 4) {
            dataMap.putFloat(str, zzj.zzgg);
            AppMethodBeat.m2505o(70677);
        } else if (i == 5) {
            dataMap.putLong(str, zzj.zzgh);
            AppMethodBeat.m2505o(70677);
        } else if (i == 6) {
            dataMap.putInt(str, zzj.zzgi);
            AppMethodBeat.m2505o(70677);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) zzj.zzgj);
            AppMethodBeat.m2505o(70677);
        } else if (i == 8) {
            dataMap.putBoolean(str, zzj.zzgk);
            AppMethodBeat.m2505o(70677);
        } else if (i == 13) {
            if (list == null) {
                String str2 = "populateBundle: unexpected type for: ";
                String valueOf = String.valueOf(str);
                runtimeException = new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                AppMethodBeat.m2505o(70677);
                throw runtimeException;
            }
            dataMap.putAsset(str, (Asset) list.get((int) zzj.zzgq));
            AppMethodBeat.m2505o(70677);
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzh zzh : zzj.zzgl) {
                zza(list, dataMap2, zzh.name, zzh.zzga);
            }
            dataMap.putDataMap(str, dataMap2);
            AppMethodBeat.m2505o(70677);
        } else if (i == 10) {
            IllegalArgumentException illegalArgumentException;
            i = 14;
            for (zzi zzi2 : zzj.zzgm) {
                if (i == 14) {
                    if (zzi2.type == 9 || zzi2.type == 2 || zzi2.type == 6) {
                        i = zzi2.type;
                    } else if (zzi2.type != 14) {
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 48).append("Unexpected TypedValue type: ").append(zzi2.type).append(" for key ").append(str).toString());
                        AppMethodBeat.m2505o(70677);
                        throw illegalArgumentException2;
                    }
                } else if (zzi2.type != i) {
                    illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 126).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(str).append(" contains items of type ").append(i).append(" and ").append(zzi2.type).toString());
                    AppMethodBeat.m2505o(70677);
                    throw illegalArgumentException;
                }
            }
            ArrayList arrayList = new ArrayList(zzj.zzgm.length);
            for (zzi zzi3 : zzj.zzgm) {
                if (zzi3.type == 14) {
                    arrayList.add(null);
                } else if (i == 9) {
                    DataMap dataMap3 = new DataMap();
                    for (zzh zzh2 : zzi3.zzgc.zzgl) {
                        zza(list, dataMap3, zzh2.name, zzh2.zzga);
                    }
                    arrayList.add(dataMap3);
                } else if (i == 2) {
                    arrayList.add(zzi3.zzgc.zzge);
                } else if (i == 6) {
                    arrayList.add(Integer.valueOf(zzi3.zzgc.zzgi));
                } else {
                    illegalArgumentException = new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                    AppMethodBeat.m2505o(70677);
                    throw illegalArgumentException;
                }
            }
            if (i == 14) {
                dataMap.putStringArrayList(str, arrayList);
                AppMethodBeat.m2505o(70677);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, arrayList);
                AppMethodBeat.m2505o(70677);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, arrayList);
                AppMethodBeat.m2505o(70677);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, arrayList);
                AppMethodBeat.m2505o(70677);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Unexpected typeOfArrayList: " + i);
                AppMethodBeat.m2505o(70677);
                throw illegalStateException;
            }
        } else {
            runtimeException = new RuntimeException("populateBundle: unexpected type " + i);
            AppMethodBeat.m2505o(70677);
            throw runtimeException;
        }
    }
}
