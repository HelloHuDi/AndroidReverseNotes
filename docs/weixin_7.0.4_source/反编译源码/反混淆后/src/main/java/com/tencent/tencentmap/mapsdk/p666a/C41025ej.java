package com.tencent.tencentmap.mapsdk.p666a;

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

/* renamed from: com.tencent.tencentmap.mapsdk.a.ej */
public class C41025ej {
    /* renamed from: a */
    public static C24343db m71291a(LatLng latLng) {
        AppMethodBeat.m2504i(101566);
        if (latLng == null) {
            AppMethodBeat.m2505o(101566);
            return null;
        }
        C24343db c24343db = new C24343db(latLng.getLatitude(), latLng.getLongitude());
        AppMethodBeat.m2505o(101566);
        return c24343db;
    }

    /* renamed from: a */
    public static LatLng m71282a(C24343db c24343db) {
        AppMethodBeat.m2504i(101567);
        if (c24343db == null) {
            AppMethodBeat.m2505o(101567);
            return null;
        }
        LatLng latLng = new LatLng(c24343db.f4615a, c24343db.f4616b);
        AppMethodBeat.m2505o(101567);
        return latLng;
    }

    /* renamed from: a */
    public static MapPoi m71284a(C24346dd c24346dd) {
        AppMethodBeat.m2504i(101568);
        MapPoi indoorMapPoi;
        if (c24346dd == null) {
            AppMethodBeat.m2505o(101568);
            return null;
        } else if (c24346dd instanceof C16191cz) {
            C16191cz c16191cz = (C16191cz) c24346dd;
            indoorMapPoi = new IndoorMapPoi(c16191cz.mo40485d(), C41025ej.m71282a(c16191cz.mo40486e()), c16191cz.mo29138a(), c16191cz.mo29139b(), c16191cz.mo29140c());
            AppMethodBeat.m2505o(101568);
            return indoorMapPoi;
        } else {
            indoorMapPoi = new MapPoi(c24346dd.mo40485d(), C41025ej.m71282a(c24346dd.mo40486e()));
            AppMethodBeat.m2505o(101568);
            return indoorMapPoi;
        }
    }

