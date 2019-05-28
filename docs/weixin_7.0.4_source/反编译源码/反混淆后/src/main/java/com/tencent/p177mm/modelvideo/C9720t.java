package com.tencent.p177mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvideo.t */
public final class C9720t {
    private static long fXo = 0;
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    public C7480h fni;
    C4934l<C9721a, C9718a> fry = new C97241();

    /* renamed from: com.tencent.mm.modelvideo.t$a */
    public interface C9721a {

        /* renamed from: com.tencent.mm.modelvideo.t$a$a */
        public static final class C9718a {
            public final long fVs;
            public final int fXk;
            public final C9722b fXt;
            public final C9719c fXu;
            public final String fileName;

            public C9718a(String str, C9722b c9722b, C9719c c9719c, int i, long j) {
                this.fileName = str;
                this.fXt = c9722b;
                this.fXu = c9719c;
                this.fXk = i;
                this.fVs = j;
            }
        }

        /* renamed from: com.tencent.mm.modelvideo.t$a$c */
        public enum C9719c {
            NORMAL,
            UPLOAD,
            DOWNLOAD;

            static {
                AppMethodBeat.m2505o(50797);
            }
        }

        /* renamed from: com.tencent.mm.modelvideo.t$a$b */
        public enum C9722b {
            INSERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(50794);
            }
        }

