package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.bridge.p814a.C8852a;
import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p1170a.C45116d;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1698d;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C24685g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c.C2242a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c.C2243b;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d */
public abstract class C33295d implements C2241c {
    private Handler bOB;
    private final AtomicInteger bOM = new AtomicInteger(0);
    private C19092p gNH = new C24685g();
    private final LinkedHashSet<C10442k> gNJ;
    final C1698d gNK;
    protected boolean gNV;
    private final LinkedHashSet<C10441j> htl;
    private C6747i hvJ;
    private final C10448l hvK;
    private final Map<String, C45608m> hvL = new HashMap();
    protected C2243b hvM;
    private final SparseArray<C33296a> hvN = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d$1 */
    class C166621 implements C8851a {
        C166621() {
        }

        /* renamed from: a */
        public final <T extends C25681b> void mo20023a(Class<T> cls, T t) {
            AppMethodBeat.m2504i(91010);
            if (t == null) {
                C45124d.m82934w("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", cls, t);
                AppMethodBeat.m2505o(91010);
                return;
            }
            C33295d.this.gNK.mo5210a(cls, t);
            AppMethodBeat.m2505o(91010);
        }

        /* renamed from: a */
        public final <T extends C45116d> void mo20024a(Class<T> cls, T t) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d$a */
    static class C33296a {
        C6747i hvT;
        /* renamed from: id */
        int f15033id;

        C33296a(C6747i c6747i, int i) {
            this.hvT = c6747i;
            this.f15033id = i;
        }
    }

    /* Access modifiers changed, original: protected */
    public String auc() {
        return "";
    }

    public C33295d() {
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        this.htl = new LinkedHashSet();
        this.gNJ = new LinkedHashSet();
        this.hvK = aCc();
        this.gNK = new C1698d();
        C8851a c166621 = new C166621();
        if (C8852a.bOP != null) {
            C8852a.bOP.mo20025a(c166621);
        }
        this.gNV = false;
    }

