package com.tencent.p177mm.plugin.appbrand.p893e;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.e.e */
public class C42433e implements C24693g {
    protected C19213f hpM;
    protected boolean hpN;
    /* renamed from: id */
    protected int f17183id;
    protected String type;

    /* renamed from: a */
    public boolean mo41593a(C45608m c45608m) {
        return this.hpN;
    }

    /* renamed from: d */
    public void mo32980d(SurfaceTexture surfaceTexture) {
        this.hpN = true;
    }

    /* renamed from: yr */
    public void mo32982yr() {
        this.hpN = false;
    }

    /* renamed from: m */
    public void mo32981m(MotionEvent motionEvent) {
    }

    /* renamed from: a */
    public String mo41591a(C2241c c2241c, JSONObject jSONObject, C45608m c45608m, int i) {
        return null;
    }

    /* renamed from: a */
    public final void mo41592a(C19213f c19213f) {
        this.hpM = c19213f;
    }

    public final C19213f aAn() {
        return this.hpM;
    }

    public final int getId() {
        return this.f17183id;
    }

    public final void setId(int i) {
        this.f17183id = i;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: wP */
    public final String mo67958wP() {
        AppMethodBeat.m2504i(117343);
        String bc = C45551d.m84007bc(this.type, this.f17183id);
        AppMethodBeat.m2505o(117343);
        return bc;
    }
}
