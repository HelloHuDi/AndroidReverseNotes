package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;

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
        AppMethodBeat.i(131699);
        this.ifz = parcel.readString();
        this.ifA = parcel.readString();
        this.ifB = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        AppMethodBeat.o(131699);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131700);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.ifz);
        parcel.writeString(this.ifA);
        parcel.writeParcelable(this.ifB, 0);
        AppMethodBeat.o(131700);
    }

    /* Access modifiers changed, original: final */
    public final void cQ(Context context) {
        AppMethodBeat.i(131701);
        Intent intent = this.ifB;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(268435456);
        }
        d.b(context, this.ifz, this.ifA, intent);
        AppMethodBeat.o(131701);
    }
}
