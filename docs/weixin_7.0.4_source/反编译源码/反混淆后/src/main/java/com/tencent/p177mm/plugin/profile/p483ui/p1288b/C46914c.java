package com.tencent.p177mm.plugin.profile.p483ui.p1288b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.profile.ui.b.c */
public final class C46914c extends BitmapDrawable implements C18765a {
    private String url;

    /* renamed from: com.tencent.mm.plugin.profile.ui.b.c$1 */
    class C214861 implements C9791v {
        C214861() {
        }

        public final boolean anN() {
            return false;
        }

        public final boolean anM() {
            return false;
        }

        /* renamed from: a */
        public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
            AppMethodBeat.m2504i(23964);
            if (C9793a.NET == c9793a) {
                try {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.UrlDrawable", e, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.UrlDrawable", "save bitmap fail");
                }
            }
            C4990ab.m7411d("MicroMsg.UrlDrawable", "get bitmap, from %s", c9793a.toString());
            AppMethodBeat.m2505o(23964);
            return bitmap;
        }

        public final void anP() {
        }

        /* renamed from: V */
        public final void mo9516V(String str, boolean z) {
        }

        /* renamed from: a */
        public final void mo9518a(C9793a c9793a, String str) {
        }

        public final C9792b anI() {
            return null;
        }

        public final String anJ() {
            AppMethodBeat.m2504i(23965);
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            String stringBuilder2 = stringBuilder.append(C18628c.m29097Yf()).append(C4995ag.m7428ck(C46914c.this.url)).toString();
            AppMethodBeat.m2505o(23965);
            return stringBuilder2;
        }

        public final String anL() {
            AppMethodBeat.m2504i(23966);
            String a = C46914c.this.url;
            AppMethodBeat.m2505o(23966);
            return a;
        }

        public final Bitmap anO() {
            return null;
        }

        public final String anK() {
            AppMethodBeat.m2504i(23967);
            String a = C46914c.this.url;
            AppMethodBeat.m2505o(23967);
            return a;
        }

        public final String getCacheKey() {
            AppMethodBeat.m2504i(23968);
            String a = C46914c.this.url;
            AppMethodBeat.m2505o(23968);
            return a;
        }
    }

    public C46914c(Resources resources, String str) {
        Bitmap i;
        boolean z = true;
        if (C26417a.flw != null) {
            i = C4977b.m7374i(C26417a.flw.mo37872ky(16), 2.0f);
        } else {
            i = null;
        }
        String str2 = "MicroMsg.UrlDrawable";
        String str3 = "verify bmp is null ? %B";
        Object[] objArr = new Object[1];
        if (i != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        super(resources, i);
        AppMethodBeat.m2504i(23969);
        this.url = str;
        C18764x.m29326a((C18765a) this);
        AppMethodBeat.m2505o(23969);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(23970);
        Bitmap a = C18764x.m29325a(new C214861());
        if (a == null || a.isRecycled()) {
            a = null;
        }
        Rect bounds = getBounds();
        if (a != null) {
            canvas.drawBitmap(a, null, bounds, null);
        }
        AppMethodBeat.m2505o(23970);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(23971);
        if (this.url.equals(str)) {
            invalidateSelf();
        }
        AppMethodBeat.m2505o(23971);
    }
}
