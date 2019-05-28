package com.tencent.p177mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C42327ad.C423261;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.launching.C27164d.C27163a;
import com.tencent.p177mm.plugin.appbrand.launching.C31317e;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C6789b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp */
public final class JsApiUpdateApp extends C10296a<C19722s> {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$SyncResult */
    static final class SyncResult implements Parcelable {
        public static final Creator<SyncResult> CREATOR = new C105471();
        private AppBrandInitConfigWC hYb;
        private boolean hYd;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$SyncResult$1 */
        static class C105471 implements Creator<SyncResult> {
            C105471() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SyncResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131492);
                SyncResult syncResult = new SyncResult(parcel);
                AppMethodBeat.m2505o(131492);
                return syncResult;
            }
        }

        SyncResult(boolean z, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.hYd = z;
            this.hYb = appBrandInitConfigWC;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            AppMethodBeat.m2504i(131493);
            if (this.hYd) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeParcelable(this.hYb, 0);
            AppMethodBeat.m2505o(131493);
        }

        SyncResult(Parcel parcel) {
            AppMethodBeat.m2504i(131494);
            this.hYd = parcel.readByte() != (byte) 0;
            this.hYb = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            AppMethodBeat.m2505o(131494);
        }

        static {
            AppMethodBeat.m2504i(131495);
            AppMethodBeat.m2505o(131495);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$SyncRequest */
    static final class SyncRequest implements Parcelable {
        public static final Creator<SyncRequest> CREATOR = new C23511();
        private AppBrandInitConfigWC hYb;
        private AppBrandStatObject hYc;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$SyncRequest$1 */
        static class C23511 implements Creator<SyncRequest> {
            C23511() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SyncRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(138130);
                SyncRequest syncRequest = new SyncRequest(parcel);
                AppMethodBeat.m2505o(138130);
                return syncRequest;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(138131);
            parcel.writeParcelable(this.hYb, i);
            parcel.writeParcelable(this.hYc, i);
            AppMethodBeat.m2505o(138131);
        }

        public SyncRequest(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
            this.hYb = appBrandInitConfigWC;
            this.hYc = appBrandStatObject;
        }

        protected SyncRequest(Parcel parcel) {
            AppMethodBeat.m2504i(138132);
            this.hYb = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.hYc = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            AppMethodBeat.m2505o(138132);
        }

        static {
            AppMethodBeat.m2504i(138133);
            AppMethodBeat.m2505o(138133);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$a */
    static final class C45629a implements C37866a<SyncRequest, SyncResult> {
        private C45629a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(131491);
            final SyncRequest syncRequest = (SyncRequest) obj;
            if (c18507c == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr callback is NULL");
                AppMethodBeat.m2505o(131491);
            } else if (syncRequest == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr data is NULL");
                c18507c.mo5960ao(new SyncResult(false, null));
                AppMethodBeat.m2505o(131491);
            } else {
                LaunchParcel launchParcel = new LaunchParcel();
                launchParcel.username = syncRequest.hYb.username;
                launchParcel.appId = syncRequest.hYb.appId;
                launchParcel.version = 0;
                launchParcel.har = syncRequest.hYb.gVs;
                launchParcel.hgC = syncRequest.hYb.hgC;
                launchParcel.ijy = syncRequest.hYc;
                launchParcel.hgF = null;
                launchParcel.ijz = new LaunchParamsOptional();
                launchParcel.ijz.bQi = syncRequest.hYb.bQi;
                launchParcel.ijz.bQh = syncRequest.hYb.bQh;
                launchParcel.ijz.bQj = syncRequest.hYb.bQj;
                launchParcel.ijA = C5046bo.anU();
                new C31317e(launchParcel, C2453g.m4700pM(syncRequest.hYb.uin), new C27163a() {
                    /* renamed from: a */
                    public final void mo44834a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
                        AppMethodBeat.m2504i(138129);
                        switch (i) {
                            case 1:
                                C4990ab.m7417i("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] succeed", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene));
                                c18507c.mo5960ao(new SyncResult(true, (AppBrandInitConfigWC) appBrandInitConfigLU));
                                AppMethodBeat.m2505o(138129);
                                return;
                            case 2:
                                C4990ab.m7413e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] failed", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene));
                                c18507c.mo5960ao(new SyncResult(false, null));
                                AppMethodBeat.m2505o(138129);
                                return;
                            default:
                                C4990ab.m7413e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] invalid result[%d]", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene), Integer.valueOf(i));
                                c18507c.mo5960ao(new SyncResult(false, null));
                                AppMethodBeat.m2505o(138129);
                                return;
                        }
                    }
                }).aHb();
                AppMethodBeat.m2505o(131491);
            }
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131496);
        mo73409a((C19722s) c2241c, i);
        AppMethodBeat.m2505o(131496);
    }

    /* renamed from: a */
    public final void mo73409a(final C19722s c19722s, final int i) {
        AppMethodBeat.m2504i(138134);
        XIPCInvoker.m83629a("com.tencent.mm", new SyncRequest(c19722s.getRuntime().atI(), c19722s.getRuntime().mo43491ya().bQn), C45629a.class, new C18507c<SyncResult>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(131489);
                SyncResult syncResult = (SyncResult) obj;
                if (c19722s.isRunning()) {
                    if (syncResult.hYd) {
                        final AppBrandInitConfigWC b = syncResult.hYb;
                        if (c19722s.getRuntime().atH().hhd.gVt == 0 && b.axy == c19722s.getRuntime().atH().hhd.gVu && !C5047bp.dpL()) {
                            c19722s.mo6107M(i, JsApiUpdateApp.this.mo73394j("fail the current version is the latest version", null));
                            AppMethodBeat.m2505o(131489);
                            return;
                        }
                        c19722s.getRuntime().mo14977B(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$1$1$2 */
                            class C23502 implements OnClickListener {
                                C23502() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(131487);
                                    c19722s.mo6107M(i, JsApiUpdateApp.this.mo73394j("fail user canceled updateApp", null));
                                    AppMethodBeat.m2505o(131487);
                                }
                            }

                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp$1$1$1 */
                            class C194981 implements OnClickListener {
                                C194981() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(131486);
                                    C41243o runtime = c19722s.getRuntime();
                                    AppBrandInitConfigWC appBrandInitConfigWC = b;
                                    if (runtime == null || appBrandInitConfigWC == null) {
                                        C4990ab.m7412e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                                        AppMethodBeat.m2505o(131486);
                                    } else if (runtime.eMP) {
                                        runtime.mo14977B(new C423261(runtime, appBrandInitConfigWC));
                                        AppMethodBeat.m2505o(131486);
                                    } else {
                                        C4990ab.m7413e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", runtime.mAppId);
                                        AppMethodBeat.m2505o(131486);
                                    }
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(131488);
                                C6789b c6789b = new C6789b(c19722s.getContext());
                                c6789b.setCanceledOnTouchOutside(false);
                                c6789b.setCancelable(false);
                                c6789b.setMessage(c19722s.getContext().getString(c19722s.getRuntime().mo65903xy() ? C25738R.string.f8945k9 : C25738R.string.f8946k_, new Object[]{c19722s.getRuntime().atI().cwz}));
                                C194981 c194981 = new C194981();
                                if (c19722s.getRuntime().atH().hhd.gVt != 0) {
                                    c6789b.mo11487a((int) C25738R.string.f8944k8, (OnClickListener) c194981);
                                    c6789b.mo11490b(C25738R.string.f8942k6, new C23502());
                                } else {
                                    c6789b.mo11487a((int) C25738R.string.f8943k7, (OnClickListener) c194981);
                                }
                                c19722s.asF().mo6468b(c6789b);
                                AppMethodBeat.m2505o(131488);
                            }
                        });
                        AppMethodBeat.m2505o(131489);
                        return;
                    }
                    c19722s.mo6107M(i, JsApiUpdateApp.this.mo73394j("fail sync error", null));
                }
                AppMethodBeat.m2505o(131489);
            }
        });
        AppMethodBeat.m2505o(138134);
    }
}
