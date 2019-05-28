package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class q implements v {
    private boolean cAy;
    private long fVx = 0;
    private long fVy = 0;
    private String size;
    private int type;
    private String url;
    private boolean vbA;

    public static final class a {
        public int h;
        public int w;
        public int x;
        public int y;

        public final String toString() {
            AppMethodBeat.i(105498);
            String format = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w)});
            AppMethodBeat.o(105498);
            return format;
        }
    }

    public q(String str, int i, String str2) {
        this.url = str;
        this.type = i;
        this.size = str2;
        this.cAy = false;
    }

    public static String v(String str, int i, String str2) {
        AppMethodBeat.i(105499);
        String format;
        if (g.RN().QY()) {
            Object[] objArr = new Object[4];
            objArr[0] = c.bGF();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str2;
            StringBuilder stringBuilder = new StringBuilder();
            g.RN();
            objArr[3] = com.tencent.mm.a.g.x(stringBuilder.append(com.tencent.mm.kernel.a.QG()).append(str).toString().getBytes());
            format = String.format("%s%d%s_%s", objArr);
            AppMethodBeat.o(105499);
            return format;
        }
        format = "";
        AppMethodBeat.o(105499);
        return format;
    }

    public final String anJ() {
        AppMethodBeat.i(105500);
        String v = v(this.url, this.type, this.size);
        AppMethodBeat.o(105500);
        return v;
    }

    public final String anK() {
        String sy;
        AppMethodBeat.i(105501);
        if (com.tencent.mm.at.q.ahs()) {
            sy = com.tencent.mm.at.q.sy(this.url);
        } else {
            sy = this.url;
        }
        AppMethodBeat.o(105501);
        return sy;
    }

    public final String anL() {
        return this.url;
    }

    public final String getCacheKey() {
        AppMethodBeat.i(105502);
        String str = this.url + this.size;
        AppMethodBeat.o(105502);
        return str;
    }

    public final boolean anM() {
        return false;
    }

    public final boolean anN() {
        return this.cAy;
    }

    public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.v.a aVar, String str) {
        AppMethodBeat.i(105503);
        if (com.tencent.mm.platformtools.v.a.NET == aVar) {
            int i;
            int i2;
            String str2 = this.size;
            a aVar2 = new a();
            Context context = ah.getContext();
            DisplayMetrics displayMetrics = null;
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    displayMetrics = resources.getDisplayMetrics();
                }
            }
            if (displayMetrics != null) {
                int i3;
                if ("@T".equals(str2)) {
                    i3 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                    i = (int) (displayMetrics.density * 167.0f);
                    i2 = i3;
                } else {
                    i3 = (int) (displayMetrics.density * 50.0f);
                    i = i3;
                    i2 = i3;
                }
            } else if ("@T".equals(str2)) {
                i = 334;
                i2 = BaseClientBuilder.API_PRIORITY_OTHER;
            } else {
                i = 100;
                i2 = 100;
            }
            aVar2.w = i2;
            aVar2.h = i;
            ab.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = d.b(bitmap, aVar2.w, aVar2.h, true);
            try {
                ab.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", anJ());
                d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e, "", new Object[0]);
                ab.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", this.url);
            }
            AppMethodBeat.o(105503);
        } else {
            AppMethodBeat.o(105503);
        }
        return bitmap;
    }

    public final void anP() {
        AppMethodBeat.i(105504);
        this.fVx = bo.anU();
        if (this.vbA) {
            ab.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            h.pYm.a(86, 0, 1, false);
        }
        AppMethodBeat.o(105504);
    }

    public final void V(String str, boolean z) {
        AppMethodBeat.i(105505);
        this.fVy = bo.anU();
        Object obj = null;
        if (com.tencent.mm.at.q.ahs() && !bo.isNullOrNil(str) && com.tencent.mm.at.q.sz(anK()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (this.vbA) {
            if (z) {
                long j = this.fVy - this.fVx;
                ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", Long.valueOf(j));
                h.pYm.a(86, 4, j, false);
                if (obj != null) {
                    ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                    h.pYm.a(86, 17, j, false);
                    h.pYm.a(86, 13, 1, false);
                }
            } else {
                ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
                h.pYm.a(86, 2, 1, false);
                if (obj != null) {
                    ab.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
                    h.pYm.a(86, 15, 1, false);
                    AppMethodBeat.o(105505);
                    return;
                }
            }
        }
        AppMethodBeat.o(105505);
    }

    public final void a(com.tencent.mm.platformtools.v.a aVar, String str) {
        AppMethodBeat.i(105506);
        if (aVar == com.tencent.mm.platformtools.v.a.NET && this.vbA && com.tencent.mm.at.q.ahs() && !bo.isNullOrNil(str) && com.tencent.mm.at.q.sz(anK()) && str.equals("image/webp")) {
            ab.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            h.pYm.a(86, 14, 1, false);
        }
        AppMethodBeat.o(105506);
    }

    public final Bitmap anO() {
        AppMethodBeat.i(105507);
        Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
        AppMethodBeat.o(105507);
        return decodeResource;
    }

    public final b anI() {
        return null;
    }
}
