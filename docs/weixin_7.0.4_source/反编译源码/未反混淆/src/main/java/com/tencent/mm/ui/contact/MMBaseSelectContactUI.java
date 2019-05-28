package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.o;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, a, b, c, VerticalScrollBar.a, l, o.b {
    protected o elS;
    public MultiSelectContactView opo;
    private ListView pxq;
    private View qzN;
    protected int scene;
    private AlphabetScrollBar zmY;
    private o zmZ;
    public m zna;
    private com.tencent.mm.ui.base.o znb;
    private View znc;
    private View znd;
    private TextView zne;
    private LabelContainerView znf;
    private TextView zng;
    private MMTagPanel znh;
    private boolean zni = true;
    private List<String> znj = new ArrayList();

    public abstract m aoA();

    public abstract boolean aow();

    public abstract boolean aox();

    public abstract String aoy();

    public abstract o aoz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ab.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (g.RK()) {
            Kh();
            ab.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
            initView();
            ab.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
            return;
        }
        ab.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        ab.dou();
        finish();
    }

    public final n dHV() {
        if (getContentLV().getHeaderViewsCount() > 0) {
            return (n) ((HeaderViewListAdapter) getContentLV().getAdapter()).getWrappedAdapter();
        }
        return (n) getContentLV().getAdapter();
    }

    public ListView getContentLV() {
        return this.pxq;
    }

    public o dHW() {
        return this.zmZ;
    }

    /* Access modifiers changed, original: protected */
    public void Kh() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void initView() {
        setMMTitle(aoy());
        this.pxq = (ListView) findViewById(R.id.iu);
        this.zmZ = aoz();
        this.zna = aoA();
        this.qzN = findViewById(R.id.iw);
        if (dId()) {
            this.znd = findViewById(R.id.j0);
            this.zne = (TextView) findViewById(R.id.j1);
            this.znd.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(105214);
                    MMBaseSelectContactUI.this.dIa();
                    MMBaseSelectContactUI.this.dIb();
                    MMBaseSelectContactUI.this.dIc();
                    AppMethodBeat.o(105214);
                    return false;
                }
            });
            if (aow()) {
                this.elS = new o((byte) 0);
                this.elS.zHa = this;
                a(this.elS);
            } else {
                this.opo = (MultiSelectContactView) findViewById(R.id.iv);
                this.opo.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, j.INVALID_ID), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, j.INVALID_ID));
                this.opo.setOnSearchTextChangeListener(this);
                this.opo.setOnSearchTextFouceChangeListener(this);
                this.opo.setOnContactDeselectListener(this);
                this.opo.setVisibility(0);
                this.znc = new View(this.mController.ylL);
                this.znc.setLayoutParams(new LayoutParams(-1, this.opo.getMeasuredHeight()));
                this.znc.setVisibility(4);
                this.pxq.addHeaderView(this.znc);
                findViewById(R.id.it).setVisibility(0);
            }
        }
        a(this.pxq, 0);
        this.pxq.setAdapter(this.zmZ);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(105215);
                MMBaseSelectContactUI.this.bMQ();
                AppMethodBeat.o(105215);
                return true;
            }
        });
        if (this.zna != null) {
            this.zna.a(new m.a() {
                public final void w(String str, int i, boolean z) {
                    AppMethodBeat.i(105216);
                    ab.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", Integer.valueOf(i));
                    if (!z || i != 0) {
                        MMBaseSelectContactUI.c(MMBaseSelectContactUI.this);
                        AppMethodBeat.o(105216);
                    } else if (bo.isNullOrNil(str)) {
                        MMBaseSelectContactUI.this.dIa();
                        AppMethodBeat.o(105216);
                    } else {
                        MMBaseSelectContactUI.b(MMBaseSelectContactUI.this);
                        AppMethodBeat.o(105216);
                    }
                }
            });
        }
        this.pxq.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(105217);
                if (i != 0) {
                    MMBaseSelectContactUI.this.aqX();
                    MMBaseSelectContactUI.this.dIc();
                }
                AppMethodBeat.o(105217);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(105218);
                if (!(MMBaseSelectContactUI.this.aow() || MMBaseSelectContactUI.this.opo == null)) {
                    View childAt = MMBaseSelectContactUI.this.pxq.getChildAt(MMBaseSelectContactUI.this.pxq.getFirstVisiblePosition());
                    if (childAt == null || childAt.getTop() != 0) {
                        MMBaseSelectContactUI.this.qzN.setVisibility(0);
                    } else {
                        MMBaseSelectContactUI.this.qzN.setVisibility(8);
                    }
                }
                if (i < 2) {
                    AppMethodBeat.o(105218);
                    return;
                }
                g.RQ();
                if (!bo.e((Boolean) g.RP().Ry().get(12296, null))) {
                    g.RQ();
                    g.RP().Ry().set(12296, Boolean.TRUE);
                    if (MMBaseSelectContactUI.this.znb != null) {
                        MMBaseSelectContactUI.this.znb.dismiss();
                    }
                    MMBaseSelectContactUI.this.znb = t.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(R.string.cw9), 4000);
                }
                AppMethodBeat.o(105218);
            }
        });
        this.pxq.setOnItemClickListener(this);
        if (aox()) {
            this.zmY = (AlphabetScrollBar) findViewById(R.id.ix);
            this.zmY.setVisibility(0);
            this.zmY.setOnScrollBarTouchListener(this);
        }
        if (bOd()) {
            this.znf = (LabelContainerView) findViewById(R.id.iy);
            this.zng = (TextView) this.znf.findViewById(16908310);
            this.zng.setText(R.string.e18);
            this.znh = (MMTagPanel) this.znf.findViewById(R.id.iz);
            this.znh.setTagSelectedBG(R.drawable.a31);
            this.znh.setTagSelectedTextColorRes(R.color.w4);
            this.znf.setOnLabelContainerListener(new LabelContainerView.a() {
                public final void bmk() {
                    AppMethodBeat.i(105219);
                    if (MMBaseSelectContactUI.this.opo != null) {
                        MMBaseSelectContactUI.this.opo.clearFocus();
                    }
                    if (MMBaseSelectContactUI.this.elS != null) {
                        MMBaseSelectContactUI.this.elS.clearFocus();
                        MMBaseSelectContactUI.this.elS.dJS();
                    }
                    MMBaseSelectContactUI.this.znf.requestFocus();
                    MMBaseSelectContactUI.this.znf.setVisibility(8);
                    AppMethodBeat.o(105219);
                }

                public final void bml() {
                    AppMethodBeat.i(105220);
                    MMBaseSelectContactUI.this.aqX();
                    AppMethodBeat.o(105220);
                }
            });
            this.znh.setCallBack(new MMTagPanel.a() {
                public final void JR(String str) {
                }

                public final void JS(String str) {
                    AppMethodBeat.i(105221);
                    MMBaseSelectContactUI.this.QA(str);
                    AppMethodBeat.o(105221);
                }

                public final void JT(String str) {
                }

                public final void q(boolean z, int i) {
                }

                public final void bmm() {
                }

                public final void JU(String str) {
                }

                public final void JV(String str) {
                }
            });
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            com.tencent.mm.ui.contact.a.a Pn = dHV().getItem(headerViewsCount);
            Pn.aou().aov();
            if (Pn.eDk) {
                headerViewsCount = Pn.mFr;
                int i2 = Pn.mFs;
                if (Pn.bAv()) {
                    headerViewsCount = 15;
                } else if (headerViewsCount == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    switch (i2) {
                        case 1:
                            headerViewsCount = 1;
                            break;
                        case 2:
                            headerViewsCount = 2;
                            break;
                        case 3:
                            headerViewsCount = 3;
                            break;
                        case 4:
                            headerViewsCount = 4;
                            break;
                        case 5:
                            headerViewsCount = 5;
                            break;
                        case 6:
                            headerViewsCount = 6;
                            break;
                        case 7:
                            headerViewsCount = 7;
                            break;
                        case 11:
                            headerViewsCount = 8;
                            break;
                        case 15:
                            headerViewsCount = 16;
                            break;
                        case 16:
                            headerViewsCount = 10;
                            break;
                        case 17:
                        case 18:
                            headerViewsCount = 9;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else if (headerViewsCount == 131075) {
                    switch (i2) {
                        case 1:
                        case 5:
                            headerViewsCount = 12;
                            break;
                        case 2:
                        case 6:
                            headerViewsCount = 13;
                            break;
                        case 3:
                        case 7:
                            headerViewsCount = 14;
                            break;
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                        case 38:
                            headerViewsCount = 11;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else {
                    headerViewsCount = headerViewsCount == 65536 ? 17 : 0;
                }
                switch (Pn.mFr) {
                    case 65536:
                        i2 = 5;
                        break;
                    case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                        i2 = 2;
                        break;
                    case 131075:
                        i2 = 3;
                        break;
                    case 131076:
                        i2 = 4;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                if (Pn.zpC) {
                    i2 = 1;
                }
                if (Pn.klY == 5) {
                    i2 = 7;
                }
                ab.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{Pn.query, Integer.valueOf(Pn.scene), Integer.valueOf(i2), Integer.valueOf(Pn.mFm), Integer.valueOf(headerViewsCount)}));
                h.pYm.X(13234, r0);
            }
        }
        if (!dHV().Po(i)) {
            mO(i);
        }
    }

    public void mO(int i) {
    }

    private String dHX() {
        if (this.elS != null) {
            return this.elS.getSearchContent();
        }
        if (this.opo != null) {
            return this.opo.getSearchContent();
        }
        return "";
    }

    private void dHY() {
        boolean dJs = this.elS != null ? this.elS.dJs() : this.opo != null ? this.opo.hasFocus() : false;
        if (dJs && bo.isNullOrNil(dHX())) {
            if (this.znj == null || this.znj.size() <= 0) {
                this.znf.setVisibility(8);
                return;
            }
            this.znf.setVisibility(0);
            this.znh.a(null, this.znj);
        } else if (this.znf != null) {
            this.znf.setVisibility(8);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.znb != null) {
            this.znb.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        if (bOd() && this.zni) {
            this.zni = false;
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(105223);
                    MMBaseSelectContactUI.this.znj = com.tencent.mm.plugin.label.a.a.bJa().bIV();
                    MMBaseSelectContactUI.this.zni = true;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105222);
                            MMBaseSelectContactUI.this.dHY();
                            AppMethodBeat.o(105222);
                        }
                    });
                    AppMethodBeat.o(105223);
                }

                public final String toString() {
                    AppMethodBeat.i(105224);
                    String str = super.toString() + "|updateLabelList";
                    AppMethodBeat.o(105224);
                    return str;
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.zmY != null) {
            this.zmY.yAU = null;
        }
        if (this.zmZ != null) {
            this.zmZ.finish();
        }
        if (this.zna != null) {
            this.zna.finish();
        }
        if (this.znb != null) {
            this.znb.dismiss();
        }
    }

    public int getLayoutId() {
        return R.layout.agi;
    }

    public final void Qa(String str) {
        ab.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", str);
        if (bOd()) {
            dHY();
        }
        if (this.zna == null) {
            return;
        }
        if (bo.isNullOrNil(str)) {
            this.zna.clearData();
            this.zna.notifyDataSetChanged();
            dIa();
            return;
        }
        this.zna.a(str, bMP(), dHZ());
    }

    public final void dji() {
        if (bOd()) {
            dHY();
        }
    }

    public int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131081};
    }

    /* Access modifiers changed, original: protected */
    public void a(ListView listView, int i) {
    }

    public void bMQ() {
        aqX();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            bMQ();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void kp(String str) {
        if (this.zmZ != null) {
            int arM = this.zmZ.arM(str);
            if (arM == 0) {
                this.pxq.setSelection(0);
            } else if (arM <= 0) {
                ab.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", Integer.valueOf(arM), str);
            } else if (aow()) {
                this.pxq.setSelection(arM);
            } else if (this.opo != null) {
                this.pxq.setSelectionFromTop(arM, this.opo.getMeasuredHeight());
            }
        }
    }

    public final boolean vN(String str) {
        return false;
    }

    public final void vO(String str) {
        ab.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", str);
        if (bOd()) {
            if (this.elS != null) {
                this.elS.dJt();
            }
            dHY();
        }
        if (bo.isNullOrNil(str)) {
            this.zna.clearData();
            this.zna.notifyDataSetChanged();
            dIa();
            return;
        }
        this.zna.a(str, bMP(), dHZ());
    }

    /* Access modifiers changed, original: protected */
    public boolean dHZ() {
        return false;
    }

    public final void apo() {
        dIa();
        if (bOd()) {
            dHY();
        }
    }

    public final void app() {
    }

    private void dIa() {
        ab.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.pxq, 0);
        this.pxq.setAdapter(this.zmZ);
        this.zmZ.notifyDataSetChanged();
        if (aox() && this.zmY != null) {
            this.zmY.setVisibility(0);
        }
        this.znd.setVisibility(8);
    }

    public void vI(String str) {
    }

    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public Activity getActivity() {
        return this;
    }

    /* Access modifiers changed, original: protected */
    public boolean bOd() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void QA(String str) {
        ab.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dIb() {
        if (this.elS != null) {
            if (!bo.isNullOrNil(this.elS.getSearchContent())) {
                o oVar = this.elS;
                if (oVar.zGZ != null) {
                    oVar.zGZ.qO(true);
                }
            }
        } else if (this.opo != null && !bo.isNullOrNil(this.opo.getSearchContent())) {
            this.opo.vhY.setText("");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dIc() {
        if (this.elS != null) {
            if (this.elS.dJs()) {
                this.elS.clearFocus();
            }
        } else if (this.opo != null && this.opo.hasFocus()) {
            this.opo.clearFocus();
        }
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public boolean dId() {
        return this.zna != null;
    }

    static /* synthetic */ void c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        ab.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.pxq, 8);
        mMBaseSelectContactUI.pxq.setAdapter(mMBaseSelectContactUI.zna);
        mMBaseSelectContactUI.zna.notifyDataSetChanged();
        if (mMBaseSelectContactUI.aox() && mMBaseSelectContactUI.zmY != null) {
            mMBaseSelectContactUI.zmY.setVisibility(8);
        }
        mMBaseSelectContactUI.znd.setVisibility(8);
    }
}
