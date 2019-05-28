package com.tencent.tencentmap.mapsdk.p666a;

import android.os.Handler;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C37423c;
import com.tencent.map.lib.p822gl.JNICallback.C25721e;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24381c;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41050ft;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41066iu;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ch */
public class C24339ch implements C25721e, C41050ft {
    /* renamed from: a */
    C31000cw f4603a = null;
    /* renamed from: b */
    private C31061iz f4604b;
    /* renamed from: c */
    private C24326f f4605c = null;
    /* renamed from: d */
    private Handler f4606d = new Handler();
    /* renamed from: e */
    private boolean f4607e = false;

    /* renamed from: a */
    static /* synthetic */ void m37552a(C24339ch c24339ch, String str, String str2, String[] strArr, int i) {
        AppMethodBeat.m2504i(100936);
        c24339ch.m37553a(str, str2, strArr, i);
        AppMethodBeat.m2505o(100936);
    }

    public C24339ch(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100930);
        this.f4604b = c31061iz;
        if (!(c31061iz == null || c31061iz.mo75386b() == null)) {
            C8889f b = c31061iz.mo75386b();
            b.mo20174a((C41050ft) this);
            b.mo20168a((C25721e) this);
            this.f4605c = new C41066iu(this.f4604b);
        }
        AppMethodBeat.m2505o(100930);
    }

    /* renamed from: a */
    public boolean mo40470a() {
        return this.f4607e;
    }

    /* renamed from: z */
    public void mo29413z() {
        AppMethodBeat.m2504i(100931);
        if (this.f4604b == null || this.f4604b.mo75386b() == null) {
            AppMethodBeat.m2505o(100931);
            return;
        }
        C37423c d = this.f4604b.mo75386b().mo20211d(new GeoPoint());
        if (d == null) {
            AppMethodBeat.m2505o(100931);
            return;
        }
        final String str = d.f16072a;
        final String str2 = d.f16073b;
        final String[] strArr = d.f16075d;
        final int i = d.f16074c;
        this.f4606d.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(100929);
                C24339ch.m37552a(C24339ch.this, str, str2, strArr, i);
                AppMethodBeat.m2505o(100929);
            }
        });
        AppMethodBeat.m2505o(100931);
    }

    /* renamed from: a */
    private void m37553a(String str, String str2, String[] strArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(100932);
        if (this.f4604b == null || this.f4604b.mo75386b() == null) {
            AppMethodBeat.m2505o(100932);
            return;
        }
        C8889f b = this.f4604b.mo75386b();
        int c = b.mo20203c();
        if (str == null || strArr == null || strArr.length <= 0 || i < 0 || c < 16) {
            m37554c();
            if (this.f4607e) {
                this.f4607e = false;
                this.f4603a = null;
                if (this.f4605c != null) {
                    this.f4605c.onIndoorBuildingDeactivated();
                }
            }
            AppMethodBeat.m2505o(100932);
            return;
        }
        if (!(this.f4605c == null || this.f4607e)) {
            this.f4607e = true;
            this.f4605c.onIndoorBuildingFocused();
        }
        b.mo20222g(Math.min(this.f4604b.f14274i, 22));
        if (this.f4605c != null) {
            ArrayList arrayList = new ArrayList();
            c = strArr.length;
            while (i2 < c) {
                arrayList.add(new C36473cy(strArr[i2]));
                i2++;
            }
            try {
                if (this.f4603a != null && this.f4603a.mo50190a().equals(str) && this.f4603a.mo50193d() == i) {
                    AppMethodBeat.m2505o(100932);
                    return;
                }
            } catch (Exception e) {
            }
            this.f4603a = new C31000cw(str, str2, arrayList, i);
            this.f4605c.onIndoorLevelActivated(this.f4603a);
        }
        AppMethodBeat.m2505o(100932);
    }

    /* renamed from: a */
    public void mo29503a(C24381c c24381c) {
        AppMethodBeat.m2504i(100933);
        if (this.f4604b == null || this.f4604b.mo75386b() == null || this.f4604b.mo50411D() == null) {
            AppMethodBeat.m2505o(100933);
        } else if (this.f4607e) {
            this.f4604b.mo50411D().mo72032b(true);
            AppMethodBeat.m2505o(100933);
        } else {
            this.f4604b.mo50411D().mo72032b(false);
            m37554c();
            AppMethodBeat.m2505o(100933);
        }
    }

    /* renamed from: c */
    private void m37554c() {
        AppMethodBeat.m2504i(100934);
        if (this.f4604b == null || this.f4604b.mo75386b() == null || this.f4607e) {
            AppMethodBeat.m2505o(100934);
            return;
        }
        C8889f b = this.f4604b.mo75386b();
        int min = Math.min(20, this.f4604b.f14274i);
        if (b.mo20231j() < ((float) min)) {
            b.mo20222g(min);
        }
        AppMethodBeat.m2505o(100934);
    }

    /* renamed from: b */
    public void mo40471b() {
        AppMethodBeat.m2504i(100935);
        if (this.f4603a != null) {
            String a = this.f4603a.mo50190a();
            int d = this.f4603a.mo50193d();
            List c = this.f4603a.mo50192c();
            if (c == null || d >= c.size()) {
                AppMethodBeat.m2505o(100935);
                return;
            }
            String a2 = ((C36473cy) c.get(d)).mo57703a();
            if (!(StringUtil.isEmpty(a) || StringUtil.isEmpty(a2))) {
                this.f4604b.mo75386b().mo20181a(a, a2);
            }
        }
        AppMethodBeat.m2505o(100935);
    }
}
