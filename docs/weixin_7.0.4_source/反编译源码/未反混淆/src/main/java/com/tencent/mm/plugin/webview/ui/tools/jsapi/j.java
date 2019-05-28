package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class j implements com.tencent.mm.ui.MMActivity.a {
    WeakReference<Context> aIq;
    com.tencent.mm.modelgeo.d fwu = null;
    com.tencent.mm.modelgeo.c nOO = null;
    boolean uIK = false;
    int uIL;
    e uIM;
    e uIN;
    String uIO;
    d uIP;
    com.tencent.mm.modelgeo.c.a uIQ = null;
    com.tencent.mm.modelgeo.c.a uIR = null;
    com.tencent.mm.modelgeo.b.a uIS = null;
    final Runnable uIT = new Runnable() {
        public final void run() {
            AppMethodBeat.i(9821);
            if (j.this.uIS == null || j.this.fwu == null) {
                AppMethodBeat.o(9821);
                return;
            }
            j.this.nOO.a(j.this.uIQ);
            j.this.fwu.c(j.this.uIS);
            j.this.uIS.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
            AppMethodBeat.o(9821);
        }
    };
    int unO;

    static abstract class f {
        public abstract String getPackageName();

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public void a(Context context, e eVar, e eVar2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    static final class a extends f {
        private a() {
            super();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(9826);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(9826);
                return;
            }
            Object format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            ab.d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(format)));
            try {
                context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
                AppMethodBeat.o(9826);
            } catch (URISyntaxException e) {
                ab.printErrStackTrace("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
                AppMethodBeat.o(9826);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.i(9827);
            String str = com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage();
            AppMethodBeat.o(9827);
            return str;
        }
    }

    static final class h extends f {
        private h() {
            super();
        }

        /* synthetic */ h(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(9834);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(9834);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude)});
            if (eVar != null) {
                format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude)});
                if (!bo.isNullOrNil(eVar.uIW)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.uIW)});
                }
            }
            if (bo.isNullOrNil(str)) {
                if (bo.isNullOrNil(eVar2.uIW)) {
                    str = "地图选点";
                } else {
                    str = eVar2.uIW;
                }
            }
            format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.o(9834);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.i(138979);
            String str = com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage();
            AppMethodBeat.o(138979);
            return str;
        }
    }

    static final class g extends f {
        private g() {
            super();
        }

        /* synthetic */ g(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(9832);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(9832);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
                if (!bo.isNullOrNil(eVar.uIW)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.uIW)});
                }
            } else {
                format = format + String.format("&from=%s", new Object[]{"我的位置"});
            }
            if (bo.isNullOrNil(str)) {
                if (bo.isNullOrNil(eVar2.uIW)) {
                    str = "目的地";
                } else {
                    str = eVar2.uIW;
                }
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.o(9832);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.i(138978);
            String str = com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage();
            AppMethodBeat.o(138978);
            return str;
        }
    }

    static final class b extends f {
        private b() {
            super();
        }

        /* synthetic */ b(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(9828);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(9828);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.o(9828);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.i(138977);
            String str = com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage();
            AppMethodBeat.o(138977);
            return str;
        }
    }

    static final class c extends f {
        private c() {
            super();
        }

        /* synthetic */ c(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(Context context, e eVar, e eVar2, String str) {
            AppMethodBeat.i(9830);
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                AppMethodBeat.o(9830);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
            AppMethodBeat.o(9830);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.i(9831);
            String str = com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage();
            AppMethodBeat.o(9831);
            return str;
        }
    }

    interface d {
        void JP(int i);

        void JQ(int i);

        void onFail(int i);

        void onSuccess(int i);
    }

    static final class e {
        double latitude;
        double longitude;
        String uIW;

        /* synthetic */ e(double d, double d2, byte b) {
            this(d, d2);
        }

        private e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.uIW = null;
        }
    }

    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(9836);
        Context context = (Context) this.aIq.get();
        if (!(this.uIP == null || context == null)) {
            if (!this.uIK) {
                ab.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", Integer.valueOf(i));
                this.uIP.onFail(this.unO);
            } else if (i2 == 4097 || i2 == 0) {
                this.uIP.JP(this.unO);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (bo.isNullOrNil(stringExtra)) {
                    ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.uIP.onFail(this.unO);
                } else {
                    f cVar;
                    if (com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage().equals(stringExtra)) {
                        cVar = new c();
                    } else if (com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage().equals(stringExtra)) {
                        cVar = new a();
                    } else if (com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage().equals(stringExtra)) {
                        cVar = new g();
                    } else if (com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage().equals(stringExtra)) {
                        cVar = new b();
                    } else {
                        cVar = new h();
                    }
                    cVar.a(context, this.uIM, this.uIN, this.uIO);
                    this.uIP.onSuccess(this.unO);
                }
            } else {
                ab.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", Integer.valueOf(i2));
                this.uIP.onFail(this.unO);
            }
        }
        if (this.uIK && this.uIP != null) {
            this.uIP.JQ(this.unO);
        }
        this.uIK = false;
        this.uIL = com.tencent.mm.pluginsdk.model.a.a.TencentMap.code;
        this.uIM = null;
        this.uIN = null;
        this.aIq = null;
        this.uIP = null;
        this.uIO = null;
        this.uIQ = null;
        this.uIR = null;
        if (!(this.fwu == null || this.uIS == null)) {
            this.fwu.c(this.uIS);
        }
        this.fwu = null;
        this.uIS = null;
        if (this.nOO != null) {
            if (this.uIQ != null) {
                this.nOO.a(this.uIQ);
            }
            if (this.uIR != null) {
                this.nOO.a(this.uIR);
            }
        }
        this.nOO = null;
        this.uIQ = null;
        this.uIR = null;
        AppMethodBeat.o(9836);
    }

    j() {
        AppMethodBeat.i(9837);
        AppMethodBeat.o(9837);
    }

    /* Access modifiers changed, original: final */
    public final void dcP() {
        Context context = null;
        AppMethodBeat.i(9838);
        this.uIS = null;
        this.uIQ = null;
        this.uIR = null;
        if (this.aIq != null) {
            context = (Context) this.aIq.get();
        }
        if (context == null) {
            AppMethodBeat.o(9838);
            return;
        }
        Intent intent = new Intent(context, AppChooserUI.class);
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage());
        arrayList.add(com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage());
        arrayList.add(com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage());
        arrayList.add(com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage());
        arrayList.add(com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage());
        intent.putStringArrayListExtra("targetwhitelist", arrayList);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.uIN.latitude), Double.valueOf(this.uIN.longitude)})));
        intent.putExtra("targetintent", intent2);
        Bundle bundle = new Bundle(2);
        bundle.putInt("key_map_app", this.uIL);
        bundle.putParcelable("key_target_intent", intent2);
        intent.putExtra("key_recommend_params", bundle);
        intent.putExtra("type", 2);
        intent.putExtra("title", context.getString(R.string.g2m));
        ((MMActivity) context).b((com.tencent.mm.ui.MMActivity.a) this, intent, 33);
        AppMethodBeat.o(9838);
    }
}
