package com.tencent.p177mm.plugin.facedetectaction.p967b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C279254;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C279285;
import com.tencent.p177mm.plugin.facedetect.p402e.C27922a.C27929b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.plugin.facedetectaction.b.e */
public final class C27945e {
    int mcA;
    C11823a mcE;
    String mct;
    float mcu;
    int mcz;
    int orientation;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$a */
    public interface C11823a {
        /* renamed from: Q */
        void mo23633Q(String str, String str2, String str3);

        void onError();
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$b */
    class C27944b implements C1628a {
        private String fileName;
        private String mct;

        /* synthetic */ C27944b(C27945e c27945e, String str, String str2, byte b) {
            this(str, str2);
        }

        private C27944b(String str, String str2) {
            this.mct = str2;
            this.fileName = str;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(704);
            C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
            if (c9545d == null || c9545d.field_retCode != 0) {
                if (c9545d != null) {
                    C4990ab.m7421w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                    C1173e.deleteFile(this.fileName);
                    C7060h.pYm.mo8378a(917, 51, 1, false);
                    if (C27945e.this.mcE != null) {
                        C27945e.this.mcE.onError();
                    }
                    AppMethodBeat.m2505o(704);
                } else if (i != 0) {
                    C4990ab.m7421w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), c18496c, c9545d);
                    C7060h.pYm.mo8378a(917, 51, 1, false);
                    C1173e.deleteFile(this.fileName);
                    if (C27945e.this.mcE != null) {
                        C27945e.this.mcE.onError();
                    }
                    AppMethodBeat.m2505o(704);
                }
                return 0;
            }
            C4990ab.m7416i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
            C27945e c27945e = C27945e.this;
            String str2 = this.fileName;
            String str3 = c9545d.field_fileId;
            String str4 = c9545d.field_aesKey;
            if (c27945e.mcE != null) {
                c27945e.mcE.mo23633Q(str2, str3, str4);
            }
            AppMethodBeat.m2505o(704);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$1 */
    class C279461 implements Runnable {
        final /* synthetic */ int hVj;
        final /* synthetic */ VideoTransPara mcF;
        final /* synthetic */ byte[][] mcG;

        C279461(int i, VideoTransPara videoTransPara, byte[][] bArr) {
            this.hVj = i;
            this.mcF = videoTransPara;
            this.mcG = bArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(701);
            C27922a btw = C27922a.btw();
            btw.lYU.mo10302aa(new C279254(this.hVj));
            btw = C27922a.btw();
            btw.lYU.mo10302aa(new C279285((float) this.mcF.fps));
            C43048d.mcq.mo68575R(new C279472(this.mcG));
            AppMethodBeat.m2505o(701);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$2 */
    class C279472 implements Runnable {
        final /* synthetic */ byte[][] mcG;

        /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$2$1 */
        class C206671 implements C27929b {
            C206671() {
            }

            /* renamed from: Lu */
            public final void mo23665Lu(String str) {
                AppMethodBeat.m2504i(702);
                C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", str);
                C7060h.pYm.mo8378a(917, 46, 1, false);
                C27945e c27945e = C27945e.this;
                try {
                    C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", str);
                    if (!C5046bo.isNullOrNil(str) && FileOp.m64138ct(str)) {
                        C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", str, C1178g.m2587cz(str));
                        String str2 = str + "_encrypt";
                        C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", c27945e.mct);
                        C27945e.m44499R(c27945e.mct, str, str2);
                        C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", str2, C1178g.m2587cz(str2));
                        FileOp.deleteFile(str);
                        C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", str2);
                        String str3 = c27945e.mct;
                        C42130g c42130g = new C42130g();
                        c42130g.egl = new C27944b(c27945e, str2, str3, (byte) 0);
                        c42130g.field_mediaId = C43036p.m76427Lt(str2);
                        c42130g.field_fullpath = str2;
                        c42130g.field_thumbpath = "";
                        c42130g.field_fileType = C42129a.MediaType_FILE;
                        c42130g.field_talker = "";
                        c42130g.field_priority = C42129a.efC;
                        c42130g.field_needStorage = false;
                        c42130g.field_isStreamMedia = false;
                        c42130g.field_appType = 0;
                        c42130g.field_bzScene = 0;
                        c42130g.field_largesvideo = 0;
                        if (!C37461f.afx().mo51225e(c42130g)) {
                            C4990ab.m7413e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", c42130g.field_mediaId);
                            C1173e.deleteFile(str2);
                            if (c27945e.mcE != null) {
                                c27945e.mcE.onError();
                            }
                        }
                    }
                    AppMethodBeat.m2505o(702);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", e, "encryptAndUploadVideoFile error", new Object[0]);
                    if (c27945e.mcE != null) {
                        c27945e.mcE.onError();
                    }
                    AppMethodBeat.m2505o(702);
                }
            }
        }

        C279472(byte[][] bArr) {
            this.mcG = bArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(703);
            try {
                C27922a.btw().mo45816EL();
                for (byte[] aU : this.mcG) {
                    C27922a.btw().mo45819aU(aU);
                }
                C27922a.btw().mo45817a(new C206671());
                AppMethodBeat.m2505o(703);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", e, "recordFrameImpl error", new Object[0]);
                if (C27945e.this.mcE != null) {
                    C27945e.this.mcE.onError();
                }
                AppMethodBeat.m2505o(703);
            }
        }
    }

    public C27945e(String str, float f, int i, int i2, int i3) {
        AppMethodBeat.m2504i(705);
        this.mct = str;
        this.mcu = f;
        this.orientation = i;
        this.mcz = i2;
        this.mcA = i3;
        C4990ab.m7417i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(705);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: R */
    static void m44499R(String str, String str2, String str3) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Exception e;
        CipherInputStream cipherInputStream;
        Throwable th;
        AppMethodBeat.m2504i(706);
        File file = new File(str2);
        File file2 = new File(str3);
        if (file.exists() && file.isFile()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            file2.createNewFile();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    cipherInputStream = null;
                    try {
                        AppMethodBeat.m2505o(706);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        if (cipherInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(706);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    cipherInputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (cipherInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(706);
                    throw th;
                }
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(new SecretKeySpec(str.getBytes("UTF-8"), "AES").getEncoded(), "AES");
                    Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
                    cipherInputStream = new CipherInputStream(fileInputStream, instance);
                } catch (Exception e3) {
                    e = e3;
                    cipherInputStream = null;
                    AppMethodBeat.m2505o(706);
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    cipherInputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (cipherInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(706);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = cipherInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        } else {
                            fileOutputStream.close();
                            cipherInputStream.close();
                            fileInputStream.close();
                            AppMethodBeat.m2505o(706);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    AppMethodBeat.m2505o(706);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                fileInputStream = null;
                cipherInputStream = null;
                AppMethodBeat.m2505o(706);
                throw e;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                fileInputStream = null;
                cipherInputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (cipherInputStream != null) {
                    cipherInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(706);
                throw th;
            }
        }
        AppMethodBeat.m2505o(706);
    }
}
