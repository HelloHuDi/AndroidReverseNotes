package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C18313ld;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aaz;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.g */
public final class C3105g {
    /* renamed from: a */
    public static void m5347a(MMActivity mMActivity, long j, C27969a c27969a) {
        AppMethodBeat.m2504i(74031);
        try {
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
            C7060h.pYm.mo8381e(15378, Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
            C4990ab.m7411d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", Integer.valueOf(iE.field_id), Integer.valueOf(iE.field_type));
            iE.field_flag = 0;
            iE.field_updateTime = System.currentTimeMillis();
            iE.field_localId = -1;
            iE.field_sourceType = 6;
            if (iE.field_favProto.wit != null) {
                iE.field_favProto.wit.alF("");
                iE.field_favProto.wit.mo39126LN(6);
                iE.field_favProto.wit.alD(C1853r.m3846Yz());
            }
            iE.field_fromUser = C1853r.m3846Yz();
            if (iE.field_type == 1) {
                iE.field_favProto.mo74738aE(new LinkedList());
                C3105g.m5346a(iE, 0, C3105g.m5344LZ(iE.field_favProto.desc));
            } else if (iE.field_favProto.wiv != null) {
                int i = 1;
                int i2 = 0;
                while (i2 < iE.field_favProto.wiv.size()) {
                    String b;
                    String c;
                    int i3;
                    aar aar = (aar) iE.field_favProto.wiv.get(i2);
                    if (!(iE.field_type == 18 && aar.whb.equals("WeNoteHtmlFile"))) {
                        b = C39037b.m66370b(aar);
                        c = C39037b.m66379c(aar);
                        aar.akU(C39037b.m66382cf(aar.toString(), 18));
                        String b2 = C39037b.m66370b(aar);
                        String c2 = C39037b.m66379c(aar);
                        if (!(C5046bo.isNullOrNil(b) || C5046bo.isNullOrNil(b2) || !C5730e.m8628ct(b))) {
                            C5730e.m8644y(b, b2);
                        }
                        if (!(C5046bo.isNullOrNil(c) || C5046bo.isNullOrNil(c2) || !C5730e.m8628ct(c))) {
                            C5730e.m8644y(c, c2);
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
                            C3105g.m5346a(iE, i2, C3105g.m5344LZ(aar.wgV + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
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
                            String a = C3105g.m5345a(mMActivity, aar);
                            if (a == null) {
                                a = "\n\n";
                            } else {
                                a = new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(a).append("\n\n").toString();
                            }
                            C3105g.m5346a(iE, i2, C3105g.m5344LZ(a));
                        }
                        if (aar.dataType == 3) {
                            aar.mo27394LE(20);
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
                        aar.akI(C3105g.m5344LZ(b + c + IOUtils.LINE_SEPARATOR_UNIX));
                        i3 = i2;
                    } else {
                        if (!C5046bo.isNullOrNil(aar.desc)) {
                            aar.akI(C3105g.m5344LZ(aar.desc));
                            i3 = i2;
                        }
                        i3 = i2;
                    }
                    i2 = i3 + 1;
                }
            }
            iE.field_localId = System.currentTimeMillis();
            iE.field_type = 18;
            iE.field_xml = C27966g.m44521s(iE);
            abh abh = new abh();
            if (c27969a != null) {
                abh.scene = c27969a.scene;
                abh.jSW = c27969a.jSW;
                abh.index = c27969a.index;
                abh.query = c27969a.query;
                abh.cvF = c27969a.sid;
                abh.mfg = c27969a.mfg;
            }
            C18313ld c18313ld = new C18313ld();
            c18313ld.cGU.field_localId = iE.field_localId;
            c18313ld.cGU.cHa = 5;
            c18313ld.cGU.cGW = iE.field_xml;
            c18313ld.cGU.context = mMActivity;
            Bundle bundle = new Bundle();
            aaz aaz = iE.field_favProto.vzK;
            if (aaz != null) {
                bundle.putString("noteauthor", aaz.wim);
                bundle.putString("noteeditor", aaz.win);
            }
            bundle.putLong("edittime", iE.field_updateTime);
            c18313ld.cGU.cGZ = bundle;
            c18313ld.cGU.field_favProto = iE.field_favProto;
            c18313ld.cGU.type = 2;
            c18313ld.cGU.cHc = true;
            c18313ld.cGU.cHd = abh;
            C4879a.xxA.mo10055m(c18313ld);
            mMActivity.finish();
            AppMethodBeat.m2505o(74031);
        } catch (Throwable th) {
            Toast.makeText(mMActivity, mMActivity.getString(C25738R.string.br9), 0).show();
            AppMethodBeat.m2505o(74031);
        }
    }

    /* renamed from: LZ */
    private static String m5344LZ(String str) {
        AppMethodBeat.m2504i(74032);
        String replaceAll = str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
        AppMethodBeat.m2505o(74032);
        return replaceAll;
    }

    /* renamed from: a */
    private static void m5346a(C27966g c27966g, int i, String str) {
        AppMethodBeat.m2504i(74034);
        aar aar = new aar();
        aar.mo27394LE(1);
        aar.akI(str);
        c27966g.field_favProto.wiv.add(i, aar);
        AppMethodBeat.m2505o(74034);
    }

    /* renamed from: a */
    private static String m5345a(Context context, aar aar) {
        AppMethodBeat.m2504i(74033);
        String str;
        switch (aar.dataType) {
            case 5:
                str = "";
                if (!(aar.wgT == null || aar.wgT.whw == null)) {
                    str = aar.wgT.whw.link;
                }
                if (C5046bo.isNullOrNil(str)) {
                    str = aar.wgg;
                    AppMethodBeat.m2505o(74033);
                    return str;
                }
                AppMethodBeat.m2505o(74033);
                return str;
            case 7:
                str = aar.desc;
                if (!C5046bo.isNullOrNil(aar.title)) {
                    str = aar.title + " " + str;
                }
                AppMethodBeat.m2505o(74033);
                return str;
            case 16:
                String string = context.getString(C25738R.string.f9145qw);
                try {
                    C1720g.m3537RQ();
                    str = string + " " + ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(aar.desc).nickname;
                } catch (Exception e) {
                    str = string;
                }
                AppMethodBeat.m2505o(74033);
                return str;
            case 17:
                str = context.getString(C25738R.string.f9212t5);
                AppMethodBeat.m2505o(74033);
                return str;
            case 19:
                str = context.getString(C25738R.string.f8821fz);
                try {
                    str = str + " " + aar.wgT.whN.wfO;
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(74033);
                return str;
            case 20:
                str = context.getString(C25738R.string.f9256ug) + " " + C34171j.m56018B(context, aar.duration / 1000) + IOUtils.LINE_SEPARATOR_UNIX;
                AppMethodBeat.m2505o(74033);
                return str;
            default:
                str = aar.desc;
                AppMethodBeat.m2505o(74033);
                return str;
        }
    }
}
