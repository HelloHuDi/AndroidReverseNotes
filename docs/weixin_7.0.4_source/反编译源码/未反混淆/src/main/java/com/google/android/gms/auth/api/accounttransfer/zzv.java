package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class zzv implements Creator<zzu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.i(77023);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        zzw zzw = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    zzw zzw2 = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    zzw = zzw2;
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            ParseException parseException = new ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
            AppMethodBeat.o(77023);
            throw parseException;
        }
        zzu zzu = new zzu(hashSet, i, zzw, str2, str);
        AppMethodBeat.o(77023);
        return zzu;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
