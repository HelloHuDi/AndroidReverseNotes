package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.pluginsdk.model.q */
public final class C30080q implements C9791v {
    private boolean cAy;
    private long fVx = 0;
    private long fVy = 0;
    private String size;
    private int type;
    private String url;
    private boolean vbA;

    /* renamed from: com.tencent.mm.pluginsdk.model.q$a */
    public static final class C30079a {
        /* renamed from: h */
        public int f13724h;
        /* renamed from: w */
        public int f13725w;
        /* renamed from: x */
        public int f13726x;
        /* renamed from: y */
        public int f13727y;

        public final String toString() {
            AppMethodBeat.m2504i(105498);
            String format = String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.f13726x), Integer.valueOf(this.f13727y), Integer.valueOf(this.f13724h), Integer.valueOf(this.f13725w)});
            AppMethodBeat.m2505o(105498);
            return format;
        }
    }

    public C30080q(String str, int i, String str2) {
        this.url = str;
        this.type = i;
        this.size = str2;
        this.cAy = false;
    }

    /* renamed from: v */
    public static String m47642v(String str, int i, String str2) {
        AppMethodBeat.m2504i(105499);
        String format;
        if (C1720g.m3534RN().mo5161QY()) {
            Object[] objArr = new Object[4];
            objArr[0] = C43217c.bGF();
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str2;
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            objArr[3] = C1178g.m2591x(stringBuilder.append(C1668a.m3384QG()).append(str).toString().getBytes());
            format = String.format("%s%d%s_%s", objArr);
            AppMethodBeat.m2505o(105499);
            return format;
        }
        format = "";
        AppMethodBeat.m2505o(105499);
        return format;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(105500);
        String v = C30080q.m47642v(this.url, this.type, this.size);
        AppMethodBeat.m2505o(105500);
        return v;
    }

    public final String anK() {
        String sy;
        AppMethodBeat.m2504i(105501);
        if (C41764q.ahs()) {
            sy = C41764q.m73703sy(this.url);
        } else {
            sy = this.url;
        }
        AppMethodBeat.m2505o(105501);
        return sy;
    }

    public final String anL() {
        return this.url;
    }

    public final String getCacheKey() {
        AppMethodBeat.m2504i(105502);
        String str = this.url + this.size;
        AppMethodBeat.m2505o(105502);
        return str;
    }

    public final boolean anM() {
        return false;
    }

    public final boolean anN() {
        return this.cAy;
    }

    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        AppMethodBeat.m2504i(105503);
        if (C9793a.NET == c9793a) {
            int i;
            int i2;
            String str2 = this.size;
            C30079a c30079a = new C30079a();
            Context context = C4996ah.getContext();
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
            c30079a.f13725w = i2;
            c30079a.f13724h = i;
            C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", c30079a.toString());
            bitmap = C5056d.m7649b(bitmap, c30079a.f13725w, c30079a.f13724h, true);
            try {
                C4990ab.m7411d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", anJ());
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, anJ(), false);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", this.url);
            }
            AppMethodBeat.m2505o(105503);
        } else {
            AppMethodBeat.m2505o(105503);
        }
        return bitmap;
    }

    public final void anP() {
        AppMethodBeat.m2504i(105504);
        this.fVx = C5046bo.anU();
        if (this.vbA) {
            C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            C7060h.pYm.mo8378a(86, 0, 1, false);
        }
        AppMethodBeat.m2505o(105504);
    }

    /* renamed from: V */
    public final void mo9516V(String str, boolean z) {
        AppMethodBeat.m2504i(105505);
        this.fVy = C5046bo.anU();
        Object obj = null;
        if (C41764q.ahs() && !C5046bo.isNullOrNil(str) && C41764q.m73704sz(anK()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (this.vbA) {
            if (z) {
                long j = this.fVy - this.fVx;
                C4990ab.m7411d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", Long.valueOf(j));
                C7060h.pYm.mo8378a(86, 4, j, false);
                if (obj != null) {
                    C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                    C7060h.pYm.mo8378a(86, 17, j, false);
                    C7060h.pYm.mo8378a(86, 13, 1, false);
                }
            } else {
                C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
                C7060h.pYm.mo8378a(86, 2, 1, false);
                if (obj != null) {
                    C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
                    C7060h.pYm.mo8378a(86, 15, 1, false);
                    AppMethodBeat.m2505o(105505);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(105505);
    }

    /* renamed from: a */
    public final void mo9518a(C9793a c9793a, String str) {
        AppMethodBeat.m2504i(105506);
        if (c9793a == C9793a.NET && this.vbA && C41764q.ahs() && !C5046bo.isNullOrNil(str) && C41764q.m73704sz(anK()) && str.equals("image/webp")) {
            C4990ab.m7410d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            C7060h.pYm.mo8378a(86, 14, 1, false);
        }
        AppMethodBeat.m2505o(105506);
    }

    public final Bitmap anO() {
        AppMethodBeat.m2504i(105507);
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
        AppMethodBeat.m2505o(105507);
        return decodeResource;
    }

    public final C9792b anI() {
        return null;
    }
}
