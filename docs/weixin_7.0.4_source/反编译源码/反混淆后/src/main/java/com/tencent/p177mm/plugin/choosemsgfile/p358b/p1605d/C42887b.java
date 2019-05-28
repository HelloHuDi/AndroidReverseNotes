package com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p1174aa.C17869f;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11377b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C27639g;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C2796h;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C42882f;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C36749c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.d.b */
public final class C42887b {
    private static C4993ae<Integer, C25814c> kvu = new C4993ae(3);

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.d.b$1 */
    static class C428881 implements C5662c {
        C428881() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
        }
    }

    /* renamed from: a */
    public static C11376a m76155a(C36749c c36749c, C7620bi c7620bi, String str, String str2, String str3) {
        AppMethodBeat.m2504i(54392);
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "all";
        }
        List HJ = C42887b.m76150HJ(str3);
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
        C11376a a;
        switch (obj) {
            case null:
                a = C42887b.m76156a(c36749c, c7620bi, str, HJ);
                if (a == null) {
                    a = C42887b.m76160b(c36749c, c7620bi);
                    if (a == null) {
                        a = C42887b.m76154a(c36749c, c7620bi);
                    }
                }
                AppMethodBeat.m2505o(54392);
                return a;
            case 1:
                a = C42887b.m76154a(c36749c, c7620bi);
                AppMethodBeat.m2505o(54392);
                return a;
            case 2:
                a = C42887b.m76160b(c36749c, c7620bi);
                AppMethodBeat.m2505o(54392);
                return a;
            case 3:
                a = C42887b.m76156a(c36749c, c7620bi, str, HJ);
                AppMethodBeat.m2505o(54392);
                return a;
            default:
                AppMethodBeat.m2505o(54392);
                return null;
        }
    }

    /* renamed from: HJ */
    public static List<String> m76150HJ(String str) {
        AppMethodBeat.m2504i(54393);
        ArrayList arrayList = new ArrayList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(54393);
        } else {
            try {
                C17869f c17869f = new C17869f(str);
                for (int i = 0; i < c17869f.length(); i++) {
                    String optString = c17869f.optString(i, "");
                    if (!C5046bo.isNullOrNil(optString)) {
                        arrayList.add(optString);
                    }
                }
            } catch (C41724g e) {
                C4990ab.printErrStackTrace("MicroMsg.MsgFileUtils", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(54393);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static C11376a m76156a(C36749c c36749c, C7620bi c7620bi, String str, List<String> list) {
        AppMethodBeat.m2504i(54394);
        if (c7620bi.bAA()) {
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                C8910b me = C8910b.m16064me(str2);
                if (me != null && me.type == 6) {
                    C11376a c42882f = new C42882f(c36749c, c7620bi, str);
                    if (list == null || list.size() == 0) {
                        AppMethodBeat.m2505o(54394);
                        return c42882f;
                    }
                    for (String str22 : list) {
                        if (c42882f.getFileName().endsWith(str22)) {
                            AppMethodBeat.m2505o(54394);
                            return c42882f;
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(54394);
        return null;
    }

    /* renamed from: a */
    private static C11376a m76154a(C36749c c36749c, C7620bi c7620bi) {
        AppMethodBeat.m2504i(54395);
        if (c7620bi.dtA()) {
            C11377b c11377b = new C11377b(c36749c, c7620bi);
            AppMethodBeat.m2505o(54395);
            return c11377b;
        } else if (c7620bi.drE()) {
            C11376a c27639g = new C27639g(c36749c, c7620bi);
            AppMethodBeat.m2505o(54395);
            return c27639g;
        } else {
            AppMethodBeat.m2505o(54395);
            return null;
        }
    }

    /* renamed from: b */
    private static C11376a m76160b(C36749c c36749c, C7620bi c7620bi) {
        AppMethodBeat.m2504i(54396);
        if (c7620bi.bws() || c7620bi.bwt()) {
            C2796h c2796h = new C2796h(c36749c, c7620bi);
            AppMethodBeat.m2505o(54396);
            return c2796h;
        }
        AppMethodBeat.m2505o(54396);
        return null;
    }

    /* renamed from: b */
    public static String m76161b(C7620bi c7620bi, boolean z) {
        String str = null;
        AppMethodBeat.m2504i(54397);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(54397);
            return null;
        } else if (c7620bi.field_isSend == 1) {
            str = C1853r.m3846Yz();
            AppMethodBeat.m2505o(54397);
            return str;
        } else {
            if (z) {
                str = C1829bf.m3762oy(c7620bi.field_content);
            }
            if (C5046bo.isNullOrNil(str)) {
                str = c7620bi.field_talker;
            }
            AppMethodBeat.m2505o(54397);
            return str;
        }
    }

    /* renamed from: ha */
    public static String m76165ha(long j) {
        AppMethodBeat.m2504i(54398);
        String a = C15894a.dJg().mo28137a(new Date(j), C4996ah.getContext());
        AppMethodBeat.m2505o(54398);
        return a;
    }

    /* renamed from: hb */
    public static long m76166hb(long j) {
        AppMethodBeat.m2504i(54399);
        long b = C15894a.dJg().mo28138b(new Date(j));
        AppMethodBeat.m2505o(54399);
        return b;
    }

    static {
        AppMethodBeat.m2504i(54410);
        AppMethodBeat.m2505o(54410);
    }

    /* renamed from: dy */
    public static final C25814c m76163dy(Context context) {
        AppMethodBeat.m2504i(54400);
        C25814c c25814c = (C25814c) kvu.get(Integer.valueOf(4));
        if (c25814c == null) {
            C17927a c17927a = new C17927a();
            c17927a.fHe = 1;
            c17927a.eQa = true;
            c17927a.ePO = C1338a.m2868gd(context) / 4;
            c17927a.ePN = C1338a.m2868gd(context) / 4;
            c17927a.ePV = C25738R.color.f12221wm;
            c25814c = c17927a.ahG();
            kvu.put(Integer.valueOf(4), c25814c);
        }
        AppMethodBeat.m2505o(54400);
        return c25814c;
    }

    /* renamed from: a */
    public static void m76158a(Context context, View view, C11376a c11376a) {
        AppMethodBeat.m2504i(54401);
        Intent intent = new Intent();
        if (c11376a == null) {
            C4990ab.m7412e("MicroMsg.MsgFileUtils", "[enterGallery] item == null");
            AppMethodBeat.m2505o(54401);
            return;
        }
        C7620bi c7620bi = c11376a.kua;
        if (c7620bi == null) {
            C4990ab.m7412e("MicroMsg.MsgFileUtils", "[enterGallery] msg == null");
            AppMethodBeat.m2505o(54401);
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
        intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId).putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId).putExtra("img_gallery_talker", c7620bi.field_talker).putExtra("img_gallery_chatroom_name", c7620bi.field_talker).putExtra("img_gallery_orientation", i).putExtra("show_enter_grid", false).putExtra("img_gallery_enter_from_scene", 1);
        if (view != null) {
            intent.putExtra("img_gallery_width", i2).putExtra("img_gallery_height", i3).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        C25985d.m41473f(context, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) context).overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(54401);
    }

    /* renamed from: HK */
    public static String m76151HK(String str) {
        AppMethodBeat.m2504i(54402);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.MsgFileUtils", "type is null, use default type");
            str = "all";
            AppMethodBeat.m2505o(54402);
            return str;
        } else if ("all".equals(str) || "image".equals(str) || "video".equals(str) || "file".equals(str)) {
            C4990ab.m7416i("MicroMsg.MsgFileUtils", "type is invalid, use default type");
            AppMethodBeat.m2505o(54402);
            return str;
        } else {
            str = "all";
            AppMethodBeat.m2505o(54402);
            return str;
        }
    }

    /* renamed from: mI */
    public static String m76167mI(String str) {
        AppMethodBeat.m2504i(54403);
        C7616ad aoO;
        String str2;
        if (C1855t.m3896kH(str)) {
            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || C5046bo.isNullOrNil(aoO.field_nickname)) {
                C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
                if (oa == null) {
                    C4990ab.m7413e("MicroMsg.MsgFileUtils", "%s chatRoomMember is null", str);
                    str2 = "";
                    AppMethodBeat.m2505o(54403);
                    return str2;
                }
                str2 = oa.field_displayname;
                AppMethodBeat.m2505o(54403);
                return str2;
            }
            str2 = aoO.field_nickname;
            AppMethodBeat.m2505o(54403);
            return str2;
        }
        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            C4990ab.m7413e("MicroMsg.MsgFileUtils", "%s, contact is null", str);
            str2 = "";
            AppMethodBeat.m2505o(54403);
            return str2;
        }
        str2 = aoO.field_nickname;
        AppMethodBeat.m2505o(54403);
        return str2;
    }

    /* renamed from: f */
    public static void m76164f(Context context, long j) {
        AppMethodBeat.m2504i(54404);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            Intent intent = new Intent();
            intent.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", j);
            intent.putExtra("scene", 1);
            context.startActivity(intent);
            AppMethodBeat.m2505o(54404);
            return;
        }
        C23639t.m36492hO(context);
        AppMethodBeat.m2505o(54404);
    }

    /* renamed from: HL */
    public static String m76152HL(String str) {
        AppMethodBeat.m2504i(54405);
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
                AppMethodBeat.m2505o(54405);
                return str2;
            case 4:
                str2 = "#c84e3a";
                AppMethodBeat.m2505o(54405);
                return str2;
            case 5:
            case 6:
                str2 = "#278453";
                AppMethodBeat.m2505o(54405);
                return str2;
            case 7:
            case 8:
                str2 = "#ff7a42";
                AppMethodBeat.m2505o(54405);
                return str2;
            case 9:
                str2 = "#33B0D6";
                AppMethodBeat.m2505o(54405);
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
                AppMethodBeat.m2505o(54405);
                return str2;
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case C2275g.CTRL_INDEX /*37*/:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                str2 = "#6781F0";
                AppMethodBeat.m2505o(54405);
                return str2;
            default:
                str2 = "#888888";
                AppMethodBeat.m2505o(54405);
                return str2;
        }
    }

    /* renamed from: a */
    public static void m76157a(int i, int i2, Intent intent, C9237a c9237a) {
        AppMethodBeat.m2504i(54406);
        if (i == 291) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        C4990ab.m7412e("MicroMsg.MsgFileUtils", "data is null");
                        C42887b.m76159a(c9237a, "data is null");
                        AppMethodBeat.m2505o(54406);
                        return;
                    }
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("FILEPATHS");
                    if (parcelableArrayListExtra == null) {
                        C4990ab.m7412e("MicroMsg.MsgFileUtils", "msgFiles is null");
                        C42887b.m76159a(c9237a, "msgFiles is null");
                        AppMethodBeat.m2505o(54406);
                        return;
                    }
                    if (c9237a != null) {
                        c9237a.mo20659a(-1, "", parcelableArrayListExtra);
                    }
                    AppMethodBeat.m2505o(54406);
                    return;
                case 0:
                    if (c9237a != null) {
                        c9237a.mo20659a(0, "", null);
                        break;
                    }
                    break;
                case 1:
                    if (intent == null) {
                        C4990ab.m7412e("MicroMsg.MsgFileUtils", "data is null");
                        C42887b.m76159a(c9237a, "data is null");
                        AppMethodBeat.m2505o(54406);
                        return;
                    }
                    C42887b.m76159a(c9237a, intent.getStringExtra("ERRMSG"));
                    AppMethodBeat.m2505o(54406);
                    return;
            }
        }
        AppMethodBeat.m2505o(54406);
    }

    /* renamed from: a */
    private static void m76159a(C9237a c9237a, String str) {
        AppMethodBeat.m2504i(54407);
        if (c9237a != null) {
            c9237a.mo20659a(1, str, null);
        }
        AppMethodBeat.m2505o(54407);
    }

    /* renamed from: cv */
    public static String m76162cv(String str) {
        AppMethodBeat.m2504i(54408);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(54408);
            return str2;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            str2 = "";
            AppMethodBeat.m2505o(54408);
            return str2;
        }
        str2 = str.substring(lastIndexOf + 1);
        AppMethodBeat.m2505o(54408);
        return str2;
    }

    /* renamed from: I */
    public static void m76153I(Context context, int i) {
        AppMethodBeat.m2504i(54409);
        String format = String.format(context.getString(C25738R.string.aph), new Object[]{Integer.valueOf(i)});
        C5659a c5659a = new C5659a(context);
        c5659a.asL(format).mo11526re(false);
        c5659a.mo11522b(new C428881()).show();
        AppMethodBeat.m2505o(54409);
    }
}
