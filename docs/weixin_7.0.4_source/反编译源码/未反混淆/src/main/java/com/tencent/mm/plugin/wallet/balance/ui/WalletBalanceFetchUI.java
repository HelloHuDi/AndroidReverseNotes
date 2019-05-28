package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.b;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@a(2)
public class WalletBalanceFetchUI extends WalletBaseUI implements WalletFormView.a {
    private String czZ = null;
    private Button gHn;
    private final int gnS = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 270);
    private View jcl;
    private double pQV;
    private String rMr;
    private ArrayList<Bankcard> tgB;
    private Bankcard tgC;
    private String tgD;
    private WalletFormView tgE;
    private LinearLayout tgF;
    private View tgG;
    private TextView tgH;
    private TextView tgI;
    private TextView tgJ;
    private TextView tgK;
    private TextView tgL;
    private ViewGroup tgM;
    private ViewGroup tgN;
    private int tgO = 0;
    private int tgP = 0;
    private int tgQ = 0;
    private double tgR = 0.0d;
    private int tgS = -1;
    private int tgT = 0;
    private DecimalFormat tgU = new DecimalFormat("0.00");
    private boolean tgV = false;
    private int tgW = 0;
    private int tgX = 0;
    private b tgY;
    private Runnable tgZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(45353);
            WalletBalanceFetchUI.a(WalletBalanceFetchUI.this);
            AppMethodBeat.o(45353);
        }
    };
    private boolean tha = false;
    private boolean thb = false;
    private boolean thc = false;
    private boolean thd = false;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$16 */
    class AnonymousClass16 implements c {
        final /* synthetic */ List thk;
        final /* synthetic */ Context val$context;

        AnonymousClass16(List list, Context context) {
            this.thk = list;
            this.val$context = context;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(45372);
            int i = 0;
            for (final Bankcard bankcard : this.thk) {
                CharSequence spannableString;
                String str;
                Bitmap a;
                e i2 = com.tencent.mm.plugin.wallet_core.d.b.i(this.val$context, bankcard.field_bankcardType, bankcard.cPb());
                String str2 = "";
                if (i2 != null) {
                    str2 = i2.oRi;
                }
                ab.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", str2);
                Bitmap a2 = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str2));
                CharSequence charSequence = "";
                if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                    charSequence = bankcard.field_forbidWord;
                }
                if (bo.isNullOrNil(bankcard.field_forbid_title)) {
                    spannableString = new SpannableString(charSequence);
                    str = charSequence;
                } else {
                    String str3 = charSequence + " ";
                    charSequence = new SpannableString(str3 + bankcard.field_forbid_title);
                    AnonymousClass1 anonymousClass1 = new j(this.val$context) {
                        public final void onClick(View view) {
                            AppMethodBeat.i(45371);
                            Intent intent = new Intent();
                            ab.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", bankcard.field_forbid_url);
                            intent.putExtra("rawUrl", r1);
                            intent.putExtra("geta8key_username", r.Yz());
                            intent.putExtra("pay_channel", 1);
                            d.b(AnonymousClass16.this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(45371);
                        }
                    };
                    int length = str3.length();
                    int length2 = str3.length() + bankcard.field_forbid_title.length();
                    charSequence.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(R.color.a50)), length, length2, 33);
                    charSequence.setSpan(anonymousClass1, length, length2, 33);
                    spannableString = charSequence;
                    str = str3;
                }
                if (bo.ac(spannableString)) {
                    spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
                }
                str2 = bankcard.field_desc;
                if (a2 != null) {
                    a = com.tencent.mm.sdk.platformtools.d.a(a2, this.val$context.getResources().getDimensionPixelOffset(R.dimen.aaq), this.val$context.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false);
                } else {
                    a = null;
                }
                ab.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", Integer.valueOf(i), str2, spannableString);
                int i3 = i + 1;
                lVar.a(i, str2, spannableString, a == null ? null : new BitmapDrawable(a), !bo.isNullOrNil(str));
                i = i3;
            }
            lVar.e(i, this.val$context.getString(R.string.f90));
            AppMethodBeat.o(45372);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBalanceFetchUI() {
        AppMethodBeat.i(45386);
        AppMethodBeat.o(45386);
    }

    static /* synthetic */ void b(WalletBalanceFetchUI walletBalanceFetchUI, com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45424);
        walletBalanceFetchUI.a(dVar);
        AppMethodBeat.o(45424);
    }

    static /* synthetic */ void cMW() {
    }

    static /* synthetic */ void i(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(45419);
        walletBalanceFetchUI.cMQ();
        AppMethodBeat.o(45419);
    }

    static /* synthetic */ void j(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(45420);
        walletBalanceFetchUI.cMR();
        AppMethodBeat.o(45420);
    }

    static /* synthetic */ void n(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(45422);
        walletBalanceFetchUI.cMS();
        AppMethodBeat.o(45422);
    }

    static /* synthetic */ void o(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(45425);
        walletBalanceFetchUI.cMT();
        AppMethodBeat.o(45425);
    }

    public final int getLayoutId() {
        return R.layout.b2w;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45387);
        this.rMr = UUID.randomUUID().toString();
        super.onCreate(bundle);
        au(getIntent());
        cfk();
        this.tgD = getString(R.string.f9s);
        initView();
        cu();
        z.hL(4, 0);
        AppMethodBeat.o(45387);
    }

    public void onDestroy() {
        AppMethodBeat.i(45388);
        al.af(this.tgZ);
        super.onDestroy();
        AppMethodBeat.o(45388);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cfk() {
        String str;
        AppMethodBeat.i(45389);
        s.cNC();
        ak cND = s.cND();
        if (this.tgV) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            ab.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.tgB != null && this.tgB.size() > 0) {
                arrayList.addAll(this.tgB);
            }
            this.tgB = cND.cQD();
            if (this.tgB != null && this.tgB.size() > 0) {
                arrayList2.addAll(this.tgB);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = cND.a(this.tgB, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.tgB != null && i < this.tgB.size()) {
                        bankcard = (Bankcard) this.tgB.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.tgS = i;
                            break;
                        }
                        i++;
                    }
                    this.tgC = bankcard2;
                    this.tgV = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
            }
            i = 0;
            while (this.tgB != null) {
                bankcard = (Bankcard) this.tgB.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.tgC = bankcard2;
            this.tgV = false;
        } else {
            this.tgB = cND.cQD();
            this.tgC = cND.a(this.tgB, null, false, true);
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = this.rMr;
        objArr[1] = Integer.valueOf(1);
        if (this.tgC != null) {
            str = this.tgC.field_bankcardType;
        } else {
            str = "";
        }
        objArr[2] = str;
        if (this.tgC != null) {
            str = this.tgC.field_bindSerial;
        } else {
            str = "";
        }
        objArr[3] = str;
        hVar.e(16398, objArr);
        if (cND.tCX != null) {
            this.tgO = cND.tCX.tgO;
            this.tgP = cND.tCX.tgP;
            cMO();
            this.tgQ = cND.tCX.tgQ;
        } else {
            ab.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        this.tgW = 0;
        this.tgX = 0;
        ab.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.tgO + " is_cal_charge:" + this.tgP + " min_charge_fee:" + this.tgR + " is_full_fetch_direct:" + this.tgQ);
        AppMethodBeat.o(45389);
    }

    public final boolean bwP() {
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(45390);
        setMMTitle((int) R.string.f8z);
        this.jcl = findViewById(R.id.f5v);
        this.tgF = (LinearLayout) findViewById(R.id.f5y);
        AnonymousClass12 anonymousClass12 = new OnClickListener() {
            public final void onClick(View view) {
                String str;
                int i;
                AppMethodBeat.i(45367);
                WalletBalanceFetchUI.this.aoB();
                s.cNC();
                final ArrayList cQD = s.cND().cQD();
                s.cNC();
                com.tencent.mm.plugin.wallet_core.model.b bVar = s.cND().tCX;
                String str2 = "";
                String str3 = "";
                if (bVar != null) {
                    str3 = bVar.twA;
                    str2 = bVar.twz;
                    str = str3;
                } else {
                    str = str3;
                }
                WalletBalanceFetchUI walletBalanceFetchUI = WalletBalanceFetchUI.this;
                AppCompatActivity appCompatActivity = WalletBalanceFetchUI.this.mController.ylL;
                Bankcard b = WalletBalanceFetchUI.this.tgC;
                AnonymousClass1 anonymousClass1 = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(45366);
                        h hVar;
                        Object[] objArr;
                        if (i < cQD.size()) {
                            WalletBalanceFetchUI.this.tgC = (Bankcard) cQD.get(i);
                            WalletBalanceFetchUI.c(WalletBalanceFetchUI.this);
                            ab.i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", WalletBalanceFetchUI.this.tgC.field_desc);
                            hVar = h.pYm;
                            objArr = new Object[4];
                            objArr[0] = WalletBalanceFetchUI.this.rMr;
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bankcardType : "";
                            objArr[3] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bindSerial : "";
                            hVar.e(16398, objArr);
                        } else {
                            ab.i("MicroMsg.WalletBalanceFetchUI", "add new card");
                            WalletBalanceFetchUI.e(WalletBalanceFetchUI.this);
                            hVar = h.pYm;
                            objArr = new Object[4];
                            objArr[0] = WalletBalanceFetchUI.this.rMr;
                            objArr[1] = Integer.valueOf(9);
                            objArr[2] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bankcardType : "";
                            objArr[3] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bindSerial : "";
                            hVar.e(16398, objArr);
                        }
                        WalletBalanceFetchUI.f(WalletBalanceFetchUI.this);
                        WalletBalanceFetchUI.cMW();
                        AppMethodBeat.o(45366);
                    }
                };
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(appCompatActivity, 2, true);
                dVar.rBl = new AnonymousClass16(cQD, appCompatActivity);
                dVar.rBm = anonymousClass1;
                dVar.zQy = true;
                View inflate = LayoutInflater.from(appCompatActivity).inflate(R.layout.b2u, null);
                if (!bo.isNullOrNil(str2)) {
                    ((TextView) inflate.findViewById(R.id.f5p)).setText(str2);
                }
                if (!bo.isNullOrNil(str)) {
                    ((TextView) inflate.findViewById(R.id.f5q)).setText(str);
                }
                dVar.F(inflate, false);
                int size = cQD.size();
                if (b != null) {
                    i = size;
                    int i2 = 0;
                    while (i2 < cQD.size()) {
                        if (((Bankcard) cQD.get(i2)).field_bindSerial.equals(b.field_bindSerial)) {
                            size = i2;
                        } else {
                            size = i;
                        }
                        i2++;
                        i = size;
                    }
                } else {
                    i = size;
                }
                dVar.zQA = i;
                dVar.cpD();
                AppMethodBeat.o(45367);
            }
        };
        this.tgG = findViewById(R.id.f5y);
        this.tgG.setOnClickListener(anonymousClass12);
        this.tgF.setOnClickListener(anonymousClass12);
        this.tgE = (WalletFormView) findViewById(R.id.f64);
        e(this.tgE, 2, false);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.tgE);
        this.tgE.setOnInputValidChangeListener(this);
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHn.setOnClickListener(new com.tencent.mm.ui.s() {
            public final void bgW() {
                AppMethodBeat.i(45376);
                WalletBalanceFetchUI.g(WalletBalanceFetchUI.this);
                AppMethodBeat.o(45376);
            }
        });
        this.gHn.setEnabled(false);
        this.tgH = (TextView) findViewById(R.id.f5w);
        this.tgI = (TextView) findViewById(R.id.f5x);
        this.tgJ = (TextView) findViewById(R.id.f69);
        this.tgK = (TextView) findViewById(R.id.f66);
        this.tgL = (TextView) findViewById(R.id.f67);
        this.tgM = (ViewGroup) findViewById(R.id.f65);
        this.tgN = (ViewGroup) findViewById(R.id.f68);
        this.tgL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45377);
                WalletBalanceFetchUI.h(WalletBalanceFetchUI.this);
                AppMethodBeat.o(45377);
            }
        });
        this.tgE.a(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(45378);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                obj.length();
                int lastIndexOf = obj.lastIndexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (lastIndexOf != indexOf) {
                    editable.delete(lastIndexOf, length);
                }
                WalletBalanceFetchUI.this.pQV = bo.getDouble(editable.toString(), 0.0d);
                WalletBalanceFetchUI.i(WalletBalanceFetchUI.this);
                WalletBalanceFetchUI.cMW();
                WalletBalanceFetchUI.j(WalletBalanceFetchUI.this);
                AppMethodBeat.o(45378);
            }
        });
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(45379);
                if (z) {
                    WalletBalanceFetchUI.k(WalletBalanceFetchUI.this);
                    AppMethodBeat.o(45379);
                    return;
                }
                WalletBalanceFetchUI.this.jcl.scrollTo(0, 0);
                AppMethodBeat.o(45379);
            }
        };
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45380);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                    AppMethodBeat.o(45380);
                    return;
                }
                com.tencent.mm.wallet_core.ui.e.a(WalletBalanceFetchUI.this.tgH, uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(45380);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(45390);
    }

    public void onResume() {
        AppMethodBeat.i(45391);
        cMT();
        super.onResume();
        AppMethodBeat.o(45391);
    }

    private void cMO() {
        AppMethodBeat.i(45392);
        if (this.tgC != null) {
            this.tgR = com.tencent.mm.wallet_core.ui.e.b(this.tgC.txn, "100", RoundingMode.HALF_UP);
            ab.i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", Double.valueOf(this.tgR));
        }
        AppMethodBeat.o(45392);
    }

    private void cu() {
        AppMethodBeat.i(45393);
        if (this.tgE.getTitleTv() != null) {
            this.tgE.getTitleTv().setText(String.format(getString(R.string.dp9), new Object[]{ae.dOd()}));
        } else {
            ab.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        final ImageView imageView = (ImageView) this.tgF.findViewById(R.id.f60);
        if (this.tgC != null) {
            String str = "";
            e i = com.tencent.mm.plugin.wallet_core.d.b.i(this, this.tgC.field_bankcardType, this.tgC.cPb());
            if (i != null) {
                str = i.oRi;
            }
            imageView.setImageBitmap(null);
            if (this.tgC.cPc()) {
                imageView.setBackgroundResource(R.drawable.bki);
            } else {
                Bitmap a = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
                x.a(new x.a() {
                    public final void m(String str, final Bitmap bitmap) {
                        AppMethodBeat.i(45382);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(45381);
                                if (!(WalletBalanceFetchUI.this.tgC == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceFetchUI.this.tgC.field_bindSerial))) {
                                    imageView.setImageBitmap(bitmap);
                                }
                                AppMethodBeat.o(45381);
                            }
                        });
                        AppMethodBeat.o(45382);
                    }
                });
                if (!(a == null || a == null)) {
                    imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a, getResources().getDimensionPixelOffset(R.dimen.aaq), getResources().getDimensionPixelOffset(R.dimen.aaq), true, false));
                }
            }
            ((TextView) this.tgF.findViewById(R.id.f61)).setText(getString(R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
            ((TextView) this.tgF.findViewById(R.id.f61)).setVisibility(0);
            if (!bo.isNullOrNil(this.tgC.field_fetchArriveTimeWording)) {
                ((TextView) this.tgF.findViewById(R.id.f62)).setText(this.tgC.field_fetchArriveTimeWording);
                ((TextView) this.tgF.findViewById(R.id.f62)).setVisibility(0);
                if (this.tgC.field_is_hightlight_pre_arrive_time_wording == 1) {
                    ((TextView) this.tgF.findViewById(R.id.f62)).setTextColor(Color.parseColor("#FA962A"));
                } else {
                    ((TextView) this.tgF.findViewById(R.id.f62)).setTextColor(Color.parseColor("#B2B2B2"));
                }
            }
            this.tgJ.setText("");
            this.tgJ.setVisibility(8);
        } else {
            imageView.setImageBitmap(null);
            ((TextView) this.tgF.findViewById(R.id.f61)).setText(this.tgD);
            ((TextView) this.tgF.findViewById(R.id.f62)).setText("");
            ((TextView) this.tgF.findViewById(R.id.f62)).setVisibility(8);
            ((ImageView) this.tgF.findViewById(R.id.f60)).setImageBitmap(null);
            this.tgJ.setVisibility(8);
        }
        s.cNC();
        String str2 = s.cND().thy.twY;
        if (bo.isNullOrNil(str2)) {
            this.tgI.setVisibility(8);
        } else {
            this.tgI.setVisibility(0);
            this.tgI.setText(str2);
        }
        if (this.tgW == 1) {
            this.tgM.setVisibility(8);
            this.tgN.setVisibility(0);
        } else {
            this.tgM.setVisibility(0);
            this.tgN.setVisibility(8);
        }
        cMQ();
        cMR();
        cMP();
        AppMethodBeat.o(45393);
    }

    private void cMP() {
        AppMethodBeat.i(45394);
        s.cNC();
        final com.tencent.mm.plugin.wallet_core.model.b bVar = s.cND().tCX;
        this.mController.removeAllOptionMenu();
        if (!(bVar == null || bVar.twB == null || bVar.twB.twD == null || bVar.twB.twD.length <= 0)) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(45385);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(WalletBalanceFetchUI.this.mController.ylL, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(45383);
                            com.tencent.mm.plugin.wallet_core.model.b.c[] cVarArr = bVar.twB.twD;
                            int length = cVarArr.length;
                            int i = 0;
                            int i2 = 0;
                            while (i < length) {
                                com.tencent.mm.plugin.wallet_core.model.b.c cVar = cVarArr[i];
                                if (!bo.isNullOrNil(cVar.title)) {
                                    if (bo.isNullOrNil(cVar.desc)) {
                                        lVar.e(i2, cVar.title);
                                    } else {
                                        lVar.a(i2, cVar.title, cVar.desc);
                                    }
                                }
                                i++;
                                i2++;
                            }
                            AppMethodBeat.o(45383);
                        }
                    };
                    dVar.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(45384);
                            int itemId = menuItem.getItemId();
                            if (bVar.twB.twD != null && itemId < bVar.twB.twD.length) {
                                com.tencent.mm.plugin.wallet_core.model.b.c cVar = bVar.twB.twD[itemId];
                                ab.i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", Integer.valueOf(cVar.ttd), cVar.kdF);
                                switch (cVar.ttd) {
                                    case 1:
                                        com.tencent.mm.wallet_core.ui.e.n(WalletBalanceFetchUI.this.mController.ylL, cVar.kdF, true);
                                        break;
                                }
                            }
                            AppMethodBeat.o(45384);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(45385);
                    return true;
                }
            });
        }
        AppMethodBeat.o(45394);
    }

    private void cMQ() {
        AppMethodBeat.i(45395);
        if (this.pQV <= 0.0d || this.tgC == null) {
            this.gHn.setEnabled(false);
            AppMethodBeat.o(45395);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.o(45395);
    }

    private void cMR() {
        AppMethodBeat.i(45396);
        if (this.tgW == 0) {
            this.pQV = bo.getDouble(this.tgE.getText(), 0.0d);
            double d = this.pQV;
            s.cNC();
            if (!(d == s.cND().thy.twU || this.tgC == null)) {
                d = this.pQV;
                s.cNC();
                if (d != s.cND().thy.twU - this.tgC.field_full_fetch_charge_fee) {
                    this.tgT = 0;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            double d2 = this.pQV;
            s.cNC();
            if (d2 > s.cND().thy.twS) {
                this.tgL.setVisibility(8);
                this.tgK.setTextColor(getResources().getColor(R.color.xy));
                stringBuilder.append(getString(R.string.f92));
            } else {
                String str;
                if (!(this.tgC == null || this.tgO == 0 || ((this.tgO == 1 && this.tgC.field_fetch_charge_rate <= 0.0d) || (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 0)))) {
                    d2 = this.tgR;
                    s.cNC();
                    if (d2 < s.cND().thy.twU) {
                        if (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 1 && (this.pQV <= 0.0d || !this.tgE.asa())) {
                            this.tgL.setVisibility(0);
                            this.tgK.setTextColor(getResources().getColor(R.color.s0));
                            s.cNC();
                            str = s.cND().thy.twZ;
                            if (bo.isNullOrNil(str)) {
                                ab.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                                s.cNC();
                                stringBuilder.append(getString(R.string.f8t, new Object[]{com.tencent.mm.wallet_core.ui.e.e(s.cND().thy.twU, "CNY")}));
                            } else {
                                stringBuilder.append(str);
                            }
                            stringBuilder.append("，");
                        } else if (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 1) {
                            this.tgL.setVisibility(8);
                            this.tgK.setTextColor(getResources().getColor(R.color.s0));
                            d2 = this.pQV;
                            s.cNC();
                            if (d2 != s.cND().thy.twU - this.tgC.field_full_fetch_charge_fee || this.tgC.field_full_fetch_charge_fee <= 0.0d) {
                                if (bo.isNullOrNil(this.tgC.txm)) {
                                    stringBuilder.append(getString(R.string.f8b, new Object[]{com.tencent.mm.wallet_core.ui.e.e(C(this.pQV), "CNY"), (this.tgC.field_fetch_charge_rate * 100.0d) + "%"}));
                                } else {
                                    stringBuilder.append(String.format(this.tgC.txm, new Object[]{com.tencent.mm.wallet_core.ui.e.e(C(this.pQV), "CNY")}));
                                }
                            } else if (bo.isNullOrNil(this.tgC.txm)) {
                                stringBuilder.append(getString(R.string.f8b, new Object[]{com.tencent.mm.wallet_core.ui.e.e(this.tgC.field_full_fetch_charge_fee, "CNY"), (this.tgC.field_fetch_charge_rate * 100.0d) + "%"}));
                            } else {
                                stringBuilder.append(String.format(this.tgC.txm, new Object[]{com.tencent.mm.wallet_core.ui.e.e(this.tgC.field_full_fetch_charge_fee, "CNY")}));
                            }
                        }
                    }
                }
                this.tgL.setVisibility(0);
                this.tgK.setTextColor(getResources().getColor(R.color.s0));
                s.cNC();
                str = s.cND().thy.twZ;
                if (bo.isNullOrNil(str)) {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                    s.cNC();
                    stringBuilder.append(getString(R.string.f8t, new Object[]{com.tencent.mm.wallet_core.ui.e.e(s.cND().thy.twU, "CNY")}));
                } else {
                    stringBuilder.append(str);
                }
                stringBuilder.append("，");
            }
            this.tgK.setText(stringBuilder.toString());
        }
        AppMethodBeat.o(45396);
    }

    private double C(double d) {
        AppMethodBeat.i(45397);
        s.cNC();
        double max = Math.max(com.tencent.mm.wallet_core.ui.e.c((d - s.cND().tCX.pPt), this.tgC.field_fetch_charge_rate, RoundingMode.HALF_UP), this.tgR);
        AppMethodBeat.o(45397);
        return max;
    }

    private void a(com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45398);
        if (bo.isNullOrNil(this.czZ)) {
            ab.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            AppMethodBeat.o(45398);
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = this.czZ;
        payInfo.cIf = 21;
        this.mBundle.putParcelable("key_pay_info", payInfo);
        Orders orders = new Orders();
        orders.pTN = dVar.pPz - dVar.pPp;
        orders.tAa = dVar.pPz - dVar.pPp;
        orders.tAq.add(new Commodity());
        orders.pPp = dVar.pPp;
        this.mBundle.putParcelable("key_orders", orders);
        this.mBundle.putParcelable("key_bankcard", this.tgC);
        this.mBundle.putString("key_fetch_cashier_desc", dVar.tfb);
        this.mBundle.putString("key_report_session_id", this.rMr);
        if (dOD() == null) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, this.mBundle, null);
            AppMethodBeat.o(45398);
            return;
        }
        dOE().p(this.mBundle);
        AppMethodBeat.o(45398);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45399);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.wallet.balance.a.d) {
                boolean a;
                com.tencent.mm.plugin.wallet.balance.a.d dVar = (com.tencent.mm.plugin.wallet.balance.a.d) mVar;
                this.tha = false;
                if (!this.thd) {
                    this.thb = false;
                }
                this.thc = false;
                this.thd = false;
                if ("1".equals(dVar.cRb)) {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, 0);
                } else if ("2".equals(dVar.cRb)) {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, dVar.cRc, dVar.cRf, dVar.cRd, dVar.cRe, false, null);
                } else {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + dVar.cRb);
                    a = false;
                }
                if (a) {
                    AppMethodBeat.o(45399);
                    return false;
                }
                Object obj;
                if (dVar.tfc) {
                    if (dVar.tfd != null) {
                        ab.i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
                        String str2 = dVar.tfd.title;
                        String str3 = dVar.tfd.content;
                        String str4 = dVar.tfd.tff;
                        final String str5 = dVar.tfd.tfg;
                        ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
                        View inflate = LayoutInflater.from(this).inflate(R.layout.b2v, null);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.au3);
                        Button button = (Button) inflate.findViewById(R.id.f5u);
                        ((TextView) inflate.findViewById(R.id.f5s)).setText(str2);
                        ((TextView) inflate.findViewById(R.id.f5t)).setText(str3);
                        ((Button) inflate.findViewById(R.id.f5u)).setText(str4);
                        final Dialog dialog = new Dialog(this, R.style.zt);
                        dialog.setContentView(inflate);
                        dialog.setTitle(null);
                        dialog.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(45373);
                                ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.o(45373);
                            }
                        });
                        imageView.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(45374);
                                ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.o(45374);
                            }
                        });
                        button.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(45375);
                                ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
                                com.tencent.mm.plugin.account.a.b.a.b(this, str5, 2, true);
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.o(45375);
                            }
                        });
                        dialog.show();
                        com.tencent.mm.ui.base.h.a(this, dialog);
                    } else {
                        ab.i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
                    }
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.o(45399);
                    return false;
                }
                ad.o(21, dVar.cBT, i2);
                if (!b(dVar)) {
                    this.czZ = dVar.cBT;
                    a(dVar);
                }
            } else if (mVar instanceof y) {
                final y yVar = (y) mVar;
                cMS();
                if (yVar.bLD()) {
                    final k kVar = yVar.nYe;
                    kVar.a((Activity) this, new com.tencent.mm.wallet_core.c.e() {
                        public final void onCancel() {
                            AppMethodBeat.i(45355);
                            if (kVar.dNM()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.o(45355);
                        }

                        public final void cMX() {
                            AppMethodBeat.i(45356);
                            if (kVar.dNM()) {
                                WalletBalanceFetchUI.n(WalletBalanceFetchUI.this);
                            }
                            AppMethodBeat.o(45356);
                        }

                        public final void cMY() {
                            AppMethodBeat.i(45357);
                            if (kVar.dNM()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.o(45357);
                        }
                    });
                    AppMethodBeat.o(45399);
                    return true;
                }
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet.balance.a.d) {
            ad.o(21, "", i2);
            cMT();
        }
        AppMethodBeat.o(45399);
        return false;
    }

    private void cMS() {
        AppMethodBeat.i(45400);
        cfk();
        cu();
        cMV();
        AppMethodBeat.o(45400);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45402);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(45402);
        } else if (i2 != -1 || intent == null) {
            ab.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
            AppMethodBeat.o(45402);
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.tgS;
            this.tgS = intExtra;
            ab.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(intExtra)));
            if (this.tgB == null || intExtra < 0 || intExtra >= this.tgB.size()) {
                if (this.tgB == null || intExtra < 0 || intExtra > this.tgB.size()) {
                    this.tgC = null;
                } else {
                    this.tgS = i3;
                }
                cMU();
            } else {
                this.tgC = (Bankcard) this.tgB.get(intExtra);
            }
            cu();
            AppMethodBeat.o(45402);
        }
    }

    private boolean b(com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45403);
        boolean z = false;
        if (!this.tha) {
            z = c(dVar);
        }
        if (!z) {
            z = d(dVar);
        }
        if (!(z || this.thb)) {
            z = e(dVar);
        }
        if (!(z || this.thc)) {
            z = f(dVar);
        }
        AppMethodBeat.o(45403);
        return z;
    }

    private void cMT() {
        this.tha = false;
        this.thb = false;
        this.thc = false;
        this.thd = false;
    }

    private boolean c(final com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45404);
        if (dVar.teW) {
            this.tha = true;
            com.tencent.mm.ui.base.h.a((Context) this, false, dVar.teX, "", getString(R.string.s6), getString(R.string.or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45358);
                    dialogInterface.dismiss();
                    if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, dVar)) {
                        WalletBalanceFetchUI.this.czZ = dVar.cBT;
                        WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, dVar);
                    }
                    AppMethodBeat.o(45358);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45359);
                    dialogInterface.dismiss();
                    WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
                    AppMethodBeat.o(45359);
                }
            });
            AppMethodBeat.o(45404);
            return true;
        }
        AppMethodBeat.o(45404);
        return false;
    }

    private boolean d(final com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45405);
        com.tencent.mm.plugin.wallet_core.model.j jVar = dVar.tfa;
        if (jVar == null) {
            AppMethodBeat.o(45405);
            return false;
        }
        ab.i("MicroMsg.WalletBalanceFetchUI", "show balance Charge tips");
        com.tencent.mm.plugin.wallet_core.ui.k.a(this, jVar, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45360);
                dialogInterface.dismiss();
                WalletBalanceFetchUI.this.czZ = dVar.cBT;
                WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, dVar);
                h.pYm.e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(5), "", "");
                AppMethodBeat.o(45360);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45361);
                dialogInterface.dismiss();
                h.pYm.e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(6), "", "");
                AppMethodBeat.o(45361);
            }
        });
        AppMethodBeat.o(45405);
        return true;
    }

    private boolean e(final com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45406);
        com.tencent.mm.plugin.wallet_core.model.b bVar = dVar.teY;
        if (bVar == null || (TextUtils.isEmpty(bVar.twx) && (bVar.twy == null || bVar.twy.size() <= 0))) {
            AppMethodBeat.o(45406);
            return false;
        }
        this.thb = true;
        com.tencent.mm.plugin.wallet_core.ui.k.a(this, bVar, false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45362);
                dialogInterface.dismiss();
                if (!WalletBalanceFetchUI.a(WalletBalanceFetchUI.this, dVar)) {
                    WalletBalanceFetchUI.this.czZ = dVar.cBT;
                    WalletBalanceFetchUI.b(WalletBalanceFetchUI.this, dVar);
                }
                AppMethodBeat.o(45362);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45363);
                dialogInterface.dismiss();
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
                AppMethodBeat.o(45363);
            }
        });
        AppMethodBeat.o(45406);
        return true;
    }

    private boolean f(com.tencent.mm.plugin.wallet.balance.a.d dVar) {
        AppMethodBeat.i(45407);
        com.tencent.mm.plugin.wallet_core.model.b bVar = dVar.teZ;
        if (bVar == null || (TextUtils.isEmpty(bVar.twx) && (bVar.twy == null || bVar.twy.size() <= 0))) {
            AppMethodBeat.o(45407);
            return false;
        }
        this.thc = true;
        com.tencent.mm.plugin.wallet_core.ui.k.a(this, bVar, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45364);
                dialogInterface.dismiss();
                String str = "";
                if (WalletBalanceFetchUI.this.tgC != null) {
                    str = WalletBalanceFetchUI.this.tgC.field_bankcardType;
                }
                WalletBalanceFetchUI.this.tgT = 1;
                WalletBalanceFetchUI.this.thd = true;
                WalletBalanceFetchUI.this.a(new com.tencent.mm.plugin.wallet.balance.a.d(WalletBalanceFetchUI.this.pQV, "CNY", str, WalletBalanceFetchUI.this.tgT), true, true);
                AppMethodBeat.o(45364);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45365);
                dialogInterface.dismiss();
                WalletBalanceFetchUI.o(WalletBalanceFetchUI.this);
                AppMethodBeat.o(45365);
            }
        });
        AppMethodBeat.o(45407);
        return true;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(45408);
        cMT();
        au(intent);
        AppMethodBeat.o(45408);
    }

    private void au(Intent intent) {
        AppMethodBeat.i(45409);
        this.tgV = av(intent);
        if (this.tgV) {
            ab.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.mBundle.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.czZ = this.czZ;
                payInfo.cIf = 21;
            }
            a(new v(payInfo.czZ), true, false);
        }
        AppMethodBeat.o(45409);
    }

    private void cMU() {
        AppMethodBeat.i(45410);
        g cPl = g.cPl();
        if (cPl.aFF()) {
            com.tencent.mm.ui.base.h.b((Context) this, cPl.pbp, getString(R.string.tz), true);
            AppMethodBeat.o(45410);
            return;
        }
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) this.mBundle.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.czZ = this.czZ;
            parcelable.cIf = 21;
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.teU);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
        AppMethodBeat.o(45410);
    }

    private static boolean av(Intent intent) {
        AppMethodBeat.i(45411);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            AppMethodBeat.o(45411);
            return false;
        }
        AppMethodBeat.o(45411);
        return true;
    }

    private void cMV() {
        AppMethodBeat.i(45412);
        if (this.tgO != 0) {
            ab.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.tgO);
            AppMethodBeat.o(45412);
            return;
        }
        com.tencent.mm.kernel.g.RQ();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        s.cNC();
        if (!(s.cND().tCX == null || booleanValue)) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.foj, new Object[]{com.tencent.mm.wallet_core.ui.e.G(r1.pPt)}), getString(R.string.fok), getString(R.string.ffp), getString(R.string.fol), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45369);
                    dialogInterface.dismiss();
                    h.pYm.e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(4), "", "");
                    AppMethodBeat.o(45369);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45370);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(R.string.fev));
                    intent.putExtra("showShare", false);
                    d.b(WalletBalanceFetchUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    dialogInterface.dismiss();
                    h.pYm.e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(3), "", "");
                    AppMethodBeat.o(45370);
                }
            }, (int) R.color.a61);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        }
        AppMethodBeat.o(45412);
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(45401);
        this.tgE.fx(null);
        AppMethodBeat.o(45401);
    }

    static /* synthetic */ void g(WalletBalanceFetchUI walletBalanceFetchUI) {
        String str;
        AppMethodBeat.i(45417);
        walletBalanceFetchUI.pQV = bo.getDouble(walletBalanceFetchUI.tgE.getText(), 0.0d);
        String str2 = "";
        if (walletBalanceFetchUI.tgC != null) {
            str2 = walletBalanceFetchUI.tgC.field_bankcardType;
        } else {
            g cPl = g.cPl();
            if (cPl.aFF()) {
                com.tencent.mm.ui.base.h.b((Context) walletBalanceFetchUI, cPl.pbp, walletBalanceFetchUI.getString(R.string.tz), true);
                AppMethodBeat.o(45417);
                return;
            }
        }
        if (walletBalanceFetchUI.tgC != null && !bo.isNullOrNil(walletBalanceFetchUI.tgC.field_forbidWord)) {
            t.makeText(walletBalanceFetchUI.mController.ylL, walletBalanceFetchUI.tgC.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.pQV <= 0.0d || !walletBalanceFetchUI.tgE.asa()) {
            t.makeText(walletBalanceFetchUI.mController.ylL, R.string.f9y, 0).show();
        } else {
            double d = walletBalanceFetchUI.pQV;
            s.cNC();
            if (d > s.cND().thy.twS) {
                t.makeText(walletBalanceFetchUI.mController.ylL, R.string.f8w, 0).show();
            } else {
                d = walletBalanceFetchUI.pQV;
                s.cNC();
                if (d > s.cND().thy.twU) {
                    t.makeText(walletBalanceFetchUI.mController.ylL, R.string.f8x, 0).show();
                } else {
                    walletBalanceFetchUI.a(new com.tencent.mm.plugin.wallet.balance.a.d(walletBalanceFetchUI.pQV, "CNY", str2, walletBalanceFetchUI.tgT), true, true);
                }
            }
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = walletBalanceFetchUI.rMr;
        objArr[1] = Integer.valueOf(7);
        if (walletBalanceFetchUI.tgC != null) {
            str = walletBalanceFetchUI.tgC.field_bankcardType;
        } else {
            str = "";
        }
        objArr[2] = str;
        if (walletBalanceFetchUI.tgC != null) {
            str = walletBalanceFetchUI.tgC.field_bindSerial;
        } else {
            str = "";
        }
        objArr[3] = str;
        hVar.e(16398, objArr);
        AppMethodBeat.o(45417);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void h(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        AppMethodBeat.i(45418);
        if (!(walletBalanceFetchUI.tgC == null || walletBalanceFetchUI.tgO == 0 || ((walletBalanceFetchUI.tgO == 1 && walletBalanceFetchUI.tgC.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.tgO == 1 && walletBalanceFetchUI.tgC.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.tgP == 0)))) {
            d = walletBalanceFetchUI.tgR;
            s.cNC();
            if (d < s.cND().thy.twU) {
                if (walletBalanceFetchUI.tgC != null) {
                    s.cNC();
                    d = s.cND().thy.twU - walletBalanceFetchUI.tgC.field_full_fetch_charge_fee;
                } else {
                    s.cNC();
                    d = s.cND().thy.twU;
                }
                if (walletBalanceFetchUI.tgQ != 1) {
                    ab.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.tgT = 1;
                    if (walletBalanceFetchUI.tgC == null || bo.isNullOrNil(walletBalanceFetchUI.tgC.field_forbidWord)) {
                        String str = "";
                        if (walletBalanceFetchUI.tgC != null) {
                            str = walletBalanceFetchUI.tgC.field_bankcardType;
                        }
                        walletBalanceFetchUI.a(new com.tencent.mm.plugin.wallet.balance.a.d(walletBalanceFetchUI.pQV, "CNY", str, walletBalanceFetchUI.tgT), true, true);
                        AppMethodBeat.o(45418);
                        return;
                    }
                    t.makeText(walletBalanceFetchUI.mController.ylL, walletBalanceFetchUI.tgC.field_forbidWord, 0).show();
                    AppMethodBeat.o(45418);
                    return;
                }
                walletBalanceFetchUI.tgE.setText(walletBalanceFetchUI.tgU.format(d));
                walletBalanceFetchUI.cMQ();
                walletBalanceFetchUI.cMR();
                walletBalanceFetchUI.tgT = 1;
                ab.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                AppMethodBeat.o(45418);
                return;
            }
        }
        s.cNC();
        d = s.cND().thy.twU;
        if (walletBalanceFetchUI.tgQ != 1) {
        }
    }

    static /* synthetic */ void k(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.i(45421);
        if (walletBalanceFetchUI.jcl != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceFetchUI.gHn.getLocationInWindow(iArr);
            int ge = (com.tencent.mm.bz.a.ge(walletBalanceFetchUI) - i) - com.tencent.mm.bz.a.fromDPToPix(walletBalanceFetchUI, 30);
            ab.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + walletBalanceFetchUI.gHn.getHeight()), Integer.valueOf(com.tencent.mm.bz.a.ge(walletBalanceFetchUI)), Integer.valueOf(ge), Integer.valueOf(walletBalanceFetchUI.gnS));
            if (ge > 0 && ge < walletBalanceFetchUI.gnS) {
                i = walletBalanceFetchUI.gnS - ge;
                ab.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                walletBalanceFetchUI.jcl.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45354);
                        WalletBalanceFetchUI.this.jcl.scrollBy(0, i);
                        AppMethodBeat.o(45354);
                    }
                });
            }
        }
        AppMethodBeat.o(45421);
    }
}
