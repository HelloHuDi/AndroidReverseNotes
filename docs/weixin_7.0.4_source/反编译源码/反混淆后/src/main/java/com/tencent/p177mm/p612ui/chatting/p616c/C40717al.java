package com.tencent.p177mm.p612ui.chatting.p616c;

import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p230g.p232b.p233a.C1583aj;
import com.tencent.p177mm.p230g.p232b.p233a.C46878am;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5510e;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.view.AvatarImageView;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.plugin.story.api.C29269k;
import com.tencent.p177mm.plugin.story.api.C29269k.C29271a;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C29293i;
import com.tencent.p177mm.plugin.story.p531g.C29293i.C29294a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@C15590a(dFp = C36158x.class)
/* renamed from: com.tencent.mm.ui.chatting.c.al */
public class C40717al extends C44291a implements C29271a, C36158x {
    private String cvF = null;
    private long iBO = 0;
    private boolean mgQ = true;
    private boolean mlA = false;
    private boolean pls = false;
    private boolean rXd = false;
    private List<String> sbP = Collections.synchronizedList(new ArrayList());
    private long smo = 500;
    private C29269k ySl;
    private List<String> ySm = Collections.synchronizedList(new ArrayList());
    private boolean ySn = false;
    private boolean ySo = false;
    private SparseArray<WeakReference<AvatarImageView>> ySp = new SparseArray();
    private OnMenuItemClickListener yvX = new C53091();

    /* renamed from: com.tencent.mm.ui.chatting.c.al$1 */
    class C53091 implements OnMenuItemClickListener {
        C53091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            long j = 1;
            AppMethodBeat.m2504i(31720);
            if (System.currentTimeMillis() - C40717al.this.iBO <= C40717al.this.smo) {
                C4990ab.m7417i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.m2505o(31720);
                return true;
            }
            C40717al.this.iBO = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", Long.valueOf(C40717al.this.iBO), Integer.valueOf(C40717al.this.ySm.size()));
            C22212h c22212h;
            if (C40717al.this.ySm.size() > 0) {
                long j2;
                String str = (String) C40717al.this.ySm.get(0);
                C4990ab.m7417i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", str);
                C46270n.m86707bj(1, str);
                C46270n.enterGallery(C40717al.this.sbP);
                C46270n.m86703ZX(str);
                c22212h = C22212h.scu;
                C22212h.cAs().mo20757fC(C40717al.this.cvF);
                if (C40717al.this.mgQ) {
                    c22212h = C22212h.scu;
                    C22212h.cAs().cYQ = 4;
                    C46270n.m86705a(C40717al.this.cgL.yTx.getContext(), C40717al.this.ySm, C40717al.this.cgL.getTalkerUserName(), C40717al.this.cvF);
                } else {
                    c22212h = C22212h.scu;
                    C22212h.cAs().cYQ = 5;
                    C46270n.m86706aT(C40717al.this.cgL.yTx.getContext(), (String) C40717al.this.ySm.get(0));
                }
                c22212h = C22212h.scu;
                C9502ar cAs = C22212h.cAs();
                if (C40717al.this.rXd) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                cAs.cYR = j2;
                AppMethodBeat.m2505o(31720);
                return true;
            } else if (C40717al.this.pls && C40717al.this.mgQ) {
                c22212h = C22212h.scu;
                C9502ar cAs2 = C22212h.cAs();
                if (!C40717al.this.rXd) {
                    j = 0;
                }
                cAs2.cYR = j;
                C46270n.m86705a(C40717al.this.cgL.yTx.getContext(), C40717al.this.ySm, C40717al.this.cgL.getTalkerUserName(), C40717al.this.cvF);
                c22212h = C22212h.scu;
                C22212h.cAs().cYQ = 4;
                AppMethodBeat.m2505o(31720);
                return true;
            } else {
                AppMethodBeat.m2505o(31720);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.al$2 */
    class C156072 implements Runnable {
        C156072() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31721);
            ((C44299r) C40717al.this.cgL.mo74857aF(C44299r.class)).dEp();
            AppMethodBeat.m2505o(31721);
        }
    }

