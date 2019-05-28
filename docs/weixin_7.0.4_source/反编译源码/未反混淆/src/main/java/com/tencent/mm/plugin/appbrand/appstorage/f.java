package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.v;
import a.y;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J$\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J.\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\tJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J \u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J5\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006H\u0002J \u0010/\u001a\u0002002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class f implements n {
    private static final a.f.a.b<String, String> gXb = c.gXx;
    private static final m<String, String, y> gXc = e.gXz;
    private static final as gXu;
    public static final f gXv = new f();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "", "key", "", "value", "invoke"})
    static final class e extends k implements m<String, String, y> {
        public static final e gXz = new e();

        static {
            AppMethodBeat.i(102441);
            AppMethodBeat.o(102441);
        }

        e() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(102440);
            String str = (String) obj;
            String str2 = (String) obj2;
            j.p(str, "key");
            j.p(str2, "value");
            f fVar = f.gXv;
            f.gXu.putString(str, str2);
            y yVar = y.AUy;
            AppMethodBeat.o(102440);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        final String data;
        final String size;
        final String type;

        public a(String str, String str2, String str3) {
            j.p(str, "data");
            j.p(str2, "type");
            j.p(str3, "size");
            AppMethodBeat.i(102434);
            this.data = str;
            this.type = str2;
            this.size = str3;
            AppMethodBeat.o(102434);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "key", "", "invoke"})
    static final class b extends k implements a.f.a.b<String, y> {
        public static final b gXw = new b();

        static {
            AppMethodBeat.i(102436);
            AppMethodBeat.o(102436);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(102435);
            String str = (String) obj;
            j.p(str, "key");
            f fVar = f.gXv;
            f.gXu.remove(str);
            y yVar = y.AUy;
            AppMethodBeat.o(102435);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class d extends k implements a.f.a.b<String, y> {
        final /* synthetic */ a.f.b.u.b gXy;

        d(a.f.b.u.b bVar) {
            this.gXy = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(102439);
            j.p((String) obj, "it");
            a.f.b.u.b bVar = this.gXy;
            bVar.AVD++;
            y yVar = y.AUy;
            AppMethodBeat.o(102439);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "key", "invoke"})
    static final class c extends k implements a.f.a.b<String, String> {
        public static final c gXx = new c();

        static {
            AppMethodBeat.i(102438);
            AppMethodBeat.o(102438);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(102437);
            String str = (String) obj;
            j.p(str, "key");
            f fVar = f.gXv;
            Object string = f.gXu.getString(str, "");
            if (string == null) {
                string = "";
            }
            AppMethodBeat.o(102437);
            return string;
        }
    }

    static {
        AppMethodBeat.i(102456);
        as amF = as.amF("AppBrandMMKVStorage");
        j.o(amF, "MultiProcessMMKV.getMMKV(NAME)");
        gXu = amF;
        AppMethodBeat.o(102456);
    }

    private f() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object[] k(int i, String str, String str2) {
        AppMethodBeat.i(102442);
        j.p(str, "appId");
        j.p(str2, "key");
        Object[] objArr;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            objArr = new Object[]{com.tencent.mm.plugin.appbrand.appstorage.n.a.MISSING_PARAMS};
            AppMethodBeat.o(102442);
            return objArr;
        }
        int i2;
        String string = gXu.getString(r.c(i, str, str2, "__"), "");
        if (string == null) {
            string = "";
        }
        a yb = yb(string);
        if (yb.data.length() == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            if (yb.type.length() == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                if (yb.size.length() == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    i2 = 1;
                    if (i2 != 0) {
                        objArr = new Object[]{com.tencent.mm.plugin.appbrand.appstorage.n.a.NONE, yb.data, yb.type};
                        AppMethodBeat.o(102442);
                        return objArr;
                    }
                    objArr = r.gYb;
                    AppMethodBeat.o(102442);
                    return objArr;
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
        }
    }

    public static com.tencent.mm.plugin.appbrand.appstorage.n.a b(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(102443);
        j.p(str, "appId");
        j.p(str2, "key");
        j.p(str4, "dataType");
        com.tencent.mm.plugin.appbrand.appstorage.n.a aVar;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            aVar = com.tencent.mm.plugin.appbrand.appstorage.n.a.MISSING_PARAMS;
            AppMethodBeat.o(102443);
            return aVar;
        }
        Object obj;
        String c = r.c(i, str, str2, "__");
        int xU = xU(c);
        int by = r.by(str2, str3);
        int i2 = by - xU;
        if (H(i, str) + i2 >= r.I(i, str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aVar = com.tencent.mm.plugin.appbrand.appstorage.n.a.QUOTA_REACHED;
            AppMethodBeat.o(102443);
            return aVar;
        }
        gXu.putString(c, str4 + "#" + by + "#" + str3);
        f(i, str, i2);
        r.a(str, i, gXb, gXc);
        aVar = com.tencent.mm.plugin.appbrand.appstorage.n.a.NONE;
        AppMethodBeat.o(102443);
        return aVar;
    }

    private static void e(int i, String str, int i2) {
        AppMethodBeat.i(102444);
        gXu.putString(r.c(i, str, "@@@TOTAL@DATA@SIZE@@@", "++"), String.valueOf(i2));
        AppMethodBeat.o(102444);
    }

    private static int f(int i, String str, int i2) {
        AppMethodBeat.i(102445);
        int max = Math.max(0, H(i, str) + i2);
        e(i, str, max);
        AppMethodBeat.o(102445);
        return max;
    }

    private static int xU(String str) {
        AppMethodBeat.i(102446);
        String string = gXu.getString(str, "");
        if (string == null) {
            string = "";
        }
        int parseInt = Integer.parseInt(yb(string).size);
        AppMethodBeat.o(102446);
        return parseInt;
    }

    private static a yb(String str) {
        AppMethodBeat.i(102447);
        Collection r = new a.k.k("#").r(str, 3);
        v vVar;
        if (r == null) {
            vVar = new v("null cannot be cast to non-null type java.util.Collection<T>");
            AppMethodBeat.o(102447);
            throw vVar;
        }
        Object[] toArray = r.toArray(new String[0]);
        if (toArray == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(102447);
            throw vVar;
        }
        String[] strArr = (String[]) toArray;
        if (strArr.length == 3) {
            a aVar = new a(strArr[2], strArr[0], strArr[1]);
            AppMethodBeat.o(102447);
            return aVar;
        }
        a aVar2 = new a("", "", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(102447);
        return aVar2;
    }

    public static com.tencent.mm.plugin.appbrand.appstorage.n.a l(int i, String str, String str2) {
        AppMethodBeat.i(102448);
        j.p(str, "appId");
        j.p(str2, "key");
        com.tencent.mm.plugin.appbrand.appstorage.n.a aVar;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            aVar = com.tencent.mm.plugin.appbrand.appstorage.n.a.MISSING_PARAMS;
            AppMethodBeat.o(102448);
            return aVar;
        }
        String c = r.c(i, str, str2, "__");
        int f = f(i, str, -xU(c));
        gXu.remove(c);
        if (f <= 0) {
            r.b(str, i, gXb, gXc);
        }
        aVar = com.tencent.mm.plugin.appbrand.appstorage.n.a.NONE;
        AppMethodBeat.o(102448);
        return aVar;
    }

    public static void F(int i, String str) {
        String str2;
        AppMethodBeat.i(102449);
        j.p(str, "appId");
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = String.valueOf(i) + "__" + str + "__";
        }
        String[] allKeys = gXu.allKeys();
        if (allKeys == null) {
            allKeys = new String[0];
        }
        for (Object obj : allKeys) {
            j.o(obj, "key");
            if (u.jb(obj, str2)) {
                gXu.remove(obj);
            }
        }
        e(i, str, 0);
        r.b(str, i, gXb, gXc);
        AppMethodBeat.o(102449);
    }

    public static void xR(String str) {
        AppMethodBeat.i(102450);
        j.p(str, "appId");
        j.p(str, "appId");
        for (int e : r.a(str, gXb, gXc)) {
            e(e, str, 0);
        }
        a(str, b.gXw);
        r.b(str, gXb, gXc);
        AppMethodBeat.o(102450);
    }

    public static Object[] G(int i, String str) {
        String str2;
        AppMethodBeat.i(102451);
        j.p(str, "appId");
        List arrayList = new ArrayList();
        if (i == 0) {
            str2 = str + "__";
        } else {
            str2 = String.valueOf(i) + "__" + str + "__";
        }
        String[] allKeys = gXu.allKeys();
        if (allKeys == null) {
            allKeys = new String[0];
        }
        for (Object obj : allKeys) {
            j.o(obj, "key");
            if (u.jb(obj, str2)) {
                arrayList.add(u.i(obj, str2, "", false));
            }
        }
        int H = H(i, str);
        int I = r.I(i, str);
        Object[] objArr = new Object[]{arrayList, Integer.valueOf(H), Integer.valueOf(I)};
        AppMethodBeat.o(102451);
        return objArr;
    }

    private static int H(int i, String str) {
        AppMethodBeat.i(102452);
        int i2 = bo.getInt(gXu.getString(r.c(i, str, "@@@TOTAL@DATA@SIZE@@@", "++"), ""), 0);
        AppMethodBeat.o(102452);
        return i2;
    }

    private static void a(String str, a.f.a.b<? super String, y> bVar) {
        AppMethodBeat.i(102453);
        j.p(str, "appId");
        j.p(bVar, "block");
        a.k.k kVar = new a.k.k("^([1-9]\\d*__)?" + str + "__.+$");
        String[] allKeys = gXu.allKeys();
        String[] strArr;
        if (allKeys == null) {
            strArr = new String[0];
        } else {
            strArr = allKeys;
        }
        for (Object obj : strArr) {
            j.o(obj, "key");
            if (kVar.aq((CharSequence) obj)) {
                bVar.am(obj);
            }
        }
        AppMethodBeat.o(102453);
    }

    public static int yc(String str) {
        AppMethodBeat.i(102454);
        j.p(str, "appId");
        a.f.b.u.b bVar = new a.f.b.u.b();
        bVar.AVD = 0;
        a(str, new d(bVar));
        int i = bVar.AVD;
        AppMethodBeat.o(102454);
        return i;
    }

    public static int xT(String str) {
        AppMethodBeat.i(102455);
        j.p(str, "appId");
        int[] a = r.a(str, gXb, gXc);
        int i = 0;
        int i2 = 0;
        while (i < a.length) {
            i++;
            i2 = H(a[i], str) + i2;
        }
        AppMethodBeat.o(102455);
        return i2;
    }
}
