package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C36478i;

public class QSupportMapFragment extends Fragment {
    private MapView mapView;

    public static QSupportMapFragment newInstance() {
        AppMethodBeat.m2504i(101317);
        QSupportMapFragment qSupportMapFragment = new QSupportMapFragment();
        AppMethodBeat.m2505o(101317);
        return qSupportMapFragment;
    }

    public MapView getMapView() {
        return this.mapView;
    }

    public void onAttach(Activity activity) {
        AppMethodBeat.m2504i(101318);
        super.onAttach(activity);
        AppMethodBeat.m2505o(101318);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.m2504i(101319);
        super.onInflate(activity, attributeSet, bundle);
        AppMethodBeat.m2505o(101319);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(101320);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(101320);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(101321);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (this.mapView == null) {
            this.mapView = new MapView(layoutInflater.getContext());
            this.mapView.onCreate(bundle);
        }
        C36478i.m60316a("js", "QSupportMapFragment onCreateView ");
        MapView mapView = this.mapView;
        AppMethodBeat.m2505o(101321);
        return mapView;
    }

    public void onResume() {
        AppMethodBeat.m2504i(101322);
        super.onResume();
        this.mapView.onResume();
        AppMethodBeat.m2505o(101322);
    }

    public void onPause() {
        AppMethodBeat.m2504i(101323);
        super.onPause();
        this.mapView.onPause();
        AppMethodBeat.m2505o(101323);
    }

    public void onDestroyView() {
        AppMethodBeat.m2504i(101324);
        this.mapView.onDestroyView();
        super.onDestroyView();
        AppMethodBeat.m2505o(101324);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101325);
        this.mapView.onDestroy();
        super.onDestroy();
        AppMethodBeat.m2505o(101325);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(101326);
        this.mapView.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(101326);
    }

    public void setArguments(Bundle bundle) {
        AppMethodBeat.m2504i(101327);
        super.setArguments(bundle);
        AppMethodBeat.m2505o(101327);
    }
}
