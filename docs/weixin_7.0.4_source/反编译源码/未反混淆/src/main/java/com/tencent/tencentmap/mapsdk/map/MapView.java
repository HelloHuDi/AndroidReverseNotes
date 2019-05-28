package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.y;
import com.tencent.tencentmap.mapsdk.dynamic.b;

public class MapView extends FrameLayout implements IMapView {
    private b mMapProvider;
    private int mMapType;
    private Projection mProjection;
    private UiSettings mUiSettings;
    private IMapView mapView;

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public static final int BOTTOM_CENTER = 81;
        public static final int CENTER = 17;
        public int alignment = 17;
        public int height = 0;
        public LatLng point = null;
        public int width = 0;

        public LayoutParams(int i, int i2, LatLng latLng, int i3) {
            super(i, i2);
            this.width = i;
            this.height = i2;
            this.point = latLng;
            this.alignment = i3;
        }
    }

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(101294);
        this.mMapType = 1;
        init(null);
        AppMethodBeat.o(101294);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        AppMethodBeat.i(101295);
        this.mMapType = 1;
        init(tencentMapOptions);
        AppMethodBeat.o(101295);
    }

    private void init(TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(101296);
        Context context = getContext();
        this.mMapProvider = new b();
        y.a(context.getApplicationContext());
        j.a(context.getApplicationContext());
        this.mapView = this.mMapProvider.a(context.getApplicationContext(), tencentMapOptions);
        if (this.mapView != null) {
            addView(this.mapView.getMapView(), new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
        AppMethodBeat.o(101296);
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(101297);
        if (this.mapView == null || layoutParams == null) {
            AppMethodBeat.o(101297);
            return;
        }
        this.mapView.addView(view, layoutParams);
        AppMethodBeat.o(101297);
    }

    public TencentMap getMap() {
        AppMethodBeat.i(101298);
        if (this.mapView == null) {
            AppMethodBeat.o(101298);
            return null;
        }
        TencentMap map = this.mapView.getMap();
        AppMethodBeat.o(101298);
        return map;
    }

    public View getMapView() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(101299);
        if (this.mapView == null) {
            AppMethodBeat.o(101299);
            return;
        }
        this.mapView.onCreate(bundle);
        AppMethodBeat.o(101299);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101300);
        boolean onTouchEvent;
        if (this.mapView != null) {
            onTouchEvent = this.mapView.onTouchEvent(motionEvent);
            AppMethodBeat.o(101300);
            return onTouchEvent;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(101300);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(101301);
        this.mapView.dispatchTouchEvent(motionEvent);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(101301);
        return dispatchTouchEvent;
    }

    public void onStart() {
        AppMethodBeat.i(101302);
        if (this.mapView == null) {
            AppMethodBeat.o(101302);
            return;
        }
        this.mapView.onStart();
        AppMethodBeat.o(101302);
    }

    public void onResume() {
        AppMethodBeat.i(101303);
        if (this.mapView == null) {
            AppMethodBeat.o(101303);
            return;
        }
        this.mapView.onResume();
        AppMethodBeat.o(101303);
    }

    public void onPause() {
        AppMethodBeat.i(101304);
        if (this.mapView == null) {
            AppMethodBeat.o(101304);
            return;
        }
        this.mapView.onPause();
        AppMethodBeat.o(101304);
    }

    public void onStop() {
        AppMethodBeat.i(101305);
        if (this.mapView == null) {
            AppMethodBeat.o(101305);
            return;
        }
        this.mapView.onStop();
        AppMethodBeat.o(101305);
    }

    public void onRestart() {
        AppMethodBeat.i(101306);
        if (this.mapView == null) {
            AppMethodBeat.o(101306);
            return;
        }
        this.mapView.onRestart();
        AppMethodBeat.o(101306);
    }

    public void onDestroyView() {
        AppMethodBeat.i(101307);
        if (this.mapView == null) {
            AppMethodBeat.o(101307);
            return;
        }
        this.mapView.onDestroyView();
        AppMethodBeat.o(101307);
    }

    public void onDestroy() {
        AppMethodBeat.i(101308);
        if (this.mapView == null) {
            AppMethodBeat.o(101308);
            return;
        }
        this.mapView.onDestroy();
        AppMethodBeat.o(101308);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(101309);
        if (this.mapView == null) {
            AppMethodBeat.o(101309);
            return;
        }
        this.mapView.onSaveInstanceState(bundle);
        AppMethodBeat.o(101309);
    }

    public void onLowMemory() {
        AppMethodBeat.i(101310);
        if (this.mapView == null) {
            AppMethodBeat.o(101310);
            return;
        }
        this.mapView.onLowMemory();
        AppMethodBeat.o(101310);
    }

    public Projection getProjection() {
        AppMethodBeat.i(101311);
        if (this.mapView == null) {
            AppMethodBeat.o(101311);
            return null;
        }
        Projection projection = this.mapView.getProjection();
        AppMethodBeat.o(101311);
        return projection;
    }

    public MapController getMapController() {
        AppMethodBeat.i(101312);
        if (this.mapView == null) {
            AppMethodBeat.o(101312);
            return null;
        }
        MapController mapController = this.mapView.getMapController();
        AppMethodBeat.o(101312);
        return mapController;
    }

    @Deprecated
    public LatLng getMapCenter() {
        AppMethodBeat.i(101313);
        if (this.mapView == null || this.mapView.getMap() == null) {
            AppMethodBeat.o(101313);
            return null;
        }
        LatLng mapCenter = this.mapView.getMap().getMapCenter();
        AppMethodBeat.o(101313);
        return mapCenter;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.i(101314);
        if (this.mapView == null) {
            AppMethodBeat.o(101314);
            return null;
        }
        UiSettings uiSettings = this.mapView.getUiSettings();
        AppMethodBeat.o(101314);
        return uiSettings;
    }

    public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(101315);
        if (this.mapView == null) {
            AppMethodBeat.o(101315);
            return;
        }
        this.mapView.updateViewLayout(view, layoutParams);
        AppMethodBeat.o(101315);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(101316);
        if (this.mapView != null) {
            this.mapView.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.o(101316);
    }
}
