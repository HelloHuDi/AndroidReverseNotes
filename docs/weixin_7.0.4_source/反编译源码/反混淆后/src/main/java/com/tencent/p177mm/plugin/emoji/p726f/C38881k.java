package com.tencent.p177mm.plugin.emoji.p726f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C37767nf;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C36724c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p727g.C33951c;
import com.tencent.p177mm.plugin.emoji.p727g.C33951c.C33950a;
import com.tencent.p177mm.protocal.protobuf.C44194yh;
import com.tencent.p177mm.protocal.protobuf.aij;
import com.tencent.p177mm.protocal.protobuf.aik;
import com.tencent.p177mm.protocal.protobuf.axm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.C23516c;
import com.tencent.p177mm.storage.emotion.C41339b;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.f.k */
public final class C38881k extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;
    private C33950a kWP;
    private boolean kWQ = false;
    private C37767nf kWR = null;
    public String kWl = "";

    public C38881k(String str) {
        AppMethodBeat.m2504i(53123);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aij();
        c1196a.fsK = new aik();
        c1196a.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        c1196a.fsI = C36724c.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kWl = str;
        this.kWR = new C37767nf();
        AppMethodBeat.m2505o(53123);
    }

    public C38881k(String str, C33950a c33950a) {
        AppMethodBeat.m2504i(53124);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aij();
        c1196a.fsK = new aik();
        c1196a.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        c1196a.fsI = C36724c.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kWl = str;
        this.kWP = c33950a;
        this.kWQ = true;
        this.kWR = new C37767nf();
        AppMethodBeat.m2505o(53124);
    }

    public final int getType() {
        return C36724c.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53125);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", this.kWl);
        this.eIc = c1202f;
        ((aij) this.ehh.fsG.fsP).ProductID = this.kWl;
        if (TextUtils.isEmpty(this.kWl)) {
            C4990ab.m7420w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
            AppMethodBeat.m2505o(53125);
            return -1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53125);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53126);
        if (i2 != 0 || i3 != 0) {
            C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.kWl);
            if (this.kWQ) {
                C4990ab.m7416i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.kWQ) {
            LinkedList<C44194yh> linkedList = ((aik) this.ehh.fsH.fsP).jBw;
            C23516c c23516c = C42952j.getEmojiStorageMgr().xYp;
            String str2 = this.kWl;
            int i4 = ((aik) this.ehh.fsH.fsP).wov;
            int bky = bky();
            if (c23516c.yaX != null) {
                c23516c.yaX.edit().putLong("274544".concat(String.valueOf(str2)), System.currentTimeMillis()).commit();
            }
            if (linkedList != null && linkedList.size() > 0) {
                long iV;
                C7480h c7480h = null;
                if (c23516c.bSd instanceof C7480h) {
                    C7480h c7480h2 = (C7480h) c23516c.bSd;
                    iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                    c7480h = c7480h2;
                } else {
                    iV = -1;
                }
                c23516c.bSd.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                C41339b c41339b = new C41339b();
                c41339b.field_groupId = str2;
                c41339b.field_click_flag = i4;
                c41339b.field_download_flag = bky;
                for (C44194yh c44194yh : linkedList) {
                    c41339b.field_md5 = c44194yh.Md5;
                    Iterator it = c44194yh.jBw.iterator();
                    while (it.hasNext()) {
                        axm axm = (axm) it.next();
                        c41339b.field_desc = axm.Desc;
                        c41339b.field_lang = axm.nbs;
                        c41339b.field_md5_lang = c41339b.field_md5 + c41339b.field_lang;
                        if (c23516c.bSd.replace("EmojiInfoDesc", "md5_lang", c41339b.mo10098Hl()) < 0) {
                            if (c7480h != null) {
                                c7480h.mo15640mB(iV);
                            }
                        }
                    }
                }
                c23516c.bSd.replace("EmojiInfoDesc", "md5_lang", c41339b.mo10098Hl());
                if (c7480h != null) {
                    c7480h.mo15640mB(iV);
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", this.kWl);
                this.kWR.cJv.cwg = this.kWl;
                C4879a.xxA.mo10055m(this.kWR);
            }
        } else if ((bky() & 1) == 1) {
            C33951c.m55566a(this.kWP);
        } else {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53126);
    }

    private int bky() {
        return ((aik) this.ehh.fsH.fsP).wox;
    }

    public final int acn() {
        return 50;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
