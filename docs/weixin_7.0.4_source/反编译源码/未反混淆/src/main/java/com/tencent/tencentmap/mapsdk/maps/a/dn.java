package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dn extends dk implements el {
    private cl a = new cl();
    private List<Object> b = new ArrayList();

    public dn() {
        AppMethodBeat.i(98724);
        bt.j().post(new do(this));
        AppMethodBeat.o(98724);
    }

    private synchronized void a() {
        AppMethodBeat.i(98728);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(98728);
    }

    static /* synthetic */ void b(dn dnVar) {
        AppMethodBeat.i(98729);
        dnVar.a();
        AppMethodBeat.o(98729);
    }

    public final String a(String str, int i, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(98727);
        String a = this.a.a(str, i, str2, str3, str4, str5);
        AppMethodBeat.o(98727);
        return a;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98726);
        if (!(TextUtils.isEmpty(str2) || ds.a().b().equals(str2))) {
            ds.a().a(str2, true);
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                try {
                    this.a.b();
                    this.a.a(str);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(98726);
                    }
                }
            }
            er.a("settings_in_client", this.a.a(), true);
            a();
        }
        AppMethodBeat.o(98726);
    }

    public final String b() {
        return "settings";
    }

    public final void c() {
        AppMethodBeat.i(98725);
        en.d().b();
        AppMethodBeat.o(98725);
    }
}
