package com.tencent.tencentmap.mapsdk.map;

public interface UiSettings {
    @Deprecated
    public static final int LOGO_POSITION_CENTER_BOTTOM = 4;
    @Deprecated
    public static final int LOGO_POSITION_CENTER_TOP = 5;
    public static final int LOGO_POSITION_LEFT_BOTTOM = 0;
    public static final int LOGO_POSITION_LEFT_TOP = 3;
    public static final int LOGO_POSITION_RIGHT_BOTTOM = 1;
    public static final int LOGO_POSITION_RIGHT_TOP = 2;
    public static final int SCALEVIEW_POSITION_CENTER_BOTTOM = 1;
    public static final int SCALEVIEW_POSITION_LEFT_BOTTOM = 0;
    public static final int SCALEVIEW_POSITION_RIGHT_BOTTOM = 2;

    boolean isAnimationEnabled();

    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleControlsEnabled();

    boolean isTiltGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setAnimationEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setIndoorLevelPickerEnabled(boolean z);

    void setLogoPosition(int i);

    void setLogoPosition(int i, int[] iArr);

    void setLogoScale(float f);

    void setRotateGesturesEnabled(boolean z);

    void setScaleControlsEnabled(boolean z);

    void setScaleViewPosition(int i);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);
}
