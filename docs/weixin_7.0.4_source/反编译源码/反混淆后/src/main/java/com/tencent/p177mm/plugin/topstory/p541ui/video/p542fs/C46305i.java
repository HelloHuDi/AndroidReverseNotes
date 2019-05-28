package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4233e;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.i */
public final class C46305i extends C4233e {
    protected C4232b sDN;
    boolean sGI;
    boolean sGJ;
    C29454g sGK;

    public C46305i(C4232b c4232b) {
        super(c4232b);
        this.sDN = c4232b;
    }

    /* renamed from: j */
    public final void mo9205j(final List<chw> list, final boolean z) {
        AppMethodBeat.m2504i(2009);
        super.mo9205j(list, z);
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.i$1$1 */
            class C224141 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.i$1$1$1 */
                class C224151 implements OnDismissListener {
                    C224151() {
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(TXLiveConstants.PLAY_EVT_PLAY_END);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(1));
                        C1720g.m3536RP().mo5239Ry().dsb();
                        AppMethodBeat.m2505o(TXLiveConstants.PLAY_EVT_PLAY_END);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.i$1$1$2 */
                class C224162 implements C5662c {
                    C224162() {
                    }

                    /* renamed from: d */
                    public final void mo5699d(boolean z, String str) {
                    }
                }

                C224141() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                    C5659a c5659a = new C5659a(C4996ah.getContext());
                    c5659a.asL(C46305i.this.sDo.bKU().getString(C25738R.string.exg)).mo11526re(true);
                    c5659a.mo11509Qg(C25738R.string.f9151r4).mo11522b(new C224162()).mo11521b(new C224151()).show();
                    AppMethodBeat.m2505o(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(2008);
                C13986n cGg = C46305i.this.sDN.cGg();
                synchronized (cGg) {
                    try {
                        List cGQ = cGg.cGQ();
                        C4990ab.m7417i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGQ.size()), Integer.valueOf(list.size()));
                        int size;
                        C46305i c46305i;
                        if (z) {
                            size = cGQ.size();
                            if (cGQ.size() > 0) {
                                cGQ.clear();
                                cGQ.addAll(list);
                                if (C46305i.this.sGJ) {
                                    C46305i.this.aop.notifyChanged();
                                } else {
                                    if (!(C46305i.this.sGK == null || cGQ == null || cGQ.get(0) == null)) {
                                        chw chw = (chw) cGQ.get(0);
                                        C46305i.this.sGK.mo76164c(chw);
                                        C46305i.this.sDn.put(chw, C46305i.this.sGK);
                                        C46305i.this.sGK = null;
                                        if ((chw.xhd & 128) > 0 && C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            C46305i.this.sDo.getRecyclerView().postDelayed(new C224141(), 1000);
                                        }
                                    }
                                    c46305i = C46305i.this;
                                    c46305i.mo66310at(c46305i.getHeadersCount() + size, list.size() - size);
                                }
                                C46305i.this.sDN.cFR().mo74506e((chw) list.get(0));
                            } else {
                                cGQ.addAll(list);
                                C46305i.this.mo66310at(C46305i.this.getHeadersCount(), list.size());
                            }
                        } else {
                            size = cGQ.size();
                            cGQ.addAll(list);
                            c46305i = C46305i.this;
                            c46305i.mo66316cg(c46305i.getHeadersCount() + size);
                            c46305i = C46305i.this;
                            c46305i.mo66310at(size + c46305i.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.m2505o(2008);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(2009);
    }

    /* renamed from: FG */
    public final int mo9196FG(int i) {
        return 0;
    }
}
