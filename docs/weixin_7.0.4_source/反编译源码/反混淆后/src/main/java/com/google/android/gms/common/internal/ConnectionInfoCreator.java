package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ConnectionInfo createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(89587);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Feature[] featureArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 2:
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ConnectionInfo connectionInfo = new ConnectionInfo(bundle, featureArr);
        AppMethodBeat.m2505o(89587);
        return connectionInfo;
    }

    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
