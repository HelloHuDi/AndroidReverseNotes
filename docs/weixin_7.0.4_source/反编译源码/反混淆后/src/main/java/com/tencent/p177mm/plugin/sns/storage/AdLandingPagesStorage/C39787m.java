package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C21989c;
import com.tencent.p177mm.plugin.sns.storage.C35003y;
import com.tencent.p177mm.plugin.sns.storage.C43569d;
import com.tencent.p177mm.plugin.sns.storage.C43574x;
import com.tencent.p177mm.protocal.protobuf.adw;
import com.tencent.p177mm.protocal.protobuf.adx;
import com.tencent.p177mm.protocal.protobuf.akz;
import com.tencent.p177mm.protocal.protobuf.ala;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m */
public final class C39787m {
    private static final C39787m reM = new C39787m();
    private Map<Long, String> cache = new HashMap();
    private C43569d reN = C13373af.cnG();
    public C35003y reO = C13373af.cnH();
    public Map<String, String> reP = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m$1 */
    class C397881 implements Runnable {
        C397881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37788);
            C39787m.m68069a(C39787m.this);
            AppMethodBeat.m2505o(37788);
        }
    }

    static {
        AppMethodBeat.m2504i(37800);
        AppMethodBeat.m2505o(37800);
    }

    public static C39787m cqn() {
        return reM;
    }

    private C39787m() {
        AppMethodBeat.m2504i(37791);
        HandlerThread anM = C7305d.anM("OpenCanvasMgr");
        anM.start();
        new C7306ak(anM.getLooper()).postDelayed(new C397881(), 5000);
        AppMethodBeat.m2505o(37791);
    }

    /* renamed from: n */
    public final String mo62908n(long j, int i, int i2) {
        AppMethodBeat.m2504i(37792);
        C4990ab.m7417i("OpenCanvasMgr", "open pageId %d, preLoad %d", Long.valueOf(j), Integer.valueOf(i));
        String str;
        if (j <= 0) {
            str = "";
            AppMethodBeat.m2505o(37792);
            return str;
        }
        str = "";
        if (i2 != 1) {
            str = m68075kt(j);
        }
        if (i != 1) {
            AppMethodBeat.m2505o(37792);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            m68067C(j, i);
            str = "";
            AppMethodBeat.m2505o(37792);
            return str;
        } else {
            AppMethodBeat.m2505o(37792);
            return str;
        }
    }

    /* renamed from: kt */
    private String m68075kt(long j) {
        AppMethodBeat.m2504i(37793);
        String str;
        if (this.cache.containsKey(Long.valueOf(j))) {
            str = (String) this.cache.get(Long.valueOf(j));
            AppMethodBeat.m2505o(37793);
            return str;
        }
        C21989c c21989c = new C21989c();
        c21989c.field_canvasId = j;
        this.reN.mo10102b((C4925c) c21989c, new String[0]);
        if (TextUtils.isEmpty(c21989c.field_canvasXml)) {
            str = "";
            AppMethodBeat.m2505o(37793);
            return str;
        }
        this.cache.put(Long.valueOf(j), c21989c.field_canvasXml);
        str = c21989c.field_canvasXml;
        AppMethodBeat.m2505o(37793);
        return str;
    }

    /* renamed from: C */
    private void m68067C(long j, int i) {
        AppMethodBeat.m2504i(37794);
        final C21989c c21989c = new C21989c();
        c21989c.field_canvasId = j;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adw();
        c1196a.fsK = new adx();
        c1196a.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        c1196a.fsI = 1286;
        C7472b acD = c1196a.acD();
        ((adw) acD.fsG.fsP).wlV = j;
        final long j2 = j;
        final int i2 = i;
        C1226w.m2654a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(37789);
                if (i == 0 && i2 == 0) {
                    adx adx = (adx) c7472b.fsH.fsP;
                    C4990ab.m7417i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(j2), adx.wlW);
                    if (!TextUtils.isEmpty(adx.wlW)) {
                        C39787m.this.cache.put(Long.valueOf(j2), adx.wlW);
                        c21989c.field_canvasXml = adx.wlW;
                        C39787m.this.reN.mo69147a(c21989c);
                    }
                    AppMethodBeat.m2505o(37789);
                } else {
                    C4990ab.m7413e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.m2505o(37789);
                }
                return 0;
            }
        });
        AppMethodBeat.m2505o(37794);
    }

    /* renamed from: u */
    public final void mo62909u(long j, String str) {
        AppMethodBeat.m2504i(37795);
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.cache.put(Long.valueOf(j), str);
            C21989c c21989c = new C21989c();
            c21989c.field_canvasId = j;
            c21989c.field_canvasXml = str;
            this.reN.mo69147a(c21989c);
        }
        AppMethodBeat.m2505o(37795);
    }

    /* renamed from: j */
    public final String mo62907j(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(37796);
        C4990ab.m7417i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", str, str2, Integer.valueOf(i));
        String str3;
        if (C5046bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.m2505o(37796);
            return str3;
        }
        str3 = "";
        if (i2 != 1) {
            str3 = m68074gp(str, str2);
        }
        if (i != 1) {
            AppMethodBeat.m2505o(37796);
            return str3;
        } else if (TextUtils.isEmpty(str3)) {
            m68068I(str, str2, i);
            str3 = "";
            AppMethodBeat.m2505o(37796);
            return str3;
        } else {
            AppMethodBeat.m2505o(37796);
            return str3;
        }
    }

    /* renamed from: gp */
    private String m68074gp(String str, String str2) {
        String str3;
        Object str32;
        AppMethodBeat.m2504i(37797);
        if (C5046bo.isNullOrNil(str2)) {
            str32 = str;
        } else {
            str32 = str + str2;
        }
        if (this.reP.containsKey(str32)) {
            str32 = (String) this.reP.get(str32);
            AppMethodBeat.m2505o(37797);
            return str32;
        }
        C43574x c43574x = new C43574x();
        c43574x.field_canvasId = str;
        c43574x.field_canvasExt = str2;
        this.reO.mo10102b((C4925c) c43574x, "canvasId", "canvasExt");
        if (TextUtils.isEmpty(c43574x.field_canvasXml)) {
            str32 = "";
            AppMethodBeat.m2505o(37797);
            return str32;
        }
        this.reP.put(str32, c43574x.field_canvasXml);
        str32 = c43574x.field_canvasXml;
        AppMethodBeat.m2505o(37797);
        return str32;
    }

    /* renamed from: I */
    private void m68068I(final String str, String str2, final int i) {
        AppMethodBeat.m2504i(37798);
        final C43574x c43574x = new C43574x();
        c43574x.field_canvasId = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akz();
        c1196a.fsK = new ala();
        c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        c1196a.fsI = 1890;
        C7472b acD = c1196a.acD();
        akz akz = (akz) acD.fsG.fsP;
        akz.wqx = str;
        akz.wqy = str2;
        C1226w.m2654a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(37790);
                if (i == 0 && i2 == 0) {
                    String dlY = ((ala) c7472b.fsH.fsP).wqz.dlY();
                    C4990ab.m7417i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", str, dlY);
                    if (!TextUtils.isEmpty(dlY)) {
                        C39787m.this.reP.put(str, dlY);
                        c43574x.field_canvasXml = dlY;
                        C39787m.this.reO.mo55582a(c43574x);
                    }
                    AppMethodBeat.m2505o(37790);
                } else {
                    C4990ab.m7413e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2));
                    AppMethodBeat.m2505o(37790);
                }
                return 0;
            }
        });
        AppMethodBeat.m2505o(37798);
    }

    /* renamed from: a */
    static /* synthetic */ void m68069a(C39787m c39787m) {
        AppMethodBeat.m2504i(37799);
        C4990ab.m7416i("OpenCanvasMgr", "clearing old canvasInfo cache");
        Cursor baR = c39787m.reN.baR();
        if (baR != null) {
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (baR.moveToNext()) {
                C21989c c21989c = new C21989c();
                c21989c.mo8995d(baR);
                if (c21989c.field_createTime < currentTimeMillis) {
                    C4990ab.m7416i("OpenCanvasMgr", "ad canvas eliminate %d " + c21989c.field_canvasId);
                    c39787m.reN.mo16760a((C4925c) c21989c, new String[0]);
                }
            }
            baR.close();
            baR = c39787m.reO.baR();
            if (baR != null) {
                currentTimeMillis = System.currentTimeMillis() - 777600000;
                while (baR.moveToNext()) {
                    C43574x c43574x = new C43574x();
                    c43574x.mo8995d(baR);
                    if (c43574x.field_createTime < currentTimeMillis) {
                        C4990ab.m7416i("OpenCanvasMgr", "ux canvas eliminate %d " + c43574x.field_canvasId);
                        c39787m.reO.mo16760a((C4925c) c43574x, new String[0]);
                    }
                }
                baR.close();
            }
        }
        AppMethodBeat.m2505o(37799);
    }
}
