package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference extends Preference {
    String cIY;
    String title;
    private int tqN;
    Map<String, a> tqO = new HashMap();

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(46208);
        AppMethodBeat.o(46208);
    }

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(46209);
        AppMethodBeat.o(46209);
    }

    public final void fa() {
        this.tqN = R.raw.addfriend_icon_invite;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(46210);
        super.onBindView(view);
        final ImageView imageView = (ImageView) view.findViewById(R.id.f6j);
        TextView textView = (TextView) view.findViewById(R.id.f6k);
        if (!bo.isNullOrNil(this.cIY)) {
            o.ahk();
            Bitmap kR = c.kR(this.cIY);
            if (kR != null) {
                imageView.setImageBitmap(kR);
            } else if (!bo.isNullOrNil(this.cIY)) {
                AnonymousClass1 anonymousClass1 = new a() {
                    public final void i(String str, Bitmap bitmap) {
                        AppMethodBeat.i(46207);
                        ab.i("MicroMsg.WalletBalancePrivacyMMHeaderPreference", "alvinluo icon url: %s", str);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.o(46207);
                    }
                };
                this.tqO.put(this.cIY, anonymousClass1);
                o.aho().a(this.cIY, anonymousClass1);
            }
        } else if (!bo.gW(this.tqN, 0)) {
            imageView.setImageResource(this.tqN);
        }
        if (!bo.isNullOrNil(this.title)) {
            textView.setText(this.title);
        }
        AppMethodBeat.o(46210);
    }
}
