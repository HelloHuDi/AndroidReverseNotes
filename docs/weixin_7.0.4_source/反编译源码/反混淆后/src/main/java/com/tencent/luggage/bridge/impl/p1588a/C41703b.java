package com.tencent.luggage.bridge.impl.p1588a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19163a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19165b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.luggage.bridge.impl.a.b */
public class C41703b implements C19162a {
    private final List<C19165b> bOX = new LinkedList();

    public C41703b() {
        AppMethodBeat.m2504i(90762);
        mo67373a(new C44678c());
        AppMethodBeat.m2505o(90762);
    }

    /* renamed from: bB */
    public final Bitmap mo34403bB(String str) {
        AppMethodBeat.m2504i(90763);
        Bitmap a = mo34401a(str, null, null);
        AppMethodBeat.m2505o(90763);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo34401a(String str, Rect rect, C19164c c19164c) {
        AppMethodBeat.m2504i(90764);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(90764);
            return null;
        }
        for (C19165b c19165b : this.bOX) {
            if (c19165b.match(str)) {
                Bitmap b = c19165b.mo22119b(str, rect, c19164c);
                AppMethodBeat.m2505o(90764);
                return b;
            }
        }
        AppMethodBeat.m2505o(90764);
        return null;
    }

    /* renamed from: a */
    public final void mo67373a(C19165b c19165b) {
        AppMethodBeat.m2504i(90765);
        if (this.bOX.contains(c19165b)) {
            this.bOX.remove(c19165b);
        }
        this.bOX.add(c19165b);
        AppMethodBeat.m2505o(90765);
    }

    /* renamed from: a */
    public final void mo34402a(String str, C19163a c19163a) {
        AppMethodBeat.m2504i(90766);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(90766);
            return;
        }
        for (C19165b c19165b : this.bOX) {
            if (c19165b.match(str)) {
                c19165b.mo22117a(str, c19163a);
            }
        }
        AppMethodBeat.m2505o(90766);
    }
}
