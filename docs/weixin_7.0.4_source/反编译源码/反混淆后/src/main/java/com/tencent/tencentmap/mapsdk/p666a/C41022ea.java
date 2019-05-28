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

/* renamed from: com.tencent.tencentmap.mapsdk.a.ea */
public class C41022ea implements IMapView {
    /* renamed from: a */
    private C30979ag f16414a;
    /* renamed from: b */
    private TencentMap f16415b;

    public C41022ea(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.m2504i(101332);
        C36476dy.m60311a("VecotrMapRenderLayer construct function start");
        C44480ak c44480ak = null;
        if (tencentMapOptions != null) {
            c44480ak = new C44480ak();
            if (tencentMapOptions.getExtSurface() != null) {
                c44480ak.mo70658a(tencentMapOptions.getExtSurface());
                c44480ak.mo70657a(tencentMapOptions.getExtSurfaceWidth(), tencentMapOptions.getExtSurfaceHeight());
            }
            c44480ak.mo70655a(tencentMapOptions.isHandDrawMapEnable());
            c44480ak.mo70659a(tencentMapOptions.getSubKey(), tencentMapOptions.getSubId());
            c44480ak.mo70661b(tencentMapOptions.isMutipleInfowindowEnabled());
        }
        this.f16414a = new C30979ag(context, c44480ak);
        this.f16415b = new C44822eh(this.f16414a.getMap());
        this.f16414a.getMap().mo50149l().mo64974a(false);
        AppMethodBeat.m2505o(101332);
    }

    public View getMapView() {
        return this.f16414a;
    }

    public TencentMap getMap() {
        return this.f16415b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.m2504i(101333);
        if (this.f16414a.getMap() != null) {
            C46763ek c46763ek = new C46763ek(this.f16414a.getMap().mo50149l());
            AppMethodBeat.m2505o(101333);
            return c46763ek;
        }
        AppMethodBeat.m2505o(101333);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.m2504i(101334);
        if (this.f16414a.getMap() != null) {
            C31009eg c31009eg = new C31009eg(this.f16414a.getMap());
            AppMethodBeat.m2505o(101334);
            return c31009eg;
        }
        AppMethodBeat.m2505o(101334);
        return null;
    }

    public MapController getMapController() {
        return this.f16415b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101335);
        if (this.f16414a.getMap() != null) {
            this.f16414a.getMap().mo50102a(new C44491df().mo70769a(C5839cn.m8916a(view)).mo70771a(C41025ej.m71291a(layoutParams.point)));
        }
        AppMethodBeat.m2505o(101335);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101336);
        if (this.f16414a != null) {
            this.f16414a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.m2505o(101336);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.m2504i(101337);
        this.f16414a.mo57646a();
        AppMethodBeat.m2505o(101337);
    }

    public void onResume() {
        AppMethodBeat.m2504i(101338);
        this.f16414a.mo57649d();
        AppMethodBeat.m2505o(101338);
    }

    public void onPause() {
        AppMethodBeat.m2504i(101339);
        this.f16414a.mo57650e();
        AppMethodBeat.m2505o(101339);
    }

    public void onStop() {
        AppMethodBeat.m2504i(101340);
        this.f16414a.mo57647b();
        AppMethodBeat.m2505o(101340);
    }

    public void onRestart() {
        AppMethodBeat.m2504i(101341);
        this.f16414a.mo57651f();
        AppMethodBeat.m2505o(101341);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101342);
        this.f16414a.mo57648c();
        AppMethodBeat.m2505o(101342);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101343);
        boolean onTouchEvent = this.f16414a.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(101343);
        return onTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(101344);
        if (this.f16414a != null) {
            this.f16414a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(101344);
    }
}
