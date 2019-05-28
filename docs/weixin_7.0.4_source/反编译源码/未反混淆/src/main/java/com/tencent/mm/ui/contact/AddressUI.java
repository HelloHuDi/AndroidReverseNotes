package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.i;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.b.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AddressUI extends FragmentActivity {
    public MMFragment zjY;

    public static class AddressUIFragment extends AbStractTabFragment implements f {
        private final long TIME_INTERVAL = 180000;
        private ProgressDialog ehJ = null;
        d ein = new d(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(33492);
                if (i < 2) {
                    AppMethodBeat.o(33492);
                    return;
                }
                if (!AddressUIFragment.this.zki) {
                    AddressUIFragment.this.zki = true;
                }
                AppMethodBeat.o(33492);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(33493);
                if (i == 2) {
                    com.tencent.mm.cf.d.dvV().ev(AddressUI.class.getName() + ".Listview", 4);
                }
                AppMethodBeat.o(33493);
            }
        });
        List<String> elZ = new LinkedList();
        private TextView gtY;
        private boolean gxV = false;
        private int jLX;
        private int jLY;
        private a jMO;
        private n.d lCi = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(33490);
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        AddressUIFragment.a(AddressUIFragment.this, AddressUIFragment.this.zke);
                        AppMethodBeat.o(33490);
                        return;
                    case 7:
                        AddressUIFragment.c(AddressUIFragment.this, AddressUIFragment.this.zke);
                        AppMethodBeat.o(33490);
                        return;
                    default:
                        AppMethodBeat.o(33490);
                        return;
                }
            }
        };
        private Animation lVH;
        private ListView nIv;
        private c ryK = new c<ru>() {
            {
                AppMethodBeat.i(33483);
                this.xxI = ru.class.getName().hashCode();
                AppMethodBeat.o(33483);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(33484);
                ru ruVar = (ru) bVar;
                if (AddressUIFragment.this.getContext() == null || AddressUIFragment.this.getContext().isFinishing()) {
                    AppMethodBeat.o(33484);
                } else {
                    if (!(ruVar.cNM.cNN || AddressUIFragment.this.zkb == null)) {
                        ((e) g.M(e.class)).getFavourUserChecker().cwS();
                        AddressUIFragment.this.zkb.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(33484);
                }
                return false;
            }
        };
        private TextView zjZ;
        private String zjx;
        private String zjy;
        private TextView zka;
        private a zkb;
        private com.tencent.mm.ui.voicesearch.b zkc;
        private String zkd;
        private String zke = "";
        private int zkf;
        private AlphabetScrollBar zkg;
        private LinearLayout zkh = null;
        private boolean zki = false;
        private boolean zkj = false;
        private k zkk;
        private BizContactEntranceView zkl;
        private b zkm;
        private b zkn;
        private b zko;
        private ContactCountView zkp;
        private u zkq;
        private i zkr;
        boolean zks;
        private boolean zkt = true;
        private LinearLayout zku;
        private Animation zkv;
        private VerticalScrollBar.a zkw = new VerticalScrollBar.a() {
            public final void kp(String str) {
                int i = 0;
                AppMethodBeat.i(33491);
                if (AddressUIFragment.this.getString(R.string.dz6).equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(0);
                    AppMethodBeat.o(33491);
                    return;
                }
                a a = AddressUIFragment.this.zkb;
                ab.v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = a.zjD;
                if (strArr == null) {
                    AppMethodBeat.o(33491);
                } else if ("↑".equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(0);
                    AppMethodBeat.o(33491);
                } else if ("☆".equals(str)) {
                    AddressUIFragment.this.nIv.setSelection(AddressUIFragment.this.nIv.getHeaderViewsCount());
                    AppMethodBeat.o(33491);
                } else {
                    while (i < strArr.length && strArr[i] != null) {
                        if (strArr[i].equals(str)) {
                            AddressUIFragment.this.nIv.setSelection(AddressUIFragment.this.zkb.getPositionForSection(i) + AddressUIFragment.this.nIv.getHeaderViewsCount());
                            AppMethodBeat.o(33491);
                            return;
                        }
                        i++;
                    }
                    AppMethodBeat.o(33491);
                }
            }
        };
        List<String> zkx = new LinkedList();
        private Runnable zky = new Runnable() {
            public final void run() {
                AppMethodBeat.i(33500);
                AddressUIFragment.q(AddressUIFragment.this);
                AppMethodBeat.o(33500);
            }
        };

        public AddressUIFragment() {
            AppMethodBeat.i(33507);
            AppMethodBeat.o(33507);
        }

        static /* synthetic */ void p(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(33528);
            addressUIFragment.dHA();
            AppMethodBeat.o(33528);
        }

        public int getLayoutId() {
            return R.layout.az;
        }

        public View getLayoutView() {
            AppMethodBeat.i(33508);
            View a = com.tencent.mm.kiss.a.b.SM().a(getContext(), "R.layout.address", (int) R.layout.az);
            AppMethodBeat.o(33508);
            return a;
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(33509);
            super.onCreate(bundle);
            com.tencent.mm.sdk.b.a.xxA.c(this.ryK);
            AppMethodBeat.o(33509);
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }

        public boolean noActionBar() {
            return true;
        }

        public final void qA(boolean z) {
            AppMethodBeat.i(33510);
            if (this.zkg != null) {
                if (this.lVH == null) {
                    this.lVH = AnimationUtils.loadAnimation(getContext(), R.anim.ax);
                    this.lVH.setDuration(200);
                }
                if (this.zkv == null) {
                    this.zkv = AnimationUtils.loadAnimation(getContext(), R.anim.ax);
                    this.zkv.setDuration(200);
                }
                if (z) {
                    if (this.zkg.getVisibility() != 0) {
                        this.zkg.setVisibility(0);
                        this.zkg.startAnimation(this.lVH);
                        AppMethodBeat.o(33510);
                        return;
                    }
                } else if (4 != this.zkg.getVisibility()) {
                    this.zkg.setVisibility(8);
                    this.zkg.startAnimation(this.zkv);
                }
            }
            AppMethodBeat.o(33510);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(33511);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.zke);
            if (aoO == null) {
                ab.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.zke);
                AppMethodBeat.o(33511);
            } else if (r.Yz().equals(aoO.field_username)) {
                AppMethodBeat.o(33511);
            } else if (t.mW(this.zke)) {
                contextMenu.setHeaderTitle(j.b(view.getContext(), aoO.Oj()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.dt);
                AppMethodBeat.o(33511);
            } else if (t.nl(this.zke) || t.nB(this.zke)) {
                AppMethodBeat.o(33511);
            } else {
                contextMenu.setHeaderTitle(j.b(view.getContext(), aoO.Oj()));
                if (com.tencent.mm.n.a.jh(aoO.field_type) && aoO.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.string.axw);
                }
                AppMethodBeat.o(33511);
            }
        }

        public void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(33512);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (!ah.cv(getContext())) {
                AppMethodBeat.o(33512);
            } else if (u.a.a(getContext(), i, i2, str, 4)) {
                AppMethodBeat.o(33512);
            } else if (i == 0 && i2 == 0) {
                AppMethodBeat.o(33512);
            } else {
                AppMethodBeat.o(33512);
            }
        }

        private void dHz() {
            AppMethodBeat.i(33513);
            this.elZ = new LinkedList();
            this.zkx = new LinkedList();
            com.tencent.mm.bp.d.dlL();
            this.elZ.add("tmessage");
            this.zkx.addAll(this.elZ);
            if (!this.elZ.contains("officialaccounts")) {
                this.elZ.add("officialaccounts");
            }
            this.elZ.add("helper_entry");
            if (this.zkb != null) {
                this.zkb.fl(this.elZ);
            }
            if (this.zkc != null) {
                this.zkc.fl(this.zkx);
            }
            AppMethodBeat.o(33513);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(33514);
            ab.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                setResult(-1);
                finish();
                AppMethodBeat.o(33514);
            } else if (i2 != -1) {
                AppMethodBeat.o(33514);
            } else {
                switch (i) {
                    case 4:
                        setResult(-1, intent);
                        finish();
                        break;
                }
                AppMethodBeat.o(33514);
            }
        }

        public final void dvY() {
            AppMethodBeat.i(33515);
            ab.v("MicroMsg.AddressUI", "address ui on create");
            ab.v("MicroMsg.AddressUI", "on address ui create");
            this.zki = false;
            this.gxV = false;
            this.zkj = false;
            this.zjx = null;
            this.zjy = null;
            this.zkd = null;
            aw.Rg().a(138, (f) this);
            this.zjx = "@all.contact.without.chatroom.without.openim";
            this.zjy = getStringExtra("Contact_GroupFilter_Str");
            this.zkd = getString(R.string.c_4);
            this.zkf = getIntExtra("List_Type", 2);
            final View findViewById = getView().getRootView().findViewById(R.id.bq);
            int de = ak.de(getContext());
            int J = ak.J(getContext(), -1);
            AnonymousClass12 anonymousClass12 = new Runnable() {
                int eRu = 0;

                public final void run() {
                    AppMethodBeat.i(33495);
                    if (AddressUIFragment.this.getView() == null) {
                        AppMethodBeat.o(33495);
                        return;
                    }
                    int de = ak.de(AddressUIFragment.this.getContext());
                    int J = ak.J(AddressUIFragment.this.getContext(), -1);
                    if (J <= 0) {
                        if (this.eRu < 2) {
                            ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
                            AddressUIFragment.this.getView().post(this);
                        } else {
                            ab.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                        }
                        this.eRu++;
                    } else {
                        int i = de + J;
                        if (i != AddressUIFragment.this.getView().getPaddingTop()) {
                            ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(i), Integer.valueOf(AddressUIFragment.this.getView().getPaddingTop()));
                            AddressUIFragment.this.getView().setPadding(0, i, 0, findViewById.getHeight());
                        } else {
                            ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                        }
                    }
                    ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J), Integer.valueOf(de));
                    AppMethodBeat.o(33495);
                }
            };
            if (J <= 0) {
                getView().post(anonymousClass12);
            } else {
                getView().setPadding(0, de + J, 0, findViewById.getHeight());
                ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(J), Integer.valueOf(de));
                getView().postDelayed(anonymousClass12, 100);
            }
            ab.v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
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
            this.nIv = (ListView) findViewById(R.id.n3);
            this.nIv.setScrollingCacheEnabled(false);
            this.zjZ = (TextView) findViewById(R.id.n5);
            this.zjZ.setText(R.string.dw);
            this.gtY = (TextView) findViewById(R.id.n4);
            this.gtY.setText(R.string.dy);
            this.zka = (TextView) findViewById(R.id.n7);
            this.zka.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.zkb = new a(getContext(), this.zjx, this.zjy, this.zkf);
            this.nIv.setAdapter(null);
            this.zkb.a((com.tencent.mm.ui.f.a) new com.tencent.mm.ui.f.a() {
                public final void apt() {
                    AppMethodBeat.i(33502);
                    AddressUIFragment addressUIFragment = AddressUIFragment.this;
                    AddressUIFragment.this.zkb.getCount();
                    AddressUIFragment.b(addressUIFragment);
                    AddressUIFragment.this.zkb.dHw();
                    AppMethodBeat.o(33502);
                }

                public final void dwH() {
                }
            });
            this.zkb.zjK = true;
            this.zkb.setFragment(this);
            this.zkb.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(33503);
                    View view2 = view;
                    while (true) {
                        try {
                            View view3 = (View) view2.getParent();
                            if (view3 != null && !view3.equals(AddressUIFragment.this.nIv)) {
                                view2 = view3;
                            }
                        } catch (ClassCastException e) {
                            AppMethodBeat.o(33503);
                            return -1;
                        }
                    }
                    if (view2.getParent() == null) {
                        AppMethodBeat.o(33503);
                        return -1;
                    }
                    int positionForView = AddressUIFragment.this.nIv.getPositionForView(view);
                    AppMethodBeat.o(33503);
                    return positionForView;
                }
            });
            this.zkb.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(33504);
                    AddressUIFragment.this.nIv.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(33504);
                }
            });
            this.zkb.a(new MMSlideDelView.f() {
                public final void bN(Object obj) {
                    AppMethodBeat.i(33505);
                    if (obj == null) {
                        ab.e("MicroMsg.AddressUI", "onItemDel object null");
                        AppMethodBeat.o(33505);
                        return;
                    }
                    AddressUIFragment.a(AddressUIFragment.this, obj.toString());
                    AppMethodBeat.o(33505);
                }
            });
            this.zkc = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
            this.zkc.qV(true);
            this.zku = new LinearLayout(getContext());
            this.zku.setOrientation(1);
            this.nIv.addHeaderView(this.zku);
            this.zkn = new b(getContext(), b.a.ContactIpCall);
            this.zku.addView(this.zkn);
            aw.ZK();
            ((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE)).booleanValue();
            this.zkn.setVisible(false);
            this.zkk = new k(getContext());
            this.zku.addView(this.zkk);
            this.zkm = new b(getContext(), b.a.Chatromm);
            this.zku.addView(this.zkm);
            this.zkm.setVisible(true);
            this.zko = new b(getContext(), b.a.ContactLabel);
            this.zku.addView(this.zko);
            this.zko.setVisible(true);
            ListView listView = this.nIv;
            ContactCountView contactCountView = new ContactCountView(getContext());
            this.zkp = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            if (com.tencent.mm.bp.d.afj("brandservice")) {
                this.zkl = new BizContactEntranceView(getContext());
                this.zku.addView(this.zkl);
                this.zkl.setVisible(true);
            }
            AnonymousClass24 anonymousClass24 = new u.b() {
                public final void qB(boolean z) {
                    AppMethodBeat.i(33506);
                    if (AddressUIFragment.this.zkl == null) {
                        AppMethodBeat.o(33506);
                        return;
                    }
                    BizContactEntranceView d = AddressUIFragment.this.zkl;
                    if (d.zld == null) {
                        AppMethodBeat.o(33506);
                    } else if (z) {
                        d.zld.setBackgroundResource(R.drawable.a_q);
                        AppMethodBeat.o(33506);
                    } else {
                        d.zld.setBackground(null);
                        AppMethodBeat.o(33506);
                    }
                }
            };
            this.zkq = new u(getContext(), new u.a() {
            });
            this.zkq.setOnVisibilityChangeListener(anonymousClass24);
            if (this.zkq.getOpenIMCount() <= 0) {
                anonymousClass24.qB(false);
                this.zkq.setVisibility(8);
            } else {
                anonymousClass24.qB(true);
            }
            this.zku.addView(this.zkq);
            if (com.tencent.mm.bp.d.afj("brandservice")) {
                this.zkr = new i(getContext(), new i.a() {
                    public final void Pl(int i) {
                        AppMethodBeat.i(33485);
                        if (AddressUIFragment.this.zkr == null) {
                            AppMethodBeat.o(33485);
                        } else if (i <= 0) {
                            AddressUIFragment.this.zkr.setVisibility(8);
                            AppMethodBeat.o(33485);
                        } else {
                            AddressUIFragment.this.zkr.setVisibility(0);
                            AppMethodBeat.o(33485);
                        }
                    }
                });
                if (this.zkr.getEnterpriseFriendCount() <= 0) {
                    this.zkr.setVisibility(8);
                }
                this.zku.addView(this.zkr);
            }
            this.jMO = new a(getContext());
            this.zkb.zjI = new a.a() {
            };
            this.nIv.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33486);
                    ab.i("MicroMsg.AddressUI", "onItemClick " + i + (AddressUIFragment.this.zkc == null ? AddressUIFragment.this.zkc : Boolean.valueOf(AddressUIFragment.this.zkc.zLy)));
                    if (i == 0 && !"@biz.contact".equals(AddressUIFragment.this.zjx)) {
                        AppMethodBeat.o(33486);
                    } else if (i < AddressUIFragment.this.nIv.getHeaderViewsCount()) {
                        AppMethodBeat.o(33486);
                    } else {
                        int headerViewsCount = i - AddressUIFragment.this.nIv.getHeaderViewsCount();
                        String str;
                        if (AddressUIFragment.this.zkc == null || !AddressUIFragment.this.zkc.zLy) {
                            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) AddressUIFragment.this.zkb.getItem(headerViewsCount);
                            if (fVar != null) {
                                str = fVar.field_username;
                                AddressUIFragment addressUIFragment = AddressUIFragment.this;
                                if (str == null || str.length() <= 0) {
                                    AppMethodBeat.o(33486);
                                    return;
                                } else if (t.ny(str)) {
                                    ab.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                    AppMethodBeat.o(33486);
                                    return;
                                } else {
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", str);
                                    if (t.mW(str)) {
                                        intent.putExtra("Is_group_card", true);
                                    }
                                    if (str != null && str.length() > 0) {
                                        e.a(intent, str);
                                        intent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                        com.tencent.mm.bp.d.b(addressUIFragment.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                    }
                                }
                            }
                            AppMethodBeat.o(33486);
                            return;
                        }
                        boolean wK = AddressUIFragment.this.zkc.wK(headerViewsCount);
                        boolean PQ = AddressUIFragment.this.zkc.PQ(headerViewsCount);
                        ab.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(PQ)));
                        Intent intent2;
                        if (PQ) {
                            AddressUIFragment.this.zkc.asx("");
                            AppMethodBeat.o(33486);
                        } else if (wK) {
                            but PO = AddressUIFragment.this.zkc.PO(headerViewsCount);
                            String str2 = PO.wcB.wVI;
                            aw.ZK();
                            ad aoO = com.tencent.mm.model.c.XM().aoO(str2);
                            if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                                intent2 = new Intent();
                                intent2.putExtra("Contact_User", str2);
                                intent2.putExtra("Contact_Scene", 3);
                                if (str2 != null && str2.length() > 0) {
                                    if (aoO.dsf()) {
                                        h.pYm.X(10298, str2 + ",3");
                                    }
                                    e.a(intent2, str2);
                                    intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                                    com.tencent.mm.bp.d.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                                }
                                AppMethodBeat.o(33486);
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
                                    ab.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                                }
                            }
                            if ((PO.wBT & 8) > 0) {
                                h.pYm.X(10298, str2 + ",3");
                            }
                            intent3.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                            com.tencent.mm.bp.d.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                            AppMethodBeat.o(33486);
                        } else {
                            ad PP = AddressUIFragment.this.zkc.PP(headerViewsCount);
                            if (PP == null) {
                                ab.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(AddressUIFragment.this.zkc.getCount()), Integer.valueOf(headerViewsCount));
                                AppMethodBeat.o(33486);
                                return;
                            }
                            str = PP.field_username;
                            if (t.ny(str)) {
                                Intent intent4 = new Intent(AddressUIFragment.this.getContext(), AddressUI.class);
                                intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                                AddressUIFragment.this.startActivity(intent4);
                                AppMethodBeat.o(33486);
                                return;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", str);
                            intent2.putExtra("Contact_Scene", 3);
                            intent2.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                            if (str != null && str.length() > 0) {
                                com.tencent.mm.bp.d.b(AddressUIFragment.this.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                            }
                            AppMethodBeat.o(33486);
                        }
                    }
                }
            });
            this.nIv.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33487);
                    ab.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(i)));
                    if (i < AddressUIFragment.this.nIv.getHeaderViewsCount()) {
                        ab.w("MicroMsg.AddressUI", "on item long click, but match header view");
                        AppMethodBeat.o(33487);
                        return true;
                    } else if (AddressUIFragment.this.zkc == null || !AddressUIFragment.this.zkc.zLy) {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) AddressUIFragment.this.zkb.getItem(i - AddressUIFragment.this.nIv.getHeaderViewsCount());
                        if (fVar == null) {
                            ab.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(AddressUIFragment.this.nIv.getHeaderViewsCount()));
                            AppMethodBeat.o(33487);
                            return true;
                        }
                        String str = fVar.field_username;
                        if (t.ny(str) || t.nz(str)) {
                            AppMethodBeat.o(33487);
                            return true;
                        }
                        AddressUIFragment.this.zke = str;
                        AddressUIFragment.this.jMO.a(view, i, j, AddressUIFragment.this, AddressUIFragment.this.lCi, AddressUIFragment.this.jLX, AddressUIFragment.this.jLY);
                        AppMethodBeat.o(33487);
                        return true;
                    } else {
                        AppMethodBeat.o(33487);
                        return true;
                    }
                }
            });
            this.nIv.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(33488);
                    switch (motionEvent.getAction()) {
                        case 0:
                            AddressUIFragment.this.hideVKB();
                            AddressUIFragment.this.jLX = (int) motionEvent.getRawX();
                            AddressUIFragment.this.jLY = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(33488);
                    return false;
                }
            });
            this.nIv.setOnScrollListener(this.ein);
            this.nIv.setDrawingCacheEnabled(false);
            this.zkg = (AlphabetScrollBar) findViewById(R.id.n6);
            this.zkg.setOnScrollBarTouchListener(this.zkw);
            aw.ZK();
            com.tencent.mm.model.c.XM().a(this.zkb);
            if (this.zkr != null) {
                z.aeR().a(this.zkr, null);
            }
            AppMethodBeat.o(33515);
        }

        public final void dvZ() {
            AppMethodBeat.i(33516);
            ab.v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            aw.ZK();
            if (currentTimeMillis - ah.d((Long) com.tencent.mm.model.c.Ry().get(340226, null)) >= 180000) {
                dHB();
            }
            if (this.zkt) {
                this.zkt = false;
                this.zks = false;
                dHz();
                this.nIv.setAdapter(this.zkb);
                this.nIv.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33497);
                        ab.i("MicroMsg.AddressUI", "post to first init finish");
                        View findViewById = AddressUIFragment.this.findViewById(R.id.ev4);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(AddressUIFragment.this.getContext(), R.anim.b6));
                        }
                        AppMethodBeat.o(33497);
                    }
                });
                this.zkc.qU(false);
            } else if (this.zks) {
                this.zks = false;
                com.tencent.mm.sdk.g.d.f(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33498);
                        Process.setThreadPriority(10);
                        AddressUIFragment.p(AddressUIFragment.this);
                        AppMethodBeat.o(33498);
                    }
                }, "AddressUI_updateUIData");
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
            aw.ZK();
            this.zki = ((Boolean) com.tencent.mm.model.c.Ry().get(12296, Boolean.FALSE)).booleanValue();
            if (this.zkf == 2) {
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(r.Yz());
                if (!(aoO == null || (com.tencent.mm.n.a.jh(aoO.field_type) && ah.isNullOrNil(aoO.field_conRemark) && ah.isNullOrNil(aoO.field_conRemarkPYFull) && ah.isNullOrNil(aoO.field_conRemarkPYShort)))) {
                    aoO.NB();
                    aoO.iz("");
                    aoO.iF("");
                    aoO.iG("");
                    aw.ZK();
                    com.tencent.mm.model.c.XM().b(r.Yz(), aoO);
                }
            }
            if (this.zkc != null) {
                this.zkc.onResume();
            }
            this.zkb.ygw = false;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33499);
                    AddressUIFragment.this.zkb.resume();
                    AppMethodBeat.o(33499);
                }
            });
            if (this.zkk != null) {
                this.zkk.setFrontGround(true);
                k.dHR();
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().setTitleBarDoubleClickListener(this.zky);
            }
            AppMethodBeat.o(33516);
        }

        private synchronized void dHA() {
            AppMethodBeat.i(33517);
            long currentTimeMillis = System.currentTimeMillis();
            dHz();
            ab.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.zkb != null) {
                ab.v("MicroMsg.AddressUI", "post to do refresh");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33494);
                        AddressUIFragment.this.zkb.dHy();
                        if (AddressUIFragment.this.zkq != null) {
                            AddressUIFragment.this.zkq.reset();
                            if (AddressUIFragment.this.zkq.getOpenIMCount() <= 0) {
                                AddressUIFragment.this.zkq.setVisibility(8);
                                AppMethodBeat.o(33494);
                                return;
                            }
                            AddressUIFragment.this.zkq.setVisibility(0);
                        }
                        AppMethodBeat.o(33494);
                    }
                });
            }
            if (this.zkc != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33496);
                        ab.v("MicroMsg.AddressUI", "post search adapter to do refresh");
                        AddressUIFragment.this.zkc.a(null, null);
                        AppMethodBeat.o(33496);
                    }
                });
            }
            ab.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(33517);
        }

        public final void dwa() {
        }

        public final void dwb() {
            AppMethodBeat.i(33518);
            ab.i("MicroMsg.AddressUI", "AddressUI on Pause");
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(340226, Long.valueOf(System.currentTimeMillis()));
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(12296, Boolean.valueOf(this.zki));
            if (this.zkc != null) {
                this.zkc.onPause();
            }
            this.zkb.dHx();
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(33501);
                    AddressUIFragment.this.zkb.pause();
                    AppMethodBeat.o(33501);
                }
            });
            if (this.zkk != null) {
                this.zkk.setFrontGround(false);
            }
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.getHomeUI().aw(this.zky);
            }
            AppMethodBeat.o(33518);
        }

        public final void dwc() {
        }

        public final void dwd() {
            AppMethodBeat.i(33519);
            ab.v("MicroMsg.AddressUI", "onDestory");
            if (this.zkg != null) {
                this.zkg.yAU = null;
            }
            aw.Rg().b(138, (f) this);
            if (this.zkb != null) {
                this.zkb.pB(true);
                this.zkb.detach();
                this.zkb.dww();
            }
            if (this.zkc != null) {
                this.zkc.detach();
                this.zkc.bIf();
            }
            if (aw.RK() && this.zkb != null) {
                aw.ZK();
                com.tencent.mm.model.c.XM().b(this.zkb);
            }
            if (aw.RK() && this.zkr != null) {
                z.aeR().a(this.zkr);
            }
            if (this.zkk != null) {
                k kVar = this.zkk;
                if (aw.RK()) {
                    com.tencent.mm.bi.d.akP().d(kVar.zmz);
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
            com.tencent.mm.sdk.b.a.xxA.d(this.ryK);
            AppMethodBeat.o(33519);
        }

        public final void dwf() {
            AppMethodBeat.i(33520);
            if (this.zkb != null) {
                a aVar = this.zkb;
                aVar.zjO.clear();
                aVar.zjM.clear();
                aVar.zjN = false;
            }
            ab.i("MicroMsg.INIT", "KEVIN Address turnTobg");
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
            AppMethodBeat.o(33520);
        }

        public final void dwg() {
            AppMethodBeat.i(33521);
            ab.v("MicroMsg.INIT", "KEVIN Address turnTofg");
            AppMethodBeat.o(33521);
        }

        public final void dwe() {
            AppMethodBeat.i(33522);
            ab.v("MicroMsg.AddressUI", "request to top");
            if (this.nIv != null) {
                BackwardSupportUtil.c.a(this.nIv);
            }
            AppMethodBeat.o(33522);
        }

        public final void dxc() {
            AppMethodBeat.i(33523);
            if (this.zkk != null) {
                k.dHR();
            }
            AppMethodBeat.o(33523);
        }

        public final void dxd() {
        }

        public final void dHB() {
            AppMethodBeat.i(33524);
            if (this.nIv != null) {
                this.nIv.setSelection(0);
            }
            AppMethodBeat.o(33524);
        }

        static /* synthetic */ void b(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(33525);
            addressUIFragment.zjZ.setVisibility(8);
            addressUIFragment.nIv.setVisibility(0);
            AppMethodBeat.o(33525);
        }

        static /* synthetic */ void c(AddressUIFragment addressUIFragment, String str) {
            AppMethodBeat.i(33527);
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(str);
            if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                Intent intent = new Intent();
                intent.setClass(addressUIFragment.getContext(), ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_User", aoO.field_username);
                intent.putExtra("view_mode", true);
                addressUIFragment.getContext().startActivity(intent);
            }
            AppMethodBeat.o(33527);
        }

        static /* synthetic */ void q(AddressUIFragment addressUIFragment) {
            AppMethodBeat.i(33529);
            LauncherUI launcherUI = (LauncherUI) addressUIFragment.getContext();
            if (launcherUI == null || launcherUI.yjJ.getMainTabUI().mbt == 1) {
                BackwardSupportUtil.c.a(addressUIFragment.nIv);
                new com.tencent.mm.sdk.platformtools.ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33489);
                        AddressUIFragment.this.nIv.setSelection(0);
                        AppMethodBeat.o(33489);
                    }
                }, 300);
            }
            AppMethodBeat.o(33529);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33530);
        super.onCreate(bundle);
        i supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(16908290) == null) {
            this.zjY = new AddressUIFragment();
            this.zjY.setArguments(getIntent().getExtras());
            supportFragmentManager.beginTransaction().a(16908290, this.zjY).commit();
        }
        AppMethodBeat.o(33530);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
