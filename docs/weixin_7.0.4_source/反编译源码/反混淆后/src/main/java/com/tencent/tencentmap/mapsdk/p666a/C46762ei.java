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

/* renamed from: com.tencent.tencentmap.mapsdk.a.ei */
public class C46762ei implements IMapView {
    /* renamed from: a */
    private C46748al f18047a;
    /* renamed from: b */
    private TencentMap f18048b;

    public C46762ei(Context context, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.m2504i(101551);
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
        this.f18047a = new C46748al(context, c44480ak);
        this.f18048b = new C44822eh(this.f18047a.getMap());
        this.f18047a.getMap().mo50149l().mo64974a(false);
        AppMethodBeat.m2505o(101551);
    }

    public View getMapView() {
        return this.f18047a;
    }

    public TencentMap getMap() {
        return this.f18048b;
    }

    public UiSettings getUiSettings() {
        AppMethodBeat.m2504i(101552);
        if (this.f18047a.getMap() != null) {
            C46763ek c46763ek = new C46763ek(this.f18047a.getMap().mo50149l());
            AppMethodBeat.m2505o(101552);
            return c46763ek;
        }
        AppMethodBeat.m2505o(101552);
        return null;
    }

    public Projection getProjection() {
        AppMethodBeat.m2504i(101553);
        if (this.f18047a.getMap() != null) {
            C31009eg c31009eg = new C31009eg(this.f18047a.getMap());
            AppMethodBeat.m2505o(101553);
            return c31009eg;
        }
        AppMethodBeat.m2505o(101553);
        return null;
    }

    public MapController getMapController() {
        return this.f18048b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101554);
        if (this.f18047a.getMap() != null) {
            this.f18047a.getMap().mo50102a(new C44491df().mo70769a(C5839cn.m8916a(view)).mo70771a(C41025ej.m71291a(layoutParams.point)));
        }
        AppMethodBeat.m2505o(101554);
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(101555);
        if (this.f18047a != null) {
            this.f18047a.updateViewLayout(view, layoutParams);
        }
        AppMethodBeat.m2505o(101555);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        AppMethodBeat.m2504i(101556);
        this.f18047a.mo57646a();
        AppMethodBeat.m2505o(101556);
    }

    public void onResume() {
        AppMethodBeat.m2504i(101557);
        this.f18047a.mo57649d();
        AppMethodBeat.m2505o(101557);
    }

    public void onPause() {
        AppMethodBeat.m2504i(101558);
        this.f18047a.mo57650e();
        AppMethodBeat.m2505o(101558);
    }

    public void onStop() {
        AppMethodBeat.m2504i(101559);
        this.f18047a.mo57647b();
        AppMethodBeat.m2505o(101559);
    }

    public void onRestart() {
        AppMethodBeat.m2504i(101560);
        this.f18047a.mo57651f();
        AppMethodBeat.m2505o(101560);
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101561);
        this.f18047a.mo57648c();
        AppMethodBeat.m2505o(101561);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101562);
        if (motionEvent.getAction() == 0) {
            AppMethodBeat.m2505o(101562);
            return true;
        }
        AppMethodBeat.m2505o(101562);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101563);
        if (this.f18047a == null) {
            AppMethodBeat.m2505o(101563);
            return false;
        } else if (this.f18047a.dispatchTouchEvent(motionEvent) || this.f18047a.onTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(101563);
            return true;
        } else {
            AppMethodBeat.m2505o(101563);
            return false;
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(101564);
        if (this.f18047a != null) {
            this.f18047a.onSizeChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(101564);
    }
}
