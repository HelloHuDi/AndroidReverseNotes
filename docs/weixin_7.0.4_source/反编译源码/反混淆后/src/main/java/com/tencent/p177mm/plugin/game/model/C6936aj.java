package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p731d.C12111al;
import com.tencent.p177mm.plugin.game.p731d.C12114bg;
import com.tencent.p177mm.plugin.game.p731d.C43163bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.aj */
public final class C6936aj extends C1207m implements C1918k {
    public static C1202f fur = new C69381();
    public static final String mYz = (C1761b.eSn + "Game/TabNav/");
    private C1202f ehi;
    private final C7472b lty;

    /* renamed from: com.tencent.mm.plugin.game.model.aj$1 */
    static class C69381 implements C1202f {
        C69381() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(111416);
            C1720g.m3540Rg().mo14546b(2641, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
                final C12114bg bET = ((C6936aj) c1207m).bET();
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(111415);
                        C6936aj.m11461a(bET);
                        AppMethodBeat.m2505o(111415);
                    }
                });
                AppMethodBeat.m2505o(111416);
                return;
            }
            C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
            AppMethodBeat.m2505o(111416);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.aj$a */
    interface C6941a {
        void onComplete();
    }

    /* renamed from: b */
    static /* synthetic */ void m11463b(List list, C6941a c6941a) {
        AppMethodBeat.m2504i(111425);
        C6936aj.m11462a(list, c6941a);
        AppMethodBeat.m2505o(111425);
    }

    static {
        AppMethodBeat.m2504i(111426);
        AppMethodBeat.m2505o(111426);
    }

    public C6936aj() {
        AppMethodBeat.m2504i(111419);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C43163bf();
        c1196a.fsK = new C12114bg();
        c1196a.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
        this.lty = c1196a.acD();
        AppMethodBeat.m2505o(111419);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111420);
        C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111420);
    }

    public final int getType() {
        return 2641;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111421);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111421);
        return a;
    }

    public final C12114bg bET() {
        return (C12114bg) this.lty.fsH.fsP;
    }

    public static void updateData() {
        AppMethodBeat.m2504i(111422);
        C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
        C1720g.m3540Rg().mo14539a(2641, fur);
        C1720g.m3540Rg().mo14541a(new C6936aj(), 0);
        AppMethodBeat.m2505o(111422);
    }

    /* renamed from: a */
    public static void m11461a(final C12114bg c12114bg) {
        AppMethodBeat.m2504i(111423);
        if (c12114bg == null) {
            AppMethodBeat.m2505o(111423);
        } else if (C5046bo.m7548ek(c12114bg.naO)) {
            C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
            AppMethodBeat.m2505o(111423);
        } else {
            List arrayList = new ArrayList();
            Iterator it = c12114bg.naO.iterator();
            while (it.hasNext()) {
                C12111al c12111al = (C12111al) it.next();
                if (c12111al != null) {
                    arrayList.add(c12111al.naY);
                    arrayList.add(c12111al.naZ);
                }
            }
            C6936aj.m11462a(arrayList, new C6941a() {
                public final void onComplete() {
                    AppMethodBeat.m2504i(111417);
                    C4990ab.m7416i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
                    ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b("game_index4_tab_nav", c12114bg);
                    AppMethodBeat.m2505o(111417);
                }
            });
            AppMethodBeat.m2505o(111423);
        }
    }

    /* renamed from: a */
    private static void m11462a(final List<String> list, final C6941a c6941a) {
        AppMethodBeat.m2504i(111424);
        while (!C5046bo.m7548ek(list)) {
            final String str = (String) list.remove(0);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
            } else {
                String str2 = mYz + C1178g.m2591x(str.getBytes());
                C17927a c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePJ = str2;
                C32291o.ahp().mo43771a(str, c17927a.ahG(), new C45158c() {
                    /* renamed from: a */
                    public final void mo15193a(boolean z, Object... objArr) {
                        AppMethodBeat.m2504i(111418);
                        C4990ab.m7417i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", Boolean.valueOf(z), str);
                        C6936aj.m11463b(list, c6941a);
                        AppMethodBeat.m2505o(111418);
                    }
                });
                AppMethodBeat.m2505o(111424);
                return;
            }
        }
        if (c6941a != null) {
            c6941a.onComplete();
        }
        AppMethodBeat.m2505o(111424);
    }
}
