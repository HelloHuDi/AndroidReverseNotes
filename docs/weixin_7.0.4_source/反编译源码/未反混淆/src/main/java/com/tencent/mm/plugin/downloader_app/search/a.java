package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;

public final class a extends android.support.v7.widget.RecyclerView.a<a> {
    ArrayList<b> iPr = new ArrayList();
    DownloadSearchListView kPj;
    Context mContext;

    public class a extends v {
        public View contentView;
        public View kPk = this.contentView.findViewById(R.id.e6u);
        public TextView kPl = ((TextView) this.contentView.findViewById(R.id.e6w));
        public View kPm;
        public TextView kPn;
        public ImageView kPo;
        public View kPp;
        public ImageView kPq;
        public Button kPr;
        public TextView kPs;
        public LinearLayout kPt;
        public TextView kPu;

        public a(View view) {
            super(view);
            AppMethodBeat.i(136166);
            this.contentView = view;
            this.kPl.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(136163);
                    DownloadSearchListView downloadSearchListView = a.this.kPj;
                    downloadSearchListView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
                    if (downloadSearchListView.kPz != null) {
                        downloadSearchListView.kPz.clear();
                    }
                    downloadSearchListView.setData(null);
                    com.tencent.mm.plugin.downloader_app.c.a.a(13, 1302, 21, 81, "", "", "");
                    AppMethodBeat.o(136163);
                }
            });
            this.kPm = this.contentView.findViewById(R.id.e6x);
            this.kPn = (TextView) this.contentView.findViewById(R.id.e70);
            this.kPo = (ImageView) this.contentView.findViewById(R.id.e6z);
            this.kPo.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(136164);
                    b bVar = (b) view.getTag();
                    DownloadSearchListView downloadSearchListView = a.this.kPj;
                    String str = bVar.kPJ;
                    if (!bo.isNullOrNil(str)) {
                        b.am(downloadSearchListView.mContext, str);
                        downloadSearchListView.kPz = b.dD(downloadSearchListView.mContext);
                        downloadSearchListView.setData(downloadSearchListView.kPz);
                    }
                    com.tencent.mm.plugin.downloader_app.c.a.a(13, 1302, bVar.position, 81, "", "", "");
                    AppMethodBeat.o(136164);
                }
            });
            this.kPp = this.contentView.findViewById(R.id.e71);
            this.kPq = (ImageView) this.contentView.findViewById(R.id.xb);
            this.kPr = (Button) this.contentView.findViewById(R.id.e72);
            this.kPr.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(136165);
                    b bVar = (b) view.getTag();
                    a.this.kPj.IN(bVar.kPJ);
                    if (a.this.mContext.getResources().getString(R.string.cm9).equals(a.this.kPr.getText().toString())) {
                        com.tencent.mm.plugin.downloader.h.a.a(a.this.mContext, bVar.appId, null);
                        com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, bVar.position, 22, bVar.appId, "", "");
                        AppMethodBeat.o(136165);
                    } else if (a.this.mContext.getResources().getString(R.string.cdv).equals(a.this.kPr.getText().toString())) {
                        com.tencent.mm.plugin.downloader.f.a In = c.In(bVar.appId);
                        if (In == null) {
                            AppMethodBeat.o(136165);
                            return;
                        }
                        if (e.ct(In.field_filePath)) {
                            com.tencent.mm.plugin.downloader.h.a.a(In.field_downloadId, false, null);
                            com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, bVar.position, 44, bVar.appId, "", "");
                        }
                        AppMethodBeat.o(136165);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("appId", bVar.appId);
                        ((d) g.K(d.class)).a(a.this.mContext, intent, null);
                        com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, bVar.position, 23, bVar.appId, "", "");
                        AppMethodBeat.o(136165);
                    }
                }
            });
            this.kPs = (TextView) this.contentView.findViewById(R.id.pc);
            this.kPt = (LinearLayout) this.contentView.findViewById(R.id.e74);
            this.kPu = (TextView) this.contentView.findViewById(R.id.e75);
            AppMethodBeat.o(136166);
        }

        static String hE(long j) {
            AppMethodBeat.i(136167);
            String format;
            if (j >= 1073741824) {
                format = String.format("%.1fGB", new Object[]{Float.valueOf(((((float) j) / 1024.0f) / 1024.0f) / 1024.0f)});
                AppMethodBeat.o(136167);
                return format;
            } else if (j >= 1048576) {
                format = String.format("%.1fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                AppMethodBeat.o(136167);
                return format;
            } else {
                format = String.format("%.2fMB", new Object[]{Float.valueOf((((float) j) / 1024.0f) / 1024.0f)});
                AppMethodBeat.o(136167);
                return format;
            }
        }
    }

    a(Context context, DownloadSearchListView downloadSearchListView) {
        AppMethodBeat.i(136168);
        this.mContext = context;
        this.kPj = downloadSearchListView;
        AppMethodBeat.o(136168);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(136169);
        int i2 = ((b) this.iPr.get(i)).type;
        AppMethodBeat.o(136169);
        return i2;
    }

    public final int getItemCount() {
        AppMethodBeat.i(136170);
        int size = this.iPr.size();
        AppMethodBeat.o(136170);
        return size;
    }
}
