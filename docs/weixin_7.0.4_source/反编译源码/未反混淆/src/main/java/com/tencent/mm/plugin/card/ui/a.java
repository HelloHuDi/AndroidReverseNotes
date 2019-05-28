package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    List<CardInfo> khh = new ArrayList();
    HashMap<String, Integer> kic = new HashMap();
    Context mContext;

    public class a {
        public RelativeLayout khS;
        public ImageView khT;
        public TextView khU;
        public TextView khV;
        public TextView khW;
        public TextView khY;
        public LinearLayout kid;
        public ImageView kie;
        public TextView kif;
        public TextView kig;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(88215);
        CardInfo sY = sY(i);
        AppMethodBeat.o(88215);
        return sY;
    }

    public a(Context context) {
        AppMethodBeat.i(88211);
        this.mContext = context;
        AppMethodBeat.o(88211);
    }

    public final int getCount() {
        AppMethodBeat.i(88212);
        int size = this.khh.size();
        AppMethodBeat.o(88212);
        return size;
    }

    public final CardInfo sY(int i) {
        AppMethodBeat.i(88213);
        CardInfo cardInfo = (CardInfo) this.khh.get(i);
        AppMethodBeat.o(88213);
        return cardInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(88214);
        CardInfo sY = sY(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.hs, null);
            aVar = new a();
            aVar.khS = (RelativeLayout) view.findViewById(R.id.a9y);
            aVar.kid = (LinearLayout) view.findViewById(R.id.a9z);
            aVar.khT = (ImageView) view.findViewById(R.id.a_0);
            aVar.khU = (TextView) view.findViewById(R.id.a_1);
            aVar.khV = (TextView) view.findViewById(R.id.a_3);
            aVar.khW = (TextView) view.findViewById(R.id.a_6);
            aVar.khY = (TextView) view.findViewById(R.id.a_7);
            aVar.kie = (ImageView) view.findViewById(R.id.a_2);
            aVar.kif = (TextView) view.findViewById(R.id.a_4);
            aVar.kig = (TextView) view.findViewById(R.id.a_5);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (sY.aZI()) {
            aVar.khT.setVisibility(0);
            aVar.khV.setVisibility(0);
            aVar.khW.setVisibility(0);
            aVar.khY.setVisibility(8);
            aVar.khU.setVisibility(0);
            aVar.khU.setText(sY.aZV().kdg);
            if (!sY.aZF()) {
                aVar.khV.setText(sY.aZV().title);
            } else if (sY.aZV().vTW != null && sY.aZV().vTW.size() == 1) {
                aVar.khV.setText(((tm) sY.aZV().vTW.get(0)).title);
            } else if (sY.aZV().vTW != null && sY.aZV().vTW.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((tm) sY.aZV().vTW.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((tm) sY.aZV().vTW.get(1)).title);
                aVar.khV.setText(stringBuilder.toString());
            }
            if (sY.aZV().vUv == 1) {
                aVar.kie.setVisibility(0);
            } else {
                aVar.kie.setVisibility(8);
            }
            long j = sY.field_begin_time;
            if (sY.getEndTime() > 0 && j > 0) {
                aVar.khW.setText(this.mContext.getString(R.string.aif, new Object[]{l.fQ(j) + "  -  " + l.fQ(sY.getEndTime())}));
                aVar.khW.setVisibility(0);
            } else if (sY.getEndTime() > 0) {
                aVar.khW.setText(this.mContext.getString(R.string.aie, new Object[]{l.fQ(sY.getEndTime())}));
                aVar.khW.setVisibility(0);
            } else {
                aVar.khW.setText("");
                aVar.khW.setVisibility(8);
            }
            m.a(aVar.khT, sY.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(R.dimen.vx), (int) R.drawable.bcm, true);
            if (sY.aZV().vUt == 1) {
                aVar.khT.setAlpha(255);
                aVar.kig.setVisibility(8);
                aVar.khV.setTextColor(this.mContext.getResources().getColor(R.color.is));
                aVar.khU.setTextColor(this.mContext.getResources().getColor(R.color.is));
                aVar.khW.setTextColor(this.mContext.getResources().getColor(R.color.rb));
            } else {
                aVar.kig.setText(sY.aZV().vUu);
                aVar.khT.setAlpha(90);
                aVar.kig.setVisibility(0);
                aVar.khV.setTextColor(this.mContext.getResources().getColor(R.color.rb));
                aVar.khU.setTextColor(this.mContext.getResources().getColor(R.color.rb));
                aVar.khW.setTextColor(this.mContext.getResources().getColor(R.color.rb));
            }
            int intValue = ((Integer) this.kic.get(sY.baa())).intValue();
            if (intValue == 1) {
                aVar.kif.setText("");
                aVar.kif.setVisibility(8);
            } else {
                aVar.kif.setText(VideoMaterialUtil.CRAZYFACE_X.concat(String.valueOf(intValue)));
                aVar.kif.setVisibility(0);
            }
        } else {
            aVar.khT.setVisibility(8);
            aVar.khV.setVisibility(8);
            aVar.khU.setVisibility(8);
            aVar.khW.setVisibility(8);
            aVar.kig.setVisibility(8);
            aVar.kif.setVisibility(8);
            aVar.khY.setVisibility(0);
            aVar.khS.setBackgroundColor(this.mContext.getResources().getColor(R.color.jb));
            aVar.khY.setText(this.mContext.getResources().getString(R.string.agb));
        }
        AppMethodBeat.o(88214);
        return view;
    }
}
