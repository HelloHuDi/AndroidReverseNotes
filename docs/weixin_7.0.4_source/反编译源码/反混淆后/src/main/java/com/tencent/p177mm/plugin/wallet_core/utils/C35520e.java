package com.tencent.p177mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.C23370ba;
import com.tencent.p177mm.protocal.protobuf.C46524az;
import com.tencent.p177mm.protocal.protobuf.C46566ms;
import com.tencent.p177mm.protocal.protobuf.auj;
import com.tencent.p177mm.protocal.protobuf.bam;
import com.tencent.p177mm.protocal.protobuf.bdr;
import com.tencent.p177mm.protocal.protobuf.bif;
import com.tencent.p177mm.protocal.protobuf.btr;
import com.tencent.p177mm.protocal.protobuf.cgt;
import com.tencent.p177mm.protocal.protobuf.cgv;
import com.tencent.p177mm.protocal.protobuf.cnx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.e */
public final class C35520e {

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$4 */
    public static class C44694 implements OnCheckedChangeListener {
        final /* synthetic */ View tPo;

        public C44694(View view) {
            this.tPo = view;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(48019);
            if (this.tPo != null) {
                this.tPo.setEnabled(z);
            }
            AppMethodBeat.m2505o(48019);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$2 */
    public static class C143342 implements OnClickListener {
        final /* synthetic */ Dialog nny;

        public C143342(Dialog dialog) {
            this.nny = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48017);
            if (this.nny.isShowing()) {
                this.nny.dismiss();
            }
            AppMethodBeat.m2505o(48017);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$3 */
    public static class C143353 implements C30795a {
        final /* synthetic */ View tPo;

        public C143353(View view) {
            this.tPo = view;
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            AppMethodBeat.m2504i(48018);
            if (this.tPo != null) {
                this.tPo.setEnabled(z);
            }
            AppMethodBeat.m2505o(48018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$5 */
    public static class C355165 implements OnClickListener {
        final /* synthetic */ C46566ms tPp;
        final /* synthetic */ OnClickListener tPq;
        final /* synthetic */ Context val$context;

        public C355165(Context context, C46566ms c46566ms, OnClickListener onClickListener) {
            this.val$context = context;
            this.tPp = c46566ms;
            this.tPq = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48020);
            C35520e.m58290a(this.val$context, this.tPp.vCP);
            if (this.tPq != null) {
                this.tPq.onClick(view);
            }
            AppMethodBeat.m2505o(48020);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$6 */
    public static class C355176 implements OnClickListener {
        final /* synthetic */ C46566ms tPp;
        final /* synthetic */ OnClickListener tPq;
        final /* synthetic */ Context val$context;

        public C355176(Context context, C46566ms c46566ms, OnClickListener onClickListener) {
            this.val$context = context;
            this.tPp = c46566ms;
            this.tPq = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48021);
            C35520e.m58290a(this.val$context, this.tPp.vCP);
            if (this.tPq != null) {
                this.tPq.onClick(view);
            }
            AppMethodBeat.m2505o(48021);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$9 */
    public static class C355189 implements C5279d {
        final /* synthetic */ C23370ba tPs;
        final /* synthetic */ C5279d tPt;
        final /* synthetic */ Context val$context;

        public C355189(C23370ba c23370ba, Context context, C5279d c5279d) {
            this.tPs = c23370ba;
            this.val$context = context;
            this.tPt = c5279d;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(48024);
            int itemId = menuItem.getItemId();
            if (itemId < this.tPs.vCQ.size()) {
                C35520e.m58290a(this.val$context, ((C46524az) this.tPs.vCQ.get(itemId)).vCP);
            }
            this.tPt.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.m2505o(48024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$a */
    public interface C35519a {
        /* renamed from: a */
        void mo7894a(btr btr);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$8 */
    public static class C355218 implements C36073c {
        final /* synthetic */ C23370ba tPs;
        final /* synthetic */ Context val$context;

        public C355218(C23370ba c23370ba, Context context) {
            this.tPs = c23370ba;
            this.val$context = context;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(48023);
            Iterator it = this.tPs.vCQ.iterator();
            int i = 0;
            while (it.hasNext()) {
                MenuItem menuItem;
                C46524az c46524az = (C46524az) it.next();
                Context context = this.val$context;
                if (c46524az == null) {
                    menuItem = null;
                } else {
                    C44274m c44274m = new C44274m(context, i, 0);
                    if (c46524az.vCN != null) {
                        c44274m.setTitle(C35520e.m58288a(context, c46524az.vCN, null));
                    }
                    if (c46524az.vCO != null) {
                        c44274m.mKB = C35520e.m58288a(context, c46524az.vCO, null);
                    }
                    Object menuItem2 = c44274m;
                }
                if (menuItem2 != null) {
                    c44273l.mo70073i(menuItem2);
                }
                i++;
            }
            AppMethodBeat.m2505o(48023);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$7 */
    public static class C355227 implements OnMenuItemClickListener {
        final /* synthetic */ MMActivity icV;
        final /* synthetic */ C35519a tPm;
        final /* synthetic */ bdr tPr;

        public C355227(bdr bdr, C35519a c35519a, MMActivity mMActivity) {
            this.tPr = bdr;
            this.tPm = c35519a;
            this.icV = mMActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48022);
            cgv cgv = this.tPr.wbo;
            ArrayList<btr> arrayList = new ArrayList();
            if (!(cgv == null || cgv.xfD == null || cgv.xfD.isEmpty())) {
                Iterator it = cgv.xfD.iterator();
                while (it.hasNext()) {
                    arrayList.add(((cgt) it.next()).vCP);
                }
            }
            for (btr btr : arrayList) {
                if (this.tPm != null) {
                    new Object[1][0] = menuItem;
                    C35520e.m58290a(this.icV, btr);
                    C35519a c35519a = this.tPm;
                    new Object[1][0] = menuItem;
                    c35519a.mo7894a(btr);
                } else {
                    C35520e.m58290a(this.icV, btr);
                }
            }
            AppMethodBeat.m2505o(48022);
            return false;
        }
    }

    /* renamed from: a */
    public static void m58294a(TextView textView, cgv cgv, C35519a c35519a) {
        AppMethodBeat.m2504i(48025);
        if (C35520e.m58298a(cgv)) {
            textView.setClickable(true);
            textView.setOnTouchListener(new C30132m(textView.getContext()));
        }
        textView.setText(C35520e.m58288a(textView.getContext(), cgv, c35519a));
        AppMethodBeat.m2505o(48025);
    }

    /* renamed from: a */
    private static boolean m58298a(cgv cgv) {
        AppMethodBeat.m2504i(48026);
        if (cgv.xfD == null || cgv.xfD.isEmpty()) {
            AppMethodBeat.m2505o(48026);
            return false;
        }
        Iterator it = cgv.xfD.iterator();
        while (it.hasNext()) {
            if (((cgt) it.next()).vCP != null) {
                AppMethodBeat.m2505o(48026);
                return true;
            }
        }
        AppMethodBeat.m2505o(48026);
        return false;
    }

    /* renamed from: a */
    public static void m58295a(CdnImageView cdnImageView, auj auj) {
        AppMethodBeat.m2504i(48027);
        C35520e.m58296a(cdnImageView, auj, -1, 0, 0, true);
        AppMethodBeat.m2505o(48027);
    }

    /* renamed from: a */
    public static void m58297a(CdnImageView cdnImageView, auj auj, int i, boolean z) {
        AppMethodBeat.m2504i(48028);
        C35520e.m58296a(cdnImageView, auj, i, 0, 0, z);
        AppMethodBeat.m2505o(48028);
    }

    /* renamed from: a */
    public static void m58296a(CdnImageView cdnImageView, auj auj, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(48029);
        cdnImageView.setUseSdcardCache(z);
        int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), (int) auj.width);
        int fromDPToPix2 = C1338a.fromDPToPix(C4996ah.getContext(), (int) auj.height);
        if (i2 <= 0) {
            i2 = fromDPToPix;
        }
        if (i3 <= 0) {
            i3 = fromDPToPix2;
        }
        cdnImageView.mo38954n(auj.url, i2, i3, i);
        AppMethodBeat.m2505o(48029);
    }

    /* renamed from: a */
    public static CharSequence m58288a(Context context, cgv cgv, C35519a c35519a) {
        AppMethodBeat.m2504i(48030);
        if (cgv == null || cgv.xfD == null || cgv.xfD.isEmpty()) {
            String str = "";
            AppMethodBeat.m2505o(48030);
            return str;
        }
        int size = cgv.xfD.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < size; i++) {
            spannableStringBuilder.append(C35520e.m58287a(context, (cgt) cgv.xfD.get(i), c35519a));
        }
        AppMethodBeat.m2505o(48030);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static CharSequence m58287a(final Context context, cgt cgt, final C35519a c35519a) {
        AppMethodBeat.m2504i(48031);
        SpannableString spannableString = new SpannableString(cgt.text);
        int i = (int) cgt.xfA;
        if ((cgt.xfA & -16777216) == 0) {
            i = (int) (cgt.xfA | -16777216);
        }
        WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan(C1338a.fromDPToPix(C4996ah.getContext(), (int) cgt.size), ColorStateList.valueOf(i));
        spannableString.setSpan(wcPayTextApppearanceSpan, 0, spannableString.length(), 17);
        if (!C5046bo.isNullOrNil(cgt.xfB)) {
            wcPayTextApppearanceSpan.tPl = C36391e.m59998bT(context, cgt.xfB);
        }
        Object obj = null;
        if (cgt.xfC == 1) {
            obj = new StrikethroughSpan();
        } else if (cgt.xfC == 2) {
            obj = new UnderlineSpan();
        }
        if (obj != null) {
            spannableString.setSpan(obj, 0, spannableString.length(), 17);
        }
        if (!(cgt.vCP == null || cgt.vCP.type == 0)) {
            final btr btr = cgt.vCP;
            C4990ab.m7417i("MicroMsg.WcPayViewEngineRender", "route type: %s", Integer.valueOf(btr.type));
            spannableString.setSpan(new C35503o(new C35502a() {
                /* renamed from: df */
                public final void mo9537df(View view) {
                    AppMethodBeat.m2504i(48016);
                    if (c35519a != null) {
                        new Object[1][0] = view;
                        C35520e.m58290a(context, btr);
                        C35519a c35519a = c35519a;
                        btr btr = btr;
                        new Object[1][0] = view;
                        c35519a.mo7894a(btr);
                        AppMethodBeat.m2505o(48016);
                        return;
                    }
                    C35520e.m58290a(context, btr);
                    AppMethodBeat.m2505o(48016);
                }
            }), 0, spannableString.length(), 17);
        }
        AppMethodBeat.m2505o(48031);
        return spannableString;
    }

    /* renamed from: a */
    public static void m58290a(Context context, btr btr) {
        AppMethodBeat.m2504i(48032);
        if (btr == null) {
            AppMethodBeat.m2505o(48032);
            return;
        }
        C4990ab.m7417i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", Integer.valueOf(btr.type), btr.url);
        if (btr.type == 1) {
            C36391e.m60016n(context, btr.url, true);
            AppMethodBeat.m2505o(48032);
        } else if (btr.type != 2) {
            if (btr.type != 3) {
                if (btr.type == 4) {
                    Intent intent;
                    if (btr.url.equals("balance")) {
                        C25985d.m41471c(context, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
                        AppMethodBeat.m2505o(48032);
                        return;
                    } else if (btr.url.equals("bankCard")) {
                        intent = new Intent();
                        intent.putExtra("intent_finish_self", true);
                        C25985d.m41468b(context, "wallet", ".bind.ui.WalletBankcardManageUI", intent, 65281);
                        AppMethodBeat.m2505o(48032);
                        return;
                    } else if (btr.url.equals("qmfCard")) {
                        C25985d.m41468b(context, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
                        AppMethodBeat.m2505o(48032);
                        return;
                    } else if (btr.url.equals("paySecurity")) {
                        intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 1);
                        C25985d.m41468b(context, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent, 65282);
                        AppMethodBeat.m2505o(48032);
                        return;
                    } else if (btr.url.equals("lqt")) {
                        intent = new Intent();
                        intent.putExtra("key_account_type", 1);
                        C25985d.m41468b(context, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent, 65286);
                        AppMethodBeat.m2505o(48032);
                        return;
                    } else if (btr.url.equals("realname")) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("real_name_verify_mode", 0);
                        bundle.putInt("entry_scene", 0);
                        Assert.assertTrue("context must be activity", context instanceof Activity);
                        C24143a.m37105a((Activity) context, C40105a.class, bundle);
                        AppMethodBeat.m2505o(48032);
                        return;
                    }
                } else if (btr.type == 5) {
                    if (btr.url.equals("balanceQuotaState")) {
                        C25985d.m41467b(context, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
                        AppMethodBeat.m2505o(48032);
                        return;
                    }
                } else if (btr.type != 13) {
                    C4990ab.m7421w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", Integer.valueOf(btr.type), btr.url);
                } else if (btr.wVG != null) {
                    AppMethodBeat.m2505o(48032);
                    return;
                }
            }
            AppMethodBeat.m2505o(48032);
        } else if (btr.wVC == null) {
            C4990ab.m7412e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
            AppMethodBeat.m2505o(48032);
        } else {
            C36391e.m60018p(btr.wVC.username, btr.wVC.path, btr.wVC.version, 1000);
            AppMethodBeat.m2505o(48032);
        }
    }

    /* renamed from: a */
    public static void m58291a(View view, MarginLayoutParams marginLayoutParams, cnx cnx) {
        AppMethodBeat.m2504i(48033);
        if (cnx == null) {
            AppMethodBeat.m2505o(48033);
            return;
        }
        C35520e.m58293a(marginLayoutParams, cnx.xlt);
        C35520e.m58292a(view, cnx.wVz);
        AppMethodBeat.m2505o(48033);
    }

    /* renamed from: a */
    public static void m58292a(View view, bif bif) {
        AppMethodBeat.m2504i(48034);
        if (bif == null) {
            AppMethodBeat.m2505o(48034);
            return;
        }
        view.setPadding(C1338a.fromDPToPix(C4996ah.getContext(), (int) bif.left), C1338a.fromDPToPix(C4996ah.getContext(), (int) bif.top), C1338a.fromDPToPix(C4996ah.getContext(), (int) bif.right), C1338a.fromDPToPix(C4996ah.getContext(), (int) bif.bottom));
        AppMethodBeat.m2505o(48034);
    }

    /* renamed from: a */
    private static void m58293a(MarginLayoutParams marginLayoutParams, bam bam) {
        AppMethodBeat.m2504i(48035);
        if (bam == null) {
            AppMethodBeat.m2505o(48035);
            return;
        }
        marginLayoutParams.topMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) bam.top);
        marginLayoutParams.bottomMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) bam.bottom);
        marginLayoutParams.leftMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) bam.left);
        marginLayoutParams.rightMargin = C1338a.fromDPToPix(C4996ah.getContext(), (int) bam.right);
        AppMethodBeat.m2505o(48035);
    }

    /* renamed from: a */
    public static String m58289a(Context context, cgv cgv) {
        AppMethodBeat.m2504i(48036);
        String charSequence = C35520e.m58288a(context, cgv, null).toString();
        AppMethodBeat.m2505o(48036);
        return charSequence;
    }
}
