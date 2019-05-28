package com.tencent.p177mm.plugin.product.p482ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.product.p737c.C28671a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.product.ui.a */
public final class C12826a extends BaseAdapter {
    private Context pik;
    private List<C28671a> pil;
    private List<Boolean> pim;
    private int pio = 1;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(44034);
        C28671a AN = m20817AN(i);
        AppMethodBeat.m2505o(44034);
        return AN;
    }

    public C12826a(Context context) {
        this.pik = context;
    }

    /* renamed from: cz */
    public final void mo24846cz(List<C28671a> list) {
        AppMethodBeat.m2504i(44028);
        this.pil = list;
        this.pio = 0;
        this.pim = new ArrayList();
        if (this.pil != null) {
            HashSet hashSet = new HashSet();
            for (C28671a c28671a : list) {
                this.pim.add(Boolean.FALSE);
                hashSet.add(Integer.valueOf(c28671a.jCt));
            }
            this.pio = list.size();
        }
        if (this.pio <= 0) {
            this.pio = 1;
        }
        AppMethodBeat.m2505o(44028);
    }

    /* renamed from: a */
    public final void mo24845a(Activity activity, View view, int i) {
        AppMethodBeat.m2504i(44029);
        C46134b c46134b = (C46134b) view.getTag();
        C4990ab.m7416i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + c46134b.type);
        C4990ab.m7416i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + c46134b.pis);
        Intent intent;
        switch (c46134b.type) {
            case 0:
                AppMethodBeat.m2505o(44029);
                return;
            case 1:
                if (c46134b.pis instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) c46134b.pis);
                    intent.putExtra("showShare", false);
                    C25985d.m41468b(this.pik, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, (int) Downloads.MIN_WAIT_FOR_NETWORK);
                    AppMethodBeat.m2505o(44029);
                    return;
                }
                break;
            case 2:
                if (c46134b.pis instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) c46134b.pis;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    AppMethodBeat.m2505o(44029);
                    return;
                }
                break;
            case 4:
            case 6:
                if (c46134b.pis instanceof String) {
                    String str = (String) c46134b.pis;
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", c46134b.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("data", str);
                    intent2.putExtra("QRDataFlag", false);
                    C25985d.m41467b((Context) activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    AppMethodBeat.m2505o(44029);
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
                AppMethodBeat.m2505o(44029);
                return;
            default:
                C4990ab.m7420w("MicroMsg.MallCustomActionAdapter", "not support type");
                break;
        }
        AppMethodBeat.m2505o(44029);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(44030);
        if (this.pil != null) {
            int size = this.pil.size();
            AppMethodBeat.m2505o(44030);
            return size;
        }
        AppMethodBeat.m2505o(44030);
        return 0;
    }

    /* renamed from: AN */
    private C28671a m20817AN(int i) {
        AppMethodBeat.m2504i(44031);
        C28671a c28671a = (C28671a) this.pil.get(i);
        AppMethodBeat.m2505o(44031);
        return c28671a;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.pio;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(44032);
        int i2 = m20817AN(i).jCt;
        AppMethodBeat.m2505o(44032);
        return i2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C46134b c46134b;
        AppMethodBeat.m2504i(44033);
        if (view == null) {
            view = View.inflate(this.pik, 2130970390, null);
            c46134b = new C46134b();
            c46134b.iDT = (TextView) view.findViewById(2131821185);
            c46134b.pip = (TextView) view.findViewById(2131826598);
            c46134b.piq = (ImageView) view.findViewById(2131826599);
            c46134b.pir = (HtmlTextView) view.findViewById(2131826600);
            view.setTag(c46134b);
        } else {
            c46134b = (C46134b) view.getTag();
        }
        C28671a AN = m20817AN(i);
        if (AN != null) {
            c46134b.iDT.setText(AN.Name);
            c46134b.pip.setText(AN.phA);
            c46134b.type = AN.jCt;
            c46134b.pis = AN.ncM;
            c46134b.title = AN.Name;
            switch (AN.jCt) {
                case 0:
                    c46134b.piq.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.pim.get(i)).booleanValue()) {
                        c46134b.pir.setVisibility(0);
                    } else {
                        c46134b.pir.setVisibility(8);
                    }
                    if (!c46134b.pir.getText().equals(AN.ncM)) {
                        c46134b.pir.setText(AN.ncM);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(44033);
        return view;
    }
}
