package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dn */
public final class C24365dn extends C44506dk implements C31041el {
    /* renamed from: a */
    private C31030cl f4664a = new C31030cl();
    /* renamed from: b */
    private List<Object> f4665b = new ArrayList();

    public C24365dn() {
        AppMethodBeat.m2504i(98724);
        C46772bt.m88746j().post(new C36498do(this));
        AppMethodBeat.m2505o(98724);
    }

    /* renamed from: a */
    private synchronized void m37693a() {
        AppMethodBeat.m2504i(98728);
        Iterator it = this.f4665b.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(98728);
    }

    /* renamed from: b */
    static /* synthetic */ void m37694b(C24365dn c24365dn) {
        AppMethodBeat.m2504i(98729);
        c24365dn.m37693a();
        AppMethodBeat.m2505o(98729);
    }

    /* renamed from: a */
    public final String mo40563a(String str, int i, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(98727);
        String a = this.f4664a.mo50352a(str, i, str2, str3, str4, str5);
        AppMethodBeat.m2505o(98727);
        return a;
    }

    /* renamed from: a */
    public final void mo40564a(String str, String str2) {
        AppMethodBeat.m2504i(98726);
        if (!(TextUtils.isEmpty(str2) || C44508ds.m80717a().mo70879b().equals(str2))) {
            C44508ds.m80717a().mo70878a(str2, true);
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f4664a) {
                try {
                    this.f4664a.mo50354b();
                    this.f4664a.mo50353a(str);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(98726);
                    }
                }
            }
            C24370er.m37713a("settings_in_client", this.f4664a.mo50351a(), true);
            m37693a();
        }
        AppMethodBeat.m2505o(98726);
    }

    /* renamed from: b */
    public final String mo29272b() {
        return "settings";
    }

    /* renamed from: c */
    public final void mo29273c() {
        AppMethodBeat.m2504i(98725);
        C46780en.m88752d().mo12421b();
        AppMethodBeat.m2505o(98725);
    }
}
