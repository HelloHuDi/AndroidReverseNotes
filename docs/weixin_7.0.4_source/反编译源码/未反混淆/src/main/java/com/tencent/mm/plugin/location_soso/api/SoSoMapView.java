package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.k.e;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.sdk.platformtools.ab;
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

public class SoSoMapView extends MapView implements d {
    public static final String TAG = "MicroMsg.SoSoMapView";
    private boolean firstanim = true;
    private b iController;
    private ViewManager mViewManager;
    private HashMap<String, Object> tagsView = new HashMap();

    public SoSoMapView(Context context) {
        super(context);
        AppMethodBeat.i(51299);
        init();
        AppMethodBeat.o(51299);
    }

    public SoSoMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(51300);
        init();
        AppMethodBeat.o(51300);
    }

    public SoSoMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        AppMethodBeat.i(51301);
        init();
        AppMethodBeat.o(51301);
    }

    public MapController getController() {
        AppMethodBeat.i(51302);
        MapController mapController = getMapController();
        AppMethodBeat.o(51302);
        return mapController;
    }

    private void setEnableForeignMap(boolean z) {
        AppMethodBeat.i(51303);
        try {
            Method declaredMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[]{Boolean.valueOf(z)});
            AppMethodBeat.o(51303);
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.o(51303);
        }
    }

    private void init() {
        AppMethodBeat.i(51304);
        this.mViewManager = new ViewManager(getMap());
        getMap().set3DEnable(true);
        this.iController = new b() {
            public void setZoom(int i) {
                AppMethodBeat.i(51294);
                ab.d(SoSoMapView.TAG, "set Zoom %d", Integer.valueOf(i));
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.zoomTo((float) i));
                AppMethodBeat.o(51294);
            }

            public void animateTo(double d, double d2, int i) {
                AppMethodBeat.i(51295);
                ab.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2 + " zoom:" + i);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
                } else {
                    SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
                }
                SoSoMapView.this.firstanim = false;
                AppMethodBeat.o(51295);
            }

            public void animateTo(double d, double d2) {
                AppMethodBeat.i(51296);
                ab.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2);
                if (SoSoMapView.this.firstanim) {
                    SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
                } else {
                    SoSoMapView.this.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
                }
                SoSoMapView.this.firstanim = false;
                AppMethodBeat.o(51296);
            }

            public void setCenter(double d, double d2) {
                AppMethodBeat.i(51297);
                SoSoMapView.this.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
                AppMethodBeat.o(51297);
            }

            public void offsetCenter(double d, double d2) {
                AppMethodBeat.i(51298);
                setCenter((((double) SoSoMapView.this.getMapCenterX()) / 1000000.0d) + d, (((double) SoSoMapView.this.getMapCenterY()) / 1000000.0d) + d2);
                AppMethodBeat.o(51298);
            }
        };
        AppMethodBeat.o(51304);
    }

    public void addView(View view, double d, double d2) {
        AppMethodBeat.i(51305);
        this.mViewManager.addView(view, d, d2);
        AppMethodBeat.o(51305);
    }

    public void addPinView(View view, double d, double d2) {
        AppMethodBeat.i(51306);
        this.mViewManager.addPinView(view, d, d2);
        AppMethodBeat.o(51306);
    }

    public b getIController() {
        return this.iController;
    }

    public int getZoomLevel() {
        AppMethodBeat.i(51307);
        TencentMap map = getMap();
        if (map == null) {
            AppMethodBeat.o(51307);
            return 16;
        }
        int zoomLevel = map.getZoomLevel();
        AppMethodBeat.o(51307);
        return zoomLevel;
    }

    public void setBuiltInZoomControls(boolean z) {
    }

    public void addNullView(View view) {
        AppMethodBeat.i(51308);
        ab.d(TAG, "addNullView ");
        addView(view);
        AppMethodBeat.o(51308);
    }

    public int getMapCenterX() {
        AppMethodBeat.i(51309);
        if (getMapCenter() != null) {
            int latitude = (int) (getMapCenter().getLatitude() * 1000000.0d);
            AppMethodBeat.o(51309);
            return latitude;
        }
        AppMethodBeat.o(51309);
        return 0;
    }

    public int getMapCenterY() {
        AppMethodBeat.i(51310);
        if (getMapCenter() != null) {
            int longitude = (int) (getMapCenter().getLongitude() * 1000000.0d);
            AppMethodBeat.o(51310);
            return longitude;
        }
        AppMethodBeat.o(51310);
        return 0;
    }

    public void updateViewLayout(View view, double d, double d2) {
        AppMethodBeat.i(51311);
        this.mViewManager.updateViewLayout(view, d, d2, false);
        AppMethodBeat.o(51311);
    }

    public void addOverlay(Object obj) {
    }

    public void requestMapFocus() {
        AppMethodBeat.i(51312);
        requestFocus();
        AppMethodBeat.o(51312);
    }

    public void addView(Object obj, double d, double d2, String str) {
        AppMethodBeat.i(51313);
        this.tagsView.put(str, obj);
        AppMethodBeat.o(51313);
    }

    public Object getViewByItag(String str) {
        AppMethodBeat.i(51314);
        if (this.tagsView.containsKey(str)) {
            Object obj = this.tagsView.get(str);
            AppMethodBeat.o(51314);
            return obj;
        }
        AppMethodBeat.o(51314);
        return null;
    }

    public Collection<Object> getChilds() {
        AppMethodBeat.i(51315);
        Collection values = this.tagsView.values();
        AppMethodBeat.o(51315);
        return values;
    }

    public void removeView(View view) {
        AppMethodBeat.i(51316);
        this.mViewManager.removeView(view);
        for (String str : this.tagsView.keySet()) {
            if (this.tagsView.get(str).equals(view)) {
                this.tagsView.remove(str);
                AppMethodBeat.o(51316);
                return;
            }
        }
        AppMethodBeat.o(51316);
    }

    public Set<String> getTags() {
        AppMethodBeat.i(51317);
        Set keySet = this.tagsView.keySet();
        AppMethodBeat.o(51317);
        return keySet;
    }

    public Object removeViewByTag(String str) {
        AppMethodBeat.i(51318);
        Object obj = this.tagsView.get(str);
        if (obj instanceof View) {
            removeView((View) obj);
        }
        AppMethodBeat.o(51318);
        return obj;
    }

    public void clean() {
        AppMethodBeat.i(51319);
        this.tagsView.clear();
        this.mViewManager.destroy();
        AppMethodBeat.o(51319);
    }

    public void addLocationPin(View view) {
        AppMethodBeat.i(51320);
        addView(view, 0.0d, 0.0d);
        AppMethodBeat.o(51320);
    }

    public void zoomToSpan(double d, double d2, double d3, double d4) {
        AppMethodBeat.i(51321);
        getIController().setCenter(d, d2);
        ab.d(TAG, "zoomToSpan " + ((int) (1000000.0d * d3)) + " " + ((int) (1000000.0d * d4)) + "  " + (1000000.0d * d) + " " + (1000000.0d * d2));
        if (d3 == 0.0d || d4 == 0.0d) {
            AppMethodBeat.o(51321);
            return;
        }
        if (getController() != null) {
            getController().zoomToSpan(d3, d4);
        }
        AppMethodBeat.o(51321);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2) {
        AppMethodBeat.i(51322);
        ab.d(TAG, "updateLocationPinLayout");
        updateLocaitonPinLayout(view, d, d2, false);
        AppMethodBeat.o(51322);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2, boolean z) {
        AppMethodBeat.i(51323);
        this.mViewManager.updateLocaitonPinLayout(view, d, d2, z);
        AppMethodBeat.o(51323);
    }

    public int getZoom() {
        AppMethodBeat.i(51324);
        int zoomLevel = getZoomLevel();
        AppMethodBeat.o(51324);
        return zoomLevel;
    }

    public void setMapViewOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(51325);
        setOnTouchListener(onTouchListener);
        AppMethodBeat.o(51325);
    }

    public Point getPointByGeoPoint(double d, double d2) {
        AppMethodBeat.i(51326);
        Point point = new Point();
        getProjection().toPixels(new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), point);
        AppMethodBeat.o(51326);
        return point;
    }

    public void addAnimTrackView(View view, double d, double d2, String str) {
        AppMethodBeat.i(51327);
        this.tagsView.put(str, view);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.o(51327);
    }

    public void updateAnimViewLayout(View view, double d, double d2) {
        AppMethodBeat.i(51328);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.o(51328);
    }

    public float metersToEquatorPixels(double d) {
        AppMethodBeat.i(51329);
        float metersToEquatorPixels = getProjection().metersToEquatorPixels((float) d);
        AppMethodBeat.o(51329);
        return metersToEquatorPixels;
    }

    public e getViewManager() {
        return this.mViewManager;
    }

    public void destroy() {
        AppMethodBeat.i(51330);
        this.mViewManager.destroy();
        AppMethodBeat.o(51330);
    }

    public void setMapAnchor(float f, float f2) {
        AppMethodBeat.i(51331);
        getMap().setMapAnchor(f, f2);
        AppMethodBeat.o(51331);
    }

    public void addView(View view, double d, double d2, int i) {
        AppMethodBeat.i(51332);
        GeoPoint geoPoint = new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2));
        if (i == -2) {
            addView(view, new LayoutParams(-2, -2, new LatLng(d, d2), 17));
            AppMethodBeat.o(51332);
        } else if (i == -1) {
            addView(view, new LayoutParams(-1, -1, new LatLng(d, d2), 17));
            AppMethodBeat.o(51332);
        } else {
            addView(view, new LayoutParams(i, i, new LatLng(d, d2), 17));
            AppMethodBeat.o(51332);
        }
    }

    public void updateViewLayout(View view, double d, double d2, int i) {
        AppMethodBeat.i(51333);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
        AppMethodBeat.o(51333);
    }
}
