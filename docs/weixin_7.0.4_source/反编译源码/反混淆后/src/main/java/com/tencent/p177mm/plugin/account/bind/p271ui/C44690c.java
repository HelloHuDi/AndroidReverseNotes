package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14918b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.c */
public final class C44690c extends C42279b {
    private C26573a gtA;
    private C38030b gtB = new C329521();
    private int[] gty;
    private String gtz;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.c$1 */
    class C329521 implements C38030b {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.c$1$1 */
        class C329531 implements C14917a {
            C329531() {
            }

            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(13694);
                C4990ab.m7417i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                C18817a vW = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34092vW(str2);
                if (vW == null) {
                    C4990ab.m7421w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                } else if (z) {
                    vW.username = str;
                    vW.status = 2;
                    vW.frT = 2;
                    C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "f :%s", vW.toString());
                    ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34084a(str2, vW);
                    C44690c.this.mo6869KC();
                    C37907bv.aaq().mo60662c(26, new Object[0]);
                    AppMethodBeat.m2505o(13694);
                    return;
                }
                AppMethodBeat.m2505o(13694);
            }
        }

        C329521() {
        }

        /* renamed from: c */
        public final void mo44352c(int i, String str, int i2) {
            AppMethodBeat.m2504i(13697);
            C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final C18817a c18817a = (C18817a) C44690c.this.getItem(i);
            if (c18817a == null) {
                C4990ab.m7413e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.m2505o(13697);
                return;
            }
            C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", c18817a.toString());
            if (c18817a.status == 1) {
                C14916a c14916a = new C14916a(C44690c.this.context, new C329531());
                c14916a.vjI = new C14918b() {
                    /* renamed from: vQ */
                    public final boolean mo8211vQ(String str) {
                        AppMethodBeat.m2504i(13695);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", c18817a.getUsername());
                        intent.putExtra("Contact_Nick", c18817a.apD());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(C5495b.yfT, str);
                        C25985d.m41468b(C44690c.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        AppMethodBeat.m2505o(13695);
                        return true;
                    }
                };
                if (C44690c.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) C44690c.this.context).ifE = new C5186a() {
                        /* renamed from: c */
                        public final void mo6069c(int i, int i2, Intent intent) {
                            AppMethodBeat.m2504i(13696);
                            if (i == 1 && i2 == -1) {
                                ((MobileFriendUI) C44690c.this.context).mo67798b(c18817a);
                            }
                            AppMethodBeat.m2505o(13696);
                        }
                    };
                }
                c14916a.gyj = c18817a.mo34067Aq();
                c14916a.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                c14916a.mo27242b(c18817a.getUsername(), linkedList, false);
            }
            AppMethodBeat.m2505o(13697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.c$a */
    class C44691a {
        String cvZ;
        TextView gnh;
        int gtF;
        TextView gtG;
        View gtH;
        ProgressBar gtI;
        int status;

        public C44691a(View view) {
            AppMethodBeat.m2504i(13699);
            this.gtG = (TextView) view.findViewById(2131824020);
            this.gtH = view.findViewById(2131826116);
            this.gnh = (TextView) view.findViewById(2131826117);
            this.gtI = (ProgressBar) view.findViewById(2131826118);
            this.gtH.setOnClickListener(new OnClickListener(C44690c.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(13698);
                    if (C44690c.this.gtB != null) {
                        C44690c.this.gtB.mo44352c(C44691a.this.gtF, C44691a.this.cvZ, C44691a.this.status);
                    }
                    AppMethodBeat.m2505o(13698);
                }
            });
            AppMethodBeat.m2505o(13699);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(13705);
        C18817a c18817a = (C18817a) obj;
        if (c18817a == null) {
            c18817a = new C18817a();
        }
        c18817a.mo34080d(cursor);
        AppMethodBeat.m2505o(13705);
        return c18817a;
    }

    /* renamed from: a */
    public final void mo67802a(C26573a c26573a) {
        this.gtA = c26573a;
    }

    public C44690c(Context context, C30723a c30723a) {
        super(context, new C18817a());
        AppMethodBeat.m2504i(13700);
        super.mo74992a(c30723a);
        this.context = context;
        AppMethodBeat.m2505o(13700);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(13702);
        mo6869KC();
        AppMethodBeat.m2505o(13702);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(13703);
        bIf();
        setCursor(((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34090vU(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gtA == null || this.gtz == null)) {
            this.gtA.mo5733mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(13703);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C44691a c44691a;
        AppMethodBeat.m2504i(13704);
        C18817a c18817a = (C18817a) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, 2130970236, null);
            c44691a = new C44691a(view);
            c44691a.gtG = (TextView) view.findViewById(2131824020);
            view.setTag(c44691a);
        } else {
            c44691a = (C44691a) view.getTag();
        }
        c44691a.gtF = i;
        c44691a.cvZ = c18817a.mo34067Aq();
        c44691a.status = c18817a.status;
        c44691a.gtG.setText(c18817a.apA());
        switch (c18817a.status) {
            case 0:
                if (c18817a.frT != 2) {
                    c44691a.gtH.setClickable(true);
                    c44691a.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                    c44691a.gnh.setText(C25738R.string.c12);
                    c44691a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.a69));
                    break;
                }
                c44691a.gtH.setClickable(false);
                c44691a.gtH.setBackgroundDrawable(null);
                c44691a.gnh.setText(C25738R.string.c13);
                c44691a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                break;
            case 1:
            case 2:
                C4990ab.m7411d("MicroMsg.MobileFriendAdapter", "username:%s", c18817a.getUsername());
                if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(c18817a.getUsername()) && !C1853r.m3846Yz().equals(c18817a.getUsername())) {
                    if (c18817a.frT != 2) {
                        c44691a.gtH.setClickable(true);
                        c44691a.gtH.setBackgroundResource(C25738R.drawable.f6484fp);
                        c44691a.gnh.setText(C25738R.string.c10);
                        c44691a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.a69));
                        break;
                    }
                    c44691a.gtH.setClickable(false);
                    c44691a.gtH.setBackgroundDrawable(null);
                    c44691a.gnh.setText(C25738R.string.c16);
                    c44691a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                    break;
                }
                c44691a.gtH.setClickable(false);
                c44691a.gtH.setBackgroundDrawable(null);
                c44691a.gnh.setText(C25738R.string.c11);
                c44691a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12121t4));
                break;
                break;
        }
        switch (c18817a.frT) {
            case 0:
            case 2:
                c44691a.gnh.setVisibility(0);
                c44691a.gtI.setVisibility(4);
                break;
            case 1:
                c44691a.gnh.setVisibility(4);
                c44691a.gtI.setVisibility(0);
                break;
        }
        AppMethodBeat.m2505o(13704);
        return view;
    }

    /* renamed from: vM */
    public final void mo67803vM(String str) {
        AppMethodBeat.m2504i(13701);
        this.gtz = C5046bo.m7586vA(str.trim());
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(13701);
    }
}
