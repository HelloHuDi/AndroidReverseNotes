package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.util.Locale;

public interface ILaunchWxaAppInfoNotify {
    public static final ILaunchWxaAppInfoNotify ihc = new ILaunchWxaAppInfoNotify() {
        private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";

        public final void a(String str, int i, String str2, aa aaVar) {
            AppMethodBeat.i(131819);
            g Ch = g.Ch(str2);
            if (Ch != null) {
                ab.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, AnonymousClass1.a(aaVar));
                Ch.a(str, i, str2, aaVar);
            }
            try {
                ab.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, AnonymousClass1.a(aaVar));
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper();
                launchInfoIpcWrapper.appId = str;
                launchInfoIpcWrapper.har = i;
                launchInfoIpcWrapper.bQt = new AppRuntimeApiPermissionBundle(aaVar.field_jsapiInfo);
                a aVar = AppBrandLaunchErrorAction.CREATOR;
                launchInfoIpcWrapper.ihd = a.a(str, i, aaVar);
                d.a(str, launchInfoIpcWrapper);
                AppMethodBeat.o(131819);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", th, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, AnonymousClass1.a(aaVar));
                AppMethodBeat.o(131819);
            }
        }

        private static String a(aa aaVar) {
            AppMethodBeat.i(131820);
            String str;
            if (aaVar == null) {
                str = "NULL";
                AppMethodBeat.o(131820);
                return str;
            }
            try {
                str = String.format(Locale.US, "bytes[%d]", new Object[]{Integer.valueOf(aaVar.field_jsapiInfo.vYw.wR.length)});
                AppMethodBeat.o(131820);
                return str;
            } catch (Exception e) {
                str = String.format(Locale.US, "Exception[%s]", new Object[]{e});
                AppMethodBeat.o(131820);
                return str;
            }
        }
    };

    public static class LaunchInfoIpcWrapper implements Parcelable {
        public static final Creator<LaunchInfoIpcWrapper> CREATOR = new Creator<LaunchInfoIpcWrapper>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchInfoIpcWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131821);
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper(parcel);
                AppMethodBeat.o(131821);
                return launchInfoIpcWrapper;
            }
        };
        public String appId;
        public AppRuntimeApiPermissionBundle bQt;
        public int har;
        public AppBrandLaunchErrorAction ihd;

        LaunchInfoIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131822);
            parcel.writeString(this.appId);
            parcel.writeInt(this.har);
            parcel.writeParcelable(this.bQt, i);
            parcel.writeParcelable(this.ihd, i);
            AppMethodBeat.o(131822);
        }

        LaunchInfoIpcWrapper(Parcel parcel) {
            AppMethodBeat.i(131823);
            this.appId = parcel.readString();
            this.har = parcel.readInt();
            this.bQt = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
            this.ihd = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            AppMethodBeat.o(131823);
        }

        static {
            AppMethodBeat.i(131824);
            AppMethodBeat.o(131824);
        }
    }

    public static class a {

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$2 */
        public static class AnonymousClass2 implements com.tencent.mm.plugin.appbrand.b.c.a {
            final /* synthetic */ o gQw;
            final /* synthetic */ c hce;

            public AnonymousClass2(o oVar, c cVar) {
                this.gQw = oVar;
                this.hce = cVar;
            }

            public final void a(String str, b bVar) {
                AppMethodBeat.i(131827);
                if (bVar == b.DESTROYED) {
                    MMToClientEvent.b(this.gQw.mAppId, this.hce);
                }
                AppMethodBeat.o(131827);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$1 */
        public static class AnonymousClass1 implements c {
            final /* synthetic */ o gQw;

            public AnonymousClass1(o oVar) {
                this.gQw = oVar;
            }

            /* JADX WARNING: Missing block: B:24:0x0099, code skipped:
            if (r0.uiu == false) goto L_0x0081;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void bk(Object obj) {
                AppMethodBeat.i(131826);
                if (obj instanceof LaunchInfoIpcWrapper) {
                    final LaunchInfoIpcWrapper launchInfoIpcWrapper = (LaunchInfoIpcWrapper) obj;
                    if (this.gQw.mAppId.equals(launchInfoIpcWrapper.appId) && this.gQw.gNB.gVs == launchInfoIpcWrapper.har) {
                        if (launchInfoIpcWrapper.ihd != null) {
                            ab.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update runtime(%s %d), error action %s ", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs), launchInfoIpcWrapper.ihd.getClass().getName());
                            AppBrandLaunchErrorAction appBrandLaunchErrorAction = launchInfoIpcWrapper.ihd;
                            i iVar = this.gQw;
                            if (iVar == null) {
                                iVar = com.tencent.mm.plugin.appbrand.a.wI(appBrandLaunchErrorAction.appId);
                            }
                            if (iVar != null && appBrandLaunchErrorAction.har == iVar.yf().gVs) {
                                Context context;
                                i asU = iVar.asU();
                                iVar.finish();
                                if (asU == null) {
                                    context = ah.getContext();
                                } else {
                                    q asV = asU.asV();
                                    if (asV != null) {
                                        MMActivity context2 = (MMActivity) asV.getContext();
                                        if (!context2.isFinishing()) {
                                        }
                                    }
                                }
                                appBrandLaunchErrorAction.cQ(context2);
                            }
                            OpenBusinessViewUtil.m(this.gQw);
                            AppMethodBeat.o(131826);
                            return;
                        }
                        e xY = this.gQw.xY();
                        if (xY != null) {
                            xY.a(launchInfoIpcWrapper.bQt);
                            AppMethodBeat.o(131826);
                            return;
                        } else if (this.gQw.mFinished) {
                            ab.e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) finished", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs));
                            AppMethodBeat.o(131826);
                            return;
                        } else {
                            ab.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs));
                            this.gQw.A(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131825);
                                    AnonymousClass1.this.gQw.xY().a(launchInfoIpcWrapper.bQt);
                                    AppMethodBeat.o(131825);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.o(131826);
            }
        }
    }

    void a(String str, int i, String str2, aa aaVar);
}
