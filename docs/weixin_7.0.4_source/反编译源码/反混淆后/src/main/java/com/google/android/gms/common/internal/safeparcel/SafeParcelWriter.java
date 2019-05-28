package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        AppMethodBeat.m2504i(89794);
        int zza = zza(parcel, 20293);
        AppMethodBeat.m2505o(89794);
        return zza;
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89795);
        zzb(parcel, i);
        AppMethodBeat.m2505o(89795);
    }

    public static void writeBigDecimal(Parcel parcel, int i, BigDecimal bigDecimal, boolean z) {
        AppMethodBeat.m2504i(89810);
        if (bigDecimal == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89810);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89810);
    }

    public static void writeBigDecimalArray(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89824);
        if (bigDecimalArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89824);
            return;
        }
        int zza = zza(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        while (i2 < length) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
            i2++;
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89824);
    }

    public static void writeBigInteger(Parcel parcel, int i, BigInteger bigInteger, boolean z) {
        AppMethodBeat.m2504i(89805);
        if (bigInteger == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89805);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeByteArray(bigInteger.toByteArray());
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89805);
    }

    public static void writeBigIntegerArray(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89821);
        if (bigIntegerArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89821);
            return;
        }
        int zza = zza(parcel, i);
        int length = bigIntegerArr.length;
        parcel.writeInt(length);
        while (i2 < length) {
            parcel.writeByteArray(bigIntegerArr[i2].toByteArray());
            i2++;
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89821);
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z) {
        AppMethodBeat.m2504i(89796);
        zzb(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.m2505o(89796);
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z) {
        AppMethodBeat.m2504i(89817);
        if (zArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89817);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeBooleanArray(zArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89817);
    }

    public static void writeBooleanList(Parcel parcel, int i, List<Boolean> list, boolean z) {
        AppMethodBeat.m2504i(89827);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89827);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(((Boolean) list.get(i2)).booleanValue() ? 1 : 0);
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89827);
    }

    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89797);
        if (bool == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89797);
            return;
        }
        zzb(parcel, i, 4);
        if (bool.booleanValue()) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        AppMethodBeat.m2505o(89797);
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(89814);
        if (bundle == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89814);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeBundle(bundle);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89814);
    }

    public static void writeByte(Parcel parcel, int i, byte b) {
        AppMethodBeat.m2504i(89798);
        zzb(parcel, i, 4);
        parcel.writeInt(b);
        AppMethodBeat.m2505o(89798);
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(89815);
        if (bArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89815);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeByteArray(bArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89815);
    }

    public static void writeByteArrayArray(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89816);
        if (bArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89816);
            return;
        }
        int zza = zza(parcel, i);
        int length = bArr.length;
        parcel.writeInt(length);
        while (i2 < length) {
            parcel.writeByteArray(bArr[i2]);
            i2++;
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89816);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i, SparseArray<byte[]> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89850);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89850);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeByteArray((byte[]) sparseArray.valueAt(i2));
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89850);
    }

    public static void writeChar(Parcel parcel, int i, char c) {
        AppMethodBeat.m2504i(89799);
        zzb(parcel, i, 4);
        parcel.writeInt(c);
        AppMethodBeat.m2505o(89799);
    }

    public static void writeCharArray(Parcel parcel, int i, char[] cArr, boolean z) {
        AppMethodBeat.m2504i(89818);
        if (cArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89818);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeCharArray(cArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89818);
    }

    public static void writeDouble(Parcel parcel, int i, double d) {
        AppMethodBeat.m2504i(89808);
        zzb(parcel, i, 8);
        parcel.writeDouble(d);
        AppMethodBeat.m2505o(89808);
    }

    public static void writeDoubleArray(Parcel parcel, int i, double[] dArr, boolean z) {
        AppMethodBeat.m2504i(89823);
        if (dArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89823);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeDoubleArray(dArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89823);
    }

    public static void writeDoubleList(Parcel parcel, int i, List<Double> list, boolean z) {
        AppMethodBeat.m2504i(89831);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89831);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeDouble(((Double) list.get(i2)).doubleValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89831);
    }

    public static void writeDoubleObject(Parcel parcel, int i, Double d, boolean z) {
        AppMethodBeat.m2504i(89809);
        if (d == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89809);
            return;
        }
        zzb(parcel, i, 8);
        parcel.writeDouble(d.doubleValue());
        AppMethodBeat.m2505o(89809);
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i, SparseArray<Double> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89842);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89842);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeDouble(((Double) sparseArray.valueAt(i2)).doubleValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89842);
    }

    public static void writeFloat(Parcel parcel, int i, float f) {
        AppMethodBeat.m2504i(89806);
        zzb(parcel, i, 4);
        parcel.writeFloat(f);
        AppMethodBeat.m2505o(89806);
    }

    public static void writeFloatArray(Parcel parcel, int i, float[] fArr, boolean z) {
        AppMethodBeat.m2504i(89822);
        if (fArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89822);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeFloatArray(fArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89822);
    }

    public static void writeFloatList(Parcel parcel, int i, List<Float> list, boolean z) {
        AppMethodBeat.m2504i(89830);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89830);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeFloat(((Float) list.get(i2)).floatValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89830);
    }

    public static void writeFloatObject(Parcel parcel, int i, Float f, boolean z) {
        AppMethodBeat.m2504i(89807);
        if (f == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89807);
            return;
        }
        zzb(parcel, i, 4);
        parcel.writeFloat(f.floatValue());
        AppMethodBeat.m2505o(89807);
    }

    public static void writeFloatSparseArray(Parcel parcel, int i, SparseArray<Float> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89843);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89843);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeFloat(((Float) sparseArray.valueAt(i2)).floatValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89843);
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z) {
        AppMethodBeat.m2504i(89812);
        if (iBinder == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89812);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeStrongBinder(iBinder);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89812);
    }

    public static void writeIBinderArray(Parcel parcel, int i, IBinder[] iBinderArr, boolean z) {
        AppMethodBeat.m2504i(89826);
        if (iBinderArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89826);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeBinderArray(iBinderArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89826);
    }

    public static void writeIBinderList(Parcel parcel, int i, List<IBinder> list, boolean z) {
        AppMethodBeat.m2504i(89833);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89833);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeBinderList(list);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89833);
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i, SparseArray<IBinder> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89849);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89849);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeStrongBinder((IBinder) sparseArray.valueAt(i2));
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89849);
    }

    public static void writeInt(Parcel parcel, int i, int i2) {
        AppMethodBeat.m2504i(89801);
        zzb(parcel, i, 4);
        parcel.writeInt(i2);
        AppMethodBeat.m2505o(89801);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        AppMethodBeat.m2504i(89819);
        if (iArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89819);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeIntArray(iArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89819);
    }

    public static void writeIntegerList(Parcel parcel, int i, List<Integer> list, boolean z) {
        AppMethodBeat.m2504i(89828);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89828);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(((Integer) list.get(i2)).intValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89828);
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z) {
        AppMethodBeat.m2504i(89802);
        if (num == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89802);
            return;
        }
        zzb(parcel, i, 4);
        parcel.writeInt(num.intValue());
        AppMethodBeat.m2505o(89802);
    }

    public static void writeList(Parcel parcel, int i, List list, boolean z) {
        AppMethodBeat.m2504i(89840);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89840);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeList(list);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89840);
    }

    public static void writeLong(Parcel parcel, int i, long j) {
        AppMethodBeat.m2504i(89803);
        zzb(parcel, i, 8);
        parcel.writeLong(j);
        AppMethodBeat.m2505o(89803);
    }

    public static void writeLongArray(Parcel parcel, int i, long[] jArr, boolean z) {
        AppMethodBeat.m2504i(89820);
        if (jArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89820);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeLongArray(jArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89820);
    }

    public static void writeLongList(Parcel parcel, int i, List<Long> list, boolean z) {
        AppMethodBeat.m2504i(89829);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89829);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeLong(((Long) list.get(i2)).longValue());
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89829);
    }

    public static void writeLongObject(Parcel parcel, int i, Long l, boolean z) {
        AppMethodBeat.m2504i(89804);
        if (l == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89804);
            return;
        }
        zzb(parcel, i, 8);
        parcel.writeLong(l.longValue());
        AppMethodBeat.m2505o(89804);
    }

    public static void writeParcel(Parcel parcel, int i, Parcel parcel2, boolean z) {
        AppMethodBeat.m2504i(89837);
        if (parcel2 == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89837);
            return;
        }
        int zza = zza(parcel, i);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89837);
    }

    public static void writeParcelArray(Parcel parcel, int i, Parcel[] parcelArr, boolean z) {
        AppMethodBeat.m2504i(89838);
        if (parcelArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89838);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeInt(r3);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89838);
    }

    public static void writeParcelList(Parcel parcel, int i, List<Parcel> list, boolean z) {
        AppMethodBeat.m2504i(89839);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89839);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcel parcel2 = (Parcel) list.get(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89839);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i, SparseArray<Parcel> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89847);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89847);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            Parcel parcel2 = (Parcel) sparseArray.valueAt(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89847);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        AppMethodBeat.m2504i(89813);
        if (parcelable == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89813);
            return;
        }
        int zza = zza(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89813);
    }

    public static void writeShort(Parcel parcel, int i, short s) {
        AppMethodBeat.m2504i(89800);
        zzb(parcel, i, 4);
        parcel.writeInt(s);
        AppMethodBeat.m2505o(89800);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        AppMethodBeat.m2504i(89841);
        if (sparseBooleanArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89841);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89841);
    }

    public static void writeSparseIntArray(Parcel parcel, int i, SparseIntArray sparseIntArray, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89844);
        if (sparseIntArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89844);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeInt(sparseIntArray.keyAt(i2));
            parcel.writeInt(sparseIntArray.valueAt(i2));
            i2++;
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89844);
    }

    public static void writeSparseLongArray(Parcel parcel, int i, SparseLongArray sparseLongArray, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(89845);
        if (sparseLongArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89845);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeInt(sparseLongArray.keyAt(i2));
            parcel.writeLong(sparseLongArray.valueAt(i2));
            i2++;
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89845);
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        AppMethodBeat.m2504i(89811);
        if (str == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89811);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeString(str);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89811);
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z) {
        AppMethodBeat.m2504i(89825);
        if (strArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89825);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeStringArray(strArr);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89825);
    }

    public static void writeStringList(Parcel parcel, int i, List<String> list, boolean z) {
        AppMethodBeat.m2504i(89832);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89832);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeStringList(list);
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89832);
    }

    public static void writeStringSparseArray(Parcel parcel, int i, SparseArray<String> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89846);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89846);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeString((String) sparseArray.valueAt(i2));
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89846);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        AppMethodBeat.m2504i(89834);
        if (tArr == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89834);
            return;
        }
        int zza = zza(parcel, i);
        parcel.writeInt(r3);
        for (Parcelable parcelable : tArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, parcelable, i2);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89834);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i, List<T> list, boolean z) {
        AppMethodBeat.m2504i(89835);
        if (list == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89835);
            return;
        }
        int zza = zza(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, parcelable, 0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89835);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i, SparseArray<T> sparseArray, boolean z) {
        AppMethodBeat.m2504i(89848);
        if (sparseArray == null) {
            if (z) {
                zzb(parcel, i, 0);
            }
            AppMethodBeat.m2505o(89848);
            return;
        }
        int zza = zza(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            Parcelable parcelable = (Parcelable) sparseArray.valueAt(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zza(parcel, parcelable, 0);
            }
        }
        zzb(parcel, zza);
        AppMethodBeat.m2505o(89848);
    }

    private static int zza(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89792);
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        int dataPosition = parcel.dataPosition();
        AppMethodBeat.m2505o(89792);
        return dataPosition;
    }

    private static <T extends Parcelable> void zza(Parcel parcel, T t, int i) {
        AppMethodBeat.m2504i(89836);
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
        AppMethodBeat.m2505o(89836);
    }

    private static void zzb(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89793);
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
        AppMethodBeat.m2505o(89793);
    }

    private static void zzb(Parcel parcel, int i, int i2) {
        AppMethodBeat.m2504i(89791);
        if (i2 >= CdnLogic.kBizGeneric) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            AppMethodBeat.m2505o(89791);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
        AppMethodBeat.m2505o(89791);
    }
}
