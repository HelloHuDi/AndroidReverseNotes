package com.tencent.p177mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.p183ai.C8920x.C8921a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.C30192iy;
import com.tencent.p177mm.protocal.protobuf.cwx;
import com.tencent.p177mm.protocal.protobuf.cwy;
import com.tencent.p177mm.protocal.protobuf.cxa;
import com.tencent.p177mm.sdk.p603e.C7293f;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.config.r */
public final class C42406r {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$2 */
    public static class C191602 implements Runnable {
        final /* synthetic */ List hhF;

        public C191602(List list) {
            this.hhF = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(129906);
            for (String aa : this.hhF) {
                C42406r.m75074aa(aa, true);
            }
            AppMethodBeat.m2505o(129906);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$b */
    public interface C38170b<T> {
        /* renamed from: f */
        void mo5935f(int i, T t);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$7 */
    static class C424057 implements C5681a<Void, C37441a<C30192iy>> {
        C424057() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129919);
            C37441a c37441a = (C37441a) obj;
            if (c37441a.errType != 0 || c37441a.errCode != 0) {
                C4990ab.m7413e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            } else if (c37441a.fsy != null) {
                long iV;
                C26844q auO = C42340f.auO();
                if (auO.bSd instanceof C7293f) {
                    iV = ((C7293f) auO.bSd).mo15639iV(Thread.currentThread().getId());
                } else {
                    iV = -1;
                }
                Iterator it = ((C30192iy) c37441a.fsy).vKQ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    cxa cxa = (cxa) it.next();
                    i = C42340f.auO().mo21570a(cxa.xfb, cxa.vMS, cxa.vMT) | i;
                }
                auO = C42340f.auO();
                if (auO.bSd instanceof C7293f) {
                    ((C7293f) auO.bSd).mo15640mB(iV);
                }
                if (i != 0) {
                    C26842p.ayH().mo15641b("batch", 3, null);
                }
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(129919);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.r$a */
    interface C42408a<T> {
        /* renamed from: br */
        boolean mo34397br(T t);

        String getUsername();

        /* renamed from: zv */
        C41226k mo34399zv(String str);

        /* renamed from: zw */
        T mo34400zw(String str);
    }

    private static int ayI() {
        AppMethodBeat.m2504i(129920);
        int i = C26373g.m41964Nu().getInt("MMBizAttrSyncFreq", 3600);
        AppMethodBeat.m2505o(129920);
        return i;
    }

    /* renamed from: zr */
    static boolean m75077zr(String str) {
        AppMethodBeat.m2504i(129921);
        if (C42340f.auO() == null) {
            C4990ab.m7420w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, storage NULL");
            AppMethodBeat.m2505o(129921);
            return false;
        }
        C4990ab.m7419v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", str, Long.valueOf(C5046bo.anT()), Long.valueOf(C42340f.auO().mo21575ze(str)), Integer.valueOf(C42406r.ayI()));
        if (C5046bo.anT() - C42340f.auO().mo21575ze(str) >= ((long) C42406r.ayI())) {
            AppMethodBeat.m2505o(129921);
            return true;
        }
        AppMethodBeat.m2505o(129921);
        return false;
    }

    /* renamed from: zs */
    private static boolean m75078zs(String str) {
        AppMethodBeat.m2504i(129922);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129922);
            return false;
        } else if (C1192l.m2624mg(str)) {
            AppMethodBeat.m2505o(129922);
            return false;
        } else {
            C4990ab.m7413e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", str, C5007an.m7449l(new Throwable()));
            C7053e.pXa.mo8378a(648, 1, 1, false);
            AppMethodBeat.m2505o(129922);
            return true;
        }
    }

