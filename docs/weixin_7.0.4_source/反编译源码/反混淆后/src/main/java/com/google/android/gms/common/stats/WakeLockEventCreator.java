package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WakeLockEventCreator implements Creator<WakeLockEvent> {
    public static final int CONTENT_DESCRIPTION = 0;

    public WakeLockEvent createFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(89981);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    list = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 8:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 11:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 16:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 17:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        WakeLockEvent wakeLockEvent = new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        AppMethodBeat.m2505o(89981);
        return wakeLockEvent;
    }

    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
