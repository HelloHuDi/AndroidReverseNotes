package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@VisibleForTesting
public final class ArrayUtils {

    static class zza {
        HashMap<Object, zza> zzzb;

        zza(int i) {
            AppMethodBeat.i(89995);
            this.zzzb = new HashMap(i);
            AppMethodBeat.o(89995);
        }

        private final zza zzd(Object obj) {
            AppMethodBeat.i(89998);
            zza zza = (zza) this.zzzb.get(obj);
            if (zza == null) {
                zza = new zza();
                this.zzzb.put(obj, zza);
            }
            AppMethodBeat.o(89998);
            return zza;
        }

        /* Access modifiers changed, original: final */
        public final void zzb(Object obj) {
            AppMethodBeat.i(89996);
            zza zzd = zzd(obj);
            zzd.count++;
            AppMethodBeat.o(89996);
        }

        /* Access modifiers changed, original: final */
        public final void zzc(Object obj) {
            AppMethodBeat.i(89997);
            zza zzd = zzd(obj);
            zzd.count--;
            AppMethodBeat.o(89997);
        }
    }

    private ArrayUtils() {
    }

    public static int[] appendToArray(int[] iArr, int i) {
        AppMethodBeat.i(90021);
        int[] copyOf = (iArr == null || iArr.length == 0) ? new int[1] : Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i;
        AppMethodBeat.o(90021);
        return copyOf;
    }

    public static <T> T[] appendToArray(T[] tArr, T t) {
        AppMethodBeat.i(90020);
        if (tArr == null && t == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot generate array of generic type w/o class info");
            AppMethodBeat.o(90020);
            throw illegalArgumentException;
        }
        T[] copyOf = tArr == null ? (Object[]) Array.newInstance(t.getClass(), 1) : Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[copyOf.length - 1] = t;
        AppMethodBeat.o(90020);
        return copyOf;
    }

