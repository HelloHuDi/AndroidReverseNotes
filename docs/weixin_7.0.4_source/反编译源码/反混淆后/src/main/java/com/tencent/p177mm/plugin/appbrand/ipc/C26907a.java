package com.tencent.p177mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.a */
public final class C26907a {
    private static final Map<String, Class<? extends AppBrandTaskProxyUI>> huD;

    /* renamed from: a */
    public static void m42842a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
        AppMethodBeat.m2504i(73119);
        AppBrandProcessProxyUI.m64715a(context, AppBrandProcessProxyUI.class, str, str2, str3, str4, onClickListener, onClickListener2, onClickListener3);
        AppMethodBeat.m2505o(73119);
    }

    /* renamed from: a */
    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void m42840a(Context context, _Req _req, C19247b<_Result> c19247b) {
        AppMethodBeat.m2504i(73120);
        C26907a.m42841a(context, _req, c19247b, null);
        AppMethodBeat.m2505o(73120);
    }

    /* renamed from: a */
    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void m42841a(Context context, _Req _req, C19247b<_Result> c19247b, Intent intent) {
        AppMethodBeat.m2504i(73121);
        AppBrandProcessProxyUI.m64714a(context, AppBrandProcessProxyUI.class, _req, c19247b, intent);
        AppMethodBeat.m2505o(73121);
    }

    static {
        AppMethodBeat.m2504i(73123);
        HashMap hashMap = new HashMap();
        hashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
        hashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
        hashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
        hashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
        hashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
        hashMap.put(":toolsmp", AppBrandTaskInToolsProxyUI.class);
        huD = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.m2505o(73123);
    }

    /* renamed from: b */
    public static <_Req extends ProcessRequest, _Result extends ProcessResult> void m42843b(Context context, _Req _req, C19247b<_Result> c19247b) {
        AppMethodBeat.m2504i(73122);
        Class cls = (Class) huD.get(C4996ah.getProcessName().replaceFirst(C4996ah.getPackageName(), ""));
        Class cls2 = AppBrandProcessProxyUI.class;
        if (cls == null) {
            cls = cls2;
        }
        AppBrandProcessProxyUI.m64714a(context, cls, _req, c19247b, null);
        AppMethodBeat.m2505o(73122);
    }
}
