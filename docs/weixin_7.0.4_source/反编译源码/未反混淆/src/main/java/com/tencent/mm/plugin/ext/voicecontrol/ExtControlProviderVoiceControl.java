package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.v4.widget.j;
import com.qq.wx.voice.embed.recognizer.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.d.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.ugc.TXRecordCommon;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements f {
    private static final String[] lPA = new String[]{"retCode"};
    private Context context;
    private String[] lPN = null;
    private int lPO = -1;
    private int lRi = 4;
    private long lRj;
    private long lRk;
    private long lRl;
    b lRm = new b();
    private long lRn = 0;
    private boolean lRo;
    private c lRp = new c() {
        public final void a(a aVar) {
            AppMethodBeat.i(20444);
            if (aVar == null) {
                ab.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
                AppMethodBeat.o(20444);
                return;
            }
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.this.lRn), aVar.text, aVar.name);
            if (!bo.isNullOrNil(aVar.name)) {
                ExtControlProviderVoiceControl.this.lRo = true;
                ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, aVar.name);
            }
            AppMethodBeat.o(20444);
        }

        public final void fM(int i) {
            AppMethodBeat.i(20445);
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", Integer.valueOf(i));
            AppMethodBeat.o(20445);
        }
    };

    static /* synthetic */ void b(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(20455);
        extControlProviderVoiceControl.Ln(str);
        AppMethodBeat.o(20455);
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        AppMethodBeat.i(20447);
        this.lPN = strArr;
        this.lPO = i;
        this.context = context;
        AppMethodBeat.o(20447);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20448);
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", Integer.valueOf(this.lPO));
        this.lRj = 0;
        this.lRk = 0;
        a(uri, this.context, this.lPO, this.lPN);
        if (uri == null) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            dZ(3, 5);
            MatrixCursor Kn = com.tencent.mm.pluginsdk.d.a.a.Kn(5);
            AppMethodBeat.o(20448);
            return Kn;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Cursor Kn2;
        if (bo.isNullOrNil(this.lPW)) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            dZ(3, 7);
            Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(7);
            AppMethodBeat.o(20448);
            return Kn2;
        } else if (bo.isNullOrNil(brL())) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            dZ(3, 6);
            Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(6);
            AppMethodBeat.o(20448);
            return Kn2;
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int brM = brM();
            if (brM != 1) {
                ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                dZ(2, brM);
                Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(brM);
                AppMethodBeat.o(20448);
                return Kn2;
            }
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2));
            switch (this.lPO) {
                case 29:
                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        dZ(3, 3501);
                        this.lRi = 3501;
                        Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(3501);
                        AppMethodBeat.o(20448);
                        return Kn2;
                    }
                    final String str3 = strArr2[0];
                    final String str4 = strArr2[1];
                    final String str5 = strArr2[2];
                    final String str6 = strArr2[3];
                    final String str7 = strArr2[4];
                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", str3, str4, str5, str6, str7);
                    if (bo.isNullOrNil(str3) || bo.isNullOrNil(str4) || bo.isNullOrNil(str5) || bo.isNullOrNil(str6) || bo.isNullOrNil(str7)) {
                        dZ(3, 3502);
                        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(3502);
                        AppMethodBeat.o(20448);
                        return Kn2;
                    } else if (e.ct(str7)) {
                        this.lRj = System.currentTimeMillis();
                        aw.Rg().a(985, (f) this);
                        this.lRm.b(13000, new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(20440);
                                int i = bo.getInt(str3, 4);
                                if (i == 1) {
                                    ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, str7);
                                } else {
                                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
                                }
                                if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this.lPW, i, bo.getInt(str4, 4), bo.getInt(str5, TXRecordCommon.AUDIO_SAMPLERATE_16000), bo.getInt(str6, 16), str7)) {
                                    ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
                                    ExtControlProviderVoiceControl.this.lRi = 3504;
                                    ExtControlProviderVoiceControl.this.lRm.countDown();
                                }
                                AppMethodBeat.o(20440);
                            }
                        });
                        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", Long.valueOf(this.lRk - this.lRj), Long.valueOf(System.currentTimeMillis() - this.lRk));
                        aw.Rg().b(985, (f) this);
                        T(10, 0, 1);
                        if (1 != this.lRi) {
                            T(11, 4, 1);
                        } else {
                            T(10, 0, 1);
                        }
                        vf(0);
                        Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(this.lRi);
                        AppMethodBeat.o(20448);
                        return Kn2;
                    } else {
                        ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        dZ(3, 3503);
                        Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(3503);
                        AppMethodBeat.o(20448);
                        return Kn2;
                    }
                default:
                    dZ(3, 15);
                    Kn2 = com.tencent.mm.pluginsdk.d.a.a.Kn(15);
                    AppMethodBeat.o(20448);
                    return Kn2;
            }
        }
    }

    public static boolean b(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] f;
        AppMethodBeat.i(20449);
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            d dVar = new d();
            if (!d.G(str2, str3)) {
                ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", str2, str3);
                AppMethodBeat.o(20449);
                return false;
            }
        }
        str3 = str2;
        int cs = e.cs(str3);
        fj fjVar = new fj();
        fjVar.vHo = 4;
        fjVar.vHp = 4;
        fjVar.vHq = i3;
        fjVar.vHr = i4;
        fi fiVar = new fi();
        fiVar.ptw = cs;
        fiVar.ptx = 0;
        if (cs <= 16384) {
            fiVar.pty = cs;
            f = e.f(str3, 0, cs);
        } else {
            fiVar.pty = 16384;
            f = e.f(str3, 0, 16384);
        }
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(cs), Integer.valueOf(16384));
        if (f == null || f.length <= 0) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            AppMethodBeat.o(20449);
            return false;
        }
        fh fhVar = new fh();
        fhVar.vHm = fjVar;
        fhVar.vHg = fiVar;
        fhVar.vHn = com.tencent.mm.bt.b.bI(f);
        int hashCode = (bo.anU()).hashCode();
        if (hashCode != j.INVALID_ID) {
            hashCode = Math.abs(hashCode);
        } else {
            hashCode = j.INVALID_ID;
        }
        aw.Rg().a(new a(hashCode, str, cs, str3, fhVar), 0);
        AppMethodBeat.o(20449);
        return true;
    }

    private static boolean a(a aVar, int i, int i2) {
        AppMethodBeat.i(20450);
        if (aVar == null) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            AppMethodBeat.o(20450);
            return false;
        } else if (aVar.lRA == null) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            AppMethodBeat.o(20450);
            return false;
        } else if (aVar.lRA.vHg == null) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            AppMethodBeat.o(20450);
            return false;
        } else {
            fh fhVar = new fh();
            fh fhVar2 = aVar.lRA;
            fhVar2.vHg.ptx = i;
            fhVar2.vHg.pty = i2;
            byte[] f = e.f(aVar.lRz, i, i2);
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", Integer.valueOf(aVar.lRx), Integer.valueOf(i), Integer.valueOf(i2));
            if (f == null || f.length <= 0) {
                ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", aVar.lRz);
                AppMethodBeat.o(20450);
                return false;
            }
            fhVar2.vHn = com.tencent.mm.bt.b.bI(f);
            m aVar2 = new a(aVar.lRx, aVar.appId, aVar.frO, aVar.lRz, fhVar2);
            aVar2.coc = aVar.coc;
            aw.Rg().a(aVar2, 0);
            AppMethodBeat.o(20450);
            return true;
        }
    }

    public final boolean a(int i, String str, com.tencent.mm.bt.b bVar) {
        AppMethodBeat.i(20451);
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", Integer.valueOf(i), str);
        if (this.lRk == 0) {
            this.lRk = System.currentTimeMillis();
        }
        this.lRl = System.currentTimeMillis();
        fb fbVar = new fb();
        fbVar.vGZ = bVar;
        aw.Rg().a(new a(i, str, fbVar, this.lRk), 0);
        AppMethodBeat.o(20451);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(20452);
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.lRi = 3506;
            this.lRm.countDown();
            AppMethodBeat.o(20452);
        } else if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", Integer.valueOf(mVar.getType()));
            if (mVar.getType() == 985) {
                if (this.lRo) {
                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                    AppMethodBeat.o(20452);
                    return;
                }
                fd fdVar;
                final a aVar = (a) mVar;
                a aVar2 = (a) mVar;
                if (aVar2.ehh == null || aVar2.ehh.fsH.fsP == null) {
                    fdVar = null;
                } else {
                    fdVar = (fd) aVar2.ehh.fsH.fsP;
                }
                if (fdVar == null) {
                    ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                    this.lRi = 3508;
                    this.lRm.countDown();
                    AppMethodBeat.o(20452);
                    return;
                }
                String str2;
                Object obj;
                aVar.lRy = fdVar.vGZ;
                String str3 = "MicroMsg.ext.ExtControlProviderVoiceControl";
                String str4 = "[voiceControl] opCode=%s, resp.Cookies=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aVar.czE);
                if (fdVar.vGZ == null) {
                    str2 = BuildConfig.COMMAND;
                } else {
                    str2 = new String(fdVar.vGZ.wR);
                }
                objArr[1] = str2;
                ab.i(str3, str4, objArr);
                if (aVar.czE == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (aVar.czE == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                        if (System.currentTimeMillis() - aVar.lRD > ((long) aVar.lRC)) {
                            ab.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.lRD), Integer.valueOf(aVar.lRC));
                            obj = 1;
                        } else {
                            ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.lRD), Integer.valueOf(aVar.lRC));
                            obj = null;
                        }
                        if (obj != null) {
                            this.lRi = 3509;
                            this.lRm.countDown();
                            AppMethodBeat.o(20452);
                            return;
                        }
                        if (fdVar.vHh != null) {
                            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", Integer.valueOf(fdVar.vHh.vHa), Integer.valueOf(fdVar.vHh.vHi));
                        }
                        if (fdVar.vHh == null || fdVar.vHh.vHi != 0) {
                            if (System.currentTimeMillis() - this.lRl >= ((long) fdVar.vHe)) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(20442);
                                        ExtControlProviderVoiceControl.this.a(aVar.lRx, aVar.appId, aVar.lRy);
                                        AppMethodBeat.o(20442);
                                    }
                                });
                                AppMethodBeat.o(20452);
                                return;
                            }
                            long currentTimeMillis = ((long) fdVar.vHe) - (System.currentTimeMillis() - this.lRl);
                            if (currentTimeMillis > ((long) fdVar.vHe)) {
                                currentTimeMillis = (long) fdVar.vHe;
                            }
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(20443);
                                    ExtControlProviderVoiceControl.this.a(aVar.lRx, aVar.appId, aVar.lRy);
                                    AppMethodBeat.o(20443);
                                }
                            }, currentTimeMillis);
                            AppMethodBeat.o(20452);
                            return;
                        } else if (fdVar.vHh.vHj == null) {
                            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.o(20452);
                            return;
                        } else if (fdVar.vHh.vHj.vHk == null || fdVar.vHh.vHj.vHk.size() <= 0) {
                            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.o(20452);
                            return;
                        } else if (fdVar.vHh.vHj.vHk.size() == 0) {
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.o(20452);
                            return;
                        } else if (fdVar.vHh.vHj.vHk.size() == 1) {
                            Ln(((fg) fdVar.vHh.vHj.vHk.get(0)).vHl);
                            AppMethodBeat.o(20452);
                            return;
                        } else {
                            String[] strArr = new String[fdVar.vHh.vHj.vHk.size()];
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < strArr.length) {
                                    strArr[i4] = ((fg) fdVar.vHh.vHj.vHk.get(i4)).vHl;
                                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", strArr[i4]);
                                    i3 = i4 + 1;
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                                    intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.lRx);
                                    intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                                    intent.setFlags(67108864);
                                    intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                                    com.tencent.mm.bp.d.f(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                                    this.lRi = 1;
                                    this.lRm.countDown();
                                    AppMethodBeat.o(20452);
                                    return;
                                }
                            }
                        }
                    }
                } else if (fdVar.vHg == null) {
                    ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                    this.lRi = 3508;
                    this.lRm.countDown();
                    AppMethodBeat.o(20452);
                    return;
                } else {
                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", Integer.valueOf(fdVar.vHe), Integer.valueOf(fdVar.vHf), Integer.valueOf(fdVar.vHg.ptx), Integer.valueOf(fdVar.vHg.pty));
                    if (fdVar.vHg.ptx >= aVar.frO) {
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(20441);
                                ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                                a aVar = aVar;
                                ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", Integer.valueOf(fdVar.vHf));
                                aVar.lRC = r1;
                                ExtControlProviderVoiceControl.this.a(aVar.lRx, aVar.appId, aVar.lRy);
                                AppMethodBeat.o(20441);
                            }
                        }, (long) fdVar.vHe);
                        AppMethodBeat.o(20452);
                        return;
                    }
                    ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                    if (fdVar.vHg.ptx == 0 || fdVar.vHg.ptx != aVar.coc) {
                        aVar.coc = fdVar.vHg.ptx;
                        if (fdVar.vHg.ptx + fdVar.vHg.pty < aVar.frO) {
                            if (!a(aVar, fdVar.vHg.ptx, fdVar.vHg.pty)) {
                                ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                                this.lRi = 3510;
                                this.lRm.countDown();
                                AppMethodBeat.o(20452);
                                return;
                            }
                        } else if (!a(aVar, fdVar.vHg.ptx, aVar.frO - fdVar.vHg.ptx)) {
                            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                            this.lRi = 3510;
                            this.lRm.countDown();
                            AppMethodBeat.o(20452);
                            return;
                        }
                        AppMethodBeat.o(20452);
                        return;
                    }
                    ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
                    AppMethodBeat.o(20452);
                    return;
                }
            }
            AppMethodBeat.o(20452);
        } else {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.lRi = 3507;
            this.lRm.countDown();
            AppMethodBeat.o(20452);
        }
    }

    private void Ln(final String str) {
        AppMethodBeat.i(20453);
        aw.ZK();
        ad aoO = com.tencent.mm.model.c.XM().aoO(str);
        if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
            ab.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.lRi = 3505;
            this.lRm.countDown();
            AppMethodBeat.o(20453);
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                AppMethodBeat.i(20446);
                ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this, str);
                AppMethodBeat.o(20446);
            }
        });
        this.lRi = 1;
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", str);
        this.lRm.countDown();
        AppMethodBeat.o(20453);
    }

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(20454);
        extControlProviderVoiceControl.lRo = false;
        extControlProviderVoiceControl.lRn = System.currentTimeMillis();
        ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", Boolean.valueOf(ah.doB().getBoolean("hasInitVoiceControlData", true)));
        if (ah.doB().getBoolean("hasInitVoiceControlData", true)) {
            byte[] f = e.f(str, 0, -1);
            com.qq.wx.voice.embed.recognizer.b bVar = com.qq.wx.voice.embed.recognizer.b.a.bCt;
            int a = bVar.bCs.a(extControlProviderVoiceControl.lRp, f);
            ab.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", Integer.valueOf(a));
        }
        AppMethodBeat.o(20454);
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.i(20456);
        Intent intent;
        if (com.tencent.mm.aj.f.rc(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", s.mJ(str));
            com.tencent.mm.bp.d.f(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
            AppMethodBeat.o(20456);
        } else if (com.tencent.mm.aj.f.kq(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            com.tencent.mm.bp.d.f(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
            AppMethodBeat.o(20456);
        } else if (com.tencent.mm.aj.f.rd(str)) {
            com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(str);
            String adT = qX == null ? null : qX.adT();
            if (adT == null) {
                adT = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", adT);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bp.d.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.o(20456);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            com.tencent.mm.plugin.ext.a.gkE.d(intent, extControlProviderVoiceControl.context);
            AppMethodBeat.o(20456);
        }
    }
}
