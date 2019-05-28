package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bf */
public class C36458bf {
    /* renamed from: a */
    private List<String> f15207a = new ArrayList();
    /* renamed from: b */
    private List<String> f15208b = new ArrayList();
    /* renamed from: c */
    private final int f15209c = 300;

    public C36458bf() {
        AppMethodBeat.m2504i(100782);
        AppMethodBeat.m2505o(100782);
    }

    /* renamed from: a */
    public synchronized boolean mo57657a(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(100783);
            if (str == null || str.trim().length() == 0) {
                AppMethodBeat.m2505o(100783);
            } else if (this.f15208b.contains(str)) {
                AppMethodBeat.m2505o(100783);
            } else {
                z = true;
                AppMethodBeat.m2505o(100783);
            }
        }
        return z;
    }

    /* renamed from: a */
    private void m60236a(List<String> list) {
        AppMethodBeat.m2504i(100784);
        if (list == null) {
            AppMethodBeat.m2505o(100784);
        } else if (list.size() <= 300) {
            AppMethodBeat.m2505o(100784);
        } else {
            list.remove(0);
            AppMethodBeat.m2505o(100784);
        }
    }

    /* renamed from: b */
    public synchronized void mo57658b(String str) {
        AppMethodBeat.m2504i(100785);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(100785);
        } else if (this.f15208b.contains(str)) {
            this.f15208b.remove(str);
            this.f15208b.add(str);
            AppMethodBeat.m2505o(100785);
        } else if (this.f15207a.contains(str)) {
            m60236a(this.f15208b);
            this.f15208b.add(str);
            this.f15207a.remove(str);
            AppMethodBeat.m2505o(100785);
        } else {
            m60236a(this.f15207a);
            this.f15207a.add(str);
            AppMethodBeat.m2505o(100785);
        }
    }
}
