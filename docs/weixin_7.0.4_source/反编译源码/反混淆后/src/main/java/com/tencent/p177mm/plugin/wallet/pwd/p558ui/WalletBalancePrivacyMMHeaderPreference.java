package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference */
public class WalletBalancePrivacyMMHeaderPreference extends Preference {
    String cIY;
    String title;
    private int tqN;
    Map<String, C32293a> tqO = new HashMap();

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(46208);
        AppMethodBeat.m2505o(46208);
    }

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(46209);
        AppMethodBeat.m2505o(46209);
    }

    /* renamed from: fa */
    public final void mo39409fa() {
        this.tqN = C1318a.addfriend_icon_invite;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(46210);
        super.onBindView(view);
        final ImageView imageView = (ImageView) view.findViewById(2131828629);
        TextView textView = (TextView) view.findViewById(2131828630);
        if (!C5046bo.isNullOrNil(this.cIY)) {
            C32291o.ahk();
            Bitmap kR = C17937c.m28186kR(this.cIY);
            if (kR != null) {
                imageView.setImageBitmap(kR);
            } else if (!C5046bo.isNullOrNil(this.cIY)) {
                C142001 c142001 = new C32293a() {
                    /* renamed from: i */
                    public final void mo11044i(String str, Bitmap bitmap) {
                        AppMethodBeat.m2504i(46207);
                        C4990ab.m7417i("MicroMsg.WalletBalancePrivacyMMHeaderPreference", "alvinluo icon url: %s", str);
                        imageView.setImageBitmap(bitmap);
                        AppMethodBeat.m2505o(46207);
                    }
                };
                this.tqO.put(this.cIY, c142001);
                C32291o.aho().mo53003a(this.cIY, c142001);
            }
        } else if (!C5046bo.m7563gW(this.tqN, 0)) {
            imageView.setImageResource(this.tqN);
        }
        if (!C5046bo.isNullOrNil(this.title)) {
            textView.setText(this.title);
        }
        AppMethodBeat.m2505o(46210);
    }
}
