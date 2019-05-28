package com.tencent.mm.plugin.appbrand.e;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

public class e implements g {
    protected f hpM;
    protected boolean hpN;
    protected int id;
    protected String type;

    public boolean a(m mVar) {
        return this.hpN;
    }

    public void d(SurfaceTexture surfaceTexture) {
        this.hpN = true;
    }

    public void yr() {
        this.hpN = false;
    }

    public void m(MotionEvent motionEvent) {
    }

    public String a(c cVar, JSONObject jSONObject, m mVar, int i) {
        return null;
    }

    public final void a(f fVar) {
        this.hpM = fVar;
    }

    public final f aAn() {
        return this.hpM;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* Access modifiers changed, original: protected|final */
    public final String wP() {
        AppMethodBeat.i(117343);
        String bc = d.bc(this.type, this.id);
        AppMethodBeat.o(117343);
        return bc;
    }
}
