package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.aa;
import android.support.v4.app.v;
import android.support.v4.app.v.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a {
    c jqz = new c<w>() {
        {
            AppMethodBeat.i(17101);
            this.xxI = w.class.getName().hashCode();
            AppMethodBeat.o(17101);
        }

        private static boolean a(w wVar) {
            AppMethodBeat.i(17102);
            if (wVar instanceof w) {
                try {
                    e eVar;
                    com.tencent.mm.g.a.w.a aVar = wVar.csR;
                    String str = wVar.csR.username;
                    String str2 = wVar.csR.title;
                    if (a.aSl()) {
                        Intent putExtra = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str);
                        com.tencent.mm.sdk.platformtools.e.aL(putExtra);
                        PendingIntent broadcast = PendingIntent.getBroadcast(ah.getContext(), str.hashCode(), putExtra, 134217728);
                        putExtra = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str);
                        com.tencent.mm.sdk.platformtools.e.aL(putExtra);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(ah.getContext(), str.hashCode(), putExtra, 134217728);
                        android.support.v4.app.aa.a aVar2 = new android.support.v4.app.aa.a("key_voice_reply_text");
                        aVar2.FV = ah.getContext().getString(R.string.t8);
                        aa aaVar = new aa(aVar2.FU, aVar2.FV, aVar2.FW, aVar2.FX, aVar2.mExtras, aVar2.FY);
                        android.support.v4.app.v.d.a.a aVar3 = new android.support.v4.app.v.d.a.a(str2);
                        aVar3.Fr = broadcast;
                        aVar3.Fp = aaVar;
                        aVar3.Fq = broadcast2;
                        int kF = f.kF(str);
                        if (kF > 10) {
                            kF = 10;
                        }
                        aw.ZK();
                        List cs = com.tencent.mm.model.c.XO().cs(str, kF);
                        for (int size = cs.size() - 1; size >= 0; size--) {
                            String trim;
                            Object string;
                            bi biVar = (bi) cs.get(size);
                            Object obj = null;
                            if (t.kH(biVar.field_talker)) {
                                String str3 = biVar.field_talker;
                                int ox = bf.ox(biVar.field_content);
                                if (ox != -1) {
                                    trim = biVar.field_content.substring(0, ox).trim();
                                    if (trim != null && trim.length() > 0) {
                                        str3 = trim;
                                    }
                                }
                                aw.ZK();
                                ad aoO = com.tencent.mm.model.c.XM().aoO(str3);
                                trim = s.a(aoO, str3);
                                if (t.kH(str3) && (aoO.field_username.equals(trim) || bo.isNullOrNil(trim))) {
                                    string = ah.getContext().getString(R.string.ao1);
                                } else {
                                    str3 = trim;
                                }
                            } else {
                                string = null;
                            }
                            String obj2;
                            if (biVar.drE()) {
                                obj2 = ah.getContext().getString(R.string.d9e);
                            } else if (biVar.isText()) {
                                if (!t.kH(biVar.field_talker) || biVar.field_isSend == 1) {
                                    obj2 = biVar.field_content;
                                } else {
                                    int ox2 = bf.ox(biVar.field_content);
                                    obj2 = ox2 != -1 ? biVar.field_content.substring(ox2 + 1).trim() : biVar.field_content;
                                }
                            } else if (biVar.drD()) {
                                obj2 = ah.getContext().getString(R.string.d_d);
                            } else if (biVar.bws()) {
                                obj2 = ah.getContext().getString(R.string.d_c);
                            } else if (biVar.bwt()) {
                                obj2 = ah.getContext().getString(R.string.d_4);
                            } else if (biVar.bAA()) {
                                b me = b.me(biVar.field_content);
                                if (me != null) {
                                    switch (me.type) {
                                        case 2:
                                            obj2 = String.format(ah.getContext().getString(R.string.d9e), new Object[0]);
                                            break;
                                        case 3:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8p), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 4:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8t), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 5:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8m), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 6:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8l), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 8:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8y), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 10:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8q), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 13:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8o), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 15:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8k), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 16:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8x), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 19:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8r), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 20:
                                            obj2 = String.format(ah.getContext().getString(R.string.d8s), new Object[]{bo.bc(me.title, "")});
                                            break;
                                        case 24:
                                            obj2 = ah.getContext().getString(R.string.bse);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            } else if (biVar.dtx()) {
                                trim = ah.getContext().getString(R.string.d94);
                                d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                                if (emojiMgr != null) {
                                    EmojiInfo Jd = emojiMgr.Jd(biVar.field_imgPath);
                                    obj2 = (Jd == null || bo.isNullOrNil(emojiMgr.Jh(Jd.Aq()))) ? ah.getContext().getString(R.string.d94) : "[" + emojiMgr.Jh(Jd.Aq()) + "]";
                                } else {
                                    obj2 = trim;
                                }
                            } else if (biVar.bAC()) {
                                obj2 = ah.getContext().getString(R.string.d9f);
                            } else if (biVar.dts() || biVar.dtt()) {
                                if (!biVar.field_content.equals(bi.xZb)) {
                                    obj2 = biVar.field_content;
                                    ui uiVar = new ui();
                                    uiVar.cQx.cAd = 1;
                                    uiVar.cQx.content = obj2;
                                    com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                                    if (uiVar.cQy.type == 3) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        obj2 = ah.getContext().getString(R.string.d_e);
                                    }
                                }
                                obj2 = ah.getContext().getString(R.string.d_f);
                            } else if (biVar.dtw()) {
                                aw.ZK();
                                com.tencent.mm.storage.bi.a Rn = com.tencent.mm.model.c.XO().Rn(biVar.field_content);
                                obj2 = String.format(ah.getContext().getString(R.string.d8x), new Object[]{Rn.getDisplayName()});
                            } else if (biVar.getType() == -1879048186) {
                                obj2 = ah.getContext().getString(R.string.d8n);
                            }
                            if (obj2 == null) {
                                obj2 = ah.getContext().getString(R.string.d_5);
                            }
                            if (string != null) {
                                obj2 = String.format("%s: %s", new Object[]{string, obj2});
                            }
                            aVar3.Fu.add(obj2);
                            if (size == 0) {
                                aVar3.Ft = biVar.field_createTime;
                            }
                        }
                        v.d dVar = new v.d();
                        dVar.Fn = new android.support.v4.app.v.d.a((String[]) aVar3.Fu.toArray(new String[aVar3.Fu.size()]), aVar3.Fp, aVar3.Fq, aVar3.Fr, new String[]{aVar3.Fv}, aVar3.Ft);
                        Object eVar2 = dVar;
                    } else {
                        eVar2 = null;
                    }
                    aVar.csS = eVar2;
                } catch (Throwable th) {
                    ab.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            AppMethodBeat.o(17102);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(17104);
        AppMethodBeat.o(17104);
    }

    static boolean aSl() {
        boolean z;
        AppMethodBeat.i(17105);
        try {
            ah.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        ab.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", Boolean.valueOf(z));
        AppMethodBeat.o(17105);
        return z;
    }
}
