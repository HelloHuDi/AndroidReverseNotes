package com.tencent.p177mm.modelsimple;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p543u.p544a.C35333a;
import com.tencent.p177mm.plugin.p543u.p544a.C4264d;
import com.tencent.p177mm.protocal.protobuf.C35948rs;
import com.tencent.p177mm.protocal.protobuf.C35949rt;
import com.tencent.p177mm.protocal.protobuf.bzb;
import com.tencent.p177mm.protocal.protobuf.bzd;
import com.tencent.p177mm.protocal.protobuf.bze;
import com.tencent.p177mm.protocal.protobuf.bzf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.util.C6037d;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.modelsimple.d */
public final class C37946d extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    private List<String> fOr;
    private String fOs;
    private int type;

    public C37946d(int i, List<String> list, String str) {
        this.type = i;
        this.fOr = list;
        this.fOs = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4 A:{SYNTHETIC, Splitter:B:18:0x00a4} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1 A:{SYNTHETIC, Splitter:B:25:0x00c1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ah */
    private void m64150ah(List<String> list) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(16559);
        C35948rs c35948rs = (C35948rs) this.fAT.fsG.fsP;
        c35948rs.jCt = 3;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "video file %s", str);
            bzf bzf = new bzf();
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "video duration %d", Integer.valueOf(C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), -1)));
                    bzf.wYj = r2;
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "%s", e2.getMessage());
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "Analysis duration of mediaItem %s error %s", str, e2.getMessage());
                        if (mediaMetadataRetriever == null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e22) {
                                C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "%s", e22.getMessage());
                            }
                        }
                        bzf.wdO = C6037d.m9504v(new File(str));
                        c35948rs.vZb.add(bzf);
                    } catch (Throwable th2) {
                        th = th2;
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e4) {
                                C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e4, "%s", e4.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(16559);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                mediaMetadataRetriever = null;
                C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "Analysis duration of mediaItem %s error %s", str, e22.getMessage());
                if (mediaMetadataRetriever == null) {
                }
                bzf.wdO = C6037d.m9504v(new File(str));
                c35948rs.vZb.add(bzf);
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.m2505o(16559);
                throw th;
            }
            bzf.wdO = C6037d.m9504v(new File(str));
            c35948rs.vZb.add(bzf);
        }
        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16559);
    }

    /* renamed from: ai */
    private void m64151ai(List<String> list) {
        AppMethodBeat.m2504i(16560);
        C35948rs c35948rs = (C35948rs) this.fAT.fsG.fsP;
        c35948rs.jCt = 5;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "share text %s", str);
            int indexOf = str.indexOf("|");
            bze bze = new bze();
            if (indexOf < 0 || indexOf + 1 >= str.length()) {
                bze.Title = "";
                bze.URL = str;
            } else {
                bze.Title = str.substring(0, indexOf);
                bze.URL = str.substring(indexOf + 1);
            }
            bze.wdO = C6037d.m9506x(bze.URL.getBytes());
            c35948rs.vZe.add(bze);
        }
        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16560);
    }

    /* renamed from: aj */
    private void m64152aj(List<String> list) {
        AppMethodBeat.m2504i(16561);
        C35948rs c35948rs = (C35948rs) this.fAT.fsG.fsP;
        c35948rs.jCt = 4;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            bzb bzb = new bzb();
            File file = new File(str);
            bzb.FileSize = (int) file.length();
            bzb.wdO = C6037d.m9504v(file);
            c35948rs.vZd.add(bzb);
        }
        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16561);
    }

    public final int getType() {
        return 837;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16562);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        C35948rs c35948rs = new C35948rs();
        if (!C5046bo.isNullOrNil(this.fOs)) {
            c35948rs.vYZ = this.fOs;
        }
        c1196a.fsJ = c35948rs;
        c1196a.fsK = new C35949rt();
        c1196a.uri = "/cgi-bin/micromsg-bin/checksystemshare";
        c1196a.fsI = 837;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fAT = c1196a.acD();
        switch (this.type) {
            case 1:
                List list = this.fOr;
                C35948rs c35948rs2 = (C35948rs) this.fAT.fsG.fsP;
                c35948rs2.jCt = 1;
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
                        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "cost %d(%d, %d, %d)ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j - currentTimeMillis), Long.valueOf(j2 - j), Long.valueOf(j4 - j2));
                        break;
                    }
                    String str = (String) it.next();
                    C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "img file %s", str);
                    byte[] e = C1173e.m2569e(str, 0, -1);
                    if (e == null || e.length <= 0) {
                        j3 = j4;
                    } else {
                        Bitmap thumbnail;
                        C4264d P;
                        bzd bzd = new bzd();
                        bzd.wdO = C6037d.m9506x(e);
                        j = System.currentTimeMillis();
                        MMBitmapFactory.decodeByteArray(e, 0, e.length, options);
                        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                        bzd.Width = options.outWidth;
                        bzd.Height = options.outHeight;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Cursor query = C4996ah.getContext().getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                        if (query != null) {
                            if (query.moveToFirst()) {
                                int i = query.getInt(query.getColumnIndex("_id"));
                                query.close();
                                thumbnail = Thumbnails.getThumbnail(C4996ah.getContext().getContentResolver(), (long) i, 1, null);
                                if (thumbnail == null) {
                                    P = new C35333a().mo56078P(thumbnail);
                                    C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "have thumbnail(w:%d, h:%d)", Integer.valueOf(thumbnail.getWidth()), Integer.valueOf(thumbnail.getHeight()));
                                } else {
                                    P = new C35333a().mo56079Vu(str);
                                }
                                j4 = System.currentTimeMillis();
                                if (P != null) {
                                    C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", P.pAE, P.result);
                                    if (!C5046bo.isNullOrNil(P.pAE)) {
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
                                c35948rs2.vZa.add(bzd);
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
                        c35948rs2.vZa.add(bzd);
                        j3 = j4;
                        j2 = currentTimeMillis2;
                    }
                }
                break;
            case 3:
                m64150ah(this.fOr);
                break;
            case 4:
                m64152aj(this.fOr);
                break;
            case 5:
                m64151ai(this.fOr);
                break;
        }
        int i2 = 1;
        if (C1720g.m3531RK()) {
            i2 = C5046bo.getInt(C26373g.m41964Nu().getValue("ShareExtCheckSwitch"), 1);
        }
        if (i2 != 1) {
            this.ehi.onSceneEnd(0, 0, "need not check", this);
            AppMethodBeat.m2505o(16562);
            return 0;
        }
        i2 = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(16562);
        return i2;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16563);
        C4990ab.m7417i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16563);
    }
}
