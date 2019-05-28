package com.tencent.mm.plugin.profile.ui.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class c extends BitmapDrawable implements a {
    private String url;

    public c(Resources resources, String str) {
        Bitmap i;
        boolean z = true;
        if (ao.a.flw != null) {
            i = b.i(ao.a.flw.ky(16), 2.0f);
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
        ab.i(str2, str3, objArr);
        super(resources, i);
        AppMethodBeat.i(23969);
        this.url = str;
        x.a((a) this);
        AppMethodBeat.o(23969);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(23970);
        Bitmap a = x.a(new v() {
            public final boolean anN() {
                return false;
            }

            public final boolean anM() {
                return false;
            }

            public final Bitmap a(Bitmap bitmap, v.a aVar, String str) {
                AppMethodBeat.i(23964);
                if (v.a.NET == aVar) {
                    try {
                        d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.UrlDrawable", e, "", new Object[0]);
                        ab.w("MicroMsg.UrlDrawable", "save bitmap fail");
                    }
                }
                ab.d("MicroMsg.UrlDrawable", "get bitmap, from %s", aVar.toString());
                AppMethodBeat.o(23964);
                return bitmap;
            }

            public final void anP() {
            }

            public final void V(String str, boolean z) {
            }

            public final void a(v.a aVar, String str) {
            }

            public final v.b anI() {
                return null;
            }

            public final String anJ() {
                AppMethodBeat.i(23965);
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Yf()).append(ag.ck(c.this.url)).toString();
                AppMethodBeat.o(23965);
                return stringBuilder2;
            }

            public final String anL() {
                AppMethodBeat.i(23966);
                String a = c.this.url;
                AppMethodBeat.o(23966);
                return a;
            }

            public final Bitmap anO() {
                return null;
            }

            public final String anK() {
                AppMethodBeat.i(23967);
                String a = c.this.url;
                AppMethodBeat.o(23967);
                return a;
            }

            public final String getCacheKey() {
                AppMethodBeat.i(23968);
                String a = c.this.url;
                AppMethodBeat.o(23968);
                return a;
            }
        });
        if (a == null || a.isRecycled()) {
            a = null;
        }
        Rect bounds = getBounds();
        if (a != null) {
            canvas.drawBitmap(a, null, bounds, null);
        }
        AppMethodBeat.o(23970);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(23971);
        if (this.url.equals(str)) {
            invalidateSelf();
        }
        AppMethodBeat.o(23971);
    }
}
