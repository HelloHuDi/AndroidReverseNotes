package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Looper;
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
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends b {
    private int eot = -1;
    c yYR;

    class b extends com.tencent.mm.ui.chatting.a.c.a {
        TextView gnC;
        ImageView iqT;
        TextView moL;

        public b(View view) {
            super(view);
            AppMethodBeat.i(32515);
            this.iqT = (ImageView) view.findViewById(R.id.yk);
            this.gnC = (TextView) view.findViewById(R.id.av);
            this.moL = (TextView) view.findViewById(R.id.b8);
            this.moL.setVisibility(8);
            AppMethodBeat.o(32515);
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.c.b {
        public com.tencent.mm.af.j.b cJM;
        public long cKK;
        public String desc;
        public String fiQ;
        public String iQW;
        public String imagePath;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5, String str6, com.tencent.mm.af.j.b bVar, long j3, String str7, String str8, String str9) {
            super(j, i, str, j2, str2, str3, str4, str5);
            this.fiQ = str6;
            this.cJM = bVar;
            this.cKK = j3;
            this.desc = str7;
            this.imagePath = str8;
            this.iQW = str9;
        }

        public final boolean arg(String str) {
            AppMethodBeat.i(32514);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (com.tencent.mm.ui.chatting.a.c.b.arh(toLowerCase)) {
                    if (!bo.isNullOrNil(this.desc) && this.desc.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.o(32514);
                        return true;
                    }
                } else if (!bo.isNullOrNil(this.desc) && isContains(toLowerCase, this.desc.toLowerCase())) {
                    AppMethodBeat.o(32514);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.o(32514);
                return arg;
            }
            AppMethodBeat.o(32514);
            return false;
        }

        public final int getType() {
            return 33;
        }
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(32516);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePT = R.raw.app_brand_app_default_icon_for_tail;
        aVar.ct(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50)).ePF = true;
        this.yYR = aVar.ahG();
        AppMethodBeat.o(32516);
    }

    public final int getType() {
        return 33;
    }

    public final void dFH() {
        AppMethodBeat.i(32517);
        ab.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.yYY.dFL();
        com.tencent.mm.plugin.appbrand.r.c.reset();
        com.tencent.mm.plugin.appbrand.r.c.a(this.emo, new com.tencent.mm.plugin.appbrand.r.c.a() {
            final /* synthetic */ boolean kve = true;

            public final void z(final LinkedList<e> linkedList) {
                AppMethodBeat.i(32507);
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32506);
                        if (!bo.ek(linkedList)) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                e eVar = (e) it.next();
                                a.this.iPr.add(new a(eVar.timestamp, eVar.type, eVar.title, eVar.cvx, eVar.username, eVar.nickname, eVar.bCv, eVar.iQV, eVar.fiQ, eVar.cJM, eVar.cKK, eVar.desc, eVar.imagePath, eVar.iQW));
                            }
                        }
                        a.this.yZa = a.this.iPr;
                        if (a.this.yYY != null) {
                            a.this.yYY.p(AnonymousClass1.this.kve, a.this.iPr.size());
                        }
                        AppMethodBeat.o(32506);
                    }
                };
                if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
                    al.d(anonymousClass1);
                    AppMethodBeat.o(32507);
                    return;
                }
                anonymousClass1.run();
                AppMethodBeat.o(32507);
            }
        });
        AppMethodBeat.o(32517);
    }

    public final String aoy() {
        AppMethodBeat.i(32518);
        String string = this.mContext.getString(R.string.dzi);
        AppMethodBeat.o(32518);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.i(32519);
        String string = this.mContext.getString(R.string.dzi);
        AppMethodBeat.o(32519);
        return string;
    }

    public final com.tencent.mm.ui.chatting.a.c.e dFI() {
        AppMethodBeat.i(32520);
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.ui.chatting.a.c.e() {
            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32509);
                ab.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
                a.a(a.this, (a) bVar);
                AppMethodBeat.o(32509);
            }

            public final void b(View view, int i, final com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32510);
                ab.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new j(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    }
                }, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(32508);
                        aw.ZK();
                        a.this.d(menuItem.getItemId(), com.tencent.mm.model.c.XO().jf(bVar.cvx));
                        AppMethodBeat.o(32508);
                    }
                });
                AppMethodBeat.o(32510);
            }
        };
        AppMethodBeat.o(32520);
        return anonymousClass2;
    }

    public final v v(ViewGroup viewGroup) {
        AppMethodBeat.i(32521);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ed, viewGroup, false));
        AppMethodBeat.o(32521);
        return bVar;
    }

    public final void a(com.tencent.mm.ui.chatting.a.c.a aVar, int i) {
        AppMethodBeat.i(32522);
        final b bVar = (b) aVar;
        final a aVar2 = (a) Oy(i);
        if (bo.isNullOrNil(aVar2.desc)) {
            bVar.gnC.setVisibility(8);
        } else {
            bVar.gnC.setVisibility(0);
            bVar.gnC.setText(bVar.gnB.getText());
            bVar.gnB.setText(aVar2.desc);
            com.tencent.mm.ui.chatting.a.c.a.c(bVar.gnC, this.yYZ.yNK);
            if (!bo.isNullOrNil(aVar2.iQW)) {
                com.tencent.mm.modelappbrand.a.b.abR().a(new i() {
                    public final void abU() {
                    }

                    public final void x(Bitmap bitmap) {
                        AppMethodBeat.i(32511);
                        if (bitmap == null || bitmap.isRecycled()) {
                            o.ahp().a(aVar2.imagePath, bVar.iqT, a.this.yYR);
                            AppMethodBeat.o(32511);
                            return;
                        }
                        bVar.iqT.setImageBitmap(bitmap);
                        AppMethodBeat.o(32511);
                    }

                    public final void mr() {
                        AppMethodBeat.i(32512);
                        o.ahp().a(aVar2.imagePath, bVar.iqT, a.this.yYR);
                        AppMethodBeat.o(32512);
                    }

                    public final String wP() {
                        AppMethodBeat.i(32513);
                        String str = "SEARCH#" + n.bE(this);
                        AppMethodBeat.o(32513);
                        return str;
                    }
                }, aVar2.iQW, null, ((com.tencent.mm.modelappbrand.i) g.K(com.tencent.mm.modelappbrand.i.class)).cq(45, 45));
                AppMethodBeat.o(32522);
                return;
            }
        }
        o.ahp().a(aVar2.imagePath, bVar.iqT, this.yYR);
        AppMethodBeat.o(32522);
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(32523);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.o(32523);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.o(32523);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.o(32523);
            }
        }
        return packageInfo;
    }
}
