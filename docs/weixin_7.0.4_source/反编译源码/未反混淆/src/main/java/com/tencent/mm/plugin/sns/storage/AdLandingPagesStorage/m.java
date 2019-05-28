package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class m {
    private static final m reM = new m();
    private Map<Long, String> cache = new HashMap();
    private d reN = af.cnG();
    public y reO = af.cnH();
    public Map<String, String> reP = new HashMap();

    static {
        AppMethodBeat.i(37800);
        AppMethodBeat.o(37800);
    }

    public static m cqn() {
        return reM;
    }

    private m() {
        AppMethodBeat.i(37791);
        HandlerThread anM = com.tencent.mm.sdk.g.d.anM("OpenCanvasMgr");
        anM.start();
        new ak(anM.getLooper()).postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37788);
                m.a(m.this);
                AppMethodBeat.o(37788);
            }
        }, 5000);
        AppMethodBeat.o(37791);
    }

    public final String n(long j, int i, int i2) {
        AppMethodBeat.i(37792);
        ab.i("OpenCanvasMgr", "open pageId %d, preLoad %d", Long.valueOf(j), Integer.valueOf(i));
        String str;
        if (j <= 0) {
            str = "";
            AppMethodBeat.o(37792);
            return str;
        }
        str = "";
        if (i2 != 1) {
            str = kt(j);
        }
        if (i != 1) {
            AppMethodBeat.o(37792);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            C(j, i);
            str = "";
            AppMethodBeat.o(37792);
            return str;
        } else {
            AppMethodBeat.o(37792);
            return str;
        }
    }

    private String kt(long j) {
        AppMethodBeat.i(37793);
        String str;
        if (this.cache.containsKey(Long.valueOf(j))) {
            str = (String) this.cache.get(Long.valueOf(j));
            AppMethodBeat.o(37793);
            return str;
        }
        c cVar = new c();
        cVar.field_canvasId = j;
        this.reN.b((com.tencent.mm.sdk.e.c) cVar, new String[0]);
        if (TextUtils.isEmpty(cVar.field_canvasXml)) {
            str = "";
            AppMethodBeat.o(37793);
            return str;
        }
        this.cache.put(Long.valueOf(j), cVar.field_canvasXml);
        str = cVar.field_canvasXml;
        AppMethodBeat.o(37793);
        return str;
    }

    private void C(long j, int i) {
        AppMethodBeat.i(37794);
        final c cVar = new c();
        cVar.field_canvasId = j;
        a aVar = new a();
        aVar.fsJ = new adw();
        aVar.fsK = new adx();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar.fsI = 1286;
        b acD = aVar.acD();
        ((adw) acD.fsG.fsP).wlV = j;
        final long j2 = j;
        final int i2 = i;
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, b bVar, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(37789);
                if (i == 0 && i2 == 0) {
                    adx adx = (adx) bVar.fsH.fsP;
                    ab.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(j2), adx.wlW);
                    if (!TextUtils.isEmpty(adx.wlW)) {
                        m.this.cache.put(Long.valueOf(j2), adx.wlW);
                        cVar.field_canvasXml = adx.wlW;
                        m.this.reN.a(cVar);
                    }
                    AppMethodBeat.o(37789);
                } else {
                    ab.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.o(37789);
                }
                return 0;
            }
        });
        AppMethodBeat.o(37794);
    }

    public final void u(long j, String str) {
        AppMethodBeat.i(37795);
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.cache.put(Long.valueOf(j), str);
            c cVar = new c();
            cVar.field_canvasId = j;
            cVar.field_canvasXml = str;
            this.reN.a(cVar);
        }
        AppMethodBeat.o(37795);
    }

    public final String j(String str, String str2, int i, int i2) {
        AppMethodBeat.i(37796);
        ab.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", str, str2, Integer.valueOf(i));
        String str3;
        if (bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.o(37796);
            return str3;
        }
        str3 = "";
        if (i2 != 1) {
            str3 = gp(str, str2);
        }
        if (i != 1) {
            AppMethodBeat.o(37796);
            return str3;
        } else if (TextUtils.isEmpty(str3)) {
            I(str, str2, i);
            str3 = "";
            AppMethodBeat.o(37796);
            return str3;
        } else {
            AppMethodBeat.o(37796);
            return str3;
        }
    }

    private String gp(String str, String str2) {
        String str3;
        Object str32;
        AppMethodBeat.i(37797);
        if (bo.isNullOrNil(str2)) {
            str32 = str;
        } else {
            str32 = str + str2;
        }
        if (this.reP.containsKey(str32)) {
            str32 = (String) this.reP.get(str32);
            AppMethodBeat.o(37797);
            return str32;
        }
        x xVar = new x();
        xVar.field_canvasId = str;
        xVar.field_canvasExt = str2;
        this.reO.b((com.tencent.mm.sdk.e.c) xVar, "canvasId", "canvasExt");
        if (TextUtils.isEmpty(xVar.field_canvasXml)) {
            str32 = "";
            AppMethodBeat.o(37797);
            return str32;
        }
        this.reP.put(str32, xVar.field_canvasXml);
        str32 = xVar.field_canvasXml;
        AppMethodBeat.o(37797);
        return str32;
    }

    private void I(final String str, String str2, final int i) {
        AppMethodBeat.i(37798);
        final x xVar = new x();
        xVar.field_canvasId = str;
        a aVar = new a();
        aVar.fsJ = new akz();
        aVar.fsK = new ala();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        aVar.fsI = 1890;
        b acD = aVar.acD();
        akz akz = (akz) acD.fsG.fsP;
        akz.wqx = str;
        akz.wqy = str2;
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, b bVar, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(37790);
                if (i == 0 && i2 == 0) {
                    String dlY = ((ala) bVar.fsH.fsP).wqz.dlY();
                    ab.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", str, dlY);
                    if (!TextUtils.isEmpty(dlY)) {
                        m.this.reP.put(str, dlY);
                        xVar.field_canvasXml = dlY;
                        m.this.reO.a(xVar);
                    }
                    AppMethodBeat.o(37790);
                } else {
                    ab.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.o(37790);
                }
                return 0;
            }
        });
        AppMethodBeat.o(37798);
    }

    static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(37799);
        ab.i("OpenCanvasMgr", "clearing old canvasInfo cache");
        Cursor baR = mVar.reN.baR();
        if (baR != null) {
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (baR.moveToNext()) {
                c cVar = new c();
                cVar.d(baR);
                if (cVar.field_createTime < currentTimeMillis) {
                    ab.i("OpenCanvasMgr", "ad canvas eliminate %d " + cVar.field_canvasId);
                    mVar.reN.a((com.tencent.mm.sdk.e.c) cVar, new String[0]);
                }
            }
            baR.close();
            baR = mVar.reO.baR();
            if (baR != null) {
                currentTimeMillis = System.currentTimeMillis() - 777600000;
                while (baR.moveToNext()) {
                    x xVar = new x();
                    xVar.d(baR);
                    if (xVar.field_createTime < currentTimeMillis) {
                        ab.i("OpenCanvasMgr", "ux canvas eliminate %d " + xVar.field_canvasId);
                        mVar.reO.a((com.tencent.mm.sdk.e.c) xVar, new String[0]);
                    }
                }
                baR.close();
            }
        }
        AppMethodBeat.o(37799);
    }
}
