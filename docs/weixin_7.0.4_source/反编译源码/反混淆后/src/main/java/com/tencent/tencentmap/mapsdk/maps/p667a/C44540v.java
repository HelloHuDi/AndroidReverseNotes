package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.v */
public class C44540v {
    /* renamed from: a */
    private static C44540v f17501a = null;
    /* renamed from: b */
    private String f17502b;
    /* renamed from: c */
    private int f17503c;
    /* renamed from: d */
    private int f17504d;
    /* renamed from: e */
    private SparseArray<C44541a> f17505e;
    /* renamed from: f */
    private Map<String, String> f17506f;
    /* renamed from: g */
    private byte f17507g;
    /* renamed from: h */
    private byte f17508h;
    /* renamed from: i */
    private String f17509i;
    /* renamed from: j */
    private String f17510j;
    /* renamed from: k */
    private String f17511k;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.v$a */
    public static class C44541a {
        /* renamed from: a */
        private final int f17512a;
        /* renamed from: b */
        private boolean f17513b = false;
        /* renamed from: c */
        private String f17514c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
        /* renamed from: d */
        private String f17515d = "http://jrlt.beacon.qq.com/analytics/upload";
        /* renamed from: e */
        private Map<String, String> f17516e = null;
        /* renamed from: f */
        private Set<String> f17517f = null;
        /* renamed from: g */
        private Set<String> f17518g = null;

        public C44541a(int i) {
            this.f17512a = i;
        }

        /* renamed from: a */
        public final boolean mo70954a() {
            return this.f17513b;
        }

        /* renamed from: a */
        public final void mo70953a(boolean z) {
            this.f17513b = z;
        }

        /* renamed from: b */
        public final String mo70955b() {
            if (C16205ag.f3126b) {
                return this.f17515d;
            }
            return this.f17514c;
        }

        /* renamed from: a */
        public final void mo70950a(String str) {
            this.f17514c = str;
        }

        /* renamed from: c */
        public final Map<String, String> mo70957c() {
            return this.f17516e;
        }

        /* renamed from: a */
        public final void mo70951a(Map<String, String> map) {
            this.f17516e = map;
        }

        /* renamed from: d */
        public final Set<String> mo70958d() {
            return this.f17517f;
        }

        /* renamed from: a */
        public final void mo70952a(Set<String> set) {
            this.f17517f = set;
        }

        /* renamed from: e */
        public final int mo70959e() {
            return this.f17512a;
        }

        /* renamed from: f */
        public final Set<String> mo70960f() {
            return this.f17518g;
        }

        /* renamed from: b */
        public final void mo70956b(Set<String> set) {
            this.f17518g = set;
        }
    }

    private C44540v() {
        AppMethodBeat.m2504i(100562);
        this.f17502b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
        this.f17503c = v2helper.VOIP_ENC_HEIGHT_LV1;
        this.f17504d = 100;
        this.f17505e = null;
        this.f17506f = null;
        this.f17507g = (byte) 3;
        this.f17508h = (byte) 2;
        this.f17509i = "";
        this.f17510j = "";
        this.f17511k = "";
        this.f17505e = new SparseArray(3);
        this.f17505e.put(1, new C44541a(1));
        this.f17505e.put(2, new C44541a(2));
        this.f17505e.put(3, new C44541a(3));
        AppMethodBeat.m2505o(100562);
    }

