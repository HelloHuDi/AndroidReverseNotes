package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private Context pik;
    private List<com.tencent.mm.plugin.product.c.a> pil;
    private List<Boolean> pim;
    private int pio = 1;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(44034);
        com.tencent.mm.plugin.product.c.a AN = AN(i);
        AppMethodBeat.o(44034);
        return AN;
    }

    public a(Context context) {
        this.pik = context;
    }

    public final void cz(List<com.tencent.mm.plugin.product.c.a> list) {
        AppMethodBeat.i(44028);
        this.pil = list;
        this.pio = 0;
        this.pim = new ArrayList();
        if (this.pil != null) {
            HashSet hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.pim.add(Boolean.FALSE);
                hashSet.add(Integer.valueOf(aVar.jCt));
            }
            this.pio = list.size();
        }
        if (this.pio <= 0) {
            this.pio = 1;
        }
        AppMethodBeat.o(44028);
    }

    public final void a(Activity activity, View view, int i) {
        AppMethodBeat.i(44029);
        b bVar = (b) view.getTag();
        ab.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        ab.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.pis);
        Intent intent;
        switch (bVar.type) {
            case 0:
                AppMethodBeat.o(44029);
                return;
            case 1:
                if (bVar.pis instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.pis);
                    intent.putExtra("showShare", false);
                    d.b(this.pik, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, (int) Downloads.MIN_WAIT_FOR_NETWORK);
                    AppMethodBeat.o(44029);
                    return;
                }
                break;
            case 2:
                if (bVar.pis instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.pis;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    AppMethodBeat.o(44029);
                    return;
                }
                break;
            case 4:
            case 6:
                if (bVar.pis instanceof String) {
                    String str = (String) bVar.pis;
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("data", str);
                    intent2.putExtra("QRDataFlag", false);
                    d.b((Context) activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    AppMethodBeat.o(44029);
                    return;
                }
                break;
            case 5:
                if (((Boolean) this.pim.get(i)).booleanValue()) {
                    this.pim.set(i, Boolean.FALSE);
                } else {
                    this.pim.set(i, Boolean.TRUE);
                }
                notifyDataSetChanged();
                AppMethodBeat.o(44029);
                return;
            default:
                ab.w("MicroMsg.MallCustomActionAdapter", "not support type");
                break;
        }
        AppMethodBeat.o(44029);
    }

    public final int getCount() {
        AppMethodBeat.i(44030);
        if (this.pil != null) {
            int size = this.pil.size();
            AppMethodBeat.o(44030);
            return size;
        }
        AppMethodBeat.o(44030);
        return 0;
    }

    private com.tencent.mm.plugin.product.c.a AN(int i) {
        AppMethodBeat.i(44031);
        com.tencent.mm.plugin.product.c.a aVar = (com.tencent.mm.plugin.product.c.a) this.pil.get(i);
        AppMethodBeat.o(44031);
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.pio;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(44032);
        int i2 = AN(i).jCt;
        AppMethodBeat.o(44032);
        return i2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(44033);
        if (view == null) {
            view = View.inflate(this.pik, R.layout.al7, null);
            bVar = new b();
            bVar.iDT = (TextView) view.findViewById(R.id.qm);
            bVar.pip = (TextView) view.findViewById(R.id.don);
            bVar.piq = (ImageView) view.findViewById(R.id.doo);
            bVar.pir = (HtmlTextView) view.findViewById(R.id.dop);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a AN = AN(i);
        if (AN != null) {
            bVar.iDT.setText(AN.Name);
            bVar.pip.setText(AN.phA);
            bVar.type = AN.jCt;
            bVar.pis = AN.ncM;
            bVar.title = AN.Name;
            switch (AN.jCt) {
                case 0:
                    bVar.piq.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.pim.get(i)).booleanValue()) {
                        bVar.pir.setVisibility(0);
                    } else {
                        bVar.pir.setVisibility(8);
                    }
                    if (!bVar.pir.getText().equals(AN.ncM)) {
                        bVar.pir.setText(AN.ncM);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(44033);
        return view;
    }
}
