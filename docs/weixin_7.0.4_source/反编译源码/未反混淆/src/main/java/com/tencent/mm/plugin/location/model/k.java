package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class k implements f {
    private List<com.tencent.mm.pluginsdk.location.a> callbacks = new ArrayList();
    az fBz = new az(1, "location_worker");
    int h = 300;
    LinkedList<b> nKb = new LinkedList();
    b nKc = null;
    int w = 300;

    public class a implements com.tencent.mm.sdk.platformtools.az.a {
        private byte[] data;
        private String mFilePath;
        boolean nKd = true;
        private int nKe;
        private int nKf;
        String url = "";

        public a(boolean z, String str, String str2) {
            AppMethodBeat.i(113330);
            this.nKd = z;
            this.nKe = k.this.w;
            this.nKf = k.this.h;
            this.url = str;
            while (this.nKe * this.nKf > 270000) {
                this.nKe = (int) (((double) this.nKe) / 1.2d);
                this.nKf = (int) (((double) this.nKf) / 1.2d);
            }
            this.mFilePath = str2;
            ab.i("MicroMsg.StaticMapServer", "get url %s %s", str, bo.bc(this.mFilePath, ""));
            AppMethodBeat.o(113330);
        }

        public final boolean acf() {
            AppMethodBeat.i(113331);
            this.data = bo.ano(this.url);
            if (this.data != null) {
                e.b(this.mFilePath, this.data, this.data.length);
            }
            AppMethodBeat.o(113331);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(113332);
            ab.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.nKd);
            if (this.data != null) {
                k.a(k.this, true);
                AppMethodBeat.o(113332);
            } else if (!this.nKd) {
                k.a(k.this, false);
                AppMethodBeat.o(113332);
            } else if (k.this.nKc == null) {
                k.a(k.this, false);
                AppMethodBeat.o(113332);
            } else {
                this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.nKe), Integer.valueOf(this.nKf), Float.valueOf(k.this.nKc.fBs), Float.valueOf(k.this.nKc.fBr), Integer.valueOf(k.this.nKc.cED)});
                k.this.fBz.e(new a(false, this.url, k.b(k.this.nKc)));
                AppMethodBeat.o(113332);
            }
            return false;
        }
    }

    static /* synthetic */ void a(k kVar, boolean z) {
        AppMethodBeat.i(113342);
        kVar.iB(z);
        AppMethodBeat.o(113342);
    }

    public final void a(com.tencent.mm.pluginsdk.location.a aVar) {
        AppMethodBeat.i(113333);
        for (com.tencent.mm.pluginsdk.location.a equals : this.callbacks) {
            if (aVar.equals(equals)) {
                AppMethodBeat.o(113333);
                return;
            }
        }
        this.callbacks.add(aVar);
        ab.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
        if (this.callbacks.size() == 1) {
            start();
        }
        AppMethodBeat.o(113333);
    }

    public final void b(com.tencent.mm.pluginsdk.location.a aVar) {
        AppMethodBeat.i(113334);
        this.callbacks.remove(aVar);
        ab.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
        if (this.callbacks.size() == 0) {
            ab.i("MicroMsg.StaticMapServer", "clean task");
            this.nKb.clear();
            this.nKc = null;
            stop();
        }
        AppMethodBeat.o(113334);
    }

    public k() {
        AppMethodBeat.i(113335);
        start();
        AppMethodBeat.o(113335);
    }

    private void start() {
        AppMethodBeat.i(113336);
        g.Rg().a(648, (f) this);
        AppMethodBeat.o(113336);
    }

    public final void stop() {
        AppMethodBeat.i(113337);
        ab.i("MicroMsg.StaticMapServer", "stop static map server");
        g.Rg().b(648, (f) this);
        AppMethodBeat.o(113337);
    }

    /* Access modifiers changed, original: final */
    public final void agx() {
        AppMethodBeat.i(113338);
        if (this.nKc == null && this.nKb.size() > 0) {
            int intValue;
            this.nKc = (b) this.nKb.removeFirst();
            try {
                intValue = Integer.valueOf(bo.bc(com.tencent.mm.m.g.Nu().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            ab.i("MicroMsg.StaticMapServer", "run local %d", Integer.valueOf(intValue));
            if (intValue == 0) {
                g.Rg().a(new g(this.nKc.fBr, this.nKc.fBs, this.nKc.cED + 1, this.w, this.h, b(this.nKc), aa.dor()), 0);
                AppMethodBeat.o(113338);
                return;
            }
            int i = this.w;
            for (intValue = this.h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (bo.gT(ah.getContext())) {
                this.fBz.e(new a(true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nKc.fBr), Float.valueOf(this.nKc.fBs), Integer.valueOf(this.nKc.cED), aa.dor()}), b(this.nKc)));
                AppMethodBeat.o(113338);
                return;
            }
            this.fBz.e(new a(false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nKc.fBs), Float.valueOf(this.nKc.fBr), Integer.valueOf(this.nKc.cED)}), b(this.nKc)));
        }
        AppMethodBeat.o(113338);
    }

    public static String b(b bVar) {
        AppMethodBeat.i(113339);
        String x = com.tencent.mm.a.g.x((bVar.toString()).getBytes());
        String str = c.XX() + x.charAt(0) + x.charAt(1) + "/" + x.charAt(3) + x.charAt(4) + "/";
        if (!e.ct(str)) {
            new com.tencent.mm.vfs.b(str).mkdirs();
        }
        x = str + "static_map_" + x;
        AppMethodBeat.o(113339);
        return x;
    }

    private void iB(boolean z) {
        AppMethodBeat.i(113340);
        ab.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", Boolean.valueOf(z));
        if (z) {
            if (this.nKc != null) {
                for (com.tencent.mm.pluginsdk.location.a aVar : this.callbacks) {
                    if (aVar != null) {
                        aVar.a(b(this.nKc), this.nKc);
                    }
                }
            }
        } else if (this.nKc != null) {
            for (com.tencent.mm.pluginsdk.location.a aVar2 : this.callbacks) {
                if (aVar2 != null) {
                    aVar2.a(this.nKc);
                }
            }
        }
        this.nKc = null;
        agx();
        AppMethodBeat.o(113340);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(113341);
        if (mVar.getType() == 648) {
            if (i == 0 && i2 == 0 && this.nKc != null) {
                iB(true);
                AppMethodBeat.o(113341);
                return;
            }
            iB(false);
        }
        AppMethodBeat.o(113341);
    }
}
