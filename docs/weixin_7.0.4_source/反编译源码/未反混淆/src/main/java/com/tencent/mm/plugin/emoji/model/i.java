package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;

public final class i {
    private Context Gn = ah.getContext();
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public Context jiq;
    public com.tencent.mm.plugin.emoji.a.a.a kVA;
    public boolean kVB = false;
    public Fragment kVC;
    public int kVD;
    public long kVE = 0;
    public String kVF = "";
    public b kVG;
    private String kVH;
    private c kVI = new c(2003);
    public String kVJ;

    public interface a {
        void a(com.tencent.mm.plugin.emoji.a.a aVar);
    }

    public interface b {
        void bkf();

        void i(String str, String str2, String str3, String str4);
    }

    public i() {
        AppMethodBeat.i(53054);
        AppMethodBeat.o(53054);
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        AppMethodBeat.i(53055);
        if (aVar == null || aVar.kRB == null || this.kVA == null || this.kVA.kSP == null) {
            AppMethodBeat.o(53055);
            return;
        }
        EmotionSummary emotionSummary = aVar.kRB.kTb;
        if (emotionSummary == null) {
            AppMethodBeat.o(53055);
            return;
        }
        Integer num;
        String str = emotionSummary.ProductID;
        String str2 = emotionSummary.PackName;
        String str3 = emotionSummary.PriceNum;
        String str4 = emotionSummary.PriceType;
        int bjn = aVar.bjn();
        if (aVar.kRB == null) {
            num = null;
        } else {
            num = Integer.valueOf(aVar.kRB.kTd);
        }
        num.intValue();
        com.tencent.mm.plugin.emoji.a.a.c cVar = this.kVA.kSP;
        boolean z = cVar.kSY;
        boolean z2 = aVar.kRB.kTf;
        String str5 = "MicroMsg.emoji.PayOrDownloadComponent";
        String str6 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = TextUtils.isEmpty(str3) ? "" : str3;
        objArr[2] = Integer.valueOf(bjn);
        ab.i(str5, str6, objArr);
        this.kVH = str;
        int i;
        ar IW;
        switch (bjn) {
            case -1:
                if (e.a(emotionSummary)) {
                    i = 3;
                } else if (e.b(emotionSummary) || (!z && TextUtils.isEmpty(emotionSummary.PackPrice))) {
                    i = 3;
                } else if (z) {
                    IW = cVar.IW(str);
                    if (TextUtils.isEmpty(IW.xYb)) {
                        i = IW.xXX;
                    } else {
                        i = 4;
                    }
                } else {
                    i = 4;
                }
                this.kVA.bW(str, i);
                AppMethodBeat.o(53055);
                return;
            case 0:
                if (this.kVA != null) {
                    this.kVA.bW(str, 3);
                }
                AppMethodBeat.o(53055);
                return;
            case 3:
            case 5:
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    com.tencent.mm.plugin.emoji.f.a.bkq();
                    com.tencent.mm.plugin.emoji.f.a.bkr();
                    AppMethodBeat.o(53055);
                    return;
                }
                i(str, null, str2, emotionSummary.IconUrl);
                if (this.kVA != null) {
                    this.kVA.bX(str, 0);
                }
                ab.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str);
                h.pYm.e(12066, Integer.valueOf(0), Integer.valueOf(this.kVD), "", str, Long.valueOf(this.kVE), this.kVF);
                AppMethodBeat.o(53055);
                return;
            case 4:
            case 12:
                if (!this.kVB) {
                    Intent intent = new Intent();
                    intent.putExtra("key_product_id", str);
                    ab.i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", str3, str4);
                    if (z) {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str4 + str3);
                    } else {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str3);
                    }
                    d.b(this.jiq, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                    this.kVB = true;
                    h.pYm.e(12066, Integer.valueOf(2), Integer.valueOf(this.kVD), "", str, Long.valueOf(this.kVE), this.kVF);
                    AppMethodBeat.o(53055);
                    return;
                }
                break;
            case 7:
                if (z2) {
                    Object obj;
                    if (this.kVC != null) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        c cVar2 = this.kVI;
                        Fragment fragment = this.kVC;
                        ab.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                        Intent intent2 = new Intent();
                        intent2.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
                        intent2.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
                        d.a(fragment, ".ui.transmit.SelectConversationUI", intent2, cVar2.iGJ);
                        fragment.getActivity().overridePendingTransition(R.anim.cg, R.anim.b6);
                    } else {
                        this.kVI.A((Activity) this.jiq);
                    }
                    this.kVI.lgK = str;
                    h.pYm.e(12069, Integer.valueOf(1), str);
                    AppMethodBeat.o(53055);
                    return;
                } else if (aVar.kRB.kTh) {
                    str3 = aVar.kRB.kTb.ProductID;
                    String str7 = aVar.kRB.kTb.PackName;
                    str = this.kVJ;
                    if (this.jiq != null) {
                        i = this.kVD == 9 ? 3 : 4;
                        Intent intent3 = new Intent();
                        intent3.setClass(this.jiq, EmojiStoreV2RewardUI.class);
                        intent3.putExtra("extra_id", str3);
                        intent3.putExtra("extra_name", str7);
                        intent3.putExtra("name", str);
                        intent3.putExtra("scene", this.kVD);
                        intent3.putExtra("pageType", i);
                        intent3.putExtra("searchID", this.kVE);
                        this.jiq.startActivity(intent3);
                        h.pYm.e(12738, str3, Integer.valueOf(i), Integer.valueOf(this.kVD), Integer.valueOf(0));
                        AppMethodBeat.o(53055);
                        return;
                    }
                    ab.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                    AppMethodBeat.o(53055);
                    return;
                }
                break;
            case 9:
                g.RO().eJo.a(new q(str, 2), 0);
                AppMethodBeat.o(53055);
                return;
            case 10:
                IW = cVar.IW(str);
                if (IW != null) {
                    String string;
                    switch (IW.xXY) {
                        case 10233:
                            string = getString(R.string.b_i);
                            break;
                        case 10234:
                            string = getString(R.string.b_a);
                            break;
                        case 10235:
                            string = getString(R.string.bcw);
                            break;
                        default:
                            string = getString(R.string.bd1);
                            break;
                    }
                    com.tencent.mm.ui.base.h.b(this.jiq, string, null, true);
                }
                AppMethodBeat.o(53055);
                return;
            case 11:
                ab.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                AppMethodBeat.o(53055);
                return;
            default:
                ab.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                break;
        }
        AppMethodBeat.o(53055);
    }

    private void i(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(53056);
        if (this.kVG != null) {
            this.kVG.i(str, str2, str3, str4);
        }
        AppMethodBeat.o(53056);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53057);
        ab.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            ab.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i3)));
            str = intent.getStringExtra("key_err_msg");
            ab.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str)));
        }
        String str2 = str;
        this.kVB = false;
        if (i2 != -1) {
            if (i == 2001) {
                if (r.YL()) {
                    h.pYm.a(166, 6, 1, false);
                    AppMethodBeat.o(53057);
                    return;
                }
                h.pYm.a(166, 2, 1, false);
            }
            AppMethodBeat.o(53057);
            return;
        }
        switch (i) {
            case 2001:
                if (this.kVA == null || this.kVA.kSP == null) {
                    AppMethodBeat.o(53057);
                    return;
                } else if (intent != null && i3 == 0) {
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                    ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                    Object obj = null;
                    int size = stringArrayListExtra.size();
                    int i4 = 0;
                    while (i4 < size) {
                        String str3 = (String) stringArrayListExtra.get(i4);
                        str = (String) stringArrayListExtra2.get(i4);
                        ar IW = this.kVA.kSP.IW(str3);
                        if (this.kVH.equals(str3)) {
                            obj = 1;
                            i(str3, str, IW.lcC, null);
                            this.kVA.bX(this.kVH, 0);
                            com.tencent.mm.ui.base.h.bQ(this.jiq, str2);
                            ab.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str3);
                            if (stringArrayListExtra.size() > 1) {
                                ab.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                if (this.kVG != null) {
                                    this.kVG.bkf();
                                }
                            }
                        } else {
                            this.kVA.bW(this.kVH, 5);
                        }
                        i4++;
                        obj = obj;
                    }
                    if (obj == null) {
                        JD(str2);
                    }
                    if (r.YL()) {
                        h.pYm.a(166, 4, 1, false);
                        AppMethodBeat.o(53057);
                        return;
                    }
                    h.pYm.a(166, 0, 1, false);
                    AppMethodBeat.o(53057);
                    return;
                } else if (intent != null && i3 == 100000002) {
                    i(this.kVH, null, this.kVA.kSP.IW(this.kVH).lcC, null);
                    this.kVA.bX(this.kVH, 0);
                    ab.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", this.kVH);
                    JD(str2);
                    if (r.YL()) {
                        h.pYm.a(166, 7, 1, false);
                        AppMethodBeat.o(53057);
                        return;
                    }
                    h.pYm.a(166, 3, 1, false);
                    AppMethodBeat.o(53057);
                    return;
                } else if (intent == null || i3 != 1) {
                    if (!(this.kVH == null || this.kVA == null || this.kVA.kSP == null)) {
                        this.kVA.kSP.IU(this.kVH);
                        com.tencent.mm.plugin.emoji.a.a IS = this.kVA.IS(this.kVH);
                        if (IS != null) {
                            IS.bjs();
                        }
                    }
                    JD(str2);
                    if (r.YL()) {
                        h.pYm.a(166, 5, 1, false);
                    } else {
                        h.pYm.a(166, 1, 1, false);
                    }
                    ab.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", str2);
                    AppMethodBeat.o(53057);
                    return;
                } else {
                    if (r.YL()) {
                        h.pYm.a(166, 6, 1, false);
                    } else {
                        h.pYm.a(166, 2, 1, false);
                    }
                    ab.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                    AppMethodBeat.o(53057);
                    return;
                }
            case 2003:
                str = this.kVI.lgK;
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(53057);
                    return;
                }
                c.a(intent, str, (Activity) this.jiq);
                h.pYm.e(12069, Integer.valueOf(3), str);
                AppMethodBeat.o(53057);
                return;
            default:
                ab.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                AppMethodBeat.o(53057);
                return;
        }
    }

    private void JD(String str) {
        AppMethodBeat.i(53058);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.b_o);
        }
        com.tencent.mm.ui.base.h.a(this.jiq, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(53058);
    }

    private String getString(int i) {
        AppMethodBeat.i(53059);
        String string = this.Gn.getString(i);
        AppMethodBeat.o(53059);
        return string;
    }
}
