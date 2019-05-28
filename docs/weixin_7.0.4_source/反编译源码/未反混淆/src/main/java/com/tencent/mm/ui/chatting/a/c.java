package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c extends android.support.v7.widget.RecyclerView.a {
    public static e yNI;
    public static f yNJ = null;
    private Context mContext;
    public String yNK;

    public interface f {
        b Oy(int i);

        void a(a aVar, int i);

        int getCount();

        v v(ViewGroup viewGroup);
    }

    public interface e {
        void a(View view, int i, b bVar);

        void b(View view, int i, b bVar);
    }

    public static class a extends v {
        public ImageView ejo;
        public TextView enf;
        public TextView gnB;
        public TextView gxi;
        public View mRR;

        public a(View view) {
            super(view);
            AppMethodBeat.i(31151);
            this.mRR = view;
            this.ejo = (ImageView) view.findViewById(R.id.as);
            this.gxi = (TextView) view.findViewById(R.id.b4);
            this.enf = (TextView) view.findViewById(R.id.ba);
            this.gnB = (TextView) view.findViewById(R.id.bb);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31149);
                    if (c.yNI != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        c.yNI.a(view, intValue, c.yNJ.Oy(intValue));
                    }
                    AppMethodBeat.o(31149);
                }
            });
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(31150);
                    if (c.yNI != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        c.yNI.b(view, intValue, c.yNJ.Oy(intValue));
                    }
                    AppMethodBeat.o(31150);
                    return true;
                }
            });
            AppMethodBeat.o(31151);
        }

        public static void c(TextView textView, String str) {
            AppMethodBeat.i(31152);
            if (!bo.isNullOrNil(str)) {
                textView.getContext();
                textView.setText(com.tencent.mm.plugin.fts.a.f.a(textView.getText(), str));
            }
            AppMethodBeat.o(31152);
        }
    }

    public static class c extends b {
        public c(long j) {
            this.timestamp = j;
        }

        public final boolean arg(String str) {
            return false;
        }

        public final int getType() {
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }
    }

    public static abstract class b {
        public String bCv;
        public long cvx;
        public String iQV;
        public String nickname;
        public long timestamp;
        public String title;
        public int type;
        public String username;
        Pattern yNM = Pattern.compile("[._a-zA-Z0-9]+");

        public b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
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
            if (arh(str)) {
                if (!bo.isNullOrNil(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bo.isNullOrNil(this.nickname) && this.nickname.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bo.isNullOrNil(this.iQV) && this.iQV.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bo.isNullOrNil(this.bCv) && this.bCv.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!bo.isNullOrNil(this.title) && isContains(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!bo.isNullOrNil(this.nickname) && isContains(str, this.nickname.toLowerCase())) {
                    return true;
                }
                if (!bo.isNullOrNil(this.iQV) && isContains(str, this.iQV.toLowerCase())) {
                    return true;
                }
                if (!bo.isNullOrNil(this.bCv) && isContains(str, this.bCv.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean isContains(String str, String str2) {
            if (bo.isNullOrNil(str2)) {
                return false;
            }
            Matcher matcher = this.yNM.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                ab.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", str, r3);
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
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.cvx == ((b) obj).cvx;
        }
    }

    public class d extends v {
        TextView gnf;

        public d(View view) {
            super(view);
            AppMethodBeat.i(31153);
            this.gnf = (TextView) view.findViewById(R.id.bpo);
            this.gnf.setTextColor(c.this.mContext.getResources().getColor(R.color.p1));
            view.findViewById(R.id.m5).setBackgroundColor(c.this.mContext.getResources().getColor(R.color.ov));
            AppMethodBeat.o(31153);
        }
    }

    public c(Context context, f fVar) {
        yNJ = fVar;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(31154);
        int type = yNJ.Oy(i).getType();
        AppMethodBeat.o(31154);
        return type;
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(31155);
        if (i == BaseClientBuilder.API_PRIORITY_OTHER) {
            d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a25, viewGroup, false));
            AppMethodBeat.o(31155);
            return dVar;
        }
        v v = yNJ.v(viewGroup);
        AppMethodBeat.o(31155);
        return v;
    }

    public final void a(v vVar, int i) {
        AppMethodBeat.i(31156);
        int itemViewType = getItemViewType(i);
        b Oy = yNJ.Oy(i);
        if (itemViewType == BaseClientBuilder.API_PRIORITY_OTHER) {
            b Oy2 = yNJ.Oy(i + 1);
            if (i == getItemCount() - 1 || hb(Oy2.timestamp) != hb(Oy.timestamp)) {
                ((d) vVar).gnf.setVisibility(8);
                AppMethodBeat.o(31156);
                return;
            }
            ((d) vVar).gnf.setVisibility(0);
            ((d) vVar).gnf.setText(ha(Oy.timestamp));
            AppMethodBeat.o(31156);
            return;
        }
        a aVar = (a) vVar;
        aVar.mRR.setTag(Integer.valueOf(i));
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ejo, Oy.username);
        TextView textView = aVar.gxi;
        Context context = this.mContext;
        CharSequence charSequence = bo.isNullOrNil(this.yNK) ? bo.isNullOrNil(Oy.bCv) ? bo.isNullOrNil(Oy.iQV) ? Oy.nickname : Oy.iQV : Oy.bCv : bo.isNullOrNil(Oy.bCv) ? !bo.isNullOrNil(Oy.iQV) ? (bo.isNullOrNil(Oy.nickname) || !Oy.nickname.contains(this.yNK)) ? Oy.iQV : Oy.iQV + "(" + Oy.nickname + ")" : Oy.nickname : (bo.isNullOrNil(Oy.iQV) || !Oy.iQV.contains(this.yNK)) ? (bo.isNullOrNil(Oy.nickname) || !Oy.nickname.contains(this.yNK)) ? Oy.bCv : Oy.bCv + "(" + Oy.nickname + ")" : Oy.bCv + "(" + Oy.iQV + ")";
        textView.setText(j.b(context, charSequence, aVar.gxi.getTextSize()));
        aVar.enf.setText(com.tencent.mm.plugin.fav.ui.j.g(this.mContext, Oy.timestamp));
        aVar.gnB.setText(Oy.title);
        yNJ.a((a) vVar, i);
        if (!bo.isNullOrNil(this.yNK)) {
            a.c(aVar.gxi, this.yNK);
            a.c(aVar.gnB, this.yNK);
        }
        AppMethodBeat.o(31156);
    }

    public final int getItemCount() {
        boolean z;
        AppMethodBeat.i(31157);
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
        ab.i(str, str2, objArr);
        AppMethodBeat.o(31157);
        return count;
    }

    public final String ha(long j) {
        AppMethodBeat.i(31158);
        String a = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(j), this.mContext);
        AppMethodBeat.o(31158);
        return a;
    }

    private static long hb(long j) {
        AppMethodBeat.i(31159);
        long b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(j));
        AppMethodBeat.o(31159);
        return b;
    }
}
