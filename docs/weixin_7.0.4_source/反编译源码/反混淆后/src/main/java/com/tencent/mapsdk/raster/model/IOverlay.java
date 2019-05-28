package com.tencent.mapsdk.raster.model;

public interface IOverlay {
    String getId();

    boolean isVisible();

    void remove();

    void setVisible(boolean z);
}
