package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;
import p000a.p051k.C25274k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J$\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J.\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\tJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J \u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J5\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006H\u0002J \u0010/\u001a\u0002002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "StorageInfo", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f */
public final class C19085f implements C10108n {
    private static final C17126b<String, String> gXb = C19090c.gXx;
    private static final C31591m<String, String, C37091y> gXc = C19086e.gXz;
    private static final C5018as gXu;
    public static final C19085f gXv = new C19085f();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "", "key", "", "value", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f$e */
    static final class C19086e extends C25053k implements C31591m<String, String, C37091y> {
        public static final C19086e gXz = new C19086e();

        static {
            AppMethodBeat.m2504i(102441);
            AppMethodBeat.m2505o(102441);
        }

        C19086e() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(102440);
            String str = (String) obj;
            String str2 = (String) obj2;
            C25052j.m39376p(str, "key");
            C25052j.m39376p(str2, "value");
            C19085f c19085f = C19085f.gXv;
            C19085f.gXu.putString(str, str2);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(102440);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f$a */
    public static final class C19087a {
        final String data;
        final String size;
        final String type;

        public C19087a(String str, String str2, String str3) {
            C25052j.m39376p(str, "data");
            C25052j.m39376p(str2, "type");
            C25052j.m39376p(str3, "size");
            AppMethodBeat.m2504i(102434);
            this.data = str;
            this.type = str2;
            this.size = str3;
            AppMethodBeat.m2505o(102434);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "key", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f$b */
    static final class C19088b extends C25053k implements C17126b<String, C37091y> {
        public static final C19088b gXw = new C19088b();

        static {
            AppMethodBeat.m2504i(102436);
            AppMethodBeat.m2505o(102436);
        }

        C19088b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(102435);
            String str = (String) obj;
            C25052j.m39376p(str, "key");
            C19085f c19085f = C19085f.gXv;
            C19085f.gXu.remove(str);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(102435);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f$d */
    static final class C19089d extends C25053k implements C17126b<String, C37091y> {
        final /* synthetic */ C41380b gXy;

        C19089d(C41380b c41380b) {
            this.gXy = c41380b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(102439);
            C25052j.m39376p((String) obj, "it");
            C41380b c41380b = this.gXy;
            c41380b.AVD++;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(102439);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "key", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.f$c */
    static final class C19090c extends C25053k implements C17126b<String, String> {
        public static final C19090c gXx = new C19090c();

        static {
            AppMethodBeat.m2504i(102438);
            AppMethodBeat.m2505o(102438);
        }

        C19090c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(102437);
            String str = (String) obj;
            C25052j.m39376p(str, "key");
            C19085f c19085f = C19085f.gXv;
            Object string = C19085f.gXu.getString(str, "");
            if (string == null) {
                string = "";
            }
            AppMethodBeat.m2505o(102437);
            return string;
        }
    }

    static {
        AppMethodBeat.m2504i(102456);
        C5018as amF = C5018as.amF("AppBrandMMKVStorage");
        C25052j.m39375o(amF, "MultiProcessMMKV.getMMKV(NAME)");
        gXu = amF;
        AppMethodBeat.m2505o(102456);
    }

    private C19085f() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    public static Object[] m29668k(int i, String str, String str2) {
        AppMethodBeat.m2504i(102442);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        Object[] objArr;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            objArr = new Object[]{C10107a.MISSING_PARAMS};
            AppMethodBeat.m2505o(102442);
            return objArr;
        }
        int i2;
        String string = gXu.getString(C38122r.m64501c(i, str, str2, "__"), "");
        if (string == null) {
            string = "";
        }
        C19087a yb = C19085f.m29673yb(string);
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
                        objArr = new Object[]{C10107a.NONE, yb.data, yb.type};
                        AppMethodBeat.m2505o(102442);
                        return objArr;
                    }
                    objArr = C38122r.gYb;
                    AppMethodBeat.m2505o(102442);
                    return objArr;
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
        }
    }

    /* renamed from: b */
    public static C10107a m29665b(int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(102443);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        C25052j.m39376p(str4, "dataType");
        C10107a c10107a;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            c10107a = C10107a.MISSING_PARAMS;
            AppMethodBeat.m2505o(102443);
            return c10107a;
        }
        Object obj;
        String c = C38122r.m64501c(i, str, str2, "__");
        int xU = C19085f.m29672xU(c);
        int by = C38122r.m64499by(str2, str3);
        int i2 = by - xU;
        if (C19085f.m29663H(i, str) + i2 >= C38122r.m64494I(i, str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            c10107a = C10107a.QUOTA_REACHED;
            AppMethodBeat.m2505o(102443);
            return c10107a;
        }
        gXu.putString(c, str4 + "#" + by + "#" + str3);
        C19085f.m29667f(i, str, i2);
        C38122r.m64495a(str, i, gXb, gXc);
        c10107a = C10107a.NONE;
        AppMethodBeat.m2505o(102443);
        return c10107a;
    }

    /* renamed from: e */
    private static void m29666e(int i, String str, int i2) {
        AppMethodBeat.m2504i(102444);
        gXu.putString(C38122r.m64501c(i, str, "@@@TOTAL@DATA@SIZE@@@", "++"), String.valueOf(i2));
        AppMethodBeat.m2505o(102444);
    }

    /* renamed from: f */
    private static int m29667f(int i, String str, int i2) {
        AppMethodBeat.m2504i(102445);
        int max = Math.max(0, C19085f.m29663H(i, str) + i2);
        C19085f.m29666e(i, str, max);
        AppMethodBeat.m2505o(102445);
        return max;
    }

