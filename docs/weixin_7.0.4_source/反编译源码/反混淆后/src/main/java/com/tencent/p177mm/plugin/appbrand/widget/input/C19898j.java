package com.tencent.p177mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C11009af.C11010a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C27399b;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38600e.C19874a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j */
public final class C19898j {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$2 */
    public class C198952 implements C27399b {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ C19871c jeo;
        final /* synthetic */ String jep;

        public C198952(WeakReference weakReference, C19871c c19871c, String str) {
            this.hKr = weakReference;
            this.jeo = c19871c;
            this.jep = str;
        }

        /* renamed from: qy */
        public final boolean mo35115qy(int i) {
            AppMethodBeat.m2504i(123647);
            if (i == 67) {
                C44709u c44709u = (C44709u) this.hKr.get();
                if (c44709u != null) {
                    try {
                        int i2 = this.jeo.jdk;
                        new C33294a().mo61030b(c44709u.getRuntime().mo15032xT(), c44709u.hashCode()).mo61027AL(new JSONObject().put("value", this.jeo.aQl().getText().toString()).put("data", this.jep).put("cursor", 0).put("inputId", i2).put("keyCode", 8).toString()).aCj();
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", e);
                    }
                }
                AppMethodBeat.m2505o(123647);
                return true;
            }
            AppMethodBeat.m2505o(123647);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$3 */
    public class C198963 implements C11009af {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ int hKt;
        final /* synthetic */ C19871c jeo;
        final /* synthetic */ String jep;

        public C198963(WeakReference weakReference, C19871c c19871c, int i, String str) {
            this.hKr = weakReference;
            this.jeo = c19871c;
            this.hKt = i;
            this.jep = str;
        }

        /* renamed from: a */
        public final void mo22667a(String str, int i, C11010a c11010a) {
            AppMethodBeat.m2504i(123648);
            try {
                C44709u c44709u = (C44709u) this.hKr.get();
                if (c44709u == null) {
                    AppMethodBeat.m2505o(123648);
                    return;
                }
                JSONObject put = new JSONObject().put("value", str).put("keyCode", ((C38595ab) this.jeo.aQl()).getLastKeyPressed()).put("inputId", this.hKt).put("cursor", i);
                if (C11010a.CHANGED.equals(c11010a)) {
                    C33294a c33294a = new C33294a();
                    c33294a.mo61030b(c44709u.getRuntime().mo15032xT(), c44709u.hashCode()).aCj();
                    c33294a.mo61027AL(put.put("data", this.jep).toString());
                    c33294a.aCj();
                    AppMethodBeat.m2505o(123648);
                    return;
                }
                String str2;
                switch (C198995.jeq[c11010a.ordinal()]) {
                    case 1:
                        str2 = "onKeyboardComplete";
                        break;
                    case 2:
                        str2 = "onKeyboardConfirm";
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (C5046bo.isNullOrNil(str2)) {
                    AppMethodBeat.m2505o(123648);
                    return;
                }
                c44709u.mo51255h(str2, put.toString(), 0);
                AppMethodBeat.m2505o(123648);
            } catch (Exception e) {
                AppMethodBeat.m2505o(123648);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$4 */
    public class C198974 implements C27400ae {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ int hKt;

        public C198974(WeakReference weakReference, int i) {
            this.hKr = weakReference;
            this.hKt = i;
        }

        /* renamed from: qz */
        public final void mo35141qz(int i) {
            AppMethodBeat.m2504i(123649);
            try {
                C44709u c44709u = (C44709u) this.hKr.get();
                if (c44709u == null) {
                    AppMethodBeat.m2505o(123649);
                    return;
                }
                int pZ = C42668g.m75569pZ(i);
                c44709u.mo51255h("onKeyboardShow", C41725h.m73451QC().mo33333J("inputId", this.hKt).mo33333J("height", pZ).toString(), 0);
                new C45628v().mo73408a(pZ, c44709u.mo44926xT(), c44709u, Integer.valueOf(this.hKt));
                AppMethodBeat.m2505o(123649);
            } catch (Exception e) {
                AppMethodBeat.m2505o(123649);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$5 */
    static /* synthetic */ class C198995 {
        static final /* synthetic */ int[] jeq = new int[C11010a.values().length];

        static {
            AppMethodBeat.m2504i(123650);
            try {
                jeq[C11010a.COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jeq[C11010a.CONFIRM.ordinal()] = 2;
                AppMethodBeat.m2505o(123650);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.m2505o(123650);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$a */
    public static final class C19900a {
        private static final C19898j jer = new C19898j();

        static {
            AppMethodBeat.m2504i(123651);
            AppMethodBeat.m2505o(123651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$1 */
    public class C199011 implements C19874a {
        final /* synthetic */ int hKt;

        public C199011(int i) {
            this.hKt = i;
        }

        /* renamed from: a */
        public final boolean mo35111a(C45718aa c45718aa) {
            AppMethodBeat.m2504i(123646);
            if (c45718aa.aQo() == null || ((C38595ab) c45718aa.aQo()).getInputId() != this.hKt) {
                AppMethodBeat.m2505o(123646);
                return false;
            }
            AppMethodBeat.m2505o(123646);
            return true;
        }
    }

    /* synthetic */ C19898j(byte b) {
        this();
    }

    private C19898j() {
    }
}
