package com.tencent.p177mm.p612ui.chatting.p619i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30451e;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30453a;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30455b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.appbrand.p328r.C38494e;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.p328r.C42666c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42666c.C38493a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.i.a */
public final class C46656a extends C24961b {
    private int eot = -1;
    C25814c yYR;

    /* renamed from: com.tencent.mm.ui.chatting.i.a$1 */
    class C237821 implements C38493a {
        final /* synthetic */ boolean kve = true;

        C237821() {
        }

        /* renamed from: z */
        public final void mo22471z(final LinkedList<C38494e> linkedList) {
            AppMethodBeat.m2504i(32507);
            C156881 c156881 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(32506);
                    if (!C5046bo.m7548ek(linkedList)) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            C38494e c38494e = (C38494e) it.next();
                            C46656a.this.iPr.add(new C41346a(c38494e.timestamp, c38494e.type, c38494e.title, c38494e.cvx, c38494e.username, c38494e.nickname, c38494e.bCv, c38494e.iQV, c38494e.fiQ, c38494e.cJM, c38494e.cKK, c38494e.desc, c38494e.imagePath, c38494e.iQW));
                        }
                    }
                    C46656a.this.yZa = C46656a.this.iPr;
                    if (C46656a.this.yYY != null) {
                        C46656a.this.yYY.mo27870p(C237821.this.kve, C46656a.this.iPr.size());
                    }
                    AppMethodBeat.m2505o(32506);
                }
            };
            if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
                C5004al.m7441d(c156881);
                AppMethodBeat.m2505o(32507);
                return;
            }
            c156881.run();
            AppMethodBeat.m2505o(32507);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.a$b */
    class C30518b extends C30453a {
        TextView gnC;
        ImageView iqT;
        TextView moL;

        public C30518b(View view) {
            super(view);
            AppMethodBeat.m2504i(32515);
            this.iqT = (ImageView) view.findViewById(2131821479);
            this.gnC = (TextView) view.findViewById(2131820602);
            this.moL = (TextView) view.findViewById(2131820615);
            this.moL.setVisibility(8);
            AppMethodBeat.m2505o(32515);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.a$a */
    class C41346a extends C30455b {
        public C8910b cJM;
        public long cKK;
        public String desc;
        public String fiQ;
        public String iQW;
        public String imagePath;

        public C41346a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5, String str6, C8910b c8910b, long j3, String str7, String str8, String str9) {
            super(j, i, str, j2, str2, str3, str4, str5);
            this.fiQ = str6;
            this.cJM = c8910b;
            this.cKK = j3;
            this.desc = str7;
            this.imagePath = str8;
            this.iQW = str9;
        }

        public final boolean arg(String str) {
            AppMethodBeat.m2504i(32514);
            if (str != null) {
                String toLowerCase = str.toLowerCase();
                if (C30455b.arh(toLowerCase)) {
                    if (!C5046bo.isNullOrNil(this.desc) && this.desc.toLowerCase().contains(toLowerCase)) {
                        AppMethodBeat.m2505o(32514);
                        return true;
                    }
                } else if (!C5046bo.isNullOrNil(this.desc) && isContains(toLowerCase, this.desc.toLowerCase())) {
                    AppMethodBeat.m2505o(32514);
                    return true;
                }
                boolean arg = super.arg(toLowerCase);
                AppMethodBeat.m2505o(32514);
                return arg;
            }
            AppMethodBeat.m2505o(32514);
            return false;
        }

        public final int getType() {
            return 33;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.a$2 */
    class C466552 implements C30451e {

        /* renamed from: com.tencent.mm.ui.chatting.i.a$2$1 */
        class C361891 implements OnCreateContextMenuListener {
            C361891() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            }
        }

        C466552() {
        }

        /* renamed from: a */
        public final void mo48855a(View view, int i, C30455b c30455b) {
            AppMethodBeat.m2504i(32509);
            C4990ab.m7417i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
            C46656a.m88346a(C46656a.this, (C41346a) c30455b);
            AppMethodBeat.m2505o(32509);
        }

        /* renamed from: b */
        public final void mo48856b(View view, int i, final C30455b c30455b) {
            AppMethodBeat.m2504i(32510);
            C4990ab.m7417i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
            new C46696j(view.getContext()).mo75009b(view, new C361891(), new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(32508);
                    C9638aw.m17190ZK();
                    C46656a.this.mo41865d(menuItem.getItemId(), C18628c.m29080XO().mo15340jf(c30455b.cvx));
                    AppMethodBeat.m2505o(32508);
                }
            });
            AppMethodBeat.m2505o(32510);
        }
    }

    public C46656a(Context context) {
        super(context);
        AppMethodBeat.m2504i(32516);
        C17927a c17927a = new C17927a();
        c17927a.ePT = C1318a.app_brand_app_default_icon_for_tail;
        c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 50), C1338a.fromDPToPix(C4996ah.getContext(), 50)).ePF = true;
        this.yYR = c17927a.ahG();
        AppMethodBeat.m2505o(32516);
    }

    public final int getType() {
        return 33;
    }

    public final void dFH() {
        AppMethodBeat.m2504i(32517);
        C4990ab.m7417i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.yYY.dFL();
        C42666c.reset();
        C42666c.m75549a(this.emo, new C237821());
        AppMethodBeat.m2505o(32517);
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32518);
        String string = this.mContext.getString(C25738R.string.dzi);
        AppMethodBeat.m2505o(32518);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.m2504i(32519);
        String string = this.mContext.getString(C25738R.string.dzi);
        AppMethodBeat.m2505o(32519);
        return string;
    }

    public final C30451e dFI() {
        AppMethodBeat.m2504i(32520);
        C466552 c466552 = new C466552();
        AppMethodBeat.m2505o(32520);
        return c466552;
    }

    /* renamed from: v */
    public final C41531v mo39525v(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(32521);
        C30518b c30518b = new C30518b(LayoutInflater.from(viewGroup.getContext()).inflate(2130968764, viewGroup, false));
        AppMethodBeat.m2505o(32521);
        return c30518b;
    }

    /* renamed from: a */
    public final void mo39523a(C30453a c30453a, int i) {
        AppMethodBeat.m2504i(32522);
        final C30518b c30518b = (C30518b) c30453a;
        final C41346a c41346a = (C41346a) mo39522Oy(i);
        if (C5046bo.isNullOrNil(c41346a.desc)) {
            c30518b.gnC.setVisibility(8);
        } else {
            c30518b.gnC.setVisibility(0);
            c30518b.gnC.setText(c30518b.gnB.getText());
            c30518b.gnB.setText(c41346a.desc);
            C30453a.m48568c(c30518b.gnC, this.yYZ.yNK);
            if (!C5046bo.isNullOrNil(c41346a.iQW)) {
                C37926b.abR().mo60686a(new C9676i() {
                    public final void abU() {
                    }

                    /* renamed from: x */
                    public final void mo6524x(Bitmap bitmap) {
                        AppMethodBeat.m2504i(32511);
                        if (bitmap == null || bitmap.isRecycled()) {
                            C32291o.ahp().mo43766a(c41346a.imagePath, c30518b.iqT, C46656a.this.yYR);
                            AppMethodBeat.m2505o(32511);
                            return;
                        }
                        c30518b.iqT.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(32511);
                    }

                    /* renamed from: mr */
                    public final void mo6522mr() {
                        AppMethodBeat.m2504i(32512);
                        C32291o.ahp().mo43766a(c41346a.imagePath, c30518b.iqT, C46656a.this.yYR);
                        AppMethodBeat.m2505o(32512);
                    }

                    /* renamed from: wP */
                    public final String mo6523wP() {
                        AppMethodBeat.m2504i(32513);
                        String str = "SEARCH#" + C38496n.m65148bE(this);
                        AppMethodBeat.m2505o(32513);
                        return str;
                    }
                }, c41346a.iQW, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(45, 45));
                AppMethodBeat.m2505o(32522);
                return;
            }
        }
        C32291o.ahp().mo43766a(c41346a.imagePath, c30518b.iqT, this.yYR);
        AppMethodBeat.m2505o(32522);
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(32523);
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            AppMethodBeat.m2505o(32523);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str22, 0);
                AppMethodBeat.m2505o(32523);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e, "", new Object[0]);
                AppMethodBeat.m2505o(32523);
            }
        }
        return packageInfo;
    }
}
