package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.C42279b.C26573a;
import com.tencent.p177mm.plugin.account.bind.p271ui.C42279b.C38030b;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14918b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.d */
public final class C45494d extends C42279b {
    private C26573a gtA;
    private C38030b gtB = new C265751();
    private int[] gty;
    private String gtz;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.d$1 */
    class C265751 implements C38030b {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.d$1$1 */
        class C19811 implements C14917a {
            C19811() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(13706);
                C4990ab.m7417i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                C18817a vW = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34092vW(str2);
                if (vW == null) {
                    C4990ab.m7421w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", str2);
                } else if (z) {
                    vW.username = str;
                    vW.status = 2;
                    vW.frT = 2;
                    C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "f :%s", vW.toString());
                    ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34084a(str2, vW);
                    C45494d.this.mo6869KC();
                    C37907bv.aaq().mo60662c(26, new Object[0]);
                    AppMethodBeat.m2505o(13706);
                    return;
                }
                AppMethodBeat.m2505o(13706);
            }
        }

        C265751() {
        }

        /* renamed from: c */
        public final void mo44352c(int i, String str, int i2) {
            AppMethodBeat.m2504i(13709);
            C4990ab.m7417i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final C18817a c18817a = (C18817a) C45494d.this.getItem(i);
            if (c18817a == null) {
                C4990ab.m7413e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.m2505o(13709);
                return;
            }
            C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", c18817a.toString());
            if (c18817a.status == 1) {
                C14916a c14916a = new C14916a(C45494d.this.context, new C19811());
                c14916a.vjI = new C14918b() {
                    /* renamed from: vQ */
                    public final boolean mo8211vQ(String str) {
                        AppMethodBeat.m2504i(13707);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", c18817a.getUsername());
                        intent.putExtra("Contact_Nick", c18817a.apD());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(C5495b.yfT, str);
                        C25985d.m41468b(C45494d.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        AppMethodBeat.m2505o(13707);
                        return true;
                    }
                };
                if (C45494d.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) C45494d.this.context).ifE = new C5186a() {
                        /* renamed from: c */
                        public final void mo6069c(int i, int i2, Intent intent) {
                            AppMethodBeat.m2504i(13708);
                            if (i == 1 && i2 == -1) {
                                ((MobileFriendUI) C45494d.this.context).mo67798b(c18817a);
                            }
                            AppMethodBeat.m2505o(13708);
                        }
                    };
                }
                c14916a.gyj = c18817a.mo34067Aq();
                c14916a.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                c14916a.mo27242b(c18817a.getUsername(), linkedList, false);
            }
            AppMethodBeat.m2505o(13709);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.d$a */
    class C45493a {
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

        public C45493a(View view) {
            AppMethodBeat.m2504i(13711);
            this.gtN = (TextView) view.findViewById(2131824172);
            this.eks = (ImageView) view.findViewById(2131824173);
            this.gtO = (TextView) view.findViewById(2131824174);
            this.gtP = (TextView) view.findViewById(2131824175);
            this.gtH = view.findViewById(2131824176);
            this.gnh = (TextView) view.findViewById(2131824177);
            this.gtQ = (ProgressBar) view.findViewById(2131824178);
            this.gtH.setOnClickListener(new OnClickListener(C45494d.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(13710);
                    if (C45494d.this.gtB != null) {
                        C45494d.this.gtB.mo44352c(C45493a.this.gtF, C45493a.this.account, C45493a.this.status);
                    }
                    AppMethodBeat.m2505o(13710);
                }
            });
            AppMethodBeat.m2505o(13711);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(13718);
        C18817a c18817a = (C18817a) obj;
        if (c18817a == null) {
            c18817a = new C18817a();
        }
        c18817a.mo34080d(cursor);
        AppMethodBeat.m2505o(13718);
        return c18817a;
    }

    /* renamed from: a */
    public final void mo67802a(C26573a c26573a) {
        this.gtA = c26573a;
    }

    public C45494d(Context context, C30723a c30723a) {
        super(context, new C18817a());
        AppMethodBeat.m2504i(13712);
        super.mo74992a(c30723a);
        this.context = context;
        mo74996pN(true);
        AppMethodBeat.m2505o(13712);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(13714);
        mo6869KC();
        AppMethodBeat.m2505o(13714);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(13715);
        bIf();
        setCursor(((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34091vV(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gtA == null || this.gtz == null)) {
            this.gtA.mo5733mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(13715);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C45493a c45493a;
        int i2;
        AppMethodBeat.m2504i(13716);
        C18817a c18817a = (C18817a) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, 2130969602, null);
            C45493a c45493a2 = new C45493a(view);
            view.setTag(c45493a2);
            c45493a = c45493a2;
        } else {
            c45493a = (C45493a) view.getTag();
        }
        c45493a.gtF = i;
        c45493a.account = c18817a.mo34067Aq();
        c45493a.status = c18817a.status;
        c45493a.gtO.setText(c18817a.apA());
        c45493a.gtP.setText(this.context.getString(C25738R.string.c17) + c18817a.apD());
        C40460b.m69434b(c45493a.eks, c18817a.getUsername());
        switch (c18817a.status) {
            case 0:
                if (c18817a.frT != 2) {
                    c45493a.gtH.setClickable(true);
                    c45493a.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                    c45493a.gnh.setText(C25738R.string.c12);
                    c45493a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.a69));
                    break;
                }
                c45493a.gtH.setClickable(false);
                c45493a.gtH.setBackgroundDrawable(null);
                c45493a.gnh.setText(C25738R.string.c13);
                c45493a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                break;
            case 1:
            case 2:
                if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c18817a.getUsername()) && !C1853r.m3846Yz().equals(c18817a.getUsername())) {
                    if (c18817a.frT != 2) {
                        c45493a.gtH.setClickable(true);
                        c45493a.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                        c45493a.gnh.setText(C25738R.string.c10);
                        c45493a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.a69));
                        break;
                    }
                    c45493a.gtH.setClickable(false);
                    c45493a.gtH.setBackgroundDrawable(null);
                    c45493a.gnh.setText(C25738R.string.c16);
                    c45493a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                    break;
                }
                c45493a.gtH.setClickable(false);
                c45493a.gtH.setBackgroundDrawable(null);
                c45493a.gnh.setText(C25738R.string.c11);
                c45493a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                break;
                break;
        }
        switch (c18817a.frT) {
            case 0:
            case 2:
                c45493a.gnh.setVisibility(0);
                c45493a.gtQ.setVisibility(4);
                break;
            case 1:
                c45493a.gnh.setVisibility(4);
                c45493a.gtQ.setVisibility(0);
                break;
        }
        C18817a c18817a2 = (C18817a) getItem(i - 1);
        if (c18817a2 == null) {
            i2 = -1;
        } else {
            i2 = c18817a2.guL;
        }
        if (i == 0) {
            String a = C45494d.m83837a(c18817a);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7421w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", c18817a.getUsername(), Integer.valueOf(i));
                c45493a.gtN.setVisibility(8);
            } else {
                c45493a.gtN.setVisibility(0);
                c45493a.gtN.setText(a);
                c45493a.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            if (c18817a.guL != i2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            String a2 = C45494d.m83837a(c18817a);
            if (C5046bo.isNullOrNil(a2) || r1 == 0) {
                C4990ab.m7421w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", c18817a.getUsername(), Integer.valueOf(i));
                c45493a.gtN.setVisibility(8);
            } else {
                c45493a.gtN.setVisibility(0);
                c45493a.gtN.setText(a2);
                c45493a.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.m2505o(13716);
        return view;
    }

    /* renamed from: vM */
    public final void mo67803vM(String str) {
        AppMethodBeat.m2504i(13713);
        this.gtz = C5046bo.m7586vA(str.trim());
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(13713);
    }

    /* renamed from: a */
    private static String m83837a(C18817a c18817a) {
        AppMethodBeat.m2504i(13717);
        String str;
        if (c18817a.guL == 123) {
            str = "#";
            AppMethodBeat.m2505o(13717);
            return str;
        }
        str = String.valueOf((char) c18817a.guL);
        AppMethodBeat.m2505o(13717);
        return str;
    }
}
