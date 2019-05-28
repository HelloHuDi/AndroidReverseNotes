package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FieldCreator implements Creator<Field> {
    public static final int CONTENT_DESCRIPTION = 0;

    public Field createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61553);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ConverterWrapper converterWrapper = null;
        String str = null;
        int i = 0;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) SafeParcelReader.createParcelable(parcel, readHeader, ConverterWrapper.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        Field field = new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        AppMethodBeat.m2505o(61553);
        return field;
    }

    public Field[] newArray(int i) {
        return new Field[i];
    }
}
