package com.tencent.p177mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView */
public class WxaBindBizInfoView extends LinearLayout {
    private static int iUs = C1338a.fromDPToPix(C4996ah.getContext(), 15);
    private static int iUt = C1338a.fromDPToPix(C4996ah.getContext(), 30);
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
        AppMethodBeat.m2504i(133654);
        init();
        AppMethodBeat.m2505o(133654);
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133655);
        init();
        AppMethodBeat.m2505o(133655);
    }

    private void init() {
        AppMethodBeat.m2504i(133656);
        this.iUl = new LinkedList();
        View inflate = View.inflate(getContext(), 2130968710, this);
        this.iUm = inflate.findViewById(2131821312);
        this.iUn = (ImageView) inflate.findViewById(2131821313);
        this.iDT = (TextView) inflate.findViewById(2131821314);
        this.iUo = (TextView) inflate.findViewById(2131821317);
        this.iUr = inflate.findViewById(2131821316);
        this.iUp = (LinearLayout) inflate.findViewById(2131821315);
        this.iUq = (ViewGroup) inflate.findViewById(2131821311);
        AppMethodBeat.m2505o(133656);
    }

    static {
        AppMethodBeat.m2504i(133657);
        AppMethodBeat.m2505o(133657);
    }

    public List<WxaEntryInfo> getWxaEntryInfoList() {
        return this.iUl;
    }
}
