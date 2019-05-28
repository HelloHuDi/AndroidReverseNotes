package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.v;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@a(19)
public class SoSoProxyUI extends MapActivity {
    protected static final String TAG = "MicroMsg.SoSoProxyUI";
    private com.tencent.mm.plugin.k.a basemapUI;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(113763);
        ab.i(TAG, "SoSoProxyUI onCreate");
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("intent_map_key", -1);
        if (c.a.nRw == null) {
            try {
                String str = TAG;
                String str2 = "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(b.foreground);
                if (bundle == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = getClass().getSimpleName();
                objArr[3] = Integer.valueOf(hashCode());
                ab.e(str, str2, objArr);
                finish();
            } catch (Throwable th) {
                ab.printErrStackTrace(TAG, th, "summerasyncinit finish:", new Object[0]);
            }
            h.pYm.a(598, 20, 1, false);
            AppMethodBeat.o(113763);
            return;
        }
        this.basemapUI = c.a.nRw.d(this, intExtra);
        if (this.basemapUI == null) {
            finish();
            AppMethodBeat.o(113763);
            return;
        }
        this.basemapUI.onCreate(bundle);
        AppMethodBeat.o(113763);
    }

    public void onBackPressed() {
        AppMethodBeat.i(113764);
        this.basemapUI.onBackPressed();
        AppMethodBeat.o(113764);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(113765);
        if (this.basemapUI.dispatchTouchEvent(motionEvent)) {
            AppMethodBeat.o(113765);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(113765);
        return dispatchTouchEvent;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113766);
        if (this.basemapUI.dispatchKeyEvent(keyEvent)) {
            AppMethodBeat.o(113766);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(113766);
        return dispatchKeyEvent;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(113767);
        if (i == 82 && keyEvent.getAction() == 1) {
            this.basemapUI.bKn();
            AppMethodBeat.o(113767);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(113767);
        return onKeyUp;
    }

    public void onResume() {
        AppMethodBeat.i(113768);
        super.onResume();
        this.basemapUI.onResume();
        AppMethodBeat.o(113768);
    }

    public void onPause() {
        AppMethodBeat.i(113769);
        super.onPause();
        this.basemapUI.onPause();
        AppMethodBeat.o(113769);
    }

    public void onDestroy() {
        AppMethodBeat.i(113770);
        if (this.basemapUI != null) {
            this.basemapUI.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(113770);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(113771);
        this.basemapUI.onActivityResult(i, i2, intent);
        AppMethodBeat.o(113771);
    }

    public Object getSystemService(String str) {
        AppMethodBeat.i(113772);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.o(113772);
            return systemService;
        }
        LayoutInflater a = v.a((LayoutInflater) systemService);
        AppMethodBeat.o(113772);
        return a;
    }

    public Resources getResources() {
        AppMethodBeat.i(113773);
        Resources resources;
        if (getAssets() == null || ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.o(113773);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(113773);
        return resources;
    }

    public void finish() {
        AppMethodBeat.i(113774);
        super.finish();
        AppMethodBeat.o(113774);
    }
}
