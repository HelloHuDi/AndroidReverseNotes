package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity */
final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String ifA;
    final Intent ifB;
    final String ifz;

    AppBrandLaunchErrorActionStartActivity(String str, int i, String str2, String str3, Intent intent) {
        super(str, i);
        this.ifz = str2;
        this.ifA = str3;
        this.ifB = intent;
    }

    @Keep
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(131699);
        this.ifz = parcel.readString();
        this.ifA = parcel.readString();
        this.ifB = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        AppMethodBeat.m2505o(131699);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131700);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ifz);
        parcel.writeString(this.ifA);
        parcel.writeParcelable(this.ifB, 0);
        AppMethodBeat.m2505o(131700);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cQ */
    public final void mo22082cQ(Context context) {
        AppMethodBeat.m2504i(131701);
        Intent intent = this.ifB;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(268435456);
        }
        C25985d.m41467b(context, this.ifz, this.ifA, intent);
        AppMethodBeat.m2505o(131701);
    }
}
