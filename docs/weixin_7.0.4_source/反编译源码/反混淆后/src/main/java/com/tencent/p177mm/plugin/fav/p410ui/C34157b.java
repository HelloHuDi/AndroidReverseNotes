package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.b */
public final class C34157b {

    /* renamed from: com.tencent.mm.plugin.fav.ui.b$a */
    static class C28007a implements Runnable {
        C27966g mgf;

        public C28007a(C27966g c27966g) {
            this.mgf = c27966g;
        }

        /* JADX WARNING: Removed duplicated region for block: B:87:0x01fd  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01c9  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            Throwable th;
            AppMethodBeat.m2504i(73918);
            LinkedList linkedList = this.mgf.field_favProto.wiv;
            if (linkedList.size() > 0) {
                boolean z = false;
                int size = linkedList.size();
                C4990ab.m7417i("MicroMsg.Fav.FavAddService", "run addfavservice copyrunable info.field_type = %d", Integer.valueOf(this.mgf.field_type));
                aar aar;
                if (this.mgf.field_type == 18 && this.mgf.field_sourceType == 6) {
                    int i = 0;
                    while (i < size) {
                        boolean z2;
                        aar = (aar) linkedList.get(i);
                        if (aar.wgL && aar.wgN) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        i++;
                        z = z2;
                    }
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        String cz;
                        aar = (aar) linkedList.get(i2);
                        if (C5046bo.isNullOrNil(aar.mnd)) {
                            aar.akU(C39037b.m66382cf(aar.toString(), this.mgf.field_type));
                        }
                        if (!(aar.wgL && aar.wgN)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = aar.wgx;
                        if (C5730e.m8628ct(str)) {
                            cz = C1178g.m2587cz(str);
                            String cA = C1178g.m2586cA(str);
                            aar.akS(cz);
                            aar.akT(cA);
                            aar.mo27431mf(new C5728b(str).length());
                            cz = C39037b.m66370b(aar);
                            if (!str.equals(cz)) {
                                C5730e.m8644y(str, cz);
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.Fav.FavAddService", "copy file fail, type:%d, %s not exist!", Integer.valueOf(aar.dataType), str);
                        }
                        cz = aar.wgz;
                        if (C5046bo.isNullOrNil(cz) && C5730e.m8628ct(str) && this.mgf.field_type == 4 && this.mgf.field_favProto.wit.cvp == 13) {
                            cz = C39037b.m66370b(aar) + "_tempthumb";
                            Bitmap LY = C45932c.m85253LY(str);
                            if (LY != null) {
                                try {
                                    C4990ab.m7416i("MicroMsg.Fav.FavAddService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                    C5056d.m7625a(LY, 60, CompressFormat.JPEG, cz, true);
                                } catch (Exception e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "", new Object[0]);
                                }
                            }
                            aar.akW(cz);
                            MediaMetadataRetriever mediaMetadataRetriever;
                            try {
                                C4990ab.m7416i("MicroMsg.Fav.FavAddService", "add fav service: get video duration");
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str);
                                    aar.mo27393LD(C5046bo.m7576mA((long) C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e, "get video duration error. path %s", str);
                                        if (mediaMetadataRetriever != null) {
                                        }
                                        if (C5730e.m8628ct(cz)) {
                                        }
                                        C4990ab.m7417i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (mediaMetadataRetriever != null) {
                                            mediaMetadataRetriever.release();
                                        }
                                        AppMethodBeat.m2505o(73918);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                mediaMetadataRetriever = null;
                                C4990ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e, "get video duration error. path %s", str);
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (C5730e.m8628ct(cz)) {
                                }
                                C4990ab.m7417i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            } catch (Throwable th3) {
                                th = th3;
                                mediaMetadataRetriever = null;
                                if (mediaMetadataRetriever != null) {
                                }
                                AppMethodBeat.m2505o(73918);
                                throw th;
                            }
                        }
                        if (C5730e.m8628ct(cz)) {
                            InputStream inputStream = null;
                            try {
                                inputStream = C5730e.openRead(cz);
                                String nullAsNil = C5046bo.nullAsNil(C1178g.m2585b(inputStream, 4096));
                                long asZ = C5730e.asZ(cz);
                                String r = C1178g.m2588r(inputStream);
                                aar.akX(nullAsNil);
                                aar.akY(r);
                                aar.mo27432mg(asZ);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                            } catch (FileNotFoundException e6) {
                                C4990ab.m7412e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e7) {
                                    }
                                }
                            } catch (Throwable th4) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                AppMethodBeat.m2505o(73918);
                            }
                            String c = C39037b.m66379c(aar);
                            if (!cz.equals(c)) {
                                C5730e.m8644y(cz, c);
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", cz);
                        }
                        C4990ab.m7417i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(73917);
                        if (z) {
                            C4990ab.m7417i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", Integer.valueOf(C28007a.this.mgf.field_type));
                            C28007a.this.mgf.field_itemStatus = 1;
                            C28007a.this.mgf.field_xml = C27966g.m44521s(C28007a.this.mgf);
                            if (C39037b.m66409k(C28007a.this.mgf)) {
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(C28007a.this.mgf, new String[0]);
                            } else {
                                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23700y(C28007a.this.mgf);
                            }
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getCheckCdnService().run();
                            AppMethodBeat.m2505o(73917);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", Integer.valueOf(C28007a.this.mgf.field_type));
                        C28007a.this.mgf.field_itemStatus = 9;
                        C28007a.this.mgf.field_xml = C27966g.m44521s(C28007a.this.mgf);
                        if (C39037b.m66409k(C28007a.this.mgf)) {
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(C28007a.this.mgf, new String[0]);
                        } else {
                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23700y(C28007a.this.mgf);
                        }
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
                        AppMethodBeat.m2505o(73917);
                    }
                });
            }
            AppMethodBeat.m2505o(73918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.b$1 */
    static class C341581 implements OnClickListener {
        final /* synthetic */ C45316cl mhl;

