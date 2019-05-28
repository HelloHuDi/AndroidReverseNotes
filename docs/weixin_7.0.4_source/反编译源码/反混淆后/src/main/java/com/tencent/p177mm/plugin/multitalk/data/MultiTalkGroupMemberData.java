package com.tencent.p177mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;

/* renamed from: com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData */
public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new C126251();
    MultiTalkGroupMember oFO;

    /* renamed from: com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData$1 */
    static class C126251 implements Creator<MultiTalkGroupMemberData> {
        C126251() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(53882);
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.Aqh = C5046bo.m7532bc(parcel.readString(), "");
            multiTalkGroupMember.Aqi = C5046bo.m7532bc(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.boZ = parcel.readInt();
            multiTalkGroupMember.Api = parcel.readInt();
            MultiTalkGroupMemberData multiTalkGroupMemberData = new MultiTalkGroupMemberData(multiTalkGroupMember);
            AppMethodBeat.m2505o(53882);
            return multiTalkGroupMemberData;
        }
    }

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.oFO = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(53883);
        parcel.writeString(C5046bo.m7532bc(this.oFO.Aqh, ""));
        parcel.writeString(C5046bo.m7532bc(this.oFO.Aqi, ""));
        parcel.writeInt(this.oFO.status);
        parcel.writeInt(this.oFO.boZ);
        parcel.writeInt(this.oFO.Api);
        AppMethodBeat.m2505o(53883);
    }

    static {
        AppMethodBeat.m2504i(53884);
        AppMethodBeat.m2505o(53884);
    }
}
