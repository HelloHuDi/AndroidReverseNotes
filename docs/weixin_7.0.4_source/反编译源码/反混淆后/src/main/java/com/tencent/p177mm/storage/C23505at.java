package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C15437n;
import com.tencent.p177mm.storage.emotion.C15439u;
import com.tencent.p177mm.storage.emotion.C23516c;
import com.tencent.p177mm.storage.emotion.C23517f;
import com.tencent.p177mm.storage.emotion.C23519l;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.storage.emotion.C40627p;
import com.tencent.p177mm.storage.emotion.C44225j;
import com.tencent.p177mm.storage.emotion.C44227q;
import com.tencent.p177mm.storage.emotion.C46623a;
import com.tencent.p177mm.storage.emotion.C46624h;
import com.tencent.p177mm.storage.emotion.C46625s;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.storage.at */
public final class C23505at {
    private static int cTa = -1;
    public static boolean xYA = false;
    private static ArrayList<EmojiGroupInfo> xYB = new ArrayList();
    private static HashMap<String, ArrayList<EmojiInfo>> xYC = new HashMap();
    private static C23505at xYH;
    public final C4931a xYD = new C235071();
    public final C4931a xYE = new C235062();
    public final C4931a xYF = new C235083();
    public final C4884c xYG = new C154354();
    public String xYI;
    public C30303d xYn;
    public C46623a xYo;
    public C23516c xYp;
    public C40627p xYq;
    public C44225j xYr;
    public C23519l xYs;
    public C46624h xYt;
    public C15437n xYu;
    public C44227q xYv;
    public C46625s xYw;
    public C23517f xYx;
    public C15439u xYy;
    public C32497a xYz;

    /* renamed from: com.tencent.mm.storage.at$4 */
    class C154354 extends C4884c<C45348ny> {
        C154354() {
            AppMethodBeat.m2504i(62712);
            this.xxI = C45348ny.class.getName().hashCode();
            AppMethodBeat.m2505o(62712);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(62713);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStorageMgr", "REFRESH_PANEL_EVENT");
            C23505at.this.xYz.mo53138ca(true);
            C23505at.this.xYz.mo53139cb(true);
            C23505at.this.xYz.mo53141cd(true);
            AppMethodBeat.m2505o(62713);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.storage.at$2 */
    class C235062 implements C4931a {
        C235062() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(62710);
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiDescMgr().dsY();
            AppMethodBeat.m2505o(62710);
        }
    }

    /* renamed from: com.tencent.mm.storage.at$1 */
    class C235071 implements C4931a {
        C235071() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(62709);
            if (!C5046bo.isNullOrNil(str) && str.equals("event_update_group")) {
                C4990ab.m7411d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", (String) c4935m.obj);
                if (C1720g.m3534RN().mo5161QY()) {
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiDescMgr().dsY();
                } else {
                    AppMethodBeat.m2505o(62709);
                    return;
                }
            }
            if (!C5046bo.isNullOrNil(str) && (str.equals("event_update_group") || str.equalsIgnoreCase("productID"))) {
                C4990ab.m7410d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
                C23505at.xYA = true;
                C23505at.this.xYz.mo53140cc(true);
            }
            AppMethodBeat.m2505o(62709);
        }
    }

    /* renamed from: com.tencent.mm.storage.at$3 */
    class C235083 implements C4931a {
        C235083() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(62711);
            if (str == null) {
                AppMethodBeat.m2505o(62711);
            } else if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                C23505at.this.xYz.mo53138ca(true);
                C23505at.this.xYz.mo53139cb(true);
                C23505at.this.xYz.mo53141cd(true);
                AppMethodBeat.m2505o(62711);
            } else {
                if (C1720g.m3531RK()) {
                    EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(str);
                    if (Jd != null) {
                        if (Jd.field_catalog == EmojiInfo.yaB) {
                            C23505at.this.xYz.mo53138ca(true);
                            C23505at.this.xYz.mo53139cb(true);
                            AppMethodBeat.m2505o(62711);
                            return;
                        } else if (C5046bo.isEqual(Jd.field_groupId, "capture")) {
                            C23505at.this.xYz.mo53141cd(true);
                        }
                    }
                }
                AppMethodBeat.m2505o(62711);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(62719);
        AppMethodBeat.m2505o(62719);
    }

    public static synchronized C23505at dsZ() {
        C23505at c23505at;
        synchronized (C23505at.class) {
            AppMethodBeat.m2504i(62714);
            if (xYH == null) {
                xYH = new C23505at();
            }
            c23505at = xYH;
            AppMethodBeat.m2505o(62714);
        }
        return c23505at;
    }

    private C23505at() {
        AppMethodBeat.m2504i(62715);
        C4990ab.m7417i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", C5046bo.dpG());
        AppMethodBeat.m2505o(62715);
    }

    public final C30303d aUp() {
        return this.xYn;
    }

    public final int bjV() {
        AppMethodBeat.m2504i(62716);
        if (cTa == -1 || xYA) {
            cTa = this.xYo.duC();
        }
        int i = cTa;
        AppMethodBeat.m2505o(62716);
        return i;
    }

    /* renamed from: bY */
    public final ArrayList<EmojiInfo> mo39170bY(boolean z) {
        AppMethodBeat.m2504i(62717);
        ArrayList bY = this.xYz.mo53136bY(z);
        AppMethodBeat.m2505o(62717);
        return bY;
    }

    public final boolean dta() {
        AppMethodBeat.m2504i(62718);
        if (this.xYI == null) {
            this.xYI = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, (Object) "");
        }
        if (C5046bo.isNullOrNil(this.xYI)) {
            AppMethodBeat.m2505o(62718);
            return false;
        }
        AppMethodBeat.m2505o(62718);
        return true;
    }
}
