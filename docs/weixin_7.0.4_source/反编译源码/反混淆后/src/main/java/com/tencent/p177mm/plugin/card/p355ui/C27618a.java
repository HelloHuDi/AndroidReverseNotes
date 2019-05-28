package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.ui.a */
public final class C27618a extends BaseAdapter {
    List<CardInfo> khh = new ArrayList();
    HashMap<String, Integer> kic = new HashMap();
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.ui.a$a */
    public class C2772a {
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
        AppMethodBeat.m2504i(88215);
        CardInfo sY = mo45469sY(i);
        AppMethodBeat.m2505o(88215);
        return sY;
    }

    public C27618a(Context context) {
        AppMethodBeat.m2504i(88211);
        this.mContext = context;
        AppMethodBeat.m2505o(88211);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(88212);
        int size = this.khh.size();
        AppMethodBeat.m2505o(88212);
        return size;
    }

    /* renamed from: sY */
    public final CardInfo mo45469sY(int i) {
        AppMethodBeat.m2504i(88213);
        CardInfo cardInfo = (CardInfo) this.khh.get(i);
        AppMethodBeat.m2505o(88213);
        return cardInfo;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C2772a c2772a;
        AppMethodBeat.m2504i(88214);
        CardInfo sY = mo45469sY(i);
        if (view == null) {
            view = View.inflate(this.mContext, 2130968890, null);
            c2772a = new C2772a();
            c2772a.khS = (RelativeLayout) view.findViewById(2131821912);
            c2772a.kid = (LinearLayout) view.findViewById(2131821913);
            c2772a.khT = (ImageView) view.findViewById(2131821914);
            c2772a.khU = (TextView) view.findViewById(2131821915);
            c2772a.khV = (TextView) view.findViewById(2131821917);
            c2772a.khW = (TextView) view.findViewById(2131821920);
            c2772a.khY = (TextView) view.findViewById(2131821921);
            c2772a.kie = (ImageView) view.findViewById(2131821916);
            c2772a.kif = (TextView) view.findViewById(2131821918);
            c2772a.kig = (TextView) view.findViewById(2131821919);
            view.setTag(c2772a);
        } else {
            c2772a = (C2772a) view.getTag();
        }
        if (sY.aZI()) {
            c2772a.khT.setVisibility(0);
            c2772a.khV.setVisibility(0);
            c2772a.khW.setVisibility(0);
            c2772a.khY.setVisibility(8);
            c2772a.khU.setVisibility(0);
            c2772a.khU.setText(sY.aZV().kdg);
            if (!sY.aZF()) {
                c2772a.khV.setText(sY.aZV().title);
            } else if (sY.aZV().vTW != null && sY.aZV().vTW.size() == 1) {
                c2772a.khV.setText(((C23446tm) sY.aZV().vTW.get(0)).title);
            } else if (sY.aZV().vTW != null && sY.aZV().vTW.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((C23446tm) sY.aZV().vTW.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((C23446tm) sY.aZV().vTW.get(1)).title);
                c2772a.khV.setText(stringBuilder.toString());
            }
            if (sY.aZV().vUv == 1) {
                c2772a.kie.setVisibility(0);
            } else {
                c2772a.kie.setVisibility(8);
            }
            long j = sY.field_begin_time;
            if (sY.getEndTime() > 0 && j > 0) {
                c2772a.khW.setText(this.mContext.getString(C25738R.string.aif, new Object[]{C38736l.m65728fQ(j) + "  -  " + C38736l.m65728fQ(sY.getEndTime())}));
                c2772a.khW.setVisibility(0);
            } else if (sY.getEndTime() > 0) {
                c2772a.khW.setText(this.mContext.getString(C25738R.string.aie, new Object[]{C38736l.m65728fQ(sY.getEndTime())}));
                c2772a.khW.setVisibility(0);
            } else {
                c2772a.khW.setText("");
                c2772a.khW.setVisibility(8);
            }
            C45778m.m84644a(c2772a.khT, sY.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10255vx), (int) C25738R.drawable.bcm, true);
            if (sY.aZV().vUt == 1) {
                c2772a.khT.setAlpha(255);
                c2772a.kig.setVisibility(8);
                c2772a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                c2772a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.f11835is));
                c2772a.khW.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12073rb));
            } else {
                c2772a.kig.setText(sY.aZV().vUu);
                c2772a.khT.setAlpha(90);
                c2772a.kig.setVisibility(0);
                c2772a.khV.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12073rb));
                c2772a.khU.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12073rb));
                c2772a.khW.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12073rb));
            }
            int intValue = ((Integer) this.kic.get(sY.baa())).intValue();
            if (intValue == 1) {
                c2772a.kif.setText("");
                c2772a.kif.setVisibility(8);
            } else {
                c2772a.kif.setText(VideoMaterialUtil.CRAZYFACE_X.concat(String.valueOf(intValue)));
                c2772a.kif.setVisibility(0);
            }
        } else {
            c2772a.khT.setVisibility(8);
            c2772a.khV.setVisibility(8);
            c2772a.khU.setVisibility(8);
            c2772a.khW.setVisibility(8);
            c2772a.kig.setVisibility(8);
            c2772a.kif.setVisibility(8);
            c2772a.khY.setVisibility(0);
            c2772a.khS.setBackgroundColor(this.mContext.getResources().getColor(C25738R.color.f11850jb));
            c2772a.khY.setText(this.mContext.getResources().getString(C25738R.string.agb));
        }
        AppMethodBeat.m2505o(88214);
        return view;
    }
}
