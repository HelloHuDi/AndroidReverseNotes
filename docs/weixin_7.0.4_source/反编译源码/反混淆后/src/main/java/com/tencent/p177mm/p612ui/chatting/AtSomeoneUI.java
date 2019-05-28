package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.MaskLayout.C23622a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI */
public class AtSomeoneUI extends MMActivity {
    private static boolean yDJ = false;
    private C7577u eih;
    private String elQ;
    private String elR;
    private C5601o elS;
    private ListView gGW;
    private String mTitle;
    private String talker;
    private C23659a yGL;

    /* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI$2 */
    class C155542 implements C5600b {
        C155542() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(30388);
            C23659a a = AtSomeoneUI.this.yGL;
            a.ema = str;
            a.mo5248a(null, null);
            AppMethodBeat.m2505o(30388);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
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
    }

    /* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI$1 */
    class C236561 implements OnMenuItemClickListener {
        C236561() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30387);
            AtSomeoneUI.this.setResult(0);
            AtSomeoneUI.this.finish();
            AppMethodBeat.m2505o(30387);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI$3 */
    class C236573 implements OnItemClickListener {
        C236573() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 1;
            AppMethodBeat.m2504i(30389);
            Intent intent = new Intent();
            if (i == 0 && AtSomeoneUI.yDJ) {
                intent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(C25738R.string.f9337x2, new Object[]{""}));
                intent.putExtra("select_raw_user_name", "notify@all");
            } else {
                C23659a a = AtSomeoneUI.this.yGL;
                if (!AtSomeoneUI.yDJ) {
                    i2 = 0;
                }
                C7616ad c7616ad = (C7616ad) a.getItem(i - i2);
                String a2 = AtSomeoneUI.m36502a(AtSomeoneUI.this.eih, c7616ad.field_username);
                if (C42252ah.isNullOrNil(a2)) {
                    a2 = c7616ad.mo16706Oi();
                }
                intent.putExtra("select_raw_user_name", c7616ad.field_username);
                intent.putExtra("Select_Conv_User", a2);
            }
            AtSomeoneUI.this.setResult(-1, intent);
            AtSomeoneUI.this.finish();
            AppMethodBeat.m2505o(30389);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI$b */
    static class C23658b {
        public MaskLayout emP;
        public TextView emg;
        public ImageView yDN;

        private C23658b() {
        }

        /* synthetic */ C23658b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.AtSomeoneUI$a */
    static class C23659a extends C46692p<C7616ad> {
        private C7577u eih;
        private List<String> elZ;
        String ema;
        private String[] yDL;
        private Bitmap yDM;

        public final /* bridge */ /* synthetic */ Object bFt() {
            return null;
        }

        public C23659a(Context context, C7616ad c7616ad, C7577u c7577u, String[] strArr, List<String> list) {
            super(context, c7616ad);
            AppMethodBeat.m2504i(30390);
            this.eih = c7577u;
            this.yDL = strArr;
            this.elZ = list;
            this.yDM = C5056d.m7668v(context.getResources().getDrawable(C1318a.at_all_avater));
            AppMethodBeat.m2505o(30390);
        }

        public final int bFs() {
            AppMethodBeat.m2504i(30391);
            if (AtSomeoneUI.yDJ) {
                AppMethodBeat.m2505o(30391);
                return 1;
            }
            AppMethodBeat.m2505o(30391);
            return 0;
        }

