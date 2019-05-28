package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolveAccountRequestCreator implements Creator<ResolveAccountRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.i(61361);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.createParcelable(parcel, readHeader, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ResolveAccountRequest resolveAccountRequest = new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        AppMethodBeat.o(61361);
        return resolveAccountRequest;
    }

    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
