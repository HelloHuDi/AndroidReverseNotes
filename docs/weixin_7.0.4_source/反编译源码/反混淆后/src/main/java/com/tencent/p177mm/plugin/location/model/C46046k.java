package com.tencent.p177mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.pluginsdk.location.C14865a;
import com.tencent.p177mm.pluginsdk.location.C14866b;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.model.k */
public final class C46046k implements C1202f {
    private List<C14865a> callbacks = new ArrayList();
    C23498az fBz = new C23498az(1, "location_worker");
    /* renamed from: h */
    int f17897h = 300;
    LinkedList<C14866b> nKb = new LinkedList();
    C14866b nKc = null;
    /* renamed from: w */
    int f17898w = 300;

    /* renamed from: com.tencent.mm.plugin.location.model.k$a */
    public class C39284a implements C23499a {
        private byte[] data;
        private String mFilePath;
        boolean nKd = true;
        private int nKe;
        private int nKf;
        String url = "";

        public C39284a(boolean z, String str, String str2) {
            AppMethodBeat.m2504i(113330);
            this.nKd = z;
            this.nKe = C46046k.this.f17898w;
            this.nKf = C46046k.this.f17897h;
            this.url = str;
            while (this.nKe * this.nKf > 270000) {
                this.nKe = (int) (((double) this.nKe) / 1.2d);
                this.nKf = (int) (((double) this.nKf) / 1.2d);
            }
            this.mFilePath = str2;
            C4990ab.m7417i("MicroMsg.StaticMapServer", "get url %s %s", str, C5046bo.m7532bc(this.mFilePath, ""));
            AppMethodBeat.m2505o(113330);
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(113331);
            this.data = C5046bo.ano(this.url);
            if (this.data != null) {
                C5730e.m8624b(this.mFilePath, this.data, this.data.length);
            }
            AppMethodBeat.m2505o(113331);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(113332);
            C4990ab.m7416i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.nKd);
            if (this.data != null) {
                C46046k.m85708a(C46046k.this, true);
                AppMethodBeat.m2505o(113332);
            } else if (!this.nKd) {
                C46046k.m85708a(C46046k.this, false);
                AppMethodBeat.m2505o(113332);
            } else if (C46046k.this.nKc == null) {
                C46046k.m85708a(C46046k.this, false);
                AppMethodBeat.m2505o(113332);
            } else {
                this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.nKe), Integer.valueOf(this.nKf), Float.valueOf(C46046k.this.nKc.fBs), Float.valueOf(C46046k.this.nKc.fBr), Integer.valueOf(C46046k.this.nKc.cED)});
                C46046k.this.fBz.mo39163e(new C39284a(false, this.url, C46046k.m85709b(C46046k.this.nKc)));
                AppMethodBeat.m2505o(113332);
            }
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m85708a(C46046k c46046k, boolean z) {
        AppMethodBeat.m2504i(113342);
        c46046k.m85710iB(z);
        AppMethodBeat.m2505o(113342);
    }

    /* renamed from: a */
    public final void mo73938a(C14865a c14865a) {
        AppMethodBeat.m2504i(113333);
        for (C14865a equals : this.callbacks) {
            if (c14865a.equals(equals)) {
                AppMethodBeat.m2505o(113333);
                return;
            }
        }
        this.callbacks.add(c14865a);
        C4990ab.m7416i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
        if (this.callbacks.size() == 1) {
            start();
        }
        AppMethodBeat.m2505o(113333);
    }

    /* renamed from: b */
    public final void mo73940b(C14865a c14865a) {
        AppMethodBeat.m2504i(113334);
        this.callbacks.remove(c14865a);
        C4990ab.m7416i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
        if (this.callbacks.size() == 0) {
            C4990ab.m7416i("MicroMsg.StaticMapServer", "clean task");
            this.nKb.clear();
            this.nKc = null;
            stop();
        }
        AppMethodBeat.m2505o(113334);
    }

    public C46046k() {
        AppMethodBeat.m2504i(113335);
        start();
        AppMethodBeat.m2505o(113335);
    }

    private void start() {
        AppMethodBeat.m2504i(113336);
        C1720g.m3540Rg().mo14539a(648, (C1202f) this);
        AppMethodBeat.m2505o(113336);
    }

    public final void stop() {
        AppMethodBeat.m2504i(113337);
        C4990ab.m7416i("MicroMsg.StaticMapServer", "stop static map server");
        C1720g.m3540Rg().mo14546b(648, (C1202f) this);
        AppMethodBeat.m2505o(113337);
    }

    /* Access modifiers changed, original: final */
    public final void agx() {
        AppMethodBeat.m2504i(113338);
        if (this.nKc == null && this.nKb.size() > 0) {
            int intValue;
            this.nKc = (C14866b) this.nKb.removeFirst();
            try {
                intValue = Integer.valueOf(C5046bo.m7532bc(C26373g.m41964Nu().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            C4990ab.m7417i("MicroMsg.StaticMapServer", "run local %d", Integer.valueOf(intValue));
            if (intValue == 0) {
                C1720g.m3540Rg().mo14541a(new C28359g(this.nKc.fBr, this.nKc.fBs, this.nKc.cED + 1, this.f17898w, this.f17897h, C46046k.m85709b(this.nKc), C4988aa.dor()), 0);
                AppMethodBeat.m2505o(113338);
                return;
            }
            int i = this.f17898w;
            for (intValue = this.f17897h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (C5046bo.m7558gT(C4996ah.getContext())) {
                this.fBz.mo39163e(new C39284a(true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nKc.fBr), Float.valueOf(this.nKc.fBs), Integer.valueOf(this.nKc.cED), C4988aa.dor()}), C46046k.m85709b(this.nKc)));
                AppMethodBeat.m2505o(113338);
                return;
            }
            this.fBz.mo39163e(new C39284a(false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nKc.fBs), Float.valueOf(this.nKc.fBr), Integer.valueOf(this.nKc.cED)}), C46046k.m85709b(this.nKc)));
        }
        AppMethodBeat.m2505o(113338);
    }

    /* renamed from: b */
    public static String m85709b(C14866b c14866b) {
        AppMethodBeat.m2504i(113339);
        String x = C1178g.m2591x((c14866b.toString()).getBytes());
        String str = C43217c.m76864XX() + x.charAt(0) + x.charAt(1) + "/" + x.charAt(3) + x.charAt(4) + "/";
        if (!C5730e.m8628ct(str)) {
            new C5728b(str).mkdirs();
        }
        x = str + "static_map_" + x;
        AppMethodBeat.m2505o(113339);
        return x;
    }

    /* renamed from: iB */
    private void m85710iB(boolean z) {
        AppMethodBeat.m2504i(113340);
        C4990ab.m7417i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", Boolean.valueOf(z));
        if (z) {
            if (this.nKc != null) {
                for (C14865a c14865a : this.callbacks) {
                    if (c14865a != null) {
                        c14865a.mo27185a(C46046k.m85709b(this.nKc), this.nKc);
                    }
                }
            }
        } else if (this.nKc != null) {
            for (C14865a c14865a2 : this.callbacks) {
                if (c14865a2 != null) {
                    c14865a2.mo27184a(this.nKc);
                }
            }
        }
        this.nKc = null;
        agx();
        AppMethodBeat.m2505o(113340);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(113341);
        if (c1207m.getType() == 648) {
            if (i == 0 && i2 == 0 && this.nKc != null) {
                m85710iB(true);
                AppMethodBeat.m2505o(113341);
                return;
            }
            m85710iB(false);
        }
        AppMethodBeat.m2505o(113341);
    }
}
