package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions {
    public static final int LINE_TYPE_DOTTEDLINE = 2;
    public static final int LINE_TYPE_MULTICOLORLINE = 0;
    private float arrowGap = 90.0f;
    private BitmapDescriptor arrowTexture;
    private int color = WebView.NIGHT_MODE_COLOR;
    private BitmapDescriptor colorTexture = null;
    private int edgeColor = -983041;
    private float edgeWidth = 0.0f;
    private int eraseColor = -7829368;
    private int iLevel = OverlayLevel.OverlayLevelAboveRoads;
    private boolean isDottedLine = false;
    private boolean isGeodesic = false;
    private boolean isVisible = true;
    private int lineType = 0;
    private IndoorInfo mIndoorInfo;
    private final List<LatLng> points = new ArrayList();
    private float width = 10.0f;
    private float zIndex = 0.0f;

    public static final class Colors {
        public static final int DARK_BLUE = 6;
        public static final int GRAYBLUE = 8;
        public static final int GREEN = 4;
        public static final int GREY = 0;
        public static final int LIGHT_BLUE = 1;
        public static final int LIVER_RED = 9;
        public static final int MID_BLUE = 5;
        public static final int RED = 2;
        public static final int TRANSPARENT = 7;
        public static final int YELLOW = 3;
    }

    public final PolylineOptions arrowGap(float f) {
        if (f > 0.0f) {
            this.arrowGap = f;
        }
        return this;
    }

    public final PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.arrowTexture = bitmapDescriptor;
        }
        return this;
    }

    public final BitmapDescriptor getArrowTexture() {
        return this.arrowTexture;
    }

    public final PolylineOptions edgeWidth(float f) {
        if (f > 0.0f) {
            this.edgeWidth = f;
        }
        return this;
    }

    public final float getEdgeWidth() {
        return this.edgeWidth;
    }

    public final PolylineOptions edgeColor(int i) {
        this.edgeColor = i;
        return this;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final float getArrowGap() {
        return this.arrowGap;
    }

    public PolylineOptions() {
        AppMethodBeat.m2504i(101220);
        AppMethodBeat.m2505o(101220);
    }

    public final PolylineOptions add(LatLng latLng) {
        AppMethodBeat.m2504i(101221);
        if (latLng == null) {
            AppMethodBeat.m2505o(101221);
        } else {
            this.points.add(latLng);
            AppMethodBeat.m2505o(101221);
        }
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        AppMethodBeat.m2504i(101222);
        if (latLngArr == null) {
            AppMethodBeat.m2505o(101222);
        } else {
            this.points.addAll(Arrays.asList(latLngArr));
            AppMethodBeat.m2505o(101222);
        }
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        AppMethodBeat.m2504i(101223);
        if (iterable == null) {
            AppMethodBeat.m2505o(101223);
        } else {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
            AppMethodBeat.m2505o(101223);
        }
        return this;
    }

    public final PolylineOptions width(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.width = f;
        return this;
    }

    public final PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final PolylineOptions eraseColor(int i) {
        this.eraseColor = i;
        return this;
    }

    public final int getEraseColor() {
        return this.eraseColor;
    }

    public final PolylineOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public final PolylineOptions level(int i) {
        if (i >= OverlayLevel.OverlayLevelAboveRoads && i <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i;
        }
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.isGeodesic = z;
        return this;
    }

    public final PolylineOptions lineType(int i) {
        this.lineType = i;
        return this;
    }

    public final PolylineOptions colorTexture(BitmapDescriptor bitmapDescriptor) {
        this.colorTexture = bitmapDescriptor;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getWidth() {
        return this.width;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final int getLevel() {
        return this.iLevel;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.isDottedLine = z;
        return this;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }

    public final int getLineType() {
        return this.lineType;
    }

    public final BitmapDescriptor getColorTexture() {
        return this.colorTexture;
    }

    public final IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public final PolylineOptions indoorInfo(IndoorInfo indoorInfo) {
        this.mIndoorInfo = indoorInfo;
        return this;
    }
}
