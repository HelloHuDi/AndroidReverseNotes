package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ek */
public class C46763ek implements UiSettings {
    /* renamed from: a */
    private C41007am f18049a;

    public C46763ek(C41007am c41007am) {
        this.f18049a = c41007am;
    }

    public boolean isAnimationEnabled() {
        return false;
    }

    public void setAnimationEnabled(boolean z) {
    }

    public void setScaleControlsEnabled(boolean z) {
        AppMethodBeat.m2504i(101585);
        if (this.f18049a != null) {
            this.f18049a.mo64987h(z);
        }
        AppMethodBeat.m2505o(101585);
    }

    public void setScrollGesturesEnabled(boolean z) {
        AppMethodBeat.m2504i(101586);
        if (this.f18049a != null) {
            this.f18049a.mo64979c(z);
        }
        AppMethodBeat.m2505o(101586);
    }

    public void setZoomGesturesEnabled(boolean z) {
        AppMethodBeat.m2504i(101587);
        if (this.f18049a != null) {
            this.f18049a.mo64981d(z);
        }
        AppMethodBeat.m2505o(101587);
    }

    public void setAllGesturesEnabled(boolean z) {
        AppMethodBeat.m2504i(101588);
        if (this.f18049a != null) {
            this.f18049a.mo64986g(z);
        }
        AppMethodBeat.m2505o(101588);
    }

    public void setLogoPosition(int i) {
        AppMethodBeat.m2504i(101589);
        if (this.f18049a != null) {
            this.f18049a.mo64976b(i);
        }
        AppMethodBeat.m2505o(101589);
    }

    public void setScaleViewPosition(int i) {
        AppMethodBeat.m2504i(101590);
        if (this.f18049a != null) {
            switch (i) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 1;
                    break;
            }
            this.f18049a.mo64972a(i);
        }
        AppMethodBeat.m2505o(101590);
    }

    public boolean isScaleControlsEnabled() {
        AppMethodBeat.m2504i(101591);
        if (this.f18049a != null) {
            boolean e = this.f18049a.mo64984e();
            AppMethodBeat.m2505o(101591);
            return e;
        }
        AppMethodBeat.m2505o(101591);
        return false;
    }

    public void setTiltGesturesEnabled(boolean z) {
        AppMethodBeat.m2504i(101592);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101592);
            return;
        }
        this.f18049a.mo64983e(z);
        AppMethodBeat.m2505o(101592);
    }

    public void setRotateGesturesEnabled(boolean z) {
        AppMethodBeat.m2504i(101593);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101593);
            return;
        }
        this.f18049a.mo64985f(z);
        AppMethodBeat.m2505o(101593);
    }

    public boolean isTiltGesturesEnabled() {
        AppMethodBeat.m2504i(101594);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101594);
            return false;
        }
        boolean b = this.f18049a.mo64978b();
        AppMethodBeat.m2505o(101594);
        return b;
    }

    public void setLogoScale(float f) {
        AppMethodBeat.m2504i(101595);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101595);
            return;
        }
        this.f18049a.mo64971a(f);
        AppMethodBeat.m2505o(101595);
    }

    public boolean isRotateGesturesEnabled() {
        AppMethodBeat.m2504i(101596);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101596);
            return false;
        }
        boolean c = this.f18049a.mo64980c();
        AppMethodBeat.m2505o(101596);
        return c;
    }

    public void setLogoPosition(int i, int[] iArr) {
        AppMethodBeat.m2504i(101597);
        if (this.f18049a != null) {
            this.f18049a.mo64973a(i, iArr);
        }
        AppMethodBeat.m2505o(101597);
    }

    public void setIndoorLevelPickerEnabled(boolean z) {
        AppMethodBeat.m2504i(101598);
        if (this.f18049a != null) {
            this.f18049a.mo64989j(z);
        }
        AppMethodBeat.m2505o(101598);
    }

    public boolean isIndoorLevelPickerEnabled() {
        AppMethodBeat.m2504i(101599);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101599);
            return false;
        }
        boolean d = this.f18049a.mo64982d();
        AppMethodBeat.m2505o(101599);
        return d;
    }

    public void setCompassEnabled(boolean z) {
        AppMethodBeat.m2504i(101600);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101600);
            return;
        }
        this.f18049a.mo64977b(z);
        AppMethodBeat.m2505o(101600);
    }

    public boolean isCompassEnabled() {
        AppMethodBeat.m2504i(101601);
        if (this.f18049a == null) {
            AppMethodBeat.m2505o(101601);
            return false;
        }
        boolean a = this.f18049a.mo64975a();
        AppMethodBeat.m2505o(101601);
        return a;
    }
}
