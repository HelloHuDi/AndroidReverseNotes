package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
            AppMethodBeat.i(89729);
            AppMethodBeat.o(89729);
        }
    }

    private SafeParcelReader() {
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i) {
        AppMethodBeat.i(89750);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89750);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        BigDecimal bigDecimal = new BigDecimal(new BigInteger(createByteArray), readInt);
        AppMethodBeat.o(89750);
        return bigDecimal;
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i) {
        AppMethodBeat.i(89764);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89764);
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89764);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i) {
        AppMethodBeat.i(89745);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89745);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        BigInteger bigInteger = new BigInteger(createByteArray);
        AppMethodBeat.o(89745);
        return bigInteger;
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i) {
        AppMethodBeat.i(89761);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89761);
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89761);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i) {
        AppMethodBeat.i(89757);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89757);
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89757);
        return createBooleanArray;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel parcel, int i) {
        AppMethodBeat.i(89767);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89767);
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89767);
        return arrayList;
    }

    public static Bundle createBundle(Parcel parcel, int i) {
        AppMethodBeat.i(89754);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89754);
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89754);
        return readBundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i) {
        AppMethodBeat.i(89755);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89755);
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89755);
        return createByteArray;
    }

    public static byte[][] createByteArrayArray(Parcel parcel, int i) {
        AppMethodBeat.i(89756);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89756);
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89756);
        return bArr;
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89778);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89778);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray sparseArray = new SparseArray(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89778);
        return sparseArray;
    }

    public static char[] createCharArray(Parcel parcel, int i) {
        AppMethodBeat.i(89758);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89758);
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89758);
        return createCharArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i) {
        AppMethodBeat.i(89763);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89763);
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89763);
        return createDoubleArray;
    }

    public static ArrayList<Double> createDoubleList(Parcel parcel, int i) {
        AppMethodBeat.i(89781);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89781);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89781);
        return arrayList;
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89772);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89772);
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89772);
        return sparseArray;
    }

    public static float[] createFloatArray(Parcel parcel, int i) {
        AppMethodBeat.i(89762);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89762);
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89762);
        return createFloatArray;
    }

    public static ArrayList<Float> createFloatList(Parcel parcel, int i) {
        AppMethodBeat.i(89780);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89780);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89780);
        return arrayList;
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89771);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89771);
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89771);
        return sparseArray;
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int i) {
        AppMethodBeat.i(89766);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89766);
            return null;
        }
        IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89766);
        return createBinderArray;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel parcel, int i) {
        AppMethodBeat.i(89783);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89783);
            return null;
        }
        ArrayList createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89783);
        return createBinderArrayList;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89777);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89777);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray sparseArray = new SparseArray(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89777);
        return sparseArray;
    }

    public static int[] createIntArray(Parcel parcel, int i) {
        AppMethodBeat.i(89759);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89759);
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89759);
        return createIntArray;
    }

    public static ArrayList<Integer> createIntegerList(Parcel parcel, int i) {
        AppMethodBeat.i(89768);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89768);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89768);
        return arrayList;
    }

    public static long[] createLongArray(Parcel parcel, int i) {
        AppMethodBeat.i(89760);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89760);
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89760);
        return createLongArray;
    }

    public static ArrayList<Long> createLongList(Parcel parcel, int i) {
        AppMethodBeat.i(89779);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89779);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89779);
        return arrayList;
    }

    public static Parcel createParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89786);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89786);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89786);
        return obtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i) {
        AppMethodBeat.i(89787);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89787);
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89787);
        return parcelArr;
    }

    public static ArrayList<Parcel> createParcelList(Parcel parcel, int i) {
        AppMethodBeat.i(89788);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89788);
            return null;
        }
        int readInt = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                arrayList.add(null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89788);
        return arrayList;
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89775);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89775);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89775);
        return sparseArray;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int i, Creator<T> creator) {
        AppMethodBeat.i(89753);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89753);
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89753);
        return parcelable;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int i) {
        AppMethodBeat.i(89769);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89769);
            return null;
        }
        SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89769);
        return readSparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int i) {
        AppMethodBeat.i(89770);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89770);
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89770);
        return sparseIntArray;
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int i) {
        AppMethodBeat.i(89773);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89773);
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89773);
        return sparseLongArray;
    }

    public static String createString(Parcel parcel, int i) {
        AppMethodBeat.i(89751);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89751);
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89751);
        return readString;
    }

    public static String[] createStringArray(Parcel parcel, int i) {
        AppMethodBeat.i(89765);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89765);
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89765);
        return createStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i) {
        AppMethodBeat.i(89782);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89782);
            return null;
        }
        ArrayList createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89782);
        return createStringArrayList;
    }

    public static SparseArray<String> createStringSparseArray(Parcel parcel, int i) {
        AppMethodBeat.i(89774);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89774);
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89774);
        return sparseArray;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int i, Creator<T> creator) {
        AppMethodBeat.i(89784);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89784);
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89784);
        return createTypedArray;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int i, Creator<T> creator) {
        AppMethodBeat.i(89785);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89785);
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89785);
        return createTypedArrayList;
    }

    public static <T> SparseArray<T> createTypedSparseArray(Parcel parcel, int i, Creator<T> creator) {
        AppMethodBeat.i(89776);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89776);
            return null;
        }
        int readInt = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        AppMethodBeat.o(89776);
        return sparseArray;
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        AppMethodBeat.i(89790);
        if (parcel.dataPosition() != i) {
            ParseException parseException = new ParseException("Overread allowed size end=" + i, parcel);
            AppMethodBeat.o(89790);
            throw parseException;
        }
        AppMethodBeat.o(89790);
    }

    public static int getFieldId(int i) {
        return CdnLogic.kBizGeneric & i;
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        AppMethodBeat.i(89736);
        zza(parcel, i, 4);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(89736);
            return true;
        }
        AppMethodBeat.o(89736);
        return false;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i) {
        AppMethodBeat.i(89737);
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            AppMethodBeat.o(89737);
            return null;
        }
        zza(parcel, i, readSize, 4);
        Boolean valueOf = Boolean.valueOf(parcel.readInt() != 0);
        AppMethodBeat.o(89737);
        return valueOf;
    }

    public static byte readByte(Parcel parcel, int i) {
        AppMethodBeat.i(89738);
        zza(parcel, i, 4);
        byte readInt = (byte) parcel.readInt();
        AppMethodBeat.o(89738);
        return readInt;
    }

    public static char readChar(Parcel parcel, int i) {
        AppMethodBeat.i(89739);
        zza(parcel, i, 4);
        char readInt = (char) parcel.readInt();
        AppMethodBeat.o(89739);
        return readInt;
    }

    public static double readDouble(Parcel parcel, int i) {
        AppMethodBeat.i(89748);
        zza(parcel, i, 8);
        double readDouble = parcel.readDouble();
        AppMethodBeat.o(89748);
        return readDouble;
    }

    public static Double readDoubleObject(Parcel parcel, int i) {
        AppMethodBeat.i(89749);
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            AppMethodBeat.o(89749);
            return null;
        }
        zza(parcel, i, readSize, 8);
        Double valueOf = Double.valueOf(parcel.readDouble());
        AppMethodBeat.o(89749);
        return valueOf;
    }

    public static float readFloat(Parcel parcel, int i) {
        AppMethodBeat.i(89746);
        zza(parcel, i, 4);
        float readFloat = parcel.readFloat();
        AppMethodBeat.o(89746);
        return readFloat;
    }

    public static Float readFloatObject(Parcel parcel, int i) {
        AppMethodBeat.i(89747);
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            AppMethodBeat.o(89747);
            return null;
        }
        zza(parcel, i, readSize, 4);
        Float valueOf = Float.valueOf(parcel.readFloat());
        AppMethodBeat.o(89747);
        return valueOf;
    }

    public static int readHeader(Parcel parcel) {
        AppMethodBeat.i(89730);
        int readInt = parcel.readInt();
        AppMethodBeat.o(89730);
        return readInt;
    }

    public static IBinder readIBinder(Parcel parcel, int i) {
        AppMethodBeat.i(89752);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89752);
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89752);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int i) {
        AppMethodBeat.i(89741);
        zza(parcel, i, 4);
        int readInt = parcel.readInt();
        AppMethodBeat.o(89741);
        return readInt;
    }

    public static Integer readIntegerObject(Parcel parcel, int i) {
        AppMethodBeat.i(89742);
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            AppMethodBeat.o(89742);
            return null;
        }
        zza(parcel, i, readSize, 4);
        Integer valueOf = Integer.valueOf(parcel.readInt());
        AppMethodBeat.o(89742);
        return valueOf;
    }

    public static void readList(Parcel parcel, int i, List list, ClassLoader classLoader) {
        AppMethodBeat.i(89789);
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            AppMethodBeat.o(89789);
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(readSize + dataPosition);
        AppMethodBeat.o(89789);
    }

    public static long readLong(Parcel parcel, int i) {
        AppMethodBeat.i(89743);
        zza(parcel, i, 8);
        long readLong = parcel.readLong();
        AppMethodBeat.o(89743);
        return readLong;
    }

    public static Long readLongObject(Parcel parcel, int i) {
        AppMethodBeat.i(89744);
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            AppMethodBeat.o(89744);
            return null;
        }
        zza(parcel, i, readSize, 8);
        Long valueOf = Long.valueOf(parcel.readLong());
        AppMethodBeat.o(89744);
        return valueOf;
    }

    public static short readShort(Parcel parcel, int i) {
        AppMethodBeat.i(89740);
        zza(parcel, i, 4);
        short readInt = (short) parcel.readInt();
        AppMethodBeat.o(89740);
        return readInt;
    }

    public static int readSize(Parcel parcel, int i) {
        AppMethodBeat.i(89731);
        int i2;
        if ((i & -65536) != -65536) {
            i2 = (i >> 16) & CdnLogic.kBizGeneric;
            AppMethodBeat.o(89731);
            return i2;
        }
        i2 = parcel.readInt();
        AppMethodBeat.o(89731);
        return i2;
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        AppMethodBeat.i(89732);
        parcel.setDataPosition(readSize(parcel, i) + parcel.dataPosition());
        AppMethodBeat.o(89732);
    }

    public static int validateObjectHeader(Parcel parcel) {
        AppMethodBeat.i(89735);
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        ParseException parseException;
        if (getFieldId(readHeader) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(readHeader));
            parseException = new ParseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
            AppMethodBeat.o(89735);
            throw parseException;
        }
        readHeader = dataPosition + readSize;
        if (readHeader < dataPosition || readHeader > parcel.dataSize()) {
            parseException = new ParseException("Size read is invalid start=" + dataPosition + " end=" + readHeader, parcel);
            AppMethodBeat.o(89735);
            throw parseException;
        }
        AppMethodBeat.o(89735);
        return readHeader;
    }

    private static void zza(Parcel parcel, int i, int i2) {
        AppMethodBeat.i(89733);
        int readSize = readSize(parcel, i);
        if (readSize != i2) {
            String toHexString = Integer.toHexString(readSize);
            ParseException parseException = new ParseException(new StringBuilder(String.valueOf(toHexString).length() + 46).append("Expected size ").append(i2).append(" got ").append(readSize).append(" (0x").append(toHexString).append(")").toString(), parcel);
            AppMethodBeat.o(89733);
            throw parseException;
        }
        AppMethodBeat.o(89733);
    }

    private static void zza(Parcel parcel, int i, int i2, int i3) {
        AppMethodBeat.i(89734);
        if (i2 != i3) {
            String toHexString = Integer.toHexString(i2);
            ParseException parseException = new ParseException(new StringBuilder(String.valueOf(toHexString).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(toHexString).append(")").toString(), parcel);
            AppMethodBeat.o(89734);
            throw parseException;
        }
        AppMethodBeat.o(89734);
    }
}
