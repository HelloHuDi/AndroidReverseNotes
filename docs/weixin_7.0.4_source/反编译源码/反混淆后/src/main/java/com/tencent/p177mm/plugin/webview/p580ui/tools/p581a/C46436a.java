package com.tencent.p177mm.plugin.webview.p580ui.tools.p581a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18261ev;
import com.tencent.p177mm.p230g.p231a.C32537dv;
import com.tencent.p177mm.p230g.p231a.C32538dw;
import com.tencent.p177mm.p230g.p231a.C32539dx;
import com.tencent.p177mm.p230g.p231a.C32540ea;
import com.tencent.p177mm.p230g.p231a.C32542ee;
import com.tencent.p177mm.p230g.p231a.C37706du;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t.C23347a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a */
public final class C46436a implements C23347a {
    private static String eSg = "lan";
    private static C46436a uzZ;
    public String cwz;
    public boolean hasInit = false;
    public byte[] uAa = null;
    private int uAb = -1;
    public boolean uAc = false;
    public C29872a uzY;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a */
    public static class C29872a {
        private String cwz = "";
        public C4884c uAd = new C298711();
        public C4884c uAe = new C229292();
        public C4884c uAf = new C298753();
        public C4884c uAg = new C298734();
        public C4884c uAh = new C298745();
        private C40281e umI = null;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a$2 */
        class C229292 extends C4884c<C37706du> {
            C229292() {
                AppMethodBeat.m2504i(8305);
                this.xxI = C37706du.class.getName().hashCode();
                AppMethodBeat.m2505o(8305);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8306);
                boolean h = C29872a.this.mo48101h((C37706du) c4883b);
                AppMethodBeat.m2505o(8306);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a$1 */
        class C298711 extends C4884c<C32540ea> {
            C298711() {
                AppMethodBeat.m2504i(8303);
                this.xxI = C32540ea.class.getName().hashCode();
                AppMethodBeat.m2505o(8303);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8304);
                boolean h = C29872a.this.mo48101h((C32540ea) c4883b);
                AppMethodBeat.m2505o(8304);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a$4 */
        class C298734 extends C4884c<C32538dw> {
            C298734() {
                AppMethodBeat.m2504i(8309);
                this.xxI = C32538dw.class.getName().hashCode();
                AppMethodBeat.m2505o(8309);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8310);
                boolean h = C29872a.this.mo48101h((C32538dw) c4883b);
                AppMethodBeat.m2505o(8310);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a$5 */
        class C298745 extends C4884c<C32539dx> {
            C298745() {
                AppMethodBeat.m2504i(8311);
                this.xxI = C32539dx.class.getName().hashCode();
                AppMethodBeat.m2505o(8311);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8312);
                boolean h = C29872a.this.mo48101h((C32539dx) c4883b);
                AppMethodBeat.m2505o(8312);
                return h;
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.a.a$a$3 */
        class C298753 extends C4884c<C32537dv> {
            C298753() {
                AppMethodBeat.m2504i(8307);
                this.xxI = C32537dv.class.getName().hashCode();
                AppMethodBeat.m2505o(8307);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(8308);
                boolean h = C29872a.this.mo48101h((C32537dv) c4883b);
                AppMethodBeat.m2505o(8308);
                return h;
            }
        }

