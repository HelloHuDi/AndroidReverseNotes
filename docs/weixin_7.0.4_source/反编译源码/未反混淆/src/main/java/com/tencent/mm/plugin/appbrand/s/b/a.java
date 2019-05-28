package com.tencent.mm.plugin.appbrand.s.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends com.tencent.luggage.a.b {

    public interface b {
        void a(int i, String str, a aVar);
    }

    public static class a {
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
            AppMethodBeat.i(93905);
            String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.bIy + '\'' + ", speed=" + this.iSf + ", accuracy=" + this.iSg + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.fsY + '}';
            AppMethodBeat.o(93905);
            return str;
        }
    }

    void a(String str, b bVar, Bundle bundle);

    boolean b(String str, b bVar, Bundle bundle);

    boolean c(String str, b bVar, Bundle bundle);
}
