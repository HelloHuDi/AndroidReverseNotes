package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ji */
public class C36903ji implements C36516gx {
    /* renamed from: a */
    private Context f15623a;
    /* renamed from: b */
    private final C46765r f15624b;
    /* renamed from: c */
    private String f15625c;

    public C36903ji(Context context, String str) {
        AppMethodBeat.m2504i(100036);
        if (context != null) {
            this.f15623a = context.getApplicationContext();
            this.f15624b = C46765r.m88663a(this.f15623a);
            this.f15625c = str;
            AppMethodBeat.m2505o(100036);
            return;
        }
        this.f15624b = null;
        AppMethodBeat.m2505o(100036);
    }

    /* renamed from: a */
    public String mo57745a() {
        AppMethodBeat.m2504i(100037);
        if (this.f15624b != null) {
            String b = this.f15624b.mo75315b();
            AppMethodBeat.m2505o(100037);
            return b;
        }
        AppMethodBeat.m2505o(100037);
        return null;
    }

    /* renamed from: b */
    public String mo57746b() {
        AppMethodBeat.m2504i(100038);
        if (this.f15624b != null) {
            String c = this.f15624b.mo75317c();
            AppMethodBeat.m2505o(100038);
            return c;
        }
        AppMethodBeat.m2505o(100038);
        return null;
    }

    /* renamed from: c */
    public String mo57747c() {
        AppMethodBeat.m2504i(100039);
        if (this.f15624b != null) {
            String b = this.f15624b.mo75316b(this.f15625c);
            AppMethodBeat.m2505o(100039);
            return b;
        }
        AppMethodBeat.m2505o(100039);
        return null;
    }

    /* renamed from: d */
    public String mo57748d() {
        AppMethodBeat.m2504i(100040);
        if (this.f15624b != null) {
            String c = this.f15624b.mo75318c(this.f15625c);
            AppMethodBeat.m2505o(100040);
            return c;
        }
        AppMethodBeat.m2505o(100040);
        return null;
    }

    /* renamed from: e */
    public String mo57749e() {
        AppMethodBeat.m2504i(100041);
        if (this.f15624b != null) {
            String d = this.f15624b.mo75319d();
            AppMethodBeat.m2505o(100041);
            return d;
        }
        AppMethodBeat.m2505o(100041);
        return null;
    }
}
