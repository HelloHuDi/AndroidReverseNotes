package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import org.json.JSONObject;

public final class JsApiUpdateApp extends com.tencent.mm.plugin.appbrand.jsapi.a<s> {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    static final class SyncResult implements Parcelable {
        public static final Creator<SyncResult> CREATOR = new Creator<SyncResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SyncResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131492);
                SyncResult syncResult = new SyncResult(parcel);
                AppMethodBeat.o(131492);
                return syncResult;
            }
        };
        private AppBrandInitConfigWC hYb;
        private boolean hYd;

        SyncResult(boolean z, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.hYd = z;
            this.hYb = appBrandInitConfigWC;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            AppMethodBeat.i(131493);
            if (this.hYd) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeParcelable(this.hYb, 0);
            AppMethodBeat.o(131493);
        }

        SyncResult(Parcel parcel) {
            AppMethodBeat.i(131494);
            this.hYd = parcel.readByte() != (byte) 0;
            this.hYb = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            AppMethodBeat.o(131494);
        }

        static {
            AppMethodBeat.i(131495);
            AppMethodBeat.o(131495);
        }
    }

    static final class SyncRequest implements Parcelable {
        public static final Creator<SyncRequest> CREATOR = new Creator<SyncRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SyncRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(138130);
                SyncRequest syncRequest = new SyncRequest(parcel);
                AppMethodBeat.o(138130);
                return syncRequest;
            }
        };
        private AppBrandInitConfigWC hYb;
        private AppBrandStatObject hYc;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(138131);
            parcel.writeParcelable(this.hYb, i);
            parcel.writeParcelable(this.hYc, i);
            AppMethodBeat.o(138131);
        }

        public SyncRequest(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
            this.hYb = appBrandInitConfigWC;
            this.hYc = appBrandStatObject;
        }

        protected SyncRequest(Parcel parcel) {
            AppMethodBeat.i(138132);
            this.hYb = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.hYc = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            AppMethodBeat.o(138132);
        }

        static {
            AppMethodBeat.i(138133);
            AppMethodBeat.o(138133);
        }
    }

    static final class a implements com.tencent.mm.ipcinvoker.a<SyncRequest, SyncResult> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(131491);
            final SyncRequest syncRequest = (SyncRequest) obj;
            if (cVar == null) {
                ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr callback is NULL");
                AppMethodBeat.o(131491);
            } else if (syncRequest == null) {
                ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr data is NULL");
                cVar.ao(new SyncResult(false, null));
                AppMethodBeat.o(131491);
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
                launchParcel.ijA = bo.anU();
                new e(launchParcel, g.pM(syncRequest.hYb.uin), new com.tencent.mm.plugin.appbrand.launching.d.a() {
                    public final void a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
                        AppMethodBeat.i(138129);
                        switch (i) {
                            case 1:
                                ab.i("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] succeed", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene));
                                cVar.ao(new SyncResult(true, (AppBrandInitConfigWC) appBrandInitConfigLU));
                                AppMethodBeat.o(138129);
                                return;
                            case 2:
                                ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] failed", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene));
                                cVar.ao(new SyncResult(false, null));
                                AppMethodBeat.o(138129);
                                return;
                            default:
                                ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] invalid result[%d]", syncRequest.hYb.appId, Integer.valueOf(syncRequest.hYc.scene), Integer.valueOf(i));
                                cVar.ao(new SyncResult(false, null));
                                AppMethodBeat.o(138129);
                                return;
                        }
                    }
                }).aHb();
                AppMethodBeat.o(131491);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131496);
        a((s) cVar, i);
        AppMethodBeat.o(131496);
    }

    public final void a(final s sVar, final int i) {
        AppMethodBeat.i(138134);
        XIPCInvoker.a("com.tencent.mm", new SyncRequest(sVar.getRuntime().atI(), sVar.getRuntime().ya().bQn), a.class, new c<SyncResult>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(131489);
                SyncResult syncResult = (SyncResult) obj;
                if (sVar.isRunning()) {
                    if (syncResult.hYd) {
                        final AppBrandInitConfigWC b = syncResult.hYb;
                        if (sVar.getRuntime().atH().hhd.gVt == 0 && b.axy == sVar.getRuntime().atH().hhd.gVu && !bp.dpL()) {
                            sVar.M(i, JsApiUpdateApp.this.j("fail the current version is the latest version", null));
                            AppMethodBeat.o(131489);
                            return;
                        }
                        sVar.getRuntime().B(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131488);
                                b bVar = new b(sVar.getContext());
                                bVar.setCanceledOnTouchOutside(false);
                                bVar.setCancelable(false);
                                bVar.setMessage(sVar.getContext().getString(sVar.getRuntime().xy() ? R.string.k9 : R.string.k_, new Object[]{sVar.getRuntime().atI().cwz}));
                                AnonymousClass1 anonymousClass1 = new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(131486);
                                        o runtime = sVar.getRuntime();
                                        AppBrandInitConfigWC appBrandInitConfigWC = b;
                                        if (runtime == null || appBrandInitConfigWC == null) {
                                            ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                                            AppMethodBeat.o(131486);
                                        } else if (runtime.eMP) {
                                            runtime.B(new com.tencent.mm.plugin.appbrand.ad.AnonymousClass1(runtime, appBrandInitConfigWC));
                                            AppMethodBeat.o(131486);
                                        } else {
                                            ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", runtime.mAppId);
                                            AppMethodBeat.o(131486);
                                        }
                                    }
                                };
                                if (sVar.getRuntime().atH().hhd.gVt != 0) {
                                    bVar.a((int) R.string.k8, (OnClickListener) anonymousClass1);
                                    bVar.b(R.string.k6, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(131487);
                                            sVar.M(i, JsApiUpdateApp.this.j("fail user canceled updateApp", null));
                                            AppMethodBeat.o(131487);
                                        }
                                    });
                                } else {
                                    bVar.a((int) R.string.k7, (OnClickListener) anonymousClass1);
                                }
                                sVar.asF().b(bVar);
                                AppMethodBeat.o(131488);
                            }
                        });
                        AppMethodBeat.o(131489);
                        return;
                    }
                    sVar.M(i, JsApiUpdateApp.this.j("fail sync error", null));
                }
                AppMethodBeat.o(131489);
            }
        });
        AppMethodBeat.o(138134);
    }
}
