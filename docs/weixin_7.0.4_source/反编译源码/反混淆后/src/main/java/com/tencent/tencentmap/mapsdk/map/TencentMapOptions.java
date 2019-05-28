package com.tencent.tencentmap.mapsdk.map;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapOptions {
    public static final int GL_MAP_VIEW = 0;
    public static final int MAP_RENDER_LAYER = 2;
    public static final int TEXTURE_MAP_VIEW = 1;
    private boolean enableHandDrawMap = false;
    private boolean isMutipleInfowindowEnabled = false;
    private Object mExtSurface;
    private int mExtSurfaceHeight;
    private int mExtSurfaceWidth;
    private int mMapType = 0;
    private String mSubId;
    private String mSubKey;

    public void setMapType(int i) {
        if (i >= 0 && i <= 2) {
            this.mMapType = i;
        }
    }

    public int getMapType() {
        return this.mMapType;
    }

    public Object getExtSurface() {
        return this.mExtSurface;
    }

    public void setExtSurface(Object obj) {
        this.mExtSurface = obj;
    }

    public final void setExtSurfaceDimension(int i, int i2) {
        this.mExtSurfaceWidth = i;
        this.mExtSurfaceHeight = i2;
    }

    public final int getExtSurfaceWidth() {
        return this.mExtSurfaceWidth;
    }

    public final int getExtSurfaceHeight() {
        return this.mExtSurfaceHeight;
    }

    @Deprecated
    public TencentMapOptions enableHandDrawMap(boolean z) {
        AppMethodBeat.m2504i(101328);
        setHandDrawMapEnable(z);
        AppMethodBeat.m2505o(101328);
        return this;
    }

    public void setHandDrawMapEnable(boolean z) {
        this.enableHandDrawMap = z;
    }

    public boolean isHandDrawMapEnable() {
        return this.enableHandDrawMap;
    }

    public final void setSubInfo(String str, String str2) {
        this.mSubId = str2;
        this.mSubKey = str;
    }

    public final String getSubId() {
        return this.mSubId;
    }

    public final String getSubKey() {
        return this.mSubKey;
    }

    public boolean isMutipleInfowindowEnabled() {
        return this.isMutipleInfowindowEnabled;
    }

    public void setMutipleInfowindowEnabled(boolean z) {
        this.isMutipleInfowindowEnabled = z;
    }
}
