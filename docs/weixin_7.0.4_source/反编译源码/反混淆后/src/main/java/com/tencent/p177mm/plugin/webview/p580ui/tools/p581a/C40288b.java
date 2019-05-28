package com.tencent.p177mm.plugin.webview.p580ui.tools.p581a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26119ec;
import com.tencent.p177mm.p230g.p231a.C26124el;
import com.tencent.p177mm.p230g.p231a.C32540ea;
import com.tencent.p177mm.p230g.p231a.C32541eb;
import com.tencent.p177mm.p230g.p231a.C32596lq;
import com.tencent.p177mm.p230g.p231a.C6475dz;
import com.tencent.p177mm.p230g.p231a.C9329ef;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t.C23347a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b */
public final class C40288b implements C23347a {
    private static final byte[] ltL = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static C40288b uAk;
    public String cwz;
    public boolean hasInit = false;
    public byte[] uAa = null;
    public boolean uAc = false;
    public C4584a uAj;
    public int uAl = -1;
    public boolean uAm = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a */
    public static class C4584a {
        private String cwz = "";
        public C4884c qwh = new C45855();
        public C4884c uAd = new C45893();
        public C4884c uAn = new C45861();
        public C4884c uAo = new C45872();
        public C4884c uAp = new C45884();
        private C40281e umI = null;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a$5 */
        class C45855 extends C4884c<C6475dz> {
            C45855() {
                AppMethodBeat.m2504i(8325);
                this.xxI = C6475dz.class.getName().hashCode();
                AppMethodBeat.m2505o(8325);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8326);
                boolean h = C4584a.this.mo9674h((C6475dz) c4883b);
                AppMethodBeat.m2505o(8326);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a$1 */
        class C45861 extends C4884c<C26119ec> {
            C45861() {
                AppMethodBeat.m2504i(8317);
                this.xxI = C26119ec.class.getName().hashCode();
                AppMethodBeat.m2505o(8317);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8318);
                boolean h = C4584a.this.mo9674h((C26119ec) c4883b);
                AppMethodBeat.m2505o(8318);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a$2 */
        class C45872 extends C4884c<C32541eb> {
            C45872() {
                AppMethodBeat.m2504i(8319);
                this.xxI = C32541eb.class.getName().hashCode();
                AppMethodBeat.m2505o(8319);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8320);
                boolean h = C4584a.this.mo9674h((C32541eb) c4883b);
                AppMethodBeat.m2505o(8320);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a$4 */
        class C45884 extends C4884c<C32596lq> {
            C45884() {
                AppMethodBeat.m2504i(8323);
                this.xxI = C32596lq.class.getName().hashCode();
                AppMethodBeat.m2505o(8323);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8324);
                boolean h = C4584a.this.mo9674h((C32596lq) c4883b);
                AppMethodBeat.m2505o(8324);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.b$a$3 */
        class C45893 extends C4884c<C32540ea> {
            C45893() {
                AppMethodBeat.m2504i(8321);
                this.xxI = C32540ea.class.getName().hashCode();
                AppMethodBeat.m2505o(8321);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8322);
                boolean h = C4584a.this.mo9674h((C32540ea) c4883b);
                AppMethodBeat.m2505o(8322);
                return h;
            }
        }

