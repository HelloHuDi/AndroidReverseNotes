package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions {
    private int fillColor = WebView.NIGHT_MODE_COLOR;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    private boolean isVisible = true;
    private final List<LatLng> points = new ArrayList();
    private int strokeColor = WebView.NIGHT_MODE_COLOR;
    private float strokeWidth = 10.0f;
    private float zIndex = 0.0f;

    public PolygonOptions() {
        AppMethodBeat.m2504i(101216);
        AppMethodBeat.m2505o(101216);
    }

    public final PolygonOptions add(LatLng latLng) {
        AppMethodBeat.m2504i(101217);
        if (latLng == null) {
            AppMethodBeat.m2505o(101217);
        } else {
            this.points.add(latLng);
            AppMethodBeat.m2505o(101217);
        }
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        AppMethodBeat.m2504i(101218);
        if (latLngArr == null) {
            AppMethodBeat.m2505o(101218);
        } else {
            this.points.addAll(Arrays.asList(latLngArr));
            AppMethodBeat.m2505o(101218);
        }
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        AppMethodBeat.m2504i(101219);
        if (iterable == null) {
            AppMethodBeat.m2505o(101219);
        } else {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
            AppMethodBeat.m2505o(101219);
        }
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.strokeWidth = f;
        return this;
    }

    public final PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final PolygonOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public final PolygonOptions level(int i) {
        if (i >= OverlayLevel.OverlayLevelAboveRoads && i <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i;
        }
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getFillColor() {
        return this.fillColor;
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
}
