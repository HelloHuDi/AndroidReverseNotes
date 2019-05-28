package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.platformtools.SpellMap;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.BankCardSelectSortView;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.BankCardSelectSortView.C35512a;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a.C143328;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a.C226699;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a.C40139a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI */
public class WalletBankCardSelectUI extends WalletBaseUI {
    private C5601o jKT;
    private boolean jLD = false;
    private BankCardSelectSortView tEc;
    private List<ElementQuery> tEd;
    private List<C36087d> tEe;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI$1 */
    class C225961 implements OnItemClickListener {
        C225961() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47140);
            C36087d c36087d = (C36087d) adapterView.getAdapter().getItem(i);
            WalletBankCardSelectUI walletBankCardSelectUI = WalletBankCardSelectUI.this;
            C35512a c35512a = (C35512a) c36087d.data;
            if (c35512a != null) {
                walletBankCardSelectUI.aqX();
                Intent intent = new Intent();
                intent.putExtra("bank_name", c35512a.pcj);
                C4990ab.m7417i("WalletBankCardSelectUI", "item bank: %s", c35512a.pcj);
                walletBankCardSelectUI.setResult(-1, intent);
                walletBankCardSelectUI.finish();
            }
            AppMethodBeat.m2505o(47140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI$2 */
    class C225972 implements C5600b {
        C225972() {
        }

        public final void app() {
            AppMethodBeat.m2504i(47141);
            WalletBankCardSelectUI.this.jLD = true;
            WalletBankCardSelectUI.this.tEc.mo70149ql(false);
            WalletBankCardSelectUI.this.tEc.setMode(1);
            AppMethodBeat.m2505o(47141);
        }

        public final void apo() {
            AppMethodBeat.m2504i(47142);
            WalletBankCardSelectUI.this.jLD = false;
            WalletBankCardSelectUI.this.aqX();
            WalletBankCardSelectUI.this.tEc.mo70149ql(true);
            WalletBankCardSelectUI.this.tEc.setMode(0);
            AppMethodBeat.m2505o(47142);
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(47143);
            C4990ab.m7411d("WalletBankCardSelectUI", "search text: %s", str);
            WalletBankCardSelectUI.this.tEc.aqS(str);
            AppMethodBeat.m2505o(47143);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            AppMethodBeat.m2504i(47144);
            WalletBankCardSelectUI.this.aqX();
            AppMethodBeat.m2505o(47144);
            return false;
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI$3 */
    class C225983 implements C40139a {
        C225983() {
        }

        /* renamed from: am */
        public final void mo38177am(Map<String, C43807e> map) {
            AppMethodBeat.m2504i(47145);
            C4990ab.m7417i("WalletBankCardSelectUI", "get logo callback: %s", Integer.valueOf(map.size()));
            WalletBankCardSelectUI.m47014a(WalletBankCardSelectUI.this, (Map) map);
            AppMethodBeat.m2505o(47145);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI$4 */
    class C225994 implements Runnable {
        C225994() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47146);
            WalletBankCardSelectUI.this.tEc.mo70141dJ(WalletBankCardSelectUI.this.tEe);
            AppMethodBeat.m2505o(47146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI$a */
    static class C29639a implements Comparator<C36087d> {
        private Collator tEg;

        private C29639a() {
            AppMethodBeat.m2504i(47147);
            this.tEg = Collator.getInstance(Locale.getDefault());
            AppMethodBeat.m2505o(47147);
        }

        /* synthetic */ C29639a(byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(47148);
            C36087d c36087d = (C36087d) obj;
            C36087d c36087d2 = (C36087d) obj2;
            if (!(c36087d == null && c36087d2 == null)) {
                if (c36087d == null) {
                    AppMethodBeat.m2505o(47148);
                    return -1;
                } else if (c36087d2 == null) {
                    AppMethodBeat.m2505o(47148);
                    return 1;
                } else {
                    String ap;
                    String ap2;
                    C35512a c35512a = (C35512a) c36087d.data;
                    C35512a c35512a2 = (C35512a) c36087d2.data;
                    if (C5046bo.isNullOrNil(c35512a.puh)) {
                        C4990ab.m7412e("WalletBankCardSelectUI", "should not go here");
                        ap = WalletBankCardSelectUI.m47017ap(c35512a.pcj, "#", "_");
                    } else {
                        ap = c35512a.puh.toUpperCase();
                    }
                    if (C5046bo.isNullOrNil(c35512a2.puh)) {
                        ap2 = WalletBankCardSelectUI.m47017ap(c35512a2.pcj, "#", "_");
                    } else {
                        ap2 = c35512a2.puh.toUpperCase();
                    }
                    if (ap.equals("#")) {
                        AppMethodBeat.m2505o(47148);
                        return 1;
                    } else if (ap2.equals("#")) {
                        AppMethodBeat.m2505o(47148);
                        return -1;
                    } else {
                        int min = Math.min(ap.length(), ap2.length());
                        int i = 0;
                        while (i < min) {
                            char charAt = ap.charAt(i);
                            char charAt2 = ap2.charAt(i);
                            if (charAt == '_' && charAt2 == '_') {
                                int compare = this.tEg.compare(c35512a.pcj, c35512a2.pcj);
                                AppMethodBeat.m2505o(47148);
                                return compare;
                            } else if (charAt == charAt2) {
                                i++;
                            } else if (charAt == '_') {
                                AppMethodBeat.m2505o(47148);
                                return -1;
                            } else if (charAt2 == '_') {
                                AppMethodBeat.m2505o(47148);
                                return 1;
                            } else if (charAt < charAt2) {
                                AppMethodBeat.m2505o(47148);
                                return -1;
                            } else {
                                AppMethodBeat.m2505o(47148);
                                return 1;
                            }
                        }
                        if (ap.length() > min) {
                            AppMethodBeat.m2505o(47148);
                            return 1;
                        } else if (ap2.length() > min) {
                            AppMethodBeat.m2505o(47148);
                            return -1;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(47148);
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47149);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a4z);
        this.tEd = C14241r.cPQ().tum;
        initView();
        this.tEe = new ArrayList();
        m47016al(null);
        C40141a c40141a = new C40141a();
        List<ElementQuery> list = C14241r.cPQ().tum;
        LinkedList linkedList = new LinkedList();
        for (ElementQuery elementQuery : list) {
            Bankcard bankcard = new Bankcard();
            bankcard.field_bankName = elementQuery.nuL;
            bankcard.field_bankcardType = elementQuery.pbn;
            linkedList.add(bankcard);
        }
        C225983 c225983 = new C225983();
        HashMap hashMap = new HashMap();
        if (linkedList.isEmpty()) {
            C4990ab.m7420w("MicroMsg.BankcardLogoHelper", "req is null");
            c225983.mo38177am(hashMap);
        } else {
            C5698f.m8559cU(linkedList).mo15893d(new C226699()).mo15893d(new C143328(linkedList, hashMap, c225983));
        }
        mo17380a(this.jKT);
        AppMethodBeat.m2505o(47149);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47150);
        this.tEc = (BankCardSelectSortView) findViewById(2131828697);
        this.tEc.setOnItemClickListener(new C225961());
        this.jKT = new C5601o((byte) 0);
        this.jKT.zHa = new C225972();
        AppMethodBeat.m2505o(47150);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971067;
    }

    /* renamed from: al */
    private void m47016al(Map<String, C43807e> map) {
        AppMethodBeat.m2504i(47151);
        String str = "WalletBankCardSelectUI";
        String str2 = "refresh data: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(map != null);
        C4990ab.m7411d(str, str2, objArr);
        this.tEe.clear();
        if (this.tEd == null || this.tEd.isEmpty()) {
            C4990ab.m7420w("WalletBankCardSelectUI", "bankcardlist is null");
            AppMethodBeat.m2505o(47151);
            return;
        }
        for (ElementQuery elementQuery : this.tEd) {
            C36087d c36087d;
            int i;
            for (C36087d c36087d2 : this.tEe) {
                if (elementQuery.nuL.equals(((C35512a) c36087d2.data).pcj)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                c36087d2 = new C36087d();
                C35512a c35512a = new C35512a();
                c35512a.pcj = elementQuery.nuL;
                if (map != null) {
                    C43807e c43807e = (C43807e) map.get(elementQuery.pbn);
                    if (c43807e != null) {
                        c35512a.cIY = c43807e.oRi;
                        c35512a.tNi = c43807e.txr;
                        c35512a.puh = c43807e.puh;
                    }
                }
                if (C5046bo.isNullOrNil(c35512a.puh)) {
                    c35512a.puh = WalletBankCardSelectUI.m47017ap(c35512a.pcj, "#", "_");
                } else {
                    C4990ab.m7411d("WalletBankCardSelectUI", "have pinyin：%s", c35512a.puh);
                }
                c36087d2.yDG = c35512a.puh.toUpperCase().charAt(0);
                c36087d2.data = c35512a;
                this.tEe.add(c36087d2);
            }
        }
        Collections.sort(this.tEe, new C29639a());
        runOnUiThread(new C225994());
        AppMethodBeat.m2505o(47151);
    }

    /* renamed from: ap */
    public static String m47017ap(String str, String str2, String str3) {
        AppMethodBeat.m2504i(47152);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47152);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String r = SpellMap.m42342r(str.charAt(i));
            if (!C5046bo.isNullOrNil(r)) {
                stringBuilder.append(r.toUpperCase());
                if (i != length - 1) {
                    stringBuilder.append(str3);
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        C4990ab.m7411d("WalletBankCardSelectUI", "full py: %s", stringBuilder2);
        if (C5046bo.isNullOrNil(stringBuilder2)) {
            AppMethodBeat.m2505o(47152);
            return str2;
        }
        AppMethodBeat.m2505o(47152);
        return stringBuilder2;
    }
}
