package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C26085ax;
import com.tencent.p177mm.p230g.p231a.C6472cw;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.sync.p948a.C38887b;
import com.tencent.p177mm.plugin.emoji.sync.p948a.C45861c;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.p177mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C46623a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.f.n */
public final class C20375n extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private final int gOW;
    public byte[] kWS;
    public int kWU;
    private boolean kWV;
    private ArrayList<EmotionSummary> kWW;
    public final int mType;

    public C20375n(int i, int i2) {
        this(i, null, i2);
    }

    public C20375n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public C20375n(int i, byte[] bArr, int i2, boolean z) {
        AppMethodBeat.m2504i(53134);
        this.kWV = false;
        this.kWW = new ArrayList();
        this.kWS = null;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new GetEmotionListRequest();
        c1196a.fsK = new GetEmotionListResponse();
        c1196a.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        c1196a.fsI = 411;
        c1196a.fsL = 210;
        c1196a.fsM = 1000000210;
        this.ehh = c1196a.acD();
        this.kWS = bArr;
        this.mType = i;
        this.gOW = i2;
        this.kWV = z;
        AppMethodBeat.m2505o(53134);
    }

    public final int getType() {
        return 411;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53135);
        this.ehi = c1202f;
        GetEmotionListRequest getEmotionListRequest = (GetEmotionListRequest) this.ehh.fsG.fsP;
        if (this.kWS != null) {
            getEmotionListRequest.ReqBuf = C1946aa.m4152ad(this.kWS);
        } else {
            getEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
        }
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetEmotionList", getEmotionListRequest.ReqBuf == null ? "Buf is NULL" : getEmotionListRequest.ReqBuf.toString());
        getEmotionListRequest.ReqType = this.mType;
        getEmotionListRequest.Scene = this.gOW;
        if (this.mType == 7) {
            getEmotionListRequest.Category = this.kWU;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53135);
        return a;
    }

    public final GetEmotionListResponse bkB() {
        if (this.ehh == null) {
            return null;
        }
        return (GetEmotionListResponse) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53136);
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            C42952j.getEmojiStorageMgr().xYq.mo64086a(this.mType, bkB());
        }
        if (i2 == 0 || i2 == 4) {
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) ((C7472b) c1929q).fsH.fsP;
            if (getEmotionListResponse.ReqBuf != null) {
                this.kWS = C1946aa.m4150a(getEmotionListResponse.ReqBuf);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    bkC();
                    m31537y(this.kWW);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    bkC();
                    ((GetEmotionListRequest) ((C7472b) c1929q).fsG.fsP).ReqBuf = ((GetEmotionListResponse) ((C7472b) c1929q).fsH.fsP).ReqBuf;
                    mo4456a(this.ftf, this.ehi);
                } else if (i3 == 3) {
                    if (this.kWW != null) {
                        this.kWW.clear();
                    }
                    ((GetEmotionListRequest) ((C7472b) c1929q).fsG.fsP).ReqBuf = new SKBuiltinBuffer_t();
                    mo4456a(this.ftf, this.ehi);
                }
            }
            if (this.mType == 1 || this.mType == 5 || this.mType == 9) {
                C23505at emojiStorageMgr = C42952j.getEmojiStorageMgr();
                Object obj = bkB().EmotionExptConfig;
                if (!C5046bo.isEqual(emojiStorageMgr.xYI, (String) obj)) {
                    emojiStorageMgr.xYI = obj;
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, obj);
                    C4879a.xxA.mo10055m(new C6472cw());
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(53136);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53136);
    }

    /* renamed from: a */
    public static C20383f m31536a(GetEmotionListResponse getEmotionListResponse) {
        AppMethodBeat.m2504i(53137);
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (getEmotionListResponse == null) {
            AppMethodBeat.m2505o(53137);
            return null;
        }
        C20383f c20383f = new C20383f();
        if (getEmotionListResponse != null) {
            c20383f.kVp = getEmotionListResponse.EmotionCount;
            ArrayList arrayList = new ArrayList();
            if (!(getEmotionListResponse.EmotionList == null || getEmotionListResponse.EmotionList.isEmpty())) {
                Object[] toArray = getEmotionListResponse.EmotionList.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof EmotionSummary)) {
                            EmotionSummary emotionSummary = (EmotionSummary) obj;
                            if (!(emotionSummary == null || C5046bo.isNullOrNil(emotionSummary.ProductID))) {
                                arrayList.add(new C11546f(emotionSummary));
                            }
                        }
                    }
                }
            }
            c20383f.kVq = arrayList;
            c20383f.kVr = getEmotionListResponse.Banner;
            c20383f.kVs = getEmotionListResponse.NewBannerList;
            LinkedList linkedList = getEmotionListResponse.CellSetList;
            if (c20383f.kVu == null) {
                c20383f.kVu = new LinkedList();
                c20383f.kVu.addAll(linkedList);
            }
            c20383f.kVt = getEmotionListResponse.BannerSetList;
        }
        AppMethodBeat.m2505o(53137);
        return c20383f;
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    private void bkC() {
        AppMethodBeat.m2504i(53138);
        GetEmotionListResponse bkB = bkB();
        if (bkB == null || bkB.EmotionList == null || bkB.EmotionList.size() <= 0) {
            C4990ab.m7420w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
            AppMethodBeat.m2505o(53138);
            return;
        }
        this.kWW.addAll(bkB.EmotionList);
        AppMethodBeat.m2505o(53138);
    }

    /* renamed from: y */
    private void m31537y(ArrayList<EmotionSummary> arrayList) {
        AppMethodBeat.m2504i(53139);
        C46623a c46623a = C42952j.getEmojiStorageMgr().xYo;
        if (c46623a == null) {
            C4990ab.m7420w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            AppMethodBeat.m2505o(53139);
            return;
        }
        long j;
        C7480h c7480h;
        EmotionSummary emotionSummary;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (c46623a.bSd instanceof C7480h) {
            C7480h c7480h2 = (C7480h) c46623a.bSd;
            C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", Long.valueOf(c7480h2.mo15639iV(Thread.currentThread().getId())));
            j = r4;
            c7480h = c7480h2;
        } else {
            j = -1;
            c7480h = null;
        }
        Iterator it;
        EmojiGroupInfo emojiGroupInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            it = c46623a.duB().iterator();
            while (it.hasNext()) {
                emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_sync > 0) {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", emojiGroupInfo.field_productID);
                    c46623a.aqd(emojiGroupInfo.field_productID);
                }
            }
            c46623a.aqd("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            HashMap duA = c46623a.duA();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", Integer.valueOf(arrayList.size()));
            for (int i = 0; i < r13; i++) {
                emotionSummary = (EmotionSummary) arrayList.get(i);
                if (emotionSummary == null || C5046bo.isNullOrNil(emotionSummary.ProductID)) {
                    C4990ab.m7420w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    EmojiGroupInfo emojiGroupInfo2;
                    C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", emotionSummary.ProductID);
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
                        C26085ax c26085ax = new C26085ax();
                        c26085ax.cua.type = 1;
                        c26085ax.cua.cud = emotionSummary.ProductID;
                        C4879a.xxA.mo10055m(c26085ax);
                        if (!c26085ax.cub.csN) {
                            C4990ab.m7411d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", emotionSummary.ProductID);
                            emojiGroupInfo2.field_sync = 1;
                        }
                    }
                    C4990ab.m7411d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", emojiGroupInfo2.field_productID, Long.valueOf(emojiGroupInfo2.field_lastUseTime), Integer.valueOf(emojiGroupInfo2.field_sort));
                    c46623a.mo10099a(emojiGroupInfo2);
                }
            }
            for (EmojiGroupInfo emojiGroupInfo3 : duA.values()) {
                if (!(emojiGroupInfo3 == null || C5046bo.isNullOrNil(emojiGroupInfo3.field_productID) || emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.yas)))) {
                    if (emojiGroupInfo3.field_productID.equals(String.valueOf(EmojiGroupInfo.yar))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", "com.tencent.xin.emoticon.tusiji");
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(emojiGroupInfo3.field_productID)) {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", emojiGroupInfo3.field_productID);
                        arrayList3.add(emojiGroupInfo3.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    c46623a.aqd((String) it.next());
                }
            }
            c46623a.mo15641b("event_update_group", 0, C5046bo.dpG().toString());
        }
        if (c7480h != null) {
            c7480h.mo15640mB(j);
            C4990ab.m7416i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
        c46623a.mo15641b("event_update_group", 0, C5046bo.dpG().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.kWV) {
            ArrayList arrayList5 = (ArrayList) c46623a.duK();
            if (arrayList5.size() > 0) {
                C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", Integer.valueOf(arrayList5.size()));
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!C5046bo.isNullOrNil(str)) {
                        if (str.equals(String.valueOf(EmojiGroupInfo.yar))) {
                            arrayList4.add(new C45861c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new C38887b(str));
                        }
                    }
                }
                C42952j.bkj().mo61755z(arrayList4);
                if (!C42952j.bkj().kXj.kXr) {
                    C42952j.bkj().kXj.bkG();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", Integer.valueOf(arrayList.size()));
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                emotionSummary = (EmotionSummary) it2.next();
                if (!(emotionSummary == null || C5046bo.isNullOrNil(emotionSummary.ProductID))) {
                    if (emotionSummary.ProductID.equals(String.valueOf(EmojiGroupInfo.yar))) {
                        arrayList4.add(new C45861c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new C38887b(emotionSummary.ProductID, (byte) 0));
                    }
                }
            }
            C42952j.bkj().mo61755z(arrayList4);
            if (!C42952j.bkj().kXj.kXr) {
                C42952j.bkj().kXj.bkG();
            }
            AppMethodBeat.m2505o(53139);
            return;
        }
        AppMethodBeat.m2505o(53139);
    }
}
