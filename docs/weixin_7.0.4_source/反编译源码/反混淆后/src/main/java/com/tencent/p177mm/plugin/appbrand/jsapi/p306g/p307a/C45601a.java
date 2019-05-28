package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

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
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C0991g;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10402o;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10404u;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10405v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10407e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10408f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10409g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10410m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10411x;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10412d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10413n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10414w;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10415p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10416a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10418q;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10419s;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10420t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10421b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10422c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10423i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10424j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10425k;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10426l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10427r;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10427r.C10428a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C19712a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C2459b;
import com.tencent.p177mm.plugin.appbrand.widget.p1235e.C38590c;
import com.tencent.p177mm.plugin.appbrand.widget.p1235e.C42724b;
import com.tencent.p177mm.plugin.appbrand.widget.p1235e.C45715d;
import com.tencent.p177mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a */
public class C45601a implements C10406b {
    ImageView cAw;
    Context context;
    private String hMR;
    FrameLayout hMS;
    protected final SoSoMapView hMT;
    C10425k hMU;
    C10413n hMV;
    private String hMW;
    private String hMX;
    private int hMY;
    CameraPosition hMZ;
    SurfaceView hNa;
    private Runnable hNb = new C2697922();
    C10426l hNc;
    C10404u hNd;
    boolean hNe = false;
    private Runnable hNf;
    C10420t hNg;
    C10407e hNh;
    public ArrayList<Circle> hNi = new ArrayList();
    public ArrayList<C42514b> hNj = new ArrayList();
    private Map<String, Polyline> hNk = new ConcurrentHashMap();
    private C24696a hNl = new C24696a();
    Map<String, C42516d> hNm = new ConcurrentHashMap();
    public ArrayList<C42515c> hNn = new ArrayList();
    public ArrayList<Polygon> hNo = new ArrayList();
    boolean hNp;
    C19388d hNq;
    private C2459b hNr = new C3331715();
    private final int hNs = 500;
    AtomicBoolean hNt = new AtomicBoolean(false);
    private AtomicBoolean hNu = new AtomicBoolean(false);
    boolean isBackground;
    private long lastCheckTime = 0;
    private int mMapType;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$10 */
    class C228310 extends Animation {
        C228310() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$19 */
    class C1039919 implements OnMapPoiClickListener {
        C1039919() {
        }

