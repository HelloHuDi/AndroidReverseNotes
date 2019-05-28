package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new Creator<MultiTalkGroupMemberData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(53882);
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.Aqh = bo.bc(parcel.readString(), "");
            multiTalkGroupMember.Aqi = bo.bc(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.boZ = parcel.readInt();
            multiTalkGroupMember.Api = parcel.readInt();
            MultiTalkGroupMemberData multiTalkGroupMemberData = new MultiTalkGroupMemberData(multiTalkGroupMember);
            AppMethodBeat.o(53882);
            return multiTalkGroupMemberData;
        }
    };
    MultiTalkGroupMember oFO;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.oFO = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(53883);
        parcel.writeString(bo.bc(this.oFO.Aqh, ""));
        parcel.writeString(bo.bc(this.oFO.Aqi, ""));
        parcel.writeInt(this.oFO.status);
        parcel.writeInt(this.oFO.boZ);
        parcel.writeInt(this.oFO.Api);
        AppMethodBeat.o(53883);
    }

    static {
        AppMethodBeat.i(53884);
        AppMethodBeat.o(53884);
    }
}
