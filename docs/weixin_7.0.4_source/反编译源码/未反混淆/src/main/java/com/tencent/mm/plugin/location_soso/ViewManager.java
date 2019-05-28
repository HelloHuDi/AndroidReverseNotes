package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import java.util.HashMap;
import java.util.Map;

public class ViewManager implements e {
    private Map<View, Marker> mMarkerMap = new HashMap();
    private TencentMap mTencentMap;

    public ViewManager(TencentMap tencentMap) {
        AppMethodBeat.i(51279);
        this.mTencentMap = tencentMap;
        AppMethodBeat.o(51279);
    }

    public void addView(View view, double d, double d2) {
        AppMethodBeat.i(51280);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51280);
            return;
        }
        this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d, d2)).markerView(view)));
        AppMethodBeat.o(51280);
    }

    public void addPinView(View view, double d, double d2) {
        AppMethodBeat.i(51281);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51281);
            return;
        }
        this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d, d2)).anchor(0.5f, 0.5f).markerView(view)));
        AppMethodBeat.o(51281);
    }

    public void removeView(View view) {
        AppMethodBeat.i(51282);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51282);
            return;
        }
        Marker marker = (Marker) this.mMarkerMap.get(view);
        if (marker != null) {
            marker.remove();
        }
        AppMethodBeat.o(51282);
    }

    public void updateViewLayout(View view, double d, double d2, boolean z) {
        AppMethodBeat.i(51283);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51283);
            return;
        }
        Marker marker = (Marker) this.mMarkerMap.get(view);
        marker.setVisible(view.getVisibility() == 0);
        marker.setPosition(new LatLng(d, d2));
        if (z) {
            marker.setMarkerView(view);
        }
        marker.setAnchor(0.5f, 1.0f);
        AppMethodBeat.o(51283);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2, boolean z) {
        AppMethodBeat.i(51284);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51284);
            return;
        }
        Marker marker = (Marker) this.mMarkerMap.get(view);
        marker.setVisible(view.getVisibility() == 0);
        marker.setPosition(new LatLng(d, d2));
        if (z) {
            marker.setMarkerView(view);
        }
        marker.setAnchor(0.5f, 0.5f);
        AppMethodBeat.o(51284);
    }

    public void updateRotation(View view, float f) {
        AppMethodBeat.i(51285);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51285);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).setRotation(f);
        AppMethodBeat.o(51285);
    }

    public void toggleViewVisible(View view) {
        AppMethodBeat.i(51286);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51286);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).setVisible(view.getVisibility() == 0);
        AppMethodBeat.o(51286);
    }

    public void updateMarkerView(View view) {
        AppMethodBeat.i(51287);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51287);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).setMarkerView(view);
        AppMethodBeat.o(51287);
    }

    public void setMarker2Top(View view) {
        AppMethodBeat.i(51288);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51288);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).set2Top();
        AppMethodBeat.o(51288);
    }

    public void setMarkerClick(final View view, final OnClickListener onClickListener) {
        AppMethodBeat.i(51289);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51289);
            return;
        }
        final Marker marker = (Marker) this.mMarkerMap.get(view);
        this.mTencentMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker marker) {
                AppMethodBeat.i(51278);
                if (marker == marker) {
                    onClickListener.onClick(view);
                }
                AppMethodBeat.o(51278);
            }
        });
        AppMethodBeat.o(51289);
    }

    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        AppMethodBeat.i(51290);
        this.mTencentMap.setInfoWindowAdapter(infoWindowAdapter);
        AppMethodBeat.o(51290);
    }

    public void showInfoWindowByView(View view) {
        AppMethodBeat.i(51291);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51291);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).showInfoWindow();
        AppMethodBeat.o(51291);
    }

    public void setMarkerTag(View view, String str) {
        AppMethodBeat.i(51292);
        if (this.mTencentMap == null) {
            AppMethodBeat.o(51292);
            return;
        }
        ((Marker) this.mMarkerMap.get(view)).setTag(str);
        AppMethodBeat.o(51292);
    }

    public void destroy() {
        AppMethodBeat.i(51293);
        if (this.mMarkerMap != null) {
            this.mMarkerMap.clear();
        }
        AppMethodBeat.o(51293);
    }
}
