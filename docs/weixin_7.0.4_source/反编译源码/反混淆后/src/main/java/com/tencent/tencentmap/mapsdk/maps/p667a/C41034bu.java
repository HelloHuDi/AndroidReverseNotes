package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bu */
public final class C41034bu {
    /* renamed from: a */
    public int f16441a = -1;
    /* renamed from: b */
    public int f16442b = -1;
    /* renamed from: c */
    private String f16443c = "";
    /* renamed from: d */
    private int f16444d = -1;
    /* renamed from: e */
    private byte f16445e;
    /* renamed from: f */
    private byte f16446f = (byte) 1;
    /* renamed from: g */
    private String[] f16447g;

    public C41034bu(String str, int i) {
        this.f16443c = str;
        this.f16444d = i;
    }

    /* renamed from: a */
    public final String mo65116a() {
        return this.f16443c;
    }

    /* renamed from: a */
    public final void mo65117a(byte b) {
        this.f16445e = (byte) 3;
    }

    /* renamed from: a */
    public final boolean mo65118a(C41034bu c41034bu) {
        AppMethodBeat.m2504i(98584);
        if (c41034bu != null && this.f16443c.equals(c41034bu.f16443c) && this.f16444d == c41034bu.f16444d) {
            AppMethodBeat.m2505o(98584);
            return true;
        }
        AppMethodBeat.m2505o(98584);
        return false;
    }

    /* renamed from: a */
    public final boolean mo65119a(String str) {
        AppMethodBeat.m2504i(98582);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98582);
            return false;
        }
        this.f16447g = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (this.f16447g.length != 2) {
            AppMethodBeat.m2505o(98582);
            return false;
        }
        this.f16443c = this.f16447g[0];
        if (C24373eu.m37746d(this.f16443c)) {
            try {
                this.f16444d = Integer.parseInt(this.f16447g[1]);
                if (this.f16444d < 0 || this.f16444d > CdnLogic.kBizGeneric) {
                    AppMethodBeat.m2505o(98582);
                    return false;
                }
                AppMethodBeat.m2505o(98582);
                return true;
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(98582);
                return false;
            }
        }
        AppMethodBeat.m2505o(98582);
        return false;
    }

    /* renamed from: b */
    public final byte mo65120b() {
        return this.f16445e;
    }

    /* renamed from: c */
    public final int mo65121c() {
        return this.f16444d;
    }

    /* renamed from: d */
    public final String mo65122d() {
        AppMethodBeat.m2504i(98581);
        String str = this.f16443c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.f16444d;
        AppMethodBeat.m2505o(98581);
        return str;
    }

    /* renamed from: e */
    public final boolean mo65123e() {
        return this.f16445e == (byte) 3;
    }

    public final String toString() {
        AppMethodBeat.m2504i(98583);
        String str = this.f16443c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.f16444d + ",protocalType:" + this.f16446f + ",ipType:" + this.f16445e;
        AppMethodBeat.m2505o(98583);
        return str;
    }
}
