package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f implements a {
    private static f oFG;
    public int cFu;
    private c oFH;
    long oFI;
    boolean oFJ = false;
    boolean oFK = false;

    public static f jf(boolean z) {
        AppMethodBeat.i(22906);
        if (oFG == null) {
            oFG = new f();
        } else if (z) {
            oFG.cancel();
            oFG = new f();
        }
        f fVar = oFG;
        AppMethodBeat.o(22906);
        return fVar;
    }

    public final void e(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(22907);
        ab.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", str, str2, Integer.valueOf(this.cFu));
        if (this.oFK) {
            ab.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", str);
            AppMethodBeat.o(22907);
            return;
        }
        this.oFK = true;
        this.oFI = bo.anU();
        if (this.oFH != null) {
            this.oFH.oFo = true;
        }
        this.oFH = new c();
        d dVar = new d(str);
        dVar.oFu = bArr;
        if (str.equals(b.oFb)) {
            a(dVar, this.cFu);
            AppMethodBeat.o(22907);
            return;
        }
        aw.ZK();
        if (((Boolean) c.Ry().get(ac.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            String[] split = str2.split(",");
            if (!str.equals(b.oFc)) {
                if (str.equals(b.oFd)) {
                    if (b.oFm <= 0) {
                        ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
                        cancel();
                        AppMethodBeat.o(22907);
                        return;
                    } else if (split.length < 5) {
                        ab.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
                        cancel();
                        AppMethodBeat.o(22907);
                        return;
                    } else {
                        String str3 = split[0];
                        long Fe = g.Fe(split[1]) * 1000;
                        long Fe2 = g.Fe(split[2]) * 1000;
                        dVar.RS(split[3]);
                        a(dVar, str3, Fe, Fe2, g.bC(split[4], 0), this.cFu);
                    }
                }
                AppMethodBeat.o(22907);
                return;
            } else if (b.oFl <= 0) {
                ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
                cancel();
                AppMethodBeat.o(22907);
                return;
            } else if (split.length < 2) {
                ab.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
                cancel();
                AppMethodBeat.o(22907);
                return;
            } else {
                a(dVar, g.Fe(split[0]) * 1000, g.Fe(split[1]) * 1000, this.cFu);
                AppMethodBeat.o(22907);
                return;
            }
        }
        ab.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
        cancel();
        AppMethodBeat.o(22907);
    }

    private void a(d dVar, int i) {
        AppMethodBeat.i(22908);
        ab.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", Integer.valueOf(i));
        h.pYm.a(466, 0, 1, false);
        d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList bQW = this.oFH.bQW();
        ab.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", Integer.valueOf(bQW.size()));
        if (bQW.size() == 0) {
            ab.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
            cancel();
            long gb = bo.gb(this.oFI);
            h.pYm.a(466, 1, 1, false);
            h.pYm.a(466, 5, 0, false);
            h.pYm.a(466, 7, gb, false);
            h.pYm.a(466, 11, 0, false);
            h.pYm.a(466, 12, 0, false);
            b.l(gb, i, 1);
            AppMethodBeat.o(22908);
            return;
        }
        long j;
        if (b.oFk < 0) {
            j = (long) b.oFk;
        } else {
            j = bo.gb((long) ((((b.oFk * 24) * 60) * 60) * 1000));
        }
        this.oFH.a(dVar, bQW, j, System.currentTimeMillis(), b.oFi);
        AppMethodBeat.o(22908);
    }

    private void a(d dVar, long j, long j2, int i) {
        AppMethodBeat.i(22909);
        ab.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", Integer.valueOf(i));
        h.pYm.a(466, 15, 1, false);
        d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList bQW = this.oFH.bQW();
        ab.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", Integer.valueOf(bQW.size()));
        if (bQW.size() == 0) {
            ab.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
            cancel();
            long gb = bo.gb(this.oFI);
            h.pYm.a(466, 16, 1, false);
            h.pYm.a(466, 20, 0, false);
            h.pYm.a(466, 22, gb, false);
            h.pYm.a(466, 26, 0, false);
            h.pYm.a(466, 27, 0, false);
            b.l(gb, i, 2);
            AppMethodBeat.o(22909);
            return;
        }
        long j3;
        long currentTimeMillis;
        if (b.oFk < 0) {
            j3 = (long) b.oFk;
        } else {
            j3 = bo.gb((long) ((((b.oFk * 24) * 60) * 60) * 1000));
        }
        if (j >= j3) {
            j3 = j;
        }
        if (j2 == 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j2;
        }
        if (j3 > currentTimeMillis) {
            ab.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", Long.valueOf(j3), Long.valueOf(currentTimeMillis));
            a(dVar, true);
            AppMethodBeat.o(22909);
            return;
        }
        this.oFH.a(dVar, bQW, j3, currentTimeMillis, b.oFi);
        AppMethodBeat.o(22909);
    }

    private void a(d dVar, String str, long j, long j2, int i, int i2) {
        AppMethodBeat.i(22910);
        ab.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", Integer.valueOf(i2));
        h.pYm.a(466, 31, 1, false);
        d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList RR = c.RR(str);
        ab.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", Integer.valueOf(RR.size()));
        if (RR.size() == 0) {
            ab.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
            cancel();
            long gb = bo.gb(this.oFI);
            h.pYm.a(466, 32, 1, false);
            h.pYm.a(466, 36, 0, false);
            h.pYm.a(466, 38, gb, false);
            h.pYm.a(466, 42, 0, false);
            h.pYm.a(466, 43, 0, false);
            b.l(gb, i2, 3);
            AppMethodBeat.o(22910);
            return;
        }
        this.oFH.a(dVar, RR, j, j2, i);
        AppMethodBeat.o(22910);
    }

    public final void a(final d dVar, String str, int i) {
        AppMethodBeat.i(22911);
        ab.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", str, Integer.valueOf(i), Long.valueOf(dVar.oFv), Long.valueOf(dVar.oFw), Long.valueOf(dVar.oFx));
        if (dVar.oFv > 0 || dVar.oFw > 0 || dVar.oFx > 0) {
            final AnonymousClass1 anonymousClass1 = new as() {
                public final void ZB() {
                    AppMethodBeat.i(22903);
                    ab.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", Boolean.valueOf(f.this.oFJ), Boolean.valueOf(com.tencent.mm.kernel.a.jP(com.tencent.mm.kernel.g.RN().eIV)));
                    if (f.this.oFJ && com.tencent.mm.kernel.a.jP(com.tencent.mm.kernel.g.RN().eIV)) {
                        ab.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
                        aw.ZK();
                        c.b(this);
                        f.this.oFJ = false;
                        f.this.a(dVar, false);
                    }
                    AppMethodBeat.o(22903);
                }
            };
            AnonymousClass2 anonymousClass2 = new com.tencent.mm.i.g.a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    AppMethodBeat.i(22904);
                    ab.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                    if (i == -21005) {
                        ab.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", str);
                        AppMethodBeat.o(22904);
                        return 0;
                    } else if (i != 0) {
                        ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", str, Integer.valueOf(i));
                        f.this.cancel();
                        f.RT(dVar.action);
                        b.a(0, 0, 0, 0, 1, f.this.cFu, dVar.action);
                        AppMethodBeat.o(22904);
                        return 0;
                    } else {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, str, dVar.field_filemd5);
                                f.RT(dVar.action);
                                f.this.cancel();
                                b.a(0, 0, 0, 0, 1, f.this.cFu, dVar.action);
                            } else {
                                ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", str, dVar.field_filemd5, Integer.valueOf(dVar.field_UploadHitCacheType));
                                PByteArray pByteArray = new PByteArray();
                                if (MMProtocalJni.rsaPublicEncryptPemkey(dVar.field_aesKey.getBytes(), pByteArray, dVar.oFu)) {
                                    String cd = bo.cd(pByteArray.value);
                                    d dVar2 = dVar;
                                    String str2 = dVar.field_fileId;
                                    int i2 = dVar.field_fileLength;
                                    dVar2.oFA = new String(str2);
                                    dVar2.oFB = new String(cd);
                                    dVar2.oFC = i2;
                                    if (com.tencent.mm.kernel.a.jP(com.tencent.mm.kernel.g.RN().eIV)) {
                                        ab.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                                        f.this.a(dVar, false);
                                    } else {
                                        ab.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                                        aw.ZK();
                                        c.a(anonymousClass1);
                                        f.this.oFJ = true;
                                    }
                                } else {
                                    ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                                    AppMethodBeat.o(22904);
                                    return -1;
                                }
                            }
                        }
                        AppMethodBeat.o(22904);
                        return 0;
                    }
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            String str2 = "MSG_SYNCHRONIZE_" + i + "_" + bo.anU();
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.egl = anonymousClass2;
            gVar.field_mediaId = str2;
            gVar.field_fullpath = str;
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
            gVar.field_talker = (String) d.aUr().aUs().Ry().get(2, null);
            gVar.field_priority = com.tencent.mm.i.a.efC;
            if (!com.tencent.mm.al.f.afx().e(gVar)) {
                ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", str2);
                RT(dVar.action);
                b.a(0, 0, 0, 0, 1, this.cFu, dVar.action);
            }
            AppMethodBeat.o(22911);
            return;
        }
        ab.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
        a(dVar, true);
        AppMethodBeat.o(22911);
    }

    static void RT(String str) {
        AppMethodBeat.i(22912);
        if (str.equals(b.oFb)) {
            h.pYm.a(466, 2, 1, false);
            AppMethodBeat.o(22912);
        } else if (str.equals(b.oFc)) {
            h.pYm.a(466, 17, 1, false);
            AppMethodBeat.o(22912);
        } else {
            if (str.equals(b.oFd)) {
                h.pYm.a(466, 33, 1, false);
            }
            AppMethodBeat.o(22912);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(final d dVar, boolean z) {
        m eVar;
        AppMethodBeat.i(22913);
        ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", Boolean.valueOf(z));
        aw.Rg().a(222, new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(22905);
                aw.Rg().b(222, (com.tencent.mm.ai.f) this);
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
                    e.N(g.bQY(), true);
                    e.N(g.bQZ(), true);
                    f.this.oFK = false;
                    long gb = bo.gb(f.this.oFI);
                    if (dVar.action.equals(b.oFb)) {
                        h.pYm.a(466, 1, 1, false);
                        h.pYm.a(466, 5, dVar.oFx, false);
                        h.pYm.a(466, 7, gb, false);
                        h.pYm.a(466, 11, dVar.oFw, false);
                        h.pYm.a(466, 12, dVar.oFv, false);
                    } else if (dVar.action.equals(b.oFc)) {
                        h.pYm.a(466, 16, 1, false);
                        h.pYm.a(466, 20, dVar.oFx, false);
                        h.pYm.a(466, 22, gb, false);
                        h.pYm.a(466, 26, dVar.oFw, false);
                        h.pYm.a(466, 27, dVar.oFv, false);
                    } else if (dVar.action.equals(b.oFd)) {
                        h.pYm.a(466, 32, 1, false);
                        h.pYm.a(466, 36, dVar.oFx, false);
                        h.pYm.a(466, 38, gb, false);
                        h.pYm.a(466, 42, dVar.oFw, false);
                        h.pYm.a(466, 43, dVar.oFv, false);
                    }
                    b.a(dVar.oFx, gb, dVar.oFw, dVar.oFv, 0, f.this.cFu, dVar.action);
                    AppMethodBeat.o(22905);
                    return;
                }
                ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                f.this.cancel();
                if (dVar.action.equals(b.oFb)) {
                    h.pYm.a(466, 3, 1, false);
                } else if (dVar.action.equals(b.oFc)) {
                    h.pYm.a(466, 18, 1, false);
                } else if (dVar.action.equals(b.oFd)) {
                    h.pYm.a(466, 34, 1, false);
                }
                b.a(0, 0, 0, 0, 2, f.this.cFu, dVar.action);
                AppMethodBeat.o(22905);
            }
        });
        String str = "";
        if (dVar.action.equals(b.oFd)) {
            str = dVar.oFy + "," + dVar.oFz;
        }
        if (z) {
            eVar = new e("", "NULL", 0, dVar.ecX, dVar.action, str);
        } else {
            eVar = new e(dVar.oFA, dVar.oFB, dVar.oFC, dVar.ecX, dVar.action, str);
        }
        aw.Rg().a(eVar, 0);
        AppMethodBeat.o(22913);
    }

    public final void cancel() {
        AppMethodBeat.i(22914);
        ab.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", an.doQ());
        this.oFH.oFo = true;
        this.oFK = false;
        AppMethodBeat.o(22914);
    }

    public final void onCancel() {
        AppMethodBeat.i(22915);
        cancel();
        AppMethodBeat.o(22915);
    }
}
