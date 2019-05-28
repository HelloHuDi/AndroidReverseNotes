package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    private LayoutInflater mInflater;
    private int nSA = 1;
    List<com.tencent.mm.plugin.l.a.a> nSx = new ArrayList();

    class a {
        ImageView kEn;
        TextView nSC;
        TextView nSD;
        TextView nSH;
        TextView niS;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(45194);
        com.tencent.mm.plugin.l.a.a CO = CO(i);
        AppMethodBeat.o(45194);
        return CO;
    }

    public b(Context context) {
        AppMethodBeat.i(45190);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(45190);
    }

    public final int getCount() {
        AppMethodBeat.i(45191);
        int size = this.nSx.size();
        AppMethodBeat.o(45191);
        return size;
    }

    private com.tencent.mm.plugin.l.a.a CO(int i) {
        AppMethodBeat.i(45192);
        com.tencent.mm.plugin.l.a.a aVar = (com.tencent.mm.plugin.l.a.a) this.nSx.get(i);
        AppMethodBeat.o(45192);
        return aVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        AppMethodBeat.i(45193);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.avk, viewGroup, false);
            aVar = new a();
            aVar.kEn = (ImageView) view.findViewById(R.id.d05);
            aVar.niS = (TextView) view.findViewById(R.id.d06);
            aVar.nSC = (TextView) view.findViewById(R.id.d0_);
            aVar.nSD = (TextView) view.findViewById(R.id.d07);
            aVar.nSH = (TextView) view.findViewById(R.id.d0b);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.l.a.a CO = CO(i);
        g.RQ();
        ad aoO = ((j) g.K(j.class)).XM().aoO(CO.igi);
        if (CO.igi != null) {
            com.tencent.mm.pluginsdk.ui.a.b.r(aVar.kEn, CO.igi);
        } else {
            ab.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", CO.igi);
        }
        TextView textView = aVar.nSC;
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
                charSequence = com.tencent.mm.pluginsdk.f.g.a(context.getString(R.string.bwy, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.nSC.setVisibility(0);
        if (aoO != null) {
            x.a(this.mContext, aVar.niS, aoO.Oj());
        } else {
            ab.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", CO.igi);
        }
        ata ata = new ata();
        try {
            if (CO.nRA == null || CO.nRA.getILen() <= 0) {
                aVar.nSD.setVisibility(8);
                aVar.nSH.setVisibility(0);
                AppMethodBeat.o(45193);
                return view;
            }
            ata.parseFrom(aa.a(CO.nRA));
            if (ata.cSh > 0) {
                aVar.nSD.setText(this.mContext.getString(R.string.csn, new Object[]{e.F(((double) ata.cSh) / 100.0d)}));
                aVar.nSH.setVisibility(8);
            } else {
                aVar.nSD.setVisibility(8);
                aVar.nSH.setVisibility(0);
            }
            AppMethodBeat.o(45193);
            return view;
        } catch (Exception e) {
            ab.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.nSD.setVisibility(8);
            aVar.nSH.setVisibility(8);
            aVar.kEn.setVisibility(8);
            aVar.niS.setVisibility(8);
            aVar.nSC.setVisibility(8);
        }
    }
}
