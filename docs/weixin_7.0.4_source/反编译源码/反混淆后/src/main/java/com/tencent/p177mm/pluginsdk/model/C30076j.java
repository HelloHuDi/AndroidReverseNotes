package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1380j.C45291a;
import com.tencent.p177mm.compatible.p1380j.C45291a.C41941a;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.modelvideo.C9713a;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.p838bj.C9084g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p878a.C26531d;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.j */
public final class C30076j extends Thread {
    private static int ehv;
    private static HashMap<String, C30078b> uPs = new HashMap();
    private static Object uPt = new byte[0];
    private static C23498az uPu;
    private Context context;
    private Intent intent;
    private boolean isStop;
    private String talker;
    private List<String> uPi;
    private List<Integer> uPj = new ArrayList();
    private List<String> uPk = new ArrayList();
    private List<String> uPl = new ArrayList();
    private List<Integer> uPm = new ArrayList();
    private int vbg;
    private C30077a vbh;

    /* renamed from: com.tencent.mm.pluginsdk.model.j$1 */
    class C300751 implements Runnable {
        C300751() {
        }

        public final void run() {
            AppMethodBeat.m2504i(50971);
            C30077a e = C30076j.this.vbh;
            C30076j.this.uPj;
            C30076j.this.uPk;
            C30076j.this.uPl;
            C30076j.this.uPm;
            e.dhi();
            AppMethodBeat.m2505o(50971);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.j$a */
    public interface C30077a {
        void dhi();
    }

    /* renamed from: com.tencent.mm.pluginsdk.model.j$b */
    static final class C30078b implements C23499a {
        private int eYk;
        private int eYl;
        String fUG;
        VideoTransPara fWR;
        String fileName;
        String hzq;
        boolean ozx;
        String toUser;
        int uPx;
        private boolean uPy;
        private int uPz;
        int vbg;
        C9084g vbj;

        private C30078b() {
            this.uPz = 0;
            this.ozx = false;
        }

        /* synthetic */ C30078b(byte b) {
            this();
        }

        public final boolean acf() {
            Object obj;
            AppMethodBeat.m2504i(50972);
            synchronized (C30076j.uPt) {
                try {
                    obj = !C30076j.uPs.containsKey(this.fileName) ? 1 : null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(50972);
                }
            }
            if (obj == null) {
                obj = C26494u.m42268ut(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                C4990ab.m7421w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.fileName);
                return true;
            }
            C30076j.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(C30076j.ehv));
            if (this.fWR == null || this.fWR.isDefault) {
                int[] iArr = new int[2];
                C30076j.m47631c(this.fUG, iArr);
                this.eYk = iArr[0];
                this.eYl = iArr[1];
            } else {
                this.eYk = this.fWR.width;
                this.eYl = this.fWR.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (!((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16777a(this.fUG, pString, pInt) || C5730e.m8644y(pString.value, this.hzq) < 0) {
                long yz = C5046bo.m7588yz();
                if (this.fWR != null) {
                    C4990ab.m7417i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.fWR);
                    if (C29014b.qwX) {
                        this.fWR.videoBitrate = (int) (((double) this.fWR.videoBitrate) * 0.915d);
                    }
                    if (this.ozx) {
                        C7060h.pYm.mo8378a(354, 245, 1, false);
                        if (C17987e.m28300a(this.fUG, this.hzq, this.fWR) < 0) {
                            C7060h.pYm.mo8378a(354, 246, 1, false);
                        }
                    } else {
                        this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, C29014b.qwX);
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.fileName);
                    if (C29014b.qwX) {
                        C29014b.qwZ = (int) (((double) C29014b.qwZ) * 0.915d);
                    }
                    if (this.ozx) {
                        this.fWR = new VideoTransPara();
                        this.fWR.width = this.eYk;
                        this.fWR.height = this.eYl;
                        this.fWR.videoBitrate = C29014b.qwZ;
                        this.fWR.fzV = C29014b.qwY;
                        this.fWR.fzU = 2;
                        this.fWR.fps = (int) C29014b.qxa;
                        this.fWR.duration = C17987e.m28306ea(this.fUG);
                        C17987e.m28300a(this.fUG, this.hzq, this.fWR);
                    } else {
                        this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, C29014b.qwZ, C29014b.qwY, 8, 2, 25.0f, C29014b.qxa, null, 0, C29014b.qwX);
                    }
                }
                this.uPz = (int) C5046bo.m7525az(yz);
                C4990ab.m7417i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.fUG, this.hzq, Integer.valueOf(this.uPx), Integer.valueOf(this.eYk), Integer.valueOf(this.eYl));
                this.uPy = this.uPx >= 0;
                PInt pInt2 = new PInt();
                if (C26494u.m42241a(this.hzq, pInt2, new PInt())) {
                    this.uPx = pInt2.value;
                }
                if (this.uPy) {
                    C4990ab.m7416i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                    try {
                        String name = new C5728b(this.hzq).getName();
                        String str = this.hzq + ".tmp";
                        PInt pInt3 = new PInt(0);
                        if (C26531d.m42370b(this.hzq, str, pInt3)) {
                            boolean deleteFile = C5730e.deleteFile(this.hzq);
                            C5728b c5728b = new C5728b(str);
                            boolean h = C5730e.m8633h(c5728b.getParent() + "/", c5728b.getName(), name);
                            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(h), C5736j.m8649w(c5728b.dMD()), this.hzq);
                            C7060h.pYm.mo8378a(354, 30, 1, false);
                        } else {
                            if (pInt3.value != 1) {
                                C7060h.pYm.mo8378a(354, 31, 1, false);
                            } else {
                                C7060h.pYm.mo8378a(354, 32, 1, false);
                                C7060h.pYm.mo8381e(13836, Integer.valueOf(600), Long.valueOf(C5046bo.anT()), this.hzq);
                            }
                            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.fUG, this.hzq);
                        }
                        ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16776P(this.fUG, this.hzq, this.uPx);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", e.toString());
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                    C5730e.deleteFile(this.hzq);
                    C5730e.m8644y(this.fUG, this.hzq);
                }
                if (C30076j.ehv != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, C30076j.ehv);
                    C4990ab.m7417i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(C30076j.ehv));
                    C30076j.ehv = 0;
                }
                AppMethodBeat.m2505o(50972);
                return true;
            }
            C4990ab.m7416i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
            this.uPx = pInt.value;
            this.uPy = true;
            AppMethodBeat.m2505o(50972);
            return true;
        }

        public final boolean acg() {
            int i;
            int i2;
            AppMethodBeat.m2504i(50973);
            synchronized (C30076j.uPt) {
                try {
                    C30076j.uPs.remove(this.fileName);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(50973);
                    }
                }
            }
            if (this.uPy) {
                C30076j.m47634dU(this.hzq, this.vbg);
            } else {
                C30076j.m47635dV(this.hzq, this.vbg);
            }
            C30076j.m47639f(this.uPy, this.fUG, this.hzq);
            if (C29014b.qwX) {
                i = 1;
            } else {
                i = 0;
            }
            C30076j.m47626a(i, this.uPz, this.fUG, this.hzq, this.uPx);
            if (this.vbg == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            C45459n.alj().mo73267a(this.fUG, this.hzq, this.toUser, "", "", i2, this.uPy ? 1 : 3);
            C26494u.m42257n(this.fileName, this.uPx, 43);
            C26494u.m42263uo(this.fileName);
            AppMethodBeat.m2505o(50973);
            return false;
        }
    }

    /* renamed from: dV */
    static /* synthetic */ void m47635dV(String str, int i) {
        AppMethodBeat.m2504i(50994);
        C30076j.m47633dT(str, i);
        AppMethodBeat.m2505o(50994);
    }

    /* renamed from: f */
    static /* synthetic */ void m47639f(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(50995);
        C30076j.m47638e(z, str, str2);
        AppMethodBeat.m2505o(50995);
    }

    static {
        AppMethodBeat.m2504i(50997);
        AppMethodBeat.m2505o(50997);
    }

    public C30076j(Context context, List<String> list, Intent intent, String str, int i, C30077a c30077a) {
        AppMethodBeat.m2504i(50974);
        this.context = context;
        this.uPi = list;
        this.intent = intent;
        this.vbh = c30077a;
        this.talker = str;
        this.vbg = i;
        AppMethodBeat.m2505o(50974);
    }

    public final void run() {
        AppMethodBeat.m2504i(50975);
        if (this.uPi == null || this.uPi.size() <= 0) {
            m47623E(this.context, this.intent);
        } else {
            for (int i = 0; i < this.uPi.size() && !this.isStop; i++) {
                C4990ab.m7417i("MicroMsg.ImportMultiVideo", "start to import %s", this.uPi.get(i));
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.uPi.get(i))));
                m47623E(this.context, intent);
            }
        }
        if (!(this.vbh == null || this.isStop)) {
            C5004al.m7441d(new C300751());
        }
        AppMethodBeat.m2505o(50975);
    }

    /* renamed from: E */
    private void m47623E(Context context, Intent intent) {
        AppMethodBeat.m2504i(50976);
        String ug = C9720t.m17302ug((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) ""));
        C37961o.all();
        String ui = C9720t.m17304ui(ug);
        C37961o.all();
        String uh = C9720t.m17303uh(ug);
        boolean is2G = C5023at.is2G(C4996ah.getContext());
        String i = C45291a.m83514i(context, intent);
        if (C5046bo.isNullOrNil(i)) {
            C4990ab.m7412e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            m47627a(-50005, ug, i, 0, null, intent);
            AppMethodBeat.m2505o(50976);
            return;
        }
        int i2;
        VideoTransPara videoTransPara;
        Object obj;
        int i3;
        C41941a j;
        int asZ = (int) C5730e.asZ(i);
        if (C42258c.m74643vC(i)) {
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(C42258c.m74643vC(i)));
            PInt pInt = new PInt();
            VideoTransPara a = C30076j.m47624a(i, pInt);
            i2 = pInt.value;
            videoTransPara = a;
        } else {
            if (asZ > (is2G ? 10485760 : 26214400)) {
                i2 = -5;
                videoTransPara = null;
            } else {
                C4990ab.m7417i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(r5));
                i2 = 1;
                videoTransPara = null;
            }
        }
        C4990ab.m7417i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i2), Boolean.valueOf(r5), Integer.valueOf(asZ));
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                m47627a(-50002, ug, i, 0, null, intent);
                AppMethodBeat.m2505o(50976);
                return;
            case -5:
                m47627a(-50008, ug, i, 0, null, intent);
                AppMethodBeat.m2505o(50976);
                return;
            case -1:
                m47627a(-50007, ug, i, 0, null, intent);
                AppMethodBeat.m2505o(50976);
                return;
            case 0:
                obj = 1;
                i3 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (asZ <= 26214400) {
                    obj = null;
                    i3 = 0;
                    break;
                }
                m47627a(-50002, ug, i, 0, null, intent);
                obj = null;
                i3 = -50002;
                break;
            default:
                C4990ab.m7412e("MicroMsg.ImportMultiVideo", "unknown check type");
                m47627a(-50001, ug, i, 0, null, intent);
                AppMethodBeat.m2505o(50976);
                return;
        }
        C41941a c41941a = null;
        try {
            j = C45291a.m83515j(context, intent);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            j = c41941a;
        }
        if (j == null) {
            C4990ab.m7412e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            m47627a(-50005, ug, i, 0, null, intent);
            AppMethodBeat.m2505o(50976);
            return;
        }
        if (obj == null) {
            C5730e.m8644y(i, uh);
            C30076j.m47633dT(uh, this.vbg);
            C30076j.m47638e(false, i, uh);
        } else {
            i3 = -50006;
        }
        int mA = C5046bo.m7576mA((long) j.duration);
        Object obj2 = 1;
        if (j.bitmap != null) {
            try {
                C5056d.m7625a(j.bitmap, 60, CompressFormat.JPEG, ui, true);
                obj2 = null;
                m47640ou(true);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                m47640ou(false);
                C5056d.m7625a(C5056d.m7644au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ui, true);
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !C5730e.m8628ct(uh)) {
            i3 = -50003;
        }
        if (!C5730e.m8628ct(ui)) {
            i3 = -50004;
        }
        m47627a(i3, ug, i, mA, videoTransPara, intent);
        AppMethodBeat.m2505o(50976);
    }

    public final void dhb() {
        AppMethodBeat.m2504i(50977);
        this.isStop = true;
        interrupt();
        AppMethodBeat.m2505o(50977);
    }

    /* renamed from: a */
    private void m47627a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        AppMethodBeat.m2504i(50978);
        C4990ab.m7417i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        m47637e(i, str, str2, i2);
        if (i == -50002) {
            dhd();
            m47628a(this.talker, str, str2, intent, i2, 141);
            AppMethodBeat.m2505o(50978);
        } else if (i == -50008) {
            C30076j.dhf();
            m47628a(this.talker, str, str2, intent, i2, 140);
            AppMethodBeat.m2505o(50978);
        } else if (i == -50006) {
            if (C26494u.m42258t(str, this.talker, str2) < 0) {
                m47628a(this.talker, str, str2, intent, i2, (int) ErrorCode.NEEDDOWNLOAD_3);
                C4990ab.m7412e("MicroMsg.ImportMultiVideo", "prepare");
                AppMethodBeat.m2505o(50978);
                return;
            }
            if (uPu == null) {
                uPu = new C23498az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            C30078b c30078b = new C30078b();
            synchronized (uPt) {
                try {
                    uPs.put(str, c30078b);
                } finally {
                    while (true) {
                    }
                    int i3 = c30078b;
                    AppMethodBeat.m2505o(50978);
                }
            }
            c30078b.fileName = str;
            c30078b.fUG = str2;
            C37961o.all();
            c30078b.hzq = C9720t.m17303uh(str);
            c30078b.vbg = this.vbg;
            c30078b.toUser = this.talker;
            c30078b.fWR = videoTransPara;
            c30078b.ozx = C17987e.m28307uD(str2);
            c30078b.vbj = new C9084g();
            uPu.mo39163e(c30078b);
        } else if (i < 0) {
            dhe();
            m47628a(this.talker, str, str2, intent, i2, (int) ErrorCode.NEEDDOWNLOAD_3);
            AppMethodBeat.m2505o(50978);
        } else {
            C26494u.m42246c(str, i2, this.talker, str2);
            C26494u.m42263uo(str);
            int i4 = this.vbg == 1 ? 8 : 1;
            C37961o.all();
            C45459n.alj().mo73267a(str2, C9720t.m17303uh(str), this.talker, "", "", i4, 2);
            AppMethodBeat.m2505o(50978);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m47628a(String str, String str2, String str3, Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(50979);
        C7620bi c7620bi = new C7620bi();
        c7620bi.setStatus(5);
        c7620bi.mo14794ju(str);
        c7620bi.mo14775eJ(C1829bf.m3756oC(str));
        c7620bi.mo14781hO(1);
        c7620bi.mo14795jv(str2);
        c7620bi.setType(43);
        long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        C4990ab.m7417i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_talker, Integer.valueOf(c7620bi.getType()), Integer.valueOf(c7620bi.field_isSend), c7620bi.field_imgPath, Integer.valueOf(c7620bi.field_status), Long.valueOf(c7620bi.field_createTime));
        if (-1 == Z) {
            C4990ab.m7413e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", str);
            AppMethodBeat.m2505o(50979);
            return;
        }
        if (C26494u.m42268ut(str2) == null) {
            C37961o.all();
            String ui = C9720t.m17304ui(str2);
            try {
                C41941a j = C45291a.m83515j(this.context, intent);
                int uj;
                int uj2;
                C26493s c26493s;
                if (j == null || j.bitmap == null) {
                    C5056d.m7625a(C5056d.m7644au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ui, true);
                    uj = C9720t.m17305uj(ui);
                    C37961o.all();
                    uj2 = C9720t.m17305uj(C9720t.m17303uh(str2));
                    c26493s = new C26493s();
                    c26493s.fileName = str2;
                    if (uj2 <= 0) {
                        uj2 = 0;
                    }
                    c26493s.frO = uj2;
                    c26493s.fXa = uj;
                    c26493s.fXd = i;
                    c26493s.cIS = str;
                    c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
                    c26493s.createTime = C5046bo.anT();
                    c26493s.fXb = C5046bo.anT();
                    c26493s.fXj = null;
                    c26493s.fUG = str3;
                    if (!C5046bo.isNullOrNil(str3)) {
                        c26493s.fXh = 1;
                    }
                    c26493s.fXk = -1;
                    c26493s.status = i2;
                    c26493s.fXe = (int) Z;
                    if (!C37961o.all().mo21059b(c26493s)) {
                        C4990ab.m7413e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(Z));
                    }
                } else {
                    i = C5046bo.m7576mA((long) j.duration);
                    C5056d.m7625a(j.bitmap, 60, CompressFormat.JPEG, ui, true);
                    uj = C9720t.m17305uj(ui);
                    C37961o.all();
                    uj2 = C9720t.m17305uj(C9720t.m17303uh(str2));
                    c26493s = new C26493s();
                    c26493s.fileName = str2;
                    if (uj2 <= 0) {
                    }
                    c26493s.frO = uj2;
                    c26493s.fXa = uj;
                    c26493s.fXd = i;
                    c26493s.cIS = str;
                    c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
                    c26493s.createTime = C5046bo.anT();
                    c26493s.fXb = C5046bo.anT();
                    c26493s.fXj = null;
                    c26493s.fUG = str3;
                    if (C5046bo.isNullOrNil(str3)) {
                    }
                    c26493s.fXk = -1;
                    c26493s.status = i2;
                    c26493s.fXe = (int) Z;
                    if (C37961o.all().mo21059b(c26493s)) {
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(50979);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static void m47631c(String str, int[] iArr) {
        Throwable th;
        AppMethodBeat.m2504i(50980);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i;
                iArr[1] = i2;
                int i3 = 0;
                while (i3 < 3) {
                    if (i % 2 == 0 && i2 % 2 == 0) {
                        if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                            break;
                        }
                        i /= 2;
                        i2 /= 2;
                        i3++;
                    } else {
                        mediaMetadataRetriever.release();
                        if (iArr[0] % 2 != 0) {
                            iArr[0] = iArr[0] + 1;
                        }
                        if (iArr[1] % 2 != 0) {
                            iArr[1] = iArr[1] + 1;
                        }
                        AppMethodBeat.m2505o(50980);
                        return;
                    }
                }
                iArr[0] = i;
                iArr[1] = i2;
                mediaMetadataRetriever.release();
                if (iArr[0] % 2 != 0) {
                    iArr[0] = iArr[0] + 1;
                }
                if (iArr[1] % 2 != 0) {
                    iArr[1] = iArr[1] + 1;
                    AppMethodBeat.m2505o(50980);
                    return;
                }
                AppMethodBeat.m2505o(50980);
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                }
                if (iArr[0] % 2 != 0) {
                }
                if (iArr[1] % 2 != 0) {
                }
                AppMethodBeat.m2505o(50980);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            if (iArr[0] % 2 != 0) {
                iArr[0] = iArr[0] + 1;
            }
            if (iArr[1] % 2 != 0) {
                iArr[1] = iArr[1] + 1;
            }
            AppMethodBeat.m2505o(50980);
            throw th;
        }
    }

    /* renamed from: e */
    private synchronized void m47637e(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(50981);
        this.uPj.add(Integer.valueOf(i));
        this.uPk.add(str);
        this.uPl.add(str2);
        this.uPm.add(Integer.valueOf(i2));
        AppMethodBeat.m2505o(50981);
    }

    public static void dhc() {
        int size;
        AppMethodBeat.m2504i(50982);
        synchronized (uPt) {
            try {
                size = uPs.size();
                uPs.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(50982);
            }
        }
        if (uPu == null) {
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            return;
        }
        C4990ab.m7417i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(uPu.xAV.size()));
        uPu.xAV.clear();
        uPu = null;
        AppMethodBeat.m2505o(50982);
    }

    public static boolean aiB(String str) {
        boolean containsKey;
        AppMethodBeat.m2504i(50983);
        synchronized (uPt) {
            try {
                containsKey = uPs.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(50983);
            }
        }
        C4990ab.m7417i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        return containsKey;
    }

    public static void aiC(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(50984);
        synchronized (uPt) {
            try {
                if (uPs.remove(str) == null) {
                    z = false;
                }
                C4990ab.m7417i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(50984);
            }
        }
    }

    /* renamed from: a */
    private static VideoTransPara m47624a(String str, PInt pInt) {
        AppMethodBeat.m2504i(50985);
        if (C42204d.afF().mo67743rT(str)) {
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", str);
            pInt.value = 1;
            C30076j.dhg();
            AppMethodBeat.m2505o(50985);
            return null;
        }
        VideoTransPara uE = C17987e.m28308uE(str);
        Boolean valueOf = Boolean.valueOf(C17987e.m28307uD(str));
        C4990ab.m7411d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", uE);
        VideoTransPara b = C42204d.afF().mo67741b(uE);
        if (b == null) {
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", uE);
            pInt.value = -5;
            AppMethodBeat.m2505o(50985);
            return null;
        }
        C4990ab.m7411d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", b);
        if (uE.videoBitrate <= 640000 || b.videoBitrate > uE.videoBitrate) {
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", b, uE);
            if (valueOf.booleanValue()) {
                pInt.value = 0;
                AppMethodBeat.m2505o(50985);
                return uE;
            }
            pInt.value = 1;
            AppMethodBeat.m2505o(50985);
            return null;
        } else if (uE.fps < 45 || uE.duration * 1000 < 180000) {
            if (valueOf.booleanValue()) {
                pInt.value = 0;
            } else {
                boolean is2G = C5023at.is2G(C4996ah.getContext());
                pInt.value = SightVideoJNI.shouldRemuxing(str, b.width, b.height, is2G ? 10485760 : 26214400, is2G ? 60000.0d : 300000.0d, 1000000);
            }
            AppMethodBeat.m2505o(50985);
            return b;
        } else {
            pInt.value = -6;
            AppMethodBeat.m2505o(50985);
            return null;
        }
    }

    /* renamed from: ou */
    private void m47640ou(boolean z) {
        int i;
        AppMethodBeat.m2504i(50986);
        if (this.vbg == 1) {
            if (z) {
                i = 217;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        C4990ab.m7410d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.vbg);
        C7060h.pYm.mo8378a(106, (long) i, 1, false);
        AppMethodBeat.m2505o(50986);
    }

    private void dhd() {
        int i;
        AppMethodBeat.m2504i(50987);
        if (this.vbg == 1) {
            i = 230;
        } else {
            i = C31128d.MIC_PTU_ZIPAI_LIGHTWHITE;
        }
        C4990ab.m7410d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.vbg);
        C7060h.pYm.mo8378a(106, (long) i, 1, false);
        AppMethodBeat.m2505o(50987);
    }

    private void dhe() {
        int i;
        AppMethodBeat.m2504i(50988);
        if (this.vbg == 1) {
            i = 229;
        } else {
            i = 244;
        }
        C4990ab.m7410d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.vbg);
        C7060h.pYm.mo8378a(106, (long) i, 1, false);
        AppMethodBeat.m2505o(50988);
    }

    /* renamed from: dT */
    private static void m47633dT(String str, int i) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.m2504i(50989);
        if (i == 1) {
            i2 = 220;
            i3 = 228;
            i4 = 219;
        } else {
            i2 = C31128d.MIC_PTU_FENGJING;
            i3 = 242;
            i4 = C31128d.MIC_PTU_MEISHI;
        }
        long asZ = C5730e.asZ(str);
        int h = C5046bo.m7567h((Integer) C7060h.m11789a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, i2, i3));
        C7060h.pYm.mo8378a(106, (long) h, 1, false);
        C7060h.pYm.mo8378a(106, (long) i4, 1, false);
        C4990ab.m7410d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + h + " file len : " + (asZ / 1024) + "K");
        AppMethodBeat.m2505o(50989);
    }

    private static void dhf() {
        AppMethodBeat.m2504i(50990);
        C7060h.pYm.mo8378a(106, 210, 1, false);
        AppMethodBeat.m2505o(50990);
    }

    private static void dhg() {
        AppMethodBeat.m2504i(50991);
        C7060h.pYm.mo8378a(422, 51, 1, false);
        AppMethodBeat.m2505o(50991);
    }

    /* renamed from: e */
    private static void m47638e(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(50992);
        C9713a.m17289j(z ? 1 : 0, str, str2);
        AppMethodBeat.m2505o(50992);
    }

    /* renamed from: dU */
    static /* synthetic */ void m47634dU(String str, int i) {
        AppMethodBeat.m2504i(50993);
        if (i == 2) {
            long asZ = C5730e.asZ(str);
            int h = C5046bo.m7567h((Integer) C7060h.m11789a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, 247, 255));
            C7060h.pYm.mo8378a(106, (long) h, 1, false);
            C7060h.pYm.mo8378a(106, 246, 1, false);
            C4990ab.m7410d("MicroMsg.ImportMultiVideo", "report compress video report id : " + h + " file len : " + (asZ / 1024) + "K");
        }
        AppMethodBeat.m2505o(50993);
    }

    /* renamed from: a */
    static /* synthetic */ void m47626a(int i, int i2, String str, String str2, int i3) {
        AppMethodBeat.m2504i(50996);
        long asZ = C5730e.asZ(str);
        if (asZ > 0) {
            int asZ2 = (int) ((100 * C5730e.asZ(str2)) / asZ);
            C4990ab.m7417i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", Integer.valueOf(i), Long.valueOf(asZ), Long.valueOf(C5730e.asZ(str2)), Integer.valueOf(asZ2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            C7060h.pYm.mo8381e(13432, Integer.valueOf(i), Long.valueOf(asZ), Long.valueOf(r2), Integer.valueOf(asZ2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            AppMethodBeat.m2505o(50996);
            return;
        }
        C4990ab.m7412e("MicroMsg.ImportMultiVideo", "file canot be empty");
        AppMethodBeat.m2505o(50996);
    }
}
