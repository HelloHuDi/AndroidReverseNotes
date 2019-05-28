package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SafeParcelResponseCreator implements Creator<SafeParcelResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    public SafeParcelResponse createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61623);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        FieldMappingDictionary fieldMappingDictionary = null;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    parcel2 = SafeParcelReader.createParcel(parcel, readHeader);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) SafeParcelReader.createParcelable(parcel, readHeader, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SafeParcelResponse safeParcelResponse = new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        AppMethodBeat.m2505o(61623);
        return safeParcelResponse;
    }

    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
