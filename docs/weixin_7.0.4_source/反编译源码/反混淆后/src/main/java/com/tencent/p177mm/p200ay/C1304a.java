package com.tencent.p177mm.p200ay;

import android.view.View;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ay.a */
public abstract class C1304a {
    public static String fKU = "";
    public static String fKV = "";
    public String TEXT;
    public String TYPE;
    public C7620bi cKd;
    public String fKW = "";
    public String fKX;
    public LinkedList<String> fKY = new LinkedList();
    public LinkedList<Integer> fKZ = new LinkedList();
    public LinkedList<Integer> fLa = new LinkedList();
    public Map<String, String> values;

    /* renamed from: com.tencent.mm.ay.a$a */
    public static abstract class C1302a {
        private static HashMap<String, C1302a> fLb = new HashMap();

        /* renamed from: a */
        public abstract C1304a mo4612a(Map<String, String> map, C7620bi c7620bi);

        /* renamed from: a */
        public static void m2777a(String str, C1302a c1302a) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(c1302a);
            synchronized (fLb) {
                fLb.put(str.toLowerCase(), c1302a);
            }
        }

        /* renamed from: b */
        public static C1304a m2778b(Map<String, String> map, C7620bi c7620bi) {
            if (map == null) {
                C4990ab.m7412e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String bc = C5046bo.m7532bc((String) map.get(".sysmsg.$type"), "");
            synchronized (fLb) {
                C1302a c1302a = (C1302a) fLb.get(bc.toLowerCase());
                if (c1302a == null) {
                    C4990ab.m7421w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", bc);
                    return null;
                }
                C1304a a = c1302a.mo4612a((Map) map, c7620bi);
                return a;
            }
        }
    }

    /* renamed from: com.tencent.mm.ay.a$b */
    public interface C1303b {
        /* renamed from: a */
        void mo4613a(View view, C7620bi c7620bi, C1304a c1304a, int i);
    }

    /* renamed from: Yt */
    public abstract boolean mo4614Yt();

    public C1304a(Map<String, String> map) {
        this.values = map;
    }

    public C1304a(Map<String, String> map, C7620bi c7620bi) {
        this.values = map;
        this.cKd = c7620bi;
    }

    public final boolean aip() {
        if (this.values == null || this.values.size() <= 0) {
            C4990ab.m7412e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.$type")) {
            this.TYPE = (String) this.values.get(".sysmsg.$type");
        }
        fKU = ".sysmsg." + this.TYPE + ".text";
        if (this.values.containsKey(fKU)) {
            this.TEXT = (String) this.values.get(fKU);
        }
        fKV = ".sysmsg." + this.TYPE + ".link.scene";
        if (this.values.containsKey(fKV)) {
            this.fKX = (String) this.values.get(fKV);
        }
        return mo4614Yt();
    }
}
