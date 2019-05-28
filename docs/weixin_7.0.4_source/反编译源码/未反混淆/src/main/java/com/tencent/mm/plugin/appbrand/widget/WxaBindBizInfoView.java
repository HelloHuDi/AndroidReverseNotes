package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int iUs = a.fromDPToPix(ah.getContext(), 15);
    private static int iUt = a.fromDPToPix(ah.getContext(), 30);
    private TextView iDT;
    private List<WxaEntryInfo> iUl;
    private View iUm;
    private ImageView iUn;
    private TextView iUo;
    private LinearLayout iUp;
    private ViewGroup iUq;
    private View iUr;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133654);
        init();
        AppMethodBeat.o(133654);
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133655);
        init();
        AppMethodBeat.o(133655);
    }

    private void init() {
        AppMethodBeat.i(133656);
        this.iUl = new LinkedList();
        View inflate = View.inflate(getContext(), R.layout.cx, this);
        this.iUm = inflate.findViewById(R.id.u2);
        this.iUn = (ImageView) inflate.findViewById(R.id.u3);
        this.iDT = (TextView) inflate.findViewById(R.id.u4);
        this.iUo = (TextView) inflate.findViewById(R.id.u7);
        this.iUr = inflate.findViewById(R.id.u6);
        this.iUp = (LinearLayout) inflate.findViewById(R.id.u5);
        this.iUq = (ViewGroup) inflate.findViewById(R.id.u1);
        AppMethodBeat.o(133656);
    }

    static {
        AppMethodBeat.i(133657);
        AppMethodBeat.o(133657);
    }

    public List<WxaEntryInfo> getWxaEntryInfoList() {
        return this.iUl;
    }
}
