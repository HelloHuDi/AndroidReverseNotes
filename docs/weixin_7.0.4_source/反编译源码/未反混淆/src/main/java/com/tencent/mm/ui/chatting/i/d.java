package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.c.e;
import java.util.Date;
import java.util.LinkedList;

public final class d extends b {
    int eot = -1;
    int yZg = 0;

    class a extends com.tencent.mm.ui.chatting.a.c.b {
        public String desc;
        public int iconRes;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.i(32543);
            if (str != null) {
                boolean arg = super.arg(str.toLowerCase());
                AppMethodBeat.o(32543);
                return arg;
            }
            AppMethodBeat.o(32543);
            return false;
        }

        public final int getType() {
            return 6;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.c.a {
        TextView gnC;
        ImageView iqT;

        public b(View view) {
            super(view);
            AppMethodBeat.i(32544);
            this.iqT = (ImageView) view.findViewById(R.id.yk);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            this.gnC = (TextView) view.findViewById(R.id.aw);
            AppMethodBeat.o(32544);
        }
    }

    public d(Context context) {
        super(context);
    }

    public final int getType() {
        return 6;
    }

    public final void dFH() {
        AppMethodBeat.i(32545);
        ab.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.yYY.dFL();
        g.RQ();
        g.RS().aa(new Runnable() {
            final /* synthetic */ boolean kve = true;

            public final void run() {
                AppMethodBeat.i(32538);
                LinkedList linkedList = new LinkedList();
                aw.ZK();
                Cursor cu = c.XO().cu(d.this.emo, d.this.eot);
                if (cu == null) {
                    ab.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(32538);
                    return;
                }
                u oa;
                if (t.kH(d.this.emo)) {
                    aw.ZK();
                    oa = c.XV().oa(d.this.emo);
                } else {
                    oa = null;
                }
                long j = 0;
                while (cu.moveToNext()) {
                    try {
                        bi biVar = new bi();
                        biVar.d(cu);
                        String str = biVar.field_content;
                        if (str != null) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                            if (me != null) {
                                Object obj;
                                if (6 == me.type) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                    if (j != b) {
                                        linkedList.add(new com.tencent.mm.ui.chatting.a.c.c(biVar.field_createTime));
                                        d dVar = d.this;
                                        dVar.yZg++;
                                    }
                                    String b2 = b.b(biVar, t.kH(d.this.emo));
                                    ad aoO = ((j) g.K(j.class)).XM().aoO(b2);
                                    String str2 = "";
                                    if (oa != null) {
                                        str2 = oa.mJ(b2);
                                    }
                                    int LX = com.tencent.mm.plugin.fav.ui.c.LX(me.fgp);
                                    a aVar = new a(biVar.field_createTime, me.type, me.title, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2);
                                    aVar.iconRes = LX;
                                    aVar.desc = bo.ga((long) me.fgo);
                                    linkedList.add(aVar);
                                    j = b;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        cu.close();
                        AppMethodBeat.o(32538);
                    }
                }
                cu.close();
                d.this.iPr.addAll(linkedList);
                d.this.yZa = d.this.iPr;
                linkedList.clear();
                ab.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", Integer.valueOf(d.this.iPr.size()));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32537);
                        if (d.this.yYY != null) {
                            d.this.yYY.p(AnonymousClass1.this.kve, d.this.iPr.size());
                        }
                        AppMethodBeat.o(32537);
                    }
                });
                AppMethodBeat.o(32538);
            }
        });
        AppMethodBeat.o(32545);
    }

    public final String aoy() {
        AppMethodBeat.i(32546);
        String string = this.mContext.getString(R.string.fc);
        AppMethodBeat.o(32546);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.i(32547);
        String string = this.mContext.getString(R.string.fc);
        AppMethodBeat.o(32547);
        return string;
    }

    public final e dFI() {
        AppMethodBeat.i(32548);
        AnonymousClass2 anonymousClass2 = new e() {
            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32541);
                ab.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
                d.a(d.this, bVar);
                AppMethodBeat.o(32541);
            }

            public final void b(View view, int i, final com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32542);
                ab.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new com.tencent.mm.ui.tools.j(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(32539);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.dr8));
                        if (!(ad.aox(bVar.username) || t.mP(bVar.username))) {
                            contextMenu.add(0, 1, 0, view.getContext().getString(R.string.akj));
                        }
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.am7));
                        AppMethodBeat.o(32539);
                    }
                }, new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(32540);
                        aw.ZK();
                        d.this.d(menuItem.getItemId(), c.XO().jf(bVar.cvx));
                        AppMethodBeat.o(32540);
                    }
                });
                AppMethodBeat.o(32542);
            }
        };
        AppMethodBeat.o(32548);
        return anonymousClass2;
    }

    public final v v(ViewGroup viewGroup) {
        AppMethodBeat.i(32549);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zg, viewGroup, false));
        AppMethodBeat.o(32549);
        return bVar;
    }

    public final void a(com.tencent.mm.ui.chatting.a.c.a aVar, int i) {
        AppMethodBeat.i(32550);
        b bVar = (b) aVar;
        a aVar2 = (a) Oy(i);
        if (bo.isNullOrNil(aVar2.desc)) {
            bVar.gnC.setVisibility(8);
        } else {
            bVar.gnC.setVisibility(0);
            bVar.gnC.setText(bo.bc(aVar2.desc, ""));
        }
        bVar.iqT.setImageResource(aVar2.iconRes);
        AppMethodBeat.o(32550);
    }
}
