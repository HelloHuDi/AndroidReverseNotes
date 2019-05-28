package com.tencent.p177mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.report.service.BroadCastData */
class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new C37361();
    ArrayList<KVReportDataInfo> pXw = new ArrayList();
    ArrayList<StIDKeyDataInfo> pXx = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> pXy = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.report.service.BroadCastData$1 */
    static class C37361 implements Creator<BroadCastData> {
        C37361() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(72689);
            BroadCastData broadCastData = new BroadCastData(parcel);
            AppMethodBeat.m2505o(72689);
            return broadCastData;
        }
    }

    public BroadCastData() {
        AppMethodBeat.m2504i(72690);
        AppMethodBeat.m2505o(72690);
    }

    public BroadCastData(BroadCastData broadCastData) {
        AppMethodBeat.m2504i(72691);
        if (broadCastData == null) {
            AppMethodBeat.m2505o(72691);
            return;
        }
        this.pXw = new ArrayList(broadCastData.pXw);
        this.pXx = new ArrayList(broadCastData.pXx);
        this.pXy = new ArrayList(broadCastData.pXy);
        AppMethodBeat.m2505o(72691);
    }

    protected BroadCastData(Parcel parcel) {
        AppMethodBeat.m2504i(72692);
        parcel.readTypedList(this.pXw, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.pXx, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.pXy, GroupIDKeyDataInfo.CREATOR);
        AppMethodBeat.m2505o(72692);
    }

    static {
        AppMethodBeat.m2504i(72694);
        AppMethodBeat.m2505o(72694);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(72693);
        parcel.writeTypedList(this.pXw);
        parcel.writeTypedList(this.pXx);
        parcel.writeTypedList(this.pXy);
        AppMethodBeat.m2505o(72693);
    }
}
