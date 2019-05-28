package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class MapActivity extends Activity {
    private List<MapView> mapViewList = new ArrayList();
    private Bundle mysavedInstanceState;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mysavedInstanceState = bundle;
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        super.onDestroy();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onDestroy();
            }
        }
        this.mapViewList.clear();
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onPause();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        super.onStart();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onStart();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onResume();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onStop();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onRestart() {
        super.onRestart();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onRestart();
            }
        }
    }

    public void setMapView(MapView mapView) {
        if (mapView != null) {
            this.mapViewList.add(mapView);
        }
    }
}
