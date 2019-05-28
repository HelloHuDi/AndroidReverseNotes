package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.c;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.f;
import com.tencent.tencentmap.mapsdk.maps.a.ft;
import com.tencent.tencentmap.mapsdk.maps.a.gs;
import com.tencent.tencentmap.mapsdk.maps.a.iu;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import java.util.ArrayList;
import java.util.List;

public class ch implements e, ft {
    cw a = null;
    private iz b;
    private f c = null;
    private Handler d = new Handler();
    private boolean e = false;

    static /* synthetic */ void a(ch chVar, String str, String str2, String[] strArr, int i) {
        AppMethodBeat.i(100936);
        chVar.a(str, str2, strArr, i);
        AppMethodBeat.o(100936);
    }

    public ch(iz izVar) {
        AppMethodBeat.i(100930);
        this.b = izVar;
        if (!(izVar == null || izVar.b() == null)) {
            com.tencent.map.lib.f b = izVar.b();
            b.a((ft) this);
            b.a((e) this);
            this.c = new iu(this.b);
        }
        AppMethodBeat.o(100930);
    }

    public boolean a() {
        return this.e;
    }

    public void z() {
        AppMethodBeat.i(100931);
        if (this.b == null || this.b.b() == null) {
            AppMethodBeat.o(100931);
            return;
        }
        c d = this.b.b().d(new GeoPoint());
        if (d == null) {
            AppMethodBeat.o(100931);
            return;
        }
        final String str = d.a;
        final String str2 = d.b;
        final String[] strArr = d.d;
        final int i = d.c;
        this.d.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(100929);
                ch.a(ch.this, str, str2, strArr, i);
                AppMethodBeat.o(100929);
            }
        });
        AppMethodBeat.o(100931);
    }

    private void a(String str, String str2, String[] strArr, int i) {
        int i2 = 0;
        AppMethodBeat.i(100932);
        if (this.b == null || this.b.b() == null) {
            AppMethodBeat.o(100932);
            return;
        }
        com.tencent.map.lib.f b = this.b.b();
        int c = b.c();
        if (str == null || strArr == null || strArr.length <= 0 || i < 0 || c < 16) {
            c();
            if (this.e) {
                this.e = false;
                this.a = null;
                if (this.c != null) {
                    this.c.onIndoorBuildingDeactivated();
                }
            }
            AppMethodBeat.o(100932);
            return;
        }
        if (!(this.c == null || this.e)) {
            this.e = true;
            this.c.onIndoorBuildingFocused();
        }
        b.g(Math.min(this.b.i, 22));
        if (this.c != null) {
            ArrayList arrayList = new ArrayList();
            c = strArr.length;
            while (i2 < c) {
                arrayList.add(new cy(strArr[i2]));
                i2++;
            }
            try {
                if (this.a != null && this.a.a().equals(str) && this.a.d() == i) {
                    AppMethodBeat.o(100932);
                    return;
                }
            } catch (Exception e) {
            }
            this.a = new cw(str, str2, arrayList, i);
            this.c.onIndoorLevelActivated(this.a);
        }
        AppMethodBeat.o(100932);
    }

    public void a(gs.c cVar) {
        AppMethodBeat.i(100933);
        if (this.b == null || this.b.b() == null || this.b.D() == null) {
            AppMethodBeat.o(100933);
        } else if (this.e) {
            this.b.D().b(true);
            AppMethodBeat.o(100933);
        } else {
            this.b.D().b(false);
            c();
            AppMethodBeat.o(100933);
        }
    }

    private void c() {
        AppMethodBeat.i(100934);
        if (this.b == null || this.b.b() == null || this.e) {
            AppMethodBeat.o(100934);
            return;
        }
        com.tencent.map.lib.f b = this.b.b();
        int min = Math.min(20, this.b.i);
        if (b.j() < ((float) min)) {
            b.g(min);
        }
        AppMethodBeat.o(100934);
    }

    public void b() {
        AppMethodBeat.i(100935);
        if (this.a != null) {
            String a = this.a.a();
            int d = this.a.d();
            List c = this.a.c();
            if (c == null || d >= c.size()) {
                AppMethodBeat.o(100935);
                return;
            }
            String a2 = ((cy) c.get(d)).a();
            if (!(StringUtil.isEmpty(a) || StringUtil.isEmpty(a2))) {
                this.b.b().a(a, a2);
            }
        }
        AppMethodBeat.o(100935);
    }
}
