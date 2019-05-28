package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: c.t.m.c.j */
public class C31903j implements Runnable {
    /* renamed from: a */
    private Context f14660a;
    /* renamed from: b */
    private List<C44972a> f14661b = null;
    /* renamed from: c */
    private boolean f14662c = false;
    /* renamed from: d */
    private List<C44972a> f14663d = null;
    /* renamed from: e */
    private C44973c f14664e = null;
    /* renamed from: f */
    private boolean f14665f = false;

    public C31903j(Context context, List<C44972a> list, boolean z) {
        AppMethodBeat.m2504i(136367);
        this.f14660a = context;
        this.f14665f = z;
        this.f14661b = new ArrayList();
        this.f14661b.addAll(list);
        this.f14664e = new C44973c(this.f14660a);
        AppMethodBeat.m2505o(136367);
    }

    /* renamed from: a */
    private boolean m51764a(String str) {
        AppMethodBeat.m2504i(136368);
        String c = C37150q.m62226c(C17501m.m27326b(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
        if (c == null) {
            AppMethodBeat.m2505o(136368);
            return true;
        }
        this.f14663d = C37150q.m62222b(c);
        boolean z = false;
        List b = C37150q.m62222b(C37150q.m62221b(this.f14660a, "__bad_dex_info__", "preference_default"));
        if (!b.isEmpty()) {
            z = C0731l.m1683a(b, this.f14663d);
        }
        boolean a = m51765a(this.f14661b, this.f14663d);
        C25383e.m40076a(this.f14660a).mo42397a("DRG", "need and samebad:" + a + "," + z);
        if (!(a || z)) {
            C25383e.m40076a(this.f14660a).mo42397a("DRG", "to download:".concat(String.valueOf(c)));
            this.f14664e.mo72252a(this.f14663d);
        }
        AppMethodBeat.m2505o(136368);
        return a;
    }

    /* renamed from: a */
    private boolean m51765a(List<C44972a> list, List<C44972a> list2) {
        AppMethodBeat.m2504i(136369);
        boolean z = true;
        for (C44972a c44972a : list) {
            Object obj;
            boolean z2;
            for (C44972a c44972a2 : list2) {
                if (!c44972a2.f17711c.contains(".dex")) {
                    c44972a2.f17711c += ".dex";
                }
                if (c44972a.f17711c.equals(c44972a2.f17711c) && c44972a.f17712d == c44972a2.f17712d && c44972a.f17713e.equals(c44972a2.f17713e)) {
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
        AppMethodBeat.m2505o(136369);
        return z;
    }

    /* renamed from: a */
    private boolean m51763a() {
        AppMethodBeat.m2504i(136370);
        String b = m51766b();
        if (b == null) {
            AppMethodBeat.m2505o(136370);
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
                byte[] a = C0733p.m1691a("https://cc.map.qq.com?desc_c", bytes);
                if (a != null) {
                    String str = new String(a);
                    C25383e.m40076a(this.f14660a).mo42397a("DRG", "response suc,try:".concat(String.valueOf(i2)));
                    boolean a2 = m51764a(str);
                    AppMethodBeat.m2505o(136370);
                    return a2;
                }
                C37150q.m62209a(10000);
                i = i2;
            }
        }
        AppMethodBeat.m2505o(136370);
        return false;
    }

    /* renamed from: b */
    private String m51766b() {
        AppMethodBeat.m2504i(136371);
        JSONObject jSONObject = new JSONObject();
        String str = this.f14660a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        try {
            jSONObject.put("appkey", C37150q.m62230d(this.f14660a));
            jSONObject.put("appversion", C37150q.m62205a(this.f14660a));
            jSONObject.put("imei", C37150q.m62232e(this.f14660a));
            jSONObject.put("coverSDKver", C37149i.f15840a);
            jSONObject.put("model", C37150q.m62218b() + "_" + C37150q.m62204a());
            jSONObject.put("APILevel", C37150q.m62225c());
            JSONArray jSONArray = new JSONArray();
            if (this.f14661b != null) {
                for (C44972a c44972a : this.f14661b) {
                    if (c44972a != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", c44972a.f17709a);
                        jSONObject2.put("compVer", c44972a.f17710b);
                        jSONObject2.put("size", c44972a.f17712d);
                        jSONObject2.put("md5", C37150q.m62206a(new File(str, c44972a.f17711c)));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
            String jSONObject3 = jSONObject.toString();
            C25383e.m40076a(this.f14660a).mo42397a("DRG", "req:".concat(String.valueOf(jSONObject3)));
            jSONObject3 = C17501m.m27321a(jSONObject3, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
            AppMethodBeat.m2505o(136371);
            return jSONObject3;
        } catch (Exception e) {
            C25383e.m40076a(this.f14660a).mo42397a("DRG", "reqDerror:" + e.toString());
            AppMethodBeat.m2505o(136371);
            return null;
        }
    }

    public void run() {
        AppMethodBeat.m2504i(136372);
        if (!this.f14665f) {
            try {
                Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            } catch (Throwable th) {
            }
        }
        C25383e.m40076a(this.f14660a).mo42397a("DRG", "t:" + m51767c() + ",i:" + this.f14665f);
        m51763a();
        C37150q.m62211a(this.f14660a, "__last_check_update_time__", Long.valueOf(System.currentTimeMillis()));
        C25383e.m40076a(this.f14660a).mo42400c();
        AppMethodBeat.m2505o(136372);
    }

    /* renamed from: c */
    private boolean m51767c() {
        AppMethodBeat.m2504i(136373);
        if (System.currentTimeMillis() - C37150q.m62217b(this.f14660a, "__last_check_update_time__", Long.valueOf(0)).longValue() > 3600000) {
            AppMethodBeat.m2505o(136373);
            return true;
        }
        AppMethodBeat.m2505o(136373);
        return false;
    }
}
