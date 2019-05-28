package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.C2117i;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p001a.C36646h;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JF\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J>\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.r */
public final class C38122r {
    public static final Object[] gYb = new Object[]{C10107a.NO_SUCH_KEY};
    public static final C38122r gYc = new C38122r();

    static {
        AppMethodBeat.m2504i(102467);
        AppMethodBeat.m2505o(102467);
    }

    private C38122r() {
    }

    /* renamed from: nw */
    public static final boolean m64503nw(int i) {
        if (i >= 0 && i <= 1) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static final String m64501c(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(102458);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        C25052j.m39376p(str3, "separator");
        StringBuilder stringBuilder = new StringBuilder();
        if (i > 0) {
            stringBuilder.append(i).append(str3);
        }
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "sb.toString()");
        AppMethodBeat.m2505o(102458);
        return stringBuilder2;
    }

    /* renamed from: by */
    public static final int m64499by(String str, String str2) {
        AppMethodBeat.m2504i(102459);
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (str2 == null) {
            str2 = "";
        }
        length += str2.length();
        AppMethodBeat.m2505o(102459);
        return length;
    }

    /* renamed from: m */
    public static final String m64502m(int i, String str, String str2) {
        AppMethodBeat.m2504i(102460);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        String c = C38122r.m64501c(i, str, str2, "++");
        AppMethodBeat.m2505o(102460);
        return c;
    }

    /* renamed from: bz */
    private static String m64500bz(String str, String str2) {
        AppMethodBeat.m2504i(102461);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "key");
        String c = C38122r.m64501c(0, str, str2, "++");
        AppMethodBeat.m2505o(102461);
        return c;
    }

    /* renamed from: a */
    public static final int[] m64496a(String str, C17126b<? super String, String> c17126b, C31591m<? super String, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(102462);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(c17126b, "getter");
        C25052j.m39376p(c31591m, "setter");
        String bz = C38122r.m64500bz(str, "@@@TOTAL@STORAGE@ID@@@");
        int[] iArr;
        if (C5046bo.isNullOrNil(bz)) {
            iArr = new int[]{0};
            AppMethodBeat.m2505o(102462);
            return iArr;
        }
        bz = (String) c17126b.mo50am(bz);
        if (C5046bo.isNullOrNil(bz)) {
            iArr = new int[]{0};
            AppMethodBeat.m2505o(102462);
            return iArr;
        }
        JSONArray jSONArray = new JSONArray(bz);
        if (jSONArray.length() <= 0) {
            iArr = new int[]{0};
            AppMethodBeat.m2505o(102462);
            return iArr;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        List list = arrayList;
        if (!list.contains(Integer.valueOf(0))) {
            list.add(Integer.valueOf(0));
        }
        iArr = C25035t.m39346h((Collection) list);
        AppMethodBeat.m2505o(102462);
        return iArr;
    }

    /* renamed from: a */
    public static final void m64495a(String str, int i, C17126b<? super String, String> c17126b, C31591m<? super String, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(102463);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(c17126b, "getter");
        C25052j.m39376p(c31591m, "setter");
        int[] a = C38122r.m64496a(str, c17126b, c31591m);
        if (C36913i.contains(a, i)) {
            AppMethodBeat.m2505o(102463);
            return;
        }
        JSONArray jSONArray = new JSONArray(C36646h.m60744I(a));
        jSONArray.put(i);
        String bz = C38122r.m64500bz(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray2 = jSONArray.toString();
        C25052j.m39375o(jSONArray2, "json.toString()");
        c31591m.mo212m(bz, jSONArray2);
        AppMethodBeat.m2505o(102463);
    }

    /* renamed from: b */
    public static final void m64497b(String str, int i, C17126b<? super String, String> c17126b, C31591m<? super String, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(102464);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(c17126b, "getter");
        C25052j.m39376p(c31591m, "setter");
        List L = C36913i.m61679L(C38122r.m64496a(str, c17126b, c31591m));
        L.remove(Integer.valueOf(i));
        String bz = C38122r.m64500bz(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray = new JSONArray(L).toString();
        C25052j.m39375o(jSONArray, "JSONArray(list).toString()");
        c31591m.mo212m(bz, jSONArray);
        AppMethodBeat.m2505o(102464);
    }

    /* renamed from: b */
    public static final void m64498b(String str, C17126b<? super String, String> c17126b, C31591m<? super String, ? super String, C37091y> c31591m) {
        AppMethodBeat.m2504i(102465);
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(c17126b, "getter");
        C25052j.m39376p(c31591m, "setter");
        c31591m.mo212m(C38122r.m64500bz(str, "@@@TOTAL@STORAGE@ID@@@"), "");
        AppMethodBeat.m2505o(102465);
    }

    /* renamed from: I */
    public static final int m64494I(int i, String str) {
        AppMethodBeat.m2504i(102466);
        C25052j.m39376p(str, "appId");
        int i2;
        if (C25052j.m39373j("wxGlobal", str)) {
            i2 = AppBrandGlobalSystemConfig.ayC().hfN;
            AppMethodBeat.m2505o(102466);
            return i2;
        } else if (i == 0) {
            i2 = C2117i.m4328yZ(str);
            AppMethodBeat.m2505o(102466);
            return i2;
        } else {
            i2 = C2117i.m4329za(str);
            AppMethodBeat.m2505o(102466);
            return i2;
        }
    }
}
