package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.g;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class j extends Thread {
    private static int ehv;
    private static HashMap<String, b> uPs = new HashMap();
    private static Object uPt = new byte[0];
    private static az uPu;
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
    private a vbh;

    public interface a {
        void dhi();
    }

    static final class b implements com.tencent.mm.sdk.platformtools.az.a {
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
        g vbj;

        private b() {
            this.uPz = 0;
            this.ozx = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final boolean acf() {
            Object obj;
            AppMethodBeat.i(50972);
            synchronized (j.uPt) {
                try {
                    obj = !j.uPs.containsKey(this.fileName) ? 1 : null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(50972);
                }
            }
            if (obj == null) {
                obj = u.ut(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                ab.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.fileName);
                return true;
            }
            j.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            ab.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(j.ehv));
            if (this.fWR == null || this.fWR.isDefault) {
                int[] iArr = new int[2];
                j.c(this.fUG, iArr);
                this.eYk = iArr[0];
                this.eYl = iArr[1];
            } else {
                this.eYk = this.fWR.width;
                this.eYl = this.fWR.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (!((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.m.a.a.class)).XT().a(this.fUG, pString, pInt) || e.y(pString.value, this.hzq) < 0) {
                long yz = bo.yz();
                if (this.fWR != null) {
                    ab.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.fWR);
                    if (com.tencent.mm.plugin.sight.base.b.qwX) {
                        this.fWR.videoBitrate = (int) (((double) this.fWR.videoBitrate) * 0.915d);
                    }
                    if (this.ozx) {
                        h.pYm.a(354, 245, 1, false);
                        if (com.tencent.mm.bj.e.a(this.fUG, this.hzq, this.fWR) < 0) {
                            h.pYm.a(354, 246, 1, false);
                        }
                    } else {
                        this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, com.tencent.mm.plugin.sight.base.b.qwX);
                    }
                } else {
                    ab.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.fileName);
                    if (com.tencent.mm.plugin.sight.base.b.qwX) {
                        com.tencent.mm.plugin.sight.base.b.qwZ = (int) (((double) com.tencent.mm.plugin.sight.base.b.qwZ) * 0.915d);
                    }
                    if (this.ozx) {
                        this.fWR = new VideoTransPara();
                        this.fWR.width = this.eYk;
                        this.fWR.height = this.eYl;
                        this.fWR.videoBitrate = com.tencent.mm.plugin.sight.base.b.qwZ;
                        this.fWR.fzV = com.tencent.mm.plugin.sight.base.b.qwY;
                        this.fWR.fzU = 2;
                        this.fWR.fps = (int) com.tencent.mm.plugin.sight.base.b.qxa;
                        this.fWR.duration = com.tencent.mm.bj.e.ea(this.fUG);
                        com.tencent.mm.bj.e.a(this.fUG, this.hzq, this.fWR);
                    } else {
                        this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, com.tencent.mm.plugin.sight.base.b.qwZ, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qxa, null, 0, com.tencent.mm.plugin.sight.base.b.qwX);
                    }
                }
                this.uPz = (int) bo.az(yz);
                ab.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.fUG, this.hzq, Integer.valueOf(this.uPx), Integer.valueOf(this.eYk), Integer.valueOf(this.eYl));
                this.uPy = this.uPx >= 0;
                PInt pInt2 = new PInt();
                if (u.a(this.hzq, pInt2, new PInt())) {
                    this.uPx = pInt2.value;
                }
                if (this.uPy) {
                    ab.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                    try {
                        String name = new com.tencent.mm.vfs.b(this.hzq).getName();
                        String str = this.hzq + ".tmp";
                        PInt pInt3 = new PInt(0);
                        if (d.b(this.hzq, str, pInt3)) {
                            boolean deleteFile = e.deleteFile(this.hzq);
                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                            boolean h = e.h(bVar.getParent() + "/", bVar.getName(), name);
                            ab.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(h), com.tencent.mm.vfs.j.w(bVar.dMD()), this.hzq);
                            h.pYm.a(354, 30, 1, false);
                        } else {
                            if (pInt3.value != 1) {
                                h.pYm.a(354, 31, 1, false);
                            } else {
                                h.pYm.a(354, 32, 1, false);
                                h.pYm.e(13836, Integer.valueOf(600), Long.valueOf(bo.anT()), this.hzq);
                            }
                            ab.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.fUG, this.hzq);
                        }
                        ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.m.a.a.class)).XT().P(this.fUG, this.hzq, this.uPx);
                    } catch (Exception e) {
                        ab.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", e.toString());
                    }
                } else {
                    ab.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                    e.deleteFile(this.hzq);
                    e.y(this.fUG, this.hzq);
                }
                if (j.ehv != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, j.ehv);
                    ab.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(j.ehv));
                    j.ehv = 0;
                }
                AppMethodBeat.o(50972);
                return true;
            }
            ab.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
            this.uPx = pInt.value;
            this.uPy = true;
            AppMethodBeat.o(50972);
            return true;
        }

        public final boolean acg() {
            int i;
            int i2;
            AppMethodBeat.i(50973);
            synchronized (j.uPt) {
                try {
                    j.uPs.remove(this.fileName);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(50973);
                    }
                }
            }
            if (this.uPy) {
                j.dU(this.hzq, this.vbg);
            } else {
                j.dV(this.hzq, this.vbg);
            }
            j.f(this.uPy, this.fUG, this.hzq);
            if (com.tencent.mm.plugin.sight.base.b.qwX) {
                i = 1;
            } else {
                i = 0;
            }
            j.a(i, this.uPz, this.fUG, this.hzq, this.uPx);
            if (this.vbg == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            n.alj().a(this.fUG, this.hzq, this.toUser, "", "", i2, this.uPy ? 1 : 3);
            u.n(this.fileName, this.uPx, 43);
            u.uo(this.fileName);
            AppMethodBeat.o(50973);
            return false;
        }
    }

    static /* synthetic */ void dV(String str, int i) {
        AppMethodBeat.i(50994);
        dT(str, i);
        AppMethodBeat.o(50994);
    }

    static /* synthetic */ void f(boolean z, String str, String str2) {
        AppMethodBeat.i(50995);
        e(z, str, str2);
        AppMethodBeat.o(50995);
    }

    static {
        AppMethodBeat.i(50997);
        AppMethodBeat.o(50997);
    }

    public j(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        AppMethodBeat.i(50974);
        this.context = context;
        this.uPi = list;
        this.intent = intent;
        this.vbh = aVar;
        this.talker = str;
        this.vbg = i;
        AppMethodBeat.o(50974);
    }

    public final void run() {
        AppMethodBeat.i(50975);
        if (this.uPi == null || this.uPi.size() <= 0) {
            E(this.context, this.intent);
        } else {
            for (int i = 0; i < this.uPi.size() && !this.isStop; i++) {
                ab.i("MicroMsg.ImportMultiVideo", "start to import %s", this.uPi.get(i));
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.uPi.get(i))));
                E(this.context, intent);
            }
        }
        if (!(this.vbh == null || this.isStop)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50971);
                    a e = j.this.vbh;
                    j.this.uPj;
                    j.this.uPk;
                    j.this.uPl;
                    j.this.uPm;
                    e.dhi();
                    AppMethodBeat.o(50971);
                }
            });
        }
        AppMethodBeat.o(50975);
    }

    private void E(Context context, Intent intent) {
        AppMethodBeat.i(50976);
        String ug = t.ug((String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) ""));
        o.all();
        String ui = t.ui(ug);
        o.all();
        String uh = t.uh(ug);
        boolean is2G = at.is2G(ah.getContext());
        String i = com.tencent.mm.compatible.j.a.i(context, intent);
        if (bo.isNullOrNil(i)) {
            ab.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, ug, i, 0, null, intent);
            AppMethodBeat.o(50976);
            return;
        }
        int i2;
        VideoTransPara videoTransPara;
        Object obj;
        int i3;
        com.tencent.mm.compatible.j.a.a j;
        int asZ = (int) e.asZ(i);
        if (c.vC(i)) {
            ab.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(c.vC(i)));
            PInt pInt = new PInt();
            VideoTransPara a = a(i, pInt);
            i2 = pInt.value;
            videoTransPara = a;
        } else {
            if (asZ > (is2G ? 10485760 : 26214400)) {
                i2 = -5;
                videoTransPara = null;
            } else {
                ab.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(r5));
                i2 = 1;
                videoTransPara = null;
            }
        }
        ab.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i2), Boolean.valueOf(r5), Integer.valueOf(asZ));
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, ug, i, 0, null, intent);
                AppMethodBeat.o(50976);
                return;
            case -5:
                a(-50008, ug, i, 0, null, intent);
                AppMethodBeat.o(50976);
                return;
            case -1:
                a(-50007, ug, i, 0, null, intent);
                AppMethodBeat.o(50976);
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
                a(-50002, ug, i, 0, null, intent);
                obj = null;
                i3 = -50002;
                break;
            default:
                ab.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, ug, i, 0, null, intent);
                AppMethodBeat.o(50976);
                return;
        }
        com.tencent.mm.compatible.j.a.a aVar = null;
        try {
            j = com.tencent.mm.compatible.j.a.j(context, intent);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            ab.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, ug, i, 0, null, intent);
            AppMethodBeat.o(50976);
            return;
        }
        if (obj == null) {
            e.y(i, uh);
            dT(uh, this.vbg);
            e(false, i, uh);
        } else {
            i3 = -50006;
        }
        int mA = bo.mA((long) j.duration);
        Object obj2 = 1;
        if (j.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, ui, true);
                obj2 = null;
                ou(true);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                ou(false);
                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ui, true);
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !e.ct(uh)) {
            i3 = -50003;
        }
        if (!e.ct(ui)) {
            i3 = -50004;
        }
        a(i3, ug, i, mA, videoTransPara, intent);
        AppMethodBeat.o(50976);
    }

    public final void dhb() {
        AppMethodBeat.i(50977);
        this.isStop = true;
        interrupt();
        AppMethodBeat.o(50977);
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        AppMethodBeat.i(50978);
        ab.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        e(i, str, str2, i2);
        if (i == -50002) {
            dhd();
            a(this.talker, str, str2, intent, i2, 141);
            AppMethodBeat.o(50978);
        } else if (i == -50008) {
            dhf();
            a(this.talker, str, str2, intent, i2, 140);
            AppMethodBeat.o(50978);
        } else if (i == -50006) {
            if (u.t(str, this.talker, str2) < 0) {
                a(this.talker, str, str2, intent, i2, (int) ErrorCode.NEEDDOWNLOAD_3);
                ab.e("MicroMsg.ImportMultiVideo", "prepare");
                AppMethodBeat.o(50978);
                return;
            }
            if (uPu == null) {
                uPu = new az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            b bVar = new b();
            synchronized (uPt) {
                try {
                    uPs.put(str, bVar);
                } finally {
                    while (true) {
                    }
                    int i3 = bVar;
                    AppMethodBeat.o(50978);
                }
            }
            bVar.fileName = str;
            bVar.fUG = str2;
            o.all();
            bVar.hzq = t.uh(str);
            bVar.vbg = this.vbg;
            bVar.toUser = this.talker;
            bVar.fWR = videoTransPara;
            bVar.ozx = com.tencent.mm.bj.e.uD(str2);
            bVar.vbj = new g();
            uPu.e(bVar);
        } else if (i < 0) {
            dhe();
            a(this.talker, str, str2, intent, i2, (int) ErrorCode.NEEDDOWNLOAD_3);
            AppMethodBeat.o(50978);
        } else {
            u.c(str, i2, this.talker, str2);
            u.uo(str);
            int i4 = this.vbg == 1 ? 8 : 1;
            o.all();
            n.alj().a(str2, t.uh(str), this.talker, "", "", i4, 2);
            AppMethodBeat.o(50978);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(String str, String str2, String str3, Intent intent, int i, int i2) {
        AppMethodBeat.i(50979);
        bi biVar = new bi();
        biVar.setStatus(5);
        biVar.ju(str);
        biVar.eJ(bf.oC(str));
        biVar.hO(1);
        biVar.jv(str2);
        biVar.setType(43);
        long Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
        ab.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_talker, Integer.valueOf(biVar.getType()), Integer.valueOf(biVar.field_isSend), biVar.field_imgPath, Integer.valueOf(biVar.field_status), Long.valueOf(biVar.field_createTime));
        if (-1 == Z) {
            ab.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", str);
            AppMethodBeat.o(50979);
            return;
        }
        if (u.ut(str2) == null) {
            o.all();
            String ui = t.ui(str2);
            try {
                com.tencent.mm.compatible.j.a.a j = com.tencent.mm.compatible.j.a.j(this.context, intent);
                int uj;
                int uj2;
                s sVar;
                if (j == null || j.bitmap == null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ui, true);
                    uj = t.uj(ui);
                    o.all();
                    uj2 = t.uj(t.uh(str2));
                    sVar = new s();
                    sVar.fileName = str2;
                    if (uj2 <= 0) {
                        uj2 = 0;
                    }
                    sVar.frO = uj2;
                    sVar.fXa = uj;
                    sVar.fXd = i;
                    sVar.cIS = str;
                    sVar.fWW = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
                    sVar.createTime = bo.anT();
                    sVar.fXb = bo.anT();
                    sVar.fXj = null;
                    sVar.fUG = str3;
                    if (!bo.isNullOrNil(str3)) {
                        sVar.fXh = 1;
                    }
                    sVar.fXk = -1;
                    sVar.status = i2;
                    sVar.fXe = (int) Z;
                    if (!o.all().b(sVar)) {
                        ab.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(Z));
                    }
                } else {
                    i = bo.mA((long) j.duration);
                    com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, ui, true);
                    uj = t.uj(ui);
                    o.all();
                    uj2 = t.uj(t.uh(str2));
                    sVar = new s();
                    sVar.fileName = str2;
                    if (uj2 <= 0) {
                    }
                    sVar.frO = uj2;
                    sVar.fXa = uj;
                    sVar.fXd = i;
                    sVar.cIS = str;
                    sVar.fWW = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, (Object) "");
                    sVar.createTime = bo.anT();
                    sVar.fXb = bo.anT();
                    sVar.fXj = null;
                    sVar.fUG = str3;
                    if (bo.isNullOrNil(str3)) {
                    }
                    sVar.fXk = -1;
                    sVar.status = i2;
                    sVar.fXe = (int) Z;
                    if (o.all().b(sVar)) {
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(50979);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(String str, int[] iArr) {
        Throwable th;
        AppMethodBeat.i(50980);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
                        AppMethodBeat.o(50980);
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
                    AppMethodBeat.o(50980);
                    return;
                }
                AppMethodBeat.o(50980);
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                }
                if (iArr[0] % 2 != 0) {
                }
                if (iArr[1] % 2 != 0) {
                }
                AppMethodBeat.o(50980);
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
            AppMethodBeat.o(50980);
            throw th;
        }
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        AppMethodBeat.i(50981);
        this.uPj.add(Integer.valueOf(i));
        this.uPk.add(str);
        this.uPl.add(str2);
        this.uPm.add(Integer.valueOf(i2));
        AppMethodBeat.o(50981);
    }

    public static void dhc() {
        int size;
        AppMethodBeat.i(50982);
        synchronized (uPt) {
            try {
                size = uPs.size();
                uPs.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(50982);
            }
        }
        if (uPu == null) {
            ab.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            return;
        }
        ab.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(uPu.xAV.size()));
        uPu.xAV.clear();
        uPu = null;
        AppMethodBeat.o(50982);
    }

    public static boolean aiB(String str) {
        boolean containsKey;
        AppMethodBeat.i(50983);
        synchronized (uPt) {
            try {
                containsKey = uPs.containsKey(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(50983);
            }
        }
        ab.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        return containsKey;
    }

    public static void aiC(String str) {
        boolean z = true;
        AppMethodBeat.i(50984);
        synchronized (uPt) {
            try {
                if (uPs.remove(str) == null) {
                    z = false;
                }
                ab.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(50984);
            }
        }
    }

    private static VideoTransPara a(String str, PInt pInt) {
        AppMethodBeat.i(50985);
        if (com.tencent.mm.modelcontrol.d.afF().rT(str)) {
            ab.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", str);
            pInt.value = 1;
            dhg();
            AppMethodBeat.o(50985);
            return null;
        }
        VideoTransPara uE = com.tencent.mm.bj.e.uE(str);
        Boolean valueOf = Boolean.valueOf(com.tencent.mm.bj.e.uD(str));
        ab.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", uE);
        VideoTransPara b = com.tencent.mm.modelcontrol.d.afF().b(uE);
        if (b == null) {
            ab.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", uE);
            pInt.value = -5;
            AppMethodBeat.o(50985);
            return null;
        }
        ab.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", b);
        if (uE.videoBitrate <= 640000 || b.videoBitrate > uE.videoBitrate) {
            ab.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", b, uE);
            if (valueOf.booleanValue()) {
                pInt.value = 0;
                AppMethodBeat.o(50985);
                return uE;
            }
            pInt.value = 1;
            AppMethodBeat.o(50985);
            return null;
        } else if (uE.fps < 45 || uE.duration * 1000 < 180000) {
            if (valueOf.booleanValue()) {
                pInt.value = 0;
            } else {
                boolean is2G = at.is2G(ah.getContext());
                pInt.value = SightVideoJNI.shouldRemuxing(str, b.width, b.height, is2G ? 10485760 : 26214400, is2G ? 60000.0d : 300000.0d, 1000000);
            }
            AppMethodBeat.o(50985);
            return b;
        } else {
            pInt.value = -6;
            AppMethodBeat.o(50985);
            return null;
        }
    }

    private void ou(boolean z) {
        int i;
        AppMethodBeat.i(50986);
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
        ab.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.vbg);
        h.pYm.a(106, (long) i, 1, false);
        AppMethodBeat.o(50986);
    }

    private void dhd() {
        int i;
        AppMethodBeat.i(50987);
        if (this.vbg == 1) {
            i = 230;
        } else {
            i = com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE;
        }
        ab.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i + " importType : " + this.vbg);
        h.pYm.a(106, (long) i, 1, false);
        AppMethodBeat.o(50987);
    }

    private void dhe() {
        int i;
        AppMethodBeat.i(50988);
        if (this.vbg == 1) {
            i = 229;
        } else {
            i = 244;
        }
        ab.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i + " importType : " + this.vbg);
        h.pYm.a(106, (long) i, 1, false);
        AppMethodBeat.o(50988);
    }

    private static void dT(String str, int i) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(50989);
        if (i == 1) {
            i2 = 220;
            i3 = 228;
            i4 = 219;
        } else {
            i2 = com.tencent.view.d.MIC_PTU_FENGJING;
            i3 = 242;
            i4 = com.tencent.view.d.MIC_PTU_MEISHI;
        }
        long asZ = e.asZ(str);
        int h = bo.h((Integer) h.a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, i2, i3));
        h.pYm.a(106, (long) h, 1, false);
        h.pYm.a(106, (long) i4, 1, false);
        ab.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + h + " file len : " + (asZ / 1024) + "K");
        AppMethodBeat.o(50989);
    }

    private static void dhf() {
        AppMethodBeat.i(50990);
        h.pYm.a(106, 210, 1, false);
        AppMethodBeat.o(50990);
    }

    private static void dhg() {
        AppMethodBeat.i(50991);
        h.pYm.a(422, 51, 1, false);
        AppMethodBeat.o(50991);
    }

    private static void e(boolean z, String str, String str2) {
        AppMethodBeat.i(50992);
        com.tencent.mm.modelvideo.a.j(z ? 1 : 0, str, str2);
        AppMethodBeat.o(50992);
    }

    static /* synthetic */ void dU(String str, int i) {
        AppMethodBeat.i(50993);
        if (i == 2) {
            long asZ = e.asZ(str);
            int h = bo.h((Integer) h.a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, 247, 255));
            h.pYm.a(106, (long) h, 1, false);
            h.pYm.a(106, 246, 1, false);
            ab.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + h + " file len : " + (asZ / 1024) + "K");
        }
        AppMethodBeat.o(50993);
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        AppMethodBeat.i(50996);
        long asZ = e.asZ(str);
        if (asZ > 0) {
            int asZ2 = (int) ((100 * e.asZ(str2)) / asZ);
            ab.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", Integer.valueOf(i), Long.valueOf(asZ), Long.valueOf(e.asZ(str2)), Integer.valueOf(asZ2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            h.pYm.e(13432, Integer.valueOf(i), Long.valueOf(asZ), Long.valueOf(r2), Integer.valueOf(asZ2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            AppMethodBeat.o(50996);
            return;
        }
        ab.e("MicroMsg.ImportMultiVideo", "file canot be empty");
        AppMethodBeat.o(50996);
    }
}
