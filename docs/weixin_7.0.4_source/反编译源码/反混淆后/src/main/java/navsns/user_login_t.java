package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24398l;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31070k;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46803m;

public final class user_login_t extends C46803m {
    public String channel = "";
    /* renamed from: fr */
    public String f1691fr = "";
    public String imei = "";
    public boolean is_login = true;
    public String nettp = "";
    /* renamed from: pf */
    public String f1692pf = "";
    public String session_id = "";
    public long uin = 0;
    public int uip = 0;
    public long user_id = 0;
    public String version = "";
    /* renamed from: x */
    public double f1693x = 0.0d;
    /* renamed from: y */
    public double f1694y = 0.0d;

    public user_login_t(long j, String str, long j2, int i, String str2, double d, double d2, String str3, String str4, boolean z, String str5, String str6, String str7) {
        this.user_id = j;
        this.session_id = str;
        this.uin = j2;
        this.uip = i;
        this.imei = str2;
        this.f1693x = d;
        this.f1694y = d2;
        this.f1692pf = str3;
        this.version = str4;
        this.is_login = z;
        this.f1691fr = str5;
        this.nettp = str6;
        this.channel = str7;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(101144);
        c24398l.mo40669a(this.user_id, 0);
        c24398l.mo40672a(this.session_id, 1);
        c24398l.mo40669a(this.uin, 2);
        c24398l.mo40668a(this.uip, 3);
        if (this.imei != null) {
            c24398l.mo40672a(this.imei, 4);
        }
        c24398l.mo40665a(this.f1693x, 5);
        c24398l.mo40665a(this.f1694y, 6);
        if (this.f1692pf != null) {
            c24398l.mo40672a(this.f1692pf, 7);
        }
        if (this.version != null) {
            c24398l.mo40672a(this.version, 8);
        }
        c24398l.mo40676a(this.is_login, 9);
        if (this.f1691fr != null) {
            c24398l.mo40672a(this.f1691fr, 10);
        }
        if (this.nettp != null) {
            c24398l.mo40672a(this.nettp, 11);
        }
        if (this.channel != null) {
            c24398l.mo40672a(this.channel, 12);
        }
        AppMethodBeat.m2505o(101144);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(101145);
        this.user_id = c31070k.mo50505a(this.user_id, 0, true);
        this.session_id = c31070k.mo50508a(1, true);
        this.uin = c31070k.mo50505a(this.uin, 2, true);
        this.uip = c31070k.mo50503a(this.uip, 3, true);
        this.imei = c31070k.mo50508a(4, false);
        this.f1693x = c31070k.mo50501a(this.f1693x, 5, false);
        this.f1694y = c31070k.mo50501a(this.f1694y, 6, false);
        this.f1692pf = c31070k.mo50508a(7, false);
        this.version = c31070k.mo50508a(8, false);
        this.is_login = c31070k.mo50516a(this.is_login, 9, false);
        this.f1691fr = c31070k.mo50508a(10, false);
        this.nettp = c31070k.mo50508a(11, false);
        this.channel = c31070k.mo50508a(12, false);
        AppMethodBeat.m2505o(101145);
    }
}
