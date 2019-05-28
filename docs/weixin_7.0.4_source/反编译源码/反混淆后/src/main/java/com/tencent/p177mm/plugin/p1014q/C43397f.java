package com.tencent.p177mm.plugin.p1014q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.p1014q.C12870a.C12871a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.q.f */
public final class C43397f implements C12871a {
    private static C43397f oFG;
    public int cFu;
    private C21515c oFH;
    long oFI;
    boolean oFJ = false;
    boolean oFK = false;

    /* renamed from: jf */
    public static C43397f m77451jf(boolean z) {
        AppMethodBeat.m2504i(22906);
        if (oFG == null) {
            oFG = new C43397f();
        } else if (z) {
            oFG.cancel();
            oFG = new C43397f();
        }
        C43397f c43397f = oFG;
        AppMethodBeat.m2505o(22906);
        return c43397f;
    }

    /* renamed from: e */
    public final void mo68952e(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(22907);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", str, str2, Integer.valueOf(this.cFu));
        if (this.oFK) {
            C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", str);
            AppMethodBeat.m2505o(22907);
            return;
        }
        this.oFK = true;
        this.oFI = C5046bo.anU();
        if (this.oFH != null) {
            this.oFH.oFo = true;
        }
        this.oFH = new C21515c();
        C46141d c46141d = new C46141d(str);
        c46141d.oFu = bArr;
        if (str.equals(C28723b.oFb)) {
            m77448a(c46141d, this.cFu);
            AppMethodBeat.m2505o(22907);
            return;
        }
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            String[] split = str2.split(",");
            if (!str.equals(C28723b.oFc)) {
                if (str.equals(C28723b.oFd)) {
                    if (C28723b.oFm <= 0) {
                        C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
                        cancel();
                        AppMethodBeat.m2505o(22907);
                        return;
                    } else if (split.length < 5) {
                        C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
                        cancel();
                        AppMethodBeat.m2505o(22907);
                        return;
                    } else {
                        String str3 = split[0];
                        long Fe = C38635g.m65507Fe(split[1]) * 1000;
                        long Fe2 = C38635g.m65507Fe(split[2]) * 1000;
                        c46141d.mo74095RS(split[3]);
                        m77450a(c46141d, str3, Fe, Fe2, C38635g.m65521bC(split[4], 0), this.cFu);
                    }
                }
                AppMethodBeat.m2505o(22907);
                return;
            } else if (C28723b.oFl <= 0) {
                C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
                cancel();
                AppMethodBeat.m2505o(22907);
                return;
            } else if (split.length < 2) {
                C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
                cancel();
                AppMethodBeat.m2505o(22907);
                return;
            } else {
                m77449a(c46141d, C38635g.m65507Fe(split[0]) * 1000, C38635g.m65507Fe(split[1]) * 1000, this.cFu);
                AppMethodBeat.m2505o(22907);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
        cancel();
        AppMethodBeat.m2505o(22907);
    }

    /* renamed from: a */
    private void m77448a(C46141d c46141d, int i) {
        AppMethodBeat.m2504i(22908);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", Integer.valueOf(i));
        C7060h.pYm.mo8378a(466, 0, 1, false);
        C38658d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList bQW = this.oFH.bQW();
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", Integer.valueOf(bQW.size()));
        if (bQW.size() == 0) {
            C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
            cancel();
            long gb = C5046bo.m7566gb(this.oFI);
            C7060h.pYm.mo8378a(466, 1, 1, false);
            C7060h.pYm.mo8378a(466, 5, 0, false);
            C7060h.pYm.mo8378a(466, 7, gb, false);
            C7060h.pYm.mo8378a(466, 11, 0, false);
            C7060h.pYm.mo8378a(466, 12, 0, false);
            C28723b.m45647l(gb, i, 1);
            AppMethodBeat.m2505o(22908);
            return;
        }
        long j;
        if (C28723b.oFk < 0) {
            j = (long) C28723b.oFk;
        } else {
            j = C5046bo.m7566gb((long) ((((C28723b.oFk * 24) * 60) * 60) * 1000));
        }
        this.oFH.mo36992a(c46141d, bQW, j, System.currentTimeMillis(), C28723b.oFi);
        AppMethodBeat.m2505o(22908);
    }

    /* renamed from: a */
    private void m77449a(C46141d c46141d, long j, long j2, int i) {
        AppMethodBeat.m2504i(22909);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", Integer.valueOf(i));
        C7060h.pYm.mo8378a(466, 15, 1, false);
        C38658d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList bQW = this.oFH.bQW();
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", Integer.valueOf(bQW.size()));
        if (bQW.size() == 0) {
            C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
            cancel();
            long gb = C5046bo.m7566gb(this.oFI);
            C7060h.pYm.mo8378a(466, 16, 1, false);
            C7060h.pYm.mo8378a(466, 20, 0, false);
            C7060h.pYm.mo8378a(466, 22, gb, false);
            C7060h.pYm.mo8378a(466, 26, 0, false);
            C7060h.pYm.mo8378a(466, 27, 0, false);
            C28723b.m45647l(gb, i, 2);
            AppMethodBeat.m2505o(22909);
            return;
        }
        long j3;
        long currentTimeMillis;
        if (C28723b.oFk < 0) {
            j3 = (long) C28723b.oFk;
        } else {
            j3 = C5046bo.m7566gb((long) ((((C28723b.oFk * 24) * 60) * 60) * 1000));
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
            C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", Long.valueOf(j3), Long.valueOf(currentTimeMillis));
            mo68950a(c46141d, true);
            AppMethodBeat.m2505o(22909);
            return;
        }
        this.oFH.mo36992a(c46141d, bQW, j3, currentTimeMillis, C28723b.oFi);
        AppMethodBeat.m2505o(22909);
    }

    /* renamed from: a */
    private void m77450a(C46141d c46141d, String str, long j, long j2, int i, int i2) {
        AppMethodBeat.m2504i(22910);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", Integer.valueOf(i2));
        C7060h.pYm.mo8378a(466, 31, 1, false);
        C38658d.aUr().aUu();
        this.oFH.oFp = this;
        LinkedList RR = C21515c.m32969RR(str);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", Integer.valueOf(RR.size()));
        if (RR.size() == 0) {
            C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
            cancel();
            long gb = C5046bo.m7566gb(this.oFI);
            C7060h.pYm.mo8378a(466, 32, 1, false);
            C7060h.pYm.mo8378a(466, 36, 0, false);
            C7060h.pYm.mo8378a(466, 38, gb, false);
            C7060h.pYm.mo8378a(466, 42, 0, false);
            C7060h.pYm.mo8378a(466, 43, 0, false);
            C28723b.m45647l(gb, i2, 3);
            AppMethodBeat.m2505o(22910);
            return;
        }
        this.oFH.mo36992a(c46141d, RR, j, j2, i);
        AppMethodBeat.m2505o(22910);
    }

    /* renamed from: a */
    public final void mo24894a(final C46141d c46141d, String str, int i) {
        AppMethodBeat.m2504i(22911);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", str, Integer.valueOf(i), Long.valueOf(c46141d.oFv), Long.valueOf(c46141d.oFw), Long.valueOf(c46141d.oFx));
        if (c46141d.oFv > 0 || c46141d.oFw > 0 || c46141d.oFx > 0) {
            final C128721 c128721 = new C1815as() {
                /* renamed from: ZB */
                public final void mo5390ZB() {
                    AppMethodBeat.m2504i(22903);
                    C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", Boolean.valueOf(C43397f.this.oFJ), Boolean.valueOf(C1668a.m3404jP(C1720g.m3534RN().eIV)));
                    if (C43397f.this.oFJ && C1668a.m3404jP(C1720g.m3534RN().eIV)) {
                        C4990ab.m7416i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
                        C9638aw.m17190ZK();
                        C18628c.m29104b(this);
                        C43397f.this.oFJ = false;
                        C43397f.this.mo68950a(c46141d, false);
                    }
                    AppMethodBeat.m2505o(22903);
                }
            };
            C347442 c347442 = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    AppMethodBeat.m2504i(22904);
                    C4990ab.m7411d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                    if (i == -21005) {
                        C4990ab.m7411d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", str);
                        AppMethodBeat.m2505o(22904);
                        return 0;
                    } else if (i != 0) {
                        C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", str, Integer.valueOf(i));
                        C43397f.this.cancel();
                        C43397f.m77447RT(c46141d.action);
                        C28723b.m45646a(0, 0, 0, 0, 1, C43397f.this.cFu, c46141d.action);
                        AppMethodBeat.m2505o(22904);
                        return 0;
                    } else {
                        if (c9545d != null) {
                            if (c9545d.field_retCode != 0) {
                                C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", Integer.valueOf(c9545d.field_retCode), c9545d.field_arg, c9545d.field_transInfo, str, c9545d.field_filemd5);
                                C43397f.m77447RT(c46141d.action);
                                C43397f.this.cancel();
                                C28723b.m45646a(0, 0, 0, 0, 1, C43397f.this.cFu, c46141d.action);
                            } else {
                                C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", str, c9545d.field_filemd5, Integer.valueOf(c9545d.field_UploadHitCacheType));
                                PByteArray pByteArray = new PByteArray();
                                if (MMProtocalJni.rsaPublicEncryptPemkey(c9545d.field_aesKey.getBytes(), pByteArray, c46141d.oFu)) {
                                    String cd = C5046bo.m7543cd(pByteArray.value);
                                    C46141d c46141d = c46141d;
                                    String str2 = c9545d.field_fileId;
                                    int i2 = c9545d.field_fileLength;
                                    c46141d.oFA = new String(str2);
                                    c46141d.oFB = new String(cd);
                                    c46141d.oFC = i2;
                                    if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
                                        C4990ab.m7416i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                                        C43397f.this.mo68950a(c46141d, false);
                                    } else {
                                        C4990ab.m7416i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                                        C9638aw.m17190ZK();
                                        C18628c.m29103a(c128721);
                                        C43397f.this.oFJ = true;
                                    }
                                } else {
                                    C4990ab.m7412e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                                    AppMethodBeat.m2505o(22904);
                                    return -1;
                                }
                            }
                        }
                        AppMethodBeat.m2505o(22904);
                        return 0;
                    }
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            String str2 = "MSG_SYNCHRONIZE_" + i + "_" + C5046bo.anU();
            C42130g c42130g = new C42130g();
            c42130g.egl = c347442;
            c42130g.field_mediaId = str2;
            c42130g.field_fullpath = str;
            c42130g.field_fileType = C42129a.MediaType_FILE;
            c42130g.field_talker = (String) C38658d.aUr().aUs().mo61496Ry().get(2, null);
            c42130g.field_priority = C42129a.efC;
            if (!C37461f.afx().mo51225e(c42130g)) {
                C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", str2);
                C43397f.m77447RT(c46141d.action);
                C28723b.m45646a(0, 0, 0, 0, 1, this.cFu, c46141d.action);
            }
            AppMethodBeat.m2505o(22911);
            return;
        }
        C4990ab.m7416i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
        mo68950a(c46141d, true);
        AppMethodBeat.m2505o(22911);
    }

