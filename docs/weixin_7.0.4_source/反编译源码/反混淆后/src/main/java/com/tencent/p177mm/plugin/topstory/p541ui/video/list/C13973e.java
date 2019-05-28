package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4233e;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.e */
public final class C13973e extends C4233e {
    boolean sGI;
    boolean sGJ;
    boolean sGP;
    C46950h sGQ;

    public C13973e(C13969b c13969b) {
        super(c13969b);
    }

    /* renamed from: j */
    public final void mo9205j(final List<chw> list, final boolean z) {
        AppMethodBeat.m2504i(2031);
        super.mo9205j(list, z);
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.e$1$1 */
            class C139721 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.e$1$1$1 */
                class C139701 implements OnDismissListener {
                    C139701() {
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(2028);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(1));
                        C1720g.m3536RP().mo5239Ry().dsb();
                        AppMethodBeat.m2505o(2028);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.e$1$1$2 */
                class C139712 implements C5662c {
                    C139712() {
                    }

                    /* renamed from: d */
                    public final void mo5699d(boolean z, String str) {
                    }
                }

                C139721() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(2029);
                    C5659a c5659a = new C5659a(C4996ah.getContext());
                    c5659a.asL(C13973e.this.sDo.bKU().getString(C25738R.string.exg)).mo11526re(true);
                    c5659a.mo11509Qg(C25738R.string.f9151r4).mo11522b(new C139712()).mo11521b(new C139701()).show();
                    AppMethodBeat.m2505o(2029);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(2030);
                C13986n cGg = ((C13969b) C13973e.this.sDo).cGg();
                synchronized (cGg) {
                    try {
                        List cGQ = cGg.cGQ();
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGQ.size()), Integer.valueOf(list.size()));
                        if (z) {
                            int size = cGQ.size();
                            if (cGQ.size() > 0) {
                                if (((chw) cGQ.get(0)).xgS.equals(((chw) list.get(0)).xgS)) {
                                    cGQ.clear();
                                } else {
                                    list.remove(0);
                                }
                                cGQ.addAll(list);
                                if (C13973e.this.sGJ) {
                                    C13973e.this.aop.notifyChanged();
                                } else {
                                    if (!(C13973e.this.sGQ == null || cGQ == null || cGQ.get(0) == null)) {
                                        chw chw = (chw) cGQ.get(0);
                                        C13973e.this.sGQ.mo76164c(chw);
                                        C13973e.this.sDn.put(chw, C13973e.this.sGQ);
                                        C13973e.this.sGQ = null;
                                        if ((chw.xhd & 128) > 0 && C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            C13973e.this.sDo.getRecyclerView().postDelayed(new C139721(), 1000);
                                        }
                                    }
                                    C13973e c13973e = C13973e.this;
                                    c13973e.mo66310at(c13973e.getHeadersCount() + size, list.size() - size);
                                }
                                ((C13969b) C13973e.this.sDo).cFR().mo74506e((chw) cGQ.get(0));
                            } else {
                                cGQ.addAll(list);
                                C13973e.this.mo66310at(C13973e.this.getHeadersCount(), list.size());
                            }
                        } else {
                            int size2 = cGQ.size();
                            cGQ.addAll(list);
                            C13973e c13973e2 = C13973e.this;
                            c13973e2.mo66310at(size2 + c13973e2.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.m2505o(2030);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(2031);
    }

    /* renamed from: FG */
    public final int mo9196FG(int i) {
        AppMethodBeat.m2504i(2032);
        if (C5046bo.m7548ek(((C13969b) this.sDo).cGg().mo26218FL(i - getHeadersCount()).wiH)) {
            AppMethodBeat.m2505o(2032);
            return 0;
        }
        AppMethodBeat.m2505o(2032);
        return 1;
    }
}
