package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bw {
    public static String a;
    private static String b = "AccessIpMgr";
    private static Map<Integer, a> c = new ConcurrentHashMap();
    private static Map<String, a> d = new ConcurrentHashMap();
    private static com.tencent.tencentmap.mapsdk.maps.a.ce.a e = new com.tencent.tencentmap.mapsdk.maps.a.ce.a();

    static class a {
        Integer a;
        String b;
        String c;
        String d;
        private String e;
        private List<bu> f;
        private List<bu> g;
        private List<bu> h;
        private List<bu> i;

        public a(String str) {
            this.e = str;
        }

        public final void a(bu buVar) {
            AppMethodBeat.i(98589);
            if (buVar == null) {
                AppMethodBeat.o(98589);
            } else if (buVar.b() == (byte) 1) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                this.f.add(buVar);
                AppMethodBeat.o(98589);
            } else if (buVar.b() == (byte) 2) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(buVar);
                AppMethodBeat.o(98589);
            } else if (buVar.b() == (byte) 3) {
                if (this.h == null) {
                    this.h = new ArrayList();
                }
                this.h.add(buVar);
                AppMethodBeat.o(98589);
            } else if (buVar.b() == (byte) 4) {
                if (this.i == null) {
                    this.i = new ArrayList();
                }
                this.i.add(buVar);
                AppMethodBeat.o(98589);
            } else {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                this.f.add(buVar);
                AppMethodBeat.o(98589);
            }
        }

        public final String toString() {
            AppMethodBeat.i(98591);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Appid：" + this.a + " domain：" + this.b + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("apn：" + this.e + " ckIP：" + this.c + IOUtils.LINE_SEPARATOR_WINDOWS);
            for (bu buVar : a()) {
                stringBuilder.append("accessIP：" + buVar.toString() + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(98591);
            return stringBuilder2;
        }

        public final List<bu> a() {
            AppMethodBeat.i(98588);
            ArrayList arrayList = new ArrayList();
            List list = this.f;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.g;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.h;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            list = this.i;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            AppMethodBeat.o(98588);
            return arrayList;
        }

        public final synchronized void b(bu buVar) {
            AppMethodBeat.i(98590);
            if (buVar == null) {
                AppMethodBeat.o(98590);
            } else {
                if (buVar.b() == (byte) 1) {
                    if (!(this.f == null || this.f.isEmpty() || !buVar.a((bu) this.f.get(0)))) {
                        this.f.remove(0);
                        AppMethodBeat.o(98590);
                    }
                } else if (buVar.b() == (byte) 2 && this.g != null && !this.g.isEmpty() && buVar.a((bu) this.g.get(0))) {
                    this.g.remove(0);
                }
                AppMethodBeat.o(98590);
            }
        }
    }

    static {
        AppMethodBeat.i(98598);
        AppMethodBeat.o(98598);
    }

    public static cc a(String str) {
        AppMethodBeat.i(98595);
        a aVar = (a) d.get(str);
        if (aVar != null) {
            cc ccVar = new cc(aVar.b, aVar.d);
            ccVar.c = aVar.a();
            AppMethodBeat.o(98595);
            return ccVar;
        }
        bu buVar = new bu(str, -1);
        buVar.a((byte) 3);
        cc ccVar2 = new cc(str, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(buVar);
        ccVar2.c = arrayList;
        AppMethodBeat.o(98595);
        return ccVar2;
    }

    public static void a() {
        AppMethodBeat.i(98592);
        bt.j().post(new ca());
        AppMethodBeat.o(98592);
    }

    public static void a(String str, bu buVar, int i) {
        AppMethodBeat.i(98596);
        a aVar = (a) d.get(str);
        if (!(aVar == null || i == 0)) {
            aVar.b(buVar);
        }
        AppMethodBeat.o(98596);
    }

    public static void b() {
        AppMethodBeat.i(98593);
        en.d().f();
        AppMethodBeat.o(98593);
    }

    public static void c() {
        AppMethodBeat.i(98594);
        List<cc> a = en.d().f().a();
        if (a != null) {
            d.clear();
            for (cc ccVar : a) {
                a aVar = new a(a);
                aVar.b = ccVar.a;
                aVar.d = ccVar.b;
                for (bu a2 : ccVar.c) {
                    aVar.a(a2);
                }
                bu a22 = new bu(ccVar.a, -1);
                a22.a((byte) 3);
                aVar.a(a22);
                d.put(ccVar.a, aVar);
            }
        }
        AppMethodBeat.o(98594);
    }

    static /* synthetic */ void d() {
        AppMethodBeat.i(98597);
        a = ce.b();
        en.d().f();
        c();
        AppMethodBeat.o(98597);
    }
}
