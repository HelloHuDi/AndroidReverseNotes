package com.tencent.p177mm.memory.p259a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.memory.p259a.p260a.C1803b;
import com.tencent.p177mm.memory.p259a.p260a.C6662a;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1792a;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1799d;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.memory.a.b */
public final class C26399b<V> extends C7483a<String, V, V, C6662a> {
    private static ConcurrentHashMap<Class<?>, C26398a> fdX = new ConcurrentHashMap();
    String fdV;
    C1177f<String, Object> fdW;
    private C1175b<String, C6662a> fdY;
    private C1176c<String, C6662a> fdZ;

    /* renamed from: com.tencent.mm.memory.a.b$a */
    public interface C26398a<T> {
        /* renamed from: aU */
        int mo37425aU(T t);
    }

    /* renamed from: com.tencent.mm.memory.a.b$1 */
    static class C264001 implements C26398a<Bitmap> {
        C264001() {
        }

        /* renamed from: aU */
        public final /* synthetic */ int mo37425aU(Object obj) {
            AppMethodBeat.m2504i(115418);
            Bitmap bitmap = (Bitmap) obj;
            int byteCount;
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.m2505o(115418);
                return 0;
            } else if (C1443d.m3067fP(19)) {
                byteCount = bitmap.getByteCount();
                AppMethodBeat.m2505o(115418);
                return byteCount;
            } else {
                byteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.m2505o(115418);
                return byteCount;
            }
        }
    }

    /* renamed from: com.tencent.mm.memory.a.b$2 */
    static class C264012 implements C26398a<WeakReference<Bitmap>> {
        C264012() {
        }

        /* renamed from: aU */
        public final /* synthetic */ int mo37425aU(Object obj) {
            AppMethodBeat.m2504i(115419);
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference == null) {
                AppMethodBeat.m2505o(115419);
                return 0;
            }
            Bitmap bitmap = (Bitmap) weakReference.get();
            int byteCount;
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.m2505o(115419);
                return 0;
            } else if (C1443d.m3067fP(19)) {
                byteCount = bitmap.getByteCount();
                AppMethodBeat.m2505o(115419);
                return byteCount;
            } else {
                byteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.m2505o(115419);
                return byteCount;
            }
        }
    }

    /* renamed from: com.tencent.mm.memory.a.b$3 */
    class C264023 implements C1175b<String, V> {
        C264023() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(115420);
            String str = (String) obj;
            if (obj2 == null || obj3 == null || obj2 != obj3) {
                if (C1792a.feq) {
                    C4990ab.m7419v("MicroMsg.BitmapResource", "BitmapResource MMLRUMap remove %s value newValue %s %s maxSize %s getfromKey %s stack [%s]", str, obj2, obj3, Integer.valueOf(C26399b.this.maxSize), C26399b.this.feD.get(str), C5046bo.dpG().toString());
                }
                if (!(C26399b.this.feF == null || obj2 == null || obj3 != null)) {
                    C4990ab.m7416i("MicroMsg.BitmapResource", "let me see see");
                    C26399b.this.feF.mo4401c(str, obj2, obj3);
                }
                if (C26399b.this.feE != null) {
                    C26399b.this.feE.mo5361s(C26399b.this.fdV, str);
                }
            }
            AppMethodBeat.m2505o(115420);
        }
    }

    /* renamed from: com.tencent.mm.memory.a.b$5 */
    class C264035 implements C1176c<String, C6662a> {
        C264035() {
        }

        /* renamed from: l */
        public final /* bridge */ /* synthetic */ int mo4402l(Object obj, Object obj2) {
            C6662a c6662a = (C6662a) obj2;
            if (c6662a != null) {
                return c6662a.fee;
            }
            return SQLiteGlobal.journalSizeLimit;
        }
    }

    /* renamed from: com.tencent.mm.memory.a.b$4 */
    class C264044 implements C1175b<String, C6662a> {
        C264044() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(115421);
            String str = (String) obj;
            C6662a c6662a = (C6662a) obj2;
            C6662a c6662a2 = (C6662a) obj3;
            String str2;
            String str3;
            Object[] objArr;
            if (c6662a != null && c6662a2 != null && c6662a.equals(c6662a2)) {
                if (C1792a.feq) {
                    str2 = "MicroMsg.BitmapResource";
                    str3 = "Proxy remove1 %s oldValue %s newValue %s size %s stack [%s]";
                    objArr = new Object[5];
                    objArr[0] = str;
                    objArr[1] = c6662a == null ? " is null " : c6662a.toString();
                    objArr[2] = c6662a2 == null ? " is null " : c6662a2.toString();
                    objArr[3] = Integer.valueOf(C26399b.this.feE.size());
                    objArr[4] = C5046bo.dpG().toString();
                    C4990ab.m7419v(str2, str3, objArr);
                }
                AppMethodBeat.m2505o(115421);
            } else if (c6662a2 == null || c6662a == null || !c6662a2.key.equals(c6662a.key)) {
                if (C1792a.feq) {
                    str2 = "MicroMsg.BitmapResource";
                    str3 = "Proxy remove3 %s oldValue %s newValue %s size %s stack [%s]";
                    objArr = new Object[5];
                    objArr[0] = str;
                    objArr[1] = c6662a == null ? " is null " : c6662a.toString();
                    objArr[2] = c6662a2 == null ? " is null " : c6662a2.toString();
                    objArr[3] = Integer.valueOf(C26399b.this.feE.size());
                    objArr[4] = C5046bo.dpG().toString();
                    C4990ab.m7419v(str2, str3, objArr);
                }
                C26399b.this.feD.remove(c6662a.key);
                AppMethodBeat.m2505o(115421);
            } else {
                if (C1792a.feq) {
                    str2 = "MicroMsg.BitmapResource";
                    str3 = "Proxy remove2 %s oldValue %s newValue %s size %s stack [%s]";
                    objArr = new Object[5];
                    objArr[0] = str;
                    objArr[1] = c6662a == null ? " is null " : c6662a.toString();
                    objArr[2] = c6662a2 == null ? " is null " : c6662a2.toString();
                    objArr[3] = Integer.valueOf(C26399b.this.feE.size());
                    objArr[4] = C5046bo.dpG().toString();
                    C4990ab.m7419v(str2, str3, objArr);
                }
                AppMethodBeat.m2505o(115421);
            }
        }
    }

    /* renamed from: aX */
    public final /* bridge */ /* synthetic */ Object mo14877aX(Object obj) {
        return obj;
    }

    /* renamed from: ai */
    public final /* synthetic */ Object mo4404ai(Object obj) {
        Object obj2;
        AppMethodBeat.m2504i(115435);
        String str = (String) obj;
        Object ai = this.feD.mo4404ai(str);
        if (ai != null || this.fdW == null) {
            obj2 = ai;
        } else {
            obj2 = this.fdW.get(str);
        }
        C6662a c6662a = null;
        if (this.feE != null) {
            c6662a = (C6662a) this.feE.mo5365u(this.fdV, str);
        }
        if (C1792a.feq) {
            C4990ab.m7419v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, obj2, c6662a, C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(115435);
        return obj2;
    }

    /* renamed from: k */
    public final /* synthetic */ void mo4412k(Object obj, Object obj2) {
        AppMethodBeat.m2504i(115439);
        String str = (String) obj;
        if (!m42019aW(obj2) || this.fdW == null) {
            super.mo4412k(str, obj2);
            AppMethodBeat.m2505o(115439);
            return;
        }
        this.fdW.put(str, obj2);
        AppMethodBeat.m2505o(115439);
    }

    /* renamed from: o */
    public final /* synthetic */ Object mo14879o(Object obj, Object obj2) {
        AppMethodBeat.m2504i(115440);
        C6662a c6662a = new C6662a((String) obj, this.fdV, obj2, m42018aU(obj2), this.fdY, this.fdZ);
        AppMethodBeat.m2505o(115440);
        return c6662a;
    }

    static {
        AppMethodBeat.m2504i(115442);
        C26399b.m42017a(Bitmap.class, new C264001());
        C26399b.m42017a(WeakReference.class, new C264012());
        AppMethodBeat.m2505o(115442);
    }

    /* renamed from: a */
    public static void m42017a(Class<?> cls, C26398a c26398a) {
        AppMethodBeat.m2504i(115422);
        fdX.put(cls, c26398a);
        AppMethodBeat.m2505o(115422);
    }

    public C26399b(int i, Class<?> cls) {
        this(i, null, cls);
        AppMethodBeat.m2504i(115423);
        m42015W(cls);
        AppMethodBeat.m2505o(115423);
    }

    public C26399b(int i, C1175b<String, V> c1175b, Class<?> cls) {
        this(i, c1175b, C1792a.m3685Xw(), cls);
        AppMethodBeat.m2504i(115424);
        m42015W(cls);
        AppMethodBeat.m2505o(115424);
    }

    private C26399b(int i, C1175b<String, V> c1175b, C1792a c1792a, Class<?> cls) {
        super(i, c1175b, c1792a);
        AppMethodBeat.m2504i(115425);
        this.fdV = "";
        this.fdW = null;
        this.fdY = new C264044();
        this.fdZ = new C264035();
        m42015W(cls);
        AppMethodBeat.m2505o(115425);
    }

    /* renamed from: W */
    private void m42015W(Class<?> cls) {
        AppMethodBeat.m2504i(115426);
        this.fdV = cls.getSimpleName();
        this.fdW = C1803b.m3708d(this.fey);
        AppMethodBeat.m2505o(115426);
    }

    public final void init() {
        AppMethodBeat.m2504i(115427);
        super.init();
        AppMethodBeat.m2505o(115427);
    }

    /* renamed from: aU */
    private int m42018aU(V v) {
        int aU;
        AppMethodBeat.m2504i(115428);
        if (v != null) {
            C26398a c26398a = (C26398a) fdX.get(v.getClass());
            if (c26398a != null) {
                aU = c26398a.mo37425aU(v);
                AppMethodBeat.m2505o(115428);
                return aU;
            }
        }
        aU = this.feD.sizeOf("", v);
        AppMethodBeat.m2505o(115428);
        return aU;
    }

    /* renamed from: a */
    public final C1799d<String, C6662a> mo14875a(C1792a c1792a) {
        AppMethodBeat.m2504i(115429);
        C1799d c = C1803b.m3707c(c1792a);
        AppMethodBeat.m2505o(115429);
        return c;
    }

    /* renamed from: aV */
    public final V mo14876aV(V v) {
        return v;
    }

    public final Map<String, V> snapshot() {
        AppMethodBeat.m2504i(115430);
        Map snapshot = this.feD.snapshot();
        AppMethodBeat.m2505o(115430);
        return snapshot;
    }

    /* renamed from: aW */
    private boolean m42019aW(V v) {
        AppMethodBeat.m2504i(115431);
        if (m42018aU(v) * 2 >= C1803b.m3709e(this.fey)) {
            AppMethodBeat.m2505o(115431);
            return true;
        }
        AppMethodBeat.m2505o(115431);
        return false;
    }

    public final V remove(String str) {
        AppMethodBeat.m2504i(115432);
        if (this.fdW != null) {
            this.fdW.remove(str);
        }
        Object remove = super.remove(str);
        AppMethodBeat.m2505o(115432);
        return remove;
    }

    public final V get(String str) {
        V v;
        AppMethodBeat.m2504i(115433);
        V v2 = this.feD.get(str);
        if (v2 != null || this.fdW == null) {
            v = v2;
        } else {
            v = this.fdW.get(str);
        }
        C6662a c6662a = null;
        if (this.feE != null) {
            c6662a = (C6662a) this.feE.mo5363t(this.fdV, str);
        }
        if (C1792a.feq) {
            C4990ab.m7419v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, v, c6662a, C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(115433);
        return v;
    }

    public final V put(String str, V v) {
        AppMethodBeat.m2504i(115434);
        if (!m42019aW(v) || this.fdW == null) {
            V put = super.put(str, v);
            AppMethodBeat.m2505o(115434);
            return put;
        }
        this.fdW.put(str, v);
        AppMethodBeat.m2505o(115434);
        return null;
    }

    /* renamed from: Xn */
    public final /* bridge */ /* synthetic */ Object mo14873Xn() {
        return this.fdV;
    }

    /* renamed from: Xo */
    public final /* synthetic */ C1177f mo14874Xo() {
        AppMethodBeat.m2504i(115441);
        C6294h c6294h = new C6294h(this.maxSize, new C264023());
        AppMethodBeat.m2505o(115441);
        return c6294h;
    }
}
