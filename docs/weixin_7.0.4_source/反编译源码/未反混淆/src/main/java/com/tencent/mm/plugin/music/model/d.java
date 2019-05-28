package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.se;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class d {
    public static boolean a(a aVar) {
        AppMethodBeat.i(104882);
        ab.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl);
        if (bo.isNullOrNil(aVar.field_songWapLinkUrl) && bo.isNullOrNil(aVar.field_songWebUrl) && bo.isNullOrNil(aVar.field_songWifiUrl)) {
            AppMethodBeat.o(104882);
            return false;
        }
        AppMethodBeat.o(104882);
        return true;
    }

    public static void a(e eVar, Activity activity) {
        AppMethodBeat.i(104883);
        h.pYm.X(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        cl clVar = new cl();
        abf abf = new abf();
        abl abl = new abl();
        aar aar = new aar();
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(5);
        abl.ml(bo.anU());
        abl.alJ(v(eVar));
        aar.akO(eVar.fKa);
        aar.akP(eVar.fKb);
        aar.akN(eVar.fKc);
        a Tp = e.bUk().Tp(b.K(eVar));
        if (Tp.bUv()) {
            aar.akQ(Tp.field_songHAlbumUrl);
        } else {
            aar.akQ(Tp.field_songAlbumUrl);
        }
        aar.oX(true);
        String u = u(eVar);
        if (com.tencent.mm.vfs.e.ct(u)) {
            aar.akW(u);
        } else {
            aar.oY(true);
        }
        aar.akH(eVar.fJW);
        aar.akI(eVar.fJX);
        aar.LE(7);
        clVar.cvA.title = eVar.fJW;
        clVar.cvA.desc = eVar.fJX;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 7;
        abf.a(abl);
        abf.wiv.add(aar);
        clVar.cvA.activity = activity;
        clVar.cvA.cvH = 3;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(104883);
    }

    public static void S(Activity activity) {
        AppMethodBeat.i(104884);
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        com.tencent.mm.bp.d.b((Context) activity, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(104884);
    }

    public static void b(e eVar, Activity activity) {
        AppMethodBeat.i(104885);
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = eVar.fKc;
        wXMusicObject.musicDataUrl = eVar.fKa;
        wXMusicObject.musicLowBandUrl = eVar.fKb;
        wXMusicObject.musicLowBandDataUrl = eVar.fKb;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = eVar.fJW;
        wXMediaMessage.description = eVar.fJX;
        Bitmap bitmap = null;
        String u = u(eVar);
        if (u != null && com.tencent.mm.vfs.e.ct(u)) {
            int dimension = (int) activity.getResources().getDimension(R.dimen.lw);
            bitmap = com.tencent.mm.sdk.platformtools.d.ap(u, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bo.an(bitmap);
        } else {
            wXMediaMessage.thumbData = bo.an(com.tencent.mm.sdk.platformtools.d.LV(R.drawable.b27));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", eVar.fJU);
        intent.putExtra("Ksnsupload_appid", v(eVar));
        intent.putExtra("Ksnsupload_appname", w(eVar));
        String nW = v.nW("music_player");
        v.Zp().y(nW, true).j("prePublishId", "music_player");
        intent.putExtra("reportSessionId", nW);
        b.gkE.l(intent, activity);
        AppMethodBeat.o(104885);
    }

    public static String u(e eVar) {
        AppMethodBeat.i(104886);
        String str = "";
        a Tp = e.bUk().Tp(b.K(eVar));
        if (Tp == null) {
            AppMethodBeat.o(104886);
        } else {
            str = b.aY(Tp.field_musicId, true);
            if (!com.tencent.mm.vfs.e.ct(str)) {
                switch (eVar.fJS) {
                    case 0:
                        str = o.ahl().I(eVar.fKe, true);
                        break;
                    case 4:
                        kd kdVar = new kd();
                        kdVar.cFz.action = 12;
                        kdVar.cFz.cFE = eVar.fJZ;
                        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                        str = kdVar.cFA.cFG;
                        if (bo.isNullOrNil(str)) {
                            str = eVar.fKe;
                        }
                        if (!com.tencent.mm.vfs.e.ct(str)) {
                            str = b.aY(Tp.field_musicId, false);
                            break;
                        }
                        break;
                    case 5:
                        if (eVar.fKe != null) {
                            str = eVar.fKe;
                            break;
                        }
                        str = "";
                        break;
                    case 6:
                        if (eVar.fKe != null) {
                            str = eVar.fKe;
                            break;
                        }
                        str = "";
                        break;
                    case 7:
                    case 10:
                    case 11:
                        if (eVar.fKe != null) {
                            str = eVar.fKe;
                            break;
                        }
                        str = "";
                        break;
                    default:
                        if (n.qFy != null) {
                            bau bau = new bau();
                            bau.Id = eVar.fKk;
                            bau.wEH = eVar.fJZ;
                            bau.wEI = eVar.fKi;
                            bau.Url = bau.wEH;
                            str = n.qFx.a(bau);
                            break;
                        }
                        break;
                }
            }
            ab.i("MicroMsg.Music.MusicUtil", "real album path = %s", str);
            AppMethodBeat.o(104886);
        }
        return str;
    }

    public static String v(e eVar) {
        AppMethodBeat.i(104887);
        String str = eVar.fKh;
        if (bo.isNullOrNil(str)) {
            switch (eVar.fJS) {
                case 4:
                    str = "wx485a97c844086dc9";
                    break;
                case 5:
                    str = "wx482a4001c37e2b74";
                    break;
            }
        }
        AppMethodBeat.o(104887);
        return str;
    }

    public static String w(e eVar) {
        AppMethodBeat.i(104888);
        String string;
        switch (eVar.fJS) {
            case 0:
            case 1:
            case 8:
                string = ah.getContext().getString(R.string.en4);
                AppMethodBeat.o(104888);
                return string;
            case 4:
                string = ah.getContext().getString(R.string.efe);
                AppMethodBeat.o(104888);
                return string;
            case 5:
                string = ah.getContext().getString(R.string.dy8);
                AppMethodBeat.o(104888);
                return string;
            default:
                string = ah.getContext().getString(R.string.b4t);
                AppMethodBeat.o(104888);
                return string;
        }
    }

    public static void H(String str, String str2, int i) {
        AppMethodBeat.i(104889);
        ab.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", str, str2, Integer.valueOf(i));
        se seVar = new se();
        seVar.cOf.appId = str;
        seVar.cOf.axy = -1;
        seVar.cOf.cOi = i;
        seVar.cOf.userName = str2;
        seVar.cOf.scene = 1056;
        if (i == 1) {
            seVar.cOf.cOl = true;
        }
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(104889);
    }

    public static c S(Context context, int i) {
        AppMethodBeat.i(104890);
        c.a aVar = new c.a(context);
        aVar.PV(R.string.tz);
        aVar.PZ(i);
        aVar.Qc(R.string.g0z).a(null);
        aVar.rc(true);
        c aMb = aVar.aMb();
        aMb.show();
        AppMethodBeat.o(104890);
        return aMb;
    }

    public static int la(String str) {
        int i = 0;
        AppMethodBeat.i(104891);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.valueOf(str).intValue();
                    AppMethodBeat.o(104891);
                    return i;
                }
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "getInt", new Object[0]);
                AppMethodBeat.o(104891);
            }
        }
        AppMethodBeat.o(104891);
        return i;
    }
}
