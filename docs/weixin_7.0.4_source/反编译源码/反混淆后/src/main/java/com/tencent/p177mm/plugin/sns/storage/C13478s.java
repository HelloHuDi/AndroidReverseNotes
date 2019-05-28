package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.support.p056d.C0252a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.memory.C37899l;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.facedetect.FaceProNative;
import com.tencent.p177mm.plugin.p1614i.C43216a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C21881h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1297d.C21879a;
import com.tencent.p177mm.plugin.sns.p517i.C46213d;
import com.tencent.p177mm.protocal.protobuf.bar;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.sns.storage.s */
public final class C13478s extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int qDU = 0;
    private static int qDc = 0;
    private static Point qLw = new Point();
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(38001);
        AppMethodBeat.m2505o(38001);
    }

    public C13478s(C7480h c7480h) {
        this.fni = c7480h;
    }

    public static int getScreenWidth() {
        return qDU > qDc ? qDc : qDU;
    }

    /* renamed from: fs */
    public static void m21646fs(int i, int i2) {
        AppMethodBeat.m2504i(37978);
        qDU = i;
        qDc = i2;
        C4990ab.m7417i("MicroMsg.snsMediaStorage", "SCREEN %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(37978);
    }

    /* renamed from: Zh */
    private static String m21632Zh(String str) {
        AppMethodBeat.m2504i(37979);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(37979);
            return str2;
        }
        String x = C1178g.m2591x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = C13373af.getAccSnsPath() + str2 + str3;
        AppMethodBeat.m2505o(37979);
        return str2;
    }

    /* renamed from: a */
    private boolean m21637a(C29098r c29098r) {
        AppMethodBeat.m2504i(37980);
        C4990ab.m7410d("MicroMsg.snsMediaStorage", "snsMedia Insert");
        if (c29098r == null) {
            AppMethodBeat.m2505o(37980);
            return false;
        }
        if (((int) this.fni.insert("SnsMedia", "local_id", c29098r.cro())) != -1) {
            AppMethodBeat.m2505o(37980);
            return true;
        }
        AppMethodBeat.m2505o(37980);
        return false;
    }

    /* renamed from: a */
    public final boolean mo25633a(String str, C29098r c29098r) {
        AppMethodBeat.m2504i(37981);
        C4990ab.m7410d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10105a("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        boolean a2;
        if (a.moveToFirst()) {
            a.close();
            a2 = m21637a(c29098r);
            AppMethodBeat.m2505o(37981);
            return a2;
        }
        a.close();
        a2 = m21643b(str, c29098r);
        AppMethodBeat.m2505o(37981);
        return a2;
    }

    /* renamed from: b */
    private boolean m21643b(String str, C29098r c29098r) {
        AppMethodBeat.m2504i(37982);
        if (this.fni.update("SnsMedia", c29098r.cro(), "StrId=?", new String[]{String.valueOf(str)}) > 0) {
            AppMethodBeat.m2505o(37982);
            return true;
        }
        AppMethodBeat.m2505o(37982);
        return false;
    }

    /* renamed from: a */
    public final int mo25631a(int i, C29098r c29098r) {
        AppMethodBeat.m2504i(37983);
        int update = this.fni.update("SnsMedia", c29098r.cro(), "local_id=?", new String[]{String.valueOf(i)});
        AppMethodBeat.m2505o(37983);
        return update;
    }

    /* renamed from: Zi */
    public final C29098r mo25630Zi(String str) {
        AppMethodBeat.m2504i(37984);
        C29098r c29098r = new C29098r();
        Cursor a = this.fni.mo10105a("SnsMedia", null, "StrId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c29098r.mo47218d(a);
            a.close();
            AppMethodBeat.m2505o(37984);
            return c29098r;
        }
        a.close();
        AppMethodBeat.m2505o(37984);
        return null;
    }

    /* renamed from: kE */
    public final C29098r mo25635kE(long j) {
        AppMethodBeat.m2504i(37985);
        C29098r c29098r = new C29098r();
        Cursor a = this.fni.mo10105a("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c29098r.mo47218d(a);
            a.close();
            AppMethodBeat.m2505o(37985);
            return c29098r;
        }
        a.close();
        AppMethodBeat.m2505o(37985);
        return null;
    }

    /* renamed from: dn */
    public final List<C21881h> mo25634dn(List<C21881h> list) {
        AppMethodBeat.m2504i(37986);
        LinkedList linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(37986);
            return null;
        }
        for (C21881h c21881h : list) {
            int a = m21635a(c21881h);
            if (a == -1) {
                AppMethodBeat.m2505o(37986);
                return null;
            }
            C21881h c21881h2 = new C21881h(a, c21881h.type);
            c21881h2.height = c21881h.height;
            c21881h2.width = c21881h.width;
            c21881h2.fileSize = c21881h.fileSize;
            linkedList.add(c21881h2);
        }
        AppMethodBeat.m2505o(37986);
        return linkedList;
    }

    /* renamed from: a */
    private static C21881h m21636a(C21881h c21881h, String str) {
        int orientationInDegree;
        Throwable e;
        InputStream inputStream = null;
        int i = 0;
        AppMethodBeat.m2504i(37987);
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream = C5730e.openRead(str);
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
                C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "setImageExtInfo failed: ".concat(String.valueOf(str)), new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                c21881h.width = i;
                c21881h.height = orientationInDegree;
                c21881h.fileSize = (int) C5730e.asZ(str);
                AppMethodBeat.m2505o(37987);
                return c21881h;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(37987);
            }
        }
        c21881h.width = i;
        c21881h.height = orientationInDegree;
        c21881h.fileSize = (int) C5730e.asZ(str);
        AppMethodBeat.m2505o(37987);
        return c21881h;
    }

    /* renamed from: a */
    private int m21635a(C21881h c21881h) {
        AppMethodBeat.m2504i(37988);
        String accSnsPath = C13373af.getAccSnsPath();
        String accSnsTmpPath = C13373af.getAccSnsTmpPath();
        C4990ab.m7417i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", accSnsPath, accSnsTmpPath);
        long currentTimeMillis = System.currentTimeMillis();
        String str = c21881h.path;
        int i = c21881h.type;
        if (C5730e.m8628ct(str)) {
            String x = C1178g.m2591x((str + System.currentTimeMillis()).getBytes());
            String Xe = C29036i.m46082Xe(x);
            C4990ab.m7410d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str)));
            if (!C5730e.m8628ct(accSnsTmpPath)) {
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(accSnsTmpPath)));
                C5730e.m8643tf(accSnsTmpPath);
            }
            if (!C5730e.m8628ct(accSnsPath)) {
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(accSnsPath)));
                C5730e.m8643tf(accSnsPath);
            }
            C43216a c43216a = new C43216a();
            C21881h a = C13478s.m21636a(c21881h, str);
            int i2 = a.width;
            int i3 = a.height;
            int i4 = a.fileSize;
            c43216a.nuw = str;
            c43216a.nuy = i2;
            c43216a.nuz = i3;
            c43216a.nuA = i4;
            if (C13478s.m21645e(accSnsTmpPath, str, Xe, true)) {
                C4990ab.m7410d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
                C4990ab.m7410d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(Xe)));
                i2 = (int) C5730e.asZ(accSnsTmpPath + Xe);
                if (str.toLowerCase().contains("jpg") || str.toLowerCase().contains("jpeg")) {
                    accSnsPath = C5056d.m7653bR(C5730e.m8632e(str, 0, i2));
                    if (accSnsPath != null) {
                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", accSnsPath);
                        try {
                            ExifInterface exifInterface = new ExifInterface(accSnsTmpPath + Xe);
                            exifInterface.setAttribute(C0252a.TAG_USER_COMMENT, accSnsPath);
                            exifInterface.saveAttributes();
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
                        }
                    }
                }
                i2 = (int) C5730e.asZ(accSnsTmpPath + Xe);
                C21881h a2 = C13478s.m21636a(a, accSnsTmpPath + Xe);
                int i5 = a2.width;
                i3 = a2.height;
                c43216a.nuB = i5;
                c43216a.nuC = i3;
                c43216a.nuD = i2;
                C29098r c29098r = new C29098r();
                c29098r.rfE = x;
                c29098r.createTime = (long) ((int) C5046bo.anT());
                c29098r.type = i;
                bax bax = new bax();
                bax.wEJ = a2.qFY;
                bax.wFe = a2.qFX;
                bax.token = a2.qFZ;
                bax.wFn = a2.qGa;
                bax.wFB = 0;
                bax.wFA = new bar();
                bax.eRu = 0;
                bax.Desc = a2.desc;
                C4990ab.m7410d("MicroMsg.snsMediaStorage", "upload.filterId " + a2.filterId);
                bax.wFd = a2.filterId;
                bax.wFD = 2;
                bax.cvZ = C5730e.atg(accSnsTmpPath + Xe);
                try {
                    c29098r.rfI = bax.toByteArray();
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
                }
                c29098r.crp();
                c29098r.rfD = i2;
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + i2 + " filepath: " + accSnsTmpPath + Xe);
                i = (int) this.fni.insert("SnsMedia", "local_id", c29098r.cro());
                C4990ab.m7410d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
                String concat = "Locall_path".concat(String.valueOf(i));
                c43216a.nux = String.valueOf(i);
                c43216a.cvZ = bax.cvZ;
                Exif fromFile = Exif.fromFile(c43216a.nuw);
                i2 = C43216a.m76862tF(c43216a.nuw);
                if (c43216a.nuw.indexOf("png") >= 0) {
                    i2 = 1;
                } else if (c43216a.nuw.indexOf("jpg") >= 0 || c43216a.nuw.indexOf("jpeg") >= 0) {
                    i2 = 2;
                } else if (c43216a.nuw.indexOf("mp3") >= 0) {
                    i2 = 3;
                }
                str = fromFile.dateTimeOriginal;
                String str2 = c43216a.nuw;
                if (C5046bo.isNullOrNil(str)) {
                    str = C43216a.m76860OK(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new File(str2).lastModified())));
                } else {
                    str = C43216a.m76860OK(str);
                }
                C32831d c32831d = new C32831d();
                c32831d.mo53400l("20 localID", c43216a.nux + ",");
                c32831d.mo53400l("21 MediaType", i2 + ",");
                c32831d.mo53400l("22 OriginWidth", c43216a.nuy + ",");
                c32831d.mo53400l("23 OriginHeight", c43216a.nuz + ",");
                c32831d.mo53400l("24 CompressedWidth", c43216a.nuB + ",");
                c32831d.mo53400l("25 CompressedHeight", c43216a.nuC + ",");
                c32831d.mo53400l("26 OriginSize", c43216a.nuA + ",");
                c32831d.mo53400l("27 CompressedSize", c43216a.nuD + ",");
                c32831d.mo53400l("28 FNumber", fromFile.fNumber + ",");
                c32831d.mo53400l("29 ExposureTime", fromFile.exposureTime + ",");
                c32831d.mo53400l("30 ISO", fromFile.isoSpeedRatings + ",");
                c32831d.mo53400l("31 Flash", fromFile.flash + ",");
                c32831d.mo53400l("32 LensModel", C43216a.m76860OK(fromFile.model) + ",");
                c32831d.mo53400l("33 CreatTime", str + ",");
                c32831d.mo53400l("34 IsFromWeChat", "0,");
                c32831d.mo53400l("35 Scene", ",");
                c32831d.mo53400l("36 sceneType", fromFile.sceneType + ",");
                c32831d.mo53400l("37 fileSource", fromFile.fileSource + ",");
                c32831d.mo53400l("38 make", fromFile.make + ",");
                c32831d.mo53400l("39 software", fromFile.software + ",");
                c32831d.mo53400l("40 fileExt", C43216a.m76861cv(c43216a.nuw) + ",");
                c32831d.mo53400l("41 faceCount", "0,");
                c32831d.mo53400l("42 YCbCrSubSampling", fromFile.yCbCrSubSampling + ",");
                c32831d.mo53400l("43 md5", c43216a.cvZ + ',');
                C4990ab.m7419v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", c32831d.mo53398Fk(), c43216a.nuw);
                C7060h.pYm.mo8381e(14525, c32831d);
                C46213d.coE().qSY.put(Integer.valueOf(i), c32831d.toString());
                accSnsPath = C29036i.m46082Xe(concat);
                str = C13478s.m21632Zh(concat);
                C5730e.m8643tf(str);
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str)));
                C5730e.m8644y(accSnsTmpPath + Xe, str + accSnsPath);
                accSnsTmpPath = str + C29036i.m46078Xa(concat);
                x = str + C29036i.m46079Xb(concat);
                C5730e.deleteFile(accSnsTmpPath);
                C5730e.deleteFile(x);
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + str + accSnsPath + " totalLen:" + C5730e.asZ(str + accSnsPath) + "  now delete...:" + accSnsTmpPath + " & " + x);
                c29098r.rfE = concat;
                mo25631a(i, c29098r);
                AppMethodBeat.m2505o(37988);
                return i;
            }
            AppMethodBeat.m2505o(37988);
            return -1;
        }
        AppMethodBeat.m2505o(37988);
        return -1;
    }

    /* renamed from: a */
    public final C21881h mo25632a(C21881h c21881h, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(37989);
        C29098r c29098r = new C29098r();
        c29098r.createTime = (long) ((int) C5046bo.anT());
        c29098r.type = c21881h.type;
        bax bax = new bax();
        bax.wEJ = c21881h.qFY;
        bax.wFe = c21881h.qFX;
        bax.token = c21881h.qFZ;
        bax.wFn = c21881h.qGa;
        bax.wFB = 0;
        bax.wFA = new bar();
        bax.eRu = 0;
        bax.Desc = c21881h.desc;
        C4990ab.m7410d("MicroMsg.snsMediaStorage", "upload.filterId " + c21881h.filterId);
        bax.wFd = c21881h.filterId;
        bax.wFD = 2;
        bax.videoPath = str;
        bax.wFF = str2;
        bax.cvZ = c21881h.qGb;
        try {
            c29098r.rfI = bax.toByteArray();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        c29098r.crp();
        int insert = (int) this.fni.insert("SnsMedia", "local_id", c29098r.cro());
        String concat = "Locall_path".concat(String.valueOf(insert));
        C4990ab.m7410d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(insert)));
        String Xe = C29036i.m46082Xe(concat);
        String Xf = C29036i.m46083Xf(concat);
        String Xd = C29036i.m46081Xd(concat);
        String Xg = C29036i.m46084Xg(concat);
        String Zh = C13478s.m21632Zh(concat);
        C5730e.m8643tf(Zh);
        C5730e.m8644y(str2, Zh + Xe);
        C5730e.m8644y(str2, Zh + Xf);
        C5730e.m8644y(str2, Zh + Xd);
        C5730e.m8644y(str, Zh + Xg);
        bax.videoPath = Zh + Xg;
        bax.wFF = Zh + Xf;
        bax.cvZ = c21881h.qGb;
        try {
            c29098r.rfI = bax.toByteArray();
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        c29098r.rfE = concat;
        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            bar bar = new bar();
            bar.jCt = 1;
            bar.Url = str3;
            bax.wFA = bar;
            bax.wFD = 0;
            C37461f.afy();
            bax.wFc = C8941a.m16130rJ(str);
            if (!C5046bo.isNullOrNil(str4)) {
                bar = new bar();
                bar.jCt = 1;
                bar.Url = str4;
                bax.wFC.add(bar);
            }
            try {
                c29098r.rfI = bax.toByteArray();
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
            }
            c29098r.crq();
        }
        mo25631a(insert, c29098r);
        C21881h a = C13478s.m21636a(c21881h, bax.wFF);
        a.cNE = insert;
        AppMethodBeat.m2505o(37989);
        return a;
    }

    public static boolean crr() {
        AppMethodBeat.m2504i(37990);
        if ("hevc".equals(C1947ae.gjm)) {
            AppMethodBeat.m2505o(37990);
            return true;
        }
        boolean cnP = C13373af.cnP();
        AppMethodBeat.m2505o(37990);
        return cnP;
    }

    public static boolean crs() {
        AppMethodBeat.m2504i(37991);
        if ("wxpc".equals(C1947ae.gjm)) {
            AppMethodBeat.m2505o(37991);
            return true;
        }
        boolean cnQ = C13373af.cnQ();
        AppMethodBeat.m2505o(37991);
        return cnQ;
    }

    /* renamed from: aj */
    public static boolean m21642aj(String str, String str2, String str3) {
        AppMethodBeat.m2504i(139041);
        boolean e = C13478s.m21645e(str, str2, str3, true);
        AppMethodBeat.m2505o(139041);
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
    /* renamed from: e */
    public static boolean m21645e(String str, String str2, String str3, boolean z) {
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
        AppMethodBeat.m2504i(37993);
        Options amj = C5056d.amj(str2);
        if (amj != null) {
            String str4 = amj.outMimeType;
            C4990ab.m7410d("MicroMsg.snsMediaStorage", "mimetype: ".concat(String.valueOf(str4)));
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
                                C37461f.afx();
                                if (C31259b.m50439lg(64) || C13478s.crr() || C13478s.crs()) {
                                    if (C5023at.isWifi(C4996ah.getContext())) {
                                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelForWifi"), 70);
                                    } else if (C5023at.is2G(C4996ah.getContext())) {
                                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor2G"), 70);
                                    } else if (C5023at.is3G(C4996ah.getContext())) {
                                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor3G"), 60);
                                    } else {
                                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor4G"), 60);
                                    }
                                } else if (C5023at.isWifi(C4996ah.getContext())) {
                                    i3 = Integer.valueOf(C26373g.m41964Nu().getValue("SnsCompressPicLevelForWifi")).intValue();
                                } else if (C5023at.is2G(C4996ah.getContext())) {
                                    i3 = Integer.valueOf(C26373g.m41964Nu().getValue("SnsCompressPicLevelFor2G")).intValue();
                                } else {
                                    i3 = Integer.valueOf(C26373g.m41964Nu().getValue("SnsCompressPicLevelFor3G")).intValue();
                                }
                                try {
                                    C4990ab.m7411d("MicroMsg.snsMediaStorage", "createPic comLev---webpWifi:%s, webp2G:%s, webp3G:%s,webp4G:%s   wifi:%s, 2G:%s, 3G:%s", C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelForWifi"), C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor2G"), C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor3G"), C26373g.m41964Nu().getValue("SnsWebpCompressPicLevelFor4G"), C26373g.m41964Nu().getValue("SnsCompressPicLevelForWifi"), C26373g.m41964Nu().getValue("SnsCompressPicLevelFor2G"), C26373g.m41964Nu().getValue("SnsCompressPicLevelFor3G"));
                                } catch (Exception e) {
                                }
                            } catch (Exception e2) {
                                i3 = 100;
                            }
                            C4990ab.m7417i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", Integer.valueOf(i3), Boolean.valueOf(z));
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
                        asZ = (int) C5730e.asZ(str2);
                        i4 = 0;
                        i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
                        if (detectFaceCnt >= 5) {
                            i4 = 0;
                            i3 = 1440;
                        }
                        String value;
                        if (detectFaceCnt >= 5) {
                            try {
                                value = C26373g.m41964Nu().getValue("SnsCompressResolutionForMultiHead");
                                i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                            } catch (Exception e3) {
                            }
                        } else if (C5023at.isWifi(C4996ah.getContext())) {
                            value = C26373g.m41964Nu().getValue("SnsCompressResolutionForWifi");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (C5023at.is2G(C4996ah.getContext())) {
                            value = C26373g.m41964Nu().getValue("SnsCompressResolutionFor2G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (C5023at.is3G(C4996ah.getContext())) {
                            value = C26373g.m41964Nu().getValue("SnsCompressResolutionFor3G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = C26373g.m41964Nu().getValue("SnsCompressResolutionFor4G");
                            i4 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
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
                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                        if (i3 <= 0) {
                            i3 = 100;
                        }
                        detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                        if (i3 <= 0) {
                            i3 = 200;
                        }
                        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
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
                                C4990ab.m7412e("MicroMsg.snsMediaStorage", "get degree error " + e4.getMessage());
                            }
                            C4990ab.m7416i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                            C5046bo.getInt(C26373g.m41964Nu().getValue("CompressLongImageRatio"), 10);
                            boolean a;
                            if (amj.outWidth < amj.outHeight * 2 || amj.outHeight >= amj.outWidth * 2) {
                                if (amj.outWidth * amj.outHeight <= 10240000) {
                                    C4990ab.m7416i("MicroMsg.snsMediaStorage", "too max pic " + amj.outWidth + " " + amj.outHeight);
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
                                    C4990ab.m7416i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i + " " + i3);
                                    a = C13478s.m21640a(str2, i, i4, CompressFormat.JPEG, i2, str, str3, z);
                                    AppMethodBeat.m2505o(37993);
                                    return a;
                                } else if (asZ < i6 && z2 && i8 == 0) {
                                    C4990ab.m7416i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong ".concat(String.valueOf(i6)));
                                    if (C5730e.m8644y(str2, str + str3) >= 0) {
                                        AppMethodBeat.m2505o(37993);
                                        return true;
                                    }
                                    AppMethodBeat.m2505o(37993);
                                    return false;
                                } else {
                                    Options options = new Options();
                                    C5056d.dnX();
                                    InputStream inputStream = null;
                                    try {
                                        inputStream = C5730e.openRead(str2);
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
                                            AppMethodBeat.m2505o(37993);
                                            return false;
                                        }
                                        C5056d.m7625a(C5056d.m7648b(decodeStream, (float) i8), i2, CompressFormat.JPEG, str + str3, true);
                                        if (z2 && i8 == 0) {
                                            C4990ab.m7417i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(C5730e.asZ(str + str3)), Integer.valueOf(i7));
                                            if ((((long) asZ) - C5730e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                                C5730e.deleteFile(str + str3);
                                                a = C5730e.m8644y(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e6) {
                                                    }
                                                }
                                                AppMethodBeat.m2505o(37993);
                                                return a;
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e7) {
                                                }
                                            }
                                            AppMethodBeat.m2505o(37993);
                                            return true;
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e8) {
                                            }
                                        }
                                        AppMethodBeat.m2505o(37993);
                                        return true;
                                    } catch (IOException e9) {
                                        C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e9, "Decode bitmap failed: ".concat(String.valueOf(str2)), new Object[0]);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e10) {
                                            }
                                        }
                                        AppMethodBeat.m2505o(37993);
                                        return false;
                                    } catch (Throwable th) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e11) {
                                            }
                                        }
                                        AppMethodBeat.m2505o(37993);
                                    }
                                }
                            } else if (asZ < detectFaceCnt && z2 && i8 == 0) {
                                C4990ab.m7416i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal ".concat(String.valueOf(detectFaceCnt)));
                                if (C5730e.m8644y(str2, str + str3) >= 0) {
                                    AppMethodBeat.m2505o(37993);
                                    return true;
                                }
                                AppMethodBeat.m2505o(37993);
                                return false;
                            } else {
                                i3 = amj.outWidth > amj.outHeight ? amj.outWidth : amj.outHeight;
                                i = amj.outWidth < amj.outHeight ? amj.outWidth : amj.outHeight;
                                if ((i5 <= 0 || i > i5) && (i5 > 0 || i3 > i4)) {
                                    if (i5 > 0) {
                                        a = C13478s.m21639a(str2, amj.outWidth, amj.outHeight, i5, CompressFormat.JPEG, i2, str, str3);
                                    } else {
                                        double d = (((double) i3) * 1.0d) / ((double) i4);
                                        a = C13478s.m21640a(str2, (int) (((double) amj.outHeight) / d), (int) (((double) amj.outWidth) / d), CompressFormat.JPEG, i2, str, str3, z);
                                    }
                                    if (z2 && i8 == 0) {
                                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(C5730e.asZ(str + str3)), Integer.valueOf(i7));
                                        if ((((long) asZ) - C5730e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                            C5730e.deleteFile(str + str3);
                                            if (C5730e.m8644y(str2, str + str3) >= 0) {
                                                AppMethodBeat.m2505o(37993);
                                                return true;
                                            }
                                            AppMethodBeat.m2505o(37993);
                                            return false;
                                        }
                                    }
                                    AppMethodBeat.m2505o(37993);
                                    return a;
                                }
                                C4990ab.m7417i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", Integer.valueOf(asZ), Integer.valueOf(amj.outWidth), Integer.valueOf(amj.outHeight));
                                if (C5730e.asZ(str2) < 71680) {
                                    if (z2) {
                                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", str2);
                                        if (C5730e.m8644y(str2, str + str3) >= 0) {
                                            AppMethodBeat.m2505o(37993);
                                            return true;
                                        }
                                        AppMethodBeat.m2505o(37993);
                                        return false;
                                    } else if (amj.outWidth < 150 && amj.outHeight < 150) {
                                        a = C13478s.m21640a(str2, amj.outHeight, amj.outWidth, CompressFormat.PNG, i2, str, str3, z);
                                        AppMethodBeat.m2505o(37993);
                                        return a;
                                    }
                                }
                                a = C13478s.m21640a(str2, amj.outHeight, amj.outWidth, CompressFormat.JPEG, i2, str, str3, z);
                                if (z2 && i8 == 0) {
                                    C4990ab.m7417i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", Integer.valueOf(asZ), Long.valueOf(C5730e.asZ(str + str3)), Integer.valueOf(i7));
                                    if ((((long) asZ) - C5730e.asZ(str + str3)) * 100 < ((long) (i7 * asZ))) {
                                        C5730e.deleteFile(str + str3);
                                        if (C5730e.m8644y(str2, str + str3) >= 0) {
                                            AppMethodBeat.m2505o(37993);
                                            return true;
                                        }
                                        AppMethodBeat.m2505o(37993);
                                        return false;
                                    }
                                    AppMethodBeat.m2505o(37993);
                                    return a;
                                }
                                AppMethodBeat.m2505o(37993);
                                return a;
                            }
                        }
                        i8 = 0;
                        C4990ab.m7416i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                        C5046bo.getInt(C26373g.m41964Nu().getValue("CompressLongImageRatio"), 10);
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
                asZ = (int) C5730e.asZ(str2);
                i4 = 0;
                i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                detectFaceCnt = FaceProNative.detectFaceCnt(str2);
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
                if (detectFaceCnt >= 5) {
                }
                if (detectFaceCnt >= 5) {
                }
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
                if (i4 > 0) {
                }
                if (i3 >= 2160) {
                }
                i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i3 <= 0) {
                }
                detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i3 <= 0) {
                }
                i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i3 > 0) {
                }
                i7 = 10;
                i3 = 0;
                if (obj2 != null) {
                }
                i8 = 0;
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
                C5046bo.getInt(C26373g.m41964Nu().getValue("CompressLongImageRatio"), 10);
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
        asZ = (int) C5730e.asZ(str2);
        i4 = 0;
        i3 = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        detectFaceCnt = FaceProNative.detectFaceCnt(str2);
        C4990ab.m7417i("MicroMsg.snsMediaStorage", "FaceCnt:%d", Integer.valueOf(detectFaceCnt));
        if (detectFaceCnt >= 5) {
        }
        if (detectFaceCnt >= 5) {
        }
        C4990ab.m7417i("MicroMsg.snsMediaStorage", "server target conf_long config_short %d %d screen %d %d comLev: %d isUpload%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(qDc), Integer.valueOf(qDU), Integer.valueOf(i2), Boolean.valueOf(z));
        if (i4 > 0) {
        }
        if (i3 >= 2160) {
        }
        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i3 <= 0) {
        }
        detectFaceCnt = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
        if (i3 <= 0) {
        }
        i6 = i3 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i3 = C5046bo.getInt(C26373g.m41964Nu().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i3 > 0) {
        }
        i7 = 10;
        i3 = 0;
        if (obj2 != null) {
        }
        i8 = 0;
        C4990ab.m7416i("MicroMsg.snsMediaStorage", "option info " + amj.outWidth + " " + amj.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i8 + " filelen " + asZ + " target " + i4 + " " + i5);
        C5046bo.getInt(C26373g.m41964Nu().getValue("CompressLongImageRatio"), 10);
        if (amj.outWidth < amj.outHeight * 2) {
        }
        if (amj.outWidth * amj.outHeight <= 10240000) {
        }
    }

    /* renamed from: a */
    private static boolean m21640a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(37994);
        Options amj = C5056d.amj(str);
        if (amj == null || amj.outWidth <= 0 || amj.outHeight <= 0) {
            AppMethodBeat.m2505o(37994);
            return false;
        }
        boolean a = C13478s.m21638a(str, amj.outWidth, amj.outHeight, i, i2, compressFormat, i3, str2, str3, z);
        AppMethodBeat.m2505o(37994);
        return a;
    }

    /* renamed from: a */
    private static boolean m21639a(String str, int i, int i2, int i3, CompressFormat compressFormat, int i4, String str2, String str3) {
        AppMethodBeat.m2504i(37995);
        OutputStream outputStream = null;
        try {
            Bitmap b;
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            Options options = new Options();
            int i5 = i2 > i ? i : i2;
            if (i5 == i3) {
                b = C21879a.m33431b(str, options);
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
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b = C21879a.m33431b(str, options);
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", b);
            if (b == null) {
                AppMethodBeat.m2505o(37995);
                return false;
            }
            int i6;
            int i7;
            int i8 = (i * i3) / i5;
            int i9 = (i2 * i3) / i5;
            int bJ = ExifHelper.m7368bJ(str);
            if (bJ == 90 || bJ == 270) {
                i6 = i9;
                i7 = i8;
            } else {
                i6 = i8;
                i7 = i9;
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(bJ));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, i7, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                C37899l.m63997Xf().mo60652v(b);
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4));
            outputStream = C5730e.m8617L(str2 + str3, false);
            C5056d.m7624a(createScaledBitmap, i4, compressFormat, outputStream, false);
            C37899l.m63997Xf().mo60652v(createScaledBitmap);
            outputStream.close();
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", str2 + str3, Long.valueOf(C5730e.asZ(str2 + str3)));
            AppMethodBeat.m2505o(37995);
            return true;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", str3);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(37995);
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
    /* renamed from: Zj */
    public static boolean m21633Zj(String str) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(37996);
        InputStream inputStream2;
        try {
            inputStream = C5730e.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            String str2 = options.outMimeType;
            C4990ab.m7410d("MicroMsg.snsMediaStorage", "mineType ".concat(String.valueOf(str2)));
            if (str2.toLowerCase().indexOf("webp") >= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(37996);
                return true;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(37996);
            return false;
            AppMethodBeat.m2505o(37996);
            return false;
            AppMethodBeat.m2505o(37996);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.m2505o(37996);
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
    /* renamed from: a */
    public static boolean m21641a(String str, String str2, String str3, float f) {
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
        AppMethodBeat.m2504i(37997);
        double d4 = 0.0d;
        Object obj = 1;
        InputStream inputStream2 = null;
        try {
            Options options;
            inputStream2 = C5730e.openRead(str + str2);
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
                a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.m2505o(37997);
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
                a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.m2505o(37997);
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
                    a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                    AppMethodBeat.m2505o(37997);
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
                a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.m2505o(37997);
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
                        a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                        AppMethodBeat.m2505o(37997);
                        return a;
                    }
                    str4 = str + str2;
                    i = (int) d;
                    i2 = (int) d4;
                    i3 = (int) d2;
                    i4 = (int) d3;
                    if (obj != null) {
                    }
                    a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                    AppMethodBeat.m2505o(37997);
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
                a = C13478s.m21638a(str4, i, i2, i3, i4, compressFormat, 70, str, str3, false);
                AppMethodBeat.m2505o(37997);
                return a;
            }
        } catch (Exception e5) {
            inputStream = inputStream2;
            d = 0.0d;
        }
    }

    /* renamed from: a */
    private static boolean m21638a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(37998);
        OutputStream outputStream = null;
        try {
            Bitmap b;
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
            Options options = new Options();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = C21879a.m33431b(str, options);
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
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b = C21879a.m33431b(str, options);
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", b);
            if (b == null) {
                AppMethodBeat.m2505o(37998);
                return false;
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
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
                int bJ = ExifHelper.m7368bJ(str);
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
                        C37899l.m63997Xf().mo60652v(b);
                    }
                    b = createScaledBitmap;
                }
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            }
            outputStream = C5730e.m8617L(str2 + str3, false);
            C5056d.m7624a(b, i5, compressFormat, outputStream, false);
            C37899l.m63997Xf().mo60652v(b);
            outputStream.close();
            AppMethodBeat.m2505o(37998);
            return true;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", str3);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(37998);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m21644b(String str, String str2, String str3, float f) {
        AppMethodBeat.m2504i(37999);
        try {
            C5730e.deleteFile(str + str3);
            Options amj = C5056d.amj(str + str2);
            if (amj == null) {
                C4990ab.m7412e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                AppMethodBeat.m2505o(37999);
                return false;
            }
            Bitmap b;
            if (amj.outMimeType == null || !(amj.outMimeType.toLowerCase().endsWith("png") || amj.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = amj.outWidth;
                int i2 = amj.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                amj.inJustDecodeBounds = false;
                C4990ab.m7417i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                if (i == i3 && i2 == i4) {
                    b = C21879a.m33431b(str + str2, amj);
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
                    C4990ab.m7411d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", Integer.valueOf(i5), Integer.valueOf(ceil));
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
                    C4990ab.m7417i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", Integer.valueOf(amj.inSampleSize));
                    Bitmap b2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        b2 = C21879a.m33431b(str + str2, amj);
                        C4990ab.m7416i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
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
                        b2 = C37899l.m63997Xf().mo60651a(str4, rect, amj);
                        if (b2 != null) {
                            b2 = C29036i.m46128s(str4, b2);
                        }
                        C4990ab.m7411d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        C4990ab.m7417i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max));
                        b = b2;
                    }
                }
            } else {
                b = C5056d.m7659d(str + str2, (int) f, (int) f, true);
            }
            if (b == null) {
                C4990ab.m7416i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                C5730e.deleteFile(str + str2);
                AppMethodBeat.m2505o(37999);
                return false;
            }
            C4990ab.m7417i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()));
            Object obj = 1;
            if (b.getHeight() > 120 || b.getWidth() > 120) {
                obj = null;
            }
            C5056d.m7625a(b, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            C37899l.m63997Xf().mo60652v(b);
            AppMethodBeat.m2505o(37999);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    /* renamed from: Zk */
    public static Bitmap m21634Zk(String str) {
        int i = 640;
        AppMethodBeat.m2504i(38000);
        Options amj = C5056d.amj(str);
        int i2 = amj.outWidth >= amj.outHeight ? VideoFilterUtil.IMAGE_HEIGHT : 640;
        if (amj.outWidth < amj.outHeight) {
            i = VideoFilterUtil.IMAGE_HEIGHT;
        }
        Bitmap d = C5056d.m7659d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.m2505o(38000);
            return null;
        }
        d = C5056d.m7648b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        AppMethodBeat.m2505o(38000);
        return d;
    }
}