        public C29872a(C40281e c40281e, String str) {
            AppMethodBeat.m2504i(8313);
            this.umI = c40281e;
            this.cwz = str;
            AppMethodBeat.m2505o(8313);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: h */
        public final boolean mo48101h(C4883b c4883b) {
            AppMethodBeat.m2504i(8314);
            if (c4883b == null) {
                AppMethodBeat.m2505o(8314);
                return false;
            } else if (this.umI == null) {
                C4990ab.m7412e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                AppMethodBeat.m2505o(8314);
                return false;
            } else {
                try {
                    Bundle bundle;
                    if (c4883b instanceof C32540ea) {
                        C4990ab.m7410d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                        C32540ea c32540ea = (C32540ea) c4883b;
                        if (C5046bo.isNullOrNil(c32540ea.cxB.ceI)) {
                            AppMethodBeat.m2505o(8314);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", c32540ea.cxB.ceI);
                        bundle.putBoolean("exdevice_is_bound", c32540ea.cxB.cww);
                        this.umI.mo26784c(17, bundle);
                        AppMethodBeat.m2505o(8314);
                        return true;
                    } else if (c4883b instanceof C37706du) {
                        C4990ab.m7410d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                        C37706du c37706du = (C37706du) c4883b;
                        if (C5046bo.isNullOrNil(c37706du.cxr.ceI) || !this.cwz.equals(c37706du.cxr.cwz)) {
                            AppMethodBeat.m2505o(8314);
                            return true;
                        }
                        bundle = new Bundle();
                        bundle.putString("exdevice_device_id", c37706du.cxr.ceI);
                        bundle.putInt("exdevice_on_state_change_state", c37706du.cxr.cxs);
                        bundle.putString("exdevice_device_type", C46436a.eSg);
                        this.umI.mo26784c(1004, bundle);
                        AppMethodBeat.m2505o(8314);
                        return true;
                    } else {
                        if (c4883b instanceof C32537dv) {
                            C4990ab.m7410d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                            C32537dv c32537dv = (C32537dv) c4883b;
                            if (C5046bo.isNullOrNil(c32537dv.cxt.ceI) || C5046bo.isNullOrNil(c32537dv.cxt.cwz) || c32537dv.cxt.data == null) {
                                AppMethodBeat.m2505o(8314);
                                return true;
                            }
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", c32537dv.cxt.ceI);
                            bundle.putByteArray("exdevice_data", c32537dv.cxt.data);
                            bundle.putString("exdevice_brand_name", c32537dv.cxt.cwz);
                            bundle.putString("exdevice_device_type", C46436a.eSg);
                            this.umI.mo26784c(16, bundle);
                        } else if (c4883b instanceof C32538dw) {
                            C4990ab.m7416i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                            C32538dw c32538dw = (C32538dw) c4883b;
                            bundle = new Bundle();
                            bundle.putString("exdevice_device_id", c32538dw.cxu.ceI);
                            bundle.putByteArray("exdevice_broadcast_data", c32538dw.cxu.cxv);
                            bundle.putBoolean("exdevice_is_complete", c32538dw.cxu.bcU);
                            bundle.putBoolean("exdevice_is_lan_device", true);
                            bundle.putString("exdevice_device_type", C46436a.eSg);
                            this.umI.mo26784c(15, bundle);
                        } else if (c4883b instanceof C32539dx) {
                            C4990ab.m7416i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                            C32539dx c32539dx = (C32539dx) c4883b;
                            bundle = new Bundle();
                            if (c32539dx.cxw.cxx) {
                                bundle.putBoolean("exdevice_lan_state", true);
                            } else {
                                bundle.putBoolean("exdevice_lan_state", false);
                            }
                            this.umI.mo26784c(47, bundle);
                        }
                        AppMethodBeat.m2505o(8314);
                        return true;
                    }
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", e.getMessage());
                }
            }
        }
    }

    private C46436a() {
    }

    public static C46436a dbo() {
        AppMethodBeat.m2504i(8315);
        if (uzZ == null) {
            uzZ = new C46436a();
        }
        C46436a c46436a = uzZ;
        AppMethodBeat.m2505o(8315);
        return c46436a;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void dbp() {
        AppMethodBeat.m2504i(8316);
        C4990ab.m7417i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", Boolean.valueOf(this.uAc));
        if (this.uAc) {
            C18261ev c18261ev = new C18261ev();
            c18261ev.cyp.cwA = false;
            C4879a.xxA.mo10055m(c18261ev);
            this.uAc = false;
        }
        this.hasInit = false;
        if (this.uzY != null) {
            C4879a.xxA.mo10053d(this.uzY.uAd);
            C4879a.xxA.mo10053d(this.uzY.uAe);
            C4879a.xxA.mo10053d(this.uzY.uAg);
            C4879a.xxA.mo10053d(this.uzY.uAf);
            C4879a.xxA.mo10053d(this.uzY.uAh);
            this.uzY = null;
        }
        this.uAa = null;
        C32542ee c32542ee = new C32542ee();
        c32542ee.cxF.cwA = false;
        C4879a.xxA.mo10055m(c32542ee);
        AppMethodBeat.m2505o(8316);
    }

    /* renamed from: ft */
    public final void mo27351ft(Context context) {
    }

    public final void dbq() {
    }
}
