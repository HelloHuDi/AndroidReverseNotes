package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaz implements Creator<zzay> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(50490);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    credential = (Credential) SafeParcelReader.createParcelable(parcel, readHeader, Credential.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzay zzay = new zzay(credential);
        AppMethodBeat.m2505o(50490);
        return zzay;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzay[i];
    }
}
