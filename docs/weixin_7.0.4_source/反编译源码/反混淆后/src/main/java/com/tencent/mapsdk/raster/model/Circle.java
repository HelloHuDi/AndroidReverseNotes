package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;

public interface Circle extends IOverlay {
    boolean contains(LatLng latLng);

    boolean equals(Object obj);

    LatLng getCenter();

    int getFillColor();

    String getId();

    int getLevel();

    double getRadius();

    int getStrokeColor();

    boolean getStrokeDash();

    DashPathEffect getStrokeDashPathEffect();

    float getStrokeWidth();

    float getZIndex();

    int hashCode();

    boolean isVisible();

    void remove();

    void setCenter(LatLng latLng);

    void setFillColor(int i);

    void setLevel(int i);

    void setRadius(double d);

    void setStrokeColor(int i);

    void setStrokeDash(boolean z);

    void setStrokeWidth(float f);

    void setVisible(boolean z);

    void setZIndex(float f);

    void strokeDashPathEffect(DashPathEffect dashPathEffect);
}
