package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzf implements Creator<AccountChangeEventsResponse> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(77056);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    list = SafeParcelReader.createTypedList(parcel, readHeader, AccountChangeEvent.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AccountChangeEventsResponse accountChangeEventsResponse = new AccountChangeEventsResponse(i, list);
        AppMethodBeat.m2505o(77056);
        return accountChangeEventsResponse;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEventsResponse[i];
    }
}
