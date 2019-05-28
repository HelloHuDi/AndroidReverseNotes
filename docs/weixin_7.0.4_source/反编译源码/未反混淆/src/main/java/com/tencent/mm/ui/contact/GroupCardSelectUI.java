package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView emptyTipTv;
    private List<ad> oov;
    private boolean zmC = true;
    private boolean zmD;
    private boolean zmE = false;
    private List<String> zmF = null;
    private int zmG;
    private ListView zmH;
    private a zmI;
    private HashMap<String, Long> zmJ;

    class a extends BaseAdapter {
        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(33731);
            ad adVar = (ad) GroupCardSelectUI.this.oov.get(i);
            if (view == null) {
                b bVar2 = new b();
                view = View.inflate(GroupCardSelectUI.this, R.layout.a6k, null);
                bVar2.nJc = (TextView) view.findViewById(R.id.cae);
                bVar2.zmL = (TextView) view.findViewById(R.id.cad);
                bVar2.gvq = (ImageView) view.findViewById(R.id.cac);
                bVar2.piE = (CheckBox) view.findViewById(R.id.a1b);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.gvq, adVar.field_username);
            bVar.zmL.setText(j.b(GroupCardSelectUI.this, s.mJ(adVar.field_username), com.tencent.mm.bz.a.al(GroupCardSelectUI.this.mController.ylL, R.dimen.m5)));
            bVar.nJc.setText("(" + n.mA(adVar.field_username) + ")");
            if (t.mP(adVar.field_username)) {
                Drawable drawable = GroupCardSelectUI.this.getResources().getDrawable(R.raw.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                bVar.zmL.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
            } else {
                bVar.zmL.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
            if (GroupCardSelectUI.this.zmE) {
                bVar.piE.setVisibility(0);
                if (GroupCardSelectUI.this.zmF.contains(adVar.field_username)) {
                    bVar.piE.setChecked(true);
                } else {
                    bVar.piE.setChecked(false);
                }
            }
            AppMethodBeat.o(33731);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(33732);
            int size = GroupCardSelectUI.this.oov.size();
            AppMethodBeat.o(33732);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(33733);
            Object obj = GroupCardSelectUI.this.oov.get(i);
            AppMethodBeat.o(33733);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    class b {
        ImageView gvq;
        TextView nJc;
        CheckBox piE;
        TextView zmL;

        b() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(GroupCardSelectUI groupCardSelectUI) {
        AppMethodBeat.i(33743);
        groupCardSelectUI.Kt();
        AppMethodBeat.o(33743);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33734);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.el));
        this.zmC = getIntent().getBooleanExtra("group_select_type", true);
        this.zmD = getIntent().getBooleanExtra("group_select_need_result", false);
        this.zmE = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.zmE) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (bo.isNullOrNil(stringExtra)) {
                this.zmF = new LinkedList();
            } else {
                this.zmF = ah.j(stringExtra.split(","));
            }
            this.zmG = getIntent().getIntExtra("max_limit_num", 0);
        }
        dHT();
        initView();
        if (this.zmE) {
            a(1, getString(R.string.s6), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33730);
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", bo.c(GroupCardSelectUI.this.zmF, ","));
                    GroupCardSelectUI.this.setResult(-1, intent);
                    GroupCardSelectUI.this.finish();
                    AppMethodBeat.o(33730);
                    return true;
                }
            }, com.tencent.mm.ui.q.b.GREEN);
            enableOptionMenu(1, true);
            Kt();
        }
        AppMethodBeat.o(33734);
    }

    public void onDestroy() {
        AppMethodBeat.i(33735);
        super.onDestroy();
        AppMethodBeat.o(33735);
    }

    public void onResume() {
        AppMethodBeat.i(33736);
        super.onResume();
        AppMethodBeat.o(33736);
    }

    public void onPause() {
        AppMethodBeat.i(33737);
        super.onPause();
        AppMethodBeat.o(33737);
    }

    public final void initView() {
        AppMethodBeat.i(33738);
        this.zmH = (ListView) findViewById(R.id.caa);
        this.zmI = new a();
        this.zmH.setAdapter(this.zmI);
        this.zmH.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(33728);
                ad adVar = (ad) GroupCardSelectUI.this.zmI.getItem(i);
                if (adVar == null) {
                    ab.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    AppMethodBeat.o(33728);
                    return;
                }
                GroupCardSelectUI.a(GroupCardSelectUI.this, adVar);
                GroupCardSelectUI.b(GroupCardSelectUI.this);
                AppMethodBeat.o(33728);
            }
        });
        this.emptyTipTv = (TextView) findViewById(R.id.cab);
        if (this.zmI.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33729);
                GroupCardSelectUI.this.finish();
                AppMethodBeat.o(33729);
                return true;
            }
        });
        AppMethodBeat.o(33738);
    }

    private void dHT() {
        AppMethodBeat.i(33739);
        aw.ZK();
        this.zmJ = c.XR().dsK();
        this.oov = new LinkedList();
        List<ad> Zi = t.Zi();
        if (Zi.size() == 0) {
            AppMethodBeat.o(33739);
            return;
        }
        int i = 0;
        for (ad adVar : Zi) {
            int i2;
            if (this.zmJ.containsKey(adVar.field_username)) {
                a(i, adVar, ((Long) this.zmJ.get(adVar.field_username)).longValue());
                i2 = i + 1;
            } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                this.oov.add(adVar);
            } else {
                i2 = i;
            }
            i = i2;
        }
        Zi.clear();
        AppMethodBeat.o(33739);
    }

    private void a(int i, ad adVar, long j) {
        AppMethodBeat.i(33740);
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.zmJ.get(((ad) this.oov.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.oov.add(i2, adVar);
        AppMethodBeat.o(33740);
    }

    public final int getLayoutId() {
        return R.layout.a6j;
    }

    private void Kt() {
        AppMethodBeat.i(33741);
        if (this.zmE) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(R.string.s6));
            if (this.zmF.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.zmF.size())});
            } else {
                format = "";
            }
            updateOptionMenuText(1, append.append(format).toString());
        }
        AppMethodBeat.o(33741);
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, ad adVar) {
        int i = 1;
        AppMethodBeat.i(33742);
        Intent intent;
        if (groupCardSelectUI.zmE) {
            if (groupCardSelectUI.zmF.contains(adVar.field_username)) {
                groupCardSelectUI.zmF.remove(adVar.field_username);
            } else {
                if (!groupCardSelectUI.zmE || groupCardSelectUI.zmF.size() < groupCardSelectUI.zmG) {
                    i = 0;
                } else {
                    h.a(groupCardSelectUI.mController.ylL, groupCardSelectUI.getString(R.string.e1o, new Object[]{Integer.valueOf(groupCardSelectUI.zmG)}), groupCardSelectUI.getString(R.string.t6), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                if (i == 0) {
                    groupCardSelectUI.zmF.add(adVar.field_username);
                }
            }
            groupCardSelectUI.zmI.notifyDataSetChanged();
            AppMethodBeat.o(33742);
        } else if (!groupCardSelectUI.zmC) {
            intent = new Intent();
            aw.ZK();
            intent.putExtra("Select_Contact", bo.c(c.XV().oe(adVar.field_username), ","));
            intent.putExtra("Select_room_name", s.mJ(adVar.field_username));
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
            AppMethodBeat.o(33742);
        } else if (groupCardSelectUI.zmD) {
            intent = new Intent();
            intent.putExtra("Select_Conv_User", adVar.field_username);
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
            AppMethodBeat.o(33742);
        } else {
            intent = new Intent(groupCardSelectUI, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", adVar.field_username);
            groupCardSelectUI.startActivity(intent);
            groupCardSelectUI.finish();
            AppMethodBeat.o(33742);
        }
    }
}
