package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInResponseCreator implements Creator<SignInResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    public SignInResponse createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61705);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readHeader, ConnectionResult.CREATOR);
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.createParcelable(parcel, readHeader, ResolveAccountResponse.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SignInResponse signInResponse = new SignInResponse(i, connectionResult, resolveAccountResponse);
        AppMethodBeat.m2505o(61705);
        return signInResponse;
    }

    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
