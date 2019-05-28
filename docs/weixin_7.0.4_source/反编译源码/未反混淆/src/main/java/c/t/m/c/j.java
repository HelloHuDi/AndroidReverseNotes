package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j implements Runnable {
    private Context a;
    private List<a> b = null;
    private boolean c = false;
    private List<a> d = null;
    private c e = null;
    private boolean f = false;

    public j(Context context, List<a> list, boolean z) {
        AppMethodBeat.i(136367);
        this.a = context;
        this.f = z;
        this.b = new ArrayList();
        this.b.addAll(list);
        this.e = new c(this.a);
        AppMethodBeat.o(136367);
    }

    private boolean a(String str) {
        AppMethodBeat.i(136368);
        String c = q.c(m.b(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
        if (c == null) {
            AppMethodBeat.o(136368);
            return true;
        }
        this.d = q.b(c);
        boolean z = false;
        List b = q.b(q.b(this.a, "__bad_dex_info__", "preference_default"));
        if (!b.isEmpty()) {
            z = l.a(b, this.d);
        }
        boolean a = a(this.b, this.d);
        e.a(this.a).a("DRG", "need and samebad:" + a + "," + z);
        if (!(a || z)) {
            e.a(this.a).a("DRG", "to download:".concat(String.valueOf(c)));
            this.e.a(this.d);
        }
        AppMethodBeat.o(136368);
        return a;
    }

    private boolean a(List<a> list, List<a> list2) {
        AppMethodBeat.i(136369);
        boolean z = true;
        for (a aVar : list) {
            Object obj;
            boolean z2;
            for (a aVar2 : list2) {
                if (!aVar2.c.contains(".dex")) {
                    aVar2.c += ".dex";
                }
                if (aVar.c.equals(aVar2.c) && aVar.d == aVar2.d && aVar.e.equals(aVar2.e)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                z2 = false;
            } else {
                z2 = z;
            }
            z = z2;
        }
        AppMethodBeat.o(136369);
        return z;
    }

    private boolean a() {
        AppMethodBeat.i(136370);
        String b = b();
        if (b == null) {
            AppMethodBeat.o(136370);
            return false;
        }
        byte[] bytes = b.getBytes();
        if (bytes != null) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 3) {
                    break;
                }
                byte[] a = p.a("https://cc.map.qq.com?desc_c", bytes);
                if (a != null) {
                    String str = new String(a);
                    e.a(this.a).a("DRG", "response suc,try:".concat(String.valueOf(i2)));
                    boolean a2 = a(str);
                    AppMethodBeat.o(136370);
                    return a2;
                }
                q.a(10000);
                i = i2;
            }
        }
        AppMethodBeat.o(136370);
        return false;
    }

    private String b() {
        AppMethodBeat.i(136371);
        JSONObject jSONObject = new JSONObject();
        String str = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        try {
            jSONObject.put("appkey", q.d(this.a));
            jSONObject.put("appversion", q.a(this.a));
            jSONObject.put("imei", q.e(this.a));
            jSONObject.put("coverSDKver", i.a);
            jSONObject.put("model", q.b() + "_" + q.a());
            jSONObject.put("APILevel", q.c());
            JSONArray jSONArray = new JSONArray();
            if (this.b != null) {
                for (a aVar : this.b) {
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", aVar.a);
                        jSONObject2.put("compVer", aVar.b);
                        jSONObject2.put("size", aVar.d);
                        jSONObject2.put("md5", q.a(new File(str, aVar.c)));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
            String jSONObject3 = jSONObject.toString();
            e.a(this.a).a("DRG", "req:".concat(String.valueOf(jSONObject3)));
            jSONObject3 = m.a(jSONObject3, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
            AppMethodBeat.o(136371);
            return jSONObject3;
        } catch (Exception e) {
            e.a(this.a).a("DRG", "reqDerror:" + e.toString());
            AppMethodBeat.o(136371);
            return null;
        }
    }

    public void run() {
        AppMethodBeat.i(136372);
        if (!this.f) {
            try {
                Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            } catch (Throwable th) {
            }
        }
        e.a(this.a).a("DRG", "t:" + c() + ",i:" + this.f);
        a();
        q.a(this.a, "__last_check_update_time__", Long.valueOf(System.currentTimeMillis()));
        e.a(this.a).c();
        AppMethodBeat.o(136372);
    }

    private boolean c() {
        AppMethodBeat.i(136373);
        if (System.currentTimeMillis() - q.b(this.a, "__last_check_update_time__", Long.valueOf(0)).longValue() > 3600000) {
            AppMethodBeat.o(136373);
            return true;
        }
        AppMethodBeat.o(136373);
        return false;
    }
}
