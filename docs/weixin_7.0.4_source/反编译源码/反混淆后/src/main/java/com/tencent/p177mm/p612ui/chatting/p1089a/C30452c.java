package com.tencent.p177mm.p612ui.chatting.p1089a;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.ui.chatting.a.c */
public final class C30452c extends C41523a {
    public static C30451e yNI;
    public static C23689f yNJ = null;
    private Context mContext;
    public String yNK;

    /* renamed from: com.tencent.mm.ui.chatting.a.c$f */
    public interface C23689f {
        /* renamed from: Oy */
        C30455b mo39522Oy(int i);

        /* renamed from: a */
        void mo39523a(C30453a c30453a, int i);

        int getCount();

        /* renamed from: v */
        C41531v mo39525v(ViewGroup viewGroup);
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$e */
    public interface C30451e {
        /* renamed from: a */
        void mo48855a(View view, int i, C30455b c30455b);

        /* renamed from: b */
        void mo48856b(View view, int i, C30455b c30455b);
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$a */
    public static class C30453a extends C41531v {
        public ImageView ejo;
        public TextView enf;
        public TextView gnB;
        public TextView gxi;
        public View mRR;

        /* renamed from: com.tencent.mm.ui.chatting.a.c$a$1 */
        class C304491 implements OnClickListener {
            C304491() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(31149);
                if (C30452c.yNI != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    C30452c.yNI.mo48855a(view, intValue, C30452c.yNJ.mo39522Oy(intValue));
                }
                AppMethodBeat.m2505o(31149);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.a.c$a$2 */
        class C304502 implements OnLongClickListener {
            C304502() {
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(31150);
                if (C30452c.yNI != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    C30452c.yNI.mo48856b(view, intValue, C30452c.yNJ.mo39522Oy(intValue));
                }
                AppMethodBeat.m2505o(31150);
                return true;
            }
        }

        public C30453a(View view) {
            super(view);
            AppMethodBeat.m2504i(31151);
            this.mRR = view;
            this.ejo = (ImageView) view.findViewById(2131820599);
            this.gxi = (TextView) view.findViewById(2131820611);
            this.enf = (TextView) view.findViewById(2131820618);
            this.gnB = (TextView) view.findViewById(2131820619);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            view.setOnClickListener(new C304491());
            view.setOnLongClickListener(new C304502());
            AppMethodBeat.m2505o(31151);
        }

