package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aw */
public final class C25008aw implements C24355au {
    /* renamed from: a */
    private boolean f4996a = false;
    /* renamed from: b */
    private List<C24356av> f4997b;
    /* renamed from: c */
    private Context f4998c;
    /* renamed from: d */
    private Runnable f4999d = new C162071();
    /* renamed from: e */
    private Runnable f5000e = new C250092();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aw$1 */
    class C162071 implements Runnable {
        C162071() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98510);
            try {
                C25008aw.this.mo41916a();
                AppMethodBeat.m2505o(98510);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(98510);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aw$2 */
    class C250092 implements Runnable {
        C250092() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98511);
            C25008aw.m39257a(C25008aw.this);
            AppMethodBeat.m2505o(98511);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aw$a */
    static class C25010a extends C44499az {
        /* renamed from: e */
        private List<C24356av> f5002e = null;
        /* renamed from: f */
        private Context f5003f;
        /* renamed from: g */
        private Long[] f5004g = null;
        /* renamed from: h */
        private boolean f5005h = false;

        public C25010a(Context context, List<C24356av> list) {
            super(context, 1, 2);
            AppMethodBeat.m2504i(98512);
            this.f5002e = list;
            this.f5003f = context;
            this.f5002e.size();
            if (this.f5002e.size() == 1 && "rqd_heartbeat".equals(((C24356av) this.f5002e.get(0)).mo40536d())) {
                this.f5005h = true;
            }
            this.f17403d = C24349e.m37595b(context, 2);
            C16205ag.m24683a("real rid:%s", this.f17403d);
            AppMethodBeat.m2505o(98512);
        }

        /* renamed from: a */
        public final synchronized C36481aa mo41919a() {
            C36481aa c36481aa;
            AppMethodBeat.m2504i(98513);
            C16205ag.m24685b(" TUUD.GetUD start", new Object[0]);
            if (this.f5002e == null || this.f5002e.size() <= 0) {
                AppMethodBeat.m2505o(98513);
                c36481aa = null;
            } else {
                try {
                    c36481aa = C25010a.m39265a(this.f17400a, this.f5002e);
                    if (c36481aa != null) {
                        AppMethodBeat.m2505o(98513);
                    }
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d(" TUUD.GetUD start error", new Object[0]);
                }
                AppMethodBeat.m2505o(98513);
                c36481aa = null;
            }
            return c36481aa;
        }

        /* renamed from: a */
        private static C36481aa m39265a(int i, List<C24356av> list) {
            C36481aa c36481aa = null;
            AppMethodBeat.m2504i(98514);
            if (list == null || list.size() <= 0) {
                AppMethodBeat.m2505o(98514);
            } else {
                try {
                    C16205ag.m24685b(" current size:" + list.size(), new Object[0]);
                    C5854ad a = C25010a.m39266a(list);
                    if (a == null) {
                        AppMethodBeat.m2505o(98514);
                    } else {
                        byte[] a2 = a.mo65110a();
                        if (a2 == null) {
                            AppMethodBeat.m2505o(98514);
                        } else {
                            c36481aa = C44499az.m80700a(i, a2);
                            AppMethodBeat.m2505o(98514);
                        }
                    }
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
                    AppMethodBeat.m2505o(98514);
                }
            }
            return c36481aa;
        }

        /* renamed from: a */
        private static C5854ad m39266a(List<C24356av> list) {
            AppMethodBeat.m2504i(98515);
            if (list == null || list.size() <= 0) {
                AppMethodBeat.m2505o(98515);
                return null;
            }
            try {
                C5854ad c5854ad = new C5854ad();
                ArrayList arrayList = new ArrayList();
                for (C24356av a : list) {
                    C5853ac a2 = C24349e.m37575a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                c5854ad.f1519a = arrayList;
                C16205ag.m24685b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
                AppMethodBeat.m2505o(98515);
                return c5854ad;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(98515);
                return null;
            }
        }

        /* renamed from: b */
        public final synchronized void mo41920b(boolean z) {
            AppMethodBeat.m2504i(98516);
            C16205ag.m24685b(" TimeUpUploadDatas.done(), result:%b", Boolean.valueOf(z));
            if (!(this.f5002e == null || z)) {
                C16205ag.m24689f(" upload failed, save to db", new Object[0]);
                if (!this.f5005h) {
                    this.f5004g = C24349e.m37590a(this.f5003f, this.f5002e);
                    this.f5002e = null;
                }
            }
            if (z && this.f5005h) {
                Context context = this.f5003f;
                C46752b.m88622a().mo12296a(108);
                C41003a.m71118a(context, "HEART_DENGTA", C24349e.m37613g());
                C16205ag.m24683a("heartbeat uploaded sucess!", new Object[0]);
            }
            if (z && this.f5004g != null) {
                C24349e.m37572a(this.f5003f, this.f5004g);
            }
            if (z && this.f5004g == null && this.f5002e != null) {
                this.f5002e = null;
            }
            AppMethodBeat.m2505o(98516);
        }
    }

    public C25008aw(Context context) {
        AppMethodBeat.m2504i(98517);
        this.f4998c = context;
        this.f4997b = Collections.synchronizedList(new ArrayList(25));
        AppMethodBeat.m2505o(98517);
    }

    /* renamed from: a */
    public final synchronized boolean mo40526a(C24356av c24356av) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(98518);
            String str = " BF eN:%s   isRT:%b";
            Object[] objArr = new Object[2];
            objArr[0] = c24356av == null ? BuildConfig.COMMAND : c24356av.mo40536d();
            objArr[1] = Boolean.TRUE;
            C16205ag.m24689f(str, objArr);
            if (this.f4998c == null || c24356av == null) {
                C16205ag.m24686c("processUA return false, context is null or bean is null !", new Object[0]);
                AppMethodBeat.m2505o(98518);
            } else if (m39259c()) {
                C46769as g = C25011ax.m39275d().mo41926g();
                int a = g.mo75342a();
                long b = (long) (g.mo75346b() * 1000);
                if (this.f4997b.size() >= a || c24356av.mo40538f()) {
                    C16205ag.m24689f(" BF mN!", new Object[0]);
                    C46752b.m88622a().mo12298a(this.f4999d);
                    C46752b.m88622a().mo12297a(103, this.f4999d, b, b);
                }
                this.f4997b.add(c24356av);
                if (this.f4997b.size() >= a) {
                    C16205ag.m24686c(" err BF 3R! num:" + this.f4997b.size(), new Object[0]);
                }
                if ("rqd_applaunched".equals(c24356av.mo40536d())) {
                    C46752b.m88622a().mo12298a(this.f4999d);
                }
                C16205ag.m24683a("processUA:true!", new Object[0]);
                AppMethodBeat.m2505o(98518);
                z = true;
            } else {
                C16205ag.m24686c("processUA return false, isEnable is false !", new Object[0]);
                AppMethodBeat.m2505o(98518);
            }
        }
        return z;
    }

