package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class ek implements UiSettings {
    private am a;

    public ek(am amVar) {
        this.a = amVar;
    }

    public boolean isAnimationEnabled() {
        return false;
    }

    public void setAnimationEnabled(boolean z) {
    }

    public void setScaleControlsEnabled(boolean z) {
        AppMethodBeat.i(101585);
        if (this.a != null) {
            this.a.h(z);
        }
        AppMethodBeat.o(101585);
    }

    public void setScrollGesturesEnabled(boolean z) {
        AppMethodBeat.i(101586);
        if (this.a != null) {
            this.a.c(z);
        }
        AppMethodBeat.o(101586);
    }

    public void setZoomGesturesEnabled(boolean z) {
        AppMethodBeat.i(101587);
        if (this.a != null) {
            this.a.d(z);
        }
        AppMethodBeat.o(101587);
    }

    public void setAllGesturesEnabled(boolean z) {
        AppMethodBeat.i(101588);
        if (this.a != null) {
            this.a.g(z);
        }
        AppMethodBeat.o(101588);
    }

    public void setLogoPosition(int i) {
        AppMethodBeat.i(101589);
        if (this.a != null) {
            this.a.b(i);
        }
        AppMethodBeat.o(101589);
    }

    public void setScaleViewPosition(int i) {
        AppMethodBeat.i(101590);
        if (this.a != null) {
            switch (i) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 1;
                    break;
            }
            this.a.a(i);
        }
        AppMethodBeat.o(101590);
    }

    public boolean isScaleControlsEnabled() {
        AppMethodBeat.i(101591);
        if (this.a != null) {
            boolean e = this.a.e();
            AppMethodBeat.o(101591);
            return e;
        }
        AppMethodBeat.o(101591);
        return false;
    }

    public void setTiltGesturesEnabled(boolean z) {
        AppMethodBeat.i(101592);
        if (this.a == null) {
            AppMethodBeat.o(101592);
            return;
        }
        this.a.e(z);
        AppMethodBeat.o(101592);
    }

    public void setRotateGesturesEnabled(boolean z) {
        AppMethodBeat.i(101593);
        if (this.a == null) {
            AppMethodBeat.o(101593);
            return;
        }
        this.a.f(z);
        AppMethodBeat.o(101593);
    }

    public boolean isTiltGesturesEnabled() {
        AppMethodBeat.i(101594);
        if (this.a == null) {
            AppMethodBeat.o(101594);
            return false;
        }
        boolean b = this.a.b();
        AppMethodBeat.o(101594);
        return b;
    }

    public void setLogoScale(float f) {
        AppMethodBeat.i(101595);
        if (this.a == null) {
            AppMethodBeat.o(101595);
            return;
        }
        this.a.a(f);
        AppMethodBeat.o(101595);
    }

    public boolean isRotateGesturesEnabled() {
        AppMethodBeat.i(101596);
        if (this.a == null) {
            AppMethodBeat.o(101596);
            return false;
        }
        boolean c = this.a.c();
        AppMethodBeat.o(101596);
        return c;
    }

    public void setLogoPosition(int i, int[] iArr) {
        AppMethodBeat.i(101597);
        if (this.a != null) {
            this.a.a(i, iArr);
        }
        AppMethodBeat.o(101597);
    }

    public void setIndoorLevelPickerEnabled(boolean z) {
        AppMethodBeat.i(101598);
        if (this.a != null) {
            this.a.j(z);
        }
        AppMethodBeat.o(101598);
    }

    public boolean isIndoorLevelPickerEnabled() {
        AppMethodBeat.i(101599);
        if (this.a == null) {
            AppMethodBeat.o(101599);
            return false;
        }
        boolean d = this.a.d();
        AppMethodBeat.o(101599);
        return d;
    }

    public void setCompassEnabled(boolean z) {
        AppMethodBeat.i(101600);
        if (this.a == null) {
            AppMethodBeat.o(101600);
            return;
        }
        this.a.b(z);
        AppMethodBeat.o(101600);
    }

    public boolean isCompassEnabled() {
        AppMethodBeat.i(101601);
        if (this.a == null) {
            AppMethodBeat.o(101601);
            return false;
        }
        boolean a = this.a.a();
        AppMethodBeat.o(101601);
        return a;
    }
}