        /* renamed from: a */
        void mo11381a(C9718a c9718a);
    }

    /* renamed from: com.tencent.mm.modelvideo.t$b */
    public static class C9723b {
        public byte[] buf = null;
        public int cqs = 0;
        public int fXD = 0;
        public int ret = 0;
    }

    /* renamed from: com.tencent.mm.modelvideo.t$1 */
    class C97241 extends C4934l<C9721a, C9718a> {
        C97241() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(50790);
            ((C9721a) obj).mo11381a((C9718a) obj2);
            AppMethodBeat.m2505o(50790);
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.t$2 */
    class C97252 implements Runnable {
        final /* synthetic */ String fXq;
        final /* synthetic */ String fXr;
        final /* synthetic */ String fXs;

        C97252(String str, String str2, String str3) {
            this.fXq = str;
            this.fXr = str2;
            this.fXs = str3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x0144  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0144  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            Object obj;
            AppMethodBeat.m2504i(50791);
            int asZ = (int) C5730e.asZ(this.fXq);
            int asZ2 = (int) C5730e.asZ(this.fXr);
            C4990ab.m7417i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", Long.valueOf(C5046bo.anU()), Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
            int i;
            if (asZ2 != asZ) {
                i = (asZ <= 0 ? 20 : 0) + ((asZ2 <= 0 ? 10 : 0) + 106);
                C7060h.pYm.mo8381e(12696, Integer.valueOf(i), this.fXs, "", "", Integer.valueOf(asZ2));
                C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
                AppMethodBeat.m2505o(50791);
                return;
            }
            int i2 = 0;
            Object obj2 = null;
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            try {
                inputStream = C5730e.openRead(this.fXq);
                inputStream2 = C5730e.openRead(this.fXr);
                byte[] bArr = new byte[4096];
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != inputStream2.read(bArr2)) {
                        obj2 = 1;
                    }
                    if (read == -1) {
                        break;
                    }
                    int i3 = 0;
                    i = i2;
                    while (i3 < read) {
                        try {
                            if (bArr[i3] != bArr2[i3]) {
                                i++;
                            }
                            i3++;
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i;
                            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", C5046bo.m7574l(e));
                            obj = 1;
                            inputStream2.close();
                            inputStream.close();
                            if (obj != null) {
                            }
                        }
                    }
                    i2 = i;
                }
                obj = obj2;
            } catch (Exception e3) {
                e = e3;
                C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", C5046bo.m7574l(e));
                obj = 1;
                inputStream2.close();
                inputStream.close();
                if (obj != null) {
                }
            }
            try {
                inputStream2.close();
            } catch (Exception e4) {
            }
            try {
                inputStream.close();
            } catch (Exception e5) {
            }
            if (obj != null) {
                C4990ab.m7413e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
                C7060h.pYm.mo8381e(12696, Integer.valueOf(107), this.fXs);
                AppMethodBeat.m2505o(50791);
                return;
            }
            long gb = C5046bo.m7566gb(r6);
            C7060h.pYm.mo8381e(12696, Integer.valueOf(400), this.fXs, String.valueOf(i2), Long.valueOf(gb));
            C4990ab.m7417i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(gb), Integer.valueOf(i2), this.fXq, this.fXr);
            AppMethodBeat.m2505o(50791);
        }
    }

    /* renamed from: a */
    public final void mo21053a(C9721a c9721a, Looper looper) {
        AppMethodBeat.m2504i(50798);
        this.fry.mo10125a(c9721a, looper);
        AppMethodBeat.m2505o(50798);
    }

    /* renamed from: a */
    public final void mo21052a(C9721a c9721a) {
        AppMethodBeat.m2504i(50799);
        this.fry.remove(c9721a);
        AppMethodBeat.m2505o(50799);
    }

    public C9720t(C7480h c7480h) {
        AppMethodBeat.m2504i(50800);
        this.fni = c7480h;
        AppMethodBeat.m2505o(50800);
    }

    /* renamed from: b */
    public final boolean mo21059b(C26493s c26493s) {
        AppMethodBeat.m2504i(50801);
        if (c26493s == null) {
            AppMethodBeat.m2505o(50801);
            return false;
        }
        c26493s.bJt = -1;
        if (((int) this.fni.insert("videoinfo2", "filename", c26493s.mo44267Hl())) != -1) {
            this.fry.mo10126cF(new C9718a(c26493s.getFileName(), C9722b.INSERT, C9719c.NORMAL, c26493s.fXk, c26493s.fVs));
            this.fry.doNotify();
            AppMethodBeat.m2505o(50801);
            return true;
        }
        AppMethodBeat.m2505o(50801);
        return false;
    }

    /* renamed from: uf */
    public final C26493s mo21063uf(String str) {
        C26493s c26493s = null;
        AppMethodBeat.m2504i(50802);
        Cursor a = this.fni.mo10104a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(50802);
        } else {
            if (a.moveToFirst()) {
                c26493s = new C26493s();
                c26493s.mo44274d(a);
            }
            a.close();
            AppMethodBeat.m2505o(50802);
        }
        return c26493s;
    }

    /* renamed from: fU */
    public final List<C26493s> mo21061fU(long j) {
        List<C26493s> list = null;
        AppMethodBeat.m2504i(50803);
        Cursor a = this.fni.mo10104a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = ".concat(String.valueOf(j)), null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(50803);
        } else {
            list = new ArrayList();
            while (a.moveToNext()) {
                C26493s c26493s = new C26493s();
                c26493s.mo44274d(a);
                list.add(c26493s);
            }
            a.close();
            AppMethodBeat.m2505o(50803);
        }
        return list;
    }

    public final List<C26493s> alB() {
        AppMethodBeat.m2504i(50804);
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.mo10104a(str, null, 2);
        int i = 0;
        while (a.moveToNext()) {
            C26493s c26493s = new C26493s();
            c26493s.mo44274d(a);
            arrayList.add(c26493s);
            i++;
        }
        a.close();
        C4990ab.m7410d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(50804);
        return arrayList;
    }

    public final List<C26493s> alC() {
        AppMethodBeat.m2504i(50805);
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.mo10104a(str, null, 2);
        while (a.moveToNext()) {
            C26493s c26493s = new C26493s();
            c26493s.mo44274d(a);
            arrayList.add(c26493s);
        }
        a.close();
        AppMethodBeat.m2505o(50805);
        return arrayList;
    }

    /* renamed from: c */
    public final boolean mo21060c(C26493s c26493s) {
        boolean z;
        AppMethodBeat.m2504i(50806);
        Assert.assertTrue(c26493s != null);
        if (c26493s.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = c26493s.mo44267Hl();
        if (Hl.size() <= 0) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.fni.update("videoinfo2", Hl, "filename= ?", new String[]{c26493s.getFileName()}) > 0) {
                C9719c c9719c = C9719c.NORMAL;
                if (c26493s.status == 112) {
                    c9719c = C9719c.DOWNLOAD;
                } else if (c26493s.status == 103 || c26493s.status == 104) {
                    c9719c = C9719c.UPLOAD;
                }
                this.fry.mo10126cF(new C9718a(c26493s.getFileName(), C9722b.UPDATE, c9719c, c26493s.fXk, c26493s.fVs));
                this.fry.doNotify();
                AppMethodBeat.m2505o(50806);
                return true;
            }
        }
        AppMethodBeat.m2505o(50806);
        return false;
    }

    public final List<String> alD() {
        Throwable th;
        List<String> list = null;
        AppMethodBeat.m2504i(50807);
        Cursor a;
        try {
            a = this.fni.mo10104a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50807);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50807);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    public final List<String> alE() {
        Throwable th;
        List<String> list = null;
        AppMethodBeat.m2504i(50808);
        String str = " LIMIT 10 )";
        Cursor a;
        try {
            a = this.fni.mo10104a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50808);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50808);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    /* renamed from: v */
    public final List<C26493s> mo21064v(int i, long j) {
        Throwable th;
        List<C26493s> list = null;
        AppMethodBeat.m2504i(50809);
        Cursor a;
        try {
            a = this.fni.mo10104a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + i + " AND preloadsize > 0 AND lastmodifytime <= " + j + " ORDER BY createtime LIMIT 1", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        C26493s c26493s = new C26493s();
                        c26493s.mo44274d(a);
                        list.add(c26493s);
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50809);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50809);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    public final List<String> alF() {
        Throwable th;
        List<String> list = null;
        AppMethodBeat.m2504i(50810);
        String str = " LIMIT 10 )";
        Cursor a;
        try {
            a = this.fni.mo10104a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50810);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(50810);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    /* renamed from: ug */
    public static String m17302ug(String str) {
        AppMethodBeat.m2504i(50811);
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + C1178g.m2591x(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = fXo;
        fXo = 1 + currentTimeMillis;
        format = append.append(currentTimeMillis).toString();
        AppMethodBeat.m2505o(50811);
        return format;
    }

    private static String getVideoPath() {
        AppMethodBeat.m2504i(50812);
        String str = C1720g.m3536RP().eJM + "video/";
        AppMethodBeat.m2505o(50812);
        return str;
    }

    /* renamed from: uh */
    public static String m17303uh(String str) {
        AppMethodBeat.m2504i(50813);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50813);
            return null;
        }
        String str2 = C9720t.getVideoPath() + str;
        if (C5730e.m8628ct(str2)) {
            AppMethodBeat.m2505o(50813);
            return str2;
        }
        str2 = str2 + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.m2505o(50813);
        return str2;
    }

    /* renamed from: ui */
    public static String m17304ui(String str) {
        AppMethodBeat.m2504i(50814);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50814);
            return null;
        }
        String str2 = C9720t.getVideoPath() + str + FileUtils.PIC_POSTFIX_JPEG;
        AppMethodBeat.m2505o(50814);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x01cc A:{SYNTHETIC, Splitter:B:28:0x01cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m17299a(String str, int i, byte[] bArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(50815);
        int line;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + " invalid fileName");
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50815);
            return line;
        } else if (i < 0) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "]  invalid startOffset:" + i);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50815);
            return line;
        } else if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "]  invalid writeBuf");
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50815);
            return line;
        } else {
            C1446a c1446a = new C1446a();
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long Mr = c1446a.mo4908Mr();
                    randomAccessFile.seek((long) i);
                    long Mr2 = c1446a.mo4908Mr();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long Mr3 = c1446a.mo4908Mr();
                    line = (int) randomAccessFile.getFilePointer();
                    long Mr4 = c1446a.mo4908Mr();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    C4990ab.m7410d("MicroMsg.VideoInfoStorage", "FIN:" + C1447g.m3075Mq() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    C4990ab.m7410d("MicroMsg.VideoInfoStorage", "FIN:" + C1447g.m3075Mq() + "[" + str + "] open:" + Mr + " seek:" + Mr2 + " write:" + Mr3 + " close:" + Mr4);
                    AppMethodBeat.m2505o(50815);
                    return line;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                try {
                    C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                    line = 0 - C1447g.getLine();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.m2505o(50815);
                    return line;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(50815);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.m2505o(50815);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01d3 A:{SYNTHETIC, Splitter:B:23:0x01d3} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01df A:{SYNTHETIC, Splitter:B:29:0x01df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: m */
    public static C9723b m17301m(String str, int i, int i2) {
        Exception e;
        Throwable th;
        int i3 = 0;
        AppMethodBeat.m2504i(50816);
        C9723b c9723b = new C9723b();
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + " invalid fileName");
            c9723b.ret = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50816);
        } else if (i < 0) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "]  invalid readOffset:" + i);
            c9723b.ret = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50816);
        } else if (i2 <= 0) {
            C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "]  invalid readLen");
            c9723b.ret = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50816);
        } else {
            C1446a c1446a = new C1446a();
            c9723b.buf = new byte[i2];
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long Mr = c1446a.mo4908Mr();
                    randomAccessFile.seek((long) i);
                    long Mr2 = c1446a.mo4908Mr();
                    int read = randomAccessFile.read(c9723b.buf, 0, i2);
                    long Mr3 = c1446a.mo4908Mr();
                    long Mr4 = c1446a.mo4908Mr();
                    if (read >= 0) {
                        i3 = read;
                    }
                    c9723b.cqs = i3;
                    c9723b.fXD = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    C4990ab.m7410d("MicroMsg.VideoInfoStorage", "FIN:" + C1447g.m3075Mq() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    C4990ab.m7410d("MicroMsg.VideoInfoStorage", "FIN:" + C1447g.m3075Mq() + "[" + str + "] open:" + Mr + " seek:" + Mr2 + " write:" + Mr3 + " close:" + Mr4);
                    AppMethodBeat.m2505o(50816);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "] \t\tOffset:" + c9723b.fXD + " failed:[" + e.getMessage() + "]");
                        c9723b.ret = 0 - C1447g.getLine();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(50816);
                        return c9723b;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.m2505o(50816);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                C4990ab.m7412e("MicroMsg.VideoInfoStorage", "ERR:" + C1447g.m3075Mq() + "[" + str + "] \t\tOffset:" + c9723b.fXD + " failed:[" + e.getMessage() + "]");
                c9723b.ret = 0 - C1447g.getLine();
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(50816);
                return c9723b;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.m2505o(50816);
                throw th;
            }
        }
        return c9723b;
    }

    /* renamed from: uj */
    public static int m17305uj(String str) {
        AppMethodBeat.m2504i(50817);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50817);
            return -1;
        }
        C5728b c5728b = new C5728b(str);
        if (c5728b.exists()) {
            int length = (int) c5728b.length();
            if (length <= 0) {
                AppMethodBeat.m2505o(50817);
                return 0;
            }
            AppMethodBeat.m2505o(50817);
            return length;
        }
        AppMethodBeat.m2505o(50817);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo21062s(String str, String str2, String str3) {
        AppMethodBeat.m2504i(50818);
        boolean aW = m17300aW(str, str2 + "##" + str3);
        AppMethodBeat.m2505o(50818);
        return aW;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2 A:{SYNTHETIC, Splitter:B:26:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df A:{SYNTHETIC, Splitter:B:32:0x00df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: uk */
    static int[] m17306uk(String str) {
        Throwable e;
        int i = 0;
        AppMethodBeat.m2504i(50819);
        int[] iArr = new int[33];
        long anU = C5046bo.anU();
        int asZ = (int) C5730e.asZ(str);
        if (asZ < 102400 || asZ >= 104857600) {
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", Integer.valueOf(asZ), str);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf((asZ < 102400 ? 10 : 20) + 101);
            objArr[1] = Integer.valueOf(asZ);
            c7060h.mo8381e(12696, objArr);
            AppMethodBeat.m2505o(50819);
            return null;
        }
        iArr[32] = asZ;
        int i2 = (asZ - 20480) / 32;
        byte[] bArr = new byte[512];
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            while (i < 32) {
                try {
                    randomAccessFile.seek((long) ((i * i2) + 10240));
                    randomAccessFile.readFully(bArr);
                    iArr[i] = (C1179i.m2594s(bArr, 512) % C8415j.INVALID_ID) | C8415j.INVALID_ID;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, C5046bo.m7574l(e));
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e3) {
                            }
                        }
                        AppMethodBeat.m2505o(50819);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(50819);
                        throw e;
                    }
                }
            }
            randomAccessFile.close();
            C4990ab.m7417i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(asZ), str);
            try {
                randomAccessFile.close();
            } catch (Exception e5) {
            }
            AppMethodBeat.m2505o(50819);
            return iArr;
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, C5046bo.m7574l(e));
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(50819);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.m2505o(50819);
            throw e;
        }
    }

    /* renamed from: aW */
    private boolean m17300aW(String str, String str2) {
        AppMethodBeat.m2504i(50820);
        C4990ab.m7417i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", str, str2, C5046bo.dpG());
        long anU = C5046bo.anU();
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", str, str2);
            AppMethodBeat.m2505o(50820);
            return false;
        }
        int[] uk = C9720t.m17306uk(str);
        if (uk == null || uk.length < 33) {
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", str);
            AppMethodBeat.m2505o(50820);
            return false;
        }
        int i = uk[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(uk[i2]));
        }
        Cursor a = this.fni.mo10104a("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (a.moveToNext()) {
            vector.add(a.getString(0));
            C4990ab.m7419v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", Integer.valueOf(vector.size()), vector.get(vector.size() - 1));
        }
        a.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            C4990ab.m7421w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", Long.valueOf(C5046bo.m7566gb(anU)), str, str2);
            AppMethodBeat.m2505o(50820);
            return true;
        }
        if (vector.size() > 0) {
            C7060h.pYm.mo8381e(12696, Integer.valueOf(102), Integer.valueOf(i), "", "", Integer.valueOf(vector.size()));
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", Integer.valueOf(vector.size()), Integer.valueOf(i));
            this.fni.mo10108hY("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(C5046bo.anT()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        C4990ab.m7417i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", Long.valueOf(C5046bo.m7566gb(anU)), Long.valueOf(this.fni.insert("VideoHash", "", contentValues)), str, stringBuffer, str2);
        if (this.fni.insert("VideoHash", "", contentValues) < 0) {
            C7060h.pYm.mo8381e(12696, Integer.valueOf(103), Integer.valueOf(i));
            C4990ab.m7413e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", Long.valueOf(r0), str);
        }
        AppMethodBeat.m2505o(50820);
        return true;
    }
}
