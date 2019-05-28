package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryStatusItem> CREATOR = new Creator<RecoveryStatusItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryStatusItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.eCq = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.AqZ = parcel.readInt();
            recoveryStatusItem.Arc = parcel.readInt();
            recoveryStatusItem.Arb = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }
    };
    public int AqZ;
    public int Arb;
    public int Arc;
    public String clientVersion;
    public String eCq;
    public String processName;
    public long timestamp;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.eCq);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.AqZ);
        parcel.writeInt(this.Arc);
        parcel.writeInt(this.Arb);
        parcel.writeLong(this.timestamp);
    }

    public final boolean atL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.eCq = split[1];
            this.clientVersion = split[2];
            this.AqZ = Integer.valueOf(split[3]).intValue();
            this.Arc = Integer.valueOf(split[4]).intValue();
            this.Arb = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final String dQf() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.eCq);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.AqZ);
        stringBuffer.append(",");
        stringBuffer.append(this.Arc);
        stringBuffer.append(",");
        stringBuffer.append(this.Arb);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }
}
