package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;

public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final a CREATOR = new a();
    final String appId;
    final int har;

    static final class a implements Creator<AppBrandLaunchErrorAction> {
        a() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131695);
            AppBrandLaunchErrorAction l = l(parcel);
            AppMethodBeat.o(131695);
            return l;
        }

        private static AppBrandLaunchErrorAction l(Parcel parcel) {
            AppMethodBeat.i(131693);
            String readString = parcel.readString();
            if (readString == null) {
                AppMethodBeat.o(131693);
                return null;
            }
            try {
                AppBrandLaunchErrorAction appBrandLaunchErrorAction = (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
                AppMethodBeat.o(131693);
                return appBrandLaunchErrorAction;
            } catch (Exception e) {
                AppMethodBeat.o(131693);
                return null;
            }
        }

        static AppBrandLaunchErrorAction a(String str, int i, aa aaVar) {
            AppBrandLaunchErrorAction appBrandLaunchErrorAction = null;
            AppMethodBeat.i(131694);
            if (aaVar == null || aaVar.field_launchAction == null) {
                AppMethodBeat.o(131694);
            } else {
                switch (aaVar.field_launchAction.vAS) {
                    case 2:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", aaVar.field_launchAction.wBu);
                        intent.putExtra("forceHideShare", true);
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
                        break;
                    case 3:
                        appBrandLaunchErrorAction = new AppBrandLaunchErrorActionAlert(str, i, aaVar.field_launchAction.wup, aaVar.field_launchAction.wBw);
                        break;
                }
                if (appBrandLaunchErrorAction != null) {
                    b.aMR();
                }
                AppMethodBeat.o(131694);
            }
            return appBrandLaunchErrorAction;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchErrorAction[i];
        }
    }

    public abstract void cQ(Context context);

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
