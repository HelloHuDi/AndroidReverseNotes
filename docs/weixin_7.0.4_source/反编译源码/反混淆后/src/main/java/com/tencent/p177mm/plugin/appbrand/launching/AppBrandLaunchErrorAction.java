package com.tencent.p177mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19771b;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction */
public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final C10573a CREATOR = new C10573a();
    final String appId;
    final int har;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction$a */
    static final class C10573a implements Creator<AppBrandLaunchErrorAction> {
        C10573a() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131695);
            AppBrandLaunchErrorAction l = C10573a.m18261l(parcel);
            AppMethodBeat.m2505o(131695);
            return l;
        }

        /* renamed from: l */
        private static AppBrandLaunchErrorAction m18261l(Parcel parcel) {
            AppMethodBeat.m2504i(131693);
            String readString = parcel.readString();
            if (readString == null) {
                AppMethodBeat.m2505o(131693);
                return null;
            }
            try {
                AppBrandLaunchErrorAction appBrandLaunchErrorAction = (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
                AppMethodBeat.m2505o(131693);
                return appBrandLaunchErrorAction;
            } catch (Exception e) {
                AppMethodBeat.m2505o(131693);
                return null;
            }
        }

        /* renamed from: a */
        static AppBrandLaunchErrorAction m18260a(String str, int i, C27157aa c27157aa) {
            AppBrandLaunchErrorAction appBrandLaunchErrorAction = null;
            AppMethodBeat.m2504i(131694);
            if (c27157aa == null || c27157aa.field_launchAction == null) {
                AppMethodBeat.m2505o(131694);
            } else {
                switch (c27157aa.field_launchAction.vAS) {
                    case 2:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", c27157aa.field_launchAction.wBu);
                        intent.putExtra("forceHideShare", true);
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
                        break;
                    case 3:
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionAlert(str, i, c27157aa.field_launchAction.wup, c27157aa.field_launchAction.wBw);
                        break;
                }
                if (appBrandLaunchErrorAction != null) {
                    C19771b.aMR();
                }
                AppMethodBeat.m2505o(131694);
            }
            return appBrandLaunchErrorAction;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchErrorAction[i];
        }
    }

    /* renamed from: cQ */
    public abstract void mo22082cQ(Context context);

    AppBrandLaunchErrorAction(Parcel parcel) {
        this.appId = parcel.readString();
        this.har = parcel.readInt();
    }

    AppBrandLaunchErrorAction(String str, int i) {
        this.appId = str;
        this.har = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.appId);
        parcel.writeInt(this.har);
    }

    public final int describeContents() {
        return 0;
    }
}
