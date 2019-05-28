package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class StringToIntConverterCreator implements Creator<StringToIntConverter> {
    public static final int CONTENT_DESCRIPTION = 0;

    public StringToIntConverter createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61459);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, Entry.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        StringToIntConverter stringToIntConverter = new StringToIntConverter(i, arrayList);
        AppMethodBeat.m2505o(61459);
        return stringToIntConverter;
    }

    public StringToIntConverter[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
