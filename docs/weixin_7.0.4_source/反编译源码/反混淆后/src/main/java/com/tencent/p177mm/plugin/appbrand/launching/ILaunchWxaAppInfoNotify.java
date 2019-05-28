package com.tencent.p177mm.plugin.appbrand.launching;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.C10573a;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify */
public interface ILaunchWxaAppInfoNotify {
    public static final ILaunchWxaAppInfoNotify ihc = new C195581();

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper */
    public static class LaunchInfoIpcWrapper implements Parcelable {
        public static final Creator<LaunchInfoIpcWrapper> CREATOR = new C195561();
        public String appId;
        public AppRuntimeApiPermissionBundle bQt;
        public int har;
        public AppBrandLaunchErrorAction ihd;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper$1 */
        static class C195561 implements Creator<LaunchInfoIpcWrapper> {
            C195561() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchInfoIpcWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131821);
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper(parcel);
                AppMethodBeat.m2505o(131821);
                return launchInfoIpcWrapper;
            }
        }

        LaunchInfoIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131822);
            parcel.writeString(this.appId);
            parcel.writeInt(this.har);
            parcel.writeParcelable(this.bQt, i);
            parcel.writeParcelable(this.ihd, i);
            AppMethodBeat.m2505o(131822);
        }

        LaunchInfoIpcWrapper(Parcel parcel) {
            AppMethodBeat.m2504i(131823);
            this.appId = parcel.readString();
            this.har = parcel.readInt();
            this.bQt = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
            this.ihd = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            AppMethodBeat.m2505o(131823);
        }

        static {
            AppMethodBeat.m2504i(131824);
            AppMethodBeat.m2505o(131824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a */
    public static class C19557a {

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$2 */
        public static class C23742 implements C10137a {
            final /* synthetic */ C41243o gQw;
            final /* synthetic */ C38244c hce;

            public C23742(C41243o c41243o, C38244c c38244c) {
                this.gQw = c41243o;
                this.hce = c38244c;
            }

            /* renamed from: a */
            public final void mo6006a(String str, C45524b c45524b) {
                AppMethodBeat.m2504i(131827);
                if (c45524b == C45524b.DESTROYED) {
                    MMToClientEvent.m75200b(this.gQw.mAppId, this.hce);
                }
                AppMethodBeat.m2505o(131827);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$a$1 */
        public static class C105761 implements C38244c {
            final /* synthetic */ C41243o gQw;

            public C105761(C41243o c41243o) {
                this.gQw = c41243o;
            }

            /* JADX WARNING: Missing block: B:24:0x0099, code skipped:
            if (r0.uiu == false) goto L_0x0081;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: bk */
            public final void mo22088bk(Object obj) {
                AppMethodBeat.m2504i(131826);
                if (obj instanceof LaunchInfoIpcWrapper) {
                    final LaunchInfoIpcWrapper launchInfoIpcWrapper = (LaunchInfoIpcWrapper) obj;
                    if (this.gQw.mAppId.equals(launchInfoIpcWrapper.appId) && this.gQw.gNB.gVs == launchInfoIpcWrapper.har) {
                        if (launchInfoIpcWrapper.ihd != null) {
                            C4990ab.m7417i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update runtime(%s %d), error action %s ", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs), launchInfoIpcWrapper.ihd.getClass().getName());
                            AppBrandLaunchErrorAction appBrandLaunchErrorAction = launchInfoIpcWrapper.ihd;
                            C6750i c6750i = this.gQw;
                            if (c6750i == null) {
                                c6750i = C10048a.m17635wI(appBrandLaunchErrorAction.appId);
                            }
                            if (c6750i != null && appBrandLaunchErrorAction.har == c6750i.mo15035yf().gVs) {
                                Context context;
                                C6750i asU = c6750i.asU();
                                c6750i.finish();
                                if (asU == null) {
                                    context = C4996ah.getContext();
                                } else {
                                    C38470q asV = asU.asV();
                                    if (asV != null) {
                                        MMActivity context2 = (MMActivity) asV.getContext();
                                        if (!context2.isFinishing()) {
                                        }
                                    }
                                }
                                appBrandLaunchErrorAction.mo22082cQ(context2);
                            }
                            OpenBusinessViewUtil.m30041m(this.gQw);
                            AppMethodBeat.m2505o(131826);
                            return;
                        }
                        C33491e xY = this.gQw.mo43488xY();
                        if (xY != null) {
                            xY.mo53978a(launchInfoIpcWrapper.bQt);
                            AppMethodBeat.m2505o(131826);
                            return;
                        } else if (this.gQw.mFinished) {
                            C4990ab.m7413e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) finished", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs));
                            AppMethodBeat.m2505o(131826);
                            return;
                        } else {
                            C4990ab.m7417i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", this.gQw.mAppId, Integer.valueOf(this.gQw.gNB.gVs));
                            this.gQw.mo14976A(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131825);
                                    C105761.this.gQw.mo43488xY().mo53978a(launchInfoIpcWrapper.bQt);
                                    AppMethodBeat.m2505o(131825);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.m2505o(131826);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify$1 */
    static class C195581 implements ILaunchWxaAppInfoNotify {
        private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";

        C195581() {
        }

        /* renamed from: a */
        public final void mo34768a(String str, int i, String str2, C27157aa c27157aa) {
            AppMethodBeat.m2504i(131819);
            C27165g Ch = C27165g.m43175Ch(str2);
            if (Ch != null) {
                C4990ab.m7417i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, C195581.m30332a(c27157aa));
                Ch.mo34768a(str, i, str2, c27157aa);
            }
            try {
                C4990ab.m7417i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, C195581.m30332a(c27157aa));
                LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper();
                launchInfoIpcWrapper.appId = str;
                launchInfoIpcWrapper.har = i;
                launchInfoIpcWrapper.bQt = new AppRuntimeApiPermissionBundle(c27157aa.field_jsapiInfo);
                C10573a c10573a = AppBrandLaunchErrorAction.CREATOR;
                launchInfoIpcWrapper.ihd = C10573a.m18260a(str, i, c27157aa);
                C10276d.m17931a(str, launchInfoIpcWrapper);
                AppMethodBeat.m2505o(131819);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", th, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", str, Integer.valueOf(i), str2, C195581.m30332a(c27157aa));
                AppMethodBeat.m2505o(131819);
            }
        }

        /* renamed from: a */
        private static String m30332a(C27157aa c27157aa) {
            AppMethodBeat.m2504i(131820);
            String str;
            if (c27157aa == null) {
                str = "NULL";
                AppMethodBeat.m2505o(131820);
                return str;
            }
            try {
                str = String.format(Locale.US, "bytes[%d]", new Object[]{Integer.valueOf(c27157aa.field_jsapiInfo.vYw.f1226wR.length)});
                AppMethodBeat.m2505o(131820);
                return str;
            } catch (Exception e) {
                str = String.format(Locale.US, "Exception[%s]", new Object[]{e});
                AppMethodBeat.m2505o(131820);
                return str;
            }
        }
    }

    /* renamed from: a */
    void mo34768a(String str, int i, String str2, C27157aa c27157aa);
}