        C341581(C45316cl c45316cl) {
            this.mhl = c45316cl;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(73916);
            if (i == -2) {
                C34157b.m56009b(this.mhl);
            }
            AppMethodBeat.m2505o(73916);
        }
    }

    /* renamed from: a */
    public static boolean m56008a(C45316cl c45316cl) {
        AppMethodBeat.m2504i(73919);
        if (!(c45316cl.cvA.cvC == null || c45316cl.cvA.cvC.wiv == null)) {
            Iterator it = c45316cl.cvA.cvC.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                int i = aar.dataType;
                if ((i == 2 || i == 4 || i == 15 || i == 8) && C5046bo.isNullOrNil(aar.wfZ)) {
                    if (C5046bo.isNullOrNil(aar.wgx)) {
                        AppMethodBeat.m2505o(73919);
                        return false;
                    } else if (!C5730e.m8628ct(aar.wgx)) {
                        AppMethodBeat.m2505o(73919);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(73919);
        return true;
    }

    /* renamed from: b */
    static int m56009b(C45316cl c45316cl) {
        AppMethodBeat.m2504i(73920);
        C27966g c27966g = new C27966g();
        c27966g.field_favProto = c45316cl.cvA.cvC;
        c27966g.field_sessionId = c45316cl.cvA.cvF;
        if (C34157b.m56010b(c27966g, c45316cl.cvA.cvH)) {
            c27966g.field_flag = 0;
            c27966g.field_updateTime = System.currentTimeMillis();
            c27966g.field_localId = System.currentTimeMillis();
            C39037b.m66405it(c27966g.field_localId);
            c27966g.field_type = c45316cl.cvA.type;
            if (c45316cl.cvA.desc == null || c45316cl.cvA.desc.length() < 10001) {
                c27966g.field_favProto.alC(c45316cl.cvA.desc);
            } else {
                C4990ab.m7420w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                c27966g.field_favProto.alC(c45316cl.cvA.desc.substring(0, 10001));
            }
            c27966g.field_xml = C27966g.m44521s(c27966g);
            C34157b.m56006C(c27966g);
            C39037b.m66408j(c27966g);
            c27966g.mo45882LI("MicroMsg.Fav.FavAddService");
            AppMethodBeat.m2505o(73920);
        } else {
            C27966g LS = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23675LS(c27966g.field_sourceId);
            if (LS != null) {
                C39037b.m66405it(LS.field_localId);
            }
            AppMethodBeat.m2505o(73920);
        }
        return 0;
    }

    /* renamed from: B */
    public static void m56005B(C27966g c27966g) {
        AppMethodBeat.m2504i(73921);
        c27966g.field_updateTime = System.currentTimeMillis();
        if (!C39037b.m66409k(c27966g)) {
            c27966g.field_localId = System.currentTimeMillis();
        }
        C34157b.m56006C(c27966g);
        C39037b.m66408j(c27966g);
        AppMethodBeat.m2505o(73921);
    }

    /* renamed from: C */
    private static void m56006C(C27966g c27966g) {
        AppMethodBeat.m2504i(73922);
        C27968h.m44528iw(c27966g.field_localId);
        if (c27966g.field_favProto.wiv.size() > 0) {
            C7305d.post(new C28007a(c27966g), "AddFavService_copy");
            AppMethodBeat.m2505o(73922);
            return;
        }
        c27966g.field_itemStatus = 9;
        if (C39037b.m66409k(c27966g)) {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(c27966g, new String[0]);
        } else {
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23700y(c27966g);
        }
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().run();
        AppMethodBeat.m2505o(73922);
    }

    /* renamed from: b */
    private static boolean m56010b(C27966g c27966g, int i) {
        AppMethodBeat.m2504i(73923);
        abl abl = c27966g.field_favProto.wit;
        if (abl != null) {
            c27966g.field_sourceId = abl.wiC;
            if (C34157b.m56007D(c27966g)) {
                C4990ab.m7420w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                AppMethodBeat.m2505o(73923);
                return false;
            }
            switch (abl.cvp) {
                case 1:
                    if (!C1855t.m3913mZ(c27966g.field_fromUser)) {
                        if (!C1855t.m3896kH(c27966g.field_fromUser)) {
                            c27966g.field_sourceType = 21;
                            break;
                        }
                        c27966g.field_sourceType = 22;
                        break;
                    }
                    c27966g.field_sourceType = 23;
                    break;
                case 3:
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                c27966g.field_sourceType = abl.cvp;
                                break;
                            }
                            c27966g.field_sourceType = 26;
                            break;
                        }
                        c27966g.field_sourceType = 25;
                        break;
                    }
                    c27966g.field_sourceType = 24;
                    break;
                default:
                    c27966g.field_sourceType = abl.cvp;
                    break;
            }
            c27966g.field_fromUser = abl.cEV;
            c27966g.field_toUser = abl.toUser;
            c27966g.field_sourceId = abl.wiC;
            c27966g.field_sourceCreateTime = abl.createTime;
        }
        C4990ab.m7417i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", c27966g.field_fromUser, c27966g.field_toUser, c27966g.field_sourceId, Integer.valueOf(c27966g.field_sourceType));
        AppMethodBeat.m2505o(73923);
        return true;
    }

    /* renamed from: D */
    private static boolean m56007D(C27966g c27966g) {
        AppMethodBeat.m2504i(73924);
        if (c27966g.field_sourceId == null || c27966g.field_sourceId.equals("")) {
            AppMethodBeat.m2505o(73924);
            return false;
        }
        C27966g LS = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23675LS(c27966g.field_sourceId);
        if (LS != null && LS.field_id > 0) {
            C34157b.m56011vB(LS.field_id);
        }
        if (LS != null) {
            AppMethodBeat.m2505o(73924);
            return true;
        }
        AppMethodBeat.m2505o(73924);
        return false;
    }

    /* renamed from: vB */
    private static void m56011vB(int i) {
        AppMethodBeat.m2504i(73925);
        if (i <= 0) {
            C4990ab.m7413e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(73925);
            return;
        }
        LinkedList linkedList = new LinkedList();
        bca bca = new bca();
        bca.wGC = 1;
        bca.wGD = (int) (System.currentTimeMillis() / 1000);
        linkedList.add(bca);
        C1720g.m3540Rg().mo14541a(new C11850al(i, linkedList, null), 0);
        AppMethodBeat.m2505o(73925);
    }
}
