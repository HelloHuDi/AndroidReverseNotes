package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClientIdentityCreator implements Creator<ClientIdentity> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ClientIdentity createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61313);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ClientIdentity clientIdentity = new ClientIdentity(i, str);
        AppMethodBeat.o(61313);
        return clientIdentity;
    }

    public ClientIdentity[] newArray(int i) {
        return new ClientIdentity[i];
    }
}
