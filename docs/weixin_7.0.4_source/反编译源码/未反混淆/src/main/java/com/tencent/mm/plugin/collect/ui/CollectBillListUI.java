package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.plugin.collect.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private Dialog gII;
    private int kCD = 0;
    private boolean kFA = true;
    private boolean kFB = false;
    private boolean kFC = false;
    private long kFD = 0;
    private long kFE = 0;
    private Calendar kFF;
    private List<h> kFG = new ArrayList();
    private ListView kFo;
    private b kFp;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectBillListUI() {
        AppMethodBeat.i(41195);
        AppMethodBeat.o(41195);
    }

    static /* synthetic */ void j(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(41209);
        collectBillListUI.bhi();
        AppMethodBeat.o(41209);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41196);
        super.onCreate(bundle);
        initView();
        setMMTitle((int) R.string.arh);
        if (this.kFC) {
            addIconOptionMenu(0, R.raw.collect_bill_filter_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(41186);
                    CollectBillListUI.a(CollectBillListUI.this);
                    AppMethodBeat.o(41186);
                    return false;
                }
            });
        }
        this.gII = g.a((Context) this, false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        bhi();
        com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(4));
        AppMethodBeat.o(41196);
    }

    public final void initView() {
        AppMethodBeat.i(41197);
        this.kFo = (ListView) findViewById(R.id.axv);
        this.kFq = (LinearLayout) findViewById(R.id.axw);
        this.kFs = (TextView) findViewById(R.id.axx);
        this.kmT = v.hu(this).inflate(R.layout.ox, this.kFo, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 5)));
        this.kFo.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 10)));
        this.kFo.addFooterView(view, null, true);
        this.kFo.setOverScrollMode(2);
        this.kFp = new b(this);
        this.kFo.setAdapter(this.kFp);
        this.kFo.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(41191);
                ab.d("MicroMsg.CollectBillListUI", "click item: %d", Integer.valueOf(i));
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    AppMethodBeat.o(41191);
                    return;
                }
                Intent intent = new Intent(CollectBillListUI.this.mController.ylL, CollectBillUI.class);
                h hVar = (h) adapterView.getItemAtPosition(i);
                if (hVar == null) {
                    ab.w("MicroMsg.CollectBillListUI", "invaild record: %d", Integer.valueOf(i));
                    AppMethodBeat.o(41191);
                    return;
                }
                intent.putExtra("key_type", hVar.type);
                intent.putExtra("key_timestamp", hVar.kCc);
                intent.putExtra("key_from_scene", 2);
                CollectBillListUI.this.startActivity(intent);
                com.tencent.mm.plugin.report.service.h.pYm.e(13944, Integer.valueOf(3));
                AppMethodBeat.o(41191);
            }
        });
        this.kFo.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kFr = (CollectPullDownView) findViewById(R.id.axu);
        bhj();
        AppMethodBeat.o(41197);
    }

    public final int getLayoutId() {
        return R.layout.ov;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41198);
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            if (this.gII.isShowing()) {
                this.gII.dismiss();
            }
            this.kFr.setLoadDataEnd(true);
            if (i == 0 && i2 == 0) {
                b bVar;
                if (qVar.kCD != 0) {
                    this.kFz = qVar.foa;
                    if (qVar.isRetry) {
                        if (!qVar.kCH.isEmpty()) {
                            this.kFG.addAll(qVar.kCH);
                        }
                        if (qVar.kCF != 0 || qVar.kCG <= 0) {
                            this.retryCount = 0;
                            this.kFA = true;
                            this.kFE = qVar.kCc;
                            if (qVar.kCF == 0) {
                                this.kFz = false;
                            } else {
                                this.kFz = true;
                            }
                            if (this.kFG.size() > 0) {
                                this.kFp.setData(this.kFG);
                            } else {
                                ab.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                                aEL();
                                if (!bo.isNullOrNil(qVar.hwA)) {
                                    this.kFs.setText(qVar.hwA);
                                    this.kFs.setVisibility(0);
                                }
                                bVar = this.kFp;
                                bVar.kFl.clear();
                                bVar.notifyDataSetChanged();
                            }
                        } else {
                            ab.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            a(qVar.kCG, qVar.kCc, qVar.kCE, qVar.kCD);
                        }
                        AppMethodBeat.o(41198);
                        return true;
                    }
                    if (!qVar.kCH.isEmpty()) {
                        this.kFp.setData(qVar.kCH);
                        this.kFD = ((h) qVar.kCH.get(0)).kCc;
                        this.kFE = ((h) qVar.kCH.get(qVar.kCH.size() - 1)).kCc;
                    } else if (qVar.kCF != 0 || qVar.kCG <= 0) {
                        aEL();
                    } else {
                        ab.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(qVar.kCG), Long.valueOf(qVar.kCc));
                        a(qVar.kCG, qVar.kCc, qVar.kCE, qVar.kCD);
                        this.kFG.clear();
                    }
                    this.kFy = false;
                    this.kFA = false;
                } else if (this.kFy) {
                    ab.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                    AppMethodBeat.o(41198);
                    return true;
                } else if (qVar.kCE == 1) {
                    this.kFA = qVar.foa;
                    if (qVar.kCH.isEmpty()) {
                        this.kFA = true;
                    } else {
                        bVar = this.kFp;
                        bVar.kFl.addAll(0, qVar.kCH);
                        bVar.notifyDataSetChanged();
                        this.kFD = ((h) qVar.kCH.get(0)).kCc;
                    }
                    this.kFx = false;
                    this.kFv = false;
                } else {
                    this.kFz = qVar.foa;
                    this.kFo.setVisibility(0);
                    this.kFq.setVisibility(8);
                    if (qVar.isRetry) {
                        if (!qVar.kCH.isEmpty()) {
                            this.kFG.addAll(qVar.kCH);
                        }
                        if (qVar.kCF == 0 && qVar.kCG > 0 && qVar.kCH.isEmpty()) {
                            ab.i("MicroMsg.CollectBillListUI", "continue retry: %d", Integer.valueOf(this.retryCount));
                            a(qVar.kCG, qVar.kCc, qVar.kCE, qVar.kCD);
                        } else {
                            this.retryCount = 0;
                            if (this.kFG.size() > 0) {
                                this.kFp.bp(this.kFG);
                            } else {
                                ab.i("MicroMsg.CollectBillListUI", "retry data is empty");
                                Ic(qVar.hwA);
                            }
                            this.kFw = false;
                            this.kFE = qVar.kCc;
                            bhh();
                            fW(this.kFz);
                        }
                        AppMethodBeat.o(41198);
                        return true;
                    } else if (!qVar.kCH.isEmpty()) {
                        this.kFp.bp(qVar.kCH);
                        this.kFE = ((h) qVar.kCH.get(qVar.kCH.size() - 1)).kCc;
                        if (this.kFE > qVar.kCc) {
                            ab.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                            this.kFE = qVar.kCc;
                        } else {
                            ab.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", Long.valueOf(this.kFE), Long.valueOf(qVar.kCc));
                        }
                        this.kFw = false;
                        bhh();
                        fW(this.kFz);
                    } else if (qVar.kCF != 0 || qVar.kCG <= 0) {
                        this.kFw = false;
                        bhh();
                        ab.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                        Ic(qVar.hwA);
                        fW(this.kFz);
                    } else {
                        ab.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", Integer.valueOf(qVar.kCG), Long.valueOf(qVar.kCc));
                        a(qVar.kCG, qVar.kCc, qVar.kCE, qVar.kCD);
                        this.kFG.clear();
                    }
                }
                AppMethodBeat.o(41198);
                return true;
            }
            ab.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(qVar.kCD), Integer.valueOf(qVar.kCE));
            if (qVar.kCD != 0) {
                this.kFy = false;
            } else if (qVar.kCE == 0) {
                this.kFw = false;
                bhh();
            } else {
                this.kFx = false;
            }
            if (this.kFp.isEmpty()) {
                aEL();
            }
            Toast.makeText(this, R.string.are, 1).show();
            AppMethodBeat.o(41198);
            return true;
        }
        AppMethodBeat.o(41198);
        return false;
    }

    private void bhh() {
        AppMethodBeat.i(41199);
        this.kFr.scrollTo(0, this.kFr.getTopHeight());
        AppMethodBeat.o(41199);
    }

    private void aEL() {
        AppMethodBeat.i(41200);
        this.kFo.setVisibility(8);
        this.kFq.setVisibility(0);
        this.kFs.setVisibility(0);
        AppMethodBeat.o(41200);
    }

    private void Ic(String str) {
        AppMethodBeat.i(41201);
        if (this.kFp.getCount() == 0) {
            ab.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!bo.isNullOrNil(str)) {
                this.kFs.setText(str);
            } else if (this.kFz) {
                this.kFs.setText(getString(R.string.arf));
            } else {
                this.kFs.setText(getString(R.string.arf) + getString(R.string.arg));
            }
            aEL();
            AppMethodBeat.o(41201);
            return;
        }
        if (!bo.isNullOrNil(str)) {
            Toast.makeText(this.mController.ylL, str, 1).show();
        }
        AppMethodBeat.o(41201);
    }

    private void fW(boolean z) {
        AppMethodBeat.i(41202);
        this.kFr.setBottomViewVisible(!z);
        AppMethodBeat.o(41202);
    }

    private void bhi() {
        AppMethodBeat.i(41203);
        int count = this.kFp.getCount();
        if (count > 0) {
            long j = this.kFp.tI(count - 1).kCc;
            if (j < this.kFE) {
                ab.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", Long.valueOf(j), Long.valueOf(this.kFE));
                this.kFE = j;
            }
        }
        ab.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", Integer.valueOf(this.type), Long.valueOf(this.kFE));
        a(new q(this.type, this.kFE, this.limit, 0), false, false);
        this.kFw = true;
        AppMethodBeat.o(41203);
    }

    private void a(int i, long j, int i2, int i3) {
        AppMethodBeat.i(41204);
        ab.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a(new q(this.type, j, i2, this.limit, i3, i), false, false);
        this.retryCount++;
        AppMethodBeat.o(41204);
    }

    private void bhj() {
        AppMethodBeat.i(41205);
        this.kFr.setTopViewVisible(false);
        this.kFr.setIsTopShowAll(false);
        this.kFr.setBottomViewVisible(true);
        this.kFr.setIsBottomShowAll(false);
        this.kFr.setCanOverScrool(true);
        this.kFr.setAtTopCallBack(new d() {
            public final boolean bhl() {
                AppMethodBeat.i(41192);
                int firstVisiblePosition = CollectBillListUI.this.kFo.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = CollectBillListUI.this.kFo.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getX() == 0.0f) {
                        AppMethodBeat.o(41192);
                        return true;
                    }
                }
                AppMethodBeat.o(41192);
                return false;
            }
        });
        this.kFr.setAtBottomCallBack(new c() {
            public final boolean bhm() {
                AppMethodBeat.i(41193);
                if (CollectBillListUI.this.kFq.getVisibility() == 0) {
                    ab.d("MicroMsg.CollectBillListUI", "empty view");
                    AppMethodBeat.o(41193);
                    return true;
                }
                View childAt = CollectBillListUI.this.kFo.getChildAt(CollectBillListUI.this.kFo.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > CollectBillListUI.this.kFo.getHeight() || CollectBillListUI.this.kFo.getLastVisiblePosition() != CollectBillListUI.this.kFo.getAdapter().getCount() - 1) {
                    AppMethodBeat.o(41193);
                    return false;
                }
                AppMethodBeat.o(41193);
                return true;
            }
        });
        this.kFr.setOnTopLoadDataListener(new MMPullDownView.g() {
            public final boolean bhn() {
                AppMethodBeat.i(41194);
                ab.d("MicroMsg.CollectBillListUI", "top load");
                AppMethodBeat.o(41194);
                return true;
            }
        });
        this.kFr.setOnBottomLoadDataListener(new e() {
            public final boolean bhk() {
                AppMethodBeat.i(41187);
                ab.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", Boolean.valueOf(CollectBillListUI.this.kFw), Boolean.valueOf(CollectBillListUI.this.kFz));
                if (CollectBillListUI.this.kFw || CollectBillListUI.this.kFz) {
                    AppMethodBeat.o(41187);
                    return true;
                }
                CollectBillListUI.i(CollectBillListUI.this);
                CollectBillListUI.j(CollectBillListUI.this);
                AppMethodBeat.o(41187);
                return false;
            }
        });
        AppMethodBeat.o(41205);
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(41206);
        if (collectBillListUI.kFt == null) {
            collectBillListUI.kFt = new android.support.design.widget.c(collectBillListUI);
            final DatePickerDialogView datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.setDatePickerMode(collectBillListUI.type);
            collectBillListUI.kFt.setContentView(datePickerDialogView);
            datePickerDialogView.setOnOkBtnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    long timeInMillis;
                    AppMethodBeat.i(41188);
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
                    ab.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.this.type), Long.valueOf(timeInMillis));
                    CollectBillListUI.a(CollectBillListUI.this, timeInMillis);
                    CollectBillListUI.this.kFt.dismiss();
                    AppMethodBeat.o(41188);
                }
            });
            datePickerDialogView.setOnCancelBtnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(41189);
                    CollectBillListUI.this.kFt.dismiss();
                    AppMethodBeat.o(41189);
                }
            });
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.kFt.getWindow().addFlags(j.INVALID_ID);
            }
            final BottomSheetBehavior j = BottomSheetBehavior.j((View) datePickerDialogView.getParent());
            j.nj = false;
            j.setState(3);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41190);
                    ab.d("MicroMsg.CollectBillListUI", "view height: %d", Integer.valueOf(datePickerDialogView.getHeight()));
                    j.K(datePickerDialogView.getHeight());
                    AppMethodBeat.o(41190);
                }
            }, 300);
        }
        collectBillListUI.kFt.show();
        AppMethodBeat.o(41206);
    }

    static /* synthetic */ void i(CollectBillListUI collectBillListUI) {
        AppMethodBeat.i(41208);
        collectBillListUI.kFr.setBottomViewVisible(true);
        AppMethodBeat.o(41208);
    }
}
