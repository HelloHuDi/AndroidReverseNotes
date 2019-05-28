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
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.account.friend.p273ui.C38040d.C18835a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.f */
public final class C9903f extends C38040d {
    /* renamed from: Zb */
    private final int f2867Zb;
    private final MMActivity crP;
    private String gtz;
    private C18835a gxG;
    boolean gxO = false;
    private C9904a gxP = new C20041();

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.f$1 */
    class C20041 implements C9904a {

        /* renamed from: com.tencent.mm.plugin.account.friend.ui.f$1$1 */
        class C20051 implements C14917a {
            C20051() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(108602);
                C4990ab.m7417i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                long longValue = new C1183p(C1183p.m2611cB(str2)).longValue();
                C9878ao ge = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73284ge(longValue);
                if (z && ge != null) {
                    ge.username = str;
                }
                if (ge != null) {
                    ge.frT = 2;
                    C4990ab.m7411d("MicroMsg.QQFriendAdapterCaseB", "f :%s", ge.toString());
                    ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(longValue, ge);
                    C9903f.this.mo6869KC();
                } else {
                    C4990ab.m7421w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", str2);
                }
                if (z && ge != null) {
                    C38040d.m64370wl(str);
                }
                AppMethodBeat.m2505o(108602);
            }
        }

        C20041() {
        }