    /* renamed from: RT */
    static void m77447RT(String str) {
        AppMethodBeat.m2504i(22912);
        if (str.equals(C28723b.oFb)) {
            C7060h.pYm.mo8378a(466, 2, 1, false);
            AppMethodBeat.m2505o(22912);
        } else if (str.equals(C28723b.oFc)) {
            C7060h.pYm.mo8378a(466, 17, 1, false);
            AppMethodBeat.m2505o(22912);
        } else {
            if (str.equals(C28723b.oFd)) {
                C7060h.pYm.mo8378a(466, 33, 1, false);
            }
            AppMethodBeat.m2505o(22912);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo68950a(final C46141d c46141d, boolean z) {
        C1207m c39532e;
        AppMethodBeat.m2504i(22913);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", Boolean.valueOf(z));
        C9638aw.m17182Rg().mo14539a(222, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(22905);
                C9638aw.m17182Rg().mo14546b(222, (C1202f) this);
                if (i == 0 && i2 == 0) {
                    C4990ab.m7416i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
                    C5730e.m8618N(C43398g.bQY(), true);
                    C5730e.m8618N(C43398g.bQZ(), true);
                    C43397f.this.oFK = false;
                    long gb = C5046bo.m7566gb(C43397f.this.oFI);
                    if (c46141d.action.equals(C28723b.oFb)) {
                        C7060h.pYm.mo8378a(466, 1, 1, false);
                        C7060h.pYm.mo8378a(466, 5, c46141d.oFx, false);
                        C7060h.pYm.mo8378a(466, 7, gb, false);
                        C7060h.pYm.mo8378a(466, 11, c46141d.oFw, false);
                        C7060h.pYm.mo8378a(466, 12, c46141d.oFv, false);
                    } else if (c46141d.action.equals(C28723b.oFc)) {
                        C7060h.pYm.mo8378a(466, 16, 1, false);
                        C7060h.pYm.mo8378a(466, 20, c46141d.oFx, false);
                        C7060h.pYm.mo8378a(466, 22, gb, false);
                        C7060h.pYm.mo8378a(466, 26, c46141d.oFw, false);
                        C7060h.pYm.mo8378a(466, 27, c46141d.oFv, false);
                    } else if (c46141d.action.equals(C28723b.oFd)) {
                        C7060h.pYm.mo8378a(466, 32, 1, false);
                        C7060h.pYm.mo8378a(466, 36, c46141d.oFx, false);
                        C7060h.pYm.mo8378a(466, 38, gb, false);
                        C7060h.pYm.mo8378a(466, 42, c46141d.oFw, false);
                        C7060h.pYm.mo8378a(466, 43, c46141d.oFv, false);
                    }
                    C28723b.m45646a(c46141d.oFx, gb, c46141d.oFw, c46141d.oFv, 0, C43397f.this.cFu, c46141d.action);
                    AppMethodBeat.m2505o(22905);
                    return;
                }
                C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C43397f.this.cancel();
                if (c46141d.action.equals(C28723b.oFb)) {
                    C7060h.pYm.mo8378a(466, 3, 1, false);
                } else if (c46141d.action.equals(C28723b.oFc)) {
                    C7060h.pYm.mo8378a(466, 18, 1, false);
                } else if (c46141d.action.equals(C28723b.oFd)) {
                    C7060h.pYm.mo8378a(466, 34, 1, false);
                }
                C28723b.m45646a(0, 0, 0, 0, 2, C43397f.this.cFu, c46141d.action);
                AppMethodBeat.m2505o(22905);
            }
        });
        String str = "";
        if (c46141d.action.equals(C28723b.oFd)) {
            str = c46141d.oFy + "," + c46141d.oFz;
        }
        if (z) {
            c39532e = new C39532e("", "NULL", 0, c46141d.ecX, c46141d.action, str);
        } else {
            c39532e = new C39532e(c46141d.oFA, c46141d.oFB, c46141d.oFC, c46141d.ecX, c46141d.action, str);
        }
        C9638aw.m17182Rg().mo14541a(c39532e, 0);
        AppMethodBeat.m2505o(22913);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(22914);
        C4990ab.m7413e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", C5007an.doQ());
        this.oFH.oFo = true;
        this.oFK = false;
        AppMethodBeat.m2505o(22914);
    }

    public final void onCancel() {
        AppMethodBeat.m2504i(22915);
        cancel();
        AppMethodBeat.m2505o(22915);
    }
}
