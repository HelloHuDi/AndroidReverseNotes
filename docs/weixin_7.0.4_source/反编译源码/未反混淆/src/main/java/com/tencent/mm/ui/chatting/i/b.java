package com.tencent.mm.ui.chatting.i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public abstract class b implements f, a {
    protected String emo;
    protected ArrayList<com.tencent.mm.ui.chatting.a.c.b> iPr = null;
    private LinearLayoutManager jop;
    private boolean kuU = false;
    protected Context mContext;
    private long yUK = 0;
    protected com.tencent.mm.ui.chatting.e.b.b yYY;
    c yYZ;
    protected ArrayList<com.tencent.mm.ui.chatting.a.c.b> yZa = null;

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.chatting.view.a aVar) {
        com.tencent.mm.ui.chatting.e.b.b bVar = (com.tencent.mm.ui.chatting.e.b.b) aVar;
        this.yYY = bVar;
        bVar.a(this);
    }

    public b(Context context) {
        this.mContext = context;
        this.iPr = new ArrayList();
    }

    public final void onDetach() {
        this.yYY.a(null);
        this.yYY = null;
        if (this.yYZ != null) {
            c.yNI = null;
            c.yNJ = null;
        }
    }

    public final h dFG() {
        return new h() {
            int kvg = b.this.mContext.getResources().getColor(R.color.ov);
            ColorDrawable kvh = new ColorDrawable(this.kvg);
            int mSize = ((int) b.this.mContext.getResources().getDimension(R.dimen.f15do));

            {
                AppMethodBeat.i(32525);
                AppMethodBeat.o(32525);
            }

            public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(32526);
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (childAt.getTag() != null) {
                        com.tencent.mm.ui.chatting.a.c.b Oy = b.this.Oy(((Integer) childAt.getTag()).intValue() + 1);
                        if (Oy == null || Oy.getType() != BaseClientBuilder.API_PRIORITY_OTHER) {
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            int bottom = layoutParams.bottomMargin + childAt.getBottom();
                            this.kvh.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                            this.kvh.draw(canvas);
                        }
                    }
                }
                AppMethodBeat.o(32526);
            }
        };
    }

    public final com.tencent.mm.ui.chatting.a.c.b Oy(int i) {
        if (this.iPr == null || this.iPr.size() <= i) {
            return null;
        }
        return (com.tencent.mm.ui.chatting.a.c.b) this.iPr.get(i);
    }

    public final RecyclerView.a aru(String str) {
        this.emo = str;
        this.yYZ = new c(this.mContext, this);
        c.yNI = dFI();
        return this.yYZ;
    }

    public final int getCount() {
        if (this.iPr == null) {
            return 0;
        }
        return this.iPr.size();
    }

    public final com.tencent.mm.modelvoiceaddr.ui.b.a dFJ() {
        return new com.tencent.mm.modelvoiceaddr.ui.b.a() {
            private ap emH = new ap(aw.RS().oAl.getLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(32529);
                    String str = "MicroMsg.BaseHistoryListPresenter";
                    String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(b.this.yZa == null);
                    objArr[1] = Boolean.valueOf(bo.isNullOrNil(AnonymousClass2.this.yNK));
                    ab.i(str, str2, objArr);
                    if (bo.isNullOrNil(AnonymousClass2.this.yNK)) {
                        b.this.yYZ.yNK = AnonymousClass2.this.yNK;
                        if (b.this.yZa == null) {
                            b.this.dFH();
                        } else {
                            b.this.iPr = b.this.yZa;
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32527);
                                    if (b.this.yYY != null) {
                                        b.this.yYY.ch(AnonymousClass2.this.yNK, false);
                                        b.this.yYZ.aop.notifyChanged();
                                    }
                                    AppMethodBeat.o(32527);
                                }
                            });
                        }
                        AppMethodBeat.o(32529);
                    } else {
                        b.this.iPr = b.this.yZa;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = b.this.iPr.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.ui.chatting.a.c.b bVar = (com.tencent.mm.ui.chatting.a.c.b) it.next();
                            if (bVar.arg(AnonymousClass2.this.yNK)) {
                                arrayList.add(bVar);
                            }
                        }
                        b.this.iPr = arrayList;
                        b.this.yYZ.yNK = AnonymousClass2.this.yNK;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32528);
                                if (b.this.yYY != null) {
                                    b.this.yYZ.aop.notifyChanged();
                                    b.this.yYY.ch(AnonymousClass2.this.yNK, b.this.iPr.isEmpty());
                                }
                                AppMethodBeat.o(32528);
                            }
                        });
                        AppMethodBeat.o(32529);
                    }
                    return false;
                }
            }, false);
            String yNK = "";

            {
                AppMethodBeat.i(32530);
                AppMethodBeat.o(32530);
            }

            public final void amJ() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
            }

            public final void app() {
            }

            public final void apo() {
                AppMethodBeat.i(32531);
                ab.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
                if (b.this.yYY != null) {
                    b.this.yYY.onFinish();
                }
                AppMethodBeat.o(32531);
            }

            public final void vO(String str) {
                AppMethodBeat.i(32532);
                if (!this.yNK.equals(str)) {
                    this.yNK = str;
                    this.emH.stopTimer();
                    this.emH.ae(500, 500);
                }
                AppMethodBeat.o(32532);
            }

            public final boolean vN(String str) {
                return false;
            }

            public final void apq() {
            }

            public final void apr() {
                AppMethodBeat.i(32533);
                ab.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
                AppMethodBeat.o(32533);
            }
        };
    }

    protected static String b(bi biVar, boolean z) {
        String str = null;
        if (biVar == null) {
            return null;
        }
        if (biVar.field_isSend == 1) {
            return r.Yz();
        }
        if (z) {
            str = bf.oy(biVar.field_content);
        }
        if (bo.isNullOrNil(str)) {
            return biVar.field_talker;
        }
        return str;
    }

    public final void d(int i, bi biVar) {
        ab.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", Integer.valueOf(i));
        switch (i) {
            case 0:
                bI(biVar);
                return;
            case 1:
                bH(biVar);
                return;
            case 2:
                bJ(biVar);
                return;
            default:
                return;
        }
    }

    private void bH(bi biVar) {
        cl clVar = new cl();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(biVar);
        if (g.a(this.mContext, clVar, this.emo, arrayList, false)) {
            c(clVar);
        } else {
            ab.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
        }
    }

    private void c(cl clVar) {
        clVar.cvA.cvH = 45;
        clVar.cvA.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret != -2 && clVar.cvB.ret <= 0 && clVar.cvB.ret <= 0) {
            if (14 != clVar.cvA.type) {
                ab.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
            } else if (clVar.cvA.cvD == null) {
                ab.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.e(11142, Integer.valueOf(clVar.cvA.cvD.wiK), Integer.valueOf(clVar.cvA.cvD.wiL), Integer.valueOf(clVar.cvA.cvD.wiM), Integer.valueOf(clVar.cvA.cvD.wiN), Integer.valueOf(clVar.cvA.cvD.wiO), Integer.valueOf(clVar.cvA.cvD.wiP), Integer.valueOf(clVar.cvA.cvD.wiQ), Integer.valueOf(clVar.cvA.cvD.fileCount), Integer.valueOf(clVar.cvA.cvD.wiR), Integer.valueOf(clVar.cvA.cvD.wiS), Integer.valueOf(clVar.cvA.cvD.wiT), Integer.valueOf(clVar.cvA.cvD.wiU), Integer.valueOf(clVar.cvA.cvD.wiV), Integer.valueOf(clVar.cvA.cvD.wiW), Integer.valueOf(clVar.cvA.cvD.wiX));
            }
        }
    }

    private void bI(bi biVar) {
        com.tencent.mm.plugin.report.service.h.pYm.a(219, 19, 1, true);
        boolean endsWith = this.emo.toLowerCase().endsWith("@chatroom");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(biVar);
        k.a(this.mContext, arrayList, endsWith, this.emo, new ah() {
            public final void dCI() {
            }

            public final void a(ah.a aVar) {
            }

            public final void b(ah.a aVar) {
            }

            public final boolean dCJ() {
                return true;
            }
        });
    }

    private void bJ(final bi biVar) {
        com.tencent.mm.plugin.report.service.h.pYm.e(11627, Integer.valueOf(5));
        final TreeSet treeSet = new TreeSet();
        treeSet.add(Long.valueOf(biVar.field_msgId));
        com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(R.string.at7), "", this.mContext.getString(R.string.b59), this.mContext.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(32536);
                ab.i("MicroMsg.BaseHistoryListPresenter", "delete message");
                i.a(b.this.mContext, treeSet, new ah() {
                    public final void dCI() {
                    }

                    public final void a(ah.a aVar) {
                        AppMethodBeat.i(32534);
                        if (aVar == ah.a.del) {
                            AnonymousClass1 anonymousClass1 = new com.tencent.mm.ui.chatting.a.c.b() {
                                public final int getType() {
                                    return -1;
                                }
                            };
                            anonymousClass1.cvx = biVar.field_msgId;
                            b.this.iPr.remove(anonymousClass1);
                            b.this.yZa.remove(anonymousClass1);
                        }
                        AppMethodBeat.o(32534);
                    }

                    public final void b(ah.a aVar) {
                        AppMethodBeat.i(32535);
                        ab.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", Thread.currentThread(), aVar);
                        if (aVar == ah.a.del) {
                            b.this.yYZ.aop.notifyChanged();
                        }
                        AppMethodBeat.o(32535);
                    }

                    public final boolean dCJ() {
                        return true;
                    }
                });
                AppMethodBeat.o(32536);
            }
        }, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dFS() {
        long j = this.yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            aw.ZK();
            this.kuU = com.tencent.mm.model.c.isSDCardAvailable();
        }
        return this.kuU;
    }

    public final /* synthetic */ RecyclerView.i bfC() {
        if (this.jop == null) {
            this.jop = new LinearLayoutManager();
        }
        return this.jop;
    }
}
