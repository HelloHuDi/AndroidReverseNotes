package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FieldMapPairCreator implements Creator<FieldMapPair> {
    public static final int CONTENT_DESCRIPTION = 0;

    public FieldMapPair createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61556);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        Field field = null;
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
                case 3:
                    field = (Field) SafeParcelReader.createParcelable(parcel, readHeader, Field.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        FieldMapPair fieldMapPair = new FieldMapPair(i, str, field);
        AppMethodBeat.m2505o(61556);
        return fieldMapPair;
    }

    public FieldMapPair[] newArray(int i) {
        return new FieldMapPair[i];
    }
}
