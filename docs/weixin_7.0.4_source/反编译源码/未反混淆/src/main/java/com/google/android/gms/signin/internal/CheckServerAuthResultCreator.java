package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class CheckServerAuthResultCreator implements Creator<CheckServerAuthResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61661);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List list = null;
        boolean z = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    list = SafeParcelReader.createTypedList(parcel, readHeader, Scope.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        CheckServerAuthResult checkServerAuthResult = new CheckServerAuthResult(i, z, list);
        AppMethodBeat.o(61661);
        return checkServerAuthResult;
    }

    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
