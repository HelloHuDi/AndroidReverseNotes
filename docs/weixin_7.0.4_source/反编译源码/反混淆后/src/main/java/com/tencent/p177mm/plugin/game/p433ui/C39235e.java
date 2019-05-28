package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12122i;
import com.tencent.p177mm.plugin.game.p731d.C6931af;
import com.tencent.p177mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.game.ui.e */
public final class C39235e extends LinearLayout implements OnClickListener {
    private String mAppId;
    private Context mContext;
    private LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int mXC;

    /* renamed from: com.tencent.mm.plugin.game.ui.e$a */
    static class C12201a {
        public String jumpUrl;
        public String mVB;
        public int mYy;

        public C12201a(int i, String str, String str2) {
            this.mYy = i;
            this.jumpUrl = str;
            this.mVB = str2;
        }
    }

    public C39235e(Context context) {
        super(context);
        AppMethodBeat.m2504i(111736);
        this.mContext = context;
        setOrientation(1);
        AppMethodBeat.m2505o(111736);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo62129a(C6931af c6931af, String str, int i, int i2) {
        AppMethodBeat.m2504i(111737);
        if (c6931af == null || C5046bo.m7548ek(c6931af.naO)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111737);
            return;
        }
        this.mAppId = str;
        this.mXC = i2;
        Iterator it = c6931af.naO.iterator();
        while (it.hasNext()) {
            C12122i c12122i = (C12122i) it.next();
            if (c12122i != null) {
                C12125a c12125a = new C12125a();
                TextView textView;
                TextView textView2;
                switch (c12122i.mZQ) {
                    case 1:
                        if (c12122i.mZO == null) {
                            break;
                        }
                        m66848n(this);
                        View inflate = this.mInflater.inflate(2130969658, this, false);
                        textView = (TextView) inflate.findViewById(2131824306);
                        textView2 = (TextView) inflate.findViewById(2131824307);
                        EllipsizingTextView ellipsizingTextView = (EllipsizingTextView) inflate.findViewById(2131824308);
                        ellipsizingTextView.setMaxLines(2);
                        ImageView imageView = (ImageView) inflate.findViewById(2131824305);
                        textView.setText(C44089j.m79293b(this.mContext, c12122i.mZM, textView.getTextSize()));
                        textView2.setText(C44089j.m79293b(this.mContext, c12122i.mZO.Title, textView2.getTextSize()));
                        ellipsizingTextView.setText(C44089j.m79293b(this.mContext, c12122i.mZO.Desc, ellipsizingTextView.getTextSize()));
                        if (C5046bo.isNullOrNil(c12122i.mZO.mZi)) {
                            imageView.setVisibility(8);
                        } else {
                            C28203e.bFH().mo46098a(imageView, c12122i.mZO.mZi, c12125a.bFI());
                        }
                        inflate.setTag(new C12201a(c12122i.mZN, c12122i.mZO.mZj, c12122i.mZL));
                        inflate.setOnClickListener(this);
                        addView(inflate);
                    case 2:
                        if (c12122i.mZP == null) {
                            break;
                        }
                        m66848n(this);
                        View inflate2 = this.mInflater.inflate(2130969659, this, false);
                        textView = (TextView) inflate2.findViewById(2131824310);
                        textView2 = (TextView) inflate2.findViewById(2131824312);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(2131824311);
                        textView.setText(C44089j.m79293b(this.mContext, c12122i.mZM, textView.getTextSize()));
                        textView2.setText(C44089j.m79293b(this.mContext, c12122i.mZP.Title, textView2.getTextSize()));
                        if (C5046bo.isNullOrNil(c12122i.mZP.mZi)) {
                            imageView2.setVisibility(8);
                        } else {
                            if (c12122i.mZP.ndC == 1) {
                                c12125a.nnP = true;
                                c12125a.nnS = C25738R.drawable.af_;
                            } else {
                                c12125a.eQf = true;
                                c12125a.nnS = C25738R.drawable.af9;
                            }
                            C28203e.bFH().mo46098a(imageView2, c12122i.mZP.mZi, c12125a.bFI());
                        }
                        inflate2.setTag(new C12201a(c12122i.mZN, c12122i.mZP.mZj, c12122i.mZL));
                        inflate2.setOnClickListener(this);
                        addView(inflate2);
                    default:
                        if (i != 2) {
                            break;
                        }
                        C34276a.m56205a(this.mContext, 10, 1002, c12122i.mZN, str, i2, C34276a.m56208kY(c12122i.mZL));
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(111737);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(111738);
        if (view.getTag() == null || !(view.getTag() instanceof C12201a)) {
            C4990ab.m7420w("MicroMsg.GameBlockContentView", "getTag is null");
            AppMethodBeat.m2505o(111738);
            return;
        }
        C12201a c12201a = (C12201a) view.getTag();
        if (C5046bo.isNullOrNil(c12201a.jumpUrl)) {
            C4990ab.m7420w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            AppMethodBeat.m2505o(111738);
            return;
        }
        C34277b.m56211a(this.mContext, 10, 1002, c12201a.mYy, C46001c.m85464t(this.mContext, c12201a.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.mXC, C34276a.m56208kY(c12201a.mVB));
        AppMethodBeat.m2505o(111738);
    }

    /* renamed from: n */
    private void m66848n(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(111739);
        ImageView imageView = (ImageView) this.mInflater.inflate(2130969702, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = C1338a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
        AppMethodBeat.m2505o(111739);
    }
}
