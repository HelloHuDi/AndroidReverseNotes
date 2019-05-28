package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;

public final class user_login_t extends m {
    public String channel = "";
    public String fr = "";
    public String imei = "";
    public boolean is_login = true;
    public String nettp = "";
    public String pf = "";
    public String session_id = "";
    public long uin = 0;
    public int uip = 0;
    public long user_id = 0;
    public String version = "";
    public double x = 0.0d;
    public double y = 0.0d;

    public user_login_t(long j, String str, long j2, int i, String str2, double d, double d2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        this.user_id = j;
        this.session_id = str;
        this.uin = j2;
        this.uip = i;
        this.imei = str2;
        this.x = d;
        this.y = d2;
        this.pf = str3;
        this.version = str4;
        this.is_login = z;
        this.fr = str5;
        this.nettp = str6;
        this.channel = str7;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(101144);
        lVar.a(this.user_id, 0);
        lVar.a(this.session_id, 1);
        lVar.a(this.uin, 2);
        lVar.a(this.uip, 3);
        if (this.imei != null) {
            lVar.a(this.imei, 4);
        }
        lVar.a(this.x, 5);
        lVar.a(this.y, 6);
        if (this.pf != null) {
            lVar.a(this.pf, 7);
        }
        if (this.version != null) {
            lVar.a(this.version, 8);
        }
        lVar.a(this.is_login, 9);
        if (this.fr != null) {
            lVar.a(this.fr, 10);
        }
        if (this.nettp != null) {
            lVar.a(this.nettp, 11);
        }
        if (this.channel != null) {
            lVar.a(this.channel, 12);
        }
        AppMethodBeat.o(101144);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(101145);
        this.user_id = kVar.a(this.user_id, 0, true);
        this.session_id = kVar.a(1, true);
        this.uin = kVar.a(this.uin, 2, true);
        this.uip = kVar.a(this.uip, 3, true);
        this.imei = kVar.a(4, false);
        this.x = kVar.a(this.x, 5, false);
        this.y = kVar.a(this.y, 6, false);
        this.pf = kVar.a(7, false);
        this.version = kVar.a(8, false);
        this.is_login = kVar.a(this.is_login, 9, false);
        this.fr = kVar.a(10, false);
        this.nettp = kVar.a(11, false);
        this.channel = kVar.a(12, false);
        AppMethodBeat.o(101145);
    }
}
