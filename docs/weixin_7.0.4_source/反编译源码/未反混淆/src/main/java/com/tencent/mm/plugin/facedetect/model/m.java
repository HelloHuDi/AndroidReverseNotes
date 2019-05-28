package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends c<bf> {
    public m() {
        AppMethodBeat.i(250);
        this.xxI = bf.class.getName().hashCode();
        AppMethodBeat.o(250);
    }

    /* JADX WARNING: Missing block: B:5:0x004d, code skipped:
            r0 = 0;
     */
    /* JADX WARNING: Missing block: B:6:0x004e, code skipped:
            if (r0 != 0) goto L_0x00b2;
     */
    /* JADX WARNING: Missing block: B:7:0x0050, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FaceModuleResUpdateListener", "hy: get lower version");
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(r10.cus.cut, r10.cus.cuu, r10.cus.cuv);
     */
    /* JADX WARNING: Missing block: B:11:0x0080, code skipped:
            if (r4 <= r0) goto L_0x004d;
     */
    /* JADX WARNING: Missing block: B:12:0x0082, code skipped:
            switch(r3) {
                case 0: goto L_0x0098;
                case 1: goto L_0x00a5;
                default: goto L_0x0085;
            };
     */
    /* JADX WARNING: Missing block: B:13:0x0085, code skipped:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:15:0x0098, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", java.lang.String.valueOf(r4));
     */
    /* JADX WARNING: Missing block: B:16:0x00a5, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", java.lang.String.valueOf(r4));
     */
    /* JADX WARNING: Missing block: B:18:0x00b6, code skipped:
            if (r10.cus.cuu != 0) goto L_0x00f6;
     */
    /* JADX WARNING: Missing block: B:19:0x00b8, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", r10.cus.filePath);
     */
    /* JADX WARNING: Missing block: B:21:0x00cc, code skipped:
            if (com.tencent.mm.plugin.facedetect.model.p.vn(r10.cus.cuu) != false) goto L_0x013d;
     */
    /* JADX WARNING: Missing block: B:22:0x00ce, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FaceModuleResUpdateListener", "hy: copy failed. reset version code and path");
     */
    /* JADX WARNING: Missing block: B:23:0x00db, code skipped:
            if (r10.cus.cuu != 0) goto L_0x0113;
     */
    /* JADX WARNING: Missing block: B:24:0x00dd, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", r10.cus.filePath);
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
     */
    /* JADX WARNING: Missing block: B:26:0x00fa, code skipped:
            if (r10.cus.cuu != 1) goto L_0x0109;
     */
    /* JADX WARNING: Missing block: B:27:0x00fc, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", r10.cus.filePath);
     */
    /* JADX WARNING: Missing block: B:28:0x0109, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FaceModuleResUpdateListener", "hy: invalid subtype");
     */
    /* JADX WARNING: Missing block: B:30:0x0117, code skipped:
            if (r10.cus.cuu != 1) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:31:0x0119, code skipped:
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", r10.cus.filePath);
            com.tencent.mm.model.av.fly.ak("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
     */
    /* JADX WARNING: Missing block: B:32:0x0132, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FaceModuleResUpdateListener", "hy: invalid subtype");
     */
    /* JADX WARNING: Missing block: B:33:0x013d, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FaceModuleResUpdateListener", "hy: load success. mark as not retry");
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.as(r10.cus.cut, r10.cus.cuu, r10.cus.cuv);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(251);
        bf bfVar = (bf) bVar;
        if (bfVar.cus.cut == 42) {
            ab.i("MicroMsg.FaceModuleResUpdateListener", "hy: new face file update coming. subtype: %d, file path: %s, file version: %d", Integer.valueOf(bfVar.cus.cuu), bfVar.cus.filePath, Integer.valueOf(bfVar.cus.cuv));
            int i = bfVar.cus.cuu;
            int i2 = bfVar.cus.cuv;
            int i3;
            switch (i) {
                case 0:
                    i3 = bo.getInt(av.fly.T("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1"), -1);
                    break;
                case 1:
                    i3 = bo.getInt(av.fly.T("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1"), -1);
                    break;
                default:
                    ab.e("MicroMsg.FaceModuleResUpdateListener", "hy: error subtype");
                    break;
            }
        }
        AppMethodBeat.o(251);
        return false;
    }
}
