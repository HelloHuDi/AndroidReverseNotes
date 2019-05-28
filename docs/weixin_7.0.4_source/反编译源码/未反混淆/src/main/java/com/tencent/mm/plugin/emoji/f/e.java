package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends m implements k {
    public static int kWq = 0;
    public static int kWr = 1;
    public final b ehh;
    private f ehi;
    private int kWn;
    private ArrayList<String> kWp;
    private ArrayList<EmojiInfo> kWs;
    public int kWt;
    private a kWu;
    private a kWv;
    private LinkedList<String> kWw;
    private int mIndex;

    public e(int i) {
        this(new LinkedList(), i, kWq);
        AppMethodBeat.i(62337);
        AppMethodBeat.o(62337);
    }

    public e(LinkedList<String> linkedList) {
        this(linkedList, 0, kWr);
    }

    private e(LinkedList<String> linkedList, int i, int i2) {
        AppMethodBeat.i(62338);
        this.kWp = new ArrayList();
        this.kWs = new ArrayList();
        this.mIndex = 0;
        this.kWt = 0;
        this.kWw = new LinkedList();
        b.a aVar = new b.a();
        aVar.fsJ = new hu();
        aVar.fsK = new hv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.fsI = 697;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.mIndex = 0;
        this.kWt = i2;
        this.kWw = linkedList;
        this.kWn = i;
        if (this.kWn == 1) {
            this.kWu = a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
            this.kWv = a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG;
            AppMethodBeat.o(62338);
            return;
        }
        this.kWu = a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
        this.kWv = a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG;
        AppMethodBeat.o(62338);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(62339);
        ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        hv hvVar;
        if (this.kWt == kWq) {
            if (i2 == 0 && i3 == 0) {
                hvVar = (hv) this.ehh.fsH.fsP;
                hu huVar = (hu) this.ehh.fsG.fsP;
                int i4;
                if (hvVar.fJT == 0 && (hvVar.vII == null || hvVar.vII.size() <= 0)) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    h.pYm.a(164, 0, 1, false);
                    AppMethodBeat.o(62339);
                    return;
                } else if (hvVar.fJT == 1) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    g.RP().Ry().set(this.kWv, Long.valueOf(System.currentTimeMillis() + 86400000));
                    g.RP().Ry().set(this.kWu, Boolean.FALSE);
                    a(hvVar);
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    if (this.kWs == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kWs.size();
                    }
                    objArr[0] = Integer.valueOf(i4);
                    ab.i(str2, str3, objArr);
                    ArrayList arrayList = this.kWp;
                    if (arrayList == null || arrayList.size() <= 0) {
                        ab.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        g.RP().Ry().set(a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                    } else {
                        if (arrayList.size() < com.tencent.mm.emoji.a.e.OM()) {
                            g.RP().Ry().set(a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                        }
                        ((Boolean) g.RP().Ry().get(a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.TRUE)).booleanValue();
                        at.dsZ().xYn.m(this.kWn, this.kWs);
                        g.RP().Ry().set(a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.FALSE);
                        d dVar = at.dsZ().xYn;
                        int i5 = this.kWn;
                        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (arrayList == null || arrayList.size() <= 0) {
                            ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> MA = dVar.MA(i5);
                            if (MA.size() <= 0) {
                                ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                for (String str4 : MA) {
                                    if (!arrayList.contains(str4.toLowerCase())) {
                                        arrayList2.add(str4);
                                        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", str4);
                                    }
                                }
                                dVar.u(arrayList2, i5);
                                ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(arrayList2.size()));
                            }
                        }
                        if (((ArrayList) at.dsZ().xYn.MD(0)).size() > 0) {
                            ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", Integer.valueOf(((ArrayList) at.dsZ().xYn.MD(0)).size()));
                            h.pYm.e(11595, Integer.valueOf(2), Integer.valueOf(this.kWn));
                            if (com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext())) {
                                h.pYm.e(11595, Integer.valueOf(3), Integer.valueOf(this.kWn));
                            }
                        } else {
                            g.RP().Ry().set(this.kWu, Boolean.FALSE);
                            ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        EmojiSyncManager.a aVar;
                        if (this.kWn == 1) {
                            com.tencent.mm.emoji.a.a.OB().cd(true);
                            aVar = EmojiSyncManager.ezA;
                            EmojiSyncManager.a.Ph().ch(false);
                        } else {
                            com.tencent.mm.emoji.a.a.OB().cb(true);
                            com.tencent.mm.emoji.a.a.OB().ca(true);
                            aVar = EmojiSyncManager.ezA;
                            EmojiSyncManager.a.Pg().ch(false);
                        }
                        com.tencent.mm.emoji.a.b bVar = com.tencent.mm.emoji.a.b.eyD;
                        com.tencent.mm.emoji.a.b.OG();
                        com.tencent.mm.sdk.b.a.xxA.m(new ny());
                    }
                    h.pYm.a(164, 0, 1, false);
                    AppMethodBeat.o(62339);
                    return;
                } else {
                    ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", Integer.valueOf(huVar.vKj), Integer.valueOf(hvVar.vII.size()));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    huVar.vKj = hvVar.vKj;
                    this.mIndex = huVar.vKj;
                    a(hvVar);
                    i4 = a(this.ftf, this.ehi);
                    if (i < 0) {
                        ab.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", Integer.valueOf(i4));
                    }
                    AppMethodBeat.o(62339);
                    return;
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            h.pYm.a(164, 1, 1, false);
            g.RP().Ry().set(this.kWv, Long.valueOf(System.currentTimeMillis() + 3600000));
            AppMethodBeat.o(62339);
        } else if (i2 == 0 && i3 == 0) {
            hvVar = (hv) this.ehh.fsH.fsP;
            if (hvVar.vKl == null || hvVar.vKl.size() <= 0) {
                ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                at.dsZ().xYn.eL(hvVar.vKl);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(62339);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(62339);
        }
    }

    private void a(hv hvVar) {
        AppMethodBeat.i(62340);
        ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", Integer.valueOf(this.kWn));
        if (hvVar == null) {
            ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
            AppMethodBeat.o(62340);
        } else if (hvVar.vKl == null || hvVar.vKl.size() <= 0) {
            ab.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
            AppMethodBeat.o(62340);
        } else {
            Iterator it = hvVar.vKl.iterator();
            while (it.hasNext()) {
                xx xxVar = (xx) it.next();
                if (bo.isNullOrNil(xxVar.Md5)) {
                    ab.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", xxVar);
                } else {
                    this.kWp.add(xxVar.Md5.toLowerCase());
                    EmojiInfo emojiInfo = new EmojiInfo();
                    com.tencent.mm.plugin.emoji.h.b.a(xxVar, emojiInfo);
                    if (this.kWn == 1) {
                        emojiInfo.field_groupId = "capture";
                    } else {
                        emojiInfo.field_catalog = EmojiInfo.yaB;
                    }
                    this.kWs.add(emojiInfo);
                }
            }
            AppMethodBeat.o(62340);
        }
    }

    public final int getType() {
        return 697;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(62341);
        this.ehi = fVar;
        hu huVar = (hu) this.ehh.fsG.fsP;
        huVar.vKj = this.mIndex;
        huVar.ReqType = this.kWt;
        huVar.vKk = this.kWw;
        huVar.vIK = this.kWn;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(62341);
        return a;
    }

    public final int acn() {
        return 20;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final hv bku() {
        if (this.ehh == null) {
            return null;
        }
        return (hv) this.ehh.fsH.fsP;
    }
}
