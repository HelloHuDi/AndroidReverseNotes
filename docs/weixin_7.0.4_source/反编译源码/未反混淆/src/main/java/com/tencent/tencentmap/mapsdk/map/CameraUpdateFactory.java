package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        AppMethodBeat.i(101282);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 0;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101282);
        return cameraUpdate;
    }

    public static CameraUpdate zoomOut() {
        AppMethodBeat.i(101283);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 1;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101283);
        return cameraUpdate;
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        AppMethodBeat.i(101284);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 2;
        cameraParameter.scrollBy_xPixel = f;
        cameraParameter.scrollBy_yPixel = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101284);
        return cameraUpdate;
    }

    public static CameraUpdate zoomTo(float f) {
        AppMethodBeat.i(101285);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 3;
        cameraParameter.zoomTo_zoom = f;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101285);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f) {
        AppMethodBeat.i(101286);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 4;
        cameraParameter.zoomBy_amount = f;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101286);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        AppMethodBeat.i(101287);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 5;
        cameraParameter.zoomBy_Point_amount = f;
        cameraParameter.zoomBy_Point_focus = point;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101287);
        return cameraUpdate;
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        AppMethodBeat.i(101288);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 6;
        cameraParameter.newCameraPosition = cameraPosition;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101288);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        AppMethodBeat.i(101289);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 7;
        cameraParameter.newLatLng = latLng;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101289);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        AppMethodBeat.i(101290);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 8;
        cameraParameter.newLatLngZoom_latlng = latLng;
        cameraParameter.newLatLngZoom_zoom = f;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101290);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        AppMethodBeat.i(101291);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 9;
        cameraParameter.newLatLngBounds_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_padding = i;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101291);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        AppMethodBeat.i(101292);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 10;
        cameraParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_dimension_width = i;
        cameraParameter.newLatLngBounds_dimension_height = i2;
        cameraParameter.newLatLngBounds_dimension_padding = i3;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101292);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds latLngBounds, LatLng latLng, int i) {
        AppMethodBeat.i(101293);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 11;
        cameraParameter.newLatLngBounds_bounds = latLngBounds;
        cameraParameter.newLatLng = latLng;
        cameraParameter.newLatLngBounds_padding = i;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(101293);
        return cameraUpdate;
    }
}
