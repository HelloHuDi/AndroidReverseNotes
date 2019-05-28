package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements com.tencent.mm.ai.f {
    public static final String emJ = new String(Character.toChars(123));
    private p ejZ = null;
    private ArrayList<b> hUW = new ArrayList();
    private boolean qjN;
    private boolean qjO;
    private boolean qjP;
    private RecyclerView qpG;
    private TextView qpH;
    private View qpI;
    private View qpJ;
    private View qpK;
    private View qpL;
    private TextView qpM;
    private a qpN;
    private RealAlphabetScrollBar qpO;
    HashMap<String, Integer> qpP = new HashMap();
    private HashMap<Integer, String> qpQ = new HashMap();
    private HashSet<Integer> qpR = new HashSet();
    private d qpS;
    private int qpT = -1;
    private HashSet<String> qpU = new HashSet();
    private l qpV;
    private boolean qpW;

    static class f {
        static int qqu;
        static int qqv;
        static int qqw;
        static int qqx;
        static int qqy;
        static int qqz;
    }

    public interface h {
        void a(e eVar);

        void e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    interface g {
        void cjq();

        void fh(int i, int i2);
    }

    class a extends android.support.v7.widget.RecyclerView.a {
        a() {
        }

        public final v a(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(127654);
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b10, viewGroup, false));
            AppMethodBeat.o(127654);
            return cVar;
        }

        public final void a(v vVar, int i) {
            AppMethodBeat.i(127655);
            if (vVar instanceof c) {
                int i2;
                c cVar = (c) vVar;
                cVar.qqh.setTag(Integer.valueOf(i));
                cVar.apJ.setTag(Integer.valueOf(i));
                b bVar = (b) UnfamiliarContactDetailUI.this.hUW.get(i);
                com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) cVar.emP.getContentView(), bVar.ehM.field_username);
                cVar.jXx.setText(j.b(UnfamiliarContactDetailUI.this.mController.ylL, bVar.eoz, cVar.jXx.getTextSize()));
                cVar.qqg.setVisibility(bVar.ehM.Od() ? 0 : 8);
                ImageView imageView = cVar.qqf;
                String str = bVar.ehM.field_username;
                if (n.qFA != null && UnfamiliarContactDetailUI.this.qpU.size() == 0) {
                    UnfamiliarContactDetailUI.this.qpU.addAll(n.qFA.jT(5));
                }
                if (UnfamiliarContactDetailUI.this.qpU.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (UnfamiliarContactDetailUI.this.qpQ.containsKey(Integer.valueOf(i))) {
                    cVar.qqe.setVisibility(0);
                    cVar.qqe.setText((CharSequence) UnfamiliarContactDetailUI.this.qpQ.get(Integer.valueOf(i)));
                } else {
                    cVar.qqe.setVisibility(8);
                }
                if (UnfamiliarContactDetailUI.this.qpW) {
                    cVar.qqi.setPadding(cVar.qqi.getPaddingLeft(), cVar.qqi.getPaddingTop(), 0, cVar.qqi.getPaddingBottom());
                    if (UnfamiliarContactDetailUI.this.qpR.contains(Integer.valueOf(i))) {
                        cVar.moo.setChecked(true);
                    } else {
                        cVar.moo.setChecked(false);
                    }
                    cVar.qqh.setVisibility(0);
                    AppMethodBeat.o(127655);
                    return;
                }
                cVar.qqi.setPadding(cVar.qqi.getPaddingLeft(), cVar.qqi.getPaddingTop(), (int) UnfamiliarContactDetailUI.this.getResources().getDimension(R.dimen.ld), cVar.qqi.getPaddingBottom());
                cVar.qqh.setVisibility(8);
            }
            AppMethodBeat.o(127655);
        }

        public final int getItemCount() {
            AppMethodBeat.i(127656);
            int size = UnfamiliarContactDetailUI.this.hUW.size();
            AppMethodBeat.o(127656);
            return size;
        }

        public final b Cr(int i) {
            AppMethodBeat.i(127657);
            b bVar;
            if (UnfamiliarContactDetailUI.this.hUW.size() > i) {
                bVar = (b) UnfamiliarContactDetailUI.this.hUW.get(i);
                AppMethodBeat.o(127657);
                return bVar;
            }
            bVar = new b(new ad());
            AppMethodBeat.o(127657);
            return bVar;
        }
    }

    class c extends v {
        View apJ;
        MaskLayout emP;
        TextView jXx;
        CheckBox moo;
        TextView qqe;
        ImageView qqf;
        ImageView qqg;
        LinearLayout qqh;
        LinearLayout qqi;

        public c(View view) {
            super(view);
            AppMethodBeat.i(127660);
            this.apJ = view;
            this.emP = (MaskLayout) view.findViewById(R.id.ezv);
            this.jXx = (TextView) view.findViewById(R.id.ezw);
            this.qqe = (TextView) view.findViewById(R.id.ezu);
            this.qqf = (ImageView) view.findViewById(R.id.ezx);
            this.qqg = (ImageView) view.findViewById(R.id.ezy);
            this.qqh = (LinearLayout) view.findViewById(R.id.ezz);
            this.moo = (CheckBox) view.findViewById(R.id.js);
            this.qqi = (LinearLayout) view.findViewById(R.id.be8);
            this.qqh.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(127658);
                    int intValue = ((Integer) view.getTag()).intValue();
                    c.this.moo.setChecked(!c.this.moo.isChecked());
                    if (c.this.moo.isChecked()) {
                        UnfamiliarContactDetailUI.this.qpR.add(Integer.valueOf(intValue));
                    } else {
                        UnfamiliarContactDetailUI.this.qpR.remove(Integer.valueOf(intValue));
                    }
                    if (UnfamiliarContactDetailUI.this.qpR.size() == 0) {
                        UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                        UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
                        AppMethodBeat.o(127658);
                        return;
                    }
                    UnfamiliarContactDetailUI.this.qpK.setEnabled(true);
                    UnfamiliarContactDetailUI.this.qpJ.setEnabled(true);
                    AppMethodBeat.o(127658);
                }
            });
            view.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(127659);
                    int intValue = ((Integer) view.getTag()).intValue();
                    ab.i("MicroMsg.UnfamiliarContactUI", "position:%s", Integer.valueOf(intValue), UnfamiliarContactDetailUI.this.qpN.Cr(intValue).eoz);
                    c.a(c.this, r1, intValue);
                    AppMethodBeat.o(127659);
                }
            });
            AppMethodBeat.o(127660);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(c cVar, b bVar, int i) {
            AppMethodBeat.i(127661);
            if (bVar == null) {
                AppMethodBeat.o(127661);
                return;
            }
            String str;
            if (UnfamiliarContactDetailUI.this.qpW) {
                f.qqy++;
            } else {
                f.qqz++;
            }
            String str2 = bVar.eoz;
            String str3 = bVar.ehM.field_username;
            String str4 = bVar.ehM.field_nickname;
            if (bo.isNullOrNil(str2)) {
                bv RB = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XN().RB(str3);
                if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                    str = RB.field_conRemark;
                    if (!bo.isNullOrNil(str3)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str3);
                        intent.putExtra("Contact_RemarkName", str);
                        intent.putExtra("Contact_Nick", str4);
                        com.tencent.mm.plugin.setting.b.gkE.c(intent, UnfamiliarContactDetailUI.this);
                        UnfamiliarContactDetailUI.this.qpT = i;
                    }
                    AppMethodBeat.o(127661);
                }
            }
            str = str2;
            if (bo.isNullOrNil(str3)) {
            }
            AppMethodBeat.o(127661);
        }
    }

    class d implements com.tencent.mm.ai.f, Runnable {
        int index = 0;
        int oqN = 0;
        g qql;
        Collection<Integer> qqm;
        int qqn = 0;
        LinkedList<String> qqo = new LinkedList();
        LinkedList<com.tencent.mm.plugin.messenger.foundation.a.a.j.b> qqp = new LinkedList();

        d(Collection<Integer> collection, g gVar) {
            AppMethodBeat.i(127663);
            this.qqm = collection;
            this.qql = gVar;
            AppMethodBeat.o(127663);
        }

        public final void run() {
            AppMethodBeat.i(127664);
            this.oqN = this.qqm.size();
            for (Integer intValue : this.qqm) {
                int intValue2 = intValue.intValue();
                this.index++;
                int size = this.qqm.size();
                int i = this.index;
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    ad adVar = UnfamiliarContactDetailUI.this.qpN.Cr(intValue2).ehM;
                    if (ad.aox(adVar.field_username)) {
                        ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.a.class)).ve(adVar.field_username);
                    } else {
                        vl vlVar = new vl();
                        vlVar.wcB = new bts().alV(bo.nullAsNil(adVar.field_username));
                        this.qqp.add(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(4, vlVar));
                        if (this.qqp.size() % 20 == 0 || i == size) {
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.az.b(this.qqp), 0);
                            this.qqp.clear();
                        }
                    }
                }
            }
            AppMethodBeat.o(127664);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(127665);
            if (mVar.getType() == 681) {
                if (((com.tencent.mm.az.b) mVar).fLr == null || ((com.tencent.mm.az.b) mVar).fLr.fLu == null) {
                    ab.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
                    AppMethodBeat.o(127665);
                    return;
                }
                bhr bhr = ((com.tencent.mm.az.b) mVar).fLr.fLu.fLw;
                if (bhr.Ret != 0 || bhr.wKS == null || bhr.wKS.wof == null) {
                    ab.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(bhr.Ret));
                    AppMethodBeat.o(127665);
                    return;
                }
                List list = ((com.tencent.mm.az.b) mVar).fLs;
                ab.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", Integer.valueOf(list.size()), Integer.valueOf(bhr.wKS.wof.size()));
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list.size()) {
                        break;
                    }
                    com.tencent.mm.plugin.messenger.foundation.a.a.j.b bVar = (com.tencent.mm.plugin.messenger.foundation.a.a.j.b) list.get(i4);
                    if (bVar.getCmdId() != 4) {
                        ab.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", Integer.valueOf(bVar.getCmdId()), bVar.toString());
                    } else {
                        this.oqN--;
                        vl vlVar = (vl) bVar.oqT;
                        if (((Integer) r4.get(i4)).intValue() == 0) {
                            this.qqn++;
                            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(aa.a(vlVar.wcB));
                            if (aoO != null) {
                                aoO.NC();
                                bf.a(aoO.field_username, null);
                                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(aoO.field_username, aoO);
                                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aoX(aoO.field_username);
                                this.qqo.add(aoO.field_username);
                            }
                        } else {
                            ab.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", r4.get(i4), aa.a(vlVar.wcB));
                        }
                    }
                    i3 = i4 + 1;
                }
                if (this.oqN <= 0) {
                    Iterator it = this.qqo.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        Iterator it2 = UnfamiliarContactDetailUI.this.hUW.iterator();
                        while (it2.hasNext()) {
                            if (((b) it2.next()).ehM.field_username.equals(str2)) {
                                it2.remove();
                            }
                        }
                    }
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.hUW);
                    UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127662);
                            if (d.this.qql != null) {
                                d.this.qql.fh(UnfamiliarContactDetailUI.this.qpR.size(), d.this.qqn);
                                UnfamiliarContactDetailUI.this.qpR.clear();
                            }
                            AppMethodBeat.o(127662);
                        }
                    });
                }
            }
            AppMethodBeat.o(127665);
        }
    }

    class b {
        ad ehM;
        String eoz;
        String qqd;

        public b(ad adVar) {
            this.ehM = adVar;
        }
    }

    public enum e {
        OVER_ONE_MIN,
        NORMAL;

        static {
            AppMethodBeat.o(127668);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public UnfamiliarContactDetailUI() {
        AppMethodBeat.i(127669);
        AppMethodBeat.o(127669);
    }

    static /* synthetic */ void c(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.i(127679);
        unfamiliarContactDetailUI.fE(z);
        AppMethodBeat.o(127679);
    }

    public final int getLayoutId() {
        return R.layout.as6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127670);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Rg().a(291, (com.tencent.mm.ai.f) this);
        this.qjN = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.qjO = getIntent().getBooleanExtra("half_year_not_response", false);
        this.qjP = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.qpV = new l(this.qjN, this.qjO, this.qjP, new h() {
            long start = System.currentTimeMillis();

            {
                AppMethodBeat.i(127648);
                AppMethodBeat.o(127648);
            }

            public final void onSuccess() {
                AppMethodBeat.i(127649);
                ab.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", Integer.valueOf(UnfamiliarContactDetailUI.this.hUW.size()), Long.valueOf(System.currentTimeMillis() - this.start));
                UnfamiliarContactDetailUI.this.qpH.setText(UnfamiliarContactDetailUI.this.getString(R.string.eyf) + "(" + UnfamiliarContactDetailUI.this.hUW.size() + ")");
                if (UnfamiliarContactDetailUI.this.hUW.size() == 0) {
                    UnfamiliarContactDetailUI.this.findViewById(R.id.eat).setVisibility(0);
                    UnfamiliarContactDetailUI.this.findViewById(R.id.oa).setVisibility(8);
                    UnfamiliarContactDetailUI.this.findViewById(R.id.a_a).setVisibility(8);
                    UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(R.string.cn1));
                    AppMethodBeat.o(127649);
                    return;
                }
                UnfamiliarContactDetailUI.this.findViewById(R.id.eat).setVisibility(8);
                UnfamiliarContactDetailUI.this.findViewById(R.id.a_a).setVisibility(0);
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                }
                AppMethodBeat.o(127649);
            }

            public final void onError() {
                AppMethodBeat.i(127650);
                ab.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                UnfamiliarContactDetailUI.this.findViewById(R.id.eat).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.id.oa).setVisibility(8);
                UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(R.string.eyl));
                AppMethodBeat.o(127650);
            }

            public final void a(e eVar) {
                AppMethodBeat.i(127651);
                ab.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", eVar.name());
                UnfamiliarContactDetailUI.this.findViewById(R.id.eat).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.id.oa).setVisibility(0);
                if (eVar == e.NORMAL) {
                    UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(R.string.cn5));
                    AppMethodBeat.o(127651);
                    return;
                }
                if (eVar == e.OVER_ONE_MIN) {
                    UnfamiliarContactDetailUI.this.qpM.setText(UnfamiliarContactDetailUI.this.getString(R.string.eym));
                }
                AppMethodBeat.o(127651);
            }

            public final void e(HashSet hashSet) {
                AppMethodBeat.i(127652);
                String str = "MicroMsg.UnfamiliarContactUI";
                String str2 = "[onResult] size:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                ab.i(str, str2, objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, hashSet);
                }
                AppMethodBeat.o(127652);
            }
        });
        l lVar = this.qpV;
        lVar.qjX = System.currentTimeMillis();
        lVar.qjW.a(e.NORMAL);
        lVar.eKj.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126865);
                l lVar = l.this;
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                bd XM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM();
                String str = "@all.contact.without.chatroom";
                ArrayList arrayList = new ArrayList();
                arrayList.add("tmessage");
                arrayList.add("officialaccounts");
                arrayList.add("filehelper");
                arrayList.add("helper_entry");
                arrayList.add(r.Yz());
                bq RA = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XU().RA("@t.qq.com");
                if (RA != null) {
                    arrayList.add(RA.name);
                }
                arrayList.add("blogapp");
                Cursor a = XM.a(str, null, arrayList, null, false, false);
                if (a != null) {
                    a.moveToFirst();
                    while (!a.isAfterLast()) {
                        ad adVar = new ad();
                        adVar.d(a);
                        linkedList.add(adVar.field_username);
                        a.moveToNext();
                    }
                    a.close();
                }
                ab.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size()));
                l.a(lVar, linkedList);
                AppMethodBeat.o(126865);
            }
        });
        AppMethodBeat.o(127670);
    }

    public void onResume() {
        AppMethodBeat.i(127671);
        super.onResume();
        if (-1 != this.qpT) {
            Object obj;
            if (-1 == this.qpT) {
                obj = null;
            } else {
                b bVar = (b) this.hUW.get(this.qpT);
                ad adVar = bVar.ehM;
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(adVar.field_username);
                if (com.tencent.mm.n.a.jh(aoO.field_type) || !com.tencent.mm.n.a.jh(adVar.field_type)) {
                    bVar.ehM = aoO;
                    obj = null;
                } else {
                    this.hUW.remove(this.qpT);
                    obj = 1;
                }
            }
            if (obj != null) {
                f.qqv++;
            }
            this.qpT = -1;
        }
        this.qpU.clear();
        if (this.qpN != null) {
            this.qpN.aop.notifyChanged();
        }
        AppMethodBeat.o(127671);
    }

    public void onDestroy() {
        AppMethodBeat.i(127672);
        super.onDestroy();
        int i = (this.qjO ? 4 : 0) | ((this.qjP ? 2 : 0) | (this.qjN ? 1 : 0));
        com.tencent.mm.plugin.report.service.h.pYm.e(14434, Integer.valueOf(i), Integer.valueOf(f.qqv), Integer.valueOf(f.qqu), Integer.valueOf(f.qqz), Integer.valueOf(f.qqw), Integer.valueOf(f.qqy), Integer.valueOf(f.qqx));
        ab.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", Integer.valueOf(i), Integer.valueOf(f.qqv), Integer.valueOf(f.qqu), Integer.valueOf(f.qqz), Integer.valueOf(f.qqw), Integer.valueOf(f.qqy), Integer.valueOf(f.qqx));
        f.qqu = 0;
        f.qqv = 0;
        f.qqw = 0;
        f.qqx = 0;
        f.qqy = 0;
        f.qqz = 0;
        com.tencent.mm.kernel.g.Rg().b(291, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(681, this.qpS);
        l lVar = this.qpV;
        ab.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", Boolean.valueOf(lVar.qjO), Boolean.valueOf(lVar.qjN), Boolean.valueOf(lVar.qjP));
        if (lVar.qjV != null) {
            com.tencent.mm.kernel.g.Rg().b(292, lVar.qjV);
        }
        com.tencent.mm.sdk.g.d.xDG.remove(lVar.mRunnable);
        lVar.eKj.oAl.quit();
        AppMethodBeat.o(127672);
    }

    public final void initView() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(127673);
        super.initView();
        setMMTitle((int) R.string.ecg);
        addTextOptionMenu(1, getString(R.string.eyh), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127632);
                UnfamiliarContactDetailUI.this.qpW = !UnfamiliarContactDetailUI.this.qpW;
                UnfamiliarContactDetailUI.this.qpR.clear();
                UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qpW);
                if (UnfamiliarContactDetailUI.this.qpW) {
                    UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
                    UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.string.eyb));
                } else {
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.string.eyh));
                }
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                }
                AppMethodBeat.o(127632);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127637);
                UnfamiliarContactDetailUI.this.finish();
                AppMethodBeat.o(127637);
                return true;
            }
        });
        findViewById(R.id.eaq).setVisibility(this.qjN ? 0 : 8);
        View findViewById = findViewById(R.id.ear);
        if (this.qjP) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(R.id.eas);
        if (!this.qjO) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.qpG = (RecyclerView) findViewById(R.id.eau);
        this.qpI = findViewById(R.id.bi7);
        this.qpH = (TextView) findViewById(R.id.eap);
        this.qpS = new d(this.qpR, new g() {
            public final void fh(int i, int i2) {
                AppMethodBeat.i(127638);
                f.qqu += i;
                UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
                UnfamiliarContactDetailUI.this.qpH.setText(UnfamiliarContactDetailUI.this.getString(R.string.eyf) + "(" + UnfamiliarContactDetailUI.this.hUW.size() + ")");
                if (UnfamiliarContactDetailUI.this.qpN != null) {
                    UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                }
                if (i2 < i) {
                    ab.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", Integer.valueOf(i2), Integer.valueOf(i));
                    com.tencent.mm.ui.base.h.b(UnfamiliarContactDetailUI.this.mController.ylL, UnfamiliarContactDetailUI.this.getString(R.string.eyc, new Object[]{Integer.valueOf(i - i2)}), "", true);
                }
                AppMethodBeat.o(127638);
            }

            public final void cjq() {
                AppMethodBeat.i(127639);
                UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, true);
                AppMethodBeat.o(127639);
            }
        });
        this.qpJ = findViewById(R.id.eay);
        this.qpJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127641);
                com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.mController.ylL, true, UnfamiliarContactDetailUI.this.mController.ylL.getString(R.string.eyk), UnfamiliarContactDetailUI.this.mController.ylL.getString(R.string.avj), UnfamiliarContactDetailUI.this.mController.ylL.getString(R.string.p4), UnfamiliarContactDetailUI.this.mController.ylL.getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127640);
                        if (UnfamiliarContactDetailUI.this.qpS != null) {
                            com.tencent.mm.kernel.g.RQ();
                            com.tencent.mm.kernel.g.RO().eJo.a(681, UnfamiliarContactDetailUI.this.qpS);
                            Runnable h = UnfamiliarContactDetailUI.this.qpS;
                            h.index = 0;
                            h.oqN = 0;
                            h.qqn = 0;
                            h.qqo.clear();
                            h.qqp.clear();
                            com.tencent.mm.sdk.g.d.xDG.remove(h);
                            if (h.qql != null) {
                                h.qql.cjq();
                            }
                            com.tencent.mm.sdk.g.d.post(h, "delete_contact_task");
                        }
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                        AppMethodBeat.o(127640);
                    }
                }, null, R.color.ei, 0);
                AppMethodBeat.o(127641);
            }
        });
        this.qpK = findViewById(R.id.eax);
        this.qpK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127644);
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(UnfamiliarContactDetailUI.this, 1, false);
                dVar.rBl = new com.tencent.mm.ui.base.n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        AppMethodBeat.i(127642);
                        lVar.a(0, UnfamiliarContactDetailUI.this.getString(R.string.d7u), UnfamiliarContactDetailUI.this.getString(R.string.e4_), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.raw.circle_notreceive), false);
                        lVar.a(1, UnfamiliarContactDetailUI.this.getString(R.string.d7v), UnfamiliarContactDetailUI.this.getString(R.string.e4_), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.raw.circle_notvisible), false);
                        AppMethodBeat.o(127642);
                    }
                };
                dVar.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(127643);
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RO().eJo.b(681, UnfamiliarContactDetailUI.this.qpS);
                        UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qpR, i);
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                        if (UnfamiliarContactDetailUI.this.qpN != null) {
                            UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                        }
                        AppMethodBeat.o(127643);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(127644);
            }
        });
        this.qpL = findViewById(R.id.eaw);
        this.qpL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(127646);
                CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.this.qpL.findViewById(R.id.js);
                if (checkBox.isChecked()) {
                    z = false;
                } else {
                    z = true;
                }
                checkBox.setChecked(z);
                if (checkBox.isChecked()) {
                    for (int i = 0; i < UnfamiliarContactDetailUI.this.hUW.size(); i++) {
                        UnfamiliarContactDetailUI.this.qpR.add(Integer.valueOf(i));
                    }
                } else {
                    UnfamiliarContactDetailUI.this.qpR.clear();
                }
                if (UnfamiliarContactDetailUI.this.qpR.size() > 0) {
                    UnfamiliarContactDetailUI.this.qpK.setEnabled(true);
                    UnfamiliarContactDetailUI.this.qpJ.setEnabled(true);
                } else {
                    UnfamiliarContactDetailUI.this.qpK.setEnabled(false);
                    UnfamiliarContactDetailUI.this.qpJ.setEnabled(false);
                }
                UnfamiliarContactDetailUI.this.qpG.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127645);
                        UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                        AppMethodBeat.o(127645);
                    }
                });
                AppMethodBeat.o(127646);
            }
        });
        this.qpM = (TextView) findViewById(R.id.n0);
        this.qpG.setLayoutManager(new LinearLayoutManager());
        this.qpN = new a();
        this.qpG.setAdapter(this.qpN);
        this.qpO = (RealAlphabetScrollBar) findViewById(R.id.eav);
        this.qpO.setOnScrollBarTouchListener(new com.tencent.mm.ui.base.VerticalScrollBar.a() {
            public final void kp(String str) {
                int i;
                AppMethodBeat.i(127647);
                UnfamiliarContactDetailUI unfamiliarContactDetailUI = UnfamiliarContactDetailUI.this;
                if (unfamiliarContactDetailUI.qpP == null || !unfamiliarContactDetailUI.qpP.containsKey(str)) {
                    i = -1;
                } else {
                    i = ((Integer) unfamiliarContactDetailUI.qpP.get(str)).intValue();
                }
                ab.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", str, Integer.valueOf(i));
                if (i != -1) {
                    UnfamiliarContactDetailUI.this.qpG.bY(i);
                }
                AppMethodBeat.o(127647);
            }
        });
        AppMethodBeat.o(127673);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127674);
        if (i == 4) {
            onBackPressed();
            AppMethodBeat.o(127674);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127674);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127675);
        ab.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + mVar.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(R.string.eyj), 1).show();
        }
        if (mVar.getType() == 291) {
            fE(false);
            this.qpU.clear();
            this.qpN.aop.notifyChanged();
        }
        AppMethodBeat.o(127675);
    }

    private void da(List<b> list) {
        AppMethodBeat.i(127676);
        this.qpP.clear();
        this.qpQ.clear();
        int i = 0;
        String str = null;
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                if (emJ.equalsIgnoreCase(bVar.qqd)) {
                    bVar.qqd = "#";
                }
                str = bVar.qqd;
                if (!str.equalsIgnoreCase(str2)) {
                    this.qpP.put(str.toUpperCase(), Integer.valueOf(i));
                    this.qpQ.put(Integer.valueOf(i), str.toUpperCase());
                }
                i++;
            } else {
                AppMethodBeat.o(127676);
                return;
            }
        }
    }

    static {
        AppMethodBeat.i(127683);
        AppMethodBeat.o(127683);
    }

    private void fE(boolean z) {
        AppMethodBeat.i(127677);
        ab.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.ejZ = p.b(this, getString(R.string.eye), true, null);
            AppMethodBeat.o(127677);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(127677);
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        AppMethodBeat.i(127678);
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.anim.cg);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(127633);
                    UnfamiliarContactDetailUI.this.qpI.setVisibility(0);
                    AppMethodBeat.o(127633);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.qpI.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.anim.ce);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(127653);
                    UnfamiliarContactDetailUI.this.qpI.setVisibility(8);
                    AppMethodBeat.o(127653);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.qpI.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.qpW = z;
        if (unfamiliarContactDetailUI.qpW) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.string.eyb));
            AppMethodBeat.o(127678);
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.string.eyh));
        ((CheckBox) unfamiliarContactDetailUI.qpL.findViewById(R.id.js)).setChecked(false);
        AppMethodBeat.o(127678);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        AppMethodBeat.i(127680);
        unfamiliarContactDetailUI.fE(true);
        if (i == 0) {
            f.qqx += hashSet.size();
        } else if (i == 1) {
            f.qqw += hashSet.size();
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(127636);
                LinkedList linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b Cr = UnfamiliarContactDetailUI.this.qpN.Cr(((Integer) it.next()).intValue());
                    ab.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", Cr.ehM.field_username, Integer.valueOf(i));
                    ro roVar;
                    if (i == 0) {
                        roVar = new ro();
                        roVar.cNw.cNy = false;
                        roVar.cNw.cNx = true;
                        roVar.cNw.username = Cr.ehM.field_username;
                        com.tencent.mm.sdk.b.a.xxA.m(roVar);
                        linkedList.add(Cr.ehM.field_username);
                    } else if (i == 1) {
                        Cr.ehM.NQ();
                        roVar = new ro();
                        roVar.cNw.cNy = true;
                        roVar.cNw.cNx = false;
                        roVar.cNw.username = Cr.ehM.field_username;
                        com.tencent.mm.sdk.b.a.xxA.m(roVar);
                        t.k(Cr.ehM);
                    }
                }
                if (linkedList.size() > 0) {
                    mo moVar = new mo();
                    moVar.cIr.list = linkedList;
                    moVar.cIr.czE = 1;
                    moVar.cIr.cIs = 5;
                    com.tencent.mm.sdk.b.a.xxA.m(moVar);
                    AppMethodBeat.o(127636);
                    return;
                }
                UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127635);
                        UnfamiliarContactDetailUI.this.qpN.aop.notifyChanged();
                        UnfamiliarContactDetailUI.c(UnfamiliarContactDetailUI.this, false);
                        AppMethodBeat.o(127635);
                    }
                });
                AppMethodBeat.o(127636);
            }
        }, "handleSnsSetting");
        AppMethodBeat.o(127680);
    }
}