    public C40717al() {
        AppMethodBeat.m2504i(31723);
        AppMethodBeat.m2505o(31723);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dxy() {
        C40717al c40717al;
        C40717al c40717al2;
        C22212h c22212h;
        C1583aj cAy;
        long j;
        boolean z = true;
        AppMethodBeat.m2504i(31724);
        super.dxy();
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", this.cgL.getTalkerUserName(), Integer.valueOf(hashCode()));
        this.cgL.yTx.removeOptionMenu(3);
        this.pls = false;
        this.rXd = false;
        this.ySm.clear();
        this.sbP.clear();
        this.cvF = "";
        this.ySo = false;
        ((C36137j) this.cgL.mo74857aF(C36137j.class)).mo57027Oz(0);
        String talkerUserName = this.cgL.getTalkerUserName();
        if (C37414c.isNullOrNil(talkerUserName)) {
            c40717al = this;
        } else {
            this.mgQ = C1855t.m3896kH(talkerUserName);
            if (C1855t.m3902mO(talkerUserName)) {
                z = C1855t.m3902mO(talkerUserName);
                c40717al2 = this;
            } else if (C1855t.m3905mR(talkerUserName) || C1855t.m3913mZ(talkerUserName) || C1855t.m3908mU(talkerUserName) || C1855t.m3909mV(talkerUserName) || C1855t.m3934nc(talkerUserName) || C1855t.m3935nd(talkerUserName) || C1855t.m3918nD(talkerUserName) || C1855t.m3923nI(talkerUserName) || C1855t.m3946no(talkerUserName) || C1855t.m3903mP(talkerUserName) || C1855t.m3902mO(talkerUserName)) {
                c40717al = this;
            } else {
                c40717al2 = this;
            }
            c40717al2.ySn = z;
            if (this.ySn) {
                this.ySl = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryStateFetcher(this.cgL.getTalkerUserName());
                if (this.ySl != null) {
                    this.ySl.mo47444a(this);
                    this.ySl.start();
                }
            }
            c22212h = C22212h.scu;
            C22212h.cAy().mo4984fl(this.cgL.getTalkerUserName());
            c22212h = C22212h.scu;
            cAy = C22212h.cAy();
            if (this.mgQ) {
                j = 5;
            } else {
                j = 4;
            }
            cAy.cYQ = j;
            c22212h = C22212h.scu;
            cAy = C22212h.cAy();
            if (this.rXd) {
                j = 0;
            } else {
                j = 1;
            }
            cAy.cYR = j;
            if (this.mgQ) {
                this.cgL.yTB = C5510e.aqC("5");
            } else {
                this.cgL.yTB = C5510e.aqC("4");
            }
            this.cvF = this.cgL.dFt();
            AppMethodBeat.m2505o(31724);
        }
        z = false;
        c40717al2 = c40717al;
        c40717al2.ySn = z;
        if (this.ySn) {
        }
        c22212h = C22212h.scu;
        C22212h.cAy().mo4984fl(this.cgL.getTalkerUserName());
        c22212h = C22212h.scu;
        cAy = C22212h.cAy();
        if (this.mgQ) {
        }
        cAy.cYQ = j;
        c22212h = C22212h.scu;
        cAy = C22212h.cAy();
        if (this.rXd) {
        }
        cAy.cYR = j;
        if (this.mgQ) {
        }
        this.cvF = this.cgL.dFt();
        AppMethodBeat.m2505o(31724);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31725);
        super.dxz();
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(31725);
    }

