package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.widget.a.e.c;
import java.util.List;

public final class e extends com.tencent.mm.plugin.topstory.ui.video.e {
    boolean sGI;
    boolean sGJ;
    boolean sGP;
    h sGQ;

    public e(b bVar) {
        super(bVar);
    }

    public final void j(final List<chw> list, final boolean z) {
        AppMethodBeat.i(2031);
        super.j(list, z);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2030);
                n cGg = ((b) e.this.sDo).cGg();
                synchronized (cGg) {
                    try {
                        List cGQ = cGg.cGQ();
                        ab.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGQ.size()), Integer.valueOf(list.size()));
                        if (z) {
                            int size = cGQ.size();
                            if (cGQ.size() > 0) {
                                if (((chw) cGQ.get(0)).xgS.equals(((chw) list.get(0)).xgS)) {
                                    cGQ.clear();
                                } else {
                                    list.remove(0);
                                }
                                cGQ.addAll(list);
                                if (e.this.sGJ) {
                                    e.this.aop.notifyChanged();
                                } else {
                                    if (!(e.this.sGQ == null || cGQ == null || cGQ.get(0) == null)) {
                                        chw chw = (chw) cGQ.get(0);
                                        e.this.sGQ.c(chw);
                                        e.this.sDn.put(chw, e.this.sGQ);
                                        e.this.sGQ = null;
                                        if ((chw.xhd & 128) > 0 && g.RP().Ry().getInt(a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            e.this.sDo.getRecyclerView().postDelayed(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(2029);
                                                    com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(ah.getContext());
                                                    aVar.asL(e.this.sDo.bKU().getString(R.string.exg)).re(true);
                                                    aVar.Qg(R.string.r4).b(new c() {
                                                        public final void d(boolean z, String str) {
                                                        }
                                                    }).b(new OnDismissListener() {
                                                        public final void onDismiss(DialogInterface dialogInterface) {
                                                            AppMethodBeat.i(2028);
                                                            g.RP().Ry().set(a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(1));
                                                            g.RP().Ry().dsb();
                                                            AppMethodBeat.o(2028);
                                                        }
                                                    }).show();
                                                    AppMethodBeat.o(2029);
                                                }
                                            }, 1000);
                                        }
                                    }
                                    e eVar = e.this;
                                    eVar.at(eVar.getHeadersCount() + size, list.size() - size);
                                }
                                ((b) e.this.sDo).cFR().e((chw) cGQ.get(0));
                            } else {
                                cGQ.addAll(list);
                                e.this.at(e.this.getHeadersCount(), list.size());
                            }
                        } else {
                            int size2 = cGQ.size();
                            cGQ.addAll(list);
                            e eVar2 = e.this;
                            eVar2.at(size2 + eVar2.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.o(2030);
                    }
                }
            }
        });
        AppMethodBeat.o(2031);
    }

    public final int FG(int i) {
        AppMethodBeat.i(2032);
        if (bo.ek(((b) this.sDo).cGg().FL(i - getHeadersCount()).wiH)) {
            AppMethodBeat.o(2032);
            return 0;
        }
        AppMethodBeat.o(2032);
        return 1;
    }
}