    public static <T> T[] concat(T[]... tArr) {
        AppMethodBeat.i(90018);
        if (tArr.length == 0) {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass(), 0);
            AppMethodBeat.o(90018);
            return objArr;
        }
        int i;
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        T[] length2 = Arrays.copyOf(tArr[0], i2);
        i2 = tArr[0].length;
        for (i = 1; i < tArr.length; i++) {
            Object obj = tArr[i];
            System.arraycopy(obj, 0, length2, i2, obj.length);
            i2 += obj.length;
        }
        AppMethodBeat.o(90018);
        return length2;
    }

    public static byte[] concatByteArrays(byte[]... bArr) {
        AppMethodBeat.i(90019);
        if (bArr.length == 0) {
            byte[] bArr2 = new byte[0];
            AppMethodBeat.o(90019);
            return bArr2;
        }
        int i;
        int i2 = 0;
        for (byte[] length : bArr) {
            i2 += length.length;
        }
        byte[] length2 = Arrays.copyOf(bArr[0], i2);
        i2 = bArr[0].length;
        for (i = 1; i < bArr.length; i++) {
            Object obj = bArr[i];
            System.arraycopy(obj, 0, length2, i2, obj.length);
            i2 += obj.length;
        }
        AppMethodBeat.o(90019);
        return length2;
    }

    public static boolean contains(byte[] bArr, byte b) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(double[] dArr, double d) {
        if (dArr == null) {
            return false;
        }
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(float[] fArr, float f, float f2) {
        if (fArr == null) {
            return false;
        }
        float f3 = f - f2;
        float f4 = f + f2;
        for (float f5 : fArr) {
            if (f3 <= f5 && f5 <= f4) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        AppMethodBeat.i(90000);
        if (indexOf(tArr, t) >= 0) {
            AppMethodBeat.o(90000);
            return true;
        }
        AppMethodBeat.o(90000);
        return false;
    }

    public static boolean contains(short[] sArr, short s) {
        if (sArr == null) {
            return false;
        }
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        if (zArr == null) {
            return false;
        }
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(String[] strArr, String str) {
        AppMethodBeat.i(90001);
        if (strArr == null) {
            AppMethodBeat.o(90001);
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (str2 == str) {
                AppMethodBeat.o(90001);
                return true;
            } else if (str2 == null || !str2.equalsIgnoreCase(str)) {
                i++;
            } else {
                AppMethodBeat.o(90001);
                return true;
            }
        }
        AppMethodBeat.o(90001);
        return false;
    }

    public static boolean equalsAnyOrder(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.i(90002);
        if (objArr == objArr2) {
            AppMethodBeat.o(90002);
            return true;
        }
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        if (length == 0 && length2 == 0) {
            AppMethodBeat.o(90002);
            return true;
        } else if (length != length2) {
            AppMethodBeat.o(90002);
            return false;
        } else {
            zza zza = new zza(length);
            for (Object zzb : objArr) {
                zza.zzb(zzb);
            }
            for (Object zzb2 : objArr2) {
                zza.zzc(zzb2);
            }
            for (zza zza2 : zza.zzzb.values()) {
                if (zza2.count != 0) {
                    AppMethodBeat.o(90002);
                    return false;
                }
            }
            AppMethodBeat.o(90002);
            return true;
        }
    }

    public static <T> int indexOf(T[] tArr, T t) {
        int i = 0;
        AppMethodBeat.i(89999);
        int length = tArr != null ? tArr.length : 0;
        while (i < length) {
            if (Objects.equal(tArr[i], t)) {
                AppMethodBeat.o(89999);
                return i;
            }
            i++;
        }
        AppMethodBeat.o(89999);
        return -1;
    }

    public static <T> ArrayList<T> newArrayList() {
        AppMethodBeat.i(90027);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(90027);
        return arrayList;
    }

    public static <T> int rearrange(T[] tArr, Predicate<T> predicate) {
        AppMethodBeat.i(90026);
        if (tArr == null || tArr.length == 0) {
            AppMethodBeat.o(90026);
            return 0;
        }
        int length = tArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.apply(tArr[i2])) {
                if (i != i2) {
                    T t = tArr[i];
                    tArr[i] = tArr[i2];
                    tArr[i2] = t;
                }
                i++;
            }
        }
        AppMethodBeat.o(90026);
        return i;
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        AppMethodBeat.i(90023);
        int[] copyOf;
        if (iArr == null) {
            AppMethodBeat.o(90023);
            return null;
        } else if (iArr2 == null || iArr2.length == 0) {
            copyOf = Arrays.copyOf(iArr, iArr.length);
            AppMethodBeat.o(90023);
            return copyOf;
        } else {
            int i;
            int[] iArr3 = new int[iArr.length];
            int length;
            int i2;
            int i3;
            if (iArr2.length == 1) {
                length = iArr.length;
                i2 = 0;
                i = 0;
                while (i2 < length) {
                    int i4 = iArr[i2];
                    if (iArr2[0] != i4) {
                        i3 = i + 1;
                        iArr3[i] = i4;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                length = iArr.length;
                i2 = 0;
                i = 0;
                while (i2 < length) {
                    int i5 = iArr[i2];
                    if (contains(iArr2, i5)) {
                        i3 = i;
                    } else {
                        i3 = i + 1;
                        iArr3[i] = i5;
                    }
                    i2++;
                    i = i3;
                }
            }
            copyOf = resize(iArr3, i);
            AppMethodBeat.o(90023);
            return copyOf;
        }
    }

    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        AppMethodBeat.i(90022);
        Object[] copyOf;
        if (tArr == null) {
            AppMethodBeat.o(90022);
            return null;
        } else if (tArr2 == null || tArr2.length == 0) {
            copyOf = Arrays.copyOf(tArr, tArr.length);
            AppMethodBeat.o(90022);
            return copyOf;
        } else {
            int i;
            copyOf = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
            int length;
            int i2;
            int i3;
            if (tArr2.length == 1) {
                length = tArr.length;
                i2 = 0;
                i = 0;
                while (i2 < length) {
                    Object obj = tArr[i2];
                    if (Objects.equal(tArr2[0], obj)) {
                        i3 = i;
                    } else {
                        i3 = i + 1;
                        copyOf[i] = obj;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                length = tArr.length;
                i2 = 0;
                i = 0;
                while (i2 < length) {
                    Object obj2 = tArr[i2];
                    if (contains((Object[]) tArr2, obj2)) {
                        i3 = i;
                    } else {
                        i3 = i + 1;
                        copyOf[i] = obj2;
                    }
                    i2++;
                    i = i3;
                }
            }
            copyOf = resize(copyOf, i);
            AppMethodBeat.o(90022);
            return copyOf;
        }
    }

    public static int[] resize(int[] iArr, int i) {
        AppMethodBeat.i(90025);
        if (iArr == null) {
            AppMethodBeat.o(90025);
            return null;
        }
        if (i != iArr.length) {
            iArr = Arrays.copyOf(iArr, i);
        }
        AppMethodBeat.o(90025);
        return iArr;
    }

    public static <T> T[] resize(T[] tArr, int i) {
        AppMethodBeat.i(90024);
        if (tArr == null) {
            AppMethodBeat.o(90024);
            return null;
        }
        if (i != tArr.length) {
            tArr = Arrays.copyOf(tArr, i);
        }
        AppMethodBeat.o(90024);
        return tArr;
    }

    public static <T> ArrayList<T> toArrayList(Collection<T> collection) {
        AppMethodBeat.i(90029);
        if (collection == null) {
            AppMethodBeat.o(90029);
            return null;
        }
        ArrayList arrayList = new ArrayList(collection);
        AppMethodBeat.o(90029);
        return arrayList;
    }

    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        AppMethodBeat.i(90028);
        ArrayList arrayList = new ArrayList(r1);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        AppMethodBeat.o(90028);
        return arrayList;
    }

    public static long[] toLongArray(Collection<Long> collection) {
        AppMethodBeat.i(90032);
        if (collection == null || collection.size() == 0) {
            long[] jArr = new long[0];
            AppMethodBeat.o(90032);
            return jArr;
        }
        long[] jArr2 = new long[collection.size()];
        int i = 0;
        for (Long longValue : collection) {
            int i2 = i + 1;
            jArr2[i] = longValue.longValue();
            i = i2;
        }
        AppMethodBeat.o(90032);
        return jArr2;
    }

    public static long[] toLongArray(Long[] lArr) {
        int i = 0;
        AppMethodBeat.i(90033);
        if (lArr == null) {
            long[] jArr = new long[0];
            AppMethodBeat.o(90033);
            return jArr;
        }
        long[] jArr2 = new long[lArr.length];
        while (i < lArr.length) {
            jArr2[i] = lArr[i].longValue();
            i++;
        }
        AppMethodBeat.o(90033);
        return jArr2;
    }

    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        AppMethodBeat.i(90030);
        if (collection == null || collection.size() == 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(90030);
            return iArr;
        }
        int[] iArr2 = new int[collection.size()];
        int i = 0;
        for (Integer intValue : collection) {
            int i2 = i + 1;
            iArr2[i] = intValue.intValue();
            i = i2;
        }
        AppMethodBeat.o(90030);
        return iArr2;
    }

    public static int[] toPrimitiveArray(Integer[] numArr) {
        int i = 0;
        AppMethodBeat.i(90031);
        if (numArr == null) {
            int[] iArr = new int[0];
            AppMethodBeat.o(90031);
            return iArr;
        }
        int[] iArr2 = new int[numArr.length];
        while (i < numArr.length) {
            iArr2[i] = numArr[i].intValue();
            i++;
        }
        AppMethodBeat.o(90031);
        return iArr2;
    }

    public static String[] toStringArray(Collection<String> collection) {
        AppMethodBeat.i(90034);
        String[] strArr;
        if (collection == null || collection.size() == 0) {
            strArr = new String[0];
            AppMethodBeat.o(90034);
            return strArr;
        }
        strArr = (String[]) collection.toArray(new String[collection.size()]);
        AppMethodBeat.o(90034);
        return strArr;
    }

    public static Boolean[] toWrapperArray(boolean[] zArr) {
        AppMethodBeat.i(90009);
        if (zArr == null) {
            AppMethodBeat.o(90009);
            return null;
        }
        int length = zArr.length;
        Boolean[] boolArr = new Boolean[length];
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        AppMethodBeat.o(90009);
        return boolArr;
    }

    public static Byte[] toWrapperArray(byte[] bArr) {
        AppMethodBeat.i(90008);
        if (bArr == null) {
            AppMethodBeat.o(90008);
            return null;
        }
        int length = bArr.length;
        Byte[] bArr2 = new Byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        AppMethodBeat.o(90008);
        return bArr2;
    }

    public static Character[] toWrapperArray(char[] cArr) {
        AppMethodBeat.i(90004);
        if (cArr == null) {
            AppMethodBeat.o(90004);
            return null;
        }
        int length = cArr.length;
        Character[] chArr = new Character[length];
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        AppMethodBeat.o(90004);
        return chArr;
    }

    public static Double[] toWrapperArray(double[] dArr) {
        AppMethodBeat.i(90006);
        if (dArr == null) {
            AppMethodBeat.o(90006);
            return null;
        }
        int length = dArr.length;
        Double[] dArr2 = new Double[length];
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        AppMethodBeat.o(90006);
        return dArr2;
    }

    public static Float[] toWrapperArray(float[] fArr) {
        AppMethodBeat.i(90007);
        if (fArr == null) {
            AppMethodBeat.o(90007);
            return null;
        }
        int length = fArr.length;
        Float[] fArr2 = new Float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        AppMethodBeat.o(90007);
        return fArr2;
    }

    public static Integer[] toWrapperArray(int[] iArr) {
        AppMethodBeat.i(90003);
        if (iArr == null) {
            AppMethodBeat.o(90003);
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        AppMethodBeat.o(90003);
        return numArr;
    }

    public static Long[] toWrapperArray(long[] jArr) {
        AppMethodBeat.i(90005);
        if (jArr == null) {
            AppMethodBeat.o(90005);
            return null;
        }
        int length = jArr.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        AppMethodBeat.o(90005);
        return lArr;
    }

    public static Short[] toWrapperArray(short[] sArr) {
        AppMethodBeat.i(90010);
        if (sArr == null) {
            AppMethodBeat.o(90010);
            return null;
        }
        int length = sArr.length;
        Short[] shArr = new Short[length];
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        AppMethodBeat.o(90010);
        return shArr;
    }

    public static void writeArray(StringBuilder stringBuilder, double[] dArr) {
        AppMethodBeat.i(90015);
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
        AppMethodBeat.o(90015);
    }

    public static void writeArray(StringBuilder stringBuilder, float[] fArr) {
        AppMethodBeat.i(90014);
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
        AppMethodBeat.o(90014);
    }

    public static void writeArray(StringBuilder stringBuilder, int[] iArr) {
        AppMethodBeat.i(90012);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toString(iArr[i]));
        }
        AppMethodBeat.o(90012);
    }

    public static void writeArray(StringBuilder stringBuilder, long[] jArr) {
        AppMethodBeat.i(90013);
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
        AppMethodBeat.o(90013);
    }

    public static <T> void writeArray(StringBuilder stringBuilder, T[] tArr) {
        AppMethodBeat.i(90011);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(tArr[i].toString());
        }
        AppMethodBeat.o(90011);
    }

    public static void writeArray(StringBuilder stringBuilder, boolean[] zArr) {
        AppMethodBeat.i(90016);
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
        AppMethodBeat.o(90016);
    }

    public static void writeStringArray(StringBuilder stringBuilder, String[] strArr) {
        AppMethodBeat.i(90017);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"").append(strArr[i]).append("\"");
        }
        AppMethodBeat.o(90017);
    }
}
