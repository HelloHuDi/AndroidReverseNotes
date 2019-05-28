package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {

    static class a implements Runnable {
        g mgf;

        public a(g gVar) {
            this.mgf = gVar;
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
            AppMethodBeat.i(73918);
            LinkedList linkedList = this.mgf.field_favProto.wiv;
            if (linkedList.size() > 0) {
                boolean z = false;
                int size = linkedList.size();
                ab.i("MicroMsg.Fav.FavAddService", "run addfavservice copyrunable info.field_type = %d", Integer.valueOf(this.mgf.field_type));
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
                        if (bo.isNullOrNil(aar.mnd)) {
                            aar.akU(com.tencent.mm.plugin.fav.a.b.cf(aar.toString(), this.mgf.field_type));
                        }
                        if (!(aar.wgL && aar.wgN)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = aar.wgx;
                        if (e.ct(str)) {
                            cz = com.tencent.mm.a.g.cz(str);
                            String cA = com.tencent.mm.a.g.cA(str);
                            aar.akS(cz);
                            aar.akT(cA);
                            aar.mf(new com.tencent.mm.vfs.b(str).length());
                            cz = com.tencent.mm.plugin.fav.a.b.b(aar);
                            if (!str.equals(cz)) {
                                e.y(str, cz);
                            }
                        } else {
                            ab.i("MicroMsg.Fav.FavAddService", "copy file fail, type:%d, %s not exist!", Integer.valueOf(aar.dataType), str);
                        }
                        cz = aar.wgz;
                        if (bo.isNullOrNil(cz) && e.ct(str) && this.mgf.field_type == 4 && this.mgf.field_favProto.wit.cvp == 13) {
                            cz = com.tencent.mm.plugin.fav.a.b.b(aar) + "_tempthumb";
                            Bitmap LY = c.LY(str);
                            if (LY != null) {
                                try {
                                    ab.i("MicroMsg.Fav.FavAddService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                    d.a(LY, 60, CompressFormat.JPEG, cz, true);
                                } catch (Exception e2) {
                                    ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "", new Object[0]);
                                }
                            }
                            aar.akW(cz);
                            MediaMetadataRetriever mediaMetadataRetriever;
                            try {
                                ab.i("MicroMsg.Fav.FavAddService", "add fav service: get video duration");
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str);
                                    aar.LD(bo.mA((long) bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e, "get video duration error. path %s", str);
                                        if (mediaMetadataRetriever != null) {
                                        }
                                        if (e.ct(cz)) {
                                        }
                                        ab.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (mediaMetadataRetriever != null) {
                                            mediaMetadataRetriever.release();
                                        }
                                        AppMethodBeat.o(73918);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                mediaMetadataRetriever = null;
                                ab.printErrStackTrace("MicroMsg.Fav.FavAddService", e, "get video duration error. path %s", str);
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (e.ct(cz)) {
                                }
                                ab.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            } catch (Throwable th3) {
                                th = th3;
                                mediaMetadataRetriever = null;
                                if (mediaMetadataRetriever != null) {
                                }
                                AppMethodBeat.o(73918);
                                throw th;
                            }
                        }
                        if (e.ct(cz)) {
                            InputStream inputStream = null;
                            try {
                                inputStream = e.openRead(cz);
                                String nullAsNil = bo.nullAsNil(com.tencent.mm.a.g.b(inputStream, 4096));
                                long asZ = e.asZ(cz);
                                String r = com.tencent.mm.a.g.r(inputStream);
                                aar.akX(nullAsNil);
                                aar.akY(r);
                                aar.mg(asZ);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                            } catch (FileNotFoundException e6) {
                                ab.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
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
                                AppMethodBeat.o(73918);
                            }
                            String c = com.tencent.mm.plugin.fav.a.b.c(aar);
                            if (!cz.equals(c)) {
                                e.y(cz, c);
                            }
                        } else {
                            ab.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", cz);
                        }
                        ab.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mgf.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(73917);
                        if (z) {
                            ab.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", Integer.valueOf(a.this.mgf.field_type));
                            a.this.mgf.field_itemStatus = 1;
                            a.this.mgf.field_xml = g.s(a.this.mgf);
                            if (com.tencent.mm.plugin.fav.a.b.k(a.this.mgf)) {
                                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(a.this.mgf, new String[0]);
                            } else {
                                ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().y(a.this.mgf);
                            }
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getCheckCdnService().run();
                            AppMethodBeat.o(73917);
                            return;
                        }
                        ab.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", Integer.valueOf(a.this.mgf.field_type));
                        a.this.mgf.field_itemStatus = 9;
                        a.this.mgf.field_xml = g.s(a.this.mgf);
                        if (com.tencent.mm.plugin.fav.a.b.k(a.this.mgf)) {
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(a.this.mgf, new String[0]);
                        } else {
                            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().y(a.this.mgf);
                        }
                        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
                        AppMethodBeat.o(73917);
                    }
                });
            }
            AppMethodBeat.o(73918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.b$1 */
    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ cl mhl;

        AnonymousClass1(cl clVar) {
            this.mhl = clVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(73916);
            if (i == -2) {
                b.b(this.mhl);
            }
            AppMethodBeat.o(73916);
        }
    }

    public static boolean a(cl clVar) {
        AppMethodBeat.i(73919);
        if (!(clVar.cvA.cvC == null || clVar.cvA.cvC.wiv == null)) {
            Iterator it = clVar.cvA.cvC.wiv.iterator();
            while (it.hasNext()) {
                aar aar = (aar) it.next();
                int i = aar.dataType;
                if ((i == 2 || i == 4 || i == 15 || i == 8) && bo.isNullOrNil(aar.wfZ)) {
                    if (bo.isNullOrNil(aar.wgx)) {
                        AppMethodBeat.o(73919);
                        return false;
                    } else if (!e.ct(aar.wgx)) {
                        AppMethodBeat.o(73919);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(73919);
        return true;
    }

    static int b(cl clVar) {
        AppMethodBeat.i(73920);
        g gVar = new g();
        gVar.field_favProto = clVar.cvA.cvC;
        gVar.field_sessionId = clVar.cvA.cvF;
        if (b(gVar, clVar.cvA.cvH)) {
            gVar.field_flag = 0;
            gVar.field_updateTime = System.currentTimeMillis();
            gVar.field_localId = System.currentTimeMillis();
            com.tencent.mm.plugin.fav.a.b.it(gVar.field_localId);
            gVar.field_type = clVar.cvA.type;
            if (clVar.cvA.desc == null || clVar.cvA.desc.length() < 10001) {
                gVar.field_favProto.alC(clVar.cvA.desc);
            } else {
                ab.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                gVar.field_favProto.alC(clVar.cvA.desc.substring(0, 10001));
            }
            gVar.field_xml = g.s(gVar);
            C(gVar);
            com.tencent.mm.plugin.fav.a.b.j(gVar);
            gVar.LI("MicroMsg.Fav.FavAddService");
            AppMethodBeat.o(73920);
        } else {
            g LS = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().LS(gVar.field_sourceId);
            if (LS != null) {
                com.tencent.mm.plugin.fav.a.b.it(LS.field_localId);
            }
            AppMethodBeat.o(73920);
        }
        return 0;
    }

    public static void B(g gVar) {
        AppMethodBeat.i(73921);
        gVar.field_updateTime = System.currentTimeMillis();
        if (!com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            gVar.field_localId = System.currentTimeMillis();
        }
        C(gVar);
        com.tencent.mm.plugin.fav.a.b.j(gVar);
        AppMethodBeat.o(73921);
    }

    private static void C(g gVar) {
        AppMethodBeat.i(73922);
        h.iw(gVar.field_localId);
        if (gVar.field_favProto.wiv.size() > 0) {
            com.tencent.mm.sdk.g.d.post(new a(gVar), "AddFavService_copy");
            AppMethodBeat.o(73922);
            return;
        }
        gVar.field_itemStatus = 9;
        if (com.tencent.mm.plugin.fav.a.b.k(gVar)) {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(gVar, new String[0]);
        } else {
            ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().y(gVar);
        }
        ((ae) com.tencent.mm.kernel.g.M(ae.class)).getSendService().run();
        AppMethodBeat.o(73922);
    }

    private static boolean b(g gVar, int i) {
        AppMethodBeat.i(73923);
        abl abl = gVar.field_favProto.wit;
        if (abl != null) {
            gVar.field_sourceId = abl.wiC;
            if (D(gVar)) {
                ab.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                AppMethodBeat.o(73923);
                return false;
            }
            switch (abl.cvp) {
                case 1:
                    if (!t.mZ(gVar.field_fromUser)) {
                        if (!t.kH(gVar.field_fromUser)) {
                            gVar.field_sourceType = 21;
                            break;
                        }
                        gVar.field_sourceType = 22;
                        break;
                    }
                    gVar.field_sourceType = 23;
                    break;
                case 3:
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                gVar.field_sourceType = abl.cvp;
                                break;
                            }
                            gVar.field_sourceType = 26;
                            break;
                        }
                        gVar.field_sourceType = 25;
                        break;
                    }
                    gVar.field_sourceType = 24;
                    break;
                default:
                    gVar.field_sourceType = abl.cvp;
                    break;
            }
            gVar.field_fromUser = abl.cEV;
            gVar.field_toUser = abl.toUser;
            gVar.field_sourceId = abl.wiC;
            gVar.field_sourceCreateTime = abl.createTime;
        }
        ab.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", gVar.field_fromUser, gVar.field_toUser, gVar.field_sourceId, Integer.valueOf(gVar.field_sourceType));
        AppMethodBeat.o(73923);
        return true;
    }

    private static boolean D(g gVar) {
        AppMethodBeat.i(73924);
        if (gVar.field_sourceId == null || gVar.field_sourceId.equals("")) {
            AppMethodBeat.o(73924);
            return false;
        }
        g LS = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().LS(gVar.field_sourceId);
        if (LS != null && LS.field_id > 0) {
            vB(LS.field_id);
        }
        if (LS != null) {
            AppMethodBeat.o(73924);
            return true;
        }
        AppMethodBeat.o(73924);
        return false;
    }

    private static void vB(int i) {
        AppMethodBeat.i(73925);
        if (i <= 0) {
            ab.e("MicroMsg.Fav.FavAddService", "modUpdateTime favId illegal:%d", Integer.valueOf(i));
            AppMethodBeat.o(73925);
            return;
        }
        LinkedList linkedList = new LinkedList();
        bca bca = new bca();
        bca.wGC = 1;
        bca.wGD = (int) (System.currentTimeMillis() / 1000);
        linkedList.add(bca);
        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.plugin.fav.a.al(i, linkedList, null), 0);
        AppMethodBeat.o(73925);
    }
}
