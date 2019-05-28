package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.app.a */
public final class C44057a {
    public int cDq;
    public String cvZ;
    public String desc;
    public long fRS;
    public int size;
    public String url;
    public long vbM;

    public static C44057a dhs() {
        AppMethodBeat.m2504i(27304);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(352273, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(27304);
            return null;
        }
        C44057a c44057a = new C44057a(str);
        if (!c44057a.isValid() || c44057a.isExpired()) {
            C44057a.dht();
            AppMethodBeat.m2505o(27304);
            return null;
        }
        AppMethodBeat.m2505o(27304);
        return c44057a;
    }

    public C44057a(String str) {
        AppMethodBeat.m2504i(27305);
        Map z = C5049br.m7595z(str, "msg");
        this.desc = (String) z.get(".msg.appmsg.des");
        this.cDq = C5046bo.getInt((String) z.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) z.get(".msg.alphainfo.url");
        this.size = C5046bo.getInt((String) z.get(".msg.alphainfo.size"), 0);
        this.cvZ = (String) z.get(".msg.alphainfo.md5");
        this.vbM = C5046bo.getLong((String) z.get(".msg.alphainfo.maxAge"), 0);
        this.fRS = C5046bo.getLong((String) z.get(".msg.alphainfo.expireTime"), 0);
        C4990ab.m7417i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.cDq), this.url, Integer.valueOf(this.size), this.cvZ, this.desc, Long.valueOf(this.vbM), Long.valueOf(this.fRS));
        AppMethodBeat.m2505o(27305);
    }

    private boolean isValid() {
        boolean z;
        AppMethodBeat.m2504i(27306);
        if (this.cDq <= C7243d.vxo || C5046bo.isNullOrNil(this.url) || C5046bo.isNullOrNil(this.cvZ) || C5046bo.isNullOrNil(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(27306);
        return z;
    }

    private boolean isExpired() {
        boolean z;
        AppMethodBeat.m2504i(27307);
        C9638aw.m17190ZK();
        if (System.currentTimeMillis() - ((Long) C18628c.m29072Ry().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.vbM || System.currentTimeMillis() > this.fRS) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(27307);
        return z;
    }

    public static void dht() {
        AppMethodBeat.m2504i(27308);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(352273, null);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(352274, null);
        AppMethodBeat.m2505o(27308);
    }

    public final void dhu() {
        AppMethodBeat.m2504i(27309);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14775eJ(C1829bf.m3764q("weixin", C5046bo.anT()));
        c7620bi.setType(1);
        c7620bi.setContent(this.desc);
        C4990ab.m7410d("MicroMsg.AlphaUpdateInfo", c7620bi.field_content);
        c7620bi.mo14781hO(0);
        c7620bi.mo14794ju("weixin");
        c7620bi.setStatus(3);
        C1829bf.m3752l(c7620bi);
        C4990ab.m7416i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        C44057a.dht();
        AppMethodBeat.m2505o(27309);
    }

    public final void dhv() {
        AppMethodBeat.m2504i(27310);
        C4990ab.m7416i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (!isValid() || isExpired()) {
            AppMethodBeat.m2505o(27310);
        } else if (C44057a.dhw()) {
            C4990ab.m7417i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.cvZ, Integer.valueOf(this.size), this.desc, this.url);
            C21429d.bQU().mo36880e(this.cvZ, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", IOUtils.LINE_SEPARATOR_UNIX), this.url);
            AppMethodBeat.m2505o(27310);
        } else {
            dhu();
            AppMethodBeat.m2505o(27310);
        }
    }

    private static boolean dhw() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(27311);
        if (C5046bo.ank(C26373g.m41964Nu().getValue("SilentDownloadApkAtWiFi")) != 0) {
            AppMethodBeat.m2505o(27311);
        } else {
            C9638aw.m17190ZK();
            boolean z3 = (((Integer) C18628c.m29072Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            if (!(C5023at.isWifi(C4996ah.getContext()) && z3)) {
                z = false;
            }
            if ((C5059g.cdh & 1) != 0) {
                C4990ab.m7410d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
            } else {
                C4990ab.m7410d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                z2 = z;
            }
            AppMethodBeat.m2505o(27311);
        }
        return z2;
    }
}
