package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class l {
    d ein = new d(new OnScrollListener() {
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(34573);
            if (i == 2) {
                com.tencent.mm.cf.d.dvV().ev(MainUI.class.getName() + ".Listview", 4);
            }
            if (i != 0) {
                l.this.dIV();
                AppMethodBeat.o(34573);
            } else if (l.this.zqz == null) {
                AppMethodBeat.o(34573);
            } else {
                l.a(l.this, -1);
                AppMethodBeat.o(34573);
            }
        }
    });
    ListView zqz;
    h zrd;
    boolean zvp = false;
    private al zvq;
    private Runnable zvr;
    int zvs = -1;

    public l() {
        AppMethodBeat.i(34576);
        AppMethodBeat.o(34576);
    }

    /* Access modifiers changed, original: final */
    public final void dIV() {
        AppMethodBeat.i(34577);
        if (!this.zvp) {
            ab.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.zvp = true;
        }
        if (!(this.zvq == null || this.zvr == null)) {
            this.zvq.doN().removeCallbacks(this.zvr);
        }
        if (this.zvq != null) {
            this.zvq.oAl.quit();
            this.zvq = null;
        }
        AppMethodBeat.o(34577);
    }

    static /* synthetic */ void a(l lVar, int i) {
        AppMethodBeat.i(34578);
        if (i < 0) {
            i = 300;
        }
        lVar.dIV();
        if (lVar.zvq == null) {
            lVar.zvq = new al("pre load mainui avatar");
        }
        lVar.zvp = false;
        al alVar = lVar.zvq;
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(34575);
                if (l.this.zvp) {
                    AppMethodBeat.o(34575);
                    return;
                }
                int lastVisiblePosition = l.this.zqz.getLastVisiblePosition();
                int firstVisiblePosition = l.this.zqz.getFirstVisiblePosition();
                int i = lastVisiblePosition - firstVisiblePosition;
                if (firstVisiblePosition == l.this.zvs) {
                    AppMethodBeat.o(34575);
                    return;
                }
                l.this.zvs = firstVisiblePosition;
                ab.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
                int i2 = lastVisiblePosition + 1;
                while (i2 < l.this.zrd.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                    try {
                        l.this.zrd.Pw(i2);
                        i2++;
                    } catch (RuntimeException e) {
                        ab.printErrStackTrace("MicroMsg.PreLoadHelper", e, "Failed to preload MainUI avatars", new Object[0]);
                        AppMethodBeat.o(34575);
                        return;
                    }
                }
                i2 = firstVisiblePosition - 1;
                while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                    l.this.zrd.Pw(i2);
                    i2--;
                }
                AppMethodBeat.o(34575);
            }
        };
        lVar.zvr = anonymousClass3;
        alVar.m(anonymousClass3, (long) i);
        AppMethodBeat.o(34578);
    }
}
