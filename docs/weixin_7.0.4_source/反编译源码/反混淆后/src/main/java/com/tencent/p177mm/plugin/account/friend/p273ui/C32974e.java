package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.account.friend.p273ui.C26595a.C26596a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C38040d.C18835a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C45500c.C9900a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C9906g.C9907a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.e */
public final class C32974e extends C38040d {
    /* renamed from: Zb */
    private final int f15026Zb;
    private final MMActivity crP;
    private String gtz;
    private final C26595a gxE;
    private final C45500c gxF;
    private C18835a gxG;
    boolean gxH = false;
    private C18836a gxI = new C329751();

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$a */
    interface C18836a {
        /* renamed from: d */
        void mo34112d(int i, String str, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$2 */
    class C265992 implements C26596a {
        C265992() {
        }

        /* renamed from: wk */
        public final void mo44377wk(String str) {
            AppMethodBeat.m2504i(108590);
            C45496ap c45496ap = (C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg();
            C9878ao wj = c45496ap.mo73286wj(str);
            if (wj == null) {
                C4990ab.m7421w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", String.valueOf(str));
                AppMethodBeat.m2505o(108590);
                return;
            }
            wj.gwD = 2;
            c45496ap.mo73281a(wj.gwC, wj);
            C32974e.this.notifyDataSetChanged();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null) {
                wj = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73286wj(str);
                if (wj != null) {
                    wj.aqu();
                    C4990ab.m7410d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + wj.gwC);
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(wj.gwC, wj);
                }
            } else if (!((aoO.field_conRemark != null && !aoO.field_conRemark.equals("")) || wj == null || wj.aqr() == null || wj.aqr().equals(""))) {
                C1855t.m3887b(aoO, wj.aqr());
            }
            C37907bv.aaq().mo60662c(26, new Object[0]);
            AppMethodBeat.m2505o(108590);
        }

        /* renamed from: W */
        public final void mo44376W(String str, boolean z) {
            AppMethodBeat.m2504i(108591);
            if (z) {
                C9878ao wj = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73286wj(str);
                if (wj != null) {
                    wj.aqu();
                    C4990ab.m7410d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + wj.gwC);
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(wj.gwC, wj);
                } else {
                    C4990ab.m7421w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", String.valueOf(str));
                }
            }
            C32974e.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(108591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$3 */
    class C266003 implements C9900a {
        C266003() {
        }

        /* renamed from: dm */
        public final void mo21257dm(boolean z) {
            AppMethodBeat.m2504i(108592);
            if (z) {
                C32974e.this.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(108592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$1 */
    class C329751 implements C18836a {

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$1$1 */
        class C20031 implements C9907a {
            C20031() {
            }

            /* renamed from: e */
            public final void mo5748e(boolean z, String str) {
                AppMethodBeat.m2504i(108587);
                C9878ao ge = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73284ge((long) C1183p.m2611cB(str));
                if (ge != null) {
                    ge.frT = 2;
                    C4990ab.m7411d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", ge.toString());
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(ge.gwC, ge);
                    C32974e.this.mo6869KC();
                    AppMethodBeat.m2505o(108587);
                    return;
                }
                C4990ab.m7421w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", ge);
                AppMethodBeat.m2505o(108587);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$1$2 */
        class C99012 implements C14917a {
            C99012() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(108588);
                C4990ab.m7417i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                long longValue = new C1183p(C1183p.m2611cB(str2)).longValue();
                C9878ao ge = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73284ge(longValue);
                if (ge != null && z) {
                    ge.username = str;
                }
                if (ge != null) {
                    ge.frT = 2;
                    C4990ab.m7411d("MicroMsg.QQFriendAdapter", "f :%s", ge.toString());
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(longValue, ge);
                    C32974e.this.mo6869KC();
                } else {
                    C4990ab.m7421w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                }
                if (z && ge != null) {
                    C38040d.m64370wl(str);
                }
                AppMethodBeat.m2505o(108588);
            }
        }

        C329751() {
        }

        /* renamed from: d */
        public final void mo34112d(int i, String str, int i2) {
            AppMethodBeat.m2504i(108589);
            C4990ab.m7411d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            C9878ao c9878ao = (C9878ao) C32974e.this.getItem(i);
            if (c9878ao == null) {
                C4990ab.m7413e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.m2505o(108589);
            } else if (C5046bo.isNullOrNil(c9878ao.getUsername())) {
                C4990ab.m7413e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", str);
                AppMethodBeat.m2505o(108589);
            } else {
                C4990ab.m7411d("MicroMsg.QQFriendAdapter", "qq friend:%s", c9878ao.toString());
                if (c9878ao.gwD == 0) {
                    int[] iArr = new int[]{C1183p.m2611cB(c9878ao.gwC)};
                    C9906g c9906g = new C9906g(C32974e.this.crP, new C20031(), (byte) 0);
                    c9906g.mo21262m(iArr);
                    c9906g.gyj = c9878ao.gwC;
                    c9878ao.frT = 1;
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(c9878ao.gwC, c9878ao);
                    C32974e.this.mo6869KC();
                    AppMethodBeat.m2505o(108589);
                    return;
                }
                if (c9878ao.gwD == 1) {
                    C14916a c14916a = new C14916a(C32974e.this.crP, new C99012());
                    c14916a.gyj = c9878ao.gwC;
                    c14916a.vjO = false;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(12));
                    c14916a.mo27242b(c9878ao.getUsername(), linkedList, true);
                    c9878ao.frT = 1;
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(c9878ao.gwC, c9878ao);
                    C32974e.this.mo6869KC();
                }
                AppMethodBeat.m2505o(108589);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.e$b */
    class C32976b {
        ImageView eks;
        TextView gnh;
        int gtF;
        TextView gtG;
        View gtH;
        ProgressBar gtI;
        String gxL;
        int status;

        public C32976b(View view) {
            AppMethodBeat.m2504i(108594);
            this.eks = (ImageView) view.findViewById(2131823840);
            this.gtG = (TextView) view.findViewById(2131823841);
            this.gtH = view.findViewById(2131826677);
            this.gnh = (TextView) view.findViewById(2131826678);
            this.gtI = (ProgressBar) view.findViewById(2131826679);
            this.gtH.setOnClickListener(new OnClickListener(C32974e.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(108593);
                    if (C32974e.this.gxI != null) {
                        C32974e.this.gxI.mo34112d(C32976b.this.gtF, C32976b.this.gxL, C32976b.this.status);
                    }
                    AppMethodBeat.m2505o(108593);
                }
            });
            AppMethodBeat.m2505o(108594);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(108601);
        C9878ao c9878ao = (C9878ao) obj;
        if (c9878ao == null) {
            c9878ao = new C9878ao();
        }
        c9878ao.mo21233d(cursor);
        AppMethodBeat.m2505o(108601);
        return c9878ao;
    }

    public C32974e(MMActivity mMActivity, int i) {
        super(mMActivity, new C9878ao());
        AppMethodBeat.m2504i(108595);
        this.crP = mMActivity;
        this.f15026Zb = i;
        this.gxH = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.gxE = new C26595a(mMActivity, new C265992());
        this.gxF = new C45500c(mMActivity, new C266003());
        AppMethodBeat.m2505o(108595);
    }

    /* renamed from: a */
    public final void mo21259a(C18835a c18835a) {
        this.gxG = c18835a;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(108597);
        mo6869KC();
        AppMethodBeat.m2505o(108597);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(108598);
        bIf();
        if (C5046bo.isNullOrNil(this.gtz)) {
            setCursor(((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73280E(this.f15026Zb, this.gxH));
        } else {
            setCursor(((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73283c(this.f15026Zb, this.gtz, this.gxH));
        }
        if (!(this.gxG == null || this.gtz == null)) {
            this.gxG.mo34111mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(108598);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C32976b c32976b;
        Bitmap fr;
        AppMethodBeat.m2504i(108599);
        C9878ao c9878ao = (C9878ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.crP, 2130970420, null);
            C32976b c32976b2 = new C32976b(view);
            view.setTag(c32976b2);
            c32976b = c32976b2;
        } else {
            c32976b = (C32976b) view.getTag();
        }
        c32976b.gtF = i;
        c32976b.gxL = c9878ao.gwC;
        c32976b.status = c9878ao.gwD;
        c32976b.gtG.setText(C44089j.m79293b(this.crP, c9878ao.getDisplayName(), c32976b.gtG.getTextSize()));
        if (C1183p.m2611cB(c9878ao.gwC) != 0) {
            fr = C41730b.m73496fr(c9878ao.gwC);
        } else {
            fr = null;
        }
        if (fr == null) {
            c32976b.eks.setImageDrawable(C1338a.m2864g(this.crP, C1318a.default_avatar));
        } else {
            c32976b.eks.setImageBitmap(fr);
        }
        if (!this.gxH) {
            switch (c9878ao.gwD) {
                case 0:
                    if (c9878ao.frT != 2) {
                        c32976b.gtH.setClickable(true);
                        c32976b.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                        c32976b.gnh.setText(C25738R.string.c12);
                        c32976b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.a69));
                        break;
                    }
                    c32976b.gtH.setClickable(false);
                    c32976b.gtH.setBackgroundDrawable(null);
                    c32976b.gnh.setText(C25738R.string.c13);
                    c32976b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.f12121t4));
                    break;
                case 1:
                case 2:
                    if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c9878ao.getUsername()) && !C1853r.m3846Yz().equals(c9878ao.getUsername())) {
                        if (c9878ao.frT != 2) {
                            c32976b.gtH.setClickable(true);
                            c32976b.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                            c32976b.gnh.setText(C25738R.string.c10);
                            c32976b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.a69));
                            break;
                        }
                        c32976b.gtH.setClickable(false);
                        c32976b.gtH.setBackgroundDrawable(null);
                        c32976b.gnh.setText(C25738R.string.c16);
                        c32976b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.f12121t4));
                        break;
                    }
                    c32976b.gtH.setClickable(false);
                    c32976b.gtH.setBackgroundDrawable(null);
                    c32976b.gnh.setText(C25738R.string.c11);
                    c32976b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.f12121t4));
                    break;
                    break;
            }
            switch (c9878ao.frT) {
                case 0:
                case 2:
                    c32976b.gnh.setVisibility(0);
                    c32976b.gtI.setVisibility(4);
                    break;
                case 1:
                    c32976b.gnh.setVisibility(4);
                    c32976b.gtI.setVisibility(0);
                    break;
            }
        }
        c32976b.gtH.setVisibility(8);
        AppMethodBeat.m2505o(108599);
        return view;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(108600);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(108600);
    }

    /* renamed from: vM */
    public final void mo21261vM(String str) {
        AppMethodBeat.m2504i(108596);
        this.gtz = C5046bo.m7586vA(str.trim());
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(108596);
    }
}
