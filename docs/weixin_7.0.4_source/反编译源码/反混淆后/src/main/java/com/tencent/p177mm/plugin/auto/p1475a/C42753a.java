package com.tencent.p177mm.plugin.auto.p1475a;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.p057v4.app.C0320aa;
import android.support.p057v4.app.C0320aa.C0319a;
import android.support.p057v4.app.C0363v.C0361e;
import android.support.p057v4.app.C0363v.C0365d;
import android.support.p057v4.app.C0363v.C0365d.C0360a;
import android.support.p057v4.app.C0363v.C0365d.C0360a.C0359a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18435w;
import com.tencent.p177mm.p230g.p231a.C18435w.C18436a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C46615e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.auto.a.a */
public final class C42753a {
    C4884c jqz = new C336591();

    /* renamed from: com.tencent.mm.plugin.auto.a.a$1 */
    class C336591 extends C4884c<C18435w> {
        C336591() {
            AppMethodBeat.m2504i(17101);
            this.xxI = C18435w.class.getName().hashCode();
            AppMethodBeat.m2505o(17101);
        }

        /* renamed from: a */
        private static boolean m54966a(C18435w c18435w) {
            AppMethodBeat.m2504i(17102);
            if (c18435w instanceof C18435w) {
                try {
                    C0361e c0361e;
                    C18436a c18436a = c18435w.csR;
                    String str = c18435w.csR.username;
                    String str2 = c18435w.csR.title;
                    if (C42753a.aSl()) {
                        Intent putExtra = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str);
                        C46615e.m88169aL(putExtra);
                        PendingIntent broadcast = PendingIntent.getBroadcast(C4996ah.getContext(), str.hashCode(), putExtra, 134217728);
                        putExtra = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str);
                        C46615e.m88169aL(putExtra);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(C4996ah.getContext(), str.hashCode(), putExtra, 134217728);
                        C0319a c0319a = new C0319a("key_voice_reply_text");
                        c0319a.f267FV = C4996ah.getContext().getString(C25738R.string.f9214t8);
                        C0320aa c0320aa = new C0320aa(c0319a.f266FU, c0319a.f267FV, c0319a.f268FW, c0319a.f269FX, c0319a.mExtras, c0319a.f270FY);
                        C0359a c0359a = new C0359a(str2);
                        c0359a.f395Fr = broadcast;
                        c0359a.f393Fp = c0320aa;
                        c0359a.f394Fq = broadcast2;
                        int kF = C18559f.m28906kF(str);
                        if (kF > 10) {
                            kF = 10;
                        }
                        C9638aw.m17190ZK();
                        List cs = C18628c.m29080XO().mo15320cs(str, kF);
                        for (int size = cs.size() - 1; size >= 0; size--) {
                            String trim;
                            Object string;
                            C7620bi c7620bi = (C7620bi) cs.get(size);
                            Object obj = null;
                            if (C1855t.m3896kH(c7620bi.field_talker)) {
                                String str3 = c7620bi.field_talker;
                                int ox = C1829bf.m3761ox(c7620bi.field_content);
                                if (ox != -1) {
                                    trim = c7620bi.field_content.substring(0, ox).trim();
                                    if (trim != null && trim.length() > 0) {
                                        str3 = trim;
                                    }
                                }
                                C9638aw.m17190ZK();
                                C7616ad aoO = C18628c.m29078XM().aoO(str3);
                                trim = C1854s.m3860a(aoO, str3);
                                if (C1855t.m3896kH(str3) && (aoO.field_username.equals(trim) || C5046bo.isNullOrNil(trim))) {
                                    string = C4996ah.getContext().getString(C25738R.string.ao1);
                                } else {
                                    str3 = trim;
                                }
                            } else {
                                string = null;
                            }
                            String obj2;
                            if (c7620bi.drE()) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d9e);
                            } else if (c7620bi.isText()) {
                                if (!C1855t.m3896kH(c7620bi.field_talker) || c7620bi.field_isSend == 1) {
                                    obj2 = c7620bi.field_content;
                                } else {
                                    int ox2 = C1829bf.m3761ox(c7620bi.field_content);
                                    obj2 = ox2 != -1 ? c7620bi.field_content.substring(ox2 + 1).trim() : c7620bi.field_content;
                                }
                            } else if (c7620bi.drD()) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d_d);
                            } else if (c7620bi.bws()) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d_c);
                            } else if (c7620bi.bwt()) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d_4);
                            } else if (c7620bi.bAA()) {
                                C8910b me = C8910b.m16064me(c7620bi.field_content);
                                if (me != null) {
                                    switch (me.type) {
                                        case 2:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d9e), new Object[0]);
                                            break;
                                        case 3:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8p), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 4:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8t), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 5:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8m), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 6:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8l), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 8:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8y), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 10:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8q), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 13:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8o), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 15:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8k), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 16:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8x), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 19:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8r), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 20:
                                            obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8s), new Object[]{C5046bo.m7532bc(me.title, "")});
                                            break;
                                        case 24:
                                            obj2 = C4996ah.getContext().getString(C25738R.string.bse);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            } else if (c7620bi.dtx()) {
                                trim = C4996ah.getContext().getString(C25738R.string.d94);
                                C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                                if (emojiMgr != null) {
                                    EmojiInfo Jd = emojiMgr.mo35596Jd(c7620bi.field_imgPath);
                                    obj2 = (Jd == null || C5046bo.isNullOrNil(emojiMgr.mo35600Jh(Jd.mo20410Aq()))) ? C4996ah.getContext().getString(C25738R.string.d94) : "[" + emojiMgr.mo35600Jh(Jd.mo20410Aq()) + "]";
                                } else {
                                    obj2 = trim;
                                }
                            } else if (c7620bi.bAC()) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d9f);
                            } else if (c7620bi.dts() || c7620bi.dtt()) {
                                if (!c7620bi.field_content.equals(C7620bi.xZb)) {
                                    obj2 = c7620bi.field_content;
                                    C26250ui c26250ui = new C26250ui();
                                    c26250ui.cQx.cAd = 1;
                                    c26250ui.cQx.content = obj2;
                                    C4879a.xxA.mo10055m(c26250ui);
                                    if (c26250ui.cQy.type == 3) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        obj2 = C4996ah.getContext().getString(C25738R.string.d_e);
                                    }
                                }
                                obj2 = C4996ah.getContext().getString(C25738R.string.d_f);
                            } else if (c7620bi.dtw()) {
                                C9638aw.m17190ZK();
                                C5135a Rn = C18628c.m29080XO().mo15260Rn(c7620bi.field_content);
                                obj2 = String.format(C4996ah.getContext().getString(C25738R.string.d8x), new Object[]{Rn.getDisplayName()});
                            } else if (c7620bi.getType() == -1879048186) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d8n);
                            }
                            if (obj2 == null) {
                                obj2 = C4996ah.getContext().getString(C25738R.string.d_5);
                            }
                            if (string != null) {
                                obj2 = String.format("%s: %s", new Object[]{string, obj2});
                            }
                            c0359a.f397Fu.add(obj2);
                            if (size == 0) {
                                c0359a.f396Ft = c7620bi.field_createTime;
                            }
                        }
                        C0365d c0365d = new C0365d();
                        c0365d.f411Fn = new C0360a((String[]) c0359a.f397Fu.toArray(new String[c0359a.f397Fu.size()]), c0359a.f393Fp, c0359a.f394Fq, c0359a.f395Fr, new String[]{c0359a.f398Fv}, c0359a.f396Ft);
                        Object c0361e2 = c0365d;
                    } else {
                        c0361e2 = null;
                    }
                    c18436a.csS = c0361e2;
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(17102);
            return false;
        }
    }

    public C42753a() {
        AppMethodBeat.m2504i(17104);
        AppMethodBeat.m2505o(17104);
    }

    static boolean aSl() {
        boolean z;
        AppMethodBeat.m2504i(17105);
        try {
            C4996ah.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(17105);
        return z;
    }
}
