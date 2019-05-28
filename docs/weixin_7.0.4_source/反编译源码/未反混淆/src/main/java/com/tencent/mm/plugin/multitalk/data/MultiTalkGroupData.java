package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new Creator<MultiTalkGroupData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(53879);
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.Aqc = bo.bc(parcel.readString(), "");
            multiTalkGroup.Aqd = bo.bc(parcel.readString(), "");
            multiTalkGroup.Aqe = bo.bc(parcel.readString(), "");
            multiTalkGroup.AlR = parcel.readInt();
            multiTalkGroup.Aqf = bo.bc(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.Aqg = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                multiTalkGroup.Aqg.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).oFO);
            }
            MultiTalkGroupData multiTalkGroupData = new MultiTalkGroupData(multiTalkGroup);
            AppMethodBeat.o(53879);
            return multiTalkGroupData;
        }
    };
    private MultiTalkGroup oFN;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.oFN = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(53880);
        parcel.writeString(bo.bc(this.oFN.Aqc, ""));
        parcel.writeString(bo.bc(this.oFN.Aqd, ""));
        parcel.writeString(bo.bc(this.oFN.Aqe, ""));
        parcel.writeInt(this.oFN.AlR);
        parcel.writeString(bo.bc(this.oFN.Aqf, ""));
        parcel.writeInt(this.oFN.Aqg.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oFN.Aqg.size()) {
                parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.oFN.Aqg.get(i3)), i);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(53880);
                return;
            }
        }
    }

    static {
        AppMethodBeat.i(53881);
        AppMethodBeat.o(53881);
    }
}
