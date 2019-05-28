package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelstat.C45457b.C18681b;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C45357pf;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19314g;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.protobuf.bti;
import com.tencent.p177mm.protocal.protobuf.btj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.modelsimple.t */
public final class C18678t extends C1207m implements C1918k {
    private static final C5004al fPG = new C5004al("deleteRevokeMessageThread");
    private final long cvx;
    private C1202f ehi;
    private final C7472b fAT;
    private final String fPH;

    static {
        AppMethodBeat.m2504i(16602);
        AppMethodBeat.m2505o(16602);
    }

    public C18678t(C7620bi c7620bi, String str) {
        int i;
        AppMethodBeat.m2504i(16598);
        C9638aw.m17190ZK();
        Object obj = C18628c.m29072Ry().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = C5046bo.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.cvx = c7620bi.field_msgId;
        this.fPH = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (c7620bi.field_createTime / 1000);
        long j = c7620bi.field_msgSvrId;
        String Yz = C1853r.m3846Yz();
        String str3 = c7620bi.field_talker;
        if (c7620bi.dJz != 1) {
            String str4;
            switch (c7620bi.getType()) {
                case 1:
                case 42:
                case 48:
                case 66:
                    C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", Integer.valueOf(C1851p.m3818m(C1853r.m3846Yz(), c7620bi.field_createTime).hashCode()));
                    i2 = r2;
                    break;
                case 3:
                    C25822e fJ = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                    C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", c7620bi.field_talker, Integer.valueOf(fJ.fDJ), Long.valueOf(fJ.fDy), c7620bi.dJC);
                    str2 = str4;
                    break;
                case 34:
                    C32849p uZ = C26500m.ama().mo33987uZ(c7620bi.field_imgPath);
                    if (uZ != null) {
                        C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", uZ.clientId);
                        str2 = str4;
                        break;
                    }
                    break;
                case 43:
                case 62:
                    C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", c7620bi.field_imgPath);
                    str2 = str4;
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", String.valueOf(C44218ap.aps(c7620bi.field_content).time));
                    str2 = str4;
                    break;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                case 1048625:
                case 268435505:
                case 553648177:
                case 587202609:
                    C30065b lZ = C14877am.aUq().mo48329lZ(c7620bi.field_msgId);
                    if (lZ != null) {
                        str4 = lZ.field_clientAppDataId;
                    } else {
                        str4 = c7620bi.field_talker + c7620bi.field_msgId + "T" + c7620bi.field_createTime;
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", str4);
                    str2 = str4;
                    break;
            }
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bti();
        c1196a.fsK = new btj();
        c1196a.uri = "/cgi-bin/micromsg-bin/revokemsg";
        c1196a.fsI = C19314g.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fAT = c1196a.acD();
        bti bti = (bti) this.fAT.fsG.fsP;
        bti.vFF = str2;
        bti.wVo = i2;
        bti.wVp = 0;
        bti.wVr = j;
        bti.pcX = i3;
        bti.ndG = Yz;
        bti.ndF = str3;
        bti.wVq = i;
        C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", bti.vFF, Integer.valueOf(bti.wVo), Integer.valueOf(bti.wVp), Integer.valueOf(bti.pcX), bti.ndG, bti.ndF, Integer.valueOf(bti.wVq));
        AppMethodBeat.m2505o(16598);
    }

    public final int getType() {
        return C19314g.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16599);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(16599);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16600);
        if (i2 == 0 && i3 == 0) {
            C9638aw.m17190ZK();
            final C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
            if (jf.field_msgId == this.cvx) {
                btj ajB = ajB();
                C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), ajB.wVt);
                int type = jf.getType();
                C18678t.m29196a(this.fPH, "  " + C4996ah.getContext().getString(C25738R.string.cg0), jf, jf.field_content);
                jf.mo14781hO(0);
                jf.mo14785ht(jf.dqI | 4);
                C45357pf c45357pf = new C45357pf();
                c45357pf.cLx.cvx = this.cvx;
                C4879a.xxA.mo10055m(c45357pf);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                int i4 = 0;
                C9638aw.m17190ZK();
                Object obj = C18628c.m29072Ry().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i4 = C5046bo.getInt(obj.toString(), 0);
                }
                i4++;
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(290818, Integer.valueOf(i4));
                jf.setType(type);
                C45457b c45457b;
                if (jf.bAA()) {
                    c45457b = C45457b.fRa;
                    type = C1191k.m2615k(jf);
                    if (c45457b.aka()) {
                        c45457b.mo73257a(jf, C18681b.revoke, type);
                    }
                } else {
                    c45457b = C45457b.fRa;
                    if (c45457b.aka()) {
                        c45457b.mo73257a(jf, C18681b.revoke, 0);
                    }
                }
                fPG.mo10310m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(16597);
                        C4990ab.m7417i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", Long.valueOf(jf.field_msgId));
                        jf.setType(10002);
                        C18678t.m29196a(C18678t.this.fPH, "", jf, "");
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                        AppMethodBeat.m2505o(16597);
                    }
                }, 300000);
            } else {
                C4990ab.m7413e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", Long.valueOf(this.cvx));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16600);
    }

    /* renamed from: a */
    public static void m29196a(String str, String str2, C7620bi c7620bi, String str3) {
        AppMethodBeat.m2504i(16601);
        if (c7620bi.getType() == 1 || c7620bi.getType() == 16777265) {
            c7620bi.setType(10002);
            c7620bi.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[]{str, Long.valueOf(System.currentTimeMillis()), str2, str3}));
            AppMethodBeat.m2505o(16601);
            return;
        }
        c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        c7620bi.setContent(str);
        AppMethodBeat.m2505o(16601);
    }

    public final btj ajB() {
        return (btj) this.fAT.fsH.fsP;
    }
}