    /* renamed from: a */
    public static List<LatLng> m71296a(List<C24343db> list) {
        AppMethodBeat.m2504i(101569);
        if (list == null) {
            AppMethodBeat.m2505o(101569);
            return null;
        }
        C24343db[] c24343dbArr = (C24343db[]) list.toArray(new C24343db[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (C24343db a : c24343dbArr) {
            arrayList.add(C41025ej.m71282a(a));
        }
        AppMethodBeat.m2505o(101569);
        return arrayList;
    }

    /* renamed from: b */
    public static List<C24343db> m71298b(List<LatLng> list) {
        AppMethodBeat.m2504i(101570);
        if (list == null) {
            AppMethodBeat.m2505o(101570);
            return null;
        }
        LatLng[] latLngArr = (LatLng[]) list.toArray(new LatLng[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (LatLng a : latLngArr) {
            arrayList.add(C41025ej.m71291a(a));
        }
        AppMethodBeat.m2505o(101570);
        return arrayList;
    }

    /* renamed from: a */
    public static C5841cp m71287a(CameraPosition cameraPosition) {
        AppMethodBeat.m2504i(101571);
        if (cameraPosition == null) {
            AppMethodBeat.m2505o(101571);
            return null;
        }
        C5841cp c5841cp = new C5841cp(C41025ej.m71291a(cameraPosition.getTarget()), C41025ej.m71279a(cameraPosition.getZoom()), cameraPosition.getSkew(), cameraPosition.getBearing());
        AppMethodBeat.m2505o(101571);
        return c5841cp;
    }

    /* renamed from: a */
    public static CameraPosition m71280a(C5841cp c5841cp) {
        AppMethodBeat.m2504i(101572);
        if (c5841cp == null) {
            AppMethodBeat.m2505o(101572);
            return null;
        }
        CameraPosition cameraPosition = new CameraPosition(C41025ej.m71282a(c5841cp.f1462a), C41025ej.m71297b(c5841cp.f1463b), c5841cp.f1464c, c5841cp.f1465d);
        AppMethodBeat.m2505o(101572);
        return cameraPosition;
    }

    /* renamed from: a */
    public static VisibleRegion m71285a(C46759do c46759do) {
        AppMethodBeat.m2504i(101573);
        if (c46759do == null) {
            AppMethodBeat.m2505o(101573);
            return null;
        }
        VisibleRegion visibleRegion = new VisibleRegion(C41025ej.m71282a(c46759do.f18041a), C41025ej.m71282a(c46759do.f18042b), C41025ej.m71282a(c46759do.f18043c), C41025ej.m71282a(c46759do.f18044d), C41025ej.m71283a(c46759do.f18045e));
        AppMethodBeat.m2505o(101573);
        return visibleRegion;
    }

    /* renamed from: a */
    public static float m71279a(float f) {
        return f;
    }

    /* renamed from: b */
    public static float m71297b(float f) {
        return f;
    }

    /* renamed from: a */
    static C24345dc m71292a(LatLngBounds latLngBounds) {
        AppMethodBeat.m2504i(101574);
        if (latLngBounds == null || latLngBounds.getNortheast() == null || latLngBounds.getSouthwest() == null) {
            AppMethodBeat.m2505o(101574);
            return null;
        }
        C24345dc c24345dc = new C24345dc(new C24343db(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude()), new C24343db(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude()));
        AppMethodBeat.m2505o(101574);
        return c24345dc;
    }

    /* renamed from: a */
    static LatLngBounds m71283a(C24345dc c24345dc) {
        AppMethodBeat.m2504i(101575);
        if (c24345dc == null || c24345dc.f4618b == null || c24345dc.f4617a == null) {
            AppMethodBeat.m2505o(101575);
            return null;
        }
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(c24345dc.f4617a.f4615a, c24345dc.f4617a.f4616b), new LatLng(c24345dc.f4618b.f4615a, c24345dc.f4618b.f4616b));
        AppMethodBeat.m2505o(101575);
        return latLngBounds;
    }

    /* renamed from: a */
    public static C5844cr m71288a(CircleOptions circleOptions) {
        AppMethodBeat.m2504i(101576);
        if (circleOptions == null) {
            AppMethodBeat.m2505o(101576);
            return null;
        }
        C5844cr c5844cr = new C5844cr();
        C24343db a = C41025ej.m71291a(circleOptions.getCenter());
        if (a != null) {
            c5844cr.mo12355a(a);
        }
        c5844cr.mo12355a(C41025ej.m71291a(circleOptions.getCenter())).mo12359b(circleOptions.getFillColor()).mo12352a(circleOptions.getRadius()).mo12354a(circleOptions.getStrokeColor()).mo12353a(circleOptions.getStrokeWidth() / C24351y.m37638g()).mo12356a(circleOptions.isVisible()).mo12361c((int) circleOptions.getZIndex()).mo12363d(circleOptions.getLevel());
        AppMethodBeat.m2505o(101576);
        return c5844cr;
    }

    /* renamed from: a */
    public static C44491df m71293a(MarkerOptions markerOptions) {
        AppMethodBeat.m2504i(101577);
        if (markerOptions == null) {
            AppMethodBeat.m2505o(101577);
            return null;
        }
        C24343db a = C41025ej.m71291a(markerOptions.getPosition());
        if (a == null) {
            AppMethodBeat.m2505o(101577);
            return null;
        }
        C44491df c44491df = new C44491df(a);
        c44491df.mo70777b(markerOptions.getAlpha()).mo70779b(markerOptions.isVisible()).mo70774a(markerOptions.isDraggable()).mo70766a(markerOptions.getAnchorU(), markerOptions.getAnchorV()).mo70765a(markerOptions.getRotation()).mo70770a(C41025ej.m71289a(markerOptions.getIndoorInfo())).mo70780c((float) markerOptions.getZIndex()).mo70767a(markerOptions.getLevel()).mo70782c(markerOptions.isFlat()).mo70784d(markerOptions.isFlat() != markerOptions.isClockwise()).mo70768a(markerOptions.getInfoWindowOffsetX(), markerOptions.getInfowindowOffsetY()).mo70781c(markerOptions.getContentDescription());
        if (markerOptions.getIcon() != null) {
            c44491df.mo70769a(C5839cn.m8915a(markerOptions.getIcon().getBitmap()));
        }
        if (markerOptions.getMarkerView() != null) {
            c44491df.mo70769a(C5839cn.m8916a(markerOptions.getMarkerView()));
        }
        if (markerOptions.getSnippet() != null) {
            c44491df.mo70778b(markerOptions.getSnippet());
        }
        if (markerOptions.getTitle() != null) {
            c44491df.mo70773a(markerOptions.getTitle());
        }
        if (markerOptions.getTag() != null) {
            c44491df.mo70772a(markerOptions.getTag());
        }
        AppMethodBeat.m2505o(101577);
        return c44491df;
    }

    /* renamed from: a */
    public static C31004dm m71295a(PolylineOptions polylineOptions) {
        AppMethodBeat.m2504i(101578);
        if (polylineOptions == null) {
            AppMethodBeat.m2505o(101578);
            return null;
        }
        C31004dm c31004dm = new C31004dm();
        Iterable b = C41025ej.m71298b(polylineOptions.getPoints());
        if (b == null || b.size() == 0) {
            AppMethodBeat.m2505o(101578);
            return null;
        }
        c31004dm.mo50241a(b);
        c31004dm.mo50255d((int) polylineOptions.getZIndex()).mo50259f(polylineOptions.getLevel()).mo50236a(polylineOptions.getWidth()).mo50242a(polylineOptions.isVisible()).mo50237a(polylineOptions.getColor()).mo50246b(polylineOptions.getEdgeColor()).mo50245b(polylineOptions.getEdgeWidth()).mo50256e(polylineOptions.getLineType()).mo50252c(polylineOptions.getEraseColor()).mo50239a(C41025ej.m71289a(polylineOptions.getIndoorInfo()));
        if (polylineOptions.getColorTexture() != null) {
            c31004dm.mo50238a(C5839cn.m8915a(polylineOptions.getColorTexture().getBitmap()));
        }
        if (polylineOptions.getArrowTexture() != null) {
            c31004dm.mo50249b(true);
            c31004dm.mo50261g((int) polylineOptions.getArrowGap());
            Matrix matrix = new Matrix();
            matrix.postRotate(-90.0f);
            try {
                Bitmap bitmap = polylineOptions.getArrowTexture().getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
                c31004dm.mo50247b(C5839cn.m8915a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true)));
            } catch (Exception e) {
            }
        }
        if (polylineOptions.isDottedLine()) {
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf((int) (3.0f * polylineOptions.getWidth())));
            arrayList.add(Integer.valueOf((int) polylineOptions.getWidth()));
            c31004dm.mo50253c(arrayList);
        }
        AppMethodBeat.m2505o(101578);
        return c31004dm;
    }

