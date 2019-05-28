package com.tencent.p177mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.p057v4.widget.C8415j;
import com.p123qq.p803wx.voice.embed.recognizer.C17715b;
import com.p123qq.p803wx.voice.embed.recognizer.C17715b.C17716a;
import com.p123qq.p803wx.voice.embed.recognizer.C25590a;
import com.p123qq.p803wx.voice.embed.recognizer.C25591c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ext.C45904a;
import com.tencent.p177mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C40420a;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.protocal.protobuf.C23387fg;
import com.tencent.p177mm.protocal.protobuf.C30183fh;
import com.tencent.p177mm.protocal.protobuf.C40519fi;
import com.tencent.p177mm.protocal.protobuf.C44117fb;
import com.tencent.p177mm.protocal.protobuf.C44119fd;
import com.tencent.p177mm.protocal.protobuf.C46541fj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl */
public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements C1202f {
    private static final String[] lPA = new String[]{"retCode"};
    private Context context;
    private String[] lPN = null;
    private int lPO = -1;
    private int lRi = 4;
    private long lRj;
    private long lRk;
    private long lRl;
    C46484b lRm = new C46484b();
    private long lRn = 0;
    private boolean lRo;
    private C25591c lRp = new C430175();

    /* renamed from: com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl$5 */
    class C430175 implements C25591c {
        C430175() {
        }

        /* renamed from: a */
        public final void mo43298a(C25590a c25590a) {
            AppMethodBeat.m2504i(20444);
            if (c25590a == null) {
                C4990ab.m7420w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
                AppMethodBeat.m2505o(20444);
                return;
            }
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.this.lRn), c25590a.text, c25590a.name);
            if (!C5046bo.isNullOrNil(c25590a.name)) {
                ExtControlProviderVoiceControl.this.lRo = true;
                ExtControlProviderVoiceControl.m85132b(ExtControlProviderVoiceControl.this, c25590a.name);
            }
            AppMethodBeat.m2505o(20444);
        }

        /* renamed from: fM */
        public final void mo43299fM(int i) {
            AppMethodBeat.m2504i(20445);
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(20445);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m85132b(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.m2504i(20455);
        extControlProviderVoiceControl.m85127Ln(str);
        AppMethodBeat.m2505o(20455);
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        AppMethodBeat.m2504i(20447);
        this.lPN = strArr;
        this.lPO = i;
        this.context = context;
        AppMethodBeat.m2505o(20447);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20448);
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", Integer.valueOf(this.lPO));
        this.lRj = 0;
        this.lRk = 0;
        mo61883a(uri, this.context, this.lPO, this.lPN);
        if (uri == null) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            mo61889dZ(3, 5);
            MatrixCursor Kn = C40420a.m69330Kn(5);
            AppMethodBeat.m2505o(20448);
            return Kn;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Cursor Kn2;
        if (C5046bo.isNullOrNil(this.lPW)) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            mo61889dZ(3, 7);
            Kn2 = C40420a.m69330Kn(7);
            AppMethodBeat.m2505o(20448);
            return Kn2;
        } else if (C5046bo.isNullOrNil(brL())) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            mo61889dZ(3, 6);
            Kn2 = C40420a.m69330Kn(6);
            AppMethodBeat.m2505o(20448);
            return Kn2;
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int brM = brM();
            if (brM != 1) {
                C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                mo61889dZ(2, brM);
                Kn2 = C40420a.m69330Kn(brM);
                AppMethodBeat.m2505o(20448);
                return Kn2;
            }
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2));
            switch (this.lPO) {
                case 29:
                    C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        mo61889dZ(3, 3501);
                        this.lRi = 3501;
                        Kn2 = C40420a.m69330Kn(3501);
                        AppMethodBeat.m2505o(20448);
                        return Kn2;
                    }
                    final String str3 = strArr2[0];
                    final String str4 = strArr2[1];
                    final String str5 = strArr2[2];
                    final String str6 = strArr2[3];
                    final String str7 = strArr2[4];
                    C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", str3, str4, str5, str6, str7);
                    if (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str5) || C5046bo.isNullOrNil(str6) || C5046bo.isNullOrNil(str7)) {
                        mo61889dZ(3, 3502);
                        C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        Kn2 = C40420a.m69330Kn(3502);
                        AppMethodBeat.m2505o(20448);
                        return Kn2;
                    } else if (C1173e.m2561ct(str7)) {
                        this.lRj = System.currentTimeMillis();
                        C9638aw.m17182Rg().mo14539a(985, (C1202f) this);
                        this.lRm.mo74707b(13000, new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(20440);
                                int i = C5046bo.getInt(str3, 4);
                                if (i == 1) {
                                    ExtControlProviderVoiceControl.m85129a(ExtControlProviderVoiceControl.this, str7);
                                } else {
                                    C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
                                }
                                if (!ExtControlProviderVoiceControl.m85133b(ExtControlProviderVoiceControl.this.lPW, i, C5046bo.getInt(str4, 4), C5046bo.getInt(str5, TXRecordCommon.AUDIO_SAMPLERATE_16000), C5046bo.getInt(str6, 16), str7)) {
                                    C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
                                    ExtControlProviderVoiceControl.this.lRi = 3504;
                                    ExtControlProviderVoiceControl.this.lRm.countDown();
                                }
                                AppMethodBeat.m2505o(20440);
                            }
                        });
                        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", Long.valueOf(this.lRk - this.lRj), Long.valueOf(System.currentTimeMillis() - this.lRk));
                        C9638aw.m17182Rg().mo14546b(985, (C1202f) this);
                        mo61881T(10, 0, 1);
                        if (1 != this.lRi) {
                            mo61881T(11, 4, 1);
                        } else {
                            mo61881T(10, 0, 1);
                        }
                        mo61890vf(0);
                        Kn2 = C40420a.m69330Kn(this.lRi);
                        AppMethodBeat.m2505o(20448);
                        return Kn2;
                    } else {
                        C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        mo61889dZ(3, 3503);
                        Kn2 = C40420a.m69330Kn(3503);
                        AppMethodBeat.m2505o(20448);
                        return Kn2;
                    }
                default:
                    mo61889dZ(3, 15);
                    Kn2 = C40420a.m69330Kn(15);
                    AppMethodBeat.m2505o(20448);
                    return Kn2;
            }
        }
    }

    /* renamed from: b */
    public static boolean m85133b(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] f;
        AppMethodBeat.m2504i(20449);
        C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            C41768d c41768d = new C41768d();
            if (!C41768d.m73722G(str2, str3)) {
                C4990ab.m7413e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", str2, str3);
                AppMethodBeat.m2505o(20449);
                return false;
            }
        }
        str3 = str2;
        int cs = C1173e.m2560cs(str3);
        C46541fj c46541fj = new C46541fj();
        c46541fj.vHo = 4;
        c46541fj.vHp = 4;
        c46541fj.vHq = i3;
        c46541fj.vHr = i4;
        C40519fi c40519fi = new C40519fi();
        c40519fi.ptw = cs;
        c40519fi.ptx = 0;
        if (cs <= 16384) {
            c40519fi.pty = cs;
            f = C1173e.m2571f(str3, 0, cs);
        } else {
            c40519fi.pty = 16384;
            f = C1173e.m2571f(str3, 0, 16384);
        }
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(cs), Integer.valueOf(16384));
        if (f == null || f.length <= 0) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            AppMethodBeat.m2505o(20449);
            return false;
        }
        C30183fh c30183fh = new C30183fh();
        c30183fh.vHm = c46541fj;
        c30183fh.vHg = c40519fi;
        c30183fh.vHn = C1332b.m2847bI(f);
        int hashCode = (C5046bo.anU()).hashCode();
        if (hashCode != C8415j.INVALID_ID) {
            hashCode = Math.abs(hashCode);
        } else {
            hashCode = C8415j.INVALID_ID;
        }
        C9638aw.m17182Rg().mo14541a(new C27908a(hashCode, str, cs, str3, c30183fh), 0);
        AppMethodBeat.m2505o(20449);
        return true;
    }

    /* renamed from: a */
    private static boolean m85130a(C27908a c27908a, int i, int i2) {
        AppMethodBeat.m2504i(20450);
        if (c27908a == null) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            AppMethodBeat.m2505o(20450);
            return false;
        } else if (c27908a.lRA == null) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            AppMethodBeat.m2505o(20450);
            return false;
        } else if (c27908a.lRA.vHg == null) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            AppMethodBeat.m2505o(20450);
            return false;
        } else {
            C30183fh c30183fh = new C30183fh();
            C30183fh c30183fh2 = c27908a.lRA;
            c30183fh2.vHg.ptx = i;
            c30183fh2.vHg.pty = i2;
            byte[] f = C1173e.m2571f(c27908a.lRz, i, i2);
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", Integer.valueOf(c27908a.lRx), Integer.valueOf(i), Integer.valueOf(i2));
            if (f == null || f.length <= 0) {
                C4990ab.m7413e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", c27908a.lRz);
                AppMethodBeat.m2505o(20450);
                return false;
            }
            c30183fh2.vHn = C1332b.m2847bI(f);
            C1207m c27908a2 = new C27908a(c27908a.lRx, c27908a.appId, c27908a.frO, c27908a.lRz, c30183fh2);
            c27908a2.coc = c27908a.coc;
            C9638aw.m17182Rg().mo14541a(c27908a2, 0);
            AppMethodBeat.m2505o(20450);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo73742a(int i, String str, C1332b c1332b) {
        AppMethodBeat.m2504i(20451);
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", Integer.valueOf(i), str);
        if (this.lRk == 0) {
            this.lRk = System.currentTimeMillis();
        }
        this.lRl = System.currentTimeMillis();
        C44117fb c44117fb = new C44117fb();
        c44117fb.vGZ = c1332b;
        C9638aw.m17182Rg().mo14541a(new C27908a(i, str, c44117fb, this.lRk), 0);
        AppMethodBeat.m2505o(20451);
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(20452);
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.lRi = 3506;
            this.lRm.countDown();
            AppMethodBeat.m2505o(20452);
        } else if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", Integer.valueOf(c1207m.getType()));
            if (c1207m.getType() == 985) {
                if (this.lRo) {
                    C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                    AppMethodBeat.m2505o(20452);
                    return;
                }
                C44119fd c44119fd;
                final C27908a c27908a = (C27908a) c1207m;
                C27908a c27908a2 = (C27908a) c1207m;
                if (c27908a2.ehh == null || c27908a2.ehh.fsH.fsP == null) {
                    c44119fd = null;
                } else {
                    c44119fd = (C44119fd) c27908a2.ehh.fsH.fsP;
                }
                if (c44119fd == null) {
                    C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                    this.lRi = 3508;
                    this.lRm.countDown();
                    AppMethodBeat.m2505o(20452);
                    return;
                }
                String str2;
                Object obj;
                c27908a.lRy = c44119fd.vGZ;
                String str3 = "MicroMsg.ext.ExtControlProviderVoiceControl";
                String str4 = "[voiceControl] opCode=%s, resp.Cookies=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(c27908a.czE);
                if (c44119fd.vGZ == null) {
                    str2 = BuildConfig.COMMAND;
                } else {
                    str2 = new String(c44119fd.vGZ.f1226wR);
                }
                objArr[1] = str2;
                C4990ab.m7417i(str3, str4, objArr);
                if (c27908a.czE == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (c27908a.czE == 2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                        if (System.currentTimeMillis() - c27908a.lRD > ((long) c27908a.lRC)) {
                            C4990ab.m7421w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", Long.valueOf(System.currentTimeMillis() - c27908a.lRD), Integer.valueOf(c27908a.lRC));
                            obj = 1;
                        } else {
                            C4990ab.m7417i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", Long.valueOf(System.currentTimeMillis() - c27908a.lRD), Integer.valueOf(c27908a.lRC));
                            obj = null;
                        }
                        if (obj != null) {
                            this.lRi = 3509;
                            this.lRm.countDown();
                            AppMethodBeat.m2505o(20452);
                            return;
                        }
                        if (c44119fd.vHh != null) {
                            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", Integer.valueOf(c44119fd.vHh.vHa), Integer.valueOf(c44119fd.vHh.vHi));
                        }
                        if (c44119fd.vHh == null || c44119fd.vHh.vHi != 0) {
                            if (System.currentTimeMillis() - this.lRl >= ((long) c44119fd.vHe)) {
                                C5004al.m7441d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(20442);
                                        ExtControlProviderVoiceControl.this.mo73742a(c27908a.lRx, c27908a.appId, c27908a.lRy);
                                        AppMethodBeat.m2505o(20442);
                                    }
                                });
                                AppMethodBeat.m2505o(20452);
                                return;
                            }
                            long currentTimeMillis = ((long) c44119fd.vHe) - (System.currentTimeMillis() - this.lRl);
                            if (currentTimeMillis > ((long) c44119fd.vHe)) {
                                currentTimeMillis = (long) c44119fd.vHe;
                            }
                            C5004al.m7442n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(20443);
                                    ExtControlProviderVoiceControl.this.mo73742a(c27908a.lRx, c27908a.appId, c27908a.lRy);
                                    AppMethodBeat.m2505o(20443);
                                }
                            }, currentTimeMillis);
                            AppMethodBeat.m2505o(20452);
                            return;
                        } else if (c44119fd.vHh.vHj == null) {
                            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.m2505o(20452);
                            return;
                        } else if (c44119fd.vHh.vHj.vHk == null || c44119fd.vHh.vHj.vHk.size() <= 0) {
                            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.m2505o(20452);
                            return;
                        } else if (c44119fd.vHh.vHj.vHk.size() == 0) {
                            this.lRi = 3511;
                            this.lRm.countDown();
                            AppMethodBeat.m2505o(20452);
                            return;
                        } else if (c44119fd.vHh.vHj.vHk.size() == 1) {
                            m85127Ln(((C23387fg) c44119fd.vHh.vHj.vHk.get(0)).vHl);
                            AppMethodBeat.m2505o(20452);
                            return;
                        } else {
                            String[] strArr = new String[c44119fd.vHh.vHj.vHk.size()];
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < strArr.length) {
                                    strArr[i4] = ((C23387fg) c44119fd.vHh.vHj.vHk.get(i4)).vHl;
                                    C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", strArr[i4]);
                                    i3 = i4 + 1;
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                                    intent.putExtra("VoiceSearchResultUI_VoiceId", c27908a.lRx);
                                    intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                                    intent.setFlags(67108864);
                                    intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                                    C25985d.m41473f(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                                    C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                                    this.lRi = 1;
                                    this.lRm.countDown();
                                    AppMethodBeat.m2505o(20452);
                                    return;
                                }
                            }
                        }
                    }
                } else if (c44119fd.vHg == null) {
                    C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                    this.lRi = 3508;
                    this.lRm.countDown();
                    AppMethodBeat.m2505o(20452);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", Integer.valueOf(c44119fd.vHe), Integer.valueOf(c44119fd.vHf), Integer.valueOf(c44119fd.vHg.ptx), Integer.valueOf(c44119fd.vHg.pty));
                    if (c44119fd.vHg.ptx >= c27908a.frO) {
                        C5004al.m7442n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(20441);
                                C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                                C27908a c27908a = c27908a;
                                C4990ab.m7417i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", Integer.valueOf(c44119fd.vHf));
                                c27908a.lRC = r1;
                                ExtControlProviderVoiceControl.this.mo73742a(c27908a.lRx, c27908a.appId, c27908a.lRy);
                                AppMethodBeat.m2505o(20441);
                            }
                        }, (long) c44119fd.vHe);
                        AppMethodBeat.m2505o(20452);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                    if (c44119fd.vHg.ptx == 0 || c44119fd.vHg.ptx != c27908a.coc) {
                        c27908a.coc = c44119fd.vHg.ptx;
                        if (c44119fd.vHg.ptx + c44119fd.vHg.pty < c27908a.frO) {
                            if (!ExtControlProviderVoiceControl.m85130a(c27908a, c44119fd.vHg.ptx, c44119fd.vHg.pty)) {
                                C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                                this.lRi = 3510;
                                this.lRm.countDown();
                                AppMethodBeat.m2505o(20452);
                                return;
                            }
                        } else if (!ExtControlProviderVoiceControl.m85130a(c27908a, c44119fd.vHg.ptx, c27908a.frO - c44119fd.vHg.ptx)) {
                            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                            this.lRi = 3510;
                            this.lRm.countDown();
                            AppMethodBeat.m2505o(20452);
                            return;
                        }
                        AppMethodBeat.m2505o(20452);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
                    AppMethodBeat.m2505o(20452);
                    return;
                }
            }
            AppMethodBeat.m2505o(20452);
        } else {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.lRi = 3507;
            this.lRm.countDown();
            AppMethodBeat.m2505o(20452);
        }
    }

    /* renamed from: Ln */
    private void m85127Ln(final String str) {
        AppMethodBeat.m2504i(20453);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
            C4990ab.m7412e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.lRi = 3505;
            this.lRm.countDown();
            AppMethodBeat.m2505o(20453);
            return;
        }
        C41933a.m74069a(11, new C41932a() {
            public final void run() {
                AppMethodBeat.m2504i(20446);
                ExtControlProviderVoiceControl.m85135c(ExtControlProviderVoiceControl.this, str);
                AppMethodBeat.m2505o(20446);
            }
        });
        this.lRi = 1;
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", str);
        this.lRm.countDown();
        AppMethodBeat.m2505o(20453);
    }

    /* renamed from: a */
    static /* synthetic */ void m85129a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.m2504i(20454);
        extControlProviderVoiceControl.lRo = false;
        extControlProviderVoiceControl.lRn = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", Boolean.valueOf(C4996ah.doB().getBoolean("hasInitVoiceControlData", true)));
        if (C4996ah.doB().getBoolean("hasInitVoiceControlData", true)) {
            byte[] f = C1173e.m2571f(str, 0, -1);
            C17715b c17715b = C17716a.bCt;
            int a = c17715b.bCs.mo67126a(extControlProviderVoiceControl.lRp, f);
            C4990ab.m7417i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", Integer.valueOf(a));
        }
        AppMethodBeat.m2505o(20454);
    }

    /* renamed from: c */
    static /* synthetic */ void m85135c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        AppMethodBeat.m2504i(20456);
        Intent intent;
        if (C17903f.m28109rc(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(str));
            C25985d.m41473f(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
            AppMethodBeat.m2505o(20456);
        } else if (C17903f.m28103kq(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            C25985d.m41473f(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
            AppMethodBeat.m2505o(20456);
        } else if (C17903f.m28110rd(str)) {
            C16527d qX = C17903f.m28104qX(str);
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
            C25985d.m41467b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.m2505o(20456);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            C45904a.gkE.mo38915d(intent, extControlProviderVoiceControl.context);
            AppMethodBeat.m2505o(20456);
        }
    }
}
