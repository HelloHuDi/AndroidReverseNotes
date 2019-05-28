package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.voicesearch.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI extends MMActivity {
    public MMFragment zjY;

    public static class OpenIMAddressUIFragment extends MMFragment implements f {
        private ProgressDialog ehJ = null;
        d ein = new d(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(33768);
                ab.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", Integer.valueOf(i));
                AppMethodBeat.o(33768);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(33769);
                ab.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", Integer.valueOf(i));
                if (i == 2) {
                    com.tencent.mm.cf.d.dvV().ev(OpenIMAddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.o(33769);
            }
        });
        List<String> elZ = new LinkedList();
        private int jLX;
        private int jLY;
        private com.tencent.mm.ui.widget.f jMb;
        private n.d lCi = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(33767);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        OpenIMAddressUIFragment.a(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.zke);
                        AppMethodBeat.o(33767);
                        return;
                    case 7:
                        OpenIMAddressUIFragment.c(OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.zke);
                        AppMethodBeat.o(33767);
                        return;
                    default:
                        AppMethodBeat.o(33767);
                        return;
                }
            }
        };
        private ListView nIv;
        private b zkc;
        private String zke = "";
        boolean zks;
        private boolean zkt = true;
        List<String> zkx = new LinkedList();
        private String znZ = "";
        private t zoa;
        private Runnable zob = new Runnable() {
            public final void run() {
                AppMethodBeat.i(33783);
                OpenIMAddressUIFragment.i(OpenIMAddressUIFragment.this);
                AppMethodBeat.o(33783);
            }
        };

        static /* synthetic */ void k(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(33799);
            openIMAddressUIFragment.dHA();
            AppMethodBeat.o(33799);
        }

        public OpenIMAddressUIFragment() {
            super(true);
            AppMethodBeat.i(33784);
            AppMethodBeat.o(33784);
        }

        public int getLayoutId() {
            return R.layout.ajq;
        }

        public View getLayoutView() {
            AppMethodBeat.i(33785);
            View a = com.tencent.mm.kiss.a.b.SM().a(getContext(), "R.layout.openim_address", (int) R.layout.ajq);
            AppMethodBeat.o(33785);
            return a;
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(33786);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            aw.ZK();
            ad aoO = c.XM().aoO(this.zke);
            if (aoO == null) {
                ab.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.zke);
                AppMethodBeat.o(33786);
            } else if (r.Yz().equals(aoO.field_username)) {
                AppMethodBeat.o(33786);
            } else if (t.mW(this.zke)) {
                contextMenu.setHeaderTitle(j.b(view.getContext(), aoO.Oj()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.dt);
                AppMethodBeat.o(33786);
            } else if (t.nl(this.zke) || t.nB(this.zke)) {
                AppMethodBeat.o(33786);
            } else {
                contextMenu.setHeaderTitle(j.b(view.getContext(), aoO.Oj()));
                if (a.jh(aoO.field_type) && aoO.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.axw);
                }
                AppMethodBeat.o(33786);
            }
        }

        public void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(33787);
            if (mVar.getType() != l.CTRL_INDEX) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (!ah.cv(getContext())) {
                    AppMethodBeat.o(33787);
                } else if (u.a.a(getContext(), i, i2, str, 4)) {
                    AppMethodBeat.o(33787);
                } else if (i == 0 && i2 == 0) {
                    AppMethodBeat.o(33787);
                } else {
                    AppMethodBeat.o(33787);
                }
            } else if (i == 0 && i2 == 0) {
                if (!((aln) ((i) mVar).ehh.fsH.fsP).wqP.isEmpty()) {
                    dHA();
                }
                AppMethodBeat.o(33787);
            } else {
                AppMethodBeat.o(33787);
            }
        }

        private void dHz() {
            AppMethodBeat.i(33788);
            this.elZ = new LinkedList();
            this.zkx = new LinkedList();
            com.tencent.mm.bp.d.dlL();
            this.elZ.add("tmessage");
            this.zkx.addAll(this.elZ);
            if (!this.elZ.contains("officialaccounts")) {
                this.elZ.add("officialaccounts");
            }
            this.elZ.add("helper_entry");
            if (this.zoa != null) {
                this.zoa.fl(this.elZ);
            }
            if (this.zkc != null) {
                this.zkc.fl(this.zkx);
            }
            AppMethodBeat.o(33788);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(33789);
            ab.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.o(33789);
            } else if (i2 != -1) {
                AppMethodBeat.o(33789);
            } else {
                switch (i) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.o(33789);
            }
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(33790);
            super.onActivityCreated(bundle);
            ab.v("MicroMsg.OpenIMAddressUI", "on address ui create");
            aw.Rg().a(138, (f) this);
            g.RQ();
            g.RO().eJo.a((int) l.CTRL_INDEX, (f) this);
            this.znZ = getStringExtra("key_openim_acctype_id");
            setMMTitle(((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).b(this.znZ, "openim_acct_type_title", com.tencent.mm.openim.a.b.a.TYPE_WORDING));
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33765);
                    OpenIMAddressUIFragment.this.finish();
                    AppMethodBeat.o(33765);
                    return true;
                }
            });
            setTitleBarDoubleClickListener(this.zob);
            ab.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            this.nIv = (ListView) findViewById(R.id.n3);
            this.nIv.setScrollingCacheEnabled(false);
            this.zoa = new t(getContext(), "@openim.contact", this.znZ);
            this.zoa.a((com.tencent.mm.ui.f.a) new com.tencent.mm.ui.f.a() {
                public final void apt() {
                    AppMethodBeat.i(33776);
                    OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                    OpenIMAddressUIFragment.this.zoa.getCount();
                    OpenIMAddressUIFragment.b(openIMAddressUIFragment);
                    OpenIMAddressUIFragment.this.zoa.dHw();
                    AppMethodBeat.o(33776);
                }

                public final void dwH() {
                }
            });
            this.zoa.zjK = true;
            this.zoa.zof = this;
            this.zoa.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(33777);
                    int positionForView = OpenIMAddressUIFragment.this.nIv.getPositionForView(view);
                    AppMethodBeat.o(33777);
                    return positionForView;
                }
            });
            this.zoa.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(33778);
                    OpenIMAddressUIFragment.this.nIv.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(33778);
                }
            });
            this.zoa.a((MMSlideDelView.f) new MMSlideDelView.f() {
                public final void bN(Object obj) {
                    AppMethodBeat.i(33779);
                    if (obj == null) {
                        ab.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
                        AppMethodBeat.o(33779);
                        return;
                    }
                    OpenIMAddressUIFragment.a(OpenIMAddressUIFragment.this, obj.toString());
                    AppMethodBeat.o(33779);
                }
            });
            this.zkc = new b(getContext(), 1);
            this.zkc.qV(true);
            this.jMb = new com.tencent.mm.ui.widget.f(getContext());
            this.nIv.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33780);
                    ab.i("MicroMsg.OpenIMAddressUI", "onItemClick " + i + (OpenIMAddressUIFragment.this.zkc == null ? OpenIMAddressUIFragment.this.zkc : Boolean.valueOf(OpenIMAddressUIFragment.this.zkc.zLy)));
                    int headerViewsCount = i - OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount();
                    String str;
                    if (OpenIMAddressUIFragment.this.zkc == null || !OpenIMAddressUIFragment.this.zkc.zLy) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) OpenIMAddressUIFragment.this.zoa.getItem(headerViewsCount);
                        if (fVar != null) {
                            str = fVar.field_username;
                            OpenIMAddressUIFragment openIMAddressUIFragment = OpenIMAddressUIFragment.this;
                            if (str == null || str.length() <= 0) {
                                AppMethodBeat.o(33780);
                                return;
                            } else if (t.ny(str)) {
                                ab.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", str);
                                AppMethodBeat.o(33780);
                                return;
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("Contact_User", str);
                                if (t.mW(str)) {
                                    intent.putExtra("Is_group_card", true);
                                }
                                if (str != null && str.length() > 0) {
                                    e.a(intent, str);
                                    com.tencent.mm.bp.d.b(openIMAddressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                }
                            }
                        }
                        AppMethodBeat.o(33780);
                        return;
                    }
                    boolean wK = OpenIMAddressUIFragment.this.zkc.wK(headerViewsCount);
                    boolean PQ = OpenIMAddressUIFragment.this.zkc.PQ(headerViewsCount);
                    ab.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(PQ)));
                    Intent intent2;
                    if (PQ) {
                        OpenIMAddressUIFragment.this.zkc.asx("");
                        AppMethodBeat.o(33780);
                    } else if (wK) {
                        but PO = OpenIMAddressUIFragment.this.zkc.PO(headerViewsCount);
                        String str2 = PO.wcB.wVI;
                        aw.ZK();
                        ad aoO = c.XM().aoO(str2);
                        if (a.jh(aoO.field_type)) {
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", str2);
                            intent2.putExtra("Contact_Scene", 3);
                            if (str2 != null && str2.length() > 0) {
                                if (aoO.dsf()) {
                                    h.pYm.X(10298, str2 + ",3");
                                }
                                e.a(intent2, str2);
                                com.tencent.mm.bp.d.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                            }
                            AppMethodBeat.o(33780);
                            return;
                        }
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", PO.wcB.wVI);
                        intent3.putExtra("Contact_Alias", PO.guS);
                        intent3.putExtra("Contact_Nick", PO.wyX.wVI);
                        intent3.putExtra("Contact_Signature", PO.guQ);
                        intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(PO.guW, PO.guO, PO.guP));
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
                                ab.printErrStackTrace("MicroMsg.OpenIMAddressUI", e, "", new Object[0]);
                            }
                        }
                        if ((PO.wBT & 8) > 0) {
                            h.pYm.X(10298, str2 + ",3");
                        }
                        com.tencent.mm.bp.d.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                        AppMethodBeat.o(33780);
                    } else {
                        ad PP = OpenIMAddressUIFragment.this.zkc.PP(headerViewsCount);
                        if (PP == null) {
                            ab.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(OpenIMAddressUIFragment.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                            AppMethodBeat.o(33780);
                            return;
                        }
                        str = PP.field_username;
                        if (t.ny(str)) {
                            Intent intent4 = new Intent(OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                            intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                            OpenIMAddressUIFragment.this.startActivity(intent4);
                            AppMethodBeat.o(33780);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Contact_Scene", 3);
                        if (str != null && str.length() > 0) {
                            com.tencent.mm.bp.d.b(OpenIMAddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        AppMethodBeat.o(33780);
                    }
                }
            });
            this.nIv.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33781);
                    ab.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
                    if (i < OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount()) {
                        ab.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
                        AppMethodBeat.o(33781);
                        return true;
                    } else if (OpenIMAddressUIFragment.this.zkc == null || !OpenIMAddressUIFragment.this.zkc.zLy) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) OpenIMAddressUIFragment.this.zoa.getItem(i - OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount());
                        if (fVar == null) {
                            ab.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(OpenIMAddressUIFragment.this.nIv.getHeaderViewsCount()));
                            AppMethodBeat.o(33781);
                            return true;
                        }
                        String str = fVar.field_username;
                        if (t.ny(str) || t.nz(str)) {
                            AppMethodBeat.o(33781);
                            return true;
                        }
                        OpenIMAddressUIFragment.this.zke = str;
                        OpenIMAddressUIFragment.this.jMb.a(view, i, j, OpenIMAddressUIFragment.this, OpenIMAddressUIFragment.this.lCi, OpenIMAddressUIFragment.this.jLX, OpenIMAddressUIFragment.this.jLY);
                        AppMethodBeat.o(33781);
                        return true;
                    } else {
                        AppMethodBeat.o(33781);
                        return true;
                    }
                }
            });
            this.nIv.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(33782);
                    switch (motionEvent.getAction()) {
                        case 0:
                            OpenIMAddressUIFragment.this.hideVKB();
                            OpenIMAddressUIFragment.this.jLX = (int) motionEvent.getRawX();
                            OpenIMAddressUIFragment.this.jLY = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(33782);
                    return false;
                }
            });
            this.nIv.setOnScrollListener(this.ein);
            this.nIv.setDrawingCacheEnabled(false);
            aw.ZK();
            c.XM().a(this.zoa);
            AppMethodBeat.o(33790);
        }

        public void onResume() {
            AppMethodBeat.i(33791);
            super.onResume();
            ab.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
            if (this.zkt) {
                this.zkt = false;
                this.zks = false;
                dHz();
                this.nIv.setAdapter(this.zoa);
                this.nIv.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33772);
                        ab.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
                        View findViewById = OpenIMAddressUIFragment.this.findViewById(R.id.ev4);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUIFragment.this.getContext(), R.anim.b6));
                        }
                        AppMethodBeat.o(33772);
                    }
                });
                this.zkc.qU(false);
            } else if (this.zks) {
                this.zks = false;
                com.tencent.mm.sdk.g.d.f(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33773);
                        Process.setThreadPriority(10);
                        OpenIMAddressUIFragment.k(OpenIMAddressUIFragment.this);
                        AppMethodBeat.o(33773);
                    }
                }, "AddressUI_updateUIData");
            }
            if (this.zkc != null) {
                this.zkc.onResume();
            }
            this.zoa.ygw = false;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33774);
                    OpenIMAddressUIFragment.this.zoa.resume();
                    AppMethodBeat.o(33774);
                }
            });
            AppMethodBeat.o(33791);
        }

        private synchronized void dHA() {
            AppMethodBeat.i(33792);
            long currentTimeMillis = System.currentTimeMillis();
            dHz();
            ab.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.zoa != null) {
                ab.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33770);
                        OpenIMAddressUIFragment.this.zoa.dHy();
                        AppMethodBeat.o(33770);
                    }
                });
            }
            if (this.zkc != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33771);
                        ab.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
                        OpenIMAddressUIFragment.this.zkc.a(null, null);
                        AppMethodBeat.o(33771);
                    }
                });
            }
            ab.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(33792);
        }

        public void onPause() {
            AppMethodBeat.i(33793);
            super.onPause();
            ab.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
            if (this.zkc != null) {
                this.zkc.onPause();
            }
            this.zoa.dHx();
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33775);
                    OpenIMAddressUIFragment.this.zoa.pause();
                    AppMethodBeat.o(33775);
                }
            });
            AppMethodBeat.o(33793);
        }

        public void onDestroy() {
            AppMethodBeat.i(33794);
            super.onDestroy();
            ab.v("MicroMsg.OpenIMAddressUI", "onDestory");
            aw.Rg().b(138, (f) this);
            g.RQ();
            g.RO().eJo.b((int) l.CTRL_INDEX, (f) this);
            if (this.zoa != null) {
                this.zoa.pB(true);
                this.zoa.detach();
                this.zoa.dww();
            }
            if (this.zkc != null) {
                this.zkc.detach();
                this.zkc.bIf();
            }
            if (aw.RK() && this.zoa != null) {
                aw.ZK();
                c.XM().b(this.zoa);
            }
            AppMethodBeat.o(33794);
        }

        static /* synthetic */ void b(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(33795);
            openIMAddressUIFragment.nIv.setVisibility(0);
            AppMethodBeat.o(33795);
        }

        static /* synthetic */ void i(OpenIMAddressUIFragment openIMAddressUIFragment) {
            AppMethodBeat.i(33797);
            BackwardSupportUtil.c.a(openIMAddressUIFragment.nIv);
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33766);
                    OpenIMAddressUIFragment.this.nIv.setSelection(0);
                    AppMethodBeat.o(33766);
                }
            }, 300);
            AppMethodBeat.o(33797);
        }

        static /* synthetic */ void c(OpenIMAddressUIFragment openIMAddressUIFragment, String str) {
            AppMethodBeat.i(33798);
            aw.ZK();
            ad aoO = c.XM().aoO(str);
            if (a.jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.setClass(openIMAddressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", aoO.field_username);
                intent.putExtra("view_mode", true);
                openIMAddressUIFragment.getContext().startActivity(intent);
            }
            AppMethodBeat.o(33798);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33800);
        super.onCreate(bundle);
        android.support.v4.app.i supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.zjY = new OpenIMAddressUIFragment();
            this.zjY.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().a((int) R.id.dkl, this.zjY).commit();
        }
        AppMethodBeat.o(33800);
    }

    public final int getLayoutId() {
        return R.layout.ajp;
    }
}
