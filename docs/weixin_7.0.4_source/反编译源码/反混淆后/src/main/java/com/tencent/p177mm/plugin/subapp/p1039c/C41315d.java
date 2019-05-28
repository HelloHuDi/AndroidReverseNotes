package com.tencent.p177mm.plugin.subapp.p1039c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C18609d;
import com.tencent.p177mm.model.C26415ao.C26416f;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C42068ue;
import com.tencent.p177mm.p230g.p231a.C42069uf;
import com.tencent.p177mm.p230g.p231a.C45355oz;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.C5510e.C5502i;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.subapp.C22330a;
import com.tencent.p177mm.plugin.subapp.p537ui.voicereminder.RemindDialog;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.plugin.subapp.c.d */
public class C41315d implements C26416f, C1816at {
    private static HashMap<Integer, C1366d> jZD;
    private static C41315d ssR;
    private String eJM;
    private final Set<C18609d> epg = new HashSet();
    private C1953a jZF;
    private C43667k ssQ;
    private C13903j ssS;
    private List<Long> ssT = new ArrayList();
    private C4884c ssU = new C399373();
    private C4884c ssV = new C352664();
    private C4884c ssW = new C223345();

    /* renamed from: com.tencent.mm.plugin.subapp.c.d$5 */
    class C223345 extends C4884c<C45355oz> {
        C223345() {
            AppMethodBeat.m2504i(25265);
            this.xxI = C45355oz.class.getName().hashCode();
            AppMethodBeat.m2505o(25265);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25266);
            int i = (int) ((C45355oz) c4883b).cLo.csG.field_msgId;
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf((long) i);
            if (!(jf.field_msgId == 0 || jf.field_imgPath == null || C5046bo.isNullOrNil(jf.field_imgPath))) {
                C29385g abp = C41315d.cDE().abp(jf.field_imgPath);
                if (!(abp == null || C5046bo.isNullOrNil(abp.field_filename))) {
                    abp.field_status = 3;
                    abp.field_offset = 0;
                    abp.field_createtime = System.currentTimeMillis() / 1000;
                    abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    abp.bJt = 16840;
                    C22335h.m34030a(abp);
                    C4990ab.m7410d("MicroMsg.VoiceRemindLogic", " file:" + abp.field_filename + " msgid:" + abp.field_msglocalid + "  stat:" + abp.field_status);
                    if (abp.field_msglocalid == 0 || C5046bo.isNullOrNil(abp.field_user)) {
                        C4990ab.m7412e("MicroMsg.VoiceRemindLogic", " failed msg id:" + abp.field_msglocalid + " user:" + abp.field_user);
                    } else {
                        jf.setStatus(1);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15284a(jf.field_msgId, jf);
                        C41315d.cDF().run();
                    }
                }
            }
            AppMethodBeat.m2505o(25266);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.d$4 */
    class C352664 extends C4884c<C42068ue> {
        C352664() {
            AppMethodBeat.m2504i(25263);
            this.xxI = C42068ue.class.getName().hashCode();
            AppMethodBeat.m2505o(25263);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25264);
            String str = ((C42068ue) c4883b).cQo.path;
            if (str != null) {
                String by = C22335h.m34031by(str, false);
                if (!C5046bo.isNullOrNil(by)) {
                    C41315d.cDE().mo69308pI(by);
                }
                C41315d.cDE().mo69309uO(str);
                new File(str).delete();
            }
            AppMethodBeat.m2505o(25264);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.d$3 */
    class C399373 extends C4884c<C42069uf> {
        C399373() {
            super(0);
            AppMethodBeat.m2504i(25261);
            this.xxI = C42069uf.class.getName().hashCode();
            AppMethodBeat.m2505o(25261);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25262);
            C42069uf c42069uf = (C42069uf) c4883b;
            C46291e abk = C46291e.abk(c42069uf.cQp.cHz);
            C7620bi c7620bi = c42069uf.cQp.csG;
            if (abk != null) {
                C41315d cDD = C41315d.cDD();
                String str = c7620bi.field_talker;
                String str2 = c42069uf.cQp.description;
                String ae = C14835h.m23086ae(C4996ah.getContext(), abk.ssY);
                String str3 = "";
                if (ae != null && ae.length() > 0) {
                    String[] split = ae.split(";");
                    str3 = str3 + split[0];
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (str2 != null) {
                    str3 = str3 + str2;
                }
                cDD.mo65987l(str, str3, c7620bi.field_createTime);
            }
            AppMethodBeat.m2505o(25262);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.d$1 */
    class C413161 implements OnCompletionListener {
        C413161() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(25260);
            try {
                mediaPlayer.release();
                AppMethodBeat.m2505o(25260);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                AppMethodBeat.m2505o(25260);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.d$2 */
    static class C413172 implements C1366d {
        C413172() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43667k.fnj;
        }
    }

    public C41315d() {
        AppMethodBeat.m2504i(25267);
        AppMethodBeat.m2505o(25267);
    }

    static {
        AppMethodBeat.m2504i(25280);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new C413172());
        AppMethodBeat.m2505o(25280);
    }

    /* renamed from: a */
    public final void mo44186a(C18609d c18609d) {
        AppMethodBeat.m2504i(25268);
        C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (c18609d != null) {
            this.epg.add(c18609d);
        }
        AppMethodBeat.m2505o(25268);
    }

    /* renamed from: b */
    public final void mo44187b(C18609d c18609d) {
        AppMethodBeat.m2504i(25269);
        C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (c18609d != null) {
            this.epg.remove(c18609d);
        }
        AppMethodBeat.m2505o(25269);
    }

    /* renamed from: l */
    public final void mo65987l(String str, String str2, long j) {
        AppMethodBeat.m2504i(25270);
        Context context = C4996ah.getContext();
        if (context == null) {
            C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            AppMethodBeat.m2505o(25270);
            return;
        }
        try {
            boolean MI = C37885a.m63956MI();
            boolean MG = C37885a.m63954MG();
            C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "shake " + MI + "sound " + MG);
            if (!C1855t.m3954nw(C9638aw.getNotification().mo41567IG())) {
                if (MI) {
                    C5046bo.m7589z(context, true);
                }
                if (MG) {
                    Uri defaultUri;
                    String MK = C37885a.m63958MK();
                    if (MK == C5502i.evO) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else {
                        defaultUri = Uri.parse(MK);
                    }
                    C45289k c45289k = new C45289k();
                    try {
                        c45289k.setDataSource(context, defaultUri);
                        c45289k.setOnCompletionListener(new C413161());
                        if (C9638aw.m17191ZL().getStreamVolume(5) != 0) {
                            if (C9638aw.m17191ZL().mo4822KV()) {
                                int streamVolume = C9638aw.m17191ZL().getStreamVolume(8);
                                int streamMaxVolume = C9638aw.m17191ZL().getStreamMaxVolume(8);
                                int streamVolume2 = C9638aw.m17191ZL().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                C9638aw.m17191ZL().mo4833bR(8, streamMaxVolume);
                                c45289k.setAudioStreamType(8);
                                c45289k.setLooping(true);
                                c45289k.prepare();
                                c45289k.setLooping(false);
                                c45289k.start();
                                C9638aw.m17191ZL().mo4833bR(8, streamVolume);
                                C4990ab.m7411d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                c45289k.setAudioStreamType(5);
                                c45289k.setLooping(true);
                                c45289k.prepare();
                                c45289k.setLooping(false);
                                c45289k.start();
                            }
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        c45289k.release();
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", th, "relese error", new Object[0]);
                    }
                }
            } else if (MI) {
                C5046bo.m7589z(context, true);
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "", new Object[0]);
        }
        if (this.epg == null || this.epg.size() == 0) {
            RemindDialog.m34061y(context, str, str2);
            AppMethodBeat.m2505o(25270);
            return;
        }
        for (C18609d p : this.epg) {
            p.mo33872p(str2, j);
        }
        AppMethodBeat.m2505o(25270);
    }

    /* renamed from: ot */
    public final void mo44189ot(String str) {
        AppMethodBeat.m2504i(25271);
        C9638aw.m17190ZK();
        C18628c.m29083XR().apb(str);
        this.ssT.clear();
        C9638aw.m17190ZK();
        Cursor Rk = C18628c.m29080XO().mo15257Rk(str);
        Rk.moveToFirst();
        C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!Rk.isAfterLast()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(Rk);
            long j = c7620bi.field_msgId;
            C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + c7620bi.field_status);
            Rk.moveToNext();
            this.ssT.add(Long.valueOf(j));
        }
        Rk.close();
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15255Ri(str);
        AppMethodBeat.m2505o(25271);
    }

