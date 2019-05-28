package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.f;
import com.tencent.tencentmap.mapsdk.a.cw;

public class iu implements f {
    private iz a;

    public iu(iz izVar) {
        this.a = izVar;
    }

    public boolean onIndoorBuildingFocused() {
        AppMethodBeat.i(99873);
        if (this.a == null) {
            AppMethodBeat.o(99873);
            return false;
        }
        this.a.onIndoorBuildingFocused();
        if (this.a.r != null) {
            this.a.r.onIndoorBuildingFocused();
        }
        lf lfVar = this.a.j;
        if (lfVar != null) {
            lfVar.b(true);
        }
        AppMethodBeat.o(99873);
        return true;
    }

    public boolean onIndoorLevelActivated(cw cwVar) {
        AppMethodBeat.i(99874);
        if (this.a == null) {
            AppMethodBeat.o(99874);
            return false;
        }
        this.a.onIndoorLevelActivated(cwVar);
        if (this.a.r != null) {
            this.a.r.onIndoorLevelActivated(cwVar);
        }
        lf lfVar = this.a.j;
        if (lfVar != null && lfVar.b() && this.a.b().h() >= 16) {
            lfVar.a(cwVar);
        }
        AppMethodBeat.o(99874);
        return true;
    }

    public boolean onIndoorBuildingDeactivated() {
        AppMethodBeat.i(99875);
        if (this.a == null) {
            AppMethodBeat.o(99875);
            return false;
        }
        this.a.onIndoorBuildingDeactivated();
        if (this.a.r != null) {
            this.a.r.onIndoorBuildingDeactivated();
        }
        lf lfVar = this.a.j;
        if (lfVar != null) {
            lfVar.b(false);
        }
        AppMethodBeat.o(99875);
        return true;
    }
}
