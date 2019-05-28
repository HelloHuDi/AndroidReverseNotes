package com.tencent.mm.ui.bizchat;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.o;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean yDJ = false;
    private String elQ;
    private String elR;
    private o elS;
    private ListView gGW;
    private long jMj;
    private String mTitle;
    private String talker;
    private a yDH;
    private c yDI;

    static class a extends p<j> {
        private com.tencent.mm.at.a.a.c elH = null;
        private List<String> elZ;
        String ema;
        private c yDI;
        private String[] yDL;
        private Bitmap yDM;

        public final /* bridge */ /* synthetic */ Object bFt() {
            return null;
        }

        public a(Context context, j jVar, c cVar, String[] strArr, List<String> list) {
            super(context, jVar);
            AppMethodBeat.i(30031);
            this.yDI = cVar;
            this.yDL = strArr;
            this.elZ = list;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePK = e.rz(this.yDI.field_brandUserName);
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.ePT = R.raw.default_avatar;
            this.elH = aVar.ahG();
            this.yDM = d.v(context.getResources().getDrawable(R.raw.at_all_avater));
            AppMethodBeat.o(30031);
        }

        public final int bFs() {
            AppMethodBeat.i(30032);
            if (BizChatAtSomeoneUI.yDJ) {
                AppMethodBeat.o(30032);
                return 1;
            }
            AppMethodBeat.o(30032);
            return 0;
        }

        public final boolean wK(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            b bVar;
            AppMethodBeat.i(30033);
            if (view == null) {
                inflate = View.inflate(this.context, R.layout.eu, null);
                bVar = new b();
                bVar.emP = (MaskLayout) inflate.findViewById(R.id.zb);
                bVar.emg = (TextView) inflate.findViewById(R.id.zc);
                inflate.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            if (i == 0 && BizChatAtSomeoneUI.yDJ) {
                bVar.yDN.setImageBitmap(this.yDM);
                bVar.emg.setText(this.context.getResources().getString(R.string.x2, new Object[]{"@"}));
                AppMethodBeat.o(30033);
                return inflate;
            }
            j jVar = (j) getItem(i - (BizChatAtSomeoneUI.yDJ ? 1 : 0));
            bVar.emg.setTextColor(com.tencent.mm.bz.a.h(this.context, (int) R.color.a7t));
            com.tencent.mm.at.o.ahp().a(jVar.field_headImageUrl, (ImageView) bVar.emP.getContentView(), this.elH);
            bVar.emP.setMaskDrawable(null);
            bVar.emg.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, BizChatAtSomeoneUI.a(this.yDI, jVar.field_userId), bVar.emg.getTextSize()));
            AppMethodBeat.o(30033);
            return inflate;
        }

        public final void KC() {
            String str;
            AppMethodBeat.i(30034);
            bIf();
            k aeV = z.aeV();
            String[] strArr = this.yDL;
            String str2 = this.ema;
            List list = this.elZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select *  from BizChatUserInfo where ");
            StringBuilder append = stringBuilder.append(k.a(strArr, list));
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
            AppMethodBeat.o(30034);
        }

        public final void KD() {
            AppMethodBeat.i(30035);
            KC();
            AppMethodBeat.o(30035);
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            AppMethodBeat.i(30036);
            j jVar = new j();
            jVar.d(cursor);
            AppMethodBeat.o(30036);
            return jVar;
        }
    }

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30037);
        super.onCreate(bundle);
        this.elQ = getIntent().getStringExtra("Block_list");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.jMj = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yDI = z.aeT().aK(this.jMj);
        if (this.yDI == null) {
            ab.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            AppMethodBeat.o(30037);
            return;
        }
        if (this.yDI != null && this.yDI.field_ownerUserId.equals(r.Yz())) {
            yDJ = true;
        }
        initView();
        AppMethodBeat.o(30037);
    }

    public final void initView() {
        AppMethodBeat.i(30038);
        setMMTitle(this.mTitle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(30027);
                BizChatAtSomeoneUI.this.setResult(0);
                BizChatAtSomeoneUI.this.finish();
                AppMethodBeat.o(30027);
                return true;
            }
        });
        this.elS = new o((byte) 0);
        this.elS.zHa = new com.tencent.mm.ui.tools.o.b() {
            public final void vO(String str) {
                AppMethodBeat.i(30028);
                a a = BizChatAtSomeoneUI.this.yDH;
                a.ema = str;
                a.a(null, null);
                AppMethodBeat.o(30028);
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
        this.yDH = new a(this, new j(), this.yDI, dAJ(), Ko());
        this.gGW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(30029);
                Intent intent = new Intent();
                if (i == 0 && BizChatAtSomeoneUI.yDJ) {
                    intent.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.string.x2, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    j jVar = (j) BizChatAtSomeoneUI.this.yDH.getItem(i);
                    String a = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this.yDI, jVar.field_userId);
                    intent.putExtra("select_raw_user_name", jVar.field_userId);
                    intent.putExtra("Select_Conv_User", a);
                }
                BizChatAtSomeoneUI.this.setResult(-1, intent);
                BizChatAtSomeoneUI.this.finish();
                AppMethodBeat.o(30029);
            }
        });
        this.gGW.setAdapter(this.yDH);
        this.gGW.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(30030);
                com.tencent.mm.at.o.ahp().cm(i);
                AppMethodBeat.o(30030);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        AppMethodBeat.o(30038);
    }

    public void onPause() {
        AppMethodBeat.i(30039);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.o(30039);
    }

    public void onDestroy() {
        AppMethodBeat.i(30040);
        this.yDH.bIf();
        super.onDestroy();
        AppMethodBeat.o(30040);
    }

    private String[] dAJ() {
        AppMethodBeat.i(30041);
        String[] strArr = null;
        if (!ah.isNullOrNil(this.elR)) {
            strArr = this.elR.split(";");
            ab.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        AppMethodBeat.o(30041);
        return strArr;
    }

    private List<String> Ko() {
        AppMethodBeat.i(30042);
        List<String> linkedList = new LinkedList();
        if (!ah.isNullOrNil(this.elQ)) {
            linkedList = ah.j(this.elQ.split(";"));
        }
        AppMethodBeat.o(30042);
        return linkedList;
    }

    public final int getLayoutId() {
        return R.layout.ev;
    }

    protected static String a(c cVar, String str) {
        AppMethodBeat.i(30043);
        if (cVar == null) {
            AppMethodBeat.o(30043);
            return null;
        }
        String mJ = cVar.mJ(str);
        AppMethodBeat.o(30043);
        return mJ;
    }
}
