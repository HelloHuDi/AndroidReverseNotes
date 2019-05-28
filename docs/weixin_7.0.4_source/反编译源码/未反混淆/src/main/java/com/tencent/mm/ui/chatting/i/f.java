package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.e;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    int eot = -1;
    private int moz = 0;
    int yZg = 0;

    class a extends com.tencent.mm.ui.chatting.a.c.b {
        public String appId;
        public int iconRes;
        public String imagePath;
        public String source;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.i(32616);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (com.tencent.mm.ui.chatting.a.c.b.arh(toLowerCase)) {
                    if (!bo.isNullOrNil(this.source) && this.source.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.o(32616);
                        return true;
                    }
                } else if (!bo.isNullOrNil(this.source) && isContains(toLowerCase, this.source.toLowerCase())) {
                    AppMethodBeat.o(32616);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.o(32616);
                return arg;
            }
            AppMethodBeat.o(32616);
            return false;
        }

        public final int getType() {
            return 3;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.c.a {
        TextView gnC;
        ImageView iqT;
        TextView moL;
        ImageView moR;

        public b(View view) {
            super(view);
            AppMethodBeat.i(32617);
            this.iqT = (ImageView) view.findViewById(R.id.yk);
            this.gnC = (TextView) view.findViewById(R.id.av);
            this.gnC.setVisibility(8);
            this.moL = (TextView) view.findViewById(R.id.b8);
            this.moR = (ImageView) view.findViewById(R.id.yl);
            this.moR.setImageResource(R.drawable.vs);
            this.moR.setVisibility(0);
            AppMethodBeat.o(32617);
        }
    }

    public f(Context context) {
        super(context);
    }

    public final int getType() {
        return 3;
    }

    public final void dFH() {
        AppMethodBeat.i(32618);
        this.yYY.dFL();
        g.RQ();
        g.RS().aa(new Runnable() {
            final /* synthetic */ boolean kve = true;

            public final void run() {
                AppMethodBeat.i(32611);
                LinkedList linkedList = new LinkedList();
                aw.ZK();
                Cursor cu = c.XO().cu(f.this.emo, f.this.eot);
                if (cu == null) {
                    ab.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(32611);
                    return;
                }
                u oa;
                if (t.kH(f.this.emo)) {
                    aw.ZK();
                    oa = c.XV().oa(f.this.emo);
                } else {
                    oa = null;
                }
                long j = 0;
                while (cu.moveToNext()) {
                    try {
                        cy biVar = new bi();
                        biVar.d(cu);
                        String str = biVar.field_content;
                        if (str != null) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                            if (me != null) {
                                Object obj;
                                if (3 == me.type) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                    if (j != b) {
                                        linkedList.add(new com.tencent.mm.ui.chatting.a.c.c(biVar.field_createTime));
                                        f fVar = f.this;
                                        fVar.yZg++;
                                    }
                                    String b2 = b.b(biVar, t.kH(f.this.emo));
                                    ad aoO = ((j) g.K(j.class)).XM().aoO(b2);
                                    String str2 = "";
                                    if (oa != null) {
                                        str2 = oa.mJ(b2);
                                    }
                                    int LX = com.tencent.mm.plugin.fav.ui.c.LX(me.fgp);
                                    String appName = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, me.cMg);
                                    aw.ZK();
                                    ad aoO2 = c.XM().aoO(me.cMg);
                                    if (aoO2 == null || !aoO2.field_username.equals(me.cMg)) {
                                        com.tencent.mm.model.ao.a.flu.a(me.cMg, "", null);
                                    } else {
                                        appName = aoO2.Oj();
                                    }
                                    a aVar = new a(biVar.field_createTime, me.type, me.title, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2);
                                    aVar.source = bo.isNullOrNil(appName) ? me.description : appName;
                                    aVar.appId = me.appId;
                                    aVar.imagePath = biVar.field_imgPath;
                                    aVar.iconRes = LX;
                                    linkedList.add(aVar);
                                    j = b;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        cu.close();
                        AppMethodBeat.o(32611);
                    }
                }
                cu.close();
                f.this.iPr.addAll(linkedList);
                f.this.yZa = f.this.iPr;
                linkedList.clear();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32610);
                        if (f.this.yYY != null) {
                            f.this.yYY.p(AnonymousClass1.this.kve, f.this.iPr.size());
                        }
                        AppMethodBeat.o(32610);
                    }
                });
                AppMethodBeat.o(32611);
            }
        });
        AppMethodBeat.o(32618);
    }

    public final String aoy() {
        AppMethodBeat.i(32619);
        String string = this.mContext.getString(R.string.fd);
        AppMethodBeat.o(32619);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.i(32620);
        String string = this.mContext.getString(R.string.fd);
        AppMethodBeat.o(32620);
        return string;
    }

    public final e dFI() {
        AppMethodBeat.i(32621);
        AnonymousClass2 anonymousClass2 = new e() {
            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
                String str;
                int i2;
                AppMethodBeat.i(32614);
                aw.ZK();
                bi jf = c.XO().jf(bVar.cvx);
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(jf.field_content);
                String B = p.B(me.url, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                String B2 = p.B(me.fgn, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                PackageInfo packageInfo = f.getPackageInfo(f.this.mContext, me.appId);
                f fVar = f.this;
                if (packageInfo == null) {
                    str = null;
                } else {
                    str = packageInfo.versionName;
                }
                if (packageInfo == null) {
                    i2 = 0;
                } else {
                    i2 = packageInfo.versionCode;
                }
                fVar.a(B, B2, str, i2, me.appId, jf.field_msgId, jf.field_msgSvrId, jf);
                AppMethodBeat.o(32614);
            }

            public final void b(View view, int i, final com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32615);
                ab.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new com.tencent.mm.ui.tools.j(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(32612);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.dr8));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.string.akj));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.am7));
                        AppMethodBeat.o(32612);
                    }
                }, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(32613);
                        aw.ZK();
                        f.this.d(menuItem.getItemId(), c.XO().jf(bVar.cvx));
                        AppMethodBeat.o(32613);
                    }
                });
                AppMethodBeat.o(32615);
            }
        };
        AppMethodBeat.o(32621);
        return anonymousClass2;
    }

    public final v v(ViewGroup viewGroup) {
        AppMethodBeat.i(32622);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b17, viewGroup, false));
        AppMethodBeat.o(32622);
        return bVar;
    }

    public final void a(com.tencent.mm.ui.chatting.a.c.a aVar, int i) {
        AppMethodBeat.i(32623);
        b bVar = (b) aVar;
        a aVar2 = (a) Oy(i);
        bVar.enf.setText(com.tencent.mm.plugin.fav.ui.j.g(this.mContext, aVar2.timestamp));
        Bitmap a = o.ahl().a(aVar2.imagePath, com.tencent.mm.bz.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bz.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                bVar.iqT.setImageResource(R.raw.app_attach_file_icon_webpage);
                bVar.moL.setText(bo.bc(aVar2.source, ""));
                com.tencent.mm.ui.chatting.a.c.a.c(bVar.moL, this.yYZ.yNK);
                AppMethodBeat.o(32623);
            }
        }
        bVar.iqT.setImageBitmap(a);
        bVar.moL.setText(bo.bc(aVar2.source, ""));
        com.tencent.mm.ui.chatting.a.c.a.c(bVar.moL, this.yYZ.yNK);
        AppMethodBeat.o(32623);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, String str2, String str3, int i, String str4, long j, long j2, bi biVar) {
        AppMethodBeat.i(32624);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            ab.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            AppMethodBeat.o(32624);
            return;
        }
        if (at.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.emo);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String b = b.b(biVar, t.kH(this.emo));
        intent.putExtra("pre_username", b);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (biVar != null) {
            intent.putExtra("preUsername", b);
        }
        intent.putExtra("preChatName", this.emo);
        intent.putExtra("preChatTYPE", com.tencent.mm.model.u.ad(b, this.emo));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bp.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(32624);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(32625);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.o(32625);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.o(32625);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.o(32625);
            }
        }
        return packageInfo;
    }
}
