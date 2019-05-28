package com.tencent.p177mm.plugin.freewifi.p973b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.freewifi.b.a */
public final class C43103a {
    private Map<String, C20779b> cache;
    private boolean mvc;

    /* renamed from: com.tencent.mm.plugin.freewifi.b.a$a */
    static class C20778a {
        private static C43103a mve = new C43103a();

        static {
            AppMethodBeat.m2504i(20662);
            AppMethodBeat.m2505o(20662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.b.a$b */
    public static class C20779b {
        String cuH;
        int mue;
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.b.a$1 */
    class C431021 extends LinkedHashMap<String, C20779b> {
        C431021() {
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean removeEldestEntry(Entry entry) {
            AppMethodBeat.m2504i(20661);
            if (size() > 512) {
                AppMethodBeat.m2505o(20661);
                return true;
            }
            AppMethodBeat.m2505o(20661);
            return false;
        }
    }

    /* synthetic */ C43103a(byte b) {
        this();
    }

    private C43103a() {
        AppMethodBeat.m2504i(20663);
        this.mvc = false;
        this.cache = new C431021();
        AppMethodBeat.m2505o(20663);
    }

    /* renamed from: ep */
    private static String m76630ep(String str, String str2) {
        AppMethodBeat.m2504i(20664);
        String str3 = str + "-" + str2;
        AppMethodBeat.m2505o(20664);
        return str3;
    }

    /* renamed from: e */
    public final synchronized void mo68615e(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(20665);
        if (C34189m.isEmpty(str) || C34189m.isEmpty(str2) || C34189m.isEmpty(str3) || !(i == 4 || i == 31)) {
            AppMethodBeat.m2505o(20665);
        } else {
            C20779b c20779b = new C20779b();
            c20779b.cuH = str3;
            c20779b.mue = i;
            this.cache.put(C43103a.m76630ep(str, str2), c20779b);
            AppMethodBeat.m2505o(20665);
        }
    }

    /* renamed from: eq */
    public final synchronized C20779b mo68616eq(String str, String str2) {
        C20779b c20779b;
        AppMethodBeat.m2504i(20666);
        if (C34189m.isEmpty(str) || C34189m.isEmpty(str2)) {
            c20779b = null;
            AppMethodBeat.m2505o(20666);
        } else {
            c20779b = (C20779b) this.cache.get(C43103a.m76630ep(str, str2));
            AppMethodBeat.m2505o(20666);
        }
        return c20779b;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.m2504i(20667);
        size = this.cache.size();
        AppMethodBeat.m2505o(20667);
        return size;
    }
}
