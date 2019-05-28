package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14111y;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14111y.C7529c;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C22496p;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C22496p.C22497a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C141147;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295346;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295358;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295389;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35403x;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4319s;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C46335aa;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C46335aa.C40053c;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.C4347a.C4348a;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtArriveTimeLayout.C29555a;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C35921ha;
import com.tencent.p177mm.protocal.protobuf.C7263hc;
import com.tencent.p177mm.protocal.protobuf.azb;
import com.tencent.p177mm.protocal.protobuf.bfi;
import com.tencent.p177mm.protocal.protobuf.bnp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI */
public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI {
    private int accountType;
    private Dialog gnn;
    private int mode;
    private HashMap<String, Integer> pas = new HashMap();
    private Bankcard tgC;
    private C35403x tgd = ((C35403x) mo74556Z(C35403x.class));
    private C14111y tge = ((C14111y) mo74555V(C14111y.class));
    private TextView tkA;
    private WalletLqtArriveTimeLayout tkB;
    private ScrollView tkC;
    private WcPayKeyboard tkD;
    private CharSequence tkE;
    private Bankcard tkF;
    private int tkG;
    private String tkH;
    private String tkI;
    private long tkJ = -1;
    private String tkK;
    private boolean tkL = false;
    private List<Bankcard> tkM;
    private boolean tkN = true;
    private C22497a tkO = new C3542812();
    private C29536z tkm = new C29536z(this.tgd, this.tge, this);
    private C46335aa tkn = new C46335aa(this.tkm);
    private ViewGroup tko;
    private WalletFormView tkp;
    private TextView tkq;
    private TextView tkr;
    private ImageView tks;
    private TextView tkt;
    private TextView tku;
    private ViewGroup tkv;
    private TextView tkw;
    private CheckBox tkx;
    private TextView tky;
    private TextView tkz;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$20 */
    class C1414920 implements C18765a {
        C1414920() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(45671);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(45670);
                    if (!(WalletLqtSaveFetchUI.this.tgC == null || WalletLqtSaveFetchUI.this.tks == null || WalletLqtSaveFetchUI.this.tks.getTag() == null || !WalletLqtSaveFetchUI.this.tks.getTag().equals(WalletLqtSaveFetchUI.this.tgC.field_bindSerial))) {
                        WalletLqtSaveFetchUI.this.tks.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.m2505o(45670);
                }
            });
            AppMethodBeat.m2505o(45671);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$14 */
    class C2251414 implements C35502a {
        C2251414() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(45665);
            C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
            C36391e.m59984a(WalletLqtSaveFetchUI.this.mController.ylL, C22496p.tfu.tfr, true, 1);
            AppMethodBeat.m2505o(45665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$15 */
    class C2251515 implements C5681a<Object, Void> {
        C2251515() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45666);
            WalletLqtSaveFetchUI.m58130b(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.this.tkp.getText());
            AppMethodBeat.m2505o(45666);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$16 */
    class C2251616 implements C4348a {
        C2251616() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(45667);
            WalletLqtSaveFetchUI.this.tkp.setText(C36391e.m59971F(WalletLqtSaveFetchUI.this.tkF.twS));
            WalletLqtSaveFetchUI.this.dOA();
            AppMethodBeat.m2505o(45667);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$4 */
    class C225174 implements OnClickListener {
        C225174() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45647);
            WalletLqtSaveFetchUI.this.tkx.setChecked(!WalletLqtSaveFetchUI.this.tkx.isChecked());
            AppMethodBeat.m2505o(45647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$5 */
    class C225185 implements OnCheckedChangeListener {
        C225185() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(45648);
            if (z) {
                WalletLqtSaveFetchUI.m58128a(WalletLqtSaveFetchUI.this, true);
                AppMethodBeat.m2505o(45648);
                return;
            }
            WalletLqtSaveFetchUI.m58128a(WalletLqtSaveFetchUI.this, false);
            AppMethodBeat.m2505o(45648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$7 */
    class C295827 implements TextWatcher {
        C295827() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(45652);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
            } else if (indexOf > 12) {
                editable.delete(12, indexOf);
            } else if (indexOf == -1 && length > 12) {
                editable.delete(12, length);
            }
            WalletLqtSaveFetchUI.m58130b(WalletLqtSaveFetchUI.this, editable.toString());
            AppMethodBeat.m2505o(45652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$8 */
    class C354258 implements C40947a {
        C354258() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(45653);
            if (!z) {
                WalletLqtSaveFetchUI.this.tkC.scrollTo(0, 0);
                if (WalletLqtSaveFetchUI.this.mode == 2 && C5046bo.isNullOrNil(WalletLqtSaveFetchUI.this.tkp.getText())) {
                    WalletLqtSaveFetchUI.m58150o(WalletLqtSaveFetchUI.this);
                }
            } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                WalletLqtSaveFetchUI.m58145m(WalletLqtSaveFetchUI.this);
                AppMethodBeat.m2505o(45653);
                return;
            } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                WalletLqtSaveFetchUI.m58145m(WalletLqtSaveFetchUI.this);
                AppMethodBeat.m2505o(45653);
                return;
            }
            AppMethodBeat.m2505o(45653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$11 */
    class C3542711 implements C29555a {
        C3542711() {
        }

        public final void cNf() {
            AppMethodBeat.m2504i(45662);
            WalletLqtSaveFetchUI.m58128a(WalletLqtSaveFetchUI.this, true);
            AppMethodBeat.m2505o(45662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$12 */
    class C3542812 implements C22497a {
        C3542812() {
        }

        public final void cMI() {
            AppMethodBeat.m2504i(45663);
            WalletLqtSaveFetchUI.this.cNm();
            AppMethodBeat.m2505o(45663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$13 */
    class C3542913 implements Runnable {
        C3542913() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45664);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WalletLqtSaveFetchUI.this.findViewById(2131828872).getLocationInWindow(iArr);
            WalletLqtSaveFetchUI.this.tkC.getLocationInWindow(iArr2);
            C4990ab.m7411d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", Integer.valueOf(iArr[1] - iArr2[1]));
            WalletLqtSaveFetchUI.this.tkC.scrollBy(0, iArr[1] - iArr2[1]);
            AppMethodBeat.m2505o(45664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$19 */
    class C3543019 implements DialogInterface.OnClickListener {
        C3543019() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$1 */
    class C354311 implements OnClickListener {
        C354311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45644);
            WalletLqtSaveFetchUI.this.aoB();
            WalletLqtSaveFetchUI.m58126a(WalletLqtSaveFetchUI.this);
            AppMethodBeat.m2505o(45644);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$3 */
    class C354323 implements C30857a {
        C354323() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(45646);
            C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", bundle);
            AppMethodBeat.m2505o(45646);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$9 */
    class C354349 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$9$1 */
        class C295831 implements C5690a {
            C295831() {
            }

            /* renamed from: bi */
            public final void mo9345bi(Object obj) {
                AppMethodBeat.m2504i(45654);
                C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", obj);
                WalletLqtSaveFetchUI.this.aDw();
                if (obj != null) {
                    String obj2;
                    if (obj instanceof String) {
                        obj2 = obj.toString();
                    } else {
                        obj2 = WalletLqtSaveFetchUI.this.getString(C25738R.string.fiu);
                    }
                    WalletLqtSaveFetchUI.this.mo56166Vz(obj2);
                }
                AppMethodBeat.m2505o(45654);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$9$3 */
        class C295853 implements C5690a {
            C295853() {
            }

            /* renamed from: bi */
            public final void mo9345bi(Object obj) {
                AppMethodBeat.m2504i(45657);
                WalletLqtSaveFetchUI.this.aDw();
                if (obj != null) {
                    String obj2;
                    if (obj instanceof String) {
                        obj2 = obj.toString();
                    } else {
                        obj2 = WalletLqtSaveFetchUI.this.getString(C25738R.string.fiu);
                    }
                    WalletLqtSaveFetchUI.this.mo56166Vz(obj2);
                }
                AppMethodBeat.m2505o(45657);
            }
        }

        C354349() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45660);
            if (C5046bo.m7525az(WalletLqtSaveFetchUI.this.tkJ) < 800) {
                C4990ab.m7410d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
                AppMethodBeat.m2505o(45660);
                return;
            }
            WalletLqtSaveFetchUI.this.tkJ = C5046bo.m7588yz();
            final int gJ = WalletLqtSaveFetchUI.m58139gJ(WalletLqtSaveFetchUI.this.tkp.getText(), "100");
            if (gJ > 0) {
                WalletLqtSaveFetchUI.this.dOz();
                int q;
                if (WalletLqtSaveFetchUI.this.mode == 1) {
                    C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
                    C40053c c40053c = WalletLqtSaveFetchUI.this.tkn.tgp;
                    q = WalletLqtSaveFetchUI.this.accountType;
                    C5698f.m8561h(Integer.valueOf(gJ), Integer.valueOf(q), WalletLqtSaveFetchUI.this.tgC).mo15892c(c40053c).mo15896f(new C5681a<Void, bnp>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(45656);
                            Void a = m46923a((bnp) obj);
                            AppMethodBeat.m2505o(45656);
                            return a;
                        }

                        /* renamed from: a */
                        private Void m46923a(bnp bnp) {
                            AppMethodBeat.m2504i(45655);
                            C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", Integer.valueOf(bnp.wQn));
                            Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                            intent.putExtra("key_amount", C36391e.m59996b(gJ, "100", RoundingMode.HALF_UP));
                            intent.putExtra("key_mode", 1);
                            intent.putExtra("profile_date_wording", bnp.wQp);
                            intent.putExtra("profile_upgrade_wording", bnp.wQo);
                            if (bnp.wQq != null) {
                                try {
                                    intent.putExtra("key_guide_cell", bnp.wQq.toByteArray());
                                } catch (IOException e) {
                                    C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
                                }
                            }
                            WalletLqtSaveFetchUI.this.startActivity(intent);
                            WalletLqtSaveFetchUI.this.finish();
                            Void voidR = zXH;
                            AppMethodBeat.m2505o(45655);
                            return voidR;
                        }
                    }).mo11586a((C5690a) new C295831());
                    AppMethodBeat.m2505o(45660);
                    return;
                } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                    C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
                    Object obj = null;
                    if (!(WalletLqtSaveFetchUI.this.tgC == null || WalletLqtSaveFetchUI.this.tgC.cPc())) {
                        obj = new C35921ha();
                        obj.nuL = WalletLqtSaveFetchUI.this.tgC.field_bankName;
                        obj.pbn = WalletLqtSaveFetchUI.this.tgC.field_bankcardType;
                        obj.vJF = WalletLqtSaveFetchUI.this.tgC.field_bindSerial;
                        obj.pck = WalletLqtSaveFetchUI.this.tgC.field_bankcardTail;
                    }
                    q = -1;
                    if (WalletLqtSaveFetchUI.this.tkB.getSelectRedeemType() != null) {
                        q = WalletLqtSaveFetchUI.this.tkB.getSelectRedeemType().wOl;
                    }
                    C5698f.m8558b(Integer.valueOf(gJ), Integer.valueOf(WalletLqtSaveFetchUI.this.accountType), Integer.valueOf(q), obj).mo15892c(WalletLqtSaveFetchUI.this.tkn.tgq).mo15896f(new C5681a<Void, bqq>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(45659);
                            Void a = m58161a((bqq) obj);
                            AppMethodBeat.m2505o(45659);
                            return a;
                        }

                        /* renamed from: a */
                        private Void m58161a(bqq bqq) {
                            AppMethodBeat.m2504i(45658);
                            C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", bqq, Boolean.valueOf(bqq.wSW), Boolean.valueOf(bqq.wSX));
                            if (bqq.wSW && bqq.wSX) {
                                Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                                intent.putExtra("key_amount", C36391e.m59996b(gJ, "100", RoundingMode.HALF_UP));
                                intent.putExtra("key_mode", 2);
                                WalletLqtSaveFetchUI.this.startActivity(intent);
                            } else {
                                Intent intent2 = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressUI.class);
                                try {
                                    intent2.putExtra("key_redeem_res", bqq.toByteArray());
                                } catch (Exception e) {
                                    C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "pass redeemFundRes error: %s", e.getMessage());
                                }
                                WalletLqtSaveFetchUI.this.startActivity(intent2);
                            }
                            WalletLqtSaveFetchUI.this.finish();
                            Void voidR = zXH;
                            AppMethodBeat.m2505o(45658);
                            return voidR;
                        }
                    }).mo11586a((C5690a) new C295853());
                }
            }
            AppMethodBeat.m2505o(45660);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletLqtSaveFetchUI() {
        AppMethodBeat.m2504i(45676);
        AppMethodBeat.m2505o(45676);
    }

    /* renamed from: gI */
    static /* synthetic */ double m58138gI(String str, String str2) {
        AppMethodBeat.m2504i(45699);
        double gG = WalletLqtSaveFetchUI.m58136gG(str, str2);
        AppMethodBeat.m2505o(45699);
        return gG;
    }

    /* renamed from: gJ */
    static /* synthetic */ int m58139gJ(String str, String str2) {
        AppMethodBeat.m2504i(45708);
        int gH = WalletLqtSaveFetchUI.m58137gH(str, str2);
        AppMethodBeat.m2505o(45708);
        return gH;
    }

    /* renamed from: i */
    static /* synthetic */ void m58141i(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45701);
        walletLqtSaveFetchUI.m58146mP(false);
        AppMethodBeat.m2505o(45701);
    }

    /* renamed from: k */
    static /* synthetic */ List m58143k(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45703);
        List cNo = walletLqtSaveFetchUI.cNo();
        AppMethodBeat.m2505o(45703);
        return cNo;
    }

    /* renamed from: m */
    static /* synthetic */ void m58145m(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45706);
        walletLqtSaveFetchUI.cNp();
        AppMethodBeat.m2505o(45706);
    }

    public final void cNm() {
        AppMethodBeat.m2504i(45678);
        if (this.mode == 1) {
            this.tkF = C22496p.tfu.cMF();
            if (this.tkF == null) {
                C46332s.cNC();
                this.tkF = C46332s.cND().thy;
            }
            if (this.tkF != null) {
                String cMG = C22496p.tfu.cMG();
                int cMH = C22496p.tfu.cMH();
                if (cMH == 0) {
                    this.tkE = cMG;
                } else if (cMH == 1) {
                    cMH = cMG.length();
                    SpannableString spannableString = new SpannableString(cMG + getString(C25738R.string.fhy));
                    spannableString.setSpan(new C4347a(new C2251616()), cMH + 1, spannableString.length(), 18);
                    this.tkE = spannableString;
                } else {
                    C4990ab.m7421w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", Integer.valueOf(cMH));
                    this.tkE = cMG;
                }
                if (this.tkt != null) {
                    this.tkt.setText(this.tkE);
                }
            }
            if (this.tko != null) {
                this.tko.setVisibility(0);
            }
        }
        m58146mP(true);
        AppMethodBeat.m2505o(45678);
    }

    private void cNn() {
        AppMethodBeat.m2504i(45679);
        WalletLqtArriveTimeLayout walletLqtArriveTimeLayout = this.tkB;
        walletLqtArriveTimeLayout.thY = false;
        if (walletLqtArriveTimeLayout.thU != null) {
            walletLqtArriveTimeLayout.thU.clear();
        }
        walletLqtArriveTimeLayout.thW = null;
        walletLqtArriveTimeLayout.thV.clear();
        walletLqtArriveTimeLayout.setVisibility(4);
        AppMethodBeat.m2505o(45679);
    }

    /* renamed from: t */
    private void m58155t(boolean z, String str) {
        AppMethodBeat.m2504i(45680);
        C4990ab.m7411d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", Boolean.valueOf(z));
        if (this.mode == 2) {
            if (this.tkB.thY) {
                this.tkB.acj(str);
            } else {
                bfi bfi = C4319s.cMK().tfI;
                if (bfi == null) {
                    C4990ab.m7420w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
                    AppMethodBeat.m2505o(45680);
                    return;
                }
                boolean z2;
                if (this.tgC.cPc()) {
                    C4990ab.m7410d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
                    this.tkB.setRedeemTypeList(bfi.wJf);
                    this.tkB.acj(str);
                    if (!(bfi.wJf == null || bfi.wJf.isEmpty())) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (bfi.wJg != null) {
                        Iterator it = bfi.wJg.iterator();
                        z2 = false;
                        while (it.hasNext()) {
                            boolean z3;
                            C7263hc c7263hc = (C7263hc) it.next();
                            if (c7263hc.vJF.equals(this.tgC.field_bindSerial)) {
                                C4990ab.m7410d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                                this.tkB.setRedeemTypeList(c7263hc.vJL);
                                this.tkB.acj(str);
                                if (!(c7263hc.vJL == null || c7263hc.vJL.isEmpty())) {
                                    z3 = true;
                                    z2 = z3;
                                }
                            }
                            z3 = z2;
                            z2 = z3;
                        }
                    }
                    z2 = false;
                }
                C4990ab.m7411d("MicroMsg.WalletLqtSaveFetchUI", "show title: %s", Boolean.valueOf(z2));
                cNp();
                AppMethodBeat.m2505o(45680);
                return;
            }
        }
        AppMethodBeat.m2505o(45680);
    }

    /* renamed from: mP */
    private void m58146mP(boolean z) {
        Bankcard bankcard;
        int i;
        String str;
        AppMethodBeat.m2504i(45681);
        List mJ = C22496p.tfu.mo38054mJ(this.mode == 1);
        if (mJ == null || mJ.size() == 0) {
            C46332s.cNC();
            mJ = C46332s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard2 : mJ) {
                if (bankcard2.cPc()) {
                    C46332s.cNC();
                    if (!C46332s.cND().cQi()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (this.mode == 1 && bankcard2.field_support_lqt_turn_in == 1) {
                    linkedList.add(bankcard2);
                }
                if (this.mode == 2 && bankcard2.field_support_lqt_turn_out == 1) {
                    linkedList.add(bankcard2);
                }
            }
        }
        if (z) {
            boolean z2;
            C22496p c22496p = C22496p.tfu;
            if (this.mode == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.tgC = c22496p.mo38053mI(z2);
            if (!C5046bo.isNullOrNil(this.tkK) && this.tgC == null) {
                for (i = 0; i < linkedList.size(); i++) {
                    bankcard2 = (Bankcard) linkedList.get(i);
                    if (!C5046bo.isNullOrNil(bankcard2.field_bindSerial) && this.tkK.equals(bankcard2.field_bindSerial)) {
                        this.tgC = bankcard2;
                    }
                }
            }
        } else if (!C5046bo.isNullOrNil(this.tkK)) {
            for (i = 0; i < linkedList.size(); i++) {
                bankcard2 = (Bankcard) linkedList.get(i);
                if (!C5046bo.isNullOrNil(bankcard2.field_bindSerial) && this.tkK.equals(bankcard2.field_bindSerial)) {
                    this.tgC = bankcard2;
                }
            }
        }
        String str2 = "MicroMsg.WalletLqtSaveFetchUI";
        String str3 = "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.tgC != null ? this.tgC.field_bindSerial : "";
        objArr[1] = this.tkK;
        objArr[2] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        if (this.tgC == null) {
            C46332s.cNC();
            this.tgC = C46332s.cND().thy;
            if (this.tgC == null) {
                finish();
                AppMethodBeat.m2505o(45681);
                return;
            }
        }
        if (this.tgC.cPc()) {
            this.tkr.setText(this.tgC.field_desc);
        } else {
            this.tkr.setText(getString(C25738R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
        }
        this.tkr.setText(this.tgC.field_desc);
        this.tkr.setVisibility(0);
        this.tks.setTag(this.tgC.field_bindSerial);
        if (this.tks != null) {
            str = "";
            C43807e i2 = C46362b.m87144i(this, this.tgC.field_bankcardType, this.tgC.cPb());
            if (i2 != null) {
                str = i2.oRi;
            }
            this.tks.setImageBitmap(null);
            if (this.tgC.cPc()) {
                this.tks.setImageResource(C25738R.drawable.bki);
            } else {
                Bitmap a = C18764x.m29325a(new C4467c(str));
                C18764x.m29326a(new C1414920());
                if (a != null) {
                    this.tks.setImageBitmap(C5056d.m7615a(a, getResources().getDimensionPixelOffset(C25738R.dimen.aaq), getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false));
                }
            }
        }
        this.tky.setVisibility(8);
        this.tkz.setVisibility(8);
        if (!(this.mode == 2 || this.mode != 1 || this.tgC.cPc() || C5046bo.isNullOrNil(this.tgC.field_avail_save_wording))) {
            this.tky.setText(this.tgC.field_avail_save_wording);
            this.tky.setVisibility(0);
        }
        String string;
        SpannableString spannableString;
        if (this.mode == 1) {
            setMMTitle(getString(C25738R.string.fjx));
            final ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.tkv.setVisibility(8);
            } else {
                this.tkv.setVisibility(0);
                this.tkx.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.tkv.setOnClickListener(new C225174());
                this.tkx.setOnCheckedChangeListener(new C225185());
                string = getString(C25738R.string.fjl);
                i = string.length();
                spannableString = new SpannableString(string + getString(C25738R.string.fjm));
                spannableString.setSpan(new C4347a(new C4348a() {

                    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$6$2 */
                    class C295802 implements C5279d {
                        C295802() {
                        }

                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.m2504i(45650);
                            int itemId = menuItem.getItemId();
                            if (itemId < stringArrayListExtra.size()) {
                                C36391e.m60016n(WalletLqtSaveFetchUI.this, ((String) stringArrayListExtra.get(itemId)).split("\\|\\|")[1], false);
                            }
                            AppMethodBeat.m2505o(45650);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI$6$1 */
                    class C295811 implements C36073c {
                        C295811() {
                        }

                        /* renamed from: a */
                        public final void mo5746a(C44273l c44273l) {
                            AppMethodBeat.m2504i(45649);
                            Iterator it = stringArrayListExtra.iterator();
                            int i = 0;
                            while (it.hasNext()) {
                                c44273l.add(0, i, 0, ((String) it.next()).split("\\|\\|")[0]);
                                i++;
                            }
                            AppMethodBeat.m2505o(45649);
                        }
                    }

                    public final void aos() {
                        AppMethodBeat.m2504i(45651);
                        C36356d c36356d = new C36356d(WalletLqtSaveFetchUI.this, 1, false);
                        c36356d.rBl = new C295811();
                        c36356d.rBm = new C295802();
                        c36356d.cpD();
                        AppMethodBeat.m2505o(45651);
                    }
                }), i, spannableString.length(), 17);
                this.tkw.setText(spannableString);
                this.tkw.setClickable(true);
                this.tkw.setOnTouchListener(new C30132m());
            }
        } else if (this.mode == 2) {
            findViewById(2131828875).setVisibility(8);
            this.tkv.setVisibility(8);
            setMMTitle(getString(C25738R.string.fir));
            this.tku.setVisibility(8);
            final C4319s cMK = C4319s.cMK();
            int i3;
            if (this.tgC == null || !this.tgC.cPc()) {
                if (cMK.tfI == null) {
                    i3 = 0;
                } else {
                    i3 = cMK.tfI.wJb;
                }
                i = cMK.tfI == null ? 0 : cMK.tfI.wJd;
                if (C1947ae.gjv) {
                    i3 = 100000000;
                    i = 50000000;
                }
                str = getString(C25738R.string.fim, new Object[]{Double.valueOf(WalletLqtSaveFetchUI.m58136gG(String.valueOf(i3), "100")), Double.valueOf(WalletLqtSaveFetchUI.m58136gG(String.valueOf(i), "100"))});
                int length = str.length();
                SpannableString spannableString2 = new SpannableString(str + getString(C25738R.string.fin));
                spannableString2.setSpan(new C4347a(new C4348a() {
                    public final void aos() {
                        AppMethodBeat.m2504i(45669);
                        WalletLqtSaveFetchUI.m58127a(WalletLqtSaveFetchUI.this, cMK.tfI);
                        AppMethodBeat.m2505o(45669);
                    }
                }), length, spannableString2.length(), 18);
                this.tkE = spannableString2;
                this.tkt.setText(spannableString2);
            } else {
                i3 = getIntent().getIntExtra("lqt_balance", 0);
                if (C1947ae.gjv) {
                    i3 = 50000000;
                }
                if (i3 > 0) {
                    string = getString(C25738R.string.fil, new Object[]{Double.valueOf(WalletLqtSaveFetchUI.m58136gG(String.valueOf(i3), "100"))});
                    i = string.length();
                    spannableString = new SpannableString(string + getString(C25738R.string.fio));
                    spannableString.setSpan(new C4347a(new C4348a() {
                        public final void aos() {
                            AppMethodBeat.m2504i(45668);
                            WalletLqtSaveFetchUI.this.tkp.setText(C36391e.m59971F(WalletLqtSaveFetchUI.m58138gI(i3, "100")));
                            WalletLqtSaveFetchUI.this.dOA();
                            AppMethodBeat.m2505o(45668);
                        }
                    }), i, spannableString.length(), 18);
                    this.tkE = spannableString;
                    this.tkt.setText(spannableString);
                }
            }
        }
        if (this.mode == 1) {
            if (this.tgC == null || !this.tgC.cPc()) {
                this.tkt.setText("");
            } else {
                this.tkt.setText(this.tkE);
                AppMethodBeat.m2505o(45681);
                return;
            }
        }
        AppMethodBeat.m2505o(45681);
    }

    private List<Bankcard> cNo() {
        AppMethodBeat.m2504i(45682);
        List mJ = C22496p.tfu.mo38054mJ(this.mode == 1);
        if (mJ == null || mJ.size() == 0) {
            C46332s.cNC();
            mJ = C46332s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard : mJ) {
                if (bankcard.cPc()) {
                    C46332s.cNC();
                    if (!C46332s.cND().cQi()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
            }
        }
        AppMethodBeat.m2505o(45682);
        return linkedList;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(45683);
        C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
        super.onNewIntent(intent);
        final List cNo = cNo();
        if (this.mode == 1) {
            this.tkn.tgs.mo74550gf(this.mode, this.accountType).mo15896f(new C5681a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(45645);
                    for (Bankcard bankcard : WalletLqtSaveFetchUI.m58143k(WalletLqtSaveFetchUI.this)) {
                        Object obj2;
                        for (Bankcard bankcard2 : cNo) {
                            if (bankcard.field_bindSerial.equals(bankcard2.field_bindSerial)) {
                                obj2 = 1;
                                continue;
                                break;
                            }
                        }
                        obj2 = null;
                        continue;
                        if (obj2 == null) {
                            WalletLqtSaveFetchUI.this.tkK = bankcard.field_bindSerial;
                            break;
                        }
                    }
                    WalletLqtSaveFetchUI.m58141i(WalletLqtSaveFetchUI.this);
                    Void voidR = zXH;
                    AppMethodBeat.m2505o(45645);
                    return voidR;
                }
            });
        }
        AppMethodBeat.m2505o(45683);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45684);
        if (this.tkD.isShown() && C5046bo.isNullOrNil(this.tkp.getText())) {
            dOz();
            AppMethodBeat.m2505o(45684);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45684);
        return onKeyUp;
    }

    private void cNp() {
        AppMethodBeat.m2504i(45685);
        this.tkC.postDelayed(new C3542913(), 100);
        AppMethodBeat.m2505o(45685);
    }

    /* renamed from: mQ */
    private void m58147mQ(boolean z) {
        AppMethodBeat.m2504i(45686);
        this.tkD.Aff.setEnabled(z);
        AppMethodBeat.m2505o(45686);
    }

    /* renamed from: mR */
    private void m58148mR(boolean z) {
        AppMethodBeat.m2504i(45687);
        if (z) {
            if (this.mode == 1) {
                if (this.tkv.getVisibility() != 0) {
                    if (this.tkL) {
                        m58147mQ(true);
                        AppMethodBeat.m2505o(45687);
                        return;
                    }
                    AppMethodBeat.m2505o(45687);
                } else if (this.tkx.isChecked() && this.tkL) {
                    m58147mQ(true);
                    AppMethodBeat.m2505o(45687);
                    return;
                } else {
                    m58147mQ(false);
                    AppMethodBeat.m2505o(45687);
                    return;
                }
            } else if (this.tkL && this.tkB.getVisibility() == 0 && (this.tkB.getSelectRedeemType() != null || this.tkB.getRedeemTypeList() == null || this.tkB.getRedeemTypeList().isEmpty())) {
                String str = "MicroMsg.WalletLqtSaveFetchUI";
                String str2 = "redeem type: %s";
                Object[] objArr = new Object[1];
                objArr[0] = this.tkB.getSelectRedeemType() == null ? null : Integer.valueOf(this.tkB.getSelectRedeemType().wOl);
                C4990ab.m7419v(str, str2, objArr);
                m58147mQ(true);
                AppMethodBeat.m2505o(45687);
                return;
            }
        }
        m58147mQ(false);
        AppMethodBeat.m2505o(45687);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45688);
        super.onResume();
        AppMethodBeat.m2505o(45688);
    }

    public final int getLayoutId() {
        return 2130971122;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45689);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            this.tkn.tgs.mo74550gf(this.mode, this.accountType).mo15896f(new C2251515());
            AppMethodBeat.m2505o(45689);
            return;
        }
        C29536z c29536z = this.tkm;
        String str;
        if (i == C29536z.tgb && i2 == -1) {
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (!(orders == null || orders.tAq == null || orders.tAq.size() <= 0)) {
                C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", Integer.valueOf(c29536z.hashCode()), Integer.valueOf(c29536z.accountType), orders.czZ);
                c29536z.cAa = ((Commodity) orders.tAq.get(0)).cAa;
                str = (String) c29536z.tgl.get(orders.czZ);
                if (!C5046bo.isNullOrNil(str)) {
                    c29536z.tgg = str;
                }
                C4990ab.m7416i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
                c29536z.tgf.mo56170mS(false);
                str = c29536z.tgf.getIntent().getStringExtra("operate_id");
                C5698f.m8553a(c29536z.tgg, c29536z.cAa, Integer.valueOf(c29536z.tgh), Integer.valueOf(c29536z.accountType), str).mo15892c(c29536z.tge.tfX).mo15896f(new C141147()).mo11586a((C5690a) new C295346());
            }
            AppMethodBeat.m2505o(45689);
            return;
        }
        if (i == C29536z.tgc && i2 == -1) {
            str = intent.getStringExtra("lqt_fetch_enc_pwd");
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", Integer.valueOf(c29536z.hashCode()), Integer.valueOf(c29536z.accountType), intent.getStringExtra("lqt_redeem_listid"));
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", Integer.valueOf(c29536z.hashCode()), r1);
            if (C5046bo.isNullOrNil(c29536z.tgj)) {
                C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", Integer.valueOf(c29536z.hashCode()), r1);
                c29536z.tgj = r1;
            }
            String stringExtra = c29536z.tgf.getIntent().getStringExtra("operate_id");
            c29536z.tgf.mo56170mS(true);
            C7529c c7529c = c29536z.tge.tfY;
            int i3 = c29536z.tgi;
            C5698f.m8553a(Integer.valueOf(i3), str, c29536z.tgj, Integer.valueOf(c29536z.accountType), stringExtra).mo15892c(c7529c).mo15896f(new C295389()).mo11586a((C5690a) new C295358());
        }
        AppMethodBeat.m2505o(45689);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45690);
        C29536z c29536z = this.tkm;
        C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (c1207m instanceof C35475y) {
            C46332s.cNC();
            c29536z.tgk = C46332s.cND().thy;
            if (c29536z.glt != null) {
                c29536z.glt.mo11581B(c1207m);
                c29536z.glt.resume();
            }
        }
        C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
        cNm();
        boolean c = super.mo7885c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(45690);
        return c;
    }

    /* renamed from: mS */
    public final void mo56170mS(boolean z) {
        AppMethodBeat.m2504i(45691);
        if (this.gnn == null || !this.gnn.isShowing()) {
            if (z) {
                this.gnn = C30901g.m49317a((Context) this, false, null);
                AppMethodBeat.m2505o(45691);
                return;
            }
            this.gnn = C30901g.m49318b(this, false, null);
        }
        AppMethodBeat.m2505o(45691);
    }

    public final void aDw() {
        AppMethodBeat.m2504i(45692);
        if (this.gnn != null) {
            this.gnn.dismiss();
        }
        AppMethodBeat.m2505o(45692);
    }

    public final void cNq() {
        boolean z = true;
        AppMethodBeat.m2504i(45693);
        if (this.mode == 1) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, this.tkK);
        } else {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC, this.tkK);
        }
        C22496p c22496p = C22496p.tfu;
        if (this.mode != 1) {
            z = false;
        }
        if (c22496p.mo38052mH(z)) {
            C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
            this.tkn.tgs.mo74550gf(this.mode, this.accountType);
        }
        AppMethodBeat.m2505o(45693);
    }

    /* renamed from: Vz */
    public final void mo56166Vz(String str) {
        AppMethodBeat.m2504i(45694);
        Toast.makeText(this, str, 1).show();
        AppMethodBeat.m2505o(45694);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45695);
        super.onDestroy();
        C22496p c22496p = C22496p.tfu;
        c22496p.tft.remove(this.tkO);
        this.tkm = null;
        this.tkn = null;
        AppMethodBeat.m2505o(45695);
    }

    /* renamed from: gG */
    private static double m58136gG(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.m2504i(45696);
        try {
            d = new BigDecimal(C5046bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 5, 2).doubleValue();
            AppMethodBeat.m2505o(45696);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(45696);
        }
        return d;
    }

    /* renamed from: gH */
    private static int m58137gH(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(45697);
        try {
            double d = C5046bo.getDouble(str, 0.0d);
            double d2 = C5046bo.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            i = bigDecimal.multiply(new BigDecimal(str2)).intValue();
            AppMethodBeat.m2505o(45697);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(45697);
        }
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45677);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f11642a5));
        dyb();
        C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
        this.tkp = (WalletFormView) findViewById(2131828873);
        this.tks = (ImageView) findViewById(2131828609);
        this.tkt = (TextView) findViewById(2131828874);
        this.tku = (TextView) findViewById(2131828876);
        this.tkq = (TextView) findViewById(2131828872);
        this.tkr = (TextView) findViewById(2131828870);
        this.tkA = (TextView) findViewById(2131820694);
        this.tkv = (ViewGroup) findViewById(2131828878);
        this.tkw = (TextView) findViewById(2131828880);
        this.tkx = (CheckBox) findViewById(2131828879);
        this.tko = (ViewGroup) findViewById(2131824519);
        this.tky = (TextView) findViewById(2131828611);
        this.tkz = (TextView) findViewById(2131828612);
        this.tkB = (WalletLqtArriveTimeLayout) findViewById(2131828877);
        this.tkC = (ScrollView) findViewById(2131828868);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        this.tkG = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.tkH = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.tkI = getIntent().getStringExtra("lqt_profile_wording");
        this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
        if (this.mode == 1) {
            C1720g.m3537RQ();
            this.tkK = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, (Object) "");
        } else {
            C1720g.m3537RQ();
            this.tkK = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC, (Object) "");
        }
        if (C5046bo.isNullOrNil(this.tkK)) {
            C1720g.m3537RQ();
            this.tkK = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_DEFAULTCARD_STRING_SYNC, (Object) "");
        }
        C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.tkK);
        this.tkp.getTitleTv().setText(C44423ae.dOd());
        this.tkD = (WcPayKeyboard) findViewById(2131829144);
        if (this.mode == 1) {
            mo39990e(this.tkp.getContentEt());
            this.tkD.setActionText(getString(C25738R.string.fjx));
        } else {
            this.Ahz = false;
            mo39990e(this.tkp.getContentEt());
            this.tkD.setActionText(getString(C25738R.string.fiq));
        }
        if (this.mode == 1) {
            this.tkq.setText(getString(C25738R.string.fjq));
            this.tkA.setText(getString(C25738R.string.fjt));
        } else if (this.mode == 2) {
            this.tkq.setText(getString(C25738R.string.fi_));
            this.tkA.setText(getString(C25738R.string.fie));
        }
        this.tkp.mo64594a(new C295827());
        this.obM = new C354258();
        final C354349 c354349 = new C354349();
        this.tkp.getContentEt().setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.m2504i(45661);
                if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
                    c354349.onClick(null);
                    AppMethodBeat.m2505o(45661);
                } else {
                    AppMethodBeat.m2505o(45661);
                }
                return true;
            }
        });
        if (!C5046bo.isNullOrNil(this.tkI)) {
            this.tkD.setTipText(this.tkI);
        }
        if (this.mode == 2) {
            this.tkB.setCallback(new C3542711());
        }
        this.tkt.setText("");
        this.tkt.setClickable(true);
        this.tkt.setOnTouchListener(new C30132m(this));
        m58148mR(false);
        if (this.mode == 1) {
            this.tko.setVisibility(4);
        }
        if (this.tkr.findViewById(2131820693) != null) {
            this.tkr.findViewById(2131820693).setVisibility(8);
        }
        C354311 c354311 = new C354311();
        this.tkr.setOnClickListener(c354311);
        if (findViewById(2131828608) != null) {
            findViewById(2131828608).setOnClickListener(c354311);
        }
        cNm();
        C22496p c22496p = C22496p.tfu;
        c22496p.tft.add(this.tkO);
        AppMethodBeat.m2505o(45677);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m58126a(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        String str;
        int i;
        int i2;
        View inflate;
        AppMethodBeat.m2504i(45698);
        walletLqtSaveFetchUI.pas.clear();
        final C36356d c36356d = new C36356d(walletLqtSaveFetchUI, 2, true);
        C22496p c22496p = C22496p.tfu;
        walletLqtSaveFetchUI.tkM = C22496p.m34199Ha(walletLqtSaveFetchUI.mode);
        String str2 = null;
        if (walletLqtSaveFetchUI.tgC != null) {
            str2 = walletLqtSaveFetchUI.tgC.field_bindSerial;
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = walletLqtSaveFetchUI.tkK;
            if (C5046bo.isNullOrNil(walletLqtSaveFetchUI.tkK)) {
                C1720g.m3537RQ();
                str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_DEFAULTCARD_STRING_SYNC, (Object) "");
                i = 0;
                for (i2 = 0; i2 < walletLqtSaveFetchUI.tkM.size(); i2++) {
                    Bankcard bankcard = (Bankcard) walletLqtSaveFetchUI.tkM.get(i2);
                    if (!C5046bo.isNullOrNil(bankcard.field_bindSerial) && str.equals(bankcard.field_bindSerial)) {
                        i = i2;
                    }
                }
                c36356d.rBl = new C36073c() {
                    /* renamed from: a */
                    public final void mo5746a(final C44273l c44273l) {
                        boolean z;
                        AppMethodBeat.m2504i(45674);
                        int size = WalletLqtSaveFetchUI.this.tkM.size();
                        for (int i = 0; i < size; i++) {
                            String str;
                            CharSequence spannableString;
                            String str2;
                            Bankcard bankcard = (Bankcard) WalletLqtSaveFetchUI.this.tkM.get(i);
                            String str3 = "";
                            C43807e i2 = C46362b.m87144i(WalletLqtSaveFetchUI.this, bankcard.field_bankcardType, bankcard.cPb());
                            if (i2 != null) {
                                str = i2.oRi;
                            } else {
                                str = str3;
                            }
                            Bitmap a = C18764x.m29325a(new C4467c(str));
                            C18764x.m29326a(new C18765a() {
                                /* renamed from: m */
                                public final void mo8136m(final String str, final Bitmap bitmap) {
                                    AppMethodBeat.m2504i(45673);
                                    C5004al.m7441d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(45672);
                                            C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                            if (WalletLqtSaveFetchUI.this.pas.containsKey(str)) {
                                                int intValue = ((Integer) WalletLqtSaveFetchUI.this.pas.get(str)).intValue();
                                                if (c44273l.getItem(intValue) != null) {
                                                    c44273l.getItem(intValue).setIcon(new BitmapDrawable(C5056d.m7615a(bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false)));
                                                    c36356d.dKX();
                                                }
                                            }
                                            AppMethodBeat.m2505o(45672);
                                        }
                                    });
                                    AppMethodBeat.m2505o(45673);
                                }
                            });
                            Bitmap bitmap = null;
                            CharSequence charSequence = "";
                            if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                                charSequence = bankcard.field_forbidWord;
                            }
                            if (C5046bo.isNullOrNil(bankcard.field_forbid_title)) {
                                spannableString = new SpannableString(charSequence);
                                str2 = charSequence;
                            } else {
                                str3 = charSequence + " ";
                                spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                                C141542 c141542 = new C46373j(WalletLqtSaveFetchUI.this) {
                                    public final void onClick(View view) {
                                    }
                                };
                                int length = str3.length();
                                int length2 = str3.length() + bankcard.field_forbid_title.length();
                                spannableString.setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(C25738R.color.a50)), length, length2, 33);
                                spannableString.setSpan(c141542, length, length2, 33);
                                str2 = str3;
                            }
                            str3 = bankcard.field_desc;
                            if (bankcard.cPc()) {
                                C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                                c44273l.mo70053a(i, str3, spannableString, WalletLqtSaveFetchUI.this.getResources().getDrawable(C25738R.drawable.bki), !C5046bo.isNullOrNil(str2));
                            } else {
                                if (a != null) {
                                    bitmap = C5056d.m7615a(a, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false);
                                }
                                C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                                c44273l.mo70053a(i, str3, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !C5046bo.isNullOrNil(str2));
                            }
                            if (bitmap == null) {
                                WalletLqtSaveFetchUI.this.pas.put(str, Integer.valueOf(i));
                            }
                        }
                        C22496p c22496p = C22496p.tfu;
                        if (WalletLqtSaveFetchUI.this.mode == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c22496p.mo38055mL(z);
                        azb azb = z ? c22496p.tfi : c22496p.tfj;
                        if (azb != null) {
                            z = azb.wCP;
                        } else {
                            z = false;
                        }
                        if (z) {
                            C4990ab.m7416i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
                            AppMethodBeat.m2505o(45674);
                        } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                            c44273l.mo70053a(size, WalletLqtSaveFetchUI.this.getString(C25738R.string.fjv), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(C25738R.drawable.bkc), false);
                            AppMethodBeat.m2505o(45674);
                        } else {
                            if (WalletLqtSaveFetchUI.this.mode == 2) {
                                c44273l.mo70053a(size, WalletLqtSaveFetchUI.this.getString(C25738R.string.fig), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(C25738R.drawable.bkc), false);
                            }
                            AppMethodBeat.m2505o(45674);
                        }
                    }
                };
                c36356d.rBm = new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(45675);
                        if (c36356d != null) {
                            c36356d.cpE();
                            if (i < WalletLqtSaveFetchUI.this.tkM.size()) {
                                WalletLqtSaveFetchUI.this.tkK = ((Bankcard) WalletLqtSaveFetchUI.this.tkM.get(i)).field_bindSerial;
                                WalletLqtSaveFetchUI.m58141i(WalletLqtSaveFetchUI.this);
                                WalletLqtSaveFetchUI.this.tkp.cey();
                                AppMethodBeat.m2505o(45675);
                                return;
                            } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                                WalletLqtSaveFetchUI.m58142j(WalletLqtSaveFetchUI.this);
                                AppMethodBeat.m2505o(45675);
                                return;
                            } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                                WalletLqtSaveFetchUI.m58142j(WalletLqtSaveFetchUI.this);
                            }
                        }
                        AppMethodBeat.m2505o(45675);
                    }
                };
                inflate = View.inflate(walletLqtSaveFetchUI, 2130969963, null);
                if (walletLqtSaveFetchUI.mode != 1) {
                    ((TextView) inflate.findViewById(2131825370)).setText(C25738R.string.fjp);
                    ((TextView) inflate.findViewById(2131825371)).setText(C25738R.string.fjo);
                } else {
                    ((TextView) inflate.findViewById(2131825370)).setText(C25738R.string.fi9);
                    ((TextView) inflate.findViewById(2131825371)).setText(C25738R.string.fi8);
                }
                c36356d.pIf = true;
                c36356d.zQA = i;
                c36356d.zQy = true;
                c36356d.mo57234F(inflate, false);
                c36356d.cpD();
                AppMethodBeat.m2505o(45698);
            }
        }
        str = str2;
        i = 0;
        while (i2 < walletLqtSaveFetchUI.tkM.size()) {
        }
        c36356d.rBl = /* anonymous class already generated */;
        c36356d.rBm = /* anonymous class already generated */;
        inflate = View.inflate(walletLqtSaveFetchUI, 2130969963, null);
        if (walletLqtSaveFetchUI.mode != 1) {
        }
        c36356d.pIf = true;
        c36356d.zQA = i;
        c36356d.zQy = true;
        c36356d.mo57234F(inflate, false);
        c36356d.cpD();
        AppMethodBeat.m2505o(45698);
    }

    /* renamed from: j */
    static /* synthetic */ void m58142j(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45702);
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) walletLqtSaveFetchUI.mBundle.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.czZ = "";
            if (walletLqtSaveFetchUI.mode == 1) {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    parcelable.cIf = 45;
                } else {
                    parcelable.cIf = 52;
                }
            } else if (walletLqtSaveFetchUI.accountType == 0) {
                parcelable.cIf = 51;
            } else {
                parcelable.cIf = 53;
            }
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 45);
            } else {
                bundle.putInt("key_scene", 52);
            }
            bundle.putInt("key_bind_scene", 16);
        } else {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 51);
            } else {
                bundle.putInt("key_scene", 53);
            }
            bundle.putInt("key_bind_scene", 17);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        C24143a.m37106a((Activity) walletLqtSaveFetchUI, C4349b.class, bundle, new C354323());
        AppMethodBeat.m2505o(45702);
    }

    /* renamed from: b */
    static /* synthetic */ void m58130b(WalletLqtSaveFetchUI walletLqtSaveFetchUI, String str) {
        AppMethodBeat.m2504i(45705);
        C4990ab.m7417i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", str);
        long iz = C36391e.m60013iz(String.valueOf(str), "100");
        if (iz <= 0) {
            if (walletLqtSaveFetchUI.mode != 1) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                walletLqtSaveFetchUI.cNn();
            } else if (walletLqtSaveFetchUI.tgC == null || !walletLqtSaveFetchUI.tgC.cPc()) {
                walletLqtSaveFetchUI.tkt.setText("");
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
            }
            walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
            walletLqtSaveFetchUI.tkL = false;
            walletLqtSaveFetchUI.m58148mR(false);
        } else if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.tgC == null) {
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.m58148mR(true);
            } else if (walletLqtSaveFetchUI.tgC.cPc()) {
                if (walletLqtSaveFetchUI.tkF != null && iz > ((long) WalletLqtSaveFetchUI.m58137gH(walletLqtSaveFetchUI.tkF.twS, "100"))) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(C25738R.string.fjr));
                    walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.m58148mR(false);
                } else if (C22496p.tfu.tfs <= 0 || iz <= ((long) C22496p.tfu.tfs) || C5046bo.isNullOrNil(C22496p.tfu.tfp) || C5046bo.isNullOrNil(C22496p.tfu.tfq) || C5046bo.isNullOrNil(C22496p.tfu.tfr)) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = true;
                    walletLqtSaveFetchUI.m58148mR(true);
                } else {
                    C35503o c35503o = new C35503o(new C2251414());
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(C22496p.tfu.tfp);
                    spannableStringBuilder.append(C22496p.tfu.tfq);
                    spannableStringBuilder.setSpan(c35503o, C22496p.tfu.tfp.length(), spannableStringBuilder.length(), 18);
                    walletLqtSaveFetchUI.tkt.setOnTouchListener(new C30132m(walletLqtSaveFetchUI.mController.ylL));
                    walletLqtSaveFetchUI.tkt.setClickable(true);
                    walletLqtSaveFetchUI.tkt.setText(spannableStringBuilder);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.m58148mR(false);
                }
            } else if (walletLqtSaveFetchUI.tgC.field_dayQuotaKind <= 0.0d || iz <= ((long) WalletLqtSaveFetchUI.m58137gH(walletLqtSaveFetchUI.tgC.field_dayQuotaKind, "100"))) {
                walletLqtSaveFetchUI.tkt.setText("");
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.m58148mR(true);
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(C25738R.string.fjs));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.m58148mR(false);
            }
        } else if (walletLqtSaveFetchUI.mode == 2) {
            int i;
            int i2;
            if (walletLqtSaveFetchUI.tgC == null || !walletLqtSaveFetchUI.tgC.cPc()) {
                bfi bfi = C4319s.cMK().tfI;
                if (bfi == null) {
                    i = 0;
                    i2 = 0;
                } else {
                    i = bfi.wJd;
                    i2 = 0;
                }
            } else {
                i = walletLqtSaveFetchUI.getIntent().getIntExtra("lqt_balance", 0);
                i2 = 1;
            }
            if (i2 != 0) {
                if (iz > ((long) i)) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(C25738R.string.fia));
                    walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.cNn();
                    walletLqtSaveFetchUI.m58148mR(false);
                } else {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = true;
                    walletLqtSaveFetchUI.m58155t(walletLqtSaveFetchUI.tkN, str);
                    walletLqtSaveFetchUI.m58148mR(true);
                }
            } else if (iz > ((long) i)) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(C25738R.string.fib));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.cNn();
                walletLqtSaveFetchUI.m58148mR(false);
            } else if (walletLqtSaveFetchUI.tgC == null || walletLqtSaveFetchUI.tgC.cPc() || walletLqtSaveFetchUI.tgC.field_dayQuotaKind <= 0.0d || iz <= ((long) WalletLqtSaveFetchUI.m58137gH(walletLqtSaveFetchUI.tgC.field_dayQuotaKind, "100"))) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.m58155t(walletLqtSaveFetchUI.tkN, str);
                walletLqtSaveFetchUI.m58148mR(true);
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(C25738R.string.fic, new Object[]{Double.valueOf(walletLqtSaveFetchUI.tgC.field_dayQuotaKind)}));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.cNn();
                walletLqtSaveFetchUI.m58148mR(false);
            }
        }
        if (iz <= 0) {
            walletLqtSaveFetchUI.tkN = true;
            AppMethodBeat.m2505o(45705);
            return;
        }
        walletLqtSaveFetchUI.tkN = false;
        AppMethodBeat.m2505o(45705);
    }

    /* renamed from: o */
    static /* synthetic */ void m58150o(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45707);
        walletLqtSaveFetchUI.tkB.removeAllViews();
        AppMethodBeat.m2505o(45707);
    }
}
