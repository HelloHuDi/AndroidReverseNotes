package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class cr {
    public String a;
    private boolean b;
    private boolean c;
    private int d;
    private URL e;
    private String f;
    private int g;

    public cr(URL url, String str) {
        boolean z = false;
        AppMethodBeat.i(98659);
        this.b = a.a("direct_access_use_schedule", 0, 1, 1) == 1;
        if (a.a("direct_https_use_sche", 0, 1, 1) == 1) {
            z = true;
        }
        this.c = z;
        this.d = a.a("direct_access_domain_try_times", 1, 8, 2);
        this.a = "";
        this.e = url;
        this.f = str;
        AppMethodBeat.o(98659);
    }

    public final String a(bu buVar) {
        AppMethodBeat.i(98660);
        String str;
        if (buVar.e()) {
            str = this.f;
            AppMethodBeat.o(98660);
            return str;
        }
        str = !this.e.getProtocol().startsWith("https") ? "http://" + buVar.a() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + buVar.c() : this.g != 0 ? "https://" + buVar.a() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.g : "https://" + buVar.a() + ":443";
        String file = this.e.getFile();
        if (!TextUtils.isEmpty(file)) {
            str = file.startsWith("/") ? str + file : str + "/" + file;
        }
        file = this.e.getRef();
        if (!TextUtils.isEmpty(file)) {
            str = str + "#" + file;
        }
        AppMethodBeat.o(98660);
        return str;
    }

    public final List<bu> a(cp cpVar, boolean z, boolean z2) {
        List<bu> list;
        int i = 3;
        int i2 = 0;
        AppMethodBeat.i(98661);
        bu buVar = new bu(this.e.getHost(), -1);
        buVar.a((byte) 3);
        ArrayList arrayList;
        Object list2;
        try {
            arrayList = new ArrayList();
            if (!z) {
                arrayList.add(buVar);
                buVar.a = 1;
                list2 = arrayList;
            } else if (ce.i() || !this.b || (z2 && !this.c)) {
                for (int i3 = 0; i3 < this.d; i3++) {
                    arrayList.add(buVar);
                }
                if (ce.i()) {
                    i = 2;
                } else if (this.b) {
                    i = 4;
                }
                buVar.a = i;
                list2 = arrayList;
            } else if (!z2 || VERSION.SDK_INT > 18) {
                cc a = cp.a(this.e.getHost());
                List<bu> list3 = a.c;
                this.g = a.d;
                this.a = a.b;
                list2 = list3;
            } else {
                for (i = 0; i < this.d; i++) {
                    arrayList.add(buVar);
                }
                buVar.a = 10;
                list2 = arrayList;
            }
        } catch (Exception e) {
            arrayList = new ArrayList();
            while (i2 < this.d) {
                arrayList.add(buVar);
                i2++;
            }
            buVar.a = 8;
            list2 = arrayList;
        }
        AppMethodBeat.o(98661);
        return list2;
    }
}
