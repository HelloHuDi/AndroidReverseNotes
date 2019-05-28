package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class a extends r {
    private final a vaQ;
    private final Intent vaR;
    private final w vaS = new w();

    public enum a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int code;

        static {
            AppMethodBeat.o(125812);
        }

        private a(int i) {
            this.code = i;
        }

        public final String getPackage() {
            AppMethodBeat.i(125811);
            String str;
            switch (this) {
                case TencentMap:
                    str = "com.tencent.map";
                    AppMethodBeat.o(125811);
                    return str;
                case GoogleMap:
                    str = "com.google.android.apps.maps";
                    AppMethodBeat.o(125811);
                    return str;
                case SogouMap:
                    str = "com.sogou.map.android.maps";
                    AppMethodBeat.o(125811);
                    return str;
                case BaiduMap:
                    str = "com.baidu.BaiduMap";
                    AppMethodBeat.o(125811);
                    return str;
                case AutonaviMap:
                    str = "com.autonavi.minimap";
                    AppMethodBeat.o(125811);
                    return str;
                default:
                    str = "com.tencent.map";
                    AppMethodBeat.o(125811);
                    return str;
            }
        }

        public static a Ko(int i) {
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

    public a(Bundle bundle) {
        AppMethodBeat.i(125813);
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.vaQ = a.TencentMap;
        } else {
            a Ko = a.Ko(bundle.getInt("key_map_app", a.TencentMap.code));
            if (a(ah.getContext(), Ko, null) == null) {
                this.vaQ = a.TencentMap;
            } else {
                this.vaQ = Ko;
            }
        }
        if (this.vaQ == a.TencentMap) {
            this.vaR = null;
            AppMethodBeat.o(125813);
            return;
        }
        this.vaR = (Intent) bundle.getParcelable("key_target_intent");
        AppMethodBeat.o(125813);
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        AppMethodBeat.i(125814);
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (bo.ek(queryIntentActivities)) {
            AppMethodBeat.o(125814);
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                AppMethodBeat.o(125814);
                return resolveInfo;
            }
        }
        AppMethodBeat.o(125814);
        return null;
    }

    public final boolean fE(Context context) {
        AppMethodBeat.i(125815);
        if (this.vaQ == a.TencentMap) {
            boolean fE = this.vaS.fE(context);
            AppMethodBeat.o(125815);
            return fE;
        } else if (a(context, this.vaQ, this.vaR) != null) {
            AppMethodBeat.o(125815);
            return true;
        } else {
            AppMethodBeat.o(125815);
            return false;
        }
    }

    public final boolean aix(String str) {
        AppMethodBeat.i(125816);
        boolean equals = this.vaQ.getPackage().equals(str);
        AppMethodBeat.o(125816);
        return equals;
    }

    public final String anK() {
        if (this.vaQ == a.TencentMap) {
            return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
        }
        return null;
    }

    public final String dgX() {
        if (this.vaQ == a.TencentMap) {
            return "TencentMap.apk";
        }
        return null;
    }

    public final com.tencent.mm.pluginsdk.model.s.a dgY() {
        AppMethodBeat.i(125817);
        com.tencent.mm.pluginsdk.model.s.a dgY;
        if (this.vaQ == a.TencentMap) {
            dgY = this.vaS.dgY();
            AppMethodBeat.o(125817);
            return dgY;
        }
        dgY = new com.tencent.mm.pluginsdk.model.s.a();
        dgY.vbF = -1;
        dgY.vbC = -1;
        ResolveInfo a = a(ah.getContext(), this.vaQ, this.vaR);
        if (a != null) {
            dgY.vbG = a(ah.getContext(), a);
        }
        AppMethodBeat.o(125817);
        return dgY;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(125818);
        String a = this.vaS.a(context, resolveInfo);
        AppMethodBeat.o(125818);
        return a;
    }
}