    /* renamed from: Zw */
    public final void mo44185Zw() {
        AppMethodBeat.m2504i(25272);
        C41315d.cDF().run();
        AppMethodBeat.m2505o(25272);
    }

    /* renamed from: fl */
    public final boolean mo44188fl(long j) {
        AppMethodBeat.m2504i(25273);
        boolean contains = this.ssT.contains(Long.valueOf(j));
        C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        AppMethodBeat.m2505o(25273);
        return contains;
    }

    public static C41315d cDD() {
        AppMethodBeat.m2504i(25274);
        C9638aw.m17184ZE();
        C22330a c22330a = (C22330a) C45439bw.m83697oJ("plugin.subapp");
        ssR = c22330a == null ? null : (C41315d) c22330a.abh(C41315d.class.getName());
        C4990ab.m7417i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", c22330a, ssR, C5046bo.dpG());
        if (ssR == null) {
            C41315d c41315d = new C41315d();
            ssR = c41315d;
            C26417a.flx = c41315d;
            c22330a.mo37875b(C41315d.class.getName(), ssR);
        }
        C41315d c41315d2 = ssR;
        AppMethodBeat.m2505o(25274);
        return c41315d2;
    }

    public static C43667k cDE() {
        AppMethodBeat.m2504i(25275);
        C1720g.m3534RN().mo5159QU();
        if (C41315d.cDD().ssQ == null) {
            C41315d cDD = C41315d.cDD();
            C41315d.cDD();
            if (C41315d.cDD().jZF == null) {
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                String stringBuilder2 = stringBuilder.append(C18628c.m29068Rt()).append("CommonOneMicroMsg.db").toString();
                C41315d.cDD().jZF = C1952t.m4171a(C41315d.class.hashCode(), stringBuilder2, jZD, false);
            }
            cDD.ssQ = new C43667k(C41315d.cDD().jZF);
        }
        C43667k c43667k = C41315d.cDD().ssQ;
        AppMethodBeat.m2505o(25275);
        return c43667k;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(25276);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        stringBuilder.append(C18628c.m29068Rt()).append("CommonOneMicroMsg.db");
        C41315d.cDE();
        C4879a.xxA.mo10052c(this.ssU);
        C4879a.xxA.mo10052c(this.ssV);
        C4879a.xxA.mo10052c(this.ssW);
        C4990ab.m7411d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(25276);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(25277);
        C9638aw.m17190ZK();
        String accPath = C18628c.getAccPath();
        if (C5046bo.isNullOrNil(accPath) || C5046bo.isNullOrNil(this.eJM) || !accPath.equals(this.eJM)) {
            C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : ".concat(String.valueOf(accPath)));
            this.eJM = accPath;
            File file = new File(accPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            C9638aw.m17190ZK();
            File file2 = new File(C18628c.m29099Yh());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        AppMethodBeat.m2505o(25277);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(25278);
        if (this.ssS != null) {
            this.ssS.cqV = 0;
        }
        if (ssR != null) {
            C4990ab.m7410d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            C41315d c41315d = ssR;
            if (c41315d.jZF != null) {
                c41315d.jZF.mo5709mJ(c41315d.hashCode());
                c41315d.jZF = null;
            }
            c41315d.eJM = "";
        }
        C4879a.xxA.mo10053d(this.ssU);
        C4879a.xxA.mo10053d(this.ssV);
        C4879a.xxA.mo10053d(this.ssW);
        AppMethodBeat.m2505o(25278);
    }

    public static C13903j cDF() {
        AppMethodBeat.m2504i(25279);
        C1720g.m3534RN().mo5159QU();
        if (C41315d.cDD().ssS == null) {
            C41315d.cDD().ssS = new C13903j();
        }
        C13903j c13903j = C41315d.cDD().ssS;
        AppMethodBeat.m2505o(25279);
        return c13903j;
    }
}
