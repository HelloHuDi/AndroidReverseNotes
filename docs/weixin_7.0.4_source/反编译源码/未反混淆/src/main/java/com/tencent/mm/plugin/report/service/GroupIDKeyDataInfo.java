package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class GroupIDKeyDataInfo implements Parcelable {
    public static final Creator<GroupIDKeyDataInfo> CREATOR = new Creator<GroupIDKeyDataInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GroupIDKeyDataInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(72695);
            GroupIDKeyDataInfo groupIDKeyDataInfo = new GroupIDKeyDataInfo(parcel);
            AppMethodBeat.o(72695);
            return groupIDKeyDataInfo;
        }
    };
    public boolean pXA;
    ArrayList<IDKey> pXz = new ArrayList();

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(72696);
        this.pXz = arrayList;
        this.pXA = false;
        AppMethodBeat.o(72696);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(72697);
        parcel.writeTypedList(this.pXz);
        parcel.writeInt(this.pXA ? 1 : 0);
        AppMethodBeat.o(72697);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(72698);
        parcel.readTypedList(this.pXz, IDKey.CREATOR);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pXA = z;
        AppMethodBeat.o(72698);
    }

    static {
        AppMethodBeat.i(72699);
        AppMethodBeat.o(72699);
    }
}
