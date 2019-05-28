package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d extends Thread {
    private static HashMap<String, b> uPs = new HashMap();
    private static Object uPt = new byte[0];
    private static az uPu;
    public boolean isStop;
    private List<String> uPi;
    private List<Integer> uPj;
    private List<String> uPk;
    private List<String> uPl;
    private List<Integer> uPm;
    private a uPn;
    private k uPo;
    private String uPp;
    private String uPq;
    private boolean uPr = false;

    public interface a {
        void a(String str, k kVar);

        void b(String str, k kVar);
    }

    static final class b implements com.tencent.mm.sdk.platformtools.az.a {
        private int eYk;
        private int eYl;
        String fUG;
        VideoTransPara fWR;
        String fileName;
        String hzq;
        a uPn;
        k uPo;
        int uPx;
        private boolean uPy;
        private int uPz;

        private b() {
            this.uPz = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final boolean acf() {
            Object obj;
            AppMethodBeat.i(26756);
            synchronized (d.uPt) {
                try {
                    obj = !d.uPs.containsKey(this.fileName) ? 1 : null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(26756);
                }
            }
            if (obj == null) {
                obj = u.ut(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                ab.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", this.fileName);
                return true;
            }
            if (this.fWR == null || this.fWR.isDefault) {
                int[] iArr = new int[2];
                d.c(this.fUG, iArr);
                this.eYk = iArr[0];
                this.eYl = iArr[1];
            } else {
                this.eYk = this.fWR.width;
                this.eYl = this.fWR.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            aw.ZK();
            if (!c.XT().a(this.fUG, pString, pInt) || e.y(pString.value, this.hzq) < 0) {
                long yz = bo.yz();
                if (this.fWR != null) {
                    ab.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", this.fWR);
                    this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, false);
                } else {
                    ab.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", this.fileName);
                    this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, com.tencent.mm.plugin.sight.base.b.qwZ, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qxa, null, 0, false);
                }
                this.uPz = (int) bo.az(yz);
                ab.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.fUG, this.hzq, Integer.valueOf(this.uPx), Integer.valueOf(this.eYk), Integer.valueOf(this.eYl));
                this.uPy = this.uPx >= 0;
                PInt pInt2 = new PInt();
                if (u.a(this.hzq, pInt2, new PInt())) {
                    this.uPx = pInt2.value;
                }
                if (this.uPy) {
                    ab.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
                    try {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.hzq);
                        String name = bVar.getName();
                        String str = this.hzq + ".tmp";
                        if (com.tencent.mm.plugin.a.d.b(this.hzq, str, new PInt(0))) {
                            boolean delete = bVar.delete();
                            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str);
                            boolean h = e.h(bVar2.getParent() + "/", bVar2.getName(), name);
                            ab.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(delete), Boolean.valueOf(h), j.w(bVar2.dMD()), this.hzq);
                        } else {
                            ab.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(new PInt(0).value), this.fUG, this.hzq);
                        }
                        aw.ZK();
                        c.XT().P(this.fUG, this.hzq, this.uPx);
                    } catch (Exception e) {
                        ab.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", e.toString());
                    }
                } else {
                    ab.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
                    e.deleteFile(this.hzq);
                    e.y(this.fUG, this.hzq);
                }
                AppMethodBeat.o(26756);
                return true;
            }
            ab.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.uPx = pInt.value;
            this.uPy = true;
            AppMethodBeat.o(26756);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(26757);
            synchronized (d.uPt) {
                try {
                    d.uPs.remove(this.fileName);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26757);
                    }
                }
            }
            if (this.uPn != null) {
                this.uPn.b(this.hzq, this.uPo);
            }
            AppMethodBeat.o(26757);
            return false;
        }
    }

    static {
        AppMethodBeat.i(26765);
        AppMethodBeat.o(26765);
    }

    public d(List<String> list, String str, String str2, k kVar, a aVar) {
        AppMethodBeat.i(26758);
        this.uPi = list;
        this.uPj = new ArrayList();
        this.uPk = new ArrayList();
        this.uPm = new ArrayList();
        this.uPl = new ArrayList();
        this.uPn = aVar;
        this.uPo = kVar;
        this.uPq = str2;
        this.uPp = str;
        AppMethodBeat.o(26758);
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0329  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.i(26759);
        if (this.uPi != null && this.uPi.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.uPi.size() && !this.isStop) {
                    String uh;
                    String str;
                    ab.i("MicroMsg.NoteVideoCompress", "start to import %s", this.uPi.toString());
                    Intent intent = new Intent();
                    intent.setData(Uri.parse("file://" + ((String) this.uPi.get(i2))));
                    Context context = ah.getContext();
                    StringBuilder stringBuilder = new StringBuilder("note_");
                    aw.ZK();
                    String stringBuilder2 = stringBuilder.append(t.ug((String) c.Ry().get(2, (Object) ""))).toString();
                    String ui;
                    if (bo.isNullOrNil(this.uPp) || bo.isNullOrNil(this.uPq)) {
                        o.all();
                        ui = t.ui(stringBuilder2);
                        o.all();
                        uh = t.uh(stringBuilder2);
                        str = ui;
                    } else {
                        ui = this.uPp;
                        stringBuilder2 = this.uPq.substring(this.uPq.lastIndexOf("/") + 1, this.uPq.length());
                        uh = this.uPq;
                        str = ui;
                    }
                    boolean is2G = at.is2G(ah.getContext());
                    String i3 = com.tencent.mm.compatible.j.a.i(context, intent);
                    if (bo.isNullOrNil(i3)) {
                        ab.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                        a(-50005, stringBuilder2, i3, 0, null, context, null);
                    } else {
                        int i4;
                        VideoTransPara videoTransPara;
                        Object obj;
                        com.tencent.mm.compatible.j.a.a j;
                        boolean vC = com.tencent.mm.plugin.a.c.vC(i3);
                        long asZ = e.asZ(i3);
                        if (vC) {
                            VideoTransPara videoTransPara2;
                            PInt pInt = new PInt();
                            if (com.tencent.mm.modelcontrol.d.afF().rT(i3)) {
                                ab.i("MicroMsg.NoteVideoCompress", "check remuxing, this video had wx meta do not remuxing. %s ", i3);
                                pInt.value = 1;
                                videoTransPara2 = null;
                            } else {
                                VideoTransPara videoTransPara3 = new VideoTransPara();
                                PInt pInt2 = new PInt();
                                PInt pInt3 = new PInt();
                                PInt pInt4 = new PInt();
                                PInt pInt5 = new PInt();
                                PInt pInt6 = new PInt();
                                com.tencent.mm.plugin.sight.base.d.a(i3, pInt2, pInt3, pInt4, pInt5, pInt6);
                                videoTransPara3.duration = pInt2.value / 1000;
                                videoTransPara3.width = pInt3.value;
                                videoTransPara3.height = pInt4.value;
                                videoTransPara3.fps = pInt5.value;
                                videoTransPara3.videoBitrate = pInt6.value;
                                ab.d("MicroMsg.NoteVideoCompress", "check remuxing old para %s", videoTransPara3);
                                videoTransPara2 = com.tencent.mm.modelcontrol.d.afF().b(videoTransPara3);
                                if (videoTransPara2 == null) {
                                    ab.i("MicroMsg.NoteVideoCompress", "get C2C album video para is null. old para %s", videoTransPara3);
                                    pInt.value = -5;
                                    videoTransPara2 = null;
                                } else {
                                    ab.d("MicroMsg.NoteVideoCompress", "check remuxing new para %s", videoTransPara2);
                                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                                        ab.i("MicroMsg.NoteVideoCompress", "new bitrate is bigger than old bitrate %s %s", videoTransPara2, videoTransPara3);
                                        pInt.value = 1;
                                        videoTransPara2 = null;
                                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                                        boolean is2G2 = at.is2G(ah.getContext());
                                        pInt.value = SightVideoJNI.shouldRemuxing(i3, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, 1000000);
                                    } else {
                                        pInt.value = -6;
                                        videoTransPara2 = null;
                                    }
                                }
                            }
                            i4 = pInt.value;
                            videoTransPara = videoTransPara2;
                        } else {
                            if (asZ > ((long) (is2G ? 10485760 : 26214400))) {
                                i4 = -5;
                                videoTransPara = null;
                            } else {
                                i4 = 1;
                                videoTransPara = null;
                            }
                        }
                        ab.i("MicroMsg.NoteVideoCompress", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i4), Boolean.valueOf(vC), Long.valueOf(asZ));
                        switch (i4) {
                            case -6:
                            case -4:
                            case -3:
                            case -2:
                                a(-50002, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case -5:
                                a(-50008, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case -1:
                                a(-50007, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case 0:
                                obj = 1;
                                i4 = 0;
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                if (asZ <= 26214400) {
                                    obj = null;
                                    i4 = 0;
                                    break;
                                }
                                a(-50002, stringBuilder2, i3, 0, null, context, null);
                                obj = null;
                                i4 = -50002;
                                break;
                            default:
                                ab.e("MicroMsg.NoteVideoCompress", "unknown check type");
                                a(-50001, stringBuilder2, i3, 0, null, context, null);
                                continue;
                        }
                        com.tencent.mm.compatible.j.a.a aVar = null;
                        try {
                            j = com.tencent.mm.compatible.j.a.j(context, intent);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "", new Object[0]);
                            j = aVar;
                        }
                        if (j == null) {
                            ab.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                            a(-50005, stringBuilder2, i3, 0, null, context, null);
                        } else {
                            Object obj2;
                            if (obj == null) {
                                e.y(i3, uh);
                            } else {
                                i4 = -50006;
                            }
                            int mA = bo.mA((long) j.duration);
                            if (j.bitmap != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, str, true);
                                    obj2 = null;
                                } catch (Exception e2) {
                                    ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e2, "", new Object[0]);
                                }
                                if (obj2 != null) {
                                    try {
                                        com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                    } catch (Exception e22) {
                                        ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e22, "", new Object[0]);
                                    }
                                }
                                if (obj == null && !e.ct(uh)) {
                                    i4 = -50003;
                                }
                                if (!e.ct(str)) {
                                    i4 = -50004;
                                }
                                a(i4, stringBuilder2, i3, mA, videoTransPara, context, str);
                            }
                            int obj22 = 1;
                            if (obj22 != null) {
                            }
                            i4 = -50003;
                            if (e.ct(str)) {
                            }
                            a(i4, stringBuilder2, i3, mA, videoTransPara, context, str);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        AppMethodBeat.o(26759);
    }

    private void a(final int i, String str, String str2, int i2, VideoTransPara videoTransPara, Context context, final String str3) {
        AppMethodBeat.i(26760);
        ab.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        e(i, str, str2, i2);
        if (i == -50002) {
            bs(context, context.getString(R.string.f16));
        } else if (i == -50008) {
            bs(context, context.getString(R.string.f14));
        } else if (i == -50006) {
            hr(str, str2);
            if (uPu == null) {
                uPu = new az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            b bVar = new b();
            synchronized (uPt) {
                try {
                    uPs.put(str, bVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26760);
                    }
                }
            }
            bVar.fileName = str;
            bVar.fUG = str2;
            bVar.hzq = this.uPq;
            bVar.fWR = videoTransPara;
            bVar.uPn = this.uPn;
            bVar.uPo = this.uPo;
            uPu.e(bVar);
        } else if (i < 0) {
            bs(context, context.getString(R.string.f15));
        } else {
            this.uPr = true;
        }
        if (!(this.uPn == null || this.isStop)) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26754);
                    d.this.uPn.a(str3, d.this.uPo);
                    if (d.this.uPr || i != -50006) {
                        aw.RS().m(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(26753);
                                d.this.uPn.b(d.this.uPq, d.this.uPo);
                                AppMethodBeat.o(26753);
                            }
                        }, 80);
                    }
                    AppMethodBeat.o(26754);
                }
            });
        }
        AppMethodBeat.o(26760);
    }

    private void bs(final Context context, final String str) {
        AppMethodBeat.i(26761);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26755);
                Toast.makeText(context, str, 0).show();
                AppMethodBeat.o(26755);
            }
        });
        AppMethodBeat.o(26761);
    }

    private static void hr(String str, String str2) {
        AppMethodBeat.i(26762);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            AppMethodBeat.o(26762);
            return;
        }
        s sVar = new s();
        sVar.fileName = str;
        sVar.fXd = 1;
        sVar.cIS = null;
        aw.ZK();
        sVar.fWW = (String) c.Ry().get(2, (Object) "");
        sVar.createTime = bo.anT();
        sVar.fXb = bo.anT();
        sVar.fXj = null;
        sVar.fUG = str2;
        if (!bo.isNullOrNil(str2)) {
            sVar.fXh = 1;
        }
        sVar.frO = 0;
        o.all().b(sVar);
        AppMethodBeat.o(26762);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(String str, int[] iArr) {
        int i;
        Throwable e;
        int i2;
        int i3;
        AppMethodBeat.i(26763);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            } catch (Exception e2) {
                e = e2;
                i = 0;
                try {
                    ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
                    if (mediaMetadataRetriever != null) {
                    }
                    i2 = 0;
                    iArr[0] = i;
                    iArr[1] = i2;
                    i3 = 0;
                    while (i3 < 3) {
                    }
                    iArr[0] = i;
                    iArr[1] = i2;
                    AppMethodBeat.o(26763);
                } catch (Throwable th) {
                    e = th;
                    if (mediaMetadataRetriever != null) {
                    }
                    AppMethodBeat.o(26763);
                    throw e;
                }
            }
            try {
                i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e = e3;
                ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                i2 = 0;
                iArr[0] = i;
                iArr[1] = i2;
                i3 = 0;
                while (i3 < 3) {
                }
                iArr[0] = i;
                iArr[1] = i2;
                AppMethodBeat.o(26763);
            }
        } catch (Exception e4) {
            e = e4;
            i = 0;
            mediaMetadataRetriever = null;
            ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
            if (mediaMetadataRetriever != null) {
            }
            i2 = 0;
            iArr[0] = i;
            iArr[1] = i2;
            i3 = 0;
            while (i3 < 3) {
            }
            iArr[0] = i;
            iArr[1] = i2;
            AppMethodBeat.o(26763);
        } catch (Throwable th2) {
            e = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            AppMethodBeat.o(26763);
            throw e;
        }
        iArr[0] = i;
        iArr[1] = i2;
        i3 = 0;
        while (i3 < 3) {
            if (i % 2 == 0 && i2 % 2 == 0) {
                if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                    break;
                }
                i /= 2;
                i2 /= 2;
                i3++;
            } else {
                AppMethodBeat.o(26763);
                return;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        AppMethodBeat.o(26763);
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        AppMethodBeat.i(26764);
        this.uPj.add(Integer.valueOf(i));
        this.uPk.add(str);
        this.uPl.add(str2);
        this.uPm.add(Integer.valueOf(i2));
        AppMethodBeat.o(26764);
    }
}
