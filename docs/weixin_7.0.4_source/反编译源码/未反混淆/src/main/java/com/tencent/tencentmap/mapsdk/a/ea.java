package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class ea implements IMapView {
    private ag a;
    private TencentMap b;

    public ea(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(101332);
        dy.a("VecotrMapRenderLayer construct function start");
        ak akVar = null;
        if (tencentMapOptions != null) {
            akVar = new ak();
            if (tencentMapOptions.getExtSurface() != null) {
                akVar.a(tencentMapOptions.getExtSurface());
                akVar.a(tencentMapOptions.getExtSurfaceWidth(), tencentMapOptions.getExtSurfaceHeight());
            }
            akVar.a(tencentMapOptions.isHandDrawMapEnable());
            akVar.a(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            akVar.b(tencentMapOptions.isMutipleInfowindowEnabled());
        }
        this.a = new ag(context, akVar);
        this.b = new eh(this.a.getMap());
        this.a.getMap().l().a(false);
        AppMethodBeat.o(101332);
    }

    public View getMapView() {
        return this.a;
    }

    public TencentMap getMap() {
        return this.b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.i(101333);
        if (this.a.getMap() != null) {
            ek ekVar = new ek(this.a.getMap().l());
            AppMethodBeat.o(101333);
            return ekVar;
        }
        AppMethodBeat.o(101333);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.i(101334);
        if (this.a.getMap() != null) {
            eg egVar = new eg(this.a.getMap());
            AppMethodBeat.o(101334);
            return egVar;
        }
        AppMethodBeat.o(101334);
        return null;
    }

    public MapController getMapController() {
        return this.b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(101335);
        if (this.a.getMap() != null) {
            this.a.getMap().a(new df().a(cn.a(view)).a(ej.a(layoutParams.point)));
        }
        AppMethodBeat.o(101335);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(101336);
        if (this.a != null) {
            this.a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(101336);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.i(101337);
        this.a.a();
        AppMethodBeat.o(101337);
    }

    public void onResume() {
        AppMethodBeat.i(101338);
        this.a.d();
        AppMethodBeat.o(101338);
    }

    public void onPause() {
        AppMethodBeat.i(101339);
        this.a.e();
        AppMethodBeat.o(101339);
    }

    public void onStop() {
        AppMethodBeat.i(101340);
        this.a.b();
        AppMethodBeat.o(101340);
    }

    public void onRestart() {
        AppMethodBeat.i(101341);
        this.a.f();
        AppMethodBeat.o(101341);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.i(101342);
        this.a.c();
        AppMethodBeat.o(101342);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101343);
        boolean onTouchEvent = this.a.onTouchEvent(motionEvent);
        AppMethodBeat.o(101343);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(101344);
        if (this.a != null) {
            this.a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(101344);
    }
}