    public final void dxA() {
        C22212h c22212h;
        long j = 2;
        AppMethodBeat.m2504i(31726);
        super.dxA();
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", Integer.valueOf(hashCode()));
        this.mlA = true;
        dEZ();
        if (this.ySl != null) {
            long j2;
            this.ySl.resume();
            c22212h = C22212h.scu;
            C9502ar cAs = C22212h.cAs();
            if (this.mgQ) {
                j2 = 10;
            } else {
                j2 = 11;
            }
            cAs.cYQ = j2;
            c22212h = C22212h.scu;
            C22212h.cAs().mo20755fA(this.cgL.getTalkerUserName());
            c22212h = C22212h.scu;
            cAs = C22212h.cAs();
            if (this.mgQ) {
                j2 = 2;
            } else {
                C29294a c29294a = C29293i.scv;
                j2 = (long) C29294a.aaR(this.cgL.getTalkerUserName());
            }
            cAs.cZr = j2;
        }
        c22212h = C22212h.scu;
        C22212h.cAA().mo76056fs(this.cgL.getTalkerUserName());
        c22212h = C22212h.scu;
        C46878am cAA = C22212h.cAA();
        if (!this.mgQ) {
            C29294a c29294a2 = C29293i.scv;
            j = (long) C29294a.aaR(this.cgL.getTalkerUserName());
        }
        cAA.cZr = j;
        AppMethodBeat.m2505o(31726);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31727);
        super.dxB();
        this.mlA = false;
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", Integer.valueOf(hashCode()));
        if (this.ySl != null) {
            this.ySl.pause();
        }
        AppMethodBeat.m2505o(31727);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31728);
        super.dxC();
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", Integer.valueOf(hashCode()));
        dEY();
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20755fA("");
        c22212h = C22212h.scu;
        C22212h.cAs().cZK = 0;
        c22212h = C22212h.scu;
        C22212h.cAs().cZr = 0;
        c22212h = C22212h.scu;
        C22212h.cAA().mo76056fs("");
        c22212h = C22212h.scu;
        C22212h.cAA().cZr = 0;
        AppMethodBeat.m2505o(31728);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31729);
        super.dDh();
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", Integer.valueOf(hashCode()));
        dEY();
        AppMethodBeat.m2505o(31729);
    }

    private void dEY() {
        AppMethodBeat.m2504i(31730);
        if (this.ySl != null) {
            this.ySl.destroy();
            this.ySl.mo47444a(null);
            this.ySl = null;
        }
        this.pls = false;
        this.rXd = false;
        this.ySm.clear();
        this.ySp.clear();
        AppMethodBeat.m2505o(31730);
    }

    /* renamed from: a */
    public final void mo57049a(AvatarImageView avatarImageView) {
        AppMethodBeat.m2504i(31731);
        Object tag = avatarImageView.getTag();
        if (tag instanceof C40814ay) {
            boolean z;
            avatarImageView.mo70201dk(((C40814ay) tag).userName, 5);
            String str = ((C40814ay) tag).userName;
            if (!C46270n.isShowStoryCheck() || this.ySl == null) {
                z = false;
            } else {
                z = this.ySl.mo47443ZW(str);
            }
            avatarImageView.setShowStoryHint(z);
            this.ySp.put(avatarImageView.hashCode(), new WeakReference(avatarImageView));
        }
        AppMethodBeat.m2505o(31731);
    }

    public final void dEE() {
        AppMethodBeat.m2504i(31732);
        int i = C26373g.m41964Nu().getInt("StoryShouldShowEntraceInChatRoom", 1);
        if (!this.pls || i == 0) {
            C4990ab.m7417i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", Integer.valueOf(i));
            this.cgL.yTx.removeOptionMenu(3);
            AppMethodBeat.m2505o(31732);
            return;
        }
        if (this.ySn && C46270n.isShowStoryCheck()) {
            C4990ab.m7417i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", Boolean.valueOf(this.rXd), Integer.valueOf(hashCode()));
            if (this.rXd) {
                this.cgL.yTx.removeOptionMenu(3);
                m70392a(C1318a.icons_outlined_one_day_blue_video, this.yvX, this.cgL.yTx.getContext().getResources().getColor(C25738R.color.f11644a7));
                AppMethodBeat.m2505o(31732);
                return;
            }
            m70392a(C1318a.icons_outlined_one_day_video, this.yvX, 0);
        }
        AppMethodBeat.m2505o(31732);
    }

    /* renamed from: a */
    private void m70392a(int i, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        AppMethodBeat.m2504i(31733);
        if (this.cgL.yTx.findMenuInfo(3) == null) {
            this.cgL.yTx.addIconOptionMenu(3, i, onMenuItemClickListener, i2);
            AppMethodBeat.m2505o(31733);
            return;
        }
        this.cgL.yTx.updateOptionMenu(3, i, onMenuItemClickListener, i2);
        AppMethodBeat.m2505o(31733);
    }

    public final boolean arn(String str) {
        AppMethodBeat.m2504i(31734);
        if (System.currentTimeMillis() - this.iBO <= this.smo) {
            C4990ab.m7417i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.m2505o(31734);
            return true;
        }
        this.iBO = System.currentTimeMillis();
        List arrayList = new ArrayList(this.ySm);
        boolean remove = arrayList.remove(str);
        if (remove) {
            C4990ab.m7417i("MicroMsg.StoryStateComponent", "goToStoryGalleryWithUser click go %s", str);
            C46270n.m86707bj(2, str);
            C46270n.enterGallery(this.sbP);
            C46270n.m86703ZX(str);
            if (this.mgQ) {
                arrayList.add(0, str);
                C46270n.m86705a(this.cgL.yTx.getContext(), arrayList, this.cgL.getTalkerUserName(), this.cvF);
            } else {
                C46270n.m86706aT(this.cgL.yTx.getContext(), str);
            }
        }
        AppMethodBeat.m2505o(31734);
        return remove;
    }

    /* renamed from: a */
    public final void mo47450a(List<String> list, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(31735);
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", this.cgL.sRl, Integer.valueOf(list.size()), Integer.valueOf(hashCode()));
        this.ySm.clear();
        this.ySm.addAll(list);
        this.sbP.clear();
        this.sbP.addAll(arrayList);
        AppMethodBeat.m2505o(31735);
    }

    /* renamed from: L */
    public final void mo47449L(boolean z, boolean z2) {
        AppMethodBeat.m2504i(31736);
        C36137j c36137j = (C36137j) this.cgL.mo74857aF(C36137j.class);
        int i = z2 ? 1 : z ? 2 : 0;
        c36137j.mo57027Oz(i);
        if (this.pls == z && this.rXd == z2) {
            AppMethodBeat.m2505o(31736);
            return;
        }
        C4990ab.m7417i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.pls = z;
        this.rXd = z2;
        C5004al.m7441d(new C156072());
        dEZ();
        AppMethodBeat.m2505o(31736);
    }

    /* renamed from: bs */
    public final void mo47451bs(final String str, final boolean z) {
        AppMethodBeat.m2504i(31737);
        C4990ab.m7416i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31722);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < C40717al.this.ySp.size()) {
                        AvatarImageView avatarImageView = (AvatarImageView) ((WeakReference) C40717al.this.ySp.valueAt(i2)).get();
                        if (avatarImageView != null) {
                            Object tag = avatarImageView.getTag();
                            if ((tag instanceof C40814ay) && str.equals(((C40814ay) tag).userName)) {
                                avatarImageView.mo70201dk(((C40814ay) tag).userName, 5);
                                avatarImageView.setShowStoryHint(z);
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(31722);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.m2505o(31737);
    }

    private void dEZ() {
        AppMethodBeat.m2504i(31738);
        if (this.pls && this.mlA) {
            long j;
            this.mlA = false;
            C22212h c22212h = C22212h.scu;
            C1583aj cAy = C22212h.cAy();
            if (this.rXd) {
                j = 1;
            } else {
                j = 0;
            }
            cAy.cYR = j;
            c22212h = C22212h.scu;
            C22212h.cAz();
        }
        AppMethodBeat.m2505o(31738);
    }
}
