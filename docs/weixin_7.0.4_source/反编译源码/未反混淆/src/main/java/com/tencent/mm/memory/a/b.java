package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.c;
import com.tencent.mm.a.h;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V> extends a<String, V, V, com.tencent.mm.memory.a.a.a> {
    private static ConcurrentHashMap<Class<?>, a> fdX = new ConcurrentHashMap();
    String fdV;
    f<String, Object> fdW;
    private com.tencent.mm.a.f.b<String, com.tencent.mm.memory.a.a.a> fdY;
    private c<String, com.tencent.mm.memory.a.a.a> fdZ;

    public interface a<T> {
        int aU(T t);
    }

    public final /* bridge */ /* synthetic */ Object aX(Object obj) {
        return obj;
    }

    public final /* synthetic */ Object ai(Object obj) {
        Object obj2;
        AppMethodBeat.i(115435);
        String str = (String) obj;
        Object ai = this.feD.ai(str);
        if (ai != null || this.fdW == null) {
            obj2 = ai;
        } else {
            obj2 = this.fdW.get(str);
        }
        com.tencent.mm.memory.a.a.a aVar = null;
        if (this.feE != null) {
            aVar = (com.tencent.mm.memory.a.a.a) this.feE.u(this.fdV, str);
        }
        if (com.tencent.mm.memory.a.a.a.a.feq) {
            ab.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, obj2, aVar, bo.dpG().toString());
        }
        AppMethodBeat.o(115435);
        return obj2;
    }

    public final /* synthetic */ void k(Object obj, Object obj2) {
        AppMethodBeat.i(115439);
        String str = (String) obj;
        if (!aW(obj2) || this.fdW == null) {
            super.k(str, obj2);
            AppMethodBeat.o(115439);
            return;
        }
        this.fdW.put(str, obj2);
        AppMethodBeat.o(115439);
    }

    public final /* synthetic */ Object o(Object obj, Object obj2) {
        AppMethodBeat.i(115440);
        com.tencent.mm.memory.a.a.a aVar = new com.tencent.mm.memory.a.a.a((String) obj, this.fdV, obj2, aU(obj2), this.fdY, this.fdZ);
        AppMethodBeat.o(115440);
        return aVar;
    }

    static {
        AppMethodBeat.i(115442);
        a(Bitmap.class, new a<Bitmap>() {
            public final /* synthetic */ int aU(Object obj) {
                AppMethodBeat.i(115418);
                Bitmap bitmap = (Bitmap) obj;
                int byteCount;
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(115418);
                    return 0;
                } else if (d.fP(19)) {
                    byteCount = bitmap.getByteCount();
                    AppMethodBeat.o(115418);
                    return byteCount;
                } else {
                    byteCount = bitmap.getAllocationByteCount();
                    AppMethodBeat.o(115418);
                    return byteCount;
                }
            }
        });
        a(WeakReference.class, new a<WeakReference<Bitmap>>() {
            public final /* synthetic */ int aU(Object obj) {
                AppMethodBeat.i(115419);
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference == null) {
                    AppMethodBeat.o(115419);
                    return 0;
                }
                Bitmap bitmap = (Bitmap) weakReference.get();
                int byteCount;
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(115419);
                    return 0;
                } else if (d.fP(19)) {
                    byteCount = bitmap.getByteCount();
                    AppMethodBeat.o(115419);
                    return byteCount;
                } else {
                    byteCount = bitmap.getAllocationByteCount();
                    AppMethodBeat.o(115419);
                    return byteCount;
                }
            }
        });
        AppMethodBeat.o(115442);
    }

    public static void a(Class<?> cls, a aVar) {
        AppMethodBeat.i(115422);
        fdX.put(cls, aVar);
        AppMethodBeat.o(115422);
    }

    public b(int i, Class<?> cls) {
        this(i, null, cls);
        AppMethodBeat.i(115423);
        W(cls);
        AppMethodBeat.o(115423);
    }

    public b(int i, com.tencent.mm.a.f.b<String, V> bVar, Class<?> cls) {
        this(i, bVar, com.tencent.mm.memory.a.a.a.a.Xw(), cls);
        AppMethodBeat.i(115424);
        W(cls);
        AppMethodBeat.o(115424);
    }

    private b(int i, com.tencent.mm.a.f.b<String, V> bVar, com.tencent.mm.memory.a.a.a.a aVar, Class<?> cls) {
        super(i, bVar, aVar);
        AppMethodBeat.i(115425);
        this.fdV = "";
        this.fdW = null;
        this.fdY = new com.tencent.mm.a.f.b<String, com.tencent.mm.memory.a.a.a>() {
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(115421);
                String str = (String) obj;
                com.tencent.mm.memory.a.a.a aVar = (com.tencent.mm.memory.a.a.a) obj2;
                com.tencent.mm.memory.a.a.a aVar2 = (com.tencent.mm.memory.a.a.a) obj3;
                String str2;
                String str3;
                Object[] objArr;
                if (aVar != null && aVar2 != null && aVar.equals(aVar2)) {
                    if (com.tencent.mm.memory.a.a.a.a.feq) {
                        str2 = "MicroMsg.BitmapResource";
                        str3 = "Proxy remove1 %s oldValue %s newValue %s size %s stack [%s]";
                        objArr = new Object[5];
                        objArr[0] = str;
                        objArr[1] = aVar == null ? " is null " : aVar.toString();
                        objArr[2] = aVar2 == null ? " is null " : aVar2.toString();
                        objArr[3] = Integer.valueOf(b.this.feE.size());
                        objArr[4] = bo.dpG().toString();
                        ab.v(str2, str3, objArr);
                    }
                    AppMethodBeat.o(115421);
                } else if (aVar2 == null || aVar == null || !aVar2.key.equals(aVar.key)) {
                    if (com.tencent.mm.memory.a.a.a.a.feq) {
                        str2 = "MicroMsg.BitmapResource";
                        str3 = "Proxy remove3 %s oldValue %s newValue %s size %s stack [%s]";
                        objArr = new Object[5];
                        objArr[0] = str;
                        objArr[1] = aVar == null ? " is null " : aVar.toString();
                        objArr[2] = aVar2 == null ? " is null " : aVar2.toString();
                        objArr[3] = Integer.valueOf(b.this.feE.size());
                        objArr[4] = bo.dpG().toString();
                        ab.v(str2, str3, objArr);
                    }
                    b.this.feD.remove(aVar.key);
                    AppMethodBeat.o(115421);
                } else {
                    if (com.tencent.mm.memory.a.a.a.a.feq) {
                        str2 = "MicroMsg.BitmapResource";
                        str3 = "Proxy remove2 %s oldValue %s newValue %s size %s stack [%s]";
                        objArr = new Object[5];
                        objArr[0] = str;
                        objArr[1] = aVar == null ? " is null " : aVar.toString();
                        objArr[2] = aVar2 == null ? " is null " : aVar2.toString();
                        objArr[3] = Integer.valueOf(b.this.feE.size());
                        objArr[4] = bo.dpG().toString();
                        ab.v(str2, str3, objArr);
                    }
                    AppMethodBeat.o(115421);
                }
            }
        };
        this.fdZ = new c<String, com.tencent.mm.memory.a.a.a>() {
            public final /* bridge */ /* synthetic */ int l(Object obj, Object obj2) {
                com.tencent.mm.memory.a.a.a aVar = (com.tencent.mm.memory.a.a.a) obj2;
                if (aVar != null) {
                    return aVar.fee;
                }
                return SQLiteGlobal.journalSizeLimit;
            }
        };
        W(cls);
        AppMethodBeat.o(115425);
    }

    private void W(Class<?> cls) {
        AppMethodBeat.i(115426);
        this.fdV = cls.getSimpleName();
        this.fdW = com.tencent.mm.memory.a.a.b.d(this.fey);
        AppMethodBeat.o(115426);
    }

    public final void init() {
        AppMethodBeat.i(115427);
        super.init();
        AppMethodBeat.o(115427);
    }

    private int aU(V v) {
        int aU;
        AppMethodBeat.i(115428);
        if (v != null) {
            a aVar = (a) fdX.get(v.getClass());
            if (aVar != null) {
                aU = aVar.aU(v);
                AppMethodBeat.o(115428);
                return aU;
            }
        }
        aU = this.feD.sizeOf("", v);
        AppMethodBeat.o(115428);
        return aU;
    }

    public final com.tencent.mm.memory.a.a.a.d<String, com.tencent.mm.memory.a.a.a> a(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(115429);
        com.tencent.mm.memory.a.a.a.d c = com.tencent.mm.memory.a.a.b.c(aVar);
        AppMethodBeat.o(115429);
        return c;
    }

    public final V aV(V v) {
        return v;
    }

    public final Map<String, V> snapshot() {
        AppMethodBeat.i(115430);
        Map snapshot = this.feD.snapshot();
        AppMethodBeat.o(115430);
        return snapshot;
    }

    private boolean aW(V v) {
        AppMethodBeat.i(115431);
        if (aU(v) * 2 >= com.tencent.mm.memory.a.a.b.e(this.fey)) {
            AppMethodBeat.o(115431);
            return true;
        }
        AppMethodBeat.o(115431);
        return false;
    }

    public final V remove(String str) {
        AppMethodBeat.i(115432);
        if (this.fdW != null) {
            this.fdW.remove(str);
        }
        Object remove = super.remove(str);
        AppMethodBeat.o(115432);
        return remove;
    }

    public final V get(String str) {
        V v;
        AppMethodBeat.i(115433);
        V v2 = this.feD.get(str);
        if (v2 != null || this.fdW == null) {
            v = v2;
        } else {
            v = this.fdW.get(str);
        }
        com.tencent.mm.memory.a.a.a aVar = null;
        if (this.feE != null) {
            aVar = (com.tencent.mm.memory.a.a.a) this.feE.t(this.fdV, str);
        }
        if (com.tencent.mm.memory.a.a.a.a.feq) {
            ab.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, v, aVar, bo.dpG().toString());
        }
        AppMethodBeat.o(115433);
        return v;
    }

    public final V put(String str, V v) {
        AppMethodBeat.i(115434);
        if (!aW(v) || this.fdW == null) {
            V put = super.put(str, v);
            AppMethodBeat.o(115434);
            return put;
        }
        this.fdW.put(str, v);
        AppMethodBeat.o(115434);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object Xn() {
        return this.fdV;
    }

    public final /* synthetic */ f Xo() {
        AppMethodBeat.i(115441);
        h hVar = new h(this.maxSize, new com.tencent.mm.a.f.b<String, V>() {
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(115420);
                String str = (String) obj;
                if (obj2 == null || obj3 == null || obj2 != obj3) {
                    if (com.tencent.mm.memory.a.a.a.a.feq) {
                        ab.v("MicroMsg.BitmapResource", "BitmapResource MMLRUMap remove %s value newValue %s %s maxSize %s getfromKey %s stack [%s]", str, obj2, obj3, Integer.valueOf(b.this.maxSize), b.this.feD.get(str), bo.dpG().toString());
                    }
                    if (!(b.this.feF == null || obj2 == null || obj3 != null)) {
                        ab.i("MicroMsg.BitmapResource", "let me see see");
                        b.this.feF.c(str, obj2, obj3);
                    }
                    if (b.this.feE != null) {
                        b.this.feE.s(b.this.fdV, str);
                    }
                }
                AppMethodBeat.o(115420);
            }
        });
        AppMethodBeat.o(115441);
        return hVar;
    }
}
