package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConverterWrapperCreator implements Creator<ConverterWrapper> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ConverterWrapper createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61445);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) SafeParcelReader.createParcelable(parcel, readHeader, StringToIntConverter.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ConverterWrapper converterWrapper = new ConverterWrapper(i, stringToIntConverter);
        AppMethodBeat.m2505o(61445);
        return converterWrapper;
    }

    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
