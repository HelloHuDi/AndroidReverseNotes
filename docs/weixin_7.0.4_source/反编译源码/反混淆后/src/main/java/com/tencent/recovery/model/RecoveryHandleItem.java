package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryHandleItem> CREATOR = new C58011();
    public String Arn;
    public String clientVersion;
    public String eCq;
    public String key;
    public String processName;
    public long timestamp;

    /* renamed from: com.tencent.recovery.model.RecoveryHandleItem$1 */
    static class C58011 implements Creator<RecoveryHandleItem> {
        C58011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.eCq = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.key = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.Arn = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }
    }

    public final String dQf() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eCq);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.key);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.Arn);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    public final boolean atL(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.eCq = split[0];
            this.clientVersion = split[1];
            this.key = split[2];
            this.processName = split[3];
            this.Arn = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eCq);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.key);
        parcel.writeString(this.processName);
        parcel.writeString(this.Arn);
        parcel.writeLong(this.timestamp);
    }
}
