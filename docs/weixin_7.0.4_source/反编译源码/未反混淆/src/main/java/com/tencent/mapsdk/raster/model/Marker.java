package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public interface Marker extends IOverlay {
    boolean equals(Object obj);

    float getAlpha();

    String getContentDescription();

    String getId();

    int getLevel();

    View getMarkerView();

    LatLng getPosition();

    float getRotation();

    String getSnippet();

    Object getTag();

    String getTitle();

    float getZIndex();

    int hashCode();

    void hideInfoWindow();

    boolean isDraggable();

    boolean isInfoWindowShown();

    boolean isVisible();

    void remove();

    void set2Top();

    void setAlpha(float f);

    void setAnchor(float f, float f2);

    void setContentDescription(String str);

    void setDraggable(boolean z);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setInfoWindowHideAnimation(Animation animation);

    void setInfoWindowShowAnimation(Animation animation);

    void setLevel(int i);

    void setMarkerView(View view);

    void setPosition(LatLng latLng);

    void setRotation(float f);

    void setSnippet(String str);

    void setTag(Object obj);

    void setTitle(String str);

    void setVisible(boolean z);

    void setZIndex(float f);

    void showInfoWindow();
}
