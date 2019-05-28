package com.tencent.p177mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.ctl;
import com.tencent.p177mm.protocal.protobuf.cuc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.h */
public final class C43845h {
    public static final Bitmap adv(String str) {
        AppMethodBeat.m2504i(26339);
        Bitmap cQ = C40460b.diS().mo8232cQ(str);
        if (cQ == null) {
            C17884o.acd();
            C4990ab.m7411d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", C41732d.m73515D(str, false));
            cQ = C41732d.m73528qi(r0);
        } else {
            C4990ab.m7411d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        }
        AppMethodBeat.m2505o(26339);
        return cQ;
    }

    public static String adw(String str) {
        String a;
        AppMethodBeat.m2504i(26340);
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (C1855t.m3896kH(str)) {
            String string = C4996ah.getContext().getString(C25738R.string.ao1);
            a = C1854s.m3860a(aoO, str);
            if (aoO.field_username.equals(a) || C5046bo.isNullOrNil(a)) {
                a = string;
            }
        } else {
            a = C1854s.m3860a(aoO, str);
        }
        AppMethodBeat.m2505o(26340);
        return a;
    }

    /* JADX WARNING: Missing block: B:17:0x007a, code skipped:
            if (r0.length() > 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aj */
    public static cuc m78628aj(C7620bi c7620bi) {
        String str;
        int ox;
        String trim;
        AppMethodBeat.m2504i(26341);
        cuc cuc = new cuc();
        cuc.vIs = c7620bi.field_msgId;
        cuc.vIv = c7620bi.field_createTime;
        cuc.nao = 1;
        cuc.xqD = true;
        if (c7620bi.field_isSend == 1) {
            cuc.wCW = C43845h.adw(C1853r.m3846Yz());
            cuc.wyw = C1853r.m3846Yz();
        } else if (C1855t.m3896kH(c7620bi.field_talker)) {
            str = c7620bi.field_talker;
            ox = C1829bf.m3761ox(c7620bi.field_content);
            if (ox != -1) {
                trim = c7620bi.field_content.substring(0, ox).trim();
                if (trim != null) {
                }
            }
            trim = str;
            cuc.wCW = C43845h.adw(trim);
            cuc.wyw = trim;
        } else {
            cuc.wCW = C43845h.adw(c7620bi.field_talker);
            cuc.wyw = c7620bi.field_talker;
        }
        trim = null;
        C8910b me;
        if (c7620bi.isSystem()) {
            trim = C4996ah.getContext().getString(C25738R.string.d_b);
            cuc.nao = 3;
        } else if (c7620bi.drE()) {
            trim = C4996ah.getContext().getString(C25738R.string.d9e);
            cuc.nao = 4;
        } else if (c7620bi.isText()) {
            if (!C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_isSend == 1) {
                trim = c7620bi.field_content;
            } else {
                ox = C1829bf.m3761ox(c7620bi.field_content);
                trim = ox != -1 ? c7620bi.field_content.substring(ox + 1).trim() : c7620bi.field_content;
            }
        } else if (c7620bi.drD()) {
            trim = C4996ah.getContext().getString(C25738R.string.d_d);
            cuc.nao = 6;
            cuc.xqD = C32850q.m53704K(c7620bi);
            float fY = C32850q.m53722fY(new C42230n(c7620bi.field_content).time);
            cuc.xqE = new C1332b(C4996ah.getContext().getString(C25738R.string.byu, new Object[]{Integer.valueOf((int) fY)}).getBytes());
        } else if (c7620bi.bws()) {
            trim = C4996ah.getContext().getString(C25738R.string.d_c);
        } else if (c7620bi.bwt()) {
            trim = C4996ah.getContext().getString(C25738R.string.d_4);
        } else if (c7620bi.dtp()) {
            me = C8910b.m16064me(c7620bi.field_content);
            if (me != null) {
                if (me.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    cuc.nao = 5;
                    trim = c7620bi.field_isSend == 1 ? me.fhT : me.fhS;
                } else {
                    trim = c7620bi.field_isSend == 1 ? me.fhT : me.fhS;
                    trim = C4996ah.getContext().getString(C25738R.string.d8w, new Object[]{trim});
                }
            }
        } else if (c7620bi.dtq()) {
            trim = C4996ah.getContext().getString(C25738R.string.d8v);
            cuc.nao = 5;
        } else if (c7620bi.bAA()) {
            me = C8910b.m16064me(c7620bi.field_content);
            if (me != null) {
                switch (me.type) {
                    case 2:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d9e), new Object[0]);
                        break;
                    case 3:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8p), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 4:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8t), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 5:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8m), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 6:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8l), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 8:
                        trim = C4996ah.getContext().getString(C25738R.string.d8y, new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 10:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8q), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 13:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8o), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 15:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8k), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 16:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8x), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 19:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8r), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                    case 20:
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8s), new Object[]{C5046bo.m7532bc(me.title, "")});
                        break;
                }
            }
        } else if (c7620bi.dtx()) {
            str = C4996ah.getContext().getString(C25738R.string.d94);
            if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr() != null) {
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(c7620bi.field_imgPath);
                if (C5046bo.isNullOrNil(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(Jd.mo20410Aq()))) {
                    trim = C4996ah.getContext().getString(C25738R.string.d94);
                } else {
                    trim = "[" + ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(Jd.mo20410Aq()) + "]";
                }
                ctl ctl = new ctl();
                ctl.wdO = Jd.mo20410Aq();
                if (Jd.isGif()) {
                    ctl.jCt = 1;
                } else {
                    ctl.jCt = 2;
                }
                try {
                    cuc.xqE = new C1332b(ctl.toByteArray());
                } catch (IOException e) {
                }
                cuc.nao = 2;
            } else {
                trim = str;
            }
        } else if (c7620bi.bAC()) {
            trim = C4996ah.getContext().getString(C25738R.string.d9f);
        } else {
            if (!(c7620bi.dts() || c7620bi.dtt())) {
                int i;
                if (c7620bi.getType() == 64) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    if (c7620bi.dtw()) {
                        C9638aw.m17190ZK();
                        C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
                        trim = String.format(C4996ah.getContext().getString(C25738R.string.d8x), new Object[]{Rn.getDisplayName()});
                    } else if (c7620bi.getType() == -1879048186) {
                        trim = C4996ah.getContext().getString(C25738R.string.d8n);
                    }
                }
            }
            if (!c7620bi.field_content.equals(C7620bi.xZb)) {
                trim = c7620bi.field_content;
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 1;
                c26250ui.cQx.content = trim;
                C4879a.xxA.mo10055m(c26250ui);
                if (c26250ui.cQy.type == 3) {
                    ox = 1;
                } else {
                    ox = 0;
                }
                if (ox == 0) {
                    trim = C4996ah.getContext().getString(C25738R.string.d_e);
                }
            }
            trim = C4996ah.getContext().getString(C25738R.string.d_f);
        }
        if (trim == null) {
            trim = C4996ah.getContext().getString(C25738R.string.d_5);
        }
        cuc.ncM = trim;
        AppMethodBeat.m2505o(26341);
        return cuc;
    }

    /* renamed from: ad */
    public static byte[] m78627ad(Bitmap bitmap) {
        AppMethodBeat.m2504i(26342);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(26342);
        return toByteArray;
    }

    /* renamed from: OX */
    public static boolean m78625OX() {
        boolean z = true;
        AppMethodBeat.m2504i(26343);
        try {
            C4996ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.m2505o(26343);
        return z;
    }

    /* renamed from: OY */
    public static boolean m78626OY() {
        boolean z = true;
        AppMethodBeat.m2504i(26344);
        try {
            C4996ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.m2505o(26344);
        return z;
    }

    public static byte[] adx(String str) {
        AppMethodBeat.m2504i(26345);
        byte[] e = C5730e.m8632e(C5736j.m8649w(new C5728b(new C5728b(C1761b.eSi, "lib"), "lib" + str + ".so").dMD()), 0, -1);
        AppMethodBeat.m2505o(26345);
        return e;
    }
}
