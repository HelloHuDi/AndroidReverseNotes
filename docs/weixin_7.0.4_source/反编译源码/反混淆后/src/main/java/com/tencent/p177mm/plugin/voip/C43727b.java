package com.tencent.p177mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C18611au;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p206bu.C32427a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.model.C14058r;
import com.tencent.p177mm.plugin.voip.model.C29498i;
import com.tencent.p177mm.plugin.voip.model.C29498i.C22459a;
import com.tencent.p177mm.plugin.voip.model.C40033o;
import com.tencent.p177mm.plugin.voip.p546ui.C40039d;
import com.tencent.p177mm.plugin.voip.video.p1045a.C22469c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.voip.b */
public class C43727b implements C1816at {
    private static int sNe = 0;
    private C14058r sMZ = null;
    private C40033o sNa = new C40033o();
    private C40039d sNb;
    private C46319d sNc = new C46319d();
    private C40027a sNd = new C40027a();

    /* renamed from: com.tencent.mm.plugin.voip.b$2 */
    class C314532 implements GetInputStream {
        C314532() {
        }

        public final InputStream getInputStream(String str) {
            AppMethodBeat.m2504i(4308);
            try {
                InputStream open = C4996ah.getContext().getAssets().open("raw" + File.separator + str);
                AppMethodBeat.m2505o(4308);
                return open;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SubCoreVoip", "cannot find res %s", str);
                C7060h.pYm.mo15419k(914, 13, 1);
                AppMethodBeat.m2505o(4308);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.b$1 */
    class C400261 implements Runnable {
        C400261() {
        }

        public final void run() {
            AppMethodBeat.m2504i(4307);
            C43727b.this.sNb.dismiss();
            C43727b.this.sNb = null;
            AppMethodBeat.m2505o(4307);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.b$a */
    public class C40027a extends C4884c<C6523mp> {
        public C40027a() {
            AppMethodBeat.m2504i(4309);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(4309);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(4310);
            if (C29498i.m46854Iv()) {
                boolean z;
                String str;
                if (C1720g.m3531RK()) {
                    C1720g.m3534RN();
                    if (!C1668a.m3393QT()) {
                        z = true;
                        if (z && C29498i.m46854Iv()) {
                            str = (String) C1720g.m3536RP().mo5239Ry().get(77829, null);
                            if (str != null) {
                                Map abV = C22459a.abV(str);
                                if (abV != null && abV.size() > 0) {
                                    LinkedList linkedList = new LinkedList();
                                    for (Entry entry : abV.entrySet()) {
                                        C22459a c22459a = (C22459a) entry.getValue();
                                        if (c22459a != null) {
                                            int i = c22459a.hitCount;
                                            int i2 = c22459a.fMk;
                                            if (i > 0 || i2 > 0) {
                                                linkedList.add(new C6333a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                                            }
                                            C4990ab.m7410d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                                        }
                                    }
                                    if (!linkedList.isEmpty()) {
                                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(linkedList));
                                        C1720g.m3536RP().mo5239Ry().set(77829, null);
                                    }
                                }
                            }
                        }
                        C1720g.m3536RP().mo5239Ry().set(77828, Long.valueOf(C5046bo.anT()));
                        C4990ab.m7410d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
                    }
                }
                z = false;
                str = (String) C1720g.m3536RP().mo5239Ry().get(77829, null);
                if (str != null) {
                }
                C1720g.m3536RP().mo5239Ry().set(77828, Long.valueOf(C5046bo.anT()));
                C4990ab.m7410d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
            }
            AppMethodBeat.m2505o(4310);
            return false;
        }
    }

    public C43727b() {
        AppMethodBeat.m2504i(4311);
        AppMethodBeat.m2505o(4311);
    }

    static {
        AppMethodBeat.m2504i(4317);
        C22469c.checkLibraryInit();
        AppMethodBeat.m2505o(4317);
    }

    private static C43727b cIi() {
        AppMethodBeat.m2504i(4312);
        C43727b c43727b = (C43727b) C7485q.m12925Y(C43727b.class);
        AppMethodBeat.m2505o(4312);
        return c43727b;
    }

    public static C14058r cIj() {
        AppMethodBeat.m2504i(4313);
        if (C1720g.m3531RK()) {
            if (C43727b.cIi().sMZ == null) {
                C43727b.cIi().sMZ = new C14058r();
            }
            C14058r c14058r = C43727b.cIi().sMZ;
            AppMethodBeat.m2505o(4313);
            return c14058r;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(4313);
        throw c1819b;
    }

    public static C40039d cIk() {
        AppMethodBeat.m2504i(4314);
        if (C1720g.m3531RK()) {
            if (C43727b.cIi().sNb == null) {
                C43727b.cIi().sNb = new C40039d();
            }
            C40039d c40039d = C43727b.cIi().sNb;
            AppMethodBeat.m2505o(4314);
            return c40039d;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(4314);
        throw c1819b;
    }

    public static int cIl() {
        return sNe;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(4315);
        if (this.sNb != null) {
            C5004al.m7441d(new C400261());
        }
        C1200d.m2637b(Integer.valueOf(50), this.sNa);
        C43727b.cIj();
        C4879a.xxA.mo10053d(this.sNc);
        C4879a.xxA.mo10053d(this.sNd);
        C32427a c32427a = C32427a.xtM;
        C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "unInit");
        C4879a.xxA.mo10053d(c32427a.fAP);
        AppMethodBeat.m2505o(4315);
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
        AppMethodBeat.m2504i(4316);
        C1200d.m2636a(Integer.valueOf(50), this.sNa);
        C43727b.cIj();
        C4879a.xxA.mo10052c(this.sNc);
        C4879a.xxA.mo10052c(this.sNd);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73217, Boolean.TRUE)).booleanValue();
        boolean booleanValue2 = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
        boolean MG = C37885a.m63954MG();
        C4990ab.m7417i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(MG), Boolean.valueOf(((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()));
        if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            boolean z2 = booleanValue || booleanValue2;
            if (z2 != MG) {
                if (z2 && !MG) {
                    C7060h.pYm.mo8378a(500, 13, 1, false);
                } else if (!z2 && MG) {
                    C7060h.pYm.mo8378a(500, 14, 1, false);
                }
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOIP_MSG_SOUND_DIFF_STAT_BOOLEAN_SYNC, Boolean.TRUE);
        }
        C18611au.m29048kB(1);
        C4990ab.m7416i("MicroMsg.SubCoreVoip", "start init beauty download");
        C32427a c32427a = C32427a.xtM;
        C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "init, downloadSoPath: %s, downloadResPath: %s", C32427a.xtJ, C32427a.xtK);
        C4879a.xxA.mo10051b(c32427a.fAP);
        C14845c.veg;
        C14839b.m23095Ky(56);
        if (C32427a.agb()) {
            C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "init check local has resource");
            C32427a.xtL = true;
            C7060h.pYm.mo8381e(15861, Integer.valueOf(0), Integer.valueOf(1));
            C7060h.pYm.mo15419k(914, 0, 1);
        } else {
            C7060h.pYm.mo15419k(914, 1, 1);
            C14845c.veg;
            String gM = C14839b.m23097gM(56, 1);
            if (C5730e.m8628ct(gM)) {
                C4990ab.m7417i("MicroMsg.BeautyDownloadLogic", "init, cache file %s exist, try unzip", gM);
                C7060h.pYm.mo15419k(914, 2, 1);
                c32427a.mo53067e(gM, 56, 1, 1);
            } else {
                C4990ab.m7416i("MicroMsg.BeautyDownloadLogic", "init cannot find beauty resource");
                C7060h.pYm.mo8381e(15861, Integer.valueOf(0), Integer.valueOf(2));
            }
        }
        try {
            int initAuth = YTCommonInterface.initAuth(C4996ah.getContext(), "rel_wechat.lic", 0, true);
            sNe = initAuth;
            C4990ab.m7417i("MicroMsg.SubCoreVoip", "init VideoModule initAuth: %s", Integer.valueOf(initAuth));
            if (initAuth != 0) {
                C7060h.pYm.mo15419k(914, 12, 1);
            }
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.SubCoreVoip", th, "init youtu sdk failed: %s", th.getMessage());
            sNe = -1;
            C7060h.pYm.mo15419k(914, 12, 1);
        }
        FilterRawGet.setGetInputStream(new C314532());
        AppMethodBeat.m2505o(4316);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
