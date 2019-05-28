package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ValidateAccountRequestCreator implements Creator<ValidateAccountRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(89725);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest(i);
        AppMethodBeat.m2505o(89725);
        return validateAccountRequest;
    }

    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
