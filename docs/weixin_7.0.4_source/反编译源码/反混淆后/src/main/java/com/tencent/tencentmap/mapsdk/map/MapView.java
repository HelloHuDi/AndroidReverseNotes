package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.dynamic.C16204b;
import com.tencent.tencentmap.mapsdk.p666a.C24351y;
import com.tencent.tencentmap.mapsdk.p666a.C36479j;

public class MapView extends FrameLayout implements IMapView {
    private C16204b mMapProvider;
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
        AppMethodBeat.m2504i(101294);
        this.mMapType = 1;
        init(null);
        AppMethodBeat.m2505o(101294);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        AppMethodBeat.m2504i(101295);
        this.mMapType = 1;
        init(tencentMapOptions);
        AppMethodBeat.m2505o(101295);
    }

    private void init(TencentMapOptions tencentMapOptions) {
        AppMethodBeat.m2504i(101296);
        Context context = getContext();
        this.mMapProvider = new C16204b();
        C24351y.m37628a(context.getApplicationContext());
        C36479j.m60319a(context.getApplicationContext());
        this.mapView = this.mMapProvider.mo29203a(context.getApplicationContext(), tencentMapOptions);
        if (this.mapView != null) {
            addView(this.mapView.getMapView(), new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
        AppMethodBeat.m2505o(101296);
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101297);
        if (this.mapView == null || layoutParams == null) {
            AppMethodBeat.m2505o(101297);
            return;
        }
        this.mapView.addView(view, layoutParams);
        AppMethodBeat.m2505o(101297);
    }

    public TencentMap getMap() {
        AppMethodBeat.m2504i(101298);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101298);
            return null;
        }
        TencentMap map = this.mapView.getMap();
        AppMethodBeat.m2505o(101298);
        return map;
    }

    public View getMapView() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(101299);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101299);
            return;
        }
        this.mapView.onCreate(bundle);
        AppMethodBeat.m2505o(101299);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101300);
        boolean onTouchEvent;
        if (this.mapView != null) {
            onTouchEvent = this.mapView.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(101300);
            return onTouchEvent;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(101300);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101301);
        this.mapView.dispatchTouchEvent(motionEvent);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(101301);
        return dispatchTouchEvent;
    }

    public void onStart() {
        AppMethodBeat.m2504i(101302);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101302);
            return;
        }
        this.mapView.onStart();
        AppMethodBeat.m2505o(101302);
    }

    public void onResume() {
        AppMethodBeat.m2504i(101303);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101303);
            return;
        }
        this.mapView.onResume();
        AppMethodBeat.m2505o(101303);
    }

    public void onPause() {
        AppMethodBeat.m2504i(101304);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101304);
            return;
        }
        this.mapView.onPause();
        AppMethodBeat.m2505o(101304);
    }

    public void onStop() {
        AppMethodBeat.m2504i(101305);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101305);
            return;
        }
        this.mapView.onStop();
        AppMethodBeat.m2505o(101305);
    }

    public void onRestart() {
        AppMethodBeat.m2504i(101306);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101306);
            return;
        }
        this.mapView.onRestart();
        AppMethodBeat.m2505o(101306);
    }

    public void onDestroyView() {
        AppMethodBeat.m2504i(101307);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101307);
            return;
        }
        this.mapView.onDestroyView();
        AppMethodBeat.m2505o(101307);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101308);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101308);
            return;
        }
        this.mapView.onDestroy();
        AppMethodBeat.m2505o(101308);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(101309);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101309);
            return;
        }
        this.mapView.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(101309);
    }

    public void onLowMemory() {
        AppMethodBeat.m2504i(101310);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101310);
            return;
        }
        this.mapView.onLowMemory();
        AppMethodBeat.m2505o(101310);
    }

    public Projection getProjection() {
        AppMethodBeat.m2504i(101311);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101311);
            return null;
        }
        Projection projection = this.mapView.getProjection();
        AppMethodBeat.m2505o(101311);
        return projection;
    }

    public MapController getMapController() {
        AppMethodBeat.m2504i(101312);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101312);
            return null;
        }
        MapController mapController = this.mapView.getMapController();
        AppMethodBeat.m2505o(101312);
        return mapController;
    }

    @Deprecated
    public LatLng getMapCenter() {
        AppMethodBeat.m2504i(101313);
        if (this.mapView == null || this.mapView.getMap() == null) {
            AppMethodBeat.m2505o(101313);
            return null;
        }
        LatLng mapCenter = this.mapView.getMap().getMapCenter();
        AppMethodBeat.m2505o(101313);
        return mapCenter;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.m2504i(101314);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101314);
            return null;
        }
        UiSettings uiSettings = this.mapView.getUiSettings();
        AppMethodBeat.m2505o(101314);
        return uiSettings;
    }

    public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101315);
        if (this.mapView == null) {
            AppMethodBeat.m2505o(101315);
            return;
        }
        this.mapView.updateViewLayout(view, layoutParams);
        AppMethodBeat.m2505o(101315);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(101316);
        if (this.mapView != null) {
            this.mapView.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(101316);
    }
}
