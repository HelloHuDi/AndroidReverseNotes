package com.tencent.p177mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.p057v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p381a.C45843a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C27727e;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.plugin.emoji.p383h.C33952c;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2RewardUI;
import com.tencent.p177mm.plugin.emoji.p726f.C42949q;
import com.tencent.p177mm.plugin.emoji.p726f.C45855a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44221ar;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.model.i */
public final class C42951i {
    /* renamed from: Gn */
    private Context f17196Gn = C4996ah.getContext();
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public Context jiq;
    public C33944a kVA;
    public boolean kVB = false;
    public Fragment kVC;
    public int kVD;
    public long kVE = 0;
    public String kVF = "";
    public C27740b kVG;
    private String kVH;
    private C33952c kVI = new C33952c(2003);
    public String kVJ;

    /* renamed from: com.tencent.mm.plugin.emoji.model.i$a */
    public interface C11558a {
        /* renamed from: a */
        void mo23265a(C45843a c45843a);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.i$b */
    public interface C27740b {
        void bkf();

        /* renamed from: i */
        void mo23318i(String str, String str2, String str3, String str4);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.i$1 */
    class C339531 implements OnClickListener {
        C339531() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C42951i() {
        AppMethodBeat.m2504i(53054);
        AppMethodBeat.m2505o(53054);
    }

    /* renamed from: a */
    public final void mo68470a(C45843a c45843a) {
        AppMethodBeat.m2504i(53055);
        if (c45843a == null || c45843a.kRB == null || this.kVA == null || this.kVA.kSP == null) {
            AppMethodBeat.m2505o(53055);
            return;
        }
        EmotionSummary emotionSummary = c45843a.kRB.kTb;
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(53055);
            return;
        }
        Integer num;
        String str = emotionSummary.ProductID;
        String str2 = emotionSummary.PackName;
        String str3 = emotionSummary.PriceNum;
        String str4 = emotionSummary.PriceType;
        int bjn = c45843a.bjn();
        if (c45843a.kRB == null) {
            num = null;
        } else {
            num = Integer.valueOf(c45843a.kRB.kTd);
        }
        num.intValue();
        C45842c c45842c = this.kVA.kSP;
        boolean z = c45842c.kSY;
        boolean z2 = c45843a.kRB.kTf;
        String str5 = "MicroMsg.emoji.PayOrDownloadComponent";
        String str6 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = TextUtils.isEmpty(str3) ? "" : str3;
        objArr[2] = Integer.valueOf(bjn);
        C4990ab.m7417i(str5, str6, objArr);
        this.kVH = str;
        int i;
        C44221ar IW;
        switch (bjn) {
            case -1:
                if (C27727e.m44036a(emotionSummary)) {
                    i = 3;
                } else if (C27727e.m44037b(emotionSummary) || (!z && TextUtils.isEmpty(emotionSummary.PackPrice))) {
                    i = 3;
                } else if (z) {
                    IW = c45842c.mo73638IW(str);
                    if (TextUtils.isEmpty(IW.xYb)) {
                        i = IW.xXX;
                    } else {
                        i = 4;
                    }
                } else {
                    i = 4;
                }
                this.kVA.mo54491bW(str, i);
                AppMethodBeat.m2505o(53055);
                return;
            case 0:
                if (this.kVA != null) {
                    this.kVA.mo54491bW(str, 3);
                }
                AppMethodBeat.m2505o(53055);
                return;
            case 3:
            case 5:
                if (C2932a.m5218g(emotionSummary)) {
                    C45855a.bkq();
                    C45855a.bkr();
                    AppMethodBeat.m2505o(53055);
                    return;
                }
                m76283i(str, null, str2, emotionSummary.IconUrl);
                if (this.kVA != null) {
                    this.kVA.mo54492bX(str, 0);
                }
                C4990ab.m7417i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str);
                C7060h.pYm.mo8381e(12066, Integer.valueOf(0), Integer.valueOf(this.kVD), "", str, Long.valueOf(this.kVE), this.kVF);
                AppMethodBeat.m2505o(53055);
                return;
            case 4:
            case 12:
                if (!this.kVB) {
                    Intent intent = new Intent();
                    intent.putExtra("key_product_id", str);
                    C4990ab.m7417i("MicroMsg.emoji.PayOrDownloadComponent", "onProductClick: price %s, currency %s", str3, str4);
                    if (z) {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str4 + str3);
                    } else {
                        intent.putExtra("key_currency_type", str4);
                        intent.putExtra("key_price", str3);
                    }
                    C25985d.m41468b(this.jiq, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                    this.kVB = true;
                    C7060h.pYm.mo8381e(12066, Integer.valueOf(2), Integer.valueOf(this.kVD), "", str, Long.valueOf(this.kVE), this.kVF);
                    AppMethodBeat.m2505o(53055);
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
                        C33952c c33952c = this.kVI;
                        Fragment fragment = this.kVC;
                        C4990ab.m7410d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                        Intent intent2 = new Intent();
                        intent2.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
                        intent2.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
                        C25985d.m41457a(fragment, ".ui.transmit.SelectConversationUI", intent2, c33952c.iGJ);
                        fragment.getActivity().overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
                    } else {
                        this.kVI.mo54501A((Activity) this.jiq);
                    }
                    this.kVI.lgK = str;
                    C7060h.pYm.mo8381e(12069, Integer.valueOf(1), str);
                    AppMethodBeat.m2505o(53055);
                    return;
                } else if (c45843a.kRB.kTh) {
                    str3 = c45843a.kRB.kTb.ProductID;
                    String str7 = c45843a.kRB.kTb.PackName;
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
                        C7060h.pYm.mo8381e(12738, str3, Integer.valueOf(i), Integer.valueOf(this.kVD), Integer.valueOf(0));
                        AppMethodBeat.m2505o(53055);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                    AppMethodBeat.m2505o(53055);
                    return;
                }
                break;
            case 9:
                C1720g.m3535RO().eJo.mo14541a(new C42949q(str, 2), 0);
                AppMethodBeat.m2505o(53055);
                return;
            case 10:
                IW = c45842c.mo73638IW(str);
                if (IW != null) {
                    String string;
                    switch (IW.xXY) {
                        case 10233:
                            string = getString(C25738R.string.b_i);
                            break;
                        case 10234:
                            string = getString(C25738R.string.b_a);
                            break;
                        case 10235:
                            string = getString(C25738R.string.bcw);
                            break;
                        default:
                            string = getString(C25738R.string.bd1);
                            break;
                    }
                    C30379h.m48461b(this.jiq, string, null, true);
                }
                AppMethodBeat.m2505o(53055);
                return;
            case 11:
                C4990ab.m7420w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                AppMethodBeat.m2505o(53055);
                return;
            default:
                C4990ab.m7420w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                break;
        }
        AppMethodBeat.m2505o(53055);
    }

