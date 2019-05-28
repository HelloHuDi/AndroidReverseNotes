package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ej {
    public static db a(LatLng latLng) {
        AppMethodBeat.i(101566);
        if (latLng == null) {
            AppMethodBeat.o(101566);
            return null;
        }
        db dbVar = new db(latLng.getLatitude(), latLng.getLongitude());
        AppMethodBeat.o(101566);
        return dbVar;
    }

    public static LatLng a(db dbVar) {
        AppMethodBeat.i(101567);
        if (dbVar == null) {
            AppMethodBeat.o(101567);
            return null;
        }
        LatLng latLng = new LatLng(dbVar.a, dbVar.b);
        AppMethodBeat.o(101567);
        return latLng;
    }

    public static MapPoi a(dd ddVar) {
        AppMethodBeat.i(101568);
        MapPoi indoorMapPoi;
        if (ddVar == null) {
            AppMethodBeat.o(101568);
            return null;
        } else if (ddVar instanceof cz) {
            cz czVar = (cz) ddVar;
            indoorMapPoi = new IndoorMapPoi(czVar.d(), a(czVar.e()), czVar.a(), czVar.b(), czVar.c());
            AppMethodBeat.o(101568);
            return indoorMapPoi;
        } else {
            indoorMapPoi = new MapPoi(ddVar.d(), a(ddVar.e()));
            AppMethodBeat.o(101568);
            return indoorMapPoi;
        }
    }

    public static List<LatLng> a(List<db> list) {
        AppMethodBeat.i(101569);
        if (list == null) {
            AppMethodBeat.o(101569);
            return null;
        }
        db[] dbVarArr = (db[]) list.toArray(new db[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (db a : dbVarArr) {
            arrayList.add(a(a));
        }
        AppMethodBeat.o(101569);
        return arrayList;
    }

    public static List<db> b(List<LatLng> list) {
        AppMethodBeat.i(101570);
        if (list == null) {
            AppMethodBeat.o(101570);
            return null;
        }
        LatLng[] latLngArr = (LatLng[]) list.toArray(new LatLng[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (LatLng a : latLngArr) {
            arrayList.add(a(a));
        }
        AppMethodBeat.o(101570);
        return arrayList;
    }

    public static cp a(CameraPosition cameraPosition) {
        AppMethodBeat.i(101571);
        if (cameraPosition == null) {
            AppMethodBeat.o(101571);
            return null;
        }
        cp cpVar = new cp(a(cameraPosition.getTarget()), a(cameraPosition.getZoom()), cameraPosition.getSkew(), cameraPosition.getBearing());
        AppMethodBeat.o(101571);
        return cpVar;
    }

    public static CameraPosition a(cp cpVar) {
        AppMethodBeat.i(101572);
        if (cpVar == null) {
            AppMethodBeat.o(101572);
            return null;
        }
        CameraPosition cameraPosition = new CameraPosition(a(cpVar.a), b(cpVar.b), cpVar.c, cpVar.d);
        AppMethodBeat.o(101572);
        return cameraPosition;
    }

    public static VisibleRegion a(do doVar) {
        AppMethodBeat.i(101573);
        if (doVar == null) {
            AppMethodBeat.o(101573);
            return null;
        }
        VisibleRegion visibleRegion = new VisibleRegion(a(doVar.a), a(doVar.b), a(doVar.c), a(doVar.d), a(doVar.e));
        AppMethodBeat.o(101573);
        return visibleRegion;
    }

    public static float a(float f) {
        return f;
    }

    public static float b(float f) {
        return f;
    }

    static dc a(LatLngBounds latLngBounds) {
        AppMethodBeat.i(101574);
        if (latLngBounds == null || latLngBounds.getNortheast() == null || latLngBounds.getSouthwest() == null) {
            AppMethodBeat.o(101574);
            return null;
        }
        dc dcVar = new dc(new db(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude()), new db(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude()));
        AppMethodBeat.o(101574);
        return dcVar;
    }

    static LatLngBounds a(dc dcVar) {
        AppMethodBeat.i(101575);
        if (dcVar == null || dcVar.b == null || dcVar.a == null) {
            AppMethodBeat.o(101575);
            return null;
        }
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(dcVar.a.a, dcVar.a.b), new LatLng(dcVar.b.a, dcVar.b.b));
        AppMethodBeat.o(101575);
        return latLngBounds;
    }

    public static cr a(CircleOptions circleOptions) {
        AppMethodBeat.i(101576);
        if (circleOptions == null) {
            AppMethodBeat.o(101576);
            return null;
        }
        cr crVar = new cr();
        db a = a(circleOptions.getCenter());
        if (a != null) {
            crVar.a(a);
        }
        crVar.a(a(circleOptions.getCenter())).b(circleOptions.getFillColor()).a(circleOptions.getRadius()).a(circleOptions.getStrokeColor()).a(circleOptions.getStrokeWidth() / y.g()).a(circleOptions.isVisible()).c((int) circleOptions.getZIndex()).d(circleOptions.getLevel());
        AppMethodBeat.o(101576);
        return crVar;
    }

    public static df a(MarkerOptions markerOptions) {
        AppMethodBeat.i(101577);
        if (markerOptions == null) {
            AppMethodBeat.o(101577);
            return null;
        }
        db a = a(markerOptions.getPosition());
        if (a == null) {
            AppMethodBeat.o(101577);
            return null;
        }
        df dfVar = new df(a);
        dfVar.b(markerOptions.getAlpha()).b(markerOptions.isVisible()).a(markerOptions.isDraggable()).a(markerOptions.getAnchorU(), markerOptions.getAnchorV()).a(markerOptions.getRotation()).a(a(markerOptions.getIndoorInfo())).c((float) markerOptions.getZIndex()).a(markerOptions.getLevel()).c(markerOptions.isFlat()).d(markerOptions.isFlat() != markerOptions.isClockwise()).a(markerOptions.getInfoWindowOffsetX(), markerOptions.getInfowindowOffsetY()).c(markerOptions.getContentDescription());
        if (markerOptions.getIcon() != null) {
            dfVar.a(cn.a(markerOptions.getIcon().getBitmap()));
        }
        if (markerOptions.getMarkerView() != null) {
            dfVar.a(cn.a(markerOptions.getMarkerView()));
        }
        if (markerOptions.getSnippet() != null) {
            dfVar.b(markerOptions.getSnippet());
        }
        if (markerOptions.getTitle() != null) {
            dfVar.a(markerOptions.getTitle());
        }
        if (markerOptions.getTag() != null) {
            dfVar.a(markerOptions.getTag());
        }
        AppMethodBeat.o(101577);
        return dfVar;
    }

    public static dm a(PolylineOptions polylineOptions) {
        AppMethodBeat.i(101578);
        if (polylineOptions == null) {
            AppMethodBeat.o(101578);
            return null;
        }
        dm dmVar = new dm();
        Iterable b = b(polylineOptions.getPoints());
        if (b == null || b.size() == 0) {
            AppMethodBeat.o(101578);
            return null;
        }
        dmVar.a(b);
        dmVar.d((int) polylineOptions.getZIndex()).f(polylineOptions.getLevel()).a(polylineOptions.getWidth()).a(polylineOptions.isVisible()).a(polylineOptions.getColor()).b(polylineOptions.getEdgeColor()).b(polylineOptions.getEdgeWidth()).e(polylineOptions.getLineType()).c(polylineOptions.getEraseColor()).a(a(polylineOptions.getIndoorInfo()));
        if (polylineOptions.getColorTexture() != null) {
            dmVar.a(cn.a(polylineOptions.getColorTexture().getBitmap()));
        }
        if (polylineOptions.getArrowTexture() != null) {
            dmVar.b(true);
            dmVar.g((int) polylineOptions.getArrowGap());
            Matrix matrix = new Matrix();
            matrix.postRotate(-90.0f);
            try {
                Bitmap bitmap = polylineOptions.getArrowTexture().getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
                dmVar.b(cn.a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true)));
            } catch (Exception e) {
            }
        }
        if (polylineOptions.isDottedLine()) {
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf((int) (3.0f * polylineOptions.getWidth())));
            arrayList.add(Integer.valueOf((int) polylineOptions.getWidth()));
            dmVar.c(arrayList);
        }
        AppMethodBeat.o(101578);
        return dmVar;
    }

    public static dk a(PolygonOptions polygonOptions) {
        AppMethodBeat.i(101579);
        if (polygonOptions == null) {
            AppMethodBeat.o(101579);
            return null;
        }
        dk dkVar = new dk();
        Iterable b = b(polygonOptions.getPoints());
        if (b == null || b.size() <= 2) {
            AppMethodBeat.o(101579);
            return null;
        }
        dkVar.b(b);
        dkVar.a(polygonOptions.isVisible()).c((int) polygonOptions.getZIndex()).d(polygonOptions.getLevel()).a(polygonOptions.getStrokeWidth() / y.g()).a(polygonOptions.getStrokeColor()).b(polygonOptions.getFillColor());
        AppMethodBeat.o(101579);
        return dkVar;
    }

    static ad a(CameraUpdate cameraUpdate, aj ajVar) {
        AppMethodBeat.i(101580);
        if (cameraUpdate == null || cameraUpdate.getParams() == null) {
            AppMethodBeat.o(101580);
            return null;
        }
        CameraParameter params = cameraUpdate.getParams();
        ad a;
        switch (cameraUpdate.getParams().cameraUpdate_type) {
            case 0:
                a = ae.a();
                AppMethodBeat.o(101580);
                return a;
            case 1:
                a = ae.b();
                AppMethodBeat.o(101580);
                return a;
            case 2:
                a = ae.a(params.scrollBy_xPixel, params.scrollBy_yPixel);
                AppMethodBeat.o(101580);
                return a;
            case 3:
                float f = params.zoomTo_zoom < ajVar.f() ? ajVar.f() : params.zoomTo_zoom > ajVar.e() ? ajVar.e() : params.zoomTo_zoom;
                a = ae.a(a(f));
                AppMethodBeat.o(101580);
                return a;
            case 4:
                a = ae.b(params.zoomBy_amount);
                AppMethodBeat.o(101580);
                return a;
            case 5:
                a = ae.a(params.zoomBy_Point_amount, params.zoomBy_Point_focus);
                AppMethodBeat.o(101580);
                return a;
            case 6:
                a = ae.a(a(params.newCameraPosition));
                AppMethodBeat.o(101580);
                return a;
            case 7:
                a = ae.a(a(params.newLatLng));
                AppMethodBeat.o(101580);
                return a;
            case 8:
                a = ae.a(a(params.newLatLngZoom_latlng), a(params.newLatLngZoom_zoom));
                AppMethodBeat.o(101580);
                return a;
            case 9:
                a = ae.a(a(params.newLatLngBounds_bounds), params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding);
                AppMethodBeat.o(101580);
                return a;
            case 10:
                int i;
                int i2;
                int i3;
                int i4;
                if (ajVar == null || ajVar.x() == 0 || ajVar.x() == 0) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    if (params.newLatLngBounds_dimension_width < ajVar.x()) {
                        i = (ajVar.x() / 2) - ((params.newLatLngBounds_dimension_width / 2) - params.newLatLngBounds_dimension_padding);
                        i2 = i;
                        i4 = i;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                    if (params.newLatLngBounds_dimension_height < ajVar.y()) {
                        int y = (ajVar.y() / 2) - ((params.newLatLngBounds_dimension_height / 2) - params.newLatLngBounds_dimension_padding);
                        i = y;
                        i3 = y;
                    } else {
                        i = 0;
                        i3 = 0;
                    }
                }
                a = ae.a(a(params.newLatLngBounds_dimension_bounds), i2, i4, i3, i);
                AppMethodBeat.o(101580);
                return a;
            case 11:
                a = ae.a(a(params.newLatLngBounds_bounds), a(params.newLatLng), params.newLatLngBounds_padding);
                AppMethodBeat.o(101580);
                return a;
            default:
                AppMethodBeat.o(101580);
                return null;
        }
    }

    static IndoorBuilding a(cw cwVar) {
        AppMethodBeat.i(101581);
        if (cwVar == null) {
            AppMethodBeat.o(101581);
            return null;
        }
        List c = c(cwVar.c());
        if (c == null) {
            AppMethodBeat.o(101581);
            return null;
        }
        IndoorBuilding indoorBuilding = new IndoorBuilding(cwVar.a(), cwVar.b(), c, cwVar.d());
        AppMethodBeat.o(101581);
        return indoorBuilding;
    }

    static cx a(IndoorInfo indoorInfo) {
        AppMethodBeat.i(101582);
        if (indoorInfo == null) {
            AppMethodBeat.o(101582);
            return null;
        }
        cx cxVar = new cx(indoorInfo.getBuildingId(), indoorInfo.getFloorName());
        AppMethodBeat.o(101582);
        return cxVar;
    }

    static List<IndoorLevel> c(List<cy> list) {
        AppMethodBeat.i(101583);
        if (list == null) {
            AppMethodBeat.o(101583);
            return null;
        }
        CopyOnWriteArrayList<cy> copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        ArrayList arrayList = new ArrayList();
        for (cy cyVar : copyOnWriteArrayList) {
            if (cyVar == null) {
                AppMethodBeat.o(101583);
                return null;
            }
            arrayList.add(new IndoorLevel(cyVar.a()));
        }
        AppMethodBeat.o(101583);
        return arrayList;
    }

    public static da a(Language language) {
        AppMethodBeat.i(101584);
        da daVar;
        if (language == null) {
            daVar = da.zh;
            AppMethodBeat.o(101584);
            return daVar;
        }
        switch (language) {
            case zh:
                daVar = da.zh;
                AppMethodBeat.o(101584);
                return daVar;
            case en:
                daVar = da.en;
                AppMethodBeat.o(101584);
                return daVar;
            default:
                daVar = da.zh;
                AppMethodBeat.o(101584);
                return daVar;
        }
    }
}
