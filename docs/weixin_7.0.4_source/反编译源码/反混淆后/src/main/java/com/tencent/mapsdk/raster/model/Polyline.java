package com.tencent.mapsdk.raster.model;

import java.util.List;

public interface Polyline extends IOverlay {
    boolean equals(Object obj);

    void eraseTo(int i, LatLng latLng);

    int getColor();

    String getId();

    int getLevel();

    List<LatLng> getPoints();

    float getWidth();

    float getZIndex();

    int hashCode();

    boolean isDottedLine();

    boolean isGeodesic();

    boolean isVisible();

    void remove();

    void setColor(int i);

    void setColorTexture(BitmapDescriptor bitmapDescriptor);

    void setDottedLine(boolean z);

    void setEraseable(boolean z);

    void setGeodesic(boolean z);

    void setLevel(int i);

    void setPoints(List<LatLng> list);

    void setVisible(boolean z);

    void setWidth(float f);

    void setZIndex(float f);
}
