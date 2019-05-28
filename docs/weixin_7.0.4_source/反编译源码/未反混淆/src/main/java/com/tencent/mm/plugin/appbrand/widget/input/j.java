package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.widget.input.ab.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class j {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$2 */
    public class AnonymousClass2 implements b {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ c jeo;
        final /* synthetic */ String jep;

        public AnonymousClass2(WeakReference weakReference, c cVar, String str) {
            this.hKr = weakReference;
            this.jeo = cVar;
            this.jep = str;
        }

        public final boolean qy(int i) {
            AppMethodBeat.i(123647);
            if (i == 67) {
                u uVar = (u) this.hKr.get();
                if (uVar != null) {
                    try {
                        int i2 = this.jeo.jdk;
                        new com.tencent.mm.plugin.appbrand.jsapi.d.h.a().b(uVar.getRuntime().xT(), uVar.hashCode()).AL(new JSONObject().put("value", this.jeo.aQl().getText().toString()).put("data", this.jep).put("cursor", 0).put("inputId", i2).put("keyCode", 8).toString()).aCj();
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", e);
                    }
                }
                AppMethodBeat.o(123647);
                return true;
            }
            AppMethodBeat.o(123647);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$3 */
    public class AnonymousClass3 implements af {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ int hKt;
        final /* synthetic */ c jeo;
        final /* synthetic */ String jep;

        public AnonymousClass3(WeakReference weakReference, c cVar, int i, String str) {
            this.hKr = weakReference;
            this.jeo = cVar;
            this.hKt = i;
            this.jep = str;
        }

        public final void a(String str, int i, com.tencent.mm.plugin.appbrand.widget.input.af.a aVar) {
            AppMethodBeat.i(123648);
            try {
                u uVar = (u) this.hKr.get();
                if (uVar == null) {
                    AppMethodBeat.o(123648);
                    return;
                }
                JSONObject put = new JSONObject().put("value", str).put("keyCode", ((ab) this.jeo.aQl()).getLastKeyPressed()).put("inputId", this.hKt).put("cursor", i);
                if (com.tencent.mm.plugin.appbrand.widget.input.af.a.CHANGED.equals(aVar)) {
                    com.tencent.mm.plugin.appbrand.jsapi.d.h.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.d.h.a();
                    aVar2.b(uVar.getRuntime().xT(), uVar.hashCode()).aCj();
                    aVar2.AL(put.put("data", this.jep).toString());
                    aVar2.aCj();
                    AppMethodBeat.o(123648);
                    return;
                }
                String str2;
                switch (AnonymousClass5.jeq[aVar.ordinal()]) {
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
                if (bo.isNullOrNil(str2)) {
                    AppMethodBeat.o(123648);
                    return;
                }
                uVar.h(str2, put.toString(), 0);
                AppMethodBeat.o(123648);
            } catch (Exception e) {
                AppMethodBeat.o(123648);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$4 */
    public class AnonymousClass4 implements ae {
        final /* synthetic */ WeakReference hKr;
        final /* synthetic */ int hKt;

        public AnonymousClass4(WeakReference weakReference, int i) {
            this.hKr = weakReference;
            this.hKt = i;
        }

        public final void qz(int i) {
            AppMethodBeat.i(123649);
            try {
                u uVar = (u) this.hKr.get();
                if (uVar == null) {
                    AppMethodBeat.o(123649);
                    return;
                }
                int pZ = g.pZ(i);
                uVar.h("onKeyboardShow", h.QC().J("inputId", this.hKt).J("height", pZ).toString(), 0);
                new v().a(pZ, uVar.xT(), uVar, Integer.valueOf(this.hKt));
                AppMethodBeat.o(123649);
            } catch (Exception e) {
                AppMethodBeat.o(123649);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$5 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] jeq = new int[com.tencent.mm.plugin.appbrand.widget.input.af.a.values().length];

        static {
            AppMethodBeat.i(123650);
            try {
                jeq[com.tencent.mm.plugin.appbrand.widget.input.af.a.COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jeq[com.tencent.mm.plugin.appbrand.widget.input.af.a.CONFIRM.ordinal()] = 2;
                AppMethodBeat.o(123650);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(123650);
            }
        }
    }

    public static final class a {
        private static final j jer = new j();

        static {
            AppMethodBeat.i(123651);
            AppMethodBeat.o(123651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$1 */
    public class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.widget.input.e.a {
        final /* synthetic */ int hKt;

        public AnonymousClass1(int i) {
            this.hKt = i;
        }

        public final boolean a(aa aaVar) {
            AppMethodBeat.i(123646);
            if (aaVar.aQo() == null || ((ab) aaVar.aQo()).getInputId() != this.hKt) {
                AppMethodBeat.o(123646);
                return false;
            }
            AppMethodBeat.o(123646);
            return true;
        }
    }

    /* synthetic */ j(byte b) {
        this();
    }

    private j() {
    }
}
