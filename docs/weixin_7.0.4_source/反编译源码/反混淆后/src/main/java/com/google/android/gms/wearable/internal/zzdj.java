package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzdj implements Creator<zzdi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(71210);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    list = SafeParcelReader.createTypedList(parcel, readHeader, zzah.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzdi zzdi = new zzdi(i, list);
        AppMethodBeat.m2505o(71210);
        return zzdi;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdi[i];
    }
}
