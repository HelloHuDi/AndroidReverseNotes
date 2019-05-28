package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cr */
public class C41039cr {
    /* renamed from: a */
    public String f16454a;
    /* renamed from: b */
    private boolean f16455b;
    /* renamed from: c */
    private boolean f16456c;
    /* renamed from: d */
    private int f16457d;
    /* renamed from: e */
    private URL f16458e;
    /* renamed from: f */
    private String f16459f;
    /* renamed from: g */
    private int f16460g;

    public C41039cr(URL url, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(98659);
        this.f16455b = C24362a.m37665a("direct_access_use_schedule", 0, 1, 1) == 1;
        if (C24362a.m37665a("direct_https_use_sche", 0, 1, 1) == 1) {
            z = true;
        }
        this.f16456c = z;
        this.f16457d = C24362a.m37665a("direct_access_domain_try_times", 1, 8, 2);
        this.f16454a = "";
        this.f16458e = url;
        this.f16459f = str;
        AppMethodBeat.m2505o(98659);
    }

    /* renamed from: a */
    public final String mo65128a(C41034bu c41034bu) {
        AppMethodBeat.m2504i(98660);
        String str;
        if (c41034bu.mo65123e()) {
            str = this.f16459f;
            AppMethodBeat.m2505o(98660);
            return str;
        }
        str = !this.f16458e.getProtocol().startsWith("https") ? "http://" + c41034bu.mo65116a() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c41034bu.mo65121c() : this.f16460g != 0 ? "https://" + c41034bu.mo65116a() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.f16460g : "https://" + c41034bu.mo65116a() + ":443";
        String file = this.f16458e.getFile();
        if (!TextUtils.isEmpty(file)) {
            str = file.startsWith("/") ? str + file : str + "/" + file;
        }
        file = this.f16458e.getRef();
        if (!TextUtils.isEmpty(file)) {
            str = str + "#" + file;
        }
        AppMethodBeat.m2505o(98660);
        return str;
    }

    /* renamed from: a */
    public final List<C41034bu> mo65129a(C46775cp c46775cp, boolean z, boolean z2) {
        List<C41034bu> list;
        int i = 3;
        int i2 = 0;
        AppMethodBeat.m2504i(98661);
        C41034bu c41034bu = new C41034bu(this.f16458e.getHost(), -1);
        c41034bu.mo65117a((byte) 3);
        ArrayList arrayList;
        Object list2;
        try {
            arrayList = new ArrayList();
            if (!z) {
                arrayList.add(c41034bu);
                c41034bu.f16441a = 1;
                list2 = arrayList;
            } else if (C31029ce.m49854i() || !this.f16455b || (z2 && !this.f16456c)) {
                for (int i3 = 0; i3 < this.f16457d; i3++) {
                    arrayList.add(c41034bu);
                }
                if (C31029ce.m49854i()) {
                    i = 2;
                } else if (this.f16455b) {
                    i = 4;
                }
                c41034bu.f16441a = i;
                list2 = arrayList;
            } else if (!z2 || VERSION.SDK_INT > 18) {
                C24360cc a = C46775cp.m88747a(this.f16458e.getHost());
                List<C41034bu> list3 = a.f4655c;
                this.f16460g = a.f4656d;
                this.f16454a = a.f4654b;
                list2 = list3;
            } else {
                for (i = 0; i < this.f16457d; i++) {
                    arrayList.add(c41034bu);
                }
                c41034bu.f16441a = 10;
                list2 = arrayList;
            }
        } catch (Exception e) {
            arrayList = new ArrayList();
            while (i2 < this.f16457d) {
                arrayList.add(c41034bu);
                i2++;
            }
            c41034bu.f16441a = 8;
            list2 = arrayList;
        }
        AppMethodBeat.m2505o(98661);
        return list2;
    }
}
