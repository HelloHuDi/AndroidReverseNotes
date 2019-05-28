package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert */
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
        AppMethodBeat.m2504i(131696);
        this.gsG = parcel.readString();
        this.gsH = parcel.readString();
        AppMethodBeat.m2505o(131696);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131697);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.gsG);
        parcel.writeString(this.gsH);
        AppMethodBeat.m2505o(131697);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cQ */
    public final void mo22082cQ(Context context) {
        AppMethodBeat.m2504i(131698);
        String str = this.gsH;
        String str2 = this.gsG;
        if (context instanceof Activity) {
            C30379h.m48448a(context, str, str2, false, null);
            AppMethodBeat.m2505o(131698);
            return;
        }
        C26907a.m42842a(null, str, str2, C4996ah.getResources().getString(C25738R.string.f9187s6), "", null, null, null);
        AppMethodBeat.m2505o(131698);
    }
}
