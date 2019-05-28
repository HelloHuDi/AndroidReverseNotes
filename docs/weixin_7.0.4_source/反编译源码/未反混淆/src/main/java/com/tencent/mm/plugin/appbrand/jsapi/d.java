package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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

public abstract class d implements c {
    private Handler bOB;
    private final AtomicInteger bOM = new AtomicInteger(0);
    private p gNH = new g();
    private final LinkedHashSet<k> gNJ;
    final com.tencent.mm.kernel.c.d gNK;
    protected boolean gNV;
    private final LinkedHashSet<j> htl;
    private i hvJ;
    private final l hvK;
    private final Map<String, m> hvL = new HashMap();
    protected b hvM;
    private final SparseArray<a> hvN = new SparseArray();

    static class a {
        i hvT;
        int id;

        a(i iVar, int i) {
            this.hvT = iVar;
            this.id = i;
        }
    }

    /* Access modifiers changed, original: protected */
    public String auc() {
        return "";
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        this.htl = new LinkedHashSet();
        this.gNJ = new LinkedHashSet();
        this.hvK = aCc();
        this.gNK = new com.tencent.mm.kernel.c.d();
        com.tencent.luggage.bridge.a.a.a anonymousClass1 = new com.tencent.luggage.bridge.a.a.a() {
            public final <T extends com.tencent.luggage.a.b> void a(Class<T> cls, T t) {
                AppMethodBeat.i(91010);
                if (t == null) {
                    com.tencent.luggage.g.d.w("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", cls, t);
                    AppMethodBeat.o(91010);
                    return;
                }
                d.this.gNK.a(cls, t);
                AppMethodBeat.o(91010);
            }

            public final <T extends com.tencent.luggage.a.d> void a(Class<T> cls, T t) {
            }
        };
        if (com.tencent.luggage.bridge.a.a.bOP != null) {
            com.tencent.luggage.bridge.a.a.bOP.a(anonymousClass1);
        }
        this.gNV = false;
    }

    /* Access modifiers changed, original: protected */
    public l aCc() {
        return new l(this);
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
        for (m g : this.hvL.values()) {
            g.g(this);
        }
    }

    public final void bX(String str, String str2) {
        h(str, str2, 0);
    }

    public void h(String str, String str2, int i) {
        if (isRunning()) {
            bo.a(aBx(), str, str2, i);
        }
    }

    public void a(final ah ahVar) {
        if (this.hvM == null) {
            h(ahVar.getName(), ahVar.getData(), ahVar.hwN);
        } else {
            this.hvM.a(ahVar, new x() {
                public final void proceed() {
                    AppMethodBeat.i(91011);
                    d.this.h(ahVar.getName(), ahVar.getData(), ahVar.hwN);
                    AppMethodBeat.o(91011);
                }
            });
        }
    }

    public final void b(ah ahVar) {
        a(ahVar.getName(), ahVar.getData(), null);
    }

