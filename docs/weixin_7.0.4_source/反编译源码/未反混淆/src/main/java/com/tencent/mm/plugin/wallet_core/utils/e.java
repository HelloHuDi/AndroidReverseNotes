package com.tencent.mm.plugin.wallet_core.utils;

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
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e {

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$4 */
    public static class AnonymousClass4 implements OnCheckedChangeListener {
        final /* synthetic */ View tPo;

        public AnonymousClass4(View view) {
            this.tPo = view;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(48019);
            if (this.tPo != null) {
                this.tPo.setEnabled(z);
            }
            AppMethodBeat.o(48019);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$2 */
    public static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ Dialog nny;

        public AnonymousClass2(Dialog dialog) {
            this.nny = dialog;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(48017);
            if (this.nny.isShowing()) {
                this.nny.dismiss();
            }
            AppMethodBeat.o(48017);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$3 */
    public static class AnonymousClass3 implements com.tencent.mm.ui.widget.MMSwitchBtn.a {
        final /* synthetic */ View tPo;

        public AnonymousClass3(View view) {
            this.tPo = view;
        }

        public final void di(boolean z) {
            AppMethodBeat.i(48018);
            if (this.tPo != null) {
                this.tPo.setEnabled(z);
            }
            AppMethodBeat.o(48018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$5 */
    public static class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ ms tPp;
        final /* synthetic */ OnClickListener tPq;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(Context context, ms msVar, OnClickListener onClickListener) {
            this.val$context = context;
            this.tPp = msVar;
            this.tPq = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(48020);
            e.a(this.val$context, this.tPp.vCP);
            if (this.tPq != null) {
                this.tPq.onClick(view);
            }
            AppMethodBeat.o(48020);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$6 */
    public static class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ ms tPp;
        final /* synthetic */ OnClickListener tPq;
        final /* synthetic */ Context val$context;

        public AnonymousClass6(Context context, ms msVar, OnClickListener onClickListener) {
            this.val$context = context;
            this.tPp = msVar;
            this.tPq = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(48021);
            e.a(this.val$context, this.tPp.vCP);
            if (this.tPq != null) {
                this.tPq.onClick(view);
            }
            AppMethodBeat.o(48021);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$9 */
    public static class AnonymousClass9 implements d {
        final /* synthetic */ ba tPs;
        final /* synthetic */ d tPt;
        final /* synthetic */ Context val$context;

        public AnonymousClass9(ba baVar, Context context, d dVar) {
            this.tPs = baVar;
            this.val$context = context;
            this.tPt = dVar;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(48024);
            int itemId = menuItem.getItemId();
            if (itemId < this.tPs.vCQ.size()) {
                e.a(this.val$context, ((az) this.tPs.vCQ.get(itemId)).vCP);
            }
            this.tPt.onMMMenuItemSelected(menuItem, i);
            AppMethodBeat.o(48024);
        }
    }

    public interface a {
        void a(btr btr);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$8 */
    public static class AnonymousClass8 implements c {
        final /* synthetic */ ba tPs;
        final /* synthetic */ Context val$context;

        public AnonymousClass8(ba baVar, Context context) {
            this.tPs = baVar;
            this.val$context = context;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(48023);
            Iterator it = this.tPs.vCQ.iterator();
            int i = 0;
            while (it.hasNext()) {
                MenuItem menuItem;
                az azVar = (az) it.next();
                Context context = this.val$context;
                if (azVar == null) {
                    menuItem = null;
                } else {
                    m mVar = new m(context, i, 0);
                    if (azVar.vCN != null) {
                        mVar.setTitle(e.a(context, azVar.vCN, null));
                    }
                    if (azVar.vCO != null) {
                        mVar.mKB = e.a(context, azVar.vCO, null);
                    }
                    Object menuItem2 = mVar;
                }
                if (menuItem2 != null) {
                    lVar.i(menuItem2);
                }
                i++;
            }
            AppMethodBeat.o(48023);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.e$7 */
    public static class AnonymousClass7 implements OnMenuItemClickListener {
        final /* synthetic */ MMActivity icV;
        final /* synthetic */ a tPm;
        final /* synthetic */ bdr tPr;

        public AnonymousClass7(bdr bdr, a aVar, MMActivity mMActivity) {
            this.tPr = bdr;
            this.tPm = aVar;
            this.icV = mMActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(48022);
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
                    e.a(this.icV, btr);
                    a aVar = this.tPm;
                    new Object[1][0] = menuItem;
                    aVar.a(btr);
                } else {
                    e.a(this.icV, btr);
                }
            }
            AppMethodBeat.o(48022);
            return false;
        }
    }

    public static void a(TextView textView, cgv cgv, a aVar) {
        AppMethodBeat.i(48025);
        if (a(cgv)) {
            textView.setClickable(true);
            textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(textView.getContext()));
        }
        textView.setText(a(textView.getContext(), cgv, aVar));
        AppMethodBeat.o(48025);
    }

    private static boolean a(cgv cgv) {
        AppMethodBeat.i(48026);
        if (cgv.xfD == null || cgv.xfD.isEmpty()) {
            AppMethodBeat.o(48026);
            return false;
        }
        Iterator it = cgv.xfD.iterator();
        while (it.hasNext()) {
            if (((cgt) it.next()).vCP != null) {
                AppMethodBeat.o(48026);
                return true;
            }
        }
        AppMethodBeat.o(48026);
        return false;
    }

    public static void a(CdnImageView cdnImageView, auj auj) {
        AppMethodBeat.i(48027);
        a(cdnImageView, auj, -1, 0, 0, true);
        AppMethodBeat.o(48027);
    }

    public static void a(CdnImageView cdnImageView, auj auj, int i, boolean z) {
        AppMethodBeat.i(48028);
        a(cdnImageView, auj, i, 0, 0, z);
        AppMethodBeat.o(48028);
    }

    public static void a(CdnImageView cdnImageView, auj auj, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(48029);
        cdnImageView.setUseSdcardCache(z);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) auj.width);
        int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) auj.height);
        if (i2 <= 0) {
            i2 = fromDPToPix;
        }
        if (i3 <= 0) {
            i3 = fromDPToPix2;
        }
        cdnImageView.n(auj.url, i2, i3, i);
        AppMethodBeat.o(48029);
    }

    public static CharSequence a(Context context, cgv cgv, a aVar) {
        AppMethodBeat.i(48030);
        if (cgv == null || cgv.xfD == null || cgv.xfD.isEmpty()) {
            String str = "";
            AppMethodBeat.o(48030);
            return str;
        }
        int size = cgv.xfD.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < size; i++) {
            spannableStringBuilder.append(a(context, (cgt) cgv.xfD.get(i), aVar));
        }
        AppMethodBeat.o(48030);
        return spannableStringBuilder;
    }

    private static CharSequence a(final Context context, cgt cgt, final a aVar) {
        AppMethodBeat.i(48031);
        SpannableString spannableString = new SpannableString(cgt.text);
        int i = (int) cgt.xfA;
        if ((cgt.xfA & -16777216) == 0) {
            i = (int) (cgt.xfA | -16777216);
        }
        WcPayTextApppearanceSpan wcPayTextApppearanceSpan = new WcPayTextApppearanceSpan(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) cgt.size), ColorStateList.valueOf(i));
        spannableString.setSpan(wcPayTextApppearanceSpan, 0, spannableString.length(), 17);
        if (!bo.isNullOrNil(cgt.xfB)) {
            wcPayTextApppearanceSpan.tPl = com.tencent.mm.wallet_core.ui.e.bT(context, cgt.xfB);
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
            ab.i("MicroMsg.WcPayViewEngineRender", "route type: %s", Integer.valueOf(btr.type));
            spannableString.setSpan(new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
                public final void df(View view) {
                    AppMethodBeat.i(48016);
                    if (aVar != null) {
                        new Object[1][0] = view;
                        e.a(context, btr);
                        a aVar = aVar;
                        btr btr = btr;
                        new Object[1][0] = view;
                        aVar.a(btr);
                        AppMethodBeat.o(48016);
                        return;
                    }
                    e.a(context, btr);
                    AppMethodBeat.o(48016);
                }
            }), 0, spannableString.length(), 17);
        }
        AppMethodBeat.o(48031);
        return spannableString;
    }

    public static void a(Context context, btr btr) {
        AppMethodBeat.i(48032);
        if (btr == null) {
            AppMethodBeat.o(48032);
            return;
        }
        ab.i("MicroMsg.WcPayViewEngineRender", "route info type: %s, uri: %s", Integer.valueOf(btr.type), btr.url);
        if (btr.type == 1) {
            com.tencent.mm.wallet_core.ui.e.n(context, btr.url, true);
            AppMethodBeat.o(48032);
        } else if (btr.type != 2) {
            if (btr.type != 3) {
                if (btr.type == 4) {
                    Intent intent;
                    if (btr.url.equals("balance")) {
                        com.tencent.mm.bp.d.c(context, "wallet", ".balance.ui.WalletBalanceManagerUI", 65281);
                        AppMethodBeat.o(48032);
                        return;
                    } else if (btr.url.equals("bankCard")) {
                        intent = new Intent();
                        intent.putExtra("intent_finish_self", true);
                        com.tencent.mm.bp.d.b(context, "wallet", ".bind.ui.WalletBankcardManageUI", intent, 65281);
                        AppMethodBeat.o(48032);
                        return;
                    } else if (btr.url.equals("qmfCard")) {
                        com.tencent.mm.bp.d.b(context, "honey_pay", ".ui.HoneyPayMainUI", new Intent(), 65283);
                        AppMethodBeat.o(48032);
                        return;
                    } else if (btr.url.equals("paySecurity")) {
                        intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 1);
                        com.tencent.mm.bp.d.b(context, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent, 65282);
                        AppMethodBeat.o(48032);
                        return;
                    } else if (btr.url.equals("lqt")) {
                        intent = new Intent();
                        intent.putExtra("key_account_type", 1);
                        com.tencent.mm.bp.d.b(context, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent, 65286);
                        AppMethodBeat.o(48032);
                        return;
                    } else if (btr.url.equals("realname")) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("real_name_verify_mode", 0);
                        bundle.putInt("entry_scene", 0);
                        Assert.assertTrue("context must be activity", context instanceof Activity);
                        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                        AppMethodBeat.o(48032);
                        return;
                    }
                } else if (btr.type == 5) {
                    if (btr.url.equals("balanceQuotaState")) {
                        com.tencent.mm.bp.d.b(context, "wallet_ecard", ".ui.WalletECardLogoutUI", new Intent());
                        AppMethodBeat.o(48032);
                        return;
                    }
                } else if (btr.type != 13) {
                    ab.w("MicroMsg.WcPayViewEngineRender", "can't handle type: %s, uri: %s", Integer.valueOf(btr.type), btr.url);
                } else if (btr.wVG != null) {
                    AppMethodBeat.o(48032);
                    return;
                }
            }
            AppMethodBeat.o(48032);
        } else if (btr.wVC == null) {
            ab.e("MicroMsg.WcPayViewEngineRender", "tiny app uri is null");
            AppMethodBeat.o(48032);
        } else {
            com.tencent.mm.wallet_core.ui.e.p(btr.wVC.username, btr.wVC.path, btr.wVC.version, 1000);
            AppMethodBeat.o(48032);
        }
    }

    public static void a(View view, MarginLayoutParams marginLayoutParams, cnx cnx) {
        AppMethodBeat.i(48033);
        if (cnx == null) {
            AppMethodBeat.o(48033);
            return;
        }
        a(marginLayoutParams, cnx.xlt);
        a(view, cnx.wVz);
        AppMethodBeat.o(48033);
    }

    public static void a(View view, bif bif) {
        AppMethodBeat.i(48034);
        if (bif == null) {
            AppMethodBeat.o(48034);
            return;
        }
        view.setPadding(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bif.left), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bif.top), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bif.right), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bif.bottom));
        AppMethodBeat.o(48034);
    }

    private static void a(MarginLayoutParams marginLayoutParams, bam bam) {
        AppMethodBeat.i(48035);
        if (bam == null) {
            AppMethodBeat.o(48035);
            return;
        }
        marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bam.top);
        marginLayoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bam.bottom);
        marginLayoutParams.leftMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bam.left);
        marginLayoutParams.rightMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) bam.right);
        AppMethodBeat.o(48035);
    }

    public static String a(Context context, cgv cgv) {
        AppMethodBeat.i(48036);
        String charSequence = a(context, cgv, null).toString();
        AppMethodBeat.o(48036);
        return charSequence;
    }
}
