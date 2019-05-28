package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.c;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d implements f {
    c kVd = new c() {
        /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean z, Object... objArr) {
            AppMethodBeat.i(53033);
            if (objArr == null || objArr.length < 4) {
                ab.w("MicroMsg.emoji.EmojiService", "extra obj error");
                AppMethodBeat.o(53033);
                return;
            }
            as asVar;
            EmojiInfo emojiInfo;
            int intValue = ((Integer) objArr[2]).intValue();
            if (objArr[0] instanceof as) {
                asVar = (as) objArr[0];
            } else {
                asVar = null;
            }
            if (objArr[1] instanceof EmojiInfo) {
                emojiInfo = (EmojiInfo) objArr[1];
            } else {
                emojiInfo = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (asVar == null || emojiInfo == null) {
                ab.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                AppMethodBeat.o(53033);
                return;
            }
            d.this.kVk.remove(asVar.cvZ);
            if (emojiInfo.field_state == EmojiInfo.zZd) {
                ab.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                emojiInfo.field_state = EmojiInfo.zZb;
                ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
            }
            ab.i("MicroMsg.emoji.EmojiService", "download finish %s, success %b", emojiInfo.Aq(), Boolean.valueOf(z));
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
                    if (e.asZ(str2) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            z2 = com.tencent.mm.a.a.g(Base64.encodeToString(bo.anf(asVar.aeskey), 0), str2, dve);
                            if (z2) {
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.hF(11);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.hF(7);
                                }
                                ab.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dve);
                                if (z2) {
                                    str = "MicroMsg.emoji.EmojiService";
                                    dve = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr2 = new Object[6];
                                    objArr2[0] = emojiInfo == null ? "" : emojiInfo.Aq();
                                    objArr2[1] = Long.valueOf(e.asZ(str2));
                                    objArr2[2] = e.atg(str2) == null ? "" : e.atg(str2);
                                    objArr2[3] = emojiInfo == null ? "" : emojiInfo.field_aeskey;
                                    objArr2[4] = emojiInfo == null ? "" : emojiInfo.field_encrypturl;
                                    objArr2[5] = asVar == null ? "" : asVar.xYg;
                                    ab.i(str, dve, objArr2);
                                    if (d.this.kVj != null) {
                                        d.this.kVj.a(false, emojiInfo);
                                    }
                                    if (intValue == 101) {
                                        com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 0, 1, asVar.cwg, 1, asVar.xYh);
                                    } else {
                                        com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 3, 0, 1, asVar.cwg, 1, asVar.xYh);
                                    }
                                    e.deleteFile(str2);
                                    d.b(asVar);
                                    AppMethodBeat.o(53033);
                                    return;
                                }
                                e.deleteFile(str2);
                            } else {
                                if (intValue == 101) {
                                    com.tencent.mm.plugin.emoji.c.hF(12);
                                } else {
                                    com.tencent.mm.plugin.emoji.c.hF(8);
                                }
                                ab.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dve);
                                if (z2) {
                                }
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", bo.l(e));
                            if (intValue == 101) {
                                com.tencent.mm.plugin.emoji.c.hF(12);
                            } else {
                                com.tencent.mm.plugin.emoji.c.hF(8);
                            }
                        }
                    } else {
                        ab.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", emojiInfo.Aq());
                        if (d.this.kVj != null) {
                            d.this.kVj.a(false, emojiInfo);
                        }
                        if (intValue == 101) {
                            com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 1, 1, asVar.cwg, 1, asVar.xYh);
                        } else {
                            com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 3, 1, 1, asVar.cwg, 1, asVar.xYh);
                        }
                        d.b(asVar);
                        AppMethodBeat.o(53033);
                        return;
                    }
                }
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dve);
                String Aq;
                if (e.asZ(dve) > 0) {
                    dve = e.atg(j.w(bVar.mUri));
                    Aq = emojiInfo.Aq();
                    if (intValue == 101) {
                        Aq = emojiInfo.field_externMd5;
                    }
                    if (bo.isNullOrNil(dve) || !dve.equalsIgnoreCase(Aq)) {
                        String str3 = "MicroMsg.emoji.EmojiService";
                        String str4 = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                        Object[] objArr3 = new Object[3];
                        objArr3[0] = dve;
                        objArr3[1] = emojiInfo == null ? "" : emojiInfo.Aq();
                        objArr3[2] = emojiInfo == null ? "" : emojiInfo.field_cdnUrl;
                        ab.i(str3, str4, objArr3);
                        if (d.this.kVj != null) {
                            d.this.kVj.a(false, emojiInfo);
                        }
                        bVar.delete();
                        d.b(asVar);
                        if (intValue == 101) {
                            com.tencent.mm.plugin.emoji.c.hF(14);
                            com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 0, 1, asVar.cwg, 0, asVar.xYh);
                            AppMethodBeat.o(53033);
                            return;
                        } else if (intValue == 102) {
                            com.tencent.mm.plugin.emoji.c.hF(5);
                            com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 3, 0, 1, asVar.cwg, 1, asVar.xYh);
                            AppMethodBeat.o(53033);
                            return;
                        } else {
                            com.tencent.mm.plugin.emoji.c.hF(5);
                            com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 2, 0, 1, asVar.cwg, 1, asVar.xYh);
                            AppMethodBeat.o(53033);
                            return;
                        }
                    }
                    if (intValue == 101) {
                        com.tencent.mm.plugin.emoji.c.hF(13);
                        com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 0, 0, asVar.cwg, 0, asVar.xYh);
                    } else if (intValue == 102) {
                        com.tencent.mm.plugin.emoji.c.hF(4);
                        com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 3, 0, 0, asVar.cwg, 0, asVar.xYh);
                    } else {
                        com.tencent.mm.plugin.emoji.c.hF(4);
                        com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 2, 0, 0, asVar.cwg, 1, asVar.xYh);
                    }
                    com.tencent.mm.plugin.emoji.e.f.bjK().c(emojiInfo, true);
                    if (d.this.kVj != null) {
                        d.this.kVj.a(true, emojiInfo);
                    }
                    d.b(asVar);
                    AppMethodBeat.o(53033);
                    return;
                }
                str = "MicroMsg.emoji.EmojiService";
                dve = "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s";
                objArr2 = new Object[2];
                objArr2[0] = emojiInfo == null ? "" : emojiInfo.Aq();
                if (emojiInfo == null) {
                    Aq = "";
                } else {
                    Aq = emojiInfo.field_cdnUrl;
                }
                objArr2[1] = Aq;
                ab.i(str, dve, objArr2);
                if (d.this.kVj != null) {
                    d.this.kVj.a(false, emojiInfo);
                }
                if (intValue == 101) {
                    com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 1, 1, asVar.cwg, 1, asVar.xYh);
                    com.tencent.mm.plugin.emoji.c.hF(3);
                } else {
                    com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 2, 1, 1, asVar.cwg, 1, asVar.xYh);
                    com.tencent.mm.plugin.emoji.c.hF(3);
                }
                d.b(asVar);
                AppMethodBeat.o(53033);
                return;
            }
            ab.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", emojiInfo.Aq());
            if (d.this.kVj != null) {
                d.this.kVj.a(false, emojiInfo);
            }
            if (intValue == 101) {
                com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 4, 1, 1, asVar.cwg, 1, asVar.xYh);
                com.tencent.mm.plugin.emoji.c.hF(3);
            } else {
                com.tencent.mm.plugin.emoji.c.a(asVar.cvZ, 2, 1, 1, asVar.cwg, 1, asVar.xYh);
                com.tencent.mm.plugin.emoji.c.hF(3);
            }
            d.b(asVar);
            AppMethodBeat.o(53033);
        }
    };
    public HashMap<Long, String> kVf = new HashMap();
    private boolean kVg = false;
    List<b> kVh = new LinkedList();
    private sq kVi;
    public a kVj;
    List kVk = Collections.synchronizedList(new ArrayList());

    class b {
        EmojiInfo cuc;
        long cvx;
        String czD;
        String toUserName;

        public b(long j, String str, EmojiInfo emojiInfo, String str2) {
            this.cvx = j;
            this.toUserName = str;
            this.cuc = emojiInfo;
            this.czD = str2;
        }
    }

    public interface a {
        void a(boolean z, EmojiInfo emojiInfo);
    }

    public d() {
        AppMethodBeat.i(53034);
        g.RO().eJo.a((int) ErrorCode.NEEDDOWNLOAD_FALSE_5, (f) this);
        AppMethodBeat.o(53034);
    }

    private static void hG(long j) {
        AppMethodBeat.i(53035);
        ((aq) ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(j));
        AppMethodBeat.o(53035);
    }

    public final void a(String str, EmojiInfo emojiInfo, bi biVar) {
        AppMethodBeat.i(53036);
        if (bo.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.o(53036);
            return;
        }
        long Z;
        long j;
        if (e.asZ(emojiInfo.dve()) <= 0) {
            emojiInfo.field_state = EmojiInfo.zYZ;
            j.getEmojiStorageMgr().xYn.G(emojiInfo);
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (com.tencent.mm.plugin.emoji.h.b.w(emojiInfo)) {
            z = j.bkm().Js(emojiInfo.field_groupId);
            ab.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", Boolean.valueOf(z));
        } else {
            j.bkm().bkc();
        }
        if (biVar == null) {
            bi biVar2 = new bi();
            if (emojiInfo.field_type == EmojiInfo.zYX || emojiInfo.field_type == EmojiInfo.zYY) {
                biVar2.setType(1048625);
            } else {
                biVar2.setType(47);
            }
            biVar2.ju(str);
            biVar2.hO(1);
            String Yz = r.Yz();
            boolean z2 = (emojiInfo.xy() || emojiInfo.isGif()) ? false : true;
            biVar2.setContent(ap.a(Yz, currentTimeMillis, z2, emojiInfo.Aq(), z, ""));
            biVar2.jv(emojiInfo.Aq());
            biVar2.eJ(bf.oC(biVar2.field_talker));
            Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar2);
            j = currentTimeMillis;
        } else {
            long j2 = biVar.field_msgId;
            ap aps = ap.aps(biVar.field_content);
            if (aps.time == 0) {
                AppMethodBeat.o(53036);
                return;
            } else {
                Z = j2;
                j = aps.time;
            }
        }
        ab.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = %s, md5 %s, len %s", Long.valueOf(Z), emojiInfo.Aq(), Integer.valueOf(emojiInfo.field_size));
        this.kVh.add(new b(Z, str, emojiInfo, String.valueOf(j)));
        if (!this.kVg || this.kVh.size() == 1) {
            this.kVg = true;
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.r(String.valueOf(j), str, emojiInfo, Z), 0);
        }
        JC(emojiInfo.field_groupId);
        AppMethodBeat.o(53036);
    }

    public final void JC(final String str) {
        AppMethodBeat.i(53037);
        g.RS().aa(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:5:0x0038  */
            /* JADX WARNING: Missing block: B:11:0x005d, code skipped:
            if ((r6 - r4) >= 3600000) goto L_0x0036;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int i = 1;
                AppMethodBeat.i(53031);
                com.tencent.mm.storage.emotion.c cVar = j.getEmojiStorageMgr().xYp;
                String str = str;
                if (com.tencent.mm.plugin.emoji.h.b.JX(str)) {
                    long j = cVar.yaX.getLong("274544".concat(String.valueOf(str)), 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j < 86400000) {
                        if (!cVar.aqh(str)) {
                        }
                    }
                    if (i != 0) {
                        j.bki();
                        String str2 = str;
                        if (bo.isNullOrNil(str2)) {
                            ab.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
                            AppMethodBeat.o(53031);
                            return;
                        }
                        g.RO().eJo.a(new k(str2), 0);
                    }
                    AppMethodBeat.o(53031);
                }
                i = 0;
                if (i != 0) {
                }
                AppMethodBeat.o(53031);
            }
        });
        AppMethodBeat.o(53037);
    }

    public final boolean s(EmojiInfo emojiInfo) {
        AppMethodBeat.i(53038);
        as D = as.D(emojiInfo);
        if (D == null) {
            ab.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.o(53038);
        } else {
            D.talker = emojiInfo == null ? "" : emojiInfo.talker;
            D.xYk = false;
            a(D, null, true);
            JC(emojiInfo == null ? null : emojiInfo.field_groupId);
            AppMethodBeat.o(53038);
        }
        return true;
    }

    public final void a(as asVar, com.tencent.mm.ai.e.a aVar, boolean z) {
        AppMethodBeat.i(53039);
        if (asVar == null) {
            ab.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            AppMethodBeat.o(53039);
            return;
        }
        EmojiInfo emojiInfo;
        if (!(aVar == null || aVar.eAB == null || aVar.eAB.ptF != asVar.cKK)) {
            asVar.dqI = bf.d(aVar);
            asVar.gag = aVar.eAB.vEI;
            asVar.createTime = (long) aVar.eAB.pcX;
        }
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(asVar.cvZ);
        String str = "MicroMsg.emoji.EmojiService";
        String str2 = "downloadEmoji: db emoji null %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(aqi == null);
        ab.i(str, str2, objArr);
        if (aqi != null) {
            int i;
            ab.i("MicroMsg.emoji.EmojiService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", aqi.field_md5, asVar.cvZ, Long.valueOf(asVar.cKK));
            if (bo.isNullOrNil(asVar.cwg) || asVar.cwg.equals(aqi.field_groupId)) {
                i = 0;
            } else {
                aqi.field_groupId = asVar.cwg;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.xYh) || asVar.xYh.equals(aqi.field_designerID))) {
                aqi.field_designerID = asVar.xYh;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.thumbUrl) || asVar.thumbUrl.equals(aqi.field_thumbUrl))) {
                aqi.field_thumbUrl = asVar.thumbUrl;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.cAp) || asVar.cAp.equals(aqi.field_encrypturl))) {
                aqi.field_encrypturl = asVar.cAp;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.aeskey) || asVar.aeskey.equals(aqi.field_aeskey))) {
                aqi.field_aeskey = asVar.aeskey;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.nuk) || asVar.nuk.equals(aqi.field_cdnUrl))) {
                aqi.field_cdnUrl = asVar.nuk;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.fgu) || asVar.fgu.equals(aqi.field_tpurl))) {
                aqi.field_tpurl = asVar.fgu;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.fgA) || asVar.fgA.equals(aqi.field_tpauthkey))) {
                aqi.field_tpauthkey = asVar.fgA;
                i = 1;
            }
            if (asVar.width > 0 && asVar.width != aqi.field_width) {
                aqi.field_width = asVar.width;
                i = 1;
            }
            if (asVar.height > 0 && asVar.height != aqi.field_height) {
                aqi.field_height = asVar.height;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.xYi) || asVar.xYi.equals(aqi.field_externUrl))) {
                aqi.field_externUrl = asVar.xYi;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.xYj) || asVar.xYj.equals(aqi.field_externMd5))) {
                aqi.field_externMd5 = asVar.xYj;
                i = 1;
            }
            if (!(bo.isNullOrNil(asVar.xYl) || asVar.xYl.equalsIgnoreCase(aqi.field_activityid))) {
                aqi.field_activityid = asVar.xYl;
                i = 1;
            }
            if (aqi.field_state == EmojiInfo.zZb && e.asZ(aqi.dve()) <= 0) {
                ab.i("MicroMsg.emoji.EmojiService", "emoji %s complete but file not exist", aqi.Aq());
                aqi.field_state = EmojiInfo.zZd;
                i = 1;
            }
            if (!bo.isNullOrNil(asVar.eyJ)) {
                aqi.field_attachedText = asVar.eyJ;
                i = 1;
            }
            if (!bo.isNullOrNil(asVar.lgY)) {
                aqi.field_lensId = asVar.lgY;
                i = 1;
            }
            if (!bo.isNullOrNil(asVar.xYm)) {
                aqi.field_attachTextColor = asVar.xYm;
                i = 1;
            }
            if (aqi.field_width <= 0 || aqi.field_height <= 0) {
                aqi.field_width = asVar.width;
                aqi.field_height = asVar.height;
                i = 1;
            }
            if (i != 0) {
                j.getEmojiStorageMgr().xYn.G(aqi);
                ab.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", aqi.field_designerID, aqi.field_thumbUrl);
            }
            emojiInfo = aqi;
        } else {
            ab.i("MicroMsg.emoji.EmojiService", "downloadEmoji: create emoji info %s", asVar.cvZ);
            emojiInfo = a(asVar);
        }
        long j = 0;
        if (asVar.xYk) {
            emojiInfo.duP();
            j = a(asVar, emojiInfo, aVar);
        }
        ab.i("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", emojiInfo.Aq(), Boolean.valueOf(emojiInfo.duP()), Boolean.valueOf(z));
        if (!emojiInfo.duP()) {
            if (z) {
                a(asVar, emojiInfo, j);
                AppMethodBeat.o(53039);
                return;
            }
            ab.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", Boolean.valueOf(z));
            this.kVk.remove(asVar.cvZ);
            b(asVar);
        }
        AppMethodBeat.o(53039);
    }

    private void a(as asVar, EmojiInfo emojiInfo, long j) {
        AppMethodBeat.i(53040);
        if (this.kVk == null || !this.kVk.contains(asVar.cvZ)) {
            this.kVk.add(asVar.cvZ);
            String dve = emojiInfo.dve();
            if (!bo.isNullOrNil(asVar.fgu)) {
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.field_mediaId = "downemoj_" + com.tencent.mm.a.g.x(asVar.fgu.getBytes()).substring(0, 16) + "_" + asVar.cKK;
                gVar.field_fullpath = dve + "_openim";
                gVar.field_fileType = 19;
                gVar.field_authKey = emojiInfo.field_tpauthkey;
                gVar.egm = emojiInfo.field_tpurl;
                gVar.field_priority = com.tencent.mm.i.a.efC;
                final as asVar2 = asVar;
                final EmojiInfo emojiInfo2 = emojiInfo;
                final long j2 = j;
                gVar.egl = new com.tencent.mm.i.g.a() {
                    public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                        AppMethodBeat.i(53032);
                        if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                            d.this.kVd.a(true, asVar2, emojiInfo2, Integer.valueOf(103), Long.valueOf(j2));
                        }
                        AppMethodBeat.o(53032);
                        return 0;
                    }

                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    public final byte[] l(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                    ab.e("MicroMsg.emoji.EmojiService", "recv openim emoj, add task failed");
                }
            } else if (com.tencent.mm.emoji.a.e.OQ() && com.tencent.mm.emoji.a.e.OR() && !bo.isNullOrNil(emojiInfo.field_externUrl) && !bo.isNullOrNil(emojiInfo.field_externMd5)) {
                j.bjW().a(asVar.xYi, com.tencent.mm.plugin.emoji.e.g.r(dve + "_extern", asVar, emojiInfo, Integer.valueOf(101), Long.valueOf(j)), this.kVd);
                com.tencent.mm.plugin.emoji.c.hF(10);
            } else if (!bo.isNullOrNil(asVar.cAp) && !bo.isNullOrNil(asVar.aeskey)) {
                j.bjW().a(asVar.cAp, com.tencent.mm.plugin.emoji.e.g.r(dve + "_encrypt", asVar, emojiInfo, Integer.valueOf(102), Long.valueOf(j)), this.kVd);
                com.tencent.mm.plugin.emoji.c.hF(6);
            } else if (bo.isNullOrNil(asVar.nuk)) {
                this.kVk.remove(asVar.cvZ);
                LinkedList linkedList = new LinkedList();
                linkedList.add(asVar.cvZ);
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                ab.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", asVar.cvZ);
                com.tencent.mm.plugin.emoji.c.hF(9);
            } else {
                j.bjW().a(asVar.nuk, com.tencent.mm.plugin.emoji.e.g.q(dve, asVar, emojiInfo, Integer.valueOf(100), Long.valueOf(j)), this.kVd);
                com.tencent.mm.plugin.emoji.c.hF(1);
            }
            if (!bo.isNullOrNil(emojiInfo.field_thumbUrl)) {
                j.bjW().a(emojiInfo.field_thumbUrl, com.tencent.mm.plugin.emoji.e.g.q(emojiInfo.dve() + "_cover", new Object[0]), null);
            }
            AppMethodBeat.o(53040);
            return;
        }
        ab.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", asVar.cvZ);
        AppMethodBeat.o(53040);
    }

    private static EmojiInfo a(as asVar) {
        AppMethodBeat.i(53041);
        ab.i("MicroMsg.emoji.EmojiService", "createEmojiInfo: %s", asVar.cvZ);
        EmojiInfo emojiInfo = new EmojiInfo();
        as.a(asVar, emojiInfo);
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.zZd;
        emojiInfo.field_catalog = EmojiInfo.yau;
        j.getEmojiStorageMgr().xYn.E(emojiInfo);
        AppMethodBeat.o(53041);
        return emojiInfo;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53042);
        ab.i("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof com.tencent.mm.plugin.emoji.f.r) {
            if (this.kVh.size() <= 0) {
                this.kVg = false;
                AppMethodBeat.o(53042);
                return;
            }
            int i3;
            b bVar;
            b bVar2 = (b) this.kVh.remove(0);
            if (i == 0 && i2 == 0) {
                i3 = 2;
            } else {
                com.tencent.mm.plugin.report.e.pXa.a(111, 35, 1, true);
                i3 = 5;
            }
            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(bVar2.cvx);
            jf.setStatus(i3);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(bVar2.cvx, jf);
            if (this.kVh.size() > 0) {
                bVar = (b) this.kVh.get(0);
                g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.r(bVar.czD, bVar.toUserName, bVar.cuc, bVar.cvx), 0);
            } else {
                this.kVg = false;
                bVar = bVar2;
            }
            if (this.kVi == null) {
                this.kVi = new sq();
            }
            this.kVi.cOO.cwg = bVar.cuc.field_groupId;
            com.tencent.mm.sdk.b.a.xxA.m(this.kVi);
        }
        AppMethodBeat.o(53042);
    }

    private long a(as asVar, EmojiInfo emojiInfo, com.tencent.mm.ai.e.a aVar) {
        long j;
        boolean z;
        AppMethodBeat.i(53043);
        ab.i("MicroMsg.emoji.EmojiService", "insertEmojiMsg: %s, %s msgSvrId: %s", asVar.cvZ, emojiInfo.field_md5, Long.valueOf(asVar.cKK));
        if (asVar.cKK != 0) {
            bi Q = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Q(asVar.talker, asVar.cKK);
            if (Q.field_msgSvrId == asVar.cKK) {
                j = Q.field_msgId;
                AppMethodBeat.o(53043);
                return j;
            }
        }
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(asVar.talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            ad adVar = new ad(asVar.talker);
            adVar.setType(2);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().Z(adVar);
        }
        bi biVar = new bi();
        biVar.setType(47);
        biVar.ju(asVar.talker);
        biVar.hO(r.mG(asVar.fWW) ? 1 : 0);
        biVar.jv(emojiInfo.Aq());
        biVar.eI(asVar.cKK);
        String str = asVar.fWW;
        if (emojiInfo.xy() || emojiInfo.isGif()) {
            z = false;
        } else {
            z = true;
        }
        biVar.setContent(ap.a(str, 0, z, emojiInfo.Aq(), false, asVar.xYg));
        biVar.eJ(bf.q(biVar.field_talker, asVar.createTime));
        biVar.setStatus(3);
        if (!bo.isNullOrNil(asVar.dqJ)) {
            biVar.ix(asVar.dqJ);
        }
        if (aVar == null) {
            int i = asVar.dqI;
            if (i != 0) {
                biVar.hY(i);
                if (biVar.field_msgId == 0 && biVar.field_isSend == 0 && (i & 2) != 0) {
                    biVar.eJ(asVar.createTime);
                }
            }
            if (asVar.gag != 0) {
                biVar.eL((long) asVar.gag);
            }
            ab.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i), Integer.valueOf(asVar.gag));
        } else {
            bf.a(biVar, aVar);
        }
        if (this.kVf != null && this.kVf.containsKey(Long.valueOf(biVar.field_msgSvrId))) {
            ab.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
            biVar.setContent((String) this.kVf.get(Long.valueOf(biVar.field_msgSvrId)));
            biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            this.kVf.remove(Long.valueOf(biVar.field_msgSvrId));
        }
        j = bf.l(biVar);
        if (!r.mG(asVar.fWW)) {
            hG(j);
        }
        AppMethodBeat.o(53043);
        return j;
    }

    static void b(as asVar) {
        AppMethodBeat.i(53044);
        if (asVar == null) {
            AppMethodBeat.o(53044);
            return;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(new h.c(asVar.talker, "update", null));
        AppMethodBeat.o(53044);
    }
}
