package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.as */
public final class C46769as {
    /* renamed from: a */
    private int f18072a = 12;
    /* renamed from: b */
    private int f18073b = 60;
    /* renamed from: c */
    private int f18074c = 12;
    /* renamed from: d */
    private int f18075d = 60;
    /* renamed from: e */
    private int f18076e = 20;
    /* renamed from: f */
    private boolean f18077f = false;
    /* renamed from: g */
    private boolean f18078g = true;
    /* renamed from: h */
    private Set<String> f18079h = null;
    /* renamed from: i */
    private Map<String, Float> f18080i = null;
    /* renamed from: j */
    private boolean f18081j = false;
    /* renamed from: k */
    private boolean f18082k = false;
    /* renamed from: l */
    private boolean f18083l = false;

    /* renamed from: a */
    public final synchronized void mo75343a(Map<String, String> map) {
        AppMethodBeat.m2504i(98502);
        if (map != null) {
            try {
                int intValue;
                String str = (String) map.get("realNumUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 50) {
                        this.f18072a = intValue;
                    }
                }
                str = (String) map.get("realDelayUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue >= 10 && intValue <= 600) {
                        this.f18073b = intValue;
                    }
                }
                str = (String) map.get("comNumDB");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 50) {
                        this.f18074c = intValue;
                    }
                }
                str = (String) map.get("comDelayDB");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue >= 30 && intValue <= 600) {
                        this.f18075d = intValue;
                    }
                }
                str = (String) map.get("comNumUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 100) {
                        this.f18076e = intValue;
                    }
                }
                str = (String) map.get("heartOnOff");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f18078g = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f18078g = false;
                    }
                }
                str = (String) map.get("tidyEF");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f18082k = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f18082k = false;
                    }
                }
                str = (String) map.get("lauEveSim");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f18083l = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f18083l = false;
                    }
                }
                str = (String) map.get("comPollUp");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f18077f = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f18077f = false;
                    }
                }
                str = (String) map.get("accessTestOnOff");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        C16205ag.f3126b = true;
                    } else if (str.toLowerCase().equals("n")) {
                        C16205ag.f3126b = false;
                    }
                }
                str = (String) map.get("upAc");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f18081j = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f18081j = false;
                    }
                }
                map.get("appendXMeths");
                AppMethodBeat.m2505o(98502);
            } catch (Exception e) {
                C16205ag.m24684a(e);
            }
        }
        AppMethodBeat.m2505o(98502);
    }

    /* renamed from: a */
    public final synchronized int mo75342a() {
        return this.f18072a;
    }

    /* renamed from: b */
    public final synchronized int mo75346b() {
        return this.f18073b;
    }

    /* renamed from: c */
    public final synchronized int mo75349c() {
        return this.f18074c;
    }

    /* renamed from: d */
    public final synchronized int mo75350d() {
        return this.f18075d;
    }

    /* renamed from: e */
    public final synchronized int mo75351e() {
        return this.f18076e;
    }

    /* renamed from: f */
    public final boolean mo75352f() {
        return this.f18078g;
    }

    /* renamed from: a */
    public final synchronized void mo75344a(Set<String> set) {
        this.f18079h = set;
    }

    /* renamed from: a */
    public final synchronized boolean mo75345a(String str) {
        boolean z;
        AppMethodBeat.m2504i(98503);
        z = false;
        if (this.f18079h != null && this.f18079h.size() > 0) {
            z = this.f18079h.contains(str);
        }
        AppMethodBeat.m2505o(98503);
        return z;
    }

    /* renamed from: b */
    public final synchronized void mo75347b(Set<String> set) {
        AppMethodBeat.m2504i(98504);
        if (this.f18080i == null) {
            this.f18080i = new HashMap();
        }
        for (String split : set) {
            String[] split2 = split.split(",");
            if (split2.length == 3) {
                try {
                    this.f18080i.put(split2[0].toLowerCase(), Float.valueOf(Float.valueOf(split2[1]).floatValue() / Float.valueOf(split2[2]).floatValue()));
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(98504);
    }

    /* renamed from: b */
    public final synchronized boolean mo75348b(String str) {
        boolean z;
        AppMethodBeat.m2504i(98505);
        if (this.f18080i == null || this.f18080i.get(str) == null) {
            AppMethodBeat.m2505o(98505);
            z = true;
        } else {
            if (new Random().nextInt(1000) + 1 > ((int) (((Float) this.f18080i.get(str.toLowerCase())).floatValue() * 1000.0f))) {
                z = false;
            } else {
                z = true;
            }
            AppMethodBeat.m2505o(98505);
        }
        return z;
    }

    /* renamed from: g */
    public final boolean mo75353g() {
        return this.f18077f;
    }

    /* renamed from: h */
    public final boolean mo75354h() {
        return this.f18082k;
    }

    /* renamed from: i */
    public final boolean mo75355i() {
        return this.f18083l;
    }

    /* renamed from: j */
    public final boolean mo75356j() {
        return this.f18081j;
    }
}
