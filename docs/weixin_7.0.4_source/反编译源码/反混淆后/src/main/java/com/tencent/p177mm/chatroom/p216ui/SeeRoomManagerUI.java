package com.tencent.p177mm.chatroom.p216ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.chatroom.p710c.C18135b;
import com.tencent.p177mm.chatroom.p710c.C41206d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p712j.p713a.p714a.C6593b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C35961vi;
import com.tencent.p177mm.protocal.protobuf.C7534bz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI */
public class SeeRoomManagerUI extends MMActivity implements C4931a {
    private C7577u eih;
    private String ejR;
    private C7650b elL;
    private GridView ely;
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$a */
    public class C1384a {
        public C7616ad ehM;
        public int type;

        public C1384a(int i, C7616ad c7616ad) {
            this.type = i;
            this.ehM = c7616ad;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$c */
    class C1385c {
        public ImageView ejo;
        public TextView elJ;

        C1385c() {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$b */
    public class C7650b extends BaseAdapter {
        List<C1384a> dataList = new ArrayList();
        private C25814c elH;
        Context mContext;

        /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$b$1 */
        class C76511 implements Runnable {
            C76511() {
            }

            public final void run() {
                AppMethodBeat.m2504i(104287);
                int dimension = (int) ((SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f9727ds) + SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f9972lw)) + SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f10016ni));
                if (SeeRoomManagerUI.this.elL.getCount() / 4 > 0) {
                    dimension *= (SeeRoomManagerUI.this.elL.getCount() / 4) + 1;
                }
                SeeRoomManagerUI.this.ely.setLayoutParams(new LayoutParams(SeeRoomManagerUI.this.ely.getWidth(), dimension));
                AppMethodBeat.m2505o(104287);
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(104295);
            C1384a iF = m13674iF(i);
            AppMethodBeat.m2505o(104295);
            return iF;
        }

        public C7650b(Context context) {
            AppMethodBeat.m2504i(104289);
            this.mContext = context;
            m13672Km();
            notifyDataSetChanged();
            C17927a c17927a = new C17927a();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.ePT = C1318a.default_avatar;
            this.elH = c17927a.ahG();
            AppMethodBeat.m2505o(104289);
        }

        public final void notifyDataSetChanged() {
            AppMethodBeat.m2504i(104290);
            super.notifyDataSetChanged();
            SeeRoomManagerUI.this.ely.post(new C76511());
            AppMethodBeat.m2505o(104290);
        }

        /* renamed from: Km */
        private void m13672Km() {
            AppMethodBeat.m2504i(104291);
            this.dataList.clear();
            SeeRoomManagerUI.this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(C5046bo.nullAsNil(SeeRoomManagerUI.this.ejR));
            if (SeeRoomManagerUI.this.eih == null) {
                AppMethodBeat.m2505o(104291);
                return;
            }
            for (String str : SeeRoomManagerUI.this.eih.afg()) {
                if (SeeRoomManagerUI.this.eih.aoo(str)) {
                    C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "[resetData] Room Manager:%s", str);
                    this.dataList.add(new C1384a(1, ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str)));
                }
            }
            if (C1853r.m3846Yz().equals(SeeRoomManagerUI.this.eih.field_roomowner)) {
                this.dataList.add(new C1384a(2, null));
                if (this.dataList.size() > 1) {
                    this.dataList.add(new C1384a(3, null));
                }
            }
            AppMethodBeat.m2505o(104291);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(104292);
            int size = this.dataList.size();
            AppMethodBeat.m2505o(104292);
            return size;
        }

