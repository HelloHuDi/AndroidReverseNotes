package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Point;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;

public interface fw {
    double a(double d);

    double a(Point point, Point point2);

    GeoPoint a(DoublePoint doublePoint);

    DoublePoint b(GeoPoint geoPoint);
}
