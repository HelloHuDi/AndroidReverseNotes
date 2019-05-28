package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.pb.common.c.c;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new Creator<MultiTalkGroup>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroup[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.Aqc = parcel.readString();
            multiTalkGroup.Aqd = parcel.readString();
            multiTalkGroup.Aqe = parcel.readString();
            multiTalkGroup.AlR = parcel.readInt();
            multiTalkGroup.Aqf = parcel.readString();
            int readInt = parcel.readInt();
            multiTalkGroup.Aqg = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
                if (multiTalkGroupMember != null) {
                    multiTalkGroup.Aqg.add(multiTalkGroupMember);
                } else {
                    c.d("MultiTalkGroup", "CLTNOT readParcelable member = null");
                }
            }
            return multiTalkGroup;
        }
    };
    public int AlR;
    public String Aqc = "";
    public String Aqd = "";
    public String Aqe = "";
    public String Aqf = "";
    public List<MultiTalkGroupMember> Aqg = new ArrayList();

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.Aqc + ", mMultiTalkClientGroupId=" + this.Aqd + ", mWxGroupId=" + this.Aqe + ", mRouteId=" + this.AlR + ", mCreatorUsrName=" + this.Aqf + ", mMultiTalkGroupMemberList=" + this.Aqg + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.Aqc == null ? "" : this.Aqc);
        parcel.writeString(this.Aqd == null ? "" : this.Aqd);
        parcel.writeString(this.Aqe == null ? "" : this.Aqe);
        parcel.writeInt(this.AlR);
        parcel.writeString(this.Aqf == null ? "" : this.Aqf);
        int size = this.Aqg == null ? 0 : this.Aqg.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeParcelable((MultiTalkGroupMember) this.Aqg.get(i2), i);
            i2++;
        }
    }

    public int describeContents() {
        return 0;
    }
}
