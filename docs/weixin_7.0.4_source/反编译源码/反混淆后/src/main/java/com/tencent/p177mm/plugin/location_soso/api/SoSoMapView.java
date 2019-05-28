package com.tencent.p177mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.location_soso.ViewManager;
import com.tencent.p177mm.plugin.p443k.C12330e;
import com.tencent.p177mm.plugin.p443k.C28353b;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.location_soso.api.SoSoMapView */
public class SoSoMapView extends MapView implements C28354d {
    public static final String TAG = "MicroMsg.SoSoMapView";
    private boolean firstanim = true;
    private C28353b iController;
    private ViewManager mViewManager;
    private HashMap<String, Object> tagsView = new HashMap();

    /* renamed from: com.tencent.mm.plugin.location_soso.api.SoSoMapView$1 */
    class C33581 implements C28353b {
        C33581() {
        }

        public void setZoom(int i) {
            AppMethodBeat.m2504i(51294);
            C4990ab.m7411d(SoSoMapView.TAG, "set Zoom %d", Integer.valueOf(i));
            SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.zoomTo((float) i));
            AppMethodBeat.m2505o(51294);
        }

        public void animateTo(double d, double d2, int i) {
            AppMethodBeat.m2504i(51295);
            C4990ab.m7410d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2 + " zoom:" + i);
            if (SoSoMapView.this.firstanim) {
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
            } else {
                SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
            }
            SoSoMapView.this.firstanim = false;
            AppMethodBeat.m2505o(51295);
        }

        public void animateTo(double d, double d2) {
            AppMethodBeat.m2504i(51296);
            C4990ab.m7410d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2);
            if (SoSoMapView.this.firstanim) {
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
            } else {
                SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
            }
            SoSoMapView.this.firstanim = false;
            AppMethodBeat.m2505o(51296);
        }

        public void setCenter(double d, double d2) {
            AppMethodBeat.m2504i(51297);
            SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
            AppMethodBeat.m2505o(51297);
        }

        public void offsetCenter(double d, double d2) {
            AppMethodBeat.m2504i(51298);
            setCenter((((double) SoSoMapView.this.getMapCenterX()) / 1000000.0d) + d, (((double) SoSoMapView.this.getMapCenterY()) / 1000000.0d) + d2);
            AppMethodBeat.m2505o(51298);
        }
    }

    public SoSoMapView(Context context) {
        super(context);
        AppMethodBeat.m2504i(51299);
        init();
        AppMethodBeat.m2505o(51299);
    }

    public SoSoMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(51300);
        init();
        AppMethodBeat.m2505o(51300);
    }

    public SoSoMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        AppMethodBeat.m2504i(51301);
        init();
        AppMethodBeat.m2505o(51301);
    }

    public MapController getController() {
        AppMethodBeat.m2504i(51302);
        MapController mapController = getMapController();
        AppMethodBeat.m2505o(51302);
        return mapController;
    }

    private void setEnableForeignMap(boolean z) {
        AppMethodBeat.m2504i(51303);
        try {
            Method declaredMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[]{Boolean.valueOf(z)});
            AppMethodBeat.m2505o(51303);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(51303);
        }
    }

    private void init() {
        AppMethodBeat.m2504i(51304);
        this.mViewManager = new ViewManager(getMap());
        getMap().set3DEnable(true);
        this.iController = new C33581();
        AppMethodBeat.m2505o(51304);
    }

    public void addView(View view, double d, double d2) {
        AppMethodBeat.m2504i(51305);
        this.mViewManager.addView(view, d, d2);
        AppMethodBeat.m2505o(51305);
    }

    public void addPinView(View view, double d, double d2) {
        AppMethodBeat.m2504i(51306);
        this.mViewManager.addPinView(view, d, d2);
        AppMethodBeat.m2505o(51306);
    }

    public C28353b getIController() {
        return this.iController;
    }

    public int getZoomLevel() {
        AppMethodBeat.m2504i(51307);
        TencentMap map = getMap();
        if (map == null) {
            AppMethodBeat.m2505o(51307);
            return 16;
        }
        int zoomLevel = map.getZoomLevel();
        AppMethodBeat.m2505o(51307);
        return zoomLevel;
    }

    public void setBuiltInZoomControls(boolean z) {
    }

    public void addNullView(View view) {
        AppMethodBeat.m2504i(51308);
        C4990ab.m7410d(TAG, "addNullView ");
        addView(view);
        AppMethodBeat.m2505o(51308);
    }

    public int getMapCenterX() {
        AppMethodBeat.m2504i(51309);
        if (getMapCenter() != null) {
            int latitude = (int) (getMapCenter().getLatitude() * 1000000.0d);
            AppMethodBeat.m2505o(51309);
            return latitude;
        }
        AppMethodBeat.m2505o(51309);
        return 0;
    }

    public int getMapCenterY() {
        AppMethodBeat.m2504i(51310);
        if (getMapCenter() != null) {
            int longitude = (int) (getMapCenter().getLongitude() * 1000000.0d);
            AppMethodBeat.m2505o(51310);
            return longitude;
        }
        AppMethodBeat.m2505o(51310);
        return 0;
    }

    public void updateViewLayout(View view, double d, double d2) {
        AppMethodBeat.m2504i(51311);
        this.mViewManager.updateViewLayout(view, d, d2, false);
        AppMethodBeat.m2505o(51311);
    }

    public void addOverlay(Object obj) {
    }

    public void requestMapFocus() {
        AppMethodBeat.m2504i(51312);
        requestFocus();
        AppMethodBeat.m2505o(51312);
    }

    public void addView(Object obj, double d, double d2, String str) {
        AppMethodBeat.m2504i(51313);
        this.tagsView.put(str, obj);
        AppMethodBeat.m2505o(51313);
    }

    public Object getViewByItag(String str) {
        AppMethodBeat.m2504i(51314);
        if (this.tagsView.containsKey(str)) {
            Object obj = this.tagsView.get(str);
            AppMethodBeat.m2505o(51314);
            return obj;
        }
        AppMethodBeat.m2505o(51314);
        return null;
    }

    public Collection<Object> getChilds() {
        AppMethodBeat.m2504i(51315);
        Collection values = this.tagsView.values();
        AppMethodBeat.m2505o(51315);
        return values;
    }

    public void removeView(View view) {
        AppMethodBeat.m2504i(51316);
        this.mViewManager.removeView(view);
        for (String str : this.tagsView.keySet()) {
            if (this.tagsView.get(str).equals(view)) {
                this.tagsView.remove(str);
                AppMethodBeat.m2505o(51316);
                return;
            }
        }
        AppMethodBeat.m2505o(51316);
    }

    public Set<String> getTags() {
        AppMethodBeat.m2504i(51317);
        Set keySet = this.tagsView.keySet();
        AppMethodBeat.m2505o(51317);
        return keySet;
    }

    public Object removeViewByTag(String str) {
        AppMethodBeat.m2504i(51318);
        Object obj = this.tagsView.get(str);
        if (obj instanceof View) {
            removeView((View) obj);
        }
        AppMethodBeat.m2505o(51318);
        return obj;
    }

    public void clean() {
        AppMethodBeat.m2504i(51319);
        this.tagsView.clear();
        this.mViewManager.destroy();
        AppMethodBeat.m2505o(51319);
    }

    public void addLocationPin(View view) {
        AppMethodBeat.m2504i(51320);
        addView(view, 0.0d, 0.0d);
        AppMethodBeat.m2505o(51320);
    }

    public void zoomToSpan(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(51321);
        getIController().setCenter(d, d2);
        C4990ab.m7410d(TAG, "zoomToSpan " + ((int) (1000000.0d * d3)) + " " + ((int) (1000000.0d * d4)) + "  " + (1000000.0d * d) + " " + (1000000.0d * d2));
        if (d3 == 0.0d || d4 == 0.0d) {
            AppMethodBeat.m2505o(51321);
            return;
        }
        if (getController() != null) {
            getController().zoomToSpan(d3, d4);
        }
        AppMethodBeat.m2505o(51321);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2) {
        AppMethodBeat.m2504i(51322);
        C4990ab.m7410d(TAG, "updateLocationPinLayout");
        updateLocaitonPinLayout(view, d, d2, false);
        AppMethodBeat.m2505o(51322);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2, boolean z) {
        AppMethodBeat.m2504i(51323);
        this.mViewManager.updateLocaitonPinLayout(view, d, d2, z);
        AppMethodBeat.m2505o(51323);
    }

    public int getZoom() {
        AppMethodBeat.m2504i(51324);
        int zoomLevel = getZoomLevel();
        AppMethodBeat.m2505o(51324);
        return zoomLevel;
    }

    public void setMapViewOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(51325);
        setOnTouchListener(onTouchListener);
        AppMethodBeat.m2505o(51325);
    }

    public Point getPointByGeoPoint(double d, double d2) {
        AppMethodBeat.m2504i(51326);
        Point point = new Point();
        getProjection().toPixels(new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), point);
        AppMethodBeat.m2505o(51326);
        return point;
    }

    public void addAnimTrackView(View view, double d, double d2, String str) {
        AppMethodBeat.m2504i(51327);
        this.tagsView.put(str, view);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.m2505o(51327);
    }

    public void updateAnimViewLayout(View view, double d, double d2) {
        AppMethodBeat.m2504i(51328);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.m2505o(51328);
    }

    public float metersToEquatorPixels(double d) {
        AppMethodBeat.m2504i(51329);
        float metersToEquatorPixels = getProjection().metersToEquatorPixels((float) d);
        AppMethodBeat.m2505o(51329);
        return metersToEquatorPixels;
    }

    public C12330e getViewManager() {
        return this.mViewManager;
    }

    public void destroy() {
        AppMethodBeat.m2504i(51330);
        this.mViewManager.destroy();
        AppMethodBeat.m2505o(51330);
    }

    public void setMapAnchor(float f, float f2) {
        AppMethodBeat.m2504i(51331);
        getMap().setMapAnchor(f, f2);
        AppMethodBeat.m2505o(51331);
    }

    public void addView(View view, double d, double d2, int i) {
        AppMethodBeat.m2504i(51332);
        GeoPoint geoPoint = new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2));
        if (i == -2) {
            addView(view, new LayoutParams(-2, -2, new LatLng(d, d2), 17));
            AppMethodBeat.m2505o(51332);
        } else if (i == -1) {
            addView(view, new LayoutParams(-1, -1, new LatLng(d, d2), 17));
            AppMethodBeat.m2505o(51332);
        } else {
            addView(view, new LayoutParams(i, i, new LatLng(d, d2), 17));
            AppMethodBeat.m2505o(51332);
        }
    }

    public void updateViewLayout(View view, double d, double d2, int i) {
        AppMethodBeat.m2504i(51333);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.m2505o(51333);
    }
}
