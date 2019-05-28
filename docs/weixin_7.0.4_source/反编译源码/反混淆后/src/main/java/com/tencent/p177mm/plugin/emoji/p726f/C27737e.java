package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9287a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23398hu;
import com.tencent.p177mm.protocal.protobuf.C23399hv;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.f.e */
public final class C27737e extends C1207m implements C1918k {
    public static int kWq = 0;
    public static int kWr = 1;
    public final C7472b ehh;
    private C1202f ehi;
    private int kWn;
    private ArrayList<String> kWp;
    private ArrayList<EmojiInfo> kWs;
    public int kWt;
    private C5127a kWu;
    private C5127a kWv;
    private LinkedList<String> kWw;
    private int mIndex;

    public C27737e(int i) {
        this(new LinkedList(), i, kWq);
        AppMethodBeat.m2504i(62337);
        AppMethodBeat.m2505o(62337);
    }

    public C27737e(LinkedList<String> linkedList) {
        this(linkedList, 0, kWr);
    }

    private C27737e(LinkedList<String> linkedList, int i, int i2) {
        AppMethodBeat.m2504i(62338);
        this.kWp = new ArrayList();
        this.kWs = new ArrayList();
        this.mIndex = 0;
        this.kWt = 0;
        this.kWw = new LinkedList();
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23398hu();
        c1196a.fsK = new C23399hv();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        c1196a.fsI = 697;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.mIndex = 0;
        this.kWt = i2;
        this.kWw = linkedList;
        this.kWn = i;
        if (this.kWn == 1) {
            this.kWu = C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
            this.kWv = C5127a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG;
            AppMethodBeat.m2505o(62338);
            return;
        }
        this.kWu = C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
        this.kWv = C5127a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG;
        AppMethodBeat.m2505o(62338);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(62339);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        C23399hv c23399hv;
        if (this.kWt == kWq) {
            if (i2 == 0 && i3 == 0) {
                c23399hv = (C23399hv) this.ehh.fsH.fsP;
                C23398hu c23398hu = (C23398hu) this.ehh.fsG.fsP;
                int i4;
                if (c23399hv.fJT == 0 && (c23399hv.vII == null || c23399hv.vII.size() <= 0)) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    C7060h.pYm.mo8378a(164, 0, 1, false);
                    AppMethodBeat.m2505o(62339);
                    return;
                } else if (c23399hv.fJT == 1) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    C1720g.m3536RP().mo5239Ry().set(this.kWv, Long.valueOf(System.currentTimeMillis() + 86400000));
                    C1720g.m3536RP().mo5239Ry().set(this.kWu, Boolean.FALSE);
                    m44052a(c23399hv);
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    if (this.kWs == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kWs.size();
                    }
                    objArr[0] = Integer.valueOf(i4);
                    C4990ab.m7417i(str2, str3, objArr);
                    ArrayList arrayList = this.kWp;
                    if (arrayList == null || arrayList.size() <= 0) {
                        C4990ab.m7420w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                    } else {
                        if (arrayList.size() < C26072e.m41618OM()) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                        }
                        ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.TRUE)).booleanValue();
                        C23505at.dsZ().xYn.mo48586m(this.kWn, this.kWs);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.FALSE);
                        C30303d c30303d = C23505at.dsZ().xYn;
                        int i5 = this.kWn;
                        C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (arrayList == null || arrayList.size() <= 0) {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> MA = c30303d.mo48559MA(i5);
                            if (MA.size() <= 0) {
                                C4990ab.m7416i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                for (String str4 : MA) {
                                    if (!arrayList.contains(str4.toLowerCase())) {
                                        arrayList2.add(str4);
                                        C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", str4);
                                    }
                                }
                                c30303d.mo48591u(arrayList2, i5);
                                C4990ab.m7417i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(arrayList2.size()));
                            }
                        }
                        if (((ArrayList) C23505at.dsZ().xYn.mo48562MD(0)).size() > 0) {
                            C4990ab.m7417i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", Integer.valueOf(((ArrayList) C23505at.dsZ().xYn.mo48562MD(0)).size()));
                            C7060h.pYm.mo8381e(11595, Integer.valueOf(2), Integer.valueOf(this.kWn));
                            if (C5023at.isWifi(C4996ah.getContext())) {
                                C7060h.pYm.mo8381e(11595, Integer.valueOf(3), Integer.valueOf(this.kWn));
                            }
                        } else {
                            C1720g.m3536RP().mo5239Ry().set(this.kWu, Boolean.FALSE);
                            C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        C9287a c9287a;
                        if (this.kWn == 1) {
                            C32497a.m53203OB().mo53141cd(true);
                            c9287a = EmojiSyncManager.ezA;
                            C9287a.m16850Ph().mo20719ch(false);
                        } else {
                            C32497a.m53203OB().mo53139cb(true);
                            C32497a.m53203OB().mo53138ca(true);
                            c9287a = EmojiSyncManager.ezA;
                            C9287a.m16849Pg().mo20719ch(false);
                        }
                        C32498b c32498b = C32498b.eyD;
                        C32498b.m53215OG();
                        C4879a.xxA.mo10055m(new C45348ny());
                    }
                    C7060h.pYm.mo8378a(164, 0, 1, false);
                    AppMethodBeat.m2505o(62339);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", Integer.valueOf(c23398hu.vKj), Integer.valueOf(c23399hv.vII.size()));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    c23398hu.vKj = c23399hv.vKj;
                    this.mIndex = c23398hu.vKj;
                    m44052a(c23399hv);
                    i4 = mo4456a(this.ftf, this.ehi);
                    if (i < 0) {
                        C4990ab.m7413e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", Integer.valueOf(i4));
                    }
                    AppMethodBeat.m2505o(62339);
                    return;
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            C7060h.pYm.mo8378a(164, 1, 1, false);
            C1720g.m3536RP().mo5239Ry().set(this.kWv, Long.valueOf(System.currentTimeMillis() + 3600000));
            AppMethodBeat.m2505o(62339);
        } else if (i2 == 0 && i3 == 0) {
            c23399hv = (C23399hv) this.ehh.fsH.fsP;
            if (c23399hv.vKl == null || c23399hv.vKl.size() <= 0) {
                C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                C23505at.dsZ().xYn.mo48581eL(c23399hv.vKl);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(62339);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(62339);
        }
    }

    /* renamed from: a */
    private void m44052a(C23399hv c23399hv) {
        AppMethodBeat.m2504i(62340);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", Integer.valueOf(this.kWn));
        if (c23399hv == null) {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
            AppMethodBeat.m2505o(62340);
        } else if (c23399hv.vKl == null || c23399hv.vKl.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
            AppMethodBeat.m2505o(62340);
        } else {
            Iterator it = c23399hv.vKl.iterator();
            while (it.hasNext()) {
                C40588xx c40588xx = (C40588xx) it.next();
                if (C5046bo.isNullOrNil(c40588xx.Md5)) {
                    C4990ab.m7421w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", c40588xx);
                } else {
                    this.kWp.add(c40588xx.Md5.toLowerCase());
                    EmojiInfo emojiInfo = new EmojiInfo();
                    C2933b.m5222a(c40588xx, emojiInfo);
                    if (this.kWn == 1) {
                        emojiInfo.field_groupId = "capture";
                    } else {
                        emojiInfo.field_catalog = EmojiInfo.yaB;
                    }
                    this.kWs.add(emojiInfo);
                }
            }
            AppMethodBeat.m2505o(62340);
        }
    }

    public final int getType() {
        return 697;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(62341);
        this.ehi = c1202f;
        C23398hu c23398hu = (C23398hu) this.ehh.fsG.fsP;
        c23398hu.vKj = this.mIndex;
        c23398hu.ReqType = this.kWt;
        c23398hu.vKk = this.kWw;
        c23398hu.vIK = this.kWn;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(62341);
        return a;
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final C23399hv bku() {
        if (this.ehh == null) {
            return null;
        }
        return (C23399hv) this.ehh.fsH.fsP;
    }
}
