package com.tencent.p177mm.p612ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p230g.p231a.C37795ru;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C40862f.C30702a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.AlphabetScrollBar;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.contact.C15824a.C15828a;
import com.tencent.p177mm.p612ui.contact.C30662b.C30661a;
import com.tencent.p177mm.p612ui.contact.C46675u.C23926a;
import com.tencent.p177mm.p612ui.contact.C46675u.C30668b;
import com.tencent.p177mm.p612ui.contact.C5451i.C5453a;
import com.tencent.p177mm.p612ui.voicesearch.C46939b;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C40629f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.AddressUI */
public class AddressUI extends FragmentActivity {
    public MMFragment zjY;

    /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment */
    public static class AddressUIFragment extends AbStractTabFragment implements C1202f {
        private final long TIME_INTERVAL = 180000;
        private ProgressDialog ehJ = null;
        C14943d ein = new C14943d(new C1576410());
        List<String> elZ = new LinkedList();
        private TextView gtY;
        private boolean gxV = false;
        private int jLX;
        private int jLY;
        private C24088a jMO;
        private C5279d lCi = new C157788();
        private Animation lVH;
        private ListView nIv;
        private C4884c ryK = new C157841();
        private TextView zjZ;
        private String zjx;
        private String zjy;
        private TextView zka;
        private C15824a zkb;
        private C46939b zkc;
        private String zkd;
        private String zke = "";
        private int zkf;
        private AlphabetScrollBar zkg;
        private LinearLayout zkh = null;
        private boolean zki = false;
        private boolean zkj = false;
        private C5458k zkk;
        private BizContactEntranceView zkl;
        private C30662b zkm;
        private C30662b zkn;
        private C30662b zko;
        private ContactCountView zkp;
        private C46675u zkq;
        private C5451i zkr;
        boolean zks;
        private boolean zkt = true;
        private LinearLayout zku;
        private Animation zkv;
        private C30374a zkw = new C157829();
        List<String> zkx = new LinkedList();
        private Runnable zky = new C1576517();

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$11 */
        class C542711 implements Runnable {
            C542711() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33494);
                AddressUIFragment.this.zkb.dHy();
                if (AddressUIFragment.this.zkq != null) {
                    AddressUIFragment.this.zkq.reset();
                    if (AddressUIFragment.this.zkq.getOpenIMCount() <= 0) {
                        AddressUIFragment.this.zkq.setVisibility(8);
                        AppMethodBeat.m2505o(33494);
                        return;
                    }
                    AddressUIFragment.this.zkq.setVisibility(0);
                }
                AppMethodBeat.m2505o(33494);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$23 */
        class C542823 implements C23599f {
            C542823() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(33505);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.AddressUI", "onItemDel object null");
                    AppMethodBeat.m2505o(33505);
                    return;
                }
                AddressUIFragment.m24123a(AddressUIFragment.this, obj.toString());
                AppMethodBeat.m2505o(33505);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$10 */
        class C1576410 implements OnScrollListener {
            C1576410() {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.m2504i(33492);
                if (i < 2) {
                    AppMethodBeat.m2505o(33492);
                    return;
                }
                if (!AddressUIFragment.this.zki) {
                    AddressUIFragment.this.zki = true;
                }
                AppMethodBeat.m2505o(33492);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.m2504i(33493);
                if (i == 2) {
                    C37634d.dvV().mo60468ev(AddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.m2505o(33493);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$17 */
        class C1576517 implements Runnable {
            C1576517() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33500);
                AddressUIFragment.m24142q(AddressUIFragment.this);
                AppMethodBeat.m2505o(33500);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$18 */
        class C1576618 implements Runnable {
            C1576618() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33501);
                AddressUIFragment.this.zkb.pause();
                AppMethodBeat.m2505o(33501);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$22 */
        class C1576722 implements C23600g {
            C1576722() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(33504);
                AddressUIFragment.this.nIv.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(33504);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$4 */
        class C157684 implements OnItemClickListener {
            C157684() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33486);
                C4990ab.m7416i("MicroMsg.AddressUI", "onItemClick " + i + (AddressUIFragment.this.zkc == null ? AddressUIFragment.this.zkc : Boolean.valueOf(AddressUIFragment.this.zkc.zLy)));
                if (i == 0 && !"@biz.contact".equals(AddressUIFragment.this.zjx)) {
                    AppMethodBeat.m2505o(33486);
                } else if (i < AddressUIFragment.this.nIv.getHeaderViewsCount()) {
                    AppMethodBeat.m2505o(33486);
                } else {
                    int headerViewsCount = i - AddressUIFragment.this.nIv.getHeaderViewsCount();
                    String str;
                    if (AddressUIFragment.this.zkc == null || !AddressUIFragment.this.zkc.zLy) {
                        C40629f c40629f = (C40629f) AddressUIFragment.this.zkb.getItem(headerViewsCount);
                        if (c40629f != null) {
                            str = c40629f.field_username;
                            AddressUIFragment addressUIFragment = AddressUIFragment.this;
                            if (str == null || str.length() <= 0) {
                                AppMethodBeat.m2505o(33486);
                                return;
                            } else if (C1855t.m3956ny(str)) {
                                C4990ab.m7413e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                AppMethodBeat.m2505o(33486);
                                return;
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("Contact_User", str);
                                if (C1855t.m3910mW(str)) {
                                    intent.putExtra("Is_group_card", true);
                                }
                                if (str != null && str.length() > 0) {
                                    C36249e.m59677a(intent, str);
                                    intent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                    C25985d.m41467b(addressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                }
                            }
                        }
                        AppMethodBeat.m2505o(33486);
                        return;
                    }
                    boolean wK = AddressUIFragment.this.zkc.mo10892wK(headerViewsCount);
                    boolean PQ = AddressUIFragment.this.zkc.mo76189PQ(headerViewsCount);
                    C4990ab.m7416i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(PQ)));
                    Intent intent2;
                    if (PQ) {
                        AddressUIFragment.this.zkc.asx("");
                        AppMethodBeat.m2505o(33486);
                    } else if (wK) {
                        but PO = AddressUIFragment.this.zkc.mo76187PO(headerViewsCount);
                        String str2 = PO.wcB.wVI;
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(str2);
                        if (C7486a.m12942jh(aoO.field_type)) {
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", str2);
                            intent2.putExtra("Contact_Scene", 3);
                            if (str2 != null && str2.length() > 0) {
                                if (aoO.dsf()) {
                                    C7060h.pYm.mo8374X(10298, str2 + ",3");
                                }
                                C36249e.m59677a(intent2, str2);
                                intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                C25985d.m41467b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                            }
                            AppMethodBeat.m2505o(33486);
                            return;
                        }
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", PO.wcB.wVI);
                        intent3.putExtra("Contact_Alias", PO.guS);
                        intent3.putExtra("Contact_Nick", PO.wyX.wVI);
                        intent3.putExtra("Contact_Signature", PO.guQ);
                        intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(PO.guW, PO.guO, PO.guP));
                        intent3.putExtra("Contact_Sex", PO.guN);
                        intent3.putExtra("Contact_VUser_Info", PO.wBU);
                        intent3.putExtra("Contact_VUser_Info_Flag", PO.wBT);
                        intent3.putExtra("Contact_KWeibo_flag", PO.wBX);
                        intent3.putExtra("Contact_KWeibo", PO.wBV);
                        intent3.putExtra("Contact_KWeiboNick", PO.wBW);
                        intent3.putExtra("Contact_KSnsIFlag", PO.wBZ.guY);
                        intent3.putExtra("Contact_KSnsBgId", PO.wBZ.gva);
                        intent3.putExtra("Contact_KSnsBgUrl", PO.wBZ.guZ);
                        if (PO.wCa != null) {
                            try {
                                intent3.putExtra("Contact_customInfo", PO.wCa.toByteArray());
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                            }
                        }
                        if ((PO.wBT & 8) > 0) {
                            C7060h.pYm.mo8374X(10298, str2 + ",3");
                        }
                        intent3.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                        C25985d.m41467b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                        AppMethodBeat.m2505o(33486);
                    } else {
                        C7616ad PP = AddressUIFragment.this.zkc.mo76188PP(headerViewsCount);
                        if (PP == null) {
                            C4990ab.m7413e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(AddressUIFragment.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                            AppMethodBeat.m2505o(33486);
                            return;
                        }
                        str = PP.field_username;
                        if (C1855t.m3956ny(str)) {
                            Intent intent4 = new Intent(AddressUIFragment.this.getContext(), AddressUI.class);
                            intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                            AddressUIFragment.this.startActivity(intent4);
                            AppMethodBeat.m2505o(33486);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Contact_Scene", 3);
                        intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                        if (str != null && str.length() > 0) {
                            C25985d.m41467b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        AppMethodBeat.m2505o(33486);
                    }
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$6 */
        class C157696 implements OnTouchListener {
            C157696() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(33488);
                switch (motionEvent.getAction()) {
                    case 0:
                        AddressUIFragment.this.hideVKB();
                        AddressUIFragment.this.jLX = (int) motionEvent.getRawX();
                        AddressUIFragment.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.m2505o(33488);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$7 */
        class C157707 implements Runnable {
            C157707() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33489);
                AddressUIFragment.this.nIv.setSelection(0);
                AppMethodBeat.m2505o(33489);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$21 */
        class C1577121 implements C15521c {
            C1577121() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(33503);
                View view2 = view;
                while (true) {
                    try {
                        View view3 = (View) view2.getParent();
                        if (view3 != null && !view3.equals(AddressUIFragment.this.nIv)) {
                            view2 = view3;
                        }
                    } catch (ClassCastException e) {
                        AppMethodBeat.m2505o(33503);
                        return -1;
                    }
                }
                if (view2.getParent() == null) {
                    AppMethodBeat.m2505o(33503);
                    return -1;
                }
                int positionForView = AddressUIFragment.this.nIv.getPositionForView(view);
                AppMethodBeat.m2505o(33503);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$24 */
        class C1577224 implements C30668b {
            C1577224() {
            }

            /* renamed from: qB */
            public final void mo27987qB(boolean z) {
                AppMethodBeat.m2504i(33506);
                if (AddressUIFragment.this.zkl == null) {
                    AppMethodBeat.m2505o(33506);
                    return;
                }
                BizContactEntranceView d = AddressUIFragment.this.zkl;
                if (d.zld == null) {
                    AppMethodBeat.m2505o(33506);
                } else if (z) {
                    d.zld.setBackgroundResource(C25738R.drawable.a_q);
                    AppMethodBeat.m2505o(33506);
                } else {
                    d.zld.setBackground(null);
                    AppMethodBeat.m2505o(33506);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$16 */
        class C1577316 implements Runnable {
            C1577316() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33499);
                AddressUIFragment.this.zkb.resume();
                AppMethodBeat.m2505o(33499);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$19 */
        class C1577419 implements OnClickListener {
            C1577419() {
            }

            public final void onClick(View view) {
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$25 */
        class C1577525 implements C23926a {
            C1577525() {
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$5 */
        class C157765 implements OnItemLongClickListener {
            C157765() {
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33487);
                C4990ab.m7416i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
                if (i < AddressUIFragment.this.nIv.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.AddressUI", "on item long click, but match header view");
                    AppMethodBeat.m2505o(33487);
                    return true;
                } else if (AddressUIFragment.this.zkc == null || !AddressUIFragment.this.zkc.zLy) {
                    C40629f c40629f = (C40629f) AddressUIFragment.this.zkb.getItem(i - AddressUIFragment.this.nIv.getHeaderViewsCount());
                    if (c40629f == null) {
                        C4990ab.m7413e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(AddressUIFragment.this.nIv.getHeaderViewsCount()));
                        AppMethodBeat.m2505o(33487);
                        return true;
                    }
                    String str = c40629f.field_username;
                    if (C1855t.m3956ny(str) || C1855t.m3957nz(str)) {
                        AppMethodBeat.m2505o(33487);
                        return true;
                    }
                    AddressUIFragment.this.zke = str;
                    AddressUIFragment.this.jMO.mo39885a(view, i, j, AddressUIFragment.this, AddressUIFragment.this.lCi, AddressUIFragment.this.jLX, AddressUIFragment.this.jLY);
                    AppMethodBeat.m2505o(33487);
                    return true;
                } else {
                    AppMethodBeat.m2505o(33487);
                    return true;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$8 */
        class C157788 implements C5279d {
            C157788() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(33490);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        AddressUIFragment.m24123a(AddressUIFragment.this, AddressUIFragment.this.zke);
                        AppMethodBeat.m2505o(33490);
                        return;
                    case 7:
                        AddressUIFragment.m24128c(AddressUIFragment.this, AddressUIFragment.this.zke);
                        AppMethodBeat.m2505o(33490);
                        return;
                    default:
                        AppMethodBeat.m2505o(33490);
                        return;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$13 */
        class C1577913 implements Runnable {
            C1577913() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33496);
                C4990ab.m7418v("MicroMsg.AddressUI", "post search adapter to do refresh");
                AddressUIFragment.this.zkc.mo5248a(null, null);
                AppMethodBeat.m2505o(33496);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$15 */
        class C1578015 implements Runnable {
            C1578015() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33498);
                Process.setThreadPriority(10);
                AddressUIFragment.m24141p(AddressUIFragment.this);
                AppMethodBeat.m2505o(33498);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$2 */
        class C157812 implements C5453a {
            C157812() {
            }

            /* renamed from: Pl */
            public final void mo11094Pl(int i) {
                AppMethodBeat.m2504i(33485);
                if (AddressUIFragment.this.zkr == null) {
                    AppMethodBeat.m2505o(33485);
                } else if (i <= 0) {
                    AddressUIFragment.this.zkr.setVisibility(8);
                    AppMethodBeat.m2505o(33485);
                } else {
                    AddressUIFragment.this.zkr.setVisibility(0);
                    AppMethodBeat.m2505o(33485);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$9 */
        class C157829 implements C30374a {
            C157829() {
            }

            /* renamed from: kp */
            public final void mo17482kp(String str) {
                int i = 0;
                AppMethodBeat.m2504i(33491);
                if (AddressUIFragment.this.getString(C25738R.string.dz6).equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(0);
                    AppMethodBeat.m2505o(33491);
                    return;
                }
                C15824a a = AddressUIFragment.this.zkb;
                C4990ab.m7418v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = a.zjD;
                if (strArr == null) {
                    AppMethodBeat.m2505o(33491);
                } else if ("↑".equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(0);
                    AppMethodBeat.m2505o(33491);
                } else if ("☆".equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(AddressUIFragment.this.nIv.getHeaderViewsCount());
                    AppMethodBeat.m2505o(33491);
                } else {
                    while (i < strArr.length && strArr[i] != null) {
                        if (strArr[i].equals(str)) {
                            AddressUIFragment.this.nIv.setSelection(AddressUIFragment.this.zkb.getPositionForSection(i) + AddressUIFragment.this.nIv.getHeaderViewsCount());
                            AppMethodBeat.m2505o(33491);
                            return;
                        }
                        i++;
                    }
                    AppMethodBeat.m2505o(33491);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$14 */
        class C1578314 implements Runnable {
            C1578314() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33497);
                C4990ab.m7416i("MicroMsg.AddressUI", "post to first init finish");
                View findViewById = AddressUIFragment.this.findViewById(2131828206);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(AddressUIFragment.this.getContext(), C25738R.anim.f8333b6));
                }
                AppMethodBeat.m2505o(33497);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$1 */
        class C157841 extends C4884c<C37795ru> {
            C157841() {
                AppMethodBeat.m2504i(33483);
                this.xxI = C37795ru.class.getName().hashCode();
                AppMethodBeat.m2505o(33483);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(33484);
                C37795ru c37795ru = (C37795ru) c4883b;
                if (AddressUIFragment.this.getContext() == null || AddressUIFragment.this.getContext().isFinishing()) {
                    AppMethodBeat.m2505o(33484);
                } else {
                    if (!(c37795ru.cNM.cNN || AddressUIFragment.this.zkb == null)) {
                        ((C35168e) C1720g.m3530M(C35168e.class)).getFavourUserChecker().cwS();
                        AddressUIFragment.this.zkb.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(33484);
                }
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$20 */
        class C1578520 implements C30702a {
            C1578520() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(33502);
                AddressUIFragment addressUIFragment = AddressUIFragment.this;
                AddressUIFragment.this.zkb.getCount();
                AddressUIFragment.m24126b(addressUIFragment);
                AddressUIFragment.this.zkb.dHw();
                AppMethodBeat.m2505o(33502);
            }

            public final void dwH() {
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.AddressUI$AddressUIFragment$3 */
        class C157863 implements C15828a {
            C157863() {
            }
        }

        public AddressUIFragment() {
            AppMethodBeat.m2504i(33507);
            AppMethodBeat.m2505o(33507);
        }

        /* renamed from: p */
        static /* synthetic */ void m24141p(AddressUIFragment addressUIFragment) {
            AppMethodBeat.m2504i(33528);
            addressUIFragment.dHA();
            AppMethodBeat.m2505o(33528);
        }

        public int getLayoutId() {
            return 2130968638;
        }

        public View getLayoutView() {
            AppMethodBeat.m2504i(33508);
            View a = C1742b.m3596SM().mo5274a(getContext(), "R.layout.address", 2130968638);
            AppMethodBeat.m2505o(33508);
            return a;
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.m2504i(33509);
            super.onCreate(bundle);
            C4879a.xxA.mo10052c(this.ryK);
            AppMethodBeat.m2505o(33509);
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }

        public boolean noActionBar() {
            return true;
        }

        /* renamed from: qA */
        public final void mo27986qA(boolean z) {
            AppMethodBeat.m2504i(33510);
            if (this.zkg != null) {
                if (this.lVH == null) {
                    this.lVH = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8326ax);
                    this.lVH.setDuration(200);
                }
                if (this.zkv == null) {
                    this.zkv = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8326ax);
                    this.zkv.setDuration(200);
                }
                if (z) {
                    if (this.zkg.getVisibility() != 0) {
                        this.zkg.setVisibility(0);
                        this.zkg.startAnimation(this.lVH);
                        AppMethodBeat.m2505o(33510);
                        return;
                    }
                } else if (4 != this.zkg.getVisibility()) {
                    this.zkg.setVisibility(8);
                    this.zkg.startAnimation(this.zkv);
                }
            }
            AppMethodBeat.m2505o(33510);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(33511);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.zke);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.zke);
                AppMethodBeat.m2505o(33511);
            } else if (C1853r.m3846Yz().equals(aoO.field_username)) {
                AppMethodBeat.m2505o(33511);
            } else if (C1855t.m3910mW(this.zke)) {
                contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), aoO.mo16707Oj()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.f8745dt);
                AppMethodBeat.m2505o(33511);
            } else if (C1855t.m3943nl(this.zke) || C1855t.m3916nB(this.zke)) {
                AppMethodBeat.m2505o(33511);
            } else {
                contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), aoO.mo16707Oj()));
                if (C7486a.m12942jh(aoO.field_type) && aoO.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, C25738R.string.axw);
                }
                AppMethodBeat.m2505o(33511);
            }
        }

        public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(33512);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (!C42252ah.m74615cv(getContext())) {
                AppMethodBeat.m2505o(33512);
            } else if (C30784a.m49123a(getContext(), i, i2, str, 4)) {
                AppMethodBeat.m2505o(33512);
            } else if (i == 0 && i2 == 0) {
                AppMethodBeat.m2505o(33512);
            } else {
                AppMethodBeat.m2505o(33512);
            }
        }

        private void dHz() {
            AppMethodBeat.m2504i(33513);
            this.elZ = new LinkedList();
            this.zkx = new LinkedList();
            C25985d.dlL();
            this.elZ.add("tmessage");
            this.zkx.addAll(this.elZ);
            if (!this.elZ.contains("officialaccounts")) {
                this.elZ.add("officialaccounts");
            }
            this.elZ.add("helper_entry");
            if (this.zkb != null) {
                this.zkb.mo28044fl(this.elZ);
            }
            if (this.zkc != null) {
                this.zkc.mo76194fl(this.zkx);
            }
            AppMethodBeat.m2505o(33513);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(33514);
            C4990ab.m7417i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.m2505o(33514);
            } else if (i2 != -1) {
                AppMethodBeat.m2505o(33514);
            } else {
                switch (i) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.m2505o(33514);
            }
        }

        public final void dvY() {
            AppMethodBeat.m2504i(33515);
            C4990ab.m7418v("MicroMsg.AddressUI", "address ui on create");
            C4990ab.m7418v("MicroMsg.AddressUI", "on address ui create");
            this.zki = false;
            this.gxV = false;
            this.zkj = false;
            this.zjx = null;
            this.zjy = null;
            this.zkd = null;
            C9638aw.m17182Rg().mo14539a(138, (C1202f) this);
            this.zjx = "@all.contact.without.chatroom.without.openim";
            this.zjy = getStringExtra("Contact_GroupFilter_Str");
            this.zkd = getString(C25738R.string.c_4);
            this.zkf = getIntExtra("List_Type", 2);
            final View findViewById = getView().getRootView().findViewById(2131820634);
            int de = C5230ak.m7987de(getContext());
            int J = C5230ak.m7984J(getContext(), -1);
            C1577712 c1577712 = new Runnable() {
                int eRu = 0;

                public final void run() {
                    AppMethodBeat.m2504i(33495);
                    if (AddressUIFragment.this.getView() == null) {
                        AppMethodBeat.m2505o(33495);
                        return;
                    }
                    int de = C5230ak.m7987de(AddressUIFragment.this.getContext());
                    int J = C5230ak.m7984J(AddressUIFragment.this.getContext(), -1);
                    if (J <= 0) {
                        if (this.eRu < 2) {
                            C4990ab.m7416i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
                            AddressUIFragment.this.getView().post(this);
                        } else {
                            C4990ab.m7412e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                        }
                        this.eRu++;
                    } else {
                        int i = de + J;
                        if (i != AddressUIFragment.this.getView().getPaddingTop()) {
                            C4990ab.m7417i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(i), Integer.valueOf(AddressUIFragment.this.getView().getPaddingTop()));
                            AddressUIFragment.this.getView().setPadding(0, i, 0, findViewById.getHeight());
                        } else {
                            C4990ab.m7417i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                        }
                    }
                    C4990ab.m7417i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J), Integer.valueOf(de));
                    AppMethodBeat.m2505o(33495);
                }
            };
            if (J <= 0) {
                getView().post(c1577712);
            } else {
                getView().setPadding(0, de + J, 0, findViewById.getHeight());
                C4990ab.m7417i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                getView().postDelayed(c1577712, 100);
            }
            C4990ab.m7419v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            if (this.nIv != null) {
                if (this.zkk != null) {
                    this.nIv.removeHeaderView(this.zkk);
                }
                if (this.zkl != null) {
                    this.nIv.removeHeaderView(this.zkl);
                }
                if (this.zkm != null) {
                    this.nIv.removeHeaderView(this.zkm);
                }
                if (this.zko != null) {
                    this.nIv.removeHeaderView(this.zko);
                }
            }
            this.nIv = (ListView) findViewById(2131821054);
            this.nIv.setScrollingCacheEnabled(false);
            this.zjZ = (TextView) findViewById(2131821056);
            this.zjZ.setText(C25738R.string.f8748dw);
            this.gtY = (TextView) findViewById(2131821055);
            this.gtY.setText(C25738R.string.f8750dy);
            this.zka = (TextView) findViewById(2131821058);
            this.zka.setOnClickListener(new C1577419());
            this.zkb = new C15824a(getContext(), this.zjx, this.zjy, this.zkf);
            this.nIv.setAdapter(null);
            this.zkb.mo64391a((C30702a) new C1578520());
            this.zkb.zjK = true;
            this.zkb.setFragment(this);
            this.zkb.setGetViewPositionCallback(new C1577121());
            this.zkb.setPerformItemClickListener(new C1576722());
            this.zkb.mo28032a(new C542823());
            this.zkc = new C46939b(getContext(), 1);
            this.zkc.mo76203qV(true);
            this.zku = new LinearLayout(getContext());
            this.zku.setOrientation(1);
            this.nIv.addHeaderView(this.zku);
            this.zkn = new C30662b(getContext(), C30661a.ContactIpCall);
            this.zku.addView(this.zkn);
            C9638aw.m17190ZK();
            ((Boolean) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
            this.zkn.setVisible(false);
            this.zkk = new C5458k(getContext());
            this.zku.addView(this.zkk);
            this.zkm = new C30662b(getContext(), C30661a.Chatromm);
            this.zku.addView(this.zkm);
            this.zkm.setVisible(true);
            this.zko = new C30662b(getContext(), C30661a.ContactLabel);
            this.zku.addView(this.zko);
            this.zko.setVisible(true);
            ListView listView = this.nIv;
            ContactCountView contactCountView = new ContactCountView(getContext());
            this.zkp = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            if (C25985d.afj("brandservice")) {
                this.zkl = new BizContactEntranceView(getContext());
                this.zku.addView(this.zkl);
                this.zkl.setVisible(true);
            }
            C1577224 c1577224 = new C1577224();
            this.zkq = new C46675u(getContext(), new C1577525());
            this.zkq.setOnVisibilityChangeListener(c1577224);
            if (this.zkq.getOpenIMCount() <= 0) {
                c1577224.mo27987qB(false);
                this.zkq.setVisibility(8);
            } else {
                c1577224.mo27987qB(true);
            }
            this.zku.addView(this.zkq);
            if (C25985d.afj("brandservice")) {
                this.zkr = new C5451i(getContext(), new C157812());
                if (this.zkr.getEnterpriseFriendCount() <= 0) {
                    this.zkr.setVisibility(8);
                }
                this.zku.addView(this.zkr);
            }
            this.jMO = new C24088a(getContext());
            this.zkb.zjI = new C157863();
            this.nIv.setOnItemClickListener(new C157684());
            this.nIv.setOnItemLongClickListener(new C157765());
            this.nIv.setOnTouchListener(new C157696());
            this.nIv.setOnScrollListener(this.ein);
            this.nIv.setDrawingCacheEnabled(false);
            this.zkg = (AlphabetScrollBar) findViewById(2131821057);
            this.zkg.setOnScrollBarTouchListener(this.zkw);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10118a(this.zkb);
            if (this.zkr != null) {
                C41747z.aeR().mo43722a(this.zkr, null);
            }
            AppMethodBeat.m2505o(33515);
        }

        public final void dvZ() {
            AppMethodBeat.m2504i(33516);
            C4990ab.m7418v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            C9638aw.m17190ZK();
            if (currentTimeMillis - C42252ah.m74617d((Long) C18628c.m29072Ry().get(340226, null)) >= 180000) {
                dHB();
            }
            if (this.zkt) {
                this.zkt = false;
                this.zks = false;
                dHz();
                this.nIv.setAdapter(this.zkb);
                this.nIv.post(new C1578314());
                this.zkc.mo76202qU(false);
            } else if (this.zks) {
                this.zks = false;
                C7305d.m12298f(new C1578015(), "AddressUI_updateUIData");
                this.zkp.dHF();
            }
            if (this.zkl != null) {
                BizContactEntranceView bizContactEntranceView = this.zkl;
                bizContactEntranceView.dHC();
                bizContactEntranceView.setVisible(true);
            }
            if (this.zkr != null) {
                if (this.zkr.getEnterpriseFriendCount() <= 0) {
                    this.zkr.setVisibility(8);
                } else {
                    this.zkr.setVisibility(0);
                }
            }
            C9638aw.m17190ZK();
            this.zki = ((Boolean) C18628c.m29072Ry().get(12296, Boolean.FALSE)).booleanValue();
            if (this.zkf == 2) {
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(C1853r.m3846Yz());
                if (!(aoO == null || (C7486a.m12942jh(aoO.field_type) && C42252ah.isNullOrNil(aoO.field_conRemark) && C42252ah.isNullOrNil(aoO.field_conRemarkPYFull) && C42252ah.isNullOrNil(aoO.field_conRemarkPYShort)))) {
                    aoO.mo16676NB();
                    aoO.mo14729iz("");
                    aoO.mo14707iF("");
                    aoO.mo14708iG("");
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(C1853r.m3846Yz(), aoO);
                }
            }
            if (this.zkc != null) {
                this.zkc.onResume();
            }
            this.zkb.ygw = false;
            C5004al.m7441d(new C1577316());
            if (this.zkk != null) {
                this.zkk.setFrontGround(true);
                C5458k.dHR();
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().setTitleBarDoubleClickListener(this.zky);
            }
            AppMethodBeat.m2505o(33516);
        }

        private synchronized void dHA() {
            AppMethodBeat.m2504i(33517);
            long currentTimeMillis = System.currentTimeMillis();
            dHz();
            C4990ab.m7416i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.zkb != null) {
                C4990ab.m7418v("MicroMsg.AddressUI", "post to do refresh");
                C5004al.m7441d(new C542711());
            }
            if (this.zkc != null) {
                C5004al.m7441d(new C1577913());
            }
            C4990ab.m7416i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(33517);
        }

        public final void dwa() {
        }

        public final void dwb() {
            AppMethodBeat.m2504i(33518);
            C4990ab.m7416i("MicroMsg.AddressUI", "AddressUI on Pause");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(340226, Long.valueOf(System.currentTimeMillis()));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(12296, Boolean.valueOf(this.zki));
            if (this.zkc != null) {
                this.zkc.onPause();
            }
            this.zkb.dHx();
            C5004al.m7441d(new C1576618());
            if (this.zkk != null) {
                this.zkk.setFrontGround(false);
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().mo69881aw(this.zky);
            }
            AppMethodBeat.m2505o(33518);
        }

        public final void dwc() {
        }

        public final void dwd() {
            AppMethodBeat.m2504i(33519);
            C4990ab.m7418v("MicroMsg.AddressUI", "onDestory");
            if (this.zkg != null) {
                this.zkg.yAU = null;
            }
            C9638aw.m17182Rg().mo14546b(138, (C1202f) this);
            if (this.zkb != null) {
                this.zkb.mo64400pB(true);
                this.zkb.detach();
                this.zkb.dww();
            }
            if (this.zkc != null) {
                this.zkc.detach();
                this.zkc.bIf();
            }
            if (C9638aw.m17179RK() && this.zkb != null) {
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo10121b(this.zkb);
            }
            if (C9638aw.m17179RK() && this.zkr != null) {
                C41747z.aeR().mo43721a(this.zkr);
            }
            if (this.zkk != null) {
                C5458k c5458k = this.zkk;
                if (C9638aw.m17179RK()) {
                    C41789d.akP().mo10117d(c5458k.zmz);
                }
                this.zkk = null;
            }
            if (this.zkl != null) {
                this.zkl = null;
            }
            if (this.zkm != null) {
                this.zkm = null;
            }
            if (this.zko != null) {
                this.zko = null;
            }
            C4879a.xxA.mo10053d(this.ryK);
            AppMethodBeat.m2505o(33519);
        }

        public final void dwf() {
            AppMethodBeat.m2504i(33520);
            if (this.zkb != null) {
                C15824a c15824a = this.zkb;
                c15824a.zjO.clear();
                c15824a.zjM.clear();
                c15824a.zjN = false;
            }
            C4990ab.m7416i("MicroMsg.INIT", "KEVIN Address turnTobg");
            if (this.zkl != null) {
                this.zkl.destroyDrawingCache();
            }
            if (this.zkm != null) {
                this.zkm.destroyDrawingCache();
            }
            if (this.zko != null) {
                this.zko.destroyDrawingCache();
            }
            if (this.zkp != null) {
                this.zkp.destroyDrawingCache();
            }
            if (this.zkk != null) {
                this.zkk.destroyDrawingCache();
            }
            AppMethodBeat.m2505o(33520);
        }

        public final void dwg() {
            AppMethodBeat.m2504i(33521);
            C4990ab.m7418v("MicroMsg.INIT", "KEVIN Address turnTofg");
            AppMethodBeat.m2505o(33521);
        }

        public final void dwe() {
            AppMethodBeat.m2504i(33522);
            C4990ab.m7418v("MicroMsg.AddressUI", "request to top");
            if (this.nIv != null) {
                C4978c.m7375a(this.nIv);
            }
            AppMethodBeat.m2505o(33522);
        }

        public final void dxc() {
            AppMethodBeat.m2504i(33523);
            if (this.zkk != null) {
                C5458k.dHR();
            }
            AppMethodBeat.m2505o(33523);
        }

        public final void dxd() {
        }

        public final void dHB() {
            AppMethodBeat.m2504i(33524);
            if (this.nIv != null) {
                this.nIv.setSelection(0);
            }
            AppMethodBeat.m2505o(33524);
        }

        /* renamed from: b */
        static /* synthetic */ void m24126b(AddressUIFragment addressUIFragment) {
            AppMethodBeat.m2504i(33525);
            addressUIFragment.zjZ.setVisibility(8);
            addressUIFragment.nIv.setVisibility(0);
            AppMethodBeat.m2505o(33525);
        }

        /* renamed from: c */
        static /* synthetic */ void m24128c(AddressUIFragment addressUIFragment, String str) {
            AppMethodBeat.m2504i(33527);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (C7486a.m12942jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.setClass(addressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", aoO.field_username);
                intent.putExtra("view_mode", true);
                addressUIFragment.getContext().startActivity(intent);
            }
            AppMethodBeat.m2505o(33527);
        }

        /* renamed from: q */
        static /* synthetic */ void m24142q(AddressUIFragment addressUIFragment) {
            AppMethodBeat.m2504i(33529);
            LauncherUI launcherUI = (LauncherUI) addressUIFragment.getContext();
            if (launcherUI == null || launcherUI.yjJ.getMainTabUI().mbt == 1) {
                C4978c.m7375a(addressUIFragment.nIv);
                new C7306ak().postDelayed(new C157707(), 300);
            }
            AppMethodBeat.m2505o(33529);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33530);
        super.onCreate(bundle);
        C0336i supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.zjY = new AddressUIFragment();
            this.zjY.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().mo552a(16908290, this.zjY).commit();
        }
        AppMethodBeat.m2505o(33530);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
