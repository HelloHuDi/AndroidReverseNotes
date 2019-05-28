package com.tencent.p177mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo */
class GroupIDKeyDataInfo implements Parcelable {
    public static final Creator<GroupIDKeyDataInfo> CREATOR = new C37371();
    public boolean pXA;
    ArrayList<IDKey> pXz = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.report.service.GroupIDKeyDataInfo$1 */
    static class C37371 implements Creator<GroupIDKeyDataInfo> {
        C37371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GroupIDKeyDataInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(72695);
            GroupIDKeyDataInfo groupIDKeyDataInfo = new GroupIDKeyDataInfo(parcel);
            AppMethodBeat.m2505o(72695);
            return groupIDKeyDataInfo;
        }
    }

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList) {
        AppMethodBeat.m2504i(72696);
        this.pXz = arrayList;
        this.pXA = false;
        AppMethodBeat.m2505o(72696);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(72697);
        parcel.writeTypedList(this.pXz);
        parcel.writeInt(this.pXA ? 1 : 0);
        AppMethodBeat.m2505o(72697);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.m2504i(72698);
        parcel.readTypedList(this.pXz, IDKey.CREATOR);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pXA = z;
        AppMethodBeat.m2505o(72698);
    }

    static {
        AppMethodBeat.m2504i(72699);
        AppMethodBeat.m2505o(72699);
    }
}
