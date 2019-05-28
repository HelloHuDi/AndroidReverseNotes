package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;

public interface Projection {
    double distanceBetween(LatLng latLng, LatLng latLng2);

    LatLng fromScreenLocation(Point point);

    double getLatitudeSpan();

    double getLongitudeSpan();

    float getScalePerPixel();

    VisibleRegion getVisibleRegion();

    float metersToEquatorPixels(float f);

    float metersToPixels(double d, double d2);

    @Deprecated
    Point toPixels(GeoPoint geoPoint, Point point);

    Point toScreenLocation(LatLng latLng);
}
