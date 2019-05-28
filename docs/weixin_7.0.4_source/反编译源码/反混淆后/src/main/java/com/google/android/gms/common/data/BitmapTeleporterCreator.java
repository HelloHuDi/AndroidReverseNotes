package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BitmapTeleporterCreator implements Creator<BitmapTeleporter> {
    public static final int CONTENT_DESCRIPTION = 0;

    public BitmapTeleporter createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61017);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, readHeader, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        BitmapTeleporter bitmapTeleporter = new BitmapTeleporter(i2, parcelFileDescriptor, i);
        AppMethodBeat.m2505o(61017);
        return bitmapTeleporter;
    }

    public BitmapTeleporter[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