    /* renamed from: a */
    public static C16192dk m71294a(PolygonOptions polygonOptions) {
        AppMethodBeat.m2504i(101579);
        if (polygonOptions == null) {
            AppMethodBeat.m2505o(101579);
            return null;
        }
        C16192dk c16192dk = new C16192dk();
        Iterable b = C41025ej.m71298b(polygonOptions.getPoints());
        if (b == null || b.size() <= 2) {
            AppMethodBeat.m2505o(101579);
            return null;
        }
        c16192dk.mo29148b(b);
        c16192dk.mo29143a(polygonOptions.isVisible()).mo29150c((int) polygonOptions.getZIndex()).mo29152d(polygonOptions.getLevel()).mo29141a(polygonOptions.getStrokeWidth() / C24351y.m37638g()).mo29142a(polygonOptions.getStrokeColor()).mo29147b(polygonOptions.getFillColor());
        AppMethodBeat.m2505o(101579);
        return c16192dk;
    }

    /* renamed from: a */
    static C41004ad m71286a(CameraUpdate cameraUpdate, C30982aj c30982aj) {
        AppMethodBeat.m2504i(101580);
        if (cameraUpdate == null || cameraUpdate.getParams() == null) {
            AppMethodBeat.m2505o(101580);
            return null;
        }
        CameraParameter params = cameraUpdate.getParams();
        C41004ad a;
        switch (cameraUpdate.getParams().cameraUpdate_type) {
            case 0:
                a = C46747ae.m88609a();
                AppMethodBeat.m2505o(101580);
                return a;
            case 1:
                a = C46747ae.m88619b();
                AppMethodBeat.m2505o(101580);
                return a;
            case 2:
                a = C46747ae.m88611a(params.scrollBy_xPixel, params.scrollBy_yPixel);
                AppMethodBeat.m2505o(101580);
                return a;
            case 3:
                float f = params.zoomTo_zoom < c30982aj.mo50140f() ? c30982aj.mo50140f() : params.zoomTo_zoom > c30982aj.mo50138e() ? c30982aj.mo50138e() : params.zoomTo_zoom;
                a = C46747ae.m88610a(C41025ej.m71279a(f));
                AppMethodBeat.m2505o(101580);
                return a;
            case 4:
                a = C46747ae.m88620b(params.zoomBy_amount);
                AppMethodBeat.m2505o(101580);
                return a;
            case 5:
                a = C46747ae.m88612a(params.zoomBy_Point_amount, params.zoomBy_Point_focus);
                AppMethodBeat.m2505o(101580);
                return a;
            case 6:
                a = C46747ae.m88613a(C41025ej.m71287a(params.newCameraPosition));
                AppMethodBeat.m2505o(101580);
                return a;
            case 7:
                a = C46747ae.m88614a(C41025ej.m71291a(params.newLatLng));
                AppMethodBeat.m2505o(101580);
                return a;
            case 8:
                a = C46747ae.m88615a(C41025ej.m71291a(params.newLatLngZoom_latlng), C41025ej.m71279a(params.newLatLngZoom_zoom));
                AppMethodBeat.m2505o(101580);
                return a;
            case 9:
                a = C46747ae.m88617a(C41025ej.m71292a(params.newLatLngBounds_bounds), params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding);
                AppMethodBeat.m2505o(101580);
                return a;
            case 10:
                int i;
                int i2;
                int i3;
                int i4;
                if (c30982aj == null || c30982aj.mo50161x() == 0 || c30982aj.mo50161x() == 0) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    if (params.newLatLngBounds_dimension_width < c30982aj.mo50161x()) {
                        i = (c30982aj.mo50161x() / 2) - ((params.newLatLngBounds_dimension_width / 2) - params.newLatLngBounds_dimension_padding);
                        i2 = i;
                        i4 = i;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                    if (params.newLatLngBounds_dimension_height < c30982aj.mo50162y()) {
                        int y = (c30982aj.mo50162y() / 2) - ((params.newLatLngBounds_dimension_height / 2) - params.newLatLngBounds_dimension_padding);
                        i = y;
                        i3 = y;
                    } else {
                        i = 0;
                        i3 = 0;
                    }
                }
                a = C46747ae.m88617a(C41025ej.m71292a(params.newLatLngBounds_dimension_bounds), i2, i4, i3, i);
                AppMethodBeat.m2505o(101580);
                return a;
            case 11:
                a = C46747ae.m88618a(C41025ej.m71292a(params.newLatLngBounds_bounds), C41025ej.m71291a(params.newLatLng), params.newLatLngBounds_padding);
                AppMethodBeat.m2505o(101580);
                return a;
            default:
                AppMethodBeat.m2505o(101580);
                return null;
        }
    }

