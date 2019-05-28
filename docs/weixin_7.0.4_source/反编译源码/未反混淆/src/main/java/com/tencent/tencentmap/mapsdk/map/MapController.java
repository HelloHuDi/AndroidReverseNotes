package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.LatLng;

@Deprecated
public interface MapController {
    @Deprecated
    void animateTo(LatLng latLng);

    @Deprecated
    void animateTo(LatLng latLng, long j, CancelableCallback cancelableCallback);

    @Deprecated
    void animateTo(LatLng latLng, Runnable runnable);

    @Deprecated
    void setCenter(LatLng latLng);

    @Deprecated
    void setZoom(int i);

    void zoomToSpan(double d, double d2);

    void zoomToSpan(LatLng latLng, LatLng latLng2);
}
