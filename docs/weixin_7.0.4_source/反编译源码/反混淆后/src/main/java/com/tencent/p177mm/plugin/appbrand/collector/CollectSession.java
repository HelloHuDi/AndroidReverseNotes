package com.tencent.p177mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.CollectSession */
public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new C381561();
    public final Bundle cBY = new Bundle();
    String groupId;
    TimePoint heA;
    TimePoint heB;
    final Map<String, TimePoint> heC = new HashMap();
    String heD;
    /* renamed from: id */
    String f17182id;

    /* renamed from: com.tencent.mm.plugin.appbrand.collector.CollectSession$1 */
    static class C381561 implements Creator<CollectSession> {
        C381561() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CollectSession[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(57013);
            CollectSession collectSession = new CollectSession();
            collectSession.groupId = parcel.readString();
            collectSession.f17182id = parcel.readString();
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
            AppMethodBeat.m2505o(57013);
            return collectSession;
        }
    }

    CollectSession() {
        AppMethodBeat.m2504i(57014);
        AppMethodBeat.m2505o(57014);
    }

    public CollectSession(String str) {
        AppMethodBeat.m2504i(57015);
        this.f17182id = str;
        AppMethodBeat.m2505o(57015);
    }

    /* renamed from: yF */
    public final void mo67917yF(String str) {
        AppMethodBeat.m2504i(57016);
        Assert.assertNull(this.heA);
        this.heA = new TimePoint(str, System.nanoTime());
        this.heB = this.heA;
        this.heA.heL.set(1);
        this.heC.put(str, this.heA);
        AppMethodBeat.m2505o(57016);
    }

    /* renamed from: yG */
    public final void mo67918yG(String str) {
        AppMethodBeat.m2504i(57017);
        Assert.assertNotNull(this.heB);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.heC.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.heL.set(1);
            this.heC.put(str, timePoint);
            this.heB.heN.set(timePoint);
            this.heB = timePoint;
            AppMethodBeat.m2505o(57017);
            return;
        }
        timePoint.heM.set((nanoTime + (timePoint.heM.get() * ((long) timePoint.heL.get()))) / ((long) (timePoint.heL.get() + 1)));
        timePoint.heL.incrementAndGet();
        AppMethodBeat.m2505o(57017);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(57018);
        parcel.writeString(this.groupId);
        parcel.writeString(this.f17182id);
        parcel.writeParcelable(this.heA, i);
        parcel.writeString(this.heD);
        parcel.writeBundle(this.cBY);
        AppMethodBeat.m2505o(57018);
    }

    static {
        AppMethodBeat.m2504i(57019);
        AppMethodBeat.m2505o(57019);
    }
}
