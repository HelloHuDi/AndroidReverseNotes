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

public class ec implements IMapView {
    private ah a;
    private TencentMap b;

    public ec(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(101364);
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
        this.a = new ah(context, akVar);
        this.b = new eh(this.a.getMap());
        this.a.getMap().l().a(false);
        AppMethodBeat.o(101364);
    }

    public View getMapView() {
        return this.a;
    }

    public TencentMap getMap() {
        return this.b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.i(101365);
        if (this.a.getMap() != null) {
            ek ekVar = new ek(this.a.getMap().l());
            AppMethodBeat.o(101365);
            return ekVar;
        }
        AppMethodBeat.o(101365);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.i(101366);
        if (this.a.getMap() != null) {
            eg egVar = new eg(this.a.getMap());
            AppMethodBeat.o(101366);
            return egVar;
        }
        AppMethodBeat.o(101366);
        return null;
    }

    public MapController getMapController() {
        return this.b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(101367);
        if (this.a.getMap() != null) {
            this.a.getMap().a(new df().a(cn.a(view)).a(ej.a(layoutParams.point)));
        }
        AppMethodBeat.o(101367);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(101368);
        if (this.a != null) {
            this.a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.o(101368);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.i(101369);
        this.a.a();
        AppMethodBeat.o(101369);
    }

    public void onResume() {
        AppMethodBeat.i(101370);
        this.a.d();
        AppMethodBeat.o(101370);
    }

    public void onPause() {
        AppMethodBeat.i(101371);
        this.a.e();
        AppMethodBeat.o(101371);
    }

    public void onStop() {
        AppMethodBeat.i(101372);
        this.a.b();
        AppMethodBeat.o(101372);
    }

    public void onRestart() {
        AppMethodBeat.i(101373);
        this.a.f();
        AppMethodBeat.o(101373);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.i(101374);
        this.a.c();
        AppMethodBeat.o(101374);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101375);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.o(101375);
            return true;
        }
        AppMethodBeat.o(101375);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101376);
        if (this.a == null) {
            AppMethodBeat.o(101376);
            return false;
        } else if (this.a.dispatchTouchEvent(motionEvent) || this.a.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(101376);
            return true;
        } else {
            AppMethodBeat.o(101376);
            return false;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(101377);
        if (this.a != null) {
            this.a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(101377);
    }
}