    /* renamed from: b */
    private synchronized List<C24356av> m39258b() {
        List<C24356av> list;
        AppMethodBeat.m2504i(98519);
        if (this.f4997b == null || this.f4997b.size() <= 0 || !m39259c()) {
            list = null;
            AppMethodBeat.m2505o(98519);
        } else {
            list = new ArrayList();
            list.addAll(this.f4997b);
            this.f4997b.clear();
            C16205ag.m24685b(" get realEventCnt in Mem:" + list.size(), new Object[0]);
            AppMethodBeat.m2505o(98519);
        }
        return list;
    }

    /* renamed from: c */
    private synchronized boolean m39259c() {
        return this.f4996a;
    }

    /* renamed from: a */
    public final synchronized void mo40525a(boolean z) {
        AppMethodBeat.m2504i(98520);
        if (this.f4996a != z) {
            if (z) {
                this.f4996a = z;
                C46752b.m88622a().mo12297a(103, this.f4999d, 5000, (long) (C25011ax.m39275d().mo41926g().mo75346b() * 1000));
                AppMethodBeat.m2505o(98520);
            } else {
                C46752b.m88622a().mo12296a(103);
                mo41917b(true);
                this.f4996a = z;
            }
        }
        AppMethodBeat.m2505o(98520);
    }

    /* renamed from: b */
    public final synchronized void mo41917b(boolean z) {
        AppMethodBeat.m2504i(98521);
        C16205ag.m24688e("realtime process flush memory objects to db.", new Object[0]);
        if (z) {
            m39260d();
            AppMethodBeat.m2505o(98521);
        } else {
            C46752b.m88622a().mo12298a(this.f5000e);
            AppMethodBeat.m2505o(98521);
        }
    }

    /* renamed from: d */
    private void m39260d() {
        AppMethodBeat.m2504i(98522);
        List b = m39258b();
        if (b != null && b.size() > 0) {
            C16205ag.m24689f(" dsb real events 2 db" + b.size(), new Object[0]);
            C24349e.m37590a(this.f4998c, b);
        }
        AppMethodBeat.m2505o(98522);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo41916a() {
        AppMethodBeat.m2504i(98523);
        if (m39259c()) {
            List b = m39258b();
            if (b != null && b.size() > 0) {
                C41033be f = C25011ax.m39275d().mo41925f();
                if (!C24349e.m37621m(this.f4998c) || f == null) {
                    C16205ag.m24689f(" dsu real events 2 db" + b.size(), new Object[0]);
                    C24349e.m37590a(this.f4998c, b);
                    AppMethodBeat.m2505o(98523);
                    return;
                }
                C16205ag.m24689f(" dsu real events 2 up " + b.size(), new Object[0]);
                f.mo65113a(new C25010a(this.f4998c, b));
            }
            AppMethodBeat.m2505o(98523);
            return;
        }
        C16205ag.m24686c(" err su 1R", new Object[0]);
        AppMethodBeat.m2505o(98523);
    }
}
