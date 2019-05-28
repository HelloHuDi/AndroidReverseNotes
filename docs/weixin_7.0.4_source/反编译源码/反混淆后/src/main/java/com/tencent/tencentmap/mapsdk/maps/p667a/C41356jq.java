package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.support.p057v4.widget.C8415j;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.p822gl.JNICallback.C32209c;
import com.tencent.map.lib.p822gl.JNICallback.C32211b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31066jt.C31067b;
import com.tencent.tencentmap.mapsdk.p666a.C36459bg;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jq */
public class C41356jq implements C32211b, C32209c, C31067b {
    /* renamed from: a */
    private WeakReference<C31061iz> f16587a;
    /* renamed from: b */
    private WeakReference<C8889f> f16588b;
    /* renamed from: c */
    private C46797jw f16589c;
    /* renamed from: d */
    private int f16590d = -1;

    public C41356jq(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100090);
        this.f16587a = new WeakReference(c31061iz);
        this.f16588b = new WeakReference(c31061iz.mo75386b());
        this.f16589c = new C31069ju(c31061iz.mo65138i());
        mo66011a((C32211b) this);
        mo66012a((C32209c) this);
        AppMethodBeat.m2505o(100090);
    }

    /* renamed from: a */
    public void mo66011a(C32211b c32211b) {
        AppMethodBeat.m2504i(100091);
        if (!(this.f16588b == null || this.f16588b.get() == null)) {
            ((C8889f) this.f16588b.get()).mo20165a(c32211b);
        }
        AppMethodBeat.m2505o(100091);
    }

    /* renamed from: a */
    public void mo66012a(C32209c c32209c) {
        AppMethodBeat.m2504i(100092);
        if (!(this.f16588b == null || this.f16588b.get() == null)) {
            ((C8889f) this.f16588b.get()).mo20166a(c32209c);
        }
        AppMethodBeat.m2505o(100092);
    }

    /* renamed from: a */
    public int mo66010a() {
        AppMethodBeat.m2504i(100093);
        if (!(this.f16588b == null || this.f16588b.get() == null)) {
            this.f16590d = ((C8889f) this.f16588b.get()).mo20140C();
            if (this.f16590d != -1) {
                ((C8889f) this.f16588b.get()).mo20161a(this.f16590d, 4, 20);
            }
        }
        int i = this.f16590d;
        AppMethodBeat.m2505o(100093);
        return i;
    }

    /* renamed from: b */
    public void mo66013b() {
        AppMethodBeat.m2504i(100094);
        if (!(this.f16588b == null || this.f16588b.get() == null || this.f16590d == -1)) {
            C8889f c8889f = (C8889f) this.f16588b.get();
            c8889f.mo20165a(null);
            c8889f.mo20166a(null);
            c8889f.mo20229i(this.f16590d);
            this.f16589c.mo50499b();
            this.f16590d = -1;
        }
        AppMethodBeat.m2505o(100094);
    }

    /* renamed from: c */
    public void mo66014c() {
        AppMethodBeat.m2504i(100095);
        if (!(this.f16588b == null || this.f16588b.get() == null || this.f16590d == C8415j.INVALID_ID)) {
            ((C8889f) this.f16588b.get()).mo20232j(this.f16590d);
        }
        AppMethodBeat.m2505o(100095);
    }

    /* renamed from: a */
    public Bitmap mo52883a(byte[] bArr) {
        AppMethodBeat.m2504i(100096);
        if (this.f16587a == null || this.f16587a.get() == null || this.f16590d == -1) {
            AppMethodBeat.m2505o(100096);
            return null;
        }
        C36459bg c36459bg = new C36459bg();
        c36459bg.mo57660a(bArr);
        Bitmap a = this.f16589c.mo50496a(c36459bg.mo57659a(), c36459bg.mo57661b(), c36459bg.mo57662c(), bArr);
        AppMethodBeat.m2505o(100096);
        return a;
    }

    /* renamed from: a */
    public void mo52881a(String str, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(100097);
        if (bArr2 == null || bArr == null || bArr2.length == 0 || bArr.length == 0) {
            AppMethodBeat.m2505o(100097);
            return;
        }
        C36459bg c36459bg = new C36459bg();
        c36459bg.mo57660a(bArr);
        this.f16589c.mo50498a(c36459bg.mo57659a(), c36459bg.mo57661b(), c36459bg.mo57662c(), str, bArr2);
        AppMethodBeat.m2505o(100097);
    }

    /* renamed from: b_ */
    public void mo50490b_() {
        AppMethodBeat.m2504i(100098);
        this.f16589c.mo50497a();
        mo66014c();
        AppMethodBeat.m2505o(100098);
    }
}
