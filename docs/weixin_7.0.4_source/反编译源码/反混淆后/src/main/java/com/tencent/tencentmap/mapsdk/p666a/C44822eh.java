package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C16180m;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30981g;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30985h;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30986j;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30987k;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30988a;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30989b;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30990c;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30991i;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C5835p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.eh */
public class C44822eh implements TencentMap {
    /* renamed from: a */
    private C30982aj f17565a;
    /* renamed from: b */
    private HashMap<Integer, C31007ed> f17566b = new HashMap();
    /* renamed from: c */
    private List<C44490de> f17567c = new ArrayList();
    /* renamed from: d */
    private boolean f17568d = false;
    /* renamed from: e */
    private C44494dn f17569e;

    /* renamed from: a */
    static /* synthetic */ C31007ed m81983a(C44822eh c44822eh, C44490de c44490de) {
        AppMethodBeat.m2504i(101550);
        C31007ed a = c44822eh.m81982a(c44490de);
        AppMethodBeat.m2505o(101550);
        return a;
    }

    public C44822eh(C30982aj c30982aj) {
        AppMethodBeat.m2504i(101489);
        this.f17565a = c30982aj;
        AppMethodBeat.m2505o(101489);
    }

    public void setCenter(LatLng latLng) {
        AppMethodBeat.m2504i(101490);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101490);
            return;
        }
        if (latLng != null) {
            this.f17565a.mo50108a(C46747ae.m88614a(new C24343db(latLng.getLatitude(), latLng.getLongitude())));
        }
        AppMethodBeat.m2505o(101490);
    }

    public void setZoom(int i) {
        AppMethodBeat.m2504i(101491);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101491);
            return;
        }
        this.f17565a.mo50108a(C46747ae.m88610a((float) i));
        AppMethodBeat.m2505o(101491);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        AppMethodBeat.m2504i(101492);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101492);
            return null;
        } else if (circleOptions == null) {
            AppMethodBeat.m2505o(101492);
            return null;
        } else {
            Circle c46761eb = new C46761eb(this.f17565a.mo50101a(C41025ej.m71288a(circleOptions)));
            AppMethodBeat.m2505o(101492);
            return c46761eb;
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        AppMethodBeat.m2504i(101493);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101493);
            return null;
        } else if (markerOptions == null) {
            AppMethodBeat.m2505o(101493);
            return null;
        } else {
            Marker c31007ed = new C31007ed(this, this.f17565a.mo50102a(C41025ej.m71293a(markerOptions)));
            this.f17566b.put(Integer.valueOf(c31007ed.getId().hashCode()), c31007ed);
            AppMethodBeat.m2505o(101493);
            return c31007ed;
        }
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        AppMethodBeat.m2504i(101494);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101494);
            return null;
        } else if (polylineOptions == null) {
            AppMethodBeat.m2505o(101494);
            return null;
        } else {
            Polyline c16194ee = new C16194ee(this.f17565a.mo50104a(C41025ej.m71295a(polylineOptions)));
            AppMethodBeat.m2505o(101494);
            return c16194ee;
        }
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        AppMethodBeat.m2504i(101495);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101495);
            return null;
        } else if (polygonOptions == null) {
            AppMethodBeat.m2505o(101495);
            return null;
        } else {
            Polygon c31008ef = new C31008ef(this.f17565a.mo50103a(C41025ej.m71294a(polygonOptions)));
            AppMethodBeat.m2505o(101495);
            return c31008ef;
        }
    }

    public void animateTo(LatLng latLng) {
        AppMethodBeat.m2504i(101496);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101496);
            return;
        }
        if (latLng != null) {
            this.f17565a.mo50129b(C46747ae.m88614a(C41025ej.m71291a(latLng)));
        }
        AppMethodBeat.m2505o(101496);
    }

    @Deprecated
    public void animateTo(LatLng latLng, final Runnable runnable) {
        AppMethodBeat.m2504i(101497);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101497);
            return;
        }
        if (latLng != null) {
            this.f17565a.mo50110a(C46747ae.m88614a(C41025ej.m71291a(latLng)), new C30988a() {
                /* renamed from: a */
                public void mo50166a() {
                    AppMethodBeat.m2504i(101456);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.m2505o(101456);
                }

                /* renamed from: b */
                public void mo50167b() {
                    AppMethodBeat.m2504i(101457);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.m2505o(101457);
                }
            });
        }
        AppMethodBeat.m2505o(101497);
    }

    public void animateTo(LatLng latLng, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.m2504i(101498);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101498);
            return;
        }
        this.f17565a.mo50109a(C46747ae.m88614a(C41025ej.m71291a(latLng)), j, new C30988a() {
            /* renamed from: a */
            public void mo50166a() {
                AppMethodBeat.m2504i(101476);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.m2505o(101476);
            }

            /* renamed from: b */
            public void mo50167b() {
                AppMethodBeat.m2504i(101477);
                cancelableCallback.onCancel();
                AppMethodBeat.m2505o(101477);
            }
        });
        AppMethodBeat.m2505o(101498);
    }

    public void clearAllOverlays() {
        AppMethodBeat.m2504i(101499);
        if (this.f17565a != null) {
            this.f17565a.mo50144h();
        }
        AppMethodBeat.m2505o(101499);
    }

    public boolean clearCache() {
        return false;
    }

    public LatLng getMapCenter() {
        AppMethodBeat.m2504i(101500);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101500);
            return null;
        }
        this.f17565a.mo50136d();
        LatLng a = C41025ej.m71282a(this.f17565a.mo50136d().f1462a);
        AppMethodBeat.m2505o(101500);
        return a;
    }

    public int getZoomLevel() {
        AppMethodBeat.m2504i(101501);
        if (this.f17565a == null || this.f17565a.mo50136d() == null) {
            AppMethodBeat.m2505o(101501);
            return -1;
        }
        int i = (int) this.f17565a.mo50136d().f1463b;
        AppMethodBeat.m2505o(101501);
        return i;
    }

    public int getMaxZoomLevel() {
        AppMethodBeat.m2504i(101502);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101502);
            return 19;
        }
        int e = (int) this.f17565a.mo50138e();
        AppMethodBeat.m2505o(101502);
        return e;
    }

    public int getMinZoomLevel() {
        AppMethodBeat.m2504i(101503);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101503);
            return 4;
        }
        int f = (int) this.f17565a.mo50140f();
        AppMethodBeat.m2505o(101503);
        return f;
    }

    public String getVersion() {
        AppMethodBeat.m2504i(101504);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101504);
            return null;
        }
        String t = this.f17565a.mo50157t();
        AppMethodBeat.m2505o(101504);
        return t;
    }

    public boolean isAppKeyAvailable() {
        return true;
    }

    public boolean isSatelliteEnabled() {
        return this.f17568d;
    }

    public void setSatelliteEnabled(boolean z) {
        AppMethodBeat.m2504i(101505);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101505);
            return;
        }
        this.f17568d = z;
        this.f17565a.mo50131b(z);
        AppMethodBeat.m2505o(101505);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.m2504i(101506);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101506);
            return;
        }
        if (cameraUpdate != null) {
            this.f17565a.mo50108a(C41025ej.m71286a(cameraUpdate, this.f17565a));
        }
        AppMethodBeat.m2505o(101506);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.m2504i(101507);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101507);
            return;
        }
        if (cameraUpdate != null) {
            this.f17565a.mo50129b(C41025ej.m71286a(cameraUpdate, this.f17565a));
        }
        AppMethodBeat.m2505o(101507);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.m2504i(101508);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101508);
            return;
        }
        if (cameraUpdate != null) {
            this.f17565a.mo50109a(C41025ej.m71286a(cameraUpdate, this.f17565a), j, new C30988a() {
                /* renamed from: a */
                public void mo50166a() {
                    AppMethodBeat.m2504i(101478);
                    if (cancelableCallback != null) {
                        cancelableCallback.onFinish();
                    }
                    AppMethodBeat.m2505o(101478);
                }

                /* renamed from: b */
                public void mo50167b() {
                    AppMethodBeat.m2504i(101479);
                    if (cancelableCallback != null) {
                        cancelableCallback.onCancel();
                    }
                    AppMethodBeat.m2505o(101479);
                }
            });
        }
        AppMethodBeat.m2505o(101508);
    }

    public void scrollBy(float f, float f2) {
        AppMethodBeat.m2504i(101509);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101509);
            return;
        }
        this.f17565a.mo50129b(C46747ae.m88611a(f, f2));
        AppMethodBeat.m2505o(101509);
    }

    public void scrollBy(float f, float f2, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.m2504i(101510);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101510);
            return;
        }
        this.f17565a.mo50110a(C46747ae.m88611a(f, f2), new C30988a() {
            /* renamed from: a */
            public void mo50166a() {
                AppMethodBeat.m2504i(101480);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.m2505o(101480);
            }

            /* renamed from: b */
            public void mo50167b() {
                AppMethodBeat.m2504i(101481);
                if (cancelableCallback != null) {
                    cancelableCallback.onCancel();
                }
                AppMethodBeat.m2505o(101481);
            }
        });
        AppMethodBeat.m2505o(101510);
    }

    public void zoomIn() {
        AppMethodBeat.m2504i(101511);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101511);
            return;
        }
        this.f17565a.mo50129b(C46747ae.m88609a());
        AppMethodBeat.m2505o(101511);
    }

    public void zoomInFixing(int i, int i2) {
        AppMethodBeat.m2504i(101512);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101512);
            return;
        }
        this.f17565a.mo50108a(C46747ae.m88612a(1.0f, new Point(i, i2)));
        AppMethodBeat.m2505o(101512);
    }

    public void zoomOut() {
        AppMethodBeat.m2504i(101513);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101513);
            return;
        }
        this.f17565a.mo50129b(C46747ae.m88619b());
        AppMethodBeat.m2505o(101513);
    }

    public void zoomOutFixing(int i, int i2) {
        AppMethodBeat.m2504i(101514);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101514);
            return;
        }
        this.f17565a.mo50108a(C46747ae.m88612a(-1.0f, new Point(i, i2)));
        AppMethodBeat.m2505o(101514);
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.m2504i(101515);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101515);
            return;
        }
        this.f17565a.mo50108a(C46747ae.m88616a(new C24345dc(C41025ej.m71291a(latLng), C41025ej.m71291a(latLng2)), 0));
        AppMethodBeat.m2505o(101515);
    }

    public void zoomToSpan(double d, double d2) {
        AppMethodBeat.m2504i(101516);
        zoomToSpan(new LatLng(getMapCenter().getLatitude() - (d / 2.0d), getMapCenter().getLongitude() + (d2 / 2.0d)), new LatLng(getMapCenter().getLatitude() + (d / 2.0d), getMapCenter().getLongitude() - (d2 / 2.0d)));
        AppMethodBeat.m2505o(101516);
    }

    public void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.m2504i(101517);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101517);
            return;
        }
        this.f17565a.mo50111a(new C30989b() {
            /* renamed from: a */
            public View mo29179a(C44490de c44490de) {
                AppMethodBeat.m2504i(101482);
                if (infoWindowAdapter != null) {
                    View infoWindow = infoWindowAdapter.getInfoWindow(C44822eh.m81983a(C44822eh.this, c44490de));
                    AppMethodBeat.m2505o(101482);
                    return infoWindow;
                }
                AppMethodBeat.m2505o(101482);
                return null;
            }

            /* renamed from: b */
            public View mo29180b(C44490de c44490de) {
                return null;
            }
        });
        AppMethodBeat.m2505o(101517);
    }

    /* renamed from: a */
    private C31007ed m81982a(C44490de c44490de) {
        AppMethodBeat.m2504i(101518);
        if (c44490de == null) {
            AppMethodBeat.m2505o(101518);
            return null;
        }
        C31007ed c31007ed = (C31007ed) this.f17566b.get(Integer.valueOf(c44490de.mo70741c().hashCode()));
        AppMethodBeat.m2505o(101518);
        return c31007ed;
    }

    public void setOnMarkerDraggedListener(final OnMarkerDraggedListener onMarkerDraggedListener) {
        AppMethodBeat.m2504i(101519);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101519);
            return;
        }
        this.f17565a.mo50120a(new C16180m() {
            /* renamed from: a */
            public void mo29056a(C44490de c44490de) {
                AppMethodBeat.m2504i(101483);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragStart(C44822eh.m81983a(C44822eh.this, c44490de));
                }
                AppMethodBeat.m2505o(101483);
            }

            /* renamed from: b */
            public void mo29057b(C44490de c44490de) {
                AppMethodBeat.m2504i(101484);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDrag(C44822eh.m81983a(C44822eh.this, c44490de));
                }
                AppMethodBeat.m2505o(101484);
            }

            /* renamed from: c */
            public void mo29058c(C44490de c44490de) {
                AppMethodBeat.m2504i(101485);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragEnd(C44822eh.m81983a(C44822eh.this, c44490de));
                }
                AppMethodBeat.m2505o(101485);
            }
        });
        AppMethodBeat.m2505o(101519);
    }

    public void setOnMapLoadedListener(final OnMapLoadedListener onMapLoadedListener) {
        AppMethodBeat.m2504i(101520);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101520);
            return;
        }
        this.f17565a.mo50116a(new C30991i() {
            /* renamed from: a */
            public void mo50170a() {
                AppMethodBeat.m2504i(101486);
                if (onMapLoadedListener != null) {
                    onMapLoadedListener.onMapLoaded();
                }
                AppMethodBeat.m2505o(101486);
            }
        });
        AppMethodBeat.m2505o(101520);
    }

    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.m2504i(101521);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101521);
            return;
        }
        this.f17565a.mo50114a(new C30981g() {
            /* renamed from: a */
            public void mo29182a(C44490de c44490de) {
                AppMethodBeat.m2504i(101487);
                onInfoWindowClickListener.onInfoWindowClick(C44822eh.m81983a(C44822eh.this, c44490de));
                AppMethodBeat.m2505o(101487);
            }

            /* renamed from: a */
            public void mo29181a(int i, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.m2505o(101521);
    }

    public void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.m2504i(101522);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101522);
            return;
        }
        this.f17565a.mo50119a(new C30992l() {
            /* renamed from: a */
            public boolean mo50171a(C44490de c44490de) {
                AppMethodBeat.m2504i(101488);
                if (onMarkerClickListener != null) {
                    boolean onMarkerClick = onMarkerClickListener.onMarkerClick(C44822eh.m81983a(C44822eh.this, c44490de));
                    AppMethodBeat.m2505o(101488);
                    return onMarkerClick;
                }
                AppMethodBeat.m2505o(101488);
                return false;
            }
        });
        AppMethodBeat.m2505o(101522);
    }

    public void setOnMapCameraChangeListener(final OnMapCameraChangeListener onMapCameraChangeListener) {
        AppMethodBeat.m2504i(101523);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101523);
            return;
        }
        this.f17565a.mo50112a(new C30990c() {
            public void onCameraChange(C5841cp c5841cp) {
                AppMethodBeat.m2504i(101458);
                if (onMapCameraChangeListener != null) {
                    onMapCameraChangeListener.onCameraChange(C41025ej.m71280a(c5841cp));
                }
                AppMethodBeat.m2505o(101458);
            }

            public void onCameraChangeFinished(C5841cp c5841cp) {
                AppMethodBeat.m2504i(101459);
                if (onMapCameraChangeListener != null) {
                    onMapCameraChangeListener.onCameraChangeFinish(C41025ej.m71280a(c5841cp));
                }
                AppMethodBeat.m2505o(101459);
            }
        });
        AppMethodBeat.m2505o(101523);
    }

    public void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        AppMethodBeat.m2504i(101524);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101524);
            return;
        }
        this.f17565a.mo50115a(new C30985h() {
            /* renamed from: a */
            public void mo50164a(C24343db c24343db) {
                AppMethodBeat.m2504i(101460);
                if (onMapClickListener != null) {
                    onMapClickListener.onMapClick(C41025ej.m71282a(c24343db));
                }
                AppMethodBeat.m2505o(101460);
            }
        });
        AppMethodBeat.m2505o(101524);
    }

    public void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        AppMethodBeat.m2504i(101525);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101525);
            return;
        }
        this.f17565a.mo50117a(new C30986j() {
            /* renamed from: a */
            public void mo50165a(C24343db c24343db) {
                AppMethodBeat.m2504i(101461);
                if (onMapLongClickListener != null) {
                    onMapLongClickListener.onMapLongClick(C41025ej.m71282a(c24343db));
                }
                AppMethodBeat.m2505o(101461);
            }
        });
        AppMethodBeat.m2505o(101525);
    }

    public void setOnMapPoiClickListener(final OnMapPoiClickListener onMapPoiClickListener) {
        AppMethodBeat.m2504i(101526);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101526);
            return;
        }
        this.f17565a.mo50118a(new C30987k() {
            /* renamed from: a */
            public void mo29183a(C24346dd c24346dd) {
                AppMethodBeat.m2504i(101462);
                if (onMapPoiClickListener != null) {
                    onMapPoiClickListener.onClicked(C41025ej.m71284a(c24346dd));
                }
                AppMethodBeat.m2505o(101462);
            }
        });
        AppMethodBeat.m2505o(101526);
    }

    public void setMapStyle(int i) {
        AppMethodBeat.m2504i(101527);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101527);
            return;
        }
        this.f17565a.mo50107a(i);
        AppMethodBeat.m2505o(101527);
    }

    public void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener onIndoorStateChangeListener) {
        AppMethodBeat.m2504i(101528);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101528);
            return;
        }
        this.f17565a.mo50113a(new C24326f() {
            public boolean onIndoorBuildingFocused() {
                AppMethodBeat.m2504i(101463);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.m2505o(101463);
                    return false;
                }
                boolean onIndoorBuildingFocused = onIndoorStateChangeListener.onIndoorBuildingFocused();
                AppMethodBeat.m2505o(101463);
                return onIndoorBuildingFocused;
            }

            public boolean onIndoorLevelActivated(C31000cw c31000cw) {
                AppMethodBeat.m2504i(101464);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.m2505o(101464);
                    return false;
                }
                boolean onIndoorLevelActivated = onIndoorStateChangeListener.onIndoorLevelActivated(C41025ej.m71281a(c31000cw));
                AppMethodBeat.m2505o(101464);
                return onIndoorLevelActivated;
            }

            public boolean onIndoorBuildingDeactivated() {
                AppMethodBeat.m2504i(101465);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.m2505o(101465);
                    return false;
                }
                boolean onIndoorBuildingDeactivated = onIndoorStateChangeListener.onIndoorBuildingDeactivated();
                AppMethodBeat.m2505o(101465);
                return onIndoorBuildingDeactivated;
            }
        });
        AppMethodBeat.m2505o(101528);
    }

    public void setIndoorEnabled(boolean z) {
        AppMethodBeat.m2504i(101529);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101529);
            return;
        }
        this.f17565a.mo50141f(z);
        AppMethodBeat.m2505o(101529);
    }

    public void setIndoorFloor(int i) {
        AppMethodBeat.m2504i(101530);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101530);
            return;
        }
        this.f17565a.mo50133c(i);
        AppMethodBeat.m2505o(101530);
    }

    public void setIndoorFloor(String str, String str2) {
        AppMethodBeat.m2504i(101531);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101531);
            return;
        }
        this.f17565a.mo50125a(str, str2);
        AppMethodBeat.m2505o(101531);
    }

    public String getActivedIndoorBuilding(LatLng latLng) {
        AppMethodBeat.m2504i(101532);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101532);
            return null;
        }
        String a = this.f17565a.mo50105a(C41025ej.m71291a(latLng));
        AppMethodBeat.m2505o(101532);
        return a;
    }

    public String[] getActivedIndoorFloorNames() {
        AppMethodBeat.m2504i(101533);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101533);
            return null;
        }
        String[] v = this.f17565a.mo50159v();
        AppMethodBeat.m2505o(101533);
        return v;
    }

    public int getIndoorFloorId() {
        AppMethodBeat.m2504i(101534);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101534);
            return 0;
        }
        int u = this.f17565a.mo50158u();
        AppMethodBeat.m2505o(101534);
        return u;
    }

    public void enableMultipleInfowindow(boolean z) {
        AppMethodBeat.m2504i(101535);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101535);
            return;
        }
        this.f17565a.mo50145h(z);
        AppMethodBeat.m2505o(101535);
    }

    public void setTencentMapGestureListener(final TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.m2504i(101536);
        if (this.f17565a == null || tencentMapGestureListener == null) {
            AppMethodBeat.m2505o(101536);
            return;
        }
        if (this.f17569e != null) {
            this.f17565a.mo50134c(this.f17569e);
        }
        this.f17569e = new C44494dn() {
            /* renamed from: a */
            public boolean mo29185a(float f, float f2) {
                AppMethodBeat.m2504i(101466);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101466);
                    return false;
                }
                boolean onDoubleTap = tencentMapGestureListener.onDoubleTap(f, f2);
                AppMethodBeat.m2505o(101466);
                return onDoubleTap;
            }

            /* renamed from: b */
            public boolean mo29186b(float f, float f2) {
                AppMethodBeat.m2504i(101467);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101467);
                    return false;
                }
                boolean onSingleTap = tencentMapGestureListener.onSingleTap(f, f2);
                AppMethodBeat.m2505o(101467);
                return onSingleTap;
            }

            /* renamed from: c */
            public boolean mo29187c(float f, float f2) {
                AppMethodBeat.m2504i(101468);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101468);
                    return false;
                }
                boolean onFling = tencentMapGestureListener.onFling(f, f2);
                AppMethodBeat.m2505o(101468);
                return onFling;
            }

            /* renamed from: d */
            public boolean mo29188d(float f, float f2) {
                AppMethodBeat.m2504i(101469);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101469);
                    return false;
                }
                boolean onScroll = tencentMapGestureListener.onScroll(f, f2);
                AppMethodBeat.m2505o(101469);
                return onScroll;
            }

            /* renamed from: e */
            public boolean mo29189e(float f, float f2) {
                AppMethodBeat.m2504i(101470);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101470);
                    return false;
                }
                boolean onLongPress = tencentMapGestureListener.onLongPress(f, f2);
                AppMethodBeat.m2505o(101470);
                return onLongPress;
            }

            /* renamed from: f */
            public boolean mo29190f(float f, float f2) {
                AppMethodBeat.m2504i(101471);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101471);
                    return false;
                }
                boolean onDown = tencentMapGestureListener.onDown(f, f2);
                AppMethodBeat.m2505o(101471);
                return onDown;
            }

            /* renamed from: g */
            public boolean mo29191g(float f, float f2) {
                AppMethodBeat.m2504i(101472);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101472);
                    return false;
                }
                boolean onUp = tencentMapGestureListener.onUp(f, f2);
                AppMethodBeat.m2505o(101472);
                return onUp;
            }

            /* renamed from: a */
            public void mo29184a() {
                AppMethodBeat.m2504i(101473);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.m2505o(101473);
                    return;
                }
                tencentMapGestureListener.onMapStable();
                AppMethodBeat.m2505o(101473);
            }
        };
        this.f17565a.mo50124a(this.f17569e);
        AppMethodBeat.m2505o(101536);
    }

    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.m2504i(101537);
        this.f17565a.mo50134c(this.f17569e);
        AppMethodBeat.m2505o(101537);
    }

    public void setForeignLanguage(Language language) {
        AppMethodBeat.m2504i(101538);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101538);
            return;
        }
        this.f17565a.mo50123a(C41025ej.m71290a(language));
        AppMethodBeat.m2505o(101538);
    }

    public CameraPosition getCameraPosition() {
        AppMethodBeat.m2504i(101539);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101539);
            return null;
        }
        CameraPosition a = C41025ej.m71280a(this.f17565a.mo50136d());
        AppMethodBeat.m2505o(101539);
        return a;
    }

    public String getDebugError() {
        AppMethodBeat.m2504i(101540);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101540);
            return null;
        }
        String z = this.f17565a.mo50163z();
        AppMethodBeat.m2505o(101540);
        return z;
    }

    public void stopAnimation() {
        AppMethodBeat.m2504i(101541);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101541);
            return;
        }
        this.f17565a.mo50142g();
        AppMethodBeat.m2505o(101541);
    }

    public void getScreenShot(final OnScreenShotListener onScreenShotListener) {
        AppMethodBeat.m2504i(101542);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101542);
            return;
        }
        this.f17565a.mo50121a(new C5835p() {
            /* renamed from: a */
            public void mo12295a(Bitmap bitmap) {
                AppMethodBeat.m2504i(101474);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.m2505o(101474);
            }
        });
        AppMethodBeat.m2505o(101542);
    }

    @Deprecated
    public void getScreenShot(final OnScreenShotListener onScreenShotListener, Rect rect) {
        AppMethodBeat.m2504i(101543);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101543);
            return;
        }
        this.f17565a.mo50121a(new C5835p() {
            /* renamed from: a */
            public void mo12295a(Bitmap bitmap) {
                AppMethodBeat.m2504i(101475);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.m2505o(101475);
            }
        });
        AppMethodBeat.m2505o(101543);
    }

    public void setTrafficEnabled(boolean z) {
        AppMethodBeat.m2504i(101544);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101544);
            return;
        }
        this.f17565a.mo50126a(z);
        AppMethodBeat.m2505o(101544);
    }

    public boolean isTrafficEnabled() {
        AppMethodBeat.m2504i(101545);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101545);
            return false;
        }
        boolean i = this.f17565a.mo50146i();
        AppMethodBeat.m2505o(101545);
        return i;
    }

    @Deprecated
    public void setErrorListener(OnErrorListener onErrorListener) {
        if (this.f17565a == null) {
        }
    }

    public void set3DEnable(boolean z) {
        AppMethodBeat.m2504i(101546);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101546);
            return;
        }
        this.f17565a.mo50139e(z);
        AppMethodBeat.m2505o(101546);
    }

    public void setMapAnchor(float f, float f2) {
        AppMethodBeat.m2504i(101547);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101547);
            return;
        }
        this.f17565a.mo50106a(f, f2, false);
        this.f17565a.mo50149l().mo64988i(true);
        AppMethodBeat.m2505o(101547);
    }

    public void setHandDrawMapEnable(boolean z) {
        AppMethodBeat.m2504i(101548);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101548);
            return;
        }
        this.f17565a.mo50143g(z);
        AppMethodBeat.m2505o(101548);
    }

    public boolean isHandDrawMapEnable() {
        AppMethodBeat.m2504i(101549);
        if (this.f17565a == null) {
            AppMethodBeat.m2505o(101549);
            return false;
        }
        boolean w = this.f17565a.mo50160w();
        AppMethodBeat.m2505o(101549);
        return w;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public List<C44490de> mo72027a() {
        return this.f17567c;
    }
}
