package com.tencent.p177mm.p612ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.p057v4.app.C0336i;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.openim.p716b.C32878i;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.C40862f.C30702a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.voicesearch.C46939b;
import com.tencent.p177mm.p612ui.widget.C16002f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.aln;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C40629f;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI */
public class OpenIMAddressUI extends MMActivity {
    public MMFragment zjY;

    /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment */
    public static class OpenIMAddressUIFragment extends MMFragment implements C1202f {
        private ProgressDialog ehJ = null;
        C14943d ein = new C14943d(new C239104());
        List<String> elZ = new LinkedList();
        private int jLX;
        private int jLY;
        private C16002f jMb;
        private C5279d lCi = new C239093();
        private ListView nIv;
        private C46939b zkc;
        private String zke = "";
        boolean zks;
        private boolean zkt = true;
        List<String> zkx = new LinkedList();
        private String znZ = "";
        private C44358t zoa;
        private Runnable zob = new C2390718();

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$12 */
        class C543712 implements C15521c {
            C543712() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(33777);
                int positionForView = OpenIMAddressUIFragment.this.nIv.getPositionForView(view);
                AppMethodBeat.m2505o(33777);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$17 */
        class C543817 implements OnTouchListener {
            C543817() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(33782);
                switch (motionEvent.getAction()) {
                    case 0:
                        OpenIMAddressUIFragment.this.hideVKB();
                        OpenIMAddressUIFragment.this.jLX = (int) motionEvent.getRawX();
                        OpenIMAddressUIFragment.this.jLY = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.m2505o(33782);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$11 */
        class C2390611 implements C30702a {
            C2390611() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(33776);
                OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                OpenIMAddressUIFragment.this.zoa.getCount();
                OpenIMAddressUIFragment.m70764b(openIMAddressUIFragment);
                OpenIMAddressUIFragment.this.zoa.dHw();
                AppMethodBeat.m2505o(33776);
            }

            public final void dwH() {
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$18 */
        class C2390718 implements Runnable {
            C2390718() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33783);
                OpenIMAddressUIFragment.m70772i(OpenIMAddressUIFragment.this);
                AppMethodBeat.m2505o(33783);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$2 */
        class C239082 implements Runnable {
            C239082() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33766);
                OpenIMAddressUIFragment.this.nIv.setSelection(0);
                AppMethodBeat.m2505o(33766);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$3 */
        class C239093 implements C5279d {
            C239093() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(33767);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        OpenIMAddressUIFragment.m70761a(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.zke);
                        AppMethodBeat.m2505o(33767);
                        return;
                    case 7:
                        OpenIMAddressUIFragment.m70766c(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.zke);
                        AppMethodBeat.m2505o(33767);
                        return;
                    default:
                        AppMethodBeat.m2505o(33767);
                        return;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$4 */
        class C239104 implements OnScrollListener {
            C239104() {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.m2504i(33768);
                C4990ab.m7417i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", Integer.valueOf(i));
                AppMethodBeat.m2505o(33768);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.m2504i(33769);
                C4990ab.m7417i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", Integer.valueOf(i));
                if (i == 2) {
                    C37634d.dvV().mo60468ev(OpenIMAddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.m2505o(33769);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$10 */
        class C3063810 implements Runnable {
            C3063810() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33775);
                OpenIMAddressUIFragment.this.zoa.pause();
                AppMethodBeat.m2505o(33775);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$13 */
        class C3624213 implements C23600g {
            C3624213() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(33778);
                OpenIMAddressUIFragment.this.nIv.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(33778);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$14 */
        class C3624314 implements C23599f {
            C3624314() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(33779);
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
                    AppMethodBeat.m2505o(33779);
                    return;
                }
                OpenIMAddressUIFragment.m70761a(OpenIMAddressUIFragment.this, obj.toString());
                AppMethodBeat.m2505o(33779);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$16 */
        class C3624416 implements OnItemLongClickListener {
            C3624416() {
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33781);
                C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
                if (i < OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
                    AppMethodBeat.m2505o(33781);
                    return true;
                } else if (OpenIMAddressUIFragment.this.zkc == null || !OpenIMAddressUIFragment.this.zkc.zLy) {
                    C40629f c40629f = (C40629f) OpenIMAddressUIFragment.this.zoa.getItem(i - OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount());
                    if (c40629f == null) {
                        C4990ab.m7413e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount()));
                        AppMethodBeat.m2505o(33781);
                        return true;
                    }
                    String str = c40629f.field_username;
                    if (C1855t.m3956ny(str) || C1855t.m3957nz(str)) {
                        AppMethodBeat.m2505o(33781);
                        return true;
                    }
                    OpenIMAddressUIFragment.this.zke = str;
                    OpenIMAddressUIFragment.this.jMb.mo39885a(view, i, j, OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.lCi, OpenIMAddressUIFragment.this.jLX, OpenIMAddressUIFragment.this.jLY);
                    AppMethodBeat.m2505o(33781);
                    return true;
                } else {
                    AppMethodBeat.m2505o(33781);
                    return true;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$5 */
        class C362455 implements Runnable {
            C362455() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33770);
                OpenIMAddressUIFragment.this.zoa.dHy();
                AppMethodBeat.m2505o(33770);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$15 */
        class C4083315 implements OnItemClickListener {
            C4083315() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33780);
                C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "onItemClick " + i + (OpenIMAddressUIFragment.this.zkc == null ? OpenIMAddressUIFragment.this.zkc : Boolean.valueOf(OpenIMAddressUIFragment.this.zkc.zLy)));
                int headerViewsCount = i - OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount();
                String str;
                if (OpenIMAddressUIFragment.this.zkc == null || !OpenIMAddressUIFragment.this.zkc.zLy) {
                    C40629f c40629f = (C40629f) OpenIMAddressUIFragment.this.zoa.getItem(headerViewsCount);
                    if (c40629f != null) {
                        str = c40629f.field_username;
                        OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                        if (str == null || str.length() <= 0) {
                            AppMethodBeat.m2505o(33780);
                            return;
                        } else if (C1855t.m3956ny(str)) {
                            C4990ab.m7413e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", str);
                            AppMethodBeat.m2505o(33780);
                            return;
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            if (C1855t.m3910mW(str)) {
                                intent.putExtra("Is_group_card", true);
                            }
                            if (str != null && str.length() > 0) {
                                C36249e.m59677a(intent, str);
                                C25985d.m41467b(openIMAddressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(33780);
                    return;
                }
                boolean wK = OpenIMAddressUIFragment.this.zkc.mo10892wK(headerViewsCount);
                boolean PQ = OpenIMAddressUIFragment.this.zkc.mo76189PQ(headerViewsCount);
                C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(PQ)));
                Intent intent2;
                if (PQ) {
                    OpenIMAddressUIFragment.this.zkc.asx("");
                    AppMethodBeat.m2505o(33780);
                } else if (wK) {
                    but PO = OpenIMAddressUIFragment.this.zkc.mo76187PO(headerViewsCount);
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
                            C25985d.m41467b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        AppMethodBeat.m2505o(33780);
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
                            C4990ab.printErrStackTrace("MicroMsg.OpenIMAddressUI", e, "", new Object[0]);
                        }
                    }
                    if ((PO.wBT & 8) > 0) {
                        C7060h.pYm.mo8374X(10298, str2 + ",3");
                    }
                    C25985d.m41467b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                    AppMethodBeat.m2505o(33780);
                } else {
                    C7616ad PP = OpenIMAddressUIFragment.this.zkc.mo76188PP(headerViewsCount);
                    if (PP == null) {
                        C4990ab.m7413e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(OpenIMAddressUIFragment.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                        AppMethodBeat.m2505o(33780);
                        return;
                    }
                    str = PP.field_username;
                    if (C1855t.m3956ny(str)) {
                        Intent intent4 = new Intent(OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                        intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                        OpenIMAddressUIFragment.this.startActivity(intent4);
                        AppMethodBeat.m2505o(33780);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", 3);
                    if (str != null && str.length() > 0) {
                        C25985d.m41467b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                    AppMethodBeat.m2505o(33780);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$6 */
        class C408346 implements Runnable {
            C408346() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33771);
                C4990ab.m7418v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
                OpenIMAddressUIFragment.this.zkc.mo5248a(null, null);
                AppMethodBeat.m2505o(33771);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$8 */
        class C408358 implements Runnable {
            C408358() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33773);
                Process.setThreadPriority(10);
                OpenIMAddressUIFragment.m70774k(OpenIMAddressUIFragment.this);
                AppMethodBeat.m2505o(33773);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$9 */
        class C408369 implements Runnable {
            C408369() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33774);
                OpenIMAddressUIFragment.this.zoa.resume();
                AppMethodBeat.m2505o(33774);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$1 */
        class C408371 implements OnMenuItemClickListener {
            C408371() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(33765);
                OpenIMAddressUIFragment.this.finish();
                AppMethodBeat.m2505o(33765);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.OpenIMAddressUI$OpenIMAddressUIFragment$7 */
        class C408387 implements Runnable {
            C408387() {
            }

            public final void run() {
                AppMethodBeat.m2504i(33772);
                C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "post to first init finish");
                View findViewById = OpenIMAddressUIFragment.this.findViewById(2131828206);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUIFragment.this.getContext(), C25738R.anim.f8333b6));
                }
                AppMethodBeat.m2505o(33772);
            }
        }

        /* renamed from: k */
        static /* synthetic */ void m70774k(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.m2504i(33799);
            openIMAddressUIFragment.dHA();
            AppMethodBeat.m2505o(33799);
        }

        public OpenIMAddressUIFragment() {
            super(true);
            AppMethodBeat.m2504i(33784);
            AppMethodBeat.m2505o(33784);
        }

        public int getLayoutId() {
            return 2130970336;
        }

        public View getLayoutView() {
            AppMethodBeat.m2504i(33785);
            View a = C1742b.m3596SM().mo5274a(getContext(), "R.layout.openim_address", 2130970336);
            AppMethodBeat.m2505o(33785);
            return a;
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(33786);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.zke);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.zke);
                AppMethodBeat.m2505o(33786);
            } else if (C1853r.m3846Yz().equals(aoO.field_username)) {
                AppMethodBeat.m2505o(33786);
            } else if (C1855t.m3910mW(this.zke)) {
                contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), aoO.mo16707Oj()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.f8745dt);
                AppMethodBeat.m2505o(33786);
            } else if (C1855t.m3943nl(this.zke) || C1855t.m3916nB(this.zke)) {
                AppMethodBeat.m2505o(33786);
            } else {
                contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), aoO.mo16707Oj()));
                if (C7486a.m12942jh(aoO.field_type) && aoO.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, C25738R.string.axw);
                }
                AppMethodBeat.m2505o(33786);
            }
        }

