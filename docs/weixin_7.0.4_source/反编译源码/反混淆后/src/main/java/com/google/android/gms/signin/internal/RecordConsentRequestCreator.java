package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RecordConsentRequestCreator implements Creator<RecordConsentRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    public RecordConsentRequest createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(61684);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String str = null;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        RecordConsentRequest recordConsentRequest = new RecordConsentRequest(i, account, scopeArr, str);
        AppMethodBeat.m2505o(61684);
        return recordConsentRequest;
    }

    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
