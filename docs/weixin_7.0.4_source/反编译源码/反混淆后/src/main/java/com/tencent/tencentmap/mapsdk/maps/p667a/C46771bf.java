package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41014c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bf */
public final class C46771bf implements C41033be {
    /* renamed from: a */
    private static C46771bf f18085a = null;
    /* renamed from: b */
    private SparseArray<C46770bd> f18086b = new SparseArray(5);
    /* renamed from: c */
    private List<C44498ay> f18087c = new ArrayList(5);
    /* renamed from: d */
    private C41032bc f18088d;
    /* renamed from: e */
    private Context f18089e = null;
    /* renamed from: f */
    private boolean f18090f = true;
    /* renamed from: g */
    private boolean f18091g = true;

    /* renamed from: a */
    public static synchronized C46771bf m88722a(Context context) {
        C46771bf c46771bf;
        synchronized (C46771bf.class) {
            AppMethodBeat.m2504i(98548);
            if (f18085a == null) {
                f18085a = new C46771bf(context, true);
                C16205ag.m24691h(" create uphandler up:true", new Object[0]);
            }
            c46771bf = f18085a;
            AppMethodBeat.m2505o(98548);
        }
        return c46771bf;
    }

    /* renamed from: a */
    public static synchronized C46771bf m88723a(Context context, boolean z) {
        C46771bf c46771bf;
        synchronized (C46771bf.class) {
            AppMethodBeat.m2504i(98549);
            if (f18085a == null) {
                f18085a = new C46771bf(context, z);
                C16205ag.m24691h(" create uphandler up: %b", Boolean.valueOf(z));
            }
            if (f18085a.f18090f != z) {
                f18085a.f18090f = z;
                C16205ag.m24691h(" change uphandler up: %b", Boolean.valueOf(z));
            }
            c46771bf = f18085a;
            AppMethodBeat.m2505o(98549);
        }
        return c46771bf;
    }

