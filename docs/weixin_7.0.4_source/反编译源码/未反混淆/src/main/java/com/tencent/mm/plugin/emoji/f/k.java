package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.j.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends m implements com.tencent.mm.network.k {
    private f eIc;
    public final b ehh;
    private a kWP;
    private boolean kWQ = false;
    private nf kWR = null;
    public String kWl = "";

    public k(String str) {
        AppMethodBeat.i(53123);
        b.a aVar = new b.a();
        aVar.fsJ = new aij();
        aVar.fsK = new aik();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.fsI = c.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.kWl = str;
        this.kWR = new nf();
        AppMethodBeat.o(53123);
    }

    public k(String str, a aVar) {
        AppMethodBeat.i(53124);
        b.a aVar2 = new b.a();
        aVar2.fsJ = new aij();
        aVar2.fsK = new aik();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.fsI = c.CTRL_INDEX;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        this.kWl = str;
        this.kWP = aVar;
        this.kWQ = true;
        this.kWR = new nf();
        AppMethodBeat.o(53124);
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53125);
        ab.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", this.kWl);
        this.eIc = fVar;
        ((aij) this.ehh.fsG.fsP).ProductID = this.kWl;
        if (TextUtils.isEmpty(this.kWl)) {
            ab.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
            AppMethodBeat.o(53125);
            return -1;
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53125);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53126);
        if (i2 != 0 || i3 != 0) {
            ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.kWl);
            if (this.kWQ) {
                ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.kWQ) {
            LinkedList<yh> linkedList = ((aik) this.ehh.fsH.fsP).jBw;
            com.tencent.mm.storage.emotion.c cVar = j.getEmojiStorageMgr().xYp;
            String str2 = this.kWl;
            int i4 = ((aik) this.ehh.fsH.fsP).wov;
            int bky = bky();
            if (cVar.yaX != null) {
                cVar.yaX.edit().putLong("274544".concat(String.valueOf(str2)), System.currentTimeMillis()).commit();
            }
            if (linkedList != null && linkedList.size() > 0) {
                long iV;
                h hVar = null;
                if (cVar.bSd instanceof h) {
                    h hVar2 = (h) cVar.bSd;
                    iV = hVar2.iV(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    iV = -1;
                }
                cVar.bSd.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                com.tencent.mm.storage.emotion.b bVar = new com.tencent.mm.storage.emotion.b();
                bVar.field_groupId = str2;
                bVar.field_click_flag = i4;
                bVar.field_download_flag = bky;
                for (yh yhVar : linkedList) {
                    bVar.field_md5 = yhVar.Md5;
                    Iterator it = yhVar.jBw.iterator();
                    while (it.hasNext()) {
                        axm axm = (axm) it.next();
                        bVar.field_desc = axm.Desc;
                        bVar.field_lang = axm.nbs;
                        bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                        if (cVar.bSd.replace("EmojiInfoDesc", "md5_lang", bVar.Hl()) < 0) {
                            if (hVar != null) {
                                hVar.mB(iV);
                            }
                        }
                    }
                }
                cVar.bSd.replace("EmojiInfoDesc", "md5_lang", bVar.Hl());
                if (hVar != null) {
                    hVar.mB(iV);
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", this.kWl);
                this.kWR.cJv.cwg = this.kWl;
                com.tencent.mm.sdk.b.a.xxA.m(this.kWR);
            }
        } else if ((bky() & 1) == 1) {
            com.tencent.mm.plugin.emoji.g.c.a(this.kWP);
        } else {
            ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53126);
    }

    private int bky() {
        return ((aik) this.ehh.fsH.fsP).wox;
    }

    public final int acn() {
        return 50;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
