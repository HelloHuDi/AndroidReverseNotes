package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C37617g;
import com.tencent.p177mm.booter.CoreService;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.zero.PluginZero;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.C30256t.C23473a;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.bej;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.modelmulti.b */
public final class C42211b extends C1207m implements C1918k {
    protected static int fHJ = 7;
    private String aIm;
    private C1446a eOm;
    private C1202f ehi;
    private int errCode;
    private int errType;
    private int fHK;
    private StringBuilder fHL;
    private long fHM;
    private boolean fHN;
    private C7564ap frk;

    /* renamed from: com.tencent.mm.modelmulti.b$2 */
    class C186642 implements C1202f {
        C186642() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(58348);
            C4990ab.m7417i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            c1207m.ftk = true;
            AppMethodBeat.m2505o(58348);
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.b$a */
    public static class C42212a implements C1929q {
        private final C23473a fHQ;
        private final C7290b fHR;
        private final boolean fHS;
        int uin;

        public C42212a() {
            AppMethodBeat.m2504i(58349);
            this.fHQ = new C23473a();
            this.fHR = new C7290b();
            this.fHS = false;
            AppMethodBeat.m2505o(58349);
        }

        public C42212a(C7290b c7290b) {
            AppMethodBeat.m2504i(58350);
            this.fHQ = new C23473a();
            this.fHR = c7290b;
            this.fHS = true;
            AppMethodBeat.m2505o(58350);
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fHR;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        public final C4834d acF() {
            AppMethodBeat.m2504i(58351);
            this.fHQ.vye = C1427q.m3028LM();
            this.fHQ.vyd = C7243d.eSg;
            this.fHQ.vyc = C7243d.vxo;
            this.fHQ.mo10000hB(this.uin);
            C23473a c23473a = this.fHQ;
            AppMethodBeat.m2505o(58351);
            return c23473a;
        }

        public final boolean acG() {
            return false;
        }

        public final int acC() {
            return 0;
        }

        public final int acB() {
            return 0;
        }

        public final boolean acH() {
            return true;
        }
    }

    public C42211b() {
        AppMethodBeat.m2504i(58352);
        this.errType = 0;
        this.errCode = 0;
        this.aIm = "";
        this.fHK = 0;
        this.fHL = new StringBuilder();
        this.fHM = -1;
        this.fHN = false;
        C4990ab.m7411d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", Integer.valueOf(hashCode()), C5046bo.dpG());
        this.eOm = new C1446a();
        this.fHL.append("stack:" + C5046bo.dpG() + " time:" + C5046bo.anT());
        AppMethodBeat.m2505o(58352);
    }

    public C42211b(final C7290b c7290b, int i, long j) {
        this();
        AppMethodBeat.m2504i(58353);
        this.fHK = i;
        this.fHM = j;
        C4990ab.m7410d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.frk = new C7564ap(C1892aa.anr(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(58347);
                C42211b.this.fHN = true;
                int i = 0;
                C42211b.this.mo4498a(-1, 0, i, "", new C42212a(c7290b), null);
                AppMethodBeat.m2505o(58347);
                return false;
            }
        }, false);
        AppMethodBeat.m2505o(58353);
    }

    public final String getInfo() {
        AppMethodBeat.m2504i(58354);
        String stringBuilder = this.fHL.toString();
        AppMethodBeat.m2505o(58354);
        return stringBuilder;
    }

    public final int acn() {
        return 500;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(58355);
        boolean acJ = super.acJ();
        AppMethodBeat.m2505o(58355);
        return acJ;
    }

