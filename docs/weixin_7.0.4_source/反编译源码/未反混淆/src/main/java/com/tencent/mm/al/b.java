package com.tencent.mm.al;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements f, com.tencent.mm.i.b, a, com.tencent.mm.sdk.e.n.b {
    private int fyG = -1;
    ak fyH = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(78030);
            if (at.isConnected(ah.getContext())) {
                ab.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
                h.pYm.a(546, 5, 1, true);
                BaseEvent.onNetworkChange();
            }
            AppMethodBeat.o(78030);
        }
    };
    private c<jm> fyI = new c<jm>() {
        {
            AppMethodBeat.i(78031);
            this.xxI = jm.class.getName().hashCode();
            AppMethodBeat.o(78031);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(78032);
            if (at.isConnected(ah.getContext())) {
                ab.i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
                b.this.fyH.removeMessages(1);
                b.this.fyH.sendEmptyMessageDelayed(1, 10000);
            }
            AppMethodBeat.o(78032);
            return false;
        }
    };
    private n fyJ = new n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(78033);
            ab.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            if (i != 4 && i != 6) {
                AppMethodBeat.o(78033);
            } else if (g.RN().QY()) {
                b.this.fyH.removeMessages(1);
                BaseEvent.onNetworkChange();
                AppMethodBeat.o(78033);
            } else {
                AppMethodBeat.o(78033);
            }
        }
    };
    Queue<String> fyK = new LinkedList();
    public Map<String, com.tencent.mm.i.g> fyL = new HashMap();
    public Map<String, com.tencent.mm.i.g> fyM = new ConcurrentHashMap();
    public Map<String, Integer> fyN = new HashMap();
    private String fyO = "";
    private long fyP = 0;
    public HashSet<String> fyQ = new HashSet();

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(78043);
        if (g.RN().QY()) {
            int g = bo.g(obj, 0);
            ab.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
            if (nVar != g.RP().Ry() || g <= 0) {
                ab.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
                AppMethodBeat.o(78043);
                return;
            } else if (g != 144385) {
                AppMethodBeat.o(78043);
                return;
            } else {
                f.afu().li(10);
                AppMethodBeat.o(78043);
                return;
            }
        }
        AppMethodBeat.o(78043);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(78044);
        if (mVar.getType() != 379) {
            AppMethodBeat.o(78044);
            return;
        }
        ab.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (g.RN().QY()) {
            d.xDH.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78034);
                    b.this.cK(true);
                    AppMethodBeat.o(78034);
                }

                public final String toString() {
                    AppMethodBeat.i(78035);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(78035);
                    return str;
                }
            }, "MicroMsg.CdnTransportService");
        }
        AppMethodBeat.o(78044);
    }

    public static boolean lg(int i) {
        AppMethodBeat.i(78045);
        g.RN();
        if (com.tencent.mm.kernel.a.QX()) {
            ab.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", Integer.valueOf(r0), Integer.valueOf(i), Integer.valueOf(bo.a((Integer) g.RP().Ry().get(144385, null), 0) & i), Boolean.valueOf(ae.git));
            if (ae.git) {
                AppMethodBeat.o(78045);
                return true;
            } else if ((r0 & i) > 0) {
                AppMethodBeat.o(78045);
                return true;
            } else {
                AppMethodBeat.o(78045);
                return false;
            }
        }
        AppMethodBeat.o(78045);
        return true;
    }

    public b() {
        AppMethodBeat.i(78046);
        g.RO().a(this.fyJ);
        if (g.RN().QY()) {
            g.RP().Ry().a(this);
        }
        g.Rg().a(379, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.fyI);
        ab.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", Integer.valueOf(hashCode()), bo.dpG());
        AppMethodBeat.o(78046);
    }

    public final void release() {
        AppMethodBeat.i(78047);
        if (g.RN().QY()) {
            g.RP().Ry().b(this);
        }
        this.fyH.removeCallbacksAndMessages(null);
        g.RO().b(this.fyJ);
        g.RO().eJo.b(379, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.fyI);
        AppMethodBeat.o(78047);
    }

    public final void lh(int i) {
        this.fyG = i;
    }

    public final boolean b(final com.tencent.mm.i.g gVar, final int i) {
        AppMethodBeat.i(78048);
        if (gVar == null) {
            ab.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            AppMethodBeat.o(78048);
            return false;
        } else if (bo.isNullOrNil(gVar.field_mediaId)) {
            ab.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            AppMethodBeat.o(78048);
            return false;
        } else {
            if (gVar.field_fileId == null) {
                gVar.field_fileId = "";
            }
            if (gVar.field_aesKey == null) {
                gVar.field_aesKey = "";
            }
            gVar.cRY = false;
            d.xDH.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(78036);
                    if (i != -1) {
                        b.this.fyN.put(gVar.field_mediaId, Integer.valueOf(i));
                    }
                    ab.i("MicroMsg.CdnTransportService", "CdnTransportService replacePizzaWorkerExecute run %s", gVar.field_mediaId);
                    b.this.fyK.add(gVar.field_mediaId);
                    b.this.fyL.put(gVar.field_mediaId, gVar);
                    b.this.cK(false);
                    AppMethodBeat.o(78036);
                }

                public final String toString() {
                    AppMethodBeat.i(78037);
                    String str = super.toString() + "|addRecvTask";
                    AppMethodBeat.o(78037);
                    return str;
                }
            }, "MicroMsg.CdnTransportService");
            AppMethodBeat.o(78048);
            return true;
        }
    }

    public final boolean d(com.tencent.mm.i.g gVar) {
        AppMethodBeat.i(78049);
        boolean b = b(gVar, -1);
        AppMethodBeat.o(78049);
        return b;
    }

    public final boolean e(final com.tencent.mm.i.g gVar) {
        AppMethodBeat.i(78050);
        if (bo.isNullOrNil(gVar.field_mediaId)) {
            ab.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            AppMethodBeat.o(78050);
            return false;
        }
        if (gVar.field_fileId == null) {
            gVar.field_fileId = "";
        }
        if (gVar.field_aesKey == null) {
            gVar.field_aesKey = "";
        }
        gVar.cRY = true;
        d.xDH.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78038);
                b.this.fyK.add(gVar.field_mediaId);
                b.this.fyL.put(gVar.field_mediaId, gVar);
                b.this.cK(false);
                AppMethodBeat.o(78038);
            }

            public final String toString() {
                AppMethodBeat.i(78039);
                String str = super.toString() + "|addSendTask";
                AppMethodBeat.o(78039);
                return str;
            }
        }, "MicroMsg.CdnTransportService");
        AppMethodBeat.o(78050);
        return true;
    }

    public final boolean rN(String str) {
        AppMethodBeat.i(78051);
        if (((com.tencent.mm.i.g) this.fyM.remove(str)) != null) {
            f.afy();
            a.rF(str);
            h.pYm.e(10769, Integer.valueOf(c.fzh), Integer.valueOf(r0.field_fileType), Long.valueOf(bo.anU() - r0.field_startTime));
        }
        this.fyL.remove(str);
        ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        AppMethodBeat.o(78051);
        return true;
    }

    public final boolean rO(String str) {
        AppMethodBeat.i(78052);
        com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) this.fyM.remove(str);
        if (gVar != null) {
            if (gVar.field_fileType == com.tencent.mm.i.a.efP || gVar.field_fileType == com.tencent.mm.i.a.efR) {
                f.afy();
                a.rK(str);
            } else if (gVar.egs) {
                f.afy();
                a.rL(str);
            } else {
                f.afy();
                a.rG(str);
            }
            h.pYm.e(10769, Integer.valueOf(c.fzg), Integer.valueOf(gVar.field_fileType), Long.valueOf(bo.anU() - gVar.field_startTime));
        }
        this.fyL.remove(str);
        this.fyN.remove(str);
        ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, gVar, Integer.valueOf(0));
        AppMethodBeat.o(78052);
        return true;
    }

    public final void cK(boolean z) {
        AppMethodBeat.i(78053);
        if (!z && f.afy().afq()) {
            g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                ab.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                f.afu().li(4);
                AppMethodBeat.o(78053);
                return;
            }
        }
        afs();
        ab.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.fyK.size()));
        while (!this.fyK.isEmpty()) {
            com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) this.fyL.remove((String) this.fyK.poll());
            if (gVar == null) {
                ab.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                AppMethodBeat.o(78053);
                return;
            }
            ab.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", gVar.field_mediaId, Boolean.valueOf(gVar.field_autostart), Integer.valueOf(gVar.field_chattype));
            gVar.field_startTime = bo.anU();
            String str;
            int i;
            com.tencent.mm.i.g gVar2;
            int b;
            String str2;
            Object[] objArr;
            if (gVar.cRY) {
                String str3;
                String str4 = "MicroMsg.CdnTransportService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]";
                Object[] objArr2 = new Object[8];
                if (gVar.field_fullpath == null) {
                    i = -1;
                } else {
                    i = gVar.field_fullpath.length();
                }
                objArr2[0] = Integer.valueOf(i);
                if (gVar.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = gVar.field_thumbpath.length();
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = bo.anv(gVar.field_svr_signature);
                objArr2[3] = bo.anv(gVar.field_aesKey);
                objArr2[4] = Integer.valueOf(gVar.field_fileType);
                objArr2[5] = gVar.field_mediaId;
                objArr2[6] = Boolean.valueOf(gVar.field_onlycheckexist);
                objArr2[7] = Integer.valueOf(gVar.field_largesvideo);
                ab.i(str4, str, objArr2);
                if (gVar.field_fullpath == null) {
                    gVar.field_fullpath = "";
                }
                if (gVar.field_thumbpath == null) {
                    gVar.field_thumbpath = "";
                }
                gVar2 = (com.tencent.mm.i.g) this.fyM.put(gVar.field_mediaId, gVar);
                com.tencent.mm.i.g gVar3 = (com.tencent.mm.i.g) this.fyM.get(gVar.field_mediaId);
                if (gVar3 == null) {
                    h.pYm.a(594, 5, 1, true);
                }
                b = f.afy().b(gVar);
                str4 = "MicroMsg.CdnTransportService";
                str2 = "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                objArr = new Object[5];
                objArr[0] = gVar.field_mediaId;
                objArr[1] = Integer.valueOf(b);
                objArr[2] = gVar2 == null ? null : gVar2.field_mediaId;
                if (gVar3 == null) {
                    str3 = null;
                } else {
                    str3 = gVar3.field_mediaId;
                }
                objArr[3] = str3;
                objArr[4] = Integer.valueOf(hashCode());
                ab.i(str4, str2, objArr);
                if (b != 0) {
                    gVar2 = (com.tencent.mm.i.g) this.fyM.remove(gVar.field_mediaId);
                    ab.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", Integer.valueOf(b), gVar.field_mediaId, gVar2);
                    if (gVar.egl != null) {
                        gVar.egl.a(gVar.field_mediaId, b, null, null, gVar.field_onlycheckexist);
                    }
                }
            } else {
                i = -1;
                int i2;
                if (gVar.field_fileType == CdnLogic.kMediaTypeStoryAudio) {
                    b = f.afy().a(gVar.field_mediaId, gVar.egm, gVar.field_fullpath, gVar.field_fileType, gVar.field_aesKey, gVar.field_authKey);
                } else if (gVar.field_fileType == 19) {
                    b = f.afy().a(gVar.field_mediaId, gVar.egm, gVar.field_fullpath, gVar.field_fileType, gVar.field_aesKey, gVar.field_authKey);
                } else if (gVar.field_fileType == com.tencent.mm.i.a.efP || gVar.field_fileType == com.tencent.mm.i.a.efR) {
                    if (!(gVar.field_fullpath == null || gVar.field_fullpath.isEmpty())) {
                        i = f.afy().a(gVar.field_mediaId, gVar.egm, gVar.field_fullpath, gVar.field_fileType, gVar.egn, gVar.ego, gVar.egp, gVar.egq);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]";
                    objArr = new Object[4];
                    if (gVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = gVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = gVar.field_mediaId;
                    objArr[2] = gVar.egm;
                    objArr[3] = Integer.valueOf(gVar.field_fileType);
                    ab.i(str, str2, objArr);
                    b = i;
                } else if (gVar.egs) {
                    if (!(gVar.field_fullpath == null || gVar.field_fullpath.isEmpty())) {
                        i = f.afy().a(gVar.field_mediaId, gVar.field_fullpath, gVar.egm, gVar.egt, gVar.egu, gVar.allow_mobile_net_download, gVar.egn, gVar.ego, gVar.is_resume_task, gVar.egr, gVar.egp);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr = new Object[4];
                    if (gVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = gVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = gVar.field_mediaId;
                    objArr[2] = gVar.egm;
                    objArr[3] = gVar.egt;
                    ab.i(str, str2, objArr);
                    b = i;
                } else {
                    if (!gVar.egv) {
                        str = "MicroMsg.CdnTransportService";
                        str2 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr = new Object[7];
                        if (gVar.field_fullpath == null) {
                            i2 = -1;
                        } else {
                            i2 = gVar.field_fullpath.length();
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (gVar.field_thumbpath == null) {
                            i2 = -1;
                        } else {
                            i2 = gVar.field_thumbpath.length();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = gVar.field_svr_signature;
                        objArr[3] = gVar.field_aesKey;
                        objArr[4] = Integer.valueOf(gVar.field_fileType);
                        objArr[5] = gVar.field_mediaId;
                        objArr[6] = Boolean.valueOf(gVar.field_onlycheckexist);
                        ab.i(str, str2, objArr);
                        if (gVar.egx != 2) {
                            b = f.afy().c(gVar);
                        } else if (gVar instanceof com.tencent.mm.i.h) {
                            com.tencent.mm.i.h hVar = (com.tencent.mm.i.h) gVar;
                            if (hVar.Jr()) {
                                b = f.afy().a(gVar, 2);
                            } else if (hVar.Jp()) {
                                b = f.afy().a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.egD, hVar.ege, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.field_preloadRatio, hVar.field_requestVideoFormat, 1);
                            } else if (hVar.Jq()) {
                                b = f.afy().a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.egD, hVar.field_preloadRatio, hVar.concurrentCount);
                            } else {
                                if (hVar.Jt()) {
                                    i = f.afy().b(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.egD, hVar.ege, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.field_preloadRatio, hVar.field_requestVideoFormat, hVar.connectionCount);
                                }
                                b = i;
                            }
                        }
                    } else if (gVar instanceof com.tencent.mm.i.f) {
                        b = f.afy().a((com.tencent.mm.i.f) gVar);
                    } else if (gVar instanceof e) {
                        e eVar = (e) gVar;
                        b = f.afy().a(eVar.field_mediaId, eVar.url, eVar.referer, eVar.egd, eVar.ege, eVar.egf, eVar.egg, eVar.egh, eVar.isColdSnsData, eVar.signalQuality, eVar.snsScene, eVar.snsCipherKey, eVar.duk, eVar.egi, eVar.fileType);
                    }
                    b = -1;
                }
                if (b != 0) {
                    ab.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), gVar.field_mediaId);
                    if (gVar.egl != null) {
                        gVar.egl.a(gVar.field_mediaId, b, null, null, gVar.field_onlycheckexist);
                    }
                } else {
                    gVar2 = (com.tencent.mm.i.g) this.fyM.put(gVar.field_mediaId, gVar);
                    com.tencent.mm.i.g gVar4 = (com.tencent.mm.i.g) this.fyM.get(gVar.field_mediaId);
                    if (gVar4 == null) {
                        h.pYm.a(594, 6, 1, true);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    String str5 = "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = gVar.field_mediaId;
                    objArr3[1] = Integer.valueOf(b);
                    objArr3[2] = gVar2 == null ? null : gVar2.field_mediaId;
                    objArr3[3] = gVar4 == null ? null : gVar4.field_mediaId;
                    objArr3[4] = Integer.valueOf(hashCode());
                    ab.i(str2, str5, objArr3);
                }
            }
        }
        AppMethodBeat.o(78053);
    }

    public final void afs() {
        AppMethodBeat.i(78054);
        g.RN();
        if (com.tencent.mm.kernel.a.QX()) {
            b afr = f.afy().afr();
            String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableSnsStreamDownload");
            String value8 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableSnsImageDownload");
            String value9 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ApprovedVideoPrivateProtocolHosts");
            try {
                if (!bo.isNullOrNil(value)) {
                    afr.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!bo.isNullOrNil(value2)) {
                    afr.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!bo.isNullOrNil(value3)) {
                    afr.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!bo.isNullOrNil(value4)) {
                    afr.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!bo.isNullOrNil(value5)) {
                    afr.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!bo.isNullOrNil(value6)) {
                    afr.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!bo.isNullOrNil(value7)) {
                    afr.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!bo.isNullOrNil(value8)) {
                    afr.field_EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                if (!bo.isNullOrNil(value9)) {
                    afr.field_ApprovedVideoHosts = value9;
                }
                f.afx();
                afr.field_EnableSafeCDN = lg(256) ? 1 : 0;
                if (afr.field_UseStreamCDN != 0) {
                    value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableJPEGDyncmicETL");
                    if (!bo.isNullOrNil(value)) {
                        afr.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!bo.isNullOrNil(value2)) {
                        afr.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!bo.isNullOrNil(value3)) {
                        afr.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!bo.isNullOrNil(value4)) {
                        afr.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!bo.isNullOrNil(value5)) {
                        afr.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                ab.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", afr);
                if (this.fyG != -1) {
                    ab.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", Integer.valueOf(this.fyG));
                    afr.field_EnableSnsImageDownload = this.fyG;
                }
                f.afy();
                a.a(afr);
            } catch (NumberFormatException e) {
                ab.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (ae.giS) {
                int i;
                ab.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                afr.field_UseStreamCDN = ae.giO ? 1 : 0;
                if (afr.field_UseStreamCDN != 0) {
                    afr.field_onlysendETL = ae.giP;
                    afr.field_onlyrecvPtl = ae.giQ;
                    if (!bo.isNullOrNil(ae.giL)) {
                        afr.field_WifiEtl = Integer.valueOf(ae.giL).intValue();
                    }
                    if (!bo.isNullOrNil(ae.giM)) {
                        afr.field_noWifiEtl = Integer.valueOf(ae.giM).intValue();
                    }
                    if (!bo.isNullOrNil(ae.giN)) {
                        afr.field_Ptl = Integer.valueOf(ae.giN).intValue();
                    }
                }
                afr.field_EnableCDNVerifyConnect = ae.giT ? 1 : 0;
                if (ae.giU) {
                    i = 1;
                } else {
                    i = 0;
                }
                afr.field_EnableCDNVideoRedirectOC = i;
                ab.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", afr);
                f.afy();
                a.a(afr);
            }
        }
        AppMethodBeat.o(78054);
    }

    public final int a(final String str, final com.tencent.mm.i.c cVar, final com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(78055);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            AppMethodBeat.o(78055);
            return -1;
        } else if (cVar == null && dVar == null) {
            ab.e("MicroMsg.CdnTransportService", "cdn callback info all null");
            AppMethodBeat.o(78055);
            return -2;
        } else {
            if (cVar != null) {
                ab.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify));
            }
            this.fyP = bo.anU();
            this.fyO = str;
            d.xDH.a(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.i(78040);
                    com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) b.this.fyM.get(str);
                    if (gVar == null) {
                        ab.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", str, Integer.valueOf(b.this.hashCode()));
                        h.pYm.a(594, 7, 1, true);
                        AppMethodBeat.o(78040);
                        return;
                    }
                    com.tencent.mm.i.f fVar;
                    if (cVar != null) {
                        cVar.cHr = str;
                        ab.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(cVar.field_toltalLength), Integer.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify));
                    }
                    if (dVar != null) {
                        dVar.cHr = str;
                    }
                    if (gVar.egl != null) {
                        long anU = bo.anU();
                        if (dVar != null || cVar == null || cVar.field_mtlnotify || at.getNetWorkType(ah.getContext()) != -1) {
                            gVar.field_lastProgressCallbackTime = anU;
                            gVar.egl.a(str, 0, cVar, dVar, gVar.field_onlycheckexist);
                        } else {
                            AppMethodBeat.o(78040);
                            return;
                        }
                    }
                    if (gVar instanceof com.tencent.mm.i.f) {
                        fVar = (com.tencent.mm.i.f) gVar;
                    } else {
                        fVar = null;
                    }
                    com.tencent.mm.i.c cVar = cVar;
                    if (cVar == null || cVar.field_finishedLength == cVar.field_toltalLength) {
                        i = 1;
                    }
                    if (i != 0 && (fVar == null || fVar.Jo())) {
                        b.this.fyN.remove(str);
                    }
                    if (dVar != null) {
                        if (fVar == null || fVar.Jo()) {
                            b.this.fyM.remove(str);
                        }
                        if (dVar.field_retCode == -5103011) {
                            ab.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            h.pYm.a(546, 4, 1, true);
                            f.afy().keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    AppMethodBeat.o(78040);
                }

                public final String toString() {
                    AppMethodBeat.i(78041);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.o(78041);
                    return str;
                }
            }, "MicroMsg.CdnTransportService");
            AppMethodBeat.o(78055);
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(78056);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.o(78056);
            return;
        }
        com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) this.fyM.get(str);
        if (gVar == null) {
            ab.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(78056);
        } else if (gVar.egl != null) {
            gVar.egl.a(str, byteArrayOutputStream);
            AppMethodBeat.o(78056);
        } else {
            ab.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.o(78056);
        }
    }

    public final byte[] l(String str, byte[] bArr) {
        AppMethodBeat.i(78057);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.o(78057);
            return null;
        }
        com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) this.fyM.get(str);
        if (gVar == null) {
            ab.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(78057);
            return null;
        } else if (gVar.egl != null) {
            byte[] l = gVar.egl.l(str, bArr);
            AppMethodBeat.o(78057);
            return l;
        } else {
            ab.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.o(78057);
            return null;
        }
    }

    public final void a(final String str, final com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(78058);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78058);
            return;
        }
        d.xDH.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78042);
                com.tencent.mm.i.g gVar = (com.tencent.mm.i.g) b.this.fyM.get(str);
                if (gVar == null) {
                    ab.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                    AppMethodBeat.o(78042);
                    return;
                }
                if (gVar.egz != null) {
                    gVar.egz.a(str, dVar);
                }
                AppMethodBeat.o(78042);
            }
        }, "MicroMsg.CdnTransportService");
        AppMethodBeat.o(78058);
    }
}
