package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.pluginsdk.model.C14868a.C14869a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.AppChooserUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j */
public final class C23130j implements C5186a {
    WeakReference<Context> aIq;
    C26443d fwu = null;
    C18657c nOO = null;
    boolean uIK = false;
    int uIL;
    C23136e uIM;
    C23136e uIN;
    String uIO;
    C23135d uIP;
    C18660a uIQ = null;
    C18660a uIR = null;
    C42206a uIS = null;
    final Runnable uIT = new C231321();
    int unO;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$f */
    static abstract class C14660f {
        public abstract String getPackageName();

        private C14660f() {
        }

        /* synthetic */ C14660f(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + c23136e2.latitude + "," + c23136e2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$2 */
    class C231252 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$2$1 */
        class C146591 implements C18660a {
            C146591() {
            }

            /* renamed from: b */
            public final void mo8746b(Addr addr) {
                AppMethodBeat.m2504i(9822);
                if (!(C23130j.this.uIM == null || C23130j.this.uIQ == null)) {
                    C23130j.this.uIM.uIW = addr.agv();
                    C23130j.this.dcP();
                }
                AppMethodBeat.m2505o(9822);
            }
        }

        C231252() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(9823);
            if (C23130j.this.fwu != null) {
                C23130j.this.fwu.mo44208c(this);
            }
            if (z) {
                C23130j.this.uIM = new C23136e((double) f2, (double) f, (byte) 0);
                if (C23130j.this.nOO != null) {
                    C23130j.this.uIQ = new C146591();
                    C23130j.this.nOO.mo33923a((double) f2, (double) f, C23130j.this.uIQ);
                    AppMethodBeat.m2505o(9823);
                    return false;
                }
            }
            C23130j.this.dcP();
            AppMethodBeat.m2505o(9823);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$3 */
    class C231263 implements C18660a {
        C231263() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(9824);
            if (!(C23130j.this.uIN == null || C23130j.this.uIR == null)) {
                C23130j.this.uIN.uIW = addr.agv();
            }
            AppMethodBeat.m2505o(9824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$4 */
    class C231274 implements Runnable {
        C231274() {
        }

        public final void run() {
            AppMethodBeat.m2504i(9825);
            if (!(C23130j.this.aIq == null || C23130j.this.aIq.get() == null)) {
                Toast.makeText((Context) C23130j.this.aIq.get(), C25738R.string.g2x, 0).show();
            }
            AppMethodBeat.m2505o(9825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$a */
    static final class C23128a extends C14660f {
        private C23128a() {
            super();
        }

        /* synthetic */ C23128a(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            AppMethodBeat.m2504i(9826);
            if (context == null) {
                super.mo26906a(context, c23136e, c23136e2, str);
                AppMethodBeat.m2505o(9826);
                return;
            }
            Object format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(c23136e2.latitude), Double.valueOf(c23136e2.longitude)});
            if (c23136e != null) {
                format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(c23136e.latitude), Double.valueOf(c23136e.longitude)});
            }
            C4990ab.m7410d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(format)));
            try {
                context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
                AppMethodBeat.m2505o(9826);
            } catch (URISyntaxException e) {
                C4990ab.printErrStackTrace("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
                AppMethodBeat.m2505o(9826);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.m2504i(9827);
            String str = C14869a.BaiduMap.getPackage();
            AppMethodBeat.m2505o(9827);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$h */
    static final class C23129h extends C14660f {
        private C23129h() {
            super();
        }

        /* synthetic */ C23129h(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            AppMethodBeat.m2504i(9834);
            if (context == null) {
                super.mo26906a(context, c23136e, c23136e2, str);
                AppMethodBeat.m2505o(9834);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(c23136e2.longitude), Double.valueOf(c23136e2.latitude)});
            if (c23136e != null) {
                format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(c23136e.longitude), Double.valueOf(c23136e.latitude)});
                if (!C5046bo.isNullOrNil(c23136e.uIW)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(c23136e.uIW)});
                }
            }
            if (C5046bo.isNullOrNil(str)) {
                if (C5046bo.isNullOrNil(c23136e2.uIW)) {
                    str = "地图选点";
                } else {
                    str = c23136e2.uIW;
                }
            }
            format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
            intent.setPackage(C14869a.TencentMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.m2505o(9834);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.m2504i(138979);
            String str = C14869a.TencentMap.getPackage();
            AppMethodBeat.m2505o(138979);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$g */
    static final class C23131g extends C14660f {
        private C23131g() {
            super();
        }

        /* synthetic */ C23131g(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            AppMethodBeat.m2504i(9832);
            if (context == null) {
                super.mo26906a(context, c23136e, c23136e2, str);
                AppMethodBeat.m2505o(9832);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(c23136e2.latitude), Double.valueOf(c23136e2.longitude)});
            if (c23136e != null) {
                format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(c23136e.latitude), Double.valueOf(c23136e.longitude)});
                if (!C5046bo.isNullOrNil(c23136e.uIW)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(c23136e.uIW)});
                }
            } else {
                format = format + String.format("&from=%s", new Object[]{"我的位置"});
            }
            if (C5046bo.isNullOrNil(str)) {
                if (C5046bo.isNullOrNil(c23136e2.uIW)) {
                    str = "目的地";
                } else {
                    str = c23136e2.uIW;
                }
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
            intent.setPackage(C14869a.SogouMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.m2505o(9832);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.m2504i(138978);
            String str = C14869a.SogouMap.getPackage();
            AppMethodBeat.m2505o(138978);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$1 */
    class C231321 implements Runnable {
        C231321() {
        }

        public final void run() {
            AppMethodBeat.m2504i(9821);
            if (C23130j.this.uIS == null || C23130j.this.fwu == null) {
                AppMethodBeat.m2505o(9821);
                return;
            }
            C23130j.this.nOO.mo33925a(C23130j.this.uIQ);
            C23130j.this.fwu.mo44208c(C23130j.this.uIS);
            C23130j.this.uIS.mo5861a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
            AppMethodBeat.m2505o(9821);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$b */
    static final class C23133b extends C14660f {
        private C23133b() {
            super();
        }

        /* synthetic */ C23133b(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            AppMethodBeat.m2504i(9828);
            if (context == null) {
                super.mo26906a(context, c23136e, c23136e2, str);
                AppMethodBeat.m2505o(9828);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(c23136e2.latitude), Double.valueOf(c23136e2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(C14869a.AutonaviMap.getPackage());
            context.startActivity(intent);
            AppMethodBeat.m2505o(9828);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.m2504i(138977);
            String str = C14869a.AutonaviMap.getPackage();
            AppMethodBeat.m2505o(138977);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$c */
    static final class C23134c extends C14660f {
        private C23134c() {
            super();
        }

        /* synthetic */ C23134c(byte b) {
            this();
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final void mo26906a(Context context, C23136e c23136e, C23136e c23136e2, String str) {
            AppMethodBeat.m2504i(9830);
            if (context == null) {
                super.mo26906a(context, c23136e, c23136e2, str);
                AppMethodBeat.m2505o(9830);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(c23136e2.latitude), Double.valueOf(c23136e2.longitude)});
            if (c23136e != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(c23136e.latitude), Double.valueOf(c23136e.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
            AppMethodBeat.m2505o(9830);
        }

        /* Access modifiers changed, original: protected|final */
        public final String getPackageName() {
            AppMethodBeat.m2504i(9831);
            String str = C14869a.GoogleMap.getPackage();
            AppMethodBeat.m2505o(9831);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$d */
    interface C23135d {
        /* renamed from: JP */
        void mo38719JP(int i);

        /* renamed from: JQ */
        void mo38720JQ(int i);

        void onFail(int i);

        void onSuccess(int i);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.j$e */
    static final class C23136e {
        double latitude;
        double longitude;
        String uIW;

        /* synthetic */ C23136e(double d, double d2, byte b) {
            this(d, d2);
        }

        private C23136e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.uIW = null;
        }
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(9836);
        Context context = (Context) this.aIq.get();
        if (!(this.uIP == null || context == null)) {
            if (!this.uIK) {
                C4990ab.m7412e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                C4990ab.m7413e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", Integer.valueOf(i));
                this.uIP.onFail(this.unO);
            } else if (i2 == 4097 || i2 == 0) {
                this.uIP.mo38719JP(this.unO);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    C4990ab.m7412e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.uIP.onFail(this.unO);
                } else {
                    C14660f c23134c;
                    if (C14869a.GoogleMap.getPackage().equals(stringExtra)) {
                        c23134c = new C23134c();
                    } else if (C14869a.BaiduMap.getPackage().equals(stringExtra)) {
                        c23134c = new C23128a();
                    } else if (C14869a.SogouMap.getPackage().equals(stringExtra)) {
                        c23134c = new C23131g();
                    } else if (C14869a.AutonaviMap.getPackage().equals(stringExtra)) {
                        c23134c = new C23133b();
                    } else {
                        c23134c = new C23129h();
                    }
                    c23134c.mo26906a(context, this.uIM, this.uIN, this.uIO);
                    this.uIP.onSuccess(this.unO);
                }
            } else {
                C4990ab.m7413e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", Integer.valueOf(i2));
                this.uIP.onFail(this.unO);
            }
        }
        if (this.uIK && this.uIP != null) {
            this.uIP.mo38720JQ(this.unO);
        }
        this.uIK = false;
        this.uIL = C14869a.TencentMap.code;
        this.uIM = null;
        this.uIN = null;
        this.aIq = null;
        this.uIP = null;
        this.uIO = null;
        this.uIQ = null;
        this.uIR = null;
        if (!(this.fwu == null || this.uIS == null)) {
            this.fwu.mo44208c(this.uIS);
        }
        this.fwu = null;
        this.uIS = null;
        if (this.nOO != null) {
            if (this.uIQ != null) {
                this.nOO.mo33925a(this.uIQ);
            }
            if (this.uIR != null) {
                this.nOO.mo33925a(this.uIR);
            }
        }
        this.nOO = null;
        this.uIQ = null;
        this.uIR = null;
        AppMethodBeat.m2505o(9836);
    }

    C23130j() {
        AppMethodBeat.m2504i(9837);
        AppMethodBeat.m2505o(9837);
    }

    /* Access modifiers changed, original: final */
    public final void dcP() {
        Context context = null;
        AppMethodBeat.m2504i(9838);
        this.uIS = null;
        this.uIQ = null;
        this.uIR = null;
        if (this.aIq != null) {
            context = (Context) this.aIq.get();
        }
        if (context == null) {
            AppMethodBeat.m2505o(9838);
            return;
        }
        Intent intent = new Intent(context, AppChooserUI.class);
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(C14869a.TencentMap.getPackage());
        arrayList.add(C14869a.GoogleMap.getPackage());
        arrayList.add(C14869a.SogouMap.getPackage());
        arrayList.add(C14869a.BaiduMap.getPackage());
        arrayList.add(C14869a.AutonaviMap.getPackage());
        intent.putStringArrayListExtra("targetwhitelist", arrayList);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.uIN.latitude), Double.valueOf(this.uIN.longitude)})));
        intent.putExtra("targetintent", intent2);
        Bundle bundle = new Bundle(2);
        bundle.putInt("key_map_app", this.uIL);
        bundle.putParcelable("key_target_intent", intent2);
        intent.putExtra("key_recommend_params", bundle);
        intent.putExtra("type", 2);
        intent.putExtra("title", context.getString(C25738R.string.g2m));
        ((MMActivity) context).mo17391b((C5186a) this, intent, 33);
        AppMethodBeat.m2505o(9838);
    }
}