    private C46771bf(Context context, boolean z) {
        Context context2 = null;
        AppMethodBeat.m2504i(98550);
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 != null) {
            this.f18089e = context2;
        } else {
            this.f18089e = context;
        }
        this.f18090f = z;
        this.f18088d = C41032bc.m71345a(this.f18089e);
        AppMethodBeat.m2505o(98550);
    }

    /* renamed from: a */
    public final synchronized boolean mo65115a(C46770bd c46770bd) {
        boolean z;
        AppMethodBeat.m2504i(98551);
        if (c46770bd == null) {
            z = false;
            AppMethodBeat.m2505o(98551);
        } else {
            this.f18086b.append(101, c46770bd);
            z = true;
            AppMethodBeat.m2505o(98551);
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean mo65114a(C44498ay c44498ay) {
        boolean z;
        AppMethodBeat.m2504i(98552);
        if (c44498ay == null) {
            z = false;
            AppMethodBeat.m2505o(98552);
        } else {
            if (!this.f18087c.contains(c44498ay)) {
                this.f18087c.add(c44498ay);
            }
            z = true;
            AppMethodBeat.m2505o(98552);
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:119:0x02df, code skipped:
            com.tencent.tencentmap.mapsdk.maps.p667a.C46771bf.m88725a(r4, r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo65113a(C44499az c44499az) {
        int i;
        Throwable th;
        boolean z = false;
        AppMethodBeat.m2504i(98553);
        if (!(this.f18090f && mo75359b())) {
            if (c44499az.mo70869c() == 2) {
                C16205ag.m24691h("  Not UpProc real event sync 2 DB done false", new Object[0]);
                c44499az.mo41920b(false);
            }
            if (c44499az.f17401b != 0) {
                C16205ag.m24691h("  Not UpProc not req: %d", Integer.valueOf(c44499az.mo70869c()));
                AppMethodBeat.m2505o(98553);
                return;
            }
            C16205ag.m24691h("  NotUpProc com req start ", new Object[0]);
        }
        if (!C24349e.m37621m(this.f18089e)) {
            C16205ag.m24686c(" doUpload network is disabled!", new Object[0]);
            if (c44499az.mo70869c() == 2) {
                c44499az.mo41920b(false);
            }
            AppMethodBeat.m2505o(98553);
        } else if (c44499az == null) {
            C16205ag.m24687d(" upData == null ", new Object[0]);
            AppMethodBeat.m2505o(98553);
        } else {
            int c = c44499az.mo70869c();
            String e = c44499az.mo70871e();
            if (e == null || "".equals(e.trim())) {
                C16205ag.m24687d(" url error", new Object[0]);
                if (c44499az.mo70869c() == 2) {
                    c44499az.mo41920b(false);
                }
                m88724a(c, -1, false, "url error");
                AppMethodBeat.m2505o(98553);
                return;
            }
            byte[] b = C46771bf.m88726b(c44499az);
            String d = c44499az.mo70870d();
            String str = null;
            if (d != null) {
                str = "?rid=".concat(String.valueOf(d));
            }
            C44540v a = C44540v.m80860a();
            if (a != null) {
                d = a.mo70949l();
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
            C16205ag.m24691h(" start upload cmd: %d  url:%s  datas:%s", Integer.valueOf(c), str, c44499az.getClass().toString());
            if (b == null) {
                C16205ag.m24686c(" sendData is null", new Object[0]);
                m88724a(c, -1, false, "sendData error");
                AppMethodBeat.m2505o(98553);
                return;
            }
            C41032bc d2 = m88728d();
            if (d2 == null) {
                C16205ag.m24687d(" reqH error", new Object[0]);
                m88724a(c, -1, false, "reqHandler error");
                AppMethodBeat.m2505o(98553);
                return;
            }
            C24349e.m37611f(this.f18089e);
            C41014c.m71224m().mo65058h();
            new Date().getTime();
            try {
                byte[] a2;
                byte[] a3 = d2.mo50349a(str, b, c44499az);
                if (a3 == null && c == 100 && !"http://strategy.beacon.qq.com/analytics/upload?mType=beacon".equals(str)) {
                    a2 = d2.mo50349a("http://strategy.beacon.qq.com/analytics/upload?mType=beacon", b, c44499az);
                } else {
                    a2 = a3;
                }
                C36482ab a4 = C46771bf.m88721a(a2);
                if (a4 != null) {
                    boolean z2;
                    i = a4.f15258b;
                    try {
                        z2 = a4.f15257a == (byte) 0;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            m88724a(c, i, false, th.toString());
                            C16205ag.m24687d(" req error  %s", th.toString());
                            c44499az.mo41920b(z);
                            AppMethodBeat.m2505o(98553);
                        } catch (Throwable th3) {
                            th = th3;
                            c44499az.mo41920b(z);
                            AppMethodBeat.m2505o(98553);
                            throw th;
                        }
                    }
                    try {
                        C16205ag.m24685b("response.cmd:%d response.result:%d", Integer.valueOf(a4.f15258b), Byte.valueOf(a4.f15257a));
                        z = z2;
                    } catch (Throwable th4) {
                        th = th4;
                        z = z2;
                        c44499az.mo41920b(z);
                        AppMethodBeat.m2505o(98553);
                        throw th;
                    }
                }
                i = -1;
                if (!(c44499az == null || a4 == null)) {
                    C41014c m = C41014c.m71224m();
                    if (m != null) {
                        if (a4.f15260d != null) {
                            m.mo65051b(a4.f15260d.trim());
                        }
                        m.mo65048a(a4.f15261e - new Date().getTime());
                        C16205ag.m24691h(" fix ip:%s  tmgap: %d", m.mo65057g(), Long.valueOf(m.mo65058h()));
                    }
                    if (a4.f15258b == 101 || a4.f15258b == 103 || a4.f15258b == 105) {
                        C36541t.m60530a(this.f18089e).mo57789e();
                    }
                    byte[] bArr = a4.f15259c;
                    if (bArr != null) {
                        SparseArray e2 = m88729e();
                        if (e2 != null && e2.size() > 0) {
                            int c2 = c44499az.mo70869c();
                            int i2 = a4.f15258b;
                            if (i2 != 0) {
                                switch (c2) {
                                    case 4:
                                        if (i2 != 105) {
                                            C16205ag.m24686c(" UNMATCH req: %d , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    case 100:
                                        if (i2 != 101) {
                                            C16205ag.m24686c(" UNMATCH req: %d , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    case 102:
                                        if (i2 != 103) {
                                            C16205ag.m24686c(" UNMATCH req: %d  , rep: %d", Integer.valueOf(c2), Integer.valueOf(i2));
                                            break;
                                        }
                                    default:
                                        C16205ag.m24686c(" unknown req: %d ", Integer.valueOf(c2));
                                        break;
                                }
                            }
                            C16205ag.m24691h(" response no datas ", new Object[0]);
                        } else {
                            C16205ag.m24691h(" no handler! ", new Object[0]);
                        }
                    } else {
                        C16205ag.m24691h(" no response! ", new Object[0]);
                    }
                }
                m88724a(c, i, z, null);
                c44499az.mo41920b(z);
                AppMethodBeat.m2505o(98553);
            } catch (Throwable th5) {
                th = th5;
                i = -1;
                m88724a(c, i, false, th.toString());
                C16205ag.m24687d(" req error  %s", th.toString());
                c44499az.mo41920b(z);
                AppMethodBeat.m2505o(98553);
            }
        }
    }

    /* renamed from: b */
    private static byte[] m88726b(C44499az c44499az) {
        AppMethodBeat.m2504i(98554);
        if (c44499az != null) {
            try {
                C36481aa a = c44499az.mo41919a();
                if (a != null) {
                    C16205ag.m24685b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", a.f15245b, a.f15247d, a.f15246c, Integer.valueOf(a.f15249f));
                    C31018al c31018al = new C31018al();
                    c31018al.mo50337a();
                    c31018al.mo50342b("test");
                    c31018al.mo50338a("test");
                    c31018al.mo50339a("detail", a);
                    byte[] b = c31018al.mo50343b();
                    C44540v a2 = C44540v.m80860a();
                    if (a2 != null) {
                        b = C24349e.m37588a(b, a2.mo70946i(), a2.mo70945h(), a2.mo70948k());
                        AppMethodBeat.m2505o(98554);
                        return b;
                    }
                }
            } catch (Throwable th) {
                C16205ag.m24687d(" parseSendDatas error", new Object[0]);
                C16205ag.m24684a(th);
                c44499az.mo70868b();
            }
        }
        AppMethodBeat.m2505o(98554);
        return null;
    }

    /* renamed from: a */
    private static C36482ab m88721a(byte[] bArr) {
        AppMethodBeat.m2504i(98555);
        if (bArr != null) {
            try {
                byte[] b;
                C44540v a = C44540v.m80860a();
                if (a != null) {
                    b = C24349e.m37599b(bArr, a.mo70946i(), a.mo70945h(), a.mo70948k());
                } else {
                    b = null;
                }
                if (b != null) {
                    C31018al c31018al = new C31018al();
                    c31018al.mo50340a(b);
                    C36482ab c36482ab = new C36482ab();
                    C16205ag.m24685b(" covert to ResponsePackage ", new Object[0]);
                    c36482ab = (C36482ab) c31018al.mo50341b("detail", c36482ab);
                    AppMethodBeat.m2505o(98555);
                    return c36482ab;
                }
            } catch (Throwable th) {
                C16205ag.m24684a(th);
            }
        }
        AppMethodBeat.m2505o(98555);
        return null;
    }

    /* renamed from: a */
    private void m88724a(int i, int i2, boolean z, String str) {
        AppMethodBeat.m2504i(98556);
        C44498ay[] c = m88727c();
        if (c != null) {
            for (C44498ay a : c) {
                a.mo70867a(i, i2, 0, 0, z, str);
            }
        }
        AppMethodBeat.m2505o(98556);
    }

    /* renamed from: c */
    private synchronized C44498ay[] m88727c() {
        C44498ay[] c44498ayArr;
        AppMethodBeat.m2504i(98557);
        if (this.f18087c == null || this.f18087c.size() <= 0) {
            c44498ayArr = null;
            AppMethodBeat.m2505o(98557);
        } else {
            c44498ayArr = (C44498ay[]) this.f18087c.toArray(new C44498ay[0]);
            AppMethodBeat.m2505o(98557);
        }
        return c44498ayArr;
    }

    /* renamed from: d */
    private synchronized C41032bc m88728d() {
        return this.f18088d;
    }

    /* renamed from: e */
    private synchronized SparseArray<C46770bd> m88729e() {
        SparseArray<C46770bd> sparseArray;
        AppMethodBeat.m2504i(98558);
        if (this.f18086b == null || this.f18086b.size() <= 0) {
            sparseArray = null;
            AppMethodBeat.m2505o(98558);
        } else {
            C36483ah c36483ah = new C36483ah();
            sparseArray = C36483ah.m60324a(this.f18086b);
            AppMethodBeat.m2505o(98558);
        }
        return sparseArray;
    }

    /* renamed from: a */
    private static boolean m88725a(SparseArray<C46770bd> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.m2504i(98559);
        if (sparseArray == null || bArr == null) {
            AppMethodBeat.m2505o(98559);
            return true;
        }
        switch (i) {
            case 103:
                AppMethodBeat.m2505o(98559);
                return true;
            default:
                C46770bd c46770bd = (C46770bd) sparseArray.get(i);
                if (c46770bd == null) {
                    C16205ag.m24686c(" no handler key:%d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(98559);
                    return false;
                }
                try {
                    C16205ag.m24685b(" key:%d  handler: %s", Integer.valueOf(i), c46770bd.getClass().toString());
                    c46770bd.mo75357a(i, bArr, true);
                    AppMethodBeat.m2505o(98559);
                    return true;
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d(" handle error key:%d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(98559);
                    return false;
                }
        }
    }

    /* renamed from: a */
    public final boolean mo75358a() {
        return this.f18090f;
    }

    /* renamed from: b */
    public final synchronized boolean mo75359b() {
        boolean z;
        AppMethodBeat.m2504i(98560);
        if (C24349e.m37620l(this.f18089e)) {
            z = true;
            AppMethodBeat.m2505o(98560);
        } else {
            z = this.f18091g;
            AppMethodBeat.m2505o(98560);
        }
        return z;
    }
}
