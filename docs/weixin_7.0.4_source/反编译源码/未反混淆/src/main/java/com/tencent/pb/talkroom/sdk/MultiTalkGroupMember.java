package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember implements Parcelable {
    public static final Creator<MultiTalkGroupMember> CREATOR = new Creator<MultiTalkGroupMember>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMember[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.Aqh = parcel.readString();
            multiTalkGroupMember.Aqi = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.boZ = parcel.readInt();
            multiTalkGroupMember.Api = parcel.readInt();
            return multiTalkGroupMember;
        }
    };
    public int Api;
    public String Aqh = "";
    public String Aqi = "";
    public int boZ;
    public int status;

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.Aqh + ", inviteUsrName=" + this.Aqi + ", status=" + this.status + ", reason=" + this.boZ + ", inviteTime=" + this.Api + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Aqh == null ? "" : this.Aqh);
        parcel.writeString(this.Aqi == null ? "" : this.Aqi);
        parcel.writeInt(this.status);
        parcel.writeInt(this.boZ);
        parcel.writeInt(this.Api);
    }
}
