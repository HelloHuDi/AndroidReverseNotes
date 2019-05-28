package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.basemap.data.C45133b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31001da;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ls */
public class C24415ls {
    /* renamed from: a */
    private C31061iz f4865a = null;
    /* renamed from: b */
    private C41357lo f4866b = null;
    /* renamed from: c */
    private C5907lt f4867c = new C5907lt();
    /* renamed from: d */
    private int f4868d;
    /* renamed from: e */
    private volatile boolean f4869e = false;

    public C24415ls(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100469);
        this.f4865a = c31061iz;
        m38000f();
        AppMethodBeat.m2505o(100469);
    }

    /* renamed from: a */
    public C31061iz mo40736a() {
        return this.f4865a;
    }

    /* renamed from: b */
    public void mo40742b() {
        AppMethodBeat.m2504i(100470);
        C24415ls.m37998a(this.f4868d, C31016w.m49806a(this.f4865a.mo65138i()));
        this.f4865a = null;
        this.f4868d = 0;
        AppMethodBeat.m2505o(100470);
    }

    /* renamed from: a */
    public C41357lo mo40737a(C5907lt c5907lt) {
        AppMethodBeat.m2504i(100471);
        if (this.f4865a == null) {
            AppMethodBeat.m2505o(100471);
            return null;
        }
        C36519hz c41357lo = new C41357lo(this, c5907lt);
        this.f4865a.mo50454a(c41357lo);
        this.f4865a.mo75386b().mo20154a();
        this.f4868d = 0;
        AppMethodBeat.m2505o(100471);
        return c41357lo;
    }

    /* renamed from: c */
    public boolean mo40743c() {
        return this.f4869e;
    }

    /* renamed from: a */
    public void mo40741a(boolean z) {
        this.f4869e = z;
    }

    /* renamed from: a */
    public void mo40740a(String str) {
        AppMethodBeat.m2504i(100472);
        if (this.f4865a == null) {
            AppMethodBeat.m2505o(100472);
            return;
        }
        this.f4865a.mo50457b(str, true);
        this.f4865a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(100472);
    }

    /* renamed from: f */
    private void m38000f() {
        AppMethodBeat.m2504i(100473);
        C31015v.m49805c(C46765r.m88664b(this.f4865a.mo65138i()) + "/tencentmapsdk/rastermap/unmainland");
        C31015v.m49805c(C46765r.m88663a(this.f4865a.mo65138i()).mo75313a().getPath() + "/rastermap/taiwan");
        AppMethodBeat.m2505o(100473);
    }

    /* renamed from: d */
    public void mo40744d() {
        AppMethodBeat.m2504i(100474);
        if (this.f4866b != null) {
            this.f4866b.mo66015e();
        }
        AppMethodBeat.m2505o(100474);
    }

    /* renamed from: a */
    public void mo40738a(int i) {
        synchronized (C24415ls.class) {
            this.f4868d += i;
        }
    }

    /* renamed from: a */
    public static void m37998a(final int i, final C31016w c31016w) {
        AppMethodBeat.m2504i(100475);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(100468);
                int i = -1;
                if (c31016w != null) {
                    i = c31016w.mo65087b("worldTileCount");
                }
                if (i > 0 || i > 0) {
                    int i2;
                    if (i > 0) {
                        i2 = i + i;
                    } else {
                        i2 = i;
                    }
                    try {
                        i = ((HttpURLConnection) new URL("https://pr.map.qq.com/pingd?" + C36520ic.m60474a(i2)).openConnection()).getResponseCode();
                        if (c31016w == null) {
                            AppMethodBeat.m2505o(100468);
                            return;
                        } else if (i == 200) {
                            c31016w.mo65086a(new String[]{"worldTileCount"});
                            AppMethodBeat.m2505o(100468);
                            return;
                        } else {
                            c31016w.mo65082a("worldTileCount", i2);
                            AppMethodBeat.m2505o(100468);
                            return;
                        }
                    } catch (IOException e) {
                        if (c31016w != null) {
                            c31016w.mo65082a("worldTileCount", i2);
                        }
                        AppMethodBeat.m2505o(100468);
                        return;
                    }
                }
                AppMethodBeat.m2505o(100468);
            }
        }).start();
        AppMethodBeat.m2505o(100475);
    }

    /* renamed from: e */
    public void mo40745e() {
        AppMethodBeat.m2504i(100476);
        if (this.f4865a == null || this.f4865a.mo75386b() == null) {
            AppMethodBeat.m2505o(100476);
        } else if (this.f4865a.mo75386b().mo20225h() < 7) {
            m38001g();
            AppMethodBeat.m2505o(100476);
        } else if (!C24414lq.m37993d()) {
            if (this.f4866b != null) {
                m38001g();
            }
            AppMethodBeat.m2505o(100476);
        } else if (m37999a(C46801ln.m88998a().mo75520c("china"))) {
            if (this.f4866b != null) {
                m38001g();
            }
            AppMethodBeat.m2505o(100476);
        } else {
            if (this.f4866b == null) {
                m38002h();
            }
            AppMethodBeat.m2505o(100476);
        }
    }

    /* renamed from: a */
    public void mo40739a(C31001da c31001da) {
        AppMethodBeat.m2504i(100477);
        this.f4867c.mo12541a(c31001da);
        AppMethodBeat.m2505o(100477);
    }

    /* renamed from: g */
    private void m38001g() {
        AppMethodBeat.m2504i(100478);
        if (this.f4865a == null || this.f4865a.mo75386b() == null || this.f4866b == null) {
            AppMethodBeat.m2505o(100478);
            return;
        }
        C8889f b = this.f4865a.mo75386b();
        mo40740a(this.f4866b.mo57757A());
        b.mo20223g(true);
        b.mo20227h(true);
        this.f4866b = null;
        AppMethodBeat.m2505o(100478);
    }

    /* renamed from: h */
    private void m38002h() {
        AppMethodBeat.m2504i(100479);
        if (this.f4865a == null || this.f4865a.mo75386b() == null) {
            AppMethodBeat.m2505o(100479);
            return;
        }
        C8889f b = this.f4865a.mo75386b();
        b.mo20223g(false);
        b.mo20227h(false);
        this.f4866b = mo40737a(this.f4867c);
        AppMethodBeat.m2505o(100479);
    }

    /* renamed from: a */
    private boolean m37999a(C45133b[] c45133bArr) {
        AppMethodBeat.m2504i(100480);
        if (this.f4865a == null) {
            AppMethodBeat.m2505o(100480);
            return true;
        }
        C45133b[] R = this.f4865a.mo50425R();
        if (R == null || c45133bArr == null) {
            AppMethodBeat.m2505o(100480);
            return true;
        }
        boolean a = C46801ln.m89000a(R, c45133bArr);
        AppMethodBeat.m2505o(100480);
        return a;
    }
}
