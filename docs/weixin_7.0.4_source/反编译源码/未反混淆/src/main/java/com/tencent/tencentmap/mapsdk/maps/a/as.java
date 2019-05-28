package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class as {
    private int a = 12;
    private int b = 60;
    private int c = 12;
    private int d = 60;
    private int e = 20;
    private boolean f = false;
    private boolean g = true;
    private Set<String> h = null;
    private Map<String, Float> i = null;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    public final synchronized void a(Map<String, String> map) {
        AppMethodBeat.i(98502);
        if (map != null) {
            try {
                int intValue;
                String str = (String) map.get("realNumUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 50) {
                        this.a = intValue;
                    }
                }
                str = (String) map.get("realDelayUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue >= 10 && intValue <= 600) {
                        this.b = intValue;
                    }
                }
                str = (String) map.get("comNumDB");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 50) {
                        this.c = intValue;
                    }
                }
                str = (String) map.get("comDelayDB");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue >= 30 && intValue <= 600) {
                        this.d = intValue;
                    }
                }
                str = (String) map.get("comNumUp");
                if (str != null) {
                    intValue = Integer.valueOf(str).intValue();
                    if (intValue > 0 && intValue <= 100) {
                        this.e = intValue;
                    }
                }
                str = (String) map.get("heartOnOff");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.g = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.g = false;
                    }
                }
                str = (String) map.get("tidyEF");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.k = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.k = false;
                    }
                }
                str = (String) map.get("lauEveSim");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.l = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.l = false;
                    }
                }
                str = (String) map.get("comPollUp");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.f = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.f = false;
                    }
                }
                str = (String) map.get("accessTestOnOff");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        ag.b = true;
                    } else if (str.toLowerCase().equals("n")) {
                        ag.b = false;
                    }
                }
                str = (String) map.get("upAc");
                if (str != null) {
                    if (str.toLowerCase().equals(VideoMaterialUtil.CRAZYFACE_Y)) {
                        this.j = true;
                    } else if (str.toLowerCase().equals("n")) {
                        this.j = false;
                    }
                }
                map.get("appendXMeths");
                AppMethodBeat.o(98502);
            } catch (Exception e) {
                ag.a(e);
            }
        }
        AppMethodBeat.o(98502);
    }

    public final synchronized int a() {
        return this.a;
    }

    public final synchronized int b() {
        return this.b;
    }

    public final synchronized int c() {
        return this.c;
    }

    public final synchronized int d() {
        return this.d;
    }

    public final synchronized int e() {
        return this.e;
    }

    public final boolean f() {
        return this.g;
    }

    public final synchronized void a(Set<String> set) {
        this.h = set;
    }

    public final synchronized boolean a(String str) {
        boolean z;
        AppMethodBeat.i(98503);
        z = false;
        if (this.h != null && this.h.size() > 0) {
            z = this.h.contains(str);
        }
        AppMethodBeat.o(98503);
        return z;
    }

    public final synchronized void b(Set<String> set) {
        AppMethodBeat.i(98504);
        if (this.i == null) {
            this.i = new HashMap();
        }
        for (String split : set) {
            String[] split2 = split.split(",");
            if (split2.length == 3) {
                try {
                    this.i.put(split2[0].toLowerCase(), Float.valueOf(Float.valueOf(split2[1]).floatValue() / Float.valueOf(split2[2]).floatValue()));
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(98504);
    }

    public final synchronized boolean b(String str) {
        boolean z;
        AppMethodBeat.i(98505);
        if (this.i == null || this.i.get(str) == null) {
            AppMethodBeat.o(98505);
            z = true;
        } else {
            if (new Random().nextInt(1000) + 1 > ((int) (((Float) this.i.get(str.toLowerCase())).floatValue() * 1000.0f))) {
                z = false;
            } else {
                z = true;
            }
            AppMethodBeat.o(98505);
        }
        return z;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.k;
    }

    public final boolean i() {
        return this.l;
    }

    public final boolean j() {
        return this.j;
    }
}
