package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMBaseActivity extends Activity {
    private boolean mIsPaused;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public Resources getResources() {
        AppMethodBeat.i(106016);
        Resources resources;
        if (getAssets() == null || ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.o(106016);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(106016);
        return resources;
    }

    public Object getSystemService(String str) {
        AppMethodBeat.i(106017);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.o(106017);
            return systemService;
        }
        LayoutInflater a = v.a((LayoutInflater) systemService);
        AppMethodBeat.o(106017);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(106018);
        super.onDestroy();
        AppMethodBeat.o(106018);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(106019);
        this.mIsPaused = false;
        super.onResume();
        AppMethodBeat.o(106019);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(106020);
        this.mIsPaused = true;
        super.onPause();
        AppMethodBeat.o(106020);
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.i(106021);
        super.startActivityForResult(intent, i);
        AppMethodBeat.o(106021);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.i(106022);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            AppMethodBeat.o(106022);
            return;
        }
        super.startActivityForResult(intent, i, bundle);
        AppMethodBeat.o(106022);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(106023);
        super.startActivity(intent);
        AppMethodBeat.o(106023);
    }

    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.i(106024);
        super.startActivities(intentArr);
        AppMethodBeat.o(106024);
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.i(106025);
        if (d.a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.o(106025);
            return;
        }
        super.startActivities(intentArr, bundle);
        AppMethodBeat.o(106025);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.i(106026);
        super.startActivity(intent, bundle);
        AppMethodBeat.o(106026);
    }
}
