package com.tencent.mm.plugin.choosemsgfile.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b {
    private static ae<Integer, c> kvu = new ae(3);

    public static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, bi biVar, String str, String str2, String str3) {
        AppMethodBeat.i(54392);
        if (bo.isNullOrNil(str2)) {
            str2 = "all";
        }
        List HJ = HJ(str3);
        String toLowerCase = str2.toLowerCase();
        Object obj = -1;
        switch (toLowerCase.hashCode()) {
            case 96673:
                if (toLowerCase.equals("all")) {
                    obj = null;
                    break;
                }
                break;
            case 3143036:
                if (toLowerCase.equals("file")) {
                    obj = 3;
                    break;
                }
                break;
            case 100313435:
                if (toLowerCase.equals("image")) {
                    obj = 1;
                    break;
                }
                break;
            case 112202875:
                if (toLowerCase.equals("video")) {
                    obj = 2;
                    break;
                }
                break;
        }
        a a;
        switch (obj) {
            case null:
                a = a(cVar, biVar, str, HJ);
                if (a == null) {
                    a = b(cVar, biVar);
                    if (a == null) {
                        a = a(cVar, biVar);
                    }
                }
                AppMethodBeat.o(54392);
                return a;
            case 1:
                a = a(cVar, biVar);
                AppMethodBeat.o(54392);
                return a;
            case 2:
                a = b(cVar, biVar);
                AppMethodBeat.o(54392);
                return a;
            case 3:
                a = a(cVar, biVar, str, HJ);
                AppMethodBeat.o(54392);
                return a;
            default:
                AppMethodBeat.o(54392);
                return null;
        }
    }

    public static List<String> HJ(String str) {
        AppMethodBeat.i(54393);
        ArrayList arrayList = new ArrayList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(54393);
        } else {
            try {
                f fVar = new f(str);
                for (int i = 0; i < fVar.length(); i++) {
                    String optString = fVar.optString(i, "");
                    if (!bo.isNullOrNil(optString)) {
                        arrayList.add(optString);
                    }
                }
            } catch (g e) {
                ab.printErrStackTrace("MicroMsg.MsgFileUtils", e, "", new Object[0]);
            }
            AppMethodBeat.o(54393);
        }
        return arrayList;
    }

    private static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, bi biVar, String str, List<String> list) {
        AppMethodBeat.i(54394);
        if (biVar.bAA()) {
            String str2 = biVar.field_content;
            if (str2 != null) {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str2);
                if (me != null && me.type == 6) {
                    a fVar = new com.tencent.mm.plugin.choosemsgfile.b.b.f(cVar, biVar, str);
                    if (list == null || list.size() == 0) {
                        AppMethodBeat.o(54394);
                        return fVar;
                    }
                    for (String str22 : list) {
                        if (fVar.getFileName().endsWith(str22)) {
                            AppMethodBeat.o(54394);
                            return fVar;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(54394);
        return null;
    }

    private static a a(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, bi biVar) {
        AppMethodBeat.i(54395);
        if (biVar.dtA()) {
            com.tencent.mm.plugin.choosemsgfile.b.b.b bVar = new com.tencent.mm.plugin.choosemsgfile.b.b.b(cVar, biVar);
            AppMethodBeat.o(54395);
            return bVar;
        } else if (biVar.drE()) {
            a gVar = new com.tencent.mm.plugin.choosemsgfile.b.b.g(cVar, biVar);
            AppMethodBeat.o(54395);
            return gVar;
        } else {
            AppMethodBeat.o(54395);
            return null;
        }
    }

    private static a b(com.tencent.mm.plugin.choosemsgfile.b.c.c cVar, bi biVar) {
        AppMethodBeat.i(54396);
        if (biVar.bws() || biVar.bwt()) {
            h hVar = new h(cVar, biVar);
            AppMethodBeat.o(54396);
            return hVar;
        }
        AppMethodBeat.o(54396);
        return null;
    }

    public static String b(bi biVar, boolean z) {
        String str = null;
        AppMethodBeat.i(54397);
        if (biVar == null) {
            AppMethodBeat.o(54397);
            return null;
        } else if (biVar.field_isSend == 1) {
            str = r.Yz();
            AppMethodBeat.o(54397);
            return str;
        } else {
            if (z) {
                str = bf.oy(biVar.field_content);
            }
            if (bo.isNullOrNil(str)) {
                str = biVar.field_talker;
            }
            AppMethodBeat.o(54397);
            return str;
        }
    }

    public static String ha(long j) {
        AppMethodBeat.i(54398);
        String a = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(j), ah.getContext());
        AppMethodBeat.o(54398);
        return a;
    }

    public static long hb(long j) {
        AppMethodBeat.i(54399);
        long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(j));
        AppMethodBeat.o(54399);
        return b;
    }

    static {
        AppMethodBeat.i(54410);
        AppMethodBeat.o(54410);
    }

    public static final c dy(Context context) {
        AppMethodBeat.i(54400);
        c cVar = (c) kvu.get(Integer.valueOf(4));
        if (cVar == null) {
            c.a aVar = new c.a();
            aVar.fHe = 1;
            aVar.eQa = true;
            aVar.ePO = com.tencent.mm.bz.a.gd(context) / 4;
            aVar.ePN = com.tencent.mm.bz.a.gd(context) / 4;
            aVar.ePV = R.color.wm;
            cVar = aVar.ahG();
            kvu.put(Integer.valueOf(4), cVar);
        }
        AppMethodBeat.o(54400);
        return cVar;
    }

    public static void a(Context context, View view, a aVar) {
        AppMethodBeat.i(54401);
        Intent intent = new Intent();
        if (aVar == null) {
            ab.e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
            AppMethodBeat.o(54401);
            return;
        }
        bi biVar = aVar.kua;
        if (biVar == null) {
            ab.e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
            AppMethodBeat.o(54401);
            return;
        }
        int i = context.getResources().getConfiguration().orientation;
        int i2 = 0;
        int i3 = 0;
        int[] iArr = new int[2];
        if (view != null) {
            i2 = view.getWidth();
            i3 = view.getHeight();
            view.getLocationInWindow(iArr);
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", biVar.field_msgId).putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId).putExtra("img_gallery_talker", biVar.field_talker).putExtra("img_gallery_chatroom_name", biVar.field_talker).putExtra("img_gallery_orientation", i).putExtra("show_enter_grid", false).putExtra("img_gallery_enter_from_scene", 1);
        if (view != null) {
            intent.putExtra("img_gallery_width", i2).putExtra("img_gallery_height", i3).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        d.f(context, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) context).overridePendingTransition(0, 0);
        AppMethodBeat.o(54401);
    }

    public static String HK(String str) {
        AppMethodBeat.i(54402);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.MsgFileUtils", "type is null, use default type");
            str = "all";
            AppMethodBeat.o(54402);
            return str;
        } else if ("all".equals(str) || "image".equals(str) || "video".equals(str) || "file".equals(str)) {
            ab.i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
            AppMethodBeat.o(54402);
            return str;
        } else {
            str = "all";
            AppMethodBeat.o(54402);
            return str;
        }
    }

    public static String mI(String str) {
        AppMethodBeat.i(54403);
        ad aoO;
        String str2;
        if (t.kH(str)) {
            aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
            if (aoO == null || bo.isNullOrNil(aoO.field_nickname)) {
                u oa = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(str);
                if (oa == null) {
                    ab.e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", str);
                    str2 = "";
                    AppMethodBeat.o(54403);
                    return str2;
                }
                str2 = oa.field_displayname;
                AppMethodBeat.o(54403);
                return str2;
            }
            str2 = aoO.field_nickname;
            AppMethodBeat.o(54403);
            return str2;
        }
        aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            ab.e("MicroMsg.MsgFileUtils", "%s, contact is null", str);
            str2 = "";
            AppMethodBeat.o(54403);
            return str2;
        }
        str2 = aoO.field_nickname;
        AppMethodBeat.o(54403);
        return str2;
    }

    public static void f(Context context, long j) {
        AppMethodBeat.i(54404);
        if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            Intent intent = new Intent();
            intent.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", j);
            intent.putExtra("scene", 1);
            context.startActivity(intent);
            AppMethodBeat.o(54404);
            return;
        }
        com.tencent.mm.ui.base.t.hO(context);
        AppMethodBeat.o(54404);
    }

    public static String HL(String str) {
        AppMethodBeat.i(54405);
        Object obj = -1;
        switch (str.hashCode()) {
            case -1069324867:
                if (str.equals("mp3pro")) {
                    obj = 10;
                    break;
                }
                break;
            case -810722925:
                if (str.equals("vorbis")) {
                    obj = 15;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    obj = 61;
                    break;
                }
                break;
            case 1827:
                if (str.equals("7z")) {
                    obj = 58;
                    break;
                }
                break;
            case 3124:
                if (str.equals("au")) {
                    obj = 16;
                    break;
                }
                break;
            case 3169:
                if (str.equals("cd")) {
                    obj = 12;
                    break;
                }
                break;
            case 3479:
                if (str.equals("md")) {
                    obj = 13;
                    break;
                }
                break;
            case 3631:
                if (str.equals("ra")) {
                    obj = 44;
                    break;
                }
                break;
            case 3643:
                if (str.equals("rm")) {
                    obj = 43;
                    break;
                }
                break;
            case 3798:
                if (str.equals("wm")) {
                    obj = 39;
                    break;
                }
                break;
            case 52316:
                if (str.equals("3gp")) {
                    obj = 40;
                    break;
                }
                break;
            case 96323:
                if (str.equals("aac")) {
                    obj = 24;
                    break;
                }
                break;
            case 96574:
                if (str.equals("aif")) {
                    obj = 27;
                    break;
                }
                break;
            case 96710:
                if (str.equals("amr")) {
                    obj = 17;
                    break;
                }
                break;
            case 96790:
                if (str.equals("ape")) {
                    obj = 25;
                    break;
                }
                break;
            case 96884:
                if (str.equals("asf")) {
                    obj = 34;
                    break;
                }
                break;
            case 96902:
                if (str.equals("asx")) {
                    obj = 33;
                    break;
                }
                break;
            case 96980:
                if (str.equals("avi")) {
                    obj = 28;
                    break;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    obj = 54;
                    break;
                }
                break;
            case 98244:
                if (str.equals("cab")) {
                    obj = 60;
                    break;
                }
                break;
            case 99453:
                if (str.equals("dib")) {
                    obj = 50;
                    break;
                }
                break;
            case 99640:
                if (str.equals("doc")) {
                    obj = 2;
                    break;
                }
                break;
            case 99752:
                if (str.equals("f4v")) {
                    obj = 35;
                    break;
                }
                break;
            case 101488:
                if (str.equals("flv")) {
                    obj = 36;
                    break;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    obj = 55;
                    break;
                }
                break;
            case 104581:
                if (str.equals("iso")) {
                    obj = 59;
                    break;
                }
                break;
            case 105439:
                if (str.equals("jpe")) {
                    obj = 49;
                    break;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    obj = 52;
                    break;
                }
                break;
            case 106479:
                if (str.equals("m4v")) {
                    obj = 29;
                    break;
                }
                break;
            case 108104:
                if (str.equals("mid")) {
                    obj = 21;
                    break;
                }
                break;
            case 108184:
                if (str.equals("mkv")) {
                    obj = 37;
                    break;
                }
                break;
            case 108230:
                if (str.equals("mmf")) {
                    obj = 20;
                    break;
                }
                break;
            case 108272:
                if (str.equals("mp3")) {
                    obj = 23;
                    break;
                }
                break;
            case 108273:
                if (str.equals("mp4")) {
                    obj = 41;
                    break;
                }
                break;
            case 108290:
                if (str.equals("mod")) {
                    obj = 14;
                    break;
                }
                break;
            case 108322:
                if (str.equals("mpe")) {
                    obj = 32;
                    break;
                }
                break;
            case 110834:
                if (str.equals("pdf")) {
                    obj = 4;
                    break;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    obj = 53;
                    break;
                }
                break;
            case 111220:
                if (str.equals("ppt")) {
                    obj = 7;
                    break;
                }
                break;
            case 112670:
                if (str.equals("ram")) {
                    obj = 45;
                    break;
                }
                break;
            case 112675:
                if (str.equals("rar")) {
                    obj = 56;
                    break;
                }
                break;
            case 113252:
                if (str.equals("rtf")) {
                    obj = 1;
                    break;
                }
                break;
            case 114833:
                if (str.equals("tif")) {
                    obj = 48;
                    break;
                }
                break;
            case 115312:
                if (str.equals("txt")) {
                    obj = null;
                    break;
                }
                break;
            case 116079:
                if (str.equals("url")) {
                    obj = 9;
                    break;
                }
                break;
            case 116937:
                if (str.equals("vob")) {
                    obj = 30;
                    break;
                }
                break;
            case 117003:
                if (str.equals("vqf")) {
                    obj = 11;
                    break;
                }
                break;
            case 117835:
                if (str.equals("wma")) {
                    obj = 19;
                    break;
                }
                break;
            case 117856:
                if (str.equals("wmv")) {
                    obj = 38;
                    break;
                }
                break;
            case 118783:
                if (str.equals("xls")) {
                    obj = 5;
                    break;
                }
                break;
            case 120609:
                if (str.equals("zip")) {
                    obj = 57;
                    break;
                }
                break;
            case 2993896:
                if (str.equals("aiff")) {
                    obj = 26;
                    break;
                }
                break;
            case 3088960:
                if (str.equals("docx")) {
                    obj = 3;
                    break;
                }
                break;
            case 3259225:
                if (str.equals("jfif")) {
                    obj = 46;
                    break;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    obj = 51;
                    break;
                }
                break;
            case 3351329:
                if (str.equals("midi")) {
                    obj = 22;
                    break;
                }
                break;
            case 3358085:
                if (str.equals("mpeg")) {
                    obj = 31;
                    break;
                }
                break;
            case 3447940:
                if (str.equals("pptx")) {
                    obj = 8;
                    break;
                }
                break;
            case 3504679:
                if (str.equals("rmvb")) {
                    obj = 42;
                    break;
                }
                break;
            case 3530325:
                if (str.equals("silk")) {
                    obj = 18;
                    break;
                }
                break;
            case 3559925:
                if (str.equals("tiff")) {
                    obj = 47;
                    break;
                }
                break;
            case 3682393:
                if (str.equals("xlsx")) {
                    obj = 6;
                    break;
                }
                break;
        }
        String str2;
        switch (obj) {
            case null:
            case 1:
            case 2:
            case 3:
                str2 = "#3980c1";
                AppMethodBeat.o(54405);
                return str2;
            case 4:
                str2 = "#c84e3a";
                AppMethodBeat.o(54405);
                return str2;
            case 5:
            case 6:
                str2 = "#278453";
                AppMethodBeat.o(54405);
                return str2;
            case 7:
            case 8:
                str2 = "#ff7a42";
                AppMethodBeat.o(54405);
                return str2;
            case 9:
                str2 = "#33B0D6";
                AppMethodBeat.o(54405);
                return str2;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                str2 = "#42AA73";
                AppMethodBeat.o(54405);
                return str2;
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                str2 = "#6781F0";
                AppMethodBeat.o(54405);
                return str2;
            default:
                str2 = "#888888";
                AppMethodBeat.o(54405);
                return str2;
        }
    }

    public static void a(int i, int i2, Intent intent, com.tencent.mm.choosemsgfile.compat.a.a aVar) {
        AppMethodBeat.i(54406);
        if (i == 291) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        ab.e("MicroMsg.MsgFileUtils", "data is null");
                        a(aVar, "data is null");
                        AppMethodBeat.o(54406);
                        return;
                    }
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("FILEPATHS");
                    if (parcelableArrayListExtra == null) {
                        ab.e("MicroMsg.MsgFileUtils", "msgFiles is null");
                        a(aVar, "msgFiles is null");
                        AppMethodBeat.o(54406);
                        return;
                    }
                    if (aVar != null) {
                        aVar.a(-1, "", parcelableArrayListExtra);
                    }
                    AppMethodBeat.o(54406);
                    return;
                case 0:
                    if (aVar != null) {
                        aVar.a(0, "", null);
                        break;
                    }
                    break;
                case 1:
                    if (intent == null) {
                        ab.e("MicroMsg.MsgFileUtils", "data is null");
                        a(aVar, "data is null");
                        AppMethodBeat.o(54406);
                        return;
                    }
                    a(aVar, intent.getStringExtra("ERRMSG"));
                    AppMethodBeat.o(54406);
                    return;
            }
        }
        AppMethodBeat.o(54406);
    }

    private static void a(com.tencent.mm.choosemsgfile.compat.a.a aVar, String str) {
        AppMethodBeat.i(54407);
        if (aVar != null) {
            aVar.a(1, str, null);
        }
        AppMethodBeat.o(54407);
    }

    public static String cv(String str) {
        AppMethodBeat.i(54408);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(54408);
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            str2 = "";
            AppMethodBeat.o(54408);
            return str2;
        }
        str2 = str.substring(lastIndexOf + 1);
        AppMethodBeat.o(54408);
        return str2;
    }

    public static void I(Context context, int i) {
        AppMethodBeat.i(54409);
        String format = String.format(context.getString(R.string.aph), new Object[]{Integer.valueOf(i)});
        e.a aVar = new e.a(context);
        aVar.asL(format).re(false);
        aVar.b(new e.c() {
            public final void d(boolean z, String str) {
            }
        }).show();
        AppMethodBeat.o(54409);
    }
}
