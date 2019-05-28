package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.HashMap;

public final class at {
    private static int cTa = -1;
    public static boolean xYA = false;
    private static ArrayList<EmojiGroupInfo> xYB = new ArrayList();
    private static HashMap<String, ArrayList<EmojiInfo>> xYC = new HashMap();
    private static at xYH;
    public final a xYD = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(62709);
            if (!bo.isNullOrNil(str) && str.equals("event_update_group")) {
                ab.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", (String) mVar.obj);
                if (g.RN().QY()) {
                    ((d) g.M(d.class)).getEmojiDescMgr().dsY();
                } else {
                    AppMethodBeat.o(62709);
                    return;
                }
            }
            if (!bo.isNullOrNil(str) && (str.equals("event_update_group") || str.equalsIgnoreCase("productID"))) {
                ab.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                at.xYA = true;
                at.this.xYz.cc(true);
            }
            AppMethodBeat.o(62709);
        }
    };
    public final a xYE = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(62710);
            ((d) g.M(d.class)).getEmojiDescMgr().dsY();
            AppMethodBeat.o(62710);
        }
    };
    public final a xYF = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(62711);
            if (str == null) {
                AppMethodBeat.o(62711);
            } else if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                at.this.xYz.ca(true);
                at.this.xYz.cb(true);
                at.this.xYz.cd(true);
                AppMethodBeat.o(62711);
            } else {
                if (g.RK()) {
                    EmojiInfo Jd = ((d) g.M(d.class)).getEmojiMgr().Jd(str);
                    if (Jd != null) {
                        if (Jd.field_catalog == EmojiInfo.yaB) {
                            at.this.xYz.ca(true);
                            at.this.xYz.cb(true);
                            AppMethodBeat.o(62711);
                            return;
                        } else if (bo.isEqual(Jd.field_groupId, "capture")) {
                            at.this.xYz.cd(true);
                        }
                    }
                }
                AppMethodBeat.o(62711);
            }
        }
    };
    public final c xYG = new c<ny>() {
        {
            AppMethodBeat.i(62712);
            this.xxI = ny.class.getName().hashCode();
            AppMethodBeat.o(62712);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(62713);
            ab.i("MicroMsg.emoji.EmojiStorageMgr", "REFRESH_PANEL_EVENT");
            at.this.xYz.ca(true);
            at.this.xYz.cb(true);
            at.this.xYz.cd(true);
            AppMethodBeat.o(62713);
            return false;
        }
    };
    public String xYI;
    public com.tencent.mm.storage.emotion.d xYn;
    public com.tencent.mm.storage.emotion.a xYo;
    public com.tencent.mm.storage.emotion.c xYp;
    public p xYq;
    public j xYr;
    public l xYs;
    public h xYt;
    public n xYu;
    public q xYv;
    public s xYw;
    public f xYx;
    public u xYy;
    public com.tencent.mm.emoji.a.a xYz;

    static {
        AppMethodBeat.i(62719);
        AppMethodBeat.o(62719);
    }

    public static synchronized at dsZ() {
        at atVar;
        synchronized (at.class) {
            AppMethodBeat.i(62714);
            if (xYH == null) {
                xYH = new at();
            }
            atVar = xYH;
            AppMethodBeat.o(62714);
        }
        return atVar;
    }

    private at() {
        AppMethodBeat.i(62715);
        ab.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", bo.dpG());
        AppMethodBeat.o(62715);
    }

    public final com.tencent.mm.storage.emotion.d aUp() {
        return this.xYn;
    }

    public final int bjV() {
        AppMethodBeat.i(62716);
        if (cTa == -1 || xYA) {
            cTa = this.xYo.duC();
        }
        int i = cTa;
        AppMethodBeat.o(62716);
        return i;
    }

    public final ArrayList<EmojiInfo> bY(boolean z) {
        AppMethodBeat.i(62717);
        ArrayList bY = this.xYz.bY(z);
        AppMethodBeat.o(62717);
        return bY;
    }

    public final boolean dta() {
        AppMethodBeat.i(62718);
        if (this.xYI == null) {
            this.xYI = (String) g.RP().Ry().get(ac.a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, (Object) "");
        }
        if (bo.isNullOrNil(this.xYI)) {
            AppMethodBeat.o(62718);
            return false;
        }
        AppMethodBeat.o(62718);
        return true;
    }
}
