package com.tencent.mm.plugin.wallet_core.ui.view;

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
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {

    static class a implements com.tencent.mm.platformtools.x.a {
        public ViewGroup tNj = null;
        public e tNk;
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

        a() {
        }

        public final void m(String str, final Bitmap bitmap) {
            AppMethodBeat.i(47875);
            ab.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.tNk == null) {
                AppMethodBeat.o(47875);
                return;
            }
            if (str.equals(this.tNk.oRi)) {
                this.tlu.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47873);
                        a.this.tlu.setImageBitmap(bitmap);
                        a.this.tNj.invalidate();
                        AppMethodBeat.o(47873);
                    }
                });
            }
            if (str.equals(this.tNk.txq) && this.tlt != null) {
                this.tlt.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47874);
                        a.this.tlt.setImageBitmap(bitmap);
                        AppMethodBeat.o(47874);
                    }
                });
            }
            AppMethodBeat.o(47875);
        }
    }

    public static View a(Context context, View view, Bankcard bankcard, int i, com.tencent.mm.plugin.wallet_core.utils.a aVar, boolean z, int i2) {
        a aVar2;
        AppMethodBeat.i(47876);
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            aVar2 = new a();
            aVar2.tlu = (ImageView) view.findViewById(R.id.f71);
            aVar2.tlq = (TextView) view.findViewById(R.id.f72);
            aVar2.tlr = (TextView) view.findViewById(R.id.f73);
            aVar2.tlp = (TextView) view.findViewById(R.id.f77);
            aVar2.tlv = (TextView) view.findViewById(R.id.f79);
            aVar2.tNj = (ViewGroup) view.findViewById(R.id.f6z);
            aVar2.tlt = (ImageView) view.findViewById(R.id.f70);
            aVar2.tlw = (TextView) view.findViewById(R.id.f7_);
            aVar2.tNl = (ViewGroup) view.findViewById(R.id.f7b);
            aVar2.tNm = (TextView) view.findViewById(R.id.f7c);
            aVar2.tNn = (ImageView) view.findViewById(R.id.f78);
            aVar2.tNo = (TextView) view.findViewById(R.id.f7a);
            view.setTag(aVar2);
        } else {
            aVar2 = (a) view.getTag();
        }
        a(context, aVar2, bankcard, aVar, z, i2);
        AppMethodBeat.o(47876);
        return view;
    }

    public static Drawable b(Context context, Bitmap bitmap) {
        AppMethodBeat.i(47878);
        if (bitmap == null) {
            AppMethodBeat.o(47878);
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            Drawable ninePatchDrawable;
            if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
                ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                AppMethodBeat.o(47878);
                return ninePatchDrawable;
            }
            ninePatchDrawable = new BitmapDrawable(bitmap);
            AppMethodBeat.o(47878);
            return ninePatchDrawable;
        } catch (Exception e) {
            ab.f("MicroMsg.BankcardListAdapter", e.getMessage());
            ab.printErrStackTrace("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            AppMethodBeat.o(47878);
            return null;
        }
    }

    private static void a(Context context, a aVar, Bankcard bankcard, com.tencent.mm.plugin.wallet_core.utils.a aVar2, boolean z, int i) {
        AppMethodBeat.i(47877);
        if (bankcard.field_bankcardState == 1) {
            aVar.tlv.setVisibility(0);
        } else {
            aVar.tlv.setVisibility(8);
        }
        if (z) {
            aVar.tNo.setText(context.getString(R.string.f_q));
            aVar.tNo.setVisibility(0);
        } else if (bo.isNullOrNil(bankcard.field_card_state_name)) {
            aVar.tNo.setVisibility(8);
        } else {
            aVar.tNo.setText(bankcard.field_card_state_name);
            aVar.tNo.setVisibility(0);
        }
        if (1 == i) {
            aVar.tlq.setVisibility(8);
        } else {
            aVar.tlq.setVisibility(0);
            aVar.tlq.setText(bankcard.field_bankName);
        }
        if (r.YM()) {
            aVar.tlr.setVisibility(8);
        } else if (!bo.isNullOrNil(bankcard.field_bankcardTypeName)) {
            aVar.tlr.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.cPb()) {
            aVar.tlr.setText(R.string.fwl);
        } else if (bankcard.cPe()) {
            aVar.tlr.setText(R.string.fdu);
        } else {
            aVar.tlr.setText(R.string.fed);
        }
        if (aVar.tlp != null) {
            aVar.tlp.setText(bankcard.field_bankcardTail);
        }
        if (bo.isNullOrNil(bankcard.field_card_bottom_wording) || aVar.tNm == null) {
            aVar.tNl.setVisibility(8);
        } else {
            aVar.tNm.setText(bankcard.field_card_bottom_wording);
            aVar.tNl.setVisibility(0);
        }
        aVar2.a(context, bankcard, aVar.tlu, aVar.tNj, aVar.tlt, aVar.tNo);
        if (aVar.tlw != null) {
            com.tencent.mm.plugin.wallet_core.model.r.cPI();
            aVar.tlw.setVisibility(8);
        }
        AppMethodBeat.o(47877);
    }
}
