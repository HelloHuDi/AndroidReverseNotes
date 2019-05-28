package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.b */
public abstract class C20869b extends C3154a {
    public C7616ad ehM;
    public C45966l hpS;
    public CharSequence jMY;
    public CharSequence jMZ;
    public String mJU;
    C3191a mJV = new C3191a();
    public String username;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.b$a */
    public class C3191a extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView gnB;
        public TextView gnC;
        TextView mJW;

        public C3191a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.b$b */
    public abstract class C20870b extends C3156b {
        public C20870b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130969613, viewGroup, false);
            C3191a c3191a = C20869b.this.mJV;
            c3191a.ejo = (ImageView) inflate.findViewById(2131821183);
            c3191a.gnB = (TextView) inflate.findViewById(2131821185);
            c3191a.gnC = (TextView) inflate.findViewById(2131820991);
            c3191a.mJW = (TextView) inflate.findViewById(2131824211);
            c3191a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c3191a);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            C3191a c3191a = (C3191a) c3155a;
            C20869b c20869b = (C20869b) c3154a;
            C3201m.m5503p(c3191a.contentView, C20869b.this.mFk);
            C40460b.m69434b(c3191a.ejo, c20869b.username);
            C3201m.m5501a(c20869b.jMY, c3191a.gnB);
            C3201m.m5501a(c20869b.jMZ, c3191a.gnC);
            C3201m.m5502b(c20869b.mJU, c3191a.mJW);
        }
    }

    public C20869b(int i) {
        super(1, i);
    }

    public final int aAq() {
        return this.hpS.mEK;
    }
}
