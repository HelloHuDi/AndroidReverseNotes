package com.tencent.p177mm.p612ui.chatting.p619i;

import android.content.Context;
import android.database.Cursor;
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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30451e;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30453a;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30454c;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30455b;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Date;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.i.d */
public final class C30519d extends C24961b {
    int eot = -1;
    int yZg = 0;

    /* renamed from: com.tencent.mm.ui.chatting.i.d$1 */
    class C237851 implements Runnable {
        final /* synthetic */ boolean kve = true;

        /* renamed from: com.tencent.mm.ui.chatting.i.d$1$1 */
        class C237841 implements Runnable {
            C237841() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32537);
                if (C30519d.this.yYY != null) {
                    C30519d.this.yYY.mo27870p(C237851.this.kve, C30519d.this.iPr.size());
                }
                AppMethodBeat.m2505o(32537);
            }
        }

        C237851() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32538);
            LinkedList linkedList = new LinkedList();
            C9638aw.m17190ZK();
            Cursor cu = C18628c.m29080XO().mo15322cu(C30519d.this.emo, C30519d.this.eot);
            if (cu == null) {
                C4990ab.m7412e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
                AppMethodBeat.m2505o(32538);
                return;
            }
            C7577u oa;
            if (C1855t.m3896kH(C30519d.this.emo)) {
                C9638aw.m17190ZK();
                oa = C18628c.m29087XV().mo14885oa(C30519d.this.emo);
            } else {
                oa = null;
            }
            long j = 0;
            while (cu.moveToNext()) {
                try {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(cu);
                    String str = c7620bi.field_content;
                    if (str != null) {
                        C8910b me = C8910b.m16064me(str);
                        if (me != null) {
                            Object obj;
                            if (6 == me.type) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                long b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                                if (j != b) {
                                    linkedList.add(new C30454c(c7620bi.field_createTime));
                                    C30519d c30519d = C30519d.this;
                                    c30519d.yZg++;
                                }
                                String b2 = C24961b.m39082b(c7620bi, C1855t.m3896kH(C30519d.this.emo));
                                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(b2);
                                String str2 = "";
                                if (oa != null) {
                                    str2 = oa.mo16807mJ(b2);
                                }
                                int LX = C45932c.m85252LX(me.fgp);
                                C30523a c30523a = new C30523a(c7620bi.field_createTime, me.type, me.title, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2);
                                c30523a.iconRes = LX;
                                c30523a.desc = C5046bo.m7565ga((long) me.fgo);
                                linkedList.add(c30523a);
                                j = b;
                            }
                        }
                    }
                } catch (Throwable th) {
                    cu.close();
                    AppMethodBeat.m2505o(32538);
                }
            }
            cu.close();
            C30519d.this.iPr.addAll(linkedList);
            C30519d.this.yZa = C30519d.this.iPr;
            linkedList.clear();
            C4990ab.m7417i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", Integer.valueOf(C30519d.this.iPr.size()));
            C5004al.m7441d(new C237841());
            AppMethodBeat.m2505o(32538);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.d$2 */
    class C305202 implements C30451e {
        C305202() {
        }

        /* renamed from: a */
        public final void mo48855a(View view, int i, C30455b c30455b) {
            AppMethodBeat.m2504i(32541);
            C4990ab.m7417i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
            C30519d.m48626a(C30519d.this, c30455b);
            AppMethodBeat.m2505o(32541);
        }

        /* renamed from: b */
        public final void mo48856b(View view, int i, final C30455b c30455b) {
            AppMethodBeat.m2504i(32542);
            C4990ab.m7417i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
            new C46696j(view.getContext()).mo75009b(view, new OnCreateContextMenuListener() {
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.m2504i(32539);
                    contextMenu.add(0, 0, 0, view.getContext().getString(C25738R.string.dr8));
                    if (!(C7616ad.aox(c30455b.username) || C1855t.m3903mP(c30455b.username))) {
                        contextMenu.add(0, 1, 0, view.getContext().getString(C25738R.string.akj));
                    }
                    contextMenu.add(0, 2, 0, view.getContext().getString(C25738R.string.am7));
                    AppMethodBeat.m2505o(32539);
                }
            }, new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(32540);
                    C9638aw.m17190ZK();
                    C30519d.this.mo41865d(menuItem.getItemId(), C18628c.m29080XO().mo15340jf(c30455b.cvx));
                    AppMethodBeat.m2505o(32540);
                }
            });
            AppMethodBeat.m2505o(32542);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.d$a */
    class C30523a extends C30455b {
        public String desc;
        public int iconRes;

        public C30523a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.m2504i(32543);
            if (str != null) {
                boolean arg = super.arg(str.toLowerCase());
                AppMethodBeat.m2505o(32543);
                return arg;
            }
            AppMethodBeat.m2505o(32543);
            return false;
        }

        public final int getType() {
            return 6;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.d$b */
    class C30524b extends C30453a {
        TextView gnC;
        ImageView iqT;

        public C30524b(View view) {
            super(view);
            AppMethodBeat.m2504i(32544);
            this.iqT = (ImageView) view.findViewById(2131821479);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            this.gnC = (TextView) view.findViewById(2131820603);
            AppMethodBeat.m2505o(32544);
        }
    }

    public C30519d(Context context) {
        super(context);
    }

    public final int getType() {
        return 6;
    }

    public final void dFH() {
        AppMethodBeat.m2504i(32545);
        C4990ab.m7417i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.yYY.dFL();
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C237851());
        AppMethodBeat.m2505o(32545);
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32546);
        String string = this.mContext.getString(C25738R.string.f8799fc);
        AppMethodBeat.m2505o(32546);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.m2504i(32547);
        String string = this.mContext.getString(C25738R.string.f8799fc);
        AppMethodBeat.m2505o(32547);
        return string;
    }

    public final C30451e dFI() {
        AppMethodBeat.m2504i(32548);
        C305202 c305202 = new C305202();
        AppMethodBeat.m2505o(32548);
        return c305202;
    }

    /* renamed from: v */
    public final C41531v mo39525v(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(32549);
        C30524b c30524b = new C30524b(LayoutInflater.from(viewGroup.getContext()).inflate(2130969547, viewGroup, false));
        AppMethodBeat.m2505o(32549);
        return c30524b;
    }

    /* renamed from: a */
    public final void mo39523a(C30453a c30453a, int i) {
        AppMethodBeat.m2504i(32550);
        C30524b c30524b = (C30524b) c30453a;
        C30523a c30523a = (C30523a) mo39522Oy(i);
        if (C5046bo.isNullOrNil(c30523a.desc)) {
            c30524b.gnC.setVisibility(8);
        } else {
            c30524b.gnC.setVisibility(0);
            c30524b.gnC.setText(C5046bo.m7532bc(c30523a.desc, ""));
        }
        c30524b.iqT.setImageResource(c30523a.iconRes);
        AppMethodBeat.m2505o(32550);
    }
}
