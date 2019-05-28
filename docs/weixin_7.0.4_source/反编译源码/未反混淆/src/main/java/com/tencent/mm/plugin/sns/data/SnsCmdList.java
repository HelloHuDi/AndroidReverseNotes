package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new Creator<SnsCmdList>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsCmdList[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            int i = 0;
            AppMethodBeat.i(35788);
            SnsCmdList snsCmdList = new SnsCmdList();
            snsCmdList.qFL = parcel.readInt();
            snsCmdList.qFN.clear();
            for (int i2 = 0; i2 < snsCmdList.qFL; i2++) {
                snsCmdList.qFN.add(Integer.valueOf(parcel.readInt()));
            }
            snsCmdList.qFM = parcel.readInt();
            snsCmdList.qFO.clear();
            while (i < snsCmdList.qFM) {
                snsCmdList.qFO.add(Integer.valueOf(parcel.readInt()));
                i++;
            }
            AppMethodBeat.o(35788);
            return snsCmdList;
        }
    };
    private int qFL = 0;
    private int qFM = 0;
    public List<Integer> qFN = new LinkedList();
    public List<Integer> qFO = new LinkedList();

    public SnsCmdList() {
        AppMethodBeat.i(35789);
        AppMethodBeat.o(35789);
    }

    public final void CK(int i) {
        AppMethodBeat.i(35790);
        this.qFN.add(Integer.valueOf(i));
        AppMethodBeat.o(35790);
    }

    public final void CL(int i) {
        AppMethodBeat.i(35791);
        this.qFO.add(Integer.valueOf(i));
        AppMethodBeat.o(35791);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.i(35792);
        this.qFL = this.qFN.size();
        parcel.writeInt(this.qFL);
        for (int i3 = 0; i3 < this.qFL; i3++) {
            parcel.writeInt(((Integer) this.qFN.get(i3)).intValue());
        }
        this.qFM = this.qFO.size();
        parcel.writeInt(this.qFM);
        while (i2 < this.qFM) {
            parcel.writeInt(((Integer) this.qFO.get(i2)).intValue());
            i2++;
        }
        AppMethodBeat.o(35792);
    }

    static {
        AppMethodBeat.i(35793);
        AppMethodBeat.o(35793);
    }
}
