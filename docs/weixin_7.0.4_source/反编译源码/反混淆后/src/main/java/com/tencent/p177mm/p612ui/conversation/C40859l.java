package com.tencent.p177mm.p612ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.ui.conversation.l */
public final class C40859l {
    C14943d ein = new C14943d(new C158761());
    ListView zqz;
    C23987h zrd;
    boolean zvp = false;
    private C5004al zvq;
    private Runnable zvr;
    int zvs = -1;

    /* renamed from: com.tencent.mm.ui.conversation.l$1 */
    class C158761 implements OnScrollListener {
        C158761() {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(34573);
            if (i == 2) {
                C37634d.dvV().mo60468ev(MainUI.class.getName() + ".Listview", 4);
            }
            if (i != 0) {
                C40859l.this.dIV();
                AppMethodBeat.m2505o(34573);
            } else if (C40859l.this.zqz == null) {
                AppMethodBeat.m2505o(34573);
            } else {
                C40859l.m70793a(C40859l.this, -1);
                AppMethodBeat.m2505o(34573);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.l$2 */
    class C306972 implements Runnable {
        C306972() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34574);
            C40859l.m70793a(C40859l.this, 0);
            AppMethodBeat.m2505o(34574);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.l$3 */
    class C408583 implements Runnable {
        C408583() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34575);
            if (C40859l.this.zvp) {
                AppMethodBeat.m2505o(34575);
                return;
            }
            int lastVisiblePosition = C40859l.this.zqz.getLastVisiblePosition();
            int firstVisiblePosition = C40859l.this.zqz.getFirstVisiblePosition();
            int i = lastVisiblePosition - firstVisiblePosition;
            if (firstVisiblePosition == C40859l.this.zvs) {
                AppMethodBeat.m2505o(34575);
                return;
            }
            C40859l.this.zvs = firstVisiblePosition;
            C4990ab.m7411d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
            int i2 = lastVisiblePosition + 1;
            while (i2 < C40859l.this.zrd.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                try {
                    C40859l.this.zrd.mo39786Pw(i2);
                    i2++;
                } catch (RuntimeException e) {
                    C4990ab.printErrStackTrace("MicroMsg.PreLoadHelper", e, "Failed to preload MainUI avatars", new Object[0]);
                    AppMethodBeat.m2505o(34575);
                    return;
                }
            }
            i2 = firstVisiblePosition - 1;
            while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                C40859l.this.zrd.mo39786Pw(i2);
                i2--;
            }
            AppMethodBeat.m2505o(34575);
        }
    }

    public C40859l() {
        AppMethodBeat.m2504i(34576);
        AppMethodBeat.m2505o(34576);
    }

    /* Access modifiers changed, original: final */
    public final void dIV() {
        AppMethodBeat.m2504i(34577);
        if (!this.zvp) {
            C4990ab.m7410d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.zvp = true;
        }
        if (!(this.zvq == null || this.zvr == null)) {
            this.zvq.doN().removeCallbacks(this.zvr);
        }
        if (this.zvq != null) {
            this.zvq.oAl.quit();
            this.zvq = null;
        }
        AppMethodBeat.m2505o(34577);
    }

    /* renamed from: a */
    static /* synthetic */ void m70793a(C40859l c40859l, int i) {
        AppMethodBeat.m2504i(34578);
        if (i < 0) {
            i = 300;
        }
        c40859l.dIV();
        if (c40859l.zvq == null) {
            c40859l.zvq = new C5004al("pre load mainui avatar");
        }
        c40859l.zvp = false;
        C5004al c5004al = c40859l.zvq;
        C408583 c408583 = new C408583();
        c40859l.zvr = c408583;
        c5004al.mo10310m(c408583, (long) i);
        AppMethodBeat.m2505o(34578);
    }
}
