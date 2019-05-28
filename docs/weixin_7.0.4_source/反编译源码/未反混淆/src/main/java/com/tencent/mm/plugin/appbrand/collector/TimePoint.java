package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint implements Parcelable {
    public static final Creator<TimePoint> CREATOR = new Creator<TimePoint>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimePoint[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(57060);
            TimePoint timePoint = new TimePoint();
            timePoint.name = parcel.readString();
            timePoint.heM.set(parcel.readLong());
            timePoint.heL.set(parcel.readInt());
            timePoint.heN.set((TimePoint) parcel.readParcelable(TimePoint.class.getClassLoader()));
            AppMethodBeat.o(57060);
            return timePoint;
        }
    };
    final AtomicInteger heL;
    final AtomicLong heM;
    final AtomicReference<TimePoint> heN;
    String name;

    TimePoint() {
        AppMethodBeat.i(57061);
        this.heL = new AtomicInteger();
        this.heM = new AtomicLong();
        this.heN = new AtomicReference();
        this.name = "";
        AppMethodBeat.o(57061);
    }

    public TimePoint(String str, long j) {
        AppMethodBeat.i(57062);
        this.heL = new AtomicInteger();
        this.heM = new AtomicLong();
        this.heN = new AtomicReference();
        this.name = str;
        this.heM.set(j);
        AppMethodBeat.o(57062);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(57063);
        parcel.writeString(this.name);
        parcel.writeLong(this.heM.get());
        parcel.writeInt(this.heL.get());
        parcel.writeParcelable((Parcelable) this.heN.get(), i);
        AppMethodBeat.o(57063);
    }

    static {
        AppMethodBeat.i(57064);
        AppMethodBeat.o(57064);
    }
}
