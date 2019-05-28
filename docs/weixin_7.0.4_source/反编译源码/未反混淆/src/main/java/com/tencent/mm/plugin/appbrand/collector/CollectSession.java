package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new Creator<CollectSession>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CollectSession[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(57013);
            CollectSession collectSession = new CollectSession();
            collectSession.groupId = parcel.readString();
            collectSession.id = parcel.readString();
            collectSession.heA = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
            collectSession.heD = parcel.readString();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                collectSession.cBY.putAll(readBundle);
            }
            TimePoint timePoint = collectSession.heA;
            if (timePoint != null) {
                collectSession.heC.put(timePoint.name, timePoint);
                while (timePoint.heN.get() != null) {
                    timePoint = (TimePoint) timePoint.heN.get();
                    collectSession.heC.put(timePoint.name, timePoint);
                }
                collectSession.heB = timePoint;
            }
            AppMethodBeat.o(57013);
            return collectSession;
        }
    };
    public final Bundle cBY = new Bundle();
    String groupId;
    TimePoint heA;
    TimePoint heB;
    final Map<String, TimePoint> heC = new HashMap();
    String heD;
    String id;

    CollectSession() {
        AppMethodBeat.i(57014);
        AppMethodBeat.o(57014);
    }

    public CollectSession(String str) {
        AppMethodBeat.i(57015);
        this.id = str;
        AppMethodBeat.o(57015);
    }

    public final void yF(String str) {
        AppMethodBeat.i(57016);
        Assert.assertNull(this.heA);
        this.heA = new TimePoint(str, System.nanoTime());
        this.heB = this.heA;
        this.heA.heL.set(1);
        this.heC.put(str, this.heA);
        AppMethodBeat.o(57016);
    }

    public final void yG(String str) {
        AppMethodBeat.i(57017);
        Assert.assertNotNull(this.heB);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.heC.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.heL.set(1);
            this.heC.put(str, timePoint);
            this.heB.heN.set(timePoint);
            this.heB = timePoint;
            AppMethodBeat.o(57017);
            return;
        }
        timePoint.heM.set((nanoTime + (timePoint.heM.get() * ((long) timePoint.heL.get()))) / ((long) (timePoint.heL.get() + 1)));
        timePoint.heL.incrementAndGet();
        AppMethodBeat.o(57017);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(57018);
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.heA, i);
        parcel.writeString(this.heD);
        parcel.writeBundle(this.cBY);
        AppMethodBeat.o(57018);
    }

    static {
        AppMethodBeat.i(57019);
        AppMethodBeat.o(57019);
    }
}
