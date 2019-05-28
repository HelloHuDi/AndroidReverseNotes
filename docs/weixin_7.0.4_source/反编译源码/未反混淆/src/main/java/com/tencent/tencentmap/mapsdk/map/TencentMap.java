package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;

public interface TencentMap extends MapController {
    @Deprecated
    public static final int MAP_STYLE_ID_NIGHT = 8;
    public static final int MAP_STYLE_ID_NORMAL = 0;
    public static final String VERSION = "1.1.2";

    public interface OnIndoorStateChangeListener {
        boolean onIndoorBuildingDeactivated();

        boolean onIndoorBuildingFocused();

        boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);

        void onInfoWindowDettached(Marker marker, View view);
    }

    public interface OnErrorListener {
        void collectErrorInfo(String str);
    }

    public interface OnScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapPoiClickListener {
        void onClicked(MapPoi mapPoi);
    }

    public interface TencentMapGestureListener {
        boolean onDoubleTap(float f, float f2);

        boolean onDown(float f, float f2);

        boolean onFling(float f, float f2);

        boolean onLongPress(float f, float f2);

        void onMapStable();

        boolean onScroll(float f, float f2);

        boolean onSingleTap(float f, float f2);

        boolean onUp(float f, float f2);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDraggedListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMapCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    Circle addCircle(CircleOptions circleOptions);

    Marker addMarker(MarkerOptions markerOptions);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback);

    void clearAllOverlays();

    boolean clearCache();

    void enableMultipleInfowindow(boolean z);

    String getActivedIndoorBuilding(LatLng latLng);

    String[] getActivedIndoorFloorNames();

    CameraPosition getCameraPosition();

    String getDebugError();

    int getIndoorFloorId();

    LatLng getMapCenter();

    int getMaxZoomLevel();

    int getMinZoomLevel();

    void getScreenShot(OnScreenShotListener onScreenShotListener);

    void getScreenShot(OnScreenShotListener onScreenShotListener, Rect rect);

    String getVersion();

    int getZoomLevel();

    boolean isAppKeyAvailable();

    boolean isHandDrawMapEnable();

    boolean isSatelliteEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdate cameraUpdate);

    void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void scrollBy(float f, float f2);

    void scrollBy(float f, float f2, long j, CancelableCallback cancelableCallback);

    void set3DEnable(boolean z);

    void setErrorListener(OnErrorListener onErrorListener);

    void setForeignLanguage(Language language);

    void setHandDrawMapEnable(boolean z);

    void setIndoorEnabled(boolean z);

    void setIndoorFloor(int i);

    void setIndoorFloor(String str, String str2);

    void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter);

    void setMapAnchor(float f, float f2);

    void setMapStyle(int i);

    void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapCameraChangeListener(OnMapCameraChangeListener onMapCameraChangeListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMapPoiClickListener(OnMapPoiClickListener onMapPoiClickListener);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDraggedListener(OnMarkerDraggedListener onMarkerDraggedListener);

    void setSatelliteEnabled(boolean z);

    void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setTrafficEnabled(boolean z);

    void stopAnimation();

    void zoomIn();

    void zoomInFixing(int i, int i2);

    void zoomOut();

    void zoomOutFixing(int i, int i2);

    void zoomToSpan(double d, double d2);

    void zoomToSpan(LatLng latLng, LatLng latLng2);
}
