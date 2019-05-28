package com.tencent.p177mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.p178a.C1168a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p230g.p231a.C37799sq;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p726f.C38881k;
import com.tencent.p177mm.plugin.emoji.p726f.C38882r;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23504as;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.C23516c;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.model.d */
public final class C20378d implements C1202f {
    C45158c kVd = new C203813();
    public HashMap<Long, String> kVf = new HashMap();
    private boolean kVg = false;
    List<C2936b> kVh = new LinkedList();
    private C37799sq kVi;
    public C11556a kVj;
    List kVk = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.tencent.mm.plugin.emoji.model.d$b */
    class C2936b {
        EmojiInfo cuc;
        long cvx;
        String czD;
        String toUserName;

        public C2936b(long j, String str, EmojiInfo emojiInfo, String str2) {
            this.cvx = j;
            this.toUserName = str;
            this.cuc = emojiInfo;
            this.czD = str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.d$a */
    public interface C11556a {
        /* renamed from: a */
        void mo23264a(boolean z, EmojiInfo emojiInfo);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.d$3 */
    class C203813 implements C45158c {
        C203813() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo15193a(boolean z, Object... objArr) {
            AppMethodBeat.m2504i(53033);
            if (objArr == null || objArr.length < 4) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiService", "extra obj error");
                AppMethodBeat.m2505o(53033);
                return;
            }
            C23504as c23504as;
            EmojiInfo emojiInfo;
            int intValue = ((Integer) objArr[2]).intValue();
            if (objArr[0] instanceof C23504as) {
                c23504as = (C23504as) objArr[0];
            } else {
                c23504as = null;
            }
            if (objArr[1] instanceof EmojiInfo) {
                emojiInfo = (EmojiInfo) objArr[1];
            } else {
                emojiInfo = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (c23504as == null || emojiInfo == null) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                AppMethodBeat.m2505o(53033);
                return;
            }
            C20378d.this.kVk.remove(c23504as.cvZ);
            if (emojiInfo.field_state == EmojiInfo.zZd) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                emojiInfo.field_state = EmojiInfo.zZb;
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "download finish %s, success %b", emojiInfo.mo20410Aq(), Boolean.valueOf(z));
            if (z) {
                String str;
                Object[] objArr2;
                String dve = emojiInfo.dve();
                if (intValue == 102 || intValue == 101 || intValue == 103) {
                    String str2;
                    if (intValue == 103) {
                        str2 = dve + "_openim";
                    } else if (intValue == 101) {
                        str2 = dve + "_extern";
                    } else {
                        str2 = dve + "_encrypt";
                    }
                    boolean z2 = false;
                    if (C5730e.asZ(str2) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            z2 = C1168a.m2550g(Base64.encodeToString(C5046bo.anf(c23504as.aeskey), 0), str2, dve);
                            if (z2) {
                                if (intValue == 101) {
                                    C38876c.m65942hF(11);
                                } else {
                                    C38876c.m65942hF(7);
                                }
                                C4990ab.m7417i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dve);
                                if (z2) {
                                    str = "MicroMsg.emoji.EmojiService";
                                    dve = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr2 = new Object[6];
                                    objArr2[0] = emojiInfo == null ? "" : emojiInfo.mo20410Aq();
                                    objArr2[1] = Long.valueOf(C5730e.asZ(str2));
                                    objArr2[2] = C5730e.atg(str2) == null ? "" : C5730e.atg(str2);
                                    objArr2[3] = emojiInfo == null ? "" : emojiInfo.field_aeskey;
                                    objArr2[4] = emojiInfo == null ? "" : emojiInfo.field_encrypturl;
                                    objArr2[5] = c23504as == null ? "" : c23504as.xYg;
                                    C4990ab.m7417i(str, dve, objArr2);
                                    if (C20378d.this.kVj != null) {
                                        C20378d.this.kVj.mo23264a(false, emojiInfo);
                                    }
                                    if (intValue == 101) {
                                        C38876c.m65941a(c23504as.cvZ, 4, 0, 1, c23504as.cwg, 1, c23504as.xYh);
                                    } else {
                                        C38876c.m65941a(c23504as.cvZ, 3, 0, 1, c23504as.cwg, 1, c23504as.xYh);
                                    }
                                    C5730e.deleteFile(str2);
                                    C20378d.m31547b(c23504as);
                                    AppMethodBeat.m2505o(53033);
                                    return;
                                }
                                C5730e.deleteFile(str2);
                            } else {
                                if (intValue == 101) {
                                    C38876c.m65942hF(12);
                                } else {
                                    C38876c.m65942hF(8);
                                }
                                C4990ab.m7417i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dve);
                                if (z2) {
                                }
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", C5046bo.m7574l(e));
                            if (intValue == 101) {
                                C38876c.m65942hF(12);
                            } else {
                                C38876c.m65942hF(8);
                            }
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", emojiInfo.mo20410Aq());
                        if (C20378d.this.kVj != null) {
                            C20378d.this.kVj.mo23264a(false, emojiInfo);
                        }
                        if (intValue == 101) {
                            C38876c.m65941a(c23504as.cvZ, 4, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                        } else {
                            C38876c.m65941a(c23504as.cvZ, 3, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                        }
                        C20378d.m31547b(c23504as);
                        AppMethodBeat.m2505o(53033);
                        return;
                    }
                }
                C5728b c5728b = new C5728b(dve);
                String Aq;
                if (C5730e.asZ(dve) > 0) {
                    dve = C5730e.atg(C5736j.m8649w(c5728b.mUri));
                    Aq = emojiInfo.mo20410Aq();
                    if (intValue == 101) {
                        Aq = emojiInfo.field_externMd5;
                    }
                    if (C5046bo.isNullOrNil(dve) || !dve.equalsIgnoreCase(Aq)) {
                        String str3 = "MicroMsg.emoji.EmojiService";
                        String str4 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                        Object[] objArr3 = new Object[3];
                        objArr3[0] = dve;
                        objArr3[1] = emojiInfo == null ? "" : emojiInfo.mo20410Aq();
                        objArr3[2] = emojiInfo == null ? "" : emojiInfo.field_cdnUrl;
                        C4990ab.m7417i(str3, str4, objArr3);
                        if (C20378d.this.kVj != null) {
                            C20378d.this.kVj.mo23264a(false, emojiInfo);
                        }
                        c5728b.delete();
                        C20378d.m31547b(c23504as);
                        if (intValue == 101) {
                            C38876c.m65942hF(14);
                            C38876c.m65941a(c23504as.cvZ, 4, 0, 1, c23504as.cwg, 0, c23504as.xYh);
                            AppMethodBeat.m2505o(53033);
                            return;
                        } else if (intValue == 102) {
                            C38876c.m65942hF(5);
                            C38876c.m65941a(c23504as.cvZ, 3, 0, 1, c23504as.cwg, 1, c23504as.xYh);
                            AppMethodBeat.m2505o(53033);
                            return;
                        } else {
                            C38876c.m65942hF(5);
                            C38876c.m65941a(c23504as.cvZ, 2, 0, 1, c23504as.cwg, 1, c23504as.xYh);
                            AppMethodBeat.m2505o(53033);
                            return;
                        }
                    }
                    if (intValue == 101) {
                        C38876c.m65942hF(13);
                        C38876c.m65941a(c23504as.cvZ, 4, 0, 0, c23504as.cwg, 0, c23504as.xYh);
                    } else if (intValue == 102) {
                        C38876c.m65942hF(4);
                        C38876c.m65941a(c23504as.cvZ, 3, 0, 0, c23504as.cwg, 0, c23504as.xYh);
                    } else {
                        C38876c.m65942hF(4);
                        C38876c.m65941a(c23504as.cvZ, 2, 0, 0, c23504as.cwg, 1, c23504as.xYh);
                    }
                    C20362f.bjK().mo35591c(emojiInfo, true);
                    if (C20378d.this.kVj != null) {
                        C20378d.this.kVj.mo23264a(true, emojiInfo);
                    }
                    C20378d.m31547b(c23504as);
                    AppMethodBeat.m2505o(53033);
                    return;
                }
                str = "MicroMsg.emoji.EmojiService";
                dve = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                objArr2 = new Object[2];
                objArr2[0] = emojiInfo == null ? "" : emojiInfo.mo20410Aq();
                if (emojiInfo == null) {
                    Aq = "";
                } else {
                    Aq = emojiInfo.field_cdnUrl;
                }
                objArr2[1] = Aq;
                C4990ab.m7417i(str, dve, objArr2);
                if (C20378d.this.kVj != null) {
                    C20378d.this.kVj.mo23264a(false, emojiInfo);
                }
                if (intValue == 101) {
                    C38876c.m65941a(c23504as.cvZ, 4, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                    C38876c.m65942hF(3);
                } else {
                    C38876c.m65941a(c23504as.cvZ, 2, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                    C38876c.m65942hF(3);
                }
                C20378d.m31547b(c23504as);
                AppMethodBeat.m2505o(53033);
                return;
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", emojiInfo.mo20410Aq());
            if (C20378d.this.kVj != null) {
                C20378d.this.kVj.mo23264a(false, emojiInfo);
            }
            if (intValue == 101) {
                C38876c.m65941a(c23504as.cvZ, 4, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                C38876c.m65942hF(3);
            } else {
                C38876c.m65941a(c23504as.cvZ, 2, 1, 1, c23504as.cwg, 1, c23504as.xYh);
                C38876c.m65942hF(3);
            }
            C20378d.m31547b(c23504as);
            AppMethodBeat.m2505o(53033);
        }
    }

    public C20378d() {
        AppMethodBeat.m2504i(53034);
        C1720g.m3535RO().eJo.mo14539a((int) ErrorCode.NEEDDOWNLOAD_FALSE_5, (C1202f) this);
        AppMethodBeat.m2505o(53034);
    }

    /* renamed from: hG */
    private static void m31548hG(long j) {
        AppMethodBeat.m2504i(53035);
        ((C42184aq) ((C46115a) C1720g.m3530M(C46115a.class)).getNotification()).mo27972a(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j));
        AppMethodBeat.m2505o(53035);
    }

    /* renamed from: a */
    public final void mo35675a(String str, EmojiInfo emojiInfo, C7620bi c7620bi) {
        AppMethodBeat.m2504i(53036);
        if (C5046bo.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.m2505o(53036);
            return;
        }
        long Z;
        long j;
        if (C5730e.asZ(emojiInfo.dve()) <= 0) {
            emojiInfo.field_state = EmojiInfo.zYZ;
            C42952j.getEmojiStorageMgr().xYn.mo48555G(emojiInfo);
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (C2933b.m5225w(emojiInfo)) {
            z = C42952j.bkm().mo61750Js(emojiInfo.field_groupId);
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", Boolean.valueOf(z));
        } else {
            C42952j.bkm().bkc();
        }
        if (c7620bi == null) {
            C7620bi c7620bi2 = new C7620bi();
            if (emojiInfo.field_type == EmojiInfo.zYX || emojiInfo.field_type == EmojiInfo.zYY) {
                c7620bi2.setType(1048625);
            } else {
                c7620bi2.setType(47);
            }
            c7620bi2.mo14794ju(str);
            c7620bi2.mo14781hO(1);
            String Yz = C1853r.m3846Yz();
            boolean z2 = (emojiInfo.mo48552xy() || emojiInfo.isGif()) ? false : true;
            c7620bi2.setContent(C44218ap.m79810a(Yz, currentTimeMillis, z2, emojiInfo.mo20410Aq(), z, ""));
            c7620bi2.mo14795jv(emojiInfo.mo20410Aq());
            c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi2.field_talker));
            Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi2);
            j = currentTimeMillis;
        } else {
            long j2 = c7620bi.field_msgId;
            C44218ap aps = C44218ap.aps(c7620bi.field_content);
            if (aps.time == 0) {
                AppMethodBeat.m2505o(53036);
                return;
            } else {
                Z = j2;
                j = aps.time;
            }
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", Long.valueOf(Z), emojiInfo.mo20410Aq(), Integer.valueOf(emojiInfo.field_size));
        this.kVh.add(new C2936b(Z, str, emojiInfo, String.valueOf(j)));
        if (!this.kVg || this.kVh.size() == 1) {
            this.kVg = true;
            C1720g.m3535RO().eJo.mo14541a(new C38882r(String.valueOf(j), str, emojiInfo, Z), 0);
        }
        mo35673JC(emojiInfo.field_groupId);
        AppMethodBeat.m2505o(53036);
    }

    /* renamed from: JC */
    public final void mo35673JC(final String str) {
        AppMethodBeat.m2504i(53037);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:5:0x0038  */
            /* JADX WARNING: Missing block: B:11:0x005d, code skipped:
            if ((r6 - r4) >= 3600000) goto L_0x0036;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int i = 1;
                AppMethodBeat.m2504i(53031);
                C23516c c23516c = C42952j.getEmojiStorageMgr().xYp;
                String str = str;
                if (C2933b.m5219JX(str)) {
                    long j = c23516c.yaX.getLong("274544".concat(String.valueOf(str)), 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j < 86400000) {
                        if (!c23516c.aqh(str)) {
                        }
                    }
                    if (i != 0) {
                        C42952j.bki();
                        String str2 = str;
                        if (C5046bo.isNullOrNil(str2)) {
                            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
                            AppMethodBeat.m2505o(53031);
                            return;
                        }
                        C1720g.m3535RO().eJo.mo14541a(new C38881k(str2), 0);
                    }
                    AppMethodBeat.m2505o(53031);
                }
                i = 0;
                if (i != 0) {
                }
                AppMethodBeat.m2505o(53031);
            }
        });
        AppMethodBeat.m2505o(53037);
    }

    /* renamed from: s */
    public final boolean mo35676s(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53038);
        C23504as D = C23504as.m36330D(emojiInfo);
        if (D == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.m2505o(53038);
        } else {
            D.talker = emojiInfo == null ? "" : emojiInfo.talker;
            D.xYk = false;
            mo35674a(D, null, true);
            mo35673JC(emojiInfo == null ? null : emojiInfo.field_groupId);
            AppMethodBeat.m2505o(53038);
        }
        return true;
    }

    /* renamed from: a */
    public final void mo35674a(C23504as c23504as, C1197a c1197a, boolean z) {
        AppMethodBeat.m2504i(53039);
        if (c23504as == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            AppMethodBeat.m2505o(53039);
            return;
        }
        EmojiInfo emojiInfo;
        if (!(c1197a == null || c1197a.eAB == null || c1197a.eAB.ptF != c23504as.cKK)) {
            c23504as.dqI = C1829bf.m3747d(c1197a);
            c23504as.gag = c1197a.eAB.vEI;
            c23504as.createTime = (long) c1197a.eAB.pcX;
        }
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(c23504as.cvZ);
        String str = "MicroMsg.emoji.EmojiService";
        String str2 = "downloadEmoji: db emoji null %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(aqi == null);
        C4990ab.m7417i(str, str2, objArr);
        if (aqi != null) {
            int i;
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", aqi.field_md5, c23504as.cvZ, Long.valueOf(c23504as.cKK));
            if (C5046bo.isNullOrNil(c23504as.cwg) || c23504as.cwg.equals(aqi.field_groupId)) {
                i = 0;
            } else {
                aqi.field_groupId = c23504as.cwg;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.xYh) || c23504as.xYh.equals(aqi.field_designerID))) {
                aqi.field_designerID = c23504as.xYh;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.thumbUrl) || c23504as.thumbUrl.equals(aqi.field_thumbUrl))) {
                aqi.field_thumbUrl = c23504as.thumbUrl;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.cAp) || c23504as.cAp.equals(aqi.field_encrypturl))) {
                aqi.field_encrypturl = c23504as.cAp;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.aeskey) || c23504as.aeskey.equals(aqi.field_aeskey))) {
                aqi.field_aeskey = c23504as.aeskey;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.nuk) || c23504as.nuk.equals(aqi.field_cdnUrl))) {
                aqi.field_cdnUrl = c23504as.nuk;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.fgu) || c23504as.fgu.equals(aqi.field_tpurl))) {
                aqi.field_tpurl = c23504as.fgu;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.fgA) || c23504as.fgA.equals(aqi.field_tpauthkey))) {
                aqi.field_tpauthkey = c23504as.fgA;
                i = 1;
            }
            if (c23504as.width > 0 && c23504as.width != aqi.field_width) {
                aqi.field_width = c23504as.width;
                i = 1;
            }
            if (c23504as.height > 0 && c23504as.height != aqi.field_height) {
                aqi.field_height = c23504as.height;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.xYi) || c23504as.xYi.equals(aqi.field_externUrl))) {
                aqi.field_externUrl = c23504as.xYi;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.xYj) || c23504as.xYj.equals(aqi.field_externMd5))) {
                aqi.field_externMd5 = c23504as.xYj;
                i = 1;
            }
            if (!(C5046bo.isNullOrNil(c23504as.xYl) || c23504as.xYl.equalsIgnoreCase(aqi.field_activityid))) {
                aqi.field_activityid = c23504as.xYl;
                i = 1;
            }
            if (aqi.field_state == EmojiInfo.zZb && C5730e.asZ(aqi.dve()) <= 0) {
                C4990ab.m7417i("MicroMsg.emoji.EmojiService", "emoji %s complete but file not exist", aqi.mo20410Aq());
                aqi.field_state = EmojiInfo.zZd;
                i = 1;
            }
            if (!C5046bo.isNullOrNil(c23504as.eyJ)) {
                aqi.field_attachedText = c23504as.eyJ;
                i = 1;
            }
            if (!C5046bo.isNullOrNil(c23504as.lgY)) {
                aqi.field_lensId = c23504as.lgY;
                i = 1;
            }
            if (!C5046bo.isNullOrNil(c23504as.xYm)) {
                aqi.field_attachTextColor = c23504as.xYm;
                i = 1;
            }
            if (aqi.field_width <= 0 || aqi.field_height <= 0) {
                aqi.field_width = c23504as.width;
                aqi.field_height = c23504as.height;
                i = 1;
            }
            if (i != 0) {
                C42952j.getEmojiStorageMgr().xYn.mo48555G(aqi);
                C4990ab.m7417i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", aqi.field_designerID, aqi.field_thumbUrl);
            }
            emojiInfo = aqi;
        } else {
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", c23504as.cvZ);
            emojiInfo = C20378d.m31545a(c23504as);
        }
        long j = 0;
        if (c23504as.xYk) {
            emojiInfo.duP();
            j = m31544a(c23504as, emojiInfo, c1197a);
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", emojiInfo.mo20410Aq(), Boolean.valueOf(emojiInfo.duP()), Boolean.valueOf(z));
        if (!emojiInfo.duP()) {
            if (z) {
                m31546a(c23504as, emojiInfo, j);
                AppMethodBeat.m2505o(53039);
                return;
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", Boolean.valueOf(z));
            this.kVk.remove(c23504as.cvZ);
            C20378d.m31547b(c23504as);
        }
        AppMethodBeat.m2505o(53039);
    }

    /* renamed from: a */
    private void m31546a(C23504as c23504as, EmojiInfo emojiInfo, long j) {
        AppMethodBeat.m2504i(53040);
        if (this.kVk == null || !this.kVk.contains(c23504as.cvZ)) {
            this.kVk.add(c23504as.cvZ);
            String dve = emojiInfo.dve();
            if (!C5046bo.isNullOrNil(c23504as.fgu)) {
                C42130g c42130g = new C42130g();
                c42130g.field_mediaId = "downemoj_" + C1178g.m2591x(c23504as.fgu.getBytes()).substring(0, 16) + "_" + c23504as.cKK;
                c42130g.field_fullpath = dve + "_openim";
                c42130g.field_fileType = 19;
                c42130g.field_authKey = emojiInfo.field_tpauthkey;
                c42130g.egm = emojiInfo.field_tpurl;
                c42130g.field_priority = C42129a.efC;
                final C23504as c23504as2 = c23504as;
                final EmojiInfo emojiInfo2 = emojiInfo;
                final long j2 = j;
                c42130g.egl = new C1628a() {
                    /* renamed from: a */
                    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                        AppMethodBeat.m2504i(53032);
                        if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                            C20378d.this.kVd.mo15193a(true, c23504as2, emojiInfo2, Integer.valueOf(103), Long.valueOf(j2));
                        }
                        AppMethodBeat.m2505o(53032);
                        return 0;
                    }

                    /* renamed from: a */
                    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    /* renamed from: l */
                    public final byte[] mo5084l(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                if (!C37461f.afx().mo51222b(c42130g, -1)) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiService", "recv openim emoj, add task failed");
                }
            } else if (C26072e.m41622OQ() && C26072e.m41623OR() && !C5046bo.isNullOrNil(emojiInfo.field_externUrl) && !C5046bo.isNullOrNil(emojiInfo.field_externMd5)) {
                C42952j.bjW().mo43771a(c23504as.xYi, C20364g.m31467r(dve + "_extern", c23504as, emojiInfo, Integer.valueOf(101), Long.valueOf(j)), this.kVd);
                C38876c.m65942hF(10);
            } else if (!C5046bo.isNullOrNil(c23504as.cAp) && !C5046bo.isNullOrNil(c23504as.aeskey)) {
                C42952j.bjW().mo43771a(c23504as.cAp, C20364g.m31467r(dve + "_encrypt", c23504as, emojiInfo, Integer.valueOf(102), Long.valueOf(j)), this.kVd);
                C38876c.m65942hF(6);
            } else if (C5046bo.isNullOrNil(c23504as.nuk)) {
                this.kVk.remove(c23504as.cvZ);
                LinkedList linkedList = new LinkedList();
                linkedList.add(c23504as.cvZ);
                C1720g.m3535RO().eJo.mo14541a(new C27737e(linkedList), 0);
                C4990ab.m7417i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", c23504as.cvZ);
                C38876c.m65942hF(9);
            } else {
                C42952j.bjW().mo43771a(c23504as.nuk, C20364g.m31466q(dve, c23504as, emojiInfo, Integer.valueOf(100), Long.valueOf(j)), this.kVd);
                C38876c.m65942hF(1);
            }
            if (!C5046bo.isNullOrNil(emojiInfo.field_thumbUrl)) {
                C42952j.bjW().mo43771a(emojiInfo.field_thumbUrl, C20364g.m31466q(emojiInfo.dve() + "_cover", new Object[0]), null);
            }
            AppMethodBeat.m2505o(53040);
            return;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", c23504as.cvZ);
        AppMethodBeat.m2505o(53040);
    }

    /* renamed from: a */
    private static EmojiInfo m31545a(C23504as c23504as) {
        AppMethodBeat.m2504i(53041);
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", c23504as.cvZ);
        EmojiInfo emojiInfo = new EmojiInfo();
        C23504as.m36332a(c23504as, emojiInfo);
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.zZd;
        emojiInfo.field_catalog = EmojiInfo.yau;
        C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiInfo);
        AppMethodBeat.m2505o(53041);
        return emojiInfo;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53042);
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C38882r) {
            if (this.kVh.size() <= 0) {
                this.kVg = false;
                AppMethodBeat.m2505o(53042);
                return;
            }
            int i3;
            C2936b c2936b;
            C2936b c2936b2 = (C2936b) this.kVh.remove(0);
            if (i == 0 && i2 == 0) {
                i3 = 2;
            } else {
                C7053e.pXa.mo8378a(111, 35, 1, true);
                i3 = 5;
            }
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c2936b2.cvx);
            jf.setStatus(i3);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c2936b2.cvx, jf);
            if (this.kVh.size() > 0) {
                c2936b = (C2936b) this.kVh.get(0);
                C1720g.m3535RO().eJo.mo14541a(new C38882r(c2936b.czD, c2936b.toUserName, c2936b.cuc, c2936b.cvx), 0);
            } else {
                this.kVg = false;
                c2936b = c2936b2;
            }
            if (this.kVi == null) {
                this.kVi = new C37799sq();
            }
            this.kVi.cOO.cwg = c2936b.cuc.field_groupId;
            C4879a.xxA.mo10055m(this.kVi);
        }
        AppMethodBeat.m2505o(53042);
    }

    /* renamed from: a */
    private long m31544a(C23504as c23504as, EmojiInfo emojiInfo, C1197a c1197a) {
        long j;
        boolean z;
        AppMethodBeat.m2504i(53043);
        C4990ab.m7417i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", c23504as.cvZ, emojiInfo.field_md5, Long.valueOf(c23504as.cKK));
        if (c23504as.cKK != 0) {
            C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(c23504as.talker, c23504as.cKK);
            if (Q.field_msgSvrId == c23504as.cKK) {
                j = Q.field_msgId;
                AppMethodBeat.m2505o(53043);
                return j;
            }
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c23504as.talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            C7616ad c7616ad = new C7616ad(c23504as.talker);
            c7616ad.setType(2);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(c7616ad);
        }
        C7620bi c7620bi = new C7620bi();
        c7620bi.setType(47);
        c7620bi.mo14794ju(c23504as.talker);
        c7620bi.mo14781hO(C1853r.m3858mG(c23504as.fWW) ? 1 : 0);
        c7620bi.mo14795jv(emojiInfo.mo20410Aq());
        c7620bi.mo14774eI(c23504as.cKK);
        String str = c23504as.fWW;
        if (emojiInfo.mo48552xy() || emojiInfo.isGif()) {
            z = false;
        } else {
            z = true;
        }
        c7620bi.setContent(C44218ap.m79810a(str, 0, z, emojiInfo.mo20410Aq(), false, c23504as.xYg));
        c7620bi.mo14775eJ(C1829bf.m3764q(c7620bi.field_talker, c23504as.createTime));
        c7620bi.setStatus(3);
        if (!C5046bo.isNullOrNil(c23504as.dqJ)) {
            c7620bi.mo14791ix(c23504as.dqJ);
        }
        if (c1197a == null) {
            int i = c23504as.dqI;
            if (i != 0) {
                c7620bi.mo14783hY(i);
                if (c7620bi.field_msgId == 0 && c7620bi.field_isSend == 0 && (i & 2) != 0) {
                    c7620bi.mo14775eJ(c23504as.createTime);
                }
            }
            if (c23504as.gag != 0) {
                c7620bi.mo14777eL((long) c23504as.gag);
            }
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i), Integer.valueOf(c23504as.gag));
        } else {
            C1829bf.m3743a(c7620bi, c1197a);
        }
        if (this.kVf != null && this.kVf.containsKey(Long.valueOf(c7620bi.field_msgSvrId))) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
            c7620bi.setContent((String) this.kVf.get(Long.valueOf(c7620bi.field_msgSvrId)));
            c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            this.kVf.remove(Long.valueOf(c7620bi.field_msgSvrId));
        }
        j = C1829bf.m3752l(c7620bi);
        if (!C1853r.m3858mG(c23504as.fWW)) {
            C20378d.m31548hG(j);
        }
        AppMethodBeat.m2505o(53043);
        return j;
    }

    /* renamed from: b */
    static void m31547b(C23504as c23504as) {
        AppMethodBeat.m2504i(53044);
        if (c23504as == null) {
            AppMethodBeat.m2505o(53044);
            return;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15289a(new C3460c(c23504as.talker, "update", null));
        AppMethodBeat.m2505o(53044);
    }
}
