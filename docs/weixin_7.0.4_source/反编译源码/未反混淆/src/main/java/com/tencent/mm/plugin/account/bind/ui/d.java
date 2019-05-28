package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e;
import java.util.LinkedList;

public final class d extends b {
    private com.tencent.mm.plugin.account.bind.ui.b.a gtA;
    private b gtB = new b() {
        public final void c(int i, String str, int i2) {
            AppMethodBeat.i(13709);
            ab.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) d.this.getItem(i);
            if (aVar == null) {
                ab.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                AppMethodBeat.o(13709);
                return;
            }
            ab.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", aVar.toString());
            if (aVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(d.this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(13706);
                        ab.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.plugin.account.friend.a.a vW = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vW(str2);
                        if (vW == null) {
                            ab.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", str2);
                        } else if (z) {
                            vW.username = str;
                            vW.status = 2;
                            vW.frT = 2;
                            ab.d("MicroMsg.MobileFriendAdapter", "f :%s", vW.toString());
                            ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(str2, vW);
                            d.this.KC();
                            bv.aaq().c(26, new Object[0]);
                            AppMethodBeat.o(13706);
                            return;
                        }
                        AppMethodBeat.o(13706);
                    }
                });
                aVar2.vjI = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                    public final boolean vQ(String str) {
                        AppMethodBeat.i(13707);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", aVar.getUsername());
                        intent.putExtra("Contact_Nick", aVar.apD());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        intent.putExtra(e.b.yfT, str);
                        com.tencent.mm.bp.d.b(d.this.context, Scopes.PROFILE, ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        AppMethodBeat.o(13707);
                        return true;
                    }
                };
                if (d.this.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) d.this.context).ifE = new com.tencent.mm.ui.MMActivity.a() {
                        public final void c(int i, int i2, Intent intent) {
                            AppMethodBeat.i(13708);
                            if (i == 1 && i2 == -1) {
                                ((MobileFriendUI) d.this.context).b(aVar);
                            }
                            AppMethodBeat.o(13708);
                        }
                    };
                }
                aVar2.gyj = aVar.Aq();
                aVar2.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                aVar2.b(aVar.getUsername(), linkedList, false);
            }
            AppMethodBeat.o(13709);
        }
    };
    private int[] gty;
    private String gtz;

    class a {
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

        public a(View view) {
            AppMethodBeat.i(13711);
            this.gtN = (TextView) view.findViewById(R.id.bx2);
            this.eks = (ImageView) view.findViewById(R.id.bx3);
            this.gtO = (TextView) view.findViewById(R.id.bx4);
            this.gtP = (TextView) view.findViewById(R.id.bx5);
            this.gtH = view.findViewById(R.id.bx6);
            this.gnh = (TextView) view.findViewById(R.id.bx7);
            this.gtQ = (ProgressBar) view.findViewById(R.id.bx8);
            this.gtH.setOnClickListener(new OnClickListener(d.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(13710);
                    if (d.this.gtB != null) {
                        d.this.gtB.c(a.this.gtF, a.this.account, a.this.status);
                    }
                    AppMethodBeat.o(13710);
                }
            });
            AppMethodBeat.o(13711);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(13718);
        com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar.d(cursor);
        AppMethodBeat.o(13718);
        return aVar;
    }

    public final void a(com.tencent.mm.plugin.account.bind.ui.b.a aVar) {
        this.gtA = aVar;
    }

    public d(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        AppMethodBeat.i(13712);
        super.a(aVar);
        this.context = context;
        pN(true);
        AppMethodBeat.o(13712);
    }

    public final void KD() {
        AppMethodBeat.i(13714);
        KC();
        AppMethodBeat.o(13714);
    }

    public final void KC() {
        AppMethodBeat.i(13715);
        bIf();
        setCursor(((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vV(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gtA == null || this.gtz == null)) {
            this.gtA.mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(13715);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        AppMethodBeat.i(13716);
        com.tencent.mm.plugin.account.friend.a.a aVar2 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.layout.a0x, null);
            a aVar3 = new a(view);
            view.setTag(aVar3);
            aVar = aVar3;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gtF = i;
        aVar.account = aVar2.Aq();
        aVar.status = aVar2.status;
        aVar.gtO.setText(aVar2.apA());
        aVar.gtP.setText(this.context.getString(R.string.c17) + aVar2.apD());
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.eks, aVar2.getUsername());
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
                aVar.gtQ.setVisibility(4);
                break;
            case 1:
                aVar.gnh.setVisibility(4);
                aVar.gtQ.setVisibility(0);
                break;
        }
        com.tencent.mm.plugin.account.friend.a.a aVar4 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i - 1);
        if (aVar4 == null) {
            i2 = -1;
        } else {
            i2 = aVar4.guL;
        }
        if (i == 0) {
            String a = a(aVar2);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", aVar2.getUsername(), Integer.valueOf(i));
                aVar.gtN.setVisibility(8);
            } else {
                aVar.gtN.setVisibility(0);
                aVar.gtN.setText(a);
                aVar.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            if (aVar2.guL != i2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            String a2 = a(aVar2);
            if (bo.isNullOrNil(a2) || r1 == 0) {
                ab.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", aVar2.getUsername(), Integer.valueOf(i));
                aVar.gtN.setVisibility(8);
            } else {
                aVar.gtN.setVisibility(0);
                aVar.gtN.setText(a2);
                aVar.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.o(13716);
        return view;
    }

    public final void vM(String str) {
        AppMethodBeat.i(13713);
        this.gtz = bo.vA(str.trim());
        bIf();
        KC();
        AppMethodBeat.o(13713);
    }

    private static String a(com.tencent.mm.plugin.account.friend.a.a aVar) {
        AppMethodBeat.i(13717);
        String str;
        if (aVar.guL == 123) {
            str = "#";
            AppMethodBeat.o(13717);
            return str;
        }
        str = String.valueOf((char) aVar.guL);
        AppMethodBeat.o(13717);
        return str;
    }
}