    /* renamed from: xU */
    private static int m29672xU(String str) {
        AppMethodBeat.m2504i(102446);
        String string = gXu.getString(str, "");
        if (string == null) {
            string = "";
        }
        int parseInt = Integer.parseInt(C19085f.m29673yb(string).size);
        AppMethodBeat.m2505o(102446);
        return parseInt;
    }

    /* renamed from: yb */
    private static C19087a m29673yb(String str) {
        AppMethodBeat.m2504i(102447);
        Collection r = new C25274k("#").mo42121r(str, 3);
        C44941v c44941v;
        if (r == null) {
            c44941v = new C44941v("null cannot be cast to non-null type java.util.Collection<T>");
            AppMethodBeat.m2505o(102447);
            throw c44941v;
        }
        Object[] toArray = r.toArray(new String[0]);
        if (toArray == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.m2505o(102447);
            throw c44941v;
        }
        String[] strArr = (String[]) toArray;
        if (strArr.length == 3) {
            C19087a c19087a = new C19087a(strArr[2], strArr[0], strArr[1]);
            AppMethodBeat.m2505o(102447);
            return c19087a;
        }
        C19087a c19087a2 = new C19087a("", "", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.m2505o(102447);
        return c19087a2;
    }

    /* renamed from: l */
    public static C10107a m29669l(int i, String str, String str2) {
        AppMethodBeat.m2504i(102448);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        C10107a c10107a;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            c10107a = C10107a.MISSING_PARAMS;
            AppMethodBeat.m2505o(102448);
            return c10107a;
        }
        String c = C38122r.m64501c(i, str, str2, "__");
        int f = C19085f.m29667f(i, str, -C19085f.m29672xU(c));
        gXu.remove(c);
        if (f <= 0) {
            C38122r.m64497b(str, i, gXb, gXc);
        }
        c10107a = C10107a.NONE;
        AppMethodBeat.m2505o(102448);
        return c10107a;
    }

    /* renamed from: F */
    public static void m29661F(int i, String str) {
        String str2;
        AppMethodBeat.m2504i(102449);
        C25052j.m39376p(str, "appId");
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
            C25052j.m39375o(obj, "key");
            if (C6163u.m9839jb(obj, str2)) {
                gXu.remove(obj);
            }
        }
        C19085f.m29666e(i, str, 0);
        C38122r.m64497b(str, i, gXb, gXc);
        AppMethodBeat.m2505o(102449);
    }

    /* renamed from: xR */
    public static void m29670xR(String str) {
        AppMethodBeat.m2504i(102450);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str, "appId");
        for (int e : C38122r.m64496a(str, gXb, gXc)) {
            C19085f.m29666e(e, str, 0);
        }
        C19085f.m29664a(str, C19088b.gXw);
        C38122r.m64498b(str, gXb, gXc);
        AppMethodBeat.m2505o(102450);
    }

    /* renamed from: G */
    public static Object[] m29662G(int i, String str) {
        String str2;
        AppMethodBeat.m2504i(102451);
        C25052j.m39376p(str, "appId");
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
            C25052j.m39375o(obj, "key");
            if (C6163u.m9839jb(obj, str2)) {
                arrayList.add(C6163u.m9838i(obj, str2, "", false));
            }
        }
        int H = C19085f.m29663H(i, str);
        int I = C38122r.m64494I(i, str);
        Object[] objArr = new Object[]{arrayList, Integer.valueOf(H), Integer.valueOf(I)};
        AppMethodBeat.m2505o(102451);
        return objArr;
    }

    /* renamed from: H */
    private static int m29663H(int i, String str) {
        AppMethodBeat.m2504i(102452);
        int i2 = C5046bo.getInt(gXu.getString(C38122r.m64501c(i, str, "@@@TOTAL@DATA@SIZE@@@", "++"), ""), 0);
        AppMethodBeat.m2505o(102452);
        return i2;
    }

    /* renamed from: a */
    private static void m29664a(String str, C17126b<? super String, C37091y> c17126b) {
        AppMethodBeat.m2504i(102453);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(c17126b, "block");
        C25274k c25274k = new C25274k("^([1-9]\\d*__)?" + str + "__.+$");
        String[] allKeys = gXu.allKeys();
        String[] strArr;
        if (allKeys == null) {
            strArr = new String[0];
        } else {
            strArr = allKeys;
        }
        for (Object obj : strArr) {
            C25052j.m39375o(obj, "key");
            if (c25274k.mo42119aq((CharSequence) obj)) {
                c17126b.mo50am(obj);
            }
        }
        AppMethodBeat.m2505o(102453);
    }

    /* renamed from: yc */
    public static int m29674yc(String str) {
        AppMethodBeat.m2504i(102454);
        C25052j.m39376p(str, "appId");
        C41380b c41380b = new C41380b();
        c41380b.AVD = 0;
        C19085f.m29664a(str, new C19089d(c41380b));
        int i = c41380b.AVD;
        AppMethodBeat.m2505o(102454);
        return i;
    }

    /* renamed from: xT */
    public static int m29671xT(String str) {
        AppMethodBeat.m2504i(102455);
        C25052j.m39376p(str, "appId");
        int[] a = C38122r.m64496a(str, gXb, gXc);
        int i = 0;
        int i2 = 0;
        while (i < a.length) {
            i++;
            i2 = C19085f.m29663H(a[i], str) + i2;
        }
        AppMethodBeat.m2505o(102455);
        return i2;
    }
}