        /* renamed from: d */
        public final void mo5754d(int i, String str, int i2) {
            AppMethodBeat.m2504i(108603);
            C4990ab.m7411d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            C9878ao c9878ao = (C9878ao) C9903f.this.getItem(i);
            if (c9878ao == null) {
                C4990ab.m7413e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.m2505o(108603);
                return;
            }
            C4990ab.m7411d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", c9878ao.toString());
            if (c9878ao.gwD == 1) {
                C14916a c14916a = new C14916a(C9903f.this.crP, new C20051());
                c14916a.gyj = c9878ao.gwC;
                c14916a.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                if (C5046bo.isNullOrNil(c9878ao.getUsername())) {
                    C4990ab.m7420w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    AppMethodBeat.m2505o(108603);
                    return;
                }
                c14916a.mo27242b(c9878ao.getUsername(), linkedList, true);
                c9878ao.frT = 1;
                ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(c9878ao.gwC, c9878ao);
                C9903f.this.mo6869KC();
            }
            AppMethodBeat.m2505o(108603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.f$a */
    interface C9904a {
        /* renamed from: d */
        void mo5754d(int i, String str, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.f$b */
    class C9905b {
        String account;
        ImageView eks;
        TextView gnh;
        int gtF;
        View gtH;
        TextView gtN;
        TextView gtO;
        TextView gtP;
        ProgressBar gtQ;
        int status;

        public C9905b(View view) {
            AppMethodBeat.m2504i(108605);
            this.gtN = (TextView) view.findViewById(2131824172);
            this.eks = (ImageView) view.findViewById(2131824173);
            this.gtO = (TextView) view.findViewById(2131824174);
            this.gtP = (TextView) view.findViewById(2131824175);
            this.gtH = view.findViewById(2131824176);
            this.gnh = (TextView) view.findViewById(2131824177);
            this.gtQ = (ProgressBar) view.findViewById(2131824178);
            this.gtH.setOnClickListener(new OnClickListener(C9903f.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(108604);
                    if (C9903f.this.gxP != null) {
                        C9903f.this.gxP.mo5754d(C9905b.this.gtF, C9905b.this.account, C9905b.this.status);
                    }
                    AppMethodBeat.m2505o(108604);
                }
            });
            AppMethodBeat.m2505o(108605);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(108612);
        C9878ao c9878ao = (C9878ao) obj;
        if (c9878ao == null) {
            c9878ao = new C9878ao();
        }
        c9878ao.mo21233d(cursor);
        AppMethodBeat.m2505o(108612);
        return c9878ao;
    }

    public C9903f(MMActivity mMActivity, int i) {
        super(mMActivity, new C9878ao());
        AppMethodBeat.m2504i(108606);
        this.crP = mMActivity;
        this.f2867Zb = i;
        this.gxO = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        mo74996pN(true);
        AppMethodBeat.m2505o(108606);
    }

    /* renamed from: a */
    public final void mo21259a(C18835a c18835a) {
        this.gxG = c18835a;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(108608);
        mo6869KC();
        AppMethodBeat.m2505o(108608);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(108609);
        bIf();
        if (C5046bo.isNullOrNil(this.gtz)) {
            setCursor(((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73280E(this.f2867Zb, this.gxO));
        } else {
            setCursor(((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73283c(this.f2867Zb, this.gtz, this.gxO));
        }
        if (!(this.gxG == null || this.gtz == null)) {
            this.gxG.mo34111mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(108609);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C9905b c9905b;
        int i2;
        AppMethodBeat.m2504i(108610);
        C9878ao c9878ao = (C9878ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.crP, 2130969602, null);
            C9905b c9905b2 = new C9905b(view);
            view.setTag(c9905b2);
            c9905b = c9905b2;
        } else {
            c9905b = (C9905b) view.getTag();
        }
        c9905b.gtF = i;
        c9905b.account = c9878ao.gwC;
        c9905b.status = c9878ao.gwD;
        c9905b.gtO.setText(C44089j.m79293b(this.crP, c9878ao.getDisplayName(), c9905b.gtO.getTextSize()));
        c9905b.gtP.setText(C44089j.m79293b(this.crP, c9878ao.mo21224Hs(), c9905b.gtP.getTextSize()));
        if (this.gxO) {
            Bitmap fr;
            if (C1183p.m2611cB(c9905b.account) != 0) {
                fr = C41730b.m73496fr(c9878ao.gwC);
            } else {
                fr = null;
            }
            if (fr == null) {
                c9905b.eks.setImageDrawable(C1338a.m2864g(this.crP, C1318a.default_avatar));
            } else {
                c9905b.eks.setImageBitmap(fr);
            }
        } else {
            C40460b.m69434b(c9905b.eks, c9878ao.getUsername());
        }
        if (!this.gxO) {
            switch (c9878ao.gwD) {
                case 1:
                case 2:
                    if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c9878ao.getUsername()) && !C1853r.m3846Yz().equals(c9878ao.getUsername())) {
                        if (c9878ao.frT != 2) {
                            c9905b.gtH.setClickable(true);
                            c9905b.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                            c9905b.gnh.setText(C25738R.string.c10);
                            c9905b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.a69));
                            break;
                        }
                        c9905b.gtH.setClickable(false);
                        c9905b.gtH.setBackgroundDrawable(null);
                        c9905b.gnh.setText(C25738R.string.c16);
                        c9905b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.f12121t4));
                        break;
                    }
                    c9905b.gtH.setClickable(false);
                    c9905b.gtH.setBackgroundDrawable(null);
                    c9905b.gnh.setText(C25738R.string.c11);
                    c9905b.gnh.setTextColor(this.crP.getResources().getColor(C25738R.color.f12121t4));
                    break;
                    break;
            }
            switch (c9878ao.frT) {
                case 0:
                case 2:
                    c9905b.gnh.setVisibility(0);
                    c9905b.gtQ.setVisibility(4);
                    break;
                case 1:
                    c9905b.gnh.setVisibility(4);
                    c9905b.gtQ.setVisibility(0);
                    break;
            }
        }
        c9905b.gtH.setVisibility(8);
        C9878ao c9878ao2 = (C9878ao) getItem(i - 1);
        if (c9878ao2 == null) {
            i2 = -1;
        } else {
            i2 = c9878ao2.frS;
        }
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = c9878ao2 != null ? c9878ao2.toString() : "";
        C4990ab.m7411d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = c9878ao != null ? c9878ao.toString() : "";
        C4990ab.m7411d(str, str2, objArr);
        if (i == 0) {
            String b = C9903f.m17541b(c9878ao);
            if (C5046bo.isNullOrNil(b)) {
                C4990ab.m7421w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", c9878ao.getUsername(), Integer.valueOf(i));
                c9905b.gtN.setVisibility(8);
            } else {
                c9905b.gtN.setVisibility(0);
                c9905b.gtN.setText(b);
                c9905b.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            int i3;
            if (c9878ao.frS != i2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String b2 = C9903f.m17541b(c9878ao);
            if (C5046bo.isNullOrNil(b2) || i3 == 0) {
                C4990ab.m7421w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", c9878ao.getUsername(), Integer.valueOf(i));
                c9905b.gtN.setVisibility(8);
            } else {
                c9905b.gtN.setVisibility(0);
                c9905b.gtN.setText(b2);
                c9905b.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.m2505o(108610);
        return view;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
    }

    /* renamed from: vM */
    public final void mo21261vM(String str) {
        AppMethodBeat.m2504i(108607);
        this.gtz = C5046bo.m7586vA(str.trim());
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(108607);
    }

    /* renamed from: b */
    private static String m17541b(C9878ao c9878ao) {
        AppMethodBeat.m2504i(108611);
        String str;
        if (c9878ao.frS == 123) {
            str = "#";
            AppMethodBeat.m2505o(108611);
            return str;
        }
        str = String.valueOf((char) c9878ao.frS);
        AppMethodBeat.m2505o(108611);
        return str;
    }
}
