package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData implements Parcelable {
    public static final Creator<RecoveryData> CREATOR = new Creator<RecoveryData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryData recoveryData = new RecoveryData();
            recoveryData.processName = parcel.readString();
            recoveryData.eCq = parcel.readString();
            recoveryData.clientVersion = parcel.readString();
            recoveryData.Arl = parcel.readString();
            recoveryData.Arm = parcel.readArrayList(RecoveryData.class.getClassLoader());
            return recoveryData;
        }
    };
    public String Arl;
    public List<RecoveryStatusItem> Arm;
    public String clientVersion;
    public String eCq;
    public String processName;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.eCq);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.Arl);
        parcel.writeList(this.Arm);
    }
}
