package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Map;

public final class a {
    public int cDq;
    public String cvZ;
    public String desc;
    public long fRS;
    public int size;
    public String url;
    public long vbM;

    public static a dhs() {
        AppMethodBeat.i(27304);
        aw.ZK();
        String str = (String) c.Ry().get(352273, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(27304);
            return null;
        }
        a aVar = new a(str);
        if (!aVar.isValid() || aVar.isExpired()) {
            dht();
            AppMethodBeat.o(27304);
            return null;
        }
        AppMethodBeat.o(27304);
        return aVar;
    }

    public a(String str) {
        AppMethodBeat.i(27305);
        Map z = br.z(str, "msg");
        this.desc = (String) z.get(".msg.appmsg.des");
        this.cDq = bo.getInt((String) z.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) z.get(".msg.alphainfo.url");
        this.size = bo.getInt((String) z.get(".msg.alphainfo.size"), 0);
        this.cvZ = (String) z.get(".msg.alphainfo.md5");
        this.vbM = bo.getLong((String) z.get(".msg.alphainfo.maxAge"), 0);
        this.fRS = bo.getLong((String) z.get(".msg.alphainfo.expireTime"), 0);
        ab.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.cDq), this.url, Integer.valueOf(this.size), this.cvZ, this.desc, Long.valueOf(this.vbM), Long.valueOf(this.fRS));
        AppMethodBeat.o(27305);
    }

    private boolean isValid() {
        boolean z;
        AppMethodBeat.i(27306);
        if (this.cDq <= d.vxo || bo.isNullOrNil(this.url) || bo.isNullOrNil(this.cvZ) || bo.isNullOrNil(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        AppMethodBeat.o(27306);
        return z;
    }

    private boolean isExpired() {
        boolean z;
        AppMethodBeat.i(27307);
        aw.ZK();
        if (System.currentTimeMillis() - ((Long) c.Ry().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.vbM || System.currentTimeMillis() > this.fRS) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        AppMethodBeat.o(27307);
        return z;
    }

    public static void dht() {
        AppMethodBeat.i(27308);
        aw.ZK();
        c.Ry().set(352273, null);
        aw.ZK();
        c.Ry().set(352274, null);
        AppMethodBeat.o(27308);
    }

    public final void dhu() {
        AppMethodBeat.i(27309);
        bi biVar = new bi();
        biVar.eJ(bf.q("weixin", bo.anT()));
        biVar.setType(1);
        biVar.setContent(this.desc);
        ab.d("MicroMsg.AlphaUpdateInfo", biVar.field_content);
        biVar.hO(0);
        biVar.ju("weixin");
        biVar.setStatus(3);
        bf.l(biVar);
        ab.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        dht();
        AppMethodBeat.o(27309);
    }

    public final void dhv() {
        AppMethodBeat.i(27310);
        ab.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (!isValid() || isExpired()) {
            AppMethodBeat.o(27310);
        } else if (dhw()) {
            ab.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.cvZ, Integer.valueOf(this.size), this.desc, this.url);
            com.tencent.mm.plugin.p.d.bQU().e(this.cvZ, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", IOUtils.LINE_SEPARATOR_UNIX), this.url);
            AppMethodBeat.o(27310);
        } else {
            dhu();
            AppMethodBeat.o(27310);
        }
    }

    private static boolean dhw() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(27311);
        if (bo.ank(g.Nu().getValue("SilentDownloadApkAtWiFi")) != 0) {
            AppMethodBeat.o(27311);
        } else {
            aw.ZK();
            boolean z3 = (((Integer) c.Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            if (!(at.isWifi(ah.getContext()) && z3)) {
                z = false;
            }
            if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
                ab.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
            } else {
                ab.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                z2 = z;
            }
            AppMethodBeat.o(27311);
        }
        return z2;
    }
}
