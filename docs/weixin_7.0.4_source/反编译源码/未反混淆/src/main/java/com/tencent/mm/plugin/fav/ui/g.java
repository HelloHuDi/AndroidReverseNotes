package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;

public final class g {
    public static void a(MMActivity mMActivity, long j, a aVar) {
        AppMethodBeat.i(74031);
        try {
            com.tencent.mm.plugin.fav.a.g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
            h.pYm.e(15378, Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
            ab.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
            iE.field_flag = 0;
            iE.field_updateTime = System.currentTimeMillis();
            iE.field_localId = -1;
            iE.field_sourceType = 6;
            if (iE.field_favProto.wit != null) {
                iE.field_favProto.wit.alF("");
                iE.field_favProto.wit.LN(6);
                iE.field_favProto.wit.alD(r.Yz());
            }
            iE.field_fromUser = r.Yz();
            if (iE.field_type == 1) {
                iE.field_favProto.aE(new LinkedList());
                a(iE, 0, LZ(iE.field_favProto.desc));
            } else if (iE.field_favProto.wiv != null) {
                int i = 1;
                int i2 = 0;
                while (i2 < iE.field_favProto.wiv.size()) {
                    String b;
                    String c;
                    int i3;
                    aar aar = (aar) iE.field_favProto.wiv.get(i2);
                    if (!(iE.field_type == 18 && aar.whb.equals("WeNoteHtmlFile"))) {
                        b = b.b(aar);
                        c = b.c(aar);
                        aar.akU(b.cf(aar.toString(), 18));
                        String b2 = b.b(aar);
                        String c2 = b.c(aar);
                        if (!(bo.isNullOrNil(b) || bo.isNullOrNil(b2) || !e.ct(b))) {
                            e.y(b, b2);
                        }
                        if (!(bo.isNullOrNil(c) || bo.isNullOrNil(c2) || !e.ct(c))) {
                            e.y(c, c2);
                        }
                    }
                    if (iE.field_type == 18) {
                        if (aar.dataType == 20) {
                            aar.akL("");
                            aar.akM("");
                        }
                        i3 = i2;
                    } else if (aar.dataType != 1) {
                        Object obj;
                        int i4 = i + 1;
                        aar.ale("WeNote_" + i);
                        if (iE.field_type == 14 && aar.wgV != null) {
                            a(iE, i2, LZ(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                            i2++;
                        }
                        i = aar.dataType;
                        if (i == 1 || i == 2 || i == 3 || i == 6 || i == 8 || i == 4 || i == 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            iE.field_favProto.wiv.remove(i2);
                            String a = a(mMActivity, aar);
                            if (a == null) {
                                a = "\n\n";
                            } else {
                                a = new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(a).append("\n\n").toString();
                            }
                            a(iE, i2, LZ(a));
                        }
                        if (aar.dataType == 3) {
                            aar.LE(20);
                            i3 = i2;
                            i = i4;
                        } else {
                            i3 = i2;
                            i = i4;
                        }
                    } else if (iE.field_type == 14) {
                        if (aar.desc == null) {
                            c = IOUtils.LINE_SEPARATOR_UNIX;
                        } else {
                            c = aar.desc + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        if (aar.wgV == null) {
                            b = "";
                        } else {
                            b = aar.wgV + ":\n";
                        }
                        aar.akI(LZ(b + c + IOUtils.LINE_SEPARATOR_UNIX));
                        i3 = i2;
                    } else {
                        if (!bo.isNullOrNil(aar.desc)) {
                            aar.akI(LZ(aar.desc));
                            i3 = i2;
                        }
                        i3 = i2;
                    }
                    i2 = i3 + 1;
                }
            }
            iE.field_localId = System.currentTimeMillis();
            iE.field_type = 18;
            iE.field_xml = com.tencent.mm.plugin.fav.a.g.s(iE);
            abh abh = new abh();
            if (aVar != null) {
                abh.scene = aVar.scene;
                abh.jSW = aVar.jSW;
                abh.index = aVar.index;
                abh.query = aVar.query;
                abh.cvF = aVar.sid;
                abh.mfg = aVar.mfg;
            }
            ld ldVar = new ld();
            ldVar.cGU.field_localId = iE.field_localId;
            ldVar.cGU.cHa = 5;
            ldVar.cGU.cGW = iE.field_xml;
            ldVar.cGU.context = mMActivity;
            Bundle bundle = new Bundle();
            aaz aaz = iE.field_favProto.vzK;
            if (aaz != null) {
                bundle.putString("noteauthor", aaz.wim);
                bundle.putString("noteeditor", aaz.win);
            }
            bundle.putLong("edittime", iE.field_updateTime);
            ldVar.cGU.cGZ = bundle;
            ldVar.cGU.field_favProto = iE.field_favProto;
            ldVar.cGU.type = 2;
            ldVar.cGU.cHc = true;
            ldVar.cGU.cHd = abh;
            com.tencent.mm.sdk.b.a.xxA.m(ldVar);
            mMActivity.finish();
            AppMethodBeat.o(74031);
        } catch (Throwable th) {
            Toast.makeText(mMActivity, mMActivity.getString(R.string.br9), 0).show();
            AppMethodBeat.o(74031);
        }
    }

    private static String LZ(String str) {
        AppMethodBeat.i(74032);
        String replaceAll = str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
        AppMethodBeat.o(74032);
        return replaceAll;
    }

    private static void a(com.tencent.mm.plugin.fav.a.g gVar, int i, String str) {
        AppMethodBeat.i(74034);
        aar aar = new aar();
        aar.LE(1);
        aar.akI(str);
        gVar.field_favProto.wiv.add(i, aar);
        AppMethodBeat.o(74034);
    }

    private static String a(Context context, aar aar) {
        AppMethodBeat.i(74033);
        String str;
        switch (aar.dataType) {
            case 5:
                str = "";
                if (!(aar.wgT == null || aar.wgT.whw == null)) {
                    str = aar.wgT.whw.link;
                }
                if (bo.isNullOrNil(str)) {
                    str = aar.wgg;
                    AppMethodBeat.o(74033);
                    return str;
                }
                AppMethodBeat.o(74033);
                return str;
            case 7:
                str = aar.desc;
                if (!bo.isNullOrNil(aar.title)) {
                    str = aar.title + " " + str;
                }
                AppMethodBeat.o(74033);
                return str;
            case 16:
                String string = context.getString(R.string.qw);
                try {
                    com.tencent.mm.kernel.g.RQ();
                    str = string + " " + ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rn(aar.desc).nickname;
                } catch (Exception e) {
                    str = string;
                }
                AppMethodBeat.o(74033);
                return str;
            case 17:
                str = context.getString(R.string.t5);
                AppMethodBeat.o(74033);
                return str;
            case 19:
                str = context.getString(R.string.fz);
                try {
                    str = str + " " + aar.wgT.whN.wfO;
                } catch (Exception e2) {
                }
                AppMethodBeat.o(74033);
                return str;
            case 20:
                str = context.getString(R.string.ug) + " " + j.B(context, aar.duration / 1000) + IOUtils.LINE_SEPARATOR_UNIX;
                AppMethodBeat.o(74033);
                return str;
            default:
                str = aar.desc;
                AppMethodBeat.o(74033);
                return str;
        }
    }
}
