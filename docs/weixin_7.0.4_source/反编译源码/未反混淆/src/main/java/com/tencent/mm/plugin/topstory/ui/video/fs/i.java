package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public final class i extends e {
    protected b sDN;
    boolean sGI;
    boolean sGJ;
    g sGK;

    public i(b bVar) {
        super(bVar);
        this.sDN = bVar;
    }

    public final void j(final List<chw> list, final boolean z) {
        AppMethodBeat.i(2009);
        super.j(list, z);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2008);
                n cGg = i.this.sDN.cGg();
                synchronized (cGg) {
                    try {
                        List cGQ = cGg.cGQ();
                        ab.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGQ.size()), Integer.valueOf(list.size()));
                        int size;
                        i iVar;
                        if (z) {
                            size = cGQ.size();
                            if (cGQ.size() > 0) {
                                cGQ.clear();
                                cGQ.addAll(list);
                                if (i.this.sGJ) {
                                    i.this.aop.notifyChanged();
                                } else {
                                    if (!(i.this.sGK == null || cGQ == null || cGQ.get(0) == null)) {
                                        chw chw = (chw) cGQ.get(0);
                                        i.this.sGK.c(chw);
                                        i.this.sDn.put(chw, i.this.sGK);
                                        i.this.sGK = null;
                                        if ((chw.xhd & 128) > 0 && g.RP().Ry().getInt(a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            i.this.sDo.getRecyclerView().postDelayed(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                                                    com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(ah.getContext());
                                                    aVar.asL(i.this.sDo.bKU().getString(R.string.exg)).re(true);
                                                    aVar.Qg(R.string.r4).b(new c() {
                                                        public final void d(boolean z, String str) {
                                                        }
                                                    }).b(new OnDismissListener() {
                                                        public final void onDismiss(DialogInterface dialogInterface) {
                                                            AppMethodBeat.i(TXLiveConstants.PLAY_EVT_PLAY_END);
                                                            g.RP().Ry().set(a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(1));
                                                            g.RP().Ry().dsb();
                                                            AppMethodBeat.o(TXLiveConstants.PLAY_EVT_PLAY_END);
                                                        }
                                                    }).show();
                                                    AppMethodBeat.o(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                                                }
                                            }, 1000);
                                        }
                                    }
                                    iVar = i.this;
                                    iVar.at(iVar.getHeadersCount() + size, list.size() - size);
                                }
                                i.this.sDN.cFR().e((chw) list.get(0));
                            } else {
                                cGQ.addAll(list);
                                i.this.at(i.this.getHeadersCount(), list.size());
                            }
                        } else {
                            size = cGQ.size();
                            cGQ.addAll(list);
                            iVar = i.this;
                            iVar.cg(iVar.getHeadersCount() + size);
                            iVar = i.this;
                            iVar.at(size + iVar.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.o(2008);
                    }
                }
            }
        });
        AppMethodBeat.o(2009);
    }

    public final int FG(int i) {
        return 0;
    }
}