    public final String n(String str, final String str2, int i) {
        String str3 = "";
        final int a = a(this.hvJ, i);
        final m mVar = (m) this.hvL.get(str);
        if (mVar == null) {
            M(a, Q(str, "fail:not supported"));
            return "fail:not supported";
        }
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        if (mVar instanceof a) {
            this.bOB.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91012);
                    d.this.a(mVar, str2, a);
                    AppMethodBeat.o(91012);
                }
            });
            str4 = str3;
        } else {
            str4 = a(mVar, str2, a);
        }
        if (!xX()) {
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
        com.tencent.luggage.g.d.i(str5, str6, objArr);
        return str4;
    }

    private String a(final m mVar, final String str, final int i) {
        int i2 = 0;
        if (isRunning()) {
            com.tencent.mm.plugin.appbrand.jsapi.c.a anonymousClass4 = new y() {
                private String aCe() {
                    AppMethodBeat.i(91013);
                    try {
                        String j;
                        JSONObject AI = d.AI(str);
                        if (AI == null) {
                            j = mVar.j("fail:invalid data", null);
                        } else {
                            j = d.this.a(mVar, AI, i);
                        }
                        d dVar = d.this;
                        m mVar = mVar;
                        String str = str;
                        int i = i;
                        if (dVar.hvM != null) {
                            dVar.hvM.a(mVar, str, i, j);
                        }
                        AppMethodBeat.o(91013);
                        return j;
                    } catch (OutOfMemoryError e) {
                        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", mVar.getName(), Integer.valueOf(bo.nullAsNil(str).length()));
                        AppMethodBeat.o(91013);
                        throw e;
                    }
                }

                private void AJ(String str) {
                    AppMethodBeat.i(91014);
                    this.hwo = str;
                    d.this.M(i, str);
                    AppMethodBeat.o(91014);
                }

                public final void proceed() {
                    AppMethodBeat.i(91015);
                    if (TextUtils.isEmpty(this.hwo)) {
                        CharSequence aCe;
                        boolean isRunning = d.this.isRunning();
                        if (!isRunning) {
                            com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", d.this.auc(), mVar, Integer.valueOf(i));
                        }
                        if (isRunning) {
                            aCe = aCe();
                        } else {
                            aCe = mVar.j("fail:interrupted", null);
                        }
                        if (!TextUtils.isEmpty(aCe)) {
                            AJ(aCe);
                        }
                        AppMethodBeat.o(91015);
                        return;
                    }
                    AppMethodBeat.o(91015);
                }

                public final void AH(String str) {
                    AppMethodBeat.i(91016);
                    if (TextUtils.isEmpty(this.hwo)) {
                        if (!TextUtils.isEmpty(str)) {
                            AJ(str);
                        }
                        AppMethodBeat.o(91016);
                        return;
                    }
                    AppMethodBeat.o(91016);
                }
            };
            if (this.hvM != null) {
                i2 = this.hvM.a(mVar, str, i, anonymousClass4);
            }
            if (i2 == 0) {
                anonymousClass4.proceed();
            }
            if (TextUtils.isEmpty(anonymousClass4.hwo)) {
                return "";
            }
            return anonymousClass4.hwo;
        }
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "invoke log[%s] api[%s], callbackId[%d], component not running", auc(), mVar.getName(), Integer.valueOf(i));
        return Q(mVar.getName(), "fail:interrupted");
    }

    /* Access modifiers changed, original: final */
    public final String a(m mVar, JSONObject jSONObject, int i) {
        String str = "";
        try {
            if (mVar instanceof u) {
                return ((u) mVar).b(this, jSONObject);
            }
            if (!(mVar instanceof a)) {
                return str;
            }
            String j;
            if (q.a(aBx(), jSONObject, (com.tencent.mm.plugin.appbrand.s.q.a) aa(com.tencent.mm.plugin.appbrand.s.q.a.class)) == q.b.FAIL_SIZE_EXCEED_LIMIT) {
                j = mVar.j("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
            } else {
                j = null;
            }
            if (j == null) {
                ((a) mVar).a(this, jSONObject, i);
            }
            return j;
        } catch (ClassCastException e) {
            com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.AppBrandComponentImpl", e, e.getMessage(), new Object[0]);
            return mVar.j("fail:internal error invalid js component", null);
        }
    }

    static JSONObject AI(String str) {
        try {
            if (bo.isNullOrNil(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", e.getMessage());
            return null;
        }
    }

    public void M(int i, String str) {
        if (isRunning()) {
            if (bo.isNullOrNil(str)) {
                str = "{}";
            }
            com.tencent.luggage.g.d.d("MicroMsg.AppBrandComponentImpl", "callbackId: %d, data size: %d", Integer.valueOf(i), Integer.valueOf(str.length()));
            a nY = nY(i);
            if (nY == null) {
                com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "callbackId = [%d] This is a Sync Api, or already called back, No callback runtime stored.", Integer.valueOf(i));
                return;
            }
            nY.hvT.evaluateJavascript(String.format(Locale.US, "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(nY.id), str}), null);
            if (this.hvM != null) {
                this.hvM.D(i, str);
                return;
            }
            return;
        }
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "callback but destroyed, callbackId %d", Integer.valueOf(i));
    }

    public final int aBw() {
        return hashCode();
    }

    public final i aBx() {
        i iVar;
        synchronized (this.hvK) {
            iVar = this.hvJ;
        }
        return iVar;
    }

    public final Handler aBy() {
        return this.bOB;
    }

    public p asE() {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "getFileSystem return dummy impl");
        return this.gNH;
    }

    public void cleanup() {
        i iVar;
        synchronized (this.hvN) {
            this.hvN.clear();
        }
        this.bOB.removeCallbacksAndMessages(null);
        this.bOB.getLooper().quit();
        this.hvK.hwc.clear();
        this.hvM = null;
        synchronized (this.hvK) {
            iVar = this.hvJ;
        }
        if (iVar != null) {
            iVar.destroy();
        }
        for (m h : this.hvL.values()) {
            h.h(this);
        }
        this.hvL.clear();
        this.hvM = null;
    }

    /* Access modifiers changed, original: protected */
    public boolean xX() {
        return false;
    }

    private static String Q(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2);
        return new JSONObject(hashMap).toString();
    }

    public final void e(Collection<j> collection) {
        this.htl.addAll(collection);
    }

    public <T extends j> T aa(Class<T> cls) {
        j jVar;
        Object obj;
        j jVar2 = null;
        Iterator it = this.htl.iterator();
        while (it.hasNext()) {
            jVar = (j) it.next();
            if (cls.isInstance(jVar)) {
                jVar2 = jVar;
                break;
            }
        }
        if (jVar2 == null) {
            try {
                obj = (j) cls.newInstance();
            } catch (Exception e) {
                com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "Make sure %s has default constructor", cls.getName());
            }
            Assert.assertNotNull(obj);
            this.htl.add(obj);
            return obj;
        }
        jVar = jVar2;
        Assert.assertNotNull(obj);
        this.htl.add(obj);
        return obj;
    }

    /* Access modifiers changed, original: protected */
    public int a(i iVar, int i) {
        if (i == 0) {
            return 0;
        }
        int incrementAndGet = this.bOM.incrementAndGet();
        synchronized (this.hvN) {
            this.hvN.put(incrementAndGet, new a(iVar, i));
        }
        return incrementAndGet;
    }

    private a nY(int i) {
        a aVar;
        synchronized (this.hvN) {
            aVar = (a) this.hvN.get(i);
            this.hvN.remove(i);
        }
        return aVar;
    }

    public k asF() {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandComponentImpl", "getDialogContainer return dummy impl");
        return k.jdi;
    }

    public <T extends com.tencent.luggage.a.b> T B(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = (com.tencent.luggage.a.b) this.gNK.U(cls);
        if (t == null) {
            t = e.B(cls);
            if (!(t == null || cls.isAssignableFrom(t.getClass()))) {
                t = null;
            }
        }
        return t;
    }

    public void B(Runnable runnable) {
        al.d(runnable);
    }

    public void a(String str, String str2, int[] iArr) {
        h(str, str2, 0);
    }
}
