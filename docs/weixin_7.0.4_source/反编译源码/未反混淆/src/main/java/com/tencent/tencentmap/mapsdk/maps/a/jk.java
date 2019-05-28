package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ak;
import com.tencent.tencentmap.mapsdk.a.ar;
import com.tencent.tencentmap.mapsdk.a.bi;
import com.tencent.tencentmap.mapsdk.a.o;
import com.tencent.tencentmap.mapsdk.a.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class jk implements com.tencent.tencentmap.mapsdk.maps.a.jm.a {
    private Context a;
    private bi b;
    private ls c;
    private q d;
    private jj e;
    private List<AsyncTask> f = new ArrayList();
    private jo g;

    public interface a {
        void a(Bitmap bitmap, int i, int i2);
    }

    public jk(ar arVar, ak akVar) {
        AppMethodBeat.i(100049);
        this.a = arVar.m();
        this.c = arVar.l().o();
        this.b = arVar.a();
        this.d = arVar.b();
        this.e = arVar.c();
        String str = "";
        String str2 = "";
        if (akVar != null) {
            if (!StringUtil.isEmpty(akVar.h())) {
                str = akVar.h().trim();
            }
            if (!StringUtil.isEmpty(akVar.g())) {
                str2 = akVar.g().trim();
            }
        }
        this.g = new jo(this.a, arVar, str);
        this.f.add(new jl(this.b.a, this, str, str2));
        this.f.add(new jm(this.a, this));
        AppMethodBeat.o(100049);
    }

    public void a(a aVar, ak akVar) {
        AppMethodBeat.i(100050);
        this.b.a(aVar, akVar);
        AppMethodBeat.o(100050);
    }

    public void a() {
        AppMethodBeat.i(100051);
        for (AsyncTask execute : this.f) {
            execute.execute(new Object[0]);
        }
        AppMethodBeat.o(100051);
    }

    public void a(JSONArray jSONArray, o oVar) {
        AppMethodBeat.i(100052);
        if (this.d == null) {
            AppMethodBeat.o(100052);
            return;
        }
        this.d.a(jSONArray);
        this.e.a(oVar);
        int i = jj.c;
        if (oVar != null) {
            i = oVar.b();
        }
        this.g.a(this.d.a(), i);
        AppMethodBeat.o(100052);
    }

    public void b() {
        AppMethodBeat.i(100053);
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                ((AsyncTask) this.f.get(i2)).cancel(true);
                i = i2 + 1;
            }
            this.f.clear();
        }
        this.f = null;
        AppMethodBeat.o(100053);
    }

    public void a(boolean z) {
        AppMethodBeat.i(100054);
        if (this.b == null) {
            AppMethodBeat.o(100054);
            return;
        }
        this.b.i(z);
        if (z) {
            this.c.d();
        }
        this.c.a(true);
        AppMethodBeat.o(100054);
    }
}
