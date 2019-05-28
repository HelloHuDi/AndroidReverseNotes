package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@i
public class WelabMainUI extends MMActivity {
    private Comparator<a> uMA = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(80617);
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == aVar2) {
                AppMethodBeat.o(80617);
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    AppMethodBeat.o(80617);
                    return 1;
                } else if (aVar.field_Pos == aVar2.field_Pos) {
                    int ank = bo.ank(aVar.field_expId);
                    int ank2 = bo.ank(aVar2.field_expId);
                    if (ank == ank2) {
                        AppMethodBeat.o(80617);
                        return 0;
                    } else if (ank2 > ank) {
                        AppMethodBeat.o(80617);
                        return 1;
                    } else {
                        AppMethodBeat.o(80617);
                        return -1;
                    }
                } else if (aVar.field_Pos > aVar2.field_Pos) {
                    AppMethodBeat.o(80617);
                    return 1;
                }
            }
            AppMethodBeat.o(80617);
            return -1;
        }
    };
    private OnClickListener uMB = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(80618);
            Object tag = view.getTag();
            if (tag instanceof a) {
                a aVar = (a) tag;
                Intent intent = new Intent();
                intent.putExtra("para_appid", aVar.field_LabsAppId);
                intent.putExtra("para_from_with_red_point", b.ddC().e(aVar) ? 1 : 0);
                intent.setClass(WelabMainUI.this, WelabAppInfoUI.class);
                WelabMainUI.this.startActivity(intent);
                b ddC = b.ddC();
                String str = aVar.field_LabsAppId;
                ddC.uLV.put(str, Integer.valueOf(1));
                ddC.tag += "&" + str + "=1";
                g.RP().Ry().set(ac.a.USERINFO_WELAB_REDPOINT_STRING, ddC.tag);
                b.ddD();
                ab.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(aVar)));
            }
            AppMethodBeat.o(80618);
        }
    };
    private boolean uMi = false;
    private LinearLayout uMt;
    private LinearLayout uMu;
    private LinearLayout uMv;
    private LinearLayout uMw;
    private View uMx;
    private View uMy;
    private List<String> uMz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WelabMainUI() {
        AppMethodBeat.i(80619);
        AppMethodBeat.o(80619);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(80620);
        super.onCreate(bundle);
        pO(true);
        dyb();
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.uMi = z;
            this.uMz = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        b.ddC();
        ah.doB().edit().putBoolean("key_has_enter_welab", true).commit();
        b.ddD();
        d.t("", 1, this.uMi);
        AppMethodBeat.o(80620);
    }

    public final int getLayoutId() {
        return R.layout.b7p;
    }

    public final void initView() {
        AppMethodBeat.i(80621);
        setMMTitle((int) R.string.g0u);
        xE(getResources().getColor(R.color.a68));
        Nc(getResources().getColor(R.color.d4));
        this.uMt = (LinearLayout) findViewById(R.id.fl8);
        this.uMv = (LinearLayout) findViewById(R.id.fl9);
        this.uMu = (LinearLayout) findViewById(R.id.fl_);
        this.uMw = (LinearLayout) findViewById(R.id.fla);
        this.uMx = findViewById(R.id.flb);
        this.uMy = findViewById(R.id.fl7);
        this.uMx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(80615);
                Intent intent = new Intent();
                intent.putExtra("title", view.getResources().getString(R.string.g0x));
                intent.putExtra("rawUrl", WelabMainUI.this.mController.ylL.getString(R.string.g0s, new Object[]{aa.dor(), Integer.valueOf(com.tencent.mm.protocal.d.vxo)}));
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(80615);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(80616);
                WelabMainUI.this.aqX();
                WelabMainUI.this.finish();
                AppMethodBeat.o(80616);
                return true;
            }
        });
        AppMethodBeat.o(80621);
    }

    public void onResume() {
        AppMethodBeat.i(80622);
        super.onResume();
        this.uMv.removeAllViews();
        this.uMw.removeAllViews();
        List<a> ddk = com.tencent.mm.plugin.welab.a.ddj().ddk();
        if (ddk == null || ddk.isEmpty()) {
            this.uMt.setVisibility(8);
        } else {
            a aVar;
            Iterator it = ddk.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!bo.isNullOrNil(aVar.field_LabsAppId) && this.uMz.contains(aVar.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (ddk.isEmpty()) {
                this.uMt.setVisibility(8);
            } else {
                this.uMt.setVisibility(0);
                Collections.sort(ddk, this.uMA);
                for (a aVar2 : ddk) {
                    a(aVar2, this.uMv);
                }
                ab.d("MicroMsg.WelabMainUI", "get online app count " + this.uMv.getChildCount());
            }
        }
        ddB();
        if (this.uMt.getVisibility() == 0 || this.uMu.getVisibility() == 0) {
            this.uMy.setVisibility(8);
            AppMethodBeat.o(80622);
            return;
        }
        this.uMy.setVisibility(0);
        AppMethodBeat.o(80622);
    }

    public void onPause() {
        AppMethodBeat.i(80623);
        super.onPause();
        AppMethodBeat.o(80623);
    }

    private void ddB() {
        a aVar;
        AppMethodBeat.i(80624);
        List<a> dds = com.tencent.mm.plugin.welab.a.ddj().uLQ.dds();
        Iterator it = dds.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if ((System.currentTimeMillis() / 1000) - aVar.field_endtime >= 2592000 || "labs1de6f3".equals(aVar.field_LabsAppId)) {
                it.remove();
                com.tencent.mm.plugin.welab.a.uLP.uLQ.a((c) aVar, new String[0]);
            } else if (aVar.isExpired() && aVar.field_Switch != 3) {
                aVar.field_Switch = 3;
                com.tencent.mm.plugin.welab.a.uLP.uLQ.c(aVar, new String[0]);
            } else if (aVar.field_Switch != 3) {
                it.remove();
            }
        }
        ab.i("WelabMgr", "stopped lab %s", dds.toString());
        if (dds.isEmpty()) {
            this.uMu.setVisibility(8);
            AppMethodBeat.o(80624);
            return;
        }
        this.uMu.setVisibility(0);
        Collections.sort(dds, this.uMA);
        for (a aVar2 : dds) {
            a(aVar2, this.uMw);
        }
        ab.d("MicroMsg.WelabMainUI", "get online app count " + this.uMw.getChildCount());
        AppMethodBeat.o(80624);
    }

    private void a(a aVar, LinearLayout linearLayout) {
        AppMethodBeat.i(80625);
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.b7n, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.fl0);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.fkz);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.cx);
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.a81);
        if (b.ddC().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.at.a.a.ahv().a(aVar.agR("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.a.ddj().udB);
        com.tencent.mm.plugin.welab.a.ddj();
        textView.setText(com.tencent.mm.plugin.welab.a.a(aVar));
        textView2.setText(aVar.agR("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.uMB);
        linearLayout.addView(linearLayout2);
        AppMethodBeat.o(80625);
    }
}
