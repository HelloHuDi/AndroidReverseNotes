package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

public final class zzp implements Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(77010);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        zzr zzr = null;
        int i = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    zzr zzr2 = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    zzr = zzr2;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            ParseException parseException = new ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
            AppMethodBeat.m2505o(77010);
            throw parseException;
        }
        zzo zzo = new zzo(hashSet, i2, arrayList, i, zzr);
        AppMethodBeat.m2505o(77010);
        return zzo;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
