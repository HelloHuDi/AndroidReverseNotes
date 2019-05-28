package com.tencent.p177mm.plugin.webview.p1325c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26200mq;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.c.a */
public final class C43863a implements C1202f {
    C22782a ueQ = new C22782a(this, (byte) 0);
    private C4884c ueR = new C438641();

    /* renamed from: com.tencent.mm.plugin.webview.c.a$a */
    class C22782a {
        boolean cxT;
        boolean isRunning;
        private C29764b ueT;
        private String ueU;
        private long ueV;

        private C22782a() {
        }

        /* synthetic */ C22782a(C43863a c43863a, byte b) {
            this();
        }

        /* renamed from: dz */
        private static String m34562dz(String str, int i) {
            AppMethodBeat.m2504i(5651);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            String x = C1178g.m2591x(stringBuffer.toString().getBytes());
            AppMethodBeat.m2505o(5651);
            return x;
        }

        /* renamed from: a */
        public final void mo38375a(int i, String str, String str2, int i2, long j) {
            AppMethodBeat.m2504i(5652);
            if (C5046bo.isNullOrNil(str)) {
                String str3 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str4 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str2 == null ? "" : str2.toString();
                C4990ab.m7417i(str3, str4, objArr);
                AppMethodBeat.m2505o(5652);
                return;
            }
            String dz = C22782a.m34562dz(str, i);
            if (!C5046bo.isNullOrNil(this.ueU) && this.ueU.equals(dz) && System.currentTimeMillis() - this.ueV <= 8000 && C5046bo.isNullOrNil(str2)) {
                if (this.cxT) {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", str);
                    C29944h.m47401JR(i2).mo38618a(this.ueT.cWk().wWr, true, C1946aa.m4153b(this.ueT.cWk().wok), this.ueT.cWk().won);
                    AppMethodBeat.m2505o(5652);
                    return;
                } else if (this.isRunning) {
                    if (this.ueT != null) {
                        this.ueT.ueW = i2;
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    AppMethodBeat.m2505o(5652);
                    return;
                } else {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", str, dz, Integer.valueOf(i2));
            if (this.ueT != null) {
                C1720g.m3540Rg().mo14547c(this.ueT);
            }
            this.ueU = dz;
            this.ueV = System.currentTimeMillis();
            this.isRunning = true;
            this.cxT = false;
            C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_FENGJING, C43863a.this);
            this.ueT = new C29764b(i, str, str2.getBytes(), i2, j);
            C1720g.m3540Rg().mo14541a(this.ueT, 0);
            AppMethodBeat.m2505o(5652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.c.a$1 */
    class C438641 extends C4884c<C26200mq> {
        C438641() {
            AppMethodBeat.m2504i(5649);
            this.xxI = C26200mq.class.getName().hashCode();
            AppMethodBeat.m2505o(5649);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5650);
            C26200mq c26200mq = (C26200mq) c4883b;
            if (c26200mq instanceof C26200mq) {
                C43863a.this.ueQ.mo38375a(c26200mq.cIt.type, c26200mq.cIt.query, c26200mq.cIt.cIu, c26200mq.cIt.cIv, c26200mq.cIt.cIw);
                AppMethodBeat.m2505o(5650);
                return true;
            }
            AppMethodBeat.m2505o(5650);
            return false;
        }
    }

    public C43863a() {
        AppMethodBeat.m2504i(5653);
        C4879a.xxA.mo10052c(this.ueR);
        AppMethodBeat.m2505o(5653);
    }

    /* renamed from: ar */
    public final boolean mo69550ar(Map<String, Object> map) {
        long j;
        AppMethodBeat.m2504i(5654);
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", map.toString());
        String t = C43863a.m78652t(map, "keyword");
        String t2 = C43863a.m78652t(map, "nextPageBuffer");
        int v = C43863a.m78653v(map, "type");
        int v2 = C43863a.m78653v(map, "webview_instance_id");
        String t3 = C43863a.m78652t(map, "searchID");
        if (C5046bo.isNullOrNil(t3)) {
            j = 0;
        } else {
            j = Long.valueOf(t3).longValue();
        }
        this.ueQ.mo38375a(v, t, t2, v2, j);
        AppMethodBeat.m2505o(5654);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(5655);
        if (c1207m instanceof C29764b) {
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_FENGJING, (C1202f) this);
            this.ueQ.isRunning = false;
            C29764b c29764b = (C29764b) c1207m;
            if (i == 0 && i2 == 0) {
                this.ueQ.cxT = true;
            } else {
                this.ueQ.cxT = false;
                C29944h.m47401JR(c29764b.ueW).mo38618a("{}", c29764b.ueX, "", 0);
            }
            C29944h.m47401JR(c29764b.ueW).mo38618a(c29764b.cWk().wWr, c29764b.ueX, C1946aa.m4153b(c29764b.cWk().wok), c29764b.cWk().won);
        }
        AppMethodBeat.m2505o(5655);
    }

    /* renamed from: t */
    public static String m78652t(Map<String, Object> map, String str) {
        AppMethodBeat.m2504i(5656);
        String str2;
        if (!map.containsKey(str)) {
            str2 = "";
            AppMethodBeat.m2505o(5656);
            return str2;
        } else if (map.get(str) != null) {
            str2 = map.get(str).toString();
            AppMethodBeat.m2505o(5656);
            return str2;
        } else {
            str2 = "";
            AppMethodBeat.m2505o(5656);
            return str2;
        }
    }

    /* renamed from: v */
    public static int m78653v(Map<String, Object> map, String str) {
        AppMethodBeat.m2504i(5657);
        String t = C43863a.m78652t(map, str);
        if (C5046bo.isNullOrNil(t)) {
            AppMethodBeat.m2505o(5657);
            return 0;
        }
        int intValue = Integer.valueOf(t).intValue();
        AppMethodBeat.m2505o(5657);
        return intValue;
    }
}
