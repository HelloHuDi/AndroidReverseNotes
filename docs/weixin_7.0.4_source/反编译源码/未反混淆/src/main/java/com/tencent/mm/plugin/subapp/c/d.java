package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.e.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements f, at {
    private static HashMap<Integer, com.tencent.mm.cd.h.d> jZD;
    private static d ssR;
    private String eJM;
    private final Set<com.tencent.mm.model.ao.d> epg = new HashSet();
    private a jZF;
    private k ssQ;
    private j ssS;
    private List<Long> ssT = new ArrayList();
    private c ssU = new c<uf>() {
        {
            AppMethodBeat.i(25261);
            this.xxI = uf.class.getName().hashCode();
            AppMethodBeat.o(25261);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(25262);
            uf ufVar = (uf) bVar;
            e abk = e.abk(ufVar.cQp.cHz);
            bi biVar = ufVar.cQp.csG;
            if (abk != null) {
                d cDD = d.cDD();
                String str = biVar.field_talker;
                String str2 = ufVar.cQp.description;
                String ae = h.ae(ah.getContext(), abk.ssY);
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
                cDD.l(str, str3, biVar.field_createTime);
            }
            AppMethodBeat.o(25262);
            return false;
        }
    };
    private c ssV = new c<ue>() {
        {
            AppMethodBeat.i(25263);
            this.xxI = ue.class.getName().hashCode();
            AppMethodBeat.o(25263);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(25264);
            String str = ((ue) bVar).cQo.path;
            if (str != null) {
                String by = h.by(str, false);
                if (!bo.isNullOrNil(by)) {
                    d.cDE().pI(by);
                }
                d.cDE().uO(str);
                new File(str).delete();
            }
            AppMethodBeat.o(25264);
            return false;
        }
    };
    private c ssW = new c<oz>() {
        {
            AppMethodBeat.i(25265);
            this.xxI = oz.class.getName().hashCode();
            AppMethodBeat.o(25265);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(25266);
            int i = (int) ((oz) bVar).cLo.csG.field_msgId;
            aw.ZK();
            bi jf = com.tencent.mm.model.c.XO().jf((long) i);
            if (!(jf.field_msgId == 0 || jf.field_imgPath == null || bo.isNullOrNil(jf.field_imgPath))) {
                g abp = d.cDE().abp(jf.field_imgPath);
                if (!(abp == null || bo.isNullOrNil(abp.field_filename))) {
                    abp.field_status = 3;
                    abp.field_offset = 0;
                    abp.field_createtime = System.currentTimeMillis() / 1000;
                    abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    abp.bJt = 16840;
                    h.a(abp);
                    ab.d("MicroMsg.VoiceRemindLogic", " file:" + abp.field_filename + " msgid:" + abp.field_msglocalid + "  stat:" + abp.field_status);
                    if (abp.field_msglocalid == 0 || bo.isNullOrNil(abp.field_user)) {
                        ab.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + abp.field_msglocalid + " user:" + abp.field_user);
                    } else {
                        jf.setStatus(1);
                        aw.ZK();
                        com.tencent.mm.model.c.XO().a(jf.field_msgId, jf);
                        d.cDF().run();
                    }
                }
            }
            AppMethodBeat.o(25266);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(25267);
        AppMethodBeat.o(25267);
    }

    static {
        AppMethodBeat.i(25280);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        AppMethodBeat.o(25280);
    }

    public final void a(com.tencent.mm.model.ao.d dVar) {
        AppMethodBeat.i(25268);
        ab.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.epg.add(dVar);
        }
        AppMethodBeat.o(25268);
    }

    public final void b(com.tencent.mm.model.ao.d dVar) {
        AppMethodBeat.i(25269);
        ab.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.epg.remove(dVar);
        }
        AppMethodBeat.o(25269);
    }

    public final void l(String str, String str2, long j) {
        AppMethodBeat.i(25270);
        Context context = ah.getContext();
        if (context == null) {
            ab.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            AppMethodBeat.o(25270);
            return;
        }
        try {
            boolean MI = com.tencent.mm.m.a.MI();
            boolean MG = com.tencent.mm.m.a.MG();
            ab.d("MicroMsg.SubCoreVoiceRemind", "shake " + MI + "sound " + MG);
            if (!t.nw(aw.getNotification().IG())) {
                if (MI) {
                    bo.z(context, true);
                }
                if (MG) {
                    Uri defaultUri;
                    String MK = com.tencent.mm.m.a.MK();
                    if (MK == i.evO) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else {
                        defaultUri = Uri.parse(MK);
                    }
                    k kVar = new k();
                    try {
                        kVar.setDataSource(context, defaultUri);
                        kVar.setOnCompletionListener(new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(25260);
                                try {
                                    mediaPlayer.release();
                                    AppMethodBeat.o(25260);
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                                    AppMethodBeat.o(25260);
                                }
                            }
                        });
                        if (aw.ZL().getStreamVolume(5) != 0) {
                            if (aw.ZL().KV()) {
                                int streamVolume = aw.ZL().getStreamVolume(8);
                                int streamMaxVolume = aw.ZL().getStreamMaxVolume(8);
                                int streamVolume2 = aw.ZL().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                aw.ZL().bR(8, streamMaxVolume);
                                kVar.setAudioStreamType(8);
                                kVar.setLooping(true);
                                kVar.prepare();
                                kVar.setLooping(false);
                                kVar.start();
                                aw.ZL().bR(8, streamVolume);
                                ab.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                kVar.setAudioStreamType(5);
                                kVar.setLooping(true);
                                kVar.prepare();
                                kVar.setLooping(false);
                                kVar.start();
                            }
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        kVar.release();
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", th, "relese error", new Object[0]);
                    }
                }
            } else if (MI) {
                bo.z(context, true);
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "", new Object[0]);
        }
        if (this.epg == null || this.epg.size() == 0) {
            RemindDialog.y(context, str, str2);
            AppMethodBeat.o(25270);
            return;
        }
        for (com.tencent.mm.model.ao.d p : this.epg) {
            p.p(str2, j);
        }
        AppMethodBeat.o(25270);
    }

    public final void ot(String str) {
        AppMethodBeat.i(25271);
        aw.ZK();
        com.tencent.mm.model.c.XR().apb(str);
        this.ssT.clear();
        aw.ZK();
        Cursor Rk = com.tencent.mm.model.c.XO().Rk(str);
        Rk.moveToFirst();
        ab.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!Rk.isAfterLast()) {
            bi biVar = new bi();
            biVar.d(Rk);
            long j = biVar.field_msgId;
            ab.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + biVar.field_status);
            Rk.moveToNext();
            this.ssT.add(Long.valueOf(j));
        }
        Rk.close();
        aw.ZK();
        com.tencent.mm.model.c.XO().Ri(str);
        AppMethodBeat.o(25271);
    }

    public final void Zw() {
        AppMethodBeat.i(25272);
        cDF().run();
        AppMethodBeat.o(25272);
    }

    public final boolean fl(long j) {
        AppMethodBeat.i(25273);
        boolean contains = this.ssT.contains(Long.valueOf(j));
        ab.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        AppMethodBeat.o(25273);
        return contains;
    }

    public static d cDD() {
        AppMethodBeat.i(25274);
        aw.ZE();
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) bw.oJ("plugin.subapp");
        ssR = aVar == null ? null : (d) aVar.abh(d.class.getName());
        ab.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", aVar, ssR, bo.dpG());
        if (ssR == null) {
            d dVar = new d();
            ssR = dVar;
            ao.a.flx = dVar;
            aVar.b(d.class.getName(), ssR);
        }
        d dVar2 = ssR;
        AppMethodBeat.o(25274);
        return dVar2;
    }

    public static k cDE() {
        AppMethodBeat.i(25275);
        g.RN().QU();
        if (cDD().ssQ == null) {
            d cDD = cDD();
            cDD();
            if (cDD().jZF == null) {
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Rt()).append("CommonOneMicroMsg.db").toString();
                cDD().jZF = com.tencent.mm.platformtools.t.a(d.class.hashCode(), stringBuilder2, jZD, false);
            }
            cDD.ssQ = new k(cDD().jZF);
        }
        k kVar = cDD().ssQ;
        AppMethodBeat.o(25275);
        return kVar;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(25276);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        stringBuilder.append(com.tencent.mm.model.c.Rt()).append("CommonOneMicroMsg.db");
        cDE();
        com.tencent.mm.sdk.b.a.xxA.c(this.ssU);
        com.tencent.mm.sdk.b.a.xxA.c(this.ssV);
        com.tencent.mm.sdk.b.a.xxA.c(this.ssW);
        ab.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
        AppMethodBeat.o(25276);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(25277);
        aw.ZK();
        String accPath = com.tencent.mm.model.c.getAccPath();
        if (bo.isNullOrNil(accPath) || bo.isNullOrNil(this.eJM) || !accPath.equals(this.eJM)) {
            ab.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : ".concat(String.valueOf(accPath)));
            this.eJM = accPath;
            File file = new File(accPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            aw.ZK();
            File file2 = new File(com.tencent.mm.model.c.Yh());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        AppMethodBeat.o(25277);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(25278);
        if (this.ssS != null) {
            this.ssS.cqV = 0;
        }
        if (ssR != null) {
            ab.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = ssR;
            if (dVar.jZF != null) {
                dVar.jZF.mJ(dVar.hashCode());
                dVar.jZF = null;
            }
            dVar.eJM = "";
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.ssU);
        com.tencent.mm.sdk.b.a.xxA.d(this.ssV);
        com.tencent.mm.sdk.b.a.xxA.d(this.ssW);
        AppMethodBeat.o(25278);
    }

    public static j cDF() {
        AppMethodBeat.i(25279);
        g.RN().QU();
        if (cDD().ssS == null) {
            cDD().ssS = new j();
        }
        j jVar = cDD().ssS;
        AppMethodBeat.o(25279);
        return jVar;
    }
}
