package com.tencent.mm.ay;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String fKU = "";
    public static String fKV = "";
    public String TEXT;
    public String TYPE;
    public bi cKd;
    public String fKW = "";
    public String fKX;
    public LinkedList<String> fKY = new LinkedList();
    public LinkedList<Integer> fKZ = new LinkedList();
    public LinkedList<Integer> fLa = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> fLb = new HashMap();

        public abstract a a(Map<String, String> map, bi biVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (fLb) {
                fLb.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, bi biVar) {
            if (map == null) {
                ab.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String bc = bo.bc((String) map.get(".sysmsg.$type"), "");
            synchronized (fLb) {
                a aVar = (a) fLb.get(bc.toLowerCase());
                if (aVar == null) {
                    ab.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", bc);
                    return null;
                }
                a a = aVar.a((Map) map, biVar);
                return a;
            }
        }
    }

    public interface b {
        void a(View view, bi biVar, a aVar, int i);
    }

    public abstract boolean Yt();

    public a(Map<String, String> map) {
        this.values = map;
    }

    public a(Map<String, String> map, bi biVar) {
        this.values = map;
        this.cKd = biVar;
    }

    public final boolean aip() {
        if (this.values == null || this.values.size() <= 0) {
            ab.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
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
        return Yt();
    }
}