        public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(33787);
            if (c1207m.getType() != C38317l.CTRL_INDEX) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (!C42252ah.m74615cv(getContext())) {
                    AppMethodBeat.m2505o(33787);
                } else if (C30784a.m49123a(getContext(), i, i2, str, 4)) {
                    AppMethodBeat.m2505o(33787);
                } else if (i == 0 && i2 == 0) {
                    AppMethodBeat.m2505o(33787);
                } else {
                    AppMethodBeat.m2505o(33787);
                }
            } else if (i == 0 && i2 == 0) {
                if (!((aln) ((C32878i) c1207m).ehh.fsH.fsP).wqP.isEmpty()) {
                    dHA();
                }
                AppMethodBeat.m2505o(33787);
            } else {
                AppMethodBeat.m2505o(33787);
            }
        }

        private void dHz() {
            AppMethodBeat.m2504i(33788);
            this.elZ = new LinkedList();
            this.zkx = new LinkedList();
            C25985d.dlL();
            this.elZ.add("tmessage");
            this.zkx.addAll(this.elZ);
            if (!this.elZ.contains("officialaccounts")) {
                this.elZ.add("officialaccounts");
            }
            this.elZ.add("helper_entry");
            if (this.zoa != null) {
                this.zoa.mo28044fl(this.elZ);
            }
            if (this.zkc != null) {
                this.zkc.mo76194fl(this.zkx);
            }
            AppMethodBeat.m2505o(33788);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(33789);
            C4990ab.m7417i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.m2505o(33789);
            } else if (i2 != -1) {
                AppMethodBeat.m2505o(33789);
            } else {
                switch (i) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.m2505o(33789);
            }
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.m2504i(33790);
            super.onActivityCreated(bundle);
            C4990ab.m7418v("MicroMsg.OpenIMAddressUI", "on address ui create");
            C9638aw.m17182Rg().mo14539a(138, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a((int) C38317l.CTRL_INDEX, (C1202f) this);
            this.znZ = getStringExtra("key_openim_acctype_id");
            setMMTitle(((C32873b) C1720g.m3528K(C32873b.class)).mo44305b(this.znZ, "openim_acct_type_title", C32874a.TYPE_WORDING));
            setBackBtn(new C408371());
            setTitleBarDoubleClickListener(this.zob);
            C4990ab.m7419v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            this.nIv = (ListView) findViewById(2131821054);
            this.nIv.setScrollingCacheEnabled(false);
            this.zoa = new C44358t(getContext(), "@openim.contact", this.znZ);
            this.zoa.mo64391a((C30702a) new C2390611());
            this.zoa.zjK = true;
            this.zoa.zof = this;
            this.zoa.setGetViewPositionCallback(new C543712());
            this.zoa.setPerformItemClickListener(new C3624213());
            this.zoa.mo28032a((C23599f) new C3624314());
            this.zkc = new C46939b(getContext(), 1);
            this.zkc.mo76203qV(true);
            this.jMb = new C16002f(getContext());
            this.nIv.setOnItemClickListener(new C4083315());
            this.nIv.setOnItemLongClickListener(new C3624416());
            this.nIv.setOnTouchListener(new C543817());
            this.nIv.setOnScrollListener(this.ein);
            this.nIv.setDrawingCacheEnabled(false);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10118a(this.zoa);
            AppMethodBeat.m2505o(33790);
        }

