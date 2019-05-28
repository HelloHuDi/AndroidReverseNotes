package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(72689);
            BroadCastData broadCastData = new BroadCastData(parcel);
            AppMethodBeat.o(72689);
            return broadCastData;
        }
    };
    ArrayList<KVReportDataInfo> pXw = new ArrayList();
    ArrayList<StIDKeyDataInfo> pXx = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> pXy = new ArrayList();

    public BroadCastData() {
        AppMethodBeat.i(72690);
        AppMethodBeat.o(72690);
    }

    public BroadCastData(BroadCastData broadCastData) {
        AppMethodBeat.i(72691);
        if (broadCastData == null) {
            AppMethodBeat.o(72691);
            return;
        }
        this.pXw = new ArrayList(broadCastData.pXw);
        this.pXx = new ArrayList(broadCastData.pXx);
        this.pXy = new ArrayList(broadCastData.pXy);
        AppMethodBeat.o(72691);
    }

    protected BroadCastData(Parcel parcel) {
        AppMethodBeat.i(72692);
        parcel.readTypedList(this.pXw, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.pXx, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.pXy, GroupIDKeyDataInfo.CREATOR);
        AppMethodBeat.o(72692);
    }

    static {
        AppMethodBeat.i(72694);
        AppMethodBeat.o(72694);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(72693);
        parcel.writeTypedList(this.pXw);
        parcel.writeTypedList(this.pXx);
        parcel.writeTypedList(this.pXy);
        AppMethodBeat.o(72693);
    }
}
