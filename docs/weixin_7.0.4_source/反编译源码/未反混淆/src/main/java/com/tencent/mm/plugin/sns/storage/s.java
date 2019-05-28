package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.i.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wxmm.v2helper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class s extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int qDU = 0;
    private static int qDc = 0;
    private static Point qLw = new Point();
    public h fni;

    static {
        AppMethodBeat.i(38001);
        AppMethodBeat.o(38001);
    }

    public s(h hVar) {
        this.fni = hVar;
    }

    public static int getScreenWidth() {
        return qDU > qDc ? qDc : qDU;
    }

    public static void fs(int i, int i2) {
        AppMethodBeat.i(37978);
        qDU = i;
        qDc = i2;
        ab.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(37978);
    }

    private static String Zh(String str) {
        AppMethodBeat.i(37979);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(37979);
            return str2;
        }
        String x = g.x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = af.getAccSnsPath() + str2 + str3;
        AppMethodBeat.o(37979);
        return str2;
    }

    private boolean a(r rVar) {
        AppMethodBeat.i(37980);
        ab.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
        if (rVar == null) {
            AppMethodBeat.o(37980);
            return false;
        }
        if (((int) this.fni.insert("SnsMedia", "local_id", rVar.cro())) != -1) {
            AppMethodBeat.o(37980);
            return true;
        }
        AppMethodBeat.o(37980);
        return false;
    }

    public final boolean a(String str, r rVar) {
        AppMethodBeat.i(37981);
        ab.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(str)));
        Cursor a = this.fni.a("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        boolean a2;
        if (a.moveToFirst()) {
            a.close();
            a2 = a(rVar);
            AppMethodBeat.o(37981);
            return a2;
        }
        a.close();
        a2 = b(str, rVar);
        AppMethodBeat.o(37981);
        return a2;
    }

    private boolean b(String str, r rVar) {
        AppMethodBeat.i(37982);
        if (this.fni.update("SnsMedia", rVar.cro(), "StrId=?", new String[]{String.valueOf(str)}) > 0) {
            AppMethodBeat.o(37982);
            return true;
        }
        AppMethodBeat.o(37982);
        return false;
    }

    public final int a(int i, r rVar) {
        AppMethodBeat.i(37983);
        int update = this.fni.update("SnsMedia", rVar.cro(), "local_id=?", new String[]{String.valueOf(i)});
        AppMethodBeat.o(37983);
        return update;
    }

    public final r Zi(String str) {
        AppMethodBeat.i(37984);
        r rVar = new r();
        Cursor a = this.fni.a("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            rVar.d(a);
            a.close();
            AppMethodBeat.o(37984);
            return rVar;
        }
        a.close();
        AppMethodBeat.o(37984);
        return null;
    }

    public final r kE(long j) {
        AppMethodBeat.i(37985);
        r rVar = new r();
        Cursor a = this.fni.a("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            rVar.d(a);
            a.close();
            AppMethodBeat.o(37985);
            return rVar;
        }
        a.close();
        AppMethodBeat.o(37985);
        return null;
    }

    public final List<com.tencent.mm.plugin.sns.data.h> dn(List<com.tencent.mm.plugin.sns.data.h> list) {
        AppMethodBeat.i(37986);
        LinkedList linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(37986);
            return null;
        }
        for (com.tencent.mm.plugin.sns.data.h hVar : list) {
            int a = a(hVar);
            if (a == -1) {
                AppMethodBeat.o(37986);
                return null;
            }
            com.tencent.mm.plugin.sns.data.h hVar2 = new com.tencent.mm.plugin.sns.data.h(a, hVar.type);
            hVar2.height = hVar.height;
            hVar2.width = hVar.width;
            hVar2.fileSize = hVar.fileSize;
            linkedList.add(hVar2);
        }
        AppMethodBeat.o(37986);
        return linkedList;
    }

    private static com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str) {
        int orientationInDegree;
        Throwable e;
        InputStream inputStream = null;
        int i = 0;
        AppMethodBeat.i(37987);
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream = e.openRead(str);
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            inputStream.mark(1048576);
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            Exif exif = new Exif();
            exif.parseFromStream(inputStream);
            orientationInDegree = exif.getOrientationInDegree();
            if (orientationInDegree == 90 || orientationInDegree == 270) {
                orientationInDegree = options.outWidth;
                try {
                    i = options.outHeight;
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                orientationInDegree = options.outHeight;
                i = options.outWidth;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Exception e4) {
            e = e4;
            orientationInDegree = i;
            try {
                ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "setImageExtInfo failed: ".concat(String.valueOf(str)), new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                hVar.width = i;
                hVar.height = orientationInDegree;
                hVar.fileSize = (int) e.asZ(str);
                AppMethodBeat.o(37987);
                return hVar;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(37987);
            }
        }
        hVar.width = i;
        hVar.height = orientationInDegree;
        hVar.fileSize = (int) e.asZ(str);
        AppMethodBeat.o(37987);
        return hVar;
    }

    private int a(com.tencent.mm.plugin.sns.data.h hVar) {
        AppMethodBeat.i(37988);
        String accSnsPath = af.getAccSnsPath();
        String accSnsTmpPath = af.getAccSnsTmpPath();
        ab.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", accSnsPath, accSnsTmpPath);
        long currentTimeMillis = System.currentTimeMillis();
        String str = hVar.path;
        int i = hVar.type;
        if (e.ct(str)) {
            String x = g.x((str + System.currentTimeMillis()).getBytes());
            String Xe = i.Xe(x);
            ab.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str)));
            if (!e.ct(accSnsTmpPath)) {
                ab.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(accSnsTmpPath)));
                e.tf(accSnsTmpPath);
            }
            if (!e.ct(accSnsPath)) {
                ab.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(accSnsPath)));
                e.tf(accSnsPath);
            }
            a aVar = new a();
            com.tencent.mm.plugin.sns.data.h a = a(hVar, str);
            int i2 = a.width;
            int i3 = a.height;
            int i4 = a.fileSize;
            aVar.nuw = str;
            aVar.nuy = i2;
            aVar.nuz = i3;
            aVar.nuA = i4;
            if (e(accSnsTmpPath, str, Xe, true)) {
                ab.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
                ab.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(Xe)));
                i2 = (int) e.asZ(accSnsTmpPath + Xe);
                if (str.toLowerCase().contains("jpg") || str.toLowerCase().contains("jpeg")) {
                    accSnsPath = d.bR(e.e(str, 0, i2));
                    if (accSnsPath != null) {
                        ab.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", accSnsPath);
                        try {
                            ExifInterface exifInterface = new ExifInterface(accSnsTmpPath + Xe);
                            exifInterface.setAttribute(android.support.d.a.TAG_USER_COMMENT, accSnsPath);
                            exifInterface.saveAttributes();
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
                        }
                    }
                }
                i2 = (int) e.asZ(accSnsTmpPath + Xe);
                com.tencent.mm.plugin.sns.data.h a2 = a(a, accSnsTmpPath + Xe);
                int i5 = a2.width;
                i3 = a2.height;
                aVar.nuB = i5;
                aVar.nuC = i3;
                aVar.nuD = i2;
                r rVar = new r();
                rVar.rfE = x;
                rVar.createTime = (long) ((int) bo.anT());
                rVar.type = i;
                bax bax = new bax();
                bax.wEJ = a2.qFY;
                bax.wFe = a2.qFX;
                bax.token = a2.qFZ;
                bax.wFn = a2.qGa;
                bax.wFB = 0;
                bax.wFA = new bar();
                bax.eRu = 0;
                bax.Desc = a2.desc;
                ab.d("MicroMsg.snsMediaStorage", "upload.filterId " + a2.filterId);
                bax.wFd = a2.filterId;
                bax.wFD = 2;
                bax.cvZ = e.atg(accSnsTmpPath + Xe);
                try {
                    rVar.rfI = bax.toByteArray();
                } catch (Exception e2) {
                    ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
                }
                rVar.crp();
                rVar.rfD = i2;
                ab.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + i2 + " filepath: " + accSnsTmpPath + Xe);
                i = (int) this.fni.insert("SnsMedia", "local_id", rVar.cro());
                ab.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
                String concat = "Locall_path".concat(String.valueOf(i));
                aVar.nux = String.valueOf(i);
                aVar.cvZ = bax.cvZ;
                Exif fromFile = Exif.fromFile(aVar.nuw);
                i2 = a.tF(aVar.nuw);
                if (aVar.nuw.indexOf("png") >= 0) {
                    i2 = 1;
                } else if (aVar.nuw.indexOf("jpg") >= 0 || aVar.nuw.indexOf("jpeg") >= 0) {
                    i2 = 2;
                } else if (aVar.nuw.indexOf("mp3") >= 0) {
                    i2 = 3;
                }
                str = fromFile.dateTimeOriginal;
                String str2 = aVar.nuw;
                if (bo.isNullOrNil(str)) {
                    str = a.OK(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new File(str2).lastModified())));
                } else {
                    str = a.OK(str);
                }
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.l("20 localID", aVar.nux + ",");
                dVar.l("21 MediaType", i2 + ",");
                dVar.l("22 OriginWidth", aVar.nuy + ",");
                dVar.l("23 OriginHeight", aVar.nuz + ",");
                dVar.l("24 CompressedWidth", aVar.nuB + ",");
                dVar.l("25 CompressedHeight", aVar.nuC + ",");
                dVar.l("26 OriginSize", aVar.nuA + ",");
                dVar.l("27 CompressedSize", aVar.nuD + ",");
                dVar.l("28 FNumber", fromFile.fNumber + ",");
                dVar.l("29 ExposureTime", fromFile.exposureTime + ",");
                dVar.l("30 ISO", fromFile.isoSpeedRatings + ",");
                dVar.l("31 Flash", fromFile.flash + ",");
                dVar.l("32 LensModel", a.OK(fromFile.model) + ",");
                dVar.l("33 CreatTime", str + ",");
                dVar.l("34 IsFromWeChat", "0,");
                dVar.l("35 Scene", ",");
                dVar.l("36 sceneType", fromFile.sceneType + ",");
                dVar.l("37 fileSource", fromFile.fileSource + ",");
                dVar.l("38 make", fromFile.make + ",");
                dVar.l("39 software", fromFile.software + ",");
                dVar.l("40 fileExt", a.cv(aVar.nuw) + ",");
                dVar.l("41 faceCount", "0,");
                dVar.l("42 YCbCrSubSampling", fromFile.yCbCrSubSampling + ",");
                dVar.l("43 md5", aVar.cvZ + ',');
                ab.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", dVar.Fk(), aVar.nuw);
                com.tencent.mm.plugin.report.service.h.pYm.e(14525, dVar);
                com.tencent.mm.plugin.sns.i.d.coE().qSY.put(Integer.valueOf(i), dVar.toString());
                accSnsPath = i.Xe(concat);
                str = Zh(concat);
                e.tf(str);
                ab.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str)));
                e.y(accSnsTmpPath + Xe, str + accSnsPath);
                accSnsTmpPath = str + i.Xa(concat);
                x = str + i.Xb(concat);
                e.deleteFile(accSnsTmpPath);
                e.deleteFile(x);
                ab.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + str + accSnsPath + " totalLen:" + e.asZ(str + accSnsPath) + "  now delete...:" + accSnsTmpPath + " & " + x);
                rVar.rfE = concat;
                a(i, rVar);
                AppMethodBeat.o(37988);
                return i;
            }
            AppMethodBeat.o(37988);
            return -1;
        }
        AppMethodBeat.o(37988);
        return -1;
    }

    public final com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h hVar, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(37989);
        r rVar = new r();
        rVar.createTime = (long) ((int) bo.anT());
        rVar.type = hVar.type;
        bax bax = new bax();
        bax.wEJ = hVar.qFY;
        bax.wFe = hVar.qFX;
        bax.token = hVar.qFZ;
        bax.wFn = hVar.qGa;
        bax.wFB = 0;
        bax.wFA = new bar();
        bax.eRu = 0;
        bax.Desc = hVar.desc;
        ab.d("MicroMsg.snsMediaStorage", "upload.filterId " + hVar.filterId);
        bax.wFd = hVar.filterId;
        bax.wFD = 2;
        bax.videoPath = str;
        bax.wFF = str2;
        bax.cvZ = hVar.qGb;
        try {
            rVar.rfI = bax.toByteArray();
        } catch (Exception e) {
            ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        rVar.crp();
        int insert = (int) this.fni.insert("SnsMedia", "local_id", rVar.cro());
        String concat = "Locall_path".concat(String.valueOf(insert));
        ab.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(insert)));
        String Xe = i.Xe(concat);
        String Xf = i.Xf(concat);
        String Xd = i.Xd(concat);
        String Xg = i.Xg(concat);
        String Zh = Zh(concat);
        e.tf(Zh);
        e.y(str2, Zh + Xe);
        e.y(str2, Zh + Xf);
        e.y(str2, Zh + Xd);
        e.y(str, Zh + Xg);
        bax.videoPath = Zh + Xg;
        bax.wFF = Zh + Xf;
        bax.cvZ = hVar.qGb;
        try {
            rVar.rfI = bax.toByteArray();
        } catch (Exception e2) {
            ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        rVar.rfE = concat;
        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            bar bar = new bar();
            bar.jCt = 1;
            bar.Url = str3;
            bax.wFA = bar;
            bax.wFD = 0;
            f.afy();
            bax.wFc = com.tencent.mm.al.a.rJ(str);
            if (!bo.isNullOrNil(str4)) {
                bar = new bar();
                bar.jCt = 1;
                bar.Url = str4;
                bax.wFC.add(bar);
            }
            try {
                rVar.rfI = bax.toByteArray();
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
            }
            rVar.crq();
        }
        a(insert, rVar);
        com.tencent.mm.plugin.sns.data.h a = a(hVar, bax.wFF);
        a.cNE = insert;
        AppMethodBeat.o(37989);
        return a;
    }

    public static boolean crr() {
        AppMethodBeat.i(37990);
        if ("hevc".equals(ae.gjm)) {
            AppMethodBeat.o(37990);
            return true;
        }
        boolean cnP = af.cnP();
        AppMethodBeat.o(37990);
        return cnP;
    }

    public static boolean crs() {
        AppMethodBeat.i(37991);
        if ("wxpc".equals(ae.gjm)) {
            AppMethodBeat.o(37991);
            return true;
        }
        boolean cnQ = af.cnQ();
        AppMethodBeat.o(37991);
        return cnQ;
    }

    public static boolean aj(String str, String str2, String str3) {
        AppMethodBeat.i(139041);
        boolean e = e(str, str2, str3, true);
        AppMethodBeat.o(139041);
        return e;
    }

    public static boolean crt() {
        return qDc >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN && qDU >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    }

    /* JADX WARNING: Removed duplicated region for block: B:176:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A:{SYNTHETIC, Splitter:B:15:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03ba A:{SYNTHETIC, Splitter:B:106:0x03ba} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0147 A:{SYNTHETIC, Splitter:B:43:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0204 A:{SYNTHETIC, Splitter:B:62:0x0204} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A:{SYNTHETIC, Splitter:B:15:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0147 A:{SYNTHETIC, Splitter:B:43:0x0147} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03ba A:{SYNTHETIC, Splitter:B:106:0x03ba} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01b2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0204 A:{SYNTHETIC, Splitter:B:62:0x0204} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(String str, String str2, String str3, boolean z) {
        boolean z2;
        Object obj;
        int i;
        int i2;
        int i3;
        int asZ;
        int i4;
        int detectFaceCnt;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(37993);
        Options amj = d.amj(str2);
        if (amj != null) {
            String str4 = amj.outMimeType;
            ab.d("MicroMsg.snsMediaStorage", "mimetype: ".concat(String.valueOf(str4)));
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("jpeg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("png") >= 0) {
                    z2 = true;
                }
                if (amj != null) {
                    str4 = amj.outMimeType;
                    if (str4 != null) {
                        int obj2;
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") >= 0) {
                            obj2 = 1;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            obj2 = 1;
                        }
                        i = -1;
                        i2 = 100;
                        if (z) {
                            try {
                                f.afx();
                                if (b.lg(64) || crr() || crs()) {
                                    if (at.isWifi(ah.getContext())) {
                                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                                    } else if (at.is2G(ah.getContext())) {
                                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                                    } else if (at.is3G(ah.getContext())) {
                                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                                    } else {
                                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                                    }
                                } else if (at.isWifi(ah.getContext())) {
                                    i3 = Integer.valueOf(com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelForWifi")).intValue();
                                } else if (at.is2G(ah.getContext())) {
                                    i3 = Integer.valueOf(com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelFor2G")).intValue();
                                } else {
                                    i3 = Integer.valueOf(com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelFor3G")).intValue();
                                }
                                try {
                                    ab.d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.m.g.Nu().getValue("SnsWebpCompressPicLevelFor4G"), com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.m.g.Nu().getValue("SnsCompressPicLevelFor3G"));
                                } catch (Exception e) {
                                }
                            } catch (Exception e2) {
                                i3 = 100;
                            }
                            ab.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", Integer.valueOf(i3), Boolean.valueOf(z));
                            if (i3 <= 10 || i3 > 100) {
                                i2 = 60;
                            } else {
                                i2 = i3;
                            }
                            if (obj2 != null) {
                                i3 = MMNativeJpeg.queryQuality(str2);
                                if (i3 >= i2 || i3 <= 25) {
                                    i = i3;
                                } else {
                                    i2 = i3;
                                    i = i3;
                                }
                            }
                        }
                        asZ = (int) e.asZ(str2);
                        i4 = 0;
                        i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                        ab.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
                        if (detectFaceCnt >= 5) {
                            i4 = 0;
                            i3 = 1440;
                        }
                        String value;
                        if (detectFaceCnt >= 5) {
                            try {
                                value = com.tencent.mm.m.g.Nu().getValue("SnsCompressResolutionForMultiHead");
                                i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                            } catch (Exception e3) {
                            }
                        } else if (at.isWifi(ah.getContext())) {
                            value = com.tencent.mm.m.g.Nu().getValue("SnsCompressResolutionForWifi");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (at.is2G(ah.getContext())) {
                            value = com.tencent.mm.m.g.Nu().getValue("SnsCompressResolutionFor2G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (at.is3G(ah.getContext())) {
                            value = com.tencent.mm.m.g.Nu().getValue("SnsCompressResolutionFor3G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = com.tencent.mm.m.g.Nu().getValue("SnsCompressResolutionFor4G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                        ab.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
                        if (i4 > 0 && i3 <= 0) {
                            i4 = 0;
                            i5 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        } else if (i3 >= 2160) {
                            i4 = 0;
                            i5 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        } else if (i3 > 0 || i4 <= 3240) {
                            i5 = i3;
                        } else {
                            i4 = 1620;
                            i5 = 0;
                        }
                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                        if (i3 <= 0) {
                            i3 = 100;
                        }
                        detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                        if (i3 <= 0) {
                            i3 = 200;
                        }
                        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                        if (i3 > 0 || i3 >= 100) {
                            i7 = 10;
                        } else {
                            i7 = i3;
                        }
                        i3 = 0;
                        if (obj2 != null) {
                            try {
                                Exif fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i3 = fromFile.getOrientationInDegree() % v2helper.VOIP_ENC_HEIGHT_LV1;
                                }
                                i8 = i3;
                            } catch (Exception e4) {
                                ab.e("MicroMsg.snsMediaStorage", "get degree error " + e4.getMessage());
                            }
                            ab.i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                            bo.getInt(com.tencent.mm.m.g.Nu().getValue("CompressLongImageRatio"), 10);
                            boolean a;
                            if (amj.outWidth < amj.outHeight * 2 || amj.outHeight >= amj.outWidth * 2) {
                                if (amj.outWidth * amj.outHeight <= 10240000) {
                                    ab.i("MicroMsg.snsMediaStorage", "too max pic " + amj.outWidth + " " + amj.outHeight);
                                    if (amj.outHeight <= 0) {
                                        amj.outHeight = 1;
                                    }
                                    if (amj.outWidth <= 0) {
                                        amj.outWidth = 1;
                                    }
                                    if (amj.outWidth > amj.outHeight) {
                                        i3 = amj.outWidth / amj.outHeight;
                                    } else {
                                        i3 = amj.outHeight / amj.outWidth;
                                    }
                                    if (i3 == 0) {
                                        i3 = 1;
                                    }
                                    obj2 = (int) Math.sqrt((double) (10240000 / i3));
                                    if (amj.outWidth > amj.outHeight) {
                                        i4 = obj2 * i3;
                                        i = obj2;
                                    } else {
                                        i = obj2 * i3;
                                        i4 = obj2;
                                    }
                                    ab.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i + " " + i3);
                                    a = a(str2, i, i4, CompressFormat.JPEG, i2, str, str3, z);
                                    AppMethodBeat.o(37993);
                                    return a;
                                } else if (asZ < i6 && z2 && i8 == 0) {
                                    ab.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong ".concat(String.valueOf(i6)));
                                    if (e.y(str2, str + str3) >= 0) {
                                        AppMethodBeat.o(37993);
                                        return true;
                                    }
                                    AppMethodBeat.o(37993);
                                    return false;
                                } else {
                                    Options options = new Options();
                                    d.dnX();
                                    InputStream inputStream = null;
                                    try {
                                        inputStream = e.openRead(str2);
                                        if (!inputStream.markSupported()) {
                                            inputStream = new BufferedInputStream(inputStream);
                                        }
                                        inputStream.mark(1048576);
                                        Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
                                        inputStream.reset();
                                        if (decodeStream == null) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e5) {
                                                }
                                            }
                                            AppMethodBeat.o(37993);
                                            return false;
                                        }
                                        d.a(d.b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                                        if (z2 && i8 == 0) {
                                            ab.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(e.asZ(str + str3)), Integer.valueOf(i7));
                                            if ((((long) asZ) - e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                                e.deleteFile(str + str3);
                                                a = e.y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e6) {
                                                    }
                                                }
                                                AppMethodBeat.o(37993);
                                                return a;
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e7) {
                                                }
                                            }
                                            AppMethodBeat.o(37993);
                                            return true;
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e8) {
                                            }
                                        }
                                        AppMethodBeat.o(37993);
                                        return true;
                                    } catch (IOException e9) {
                                        ab.printErrStackTrace("MicroMsg.snsMediaStorage", e9, "Decode bitmap failed: ".concat(String.valueOf(str2)), new Object[0]);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e10) {
                                            }
                                        }
                                        AppMethodBeat.o(37993);
                                        return false;
                                    } catch (Throwable th) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e11) {
                                            }
                                        }
                                        AppMethodBeat.o(37993);
                                    }
                                }
                            } else if (asZ < detectFaceCnt && z2 && i8 == 0) {
                                ab.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal ".concat(String.valueOf(detectFaceCnt)));
                                if (e.y(str2, str + str3) >= 0) {
                                    AppMethodBeat.o(37993);
                                    return true;
                                }
                                AppMethodBeat.o(37993);
                                return false;
                            } else {
                                i3 = amj.outWidth > amj.outHeight ? amj.outWidth : amj.outHeight;
                                i = amj.outWidth < amj.outHeight ? amj.outWidth : amj.outHeight;
                                if ((i5 <= 0 || i > i5) && (i5 > 0 || i3 > i4)) {
                                    if (i5 > 0) {
                                        a = a(str2, amj.outWidth, amj.outHeight, i5, CompressFormat.JPEG, i2, str, str3);
                                    } else {
                                        double d = (((double) i3) * 1.0d) / ((double) i4);
                                        a = a(str2, (int) (((double) amj.outHeight) / d), (int) (((double) amj.outWidth) / d), CompressFormat.JPEG, i2, str, str3, z);
                                    }
                                    if (z2 && i8 == 0) {
                                        ab.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(e.asZ(str + str3)), Integer.valueOf(i7));
                                        if ((((long) asZ) - e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                            e.deleteFile(str + str3);
                                            if (e.y(str2, str + str3) >= 0) {
                                                AppMethodBeat.o(37993);
                                                return true;
                                            }
                                            AppMethodBeat.o(37993);
                                            return false;
                                        }
                                    }
                                    AppMethodBeat.o(37993);
                                    return a;
                                }
                                ab.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", Integer.valueOf(asZ), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                                if (e.asZ(str2) < 71680) {
                                    if (z2) {
                                        ab.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", str2);
                                        if (e.y(str2, str + str3) >= 0) {
                                            AppMethodBeat.o(37993);
                                            return true;
                                        }
                                        AppMethodBeat.o(37993);
                                        return false;
                                    } else if (amj.outWidth < 150 && amj.outHeight < 150) {
                                        a = a(str2, amj.outHeight, amj.outWidth, CompressFormat.PNG, i2, str, str3, z);
                                        AppMethodBeat.o(37993);
                                        return a;
                                    }
                                }
                                a = a(str2, amj.outHeight, amj.outWidth, CompressFormat.JPEG, i2, str, str3, z);
                                if (z2 && i8 == 0) {
                                    ab.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(e.asZ(str + str3)), Integer.valueOf(i7));
                                    if ((((long) asZ) - e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                        e.deleteFile(str + str3);
                                        if (e.y(str2, str + str3) >= 0) {
                                            AppMethodBeat.o(37993);
                                            return true;
                                        }
                                        AppMethodBeat.o(37993);
                                        return false;
                                    }
                                    AppMethodBeat.o(37993);
                                    return a;
                                }
                                AppMethodBeat.o(37993);
                                return a;
                            }
                        }
                        i8 = 0;
                        ab.i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                        bo.getInt(com.tencent.mm.m.g.Nu().getValue("CompressLongImageRatio"), 10);
                        if (amj.outWidth < amj.outHeight * 2) {
                        }
                        if (amj.outWidth * amj.outHeight <= 10240000) {
                        }
                    }
                }
                obj2 = null;
                i = -1;
                i2 = 100;
                if (z) {
                }
                asZ = (int) e.asZ(str2);
                i4 = 0;
                i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                ab.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
                if (detectFaceCnt >= 5) {
                }
                if (detectFaceCnt >= 5) {
                }
                ab.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
                if (i4 > 0) {
                }
                if (i3 >= 2160) {
                }
                i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i3 <= 0) {
                }
                detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i3 <= 0) {
                }
                i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i3 > 0) {
                }
                i7 = 10;
                i3 = 0;
                if (obj2 != null) {
                }
                i8 = 0;
                ab.i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                bo.getInt(com.tencent.mm.m.g.Nu().getValue("CompressLongImageRatio"), 10);
                if (amj.outWidth < amj.outHeight * 2) {
                }
                if (amj.outWidth * amj.outHeight <= 10240000) {
                }
            }
        }
        z2 = false;
        if (amj != null) {
        }
        obj2 = null;
        i = -1;
        i2 = 100;
        if (z) {
        }
        asZ = (int) e.asZ(str2);
        i4 = 0;
        i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
        ab.i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
        if (detectFaceCnt >= 5) {
        }
        if (detectFaceCnt >= 5) {
        }
        ab.i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
        if (i4 > 0) {
        }
        if (i3 >= 2160) {
        }
        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i3 <= 0) {
        }
        detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
        if (i3 <= 0) {
        }
        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i3 > 0) {
        }
        i7 = 10;
        i3 = 0;
        if (obj2 != null) {
        }
        i8 = 0;
        ab.i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
        bo.getInt(com.tencent.mm.m.g.Nu().getValue("CompressLongImageRatio"), 10);
        if (amj.outWidth < amj.outHeight * 2) {
        }
        if (amj.outWidth * amj.outHeight <= 10240000) {
        }
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        AppMethodBeat.i(37994);
        Options amj = d.amj(str);
        if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
            AppMethodBeat.o(37994);
            return false;
        }
        boolean a = a(str, amj.outWidth, amj.outHeight, i, i2, compressFormat, i3, str2, str3, z);
        AppMethodBeat.o(37994);
        return a;
    }

    private static boolean a(String str, int i, int i2, int i3, CompressFormat compressFormat, int i4, String str2, String str3) {
        AppMethodBeat.i(37995);
        OutputStream outputStream = null;
        try {
            Bitmap b;
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            Options options = new Options();
            int i5 = i2 > i ? i : i2;
            if (i5 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options);
            } else {
                options.inSampleSize = 1;
                if (i5 > i3) {
                    options.inSampleSize = i5 / i3;
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 5529600) {
                    options.inSampleSize++;
                }
                ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b = com.tencent.mm.plugin.sns.d.a.b(str, options);
            }
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", b);
            if (b == null) {
                AppMethodBeat.o(37995);
                return false;
            }
            int i6;
            int i7;
            int i8 = (i * i3) / i5;
            int i9 = (i2 * i3) / i5;
            int bJ = ExifHelper.bJ(str);
            if (bJ == 90 || bJ == 270) {
                i6 = i9;
                i7 = i8;
            } else {
                i6 = i8;
                i7 = i9;
            }
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(bJ));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, i7, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.Xf().v(b);
            }
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4));
            outputStream = e.L(str2 + str3, false);
            d.a(createScaledBitmap, i4, compressFormat, outputStream, false);
            l.Xf().v(createScaledBitmap);
            outputStream.close();
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", str2 + str3, Long.valueOf(e.asZ(str2 + str3)));
            AppMethodBeat.o(37995);
            return true;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", str3);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(37995);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A:{Splitter:B:1:0x0009, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x004d, code skipped:
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:21:0x0059, code skipped:
            if (r2 != null) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Zj(String str) {
        InputStream inputStream = null;
        AppMethodBeat.i(37996);
        InputStream inputStream2;
        try {
            inputStream = e.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            String str2 = options.outMimeType;
            ab.d("MicroMsg.snsMediaStorage", "mineType ".concat(String.valueOf(str2)));
            if (str2.toLowerCase().indexOf("webp") >= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(37996);
                return true;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(37996);
            return false;
            AppMethodBeat.o(37996);
            return false;
            AppMethodBeat.o(37996);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(37996);
            return false;
        } catch (Exception e4) {
            inputStream2 = inputStream;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e6 A:{SYNTHETIC, Splitter:B:46:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e6 A:{SYNTHETIC, Splitter:B:46:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, String str2, String str3, float f) {
        InputStream inputStream;
        double d;
        double d2;
        double d3;
        String str4;
        int i;
        int i2;
        int i3;
        int i4;
        boolean a;
        CompressFormat compressFormat;
        AppMethodBeat.i(37997);
        double d4 = 0.0d;
        Object obj = 1;
        InputStream inputStream2 = null;
        try {
            Options options;
            inputStream2 = e.openRead(str + str2);
            try {
                options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(inputStream2, null, options);
                inputStream2.close();
                inputStream = null;
            } catch (Exception e) {
                inputStream = inputStream2;
                d = 0.0d;
                if (inputStream != null) {
                }
                d2 = 240.0d;
                d3 = 240.0d;
                str4 = str + str2;
                i = (int) d;
                i2 = (int) d4;
                i3 = (int) d2;
                i4 = (int) d3;
                if (obj != null) {
                }
                a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.o(37997);
                return a;
            }
            try {
                d = (double) options.outWidth;
                d4 = (double) options.outHeight;
                if (d > 120.0d || d4 > 120.0d) {
                    obj = null;
                }
            } catch (Exception e2) {
                d = 0.0d;
                if (inputStream != null) {
                }
                d2 = 240.0d;
                d3 = 240.0d;
                str4 = str + str2;
                i = (int) d;
                i2 = (int) d4;
                i3 = (int) d2;
                i4 = (int) d3;
                if (obj != null) {
                }
                a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.o(37997);
                return a;
            }
            try {
                double d5;
                str4 = options.outMimeType;
                if (d < 0.0d || d4 < 0.0d) {
                    d5 = 240.0d;
                    d3 = 240.0d;
                } else {
                    d5 = d4;
                    d3 = d;
                }
                double d6 = (double) f;
                double d7 = (double) ((f / 200.0f) * 44.0f);
                double d8 = (double) ((f / 200.0f) * 160.0f);
                if (d3 <= 0.0d || d5 <= 0.0d) {
                    d2 = d8;
                    d3 = d8;
                    str4 = str + str2;
                    i = (int) d;
                    i2 = (int) d4;
                    i3 = (int) d2;
                    i4 = (int) d3;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                    AppMethodBeat.o(37997);
                    return a;
                }
                d8 = Math.min(d6 / d3, d6 / d5);
                d3 *= d8;
                d8 *= d5;
                if (d3 < d7) {
                    d2 = (1.0d * d7) / d3;
                    d3 *= d2;
                    d8 *= d2;
                }
                if (d8 < d7) {
                    d2 = (1.0d * d7) / d8;
                    d3 *= d2;
                    d8 *= d2;
                }
                if (d3 > d6) {
                    d3 = d6;
                }
                if (d8 <= d6) {
                    d6 = d8;
                }
                d2 = d6;
                str4 = str + str2;
                i = (int) d;
                i2 = (int) d4;
                i3 = (int) d2;
                i4 = (int) d3;
                if (obj != null) {
                }
                a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.o(37997);
                return a;
            } catch (Exception e3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        d2 = 240.0d;
                        d3 = 240.0d;
                    } catch (IOException e4) {
                        d2 = 240.0d;
                        d3 = 240.0d;
                        str4 = str + str2;
                        i = (int) d;
                        i2 = (int) d4;
                        i3 = (int) d2;
                        i4 = (int) d3;
                        if (obj != null) {
                        }
                        a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                        AppMethodBeat.o(37997);
                        return a;
                    }
                    str4 = str + str2;
                    i = (int) d;
                    i2 = (int) d4;
                    i3 = (int) d2;
                    i4 = (int) d3;
                    if (obj != null) {
                    }
                    a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                    AppMethodBeat.o(37997);
                    return a;
                }
                d2 = 240.0d;
                d3 = 240.0d;
                str4 = str + str2;
                i = (int) d;
                i2 = (int) d4;
                i3 = (int) d2;
                i4 = (int) d3;
                if (obj != null) {
                }
                a = a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.o(37997);
                return a;
            }
        } catch (Exception e5) {
            inputStream = inputStream2;
            d = 0.0d;
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        AppMethodBeat.i(37998);
        OutputStream outputStream = null;
        try {
            Bitmap b;
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
            Options options = new Options();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b = com.tencent.mm.plugin.sns.d.a.b(str, options);
            }
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", b);
            if (b == null) {
                AppMethodBeat.o(37998);
                return false;
            }
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            if (z) {
                int ceil;
                int i6;
                int i7;
                if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                    i6 = i4;
                } else {
                    i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i3;
                }
                int bJ = ExifHelper.bJ(str);
                if (bJ == 90 || bJ == 270) {
                    bJ = ceil;
                    i7 = i6;
                } else {
                    bJ = i6;
                    i7 = ceil;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, bJ, i7, true);
                if (createScaledBitmap != null) {
                    if (b != createScaledBitmap) {
                        l.Xf().v(b);
                    }
                    b = createScaledBitmap;
                }
                ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            }
            outputStream = e.L(str2 + str3, false);
            d.a(b, i5, compressFormat, outputStream, false);
            l.Xf().v(b);
            outputStream.close();
            AppMethodBeat.o(37998);
            return true;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", str3);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(37998);
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3, float f) {
        AppMethodBeat.i(37999);
        try {
            e.deleteFile(str + str3);
            Options amj = d.amj(str + str2);
            if (amj == null) {
                ab.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                AppMethodBeat.o(37999);
                return false;
            }
            Bitmap b;
            if (amj.outMimeType == null || !(amj.outMimeType.toLowerCase().endsWith("png") || amj.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = amj.outWidth;
                int i2 = amj.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                amj.inJustDecodeBounds = false;
                ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                if (i == i3 && i2 == i4) {
                    b = com.tencent.mm.plugin.sns.d.a.b(str + str2, amj);
                } else {
                    int i5;
                    int ceil;
                    if ((((double) i2) * 1.0d) / ((double) i4) > (((double) i) * 1.0d) / ((double) i3)) {
                        i5 = i3;
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                    ab.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", Integer.valueOf(i5), Integer.valueOf(ceil));
                    amj.inSampleSize = 1;
                    if (i2 > ceil || i > i5) {
                        amj.inSampleSize = 1;
                        if (i2 > ceil || i > i5) {
                            double d = (((double) i2) * 1.0d) / ((double) ceil);
                            double d2 = (((double) i) * 1.0d) / ((double) i5);
                            if (d >= d2) {
                                d2 = d;
                            }
                            amj.inSampleSize = (int) d2;
                            if (amj.inSampleSize <= 1) {
                                amj.inSampleSize = 1;
                            }
                        }
                        while (((i2 * i) / amj.inSampleSize) / amj.inSampleSize > 2764800) {
                            amj.inSampleSize++;
                        }
                    }
                    ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", Integer.valueOf(amj.inSampleSize));
                    Bitmap b2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        b2 = com.tencent.mm.plugin.sns.d.a.b(str + str2, amj);
                        ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        b = b2;
                    } else {
                        float max = Math.max(((float) i5) / ((float) i), ((float) ceil) / ((float) i2));
                        int i6 = (int) (((float) i4) / max);
                        int min = Math.min(i, (int) (((float) i3) / max));
                        i6 = Math.min(i2, i6);
                        i5 = (i2 - i6) >> 1;
                        i3 = Math.max(0, (i - min) >> 1);
                        i5 = Math.max(0, i5);
                        Rect rect = new Rect();
                        rect.left = i3;
                        rect.right = i3 + min;
                        rect.top = i5;
                        rect.bottom = i5 + i6;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        b2 = l.Xf().a(str4, rect, amj);
                        if (b2 != null) {
                            b2 = i.s(str4, b2);
                        }
                        ab.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max));
                        b = b2;
                    }
                }
            } else {
                b = d.d(str + str2, (int) f, (int) f, true);
            }
            if (b == null) {
                ab.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                e.deleteFile(str + str2);
                AppMethodBeat.o(37999);
                return false;
            }
            ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            Object obj = 1;
            if (b.getHeight() > 120 || b.getWidth() > 120) {
                obj = null;
            }
            d.a(b, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            l.Xf().v(b);
            AppMethodBeat.o(37999);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    public static Bitmap Zk(String str) {
        int i = 640;
        AppMethodBeat.i(38000);
        Options amj = d.amj(str);
        int i2 = amj.outWidth >= amj.outHeight ? VideoFilterUtil.IMAGE_HEIGHT : 640;
        if (amj.outWidth < amj.outHeight) {
            i = VideoFilterUtil.IMAGE_HEIGHT;
        }
        Bitmap d = d.d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.o(38000);
            return null;
        }
        d = d.b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        AppMethodBeat.o(38000);
        return d;
    }
}
