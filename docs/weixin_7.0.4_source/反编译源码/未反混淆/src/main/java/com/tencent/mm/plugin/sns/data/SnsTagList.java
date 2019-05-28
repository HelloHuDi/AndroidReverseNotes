package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new Creator<SnsTagList>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsTagList[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(35800);
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.qFV = parcel.readInt();
            for (int i = 0; i < snsTagList.qFV; i++) {
                snsTagList.qFW.add(Long.valueOf(parcel.readLong()));
            }
            AppMethodBeat.o(35800);
            return snsTagList;
        }
    };
    private int qFV = 0;
    private List<Long> qFW = new LinkedList();

    public SnsTagList() {
        AppMethodBeat.i(35801);
        AppMethodBeat.o(35801);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(35802);
        this.qFV = this.qFW.size();
        parcel.writeInt(this.qFV);
        for (Long longValue : this.qFW) {
            parcel.writeLong(longValue.longValue());
        }
        AppMethodBeat.o(35802);
    }

    static {
        AppMethodBeat.i(35803);
        AppMethodBeat.o(35803);
    }
}
