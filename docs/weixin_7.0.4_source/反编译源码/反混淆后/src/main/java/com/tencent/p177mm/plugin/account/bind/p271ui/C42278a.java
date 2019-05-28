package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.plugin.account.friend.p272a.C38036o;
import com.tencent.p177mm.plugin.account.friend.p272a.C45498n;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.a */
public final class C42278a extends C46692p<C45498n> {
    private String gqn;
    C1980a gsZ;
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.a$a */
    interface C1980a {
        /* renamed from: mS */
        void mo5738mS(int i);
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.a$b */
    class C18813b {
        ImageView eks;
        TextView gnh;
        String gta;
        TextView gtb;
        TextView gtc;
        View gtd;
        ProgressBar gte;
        int position;

        public C18813b(View view) {
            AppMethodBeat.m2504i(13643);
            this.eks = (ImageView) view.findViewById(2131824662);
            this.gtb = (TextView) view.findViewById(2131824663);
            this.gtd = view.findViewById(2131824665);
            this.gnh = (TextView) view.findViewById(2131824666);
            this.gte = (ProgressBar) view.findViewById(2131824667);
            this.gtc = (TextView) view.findViewById(2131824664);
            this.gtd.setOnClickListener(new OnClickListener(C42278a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(13642);
                    C4990ab.m7410d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (C42278a.this.gsZ != null) {
                        C42278a.this.gsZ.mo5738mS(C18813b.this.position);
                    }
                    AppMethodBeat.m2505o(13642);
                }
            });
            AppMethodBeat.m2505o(13643);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(13649);
        C45498n c45498n = (C45498n) obj;
        if (c45498n == null) {
            c45498n = new C45498n();
        }
        c45498n.mo8995d(cursor);
        AppMethodBeat.m2505o(13649);
        return c45498n;
    }

    public C42278a(Context context, String str) {
        super(context, new C45498n());
        AppMethodBeat.m2504i(13644);
        this.gqn = str;
        this.mContext = context;
        AppMethodBeat.m2505o(13644);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(13645);
        mo6869KC();
        AppMethodBeat.m2505o(13645);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(13646);
        setCursor(((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60782bi(this.mFilter, this.gqn));
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(13646);
    }

    /* renamed from: vM */
    public final void mo67801vM(String str) {
        AppMethodBeat.m2504i(13647);
        this.mFilter = C5046bo.m7586vA(str);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(13647);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C18813b c18813b;
        AppMethodBeat.m2504i(13648);
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(2130969798, null);
            C18813b c18813b2 = new C18813b(view);
            view.setTag(c18813b2);
            c18813b = c18813b2;
        } else {
            c18813b = (C18813b) view.getTag();
        }
        C45498n c45498n = (C45498n) getItem(i);
        if (c45498n == null) {
            AppMethodBeat.m2505o(13648);
        } else {
            c18813b.position = i;
            c18813b.gta = c45498n.field_googlegmail;
            Bitmap a;
            switch (c45498n.field_status) {
                case 0:
                case 2:
                    if (c45498n.field_small_url != null) {
                        a = C41730b.m73490a(c45498n.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        c18813b.eks.setImageBitmap(a);
                        break;
                    }
                    c18813b.eks.setImageDrawable(C1338a.m2864g(this.mContext, C1318a.default_avatar));
                    break;
                case 1:
                    a = C41730b.m73497pP(c45498n.field_googleid);
                    if (a != null) {
                        c18813b.eks.setImageBitmap(a);
                        break;
                    }
                    c18813b.eks.setImageDrawable(C1338a.m2864g(this.mContext, C1318a.default_avatar));
                    break;
            }
            if (TextUtils.isEmpty(c45498n.field_googlename)) {
                c18813b.gtb.setText(C5046bo.anu(c45498n.field_googlegmail));
            } else {
                c18813b.gtb.setText(c45498n.field_googlename);
            }
            switch (c45498n.field_status) {
                case 0:
                    c18813b.gtd.setClickable(true);
                    c18813b.gtd.setBackgroundResource(C25738R.drawable.f6484fp);
                    c18813b.gnh.setText(C25738R.string.c8d);
                    c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
                    break;
                case 1:
                    c18813b.gtd.setClickable(true);
                    c18813b.gtd.setBackgroundResource(C25738R.drawable.f6486fr);
                    c18813b.gnh.setText(C25738R.string.c8l);
                    c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12121t4));
                    break;
                case 2:
                    c18813b.gtd.setClickable(false);
                    c18813b.gtd.setBackgroundDrawable(null);
                    c18813b.gnh.setText(C25738R.string.c8f);
                    c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12121t4));
                    break;
            }
            switch (c45498n.field_googlecgistatus) {
                case 0:
                    c18813b.gnh.setVisibility(4);
                    c18813b.gte.setVisibility(0);
                    break;
                case 1:
                    c18813b.gtd.setClickable(false);
                    c18813b.gtd.setBackgroundDrawable(null);
                    c18813b.gnh.setVisibility(0);
                    c18813b.gte.setVisibility(8);
                    c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12121t4));
                    switch (c45498n.field_status) {
                        case 0:
                            c18813b.gnh.setText(C25738R.string.c8e);
                            break;
                        case 1:
                            c18813b.gnh.setText(C25738R.string.c8m);
                            break;
                    }
                    break;
                case 2:
                    c18813b.gnh.setVisibility(0);
                    c18813b.gte.setVisibility(8);
                    switch (c45498n.field_status) {
                        case 0:
                            c18813b.gnh.setText(C25738R.string.c8d);
                            c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.a69));
                            break;
                        case 1:
                            c18813b.gnh.setText(C25738R.string.c8l);
                            c18813b.gnh.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12121t4));
                            break;
                    }
                    break;
            }
            c18813b.gtc.setText(c45498n.field_googlegmail);
            AppMethodBeat.m2505o(13648);
        }
        return view;
    }
}
