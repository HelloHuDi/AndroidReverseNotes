package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean yDJ = false;
    private u eih;
    private String elQ;
    private String elR;
    private o elS;
    private ListView gGW;
    private String mTitle;
    private String talker;
    private a yGL;

    static class b {
        public MaskLayout emP;
        public TextView emg;
        public ImageView yDN;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class a extends p<ad> {
        private u eih;
        private List<String> elZ;
        String ema;
        private String[] yDL;
        private Bitmap yDM;

        public final /* bridge */ /* synthetic */ Object bFt() {
            return null;
        }

        public a(Context context, ad adVar, u uVar, String[] strArr, List<String> list) {
            super(context, adVar);
            AppMethodBeat.i(30390);
            this.eih = uVar;
            this.yDL = strArr;
            this.elZ = list;
            this.yDM = d.v(context.getResources().getDrawable(R.raw.at_all_avater));
            AppMethodBeat.o(30390);
        }

        public final int bFs() {
            AppMethodBeat.i(30391);
            if (AtSomeoneUI.yDJ) {
                AppMethodBeat.o(30391);
                return 1;
            }
            AppMethodBeat.o(30391);
            return 0;
        }

        public final boolean wK(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            b bVar;
            AppMethodBeat.i(30392);
            if (view == null) {
                inflate = View.inflate(this.context, R.layout.eu, null);
                b bVar2 = new b();
                bVar2.emP = (MaskLayout) inflate.findViewById(R.id.zb);
                bVar2.emg = (TextView) inflate.findViewById(R.id.zc);
                bVar2.yDN = (ImageView) inflate.findViewById(R.id.m5);
                inflate.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            if (i == 0 && AtSomeoneUI.yDJ) {
                bVar.yDN.setImageBitmap(this.yDM);
                bVar.emg.setText(this.context.getResources().getString(R.string.x2, new Object[]{"@"}));
                AppMethodBeat.o(30392);
                return inflate;
            }
            String kz;
            CharSequence Oi;
            ad adVar = (ad) getItem(i - (AtSomeoneUI.yDJ ? 1 : 0));
            bVar.emg.setTextColor(com.tencent.mm.bz.a.h(this.context, !t.nI(adVar.field_username) ? R.color.a7t : R.color.a7u));
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) bVar.emP.getContentView(), adVar.field_username);
            if (adVar.field_verifyFlag == 0) {
                bVar.emP.setMaskDrawable(null);
            } else if (com.tencent.mm.model.ao.a.flw != null) {
                kz = com.tencent.mm.model.ao.a.flw.kz(adVar.field_verifyFlag);
                if (kz != null) {
                    bVar.emP.a(m.rk(kz), com.tencent.mm.ui.base.MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                } else {
                    bVar.emP.setMaskDrawable(null);
                }
            } else {
                bVar.emP.setMaskDrawable(null);
            }
            if (ah.isNullOrNil(adVar.field_conRemark)) {
                kz = AtSomeoneUI.a(this.eih, adVar.field_username);
            } else {
                kz = adVar.field_conRemark;
            }
            if (ah.isNullOrNil(kz)) {
                Oi = adVar.Oi();
            } else {
                Object Oi2 = kz;
            }
            if (ad.aox(adVar.field_username)) {
                ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(bVar.emg.getContext(), bVar.emg, Oi2, adVar.field_openImAppid, adVar.field_descWordingId, (int) bVar.emg.getTextSize());
            } else {
                bVar.emg.setText(j.b(this.context, Oi2, bVar.emg.getTextSize()));
            }
            AppMethodBeat.o(30392);
            return inflate;
        }

        public final void KC() {
            List list;
            AppMethodBeat.i(30393);
            aw.ZK();
            bd XM = c.XM();
            String[] strArr = this.yDL;
            String str = "@all.chatroom";
            String str2 = this.ema;
            String str3 = this.ema;
            if (this.eih == null || str3 == null || this.yDL == null) {
                list = null;
            } else {
                list = new ArrayList();
                for (String str4 : this.yDL) {
                    String mJ = this.eih.mJ(str4);
                    if (mJ != null && mJ.contains(str3)) {
                        list.add(str4);
                    }
                }
            }
            setCursor(XM.a(strArr, str, str2, list, this.elZ));
            super.notifyDataSetChanged();
            AppMethodBeat.o(30393);
        }

        public final void KD() {
            AppMethodBeat.i(30394);
            bIf();
            KC();
            AppMethodBeat.o(30394);
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(30395);
            aw.ZK();
            Object aoI = c.XM().aoI(ad.q(cursor));
            if (aoI == null) {
                aoI = new ad();
                aoI.d(cursor);
                aw.ZK();
                c.XM().W(aoI);
            }
            AppMethodBeat.o(30395);
            return aoI;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30396);
        super.onCreate(bundle);
        this.elQ = getIntent().getStringExtra("Block_list");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        aw.ZK();
        this.eih = c.XV().oa(this.talker);
        if (this.eih != null && this.eih.field_roomowner.equals(r.Yz())) {
            yDJ = false;
        }
        initView();
        AppMethodBeat.o(30396);
    }

    public final void initView() {
        AppMethodBeat.i(30397);
        setMMTitle(this.mTitle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30387);
                AtSomeoneUI.this.setResult(0);
                AtSomeoneUI.this.finish();
                AppMethodBeat.o(30387);
                return true;
            }
        });
        this.elS = new o((byte) 0);
        this.elS.zHa = new com.tencent.mm.ui.tools.o.b() {
            public final void vO(String str) {
                AppMethodBeat.i(30388);
                a a = AtSomeoneUI.this.yGL;
                a.ema = str;
                a.a(null, null);
                AppMethodBeat.o(30388);
            }

            public final boolean vN(String str) {
                return false;
            }

            public final void apo() {
            }

            public final void app() {
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        a(this.elS);
        this.gGW = (ListView) findViewById(R.id.ze);
        this.yGL = new a(this, new ad(), this.eih, dAJ(), Ko());
        this.gGW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                AppMethodBeat.i(30389);
                Intent intent = new Intent();
                if (i == 0 && AtSomeoneUI.yDJ) {
                    intent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.string.x2, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    a a = AtSomeoneUI.this.yGL;
                    if (!AtSomeoneUI.yDJ) {
                        i2 = 0;
                    }
                    ad adVar = (ad) a.getItem(i - i2);
                    String a2 = AtSomeoneUI.a(AtSomeoneUI.this.eih, adVar.field_username);
                    if (ah.isNullOrNil(a2)) {
                        a2 = adVar.Oi();
                    }
                    intent.putExtra("select_raw_user_name", adVar.field_username);
                    intent.putExtra("Select_Conv_User", a2);
                }
                AtSomeoneUI.this.setResult(-1, intent);
                AtSomeoneUI.this.finish();
                AppMethodBeat.o(30389);
            }
        });
        this.gGW.setAdapter(this.yGL);
        AppMethodBeat.o(30397);
    }

    public void onPause() {
        AppMethodBeat.i(30398);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.o(30398);
    }

    public void onDestroy() {
        AppMethodBeat.i(30399);
        this.yGL.bIf();
        super.onDestroy();
        AppMethodBeat.o(30399);
    }

    private String[] dAJ() {
        boolean z = true;
        AppMethodBeat.i(30400);
        String[] strArr = null;
        if (!ah.isNullOrNil(this.elR)) {
            strArr = this.elR.split(",");
            ab.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        if (strArr == null && this.eih != null) {
            ab.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = ah.c(this.eih.afg(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.eih != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
        }
        AppMethodBeat.o(30400);
        return strArr;
    }

    private List<String> Ko() {
        AppMethodBeat.i(30401);
        List linkedList = new LinkedList();
        if (!ah.isNullOrNil(this.elQ)) {
            linkedList = ah.j(this.elQ.split(","));
        }
        aw.ZK();
        bq RA = c.XU().RA("@t.qq.com");
        if (RA != null) {
            linkedList.add(RA.name);
        }
        AppMethodBeat.o(30401);
        return linkedList;
    }

    public final int getLayoutId() {
        return R.layout.ev;
    }

    protected static String a(u uVar, String str) {
        AppMethodBeat.i(30402);
        if (uVar == null) {
            AppMethodBeat.o(30402);
            return null;
        }
        String mJ = uVar.mJ(str);
        AppMethodBeat.o(30402);
        return mJ;
    }
}
