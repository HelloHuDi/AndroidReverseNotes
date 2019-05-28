package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.abu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.fav.a.k */
public final class C41268k implements C39039w {
    public boolean mfm = true;

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e2 A:{SYNTHETIC, Splitter:B:74:0x01e2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: t */
    public final boolean mo61948t(C27966g c27966g) {
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.m2504i(102666);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102666);
            return true;
        } else if (C39037b.m66392f(c27966g)) {
            AppMethodBeat.m2505o(102666);
            return true;
        } else {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId);
            boolean isNullOrNil;
            aar c;
            String str;
            abe abe;
            switch (c27966g.field_type) {
                case 1:
                    isNullOrNil = C5046bo.isNullOrNil(c27966g.field_favProto.desc);
                    AppMethodBeat.m2505o(102666);
                    return isNullOrNil;
                case 2:
                case 8:
                    if (new C5728b(C39037b.m66370b(C39037b.m66378c(c27966g))).exists()) {
                        AppMethodBeat.m2505o(102666);
                        return false;
                    }
                    AppMethodBeat.m2505o(102666);
                    return true;
                case 3:
                    if (this.mfm) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 4:
                    c = C39037b.m66378c(c27966g);
                    if (new C5728b(C39037b.m66370b(c)).exists()) {
                        AppMethodBeat.m2505o(102666);
                        return false;
                    }
                    isNullOrNil = C5046bo.isNullOrNil(c.wgg);
                    AppMethodBeat.m2505o(102666);
                    return isNullOrNil;
                case 5:
                    abl abl = c27966g.field_favProto.wit;
                    abu abu = c27966g.field_favProto.whA;
                    str = null;
                    if (abu != null) {
                        str = abu.wiY;
                    }
                    if (abl != null && C5046bo.isNullOrNil(r0)) {
                        str = abl.link;
                    }
                    isNullOrNil = C5046bo.isNullOrNil(str);
                    AppMethodBeat.m2505o(102666);
                    return isNullOrNil;
                case 6:
                    if (c27966g.field_favProto.why == null) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 7:
                    c = C39037b.m66378c(c27966g);
                    if (C5046bo.isNullOrNil(c.wgg) && C5046bo.isNullOrNil(c.wgi) && C5046bo.isNullOrNil(c.wgk) && C5046bo.isNullOrNil(c.wgk)) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 10:
                    abe = c27966g.field_favProto.whC;
                    if (abe == null || C5046bo.isNullOrNil(abe.info)) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 11:
                    abe = c27966g.field_favProto.whC;
                    if (abe == null || C5046bo.isNullOrNil(abe.info)) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 14:
                case 18:
                    if (c27966g.field_id <= 0 && iE != null) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    } else if (c27966g.field_type == 18 && (c27966g.field_favProto == null || c27966g.field_favProto.wiv.size() <= 1)) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    } else if (c27966g.field_type == 18 && (C5046bo.isNullOrNil(((aar) c27966g.field_favProto.wiv.get(0)).wfZ) || C5046bo.isNullOrNil(((aar) c27966g.field_favProto.wiv.get(0)).wgb))) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    } else {
                        Iterator it = c27966g.field_favProto.wiv.iterator();
                        while (it.hasNext()) {
                            c = (aar) it.next();
                            if ((c.dataType == 2 || c.dataType == 8 || c.dataType == 15 || c.dataType == 4) && !C5730e.m8628ct(C39037b.m66370b(c))) {
                                AppMethodBeat.m2505o(102666);
                                return true;
                            }
                        }
                        AppMethodBeat.m2505o(102666);
                        return false;
                    }
                case 15:
                    abo abo = c27966g.field_favProto.whE;
                    if (abo == null || C5046bo.isNullOrNil(abo.info)) {
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    AppMethodBeat.m2505o(102666);
                    return false;
                case 16:
                    if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                        C4990ab.m7420w("MicroMsg.FavSendFilter", "can not retransmit short video");
                        AppMethodBeat.m2505o(102666);
                        return true;
                    }
                    aar c2 = C39037b.m66378c(c27966g);
                    C5728b c5728b = new C5728b(C39037b.m66370b(c2));
                    C4990ab.m7419v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), C5736j.m8649w(c5728b.dMD()), Boolean.valueOf(c5728b.exists()));
                    if (c5728b.exists()) {
                        long length = c5728b.length();
                        if (Math.abs(c2.wgu - length) > 16) {
                            InputStream b;
                            try {
                                b = C5730e.m8625b(c5728b.mUri, null);
                                try {
                                    str = C1178g.m2585b(b, 4096);
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
                                    AppMethodBeat.m2505o(102666);
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
                                C4990ab.m7421w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", Long.valueOf(length), str, Long.valueOf(r6), c2.wgq);
                                AppMethodBeat.m2505o(102666);
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
                                AppMethodBeat.m2505o(102666);
                                throw th;
                            }
                            C4990ab.m7421w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", Long.valueOf(length), str, Long.valueOf(r6), c2.wgq);
                            AppMethodBeat.m2505o(102666);
                            return true;
                        }
                        AppMethodBeat.m2505o(102666);
                        return false;
                    }
                    AppMethodBeat.m2505o(102666);
                    return true;
                default:
                    AppMethodBeat.m2505o(102666);
                    return false;
            }
        }
    }

    /* renamed from: h */
    public static boolean m71868h(aar aar) {
        AppMethodBeat.m2504i(102667);
        if (aar == null) {
            AppMethodBeat.m2505o(102667);
            return true;
        }
        switch (aar.dataType) {
            case 2:
            case 8:
                if (new C5728b(C39037b.m66370b(aar)).exists()) {
                    AppMethodBeat.m2505o(102667);
                    return false;
                }
                AppMethodBeat.m2505o(102667);
                return true;
            case 3:
                AppMethodBeat.m2505o(102667);
                return true;
            case 4:
                if (new C5728b(C39037b.m66370b(aar)).exists()) {
                    AppMethodBeat.m2505o(102667);
                    return false;
                }
                boolean isNullOrNil = C5046bo.isNullOrNil(aar.wgg);
                AppMethodBeat.m2505o(102667);
                return isNullOrNil;
            case 7:
                if (C5046bo.isNullOrNil(aar.wgg) && C5046bo.isNullOrNil(aar.wgi) && C5046bo.isNullOrNil(aar.wgk) && C5046bo.isNullOrNil(aar.wgk)) {
                    AppMethodBeat.m2505o(102667);
                    return true;
                }
                AppMethodBeat.m2505o(102667);
                return false;
            case 15:
                if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    C4990ab.m7420w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    AppMethodBeat.m2505o(102667);
                    return true;
                } else if (new C5728b(C39037b.m66370b(aar)).exists()) {
                    AppMethodBeat.m2505o(102667);
                    return false;
                } else {
                    AppMethodBeat.m2505o(102667);
                    return true;
                }
            default:
                AppMethodBeat.m2505o(102667);
                return false;
        }
    }

    /* renamed from: u */
    public static boolean m71869u(C27966g c27966g) {
        AppMethodBeat.m2504i(102668);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102668);
            return false;
        } else if (c27966g.field_itemStatus <= 0 || C39037b.m66395g(c27966g)) {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(c27966g.field_localId);
            C5728b c5728b = new C5728b(C39037b.m66370b(C39037b.m66378c(c27966g)));
            switch (c27966g.field_type) {
                case 2:
                case 8:
                    if (!c5728b.exists()) {
                        AppMethodBeat.m2505o(102668);
                        return true;
                    }
                    break;
                case 4:
                    if (C5046bo.isNullOrNil(C39037b.m66378c(c27966g).wgg) && !c5728b.exists()) {
                        AppMethodBeat.m2505o(102668);
                        return true;
                    }
                case 14:
                case 18:
                    if (c27966g.field_id > 0 || iE == null) {
                        if (c27966g.field_favProto != null && c27966g.field_favProto.wiv.size() > 1) {
                            Iterator it = c27966g.field_favProto.wiv.iterator();
                            while (it.hasNext()) {
                                aar aar = (aar) it.next();
                                if (!C5046bo.isNullOrNil(aar.wfZ) && !C5046bo.isNullOrNil(aar.wgb) && !C5730e.m8628ct(C39037b.m66370b(aar))) {
                                    AppMethodBeat.m2505o(102668);
                                    return true;
                                }
                            }
                            break;
                        }
                        AppMethodBeat.m2505o(102668);
                        return false;
                    }
                    AppMethodBeat.m2505o(102668);
                    return false;
                case 16:
                    if (C5046bo.ank(C26373g.m41964Nu().getValue("SIGHTCannotTransmitForFav")) != 0) {
                        C4990ab.m7420w("MicroMsg.FavSendFilter", "can not retransmit short video");
                        AppMethodBeat.m2505o(102668);
                        return false;
                    } else if (!c5728b.exists()) {
                        AppMethodBeat.m2505o(102668);
                        return true;
                    }
                    break;
            }
            AppMethodBeat.m2505o(102668);
            return false;
        } else {
            AppMethodBeat.m2505o(102668);
            return false;
        }
    }
}
