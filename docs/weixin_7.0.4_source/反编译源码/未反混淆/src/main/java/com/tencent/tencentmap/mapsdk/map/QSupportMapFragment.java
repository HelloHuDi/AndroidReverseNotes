package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.i;

public class QSupportMapFragment extends Fragment {
    private MapView mapView;

    public static QSupportMapFragment newInstance() {
        AppMethodBeat.i(101317);
        QSupportMapFragment qSupportMapFragment = new QSupportMapFragment();
        AppMethodBeat.o(101317);
        return qSupportMapFragment;
    }

    public MapView getMapView() {
        return this.mapView;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.i(101318);
        super.onAttach(activity);
        AppMethodBeat.o(101318);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.i(101319);
        super.onInflate(activity, attributeSet, bundle);
        AppMethodBeat.o(101319);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(101320);
        super.onCreate(bundle);
        AppMethodBeat.o(101320);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(101321);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (this.mapView == null) {
            this.mapView = new MapView(layoutInflater.getContext());
            this.mapView.onCreate(bundle);
        }
        i.a("js", "QSupportMapFragment onCreateView ");
        MapView mapView = this.mapView;
        AppMethodBeat.o(101321);
        return mapView;
    }

    public void onResume() {
        AppMethodBeat.i(101322);
        super.onResume();
        this.mapView.onResume();
        AppMethodBeat.o(101322);
    }

    public void onPause() {
        AppMethodBeat.i(101323);
        super.onPause();
        this.mapView.onPause();
        AppMethodBeat.o(101323);
    }

    public void onDestroyView() {
        AppMethodBeat.i(101324);
        this.mapView.onDestroyView();
        super.onDestroyView();
        AppMethodBeat.o(101324);
    }

    public void onDestroy() {
        AppMethodBeat.i(101325);
        this.mapView.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(101325);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(101326);
        this.mapView.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(101326);
    }

    public void setArguments(Bundle bundle) {
        AppMethodBeat.i(101327);
        super.setArguments(bundle);
        AppMethodBeat.o(101327);
    }
}
