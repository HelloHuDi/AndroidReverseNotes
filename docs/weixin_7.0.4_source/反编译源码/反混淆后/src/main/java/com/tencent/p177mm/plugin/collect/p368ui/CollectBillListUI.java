package com.tencent.p177mm.plugin.collect.p368ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5262g;
import com.tencent.p177mm.plugin.collect.model.C38805h;
import com.tencent.p177mm.plugin.collect.model.C38807q;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI */
public class CollectBillListUI extends WalletBaseUI {
    private Dialog gII;
    private int kCD = 0;
    private boolean kFA = true;
    private boolean kFB = false;
    private boolean kFC = false;
    private long kFD = 0;
    private long kFE = 0;
    private Calendar kFF;
    private List<C38805h> kFG = new ArrayList();
    private ListView kFo;
    private C33883b kFp;
    private LinearLayout kFq;
    private CollectPullDownView kFr;
    private TextView kFs;
    private Dialog kFt;
    private boolean kFu = false;
    private boolean kFv = false;
    private boolean kFw = false;
    private boolean kFx = false;
    private boolean kFy = false;
    private boolean kFz = false;
    private View kmT;
    private int limit = 20;
    private int retryCount = 0;
    private int type = 0;

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$8 */
    class C28418 implements OnScrollListener {
        C28418() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$9 */
    class C28429 implements C5260d {
        C28429() {
        }