    public final int getType() {
        return 138;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(58356);
        super.cancel();
        AppMethodBeat.m2505o(58356);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        boolean z = false;
        AppMethodBeat.m2504i(58357);
        this.ehi = c1202f;
        this.fHL.append(" lastd:" + this.ftg + " dotime:" + C5046bo.anT() + " net:" + C5023at.getNetType(C4996ah.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(fHJ);
        if (this.frk != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.frk != null) {
            mo4470c(c1902e);
            this.frk.mo16770ae(0, 0);
            this.frk = null;
            AppMethodBeat.m2505o(58357);
            return -1;
        }
        C42212a c42212a = new C42212a();
        c42212a.uin = C1892aa.ano().gcU.mo5495QF();
        bej bej = ((C23473a) c42212a.acF()).vyG;
        bej.vTN = fHJ;
        bej.vTO = C1946aa.m4152ad(C5046bo.anf(C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).getString("notify_sync_key_keybuf", "")));
        bej.Scene = 1;
        bej.wIw = new C35956tc();
        bej.vIk = C7243d.eSg;
        int a = mo4457a(c1902e, c42212a, this);
        AppMethodBeat.m2505o(58357);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x04f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58358);
        String str2;
        String str3;
        if (c1929q == null || c1929q.getType() != 138) {
            str2 = "MicroMsg.NetPushSync";
            str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(c1929q == null ? -2 : c1929q.getType());
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(58358);
            return;
        }
        Object obj;
        this.fHL.append(" endtime:" + C5046bo.anT());
        C4990ab.m7417i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.fHN), Long.valueOf(this.eOm.mo4908Mr()), this.fHL);
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] anf;
            int size;
            int i4;
            C7290b c7290b = (C7290b) c1929q.mo5618ZS();
            if (obj == null) {
                byte[] a = C1946aa.m4150a(((C23473a) c1929q.acF()).vyG.vTO);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = C5046bo.m7539ca(a);
                C4990ab.m7411d(str4, str5, objArr2);
                if (C5046bo.m7540cb(a)) {
                    anf = C5046bo.anf(C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).getString("notify_sync_key_keybuf", ""));
                    C4990ab.m7411d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", Integer.valueOf(anf.length), C5046bo.m7539ca(anf));
                } else {
                    anf = a;
                }
                a = C1946aa.m4150a(c7290b.vyH.vTO);
                anf = C44098aa.m79382j(anf, a);
                if (anf == null || anf.length <= 0) {
                    C4990ab.m7420w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    anf = a;
                }
                c7290b.vyH.vTO = C1946aa.m4152ad(anf);
                size = (c7290b.vyH.vTR == null || c7290b.vyH.vTR.jBw == null) ? 0 : c7290b.vyH.vTR.jBw.size();
                C4990ab.m7417i("MicroMsg.NetPushSync", "newMsgSize:%d", Integer.valueOf(size));
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(anf == null ? -1 : anf.length);
                objArr2[2] = C5046bo.m7539ca(anf);
                C4990ab.m7411d(str4, str5, objArr2);
            }
            Iterator it = c7290b.vyH.vTR.jBw.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                C40573tb c40573tb = (C40573tb) it.next();
                if (c40573tb.wat == 5) {
                    anf = C1946aa.m4150a(c40573tb.wau);
                    try {
                        C7254cm c7254cm = new C7254cm();
                        c7254cm.parseFrom(anf);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(c7254cm.nao);
                        objArr3[1] = c7254cm.vEB.wVI;
                        objArr3[2] = Long.valueOf(c7254cm.ptF);
                        if (c7254cm.vEH == null) {
                            i4 = 0;
                        } else {
                            i4 = c7254cm.vEH.length();
                        }
                        objArr3[3] = Integer.valueOf(i4);
                        objArr3[4] = Integer.valueOf(c7254cm.vED.wVI == null ? 0 : c7254cm.vED.wVI.length());
                        C4990ab.m7417i(str3, str4, objArr3);
                        i4 = c7254cm.nao;
                        str3 = c7254cm.vEB.wVI;
                        str4 = c7254cm.vED.wVI;
                        if (i4 == 50) {
                            C4990ab.m7416i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str3)) {
                                C4990ab.m7420w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i4 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                C4990ab.m7416i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i4 == 10002 && str4.contains("revokemsg")) {
                                C4990ab.m7416i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = c7254cm.ptF;
                            str5 = c7254cm.vEB.wVI;
                            str2 = c7254cm.vEH;
                            int i5 = c7254cm.nao;
                            if (C5046bo.isNullOrNil(str2)) {
                                C4990ab.m7416i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = C5046bo.anj(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map z = C5049br.m7595z(str2, "pushcontent");
                                if (z == null) {
                                    C4990ab.m7412e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) z.get(".pushcontent.$content");
                                    pString2.value = (String) z.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) C1720g.m3530M(PluginZero.class);
                                if (pluginZero.yaf != null) {
                                    pluginZero.yaf.mo38834a(j, str5, pString2.value, pString.value, (C6457e.eSi + C1178g.m2591x(("mm" + C1892aa.ano().gcU.mo5495QF()).getBytes())) + "/avatar/", i5);
                                }
                            }
                            if (c7254cm.nao == 10002) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                C4990ab.m7416i("MicroMsg.NetPushSync", "need remove pushContent");
                                c7254cm.vEH = null;
                                c40573tb.wau = C1946aa.m4152ad(c7254cm.toByteArray());
                            }
                        }
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                anf = c7290b.vyH.toByteArray();
                size = C1892aa.ano().gcU.mo5495QF();
                str4 = C37617g.m63512ij(size);
                int jH = C37617g.m63513jH(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + jH;
                byte[] d = C1182l.m2608d(anf, C1178g.m2591x((C1427q.m3026LK() + size).getBytes()).getBytes());
                C4990ab.m7417i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", Integer.valueOf(jH), Integer.valueOf(anf.length), Integer.valueOf(d.length), str6, C37617g.m63507J(anf), C37617g.m63507J(d), C37617g.m63507J(str3.getBytes()));
                if (C5046bo.m7540cb(d)) {
                    C4990ab.m7412e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i4 = C1173e.m2559b(str6, d, d.length);
                    boolean ct = C1173e.m2561ct(str6);
                    if (i4 == 0 && ct) {
                        anf = String.valueOf(jH).getBytes();
                        C1173e.m2559b(str4 + "/syncResp.ini", anf, anf.length);
                    } else {
                        C4990ab.m7413e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", Integer.valueOf(i4), Boolean.valueOf(ct));
                    }
                }
            } catch (IOException e2) {
                C4990ab.m7413e("MicroMsg.NetPushSync", "write syncResp buf err:%s", e2);
                C4990ab.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            C4990ab.m7410d("MicroMsg.NetPushSync", "onRespHandled sync");
            C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).edit().putString("notify_sync_key_keybuf", C5046bo.m7543cd(C1946aa.m4150a(c7290b.vyH.vTO))).commit();
            C4990ab.m7411d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", Integer.valueOf(this.fHK));
            if (obj2 == null) {
                obj = ((c7290b.vyH.vQe & fHJ) == 0 || super.acJ()) ? null : 1;
                C4990ab.m7416i("MicroMsg.NetPushSync", "continue flag=" + c7290b.vyH.vQe + ", selector=" + fHJ + ", limit reach=" + super.acJ());
                if (obj != null) {
                    mo4456a(this.ftf, this.ehi);
                    if (obj2 != null) {
                        CoreService.m16662Ie();
                    }
                    AppMethodBeat.m2505o(58358);
                    return;
                }
            }
            if ((this.fHK & 1) > 0) {
                C4990ab.m7416i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new C26448f(this.fHM, C1946aa.m4150a(c7290b.vyH.vTO), C1892aa.ano().gcU.mo5495QF()).mo4456a(C1892aa.ano(), new C186642());
            }
            this.ehi.onSceneEnd(this.errType, this.errCode, this.aIm, this);
            if (obj2 != null) {
            }
            AppMethodBeat.m2505o(58358);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(58358);
    }
}