        /* renamed from: wK */
        public final boolean mo10892wK(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            C23658b c23658b;
            AppMethodBeat.m2504i(30392);
            if (view == null) {
                inflate = View.inflate(this.context, 2130968781, null);
                C23658b c23658b2 = new C23658b();
                c23658b2.emP = (MaskLayout) inflate.findViewById(2131821519);
                c23658b2.emg = (TextView) inflate.findViewById(2131821520);
                c23658b2.yDN = (ImageView) inflate.findViewById(2131821019);
                inflate.setTag(c23658b2);
                c23658b = c23658b2;
            } else {
                c23658b = (C23658b) view.getTag();
                inflate = view;
            }
            if (i == 0 && AtSomeoneUI.yDJ) {
                c23658b.yDN.setImageBitmap(this.yDM);
                c23658b.emg.setText(this.context.getResources().getString(C25738R.string.f9337x2, new Object[]{"@"}));
                AppMethodBeat.m2505o(30392);
                return inflate;
            }
            String kz;
            CharSequence Oi;
            C7616ad c7616ad = (C7616ad) getItem(i - (AtSomeoneUI.yDJ ? 1 : 0));
            c23658b.emg.setTextColor(C1338a.m2870h(this.context, !C1855t.m3923nI(c7616ad.field_username) ? C25738R.color.a7t : C25738R.color.a7u));
            C40460b.m69434b((ImageView) c23658b.emP.getContentView(), c7616ad.field_username);
            if (c7616ad.field_verifyFlag == 0) {
                c23658b.emP.setMaskDrawable(null);
            } else if (C26417a.flw != null) {
                kz = C26417a.flw.mo37873kz(c7616ad.field_verifyFlag);
                if (kz != null) {
                    c23658b.emP.mo48741a(C8935m.m16106rk(kz), C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                } else {
                    c23658b.emP.setMaskDrawable(null);
                }
            } else {
                c23658b.emP.setMaskDrawable(null);
            }
            if (C42252ah.isNullOrNil(c7616ad.field_conRemark)) {
                kz = AtSomeoneUI.m36502a(this.eih, c7616ad.field_username);
            } else {
                kz = c7616ad.field_conRemark;
            }
            if (C42252ah.isNullOrNil(kz)) {
                Oi = c7616ad.mo16706Oi();
            } else {
                Object Oi2 = kz;
            }
            if (C7616ad.aox(c7616ad.field_username)) {
                ((C32873b) C1720g.m3528K(C32873b.class)).mo44302a(c23658b.emg.getContext(), c23658b.emg, Oi2, c7616ad.field_openImAppid, c7616ad.field_descWordingId, (int) c23658b.emg.getTextSize());
            } else {
                c23658b.emg.setText(C44089j.m79293b(this.context, Oi2, c23658b.emg.getTextSize()));
            }
            AppMethodBeat.m2505o(30392);
            return inflate;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            List list;
            AppMethodBeat.m2504i(30393);
            C9638aw.m17190ZK();
            C7309bd XM = C18628c.m29078XM();
            String[] strArr = this.yDL;
            String str = "@all.chatroom";
            String str2 = this.ema;
            String str3 = this.ema;
            if (this.eih == null || str3 == null || this.yDL == null) {
                list = null;
            } else {
                list = new ArrayList();
                for (String str4 : this.yDL) {
                    String mJ = this.eih.mo16807mJ(str4);
                    if (mJ != null && mJ.contains(str3)) {
                        list.add(str4);
                    }
                }
            }
            setCursor(XM.mo15705a(strArr, str, str2, list, this.elZ));
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(30393);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(30394);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(30394);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(30395);
            C9638aw.m17190ZK();
            Object aoI = C18628c.m29078XM().aoI(C7616ad.m13550q(cursor));
            if (aoI == null) {
                aoI = new C7616ad();
                aoI.mo8995d(cursor);
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15699W(aoI);
            }
            AppMethodBeat.m2505o(30395);
            return aoI;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30396);
        super.onCreate(bundle);
        this.elQ = getIntent().getStringExtra("Block_list");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        C9638aw.m17190ZK();
        this.eih = C18628c.m29087XV().mo14885oa(this.talker);
        if (this.eih != null && this.eih.field_roomowner.equals(C1853r.m3846Yz())) {
            yDJ = false;
        }
        initView();
        AppMethodBeat.m2505o(30396);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30397);
        setMMTitle(this.mTitle);
        setBackBtn(new C236561());
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C155542();
        mo17380a(this.elS);
        this.gGW = (ListView) findViewById(2131821522);
        this.yGL = new C23659a(this, new C7616ad(), this.eih, dAJ(), m36500Ko());
        this.gGW.setOnItemClickListener(new C236573());
        this.gGW.setAdapter(this.yGL);
        AppMethodBeat.m2505o(30397);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30398);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(30398);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30399);
        this.yGL.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(30399);
    }

    private String[] dAJ() {
        boolean z = true;
        AppMethodBeat.m2504i(30400);
        String[] strArr = null;
        if (!C42252ah.isNullOrNil(this.elR)) {
            strArr = this.elR.split(",");
            C4990ab.m7411d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        if (strArr == null && this.eih != null) {
            C4990ab.m7420w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = C42252ah.m74611c(this.eih.afg(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.eih != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(30400);
        return strArr;
    }

    /* renamed from: Ko */
    private List<String> m36500Ko() {
        AppMethodBeat.m2504i(30401);
        List linkedList = new LinkedList();
        if (!C42252ah.isNullOrNil(this.elQ)) {
            linkedList = C42252ah.m74626j(this.elQ.split(","));
        }
        C9638aw.m17190ZK();
        C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
        if (RA != null) {
            linkedList.add(RA.name);
        }
        AppMethodBeat.m2505o(30401);
        return linkedList;
    }

    public final int getLayoutId() {
        return 2130968782;
    }

    /* renamed from: a */
    protected static String m36502a(C7577u c7577u, String str) {
        AppMethodBeat.m2504i(30402);
        if (c7577u == null) {
            AppMethodBeat.m2505o(30402);
            return null;
        }
        String mJ = c7577u.mo16807mJ(str);
        AppMethodBeat.m2505o(30402);
        return mJ;
    }
}