        public final void onClicked(MapPoi mapPoi) {
            AppMethodBeat.m2504i(51168);
            if (C45601a.this.hNd != null) {
                C10415p c10415p = new C10415p();
                c10415p.latitude = mapPoi.getPosition().getLatitude();
                c10415p.longitude = mapPoi.getPosition().getLongitude();
                c10415p.name = mapPoi.getName();
                if ((mapPoi instanceof IndoorMapPoi) && !C5046bo.isNullOrNil(((IndoorMapPoi) mapPoi).getBuildingId())) {
                    c10415p.buildingId = ((IndoorMapPoi) mapPoi).getBuildingId();
                    c10415p.floorName = ((IndoorMapPoi) mapPoi).getFloorName();
                }
                C45601a.this.hNd.mo6230a(c10415p);
            }
            AppMethodBeat.m2505o(51168);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$21 */
    class C1040021 implements OnScreenShotListener {
        C1040021() {
        }

        public final void onMapScreenShot(Bitmap bitmap) {
            AppMethodBeat.m2504i(51172);
            if (bitmap != null) {
                C45601a.this.cAw.setImageBitmap(bitmap);
            }
            AppMethodBeat.m2505o(51172);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$23 */
    class C1040123 implements TencentMapGestureListener {
        C1040123() {
        }

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
            C45601a.this.hNe = true;
            return false;
        }

        public final boolean onUp(float f, float f2) {
            return false;
        }

        public final void onMapStable() {
            C45601a.this.hNe = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$17 */
    class C1938417 implements OnMapClickListener {
        C1938417() {
        }

        public final void onMapClick(LatLng latLng) {
            AppMethodBeat.m2504i(51166);
            for (C42516d c42516d : C45601a.this.hNm.values()) {
                if (c42516d.hOa != null && c42516d.hOa.hOe != null && c42516d.hOa.hOe.hOl == C10428a.hOm && c42516d.hNK.isInfoWindowShown()) {
                    c42516d.hNK.hideInfoWindow();
                }
            }
            if (C45601a.this.hNc != null) {
                C45601a.this.hNc.aDL();
                AppMethodBeat.m2505o(51166);
                return;
            }
            AppMethodBeat.m2505o(51166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$4 */
    class C193864 implements Runnable {
        C193864() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51152);
            ViewGroup viewGroup = C45601a.this.hMS;
            synchronized (C45601a.this.hNj) {
                try {
                    Iterator it = C45601a.this.hNj.iterator();
                    while (it.hasNext()) {
                        viewGroup.removeView(((C42514b) it.next()).hNJ);
                    }
                    C45601a.this.hNj.clear();
                } finally {
                    AppMethodBeat.m2505o(51152);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$a */
    public class C24696a implements InfoWindowAdapter {
        public final View getInfoWindow(Marker marker) {
            AppMethodBeat.m2504i(51175);
            if (marker == null) {
                C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "realMarker is null, return");
                AppMethodBeat.m2505o(51175);
                return null;
            } else if (C5046bo.isNullOrNil((String) marker.getTag())) {
                C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                AppMethodBeat.m2505o(51175);
                return null;
            } else if (((String) marker.getTag()).endsWith("#label")) {
                AppMethodBeat.m2505o(51175);
                return null;
            } else {
                C42516d c42516d = (C42516d) C45601a.this.mo73390Bh((String) marker.getTag());
                if (c42516d == null) {
                    C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
                    AppMethodBeat.m2505o(51175);
                    return null;
                } else if (c42516d.hOa == null) {
                    C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
                    AppMethodBeat.m2505o(51175);
                    return null;
                } else {
                    C10428a c10428a = c42516d.hOa.hOe;
                    if (c10428a == null) {
                        AppMethodBeat.m2505o(51175);
                        return null;
                    }
                    C45601a c45601a = C45601a.this;
                    View aEe = C38304i.aEe();
                    if (aEe == null) {
                        aEe = new C42724b(c45601a.context);
                    }
                    aEe.setText("");
                    aEe.setTextSize(12);
                    aEe.setTextColor(C42724b.jjZ);
                    aEe.setTitlePadding(0);
                    aEe.setGravity("center");
                    int i = C42724b.jka;
                    aEe.mo68162x(0, 0, i, i);
                    aEe.setText(c10428a.content);
                    aEe.setTextSize(c10428a.hOg);
                    aEe.setTextColor(c10428a.color);
                    aEe.setTitlePadding(c10428a.padding);
                    aEe.setGravity(c10428a.hdq);
                    aEe.mo68162x(c10428a.hOh, c10428a.borderWidth, c10428a.borderColor, c10428a.bgColor);
                    AppMethodBeat.m2505o(51175);
                    return aEe;
                }
            }
        }

        public final void onInfoWindowDettached(Marker marker, View view) {
            AppMethodBeat.m2504i(51176);
            if (view instanceof C42724b) {
                C4990ab.m7410d("MicroMsg.DefaultTencentMapView", "recycler calloutView");
                C38304i.m64819a((C42724b) view);
            }
            AppMethodBeat.m2505o(51176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$18 */
    class C2697818 implements OnMapLoadedListener {
        C2697818() {
        }

        public final void onMapLoaded() {
            AppMethodBeat.m2504i(51167);
            C45601a.m84118a(C45601a.this);
            AppMethodBeat.m2505o(51167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$22 */
    class C2697922 implements Runnable {
        C2697922() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51173);
            C45601a.this.hNa.setVisibility(4);
            AppMethodBeat.m2505o(51173);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$3 */
    class C269803 implements Runnable {
        C269803() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138414);
            if (C45601a.this.hNq != null && C45601a.this.hNp) {
                C45601a.this.hMT.getIController().animateTo(C45601a.this.hNq.getLatitude(), C45601a.this.hNq.getLongitude());
                C4990ab.m7411d("MicroMsg.DefaultTencentMapView", "[moveToMapLocation]latitude:%f, longtitude:%f", Double.valueOf(r0), Double.valueOf(r2));
            }
            AppMethodBeat.m2505o(138414);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$16 */
    class C3130216 implements OnScreenShotListener {
        C3130216() {
        }

        public final void onMapScreenShot(Bitmap bitmap) {
            AppMethodBeat.m2504i(138424);
            C4990ab.m7418v("MicroMsg.DefaultTencentMapView", "updateScreenCapture end");
            if (bitmap != null) {
                C45601a.this.cAw.setImageBitmap(bitmap);
            }
            C45601a.this.hNt.set(false);
            AppMethodBeat.m2505o(138424);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$12 */
    class C3331412 implements OnMarkerClickListener {
        C3331412() {
        }

        public final boolean onMarkerClick(Marker marker) {
            AppMethodBeat.m2504i(51158);
            if (marker == null) {
                C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "realMarker is null");
                AppMethodBeat.m2505o(51158);
                return false;
            }
            C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s markerid:%s, onMarkerClick", this, marker.getTag());
            if (C5046bo.isNullOrNil((String) marker.getTag())) {
                C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is null, return");
                AppMethodBeat.m2505o(51158);
                return false;
            } else if (((String) marker.getTag()).endsWith("#label")) {
                C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "realMarker.getTag is label marker, return");
                AppMethodBeat.m2505o(51158);
                return false;
            } else {
                C42516d c42516d = (C42516d) C45601a.this.mo73390Bh((String) marker.getTag());
                if (c42516d == null) {
                    C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s appbrandMarker is null, return", this);
                    AppMethodBeat.m2505o(51158);
                    return false;
                } else if (C45601a.this.hMV == null) {
                    C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", this);
                    AppMethodBeat.m2505o(51158);
                    return false;
                } else {
                    if (c42516d.hOa != null) {
                        C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "[onMarkerClickListener] map:%s mapCalloutClick is null, return", this);
                        C10428a c10428a = c42516d.hOa.hOe;
                        if (c10428a != null && c10428a.hOl == C10428a.hOm && c42516d.hNK.isInfoWindowShown()) {
                            c42516d.hNK.hideInfoWindow();
                        } else {
                            c42516d.hNK.showInfoWindow();
                        }
                    }
                    if (c42516d.hNK != null) {
                        c42516d.hNK.set2Top();
                    }
                    if (c42516d.hNL != null) {
                        c42516d.hNL.set2Top();
                    }
                    if (C45601a.this.hNq != null) {
                        C19388d c19388d = C45601a.this.hNq;
                        if (c19388d.hNK != null) {
                            c19388d.hNK.set2Top();
                        }
                    }
                    boolean b = C45601a.this.hMV.mo6163b(c42516d);
                    AppMethodBeat.m2505o(51158);
                    return b;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$15 */
    class C3331715 implements C2459b {
        C3331715() {
        }

        /* renamed from: a */
        public final void mo6153a(int i, String str, final C19712a c19712a) {
            AppMethodBeat.m2504i(138423);
            if (i != 0) {
                C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "errCode:%d, errStr:%s", Integer.valueOf(i), str);
                AppMethodBeat.m2505o(138423);
                return;
            }
            C4990ab.m7411d("MicroMsg.DefaultTencentMapView", "refresh location latitude = %f, longitude = %f", Double.valueOf(c19712a.latitude), Double.valueOf(c19712a.longitude));
            if (!C0991g.m2253o(C4996ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "refresh location fail, no perrmission");
                AppMethodBeat.m2505o(138423);
            } else if (!C45601a.this.hNp || C45601a.this.isBackground) {
                AppMethodBeat.m2505o(138423);
            } else {
                C45673m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(138422);
                        if (C45601a.this.hMT != null) {
                            if (C45601a.this.hNq == null) {
                                C45601a.this.hNq = new C19388d(C45601a.this.context);
                                C19388d c19388d = C45601a.this.hNq;
                                SoSoMapView soSoMapView = C45601a.this.hMT;
                                C19712a c19712a = c19712a;
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.anchor(0.5f, 0.5f);
                                markerOptions.position(new LatLng(c19712a.latitude, c19712a.longitude));
                                markerOptions.markerView(c19388d);
                                markerOptions.zIndex(BaseClientBuilder.API_PRIORITY_OTHER);
                                markerOptions.flat(true);
                                c19388d.hNK = soSoMapView.getMap().addMarker(markerOptions);
                            }
                            C19388d c19388d2 = C45601a.this.hNq;
                            double d = c19712a.latitude;
                            double d2 = c19712a.longitude;
                            String str = c19712a.bIy;
                            double d3 = c19712a.iSf;
                            if (c19388d2.hOt == -1.0d && c19388d2.hOu == -1.0d) {
                                c19388d2.hOt = d;
                                c19388d2.hOr = d;
                                c19388d2.hOu = d2;
                                c19388d2.hOs = d2;
                            } else {
                                c19388d2.hOt = c19388d2.hOr;
                                c19388d2.hOu = c19388d2.hOs;
                                c19388d2.hOs = d2;
                                c19388d2.hOr = d;
                            }
                            if (!(c19388d2.hOt == -1.0d || c19388d2.hOu == -1.0d)) {
                                c19388d2.hOy = C38303f.m64814a(c19388d2.hOu, c19388d2.hOt, d2, d, str, d3);
                            }
                            if (c19388d2.hOw == 900.0f || c19388d2.hOv == 900.0f) {
                                float h = (float) C38303f.m64818h(d, d2);
                                c19388d2.hOv = h;
                                c19388d2.hOw = h;
                            } else {
                                c19388d2.hOw = c19388d2.hOv;
                                c19388d2.hOv = (float) C38303f.m64818h(d, d2);
                            }
                            if (c19388d2.hNK != null) {
                                c19388d2.hNK.setPosition(new LatLng(d, d2));
                            }
                        }
                        AppMethodBeat.m2505o(138422);
                    }
                });
                AppMethodBeat.m2505o(138423);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$1 */
    class C383011 implements OnInfoWindowClickListener {
        C383011() {
        }

        public final void onInfoWindowClick(Marker marker) {
            AppMethodBeat.m2504i(51149);
            if (marker == null) {
                C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "realMarker is null");
                AppMethodBeat.m2505o(51149);
                return;
            }
            C42516d c42516d = (C42516d) C45601a.this.mo73390Bh((String) marker.getTag());
            if (c42516d == null) {
                C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s appbrandMarker is null, return", this);
                AppMethodBeat.m2505o(51149);
            } else if (C45601a.this.hMU == null) {
                C4990ab.m7413e("MicroMsg.DefaultTencentMapView", "[onInfoWindowClick] map:%s mapCalloutClick is null, return", this);
                AppMethodBeat.m2505o(51149);
            } else {
                C45601a.this.hMU.mo21939a(c42516d);
                AppMethodBeat.m2505o(51149);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$20 */
    class C4251020 implements OnIndoorStateChangeListener {
        C4251020() {
        }

        public final boolean onIndoorBuildingFocused() {
            AppMethodBeat.m2504i(51169);
            C4990ab.m7418v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
            AppMethodBeat.m2505o(51169);
            return true;
        }

        public final boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
            AppMethodBeat.m2504i(51170);
            C4990ab.m7419v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", indoorBuilding);
            if (C45601a.this.hNg != null) {
                C10407e c10407e = new C10407e();
                c10407e.buildingId = indoorBuilding.getBuidlingId();
                c10407e.buildingName = indoorBuilding.getBuildingName();
                c10407e.hNP = new LinkedList();
                for (IndoorLevel indoorLevel : indoorBuilding.getLevels()) {
                    C10408f c10408f = new C10408f();
                    c10408f.floorName = indoorLevel.getName();
                    c10407e.hNP.add(c10408f);
                }
                c10407e.hNQ = indoorBuilding.getActiveLevelIndex();
                C45601a.this.hNh = c10407e;
                C45601a.this.hNg.mo21938a(c10407e);
            }
            AppMethodBeat.m2505o(51170);
            return true;
        }

        public final boolean onIndoorBuildingDeactivated() {
            AppMethodBeat.m2504i(51171);
            C4990ab.m7418v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
            if (C45601a.this.hNg != null) {
                C10407e aDN = C45601a.aDN();
                C45601a.this.hNh = aDN;
                C45601a.this.hNg.mo21938a(aDN);
            }
            AppMethodBeat.m2505o(51171);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$9 */
    class C425139 extends Animation {
        C425139() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$b */
    public class C42514b {
        ImageView hNJ;

        public C42514b(ImageView imageView) {
            this.hNJ = imageView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$c */
    public class C42515c {
        Marker hNK;

        public C42515c(Marker marker) {
            this.hNK = marker;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.a$d */
    public static class C42516d extends C10418q {
        public Marker hNK;
        public Marker hNL;
    }

    public C45601a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.m2504i(51177);
        this.context = context;
        this.hMR = str;
        this.hMS = new FrameLayout(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.hMS.setBackgroundColor(0);
        this.hMS.setLayoutParams(layoutParams);
        this.hMT = new SoSoMapView(context, mo61042A(map));
        this.hMS.addView(this.hMT, new LayoutParams(-1, -1));
        this.cAw = new ImageView(context);
        this.cAw.setScaleType(ScaleType.FIT_XY);
        this.hMS.addView(this.cAw, new ViewGroup.LayoutParams(-1, -1));
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s, init", this);
        this.hMT.getMap().setInfoWindowAdapter(this.hNl);
        this.hMT.getMap().setMapAnchor(0.5f, 0.5f);
        this.hMT.getMap().enableMultipleInfowindow(true);
        this.hMT.getMap().setMapStyle(this.hMY);
        this.hMT.getMap().setOnInfoWindowClickListener(new C383011());
        this.hMT.getMap().setOnMarkerClickListener(new C3331412());
        this.hMT.getMap().setOnMapClickListener(new C1938417());
        this.hMT.getMap().setOnMapLoadedListener(new C2697818());
        this.hMT.getMap().setOnMapPoiClickListener(new C1039919());
        this.hMT.getMap().setOnIndoorStateChangeListener(new C4251020());
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s onCreate", this);
        this.hMT.onCreate(null);
        onResume();
        AppMethodBeat.m2505o(51177);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: A */
    public TencentMapOptions mo61042A(Map<String, Object> map) {
        AppMethodBeat.m2504i(51178);
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        if (map == null) {
            C4990ab.m7420w("MicroMsg.DefaultTencentMapView", "params is null, return");
            AppMethodBeat.m2505o(51178);
        } else {
            tencentMapOptions.enableHandDrawMap(C38303f.m64813a((Map) map, "theme", "normal").equals("handDraw"));
            this.mMapType = C38303f.m64812a((Map) map, "mapType", 1);
            tencentMapOptions.setMapType(this.mMapType);
            this.hMW = C38303f.m64813a((Map) map, "subKey", "");
            this.hMX = C38303f.m64813a((Map) map, "subId", "");
            if (C5046bo.isNullOrNil(this.hMW)) {
                this.hMW = "E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX";
                this.hMX = "";
            }
            tencentMapOptions.setSubInfo(this.hMW, this.hMX);
            this.hMY = C38303f.m64812a((Map) map, "styleId", 0);
            C4990ab.m7411d("MicroMsg.DefaultTencentMapView", "MapReport subId:%s, subKey:%s", this.hMX, this.hMW);
            C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "[createTencentMapOptions]theme:%s isHandDraw:%b, mapType:%d, subId:%s, subKey:%s, styleId:%d", r1, Boolean.valueOf(r2), Integer.valueOf(this.mMapType), this.hMX, this.hMW, Integer.valueOf(this.hMY));
            AppMethodBeat.m2505o(51178);
        }
        return tencentMapOptions;
    }

    static C10407e aDN() {
        AppMethodBeat.m2504i(51179);
        C10407e c10407e = new C10407e();
        c10407e.buildingId = "";
        c10407e.buildingName = "";
        c10407e.hNP = new LinkedList();
        c10407e.hNQ = -1;
        AppMethodBeat.m2505o(51179);
        return c10407e;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(51180);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s onResume", this);
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
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20055b("gcj02", this.hNr, aEc());
            C33320g.m54491a(this);
        }
        AppMethodBeat.m2505o(51180);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(51181);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s onPause", this);
        if (this.mMapType == 0) {
            this.cAw.setVisibility(0);
            if (this.hNa == null) {
                this.hNa = aDO();
            }
            if (this.hNa != null) {
                C5004al.m7442n(this.hNb, 100);
            } else {
                C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "hideTencentMap err");
            }
            this.hMT.setVisibility(4);
            this.hMT.getMap().getScreenShot(new C1040021());
        } else {
            this.hMT.onPause();
        }
        this.isBackground = true;
        if (this.hNp) {
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20056c("gcj02", this.hNr, aEc());
            C33320g.m54493b(this);
        }
        AppMethodBeat.m2505o(51181);
    }

    private SurfaceView aDO() {
        AppMethodBeat.m2504i(51182);
        SurfaceView surfaceView;
        if (this.hNa != null) {
            surfaceView = this.hNa;
            AppMethodBeat.m2505o(51182);
            return surfaceView;
        }
        this.hNa = C45601a.m84120h(this.hMT);
        surfaceView = this.hNa;
        AppMethodBeat.m2505o(51182);
        return surfaceView;
    }

    private void aDP() {
        AppMethodBeat.m2504i(51183);
        if (this.hNa == null) {
            this.hNa = aDO();
        }
        if (this.hNa != null) {
            C5004al.m7439af(this.hNb);
            this.hNa.setVisibility(0);
            AppMethodBeat.m2505o(51183);
            return;
        }
        C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "showTencentMap err");
        AppMethodBeat.m2505o(51183);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(51184);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s onDestroy", this);
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
            C19388d c19388d = this.hNq;
            if (c19388d.hNK != null) {
                c19388d.hNK.remove();
                c19388d.hNK = null;
            }
            this.hNq = null;
        }
        AppMethodBeat.m2505o(51184);
    }

    public final View getView() {
        return this.hMS;
    }

    /* renamed from: a */
    public final void mo21887a(C10426l c10426l) {
        this.hNc = c10426l;
    }

    /* renamed from: a */
    public final void mo21891a(C10404u c10404u) {
        this.hNd = c10404u;
    }

    public final C10414w aDQ() {
        AppMethodBeat.m2504i(51185);
        LatLngBounds latLngBounds = this.hMT.getProjection().getVisibleRegion().getLatLngBounds();
        C10423i c10423i = new C10423i();
        c10423i.hNT = new C10417h(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude());
        c10423i.hNU = new C10417h(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude());
        C10411x c10411x = new C10411x();
        c10411x.hOp = c10423i;
        C10414w c10414w = new C10414w();
        c10414w.hOo = c10411x;
        AppMethodBeat.m2505o(51185);
        return c10414w;
    }

    /* renamed from: a */
    public final void mo21889a(final C10419s c10419s) {
        AppMethodBeat.m2504i(51186);
        this.hMT.getMap().setTencentMapGestureListener(new C1040123());
        this.hMT.getMap().setOnMapCameraChangeListener(new OnMapCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                AppMethodBeat.m2504i(138412);
                if (c10419s != null) {
                    C10416a c10416a = new C10416a();
                    c10416a.hNM = new C10417h(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    c10416a.zoom = cameraPosition.getZoom();
                    c10416a.rotate = cameraPosition.getBearing();
                    c10416a.skew = cameraPosition.getSkew();
                    c10419s.mo21936a(c10416a);
                }
                AppMethodBeat.m2505o(138412);
            }

            public final void onCameraChangeFinish(CameraPosition cameraPosition) {
                AppMethodBeat.m2504i(138413);
                C45601a.this.hMZ = cameraPosition;
                if (c10419s != null) {
                    C10416a c10416a = new C10416a();
                    c10416a.hNM = new C10417h(cameraPosition.getTarget().getLatitude(), cameraPosition.getTarget().getLongitude());
                    c10416a.zoom = cameraPosition.getZoom();
                    c10416a.rotate = cameraPosition.getBearing();
                    c10416a.skew = cameraPosition.getSkew();
                    c10419s.mo21937a(c10416a, C45601a.this.hNe);
                }
                C45601a.m84118a(C45601a.this);
                AppMethodBeat.m2505o(138413);
            }
        });
        AppMethodBeat.m2505o(51186);
    }

    public final void aDR() {
        AppMethodBeat.m2504i(51187);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s moveToMapLocation", this);
        this.hNf = new C269803();
        if (this.hNq != null && this.hNp) {
            this.hNf.run();
            this.hNf = null;
        }
        AppMethodBeat.m2505o(51187);
    }

    /* renamed from: al */
    public final void mo21910al(float f) {
        AppMethodBeat.m2504i(51188);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s zoomTo scale:%f", this, Float.valueOf(f));
        TencentMap map = this.hMT.getMap();
        if (map != null) {
            map.animateCamera(CameraUpdateFactory.zoomTo(f));
        }
        AppMethodBeat.m2505o(51188);
    }

    /* renamed from: am */
    public final void mo21911am(float f) {
        AppMethodBeat.m2504i(51189);
        TencentMap map = this.hMT.getMap();
        if (!(map == null || this.hMZ == null)) {
            map.animateCamera(CameraUpdateFactory.newCameraPosition(new Builder(this.hMZ).skew(this.hMZ.getSkew()).bearing(f).build()));
        }
        AppMethodBeat.m2505o(51189);
    }

    /* renamed from: an */
    public final void mo21912an(float f) {
        AppMethodBeat.m2504i(51190);
        TencentMap map = this.hMT.getMap();
        if (!(map == null || this.hMZ == null)) {
            map.animateCamera(CameraUpdateFactory.newCameraPosition(new Builder(this.hMZ).skew(f).bearing(this.hMZ.getBearing()).build()));
        }
        AppMethodBeat.m2505o(51190);
    }

    public final int getZoomLevel() {
        AppMethodBeat.m2504i(51191);
        int zoomLevel = this.hMT.getMap().getZoomLevel();
        AppMethodBeat.m2505o(51191);
        return zoomLevel;
    }

    public final float aDS() {
        AppMethodBeat.m2504i(51192);
        if (this.hMZ != null) {
            float bearing = this.hMZ.getBearing();
            AppMethodBeat.m2505o(51192);
            return bearing;
        }
        C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
        AppMethodBeat.m2505o(51192);
        return 0.0f;
    }

    public final float getSkew() {
        AppMethodBeat.m2504i(51193);
        if (this.hMZ != null) {
            float skew = this.hMZ.getSkew();
            AppMethodBeat.m2505o(51193);
            return skew;
        }
        C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "getRotate fail, curCameraPosition is null");
        AppMethodBeat.m2505o(51193);
        return 0.0f;
    }

    /* renamed from: ed */
    public final void mo21914ed(boolean z) {
        AppMethodBeat.m2504i(51194);
        this.hMT.getUiSettings().setZoomGesturesEnabled(z);
        AppMethodBeat.m2505o(51194);
    }

    /* renamed from: ee */
    public final void mo21915ee(boolean z) {
        AppMethodBeat.m2504i(51195);
        this.hMT.getUiSettings().setScrollGesturesEnabled(z);
        AppMethodBeat.m2505o(51195);
    }

    /* renamed from: ef */
    public final void mo21916ef(boolean z) {
        AppMethodBeat.m2504i(51196);
        this.hMT.getUiSettings().setRotateGesturesEnabled(z);
        AppMethodBeat.m2505o(51196);
    }

    /* renamed from: eg */
    public final void mo21917eg(boolean z) {
        AppMethodBeat.m2504i(51197);
        this.hMT.getUiSettings().setCompassEnabled(z);
        AppMethodBeat.m2505o(51197);
    }

    /* renamed from: eh */
    public final void mo21918eh(boolean z) {
        AppMethodBeat.m2504i(51198);
        this.hMT.getMap().set3DEnable(z);
        AppMethodBeat.m2505o(51198);
    }

    /* renamed from: ei */
    public final void mo21919ei(boolean z) {
        AppMethodBeat.m2504i(51199);
        this.hMT.getUiSettings().setTiltGesturesEnabled(z);
        AppMethodBeat.m2505o(51199);
    }

    /* renamed from: ej */
    public final void mo21920ej(boolean z) {
        AppMethodBeat.m2504i(VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
        this.hMT.getMap().setSatelliteEnabled(z);
        AppMethodBeat.m2505o(VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
    }

    /* renamed from: ek */
    public final void mo21921ek(boolean z) {
        AppMethodBeat.m2504i(51201);
        this.hMT.getMap().setTrafficEnabled(z);
        AppMethodBeat.m2505o(51201);
    }

    /* renamed from: el */
    public final void mo21922el(boolean z) {
        AppMethodBeat.m2504i(51202);
        this.hMT.getMap().setIndoorEnabled(z);
        AppMethodBeat.m2505o(51202);
    }

    /* renamed from: a */
    public final void mo21890a(C10420t c10420t) {
        this.hNg = c10420t;
    }

    /* renamed from: ci */
    public final void mo21913ci(String str, String str2) {
        AppMethodBeat.m2504i(51203);
        this.hMT.getMap().setIndoorFloor(str, str2);
        AppMethodBeat.m2505o(51203);
    }

    public final C10407e aDT() {
        AppMethodBeat.m2504i(51204);
        C10407e c10407e;
        if (this.hNh != null) {
            c10407e = this.hNh;
            AppMethodBeat.m2505o(51204);
            return c10407e;
        }
        c10407e = C45601a.aDN();
        AppMethodBeat.m2505o(51204);
        return c10407e;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
    }

    public void onSizeChanged(int i, int i2) {
    }

    public boolean aDU() {
        return false;
    }

    /* renamed from: em */
    public final void mo21923em(boolean z) {
        AppMethodBeat.m2504i(51205);
        this.hMT.getUiSettings().setIndoorLevelPickerEnabled(z);
        AppMethodBeat.m2505o(51205);
    }

    /* renamed from: I */
    public final void mo21882I(float f, float f2) {
        AppMethodBeat.m2504i(51206);
        this.hMT.getIController().setCenter((double) f, (double) f2);
        AppMethodBeat.m2505o(51206);
    }

    public final C10417h aDV() {
        AppMethodBeat.m2504i(51207);
        LatLng mapCenter = this.hMT.getMap().getMapCenter();
        C10417h c10417h = new C10417h(mapCenter.getLatitude(), mapCenter.getLongitude());
        AppMethodBeat.m2505o(51207);
        return c10417h;
    }

    /* renamed from: h */
    public final void mo21928h(List<C10417h> list, int i) {
        AppMethodBeat.m2504i(51208);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterable linkedList = new LinkedList();
        for (C10417h c10417h : list) {
            linkedList.add(new LatLng(c10417h.latitude, c10417h.longitude));
        }
        builder.include(linkedList);
        this.hMT.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i));
        this.hNf = null;
        AppMethodBeat.m2505o(51208);
    }

    /* renamed from: a */
    public final void mo21883a(float f, float f2, float f3, float f4, float f5) {
        AppMethodBeat.m2504i(51209);
        TencentMap map = this.hMT.getMap();
        if (map != null) {
            map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng((double) f, (double) f2), f3, f5, f4)));
            this.hNf = null;
        }
        AppMethodBeat.m2505o(51209);
    }

    public final void aDW() {
        AppMethodBeat.m2504i(51210);
        synchronized (this.hNi) {
            try {
                Iterator it = this.hNi.iterator();
                while (it.hasNext()) {
                    ((Circle) it.next()).remove();
                }
                this.hNi.clear();
            } finally {
                AppMethodBeat.m2505o(51210);
            }
        }
    }

    /* renamed from: a */
    public final void mo21884a(C10421b c10421b) {
        AppMethodBeat.m2504i(51211);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(c10421b.latitude, c10421b.longitude));
        circleOptions.radius((double) c10421b.radius);
        circleOptions.strokeColor(c10421b.strokeColor);
        circleOptions.strokeWidth((float) c10421b.strokeWidth);
        circleOptions.fillColor(c10421b.fillColor);
        Circle addCircle = this.hMT.getMap().addCircle(circleOptions);
        synchronized (this.hNi) {
            try {
                this.hNi.add(addCircle);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51211);
            }
        }
    }

    public final void aDX() {
        AppMethodBeat.m2504i(51212);
        C45673m.runOnUiThread(new C193864());
        AppMethodBeat.m2505o(51212);
    }

    /* renamed from: a */
    public final boolean mo21895a(C10422c c10422c, final C10410m c10410m, C19162a c19162a) {
        AppMethodBeat.m2504i(51213);
        if (C5046bo.isNullOrNil(c10422c.hNN)) {
            AppMethodBeat.m2505o(51213);
            return false;
        }
        Bitmap bB = c19162a.mo34403bB(c10422c.hNN);
        if (bB == null) {
            AppMethodBeat.m2505o(51213);
            return false;
        }
        final ImageView imageView = new ImageView(this.context);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageBitmap(bB);
        int i = c10422c.left;
        int i2 = c10422c.top;
        final LayoutParams layoutParams = new LayoutParams(c10422c.width == 0 ? C42668g.m75571qb(bB.getWidth()) : c10422c.width, c10422c.height == 0 ? C42668g.m75571qb(bB.getHeight()) : c10422c.height);
        layoutParams.setMargins(i, i2, 0, 0);
        final boolean z = c10422c.hNO;
        final String str = c10422c.data;
        imageView.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(138415);
                if (z) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        imageView.setColorFilter(Color.parseColor("#88888888"));
                    } else if (action == 3 || action == 1) {
                        imageView.clearColorFilter();
                    }
                }
                AppMethodBeat.m2505o(138415);
                return false;
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(138416);
                if (z && c10410m != null) {
                    c10410m.mo21934Bf(str);
                }
                AppMethodBeat.m2505o(138416);
            }
        });
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(138417);
                C45601a.this.hMS.addView(imageView, layoutParams);
                synchronized (C45601a.this.hNj) {
                    try {
                        C45601a.this.hNj.add(new C42514b(imageView));
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(138417);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(51213);
        return true;
    }

    public final void aDY() {
        AppMethodBeat.m2504i(51214);
        for (Polyline remove : this.hNk.values()) {
            remove.remove();
        }
        this.hNk.clear();
        AppMethodBeat.m2505o(51214);
    }

    /* renamed from: Bg */
    public final boolean mo21880Bg(String str) {
        AppMethodBeat.m2504i(51215);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s removeLine lineId:%s", this, str);
        Polyline polyline = (Polyline) this.hNk.get(str);
        if (polyline == null) {
            C4990ab.m7421w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.m2505o(51215);
            return false;
        }
        polyline.remove();
        this.hNk.remove(str);
        AppMethodBeat.m2505o(51215);
        return true;
    }

    /* renamed from: a */
    public final void mo21885a(C10424j c10424j, C19162a c19162a) {
        AppMethodBeat.m2504i(51216);
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        for (C10417h c10417h : c10424j.hNV) {
            arrayList.add(new LatLng(c10417h.latitude, c10417h.longitude));
        }
        polylineOptions.addAll(arrayList);
        if (c10424j.style != -1) {
            polylineOptions.color(c10424j.style);
        } else {
            polylineOptions.color(c10424j.color);
        }
        polylineOptions.width((float) c10424j.width);
        polylineOptions.setDottedLine(c10424j.hNW);
        polylineOptions.edgeColor(c10424j.borderColor);
        polylineOptions.edgeWidth((float) c10424j.borderWidth);
        if (c10424j.hNX) {
            Bitmap bB = c19162a.mo34403bB(c10424j.hNY);
            polylineOptions.arrowTexture(new BitmapDescriptor(bB));
            if (bB == null) {
                polylineOptions.arrowTexture(new BitmapDescriptor(BitmapFactory.decodeResource(this.context.getResources(), C25738R.drawable.aw6)));
            }
        }
        polylineOptions.zIndex(1.0f);
        if (!(C5046bo.isNullOrNil(c10424j.buildingId) || C5046bo.isNullOrNil(c10424j.floorName))) {
            polylineOptions.indoorInfo(new IndoorInfo(c10424j.buildingId, c10424j.floorName));
        }
        polylineOptions.arrowGap((float) c10424j.hNZ);
        if (this.hMT.getMap().isHandDrawMapEnable()) {
            polylineOptions.level(OverlayLevel.OverlayLevelAboveBuildings);
        }
        Polyline addPolyline = this.hMT.getMap().addPolyline(polylineOptions);
        if (addPolyline == null) {
            C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "polyline is null, return");
            AppMethodBeat.m2505o(51216);
            return;
        }
        this.hNk.put(C5046bo.m7532bc(C5046bo.isNullOrNil(c10424j.f2876id) ? c10424j.hashCode() : c10424j.f2876id, c10424j.toString()), addPolyline);
        AppMethodBeat.m2505o(51216);
    }

    /* renamed from: a */
    public final void mo21892a(String str, int i, C10417h c10417h, boolean z) {
        AppMethodBeat.m2504i(51217);
        Polyline polyline = (Polyline) this.hNk.get(str);
        if (polyline == null) {
            C4990ab.m7421w("MicroMsg.DefaultTencentMapView", "lineId:%s is null", str);
            AppMethodBeat.m2505o(51217);
            return;
        }
        polyline.setEraseable(z);
        polyline.eraseTo(i, new LatLng(c10417h.latitude, c10417h.longitude));
        AppMethodBeat.m2505o(51217);
    }

    /* renamed from: Bh */
    public final C10418q mo73390Bh(String str) {
        AppMethodBeat.m2504i(51218);
        C10418q c10418q = (C10418q) this.hNm.get(str);
        AppMethodBeat.m2505o(51218);
        return c10418q;
    }

    public final void aDZ() {
        AppMethodBeat.m2504i(51219);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s removeAllMarker", this);
        for (C42516d c42516d : this.hNm.values()) {
            c42516d.hNK.remove();
            if (c42516d.hNL != null) {
                if (c42516d.hNL.getMarkerView() != null && (c42516d.hNL.getMarkerView() instanceof C45715d)) {
                    C38304i.m64820a((C45715d) c42516d.hNL.getMarkerView());
                }
                c42516d.hNL.remove();
            }
        }
        this.hNm.clear();
        AppMethodBeat.m2505o(51219);
    }

    /* renamed from: Bi */
    public final boolean mo21881Bi(String str) {
        AppMethodBeat.m2504i(51220);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s removeMarker markerId:%s", this, str);
        C42516d c42516d = (C42516d) this.hNm.get(str);
        if (c42516d == null) {
            C4990ab.m7421w("MicroMsg.DefaultTencentMapView", "marker:%s is null", str);
            AppMethodBeat.m2505o(51220);
            return false;
        }
        c42516d.hNK.remove();
        if (c42516d.hNL != null) {
            if (c42516d.hNL.getMarkerView() != null && (c42516d.hNL.getMarkerView() instanceof C45715d)) {
                C38304i.m64820a((C45715d) c42516d.hNL.getMarkerView());
            }
            c42516d.hNL.remove();
            this.hNm.remove(str + "#label");
        }
        this.hNm.remove(str);
        AppMethodBeat.m2505o(51220);
        return true;
    }

    /* renamed from: a */
    public final void mo21893a(String str, C10427r c10427r, C19162a c19162a) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(51221);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", this, str);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(c10427r.latitude, c10427r.longitude));
        if (!C5046bo.isNullOrNil(c10427r.title)) {
            markerOptions.title(c10427r.title);
        }
        if (!C5046bo.isNullOrNil(c10427r.hOd)) {
            markerOptions.contentDescription(c10427r.hOd);
        }
        markerOptions.rotation(c10427r.rotate);
        markerOptions.alpha(c10427r.alpha);
        FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(2130969266, null);
        final ImageView imageView = (ImageView) frameLayout.findViewById(2131821236);
        final float f = c10427r.hOb;
        final float f2 = c10427r.hOc;
        if (c19162a != null) {
            bitmap = c19162a.mo34401a(c10427r.hNN, null, new C19164c() {
                /* renamed from: E */
                public final void mo34405E(Bitmap bitmap) {
                    AppMethodBeat.m2504i(138418);
                    if (bitmap != null) {
                        C45601a.m84117a(f, f2, bitmap, imageView);
                    }
                    AppMethodBeat.m2505o(138418);
                }
            });
        }
        if (bitmap != null) {
            C45601a.m84117a(f, f2, bitmap, imageView);
        } else {
            C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "[addMarker] bitmap is null, use default");
        }
        markerOptions.markerView(frameLayout);
        markerOptions.anchor(c10427r.bDv, c10427r.bDw);
        markerOptions.tag(str);
        markerOptions.infoWindowHideAnimation(new C425139());
        markerOptions.infoWindowShowAnimation(new C228310());
        markerOptions.visible(true);
        markerOptions.zIndex(c10427r.zIndex + 2);
        if (!(C5046bo.isNullOrNil(c10427r.buildingId) || C5046bo.isNullOrNil(c10427r.floorName))) {
            markerOptions.indoorInfo(new IndoorInfo(c10427r.buildingId, c10427r.floorName));
        }
        Marker addMarker = this.hMT.getMap().addMarker(markerOptions);
        C42516d c42516d = new C42516d();
        c42516d.hNK = addMarker;
        c42516d.data = c10427r.data;
        c42516d.hOa = c10427r;
        m84119a(str, c42516d);
        if (c10427r.hOe != null && c10427r.hOe.hOl == C10428a.hOn) {
            c42516d.hNK.showInfoWindow();
        }
        if (c10427r.hOf != null) {
            MarkerOptions markerOptions2 = new MarkerOptions();
            markerOptions2.position(new LatLng(c10427r.latitude, c10427r.longitude));
            markerOptions2.alpha(c10427r.alpha);
            C45715d aEf = C38304i.aEf();
            if (aEf == null) {
                aEf = new C45715d(this.context);
            }
            aEf.setText("");
            aEf.setTextSize(12);
            aEf.setTextColor(C45715d.jjZ);
            aEf.setTextPadding(0);
            aEf.setGravity("center");
            int i = C45715d.jka;
            aEf.mo73519x(0, 0, i, i);
            aEf.setTextColor(c10427r.hOf.color);
            aEf.setTextSize(c10427r.hOf.hOg);
            aEf.setText(c10427r.hOf.content);
            aEf.setTextPadding(c10427r.hOf.padding);
            aEf.setGravity(c10427r.hOf.hdq);
            aEf.mo73519x(c10427r.hOf.hOh, c10427r.hOf.borderWidth, c10427r.hOf.borderColor, c10427r.hOf.bgColor);
            aEf.setX(c10427r.hOf.f2874x);
            aEf.setY(c10427r.hOf.f2875y);
            aEf.measure(0, 0);
            markerOptions2.anchor(aEf.getAnchorX(), aEf.getAnchorY());
            markerOptions2.markerView(aEf);
            markerOptions2.visible(true);
            markerOptions2.tag(str + "#label");
            markerOptions2.zIndex(c10427r.zIndex + 2);
            if (!(C5046bo.isNullOrNil(c10427r.buildingId) || C5046bo.isNullOrNil(c10427r.floorName))) {
                markerOptions2.indoorInfo(new IndoorInfo(c10427r.buildingId, c10427r.floorName));
            }
            c42516d.hNL = this.hMT.getMap().addMarker(markerOptions2);
            m84119a(str + "#label", c42516d);
        }
        AppMethodBeat.m2505o(51221);
    }

    /* renamed from: a */
    static void m84117a(float f, float f2, Bitmap bitmap, ImageView imageView) {
        AppMethodBeat.m2504i(51222);
        if (f == 0.0f || f2 == 0.0f) {
            f = (float) C42668g.m75571qb(bitmap.getWidth());
            f2 = (float) C42668g.m75571qb(bitmap.getHeight());
        }
        if (f <= 0.0f || f2 <= 0.0f || (f == ((float) bitmap.getWidth()) && f2 == ((float) bitmap.getHeight()))) {
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ScaleType.CENTER);
            AppMethodBeat.m2505o(51222);
            return;
        }
        float width = f / ((float) bitmap.getWidth());
        float height = f2 / ((float) bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
        AppMethodBeat.m2505o(51222);
    }

    /* renamed from: a */
    private void m84119a(String str, C42516d c42516d) {
        AppMethodBeat.m2504i(51223);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s addMarker markerId:%s", this, str);
        this.hNm.put(str, c42516d);
        AppMethodBeat.m2505o(51223);
    }

    /* renamed from: a */
    public final void mo21894a(String str, LinkedList<C10409g> linkedList, final C10402o c10402o) {
        AppMethodBeat.m2504i(51224);
        C42516d c42516d = (C42516d) mo73390Bh(str);
        if (c42516d == null || c42516d.hNK == null) {
            C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "get marker failed!");
            c10402o.mo6165ec(false);
            AppMethodBeat.m2505o(51224);
        } else if (linkedList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.DefaultTencentMapView", "keyFrame is empty, err, return");
            c10402o.mo6165ec(false);
            AppMethodBeat.m2505o(51224);
        } else {
            C10409g c10409g = (C10409g) linkedList.get(0);
            c10409g.hNS = c42516d.hNK.getPosition().getLatitude();
            c10409g.hNR = c42516d.hNK.getPosition().getLongitude();
            int size = linkedList.size();
            for (int i = 1; i < size; i++) {
                c10409g = (C10409g) linkedList.get(i - 1);
                C10409g c10409g2 = (C10409g) linkedList.get(i);
                if (c10409g.rotate == 0.0f) {
                    c10409g2.hNR = c10409g.longitude;
                    c10409g2.hNS = c10409g.latitude;
                } else {
                    c10409g2.hNR = c42516d.hNK.getPosition().getLongitude();
                    c10409g2.hNS = c42516d.hNK.getPosition().getLatitude();
                }
            }
            final C38590c c38590c = new C38590c(linkedList, c42516d.hNK, this.hMT);
            c38590c.f16155uB.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.m2504i(138419);
                    C4990ab.m7410d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
                    AppMethodBeat.m2505o(138419);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(138420);
                    C4990ab.m7410d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
                    if (c10402o != null) {
                        c10402o.mo6165ec(true);
                    }
                    AppMethodBeat.m2505o(138420);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(138421);
                    c38590c.f16155uB.start();
                    AppMethodBeat.m2505o(138421);
                }
            });
            if (c42516d.hNL != null) {
                c38590c = new C38590c(linkedList, c42516d.hNL, this.hMT);
                C45673m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(51161);
                        c38590c.f16155uB.start();
                        AppMethodBeat.m2505o(51161);
                    }
                });
            }
            AppMethodBeat.m2505o(51224);
        }
    }

