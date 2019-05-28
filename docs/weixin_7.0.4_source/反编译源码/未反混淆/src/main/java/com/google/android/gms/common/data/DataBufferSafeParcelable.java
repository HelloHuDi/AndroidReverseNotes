package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder.Builder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    public static final String DATA_FIELD = "data";
    private static final String[] zznk = new String[]{"data"};
    private final Creator<T> zznl;

    public DataBufferSafeParcelable(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zznl = creator;
    }

    public static <T extends SafeParcelable> void addValue(Builder builder, T t) {
        AppMethodBeat.i(61066);
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
        AppMethodBeat.o(61066);
    }

    public static Builder buildDataHolder() {
        AppMethodBeat.i(61065);
        Builder builder = DataHolder.builder(zznk);
        AppMethodBeat.o(61065);
        return builder;
    }

    public T get(int i) {
        AppMethodBeat.i(61067);
        byte[] byteArray = this.mDataHolder.getByteArray("data", i, this.mDataHolder.getWindowIndex(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zznl.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(61067);
        return safeParcelable;
    }
}
