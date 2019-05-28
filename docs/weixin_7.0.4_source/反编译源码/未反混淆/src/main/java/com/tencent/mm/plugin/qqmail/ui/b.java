package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements f {
    int mode;
    private TextView pwq;
    private ImageView pwr;
    ComposeUI pxP;
    ViewGroup pxQ;
    Map<String, ai> pxR;
    Map<String, u> pxS;
    Map<String, String> pxT;
    Map<String, String> pxU;
    b pxV;
    private OnClickListener pxW;

    class a {
        TextView gxi;
        ImageView iqT;
        TextView pxy;
        ProgressBar pyf;
        TextView pyg;
        ImageView pyh;
        ImageView pyi;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public interface b {
        void ccU();

        void onComplete();
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        AppMethodBeat.i(68295);
        this.pxR = new HashMap();
        this.pxS = new HashMap();
        this.pxT = new LinkedHashMap();
        this.pxU = new LinkedHashMap();
        this.pxV = null;
        this.pxW = null;
        this.mode = 5;
        this.pxP = composeUI;
        this.pxQ = viewGroup;
        this.pxW = null;
        this.pwq = textView;
        this.pwr = imageView;
        cdd();
        g.RO().eJo.a(484, (f) this);
        AppMethodBeat.o(68295);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void cI(List<ai> list) {
        AppMethodBeat.i(68296);
        if (list == null) {
            AppMethodBeat.o(68296);
            return;
        }
        for (ai aiVar : list) {
            a(aiVar);
            this.pxR.put(aiVar.path, aiVar);
        }
        if (this.mode == 6) {
            for (ai aiVar2 : list) {
                this.pxT.put(aiVar2.path, aiVar2.pvH);
                this.pxU.put(aiVar2.path, aiVar2.name);
            }
        }
        AppMethodBeat.o(68296);
    }

    public final void fG(String str, String str2) {
        AppMethodBeat.i(68297);
        if (str == null || str.length() == 0 || this.pxR.containsKey(str)) {
            AppMethodBeat.o(68297);
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            ai aiVar = new ai();
            aiVar.path = str;
            if (str2 == null) {
                aiVar.name = file.getName();
            } else {
                aiVar.name = str2;
            }
            aiVar.size = file.length();
            aiVar.state = 0;
            this.pxR.put(str, aiVar);
            a(aiVar);
            AppMethodBeat.o(68297);
            return;
        }
        AppMethodBeat.o(68297);
    }

    public final boolean wi(String str) {
        AppMethodBeat.i(68298);
        boolean containsKey = this.pxR.containsKey(str);
        AppMethodBeat.o(68298);
        return containsKey;
    }

    private void a(final ai aiVar) {
        AppMethodBeat.i(68299);
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.pxP, R.layout.am5, null)).findViewById(R.id.dra);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.drb);
        TextView textView = (TextView) linearLayout.findViewById(R.id.drc);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.drd);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.dre);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.drf);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.drg);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.drh);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.ajW(aiVar.name));
        textView.setText(aiVar.name);
        textView2.setText(bo.ga(aiVar.size));
        a aVar = new a(this, (byte) 0);
        aVar.iqT = imageView;
        aVar.gxi = textView;
        aVar.pxy = textView2;
        aVar.pyf = progressBar;
        aVar.pyg = textView3;
        aVar.pyh = imageView2;
        aVar.pyi = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(aiVar.path.hashCode() / 2));
        if (this.pxW != null) {
            linearLayout.setOnClickListener(this.pxW);
        }
        this.pxQ.addView(linearLayout);
        cdd();
        linearLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68282);
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
                AppMethodBeat.o(68282);
            }
        });
        imageView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68283);
                if (b.this.mode == 5) {
                    aiVar.pvG = b.this.Vr(aiVar.path);
                    AppMethodBeat.o(68283);
                    return;
                }
                if (b.this.mode == 6) {
                    aiVar.pvG = b.this.fH(aiVar.path, aiVar.name);
                }
                AppMethodBeat.o(68283);
            }
        });
        imageView3.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(68285);
                h.a(b.this.pxP, (int) R.string.dd0, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(68284);
                        if (aiVar.state == 0 || aiVar.state == 1) {
                            b bVar = b.this;
                            ai aiVar = aiVar;
                            if (bVar.mode == 5) {
                                ac.ccC().cancel(aiVar.pvG);
                            } else if (bVar.mode == 6) {
                                m mVar = (u) bVar.pxS.get(aiVar.path);
                                if (mVar != null) {
                                    g.RO().eJo.c(mVar);
                                }
                                bVar.pxT.remove(aiVar.path);
                                bVar.pxU.remove(aiVar.path);
                            }
                        }
                        b.this.pxR.remove(aiVar.path);
                        b.this.pxS.remove(aiVar.path);
                        b.this.pxT.remove(aiVar.path);
                        b.this.pxU.remove(aiVar.path);
                        b.this.pxQ.removeView(linearLayout);
                        b.this.cdd();
                        AppMethodBeat.o(68284);
                    }
                }, null);
                AppMethodBeat.o(68285);
            }
        });
        this.pxQ.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68286);
                b.this.b(aiVar);
                AppMethodBeat.o(68286);
            }
        });
        if (aiVar.state == 0) {
            if (this.mode == 5) {
                aiVar.pvG = Vr(aiVar.path);
                AppMethodBeat.o(68299);
                return;
            } else if (this.mode == 6) {
                aiVar.pvG = fH(aiVar.path, aiVar.name);
            }
        }
        AppMethodBeat.o(68299);
    }

    public final String ccZ() {
        AppMethodBeat.i(68300);
        String str = "";
        for (String str2 : this.pxR.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((ai) this.pxR.get(str2)).pvH;
        }
        AppMethodBeat.o(68300);
        return str;
    }

    public final LinkedList<ai> cda() {
        AppMethodBeat.i(68301);
        LinkedList linkedList = new LinkedList();
        for (String str : this.pxR.keySet()) {
            linkedList.add(this.pxR.get(str));
        }
        AppMethodBeat.o(68301);
        return linkedList;
    }

    public final void cdb() {
        AppMethodBeat.i(68302);
        ai aiVar;
        if (this.mode == 5) {
            for (String str : this.pxR.keySet()) {
                aiVar = (ai) this.pxR.get(str);
                if (aiVar.state != 2) {
                    ac.ccC().cancel(aiVar.pvG);
                    aiVar.state = 3;
                    b(aiVar);
                }
            }
            AppMethodBeat.o(68302);
            return;
        }
        if (this.mode == 6) {
            for (String str2 : this.pxR.keySet()) {
                aiVar = (ai) this.pxR.get(str2);
                if (aiVar.state != 2) {
                    m mVar = (u) this.pxS.get(aiVar.path);
                    if (mVar != null) {
                        g.RO().eJo.c(mVar);
                        aiVar.state = 3;
                        b(aiVar);
                    }
                    this.pxT.remove(aiVar.path);
                    this.pxU.remove(aiVar.path);
                    this.pxS.remove(aiVar.path);
                }
            }
        }
        AppMethodBeat.o(68302);
    }

    /* Access modifiers changed, original: final */
    public final long Vr(final String str) {
        AppMethodBeat.i(68303);
        c cVar = new c();
        cVar.puP = false;
        cVar.puO = true;
        long a = ac.ccC().a("/cgi-bin/uploaddata", "UploadFile", str, cVar, new com.tencent.mm.plugin.qqmail.b.v.a() {
            public final boolean onReady() {
                AppMethodBeat.i(68287);
                ai aiVar = (ai) b.this.pxR.get(str);
                if (aiVar != null) {
                    aiVar.state = 1;
                    b.this.b(aiVar);
                }
                AppMethodBeat.o(68287);
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(68288);
                String str2 = (String) map.get(".Response.result.DataID");
                ai aiVar = (ai) b.this.pxR.get(str);
                if (aiVar != null) {
                    aiVar.state = 2;
                    aiVar.pvH = str2;
                    b.this.b(aiVar);
                }
                AppMethodBeat.o(68288);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.i(68289);
                ab.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", Integer.valueOf(i), str);
                ai aiVar = (ai) b.this.pxR.get(str);
                if (aiVar != null) {
                    aiVar.state = 3;
                    b.this.b(aiVar);
                }
                if (i == -5) {
                    b.this.pxP.pwy.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                        public final void ccF() {
                        }

                        public final void ccG() {
                        }
                    });
                    AppMethodBeat.o(68289);
                    return;
                }
                AppMethodBeat.o(68289);
            }

            public final void onComplete() {
                AppMethodBeat.i(68290);
                b.a(b.this);
                AppMethodBeat.o(68290);
            }
        });
        AppMethodBeat.o(68303);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final long fH(final String str, final String str2) {
        AppMethodBeat.i(68304);
        long hashCode;
        if (this.pxS.containsKey(str)) {
            hashCode = (long) ((u) this.pxS.get(str)).hashCode();
            AppMethodBeat.o(68304);
            return hashCode;
        }
        m uVar = new u(str, str, new com.tencent.mm.ai.g() {
            public final void a(int i, int i2, m mVar) {
                AppMethodBeat.i(68293);
                ab.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", Integer.valueOf(i), Integer.valueOf(i2));
                final ai aiVar;
                if (i < i2) {
                    ab.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                    aiVar = (ai) b.this.pxR.get(str);
                    if (aiVar != null) {
                        aiVar.state = 1;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(68291);
                                b.this.b(aiVar);
                                AppMethodBeat.o(68291);
                            }
                        });
                    }
                    AppMethodBeat.o(68293);
                    return;
                }
                if (i >= i2) {
                    aiVar = (ai) b.this.pxR.get(str);
                    String str = ((u) mVar).ccv().ptE;
                    b.this.pxT.put(str, str);
                    b.this.pxU.put(str, str2);
                    b.this.pxS.remove(str);
                    ab.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", str, str);
                    if (aiVar != null) {
                        aiVar.state = 2;
                        aiVar.pvH = str;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(68292);
                                b.this.b(aiVar);
                                AppMethodBeat.o(68292);
                            }
                        });
                    }
                    b.a(b.this);
                }
                AppMethodBeat.o(68293);
            }
        });
        ai aiVar = (ai) this.pxR.get(str);
        if (aiVar != null) {
            aiVar.state = 1;
        }
        b(aiVar);
        g.RO().eJo.a(uVar, 0);
        this.pxS.put(str, uVar);
        hashCode = (long) uVar.hashCode();
        AppMethodBeat.o(68304);
        return hashCode;
    }

    public final boolean cdc() {
        AppMethodBeat.i(68305);
        for (String str : this.pxR.keySet()) {
            ai aiVar = (ai) this.pxR.get(str);
            if (aiVar.state != 2 && aiVar.state != 3) {
                AppMethodBeat.o(68305);
                return false;
            }
        }
        AppMethodBeat.o(68305);
        return true;
    }

    public final void cdd() {
        AppMethodBeat.i(68306);
        if (this.pxR.size() == 0) {
            this.pwq.setText(this.pxP.getString(R.string.dd7) + " " + this.pxP.getString(R.string.dd_));
            this.pwr.setImageResource(R.raw.qqmail_attach_icon_normal);
            ((View) this.pxQ.getParent()).setVisibility(8);
        } else {
            this.pwq.setText(this.pxP.getString(R.string.dd7) + this.pxP.getResources().getQuantityString(R.plurals.y, this.pxR.size(), new Object[]{Integer.valueOf(this.pxR.size()), bo.ga((long) cde())}));
            this.pwr.setImageResource(R.raw.qqmail_attach_icon_pressed);
            ((View) this.pxQ.getParent()).setVisibility(0);
        }
        int childCount = this.pxQ.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.pxQ.getChildAt(i).setBackgroundResource(R.drawable.td);
            } else if (i == 0) {
                this.pxQ.getChildAt(i).setBackgroundResource(R.drawable.te);
            } else if (i <= 0 || i >= childCount - 1) {
                this.pxQ.getChildAt(i).setBackgroundResource(R.drawable.tg);
            } else {
                this.pxQ.getChildAt(i).setBackgroundResource(R.drawable.tf);
            }
            i++;
        }
        AppMethodBeat.o(68306);
    }

    public final int cde() {
        AppMethodBeat.i(68307);
        int i = 0;
        Iterator it = this.pxR.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                long j = (long) i2;
                i = (int) (((ai) this.pxR.get((String) it.next())).size + j);
            } else {
                AppMethodBeat.o(68307);
                return i2;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(ai aiVar) {
        AppMethodBeat.i(68308);
        LinearLayout linearLayout = (LinearLayout) this.pxQ.findViewById(Math.abs(aiVar.path.hashCode() / 2));
        if (linearLayout == null) {
            AppMethodBeat.o(68308);
            return;
        }
        a aVar = (a) linearLayout.getTag();
        switch (aiVar.state) {
            case 0:
            case 1:
                aVar.gxi.setTextColor(WebView.NIGHT_MODE_COLOR);
                aVar.pyf.setVisibility(0);
                aVar.pyg.setVisibility(8);
                aVar.pyh.setVisibility(8);
                aVar.pyi.setVisibility(0);
                AppMethodBeat.o(68308);
                return;
            case 2:
                aVar.gxi.setTextColor(WebView.NIGHT_MODE_COLOR);
                aVar.pyf.setVisibility(8);
                aVar.pyg.setVisibility(8);
                aVar.pyh.setVisibility(8);
                aVar.pyi.setVisibility(0);
                AppMethodBeat.o(68308);
                return;
            case 3:
                aVar.gxi.setTextColor(com.tencent.mm.bz.a.i(this.pxP, R.color.t4));
                aVar.pyf.setVisibility(8);
                aVar.pyg.setVisibility(0);
                aVar.pyh.setVisibility(0);
                aVar.pyi.setVisibility(0);
                break;
        }
        AppMethodBeat.o(68308);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(68309);
        if (mVar.getType() == 484) {
            mVar = (u) mVar;
            String str2 = mVar.filePath;
            final ai aiVar = (ai) this.pxR.get(str2);
            if (!(aiVar == null || (i == 0 && i2 == 0))) {
                ab.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", Integer.valueOf(i), Integer.valueOf(i2), str2);
                aiVar.state = 3;
                this.pxS.remove(str2);
                g.RO().eJo.c(mVar);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(68294);
                        b.this.b(aiVar);
                        AppMethodBeat.o(68294);
                    }
                });
            }
        }
        AppMethodBeat.o(68309);
    }
}
