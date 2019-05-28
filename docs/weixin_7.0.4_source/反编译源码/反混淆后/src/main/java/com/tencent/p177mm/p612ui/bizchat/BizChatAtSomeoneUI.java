package com.tencent.p177mm.p612ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C37449k;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI */
public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean yDJ = false;
    private String elQ;
    private String elR;
    private C5601o elS;
    private ListView gGW;
    private long jMj;
    private String mTitle;
    private String talker;
    private C5289a yDH;
    private C45142c yDI;

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$a */
    static class C5289a extends C46692p<C45143j> {
        private C25814c elH = null;
        private List<String> elZ;
        String ema;
        private C45142c yDI;
        private String[] yDL;
        private Bitmap yDM;

        public final /* bridge */ /* synthetic */ Object bFt() {
            return null;
        }

        public C5289a(Context context, C45143j c45143j, C45142c c45142c, String[] strArr, List<String> list) {
            super(context, c45143j);
            AppMethodBeat.m2504i(30031);
            this.yDI = c45142c;
            this.yDL = strArr;
            this.elZ = list;
            C17927a c17927a = new C17927a();
            c17927a.ePK = C25754e.m40912rz(this.yDI.field_brandUserName);
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            this.elH = c17927a.ahG();
            this.yDM = C5056d.m7668v(context.getResources().getDrawable(C1318a.at_all_avater));
            AppMethodBeat.m2505o(30031);
        }

        public final int bFs() {
            AppMethodBeat.m2504i(30032);
            if (BizChatAtSomeoneUI.yDJ) {
                AppMethodBeat.m2505o(30032);
                return 1;
            }
            AppMethodBeat.m2505o(30032);
            return 0;
        }

        /* renamed from: wK */
        public final boolean mo10892wK(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            C15545b c15545b;
            AppMethodBeat.m2504i(30033);
            if (view == null) {
                inflate = View.inflate(this.context, 2130968781, null);
                c15545b = new C15545b();
                c15545b.emP = (MaskLayout) inflate.findViewById(2131821519);
                c15545b.emg = (TextView) inflate.findViewById(2131821520);
                inflate.setTag(c15545b);
            } else {
                c15545b = (C15545b) view.getTag();
                inflate = view;
            }
            if (i == 0 && BizChatAtSomeoneUI.yDJ) {
                c15545b.yDN.setImageBitmap(this.yDM);
                c15545b.emg.setText(this.context.getResources().getString(C25738R.string.f9337x2, new Object[]{"@"}));
                AppMethodBeat.m2505o(30033);
                return inflate;
            }
            C45143j c45143j = (C45143j) getItem(i - (BizChatAtSomeoneUI.yDJ ? 1 : 0));
            c15545b.emg.setTextColor(C1338a.m2870h(this.context, (int) C25738R.color.a7t));
            C32291o.ahp().mo43766a(c45143j.field_headImageUrl, (ImageView) c15545b.emP.getContentView(), this.elH);
            c15545b.emP.setMaskDrawable(null);
            c15545b.emg.setText(C44089j.m79293b(this.context, BizChatAtSomeoneUI.m88258a(this.yDI, c45143j.field_userId), c15545b.emg.getTextSize()));
            AppMethodBeat.m2505o(30033);
            return inflate;
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            String str;
            AppMethodBeat.m2504i(30034);
            bIf();
            C37449k aeV = C41747z.aeV();
            String[] strArr = this.yDL;
            String str2 = this.ema;
            List list = this.elZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select *  from BizChatUserInfo where ");
            StringBuilder append = stringBuilder.append(C37449k.m63135a(strArr, list));
            if (str2 == null || str2.equals("")) {
                str = "";
            } else {
                str = " and (" + "userName like '%" + str2 + "%' )";
            }
            append.append(str);
            StringBuilder append2 = stringBuilder.append(" order by ");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(BizChatUserInfo.userNamePY) ");
            stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
            append2.append(stringBuffer.toString());
            setCursor(aeV.bSd.rawQuery(stringBuilder.toString(), null));
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(30034);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(30035);
            mo6869KC();
            AppMethodBeat.m2505o(30035);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(30036);
            C45143j c45143j = new C45143j();
            c45143j.mo8995d(cursor);
            AppMethodBeat.m2505o(30036);
            return c45143j;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$b */
    static class C15545b {
        public MaskLayout emP;
        public TextView emg;
        public ImageView yDN;

        private C15545b() {
        }

        /* synthetic */ C15545b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$1 */
    class C303991 implements OnMenuItemClickListener {
        C303991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(30027);
            BizChatAtSomeoneUI.this.setResult(0);
            BizChatAtSomeoneUI.this.finish();
            AppMethodBeat.m2505o(30027);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$2 */
    class C406782 implements C5600b {
        C406782() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(30028);
            C5289a a = BizChatAtSomeoneUI.this.yDH;
            a.ema = str;
            a.mo5248a(null, null);
            AppMethodBeat.m2505o(30028);
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

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$4 */
    class C406794 implements OnScrollListener {
        C406794() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30030);
            C32291o.ahp().mo43773cm(i);
            AppMethodBeat.m2505o(30030);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI$3 */
    class C466383 implements OnItemClickListener {
        C466383() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(30029);
            Intent intent = new Intent();
            if (i == 0 && BizChatAtSomeoneUI.yDJ) {
                intent.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(C25738R.string.f9337x2, new Object[]{""}));
                intent.putExtra("select_raw_user_name", "notify@all");
            } else {
                C45143j c45143j = (C45143j) BizChatAtSomeoneUI.this.yDH.getItem(i);
                String a = BizChatAtSomeoneUI.m88258a(BizChatAtSomeoneUI.this.yDI, c45143j.field_userId);
                intent.putExtra("select_raw_user_name", c45143j.field_userId);
                intent.putExtra("Select_Conv_User", a);
            }
            BizChatAtSomeoneUI.this.setResult(-1, intent);
            BizChatAtSomeoneUI.this.finish();
            AppMethodBeat.m2505o(30029);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30037);
        super.onCreate(bundle);
        this.elQ = getIntent().getStringExtra("Block_list");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yDI = C41747z.aeT().mo60349aK(this.jMj);
        if (this.yDI == null) {
            C4990ab.m7420w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            AppMethodBeat.m2505o(30037);
            return;
        }
        if (this.yDI != null && this.yDI.field_ownerUserId.equals(C1853r.m3846Yz())) {
            yDJ = true;
        }
        initView();
        AppMethodBeat.m2505o(30037);
    }

    public final void initView() {
        AppMethodBeat.m2504i(30038);
        setMMTitle(this.mTitle);
        setBackBtn(new C303991());
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C406782();
        mo17380a(this.elS);
        this.gGW = (ListView) findViewById(2131821522);
        this.yDH = new C5289a(this, new C45143j(), this.yDI, dAJ(), m88256Ko());
        this.gGW.setOnItemClickListener(new C466383());
        this.gGW.setAdapter(this.yDH);
        this.gGW.setOnScrollListener(new C406794());
        AppMethodBeat.m2505o(30038);
    }

    public void onPause() {
        AppMethodBeat.m2504i(30039);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(30039);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(30040);
        this.yDH.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(30040);
    }

    private String[] dAJ() {
        AppMethodBeat.m2504i(30041);
        String[] strArr = null;
        if (!C42252ah.isNullOrNil(this.elR)) {
            strArr = this.elR.split(";");
            C4990ab.m7411d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        AppMethodBeat.m2505o(30041);
        return strArr;
    }

    /* renamed from: Ko */
    private List<String> m88256Ko() {
        AppMethodBeat.m2504i(30042);
        List<String> linkedList = new LinkedList();
        if (!C42252ah.isNullOrNil(this.elQ)) {
            linkedList = C42252ah.m74626j(this.elQ.split(";"));
        }
        AppMethodBeat.m2505o(30042);
        return linkedList;
    }

    public final int getLayoutId() {
        return 2130968782;
    }

    /* renamed from: a */
    protected static String m88258a(C45142c c45142c, String str) {
        AppMethodBeat.m2504i(30043);
        if (c45142c == null) {
            AppMethodBeat.m2505o(30043);
            return null;
        }
        String mJ = c45142c.mo73053mJ(str);
        AppMethodBeat.m2505o(30043);
        return mJ;
    }
}