        public void onResume() {
            AppMethodBeat.m2504i(33791);
            super.onResume();
            C4990ab.m7418v("MicroMsg.OpenIMAddressUI", "address ui on resume");
            if (this.zkt) {
                this.zkt = false;
                this.zks = false;
                dHz();
                this.nIv.setAdapter(this.zoa);
                this.nIv.post(new C408387());
                this.zkc.mo76202qU(false);
            } else if (this.zks) {
                this.zks = false;
                C7305d.m12298f(new C408358(), "AddressUI_updateUIData");
            }
            if (this.zkc != null) {
                this.zkc.onResume();
            }
            this.zoa.ygw = false;
            C5004al.m7441d(new C408369());
            AppMethodBeat.m2505o(33791);
        }

        private synchronized void dHA() {
            AppMethodBeat.m2504i(33792);
            long currentTimeMillis = System.currentTimeMillis();
            dHz();
            C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.zoa != null) {
                C4990ab.m7418v("MicroMsg.OpenIMAddressUI", "post to do refresh");
                C5004al.m7441d(new C362455());
            }
            if (this.zkc != null) {
                C5004al.m7441d(new C408346());
            }
            C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(33792);
        }

        public void onPause() {
            AppMethodBeat.m2504i(33793);
            super.onPause();
            C4990ab.m7416i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
            if (this.zkc != null) {
                this.zkc.onPause();
            }
            this.zoa.dHx();
            C5004al.m7441d(new C3063810());
            AppMethodBeat.m2505o(33793);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(33794);
            super.onDestroy();
            C4990ab.m7418v("MicroMsg.OpenIMAddressUI", "onDestory");
            C9638aw.m17182Rg().mo14546b(138, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b((int) C38317l.CTRL_INDEX, (C1202f) this);
            if (this.zoa != null) {
                this.zoa.mo64400pB(true);
                this.zoa.detach();
                this.zoa.dww();
            }
            if (this.zkc != null) {
                this.zkc.detach();
                this.zkc.bIf();
            }
            if (C9638aw.m17179RK() && this.zoa != null) {
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo10121b(this.zoa);
            }
            AppMethodBeat.m2505o(33794);
        }

        /* renamed from: b */
        static /* synthetic */ void m70764b(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.m2504i(33795);
            openIMAddressUIFragment.nIv.setVisibility(0);
            AppMethodBeat.m2505o(33795);
        }

        /* renamed from: i */
        static /* synthetic */ void m70772i(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.m2504i(33797);
            C4978c.m7375a(openIMAddressUIFragment.nIv);
            new C7306ak().postDelayed(new C239082(), 300);
            AppMethodBeat.m2505o(33797);
        }

        /* renamed from: c */
        static /* synthetic */ void m70766c(OpenIMAddressUIFragment openIMAddressUIFragment, String str) {
            AppMethodBeat.m2504i(33798);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (C7486a.m12942jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.setClass(openIMAddressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", aoO.field_username);
                intent.putExtra("view_mode", true);
                openIMAddressUIFragment.getContext().startActivity(intent);
            }
            AppMethodBeat.m2505o(33798);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33800);
        super.onCreate(bundle);
        C0336i supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.zjY = new OpenIMAddressUIFragment();
            this.zjY.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().mo552a(2131826448, this.zjY).commit();
        }
        AppMethodBeat.m2505o(33800);
    }

    public final int getLayoutId() {
        return 2130970335;
    }
}
