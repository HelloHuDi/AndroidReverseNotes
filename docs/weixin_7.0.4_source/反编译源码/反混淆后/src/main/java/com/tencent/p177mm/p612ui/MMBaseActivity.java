package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.MMBaseActivity */
public class MMBaseActivity extends Activity {
    private boolean mIsPaused;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(106016);
        Resources resources;
        if (getAssets() == null || C4996ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(106016);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(106016);
        return resources;
    }

    public Object getSystemService(String str) {
        AppMethodBeat.m2504i(106017);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.m2505o(106017);
            return systemService;
        }
        LayoutInflater a = C5616v.m8408a((LayoutInflater) systemService);
        AppMethodBeat.m2505o(106017);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(106018);
        super.onDestroy();
        AppMethodBeat.m2505o(106018);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(106019);
        this.mIsPaused = false;
        super.onResume();
        AppMethodBeat.m2505o(106019);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(106020);
        this.mIsPaused = true;
        super.onPause();
        AppMethodBeat.m2505o(106020);
    }

    public void startActivityForResult(Intent intent, int i) {
        AppMethodBeat.m2504i(106021);
        super.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(106021);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(106022);
        if (C5493d.m8286a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            AppMethodBeat.m2505o(106022);
            return;
        }
        super.startActivityForResult(intent, i, bundle);
        AppMethodBeat.m2505o(106022);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.m2504i(106023);
        super.startActivity(intent);
        AppMethodBeat.m2505o(106023);
    }

    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.m2504i(106024);
        super.startActivities(intentArr);
        AppMethodBeat.m2505o(106024);
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.m2504i(106025);
        if (C5493d.m8286a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.m2505o(106025);
            return;
        }
        super.startActivities(intentArr, bundle);
        AppMethodBeat.m2505o(106025);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(106026);
        super.startActivity(intent, bundle);
        AppMethodBeat.m2505o(106026);
    }
}
