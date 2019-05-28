package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h {
    public static final Bitmap adv(String str) {
        AppMethodBeat.i(26339);
        Bitmap cQ = b.diS().cQ(str);
        if (cQ == null) {
            o.acd();
            ab.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", d.D(str, false));
            cQ = d.qi(r0);
        } else {
            ab.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        }
        AppMethodBeat.o(26339);
        return cQ;
    }

    public static String adw(String str) {
        String a;
        AppMethodBeat.i(26340);
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        if (t.kH(str)) {
            String string = ah.getContext().getString(R.string.ao1);
            a = s.a(aoO, str);
            if (aoO.field_username.equals(a) || bo.isNullOrNil(a)) {
                a = string;
            }
        } else {
            a = s.a(aoO, str);
        }
        AppMethodBeat.o(26340);
        return a;
    }

    /* JADX WARNING: Missing block: B:17:0x007a, code skipped:
            if (r0.length() > 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static cuc aj(bi biVar) {
        String str;
        int ox;
        String trim;
        AppMethodBeat.i(26341);
        cuc cuc = new cuc();
        cuc.vIs = biVar.field_msgId;
        cuc.vIv = biVar.field_createTime;
        cuc.nao = 1;
        cuc.xqD = true;
        if (biVar.field_isSend == 1) {
            cuc.wCW = adw(r.Yz());
            cuc.wyw = r.Yz();
        } else if (t.kH(biVar.field_talker)) {
            str = biVar.field_talker;
            ox = bf.ox(biVar.field_content);
            if (ox != -1) {
                trim = biVar.field_content.substring(0, ox).trim();
                if (trim != null) {
                }
            }
            trim = str;
            cuc.wCW = adw(trim);
            cuc.wyw = trim;
        } else {
            cuc.wCW = adw(biVar.field_talker);
            cuc.wyw = biVar.field_talker;
        }
        trim = null;
        j.b me;
        if (biVar.isSystem()) {
            trim = ah.getContext().getString(R.string.d_b);
            cuc.nao = 3;
        } else if (biVar.drE()) {
            trim = ah.getContext().getString(R.string.d9e);
            cuc.nao = 4;
        } else if (biVar.isText()) {
            if (!t.kH(biVar.field_talker) || biVar.field_isSend == 1) {
                trim = biVar.field_content;
            } else {
                ox = bf.ox(biVar.field_content);
                trim = ox != -1 ? biVar.field_content.substring(ox + 1).trim() : biVar.field_content;
            }
        } else if (biVar.drD()) {
            trim = ah.getContext().getString(R.string.d_d);
            cuc.nao = 6;
            cuc.xqD = q.K(biVar);
            float fY = q.fY(new n(biVar.field_content).time);
            cuc.xqE = new com.tencent.mm.bt.b(ah.getContext().getString(R.string.byu, new Object[]{Integer.valueOf((int) fY)}).getBytes());
        } else if (biVar.bws()) {
            trim = ah.getContext().getString(R.string.d_c);
        } else if (biVar.bwt()) {
            trim = ah.getContext().getString(R.string.d_4);
        } else if (biVar.dtp()) {
            me = j.b.me(biVar.field_content);
            if (me != null) {
                if (me.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    cuc.nao = 5;
                    trim = biVar.field_isSend == 1 ? me.fhT : me.fhS;
                } else {
                    trim = biVar.field_isSend == 1 ? me.fhT : me.fhS;
                    trim = ah.getContext().getString(R.string.d8w, new Object[]{trim});
                }
            }
        } else if (biVar.dtq()) {
            trim = ah.getContext().getString(R.string.d8v);
            cuc.nao = 5;
        } else if (biVar.bAA()) {
            me = j.b.me(biVar.field_content);
            if (me != null) {
                switch (me.type) {
                    case 2:
                        trim = String.format(ah.getContext().getString(R.string.d9e), new Object[0]);
                        break;
                    case 3:
                        trim = String.format(ah.getContext().getString(R.string.d8p), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 4:
                        trim = String.format(ah.getContext().getString(R.string.d8t), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 5:
                        trim = String.format(ah.getContext().getString(R.string.d8m), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 6:
                        trim = String.format(ah.getContext().getString(R.string.d8l), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 8:
                        trim = ah.getContext().getString(R.string.d8y, new Object[]{bo.bc(me.title, "")});
                        break;
                    case 10:
                        trim = String.format(ah.getContext().getString(R.string.d8q), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 13:
                        trim = String.format(ah.getContext().getString(R.string.d8o), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 15:
                        trim = String.format(ah.getContext().getString(R.string.d8k), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 16:
                        trim = String.format(ah.getContext().getString(R.string.d8x), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 19:
                        trim = String.format(ah.getContext().getString(R.string.d8r), new Object[]{bo.bc(me.title, "")});
                        break;
                    case 20:
                        trim = String.format(ah.getContext().getString(R.string.d8s), new Object[]{bo.bc(me.title, "")});
                        break;
                }
            }
        } else if (biVar.dtx()) {
            str = ah.getContext().getString(R.string.d94);
            if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() != null) {
                EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(biVar.field_imgPath);
                if (bo.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(Jd.Aq()))) {
                    trim = ah.getContext().getString(R.string.d94);
                } else {
                    trim = "[" + ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(Jd.Aq()) + "]";
                }
                ctl ctl = new ctl();
                ctl.wdO = Jd.Aq();
                if (Jd.isGif()) {
                    ctl.jCt = 1;
                } else {
                    ctl.jCt = 2;
                }
                try {
                    cuc.xqE = new com.tencent.mm.bt.b(ctl.toByteArray());
                } catch (IOException e) {
                }
                cuc.nao = 2;
            } else {
                trim = str;
            }
        } else if (biVar.bAC()) {
            trim = ah.getContext().getString(R.string.d9f);
        } else {
            if (!(biVar.dts() || biVar.dtt())) {
                int i;
                if (biVar.getType() == 64) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    if (biVar.dtw()) {
                        aw.ZK();
                        a Rn = c.XO().Rn(biVar.field_content);
                        trim = String.format(ah.getContext().getString(R.string.d8x), new Object[]{Rn.getDisplayName()});
                    } else if (biVar.getType() == -1879048186) {
                        trim = ah.getContext().getString(R.string.d8n);
                    }
                }
            }
            if (!biVar.field_content.equals(bi.xZb)) {
                trim = biVar.field_content;
                ui uiVar = new ui();
                uiVar.cQx.cAd = 1;
                uiVar.cQx.content = trim;
                com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                if (uiVar.cQy.type == 3) {
                    ox = 1;
                } else {
                    ox = 0;
                }
                if (ox == 0) {
                    trim = ah.getContext().getString(R.string.d_e);
                }
            }
            trim = ah.getContext().getString(R.string.d_f);
        }
        if (trim == null) {
            trim = ah.getContext().getString(R.string.d_5);
        }
        cuc.ncM = trim;
        AppMethodBeat.o(26341);
        return cuc;
    }

    public static byte[] ad(Bitmap bitmap) {
        AppMethodBeat.i(26342);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(26342);
        return toByteArray;
    }

    public static boolean OX() {
        boolean z = true;
        AppMethodBeat.i(26343);
        try {
            ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.o(26343);
        return z;
    }

    public static boolean OY() {
        boolean z = true;
        AppMethodBeat.i(26344);
        try {
            ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.o(26344);
        return z;
    }

    public static byte[] adx(String str) {
        AppMethodBeat.i(26345);
        byte[] e = e.e(com.tencent.mm.vfs.j.w(new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.loader.j.b.eSi, "lib"), "lib" + str + ".so").dMD()), 0, -1);
        AppMethodBeat.o(26345);
        return e;
    }
}
