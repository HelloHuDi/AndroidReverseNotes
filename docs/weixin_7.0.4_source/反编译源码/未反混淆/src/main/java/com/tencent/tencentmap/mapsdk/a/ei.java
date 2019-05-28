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

public class ei implements IMapView {
    private al a;
    private TencentMap b;

    public ei(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(101551);
        dy.a("vector MapView construct function start");
        ak akVar = null;
        if (tencentMapOptions != null) {
            akVar = new ak();
            if (tencentMapOptions.getExtSurface() != null) {
                akVar.a(tencentMapOptions.getExtSurface());
            }
            akVar.a(tencentMapOptions.isHandDrawMapEnable());
            akVar.a(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            akVar.b(tencentMapOptions.isMutipleInfowindowEnabled());
        }
        this.a = new al(context, akVar);
        this.b = new eh(this.a.getMap());
        this.a.getMap().l().a(false);
        AppMethodBeat.o(101551);
    }

    public View getMapView() {
        return this.a;
    }

    public TencentMap getMap() {
        return this.b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.i(101552);
        if (this.a.getMap() != null) {
            ek ekVar = new ek(this.a.getMap().l());
            AppMethodBeat.o(101552);
            return ekVar;
        }
        AppMethodBeat.o(101552);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.i(101553);
        if (this.a.getMap() != null) {
            eg egVar = new eg(this.a.getMap());
            AppMethodBeat.o(101553);
            return egVar;
        }
        AppMethodBeat.o(101553);
        return null;
    }

    public MapController getMapController() {
        return this.b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(101554);
        if (this.a.getMap() != null) {
            this.a.getMap().a(new df().a(cn.a(view)).a(ej.a(layoutParams.point)));
        }
        AppMethodBeat.o(101554);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(101555);
        if (this.a != null) {
            this.a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(101555);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.i(101556);
        this.a.a();
        AppMethodBeat.o(101556);
    }

    public void onResume() {
        AppMethodBeat.i(101557);
        this.a.d();
        AppMethodBeat.o(101557);
    }

    public void onPause() {
        AppMethodBeat.i(101558);
        this.a.e();
        AppMethodBeat.o(101558);
    }

    public void onStop() {
        AppMethodBeat.i(101559);
        this.a.b();
        AppMethodBeat.o(101559);
    }

    public void onRestart() {
        AppMethodBeat.i(101560);
        this.a.f();
        AppMethodBeat.o(101560);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.i(101561);
        this.a.c();
        AppMethodBeat.o(101561);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101562);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.o(101562);
            return true;
        }
        AppMethodBeat.o(101562);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101563);
        if (this.a == null) {
            AppMethodBeat.o(101563);
            return false;
        } else if (this.a.dispatchTouchEvent(motionEvent) || this.a.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(101563);
            return true;
        } else {
            AppMethodBeat.o(101563);
            return false;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(101564);
        if (this.a != null) {
            this.a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(101564);
    }
}
