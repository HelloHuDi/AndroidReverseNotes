package com.tencent.p177mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData */
public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new C35111();
    private MultiTalkGroup oFN;

    /* renamed from: com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData$1 */
    static class C35111 implements Creator<MultiTalkGroupData> {
        C35111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(53879);
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.Aqc = C5046bo.m7532bc(parcel.readString(), "");
            multiTalkGroup.Aqd = C5046bo.m7532bc(parcel.readString(), "");
            multiTalkGroup.Aqe = C5046bo.m7532bc(parcel.readString(), "");
            multiTalkGroup.AlR = parcel.readInt();
            multiTalkGroup.Aqf = C5046bo.m7532bc(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.Aqg = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                multiTalkGroup.Aqg.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).oFO);
            }
            MultiTalkGroupData multiTalkGroupData = new MultiTalkGroupData(multiTalkGroup);
            AppMethodBeat.m2505o(53879);
            return multiTalkGroupData;
        }
    }

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.oFN = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(53880);
        parcel.writeString(C5046bo.m7532bc(this.oFN.Aqc, ""));
        parcel.writeString(C5046bo.m7532bc(this.oFN.Aqd, ""));
        parcel.writeString(C5046bo.m7532bc(this.oFN.Aqe, ""));
        parcel.writeInt(this.oFN.AlR);
        parcel.writeString(C5046bo.m7532bc(this.oFN.Aqf, ""));
        parcel.writeInt(this.oFN.Aqg.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oFN.Aqg.size()) {
                parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.oFN.Aqg.get(i3)), i);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(53880);
                return;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(53881);
        AppMethodBeat.m2505o(53881);
    }
}
