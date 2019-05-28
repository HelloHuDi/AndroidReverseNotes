package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30981g;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30985h;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30986j;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30987k;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30988a;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30990c;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30991i;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C5835p;

/* renamed from: com.tencent.tencentmap.mapsdk.a.br */
public class C41012br {
    /* renamed from: a */
    private C24338bw f16375a = null;
    /* renamed from: b */
    private C5835p f16376b = null;
    /* renamed from: c */
    private Handler f16377c = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(100884);
            if (message != null && message.what == 0) {
                if (C41012br.this.f16376b != null) {
                    C41012br.this.f16376b.mo12295a((Bitmap) message.obj);
                }
                C41012br.this.f16376b = null;
            }
            AppMethodBeat.m2505o(100884);
        }
    };

    public C41012br(C24338bw c24338bw) {
        AppMethodBeat.m2504i(100885);
        this.f16375a = c24338bw;
        mo65028c(false);
        AppMethodBeat.m2505o(100885);
    }

    /* renamed from: a */
    public void mo65007a() {
        if (this.f16375a != null) {
            this.f16375a = null;
        }
    }

    /* renamed from: b */
    public C5841cp mo65023b() {
        AppMethodBeat.m2504i(100886);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100886);
            return null;
        }
        C5841cp g = this.f16375a.mo40453g();
        AppMethodBeat.m2505o(100886);
        return g;
    }

    /* renamed from: c */
    public final float mo65027c() {
        AppMethodBeat.m2504i(100887);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100887);
            return -1.0f;
        }
        float h = this.f16375a.mo40454h();
        AppMethodBeat.m2505o(100887);
        return h;
    }

    /* renamed from: d */
    public final float mo65029d() {
        AppMethodBeat.m2504i(100888);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100888);
            return -1.0f;
        }
        float i = this.f16375a.mo40455i();
        AppMethodBeat.m2505o(100888);
        return i;
    }

    /* renamed from: a */
    public final int mo65004a(C41004ad c41004ad) {
        AppMethodBeat.m2504i(100889);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100889);
            return C8415j.INVALID_ID;
        }
        int a = this.f16375a.mo40429a(c41004ad);
        AppMethodBeat.m2505o(100889);
        return a;
    }

    /* renamed from: a */
    public final int mo65005a(C41004ad c41004ad, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100890);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100890);
            return C8415j.INVALID_ID;
        }
        int a = this.f16375a.mo40430a(c41004ad, j, c30988a);
        AppMethodBeat.m2505o(100890);
        return a;
    }

    /* renamed from: e */
    public final void mo65031e() {
        AppMethodBeat.m2504i(100891);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100891);
            return;
        }
        this.f16375a.mo40456j();
        AppMethodBeat.m2505o(100891);
    }

    /* renamed from: a */
    public final void mo65009a(int i) {
        AppMethodBeat.m2504i(100892);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100892);
            return;
        }
        this.f16375a.mo40432a(i);
        AppMethodBeat.m2505o(100892);
    }

    /* renamed from: a */
    public final void mo65022a(boolean z) {
        AppMethodBeat.m2504i(100893);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100893);
            return;
        }
        this.f16375a.mo40445a(z);
        AppMethodBeat.m2505o(100893);
    }

    /* renamed from: b */
    public final void mo65026b(boolean z) {
        AppMethodBeat.m2504i(100894);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100894);
            return;
        }
        this.f16375a.mo40449b(z);
        AppMethodBeat.m2505o(100894);
    }

    /* renamed from: f */
    public final boolean mo65033f() {
        AppMethodBeat.m2504i(100895);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100895);
            return false;
        }
        boolean k = this.f16375a.mo40457k();
        AppMethodBeat.m2505o(100895);
        return k;
    }

    /* renamed from: a */
    public final void mo65013a(C30985h c30985h) {
        AppMethodBeat.m2504i(100896);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100896);
            return;
        }
        this.f16375a.mo40437a(c30985h);
        AppMethodBeat.m2505o(100896);
    }

    /* renamed from: a */
    public final void mo65015a(C30986j c30986j) {
        AppMethodBeat.m2504i(100897);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100897);
            return;
        }
        this.f16375a.mo40439a(c30986j);
        AppMethodBeat.m2505o(100897);
    }

    /* renamed from: a */
    public final void mo65010a(C30990c c30990c) {
        AppMethodBeat.m2504i(100898);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100898);
            return;
        }
        this.f16375a.mo40434a(c30990c);
        AppMethodBeat.m2505o(100898);
    }

    /* renamed from: g */
    public void mo65034g() {
        AppMethodBeat.m2504i(100899);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100899);
            return;
        }
        this.f16375a.mo40458n();
        AppMethodBeat.m2505o(100899);
    }

    /* renamed from: h */
    public void mo65035h() {
        AppMethodBeat.m2504i(100900);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100900);
            return;
        }
        this.f16375a.mo40459o();
        AppMethodBeat.m2505o(100900);
    }

    /* renamed from: i */
    public void mo65036i() {
        AppMethodBeat.m2504i(100901);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100901);
            return;
        }
        this.f16375a.mo40463t();
        AppMethodBeat.m2505o(100901);
    }

    /* renamed from: j */
    public void mo65037j() {
        AppMethodBeat.m2504i(100902);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100902);
            return;
        }
        this.f16375a.mo40464u();
        AppMethodBeat.m2505o(100902);
    }

    /* renamed from: k */
    public void mo65038k() {
        AppMethodBeat.m2504i(100903);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100903);
            return;
        }
        this.f16375a.mo40460p();
        AppMethodBeat.m2505o(100903);
    }

    /* renamed from: l */
    public void mo65039l() {
        AppMethodBeat.m2504i(100904);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100904);
            return;
        }
        this.f16375a.mo40461q();
        AppMethodBeat.m2505o(100904);
    }

    /* renamed from: a */
    private void m71174a(Handler handler, Config config) {
        AppMethodBeat.m2504i(100905);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100905);
            return;
        }
        this.f16375a.mo40433a(handler, config);
        AppMethodBeat.m2505o(100905);
    }

    /* renamed from: a */
    public void mo65018a(C5835p c5835p, Config config) {
        AppMethodBeat.m2504i(100906);
        if (this.f16375a == null || c5835p == null) {
            AppMethodBeat.m2505o(100906);
            return;
        }
        this.f16376b = c5835p;
        m71174a(this.f16377c, config);
        AppMethodBeat.m2505o(100906);
    }

    /* renamed from: a */
    public final void mo65020a(C44494dn c44494dn) {
        AppMethodBeat.m2504i(100907);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100907);
            return;
        }
        this.f16375a.mo40443a(c44494dn);
        AppMethodBeat.m2505o(100907);
    }

    /* renamed from: b */
    public final void mo65025b(C44494dn c44494dn) {
        AppMethodBeat.m2504i(100908);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100908);
            return;
        }
        this.f16375a.mo40448b(c44494dn);
        AppMethodBeat.m2505o(100908);
    }

    /* renamed from: a */
    public void mo65008a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(100909);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100909);
            return;
        }
        this.f16375a.mo40431a(f, f2, z);
        AppMethodBeat.m2505o(100909);
    }

    /* renamed from: m */
    public String mo65040m() {
        AppMethodBeat.m2504i(100910);
        String str;
        if (this.f16375a == null) {
            str = "";
            AppMethodBeat.m2505o(100910);
            return str;
        }
        str = this.f16375a.mo40462r();
        AppMethodBeat.m2505o(100910);
        return str;
    }

    /* renamed from: a */
    public void mo65014a(C30991i c30991i) {
        AppMethodBeat.m2504i(100911);
        if (this.f16375a != null) {
            this.f16375a.mo40438a(c30991i);
        }
        AppMethodBeat.m2505o(100911);
    }

    /* renamed from: a */
    public final void mo65017a(C30992l c30992l) {
        AppMethodBeat.m2504i(100912);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100912);
            return;
        }
        this.f16375a.mo40441a(c30992l);
        AppMethodBeat.m2505o(100912);
    }

    /* renamed from: a */
    public final void mo65012a(C30981g c30981g) {
        AppMethodBeat.m2504i(100913);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100913);
            return;
        }
        this.f16375a.mo40436a(c30981g);
        AppMethodBeat.m2505o(100913);
    }

    /* renamed from: a */
    public final void mo65011a(C24326f c24326f) {
        AppMethodBeat.m2504i(100914);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100914);
            return;
        }
        this.f16375a.mo40435a(c24326f);
        AppMethodBeat.m2505o(100914);
    }

    /* renamed from: c */
    public void mo65028c(boolean z) {
        AppMethodBeat.m2504i(100915);
        if (this.f16375a != null) {
            this.f16375a.mo40450d(z);
        }
        AppMethodBeat.m2505o(100915);
    }

    /* renamed from: b */
    public void mo65024b(int i) {
        AppMethodBeat.m2504i(100916);
        if (this.f16375a != null) {
            this.f16375a.mo40447b(i);
        }
        AppMethodBeat.m2505o(100916);
    }

    /* renamed from: n */
    public int mo65041n() {
        AppMethodBeat.m2504i(100917);
        if (this.f16375a != null) {
            int v = this.f16375a.mo40465v();
            AppMethodBeat.m2505o(100917);
            return v;
        }
        AppMethodBeat.m2505o(100917);
        return -1;
    }

    /* renamed from: o */
    public String[] mo65042o() {
        AppMethodBeat.m2504i(100918);
        if (this.f16375a != null) {
            String[] w = this.f16375a.mo40466w();
            AppMethodBeat.m2505o(100918);
            return w;
        }
        AppMethodBeat.m2505o(100918);
        return null;
    }

    /* renamed from: a */
    public String mo65006a(C24343db c24343db) {
        AppMethodBeat.m2504i(100919);
        if (this.f16375a != null) {
            String b = this.f16375a.mo40446b(c24343db);
            AppMethodBeat.m2505o(100919);
            return b;
        }
        AppMethodBeat.m2505o(100919);
        return null;
    }

    /* renamed from: a */
    public final void mo65016a(C30987k c30987k) {
        AppMethodBeat.m2504i(100920);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100920);
            return;
        }
        this.f16375a.mo40440a(c30987k);
        AppMethodBeat.m2505o(100920);
    }

    /* renamed from: d */
    public void mo65030d(boolean z) {
        AppMethodBeat.m2504i(100921);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100921);
            return;
        }
        this.f16375a.mo40451e(z);
        AppMethodBeat.m2505o(100921);
    }

    /* renamed from: p */
    public boolean mo65043p() {
        AppMethodBeat.m2504i(100922);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100922);
            return false;
        }
        boolean x = this.f16375a.mo40467x();
        AppMethodBeat.m2505o(100922);
        return x;
    }

    /* renamed from: a */
    public void mo65021a(String str, String str2) {
        AppMethodBeat.m2504i(100923);
        if (m71175a(str) || m71175a(str2)) {
            AppMethodBeat.m2505o(100923);
            return;
        }
        this.f16375a.mo40444a(str, str2);
        AppMethodBeat.m2505o(100923);
    }

    /* renamed from: a */
    private boolean m71175a(String str) {
        AppMethodBeat.m2504i(100924);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(100924);
            return true;
        }
        AppMethodBeat.m2505o(100924);
        return false;
    }

    /* renamed from: e */
    public void mo65032e(boolean z) {
        AppMethodBeat.m2504i(100925);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100925);
            return;
        }
        this.f16375a.mo40452f(z);
        AppMethodBeat.m2505o(100925);
    }

    /* renamed from: q */
    public boolean mo65044q() {
        AppMethodBeat.m2504i(100926);
        if (this.f16375a != null) {
            boolean y = this.f16375a.mo40468y();
            AppMethodBeat.m2505o(100926);
            return y;
        }
        AppMethodBeat.m2505o(100926);
        return false;
    }

    /* renamed from: a */
    public void mo65019a(C31001da c31001da) {
        AppMethodBeat.m2504i(100927);
        if (this.f16375a != null) {
            this.f16375a.mo40442a(c31001da);
        }
        AppMethodBeat.m2505o(100927);
    }

    /* renamed from: r */
    public String mo65045r() {
        AppMethodBeat.m2504i(100928);
        if (this.f16375a == null) {
            AppMethodBeat.m2505o(100928);
            return null;
        }
        String z = this.f16375a.mo40469z();
        AppMethodBeat.m2505o(100928);
        return z;
    }
}
