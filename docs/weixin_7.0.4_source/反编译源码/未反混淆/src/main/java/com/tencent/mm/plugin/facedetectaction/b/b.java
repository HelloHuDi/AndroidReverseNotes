package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class b {
    public int mcm;
    public PoseDetectOnFrame mcn = null;
    a mco;
    public int status = -1;

    public interface a {
        void a(byte[][] bArr, int i, int i2);
    }

    static {
        AppMethodBeat.i(686);
        k.a("YTCommonEx", b.class.getClassLoader());
        k.a("YTFaceTrace", b.class.getClassLoader());
        k.a("YTNextCV", b.class.getClassLoader());
        k.a("YTPoseDetect", b.class.getClassLoader());
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        AppMethodBeat.o(686);
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
    public final boolean f(MMActivity mMActivity) {
        byte[] bArr;
        byte[] bArr2;
        IOException e;
        int initModel;
        int i;
        AppMethodBeat.i(685);
        ab.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
        try {
            InputStream open = ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
            InputStream open2 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
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
                    ab.i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                    if (!FileOp.ct(p.bsR())) {
                    }
                    ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", p.bsR());
                    initModel = YTPoseDetectInterface.initModel(p.bsR());
                    ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
                    if (initModel == 0) {
                    }
                    if (i == 0) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bArr2 = null;
                ab.i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
                if (FileOp.ct(p.bsR())) {
                }
                ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", p.bsR());
                initModel = YTPoseDetectInterface.initModel(p.bsR());
                ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
                if (initModel == 0) {
                }
                if (i == 0) {
                }
            }
        } catch (IOException e4) {
            e = e4;
            bArr2 = null;
            bArr = null;
            ab.i("MicroMsg.FaceCheckActionEngine", "load ufat.bin or ufdmtcc.bin failed" + e.getMessage());
            if (FileOp.ct(p.bsR())) {
            }
            ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", p.bsR());
            initModel = YTPoseDetectInterface.initModel(p.bsR());
            ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
            if (initModel == 0) {
            }
            if (i == 0) {
            }
        }
        if (FileOp.ct(p.bsR())) {
            ab.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance copy post detect model file");
            p.p(ah.getContext(), "face_detect" + File.separator + "PE.dat", p.bsR());
        }
        ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel FielPath: %s", p.bsR());
        initModel = YTPoseDetectInterface.initModel(p.bsR());
        ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", Integer.valueOf(initModel));
        if (initModel == 0) {
            ab.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel failed，return:".concat(String.valueOf(initModel)));
            i = 0;
        } else {
            i = YTFaceTraceInterface.initModel(bArr, bArr2);
            if (i != 0) {
                ab.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(i)));
                i = 0;
            } else {
                i = 1;
            }
        }
        if (i == 0) {
            YTCommonExInterface.setAppBrightness(mMActivity, 255);
            this.status = 1;
            AppMethodBeat.o(685);
            return true;
        }
        AppMethodBeat.o(685);
        return false;
    }
}
