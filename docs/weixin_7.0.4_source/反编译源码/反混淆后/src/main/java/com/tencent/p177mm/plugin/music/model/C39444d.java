package com.tencent.p177mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.music.model.d */
public final class C39444d {
    /* renamed from: a */
    public static boolean m67386a(C28575a c28575a) {
        AppMethodBeat.m2504i(104882);
        C4990ab.m7411d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", c28575a.field_songWapLinkUrl, c28575a.field_songWebUrl, c28575a.field_songWifiUrl);
        if (C5046bo.isNullOrNil(c28575a.field_songWapLinkUrl) && C5046bo.isNullOrNil(c28575a.field_songWebUrl) && C5046bo.isNullOrNil(c28575a.field_songWifiUrl)) {
            AppMethodBeat.m2505o(104882);
            return false;
        }
        AppMethodBeat.m2505o(104882);
        return true;
    }

    /* renamed from: a */
    public static void m67385a(C9058e c9058e, Activity activity) {
        AppMethodBeat.m2504i(104883);
        C7060h.pYm.mo8374X(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        C45316cl c45316cl = new C45316cl();
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(5);
        abl.mo39136ml(C5046bo.anU());
        abl.alJ(C39444d.m67390v(c9058e));
        aar.akO(c9058e.fKa);
        aar.akP(c9058e.fKb);
        aar.akN(c9058e.fKc);
        C28575a Tp = C39445e.bUk().mo24653Tp(C12673b.m20670K(c9058e));
        if (Tp.bUv()) {
            aar.akQ(Tp.field_songHAlbumUrl);
        } else {
            aar.akQ(Tp.field_songAlbumUrl);
        }
        aar.mo27434oX(true);
        String u = C39444d.m67389u(c9058e);
        if (C5730e.m8628ct(u)) {
            aar.akW(u);
        } else {
            aar.mo27435oY(true);
        }
        aar.akH(c9058e.fJW);
        aar.akI(c9058e.fJX);
        aar.mo27394LE(7);
        c45316cl.cvA.title = c9058e.fJW;
        c45316cl.cvA.desc = c9058e.fJX;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 7;
        abf.mo74737a(abl);
        abf.wiv.add(aar);
        c45316cl.cvA.activity = activity;
        c45316cl.cvA.cvH = 3;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(104883);
    }

    /* renamed from: S */
    public static void m67384S(Activity activity) {
        AppMethodBeat.m2504i(104884);
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        C25985d.m41466b((Context) activity, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.m2505o(104884);
    }

    /* renamed from: b */
    public static void m67387b(C9058e c9058e, Activity activity) {
        AppMethodBeat.m2504i(104885);
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = c9058e.fKc;
        wXMusicObject.musicDataUrl = c9058e.fKa;
        wXMusicObject.musicLowBandUrl = c9058e.fKb;
        wXMusicObject.musicLowBandDataUrl = c9058e.fKb;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = c9058e.fJW;
        wXMediaMessage.description = c9058e.fJX;
        Bitmap bitmap = null;
        String u = C39444d.m67389u(c9058e);
        if (u != null && C5730e.m8628ct(u)) {
            int dimension = (int) activity.getResources().getDimension(C25738R.dimen.f9972lw);
            bitmap = C5056d.m7642ap(u, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = C5046bo.m7522an(bitmap);
        } else {
            wXMediaMessage.thumbData = C5046bo.m7522an(C5056d.m7610LV(C25738R.drawable.b27));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", c9058e.fJU);
        intent.putExtra("Ksnsupload_appid", C39444d.m67390v(c9058e));
        intent.putExtra("Ksnsupload_appname", C39444d.m67391w(c9058e));
        String nW = C37922v.m64078nW("music_player");
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "music_player");
        intent.putExtra("reportSessionId", nW);
        C39441b.gkE.mo38927l(intent, activity);
        AppMethodBeat.m2505o(104885);
    }

    /* renamed from: u */
    public static String m67389u(C9058e c9058e) {
        AppMethodBeat.m2504i(104886);
        String str = "";
        C28575a Tp = C39445e.bUk().mo24653Tp(C12673b.m20670K(c9058e));
        if (Tp == null) {
            AppMethodBeat.m2505o(104886);
        } else {
            str = C12673b.m20675aY(Tp.field_musicId, true);
            if (!C5730e.m8628ct(str)) {
                switch (c9058e.fJS) {
                    case 0:
                        str = C32291o.ahl().mo73074I(c9058e.fKe, true);
                        break;
                    case 4:
                        C45337kd c45337kd = new C45337kd();
                        c45337kd.cFz.action = 12;
                        c45337kd.cFz.cFE = c9058e.fJZ;
                        C4879a.xxA.mo10055m(c45337kd);
                        str = c45337kd.cFA.cFG;
                        if (C5046bo.isNullOrNil(str)) {
                            str = c9058e.fKe;
                        }
                        if (!C5730e.m8628ct(str)) {
                            str = C12673b.m20675aY(Tp.field_musicId, false);
                            break;
                        }
                        break;
                    case 5:
                        if (c9058e.fKe != null) {
                            str = c9058e.fKe;
                            break;
                        }
                        str = "";
                        break;
                    case 6:
                        if (c9058e.fKe != null) {
                            str = c9058e.fKe;
                            break;
                        }
                        str = "";
                        break;
                    case 7:
                    case 10:
                    case 11:
                        if (c9058e.fKe != null) {
                            str = c9058e.fKe;
                            break;
                        }
                        str = "";
                        break;
                    default:
                        if (C21877n.qFy != null) {
                            bau bau = new bau();
                            bau.f17915Id = c9058e.fKk;
                            bau.wEH = c9058e.fJZ;
                            bau.wEI = c9058e.fKi;
                            bau.Url = bau.wEH;
                            str = C21877n.qFx.mo37437a(bau);
                            break;
                        }
                        break;
                }
            }
            C4990ab.m7417i("MicroMsg.Music.MusicUtil", "real album path = %s", str);
            AppMethodBeat.m2505o(104886);
        }
        return str;
    }

    /* renamed from: v */
    public static String m67390v(C9058e c9058e) {
        AppMethodBeat.m2504i(104887);
        String str = c9058e.fKh;
        if (C5046bo.isNullOrNil(str)) {
            switch (c9058e.fJS) {
                case 4:
                    str = "wx485a97c844086dc9";
                    break;
                case 5:
                    str = "wx482a4001c37e2b74";
                    break;
            }
        }
        AppMethodBeat.m2505o(104887);
        return str;
    }

    /* renamed from: w */
    public static String m67391w(C9058e c9058e) {
        AppMethodBeat.m2504i(104888);
        String string;
        switch (c9058e.fJS) {
            case 0:
            case 1:
            case 8:
                string = C4996ah.getContext().getString(C25738R.string.en4);
                AppMethodBeat.m2505o(104888);
                return string;
            case 4:
                string = C4996ah.getContext().getString(C25738R.string.efe);
                AppMethodBeat.m2505o(104888);
                return string;
            case 5:
                string = C4996ah.getContext().getString(C25738R.string.dy8);
                AppMethodBeat.m2505o(104888);
                return string;
            default:
                string = C4996ah.getContext().getString(C25738R.string.b4t);
                AppMethodBeat.m2505o(104888);
                return string;
        }
    }

    /* renamed from: H */
    public static void m67382H(String str, String str2, int i) {
        AppMethodBeat.m2504i(104889);
        C4990ab.m7417i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", str, str2, Integer.valueOf(i));
        C32628se c32628se = new C32628se();
        c32628se.cOf.appId = str;
        c32628se.cOf.axy = -1;
        c32628se.cOf.cOi = i;
        c32628se.cOf.userName = str2;
        c32628se.cOf.scene = 1056;
        if (i == 1) {
            c32628se.cOf.cOl = true;
        }
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(104889);
    }

    /* renamed from: S */
    public static C5653c m67383S(Context context, int i) {
        AppMethodBeat.m2504i(104890);
        C5652a c5652a = new C5652a(context);
        c5652a.mo11446PV(C25738R.string.f9238tz);
        c5652a.mo11450PZ(i);
        c5652a.mo11453Qc(C25738R.string.g0z).mo11457a(null);
        c5652a.mo11482rc(true);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(104890);
        return aMb;
    }

    /* renamed from: la */
    public static int m67388la(String str) {
        int i = 0;
        AppMethodBeat.m2504i(104891);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.valueOf(str).intValue();
                    AppMethodBeat.m2505o(104891);
                    return i;
                }
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getInt", new Object[0]);
                AppMethodBeat.m2505o(104891);
            }
        }
        AppMethodBeat.m2505o(104891);
        return i;
    }
}