    /* Access modifiers changed, original: protected */
    public C10448l aCc() {
        return new C10448l(this);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aCd() {
        synchronized (this.hvK) {
            if (this.hvJ == null) {
                this.hvJ = aua();
                this.hvJ.addJavascriptInterface(this.hvK, "WeixinJSCore");
            }
        }
    }

    public void init() {
        aCd();
        this.hvL.putAll(aub());
        for (C45608m g : this.hvL.values()) {
            g.mo31168g(this);
        }
    }

    /* renamed from: bX */
    public final void mo6116bX(String str, String str2) {
        mo51255h(str, str2, 0);
    }

    /* renamed from: h */
    public void mo51255h(String str, String str2, int i) {
        if (isRunning()) {
            C19346bo.m30025a(aBx(), str, str2, i);
        }
    }

    /* renamed from: a */
    public void mo6108a(final C42467ah c42467ah) {
        if (this.hvM == null) {
            mo51255h(c42467ah.getName(), c42467ah.getData(), c42467ah.hwN);
        } else {
            this.hvM.mo6121a(c42467ah, new C42595x() {
                public final void proceed() {
                    AppMethodBeat.m2504i(91011);
                    C33295d.this.mo51255h(c42467ah.getName(), c42467ah.getData(), c42467ah.hwN);
                    AppMethodBeat.m2505o(91011);
                }
            });
        }
    }

    /* renamed from: b */
    public final void mo6115b(C42467ah c42467ah) {
        mo6109a(c42467ah.getName(), c42467ah.getData(), null);
    }

    /* renamed from: n */
    public final String mo53814n(String str, final String str2, int i) {
        String str3 = "";
        final int a = mo51254a(this.hvJ, i);
        final C45608m c45608m = (C45608m) this.hvL.get(str);
        if (c45608m == null) {
            mo6107M(a, C33295d.m54458Q(str, "fail:not supported"));
            return "fail:not supported";
        }
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        if (c45608m instanceof C10296a) {
            this.bOB.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(91012);
                    C33295d.this.m54460a(c45608m, str2, a);
                    AppMethodBeat.m2505o(91012);
                }
            });
            str4 = str3;
        } else {
            str4 = m54460a(c45608m, str2, a);
        }
        if (!mo53815xX()) {
            return str4;
        }
        int i2;
        String str5 = "MicroMsg.AppBrandComponentImpl";
        String str6 = "invokeHandler, api: %s, data size: %d, time: %d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.length();
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        C45124d.m82930i(str5, str6, objArr);
        return str4;
    }

    /* renamed from: a */
    private String m54460a(final C45608m c45608m, final String str, final int i) {
        int i2 = 0;
        if (isRunning()) {
            C2242a c103724 = new C42596y() {
                private String aCe() {
                    AppMethodBeat.m2504i(91013);
                    try {
                        String j;
                        JSONObject AI = C33295d.m54457AI(str);
                        if (AI == null) {
                            j = c45608m.mo73394j("fail:invalid data", null);
                        } else {
                            j = C33295d.this.mo53809a(c45608m, AI, i);
                        }
                        C33295d c33295d = C33295d.this;
                        C45608m c45608m = c45608m;
                        String str = str;
                        int i = i;
                        if (c33295d.hvM != null) {
                            c33295d.hvM.mo6122a(c45608m, str, i, j);
                        }
                        AppMethodBeat.m2505o(91013);
                        return j;
                    } catch (OutOfMemoryError e) {
                        C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", c45608m.getName(), Integer.valueOf(C5046bo.nullAsNil(str).length()));
                        AppMethodBeat.m2505o(91013);
                        throw e;
                    }
                }

                /* renamed from: AJ */
                private void m18077AJ(String str) {
                    AppMethodBeat.m2504i(91014);
                    this.hwo = str;
                    C33295d.this.mo6107M(i, str);
                    AppMethodBeat.m2505o(91014);
                }

                public final void proceed() {
                    AppMethodBeat.m2504i(91015);
                    if (TextUtils.isEmpty(this.hwo)) {
                        CharSequence aCe;
                        boolean isRunning = C33295d.this.isRunning();
                        if (!isRunning) {
                            C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", C33295d.this.auc(), c45608m, Integer.valueOf(i));
                        }
                        if (isRunning) {
                            aCe = aCe();
                        } else {
                            aCe = c45608m.mo73394j("fail:interrupted", null);
                        }
                        if (!TextUtils.isEmpty(aCe)) {
                            m18077AJ(aCe);
                        }
                        AppMethodBeat.m2505o(91015);
                        return;
                    }
                    AppMethodBeat.m2505o(91015);
                }

                /* renamed from: AH */
                public final void mo6118AH(String str) {
                    AppMethodBeat.m2504i(91016);
                    if (TextUtils.isEmpty(this.hwo)) {
                        if (!TextUtils.isEmpty(str)) {
                            m18077AJ(str);
                        }
                        AppMethodBeat.m2505o(91016);
                        return;
                    }
                    AppMethodBeat.m2505o(91016);
                }
            };
            if (this.hvM != null) {
                i2 = this.hvM.mo6123a(c45608m, str, i, c103724);
            }
            if (i2 == 0) {
                c103724.proceed();
            }
            if (TextUtils.isEmpty(c103724.hwo)) {
                return "";
            }
            return c103724.hwo;
        }
        C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "invoke log[%s] api[%s], callbackId[%d], component not running", auc(), c45608m.getName(), Integer.valueOf(i));
        return C33295d.m54458Q(c45608m.getName(), "fail:interrupted");
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final String mo53809a(C45608m c45608m, JSONObject jSONObject, int i) {
        String str = "";
        try {
            if (c45608m instanceof C19497u) {
                return ((C19497u) c45608m).mo6145b(this, jSONObject);
            }
            if (!(c45608m instanceof C10296a)) {
                return str;
            }
            String j;
            if (C27295q.m43334a(aBx(), jSONObject, (C27296a) mo5937aa(C27296a.class)) == C10730b.FAIL_SIZE_EXCEED_LIMIT) {
                j = c45608m.mo73394j("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
            } else {
                j = null;
            }
            if (j == null) {
                ((C10296a) c45608m).mo5994a(this, jSONObject, i);
            }
            return j;
        } catch (ClassCastException e) {
            C45124d.printErrStackTrace("MicroMsg.AppBrandComponentImpl", e, e.getMessage(), new Object[0]);
            return c45608m.mo73394j("fail:internal error invalid js component", null);
        }
    }

    /* renamed from: AI */
    static JSONObject m54457AI(String str) {
        try {
            if (C5046bo.isNullOrNil(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            C45124d.m82927e("MicroMsg.AppBrandComponentImpl", e.getMessage());
            return null;
        }
    }

    /* renamed from: M */
    public void mo6107M(int i, String str) {
        if (isRunning()) {
            if (C5046bo.isNullOrNil(str)) {
                str = "{}";
            }
            C45124d.m82926d("MicroMsg.AppBrandComponentImpl", "callbackId: %d, data size: %d", Integer.valueOf(i), Integer.valueOf(str.length()));
            C33296a nY = m54461nY(i);
            if (nY == null) {
                C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "callbackId = [%d] This is a Sync Api, or already called back, No callback runtime stored.", Integer.valueOf(i));
                return;
            }
            nY.hvT.evaluateJavascript(String.format(Locale.US, "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(nY.f15033id), str}), null);
            if (this.hvM != null) {
                this.hvM.mo6120D(i, str);
                return;
            }
            return;
        }
        C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "callback but destroyed, callbackId %d", Integer.valueOf(i));
    }

    public final int aBw() {
        return hashCode();
    }

    public final C6747i aBx() {
        C6747i c6747i;
        synchronized (this.hvK) {
            c6747i = this.hvJ;
        }
        return c6747i;
    }

    public final Handler aBy() {
        return this.bOB;
    }

    public C19092p asE() {
        C45124d.m82927e("MicroMsg.AppBrandComponentImpl", "getFileSystem return dummy impl");
        return this.gNH;
    }

    public void cleanup() {
        C6747i c6747i;
        synchronized (this.hvN) {
            this.hvN.clear();
        }
        this.bOB.removeCallbacksAndMessages(null);
        this.bOB.getLooper().quit();
        this.hvK.hwc.clear();
        this.hvM = null;
        synchronized (this.hvK) {
            c6747i = this.hvJ;
        }
        if (c6747i != null) {
            c6747i.destroy();
        }
        for (C45608m h : this.hvL.values()) {
            h.mo31169h(this);
        }
        this.hvL.clear();
        this.hvM = null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xX */
    public boolean mo53815xX() {
        return false;
    }

    /* renamed from: Q */
    private static String m54458Q(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
        return new JSONObject(hashMap).toString();
    }

    /* renamed from: e */
    public final void mo53812e(Collection<C10441j> collection) {
        this.htl.addAll(collection);
    }

    /* renamed from: aa */
    public <T extends C10441j> T mo5937aa(Class<T> cls) {
        C10441j c10441j;
        Object obj;
        C10441j c10441j2 = null;
        Iterator it = this.htl.iterator();
        while (it.hasNext()) {
            c10441j = (C10441j) it.next();
            if (cls.isInstance(c10441j)) {
                c10441j2 = c10441j;
                break;
            }
        }
        if (c10441j2 == null) {
            try {
                obj = (C10441j) cls.newInstance();
            } catch (Exception e) {
                C45124d.m82928e("MicroMsg.AppBrandComponentImpl", "Make sure %s has default constructor", cls.getName());
            }
            Assert.assertNotNull(obj);
            this.htl.add(obj);
            return obj;
        }
        c10441j = c10441j2;
        Assert.assertNotNull(obj);
        this.htl.add(obj);
        return obj;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo51254a(C6747i c6747i, int i) {
        if (i == 0) {
            return 0;
        }
        int incrementAndGet = this.bOM.incrementAndGet();
        synchronized (this.hvN) {
            this.hvN.put(incrementAndGet, new C33296a(c6747i, i));
        }
        return incrementAndGet;
    }

    /* renamed from: nY */
    private C33296a m54461nY(int i) {
        C33296a c33296a;
        synchronized (this.hvN) {
            c33296a = (C33296a) this.hvN.get(i);
            this.hvN.remove(i);
        }
        return c33296a;
    }

    public C33589k asF() {
        C45124d.m82927e("MicroMsg.AppBrandComponentImpl", "getDialogContainer return dummy impl");
        return C33589k.jdi;
    }

    /* renamed from: B */
    public <T extends C25681b> T mo5936B(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = (C25681b) this.gNK.mo5209U(cls);
        if (t == null) {
            t = C37384e.m62985B(cls);
            if (!(t == null || cls.isAssignableFrom(t.getClass()))) {
                t = null;
            }
        }
        return t;
    }

    /* renamed from: B */
    public void mo6106B(Runnable runnable) {
        C5004al.m7441d(runnable);
    }

    /* renamed from: a */
    public void mo6109a(String str, String str2, int[] iArr) {
        mo51255h(str, str2, 0);
    }
}
