package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class FieldMappingDictionaryCreator implements Creator<FieldMappingDictionary> {
    public static final int CONTENT_DESCRIPTION = 0;

    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61575);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String str = null;
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
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(i, arrayList, str);
        AppMethodBeat.o(61575);
        return fieldMappingDictionary;
    }

    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
