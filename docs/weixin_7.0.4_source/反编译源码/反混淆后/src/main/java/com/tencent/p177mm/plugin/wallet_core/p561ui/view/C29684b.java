package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.b */
public final class C29684b {

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.b$a */
    static class C29685a implements C18765a {
        public ViewGroup tNj = null;
        public C43807e tNk;
        public ViewGroup tNl = null;
        public TextView tNm = null;
        public ImageView tNn = null;
        public TextView tNo = null;
        public TextView tlp = null;
        public TextView tlq = null;
        public TextView tlr = null;
        public ImageView tlt = null;
        public ImageView tlu = null;
        public TextView tlv = null;
        public TextView tlw = null;
        public TextView tlx = null;

        C29685a() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(47875);
            C4990ab.m7410d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.tNk == null) {
                AppMethodBeat.m2505o(47875);
                return;
            }
            if (str.equals(this.tNk.oRi)) {
                this.tlu.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(47873);
                        C29685a.this.tlu.setImageBitmap(bitmap);
                        C29685a.this.tNj.invalidate();
                        AppMethodBeat.m2505o(47873);
                    }
                });
            }
            if (str.equals(this.tNk.txq) && this.tlt != null) {
                this.tlt.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(47874);
                        C29685a.this.tlt.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(47874);
                    }
                });
            }
            AppMethodBeat.m2505o(47875);
        }
    }

    /* renamed from: a */
    public static View m47080a(Context context, View view, Bankcard bankcard, int i, C40141a c40141a, boolean z, int i2) {
        C29685a c29685a;
        AppMethodBeat.m2504i(47876);
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            c29685a = new C29685a();
            c29685a.tlu = (ImageView) view.findViewById(2131828647);
            c29685a.tlq = (TextView) view.findViewById(2131828648);
            c29685a.tlr = (TextView) view.findViewById(2131828649);
            c29685a.tlp = (TextView) view.findViewById(2131828653);
            c29685a.tlv = (TextView) view.findViewById(2131828655);
            c29685a.tNj = (ViewGroup) view.findViewById(2131828645);
            c29685a.tlt = (ImageView) view.findViewById(2131828646);
            c29685a.tlw = (TextView) view.findViewById(2131828656);
            c29685a.tNl = (ViewGroup) view.findViewById(2131828658);
            c29685a.tNm = (TextView) view.findViewById(2131828659);
            c29685a.tNn = (ImageView) view.findViewById(2131828654);
            c29685a.tNo = (TextView) view.findViewById(2131828657);
            view.setTag(c29685a);
        } else {
            c29685a = (C29685a) view.getTag();
        }
        C29684b.m47081a(context, c29685a, bankcard, c40141a, z, i2);
        AppMethodBeat.m2505o(47876);
        return view;
    }

    /* renamed from: b */
    public static Drawable m47082b(Context context, Bitmap bitmap) {
        AppMethodBeat.m2504i(47878);
        if (bitmap == null) {
            AppMethodBeat.m2505o(47878);
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            Drawable ninePatchDrawable;
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
                ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                AppMethodBeat.m2505o(47878);
                return ninePatchDrawable;
            }
            ninePatchDrawable = new BitmapDrawable(bitmap);
            AppMethodBeat.m2505o(47878);
            return ninePatchDrawable;
        } catch (Exception e) {
            C4990ab.m7414f("MicroMsg.BankcardListAdapter", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            AppMethodBeat.m2505o(47878);
            return null;
        }
    }

    /* renamed from: a */
    private static void m47081a(Context context, C29685a c29685a, Bankcard bankcard, C40141a c40141a, boolean z, int i) {
        AppMethodBeat.m2504i(47877);
        if (bankcard.field_bankcardState == 1) {
            c29685a.tlv.setVisibility(0);
        } else {
            c29685a.tlv.setVisibility(8);
        }
        if (z) {
            c29685a.tNo.setText(context.getString(C25738R.string.f_q));
            c29685a.tNo.setVisibility(0);
        } else if (C5046bo.isNullOrNil(bankcard.field_card_state_name)) {
            c29685a.tNo.setVisibility(8);
        } else {
            c29685a.tNo.setText(bankcard.field_card_state_name);
            c29685a.tNo.setVisibility(0);
        }
        if (1 == i) {
            c29685a.tlq.setVisibility(8);
        } else {
            c29685a.tlq.setVisibility(0);
            c29685a.tlq.setText(bankcard.field_bankName);
        }
        if (C1853r.m3831YM()) {
            c29685a.tlr.setVisibility(8);
        } else if (!C5046bo.isNullOrNil(bankcard.field_bankcardTypeName)) {
            c29685a.tlr.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.cPb()) {
            c29685a.tlr.setText(C25738R.string.fwl);
        } else if (bankcard.cPe()) {
            c29685a.tlr.setText(C25738R.string.fdu);
        } else {
            c29685a.tlr.setText(C25738R.string.fed);
        }
        if (c29685a.tlp != null) {
            c29685a.tlp.setText(bankcard.field_bankcardTail);
        }
        if (C5046bo.isNullOrNil(bankcard.field_card_bottom_wording) || c29685a.tNm == null) {
            c29685a.tNl.setVisibility(8);
        } else {
            c29685a.tNm.setText(bankcard.field_card_bottom_wording);
            c29685a.tNl.setVisibility(0);
        }
        c40141a.mo63492a(context, bankcard, c29685a.tlu, c29685a.tNj, c29685a.tlt, c29685a.tNo);
        if (c29685a.tlw != null) {
            C14241r.cPI();
            c29685a.tlw.setVisibility(8);
        }
        AppMethodBeat.m2505o(47877);
    }
}
