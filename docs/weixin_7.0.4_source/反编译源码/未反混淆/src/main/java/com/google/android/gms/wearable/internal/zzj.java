package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzj implements Creator<zzi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.i(71448);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    b2 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 3:
                    b = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzi zzi = new zzi(b2, b, str);
        AppMethodBeat.o(71448);
        return zzi;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}