    /* renamed from: a */
    public final void mo21888a(C10413n c10413n) {
        this.hMV = c10413n;
    }

    /* renamed from: a */
    public final void mo21886a(C10425k c10425k) {
        this.hMU = c10425k;
    }

    public final void aEa() {
        AppMethodBeat.m2504i(51225);
        synchronized (this.hNn) {
            try {
                Iterator it = this.hNn.iterator();
                while (it.hasNext()) {
                    ((C42515c) it.next()).hNK.remove();
                }
                this.hNn.clear();
            } finally {
                AppMethodBeat.m2505o(51225);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo21896a(C10412d c10412d, C19162a c19162a) {
        AppMethodBeat.m2504i(51226);
        if (C5046bo.isNullOrNil(c10412d.hNN)) {
            AppMethodBeat.m2505o(51226);
            return false;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(c10412d.latitude, c10412d.longitude));
        Bitmap bB = c19162a.mo34403bB(c10412d.hNN);
        if (!(bB == null || bB.isRecycled())) {
            markerOptions.icon(new BitmapDescriptor(bB));
        }
        markerOptions.rotation(c10412d.rotate);
        Marker addMarker = this.hMT.getMap().addMarker(markerOptions);
        synchronized (this.hNn) {
            try {
                this.hNn.add(new C42515c(addMarker));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51226);
            }
        }
        return true;
    }

    public final void aEb() {
        AppMethodBeat.m2504i(51227);
        synchronized (this.hNo) {
            try {
                Iterator it = this.hNo.iterator();
                while (it.hasNext()) {
                    ((Polygon) it.next()).remove();
                }
                this.hNo.clear();
            } finally {
                AppMethodBeat.m2505o(51227);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo21897a(C10405v c10405v) {
        AppMethodBeat.m2504i(51228);
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        for (C10417h c10417h : c10405v.hNV) {
            arrayList.add(new LatLng(c10417h.latitude, c10417h.longitude));
        }
        polygonOptions.addAll(arrayList);
        polygonOptions.fillColor(c10405v.fillColor);
        polygonOptions.strokeColor(c10405v.strokeColor);
        polygonOptions.strokeWidth((float) c10405v.strokeWidth);
        polygonOptions.zIndex((float) c10405v.zIndex);
        Polygon addPolygon = this.hMT.getMap().addPolygon(polygonOptions);
        synchronized (this.hNo) {
            try {
                this.hNo.add(addPolygon);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51228);
            }
        }
        return true;
    }

    /* renamed from: en */
    public final void mo21924en(boolean z) {
        AppMethodBeat.m2504i(51229);
        C4990ab.m7417i("MicroMsg.DefaultTencentMapView", "map:%s show location", this);
        this.hNp = z;
        C19388d c19388d;
        if (z) {
            if (this.hNq != null) {
                c19388d = this.hNq;
                if (c19388d.hNK != null) {
                    c19388d.hNK.setVisible(true);
                }
            }
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20055b("gcj02", this.hNr, aEc());
            C33320g.m54491a(this);
            AppMethodBeat.m2505o(51229);
            return;
        }
        if (this.hNq != null) {
            c19388d = this.hNq;
            if (c19388d.hNK != null) {
                c19388d.hNK.setVisible(false);
            }
        }
        ((C33523a) C37384e.m62985B(C33523a.class)).mo20056c("gcj02", this.hNr, aEc());
        C33320g.m54493b(this);
        AppMethodBeat.m2505o(51229);
    }

    private Bundle aEc() {
        AppMethodBeat.m2504i(51230);
        Bundle bundle = new Bundle();
        if (!"E6FBZ-OLSCQ-UIU5C-GWLJ7-ABUPT-V7FJX".equals(this.hMW)) {
            bundle.putString("smallAppKey", C5046bo.nullAsNil(bundle.getString("smallAppKey")) + this.hMW + "#" + this.hMX + ";");
        }
        AppMethodBeat.m2505o(51230);
        return bundle;
    }

    /* renamed from: J */
    public final void mo34547J(float f, float f2) {
        AppMethodBeat.m2504i(51231);
        if (!this.hNp || this.isBackground) {
            AppMethodBeat.m2505o(51231);
            return;
        }
        if (this.hNq != null) {
            this.hNq.mo34547J(f, f2);
        }
        AppMethodBeat.m2505o(51231);
    }

    public String toString() {
        AppMethodBeat.m2504i(51232);
        String str = "DefaultTencentMapView{mapId=" + this.hMR + '}';
        AppMethodBeat.m2505o(51232);
        return str;
    }

    /* renamed from: h */
    private static SurfaceView m84120h(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(51233);
        while (viewGroup != null && viewGroup.getChildCount() != 0) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) childAt;
                    AppMethodBeat.m2505o(51233);
                    return surfaceView;
                } else if (childAt instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt;
                } else {
                    i++;
                }
            }
            AppMethodBeat.m2505o(51233);
            return null;
        }
        AppMethodBeat.m2505o(51233);
        return null;
    }
}
