package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.c.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass8;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WalletBankCardSelectUI extends WalletBaseUI {
    private o jKT;
    private boolean jLD = false;
    private BankCardSelectSortView tEc;
    private List<ElementQuery> tEd;
    private List<d> tEe;

    static class a implements Comparator<d> {
        private Collator tEg;

        private a() {
            AppMethodBeat.i(47147);
            this.tEg = Collator.getInstance(Locale.getDefault());
            AppMethodBeat.o(47147);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(47148);
            d dVar = (d) obj;
            d dVar2 = (d) obj2;
            if (!(dVar == null && dVar2 == null)) {
                if (dVar == null) {
                    AppMethodBeat.o(47148);
                    return -1;
                } else if (dVar2 == null) {
                    AppMethodBeat.o(47148);
                    return 1;
                } else {
                    String ap;
                    String ap2;
                    com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a aVar = (com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a) dVar.data;
                    com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a aVar2 = (com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a) dVar2.data;
                    if (bo.isNullOrNil(aVar.puh)) {
                        ab.e("WalletBankCardSelectUI", "should not go here");
                        ap = WalletBankCardSelectUI.ap(aVar.pcj, "#", "_");
                    } else {
                        ap = aVar.puh.toUpperCase();
                    }
                    if (bo.isNullOrNil(aVar2.puh)) {
                        ap2 = WalletBankCardSelectUI.ap(aVar2.pcj, "#", "_");
                    } else {
                        ap2 = aVar2.puh.toUpperCase();
                    }
                    if (ap.equals("#")) {
                        AppMethodBeat.o(47148);
                        return 1;
                    } else if (ap2.equals("#")) {
                        AppMethodBeat.o(47148);
                        return -1;
                    } else {
                        int min = Math.min(ap.length(), ap2.length());
                        int i = 0;
                        while (i < min) {
                            char charAt = ap.charAt(i);
                            char charAt2 = ap2.charAt(i);
                            if (charAt == '_' && charAt2 == '_') {
                                int compare = this.tEg.compare(aVar.pcj, aVar2.pcj);
                                AppMethodBeat.o(47148);
                                return compare;
                            } else if (charAt == charAt2) {
                                i++;
                            } else if (charAt == '_') {
                                AppMethodBeat.o(47148);
                                return -1;
                            } else if (charAt2 == '_') {
                                AppMethodBeat.o(47148);
                                return 1;
                            } else if (charAt < charAt2) {
                                AppMethodBeat.o(47148);
                                return -1;
                            } else {
                                AppMethodBeat.o(47148);
                                return 1;
                            }
                        }
                        if (ap.length() > min) {
                            AppMethodBeat.o(47148);
                            return 1;
                        } else if (ap2.length() > min) {
                            AppMethodBeat.o(47148);
                            return -1;
                        }
                    }
                }
            }
            AppMethodBeat.o(47148);
            return 0;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47149);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a4z);
        this.tEd = r.cPQ().tum;
        initView();
        this.tEe = new ArrayList();
        al(null);
        com.tencent.mm.plugin.wallet_core.utils.a aVar = new com.tencent.mm.plugin.wallet_core.utils.a();
        List<ElementQuery> list = r.cPQ().tum;
        LinkedList linkedList = new LinkedList();
        for (ElementQuery elementQuery : list) {
            Bankcard bankcard = new Bankcard();
            bankcard.field_bankName = elementQuery.nuL;
            bankcard.field_bankcardType = elementQuery.pbn;
            linkedList.add(bankcard);
        }
        AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.wallet_core.utils.a.a() {
            public final void am(Map<String, e> map) {
                AppMethodBeat.i(47145);
                ab.i("WalletBankCardSelectUI", "get logo callback: %s", Integer.valueOf(map.size()));
                WalletBankCardSelectUI.a(WalletBankCardSelectUI.this, (Map) map);
                AppMethodBeat.o(47145);
            }
        };
        HashMap hashMap = new HashMap();
        if (linkedList.isEmpty()) {
            ab.w("MicroMsg.BankcardLogoHelper", "req is null");
            anonymousClass3.am(hashMap);
        } else {
            f.cU(linkedList).d(new com.tencent.mm.vending.c.a<Object, List<Bankcard>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(47994);
                    Object dW = dW((List) obj);
                    AppMethodBeat.o(47994);
                    return dW;
                }

                private Object dW(List<Bankcard> list) {
                    AppMethodBeat.i(47993);
                    if (list != null && list.size() > 0) {
                        int size = list.size();
                        a.this.tOS = new LinkedList();
                        for (int i = 0; i < size; i++) {
                            Bankcard bankcard = (Bankcard) list.get(i);
                            if (bankcard.cPc()) {
                                ab.i("MicroMsg.BankcardLogoHelper", "ignore balance!!");
                            } else {
                                a.this.tOS.add(bankcard.field_bankcardType);
                            }
                        }
                        if (a.this.tOS.size() > 0) {
                            ab.i("MicroMsg.BankcardLogoHelper", "need fetch bank logo, %s", Integer.valueOf(a.this.tOS.size()));
                            final com.tencent.mm.vending.g.b dMj = f.dMj();
                            m cVar = new c(a.this.tOS);
                            g.RQ();
                            g.RO().eJo.a(1650, new com.tencent.mm.ai.f() {
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(47992);
                                    g.RQ();
                                    g.RO().eJo.b(1650, (com.tencent.mm.ai.f) this);
                                    a.this.tOS = null;
                                    f.a(dMj, new Object[0]);
                                    AppMethodBeat.o(47992);
                                }
                            });
                            g.RQ();
                            g.RO().eJo.a(cVar, 0);
                            dMj.dMi();
                        }
                    }
                    Void voidR = zXH;
                    AppMethodBeat.o(47993);
                    return voidR;
                }
            }).d(new AnonymousClass8(linkedList, hashMap, anonymousClass3));
        }
        a(this.jKT);
        AppMethodBeat.o(47149);
    }

    public final void initView() {
        AppMethodBeat.i(47150);
        this.tEc = (BankCardSelectSortView) findViewById(R.id.f8d);
        this.tEc.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(47140);
                d dVar = (d) adapterView.getAdapter().getItem(i);
                WalletBankCardSelectUI walletBankCardSelectUI = WalletBankCardSelectUI.this;
                com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a aVar = (com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a) dVar.data;
                if (aVar != null) {
                    walletBankCardSelectUI.aqX();
                    Intent intent = new Intent();
                    intent.putExtra("bank_name", aVar.pcj);
                    ab.i("WalletBankCardSelectUI", "item bank: %s", aVar.pcj);
                    walletBankCardSelectUI.setResult(-1, intent);
                    walletBankCardSelectUI.finish();
                }
                AppMethodBeat.o(47140);
            }
        });
        this.jKT = new o((byte) 0);
        this.jKT.zHa = new b() {
            public final void app() {
                AppMethodBeat.i(47141);
                WalletBankCardSelectUI.this.jLD = true;
                WalletBankCardSelectUI.this.tEc.ql(false);
                WalletBankCardSelectUI.this.tEc.setMode(1);
                AppMethodBeat.o(47141);
            }

            public final void apo() {
                AppMethodBeat.i(47142);
                WalletBankCardSelectUI.this.jLD = false;
                WalletBankCardSelectUI.this.aqX();
                WalletBankCardSelectUI.this.tEc.ql(true);
                WalletBankCardSelectUI.this.tEc.setMode(0);
                AppMethodBeat.o(47142);
            }

            public final void vO(String str) {
                AppMethodBeat.i(47143);
                ab.d("WalletBankCardSelectUI", "search text: %s", str);
                WalletBankCardSelectUI.this.tEc.aqS(str);
                AppMethodBeat.o(47143);
            }

            public final boolean vN(String str) {
                AppMethodBeat.i(47144);
                WalletBankCardSelectUI.this.aqX();
                AppMethodBeat.o(47144);
                return false;
            }

            public final void apq() {
            }

            public final void apr() {
            }
        };
        AppMethodBeat.o(47150);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b3e;
    }

    private void al(Map<String, e> map) {
        AppMethodBeat.i(47151);
        String str = "WalletBankCardSelectUI";
        String str2 = "refresh data: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(map != null);
        ab.d(str, str2, objArr);
        this.tEe.clear();
        if (this.tEd == null || this.tEd.isEmpty()) {
            ab.w("WalletBankCardSelectUI", "bankcardlist is null");
            AppMethodBeat.o(47151);
            return;
        }
        for (ElementQuery elementQuery : this.tEd) {
            d dVar;
            int i;
            for (d dVar2 : this.tEe) {
                if (elementQuery.nuL.equals(((com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a) dVar2.data).pcj)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                dVar2 = new d();
                com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a aVar = new com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a();
                aVar.pcj = elementQuery.nuL;
                if (map != null) {
                    e eVar = (e) map.get(elementQuery.pbn);
                    if (eVar != null) {
                        aVar.cIY = eVar.oRi;
                        aVar.tNi = eVar.txr;
                        aVar.puh = eVar.puh;
                    }
                }
                if (bo.isNullOrNil(aVar.puh)) {
                    aVar.puh = ap(aVar.pcj, "#", "_");
                } else {
                    ab.d("WalletBankCardSelectUI", "have pinyin：%s", aVar.puh);
                }
                dVar2.yDG = aVar.puh.toUpperCase().charAt(0);
                dVar2.data = aVar;
                this.tEe.add(dVar2);
            }
        }
        Collections.sort(this.tEe, new a());
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(47146);
                WalletBankCardSelectUI.this.tEc.dJ(WalletBankCardSelectUI.this.tEe);
                AppMethodBeat.o(47146);
            }
        });
        AppMethodBeat.o(47151);
    }

    public static String ap(String str, String str2, String str3) {
        AppMethodBeat.i(47152);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47152);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String r = SpellMap.r(str.charAt(i));
            if (!bo.isNullOrNil(r)) {
                stringBuilder.append(r.toUpperCase());
                if (i != length - 1) {
                    stringBuilder.append(str3);
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        ab.d("WalletBankCardSelectUI", "full py: %s", stringBuilder2);
        if (bo.isNullOrNil(stringBuilder2)) {
            AppMethodBeat.o(47152);
            return str2;
        }
        AppMethodBeat.o(47152);
        return stringBuilder2;
    }
}
