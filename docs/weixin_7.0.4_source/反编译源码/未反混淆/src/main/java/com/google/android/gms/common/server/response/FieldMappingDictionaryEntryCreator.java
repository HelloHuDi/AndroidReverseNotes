package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class FieldMappingDictionaryEntryCreator implements Creator<Entry> {
    public static final int CONTENT_DESCRIPTION = 0;

    public Entry createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61578);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        ArrayList arrayList = null;
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
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, FieldMapPair.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        Entry entry = new Entry(i, str, arrayList);
        AppMethodBeat.o(61578);
        return entry;
    }

    public Entry[] newArray(int i) {
        return new Entry[i];
    }
}
