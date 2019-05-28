package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16290jm.C16291a;
import com.tencent.tencentmap.mapsdk.p666a.C16201o;
import com.tencent.tencentmap.mapsdk.p666a.C16203q;
import com.tencent.tencentmap.mapsdk.p666a.C25001ar;
import com.tencent.tencentmap.mapsdk.p666a.C36463bi;
import com.tencent.tencentmap.mapsdk.p666a.C44480ak;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jk */
public class C16287jk implements C16291a {
    /* renamed from: a */
    private Context f3446a;
    /* renamed from: b */
    private C36463bi f3447b;
    /* renamed from: c */
    private C24415ls f3448c;
    /* renamed from: d */
    private C16203q f3449d;
    /* renamed from: e */
    private C16286jj f3450e;
    /* renamed from: f */
    private List<AsyncTask> f3451f = new ArrayList();
    /* renamed from: g */
    private C41067jo f3452g;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jk$a */
    public interface C16288a {
        /* renamed from: a */
        void mo29535a(Bitmap bitmap, int i, int i2);
    }

    public C16287jk(C25001ar c25001ar, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100049);
        this.f3446a = c25001ar.mo41911m();
        this.f3448c = c25001ar.mo41910l().mo50478o();
        this.f3447b = c25001ar.mo41898a();
        this.f3449d = c25001ar.mo41903b();
        this.f3450e = c25001ar.mo41905c();
        String str = "";
        String str2 = "";
        if (c44480ak != null) {
            if (!StringUtil.isEmpty(c44480ak.mo70667h())) {
                str = c44480ak.mo70667h().trim();
            }
            if (!StringUtil.isEmpty(c44480ak.mo70666g())) {
                str2 = c44480ak.mo70666g().trim();
            }
        }
        this.f3452g = new C41067jo(this.f3446a, c25001ar, str);
        this.f3451f.add(new C16289jl(this.f3447b.f15217a, this, str, str2));
        this.f3451f.add(new C16290jm(this.f3446a, this));
        AppMethodBeat.m2505o(100049);
    }

    /* renamed from: a */
    public void mo29531a(C16288a c16288a, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100050);
        this.f3447b.mo57686a(c16288a, c44480ak);
        AppMethodBeat.m2505o(100050);
    }

    /* renamed from: a */
    public void mo29530a() {
        AppMethodBeat.m2504i(100051);
        for (AsyncTask execute : this.f3451f) {
            execute.execute(new Object[0]);
        }
        AppMethodBeat.m2505o(100051);
    }

    /* renamed from: a */
    public void mo29532a(JSONArray jSONArray, C16201o c16201o) {
        AppMethodBeat.m2504i(100052);
        if (this.f3449d == null) {
            AppMethodBeat.m2505o(100052);
            return;
        }
        this.f3449d.mo29202a(jSONArray);
        this.f3450e.mo29527a(c16201o);
        int i = C16286jj.f3440c;
        if (c16201o != null) {
            i = c16201o.mo29194b();
        }
        this.f3452g.mo65153a(this.f3449d.mo29200a(), i);
        AppMethodBeat.m2505o(100052);
    }

    /* renamed from: b */
    public void mo29534b() {
        AppMethodBeat.m2504i(100053);
        if (this.f3451f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f3451f.size()) {
                    break;
                }
                ((AsyncTask) this.f3451f.get(i2)).cancel(true);
                i = i2 + 1;
            }
            this.f3451f.clear();
        }
        this.f3451f = null;
        AppMethodBeat.m2505o(100053);
    }

    /* renamed from: a */
    public void mo29533a(boolean z) {
        AppMethodBeat.m2504i(100054);
        if (this.f3447b == null) {
            AppMethodBeat.m2505o(100054);
            return;
        }
        this.f3447b.mo57689i(z);
        if (z) {
            this.f3448c.mo40744d();
        }
        this.f3448c.mo40741a(true);
        AppMethodBeat.m2505o(100054);
    }
}
