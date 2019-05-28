package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.i;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
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

public final class t {
    private static long fXo = 0;
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    public h fni;
    l<a, a> fry = new l<a, a>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(50790);
            ((a) obj).a((a) obj2);
            AppMethodBeat.o(50790);
        }
    };

    public interface a {

        public static final class a {
            public final long fVs;
            public final int fXk;
            public final b fXt;
            public final c fXu;
            public final String fileName;

            public a(String str, b bVar, c cVar, int i, long j) {
                this.fileName = str;
                this.fXt = bVar;
                this.fXu = cVar;
                this.fXk = i;
                this.fVs = j;
            }
        }

        public enum c {
            NORMAL,
            UPLOAD,
            DOWNLOAD;

            static {
                AppMethodBeat.o(50797);
            }
        }

        public enum b {
            INSERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(50794);
            }
        }

        void a(a aVar);
    }

    public static class b {
        public byte[] buf = null;
        public int cqs = 0;
        public int fXD = 0;
        public int ret = 0;
    }

    /* renamed from: com.tencent.mm.modelvideo.t$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String fXq;
        final /* synthetic */ String fXr;
        final /* synthetic */ String fXs;

        AnonymousClass2(String str, String str2, String str3) {
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
            AppMethodBeat.i(50791);
            int asZ = (int) e.asZ(this.fXq);
            int asZ2 = (int) e.asZ(this.fXr);
            ab.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", Long.valueOf(bo.anU()), Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
            int i;
            if (asZ2 != asZ) {
                i = (asZ <= 0 ? 20 : 0) + ((asZ2 <= 0 ? 10 : 0) + 106);
                com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(i), this.fXs, "", "", Integer.valueOf(asZ2));
                ab.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
                AppMethodBeat.o(50791);
                return;
            }
            int i2 = 0;
            Object obj2 = null;
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            try {
                inputStream = e.openRead(this.fXq);
                inputStream2 = e.openRead(this.fXr);
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
                            ab.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", bo.l(e));
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
                ab.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", bo.l(e));
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
                ab.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(asZ), Integer.valueOf(asZ2), this.fXq, this.fXr);
                com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(107), this.fXs);
                AppMethodBeat.o(50791);
                return;
            }
            long gb = bo.gb(r6);
            com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(400), this.fXs, String.valueOf(i2), Long.valueOf(gb));
            ab.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(gb), Integer.valueOf(i2), this.fXq, this.fXr);
            AppMethodBeat.o(50791);
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(50798);
        this.fry.a(aVar, looper);
        AppMethodBeat.o(50798);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(50799);
        this.fry.remove(aVar);
        AppMethodBeat.o(50799);
    }

    public t(h hVar) {
        AppMethodBeat.i(50800);
        this.fni = hVar;
        AppMethodBeat.o(50800);
    }

    public final boolean b(s sVar) {
        AppMethodBeat.i(50801);
        if (sVar == null) {
            AppMethodBeat.o(50801);
            return false;
        }
        sVar.bJt = -1;
        if (((int) this.fni.insert("videoinfo2", "filename", sVar.Hl())) != -1) {
            this.fry.cF(new a(sVar.getFileName(), b.INSERT, c.NORMAL, sVar.fXk, sVar.fVs));
            this.fry.doNotify();
            AppMethodBeat.o(50801);
            return true;
        }
        AppMethodBeat.o(50801);
        return false;
    }

    public final s uf(String str) {
        s sVar = null;
        AppMethodBeat.i(50802);
        Cursor a = this.fni.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(50802);
        } else {
            if (a.moveToFirst()) {
                sVar = new s();
                sVar.d(a);
            }
            a.close();
            AppMethodBeat.o(50802);
        }
        return sVar;
    }

    public final List<s> fU(long j) {
        List<s> list = null;
        AppMethodBeat.i(50803);
        Cursor a = this.fni.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = ".concat(String.valueOf(j)), null, 2);
        if (a == null) {
            AppMethodBeat.o(50803);
        } else {
            list = new ArrayList();
            while (a.moveToNext()) {
                s sVar = new s();
                sVar.d(a);
                list.add(sVar);
            }
            a.close();
            AppMethodBeat.o(50803);
        }
        return list;
    }

    public final List<s> alB() {
        AppMethodBeat.i(50804);
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.a(str, null, 2);
        int i = 0;
        while (a.moveToNext()) {
            s sVar = new s();
            sVar.d(a);
            arrayList.add(sVar);
            i++;
        }
        a.close();
        ab.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
        AppMethodBeat.o(50804);
        return arrayList;
    }

    public final List<s> alC() {
        AppMethodBeat.i(50805);
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.a(str, null, 2);
        while (a.moveToNext()) {
            s sVar = new s();
            sVar.d(a);
            arrayList.add(sVar);
        }
        a.close();
        AppMethodBeat.o(50805);
        return arrayList;
    }

    public final boolean c(s sVar) {
        boolean z;
        AppMethodBeat.i(50806);
        Assert.assertTrue(sVar != null);
        if (sVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues Hl = sVar.Hl();
        if (Hl.size() <= 0) {
            ab.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.fni.update("videoinfo2", Hl, "filename= ?", new String[]{sVar.getFileName()}) > 0) {
                c cVar = c.NORMAL;
                if (sVar.status == 112) {
                    cVar = c.DOWNLOAD;
                } else if (sVar.status == 103 || sVar.status == 104) {
                    cVar = c.UPLOAD;
                }
                this.fry.cF(new a(sVar.getFileName(), b.UPDATE, cVar, sVar.fXk, sVar.fVs));
                this.fry.doNotify();
                AppMethodBeat.o(50806);
                return true;
            }
        }
        AppMethodBeat.o(50806);
        return false;
    }

    public final List<String> alD() {
        Throwable th;
        List<String> list = null;
        AppMethodBeat.i(50807);
        Cursor a;
        try {
            a = this.fni.a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10", null, 2);
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
                AppMethodBeat.o(50807);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(50807);
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
        AppMethodBeat.i(50808);
        String str = " LIMIT 10 )";
        Cursor a;
        try {
            a = this.fni.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null, 2);
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
                AppMethodBeat.o(50808);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(50808);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    public final List<s> v(int i, long j) {
        Throwable th;
        List<s> list = null;
        AppMethodBeat.i(50809);
        Cursor a;
        try {
            a = this.fni.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + i + " AND preloadsize > 0 AND lastmodifytime <= " + j + " ORDER BY createtime LIMIT 1", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        s sVar = new s();
                        sVar.d(a);
                        list.add(sVar);
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(50809);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(50809);
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
        AppMethodBeat.i(50810);
        String str = " LIMIT 10 )";
        Cursor a;
        try {
            a = this.fni.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null, 2);
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
                AppMethodBeat.o(50810);
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(50810);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
        }
    }

    public static String ug(String str) {
        AppMethodBeat.i(50811);
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.x(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = fXo;
        fXo = 1 + currentTimeMillis;
        format = append.append(currentTimeMillis).toString();
        AppMethodBeat.o(50811);
        return format;
    }

    private static String getVideoPath() {
        AppMethodBeat.i(50812);
        String str = com.tencent.mm.kernel.g.RP().eJM + "video/";
        AppMethodBeat.o(50812);
        return str;
    }

    public static String uh(String str) {
        AppMethodBeat.i(50813);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50813);
            return null;
        }
        String str2 = getVideoPath() + str;
        if (e.ct(str2)) {
            AppMethodBeat.o(50813);
            return str2;
        }
        str2 = str2 + VideoMaterialUtil.MP4_SUFFIX;
        AppMethodBeat.o(50813);
        return str2;
    }

    public static String ui(String str) {
        AppMethodBeat.i(50814);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50814);
            return null;
        }
        String str2 = getVideoPath() + str + FileUtils.PIC_POSTFIX_JPEG;
        AppMethodBeat.o(50814);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x01cc A:{SYNTHETIC, Splitter:B:28:0x01cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(String str, int i, byte[] bArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(50815);
        int line;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " invalid fileName");
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50815);
            return line;
        } else if (i < 0) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  invalid startOffset:" + i);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50815);
            return line;
        } else if (bo.cb(bArr)) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  invalid writeBuf");
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50815);
            return line;
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long Mr = aVar.Mr();
                    randomAccessFile.seek((long) i);
                    long Mr2 = aVar.Mr();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long Mr3 = aVar.Mr();
                    line = (int) randomAccessFile.getFilePointer();
                    long Mr4 = aVar.Mr();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    ab.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    ab.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "] open:" + Mr + " seek:" + Mr2 + " write:" + Mr3 + " close:" + Mr4);
                    AppMethodBeat.o(50815);
                    return line;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                try {
                    ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                    line = 0 - com.tencent.mm.compatible.util.g.getLine();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.o(50815);
                    return line;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(50815);
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
                AppMethodBeat.o(50815);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01d3 A:{SYNTHETIC, Splitter:B:23:0x01d3} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01df A:{SYNTHETIC, Splitter:B:29:0x01df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b m(String str, int i, int i2) {
        Exception e;
        Throwable th;
        int i3 = 0;
        AppMethodBeat.i(50816);
        b bVar = new b();
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " invalid fileName");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50816);
        } else if (i < 0) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  invalid readOffset:" + i);
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50816);
        } else if (i2 <= 0) {
            ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50816);
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            bVar.buf = new byte[i2];
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long Mr = aVar.Mr();
                    randomAccessFile.seek((long) i);
                    long Mr2 = aVar.Mr();
                    int read = randomAccessFile.read(bVar.buf, 0, i2);
                    long Mr3 = aVar.Mr();
                    long Mr4 = aVar.Mr();
                    if (read >= 0) {
                        i3 = read;
                    }
                    bVar.cqs = i3;
                    bVar.fXD = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    ab.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    ab.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "] open:" + Mr + " seek:" + Mr2 + " write:" + Mr3 + " close:" + Mr4);
                    AppMethodBeat.o(50816);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "] \t\tOffset:" + bVar.fXD + " failed:[" + e.getMessage() + "]");
                        bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(50816);
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                        }
                        AppMethodBeat.o(50816);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                ab.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + "[" + str + "] \t\tOffset:" + bVar.fXD + " failed:[" + e.getMessage() + "]");
                bVar.ret = 0 - com.tencent.mm.compatible.util.g.getLine();
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(50816);
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.o(50816);
                throw th;
            }
        }
        return bVar;
    }

    public static int uj(String str) {
        AppMethodBeat.i(50817);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50817);
            return -1;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.exists()) {
            int length = (int) bVar.length();
            if (length <= 0) {
                AppMethodBeat.o(50817);
                return 0;
            }
            AppMethodBeat.o(50817);
            return length;
        }
        AppMethodBeat.o(50817);
        return 0;
    }

    public final boolean s(String str, String str2, String str3) {
        AppMethodBeat.i(50818);
        boolean aW = aW(str, str2 + "##" + str3);
        AppMethodBeat.o(50818);
        return aW;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2 A:{SYNTHETIC, Splitter:B:26:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df A:{SYNTHETIC, Splitter:B:32:0x00df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int[] uk(String str) {
        Throwable e;
        int i = 0;
        AppMethodBeat.i(50819);
        int[] iArr = new int[33];
        long anU = bo.anU();
        int asZ = (int) e.asZ(str);
        if (asZ < 102400 || asZ >= 104857600) {
            ab.e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", Integer.valueOf(asZ), str);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf((asZ < 102400 ? 10 : 20) + 101);
            objArr[1] = Integer.valueOf(asZ);
            hVar.e(12696, objArr);
            AppMethodBeat.o(50819);
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
                    iArr[i] = (i.s(bArr, 512) % j.INVALID_ID) | j.INVALID_ID;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, bo.l(e));
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e3) {
                            }
                        }
                        AppMethodBeat.o(50819);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(50819);
                        throw e;
                    }
                }
            }
            randomAccessFile.close();
            ab.i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(asZ), str);
            try {
                randomAccessFile.close();
            } catch (Exception e5) {
            }
            AppMethodBeat.o(50819);
            return iArr;
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            ab.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, bo.l(e));
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(50819);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(50819);
            throw e;
        }
    }

    private boolean aW(String str, String str2) {
        AppMethodBeat.i(50820);
        ab.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", str, str2, bo.dpG());
        long anU = bo.anU();
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", str, str2);
            AppMethodBeat.o(50820);
            return false;
        }
        int[] uk = uk(str);
        if (uk == null || uk.length < 33) {
            ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", str);
            AppMethodBeat.o(50820);
            return false;
        }
        int i = uk[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(uk[i2]));
        }
        Cursor a = this.fni.a("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (a.moveToNext()) {
            vector.add(a.getString(0));
            ab.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", Integer.valueOf(vector.size()), vector.get(vector.size() - 1));
        }
        a.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            ab.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", Long.valueOf(bo.gb(anU)), str, str2);
            AppMethodBeat.o(50820);
            return true;
        }
        if (vector.size() > 0) {
            com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(102), Integer.valueOf(i), "", "", Integer.valueOf(vector.size()));
            ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", Integer.valueOf(vector.size()), Integer.valueOf(i));
            this.fni.hY("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(bo.anT()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        ab.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", Long.valueOf(bo.gb(anU)), Long.valueOf(this.fni.insert("VideoHash", "", contentValues)), str, stringBuffer, str2);
        if (this.fni.insert("VideoHash", "", contentValues) < 0) {
            com.tencent.mm.plugin.report.service.h.pYm.e(12696, Integer.valueOf(103), Integer.valueOf(i));
            ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", Long.valueOf(r0), str);
        }
        AppMethodBeat.o(50820);
        return true;
    }
}
