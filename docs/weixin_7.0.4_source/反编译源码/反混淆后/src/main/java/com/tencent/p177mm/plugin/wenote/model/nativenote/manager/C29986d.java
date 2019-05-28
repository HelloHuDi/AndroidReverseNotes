package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1380j.C45291a;
import com.tencent.p177mm.compatible.p1380j.C45291a.C41941a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.plugin.p878a.C26531d;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
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
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.d */
public final class C29986d extends Thread {
    private static HashMap<String, C29988b> uPs = new HashMap();
    private static Object uPt = new byte[0];
    private static C23498az uPu;
    public boolean isStop;
    private List<String> uPi;
    private List<Integer> uPj;
    private List<String> uPk;
    private List<String> uPl;
    private List<Integer> uPm;
    private C29987a uPn;
    private C40366k uPo;
    private String uPp;
    private String uPq;
    private boolean uPr = false;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.d$a */
    public interface C29987a {
        /* renamed from: a */
        void mo27057a(String str, C40366k c40366k);

        /* renamed from: b */
        void mo27058b(String str, C40366k c40366k);
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.d$b */
    static final class C29988b implements C23499a {
        private int eYk;
        private int eYl;
        String fUG;
        VideoTransPara fWR;
        String fileName;
        String hzq;
        C29987a uPn;
        C40366k uPo;
        int uPx;
        private boolean uPy;
        private int uPz;

        private C29988b() {
            this.uPz = 0;
        }

        /* synthetic */ C29988b(byte b) {
            this();
        }

