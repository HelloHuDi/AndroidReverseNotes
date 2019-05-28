package com.tencent.p177mm.plugin.appbrand.p329s.p331b;

import android.os.Bundle;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.s.b.a */
public interface C33523a extends C25681b {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.b.a$b */
    public interface C2459b {
        /* renamed from: a */
        void mo6153a(int i, String str, C19712a c19712a);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.b.a$a */
    public static class C19712a {
        public double altitude;
        public String bIy;
        public String buildingId;
        public String floorName;
        public Object fsY;
        public double iSf;
        public double iSg;
        public double latitude;
        public double longitude;

        public final String toString() {
            AppMethodBeat.m2504i(93905);
            String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.bIy + '\'' + ", speed=" + this.iSf + ", accuracy=" + this.iSg + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.fsY + '}';
            AppMethodBeat.m2505o(93905);
            return str;
        }
    }

    /* renamed from: a */
    void mo20054a(String str, C2459b c2459b, Bundle bundle);

    /* renamed from: b */
    boolean mo20055b(String str, C2459b c2459b, Bundle bundle);

    /* renamed from: c */
    boolean mo20056c(String str, C2459b c2459b, Bundle bundle);
}
