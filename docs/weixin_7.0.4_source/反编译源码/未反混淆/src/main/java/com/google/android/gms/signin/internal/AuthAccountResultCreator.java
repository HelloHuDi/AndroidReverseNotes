package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthAccountResultCreator implements Creator<AuthAccountResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    public AuthAccountResult createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61654);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Intent intent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    intent = (Intent) SafeParcelReader.createParcelable(parcel, readHeader, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AuthAccountResult authAccountResult = new AuthAccountResult(i2, i, intent);
        AppMethodBeat.o(61654);
        return authAccountResult;
    }

    public AuthAccountResult[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
