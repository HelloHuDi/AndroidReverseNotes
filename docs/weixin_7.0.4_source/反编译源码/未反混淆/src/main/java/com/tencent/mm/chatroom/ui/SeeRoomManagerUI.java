package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.c.d;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomManagerUI extends MMActivity implements com.tencent.mm.sdk.e.k.a {
    private u eih;
    private String ejR;
    private b elL;
    private GridView ely;
    private p tipDialog;

    public class a {
        public ad ehM;
        public int type;

        public a(int i, ad adVar) {
            this.type = i;
            this.ehM = adVar;
        }
    }

    class c {
        public ImageView ejo;
        public TextView elJ;

        c() {
        }
    }

    public class b extends BaseAdapter {
        List<a> dataList = new ArrayList();
        private com.tencent.mm.at.a.a.c elH;
        Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(104295);
            a iF = iF(i);
            AppMethodBeat.o(104295);
            return iF;
        }

        public b(Context context) {
            AppMethodBeat.i(104289);
            this.mContext = context;
            Km();
            notifyDataSetChanged();
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.ePT = R.raw.default_avatar;
            this.elH = aVar.ahG();
            AppMethodBeat.o(104289);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.i(104290);
            super.notifyDataSetChanged();
            SeeRoomManagerUI.this.ely.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(104287);
                    int dimension = (int) ((SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ds) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.lw)) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ni));
                    if (SeeRoomManagerUI.this.elL.getCount() / 4 > 0) {
                        dimension *= (SeeRoomManagerUI.this.elL.getCount() / 4) + 1;
                    }
                    SeeRoomManagerUI.this.ely.setLayoutParams(new LayoutParams(SeeRoomManagerUI.this.ely.getWidth(), dimension));
                    AppMethodBeat.o(104287);
                }
            });
            AppMethodBeat.o(104290);
        }

        private void Km() {
            AppMethodBeat.i(104291);
            this.dataList.clear();
            SeeRoomManagerUI.this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oa(bo.nullAsNil(SeeRoomManagerUI.this.ejR));
            if (SeeRoomManagerUI.this.eih == null) {
                AppMethodBeat.o(104291);
                return;
            }
            for (String str : SeeRoomManagerUI.this.eih.afg()) {
                if (SeeRoomManagerUI.this.eih.aoo(str)) {
                    ab.i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", str);
                    this.dataList.add(new a(1, ((j) g.K(j.class)).XM().aoO(str)));
                }
            }
            if (r.Yz().equals(SeeRoomManagerUI.this.eih.field_roomowner)) {
                this.dataList.add(new a(2, null));
                if (this.dataList.size() > 1) {
                    this.dataList.add(new a(3, null));
                }
            }
            AppMethodBeat.o(104291);
        }

        public final int getCount() {
            AppMethodBeat.i(104292);
            int size = this.dataList.size();
            AppMethodBeat.o(104292);
            return size;
        }

        private a iF(int i) {
            AppMethodBeat.i(104293);
            a aVar = (a) this.dataList.get(i);
            AppMethodBeat.o(104293);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            c ce;
            AppMethodBeat.i(104294);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.ap0, null);
                ce = SeeRoomManagerUI.this.ce(view);
            } else {
                ce = (c) view.getTag();
                if (ce == null) {
                    ce = SeeRoomManagerUI.this.ce(view);
                }
            }
            a iF = iF(i);
            if (iF == null) {
                ab.e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", Integer.valueOf(i), Integer.valueOf(getCount()));
                AppMethodBeat.o(104294);
            } else {
                if (iF.type == 1) {
                    ce.elJ.setVisibility(0);
                    ad adVar = iF.ehM;
                    ce.elJ.setText(SeeRoomManagerUI.a(SeeRoomManagerUI.this, adVar.field_username, ce.elJ));
                    com.tencent.mm.pluginsdk.ui.a.b.b(ce.ejo, adVar.field_username);
                } else if (iF.type == 2) {
                    ce.elJ.setVisibility(4);
                    ce.ejo.setImageResource(R.drawable.e4);
                } else if (iF.type == 3) {
                    ce.elJ.setVisibility(4);
                    ce.ejo.setImageResource(R.drawable.e5);
                }
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(104288);
                        a aVar = (a) b.this.dataList.get(i);
                        Intent intent;
                        if (aVar.type == 1) {
                            ad adVar = ((a) b.this.dataList.get(i)).ehM;
                            SeeRoomManagerUI.a(SeeRoomManagerUI.this, adVar.field_username, b.a(b.this, adVar), adVar.field_nickname);
                            AppMethodBeat.o(104288);
                        } else if (aVar.type == 2) {
                            intent = new Intent(SeeRoomManagerUI.this, SelectAddRoomManagerUI.class);
                            intent.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.ejR);
                            SeeRoomManagerUI.this.startActivityForResult(intent, 0);
                            AppMethodBeat.o(104288);
                        } else {
                            if (aVar.type == 3) {
                                intent = new Intent(SeeRoomManagerUI.this, SelectDelRoomManagerUI.class);
                                intent.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.ejR);
                                intent.putExtra("RoomManagers", SeeRoomManagerUI.e(SeeRoomManagerUI.this));
                                SeeRoomManagerUI.this.startActivityForResult(intent, 1);
                            }
                            AppMethodBeat.o(104288);
                        }
                    }
                });
                AppMethodBeat.o(104294);
            }
            return view;
        }

        static /* synthetic */ String a(b bVar, ad adVar) {
            String mJ;
            String Oi;
            AppMethodBeat.i(104296);
            if (bo.isNullOrNil(adVar.field_conRemark)) {
                mJ = SeeRoomManagerUI.this.eih.mJ(adVar.field_username);
            } else {
                mJ = adVar.field_conRemark;
            }
            if (bo.isNullOrNil(mJ)) {
                Oi = adVar.Oi();
            } else {
                Oi = mJ;
            }
            if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                bv RB = ((j) g.K(j.class)).XN().RB(adVar.field_username);
                if (!(RB == null || bo.isNullOrNil(RB.field_conRemark))) {
                    Oi = RB.field_conRemark;
                }
            }
            AppMethodBeat.o(104296);
            return Oi;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104297);
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().c(this);
        this.ejR = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(104297);
    }

    public void onDestroy() {
        AppMethodBeat.i(104298);
        super.onDestroy();
        ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().d(this);
        AppMethodBeat.o(104298);
    }

    public final void initView() {
        AppMethodBeat.i(104299);
        super.initView();
        setMMTitle((int) R.string.dt2);
        this.ely = (GridView) findViewById(R.id.e7r);
        this.elL = new b(this);
        this.ely.setAdapter(this.elL);
        this.ely.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.ely.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104283);
                int dimension = (int) ((SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ds) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.lw)) + SeeRoomManagerUI.this.getResources().getDimension(R.dimen.ni));
                if (SeeRoomManagerUI.this.elL.getCount() / 4 > 0) {
                    dimension *= (SeeRoomManagerUI.this.elL.getCount() / 4) + 1;
                }
                SeeRoomManagerUI.this.ely.setLayoutParams(new LayoutParams(SeeRoomManagerUI.this.ely.getWidth(), dimension));
                AppMethodBeat.o(104283);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104284);
                SeeRoomManagerUI.this.finish();
                AppMethodBeat.o(104284);
                return true;
            }
        });
        AppMethodBeat.o(104299);
    }

    public final int getLayoutId() {
        return R.layout.aqc;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(104300);
        if (mVar != null) {
            ab.i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", str, mVar.ctq, Integer.valueOf(mVar.hsh));
        }
        AppMethodBeat.o(104300);
    }

    /* Access modifiers changed, original: protected|final */
    public final c ce(View view) {
        AppMethodBeat.i(104301);
        c cVar = new c();
        cVar.ejo = (ImageView) view.findViewById(R.id.e3x);
        cVar.elJ = (TextView) view.findViewById(R.id.e42);
        AppMethodBeat.o(104301);
        return cVar;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104302);
        super.onActivityResult(i, i2, intent);
        if (intent == null || i2 != -1) {
            String str = "MicroMsg.SeeRoomManagerUI";
            String str2 = "[onActivityResult] data is null? %s resultCode:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            objArr[1] = Integer.valueOf(i2);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(104302);
            return;
        }
        String stringExtra = intent.getStringExtra("Select_Contact");
        ab.i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", this.ejR, Integer.valueOf(i), stringExtra);
        if (bo.isNullOrNil(stringExtra)) {
            ab.e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
            AppMethodBeat.o(104302);
            return;
        }
        String[] split = stringExtra.split(",");
        final LinkedList linkedList = new LinkedList();
        for (Object add : split) {
            linkedList.add(add);
        }
        Context context;
        switch (i) {
            case 0:
                context = this.mController.ylL;
                getString(R.string.tz);
                this.tipDialog = h.b(context, getString(R.string.drb), false, null);
                new com.tencent.mm.chatroom.c.b(this.ejR, linkedList).acy().b((com.tencent.mm.vending.e.b) this).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bz>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(104285);
                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                        if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                            SeeRoomManagerUI.this.tipDialog.dismiss();
                        }
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(aVar.aIm);
                        if (jY != null) {
                            jY.a(SeeRoomManagerUI.this, null, null);
                            Void voidR = zXH;
                            AppMethodBeat.o(104285);
                            return voidR;
                        }
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            SeeRoomManagerUI.a(SeeRoomManagerUI.this, linkedList);
                            SeeRoomManagerUI.this.elL.notifyDataSetChanged();
                        } else if (aVar.cwn.getType() == 889) {
                            ab.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bo.nullAsNil(aVar.aIm));
                            h.b(SeeRoomManagerUI.this.mController.ylL, bo.bc(aVar.aIm, SeeRoomManagerUI.this.getString(R.string.cr)), SeeRoomManagerUI.this.getString(R.string.tz), true);
                        }
                        AppMethodBeat.o(104285);
                        return null;
                    }
                });
                AppMethodBeat.o(104302);
                return;
            case 1:
                context = this.mController.ylL;
                getString(R.string.tz);
                this.tipDialog = h.b(context, getString(R.string.drw), false, null);
                new d(this.ejR, linkedList).acy().b((com.tencent.mm.vending.e.b) this).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<vi>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(104286);
                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                        if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                            SeeRoomManagerUI.this.tipDialog.dismiss();
                        }
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(aVar.aIm);
                        if (jY != null) {
                            jY.a(SeeRoomManagerUI.this, null, null);
                            Void voidR = zXH;
                            AppMethodBeat.o(104286);
                            return voidR;
                        }
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            SeeRoomManagerUI.b(SeeRoomManagerUI.this, linkedList);
                            SeeRoomManagerUI.this.elL.notifyDataSetChanged();
                        } else if (aVar.cwn.getType() == com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA) {
                            ab.i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bo.nullAsNil(aVar.aIm));
                            h.b(SeeRoomManagerUI.this.mController.ylL, SeeRoomManagerUI.this.getString(R.string.b4y), SeeRoomManagerUI.this.getString(R.string.tz), true);
                        }
                        AppMethodBeat.o(104286);
                        return null;
                    }
                });
                break;
        }
        AppMethodBeat.o(104302);
    }

    static /* synthetic */ SpannableString a(SeeRoomManagerUI seeRoomManagerUI, String str, TextView textView) {
        AppMethodBeat.i(104303);
        if (textView == null) {
            AppMethodBeat.o(104303);
            return null;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(bo.nullAsNil(str));
        if (aoO == null) {
            ab.w("MicroMsg.SeeRoomManagerUI", "ct == null");
            AppMethodBeat.o(104303);
            return null;
        }
        String mJ = !bo.isNullOrNil(aoO.field_conRemark) ? aoO.field_conRemark : seeRoomManagerUI.eih != null ? seeRoomManagerUI.eih.mJ(str) : null;
        if (bo.isNullOrNil(mJ)) {
            mJ = aoO.field_conRemark;
        }
        if (bo.isNullOrNil(mJ)) {
            mJ = aoO.Oi();
        }
        SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b((Context) seeRoomManagerUI, bo.nullAsNil(mJ), textView.getTextSize());
        AppMethodBeat.o(104303);
        return b;
    }

    static /* synthetic */ void a(SeeRoomManagerUI seeRoomManagerUI, String str, String str2, String str3) {
        AppMethodBeat.i(104304);
        if (bo.isNullOrNil(str2)) {
            bv RB = ((j) g.K(j.class)).XN().RB(str);
            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                str2 = RB.field_conRemark;
            }
        }
        if (!bo.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomManagerUI.eih != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomManagerUI.eih.mJ(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomManagerUI.ejR);
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                qh qhVar = new qh();
                qhVar.cMw.intent = intent;
                qhVar.cMw.username = str;
                com.tencent.mm.sdk.b.a.xxA.m(qhVar);
            }
            if (aoO != null && aoO.dsf()) {
                com.tencent.mm.plugin.report.service.h.pYm.X(10298, aoO.field_username + ",14");
            }
            intent.putExtra("Contact_Scene", 96);
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeRoomManagerUI.ejR);
            com.tencent.mm.bp.d.b((Context) seeRoomManagerUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(104304);
    }

    static /* synthetic */ String e(SeeRoomManagerUI seeRoomManagerUI) {
        AppMethodBeat.i(104305);
        List linkedList = new LinkedList();
        for (a aVar : seeRoomManagerUI.elL.dataList) {
            if (aVar.type == 1) {
                linkedList.add(aVar.ehM.field_username);
            }
        }
        String c = bo.c(linkedList, ",");
        AppMethodBeat.o(104305);
        return c;
    }

    static /* synthetic */ void b(SeeRoomManagerUI seeRoomManagerUI, List list) {
        AppMethodBeat.i(104307);
        ab.i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s", seeRoomManagerUI.ejR, Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList(seeRoomManagerUI.elL.dataList);
        seeRoomManagerUI.elL.dataList.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == 1 && !list.contains(aVar.ehM.field_username)) {
                seeRoomManagerUI.elL.dataList.add(aVar);
            } else if (aVar.type == 1 && list.contains(aVar.ehM.field_username)) {
                com.tencent.mm.j.a.a.b aon = seeRoomManagerUI.eih.aon(aVar.ehM.field_username);
                if (aon != null) {
                    aon.eoA &= -2049;
                }
            }
        }
        seeRoomManagerUI.elL.dataList.add(new a(2, null));
        if (seeRoomManagerUI.elL.dataList.size() > 1) {
            seeRoomManagerUI.elL.dataList.add(new a(3, null));
        } else {
            ab.w("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s mAdapter.dataList size:%s", seeRoomManagerUI.ejR, Integer.valueOf(list.size()), seeRoomManagerUI.elL.dataList);
        }
        boolean a = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().a(seeRoomManagerUI.eih);
        ab.i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] ret:%s", Boolean.valueOf(a));
        AppMethodBeat.o(104307);
    }
}
