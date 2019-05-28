package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ec */
public class C44495ec implements IMapView {
    /* renamed from: a */
    private C16178ah f17396a;
    /* renamed from: b */
    private TencentMap f17397b;

    public C44495ec(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.m2504i(101364);
        C36476dy.m60311a("vector MapView construct function start");
        C44480ak c44480ak = null;
        if (tencentMapOptions != null) {
            c44480ak = new C44480ak();
            if (tencentMapOptions.getExtSurface() != null) {
                c44480ak.mo70658a(tencentMapOptions.getExtSurface());
            }
            c44480ak.mo70655a(tencentMapOptions.isHandDrawMapEnable());
            c44480ak.mo70659a(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            c44480ak.mo70661b(tencentMapOptions.isMutipleInfowindowEnabled());
        }
        this.f17396a = new C16178ah(context, c44480ak);
        this.f17397b = new C44822eh(this.f17396a.getMap());
        this.f17396a.getMap().mo50149l().mo64974a(false);
        AppMethodBeat.m2505o(101364);
    }

    public View getMapView() {
        return this.f17396a;
    }

    public TencentMap getMap() {
        return this.f17397b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.m2504i(101365);
        if (this.f17396a.getMap() != null) {
            C46763ek c46763ek = new C46763ek(this.f17396a.getMap().mo50149l());
            AppMethodBeat.m2505o(101365);
            return c46763ek;
        }
        AppMethodBeat.m2505o(101365);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.m2504i(101366);
        if (this.f17396a.getMap() != null) {
            C31009eg c31009eg = new C31009eg(this.f17396a.getMap());
            AppMethodBeat.m2505o(101366);
            return c31009eg;
        }
        AppMethodBeat.m2505o(101366);
        return null;
    }

    public MapController getMapController() {
        return this.f17397b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101367);
        if (this.f17396a.getMap() != null) {
            this.f17396a.getMap().mo50102a(new C44491df().mo70769a(C5839cn.m8916a(view)).mo70771a(C41025ej.m71291a(layoutParams.point)));
        }
        AppMethodBeat.m2505o(101367);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101368);
        if (this.f17396a != null) {
            this.f17396a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.m2505o(101368);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.m2504i(101369);
        this.f17396a.mo57646a();
        AppMethodBeat.m2505o(101369);
    }

    public void onResume() {
        AppMethodBeat.m2504i(101370);
        this.f17396a.mo57649d();
        AppMethodBeat.m2505o(101370);
    }

    public void onPause() {
        AppMethodBeat.m2504i(101371);
        this.f17396a.mo57650e();
        AppMethodBeat.m2505o(101371);
    }

    public void onStop() {
        AppMethodBeat.m2504i(101372);
        this.f17396a.mo57647b();
        AppMethodBeat.m2505o(101372);
    }

    public void onRestart() {
        AppMethodBeat.m2504i(101373);
        this.f17396a.mo57651f();
        AppMethodBeat.m2505o(101373);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101374);
        this.f17396a.mo57648c();
        AppMethodBeat.m2505o(101374);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101375);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.m2505o(101375);
            return true;
        }
        AppMethodBeat.m2505o(101375);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101376);
        if (this.f17396a == null) {
            AppMethodBeat.m2505o(101376);
            return false;
        } else if (this.f17396a.dispatchTouchEvent(motionEvent) || this.f17396a.onTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(101376);
            return true;
        } else {
            AppMethodBeat.m2505o(101376);
            return false;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(101377);
        if (this.f17396a != null) {
            this.f17396a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(101377);
    }
}