        public final boolean acf() {
            Object obj;
            AppMethodBeat.m2504i(26756);
            synchronized (C29986d.uPt) {
                try {
                    obj = !C29986d.uPs.containsKey(this.fileName) ? 1 : null;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(26756);
                }
            }
            if (obj == null) {
                obj = C26494u.m42268ut(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                C4990ab.m7421w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", this.fileName);
                return true;
            }
            if (this.fWR == null || this.fWR.isDefault) {
                int[] iArr = new int[2];
                C29986d.m47458c(this.fUG, iArr);
                this.eYk = iArr[0];
                this.eYl = iArr[1];
            } else {
                this.eYk = this.fWR.width;
                this.eYl = this.fWR.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            C9638aw.m17190ZK();
            if (!C18628c.m29085XT().mo16777a(this.fUG, pString, pInt) || C5730e.m8644y(pString.value, this.hzq) < 0) {
                long yz = C5046bo.m7588yz();
                if (this.fWR != null) {
                    C4990ab.m7417i("MicroMsg.NoteVideoCompress", "remuxing new para %s", this.fWR);
                    this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, false);
                } else {
                    C4990ab.m7421w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", this.fileName);
                    this.uPx = SightVideoJNI.remuxing(this.fUG, this.hzq, this.eYk, this.eYl, C29014b.qwZ, C29014b.qwY, 8, 2, 25.0f, C29014b.qxa, null, 0, false);
                }
                this.uPz = (int) C5046bo.m7525az(yz);
                C4990ab.m7417i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.fUG, this.hzq, Integer.valueOf(this.uPx), Integer.valueOf(this.eYk), Integer.valueOf(this.eYl));
                this.uPy = this.uPx >= 0;
                PInt pInt2 = new PInt();
                if (C26494u.m42241a(this.hzq, pInt2, new PInt())) {
                    this.uPx = pInt2.value;
                }
                if (this.uPy) {
                    C4990ab.m7416i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
                    try {
                        C5728b c5728b = new C5728b(this.hzq);
                        String name = c5728b.getName();
                        String str = this.hzq + ".tmp";
                        if (C26531d.m42370b(this.hzq, str, new PInt(0))) {
                            boolean delete = c5728b.delete();
                            C5728b c5728b2 = new C5728b(str);
                            boolean h = C5730e.m8633h(c5728b2.getParent() + "/", c5728b2.getName(), name);
                            C4990ab.m7417i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(delete), Boolean.valueOf(h), C5736j.m8649w(c5728b2.dMD()), this.hzq);
                        } else {
                            C4990ab.m7417i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(new PInt(0).value), this.fUG, this.hzq);
                        }
                        C9638aw.m17190ZK();
                        C18628c.m29085XT().mo16776P(this.fUG, this.hzq, this.uPx);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", e.toString());
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
                    C5730e.deleteFile(this.hzq);
                    C5730e.m8644y(this.fUG, this.hzq);
                }
                AppMethodBeat.m2505o(26756);
                return true;
            }
            C4990ab.m7416i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.uPx = pInt.value;
            this.uPy = true;
            AppMethodBeat.m2505o(26756);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(26757);
            synchronized (C29986d.uPt) {
                try {
                    C29986d.uPs.remove(this.fileName);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26757);
                    }
                }
            }
            if (this.uPn != null) {
                this.uPn.mo27058b(this.hzq, this.uPo);
            }
            AppMethodBeat.m2505o(26757);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(26765);
        AppMethodBeat.m2505o(26765);
    }

    public C29986d(List<String> list, String str, String str2, C40366k c40366k, C29987a c29987a) {
        AppMethodBeat.m2504i(26758);
        this.uPi = list;
        this.uPj = new ArrayList();
        this.uPk = new ArrayList();
        this.uPm = new ArrayList();
        this.uPl = new ArrayList();
        this.uPn = c29987a;
        this.uPo = c40366k;
        this.uPq = str2;
        this.uPp = str;
        AppMethodBeat.m2505o(26758);
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0329  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.m2504i(26759);
        if (this.uPi != null && this.uPi.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.uPi.size() && !this.isStop) {
                    String uh;
                    String str;
                    C4990ab.m7417i("MicroMsg.NoteVideoCompress", "start to import %s", this.uPi.toString());
                    Intent intent = new Intent();
                    intent.setData(Uri.parse("file://" + ((String) this.uPi.get(i2))));
                    Context context = C4996ah.getContext();
                    StringBuilder stringBuilder = new StringBuilder("note_");
                    C9638aw.m17190ZK();
                    String stringBuilder2 = stringBuilder.append(C9720t.m17302ug((String) C18628c.m29072Ry().get(2, (Object) ""))).toString();
                    String ui;
                    if (C5046bo.isNullOrNil(this.uPp) || C5046bo.isNullOrNil(this.uPq)) {
                        C37961o.all();
                        ui = C9720t.m17304ui(stringBuilder2);
                        C37961o.all();
                        uh = C9720t.m17303uh(stringBuilder2);
                        str = ui;
                    } else {
                        ui = this.uPp;
                        stringBuilder2 = this.uPq.substring(this.uPq.lastIndexOf("/") + 1, this.uPq.length());
                        uh = this.uPq;
                        str = ui;
                    }
                    boolean is2G = C5023at.is2G(C4996ah.getContext());
                    String i3 = C45291a.m83514i(context, intent);
                    if (C5046bo.isNullOrNil(i3)) {
                        C4990ab.m7412e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                        m47455a(-50005, stringBuilder2, i3, 0, null, context, null);
                    } else {
                        int i4;
                        VideoTransPara videoTransPara;
                        Object obj;
                        C41941a j;
                        boolean vC = C42258c.m74643vC(i3);
                        long asZ = C5730e.asZ(i3);
                        if (vC) {
                            VideoTransPara videoTransPara2;
                            PInt pInt = new PInt();
                            if (C42204d.afF().mo67743rT(i3)) {
                                C4990ab.m7417i("MicroMsg.NoteVideoCompress", "check remuxing, this video had wx meta do not remuxing. %s ", i3);
                                pInt.value = 1;
                                videoTransPara2 = null;
                            } else {
                                VideoTransPara videoTransPara3 = new VideoTransPara();
                                PInt pInt2 = new PInt();
                                PInt pInt3 = new PInt();
                                PInt pInt4 = new PInt();
                                PInt pInt5 = new PInt();
                                PInt pInt6 = new PInt();
                                C21846d.m33389a(i3, pInt2, pInt3, pInt4, pInt5, pInt6);
                                videoTransPara3.duration = pInt2.value / 1000;
                                videoTransPara3.width = pInt3.value;
                                videoTransPara3.height = pInt4.value;
                                videoTransPara3.fps = pInt5.value;
                                videoTransPara3.videoBitrate = pInt6.value;
                                C4990ab.m7411d("MicroMsg.NoteVideoCompress", "check remuxing old para %s", videoTransPara3);
                                videoTransPara2 = C42204d.afF().mo67741b(videoTransPara3);
                                if (videoTransPara2 == null) {
                                    C4990ab.m7417i("MicroMsg.NoteVideoCompress", "get C2C album video para is null. old para %s", videoTransPara3);
                                    pInt.value = -5;
                                    videoTransPara2 = null;
                                } else {
                                    C4990ab.m7411d("MicroMsg.NoteVideoCompress", "check remuxing new para %s", videoTransPara2);
                                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                                        C4990ab.m7417i("MicroMsg.NoteVideoCompress", "new bitrate is bigger than old bitrate %s %s", videoTransPara2, videoTransPara3);
                                        pInt.value = 1;
                                        videoTransPara2 = null;
                                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                                        boolean is2G2 = C5023at.is2G(C4996ah.getContext());
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
                        C4990ab.m7417i("MicroMsg.NoteVideoCompress", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i4), Boolean.valueOf(vC), Long.valueOf(asZ));
                        switch (i4) {
                            case -6:
                            case -4:
                            case -3:
                            case -2:
                                m47455a(-50002, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case -5:
                                m47455a(-50008, stringBuilder2, i3, 0, null, context, null);
                                continue;
                            case -1:
                                m47455a(-50007, stringBuilder2, i3, 0, null, context, null);
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
                                m47455a(-50002, stringBuilder2, i3, 0, null, context, null);
                                obj = null;
                                i4 = -50002;
                                break;
                            default:
                                C4990ab.m7412e("MicroMsg.NoteVideoCompress", "unknown check type");
                                m47455a(-50001, stringBuilder2, i3, 0, null, context, null);
                                continue;
                        }
                        C41941a c41941a = null;
                        try {
                            j = C45291a.m83515j(context, intent);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "", new Object[0]);
                            j = c41941a;
                        }
                        if (j == null) {
                            C4990ab.m7412e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                            m47455a(-50005, stringBuilder2, i3, 0, null, context, null);
                        } else {
                            Object obj2;
                            if (obj == null) {
                                C5730e.m8644y(i3, uh);
                            } else {
                                i4 = -50006;
                            }
                            int mA = C5046bo.m7576mA((long) j.duration);
                            if (j.bitmap != null) {
                                try {
                                    C5056d.m7625a(j.bitmap, 60, CompressFormat.JPEG, str, true);
                                    obj2 = null;
                                } catch (Exception e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e2, "", new Object[0]);
                                }
                                if (obj2 != null) {
                                    try {
                                        C5056d.m7625a(C5056d.m7644au(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                    } catch (Exception e22) {
                                        C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e22, "", new Object[0]);
                                    }
                                }
                                if (obj == null && !C5730e.m8628ct(uh)) {
                                    i4 = -50003;
                                }
                                if (!C5730e.m8628ct(str)) {
                                    i4 = -50004;
                                }
                                m47455a(i4, stringBuilder2, i3, mA, videoTransPara, context, str);
                            }
                            int obj22 = 1;
                            if (obj22 != null) {
                            }
                            i4 = -50003;
                            if (C5730e.m8628ct(str)) {
                            }
                            m47455a(i4, stringBuilder2, i3, mA, videoTransPara, context, str);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        AppMethodBeat.m2505o(26759);
    }

    /* renamed from: a */
    private void m47455a(final int i, String str, String str2, int i2, VideoTransPara videoTransPara, Context context, final String str3) {
        AppMethodBeat.m2504i(26760);
        C4990ab.m7417i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        m47461e(i, str, str2, i2);
        if (i == -50002) {
            m47457bs(context, context.getString(C25738R.string.f16));
        } else if (i == -50008) {
            m47457bs(context, context.getString(C25738R.string.f14));
        } else if (i == -50006) {
            C29986d.m47462hr(str, str2);
            if (uPu == null) {
                uPu = new C23498az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            C29988b c29988b = new C29988b();
            synchronized (uPt) {
                try {
                    uPs.put(str, c29988b);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26760);
                    }
                }
            }
            c29988b.fileName = str;
            c29988b.fUG = str2;
            c29988b.hzq = this.uPq;
            c29988b.fWR = videoTransPara;
            c29988b.uPn = this.uPn;
            c29988b.uPo = this.uPo;
            uPu.mo39163e(c29988b);
        } else if (i < 0) {
            m47457bs(context, context.getString(C25738R.string.f15));
        } else {
            this.uPr = true;
        }
        if (!(this.uPn == null || this.isStop)) {
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.d$1$1 */
                class C147301 implements Runnable {
                    C147301() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(26753);
                        C29986d.this.uPn.mo27058b(C29986d.this.uPq, C29986d.this.uPo);
                        AppMethodBeat.m2505o(26753);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(26754);
                    C29986d.this.uPn.mo27057a(str3, C29986d.this.uPo);
                    if (C29986d.this.uPr || i != -50006) {
                        C9638aw.m17180RS().mo10310m(new C147301(), 80);
                    }
                    AppMethodBeat.m2505o(26754);
                }
            });
        }
        AppMethodBeat.m2505o(26760);
    }

    /* renamed from: bs */
    private void m47457bs(final Context context, final String str) {
        AppMethodBeat.m2504i(26761);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26755);
                Toast.makeText(context, str, 0).show();
                AppMethodBeat.m2505o(26755);
            }
        });
        AppMethodBeat.m2505o(26761);
    }

    /* renamed from: hr */
    private static void m47462hr(String str, String str2) {
        AppMethodBeat.m2504i(26762);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            AppMethodBeat.m2505o(26762);
            return;
        }
        C26493s c26493s = new C26493s();
        c26493s.fileName = str;
        c26493s.fXd = 1;
        c26493s.cIS = null;
        C9638aw.m17190ZK();
        c26493s.fWW = (String) C18628c.m29072Ry().get(2, (Object) "");
        c26493s.createTime = C5046bo.anT();
        c26493s.fXb = C5046bo.anT();
        c26493s.fXj = null;
        c26493s.fUG = str2;
        if (!C5046bo.isNullOrNil(str2)) {
            c26493s.fXh = 1;
        }
        c26493s.frO = 0;
        C37961o.all().mo21059b(c26493s);
        AppMethodBeat.m2505o(26762);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public static void m47458c(String str, int[] iArr) {
        int i;
        Throwable e;
        int i2;
        int i3;
        AppMethodBeat.m2504i(26763);
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            } catch (Exception e2) {
                e = e2;
                i = 0;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
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
                    AppMethodBeat.m2505o(26763);
                } catch (Throwable th) {
                    e = th;
                    if (mediaMetadataRetriever != null) {
                    }
                    AppMethodBeat.m2505o(26763);
                    throw e;
                }
            }
            try {
                i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e = e3;
                C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
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
                AppMethodBeat.m2505o(26763);
            }
        } catch (Exception e4) {
            e = e4;
            i = 0;
            mediaMetadataRetriever = null;
            C4990ab.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "getImportProperRemuxingResolution error", new Object[0]);
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
            AppMethodBeat.m2505o(26763);
        } catch (Throwable th2) {
            e = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            AppMethodBeat.m2505o(26763);
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
                AppMethodBeat.m2505o(26763);
                return;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        AppMethodBeat.m2505o(26763);
    }

    /* renamed from: e */
    private synchronized void m47461e(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(26764);
        this.uPj.add(Integer.valueOf(i));
        this.uPk.add(str);
        this.uPl.add(str2);
        this.uPm.add(Integer.valueOf(i2));
        AppMethodBeat.m2505o(26764);
    }
}
