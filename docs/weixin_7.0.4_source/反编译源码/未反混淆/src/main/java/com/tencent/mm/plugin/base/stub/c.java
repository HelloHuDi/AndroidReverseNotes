package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class c extends a {
    private static final Map<String, Object> jDp;

    static {
        AppMethodBeat.i(18121);
        HashMap hashMap = new HashMap();
        jDp = hashMap;
        hashMap.put("_build_info_sdk_int_", Integer.valueOf(Build.SDK_INT));
        jDp.put("_build_info_sdk_name_", Build.SDK_VERSION_NAME);
        jDp.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
        AppMethodBeat.o(18121);
    }

    public final boolean dt(Context context) {
        AppMethodBeat.i(18119);
        super.dt(context);
        AppMethodBeat.o(18119);
        return true;
    }

    public static Cursor a(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(18120);
        Object obj = strArr2[0];
        Object obj2 = jDp.get(obj);
        if (obj2 == null) {
            ab.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: ".concat(String.valueOf(obj)));
            AppMethodBeat.o(18120);
            return null;
        }
        int i;
        if (obj2 == null) {
            ab.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
            i = 0;
        } else if (obj2 instanceof Integer) {
            i = 1;
        } else if (obj2 instanceof Long) {
            i = 2;
        } else if (obj2 instanceof String) {
            i = 3;
        } else if (obj2 instanceof Boolean) {
            i = 4;
        } else if (obj2 instanceof Float) {
            i = 5;
        } else if (obj2 instanceof Double) {
            i = 6;
        } else {
            ab.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + obj2.getClass().toString());
            i = 0;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = obj;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = obj2 == null ? null : obj2.toString();
        matrixCursor.addRow(objArr);
        AppMethodBeat.o(18120);
        return matrixCursor;
    }
}
