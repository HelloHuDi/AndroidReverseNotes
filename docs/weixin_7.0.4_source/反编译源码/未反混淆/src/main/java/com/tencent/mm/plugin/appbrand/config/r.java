package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.ai.x;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$2 */
    public static class AnonymousClass2 implements Runnable {
        final /* synthetic */ List hhF;

        public AnonymousClass2(List list) {
            this.hhF = list;
        }

        public final void run() {
            AppMethodBeat.i(129906);
            for (String aa : this.hhF) {
                r.aa(aa, true);
            }
            AppMethodBeat.o(129906);
        }
    }

    public interface b<T> {
        void f(int i, T t);
    }

    interface a<T> {
        boolean br(T t);

        String getUsername();

        k zv(String str);

        T zw(String str);
    }

    private static int ayI() {
        AppMethodBeat.i(129920);
        int i = g.Nu().getInt("MMBizAttrSyncFreq", 3600);
        AppMethodBeat.o(129920);
        return i;
    }

    static boolean zr(String str) {
        AppMethodBeat.i(129921);
        if (f.auO() == null) {
            ab.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
            AppMethodBeat.o(129921);
            return false;
        }
        ab.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", str, Long.valueOf(bo.anT()), Long.valueOf(f.auO().ze(str)), Integer.valueOf(ayI()));
        if (bo.anT() - f.auO().ze(str) >= ((long) ayI())) {
            AppMethodBeat.o(129921);
            return true;
        }
        AppMethodBeat.o(129921);
        return false;
    }

    private static boolean zs(String str) {
        AppMethodBeat.i(129922);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129922);
            return false;
        } else if (l.mg(str)) {
            AppMethodBeat.o(129922);
            return false;
        } else {
            ab.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", str, an.l(new Throwable()));
            e.pXa.a(648, 1, 1, false);
            AppMethodBeat.o(129922);
            return true;
        }
    }

    public static void zt(final String str) {
        AppMethodBeat.i(129923);
        if (zs(str)) {
            AppMethodBeat.o(129923);
            return;
        }
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129905);
                r.zu(str);
                AppMethodBeat.o(129905);
            }
        }, "WxaAttrSync");
        AppMethodBeat.o(129923);
    }

    public static Pair<WxaAttributes, com.tencent.mm.ai.a.a> aa(final String str, boolean z) {
        AppMethodBeat.i(129924);
        Pair a = a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean br(Object obj) {
                AppMethodBeat.i(129909);
                boolean isNullOrNil = bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                AppMethodBeat.o(129909);
                return isNullOrNil;
            }

            public final String getUsername() {
                AppMethodBeat.i(129907);
                String zo = p.zo(str);
                AppMethodBeat.o(129907);
                return zo;
            }

            public final k zv(String str) {
                AppMethodBeat.i(129908);
                k kVar = new k(null, str);
                AppMethodBeat.o(129908);
                return kVar;
            }

            public final /* synthetic */ Object zw(String str) {
                AppMethodBeat.i(129910);
                WxaAttributes e = f.auO().e(str, new String[0]);
                AppMethodBeat.o(129910);
                return e;
            }
        });
        AppMethodBeat.o(129924);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> Pair<T, com.tencent.mm.ai.a.a> a(String str, boolean z, a<T> aVar) {
        Object obj = null;
        AppMethodBeat.i(129925);
        if (bo.isNullOrNil(str) || !com.tencent.mm.kernel.g.RN().eJb) {
            Pair create = Pair.create(null, null);
            AppMethodBeat.o(129925);
            return create;
        }
        Object obj2;
        Pair<T, com.tencent.mm.ai.a.a> create2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = aVar.zw(str);
            if (!(obj2 == null || aVar.br(obj2))) {
                ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", Boolean.valueOf(z), obj2);
                create2 = Pair.create(obj2, obj);
                AppMethodBeat.o(129925);
                return create2;
            }
        }
        com.tencent.mm.ai.a.a c = x.c(aVar.zv(str).ehh);
        if (c == null || (c instanceof com.tencent.mm.ai.x.a) || c.errType != 0 || c.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(c == null ? -1 : c.errType);
            objArr[2] = Integer.valueOf(c == null ? -1 : c.errCode);
            objArr[3] = c == null ? "null resp" : c.aIm;
            ab.e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = aVar.zw(str);
                if (obj2 == null) {
                    create2 = Pair.create(null, c);
                    AppMethodBeat.o(129925);
                    return create2;
                }
            }
            create2 = Pair.create(obj2, c);
            AppMethodBeat.o(129925);
            return create2;
        }
        String str4;
        String str5;
        Iterator it = ((cwy) c.fsy).vMT.iterator();
        while (it.hasNext()) {
            cwx cwx = (cwx) it.next();
            if ("UserName".equalsIgnoreCase(cwx.vMU)) {
                str4 = cwx.pXM;
                if (!str4.endsWith("@app")) {
                    str4 = str4 + "@app";
                }
                if (bo.isNullOrNil(str4)) {
                    str4 = aVar.getUsername();
                    if (bo.isNullOrNil(str4)) {
                        ab.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", Boolean.valueOf(z), str);
                        create2 = Pair.create(null, null);
                        AppMethodBeat.o(129925);
                        return create2;
                    }
                }
                str5 = str4;
                if (f.auO().a(str5, ((cwy) c.fsy).vMS, ((cwy) c.fsy).vMT)) {
                    p.ayH().b("single", 3, str5);
                }
                obj2 = aVar.zw(str);
                ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
                obj = c;
                create2 = Pair.create(obj2, obj);
                AppMethodBeat.o(129925);
                return create2;
            }
        }
        str4 = null;
        if (bo.isNullOrNil(str4)) {
        }
        str5 = str4;
        if (f.auO().a(str5, ((cwy) c.fsy).vMS, ((cwy) c.fsy).vMT)) {
        }
        obj2 = aVar.zw(str);
        ab.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
        obj = c;
        create2 = Pair.create(obj2, obj);
        AppMethodBeat.o(129925);
        return create2;
    }

    public static Pair<WxaAttributes, com.tencent.mm.ai.a.a> ab(final String str, boolean z) {
        AppMethodBeat.i(129926);
        if (zs(str)) {
            Pair pair = new Pair(null, null);
            AppMethodBeat.o(129926);
            return pair;
        }
        Pair<WxaAttributes, com.tencent.mm.ai.a.a> a = a(str, z, new a<WxaAttributes>() {
            public final /* synthetic */ boolean br(Object obj) {
                AppMethodBeat.i(129912);
                boolean isNullOrNil = bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                AppMethodBeat.o(129912);
                return isNullOrNil;
            }

            public final String getUsername() {
                return str;
            }

            public final k zv(String str) {
                AppMethodBeat.i(129911);
                k kVar = new k(str, null);
                AppMethodBeat.o(129911);
                return kVar;
            }

            public final /* synthetic */ Object zw(String str) {
                AppMethodBeat.i(129913);
                WxaAttributes d = f.auO().d(str, new String[0]);
                AppMethodBeat.o(129913);
                return d;
            }
        });
        AppMethodBeat.o(129926);
        return a;
    }

    public static void a(final String str, final boolean z, final b<WxaAttributes> bVar) {
        AppMethodBeat.i(129927);
        if (zs(str)) {
            AppMethodBeat.o(129927);
            return;
        }
        Looper looper;
        boolean z2;
        if (al.isMainThread() || Looper.myLooper() == null) {
            looper = new al().oAl.getLooper();
            z2 = true;
        } else {
            looper = Looper.myLooper();
            z2 = false;
        }
        new ak(looper).post(new Runnable() {
            public final void run() {
                boolean z;
                int i = 1;
                AppMethodBeat.i(129917);
                String str = str;
                if (z && r.zr(str)) {
                    z = true;
                } else {
                    z = false;
                }
                Pair a = r.a(str, z, new a<WxaAttributes>() {
                    public final /* synthetic */ boolean br(Object obj) {
                        AppMethodBeat.i(129915);
                        boolean isNullOrNil = bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                        AppMethodBeat.o(129915);
                        return isNullOrNil;
                    }

                    public final String getUsername() {
                        return str;
                    }

                    public final k zv(String str) {
                        AppMethodBeat.i(129914);
                        k kVar = new k(str, null);
                        AppMethodBeat.o(129914);
                        return kVar;
                    }

                    public final /* synthetic */ Object zw(String str) {
                        AppMethodBeat.i(129916);
                        WxaAttributes d = f.auO().d(str, new String[0]);
                        AppMethodBeat.o(129916);
                        return d;
                    }
                });
                if (bVar != null) {
                    if (a.second != null) {
                        if (((com.tencent.mm.ai.a.a) a.second).errType == 0 && ((com.tencent.mm.ai.a.a) a.second).errCode == 0) {
                            i = 2;
                        } else {
                            i = 3;
                        }
                    }
                    bVar.f(i, a.first);
                }
                if (z2) {
                    try {
                        ((HandlerThread) Looper.myLooper().getThread()).quit();
                        AppMethodBeat.o(129917);
                        return;
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.o(129917);
            }
        });
        AppMethodBeat.o(129927);
    }

    public static void zu(String str) {
        AppMethodBeat.i(129928);
        if (zs(str)) {
            AppMethodBeat.o(129928);
            return;
        }
        if (zr(str)) {
            ab(str, true);
        }
        AppMethodBeat.o(129928);
    }

    public static void a(final List<String> list, final com.tencent.mm.plugin.appbrand.config.j.a aVar) {
        int i = 0;
        AppMethodBeat.i(129929);
        if (bo.ek(list)) {
            AppMethodBeat.o(129929);
        } else if (al.isMainThread()) {
            m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129918);
                    r.a(list, aVar);
                    AppMethodBeat.o(129918);
                }
            });
            AppMethodBeat.o(129929);
        } else {
            if (!((list instanceof ArrayList) || (list instanceof LinkedList))) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                Object list2 = linkedList;
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (!zr((String) it.next())) {
                    it.remove();
                }
            }
            if (bo.ek(list2)) {
                AppMethodBeat.o(129929);
                return;
            }
            int i2;
            ab.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", Integer.valueOf(list2.size()), aVar.name(), Integer.valueOf(aVar.intValue));
            int i3 = 0;
            while (true) {
                i2 = i;
                if (i3 >= list2.size() / 20) {
                    break;
                }
                i2 = i3 * 20;
                i = i2 + 20;
                b(list2.subList(i2, i), aVar);
                i3++;
            }
            if (i2 < list2.size()) {
                b(list2.subList(i2, list2.size()), aVar);
            }
            AppMethodBeat.o(129929);
        }
    }

    private static void b(List<String> list, com.tencent.mm.plugin.appbrand.config.j.a aVar) {
        AppMethodBeat.i(129930);
        if (bo.ek(list)) {
            AppMethodBeat.o(129930);
            return;
        }
        new j(list, aVar).acy().i(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<iy>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129919);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                if (aVar.errType != 0 || aVar.errCode != 0) {
                    ab.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                } else if (aVar.fsy != null) {
                    long iV;
                    q auO = f.auO();
                    if (auO.bSd instanceof com.tencent.mm.sdk.e.f) {
                        iV = ((com.tencent.mm.sdk.e.f) auO.bSd).iV(Thread.currentThread().getId());
                    } else {
                        iV = -1;
                    }
                    Iterator it = ((iy) aVar.fsy).vKQ.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        cxa cxa = (cxa) it.next();
                        i = f.auO().a(cxa.xfb, cxa.vMS, cxa.vMT) | i;
                    }
                    auO = f.auO();
                    if (auO.bSd instanceof com.tencent.mm.sdk.e.f) {
                        ((com.tencent.mm.sdk.e.f) auO.bSd).mB(iV);
                    }
                    if (i != 0) {
                        p.ayH().b("batch", 3, null);
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.o(129919);
                return voidR;
            }
        });
        AppMethodBeat.o(129930);
    }
}
