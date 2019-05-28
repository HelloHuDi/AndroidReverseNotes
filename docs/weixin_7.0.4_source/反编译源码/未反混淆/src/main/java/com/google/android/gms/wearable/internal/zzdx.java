package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdx implements Creator<zzdw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.i(71231);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        ConnectionConfiguration connectionConfiguration = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    connectionConfiguration = (ConnectionConfiguration) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzdw zzdw = new zzdw(i, connectionConfiguration);
        AppMethodBeat.o(71231);
        return zzdw;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdw[i];
    }
}