        /* renamed from: c */
        public static void m48568c(TextView textView, String str) {
            AppMethodBeat.m2504i(31152);
            if (!C5046bo.isNullOrNil(str)) {
                textView.getContext();
                textView.setText(C34204f.m56084a(textView.getText(), str));
            }
            AppMethodBeat.m2505o(31152);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$c */
    public static class C30454c extends C30455b {
        public C30454c(long j) {
            this.timestamp = j;
        }

        public final boolean arg(String str) {
            return false;
        }

        public final int getType() {
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$b */
    public static abstract class C30455b {
        public String bCv;
        public long cvx;
        public String iQV;
        public String nickname;
        public long timestamp;
        public String title;
        public int type;
        public String username;
        Pattern yNM = Pattern.compile("[._a-zA-Z0-9]+");

        public C30455b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.timestamp = j;
            this.type = i;
            this.title = str;
            this.cvx = j2;
            this.username = str2;
            this.nickname = str3;
            this.bCv = str4;
            this.iQV = str5;
        }

        public int getType() {
            return this.type;
        }

        public boolean arg(String str) {
            if (C30455b.arh(str)) {
                if (!C5046bo.isNullOrNil(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!C5046bo.isNullOrNil(this.nickname) && this.nickname.toLowerCase().contains(str)) {
                    return true;
                }
                if (!C5046bo.isNullOrNil(this.iQV) && this.iQV.toLowerCase().contains(str)) {
                    return true;
                }
                if (!C5046bo.isNullOrNil(this.bCv) && this.bCv.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!C5046bo.isNullOrNil(this.title) && isContains(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!C5046bo.isNullOrNil(this.nickname) && isContains(str, this.nickname.toLowerCase())) {
                    return true;
                }
                if (!C5046bo.isNullOrNil(this.iQV) && isContains(str, this.iQV.toLowerCase())) {
                    return true;
                }
                if (!C5046bo.isNullOrNil(this.bCv) && isContains(str, this.bCv.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isContains(String str, String str2) {
            if (C5046bo.isNullOrNil(str2)) {
                return false;
            }
            Matcher matcher = this.yNM.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                C4990ab.m7417i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", str, r3);
                if (z) {
                    return z;
                }
            }
            return z;
        }

        protected static boolean arh(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (toCharArray[i] >= 19968 && toCharArray[i] <= 40891) {
                    return true;
                }
                i++;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C30455b)) {
                return super.equals(obj);
            }
            return this.cvx == ((C30455b) obj).cvx;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a.c$d */
    public class C30456d extends C41531v {
        TextView gnf;

        public C30456d(View view) {
            super(view);
            AppMethodBeat.m2504i(31153);
            this.gnf = (TextView) view.findViewById(2131823899);
            this.gnf.setTextColor(C30452c.this.mContext.getResources().getColor(C25738R.color.f11999p1));
            view.findViewById(2131821019).setBackgroundColor(C30452c.this.mContext.getResources().getColor(C25738R.color.f11995ov));
            AppMethodBeat.m2505o(31153);
        }
    }

    public C30452c(Context context, C23689f c23689f) {
        yNJ = c23689f;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(31154);
        int type = yNJ.mo39522Oy(i).getType();
        AppMethodBeat.m2505o(31154);
        return type;
    }

    /* renamed from: a */
    public final C41531v mo4976a(ViewGroup viewGroup, int i) {
        AppMethodBeat.m2504i(31155);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            C30456d c30456d = new C30456d(LayoutInflater.from(viewGroup.getContext()).inflate(2130969647, viewGroup, false));
            AppMethodBeat.m2505o(31155);
            return c30456d;
        }
        C41531v v = yNJ.mo39525v(viewGroup);
        AppMethodBeat.m2505o(31155);
        return v;
    }

    /* renamed from: a */
    public final void mo4977a(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(31156);
        int itemViewType = getItemViewType(i);
        C30455b Oy = yNJ.mo39522Oy(i);
        if (itemViewType == BaseClientBuilder.API_PRIORITY_OTHER) {
            C30455b Oy2 = yNJ.mo39522Oy(i + 1);
            if (i == getItemCount() - 1 || C30452c.m48564hb(Oy2.timestamp) != C30452c.m48564hb(Oy.timestamp)) {
                ((C30456d) c41531v).gnf.setVisibility(8);
                AppMethodBeat.m2505o(31156);
                return;
            }
            ((C30456d) c41531v).gnf.setVisibility(0);
            ((C30456d) c41531v).gnf.setText(mo48857ha(Oy.timestamp));
            AppMethodBeat.m2505o(31156);
            return;
        }
        C30453a c30453a = (C30453a) c41531v;
        c30453a.mRR.setTag(Integer.valueOf(i));
        C40460b.m69434b(c30453a.ejo, Oy.username);
        TextView textView = c30453a.gxi;
        Context context = this.mContext;
        CharSequence charSequence = C5046bo.isNullOrNil(this.yNK) ? C5046bo.isNullOrNil(Oy.bCv) ? C5046bo.isNullOrNil(Oy.iQV) ? Oy.nickname : Oy.iQV : Oy.bCv : C5046bo.isNullOrNil(Oy.bCv) ? !C5046bo.isNullOrNil(Oy.iQV) ? (C5046bo.isNullOrNil(Oy.nickname) || !Oy.nickname.contains(this.yNK)) ? Oy.iQV : Oy.iQV + "(" + Oy.nickname + ")" : Oy.nickname : (C5046bo.isNullOrNil(Oy.iQV) || !Oy.iQV.contains(this.yNK)) ? (C5046bo.isNullOrNil(Oy.nickname) || !Oy.nickname.contains(this.yNK)) ? Oy.bCv : Oy.bCv + "(" + Oy.nickname + ")" : Oy.bCv + "(" + Oy.iQV + ")";
        textView.setText(C44089j.m79293b(context, charSequence, c30453a.gxi.getTextSize()));
        c30453a.enf.setText(C34171j.m56019g(this.mContext, Oy.timestamp));
        c30453a.gnB.setText(Oy.title);
        yNJ.mo39523a((C30453a) c41531v, i);
        if (!C5046bo.isNullOrNil(this.yNK)) {
            C30453a.m48568c(c30453a.gxi, this.yNK);
            C30453a.m48568c(c30453a.gnB, this.yNK);
        }
        AppMethodBeat.m2505o(31156);
    }

    public final int getItemCount() {
        boolean z;
        AppMethodBeat.m2504i(31157);
        int count = yNJ == null ? 0 : yNJ.getCount();
        String str = "MicroMsg.MediaHistoryListAdapter";
        String str2 = " null == mIDetail?%s getItemCount:%s";
        Object[] objArr = new Object[2];
        if (yNJ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(31157);
        return count;
    }

    /* renamed from: ha */
    public final String mo48857ha(long j) {
        AppMethodBeat.m2504i(31158);
        String a = C15894a.dJg().mo28137a(new Date(j), this.mContext);
        AppMethodBeat.m2505o(31158);
        return a;
    }

    /* renamed from: hb */
    private static long m48564hb(long j) {
        AppMethodBeat.m2504i(31159);
        long b = C15894a.dJg().mo28138b(new Date(j));
        AppMethodBeat.m2505o(31159);
        return b;
    }
}
