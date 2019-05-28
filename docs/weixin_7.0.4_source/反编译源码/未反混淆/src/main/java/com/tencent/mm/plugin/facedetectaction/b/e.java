package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.e.a.AnonymousClass4;
import com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class e {
    int mcA;
    a mcE;
    String mct;
    float mcu;
    int mcz;
    int orientation;

    public interface a {
        void Q(String str, String str2, String str3);

        void onError();
    }

    class b implements com.tencent.mm.i.g.a {
        private String fileName;
        private String mct;

        /* synthetic */ b(e eVar, String str, String str2, byte b) {
            this(str, str2);
        }

        private b(String str, String str2) {
            this.mct = str2;
            this.fileName = str;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(704);
            ab.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
            if (dVar == null || dVar.field_retCode != 0) {
                if (dVar != null) {
                    ab.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                    com.tencent.mm.a.e.deleteFile(this.fileName);
                    h.pYm.a(917, 51, 1, false);
                    if (e.this.mcE != null) {
                        e.this.mcE.onError();
                    }
                    AppMethodBeat.o(704);
                } else if (i != 0) {
                    ab.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
                    h.pYm.a(917, 51, 1, false);
                    com.tencent.mm.a.e.deleteFile(this.fileName);
                    if (e.this.mcE != null) {
                        e.this.mcE.onError();
                    }
                    AppMethodBeat.o(704);
                }
                return 0;
            }
            ab.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
            e eVar = e.this;
            String str2 = this.fileName;
            String str3 = dVar.field_fileId;
            String str4 = dVar.field_aesKey;
            if (eVar.mcE != null) {
                eVar.mcE.Q(str2, str3, str4);
            }
            AppMethodBeat.o(704);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hVj;
        final /* synthetic */ VideoTransPara mcF;
        final /* synthetic */ byte[][] mcG;

        AnonymousClass1(int i, VideoTransPara videoTransPara, byte[][] bArr) {
            this.hVj = i;
            this.mcF = videoTransPara;
            this.mcG = bArr;
        }

        public final void run() {
            AppMethodBeat.i(701);
            com.tencent.mm.plugin.facedetect.e.a btw = com.tencent.mm.plugin.facedetect.e.a.btw();
            btw.lYU.aa(new AnonymousClass4(this.hVj));
            btw = com.tencent.mm.plugin.facedetect.e.a.btw();
            btw.lYU.aa(new AnonymousClass5((float) this.mcF.fps));
            d.mcq.R(new AnonymousClass2(this.mcG));
            AppMethodBeat.o(701);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.e$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[][] mcG;

        AnonymousClass2(byte[][] bArr) {
            this.mcG = bArr;
        }

        public final void run() {
            AppMethodBeat.i(703);
            try {
                com.tencent.mm.plugin.facedetect.e.a.btw().EL();
                for (byte[] aU : this.mcG) {
                    com.tencent.mm.plugin.facedetect.e.a.btw().aU(aU);
                }
                com.tencent.mm.plugin.facedetect.e.a.btw().a(new com.tencent.mm.plugin.facedetect.e.a.b() {
                    public final void Lu(String str) {
                        AppMethodBeat.i(702);
                        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "onStop filePath: %s", str);
                        h.pYm.a(917, 46, 1, false);
                        e eVar = e.this;
                        try {
                            ab.i("MicroMsg.FaceCheckVideoRecordMgr", "encryptAndUploadVideoFile: %s", str);
                            if (!bo.isNullOrNil(str) && FileOp.ct(str)) {
                                ab.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", str, g.cz(str));
                                String str2 = str + "_encrypt";
                                ab.i("MicroMsg.FaceCheckVideoRecordMgr", "encrypt video file, personId: %s", eVar.mct);
                                e.R(eVar.mct, str, str2);
                                ab.i("MicroMsg.FaceCheckVideoRecordMgr", "%s MD5: %s", str2, g.cz(str2));
                                FileOp.deleteFile(str);
                                ab.i("MicroMsg.FaceCheckVideoRecordMgr", "doUploadVideoFile: %s", str2);
                                String str3 = eVar.mct;
                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                gVar.egl = new b(eVar, str2, str3, (byte) 0);
                                gVar.field_mediaId = p.Lt(str2);
                                gVar.field_fullpath = str2;
                                gVar.field_thumbpath = "";
                                gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
                                gVar.field_talker = "";
                                gVar.field_priority = com.tencent.mm.i.a.efC;
                                gVar.field_needStorage = false;
                                gVar.field_isStreamMedia = false;
                                gVar.field_appType = 0;
                                gVar.field_bzScene = 0;
                                gVar.field_largesvideo = 0;
                                if (!f.afx().e(gVar)) {
                                    ab.e("MicroMsg.FaceCheckVideoRecordMgr", "hy: video task info failed. clientid:%s", gVar.field_mediaId);
                                    com.tencent.mm.a.e.deleteFile(str2);
                                    if (eVar.mcE != null) {
                                        eVar.mcE.onError();
                                    }
                                }
                            }
                            AppMethodBeat.o(702);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", e, "encryptAndUploadVideoFile error", new Object[0]);
                            if (eVar.mcE != null) {
                                eVar.mcE.onError();
                            }
                            AppMethodBeat.o(702);
                        }
                    }
                });
                AppMethodBeat.o(703);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", e, "recordFrameImpl error", new Object[0]);
                if (e.this.mcE != null) {
                    e.this.mcE.onError();
                }
                AppMethodBeat.o(703);
            }
        }
    }

    public e(String str, float f, int i, int i2, int i3) {
        AppMethodBeat.i(705);
        this.mct = str;
        this.mcu = f;
        this.orientation = i;
        this.mcz = i2;
        this.mcA = i3;
        ab.i("MicroMsg.FaceCheckVideoRecordMgr", "create FaceCheckVideoRecordMgr, reductionRatio: %s, orientation: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(705);
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
    static void R(String str, String str2, String str3) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Exception e;
        CipherInputStream cipherInputStream;
        Throwable th;
        AppMethodBeat.i(706);
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
                        AppMethodBeat.o(706);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        if (cipherInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(706);
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
                    AppMethodBeat.o(706);
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
                    AppMethodBeat.o(706);
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
                    AppMethodBeat.o(706);
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
                            AppMethodBeat.o(706);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    AppMethodBeat.o(706);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                fileInputStream = null;
                cipherInputStream = null;
                AppMethodBeat.o(706);
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
                AppMethodBeat.o(706);
                throw th;
            }
        }
        AppMethodBeat.o(706);
    }
}
