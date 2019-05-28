package com.tencent.mapsdk.raster.model;

import java.util.List;

public interface Polygon extends IOverlay {
    boolean contains(LatLng latLng);

    boolean equals(Object obj);

    int getFillColor();

    String getId();

    int getLevel();

    List<LatLng> getPoints();

    int getStrokeColor();

    float getStrokeWidth();

    float getZIndex();

    int hashCode();

    boolean isVisible();

    void remove();

    void setFillColor(int i);

    void setLevel(int i);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
