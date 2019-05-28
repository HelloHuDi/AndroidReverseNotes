package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Color;
import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30984n;
import com.tencent.tencentmap.mapsdk.p666a.C41006af.C41005a;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cj */
public class C41016cj extends C30997bv {
    /* renamed from: a */
    private C44481at f16393a = null;
    /* renamed from: b */
    private C41011bp f16394b = null;
    /* renamed from: c */
    private C41012br f16395c = null;
    /* renamed from: d */
    private C41005a f16396d = null;
    /* renamed from: e */
    private C41006af f16397e = null;
    /* renamed from: f */
    private boolean f16398f = false;
    /* renamed from: g */
    private C44490de f16399g = null;
    /* renamed from: h */
    private C5843cq f16400h = null;
    /* renamed from: i */
    private C30984n f16401i = null;
    /* renamed from: j */
    private C44493dh f16402j = new C44493dh();
    /* renamed from: k */
    private int f16403k = Color.argb(102, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    /* renamed from: l */
    private Location f16404l = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.cj$1 */
    class C410171 implements C41005a {
        C410171() {
        }
    }

    public C41016cj(C44481at c44481at, C41011bp c41011bp, C41012br c41012br) {
        AppMethodBeat.m2504i(100941);
        this.f16393a = c44481at;
        this.f16394b = c41011bp;
        this.f16395c = c41012br;
        this.f16396d = m71243f();
        AppMethodBeat.m2505o(100941);
    }

    /* renamed from: e */
    public void mo65063e() {
        AppMethodBeat.m2504i(100942);
        mo50182b();
        this.f16393a = null;
        this.f16394b = null;
        this.f16395c = null;
        AppMethodBeat.m2505o(100942);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo50181a() {
        AppMethodBeat.m2504i(100943);
        if (this.f16398f) {
            AppMethodBeat.m2505o(100943);
            return;
        }
        this.f16398f = true;
        if (this.f16396d == null) {
            this.f16396d = m71243f();
        }
        if (this.f16399g != null) {
            this.f16399g.mo70740b(true);
        }
        if (this.f16400h != null) {
            this.f16400h.mo12334a(true);
        }
        if (this.f16397e != null) {
            this.f16397e.mo64970a(this.f16396d);
        }
        AppMethodBeat.m2505o(100943);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo50182b() {
        AppMethodBeat.m2504i(100944);
        if (this.f16399g != null) {
            this.f16399g.mo70740b(false);
            this.f16399g.mo70737b();
            this.f16399g = null;
        }
        if (this.f16400h != null) {
            this.f16400h.mo12334a(false);
            this.f16400h.mo12336b();
            this.f16400h = null;
        }
        if (this.f16398f) {
            this.f16398f = false;
            this.f16396d = null;
            if (this.f16397e != null) {
                this.f16397e.mo64969a();
            }
            AppMethodBeat.m2505o(100944);
            return;
        }
        AppMethodBeat.m2505o(100944);
    }

    /* renamed from: f */
    private C41005a m71243f() {
        AppMethodBeat.m2504i(100945);
        C410171 c410171 = new C410171();
        AppMethodBeat.m2505o(100945);
        return c410171;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public Location mo50184d() {
        AppMethodBeat.m2504i(100946);
        if (this.f16404l == null) {
            AppMethodBeat.m2505o(100946);
            return null;
        }
        Location location = new Location(this.f16404l);
        AppMethodBeat.m2505o(100946);
        return location;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public boolean mo50183c() {
        return this.f16398f;
    }
}