    /* renamed from: a */
    static IndoorBuilding m71281a(C31000cw c31000cw) {
        AppMethodBeat.m2504i(101581);
        if (c31000cw == null) {
            AppMethodBeat.m2505o(101581);
            return null;
        }
        List c = C41025ej.m71299c(c31000cw.mo50192c());
        if (c == null) {
            AppMethodBeat.m2505o(101581);
            return null;
        }
        IndoorBuilding indoorBuilding = new IndoorBuilding(c31000cw.mo50190a(), c31000cw.mo50191b(), c, c31000cw.mo50193d());
        AppMethodBeat.m2505o(101581);
        return indoorBuilding;
    }

    /* renamed from: a */
    static C24341cx m71289a(IndoorInfo indoorInfo) {
        AppMethodBeat.m2504i(101582);
        if (indoorInfo == null) {
            AppMethodBeat.m2505o(101582);
            return null;
        }
        C24341cx c24341cx = new C24341cx(indoorInfo.getBuildingId(), indoorInfo.getFloorName());
        AppMethodBeat.m2505o(101582);
        return c24341cx;
    }

    /* renamed from: c */
    static List<IndoorLevel> m71299c(List<C36473cy> list) {
        AppMethodBeat.m2504i(101583);
        if (list == null) {
            AppMethodBeat.m2505o(101583);
            return null;
        }
        CopyOnWriteArrayList<C36473cy> copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        ArrayList arrayList = new ArrayList();
        for (C36473cy c36473cy : copyOnWriteArrayList) {
            if (c36473cy == null) {
                AppMethodBeat.m2505o(101583);
                return null;
            }
            arrayList.add(new IndoorLevel(c36473cy.mo57703a()));
        }
        AppMethodBeat.m2505o(101583);
        return arrayList;
    }

    /* renamed from: a */
    public static C31001da m71290a(Language language) {
        AppMethodBeat.m2504i(101584);
        C31001da c31001da;
        if (language == null) {
            c31001da = C31001da.zh;
            AppMethodBeat.m2505o(101584);
            return c31001da;
        }
        switch (language) {
            case zh:
                c31001da = C31001da.zh;
                AppMethodBeat.m2505o(101584);
                return c31001da;
            case en:
                c31001da = C31001da.en;
                AppMethodBeat.m2505o(101584);
                return c31001da;
            default:
                c31001da = C31001da.zh;
                AppMethodBeat.m2505o(101584);
                return c31001da;
        }
    }
}
