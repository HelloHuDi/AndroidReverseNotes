package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public final class k implements w {
    public boolean mfm = true;

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e2 A:{SYNTHETIC, Splitter:B:74:0x01e2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(g gVar) {
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.i(102666);
        if (gVar == null) {
            AppMethodBeat.o(102666);
            return true;
        } else if (b.f(gVar)) {
            AppMethodBeat.o(102666);
            return true;
        } else {
            g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId);
            boolean isNullOrNil;
            aar c;
            String str;
            abe abe;
            switch (gVar.field_type) {
                case 1:
                    isNullOrNil = bo.isNullOrNil(gVar.field_favProto.desc);
                    AppMethodBeat.o(102666);
                    return isNullOrNil;
                case 2:
                case 8:
                    if (new b(b.b(b.c(gVar))).exists()) {
                        AppMethodBeat.o(102666);
                        return false;
                    }
                    AppMethodBeat.o(102666);
                    return true;
                case 3:
                    if (this.mfm) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 4:
                    c = b.c(gVar);
                    if (new b(b.b(c)).exists()) {
                        AppMethodBeat.o(102666);
                        return false;
                    }
                    isNullOrNil = bo.isNullOrNil(c.wgg);
                    AppMethodBeat.o(102666);
                    return isNullOrNil;
                case 5:
                    abl abl = gVar.field_favProto.wit;
                    abu abu = gVar.field_favProto.whA;
                    str = null;
                    if (abu != null) {
                        str = abu.wiY;
                    }
                    if (abl != null && bo.isNullOrNil(r0)) {
                        str = abl.link;
                    }
                    isNullOrNil = bo.isNullOrNil(str);
                    AppMethodBeat.o(102666);
                    return isNullOrNil;
                case 6:
                    if (gVar.field_favProto.why == null) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 7:
                    c = b.c(gVar);
                    if (bo.isNullOrNil(c.wgg) && bo.isNullOrNil(c.wgi) && bo.isNullOrNil(c.wgk) && bo.isNullOrNil(c.wgk)) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 10:
                    abe = gVar.field_favProto.whC;
                    if (abe == null || bo.isNullOrNil(abe.info)) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 11:
                    abe = gVar.field_favProto.whC;
                    if (abe == null || bo.isNullOrNil(abe.info)) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 14:
                case 18:
                    if (gVar.field_id <= 0 && iE != null) {
                        AppMethodBeat.o(102666);
                        return true;
                    } else if (gVar.field_type == 18 && (gVar.field_favProto == null || gVar.field_favProto.wiv.size() <= 1)) {
                        AppMethodBeat.o(102666);
                        return true;
                    } else if (gVar.field_type == 18 && (bo.isNullOrNil(((aar) gVar.field_favProto.wiv.get(0)).wfZ) || bo.isNullOrNil(((aar) gVar.field_favProto.wiv.get(0)).wgb))) {
                        AppMethodBeat.o(102666);
                        return true;
                    } else {
                        Iterator it = gVar.field_favProto.wiv.iterator();
                        while (it.hasNext()) {
                            c = (aar) it.next();
                            if ((c.dataType == 2 || c.dataType == 8 || c.dataType == 15 || c.dataType == 4) && !e.ct(b.b(c))) {
                                AppMethodBeat.o(102666);
                                return true;
                            }
                        }
                        AppMethodBeat.o(102666);
                        return false;
                    }
                case 15:
                    abo abo = gVar.field_favProto.whE;
                    if (abo == null || bo.isNullOrNil(abo.info)) {
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    AppMethodBeat.o(102666);
                    return false;
                case 16:
                    if (bo.ank(com.tencent.mm.m.g.Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                        ab.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                        AppMethodBeat.o(102666);
                        return true;
                    }
                    aar c2 = b.c(gVar);
                    b bVar = new b(b.b(c2));
                    ab.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), j.w(bVar.dMD()), Boolean.valueOf(bVar.exists()));
                    if (bVar.exists()) {
                        long length = bVar.length();
                        if (Math.abs(c2.wgu - length) > 16) {
                            InputStream b;
                            try {
                                b = e.b(bVar.mUri, null);
                                try {
                                    str = com.tencent.mm.a.g.b(b, 4096);
                                    if (b != null) {
                                        try {
                                            b.close();
                                        } catch (IOException e) {
                                        }
                                    }
                                } catch (IOException e2) {
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = b;
                                    if (inputStream != null) {
                                    }
                                    AppMethodBeat.o(102666);
                                    throw th;
                                }
                            } catch (IOException e3) {
                                b = null;
                                str = null;
                                if (b != null) {
                                    try {
                                        b.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                ab.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", Long.valueOf(length), str, Long.valueOf(r6), c2.wgq);
                                AppMethodBeat.o(102666);
                                return true;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                AppMethodBeat.o(102666);
                                throw th;
                            }
                            ab.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", Long.valueOf(length), str, Long.valueOf(r6), c2.wgq);
                            AppMethodBeat.o(102666);
                            return true;
                        }
                        AppMethodBeat.o(102666);
                        return false;
                    }
                    AppMethodBeat.o(102666);
                    return true;
                default:
                    AppMethodBeat.o(102666);
                    return false;
            }
        }
    }

    public static boolean h(aar aar) {
        AppMethodBeat.i(102667);
        if (aar == null) {
            AppMethodBeat.o(102667);
            return true;
        }
        switch (aar.dataType) {
            case 2:
            case 8:
                if (new b(b.b(aar)).exists()) {
                    AppMethodBeat.o(102667);
                    return false;
                }
                AppMethodBeat.o(102667);
                return true;
            case 3:
                AppMethodBeat.o(102667);
                return true;
            case 4:
                if (new b(b.b(aar)).exists()) {
                    AppMethodBeat.o(102667);
                    return false;
                }
                boolean isNullOrNil = bo.isNullOrNil(aar.wgg);
                AppMethodBeat.o(102667);
                return isNullOrNil;
            case 7:
                if (bo.isNullOrNil(aar.wgg) && bo.isNullOrNil(aar.wgi) && bo.isNullOrNil(aar.wgk) && bo.isNullOrNil(aar.wgk)) {
                    AppMethodBeat.o(102667);
                    return true;
                }
                AppMethodBeat.o(102667);
                return false;
            case 15:
                if (bo.ank(com.tencent.mm.m.g.Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    ab.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    AppMethodBeat.o(102667);
                    return true;
                } else if (new b(b.b(aar)).exists()) {
                    AppMethodBeat.o(102667);
                    return false;
                } else {
                    AppMethodBeat.o(102667);
                    return true;
                }
            default:
                AppMethodBeat.o(102667);
                return false;
        }
    }

    public static boolean u(g gVar) {
        AppMethodBeat.i(102668);
        if (gVar == null) {
            AppMethodBeat.o(102668);
            return false;
        } else if (gVar.field_itemStatus <= 0 || b.g(gVar)) {
            g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(gVar.field_localId);
            b bVar = new b(b.b(b.c(gVar)));
            switch (gVar.field_type) {
                case 2:
                case 8:
                    if (!bVar.exists()) {
                        AppMethodBeat.o(102668);
                        return true;
                    }
                    break;
                case 4:
                    if (bo.isNullOrNil(b.c(gVar).wgg) && !bVar.exists()) {
                        AppMethodBeat.o(102668);
                        return true;
                    }
                case 14:
                case 18:
                    if (gVar.field_id > 0 || iE == null) {
                        if (gVar.field_favProto != null && gVar.field_favProto.wiv.size() > 1) {
                            Iterator it = gVar.field_favProto.wiv.iterator();
                            while (it.hasNext()) {
                                aar aar = (aar) it.next();
                                if (!bo.isNullOrNil(aar.wfZ) && !bo.isNullOrNil(aar.wgb) && !e.ct(b.b(aar))) {
                                    AppMethodBeat.o(102668);
                                    return true;
                                }
                            }
                            break;
                        }
                        AppMethodBeat.o(102668);
                        return false;
                    }
                    AppMethodBeat.o(102668);
                    return false;
                case 16:
                    if (bo.ank(com.tencent.mm.m.g.Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                        ab.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                        AppMethodBeat.o(102668);
                        return false;
                    } else if (!bVar.exists()) {
                        AppMethodBeat.o(102668);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.o(102668);
            return false;
        } else {
            AppMethodBeat.o(102668);
            return false;
        }
    }
}