    /* renamed from: i */
    private void m76283i(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(53056);
        if (this.kVG != null) {
            this.kVG.mo23318i(str, str2, str3, str4);
        }
        AppMethodBeat.m2505o(53056);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53057);
        C4990ab.m7410d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            C4990ab.m7420w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:".concat(String.valueOf(i3)));
            str = intent.getStringExtra("key_err_msg");
            C4990ab.m7420w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str)));
        }
        String str2 = str;
        this.kVB = false;
        if (i2 != -1) {
            if (i == 2001) {
                if (C1853r.m3830YL()) {
                    C7060h.pYm.mo8378a(166, 6, 1, false);
                    AppMethodBeat.m2505o(53057);
                    return;
                }
                C7060h.pYm.mo8378a(166, 2, 1, false);
            }
            AppMethodBeat.m2505o(53057);
            return;
        }
        switch (i) {
            case 2001:
                if (this.kVA == null || this.kVA.kSP == null) {
                    AppMethodBeat.m2505o(53057);
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
                        C44221ar IW = this.kVA.kSP.mo73638IW(str3);
                        if (this.kVH.equals(str3)) {
                            obj = 1;
                            m76283i(str3, str, IW.lcC, null);
                            this.kVA.mo54492bX(this.kVH, 0);
                            C30379h.m48465bQ(this.jiq, str2);
                            C4990ab.m7417i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str3);
                            if (stringArrayListExtra.size() > 1) {
                                C4990ab.m7416i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                if (this.kVG != null) {
                                    this.kVG.bkf();
                                }
                            }
                        } else {
                            this.kVA.mo54491bW(this.kVH, 5);
                        }
                        i4++;
                        obj = obj;
                    }
                    if (obj == null) {
                        m76282JD(str2);
                    }
                    if (C1853r.m3830YL()) {
                        C7060h.pYm.mo8378a(166, 4, 1, false);
                        AppMethodBeat.m2505o(53057);
                        return;
                    }
                    C7060h.pYm.mo8378a(166, 0, 1, false);
                    AppMethodBeat.m2505o(53057);
                    return;
                } else if (intent != null && i3 == 100000002) {
                    m76283i(this.kVH, null, this.kVA.kSP.mo73638IW(this.kVH).lcC, null);
                    this.kVA.mo54492bX(this.kVH, 0);
                    C4990ab.m7417i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", this.kVH);
                    m76282JD(str2);
                    if (C1853r.m3830YL()) {
                        C7060h.pYm.mo8378a(166, 7, 1, false);
                        AppMethodBeat.m2505o(53057);
                        return;
                    }
                    C7060h.pYm.mo8378a(166, 3, 1, false);
                    AppMethodBeat.m2505o(53057);
                    return;
                } else if (intent == null || i3 != 1) {
                    if (!(this.kVH == null || this.kVA == null || this.kVA.kSP == null)) {
                        this.kVA.kSP.mo73636IU(this.kVH);
                        C45843a IS = this.kVA.mo54486IS(this.kVH);
                        if (IS != null) {
                            IS.bjs();
                        }
                    }
                    m76282JD(str2);
                    if (C1853r.m3830YL()) {
                        C7060h.pYm.mo8378a(166, 5, 1, false);
                    } else {
                        C7060h.pYm.mo8378a(166, 1, 1, false);
                    }
                    C4990ab.m7417i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", str2);
                    AppMethodBeat.m2505o(53057);
                    return;
                } else {
                    if (C1853r.m3830YL()) {
                        C7060h.pYm.mo8378a(166, 6, 1, false);
                    } else {
                        C7060h.pYm.mo8378a(166, 2, 1, false);
                    }
                    C4990ab.m7416i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                    AppMethodBeat.m2505o(53057);
                    return;
                }
            case 2003:
                str = this.kVI.lgK;
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(53057);
                    return;
                }
                C33952c.m55568a(intent, str, (Activity) this.jiq);
                C7060h.pYm.mo8381e(12069, Integer.valueOf(3), str);
                AppMethodBeat.m2505o(53057);
                return;
            default:
                C4990ab.m7412e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                AppMethodBeat.m2505o(53057);
                return;
        }
    }

    /* renamed from: JD */
    private void m76282JD(String str) {
        AppMethodBeat.m2504i(53058);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.b_o);
        }
        C30379h.m48438a(this.jiq, str, "", new C339531());
        AppMethodBeat.m2505o(53058);
    }

    private String getString(int i) {
        AppMethodBeat.m2504i(53059);
        String string = this.f17196Gn.getString(i);
        AppMethodBeat.m2505o(53059);
        return string;
    }
}
