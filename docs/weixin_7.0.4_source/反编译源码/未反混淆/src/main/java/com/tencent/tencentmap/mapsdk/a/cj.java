package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tencentmap.mapsdk.a.af.a;
import com.tencent.tencentmap.mapsdk.a.aj.n;

public class cj extends bv {
    private at a = null;
    private bp b = null;
    private br c = null;
    private a d = null;
    private af e = null;
    private boolean f = false;
    private de g = null;
    private cq h = null;
    private n i = null;
    private dh j = new dh();
    private int k = Color.argb(102, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    private Location l = null;

    public cj(at atVar, bp bpVar, br brVar) {
        AppMethodBeat.i(100941);
        this.a = atVar;
        this.b = bpVar;
        this.c = brVar;
        this.d = f();
        AppMethodBeat.o(100941);
    }

    public void e() {
        AppMethodBeat.i(100942);
        b();
        this.a = null;
        this.b = null;
        this.c = null;
        AppMethodBeat.o(100942);
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        AppMethodBeat.i(100943);
        if (this.f) {
            AppMethodBeat.o(100943);
            return;
        }
        this.f = true;
        if (this.d == null) {
            this.d = f();
        }
        if (this.g != null) {
            this.g.b(true);
        }
        if (this.h != null) {
            this.h.a(true);
        }
        if (this.e != null) {
            this.e.a(this.d);
        }
        AppMethodBeat.o(100943);
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        AppMethodBeat.i(100944);
        if (this.g != null) {
            this.g.b(false);
            this.g.b();
            this.g = null;
        }
        if (this.h != null) {
            this.h.a(false);
            this.h.b();
            this.h = null;
        }
        if (this.f) {
            this.f = false;
            this.d = null;
            if (this.e != null) {
                this.e.a();
            }
            AppMethodBeat.o(100944);
            return;
        }
        AppMethodBeat.o(100944);
    }

    private a f() {
        AppMethodBeat.i(100945);
        AnonymousClass1 anonymousClass1 = new a() {
        };
        AppMethodBeat.o(100945);
        return anonymousClass1;
    }

    /* Access modifiers changed, original: 0000 */
    public Location d() {
        AppMethodBeat.i(100946);
        if (this.l == null) {
            AppMethodBeat.o(100946);
            return null;
        }
        Location location = new Location(this.l);
        AppMethodBeat.o(100946);
        return location;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean c() {
        return this.f;
    }
}
