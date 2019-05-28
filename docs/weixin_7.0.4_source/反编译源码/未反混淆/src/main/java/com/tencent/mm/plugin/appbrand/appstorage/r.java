package com.tencent.mm.plugin.appbrand.appstorage;

import a.a.h;
import a.a.i;
import a.a.t;
import a.f.a.b;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JF\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J>\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
public final class r {
    public static final Object[] gYb = new Object[]{a.NO_SUCH_KEY};
    public static final r gYc = new r();

    static {
        AppMethodBeat.i(102467);
        AppMethodBeat.o(102467);
    }

    private r() {
    }

    public static final boolean nw(int i) {
        if (i >= 0 && i <= 1) {
            return false;
        }
        return true;
    }

    public static final String c(int i, String str, String str2, String str3) {
        AppMethodBeat.i(102458);
        j.p(str, "appId");
        j.p(str2, "key");
        j.p(str3, "separator");
        StringBuilder stringBuilder = new StringBuilder();
        if (i > 0) {
            stringBuilder.append(i).append(str3);
        }
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "sb.toString()");
        AppMethodBeat.o(102458);
        return stringBuilder2;
    }

    public static final int by(String str, String str2) {
        AppMethodBeat.i(102459);
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (str2 == null) {
            str2 = "";
        }
        length += str2.length();
        AppMethodBeat.o(102459);
        return length;
    }

    public static final String m(int i, String str, String str2) {
        AppMethodBeat.i(102460);
        j.p(str, "appId");
        j.p(str2, "key");
        String c = c(i, str, str2, "++");
        AppMethodBeat.o(102460);
        return c;
    }

    private static String bz(String str, String str2) {
        AppMethodBeat.i(102461);
        j.p(str, "appId");
        j.p(str2, "key");
        String c = c(0, str, str2, "++");
        AppMethodBeat.o(102461);
        return c;
    }

    public static final int[] a(String str, b<? super String, String> bVar, m<? super String, ? super String, y> mVar) {
        AppMethodBeat.i(102462);
        j.p(str, "appId");
        j.p(bVar, "getter");
        j.p(mVar, "setter");
        String bz = bz(str, "@@@TOTAL@STORAGE@ID@@@");
        int[] iArr;
        if (bo.isNullOrNil(bz)) {
            iArr = new int[]{0};
            AppMethodBeat.o(102462);
            return iArr;
        }
        bz = (String) bVar.am(bz);
        if (bo.isNullOrNil(bz)) {
            iArr = new int[]{0};
            AppMethodBeat.o(102462);
            return iArr;
        }
        JSONArray jSONArray = new JSONArray(bz);
        if (jSONArray.length() <= 0) {
            iArr = new int[]{0};
            AppMethodBeat.o(102462);
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
        iArr = t.h((Collection) list);
        AppMethodBeat.o(102462);
        return iArr;
    }

    public static final void a(String str, int i, b<? super String, String> bVar, m<? super String, ? super String, y> mVar) {
        AppMethodBeat.i(102463);
        j.p(str, "appId");
        j.p(bVar, "getter");
        j.p(mVar, "setter");
        int[] a = a(str, bVar, mVar);
        if (i.contains(a, i)) {
            AppMethodBeat.o(102463);
            return;
        }
        JSONArray jSONArray = new JSONArray(h.I(a));
        jSONArray.put(i);
        String bz = bz(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray2 = jSONArray.toString();
        j.o(jSONArray2, "json.toString()");
        mVar.m(bz, jSONArray2);
        AppMethodBeat.o(102463);
    }

    public static final void b(String str, int i, b<? super String, String> bVar, m<? super String, ? super String, y> mVar) {
        AppMethodBeat.i(102464);
        j.p(str, "appId");
        j.p(bVar, "getter");
        j.p(mVar, "setter");
        List L = i.L(a(str, bVar, mVar));
        L.remove(Integer.valueOf(i));
        String bz = bz(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray = new JSONArray(L).toString();
        j.o(jSONArray, "JSONArray(list).toString()");
        mVar.m(bz, jSONArray);
        AppMethodBeat.o(102464);
    }

    public static final void b(String str, b<? super String, String> bVar, m<? super String, ? super String, y> mVar) {
        AppMethodBeat.i(102465);
        j.p(str, "appId");
        j.p(bVar, "getter");
        j.p(mVar, "setter");
        mVar.m(bz(str, "@@@TOTAL@STORAGE@ID@@@"), "");
        AppMethodBeat.o(102465);
    }

    public static final int I(int i, String str) {
        AppMethodBeat.i(102466);
        j.p(str, "appId");
        int i2;
        if (j.j("wxGlobal", str)) {
            i2 = AppBrandGlobalSystemConfig.ayC().hfN;
            AppMethodBeat.o(102466);
            return i2;
        } else if (i == 0) {
            i2 = com.tencent.mm.plugin.appbrand.config.i.yZ(str);
            AppMethodBeat.o(102466);
            return i2;
        } else {
            i2 = com.tencent.mm.plugin.appbrand.config.i.za(str);
            AppMethodBeat.o(102466);
            return i2;
        }
    }
}
