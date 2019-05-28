package com.tencent.p659pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.p659pb.common.p1102c.C44443c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.pb.talkroom.sdk.MultiTalkGroup */
public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new C309171();
    public int AlR;
    public String Aqc = "";
    public String Aqd = "";
    public String Aqe = "";
    public String Aqf = "";
    public List<MultiTalkGroupMember> Aqg = new ArrayList();

    /* renamed from: com.tencent.pb.talkroom.sdk.MultiTalkGroup$1 */
    static class C309171 implements Creator<MultiTalkGroup> {
        C309171() {
        }

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
                    C44443c.m80389d("MultiTalkGroup", "CLTNOT readParcelable member = null");
                }
            }
            return multiTalkGroup;
        }
    }

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
