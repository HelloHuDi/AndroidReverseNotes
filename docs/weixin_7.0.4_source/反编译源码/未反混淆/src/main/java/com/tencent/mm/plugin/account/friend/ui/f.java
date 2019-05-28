package com.tencent.mm.plugin.account.friend.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f extends d {
    private final int Zb;
    private final MMActivity crP;
    private String gtz;
    private com.tencent.mm.plugin.account.friend.ui.d.a gxG;
    boolean gxO = false;
    private a gxP = new a() {
        public final void d(int i, String str, int i2) {
            AppMethodBeat.i(108603);
            ab.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            ao aoVar = (ao) f.this.getItem(i);
            if (aoVar == null) {
                ab.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", str);
                AppMethodBeat.o(108603);
                return;
            }
            ab.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", aoVar.toString());
            if (aoVar.gwD == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(f.this.crP, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        AppMethodBeat.i(108602);
                        ab.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        long longValue = new p(p.cB(str2)).longValue();
                        ao ge = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).ge(longValue);
                        if (z && ge != null) {
                            ge.username = str;
                        }
                        if (ge != null) {
                            ge.frT = 2;
                            ab.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", ge.toString());
                            ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(longValue, ge);
                            f.this.KC();
                        } else {
                            ab.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", str2);
                        }
                        if (z && ge != null) {
                            d.wl(str);
                        }
                        AppMethodBeat.o(108602);
                    }
                });
                aVar.gyj = aoVar.gwC;
                aVar.vjO = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                if (bo.isNullOrNil(aoVar.getUsername())) {
                    ab.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    AppMethodBeat.o(108603);
                    return;
                }
                aVar.b(aoVar.getUsername(), linkedList, true);
                aoVar.frT = 1;
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar.gwC, aoVar);
                f.this.KC();
            }
            AppMethodBeat.o(108603);
        }
    };

    interface a {
        void d(int i, String str, int i2);
    }

    class b {
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

        public b(View view) {
            AppMethodBeat.i(108605);
            this.gtN = (TextView) view.findViewById(R.id.bx2);
            this.eks = (ImageView) view.findViewById(R.id.bx3);
            this.gtO = (TextView) view.findViewById(R.id.bx4);
            this.gtP = (TextView) view.findViewById(R.id.bx5);
            this.gtH = view.findViewById(R.id.bx6);
            this.gnh = (TextView) view.findViewById(R.id.bx7);
            this.gtQ = (ProgressBar) view.findViewById(R.id.bx8);
            this.gtH.setOnClickListener(new OnClickListener(f.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(108604);
                    if (f.this.gxP != null) {
                        f.this.gxP.d(b.this.gtF, b.this.account, b.this.status);
                    }
                    AppMethodBeat.o(108604);
                }
            });
            AppMethodBeat.o(108605);
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(108612);
        ao aoVar = (ao) obj;
        if (aoVar == null) {
            aoVar = new ao();
        }
        aoVar.d(cursor);
        AppMethodBeat.o(108612);
        return aoVar;
    }

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new ao());
        AppMethodBeat.i(108606);
        this.crP = mMActivity;
        this.Zb = i;
        this.gxO = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        pN(true);
        AppMethodBeat.o(108606);
    }

    public final void a(com.tencent.mm.plugin.account.friend.ui.d.a aVar) {
        this.gxG = aVar;
    }

    public final void KD() {
        AppMethodBeat.i(108608);
        KC();
        AppMethodBeat.o(108608);
    }

    public final void KC() {
        AppMethodBeat.i(108609);
        bIf();
        if (bo.isNullOrNil(this.gtz)) {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).E(this.Zb, this.gxO));
        } else {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.Zb, this.gtz, this.gxO));
        }
        if (!(this.gxG == null || this.gtz == null)) {
            this.gxG.mT(getCursor().getCount());
        }
        notifyDataSetChanged();
        AppMethodBeat.o(108609);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        AppMethodBeat.i(108610);
        ao aoVar = (ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.crP, R.layout.a0x, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.gtF = i;
        bVar.account = aoVar.gwC;
        bVar.status = aoVar.gwD;
        bVar.gtO.setText(j.b(this.crP, aoVar.getDisplayName(), bVar.gtO.getTextSize()));
        bVar.gtP.setText(j.b(this.crP, aoVar.Hs(), bVar.gtP.getTextSize()));
        if (this.gxO) {
            Bitmap fr;
            if (p.cB(bVar.account) != 0) {
                fr = com.tencent.mm.ah.b.fr(aoVar.gwC);
            } else {
                fr = null;
            }
            if (fr == null) {
                bVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.default_avatar));
            } else {
                bVar.eks.setImageBitmap(fr);
            }
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.eks, aoVar.getUsername());
        }
        if (!this.gxO) {
            switch (aoVar.gwD) {
                case 1:
                case 2:
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoJ(aoVar.getUsername()) && !r.Yz().equals(aoVar.getUsername())) {
                        if (aoVar.frT != 2) {
                            bVar.gtH.setClickable(true);
                            bVar.gtH.setBackgroundResource(R.drawable.fp);
                            bVar.gnh.setText(R.string.c10);
                            bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.a69));
                            break;
                        }
                        bVar.gtH.setClickable(false);
                        bVar.gtH.setBackgroundDrawable(null);
                        bVar.gnh.setText(R.string.c16);
                        bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.t4));
                        break;
                    }
                    bVar.gtH.setClickable(false);
                    bVar.gtH.setBackgroundDrawable(null);
                    bVar.gnh.setText(R.string.c11);
                    bVar.gnh.setTextColor(this.crP.getResources().getColor(R.color.t4));
                    break;
                    break;
            }
            switch (aoVar.frT) {
                case 0:
                case 2:
                    bVar.gnh.setVisibility(0);
                    bVar.gtQ.setVisibility(4);
                    break;
                case 1:
                    bVar.gnh.setVisibility(4);
                    bVar.gtQ.setVisibility(0);
                    break;
            }
        }
        bVar.gtH.setVisibility(8);
        ao aoVar2 = (ao) getItem(i - 1);
        if (aoVar2 == null) {
            i2 = -1;
        } else {
            i2 = aoVar2.frS;
        }
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = aoVar2 != null ? aoVar2.toString() : "";
        ab.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = aoVar != null ? aoVar.toString() : "";
        ab.d(str, str2, objArr);
        if (i == 0) {
            String b = b(aoVar);
            if (bo.isNullOrNil(b)) {
                ab.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", aoVar.getUsername(), Integer.valueOf(i));
                bVar.gtN.setVisibility(8);
            } else {
                bVar.gtN.setVisibility(0);
                bVar.gtN.setText(b);
                bVar.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            int i3;
            if (aoVar.frS != i2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String b2 = b(aoVar);
            if (bo.isNullOrNil(b2) || i3 == 0) {
                ab.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", aoVar.getUsername(), Integer.valueOf(i));
                bVar.gtN.setVisibility(8);
            } else {
                bVar.gtN.setVisibility(0);
                bVar.gtN.setText(b2);
                bVar.gtN.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        AppMethodBeat.o(108610);
        return view;
    }

    public final void qj(String str) {
    }

    public final void vM(String str) {
        AppMethodBeat.i(108607);
        this.gtz = bo.vA(str.trim());
        bIf();
        KC();
        AppMethodBeat.o(108607);
    }

    private static String b(ao aoVar) {
        AppMethodBeat.i(108611);
        String str;
        if (aoVar.frS == 123) {
            str = "#";
            AppMethodBeat.o(108611);
            return str;
        }
        str = String.valueOf((char) aoVar.frS);
        AppMethodBeat.o(108611);
        return str;
    }
}
