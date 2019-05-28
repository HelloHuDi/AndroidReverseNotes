package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e;
import java.util.LinkedList;

public final class c extends b {
    private com.tencent.mm.plugin.account.bind.ui.b.a gtA;
    private b gtB = new b() {
        public final void c(int i, String str, int i2) {
            AppMethodBeat.i(13697);
            ab.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) c.this.getItem(i);
            if (aVar == null) {
                ab.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.o(13697);
                return;
            }
            ab.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", aVar.toString());
            if (aVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(c.this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(13694);
                        ab.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.plugin.account.friend.a.a vW = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vW(str2);
                        if (vW == null) {
                            ab.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                        } else if (z) {
                            vW.username = str;
                            vW.status = 2;
                            vW.frT = 2;
                            ab.d("MicroMsg.MobileFriendAdapter", "f :%s", vW.toString());
                            ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(str2, vW);
                            c.this.KC();
                            bv.aaq().c(26, new Object[0]);
                            AppMethodBeat.o(13694);
                            return;
                        }
                        AppMethodBeat.o(13694);
                    }
                });
                aVar2.vjI = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                    public final boolean vQ(String str) {
                        AppMethodBeat.i(13695);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", aVar.getUsername());
                        intent.putExtra("Contact_Nick", aVar.apD());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(e.b.yfT, str);
                        d.b(c.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        AppMethodBeat.o(13695);
                        return true;
                    }
                };
                if (c.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) c.this.context).ifE = new com.tencent.mm.ui.MMActivity.a() {
                        public final void c(int i, int i2, Intent intent) {
                            AppMethodBeat.i(13696);
                            if (i == 1 && i2 == -1) {
                                ((MobileFriendUI) c.this.context).b(aVar);
                            }
                            AppMethodBeat.o(13696);
                        }
                    };
                }
                aVar2.gyj = aVar.Aq();
                aVar2.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                aVar2.b(aVar.getUsername(), linkedList, false);
            }
            AppMethodBeat.o(13697);
        }
    };
    private int[] gty;
    private String gtz;

    class a {
        String cvZ;
        TextView gnh;
        int gtF;
        TextView gtG;
        View gtH;
        ProgressBar gtI;
        int status;

        public a(View view) {
            AppMethodBeat.i(13699);
            this.gtG = (TextView) view.findViewById(R.id.bsy);
            this.gtH = view.findViewById(R.id.dbm);
            this.gnh = (TextView) view.findViewById(R.id.dbn);
            this.gtI = (ProgressBar) view.findViewById(R.id.dbo);
            this.gtH.setOnClickListener(new OnClickListener(c.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(13698);
                    if (c.this.gtB != null) {
                        c.this.gtB.c(a.this.gtF, a.this.cvZ, a.this.status);
                    }
                    AppMethodBeat.o(13698);
                }
            });
            AppMethodBeat.o(13699);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(13705);
        com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar.d(cursor);
        AppMethodBeat.o(13705);
        return aVar;
    }

    public final void a(com.tencent.mm.plugin.account.bind.ui.b.a aVar) {
        this.gtA = aVar;
    }

    public c(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        AppMethodBeat.i(13700);
        super.a(aVar);
        this.context = context;
        AppMethodBeat.o(13700);
    }

    public final void KD() {
        AppMethodBeat.i(13702);
        KC();
        AppMethodBeat.o(13702);
    }

    public final void KC() {
        AppMethodBeat.i(13703);
        bIf();
        setCursor(((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vU(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gtA == null || this.gtz == null)) {
            this.gtA.mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(13703);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(13704);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.layout.ah2, null);
            aVar = new a(view);
            aVar.gtG = (TextView) view.findViewById(R.id.bsy);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gtF = i;
        aVar.cvZ = aVar2.Aq();
        aVar.status = aVar2.status;
        aVar.gtG.setText(aVar2.apA());
        switch (aVar2.status) {
            case 0:
                if (aVar2.frT != 2) {
                    aVar.gtH.setClickable(true);
                    aVar.gtH.setBackgroundResource(R.drawable.fp);
                    aVar.gnh.setText(R.string.c12);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.a69));
                    break;
                }
                aVar.gtH.setClickable(false);
                aVar.gtH.setBackgroundDrawable(null);
                aVar.gnh.setText(R.string.c13);
                aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.t4));
                break;
            case 1:
            case 2:
                ab.d("MicroMsg.MobileFriendAdapter", "username:%s", aVar2.getUsername());
                if (!((j) g.K(j.class)).XM().aoJ(aVar2.getUsername()) && !r.Yz().equals(aVar2.getUsername())) {
                    if (aVar2.frT != 2) {
                        aVar.gtH.setClickable(true);
                        aVar.gtH.setBackgroundResource(R.drawable.fp);
                        aVar.gnh.setText(R.string.c10);
                        aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.a69));
                        break;
                    }
                    aVar.gtH.setClickable(false);
                    aVar.gtH.setBackgroundDrawable(null);
                    aVar.gnh.setText(R.string.c16);
                    aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.t4));
                    break;
                }
                aVar.gtH.setClickable(false);
                aVar.gtH.setBackgroundDrawable(null);
                aVar.gnh.setText(R.string.c11);
                aVar.gnh.setTextColor(this.context.getResources().getColor(R.color.t4));
                break;
                break;
        }
        switch (aVar2.frT) {
            case 0:
            case 2:
                aVar.gnh.setVisibility(0);
                aVar.gtI.setVisibility(4);
                break;
            case 1:
                aVar.gnh.setVisibility(4);
                aVar.gtI.setVisibility(0);
                break;
        }
        AppMethodBeat.o(13704);
        return view;
    }

    public final void vM(String str) {
        AppMethodBeat.i(13701);
        this.gtz = bo.vA(str.trim());
        bIf();
        KC();
        AppMethodBeat.o(13701);
    }
}