        public final boolean bhl() {
            AppMethodBeat.m2504i(41192);
            int firstVisiblePosition = CollectBillListUI.this.kFo.getFirstVisiblePosition();
            if (firstVisiblePosition == 0) {
                View childAt = CollectBillListUI.this.kFo.getChildAt(firstVisiblePosition);
                if (childAt != null && childAt.getX() == 0.0f) {
                    AppMethodBeat.m2505o(41192);
                    return true;
                }
            }
            AppMethodBeat.m2505o(41192);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$11 */
    class C1144911 implements C5262g {
        C1144911() {
        }

        public final boolean bhn() {
            AppMethodBeat.m2504i(41194);
            C4990ab.m7410d("MicroMsg.CollectBillListUI", "top load");
            AppMethodBeat.m2505o(41194);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$7 */
    class C114507 implements OnItemClickListener {
        C114507() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(41191);
            C4990ab.m7411d("MicroMsg.CollectBillListUI", "click item: %d", Integer.valueOf(i));
            if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                AppMethodBeat.m2505o(41191);
                return;
            }
            Intent intent = new Intent(CollectBillListUI.this.mController.ylL, CollectBillUI.class);
            C38805h c38805h = (C38805h) adapterView.getItemAtPosition(i);
            if (c38805h == null) {
                C4990ab.m7421w("MicroMsg.CollectBillListUI", "invaild record: %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(41191);
                return;
            }
            intent.putExtra("key_type", c38805h.type);
            intent.putExtra("key_timestamp", c38805h.kCc);
            intent.putExtra("key_from_scene", 2);
            CollectBillListUI.this.startActivity(intent);
            C7060h.pYm.mo8381e(13944, Integer.valueOf(3));
            AppMethodBeat.m2505o(41191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$10 */
    class C2769110 implements C5258c {
        C2769110() {
        }

        public final boolean bhm() {
            AppMethodBeat.m2504i(41193);
            if (CollectBillListUI.this.kFq.getVisibility() == 0) {
                C4990ab.m7410d("MicroMsg.CollectBillListUI", "empty view");
                AppMethodBeat.m2505o(41193);
                return true;
            }
            View childAt = CollectBillListUI.this.kFo.getChildAt(CollectBillListUI.this.kFo.getChildCount() - 1);
            if (childAt == null || childAt.getBottom() > CollectBillListUI.this.kFo.getHeight() || CollectBillListUI.this.kFo.getLastVisiblePosition() != CollectBillListUI.this.kFo.getAdapter().getCount() - 1) {
                AppMethodBeat.m2505o(41193);
                return false;
            }
            AppMethodBeat.m2505o(41193);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$1 */
    class C276921 implements OnMenuItemClickListener {
        C276921() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41186);
            CollectBillListUI.m65854a(CollectBillListUI.this);
            AppMethodBeat.m2505o(41186);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$5 */
    class C338705 implements OnClickListener {
        C338705() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41189);
            CollectBillListUI.this.kFt.dismiss();
            AppMethodBeat.m2505o(41189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$2 */
    class C388112 implements C5257e {
        C388112() {
        }

        public final boolean bhk() {
            AppMethodBeat.m2504i(41187);
            C4990ab.m7411d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", Boolean.valueOf(CollectBillListUI.this.kFw), Boolean.valueOf(CollectBillListUI.this.kFz));
            if (CollectBillListUI.this.kFw || CollectBillListUI.this.kFz) {
                AppMethodBeat.m2505o(41187);
                return true;
            }
            CollectBillListUI.m65864i(CollectBillListUI.this);
            CollectBillListUI.m65865j(CollectBillListUI.this);
            AppMethodBeat.m2505o(41187);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillListUI$3 */
    class C388133 implements OnCancelListener {
        C388133() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CollectBillListUI() {
        AppMethodBeat.m2504i(41195);
        AppMethodBeat.m2505o(41195);
    }

    /* renamed from: j */
    static /* synthetic */ void m65865j(CollectBillListUI collectBillListUI) {
        AppMethodBeat.m2504i(41209);
        collectBillListUI.bhi();
        AppMethodBeat.m2505o(41209);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41196);
        super.onCreate(bundle);
        initView();
        setMMTitle((int) C25738R.string.arh);
        if (this.kFC) {
            addIconOptionMenu(0, C1318a.collect_bill_filter_icon, new C276921());
        }
        this.gII = C30901g.m49317a((Context) this, false, new C388133());
        bhi();
        C7060h.pYm.mo8381e(13944, Integer.valueOf(4));
        AppMethodBeat.m2505o(41196);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41197);
        this.kFo = (ListView) findViewById(2131822833);
        this.kFq = (LinearLayout) findViewById(2131822834);
        this.kFs = (TextView) findViewById(2131822835);
        this.kmT = C5616v.m8409hu(this).inflate(2130969156, this.kFo, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, C1338a.fromDPToPix(this, 5)));
        this.kFo.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, C1338a.fromDPToPix(this, 10)));
        this.kFo.addFooterView(view, null, true);
        this.kFo.setOverScrollMode(2);
        this.kFp = new C33883b(this);
        this.kFo.setAdapter(this.kFp);
        this.kFo.setOnItemClickListener(new C114507());
        this.kFo.setOnScrollListener(new C28418());
        this.kFr = (CollectPullDownView) findViewById(2131822832);
        bhj();
        AppMethodBeat.m2505o(41197);
    }

    public final int getLayoutId() {
        return 2130969154;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41198);
        if (c1207m instanceof C38807q) {
            C38807q c38807q = (C38807q) c1207m;
            if (this.gII.isShowing()) {
                this.gII.dismiss();
            }
            this.kFr.setLoadDataEnd(true);
            if (i == 0 && i2 == 0) {
                C33883b c33883b;
                if (c38807q.kCD != 0) {
                    this.kFz = c38807q.foa;
                    if (c38807q.isRetry) {
                        if (!c38807q.kCH.isEmpty()) {
                            this.kFG.addAll(c38807q.kCH);
                        }
                        if (c38807q.kCF != 0 || c38807q.kCG <= 0) {
                            this.retryCount = 0;
                            this.kFA = true;
                            this.kFE = c38807q.kCc;
                            if (c38807q.kCF == 0) {
                                this.kFz = false;
                            } else {
                                this.kFz = true;
                            }
                            if (this.kFG.size() > 0) {
                                this.kFp.setData(this.kFG);
                            } else {
                                C4990ab.m7416i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                                aEL();
                                if (!C5046bo.isNullOrNil(c38807q.hwA)) {
                                    this.kFs.setText(c38807q.hwA);
                                    this.kFs.setVisibility(0);
                                }
                                c33883b = this.kFp;
                                c33883b.kFl.clear();
                                c33883b.notifyDataSetChanged();
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            m65853a(c38807q.kCG, c38807q.kCc, c38807q.kCE, c38807q.kCD);
                        }
                        AppMethodBeat.m2505o(41198);
                        return true;
                    }
                    if (!c38807q.kCH.isEmpty()) {
                        this.kFp.setData(c38807q.kCH);
                        this.kFD = ((C38805h) c38807q.kCH.get(0)).kCc;
                        this.kFE = ((C38805h) c38807q.kCH.get(c38807q.kCH.size() - 1)).kCc;
                    } else if (c38807q.kCF != 0 || c38807q.kCG <= 0) {
                        aEL();
                    } else {
                        C4990ab.m7417i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(c38807q.kCG), Long.valueOf(c38807q.kCc));
                        m65853a(c38807q.kCG, c38807q.kCc, c38807q.kCE, c38807q.kCD);
                        this.kFG.clear();
                    }
                    this.kFy = false;
                    this.kFA = false;
                } else if (this.kFy) {
                    C4990ab.m7416i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                    AppMethodBeat.m2505o(41198);
                    return true;
                } else if (c38807q.kCE == 1) {
                    this.kFA = c38807q.foa;
                    if (c38807q.kCH.isEmpty()) {
                        this.kFA = true;
                    } else {
                        c33883b = this.kFp;
                        c33883b.kFl.addAll(0, c38807q.kCH);
                        c33883b.notifyDataSetChanged();
                        this.kFD = ((C38805h) c38807q.kCH.get(0)).kCc;
                    }
                    this.kFx = false;
                    this.kFv = false;
                } else {
                    this.kFz = c38807q.foa;
                    this.kFo.setVisibility(0);
                    this.kFq.setVisibility(8);
                    if (c38807q.isRetry) {
                        if (!c38807q.kCH.isEmpty()) {
                            this.kFG.addAll(c38807q.kCH);
                        }
                        if (c38807q.kCF == 0 && c38807q.kCG > 0 && c38807q.kCH.isEmpty()) {
                            C4990ab.m7417i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            m65853a(c38807q.kCG, c38807q.kCc, c38807q.kCE, c38807q.kCD);
                        } else {
                            this.retryCount = 0;
                            if (this.kFG.size() > 0) {
                                this.kFp.mo54429bp(this.kFG);
                            } else {
                                C4990ab.m7416i("MicroMsg.CollectBillListUI", "retry data is empty");
                                m65850Ic(c38807q.hwA);
                            }
                            this.kFw = false;
                            this.kFE = c38807q.kCc;
                            bhh();
                            m65861fW(this.kFz);
                        }
                        AppMethodBeat.m2505o(41198);
                        return true;
                    } else if (!c38807q.kCH.isEmpty()) {
                        this.kFp.mo54429bp(c38807q.kCH);
                        this.kFE = ((C38805h) c38807q.kCH.get(c38807q.kCH.size() - 1)).kCc;
                        if (this.kFE > c38807q.kCc) {
                            C4990ab.m7410d("MicroMsg.CollectBillListUI", "use from_timestamp");
                            this.kFE = c38807q.kCc;
                        } else {
                            C4990ab.m7417i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", Long.valueOf(this.kFE), Long.valueOf(c38807q.kCc));
                        }
                        this.kFw = false;
                        bhh();
                        m65861fW(this.kFz);
                    } else if (c38807q.kCF != 0 || c38807q.kCG <= 0) {
                        this.kFw = false;
                        bhh();
                        C4990ab.m7416i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                        m65850Ic(c38807q.hwA);
                        m65861fW(this.kFz);
                    } else {
                        C4990ab.m7417i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(c38807q.kCG), Long.valueOf(c38807q.kCc));
                        m65853a(c38807q.kCG, c38807q.kCc, c38807q.kCE, c38807q.kCD);
                        this.kFG.clear();
                    }
                }
                AppMethodBeat.m2505o(41198);
                return true;
            }
            C4990ab.m7417i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c38807q.kCD), Integer.valueOf(c38807q.kCE));
            if (c38807q.kCD != 0) {
                this.kFy = false;
            } else if (c38807q.kCE == 0) {
                this.kFw = false;
                bhh();
            } else {
                this.kFx = false;
            }
            if (this.kFp.isEmpty()) {
                aEL();
            }
            Toast.makeText(this, C25738R.string.are, 1).show();
            AppMethodBeat.m2505o(41198);
            return true;
        }
        AppMethodBeat.m2505o(41198);
        return false;
    }

    private void bhh() {
        AppMethodBeat.m2504i(41199);
        this.kFr.scrollTo(0, this.kFr.getTopHeight());
        AppMethodBeat.m2505o(41199);
    }

    private void aEL() {
        AppMethodBeat.m2504i(41200);
        this.kFo.setVisibility(8);
        this.kFq.setVisibility(0);
        this.kFs.setVisibility(0);
        AppMethodBeat.m2505o(41200);
    }

    /* renamed from: Ic */
    private void m65850Ic(String str) {
        AppMethodBeat.m2504i(41201);
        if (this.kFp.getCount() == 0) {
            C4990ab.m7416i("MicroMsg.CollectBillListUI", "show empty view");
            if (!C5046bo.isNullOrNil(str)) {
                this.kFs.setText(str);
            } else if (this.kFz) {
                this.kFs.setText(getString(C25738R.string.arf));
            } else {
                this.kFs.setText(getString(C25738R.string.arf) + getString(C25738R.string.arg));
            }
            aEL();
            AppMethodBeat.m2505o(41201);
            return;
        }
        if (!C5046bo.isNullOrNil(str)) {
            Toast.makeText(this.mController.ylL, str, 1).show();
        }
        AppMethodBeat.m2505o(41201);
    }

    /* renamed from: fW */
    private void m65861fW(boolean z) {
        AppMethodBeat.m2504i(41202);
        this.kFr.setBottomViewVisible(!z);
        AppMethodBeat.m2505o(41202);
    }

    private void bhi() {
        AppMethodBeat.m2504i(41203);
        int count = this.kFp.getCount();
        if (count > 0) {
            long j = this.kFp.mo54435tI(count - 1).kCc;
            if (j < this.kFE) {
                C4990ab.m7417i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", Long.valueOf(j), Long.valueOf(this.kFE));
                this.kFE = j;
            }
        }
        C4990ab.m7417i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", Integer.valueOf(this.type), Long.valueOf(this.kFE));
        mo39970a(new C38807q(this.type, this.kFE, this.limit, 0), false, false);
        this.kFw = true;
        AppMethodBeat.m2505o(41203);
    }

    /* renamed from: a */
    private void m65853a(int i, long j, int i2, int i3) {
        AppMethodBeat.m2504i(41204);
        C4990ab.m7417i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        mo39970a(new C38807q(this.type, j, i2, this.limit, i3, i), false, false);
        this.retryCount++;
        AppMethodBeat.m2505o(41204);
    }

    private void bhj() {
        AppMethodBeat.m2504i(41205);
        this.kFr.setTopViewVisible(false);
        this.kFr.setIsTopShowAll(false);
        this.kFr.setBottomViewVisible(true);
        this.kFr.setIsBottomShowAll(false);
        this.kFr.setCanOverScrool(true);
        this.kFr.setAtTopCallBack(new C28429());
        this.kFr.setAtBottomCallBack(new C2769110());
        this.kFr.setOnTopLoadDataListener(new C1144911());
        this.kFr.setOnBottomLoadDataListener(new C388112());
        AppMethodBeat.m2505o(41205);
    }

    /* renamed from: a */
    static /* synthetic */ void m65854a(CollectBillListUI collectBillListUI) {
        AppMethodBeat.m2504i(41206);
        if (collectBillListUI.kFt == null) {
            collectBillListUI.kFt = new C17391c(collectBillListUI);
            final DatePickerDialogView datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.setDatePickerMode(collectBillListUI.type);
            collectBillListUI.kFt.setContentView(datePickerDialogView);
            datePickerDialogView.setOnOkBtnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    long timeInMillis;
                    AppMethodBeat.m2504i(41188);
                    if (CollectBillListUI.this.kFF == null) {
                        CollectBillListUI.this.kFF = Calendar.getInstance();
                    }
                    CollectBillListUI.this.kFF.clear();
                    int year = datePickerDialogView.getYear();
                    int month = datePickerDialogView.getMonth();
                    int dayOfMonth = datePickerDialogView.getDayOfMonth();
                    CollectBillListUI.this.type = datePickerDialogView.getDatePickerMode();
                    if (CollectBillListUI.this.type == 2) {
                        CollectBillListUI.this.kFF.set(1, year);
                        timeInMillis = CollectBillListUI.this.kFF.getTimeInMillis() / 1000;
                    } else if (CollectBillListUI.this.type == 1) {
                        CollectBillListUI.this.kFF.set(1, year);
                        CollectBillListUI.this.kFF.set(2, month);
                        timeInMillis = CollectBillListUI.this.kFF.getTimeInMillis() / 1000;
                    } else {
                        CollectBillListUI.this.kFF.set(year, month, dayOfMonth);
                        timeInMillis = CollectBillListUI.this.kFF.getTimeInMillis() / 1000;
                    }
                    C4990ab.m7417i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.this.type), Long.valueOf(timeInMillis));
                    CollectBillListUI.m65855a(CollectBillListUI.this, timeInMillis);
                    CollectBillListUI.this.kFt.dismiss();
                    AppMethodBeat.m2505o(41188);
                }
            });
            datePickerDialogView.setOnCancelBtnClickListener(new C338705());
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.kFt.getWindow().addFlags(C8415j.INVALID_ID);
            }
            final BottomSheetBehavior j = BottomSheetBehavior.m38322j((View) datePickerDialogView.getParent());
            j.f4913nj = false;
            j.setState(3);
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(41190);
                    C4990ab.m7411d("MicroMsg.CollectBillListUI", "view height: %d", Integer.valueOf(datePickerDialogView.getHeight()));
                    j.mo41462K(datePickerDialogView.getHeight());
                    AppMethodBeat.m2505o(41190);
                }
            }, 300);
        }
        collectBillListUI.kFt.show();
        AppMethodBeat.m2505o(41206);
    }

    /* renamed from: i */
    static /* synthetic */ void m65864i(CollectBillListUI collectBillListUI) {
        AppMethodBeat.m2504i(41208);
        collectBillListUI.kFr.setBottomViewVisible(true);
        AppMethodBeat.m2505o(41208);
    }
}
