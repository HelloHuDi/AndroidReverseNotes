package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.model.C14893s.C14894a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.a */
public final class C14868a extends C30081r {
    private final C14869a vaQ;
    private final Intent vaR;
    private final C40446w vaS = new C40446w();

    /* renamed from: com.tencent.mm.pluginsdk.model.a$a */
    public enum C14869a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int code;

        static {
            AppMethodBeat.m2505o(125812);
        }

        private C14869a(int i) {
            this.code = i;
        }

        public final String getPackage() {
            AppMethodBeat.m2504i(125811);
            String str;
            switch (this) {
                case TencentMap:
                    str = "com.tencent.map";
                    AppMethodBeat.m2505o(125811);
                    return str;
                case GoogleMap:
                    str = "com.google.android.apps.maps";
                    AppMethodBeat.m2505o(125811);
                    return str;
                case SogouMap:
                    str = "com.sogou.map.android.maps";
                    AppMethodBeat.m2505o(125811);
                    return str;
                case BaiduMap:
                    str = "com.baidu.BaiduMap";
                    AppMethodBeat.m2505o(125811);
                    return str;
                case AutonaviMap:
                    str = "com.autonavi.minimap";
                    AppMethodBeat.m2505o(125811);
                    return str;
                default:
                    str = "com.tencent.map";
                    AppMethodBeat.m2505o(125811);
                    return str;
            }
        }

        /* renamed from: Ko */
        public static C14869a m23133Ko(int i) {
            switch (i) {
                case 0:
                    return TencentMap;
                case 1:
                    return GoogleMap;
                case 2:
                    return SogouMap;
                case 3:
                    return BaiduMap;
                case 4:
                    return AutonaviMap;
                default:
                    return TencentMap;
            }
        }
    }

    public C14868a(Bundle bundle) {
        AppMethodBeat.m2504i(125813);
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.vaQ = C14869a.TencentMap;
        } else {
            C14869a Ko = C14869a.m23133Ko(bundle.getInt("key_map_app", C14869a.TencentMap.code));
            if (C14868a.m23130a(C4996ah.getContext(), Ko, null) == null) {
                this.vaQ = C14869a.TencentMap;
            } else {
                this.vaQ = Ko;
            }
        }
        if (this.vaQ == C14869a.TencentMap) {
            this.vaR = null;
            AppMethodBeat.m2505o(125813);
            return;
        }
        this.vaR = (Intent) bundle.getParcelable("key_target_intent");
        AppMethodBeat.m2505o(125813);
    }

    /* renamed from: a */
    private static ResolveInfo m23130a(Context context, C14869a c14869a, Intent intent) {
        AppMethodBeat.m2504i(125814);
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (C5046bo.m7548ek(queryIntentActivities)) {
            AppMethodBeat.m2505o(125814);
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && c14869a.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                AppMethodBeat.m2505o(125814);
                return resolveInfo;
            }
        }
        AppMethodBeat.m2505o(125814);
        return null;
    }

    /* renamed from: fE */
    public final boolean mo27192fE(Context context) {
        AppMethodBeat.m2504i(125815);
        if (this.vaQ == C14869a.TencentMap) {
            boolean fE = this.vaS.mo27192fE(context);
            AppMethodBeat.m2505o(125815);
            return fE;
        } else if (C14868a.m23130a(context, this.vaQ, this.vaR) != null) {
            AppMethodBeat.m2505o(125815);
            return true;
        } else {
            AppMethodBeat.m2505o(125815);
            return false;
        }
    }

    public final boolean aix(String str) {
        AppMethodBeat.m2504i(125816);
        boolean equals = this.vaQ.getPackage().equals(str);
        AppMethodBeat.m2505o(125816);
        return equals;
    }

    public final String anK() {
        if (this.vaQ == C14869a.TencentMap) {
            return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
        }
        return null;
    }

    public final String dgX() {
        if (this.vaQ == C14869a.TencentMap) {
            return "TencentMap.apk";
        }
        return null;
    }

    public final C14894a dgY() {
        AppMethodBeat.m2504i(125817);
        C14894a dgY;
        if (this.vaQ == C14869a.TencentMap) {
            dgY = this.vaS.dgY();
            AppMethodBeat.m2505o(125817);
            return dgY;
        }
        dgY = new C14894a();
        dgY.vbF = -1;
        dgY.vbC = -1;
        ResolveInfo a = C14868a.m23130a(C4996ah.getContext(), this.vaQ, this.vaR);
        if (a != null) {
            dgY.vbG = mo27187a(C4996ah.getContext(), a);
        }
        AppMethodBeat.m2505o(125817);
        return dgY;
    }

    /* renamed from: a */
    public final String mo27187a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.m2504i(125818);
        String a = this.vaS.mo27187a(context, resolveInfo);
        AppMethodBeat.m2505o(125818);
        return a;
    }
}
