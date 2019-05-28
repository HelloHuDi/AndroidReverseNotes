package com.tencent.p177mm.plugin.facedetectaction.p967b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.facedetectaction.b.b */
public class C39031b {
    public int mcm;
    public PoseDetectOnFrame mcn = null;
    C39030a mco;
    public int status = -1;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.b$a */
    public interface C39030a {
        /* renamed from: a */
        void mo35963a(byte[][] bArr, int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.b.b$1 */
    class C390321 implements PoseDetectOnFrame {
        C390321() {
        }

        public final void onSuccess(int i) {
            AppMethodBeat.m2504i(682);
            C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "detect action success: %s", Integer.valueOf(i));
            C39031b.this.status = 3;
            C7060h.pYm.mo8378a(917, 42, 1, false);
            if (C39031b.this.mco != null) {
                C39031b.this.mco;
            }
            AppMethodBeat.m2505o(682);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(683);
            C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "detect action failed, %s %s %s", Integer.valueOf(i), str, str2);
            C39031b.this.status = 4;
            C7060h.pYm.mo8378a(917, 43, 1, false);
            if (C39031b.this.mco != null) {
                C39031b.this.mco;
            }
            AppMethodBeat.m2505o(683);
        }

        public final void onRecordingDone(byte[][] bArr, int i, int i2) {
            AppMethodBeat.m2504i(684);
            if (bArr != null) {
                C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "notify start record, frameDatas.length: %s, width: %s, height: %s", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                C4990ab.m7412e("MicroMsg.FaceCheckActionEngine", "onRecordingDone, frameData is null!!");
            }
            C39031b.this.status = 5;
            if (C39031b.this.mco != null) {
                C39031b.this.mco.mo35963a(bArr, i, i2);
            }
            AppMethodBeat.m2505o(684);
        }
    }

    static {
        AppMethodBeat.m2504i(686);
        C1449k.m3079a("YTCommonEx", C39031b.class.getClassLoader());
        C1449k.m3079a("YTFaceTrace", C39031b.class.getClassLoader());
        C1449k.m3079a("YTNextCV", C39031b.class.getClassLoader());
        C1449k.m3079a("YTPoseDetect", C39031b.class.getClassLoader());
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        AppMethodBeat.m2505o(686);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final boolean mo61947f(MMActivity mMActivity) {
        byte[] bArr;
        byte[] bArr2;
        IOException e;
        int initModel;
        int i;
        AppMethodBeat.m2504i(685);
        C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
        try {
            InputStream open = C4996ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
            InputStream open2 = C4996ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
            bArr = new byte[open.available()];
            try {
                open.read(bArr);
                bArr2 = new byte[open2.available()];
                try {
                    open2.read(bArr2);
                    open.close();
                    open2.close();
                } catch (IOException e2) {
                    e = e2;
                    C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                    if (!FileOp.m64138ct(C43036p.bsR())) {
                    }
                    C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", C43036p.bsR());
                    initModel = YTPoseDetectInterface.initModel(C43036p.bsR());
                    C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
                    if (initModel == 0) {
                    }
                    if (i == 0) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bArr2 = null;
                C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                if (FileOp.m64138ct(C43036p.bsR())) {
                }
                C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", C43036p.bsR());
                initModel = YTPoseDetectInterface.initModel(C43036p.bsR());
                C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
                if (initModel == 0) {
                }
                if (i == 0) {
                }
            }
        } catch (IOException e4) {
            e = e4;
            bArr2 = null;
            bArr = null;
            C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
            if (FileOp.m64138ct(C43036p.bsR())) {
            }
            C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", C43036p.bsR());
            initModel = YTPoseDetectInterface.initModel(C43036p.bsR());
            C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
            if (initModel == 0) {
            }
            if (i == 0) {
            }
        }
        if (FileOp.m64138ct(C43036p.bsR())) {
            C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance copy post detect model file");
            C43036p.m76434p(C4996ah.getContext(), "face_detect" + File.separator + "PE.dat", C43036p.bsR());
        }
        C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", C43036p.bsR());
        initModel = YTPoseDetectInterface.initModel(C43036p.bsR());
        C4990ab.m7417i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
        if (initModel == 0) {
            C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel failed，return:".concat(String.valueOf(initModel)));
            i = 0;
        } else {
            i = YTFaceTraceInterface.initModel(bArr, bArr2);
            if (i != 0) {
                C4990ab.m7416i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(i)));
                i = 0;
            } else {
                i = 1;
            }
        }
        if (i == 0) {
            YTCommonExInterface.setAppBrightness(mMActivity, 255);
            this.status = 1;
            AppMethodBeat.m2505o(685);
            return true;
        }
        AppMethodBeat.m2505o(685);
        return false;
    }
}