    /* renamed from: zt */
    public static void m75079zt(final String str) {
        AppMethodBeat.m2504i(129923);
        if (C42406r.m75078zs(str)) {
            AppMethodBeat.m2505o(129923);
            return;
        }
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129905);
                C42406r.m75080zu(str);
                AppMethodBeat.m2505o(129905);
            }
        }, "WxaAttrSync");
        AppMethodBeat.m2505o(129923);
    }

    /* renamed from: aa */
    public static Pair<WxaAttributes, C37441a> m75074aa(final String str, boolean z) {
        AppMethodBeat.m2504i(129924);
        Pair a = C42406r.m75071a(str, z, new C42408a<WxaAttributes>() {
            /* renamed from: br */
            public final /* synthetic */ boolean mo34397br(Object obj) {
                AppMethodBeat.m2504i(129909);
                boolean isNullOrNil = C5046bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                AppMethodBeat.m2505o(129909);
                return isNullOrNil;
            }

            public final String getUsername() {
                AppMethodBeat.m2504i(129907);
                String zo = C26842p.m42742zo(str);
                AppMethodBeat.m2505o(129907);
                return zo;
            }

            /* renamed from: zv */
            public final C41226k mo34399zv(String str) {
                AppMethodBeat.m2504i(129908);
                C41226k c41226k = new C41226k(null, str);
                AppMethodBeat.m2505o(129908);
                return c41226k;
            }

            /* renamed from: zw */
            public final /* synthetic */ Object mo34400zw(String str) {
                AppMethodBeat.m2504i(129910);
                WxaAttributes e = C42340f.auO().mo21573e(str, new String[0]);
                AppMethodBeat.m2505o(129910);
                return e;
            }
        });
        AppMethodBeat.m2505o(129924);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static <T> Pair<T, C37441a> m75071a(String str, boolean z, C42408a<T> c42408a) {
        Object obj = null;
        AppMethodBeat.m2504i(129925);
        if (C5046bo.isNullOrNil(str) || !C1720g.m3534RN().eJb) {
            Pair create = Pair.create(null, null);
            AppMethodBeat.m2505o(129925);
            return create;
        }
        Object obj2;
        Pair<T, C37441a> create2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = c42408a.mo34400zw(str);
            if (!(obj2 == null || c42408a.mo34397br(obj2))) {
                C4990ab.m7417i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", Boolean.valueOf(z), obj2);
                create2 = Pair.create(obj2, obj);
                AppMethodBeat.m2505o(129925);
                return create2;
            }
        }
        C37441a c = C8920x.m16082c(c42408a.mo34399zv(str).ehh);
        if (c == null || (c instanceof C8921a) || c.errType != 0 || c.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(c == null ? -1 : c.errType);
            objArr[2] = Integer.valueOf(c == null ? -1 : c.errCode);
            objArr[3] = c == null ? "null resp" : c.aIm;
            C4990ab.m7413e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = c42408a.mo34400zw(str);
                if (obj2 == null) {
                    create2 = Pair.create(null, c);
                    AppMethodBeat.m2505o(129925);
                    return create2;
                }
            }
            create2 = Pair.create(obj2, c);
            AppMethodBeat.m2505o(129925);
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
                if (C5046bo.isNullOrNil(str4)) {
                    str4 = c42408a.getUsername();
                    if (C5046bo.isNullOrNil(str4)) {
                        C4990ab.m7413e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", Boolean.valueOf(z), str);
                        create2 = Pair.create(null, null);
                        AppMethodBeat.m2505o(129925);
                        return create2;
                    }
                }
                str5 = str4;
                if (C42340f.auO().mo21570a(str5, ((cwy) c.fsy).vMS, ((cwy) c.fsy).vMT)) {
                    C26842p.ayH().mo15641b("single", 3, str5);
                }
                obj2 = c42408a.mo34400zw(str);
                C4990ab.m7417i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
                obj = c;
                create2 = Pair.create(obj2, obj);
                AppMethodBeat.m2505o(129925);
                return create2;
            }
        }
        str4 = null;
        if (C5046bo.isNullOrNil(str4)) {
        }
        str5 = str4;
        if (C42340f.auO().mo21570a(str5, ((cwy) c.fsy).vMS, ((cwy) c.fsy).vMT)) {
        }
        obj2 = c42408a.mo34400zw(str);
        C4990ab.m7417i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", Boolean.valueOf(z), obj2);
        obj = c;
        create2 = Pair.create(obj2, obj);
        AppMethodBeat.m2505o(129925);
        return create2;
    }

    /* renamed from: ab */
    public static Pair<WxaAttributes, C37441a> m75075ab(final String str, boolean z) {
        AppMethodBeat.m2504i(129926);
        if (C42406r.m75078zs(str)) {
            Pair pair = new Pair(null, null);
            AppMethodBeat.m2505o(129926);
            return pair;
        }
        Pair<WxaAttributes, C37441a> a = C42406r.m75071a(str, z, new C42408a<WxaAttributes>() {
            /* renamed from: br */
            public final /* synthetic */ boolean mo34397br(Object obj) {
                AppMethodBeat.m2504i(129912);
                boolean isNullOrNil = C5046bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                AppMethodBeat.m2505o(129912);
                return isNullOrNil;
            }

            public final String getUsername() {
                return str;
            }

            /* renamed from: zv */
            public final C41226k mo34399zv(String str) {
                AppMethodBeat.m2504i(129911);
                C41226k c41226k = new C41226k(str, null);
                AppMethodBeat.m2505o(129911);
                return c41226k;
            }

            /* renamed from: zw */
            public final /* synthetic */ Object mo34400zw(String str) {
                AppMethodBeat.m2504i(129913);
                WxaAttributes d = C42340f.auO().mo21572d(str, new String[0]);
                AppMethodBeat.m2505o(129913);
                return d;
            }
        });
        AppMethodBeat.m2505o(129926);
        return a;
    }

    /* renamed from: a */
    public static void m75072a(final String str, final boolean z, final C38170b<WxaAttributes> c38170b) {
        AppMethodBeat.m2504i(129927);
        if (C42406r.m75078zs(str)) {
            AppMethodBeat.m2505o(129927);
            return;
        }
        Looper looper;
        boolean z2;
        if (C5004al.isMainThread() || Looper.myLooper() == null) {
            looper = new C5004al().oAl.getLooper();
            z2 = true;
        } else {
            looper = Looper.myLooper();
            z2 = false;
        }
        new C7306ak(looper).post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.config.r$5$1 */
            class C381681 implements C42408a<WxaAttributes> {
                C381681() {
                }

                /* renamed from: br */
                public final /* synthetic */ boolean mo34397br(Object obj) {
                    AppMethodBeat.m2504i(129915);
                    boolean isNullOrNil = C5046bo.isNullOrNil(((WxaAttributes) obj).field_versionInfo);
                    AppMethodBeat.m2505o(129915);
                    return isNullOrNil;
                }

                public final String getUsername() {
                    return str;
                }

                /* renamed from: zv */
                public final C41226k mo34399zv(String str) {
                    AppMethodBeat.m2504i(129914);
                    C41226k c41226k = new C41226k(str, null);
                    AppMethodBeat.m2505o(129914);
                    return c41226k;
                }

                /* renamed from: zw */
                public final /* synthetic */ Object mo34400zw(String str) {
                    AppMethodBeat.m2504i(129916);
                    WxaAttributes d = C42340f.auO().mo21572d(str, new String[0]);
                    AppMethodBeat.m2505o(129916);
                    return d;
                }
            }

            public final void run() {
                boolean z;
                int i = 1;
                AppMethodBeat.m2504i(129917);
                String str = str;
                if (z && C42406r.m75077zr(str)) {
                    z = true;
                } else {
                    z = false;
                }
                Pair a = C42406r.m75071a(str, z, new C381681());
                if (c38170b != null) {
                    if (a.second != null) {
                        if (((C37441a) a.second).errType == 0 && ((C37441a) a.second).errCode == 0) {
                            i = 2;
                        } else {
                            i = 3;
                        }
                    }
                    c38170b.mo5935f(i, a.first);
                }
                if (z2) {
                    try {
                        ((HandlerThread) Looper.myLooper().getThread()).quit();
                        AppMethodBeat.m2505o(129917);
                        return;
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.m2505o(129917);
            }
        });
        AppMethodBeat.m2505o(129927);
    }

    /* renamed from: zu */
    public static void m75080zu(String str) {
        AppMethodBeat.m2504i(129928);
        if (C42406r.m75078zs(str)) {
            AppMethodBeat.m2505o(129928);
            return;
        }
        if (C42406r.m75077zr(str)) {
            C42406r.m75075ab(str, true);
        }
        AppMethodBeat.m2505o(129928);
    }

    /* renamed from: a */
    public static void m75073a(final List<String> list, final C33137a c33137a) {
        int i = 0;
        AppMethodBeat.m2504i(129929);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(129929);
        } else if (C5004al.isMainThread()) {
            C45673m.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129918);
                    C42406r.m75073a(list, c33137a);
                    AppMethodBeat.m2505o(129918);
                }
            });
            AppMethodBeat.m2505o(129929);
        } else {
            if (!((list instanceof ArrayList) || (list instanceof LinkedList))) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                Object list2 = linkedList;
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (!C42406r.m75077zr((String) it.next())) {
                    it.remove();
                }
            }
            if (C5046bo.m7548ek(list2)) {
                AppMethodBeat.m2505o(129929);
                return;
            }
            int i2;
            C4990ab.m7417i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", Integer.valueOf(list2.size()), c33137a.name(), Integer.valueOf(c33137a.intValue));
            int i3 = 0;
            while (true) {
                i2 = i;
                if (i3 >= list2.size() / 20) {
                    break;
                }
                i2 = i3 * 20;
                i = i2 + 20;
                C42406r.m75076b(list2.subList(i2, i), c33137a);
                i3++;
            }
            if (i2 < list2.size()) {
                C42406r.m75076b(list2.subList(i2, list2.size()), c33137a);
            }
            AppMethodBeat.m2505o(129929);
        }
    }

    /* renamed from: b */
    private static void m75076b(List<String> list, C33137a c33137a) {
        AppMethodBeat.m2504i(129930);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(129930);
            return;
        }
        new C33138j(list, c33137a).acy().mo60493i(new C424057());
        AppMethodBeat.m2505o(129930);
    }
}
