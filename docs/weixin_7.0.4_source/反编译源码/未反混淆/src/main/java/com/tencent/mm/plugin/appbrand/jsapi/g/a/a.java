package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.g.g;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.OverlayLevel;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.x;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class a implements b {
    ImageView cAw;
    Context context;
    private String hMR;
    FrameLayout hMS;
    protected final SoSoMapView hMT;
    k hMU;
    n hMV;
    private String hMW;
    private String hMX;
    private int hMY;
    CameraPosition hMZ;
    SurfaceView hNa;
    private Runnable hNb = new Runnable() {
        public final void run() {
            AppMethodBeat.i(51173);
            a.this.hNa.setVisibility(4);
            AppMethodBeat.o(51173);
        }
    };
    l hNc;
    u hNd;
    boolean hNe = false;
    private Runnable hNf;
    t hNg;
    e hNh;
    public ArrayList<Circle> hNi = new ArrayList();
    public ArrayList<b> hNj = new ArrayList();
    private Map<String, Polyline> hNk = new ConcurrentHashMap();
    private a hNl = new a();
    Map<String, d> hNm = new ConcurrentHashMap();
    public ArrayList<c> hNn = new ArrayList();
    public ArrayList<Polygon> hNo = new ArrayList();
    boolean hNp;
    d hNq;
    private com.tencent.mm.plugin.appbrand.s.b.a.b hNr = new com.tencent.mm.plugin.appbrand.s.b.a.b() {
        public final void a(int i, String str, final com.tencent.mm.plugin.appbrand.s.b.a.a aVar) {
            AppMethodBeat.i(138423);
            if (i != 0) {
                ab.e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", Integer.valueOf(i), str);
                AppMethodBeat.o(138423);
                return;
            }
            ab.d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude));
            if (!g.o(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                ab.w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
                AppMethodBeat.o(138423);
            } else if (!a.this.hNp || a.this.isBackground) {
                AppMethodBeat.o(138423);
            } else {
                m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(138422);
                        if (a.this.hMT != null) {
                            if (a.this.hNq == null) {
                                a.this.hNq = new d(a.this.context);
                                d dVar = a.this.hNq;
                                SoSoMapView soSoMapView = a.this.hMT;
                                com.tencent.mm.plugin.appbrand.s.b.a.a aVar = aVar;
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.anchor(0.5f, 0.5f);
                                markerOptions.position(new LatLng(aVar.latitude, aVar.longitude));
                                markerOptions.markerView(dVar);
                                markerOptions.zIndex(BaseClientBuilder.API_PRIORITY_OTHER);
                                markerOptions.flat(true);
                                dVar.hNK = soSoMapView.getMap().addMarker(markerOptions);
                            }
                            d dVar2 = a.this.hNq;
                            double d = aVar.latitude;
                            double d2 = aVar.longitude;
                            String str = aVar.bIy;
                            double d3 = aVar.iSf;
                            if (dVar2.hOt == -1.0d && dVar2.hOu == -1.0d) {
                                dVar2.hOt = d;
                                dVar2.hOr = d;
                                dVar2.hOu = d2;
                                dVar2.hOs = d2;
                            } else {
                                dVar2.hOt = dVar2.hOr;
                                dVar2.hOu = dVar2.hOs;
                                dVar2.hOs = d2;
                                dVar2.hOr = d;
                            }
                            if (!(dVar2.hOt == -1.0d || dVar2.hOu == -1.0d)) {
                                dVar2.hOy = f.a(dVar2.hOu, dVar2.hOt, d2, d, str, d3);
                            }
                            if (dVar2.hOw == 900.0f || dVar2.hOv == 900.0f) {
                                float h = (float) f.h(d, d2);
                                dVar2.hOv = h;
                                dVar2.hOw = h;
                            } else {
                                dVar2.hOw = dVar2.hOv;
                                dVar2.hOv = (float) f.h(d, d2);
                            }
                            if (dVar2.hNK != null) {
                                dVar2.hNK.setPosition(new LatLng(d, d2));
                            }
                        }
                        AppMethodBeat.o(138422);
                    }
                });
                AppMethodBeat.o(138423);
            }
        }
    };
    private final int hNs = 500;
    AtomicBoolean hNt = new AtomicBoolean(false);
    private AtomicBoolean hNu = new AtomicBoolean(false);
    boolean isBackground;
    private long lastCheckTime = 0;
    private int mMapType;

    public class a implements InfoWindowAdapter {
        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.i(51175);
            if (marker == null) {
                ab.w("MicroMsg.DefaultTencentMapView", "realMarker is null, return");
                AppMethodBeat.o(51175);
                return null;
            } else if (bo.isNullOrNil((String) marker.getTag())) {
                ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                AppMethodBeat.o(51175);
                return null;
            } else if (((String) marker.getTag()).endsWith("#label")) {
                AppMethodBeat.o(51175);
                return null;
            } else {
                d dVar = (d) a.this.Bh((String) marker.getTag());
                if (dVar == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
                    AppMethodBeat.o(51175);
                    return null;
                } else if (dVar.hOa == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
                    AppMethodBeat.o(51175);
                    return null;
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a aVar = dVar.hOa.hOe;
                    if (aVar == null) {
                        AppMethodBeat.o(51175);
                        return null;
                    }
                    a aVar2 = a.this;
                    View aEe = i.aEe();
                    if (aEe == null) {
                        aEe = new com.tencent.mm.plugin.appbrand.widget.e.b(aVar2.context);
                    }
                    aEe.setText("");
                    aEe.setTextSize(12);
                    aEe.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.b.jjZ);
                    aEe.setTitlePadding(0);
                    aEe.setGravity("center");
                    int i = com.tencent.mm.plugin.appbrand.widget.e.b.jka;
                    aEe.x(0, 0, i, i);
                    aEe.setText(aVar.content);
                    aEe.setTextSize(aVar.hOg);
                    aEe.setTextColor(aVar.color);
                    aEe.setTitlePadding(aVar.padding);
                    aEe.setGravity(aVar.hdq);
                    aEe.x(aVar.hOh, aVar.borderWidth, aVar.borderColor, aVar.bgColor);
                    AppMethodBeat.o(51175);
                    return aEe;
                }
            }
        }

        public final void onInfoWindowDettached(Marker marker, View view) {
            AppMethodBeat.i(51176);
            if (view instanceof com.tencent.mm.plugin.appbrand.widget.e.b) {
                ab.d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
                i.a((com.tencent.mm.plugin.appbrand.widget.e.b) view);
            }
            AppMethodBeat.o(51176);
        }
    }

    public class b {
        ImageView hNJ;

        public b(ImageView imageView) {
            this.hNJ = imageView;
        }
    }

    public class c {
        Marker hNK;

        public c(Marker marker) {
            this.hNK = marker;
        }
    }

    public static class d extends q {
        public Marker hNK;
        public Marker hNL;
    }

    public a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.i(51177);
        this.context = context;
        this.hMR = str;
        this.hMS = new FrameLayout(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.hMS.setBackgroundColor(0);
        this.hMS.setLayoutParams(layoutParams);
        this.hMT = new SoSoMapView(context, A(map));
        this.hMS.addView(this.hMT, new LayoutParams(-1, -1));
        this.cAw = new ImageView(context);
        this.cAw.setScaleType(ScaleType.FIT_XY);
        this.hMS.addView(this.cAw, new ViewGroup.LayoutParams(-1, -1));
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s, init", this);
        this.hMT.getMap().setInfoWindowAdapter(this.hNl);
        this.hMT.getMap().setMapAnchor(0.5f, 0.5f);
        this.hMT.getMap().enableMultipleInfowindow(true);
        this.hMT.getMap().setMapStyle(this.hMY);
        this.hMT.getMap().setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            public final void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(51149);
                if (marker == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "realMarker is null");
                    AppMethodBeat.o(51149);
                    return;
                }
                d dVar = (d) a.this.Bh((String) marker.getTag());
                if (dVar == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", this);
                    AppMethodBeat.o(51149);
                } else if (a.this.hMU == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", this);
                    AppMethodBeat.o(51149);
                } else {
                    a.this.hMU.a(dVar);
                    AppMethodBeat.o(51149);
                }
            }
        });
        this.hMT.getMap().setOnMarkerClickListener(new OnMarkerClickListener() {
            public final boolean onMarkerClick(Marker marker) {
                AppMethodBeat.i(51158);
                if (marker == null) {
                    ab.e("MicroMsg.DefaultTencentMapView", "realMarker is null");
                    AppMethodBeat.o(51158);
                    return false;
                }
                ab.i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", this, marker.getTag());
                if (bo.isNullOrNil((String) marker.getTag())) {
                    ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                    AppMethodBeat.o(51158);
                    return false;
                } else if (((String) marker.getTag()).endsWith("#label")) {
                    ab.w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
                    AppMethodBeat.o(51158);
                    return false;
                } else {
                    d dVar = (d) a.this.Bh((String) marker.getTag());
                    if (dVar == null) {
                        ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", this);
                        AppMethodBeat.o(51158);
                        return false;
                    } else if (a.this.hMV == null) {
                        ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", this);
                        AppMethodBeat.o(51158);
                        return false;
                    } else {
                        if (dVar.hOa != null) {
                            ab.e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", this);
                            com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a aVar = dVar.hOa.hOe;
                            if (aVar != null && aVar.hOl == com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a.hOm && dVar.hNK.isInfoWindowShown()) {
                                dVar.hNK.hideInfoWindow();
                            } else {
                                dVar.hNK.showInfoWindow();
                            }
                        }
                        if (dVar.hNK != null) {
                            dVar.hNK.set2Top();
                        }
                        if (dVar.hNL != null) {
                            dVar.hNL.set2Top();
                        }
                        if (a.this.hNq != null) {
                            d dVar2 = a.this.hNq;
                            if (dVar2.hNK != null) {
                                dVar2.hNK.set2Top();
                            }
                        }
                        boolean b = a.this.hMV.b(dVar);
                        AppMethodBeat.o(51158);
                        return b;
                    }
                }
            }
        });
        this.hMT.getMap().setOnMapClickListener(new OnMapClickListener() {
            public final void onMapClick(LatLng latLng) {
                AppMethodBeat.i(51166);
                for (d dVar : a.this.hNm.values()) {
                    if (dVar.hOa != null && dVar.hOa.hOe != null && dVar.hOa.hOe.hOl == com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a.hOm && dVar.hNK.isInfoWindowShown()) {
                        dVar.hNK.hideInfoWindow();
                    }
                }
                if (a.this.hNc != null) {
                    a.this.hNc.aDL();
                    AppMethodBeat.o(51166);
                    return;
                }
                AppMethodBeat.o(51166);
            }
        });
        this.hMT.getMap().setOnMapLoadedListener(new OnMapLoadedListener() {
            public final void onMapLoaded() {
                AppMethodBeat.i(51167);
                a.a(a.this);
                AppMethodBeat.o(51167);
            }
        });
        this.hMT.getMap().setOnMapPoiClickListener(new OnMapPoiClickListener() {
            public final void onClicked(MapPoi mapPoi) {
                AppMethodBeat.i(51168);
                if (a.this.hNd != null) {
                    p pVar = new p();
                    pVar.latitude = mapPoi.getPosition().getLatitude();
                    pVar.longitude = mapPoi.getPosition().getLongitude();
                    pVar.name = mapPoi.getName();
                    if ((mapPoi instanceof IndoorMapPoi) && !bo.isNullOrNil(((IndoorMapPoi) mapPoi).getBuildingId())) {
                        pVar.buildingId = ((IndoorMapPoi) mapPoi).getBuildingId();
                        pVar.floorName = ((IndoorMapPoi) mapPoi).getFloorName();
                    }
                    a.this.hNd.a(pVar);
                }
                AppMethodBeat.o(51168);
            }
        });
        this.hMT.getMap().setOnIndoorStateChangeListener(new OnIndoorStateChangeListener() {
            public final boolean onIndoorBuildingFocused() {
                AppMethodBeat.i(51169);
                ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
                AppMethodBeat.o(51169);
                return true;
            }

            public final boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
                AppMethodBeat.i(51170);
                ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", indoorBuilding);
                if (a.this.hNg != null) {
                    e eVar = new e();
                    eVar.buildingId = indoorBuilding.getBuidlingId();
                    eVar.buildingName = indoorBuilding.getBuildingName();
                    eVar.hNP = new LinkedList();
                    for (IndoorLevel indoorLevel : indoorBuilding.getLevels()) {
                        f fVar = new f();
                        fVar.floorName = indoorLevel.getName();
                        eVar.hNP.add(fVar);
                    }
                    eVar.hNQ = indoorBuilding.getActiveLevelIndex();
                    a.this.hNh = eVar;
                    a.this.hNg.a(eVar);
                }
                AppMethodBeat.o(51170);
                return true;
            }

            public final boolean onIndoorBuildingDeactivated() {
                AppMethodBeat.i(51171);
                ab.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
                if (a.this.hNg != null) {
                    e aDN = a.aDN();
                    a.this.hNh = aDN;
                    a.this.hNg.a(aDN);
                }
                AppMethodBeat.o(51171);
                return true;
            }
        });
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", this);
        this.hMT.onCreate(null);
        onResume();
        AppMethodBeat.o(51177);
    }

    /* Access modifiers changed, original: protected */
    public TencentMapOptions A(Map<String, Object> map) {
        AppMethodBeat.i(51178);
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        if (map == null) {
            ab.w("MicroMsg.DefaultTencentMapView", "params is null, return");
            AppMethodBeat.o(51178);
        } else {
            tencentMapOptions.enableHandDrawMap(f.a((Map) map, "theme", "normal").equals("handDraw"));
            this.mMapType = f.a((Map) map, "mapType", 1);
            tencentMapOptions.setMapType(this.mMapType);
            this.hMW = f.a((Map) map, "subKey", "");
            this.hMX = f.a((Map) map, "subId", "");
            if (bo.isNullOrNil(this.hMW)) {
                this.hMW = "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX";
                this.hMX = "";
            }
            tencentMapOptions.setSubInfo(this.hMW, this.hMX);
            this.hMY = f.a((Map) map, "styleId", 0);
            ab.d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", this.hMX, this.hMW);
            ab.i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d", r1, Boolean.valueOf(r2), Integer.valueOf(this.mMapType), this.hMX, this.hMW, Integer.valueOf(this.hMY));
            AppMethodBeat.o(51178);
        }
        return tencentMapOptions;
    }

    static e aDN() {
        AppMethodBeat.i(51179);
        e eVar = new e();
        eVar.buildingId = "";
        eVar.buildingName = "";
        eVar.hNP = new LinkedList();
        eVar.hNQ = -1;
        AppMethodBeat.o(51179);
        return eVar;
    }

    public final void onResume() {
        AppMethodBeat.i(51180);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s onResume", this);
        if (this.mMapType == 0) {
            this.cAw.setVisibility(4);
            this.hMT.setVisibility(0);
            this.hMT.onResume();
            aDP();
        } else {
            this.hMT.onResume();
        }
        this.isBackground = false;
        if (this.hNp) {
            ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).b("gcj02", this.hNr, aEc());
            g.a(this);
        }
        AppMethodBeat.o(51180);
    }

    public final void onPause() {
        AppMethodBeat.i(51181);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s onPause", this);
        if (this.mMapType == 0) {
            this.cAw.setVisibility(0);
            if (this.hNa == null) {
                this.hNa = aDO();
            }
            if (this.hNa != null) {
                al.n(this.hNb, 100);
            } else {
                ab.e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
            }
            this.hMT.setVisibility(4);
            this.hMT.getMap().getScreenShot(new OnScreenShotListener() {
                public final void onMapScreenShot(Bitmap bitmap) {
                    AppMethodBeat.i(51172);
                    if (bitmap != null) {
                        a.this.cAw.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(51172);
                }
            });
        } else {
            this.hMT.onPause();
        }
        this.isBackground = true;
        if (this.hNp) {
            ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).c("gcj02", this.hNr, aEc());
            g.b(this);
        }
        AppMethodBeat.o(51181);
    }

    private SurfaceView aDO() {
        AppMethodBeat.i(51182);
        SurfaceView surfaceView;
        if (this.hNa != null) {
            surfaceView = this.hNa;
            AppMethodBeat.o(51182);
            return surfaceView;
        }
        this.hNa = h(this.hMT);
        surfaceView = this.hNa;
        AppMethodBeat.o(51182);
        return surfaceView;
    }

    private void aDP() {
        AppMethodBeat.i(51183);
        if (this.hNa == null) {
            this.hNa = aDO();
        }
        if (this.hNa != null) {
            al.af(this.hNb);
            this.hNa.setVisibility(0);
            AppMethodBeat.o(51183);
            return;
        }
        ab.e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
        AppMethodBeat.o(51183);
    }

    public final void onDestroy() {
        AppMethodBeat.i(51184);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", this);
        this.hNu.set(true);
        this.hMT.getMap().setOnMapCameraChangeListener(null);
        aDZ();
        aDY();
        aDY();
        aDX();
        aEa();
        aEb();
        if (this.hMT != null) {
            this.hMT.clean();
            this.hMT.onDestroy();
        }
        if (this.hNq != null) {
            d dVar = this.hNq;
            if (dVar.hNK != null) {
                dVar.hNK.remove();
                dVar.hNK = null;
            }
            this.hNq = null;
        }
        AppMethodBeat.o(51184);
    }

    public final View getView() {
        return this.hMS;
    }

    public final void a(l lVar) {
        this.hNc = lVar;
    }

    public final void a(u uVar) {
        this.hNd = uVar;
    }

    public final w aDQ() {
        AppMethodBeat.i(51185);
        LatLngBounds latLngBounds = this.hMT.getProjection().getVisibleRegion().getLatLngBounds();
        i iVar = new i();
        iVar.hNT = new h(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude());
        iVar.hNU = new h(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude());
        x xVar = new x();
        xVar.hOp = iVar;
        w wVar = new w();
        wVar.hOo = xVar;
        AppMethodBeat.o(51185);
        return wVar;
    }

    public final void a(final s sVar) {
        AppMethodBeat.i(51186);
        this.hMT.getMap().setTencentMapGestureListener(new TencentMapGestureListener() {
            public final boolean onDoubleTap(float f, float f2) {
                return false;
            }

            public final boolean onSingleTap(float f, float f2) {
                return false;
            }

            public final boolean onFling(float f, float f2) {
                return false;
            }

            public final boolean onScroll(float f, float f2) {
                return false;
            }

            public final boolean onLongPress(float f, float f2) {
                return false;
            }

            public final boolean onDown(float f, float f2) {
                a.this.hNe = true;
                return false;
            }

            public final boolean onUp(float f, float f2) {
                return false;
            }

            public final void onMapStable() {
                a.this.hNe = false;
            }
        });
        this.hMT.getMap().setOnMapCameraChangeListener(new OnMapCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                AppMethodBeat.i(138412);
                if (sVar != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a();
                    aVar.hNM = new h(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    aVar.zoom = cameraPosition.getZoom();
                    aVar.rotate = cameraPosition.getBearing();
                    aVar.skew = cameraPosition.getSkew();
                    sVar.a(aVar);
                }
                AppMethodBeat.o(138412);
            }

            public final void onCameraChangeFinish(CameraPosition cameraPosition) {
                AppMethodBeat.i(138413);
                a.this.hMZ = cameraPosition;
                if (sVar != null) {
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a();
                    aVar.hNM = new h(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    aVar.zoom = cameraPosition.getZoom();
                    aVar.rotate = cameraPosition.getBearing();
                    aVar.skew = cameraPosition.getSkew();
                    sVar.a(aVar, a.this.hNe);
                }
                a.a(a.this);
                AppMethodBeat.o(138413);
            }
        });
        AppMethodBeat.o(51186);
    }

    public final void aDR() {
        AppMethodBeat.i(51187);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", this);
        this.hNf = new Runnable() {
            public final void run() {
                AppMethodBeat.i(138414);
                if (a.this.hNq != null && a.this.hNp) {
                    a.this.hMT.getIController().animateTo(a.this.hNq.getLatitude(), a.this.hNq.getLongitude());
                    ab.d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", Double.valueOf(r0), Double.valueOf(r2));
                }
                AppMethodBeat.o(138414);
            }
        };
        if (this.hNq != null && this.hNp) {
            this.hNf.run();
            this.hNf = null;
        }
        AppMethodBeat.o(51187);
    }

    public final void al(float f) {
        AppMethodBeat.i(51188);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s zoomTo scale:%f", this, Float.valueOf(f));
        TencentMap map = this.hMT.getMap();
        if (map != null) {
            map.animateCamera(CameraUpdateFactory.zoomTo(f));
        }
        AppMethodBeat.o(51188);
    }

    public final void am(float f) {
        AppMethodBeat.i(51189);
        TencentMap map = this.hMT.getMap();
        if (!(map == null || this.hMZ == null)) {
            map.animateCamera(CameraUpdateFactory.newCameraPosition(new Builder(this.hMZ).skew(this.hMZ.getSkew()).bearing(f).build()));
        }
        AppMethodBeat.o(51189);
    }

    public final void an(float f) {
        AppMethodBeat.i(51190);
        TencentMap map = this.hMT.getMap();
        if (!(map == null || this.hMZ == null)) {
            map.animateCamera(CameraUpdateFactory.newCameraPosition(new Builder(this.hMZ).skew(f).bearing(this.hMZ.getBearing()).build()));
        }
        AppMethodBeat.o(51190);
    }

    public final int getZoomLevel() {
        AppMethodBeat.i(51191);
        int zoomLevel = this.hMT.getMap().getZoomLevel();
        AppMethodBeat.o(51191);
        return zoomLevel;
    }

    public final float aDS() {
        AppMethodBeat.i(51192);
        if (this.hMZ != null) {
            float bearing = this.hMZ.getBearing();
            AppMethodBeat.o(51192);
            return bearing;
        }
        ab.e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
        AppMethodBeat.o(51192);
        return 0.0f;
    }

    public final float getSkew() {
        AppMethodBeat.i(51193);
        if (this.hMZ != null) {
            float skew = this.hMZ.getSkew();
            AppMethodBeat.o(51193);
            return skew;
        }
        ab.e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
        AppMethodBeat.o(51193);
        return 0.0f;
    }

    public final void ed(boolean z) {
        AppMethodBeat.i(51194);
        this.hMT.getUiSettings().setZoomGesturesEnabled(z);
        AppMethodBeat.o(51194);
    }

    public final void ee(boolean z) {
        AppMethodBeat.i(51195);
        this.hMT.getUiSettings().setScrollGesturesEnabled(z);
        AppMethodBeat.o(51195);
    }

    public final void ef(boolean z) {
        AppMethodBeat.i(51196);
        this.hMT.getUiSettings().setRotateGesturesEnabled(z);
        AppMethodBeat.o(51196);
    }

    public final void eg(boolean z) {
        AppMethodBeat.i(51197);
        this.hMT.getUiSettings().setCompassEnabled(z);
        AppMethodBeat.o(51197);
    }

    public final void eh(boolean z) {
        AppMethodBeat.i(51198);
        this.hMT.getMap().set3DEnable(z);
        AppMethodBeat.o(51198);
    }

    public final void ei(boolean z) {
        AppMethodBeat.i(51199);
        this.hMT.getUiSettings().setTiltGesturesEnabled(z);
        AppMethodBeat.o(51199);
    }

    public final void ej(boolean z) {
        AppMethodBeat.i(VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
        this.hMT.getMap().setSatelliteEnabled(z);
        AppMethodBeat.o(VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
    }

    public final void ek(boolean z) {
        AppMethodBeat.i(51201);
        this.hMT.getMap().setTrafficEnabled(z);
        AppMethodBeat.o(51201);
    }

    public final void el(boolean z) {
        AppMethodBeat.i(51202);
        this.hMT.getMap().setIndoorEnabled(z);
        AppMethodBeat.o(51202);
    }

    public final void a(t tVar) {
        this.hNg = tVar;
    }

    public final void ci(String str, String str2) {
        AppMethodBeat.i(51203);
        this.hMT.getMap().setIndoorFloor(str, str2);
        AppMethodBeat.o(51203);
    }

    public final e aDT() {
        AppMethodBeat.i(51204);
        e eVar;
        if (this.hNh != null) {
            eVar = this.hNh;
            AppMethodBeat.o(51204);
            return eVar;
        }
        eVar = aDN();
        AppMethodBeat.o(51204);
        return eVar;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
    }

    public void onSizeChanged(int i, int i2) {
    }

    public boolean aDU() {
        return false;
    }

    public final void em(boolean z) {
        AppMethodBeat.i(51205);
        this.hMT.getUiSettings().setIndoorLevelPickerEnabled(z);
        AppMethodBeat.o(51205);
    }

    public final void I(float f, float f2) {
        AppMethodBeat.i(51206);
        this.hMT.getIController().setCenter((double) f, (double) f2);
        AppMethodBeat.o(51206);
    }

    public final h aDV() {
        AppMethodBeat.i(51207);
        LatLng mapCenter = this.hMT.getMap().getMapCenter();
        h hVar = new h(mapCenter.getLatitude(), mapCenter.getLongitude());
        AppMethodBeat.o(51207);
        return hVar;
    }

    public final void h(List<h> list, int i) {
        AppMethodBeat.i(51208);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterable linkedList = new LinkedList();
        for (h hVar : list) {
            linkedList.add(new LatLng(hVar.latitude, hVar.longitude));
        }
        builder.include(linkedList);
        this.hMT.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i));
        this.hNf = null;
        AppMethodBeat.o(51208);
    }

    public final void a(float f, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(51209);
        TencentMap map = this.hMT.getMap();
        if (map != null) {
            map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng((double) f, (double) f2), f3, f5, f4)));
            this.hNf = null;
        }
        AppMethodBeat.o(51209);
    }

    public final void aDW() {
        AppMethodBeat.i(51210);
        synchronized (this.hNi) {
            try {
                Iterator it = this.hNi.iterator();
                while (it.hasNext()) {
                    ((Circle) it.next()).remove();
                }
                this.hNi.clear();
            } finally {
                AppMethodBeat.o(51210);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b bVar) {
        AppMethodBeat.i(51211);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(bVar.latitude, bVar.longitude));
        circleOptions.radius((double) bVar.radius);
        circleOptions.strokeColor(bVar.strokeColor);
        circleOptions.strokeWidth((float) bVar.strokeWidth);
        circleOptions.fillColor(bVar.fillColor);
        Circle addCircle = this.hMT.getMap().addCircle(circleOptions);
        synchronized (this.hNi) {
            try {
                this.hNi.add(addCircle);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51211);
            }
        }
    }

    public final void aDX() {
        AppMethodBeat.i(51212);
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(51152);
                ViewGroup viewGroup = a.this.hMS;
                synchronized (a.this.hNj) {
                    try {
                        Iterator it = a.this.hNj.iterator();
                        while (it.hasNext()) {
                            viewGroup.removeView(((b) it.next()).hNJ);
                        }
                        a.this.hNj.clear();
                    } finally {
                        AppMethodBeat.o(51152);
                    }
                }
            }
        });
        AppMethodBeat.o(51212);
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.c cVar, final b.m mVar, com.tencent.mm.plugin.appbrand.d.a aVar) {
        AppMethodBeat.i(51213);
        if (bo.isNullOrNil(cVar.hNN)) {
            AppMethodBeat.o(51213);
            return false;
        }
        Bitmap bB = aVar.bB(cVar.hNN);
        if (bB == null) {
            AppMethodBeat.o(51213);
            return false;
        }
        final ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageBitmap(bB);
        int i = cVar.left;
        int i2 = cVar.top;
        final LayoutParams layoutParams = new LayoutParams(cVar.width == 0 ? com.tencent.mm.plugin.appbrand.r.g.qb(bB.getWidth()) : cVar.width, cVar.height == 0 ? com.tencent.mm.plugin.appbrand.r.g.qb(bB.getHeight()) : cVar.height);
        layoutParams.setMargins(i, i2, 0, 0);
        final boolean z = cVar.hNO;
        final String str = cVar.data;
        imageView.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(138415);
                if (z) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        imageView.setColorFilter(Color.parseColor("#88888888"));
                    } else if (action == 3 || action == 1) {
                        imageView.clearColorFilter();
                    }
                }
                AppMethodBeat.o(138415);
                return false;
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(138416);
                if (z && mVar != null) {
                    mVar.Bf(str);
                }
                AppMethodBeat.o(138416);
            }
        });
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138417);
                a.this.hMS.addView(imageView, layoutParams);
                synchronized (a.this.hNj) {
                    try {
                        a.this.hNj.add(new b(imageView));
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(138417);
                    }
                }
            }
        });
        AppMethodBeat.o(51213);
        return true;
    }

    public final void aDY() {
        AppMethodBeat.i(51214);
        for (Polyline remove : this.hNk.values()) {
            remove.remove();
        }
        this.hNk.clear();
        AppMethodBeat.o(51214);
    }

    public final boolean Bg(String str) {
        AppMethodBeat.i(51215);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", this, str);
        Polyline polyline = (Polyline) this.hNk.get(str);
        if (polyline == null) {
            ab.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.o(51215);
            return false;
        }
        polyline.remove();
        this.hNk.remove(str);
        AppMethodBeat.o(51215);
        return true;
    }

    public final void a(j jVar, com.tencent.mm.plugin.appbrand.d.a aVar) {
        AppMethodBeat.i(51216);
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        for (h hVar : jVar.hNV) {
            arrayList.add(new LatLng(hVar.latitude, hVar.longitude));
        }
        polylineOptions.addAll(arrayList);
        if (jVar.style != -1) {
            polylineOptions.color(jVar.style);
        } else {
            polylineOptions.color(jVar.color);
        }
        polylineOptions.width((float) jVar.width);
        polylineOptions.setDottedLine(jVar.hNW);
        polylineOptions.edgeColor(jVar.borderColor);
        polylineOptions.edgeWidth((float) jVar.borderWidth);
        if (jVar.hNX) {
            Bitmap bB = aVar.bB(jVar.hNY);
            polylineOptions.arrowTexture(new BitmapDescriptor(bB));
            if (bB == null) {
                polylineOptions.arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.aw6)));
            }
        }
        polylineOptions.zIndex(1.0f);
        if (!(bo.isNullOrNil(jVar.buildingId) || bo.isNullOrNil(jVar.floorName))) {
            polylineOptions.indoorInfo(new IndoorInfo(jVar.buildingId, jVar.floorName));
        }
        polylineOptions.arrowGap((float) jVar.hNZ);
        if (this.hMT.getMap().isHandDrawMapEnable()) {
            polylineOptions.level(OverlayLevel.OverlayLevelAboveBuildings);
        }
        Polyline addPolyline = this.hMT.getMap().addPolyline(polylineOptions);
        if (addPolyline == null) {
            ab.e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
            AppMethodBeat.o(51216);
            return;
        }
        this.hNk.put(bo.bc(bo.isNullOrNil(jVar.id) ? jVar.hashCode() : jVar.id, jVar.toString()), addPolyline);
        AppMethodBeat.o(51216);
    }

    public final void a(String str, int i, h hVar, boolean z) {
        AppMethodBeat.i(51217);
        Polyline polyline = (Polyline) this.hNk.get(str);
        if (polyline == null) {
            ab.w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.o(51217);
            return;
        }
        polyline.setEraseable(z);
        polyline.eraseTo(i, new LatLng(hVar.latitude, hVar.longitude));
        AppMethodBeat.o(51217);
    }

    public final q Bh(String str) {
        AppMethodBeat.i(51218);
        q qVar = (q) this.hNm.get(str);
        AppMethodBeat.o(51218);
        return qVar;
    }

    public final void aDZ() {
        AppMethodBeat.i(51219);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", this);
        for (d dVar : this.hNm.values()) {
            dVar.hNK.remove();
            if (dVar.hNL != null) {
                if (dVar.hNL.getMarkerView() != null && (dVar.hNL.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d)) {
                    i.a((com.tencent.mm.plugin.appbrand.widget.e.d) dVar.hNL.getMarkerView());
                }
                dVar.hNL.remove();
            }
        }
        this.hNm.clear();
        AppMethodBeat.o(51219);
    }

    public final boolean Bi(String str) {
        AppMethodBeat.i(51220);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", this, str);
        d dVar = (d) this.hNm.get(str);
        if (dVar == null) {
            ab.w("MicroMsg.DefaultTencentMapView", "marker:%s is null", str);
            AppMethodBeat.o(51220);
            return false;
        }
        dVar.hNK.remove();
        if (dVar.hNL != null) {
            if (dVar.hNL.getMarkerView() != null && (dVar.hNL.getMarkerView() instanceof com.tencent.mm.plugin.appbrand.widget.e.d)) {
                i.a((com.tencent.mm.plugin.appbrand.widget.e.d) dVar.hNL.getMarkerView());
            }
            dVar.hNL.remove();
            this.hNm.remove(str + "#label");
        }
        this.hNm.remove(str);
        AppMethodBeat.o(51220);
        return true;
    }

    public final void a(String str, r rVar, com.tencent.mm.plugin.appbrand.d.a aVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(51221);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", this, str);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(rVar.latitude, rVar.longitude));
        if (!bo.isNullOrNil(rVar.title)) {
            markerOptions.title(rVar.title);
        }
        if (!bo.isNullOrNil(rVar.hOd)) {
            markerOptions.contentDescription(rVar.hOd);
        }
        markerOptions.rotation(rVar.rotate);
        markerOptions.alpha(rVar.alpha);
        FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.rw, null);
        final ImageView imageView = (ImageView) frameLayout.findViewById(R.id.s0);
        final float f = rVar.hOb;
        final float f2 = rVar.hOc;
        if (aVar != null) {
            bitmap = aVar.a(rVar.hNN, null, new com.tencent.mm.plugin.appbrand.d.a.c() {
                public final void E(Bitmap bitmap) {
                    AppMethodBeat.i(138418);
                    if (bitmap != null) {
                        a.a(f, f2, bitmap, imageView);
                    }
                    AppMethodBeat.o(138418);
                }
            });
        }
        if (bitmap != null) {
            a(f, f2, bitmap, imageView);
        } else {
            ab.e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        }
        markerOptions.markerView(frameLayout);
        markerOptions.anchor(rVar.bDv, rVar.bDw);
        markerOptions.tag(str);
        markerOptions.infoWindowHideAnimation(new Animation() {
        });
        markerOptions.infoWindowShowAnimation(new Animation() {
        });
        markerOptions.visible(true);
        markerOptions.zIndex(rVar.zIndex + 2);
        if (!(bo.isNullOrNil(rVar.buildingId) || bo.isNullOrNil(rVar.floorName))) {
            markerOptions.indoorInfo(new IndoorInfo(rVar.buildingId, rVar.floorName));
        }
        Marker addMarker = this.hMT.getMap().addMarker(markerOptions);
        d dVar = new d();
        dVar.hNK = addMarker;
        dVar.data = rVar.data;
        dVar.hOa = rVar;
        a(str, dVar);
        if (rVar.hOe != null && rVar.hOe.hOl == com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a.hOn) {
            dVar.hNK.showInfoWindow();
        }
        if (rVar.hOf != null) {
            MarkerOptions markerOptions2 = new MarkerOptions();
            markerOptions2.position(new LatLng(rVar.latitude, rVar.longitude));
            markerOptions2.alpha(rVar.alpha);
            com.tencent.mm.plugin.appbrand.widget.e.d aEf = i.aEf();
            if (aEf == null) {
                aEf = new com.tencent.mm.plugin.appbrand.widget.e.d(this.context);
            }
            aEf.setText("");
            aEf.setTextSize(12);
            aEf.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.d.jjZ);
            aEf.setTextPadding(0);
            aEf.setGravity("center");
            int i = com.tencent.mm.plugin.appbrand.widget.e.d.jka;
            aEf.x(0, 0, i, i);
            aEf.setTextColor(rVar.hOf.color);
            aEf.setTextSize(rVar.hOf.hOg);
            aEf.setText(rVar.hOf.content);
            aEf.setTextPadding(rVar.hOf.padding);
            aEf.setGravity(rVar.hOf.hdq);
            aEf.x(rVar.hOf.hOh, rVar.hOf.borderWidth, rVar.hOf.borderColor, rVar.hOf.bgColor);
            aEf.setX(rVar.hOf.x);
            aEf.setY(rVar.hOf.y);
            aEf.measure(0, 0);
            markerOptions2.anchor(aEf.getAnchorX(), aEf.getAnchorY());
            markerOptions2.markerView(aEf);
            markerOptions2.visible(true);
            markerOptions2.tag(str + "#label");
            markerOptions2.zIndex(rVar.zIndex + 2);
            if (!(bo.isNullOrNil(rVar.buildingId) || bo.isNullOrNil(rVar.floorName))) {
                markerOptions2.indoorInfo(new IndoorInfo(rVar.buildingId, rVar.floorName));
            }
            dVar.hNL = this.hMT.getMap().addMarker(markerOptions2);
            a(str + "#label", dVar);
        }
        AppMethodBeat.o(51221);
    }

    static void a(float f, float f2, Bitmap bitmap, ImageView imageView) {
        AppMethodBeat.i(51222);
        if (f == 0.0f || f2 == 0.0f) {
            f = (float) com.tencent.mm.plugin.appbrand.r.g.qb(bitmap.getWidth());
            f2 = (float) com.tencent.mm.plugin.appbrand.r.g.qb(bitmap.getHeight());
        }
        if (f <= 0.0f || f2 <= 0.0f || (f == ((float) bitmap.getWidth()) && f2 == ((float) bitmap.getHeight()))) {
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ScaleType.CENTER);
            AppMethodBeat.o(51222);
            return;
        }
        float width = f / ((float) bitmap.getWidth());
        float height = f2 / ((float) bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
        AppMethodBeat.o(51222);
    }

    private void a(String str, d dVar) {
        AppMethodBeat.i(51223);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", this, str);
        this.hNm.put(str, dVar);
        AppMethodBeat.o(51223);
    }

    public final void a(String str, LinkedList<b.g> linkedList, final o oVar) {
        AppMethodBeat.i(51224);
        d dVar = (d) Bh(str);
        if (dVar == null || dVar.hNK == null) {
            ab.e("MicroMsg.DefaultTencentMapView", "get marker failed!");
            oVar.ec(false);
            AppMethodBeat.o(51224);
        } else if (linkedList.size() <= 0) {
            ab.e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
            oVar.ec(false);
            AppMethodBeat.o(51224);
        } else {
            b.g gVar = (b.g) linkedList.get(0);
            gVar.hNS = dVar.hNK.getPosition().getLatitude();
            gVar.hNR = dVar.hNK.getPosition().getLongitude();
            int size = linkedList.size();
            for (int i = 1; i < size; i++) {
                gVar = (b.g) linkedList.get(i - 1);
                b.g gVar2 = (b.g) linkedList.get(i);
                if (gVar.rotate == 0.0f) {
                    gVar2.hNR = gVar.longitude;
                    gVar2.hNS = gVar.latitude;
                } else {
                    gVar2.hNR = dVar.hNK.getPosition().getLongitude();
                    gVar2.hNS = dVar.hNK.getPosition().getLatitude();
                }
            }
            final com.tencent.mm.plugin.appbrand.widget.e.c cVar = new com.tencent.mm.plugin.appbrand.widget.e.c(linkedList, dVar.hNK, this.hMT);
            cVar.uB.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(138419);
                    ab.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
                    AppMethodBeat.o(138419);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(138420);
                    ab.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
                    if (oVar != null) {
                        oVar.ec(true);
                    }
                    AppMethodBeat.o(138420);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(138421);
                    cVar.uB.start();
                    AppMethodBeat.o(138421);
                }
            });
            if (dVar.hNL != null) {
                cVar = new com.tencent.mm.plugin.appbrand.widget.e.c(linkedList, dVar.hNL, this.hMT);
                m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(51161);
                        cVar.uB.start();
                        AppMethodBeat.o(51161);
                    }
                });
            }
            AppMethodBeat.o(51224);
        }
    }

    public final void a(n nVar) {
        this.hMV = nVar;
    }

    public final void a(k kVar) {
        this.hMU = kVar;
    }

    public final void aEa() {
        AppMethodBeat.i(51225);
        synchronized (this.hNn) {
            try {
                Iterator it = this.hNn.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).hNK.remove();
                }
                this.hNn.clear();
            } finally {
                AppMethodBeat.o(51225);
            }
        }
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d dVar, com.tencent.mm.plugin.appbrand.d.a aVar) {
        AppMethodBeat.i(51226);
        if (bo.isNullOrNil(dVar.hNN)) {
            AppMethodBeat.o(51226);
            return false;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(dVar.latitude, dVar.longitude));
        Bitmap bB = aVar.bB(dVar.hNN);
        if (!(bB == null || bB.isRecycled())) {
            markerOptions.icon(new BitmapDescriptor(bB));
        }
        markerOptions.rotation(dVar.rotate);
        Marker addMarker = this.hMT.getMap().addMarker(markerOptions);
        synchronized (this.hNn) {
            try {
                this.hNn.add(new c(addMarker));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51226);
            }
        }
        return true;
    }

    public final void aEb() {
        AppMethodBeat.i(51227);
        synchronized (this.hNo) {
            try {
                Iterator it = this.hNo.iterator();
                while (it.hasNext()) {
                    ((Polygon) it.next()).remove();
                }
                this.hNo.clear();
            } finally {
                AppMethodBeat.o(51227);
            }
        }
    }

    public final boolean a(v vVar) {
        AppMethodBeat.i(51228);
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        for (h hVar : vVar.hNV) {
            arrayList.add(new LatLng(hVar.latitude, hVar.longitude));
        }
        polygonOptions.addAll(arrayList);
        polygonOptions.fillColor(vVar.fillColor);
        polygonOptions.strokeColor(vVar.strokeColor);
        polygonOptions.strokeWidth((float) vVar.strokeWidth);
        polygonOptions.zIndex((float) vVar.zIndex);
        Polygon addPolygon = this.hMT.getMap().addPolygon(polygonOptions);
        synchronized (this.hNo) {
            try {
                this.hNo.add(addPolygon);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51228);
            }
        }
        return true;
    }

    public final void en(boolean z) {
        AppMethodBeat.i(51229);
        ab.i("MicroMsg.DefaultTencentMapView", "map:%s show location", this);
        this.hNp = z;
        d dVar;
        if (z) {
            if (this.hNq != null) {
                dVar = this.hNq;
                if (dVar.hNK != null) {
                    dVar.hNK.setVisible(true);
                }
            }
            ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).b("gcj02", this.hNr, aEc());
            g.a(this);
            AppMethodBeat.o(51229);
            return;
        }
        if (this.hNq != null) {
            dVar = this.hNq;
            if (dVar.hNK != null) {
                dVar.hNK.setVisible(false);
            }
        }
        ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).c("gcj02", this.hNr, aEc());
        g.b(this);
        AppMethodBeat.o(51229);
    }

    private Bundle aEc() {
        AppMethodBeat.i(51230);
        Bundle bundle = new Bundle();
        if (!"E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX".equals(this.hMW)) {
            bundle.putString("smallAppKey", bo.nullAsNil(bundle.getString("smallAppKey")) + this.hMW + "#" + this.hMX + ";");
        }
        AppMethodBeat.o(51230);
        return bundle;
    }

    public final void J(float f, float f2) {
        AppMethodBeat.i(51231);
        if (!this.hNp || this.isBackground) {
            AppMethodBeat.o(51231);
            return;
        }
        if (this.hNq != null) {
            this.hNq.J(f, f2);
        }
        AppMethodBeat.o(51231);
    }

    public String toString() {
        AppMethodBeat.i(51232);
        String str = "DefaultTencentMapView{mapId=" + this.hMR + '}';
        AppMethodBeat.o(51232);
        return str;
    }

    private static SurfaceView h(ViewGroup viewGroup) {
        AppMethodBeat.i(51233);
        while (viewGroup != null && viewGroup.getChildCount() != 0) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) childAt;
                    AppMethodBeat.o(51233);
                    return surfaceView;
                } else if (childAt instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt;
                } else {
                    i++;
                }
            }
            AppMethodBeat.o(51233);
            return null;
        }
        AppMethodBeat.o(51233);
        return null;
    }
}
