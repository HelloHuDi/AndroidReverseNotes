package com.tencent.p177mm.plugin.sns.lucky.p1299ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p444l.C3330a.C3331a;
import com.tencent.p177mm.pluginsdk.p1079f.C46486g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.ata;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.lucky.ui.b */
public final class C29041b extends BaseAdapter {
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    private LayoutInflater mInflater;
    private int nSA = 1;
    List<C3331a> nSx = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.sns.lucky.ui.b$a */
    class C29042a {
        ImageView kEn;
        TextView nSC;
        TextView nSD;
        TextView nSH;
        TextView niS;

        C29042a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(45194);
        C3331a CO = m46132CO(i);
        AppMethodBeat.m2505o(45194);
        return CO;
    }

    public C29041b(Context context) {
        AppMethodBeat.m2504i(45190);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(45190);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(45191);
        int size = this.nSx.size();
        AppMethodBeat.m2505o(45191);
        return size;
    }

    /* renamed from: CO */
    private C3331a m46132CO(int i) {
        AppMethodBeat.m2504i(45192);
        C3331a c3331a = (C3331a) this.nSx.get(i);
        AppMethodBeat.m2505o(45192);
        return c3331a;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C29042a c29042a;
        CharSequence charSequence;
        AppMethodBeat.m2504i(45193);
        if (view == null) {
            view = this.mInflater.inflate(2130970773, viewGroup, false);
            c29042a = new C29042a();
            c29042a.kEn = (ImageView) view.findViewById(2131825654);
            c29042a.niS = (TextView) view.findViewById(2131825655);
            c29042a.nSC = (TextView) view.findViewById(2131825659);
            c29042a.nSD = (TextView) view.findViewById(2131825656);
            c29042a.nSH = (TextView) view.findViewById(2131825661);
            view.setTag(c29042a);
        } else {
            c29042a = (C29042a) view.getTag();
        }
        C3331a CO = m46132CO(i);
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(CO.igi);
        if (CO.igi != null) {
            C40460b.m69437r(c29042a.kEn, CO.igi);
        } else {
            C4990ab.m7413e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", CO.igi);
        }
        TextView textView = c29042a.nSC;
        Context context = this.mContext;
        long j = ((long) CO.nRz) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = C46486g.m87705a(context.getString(C25738R.string.bwy, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        c29042a.nSC.setVisibility(0);
        if (aoO != null) {
            C46063x.m85800a(this.mContext, c29042a.niS, aoO.mo16707Oj());
        } else {
            C4990ab.m7413e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", CO.igi);
        }
        ata ata = new ata();
        try {
            if (CO.nRA == null || CO.nRA.getILen() <= 0) {
                c29042a.nSD.setVisibility(8);
                c29042a.nSH.setVisibility(0);
                AppMethodBeat.m2505o(45193);
                return view;
            }
            ata.parseFrom(C1946aa.m4150a(CO.nRA));
            if (ata.cSh > 0) {
                c29042a.nSD.setText(this.mContext.getString(C25738R.string.csn, new Object[]{C36391e.m59971F(((double) ata.cSh) / 100.0d)}));
                c29042a.nSH.setVisibility(8);
            } else {
                c29042a.nSD.setVisibility(8);
                c29042a.nSH.setVisibility(0);
            }
            AppMethodBeat.m2505o(45193);
            return view;
        } catch (Exception e) {
            C4990ab.m7412e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            c29042a.nSD.setVisibility(8);
            c29042a.nSH.setVisibility(8);
            c29042a.kEn.setVisibility(8);
            c29042a.niS.setVisibility(8);
            c29042a.nSC.setVisibility(8);
        }
    }
}