        public C4584a(C40281e c40281e, String str) {
            AppMethodBeat.m2504i(8327);
            this.umI = c40281e;
            this.cwz = str;
            AppMethodBeat.m2505o(8327);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: h */
        public final boolean mo9674h(C4883b c4883b) {
            AppMethodBeat.m2504i(8328);
            if (c4883b == null) {
                AppMethodBeat.m2505o(8328);
                return false;
            } else if (this.umI == null) {
                C4990ab.m7412e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                AppMethodBeat.m2505o(8328);
                return false;
            } else {
                try {
                    Bundle bundle;
                    if (c4883b instanceof C26119ec) {
                        C4990ab.m7416i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                        C26119ec c26119ec = (C26119ec) c4883b;
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", c26119ec.cxD.ceI);
                        bundle.putByteArray("exdevice_broadcast_data", c26119ec.cxD.cxv);
                        bundle.putBoolean("exdevice_is_complete", c26119ec.cxD.bcU);
                        this.umI.mo26784c(15, bundle);
                    } else if (c4883b instanceof C32541eb) {
                        C4990ab.m7416i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                        C32541eb c32541eb = (C32541eb) c4883b;
                        if (C5046bo.isNullOrNil(c32541eb.cxC.ceI) || C5046bo.isNullOrNil(c32541eb.cxC.cwz) || c32541eb.cxC.data == null) {
                            AppMethodBeat.m2505o(8328);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", c32541eb.cxC.ceI);
                        bundle.putByteArray("exdevice_data", c32541eb.cxC.data);
                        bundle.putString("exdevice_brand_name", c32541eb.cxC.cwz);
                        this.umI.mo26784c(16, bundle);
                    } else if (c4883b instanceof C32540ea) {
                        C4990ab.m7410d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        C32540ea c32540ea = (C32540ea) c4883b;
                        if (C5046bo.isNullOrNil(c32540ea.cxB.ceI)) {
                            AppMethodBeat.m2505o(8328);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", c32540ea.cxB.ceI);
                        bundle.putBoolean("exdevice_is_bound", c32540ea.cxB.cww);
                        this.umI.mo26784c(17, bundle);
                    } else if (c4883b instanceof C32596lq) {
                        C32596lq c32596lq = (C32596lq) c4883b;
                        if (c32596lq.cHu.f15019op != 2) {
                            AppMethodBeat.m2505o(8328);
                            return true;
                        } else if (C5046bo.isNullOrNil(c32596lq.cHu.cEN) || !this.cwz.equals(c32596lq.cHu.cEN)) {
                            AppMethodBeat.m2505o(8328);
                            return true;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", c32596lq.cHu.ceI);
                            bundle.putInt("exdevice_on_state_change_state", c32596lq.cHu.cxs);
                            this.umI.mo26784c(1004, bundle);
                        }
                    } else if (c4883b instanceof C6475dz) {
                        C6475dz c6475dz = (C6475dz) c4883b;
                        bundle = new Bundle();
                        if (c6475dz.cxz.cxA == 12) {
                            bundle.putBoolean("exdevice_bt_state", true);
                        } else {
                            bundle.putBoolean("exdevice_bt_state", false);
                        }
                        this.umI.mo26784c(18, bundle);
                    }
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
                }
                AppMethodBeat.m2505o(8328);
                return true;
            }
        }
    }

    private C40288b() {
    }

    public static C40288b dbr() {
        AppMethodBeat.m2504i(8329);
        if (uAk == null) {
            uAk = new C40288b();
        }
        C40288b c40288b = uAk;
        AppMethodBeat.m2505o(8329);
        return c40288b;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void dbp() {
        AppMethodBeat.m2504i(8330);
        C4990ab.m7417i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.uAc));
        if (this.uAc) {
            C9329ef c9329ef = new C9329ef();
            c9329ef.cxG.cwA = false;
            c9329ef.cxG.cwz = this.cwz;
            C4879a.xxA.mo10055m(c9329ef);
            if (!c9329ef.cxH.cwB) {
                C4990ab.m7412e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.uAc = false;
        }
        this.hasInit = false;
        if (this.uAj != null) {
            C4879a.xxA.mo10053d(this.uAj.uAn);
            C4879a.xxA.mo10053d(this.uAj.uAo);
            C4879a.xxA.mo10053d(this.uAj.uAp);
            C4879a.xxA.mo10053d(this.uAj.uAd);
            C4879a.xxA.mo10053d(this.uAj.qwh);
            this.uAj = null;
        }
        this.uAa = null;
        C26124el c26124el = new C26124el();
        c26124el.cxX.ceI = "";
        c26124el.cxX.direction = 0;
        c26124el.cxX.clear = true;
        C4879a.xxA.mo10055m(c26124el);
        C4990ab.m7417i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", Boolean.valueOf(c26124el.cxY.cwB));
        AppMethodBeat.m2505o(8330);
    }

    /* renamed from: bE */
    public static boolean m69084bE(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    /* renamed from: ft */
    public final void mo27351ft(Context context) {
    }

    public final void dbq() {
    }
}
