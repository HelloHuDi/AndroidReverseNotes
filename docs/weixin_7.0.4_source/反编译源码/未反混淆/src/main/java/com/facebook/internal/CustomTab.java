package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.b;
import android.support.customtabs.b.a;
import com.facebook.FacebookSdk;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        AppMethodBeat.i(96613);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
        AppMethodBeat.o(96613);
    }

    public void openCustomTab(Activity activity, String str) {
        AppMethodBeat.i(96614);
        a aVar = new a();
        if (aVar.kz != null) {
            aVar.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", aVar.kz);
        }
        if (aVar.kB != null) {
            aVar.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", aVar.kB);
        }
        aVar.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", aVar.kC);
        b bVar = new b(aVar.mIntent, aVar.kA, (byte) 0);
        bVar.intent.setPackage(str);
        bVar.intent.addFlags(ErrorDialogData.SUPPRESSED);
        bVar.intent.setData(this.uri);
        android.support.v4.content.b.startActivity(activity, bVar.intent, bVar.ky);
        AppMethodBeat.o(96614);
    }
}
