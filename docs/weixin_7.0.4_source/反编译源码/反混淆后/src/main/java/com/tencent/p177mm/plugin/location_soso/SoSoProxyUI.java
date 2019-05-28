package com.tencent.p177mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.p443k.C12329c.C3329a;
import com.tencent.p177mm.plugin.p443k.C39279a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.location_soso.SoSoProxyUI */
public class SoSoProxyUI extends MapActivity {
    protected static final String TAG = "MicroMsg.SoSoProxyUI";
    private C39279a basemapUI;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(113763);
        C4990ab.m7416i(TAG, "SoSoProxyUI onCreate");
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("intent_map_key", -1);
        if (C3329a.nRw == null) {
            try {
                String str = TAG;
                String str2 = "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(C4872b.foreground);
                if (bundle == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = getClass().getSimpleName();
                objArr[3] = Integer.valueOf(hashCode());
                C4990ab.m7413e(str, str2, objArr);
                finish();
            } catch (Throwable th) {
                C4990ab.printErrStackTrace(TAG, th, "summerasyncinit finish:", new Object[0]);
            }
            C7060h.pYm.mo8378a(598, 20, 1, false);
            AppMethodBeat.m2505o(113763);
            return;
        }
        this.basemapUI = C3329a.nRw.mo24188d(this, intExtra);
        if (this.basemapUI == null) {
            finish();
            AppMethodBeat.m2505o(113763);
            return;
        }
        this.basemapUI.onCreate(bundle);
        AppMethodBeat.m2505o(113763);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(113764);
        this.basemapUI.onBackPressed();
        AppMethodBeat.m2505o(113764);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113765);
        if (this.basemapUI.dispatchTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(113765);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(113765);
        return dispatchTouchEvent;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(113766);
        if (this.basemapUI.dispatchKeyEvent(keyEvent)) {
            AppMethodBeat.m2505o(113766);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(113766);
        return dispatchKeyEvent;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(113767);
        if (i == 82 && keyEvent.getAction() == 1) {
            this.basemapUI.bKn();
            AppMethodBeat.m2505o(113767);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(113767);
        return onKeyUp;
    }

    public void onResume() {
        AppMethodBeat.m2504i(113768);
        super.onResume();
        this.basemapUI.onResume();
        AppMethodBeat.m2505o(113768);
    }

    public void onPause() {
        AppMethodBeat.m2504i(113769);
        super.onPause();
        this.basemapUI.onPause();
        AppMethodBeat.m2505o(113769);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(113770);
        if (this.basemapUI != null) {
            this.basemapUI.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(113770);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(113771);
        this.basemapUI.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(113771);
    }

    public Object getSystemService(String str) {
        AppMethodBeat.m2504i(113772);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.m2505o(113772);
            return systemService;
        }
        LayoutInflater a = C5616v.m8408a((LayoutInflater) systemService);
        AppMethodBeat.m2505o(113772);
        return a;
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(113773);
        Resources resources;
        if (getAssets() == null || C4996ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(113773);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(113773);
        return resources;
    }

    public void finish() {
        AppMethodBeat.m2504i(113774);
        super.finish();
        AppMethodBeat.m2505o(113774);
    }
}
