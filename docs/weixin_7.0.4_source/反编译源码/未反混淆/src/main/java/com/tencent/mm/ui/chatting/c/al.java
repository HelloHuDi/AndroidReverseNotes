package com.tencent.mm.ui.chatting.c;

import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@a(dFp = x.class)
public class al extends a implements k.a, x {
    private String cvF = null;
    private long iBO = 0;
    private boolean mgQ = true;
    private boolean mlA = false;
    private boolean pls = false;
    private boolean rXd = false;
    private List<String> sbP = Collections.synchronizedList(new ArrayList());
    private long smo = 500;
    private k ySl;
    private List<String> ySm = Collections.synchronizedList(new ArrayList());
    private boolean ySn = false;
    private boolean ySo = false;
    private SparseArray<WeakReference<AvatarImageView>> ySp = new SparseArray();
    private OnMenuItemClickListener yvX = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            long j = 1;
            AppMethodBeat.i(31720);
            if (System.currentTimeMillis() - al.this.iBO <= al.this.smo) {
                ab.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(31720);
                return true;
            }
            al.this.iBO = System.currentTimeMillis();
            ab.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", Long.valueOf(al.this.iBO), Integer.valueOf(al.this.ySm.size()));
            h hVar;
            if (al.this.ySm.size() > 0) {
                long j2;
                String str = (String) al.this.ySm.get(0);
                ab.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", str);
                n.bj(1, str);
                n.enterGallery(al.this.sbP);
                n.ZX(str);
                hVar = h.scu;
                h.cAs().fC(al.this.cvF);
                if (al.this.mgQ) {
                    hVar = h.scu;
                    h.cAs().cYQ = 4;
                    n.a(al.this.cgL.yTx.getContext(), al.this.ySm, al.this.cgL.getTalkerUserName(), al.this.cvF);
                } else {
                    hVar = h.scu;
                    h.cAs().cYQ = 5;
                    n.aT(al.this.cgL.yTx.getContext(), (String) al.this.ySm.get(0));
                }
                hVar = h.scu;
                ar cAs = h.cAs();
                if (al.this.rXd) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                cAs.cYR = j2;
                AppMethodBeat.o(31720);
                return true;
            } else if (al.this.pls && al.this.mgQ) {
                hVar = h.scu;
                ar cAs2 = h.cAs();
                if (!al.this.rXd) {
                    j = 0;
                }
                cAs2.cYR = j;
                n.a(al.this.cgL.yTx.getContext(), al.this.ySm, al.this.cgL.getTalkerUserName(), al.this.cvF);
                hVar = h.scu;
                h.cAs().cYQ = 4;
                AppMethodBeat.o(31720);
                return true;
            } else {
                AppMethodBeat.o(31720);
                return false;
            }
        }
    };

    public al() {
        AppMethodBeat.i(31723);
        AppMethodBeat.o(31723);
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
        al alVar;
        al alVar2;
        h hVar;
        aj cAy;
        long j;
        boolean z = true;
        AppMethodBeat.i(31724);
        super.dxy();
        ab.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimStart: user %s hashCode:%s", this.cgL.getTalkerUserName(), Integer.valueOf(hashCode()));
        this.cgL.yTx.removeOptionMenu(3);
        this.pls = false;
        this.rXd = false;
        this.ySm.clear();
        this.sbP.clear();
        this.cvF = "";
        this.ySo = false;
        ((j) this.cgL.aF(j.class)).Oz(0);
        String talkerUserName = this.cgL.getTalkerUserName();
        if (c.isNullOrNil(talkerUserName)) {
            alVar = this;
        } else {
            this.mgQ = t.kH(talkerUserName);
            if (t.mO(talkerUserName)) {
                z = t.mO(talkerUserName);
                alVar2 = this;
            } else if (t.mR(talkerUserName) || t.mZ(talkerUserName) || t.mU(talkerUserName) || t.mV(talkerUserName) || t.nc(talkerUserName) || t.nd(talkerUserName) || t.nD(talkerUserName) || t.nI(talkerUserName) || t.no(talkerUserName) || t.mP(talkerUserName) || t.mO(talkerUserName)) {
                alVar = this;
            } else {
                alVar2 = this;
            }
            alVar2.ySn = z;
            if (this.ySn) {
                this.ySl = ((e) g.M(e.class)).getStoryStateFetcher(this.cgL.getTalkerUserName());
                if (this.ySl != null) {
                    this.ySl.a(this);
                    this.ySl.start();
                }
            }
            hVar = h.scu;
            h.cAy().fl(this.cgL.getTalkerUserName());
            hVar = h.scu;
            cAy = h.cAy();
            if (this.mgQ) {
                j = 5;
            } else {
                j = 4;
            }
            cAy.cYQ = j;
            hVar = h.scu;
            cAy = h.cAy();
            if (this.rXd) {
                j = 0;
            } else {
                j = 1;
            }
            cAy.cYR = j;
            if (this.mgQ) {
                this.cgL.yTB = com.tencent.mm.ui.e.aqC("5");
            } else {
                this.cgL.yTB = com.tencent.mm.ui.e.aqC("4");
            }
            this.cvF = this.cgL.dFt();
            AppMethodBeat.o(31724);
        }
        z = false;
        alVar2 = alVar;
        alVar2.ySn = z;
        if (this.ySn) {
        }
        hVar = h.scu;
        h.cAy().fl(this.cgL.getTalkerUserName());
        hVar = h.scu;
        cAy = h.cAy();
        if (this.mgQ) {
        }
        cAy.cYQ = j;
        hVar = h.scu;
        cAy = h.cAy();
        if (this.rXd) {
        }
        cAy.cYR = j;
        if (this.mgQ) {
        }
        this.cvF = this.cgL.dFt();
        AppMethodBeat.o(31724);
    }

    public final void dxz() {
        AppMethodBeat.i(31725);
        super.dxz();
        ab.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(31725);
    }

    public final void dxA() {
        h hVar;
        long j = 2;
        AppMethodBeat.i(31726);
        super.dxA();
        ab.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", Integer.valueOf(hashCode()));
        this.mlA = true;
        dEZ();
        if (this.ySl != null) {
            long j2;
            this.ySl.resume();
            hVar = h.scu;
            ar cAs = h.cAs();
            if (this.mgQ) {
                j2 = 10;
            } else {
                j2 = 11;
            }
            cAs.cYQ = j2;
            hVar = h.scu;
            h.cAs().fA(this.cgL.getTalkerUserName());
            hVar = h.scu;
            cAs = h.cAs();
            if (this.mgQ) {
                j2 = 2;
            } else {
                i.a aVar = i.scv;
                j2 = (long) i.a.aaR(this.cgL.getTalkerUserName());
            }
            cAs.cZr = j2;
        }
        hVar = h.scu;
        h.cAA().fs(this.cgL.getTalkerUserName());
        hVar = h.scu;
        am cAA = h.cAA();
        if (!this.mgQ) {
            i.a aVar2 = i.scv;
            j = (long) i.a.aaR(this.cgL.getTalkerUserName());
        }
        cAA.cZr = j;
        AppMethodBeat.o(31726);
    }

    public final void dxB() {
        AppMethodBeat.i(31727);
        super.dxB();
        this.mlA = false;
        ab.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", Integer.valueOf(hashCode()));
        if (this.ySl != null) {
            this.ySl.pause();
        }
        AppMethodBeat.o(31727);
    }

    public final void dxC() {
        AppMethodBeat.i(31728);
        super.dxC();
        ab.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", Integer.valueOf(hashCode()));
        dEY();
        h hVar = h.scu;
        h.cAs().fA("");
        hVar = h.scu;
        h.cAs().cZK = 0;
        hVar = h.scu;
        h.cAs().cZr = 0;
        hVar = h.scu;
        h.cAA().fs("");
        hVar = h.scu;
        h.cAA().cZr = 0;
        AppMethodBeat.o(31728);
    }

    public final void dDh() {
        AppMethodBeat.i(31729);
        super.dDh();
        ab.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", Integer.valueOf(hashCode()));
        dEY();
        AppMethodBeat.o(31729);
    }

    private void dEY() {
        AppMethodBeat.i(31730);
        if (this.ySl != null) {
            this.ySl.destroy();
            this.ySl.a(null);
            this.ySl = null;
        }
        this.pls = false;
        this.rXd = false;
        this.ySm.clear();
        this.ySp.clear();
        AppMethodBeat.o(31730);
    }

    public final void a(AvatarImageView avatarImageView) {
        AppMethodBeat.i(31731);
        Object tag = avatarImageView.getTag();
        if (tag instanceof ay) {
            boolean z;
            avatarImageView.dk(((ay) tag).userName, 5);
            String str = ((ay) tag).userName;
            if (!n.isShowStoryCheck() || this.ySl == null) {
                z = false;
            } else {
                z = this.ySl.ZW(str);
            }
            avatarImageView.setShowStoryHint(z);
            this.ySp.put(avatarImageView.hashCode(), new WeakReference(avatarImageView));
        }
        AppMethodBeat.o(31731);
    }

    public final void dEE() {
        AppMethodBeat.i(31732);
        int i = com.tencent.mm.m.g.Nu().getInt("StoryShouldShowEntraceInChatRoom", 1);
        if (!this.pls || i == 0) {
            ab.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", Integer.valueOf(i));
            this.cgL.yTx.removeOptionMenu(3);
            AppMethodBeat.o(31732);
            return;
        }
        if (this.ySn && n.isShowStoryCheck()) {
            ab.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", Boolean.valueOf(this.rXd), Integer.valueOf(hashCode()));
            if (this.rXd) {
                this.cgL.yTx.removeOptionMenu(3);
                a(R.raw.icons_outlined_one_day_blue_video, this.yvX, this.cgL.yTx.getContext().getResources().getColor(R.color.a7));
                AppMethodBeat.o(31732);
                return;
            }
            a(R.raw.icons_outlined_one_day_video, this.yvX, 0);
        }
        AppMethodBeat.o(31732);
    }

    private void a(int i, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        AppMethodBeat.i(31733);
        if (this.cgL.yTx.findMenuInfo(3) == null) {
            this.cgL.yTx.addIconOptionMenu(3, i, onMenuItemClickListener, i2);
            AppMethodBeat.o(31733);
            return;
        }
        this.cgL.yTx.updateOptionMenu(3, i, onMenuItemClickListener, i2);
        AppMethodBeat.o(31733);
    }

    public final boolean arn(String str) {
        AppMethodBeat.i(31734);
        if (System.currentTimeMillis() - this.iBO <= this.smo) {
            ab.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(31734);
            return true;
        }
        this.iBO = System.currentTimeMillis();
        List arrayList = new ArrayList(this.ySm);
        boolean remove = arrayList.remove(str);
        if (remove) {
            ab.i("MicroMsg.StoryStateComponent", "goToStoryGalleryWithUser click go %s", str);
            n.bj(2, str);
            n.enterGallery(this.sbP);
            n.ZX(str);
            if (this.mgQ) {
                arrayList.add(0, str);
                n.a(this.cgL.yTx.getContext(), arrayList, this.cgL.getTalkerUserName(), this.cvF);
            } else {
                n.aT(this.cgL.yTx.getContext(), str);
            }
        }
        AppMethodBeat.o(31734);
        return remove;
    }

    public final void a(List<String> list, ArrayList<String> arrayList) {
        AppMethodBeat.i(31735);
        ab.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", this.cgL.sRl, Integer.valueOf(list.size()), Integer.valueOf(hashCode()));
        this.ySm.clear();
        this.ySm.addAll(list);
        this.sbP.clear();
        this.sbP.addAll(arrayList);
        AppMethodBeat.o(31735);
    }

    public final void L(boolean z, boolean z2) {
        AppMethodBeat.i(31736);
        j jVar = (j) this.cgL.aF(j.class);
        int i = z2 ? 1 : z ? 2 : 0;
        jVar.Oz(i);
        if (this.pls == z && this.rXd == z2) {
            AppMethodBeat.o(31736);
            return;
        }
        ab.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.pls = z;
        this.rXd = z2;
        com.tencent.mm.sdk.platformtools.al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31721);
                ((r) al.this.cgL.aF(r.class)).dEp();
                AppMethodBeat.o(31721);
            }
        });
        dEZ();
        AppMethodBeat.o(31736);
    }

    public final void bs(final String str, final boolean z) {
        AppMethodBeat.i(31737);
        ab.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
        com.tencent.mm.sdk.platformtools.al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31722);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < al.this.ySp.size()) {
                        AvatarImageView avatarImageView = (AvatarImageView) ((WeakReference) al.this.ySp.valueAt(i2)).get();
                        if (avatarImageView != null) {
                            Object tag = avatarImageView.getTag();
                            if ((tag instanceof ay) && str.equals(((ay) tag).userName)) {
                                avatarImageView.dk(((ay) tag).userName, 5);
                                avatarImageView.setShowStoryHint(z);
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(31722);
                        return;
                    }
                }
            }
        });
        AppMethodBeat.o(31737);
    }

    private void dEZ() {
        AppMethodBeat.i(31738);
        if (this.pls && this.mlA) {
            long j;
            this.mlA = false;
            h hVar = h.scu;
            aj cAy = h.cAy();
            if (this.rXd) {
                j = 1;
            } else {
                j = 0;
            }
            cAy.cYR = j;
            hVar = h.scu;
            h.cAz();
        }
        AppMethodBeat.o(31738);
    }
}
