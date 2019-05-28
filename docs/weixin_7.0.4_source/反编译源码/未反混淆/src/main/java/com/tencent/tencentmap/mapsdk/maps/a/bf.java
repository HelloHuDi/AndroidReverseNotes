package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class bf implements be {
    private static bf a = null;
    private SparseArray<bd> b = new SparseArray(5);
    private List<ay> c = new ArrayList(5);
    private bc d;
    private Context e = null;
    private boolean f = true;
    private boolean g = true;

    public static synchronized bf a(Context context) {
        bf bfVar;
        synchronized (bf.class) {
            AppMethodBeat.i(98548);
            if (a == null) {
                a = new bf(context, true);
                ag.h(" create uphandler up:true", new Object[0]);
            }
            bfVar = a;
            AppMethodBeat.o(98548);
        }
        return bfVar;
    }

    public static synchronized bf a(Context context, boolean z) {
        bf bfVar;
        synchronized (bf.class) {
            AppMethodBeat.i(98549);
            if (a == null) {
                a = new bf(context, z);
                ag.h(" create uphandler up: %b", Boolean.valueOf(z));
            }
            if (a.f != z) {
                a.f = z;
                ag.h(" change uphandler up: %b", Boolean.valueOf(z));
            }
            bfVar = a;
            AppMethodBeat.o(98549);
        }
        return bfVar;
    }

    private bf(Context context, boolean z) {
        Context context2 = null;
        AppMethodBeat.i(98550);
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 != null) {
            this.e = context2;
        } else {
            this.e = context;
        }
        this.f = z;
        this.d = bc.a(this.e);
        AppMethodBeat.o(98550);
    }

    public final synchronized boolean a(bd bdVar) {
        boolean z;
        AppMethodBeat.i(98551);
        if (bdVar == null) {
            z = false;
            AppMethodBeat.o(98551);
        } else {
            this.b.append(101, bdVar);
            z = true;
            AppMethodBeat.o(98551);
        }
        return z;
    }

    public final synchronized boolean a(ay ayVar) {
        boolean z;
        AppMethodBeat.i(98552);
        if (ayVar == null) {
            z = false;
            AppMethodBeat.o(98552);
        } else {
            if (!this.c.contains(ayVar)) {
                this.c.add(ayVar);
            }
            z = true;
            AppMethodBeat.o(98552);
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:119:0x02df, code skipped:
            a(r4, r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(az azVar) {
        int i;
        Throwable th;
        boolean z = false;
        AppMethodBeat.i(98553);
        if (!(this.f && b())) {
            if (azVar.c() == 2) {
                ag.h("  Not UpProc real event sync 2 DB done false", new Object[0]);
                azVar.b(false);
            }
            if (azVar.b != 0) {
                ag.h("  Not UpProc not req: %d", Integer.valueOf(azVar.c()));
                AppMethodBeat.o(98553);
                return;
            }
            ag.h("  NotUpProc com req start ", new Object[0]);
        }
        if (!e.m(this.e)) {
            ag.c(" doUpload network is disabled!", new Object[0]);
            if (azVar.c() == 2) {
                azVar.b(false);
            }
            AppMethodBeat.o(98553);
        } else if (azVar == null) {
            ag.d(" upData == null ", new Object[0]);
            AppMethodBeat.o(98553);
        } else {
            int c = azVar.c();
            String e = azVar.e();
            if (e == null || "".equals(e.trim())) {
                ag.d(" url error", new Object[0]);
                if (azVar.c() == 2) {
                    azVar.b(false);
                }
                a(c, -1, false, "url error");
                AppMethodBeat.o(98553);
                return;
            }
            byte[] b = b(azVar);
            String d = azVar.d();
            String str = null;
            if (d != null) {
                str = "?rid=".concat(String.valueOf(d));
            }
            v a = v.a();
            if (a != null) {
                d = a.l();
                if (!(d == null || "".equals(d))) {
                    if (str == null) {
                        str = "?sid=".concat(String.valueOf(d));
                    } else {
                        str = str + "&sid=" + d;
                    }
                }
            }
            if (str != null) {
                str = e + str;
            } else {
                str = e;
            }
            ag.h(" start upload cmd: %d  url:%s  datas:%s", Integer.valueOf(c), str, azVar.getClass().toString());
            if (b == null) {
                ag.c(" sendData is null", new Object[0]);
                a(c, -1, false, "sendData error");
                AppMethodBeat.o(98553);
                return;
            }
            bc d2 = d();
            if (d2 == null) {
                ag.d(" reqH error", new Object[0]);
                a(c, -1, false, "reqHandler error");
                AppMethodBeat.o(98553);
                return;
            }
            e.f(this.e);
            c.m().h();
            new Date().getTime();
            try {
                byte[] a2;
                byte[] a3 = d2.a(str, b, azVar);
                if (a3 == null && c == 100 && !"http://strategy.beacon.qq.com/analytics/upload?mType=beacon".equals(str)) {
                    a2 = d2.a("http://strategy.beacon.qq.com/analytics/upload?mType=beacon", b, azVar);
                } else {
                    a2 = a3;
                }
                ab a4 = a(a2);
                if (a4 != null) {
                    boolean z2;
                    i = a4.b;
                    try {
                        z2 = a4.a == (byte) 0;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            a(c, i, false, th.toString());
                            ag.d(" req error  %s", th.toString());
                            azVar.b(z);
                            AppMethodBeat.o(98553);
                        } catch (Throwable th3) {
                            th = th3;
                            azVar.b(z);
                            AppMethodBeat.o(98553);
                            throw th;
                        }
                    }
                    try {
                        ag.b("response.cmd:%d response.result:%d", Integer.valueOf(a4.b), Byte.valueOf(a4.a));
                        z = z2;
                    } catch (Throwable th4) {
                        th = th4;
                        z = z2;
                        azVar.b(z);
                        AppMethodBeat.o(98553);
                        throw th;
                    }
                }
                i = -1;
                if (!(azVar == null || a4 == null)) {
                    c m = c.m();
                    if (m != null) {
                        if (a4.d != null) {
                            m.b(a4.d.trim());
                        }
                        m.a(a4.e - new Date().getTime());
                        ag.h(" fix ip:%s  tmgap: %d", m.g(), Long.valueOf(m.h()));
                    }
                    if (a4.b == 101 || a4.b == 103 || a4.b == 105) {
                        t.a(this.e).e();
                    }
                    byte[] bArr = a4.c;
                    if (bArr != null) {
                        SparseArray e2 = e();
                        if (e2 != null && e2.size() > 0) {
                            int c2 = azVar.c();
                            int i2 = a4.b;
                            if (i2 != 0) {
                                switch (c2) {
                                    case 4:
                                        if (i2 != 105) {
                                            ag.c(" UNMATCH req: %d , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    case 100:
                                        if (i2 != 101) {
                                            ag.c(" UNMATCH req: %d , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    case 102:
                                        if (i2 != 103) {
                                            ag.c(" UNMATCH req: %d  , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    default:
                                        ag.c(" unknown req: %d ", Integer.valueOf(c2));
                                        break;
                                }
                            }
                            ag.h(" response no datas ", new Object[0]);
                        } else {
                            ag.h(" no handler! ", new Object[0]);
                        }
                    } else {
                        ag.h(" no response! ", new Object[0]);
                    }
                }
                a(c, i, z, null);
                azVar.b(z);
                AppMethodBeat.o(98553);
            } catch (Throwable th5) {
                th = th5;
                i = -1;
                a(c, i, false, th.toString());
                ag.d(" req error  %s", th.toString());
                azVar.b(z);
                AppMethodBeat.o(98553);
            }
        }
    }

    private static byte[] b(az azVar) {
        AppMethodBeat.i(98554);
        if (azVar != null) {
            try {
                aa a = azVar.a();
                if (a != null) {
                    ag.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", a.b, a.d, a.c, Integer.valueOf(a.f));
                    al alVar = new al();
                    alVar.a();
                    alVar.b("test");
                    alVar.a("test");
                    alVar.a("detail", a);
                    byte[] b = alVar.b();
                    v a2 = v.a();
                    if (a2 != null) {
                        b = e.a(b, a2.i(), a2.h(), a2.k());
                        AppMethodBeat.o(98554);
                        return b;
                    }
                }
            } catch (Throwable th) {
                ag.d(" parseSendDatas error", new Object[0]);
                ag.a(th);
                azVar.b();
            }
        }
        AppMethodBeat.o(98554);
        return null;
    }

    private static ab a(byte[] bArr) {
        AppMethodBeat.i(98555);
        if (bArr != null) {
            try {
                byte[] b;
                v a = v.a();
                if (a != null) {
                    b = e.b(bArr, a.i(), a.h(), a.k());
                } else {
                    b = null;
                }
                if (b != null) {
                    al alVar = new al();
                    alVar.a(b);
                    ab abVar = new ab();
                    ag.b(" covert to ResponsePackage ", new Object[0]);
                    abVar = (ab) alVar.b("detail", abVar);
                    AppMethodBeat.o(98555);
                    return abVar;
                }
            } catch (Throwable th) {
                ag.a(th);
            }
        }
        AppMethodBeat.o(98555);
        return null;
    }

    private void a(int i, int i2, boolean z, String str) {
        AppMethodBeat.i(98556);
        ay[] c = c();
        if (c != null) {
            for (ay a : c) {
                a.a(i, i2, 0, 0, z, str);
            }
        }
        AppMethodBeat.o(98556);
    }

    private synchronized ay[] c() {
        ay[] ayVarArr;
        AppMethodBeat.i(98557);
        if (this.c == null || this.c.size() <= 0) {
            ayVarArr = null;
            AppMethodBeat.o(98557);
        } else {
            ayVarArr = (ay[]) this.c.toArray(new ay[0]);
            AppMethodBeat.o(98557);
        }
        return ayVarArr;
    }

    private synchronized bc d() {
        return this.d;
    }

    private synchronized SparseArray<bd> e() {
        SparseArray<bd> sparseArray;
        AppMethodBeat.i(98558);
        if (this.b == null || this.b.size() <= 0) {
            sparseArray = null;
            AppMethodBeat.o(98558);
        } else {
            ah ahVar = new ah();
            sparseArray = ah.a(this.b);
            AppMethodBeat.o(98558);
        }
        return sparseArray;
    }

    private static boolean a(SparseArray<bd> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.i(98559);
        if (sparseArray == null || bArr == null) {
            AppMethodBeat.o(98559);
            return true;
        }
        switch (i) {
            case 103:
                AppMethodBeat.o(98559);
                return true;
            default:
                bd bdVar = (bd) sparseArray.get(i);
                if (bdVar == null) {
                    ag.c(" no handler key:%d", Integer.valueOf(i));
                    AppMethodBeat.o(98559);
                    return false;
                }
                try {
                    ag.b(" key:%d  handler: %s", Integer.valueOf(i), bdVar.getClass().toString());
                    bdVar.a(i, bArr, true);
                    AppMethodBeat.o(98559);
                    return true;
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d(" handle error key:%d", Integer.valueOf(i));
                    AppMethodBeat.o(98559);
                    return false;
                }
        }
    }

    public final boolean a() {
        return this.f;
    }

    public final synchronized boolean b() {
        boolean z;
        AppMethodBeat.i(98560);
        if (e.l(this.e)) {
            z = true;
            AppMethodBeat.o(98560);
        } else {
            z = this.g;
            AppMethodBeat.o(98560);
        }
        return z;
    }
}
