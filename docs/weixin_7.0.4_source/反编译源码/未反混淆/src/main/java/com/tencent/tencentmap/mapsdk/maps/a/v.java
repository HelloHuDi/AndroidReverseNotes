package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class v {
    private static v a = null;
    private String b;
    private int c;
    private int d;
    private SparseArray<a> e;
    private Map<String, String> f;
    private byte g;
    private byte h;
    private String i;
    private String j;
    private String k;

    public static class a {
        private final int a;
        private boolean b = false;
        private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
        private String d = "http://jrlt.beacon.qq.com/analytics/upload";
        private Map<String, String> e = null;
        private Set<String> f = null;
        private Set<String> g = null;

        public a(int i) {
            this.a = i;
        }

        public final boolean a() {
            return this.b;
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final String b() {
            if (ag.b) {
                return this.d;
            }
            return this.c;
        }

        public final void a(String str) {
            this.c = str;
        }

        public final Map<String, String> c() {
            return this.e;
        }

        public final void a(Map<String, String> map) {
            this.e = map;
        }

        public final Set<String> d() {
            return this.f;
        }

        public final void a(Set<String> set) {
            this.f = set;
        }

        public final int e() {
            return this.a;
        }

        public final Set<String> f() {
            return this.g;
        }

        public final void b(Set<String> set) {
            this.g = set;
        }
    }

    private v() {
        AppMethodBeat.i(100562);
        this.b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
        this.c = v2helper.VOIP_ENC_HEIGHT_LV1;
        this.d = 100;
        this.e = null;
        this.f = null;
        this.g = (byte) 3;
        this.h = (byte) 2;
        this.i = "";
        this.j = "";
        this.k = "";
        this.e = new SparseArray(3);
        this.e.put(1, new a(1));
        this.e.put(2, new a(2));
        this.e.put(3, new a(3));
        AppMethodBeat.o(100562);
    }

    public static v a() {
        AppMethodBeat.i(100563);
        if (a == null) {
            synchronized (v.class) {
                try {
                    if (a == null) {
                        a = new v();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(100563);
                }
            }
        }
        v vVar = a;
        AppMethodBeat.o(100563);
        return vVar;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int c() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final Map<String, String> d() {
        return this.f;
    }

    public final void a(Map<String, String> map) {
        this.f = map;
    }

    public final synchronized SparseArray<a> e() {
        SparseArray<a> a;
        AppMethodBeat.i(100564);
        if (this.e != null) {
            ah ahVar = new ah();
            a = ah.a(this.e);
            AppMethodBeat.o(100564);
        } else {
            a = null;
            AppMethodBeat.o(100564);
        }
        return a;
    }

    public final synchronized a b(int i) {
        a aVar;
        AppMethodBeat.i(100565);
        if (this.e != null) {
            aVar = (a) this.e.get(i);
            AppMethodBeat.o(100565);
        } else {
            aVar = null;
            AppMethodBeat.o(100565);
        }
        return aVar;
    }

    public final int f() {
        int intValue;
        AppMethodBeat.i(100566);
        if (this.f != null) {
            String str = (String) this.f.get("maxStrategyQueryOneDay");
            if (!(str == null || str.trim().equals(""))) {
                int i = this.d;
                try {
                    intValue = Integer.valueOf(str).intValue();
                } catch (Exception e) {
                    intValue = i;
                }
                AppMethodBeat.o(100566);
                return intValue;
            }
        }
        intValue = this.d;
        AppMethodBeat.o(100566);
        return intValue;
    }

    public final synchronized boolean g() {
        boolean z;
        AppMethodBeat.i(100567);
        if (this.f != null) {
            String str = (String) this.f.get("zeroPeak");
            if (str != null && VideoMaterialUtil.CRAZYFACE_Y.equalsIgnoreCase(str) && Calendar.getInstance().get(11) == 0) {
                z = true;
                AppMethodBeat.o(100567);
            }
        }
        z = false;
        AppMethodBeat.o(100567);
        return z;
    }

    public final synchronized byte h() {
        return this.g;
    }

    public final synchronized byte i() {
        return this.h;
    }

    public final synchronized String j() {
        return this.i;
    }

    private synchronized void b(String str) {
        AppMethodBeat.i(100568);
        this.j = str;
        this.i = Base64.encodeToString(e.a(str), 2);
        AppMethodBeat.o(100568);
    }

    public final synchronized String k() {
        return this.j;
    }

    private synchronized void c(String str) {
        this.k = str;
    }

    public final synchronized String l() {
        return this.k;
    }

    public final synchronized void a(final Context context, final String str, final String str2) {
        AppMethodBeat.i(100569);
        this.k = str;
        b.a().a(new Runnable() {
            public final void run() {
                long time;
                AppMethodBeat.i(100561);
                Object[] objArr = new Object[2];
                objArr[0] = str;
                try {
                    time = e.d(str2).getTime() / 1000;
                } catch (Exception e) {
                    time = 0;
                }
                if (time == 0) {
                    time = (new Date().getTime() / 1000) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                }
                objArr[1] = Long.valueOf(time);
                Context context = context;
                v.this.getClass();
                e.a(context, "sid", objArr);
                AppMethodBeat.o(100561);
            }
        });
        AppMethodBeat.o(100569);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(Context context) {
        AppMethodBeat.i(100570);
        Object[] a = e.a(context, "sid");
        if (a != null && a.length == 3) {
            long longValue;
            long time = new Date().getTime() / 1000;
            try {
                longValue = ((Long) a[2]).longValue();
            } catch (Exception e) {
                longValue = 0;
            }
            if (longValue > time) {
                c((String) a[1]);
            }
        }
        b(e.k(context));
        AppMethodBeat.o(100570);
    }
}
