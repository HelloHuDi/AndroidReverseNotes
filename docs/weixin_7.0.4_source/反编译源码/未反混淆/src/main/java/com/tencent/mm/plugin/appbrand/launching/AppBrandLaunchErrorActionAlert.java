package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String gsG;
    final String gsH;

    AppBrandLaunchErrorActionAlert(String str, int i, String str2, String str3) {
        super(str, i);
        this.gsG = str2;
        this.gsH = str3;
    }

    @Keep
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(131696);
        this.gsG = parcel.readString();
        this.gsH = parcel.readString();
        AppMethodBeat.o(131696);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131697);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.gsG);
        parcel.writeString(this.gsH);
        AppMethodBeat.o(131697);
    }

    /* Access modifiers changed, original: final */
    public final void cQ(Context context) {
        AppMethodBeat.i(131698);
        String str = this.gsH;
        String str2 = this.gsG;
        if (context instanceof Activity) {
            h.a(context, str, str2, false, null);
            AppMethodBeat.o(131698);
            return;
        }
        a.a(null, str, str2, ah.getResources().getString(R.string.s6), "", null, null, null);
        AppMethodBeat.o(131698);
    }
}
