package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class m extends BaseAdapter {
    private List<b> kaW = new ArrayList();
    OnClickListener koa;
    boolean kob = false;
    private Context mContext;

    class a {
        View jAp;
        TextView kne;
        TextView kog;
        TextView koh;
        ImageView koi;
        CheckBox koj;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(88692);
        b tg = tg(i);
        AppMethodBeat.o(88692);
        return tg;
    }

    public m(Context context) {
        AppMethodBeat.i(88685);
        this.mContext = context;
        AppMethodBeat.o(88685);
    }

    public final void setData(List<b> list) {
        AppMethodBeat.i(88686);
        this.kaW.clear();
        this.kaW.addAll(list);
        AppMethodBeat.o(88686);
    }

    public final int getCount() {
        AppMethodBeat.i(88687);
        int size = this.kaW.size();
        AppMethodBeat.o(88687);
        return size;
    }

    private b tg(int i) {
        AppMethodBeat.i(88688);
        b bVar = (b) this.kaW.get(i);
        AppMethodBeat.o(88688);
        return bVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(88689);
        final b tg = tg(i);
        switch (tg.kcg) {
            case 2:
                view = View.inflate(this.mContext, R.layout.hz, null);
                TextView textView = (TextView) view.findViewById(R.id.a_s);
                TextView textView2 = (TextView) view.findViewById(R.id.a_t);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.a_u);
                if (TextUtils.isEmpty(tg.kck)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(tg.kck);
                    linearLayout.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(88683);
                            String str = (String) view.getTag();
                            if (!TextUtils.isEmpty(str)) {
                                String substring;
                                if (str.contains(";")) {
                                    substring = str.substring(0, str.indexOf(";"));
                                } else {
                                    substring = str;
                                }
                                h.a(m.this.mContext, true, substring, "", m.this.mContext.getString(R.string.add), m.this.mContext.getString(R.string.atb), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(88682);
                                        Intent intent = new Intent("android.intent.action.DIAL");
                                        intent.setFlags(268435456);
                                        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(substring).toString()));
                                        m.this.mContext.startActivity(intent);
                                        AppMethodBeat.o(88682);
                                    }
                                }, null);
                            }
                            AppMethodBeat.o(88683);
                        }
                    });
                    ((ImageView) view.findViewById(R.id.a_v)).setBackgroundColor(l.Hn(tg.color));
                    linearLayout.setVisibility(0);
                }
                textView.setText(tg.title);
                textView2.setText(tg.kbW);
                AppMethodBeat.o(88689);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, R.layout.i0, null);
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.kne = (TextView) view.findViewById(R.id.aa0);
                    aVar2.kog = (TextView) view.findViewById(R.id.aa1);
                    aVar2.koh = (TextView) view.findViewById(R.id.a_x);
                    aVar2.koi = (ImageView) view.findViewById(R.id.a_z);
                    aVar2.jAp = view.findViewById(R.id.a_y);
                    aVar2.koj = (CheckBox) view.findViewById(R.id.aa2);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.kne.setText(tg.title);
                if (tg.kci) {
                    aVar.koj.setVisibility(0);
                    aVar.koj.setChecked(tg.kcj);
                    aVar.koj.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(88684);
                            if (((CheckBox) view).isChecked()) {
                                tg.kcj = true;
                                AppMethodBeat.o(88684);
                                return;
                            }
                            tg.kcj = false;
                            AppMethodBeat.o(88684);
                        }
                    });
                } else {
                    aVar.koj.setVisibility(8);
                }
                if (TextUtils.isEmpty(tg.kbW)) {
                    aVar.kog.setVisibility(4);
                } else {
                    aVar.kog.setVisibility(0);
                    aVar.kog.setText(tg.kbW);
                }
                if ((tg.vUW & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.kne.setGravity(17);
                    aVar.kne.setTextColor(this.mContext.getResources().getColor(R.color.t7));
                    aVar.kog.setVisibility(8);
                } else {
                    aVar.kne.setGravity(3);
                    aVar.kne.setTextColor(this.mContext.getResources().getColor(R.color.sr));
                }
                if (tg.kch) {
                    aVar.koh.setVisibility(0);
                } else {
                    aVar.koh.setVisibility(8);
                }
                aVar.kog.setTextColor(this.mContext.getResources().getColor(R.color.sq));
                if (bo.isNullOrNil(tg.kKZ)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.koi.setVisibility(0);
                    com.tencent.mm.plugin.card.d.m.a(aVar.koi, tg.kKZ, com.tencent.mm.bz.a.fromDPToPix(this.mContext, 20), (int) R.drawable.bcm, false);
                } else {
                    aVar.koi.setVisibility(8);
                }
                if (i + 1 < getCount()) {
                    a(aVar.jAp, tg(i));
                    a(aVar.jAp, tg(i + 1));
                } else if (i + 1 == getCount()) {
                    if (this.kob) {
                        o(aVar.jAp, true);
                    } else {
                        o(aVar.jAp, false);
                    }
                }
                AppMethodBeat.o(88689);
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        AppMethodBeat.i(88690);
        if (bVar == null) {
            AppMethodBeat.o(88690);
            return;
        }
        o(view, bVar.kch);
        AppMethodBeat.o(88690);
    }

    private static void o(View view, boolean z) {
        AppMethodBeat.i(88691);
        Rect dc = com.tencent.mm.plugin.card.d.m.dc(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(R.drawable.uv);
        } else {
            view.setBackgroundResource(R.drawable.a_q);
        }
        view.setLayoutParams(layoutParams);
        com.tencent.mm.plugin.card.d.m.k(view, dc);
        AppMethodBeat.o(88691);
    }
}
