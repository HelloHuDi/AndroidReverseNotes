package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI extends MMActivity implements f {
    private View Ek;
    private ProgressDialog gqo;
    private ListView mListView;
    private a nDx;
    private d nDy;

    static class a extends BaseAdapter {
        private IPCallMyGiftCardUI nDA = null;
        aqk nDB = null;
        List<crv> ngC = null;

        class a {
            TextView nDC;
            TextView nDD;
            TextView nDE;
            CdnImageView nDF;
            ImageView nDG;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            AppMethodBeat.i(22212);
            Assert.assertTrue(true);
            this.nDA = iPCallMyGiftCardUI;
            AppMethodBeat.o(22212);
        }

        public final int getCount() {
            AppMethodBeat.i(22213);
            if (this.ngC == null) {
                AppMethodBeat.o(22213);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(22213);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(22214);
            if (this.ngC != null) {
                Object obj = this.ngC.get(i);
                AppMethodBeat.o(22214);
                return obj;
            }
            AppMethodBeat.o(22214);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(22215);
            if (view == null) {
                view = ((LayoutInflater) this.nDA.getSystemService("layout_inflater")).inflate(R.layout.a8z, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.nDC = (TextView) view.findViewById(R.id.cjm);
                aVar.nDD = (TextView) view.findViewById(R.id.cjn);
                aVar.nDE = (TextView) view.findViewById(R.id.cjo);
                aVar.nDF = (CdnImageView) view.findViewById(R.id.ms);
                aVar.nDG = (ImageView) view.findViewById(R.id.cmy);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            crv crv = (crv) getItem(i);
            if (crv == null) {
                AppMethodBeat.o(22215);
            } else {
                if (bo.isNullOrNil(crv.xpv)) {
                    aVar.nDC.setVisibility(0);
                    aVar.nDD.setVisibility(0);
                    aVar.nDE.setVisibility(8);
                    aVar.nDC.setText(crv.wOs);
                    aVar.nDD.setText(crv.xpu);
                } else {
                    aVar.nDC.setVisibility(8);
                    aVar.nDD.setVisibility(8);
                    aVar.nDE.setVisibility(0);
                    aVar.nDE.setText(crv.xpv);
                }
                b.a(aVar.nDG, "", 0.5f, false);
                if (bo.isNullOrNil(crv.mZW)) {
                    aVar.nDG.setVisibility(0);
                    aVar.nDF.setVisibility(4);
                } else {
                    aVar.nDF.setVisibility(0);
                    aVar.nDF.setUrl(crv.mZW);
                    aVar.nDG.setVisibility(4);
                }
                AppMethodBeat.o(22215);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22216);
        super.onCreate(bundle);
        aw.Rg().a((int) com.tencent.view.d.MIC_PTU_YOUJIALI, (f) this);
        setMMTitle((int) R.string.cix);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22209);
                IPCallMyGiftCardUI.this.finish();
                AppMethodBeat.o(22209);
                return true;
            }
        });
        addTextOptionMenu(0, this.mController.ylL.getString(R.string.civ), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22210);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(R.string.cgo));
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(22210);
                return true;
            }
        });
        this.Ek = findViewById(R.id.cn0);
        this.mListView = (ListView) findViewById(R.id.cmz);
        this.nDx = new a(this);
        this.mListView.setAdapter(this.nDx);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.gqo = h.b(context, getString(R.string.ch0), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22211);
                try {
                    if (IPCallMyGiftCardUI.this.nDy != null) {
                        aw.Rg().c(IPCallMyGiftCardUI.this.nDy);
                    }
                    IPCallMyGiftCardUI.this.finish();
                    AppMethodBeat.o(22211);
                } catch (Exception e) {
                    ab.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", e.getMessage());
                    AppMethodBeat.o(22211);
                }
            }
        });
        this.nDy = new d();
        aw.Rg().a(this.nDy, 0);
        AppMethodBeat.o(22216);
    }

    public void onResume() {
        AppMethodBeat.i(22217);
        super.onResume();
        AppMethodBeat.o(22217);
    }

    public void onDestroy() {
        AppMethodBeat.i(22218);
        super.onDestroy();
        aw.Rg().b((int) com.tencent.view.d.MIC_PTU_YOUJIALI, (f) this);
        AppMethodBeat.o(22218);
    }

    public final int getLayoutId() {
        return R.layout.a90;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(22219);
        ab.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (mVar instanceof d) {
            if (i == 0 && i2 == 0) {
                aqk aqk = ((d) mVar).nym;
                if (this.gqo != null && this.gqo.isShowing()) {
                    this.gqo.dismiss();
                }
                this.nDx.ngC = aqk.wuj;
                this.nDx.nDB = aqk;
                this.nDx.notifyDataSetChanged();
                if (aqk.wuj.size() == 0) {
                    this.Ek.setVisibility(0);
                }
                AppMethodBeat.o(22219);
                return;
            }
            if (this.gqo != null && this.gqo.isShowing()) {
                this.gqo.dismiss();
            }
            this.Ek.setVisibility(0);
            Toast.makeText(this.mController.ylL, getString(R.string.cgx), 0).show();
        }
        AppMethodBeat.o(22219);
    }
}
