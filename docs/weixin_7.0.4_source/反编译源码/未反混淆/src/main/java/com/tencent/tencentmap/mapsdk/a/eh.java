package com.tencent.tencentmap.mapsdk.a;

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
import com.tencent.tencentmap.mapsdk.a.aj.a;
import com.tencent.tencentmap.mapsdk.a.aj.b;
import com.tencent.tencentmap.mapsdk.a.aj.c;
import com.tencent.tencentmap.mapsdk.a.aj.f;
import com.tencent.tencentmap.mapsdk.a.aj.g;
import com.tencent.tencentmap.mapsdk.a.aj.h;
import com.tencent.tencentmap.mapsdk.a.aj.i;
import com.tencent.tencentmap.mapsdk.a.aj.j;
import com.tencent.tencentmap.mapsdk.a.aj.k;
import com.tencent.tencentmap.mapsdk.a.aj.l;
import com.tencent.tencentmap.mapsdk.a.aj.m;
import com.tencent.tencentmap.mapsdk.a.aj.p;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class eh implements TencentMap {
    private aj a;
    private HashMap<Integer, ed> b = new HashMap();
    private List<de> c = new ArrayList();
    private boolean d = false;
    private dn e;

    static /* synthetic */ ed a(eh ehVar, de deVar) {
        AppMethodBeat.i(101550);
        ed a = ehVar.a(deVar);
        AppMethodBeat.o(101550);
        return a;
    }

    public eh(aj ajVar) {
        AppMethodBeat.i(101489);
        this.a = ajVar;
        AppMethodBeat.o(101489);
    }

    public void setCenter(LatLng latLng) {
        AppMethodBeat.i(101490);
        if (this.a == null) {
            AppMethodBeat.o(101490);
            return;
        }
        if (latLng != null) {
            this.a.a(ae.a(new db(latLng.getLatitude(), latLng.getLongitude())));
        }
        AppMethodBeat.o(101490);
    }

    public void setZoom(int i) {
        AppMethodBeat.i(101491);
        if (this.a == null) {
            AppMethodBeat.o(101491);
            return;
        }
        this.a.a(ae.a((float) i));
        AppMethodBeat.o(101491);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        AppMethodBeat.i(101492);
        if (this.a == null) {
            AppMethodBeat.o(101492);
            return null;
        } else if (circleOptions == null) {
            AppMethodBeat.o(101492);
            return null;
        } else {
            Circle ebVar = new eb(this.a.a(ej.a(circleOptions)));
            AppMethodBeat.o(101492);
            return ebVar;
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        AppMethodBeat.i(101493);
        if (this.a == null) {
            AppMethodBeat.o(101493);
            return null;
        } else if (markerOptions == null) {
            AppMethodBeat.o(101493);
            return null;
        } else {
            Marker edVar = new ed(this, this.a.a(ej.a(markerOptions)));
            this.b.put(Integer.valueOf(edVar.getId().hashCode()), edVar);
            AppMethodBeat.o(101493);
            return edVar;
        }
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        AppMethodBeat.i(101494);
        if (this.a == null) {
            AppMethodBeat.o(101494);
            return null;
        } else if (polylineOptions == null) {
            AppMethodBeat.o(101494);
            return null;
        } else {
            Polyline eeVar = new ee(this.a.a(ej.a(polylineOptions)));
            AppMethodBeat.o(101494);
            return eeVar;
        }
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        AppMethodBeat.i(101495);
        if (this.a == null) {
            AppMethodBeat.o(101495);
            return null;
        } else if (polygonOptions == null) {
            AppMethodBeat.o(101495);
            return null;
        } else {
            Polygon efVar = new ef(this.a.a(ej.a(polygonOptions)));
            AppMethodBeat.o(101495);
            return efVar;
        }
    }

    public void animateTo(LatLng latLng) {
        AppMethodBeat.i(101496);
        if (this.a == null) {
            AppMethodBeat.o(101496);
            return;
        }
        if (latLng != null) {
            this.a.b(ae.a(ej.a(latLng)));
        }
        AppMethodBeat.o(101496);
    }

    @Deprecated
    public void animateTo(LatLng latLng, final Runnable runnable) {
        AppMethodBeat.i(101497);
        if (this.a == null) {
            AppMethodBeat.o(101497);
            return;
        }
        if (latLng != null) {
            this.a.a(ae.a(ej.a(latLng)), new a() {
                public void a() {
                    AppMethodBeat.i(101456);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(101456);
                }

                public void b() {
                    AppMethodBeat.i(101457);
                    if (runnable != null) {
                        runnable.run();
                    }
                    AppMethodBeat.o(101457);
                }
            });
        }
        AppMethodBeat.o(101497);
    }

    public void animateTo(LatLng latLng, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(101498);
        if (this.a == null) {
            AppMethodBeat.o(101498);
            return;
        }
        this.a.a(ae.a(ej.a(latLng)), j, new a() {
            public void a() {
                AppMethodBeat.i(101476);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.o(101476);
            }

            public void b() {
                AppMethodBeat.i(101477);
                cancelableCallback.onCancel();
                AppMethodBeat.o(101477);
            }
        });
        AppMethodBeat.o(101498);
    }

    public void clearAllOverlays() {
        AppMethodBeat.i(101499);
        if (this.a != null) {
            this.a.h();
        }
        AppMethodBeat.o(101499);
    }

    public boolean clearCache() {
        return false;
    }

    public LatLng getMapCenter() {
        AppMethodBeat.i(101500);
        if (this.a == null) {
            AppMethodBeat.o(101500);
            return null;
        }
        this.a.d();
        LatLng a = ej.a(this.a.d().a);
        AppMethodBeat.o(101500);
        return a;
    }

    public int getZoomLevel() {
        AppMethodBeat.i(101501);
        if (this.a == null || this.a.d() == null) {
            AppMethodBeat.o(101501);
            return -1;
        }
        int i = (int) this.a.d().b;
        AppMethodBeat.o(101501);
        return i;
    }

    public int getMaxZoomLevel() {
        AppMethodBeat.i(101502);
        if (this.a == null) {
            AppMethodBeat.o(101502);
            return 19;
        }
        int e = (int) this.a.e();
        AppMethodBeat.o(101502);
        return e;
    }

    public int getMinZoomLevel() {
        AppMethodBeat.i(101503);
        if (this.a == null) {
            AppMethodBeat.o(101503);
            return 4;
        }
        int f = (int) this.a.f();
        AppMethodBeat.o(101503);
        return f;
    }

    public String getVersion() {
        AppMethodBeat.i(101504);
        if (this.a == null) {
            AppMethodBeat.o(101504);
            return null;
        }
        String t = this.a.t();
        AppMethodBeat.o(101504);
        return t;
    }

    public boolean isAppKeyAvailable() {
        return true;
    }

    public boolean isSatelliteEnabled() {
        return this.d;
    }

    public void setSatelliteEnabled(boolean z) {
        AppMethodBeat.i(101505);
        if (this.a == null) {
            AppMethodBeat.o(101505);
            return;
        }
        this.d = z;
        this.a.b(z);
        AppMethodBeat.o(101505);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(101506);
        if (this.a == null) {
            AppMethodBeat.o(101506);
            return;
        }
        if (cameraUpdate != null) {
            this.a.a(ej.a(cameraUpdate, this.a));
        }
        AppMethodBeat.o(101506);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        AppMethodBeat.i(101507);
        if (this.a == null) {
            AppMethodBeat.o(101507);
            return;
        }
        if (cameraUpdate != null) {
            this.a.b(ej.a(cameraUpdate, this.a));
        }
        AppMethodBeat.o(101507);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(101508);
        if (this.a == null) {
            AppMethodBeat.o(101508);
            return;
        }
        if (cameraUpdate != null) {
            this.a.a(ej.a(cameraUpdate, this.a), j, new a() {
                public void a() {
                    AppMethodBeat.i(101478);
                    if (cancelableCallback != null) {
                        cancelableCallback.onFinish();
                    }
                    AppMethodBeat.o(101478);
                }

                public void b() {
                    AppMethodBeat.i(101479);
                    if (cancelableCallback != null) {
                        cancelableCallback.onCancel();
                    }
                    AppMethodBeat.o(101479);
                }
            });
        }
        AppMethodBeat.o(101508);
    }

    public void scrollBy(float f, float f2) {
        AppMethodBeat.i(101509);
        if (this.a == null) {
            AppMethodBeat.o(101509);
            return;
        }
        this.a.b(ae.a(f, f2));
        AppMethodBeat.o(101509);
    }

    public void scrollBy(float f, float f2, long j, final CancelableCallback cancelableCallback) {
        AppMethodBeat.i(101510);
        if (this.a == null) {
            AppMethodBeat.o(101510);
            return;
        }
        this.a.a(ae.a(f, f2), new a() {
            public void a() {
                AppMethodBeat.i(101480);
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                AppMethodBeat.o(101480);
            }

            public void b() {
                AppMethodBeat.i(101481);
                if (cancelableCallback != null) {
                    cancelableCallback.onCancel();
                }
                AppMethodBeat.o(101481);
            }
        });
        AppMethodBeat.o(101510);
    }

    public void zoomIn() {
        AppMethodBeat.i(101511);
        if (this.a == null) {
            AppMethodBeat.o(101511);
            return;
        }
        this.a.b(ae.a());
        AppMethodBeat.o(101511);
    }

    public void zoomInFixing(int i, int i2) {
        AppMethodBeat.i(101512);
        if (this.a == null) {
            AppMethodBeat.o(101512);
            return;
        }
        this.a.a(ae.a(1.0f, new Point(i, i2)));
        AppMethodBeat.o(101512);
    }

    public void zoomOut() {
        AppMethodBeat.i(101513);
        if (this.a == null) {
            AppMethodBeat.o(101513);
            return;
        }
        this.a.b(ae.b());
        AppMethodBeat.o(101513);
    }

    public void zoomOutFixing(int i, int i2) {
        AppMethodBeat.i(101514);
        if (this.a == null) {
            AppMethodBeat.o(101514);
            return;
        }
        this.a.a(ae.a(-1.0f, new Point(i, i2)));
        AppMethodBeat.o(101514);
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(101515);
        if (this.a == null) {
            AppMethodBeat.o(101515);
            return;
        }
        this.a.a(ae.a(new dc(ej.a(latLng), ej.a(latLng2)), 0));
        AppMethodBeat.o(101515);
    }

    public void zoomToSpan(double d, double d2) {
        AppMethodBeat.i(101516);
        zoomToSpan(new LatLng(getMapCenter().getLatitude() - (d / 2.0d), getMapCenter().getLongitude() + (d2 / 2.0d)), new LatLng(getMapCenter().getLatitude() + (d / 2.0d), getMapCenter().getLongitude() - (d2 / 2.0d)));
        AppMethodBeat.o(101516);
    }

    public void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(101517);
        if (this.a == null) {
            AppMethodBeat.o(101517);
            return;
        }
        this.a.a(new b() {
            public View a(de deVar) {
                AppMethodBeat.i(101482);
                if (infoWindowAdapter != null) {
                    View infoWindow = infoWindowAdapter.getInfoWindow(eh.a(eh.this, deVar));
                    AppMethodBeat.o(101482);
                    return infoWindow;
                }
                AppMethodBeat.o(101482);
                return null;
            }

            public View b(de deVar) {
                return null;
            }
        });
        AppMethodBeat.o(101517);
    }

    private ed a(de deVar) {
        AppMethodBeat.i(101518);
        if (deVar == null) {
            AppMethodBeat.o(101518);
            return null;
        }
        ed edVar = (ed) this.b.get(Integer.valueOf(deVar.c().hashCode()));
        AppMethodBeat.o(101518);
        return edVar;
    }

    public void setOnMarkerDraggedListener(final OnMarkerDraggedListener onMarkerDraggedListener) {
        AppMethodBeat.i(101519);
        if (this.a == null) {
            AppMethodBeat.o(101519);
            return;
        }
        this.a.a(new m() {
            public void a(de deVar) {
                AppMethodBeat.i(101483);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragStart(eh.a(eh.this, deVar));
                }
                AppMethodBeat.o(101483);
            }

            public void b(de deVar) {
                AppMethodBeat.i(101484);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDrag(eh.a(eh.this, deVar));
                }
                AppMethodBeat.o(101484);
            }

            public void c(de deVar) {
                AppMethodBeat.i(101485);
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragEnd(eh.a(eh.this, deVar));
                }
                AppMethodBeat.o(101485);
            }
        });
        AppMethodBeat.o(101519);
    }

    public void setOnMapLoadedListener(final OnMapLoadedListener onMapLoadedListener) {
        AppMethodBeat.i(101520);
        if (this.a == null) {
            AppMethodBeat.o(101520);
            return;
        }
        this.a.a(new i() {
            public void a() {
                AppMethodBeat.i(101486);
                if (onMapLoadedListener != null) {
                    onMapLoadedListener.onMapLoaded();
                }
                AppMethodBeat.o(101486);
            }
        });
        AppMethodBeat.o(101520);
    }

    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        AppMethodBeat.i(101521);
        if (this.a == null) {
            AppMethodBeat.o(101521);
            return;
        }
        this.a.a(new g() {
            public void a(de deVar) {
                AppMethodBeat.i(101487);
                onInfoWindowClickListener.onInfoWindowClick(eh.a(eh.this, deVar));
                AppMethodBeat.o(101487);
            }

            public void a(int i, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.o(101521);
    }

    public void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        AppMethodBeat.i(101522);
        if (this.a == null) {
            AppMethodBeat.o(101522);
            return;
        }
        this.a.a(new l() {
            public boolean a(de deVar) {
                AppMethodBeat.i(101488);
                if (onMarkerClickListener != null) {
                    boolean onMarkerClick = onMarkerClickListener.onMarkerClick(eh.a(eh.this, deVar));
                    AppMethodBeat.o(101488);
                    return onMarkerClick;
                }
                AppMethodBeat.o(101488);
                return false;
            }
        });
        AppMethodBeat.o(101522);
    }

    public void setOnMapCameraChangeListener(final OnMapCameraChangeListener onMapCameraChangeListener) {
        AppMethodBeat.i(101523);
        if (this.a == null) {
            AppMethodBeat.o(101523);
            return;
        }
        this.a.a(new c() {
            public void onCameraChange(cp cpVar) {
                AppMethodBeat.i(101458);
                if (onMapCameraChangeListener != null) {
                    onMapCameraChangeListener.onCameraChange(ej.a(cpVar));
                }
                AppMethodBeat.o(101458);
            }

            public void onCameraChangeFinished(cp cpVar) {
                AppMethodBeat.i(101459);
                if (onMapCameraChangeListener != null) {
                    onMapCameraChangeListener.onCameraChangeFinish(ej.a(cpVar));
                }
                AppMethodBeat.o(101459);
            }
        });
        AppMethodBeat.o(101523);
    }

    public void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        AppMethodBeat.i(101524);
        if (this.a == null) {
            AppMethodBeat.o(101524);
            return;
        }
        this.a.a(new h() {
            public void a(db dbVar) {
                AppMethodBeat.i(101460);
                if (onMapClickListener != null) {
                    onMapClickListener.onMapClick(ej.a(dbVar));
                }
                AppMethodBeat.o(101460);
            }
        });
        AppMethodBeat.o(101524);
    }

    public void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        AppMethodBeat.i(101525);
        if (this.a == null) {
            AppMethodBeat.o(101525);
            return;
        }
        this.a.a(new j() {
            public void a(db dbVar) {
                AppMethodBeat.i(101461);
                if (onMapLongClickListener != null) {
                    onMapLongClickListener.onMapLongClick(ej.a(dbVar));
                }
                AppMethodBeat.o(101461);
            }
        });
        AppMethodBeat.o(101525);
    }

    public void setOnMapPoiClickListener(final OnMapPoiClickListener onMapPoiClickListener) {
        AppMethodBeat.i(101526);
        if (this.a == null) {
            AppMethodBeat.o(101526);
            return;
        }
        this.a.a(new k() {
            public void a(dd ddVar) {
                AppMethodBeat.i(101462);
                if (onMapPoiClickListener != null) {
                    onMapPoiClickListener.onClicked(ej.a(ddVar));
                }
                AppMethodBeat.o(101462);
            }
        });
        AppMethodBeat.o(101526);
    }

    public void setMapStyle(int i) {
        AppMethodBeat.i(101527);
        if (this.a == null) {
            AppMethodBeat.o(101527);
            return;
        }
        this.a.a(i);
        AppMethodBeat.o(101527);
    }

    public void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener onIndoorStateChangeListener) {
        AppMethodBeat.i(101528);
        if (this.a == null) {
            AppMethodBeat.o(101528);
            return;
        }
        this.a.a(new f() {
            public boolean onIndoorBuildingFocused() {
                AppMethodBeat.i(101463);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(101463);
                    return false;
                }
                boolean onIndoorBuildingFocused = onIndoorStateChangeListener.onIndoorBuildingFocused();
                AppMethodBeat.o(101463);
                return onIndoorBuildingFocused;
            }

            public boolean onIndoorLevelActivated(cw cwVar) {
                AppMethodBeat.i(101464);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(101464);
                    return false;
                }
                boolean onIndoorLevelActivated = onIndoorStateChangeListener.onIndoorLevelActivated(ej.a(cwVar));
                AppMethodBeat.o(101464);
                return onIndoorLevelActivated;
            }

            public boolean onIndoorBuildingDeactivated() {
                AppMethodBeat.i(101465);
                if (onIndoorStateChangeListener == null) {
                    AppMethodBeat.o(101465);
                    return false;
                }
                boolean onIndoorBuildingDeactivated = onIndoorStateChangeListener.onIndoorBuildingDeactivated();
                AppMethodBeat.o(101465);
                return onIndoorBuildingDeactivated;
            }
        });
        AppMethodBeat.o(101528);
    }

    public void setIndoorEnabled(boolean z) {
        AppMethodBeat.i(101529);
        if (this.a == null) {
            AppMethodBeat.o(101529);
            return;
        }
        this.a.f(z);
        AppMethodBeat.o(101529);
    }

    public void setIndoorFloor(int i) {
        AppMethodBeat.i(101530);
        if (this.a == null) {
            AppMethodBeat.o(101530);
            return;
        }
        this.a.c(i);
        AppMethodBeat.o(101530);
    }

    public void setIndoorFloor(String str, String str2) {
        AppMethodBeat.i(101531);
        if (this.a == null) {
            AppMethodBeat.o(101531);
            return;
        }
        this.a.a(str, str2);
        AppMethodBeat.o(101531);
    }

    public String getActivedIndoorBuilding(LatLng latLng) {
        AppMethodBeat.i(101532);
        if (this.a == null) {
            AppMethodBeat.o(101532);
            return null;
        }
        String a = this.a.a(ej.a(latLng));
        AppMethodBeat.o(101532);
        return a;
    }

    public String[] getActivedIndoorFloorNames() {
        AppMethodBeat.i(101533);
        if (this.a == null) {
            AppMethodBeat.o(101533);
            return null;
        }
        String[] v = this.a.v();
        AppMethodBeat.o(101533);
        return v;
    }

    public int getIndoorFloorId() {
        AppMethodBeat.i(101534);
        if (this.a == null) {
            AppMethodBeat.o(101534);
            return 0;
        }
        int u = this.a.u();
        AppMethodBeat.o(101534);
        return u;
    }

    public void enableMultipleInfowindow(boolean z) {
        AppMethodBeat.i(101535);
        if (this.a == null) {
            AppMethodBeat.o(101535);
            return;
        }
        this.a.h(z);
        AppMethodBeat.o(101535);
    }

    public void setTencentMapGestureListener(final TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(101536);
        if (this.a == null || tencentMapGestureListener == null) {
            AppMethodBeat.o(101536);
            return;
        }
        if (this.e != null) {
            this.a.c(this.e);
        }
        this.e = new dn() {
            public boolean a(float f, float f2) {
                AppMethodBeat.i(101466);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101466);
                    return false;
                }
                boolean onDoubleTap = tencentMapGestureListener.onDoubleTap(f, f2);
                AppMethodBeat.o(101466);
                return onDoubleTap;
            }

            public boolean b(float f, float f2) {
                AppMethodBeat.i(101467);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101467);
                    return false;
                }
                boolean onSingleTap = tencentMapGestureListener.onSingleTap(f, f2);
                AppMethodBeat.o(101467);
                return onSingleTap;
            }

            public boolean c(float f, float f2) {
                AppMethodBeat.i(101468);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101468);
                    return false;
                }
                boolean onFling = tencentMapGestureListener.onFling(f, f2);
                AppMethodBeat.o(101468);
                return onFling;
            }

            public boolean d(float f, float f2) {
                AppMethodBeat.i(101469);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101469);
                    return false;
                }
                boolean onScroll = tencentMapGestureListener.onScroll(f, f2);
                AppMethodBeat.o(101469);
                return onScroll;
            }

            public boolean e(float f, float f2) {
                AppMethodBeat.i(101470);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101470);
                    return false;
                }
                boolean onLongPress = tencentMapGestureListener.onLongPress(f, f2);
                AppMethodBeat.o(101470);
                return onLongPress;
            }

            public boolean f(float f, float f2) {
                AppMethodBeat.i(101471);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101471);
                    return false;
                }
                boolean onDown = tencentMapGestureListener.onDown(f, f2);
                AppMethodBeat.o(101471);
                return onDown;
            }

            public boolean g(float f, float f2) {
                AppMethodBeat.i(101472);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101472);
                    return false;
                }
                boolean onUp = tencentMapGestureListener.onUp(f, f2);
                AppMethodBeat.o(101472);
                return onUp;
            }

            public void a() {
                AppMethodBeat.i(101473);
                if (tencentMapGestureListener == null) {
                    AppMethodBeat.o(101473);
                    return;
                }
                tencentMapGestureListener.onMapStable();
                AppMethodBeat.o(101473);
            }
        };
        this.a.a(this.e);
        AppMethodBeat.o(101536);
    }

    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        AppMethodBeat.i(101537);
        this.a.c(this.e);
        AppMethodBeat.o(101537);
    }

    public void setForeignLanguage(Language language) {
        AppMethodBeat.i(101538);
        if (this.a == null) {
            AppMethodBeat.o(101538);
            return;
        }
        this.a.a(ej.a(language));
        AppMethodBeat.o(101538);
    }

    public CameraPosition getCameraPosition() {
        AppMethodBeat.i(101539);
        if (this.a == null) {
            AppMethodBeat.o(101539);
            return null;
        }
        CameraPosition a = ej.a(this.a.d());
        AppMethodBeat.o(101539);
        return a;
    }

    public String getDebugError() {
        AppMethodBeat.i(101540);
        if (this.a == null) {
            AppMethodBeat.o(101540);
            return null;
        }
        String z = this.a.z();
        AppMethodBeat.o(101540);
        return z;
    }

    public void stopAnimation() {
        AppMethodBeat.i(101541);
        if (this.a == null) {
            AppMethodBeat.o(101541);
            return;
        }
        this.a.g();
        AppMethodBeat.o(101541);
    }

    public void getScreenShot(final OnScreenShotListener onScreenShotListener) {
        AppMethodBeat.i(101542);
        if (this.a == null) {
            AppMethodBeat.o(101542);
            return;
        }
        this.a.a(new p() {
            public void a(Bitmap bitmap) {
                AppMethodBeat.i(101474);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.o(101474);
            }
        });
        AppMethodBeat.o(101542);
    }

    @Deprecated
    public void getScreenShot(final OnScreenShotListener onScreenShotListener, Rect rect) {
        AppMethodBeat.i(101543);
        if (this.a == null) {
            AppMethodBeat.o(101543);
            return;
        }
        this.a.a(new p() {
            public void a(Bitmap bitmap) {
                AppMethodBeat.i(101475);
                if (onScreenShotListener != null) {
                    onScreenShotListener.onMapScreenShot(bitmap);
                }
                AppMethodBeat.o(101475);
            }
        });
        AppMethodBeat.o(101543);
    }

    public void setTrafficEnabled(boolean z) {
        AppMethodBeat.i(101544);
        if (this.a == null) {
            AppMethodBeat.o(101544);
            return;
        }
        this.a.a(z);
        AppMethodBeat.o(101544);
    }

    public boolean isTrafficEnabled() {
        AppMethodBeat.i(101545);
        if (this.a == null) {
            AppMethodBeat.o(101545);
            return false;
        }
        boolean i = this.a.i();
        AppMethodBeat.o(101545);
        return i;
    }

    @Deprecated
    public void setErrorListener(OnErrorListener onErrorListener) {
        if (this.a == null) {
        }
    }

    public void set3DEnable(boolean z) {
        AppMethodBeat.i(101546);
        if (this.a == null) {
            AppMethodBeat.o(101546);
            return;
        }
        this.a.e(z);
        AppMethodBeat.o(101546);
    }

    public void setMapAnchor(float f, float f2) {
        AppMethodBeat.i(101547);
        if (this.a == null) {
            AppMethodBeat.o(101547);
            return;
        }
        this.a.a(f, f2, false);
        this.a.l().i(true);
        AppMethodBeat.o(101547);
    }

    public void setHandDrawMapEnable(boolean z) {
        AppMethodBeat.i(101548);
        if (this.a == null) {
            AppMethodBeat.o(101548);
            return;
        }
        this.a.g(z);
        AppMethodBeat.o(101548);
    }

    public boolean isHandDrawMapEnable() {
        AppMethodBeat.i(101549);
        if (this.a == null) {
            AppMethodBeat.o(101549);
            return false;
        }
        boolean w = this.a.w();
        AppMethodBeat.o(101549);
        return w;
    }

    /* Access modifiers changed, original: protected */
    public List<de> a() {
        return this.c;
    }
}