        /* renamed from: iF */
        private C1384a m13674iF(int i) {
            AppMethodBeat.m2504i(104293);
            C1384a c1384a = (C1384a) this.dataList.get(i);
            AppMethodBeat.m2505o(104293);
            return c1384a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C1385c ce;
            AppMethodBeat.m2504i(104294);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970531, null);
                ce = SeeRoomManagerUI.this.mo17447ce(view);
            } else {
                ce = (C1385c) view.getTag();
                if (ce == null) {
                    ce = SeeRoomManagerUI.this.mo17447ce(view);
                }
            }
            C1384a iF = m13674iF(i);
            if (iF == null) {
                C4990ab.m7413e("MicroMsg.SeeRoomManagerUI", "null == item! position:%s, count:%s", Integer.valueOf(i), Integer.valueOf(getCount()));
                AppMethodBeat.m2505o(104294);
            } else {
                if (iF.type == 1) {
                    ce.elJ.setVisibility(0);
                    C7616ad c7616ad = iF.ehM;
                    ce.elJ.setText(SeeRoomManagerUI.m13659a(SeeRoomManagerUI.this, c7616ad.field_username, ce.elJ));
                    C40460b.m69434b(ce.ejo, c7616ad.field_username);
                } else if (iF.type == 2) {
                    ce.elJ.setVisibility(4);
                    ce.ejo.setImageResource(C25738R.drawable.f6436e4);
                } else if (iF.type == 3) {
                    ce.elJ.setVisibility(4);
                    ce.ejo.setImageResource(C25738R.drawable.f6437e5);
                }
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(104288);
                        C1384a c1384a = (C1384a) C7650b.this.dataList.get(i);
                        Intent intent;
                        if (c1384a.type == 1) {
                            C7616ad c7616ad = ((C1384a) C7650b.this.dataList.get(i)).ehM;
                            SeeRoomManagerUI.m13662a(SeeRoomManagerUI.this, c7616ad.field_username, C7650b.m13673a(C7650b.this, c7616ad), c7616ad.field_nickname);
                            AppMethodBeat.m2505o(104288);
                        } else if (c1384a.type == 2) {
                            intent = new Intent(SeeRoomManagerUI.this, SelectAddRoomManagerUI.class);
                            intent.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.ejR);
                            SeeRoomManagerUI.this.startActivityForResult(intent, 0);
                            AppMethodBeat.m2505o(104288);
                        } else {
                            if (c1384a.type == 3) {
                                intent = new Intent(SeeRoomManagerUI.this, SelectDelRoomManagerUI.class);
                                intent.putExtra("RoomInfo_Id", SeeRoomManagerUI.this.ejR);
                                intent.putExtra("RoomManagers", SeeRoomManagerUI.m13668e(SeeRoomManagerUI.this));
                                SeeRoomManagerUI.this.startActivityForResult(intent, 1);
                            }
                            AppMethodBeat.m2505o(104288);
                        }
                    }
                });
                AppMethodBeat.m2505o(104294);
            }
            return view;
        }

        /* renamed from: a */
        static /* synthetic */ String m13673a(C7650b c7650b, C7616ad c7616ad) {
            String mJ;
            String Oi;
            AppMethodBeat.m2504i(104296);
            if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
                mJ = SeeRoomManagerUI.this.eih.mo16807mJ(c7616ad.field_username);
            } else {
                mJ = c7616ad.field_conRemark;
            }
            if (C5046bo.isNullOrNil(mJ)) {
                Oi = c7616ad.mo16706Oi();
            } else {
                Oi = mJ;
            }
            if (!C7486a.m12942jh(c7616ad.field_type)) {
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(c7616ad.field_username);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_conRemark))) {
                    Oi = RB.field_conRemark;
                }
            }
            AppMethodBeat.m2505o(104296);
            return Oi;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$2 */
    class C76542 implements Runnable {
        C76542() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104283);
            int dimension = (int) ((SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f9727ds) + SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f9972lw)) + SeeRoomManagerUI.this.getResources().getDimension(C25738R.dimen.f10016ni));
            if (SeeRoomManagerUI.this.elL.getCount() / 4 > 0) {
                dimension *= (SeeRoomManagerUI.this.elL.getCount() / 4) + 1;
            }
            SeeRoomManagerUI.this.ely.setLayoutParams(new LayoutParams(SeeRoomManagerUI.this.ely.getWidth(), dimension));
            AppMethodBeat.m2505o(104283);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$3 */
    class C76553 implements OnMenuItemClickListener {
        C76553() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104284);
            SeeRoomManagerUI.this.finish();
            AppMethodBeat.m2505o(104284);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomManagerUI$1 */
    class C76561 implements OnTouchListener {
        C76561() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104297);
        super.onCreate(bundle);
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10116c(this);
        this.ejR = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.m2505o(104297);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104298);
        super.onDestroy();
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10117d(this);
        AppMethodBeat.m2505o(104298);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104299);
        super.initView();
        setMMTitle((int) C25738R.string.dt2);
        this.ely = (GridView) findViewById(2131827305);
        this.elL = new C7650b(this);
        this.ely.setAdapter(this.elL);
        this.ely.setOnTouchListener(new C76561());
        this.ely.post(new C76542());
        setBackBtn(new C76553());
        AppMethodBeat.m2505o(104299);
    }

    public final int getLayoutId() {
        return 2130970581;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(104300);
        if (c4935m != null) {
            C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "[onNotifyChange] event:%s [%s:%s]", str, c4935m.ctq, Integer.valueOf(c4935m.hsh));
        }
        AppMethodBeat.m2505o(104300);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ce */
    public final C1385c mo17447ce(View view) {
        AppMethodBeat.m2504i(104301);
        C1385c c1385c = new C1385c();
        c1385c.ejo = (ImageView) view.findViewById(2131827163);
        c1385c.elJ = (TextView) view.findViewById(2131827168);
        AppMethodBeat.m2505o(104301);
        return c1385c;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104302);
        super.onActivityResult(i, i2, intent);
        if (intent == null || i2 != -1) {
            String str = "MicroMsg.SeeRoomManagerUI";
            String str2 = "[onActivityResult] data is null? %s resultCode:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            objArr[1] = Integer.valueOf(i2);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(104302);
            return;
        }
        String stringExtra = intent.getStringExtra("Select_Contact");
        C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "[onActivityResult] roomName:%s requestCode:%s userListString:%s", this.ejR, Integer.valueOf(i), stringExtra);
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7412e("MicroMsg.SeeRoomManagerUI", "[onActivityResult] userListString is null!");
            AppMethodBeat.m2505o(104302);
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
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.drb), false, null);
                new C18135b(this.ejR, linkedList).acy().mo60488b((C5685b) this).mo60487b(new C5681a<Void, C37441a<C7534bz>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(104285);
                        C37441a c37441a = (C37441a) obj;
                        if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                            SeeRoomManagerUI.this.tipDialog.dismiss();
                        }
                        C42124a jY = C42124a.m74268jY(c37441a.aIm);
                        if (jY != null) {
                            jY.mo67668a(SeeRoomManagerUI.this, null, null);
                            Void voidR = zXH;
                            AppMethodBeat.m2505o(104285);
                            return voidR;
                        }
                        if (c37441a.errType == 0 && c37441a.errCode == 0) {
                            SeeRoomManagerUI.m13663a(SeeRoomManagerUI.this, linkedList);
                            SeeRoomManagerUI.this.elL.notifyDataSetChanged();
                        } else if (c37441a.cwn.getType() == 889) {
                            C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), C5046bo.nullAsNil(c37441a.aIm));
                            C30379h.m48461b(SeeRoomManagerUI.this.mController.ylL, C5046bo.m7532bc(c37441a.aIm, SeeRoomManagerUI.this.getString(C25738R.string.f8710cr)), SeeRoomManagerUI.this.getString(C25738R.string.f9238tz), true);
                        }
                        AppMethodBeat.m2505o(104285);
                        return null;
                    }
                });
                AppMethodBeat.m2505o(104302);
                return;
            case 1:
                context = this.mController.ylL;
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.drw), false, null);
                new C41206d(this.ejR, linkedList).acy().mo60488b((C5685b) this).mo60487b(new C5681a<Void, C37441a<C35961vi>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(104286);
                        C37441a c37441a = (C37441a) obj;
                        if (SeeRoomManagerUI.this.tipDialog != null && SeeRoomManagerUI.this.tipDialog.isShowing()) {
                            SeeRoomManagerUI.this.tipDialog.dismiss();
                        }
                        C42124a jY = C42124a.m74268jY(c37441a.aIm);
                        if (jY != null) {
                            jY.mo67668a(SeeRoomManagerUI.this, null, null);
                            Void voidR = zXH;
                            AppMethodBeat.m2505o(104286);
                            return voidR;
                        }
                        if (c37441a.errType == 0 && c37441a.errCode == 0) {
                            SeeRoomManagerUI.m13665b(SeeRoomManagerUI.this, linkedList);
                            SeeRoomManagerUI.this.elL.notifyDataSetChanged();
                        } else if (c37441a.cwn.getType() == C31128d.MIC_PTU_ZIPAI_MEDSEA) {
                            C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(774), Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), C5046bo.nullAsNil(c37441a.aIm));
                            C30379h.m48461b(SeeRoomManagerUI.this.mController.ylL, SeeRoomManagerUI.this.getString(C25738R.string.b4y), SeeRoomManagerUI.this.getString(C25738R.string.f9238tz), true);
                        }
                        AppMethodBeat.m2505o(104286);
                        return null;
                    }
                });
                break;
        }
        AppMethodBeat.m2505o(104302);
    }

    /* renamed from: a */
    static /* synthetic */ SpannableString m13659a(SeeRoomManagerUI seeRoomManagerUI, String str, TextView textView) {
        AppMethodBeat.m2504i(104303);
        if (textView == null) {
            AppMethodBeat.m2505o(104303);
            return null;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C5046bo.nullAsNil(str));
        if (aoO == null) {
            C4990ab.m7420w("MicroMsg.SeeRoomManagerUI", "ct == null");
            AppMethodBeat.m2505o(104303);
            return null;
        }
        String mJ = !C5046bo.isNullOrNil(aoO.field_conRemark) ? aoO.field_conRemark : seeRoomManagerUI.eih != null ? seeRoomManagerUI.eih.mo16807mJ(str) : null;
        if (C5046bo.isNullOrNil(mJ)) {
            mJ = aoO.field_conRemark;
        }
        if (C5046bo.isNullOrNil(mJ)) {
            mJ = aoO.mo16706Oi();
        }
        SpannableString b = C44089j.m79293b((Context) seeRoomManagerUI, C5046bo.nullAsNil(mJ), textView.getTextSize());
        AppMethodBeat.m2505o(104303);
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ void m13662a(SeeRoomManagerUI seeRoomManagerUI, String str, String str2, String str3) {
        AppMethodBeat.m2504i(104304);
        if (C5046bo.isNullOrNil(str2)) {
            C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(str);
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                str2 = RB.field_conRemark;
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomManagerUI.eih != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomManagerUI.eih.mo16807mJ(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomManagerUI.ejR);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                C42041qh c42041qh = new C42041qh();
                c42041qh.cMw.intent = intent;
                c42041qh.cMw.username = str;
                C4879a.xxA.mo10055m(c42041qh);
            }
            if (aoO != null && aoO.dsf()) {
                C7060h.pYm.mo8374X(10298, aoO.field_username + ",14");
            }
            intent.putExtra("Contact_Scene", 96);
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeRoomManagerUI.ejR);
            C25985d.m41467b((Context) seeRoomManagerUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.m2505o(104304);
    }

    /* renamed from: e */
    static /* synthetic */ String m13668e(SeeRoomManagerUI seeRoomManagerUI) {
        AppMethodBeat.m2504i(104305);
        List linkedList = new LinkedList();
        for (C1384a c1384a : seeRoomManagerUI.elL.dataList) {
            if (c1384a.type == 1) {
                linkedList.add(c1384a.ehM.field_username);
            }
        }
        String c = C5046bo.m7536c(linkedList, ",");
        AppMethodBeat.m2505o(104305);
        return c;
    }

    /* renamed from: b */
    static /* synthetic */ void m13665b(SeeRoomManagerUI seeRoomManagerUI, List list) {
        AppMethodBeat.m2504i(104307);
        C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s", seeRoomManagerUI.ejR, Integer.valueOf(list.size()));
        LinkedList linkedList = new LinkedList(seeRoomManagerUI.elL.dataList);
        seeRoomManagerUI.elL.dataList.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C1384a c1384a = (C1384a) it.next();
            if (c1384a.type == 1 && !list.contains(c1384a.ehM.field_username)) {
                seeRoomManagerUI.elL.dataList.add(c1384a);
            } else if (c1384a.type == 1 && list.contains(c1384a.ehM.field_username)) {
                C6593b aon = seeRoomManagerUI.eih.aon(c1384a.ehM.field_username);
                if (aon != null) {
                    aon.eoA &= -2049;
                }
            }
        }
        seeRoomManagerUI.elL.dataList.add(new C1384a(2, null));
        if (seeRoomManagerUI.elL.dataList.size() > 1) {
            seeRoomManagerUI.elL.dataList.add(new C1384a(3, null));
        } else {
            C4990ab.m7421w("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] roomName:%s size:%s mAdapter.dataList size:%s", seeRoomManagerUI.ejR, Integer.valueOf(list.size()), seeRoomManagerUI.elL.dataList);
        }
        boolean a = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10099a(seeRoomManagerUI.eih);
        C4990ab.m7417i("MicroMsg.SeeRoomManagerUI", "[delRoomManagerSuccessful] ret:%s", Boolean.valueOf(a));
        AppMethodBeat.m2505o(104307);
    }
}
