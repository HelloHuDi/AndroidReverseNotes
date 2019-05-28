package com.tencent.p177mm.plugin.freewifi.p416d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.freewifi.d.c */
public abstract class C43104c extends C1207m implements C1918k {
    protected Activity activity;
    protected C7472b ehh;
    protected C1202f ehi;
    protected C1202f mww;

    public abstract void bzd();

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        C34189m.m56056MA("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.mww != null) {
            this.mww.onSceneEnd(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.ehi != null) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final C1929q c1929q2 = c1929q;
            final byte[] bArr2 = bArr;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(20778);
                    C43104c.this.mo45999b(i4, i5, i6, str2);
                    if (C43104c.this.ehi != null) {
                        C43104c.this.ehi.onSceneEnd(i5, i6, str2, C43104c.this);
                    }
                    AppMethodBeat.m2505o(20778);
                }
            });
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo45999b(int i, int i2, int i3, String str) {
    }

    /* renamed from: c */
    public final void mo68619c(C1202f c1202f) {
        this.ehi = c1202f;
        C34189m.m56056MA("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        C9638aw.m17182Rg().mo14541a((C1207m) this, 0);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.mww = c1202f;
        return mo4457a(c1902e, this.ehh, this);
    }

    /* renamed from: O */
    public final C43104c mo68618O(Activity activity) {
        this.activity = activity;
        return this;
    }
}
