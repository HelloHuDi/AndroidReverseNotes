package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.y;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements f {
    private static int elW = 5;
    private int Lp;
    private boolean cEH;
    private boolean ehL;
    private u eih;
    private String ejD;
    private String ejR;
    private int ejS;
    private String ejT;
    private boolean ejU;
    private p ejZ;
    private b elP;
    private String elQ;
    private String elR;
    private o elS;
    private String elT;
    private MMEditText elU;
    private int elV;
    private GridView ely;
    private String mTitle;
    private String talker;
    private String username;

    static class a {
        ad ehM;
        int order;
        int type;

        public a(ad adVar, int i) {
            this.order = 0;
            this.type = 1;
            this.ehM = adVar;
            this.order = i;
        }

        public a(int i) {
            this.order = 0;
            this.type = i;
            this.ehM = null;
        }
    }

    class b extends BaseAdapter {
        private List<a> cFX = new ArrayList();
        private String ehq;
        private u eih;
        private List<String> elZ;
        public String ema;
        private boolean emb = false;
        private String emc = null;
        private List<a> emd;
        private j eme;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(104333);
            a iG = iG(i);
            AppMethodBeat.o(104333);
            return iG;
        }

        public b(Context context, u uVar, String str, List<String> list, String str2) {
            AppMethodBeat.i(104326);
            this.eih = uVar;
            this.ehq = str;
            this.elZ = list;
            this.emc = str2;
            this.mContext = context;
            this.eme = (j) g.K(j.class);
            Q(n.my(str));
            AppMethodBeat.o(104326);
        }

        public final void Q(List<String> list) {
            AppMethodBeat.i(104327);
            if (list == null) {
                AppMethodBeat.o(104327);
                return;
            }
            this.cFX.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                ad aoO = this.eme.XM().aoO((String) list.get(i2));
                if (this.eih.aos(aoO.field_username)) {
                    this.cFX.add(new a(aoO, 3));
                } else if (this.eih.aoo(aoO.field_username)) {
                    this.cFX.add(new a(aoO, 2));
                } else {
                    this.cFX.add(new a(aoO, 1));
                }
                i = i2 + 1;
            }
            Collections.sort(this.cFX, new Comparator<a>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((a) obj2).order - ((a) obj).order;
                }
            });
            this.cFX.add(new a(2));
            if (this.eih.JR()) {
                this.cFX.add(new a(3));
            }
            this.emd = this.cFX;
            notifyDataSetChanged();
            AppMethodBeat.o(104327);
        }

        private void kn(String str) {
            AppMethodBeat.i(104328);
            ArrayList arrayList = new ArrayList();
            if (bo.isNullOrNil(str)) {
                this.cFX = this.emd;
            } else {
                for (a aVar : this.emd) {
                    if (!(aVar == null || aVar.ehM == null || aVar.type != 1)) {
                        ad adVar = aVar.ehM;
                        if (adVar.field_conRemark != null && adVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (!bo.isNullOrNil(SeeRoomMemberUI.a(this.eih, adVar.field_username)) && SeeRoomMemberUI.a(this.eih, adVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (adVar.Oi() != null && adVar.Oi().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (adVar.Ht() != null && adVar.Ht().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (adVar.Hq() != null && adVar.Hq().contains(str)) {
                            arrayList.add(aVar);
                        } else if (adVar.field_username != null && adVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                            bv RB = ((j) g.K(j.class)).XN().RB(adVar.field_username);
                            if (!(RB == null || RB.field_conRemark == null || !RB.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                ab.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.cFX = arrayList;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(104328);
        }

        public final a iG(int i) {
            AppMethodBeat.i(104329);
            a aVar = (a) this.cFX.get(i);
            AppMethodBeat.o(104329);
            return aVar;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(104330);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.aqd, null);
                cVar = new c();
                cVar.ejo = (ImageView) view.findViewById(R.id.av4);
                cVar.emg = (TextView) view.findViewById(R.id.av6);
                cVar.emg.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                cVar.emh = (TextView) view.findViewById(R.id.e7s);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (cVar.emh != null) {
                cVar.emh.setVisibility(8);
            }
            a aVar = (a) this.cFX.get(i);
            if (aVar != null && aVar.type == 1) {
                CharSequence charSequence;
                ad adVar = aVar.ehM;
                com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, adVar.field_username);
                String a = SeeRoomMemberUI.a(this.eih, adVar.field_username);
                if (bo.isNullOrNil(adVar.field_conRemark)) {
                    Object charSequence2 = a;
                } else {
                    charSequence2 = adVar.field_conRemark;
                }
                if (bo.isNullOrNil(charSequence2)) {
                    charSequence2 = adVar.Oi();
                }
                if (!(a == null || a.equals("") || charSequence2.equals(a))) {
                    charSequence2 = a + "( " + charSequence2 + " )";
                }
                cVar.emg.setVisibility(0);
                cVar.emg.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, charSequence2, cVar.emg.getTextSize()));
                if (cVar.emh != null) {
                    String A = com.tencent.mm.openim.room.a.a.A(adVar);
                    if (TextUtils.isEmpty(A)) {
                        cVar.emh.setVisibility(8);
                    } else {
                        cVar.emh.setVisibility(0);
                        cVar.emh.setText(A);
                    }
                }
            } else if (aVar != null && aVar.type == 2) {
                cVar.emg.setVisibility(4);
                cVar.ejo.setImageResource(R.drawable.e4);
            } else if (aVar != null && aVar.type == 3) {
                cVar.emg.setVisibility(4);
                cVar.ejo.setImageResource(R.drawable.e5);
            }
            AppMethodBeat.o(104330);
            return view;
        }

        public final void ko(String str) {
            AppMethodBeat.i(104331);
            this.emb = true;
            this.ema = str;
            kn(str);
            AppMethodBeat.o(104331);
        }

        public final int getCount() {
            AppMethodBeat.i(104332);
            int size = this.cFX.size();
            AppMethodBeat.o(104332);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static class c {
        public ImageView ejo;
        public TextView emg;
        public TextView emh;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void k(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(104358);
        seeRoomMemberUI.Kn();
        AppMethodBeat.o(104358);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104334);
        super.onCreate(bundle);
        h.pYm.a(219, 2, 1, true);
        g.RO().eJo.a(990, (f) this);
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejT = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.talker == null ? this.ejD : this.talker);
        this.ejS = getIntent().getIntExtra("room_member_count", 0);
        this.ejR = getIntent().getStringExtra("room_name");
        this.Lp = getIntent().getIntExtra("offset", 0);
        this.elV = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.elP != null) {
            Kn();
            this.ely.setSelection(this.elV * elW < this.elP.getCount() ? this.elV * elW : this.elP.getCount() - 1);
            this.ely.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(104308);
                    if (VERSION.SDK_INT >= 19) {
                        SeeRoomMemberUI.this.ely.scrollListBy(SeeRoomMemberUI.this.Lp);
                        AppMethodBeat.o(104308);
                        return;
                    }
                    SeeRoomMemberUI.a(SeeRoomMemberUI.this.ely, "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.this.Lp), Integer.valueOf(-SeeRoomMemberUI.this.Lp)}, new Class[]{Integer.TYPE, Integer.TYPE});
                    AppMethodBeat.o(104308);
                }
            }, 100);
        }
        AppMethodBeat.o(104334);
    }

    public void onResume() {
        AppMethodBeat.i(104335);
        super.onResume();
        if (this.elP != null) {
            this.elP.ko(this.elU.getText().toString());
        }
        AppMethodBeat.o(104335);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(104336);
        super.onConfigurationChanged(configuration);
        this.ely.setNumColumns(bz(this));
        AppMethodBeat.o(104336);
    }

    private static int bz(Context context) {
        AppMethodBeat.i(104337);
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.dimen.ld) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.dimen.lo) * 2.0f) + context.getResources().getDimension(R.dimen.lw)))));
        ab.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", Integer.valueOf(width));
        elW = width;
        AppMethodBeat.o(104337);
        return width;
    }

    public final void initView() {
        AppMethodBeat.i(104338);
        setMMTitle(this.mTitle + "(" + this.ejS + ")");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104317);
                SeeRoomMemberUI.this.setResult(0);
                SeeRoomMemberUI.this.finish();
                AppMethodBeat.o(104317);
                return true;
            }
        });
        this.elU = (MMEditText) findViewById(R.id.b98);
        this.ely = (GridView) findViewById(R.id.e7t);
        this.ely.setNumColumns(bz(this));
        this.ely.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ld));
        this.elP = new b(this, this.eih, this.ejD, Ko(), this.ejT);
        this.elU.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(104318);
                SeeRoomMemberUI.this.elP.ko(charSequence.toString());
                AppMethodBeat.o(104318);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.ely.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(104319);
                a iG = SeeRoomMemberUI.this.elP.iG(i);
                if (iG.type == 2) {
                    ab.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                    h.pYm.a(219, 6, 1, true);
                    SeeRoomMemberUI.d(SeeRoomMemberUI.this);
                    AppMethodBeat.o(104319);
                } else if (iG.type == 3) {
                    ab.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                    SeeRoomMemberUI.e(SeeRoomMemberUI.this);
                    AppMethodBeat.o(104319);
                } else {
                    if (iG.type == 1) {
                        ad adVar = SeeRoomMemberUI.this.elP.iG(i).ehM;
                        if (adVar == null) {
                            ab.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                            AppMethodBeat.o(104319);
                            return;
                        }
                        SeeRoomMemberUI.this.username = adVar.field_username;
                        String str = adVar.field_nickname;
                        String a = SeeRoomMemberUI.a(SeeRoomMemberUI.this.eih, SeeRoomMemberUI.this.username);
                        if (bo.isNullOrNil(a)) {
                            SeeRoomMemberUI.this.elT = adVar.Oj();
                        } else {
                            SeeRoomMemberUI.this.elT = a;
                        }
                        y.q(SeeRoomMemberUI.this.elU.getText().toString(), 1, 6, i + 1);
                        SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.username, SeeRoomMemberUI.this.elT, str);
                    }
                    AppMethodBeat.o(104319);
                }
            }
        });
        this.ely.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(104321);
                if (SeeRoomMemberUI.this.ejU) {
                    ad adVar = SeeRoomMemberUI.this.elP.iG(i).ehM;
                    if (adVar == null) {
                        AppMethodBeat.o(104321);
                    } else {
                        if (SeeRoomMemberUI.this.eih.field_roomowner.equals(adVar.field_username)) {
                            AppMethodBeat.o(104321);
                        } else {
                            com.tencent.mm.ui.base.h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(R.string.drz), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(104320);
                                    SeeRoomMemberUI.a(SeeRoomMemberUI.this, i);
                                    AppMethodBeat.o(104320);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(104321);
                        }
                    }
                } else {
                    ab.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                    AppMethodBeat.o(104321);
                }
                return true;
            }
        });
        this.ely.setAdapter(this.elP);
        AppMethodBeat.o(104338);
    }

    private void Kn() {
        AppMethodBeat.i(104339);
        this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.talker == null ? this.ejD : this.talker);
        List my = n.my(this.ejD);
        if (this.elP != null) {
            this.elP.Q(my);
        }
        AppMethodBeat.o(104339);
    }

    public void onPause() {
        AppMethodBeat.i(104340);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.o(104340);
    }

    public void onDestroy() {
        AppMethodBeat.i(104341);
        g.RO().eJo.b(990, (f) this);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(104341);
    }

    private List<String> Ko() {
        List P;
        AppMethodBeat.i(104342);
        LinkedList linkedList = new LinkedList();
        if (bo.isNullOrNil(this.elQ)) {
            Object P2 = linkedList;
        } else {
            P2 = bo.P(this.elQ.split(","));
        }
        bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
        if (RA != null) {
            P2.add(RA.name);
        }
        AppMethodBeat.o(104342);
        return P2;
    }

    public final int getLayoutId() {
        return R.layout.aqe;
    }

    private void km(String str) {
        AppMethodBeat.i(104343);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(104343);
            return;
        }
        List linkedList = new LinkedList();
        linkedList.add(str);
        final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(this.ejD).a(this.ejD, linkedList, 0);
        a.b(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(104322);
                SeeRoomMemberUI.k(SeeRoomMemberUI.this);
                SeeRoomMemberUI.l(SeeRoomMemberUI.this);
                AppMethodBeat.o(104322);
            }
        });
        a.c(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(104323);
                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(SeeRoomMemberUI.this, null, null);
                    AppMethodBeat.o(104323);
                    return;
                }
                if (i2 == -66) {
                    com.tencent.mm.ui.base.h.b(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(R.string.b50), SeeRoomMemberUI.this.getString(R.string.tz), true);
                    SeeRoomMemberUI.k(SeeRoomMemberUI.this);
                    SeeRoomMemberUI.l(SeeRoomMemberUI.this);
                }
                AppMethodBeat.o(104323);
            }
        });
        getString(R.string.tz);
        a.a(this, getString(R.string.drx), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(104324);
                a.cancel();
                AppMethodBeat.o(104324);
            }
        });
        AppMethodBeat.o(104343);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104344);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY != null) {
            jY.a(this, null, null);
            AppMethodBeat.o(104344);
            return;
        }
        AppMethodBeat.o(104344);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104345);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(104345);
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!com.tencent.mm.model.m.mo(stringExtra)) {
                    com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.dt9), getString(R.string.tz), true);
                    AppMethodBeat.o(104345);
                    return;
                } else if (kh(stringExtra)) {
                    com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cy), getString(R.string.tz), true);
                    AppMethodBeat.o(104345);
                    return;
                } else if (bo.P(stringExtra.split(",")) == null) {
                    AppMethodBeat.o(104345);
                    return;
                } else {
                    final String stringExtra2 = intent.getStringExtra("Select_Contact");
                    u oa = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(this.ejD);
                    if (oa != null) {
                        if (oa.drV() == 2) {
                            com.tencent.mm.ui.widget.a.e.a asL = new com.tencent.mm.ui.widget.a.e.a(this).asL(getString(R.string.dqy));
                            asL.zQJ = getString(R.string.tf);
                            asL = asL.re(true).m(Boolean.TRUE);
                            asL.zQK = getString(R.string.or);
                            asL.asN(getString(R.string.dip)).c(new com.tencent.mm.ui.widget.a.e.c() {
                                public final void d(boolean z, String str) {
                                    AppMethodBeat.i(104325);
                                    if (z) {
                                        SeeRoomMemberUI.a(SeeRoomMemberUI.this, stringExtra2, str);
                                    }
                                    AppMethodBeat.o(104325);
                                }
                            }).show();
                            AppMethodBeat.o(104345);
                            return;
                        }
                        b(stringExtra, null, R.string.db);
                        AppMethodBeat.o(104345);
                        return;
                    }
                }
                break;
            case 2:
                if (intent != null) {
                    km(intent.getStringExtra("Select_Contact"));
                    break;
                } else {
                    AppMethodBeat.o(104345);
                    return;
                }
        }
        AppMethodBeat.o(104345);
    }

    private void b(String str, String str2, int i) {
        AppMethodBeat.i(104346);
        if (!com.tencent.mm.model.m.mo(str)) {
            com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.dt9), getString(R.string.tz), true);
            AppMethodBeat.o(104346);
        } else if (kh(str)) {
            com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cy), getString(R.string.tz), true);
            AppMethodBeat.o(104346);
        } else {
            List P = bo.P(str.split(","));
            if (P == null) {
                AppMethodBeat.o(104346);
                return;
            }
            final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(this.ejD).a(this.ejD, P, str2);
            a.d(new com.tencent.mm.roomsdk.a.b.c() {
                public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                    AppMethodBeat.i(104309);
                    com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(SeeRoomMemberUI.this, null, null);
                        AppMethodBeat.o(104309);
                    } else if (i == 0 && i2 == 0) {
                        if (i == 0 && i2 == 0) {
                            SeeRoomMemberUI.a(SeeRoomMemberUI.this, i2, cVar);
                            SeeRoomMemberUI.k(SeeRoomMemberUI.this);
                        }
                        SeeRoomMemberUI.l(SeeRoomMemberUI.this);
                        AppMethodBeat.o(104309);
                    } else {
                        SeeRoomMemberUI.a(SeeRoomMemberUI.this, i2, cVar);
                        SeeRoomMemberUI.k(SeeRoomMemberUI.this);
                        AppMethodBeat.o(104309);
                    }
                }
            });
            getString(R.string.tz);
            a.a(this, getString(i), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(104310);
                    a.cancel();
                    AppMethodBeat.o(104310);
                }
            });
            AppMethodBeat.o(104346);
        }
    }

    private void d(String str, List<String> list) {
        AppMethodBeat.i(104347);
        if (list != null && list.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            com.tencent.mm.model.m.a(str, linkedList, getString(R.string.ajv), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
        AppMethodBeat.o(104347);
    }

    private static boolean JI() {
        AppMethodBeat.i(104348);
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("ChatroomGlobalSwitch"), 1) == 1) {
            AppMethodBeat.o(104348);
            return true;
        }
        AppMethodBeat.o(104348);
        return false;
    }

    private static List<String> O(List<String> list) {
        AppMethodBeat.i(104349);
        LinkedList linkedList = new LinkedList();
        if (!g.RK()) {
            AppMethodBeat.o(104349);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(104349);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                ad aoO = ((j) g.K(j.class)).XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.o(104349);
            return linkedList;
        }
    }

    private boolean kh(String str) {
        boolean z = false;
        AppMethodBeat.i(104350);
        if (bo.nullAsNil(r.Yz()).equals(str)) {
            AppMethodBeat.o(104350);
            return true;
        }
        List my = n.my(this.ejD);
        if (my == null) {
            AppMethodBeat.o(104350);
            return false;
        }
        Iterator it = my.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.o(104350);
                return z2;
            } else if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    protected static String a(u uVar, String str) {
        AppMethodBeat.i(104351);
        String str2;
        if (uVar == null) {
            str2 = "";
            AppMethodBeat.o(104351);
            return str2;
        }
        str2 = uVar.mJ(str);
        AppMethodBeat.o(104351);
        return str2;
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Class cls;
        AppMethodBeat.i(104352);
        if (obj == null) {
            AppMethodBeat.o(104352);
            return null;
        }
        Method declaredMethod;
        Object invoke;
        cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (NoSuchMethodException e) {
                ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (SecurityException e2) {
                ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (IllegalAccessException e3) {
                ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (IllegalArgumentException e4) {
                ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e4, "", new Object[0]);
                invoke = null;
            } catch (InvocationTargetException e5) {
                ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e5, "", new Object[0]);
            }
            AppMethodBeat.o(104352);
            return invoke;
        }
        invoke = null;
        AppMethodBeat.o(104352);
        return invoke;
        cls = cls.getSuperclass();
    }

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(104354);
        String c = bo.c(n.my(seeRoomMemberUI.ejD), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.string.eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.znF);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 4);
        intent.putExtra("KBlockOpenImFav", t.mO(seeRoomMemberUI.ejD));
        d.b((Context) seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(104354);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(104355);
        h.pYm.a(219, 8, 1, true);
        List my = n.my(seeRoomMemberUI.ejD);
        String c = bo.c(my, ",");
        int size = my.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.ejD);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.ejU);
        intent.putExtra("list_attr", s.znF);
        intent.putExtra("room_name", seeRoomMemberUI.ejD);
        intent.putExtra("room_owner_name", seeRoomMemberUI.eih.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(104355);
    }

    static /* synthetic */ void l(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.i(104359);
        if (seeRoomMemberUI.eih != null) {
            seeRoomMemberUI.setMMTitle(seeRoomMemberUI.mTitle + "(" + seeRoomMemberUI.eih.afg().size() + ")");
        }
        AppMethodBeat.o(104359);
    }
}