    /* renamed from: a */
    public static C44540v m80860a() {
        AppMethodBeat.m2504i(100563);
        if (f17501a == null) {
            synchronized (C44540v.class) {
                try {
                    if (f17501a == null) {
                        f17501a = new C44540v();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(100563);
                }
            }
        }
        C44540v c44540v = f17501a;
        AppMethodBeat.m2505o(100563);
        return c44540v;
    }

    /* renamed from: b */
    public final String mo70939b() {
        return this.f17502b;
    }

    /* renamed from: a */
    public final void mo70936a(String str) {
        this.f17502b = str;
    }

    /* renamed from: c */
    public final int mo70940c() {
        return this.f17503c;
    }

    /* renamed from: a */
    public final void mo70933a(int i) {
        this.f17503c = i;
    }

    /* renamed from: d */
    public final Map<String, String> mo70941d() {
        return this.f17506f;
    }

    /* renamed from: a */
    public final void mo70937a(Map<String, String> map) {
        this.f17506f = map;
    }

    /* renamed from: e */
    public final synchronized SparseArray<C44541a> mo70942e() {
        SparseArray<C44541a> a;
        AppMethodBeat.m2504i(100564);
        if (this.f17505e != null) {
            C36483ah c36483ah = new C36483ah();
            a = C36483ah.m60324a(this.f17505e);
            AppMethodBeat.m2505o(100564);
        } else {
            a = null;
            AppMethodBeat.m2505o(100564);
        }
        return a;
    }

    /* renamed from: b */
    public final synchronized C44541a mo70938b(int i) {
        C44541a c44541a;
        AppMethodBeat.m2504i(100565);
        if (this.f17505e != null) {
            c44541a = (C44541a) this.f17505e.get(i);
            AppMethodBeat.m2505o(100565);
        } else {
            c44541a = null;
            AppMethodBeat.m2505o(100565);
        }
        return c44541a;
    }

    /* renamed from: f */
    public final int mo70943f() {
        int intValue;
        AppMethodBeat.m2504i(100566);
        if (this.f17506f != null) {
            String str = (String) this.f17506f.get("maxStrategyQueryOneDay");
            if (!(str == null || str.trim().equals(""))) {
                int i = this.f17504d;
                try {
                    intValue = Integer.valueOf(str).intValue();
                } catch (Exception e) {
                    intValue = i;
                }
                AppMethodBeat.m2505o(100566);
                return intValue;
            }
        }
        intValue = this.f17504d;
        AppMethodBeat.m2505o(100566);
        return intValue;
    }

    /* renamed from: g */
    public final synchronized boolean mo70944g() {
        boolean z;
        AppMethodBeat.m2504i(100567);
        if (this.f17506f != null) {
            String str = (String) this.f17506f.get("zeroPeak");
            if (str != null && VideoMaterialUtil.CRAZYFACE_Y.equalsIgnoreCase(str) && Calendar.getInstance().get(11) == 0) {
                z = true;
                AppMethodBeat.m2505o(100567);
            }
        }
        z = false;
        AppMethodBeat.m2505o(100567);
        return z;
    }

    /* renamed from: h */
    public final synchronized byte mo70945h() {
        return this.f17507g;
    }

    /* renamed from: i */
    public final synchronized byte mo70946i() {
        return this.f17508h;
    }

    /* renamed from: j */
    public final synchronized String mo70947j() {
        return this.f17509i;
    }

    /* renamed from: b */
    private synchronized void m80861b(String str) {
        AppMethodBeat.m2504i(100568);
        this.f17510j = str;
        this.f17509i = Base64.encodeToString(C24349e.m37584a(str), 2);
        AppMethodBeat.m2505o(100568);
    }

    /* renamed from: k */
    public final synchronized String mo70948k() {
        return this.f17510j;
    }

    /* renamed from: c */
    private synchronized void m80862c(String str) {
        this.f17511k = str;
    }

    /* renamed from: l */
    public final synchronized String mo70949l() {
        return this.f17511k;
    }

    /* renamed from: a */
    public final synchronized void mo70935a(final Context context, final String str, final String str2) {
        AppMethodBeat.m2504i(100569);
        this.f17511k = str;
        C46752b.m88622a().mo12298a(new Runnable() {
            public final void run() {
                long time;
                AppMethodBeat.m2504i(100561);
                Object[] objArr = new Object[2];
                objArr[0] = str;
                try {
                    time = C24349e.m37606d(str2).getTime() / 1000;
                } catch (Exception e) {
                    time = 0;
                }
                if (time == 0) {
                    time = (new Date().getTime() / 1000) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                }
                objArr[1] = Long.valueOf(time);
                Context context = context;
                C44540v.this.getClass();
                C24349e.m37582a(context, "sid", objArr);
                AppMethodBeat.m2505o(100561);
            }
        });
        AppMethodBeat.m2505o(100569);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo70934a(Context context) {
        AppMethodBeat.m2504i(100570);
        Object[] a = C24349e.m37591a(context, "sid");
        if (a != null && a.length == 3) {
            long longValue;
            long time = new Date().getTime() / 1000;
            try {
                longValue = ((Long) a[2]).longValue();
            } catch (Exception e) {
                longValue = 0;
            }
            if (longValue > time) {
                m80862c((String) a[1]);
            }
        }
        m80861b(C24349e.m37619k(context));
        AppMethodBeat.m2505o(100570);
    }
}
