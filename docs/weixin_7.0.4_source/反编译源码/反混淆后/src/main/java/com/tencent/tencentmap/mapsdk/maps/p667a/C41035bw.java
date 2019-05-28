package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bw */
public final class C41035bw {
    /* renamed from: a */
    public static String f16448a;
    /* renamed from: b */
    private static String f16449b = "AccessIpMgr";
    /* renamed from: c */
    private static Map<Integer, C36489a> f16450c = new ConcurrentHashMap();
    /* renamed from: d */
    private static Map<String, C36489a> f16451d = new ConcurrentHashMap();
    /* renamed from: e */
    private static C24362a f16452e = new C24362a();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bw$a */
    static class C36489a {
        /* renamed from: a */
        Integer f15270a;
        /* renamed from: b */
        String f15271b;
        /* renamed from: c */
        String f15272c;
        /* renamed from: d */
        String f15273d;
        /* renamed from: e */
        private String f15274e;
        /* renamed from: f */
        private List<C41034bu> f15275f;
        /* renamed from: g */
        private List<C41034bu> f15276g;
        /* renamed from: h */
        private List<C41034bu> f15277h;
        /* renamed from: i */
        private List<C41034bu> f15278i;

        public C36489a(String str) {
            this.f15274e = str;
        }

        /* renamed from: a */
        public final void mo57711a(C41034bu c41034bu) {
            AppMethodBeat.m2504i(98589);
            if (c41034bu == null) {
                AppMethodBeat.m2505o(98589);
            } else if (c41034bu.mo65120b() == (byte) 1) {
                if (this.f15275f == null) {
                    this.f15275f = new ArrayList();
                }
                this.f15275f.add(c41034bu);
                AppMethodBeat.m2505o(98589);
            } else if (c41034bu.mo65120b() == (byte) 2) {
                if (this.f15276g == null) {
                    this.f15276g = new ArrayList();
                }
                this.f15276g.add(c41034bu);
                AppMethodBeat.m2505o(98589);
            } else if (c41034bu.mo65120b() == (byte) 3) {
                if (this.f15277h == null) {
                    this.f15277h = new ArrayList();
                }
                this.f15277h.add(c41034bu);
                AppMethodBeat.m2505o(98589);
            } else if (c41034bu.mo65120b() == (byte) 4) {
                if (this.f15278i == null) {
                    this.f15278i = new ArrayList();
                }
                this.f15278i.add(c41034bu);
                AppMethodBeat.m2505o(98589);
            } else {
                if (this.f15275f == null) {
                    this.f15275f = new ArrayList();
                }
                this.f15275f.add(c41034bu);
                AppMethodBeat.m2505o(98589);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(98591);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Appid：" + this.f15270a + " domain：" + this.f15271b + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("apn：" + this.f15274e + " ckIP：" + this.f15272c + IOUtils.LINE_SEPARATOR_WINDOWS);
            for (C41034bu c41034bu : mo57710a()) {
                stringBuilder.append("accessIP：" + c41034bu.toString() + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(98591);
            return stringBuilder2;
        }

        /* renamed from: a */
        public final List<C41034bu> mo57710a() {
            AppMethodBeat.m2504i(98588);
            ArrayList arrayList = new ArrayList();
            List list = this.f15275f;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.f15276g;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.f15277h;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.f15278i;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            AppMethodBeat.m2505o(98588);
            return arrayList;
        }

        /* renamed from: b */
        public final synchronized void mo57712b(C41034bu c41034bu) {
            AppMethodBeat.m2504i(98590);
            if (c41034bu == null) {
                AppMethodBeat.m2505o(98590);
            } else {
                if (c41034bu.mo65120b() == (byte) 1) {
                    if (!(this.f15275f == null || this.f15275f.isEmpty() || !c41034bu.mo65118a((C41034bu) this.f15275f.get(0)))) {
                        this.f15275f.remove(0);
                        AppMethodBeat.m2505o(98590);
                    }
                } else if (c41034bu.mo65120b() == (byte) 2 && this.f15276g != null && !this.f15276g.isEmpty() && c41034bu.mo65118a((C41034bu) this.f15276g.get(0))) {
                    this.f15276g.remove(0);
                }
                AppMethodBeat.m2505o(98590);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(98598);
        AppMethodBeat.m2505o(98598);
    }

    /* renamed from: a */
    public static C24360cc m71358a(String str) {
        AppMethodBeat.m2504i(98595);
        C36489a c36489a = (C36489a) f16451d.get(str);
        if (c36489a != null) {
            C24360cc c24360cc = new C24360cc(c36489a.f15271b, c36489a.f15273d);
            c24360cc.f4655c = c36489a.mo57710a();
            AppMethodBeat.m2505o(98595);
            return c24360cc;
        }
        C41034bu c41034bu = new C41034bu(str, -1);
        c41034bu.mo65117a((byte) 3);
        C24360cc c24360cc2 = new C24360cc(str, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c41034bu);
        c24360cc2.f4655c = arrayList;
        AppMethodBeat.m2505o(98595);
        return c24360cc2;
    }

    /* renamed from: a */
    public static void m71359a() {
        AppMethodBeat.m2504i(98592);
        C46772bt.m88746j().post(new C44500ca());
        AppMethodBeat.m2505o(98592);
    }

    /* renamed from: a */
    public static void m71360a(String str, C41034bu c41034bu, int i) {
        AppMethodBeat.m2504i(98596);
        C36489a c36489a = (C36489a) f16451d.get(str);
        if (!(c36489a == null || i == 0)) {
            c36489a.mo57712b(c41034bu);
        }
        AppMethodBeat.m2505o(98596);
    }

    /* renamed from: b */
    public static void m71361b() {
        AppMethodBeat.m2504i(98593);
        C46780en.m88752d().mo75365f();
        AppMethodBeat.m2505o(98593);
    }

    /* renamed from: c */
    public static void m71362c() {
        AppMethodBeat.m2504i(98594);
        List<C24360cc> a = C46780en.m88752d().mo75365f().mo40548a();
        if (a != null) {
            f16451d.clear();
            for (C24360cc c24360cc : a) {
                C36489a c36489a = new C36489a(f16448a);
                c36489a.f15271b = c24360cc.f4653a;
                c36489a.f15273d = c24360cc.f4654b;
                for (C41034bu a2 : c24360cc.f4655c) {
                    c36489a.mo57711a(a2);
                }
                C41034bu a22 = new C41034bu(c24360cc.f4653a, -1);
                a22.mo65117a((byte) 3);
                c36489a.mo57711a(a22);
                f16451d.put(c24360cc.f4653a, c36489a);
            }
        }
        AppMethodBeat.m2505o(98594);
    }

    /* renamed from: d */
    static /* synthetic */ void m71363d() {
        AppMethodBeat.m2504i(98597);
        f16448a = C31029ce.m49847b();
        C46780en.m88752d().mo75365f();
        C41035bw.m71362c();
        AppMethodBeat.m2505o(98597);
    }
}
