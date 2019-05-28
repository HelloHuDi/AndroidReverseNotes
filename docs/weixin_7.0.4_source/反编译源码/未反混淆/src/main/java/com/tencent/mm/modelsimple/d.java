package com.tencent.mm.modelsimple;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class d extends m implements k {
    private f ehi;
    private b fAT;
    private List<String> fOr;
    private String fOs;
    private int type;

    public d(int i, List<String> list, String str) {
        this.type = i;
        this.fOr = list;
        this.fOs = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4 A:{SYNTHETIC, Splitter:B:18:0x00a4} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1 A:{SYNTHETIC, Splitter:B:25:0x00c1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ah(List<String> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(16559);
        rs rsVar = (rs) this.fAT.fsG.fsP;
        rsVar.jCt = 3;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            ab.i("MicroMsg.NetSceneCheckSysShare", "video file %s", str);
            bzf bzf = new bzf();
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    ab.i("MicroMsg.NetSceneCheckSysShare", "video duration %d", Integer.valueOf(bo.getInt(mediaMetadataRetriever.extractMetadata(9), -1)));
                    bzf.wYj = r2;
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "%s", e2.getMessage());
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "Analysis duration of mediaItem %s error %s", str, e2.getMessage());
                        if (mediaMetadataRetriever == null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e22) {
                                ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "%s", e22.getMessage());
                            }
                        }
                        bzf.wdO = com.tencent.xweb.util.d.v(new File(str));
                        rsVar.vZb.add(bzf);
                    } catch (Throwable th2) {
                        th = th2;
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e4) {
                                ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e4, "%s", e4.getMessage());
                            }
                        }
                        AppMethodBeat.o(16559);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                mediaMetadataRetriever = null;
                ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "Analysis duration of mediaItem %s error %s", str, e22.getMessage());
                if (mediaMetadataRetriever == null) {
                }
                bzf.wdO = com.tencent.xweb.util.d.v(new File(str));
                rsVar.vZb.add(bzf);
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.o(16559);
                throw th;
            }
            bzf.wdO = com.tencent.xweb.util.d.v(new File(str));
            rsVar.vZb.add(bzf);
        }
        ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16559);
    }

    private void ai(List<String> list) {
        AppMethodBeat.i(16560);
        rs rsVar = (rs) this.fAT.fsG.fsP;
        rsVar.jCt = 5;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            ab.i("MicroMsg.NetSceneCheckSysShare", "share text %s", str);
            int indexOf = str.indexOf("|");
            bze bze = new bze();
            if (indexOf < 0 || indexOf + 1 >= str.length()) {
                bze.Title = "";
                bze.URL = str;
            } else {
                bze.Title = str.substring(0, indexOf);
                bze.URL = str.substring(indexOf + 1);
            }
            bze.wdO = com.tencent.xweb.util.d.x(bze.URL.getBytes());
            rsVar.vZe.add(bze);
        }
        ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16560);
    }

    private void aj(List<String> list) {
        AppMethodBeat.i(16561);
        rs rsVar = (rs) this.fAT.fsG.fsP;
        rsVar.jCt = 4;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            bzb bzb = new bzb();
            File file = new File(str);
            bzb.FileSize = (int) file.length();
            bzb.wdO = com.tencent.xweb.util.d.v(file);
            rsVar.vZd.add(bzb);
        }
        ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16561);
    }

    public final int getType() {
        return 837;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16562);
        this.ehi = fVar;
        a aVar = new a();
        rs rsVar = new rs();
        if (!bo.isNullOrNil(this.fOs)) {
            rsVar.vYZ = this.fOs;
        }
        aVar.fsJ = rsVar;
        aVar.fsK = new rt();
        aVar.uri = "/cgi-bin/micromsg-bin/checksystemshare";
        aVar.fsI = 837;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fAT = aVar.acD();
        switch (this.type) {
            case 1:
                List list = this.fOr;
                rs rsVar2 = (rs) this.fAT.fsG.fsP;
                rsVar2.jCt = 1;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                Iterator it = list.iterator();
                while (true) {
                    long j4 = j3;
                    if (!it.hasNext()) {
                        ab.i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j - currentTimeMillis), Long.valueOf(j2 - j), Long.valueOf(j4 - j2));
                        break;
                    }
                    String str = (String) it.next();
                    ab.i("MicroMsg.NetSceneCheckSysShare", "img file %s", str);
                    byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
                    if (e == null || e.length <= 0) {
                        j3 = j4;
                    } else {
                        Bitmap thumbnail;
                        com.tencent.mm.plugin.u.a.d P;
                        bzd bzd = new bzd();
                        bzd.wdO = com.tencent.xweb.util.d.x(e);
                        j = System.currentTimeMillis();
                        MMBitmapFactory.decodeByteArray(e, 0, e.length, options);
                        ab.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                        bzd.Width = options.outWidth;
                        bzd.Height = options.outHeight;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Cursor query = ah.getContext().getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                        if (query != null) {
                            if (query.moveToFirst()) {
                                int i = query.getInt(query.getColumnIndex("_id"));
                                query.close();
                                thumbnail = Thumbnails.getThumbnail(ah.getContext().getContentResolver(), (long) i, 1, null);
                                if (thumbnail == null) {
                                    P = new com.tencent.mm.plugin.u.a.a().P(thumbnail);
                                    ab.i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", Integer.valueOf(thumbnail.getWidth()), Integer.valueOf(thumbnail.getHeight()));
                                } else {
                                    P = new com.tencent.mm.plugin.u.a.a().Vu(str);
                                }
                                j4 = System.currentTimeMillis();
                                if (P != null) {
                                    ab.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", P.pAE, P.result);
                                    if (!bo.isNullOrNil(P.pAE)) {
                                        if (P.pAE.equals("QR_CODE") || P.pAE.equals("WX_CODE")) {
                                            bzd.wVm = P.result;
                                        } else {
                                            i = P.result.indexOf(",");
                                            if (i < 0 || i + 1 >= P.result.length()) {
                                                bzd.wVm = P.result;
                                            } else {
                                                bzd.wVm = P.result.substring(i + 1);
                                            }
                                        }
                                        bzd.wYi = P.pAE;
                                    }
                                }
                                rsVar2.vZa.add(bzd);
                                j3 = j4;
                                j2 = currentTimeMillis2;
                            } else {
                                query.close();
                            }
                        }
                        thumbnail = null;
                        if (thumbnail == null) {
                        }
                        j4 = System.currentTimeMillis();
                        if (P != null) {
                        }
                        rsVar2.vZa.add(bzd);
                        j3 = j4;
                        j2 = currentTimeMillis2;
                    }
                }
                break;
            case 3:
                ah(this.fOr);
                break;
            case 4:
                aj(this.fOr);
                break;
            case 5:
                ai(this.fOr);
                break;
        }
        int i2 = 1;
        if (g.RK()) {
            i2 = bo.getInt(com.tencent.mm.m.g.Nu().getValue("ShareExtCheckSwitch"), 1);
        }
        if (i2 != 1) {
            this.ehi.onSceneEnd(0, 0, "need not check", this);
            AppMethodBeat.o(16562);
            return 0;
        }
        i2 = a(eVar, this.fAT, this);
        AppMethodBeat.o(16562);
        return i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16563);
        ab.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16563);
    }
}
