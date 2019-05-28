package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class zzx implements Creator<zzw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(77032);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        DeviceMetaData deviceMetaData = null;
        PendingIntent pendingIntent = null;
        byte[] bArr = null;
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    PendingIntent pendingIntent2 = (PendingIntent) SafeParcelReader.createParcelable(parcel, readHeader, PendingIntent.CREATOR);
                    hashSet.add(Integer.valueOf(5));
                    pendingIntent = pendingIntent2;
                    break;
                case 6:
                    DeviceMetaData deviceMetaData2 = (DeviceMetaData) SafeParcelReader.createParcelable(parcel, readHeader, DeviceMetaData.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    deviceMetaData = deviceMetaData2;
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            ParseException parseException = new ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
            AppMethodBeat.m2505o(77032);
            throw parseException;
        }
        zzw zzw = new zzw(hashSet, i2, str, i, bArr, pendingIntent, deviceMetaData);
        AppMethodBeat.m2505o(77032);
        return zzw;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzw[i];
    }
}
