package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.a.c;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends m implements k {
    private final b ehh;
    private f ehi;
    private final int gOW;
    public byte[] kWS;
    public int kWU;
    private boolean kWV;
    private ArrayList<EmotionSummary> kWW;
    public final int mType;

    public n(int i, int i2) {
        this(i, null, i2);
    }

    public n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public n(int i, byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(53134);
        this.kWV = false;
        this.kWW = new ArrayList();
        this.kWS = null;
        a aVar = new a();
        aVar.fsJ = new GetEmotionListRequest();
        aVar.fsK = new GetEmotionListResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.fsI = 411;
        aVar.fsL = 210;
        aVar.fsM = 1000000210;
        this.ehh = aVar.acD();
        this.kWS = bArr;
        this.mType = i;
        this.gOW = i2;
        this.kWV = z;
        AppMethodBeat.o(53134);
    }

    public final int getType() {
        return 411;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53135);
        this.ehi = fVar;
        GetEmotionListRequest getEmotionListRequest = (GetEmotionListRequest) this.ehh.fsG.fsP;
        if (this.kWS != null) {
            getEmotionListRequest.ReqBuf = aa.ad(this.kWS);
        } else {
            getEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
        }
        ab.d("MicroMsg.emoji.NetSceneGetEmotionList", getEmotionListRequest.ReqBuf == null ? "Buf is NULL" : getEmotionListRequest.ReqBuf.toString());
        getEmotionListRequest.ReqType = this.mType;
        getEmotionListRequest.Scene = this.gOW;
        if (this.mType == 7) {
            getEmotionListRequest.Category = this.kWU;
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53135);
        return a;
    }

    public final GetEmotionListResponse bkB() {
        if (this.ehh == null) {
            return null;
        }
        return (GetEmotionListResponse) this.ehh.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53136);
        ab.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            j.getEmojiStorageMgr().xYq.a(this.mType, bkB());
        }
        if (i2 == 0 || i2 == 4) {
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) ((b) qVar).fsH.fsP;
            if (getEmotionListResponse.ReqBuf != null) {
                this.kWS = aa.a(getEmotionListResponse.ReqBuf);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    bkC();
                    y(this.kWW);
                    g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    bkC();
                    ((GetEmotionListRequest) ((b) qVar).fsG.fsP).ReqBuf = ((GetEmotionListResponse) ((b) qVar).fsH.fsP).ReqBuf;
                    a(this.ftf, this.ehi);
                } else if (i3 == 3) {
                    if (this.kWW != null) {
                        this.kWW.clear();
                    }
                    ((GetEmotionListRequest) ((b) qVar).fsG.fsP).ReqBuf = new SKBuiltinBuffer_t();
                    a(this.ftf, this.ehi);
                }
            }
            if (this.mType == 1 || this.mType == 5 || this.mType == 9) {
                at emojiStorageMgr = j.getEmojiStorageMgr();
                Object obj = bkB().EmotionExptConfig;
                if (!bo.isEqual(emojiStorageMgr.xYI, (String) obj)) {
                    emojiStorageMgr.xYI = obj;
                    g.RP().Ry().set(ac.a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, obj);
                    com.tencent.mm.sdk.b.a.xxA.m(new cw());
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(53136);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53136);
    }

    public static com.tencent.mm.plugin.emoji.model.f a(GetEmotionListResponse getEmotionListResponse) {
        AppMethodBeat.i(53137);
        ab.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (getEmotionListResponse == null) {
            AppMethodBeat.o(53137);
            return null;
        }
        com.tencent.mm.plugin.emoji.model.f fVar = new com.tencent.mm.plugin.emoji.model.f();
        if (getEmotionListResponse != null) {
            fVar.kVp = getEmotionListResponse.EmotionCount;
            ArrayList arrayList = new ArrayList();
            if (!(getEmotionListResponse.EmotionList == null || getEmotionListResponse.EmotionList.isEmpty())) {
                Object[] toArray = getEmotionListResponse.EmotionList.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof EmotionSummary)) {
                            EmotionSummary emotionSummary = (EmotionSummary) obj;
                            if (!(emotionSummary == null || bo.isNullOrNil(emotionSummary.ProductID))) {
                                arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(emotionSummary));
                            }
                        }
                    }
                }
            }
            fVar.kVq = arrayList;
            fVar.kVr = getEmotionListResponse.Banner;
            fVar.kVs = getEmotionListResponse.NewBannerList;
            LinkedList linkedList = getEmotionListResponse.CellSetList;
            if (fVar.kVu == null) {
                fVar.kVu = new LinkedList();
                fVar.kVu.addAll(linkedList);
            }
            fVar.kVt = getEmotionListResponse.BannerSetList;
        }
        AppMethodBeat.o(53137);
        return fVar;
    }

    public final int acn() {
        return 100;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    private void bkC() {
        AppMethodBeat.i(53138);
        GetEmotionListResponse bkB = bkB();
        if (bkB == null || bkB.EmotionList == null || bkB.EmotionList.size() <= 0) {
            ab.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
            AppMethodBeat.o(53138);
            return;
        }
        this.kWW.addAll(bkB.EmotionList);
        AppMethodBeat.o(53138);
    }

    private void y(ArrayList<EmotionSummary> arrayList) {
        AppMethodBeat.i(53139);
        com.tencent.mm.storage.emotion.a aVar = j.getEmojiStorageMgr().xYo;
        if (aVar == null) {
            ab.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            AppMethodBeat.o(53139);
            return;
        }
        long j;
        h hVar;
        EmotionSummary emotionSummary;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (aVar.bSd instanceof h) {
            h hVar2 = (h) aVar.bSd;
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", Long.valueOf(hVar2.iV(Thread.currentThread().getId())));
            j = r4;
            hVar = hVar2;
        } else {
            j = -1;
            hVar = null;
        }
        Iterator it;
        EmojiGroupInfo emojiGroupInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            it = aVar.duB().iterator();
            while (it.hasNext()) {
                emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_sync > 0) {
                    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", emojiGroupInfo.field_productID);
                    aVar.aqd(emojiGroupInfo.field_productID);
                }
            }
            aVar.aqd("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            HashMap duA = aVar.duA();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", Integer.valueOf(arrayList.size()));
            for (int i = 0; i < r13; i++) {
                emotionSummary = (EmotionSummary) arrayList.get(i);
                if (emotionSummary == null || bo.isNullOrNil(emotionSummary.ProductID)) {
                    ab.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    EmojiGroupInfo emojiGroupInfo2;
                    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", emotionSummary.ProductID);
                    arrayList2.add(emotionSummary.ProductID);
                    if (duA.containsKey(emotionSummary.ProductID)) {
                        emojiGroupInfo2 = (EmojiGroupInfo) duA.get(emotionSummary.ProductID);
                        if (emojiGroupInfo2 == null) {
                            emojiGroupInfo2 = new EmojiGroupInfo();
                        }
                        emojiGroupInfo2.field_productID = emotionSummary.ProductID;
                    } else if (emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                        emojiGroupInfo2 = (EmojiGroupInfo) duA.get(String.valueOf(EmojiGroupInfo.yar));
                        if (emojiGroupInfo2 == null) {
                            emojiGroupInfo2 = new EmojiGroupInfo();
                        }
                        emojiGroupInfo2.field_productID = String.valueOf(EmojiGroupInfo.yar);
                    } else {
                        emojiGroupInfo2 = new EmojiGroupInfo();
                        emojiGroupInfo2.field_productID = emotionSummary.ProductID;
                    }
                    if (emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                        emojiGroupInfo2.field_flag = 0;
                        emojiGroupInfo2.field_packName = "emoji_custom_all";
                        emojiGroupInfo2.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                    } else {
                        emojiGroupInfo2.field_packName = emotionSummary.PackName;
                        emojiGroupInfo2.field_type = EmojiGroupInfo.yao;
                    }
                    emojiGroupInfo2.field_packIconUrl = emotionSummary.IconUrl;
                    emojiGroupInfo2.field_packGrayIconUrl = emotionSummary.PanelUrl;
                    emojiGroupInfo2.field_packCoverUrl = emotionSummary.CoverUrl;
                    emojiGroupInfo2.field_packDesc = emotionSummary.PackDesc;
                    emojiGroupInfo2.field_packAuthInfo = emotionSummary.PackAuthInfo;
                    emojiGroupInfo2.field_packPrice = emotionSummary.PackPrice;
                    emojiGroupInfo2.field_packType = emotionSummary.PackType;
                    emojiGroupInfo2.field_packFlag = emotionSummary.PackFlag;
                    emojiGroupInfo2.field_packExpire = (long) emotionSummary.PackExpire;
                    emojiGroupInfo2.field_packTimeStamp = (long) emotionSummary.Timestamp;
                    emojiGroupInfo2.field_sort = 1;
                    emojiGroupInfo2.field_idx = i;
                    if (emojiGroupInfo2.field_sync == 0) {
                        if (emojiGroupInfo2.field_status == 7 && emojiGroupInfo2.field_packStatus == 1) {
                            emojiGroupInfo2.field_sync = 2;
                        } else {
                            emojiGroupInfo2.field_sync = 1;
                        }
                    }
                    if (emojiGroupInfo2.field_sync == 2) {
                        emojiGroupInfo2.field_status = 7;
                    }
                    if (emojiGroupInfo2.field_sync == 2 && !emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                        ax axVar = new ax();
                        axVar.cua.type = 1;
                        axVar.cua.cud = emotionSummary.ProductID;
                        com.tencent.mm.sdk.b.a.xxA.m(axVar);
                        if (!axVar.cub.csN) {
                            ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", emotionSummary.ProductID);
                            emojiGroupInfo2.field_sync = 1;
                        }
                    }
                    ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", emojiGroupInfo2.field_productID, Long.valueOf(emojiGroupInfo2.field_lastUseTime), Integer.valueOf(emojiGroupInfo2.field_sort));
                    aVar.a(emojiGroupInfo2);
                }
            }
            for (EmojiGroupInfo emojiGroupInfo3 : duA.values()) {
                if (!(emojiGroupInfo3 == null || bo.isNullOrNil(emojiGroupInfo3.field_productID) || emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.yas)))) {
                    if (emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.yar))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", "com.tencent.xin.emoticon.tusiji");
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(emojiGroupInfo3.field_productID)) {
                        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", emojiGroupInfo3.field_productID);
                        arrayList3.add(emojiGroupInfo3.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    aVar.aqd((String) it.next());
                }
            }
            aVar.b("event_update_group", 0, bo.dpG().toString());
        }
        if (hVar != null) {
            hVar.mB(j);
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
        aVar.b("event_update_group", 0, bo.dpG().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.kWV) {
            ArrayList arrayList5 = (ArrayList) aVar.duK();
            if (arrayList5.size() > 0) {
                ab.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", Integer.valueOf(arrayList5.size()));
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!bo.isNullOrNil(str)) {
                        if (str.equals(String.valueOf(EmojiGroupInfo.yar))) {
                            arrayList4.add(new c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(str));
                        }
                    }
                }
                j.bkj().z(arrayList4);
                if (!j.bkj().kXj.kXr) {
                    j.bkj().kXj.bkG();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            ab.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", Integer.valueOf(arrayList.size()));
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                emotionSummary = (EmotionSummary) it2.next();
                if (!(emotionSummary == null || bo.isNullOrNil(emotionSummary.ProductID))) {
                    if (emotionSummary.ProductID.equals(String.valueOf(EmojiGroupInfo.yar))) {
                        arrayList4.add(new c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(emotionSummary.ProductID, (byte) 0));
                    }
                }
            }
            j.bkj().z(arrayList4);
            if (!j.bkj().kXj.kXr) {
                j.bkj().kXj.bkG();
            }
            AppMethodBeat.o(53139);
            return;
        }
        AppMethodBeat.o(53139);
    }
}
