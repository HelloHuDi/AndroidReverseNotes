package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.C41482b;
import android.support.customtabs.C41482b.C31829a;
import android.support.p057v4.content.C0380b;
import com.facebook.FacebookSdk;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        AppMethodBeat.m2504i(96613);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
        AppMethodBeat.m2505o(96613);
    }

    public void openCustomTab(Activity activity, String str) {
        AppMethodBeat.m2504i(96614);
        C31829a c31829a = new C31829a();
        if (c31829a.f14543kz != null) {
            c31829a.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", c31829a.f14543kz);
        }
        if (c31829a.f14541kB != null) {
            c31829a.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", c31829a.f14541kB);
        }
        c31829a.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", c31829a.f14542kC);
        C41482b c41482b = new C41482b(c31829a.mIntent, c31829a.f14540kA, (byte) 0);
        c41482b.intent.setPackage(str);
        c41482b.intent.addFlags(ErrorDialogData.SUPPRESSED);
        c41482b.intent.setData(this.uri);
        C0380b.startActivity(activity, c41482b.intent, c41482b.f16699ky);
        AppMethodBeat.m2505o(96614);
    }
}
